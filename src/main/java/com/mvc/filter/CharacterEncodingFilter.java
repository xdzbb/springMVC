package com.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	
	private String characterEncoding; //编码方式配置在web.xml文件中
    private boolean enabled;   //是否启用此Filter，配置在web.xml中
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		characterEncoding =null;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if (enabled || characterEncoding != null) {
            request.setCharacterEncoding(characterEncoding);
            response.setCharacterEncoding(characterEncoding);
        }
        chain.doFilter(request, response);
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		characterEncoding = filterConfig.getInitParameter("characterEncoding");
        enabled = "true".equalsIgnoreCase(filterConfig.getInitParameter("enabled").trim());
	}
	
}
