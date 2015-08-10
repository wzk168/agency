<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录后台管理系统</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.1.7.2.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/cloud.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		JPlaceHolder.init();
		$("#ucsCompanyName").focus();
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
	});
	function loginToHttp() {
		if (checkInputMsg()) {
			document.getElementById("loginFrom").submit();
		}
	}
	document.onkeydown = keyDownSearch;
	function keyDownSearch(e) {
		// 兼容FF和IE和Opera    
		var theEvent = e || window.event;
		var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
		if (code == 13) {
			if (checkInputMsg()) {
				document.getElementById("loginFrom").submit();
			}
			return false;
		}
		return true;
	}
	function checkInputMsg() {
		var pwdtest = /^[0-9a-zA-Z]{6,16}$/;//验证密码
		var ucsCompanyName = $('#ucsCompanyName').val().replace(/[ ]/g, "");
		var uosUserinfoName = $('#uosUserinfoName').val().replace(/[ ]/g, "");
		var uosUserinfoPwd = $('#uosUserinfoPwd').val().replace(/[ ]/g, "");
		if (ucsCompanyName == "") {
			$('#ucsCompanyNameAlert').text('企业账号不能为空!');
			return false;
		} else if (uosUserinfoName == "") {
			$('#ucsCompanyNameAlert').text('');
			$('#uosUserinfoNameAlert').text('个人账号不能为空!');
			return false;
		} else if (!pwdtest.test(uosUserinfoPwd)) {
			$('#uosUserinfoNameAlert').text('');
			$('#uosUserinfoPwdAlert').text('密码6-16位!');
			return false;
		}
		$('#uosUserinfoPwdAlert').text('');
		return true;
	}

	var JPlaceHolder = {
		//检测
		_check : function() {
			return 'placeholder' in document.createElement('input');
		},
		//初始化
		init : function() {
			if (!this._check()) {
				this.fix();
			}
		},
		//修复
		fix : function() {
			jQuery(':input[placeholder]')
					.each(
							function(index, element) {
								var self = $(this), txt = self
										.attr('placeholder');
								self.wrap($('<div></div>').css({
									position : 'relative',
									zoom : '1',
									border : 'none',
									background : 'none',
									padding : 'none',
									margin : 'none'
								}));
								var pos = self.position(), h = self
										.outerHeight(true), paddingleft = self
										.css('padding-left');
								var holder = $('<span></span>').text(txt).css({
									position : 'absolute',
									left : pos.left,
									top : '17px',
									height : h,
									lienHeight : h,
									paddingLeft : paddingleft,
									color : '#aaa'
								}).appendTo(self.parent());
								self.focusin(function(e) {
									holder.hide();
								}).focusout(function(e) {
									if (!self.val()) {
										holder.show();
									}
								});
								holder.click(function(e) {
									holder.hide();
									self.focus();
								});
							});
		}
	};
</script>
</head>

<body
	style="background-color:#1c77ac; 
	background-image:url(${pageContext.request.contextPath}/resources/images/light.png); 
	background-repeat:no-repeat; background-position:center top; overflow:hidden;">


	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>


	<div class="logintop">
		<span>欢迎登录云保平台</span>
		<ul>
			<li><a href="#">回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>
	<div class="loginbody">
		<span class="systemlogo"></span>
		<div class="loginbox">
			<form id="loginFrom" method="post"
				action="${pageContext.request.contextPath}/user/login.html">
				<table>
					<tr>
						<td><input name="ucsCompanyName" id="ucsCompanyName"
							type="text" class="loginuser" placeholder="企业账号"
							onBlur="checkInputMsg()" value="${user.ucsCompanyName}" /></td>
						<td><span id="ucsCompanyNameAlert"
							style="color: red; margin-left: 5px;">${companyMsg}</span></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><input name="uosUserinfoName" id="uosUserinfoName"
							type="text" class="loginuser" placeholder="个人账号"
							onBlur="checkInputMsg()" value="${user.uosUserinfoName}" /></td>
						<td><span id="uosUserinfoNameAlert"
							style="color: red; margin-left: 5px;">${userNameMsg}</span></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><input name="uosUserinfoPwd" id="uosUserinfoPwd"
							type="password" class="loginpwd" placeholder="密码"
							onBlur="checkInputMsg()" value="${user.uosUserinfoPwd}" /></td>
						<td><span id="uosUserinfoPwdAlert"
							style="color: red; margin-left: 5px;">${pwMsg}</span></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><input name="" type="button" class="loginbtn" value="登录"
							id="loginNow" onclick="loginToHttp()" /></td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2">&nbsp;</td>
					</tr>
					<tr>
						<td><label> <input name="" type="checkbox" value=""
								checked="checked" style="vertical-align: middle; margin-top: 0;" />记住密码
						</label><label style="margin-left: 30px;"><a href="#">忘记密码？</a></label></td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

	<div class="loginbm">
		版权所有权 <a href="#">云保</a>
	</div>

</body>
</html>