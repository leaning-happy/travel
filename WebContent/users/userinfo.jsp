<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>个人信息</title>
<style type="text/css">
.shenfen {
    position:absolute;
    top:11.5em;
    left:2em;
    right:2em;
    align:center;
    padding:0 0 0 1em;
    margin:0;
    list-style:none;
    height:80%;
    background-repeat:round;
    background-color:rgba(225,233,220,1);
}
.shenfen ul{
    list-style:none;
    width:20em;
    height:25em;
    padding:0 0 0 1em;
    float:left;
    color:rgba(23,44,60,1);
    }
.kongtu{
    letter-spacing:2em;
    }
.touxiang{
position:absolute;
top:3.5em;
left:0em;
right:0em;
align:center;
padding:0 0 0 1em;
margin:0;
list-style:none;
height:8em;
background-color:rgba(167,220,224,0.6);
color:red;
}
.touxiang img{
    border-radius:50%;}
.main{
width:6em;
position:absolute;
left:10%;
top:1em;
}
input{
border:none;
background-color:rgba(225,233,220,1);
margin:0 0 0 1em;}
input:focus{
border:solid 1px black;
}
.shenfen li{
height:1em;
padding:1em 1em 1em 1em;
font-size:1.2em;}
input[type="submit"]{
display:block;
background-color:rgba(1,77,103,0.3);
border:solid 2px rgba(151,151,151,1);
border-radius:3px;
cursor:pointer;
font-size:1.1em;
}
</style>
</head>
<body>
<div class="touxiang">
<img src="../image/touxiang1.jpg" alt="我的头像" class="main"/>
</div>
<div class="shenfen">
<form action="../servlets/ChangeInformationServlet" method="post">
<ul>
<li><span class="kongtu">昵</span>称:<input type="text" value="${list.name}" name="name"></input></li>
<li><span class="kongtu">性</span>别:<input type="text" value="${list.sex}" name="sex"></input></li>
<li><span class="kongtu">年</span>龄:<input type="text" value="${list.age }" name="age"></input></li>
<li>个性签名:<input type="text" value="${list.write }" name="write"></input></li>
<li><input type="submit" value="修改"></input></li>
</ul>
</form>
</div>
</body>
</html>