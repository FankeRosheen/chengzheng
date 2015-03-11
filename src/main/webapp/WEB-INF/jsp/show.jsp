<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=1507703fda1fb9594c7e7199da8c41d8"></script>
<script src='/lib/jquery-1.8.0.min.js' type='text/javascript'></script>
<script type="text/javascript">
	$(function() {
	var map = new BMap.Map("allmap"); // 创建Map实例
		$.ajax({
			type : "GET",
			url : "/show",
			data : "{}",
			contentType : "application/json; charset=utf-8",
			dataType : "json",
			async : false,
			success : function(data) {
				$.each(data, function(index, element) {
					var location;
					// 百度地图API功能
					alert(data);
					var point = new BMap.Point(data.location[0],data.location[1]);
					map.centerAndZoom(point, 12);
					var marker = new BMap.Marker(point); // 创建标注
					map.addOverlay(marker);
					var opts = {
						position : point, // 指定文本标注所在的地理位置
						offset : new BMap.Size(30, -30)
					//设置文本偏移量
					}
					var label = new BMap.Label(data.address, opts); // 创建文本标注对象
					label.setStyle({
						color : "red",
						fontSize : "12px",
						height : "20px",
						lineHeight : "20px",
						fontFamily : "微软雅黑"
					});
					map.addOverlay(label);
					var local = new BMap.LocalSearch(map, {
						renderOptions : {
							map : map,
							autoViewport : true
						}
					});
				});
			}
		});
	});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
body,html,#allmap {
	width: 100%;
	height: 100%;
	overflow: hidden;
	margin: 0;
	font-family: "微软雅黑";
}
</style>
	<title>根据中心点关键字周边搜索</title>

</head>
<body>
		<div id="allmap"></div>
</body>
</html>
