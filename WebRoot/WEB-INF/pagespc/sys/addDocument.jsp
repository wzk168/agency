<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>单证入库</title>
</head>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
	<script type="text/javascript">
	//添加部门js
	function addDept() {
		$.ajax({
			type : "post",
			url : "addDeptInfo.html",
			data : $("#adddeptfrom").serialize(),
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
			<li><a href="#">单证管理</a></li>
			<li><a href="#">单证入库</a></li>
		</ul>
	</div>
	
	<div class="formbody">
    <div class="formtitle"><span>单证入库</span></div>
    <form id="adddeptfrom">
    <ul class="forminfo">
    <li><label>部门全称</label><input name="dsDeptName" id="1" type="text" class="dfinput" /></li>
    <li><label>部门简称</label><input name="dsDeptAbbreviation" id="2" type="text" class="dfinput" /></li>
    <li><label>负责人</label><input name="dsDeptPrincipal" type="text" class="dfinput"/></li>
    <li><label>业务类型</label><cite><input name="dsDeptType" type="radio" value="1" checked="checked" />管理部&nbsp;&nbsp;&nbsp;&nbsp;<input name="ucsCompanyState" type="radio" value="2" />业务部</cite></li>
    <li><label>联系电话1</label><input name="dsDeptOnephone" type="text" class="dfinput" /></li>
    <li><label>联系电话2</label><input name="dsDeptTwophone" type="text" class="dfinput" /></li>
    <li><label>电子邮箱</label><input name="dsDeptEmail" type="text" class="dfinput" /></li>
   <li><label>地址</label><input name="dsDeptAddress" type="text" class="dfinput" /></li>
    <li><label>&nbsp;</label>
    <input name="" onclick="addDept()" type="button" class="btn" value="确认保存"/>
    <input type="button" class="btn" value=" 返回 " onclick="history.back();">
    </li>
    </ul>
    </form>
    </div>
	
<script>
//两个文本框信息同步
var o_1 = document.getElementById("1");
var o_2 = document.getElementById("2");
o_1.onkeyup = function(){
        o_2.value = o_1.value
}
</script>
</body>
</html>