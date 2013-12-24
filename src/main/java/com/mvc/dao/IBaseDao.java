package com.mvc.dao;

public interface IBaseDao<T> {
	public Object getObjectById(Class<?> clazz,Integer id);
}
