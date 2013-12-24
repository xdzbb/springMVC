package com.mvc.dao.impl;

import java.util.List;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
	
	//保存对象
	@Override
	public int saveObject(T t) {
		// TODO Auto-generated method stub
		ht.save(t);
		return baseNum;
	}
	
	//更新对象
	@Override
	public int updateObject(T t) {
		// TODO Auto-generated method stub
		ht.update(t);
		return baseNum;
	}
	
	// 根据id获取对象
	@Override
	public Object getObjectById(T clazz,Integer id){	
		return ht.get(clazz.getClass(), id);
	}

	
	
	// 删除或更新
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int updateOrDelete(final String hql) throws DataAccessException {			
		return (Integer) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				try {
					Query query = session.createQuery(hql);
					return (Integer) query.executeUpdate();
				} catch (RuntimeException e) {						
					e.printStackTrace();
					return null;
				}
			}
		});
	}		
	
	// 查询 返回列表 num个(如果num为null返回所有)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<?> getList(final String hql, final Integer num)
			throws DataAccessException {	
		return (List<?>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				try {
					Query query = session.createQuery(hql);
					if (num != null && num.intValue() > 0){
						query.setMaxResults(num);
					}
					List<?> result = query.list();
					return result;
				} catch (RuntimeException e) {						
					e.printStackTrace();
					return null;
				}
			}
		});
	}

	// 查询数量
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Integer getCount(final String hql) throws DataAccessException {
		int ret = 0;
		Long Int;	
		Int = (Long) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				try {
					Query query = session.createQuery(hql);
					return (Long) query.uniqueResult();
				} catch (RuntimeException e) {					
					e.printStackTrace();
					return 0;
				}
			}
		});
		if (Int != null)
			ret = Int.intValue();
		return ret;
	}
	
	// 查询数量
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Integer getMax(final String hql) throws DataAccessException {			
		int Int =0;		
		Int = (Integer) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				try {
					Query query = session.createQuery(hql);
					return (Integer) query.uniqueResult();
				} catch (RuntimeException e) {							
					e.printStackTrace();
					return 0;
				}
			}
		});			
		return Int;
	}
			
	// 分页查询
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<?> getPagerData(final String hql, final Integer curPage,
			final Integer countPerPage) {		
		return (List<?>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				try {
					Query query = session.createQuery(hql);
					if (curPage!=null&&countPerPage!=null) {
						query.setFirstResult(countPerPage * (curPage - 1));
						query.setMaxResults(countPerPage);
					}
					List<?> result = query.list();
					return result;
				} catch (RuntimeException e) {						
					e.printStackTrace();
					return null;
				}
			}
		});
	}

	// 查询对象
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Object findObject(final String hql) throws DataAccessException {		
		return ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				Object result;
				try {
					Query query = session.createQuery(hql);
					query.setCacheable(true);
					result = query.uniqueResult();
				} catch (RuntimeException e) {
					result = null;						
					e.printStackTrace();
				}
				return result;
			}
		});
	}
	

	// 插入或修改对象
	public int UpdateObject(T object) {
		try {		
			ht.saveOrUpdate(object);
			ht.flush();
			return 1;
		} catch (RuntimeException e) {				
			e.printStackTrace();
			return 0;
		}
	}
	
	//执行sql语句进行更新和删除
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public int executeSQLUpdate(final String sql)
			throws DataAccessException {
		Integer ret = new Integer(0);	
		ret = (Integer) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createSQLQuery(sql);
				Integer result = (Integer) query.executeUpdate();
				return result;
			}
		});
		return ret.intValue();
	}
	
	//执行sql执行查询数量
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int executeSQLQueryCount(final String sql)
			throws DataAccessException {
		Integer ret = new Integer(0);	
		ret = (Integer) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createSQLQuery(sql);
				Integer result = (Integer) query.uniqueResult();
				return result;
			}
		});
		return ret.intValue();
	}
	
	// 查询 返回列表 num个(如果num为null返回所有)
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<?> SQLQueryList(final String sql, final Integer num,final Class<?> clazz)
			throws DataAccessException {
		return (List<?>) ht.execute(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException {
				try {
					SQLQuery query = session.createSQLQuery(sql);
					/*
					 * begin:Name wuqiwei,Date:2013-1-16,Email:1058633117@qq.com
					 * 配置主页的团购的查询缓存
					 */
					query.setCacheable(true);
					/*
					 * begin:Name wuqiwei,Date:2013-1-16,Email:1058633117@qq.com
					 * 配置主页的团购的查询缓存
					 */
					query.addEntity(clazz);
					if (num != null && num.intValue() > 0)
						query.setMaxResults(num);
					List<?> result = query.list();
					return result;
				} catch (RuntimeException e) {					
					e.printStackTrace();
					return null;
				}
			}
		});
	}	
	
	// 查询 返回列表 num个(如果num为null返回所有)
	@Override
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
	//删除对象
	@Override
	public int deleteObject(T t) {
		// TODO Auto-generated method stub
		ht.delete(t);
		return baseNum;
	}
	
	//查询数量
	@Override
	public Integer findByConut(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		return ht.findByCriteria(dc).size();
	}
	
	//查询分页
	@Override
	public List<?> findByDetach(DetachedCriteria dc, Pager pager) {
		// TODO Auto-generated method stub
		return ht.findByCriteria(dc,pager.getCurrentPage()*pager.getPageSize(),pager.getPageSize());
	}
	
}
