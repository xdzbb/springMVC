package com.mvc.test;

import java.security.acl.Owner;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.entity.Tuser;
import com.mvc.service.ITuserService;

@Controller
/**
 * 使用 SessionStatus 控制 Session 级别的模型属性
 * @author syj
 *
 */
public class SessionStatus {

	@Resource
	private ITuserService usersService;

	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute Tuser user,
			BindingResult result, SessionStatus status) {
		// <——① new OwnerValidator().validate(owner, result);
		if (result.hasErrors()) {
			return "ownerForm";
		} else {
			this.usersService.isRegister(user);
			/**
			 * processSubmit() 方法中的 owner 表单对象将绑定到 ModelMap 的“owner”属性中，result
			 * 参数用于存放检验 owner 结果的对象，而 status 用于控制表单处理的状态。在 ② 处，我们通过调用
			 * status.setComplete() 方法，该 Controller 所有放在 session 级别的模型属性数据将从
			 * session 中清空
			 */
			//status.setComplete();// <——②
			return "redirect:owner.do?ownerId=" + user.getId();
		}
	}
}
