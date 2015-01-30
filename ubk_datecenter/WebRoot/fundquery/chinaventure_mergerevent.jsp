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
		window.location.href = "./../exportChinaventureMergereventExcel.action?startTime="
				+ startTime + "&endTime=" + endTime;

	}

	$(function() {
		$('#mydatagrid').datagrid({
			title : '并购事件',
			iconCls : 'icon-ok',
			nowrap : true,
			striped : true,
			url : './../readChinaventureMergereventInfos.action',
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
					<th data-options="field:'proName',width:50,align:'left'">产品名称</th>
					<th data-options="field:'transactionType',width:50,align:'left'">产品类型</th>
					<th data-options="field:'tradingManner',width:50,align:'left'">交易方式</th>
					<th data-options="field:'whetherCrossBorder',width:50,align:'left'">是否跨境并购</th>
					<th
						data-options="field:'whetherRelatedParty',width:50,align:'left'">是否关联交易</th>
					<th data-options="field:'tradingAttitude',width:50,align:'left'">交易态度</th>
					<th data-options="field:'transactionStatus',width:50,align:'left'">交易状态</th>
					<th data-options="field:'dealAnnouncedTime',width:50,align:'left'">交易宣布时间</th>
					<th
						data-options="field:'transactionsOverTime',width:50,align:'left'">交易结束时间</th>
					<th data-options="field:'transactionAmount',width:50,align:'left'">交易金额</th>
					<th data-options="field:'businessValuation',width:50,align:'left'">企业估值</th>
					<th data-options="field:'patternPayment',width:50,align:'left'">支付方式</th>
					<th data-options="field:'industryCategory',width:50,align:'left'">行业分类</th>
					<th data-options="field:'targetEnterprise',width:50,align:'left'">标的企业</th>
					<th data-options="field:'buyerCompany',width:50,align:'left'">买方企业</th>
					<th data-options="field:'investmentBank',width:50,align:'left'">投资银行</th>
					<th data-options="field:'lawFirm',width:50,align:'left'">律师事务所</th>
					<th data-options="field:'accountingFirm',width:50,align:'left'">会计事务所</th>
					<th data-options="field:'evaluationCompany',width:50,align:'left'">资产评估公司</th>
					<th
						data-options="field:'businessTransaction',width:50,align:'left'">交易描述</th>
				</tr>
			</thead>
		</table>
	</div>



</body>
</html>