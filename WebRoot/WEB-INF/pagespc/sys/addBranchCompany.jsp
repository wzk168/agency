<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加保险公司分支机构</title>
</head>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/uicss/jquery.ui.core.css"> 
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/form.validation.js"></script>
<script type="text/javascript">
	//添加分支机构js
	function addBranchCompany() {
		var bValid = true;
		bValid = bValid && checkselect( "bcgInscompanyIdId", "上级公司","bcgInscompanyIdspan");
		bValid = bValid && checkLength( "bcgBranchNameId", "保险公司", 3, 40,"bcgBranchNamespan");
		bValid = bValid && checkLength( "bcgBranchShortId", "简称", 3, 25,"bcgBranchShortspan");
		bValid = bValid && checkLength( "bcgBranchManId", "联系人", 3, 30,"bcgBranchManspan");
		bValid = bValid && checkselect( "bcgBranchSituationId", "出单情况","bcgBranchSituationspan");
		bValid = bValid && checkselect( "bcgBranchTypeId", "业务类型","bcgBranchTypespan");
		bValid = bValid && checknull( "bcgBranchPhoneId", "电话",0,25,"bcgBranchPhonespan");
		bValid = bValid && checknull( "bcgBranchFaxId", "传真",0,30,"bcgBranchFaxspan");
		bValid = bValid && checknull( "bcgBranchEmailId", "邮箱",0,50,"bcgBranchEmailspan");
		bValid = bValid && checknull( "bcgBranchAdressId", "地址",0,50,"bcgBranchAdressspan");
		bValid = bValid && checknull( "bcgBranchRemarkId", "备注",0,200,"bcgBranchRemarkspan");
		
		if(bValid)
		{
			$.ajax({
				type : "post",
				url : "addBrabchCompany.html",
				data : $("#addbranchfrom").serialize(),
				dataType : "text",
				success : function(data) {
					if (data > 0) {
						beforInstit("branch");
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(errorThrown);
				}
			});
		}
	}
	//重新加载分支机构信息列表js
	function beforInstit(project) {
		window.location.href = "beforInstit.html?projectType="+project;
	}
	</script>

	<style>
		label, input { display: inline; }
		input.text { margin-bottom:12px; padding: .4em; }
		 select { margin-bottom:12px; padding: .4em; }
	</style>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">合作机构</a></li>
			<li><a href="#">添加分支机构信息</a></li>
		</ul>
	</div>


	<div class="formtitle">
		<span>保险公司分支机构基本信息</span>
	</div>
	<form id="addbranchfrom">

		<table width="86%" class="u-table" align="center">
			<tbody>
				<tr>
					<th align="right">上级公司</th>
					<td colspan="3">
					<select name="bcgInscompanyId" 
						id="bcgInscompanyIdId" class="dfinput">
							<option value="">--请选择上级公司--</option>
							<c:forEach items="${insuranceList}" var="insuran">
							<option value="${insuran.insuranceId}">${insuran.insuranceName}</option>
							</c:forEach>
					</select><i class="bcgInscompanyIdspan"></i></td>
				</tr>
				<tr>
					<th align="right">公司全称</th>
					<td colspan="3"><input type="text" name="bcgBranchName"
						id="bcgBranchNameId"  class="dfinput" size="60"
						/><i class="bcgBranchNamespan"></i></td>
				</tr>
				<tr>
					<th align="right" width="10%">公司简称</th>
					<td width="30%"><input type="text" name="bcgBranchShort"
						id="bcgBranchShortId" 
						class="dfinput" size="30"/><i class="bcgBranchShortspan"></i></td>
					<th align="right" width="10%">联系人</th>
					<td width="31%"><input type="text" name="bcgBranchMan"
						id="bcgBranchManId" class="dfinput" size="30"
						 /><i class="bcgBranchManspan"></i></td>
				</tr>
				<tr>
					<th>出单情况</th>
					<td><select name="bcgBranchSituation"  
						id="bcgBranchSituationId" class="dfinput">
							<option value="0">--请选择出单情况--</option>
							<option value="1">正常出单</option>
							<option value="2">停止出单</option>
					</select><i class="bcgBranchSituationspan"></i></td>
					<th>业务类型</th>
					<td><select id="bcgBranchTypeId" name="bcgBranchType" class="dfinput">
							<option value="0">--请选择类型--</option>
							<option value="1">综合业务</option>
							<option value="2">产险</option>
							<option value="3">车险</option>
							<option value="4">寿险</option>
					</select><i class="bcgBranchTypespan"></i></td>
				</tr>
				<tr>
					<th>公司电话</th>
					<td><input type="text" name="bcgBranchPhone"
						id="bcgBranchPhoneId"  class="dfinput" size="30" />
						<i class="bcgBranchPhonespan"></i>
						</td>
					<th>传真</th>
					<td><input type="text" name="bcgBranchFax"
						id="bcgBranchFaxId" class="dfinput" size="30" />
						<i class="bcgBranchFaxspan"></i>
						</td>
				</tr>
				<tr>
					<th>邮箱</th>
					<td colspan="3"><input type="text" name="bcgBranchEmail"
						id="bcgBranchEmailId" class="dfinput" size="60"
						 />
						 <i class="bcgBranchEmailspan"></i></td>
				</tr>
				<tr>
					<th>地址</th>
					<td colspan="3"><input type="text" name="bcgBranchAdress"
						id="bcgBranchAdressId" class="dfinput" size="60"
						/>
						<i class="bcgBranchAdressspan"></i></td>
				</tr>
				<tr>
					<th>备注信息</th>
					<td colspan="3"><input type="text" name="bcgBranchRemark"
						id="bcgBranchRemarkId" class="dfinput" size="60"
						/><i class="bcgBranchRemarkspan"></i></td>
				</tr>
				<tr align="center"><td colspan="4">
				<input type="button" value="提交保存" onclick="addBranchCompany()" class="ibtn">
				<input type="reset" value="重置信息" class="ibtn">
				</td></tr>
			</tbody>
		</table>
	
	</form>

</body>
</html>