<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="page">
	<div class="pageContent">
		<form method="post" action="org/users/supd" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" style="height:120px;" layoutH="160">
				<input type="hidden" name="uid" value="${user.uid}" />
				<p>
					<label>登录名：</label>
					<input name="account" class="required" type="text" size="30" value="${user.account }" alt="请输入登录名"/>
				</p>
				<p>
					<label>密码：</label>
					<input name="pwd" type="password" class="required" size="30" value="${user.pwd}" alt="请输入密码"/ />
				</p>
				<p>
					<label>用户姓名：</label>
					<input name="name" class="required" type="text" size="30" value="${user.name}" alt="请输入姓名"/>
				</p>
				<p>
					<label>邮箱：</label>
					<input name="email"  type="text" size="30" value="${user.email}" alt="请输入数字"/>
				</p>
				<p>
					<label>电话：</label>
					<input name="phone" type="text" value="${user.phone }" size="30" />
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