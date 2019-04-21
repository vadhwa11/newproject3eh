<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_CTCAnnexure.jsp  
 * Purpose of the JSP -  This is for candidate CTC Annexure.
 * @author  Rajat  
 * Create Date: 22th April,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.10
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.math.*"%>
<%@ page import="java.text.*"%>
<%@ page import="jkt.hrms.masters.business.*"%>
<%@ page import="jkt.hms.masters.business.*"%>
<%@ page import="jkt.hms.util.*"%>
<%@page
	import="jkt.hrms.recruitment.masters.business.Resumepersonaldetails"%>
<%@page
	import="jkt.hrms.recruitment.masters.business.HrResumePayElements"%>
	
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
	Resumepersonaldetails resume = new Resumepersonaldetails(); 
	if(mapEmployee.get("resume") != null){
		resume = (Resumepersonaldetails)mapEmployee.get("resume");
	}
	List<HrResumePayElements> searchResumePayElementsList = new ArrayList<HrResumePayElements>(); 
	if(mapEmployee.get("searchResumePayElementsList") != null){
		searchResumePayElementsList = (List)mapEmployee.get("searchResumePayElementsList");
		session.setAttribute("searchResumePayElementsList",searchResumePayElementsList);
	}
	
	
	
	List<HrMasPayElement> payElementsList = new ArrayList<HrMasPayElement>();
	if(mapEmployee.get("payElementsList") != null){
		payElementsList = (List)mapEmployee.get("payElementsList");
	}
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(mapEmployee.get("message") != null){
		message = (String)mapEmployee.get("message");
	}
	
	BigDecimal totalAmount = new BigDecimal(0);
	for(HrResumePayElements resumePayElements :searchResumePayElementsList  )
	{
		
			totalAmount =  resumePayElements.getPayAmount().add(totalAmount);
		
	
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	Integer basic = new Float(new Float(resume.getResumeStatus().getCtc())* .35).intValue();
%>

<div class="titleBg">
<h2>CTC Annexure</h2>
<div class="Block"><a href="javascript:refreshPage();">Refresh</a>
</div>
</div>

<h4><%=message%></h4>
<div class="clear"></div>
<div class="Block">

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><label>Candidate
Name</label> <label class="value"><%=resume.getFirstName() + " " + resume.getLastName() %></label>

<label>Designation Offered</label> <label class="value"><%=resume.getResumeStatus().getDesignation().getRankName() %></label>
<div class="clear"></div>
<label>CTC (in Rs.)</label> <input type="text" name="<%=CTC%>"
	id="<%=CTC %>"
	value="<%=new Float(resume.getResumeStatus().getCtc()) %>"
	validate="CTC,float,yes" maxlength="10" /> <label>Basic (in
Rs.)</label> <input type="text" name="" value="<%=basic %>" class="readOnly"
	readonly />

<div class="clear"></div>
<div class="paddingTop15"></div>

<input type="button" name="update" value="Update" class="button"
	onclick="alertAndSubmit()" tabindex=1 /> <input type="button"
	name="payelements" value="Assign Pay Elements" class="buttonBig"
	onclick="submitForm('search','resume?method=showAssignPayElements&<%=RequestConstants.RESUMEID%>=<%=resume.getId() %>')"
	tabindex=1 /> <!--<input type="button" name="preview" value="Preview CTC Annexure" class="buttonBig" onclick="submitForm('search','resume?method=previewCTCAnnexureHr&<%=RequestConstants.RESUMEID%>=<%=resume.getId() %>')" tabindex=1  />
		       	--><input type="button" name="sendForApproval"
	id="sendForApproval" value="Send For Approval" class="buttonBig"
	onClick="checkCTC()" accesskey="a" /> <input type="button" name="back"
	id="back" value="Back" class="buttonBig"
	onClick="submitForm('search','resume?method=viewResume&<%=RequestConstants.RESUMEID %>=<%=resume.getId() %>');"
	accesskey="a" /> <!--<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig2" onClick="submitForm('search','personnel?method=generateReportForEmployeePayElement');" accesskey="g" tabindex=1/>
                --><input type="hidden" name="<%=JASPER_FILE_NAME%>"
	value="Mas_employee">
<div class="clear"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>

<script type="text/javascript">
	
	formFields = [
	[0, "<%= COMMON_ID%>", "id"], [1,"<%= PAY_ELEMENT_CODE%>"],  [2,"<%=PAY_ELEMENT_DESC%>"],[3,"<%= PAY_AMOUNT %>"],[4,"<%= PAY_ELEMENT_TYPE %>"],[5,"<%= PAY_ELEMENT_START_DATE%>"],[6,"<%= EMPLOYEE_ID %>"],[7,"<%= STATUS %>"]];
	 statusTd = 7;
	</script>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults">
<div id="searchtable"></div>
<div class="division"></div>
<% try{
		if(searchResumePayElementsList.size()>0 )
		 {
			String strForCode = (String)mapEmployee.get("employeeCode");
			String strForCodeFirstDescriptions = (String)mapEmployee.get("firstName");
			String strForCodeLastDescriptions = (String)mapEmployee.get("lastName");
			if(strForCode!= null && strForCode!= "" || strForCodeFirstDescriptions!= null && strForCodeFirstDescriptions!= "" || strForCodeLastDescriptions!=null && strForCodeLastDescriptions!="")
			{
	%> <a href="personnel?method=showEmployeePayElementJsp">Show All
Records</a> <%
			}
		 }
		}
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
	 if(searchResumePayElementsList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="personnel?method=showEmployeePayElementJsp">Show All
Records</a> <%
      }
 	%>


<div class=="clear"></div>

<form name="employeePayElements" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasEmployee"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="FirstName"><input
	type="hidden" name="title" value="Employee"><input
	type="hidden" name="<%=JSP_NAME %>" value="employee"><input
	type="hidden" name="pojoPropertyCode" value="EmployeeCode"><input
	type="hidden" id="dclick" value="yes"><input type="hidden"
	id="rowid" value="">
<div class="clear"></div>
<div class="Block" id="title1">


<h4>Total Pay Elements Amount : Rs. <%=totalAmount %></h4>
<div class="clear"></div>

<h4>Remaining Amount : Rs. <%=(new BigDecimal(resume.getResumeStatus().getCtc())).subtract(totalAmount).subtract(new BigDecimal(basic)) %></h4>
<div class="clear"></div>

<label><span>* </span>Pay Element Code</label> <select
	name="<%=PAY_ELEMENT_CODE %>" validate="Pay Element Code,string,yes"
	onchange="populateElementType(this)">
	<option value="">Select</option>
	<%for(HrMasPayElement payElement : payElementsList){ %>
	<option value="<%= payElement.getId()%>"><%=payElement.getPayElementCode() + "--" + payElement.getPayElementDesc()%>
	</option>
	<%} %>
</select> <label>Pay Amount</label> <input type="text" name="<%=PAY_AMOUNT %>"
	validate="Pay Amount,float,yes" maxlength="10" />


<div class="clear"></div>

<label><span>* </span>Start Date</label> <input type="text"
	name="<%=PAY_ELEMENT_START_DATE %>" class="date"
	validate="Start Date,date,yes" /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0"
	onClick="javascript:setdate('',document.employeePayElements.<%=PAY_ELEMENT_START_DATE%>,'event')"
	validate="Pick a date" class="calender" /> <label><span>*
</span>Pay Element Type</label> <input type="text" id="<%=PAY_ELEMENT_TYPE%>"
	name="<%=PAY_ELEMENT_TYPE%>" value=""
	validate="Pay Element Type,string,no" class="readOnly"
	readonly="readonly" MAXLENGTH="30" />

<div class="clear"></div>


</div>


<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div class="clear"></div>


<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('employeePayElements','resume?method=addOrUpdateResumePayElement&<%=RequestConstants.RESUMEID %>=<%=resume.getId() %>');"
	accesskey="a" />
<input type="button" name="edit" id="editbutton" value="Update"
	style="display: none;" class="button"
	onClick="submitForm('employeePayElements','resume?method=addOrUpdateResumePayElement&<%=RequestConstants.RESUMEID %>=<%=resume.getId() %>');"
	accesskey="u" />
<input type="button" name="Delete" id="deletebutton" value="Activate"
	style="display: none;" class="button"
	onClick="submitForm('employeePayElements','personnel?method=deleteEmployeePayElement&flag='+this.value,'removeMandatory')"
	accesskey="d" />
<input type="reset" name="Reset" id="reset" value="Reset"
	class="buttonHighlight" onclick="location.reload();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />

<input type="hidden" name="<%= HOSPITAL_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Payment Element Code."
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%= PAY_ELEMENT_CODE %>"

data_header[1] = new Array;
data_header[1][0] = "Pay Element Desc"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%= PAY_ELEMENT_DESC %>";

data_header[2] = new Array;
data_header[2][0] = "Pay Amount"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%=PAY_AMOUNT%>"

data_header[3] = new Array;
data_header[3][0] = "Pay Element Type"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= PAY_ELEMENT_TYPE %>"

data_header[4] = new Array;
data_header[4][0] = "Start Date "
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= PAY_ELEMENT_START_DATE%>"

data_header[5] = new Array;
data_header[5][0] = "Employee"
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= EMPLOYEE_ID %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = 0;
data_header[6][3] = "<%=STATUS%>"

data_arr = new Array();

<%
	int  counter=0;
	for (HrResumePayElements masEmp : searchResumePayElementsList) {
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%=masEmp.getId()%>



<%if(true){
	for(HrMasPayElement payElement : payElementsList)
	{
	 if( payElement !=null && payElement.getId().equals(masEmp.getPayElement().getId()) && masEmp.getPayElement().getStatus().equals("y") ){
		 %>
	     data_arr[<%= counter%>][1] = "<%=payElement.getPayElementCode() +"--"+payElement.getPayElementDesc()%>"
	
<%}}}else{%>
data_arr[<%= counter%>][1] = ""
<%}%>



<%if(masEmp.getPayElement().getPayElementDesc()!=null){%>
data_arr[<%= counter%>][2] = "<%=masEmp.getPayElement().getPayElementDesc()%>"
<%}else {%>
data_arr[<%= counter%>][2] = ""
<%} if(masEmp.getPayAmount() != null){
	
%>
data_arr[<%= counter%>][3] = "<%=masEmp.getPayAmount()%>"
<%}else{%>
data_arr[<%= counter%>][3] = "0.0"
<%}%>
<%if(masEmp.getPayElement().getPayElementType()!= null){%>
data_arr[<%= counter%>][4] = "<%= masEmp.getPayElement().getPayElementType()%>"
<%} else {%>
data_arr[<%= counter%>][4] = ""
<%} if(masEmp.getStartDate() != null){%>
data_arr[<%= counter%>][5] = "<%= new SimpleDateFormat("dd/MM/yyyy").format(masEmp.getStartDate())%>"
<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>





<%if(masEmp.getStatus().equals("y")){%>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "Inactive"
<%}%>
 
<%
		     counter++;
}
		
%>
formName = "employeePayElements"

nonEditable = ['<%= EMPLOYEE_ID%>']
 
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	
	
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');

</script> <script type="text/javascript">





function populateElementType(obj)
{
		payElementId = obj.value;
		<%for(HrMasPayElement payElement : payElementsList){ %>
		
		if(<%=payElement.getId()%> == payElementId){
		document.employeePayElements.<%=PAY_ELEMENT_TYPE%>.value = '<%=payElement.getPayElementType()%>';
		
		if("<%=payElement.getBasicDependent()%>" == "y")
		{
		
		document.employeePayElements.<%=PAY_AMOUNT%>.value = (parseFloat('<%=payElement.getBasicMultiplier()%>')* basicPayValue)/100;
		//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("class","readOnly");
		//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("readonly","readonly");
		document.getElementById('basicDependantDiv').innerHTML = 'Basic Dependant ('+<%=payElement.getBasicMultiplier()%> +'% of Basic)';
		document.getElementById('basicDependantDiv').style.display = 'block';
		}
		else
		{
		document.employeePayElements.<%=PAY_AMOUNT%>.value = '';
		//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("class","");
		//document.employeePayElements.<%=PAY_AMOUNT%>.setAttribute("readonly","");
		document.getElementById('basicDependantDiv').innerHTML = '';
		document.getElementById('basicDependantDiv').style.display  = 'none';
		}
		
		}
		<%}%>
		
}
function removeMandatory()
	{
	document.getElementById('<%=EMPLOYEE_ID%>').setAttribute('validate','Employee Name,string,no');
	return true;
	}
	
function refreshPage()
{
document.location.href = 'resume?method=showCTCAnnexureJsp&resumeid=<%=resume.getId()%>';
}

function alertAndSubmit()
{


 x = confirm('Are you sure to update the CTC offered to the candidate !');
if(x == true){
submitForm('search','resume?method=updateCTC&<%=RequestConstants.RESUMEID%>=<%=resume.getId() %>');
}
else
{
return false;
}


}
<%if(map.get("preview")!=null)
{
%>
my = window.open("../Reports/ctcAnnexure.html","_blank","scrollbars=yes", "resizable=yes", "copyhistory=no", "width=600 "," height=900");
my.focus();
<%}%>

function checkCTC()
{
if(document.getElementById('<%=CTC%>').value == parseInt('<%=totalAmount.add(new BigDecimal(basic)) %>' ))
{
	if(confirm("Are you sure to send it for HR Head Approval")){
	submitForm('search','resume?method=sendForApproval&<%=RequestConstants.RESUMEID %>=<%=resume.getId() %>');
	}
	else
	{
		return false;
	}
}
else
{
	alert("Pay elements total value is not equal to CTC");
}

}
</script>