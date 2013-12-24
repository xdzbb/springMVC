package com.mvc.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.mvc.dao.impl.BaseDaoImpl;
import com.mvc.entity.Articletype;
import com.mvc.entity.Tuser;
import com.mvc.service.ITuserService;

@Service("userService")
public class TuserServiceImpl implements ITuserService {

	@Resource
	private BaseDaoImpl baseDao;
}
