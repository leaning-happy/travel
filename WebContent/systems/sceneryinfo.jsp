<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>在此处插入标题</title>
<style type="text/css">
ul{
padding-left:0;
list-style:none;
margin:0;}
a{
text-decoration:none;
color:black;}
p{
text-indent:2em;
height:60px;
overflow:hidden;
margin:0;}
.ground{
position:absolute;
top:3.5em;
width:100%;
}
#maincontent{
width:95%;
margin:0 auto;}
#leftfloat{
padding-top:10px;
padding-left:2%;
padding-right:1%;
font-size:15px;
width:59%;
height:1040px;
background-color:rgba(179,168,150,0.6)}
.rec{
height:20px;
text-overflow:ellipsis;
white-space:nowrap;
overflow:hidden;
background-color:rgba(179,168,150,1)
}
.recc{
height:500px;}
#rightfloat{
padding-top:10px;
padding-left:2%;
padding-right:1%;
font-size:18px;
color:white;
float:right;
height:1040px;
width:35%;
background-color:rgba(200,200,200,0.6);}
#imin{
height:120px;}
#imin ul{
font-size:15px;}
#outway{
height:225px;}
#type{
height:425px;}
#rightfloat img{
height:200px;
width:100%;}
#leftfloat img{
height:99px;
width:25%;
float:left;}
#leftfloat li{
height:99px;
border-top:solid 1px black;}
#type a{
display:block;
float:left;
width:50%;
}
.recc li{
overflow:hidden;
}
</style>
<script>
function select(r){
	window.location.href="<%=request.getContextPath() %>/servlets/AddHistoryServlet?case1=0&name="+r;
}
</script>
<%if(request.getSession().getAttribute("rulex")==null)   session.setAttribute("rulex","0");%>
<%if(request.getSession().getAttribute("ruley")==null)   session.setAttribute("ruley","0");%> 
</head>
<body>
<div class="ground">
<div id="maincontent">
<div id="rightfloat">
<!--  
<div id="imin">重要资讯<br/>
<ul>
<li><a href="#">今日减免</a></li>
<li><a href="#">高速封路</a></li>
<li><a href="#">景区暂时休业</a></li>
<li><a href="#">景区评测</a></li>
<li><a href="#">假期通知</a></li>
</ul></div>-->
<!--  <div id="outway">出行方式<br/>
<img src="../image/drive.jpg"/><img src="../image/allhava.jpg"/></div> -->
<div id="type">景点类型<br/>
<a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=4"><img src="../image/333.jpg"/></a>
<a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=8"><img src="../image/444.jpg"/></a>
<a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=2"><img src="../image/222.jpg"/></a>
<a href="<%=request.getContextPath()%>/servlets/ShowServlet?case1=0&case2=1"><img src="../image/111.jpg"/></a>
</div>
热门景点
<ul>
<c:forEach items="${hot_list}" var="pat" begin="0" end="4">
<li><a href="javascript:void(0);" onclick="select('${pat.name}')">
${pat.name}</a></li><br/></c:forEach>
</ul>
</div>
<div id="leftfloat">
<div id="like" class="rec">偏好推荐(根据您的浏览历史推荐，您浏览的越多，推荐得就越精准哦)</div>
<%if(request.getSession().getAttribute("list")==null){%>
<div style="text-align:center">登录后才有推荐呢</div>
<% }else if(request.getSession().getAttribute("recommend_list")==null){ %>
<div style="text-align:center">您还没有浏览记录，暂时无法为您推荐</div> 
<%}else{ %> 
<ul class="recc">
<c:forEach items="${recommend_list}" var="pat" begin="0" end="4">
<li><a href="javascript:void(0);" onclick="select('${pat.name}')"><img src="../${pat.imgpath}" /><span>所属地区：</span>${pat.belongcity}<br/>
<span>名字：</span>${pat.name}<br/>
<span>${pat.brief}</span>
</a></li></c:forEach>
</ul> 
<%} %>
<div id="place" class="rec">附近推荐</div>
<ul class="recc">
<c:forEach items="${scenery_list}" var="pat" begin="0" end="4">
<li><a href="javascript:void(0);" onclick="select('${pat.name}')"><img src="../${pat.imgpath}" /><span>所属地区：</span>${pat.belongcity}<br/>
<span>名字：</span>${pat.name}<br/>
<span>${pat.brief}</span>
</a></li></c:forEach>
</ul>
</div>
</div>
</div>
</body>
</html>