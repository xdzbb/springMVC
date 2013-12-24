package com.mvc.controller;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.entity.Tuser;
import com.mvc.service.ITuserService;

@Controller
@RequestMapping("/user.do")
@SessionAttributes({"u","a"})
public class TuserController{
	
	@Resource
	private ITuserService userService;

	@RequestMapping(params="method=reg")
	public String reg(Tuser tuser){
			return "register";
	}
	
}
