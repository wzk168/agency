<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/dtree.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/css/dialog.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/dtree.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/select-ui.min.js"></script>
<title>险种</title>
</head>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">系统设置</a></li>
		</ul>
	</div>

	<div class="rightinfo">
		<div id="usual1" class="usual">
			<div class="itab">
				<ul>
					<li><a href="#tab1" class="selected">险种列表</a></li>
					<li><a href="#tab2">险种类型</a></li>
					<li><a href="#tab3">险种父类</a></li>
					<li><a href="#tab4">险种子类</a></li>
				</ul>
			</div>
			<!-- 第一列表险种产品列表树 -->
			<div id="tab1" class="tabson">
				<a href="javascript: d.openAll();">打开所有</a> | 
				<a href="javascript: d.closeAll();">关闭所有</a> <br>
				
				<script type="text/javascript">
				${tree}
				</script>
			</div>
			<!-- 险种类型 -->
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
			<!-- 险种大类 -->
		<div id="tab3" class="tabson">
			<table class="tablelist">
				<thead>
					<tr>
						<th>险种父类ID</th>
						<th>险种父类名</th>
						<th>险种产品ID</th>
						<th>操作 <img
						src="${pageContext.request.contextPath}/resources/images/leftico03.png"
						class="addtypediv"/></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${prodtypelist}" var="protype">
				<tr>
					<td>${protype.ptgProdtypeId}</td>
					<td>${protype.ptgProdtypeName}</td>
					<td>${protype.ptgProdclassId}</td>
					<td><a href="#" class="tablelink">修改</a> <a href="#"
							class="tablelink"> 删除</a></td></tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
	    </div>
	 
	 
   <!-- 添加险种产品 -->
	    <div class="tip1">
			<div class="tiptop1">
				<span id="titleName">添加险种类型</span><a></a>
			</div>
			<div style="padding-top: 10px; margin-left: 25px; height: 70px">
				<div class="tipright1">
					<form id="addpcgfrom" action="" method="post">
						<p>
							<label>险种产品名:</label>&nbsp;&nbsp;<input name="pcgProdclassName"
								id="pcgProdclassNameId" type="text" class="dfinput1" /><i id="pcgProdclassNamelabel"></i>
						</p>
							<p>
							<label>险种产品名:</label>&nbsp;&nbsp;<input name="pcgProdclassName"
								id="pcgProdclassNameId" type="text" class="dfinput1" /><i id="pcgProdclassNamelabel"></i>
						</p>
					</form>
				</div>
			</div>
			<div class="tipbtn1">
				<input id="pcgup" type="button" class="sure1" value="确定" />&nbsp; <input
					id="pcgcel" type="button" class="cancel1" value="取消" />
			</div>
		</div>
	
		
	<script type="text/javascript">
		$("#usual1 ul").idTabs();
		
		
		//重新树
		function reloadprod() {
			window.location.href = "selProdectTree.html";
		}

		$(document).ready(function(){
			//险种产品弹出层
			  $("#addiv").click(function(){
				  alert();
			  $(".tip1").fadeIn(200);
			  });
			
			});
	</script>
</body>
</html>
