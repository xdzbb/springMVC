package com.mvc.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.entity.Tuser;
import com.mvc.service.ITuserService;

@Controller
@SessionAttributes({ "u", "a" })
public class TuserController {

	@Resource
	private ITuserService userService;

	@RequestMapping("/reg.do")
	public String isreg() {
		//这是进入注册页面
		return "register";
	}

	@RequestMapping("/user.do")
	public String reg(Tuser tuser) {
		//当tuser的部分属性不为空时
		if (tuser.getEmail() != null && tuser.getUsername() != null
				&& tuser.getNickname() != null && tuser.getPassword() != null) {
			//进行保存操作
			if (userService.isRegister(tuser)) {
				return "index";
			}
		}
		return "register";
	}

}
