<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="page">
	<div class="pageContent">
		<div class="panelBar">
			<ul class="toolBar">
				<li><a class="add" href="../function/sys/addRole.jsp" target="navTab"><span>添加</span></a></li>
				<li><a class="delete" href="org/roles/del/{sid_role}" target="navTabTodo" title="确定要删除吗?"><span>删除</span></a></li>
				<li class="line">line</li>
				<li><a class="icon" href="org/roles/funs/{sid_role}" target="navTab" ><span>功能权限</span></a></li>
				<li><a class="add" href="org/roles/del/{sid_role}" target="navTabTodo" ><span>日常标准维护权限</span></a></li>
			</ul>
		</div>
		<table class="table" layouth="138">
			<thead>
				<tr>
					<th width="120">角色名</th>
					<th >描述</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${roles}" var = "item" varStatus="var">
					<tr target="sid_role" rel="${item.id}">
						<td>${item.name}</td>
						<td>${item.desct}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
