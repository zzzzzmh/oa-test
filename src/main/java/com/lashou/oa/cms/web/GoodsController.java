package com.lashou.oa.cms.web;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lashou.oa.cms.domain.Goods;

@Controller
@RequestMapping("/cms/goods")
public class GoodsController {
	
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView mnv =  new ModelAndView("cms/goods_add");
		return mnv;
	}
	
	@RequestMapping(value="/addsub", method=RequestMethod.POST)
	public void addsub(@Validated @ModelAttribute("user") Goods goods, BindingResult bindingResult) {
		//System.out.println(goods);
		//return "";
		System.out.println(goods.getTitle());
	}
	
}
