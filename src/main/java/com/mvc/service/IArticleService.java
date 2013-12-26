package com.mvc.service;

import com.mvc.entity.Article;

import antlr.collections.List;

public interface IArticleService {
	public int publishArticle(Article article);
	public int deleteArticle();
	public int recommendArticle();
	public int banArticle();
	/*
	 * 根据不同类型获取列表
	 */
	public List getList(int type,int num);
	public List	getPageList();
}
