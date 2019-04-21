<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript">
var	icdOtArray= new Array();
	<%
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	String consultationDate = (String)utilMap.get("currentDate");
	String consultationTime = (String)utilMap.get("currentTime");
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
	
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	String userName = "";
	String yearlySerialNo="";
	String monthlySerialNo="";
	String ipNo="";
	String wardName="";
	 List patientDetailList = new ArrayList();
	 List otList = new ArrayList();
	 List<OtProcedureNotesEntryDetail> otDetailList = new ArrayList<OtProcedureNotesEntryDetail>();
	 List<MasAnesthesia> anaesthesiaList = new ArrayList<MasAnesthesia>();
	 List<OtPreAnesthesiaDetails>otPreAnesthesiaDetailsList=new ArrayList<OtPreAnesthesiaDetails>();
	 List<OtBookSurgeon>otBookSurgeaonList=new ArrayList<OtBookSurgeon>();
	 List<PatientPrescriptionDetails> patientPrescriptionDetails= new ArrayList<PatientPrescriptionDetails>();
	 int surgeryHdId=0;
	 if(map.get("surgeryHdId") != null)
		{
		 surgeryHdId=(Integer)map.get("surgeryHdId");
		} 
	 int hinId=0;
	 if(map.get("hinId") != null)
		{
		 hinId=(Integer)map.get("hinId");
		} 
	 int visitId=0;
	 if(map.get("visitId") != null)
		{
		 visitId=(Integer)map.get("visitId");
		}
	 if(map.get("patientPrescriptionDetails") != null)
		{
			patientPrescriptionDetails=(List<PatientPrescriptionDetails>)map.get("patientPrescriptionDetails");
		} 
		List<RouteOfAdministration> routeOfAdministrationList = new   ArrayList<RouteOfAdministration>();
		if(map.get("routeOfAdministrationList") != null)
		{
			routeOfAdministrationList=(List<RouteOfAdministration>)map.get("routeOfAdministrationList");
		}
		List<OpdInstructionTreatment> masInstructionMasterList = new   ArrayList<OpdInstructionTreatment>();
		if(map.get("masInstructionMasterList") != null)
		{
		  masInstructionMasterList=(List<OpdInstructionTreatment>)map.get("masInstructionMasterList");
		}
		List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
		if(map.get("frequencyList") != null){
		frequencyList=(List)map.get("frequencyList");
		}
	 
	 if(map.get("otPreAnesthesiaDetailsList")!=null)
		{
		 otPreAnesthesiaDetailsList=(List)map.get("otPreAnesthesiaDetailsList");
		}
	 if(map.get("monthSerialNo")!=null)
	{
		monthlySerialNo=(String)map.get("monthSerialNo");
	}
	if(map.get("yearlySerialNo")!=null)
	{
		yearlySerialNo=(String)map.get("yearlySerialNo");
	}		
	if(map.get("patientDetailList") != null){
		
		patientDetailList=(List)map.get("patientDetailList");
		
	}
	if(map.get("otBookSurgeaonList") != null){
		
		otBookSurgeaonList=(List)map.get("otBookSurgeaonList");
		
	}
	
	if(map.get("otList") != null){
		
		otList=(List)map.get("otList");
	}
	if(map.get("otDetailList") != null){
		
		otDetailList=(List)map.get("otDetailList");
	}
	if(map.get("anaesthesiaList") != null){
			
		anaesthesiaList=(List)map.get("anaesthesiaList");
			
		}
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	int prescribedDepartmentId=0;
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(patientDetailList!=null && patientDetailList.size()>0)
	{	OtBooking otBooking=(OtBooking)patientDetailList.get(0);
		
		String patientName="";
		if(otBooking.getHin().getPFirstName()!= null){
			patientName=otBooking.getHin().getPFirstName();
		}
		if(otBooking.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+otBooking.getHin().getPMiddleName();
		}
		if(otBooking.getHin().getPLastName()!= null){
			patientName=patientName+" "+otBooking.getHin().getPLastName();
		}
		String servicePersonName="";
		if(otBooking.getHin().getSFirstName()!= null){
			servicePersonName=otBooking.getHin().getSFirstName();
		}
		if(otBooking.getHin().getSMiddleName()!= null){
			servicePersonName=servicePersonName+" "+otBooking.getHin().getSMiddleName();
		}
		if(otBooking.getHin().getSLastName()!= null){
			servicePersonName=servicePersonName+" "+otBooking.getHin().getSLastName();
		}
		if(otBooking.getInpatient()!=null){
			ipNo=otBooking.getInpatient().getAdNo();
			wardName=otBooking.getInpatient().getAdWard().getDepartmentName();
		}
%>

<!--main content placeholder starts here-->

<form name="otBooking" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Operative Notes (Surgery)</h2>
</div>
<div class="Clear"></div>
<input type="hidden" name="bookingId" id="bookingId" value="<%=otBooking.getId()%>" />
<div class="Block">
<div class="clear"></div>
<label>Yearly Serial No. </label>
<input type="text" id="yearlySerialNo" name="yearlySerialNo" value="<%=yearlySerialNo %>" readonly="readonly"/> 
<label>Monthly Serial No. </label> <input type="text" id="monthlySerialNo" name="monthlySerialNo" value="<%=monthlySerialNo %>" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<!--Block One Starts-->
<br />
<h4>Patient Particulars</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>UHID</label> <%if(otBooking.getHin().getHinNo()!= null){ %>
<input type="text" value="<%=otBooking.getHin().getHinNo() %>" name="hinNo" readonly="readonly"/>
<input type="hidden" name="hinId" id="hinId" value="<%=otBooking.getHin().getId()%>" /> <%}else{ %>
<input type="text" value="-" name="hinNo" readonly="readonly"/><%} %>
 <label>Patient Name </label> <%if(patientName!= null){ %>
<input type="text" name="patName" id="patName" value="<%=patientName%>" readonly="readonly"/>  <%}else{ %> 
<input type="text" name="patName" id="patName" value="-" readonly="readonly"/>  <%} %>
 <label>Age</label> <%if(otBooking.getHin().getAge()!= null){ %>
<input type="text" value="<%=otBooking.getHin().getAge() %>" name="age" readonly="readonly"/><%}else{ %>
<input type="text" value="-" name="age" readonly="readonly"/><%} %> 
<label>Patient Status </label> <%if(otBooking.getHin().getPatientStatus() != null){ %>
<input type="text" value="<%=otBooking.getHin().getPatientStatus() %>" name="getPatientStatus" readonly="readonly"/>
<%}else{ %> <input type="text" value="-" name="getPatientStatus" readonly="readonly"/> <%} %>
 <label>Reg.Date </label> <%if(otBooking.getHin().getRegDate()!= null){ %>
 <input type="text" value="<%= HMSUtil.convertDateToStringWithoutTime(otBooking.getHin().getRegDate()) %>" name="getRegDate" readonly="readonly"/>
<%}else{ %>  <input type="text" value="-" name="getRegDate" readonly="readonly"/><%} %> <label>Order No. </label>
<%if(otBooking.getOrderNo() !=0){ %> 
<input type="text" name="orderNo" id="orderNo"	value="<%=otBooking.getOrderNo()%>" readonly="readonly" /> 
<%}else{ %> <input type="text" name="orderNo" id="orderNo"	value="-" readonly="readonly" /> 
<%}%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="Block">
<label>Date</label> <input type="text" id="date" class="date" name="<%=DATE %>"	maxlength="30" readonly="readonly" 
	value="<%=HMSUtil.convertDateToStringWithoutTime(otBooking.getSurgeryDate())%>" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onchange="isApptGrCurrentDate1();"
	onclick="setdate('<%=date %>',document.otBooking.<%=DATE%>,event);" />
	
<label>Ip No</label>
<input type="text" name="ipNo" id="ipNo" value="<%=ipNo!=""?ipNo:"" %>" readonly="readonly" />
<label>Ward Name</label>
<input type="text" name="wardName" id="wardName" value="<%=wardName!=""?wardName:"" %>" readonly="readonly" />
<div class="clear"></div>	</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<h4>Surgeons Name</h4> <input name="Add" type="button" class="buttonAdd" value="" onclick="addRowForSurgery()" />
<input name="Delete" type="button" class="buttonDel" value="" onclick="removeRow()" />
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="investigationGrid" class="cmntable">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Surgeon Name</th>
		
	</tr>
	<%if(otBookSurgeaonList!=null && otBookSurgeaonList.size()>0){
	  int count=1;
	  for(OtBookSurgeon otBookSurgeon:otBookSurgeaonList)
	  {	  
	  %>

	<tr>
		<td><input type="text" name="textfield" readonly="readonly" size=2 value="<%=count%>" /></td>
		<td id="nomenclaturetd1">
		<% String empName="";
			if(otBookSurgeon.getEmployee() !=null){
				empName=otBookSurgeon.getEmployee().getFirstName();
				if(otBookSurgeon.getEmployee().getLastName() !=null){
				empName=empName+" "+otBookSurgeon.getEmployee().getLastName();
				}}
			%>
		<input type="text"	name="empName<%=count%>" id="empName<%=count %>" size=43
			value="<%=empName%>[<%=otBookSurgeon.getEmployee().getId()%>]" />
			<input type="hidden" value="<%=count %>" name="hiddenValue" id="hiddenValue" />
		</td>

	</tr>
	<%  count++;}
  } %>
	<tr>
		<%int inc=otBookSurgeaonList.size()+1; %>
		<td><input type="text" name="textfield" readonly="readonly" size=2 value="<%=inc%>" /></td>
		<td id="nomenclaturetd1"><input type="text" name="empName<%=inc%>" id="empName<%=inc%>" size=43 value="" />
		</td>
	</tr>
</table><div id=ac2update2	style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('empName<%=inc%>','ac2update2','ot?method=getEmpNameForAutoComplete',{parameters:'requiredField=empName<%=inc%>'});
	</script><input type="hidden" value="<%=inc%>" name="hiddenValue" id="hiddenValue" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Surgery Time</h4>
<div class="clear"></div>
<div class="Block">
<label>From</label> <input type="text"	name="surgeryFromTime" id="surgeryFromTime" value=""
	onkeyup="mask(this.value,this,'2,5',':');"	onblur="IsValidTime(this.value,'surgeryFromTime')" maxlength="8"/> <label>To</label>
<input type="text" name="surgeryToTime" id="surgeryToTime" value=""	onblur="IsValidTime(this.value,surgeryFromTime)" 
onkeyup="mask(this.value,this,'2,5',':');" maxlength="8"/>
<div class="clear"></div>
<label>Anesthesia</label> <select name="anaesthesiaId" id="anaesthesiaId">
	<option value="0">Select</option>
	<%for(MasAnesthesia masAnesthesia:anaesthesiaList){ %>
	<option value="<%=masAnesthesia.getId()%>"><%=masAnesthesia.getAnesthesiaName()%></option>
	<%} %>
</select>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="Block">
<label>Pre OP Orders</label> 
<textarea name="preOpOrders" class="large" id="postOpOrders" maxlength="45" ></textarea>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<label>Finding &amp; Procedure</label>
<textarea name="findings" class="large" id="findings" maxlength="45" ></textarea>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<label>Post OP Orders</label> 
<textarea name="postOpOrders" class="large" id="postOpOrders" maxlength="45" ></textarea>
<div class="clear"></div>
<label>Procedure Notes</label> 
<textarea name="ProcedureNotes" class="large" id="ProcedureNotesId" maxlength="1000" ></textarea>
<div class="clear"></div>
</div>
<div class="clear"></div>
<%}
	if(otList!=null && otList.size()>0)
	{
		OtProcedureNotesEntryHeader otProcedureNotesEntryHeader=(OtProcedureNotesEntryHeader)otList.get(0);
	
	String patientName="";
	if(otProcedureNotesEntryHeader.getHin().getPFirstName()!= null){
		patientName=otProcedureNotesEntryHeader.getHin().getPFirstName();
	}
	if(otProcedureNotesEntryHeader.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+otProcedureNotesEntryHeader.getHin().getPMiddleName();
	}
	if(otProcedureNotesEntryHeader.getHin().getPLastName()!= null){
		patientName=patientName+" "+otProcedureNotesEntryHeader.getHin().getPLastName();
	}
	String servicePersonName="";
	if(otProcedureNotesEntryHeader.getHin().getSFirstName()!= null){
		servicePersonName=otProcedureNotesEntryHeader.getHin().getSFirstName();
	}
	if(otProcedureNotesEntryHeader.getHin().getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+otProcedureNotesEntryHeader.getHin().getSMiddleName();
	}
	if(otProcedureNotesEntryHeader.getHin().getSLastName()!= null){
		servicePersonName=servicePersonName+" "+otProcedureNotesEntryHeader.getHin().getSLastName();
	}
%> <!--main content placeholder starts here-->

<!--<form name="otBooking" method="post" action="">
--><div class="titleBg">
<h2>OT Procedure Notes Entry</h2>
</div>
<div class="clear"></div>
<div class="Block"><label>Yearly Serial No. </label> <label
	class="value"><%=otProcedureNotesEntryHeader.getYearlySerialNo()%></label>
<input type="hidden" id="yearlySerialNo" name="yearlySerialNo"
	value="<%=otProcedureNotesEntryHeader.getYearlySerialNo() %>" /> <label>Monthly
Serial No. </label> <label class="value"><%=otProcedureNotesEntryHeader.getMonthlySerialNo()%></label>
<input type="hidden" id="monthlySerialNo" name="monthlySerialNo"
	value="<%=otProcedureNotesEntryHeader.getMonthlySerialNo()%>" />
<div class="clear"></div>
</div>
<!--Block One Starts-->
<div class="clear"></div>
<h4>Patient Particulars</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>HIN</label> <%if(otProcedureNotesEntryHeader.getHin().getHinNo()!= null){ %>
<label class="value"><%=otProcedureNotesEntryHeader.getHin().getHinNo() %></label>
<input type="hidden" name="hinId" id="hinId"
	value="<%=otProcedureNotesEntryHeader.getHin().getId()%>" /> <%}else{ %>
<label class="value">-</label> <%} %> <label>Patient Name. </label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label>Age</label> <%if(otProcedureNotesEntryHeader.getHin().getAge()!= null){ %>
<label class="value"><%=otProcedureNotesEntryHeader.getHin().getAge() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Patient
Status </label> <%if(otProcedureNotesEntryHeader.getHin().getPatientStatus() != null){ %>
<label class="value"><%=otProcedureNotesEntryHeader.getHin().getPatientStatus() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>

<label>Reg.Date </label> <%if(otProcedureNotesEntryHeader.getHin().getRegDate()!= null){ %>
<label class="value"><%=otProcedureNotesEntryHeader.getHin().getRegDate() %></label>
<%}else{ %> <label class="value">-</label> <%}%>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<label>Date:</label> 
<input type="text" id="date" name="<%=DATE %>"	value="<%=otProcedureNotesEntryHeader.getDate()%>" maxlength="30"readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="date" onchange="isApptGrCurrentDate1();"
	onclick="setdate('<%=otProcedureNotesEntryHeader.getDate()%>',document.otBooking.<%=DATE%>,event);" />
<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
<label>Surgeons Name</label> 
<input name="Add" type="button"	class="button" value="Add" onclick="addRowForSurgery()" />
<input name="Delete" type="button" class="button" value="Delete" onclick="removeRow()" />
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="investigationGrid">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Surgeaon Name</th>
		
	</tr>
	<%int inc=1;
     for(OtProcedureNotesEntryDetail otProcedureNotesEntryDetail:otDetailList){
     %>
	<tr>
		<td><input type="text" name="textfield" size=2 value="<%=inc%>" /></td>
		<td id="nomenclaturetd<%=inc%>"><input type="text"
			name="empName<%=inc%>" id="empName1" size=43
			value="<%=otProcedureNotesEntryDetail.getEmployee().getFirstName()%>[<%=otProcedureNotesEntryDetail.getEmployee().getId()%>]" />
		<div id="ac2update2"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('empName1','ac2update2','ot?method=getEmpNameForAutoComplete',{parameters:'requiredField=empName<%=inc%>'});
	</script><input type="hidden" value="<%=inc%>" name="hiddenValue"
			id="hiddenValue" /></td>
	</tr>
	<%inc++;} %>
</table>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="Block"><label>Surgery Time:</label> <label>From:</label>
<input type="text" name="surgeryFromTime" id="surgeryFromTime"
	value="<%=otProcedureNotesEntryHeader.getSurgeryFromTime() %>"
	onblur="IsValidTime(this.value,surgeryFromTime)" /> <label>To:</label>
<input type="text" name="surgeryToTime" id="surgeryToTime"
	value="<%=otProcedureNotesEntryHeader.getSurgeryToTime() %>"
	onblur="IsValidTime(this.value,surgeryFromTime)" />
<div class="clear"></div>
<label>Anesthesia:</label> <select name="anaesthesiaId"
	id="anaesthesiaId">
	<option value="0">Select</option>
	<%for(MasAnesthesia masAnesthesia:anaesthesiaList){ 
		if(masAnesthesia.getId()==otProcedureNotesEntryHeader.getAnaesthesia().getId()){
		%>

	<option value="<%=masAnesthesia.getId()%>" selected="selected"><%=masAnesthesia.getAnesthesiaName()%></option>
	<%}else{%>
	<option value="<%=masAnesthesia.getId()%>"><%=masAnesthesia.getAnesthesiaName()%></option>
	<%} %>
	<%} %>
</select>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="Block"><label>Pre OP Orders</label> <textarea
	name="preOpOrders" id="remarks" cols="0" rows="0" class="large"><%=otProcedureNotesEntryHeader.getPreOpOrders()%></textarea>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<label>Finding & Procedure</label> <textarea name="findings" cols="0"
	rows="0" class="large" id="findings"><%=otProcedureNotesEntryHeader.getFindingsNProcedures()%></textarea>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<label>Post OP Orders</label> <textarea name="postOpOrders" cols="0"
	rows="0" class="large" id="postOpOrders"><%=otProcedureNotesEntryHeader.getPostOpOrders()%></textarea>
<div class="clear"></div>
</div>
<%} %>
<div class="clear"></div>
<div class="division"></div>
					<div class="addDeleteButton">
						<!-- <a href="#" onclick="getDetails();">Today's Other Prescription</a> -->
						<input type="button" class="buttonDel" value=""
							onclick="removeRowPrescriptionTabInOt('opcTab');" /> <input type="button" class="buttonAdd"
							onclick="addRowPrescriptionTabInOt();" value="" />
					</div>
					<div class="clear"></div>
<div class="clear"></div>
<!-- ..........By Awadhesh................ -->
					<div class="clear"></div>
		<div class="paddLeft15">
						<div class="tableForTab" style="width:890px; height:152px; overflow: scroll;">
							<!-- <div id="divTemplet2"> -->
								<table border="0" align="center" cellpadding="0" cellspacing="0"
									id="prescriptionTabGridOt">
									<tr>
										<th scope="col">&nbsp;</th>
										<th scope="col">Item Name</th>
										<th scope="col">Route</th>
										<th scope="col">Dosage</th>
										<th scope="col">Unit</th>
										<th scope="col">Frequency<span>*</span></th>
										<!-- <th scope="col">Days</th> -->
										<th scope="col">Duration</th>
										<th scope="col">Instruction</th>
										<th scope="col">Special Instruction</th>
										<th scope="col">Total</th>
										<th scope="col"></th>
										<!-- <th scope="col">Start Date</th>
										<th scope="col">End Date</th> -->
									</tr>
									<%	
	int incr = 0;int len=3;
	/* if(patientPrescriptionDetails.size()>0){
		len=patientPrescriptionDetails.size();
	}else{
		len=3;
	} */
	int inxRow=3;
	int inxCol=0;
	Integer pHeaderId=0;
	for(;incr< len;incr++,inxRow++){
		String nomeclature="";
		Integer ItemId=0;
		String pvmsNo="";
		int routeId=0;
		int frequencyId=0;
		int inctrunctionId=0;
		String unit="";
		String frequecnyType = "";
		Float dosage=0f;
		int ndays=0;
		Float total=0f;
		Date sDate=null;
		Date eDate=null;
		String issuedStatus="";
		String routeName="";
		PatientPrescriptionDetails pd=null;
		String pAvailableStatus="";
		String conversion="";
		/*if(patientPrescriptionDetails.size()>0){ 
			pd=patientPrescriptionDetails.get(incr);
			pHeaderId=pd.getPrescription().getId();
			ItemId=pd.getItem().getId();
			ItemId=0;
			if(pd.getIssuedStatus()!=null && !pd.getIssuedStatus().equals("")  && pd.getIssuedStatus().equalsIgnoreCase("y")){
				issuedStatus=pd.getIssuedStatus();
				System.out.println("issuedStatus "+issuedStatus);
			}	
			if(pd.getNotAvailable()!=null){
				pAvailableStatus=pd.getNotAvailable();
			}
			nomeclature=pd.getItem().getNomenclature();
			nomeclature="";
			pvmsNo=pd.getItem().getPvmsNo();
			dosage=pd.getDosage();
			unit=pd.getItem().getDispUnit();
			conversion=pd.getItem().getItemConversion().getItemUnitName();
			total=pd.getTotal();
			frequecnyType = pd.getFrequency().getFrequencyType();
			ndays=pd.getNoOfDays();
			sDate=pd.getStartDate();
			eDate=pd.getEndDate();
			if(pd.getRoute()!=null){
				routeId=pd.getRoute().getId();
				routeName=pd.getRoute().getRouteName();
			}
			if(pd.getFrequency()!=null){
				frequencyId=pd.getFrequency().getId();
			}
			if(pd.getInsrtuction()!=null){
				inctrunctionId=pd.getInsrtuction().getId();
			}
			if(ItemId!=0 &&  !pvmsNo.equals("")){
				nomeclature=nomeclature+"("+ItemId+")["+pvmsNo+"]";
			}
		 }*/
		%>
									<tr>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="checkbox" disabled="disabled" class="radioCheck"
											id="itemRadioOtTab<%=incr%>" name="itemRadioOtTab<%=incr%>" />
											<%}else{ %> <input type="checkbox" class="radioCheck"
											id="itemRadioOtTab<%=incr%>" name="itemRadioOtTab<%=incr%>" />
											<% }%>
											<input type="hidden" id="parkPrescriptionOtIds<%=incr%>"
											name="parkPrescriptionOtIds<%=incr%>"
											value="<%=pd!=null && pd.getId()!=0?pd.getId():"0"%>"
											readonly="readonly" /> 
											
											<input type="hidden"
											name="prescription_availableStatuspOtTab<%=incr %>"
											id="prescription_availableStatuspOtTab<%=incr %>"
											value="<%= pAvailableStatus%>" />
										</td>
										<td>
											<%if(!issuedStatus.equals("") && issuedStatus.equalsIgnoreCase("y")){ %>
											<input type="text" readonly="readonly"
											class="textYellow largTextBoxOpd" value="<%=nomeclature %>"
											id="nomenclatureOtTab<%=incr%>" size="35"
											name="nomenclatureOtTab<%=incr%>"
											onkeypress="checkTextColor('nomenclatureOtTab<%=incr%>');"
											onblur="populatePVMSOtTab(this.value,'<%=incr%>');checkPItemOt('<%=incr%>');validatePrescriptionAutocompleteOt('opOtTab',this.value,<%=incr %> );checkForAllergyOt(this.value,<%=incr%>);" />
											<%}else{ %> <input type="text"
											class="textYellow largTextBoxOpd" value="<%=nomeclature %>"
											id="nomenclatureOtTab<%=incr%>" size="35"
											name="nomenclatureOtTab<%=incr%>"
											onfocus="checkEnteredDiagnosis();checkFrequency('<%=incr%>','tab');"
											onkeypress="checkTextColor('nomenclatureOtTab<%=incr%>');"
											onblur="populatePVMSOtTab(this.value,'<%=incr%>');checkPItemOt('<%=incr%>');validatePrescriptionAutocompleteOt('opOtTab',this.value,<%=incr %>);checkForAllergyOt(this.value,<%=incr%>);" />
											<% }%>


											<div id="ac2updatesOtTab<%=incr%>" style="display: none;"
												class="autocomplete"></div> <script type="text/javascript"
												language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('nomenclatureOtTab<%=incr%>','ac2updatesOtTab<%=incr%>','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclatureOtTab<%=incr%>'});
					</script>
				<input type="hidden" name="pvmsNoOtTab<%=incr %>" tabindex="33" id="pvmsNoOtTab<%=incr %>" value="" size="10" readonly="readonly" />
				<input type="hidden" name="actualDispensingQtyOtTab<%=incr%>" tabindex="1" id="actualDispensingQtyOtTab<%=incr%>" value="" size="6" validate="AU,string,no" />
				<input type="hidden" name="tapered<%=incr%>" id="tapered<%=incr%>"  validate="tapered,string,no" />
										</td>
										
										<td>
								 <select name="routeOtTab<%=incr%>"
											id="routeOtTab<%=incr%>"
											style="width: 70px; background: #FFFF99">
												<option value="0">Select</option>
												<%
					      for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
					    	  
					       int id = routeOfAdministration.getId();
					       String name = routeOfAdministration.getRouteName();
			          %>
												<%if(routeId==id){ %>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%}%>
										</select>
										</td>
										<td><input class="textYellow opdTextBoxTSmall"
											type="text" name="dosageOtTab<%=incr%>"
											value="<%=dosage!=null && dosage!=0?dosage:"" %>"
											onblur="fillValueOt(this.value,<%=incr%>,'tab');"
											id="dosageOtTab<%=incr%>" size="10" maxlength="45" />
											<div id="testDivOtTab<%=incr%>"></div></td>
										<td><input type="text" name="unitOtTab<%=incr%>"
											class="textYellow opdTextBoxTSmall" id="unitOtTab<%=incr%>"
											value="<%=unit!=null && !unit.equals("")?unit:"" %>"
											readonly="readonly" size="5"
											validate="unit<%=incr%>,string,no" /></td>
										<td><input type="hidden"
											name="frequencyValueOtTab<%=incr%>" tabindex="1"
											id="frequencyValueOtTab<%=incr%>" size="6" /> <input
											type="hidden" name="sosQtyOtTab<%=incr%>" tabindex="1"
											id="sosQtyOtTab<%=incr%>" style="display: none;" size="3"
											maxlength="3" validate="Sos Qty,num,no" /> <select
											style="width: 70px; background: #FFFF99"
											name="frequencyOtTab<%=incr%>" id="frequencyOtTab<%=incr%>"
											onchange="getFrequencyValueOtTab(this.value,<%=incr%>);fillValueOt(this.value,<%=incr%>,'tab');displaySOSQtypTab(this.value,<%=incr%>);displaFrequencyTypeForPrescriptionTab(this,<%=incr%>);">
												<option value="0">Select</option>
												<%
				  
			      for(MasFrequency masFrequency2 : frequencyList){
			       int id = masFrequency2.getId();
			       String name = masFrequency2.getFrequencyName();
			       String type = masFrequency2.getFrequencyType();
	          %>
												<%if(frequencyId==id){%>
												<option id="<%=type %>" selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option id="<%=type %>" value="<%=id %>"><%=name%></option>
												<%} %>
												<%} %>
										</select> <%
				  MasFrequency masFrequency3 = new MasFrequency();

				         for (int i = 0; i < frequencyList.size(); i++) {
				        	 masFrequency3 = (MasFrequency) frequencyList.get(i);
	     			 %> <script>
	     			
		          icdOtArray[<%=i%>]= new Array();
		          icdOtArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
		          icdOtArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
		          icdOtArray[<%=i%>][2] = "<%=masFrequency3.getFrequencyType()%>";
	            </script> <% }%></td>
	            						
										<td>
										<div style="width:100px; float: left;">
										<input type="text" name="noOfDaysOtTab<%=incr%>"
											id="noOfDaysOtTab<%=incr%>"
											class="textYellow opdTextBoxTSmall"
											value="<%=ndays!=0 ?ndays:"" %>" size="3" maxlength="3"
											validate="No Of Days,num,no"
											onblur="fillValueOt(this.value,<%=incr%>,'tab');setEndDate(this.value,<%=incr %>);" />
									    <p style="line-height:0px;" id="frequencyTypeForPrescriptionOtTab<%=incr %>" ><%=frequecnyType %></p>
										</div>
										</td>
										<td><select style="width: 70px; background: #FFFF99"
											name="instrunctionOtTab<%=incr%>"
											id="instrunctionOtTab<%=incr%>"><option value="0">Select</option>
												<%
					for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
					{
		
				       int id = instructionTreatment.getId();
				       String name = instructionTreatment.getOpdInstructionTreatmentName();
		
		          %>
												<%if(inctrunctionId==id){%>
												<option selected="selected" value="<%=id %>"><%=name%></option>
												<%}else{ %>
												<option value="<%=id %>"><%=name%></option>
												<%} %>
												<%
					}
					%>
										</select>
										
										<script type="text/javascript">	var	instructionOtArray= new Array();
              <%
              OpdInstructionTreatment  instructionMaster = new OpdInstructionTreatment();
			     for (int k = 0; k < masInstructionMasterList.size(); k++) {
			    	 instructionMaster = (OpdInstructionTreatment) masInstructionMasterList.get(k);
     			 %> 
     			instructionOtArray[<%=k%>]= new Array();
     			instructionOtArray[<%=k%>][0] = "<%=instructionMaster.getId()%>";
     			instructionOtArray[<%=k%>][1] = "<%=instructionMaster.getOpdInstructionTreatmentName()%>";
     			<% }%> 
            </script>
										
										
										
										
										</td>
										<td><input type="text"
											name="splInstrunctionOtTab<%=incr %>"
											class="textYellow opdTextBoxSmall"
											id="splInstrunctionOtTab<%=incr %>" maxlength="200" /></td>
										<td>
										<input type="text" name="totalOtTab<%=incr%>"
											id="totalOtTab<%=incr%>"
											value="<%=total!=null && total!=0?total:"" %>"
											class="textYellow opdTextBoxTSmall" size="5"
											validate="Total,num,no" readonly="readonly" /></td>
										
										<td>
											<input type="text" name="unitLableOtTab<%=incr%>"
											id="unitLableOtTab<%=incr%>" value="<%=!conversion.equals("")?conversion:"" %>"
											class="textYellow opdTextBoxTSmall" size="5"
											readonly="readonly" />
										</td>	
											
										<!-- <td> --><div style="width: 145px;">
												<input size="5" type="hidden" name="startOtDate<%=incr%>"
													value="<%=currentDate%>" class="textYellow small"
													value="<%=sDate!=null ?sDate:"" %>" id="startOtDate<%=incr%>"
													validate="startOtDate<%=incr%>,string,no" readonly="readonly"
													onblur="compareDate(<%=incr%>);checkStartDate(<%=incr%>)" />
												<%-- <img src="/hms/jsp/images/cal.gif" width="16" height="16"
													border="0" validate="Pick a date"
													onclick="setdate('<%=currentDate%>',document.otBooking.<%=incr%>,event);" /> --%>
											</div><!-- </td> -->
										<!-- <td> --><div style="width: 145px;">
												<input size="5" type="hidden" name="endOtDate<%=incr%>"
													class="textYellow small" value="" id="endOtDate<%=incr%>"
													validate="endOtDate<%=incr%>,string,no" readonly="readonly"
													onblur="compareDate(<%=incr%>);checkEndDate(<%=incr%>)" />
											<%-- 	<img src="/hms/jsp/images/cal.gif" validate="Pick a date"
													onclick="setdate('<%=currentDate%>',document.opdMain.endDate<%=incr%>,event);" /> --%>
											</div><!-- </td> -->
									</tr>
									<%}%>
									<tbody id="divTempletOt2"></tbody>	
								</table>
								<input type="hidden" name="OtTabhdb" value="<%=incr-1%>"
									id="OtTabhdb" />
							<!-- </div> -->
						</div>
						<div class="clear"></div>
						<div class="floatLeft">
							<label class="auto"><img
								src="/hms/jsp/images/red_rectangle.jpg" width="14" height="14" /><span>Stock
									not available for medicine</span></label>
						</div>
					</div>





<!-- ..........By Awadhesh................ -->
<div class="clear"></div>

<%if(patientDetailList!=null && patientDetailList.size()>0)
	{ %> <input type="button" name="Submit" class="button" value="Submit"
	onclick="submitForm ('otBooking','ot?method=submitOtProcedureNotesEntryJsp&otProcedure=yes')" />
<%}else if(otList!=null && otList.size()>0){ %> <%} %> <input name="hinId"
	type="hidden" value="" /> <input name="patientStatus" type="hidden"
	value="" /> <input name="orderNo" type="hidden" value="" /> <input
	name="hospitalId" type="hidden" value="" /> <input name="changedBy"
	type="hidden" value="<%=userName %>" /> <input name="changedDate"
	type="hidden" value="<%=date %>" /> <input name="changedTime"
	type="hidden" value="<%=time %>" /> <input name="back" type="button"
	class="button" value="Back"
	onclick="submitForm ('otBooking','ot?method=showOtPatientDetails&otProcedure=yes')" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<div class="clear"></div>

 <input name="pHeaderId"
			type="hidden" value="<%=pHeaderId%>" />
			<input name="surgeryId"
			type="hidden" value="<%=surgeryHdId%>" />
			<input name="hinId1"
			type="hidden" value="<%=hinId%>" />
			<input name="visitId"
			type="hidden" id="visitId" value="<%=visitId%>" />
			 <input id="consultationDate"
			name="consultationDate" type="hidden" value="<%=consultationDate%>" />
		<input name="consultationTime" type="hidden"
			value="<%=consultationTime%>" />
<label>Changed By</label> <label class="value"><%=userName %></label> <label>Changed
Date</label> <label class="value"><%=date %></label> <label>Changed Time</label>
<label class="value"><%=time %></label>

<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
</div>
 <div  style="display: none;">
						<table id="taperedMedicne1">
						<th scope="col">Item Id</th>
						<th scope="col">Frequency</th>
				        <th scope="col">Dosage</th>
				        <th scope="col">Dosage Total</th>
				        <th scope="col">Duration</th>
				        <th scope="col">Total</th>
						</table>
	<input type="hidden" id="taperedMedicineHdb1" name="taperedMedicineHdb" value="0"/>
</div>
</form>
<form action="" name="taperedForm"  style="display: none;">
							<!-- added by govind for tapered Medicine -->
						<div>
						<table id="taperedMedicne">
						<th scope="col">Item Id</th>
						<th scope="col">Frequency</th>
				        <th scope="col">Dosage</th>
				        <th scope="col">Dosage Total</th>
				        <th scope="col">Duration</th>
				        <th scope="col">Total</th>
						</table>
						</div>
						<input type="hidden" id="taperedMedicineHdb" name="taperedMedicineHdb" value="0"/>
						<!-- added by govind for tapered Medicine -->
	</form>

<script type="text/javascript">

function validateEmpForAutoComplete( strValue,inc ) {
 			 
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    if(id =="")
		    {
		    		document.getElementById('empName'+inc).value="";
 					return ;
 			}
 			return true;
		}	
  
	function removeRow()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	   tbl.deleteRow(lastRow - 1);
	   document.getElementById('hiddenValue').value= (document.getElementById('hiddenValue').value-1);
	  }
	}
 function addRowForSurgery(){
		
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	 
	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('input');
	  sel.value=hdb.value;
	  sel.size='2';
	  sel.setAttribute("readonly","readonly");
	  cellRightSel.appendChild(sel);
	 
	  var cellRight1 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	   e0.name = 'empName' + iteration;
	  e0.id = 'empName' + iteration;
	  e0.size = '43'
	  cellRight1.appendChild(e0);
	   new Ajax.Autocompleter('empName'+iteration,'ac2update2','ot?method=getEmpNameForAutoComplete',{parameters:'requiredField=empName'+iteration});
	 
	  var cellRightSel = row.insertCell(2);
	  cellRightSel.id='nomenclaturetd'+iteration;
	}
 




function getFrequencyValueOtTab(feqValue,inc){
		var feqQty;
		<%
		if(frequencyList.size()>0){	
			for(MasFrequency masFrequency :frequencyList){
		%>
		 if(feqValue == '<%=masFrequency.getId()%>'){
			 feqQty = '<%=masFrequency.getFrequencyCount()%>'
		  }

		<%}
		}%>
		 if(document.getElementById('frequencyValueOtTab' + inc)!=null){
		 document.getElementById('frequencyValueOtTab'+inc).value = feqQty;
		 }
	}
	
function addRowPrescriptionTabInOt() {
	/** For prescription tab : START */
	
	var tbl = document.getElementById('prescriptionTabGridOt');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('OtTabhdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadioOtTab' + iteration;
	e1.id = 'itemRadioOtTab' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'prescription_availableStatusOtTab' + iteration;
	e1.id = 'prescription_availableStatusOtTab' + iteration;
	e1.className = 'textYellow grdTextSmall';
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'parkPrescriptionOtIds' + iteration;
	e1.id = 'parkPrescriptionOtIds' + iteration;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'nomenclatureOtTab' + iteration;
	e1.id = 'nomenclatureOtTab' + iteration;
	e1.size = '35'
	e1.className = 'textYellow largTextBoxOpd';
	e1.onfocus = function() {
		//checkEnteredDiagnosis();
		//checkFrequency(iteration, "tab");
	}
	e1.onkeypress = function() {
		checkTextColor('nomenclatureOtTab' + iteration);
	};
	e1.onblur = function() {
		populatePVMSOtTab(this.value, iteration);
		checkPItemOt(iteration);
		validatePrescriptionAutocompleteOt('opPTab', this.value, iteration);
	    checkForAllergyOt(this.value, iteration);
	};

	cellRight1.appendChild(e1);
	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'ac2updatesOtTab' + iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	new Ajax.Autocompleter('nomenclatureOtTab' + iteration, 'ac2updatesOtTab'
			+ iteration, 'opd?method=getItemListForAutoCompleteItem', {
		minChars : 3,
		parameters : 'requiredField=nomenclatureOtTab' + iteration
	});
	e1.focus();

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'brandIdOtTab' + iteration;
	e1.id = 'brandOtId' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'manufactureIdOtTab' + iteration;
	e1.id = 'manufactureOtId' + iteration;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'routeOtTab' + iteration;
	e1.id = 'routeOtTab' + iteration;
	e1.style.width = "70px";
	e1.style.background = "#FFFF99";
	e1.options[0] = new Option('Select', '0');
	
	for (var i = 0; i < icdOtArray.length; i++) {
		e1.options[i + 1] = new Option(icdOtArray[i][1], icdOtArray[i][0]);
	}
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'actualDispensingQtyOtTab' + iteration;
	e1.id = 'actualDispensingQtyOtTab' + iteration;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.name = 'dosageOtTab' + iteration;
	e1.id = 'dosageOtTab' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.onblur = function() {
		fillValueOt(this.value, iteration, 'tab');
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'unitOtTab' + iteration;
	e1.id = 'unitOtTab' + iteration;
	e1.className = 'textYellow opdTextBoxTSmall';
	e1.readOnly = 'readOnly';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.name = 'frequencyOtTab' + iteration;
	e1.id = 'frequencyOtTab' + iteration;
	e1.style.width = "70px";
	e1.style.background = "#FFFF99";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < icdOtArray.length; i++) {
		e1.options[i + 1] = new Option(icdOtArray[i][1], icdOtArray[i][0]);
	}
	e1.onchange = function() {
		getFrequencyValueOtTab(this.value, iteration);
		fillValueOt(this.value, iteration, 'tab');
		displaySOSQtyOtTab(this.value, iteration)
	};
	cellRight1.appendChild(e1);

	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'sosQtyOtTab' + iteration;
	e21.id = 'sosQtyOtTab' + iteration;
	e21.size = '5';
	e21.setAttribute('tabindex', '1');
	cellRight1.appendChild(e21);

	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'frequencyValueOtTab' + iteration;
	e21.id = 'frequencyValueOtTab' + iteration;
	e21.size = '5';
	e21.setAttribute('tabindex', '1');
	cellRight1.appendChild(e21);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'noOfDaysOtTab' + iteration;
	e1.id = 'noOfDaysOtTab' + iteration;
	e1.size = '3';
	e1.className = 'textYellow opdTextBoxTSmall';
	e1.onblur = function() {
		fillValueOt(this.value, iteration, 'tab');
		setEndDate(this.value, iteration);
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('Select');
	e1.name = 'instrunctionOtTab' + iteration;
	e1.id = 'instrunctionOtTab' + iteration;
	e1.style.width = "70px";
	e1.style.background = "#FFFF99";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < instructionOtArray.length; i++) {
		e1.options[i + 1] = new Option(instructionOtArray[i][1],
				instructionOtArray[i][0]);
	}
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.maxlength = '200';
	e1.name = 'splInstrunctionOtTab' + iteration;
	e1.id = 'splInstrunctionOtTab' + iteration;
	e1.className = "textYellow opdTextBoxSmall";

	e1.size = '5';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'totalOtTab' + iteration;
	e1.id = 'totalOtTab' + iteration;
	e1.size = '5';
	e1.readOnly = true;
	e1.className = 'textYellow opdTextBoxTSmall';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'unitLableOtTab' + iteration;
	e1.id = 'unitLableOtTab' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.readOnly = 'readOnly';
	e1.size = '5';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'startDate' + iteration;
	e1.id = 'startDate' + iteration;
	e1.size = '5';
	e1.value = document.getElementById('consultationDate').value;
	e1.className = 'textYellow small';
	e1.readOnly = true;
	e1.onblur = function() {
		compareDate(iteration);
	};
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';
	img1.onclick = function(event) {
		var obj = document.getElementById('startDate' + iteration);
		setdate(document.getElementById('consultationDate').value, obj, event);
	};
	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(12);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'endDate' + iteration;
	e1.id = 'endDate' + iteration;
	e1.size = '5';
	e1.value = "";
	e1.readOnly = true;
	e1.className = 'textYellow small';
	e1.readOnly = true;
	e1.onblur = function() {
		compareDate(iteration);
	};
	cellRight1.appendChild(e1);

	var img2 = document.createElement('img');
	img2.src = '/hms/jsp/images/cal.gif';
	img2.onclick = function(event) {
		var obj = document.getElementById('endDate' + iteration);
		setdate(document.getElementById('consultationDate').value, obj, event);
	};
	cellRight1.appendChild(img2);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'pvmsNoOtTab' + iteration;
	e1.id = 'pvmsNoOtTab' + iteration;
	cellRight1.appendChild(e1);
	/** For prescription tab : END */
}
function removeRowPrescriptionTabInOt(from) {
	//setDisablePharmacy();
	var tbl = document.getElementById('prescriptionTabGridOt');
	var lastRow = tbl.rows.length; 
	var hdb = document.getElementById('OtTabhdb');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	
	if (from != 'opc' ? confirm("Do you want to delete !") : true) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("itemRadioOtTab" + i) != null
					&& (typeof document.getElementById("itemRadioOtTab" + i).checked) != 'undefined'
					&& document.getElementById("itemRadioOtTab" + i).checked) {
				totalSelected = totalSelected + 1;
			}
		}

		if (totalSelected == 0) {
			if (from != 'opc')
				alert('Please select atleast 1 row to delete');
		}
		/*
		 * else if(lastRow==2 || lastRow==(totalSelected+1)) { alert('You can
		 * not delete all Row.'); } else if (lastRow > 2){
		 */
		var flag = 0;
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("itemRadioOtTab" + i) != null
					&& (typeof document.getElementById("itemRadioOtTab" + i).checked) != 'undefined'
					&& document.getElementById("itemRadioOtTab" + i).checked) {
				jQuery(function($) {
					if (document.getElementById("parkPrescriptionOtIds" + i) != null) {
						var ids = document.getElementById("parkPrescriptionOtIds"
								+ i).value;
						if (ids != "" && ids != "0") {
							$.post('opd?method=deleteOPDdetails&ids=' + ids
									+ "&for=" + "prc" + "&" + csrfTokenName
									+ "=" + csrfTokenValue, function(data) {
								try {
									flag = 1;
									msgFlag = data;
								} catch (e) {
									alert(e);
								}
							});
						}
					}
				});

				var deleteRow = document.getElementById("itemRadioOtTab" + i).parentNode.parentNode;
				document.getElementById("itemRadioOtTab" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
	// }
}
/////////////////////////////////////////////////////////////////////////////////////////////////////

function checkPItemOt(cnt) {

	var tbl = document.getElementById('prescriptionTabGridOt');
	var lastRow = tbl.rows.length;
	var iteration = lastRow - 1;

	// var pvmsNo=document.getElementById("pvmsNo"+iteration).value
	var visitId = document.getElementById("visitId").value
	var nomenclature = document.getElementById("nomenclatureOtTab" + cnt).value
	var index1 = nomenclature.lastIndexOf("[");
	var indexForBrandName = index1;
	var index2 = nomenclature.lastIndexOf("]");
	index1++;

	var pvmsNo = nomenclature.substring(index1, index2);
	if (pvmsNo != "") {

		var xmlHttp;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				alert(e)
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}

		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {

				var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
				for (loop = 0; loop < items.childNodes.length; loop++) {
					var item = items.childNodes[loop];
					var stockStstus = item.getElementsByTagName("stock")[0];
					jQuery(function($) {
						if (stockStstus.childNodes[0].nodeValue == '0') {
							$("#nomenclatureOtTab" + cnt).css({
								'color' : 'red',
								'font-size' : '125%'
							});
							$("#prescription_availableStatusOtTab" + cnt).val(
									'y');
						} else {
							$("#prescription_availableStatusOtTab" + cnt).val(
									'n');
						}
					});
				}
			}
		}
		var url = "/hms/hms/opd?method=checkItem&pvmsNo=" + pvmsNo
				+ "&visitId=" + visitId + "&" + csrfTokenName + "="
				+ csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
}
function validatePrescriptionAutocompleteOt(flag, strValue, inc) {
	if (flag == 'opmain') {
		var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		var id = strValue.substring(index1, index2);
		var count = document.getElementById('OtTabhdb').value;
		if (id == "") {
			document.getElementById('nomenclatureOtTab' + inc).value = "";
			return;
		}

		for (var i = 0; i < count; i++) {
			if (document.getElementById('nomenclatureOtTab' + i) != null
					&& document.getElementById('nomenclatureOtTab' + i).value == strValue
					&& i != inc) {
				if(document.getElementById('tapered' + i)!=null && document.getElementById('tapered' + i).value!='y' ){
					alert('This Prescription is already selected.');
					document.getElementById('nomenclatureOtTab' + inc).value = "";
					return false;
				}
			}
		}
		return true;
	} else  {
		var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		var id = strValue.substring(index1, index2);
		var count = document.getElementById('OtTabhdb').value;
		if (id == "") {
			document.getElementById('nomenclatureOtTab' + inc).value = "";
			return;
		}

		for (var i = 0; i < count; i++) {
			if (document.getElementById('nomenclatureOtTab' + i) != null
					&& document.getElementById('nomenclatureOtTab' + i).value == strValue
					&& i != inc) {
				
				alert('This Prescription is already selected.');
				document.getElementById('nomenclatureOtTab' + inc).value = "";
				return false;
			}
		}
		return true;
	}

}
function checkForAllergy(val, inc) {
	// alert(val+"<<<-------val======inc------>>"+inc);
	var visitId = document.getElementById("visitId").value;
	var id;
	if (val != "") {

		var xmlHttp;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				alert(e)
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}

		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				var b = "false";
				var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
				for (loop = 0; loop < items.childNodes.length; loop++) {
					var item = items.childNodes[loop];
					icdString = item.getElementsByTagName('allergyString')[0];
					// alert("icdString"+icdString);
					b = icdString.childNodes[0].nodeValue
					// alert("b-->>"+b);

					// var val=document.getElementById('icd').value;
					var index1 = val.lastIndexOf("[");
					var index2 = val.lastIndexOf("]");
					index1++;
					id = val.substring(index1, index2);
					// alert("id------>>>"+id);
					if (id == "") {
						return;
					}

					if (b == 'true') {
						alert("Medicine is allergic to Patient!!");
						document.getElementById('nomenclatureOtTab' + inc).value = "";
					}
				}

			}
		}
		var url = "/hms/hms/opd?method=getItemForAllergy&val=" + val
				+ "&visitId=" + visitId + "&" + csrfTokenName + "="
				+ csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
}
function displaySOSQtyOtTab(val, inc) {
	if (val == '13') {
		document.getElementById('sosQtyOtTab' + inc).style.display = 'block';
		document.getElementById('noOfDaysOtTab' + inc).disabled = true;
	} else {

		document.getElementById('sosQtyOtTab' + inc).style.display = 'none';
		document.getElementById('noOfDaysOtTab' + inc).disabled = false;
	}
}



function fillValueOt(value, inc, from) {
	var dosage;
	var freq;
	var dispenseQty;
	var noOfDays;
	var sosQty;
	// added by amit das on 19-11-2016
	var unit;
	var mixtuerUnit;
	var mixable;
	var mixtureQuantity;
	
	//added by govind 24-01-2017
	setDisablePharmacy();
	//added by govind 24-01-2017 end
		dosage = document.getElementById('dosageOtTab' + inc).value
		noOfDays = document.getElementById('noOfDaysOtTab' + inc).value
		freq = document.getElementById('frequencyValueOtTab' + inc).value
		document.getElementById('totalOtTab' + inc).value = noOfDays * freq
				* dosage
		dispenseQty = document.getElementById('actualDispensingQtyOtTab' + inc).value;
		sosQty = document.getElementById('sosQtyOtTab' + inc).value;
		unit = document.getElementById('unitOtTab' + inc).value;
		
		
		if (freq > 0 && dosage > 0 && noOfDays > 0) {
			total =  Math.round(freq * noOfDays * dosage);
		} else {
			total = 0;
		}
	
		
		var finalQty = "";
		if (document.getElementById('frequencyOtTab' + inc).value != 13) {
			if (document.getElementById('actualDispensingQtyOtTab' + inc).value != 0) {
				var totalQty = (parseFloat(total) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				document.getElementById('totalOtTab' + inc).value = finalQty;
				
			} else {
				document.getElementById('totalOtTab' + inc).value = total;
				
			}
		} else {
			
			if (document.getElementById('actualDispensingQtyOtTab' + inc).value != 0) {
				var totalQty = (parseFloat(freq * sosQty * dosage) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				document.getElementById('totalOtTab' + inc).value = finalQty;
				
			} else {
				document.getElementById('totalOtTab' + inc).value = sosQty
						* freq * dosage;
				
			}
		}

	}

function populatePVMSOtTab(val, inc) {
	if (val != "") {
		var index1 = val.lastIndexOf("[");
		var indexForBrandName = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvmsNo = val.substring(index1, index2);
		var indexForBrandName = indexForBrandName--;
		var brandName = val.substring(0, indexForBrandName);

		if (pvmsNo == "") {
			document.getElementById('nomenclatureOtTab' + inc).value = "";
			document.getElementById('pvmsNoOtTab' + inc).value = "";
			document.getElementById('dosageOtTab' + inc).value = "";
			document.getElementById('noOfDaysOtTab' + inc).value = "";
			document.getElementById('unitOtTab' + inc).value = "";
			return;
		} else {// alert("pvmsNo "+pvmsNo);
			document.getElementById('pvmsNoOtTab' + inc).value = pvmsNo;
			document.getElementById('dosageOtTab' + inc).value = 1;
			document.getElementById('noOfDaysOtTab' + inc).value = 1;

			new Ajax.Request(
					'ipd?method=updateItemUnit&pvmsNo=' + pvmsNo + '&'
							+ csrfTokenName + '=' + csrfTokenValue,
					{
						onSuccess : function(response) {
							if (response.responseText.trim() != '') {
								var str = response.responseText.trim().split(
										"###");
								/*
								 * document.getElementById('unitpTab'+inc).value=response.responseText.trim();
								 * document.getElementById('unit'+inc).value=response.responseText.trim();
								 */
								
								document.getElementById('unitOtTab' + inc).value = str[0];
								
								document.getElementById('unitLableOtTab' + inc).value = str[1] != undefined ? str[1]
										: "";
								 //added by govind on 28-10-2017 for Tapered Medicine
				    	    	  document.getElementById('tapered' + inc).value = str[3]!=undefined?str[3]:"n";
									if(document.getElementById('tapered' + inc)!=null && document.getElementById('tapered' + inc).value=='y' ){
										var nomenclature=document.getElementById('nomenclatureOtTab' + inc).value;
										var index1 = nomenclature.lastIndexOf("[");
										var index2 = nomenclature.lastIndexOf("]");
										index1++;
										var id = nomenclature.substring(index1, index2);
										var count = document.getElementById('OtTabhdb').value;
										var alrady=0;
										for (var i = 0; i < count; i++) {
											if (document.getElementById('nomenclatureOtTab' + i) != null
													&& document.getElementById('nomenclatureOtTab' + i).value == nomenclature
													&& i != inc) {
													alert('This Prescription is already selected.');
													alrady++;
													document.getElementById('nomenclatureOtTab' + inc).value = "";
											}
											
										}
										/*var alPres= document.getElementById('alreadyPres' + inc).value;
										if(alPres=="Y"){
											alrady++;
										}*/
										if(alrady==0){
											var first = nomenclature.lastIndexOf("(");
											var second = nomenclature.lastIndexOf(")");
											first++;
											var itemId = val.substring(first, second);
											//alert("itemId "+itemId);
											var url = '/hms/hms/opd?method=showTaperdMedicine&nomenclature='+itemId+'&row='+inc+'&type=OT'+'&' + csrfTokenName + '='
											+ csrfTokenValue;
											openTaperedMedicine(url);
										}
									}
									 //added by govind on 28-10-2017 for Tapered Medicine end

							}
						}
					});
		}
	} else {
		document.getElementById('nomenclatureOtTab' + inc).value = "";
		document.getElementById('pvmsNoOtTab' + inc).value = "";
		document.getElementById('dosageOtTab' + inc).value = "";
		document.getElementById('noOfDaysOtTab' + inc).value = "";
		document.getElementById('unitOtTab' + inc).value = "";
	}
}

//added by govind 30-10-2017
function openTaperedMedicine(url) {
	/*submitForm('opdMain','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo);*/
	window.open(url,
					"opd_window",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
}		

function editTaperedMedicine(row,itemId){
//alert("editTaperedMedicine");
var url = '/hms/hms/opd?method=showTaperdMedicine&nomenclature='+itemId+'&'+getFormData('taperedForm')+'&taperedEdit=Y'+'&type=OT'+'&row='+row+'&' + csrfTokenName + '='
+ csrfTokenValue;
openTaperedMedicine(url);
}

function getFormData(formName) {
   var str="";
   inputs = eval('document.'+formName+'.elements');
   // alert(inputs.length);
   for(i=0;i<inputs.length;i++){
   	str=str+inputs[i].name+"="+inputs[i].value+"&"
   }
   return str;
}
//added by govind 30-10-2017


</script>
