<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.ProcedureDetails"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<%@page import="java.math.BigDecimal"%><script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />

<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript"> 
// var csrfTokenName='<csrf:tokenname />';
// var csrfTokenValue='<csrf:tokenvalue />';
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';
</script>

 <script type="text/javascript" language="javascript"  src="/hms/jsp/js/jquery.min.js"></script>
<%
	Map map = new HashMap();
	Box box = HMSUtil.getBox(request);
	int itemId=0;
	int rowVal=0;
	String userName = "";
	int visitId=0;
	int hinId=0;
	int referralDept=0;
	int referralHospital=0;
	int referralDistrict=0;
	int procedureDetailsId=0;
	String referralType="NA";
	String deptNameforExternal="NA";
	List<ProcedureDetails> procedureDetails = new ArrayList<ProcedureDetails>();
	
	
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	
	}

	if(map.get("visitId") != null){
		visitId = (Integer)map.get("visitId");
		
	}
	if(map.get("procedureDetailsId") != null){
		procedureDetailsId = (Integer)map.get("procedureDetailsId");
		
	}
	if(map.get("hinId") != null){
		hinId = (Integer)map.get("hinId");
		
	}
	if(map.get("referralHospital") != null){
		referralHospital = (Integer)map.get("referralHospital");
		
	}
	if(map.get("referralDept") != null){
		referralDept = (Integer)map.get("referralDept");
		
	}
	if(map.get("deptNameforExternal") != null){
		deptNameforExternal = (String)map.get("deptNameforExternal");
		
	}
	String dateOfAdmission=null;
	if(map.get("dateOfAdmission") != null){
		dateOfAdmission = (String)map.get("dateOfAdmission");
		
	}
	if(map.get("userName") != null){
		userName = (String)map.get("userName");
		
	}
	

	List<StoreItemBatchStock>batchList=new ArrayList<StoreItemBatchStock>();
	if(map.get("batchList")!=null){
		batchList=(List<StoreItemBatchStock>)map.get("batchList");
	}
	
	
	String message="";
	int dmaHeaderId=0;
    int qtyPrescription=0;
	if (map.get("procedureDetails")!=null)
		procedureDetails = (List<ProcedureDetails>)map.get("procedureDetails");

	if (map.get("dmaHeaderId")!=null)
		dmaHeaderId = (Integer)map.get("dmaHeaderId");
	else
		dmaHeaderId =box.getInt("dmaHeaderId");
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTimeWithoutSc");
	
	%>

<script language="JavaScript">
	<% 
	if (!message.equals("")) { %>
		window.opener.document.getElementById('dmaHeaderId').value='<%=dmaHeaderId%>';
		self.close();
	<% } %>
	</script>



<script type="text/javascript">



	 function cancelForm()
	{
	    window.close();
	  
   	}
	 

</script>
<form name="issueProcedure" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="hospitalName" id="hospitalName" value="<%=deptNameforExternal%>">
<input type="hidden" name="userName" id="userName" value="<%=userName %>">
<input type="hidden" name="hospitalId" id="hospitalId" value="<%=referralHospital %>">
<input type="hidden" name="departmentId" id="departmentId" value="<%=referralDept %>">
<input type="hidden" name="admissionDate" id="admissionDate" value="<%=dateOfAdmission %>">
<input type="hidden" name="refereddoctor" id="refereddoctor" value="">
<div class="titleBg">
<h2>Procedure Details </h2>
</div>
<div class="Clear"></div>
<div class="Block">
<label>Procedure Name</label>
<label class="valueAuto">&nbsp;<%=box.getString("procedureName")%></label>
<label>Frequency </label>
<label class="valueAuto">&nbsp;<%=box.getString("frequencyName")%></label>
<label>No Of Days </label>
<label class="valueAuto">&nbsp;<%=box.getString("noOfDays")%></label>
<%
String AppointmentFlag="n";
int TotalRecordsForSameDay=0;
int nTotalProcedure =box.getInt("nTotalProcedure");
int frequencyCount = box.getInt("frequencyCount");
String currentRecordsDate ="";
String sd1="";
String sd2="";
for(ProcedureDetails listA : procedureDetails)
  					{
  					Date d1= new Date();
  					Date d2= new Date();
  					sd1 = HMSUtil.convertDateToStringWithoutTime(d1);
  					sd2 = HMSUtil.convertDateToStringWithoutTime(listA.getAppointmentDate()!=null?listA.getAppointmentDate():d2);
  					currentRecordsDate = HMSUtil.convertDateToStringWithoutTime(listA.getAppointmentDate()!=null?listA.getAppointmentDate():d2);
  					
  					if(sd1.equalsIgnoreCase(sd2))
  					{
  						TotalRecordsForSameDay++;
  					}
  					}

%>
<%
//out.print("frequencyCount="+frequencyCount);
//out.print("TotalRecordsForSameDay="+TotalRecordsForSameDay);
  if(frequencyCount == TotalRecordsForSameDay && procedureDetails.size() != nTotalProcedure && sd1.equalsIgnoreCase(currentRecordsDate) )
  {
	   AppointmentFlag="y";
	  %>
	  	<label>Next Appointment Date </label>
		<input	type="text" name="appDate" id="appDate" validate="Appointment Date,string,yes" value="" class="date" readonly="readonly" MAXLENGTH="50"  />
		<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
		class="calender"	onClick="setdate('<%=date %>',document.issueProcedure.appDate,event)" /> 
	  <%
  }

%>


</div>
<div class="Clear paddingTop15"></div>

<input type="hidden" name="storeFyDocumentNoId" id="storeFyDocumentNoId" value="" />
<input type="hidden" name="procedureDetailsId" id="procedureDetailsId" value="procedureDetailsId" />
<input type="hidden" name="nTotalProcedure" id="nTotalProcedure" value="<%=box.getInt("nTotalProcedure")%>" />
<table width="200" colspan="7" id="indentDetails" cellpadding="0" cellspacing="0">

<thead>
<tr>
<th width="10%">Sl No</th>
<th width="13%">OP Remarks</th>
<th width="10%">Appointment Date</th>
<th width="10%">Procedure Date/Time</th>
<th width="13%">Nursing Remarks</th>
<th width="13%">Action</th>
</tr>

	</thead>
	<tbody>
		<%
  					int i=1;
  					int count=0;
  				for(ProcedureDetails listA : procedureDetails)
  					{
 			%>
		<tr>
			<td>
			<input type="text" id ="counter<%=i %>" name="counter<%= i%>" size="10" readonly="readonly" value="<%=i %>" /></td>
			<td><input type="text" id ="opremarks<%=i %>" name="opremarks<%= i%>" size="30" readonly="readonly" value="<%=listA.getRemarks()!=null?listA.getRemarks():"" %>" /></td>
			<td><input type="text" id="appointmentDate<%=i %>" name="appointmentDate<%=i %>"	size="18" readonly="readonly" value="<%=(listA.getAppointmentDate()!=null? HMSUtil.convertDateToStringWithoutTime(listA.getAppointmentDate()): "") %>" /></td>
			<td><input type="text" id="procedureDate<%=i %>" name="procedureDate<%=i %>"	size="18" readonly="readonly" value="<%=(listA.getProcedureDate()!=null? HMSUtil.convertDateToStringWithoutTime(listA.getProcedureDate()): "") %>   <%=listA.getProcedureTime()!=null? listA.getProcedureTime(): "" %>" /></td>
			
			
			<td><input type="text" name="remarks<%=listA.getId()%>" id="remarks<%=listA.getId()%>" value="<%=listA.getNursingRemarks()!=null?listA.getNursingRemarks():"" %>" tabindex="1" size="30"	 />
			<%
			
			if(listA.getStatus().equalsIgnoreCase("y"))
			{
				%>
					<td><input type="text" id ="status<%=i %>" name="status<%= i%>" size="30" readonly="readonly" value="<%=!listA.getStatus().equalsIgnoreCase("n")?"Completed":"Not Completed"%>" /></td>
				
				<%
			}
			else
			{
				if(sd1.equalsIgnoreCase(currentRecordsDate)){
				%>
				
					<td><input type="button" class="button" readonly="readonly" name="save<%=listA.getId()%>" id="save<%=listA.getId()%>" value="Save" onclick="saveNursingCareValues(<%=listA.getId() %>);" />
				<%
				}
				else
				{
					%>
					<td><input type="text" id ="status<%=i %>" name="status<%= i%>" size="30" readonly="readonly" value="Wait for next Appontment date" /></td>
				
					<%
				}
			}
			
			%>
			<input type="hidden" name="amount<%=i %>" id="amount<%= i%>" value="" /></td>
			
			</tr>
				<%
  	 	i++;
  	   }
  	 %>
   </tbody>
</table>
	<input type="hidden" name="hdb" value="<%=i %>" id="hdb" />
<script>
  
  </script>

<div id="edited"></div>
  <div class="clear"></div>
    <div class="division"></div>
      <div class="clear"></div>
 <%if(batchList.size()>0) {%>     
 <div  class="paddingTop25">
 	<label>Batch</label>
 	<select id="itemBatchStock" onchange="showClosingStock(this.value)">
		<option value="0">Select</option>
		<%for(StoreItemBatchStock str:batchList){ %>
			<option value="<%=str.getBatchNo() %>:<%=str.getId()%>:<%=str.getClosingStock()%>"><%=str.getBatchNo() %></option>
		<%} %>
	</select>
	<label>Available Stock</label><input type="text" readonly="readonly" id="availableStock" name="availableStock"/>
	<div class="clear"></div>
	<input type="hidden" value="1" id="issueStock" name="issueStock"/>
 </div>
 <%}%>
 <div class="clear"></div>

									
<%-- <input name="Submit11" id="Submit11" class="buttonAuto" type="button" align="right"	value="Refer Back"
				 onclick="fnNurseOpdSubmitPatientNew(<%=hinId%>,<%=visitId%>,<%=procedureDetailsId%>);" /> --%>
  <!-- <input id="save"	type="button" name="save" value="Save" tabindex="1"	class="button"	onclick="if(validatePage(issueInjection)){submitForm('issueInjection','/hms/hms/opd?method=issueInjectionFromReception');}" /> -->
  <input type="button" name="cancel" id="addbutton" value="Close" class="button" onClick="cancelForm();" accesskey="a" />
    <div class="clear"></div>
    <div class="division"></div>
    <div class="clear"></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />	
</form>
<script type="text/javascript">
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date1=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date1.length()<2){
		date1="0"+date1;
	}
%>
serverdate = '<%=date1+"/"+month1+"/"+year1%>'

function saveNursingCare(Id)
{
	
	var b = true;
	if(document.getElementById('cDate'+Id).value == "")
	{
	  alert("Please enter the Procedure date.");
	  b=false;
	}
	if(document.getElementById('cTime'+Id).value == "")
	{
	  alert("Please enter the Procedure time.");
	  b=false;
	}
	
	if(!b)
		{
			saveNursingCareValues(Id);
		}
}

function showClosingStock(val){
	if(val!=0){
		var str=val.split(":");
		var stockId=str[1];
		var closingStock=str[2];
		document.getElementById("availableStock").value=closingStock;
	}else{
		document.getElementById("availableStock").value="";
	}
}
function saveNursingCareValues(Id)
{
		var AppointmentFlag = '<%out.print(AppointmentFlag);%>';
	    var AppointmentDate = $("#appDate").val();
	    var remarks = document.getElementById('remarks'+Id).value;
	 	var data = "Id="+Id+"&remarks="+remarks+"&AppointmentFlag="+AppointmentFlag+"&AppointmentDate="+AppointmentDate;
	    var url = "opd?method=saveNursingCare&"+csrfTokenName+"="+csrfTokenValue;
	    
	    if(AppointmentFlag == 'y')
	    	{
	    		if($("#appDate").val() == "")
	    			{
	    				alert("Please enter next appointment date");
	    				return;
	    			}
	    	}
	    var len=0;
	    if(undefined !=document.getElementById("itemBatchStock")){
	 	 len=document.getElementById("itemBatchStock").length;
	    }
	 	var issueStock=0;
	 	var itemBatchStock=0;
	 	if(len>0){
	 		if(document.getElementById("itemBatchStock").value==0){
	 			alert("please select batch");
	 			document.getElementById("itemBatchStock").focus();
	 			return;
	 		}
	 		if(document.getElementById("issueStock").value==""){
	 			alert("please enter issue stock");
	 			document.getElementById("issueStock").focus();
	 			return;
	 		}
	 		itemBatchStock=document.getElementById("itemBatchStock").value;
	 		issueStock=document.getElementById("issueStock").value;
	 	}
	 	data=data+"&issueStock="+issueStock+"&batchNo="+itemBatchStock;
	    jQuery(function ($) {
	    	$.ajax({
				type:"POST",
				url: url,
				data: data,	 							
				cache: false,
				success: function(msg)
				{									 
					$("#save"+Id).hide();
					alert("Records Saved Sucessfully");
					window.opener.location = window.opener.location;
					window.close();
				},
				error: function(msg)
				{					
					alert("An error has occurred while contacting the server");
					$("#save"+Id).hide();
				}
			});
	    }); 
}


 function cancelForm()
{
	 window.opener.location = window.opener.location;
	 window.close();
	 
}

function fnNurseOpdSubmitPatientNew(hinId,visitId,procedureDetailsId){
	
	

	/* if (confirm("Do you want to referback the Patient to OPD !")) {
		submitForm('issueProcedure',
				'opd?method=submitNursingDetails&hinId='+hinId+'&visitId='+visitId); */
		
		  if (confirm("Do you want to referback the Patient to OPD !")) {
				submitForm('issueProcedure',
						'opd?method=referBackNursingPatientToOpd&hinId='+hinId+'&visitId='+visitId);
				   var Id=procedureDetailsId;
			       saveNursingCareValues(Id);			
		           window.close();

	}



}

</script>