<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
	function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
	}
	</script>
	
<script type="text/javascript">
	
function showBack(formName)
	{
	  obj = eval('document.'+formName)
	  obj.action = "/hms/hms/ot?method=showOTPatientSearchForDisposalJsp";
	  obj.submit();
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
		List otHumanBodyPartsList= new ArrayList();
		List patientDetailList = new ArrayList();
		List deptList = new ArrayList();
		List empList = new ArrayList();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");	 
		String currentTime = (String)utilMap.get("currentTime");
		int hospitalId=0;
		int entryNo=0;
		String userName = "";
		String patientName="";
		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		if(map.get("patientDetailList") != null){
			patientDetailList=(List)map.get("patientDetailList");
		}
		if(map.get("deptList") != null){
			deptList=(List)map.get("deptList");
		}
		if(map.get("empList") != null){
			empList=(List)map.get("empList");
		}
		if(map.get("otHumanBodyPartsList") != null){
			otHumanBodyPartsList=(List)map.get("otHumanBodyPartsList");
		}
		if (session.getAttribute("hospitalId") != null) {
			hospitalId = (Integer) session.getAttribute("hospitalId");
		}
		if(map.get("entryNo") != null){
			entryNo = (Integer)map.get("entryNo");
		}
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		if(patientDetailList!=null && patientDetailList.size()>0)
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


<form name="humanBodyDisposal" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="titleBg">
<h2>Human Body Parts Disposal Entry</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Entry No</label> 
<%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){ OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);%>
<input type="text"	value="<%=ot.getEntryNo() %>" name="entryNo"  readonly="readonly" />
<%}else{ %> <input type="text"	value="<%=entryNo %>" name="entryNo"  readonly="readonly" /> <%} %>
<label>Date</label> <%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){ 
		OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);
		String dateOfDispatch=HMSUtil.convertDateToStringWithoutTime(ot.getDispatchDate());
	%> 
	<input	type="text" id="dateOfDispatch" name="dateOfDispatch" value="<%=dateOfDispatch %>"  readonly="readonly" />
 <%}else{ %> <input	type="text" id="dateOfDispatch" name="dateOfDispatch" value="<%=currentDate %>"  readonly="readonly"/>
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" onclick="setdate('<%=currentDate %>',document.humanBodyDisposal.dateOfDispatch,event);"
	border="0" validate="Pick a date" class="calender" /> <%} %> <!-- <label class="value"><input type="text" value="<%=currentDate %>" name="dateOfDispatch" readonly /></label> -->

<div class="clear"></div>
</div>
<div class="clear"></div>
<!--Block One Starts-->


<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<label>HIN</label> <%if(patient.getHin().getHinNo()!= null){ %>
<input type="text" value="<%=patient.getHin().getHinNo() %>" name="hinNo" id="hinNo" readonly="readonly"/>
<%}else{ %> <input type="text" value="-" name="hinNo" id="hinNo" readonly="readonly"/> <%} %>
 <label>Patient Name </label> <%if(patientName!= null){ %>
 <input type="text" value="<%=patientName %>" name="patName" id="patName" readonly="readonly"/>
<%}else{ %> <input type="text" value="-" name="patName" id="patName" readonly="readonly"/> <%} %>
<label>Age</label> <%if(patient.getHin().getAge()!= null){ %>
 <input type="text" value="<%=patient.getHin().getAge() %>" name="age" id="age" readonly="readonly"/> <%}else{ %> 
  <input type="text" value="-" name="age" id="age" readonly="readonly"/> <%} %>

<div class="clear"></div>

<label>Patient Status </label> <%if(patient.getHin().getPatientStatus() != null){ %>
 <input type="text" value="<%=patient.getHin().getPatientStatus() %>" name="patStatus" id="patStatus" readonly="readonly"/> 
<%}else{ %>
 <input type="text" value="" name="patStatus" id="patStatus" readonly="readonly"/>  <%} %> 
 <label>Reg.Date </label> <%if(patient.getHin().getRegDate()!= null){ %>
  <input type="text" value="<%=HMSUtil.changeDateToddMMyyyy(patient.getHin().getRegDate()) %>" name="patStatus" id="patStatus" readonly="readonly"/> 
<%}else{ %> <input type="text" value="-" name="patStatus" id="patStatus" readonly="readonly"/>  <%} %> <%if(patient.getHin() != null){%>
<input name="hinId" type="hidden" value="<%=patient.getHin().getId()%>" />
<%} %> 
<input name="departmentId" type="hidden"	value="<%=patient.getDepartment().getId()%>" /> <%}%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="Block">
<div class="clear"></div>
<label><span>*</span>Tissue/Organ</label> <%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){ OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);%>
<input name="tissueOrgan"  readonly="readonly"
	type="text" value="<%=ot.getTissueOrgan() %>" tabindex="1" size="43"
	maxlength="50" validate="Tissue,string,yes" /> <%}else{ %> <input
	name="tissueOrgan" type="text" tabindex="1" size="43" maxlength="50"
	validate="Tissue,string,yes" /> <%} %> <label><span>*</span>Time of dispatch</label>
<%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){ OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);%>
<input id="timeOfDispatch"  readonly="readonly"	name="timeOfDispatch" value="<%=ot.getTimeOfDispatch()%>" type="text"
	tabindex="10" maxlength="5" validate="Time,string,yes" onblur="IsValidTime(this.value,'timeOfDispatch')" onkeyup="mask(this.value,this,'2',':');" /> 
<%}else{ %> <input	type="text" name="timeOfDispatch" id="timeOfDispatch" validate="Time,string,yes"
	onblur="IsValidTime(this.value,'timeOfDispatch')" maxlength="5" onkeyup="mask(this.value,this,'2',':');" /> <%} %>
<div class="clear"></div>

<label><span>*</span>Specimen Received By</label> 
<%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){
	OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);
	String speciRecBy="";
	speciRecBy=ot.getSpecimenRecievedBy().getFirstName();
	
	if(ot.getSpecimenRecievedBy().getMiddleName() !=null){
		speciRecBy=speciRecBy+" "+ot.getSpecimenRecievedBy().getMiddleName();
	}
	if(ot.getSpecimenRecievedBy().getLastName() !=null){
		speciRecBy=speciRecBy+" "+ot.getSpecimenRecievedBy().getLastName();
	}
	%> 
<input type="text" class="" readOnly readonly="readonly" name="empId" id="empId" value="<%=speciRecBy%>"
	validate="Specimen Received By,string,yes" maxlength="8" /> <%}else{ %>
<select id="empId" name="empId" validate="Specimen Received By,string,yes" tabindex="2">
	<option value="0">Select</option>
	<%
					   Iterator itr= empList.iterator();
						while(itr.hasNext()){
						   MasEmployee masEmployee=(MasEmployee)itr.next();
						   int empId=masEmployee.getId();
						   String empName="";
						   if(masEmployee.getFirstName()!= null){
							   empName=masEmployee.getFirstName();
						   }
						   if(masEmployee.getMiddleName()!= null){
							   empName=empName+" "+masEmployee.getMiddleName();
						   }
							if(masEmployee.getLastName()!= null){
								empName= empName+" "+masEmployee.getLastName();
							}
							%>
	<option value="<%=empId %>"><%=empName %></option>
	<%} %>
</select> <%} %>
<label><span>*</span>Specimen Dispatched By</label> <%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){
		OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);
	%> <input type="text"  readonly="readonly"	name="deptId" id="deptId"	value="<%=ot.getSpecimenDispatchedBy().getDepartmentName()%>"
	validate="Specimen Dispatch By,string,yes" maxlength="8" /> <%}else{ %>
<select id="deptId" name="deptId"	validate="Specimen Dispatch By,string,yes" tabindex="2">
	<option value="0">Select</option>
	<%		  Iterator itr1= deptList.iterator();
					while(itr1.hasNext()){
						MasDepartment masDepartment= (MasDepartment)itr1.next();
						int deptId=masDepartment.getId();
						String deptName=masDepartment.getDepartmentName();
						%>
	<option value="<%=deptId %>"><%=deptName %></option>
	<%} %>
</select> <%} %> <label>Clinical Notes</label> <%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){ OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);%>
<input name="clinicalNotes"  readonly="readonly" type="text" value="<%=ot.getClinicalNotes() %>" tabindex="2"
	maxlength="50" validate="Clinical Notes,string,no" /> 
<%}else{ %> <input	name="clinicalNotes" type="text" tabindex="2" maxlength="50" validate="Clinical Notes,string,no" /> <%} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<%if(otHumanBodyPartsList!= null && otHumanBodyPartsList.size()>0){ OtHumanBodyDisposal ot=(OtHumanBodyDisposal)otHumanBodyPartsList.get(0);%>
<!-- <input type="button" name="Update"  class="button" value="Update" onclick="submitForm ('humanBodyDisposal','ot?method=')"/> -->
<%}else{ %>
 <input type="button" name="Submit" class="button"	value="Submit"	onclick="submitForm ('humanBodyDisposal','ot?method=submitHumanBodyPartsDisposal')" />
<%} %> <input type="button" name="Back" class="button" value="Back"	onclick="showBack('humanBodyDisposal')" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>

<label>Changed Date</label> <label class="value"><%=currentDate %></label>

<label>Changed Time</label> <label class="value"><%=currentTime %></label>

<div class="clear"></div>

<input name="userName" id="userName" type="hidden"	value="<%=userName %>" /> <input name="entryNo" type="hidden"value="<%=entryNo%>" />
<input name="hospitalId" type="hidden" value="<%=hospitalId%>" /> <input name="changedDate" type="hidden"value="<%=currentDate %>" />
<input name="changedTime" type="hidden"	value="<%=currentTime %>" /></div>
</form>
