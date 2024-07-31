<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript">
	function checkLogin(){
		var flag=true;
		var name=document.getElementById("name").value;
		var pwd=document.getElementById("pwd").value;
		if(""==name){
			alert("账号不能为空！");
			flag=false;
			return false;
		}else if(""==pwd){
			alert("密码不能为空！");
			flag=false;
			return false;
		}if(flag==true){
			return true;
		}
	}
</script>
<style type="text/css">
	/*统一页面字体和大小*/
	body {
	    font-family:"Lucida Grande", "Lucida Sans Unicode", Verdana, Arial, Helvetica, sans-serif;
	    font-size:12px;
	}
	/*清除常用元素的边界、补白、边框默认样式*/
	p, h1, form,button{
	    border:0;
	    margin:0;
	    padding:0;
	}
	/*定义一个强制换行显示类*/
	.spacer {
	    clear:both;
	    height:1px;
	}
	/*定义表单外框样式*/
	.myform {
	    margin:0 auto;
	    width:400px;
	    padding:14px;
	}
	/*定制当前表单样式*/
	#stylized {
	    border:solid 2px #b7ddf2;
	    background:#ebf4fb;
	}
	/*设计表单内div和p通用样式效果*/
	#stylized h1 {
	    font-size:14px;
	    font-weight:bold;
	    margin-bottom:8px;
	}
	#stylized p {
	    font-size:11px;
	    color:#666666;
	    margin-bottom:20px;
	    border-bottom:solid 1px #b7ddf2;
	    padding-bottom:10px;
	}
	#stylized label {/*定义表单标签样式*/
	    display:block;
	    font-weight:bold;
	    text-align:right;
	    width:140px;
	    float:left;
	}
	/*定义小字体样式类*/
	#stylized .small {
	    color:#666666;
	    display:block;
	    font-size:11px;
	    font-weight:normal;
	    text-align:right;
	    width:140px;
	}
	/*统一输入文本框样式*/
	#stylized input {
	    float:left;
	    font-size:12px;
	    padding:4px 2px;
	    border:solid 1px #aacfe4;
	    width:200px;
	    margin:2px 0 20px 10px;
	}
	#stylized input[type="button"]{
	float:left;
    clear:both;
    margin:initial;
	    margin-left:150px;
	    width:125px;
	    height:31px;
	    background:#666666 url(images/button.png) no-repeat;
	    text-align:center;
	    line-height:31px;
	    color:#FFFFFF;
	    font-size:11px;
	    font-weight:bold;}
	/*定义图形化按钮样式*/
	#stylized button {
	    clear:both;
	    margin-left:150px;
	    width:125px;
	    height:31px;
	    background:#666666 url(images/button.png) no-repeat;
	    text-align:center;
	    line-height:31px;
	    color:#FFFFFF;
	    font-size:11px;
	    font-weight:bold;
	}
	/*设计表单内文本框和按钮在被激活和获取焦点状态下时，轮廓线的宽、样式和颜色*/
	input:focus, button:focus { outline: thick solid #b7ddf2 }
	input:active, button:active  { outline: thick solid #aaa }
	</style>
<title>登录</title>
</head>
<body>
	<div id="stylized" class="myform">
    <form id="form1" name="form1" method="post" action="<%=request.getContextPath() %>/servlets/LoginServlet">
        <h1>登录</h1>
        <p>请准确填写个人信息...</p>
        <label>Name <span class="small">用户账号</span> </label>
        <input type="text" name="acount" id="name"/>
        <label>Password <span class="small">密码</span> </label>
        <input type="password" name="password" id="pwd"/>
        <button type="submit" onclick="return checkLogin();">登 录</button>
        <input type="button" value="注册" onclick="location='reg.jsp'"/> 
        <div class="spacer"></div>
    </form>
</div>
</body>
</html>