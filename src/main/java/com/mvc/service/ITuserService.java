package com.mvc.service;

import java.util.List;
import com.mvc.entity.Pager;
import com.mvc.entity.Tuser;

public interface ITuserService {

	/**
	 * 添加
	 * @param t
	 * @return
	 */
	public int saveUser(Tuser user);
	
	/**
	 * 更新
	 * @param t
	 * @return
	 */
	public int updateUser(Tuser user);
	
	/**
	 * 删除
	 * @param t
	 * @return
	 */
	public int deleteUser(Tuser user); 
	
	/**
	 * 离线式组合查询（带分页）
	 * @param dc
	 * @param pager
	 * @return
	 */
	public List<Tuser> findByDetach(Tuser tuser,Pager pager);
	
	/**
	 * 查询总记录个数
	 * @param dc
	 * @return
	 */
	public Integer findByConut(Tuser tuser);

}
