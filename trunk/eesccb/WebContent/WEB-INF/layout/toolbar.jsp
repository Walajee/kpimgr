<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="toolbartab">
	<ul class="tabs-nav">
		<c:if test="${select == 'main'}">
			<li class="tabs-selected">
		</c:if>
		<c:if test="${select != 'main'}">
			<li>
		</c:if>
			<a href="main">
				<span>个人工作台</span>
			</a>
		</li>
		<c:if test="${select == 'daily'}">
			<li class="tabs-selected">
		</c:if>
		<c:if test="${select != 'daily'}">
			<li>
		</c:if>
			<a href="daily">
				<span>日常工作管理</span>
			</a>
		</li>
		<c:if test="${select == 'mark'}">
			<li class="tabs-selected">
		</c:if>
		<c:if test="${select != 'mark'}">
			<li>
		</c:if>
			<a href="mark">
				<span>评标对标</span>
			</a>
		</li>
		<c:if test="${select == 'stand'}">
			<li class="tabs-selected">
		</c:if>
		<c:if test="${select != 'stand'}">
			<li>
		</c:if>
			<a href="stand">
				<span>标准维护</span>
			</a>
		</li>
		<c:if test="${select == 'sys'}">
			<li class="tabs-selected">
		</c:if>
		<c:if test="${select != 'sys'}">
			<li>
		</c:if>
			<a href="sys">
				<span>系统管理</span>
			</a>
		</li>
	</ul>
</div>