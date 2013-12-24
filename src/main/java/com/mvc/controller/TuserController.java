package com.mvc.controller;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.service.ITuserService;

@Controller
@RequestMapping("/user.do")
@SessionAttributes({"u","a"})
public class TuserController{
	
	@Resource
	private ITuserService userService;

	@RequestMapping(params="method=reg")
	public String reg(String uname){
		System.out.println(uname+"++++++++++++");
		System.out.println("此处调用了TuserControllerXXXX");   
		System.err.println("---------------------------------");
		userService.test();
		return "index";
	}
	
}
