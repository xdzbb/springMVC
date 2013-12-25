function checkSubmit()
{

	
	if(document.addcontent.title.value==""){
		alert("名称不能为空！");
		document.addcontent.title.focus();
		return false;
	}
	
	if(document.addcontent.title.value=="请输入内容标题"){
		alert("标题不能为空，请输入内容标题！");
		document.addcontent.title.focus();
		return false;
	}
	
	if(document.addcontent.title.value=="无题"){
		alert("标题不能无题！");
		document.addcontent.title.focus();
		return false;
	}
	
     if(document.addcontent.title.value.length<2 || document.addcontent.title.value.length>20){
		alert("标题不能少于2个字,多于20个字");
		document.addcontent.title.focus();
		return false;
	}
	if(!isNaN(document.addcontent.title.value)){  
		alert("标题不能是纯数字！");
		document.addcontent.title.focus();
		return false;
	}  
	
	/*var title = /[_a-zA-Z]/;
	if(title.test(document.addcontent.title.value))
	{
		alert("标题不允许用字母！");
		return false;
	}*/


	if(document.addcontent.typeid.value==0){
		alert("隶属栏目必须选择！");
		return false;
	}

	if(document.addcontent.typeid.options && document.addcontent.typeid.options[document.addcontent.typeid.selectedIndex].className!='option3')
	{
		alert("隶属栏目必须选择白色背景的项目！");
		return false;
	}

	if(document.addcontent.vdcode.value==""){
		document.addcontent.vdcode.focus();
		alert("验证码不能为空！");
		return false;
	}

}