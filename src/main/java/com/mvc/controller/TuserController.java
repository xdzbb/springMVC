package com.mvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
public class TuserController {
	private static final Log log = LogFactory.getLog(TuserController.class);

	@Resource
	private ITuserService userService;

	@RequestMapping("/reg.do")
	public String isreg() {
		// 这是进入注册页面
		return "register";
	}

	@RequestMapping("/index.do")
	public String index() {
		return "index";
	}

	// @ModelAttribute注解的方法进行表单引用对象的创建
	@RequestMapping(value = "/user.do", method = RequestMethod.POST)
	public String reg(Tuser tuser, ModelMap model, HttpSession session,
			String newpassword) {
		// 当tuser的部分属性不为空时
		if (tuser.getEmail() != null && tuser.getUsername() != null
				&& tuser.getNickname() != null && tuser.getPassword() != null
				&& tuser.getPassword().equals(newpassword)) {
			// 进行保存操作
			System.out.println((int) new Date().getTime());
			tuser.setCreatetime((int) new Date().getTime());
			tuser.setStatus(Tuser.NormalStatus);
			if (userService.isRegister(tuser)) {
				//放入session中
				session.setAttribute("tuser", tuser);
				session.setAttribute("message","注册成功！");
				return "redirect:/superMessage.do";
			}
		}
		session.setAttribute("message","注册失败！");
		return "redirect:/superError.do";
	}
	
	@RequestMapping("/superError.do")
	public String superError(){
		return "superError";
	}
	
	@RequestMapping("/superMessage.do")
	public String superMessage(){
		return "superMessage";
	}

}
