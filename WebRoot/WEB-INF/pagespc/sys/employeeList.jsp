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
				<li class="upclick" onclick="beforUpEmp()"><span><img
						src="${pageContext.request.contextPath}/resources/images/t02.png" onclick="beforUpUserCompany()"/></span>修改</li>
				<li><label>&nbsp;&nbsp;员工姓名:&nbsp;</label><input
					id="esEmplNameId" type="text" class="dfinput" /></li>
						<li><label>&nbsp;&nbsp;归属部门:&nbsp;</label>
						<select class="dfinput" id="esEmpDeptId">
						<option value="">--请选择部门--</option>
						<c:forEach items="${deptlist}" var="dept">
						<option value="${dept.deptId}">${dept.deptName}</option>
						</c:forEach>
						</select>
						</li>
				<li><span><img
						src="${pageContext.request.contextPath}/resources/images/ico06.png"
						class="seluy" onclick="turnPage(1)"/></span></li>
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
					<c:forEach items="${emplist}" var="emp">
					<tr>
					<td>
					<input type="radio" value="${emp.empId}" name="empId">
					</td>
					<td>${emp.empCompanyName}</td>
					<td>${emp.empName}</td>
					<td>${emp.empDeptName}</td>
					<td>${emp.empTeamName}</td>
					<td>${emp.empTheTime}</td>
					<td>${emp.empTheJob}</td>
					<td>${emp.empSalesMan}</td>
					</tr>
					</c:forEach>
					
				</tbody>
			</table>
			
				<div class="pagin">
			<div class="message">
				共<i class="blue">${page.totalSize}</i>条记录，总页数${page.totalPage}页,
				当前显示第&nbsp;<i class="blue">${page.pageNow}&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem"><c:choose>
						<c:when test="${page.hasPre}">
							<a href="javascript:;" onclick="turnPage('${page.pageNow-1}')"><span
								class="pagepreblue"></span></a>
						</c:when>
						<c:otherwise>
							<a href="javascript:;"><span class="pagepre"
								onclick="turnPage(1)"></span></a>
						</c:otherwise>
					</c:choose></li>
				<li class="paginItem"><a href="javascript:;"
					onclick="turnPage(1)">首页</a></li>
				<li class="paginItem"><a href="javascript:;"
					onclick="turnPage(${page.totalPage})">尾页</a></li>
				<li class="paginItem"><c:if test="${!page.hasNext}">
						<a href="javascript:;" onclick="turnPage('${page.pageNow}')"><span
							class="pagenxt"></span></a>
					</c:if> <c:if test="${page.hasNext}">
						<a href="javascript:;"><span class="pagenxtblue"
							onclick="turnPage('${page.pageNow+1}')"></span></a>
					</c:if></li>
			</ul>
		</div>
		</div>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
		
		//加载进入添加员工信息界面js
		function beforAddEmployee()
		{
				window.location.href = "beforAddEmployee.html";	
		}
		//分页
		function turnPage(op) 
		{
		   window.location.href="beforLoadEmployeeList.html?pageNow="
				   +op+"&esEmplName="+$("#esEmplNameId").val()+"&esDeptId="+$("#esEmpDeptId").val();
		}
		
		//进入修改员工界面
		function beforUpEmp() {
			var val = $("input[name='empId']:checked").val();
			if(typeof(val)=='undefined'){
            	alert("请选择员工再点击修改按钮");
                    }else
                    {
                    	window.location.href = "loadEmployeeEntity.html?empId="+val;
                    }
		}
		
	</script>
</body>
</html>