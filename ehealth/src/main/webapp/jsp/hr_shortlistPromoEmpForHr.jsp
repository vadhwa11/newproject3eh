<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.HrRequisitionFrPromotion"%>
<%@page import="jkt.hrms.recruitment.masters.business.ResourceRequisition"%>
<%@page import="jkt.hrms.recruitment.masters.business.HrReqPromStatus"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.recruitment.masters.business.RequestStatusMaster"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.CCLIST"%>
<%@page import="java.util.ArrayList"%>
<%@page import= "java.util.Map"%>
<%@page import= "java.util.List"%>
<%@page import= "jkt.erp.hrms.recruitment.masters.business.*"%>
<%@page import= "jkt.erp.masters.business.*"%>
<%@page import="jkt.erp.util.*" %>
<%@page import="java.util.HashMap" %>

<script type="text/javascript" src="/erp/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.datePicker.js"></script>
<script language="javascript">
var $j = jQuery.noConflict();
</script>


 <%
	Map map = null;
 	int designation_order=0;
	Map<String, Object> map2= new HashMap<String, Object>();
	List<HrReqPromStatus> shortListedEmpForHr = new ArrayList<HrReqPromStatus>();
	List<RequestStatusMaster> requestStatusMasterList = new ArrayList<RequestStatusMaster>();
	List<MasEmployeeDepartment> masDepartmentList = new ArrayList<MasEmployeeDepartment>();
	List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
	List<HrRequisitionFrPromotion> masEmployeeRequisionList = new ArrayList<HrRequisitionFrPromotion>();
	String flag="";
	
	if(request.getAttribute("map") != null)
	{
	map2 = (Map)request.getAttribute("map");
	}
	if(request.getAttribute("map") != null)
	{
	map = (Map)request.getAttribute("map");
	}

	
	if(map2.get("shortListedEmpForHr") != null)
	{
		shortListedEmpForHr = (List<HrReqPromStatus>)map2.get("shortListedEmpForHr");
	}
	if(map2.get("requestStatusMasterList") != null)
	{
		requestStatusMasterList = (List<RequestStatusMaster>)map2.get("requestStatusMasterList");
	}
	if(map2.get("masDepartmentList") != null)
	{
		masDepartmentList = (List<MasEmployeeDepartment>)map2.get("masDepartmentList");
	}
	
	if(map2.get("masEmployeeList") != null)
	{
		masEmployeeList = (List<MasEmployee>)map2.get("masEmployeeList");
	}
	if(map2.get("masEmployeeRequisionList") != null)
	{
		masEmployeeRequisionList = (List<HrRequisitionFrPromotion>)map2.get("masEmployeeRequisionList");
	}
	
	if(map.get("flag") != null)
	{
		flag = (String )map.get("flag");
	}
	
	List<ResourceRequisition> manPowerRequisitionList = (List)map.get("manPowerRequisitionList");
	int deptId=0;
	int empId=0;
	Date fromDate = null;
	Date toDate = null;
	if(map.get("deptId") != null){
		deptId = (Integer)map.get("deptId");
	}
	if(map.get("empId") != null){
		empId = (Integer)map.get("empId");
	}
	if(map.get("fromDate") != null){
		fromDate = (Date)map.get("fromDate");
	}
	if(map.get("toDate") != null){
		toDate = (Date)map.get("toDate");
	}
%>
<script type="text/javascript" src="/erp/jsp/js/balloontip.js">

/***********************************************
* Rich HTML Balloon Tooltip- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>
 <div class="titleBg">
 <h2>Shortlist Employee For Promotion</h2>
 </div>
 
 <div class="clear"></div>
 
 
 
 <form name="requisitionApproval" method="post">
	<div class="Block">

	<div class="clear"></div>

	<label>From Date </label>
	<%if(fromDate != null){ %>
	<input type="text" name="fromDate" value="<%=HMSUtil.convertDateToStringWithoutTime(fromDate) %>" validate="From Date,date,no" class="calDate" MAXLENGTH="15"  tabindex=1 onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');" />
	<%}else{ %>
	<input type="text" name="fromDate" value="" validate="From Date,date,no" class="calDate" MAXLENGTH="15"  tabindex=1 onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');" />
	<%} %>
	<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.requisitionApproval.<%=FROM_DATE_FOR_VALIDATION%>,event)"/> --%>
	
	<label>To Date </label>
	<%if(toDate != null){ %>
	<input name="toDate" type="text" class="calDate" MAXLENGTH="15" value="<%=HMSUtil.convertDateToStringWithoutTime(toDate) %>"  tabindex=1 onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');"  />
	<%}else{ %>
	<input name="toDate" type="text" class="calDate" MAXLENGTH="15" value=""  tabindex=1 onkeyup="mask(this.value,this,'2,5','/');" onblur="validateExpDate(this,'fromdate-pick');"  />
	<%} %>
 	<%-- <img src="/erp/jsp/images/cal.gif" width="16" height="16" class="calendar" border="0" validate="Pick a date" onClick="setdate('',document.requisitionApproval.<%=TO_DATE_FOR_VALIDATION%>,event)"/> --%>
    
 <%--    <label>Promo. ID </label> 
	<select name="promoId" validate="Promo Id,string,no" tabindex=1>
			<option value="0">Select</option>
			  <% 
				for (HrReqPromStatus  hrpStatus : shortListedEmpForHr){
				%>
			  <option value="<%=hrpStatus.getId ()%>"><%=hrpStatus.getId ()%></option>
			  <%}%>
			</select> --%>
	<div class="clear"></div>
	<label><span>*</span>Department:</label>
			<select name="deptId" validate="Department,string,yes" tabindex=1 " >
			<option value="0">Select</option>
			  <% 
				for (MasEmployeeDepartment  masDepartment : masDepartmentList){
					if(masDepartment.getId()== deptId){
				%>
			  <option value="<%=masDepartment.getId ()%>" selected="selected"><%=masDepartment.getEmpDeptName()%></option>
			  <%}else{%>
			    <option value="<%=masDepartment.getId ()%>" ><%=masDepartment.getEmpDeptName()%></option>
			  <%}} %>
			</select>

	<label>Employee</label>
			<select name="empId" validate="Employee,string,no" tabindex=1 ">
			<option value="0">Select</option>
			  <% 
				for (MasEmployee  masEmployee : masEmployeeList){
					if(masEmployeeRequisionList.size()>0){
						for(HrRequisitionFrPromotion hrRequisitionFrPromotion : masEmployeeRequisionList){
					if(masEmployee.getId()== hrRequisitionFrPromotion.getEmployee().getId()){
						if(masEmployee.getId().equals(empId)){
				%>
			  <option value="<%=masEmployee.getId ()%>" selected="selected"><%=masEmployee.getEmployeeName()%></option>
			  <%}else{ %>
			   <option value="<%=masEmployee.getId ()%>" ><%=masEmployee.getEmployeeName()%></option>
			  <%}}}}}%>
			</select>
<div class="clear"></div>
	<%-- <input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" /> 
	<input type="hidden" name="<%=EMPLOYEE_ID %>"  value="<%=employeeId%>" /> --%>
	<input name="save" type="button"  class="button" value="Search" onClick="submitForm('requisitionApproval','resume?method=showshortListEmpForHrApproval&flag=H')" />
	<!--  <input name="save" type="button" class="button" value="Back" onClick="javascript:history.back()"/>-->
	<div class="clear"></div>
	</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
 
 <form name="shortlistResume" method="post">
 
 	<div class="clear"></div>
 
 	<div class="clear"></div>
 	<div class="division"></div>
	<h4><u>Select Request :</u></h4>
	<div class="clear"></div>
	
	<%if(shortListedEmpForHr.size()!=0){ %>
	<table width="100%" cellspacing="0" cellpadding="0">
		<tr>
			<th>
				<input type="checkbox" name="allIds" value="yes" onClick="checkAll()" class="radioCheck"  />
			</th>
			<th>Promotion Id</th>
			<th>Employee Name</th>
		   <!--  <th>Employee Type</th> -->
			<th>Department Name</th>
			<th>Current Designation</th>
			<th>Promotion Designation</th>
			<!-- <th>Requisition</th> -->
			<th>Status</th>
		</tr> 	
 		<tbody>
 		<%
 			 int i = 0;
 			String klass = "";
 			for(HrReqPromStatus hrReqPromStatus : shortListedEmpForHr){
 				String id = "";
 		 		id = "id" + i;
 		 	
 			if(i%2 == 0)
 			{
 				klass= "even";
 			}
 			else
 			{
 				klass="odd";
 			}
 			String status = ""; 	  		
	  		
 		%>
 			<%-- <div id="balloon<%=i%>" class="balloonstyle">
			<label>Request Id</label> <label class="value"><%=manpowerRequest.getId()%></label>
			<label>Date</label><label class="value"> <%=manpowerRequest.getRequisitionDate()%></label>
			<label>Name of Initiator</label> <label class="value"><%=manpowerRequest.getInitiator().getFirstName() + " " +manpowerRequest.getInitiator().getLastName()%></label>
			<div class="clear"></div>
			<label>Employee Type</label><label class="value"><%=manpowerRequest.getEmployeeType().getEmpType()%></label>
			<label>Department</label> <label class="value"><%=manpowerRequest.getDepartment().getDepartmentName()%></label>
			<label>Desirable Exp</label> <label class="value"><%=expRange %></label>
			<label>Total No. Of Positions</label> <label class="value"><%=manpowerRequest.getTotalNoPosition()%></label>
			<div class="clear"></div>
			<label>Salary Range </label> <label class="value"><%=salaryRange%></label>
			<label>Deptt. Manpower Cost</label><label class="value"> <%=manpowerRequest.getTotalDepartmentCTC().intValue() %></label>
			<%if(manpowerRequest.getMarketCtc()!=null){%>
			<label>Current Mkt CTC</label><label class="value"><%=manpowerRequest.getMarketCtc()%></label>
			<label>Tentative Manpower Cost</label><label class="value"><%=manpowerRequest.getTotalDepartmentCTC().intValue()+ (manpowerRequest.getMarketCtc() * manpowerRequest.getTotalNoPosition())%>/-</label> 
			
			<%} %>
			
			</div>--%>
 		<tr class="<%=klass%>">
 			<td>

 				<input type="checkbox" name="<%= id %>" value="<%=hrReqPromStatus.getId()%>" onClick="unCheck(this)" class="radioCheck" />
 				<%-- <input name="desig_order" id="desig_order<%=i%>" type=hidden value='<%=manpowerRequest.getDesignation().getDesignationOrder()%>' /> --%>
 			</td>
 			<td><%=hrReqPromStatus.getId()%></a></td>
 			<td><%=hrReqPromStatus.getPromReq().getEmployee().getEmployeeName()%></a></td>
 			<%-- <td><a href="javascript:showRequisitionScreen(<%=manpowerRequest.getId()%>)" rel="balloon<%=i%>"><%=manpowerRequest.getEmployeeType().getEmpType() %></a></td> --%>
 			<td><%=hrReqPromStatus.getPromReq().getEmployee().getEmployeeDepartment().getEmpDeptName()%></a>
 				<input name="req_id<%=i%>"" id="req_id<%=i%>" type="hidden" value='<%=hrReqPromStatus.getPromReq().getRequisition().getId()%>' />
 				<input name="req_fr_promotion_id<%=i%>"" id="req_fr_promotion_id<%=i%>" type="hidden" value='<%=hrReqPromStatus.getPromReq().getId()%>' />
 			
 			</td>
 			<td><%=hrReqPromStatus.getPromReq().getEmployee().getRank().getRankName() %></a></td>
			<td><%=hrReqPromStatus.getPromReq().getRequisition().getDesignation().getRankName() %></a></td>
 			<%--  <td><a href="javascript:showRequisitionScreen(<%=hrReqPromStatus.getId()%>)" rel="balloon<%=i%>"><%=manpowerRequest.getDirectReq() %></a></td> --%>
 			<td><%=hrReqPromStatus.getPromStatus().getStatusDesc() %></a></td>
 		</tr>
 		<script>
 			document.getElementById('rb0').checked = 'checked';
 		</script>
 		<%
 			i++;}
 		%>
 		</tbody> 		
 		
 		 <input name="counter" id="counter" type="hidden" value=<%=i%> />
 		  <input name="flag" id="counter" type="hidden" value='<%=flag%>' />
 	</table>
 	
 	<div class="clear"></div>
	
	<label>Status</label>
	<select name="requestStatus" validate="Status,String,yes">
	<option value="">Select</option>
	<%--
	 <% for(RequestStatusMaster requestStatus : requestStatusMasterList){
	 	if( requestStatus.getId()!= 3){
	 
	 %>
		<option value= <%=requestStatus.getId()%>><%= requestStatus.getStatusDesc()%></option>
		<%} }%> --%>
		<option value= "Approved"><%= "Approved"%></option>
		<option value= "DisApproved"><%= "DisApproved"%></option>
		
	</select>
	
	<label>Remarks</label>	
	<textarea id="remraks" name="remraks" validate="Remraks,'',no" onkeydown="refreshLengthWithoutMeter1(this.id,250)" onkeyup="refreshLengthWithoutMeter(this.id,250)"></textarea>
	
	 	<div class="clear"></div>
	<input type="button" name="assignto" value="Submit" class="button" onClick="updatestatus()" >
 
	<input type="button" name="back" value="Back" class="button" onClick="history.back()" >
 	
 	<%}
	else{
	%>
	<h4>No ShortList Employee Are Present </h4>
	<%} %>
 	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 </form> 
 <script> 	
 	
 	function changeAssignedTo()
	{
	if(document.shortlistResume.assignedTo.value == "")
	{
	errorMsg += "First Select Any Authority Member. \n";
	return false;	
	}
	checkCCList();
	return true;
	}
	
	<%-- function checkCCList()
	{
	var myString = document.shortlistResume.<%=HrmsRequestConstants.CCLIST%>.value;
	var ccArray = myString.split(",");
	if(myString != null && myString!="")
	{
	for(var i=0;i<ccArray.length;i++)
		{
		if(!validateEmail(ccArray[i]))
			{
			errorMsg +="Please Enter the valid CC List. \n";
			return false;
			}
		}
	}
	} --%>
	
function unCheck(obj)
{
	if(obj.checked==false)
	{
	document.shortlistResume.allIds.checked=false;
	}
}


 function checkAll()
{
	var no = <%=shortListedEmpForHr.size()%>;

	for(j=0;j<=no;j++)
	{
		var obj = "document.shortlistResume." + "id" +j;
		obj=eval(obj);
		if(obj.disabled==true)
		{
		}
		else
		{
			if(document.shortlistResume.allIds.checked==true)
			{
			obj.checked=true;
			}
			else
			{
			obj.checked=false;
			}
		}
	}
} 


function chkCheckBoxesForApprove()
{
inps = document.getElementsByTagName('input');
flag=false;
for(i=0;i<inps.length;i++)
{
if(inps[i].type == 'checkbox' && inps[i].name != "allIds")
{
if(inps[i].checked)
{
name = 'status' + i;
flag=true;
	
break;
}
}
}
if(!flag)
{
errorMsg +="Please select one of the candidate.";
return false;
}
return true;
}
function getEmp(id,i){
	//alert(i);
	var order = document.getElementById("desig_order"+i).value;
	document.getElementById('desigOrder').value =order;
	//alert(i + "     "+order+"         "+document.getElementById('desigOrder').value);
	var url ='/erp/erp/resume?method=showShortListEmpForPromo&flag=s&id='+id
	submitForm('shortlistResume',url);
	
}
function updatestatus()
{
val = chkCheckBoxesForApprove();
if(val==true){
submitForm('shortlistResume','resume?method=updateEmpPromoStatus')
}else{
	
	alert("Please select one of the Employee.")
}
}

 </script>