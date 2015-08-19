<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加保险公司</title>
</head>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/uicss/jquery.ui.core.css"> 
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/form.validation.js"></script>
<script type="text/javascript">
	//添加部门js
	function addInsurCompany() {
		
		var bValid = true;
		bValid = bValid && checkLength( "icgInscompanyNameId", "保险公司", 3, 40,"icgInscompanyNamespan");
		bValid = bValid && checkLength( "icgInscompanyShortId", "简称", 3, 25,"icgInscompanyShortspan");
		bValid = bValid && checkLength( "icgInscompanyManId", "联系人", 3, 30,"icgInscompanyManspan");
		bValid = bValid && checkselect( "icgInscompanySituationId", "出单情况","icgInscompanySituationspan");
		bValid = bValid && checkselect( "icgInscompanyTypeId", "业务类型","icgInscompanyTypespan");
		bValid = bValid && checknull( "icgInscompanyPhoneId", "电话",0,25,"icgInscompanyPhonespan");
		bValid = bValid && checknull( "icgInscompanyFaxId", "传真",0,30,"icgInscompanyFaxspan");
		bValid = bValid && checknull( "icgInscompanyBankId", "开户行",0,50,"icgInscompanyBankspan");
		bValid = bValid && checknull( "icgInscompanyAccountId", "账号",0,50,"icgInscompanyAccountspan");
		bValid = bValid && checknull( "icgInscompanyEmailId", "邮箱",0,50,"icgInscompanyEmailspan");
		bValid = bValid && checknull( "icgInscompanyWebsiteId", "网址",0,200,"icgInscompanyWebsitespan");
		bValid = bValid && checknull( "icgInscompanyAddressId", "地址",0,50,"icgInscompanyAddressspan");
		bValid = bValid && checknull( "icgInscompanyRemarkId", "地址",0,200,"icgInscompanyRemarkspan");
		
		if(bValid)
		{
			alert();
			$.ajax({
				type : "post",
				url : "addInstitionCompany.html",
				data : $("#inscompanyfrom").serialize(),
				dataType : "text",
				success : function(data) {
					if (data > 0) {
						beforInstit();
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(errorThrown);
				}
			});
		}
		
	}
	//重新加载部门信息列表js
	function beforInstit() {
		window.location.href = "beforInstit.html";
	}
	</script>

	<style>
		label, input { display:block; }
		input.text { margin-bottom:12px; padding: .4em; }
		 select { margin-bottom:12px; padding: .4em; }
	</style>

<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">合作机构</a></li>
			<li><a href="#">添加保险公司信息</a></li>
		</ul>
	</div>

  <div class="formbody">

	<div class="formtitle">
		<span>保险公司基本信息</span>
	</div>
	<form id="inscompanyfrom">
	<div align="center">
		<table width="86%" class="u-table">
			<tbody>
				<tr>
					<th align="right">公司全称</th>
					<td colspan="3"><input type="text" name="icgInscompanyName"
						id="icgInscompanyNameId"  class="dfinput" size="70"
						/><i class="icgInscompanyNamespan"></i></td>
				</tr>
				<tr>
					<th align="right">公司简称</th>
					<td><input type="text" name="icgInscompanyShort"
						id="icgInscompanyShortId" 
						class="dfinput" size="35"/><i class="icgInscompanyShortspan"></i></td>
					<th align="right">联系人</th>
					<td><input type="text" name="icgInscompanyMan"
						id="icgInscompanyManId" class="dfinput" size="35"
						 /><i class="icgInscompanyManspan"></i></td>
				</tr>
				<tr>
					<th>出单情况</th>
					<td><select name="icgInscompanySituation"  
						id="icgInscompanySituationId" class="dfinput">
							<option value="0">--请选择出单情况--</option>
							<option value="1">正常出单</option>
							<option value="2">停止出单</option>
					</select><i class="icgInscompanySituationspan"></i></td>
					<th align="right">业务类型</th>
					<td><select id="icgInscompanyTypeId" name="icgInscompanyType" class="dfinput">
							<option value="0">--请选择类型--</option>
							<option value="1">综合业务</option>
							<option value="2">产险</option>
							<option value="3">车险</option>
							<option value="4">寿险</option>
					</select><i class="icgInscompanyTypespan"></i></td>
				</tr>
				<tr>
					<th>公司电话</th>
					<td><input type="text" name="icgInscompanyPhone"
						id="icgInscompanyPhoneId"  class="dfinput" size="35" />
						<i class="icgInscompanyPhonespan"></i>
						</td>
					<th>传真</th>
					<td><input type="text" name="icgInscompanyFax"
						id="icgInscompanyFaxId" class="dfinput" size="35" />
						<i class="icgInscompanyFaxspan"></i>
						</td>
				</tr>
				<tr>
					<th>开户行</th>
					<td><input type="text" name="icgInscompanyBank"
						id="icgInscompanyBankId"
						class="dfinput" size="35" />
						<i class="icgInscompanyBankspan"></i>
						</td>
					<th>账号</th>
					<td><input type="text" name="icgInscompanyAccount"
						id="icgInscompanyAccountId" 
						class="dfinput" size="35" />
						<i class="icgInscompanyAccountspan"></i>
						</td>
				</tr>
				<tr>
					<th>邮箱</th>
					<td colspan="3"><input type="text" name="icgInscompanyEmail"
						id="icgInscompanyEmailId" class="dfinput" size="70"
						 />
						 <i class="icgInscompanyEmailspan"></i></td>
				</tr>
				<tr>
					<th>网址</th>
					<td colspan="3"><input type="text" name="icgInscompanyWebsite"
						id="icgInscompanyWebsiteId" class="dfinput" size="70"
						 />
						 <i class="icgInscompanyWebsitespan"></i>
						 </td>
				</tr>
				<tr>
					<th>地址</th>
					<td colspan="3"><input type="text" name="icgInscompanyAddress"
						id="icgInscompanyAddressId" class="dfinput" size="70"
						/>
						<i class="icgInscompanyAddressspan"></i></td>
				</tr>
				<tr>
					<th>备注信息</th>
					<td colspan="3"><input type="text" name="icgInscompanyRemark"
						id="icgInscompanyRemarkId" class="dfinput" size="70"
						/><i class="icgInscompanyRemarkspan"></i></td>
				</tr>
				<tr align="center"><td colspan="4">
				<input type="button" value="提交保存" onclick="addInsurCompany()" class="ibtn">
				<input type="reset" value="重置信息" class="ibtn">
				</td></tr>
			</tbody>
		</table>
		</div>
	</form>
	</div>
</body>
</html>