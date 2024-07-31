<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>在此处插入标题</title>
<link href="../CSS/topnormal.css" type="text/css" rel="stylesheet"/>
<style type="text/css">
.menu {
    background-image:none;
    background-color:rgba(214,200,75,1);
    border:solid,0.1em;
    border-radius:0.1em;
    }
.logo{
background-color:rgba(38,188,213,1);
background-image:none;
border:solid,0.1em;
border-radius:0.1em;
}
</style>
<script>
</script>
</head>
<body>
<ul class="logo">
<li><a href="../index.jsp">返回首页</a></li>
<li>${list.name}</li>
</ul>
<ul class="menu">
<li class="current"><a href="user.jsp">基本信息</a></li>
<li class="current1"><a href="security.jsp">账户安全</a></li>
<li class="current2"><a href="<%=request.getContextPath()%>/servlets/CheckTeamServlet">旅游安排</a></li>
<li class="current3"><a href="<%=request.getContextPath()%>/servlets/ShowHistoryServlet">最近浏览</a></li>
</ul>
</body>
</html>