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
<link href="${pageContext.request.contextPath}/resources/css/select.css"
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

<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 300
		});

	});
</script>
<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">系统设置</a></li>
		</ul>
	</div>

	<div class="formbody">
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
						class="addpcg"/></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${proclaslist}" var="proclas">
				<tr>
					<td>${proclas.pcgProdclassId}</td><td>${proclas.pcgProdclassName}</td>
					<td><a href="#" class="tablelink" onclick="uppcg('${proclas.pcgProdclassId}')" >修改</a> <a href="#"
							class="tablelink"> 删除</a></td></tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
			
			
			
		</div>
	    </div>
	    
	    <!-- 添加险种产品 -->
	    <div class="tip1" id="addpcgdiv">
			<div class="tiptop">
				<span id="titleName">添加险种类型</span><a></a>
			</div>
			<div style="padding-top: 30px; margin-left: 25px; height: 70px">
				<div class="tipright">
					<form id="addpcgfrom" action="" method="post">
						<p>
							<label>险种产品名:</label>&nbsp;&nbsp;<input name="pcgProdclassName"
								id="pcgProdclassNameId" type="text" class="dfinput1" /><i id="pcgProdclassNamelabel"></i>
						</p>
					</form>
				</div>
			</div>
			<div class="tipbtn">
				<input id="addpcgbut" type="button" class="sure" value="确定" />&nbsp; <input
					id="celpcgbut" type="button" class="cancel" value="取消" />
			</div>
		</div>
		<!-- 修改险种产品 -->
		    <div class="tip2" id="uppcgdiv">
			<div class="tiptop">
				<span id="titleName">修改险种类型</span><a></a>
			</div>
			<div style="padding-top: 30px; margin-left: 25px; height: 70px">
				<div class="tipright">
					<form id="addpcgfrom" action="" method="post">
						<p>
							<label>险种产品名:</label>&nbsp;&nbsp;<input name="pcgProdclassName"
								id="pcgProdclassNameId" type="text" class="dfinput1" /><i id="pcgProdclassNamelabel"></i>
						</p>
					</form>
				</div>
			</div>
			<div class="tipbtn">
				<input id="pcgup" type="button" class="sure" value="确定" />&nbsp; <input
					id="uppcgcel" type="button" class="cancel" value="取消" />
			</div>
		</div>
		
	<script type="text/javascript">
		$("#usual1 ul").idTabs();
		
		$(document).ready(function(){
			//险种产品弹出层
			  $(".addpcg").click(function(){
			  $(".tip1").fadeIn(200);
			  });
			//险种产品关闭层
			  $("#celpcgbut").click(function(){
				  $(".tip1").fadeOut(100);
				});
			  
			});
		
		function addpcg()
		{
			//添加险种产品信息
	
				  if($("#pcgProdclassNameId").val().replace(/\ +/g, "")==null || $("#pcgProdclassNameId").val().replace(/\ +/g, "")=="")
				  {
					  $("#pcgProdclassNamelabel").html(
						'<font color="red" size="12px">险种大类不为空</font>');
			     	return false;
				  }
				  $.ajax({
						type : "post",
						url : "addProductInfo.html",
						data : $("#addpcgfrom").serialize(),
						dataType : "text",
						success : function(data) {
							if (data > 0) {
								reloadprod();
							}
						},
						error : function(XMLHttpRequest, textStatus, errorThrown) {
							alert(errorThrown);
						}
					});
		}
		 //险种产品点击修改
		function uppcg(prodId)
		{
		    	if(confirm("你确定要修改该险种产品吗???"))
		    	{
		    		 $.ajax({
							type : "post",
							url : "addProductInfo.html?prodId="+prodId+"&prodType='PCG'",
							data : $("#addpcgfrom").serialize(),
							dataType : "text",
							success : function(data) {
								if (data > 0) {
									  $("#uppcgdiv").fadeIn(200);
								}
							},
							error : function(XMLHttpRequest, textStatus, errorThrown) {
								alert(errorThrown);
							}
						});
		    	}
		    	
		
		}
		//重新树
		function reloadprod() {
			window.location.href = "selProdectTree.html";
		}
	</script>
</body>
</html>
