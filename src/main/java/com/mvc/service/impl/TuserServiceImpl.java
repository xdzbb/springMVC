package com.mvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.mvc.dao.impl.BaseDaoImpl;
import com.mvc.entity.Articletype;
import com.mvc.entity.Pager;
import com.mvc.entity.Tuser;
import com.mvc.service.ITuserService;

@Service("userService")
public class TuserServiceImpl implements ITuserService {

	@Resource
	private BaseDaoImpl<Tuser> baseDao;
	
	@Override
	public boolean isRegister(Tuser tuser) {
		// TODO Auto-generated method stub
		Integer resultr=baseDao.saveObject(tuser);
		if (resultr>0) {
			return true;
		}
		return false;
	}
	
	@Override
	public Tuser isLogin(Tuser tuser) {
		// TODO Auto-generated method stub
		DetachedCriteria dc=DetachedCriteria.forClass(Tuser.class);
		dc.add(Restrictions.eq("nickname", tuser.getNickname()));
		dc.add(Restrictions.eq("password", tuser.getPassword()));
		List<Tuser> list= baseDao.findByDetach(dc, null);
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}
}
