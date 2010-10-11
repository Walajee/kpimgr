<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.focusoft.power.sccb.util.ServiceUtil" %>
<%@ page import="com.focusoft.power.sccb.service.PageService" %>

<%
	PageService ps = ServiceUtil.getPageService(this.getServletContext());
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	
	<script src="<c:url value="/scripts/dwz/jquery-1.4.2.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/jquery.cookie.js" />" type="text/javascript"></script>
	
	<script src="<c:url value="/scripts/dwz/jquery.validate.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/jquery.bgiframe.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.core.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.scrollCenter.js" />" type="text/javascript"></script>

	<script src="<c:url value="/scripts/dwz/dwz.validate.method.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.regional.zh.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.barDrag.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.drag.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.tree.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.accordion.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.ui.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.theme.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.switchEnv.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.alertMsg.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.contextmenu.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.navTab.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.tab.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.resize.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.jDialog.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.dialogDrag.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.cssTable.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.stable.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.taskBar.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.ajax.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.pagination.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.datepicker.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.effects.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.panel.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.checkbox.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.history.js" />" type="text/javascript"></script>
	<script src="<c:url value="/scripts/dwz/dwz.combox.js" />" type="text/javascript"></script>
	<link href="<c:url value="/style/css/themes/default/style.css" />" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/style/css/themes/css/core.css" />" rel="stylesheet" type="text/css" />
	<link href="<c:url value="/style/css/uploadify/css/uploadify.css" />" rel="stylesheet" type="text/css" />

	<!--[if IE]>
	<link href="<c:url value="/style/css/themes/css/ieHack.css" />" rel="stylesheet" type="text/css" />
	<![endif]-->
	
	<script type="text/javascript">
	$(function(){	
		DWZ.init("../dwz.frag.xml", {
	//		loginUrl:"loginsub.html", loginTitle:"登录",	// 弹出登录对话框
			loginUrl:"login.html",	// 跳到登录页面
			debug:false,	// 调试模式 【true|false】
			callback:function(){
				initEnv();
				$("#themeList").theme({themeBase:"themes"});
			}
		});

	});
	//清理浏览器内存,只对IE起效,FF不需要
	if ($.browser.msie) {
		window.setInterval("CollectGarbage();", 10000);
	}
	</script>
</head>

<body>
	<div id="layout">
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>
				
				<div class="accordion" fillSpace="sideBar">
					<div class="accordionHeader">
							<h2><span>Folder</span>标准管理</h2>
					</div>
					<div class="accordionContent">
							<%=
								ps.getStdCatHtml()
							%>
					</div>
					
					<div class="accordionHeader">
						<h2><span>Folder</span>标准评审</h2>
					</div>
					<div class="accordionContent" style="height:150px;">
						<ul class="tree">
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">创建评审</a></li>
							<li><a href="newPage1.html" target="dialog" rel="dlg_page">已经评审</a></li>
						</ul>
					</div>
				</div>
		</div>
		
		
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				
				<ul class="tabsMoreList">
					
				</ul>
				<div class="navTab-panel tabsPageContent">
				</div>
				
			</div>
		
		</div>
		<div id="taskbar" style="left:0px; display:none;">
			<div class="taskbarContent">
				<ul></ul>
			</div>
			<div class="taskbarLeft taskbarLeftDisabled" style="display:none;">taskbarLeft</div>
			<div class="taskbarRight" style="display:none;">taskbarRight</div>
		</div>
		<div id="splitBar"></div>
		<div id="splitBarProxy"></div>
</body>

</html>