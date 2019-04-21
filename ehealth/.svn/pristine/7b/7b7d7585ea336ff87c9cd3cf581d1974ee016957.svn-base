<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * employeeDependent.jsp  
 * Purpose of the JSP -  This is for Dependent Employee.
 * @author  Dipali
 * @author  Mansi  
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.14
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>





<script>
	<%
System.out.println("22222222");
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
		
	%>
		serverdate = '<%=dateCal+"/"+month+"/"+year%>'
	</script>


<script type="text/javascript">
function checkDOB(){

	
	
	
	var vDate = new Date() ;
	var dobDate = document.getElementById('dobId').value ;
	var d = new Date(dobDate.substring(6),(dobDate.substring(3,5) - 1) ,dobDate.substring(0,2));
	if(dobDate != ""){

		if(vDate < d)
		{
			alert("Please enter valid date of birth.");
			document.getElementById('dobId').value = "";
			return false;
		}
		else
		{
			var curr_date = d.getDate();
      
      	var curr_month = d.getMonth();
      
      	var curr_year = d.getFullYear();
		
		var mth;
      	var dt;
     	if(d.getDate() < 10){
       			
       			dt = "0"+curr_date;
       		}
       		else
       		{
       			dt = curr_date;
       		}
       		
       		if(d.getMonth()+1 < 10){
       			mth = "0"+curr_month
       		}
       		else
       		{
       			mth = curr_month
       		}
      
      		var myDate = (dt + "/" + mth + "/" + curr_year);

	 		document.getElementById('dobId').value=myDate;		
	  				
			return true;
		}
	}
	return true;
}	

</script>
<%System.out.println("searchEmployeeDependentList>>()");
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
	employeeCodeList = (ArrayList) map.get("employeeCodeList");
	List<MasRelation> relationCodeList = new ArrayList<MasRelation>();
	relationCodeList = (ArrayList) map.get("relationCodeList");

	ArrayList searchEmployeeDependentList = (ArrayList) map.get("searchEmployeeDependentList");

	ArrayList gridEmployeeList = (ArrayList) map.get("gridEmployeeList");
	ArrayList gridRelationList = (ArrayList) map.get("gridRelationList");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("message") != null) {
		String message = (String) map.get("message");
		out.println(message);
	}
	System.out.println("searchEmployeeDepeffffffffffffffffffndentList>>");
%>
<div class="titleBg">
<h2>Employee Dependent Master</h2>
</div>
<div id="searcharea">

<div id="searchbar">
<form name="search" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <font
	class="bodytextB_blue">Dependent Code:</font> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" /> <font class="bodytextB_blue">Dependent
Name:</font> <input type="text" id="searchField" name="<%= SEARCH_FIELD%>"
	value="" validate="Employee Dependent Code,string,no" MAXLENGTH="8"
	tabindex=1
	onkeypress="return submitenter(this,event,'personnel?method=searchEmployeeDependent')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','personnel?method=searchEmployeeDependent','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="button"
	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"
	accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_employee_dependent"></form>
</div>

</div>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchEmployeeDependentList.size()>0 && employeeCodeList.size() > 0)
		 {
			String strForCode = (String) map.get("employeeDependentCode");
			String strForCodeDescription = (String) map.get("employeeDependentName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
<div class="clear"></div>

<a href="personnel?method=showEmployeeDependentJsp">Show All Records</a>
<%
			}
		 }
	if(searchEmployeeDependentList.size()==0 && map.get("search") != null)
	{
	%> <a href="personnel?method=showEmployeeDependentJsp">Show All
Records</a> <%
	}
	%> <script type="text/javascript">
		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME%>"], [3,"<%= EMPLOYEE_DEPENDENT_DOB %>"],[4,"<%= EMPLOYEE_DEPENDENT_GENDER %>"],[5,"<%= EMPLOYEE_DEPENDENT_ADDRESS %>"],[6,"<%= EMPLOYEE_ID %>"],[7,"<%= RELATION_ID%>"],[8,"<%= CHANGED_BY%>"], [9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"] ];
	 statusTd = 11;
		</script></div>
<div class="clear"></div>
<div class="clear"></div>
<form name="employeeDependent" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="<%= POJO_NAME %>" value="MasEmployeeDependent"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="EmployeeDependentName"><input type="hidden" name="title"
	value="EmployeeDependent"><input type="hidden"
	name="<%=JSP_NAME %>" value="employeeDependent"><input
	type="hidden" name="pojoPropertyCode" value="EmployeeDependentCode"><br>
<div id=contentoperation><label class="bodytextB_blue"><font
	id="error">*</font>Dependent Code:</label> <input id="codeId" type="text"
	name="<%= CODE%>" value="" validate="Dependent Code,string,yes"
	class="textbox_size20" MAXLENGTH="8" / tabindex=1><label
	class="bodytextB_blue"><font id="error">*</font>Dependent Name:</label>
<input type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Dependent Name,string,yes" class="textbox_size20"
	MAXLENGTH="30" / tabindex=1><script>
				document.employeeDependent.<%=CODE%>.focus();
			</script> <label class="bodytextB_blue"><font id="error">*</font>
Employee Name:</label> <select name="<%= EMPLOYEE_ID %>"
	validate="Employee Name,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
		for (MasEmployee masEmployeecode : employeeCodeList) {
	%>

	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>

	<%
		}
	%>
</select> <label class="bodytextB_blue"><font id="error">*</font>
Relation Name:</label> <select name="<%= RELATION_ID %>"
	validate="Relation Name,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
		for (MasRelation masRelationcode : relationCodeList) {
	%>

	<option value="<%=masRelationcode.getId ()%>"><%=masRelationcode.getRelationName()%></option>

	<%
		}
		%>
</select> <label class="bodytextB_blue"><font id="error">*</font>Date of
Birth:</label> <input type="text" id="dobId" name="<%=EMPLOYEE_DEPENDENT_DOB%>"
	value="" class="textbox_date" readonly="readonly"
	validate="DOB,date,yes" MAXLENGTH="30" /> <a
	href="javascript:setdate('',document.employeeDependent.<%=EMPLOYEE_DEPENDENT_DOB%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label
	class="bodytextB_blue"><font id="error">*</font>Gender:</label> <select
	name="<%= EMPLOYEE_DEPENDENT_GENDER%>" validate="Gender,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<option value="M">Male</option>
	<option value="F">Female</option>
</select> <br />
<label class="bodytextB_blue"><font id="error">*</font> Address:</label>
<input type="text" name="<%= EMPLOYEE_DEPENDENT_ADDRESS %>" value=""
	validate="Address,string,yes" class="textbox_size20" MAXLENGTH="30"
	tabindex=1
	onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')"><br />
<br />
<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<br />

<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('employeeDependent','personnel?method=addEmployeeDependent','checkDOB');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('employeeDependent','personnel?method=editEmployeeDependent','checkDOB')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('employeeDependent','personnel?method=deleteEmployeeDependent')"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" /> <br />
<br />
<br /></form>

<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Employee Dependent Code"
	data_header[0][1] = "data";
	data_header[0][2] = "10%";
	data_header[0][3] = "<%= CODE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Employee Dependent Description"
	data_header[1][1] = "data";
	data_header[1][2] = "25%";
	data_header[1][3] = "<%= SEARCH_NAME %>";
	
	data_header[2] = new Array;
	data_header[2][0] = "Date of Birth"
	data_header[2][1] = "hide";
	data_header[2][2] = "15%";
	data_header[2][3] = "<%= EMPLOYEE_DEPENDENT_DOB %>";
	
	data_header[3] = new Array;
	data_header[3][0] = "Gender"
	data_header[3][1] = "hide";
	data_header[3][2] = "10%";
	data_header[3][3] = "<%= EMPLOYEE_DEPENDENT_GENDER %>";
	
	data_header[4] = new Array;
	data_header[4][0] = "Address"
	data_header[4][1] = "hide";
	data_header[4][2] = "30%";
	data_header[4][3] = "<%= EMPLOYEE_DEPENDENT_ADDRESS%>";
	
	data_header[5] = new Array;
	data_header[5][0] = "Employee"
	data_header[5][1] = "data";
	data_header[5][2] = "40%";
	data_header[5][3] = "<%=EMPLOYEE_ID %>";
	
	data_header[6] = new Array;
	data_header[6][0] = "Relation"
	data_header[6][1] = "data";
	data_header[6][2] = "40%";
	data_header[6][3] = "<%=RELATION_ID %>";
	
	data_header[7] = new Array;
	data_header[7][0] = ""
	data_header[7][1] = "hide";
	data_header[7][2] = 0;
	data_header[7][3] = "<%=CHANGED_BY %>"
	
	data_header[8] = new Array;
	data_header[8][0] = "Admin"
	data_header[8][1] = "hide";
	data_header[8][2] = 0;
	data_header[8][3] = "<%=CHANGED_DATE %>"
	
	data_header[9] = new Array;
	data_header[9][0] = ""
	data_header[9][1] = "hide";
	data_header[9][2] = "0";
	data_header[9][3] = "<%=CHANGED_TIME %>";
	
	data_header[10] = new Array;
	data_header[10][0] = "Status"
	data_header[10][1] = "data";
	data_header[10][2] = "15%";
	data_header[10][3] = "<%=STATUS %>";
	
	data_arr = new Array();
	
	<%
		Iterator itr=searchEmployeeDependentList.iterator();
	System.out.println("searchEmployeeDependentList>>"+searchEmployeeDependentList.size());
	    int  counter=0;
	    while(itr.hasNext())
	    {																																																											
	         MasEmployeeDependent  masEmployeeDependent= (MasEmployeeDependent)itr.next(); 
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= masEmployeeDependent.getId()%>
			data_arr[<%= counter%>][1] = "<%=masEmployeeDependent.getEmployeeDependentCode()%>"
			data_arr[<%= counter%>][2] = "<%= masEmployeeDependent.getEmployeeDependentName()%>"
			
			
			data_arr[<%= counter%>][3] ="<%=masEmployeeDependent.getDateOfBirth() != null ? HMSUtil.convertDateToStringWithoutTime(masEmployeeDependent.getDateOfBirth()) :""%>"
			
			data_arr[<%= counter%>][4] = "<%= masEmployeeDependent.getGender()%>"
			data_arr[<%= counter%>][5] = "<%= masEmployeeDependent.getAddress() != null ? masEmployeeDependent.getAddress() :""%>"
	<%
			
	
	Iterator itrGridEmployeeList=gridEmployeeList.iterator();
			System.out.println("gridEmployeeList>>"+gridEmployeeList.size());
	while(itrGridEmployeeList.hasNext())
   {
		MasEmployee  employeeGrid = (MasEmployee)itrGridEmployeeList.next(); 
		if(masEmployeeDependent.getEmployee().getId().equals(employeeGrid.getId()) && employeeGrid.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][6] = "<%=employeeGrid.getEmployeeCode()%> - <%=employeeGrid.getEmployeeName()%>";
		<%}else if(masEmployeeDependent.getId().equals(employeeGrid.getId()) && employeeGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=employeeGrid.getEmployeeCode()%> - <%=employeeGrid.getFirstName()%>";
			
		<%}
	}
		
			Iterator itrGridRelationList=gridRelationList.iterator();
		
			 while(itrGridRelationList.hasNext())
	       {
	       		MasRelation  rGrid = (MasRelation)itrGridRelationList.next(); 
				if(masEmployeeDependent.getRelation().getId().equals(rGrid.getId()) && rGrid.getStatus().equals("y")){%>
					data_arr[<%= counter%>][7] = "<%=rGrid.getRelationName()%>";
				<%}else if(masEmployeeDependent.getId().equals(rGrid.getId()) && rGrid.getStatus().equals("n")){%>
					data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=rGrid.getRelationName()%>";
					
				<%}
			} 
	%>
			data_arr[<%= counter%>][8] = "<%= masEmployeeDependent.getLastChgBy() %>"
			data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(masEmployeeDependent.getLastChgDate()) %>"
			data_arr[<%= counter%>][10] = "<%= masEmployeeDependent.getLastChgTime() %>"
			<% if(masEmployeeDependent.getStatus().equalsIgnoreCase("y")){ %>
					data_arr[<%= counter%>][11] = "Active"
			<%}else{%>
					data_arr[<%= counter%>][11] = "InActive"
			<%}
	
			     counter++;
		}
	%>
	 formName = "employeeDependent"
	nonEditable = ['<%=EMPLOYEE_DEPENDENT_CODE%>'];
	
	
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script>
