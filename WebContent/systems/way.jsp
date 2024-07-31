<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<title>路线推荐</title>
<style type="text/css">
.menu li.current4 a {
    background-image:url(../image/left3.gif);
    background-repeat:no-repeat;
    background-size:100% 100%;
}
.body{
position:absolute;
margin:0 auto;
top:3.5em;
width:100%;}
#allmap{
height:1000px;
width:100%;}
#r-result,#r-result table{
width:100%;
}
</style>
<script type="text/javascript" src="//api.map.baidu.com/api?v=2.0&ak=lDZnGFIDXyGjm1hDmAF1VK2GYCIQzksF"></script>
<script src="//libs.baidu.com/jquery/1.9.0/jquery.js"></script>
</head>
<body>
<jsp:include flush="true" page="topx.jsp" /><br/>
<div class="body">
出发地点<input id="inputstart"></input>
到达地点<input id="inputend"></input>
<div id="driving_way">
<span>驾车策略：</span>
<select>
    <option value="0">最少时间</option>
    <option value="1">最短距离</option>
	<option value="2">避开高速</option>
</select>
<input type="button" id="result" value="查询"/>
</div>
<div id="allmap"></div>
<div id="r-result"></div>
</div>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
	map.enableScrollWheelZoom(true);  
	//三种驾车策略：最少时间，最短距离，避开高速
	var routePolicy = [BMAP_DRIVING_POLICY_LEAST_TIME,BMAP_DRIVING_POLICY_LEAST_DISTANCE,BMAP_DRIVING_POLICY_AVOID_HIGHWAYS];
	$("#result").click(function(){
		var start = document.getElementById("inputstart").value;
		var end =  document.getElementById("inputend").value;
		map.clearOverlays(); 
		var i=$("#driving_way select").val();
		search(start,end,routePolicy[i]); 
		function search(start,end,route){ 
			var driving = new BMap.DrivingRoute(map, {renderOptions:{map: map, autoViewport: true},policy: route});
			driving.search(start,end);
		}
	});
</script>
</body>
</html>