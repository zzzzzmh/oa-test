package com.lashou.oa.home.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class IndexController {
	
	private static Logger log = LoggerFactory.getLogger(IndexController.class);
	
	public IndexController() {}
	
	//@ResponseBody
	@RequestMapping({"/", "/home"})
	public String index(HttpServletRequest request) {
		
		log.debug("test debug");
		log.error("error test");
		log.info("home info test");
		log.trace("home trace test");
		log.warn("home warning test");
		return "home/index";
	}
}
