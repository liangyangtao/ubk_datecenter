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
		window.location.href = "./../exportBhiInfoExcel.action?startTime="
				+ startTime + "&endTime=" + endTime;

	}

	$(function() {
		$('#mydatagrid').datagrid({
			title : '银信产品',
			iconCls : 'icon-ok',
			nowrap : true,
			striped : true,
			url : './../readBhiInfos.action',
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
		<div style="margin:10px 5px 15px 20px;">
			<span> 开始时间 <input class="easyui-datebox" name="startTime"
				id="startTime"></input> 结束时间 <input class="easyui-datebox"
				name="endTime" id="endTime"></input> <a href="javascript:void(0)"
				onclick="exportexcel()" class="easyui-linkbutton" id="exportexcel">导出到本地</a>
			</span> <span style="font-family:arial;color:red;font-size:10px;">*时间只对导出到本地有效</span>
		</div>
	</div>
	<div data-options="region:'center',iconCls:'icon-ok'">
		<table id="mydatagrid">
			<thead>
				<tr>
					<th data-options="field:'proName',width:300,align:'left'">项目名称</th>
					<th data-options="field:'proArea',width:300,align:'left'">地区</th>
				<!-- 	<th data-options="field:'proTime',width:300,align:'left'">发布时间</th> -->
				<!-- 	<th data-options="field:'ptoNature',width:300,align:'left' ">行页性质</th> -->
					<th data-options="field:'firmNature',width:300,align:'left'">企业性质</th>
					<th data-options="field:'proTrade',width:300,align:'left'">行业</th>
					<th data-options="field:'proAssets',width:300,align:'left'">投资总额</th>
					<th data-options="field:'proStage',width:300,align:'left'">进展阶段</th>
					<th data-options="field:'proWay',width:300,align:'left'">申报方式</th>
					<th data-options="field:'proOffice',width:300,align:'left'">审批机关</th>
					<th data-options="field:'proCycle',width:300,align:'left'">建设周期</th>
					<th data-options="field:'proFund',width:300,align:'left'">资金到位</th>
					<th data-options="field:'equipmentSource',width:300,align:'left'">设备来源</th>
					<th data-options="field:'governingUnit',width:300,align:'left'">主管单位</th>
					<th data-options="field:'address',width:300,align:'left'">所在地</th>
					<th data-options="field:'proFacility',width:300,align:'left'">主要设备</th>
					<th data-options="field:'proContent',width:300,align:'left'">建设内容</th>
					<th data-options="field:'proDepartment',width:300,align:'left'">单位名称</th>
					<th data-options="field:'proPeople',width:300,align:'left'">姓名</th>
					<th data-options="field:'proTel',width:300,align:'left'">电话</th>
				<!-- 	<th data-options="field:'fax',width:300,align:'left'">传真</th> -->
					<th data-options="field:'postcode',width:300,align:'left'">邮编</th>
					<th data-options="field:'detailAddress',width:300,align:'left'">详细地址</th>
					<th data-options="field:'proIntro',width:300,align:'left'">项目简介</th>

				</tr>
			</thead>
		</table>
	</div>



</body>
</html>