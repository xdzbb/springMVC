package com.mvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.mvc.dao.impl.BaseDaoImpl;
import com.mvc.entity.Articletype;
import com.mvc.entity.Pager;
import com.mvc.entity.Tuser;
import com.mvc.service.ITuserService;

@Service("userService")
public class TuserServiceImpl implements ITuserService {

	@Resource
	private BaseDaoImpl baseDao;
	
	@Override
	public int deleteUser(Tuser user) {
		// TODO Auto-generated method stub
		return baseDao.deleteObject(user);
	}
	
	@Override
	public Integer findByConut(Tuser tuser) {
		// TODO Auto-generated method stub
		DetachedCriteria dc=DetachedCriteria.forClass(Tuser.class);
		return baseDao.findByConut(dc);
	}
	
	@Override
	public List<Tuser> findByDetach(Tuser tuser, Pager pager) {
		// TODO Auto-generated method stub
		DetachedCriteria dc=DetachedCriteria.forClass(Tuser.class);
		return baseDao.findByDetach(dc, pager);
	}
	
	@Override
	public int saveUser(Tuser user) {
		// TODO Auto-generated method stub
		return baseDao.saveObject(user);
	}
	
	@Override
	public int updateUser(Tuser user) {
		// TODO Auto-generated method stub
		return baseDao.saveObject(user);
	}
}
