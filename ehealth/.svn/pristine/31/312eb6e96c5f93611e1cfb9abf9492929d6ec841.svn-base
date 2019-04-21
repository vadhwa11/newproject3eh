<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * employeeDependent.jsp  
 * Purpose of the JSP -  This is for Dependent Employee.
 * @author  Rajat
 * Create Date: 7th Feb,2009 
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
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>

<script>
	<%
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
	vDate = new Date();
					var month = vDate.getMonth() + 1
					var day = vDate.getDate()
					var year = vDate.getFullYear()
					var seperator = "/"
					vDate = new Date(month + seperator + day + seperator + year); 
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
      	var curr_month = d.getMonth() + 1;
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
       		if(d.getMonth()+ 1 < 10){
       		   mth = "0"+ curr_month
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

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> mapEmployee = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		mapEmployee = (Map<String,Object>) request.getAttribute("map");
		}
		
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	
	List<MasEmployeeDependent> searchEmployeeDependentList = new ArrayList<MasEmployeeDependent>(); 
	if(mapEmployee.get("searchEmployeeDependentList") != null){
		searchEmployeeDependentList = (List)mapEmployee.get("searchEmployeeDependentList");
	
	}
	List<MasAdministrativeSex>  gridAdministrativeSexList=new ArrayList<MasAdministrativeSex>();
	if(map.get("gridAdministrativeSexList") != null){
		gridAdministrativeSexList = (List<MasAdministrativeSex>)mapEmployee.get("gridAdministrativeSexList");
		
	}
	

	List<MasEmployee> employeeCodeList = new ArrayList<MasEmployee>();
	employeeCodeList = (ArrayList) map.get("employeeCodeList");
	List<MasRelation> relationCodeList = new ArrayList<MasRelation>();
	relationCodeList = (ArrayList) map.get("relationCodeList");
    //ArrayList searchEmployeeDependentList = (ArrayList) map.get("searchEmployeeDependentList");
    ArrayList gridEmployeeList = (ArrayList) map.get("gridEmployeeList");
	ArrayList gridRelationList = (ArrayList) map.get("gridRelationList");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String message = "";
	if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Employee Dependent</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
 <label>PEN</label>  
 <input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Dependent Name</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Employee Dependent Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=searchEmployeeDependent')" />

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchEmployeeDependent','checkSearch')" tabindex=1 /> 
<%--- Report Button  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','personnel?method=generateReportForEmployeeDependent');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_employee_dependent">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
</div>
<div class="clear"></div>
<!-- end of div Block -->
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchEmployeeDependentList.size()>0)
		 {
			String strForCode = (String) map.get("employeeDependentcodeCode");
			String strForCodeDescription = (String) map.get("employeeDependentcodeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4> <a href="personnel?method=showEmployeeDependentJsp">Show All Records</a></h4> <%
			}
		 }
	if(searchEmployeeDependentList.size()==0 && map.get("search") != null)
	{
	%><h4> <a href="personnel?method=showEmployeeDependentJsp">Show All Records</a></h4> <%
	}
	%> <script type="text/javascript">
		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME%>"], [3,"<%= EMPLOYEE_DEPENDENT_DOB %>"],[4,"<%= EMPLOYEE_DEPENDENT_GENDER %>"],[5,"<%= EMPLOYEE_DEPENDENT_ADDRESS %>"],[6,"<%= EMPLOYEE_ID %>"],[7,"<%= RELATION_ID%>"],[8,"<%= CHANGED_BY%>"], [9,"<%= CHANGED_DATE %>"],
				[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"],[12,"empCode"] ];
	 statusTd = 12;
		</script></div>
<div class="clear"></div>
<form name="employeeDependent" method="post" action="">
<input
	type="hidden" name="<%= POJO_NAME %>" value="MasEmployeeDependent">
	<input 	type="hidden" name="<%=POJO_PROPERTY_NAME %>"	value="EmployeeDependentName">
	<input type="hidden" name="title"	value="EmployeeDependent">
	<input type="hidden"	name="<%=JSP_NAME %>" value="employeeDependent">
	<input	type="hidden" name="pojoPropertyCode" value="EmployeeDependentCode">	
<div class="Block"> 
<div class="clear"></div>
<label><span>*</span> Employee Name</label> 
<select	id="<%= EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"	validate="Employee Name,string,yes"	onchange="populateDependentCode(this)">
	<option value="">Select</option>
	<%
		for (MasEmployee masEmployeecode : employeeCodeList) {
	%>
   
	<option value="<%=masEmployeecode.getId()%>"><%=masEmployeecode.getEmployeeName()%></option>

	<%
		}
	%>
 </select> 
 <label><span>*</span> PEN</label> 
 <input id="empCode" 	type="text" name="empCode" value=""	validate="PEN,string,yes" maxlength="10" />
 
 <input id="codeId"	type="hidden" name="<%= CODE%>" value=""	validate="Dependent Code,string,yes" maxlength="10" />
<label><span>*
</span>Dependent Name</label> <input type="text" id="<%= SEARCH_NAME%>"
	name="<%= SEARCH_NAME %>" value="" validate="Dependent Name,string,yes"
	class="textbox_size20" MAXLENGTH="30" tabindex=1 /> <script>
				document.employeeDependent.<%=CODE%>.focus();
			</script>
 
<div class="clear"></div>
<label><span>*</span> Relationship</label> <select
	name="<%= RELATION_ID %>" validate="Relation Name,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%
		for (MasRelation masRelationcode : relationCodeList) {
	%>
	<option value="<%=masRelationcode.getId ()%>"><%=masRelationcode.getRelationName()%></option>
	<%
		}
		%>
</select> <label><span>* </span>Date of Birth</label> <input type="text"
	id="dobId" name="<%=EMPLOYEE_DEPENDENT_DOB%>" value=""
	readonly="readonly" class="date" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="javascript:setdate('',document.employeeDependent.<%=EMPLOYEE_DEPENDENT_DOB%>,'event')" />


<label><span>*</span> Gender</label> <select
	name="<%= EMPLOYEE_DEPENDENT_GENDER%>" validate="Gender,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%for(MasAdministrativeSex masAdministrativeSex:gridAdministrativeSexList) {%>
	<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName()%></option>
	<%} %>
</select>

<div class="clear"></div>
 <label> AAdhar</label>
<input id="codeId" type="text" name="aadhar" value="" validate="AAdhar,string,no" maxlength="10" />
 
<div class="clear"></div>	
 <label>Permanent</label>     
<input type="radio" name="<%=SELECTED_RADIO  %>" value="with" checked="checked" class="inputRadiobutton" tabindex=1  onClick="notify(this.value)"/>
			    	
<label>Temporary</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="without"  class="inputRadiobutton"  tabindex=1 MAXLENGTH="128" onClick="notify(this.value)"/>
			    	
<label>Present</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="without"  class="radioAuto"  tabindex=1 MAXLENGTH="128" onClick="notify(this.value)"/>

<div class="clear"></div>
<label><span>*</span> Address</label> <textarea
	name="<%= EMPLOYEE_DEPENDENT_ADDRESS %>"
	id="<%= EMPLOYEE_DEPENDENT_ADDRESS%>" validate="Address,string,yes"
	onkeydown="refreshLength1(this.id,30)" class="textareaMediua"
	onkeyup="refreshLength(this.id,30)" tabindex=1
	onkeypress="return submitenter(this,event,'personnel?method=addEmployeeDependent')"
	maxlength="30"></textarea> 
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="if(checkDOB()){submitForm('employeeDependent','personnel?method=addEmployeeDependent');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('employeeDependent','personnel?method=editEmployeeDependent','checkDOB')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="InActivate" style="display: none;"
	class="button"
	onClick="submitForm('employeeDependent','personnel?method=deleteEmployeeDependent','removeMandatory')"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS%>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Employee Dependent Code"
	data_header[0][1] = "hide";
	data_header[0][2] = "10%";
	data_header[0][3] = "<%= CODE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Employee Dependent Name"
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
	
	data_header[11] = new Array;
	data_header[11][0] = "Pen"
	data_header[11][1] = "data";
	data_header[11][2] = "15%";
	data_header[11][3] = "empCode";
	
	data_arr = new Array();
	
	<%
		Iterator itr=searchEmployeeDependentList.iterator();
	    int  counter=0;
	    while(itr.hasNext())
	    {																																																											
	         MasEmployeeDependent  masEmployeeDependent= (MasEmployeeDependent)itr.next(); 
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= masEmployeeDependent.getId()%>
			data_arr[<%= counter%>][1] = "<%=masEmployeeDependent.getEmployeeDependentCode()%>"
			data_arr[<%= counter%>][2] = "<%= masEmployeeDependent.getEmployeeDependentName()%>"
			
			<%
			if(masEmployeeDependent.getDateOfBirth() != null){
			%>
			data_arr[<%= counter%>][3] ="<%= HMSUtil.convertDateToStringWithoutTime(masEmployeeDependent.getDateOfBirth()) %>"
			<%}else{%>
			data_arr[<%= counter%>][3] ="";
			<%}%>
			data_arr[<%= counter%>][4] = "<%= masEmployeeDependent.getGender().getAdministrativeSexName()%>"
			data_arr[<%= counter%>][5] = "<%= masEmployeeDependent.getAddress()%>"
	<%
			
	
	Iterator itrGridEmployeeList= gridEmployeeList.iterator();
	while(itrGridEmployeeList.hasNext())
   {
		MasEmployee  employeeGrid = (MasEmployee)itrGridEmployeeList.next(); 
		if(masEmployeeDependent.getEmployee().getId().equals(employeeGrid.getId()) && employeeGrid.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][6] = "<%=employeeGrid.getEmployeeName()%>";
		<%}else if(masEmployeeDependent.getId().equals(employeeGrid.getId()) && employeeGrid.getStatus().equalsIgnoreCase("n")){%>
			data_arr[<%= counter%>][6] = "<span>* </span>Parent InActivated--<%=employeeGrid.getEmployeeCode()%> - <%=employeeGrid.getFirstName()%>";
			
		<%}
	}
		
			Iterator itrGridRelationList=gridRelationList.iterator();
			while(itrGridRelationList.hasNext())
	       {   MasRelation  rGrid = (MasRelation)itrGridRelationList.next(); 
				if(masEmployeeDependent.getRelation().getId().equals(rGrid.getId()) && rGrid.getStatus().equalsIgnoreCase("y")){%>
					data_arr[<%= counter%>][7] = "<%=rGrid.getRelationName()%>";
				<%}else if(masEmployeeDependent.getRelation().getId().equals(rGrid.getId()) && rGrid.getStatus().equalsIgnoreCase("n")){%>
					data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated-- <%=masEmployeeDependent.getId()%> <%=rGrid.getRelationName()%>";
					
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
			<%}%>
			<%if(masEmployeeDependent.getEmployee().getPEN()!=null){%>
			data_arr[<%= counter%>][12] = "<%= masEmployeeDependent.getEmployee().getPEN().trim() %>"
			<%}else{%>
			data_arr[<%= counter%>][12] = "";
			<%}%>
	<%
			     counter++;
		}
	%>
	 formName = "employeeDependent"
	nonEditable = "";
	
	
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script>

<script>
	function populateDependentCode(obj){
	id = obj.value;
	<%for(MasEmployee employee : employeeCodeList){%>
		if(id == <%=employee.getId()%>){
		 document.getElementById('codeId').value = '<%=employee.getPEN()%>';
		 
		}
	<%}%>
	
	}
	
	function removeMandatory()
	{
	document.getElementById('<%=EMPLOYEE_ID%>').setAttribute('validate','Employee Name,string,no');
	return true;
	}
	</script>