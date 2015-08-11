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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/dtree.js"></script>
<script type="text/javascript">
	function getid(op, parem) {
		$.ajax({
			type : "post",
			url : "loadProductInfoAjax.html",
			data : "prodId=" + op + "&prodType=" + parem,
			dataType : "json",
			success : function(data) {
				if (parem == "PCG") {
					$("#pcgProdclassNameId").val(data.pcgProdclassName);
					$("#div1").css("display", "block");
					$("#div2").css("display", "none");
					$("#div3").css("display", "none");
					//险种产品大类
				} else if (parem == "PG") {
					$("#div1").css("display", "none");
					$("#div2").css("display", "block");
					$("#div3").css("display", "none");
					//险种产品子类
				} else if (parem == "PTG") {
					$("#div1").css("display", "none");
					$("#div2").css("display", "none");
					$("#div3").css("display", "block");
					//险种产品父类
				}
				//entityinfo
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("没有相关险种信息请联系管理员");
			}
		});
	}
	//点击取消按钮
	$(document).ready(function() {
		$(".cancel").click(function() {
			$("#div1").css("display", "none");
			$("#div2").css("display", "none");
			$("#div3").css("display", "none");
		});

	});
</script>
<title>险种</title>
<style type="text/css">
#apDiv1 {
	position: absolute;
	width: 50%;
	height: 80%;
	z-index: 1;
	left: 6%;
	top: 10%;
}

#apDiv2 {
	position: absolute;
	z-index: 2;
	left: 45%;
	top: 15%;
}
</style>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">险种</a></li>
			<li><a href="#">险种产品</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div id="apDiv1" class="dtree">
			<p>
				<a href="javascript: d.openAll();">打开所有</a> | <a
					href="javascript: d.closeAll();">关闭所有</a>
			</p>
			<script type="text/javascript">
				${tree}
			</script>
		</div>

		<div id="apDiv2">
			<div style="display: none;" id="div1">
				<div class="tiptop">
					<span id="titleName">险种产品</span><a></a>
				</div>
				<div style="padding-top: 30px; margin-left: 25px; height: 50px">
					<div class="tipright">
						<form id="addMenuForm" action="" method="post">
							<p>
								<label>菜单名:</label>&nbsp;&nbsp;<input name="pcgProdclassName"
									id="pcgProdclassNameId" type="text" class="dfinput" />
							</p>

						</form>
					</div>
				</div>

				<div class="tipbtn">
					<input name="" type="button" class="sure" value="确定" />&nbsp; <input
						name="" type="button" class="cancel" value="取消" />
				</div>
			</div>
			<!-- 第二个div -->
         <div style="display: none;" id="div2">
				<div class="tiptop">
					<span id="titleName">险种父类</span><a></a>
				</div>
				<div style="padding-top: 30px; margin-left: 25px; height: 80px">
					<div class="tipright">
						<form id="addMenuForm" action="" method="post">
							<p>
								<label>菜单名:</label>&nbsp;&nbsp;<input name="pcgProdclassName"
									id="pcgProdclassNameId" type="text" class="dfinput" />
							</p>
                            <p>
								<label>菜单名:</label>&nbsp;&nbsp;<input name="pcgProdclassName"
									id="pcgProdclassNameId" type="text" class="dfinput" />
							</p>
						</form>
					</div>
				</div>

				<div class="tipbtn">
					<input name="" type="button" class="sure" value="确定" />&nbsp; <input
						name="" type="button" class="cancel" value="取消" />
				</div>
			</div>			
			<!-- 第三个div -->
			  <div style="display: none;" id="div3">
				<div class="tiptop">
					<span id="titleName">险种子类</span><a></a>
				</div>
				<div style="padding-top: 30px; margin-left: 25px; height: 80px">
					<div class="tipright">
						<form id="addMenuForm" action="" method="post">
							<p>
								<label>菜单名:</label>&nbsp;&nbsp;<input name="pcgProdclassName"
									id="pcgProdclassNameId" type="text" class="dfinput" />
							</p>
                            <p>
								<label>菜单名:</label>&nbsp;&nbsp;<input name="pcgProdclassName"
									id="pcgProdclassNameId" type="text" class="dfinput" />
							</p>
						</form>
					</div>
				</div>

				<div class="tipbtn">
					<input name="" type="button" class="sure" value="确定" />&nbsp; <input
						name="" type="button" class="cancel" value="取消" />
				</div>
			</div>	
			<!--  -->
		</div>
	</div>
</body>
</html>