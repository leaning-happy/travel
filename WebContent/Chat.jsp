<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>交流</title>
<style type="text/css">
.slide{
float:right;
border:1px blue solid;

}
.chat{
float:right;
}
</style>
</head>
<body>
<div class="slide"></div>
<div class="chat">
<div class="message">
</div>
<input type="text" name="text" id="message">

<button onclick="sendMessage()">send</button>

</div>
<script>
function sendMessage(){
	 var message=document.getElementById("message").value
	 var ws=new WebSocket("ws://localhost:8040/travel/websocket/ChatS")
	 ws.onopen=()=>{
		 console.log("成功建立联系")
	 }
}
</script>
</body>
</html>