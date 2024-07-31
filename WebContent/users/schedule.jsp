<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>旅游安排</title>
<style type="text/css">
.menu li.current2 a {
    background-image:url(../image/left3.gif);
    background-repeat:no-repeat;
    background-size:100% 100%;
}
ul{
list-style:none;
padding-left:0px;}
.sche{
position:absolute;
top:3.5em;
left:0.1em;
right:0.1em;
background-color:rgba(167,220,224,0.6);}
</style>
<script>
function select(r){
	window.location.href="<%=request.getContextPath() %>/servlets/DeleteScheduleServlet?id="+r;
}
</script>
</head>
<body>
<jsp:include flush="true" page="topy.jsp" /><br/>
<div class="sche">
<div class="had">
我的日程
<ul>
<c:forEach items="${teamlist}" var="pat">
<li>
队伍编号：<span>${pat.id}</span>
队长：<span>${pat.teamholder}</span><br/>
开始时间:<span>${pat.time}</span>
人数: ${pat.num} /<span>${pat.maxnum}</span><br/>
出发详细地点：<span>${pat.startdetial}</span><br/>
到达具体景点：<span>${pat.enddetial}</span><br/>
<a href="javascript:void(0);" onclick="select('${pat.id}')">删除日程</a>
</li></c:forEach>
</ul>
</div>
<div class="create">
<a href="../systems/createteam.jsp">创建日程</a>
</div>
</div>
</body>
</html>