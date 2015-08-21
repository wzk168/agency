
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
										+data.teamlist[i].teanName
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
