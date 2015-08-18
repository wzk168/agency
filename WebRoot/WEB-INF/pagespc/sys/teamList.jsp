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
<title>团队管理列表</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">团队</a></li>
			<li><a href="#">列表</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<li class="adduydiv"><span><img
						src="${pageContext.request.contextPath}/resources/images/t01.png" onclick="beforaddUserCompany()"/></span>添加</li>
				<li class="upclick"><span><img
						src="${pageContext.request.contextPath}/resources/images/t02.png" onclick="beforUpUserCompany()"/></span>修改</li>
				<li><label>&nbsp;&nbsp;公司名称:&nbsp;</label><input
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
						<th><input type="radio" value="" /></th>
						<th>公司</th>
						<th>归属部门</th>
						<th>团队名</th>
						<th>负责人</th>
						<th>团队类型</th>
						
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty teamlist}">
						<c:forEach items="${teamlist}" var="team">
							<tr>
								<td><input name="ucsCompanyId" type="radio"
									value="${team.tsCompanyId}" /></td>
								<td>${team.tsDeptId}</td>
								<td>${team.tsTeamName }</td>
								<td>${team.ucsCompanyLinkman}</td>
								<td>${team.tsTeamPrincipal}</td>
								<td>${team.tsTeamType}</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>