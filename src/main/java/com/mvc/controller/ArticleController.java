package com.mvc.controller;

import java.util.List;

import javassist.expr.NewArray;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.entity.Article;
import com.mvc.entity.Articletype;
import com.mvc.service.IArticleService;
import com.mvc.service.IArticleTypeService;

@Controller
public class ArticleController {
	@Resource
	private IArticleService articleService;
	@Resource
	private IArticleTypeService articleTypeService;

	@RequestMapping(value = "/article_publicArticle.do", method = RequestMethod.GET)
	public String publicArticle(HttpServletRequest request, ModelMap map,
			ModelAndView modelAndView, SessionStatus status) {
		List<Articletype> typelist = (List<Articletype>) articleTypeService
				.getArticleTypeList();
		map.addAttribute("typelist", typelist);		
		return "publicArticle";
	}

	@RequestMapping(value = "/article_publicArticle.do", method = RequestMethod.POST)
	public String saveArticle(Article article,
			String vdcode, @RequestParam("ArtContent") String content,
			ModelMap map, HttpSession session) {
		String Session_ValidateCode = (String) session
				.getAttribute("Session_ValidateCode");
		String error = "";	
		// 验证码
		if (Session_ValidateCode == null || "".equals(Session_ValidateCode)
				|| !Session_ValidateCode.equalsIgnoreCase(vdcode)) {
			error = "验证码错误！";
		} else if (article.getArticletype().getId().equals("")) {
			error = "请选择分类！";
		} else if (article.getTuser().getId().equals("")) {
			error = "登录用户才能发表文章！";
		}
		article.setContent(content);
		if (!error.equals("")) {
			map.addAttribute("error", error);
			List<Articletype> typelist = (List<Articletype>) articleTypeService
					.getArticleTypeList();
			map.addAttribute("typelist", typelist);
			map.addAttribute(article);
			return "publicArticle";
		} else {
			articleService.publishArticle(article);
			map.addAttribute("message", "文章发布成功！");
			return "superMessage";
		}
	}
}
