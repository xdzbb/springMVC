package com.mvc.controller;

import java.io.File;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.util.Uploader;

@Controller
public class UeditorController{

	//ueditor上传图片
	@RequestMapping("/ueditor_imageUp.do")
	public String imageUp(HttpServletRequest request,HttpServletResponse response) {
		try {			
			HttpSession session = request.getSession();
			
			String status = request.getParameter("status");
			System.out.println("************"+status);
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
		    Uploader up = new Uploader(request);		   
		    up.setSavePath("mnt/imgsvr/email/uploadImage/");
		    String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
		    up.setAllowFiles(fileType);
		    up.setMaxSize(10000); //单位KB
			up.upload();
			String url = up.getUrl().replaceAll("mnt/imgsvr/", "");
			response.getWriter().print("{'original':'"+up.getOriginalName()+"','url':'"+url+"','title':'"+up.getTitle()+"','state':'"+up.getState()+"'}");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return null;
	}
	
	//ueditor上传文件
	@RequestMapping("/ueditor_fileUp.do")
	public String fileUp(HttpServletRequest request, HttpServletResponse response) {
		try {			
			request.setCharacterEncoding("utf-8");
		    response.setCharacterEncoding("utf-8");
		    Uploader up = new Uploader(request);
		    up.setSavePath("mnt/imgsvr/email/uploadFile"); //保存路径
		    String[] fileType = {".rar" , ".doc" , ".docx" , ".zip" , ".pdf" , ".txt" , ".swf", ".wmv"};  //允许的文件类型
		    up.setAllowFiles(fileType);
		    up.setMaxSize(10000);        //允许的文件最大尺寸，单位KB
		    up.upload();
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
			String status = request.getParameter("status");
			String path = "";		
			path = "mnt/imgsvr/email/uploadImage/";			
			String imgStr ="";
			String realpath = "/"+path;
			List<File> files = getFiles(realpath,new ArrayList());
			for(File file :files ){
				imgStr+=file.getPath().replace("mnt/imgsvr/","")+"ue_separate_ue";
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
