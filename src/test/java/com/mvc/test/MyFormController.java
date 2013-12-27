package com.mvc.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
/**
 * 注册 Controller 级的自定义属性编辑器
 * @author syj
 *
 */
public class MyFormController {
	//注意被标注 @InitBinder 注解的方法必须拥有一个 WebDataBinder 类型的入参，
	//以便 Spring MVC 框架将注册属性编辑器的 WebDataBinder 对象传递进来。
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
}
