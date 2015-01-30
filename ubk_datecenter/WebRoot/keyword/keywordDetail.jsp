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
<title>新闻详情页</title>
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
<style>
p {
	font-family: 微软雅黑, 'New Century Schoolbook', Georgia, 'New York', serif;
	font-size: 16px;
}
</style>
<%
	response.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	String crawlid = request.getParameter("crawlid");
	String crawltitle = request.getParameter("crawltitle");
%>
<script type="text/javascript">
	
	
	function savekeyword(){
	  var keyword =$("#keywordarea").val();
	  
	  
	$.ajax({
			type : "GET",
			url : "./../saveKeywordInfo.action?crawlid="+$("#crawlid").val() +"&keyword=" +keyword,
			dataType : "json",
			success : function(data) {
				alert("保存成功");
			}

		});
	
	}
	
	
	
    <%--  $("#title").append(<%=crawltitle%>); --%>
   
/* 	$(function(){
		 alert($("#crawltitle").val());
	}); */
	
	$(document).ready(
			function() {

$("#title").append("<h1>"+$("#crawltitle").val()+"</h1>"); 
                  
$.ajax({
			type : "GET",
			url : "./../readKeywordInfo.action?crawlid="+$("#crawlid").val(),
			dataType : "json",
			success : function(data) {
				$("#content").append(data.content); 
			}

		});

			});
	
	
</script>

</head>
<body>
	<input type="hidden" id="crawltitle" value="<%=crawltitle%>"></input>
	<input type="hidden" id="crawlid" value="<%=crawlid%>"></input>

	<div class="easyui-layout" style="width:100%;height:968px;">
		<div data-options="region:'west',split:true,border:false"
			style="width:200px;height:768;">
			<div class="easyui-accordion" data-options="fit:true,border:false">
			</div>
		</div>
		<div data-options="region:'center',border:false">
			<div class="easyui-layout" style="width:100%;height:968px;">
				<div data-options="region:'north'" style="height:100px"></div>
				<div data-options="region:'east',split:true" style="width:400px;">
					<div style="height:60px;">
						<textarea id="keywordarea"
							style="overflow:auto;border:2;width:100%;height:100%;">银行@@@小红@@@大米</textarea>
						<p>请输入10个关键词,请用@@@隔开</p>
						<a href="javascript:void(0)" class="easyui-linkbutton"
							id="savekeyword" onclick="savekeyword()">保存关键词</a>
					</div>
				</div>
				<div data-options="region:'center',iconCls:'icon-ok',border:false">
					<div>
						<div id="title"></div>
					</div>
					<hr>
					<div>
						<div id="content"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>