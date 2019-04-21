<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * referralDoctor.jsp  
 * Purpose of the JSP -  This is for Referral Doctor.
 * @author Ujjwal

 * Create Date: 16th Feb,2013 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	employeeList = (ArrayList)map.get("employeeList");
	
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %>
<div class="titleBg">
<h2>Referral Patient Slip</h2>
</div>
<form name="referral" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="Block">
<label>Reg. No.</label>
<input type="text" name="<%=HIN_NO %>" id="hinId" value=""  />
<input type="button" class="button" value="search" onClick="submitForm('referral','/hms/hms/opd?method=searchPatient');" /> 

</div>
</form>