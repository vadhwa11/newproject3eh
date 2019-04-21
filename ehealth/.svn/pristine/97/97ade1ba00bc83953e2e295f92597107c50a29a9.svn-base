<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script lang="javascript" src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script lang="javascript" src="/hms/jsp/js/csrfToken.js" type="text/javascript"></script>
	
	
<html>
<head>

<%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet">
</script>

<script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<%
String opt="";
String message="";
String mobileNumber="";
 Map<String, Object> map = new HashMap<String, Object>();
       
       if(request.getAttribute("map") != null)
       {
               map=(Map<String, Object>)request.getAttribute("map");
       }
        if(map.get("opt") != null)
       {
               opt=(String)map.get("opt");
       }
        if(map.get("message") != null)
       {
               message=(String)map.get("message");
       }
        if(map.get("mobileNumber") != null)
        {
        	mobileNumber=(String)map.get("mobileNumber");
        }
        boolean status=false;
        if(map.get("status") != null)
        {
        	status=(Boolean)map.get("status");
        	System.out.println("status "+status);
        }
        %>
<body>
<div class="Block">
<%
if(!message.equals("")){%>
<h4><%=message %></h4>
<script type="text/javascript">
testMa();
</script>
<%
}
%>
<lable>Enter otp</lable>
<form name="mobileVerification" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<input type="text" name="otp" value="" id="otpId" maxlength="10"/>
<input type="hidden" name="mobileNumber" value="<%=mobileNumber %>" id="mobileNumberId" maxlength="10"/>

<input type="button" class="button" value="Validate" onClick="if(checkField()){verifyOnRegistrationOtp()}"/>

</form>
</div>
</body>
</html>
<script>
	function verify(){
		// submitProtoAjaxWithDivName('registration','/hms/hms/registration?method=getNameAndMobile&mobNo='+mobNo+'&name='+name,'patientDtDiv');

		submitForm('mobileVerification','/hms/hms/registration?method=verifyMobileNum&mobileNumber='+<%=mobileNumber%>) 
		opener.openOtpWindos();
		window.close();
	}
	
	function checkField(){
		var otp=document.getElementById('otpId').value;
		
		if (otp != '') {
			//alert("Field is empty");
			return true;
	        
	    }
		else{
			alert("Please Enter OTP");
			return false;
		}
	}
</script>