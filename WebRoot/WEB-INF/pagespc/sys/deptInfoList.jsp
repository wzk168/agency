<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>部门管理列表</title>
</head>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
<body>
<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">组织机构</a></li>
			<li><a href="#">部门信息管理</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<li class="adduydiv"><span><img
						src="${pageContext.request.contextPath}/resources/images/t01.png" onclick="beforaddDept()"/></span>添加</li>
			<li class="upclick"><span><img
						src="${pageContext.request.contextPath}/resources/images/t02.png" onclick="beforUpDept()"/></span>修改</li>
			</ul>

		</div>
		<div class="rightinfo">
			<table class="tablelist">
				<thead>
					<tr>
						<th><input type="radio" value="" /></th>
						<th>公司</th>
						<th>部门名称</th>
						<th>部门简称</th>
						<th>负责人</th>
						<th>类型</th>
						<th>联系电话</th>
						
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty deptlist}">
						<c:forEach items="${deptlist}" var="dept" varStatus="deptnum">
							<tr>
								<td><input name="dsDeptId" type="radio"
									value="${dept.dsDeptId}" /></td>
								<td>${dept.dsCompanyId}</td>
								<td>${dept.dsDeptName}</td>
								<td>${dept.dsDeptAbbreviation}</td>
								<td>${dept.dsDeptPrincipal}</td>
								<td>
								<c:if test="${dept.dsDeptType==1}">管理部</c:if>
								<c:if test="${dept.dsDeptType==2}">业务部</c:if>
								</td>
								<td>${dept.dsDeptOnephone}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		
		//进入添加部门信息界面js
		function beforaddDept()
		{
			window.location.href = "beforAddDept.html";
		}
		//点击修改进入js
		function beforUpDept(){
			var val = $("input[name='dsDeptId']:checked").val();
			if(typeof(val)=='undefined'){
            	alert("请选择部门再点击修改按钮");
                    }else
                    {
                    	window.location.href = "beforUpdateDept.html?dsDeptId="+val;	
                    }
		}
	</script>
</body>
</html>