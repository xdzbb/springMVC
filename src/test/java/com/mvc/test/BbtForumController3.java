package com.mvc.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.entity.Tuser;
import com.mvc.service.ITuserService;

@Controller
/**
 * 使模型对象的特定属性具有 Session 范围的作用域
 * 使用@ModelAttribute注解
 * @author syj
 *
 */
@RequestMapping("/bbtForum.do")
@SessionAttributes("tuser")// ①让ModelMap的tuser属性拥有session级作用域
public class BbtForumController3 {

	@Resource
	private ITuserService userService;

	@RequestMapping(params = "method=listBoardTopic")
	public String listBoardTopic(@RequestParam("id") int topicId, Tuser tuser,
			ModelMap model) {
		userService.isRegister(tuser);
		System.out.println("topicId:" + topicId);
		System.out.println("user:" + tuser);
		// ②向ModelMap中添加一个属
		model.addAttribute("tuser", tuser);
		return "listTopic";
	}

	// ③将ModelMap中的 //currUser属性绑定到user入参中。
	public String listAllBoard(@ModelAttribute("tuser") Tuser tuser) {
		userService.isRegister(tuser);
		System.out.println("user:" + tuser);
		return "listBoard";
		/**
		 * 在 ② 处，我们向 ModelMap 中添加一个名为 tuser 的属性，而 ① 外的注解使这个 tuser 属性拥有了
		 * session 级的作用域。所以，我们可以在 ③ 处通过 @ModelAttribute 注解将 ModelMap 中的 currUser
		 * 属性绑定以请求处理方法的 user 入参中。所以当我们先调用以下 URL 请求：
		 * http://localhost/bbtForum.do?method=listBoardTopic&id=1&userName=tom&dept.deptId=12
		 * 以执行listBoardTopic()请求处理方法，然后再访问以下URL： 
		 * http://localhost/sample/bbtForum.do?method=listAllBoard
		 * 你将可以看到 listAllBoard() 的 tuser 入参已经成功绑定到 listBoardTopic() 中注册的
		 *  session 级的 tuser 属性上了。
		 */
	}
}