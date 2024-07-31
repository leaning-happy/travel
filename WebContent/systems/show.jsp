<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%if(request.getSession().getAttribute("rulex")==null)   session.setAttribute("rulex","0");%>
<%if(request.getSession().getAttribute("ruley")==null)   session.setAttribute("ruley","0");%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="../CSS/topnormal.css" type="text/css" rel="stylesheet"/>
<style type="text/css">
body{
font-size:big;}
a{
cursor:pointer;
text-decoration:none;
color:rgba(255,255,255,1)}
span{
text-indent:2em;}
ul{
list-style:none;
padding-left:0;
margin:0;}
ul a{
color:black;}
img{
height:100px;
width:200px;
float:left;}
.try{
position:absolute;
background-color:rgba(250,218,141,1);
top:3.5em;
left:0.2em;
right:0.2em;
height:2.5em;
align:center;}
.try input[type="text"]{
margin-left:25%;
margin-right:0.1em;
margin-top:0.15em;
margin-buttom:0.15em;
width:35%;
height:2.2em;
}
.h1{
display:block;
position:absolute;
top:6em;
background-color:rgba(3,38,58,0.5);
left:0.2em;
right:0.2em;
height:1.5em;
text-align:center;
}
.type{
background-color:rgba(179,168,150,1);
}
.detail{
background-color:rgba(222,125,44,0.8);
border:solid 1px;}
#detail1{
position:absolute;
top:7.5em;
height:8em;
left:0.2em;
right:0.2em;
}
#detail2{
position:absolute;
top:15.5em;
height:4.5em;
left:0.2em;
right:0.2em;
}
.end{
position:absolute;
top:20em;
background-color:rgba(20,68,106,0.1);
height:auto;
border:solid 1px;
left:0.2em;
right:0.2em;
}
#hil{
font-size:1.2em;
line-height:1.4em;
}
.end li{
height:99px;
border-bottom:solid 1px white;}
.recc li{
overflow:hidden;
border:1px solid black;
}
</style>
  </head>  
  <body>
  <form action="<%=request.getContextPath()%>/servlets/CheckServlet" method="post" class="try">
  <input type="text" placeholder="请输入地点名称（宁少不多不错）"  name="inf">
  <input type="submit" value="搜索">
  </form>
  <div class="h1"><span id="hil">筛选搜索</span></div>
  <div class="detail" id="detail1"> 
  <table>
  <tr><td class="type" id="type1"><b>省份</b></td></tr>
  <tr><td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=1&case2=0"><span><%if(!session.getAttribute("rulex").equals("1")){%>湖北省<%}else{%><b><font color="red">湖北省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=2&case2=0"><span><% if(!session.getAttribute("rulex").equals("2")){%>北京市<%}else{%><b><font color="red">北京市</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=3&case2=0"><span><% if(!session.getAttribute("rulex").equals("3")){%>天津市<%}else{%><b><font color="red">天津市</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=4&case2=0"><span><% if(!session.getAttribute("rulex").equals("4")){%>浙江省<%}else{%><b><font color="red">浙江省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=5&case2=0"><span><% if(!session.getAttribute("rulex").equals("5")){%>重庆市<%}else{%><b><font color="red">重庆市</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=6&case2=0"><span><% if(!session.getAttribute("rulex").equals("6")){%>江苏省<%}else{%><b><font color="red">江苏省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=7&case2=0"><span><% if(!session.getAttribute("rulex").equals("7")){%>湖南省<%}else{%><b><font color="red">湖南省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=8&case2=0"><span><% if(!session.getAttribute("rulex").equals("8")){%>广东省<%}else{%><b><font color="red">广东省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=9&case2=0"><span><% if(!session.getAttribute("rulex").equals("9")){%>甘肃省<%}else{%><b><font color="red">甘肃省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=10&case2=0"><span><% if(!session.getAttribute("rulex").equals("10")){%>陕西省<%}else{%><b><font color="red">陕西省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=11&case2=0"><span><% if(!session.getAttribute("rulex").equals("11")){%>山东省<%}else{%><b><font color="red">山东省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=12&case2=0"><span><% if(!session.getAttribute("rulex").equals("12")){%>河南省<%}else{%><b><font color="red">河南省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=13&case2=0"><span><% if(!session.getAttribute("rulex").equals("13")){%>黑龙江省<%}else{%><b><font color="red">黑龙江省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=14&case2=0"><span><% if(!session.getAttribute("rulex").equals("14")){%>辽宁省<%}else{%><b><font color="red">辽宁省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=15&case2=0"><span><% if(!session.getAttribute("rulex").equals("15")){%>吉林省<%}else{%><b><font color="red">吉林省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=16&case2=0"><span><% if(!session.getAttribute("rulex").equals("16")){%>贵州省<%}else{%><b><font color="red">贵州省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=17&case2=0"><span><% if(!session.getAttribute("rulex").equals("17")){%>四川省<%}else{%><b><font color="red">四川省</font></b><%}%></span></a></td></tr>
  <tr>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=18&case2=0"><span><% if(!session.getAttribute("rulex").equals("18")){%>青海省<%}else{%><b><font color="red">青海省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=19&case2=0"><span><% if(!session.getAttribute("rulex").equals("19")){%>江西省<%}else{%><b><font color="red">江西省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=20&case2=0"><span><% if(!session.getAttribute("rulex").equals("20")){%>安徽省<%}else{%><b><font color="red">安徽省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=21&case2=0"><span><% if(!session.getAttribute("rulex").equals("21")){%>福建省<%}else{%><b><font color="red">福建省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=22&case2=0"><span><% if(!session.getAttribute("rulex").equals("22")){%>台湾省<%}else{%><b><font color="red">台湾省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=23&case2=0"><span><% if(!session.getAttribute("rulex").equals("23")){%>海南省<%}else{%><b><font color="red">海南省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=24&case2=0"><span><% if(!session.getAttribute("rulex").equals("24")){%>上海市<%}else{%><b><font color="red">上海市</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=25&case2=0"><span><% if(!session.getAttribute("rulex").equals("25")){%>云南省<%}else{%><b><font color="red">云南省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=26&case2=0"><span><% if(!session.getAttribute("rulex").equals("26")){%>山西省<%}else{%><b><font color="red">山西省</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=27&case2=0"><span><% if(!session.getAttribute("rulex").equals("27")){%>河北省<%}else{%><b><font color="red">河北省</font></b><%}%></span></a></td></tr></table>
  <table><tr>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=28&case2=0"><span><% if(!session.getAttribute("rulex").equals("28")){%>澳门特别行政区<%}else{%><b><font color="red">澳门特别行政区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=29&case2=0"><span><% if(!session.getAttribute("rulex").equals("29")){%>香港特别行政区<%}else{%><b><font color="red">香港特别行政区</font></b><%}%></span></a></td></tr></table>
  <table><tr>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=30&case2=0"><span><% if(!session.getAttribute("rulex").equals("30")){%>广西壮族自治区<%}else{%><b><font color="red">广西壮族自治区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=31&case2=0"><span><% if(!session.getAttribute("rulex").equals("31")){%>西藏藏族自治区<%}else{%><b><font color="red">西藏藏族自治区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=32&case2=0"><span><% if(!session.getAttribute("rulex").equals("32")){%>新疆维吾尔族自治区<%}else{%><b><font color="red">新疆维吾尔族自治区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=33&case2=0"><span><% if(!session.getAttribute("rulex").equals("33")){%>宁夏回族自治区<%}else{%><b><font color="red">宁夏回族自治区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=34&case2=0"><span><% if(!session.getAttribute("rulex").equals("34")){%>内蒙古自治区<%}else{%><b><font color="red">内蒙古自治区</font></b><%}%></span></a></td> 
  </tr></table>
   </div>
   <div class="detail" id="detail2"> 
   <table>
  <tr><td class="type" id="type2"><b>类别</b></td></tr>
  <tr>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=1"><span><% if(!session.getAttribute("ruley").equals("1")){%>山川景区
  <%}else{%>
  <b><font color="red">山川景区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=2"><span><% if(!session.getAttribute("ruley").equals("2")){%>森林景区
  <%}else{%>
  <b><font color="red">森林景区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=3"><span><% if(!session.getAttribute("ruley").equals("3")){%>湖泊景区
  <%}else{%>
  <b><font color="red">湖泊景区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=4"><span><% if(!session.getAttribute("ruley").equals("4")){%>海滨景区
  <%}else{%>
  <b><font color="red">海滨景区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=5"><span><% if(!session.getAttribute("ruley").equals("5")){%>休闲景区
  <%}else{%>
  <b><font color="red">休闲景区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=6"><span><% if(!session.getAttribute("ruley").equals("6")){%>宗教寺庙景区
  <%}else{%>
  <b><font color="red">宗教寺庙景区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=7"><span><% if(!session.getAttribute("ruley").equals("7")){%>革命纪念区
  <%}else{%>
  <b><font color="red">革命纪念区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=8"><span><% if(!session.getAttribute("ruley").equals("8")){%>历史文物景区
  <%}else{%>
  <b><font color="red">历史文物景区</font></b><%}%></span></a></td>
  <td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=9"><span><% if(!session.getAttribute("ruley").equals("9")){%>民俗文化景区
  <%}else{%>
  <b><font color="red">民俗文化景区</font></b><%}%></span></a></td>
  </tr>
  <tr><td><a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=0"><span><% if(!session.getAttribute("ruley").equals("0")){%>清除选择
  <%}else{%>
  <b><font color="red">清除选择</font></b><%}%></span></a></td></tr>
   </table>
   </div>
   <div class="end">
   <span style="display:block;text-align:center;font-weight:bold;color:purple">搜索结果</span>
   <%if(request.getSession().getAttribute("search")==null||session.getAttribute("search").equals(" ")){ %>
   <p style="text-align:center">没有对应的景点</p>
   <%}else {%>
   <ul class="recc">
   <c:forEach items="${search}" var="pat" begin="0" end="4">
   <li><a href="<%=request.getContextPath()%>/servlets/AddHistoryServlet?case1=1&name=${pat.name}"><img src="../${pat.imgpath}" />
   <span>所属地区：</span>${pat.belongcity}<br/>
   <span>名字：</span>${pat.name}<br/>
   <span>${pat.brief}</span>
   </a></li></c:forEach>
   </ul><%} %>
   </div>
   
  </body>
</html>
