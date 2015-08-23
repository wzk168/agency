
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

//判断文本框只能输入数字字母
function checknum(o, n, min, max ,varname) 
{ 
	var s='#'+o;
	var o = $( s );
var re=/^[A-Za-z0-9]*$/; 

if(re.test(o.val())==false){ 
	//不全是数字或者字母的进入该模块
	o.addClass( "ui-state-error" );
	updateTips(  n +"只能输入数字或字母" ,varname);
	o.blur(function () 
              { 
		if(re.test(o.val())==false)
		{
			o.addClass( "ui-state-error" );
			updateTips(  n +"只能输入数字或字母" ,varname);
			return false;
		}else{
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
		}
           });
	
return false;
} else { 
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
return true;
} 
} 



//判断只能输入正整数
function checkOnlyNum(o, n ,varname)
{
	var s='#'+o;
   var o = $( s );
   var res=/^[0-9]*[1-9][0-9]*$/;
   if(res.test(o.val())==false )
   {
	   o.addClass( "ui-state-error" );
		updateTips(  n +"只能输入大于0的数字" ,varname);
		o.blur(function () 
	              { 
			  if(res.test(o.val())==false)
			  {
				   o.addClass( "ui-state-error" );
					updateTips(  n +"只能输入大于0的数字," ,varname); 
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
   }else
   {
     return true;
   }
}






//判断两数之差
function checkpoor(o,num, n ,varname)
{
	var s='#'+o;
	   var o = $( s );
 if(num>0 && num<100)
 {
	 return true;
 }else
 {
	  o.addClass( "ui-state-error" );
		updateTips(  n +"每次入库在100份以内" ,varname);
		o.blur(function () 
	              { 
			  if(num>0 && num<100)
			  {
				   o.addClass( "ui-state-error" );
					updateTips(  n +"每次入库在100份以内," ,varname); 
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
 }
}
