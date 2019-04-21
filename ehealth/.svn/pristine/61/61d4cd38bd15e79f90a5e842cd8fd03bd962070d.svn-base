<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientDischargeSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@page import="jkt.hms.masters.business.MmRequestConfig"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasPriorityCodes"%>
<%@page import="jkt.hms.masters.business.MmServiceRequest"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String currentTime = (String)utilMap.get("currentTime");
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		
</script>
<script>
function designation(lebel,id){
	var l=parseInt(lebel);
	if(l==1){
		document.getElementById(id).innerHTML="First Label";
	}
	if(l==2){
		document.getElementById(id).innerHTML="Second Label";
	}
	if(l==3){
		document.getElementById(id).innerHTML="Third Label";
	}
} 	

	function checkData(){
		var employee=document.getElementsByName("EmployeeId");
		var userId=document.getElementById("Resource").value;
		flag=false;
		if(userId!="" && employee.length>0){
		for(var i=0;i<employee.length;i++){
			if(document.getElementsByName("EmployeeId")[i].value==userId){
				flag=true
			}
		}
		}
		if(flag){
			alert("Employee Already Assigned!");
			return false;
		}else{
			return false;
		}
	}
</script>
<% 
	Map<String, Object> map=new HashMap<String, Object>();
	List<MasInstituteDepartment> masInstituteDepartments=new ArrayList<MasInstituteDepartment>();
	List<MmRequestConfig> mmRequestConfigs=new ArrayList<MmRequestConfig>();
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("masInstituteDepartments")!=null){
		masInstituteDepartments=(List<MasInstituteDepartment>)map.get("masInstituteDepartments");
	}
	if(map.get("mmRequestConfigs")!=null){
		mmRequestConfigs=(List<MmRequestConfig>)map.get("mmRequestConfigs");
	}
	
	if(map.get("msg")!=null){
		out.println(map.get("msg"));
	}
%>

<div class="titleBg">
<h2>Request Tracker Configuration</h2>
</div>
<div class="clear"></div>
<div class="Block">
<h4>Configuration List</h4>
<div class="clear"></div>
 	<table>
 	<%if(mmRequestConfigs.size()>0){ %>
 		<tr><th>S.No.</th><th>Designation Label</th><th>Department</th><th>User</th><th>Day Duration</th></tr>
 		<%int count=1;
 			for(MmRequestConfig mmRequestConfig:mmRequestConfigs){
 			%>
 			<tr onclick="modifyFunction('<%=mmRequestConfig.getId()%>','<%=mmRequestConfig.getDepartment().getId()%>','<%=mmRequestConfig.getEmployee().getId()%>','<%=mmRequestConfig.getDesignationLevel()%>','<%=mmRequestConfig.getFromDay()%>','<%=mmRequestConfig.getToDay()%>')"><td><%=count %></td>
 			<td>
 			<input type="hidden" name="RequetConfig" value="<%=mmRequestConfig.getId()%>" />
 			<input type="hidden" name="EmployeeId" value="<%=mmRequestConfig.getEmployee().getId()%>" />
 			<input type="hidden" name="RankId" value="<%=mmRequestConfig.getEmployee().getRank().getDesignationOrder()%>" />
 			<div id="desiLabel<%=count%>"></div><script>designation(<%=mmRequestConfig.getDesignationLevel()%>,'desiLabel<%=count%>')</script></td>
 			<td><%=mmRequestConfig.getDepartment().getDepartmentName() %></td><td><%=mmRequestConfig.getEmployee().getEmployeeName() %></td><td><%=mmRequestConfig.getFromDay()+" To "+mmRequestConfig.getToDay() %></td></tr>
 			<%++count;}}else{ %>
 				No Records Available.
 			<%} %>
 	</table>
	</div>
<form name="mRequestTrackerConfiguration" action="" method="post">
<div class="Block">
	<h4>Configuration</h4>
	<div class="clear"></div>
	<label>Department</label>
	<select name="department" id="department" onchange="if(this.value!=''){submitProtoAjaxWithDivNameToShowStatus('mRequestTrackerConfiguration','/hms/hms/maintenance?method=getResourceListForConfig','mResource');}else{var x = document.getElementById('Resource');for(i=1;i<x.options.length;){x.options[i] = null;}}" validate="Department,string,yes">
		<option value="">Select</option>
		<%if(masInstituteDepartments.size()>0){ 
			for(MasInstituteDepartment masInstituteDepartment:masInstituteDepartments){
		%>
		<option value="<%=masInstituteDepartment.getDepartment().getId()%>"><%=masInstituteDepartment.getDepartment().getDepartmentName()%></option>
		<%}} %>
	</select>
	<label>User</label>
	<div id="mResource">
	<select name="Resource" id="Resource" validate="Employee,string,yes">
		<option value="">Select</option>
	</select>
	</div>
	<label>Designation Label</label>
	<select name="designationLabel" id="designationLabel" validate="Designation Label,string,yes">
		<option value="">Select</option>
		<option value="1">First Label</option>
		<option value="2">Second Label</option>
		<option value="3">Third Label</option>
	</select>
	<div class="clear"></div>
	<label>From Day</label>
	<input name="FromDay" id="FromDay" maxlength="3" validate="FromDay,string,yes" value="" />
	<label>To Day</label>
	<input name="ToDay" id="ToDay" maxlength="3" validate="ToDay,string,yes" value="" />

<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="Add" id="addbutton"	onclick="if(checkData()){submitForm('mRequestTrackerConfiguration','maintenance?method=addConfig')}"	value="Add" class="button" accesskey="a" />
<input type="button" name="Update" style="display: none" id="updateButton"	onclick="submitForm('mRequestTrackerConfiguration','maintenance?method=addConfig')"	value="Update" class="button" accesskey="a" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
	<input type="hidden" name="configId" id="configId" value="" /> 
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script>
	function modifyFunction(id,department,employee,designation,fromDay,toDay){
		if(document.getElementById("updateButton").style.display==""){
			document.getElementById("updateButton").style.display="none";
			document.getElementById("addbutton").style.display="";
			document.getElementById("configId").value="";
			document.getElementById("department").value="";
			document.getElementById("Resource").value="";
			document.getElementById("designationLabel").value="";
			document.getElementById("FromDay").value="";
			document.getElementById("ToDay").value="";
		}else{
			document.getElementById("updateButton").style.display="";
			document.getElementById("addbutton").style.display="none";
			document.getElementById("configId").value=id;
			document.getElementById("department").value=department;
			submitProtoAjaxWithDivNameToShowStatus('mRequestTrackerConfiguration','/hms/hms/maintenance?method=getResourceList','mResource');			document.getElementById("designationLabel").value=designation;
			document.getElementById("FromDay").value=fromDay;
			document.getElementById("ToDay").value=toDay;
			document.getElementById("Resource").value=employee;
		}
	}
	
</script>