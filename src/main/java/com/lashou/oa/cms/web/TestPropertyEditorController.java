package com.lashou.oa.cms.web;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.SessionFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;


@SuppressWarnings("deprecation")
public class TestPropertyEditorController extends AbstractCommandController {
	
	@Resource
	MessageSource messageSource;
	
	@Resource
	private SessionFactory sessionFactory;
	
	public TestPropertyEditorController() {
		setCommandClass(DataBinderTestModel.class);
		setCommandName("dataBindTest");
	}
	
	@Override
    protected void initBinder(HttpServletRequest request, 
			ServletRequestDataBinder binder) throws Exception {
		super.initBinder(request, binder);
		//表示如果命令对象有Date类型的属性，将使用该属性编辑器进行类型转换  
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor dateEditor = new CustomDateEditor(df, true);
		binder.registerCustomEditor(Date.class, dateEditor);
		//自定义的电话号码编辑器
		binder.registerCustomEditor(PhoneNumberModel.class, new PhoneNumberEditor());      
		//enum
		//binder.registerCustomEditor(UserState.class, new UserStateEnumEditor());
		
	};
	
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		
		//数据绑定失败 和 数据不合法
		/*
		1、首先进行数据绑定验证，如果验证失败会通过MessageCodesResolver生成错误码放入Errors错误对象；
		2、数据不合法验证，通过自定义的验证器验证，如果失败需要手动将错误码放入Errors错误对象；
		*/
		DataBinderTestModel dataBind = (DataBinderTestModel) command;
		
		//errors.reject("username.not.empty");
		//errors.reject("username.length.error", new Object[]{5, 10}, "");
		Map model = errors.getModel();
		
		System.out.println(model);
		return new ModelAndView("cms/testPropertyEditor", model);
		
		
		
		//response.setContentType("text/html");
		//PrintWriter writer = response.getWriter();
		//writer.write(request.getParameter("date"));
		//writer.write(dataBind.getDate().toString());
		//writer.write(dataBind.getState().ordinal());
		//System.out.println(dataBind);
		//writer.write("<br/>");
		//writer.write(dataBind.toString());
		//writer.write("bind success");
	}
}

class UserStateEnumEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		boolean found = false;
		for(UserState u:UserState.values()) {
			System.out.println(u.name());
			System.out.println(u.ordinal());
			if(text.equals(u.name())) {
				setValue(u);
				found = true;
				break;
			}
		}
		if(found == false) {
			setValue(UserState.jiangxi);
		}
	}
}

class PhoneNumberEditor extends PropertyEditorSupport {  
    Pattern pattern = Pattern.compile("^(\\d{3,4})-(\\d{7,8})$");
    
    @Override  
    public void setAsText(String text) throws IllegalArgumentException {  
        if(text == null || StringUtils.isEmpty(text)) {  
            setValue(null); //如果没值，设值为null  
        }
        Matcher matcher = pattern.matcher(text);  
        if(matcher.matches()) {  
            PhoneNumberModel phoneNumber = new PhoneNumberModel();  
            phoneNumber.setAreaCode(matcher.group(1));  
            phoneNumber.setPhoneNumber(matcher.group(2));  
            setValue(phoneNumber);  
        } else {  
            throw new IllegalArgumentException(String.format("类型转换失败，需要格式[010-12345678]，但格式是[%s]", text));  
        }  
    }  
    @Override  
    public String getAsText() {  
        PhoneNumberModel phoneNumber = ((PhoneNumberModel)getValue());  
        return phoneNumber == null ? "" : phoneNumber.getAreaCode() + "-" + phoneNumber.getPhoneNumber();  
    }  
}

class DataBinderTestModel {  
    private String username;  
    private boolean bool;						//Boolean值测试  
    private SchoolInfoModel schoolInfo;  
    private List hobbyList;						//集合测试，此处可以改为数组/Set进行测试  
    private Map map;							//Map测试  
    private PhoneNumberModel phoneNumber;		//String->自定义对象的转换测试  
    private Date date;							//日期类型测试  
    private UserState state;					//String——>Enum类型转换测试  
	
    public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isBool() {
		return bool;
	}
	public void setBool(boolean bool) {
		this.bool = bool;
	}
	public SchoolInfoModel getSchoolInfo() {
		return schoolInfo;
	}
	public void setSchoolInfo(SchoolInfoModel schoolInfo) {
		this.schoolInfo = schoolInfo;
	}
	public List getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List hobbyList) {
		this.hobbyList = hobbyList;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public PhoneNumberModel getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(PhoneNumberModel phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public UserState getState() {
		return state;
	}
	public void setState(UserState state) {
		this.state = state;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this); 
	}
}  

enum UserState {
	jiangxi, beijing, xinjiang;
}

class PhoneNumberModel {  
    private String areaCode;			//区号  
    private String phoneNumber;				//电话号码  
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String toString() {
		return ReflectionToStringBuilder.toString(this); 
	}
}  

/*
http://localhost:8080/oa-test/cms/databind?username=zhang&bool=yes&schoolInfo.schoolName=computer&hobbyList[0]=program&hobbyList[1]=music&map[key1]=value1&map[key2]=value2&phoneNumber=010-12345678&date=2012-3-18%2016:48:48&state=blocked
	
http://localhost:8080/oa-test/cms/databind?
	username=zhang
	bool=yes
	schooInfo.schoolName=computer
	hobbyList[0]=program
	hobbyList[1]=music
	map[key1]=value1
	map[key2]=value2&
	phoneNumber=010-12345678&
	date=2012-3-18%2016:48:48&
	state=blocked
*/		
