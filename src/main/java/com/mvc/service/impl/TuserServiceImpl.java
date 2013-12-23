package com.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.impl.BaseDaoImpl;
import com.mvc.entity.Tuser;
import com.mvc.service.ITuserService;

@Service("userService")
public class TuserServiceImpl implements ITuserService {

	private BaseDaoImpl<Tuser> baseDao;
	
	
	public BaseDaoImpl<Tuser> getBaseDao() {
		return baseDao;
	}

	@Autowired
	public void setBaseDao(BaseDaoImpl<Tuser> baseDao) {
		this.baseDao = baseDao;
	}


	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("此处调用了ITuserService");
	}

}
