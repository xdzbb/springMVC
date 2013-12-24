package com.mvc.service;

import com.mvc.entity.Tuser;

public interface ITuserService {

	/**
	 * 是否注册成功
	 * @param tuser
	 * @return
	 */
	public boolean isRegister(Tuser tuser);
	
	/**
	 * 是否登录成功
	 * @param tuser
	 * @return
	 */
	public Tuser isLogin(Tuser tuser);
	

}
