
function updateTips( t, varname) {
	var ts='.'+varname;
		tips = $( ts );
	tips.text( t )
		.addClass("ui-state-highlight" );
}

function checkLength( o, n, min, max ,varname) {
	var s='#'+o;
	var o = $( s );
	if ( o.val().length > max || o.val().length < min ) {
		o.addClass( "ui-state-error" );
		updateTips(  n + " 字符长度在 " +
			min + " 与 " + max + "之间" ,varname);
			o.blur(function () 
              { 
				if ( o.val().length > max || o.val().length < min )
				{
					o.addClass( "ui-state-error" );
					updateTips(  n + " 字符长度在 " +
						min + " 与 " + max + "之间" ,varname);
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


function checkselect(o, n,varname)
{
	var s='#'+o;
	var o = $( s );
	if ( o.val()==0 || o.val()=="") {
		o.addClass( "ui-state-error" );
		updateTips(  n + "不能为空请选择" ,varname);
			o.blur(function () 
              { 
				if ( o.val()==0 || o.val()=="")
				{
					o.addClass( "ui-state-error" );
					updateTips(  n + "不能为空请选择" ,varname);
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
