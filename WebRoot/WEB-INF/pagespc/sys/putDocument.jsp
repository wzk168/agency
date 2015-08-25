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
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/putDocument.js"></script>
	
<title>员工信息管理</title>
</head>
<body >
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">平台</a></li>
			<li><a href="#">单证出库</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<li><label>&nbsp;&nbsp;分支机构:&nbsp;</label><select class="dfinput">
				<option value="">--请选择分支机构--</option>
				<c:forEach items="${bralist}" var="bran">
				<option value="${bran.branchId}">${bran.branchName}</option>
				</c:forEach>
				</select></li>
				<li>
				<label>&nbsp;&nbsp;单证类型:&nbsp;</label><select class="dfinput">
				<option value="0">--请选择单证类型--</option>
				<option value="1">--强制标志--</option>
				<option value="2">--交单--</option>
				<option value="3">--商单--</option>
				<option value="4">--发票--</option>
				</select>
				</li>
				<li><label>&nbsp;&nbsp;时间:&nbsp;</label>
				<input id="esEmplNameId" type="text" class="dfinput" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly"/>至
				<input id="esEmplNameId" type="text" class="dfinput" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly"/>
				</li>
					
				<li><span><img
						src="${pageContext.request.contextPath}/resources/images/ico06.png"
						class="seluy" onclick="selDocument()"/></span></li>
			</ul>

		</div>
		<div class="rightinfo">
			<table class="tablelist" id="tabId">
				<thead>
					<tr>
						<th width="5%">序号</th>
						<th>分支机构</th>
						<th>批号</th>
						<th>单证号</th>
						<th>入库时间</th>
						<th>单证类型</th>
						<th>单证状态</th>
						<th>操作</th>
						
					</tr>
				</thead>
				<tbody id="contextObj">
			    	
				</tbody>
			</table>
			
				<div class="pagin">
			<div class="message">
				共<i class="blue">${page.totalSize}</i>条记录，总页数${page.totalPage}页,
				当前显示第&nbsp;<i class="blue">${page.pageNow}&nbsp;</i>页
			</div>
			<ul class="paginList">
				<li class="paginItem"><c:choose>
						<c:when test="${page.hasPre}">
							<a href="javascript:;" onclick="turnPage('${page.pageNow-1}')"><span
								class="pagepreblue"></span></a>
						</c:when>
						<c:otherwise>
							<a href="javascript:;"><span class="pagepre"
								onclick="turnPage(1)"></span></a>
						</c:otherwise>
					</c:choose></li>
				<li class="paginItem"><a href="javascript:;"
					onclick="turnPage(1)">首页</a></li>
				<li class="paginItem"><a href="javascript:;"
					onclick="turnPage(${page.totalPage})">尾页</a></li>
				<li class="paginItem"><c:if test="${!page.hasNext}">
						<a href="javascript:;" onclick="turnPage('${page.pageNow}')"><span
							class="pagenxt"></span></a>
					</c:if> <c:if test="${page.hasNext}">
						<a href="javascript:;"><span class="pagenxtblue"
							onclick="turnPage('${page.pageNow+1}')"></span></a>
					</c:if></li>
			</ul>
		</div>
		</div>
	</div>
</body>
</html>