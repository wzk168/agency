<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>机构管理列表</title>
</head>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.idTabs.min.js"></script>
<body>
<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">合作机构</a></li>
			<li><a href="#">保险公司/分支机构管理</a></li>
		</ul>
	</div>
		<div class="rightinfo">
		<div id="usual1" class="usual">
			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">保险公司</a></li>
					<li><a href="#tab2">保险公司分支机构</a></li>
				</ul>
			</div>
			
			
			<!-- 保险公司 -->
			<div id="tab1" class="tabson">
				<table class="tablelist">
				<thead>
					<tr>
						<th>险种产品ID</th>
						<th>险种产品名</th>
						<th>操作 <img
						src="${pageContext.request.contextPath}/resources/images/leftico03.png"
						 id="addiv"/></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${proclaslist}" var="proclas">
				<tr>
					<td>${proclas.pcgProdclassId}</td><td>${proclas.pcgProdclassName}</td>
					<td><a href="#" class="tablelink" >修改</a>
				</c:forEach>
				</tbody>
			</table>
			</div>
			<!-- 保险公司分支机构 -->
			<div id="tab2" class="tabson">
					<table class="tablelist">
				<thead>
					<tr>
						<th>险种产品ID</th>
						<th>险种产品名</th>
						<th>操作 <img
						src="${pageContext.request.contextPath}/resources/images/leftico03.png"
						 id="addiv"/></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${proclaslist}" var="proclas">
				<tr>
					<td>${proclas.pcgProdclassId}</td><td>${proclas.pcgProdclassName}</td>
					<td><a href="#" class="tablelink" >修改</a>
				</c:forEach>
				</tbody>
			</table>
			</div>
			
			
			
			</div>
			</div>
	<script type="text/javascript">
		$("#usual1 ul").idTabs();
		</script>
</body>
</html>