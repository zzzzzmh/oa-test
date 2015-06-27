package com.lashou.oa.account.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class LoginController {
	
	@RequestMapping("/login")
	public String Login() {
		return "account/login";
	}
	
}
