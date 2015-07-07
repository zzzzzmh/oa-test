package com.lashou.oa.cms.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;


/*
public class TestController extends AbstractController{
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PrintWriter writer = response.getWriter();
		writer.write("test AbstractController !!! hahaha");
		return null;
	}
}
*/

@SuppressWarnings("deprecation")
public class TestController extends AbstractCommandController {

	public TestController() {
		setCommandClass(UserModel.class);
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		UserModel user = (UserModel) command;
		PrintWriter writer = response.getWriter();
		writer.write(user.toString());
		writer.write("bind success");
		return null;
	}
}


class UserModel {
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		return username + "---" + password;
	}
}