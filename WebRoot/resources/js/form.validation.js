
function updateTips( t, varname) {
	var ts='.'+varname;
		tips = $( ts );
	tips.text( t )
		.addClass("ui-state-highlight" );
}
//判断啊必填项
function checkLength( o, n, min, max ,varname) {
	var s='#'+o;
	var o = $( s );
	if ( o.val().length > max || o.val().length < min ) {
		o.addClass( "ui-state-error" );
		updateTips(  n + "字符在 " +
			min + "到" + max + "之间" ,varname);
			o.blur(function () 
              { 
				if ( o.val().length > max || o.val().length < min )
				{
					o.addClass( "ui-state-error" );
					updateTips(  n + "字符在 " +
						min + "到" + max + "之间" ,varname);
					return false;
				}else
				{
					var tss='.'+varname;
					tipss = $( tss );
					o.removeClass("ui-state-error");
					tipss.text("").removeClass("ui-state-highlight");
					return true;
				}
           });
		return false;
	} else {
		return true;
	}
}

//判断下拉框默认为空或者为0的时候
function checkselect(o, n,varname)
{
	var s='#'+o;
	var o = $( s );
	if ( o.val()==0 || o.val()=="") {
		o.addClass( "ui-state-error" );
		updateTips(  n + "不能为空" ,varname);
			o.blur(function () 
              { 
				if ( o.val()==0 || o.val()=="")
				{
					o.addClass( "ui-state-error" );
					updateTips(  n + "不能为空" ,varname);
					return false;
				}else
				{
					var tss='.'+varname;
					tipss = $( tss );
					o.removeClass("ui-state-error");
					tipss.text("").removeClass("ui-state-highlight");
					return true;
				}
           });
		return false;
	} else {
		return true;
	}
}



//默认可以为空不为空时判断
function checknull( o, n, min, max ,varname) {
	var s='#'+o;
	var o = $( s );
	if(o.val()!=null && o.val().length >0)
	{
		if (o.val().length > max || o.val().length < min ) {
			o.addClass( "ui-state-error" );
			updateTips(  n + "字符在 " +
				min + "到" + max + "之间" ,varname);
				o.blur(function () 
	              { 
					if ( o.val().length > max || o.val().length < min )
					{
						o.addClass( "ui-state-error" );
						updateTips(  n + "字符在" +
							min + "到" + max + "之间" ,varname);
						return false;
					}else
					{
						var tss='.'+varname;
						tipss = $( tss );
						o.removeClass("ui-state-error");
						tipss.text("").removeClass("ui-state-highlight");
						return true;
					}
	           });
			return false;
		} else {
			return true;
		}
	}else
	{
		return true;
	}
	
}

