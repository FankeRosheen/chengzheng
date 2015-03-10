<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String id = request.getParameter("restaurantId");
	if (id == null) {
		id = "";
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>系统</title>
<style type="text/css"></style>
</head>

<script type="text/javascript">
var id = <%=id%>;

function dl(){
	if(form1.addr.value=="" || form1.location.value==""){
		alert("请您填写餐馆位置和位置坐标!");
		return false;
	}
}
</script>

<body bgcolor="">
	<table>
		<tr>
			<td height="100%" background="">
				<table width="1342" align="center">
					<tr>
						<form action="show" name=form1 method=post
							onSubmit="return dl()">
							<table width="100%">
								<tr>
									<p align="center">
										<span class="STYLE3" align="center">餐馆第ID：</span> <input
											type="text" name="id" value=<%=id%>
											style="text-align:left;width:200px;height:40px;"
											>
									</p>
									<p align="center">
										<span class="STYLE3" align="center">餐馆位置：</span> <input
											type="text" name="addr" style="width:200px;height:40px;" disable="true">
									</p>
									<p align="center">
										<span class="STYLE3" align="center">位置坐标：</span> <input
											type="text" name="location" style="width:200px;height:40px;">
									</p>

									<td height="247" valign="top" background="<%=basePath%>images/">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr align="center">
												<td width="22%" height="30">&nbsp;</td>
												<td width="56%"><input type="submit" name="Submit"
													 value="提交"
													style="background-color:#ff0000;width:90px;height:32px">
													<input name="Reset" type="Reset" id="Reset" align="center"
													value="重 置"
													style="background-color:#ff0000;width:90px;height:32px">
												</td>
												<td width="22%">&nbsp;</td>
											</tr>
										</table></td>

								</tr>
							</table>
							</td>
					</tr>
				</table></td>
		</tr>
	</table>
</body>
</html>
