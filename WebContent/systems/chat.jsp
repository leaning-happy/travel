<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>聊天</title>
<style type="text/css">
.chat{
position:fixed;
width:auto;
height:70%;
right:0px;
bottom:0px;
border:solid 1px blue;}
.content{
overflow:auto;
width:500px;
height:95%;
white-space:pre-wrap;
word-break: break-all;
word-wrap: break-word;
background-color:rgba(230,230,230,0.4);
}
.send{
height:5%;}
.sendf{
height:100%;}
.sendb{
display:inline-block;
width:80px;
float:right;
height:100%;}
.sendt{
border:none;
width:420px;
height:100%;}
</style>
<!--  
<script>
function chgDiv(){
var divx=document.getElementById("div1");
divx.innerHTML="<html><%if(request.getSession().getAttribute("chat")!=null){%>
<%=request.getSession().getAttribute("chat") %><%}%></html>";
}
window.setInterval(chgDiv,1000); 
</script>
-->
</head>
<body>
<div class="chat">
<div class="content" id="div1">
<% if(request.getSession().getAttribute("chat")!=null){%>
<%=request.getSession().getAttribute("chat") %><%} %>
</div>
<div class="send">
<form action="<%=request.getContextPath()%>/servlets/ChatServlet" method="post" class="sendf">
<input type="text" class="sendt" name="words"></input>
<input type="submit" class="sendb" value="发送消息 "></input>
</form>
</div>
</div>
</body>
</html>