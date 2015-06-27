package com.lashou.oa.cms.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("CmsIndexController")
@RequestMapping("/cms")
public class IndexController {
	
	private static Logger log = LoggerFactory.getLogger(IndexController.class);
	public IndexController() {}
	
	@ResponseBody
	@RequestMapping({"/", "/index"})
	public String index(HttpServletRequest request) {
		log.trace("trace test");
		log.debug("test debug");
		log.info("cms info test");
		log.warn("cms warning test");
		log.error("cms  error test");
		return "cms, hello world";
	}
}