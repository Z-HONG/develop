package com.hong.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ValidateCodeDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session  = request.getSession();
		String fcaptcha = request.getParameter("captcha");
		String scaptcha = (String) session.getAttribute("captcha");
		session.removeAttribute("captcha");
		if(scaptcha != null ){
			if(scaptcha.equalsIgnoreCase(fcaptcha)){
				response.getWriter().write("true");
				return ;
			}
			//
		}
		response.getWriter().write("false");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
