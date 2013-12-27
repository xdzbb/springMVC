package com.mvc.util;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/*import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;*/

public class BitTools {

	/**
	 * @param args
	 */
	public static List ReadListFromFile(String fileName) {
		List<String> li = new ArrayList<String>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str;
			while ((str = in.readLine()) != null) {
				li.add(str);
			}
			in.close();
		} catch (IOException e) {
			//System.out.println(fileName);
			//System.out.println(e.toString());
			e.printStackTrace();
		}
		return li;

	}

	/*
	 * 将"请选择"字符串转换为对应的十进制Unicode码"&#35831;&#36873;&#25321;"
	 */
	public static String ConvertToUnicode(String testStr) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < testStr.length(); i++) {
			char s1 = testStr.charAt(i);
			int i1 = (int) s1;
			sb.append(String.format("&#%1$d;", i1));
		}
		return sb.toString();

	}

	/*
	 * 将"请选择"字符串转换为对应的十进制Unicode码"\u8bf7\u9009\u62e9\u5bbf\u820d"
	 */
	public static String ConvertToUnicodeHex(String testStr) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < testStr.length(); i++) {
			char s1 = testStr.charAt(i);
			int i1 = (int) s1;
			sb.append(String.format("/u%1$x", i1));
		}
		return sb.toString();

	}

	public static String ConvertToUnicodeHex2(String s) {
		String unicode = "";
		char[] charAry = new char[s.length()];
		for (int i = 0; i < charAry.length; i++) {
			charAry[i] = (char) s.charAt(i);
			unicode += "/u" + Integer.toString(charAry[i], 16);
		}
		return unicode;

	}

	// 经典java转码程序，有备无患！实现和jdk\bin\native2ascii.exe同样的功能,verygood!
	public static String ConvertToUnicodeHexCode(String str) {
		String tmp;
		StringBuffer sb = new StringBuffer(1000);
		char c;
		int i, j;
		sb.setLength(0);
		for (i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			if (c > 255) {
				sb.append("/u");
				j = (c >>> 8);
				tmp = Integer.toHexString(j);
				if (tmp.length() == 1)
					sb.append("0");
				sb.append(tmp);
				j = (c & 0xFF);
				tmp = Integer.toHexString(j);
				if (tmp.length() == 1)
					sb.append("0");
				sb.append(tmp);
			} else {
				sb.append(c);
			}

		}
		return (new String(sb));

	}

	public static boolean SaveBufferedImageToFile(BufferedImage image, String fileName) {
		boolean ret = false;
		try {
			File f = new File(fileName);
			if (!f.exists()) {
				f.createNewFile();
			} else {
				Thread.sleep(200);
				f.delete();
				f.createNewFile();
			}
			ImageIO.write(image, "jpg", f);
			ret = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static HashMap getFormElementFromRequest(HttpServletRequest request,
			HttpServletResponse response) {
		HashMap<String, Serializable> map = new HashMap<String, Serializable>();
		try {
			// Create a factory for disk-based file items
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 设置最多只允许在内存中存储的数据,单位:字节
			factory.setSizeThreshold(4096);
			// 设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
			factory.setRepository(new File(request.getSession()
					.getServletContext().getRealPath("/photo-temp")));

			// Create a new file upload handler
			ServletFileUpload upload = new ServletFileUpload(factory);

			// Sets the maximum allowed size of a complete request, as opposed
			// to setFileSizeMax(long).
			// 设置允许用户上传文件大小,单位:字节
			upload.setSizeMax(10240000);

			// Parse the request
			List /* FileItem */items = upload.parseRequest(request);
			// Process the uploaded items
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();

				if (item.isFormField()) {// 一般的表单字段
					map.put(item.getFieldName(), item.getString());
				} else {

					map.put(item.getFieldName(), item);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}
	
	// 将item对应的文件写到saveFilePath这个文件中
	public static boolean saveFileToServer(FileItem item, String saveFilePath) {
		File uploadedFile = new File(saveFilePath);
		try {
			item.write(uploadedFile);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public static boolean DeleteFiles(List<String> files) {
		boolean ret = true;
		for (String file : files) {
			if (file != null && file.length() > 0) {
				File f = new File(file);
				if (f.exists()) {
					boolean success = (new File(file)).delete();
					if (!success) {
						ret = false;
					}
				}
			}
		}
		return ret;
	}

	public static String Date2String(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static String Date2HQLString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static String Date2StringSimple(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	public static String Date2StringSimple3(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return sdf.format(date);
	}

	public static String getMonth(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(date);
	}

	public static String getDay(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		return sdf.format(date);
	}

	public static String Date2StringSimple2(Date date) {
		if (date == null)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
		return sdf.format(date);
	}

	public static String Date2MonthDay(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		return sdf.format(date);
	}

	public static String GetRandomString(int length) {
		Random random = new Random();
		String base = "0123456789";
		int size = base.length();
		String sRand = "";
		for (int i = 0; i < length; i++) {
			int start = random.nextInt(size);
			String tmpStr = base.substring(start, start + 1);
			sRand += tmpStr;
		}
		return sRand;
	}

	public static String String2URL(String oriURL) {
		String ret = null;
		try {
			if(oriURL==null){
				ret = "";
			}else{
				ret = URLEncoder.encode(oriURL, "UTF-8");
			}			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = "";
		}
		return ret;
	}
	
	public static String ISO2UTF8(String str) {
		try {
			String encode=getEncoding(str);
			if (encode.equals("ISO-8859-1")) {
				return new String(str.getBytes("ISO8859_1"), "utf-8");
			}else {
				return new String(str.getBytes("UTF-8"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static String URL2String(String oriURL) {
		String ret = null;
		try {
			if(oriURL==null){
				ret = "";
			}else{
				ret = URLDecoder.decode(oriURL, "UTF-8");
			}			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = "";
		}
		return ret;

	}

	public static String[] splitString(String str, String patternString) {
		Pattern p = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE
				| Pattern.MULTILINE);
		return p.split(str);
	}
	
	// 调试输出信息
	public static void debugPrintln(String msg) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = df.format(new java.util.Date());
			SimpleDateFormat dir_str = new SimpleDateFormat("yyyy-MM-dd");
			String dir_date = dir_str.format(new Date());
			boolean exists = (new File("/web/debug/")).exists();
			if (!exists) {
				boolean success = (new File("/web/debug/")).mkdirs();
				if (!success) {
				}
			}
			File out = new File("/web/debug/" + dir_date + ".txt");
			FileWriter fw = new FileWriter(out, true);
			PrintWriter pw = new PrintWriter(fw, true);
			pw.println(now + " : " + msg);
			fw.close();
		} catch (Exception e) {
			//System.out.println(e.toString());
		}
	}

	// 输出访问信息
	public static void visitPrintln(String msg) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = df.format(new java.util.Date());
			SimpleDateFormat dir_str = new SimpleDateFormat("yyyy-MM-dd");
			String dir_date = dir_str.format(new Date());
			boolean exists = (new File("/web/visit/")).exists();
			if (!exists) {
				boolean success = (new File("/web/visit/")).mkdirs();
				if (!success) {
				}
			}
			File out = new File("/web/visit/" + dir_date + ".txt");
			FileWriter fw = new FileWriter(out, true);
			PrintWriter pw = new PrintWriter(fw, true);
			pw.println(now + " : " + msg);
			fw.close();
		} catch (Exception e) {
			//System.out.println(e.toString());
		}
	}

	// 输出异常信息
	public static void exceptionPrintln(String msg) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = df.format(new java.util.Date());
			SimpleDateFormat dir_str = new SimpleDateFormat("yyyy-MM-dd");
			String dir_date = dir_str.format(new Date());
			boolean exists = (new File("/web/exception/")).exists();
			if (!exists) {
				boolean success = (new File("/web/exception/")).mkdirs();
				if (!success) {
				}
			}
			File out = new File("/web/exception/" + dir_date + ".txt");
			FileWriter fw = new FileWriter(out, true);
			PrintWriter pw = new PrintWriter(fw, true);
			pw.println(now + " : " + msg);
			fw.close();
		} catch (Exception e) {
			//System.out.println(e.toString());
		}
	}

	// 输出严重错误信息
	public static void fatalPrintln(String msg) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String now = df.format(new java.util.Date());
			File out = new File("/web/mdaxue_fatal.txt");
			FileWriter fw = new FileWriter(out, true);
			PrintWriter pw = new PrintWriter(fw, true);
			pw.println(now + " : " + msg);
			fw.close();
		} catch (Exception e) {
			//System.out.println(e.toString());
		}

	}

	public static void PrintToFile(String msg, String filename) {
		try {
			File out = new File(filename);
			FileWriter fw = new FileWriter(out);
			PrintWriter pw = new PrintWriter(fw);
			pw.print(msg);
			fw.close();
		} catch (Exception e) {
			//System.out.println(e.toString());
		}

	}

	public static void PrintToFile(String msg, String filename, boolean append) {
		try {
			File out = new File(filename);
			FileWriter fw = new FileWriter(out, append);
			PrintWriter pw = new PrintWriter(fw, append);
			pw.print(msg);
			fw.close();
		} catch (Exception e) {
			//System.out.println(e.toString());
		}

	}

	public static void PrintToFileLn(String msg, String filename, boolean append) {
		try {
			File out = new File(filename);
			FileWriter fw = new FileWriter(out, append);
			PrintWriter pw = new PrintWriter(fw, append);
			pw.println(msg);
			fw.close();
		} catch (Exception e) {
			//System.out.println(e.toString());
		}

	}

	public static void PrintListToFile(List dataList, String filename) {
		try {
			File out = new File(filename);
			FileWriter fw = new FileWriter(out);
			PrintWriter pw = new PrintWriter(fw);
			if (dataList != null) {
				for (int i = 0; i < dataList.size(); i++) {
					String line = (String) dataList.get(i);
					pw.println(line);
				}
			}
			fw.close();
		} catch (Exception e) {
			//System.out.println(e.toString());
		}

	}

	public static void PrintToFileUTF8(String msg, String filename) {
		try {
			File out = new File(filename);
			PrintWriter pw = new PrintWriter(out, "UTF-8");
			pw.print(msg);
			pw.close();
		} catch (Exception e) {
			//System.out.println(e.toString());
		}

	}

	public static int DiffTowDays(Date date1, Date date2) {
		long diff = date2.getTime() - date1.getTime();
		int result = (int) Math.abs((diff / (1000 * 24 * 60 * 60)));
		return result;
	}
	
	// List中是否包含指定的对象
	public static boolean ListContains(List list, Object obj) {
		boolean ret = false;
		if (list != null) {
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Object listObj = it.next();
				if (listObj.equals(obj)) {
					ret = true;
					break;
				}

			}
		}
		return ret;
	}

	public static String getCaller() {
		int i;
		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < stack.length; i++) {
			StackTraceElement ste = stack[i];
			sb.append(ste.getClassName() + "." + ste.getMethodName() + "(...)\n");
			sb.append(i + "--" + ste.getMethodName() + "\n");
			sb.append(i + "--" + ste.getFileName() + "\n");
			sb.append(i + "--" + ste.getLineNumber() + "\n");
		}
		return sb.toString();
	}

	public static String getBirthRange(Date birth, int range) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(birth);
		// 从当前日历中减去range天
		cal.add(Calendar.DAY_OF_MONTH, range);
		// 取得新的月份
		return BitTools.Date2MonthDay(cal.getTime());
	}

	public static String[] getBirthRangeString(Date birth, int range) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(birth);
		// 从当前日历中减去range天
		cal.add(Calendar.DAY_OF_MONTH, range);
		// 取得新的月份
		String month = BitTools.getMonth(cal.getTime());
		String day = BitTools.getDay(cal.getTime());
		String[] ret = new String[2];
		ret[0] = month;
		ret[1] = day;
		return ret;
	}

	public static String RandomCode(int length) {
		java.util.Random rand = new Random(); // 设置随机种子
		// 设置备选验证码:包括"a-z"和数字"0-9"
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int size = base.length();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int start = rand.nextInt(size);
			String tmpStr = base.substring(start, start + 1);
			str.append(tmpStr);
		}
		return str.toString();
	}


	public static void main(String[] args) {
		//System.out.println(RandomCode(9));
		//System.out.println(stripHtml("<p>我们</p>"));
	}
	
	//去掉HTML标签
	public static String stripHtml(String content) {  
		// <p>段落替换为换行  
		content = content.replaceAll("<p .*?>", "\r\n");  
		// <br><br/>替换为换行  
		content = content.replaceAll("<br\\s*/?>", "\r\n");  
		// 去掉其它的<>之间的东西  
		content = content.replaceAll("\\<.*?>", "");  
		// 还原HTML  
		//content = HTMLDecoder.decode(content);  
		return content;  
	} 

	static String convertFileName(String filename, String flag) {
		String ret = null;
		File file = new File(filename);
		String path = file.getParent();
		String thisfile = file.getName();
		ret = path + "/" + flag + thisfile;
		return ret;
	}	
	public static String readFromTextFile(String fileName) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String s;
			while ((s = in.readLine()) != null) {
				sb.append(s);
				sb.append("\n");
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static boolean isEmpty(String str) {
		return (str == null || str.equals("")) ? true : false;
	}

	public static boolean isEmptyTrim(String str) {
		return (str == null || str.trim().equals("")) ? true : false;
	}

	public static String isUUID(String str) {
		return (isEmptyTrim(str) || str.length() != 32) ? null : str;
	}

	public static Integer isGTZ(String str) {
		Integer strn = null;
		if (str == null)
			return null;
		try {
			strn = Integer.parseInt(str);
		} catch (Exception e) {
			strn = null;
		}
		if (strn == null || (strn != null && strn.intValue() < 1))
			return null;
		else
			return strn;
	}

	public static Short isGTZS(String str) {
		Short strn = null;
		if (str == null)
			return null;
		try {
			strn = Short.parseShort(str);
		} catch (Exception e) {
			strn = null;
		}
		if (strn == null || (strn != null && strn.intValue() < 1))
			return null;
		else
			return strn;
	}
	
	public static Short isGTZSO(String str) {
		Short strn = null;
		if (str == null)
			return null;
		try {
			strn = Short.parseShort(str);
		} catch (Exception e) {
			strn = null;
		}
		if (strn == null || (strn != null && strn.intValue() < 0))
			return null;
		else
			return strn;
	}
	
	public static Short toShort(String str) {
		Short strn = null;
		if (str == null)
			return null;
		try {
			strn = Short.parseShort(str);
		} catch (Exception e) {
			strn = null;
		}
		if (strn == null || (strn != null && strn.intValue() < -1))
			return null;
		else
			return strn;
	}

	public static Byte isGTZB(String str) {
		Byte strn = null;
		if (str == null)
			return null;
		try {
			strn = Byte.parseByte(str);
		} catch (Exception e) {
			strn = null;
		}
		if (strn == null || (strn != null && strn.intValue() < 1))
			return null;
		else
			return strn;
	}

	public static Short isSHORT(String str) {
		Short strn = null;
		if (str == null)
			return null;
		try {
			strn = Short.parseShort(str);
		} catch (Exception e) {
			strn = null;
		}
		if (strn == null || (strn != null && strn.intValue() < 0))
			return null;
		else
			return strn;
	}

	public static Byte isByte(String str) {
		Byte strn = null;
		if (str == null)
			return null;
		try {
			strn = Byte.parseByte(str);
		} catch (Exception e) {
			strn = null;
		}
		if (strn == null || (strn != null && strn.intValue() < 0))
			return null;
		else
			return strn;
	}

	public static Float isGTZF(String str) {
		Float strn = null;
		if (str == null)
			return null;
		try {
			strn = Float.parseFloat(str);
		} catch (Exception e) {
			strn = null;
		}
		if (strn == null || (strn != null && strn.intValue() < 0))
			return null;
		else
			return strn;
	}

	public static Integer isINT(String str) {
		Integer strn = null;
		if (str == null)
			return null;
		try {
			strn = Integer.parseInt(str);
		} catch (Exception e) {
			strn = null;
		}
		if (strn == null)
			return null;
		else
			return strn;
	}

	public static String getContentImg(String content) {
		String ret = "";
		StringBuffer sb = new StringBuffer();
		StringBuffer input = new StringBuffer(content);
		String patternString = "<img([^>]+)>";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(input);		
		if (matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			String match = input.substring(start, end);			
			match = getImgSrc(match);			
			sb.append(match );			
		}
		ret = sb.toString();
	
		return ret;
	}

	public static String getImgSrc(String temp) {
		String ret = "";
		StringBuffer sb = new StringBuffer();
		StringBuffer input = new StringBuffer(temp);
		String patternString = "src=(.)*?.(JPG|GIF|BMP|JPEG|jpg|gif|bmp|jpeg)(\"|')";
		Pattern pattern = Pattern.compile(patternString, Pattern.DOTALL);
		Matcher matcher = pattern.matcher(input);
		while(matcher.find()) {
			int start = matcher.start();
			int end = matcher.end();
			String match = input.substring(start, end);		
			int i = match.length();
			match = match.substring(5, i - 1);
			sb.append(match);
		}
		ret = sb.toString();		
		return ret;
	}

	public static String intToString(Integer id) {
		if (id == null || id.intValue() < 0)
			return null;
		String old = "00000000";
		String str = String.valueOf(id);
		int len = old.length() - str.length();
		if (len < 0)
			return null;
		return old.substring(0, len).concat(str);
	}

	public static String shortToString(Short id) {
		if (id == null || id.shortValue() < 0)
			return null;
		String old = "0000";
		String str = String.valueOf(id);
		int len = old.length() - str.length();
		if (len < 0)
			return null;
		return old.substring(0, len).concat(str);
	}

	public static String getEmailWeb(String str) {
		if (str == null || str.length() < 1)
			return null;
		return str.substring(str.indexOf("@") + 1);
	}
	/*
	// 添加水印,filePath 源图片路径， watermark 水印图片路径
	public static boolean createMark(String srcfilePath, String desfilePath,String watermark) {
		ImageIcon imgIcon = new ImageIcon(srcfilePath);
		Image theImg = imgIcon.getImage();
		ImageIcon waterIcon = new ImageIcon(watermark);
		Image waterImg = waterIcon.getImage();
		int width = theImg.getWidth(null);
		int height = theImg.getHeight(null);
		BufferedImage bimage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bimage.createGraphics();
		g.setColor(Color.red);
		g.setBackground(Color.white);
		g.drawImage(theImg, 0, 0, null);
		g.drawImage(waterImg, 0, 0, null);
		g.dispose();
		try {
			FileOutputStream out = new FileOutputStream(desfilePath);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage);
			param.setQuality(50f, true);
			encoder.encode(bimage, param);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	
	// 将文件filePath1复制为filePath2
	public static boolean copyPhotoFile(String filePath1, String filePath2) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File filePathOld = new File(filePath1);
			if (filePathOld.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(filePath1); // 读入原文件
				FileOutputStream fs = new FileOutputStream(filePath2);
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					// //System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
			return true;
		} catch (Exception e) {
			//System.out.println("复制文件出错");
			e.printStackTrace();
			return false;
		}
	}
	// 判断字符串的编码！！
	public static String getEncoding(String str) {
		String encode = "GB2312";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s = encode;
				return s;
			}
		} catch (Exception exception) {
		}
		encode = "ISO-8859-1";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s1 = encode;
				return s1;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s2 = encode;
				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (str.equals(new String(str.getBytes(encode), encode))) {
				String s3 = encode;
				return s3;
			}
		} catch (Exception exception3) {
		}
		return "";
	}	
}

