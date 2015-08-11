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
	function getid(op,parem) {
		$.ajax({
			type : "post",
			url : "loadProductInfoAjax.html",
			data : "prodId="+op+"&prodType="+parem,
			dataType : "json",
			success : function(data) {
				if(parem=="PCG")
				{
					$("#pcgProdclassNameId").val(data.pcgProdclassName);
					$("#div1").css("display","block");
					//险种产品大类
				}else if(parem=="PG")
				{
					alert("2");
					//险种产品子类
				}else if(parem=="PTG")
				{
					alert("3");
					//险种产品父类
				
				}
				//entityinfo
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("没有相关险种信息请联系管理员");
			}
		});
	}
	function backMethod(data) {
		alert(data)
	}
</script>
<title>险种</title>
<style type="text/css">
#apDiv1 {
	position: absolute;
	width: 50%;
	height: 80%;
	z-index: 1;
	left: 3%;
	top: 10%;
}

#apDiv2 {
	position: absolute;
	width: 600px;
	height: 600px;
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
	<div id="apDiv1">
		<p>
			<a href="javascript: d.openAll();">打开所有</a> | <a
				href="javascript: d.closeAll();">关闭所有</a>
		</p>
		<script type="text/javascript">
			${tree}
		</script>
	</div>
	<div class="apDiv2" id="apDiv2">
		<div id="div1" style="display: none;">
	<ul class="forminfo">
	                 <li><div class="formtext">Hi保险产品!!!</div></li>
					<li><label>险种类型名称<b>*</b></label><input id="pcgProdclassNameId" name="pcgProdclassName" type="text"
						class="dfinput" style="width: 300px;" /></li>
					<li><label>&nbsp;</label>
					<input name="" type="button" class="btn" value="保存添加" /></li>
			</ul>
		</div>
		<div id="div2" style="display: none;">
		dgdfg
		</div>
		<div id="div3" style="display: none;">
		dgdfg
		</div>
	</div>
</body>
</html>