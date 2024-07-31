<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="users.Customer"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>后台管理</title>
<% Customer user=(Customer) request.getSession().getAttribute("list");
if((user==null)||((user!=null)&&(!"admin".equals(user.getType())))){%>
<script>alert("请登录管理员账号后重试");window.navigate('../systems/index.jsp')</script><%}%>
</head>
<body>
管理员信息管理
<ul>
<li><a href="#">删除管理员</a></li>
</ul>
景点添加
</body>
</html>