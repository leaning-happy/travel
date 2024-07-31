<?xml version="1.0" encoding="UTF-8" ?>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>组队信息</title>
<style type="text/css">
.menu li.current2 a {
    background-image:url(../image/left3.gif);
    background-repeat:no-repeat;
    background-size:100% 100%;
}
.body{
position:absolute;
top:3.5em;
width:100%;
background:url("../image/1.jpg");
height:100%;}
.mainbody{
background-color:rgba(227,230,195,1);
width:900px;
margin:0 auto;
margin-right:500px;

}
a{
text-decoration:none;
color:black;}
ul{
list-style:none;
background-color:rgba(180,180,180,0.8);
padding-left:0;
margin:0;}
img{
float:left;
height:100%;
width:1em;}
.chat{
display:none;
position:fixed;
width:auto;
height:70%;
right:0px;
bottom:0px;
border:solid 1px blue;
}
.div1{
overflow:auto;
width:500px;
height:90%;
white-space:pre-wrap;
word-break: break-all;
word-wrap: break-word;
background-color:rgba(230,230,230,0.4);
}
.send{
display:flex;
height:5%;}
.sendf{
height:100%;
padding:0;
width:80%;}
.sendb{
width:20%;
height:100%;}
.sendt{
border:none;
width:420px;
height:100%;}
.showsend{
position:fixed;
right:0px;
bottom:0px;
width:500px;
height:2em;}
.hidesend{
width:500px;
height:2em;}
.buttom{
border:solid 1px rgba(23,50,7,0.6);
background-color:rgba(153,77,82,0.6);
margin-right:20px;
}
.me{
background-color:rgba(200,200,200,0.9);
}
.me2{
background-color:rgba(217,116,43,0.8);}
.me2 span{
display:block;
text-align:center;
border-bottom:solid 1px black;}
select{
height:2em;}
input{
height:2em;}
.hotteam{
background-color:rgba(280,180,80,0.8);}
.name{
font-size:0.6em;
color:rgba(10,100,100,0.8);}
.msg{
font-size:1em;
}
.chatmsg{
background-color:rgba(255,255,255,0.5);
border-radius:10px;
margin:1px 0 2px 0;}
</style>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$(".showsend").click(function() {  
		let flag=joinRoom();
		if(flag){
			$(".chat").slideToggle(); 
			$(".showsend").slideToggle(); 
		}
		});
	$(".hidesend").click(function() {                    
		$(".chat").slideToggle(); 
		$(".showsend").slideToggle(); 
		exitRoom();
		});
});

function select(r,p,q){
	var a=Number(p);
	var b=Number(q);
	if(a<b){
	window.location.href="<%=request.getContextPath() %>/servlets/AddScheduleServlet?id="+r;}
	else{
		alert("人数已满，无法加入");
	}
}

        var url = "ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/websocket/ChatS";
        var ws = null;
        //加入聊天室
        function joinRoom() {
            if (ws) {
                alert("你已经在聊天室，不能再加入");
                return false;
            }            
            if(!"${list.name}"){
            	alert("请登录后发送聊天");
            	return false;
            }
            else{//登陆后可以聊天
            	var username ="${list.name}";
                ws = new WebSocket(url+'?username='+username);
                //与服务端建立连接触发
                ws.onopen = function () {
                  console.log("与服务器成功建立连接")
                };
                //服务端推送消息触发
                ws.onmessage = function (ev) {
                    talking(ev.data);
                };

                //发生错误触发
                ws.onerror = function () {
                    console.log("连接错误")
                };
                //正常关闭触发
//                ws.onclose = function () {
//                    console.log("连接关闭");
//                };
                return true;
            }
        }

        //退出聊天室
        function exitRoom() {
            closeWebSocket();
        }

        function sendMsg() {
            if(!ws){
                alert("你已掉线，请重新加入");
                return;
            }
            //消息发送
            ws.send(document.getElementById("sendMsg").value);
            document.getElementById("sendMsg").value = "";

        }

        function closeWebSocket() {
            if(ws){
                ws.close();
                ws = null;
            }
        }

        function talking(content) {
        	let name=content.split(" ")[0];
        	let msg=content.split("\r\n")[1];
        	let div=document.createElement("div");
        	div.className="chatmsg";
        	div.innerHTML="<p class='name'><span>"+name+"</span></p><p class='msg'>"+msg+"</p>"
            document.getElementById("content").append(div);
        }
        function check1()
        {
        	
        	if (document.form1.start.value == "")  
        	{
        		alert("检索输入不能为空!");
        		document.form1.start.focus();
        		return false;
        	}

        }
</script>
<%if(request.getSession().getAttribute("showteam")==null)   session.removeAttribute("showteam");%> 
</head>
<body>
<jsp:include flush="true" page="topx.jsp" /><br/>
<div class="body">
<div class="mainbody">
<div class="me">
<a href="../systems/createteam.jsp" class="buttom">创建组队</a>
<a href="<%=request.getContextPath()%>/servlets/CheckTeamServlet" class="buttom">个人组队</a></div>
<div class="me2"><span>组队搜索</span>
<form name="form1" action="<%=request.getContextPath()%>/servlets/ShowTeamServlet" method="post" onsubmit="check1()">
<select name="type">
    <option value="0">队长姓名</option>
    <option value="1">队伍编号</option>
	<option value="2">到达景点名称</option>
</select>
<input id="start" name="start"></input>
<input type="submit" value="查询"></input>
</form>
<%if(request.getSession().getAttribute("showteam")!=null){ %>
<table>
<tr>
<td>队伍编号</td><td>队长</td><td>开始时间</td><td>人数</td><td>出发详细地点</td><td>到达具体景点</td><td></td></tr>
<c:forEach items="${showteam}" var="pat">
<tr><td>${pat.id}</td>
<td>${pat.teamholder}</td>
<td>${pat.time}</td>
<td>${pat.num} / ${pat.maxnum}</td>
<td>${pat.startdetial}</td>
<td>${pat.enddetial}</td>
<td><a href="javascript:void(0);" onclick="select('${pat.id}','${pat.num}','${pat.maxnum}')" class="spe"> 加入组队 </a></td></tr></c:forEach>
</table>
<%} %>
</div>
<!--
<div class="hotteam"><span>热门组队(按时间顺序)</span>
<ul>
<c:forEach items="${hotteam}" var="pat">
<li>
队伍编号：<span>${pat.id}</span>
队长：<span>${pat.teamholder}</span><br/>
开始时间:<span>${pat.time}</span>
人数: ${pat.num} /<span>${pat.maxnum}</span><br/>
出发详细地点：<span>${pat.startdetial}</span><br/>
到达具体景点：<span>${pat.enddetial}</span>
<a href="javascript:void(0);" onclick="select('${pat.id}')" class="spe"> 加入组队 </a></li></c:forEach>
</ul>
</div>  -->
<button class="showsend">
<img src="../image/arrowtop.jpg"></img>
点击以打开聊天框</button>
<div class="chat">
<button class="hidesend">
<img src="../image/arrowdown.jpg"></img>
点击以隐藏聊天框</button>
<div id="content" class="div1">

</div>
<div class="send">
<input type="text" class="sendf" id="sendMsg"/>
<input type="button" class="sendb" value="发送消息 " onclick="sendMsg()"/>
</div>
</div>
</div>
</div>
</body>
</html>