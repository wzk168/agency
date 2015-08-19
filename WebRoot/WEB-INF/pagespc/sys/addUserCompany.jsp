<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
<title>使用公司列表</title>
<script type="text/javascript">
//添加使用公司提交
function adduy() {
	

	$.ajax({
		type : "post",
		url : "addUserCompany.html",
		data : $("#addusercompany").serialize(),
		dataType : "text",
		success : function(data) {
			if (data > 0) {
				reloaduy();
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(errorThrown);
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
    <li><a href="#">添加使用公司</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>使用公司基本信息</span></div>
    <form id="addusercompany">
    <ul class="forminfo">
    <li><label>公司名称</label><input name="ucsCompanyName" type="text" class="textinput" /><i>标题不能超过30个字符</i></li>
    <li><label>公司编号</label><input name="ucsCompanyNumber" type="text" class="textinput" /><i>多个关键字用,隔开</i></li>
    <li><label>使用状态</label><cite><input name="ucsCompanyState" type="radio" value="1" checked="checked" />使用&nbsp;&nbsp;&nbsp;&nbsp;<input name="ucsCompanyState" type="radio" value="2" />停用</cite></li>
    <li><label>公司电话</label><input name="ucsCompanyPhone" type="text" class="dfinput" /></li>
    <li><label>公司联系人</label><input name="ucsCompanyLinkman" type="text" class="dfinput" /></li>
    <li><label>公司地址</label><input name="ucsCompanyAddress" type="text" class="dfinput" /></li>
    <li><label>&nbsp;</label><input name="" onclick="adduy()" type="button" class="btn" value="确认保存"/></li>
    </ul>
    
    </form>
    </div>
	
</body>
</html>