<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * changePassword.jsp  
 * Purpose of the JSP -  This is for Country Details.
 * @author  
 * @author  
 * Create Date: 17th september,2008 
 * Revision Date:      
 * Revision By: 
 * @version   
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
 
<script>
function displayData(){
 if(document.getElementById("newPwd").value != document.getElementById("conPwd").value){
  alert("please check new password and confirm password are not same");
   return false;
 }
 return true;
}

	function resetpassword(){
	
	 if(document.getElementById("loginName").value == ""){
	   alert("Please select the Login name!!")
	   return false;
	 }
	  if(confirm("Are You sure, You want to Reset Password ?"))
					return true;
				else
					return false;
	}
</script>
<form name="changePassword" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<% 
  Map map = new HashMap();
  String message = "";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	ArrayList usersList = (ArrayList)map.get("usersList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		 message = (String)map.get("message");
		  }	
	int userType = 0; /* user type 4 for general user */
	if(session.getAttribute("users") != null){
		 Users user = (Users)session.getAttribute("users");
		 userType = user.getUserType()!=null?user.getUserType():4;
	}	
  %>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Change Password</h2>
</div>
<div class="Block">
<h4>Change Password</h4>
<div class="clear"></div>
<%//if(userName.equals("admin")){
	if(userType<3){
		 %> <label>Login Name</label> <input type="text" id="loginName"
	name="loginName" validate="loginName,string,yes"
	onblur="submitProtoAjaxWithDivName('changePassword','superAdmin?method=getEmpNameByLoginName','testdiv')"
	style="width: 100">
<div id="testdiv"><label>Employee Name</label> <label
	class="value" validate="EmpName,string,no">-</label> <%}%>
<div class="clear"></div>
<label>Old Password</label> <input type="password" value="" id="oldPwd" 
	name="oldPwd" validate="oldPwd,metachar,yes" autocomplete="off">
<label>New Password</label> <input type="password" value="" id="newPwd" autocomplete="off" 
name="newPwd" maxlength="25" validate="newPwd,metachar,yes"/>
<label>Confirm Password</label> <input type="password" value="" id="conPwd" autocomplete="off" 
name="conPwd"	maxlength="25" validate="conPwd,metachar,yes"/>
</div>
<div class="clear"></div>
<input type="button" name="change"
	onClick="if(displayData()){submitForm('changePassword','superAdmin?method=showChangePassword&action=update');}"
	value="Submit" class="button"> <%if(userName.equals("admin")){%>
<input type="button" name="change"
	onClick="if(resetpassword()){submitForm('changePassword','superAdmin?method=showChangePassword&action=reset');}"
	value="Password reset" class="buttonBig"> <%}%>
<div class="clear"></div>

</div>

</form>
