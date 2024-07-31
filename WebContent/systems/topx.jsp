<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="users.Customer"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>在此处插入标题</title>
<link href="../CSS/topnormal.css" type="text/css" rel="stylesheet"/>
<style type="text/css">
.menu {
    background-color:rgba(179,168,150,1);
    border:solid,0.1em;
    border-radius:0.1em;
    }
.logo{
background-color:rgba(250,218,141,1);
background-image:none;
border:solid,0.1em;
border-radius:0.1em;
}
</style>
</head>
<body>
<ul class="logo">
<%Customer user=(Customer) request.getSession().getAttribute("list");
if(user==null){%>
<li><a href="../users/login.jsp">登录</a></li>
<li><a href="../users/reg.jsp">注册</a></li><%}else{%>
<li><a href="<%=request.getContextPath() %>/servlets/OutServlet">退出登录</a></li>
<%if("customer".equals(user.getType())){%>
<li><a href="../users/user.jsp">个人中心</a></li><%}else{%>
<li><a href="#">管理员账号管理</a></li><%}}%>
</ul>
<ul class="menu">
<li class="current"><a href="index.jsp">首页</a></li>
<li class="current1"><a href="showall.jsp">旅游景点</a></li>
<li class="current2"><a href="teamhold.jsp">组队信息</a></li>
<!-- <li class="current3"><a href="hotel.jsp">住宿推荐</a></li>-->
<li class="current4"><a href="way.jsp">旅游路线推荐</a></li>
</ul>
</body>
</html>