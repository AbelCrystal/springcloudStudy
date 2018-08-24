package com.yjclsx;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yjclsx.util.DateUtils;

@Controller
public class IndexController {
	
	private static Map<String,String> map = new HashMap<String, String>();
	
	static{
    	map.put("yjc1", "yjc1");
    	map.put("yjc2", "yjc2");
    }
	
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping("/index")
	public String index(){
		System.out.println(httpSession.getId());
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginGet(){
		return "login";
	}
	
	/**
	 * 登录
	 * @param request
	 * @param response
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginPost(HttpServletRequest request,HttpServletResponse response,String username,String password){
		if(map.get(username)!=null && map.get(username).equals(password)){
			httpSession.setAttribute("login_user", username);
			httpSession.setAttribute("login_time", DateUtils.parseDateStr(new Date(), DateUtils.format_YYYYMMDDHHmmSS));
			httpSession.setAttribute("enable", true);
			try {
				if(httpSession.getAttribute("back_url")!=null){
					response.sendRedirect((String)httpSession.getAttribute("back_url"));
				}else{
					response.sendRedirect("/index");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "login";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpServletRequest request,HttpServletResponse response){
		httpSession.invalidate();
		try {
			response.sendRedirect("/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
