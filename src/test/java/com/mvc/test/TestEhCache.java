package com.mvc.test;

import java.util.ArrayList;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEhCache {
	public static void main(String[] args) {
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring-servlet.xml");    
		 Cache ehCache = (Cache) ctx.getBean("ehCache");
		 List list = new ArrayList();
		 list.add("123456");
		 Element element = new Element("key", list);
		 ehCache.put(element);
		 System.out.println(((List)ehCache.get("key").getValue()).get(0));
		 ehCache.remove("key");
		 ehCache.removeAll();
		 System.out.println(("xxx"+ehCache.get("key")));
	}
}
