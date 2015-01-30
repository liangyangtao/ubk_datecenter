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
		window.location.href = "./../exportYangleeSilverLetterExcel.action?startTime="
				+ startTime + "&endTime=" + endTime;

	}

	$(function() {
		$('#mydatagrid').datagrid({
			title : '银信产品',
			iconCls : 'icon-ok',
			nowrap : true,
			striped : true,
			url : './../readYangleeSilverLetterInfos.action',
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
					<th data-options="field:'proName',width:300,align:'left'">产品名称</th>
					<th data-options="field:'proType',width:50,align:'left'">产品类型</th>
					<th data-options="field:'proState',width:50,align:'left'">产品状态</th>
			<!-- 		<th data-options="field:'proHouse',width:100,align:'left'">发行机构</th> -->
<!-- 					<th data-options="field:'proManage',width:100,align:'left'">项目经理</th> -->
					<th data-options="field:'financialCurrency',width:50,align:'left'">理财币种</th>
					<th
						data-options="field:'investmentThreshold',width:50,align:'left'">投资门槛</th>
					<th data-options="field:'releaseObject',width:50,align:'left'">发售对象</th>
					<th data-options="field:'issuePlace',width:50,align:'left'">发行地</th>
					<th data-options="field:'issueDate',width:100,align:'left'">发行时间</th>
					<th data-options="field:'issuingScale',width:50,align:'left'">发行规模</th>
					<th data-options="field:'establishedTime',width:100,align:'left'">成立时间</th>
					<th data-options="field:'setupScale',width:50,align:'left'">成立规模</th>
					<th data-options="field:'lifetimeExtension',width:50,align:'left'">产品期限</th>
					<th data-options="field:'anticipatedIncome',width:50,align:'left'">预计收益</th>
					<th data-options="field:'returnsType',width:100,align:'left'">收益类型</th>
					<th data-options="field:'investmentWay',width:50,align:'left'">投资方式</th>
					<th data-options="field:'investmentField',width:50,align:'left'">投资领域</th>
					<th
						data-options="field:'investmentManageType',width:50,align:'left'">投资管理类型</th>
			<!-- 		<th data-options="field:'investmentManager',width:100,align:'left'">投资管理人</th> -->
				<!-- 	<th data-options="field:'escrowLine',width:100,align:'left'">资金托管行</th> -->
			<!-- 		<th data-options="field:'escrowFee',width:100,align:'left'">资金托管费率</th> -->
			<!-- 		<th data-options="field:'distributionType',width:100,align:'left'">收益分配方式</th> -->
				<!-- 	<th data-options="field:'redemptiveRate',width:100,align:'left'">申购赎回费率</th> -->
					<th data-options="field:'matureTime',width:100,align:'left'">到期清算日</th>
		<!-- 			<th data-options="field:'effectiveRate',width:100,align:'left'">实际收益率</th> -->
					<th data-options="field:'dealStructure',width:100,align:'left'">交易结构</th>
<!-- 					<th data-options="field:'creditEnhancement',width:100,align:'left'">信用增级措施</th> -->
				<!-- 	<th data-options="field:'productFeature',width:100,align:'left'">产品特点</th> -->
			<!-- 		<th data-options="field:'otherInformation',width:100,align:'left'">其他相关信息</th> -->
					<th data-options="field:'detailurl',width:100,align:'left'">原始链接</th>


				</tr>
			</thead>
		</table>
	</div>



</body>
</html>