package com.mvc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.mvc.dao.IBaseDao;
import com.mvc.entity.Articletype;
import com.mvc.service.IArticleTypeService;
import com.mvc.util.Pager;

@Service
public class ArticleTypeServiceImpl implements IArticleTypeService {
	@Resource
	private IBaseDao<Articletype> baseDao;
	
	/* (non-Javadoc)
	 * @see com.mvc.service.impl.IArticleTypeService#getArticleTypeList()
	 */
	@Override
	public List<?> getArticleTypeList(){
		return baseDao.getList("from Articletype", null);
	}
	
	@Override
	public List<?> findByDetach(Articletype type, Pager pager) {
		// TODO Auto-generated method stub
		DetachedCriteria dc=DetachedCriteria.forClass(Articletype.class);
		return baseDao.findByDetach(dc, null);
	}

	@Override
	public Articletype getArticleById(int id) {
		// TODO Auto-generated method stub
		Articletype articletype = (Articletype) baseDao.getObjectById(new Articletype(),Integer.parseInt("1"));
		System.out.println(articletype.getTypename());
		return null;
	}
	
}
