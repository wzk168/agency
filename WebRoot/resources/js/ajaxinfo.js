
	function findTeamList(textName,deptId) {
	if(deptId.value.replace(/\ +/g,"")!=null && deptId.value.replace(/\ +/g,"")!=""){
				$.ajax({
					 type : "post",
					async : false,
					  url : "../team/teamListByDeptId.html",
					 data : "tsDeptId="+deptId.value+"&"+$("#addempfrom").serialize(),
					dataType : "json",
					success : function(data) {
						var teamNames = "<option value=''>--请选择团队--</option>";
						if (data.teamlist.length > 0) {
							for ( var i = 0; i < data.teamlist.length; i++) {
								teamNames = teamNames
										+ "<option value='"+data.teamlist[i].teamId+"'>"
										+data.teamlist[i].teamName
										+ "</option>";
							}
						}
						$("#"+textName).html(teamNames);
					},
					error : function() {
						alert("fail");
					}
				});
	}
	}
	

	//页面加载时根据部门ID查询有该部门下的团队在根据对象值默认具体团队
	function onloadTeamList(teamTextId,deptId,teamName) {
		if(deptId.replace(/\ +/g,"")!=null && deptId.replace(/\ +/g,"")!=""){
					$.ajax({
						 type : "post",
						async : false,
						  url : "../team/teamListByDeptId.html",
						 data : "tsDeptId="+deptId,
						dataType : "json",
						success : function(data) {
							var teamValue = "<option value=''>--请选择团队--</option>";
							if (data.teamlist.length > 0) {
								for ( var i = 0; i < data.teamlist.length; i++) {
									var sele=false;
								if(data.teamlist[i].teamId==teamName)
								{
									var sele=true;
								}
									teamValue = teamValue
											+ "<option value='"+data.teamlist[i].teamId+"' selected='"+sele+"'>"
											+data.teamlist[i].teamName
											+ "</option>";
								}
							}
							$('#'+teamTextId).html(teamValue);
						},
						error : function() {
							alert("fail");
						}
					});
		}else
		{
			alert("请选择部门信息在选择团队");
		}
		}
