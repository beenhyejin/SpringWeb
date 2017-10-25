package com.newlecture.webapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/*")
public class HomeController {
	@RequestMapping("index")
	public String index() {
		//return "/WEB-INF/views/index.jsp";
		return "home.index";
	}
	
	@RequestMapping("file-list")
	@ResponseBody
	public String fileList(HttpServletRequest request) {
		ServletContext ctx = request.getServletContext();
		String path = ctx.getRealPath("/resource/upload");
		
		StringBuilder json = new StringBuilder();
		json.append("[");
		
		File folder = new File(path);//파일일수도 있고 디렉토리 일수도 있음.
		if(folder.isDirectory())
		{
			File[] files = folder.listFiles();
			for(int i=0; i<files.length; i++) {
				json.append(String.format("\"%s\"",files[i].getName()));
				if(i+1<files.length)
					json.append(",");
			}
		}
		json.append("]");
		return json.toString();
	}

	@RequestMapping("upload")
	@ResponseBody
	public String upload(String title, MultipartFile file, HttpServletRequest request) throws IOException {
		System.out.println(title);
		System.out.println(file.getOriginalFilename());

		ServletContext ctx = request.getServletContext();
		String path = ctx.getRealPath("/resource/upload");
		path += File.separator + file.getOriginalFilename();
		File f2 = new File(path);
		System.out.println("path:"+path);

		InputStream fis = file.getInputStream();
		OutputStream fos = new FileOutputStream(f2);

		byte[] buf = new byte[1024];
		int size = 0;
		while ((size = fis.read(buf)) > 0)
			fos.write(buf, 0, size);
		fis.close();
		fos.close();
		return title;
	}
	
	
}
