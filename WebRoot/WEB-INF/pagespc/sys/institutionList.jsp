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
<body onload="onlaod()">
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
					<li><a href="#tab1" class="selected" id="insurtab">保险公司</a></li>
					<li><a href="#tab2" id="branchtab">保险公司分支机构</a></li>
				</ul>
			</div>
			<!-- 保险公司 -->
			<div id="tab1" class="tabson">
				<div class="tools">
					<ul class="toolbar">
						<li class="adduydiv" onclick="beforAddInstit()"><span><img
								src="${pageContext.request.contextPath}/resources/images/t01.png" /></span>添加</li>
						<li class="upclick" ><span><img
								src="${pageContext.request.contextPath}/resources/images/t02.png"
								onclick="beforUpInstit()"/></span>修改</li>
					</ul>
				</div>
				<table class="tablelist" width="98%">
					<thead>
						<tr>
							<th>操作</th>
							<th>公司</th>
							<th>保险公司</th>
							<th>联系人</th>
							<th>业务类型</th>
							<th>出单情况</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${insurancelist}" var="insurance">
							<tr>
							<td><input type="radio" name="icgInscompanyRido" value="${insurance.icgInscompanyId}"></td>
							<td>${insurance.icgCompanyId}</td>
							<td>${insurance.icgInscompanyShort}</td>
							<td>${insurance.icgInscompanyMan}</td>
							<td>
							<c:if test="${insurance.icgInscompanyType==1}">综合业务</c:if>
							<c:if test="${insurance.icgInscompanyType==2}">产险</c:if>
							<c:if test="${insurance.icgInscompanyType==3}">车险</c:if>
							<c:if test="${insurance.icgInscompanyType==4}">寿险</c:if>
							</td>
							<td>
							<c:if test="${insurance.icgInscompanySituation==1}">正常出单</c:if>
							<c:if test="${insurance.icgInscompanySituation==2}">停止出单</c:if>
							</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- 保险公司分支机构 -->
			<div id="tab2" class="tabson">
			<div class="tools">
					<ul class="toolbar">
						<li class="adduydiv" onclick="beforAddBranch()"><span><img
								src="${pageContext.request.contextPath}/resources/images/t01.png" /></span>添加</li>
						<li class="upclick" onclick="beforUpBranch()"><span><img
								src="${pageContext.request.contextPath}/resources/images/t02.png"
								/></span>修改</li>
					</ul>
				</div>
				<table class="tablelist">
					<thead>
						<tr>
							<th>操作</th>
							<th>公司</th>
							<th>上级公司</th>
							<th>分支机构</th>
							<th>联系人</th>
							<th>业务类型</th>
							<th>出单情况</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${branchlist}" var="branch">
							<tr>
							<td><input type="radio" name="bcgBranchIds" value="${branch.bcgBranchId}"></td>
							<td>${branch.bcgCompanyId}</td>
							<td>${branch.bcgInscompanyId}</td>
							<td>${branch.bcgBranchShort}</td>
							<td>${branch.bcgBranchMan}</td>
							<td>
							<c:if test="${branch.bcgBranchType==1}">综合业务</c:if>
							<c:if test="${branch.bcgBranchType==2}">产险</c:if>
							<c:if test="${branch.bcgBranchType==3}">车险</c:if>
							<c:if test="${branch.bcgBranchType==4}">寿险</c:if>
							</td>
							<td>
							<c:if test="${branch.bcgBranchSituation==1}">正常出单</c:if>
							<c:if test="${branch.bcgBranchSituation==2}">停止出单</c:if>
							</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>



		</div>
	</div>

	<script type="text/javascript">
		$("#usual1 ul").idTabs();
		$('.tablelist tbody tr:odd').addClass('odd');
	
		//进入添加保险公司
		function beforAddInstit()
		{
			window.location.href = "beforAddInstition.html";
		}
		//进图添加分支机构
		function beforAddBranch()
		{
			window.location.href = "beforAddBranch.html";	
		}
		//进入修改保险公司
		function beforUpInstit()
		{
			var val = $("input[name='icgInscompanyRido']:checked").val();
			if(typeof(val)=='undefined'){
            	alert("请选择公司再点击修改按钮");
                    }else
                    {
			window.location.href = "beforUpdateInstition.html?icgInscompanyId="+val;
                    }
		}
		//进入修改分支机构
		function beforUpBranch()
		{
			var val = $("input[name='bcgBranchIds']:checked").val();
			if(typeof(val)=='undefined'){
            	alert("请选择分支机构再点击修改按钮");
                    }else
                    {
			window.location.href = "beforUpBranch.html?bcgBranchId="+val;
                    }
		}
		
		function onlaod()
		{
			if(null!="${projectType}" && "${projectType}"!="")
			{
				if("${projectType}"=='branch')
				{
					$("#insurtab").removeClass("selected");
					$("#branchtab").addClass("selected");
					$("#tab1").hide();
					$("#tab2").show();
					
				}else if("${projectType}"=='insuran')
				{
					$("#insurtab").addClass("selected");
					$("#branchtab").removeClass("selected");
					$("#tab2").hide();
					$("#tab1").show();
				}
			}
		}	
		</script>
</body>
</html>