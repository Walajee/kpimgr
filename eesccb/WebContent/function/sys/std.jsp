<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String catId = request.getParameter("catId");
%>

<div class="page">
	<div class="pageContent">
		<form method="post" action="std/stds/add" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" style="height:120px;" layoutH="160">
				<input type="hidden" name="catid" value="<%=catId %>" />
				<p>
					<label>指标名称：</label>
					<input name="name" class="required" type="text" size="30" value="" />
				</p>
				<p>
					<label>指标性质：</label>
					<input name="prop" class="" type="text" size="30" value="" />
				</p>
				<p>
					<label>单位：</label>
					<input name="unit" class="" type="text" size="30" value="" />
				</p>
				<p>
					<label>指标释义：</label>
					<input name="mean" class="" type="text" size="30" value="" />
				</p>
				<p>
					<label>标准值：</label>
					<input name="value" class="" type="text" size="30" value="" />
				</p>
				<p>
					<label>备注：</label>
					<input name="desct" class="" type="text" size="30" value="" />
				</p>
			</div>
			<div class="formBar">
				<ul>
					<!--<li><a class="buttonActive" href="javascript:void(0)"><span>保存</span></a></li>-->
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li>
						<div class="button"><div class="buttonContent"><button type="Button" onclick="navTab.closeCurrentTab()">取消</button></div></div>
					</li>
				</ul>
			</div>
		</form>
	</div>
</div>