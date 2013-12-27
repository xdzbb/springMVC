package com.mvc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.entity.Tuser;
import com.mvc.service.ITuserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

/**
 * 定义为处理请求准备数据的方法
 * 
 * @author syj
 * 
 */
@Controller
@RequestMapping("/bbtForum.do")
public class BbtForumController4 {

	@Resource
	private ITuserService userService;

	@ModelAttribute("items")
	// <——①向模型对象中添加一个名为items的属性
	public List<String> populateItems() {
		List<String> lists = new ArrayList<String>();
		lists.add("item1");
		lists.add("item2");
		return lists;
	}

	@RequestMapping(params = "method=listAllBoard")
	public String listAllBoard(@ModelAttribute("user") Tuser user,
			ModelMap model) {
		userService.isRegister(user); // <——②在此访问模型中的items属性
		System.out.println("model.items:"
				+ ((List<String>) model.get("items")).size());
		return "listBoard";
		/**
		 * 在 ① 处，通过使用 @ModelAttribute 注解，populateItem()
		 * 方法将在任何请求处理方法执行前调用，Spring MVC 会将该方法返回值以“items”为名放入到隐含的模型对象属性列表中。
		 * 所以在 ② 处，我们就可以通过 ModelMap 入参访问到 items 属性，当执行 listAllBoard() 请求处理方法时，
		 * ② 处将在控制台打印出“model.items:2”的信息。当然我们也可以在请求的视图中访问到模型对象中的 items 属性。
		 */
	}
}
