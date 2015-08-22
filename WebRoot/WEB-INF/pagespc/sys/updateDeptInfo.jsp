<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>修改部门信息</title>
</head>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
	<script type="text/javascript">
	//添加部门js
	function upDept() {
		$.ajax({
			type : "post",
			url : "updateDept.html",
			data : $("#updeptfrom").serialize(),
			dataType : "text",
			success : function(data) {
				if (data > 0) {
					relodept();
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
			}
		});
	}
	//重新加载部门信息列表js
	function relodept() {
		window.location.href = "loadDeptInfoList.html";
	}
	</script>
<body>
<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">组织机构</a></li>
			<li><a href="#">修改部门信息</a></li>
		</ul>
	</div>
	
	<div class="formbody">
    <div class="formtitle"><span>修改部门基本信息</span></div>
    <form id="updeptfrom">
    <ul class="forminfo">
    <li><label>部门全称</label><input name="dsDeptName" value="${dept.dsDeptName}" type="text" class="dfinput" size="40"/></li>
    <li><label>部门简称</label><input name="dsDeptAbbreviation" value="${dept.dsDeptAbbreviation}" type="text" class="dfinput" size="40"/></li>
    <li><label>负责人</label><input name="dsDeptPrincipal" value="${dept.dsDeptPrincipal}" type="text" class="dfinput" size="40"/></li>
    <li><label>业务类型</label><cite><input name="dsDeptType" type="radio" value="1" <c:if test="${dept.dsDeptType==1}">checked="checked"</c:if> />管理部&nbsp;&nbsp;&nbsp;&nbsp;<input name="ucsCompanyState" type="radio" value="2" <c:if test="${dept.dsDeptType==2}">checked="checked"</c:if>  />业务部</cite></li>
    <li><label>联系电话1</label><input name="dsDeptOnephone" value="${dept.dsDeptOnephone}" type="text" class="dfinput" size="40"/></li>
    <li><label>联系电话2</label><input name="dsDeptTwophone" value="${dept.dsDeptTwophone}" type="text" class="dfinput" size="40"/></li>
    <li><label>电子邮箱</label><input name="dsDeptEmail" value="${dept.dsDeptEmail}" type="text" class="dfinput" size="40"/></li>
   <li><label>地址</label><input name="dsDeptAddress" value="${dept.dsDeptAddress}" type="text" class="dfinput" size="40"/></li>
    <li><label>&nbsp;</label>
    <input type="hidden" value="${dept.dsDeptId}" name="dsDeptId">
    <input type="hidden" value="${dept.dsCompanyId}" name="dsCompanyId">
    <input name="" onclick="upDept()" type="button" class="btn" value="确认修改"/>
    <input type="button" class="btn" value=" 返回 " onclick="history.back();">
    </li>
    </ul>
    </form>
    </div>
	
	
</body>
</html>