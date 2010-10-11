<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String stdId = request.getParameter("stdId");
%>

<div class="page">
	<div class="pageContent">
		<form method="post" action="std/stds/tpl/upload" class="pageForm required-validate" enctype="multipart/form-data">
			<div class="pageFormContent"  layoutH="55">
				<input type="hidden" name=stdId value="<%=stdId %>" />
				<p>
					<label>模板一：</label>
					<input name="file1"  type="file" size="20" value="" />
				</p>
				<p>
					<label>模板二：</label>
					<input name="file2"  type="file" size="20" value="" />
				</p>
				<p>
					<label>模板三：</label>
					<input name="file3"  type="file" size="20" value="" />
				</p>
				<p>
					<label>模板四：</label>
					<input name="file4"  type="file" size="20" value="" />
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
