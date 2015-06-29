package com.lashou.oa.cms.domain;

import org.hsqldb.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GoodsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Goods.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		/*
		private String title;
		private String product;
		private BigDecimal price;
		private BigDecimal costPrice;
		private Integer spId;
		private Date addTime;
		*/
		
		ValidationUtils.rejectIfEmpty(errors, "title", null, "title si empty.");
		Goods goods = (Goods) target;
		if(null == goods.getTitle() || "".equalsIgnoreCase(goods.getTitle())) {
			errors.rejectValue("title", null, "title is empty");
		}
		
		
	}
	
}
