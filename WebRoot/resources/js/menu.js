$(function() {
	var clickWhich;
	$('.tablelist tbody tr:odd').addClass('odd');
	$(".click").click(function() {
		clickWhich = this.id;
		if (clickWhich == "updatemsg") {
			findTbody();
		} else {
			$("#titleName").text("添加菜单");
			$(".tip").fadeIn(200);
		}

	});

	$(".tiptop a").click(function() {
		$(".tip").fadeOut(200);
	});

	$(".sure").click(
			function() {
				if (clickWhich == "addmsg") {
					checkInputMsg();
					document.getElementById('addMenuForm').setAttribute(
							'action', 'addMenu.html');
				}
				if (clickWhich == "updatemsg") {
					checkInputMsg();
					document.getElementById('addMenuForm').setAttribute(
							'action', 'updateMenu.html');
				}
				$("#addMenuForm").submit();
				$(".tip").fadeOut(100);
			});

	$(".cancel").click(function() {
		$(".tip").fadeOut(100);
	});

	// 分页
	function turnPage(op) {
		window.location.href = "menuList.html?pageNow=" + op;
	}
	function checkInputMsg() {
		if ($("#msMenuname").val().replace(/[ ]/g, "") == "") {
			document.getElementById('msMenuname').focus();
			return;
		} else if ($("#msMenuImg").val().replace(/[ ]/g, "") == "") {
			document.getElementById('msMenuImg').focus();
			return;
		}

	}

	function findTbody() {
		var val = $("input[name='msMenuId']:checked").val();
		if (typeof (val) == 'undefined') {
			alert("请选择要修改的菜单");
		} else {
			loadMenu(val);
		}
	}
	function loadMenu(data) {
		$.ajax({
			type : "post",
			data : "menuId=" + data,
			url : "loadMenu.html",
			dataType : "json",
			success : function(msg) {
				$("#msMenuId").val(data);
				$("#msMenuname").val(msg.msMenuname);
				$("#msMenuImg").val(msg.msMenuImg);
				$("#titleName").text("修改菜单");
				$(".tip").fadeIn(200);
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(errorThrown);
			}
		});

	}
});