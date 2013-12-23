package com.mvc.controller;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.service.ITuserService;

@Controller
@RequestMapping("/user.do")
@SessionAttributes({"u","a"})
public class TuserController{

	@Autowired
	private ITuserService userService;
	
	@RequestMapping(params="method=reg")
	public String reg(String uname){
		//配置错了
		System.out.println(uname+"++++++++++++");
		System.out.println("此处调用了TuserController");   
		return "index";
	}
	
}
