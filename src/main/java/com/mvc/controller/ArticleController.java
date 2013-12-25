package com.mvc.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.entity.Articletype;
import com.mvc.service.IArticleService;
import com.mvc.service.IArticleTypeService;

@Controller
public class ArticleController{
	@Resource
	private IArticleService articleService;
	@Resource
	private IArticleTypeService articleTypeService;
	
	
	@RequestMapping("/article_publicArticle.do")
	public String publicArticle(HttpServletRequest request){
		List<Articletype> typelist = (List<Articletype>) articleTypeService.getArticleTypeList();
		request.setAttribute("typelist", typelist);
		return "publicArticle";
	}	
}
