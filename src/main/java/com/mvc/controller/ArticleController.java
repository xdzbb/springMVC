package com.mvc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.service.IArticleService;

@Controller
public class ArticleController{
	@Resource
	private IArticleService articleService;
	
	@RequestMapping("/article_publicArticle.do")
	public String publicArticle(){
		return "publicArticle";
	}	
}
