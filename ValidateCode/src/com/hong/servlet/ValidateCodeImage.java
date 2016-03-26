package com.hong.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.dsna.util.images.ValidateCode;

public class ValidateCodeImage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session  = request.getSession();
		//获取验证码工具类
		ValidateCode validateCode = new ValidateCode(300, 200, 4, 20);	
		//得到验证码图片
		BufferedImage bi = validateCode.getBuffImg();
		//得到验证码字符串
		String captcha = validateCode.getCode();
		//把验证码字符串放入到session里保存
		session.setAttribute("captcha", captcha);
		//通过ImageIO流输出验证码图片
		ImageIO.write(bi, "jpeg", response.getOutputStream());
		///
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
