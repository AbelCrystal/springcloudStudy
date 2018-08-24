package com.yjclsx;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
	
	@Autowired
	private HttpSession httpSession;

	@RequestMapping("/index")
	public String index(){
		System.out.println(httpSession.getId());
		return "index";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		return "success2";
	}
	
}
