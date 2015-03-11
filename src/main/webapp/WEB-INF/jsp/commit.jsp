<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String id = request.getParameter("restaurantId");
if(id == null){
	id = "";
}
%>
<html>
 <head>
   <meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
   <title>系统</title>
   <style type="text/css">
   #submit {
		cursor: pointer;
		width: 271px;
		height: 47px;
		margin: 33px auto 0px auto;
		font-size: 14px;
		background-color: rgb(235,40,40);
		color: #fff;
		line-height: 47px;
		border: 0px;
	}
	#showmap {
		cursor: pointer;
		width: 271px;
		height: 47px;
		margin: 33px auto 0px auto;
		font-size: 14px;
		background-color: rgb(235,40,40);
		color: #fff;
		line-height: 47px;
		border: 0px;
	}
   </style>
 </head>

<script type="text/javascript" src="/lib/jquery-1.8.0.min.js"></script>
<script type="text/javascript">

var id = '<%=id%>';
function dl(){
	if( form1.location.value==""){
		alert("请您填写位置坐标!");
		return false;
	}
}
function checkAll(){
	window.location.href="check";
}

</script>

<body bgcolor="">
<table >
  <tr>
    <td height="100%" background="">
     <table width="1342"  align="center">
      <tr>
        <form action="/saveRestLoc" name=form1 method=get onSubmit="return dl()" >
         <table width="100%" >
          <tr>
          	  <p align="center">
                <span class="STYLE3" align="center">&nbsp;餐馆ID：</span>
                <input type="text" name="restaurantId" style="width:200px;height:40px;" readonly="true" value=
                <%=id%>>
              </p>
              <p align="center">
                <span class="STYLE3" align="center">位置坐标：</span>
                <input type="text" name="location" style="width:200px;height:40px;" >
              </p>
           
           <td height="247" valign="top" background="<%=basePath%>images/">
           <table width="100%" border="0" cellspacing="0" cellpadding="0">
           <tr>
              <td width="22%" height="30">&nbsp;</td>
              <td width="56%">　　　　　　　　　　　　　　　　
	              <input id="submit" type="submit" name="Submit"  align="center" value="提交" />　
              </td>
              <td width="22%">&nbsp;</td>
          </tr> 
          
          <tr>
              <td width="22%" height="30">&nbsp;</td>
              <td width="56%">　　　　　　　　　　　　　　　　
	              <input id="submit" name="Reset" type="Reset" align="center" value="重 置" />
              </td>
              <td width="22%">&nbsp;</td>
          </tr> 
          
          <tr>
          	  <td width="22%" height="30">&nbsp;</td>
          	  <td width="56%">　　　　　　　　　　　　　　　　
	              <input id="showmap" type="button" name="Submit"  align="center" value="查看地图位置" onclick="checkAll()" />　
              </td>
              <td width="22%">&nbsp;</td>
          </tr>    
          </table>
          </td>
          
         </tr>
        </table>
       </td>
      </tr>
    </table>
    </td>
  </tr>
</table>
</body>
</html>
