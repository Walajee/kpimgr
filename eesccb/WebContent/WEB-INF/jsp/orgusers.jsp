<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="page">
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="../function/sys/addUser.jsp?orgId=${orgId}" target="navTab"><span>添加</span></a></li>
				<li><a class="delete" href="org/users/del/{sid_user}" target="navTabTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li><a class="edit" href="org/users/upd/{sid_user}" target="navTab"><span>修改</span></a></li>
				<li class="line">line</li>
				<li><a class="icon" href="javascript:void(0);"><span>导入EXCEL</span></a></li>
			</ul>
		</div>
		<table class="table" layouth="138">
			<thead>
				<tr>
					<th width="120">登录名</th>
					<th >姓名</th>
					<th width="200">邮箱</th>
					<th width="150">电话</th>
					<th width="80" align="center">用户状态</th>
					<th width="150">创建时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var = "item" varStatus="var">
					<tr target="sid_user" rel="${item.uid}">
						<td>${item.account}</td>
						<td>${item.name}</td>
						<td>${item.email}</td>
						<td>${item.phone}</td>
						<td>${item.stats}</td>
						<td>${item.crtTime}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>