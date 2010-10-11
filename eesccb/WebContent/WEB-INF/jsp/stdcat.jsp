<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="page">
	<div class="pageHeader">
		<div class="panelBar">
				<ul class="toolBar">
					<li><a class="add" href="../function/sys/stdCat.jsp?catId=${catId}" target="navTab"><span>添加下级分类</span></a></li>
					<li><a class="delete" href="std/stdcats/del/${catId}" target="navTabTodo" title="确定要删除吗?"><span>删除分类</span></a></li>
				</ul>
		</div>
		<form class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);" action="std/stdcats/catd" method="post">
		<div class="searchBar">
			<input type=hidden name=catid value="${stdCat.catid }"></input>
			<ul class="searchContent">
				<li>
					<label>分类名：</label>
					<input class="required" type="text" value="${stdCat.name }" name="name" />
				</li>
				<li>
					<label>分类描述：</label>
					<input type="text" value="${stdCat.desct }" name="desct" />
				</li>
			</ul>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
				</ul>
			</div>
		</div>
		</form>
	</div>
	
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="../function/sys/std.jsp?catId=${catId}" target="navTab"><span>添加标准</span></a></li>
				<li><a class="delete" href="std/stds/del/{sid_std}" target="navTabTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li><a class="edit" href="std/stds/upd/{sid_std}" target="navTab"><span>修改</span></a></li>
				<li class="line">line</li>
			</ul>
		</div>
		<table class="table" layouth="138">
			<thead>
				<tr>
					<th width="120">指标名称</th>
					<th width="100">指标性质</th>
					<th width="200">单位</th>
					<th>指标释义</th>
					<th width="80" align="center">标准值</th>
					<th width="150">备注</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${stds}" var = "item" varStatus="var">
					<tr target="sid_std" rel="${item.id}">
						<td>${item.name}</td>
						<td>${item.prop}</td>
						<td>${item.unit}</td>
						<td>${item.mean}</td>
						<td>${item.value}</td>
						<td>${item.desct}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>