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
	//分页
	function turnPage(op) 
	{
	   window.location.href="userCompanyList.html?pageNow="+op;
	}
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
						<th>编号<i class="sort"><img
								src="${pageContext.request.contextPath}/resources/images/px.gif" /></i></th>
						<th>名称</th>
						<th>状态</th>
						<th>联系人</th>
						<th>联系电话</th>
						<th>公司地址</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty uslist}">
						<c:forEach items="${uslist}" var="us">
							<tr>
								<td><input name="ucsCompanyId" type="radio"
									value="${us.ucsCompanyId}" /></td>
								<td>${us.ucsCompanyId}</td>
								<td>${us.ucsCompanyName}</td>
								<td><c:if test="${us.ucsCompanyState==1}">使用</c:if> 
								<c:if test="${us.ucsCompanyState==2}">停用</c:if></td>
								<td>${us.ucsCompanyLinkman}</td>
								<td>${us.ucsCompanyPhone}</td>
								<td>${us.ucsCompanyAddress}</td>
							</tr>
						</c:forEach>
					</c:if>
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
	</script>
</body>
</html>