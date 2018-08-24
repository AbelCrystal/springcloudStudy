package com.yjclsx.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AccessFilter extends ZuulFilter {
	
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
    	RequestContext ctx = RequestContext.getCurrentContext() ;
        HttpServletRequest request = ctx.getRequest();
    	if(request.getRequestURL().toString().contains("/login")){
    		return false;
    	}
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpSession httpSession = request.getSession();
        Object enable = httpSession.getAttribute("enable");
		if(enable!=null && (boolean)enable){
			//可以在request头信息中添加数据，请求转发到后续服务后可以从request头信息中获取
			ctx.addZuulRequestHeader("userName", httpSession.getAttribute("login_user").toString());
			return true;
		}
		httpSession.setAttribute("back_url", request.getRequestURL().toString()+"?"+request.getQueryString());
		try {
			ctx.setSendZuulResponse(false);
			ctx.getResponse().sendRedirect("/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
    }
}
