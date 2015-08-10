<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
<title>修改使用公司</title>
<script type="text/javascript">
	//修改使用公司提交
	function uy() {
		
		$.ajax({
			type : "post",
			url : "upUserCompanyController.html",
			data : $("#upusercompany").serialize(),
			dataType : "text",
			success : function(data) {
				if (data > 0) {
					reloaduy();
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("修改错误请重新修改");
			}
		});
	}
	//重新加载使用公司
	function reloaduy() {
		window.location.href = "beforUserCompanyList.html";
	}
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">使用公司</a></li>
			<li><a href="#">修改使用公司</a></li>
		</ul>
	</div>

	<div class="formbody">

		<div class="formtitle">
			<span>修改公司基本信息</span>
		</div>
		<form id="upusercompany" class="uyfrom">
			<ul class="forminfo">
				<li><label>公司名称</label><input name="ucsCompanyName"
					value="${uy.ucsCompanyName}" type="text" class="dfinput" /><i
					class="alertCompanyName"></i></li>
				<li><label>公司编号</label><input name="ucsCompanyNumber"
					value="${uy.ucsCompanyNumber}" type="text" class="dfinput" /><i
					class="alertCompanyNumber"></i></li>
				<li><label>使用状态</label><cite> <input
						name="ucsCompanyState" type="radio" value="1"
						<c:if test="${uy.ucsCompanyState==1}">checked="checked"</c:if> />使用&nbsp;&nbsp;&nbsp;&nbsp;
						<input name="ucsCompanyState" type="radio" value="2"
						<c:if test="${uy.ucsCompanyState==2}">checked="checked"</c:if> />停用
				</cite></li>
				<li><label>公司电话</label><input name="ucsCompanyPhone"
					value="${uy.ucsCompanyPhone}" type="text" class="dfinput" /><i
					class="alertCompanyPhone"></i></li>
				<li><label>公司联系人</label><input name="ucsCompanyLinkman"
					value="${uy.ucsCompanyLinkman}" type="text" class="dfinput" /><i
					class="alertCompanyLinkman"></i></li>
				<li><label>公司地址</label><input name="ucsCompanyAddress"
					value="${uy.ucsCompanyAddress}" type="text" class="dfinput" /><i
					class="alertCompanyAddress"></i></li>
				<li><label>&nbsp;</label><input type="button" class="btn"
					value="修改保存" onclick="uy()" /> <input name="ucsCompanyId"
					value="${uy.ucsCompanyId}" type="hidden" /> <input
					onclick="history.back();" type="button" class="btn" value="返回" />
				</li>
			</ul>
		</form>
	</div>


</body>
</html>
