<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * registration.jsp
 * Purpose of the JSP -  This is for Birth .
 * @author  Dipali
 * Create Date: 23rd April,2008
 * Revision Date:
 * Revision By:
 * @version 1.36
--%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script>function changeList(){
         
			  if(document.sendSms.selectedChrage.checked)				 
				   {
			  		document.sendSms.<%=EMPLOYEE_ID%>.disabled = true;
			  }
			  else{
			   		document.sendSms.<%=EMPLOYEE_ID%>.disabled = false;
			  }
 }
</script>
<%
    Map<String, Object> map = new HashMap<String, Object>();
	String motherName=null;
	String motherNameas =null;
	String regNo="";
	if(request.getAttribute("map") != null){
		map=(Map<String, Object>)request.getAttribute("map");
	}

	List<Inpatient> inPatientDetailList = new ArrayList<Inpatient>();
	List<Patient> motherList = new ArrayList<Patient>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
   try{
		

		if(map.get("employeeList")!=null)
		{
			employeeList=(List)map.get("employeeList");
		}

		

	}catch(Exception e){
		e.printStackTrace();
	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String babyAddress="";
	String regDate="";
	  %>
	  
	  
	  
	  <div id="birthDiv">
	  <div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>

<label>Send All</label>
<input type="checkbox" name="selectedChrage" id="selectedChrage" value="y" onClick="changeList();"/> 
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	  <label><span>*</span> SMS To</label>
	  <select	id="employeeId" name=<%=EMPLOYEE_ID%> multiple="multiple" size="16" class="list"   tabindex="1" tabindex="1" onchange="chkMobileNo(this.value)">
		<option value="0">Select</option>

	<%
				         		if(employeeList != null){
				         			for (Iterator iter = employeeList.iterator(); iter.hasNext();) {
				         				MasEmployee masEmployee = (MasEmployee) iter.next();
				         %>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName() +" "+masEmployee.getLastName()%></option>
	<%
				        			}
				        		 }
				        %>
</select>
	  
	  </div>
