package com.mvc.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/*
 * 统计controller的执行时间
 */
public class MeasurementInterceptor implements HandlerInterceptor {
	/*
	 * 添加拦截器的过滤器
	 */
	private List<String> excludedUrls;  
	   
	public void setExcludedUrls(List<String> excludedUrls) {  
		this.excludedUrls = excludedUrls;  
	} 
	@Override
	public boolean preHandle(HttpServletRequest request,  
	        HttpServletResponse response,Object handler)throws Exception{  
	        long startTime = System.currentTimeMillis();  
	        request.setAttribute("startTime",startTime);  
	        return true;
	}  
    @Override
    public void postHandle(HttpServletRequest request,HttpServletResponse response,  
        Object handler,ModelAndView modelAndView)throws Exception{
    	boolean isexclude = false;
    	String requestUri = request.getRequestURI();
    	System.out.println(requestUri);
    	for(String url : excludedUrls) {  
    	      if (requestUri.endsWith(url)) {  
    	    	  isexclude = true;
    	      }  
    	}  
        long startTime = (Long)request.getAttribute("startTime");  
        request.removeAttribute("startTime");  
        long endTime = System.currentTimeMillis();
        long handlingTime = endTime-startTime;
        if(!isexclude){
        	System.out.println("handlingTime:"+handlingTime+"ms");        	
        }
        
    }
    @Override
    public void afterCompletion(HttpServletRequest request,  
        HttpServletResponse response,Object handler,Exception ex)throws Exception{  
          
    }  

}
