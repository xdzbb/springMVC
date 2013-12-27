package com.mvc.util;

import java.io.File;


import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.context.WebApplicationContext;

public class WebTools {
	// 取得主机名
	public static String getHostName(HttpServletRequest request) {
		String ret = "";
		if (request != null) {
			String s4 = request.getRequestURI();
			String s5 = request.getRequestURL().toString();
			int i = s5.indexOf(s4);
			if (i > 0) {
				ret = s5.substring(0, i);
			}
		}
		return ret;
	}

	/*
	 * begin: Name:wuqiwei Data:2013-3-21 Email:1058633117@qq.com restoreReason:
	 * 错误修改公共模块代码
	 */
	public static HashMap ProcessUploadForm(List requestList) {
		HashMap<String, Serializable> requestMap = new HashMap<String, Serializable>();
		if (requestList != null) {
			Iterator iter = requestList.iterator();
			String fieldName = null;
			String fieldValue = null;
			@SuppressWarnings("unused")
			String fileupname = null;
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {
					fieldName = item.getFieldName();
					requestMap.put(fieldName, item);
				} else {
					fieldName = item.getFieldName();
					fieldValue = CharTools.ISO2UTF8(item.getString());
					requestMap.put(fieldName, fieldValue);
				}
			}
		}
		return requestMap;
	}

	/*
	 * end: Name:wuqiwei Data:2013-3-21 Email:1058633117@qq.com restoreReason:
	 * 错误修改公共模块代码
	 */
	// 处理common upload 组件的form
	/* Begin Name:wuqiwei Date:2013-07-16 AddReason:使用fastdfs上传文件 */
	@SuppressWarnings("rawtypes")
	public static HashMap<String, Serializable> ProcessUploadForm(
			HttpServletRequest request) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置最多只允许在内存中存储的数据,单位:字节
		factory.setSizeThreshold(10240 * 10);
		String temDir = "/home/xdzbb/temp";
		File temDirFile = new File(temDir);
		if (!temDirFile.exists()) {
			temDirFile.mkdirs();
		}
		// 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
		factory.setRepository(new File(temDir));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(50 * 1024 * 1000);
		// 将文件表单域的文件放入内存
		List requestList = null;
		try {
			requestList = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		HashMap<String, Serializable> requestMap = new HashMap<String, Serializable>();
		if (requestList != null) {
			Iterator iter = requestList.iterator();
			String fieldName = "";
			String fieldValue = "";
			while (iter.hasNext()) {
				FileItem fileItem = (FileItem) iter.next();
				// 如果是文件表单域
				if (!fileItem.isFormField()) {
					// 获得表单的字段名
					fieldName = fileItem.getFieldName();
					// 上传游戏图片
					requestMap.put(fieldName, fileItem);
					// 如果是正常的表单域
				} else {
					fieldName = fileItem.getFieldName();
					fieldValue = CharTools.ISO2UTF8(fileItem.getString());
					requestMap.put(fieldName, fieldValue);
				}
			}
		}
		return requestMap;
	}

	/* Begin Name:wuqiwei Date:2013-07-16 AddReason:使用fastdfs上传文件 */

	// 取得三级域名
	public static String getThirdDNS(HttpServletRequest request) {
		String ret = "";
		if (request != null) {
			String URL = request.getRequestURL().toString();
			int i = URL.indexOf("/");
			if (i < 0)
				i = 0;
			int j = URL.indexOf(".");
			if (j > 0) {
				if (i > 0)
					ret = URL.substring(i + 2, j);
				else
					ret = URL.substring(0, j);
			}
		}
		return ret;
	}

	// 获得域名数
	public static int getDNSCount(HttpServletRequest request) {
		int ret = 0;
		if (request != null) {
			String URL = request.getRequestURL().toString();
			int i = URL.indexOf("/");
			if (i != -1)
				URL = URL.substring(0, i);
			String[] list = URL.split(".");
			ret = list.length - 1;
		}
		return ret;
	}

	// 取得www后的三级域名
	public static String getFourthDNS(HttpServletRequest request) {
		String ret = "";
		if (request != null) {
			String URL = request.getRequestURL().toString();
			int i = URL.indexOf("/");
			if (i < 0)
				i = 0;
			int j = URL.indexOf(".", 12);
			if (j > 0) {
				if (i > 0)
					ret = URL.substring(i + 6, j);
				else
					ret = URL.substring(0, j);
			}
		}
		return ret;
	}

	public static String getThirdDNS(String URL) {
		String ret = "";
		if (URL != null) {
			int i = URL.indexOf("/");
			if (i < 0)
				i = 0;
			int j = URL.indexOf(".");
			if (j > 0) {
				if (i > 0)
					ret = URL.substring(i + 2, j);
				else
					ret = URL.substring(0, j);
			}
		}

		return ret;
	}

	public static String getPathDNS(String URL) {
		String ret = "";
		if (URL != null) {
			int i = URL.indexOf("/", 7);
			if (i < 0)
				i = 0;
			int j = URL.indexOf("/", i + 1);
			if (j > 0) {
				ret = URL.substring(i + 1, j);
			}
		}
		return ret;
	}

	public static String getPathURL(String URL) {
		String ret = "";
		if (URL != null) {
			int i = URL.indexOf("/", 7);
			if (i < 0)
				i = 0;
			int j = URL.indexOf("/", i + 1);
			if (j > 0) {
				ret = URL.substring(j + 1);
			}
		}
		return ret;
	}

	public static String getPathDNS(HttpServletRequest request) {
		String ret = "";
		if (request != null) {
			String URL = request.getRequestURL().toString();
			int i = URL.indexOf("/", 7);
			if (i < 0)
				i = 0;
			int j = URL.indexOf("/", i + 1);
			if (j > 0) {
				ret = URL.substring(i + 1, j);
			}
		}
		return ret;
	}

	public static String getPathURL(HttpServletRequest request) {
		String ret = "";
		if (request != null) {
			String URL = request.getRequestURL().toString();
			int i = URL.indexOf("/", 7);
			if (i < 0)
				i = 0;
			int j = URL.indexOf("/", i + 1);
			if (j > 0) {
				ret = URL.substring(j + 1);
			}
		}
		return ret;
	}

	// 根据列表和请求字符串查找请求的分站主页是否存在，如果存在的话返回真，如果不存在的话返回假
	public static boolean checkColllegeAbbrName(Vector v, String url) {
		if (v.contains(url)) {
			return true;
		} else {
			return false;
		}
	}

	public static void addCookie(HttpServletResponse response, String domain,
			String name, String value, int maxAge) {
		try {
			// 解决中文报Control character in cookie value, consider BASE64 encoding
			// your value错。
			value = URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cookie cookie = new Cookie(name, value);
		cookie.setPath("/");
		if (!domain.equals("") && domain != null) {
			cookie.setDomain(domain);
		} else {
			cookie.setDomain("." + "mdaxue");
		}
		if (maxAge > 0)
			cookie.setMaxAge(maxAge);
		response.addCookie(cookie);
	}

	public static String getCookieValue(String cook, HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		try {
			for (Cookie one : cookies) {
				if (one.getName() != null && one.getName().equals(cook))
					return URLDecoder.decode(one.getValue(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void clearCookiebyName(String cook,
			HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie one : cookies) {
				try {
					if (one.getName() != null && one.getName().equals(cook)) {
						one.setMaxAge(0);
						one.setDomain("."
								+ "mdaxue");
						response.addCookie(one);
					}
				} catch (Exception e) {

					BitTools.debugPrintln("清楚Cookies发生异常！");
				}
			}
		}

	}

	public static void clearAllCookie(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		Cookie cookie = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				try {
					cookie = cookies[i];
					cookie.setMaxAge(0);
					cookies[i].setDomain("."
							+ "mdaxue");
					response.addCookie(cookie);
				} catch (Exception e) {

					BitTools.debugPrintln("清空Cookies发生异常！");
				}
			}
		}
	}

	// 返回request所有属性的map add by zbb
	public static Map<String, Object> getAllAtrributions(
			HttpServletRequest request, List<String> allowList){
		Enumeration<?> enum1 = request.getAttributeNames();
		Map<String, Object> map = new HashMap<String, Object>();
		while (enum1.hasMoreElements()) {
			String o = (String) enum1.nextElement();
			if (!allowList.contains(o)) {
				continue;
			}				
			map.put(o, request.getAttribute(o));			
		}
		return map;

	}

	// 设置request属性通过map add by zbb
	public static void setAllAtrributions(HttpServletRequest request,
			Map<String, Object> map) {
		Object value = null;
		String key = null;
		Set<String> keysSet = map.keySet();
		@SuppressWarnings("rawtypes")
		Iterator iterator = keysSet.iterator();
		while (iterator.hasNext()) {
			key = (String) iterator.next();// key
			value = map.get(key);// value
			request.setAttribute(key, value);
		}
	}
}
