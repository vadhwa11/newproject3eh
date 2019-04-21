<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_employeeContract.jsp  
 * Purpose of the JSP -  This is for Employee Contract Details.
 * @author  Rajat  
 * Create Date: 07th Jan,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.10
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hrms.masters.business.*"%>
<%@ page import="jkt.hms.masters.business.*"%>
<%@ page import="jkt.hms.util.*"%>

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
<%	
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	}

	Map<String,Object> mapEmployee = new HashMap<String,Object>();
	
	if(request.getAttribute("map") != null){
	mapEmployee = (Map<String,Object>) request.getAttribute("map");
	}
	
	List<MasEmployeeContract> searchEmployeeContractList = new ArrayList<MasEmployeeContract>(); 
	if(mapEmployee.get("searchEmployeeContractList") != null){
		searchEmployeeContractList = (List)mapEmployee.get("searchEmployeeContractList");
		session.setAttribute("mapEmployeeContract",mapEmployee);
	}
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>(); 
	if(mapEmployee.get("employeeList") != null){
		employeeList = (List)mapEmployee.get("employeeList");
	}
	
	List<MasEmployee> employeeListForSearch = new ArrayList<MasEmployee>(); 
	if(mapEmployee.get("employeeListForSearch") != null){
		employeeListForSearch = (List)mapEmployee.get("employeeListForSearch");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message = "";
	if(mapEmployee.get("message") != null)
	{
		message = (String)mapEmployee.get("message");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	/* List<MasEmployeeContract> searchEmployeeList = new ArrayList<MasEmployeeContract>(); 
	if(mapEmployee.get("searchEmployeeList") != null){
		searchEmployeeList = (List)mapEmployee.get("searchEmployeeList");
		
	}
	System.out.println(">jsp>>>"+searchEmployeeList.size()); */
%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Employee Contract</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Employee Name</label> <select name="<%=EMPLOYEE_CODE %>" id='searchField' validate="Employee Name,alphanumeric,no">
	<option value="">Select</option>
	<% for(MasEmployee employee: employeeList){%>

	<option value="<%=employee.getId() %>"><%=employee.getEmployeeName()+" - " +employee.getEmployeeCode()%>
	</option>
	<%} %>
</select>
<div class="clear"></div>
<input type="button" name="search" value="Search" class="inputButtonAutu"
	onclick="submitForm('search','/hms/hms/personnel?method=searchEmployeeContract','checkSearch')"
	tabindex=1 /> <input type="button" name="Report"
	value="Generate Report Based on Search" class="inputButtonAutu"
	onClick="submitForm('search','personnel?method=generateReportForEmployeeContract');"
	accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_employee"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>

<script type="text/javascript">
	
	formFields = [
	[0, "<%= COMMON_ID%>", "id"], [1,"<%= EMPLOYEE_CONTRACT_ID%>"],[2,"<%= EMPLOYEE_ID%>"],  [3,"<%= AGENCY %>"],[4,"<%= AGREEMENT_START_DATE %>"],[5,"<%= AGREEMENT_END_DATE %>"],[6,"<%= AGREEMENT_TYPE%>"],[7,"<%= CATEGORY %>"],[8,"<%= AGREEMENT_REMARKS %>"],[9,"<%= DOCUMENTS_SUBMITTED %>"],[10,"<%= AGREEMENT_RULES %>"],[11,"<%= STATUS %>"]
	,[12,"conSal"],[13,"desig"]];
	 statusTd = 11;
	</script>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults">
<div id="searchtable"></div>
<% try{
		if(searchEmployeeContractList.size()>0 )
		 {
			/* String strForCode = (String)mapEmployee.get("employeeCode");
			String strForCodeFirstDescriptions = (String)mapEmployee.get("firstName");
			String strForCodeLastDescriptions = (String)mapEmployee.get("lastName"); */
			String search = (String)mapEmployee.get("search");
			if(search!= null && search!= "")	
			{
	%> <a href="personnel?method=showEmployeeContractJsp">Show AllRecords</a> <%

			}
			
		 }
		}
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	 if(searchEmployeeContractList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="personnel?method=showEmployeeContractJsp">Show All Records</a> <%

      }
 	%>
</div>

<div class="clear"></div>

<form name="employeeContract" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasEmployee"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="FirstName"><input
	type="hidden" name="title" value="Employee"><input
	type="hidden" name="<%=JSP_NAME %>" value="employee"><input
	type="hidden" name="pojoPropertyCode" value="EmployeeCode"><input
	type="hidden" id="dclick" value="yes"><input type="hidden"
	id="rowid" value=""><input type="hidden" name="<%=STATUS%>"
	value="" /> <input type="hidden" name="<%=EMPLOYEE_CONTRACT_ID%>"
	value="" />


<div class="Block" id="title1">
<label>Employee Name<span>* </span></label> 
<select name="<%=EMPLOYEE_ID %>" id="<%=EMPLOYEE_ID %>" validate="Employee Code,alphanumeric,yes" onchange="getDesig(this.value)">
	<option value="">Select</option>
	<% for(MasEmployee employee: employeeList){%>

	 <option value="<%=employee.getId() %>"><%=employee.getEmployeeName()+" - " +employee.getEmployeeCode()%>
	</option> 
	<%} %>
</select> <label>Agency</label> 
<input type="text" name="<%=AGENCY %>" value=""	validate="Agency,alphanumeric,no" maxlength="45"/>
 <label><span>* </span>Category</label>
<select name="<%=CATEGORY %>" validate="Category,alphanumeric,yes">
	<option value="">Select</option>
	<option value="Skilled">Skilled</option>
	<option value="Unskilled">Unskilled</option>
</select>


<div class="clear"></div>

<%-- <label><span>* </span>Agreement Type</label> 
	<select name="<%=AGREEMENT_TYPE %>" validate="Agreement Type,string,no">
	<option value="">Select</option>
	<option value="Agreement">Agreement</option>
	<option value="Non Agreement">Non Agreement</option>
</select> --%>

 <label>Agreement Start Date<span>* </span></label> 
	<input type="text"  id="<%=AGREEMENT_START_DATE%>" name="<%=AGREEMENT_START_DATE%>" value="" class="date"  onkeyup="mask(this.value,this,'2,5','/');"  onblur="validateExpDate(this,'td');" maxlength="10" validate="Agreement Start Date,date,no" /> 
	
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.employeeContract.<%=AGREEMENT_START_DATE%>,event)"
	validate="Pick a date" class="calender" /> 	
	
<label >Agreement End Date<span>* </span></label> 
<input type="text" id="<%=AGREEMENT_END_DATE%>" onkeyup="mask(this.value,this,'2,5','/');"  onblur="validateExpDate(this,'td');"
	name="<%=AGREEMENT_END_DATE%>" value="" class="date" validate="Agreement End Date,date,no" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" 	height="16" border="0" onClick="javascript:setdate('',document.employeeContract.<%=AGREEMENT_END_DATE%>,event)"
	validate="Pick a date" class="calender" />	

<label>Designation<span>* </span></label> 
<input type="text" name="desig" id="desig"	validate="Designation,string,no" maxlength="45" />	

<div class="clear"></div>
<label>Consolidated Salary<span>* </span></label> 
<input type="text" name="conSal" id="conSal" validate="Consolidated Salary,string,no" maxlength="5" />

<label>Agreement Remarks</label> <textarea name="<%=AGREEMENT_REMARKS%>"
	id="<%=AGREEMENT_REMARKS%>" validate="Agreement Remarks,string,no" maxlength="45" class="textareaMediua"
	onkeydown="refreshLengthWithoutMeter1(this.id,45)"
	onkeyup="refreshLengthWithoutMeter(this.id,45)"></textarea> 
	<label>Documents
Submitted</label> <textarea name="<%=DOCUMENTS_SUBMITTED%>"
	id="<%=DOCUMENTS_SUBMITTED %>" validate="Documents Submitted,string,no"
	onkeydown="refreshLength1(this.id,45)"  maxlength="45" class="textareaMediua"
	onkeyup="refreshLength(this.id,45)"></textarea>	
	<div class="clear"></div>	
	 <label>Agreement Rules</label>
 <textarea name="<%=AGREEMENT_RULES%>" id="<%=AGREEMENT_RULES %>"
	validate="Agreement Rules,string,no" class="textareaMediua"
	onkeydown="refreshLength1(this.id,250)"
	onkeyup="refreshLength(this.id,250)"></textarea>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('employeeContract','personnel?method=addEmployeeContract','check()');"
	accesskey="a" /> <input type="button" name="edit" id="editbutton"
	value="Update" style="display: none;" class="button"
	onClick="submitForm('employeeContract','personnel?method=addEmployeeContract')"
	accesskey="u" /> <input type="button" name="Delete" id="deletebutton"
	value="Activate" style="display: none;" class="button"
	onClick="submitForm('employeeContract','personnel?method=deleteEmployeeContract&flag='+this.value,'removeMandatory')"
	accesskey="d" /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="buttonHighlight" onClick="resetCheck();"
	accesskey="r" /> <input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%=COMMON_ID%>" value="" /> <input
	type="hidden" name="<%= HOSPITAL_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>

<div class="clear"></div>
<script type="text/javascript">

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Contract Id."
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%= EMPLOYEE_CONTRACT_ID %>"

data_header[1] = new Array;
data_header[1][0] = "Employee Name"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%= EMPLOYEE_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Agency"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= AGENCY %>"

data_header[3] = new Array;
data_header[3][0] = "Agreement Start Date"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%= AGREEMENT_START_DATE %>"

data_header[4] = new Array;
data_header[4][0] = "Agreement End Date"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= AGREEMENT_END_DATE%>"

data_header[5] = new Array;
data_header[5][0] = "Agreement Type"
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= AGREEMENT_TYPE %>"

data_header[6] = new Array;
data_header[6][0] = "Category"
data_header[6][1] = "data";
data_header[6][2] = 0;
data_header[6][3] = "<%= CATEGORY %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%= AGREEMENT_REMARKS %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%= DOCUMENTS_SUBMITTED %>"

data_header[9] = new Array;
data_header[9][0] = "Agreement Rules"
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%= AGREEMENT_RULES %>"

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "data";
data_header[10][2] = 0;
data_header[10][3] = "<%= STATUS %>"

data_header[11] = new Array;
data_header[11][0] = "Consolidated Salary"
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "conSal"

	data_header[12] = new Array;
data_header[12][0] = "Designation"
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "desig"


  
data_arr = new Array();

<%
	int  counter=0;
	for (MasEmployeeContract masEmp : searchEmployeeContractList) {
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=masEmp.getId()%>";


<%if(masEmp.getId()!= null){%>
data_arr[<%= counter%>][1] = "<%=masEmp.getId()%>"
<%}else {%>
data_arr[<%= counter%>][1] = ""
<%} %>


<%-- <% if(masEmp.getEmployee().getEmployeeCode() != null){
	Iterator itrTitleList= employeeList.iterator();
	 while(itrTitleList.hasNext())
        {
         MasEmployee  masEmployee = (MasEmployee)itrTitleList.next(); 
         System.out.println(masEmp.getEmployee().getId()+"   "+ masEmployee.getId());
		 if(( masEmp.getEmployee().getId()== masEmployee.getId()) && masEmployee.getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][2] = "<%=masEmployee.getEmployeeName()+" - " +masEmployee.getEmployeeCode()%>"
		<%}else if(masEmp.getEmployee().getId().equals(masEmployee.getId()) && masEmployee.getStatus().equals("n")){%>
			data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent nActivated--<%=masEmployee.getFirstName()+" " + masEmployee.getLastName()+" - " +masEmployee.getEmployeeCode()%>";
			
		<%}/* else{ */%>
			data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent inActivated--<%=masEmp.getEmployee().getFirstName()+" " + masEmp.getEmployee().getLastName()+" - " +masEmp.getEmployee().getEmployeeCode()+" "+masEmployee.getStatus()%>";
		<%//}
		}%>
<%}else {%>
data_arr[<%= counter%>][2] = ""
<%}%> --%>


 <% if(masEmp.getEmployee().getEmployeeCode() != null){
	
	
        
		 if( masEmp.getEmployee().getStatus().equalsIgnoreCase("y")){%>
			data_arr[<%= counter%>][2] = "<%=masEmp.getEmployee().getEmployeeName()+" - " +masEmp.getEmployee().getEmployeeCode()%>"
		<%}else if(masEmp.getEmployee().getStatus().equals("n")){%>
			data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masEmp.getEmployee().getFirstName()+" " + masEmp.getEmployee().getLastName()+" - " +masEmp.getEmployee().getEmployeeCode()%>";
			
		<%}
		%>
<%}else {%>
data_arr[<%= counter%>][2] = ""
<%}%> 


<% if(masEmp.getAgency() != null ){%>
data_arr[<%= counter%>][3] = "<%=masEmp.getAgency()%>"
<%}else{%>
data_arr[<%= counter%>][3] = ""
<%}%>
<%if(masEmp.getAgreementStartDate() != null){%>
data_arr[<%= counter%>][4] = "<%= HMSUtil.changeDateToddMMyyyy(masEmp.getAgreementStartDate())%>"
<%} else {%>
data_arr[<%= counter%>][4] = ""
<%} if(masEmp.getAgreementEndDate() != null){%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.changeDateToddMMyyyy(masEmp.getAgreementEndDate())%>"
<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>
<% if(masEmp.getAgreementType() != null){%>
data_arr[<%= counter%>][6] = "<%=masEmp.getAgreementType()%>"
<%}else{%>
data_arr[<%= counter%>][6] = ""
<%}%>
<% if(masEmp.getCategory() != null){%>
data_arr[<%= counter%>][7] = "<%=masEmp.getCategory()%>"
<%}else{%>
data_arr[<%= counter%>][7] =""
<%}%>
<% if(masEmp.getAgreementRemark() != null){%>
var str2=changeDateToddMMyyyy("<%= masEmp.getAgreementRemark()%>")
data_arr[<%= counter%>][8] = "<%= masEmp.getAgreementRemark()%>"
<%}else{%>
data_arr[<%= counter%>][8] = ""
<%}if(masEmp.getDocumentsSubmitted() != null){%>
data_arr[<%= counter%>][9] = "<%= masEmp.getDocumentsSubmitted()%>"
<%}else{%>
data_arr[<%= counter%>][9] = ""
<%}
if(masEmp.getAgreementRules() != null){%>
data_arr[<%= counter%>][10] = "<%= masEmp.getAgreementRules() %>"
<%}else {%>
data_arr[<%= counter%>][10] = ""
<%}%> 
<%if(masEmp.getStatus().equals("y") ){%>
data_arr[<%= counter%>][11] = "Active"
<%}else {%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>


data_arr[<%= counter%>][12] =  "<%= masEmp.getConSalary() %>"
data_arr[<%= counter%>][13] =  "<%= masEmp.getEmployee().getRank().getRankName() %>"


<%
		     counter++;
}
%>
formName = "employeeContract"


 
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	
	
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');

function removeMandatory()
	{
	document.getElementById('<%=EMPLOYEE_ID%>').setAttribute('validate','Employee Name,string,no');
	return true;
	}
</script>


<script>
function check(){
	var SDate = document.employeeContract.<%=AGREEMENT_START_DATE%>.value;
	var EDate = document.employeeContract.<%=AGREEMENT_END_DATE%>.value;


	var	endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
	var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

	if(startDate > endDate)
	{
		alert("Please ensure that the Agreement End Date is greater than or equal to the Agreement Start Date.");
		// document.calldate.next_day.focus();
		return false;
	}
}

function getDesig(val){
		
	document.getElementById('desig').value ='';
		if(val!=""){
		var size = <%=employeeList.size()%>
				
				<%
				for(MasEmployee mid:employeeList){%>
			
					if(<%=mid.getId()%> == val){<%
					if(mid.getStatus().equals("y")){
				%>
				document.getElementById('desig').value = '<%=mid.getRank().getRankName()%>'
						
				<%}
				%>
					}
					<%}%>
				
			}
		
		
	}
	

</script>
