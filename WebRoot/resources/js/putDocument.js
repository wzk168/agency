function selDocument() {
	$("#contextObj tr").remove();// 先清空数据然后在添加

	$.ajax({
		type : "POST",
		async : false,
		url : "loadDocumentPage.html",
		data : "pageNow=1",
		dataType : "json",
		contentType : 'application/json',
		success : function(data) {
			alert(data);
			alert(data.page.pageNow);
			alert(data.doculist);
			loadList(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alert(XMLHttpRequest);
			alert(textStatus);
			alert(errorThrown);
		}
	});
}

// 加载处理
function loadList(data) {
	var str = "";
	for (var i = 0; i < data.doculist.length; i++) {
		str += "<tr>" + "<td>" + (i + 1) + "</td>" + "<td>"
				+ data.doculist[i].branchName + "</td>" + "<td>"
				+ data.doculist[i].dgDocumentBatchNumber + "</td>" + "<td>"
				+ data.doculist[i].dgDocumentSerial + "</td>" + "<td>"
				+ data.doculist[i].dgDocumentEnterTime + "</td>" + "<td>"
				+ data.doculist[i].dgDocumentType + "</td>" + "<td>"
				+ data.doculist[i].dgDocumentState + "</td>" + "<td>"
				+ +"</td>" + "</tr>"
	}

	$("tbody").append(str);
}
