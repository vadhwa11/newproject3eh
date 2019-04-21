<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	
<script type="text/javascript">

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showSpecimenDispatchEntry";
  obj.submit();
}
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(Calendar.YEAR);
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
        int hospitalId=0;
        String entryNo="";
        String userName = "";
        String patientName="";
		Map map = new HashMap();
		
	 List patientDetailList = new ArrayList();
	 List departmentList = new ArrayList();
	 List<OtSpecimenDispatchEntry> otSpecimenDispatchEntryList = new ArrayList<OtSpecimenDispatchEntry>();
	 List<MasEmployee> empByList = new ArrayList<MasEmployee>();
	 List<MasEmployee> empRevList = new ArrayList<MasEmployee>();
	 Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");	 
		String currentTime = (String)utilMap.get("currentTime");
	 if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
	if(map.get("patientDetailList") != null){
		patientDetailList=(List)map.get("patientDetailList");
	}
	if(map.get("departmentList") != null){
		departmentList=(List)map.get("departmentList");
		}
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if(map.get("entryNo") != null){
		entryNo = (String)map.get("entryNo");
	}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	 if(map.get("empByList") != null){
		 empByList = (List<MasEmployee>) map.get("empByList");
	}
	 if(map.get("empRevList") != null){
		 empRevList = (List<MasEmployee>) map.get("empRevList");
	}
	 if(map.get("otSpecimenDispatchEntryList") != null){
		 otSpecimenDispatchEntryList = (List<OtSpecimenDispatchEntry>) map.get("otSpecimenDispatchEntryList");
		}
	if(patientDetailList!=null)
	{
			OtBooking patient=(OtBooking)patientDetailList.get(0);
			if(patient.getHin().getPFirstName()!= null){
				patientName=patient.getHin().getPFirstName();
			}
			if(patient.getHin().getPMiddleName()!= null){
				patientName=patientName+" "+patient.getHin().getPMiddleName();
			}
			if(patient.getHin().getPLastName()!= null){
				patientName=patientName+" "+patient.getHin().getPLastName();
			}
			 
		%>


<form name="specimenDispatchEntry" action="" method="post">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Specimen Dispatch Entry</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Entry No</label>  <input	type="text" name="entryNo" value="<%=entryNo %>" readonly="readonly"/>
<label>Date</label><input	type="text" name="entryNo" value="<%=currentDate %>" readonly="readonly"/>
<div class="clear"></div>
</div>
<div class="clear"></div>
<!--Block One Starts-->

<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>HIN</label> <%if(patient.getHin().getHinNo()!= null){ %> 
<input	type="text" name="hinNo" value="<%=patient.getHin().getHinNo() %>" readonly="readonly"/>
 <%}else{ %> <input	type="text" name="hinNo" value="-" readonly="readonly"/> <%} %> 
 <label>Patient Name. </label> <%if(patientName!= null){ %>
 <input	type="text" name="patientName" value="<%=patientName %>" readonly="readonly"/>
<%}else{ %><input	type="text" name="patientName" value="-" readonly="readonly"/>
<%} %> <label>Age</label>
 <%if(patient.getHin().getAge()!= null){ %> <input	type="text" name="age" value="<%=patient.getHin().getAge() %>" readonly="readonly"/>
<%}else{ %> <input	type="text" name="age" value="-" readonly="readonly"/> <%} %>

<div class="clear"></div>

<label>Patient Status </label> <%if(patient.getHin().getPatientStatus() != null){ %>
 <input	type="text" name="getPatientStatus" value="<%=patient.getHin().getPatientStatus() %>" readonly="readonly"/>
 <%}else{ %>
 <input	type="text" name="getPatientStatus" value="-" readonly="readonly"/> <%} %>
  <%if(patient.getVisit() != null){ %> <input
	name="visitId" type="hidden" value="<%=patient.getVisit().getId()%>" readonly="readonly"/>
<%} else{%> <input name="visitId" type="hidden" value="" /> <%} %> <label>Reg.Date
</label> <%if(patient.getHin().getRegDate()!= null){ %>
 <input	type="text" name="getRegDate" value="<%=HMSUtil.changeDateToddMMyyyy(patient.getHin().getRegDate()) %>" readonly="readonly"/>
<%}else{ %><input	type="text" name="getRegDate" value="-" readonly="readonly"/> <%}%>
<input name="userName" id="userName" type="hidden" value="<%=userName %>" /> 
<%if(patient.getOrderNo()  != null){ %><input type="hidden" name="orderNo" value="<%=patient.getOrderNo() %>" />
<%} %> <%if(patient.getHin() != null){ %> <input name="hinId" type="hidden"	value="<%=patient.getHin().getId()%>" /> 
<%} %> <%if(patient.getDepartment() != null){ %><input name="departmentId" type="hidden" value="<%=patient.getDepartment().getId()%>" /> <%} %>
<input	name="hospitalId" type="hidden" value="<%=hospitalId%>" /> <input name="changedDate" type="hidden" value="<%=currentDate %>" />
<input	name="changedTime" type="hidden" value="<%=currentTime %>" /> <%}%>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> Tissue/Organ</label> <input
	name="tissueOrgan" type="text" tabindex="1" size="43" maxlength="50"
	validate="Tissue,string,yes" /> <label><span>*</span> Specimen
Dispatched By</label> <select id="empBy" name="empBy"
	validate="Specimen Dispatch By,string,yes" tabindex="2">
	<option value="0">Select</option>
	<%String empName="";
							for (MasEmployee masEmployee : empByList) {
								empName=masEmployee.getFirstName();
								if(masEmployee.getLastName() !=null){
									empName=empName+" "+masEmployee.getLastName();
								}
								
						%>
	<option value="<%=masEmployee.getId() %>"><%=empName%></option>
	<%
						}
					%>
</select> <label><span>*</span> Time of dispatch</label>
<input name="timeOfDispatch" type="text" tabindex="1" validate="Time of dispatch,string,yes"
	onblur="IsValidTime(this.value,timeOfDispatch)"  onkeyup="mask(this.value,this,'2,5',':');"  maxlength="8" "/>
<div class="clear"></div>

<label>Examination Required</label>
<input name="examinationRequired"	type="text" tabindex="1" maxlength="50" validate="Examination Required,string,no" />
	 <label><span>*</span>
Specimen Received By</label>
<select id="empRev" name="empRev" validate="Specimen Received By,string,yes" tabindex="2">
	<option value="0">Select</option>
	<%String receivBy="";
				for (MasEmployee masEmployee : empRevList) {
					receivBy=masEmployee.getFirstName();
					if(masEmployee.getLastName() !=null){
						receivBy=receivBy+" "+masEmployee.getLastName();
					}
		%>
	<option value="<%=masEmployee.getId() %>"><%=receivBy%></option>
	<%
						}
					%>
</select>
<label>Clinical Notes</label> <input name="clinicalNotes" type="text"
	class="large2" maxlength="50" validate="Clinical Notes,string,no" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>

<input type="button" name="Submit" class="button" value="Submit"
	onclick="submitForm('specimenDispatchEntry','ot?method=submitOtSpecimenDispatchEntry')" />
<input type="button" name="Back" class="button" value="Back"
	onclick="showBack('specimenDispatchEntry')" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=currentDate %></label>

<label>Changed Time</label> <label class="value"><%=currentTime %></label>

</div>
</form>