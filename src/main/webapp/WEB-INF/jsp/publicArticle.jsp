<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0042)http://www.jj59.com/member/article_add.php -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=GBK">

<title>发表普通文章 - 会员中心 - 九九文章网</title>
<link href="resource/css/base.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="resource/js/j.js"></script>
<script type="text/javascript" src="resource/js/inputAutoClear.js"></script>
<script type="text/javascript" src="resource/js/load.js"></script>
<script type="text/javascript" src="resource/js/leftmenu.js"></script>
<script type="text/javascript" src="resource/js/checkSubmit.js"></script>
</head>
<body>
<div id="main">
  <script type="text/javascript" src="resource/js/jquery.js"></script> 
<div id="header">
  <div id="siteNav">
    <div class="innerWrap">
      <div id="loginInfo">
      <script type="text/javascript">
           	var now=(new Date()).getHours();
			if(now>0&&now<=6){
				document.write("午夜好，");
			}else if(now>6&&now<=11){
				document.write("早上好，");
			}else if(now>11&&now<=14){
				document.write("中午好，");
			}else if(now>14&&now<=18){
				document.write("下午好，");
			}else{
				document.write("晚上好，");
			}
			</script>早上好，
       <a href="http://www.jj59.com/member/article_add.php#" class="userName">xdzbb</a> <a href="http://www.jj59.com/member/index_do.php?fmdo=login&dopost=exit#">[退出]</a> 
       <a href="http://www.jj59.com/member/pm.php" target="_blank">短消息</a>       </div>
      <ul id="quickMenu">
        <li class="home"><a href="http://www.jj59.com/" title="返回九九首页">网站首页</a></li>
        <li><a href="http://www.jj59.com/member/article_add.php#">内容中心</a></li>
        <li><a href="http://www.jj59.com/member/index.php?uid=xdzbb" title="会员空间">我的空间</a></li>
        <li><a href="http://www.jj59.com/member/mystow.php" title="收藏夹">收藏夹</a></li>
        <li class="help"><a href="http://www.jj59.com/23/help/" target="_blank" title="九九文章网 帮助中心">帮助</a></li>
        <li class="wb"><a href="http://t.qq.com/jj59_com" target="_blank" title="九九微博">关注九九微博</a></li>
      </ul>
    </div>
  </div>
  <!--顶部导航 -->
  <div id="topPic"> <span style="float:left;"><a href="http://www.jj59.com/member/"><img alt="返回会员中心" src="resource/images/m_logo.gif" class="topLogo"></a> </span>
  <span style=" width:550px; height:80px;  margin-top:10px; display:block; line-height:20px; float:right;"><font style="color:red; font-weight:bold;">九九公告：</font>为给大家提供更好的发表及阅读文章的交流平台，九九近期将对服务器进行升级，会暂停图片上传功能，阅读及发表都不受影响，在此给大家带来的不便还望谅解，图片上传恢复时间会在此公告。</span>
  </div>
  <div id="topNav">
    <ul id="appIterm">
      <li class="thisApp"><a href="http://www.jj59.com/member/" title="我的九九">我的九九</a></li>      
    </ul>
    <!--程序导航列表 -->
    <div id="channel">
      <ul>
        <li><a href="http://www.jj59.com/member/" title="个人空间"><span>个人中心</span></a></li>
        <li><a href="http://www.jj59.com/member/myfriend.php" title="我的好友"><span>我的好友</span></a></li>
        <li><a href="http://www.jj59.com/member/pm.php" title="短消息"><span>短消息</span></a></li>
        <li><a href="http://www.jj59.com/member/guestbook_admin.php" title="留言板"><span>留言板</span></a></li>
        <li><a href="http://www.jj59.com/member/caicai.php" title="随便踩踩"><span>随便踩踩</span></a></li>		
		<li><a href="http://www.jj59.com/member/edit_space_info.php" title="系统设置"><span>系统设置</span></a></li>
      </ul>
	  
    </div>
    <!--导航栏目项 -->
  </div>
</div>
  <div id="content" class="w960 clearfix">
            <div id="mcpsub">
      <div class="topGr"></div>
      <div id="menuBody">
      	<!-- 内容中心菜单-->
      	
        <h2 class="menuTitle" onclick="menuShow(&#39;menuOne&#39;)" id="menuOne_t"><b></b>文章内容管理</h2>
        <ul id="menuOne">
                  <li class="articles"><a href="http://www.jj59.com/member/content_list.php?channelid=1" title="已发布的文章"><b></b>已发文章</a><a href="./发表普通文章 - 会员中心 - 九九文章网_files/发表普通文章 - 会员中心 - 九九文章网.html" class="act" title="发表新作品">发表文章</a></li>
		  <li class="articles"><a href="http://www.jj59.com/member/content_list.php?channelid=7" title="已发布的故事"><b></b>故事</a><a href="http://www.jj59.com/member/article_add.php?channelid=7" class="act" title="发表新故事">发表故事</a></li>
		  
		  <li class="articles"><a href="http://www.jj59.com/member/content_list.php?channelid=8" title="已发布的散文"><b></b>散文</a><a href="http://www.jj59.com/member/article_add.php?channelid=8" class="act" title="发表新散文">发表散文</a></li>
		  
		  <li class="articles"><a href="http://www.jj59.com/member/content_list.php?channelid=9" title="已发布的杂文"><b></b>杂文</a><a href="http://www.jj59.com/member/article_add.php?channelid=9" class="act" title="发表新杂文">发表杂文</a></li>
		  
		  <li class="articles"><a href="http://www.jj59.com/member/content_list.php?channelid=10" title="已发布的诗歌"><b></b>诗歌</a><a href="http://www.jj59.com/member/article_add.php?channelid=10" class="act" title="发表新诗歌">发表诗歌</a></li>
		  
		  <li class="articles"><a href="http://www.jj59.com/member/content_list.php?channelid=11" title="已发布的日记"><b></b>日记</a><a href="http://www.jj59.com/member/article_add.php?channelid=11" class="act" title="发表新日记">发表日记</a></li>
		 
          <li class="articles"><a href="http://www.jj59.com/member/content_list.php?channelid=12" title="已发布的小说"><b></b>小说</a><a href="http://www.jj59.com/member/article_add.php?channelid=12" class="act" title="发表短篇小说">发表小说</a></li>
                </ul>
				  
        
       
        <!--资料修改-->
		<h2 class="menuTitle" onclick="menuShow(&#39;menuFirst&#39;)" id="menuFirst_t"><b></b>个人资料</h2>
        <ul id="menuFirst">
        	<li class="icon baseinfo"><a href="http://www.jj59.com/member/edit_baseinfo.php"><b></b>基本资料</a></li>
	        <li class="icon myinfo"><a href="http://www.jj59.com/member/edit_fullinfo.php"><b></b>个人资料</a></li>
	        <li class="icon face"><a href="http://www.jj59.com/member/edit_face.php"><b></b>头像设置</a></li>
        </ul>
  
      	
        <h2 class="menuTitle" onclick="menuShow(&#39;menutwo&#39;)" id="menutwo_t"><b></b>会员互动</h2>
        <ul id="menutwo">
        	<li class="icon mystow"><a href="http://www.jj59.com/member/mystow.php"><b></b>我的收藏夹</a></li>
			<li class="icon feedback"><a href="http://www.jj59.com/member/myfeedback.php"><b></b>我的评论</a></li>
                </ul>
		  <!--其他管理-->
	
	 <h2 class="menuTitle" onclick="menuShow(&#39;menuThird&#39;)" id="menuThird_t"><b></b>其他管理</h2>
        <ul id="menuThird">
        	<li class="icon attachment"><a href="http://www.jj59.com/member/uploads.php"><b></b>附件管理</a></li>
			<li class="icon attachment"><a href="http://www.jj59.com/23/fbsm.html" title="发表文章说明" target="_blank"><b></b>发表说明</a></li>
			<li class="icon attachment"><a href="http://www.jj59.com/23/zdpb.html" title="文章排版工具" target="_blank"><b></b>排版工具</a></li>
        </ul>
      	<!-- 我的织梦菜单-->
		<h2 class="menuTitle" onclick="menuShow(&#39;menufour&#39;)" id="menufour_t"><b></b>常见问题</h2>
          <ul id="menufour">
        <li class="ask"><a href="http://www.jj59.com/23/fbsm.html#3" target="_blank">文章审核需多久？</a></li>
        <li class="ask"><a href="http://www.jj59.com/23/fbsm.html#2" target="_blank">文章审核的标准？</a></li>
		<li class="ask"><a href="http://www.jj59.com/23/fbsm.html#3" target="_blank">文章为何被退回？</a></li>
    	</ul>
     
      	<!-- 系统设置菜单-->
      
        
            
        <!--<h2 class="menuTitle"><b class="showMenu"></b>操作主菜单项</h2> -->
      </div>
      <div class="buttomGr"></div>
    </div>
        <!--左侧操作菜单项 -->    <div id="mcpmain">
      <div id="appTab">
        <ul>
          <li class="thisTab"><a href="http://www.jj59.com/member/article_add.php#"><span>发表普通文章</span></a></li>
        </ul>        
       </div>
      <form name="addcontent" action="./发表普通文章 - 会员中心 - 九九文章网_files/发表普通文章 - 会员中心 - 九九文章网.html" method="post" enctype="multipart/form-data" onsubmit="return checkSubmit();">
          <input type="hidden" name="dopost" value="save">
          <input type="hidden" name="channelid" value="1">
      <div id="mainCp">
        <h3 class="meTitle"><strong>发表普通文章</strong></h3>
        <div class="postForm">
          <p class="cellBg">
            <label>标题：</label>
            <input name="title" type="text" id="title" value="请输入内容标题" maxlength="100" class="intxt" onfocus="inputAutoClear(this)">　　<span style="color:#F00">*</span>
          </p>
         <!-- <p>
            <label>标签TAG：</label>
            <input name="tags" type="text" id="tags" maxlength="100" class="intxt"/>
          </p>
		  -->
          <p class="cellBg">
           <label>来源：</label>
           <input type="text" name="source" id="source" value="原创" maxlength="100" class="intxt" style="width:119px; line-height:18px;">　　　<span style="font-size:12px; line-height:15px;">转载的请注明。并在<a href="http://www.jj59.com/23/zdpb.html" target="_blank">排版工具</a>第九条，搜索本站是否存在</span>
          </p>		  
		  <p class="cellBg">
            <label>作者：</label>
            <input type="text" name="writer" id="writer" value="xdzbb" maxlength="100" class="intxt" style="width:219px">
          </p>
		  
          <p>
            <label>所属栏目：</label>
            <select name="typeid" size="1">
<option value="0" selected="">请选择栏目...</option>
<option value="111" class="option2">文章</option>
<option value="77" class="option3">──经典语录</option>
<option value="39" class="option3">─情感文章</option>
<option value="46" class="option3">─伤感文章</option>
<option value="58" class="option3">─心情文章</option>
<option value="64" class="option3">─人生哲理</option>
<option value="73" class="option3">──人生感悟</option>
<option value="65" class="option2">─励志文章</option>
<option value="71" class="option3">──学习成功</option>
<option value="70" class="option3">──励志文章</option>
<option value="48" class="option2">─爱情文章</option>
<option value="49" class="option3">──爱情文章</option>
<option value="50" class="option3">──恋爱文章</option>
<option value="63" class="option3">─搞笑文章</option>
<option value="119" class="option3">──笑话</option>
<option value="121" class="option3">─亲情文章</option>
<option value="45" class="option2">伤感文章</option>
</select>            <span style="color:#F00">*</span>(不能选择带颜色的分类)
          </p>
          <p class="cellBg">
            <label>我的分类：</label>
            <select name="mtypesid" size="1">
<option value="0" selected="">请选择分类...</option>
</select>            <a href="http://www.jj59.com/member/mtypes.php">添加分类</a>
          </p>
          <p>
            <label>信息摘要：</label>
            <textarea name="description" id="description"></textarea>(内容的简要说明)
          </p>
         <!-- <p class="cellBg">
            <label>缩略图：</label>
            <input name="litpic" type="file" id="litpic" onchange="SeePicNew('divpicview',this);"  maxlength="100" class="intxt"/>
          </p-->
      <input type="hidden" name="dede_addonfields" value="">
    </div>
        <!-- 表单操作区域 -->
        <h3 class="meTitle">详细内容</h3>
		<span style="line-height:20px;">（请使用<strong>规范的标点符号</strong>,尽量不要使用繁体字，<span class="STYLE1">格式杂乱的文章</span>将<strong>不被审核通过</strong>。文章排版推荐使用本站<a href="http://www.jj59.com/23/zdpb.html" target="_blank">自动排版工具</a>。<span class="STYLE1">每天发表不得超过2篇文章</span>，多余的文章将不予审核。详情看<a href="http://www.jj59.com/23/fbsm.html" target="_blank"><span class="STYLE1"><u>发表说明</u></span></a>)
				<font color="#FF0000">用手机发表文章的作者，可以用<font color="#0000FF">&lt;br&gt;</font>来表示换行!</font></span>
        <div class="contentShow postForm">
          <p>
          	<input type="hidden" id="body" name="body" value="" style="display:none"><input type="hidden" id="body___Config" value="FullPage=false" style="display:none"><iframe id="body___Frame" src="./发表普通文章 - 会员中心 - 九九文章网_files/fckeditor.html" width="100%" height="350" frameborder="0" scrolling="no"></iframe>          </p>
                <p class="cellBg">
            <label>验证码：</label>
            <input name="vdcode" type="text" id="vdcode" maxlength="100" class="intxt" style="width:50px;text-transform:uppercase;">
            <img src="./发表普通文章 - 会员中心 - 九九文章网_files/vdimgck.php" alt="看不清？点击更换" align="absmiddle" style="cursor:pointer" onclick="this.src=this.src+&#39;?&#39;"></p>
            <p>
             <button class="button2" type="submit">提交</button>
             <button class="button2 ml10" type="reset" onclick="location.reload();">重置</button><font style="color:#FF0000;
				  margin-left:50px;font-weight:bold;">友情提示:发表文章时，请先备份好您的文章，以免发表失败而丢失文章！</font>
      </p>
        </div>
      </div>
      </form>
      <!--主操作区域 -->
    </div>
  </div>
<script language="javascript" type="text/javascript">
	window.onload=function (){
		setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
	}
</script>

<div id="footer">
  <div class="fLeft">Copyright &#169; 2008-2011 九九文章网  版权所有  管理员QQ：782841080</div>
  <div id="time" class="fRight">Wed Dec 25 2013 09:41:31 GMT+0800 (CST) 星期三</div>
</div>
</div>