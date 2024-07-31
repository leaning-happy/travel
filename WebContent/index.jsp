<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8" />
<title>地理定位</title>
<script type="text/javascript" src="//api.map.baidu.com/api?v=2.0&ak=lDZnGFIDXyGjm1hDmAF1VK2GYCIQzksF"></script>
<%if(request.getSession().getAttribute("scenery_list")==null){%>
<script type="text/javascript">
alert("正在定位，请稍等")
var geolocation = new BMap.Geolocation();
	geolocation.getCurrentPosition(function(r){
		if(this.getStatus() == BMAP_STATUS_SUCCESS){
			var geoc = new BMap.Geocoder();    
			var pt = r.point;
			geoc.getLocation(pt, function(rs){
			var addComp = rs.addressComponents;
			alert("您现在所在位置为:"+addComp.province + " " + addComp.city + " " + addComp.district + " " + addComp.street + " " + addComp.streetNumber);
			window.location.href="<%=request.getContextPath() %>/servlets/IndexServlet?case1="
					+addComp.province;
			}); 
		}
		else {
			alert('failed'+this.getStatus());
		}},{enableHighAccuracy:true } )     	
</script>
<%} else{%>
<script>window.location.href="<%=request.getContextPath()%>/systems/index.jsp";</script>
<%} %>
</head>
<body>
</body>
</html>