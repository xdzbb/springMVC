<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<link type="text/css" rel="stylesheet" href="resource/css/login.css">
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<body>
	<div class="header">
		<div class="auto960">
			<ul class="userMenu fRight">
				<li><a href="../" title="网站主页">网站主页</a></li>
				<li><a href="../member/index_do.php?fmdo=user&dopost=regnew"
					title="注册">注册</a></li>
				<li><a href="../member/login.php" title="登录">登录</a></li>
				<li class="help"><a href="../23/help/" title="九九文章网 帮助中心">帮助</a>
				</li>
			</ul>
			<span> <script type="text/javascript">
				var now = (new Date()).getHours();
				if (now > 0 && now <= 6) {
					document.write("午夜好，");
				} else if (now > 6 && now <= 11) {
					document.write("早上好，");
				} else if (now > 11 && now <= 14) {
					document.write("中午好，");
				} else if (now > 14 && now <= 18) {
					document.write("下午好，");
				} else {
					document.write("晚上好，");
				}
			</script><i class="green">游客</i> 你可以选择到
			</span>
		</div>
	</div>
	<div class="wrapper">
		<div class="logo fLeft">
			<a href="../member/"> <img src="resource/images/login_logo.gif"
				alt="会员中心" style="margin:8px 0 0 25px;">
			</a>
		</div>
	</div>
	<div id="login" class="bor">
		<div class="stip1"></div>
		<div class="theme fLeft">
			<form id="regUser" name="form2" action="user.do" method="post"
				onsubmit="return checkform();">
				<input type="hidden" name="dopost" value="regbase"> <input
					type="hidden" name="step" value="1"> <input type="hidden"
					name="mtype" value="个人">
				<p class="mB10" style="text-align: right;"></p>
				<ul>
					<li class="mL68">(带 <i class="red"> * </i>
						号的表示为必填项目，用户名必须大于3位小于20位，密码必须大于3位)
					</li>
					<li><span>帐号类型：</span> <label> <input
							class="usermtype" type="radio" checked="" value="个人" name="mtype">
							个人
					</label></li>
					<li><span>用户名：</span> <input id="username" class="intxt w200"
						type="text" name="username" alt="请输入用户名" minlength="1"
						maxlength="100"> <i class="red">*</i> <em id="_userid">(可以使用中文，但禁止除[@][.]以外的特殊符号)</em>
					</li>
					<li><span id="nickname">用户笔名：</span> <input id="nickname"
						class="intxt w200" type="text" name="nickname" size="20"
						alt="请输入笔名" minlength="1" maxlength="100"> <i class="red">*</i>
						<em id="_uname"> </em></li>
					<em id="_uname"> <script type="text/javascript">
						function checkPwd() {
							if ($("#password").val() == $("#newpassword").val()) {
								alert(1);
							}
						}
					</script>
						<li><span>登陆密码：</span> <input id="password"
							class="intxt w200" type="password" name="password"
							style="font-family: verdana;" alt="请输入密码" minlength="1"
							maxlength="100"> <i class="red">*</i></li>

						<li><span>确认密码：</span> <input id="newpassword"
							class="intxt w200" type="password" name="newpassword" value=""
							alt="请再次输入密码" minlength="1" maxlength="100" size="20"> <i
							class="red">*</i> <em id="_userpwdok"> <font color="red">
									<b>(请保持密码一致)</b>
							</font>
						</em></li>
						<li><span>电子邮箱：</span> <input id="email" class="intxt w200"
							type="text" name="email" alt="请输入电子邮箱" minlength="1"
							maxlength="100"> <i class="red">*</i> <em id="_email">(每个电子邮邮箱只能注册一个帐号)</em>
					</li>

						<li><span>性别：</span> <input type="radio" name="sex" value="0">
							男 <input type="radio" name="sex" value="1"> 女 <input
							type="radio" name="sex" value="" checked="checked"> 保密</li>

						<li><span>电话号码：</span> <input id="tel" class="intxt w200"
							type="text" name="tel" alt="请输入电话号码" minlength="1"
							maxlength="100"> <i class="red">*</i> <em id="tel">(请填写真实的手机号码)</em>
					</li>
						<li><span>验证码：</span> <input name="vdcode" type="text"
							id="vdcode" alt="请输入验证码" minlength="1" maxlength="100" class="intxt" style="width:50px;">
							<img src="ValidateCode.do?t=<%=new Date().getTime()%>"
							alt="看不清？点击更换" align="absmiddle" style="cursor:pointer"
							onclick="javascript:this.src='ValidateCode.do?'+ Math.random()" /></li>
					</em>
				</ul>
				<em id="_uname">
					<div>
						<span class="fLeft" style="height: 110px; width: 15%;">会员注册协议：</span>
						<div class="contract">
							1、在本站注册的会员，必须遵守《互联网电子公告服务管理规定》，不得在本站发表诽谤他人，侵犯他人隐私，侵犯他人知识产权，传播病毒，政治言论，商业讯息等信息。
							<br>
							2、在所有在本站发表的文章，本站都具有最终编辑权，并且保留用于印刷或向第三方发表的权利，如果你的资料不齐全，我们将有权不作任何通知使用你在本站发布的作品。
							<br>
							3、在登记过程中，您将选择注册名和密码。注册名的选择应遵守法律法规及社会公德。您必须对您的密码保密，您将对您注册名和密码下发生的所有活动承担责任。
						</div>
					</div> <br>
					<ul>
						<li><span> </span> <input id="agree" type="checkbox"
							name="agree" value="" checked="" style="margin-left: 130px;">
							我已阅读并完全接受服务协议</li>
						<li><span> </span>
							<button id="btnSignCheck" class="buttonGreen142" type="submit">完
								善 信 息</button></li>
					</ul>
				</em>
			</form>
		</div>
		<em id="_uname"> <br class="clear">
		</em>
	</div>
	<em id="_uname"> <script type="text/javascript"
			language="javascript">
		window.onload = function() {
			setInterval(
					"document.getElementById('time').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",
					1000);
		}
	</script>
		<div class="footer bor">
			<div class="fLeft mL10">Copyright © 2002-2010 www.jj59.com
				九九文章网 版权所有</div>
			<div id="time" class="fRight mR10">2013年12月24日 星期二 17时27分14秒
				星期二</div>
		</div>
	</em>
</body>
</html>
