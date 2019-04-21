<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>

<script type="text/javascript">
function validateSpecialChar(val) {
	var result=filterNum(document.getElementById("fname").value);

	}
function filterSpecialChar(str) {
	//re = /\$|,|@|#|~|`|\%|\*|\^|\&|\(|\)|\+|\=|\[|\-|\_|\]|\[|\}|\{|\;|\:|\'|\"|\<|\>|\?|\||\\|\!|\$|\./g;
	re = /\$|@|#|~|`|\%|\*|\^|\&|\(|\)|\'|\!|\$/g;
	// remove special characters like "$" and "," etc...
	return str.replace(re, "");
	}
	function checkValidcharOnly(charvalue,fieldname)
	{
		var invalid = "~/<>`|^!'"
		//var charvalue = allTrim(charvalue) ;
		//var charvalue = allTrim(charvalue) ;
		for(i=0;i<invalid.length;i++)
		{
			for(j=0;j<invalid.length;j++)
			{
				if(charvalue.charAt(j) == invalid.charAt(i))
				{

					alert("Only valid characters are allowed in "+fieldname);
					alert("Please Remove "+ string );
					return(false);
				}
			}
		}
		for(i=0;i<charvalue.length;i++)
		{
			if(charvalue.charAt(i) == 66 || charvalue.charAt(i) == 39)
			{
				alert("Only valid characters are allowed in " +fieldname) ;
				return(false);
			}
		}
		return(true);
	}
function submitForm(){
        errorMsg="";

                if(document.getElementById("mobileNo").value==""){
                    errorMsg=errorMsg+"Please Enter Mobile No\n";
                  }else{
		           var objRegExp  = /^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$/
					if(!objRegExp.test(document.getElementById("mobileNo").value))
						errorMsg += errorMsg + "Please Enter valid phone number.\n";
                  }


                if(document.getElementById("message").value==""){
                    errorMsg=errorMsg+"Please fill message";
                  }else{
   		           //var objRegExp  =/[^a-z*(\.\-\&\d\s\:\@\#\$\^\*\(\)\{\}\[\]\;\"\,\<\>\?\/\_\\\+\=)]/i;

   					//if(!objRegExp.test(document.getElementById("message").value))
   						//errorMsg += errorMsg + "Please Check Message Format";
                	/*
                	var msg=document.getElementById("message").value;
                	if(checkValidcharOnly(msg,'Message')){
                		document.getElementById("message").value=msg;
                	}*/
                	var msg=filterSpecialChar(document.getElementById("message").value);
                  	document.getElementById("message").value=msg;
                     }





				if(errorMsg != ""){
					alert(errorMsg);
		       		return false;
		       	}else{
		       	obj = eval('document.OneToOne');
		        obj.action = 'sms?method=submitOneToOneService';
		        obj.submit();
		       	}

	}

</script>
<%

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");

   Map<String, Object> map = new HashMap<String, Object>();
   
   if(request.getAttribute("map") != null)
   {
           map=(Map<String, Object>)request.getAttribute("map");
   }
String message="";
if(map.get("messsageForDisplay")!=null){
	message=(String)map.get("messsageForDisplay");
}
%>
<form name="OneToOne"  method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="formLayoutIn">
<h4>One To One Messaging Service</h4>
<%if(!message.equals("")){ %>
 <label class="value"
	style="FONT-WEIGHT: bold; FONT-SIZE: 11px; COLOR: #F71818; width: 100%; text-align: center; float: right; font-family: Verdana, Arial, Helvetica, sans-serif;">
<%=message%> </label>
<%} %>
<div class="clear"></div>
<div class="clear"></div>
	<div class="Block">
	<label >Category:</label>
	<select name="smstoCategory" id="smstoCategoryId" validate="smstoCategory,string,no" onchange="showSMSCate(this.value);">
	<option value="">Select</option>
	<option value="P">Patient</option>
	<option value="E">Employee</option>
	<option value="V">Vendor</option>
	</select>
	<div class="clear"></div>
	<div id="patientDiv" style="display: none;">
	<label>UHID</label>
	<input type="text" name="uhid" value="" validate="uhid,metachar,no"/>
	</div>
	<div id="employeeDiv" style="display: none;">
		<label>Employee Name</label>
		<select name="empName" id="empId" validate="empName,string,no">
		<option value="0">Select </option>
		</select>
	</div>
	<div id="vendorDiv" style="display: none;">
	
	</div>
	
	<label >Mobile No. :</label>
	<input type="text" name="mobileNo" id="mobileNo" maxlength="13" validate="mobileNo,contact,no" />
	<div class="clear"></div>
	<label >Message :</label>
	<textarea name="message" id="message" class="large" cols="20" rows="2" tabindex="1" validate="message,string,no" onKeyDown="limitText(this,159);" onKeyUp="limitText(this,159);" onpaste="limitText(this,159);" ></textarea>
	<label class="comment" >Left :</label>
<input type="text" name="left" id="left" readonly="readonly" value="159" class="small"/>
</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<input type="button" name="time" class="button" value="Send" onclick="submitForm();"/>
</div>
</form>
<div class="clear"></div>
<script>
function showSMSCate(value){
	//alert("value"+value);
}
</script>
<script>
function limitText(limitField, limitNum) {
	if(limitNum-limitField.value.length !='-1')
	document.getElementById("left").value=limitNum-limitField.value.length
    if (limitField.value.length > limitNum) {
        limitField.value = limitField.value.substring(0, limitNum);
        
    } 
}
</script>