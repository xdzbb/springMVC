package com.mvc.service;

import antlr.collections.List;

public interface IArticleService {
	public int publishArticle();
	public int deleteArticle();
	public int recommendArticle();
	public int banArticle();
	/*
	 * 根据不同类型获取列表
	 */
	public List getList(int type,int num);
	public List	getPageList();
}
