<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>单证入库</title>
</head>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/uicss/jquery.ui.core.css"> 
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/form.validation.js"></script>
	<script type="text/javascript">
	
	
	//添加部门js
	function addDocument() {
		var bValid = true;
		bValid = bValid && checkselect("dgBranchIdId", "分支机构","dgBranchIdIdspan");
		bValid = bValid && checkselect("dgDocumentTypeId", "单证类型","dgDocumentTypespan");
		bValid = bValid && checknum("dgDocumentSerial1", "起始编号",5,20,"dgDocumentSerial11span");
		bValid = bValid && checkOnlyNum("dgDocumentSerial11", "起始编号2","dgDocumentSerial11span");
		bValid = bValid && checkOnlyNum("dgDocumentSerial22", "截止编号2","dgDocumentSerial22span");
		
		var difference=$("#dgDocumentSerial22").val()-$("#dgDocumentSerial11").val();
		bValid = bValid && checkpoor("dgDocumentSerial22",difference,"单证","dgDocumentSerial22span");
		
		
		bValid = bValid && checknull("bcgBranchRemarkId", "备注",0,200,"bcgBranchRemarkspan");
		if(bValid){
			$.ajax({
				type : "post",
				url : "addDocumentInfo.html",
				data : $("#adddocumfrom").serialize(),
				dataType : "text",
				success : function(data) {
					if (data > 0) {
						alert();
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alert(errorThrown);
				}
			});
			
		}
		
	}
	//重新加载部门信息列表js
	function relodept() {
		window.location.href = "loadDeptInfoList.html";
	}
	</script>
<body>
<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">单证管理</a></li>
			<li><a href="#">单证入库</a></li>
		</ul>
	</div>
	
	<div class="formbody">
    <div class="formtitle"><span>单证入库</span></div>
    <form id="adddocumfrom">
    <ul class="forminfo">
    <li>
    <label>分支机构</label><select class="dfinput" name="dgBranchId" id="dgBranchIdId" style="width: 200px;">
    <option value="">--请选择保险公司分支机构 --</option>
    <c:forEach items="${branchlist}" var="branch">
  <option value="${branch.branchId}">${branch.branchName}</option>
    </c:forEach>
    </select>
    <i class="dgBranchIdIdspan"></i>
    </li>
    <li>
    <label>单证类型</label><select class="dfinput" style="width: 200px;" name="dgDocumentType" id="dgDocumentTypeId">
    <option value="0">--请选择单证类型 --</option>
    <option value="1">--强制标志 --</option>
    <option value="2">--交强单证 --</option>
    <option value="3">--商业单证 --</option>
    <option value="4">--发票号 --</option>
    </select>
    <i class="dgDocumentTypespan"></i>
    </li>
    <li><label>起始编号</label><input name="serial" size="21" id="dgDocumentSerial1" type="text" class="dfinput" />
    <input size="10" type="text" name="seria2" id="dgDocumentSerial11" class="dfinput" />
    <i class="dgDocumentSerial11span"></i></li>
    <li><label>截止编号</label><input name="dgDocumentSerial2" readonly="readonly"  size="21" id="dgDocumentSerial2" type="text" class="dfinput" />
    <input  size="10" name="seria3" id="dgDocumentSerial22" type="text" class="dfinput" />
    <i class="dgDocumentSerial22span"></i></li>
   <li><label>备注</label>
   <textarea rows="5" cols="45" class="textinput" name="dgDocumentRemark" id="dgDocumentRemarkId"></textarea>
   <i class="dgDocumentRemarkspan"></i>
    </li>
    <li>
    <label>&nbsp;</label>
    <input name="" onclick="addDocument()" type="button" class="btn" value="确认保存"/>
    <input type="button" class="btn" value=" 返回 " onclick="history.back();">
    </li>
    </ul>
    </form>
    </div>
	
<script>
//两个文本框信息同步
var o_1 = document.getElementById("dgDocumentSerial1");
var o_2 = document.getElementById("dgDocumentSerial2");
o_1.onkeyup = function(){
        o_2.value = o_1.value
}
o_2.onkeyup = function(){
    o_1.value = o_2.value
}
</script>
</body>
</html>