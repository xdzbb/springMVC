package com.mvc.test;

import java.text.SimpleDateFormat;

import javax.xml.crypto.Data;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

/**
 * 注册框架级的自定义属性编辑器
 * 
 * @author syj
 * 
 */
public class MyBindingInitializer implements WebBindingInitializer {

	/**
	 * 配置文件 <bean class=
	 * "org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter"
	 * > <property name="webBindingInitializer"></property> </bean> <bean
	 * class="com.mvc.controller" />
	 */
	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Data.class, new CustomDateEditor(
				dateFormat, false));
		binder.registerCustomEditor(String.class,
				new StringTrimmerEditor(false));
		/**
		 * 如果希望某个属性编辑器仅作用于特定的 Controller，可以在 Controller 中定义一个标注 @InitBinder
		 * 注解的方法，可以在该方法中向 Controller 了注册若干个属性编辑器，来看MyFormController类：
		 */
	}
}
