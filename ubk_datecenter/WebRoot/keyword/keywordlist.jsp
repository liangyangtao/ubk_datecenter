<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试列表</title>
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
	$(document)
			.ready(
					function() {

						$('#tt')
								.datagrid(
										{
											url : "./../readInfo.action",
											width : '100%',
											height : '1024',
											nowrap : true,
											iconCls : 'icon-save',
											striped : true,
											rownumbers : true,
											singleSelect : true,
											loadMsg : '数据加载中......',
											columns : [ [
													{
														field : 'crawlId',
														title : '新闻编号',
														width : 100,
														align : 'left'
													},

													{
														field : 'crawlTitle',
														title : '新闻标题',
														align : 'left',
														width : 300,
														formatter : function(
																val, rec) {
															return "<a href='./keywordDetail.jsp?crawlid="
																	+ rec.crawlId
																	+ "&crawltitle="
																	+ val
																	+ "' target='_blank'>"
																	+ val
																	+ "</a> ";
														}

													}, {
														field : 'webName',
														title : '网站名称',
														width : 200,
														align : 'left'
													}, {
														field : 'url',
														title : '网址',
														width : 400,
														align : 'left'
													}

											] ]

										});
					});
</script>

</head>
<body>
	<div class="easyui-layout" style="width:100%;height:1024px;">
		<div data-options="region:'center',title:'新闻列表',iconCls:'icon-ok'">
			<div id="tt"></div>
		</div>
	</div>



</body>
</html>