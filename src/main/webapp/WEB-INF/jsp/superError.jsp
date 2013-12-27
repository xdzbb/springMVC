<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>错误信息</title>
</head>
<body>
<style>
.col-dl{ width:60%; height:auto; padding:30px; background:#f8f8f8; border:1px solid #ddd; margin:0 auto; margin-top:30px; text-align:center}
.col-dl dt{ width:100%; clear:both; margin:0; padding:0}
.col-dl .h2{ color:#AFC7EB; font-family:"微软雅黑"; font-size:36px; line-height:50px}
.col-dl dd.big{ font-size:30px; font-family:"微软雅黑"; line-height:50px; color:#999}
.col-dl dd{ font-size:14px; line-height:30px; color:#666; margin:0; padding:0}
.col-dl dd a{ color:#06C; text-decoration:none}
.success .h2{ color:#A0C758}
.error .h2{ color:#FF7171} 
</style>
<div class="col-dl success">
 	<dl>
 	<dt class="h2">错误提示</dt>
 	<dd class="big">
    <c:if test="${empty message}">
网络地址错误。
</c:if>
<c:if test="${!empty message}">
${message}
</c:if>
    </dd>
	<dd>你可以<a href="javascript:void(0);" onclick="history.back();return false;">返回</a>之前的页面，或者关闭此窗口</dd>
 	</dl>
</div>
</body>
</html>
