<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>游览历史</title>
<style type="text/css">
.menu li.current3 a {
    background-image:url(../image/left3.gif);
    background-repeat:no-repeat;
    background-size:100% 100%;
}
.his{
position:absolute;
top:3.5em;
left:0.1em;
right:0.1em;
background-color:rgba(167,220,224,0.6);}
ul{
list-style:none;}
</style>
</head>
<body>
<jsp:include flush="true" page="topy.jsp" /><br/>
<div class="his">
<ul>
<c:forEach items="${history}" var="pat">
<li>
时间：<span>${pat.time}</span>
景点：<span>${pat.slight}</span><br/>
</li></c:forEach>
</ul> 
</div>
</body>
</html>