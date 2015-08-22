<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		//顶部导航切换
		$(".nav li a").click(function() {
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		})
	})
</script>
<title>Insert title here</title>
</head>

<body style="background: url(../images/topbg.gif) repeat-x;">

	<div class="topleft">
		<a href="main.html" target="_parent"><img src="../images/logo.png"
			title="系统首页" /></a>
	</div>



	<div class="topright">
		<ul>
			<li><span><img src="../images/help.png" title="帮助"
					class="helpimg" /></span><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
			<li><a href="${pageContext.request.contextPath}/user/goOut.html"
				target="_parent">退出</a></li>
		</ul>

		<div class="user">
			<span>${userInfo.uosUserinfoName}</span> <i>消息</i> <b>5</b>
		</div>

	</div>

</body>
</html>