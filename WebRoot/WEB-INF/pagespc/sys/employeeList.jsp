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
<title>员工信息管理</title>
<script type="text/javascript">


</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">平台</a></li>
			<li><a href="#">员工信息管理</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<li class="adduydiv" onclick="beforAddEmployee()"><span><img
						src="${pageContext.request.contextPath}/resources/images/t01.png" onclick="beforaddUserCompany()"/></span>添加</li>
				<li class="upclick"><span><img
						src="${pageContext.request.contextPath}/resources/images/t02.png" onclick="beforUpUserCompany()"/></span>修改</li>
				<li><label>&nbsp;&nbsp;员工姓名:&nbsp;</label><input
					id="ucsCompanyNameId" type="text" class="dfinput" /></li>
				<li><span><img
						src="${pageContext.request.contextPath}/resources/images/ico06.png"
						class="seluy" onclick="userCompanyList()"/></span></li>
			</ul>

		</div>
		<div class="rightinfo">
			<table class="tablelist">
				<thead>
					<tr>
						<th width="5%"><input type="radio" value="" /></th>
						<th>使用公司<i class="sort"><img
								src="${pageContext.request.contextPath}/resources/images/px.gif" /></i></th>
						<th>员工姓名</th>
						<th>部门</th>
						<th>团队</th>
						<th>入职时间</th>
						<th>是否在职</th>
						<th>业务员</th>
					</tr>
				</thead>
				<tbody>
					
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		
		//加载进入添加员工信息界面js
		function beforAddEmployee()
		{
				window.location.href = "beforAddEmployee.html";	
		}
	</script>
</body>
</html>