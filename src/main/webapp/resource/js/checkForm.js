var navigate=0;
var index=1;
var regexphone="^[0-9]{11,11}$";
var regexemail="^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$";
var regenum="^[0-9]*$";
//begin js验证功能
function minlength(obj){
	var value = obj.val().replace(/(^\s*)|(\s*$)/g, "");
	var min_len = obj.attr('minlength');
	var alt = obj.attr('alt');
	if(value.length<min_len){
		if(min_len == 1){
			alert(alt+"不能为空");
			obj.focus();
			return false;
		}
		alert(alt+"少于规定的最小长度"+min_len);
		obj.focus();
		return false;
	}
	return true;
}
function regex(obj){
	var value = obj.val().replace(/(^\s*)|(\s*$)/g, "");
	var regular = obj.attr('regex').replace(/(^\s*)|(\s*$)/g, "");
	var alt = obj.attr('alt');
	var regex = new RegExp(regular);
	if((!regex.test(value))&&(value.length>0)){
      		alert(alt+"无效！");
   		obj.focus();
		return false;
   	}
	return true;
}
function checklength(){
	var list=$("form :input[minlength]");
	var ret = true;	
	list.each(function(i){	
		if(!minlength($(this))) {
			ret = false;
			return false;
		}
	});
	return ret;
}
function checkregex(){
	var list=$("form :input[regex]");
	var ret = true;	
	list.each(function(i){
		if(!regex($(this))) {
			ret = false;
			return false;
		}		
	});
	return ret;
}
/*
使用方法,在需要验证的input中添加属性minlength,alt为提示对象名称，当minlength=1表示非空验证；需要正则验证时,添加regex属性，内容为正则表达式，alt属性为提示对象名称；在表单form提交的onsubmit事件中添加return checkform();
*/
function checkform(){	
	return checklength() && checkregex();
}
//end js验证

//begin js标签切换功能
function scroll(nav,content,i){	
	$("."+nav+" a").removeClass("on");
	$("."+nav+" a").eq(i).addClass("on");	
	$("."+content).hide();
	$("."+content).eq(i).show(); 	
}
function scrollthenav(nav,content,obj){
        var i=$("."+nav+" a").index($(obj));	
        scroll(nav,content,i);
} 
/*
使用方法，提供切换tab功能的函数nav表示标签导航div的class，导航的标签用<a>罗列出来，content表示标签内容对应div的class;i表示开始默认显示的tab;结构如
<div class=nav>
	<a href="#">tab1</a><a href="#">tab2</a><a href="#">tab3</a>
</div>
<div class=content>content1</div>
<div class=content>content2</div>
<div class=content>content3</div>
调用方式在javascript代码中调用，beginscroll(nav,content,0);
*/
function beginscroll(nav,content,i){
	$("."+nav+" a").mouseover(function(){scrollthenav(nav,content,this)});
	$(function(){scroll(nav,content,i);});
}
//end js标签切换功能
//通用的发送ajax请求函数,parameters形式如下:(userid:$userid,orgid:$orgid)键值对的形式。
function reload() {
	setTimeout(function(){
		window.location.reload();
	},1000);
}
//全选，反选，取消
function multioptions(type,name){	
	switch(type){
	case 1://全选
		$("input[name='"+name+"']").each(function(){  
	        this.checked=true;  
	    });
		break;
	case 2://取消
		$("input[name='"+name+"']").each(function(){  
		        this.checked=false;  
		    });
		break;	
	case 3://反选		
		$("input[name='"+name+"']").each(function(){
			   $(this).attr("checked",!this.checked);              
			});
		break;
	default:	
		break;
	}	
}
//取值
function getmultivalues(name){  
    var str="";  
    $("input[name='"+name+"']:checked").each(function(){  
        str+=$(this).val()+",";  
    });   
    str = str.substr(0,str.length-1);
    return str;  
}  
//link需要携带参数
function getAjax(link,title){
	$.get(
		"index.php?"+link,		
		function(xml){		
			var message=xml.lastChild.firstChild.nodeValue;			
			if(message==0){
				$.dialog.box('getAjax', title, '操作成功!');
				reload();
			}else{
				$.dialog.box('getAjax', title, message);
			}
		}
	);
	return false;
}
//end
function resetControl() {
    var obj = null;
    for (var i = 0; i <= document.uploadform.elements.length - 1; i++) {
        obj = document.uploadform.elements[i];
        if (obj.tagName == "INPUT" && obj.type == "text") {
            obj.setAttribute("value", "");
        }
        if (obj.tagName == "INPUT" && obj.type == "checkbox") {
            obj.setAttribute("checked", false);
        }

        if (obj.tagName == "SELECT") {
            obj.options[0].selected = true;
        }
        if(obj.tagName == "TEXTAREA"){
        	obj.setAttribute("value","");
        }
    }
    return false;
}

function setheader(url){
	window.location.href=url; 
}


/**
 * @author httpd4
 * @desc flash 文件上传
 * @param (Object)
 * 		  paramReg 上传基本参数注册
 * @param (Object)
 * 		  contrReg 站内业务参数注册
 */
function uploadify(paramReg,contrReg){
	var paramReg  = paramReg?paramReg:{};
	var contrReg  = contrReg?contrReg:{};
	var uploadify = {};
	var auto 	  = paramReg.auto==true?true:false;//是否自动提交
	var debug     = paramReg.debug==true?true:false;//是否开启debug调试
	var hide      = paramReg.hide==true?true:false;//上传完成后是否隐藏文件域
	var swf  	  = paramReg.swf?paramReg.swf:'js/uploadify/uploadify.swf';//flash路径
	var uploader  = paramReg.uploader?paramReg.uploader:'index.php?ajax-upload';////上传基本路径
	var fileme	  = paramReg.file?paramReg.file:'file_upload';//file对象
	var fname	  = paramReg.fname?paramReg.fname:'picture';//file字段名供服务端处理用
	var width	  = paramReg.width?paramReg.width:150;//上传按钮的宽
	var height	  = paramReg.height?paramReg.height:40;//上传按钮的高
	var text      = paramReg.text?paramReg.text:'选择图片';//按钮文字
	var size      = paramReg.size;//文件大小限制
	var exts      = paramReg.exts;//文件类型限制
	var method    = paramReg.m?paramReg.m:'post';//上传方式
	var limit     = paramReg.limit?paramReg.limit:1;//上传个数限制
	var ori		  =	paramReg.ori?true:false;//是否保持uploadify的原样，即使用原始模板
	var qlimit    = paramReg.qlimit?paramReg.qlimit:999;
	var tpl		  = paramReg.tpl?paramReg.tpl:false;
	var task_id   =	parseInt(contrReg.task_id)+0;
		
		uploadify.auto			  =	auto;
		uploadify.debug			  =	debug;
		uploadify.removeCompleted =	hide;
		uploadify.swf			  =	swf;
		uploadify.uploader		  = uploader;
		uploadify.fileObjName	  =	fname;
		uploadify.fileSizeLimit	  =	size;
		uploadify.fileTypeExts	  =	exts;
		uploadify.uploadLimit     = limit;
		uploadify.queueSizeLimit  = qlimit;
		uploadify.method		  = method;
		uploadify.width			  = width;
		uploadify.height		  = height;
		uploadify.buttonText	  = text;
		if(!ori){//这里可以控制模板的选择和输出
			uploadify.itemTemplate = '<div id="$#fileID#" class="uploadify-queue-item">\
				<div class="cancel">\
					<a href="javascript:$(\'#$#instanceID#\').uploadify(\'cancel\', \'$#fileID#\')">X</a>\
				</div>\
				<span>$#fileName#</span><input class="$#fileID# filedesc" value="请输入图片描述..."/> <span>($#fileSize#)</span><span class="data"></span>\
			</div>';
			tpl&&(uploadify.itemTemplate=tpl);
		}
		/**
		 * onUploadStart这个函数是核心，用来定义前端网站需要处理的业务逻辑
		 * 接受两个合法函数getSwfValues，getTplValues用来根据不同模板需求来获取相关
		 * html元素的值，可以将需要提交的值以{'key':'value'}的形式返回，方便服务端处理，
		 * 目前只注册了这两个函数，后期可以添加或者扩展；也可以直接接受contrReg里面的key-value
		 */
		uploadify.onUploadStart = function(file){
			var allData = [];
			if(typeof(contrReg.getSwfValues)=='function'){
				var swfObj= contrReg.getSwfValues(file);
				allData.push(swfObj);
			}
			if(typeof(contrReg.getTplValues)=='function'){
				var tplObj= contrReg.getTplValues();
				allData.push(tplObj);
			}
			if(typeof(contrReg.validatefunc)=='function'){
				var validate= contrReg.validatefunc(file);
				if(!validate)
					$("#"+fileme).uploadify('stop');
			}
			allData.push(contrReg);
			var formData = {
					'fname':fname,
					'PHPSESSID':xyq,
					'timestamp':timestamp,
					'token':token,
				};
			for(var Index in allData){
				if(typeof(allData[Index])=='object'){
					for(var nextIndex in allData[Index]){
						typeof(allData[Index][nextIndex])!='function'&& (formData[nextIndex] = allData[Index][nextIndex]);
					}
				}else if(typeof(allData[Index])!='function'&&typeof(allData[Index])!='object'){
					formData[nextIndex] = allData[Index];
				}
			}
			$("#"+fileme).uploadify('settings','formData',formData);
		};
		uploadify.onUploadSuccess =	function(file, data, response) {
			$('.uploadify-success').show().html(data);
		};
	$("#"+fileme).uploadify(uploadify);
}
function checklogin(userid){	
	if(userid!=null && userid!="0" && userid!=""){		
		return true;
	}else{
		if(confirm("登录用户才能做此操作，你要立即登录吗？"))			
			mdaxue.login();		
		return false;
	}	
}