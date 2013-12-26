package com.mvc.controller;

import javax.annotation.Resource;
import javax.transaction.Transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import com.mvc.entity.Tuser;
import com.mvc.service.ITuserService;

@Controller
@SessionAttributes(value={"tuser"})
public class TuserController {
	private static final Log log = LogFactory.getLog(TuserController.class);

	@Resource
	private ITuserService userService;
	
	@RequestMapping("reg.do")
	public String isreg() {
		//这是进入注册页面
		return "register";
	}
	
	@RequestMapping("index.do")
	public String index(){
		return "index";
	}

	//@ModelAttribute注解的方法进行表单引用对象的创建
	@RequestMapping(value="/user.do",method=RequestMethod.POST)
	public String reg(@ModelAttribute("tuser")Tuser tuser,ModelMap model,SessionStatus status) {
		//当tuser的部分属性不为空时
		if (tuser.getEmail() != null && tuser.getUsername() != null
				&& tuser.getNickname() != null && tuser.getPassword() != null) {
			//进行保存操作
			if (userService.isRegister(tuser)) {
				model.addAttribute("tuser",tuser);
				return "redirect:index.do";
			}
			 log.error("session错了");
		}
		return "register";
	}

}


