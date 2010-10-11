<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="page">
	<div class="pageHeader">
		<div class="panelBar">
				<ul class="toolBar">
					<li><a class="delete" href="std/stds/del/${std.id}" target="navTabTodo" title="确定要删除吗?"><span>删除</span></a></li>
					<li><a class="edit" href="std/stds/upd/${std.id}" target="navTab"><span>修改</span></a></li>
				</ul>
		</div>
	</div>
	
	<form class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);" action="std/stds/del/${std.id}" method="post">
		<div>
			<table width=100%>
				<tr>
					<th height=25  width="30%">名称</td>
					<th align="left" width="70%">${std.name }</th>
				</tr>
				<tr>
					<th bgcolor="#EEEEEE" height=25  width="30%">指标性质</td>
					<td bgcolor="#EEEEEE" width="70%">${std.prop }</td>
				</tr>
				<tr>
					<th height=25  width="30%">单位</td>
					<td width="70%">${std.unit }</td>
				</tr>
				<tr>
					<th bgcolor="#EEEEEE" height=25  width="30%">指标释义</td>
					<th bgcolor="#EEEEEE" width="70%">${std.mean }</th>
				</tr>
				<tr>
					<th height=25  width="30%">标准值</td>
					<td width="70%">${std.value }</td>
				</tr>
				<tr>
					<th bgcolor="#EEEEEE" height=25  width="30%">备注</td>
					<td bgcolor="#EEEEEE" width="70%">${std.desct }</td>
				</tr>
			</table>
		</div>
	</form>

<div class="pageContent">
	<div class="panelBar">
				<ul class="toolBar">
					<li><a class="add" href="../function/sys/addTpl.jsp?stdId=${std.id}" target="dialog" rel="dlg_page1"><span>上传模板</span></a></li>
					<li><a class="delete" href="std/stds/tpl/del/{sid_std}" target="navTabTodo" title="确定要删除吗?"><span>删除</span></a></li>
				</ul>
	</div>
	<table class="table" layouth="138">
			<thead>
				<tr>
					<th height=25 width="30%">模板名</th>
					<th width="40%">上传时间</th>
					<th width="30%">上传人</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${std.tpls}" var = "item" varStatus="var">
					<tr target="sid_std" rel="${item.tplid}">
						<td height=25>${item.name}</td>
						<td>${item.deployDate}</td>
						<td>${item.creator}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>