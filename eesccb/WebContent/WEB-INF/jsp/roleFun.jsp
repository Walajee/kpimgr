<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="page">
	<div class="pageHeader">
		<div class="panelBar">
				<ul class="toolBar">
					<li>功能权限设置</li>
				</ul>
		</div>
	</div>
	
	<form class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);" action="org/roles/funs/upd" method="post">
		<input type=hidden name="type" value="func" />
		<input type=hidden name="roleId" value="${roleId }" />
		<div>
			<table width=100%>
				<tr>
					<td>
						<c:forEach items="${funcs}" var = "item" varStatus="var">
							<c:if test="${item.hasPmn}">
								<input type="checkbox" name="funcName" value="${item.resid }" checked/>${item.name } &nbsp;&nbsp;&nbsp;
							</c:if>
							<c:if test="${!item.hasPmn}">
								<input type="checkbox" name="funcName" value="${item.resid }" />${item.name } &nbsp;&nbsp;&nbsp;
							</c:if>
						</c:forEach>
					</td>
				</tr>
			</table>
			<input type="submit" name="" value="修改">
		</div>
	</form>
</div>
