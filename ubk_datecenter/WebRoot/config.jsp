<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


</head>
<body>
	<div style="margin:10px 5px 15px 20px;">
		<span> 开始时间 <input class="easyui-datebox" name="startTime"
			id="startTime"></input> 结束时间 <input class="easyui-datebox"
			name="endTime" id="endTime"></input> <a href="javascript:void(0)"
			onclick="exportexcel()" class="easyui-linkbutton" id="exportexcel">导出到本地</a>
		</span> <span style="font-family:arial;color:red;font-size:10px;">*时间只对导出到本地有效</span>
	</div>
</body>
</html>