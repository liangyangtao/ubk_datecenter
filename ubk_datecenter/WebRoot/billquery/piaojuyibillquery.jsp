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
<!-- 引入Jquery -->
<script type="text/javascript"
	src="<%=path%>/resource/js/easyui/jquery.min.js" charset="utf-8"></script>
<!-- 引入Jquery_easyui -->
<script type="text/javascript"
	src="<%=path%>/resource/js/easyui/jquery.easyui.min.js" charset="utf-8"></script>
<!-- 引入easyUi国际化--中文 -->
<script type="text/javascript"
	src="<%=path%>/resource/js/easyui/locale/easyui-lang-zh_CN.js"
	charset="utf-8"></script>
<!-- 引入easyUi默认的CSS格式--蓝色 -->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resource/js/easyui/themes/default/easyui.css" />
<!-- 引入easyUi小图标 -->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/resource/js/easyui/themes/icon.css" />

<script type="text/javascript">
	function exportexcel() {
		var startTime = $('#startTime').datebox('getValue');
		var endTime = $('#endTime').datebox('getValue');
		window.location.href = "./../exportPiaojuyiBillExcel.action?startTime="
				+ startTime + "&endTime=" + endTime;

	}

	$(function() {
		$('#mydatagrid').datagrid({
			title : '银票',
			iconCls : 'icon-ok',
			nowrap : true,
			striped : true,
			url : './../readPiaojuyiBills.action',
			loadMsg : '数据装载中......',
			fitColumns : true,
			remoteSort : false,
			rownumbers : true,
			pagination : true
		});
		var p = $('#mydatagrid').datagrid('getPager');

		$(p).pagination({
			pageSize : 10,//每页显示的记录条数，默认为10 
			pageList : [ 10, 20, 30 ],//可以设置每页记录条数的列表 
			beforePageText : '第',//页数文本框前显示的汉字 
			afterPageText : '页    共 {pages} 页',
			displayMsg : '当前显示 {from} - {to} 条记录   共 {total} 条记录'
		});
	});
</script>

</head>
<body class="easyui-layout">
	<div data-options="region:'north'" style="height:50px;">
		<jsp:include page="./../config.jsp"></jsp:include>
	</div>
	<div data-options="region:'center',iconCls:'icon-ok'">
		<table id="mydatagrid">
			<thead>
				<tr>

					<!--  "金额", "银行类型", "发布地点", "利率", "交易类型",
				"交易时间" -->
					<th data-options="field:'proMoney',width:100,align:'center'">金额</th>
					<th data-options="field:'proType',width:100,align:'center'">银行类型</th>
					<th data-options="field:'proPlace',width:100,align:'center'">发布地点</th>
					<th data-options="field:'proRate',width:100,align:'center'">利率</th>
					<th data-options="field:'billType',width:100,align:'center'">交易类型</th>
					<th data-options="field:'proDate',width:100,align:'center'">发布日期</th>



				</tr>
			</thead>
		</table>
	</div>



</body>
</html>