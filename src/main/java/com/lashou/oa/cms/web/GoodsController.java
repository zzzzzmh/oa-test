package com.lashou.oa.cms.web;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import javax.validation.Valid;

import junit.framework.Test;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lashou.oa.cms.domain.Goods;
import com.lashou.oa.cms.domain.GoodsDescripton;
//import com.lashou.oa.cms.domain.GoodsValidator;
import com.lashou.oa.cms.manager.GoodsManager;


@Controller
@RequestMapping("/cms/goods")
public class GoodsController {
	
	@Resource
	private GoodsManager goodsManager;
	
	@Resource
	MessageSource messageSource;
	
	@Resource
	private SessionFactory sessionFactory;
	
	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView mnv =  new ModelAndView("cms/goods_add");
		return mnv;
	}
	
	@RequestMapping(value="/addsub", method=RequestMethod.POST)
	@ResponseBody
	public String addsub(@Valid @ModelAttribute("goods") Goods goods, BindingResult result, 
			@ModelAttribute("goodsDescripton") GoodsDescripton goodsDescripton, BindingResult result2) {
		 if(result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for(FieldError err : errors) {
                /*
            	System.out.println("ObjectName:" + err.getObjectName() + "\tFieldName:" + err.getField()
                		+ "\tFieldValue:" + err.getRejectedValue() + "\tMessage:" + err.getCodes());
                System.out.println(err.getCode());
                System.out.println(err.getCodes());
                */
            	
                String[] arr = err.getCodes();
                System.out.println(err.getDefaultMessage());
                //System.out.println(messageSource.getMessage(err.getDefaultMessage(), null, null));
                /*
                for(int i=0;i<arr.length;i++) {
                	System.out.println(arr[i]);
                	//System.out.println(messageSource.getMessage(arr[i], null, null));
                }
                */
            }
            
            System.out.println(goods.toString());
            //return "hehehe,这么二心";
            //return new String[]{"hello", "", "world"};
            
            return "cms/testPropertyEditor";
            //return result.toString();
	     }
		 
		
		
		return goods.toString();
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String Test(@RequestBody String str) {
		return str;
	}
	
	
	@RequestMapping("/success")
	@ResponseBody
	public String success() {
		return "success";
	}
	
	/*
	@InitBinder  
    public void initBinder(DataBinder binder) {  
       binder.setValidator(new GoodsValidator());  
    }
    */
	
}