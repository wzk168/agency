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

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/uicss/jquery.ui.core.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/uicss/jquery-ui.css">
<script
	src="${pageContext.request.contextPath}/resources/js/jqueryui/jquery.ui.core.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jqueryui/jquery.ui.widget.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jqueryui/jquery.ui.button.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jqueryui/jquery.ui.position.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jqueryui/jquery.ui.dialog.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/form.validation.js"></script>
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
				<div class="tools">
					<ul class="toolbar">
						<li class="adduydiv" onclick="beforAddInstit()"><span><img
								src="${pageContext.request.contextPath}/resources/images/t01.png" /></span>添加</li>
						<li class="upclick" onclick="beforUpInstit()"><span><img
								src="${pageContext.request.contextPath}/resources/images/t02.png" /></span>修改</li>
						<li><label>&nbsp;&nbsp;公司简称:&nbsp;</label><input
							id="ucsCompanyNameId" type="text" class="dfinput" /></li>
						<li><label>&nbsp;&nbsp;出单情况:&nbsp;</label> <select
							style="height: 28px;">
								<option value="0">--请选择--</option>
								<option value="1">正常出单</option>
								<option value="2">停止出单</option>
						</select></li>
						<li><span><img
								src="${pageContext.request.contextPath}/resources/images/ico06.png"
								class="seluy" onclick="userCompanyList()" /></span></li>
					</ul>

				</div>
				<table class="tablelist" width="98%">
					<thead>
						<tr>
							<th></th>
							<th>公司</th>
							<th>保险公司</th>
							<th>业务类型</th>
							<th>出单情况</th>
							<th>联系人</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${insurancelist}" var="insur">
							<tr>
								<td><input name="icgInscomp" id="icgInscomp" type="radio" 
									value="${insur.icgInscompanyId}" /></td>
								<td>${insur.icgCompanyId }</td>
								<td>${insur.icgInscompanyShort }</td>
								<td><c:if test="${insur.icgInscompanyType==1}">综合业务</c:if>
									<c:if test="${insur.icgInscompanyType==2}">产线</c:if> <c:if
										test="${insur.icgInscompanyType==3}">车险</c:if> <c:if
										test="${insur.icgInscompanyType==4}">寿险</c:if></td>
								<td><c:if test="${insur.icgInscompanySituation==1}">正常出单</c:if>
									<c:if test="${insur.icgInscompanySituation==2}">停止出单</c:if></td>
								<td>${insur.icgInscompanyMan }</td>
							<tr>
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
								src="${pageContext.request.contextPath}/resources/images/t01.png" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${proclaslist}" var="proclas">
							<tr>
								<td>${proclas.pcgProdclassId}</td>
								<td>${proclas.pcgProdclassName}</td>
								<td><a href="#" class="tablelink">修改</a>
						</c:forEach>
					</tbody>
				</table>
			</div>



		</div>
	</div>

	<script type="text/javascript">
		$("#usual1 ul").idTabs();
		$('.tablelist tbody tr:odd').addClass('odd');
		//进入添加
		function beforAddInstit()
		{
			window.location.href = "beforAddInstition.html";
		}
		
		function beforUpInstit()
		{
			var val = $("input[name='icgInscomp']:checked").val();
			
			alert(val);
		if(typeof(val)=='undefined')
		{
        	alert("请选择保险公司再点击修改按钮");
        	return false;
        }else{
        	window.location.href = "beforSelInstitonEntity.html?icgInscompanyId="+val;
         }
		}
	</script>
</body>
</html>