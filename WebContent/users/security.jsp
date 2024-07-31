<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>安全设置</title>
<style type="text/css">
.menu li.current1 a {
    background-image:url(../image/left3.gif);
    background-repeat:no-repeat;
    background-size:100% 100%;
}
#button{
cursor:pointer;}
.safe{
background-color:rgba(167,220,224,0.6);
height:60%;
position:absolute;
top:3.5em;
right:1%;
left:1%;
}
.safe .safe1{
list-style:none;
font-size:1.25em;
line-height:1.3em;
color:green;
margin-top:1em;
margin-left:1em;
}
input{
border:none;
background-color:rgba(167,220,224,0.6);
margin:0 0 0 1em;
height:1.3em;}
.button{
background-color:rgba(28,120,135,0.3);
margin-top:1em;
margin-left:2em;
font-size:1em;
line-height:1em;
padding:0;}
span{
letter-spacing:2em;}
#form{
display:none;}
</style>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("button").click(function() {                    
		$("#form").slideToggle();                
		});
});
function check1()
{
	
	if ((document.form3.opassword.value == "")||(document.form3.password.value == "" ) )  
	{
		alert("密码不能为空!");
		document.form3.opassword.focus();
		return false;
	}
	var pwdreg=/[^\d]/
	if (!pwdreg.test(document.form3.opassword.value )||!pwdreg.test(document.form3.password.value ) )  
	{
		alert("密码必须包含特殊字符!");
		document.form3.opassword.focus();
		return false;
	}
	if (document.form3.nppassword.value == ""  )  
	{
		alert("确认密码不能为空!");
		document.form3.nppassword.focus();
		return false;
	}
	if (document.form3.nppassword.value != document.form3.password.value  )  
	{
		alert("两次密码不一致!");
		document.form3.nppassword.focus();
		return false;
	}
}
function check2()
	{	
	if (document.form2.phonenumber.value != ""  ){
	if (!/\d{11}/.test(document.form2.phonenumber.value )  )
	{
		alert("请输入正确的手机号码!");
		document.form2.phonenumber.focus();
		return false;
	}}
}
function check3()
{	
	if (document.form1.mail.value == ""  )  
	{
		alert("电子邮箱不能为空!");
		document.form1.email.focus();
		return false;
	}
	var emailreg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
	if (!emailreg.test(document.form1.mail.value )  )  
		{
			alert("请输入正确的电子邮箱!");
			document.form1.email.focus();
			return false;
		}
}
</script>
</head>
<body>
<jsp:include flush="true" page="topy.jsp" /><br/>
<div class="safe">
<form class="safe1" action="../servlets/ChangeMailServlet" method="post" onsubmit="return check3()" name="form1">
<span>邮</span>箱<input type="text" name="mail" value="${list.mail}"></input>
<input id="button" type="submit" value="确认修改"></input></form>
<form class="safe1" action="../servlets/ChangePhoneServlet" method="post" onsubmit="return check2()" name="form2">
电话号码<input type="text" name="phonenumber" value="${list.phonenumber}"></input>
<input id="button" type="submit" value="确认修改"></input></form>
<button id="button" class="button">修改密码</button>
<form class="safe1" action="../servlets/ChangePasswordServlet" method="post" id="form" onsubmit="return check1()" name="form3">
初始密码<input type="password" name="opassword"></input><br/>
新的密码<input type="password" name="password"></input><br/>
确认密码<input type="password" name="nppassword"></input><br/><br/>
<input id="button" type="submit" value="确认修改"></input>
</form>
</div>
</body>
</html>