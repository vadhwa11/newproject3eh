<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
		function ismaxlength(obj){
		var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
		if (obj.getAttribute && obj.value.length>mlength)
		obj.value=obj.value.substring(0,mlength)
		}
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(getDate.length()<2){
			getDate="0"+getDate;
		}
			
	%>
		serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>
<%
   
		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
	

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	 
	String currentTime = (String)utilMap.get("currentTime");
	
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	 List patientDetailList = new ArrayList();
	 List departmentList = new ArrayList();
	 
			
	if(map.get("patientDetailList") != null){
		
		patientDetailList=(List)map.get("patientDetailList");
		
	}
	if(map.get("departmentList") != null){
			
		departmentList=(List)map.get("departmentList");
			
		}
	OtBooking patient=(OtBooking)patientDetailList.get(0);
	List<OtSpecimenDispatchEntry> otSpecimenDispatchEntryList = new ArrayList<OtSpecimenDispatchEntry>();
	if(map.get("otSpecimenDispatchEntryList") != null){
		otSpecimenDispatchEntryList=(List<OtSpecimenDispatchEntry>)map.get("otSpecimenDispatchEntryList");
	}	
	List<MasEmployee> empByList = new ArrayList<MasEmployee>();
	if(map.get("empByList") != null){
		empByList=(List<MasEmployee>)map.get("empByList");
	}	
	List<MasEmployee> empRevList = new ArrayList<MasEmployee>();
	if(map.get("empRevList") != null){
		empRevList=(List<MasEmployee>)map.get("empRevList");
	}	
	if(otSpecimenDispatchEntryList.size() > 0 && otSpecimenDispatchEntryList!= null){
		

			for (Iterator iter = otSpecimenDispatchEntryList.iterator(); iter.hasNext();) {
				OtSpecimenDispatchEntry otSpecimenDispatchEntry = (OtSpecimenDispatchEntry) iter.next();
	
		

		
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	String patientName="";
	if(otSpecimenDispatchEntry.getHin().getPFirstName()!= null){
		patientName=otSpecimenDispatchEntry.getHin().getPFirstName();
	}
	if(otSpecimenDispatchEntry.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+otSpecimenDispatchEntry.getHin().getPMiddleName();
	}
	if(otSpecimenDispatchEntry.getHin().getPLastName()!= null){
		patientName=patientName+" "+otSpecimenDispatchEntry.getHin().getPLastName();
	}
	String servicePersonName="";
	if(otSpecimenDispatchEntry.getHin().getSFirstName()!= null){
		servicePersonName=otSpecimenDispatchEntry.getHin().getSFirstName();
	}
	if(otSpecimenDispatchEntry.getHin().getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+otSpecimenDispatchEntry.getHin().getSMiddleName();
	}
	if(otSpecimenDispatchEntry.getHin().getSLastName()!= null){
		servicePersonName=servicePersonName+" "+otSpecimenDispatchEntry.getHin().getSLastName();
	}
	
%>
<form name="specimenDispatchEntry" action="" method="post">

<div class="titleBg">
<h2>Specimen Dispatch Entry Entry</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Entry No</label> <label class="value"><%=otSpecimenDispatchEntry.getEntryNo() %></label>
<input type="hidden" value="<%=otSpecimenDispatchEntry.getEntryNo() %>"
	name="entryNo" /> <label>Date</label> <label class="value"><%=HMSUtil.changeDateToddMMyyyy(otSpecimenDispatchEntry.getOtSpecimenDispatchEntryDate()) %></label>
<input type="hidden"
	value="<%=HMSUtil.changeDateToddMMyyyy(otSpecimenDispatchEntry.getOtSpecimenDispatchEntryDate()) %>"
	name="dateOfDispatch" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<!--Block One Starts-->

<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>HIN</label> <%if(otSpecimenDispatchEntry.getHin().getHinNo()!= null){ %>
<label class="value"><%=otSpecimenDispatchEntry.getHin().getHinNo() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Patient
Name. </label> <%if(patientName!= null){ %> <label class="value"><%=patientName %>
</label> <%}else{ %> <label class="value">- </label> <%} %> <label>Age</label> <%if(otSpecimenDispatchEntry.getHin().getAge()!= null){ %>
<label class="value"><%=otSpecimenDispatchEntry.getHin().getAge() %></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>

<label>Patient Status </label> <%if(otSpecimenDispatchEntry.getHin().getPatientStatus() != null){ %>
<label class="value"><%=otSpecimenDispatchEntry.getHin().getPatientStatus() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Reg.Date </label> <%if(otSpecimenDispatchEntry.getHin().getRegDate()!= null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(otSpecimenDispatchEntry.getHin().getRegDate()) %></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<label>Tissue/Organ</label> <input name="tissueOrgan" class="readOnly"
	readonly="readonly" type="text" tabindex="1" size="43" maxlength="50"
	validate="Tissue,string,no"
	value="<%=otSpecimenDispatchEntry.getTissueOrgan() %>" /> <label
	class=valueNoWidth> Specimen dispatched by</label> <input name="empBy"
	id="empBy" class="readOnly" readonly="readonly" type="text"
	tabindex="1" size="43" maxlength="50"
	validate="Specimen dispatched by,string,no"
	value="<%=otSpecimenDispatchEntry.getSpecimenDispatchedBy().getFirstName()+" "+ otSpecimenDispatchEntry.getSpecimenDispatchedBy().getMiddleName()+" "+otSpecimenDispatchEntry.getSpecimenDispatchedBy().getLastName()%>" />

<label>Clinical Notes</label> <input name="clinicalNotes"
	class="readOnly" readonly="readonly" type="text" tabindex="2"
	maxlength="50" validate="Clinical Notes,string,no"
	value="<%=otSpecimenDispatchEntry.getClinicalNotes() %>" />
<div class="clear"></div>
<label>Time of dispatch</label> <input name="timeOfDispatch"
	class="readOnly" readonly="readonly" type="text" tabindex="10"
	maxlength="8" validate="Time,string,no"
	value="<%=otSpecimenDispatchEntry.getTimeOfDispatch() %>" /> <label>Examination
required</label> <input name="examinationRequired" class="readOnly"
	readonly="readonly" type="text" tabindex="10" maxlength="50"
	validate="Examination Required,string,no"
	value="<%=otSpecimenDispatchEntry.getExaminationRequired() %>" /> <label>Specimen
received by</label> <input name="empRev" id="empRev" class="readOnly"
	readonly="readonly" type="text" tabindex="10" maxlength="50"
	validate="Specimen Dispatch Received,string,no"
	value="<%=otSpecimenDispatchEntry.getSpecimenReceivedBy().getFirstName()+" "+otSpecimenDispatchEntry.getSpecimenReceivedBy().getMiddleName()+" "+otSpecimenDispatchEntry.getSpecimenReceivedBy().getLastName() %>" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<div class="clear"></div>

<!--  <input type="button" name="Update"  class="button" value="Update" onclick="submitForm ('specimenDispatchEntry','ot?method=updateOtSpecimenDispatchEntry')"/>-->
<input type="button" name="Back" class="button" value="Back"
	onclick="submitForm ('specimenDispatchEntry','ot?method=searchOtSpecimenDispatchEntry')" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<label>Changed By</label> <label class="value"><%=userName %></label> <label>Changed
Date</label> <label class="value"><%=currentDate %></label> <label>Changed
Time</label> <label class="value"><%=currentTime %></label> <input
	name="userName" id="userName" type="hidden" value="<%=userName %>" />
<input name="hinId" type="hidden"
	value="<%=otSpecimenDispatchEntry.getHin().getId()%>" /> <input
	name="departmentId" type="hidden"
	value="<%=otSpecimenDispatchEntry.getDepartment().getId()%>" /> <input
	name="visitId" type="hidden"
	value="<%=otSpecimenDispatchEntry.getVisit().getId()%>" /> <input
	type="hidden" name="orderNo" value="<%=patient.getOrderNo() %>" /> <input
	name="hospitalId" type="hidden" value="<%=hospitalId%>" /> <input
	name="changedDate" type="hidden" value="<%=currentDate %>" /> <input
	name="changedTime" type="hidden" value="<%=currentTime %>" /> <input
	name="specimenId" type="hidden"
	value="<%=otSpecimenDispatchEntry.getId() %>" /></div>
<%} }%>
 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>
</div>

