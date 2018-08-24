package com.yjclsx.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yjc
 * 2017年4月14日
 */
@Component
public class DataRepositoryInterceptor implements HandlerInterceptor {
	
	@Autowired
	private HttpSession httpSession;
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		Object enable = httpSession.getAttribute("enable");
		if(enable!=null && (boolean)enable){
			return true;
		}
		httpSession.setAttribute("back_url", arg0.getRequestURL().toString()+"?"+arg0.getQueryString());
		arg1.sendRedirect("/login");
		return false;
	}

}
