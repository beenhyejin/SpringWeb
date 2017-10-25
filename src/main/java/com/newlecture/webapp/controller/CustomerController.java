package com.newlecture.webapp.controller;

import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.newlecture.webapp.dao.NoticeDao;

import com.newlecture.webapp.entity.NoticeView;


@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	
	//customer에 필요한 dao를 적절하게 가져다 사용
	@Autowired
	private NoticeDao noticeDao;
	

	@RequestMapping("notice-ajax")
	@ResponseBody
	public String noticeAjax(
			@RequestParam(value="p", defaultValue="1")Integer page, 
			@RequestParam(value="f",defaultValue="title") String field,
			@RequestParam(value="q",defaultValue="") String query,
			Model model){
		//model.addAttribute("list", noticeDao.getList(page, field, query));	
		List<NoticeView> list = noticeDao.getList(page, field, query);
		String json = "";
		
		Gson gson = new Gson();
		json = gson.toJson(list);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	/*	StringBuilder builder = new StringBuilder(); //StringBuilder : 문자열의 저장 및 변경을 위한 메모리 공간 가짐, 변경가능한 문자열
		builder.append("[");
		builder.append("{},");
		builder.append("{}");
		builder.append("]");
		json = builder.toString();
		System.out.println("json : "+json);
*/		
		//String output = String.format("p:%s, q:%s",page,query);
		//output += String.format("->title:%s \n",list.get(0).getTitle());
		//return "customer.notice.list";
		return json;//자바스크립트에서 요청하여 값을 가져와야함.
	}
	
	   @RequestMapping("notice")
	   public String notice(@RequestParam(value="p", defaultValue="1") Integer page, 
	         @RequestParam(value="f", defaultValue="title") String field,
	         @RequestParam(value="q", defaultValue="") String query,
	         Model model) {
	      
	      
	      model.addAttribute("list", noticeDao.getList(page, field, query));
	      model.addAttribute("count", noticeDao.getCount());
	      /*String output = String.format("p:%s, q:%s", page, query);
	      	output += String.format("title : %s\n", list.get(0).getTitle());
	      */
	      //return "customer/notice";
	      return "customer.notice.list";
	   }
	
	//@ResponseBody
	@RequestMapping("notice/{id}")
	public String noticeDetail(@PathVariable("id") String id, Model model) {
		
		model.addAttribute("n",noticeDao.get(id));
		//model.addAttribute("prev",noticeDao.getPrev(id));
		//model.addAttribute("next",noticeDao.getNext(id));
		//return aaid+"번째 공지사항-title:"+ noticeView.getTitle();
		return "customer.notice.detail";
	}
}
