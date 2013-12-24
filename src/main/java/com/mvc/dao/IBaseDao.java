package com.mvc.dao;
import java.util.List;

import org.springframework.dao.DataAccessException;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.mvc.entity.Pager;

public interface IBaseDao<T> {		
		/**
		 * 离线式组合查询（带分页）
		 * @param dc
		 * @param pager
		 * @return
		 */
		public List<?> findByDetach(DetachedCriteria dc,Pager pager);
		
		/**
		 * 查询总记录个数
		 * @param dc
		 * @return
		 */
		public Integer findByConut(DetachedCriteria dc);

		// 删除或更新
		public abstract int updateOrDelete(String hql) throws DataAccessException;
		
		// 删除对象
		public abstract int deleteObject(T object);		
			
		// 根据id获取对象
		public abstract Object getObjectById(T clazz, Integer id);
		
		// 插入对象
		public abstract int saveObject(T object);

		// 插入或修改对象
		public abstract int updateObject(T object);

		
		// 查询 返回列表 num个(如果num为null返回所有)
		public abstract List<?> getList(String hql, Integer num)
				throws DataAccessException;

		// 查询数量
		public abstract Integer getCount(String hql) throws DataAccessException;

		// 查询数量
		public abstract Integer getMax(String hql) throws DataAccessException;
	
		// 分页查询
		public abstract List<?> getPagerData(String hql, Integer curPage,
				Integer countPerPage);

		// 查询对象
		public abstract Object findObject(String hql) throws DataAccessException;

	
		//执行sql语句进行更新和删除
		public abstract int executeSQLUpdate(String sql) throws DataAccessException;

		//执行sql执行查询数量
		public abstract int executeSQLQueryCount(String sql)
				throws DataAccessException;

		// 查询 返回列表 num个(如果num为null返回所有)
		public abstract List<?> SQLQueryList(String sql, Integer num, Class<?> clazz)
				throws DataAccessException;

		// 查询 返回列表 分页
		public abstract List<?> SQLQueryPagerList(String sql, Integer curPage,
				Integer countPerPage, Class<?> clazz) throws DataAccessException;

}
