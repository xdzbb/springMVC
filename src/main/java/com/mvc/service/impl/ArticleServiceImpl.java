package com.mvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import antlr.collections.List;

import com.mvc.dao.IBaseDao;
import com.mvc.entity.Article;
import com.mvc.service.IArticleService;

@Service
public class ArticleServiceImpl implements IArticleService {
	public static int ART_NEW=1;
	public static int ART_RECOMMEND=2;
	public static int ART_HOT=3;
	@Resource
	private IBaseDao<Article> baseDao;
	
	@Override
	public int publishArticle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteArticle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int recommendArticle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int banArticle() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List getList(int type, int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getPageList() {
		// TODO Auto-generated method stub
		return null;
	}

}
