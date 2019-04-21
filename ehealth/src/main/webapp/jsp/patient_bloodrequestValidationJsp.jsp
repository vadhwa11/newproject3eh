
<%@page import="jkt.hms.masters.business.DgMasCollection"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryHeader"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryDetail"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>

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
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>

<%
	    Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<BloodRequestEntryHeader> requestheaderList=new ArrayList<BloodRequestEntryHeader>();
		
		 List<BloodRequestEntryDetail> requestdetailList=new ArrayList<BloodRequestEntryDetail>();
		 
		 List<MasBloodGroup> bloodGroupList= new ArrayList<MasBloodGroup>();
		
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<BloodSampleCollection> patientDetailList = new ArrayList<BloodSampleCollection>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String userName = "";
		int userId=0;
		String message = "";
		
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		if(map.get("requestheaderList") != null){
			requestheaderList= (List<BloodRequestEntryHeader>)map.get("requestheaderList");
		}
		
		if(map.get("requestdetailList") != null){
			requestdetailList= (List<BloodRequestEntryDetail>)map.get("requestdetailList");
		}
		
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("userName") != null){
			userName= (String)map.get("userName");
		}
		if(map.get("userId") != null){
			userId= (Integer)map.get("userId");
		}
		
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(patientMap.get("patientDetailList") != null){
			patientDetailList= (List<BloodSampleCollection>)patientMap.get("patientDetailList");
		}
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(map.get("bloodGroupList") != null){
			bloodGroupList= (List<MasBloodGroup>)map.get("bloodGroupList");
		}
		
		/* if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		} */
		if(detailsMap.get("departmentList") != null){
			departmentList = (List<MasDepartment>)detailsMap.get("departmentList");
			}
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		}
		 DgMasCollection conatiner = new DgMasCollection();
		if(map.get("conatiner") != null){
			conatiner= (DgMasCollection)map.get("conatiner");
		}
		int containerId=0;
		String containerName="";
		if(null !=conatiner && null !=conatiner.getCollectionName())
		{
			containerName=conatiner.getCollectionName();
		}
		if(null !=conatiner && null !=conatiner.getCollectionName())
		{
			containerId=conatiner.getId();
		}
		
		
		String ipNumber="";
		String WardNumber="";
		String doctorName="";
		String Uhid="";
		String gender="";
		
		String mobNo="";
		String name="";
		String requestIdNum="";
		Date requestDate=null;
		Date requestedDate=null;
		String requestedBy="";
		String componentReq="";
		int quantity=0;
		String bloodGroup="";
		String bedNum="";
		int bldReqEntyHdId=0;
		String no_of_bottol="";
		int bloodGroupId=0;
		int hindId=0;
		
		
		if(null !=requestdetailList && requestdetailList.size()>0){
			for(BloodRequestEntryDetail breh:requestdetailList){
				bldReqEntyHdId=breh.getRequest().getId();
				
				no_of_bottol=breh.getRequest().getNoBottles();
				if(null !=breh.getRequest().getInpatient()){
					
				ipNumber=breh.getRequest().getInpatient().getAdNo();
				WardNumber=breh.getRequest().getInpatient().getAdWard().getDepartmentName();
				doctorName=breh.getRequest().getInpatient().getDoctor().getEmployeeName();
				 if(breh.getRequest().getInpatient().getBed() !=null)
				bedNum=breh.getRequest().getInpatient().getBed().getBedNo(); 
				
				}
				requestIdNum=breh.getRequest().getOrderNo();
				Uhid=breh.getRequest().getInpatient().getHin().getHinNo();
				
				hindId=breh.getRequest().getInpatient().getHin().getId();
				
				if(null !=breh.getRequest().getInpatient().getHin().getSex())
				gender=breh.getRequest().getInpatient().getHin().getSex().getAdministrativeSexName();
				
				if(null !=breh.getRequest().getInpatient().getHin().getMobileNumber())
				mobNo=breh.getRequest().getInpatient().getHin().getMobileNumber();
				
				requestDate=breh.getRequest().getOrderDate();
				
				name=breh.getRequest().getInpatient().getHin().getPFirstName();
				if(null !=breh.getRequest().getBloodGroup()){
					bloodGroupId=breh.getRequest().getBloodGroup().getId();
				bloodGroup=breh.getRequest().getBloodGroup().getBloodGroupName();
				}
				
			}
		}
		
	 %>
	 <%Date bldRequestDate=null;
String componentName="";
	String sdate="";
		if(null !=requestdetailList && requestdetailList.size()>0){
			
			
			for(BloodRequestEntryDetail bllodrequestDetai:requestdetailList){
			componentReq=bllodrequestDetai.getComponent().getComponentName();
			 quantity=bllodrequestDetai.getQty();
			 bldRequestDate=bllodrequestDetai.getReqDate();
			 if(null !=requestDate)
			 sdate= HMSUtil.convertDateToStringTypeDateOnly(requestDate);
			 componentName=bllodrequestDetai.getComponent().getComponentName();
			}
			} %>

<script type="text/javascript">
	function check(){
		var FDate = document.patientSearch.<%= FROM_DATE%>.value;
		var TDate = document.patientSearch.<%= TO_DATE %>.value;
		
		if (FDate == '' || TDate == '') {
		alert("Please enter both Date....");
		return false;
	   }

		var toDate =new Date(TDate.substring(6),(TDate.substring(3,5) - 1) ,TDate.substring(0,2))
		var fromDate =new Date(FDate.substring(6),(FDate.substring(3,5) - 1) ,FDate.substring(0,2))
	    if(fromDate > toDate)
		{
			alert("Please ensure that To Date is greater than or equal to the From Date.");
			document.calldate.next_day.focus();
			return false;
		}
	}
</script>
<div class="Block">
<form name="validateBldRequest" action="" method="post">

<div class="titleBg">
<h2>Sample Collection</h2>
</div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label> UHID</label> 
<input type="text" readonly="readonly" name="uhidNo" value="<%=Uhid%>"/>
<input type="hidden" readonly="readonly" name="hinId" value="<%=hindId%>"/>


<input type="hidden"  name="requestHeaderId" value="<%=bldReqEntyHdId%>"/>
<label>Name</label> 
<input type="text"  readonly="readonly"name="name" value="<%=name%>"/>

<label>Gender</label> 
<input type="text" name="gender" value="<%=gender%>" readonly="readonly"/>

<div class="clear"></div>
<label>IP Number </label> <input type="text" name="ipnumber" value="<%=ipNumber %>"
	MAXLENGTH="15" readonly="readonly"/> 
	
	<label>Blood Group</label> 
	<input type="text" name="bloodGroup" value="<%=bloodGroup %>" MAXLENGTH="15" readonly="readonly" /> 
	
	
	<label>Moble Number</label> 
	<input type="text" name="mobileNumber" value="<%=mobNo%>" MAXLENGTH="13" readonly="readonly"/> 


<div class="clear"></div>
<label>Unit</label>
 <input type="text" name="Unit" value="<%=no_of_bottol %>" MAXLENGTH="2" readonly="readonly"/> 
 
 <label>Ward</label>
 <input type="text" name="ward" value="<%=WardNumber %>" MAXLENGTH="15" readonly="readonly" /> 
 
 <label>Bed number</label>
 <input type="text" name="bedNum" value="<%=bedNum %>" MAXLENGTH="15" readonly="readonly" /> 
 
	<div class="clear"></div>
	
	<label>Doctor Name</label>
 <input type="text" name="doctorName" value="<%=doctorName %>" MAXLENGTH="15" readonly="readonly" /> 
	<div class="clear"></div>
	<h4>Request Details</h4>
	
	<label> Request Id Number</label> 
<input type="text" name="RequestId" value="<%=requestIdNum %>" readonly="readonly"/>

<label>Request Date</label> 
<input type="text" name="requestDate" value="<%=sdate %>" readonly="readonly"/>

<label>Request By</label> 
<input type="text" name="requestBy" value="<%=doctorName%>"/>

<div class="clear"></div>
<label>Component requested </label> <input type="text" name="ipnumber" value="<%=componentReq %>"
	MAXLENGTH="15" /> 
	
	<label>Quantity requested (In ml)</label> 
	<input type="text" name="bloodGroup" value="<%=quantity %>" MAXLENGTH="15" readonly="readonly"/> 
	

<div class="clear"></div>

<h4>Sample Details</h4>
<label>Sample Validation Date</label>
 <input type="text" name="validationDate" value="<%=currentDate %>" MAXLENGTH="15" readonly="readonly" /> 
 
 <label>Sample Validation Time</label>
 <input type="text" name="validationTime" value="<%=time %>" MAXLENGTH="15" readonly="readonly"/> 
 
 <label>Validated By</label>
 <input type="text" name="validatedBy" value="<%=userName %>" MAXLENGTH="100" /> 
  <input type="hidden" name="validatedById" value="<%=userId %>" MAXLENGTH="10" /> 
 
 <input type="hidden" id="acceptRejectId" name="acceptReject" />
	<div class="clear"></div>
	
	<label>Blood Group Validated</label>
 <select id="validatebloodGroupId" name="validatebloodGroupId" validation="Blood Group,string,yes"  > 
 <%if(null !=bloodGroupList && bloodGroupList.size()>0) {
 for(MasBloodGroup bldGroup:bloodGroupList){if(bloodGroupId==bldGroup.getId())%>
  <option value="<%=bldGroup.getId()%>" selected="selected"><%=bldGroup.getBloodGroupName() %></option>
<%}} %>
 </select>
	<div class="clear"></div>
<div class="clear"></div>

<input type="hidden" name="containerId" value="<%=containerId %>" MAXLENGTH="15" readonly="readonly"/> 

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>



		
<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th>Component Name</th>
			<th>Quantity(ml)</th>
			<th>Required On Date</th>
			<th>Container</th>
			<th>Accepted</th>
			<th>Rejected</th>
			
			
		</tr>
	</thead>
	<tbody>
	
	
		<tr>
			 <td><%=componentName %></td>
			<td><%=quantity %></td>
			<%if(null !=bldRequestDate){ %>
			<td><%=HMSUtil.convertDateToStringTypeDateOnly(bldRequestDate) %></td>
			<%}else{ %>
			<td></td>
			<%} %>
			<td><%=containerName%></td>
		 <td>
			<input type="radio" id="bldAcceptId" name="blodvalidate" value="y" class="button"  onclick="AccetValue()"
	tabindex=1 /></td>
	<td>
			<input type="radio" id="bldAcceptIdr" name="blodvalidate" value="n" class="button" onclick="AccetValuer()"
	tabindex=1 /></td> 
		</tr>
		
	</tbody>
</table>

</div>

<div class="clear"></div>
<div class="clear"></div>
<label>Remarks</label><input type="text" name="remark" value=""  tabindex=1 />
<div class="clear"></div>
<input type="button" name="Save" value="Save" class="button" 
tabindex=1  onclick="if(checkFillField()){submitForm('validateBldRequest','/hms/hms/bloodBank?method=validatePatientBloodRequest')}"/>

<input type="button" name="Reset" class="button" value="Reset" tabindex=1 />



</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	
<script type="text/javascript">
function AccetValue(){
	
	var Rvalue=document.getElementById('bldAcceptId').value;
	
	document.getElementById('acceptRejectId').value=Rvalue;
}
function AccetValuer(){
	
	var Rvalue=document.getElementById('bldAcceptIdr').value;
	
	document.getElementById('acceptRejectId').value=Rvalue;
}

function checkFillField(){
	
	var issuesStatus=document.getElementById('acceptRejectId').value;
	
	
	if(issuesStatus==''){
		alert('Select Accept or Reject option');
		return false;
	}
	else{
		
		return true;
	}
}

function populateBloodRequestValidation(Id){
	
	 // new Ajax.Request('bloodBank?method=resultEntryFormJsp&Id='+Id, {});
	window.location.href = 'bloodBank?method=bloodRequestValidationJsp&bloodrequestHeaderId='+Id+'&'+csrfTokenName+'='+csrfTokenValue; 
} 

</script>
</div>
