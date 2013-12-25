package com.mvc.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.mvc.entity.Articletype;
import com.mvc.util.Pager;

public interface IArticleTypeService {

	public abstract List<?> getArticleTypeList();
	
	/**
	 * 离线式组合查询（带分页）
	 * @param dc
	 * @param pager
	 * @return
	 */
	public List<?> findByDetach(Articletype type,Pager pager); 
	
	public Articletype getArticleById(int id);

}