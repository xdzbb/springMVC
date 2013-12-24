package com.mvc.dao.impl;


import java.util.List;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mvc.dao.IBaseDao;
import com.mvc.entity.Pager;

@Repository("baseDao")
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {	
	
	private final static Integer baseNum=1;//增删该返回的受影响行数
	
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

	@Override
	public int deleteObject(T t) {
		// TODO Auto-generated method stub
		ht.delete(t);
		return baseNum;
	}
	
	@Override
	public Integer findByConut(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return ht.findByCriteria(dc).size();
	}
	
	@Override
	public List<T> findByDetach(DetachedCriteria dc, Pager pager) {
		// TODO Auto-generated method stub
		return ht.findByCriteria(dc,pager.getCurrentPage()*pager.getPageSize(),pager.getPageSize());
	}
	
	@Override
	public int saveObject(T t) {
		// TODO Auto-generated method stub
		ht.save(t);
		return baseNum;
	}
	
	@Override
	public int updateObject(T t) {
		// TODO Auto-generated method stub
		ht.update(t);
		return baseNum;
	}
}
