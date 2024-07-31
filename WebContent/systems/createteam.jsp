<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>创建组队</title>
</head>
<body>
<div><span>创建组队</span>
<a href="<%=request.getContextPath()%>/servlets/CheckTeamServlet">个人组队</a><br/>
<form action="<%=request.getContextPath()%>/servlets/CreateTeamServlet" method="post">
队长名<input name="teamholder" value="${name}"></input><br/>
出发省份<input name="startcon"></input><br/>
具体出发地点<input name="startdetialcon"></input><br/>
到达省份<input name="endcon"></input><br/>
具体到达地点<input name="enddetialcon"></input><br/>
最大人数<input name="maxnum"></input><br/>
出发时间<input name="starttime"></input><br/>
<input type="submit" value="创建组队"></input>
</form>
</div>
</body>
</html>