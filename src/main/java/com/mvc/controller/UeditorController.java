package com.mvc.controller;

import java.io.File;
import java.net.URL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.iterators.EnumerationIterator;
import org.apache.commons.fileupload.FileItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONWriter.State;
import com.mvc.util.DFSTracker;
import com.mvc.util.Uploader;

@Controller
public class UeditorController implements ServletContextAware {
	private ServletContext servletContext;
	@Resource(name="dfsTracker")
	private DFSTracker dfsTracker;
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		this.servletContext = arg0;
	}
	/*//ueditor上传图片
	@RequestMapping("/ueditor_imageUp.do")
	public String imageUp(@RequestParam("upfile") CommonsMultipartFile file,HttpServletRequest request,HttpServletResponse response) {
		try {			
			HttpSession session = request.getSession();	
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");	
		    Uploader up = new Uploader(request);		   
		    up.setSavePath("/home/xdzbb/temp");
		    String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
		    up.setAllowFiles(fileType);
		    up.setMaxSize(10000); //单位KB
			up.upload();
			String url = up.getUrl();		
			response.getWriter().print("{'original':'"+up.getOriginalName()+"','url':'"+url+"','title':'"+up.getTitle()+"','state':'"+up.getState()+"'}");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}*/
	//ueditor上传图片
	@RequestMapping("/ueditor_imageUp.do")
	public String imageUp(@RequestParam("upfile") CommonsMultipartFile file,HttpServletRequest request,HttpServletResponse response) {
		try {			
			HttpSession session = request.getSession();	
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");	
			Uploader up = new Uploader(request,dfsTracker);
			/*String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
			up.setAllowFiles(fileType);*/
			up.springUpload(file);
			response.getWriter().print("{'url':'"+up.getUrl()+"','fileType':'"+up.getType()+"','state':'"+up.getState()+"','original':'"+up.getOriginalName()+"'}");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}
	//ueditor上传文件
	@RequestMapping("/ueditor_fileUp.do")
	public String fileUp(@RequestParam("upfile") CommonsMultipartFile file,HttpServletRequest request, HttpServletResponse response) {
		 try {			
				HttpSession session = request.getSession();	
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");	
				Uploader up = new Uploader(request,dfsTracker);
				 String[] fileType = {".rar" , ".doc" , ".docx" , ".zip" , ".pdf" , ".txt" , ".swf", ".wmv"}; 
				up.setAllowFiles(fileType);
				up.springUpload(file);
				response.getWriter().print("{'url':'"+up.getUrl()+"','fileType':'"+up.getType()+"','state':'"+up.getState()+"','original':'"+up.getOriginalName()+"'}");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}
	
	//ueditor管理文件
	@RequestMapping("/ueditor_imageManager.do")
	public String imageManager(HttpServletRequest request, HttpServletResponse response) {
		try {
		
			//仅做示例用，请自行修改
			HttpSession session = request.getSession();	
			String path = "";		
			path = "/home/xdzbb/temp";			
			String imgStr ="";
			String realpath = "/"+path;
			List<File> files = getFiles(realpath,new ArrayList());
			for(File file :files ){
				imgStr+=file.getPath()+"ue_separate_ue";
			}
			if(imgStr!=""){
		        imgStr = imgStr.substring(0,imgStr.lastIndexOf("ue_separate_ue")).replace(File.separator, "/").trim();
		    }
			response.getWriter().print(imgStr);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}
	
	
	public List getFiles(String realpath, List files) {
		File realFile = new File(realpath);
		if (realFile.isDirectory()) {
			File[] subfiles = realFile.listFiles();
			for(File file :subfiles ){
				if(file.isDirectory()){
					getFiles(file.getAbsolutePath(),files);
				}else{
					if(!getFileType(file.getName()).equals("")) {
						files.add(file);
					}
				}
			}
		}
		return files;
	}

	public String getRealPath(HttpServletRequest request,String path){
		ServletContext application = request.getSession().getServletContext();
		String str = application.getRealPath(request.getServletPath());
		return new File(str).getParent();
	}

	public String getFileType(String fileName){
		String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
		Iterator<String> type = Arrays.asList(fileType).iterator();
		while(type.hasNext()){
			String t = type.next();
			if(fileName.endsWith(t)){
				return t;
			}
		}
		return "";
	}
}
