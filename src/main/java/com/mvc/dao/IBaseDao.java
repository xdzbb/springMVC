package com.mvc.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.mvc.entity.Pager;

public interface IBaseDao<T> {
	
	public Object getObjectById(Class<?> clazz,Integer id);
	
	/**
	 * 添加
	 * @param t
	 * @return
	 */
	public int saveObject(T t);
	
	/**
	 * 更新
	 * @param t
	 * @return
	 */
	public int updateObject(T t);
	
	/**
	 * 删除
	 * @param t
	 * @return
	 */
	public int deleteObject(T t);
	
	/**
	 * 离线式组合查询（带分页）
	 * @param dc
	 * @param pager
	 * @return
	 */
	public List<T> findByDetach(DetachedCriteria dc,Pager pager);
	
	/**
	 * 查询总记录个数
	 * @param dc
	 * @return
	 */
	public Integer findByConut(DetachedCriteria dc);
}
