package com.newlecture.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/*")
public class Membercontroller {
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login() {
		return "member.login";
	}
	
}
