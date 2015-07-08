package com.lashou.oa.cms.web;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class SchoolInfoModel {

	private String schoolName;
	private String schoolAddress;
	public String getSchoolName() {
		return schoolName;
	}
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this); 
	}
}
