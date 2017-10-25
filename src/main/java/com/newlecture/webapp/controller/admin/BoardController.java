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
	
	//service를 사용할때
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
//------------------------------------------> 공지 수정 <-------------------------------------------------------------	
	@RequestMapping(value="notice/edit",method=RequestMethod.GET)
	public String noticeEdit(@PathVariable("id") String id, Model model) {
		
		return "admin.board.notice.edit";
	}
	
	@RequestMapping(value="notice/detail",method=RequestMethod.POST)
	public String noticeEdit() {
		
		return "redirect:../notice/${id}";
	}
//-------------------------------------------> 공지 등록 <--------------------------------------------------------------------		
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
			
			//1011파일 경로 설정
			ServletContext ctx = request.getServletContext();
			String path = ctx.getRealPath(String.format("/resource/customer/notice/%d/%s", year,nextId));			
			System.out.println("path : "+path);			
			File f = new File(path);			
			if(!f.exists()) {
				if(!f.mkdirs())
					System.out.println("디렉토리를 생성할 수가 없습니다.");
			}	
			path +=File.separator+file.getOriginalFilename();
			File f2 = new File(path); //빈파일 만들어진 것
			System.out.println("path2 : "+path);
			InputStream fis = file.getInputStream();	//읽기
			OutputStream fos = new FileOutputStream(f2); //기록			
			byte[] buf = new byte[1024];		
			int size =0;
			while((size=fis.read(buf))>0)
				fos.write(buf, 0, size);
			fos.close();
			fis.close();	
			notice.setWriterId("sds");
			service.insert(new NoticeFile(null,fileName, nextId));	//notice파일 등록sql
		}
		return "redirect:../notice";
	}
	
	
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------	service를 사용하지 않을때 10.24이전------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	/*	Service를 사용할때는 주석처리 10.24
	 * Board Service로 옮겨줌 
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
		//return aaid+"번째 공지사항-title:"+ noticeView.getTitle();
		return "admin.board.notice.detail";
	}
//------------------------------------------> 공지 수정 <-------------------------------------------------------------	
	@RequestMapping(value="notice/edit",method=RequestMethod.GET)
	public String noticeEdit(@PathVariable("id") String id, Model model) {
		
		return "admin.board.notice.edit";
	}
	
	@RequestMapping(value="notice/detail",method=RequestMethod.POST)
	public String noticeEdit() {
		
		return "redirect:../notice/${id}";
	}
//-------------------------------------------> 공지 등록 <--------------------------------------------------------------------		
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
			Principal principal) throws IOException { //Principal : 사용자에 대한 정보를 가져옴.
			String fileName = file.getOriginalFilename(); 
		if(fileName == null || fileName.equals("")) {
			notice.setWriterId("sds");
			System.out.println("title : " + notice.getTitle());
			//int row = noticeDao.insert(title, content,writerId);
			
			//업무명  - transaction
			int row = noticeDao.insert(notice);								//notice등록 -> 분리된 connection -> transaction을 포기하거나 dao를 버리거나....->둘다 사용하려면??EJD
			memberDao.pointUp(principal.getName());
		}
		else {
			//1011날짜 설정
			//날짜를 얻는 방법 1)
			Date curDate = new Date();
			//curDate.getYear(); //사라지고 있는 방법
			//날짜를 얻는 방법 2)분쇄?? 선택
			Calendar cal = Calendar.getInstance();
			Date curDate2 = cal.getTime();
			int year = cal.get(Calendar.YEAR);
			//날짜를 얻는 방법 3)문자열을 바꿔서 쓰고 싶을때
			//SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy");
			String year = fmt.format(curDate);
			
			String nextId = noticeDao.getNextId();
			
			//1011파일 경로 설정
			ServletContext ctx = request.getServletContext();
			String path = ctx.getRealPath(String.format("/resource/customer/notice/%d/%s", year,nextId));
										//"/resource/customer/notice/"+year+"/"+nextId); //연도수안에 게시글 번호를 넣고 싷펑
			
			System.out.println("path : "+path);
			
			File f = new File(path);	//실제파일을 저장하기 위한 파일 객체 , 경로는 파일을 등록하기 위한 준비사항
			
			if(!f.exists()) {
				if(!f.mkdirs())
					System.out.println("디렉토리를 생성할 수가 없습니다.");
			}
			//1012 파일 경로에 파일명도 추가		
			path +=File.separator+file.getOriginalFilename();//앞 path는 \이지만 여기path는 /.. 각 운영체제마다규칙이 다름. 이것을 통용하게 해주는 것
			File f2 = new File(path); //빈파일 만들어진 것
			System.out.println("path2 : "+path);
			InputStream fis = file.getInputStream();	//읽기
			OutputStream fos = new FileOutputStream(f2); //기록			
			byte[] buf = new byte[1024];		
			int size =0;
			while((size=fis.read(buf))>0)
				fos.write(buf, 0, size);
			fos.close();
			fis.close();	
			//--------------------한글 설정--------------------------
			//파라미터데이터를 가져오기 전에 request(utf8)을 할수 없다. 대안1 filter(was안 오브젝트 서블ㄹ릿,필터,리스너 지금까지 서블릿에대해 알앗으나 지금부터는 필터에 대ㅐㅎ 알아보자
			// 대안1) // title = new String(title.getBytes("ISO-8859-1"),"UTF-8");
			// 대안2) 필터	
			//---------------file설정------------------------
			//file.getInputStream(); //resource안에 넣어야 공개 파일이 됨. 밖에 넣을 경우 비공개 파일.
			//String fileName = file.getOriginalFilename(); //파일 이름 확인
			System.out.println("filename : "+fileName);
			notice.setWriterId("sds");
			System.out.println("title : " + notice.getTitle());
			//int row = noticeDao.insert(title, content,writerId);
			int row = noticeDao.insert(notice);								//notice등록 -> 분리된 connection -> transaction을 포기하거나 dao를 버리거나....->둘다 사용하려면??EJD
			memberDao.pointUp(principal.getName());
			noticeFileDao.insert(new NoticeFile(null,fileName, nextId));	//notice파일 등록sql
		}
		return "redirect:../notice";
	}*/
	
}
