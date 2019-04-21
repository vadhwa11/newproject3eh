<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * login.jsp  
 * Purpose of the JSP -  This is for login.
 * @author  Mansi
 * @author  Deepali
 * Create Date: 31st Jan,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.11
--%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ include file="headerClinirx.jsp"%>

<div class="clear"></div>


<div id="main">
<div class="omegaTitle"><img
	src="/hms/jsp/images/clinirx/omegaLogo.jpg" alt="omega" height="59"
	width="290" /></div>
<div class="clear"></div>
<form name="loginForm" method="post" action="">
<%
			Map map = new HashMap();
			if(request.getAttribute("map") != null){
				map = (Map) request.getAttribute("map");
			}
			
				%>
<div id="login">
<div class="clear"></div>
<label>Username : <span></span></label> <input id="loginName"
	type="text" name="<%=LOGIN_NAME%>" value="admin"
	validate='User Name,string,yes' maxlength="12" /> <script>
 document.loginForm.<%=LOGIN_NAME%>.focus();
 </script>

<div class="clear"></div>

<label>Password : </label> <input type="password" name="<%=PASSWORD%>"
	value="admin" validate='Password,string,yes'
	onblur="hospitalList('loginForm')" maxlength="12" />
<div class="clear"></div>
<div id="defaultList" style="display: block;"><label>Organisation
: </label> <select name="hospitalName" id="hospitalName">
	<option value="0">Select</option>
</select>
<div class="clear"></div>

<label>Department : </label> <select id="departmentName"
	name="departmentName">
	<option value="0">Select</option>
</select></div>
<div id="responseList" style="display: none;"></div>
<div class="clear"></div>
<input name="Login2" type="image"
	src="/hms/jsp/images/clinirx/submit.jpg" alt="Login" class="button"
	onClick="submitForm('loginForm','/hms/hms/login?method=validate','checkHospitalName');" />
<div class="clear"></div>
<span id="errorMsg"></span> <%
					    if(map.get("error") != null){
					        String message = (String)map.get("error");
					%> <label id="loginMsg" style="display: block;"><%=message%></label>
<%}%>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


<div class="clear"></div>

</div>
<div class="clear"></div>

<%@ include file="footerClinirx.jsp"%>