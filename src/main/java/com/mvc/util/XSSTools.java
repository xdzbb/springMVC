package com.mvc.util;

import java.util.regex.Pattern;

public class XSSTools {

	/**
	 * @author zbb
	 */
	public static String replaceSpecialChars(String input) {
		if (!hasSpecialChars(input)) {
			return input;
		}
		StringBuffer sb = new StringBuffer(input.length());
		char c;
		for (int i = 0; i <= input.length() - 1; i++) {
			c = input.charAt(i);
		    switch (c) {  
            case '<':  
                sb.append("&lt;");  
                break;
            case '>':  
                sb.append("&gt;");  
                break;  
            case '\'':  
                sb.append("&prime;");// &acute;");  
                break;  
            case '′':  
                sb.append("&prime;");// &acute;");  
                break;  
            case '\"':  
                sb.append("&quot;");  
                break;  
            case '＂':  
                sb.append("&quot;");  
                break;  
            case '&':  
                sb.append("＆");  
                break;  
            case '#':  
                sb.append("＃");  
                break;  
            case '\\':  
                sb.append('￥');  
                break;
            case '=':  
                sb.append("&#61;");  
                break;
            default:  
                sb.append(c);  
                break;  
            } 
		}
		return (sb.toString());
	}

	public static boolean hasSpecialChars(String input) {
		boolean flag = false;
			if ((input != null) && (input.length() > 0)) {
				char c;
				for (int i = 0; i <= input.length() - 1; i++) {
					c = input.charAt(i);
					switch (c) {				
						case '<':  
							flag = true;
			                break;
			            case '>':  
			            	flag = true;
			                break;  
			            case '\'':  
			            	flag = true;
			                break;  
			            case '′':  
			            	flag = true;
			                break;  
			            case '\"':  
			            	flag = true;
			                break;  
			            case '＂':  
			            	flag = true;
			                break;  
			            case '&':  
			            	flag = true;
			                break;  
			            case '#':  
			            	flag = true;
			                break;  
			            case '\\':  
			            	flag = true;
			                break;
			            case '=':  
			            	flag = true;
			                break;	            
					}
				}
		}
		return flag;
	}
	public static String Html2Text(String inputString) {
		String htmlStr;
		if (inputString != null) {
			htmlStr = inputString; // 含html标签的字符串
		}else {
			htmlStr = "";
		}
		String textStr = "";
		java.util.regex.Pattern p_script;
		java.util.regex.Matcher m_script;
		java.util.regex.Pattern p_style;
		java.util.regex.Matcher m_style;
		java.util.regex.Pattern p_html;
		java.util.regex.Matcher m_html;

		try {
			String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
																										// }
			String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
																									// }
			String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

			p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
			m_script = p_script.matcher(htmlStr);
			htmlStr = m_script.replaceAll(""); // 过滤script标签

			p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
			m_style = p_style.matcher(htmlStr);
			htmlStr = m_style.replaceAll(""); // 过滤style标签

			p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
			m_html = p_html.matcher(htmlStr);
			htmlStr = m_html.replaceAll(""); // 过滤html标签

			textStr = htmlStr;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return textStr;// 返回文本字符串
	}	
}
