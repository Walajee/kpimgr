<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="page">
	<div class="pageContent">
		<form method="post" action="std/stds/upds" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
			<div class="pageFormContent" style="height:120px;" layoutH="160">
				<input type="hidden" name="id" value="${std.id}" />
				<p>
					<label>指标名称：</label>
					<input name="name" class="required" type="text" size="30" value="${std.name }"/>
				</p>
				<p>
					<label>指标性质：</label>
					<input name="prop" type="text" size="30" value="${std.prop}"/ />
				</p>
				<p>
					<label>单位：</label>
					<input name="unit" class="required" type="text" size="30" value="${std.unit}"/>
				</p>
				<p>
					<label>指标释义：</label>
					<input name="mean"  type="text" size="30" value="${std.mean}"/>
				</p>
				<p>
					<label>标准值：</label>
					<input name="value" type="text" value="${std.value }" size="30" />
				</p>
				<p>
					<label>备注：</label>
					<input name="desct" type="text" value="${std.desct }" size="30" />
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