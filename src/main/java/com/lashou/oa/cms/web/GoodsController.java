package com.lashou.oa.cms.web;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lashou.oa.cms.domain.Goods;
import com.lashou.oa.cms.domain.GoodsDescripton;
import com.lashou.oa.cms.domain.Tags;
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
	
	@RequestMapping(value="/addSubmit", method=RequestMethod.POST)
	@ResponseBody
	public String addSubmit(@ModelAttribute("tags") String tagsStr, @Valid @ModelAttribute("goods") Goods goods, BindingResult result,
			@ModelAttribute("goodsDesc") GoodsDescripton goodsDesc) {
	
		if(result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
            for(FieldError err : errors) {
            	System.out.println(err.getField() +" : "+ err.getDefaultMessage());
            }
			return "cms/goods_add";
		}
		
//		System.out.println(goods.toString());
//		System.out.println(goodsDesc.toString());
		
		Set<Tags> s = new HashSet<Tags>();
		String[] tags = tagsStr.split(" ");
		for (int i = 0; i < tags.length; i++) {
			s.add(new Tags(tags[i],goods));
		}
		
		goods.setTags(s);
		goods.setDesc(goodsDesc);
//		goodsDesc.setGoods(goods);
		Session session = sessionFactory.openSession();
		Transaction transaction = null;  
	    try {
	    	
//	    	transaction = session.beginTransaction();  
//	        transaction.begin(); 
//	        session.save(goods);
//	        transaction.commit();
	        
	        transaction = session.beginTransaction();  
	        transaction.begin(); 
	        session.save(goods);
	        goodsDesc.setGoods(goods);
	        goods.setDesc(goodsDesc);
	        session.save(goodsDesc);
	        transaction.commit();
	    	
	    } catch (RuntimeException e) {  
	    	if(transaction != null) {  
	            transaction.rollback();  
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    System.out.println(goods.getGoodsId());
		return "redirect:/cms/goods/success";
	}
	
	/*
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
                * /
            	
                String[] arr = err.getCodes();
                System.out.println(err.getDefaultMessage());
                //System.out.println(messageSource.getMessage(err.getDefaultMessage(), null, null));
                /*
                for(int i=0;i<arr.length;i++) {
                	System.out.println(arr[i]);
                	//System.out.println(messageSource.getMessage(arr[i], null, null));
                }
                *  /
            }
            
            System.out.println(goods.toString());
            //return "hehehe,这么二心";
            //return new String[]{"hello", "", "world"};
            
            return "cms/testPropertyEditor";
            //return result.toString();
	     }
		
		return goods.toString();
	}
	 */ 
	
	@RequestMapping("/test")
	@ResponseBody
	public String Test(@RequestBody String str) {
		return str;
	}
	
	
	@RequestMapping("/success")
	@ResponseBody
	public String success() {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = null;  
	    try {
	        transaction = session.beginTransaction();  
	        transaction.begin(); 
	        Goods goods = (Goods) session.load(Goods.class, 8);
	        System.out.println(goods);
	        System.out.println(goods.getDesc().getDescription());
	        transaction.commit();
	    } catch (RuntimeException e) {  
	    	if(transaction != null) {  
	            transaction.rollback();  
	        }
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    
		return "success";
	}
	
	/*
	@InitBinder  
    public void initBinder(DataBinder binder) {  
       binder.setValidator(new GoodsValidator());  
    }
    CREATE TABLE `goods_tags` (
	  `goods_id` int(11) NOT NULL,
	  `tag_id` int(11) NOT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=utf8
	
	CREATE TABLE `think_tags` (
	  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
	  `tag` varchar(50) NOT NULL,
	  PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8
	
    */
	
}