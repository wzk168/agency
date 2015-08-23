<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加员工信息</title>
</head>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/uicss/jquery.ui.core.css"> 
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/form.validation.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/ajaxinfo.js"></script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/My97DatePicker/WdatePicker.js"></script>
	
<script type="text/javascript">
	//添加分支机构js
	function addEmp() {
		var bValid = true;
		bValid = bValid && checkLength( "esEmplNameId", "员工姓名", 3, 25,"esEmplNamespan");
		bValid = bValid && checkLength( "esEmplCardId", "身份证号码", 3, 20,"esEmplCardspan");
		bValid = bValid && checkselect( "esDeptIdId", "归属部门","esDeptIdspan");
		bValid = bValid && checkselect( "esTeamIdId", "归属团队","esTeamIdspan");
		bValid = bValid && checkLength( "esEmplBirthdateId","出生日期", 1, 20,"esEmplBirthdatespan");
		bValid = bValid && checkLength( "esEmplHireEateId","入职时间", 1, 20,"esEmplHireEatespan");
		bValid = bValid && checkLength( "esEmplPhoneId","电话", 1, 20,"esEmplPhonespan");
		bValid = bValid && checknull( "esEmplDimissionDateId", "离职时间",1,20,"esEmplDimissionDatespan");
		bValid = bValid && checknull( "esEmplEmergencyId", "紧急联系人",1,25,"esEmplEmergencyspan");
		bValid = bValid && checknull( "esEmplEmergencyPhoneId", "紧急电话",1,25,"esEmplEmergencyPhonespan");
		bValid = bValid && checknull( "esEmplProfessionNameId", "职业证",1,25,"esEmplProfessionNamespan");
		bValid = bValid && checknull( "esEmplProfessionCardId", "职业证号",1,30,"esEmplProfessionCardspan");
		bValid = bValid && checknull( "esPlacedoMicileId", "户籍地址",1,100,"esPlacedoMicilespan");
		bValid = bValid && checknull( "esActualResidenceId", "现住地",1,100,"esActualResidencespan");
		bValid = bValid && checknull( "esEmplRemarkId", "备注信息",1,200,"esEmplRemarkspan");
		
		
		if(bValid)
		{
			$.ajax({
				type : "post",
				url : "addEmployee.html",
				data : $("#addempfrom").serialize(),
				dataType : "text",
				success : function(data) {
					if (data > 0) {
						beforemp();
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(errorThrown);
				}
			});
		}
	}
	//重新加载员工信息列表js
	function beforemp() {
		window.location.href = "beforLoadEmployeeList.html";
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
			<li><a href="#">员工管理</a></li>
			<li><a href="#">添加员工信息</a></li>
		</ul>
	</div>


	<div class="formtitle">
		<span>员工基本信息</span>
	</div>
	<form id="addempfrom" method="post">

		<table width="86%" class="u-table" align="center">
			<tbody>
				<tr>
					<th align="right">员工姓名</th>
					<td><input type="text" name="esEmplName"
						id="esEmplNameId"  class="dfinput" size="30"
						/>
					<i class="esEmplNamespan"></i></td>
					<th align="right">身份证号码</th>
					<td><input type="text" name="esEmplCard"
						id="esEmplCardId"  class="dfinput" size="30"
						/>
					<i class="esEmplCardspan"></i></td>
				</tr>
				<tr>
					<th align="right">归属部门</th>
					<td>
						<select name="esDeptId" id="esDeptIdId" class="dfinput" onchange="findTeamList('esTeamIdId',this)">
						<option value="">--请选择部门--</option>
						<c:forEach items="${deptlist}" var="dept">
						<option value="${dept.deptId}">${dept.deptName}</option>
						</c:forEach>
						</select>
						
						<i class="esDeptIdspan"></i></td>
					<th align="right">归属团队</th>
					<td>
						<select name="esTeamId"
						id="esTeamIdId"  class="dfinput">
						<option value="">--请选择团队--</option>
						</select>
						<i class="esTeamIdspan"></i></td>
				</tr>
				<tr>
					<th align="right" width="10%">性别</th>
					<td width="30%">
						<select name="esEmplSex" id="esEmplSexId" class="dfinput">
						<option value="1">男</option>
						<option value="2">女</option>
						</select>
						<i class="esEmplSexspan"></i></td>
					<th align="right" width="10%">出生日期</th>
					<td width="31%"><input type="text" name="esEmplBirthdate"
						id="esEmplBirthdateId" class="dfinput" size="30" 
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly"/>
						 <i class="esEmplBirthdatespan"></i></td>
				</tr>
				<tr>
					<th>婚否</th>
					<td><select name="esEmplMarry"  
						id="esEmplMarryId" class="dfinput">
							<option value="1">已婚</option>
							<option value="2">未婚</option>
					</select><i class="esEmplMarryspan"></i></td>
					<th>学历</th>
					<td><select id="esEmplEducationId" name="esEmplEducation" class="dfinput">
							<option value="1">高中/中专</option>
							<option value="2">大专</option>
							<option value="3">大学及以上</option>
							<option value="4">其他</option>
					</select><i class="esEmplEducationspan"></i></td>
				</tr>
				<tr>
					<th>入职时间</th>
					<td><input type="text" name="esEmplHireEate"
						id="esEmplHireEateId"  class="dfinput" size="30" 
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly"/>
						<i class="esEmplHireEatespan"></i>
						</td>
					<th>职位</th>
					<td>
						<select name="esEmplPosition" id="esEmplPositionId" class="dfinput" >
						<option value="1">内勤</option>
						<option value="2">内勤主管</option>
						<option value="3">业管</option>
						<option value="4">财务</option>
						<option value="5">出纳</option>
						<option value="6">部门经理</option>
						<option value="7">总监</option>
						<option value="8">总经理</option>
						</select>
						<i class="esEmplPositionspan"></i>
						</td>
				</tr>
				<tr>
					<th>电话</th>
					<td><input type="text" name="esEmplPhone"
						id="esEmplPhoneId" class="dfinput" size="30"
						 />
						 <i class="esEmplPhonespan"></i></td>
						 <th>是否在职</th>
					<td>
					 <select name="esEmplJob" id="esEmplJobId" class="dfinput">
						 <option value="1">在职</option>
						  <option value="2">离职</option>
						 </select>
						 <i class="esEmplJobspan"></i></td>
				</tr>
				<tr>
					<th>是否业务员</th>
					<td>
						<select  name="esEmplSalesman"id="esEmplSalesmanId" class="dfinput">
						  <option value="2">不是</option>
						  <option value="1">是</option>
						 </select>
						<i class="esEmplSalesmanspan"></i></td>
						<th>离职时间</th>
					<td><input type="text" name="esEmplDimissionDate"
						id="esEmplDimissionDateId" class="dfinput" size="30" 
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
						 <i class="esEmplDimissionDatespan"></i></td>
				</tr>
				<tr>
					<th>紧急联系人</th>
					<td><input type="text" name="esEmplEmergency"
						id="esEmplEmergencyId" class="dfinput" size="30"
						/>
						<i class="esEmplEmergencyspan"></i></td>
						<th>紧急电话</th>
					<td><input type="text" name="esEmplEmergencyPhone"
						id="esEmplEmergencyPhoneId" class="dfinput" size="30"
						 />
						 <i class="esEmplEmergencyPhonespan"></i></td>
				</tr>
					<tr>
					<th>职业证号姓名</th>
					<td><input type="text" name="esEmplProfessionName"
						id="esEmplProfessionNameId" class="dfinput" size="30"
						/>
						<i class="esEmplProfessionNamespan"></i></td>
						<th>职业证号码</th>
					<td><input type="text" name="esEmplProfessionCard"
						id="esEmplProfessionCardId" class="dfinput" size="30"
						 />
						 <i class="esEmplProfessionCardspan"></i></td>
				</tr>
				<tr>
					<th>户籍地址</th>
					<td colspan="3"><input type="text" name="esPlacedoMicile"
						id="esPlacedoMicileId" class="dfinput" size="60"
						/>
						<i class="esPlacedoMicilespan"></i></td>
				</tr>
						<tr>
					<th>现住地</th>
					<td colspan="3"><input type="text" name="esActualResidence" 
						id="esActualResidenceId" class="dfinput" size="60"
						/>
						<i class="esActualResidencespan"></i></td>
				</tr>
				<tr>
					<th>备注信息</th>
					<td colspan="3"><input type="text" name="esEmplRemark"
						id="esEmplRemarkId" class="dfinput" size="100"
						/><i class="esEmplRemarkspan"></i></td>
				</tr>
				<tr align="center"><td colspan="4">
				<input type="button" value="提交保存" onclick="addEmp()" class="ibtn">
				<input type="button" value="重置信息" class="ibtn" onclick="f()">
				</td></tr>
			</tbody>
		</table>
	
	</form>

</body>
</html>