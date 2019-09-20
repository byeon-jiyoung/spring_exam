package com.yi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("LoginInterceptor preHandler");
//		return super.preHandle(request, response, handler);
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
																									//modelAndView => 이건 해당 jsp가 반드시 필요하다. 적을게 없어도 무조건 jsp가 있어야됨
//		super.postHandle(request, response, handler, modelAndView);
		logger.info("LoginInterceptor postHandler");
		
		HttpSession session = request.getSession();
		
		Object loginDTO = modelAndView.getModel().get("loginDTO");
		
		if(loginDTO != null) {
			session.setAttribute("Auth", loginDTO);
			
			Object dest = session.getAttribute("dest");
			String path = (dest != null) ? (String) dest : request.getContextPath();
			
//			response.sendRedirect(request.getContextPath()); //home으로 이동하라
//										//프로젝트이름반환
			response.sendRedirect(path);
		}else { //로그인 실패했을때
			session.setAttribute("error", "notMatch");
			response.sendRedirect(request.getContextPath() + "/login/login");
		}
	}
	
}
