package com.newlecture.webapp.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.webapp.dao.MemberDao;
import com.newlecture.webapp.dao.NoticeDao;
import com.newlecture.webapp.dao.NoticeFileDao;
import com.newlecture.webapp.entity.Notice;
import com.newlecture.webapp.entity.NoticeFile;
import com.newlecture.webapp.service.admin.BoardService;

@Controller
@RequestMapping("admin/board/*")
public class BoardController {
	

	@Autowired
	private BoardService service;//10.24
	
	//service�� ����Ҷ�
	@RequestMapping("notice")
	public String notice(@RequestParam(value="p", defaultValue="1")Integer page, 
			@RequestParam(value="f",defaultValue="title") String field,
						@RequestParam(value="q",defaultValue="") String query,
						Model model){
		model.addAttribute("list", service.getNoticeList());	
		//model.addAttribute("list", service.getNoticeList(page, field, query));	
		return "admin.board.notice.list";
	}
	
	@RequestMapping("notice/{id}")
	public String noticeDetail(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("n",service.getNotice(id));
		model.addAttribute("prev",service.getNoticePrev(id));
		model.addAttribute("next",service.getNoticeNext(id));
		return "admin.board.notice.detail";
	}
//------------------------------------------> ���� ���� <-------------------------------------------------------------	
	@RequestMapping(value="notice/edit",method=RequestMethod.GET)
	public String noticeEdit(@PathVariable("id") String id, Model model) {
		
		return "admin.board.notice.edit";
	}
	
	@RequestMapping(value="notice/detail",method=RequestMethod.POST)
	public String noticeEdit() {
		
		return "redirect:../notice/${id}";
	}
//-------------------------------------------> ���� ��� <--------------------------------------------------------------------		
	@RequestMapping(value="notice/reg",method=RequestMethod.GET)
	public String noticeReg() {
		return "admin.board.notice.reg";
	}

	@RequestMapping(value="notice/reg", method=RequestMethod.POST)
	public String noticeReg(
			Notice notice,
			String aa,
			MultipartFile file, 
			HttpServletRequest request,
			Principal principal) throws IOException {
			String fileName = file.getOriginalFilename(); 
		if(fileName == null || fileName.equals("")) {
			notice.setWriterId("sds");
			System.out.println("title : " + notice.getTitle());
			int row = service.insertAndPointUp(notice);
		}
		else {		
			Date curDate = new Date();
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy");
			String year = fmt.format(curDate);
			
			String nextId = service.getNextId();
			
			//1011���� ��� ����
			ServletContext ctx = request.getServletContext();
			String path = ctx.getRealPath(String.format("/resource/customer/notice/%d/%s", year,nextId));			
			System.out.println("path : "+path);			
			File f = new File(path);			
			if(!f.exists()) {
				if(!f.mkdirs())
					System.out.println("���丮�� ������ ���� �����ϴ�.");
			}	
			path +=File.separator+file.getOriginalFilename();
			File f2 = new File(path); //������ ������� ��
			System.out.println("path2 : "+path);
			InputStream fis = file.getInputStream();	//�б�
			OutputStream fos = new FileOutputStream(f2); //���			
			byte[] buf = new byte[1024];		
			int size =0;
			while((size=fis.read(buf))>0)
				fos.write(buf, 0, size);
			fos.close();
			fis.close();	
			notice.setWriterId("sds");
			service.insert(new NoticeFile(null,fileName, nextId));	//notice���� ���sql
		}
		return "redirect:../notice";
	}
	
	
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------	service�� ������� ������ 10.24����------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	/*	Service�� ����Ҷ��� �ּ�ó�� 10.24
	 * Board Service�� �Ű��� 
	 * @Autowired
		private NoticeDao noticeDao;
		@Autowired
		private NoticeFileDao noticeFileDao;
		@Autowired
		private MemberDao memberDao;*/
/*
 * @RequestMapping("notice")
	public String notice(@RequestParam(value="p", defaultValue="1")Integer page, 
			@RequestParam(value="f",defaultValue="title") String field,
						@RequestParam(value="q",defaultValue="") String query,
						Model model){
		model.addAttribute("list", noticeDao.getList(page, field, query));	
		return "admin.board.notice.list";
	}
	
	@RequestMapping("notice/{id}")
	public String noticeDetail(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("n",noticeDao.get(id));
		model.addAttribute("prev",noticeDao.getPrev(id));
		model.addAttribute("next",noticeDao.getNext(id));
		//return aaid+"��° ��������-title:"+ noticeView.getTitle();
		return "admin.board.notice.detail";
	}
//------------------------------------------> ���� ���� <-------------------------------------------------------------	
	@RequestMapping(value="notice/edit",method=RequestMethod.GET)
	public String noticeEdit(@PathVariable("id") String id, Model model) {
		
		return "admin.board.notice.edit";
	}
	
	@RequestMapping(value="notice/detail",method=RequestMethod.POST)
	public String noticeEdit() {
		
		return "redirect:../notice/${id}";
	}
//-------------------------------------------> ���� ��� <--------------------------------------------------------------------		
	@RequestMapping(value="notice/reg",method=RequestMethod.GET)
	public String noticeReg() {
		return "admin.board.notice.reg";
	}

	@RequestMapping(value="notice/reg", method=RequestMethod.POST)
	//public String noticeReg(String title, String content) throws UnsupportedEncodingException {
	public String noticeReg(
			Notice notice,
			String aa,
			MultipartFile file, 
			HttpServletRequest request,
			Principal principal) throws IOException { //Principal : ����ڿ� ���� ������ ������.
			String fileName = file.getOriginalFilename(); 
		if(fileName == null || fileName.equals("")) {
			notice.setWriterId("sds");
			System.out.println("title : " + notice.getTitle());
			//int row = noticeDao.insert(title, content,writerId);
			
			//������  - transaction
			int row = noticeDao.insert(notice);								//notice��� -> �и��� connection -> transaction�� �����ϰų� dao�� �����ų�....->�Ѵ� ����Ϸ���??EJD
			memberDao.pointUp(principal.getName());
		}
		else {
			//1011��¥ ����
			//��¥�� ��� ��� 1)
			Date curDate = new Date();
			//curDate.getYear(); //������� �ִ� ���
			//��¥�� ��� ��� 2)�м�?? ����
			Calendar cal = Calendar.getInstance();
			Date curDate2 = cal.getTime();
			int year = cal.get(Calendar.YEAR);
			//��¥�� ��� ��� 3)���ڿ��� �ٲ㼭 ���� ������
			//SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy");
			String year = fmt.format(curDate);
			
			String nextId = noticeDao.getNextId();
			
			//1011���� ��� ����
			ServletContext ctx = request.getServletContext();
			String path = ctx.getRealPath(String.format("/resource/customer/notice/%d/%s", year,nextId));
										//"/resource/customer/notice/"+year+"/"+nextId); //�������ȿ� �Խñ� ��ȣ�� �ְ� ����
			
			System.out.println("path : "+path);
			
			File f = new File(path);	//���������� �����ϱ� ���� ���� ��ü , ��δ� ������ ����ϱ� ���� �غ����
			
			if(!f.exists()) {
				if(!f.mkdirs())
					System.out.println("���丮�� ������ ���� �����ϴ�.");
			}
			//1012 ���� ��ο� ���ϸ� �߰�		
			path +=File.separator+file.getOriginalFilename();//�� path�� \������ ����path�� /.. �� �ü�����ٱ�Ģ�� �ٸ�. �̰��� ����ϰ� ���ִ� ��
			File f2 = new File(path); //������ ������� ��
			System.out.println("path2 : "+path);
			InputStream fis = file.getInputStream();	//�б�
			OutputStream fos = new FileOutputStream(f2); //���			
			byte[] buf = new byte[1024];		
			int size =0;
			while((size=fis.read(buf))>0)
				fos.write(buf, 0, size);
			fos.close();
			fis.close();	
			//--------------------�ѱ� ����--------------------------
			//�Ķ���͵����͸� �������� ���� request(utf8)�� �Ҽ� ����. ���1 filter(was�� ������Ʈ ������,����,������ ���ݱ��� ���������� �˾����� ���ݺ��ʹ� ���Ϳ� ����� �˾ƺ���
			// ���1) // title = new String(title.getBytes("ISO-8859-1"),"UTF-8");
			// ���2) ����	
			//---------------file����------------------------
			//file.getInputStream(); //resource�ȿ� �־�� ���� ������ ��. �ۿ� ���� ��� ����� ����.
			//String fileName = file.getOriginalFilename(); //���� �̸� Ȯ��
			System.out.println("filename : "+fileName);
			notice.setWriterId("sds");
			System.out.println("title : " + notice.getTitle());
			//int row = noticeDao.insert(title, content,writerId);
			int row = noticeDao.insert(notice);								//notice��� -> �и��� connection -> transaction�� �����ϰų� dao�� �����ų�....->�Ѵ� ����Ϸ���??EJD
			memberDao.pointUp(principal.getName());
			noticeFileDao.insert(new NoticeFile(null,fileName, nextId));	//notice���� ���sql
		}
		return "redirect:../notice";
	}*/
	
}
