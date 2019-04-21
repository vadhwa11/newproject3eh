<html  xml:lang="IN_hi" xmlns="http://www.w3.org/1999/xhtml">
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * doctorEnquiry.jsp  
 * Purpose of the JSP -  This is for doctor Enquiry.
 * @author  Ritu  
 * Create Date: 12th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


<div class="titleBg">
<h2>Doctor Enquiry</h2>
</div>
<div class="clear"></div>
<form name="doctorEnquirySearch" method="post" action="">
<div class="Block">
<%
	
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>) request.getAttribute("map");
	}
	List<Object> doctorList = new ArrayList<Object>();
	List<MasDepartment> wardList = new ArrayList<MasDepartment>();
	
	if(map.get("doctorList") != null){
		doctorList = (List<Object>)map.get("doctorList");
	}
	if(map.get("wardList") != null){
		wardList = (List<MasDepartment>)map.get("wardList");
	}
	
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	
	%>
<label>Department</label> 
<select id="deptId"	name="<%=PATIENT_DEPARTMENT %>">
	<option value="0">Select</option>
	<%
				for(MasDepartment masDepartment : wardList){
				%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%		
			} %>
</select> 
<label>Doctor Name</label> 
<input type="text" name="<%=DOCTOR_NAME%>" id="<%=DOCTOR_NAME%>" onchange="checkNameLength(this.value,'Doctor Name')"	value="" MAXLENGTH="30" tabindex=1 />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="" value="Search" class="button"	onclick="if(checkEnquiryForm()){submitForm('doctorEnquirySearch','/hms/hms/enquiry?method=searchDoctorForEnquiry');}"	tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('village','generalMaster?method=deleteVillage&flag='+this.value)" accesskey="d" tabindex=1 />

<div class="clear"></div>
<div class="division"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<%
		if(doctorList.size() > 0){
	%>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="doctorEnuiry" method="post" action="" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script	type="text/javascript">
formFields = [
			[0, "<%= EMPLOYEE_ID%>", "id"], [1,"<%= EMPLOYEE_CODE%>"], [2,"<%= DOCTOR_NAME%>"], [3,"<%= DEPARTMENT_ID %>"], [4,"<%= SERVICE_NO%>"], [5,"<%= RANK_ID%>"],[6,"<%= CONTACT_NUMBER%>"],[7,"<%= TELL_NO_OFFICE%>"],[8,"<%= LAST_CHG_TIME%>"]];
	 statusTd = 8;
	</script>
</div>
<script type="text/javascript" language="javascript"><!--
	data_header = new Array();
	data_header[0] = new Array;
	data_header[0][0] = "Employee Code"
	data_header[0][1] = "data";
	data_header[0][2] = "2%";
	data_header[0][3] = "<%= EMPLOYEE_CODE%>"
	data_header[1] = new Array;
	data_header[1][0] = "Doctor Name"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "<%= DOCTOR_NAME %>";
	
	data_header[2] = new Array;
	data_header[2][0] = "Department"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "<%= DEPARTMENT_ID%>";
	
	data_header[3] = new Array;
	data_header[3][0] = "Service No."
	data_header[3][1] = "hide";
	data_header[3][2] = "20%";
	data_header[3][3] = "<%= SERVICE_NO%>"
	
	data_header[4] = new Array;
	data_header[4][0] = "Rank"
	data_header[4][1] = "hide";
	data_header[4][2] = "15%";
	data_header[4][3] = "<%= RANK_ID %>";
	
	data_header[5] = new Array;
	data_header[5][0] = "Contact Details"
	data_header[5][1] = "data";
	data_header[5][2] = "20%";
	data_header[5][3] = "<%= CONTACT_NUMBER%>"
	
	data_header[6] = new Array;
	data_header[6][0] = "Mobile No."
	data_header[6][1] = "data";
	data_header[6][2] = "15%";
	data_header[6][3] = "<%= TELL_NO_OFFICE %>";

	data_header[7] = new Array;
	data_header[7][0] = "Time "
	data_header[7][1] = "data";
	data_header[7][2] = "15%";
	data_header[7][3] = "<%= LAST_CHG_TIME %>";
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		for (Iterator iterator = doctorList.iterator(); iterator.hasNext();) {
			Object[] object = (Object[]) iterator.next();
			MasEmployee employee = (MasEmployee)object[0];
			MasDepartment masDepartment = (MasDepartment)object[1];
			if(employee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= employee.getId()%>
		<%
			if(employee.getEmployeeCode() != null){
		%>
			data_arr[<%= counter%>][1] = "<%=employee.getEmployeeCode()%>"
		<%}else{%>
		<%}%>
		<%
			if(employee.getFirstName() != null){
		%>
			data_arr[<%= counter%>][2] = "<%=employee.getFirstName()%> <%=employee.getLastName()%>"
			<%}else {%>
			<%}%>
		<%
			if(employee.getDepartment() != null){
		%>	
			data_arr[<%= counter%>][3] = "<%=masDepartment.getDepartmentName()%> "
		<%}else {%>
		<%}%>
		
		<%
		if(employee.getServiceNo() != null){
    	%>
			data_arr[<%= counter%>][4] = "<%=employee.getServiceNo()%>"
		<%}else{%>
		<%}%>
		
		<%
		if(employee.getRank() != null){
	   	%>
			data_arr[<%= counter%>][5] = ""
		<%}else {%>
		data_arr[<%= counter%>][5] = " "
		<%}%>
		<%
		if((employee.getResidentialAddress()!=null)){
	   	%>
			data_arr[<%= counter%>][6] = "<%=employee.getResidentialAddress()%>"
		<%}else {%>
		data_arr[<%= counter%>][6] = "-"
		<%}%>
		<%
		if((employee.getTelNoOffice()!=null)){
	   	%>
		    data_arr[<%= counter%>][7] = "<%=employee.getTelNoOffice()%>"
	   <%}else {%>
	   data_arr[<%= counter%>][7] = "-"
	   <%}%>

       <%
		if(employee.getLastChgTime() != null){
	   	%>
		    data_arr[<%= counter%>][8] = "<%=employee.getLastChgTime()%>"
	  <%}else {%>
	  data_arr[<%= counter%>][8] = "-"
	  <%}%>		    
		<%	counter++;
	    	}
	    }
	%>
	
    formName = "doctorEnuiry"
	nonEditable = ['<%=EMPLOYEE_ID%>'];
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	}
	
	makeTable(start,end);
	
	</script>
<%}else{%> 
<h4> No Records Found!!</h4>
<%}	%>
<div id="statusMessage"></div>
<div id="clear"></div>
</form>
</div>

<script type="text/javascript" language="javascript">
function checkNameLength(value,fieldName){

	if(value!=""){
		var len=value.length;
		if(parseInt(len)<3){
			alert("Please Enter min three charecter "+fieldName);
			return false;
		}
	}else{
		return false;
		}
}
function checkEnquiryForm()
{
	   var deptId = document.getElementById('deptId').value;
		var doctor = document.getElementById('<%=DOCTOR_NAME%>').value;
		if((deptId==null || deptId=='0')&& (doctor==null || doctor=='') )
		{
			alert('Please Enter at Least one Data for Search !!!');
			return false;
		}else
		{
			return true;
		}
}
</script>

</html>