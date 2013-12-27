package com.mvc.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mvc.entity.Tuser;
import com.mvc.service.ITuserService;

@Controller
/**
 * 使模型对象的特定属性具有 Session 范围的作用域
 * @author syj
 *
 */
@RequestMapping("/bbtForum.do")
// ①将ModelMap中属性名为currUser的属性 //放到Session属性列表中，以便这个属性可以跨请求访问
@SessionAttributes("tuser")
public class BbtForumController2 {

	@Resource
	private ITuserService userService;

	public String listBoardTopic(@RequestParam("id") int topicId, Tuser tuser,
			ModelMap model) {
		userService.isRegister(tuser);
		System.out.println("topicId:" + topicId);
		System.out.println("user:" + tuser); // ① 将user对象以currUser为键放入到model中
		/**
		 * 我们在②处添加了一个 ModelMap 属性，其属性名为 tuser，而 ① 处通过 @SessionAttributes 注解将
		 * ModelMap 中名为 tuser 的属性放置到 Session 中，所以我们不但可以在 listBoardTopic() 请求所对应的
		 * JSP 视图页面中通过 request.getAttribute(“tuser”) 和
		 * session.getAttribute(“tuser”) 获取 user 对象，还可以在下一个请求所对应的 JSP 视图页面中通过
		 * session.getAttribute(“tuser”) 或 ModelMap#get(“tuser”) 访问到这个属性 其实 @SessionAttributes
		 * 允许指定多个属性。你可以通过字符串数组的方式指定多个属性，如
		 * @SessionAttributes({“attr1”,”attr2” )。此外，@SessionAttributes
		 * 还可以通过属性类型指定要 session 化的 ModelMap
		 * 属性，如 @SessionAttributes(types =
		 * User.class)，当然也可以指定多个类，如
		 * @SessionAttributes(types ={User.class,Dept.class})，
		 * 还可以联合使用属性名和属性类型指定 ：@SessionAttributes(types ={User.class,Dept.class},
		 * value={“attr1”,”attr2”})。 是否可以将ModelMap中的属性绑定到请求处理方法的入参中呢？答案是肯定的.
		 * Spring为此提供了一个@ModelAttribute的注解，下面是使用@ModelAttribute注解的例子,在BbtForumController3里面：
		 */
		model.addAttribute("tuser", tuser);
		return "listTopic";
	}
}