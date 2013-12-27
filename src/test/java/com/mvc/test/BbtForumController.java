package com.mvc.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.entity.Tuser;
import com.mvc.service.ITuserService;

@Controller
/**
 * 使用 ModelMap 访问请示对应的隐含模型对象
 * @author syj
 *
 */
public class BbtForumController{
	
	@Resource
	private ITuserService userService;
	
	/**
	 * Spring 2.0 定义了一个 org.springframework.ui.ModelMap 类，
	 * 它作为通用的模型数据承载对象，传递数据供视图所用。
	 * 我们可以在请求处理方法中声明一个 ModelMap 类型的入参，
	 * Spring 会将本次请求模型对象引用通过该入参传递进来，
	 * 这样就可以在请求处理方法内部访问模型对象了
	 */
	public String listBoardTopic(@RequestParam("id")int topicId, Tuser tuser,ModelMap model) {
		userService.isRegister(tuser);
		System.out.println("topicId:" + topicId);       
		System.out.println("user:" + tuser);  //① 将user对象以currUser为键放入到model中       
		/**
		 * ModelMap 中的 currUser 属性将放到 
		 * request 的属性列表中，所以可以在 JSP 视图页面中通过 
		 * request.getAttribute(“tuser”) 或者通过 ${tuser} EL 
		 * 表达式访问模型对象中的 user 对象。从这个角度上看， 
		 * ModelMap 相当于是一个向 request 属性列表中添加对象的一条管道，借由 ModelMap 对象的支持，
		 * 我们可以在一个不依赖 Servlet API 的 Controller 中向 request 中添加属性。
		 * 在默认情况下，ModelMap 中的属性作用域是 request 级别是，也就是说，当本次请求结束后，
		 * ModelMap 中的属性将销毁。如果希望在多个请求中共享 ModelMap 
		 * 中的属性，必须将其属性转存到 session 中，
		 * 这样 ModelMap 的属性才可以被跨请求访问,请看BbtForumController2类的例子。
		 */
		model.addAttribute("currUser",tuser);        
		return "listTopic";
	}
}