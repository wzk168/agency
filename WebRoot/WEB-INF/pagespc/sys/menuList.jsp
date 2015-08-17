<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/menu.js"></script>
<title>系统菜单列表</title>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">系统管理</a></li>
			<li><a href="#">菜单列表</a></li>
		</ul>
	</div>

	<div class="rightinfo">

		<div class="tools">

			<ul class="toolbar">
				<li class="click" id="addmsg"><span><img
						src="${pageContext.request.contextPath}/resources/images/t01.png" /></span>添加</li>
				<li class="click" id="updatemsg"><span><img
						src="${pageContext.request.contextPath}/resources/images/t02.png" /></span>修改</li>
				<li><span><img
						src="${pageContext.request.contextPath}/resources/images/t03.png" /></span>删除</li>
			</ul>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th>&nbsp;</th>
					<th>编号<i class="sort"><img
							src="${pageContext.request.contextPath}/resources/images/px.gif" /></i></th>
					<th>菜单名</th>
					<th>图片</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${menuInfos}" var="menuList">
					<tr>
						<td><input name="msMenuId" type="radio"
							value="${menuList.msMenuId}" /></td>
						<td>${menuList.msMenuId}</td>
						<td>${menuList.msMenuname}</td>
						<td>${menuList.msMenuImg}</td>
						<td><a href="#" class="tablelink">查看子菜单</a></td>
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

		<div class="tip">
			<div class="tiptop">
				<span id="titleName">添加菜单</span><a></a>
			</div>

			<div style="padding-top: 30px; margin-left: 25px; height: 95px">
				<div class="tipright">
					<form id="addMenuForm" action="" method="post">
						<p>
							<label>菜单名:</label>&nbsp;&nbsp;<input name="msMenuname"
								id="msMenuname" type="text" class="dfinput" />
						</p>
						<p style="margin-top: 5px;">
							<label>图片名:</label>&nbsp;&nbsp;<input name="msMenuImg"
								id="msMenuImg" type="text" class="dfinput" />
						</p>
						<input type="hidden" id="msMenuId" name="msMenuId">
					</form>
				</div>
			</div>

			<div class="tipbtn">
				<input name="" type="button" class="sure" value="确定" />&nbsp; <input
					name="" type="button" class="cancel" value="取消" />
			</div>
		</div>
	</div>
</body>
</html>