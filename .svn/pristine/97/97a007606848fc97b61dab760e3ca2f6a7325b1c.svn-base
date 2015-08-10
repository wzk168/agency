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

<script type="text/javascript">
	$(function() {
		//导航切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});

		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
	})
</script>
<title>主页</title>
</head>

<body style="background: #f0f9fd;">
	<div class="lefttop">
		<span></span><a href="right.jsp" target="rightFrame">通讯录</a>
	</div>

	<dl class="leftmenu">

		<c:forEach items="${menuInfos}" var="menu">
			<dd>
				<div class="title">
					<span><img
						src="${pageContext.request.contextPath}/resources/images/${menu.msMenuImg}" />
					</span>${menu.msMenuname}
				</div>
				<ul class="menuson">
					<c:forEach items="${submenuInfos}" var="submenu">
						<c:if test="${submenu.smsMenuId ==menu.msMenuId}">
							<li><cite></cite><a
								href="${pageContext.request.contextPath}/${submenu.smsSubmenuLike}"
								target="rightFrame">${submenu.smsSubmenuName}</a><i></i></li>
						</c:if>
					</c:forEach>
				</ul>
			</dd>
		</c:forEach>
	</dl>
</body>
</html>