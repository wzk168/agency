<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/uicss/jquery.ui.core.css">  
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/uicss/jquery-ui.css">
	<script src="${pageContext.request.contextPath}/resources/js/jqueryui/jquery.ui.core.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jqueryui/jquery.ui.widget.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jqueryui/jquery.ui.button.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jqueryui/jquery.ui.position.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jqueryui/jquery.ui.dialog.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/form.validation.js"></script>
	<style>
		body { font-size: 62.5%; }
		label, input { display:block; }
		input.text { margin-bottom:12px; width:95%; padding: .4em; }
		 select { margin-bottom:12px; width:95%; padding: .4em; }
		fieldset { padding:0; border:0; margin-top:25px; }
		h1 { font-size: 1.2em; margin: .6em 0; }
		.ui-dialog .ui-state-error { padding: .3em; }
		.validateTips,.validateTips1 { border: 1px solid transparent; padding: 0.3em; }
	</style>
	
<title>团队管理列表</title>

</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">团队</a></li>
			<li><a href="#">列表</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<li class="adduydiv" id="crea"><span><img
						src="${pageContext.request.contextPath}/resources/images/t01.png" /></span>添加</li>
				<li class="upclick" onclick="beforteam()"><span><img
						src="${pageContext.request.contextPath}/resources/images/t02.png" /></span>修改</li>
			</ul>
		</div>
		

			<table class="tablelist" width="98%">
				<thead>
					<tr>
						<th><input type="radio" value="" /></th>
						<th>公司</th>
						<th>归属部门</th>
						<th>团队名</th>
						<th>负责人</th>
						<th>团队类型</th>
						
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty teamlist}">
						<c:forEach items="${teamlist}" var="team">
							<tr>
								<td><input name="tsTeamIds" id="tsTeamIds" type="radio"
									value="${team.tsTeamId}" /></td>
								<td>${team.tsCompanyId}</td>
								<td>${team.tsDeptId}</td>
								<td>${team.tsTeamName }</td>
								<td>${team.tsTeamPrincipal}</td>
								<td>
							<c:if test="${team.tsTeamType==1 }">直接渠道</c:if>
							<c:if test="${team.tsTeamType==2 }">渠道业务</c:if>
							<c:if test="${team.tsTeamType==3 }">特殊渠道业务</c:if>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
	
	</div>
	
	
<div id="dialog-form" title="添加团队信息">
<p class="validateTips"></p>
	<form id="addteamfrom">
	<fieldset>
		<label >团队名称</label>
		<input type="text" name="tsTeamName" id="tsTeamName"  class="text ui-widget-content ui-corner-all" />
		<label >归属部门</label>
		<select name="tsDeptId" id="tsDeptId" class="text ui-widget-content ui-corner-all">
		<option value="">--请选择归属部门--</option>
		<c:forEach items="${deptlist}" var="dept">
		<option value="${dept.dsDeptId}">${dept.dsDeptAbbreviation}</option>
		</c:forEach>
		</select>
		<label >负责人</label>
		<input type="text" name="tsTeamPrincipal" id="tsTeamPrincipal" value="" class="text ui-widget-content ui-corner-all" />
		<label >团队类型</label>
		<select name="tsTeamType" id="tsTeamType" class="text ui-widget-content ui-corner-all">
		<option value="0">--请选择团队类型--</option>
		<option value="1">直接渠道</option>
		<option value="2">渠道业务</option>
		<option value="3">特殊渠道业务</option>
		</select>
	</fieldset>
	</form>
</div>

<div id="dialog-form1" title="修改团队信息">
<p class="validateTips1"></p>
	<form id="upteamfrom">
	<fieldset>
		<label >团队名称</label>
		<input type="text" name="tsTeamName" id="tsTeamNameId"  class="text ui-widget-content ui-corner-all" />
		<label >归属部门</label>
		<select name="tsDeptId" id="tsDeptIdId" class="text ui-widget-content ui-corner-all">
		<option value="">--请选择归属部门--</option>
		<c:forEach items="${deptlist}" var="dept">
		<option value="${dept.dsDeptId}">${dept.dsDeptAbbreviation}</option>
		</c:forEach>
		</select>
		<label >负责人</label>
		<input type="text" name="tsTeamPrincipal" id="tsTeamPrincipalId" value="" class="text ui-widget-content ui-corner-all" />
		<label >团队类型</label>
		<select name="tsTeamType" id="tsTeamTypeId" class="text ui-widget-content ui-corner-all">
		<option value="0">--请选择团队类型--</option>
		<option value="1">直接渠道</option>
		<option value="2">渠道业务</option>
		<option value="3">特殊渠道业务</option>
		</select>
		<input type="hidden" name="tsCompanyId" id="tsCompanyIdId">
		<input type="hidden" name="tsTeamId" id="tsTeamIdId">
	</fieldset>
	</form>
</div>

	<script type="text/javascript">
	
		$('.tablelist tbody tr:odd').addClass('odd');
		
		//重新加载部门信息列表js
		function reloteam() {
			window.location.href = "loadTeamList.html?teamType=0";
		}
		
		$(function() {
			//以下是添加团队层
			$( "#dialog-form" ).dialog({
				autoOpen: false,
				height: 410,
				width: 350,
				modal: true,
				buttons: {
					//保存添加
					"保存添加": function() {
						var bValid = true;
							bValid = bValid && checkLength( "tsTeamName", "团队名", 3, 16,"validateTips");
							bValid = bValid && checkselect( "tsDeptId", "部门名称","validateTips");
							bValid = bValid && checkLength( "tsTeamPrincipal", "负责人", 3, 16,"validateTips");
							bValid = bValid && checkselect( "tsTeamType", "团队类型","validateTips");
					    if(bValid)
					    {
					    	
					    	$.ajax({
								type : "post",
								url : "addTeamInfo.html",
								data : $("#addteamfrom").serialize(),
								dataType : "text",
								success : function(data) {
									if (data > 0) {
										//$( this ).dialog( "close" );
										
										reloteam();
									}
								},
								error : function(XMLHttpRequest, textStatus, errorThrown) {
									alert(errorThrown);
								}
							});
					    }
					},
					//关闭层添加
					关闭: function() {
						$( this ).dialog( "close" );
					}
				},
			});
                    //打开层添加
			$( "#crea" ).click(function() {
					$( "#dialog-form" ).dialog( "open" );
				});
		});
                    //**************************以下是修改团队层*****************************
                    
			$( "#dialog-form1" ).dialog({
				autoOpen: false,
				height: 410,
				width: 350,
				modal: true,
				buttons: {
					//保存修改
				"修改保存": function() {
						var bValid = true;
							bValid = bValid && checkLength( "tsTeamNameId", "团队名", 3, 16,"validateTips1");
							bValid = bValid && checkselect( "tsDeptIdId", "部门名称","validateTips1");
							bValid = bValid && checkLength( "tsTeamPrincipalId", "负责人", 3, 16,"validateTips1");
							bValid = bValid && checkselect( "tsTeamTypeId", "团队类型","validateTips1");
					    if(bValid)
					    {
					    	$.ajax({
								type : "post",
								url : "updTeamInfo.html",
								data : $("#upteamfrom").serialize(),
								dataType : "text",
								success : function(data) {
									if (data > 0) {
										//$( this ).dialog( "close" );
										reloteam();
									}
								},
								error : function(XMLHttpRequest, textStatus, errorThrown) {
									alert(errorThrown);
								}
							});
					    }
					},
					//关闭层修改
					关闭: function() {
						$( this ).dialog( "close" );
					}
				},
			});
                    //打开层修改
		function beforteam(){
				var val = $("input[name='tsTeamIds']:checked").val();
				if(typeof(val)=='undefined'){
	            	alert("请选择团队再点击修改按钮");
	                    }else
	                    {
	                    	$.ajax({
								type : "post",
								url : "loadTeamInfoEntity.html",
								data : "tsTeamId="+val,
								dataType : "json",
								success : function(data) {
									if (null!=data) {
									$("#tsDeptIdId").val(data.tsDeptId);
									$("#tsTeamNameId").val(data.tsTeamName);
									$("#tsTeamPrincipalId").val(data.tsTeamPrincipal);
									$("#tsTeamTypeId").val(data.tsTeamType);
									$("#tsCompanyIdId").val(data.tsCompanyId);
									$("#tsTeamIdId").val(data.tsTeamId);
									$( "#dialog-form1" ).dialog( "open" );
									}
								},
								error : function(XMLHttpRequest, textStatus, errorThrown) {
									alert(errorThrown);
								}
							});
	                    		
	                    }
					
				}
                    
	
	</script>
</body>
</html>