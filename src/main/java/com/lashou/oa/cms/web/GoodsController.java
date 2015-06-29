package com.lashou.oa.cms.web;

import javax.annotation.Resource;

import org.hibernate.validator.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lashou.oa.cms.domain.Goods;
import com.lashou.oa.cms.domain.GoodsValidator;
import com.lashou.oa.cms.manager.GoodsManager;

@Controller
@RequestMapping("/cms/goods")
public class GoodsController {
	
	@Resource
	private GoodsManager goodsManager;
	
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView mnv =  new ModelAndView("cms/goods_add");
		return mnv;
	}
	
	@RequestMapping(value="/addsub", method=RequestMethod.POST)
	public String addsub(@Valid Goods goods, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:cms/goods/add";
		}
		return "cms/goods/success";
	}
	
	
	@InitBinder  
    public void initBinder(DataBinder binder) {  
       binder.setValidator(new GoodsValidator());  
    }
	
   /*
    @RequestMapping("login")  
    public String login(@Valid User user, BindingResult result) {  
       if (result.hasErrors())  
           return "redirect:user/login";  
       return "redirect:/";  
    }  
    */
}