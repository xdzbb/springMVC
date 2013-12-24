package com.mvc.dao.impl;


import java.util.List;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mvc.dao.IBaseDao;

@Repository("baseDao")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {	
	private HibernateTemplate ht = this.getHibernateTemplate();
	
	@Resource
	public void setSessionFactory0(SessionFactory sessionFactory){		
	  super.setSessionFactory(sessionFactory);		 
	}	
	
	// 查询 返回列表 num个(如果num为null返回所有)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<?> SQLQueryPagerList(final String sql, final Integer curPage,
			final Integer countPerPage,final Class<?> clazz)
			throws DataAccessException {
		return (List<?>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				try {
					SQLQuery query = session.createSQLQuery(sql);
					query.addEntity(clazz);
					query.setFirstResult(countPerPage * (curPage - 1));
					query.setMaxResults(countPerPage);
					List<?> result = query.list();
					return result;
				} catch (RuntimeException e) {					
					e.printStackTrace();
					return null;
				}
			}
		});
	}
	// 根据id获取对象
	public Object getObjectById(Class<?> clazz,Integer id){
		return ht.get(clazz, id);
	}	
}
