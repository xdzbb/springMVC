function checkSubmit()
{

	
	if(document.addcontent.title.value==""){
		alert("���Ʋ���Ϊ�գ�");
		document.addcontent.title.focus();
		return false;
	}
	
	if(document.addcontent.title.value=="���������ݱ���"){
		alert("���ⲻ��Ϊ�գ����������ݱ��⣡");
		document.addcontent.title.focus();
		return false;
	}
	
	if(document.addcontent.title.value=="����"){
		alert("���ⲻ�����⣡");
		document.addcontent.title.focus();
		return false;
	}
	
     if(document.addcontent.title.value.length<2 || document.addcontent.title.value.length>20){
		alert("���ⲻ������2����,����20����");
		document.addcontent.title.focus();
		return false;
	}
	if(!isNaN(document.addcontent.title.value)){  
		alert("���ⲻ���Ǵ����֣�");
		document.addcontent.title.focus();
		return false;
	}  
	
	/*var title = /[_a-zA-Z]/;
	if(title.test(document.addcontent.title.value))
	{
		alert("���ⲻ��������ĸ��");
		return false;
	}*/


	if(document.addcontent.typeid.value==0){
		alert("������Ŀ����ѡ��");
		return false;
	}

	if(document.addcontent.typeid.options && document.addcontent.typeid.options[document.addcontent.typeid.selectedIndex].className!='option3')
	{
		alert("������Ŀ����ѡ���ɫ��������Ŀ��");
		return false;
	}

	if(document.addcontent.vdcode.value==""){
		document.addcontent.vdcode.focus();
		alert("��֤�벻��Ϊ�գ�");
		return false;
	}

}