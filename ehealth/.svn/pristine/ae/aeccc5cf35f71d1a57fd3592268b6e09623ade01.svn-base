<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
var dataTempNum = 0,dataTempNum2 = 0;
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
	function showBack(formName)
	{
	  obj = eval('document.'+formName)
	  obj.action = "/hms/hms/ot?method=showOtPostAnaesthesiaPatientSearchJsp";
	  obj.submit();
	}

<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(Calendar.YEAR);
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
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	List patientDetailList = new ArrayList();
	List departmentList = new ArrayList();

	if (map.get("patientDetailList") != null) {

		patientDetailList = (List) map.get("patientDetailList");

	}
	if (map.get("departmentList") != null) {

		departmentList = (List) map.get("departmentList");

	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String currentTime = (String) utilMap.get("currentTime");

	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}

	String yearlySrNo = "";
	if (map.get("yearlySrNo") != null) {
		yearlySrNo = (String) map.get("yearlySrNo");

	}
	String monthlySrNo = "";
	if (map.get("monthlySrNo") != null) {
		monthlySrNo = (String) map.get("monthlySrNo");

	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	OtBooking otbook = (OtBooking) patientDetailList.get(0);

	String patientName = "";
	if (otbook.getHin().getPFirstName() != null) {
		patientName = otbook.getHin().getPFirstName();
	}
	if (otbook.getHin().getPMiddleName() != null) {
		patientName = patientName + " "
				+ otbook.getHin().getPMiddleName();
	}
	if (otbook.getHin().getPLastName() != null) {
		patientName = patientName + " "
				+ otbook.getHin().getPLastName();
	}

	// String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());

	List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();
	if (map.get("anesthesiaList") != null) {
		anesthesiaList = (List<MasAnesthesia>) map
				.get("anesthesiaList");
	}

	List<OtPostAnaesthesiaProcedure> otPostAnaesthesiaProcedureList = new ArrayList<OtPostAnaesthesiaProcedure>();
	if (map.get("otPostAnaesthesiaProcedureList") != null) {
		otPostAnaesthesiaProcedureList = (List<OtPostAnaesthesiaProcedure>) map
				.get("otPostAnaesthesiaProcedureList");
	}
%>

<script type="text/javascript">
function get_valueForPACDeatil(patientId)
{
		<%if(otbook.getVisit()!=null){%>
   			var url="/hms/hms/ot?method=showPACDetailJsp&orderNo=<%=otbook.getOrderNo()%>&hinId=<%=otbook.getHin().getId()%>&visitId=<%=otbook.getVisit().getId()%>";
   			popwindowGravidagram(url);
   		<%}else if(otbook.getInpatient() !=null){%>
   			var url="/hms/hms/ot?method=showPACDetailJsp&orderNo=<%=otbook.getOrderNo()%>&hinId=<%=otbook.getHin().getId()%>&inpatientId=<%=otbook.getInpatient().getId()%>";
   			popwindowGravidagram(url);
   		<%}else{%>
   		var url="/hms/hms/ot?method=showPACDetailJsp&orderNo=<%=otbook.getOrderNo()%>&hinId=<%=otbook.getHin().getId()%>";
			popwindowGravidagram(url);
  <%}%>
}
 
 
 function popwindowGravidagram(url)
{

 newwindow=window.open(url,'name',"height=1000, width=1000, scrollbars=yes");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();
 //window.close();
}
</script>
<form name="dummyFormName" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<input type="hidden" name="otBookingId" id="otBooking" value="<%=otbook.getId()%>"/>
<input name="hospitalId" type="hidden" id="hospitalId" value="<%=hospitalId%>" />
</form>
<title>Post-Anesthesia Notes</title>
<form name="postAnesthesiaProcedure" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="titleBg">
<h2>Post Anesthesia Procedure Notes Entry</h2>
</div>
<div class="clear"></div>
<input type="hidden" name="otBookingId" id="otBookingId" value="<%=otbook.getId()%>">
<input type="hidden" name="bookingId" value="<%=otbook.getId()%>">

<div class="Block">
<label>Yearly Serial No.</label> <input	type="text" value="<%=yearlySrNo %>" name="yearlySlNo" readonly="readonly"  />
<label>Monthly Serial No.</label> <input type="text" value="<%=monthlySrNo %>" name="monthlySlNo" readonly="readonly"  />
<label>Date</label> <input	type="text" id="startDateId" class="date" name="<%=START_DATE%>" value="<%=currentDate %>" 
readonly="readonly" validate="Date,date,yes" maxlength="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"
			onclick="javascript:setdate('',document.postAnesthesiaProcedure.<%=START_DATE%>,event)" />
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<label>UHID</label> <%
 	if (otbook.getHin().getHinNo() != null) { %>
 	<input type="text" value="<%=otbook.getHin().getHinNo() %>" name="hinNo" id="hinNoUHID" readonly="readonly"/>
 <%	} else { %>  	<input type="text" value="-" name="hinNo" readonly="readonly"/> <%	} %>
  <label>Patient Name </label> <%
 	if (patientName != null) {
 %> <input type="text" value="<%=patientName %>" name="patName" readonly="readonly"/> <%
 	} else {
 %> <input type="text" value="-" name="patName" readonly="readonly"/> <%
 	}
 %> <label>Age</label> <%
 	if (otbook.getHin().getAge() != null) {%>
 		<input type="text" value="<%=otbook.getHin().getAge() %>" name="age" readonly="readonly"/>
 <%
 	} else {
 %><input type="text" value="-" name="age" readonly="readonly"/>  <%
 	}
 %> 
 
 <label>Gender</label> <%
 	if (otbook.getHin().getSex().getAdministrativeSexName()!= null) {%>
 		<input type="text" value="<%=otbook.getHin().getSex().getAdministrativeSexName() %>" name="gender" readonly="readonly"/>
 <%
 	} else {
 %><input type="text" value="-" name="gendr" readonly="readonly"/>  <%
 	}
 %> 
 
  
<label>Requisition No.</label> 
<input type="text" readonly="readonly" value=" <%=otbook.getOrderNo() %>" />
 
 <label>Patient Status </label> <%
 	if (otbook.getHin().getPatientStatus() != null) {
 %> 	<input type="text" value="<%=otbook.getHin().getPatientStatus() %>" name="age" readonly="readonly"/>
<%
 	} else {
 %> <input type="text" value="-" name="age" readonly="readonly"/><%
 	}
 %> <label>Reg.Date </label> <%
 	if (otbook.getHin().getRegDate()!= null) {
 %>
 <input type="text" value="<%=HMSUtil.changeDateToddMMyyyy(otbook.getHin().getRegDate())%>" name="regDate" readonly="readonly"/>
  <%
	} else {
%> <input type="text" value="-" name="regDate" readonly="readonly"/> <%
 	}
 %>

<label>PAC Details</label> <input type="button" name="yes"
	value="PAC Preview" class="button"
	onclick="submitForm('postAnesthesiaProcedure','/hms/hms/ot?method=printPAC&orderNo=<%=otbook.getOrderNo()%>','checkTargetForYes');" />
<input class="transparent" size="5" style="margin-left:5px;"/>
<label style="width:133px;">Risk Grade</label> <select name="risk_grade" id="risk1" class="small"
	class="date" tabindex="2">
	<option value="">Select</option>
	<option value="I">I</option>
	<option value="II">II</option>
	<option value="3">III</option>
	<option value="IV">IV</option>
</select>

<div class="clear"></div>
<h4>Surgery's</h4>
<div class="clear"></div>
<input tabindex="2" name="Add"	type="button" class="buttonAdd" value="" onclick="addRowForInvestigation();" /> 
<input tabindex="2" name="Delete" type="button" class="buttonDel" value="" onclick="removeRowForInvestigation();" />
<div class="clear"></div>
<table id="investigationGrid" class="cmntable">
	<tr>
		<th></th>
		<th scope="col">Surgery Name</th>
		<th scope="col">Surgery Code<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" /></th>
	</tr>

	<%
		int inc=1;
		if (otbook.getChargeCode() != null) {
	%>
	<tr>
		<td><input type="hidden" value="<%=otbook.getChargeCode().getId() %>" /><input type="radio" name="selectedSurgery" id="selectSurgery" /></td>
		<td><input type="text" size="43" readonly="readonly" 
			value="<%=otbook.getChargeCode().getChargeCodeName() %>[<%=otbook.getChargeCode().getId() %>]" /></td>

		<td><input type="text" size="10" readonly 
			value="<%=otbook.getChargeCode().getChargeCodeCode() %>" /></td>
	</tr>
	<%
		inc++;
	}%>
		<% if (otPostAnaesthesiaProcedureList != null) {
			for (Iterator iter = otPostAnaesthesiaProcedureList.iterator(); iter
					.hasNext();) {
				OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure = (OtPostAnaesthesiaProcedure) iter
						.next();

				Set<OtSurgeyPaSurgeyDetail> setS = new HashSet<OtSurgeyPaSurgeyDetail>();
				setS = otPostAnaesthesiaProcedure
						.getOtSurgeyPaSurgeyDetails();
				for (OtSurgeyPaSurgeyDetail surgeyPaSurgeyDetail : setS) {
	%>


	<tr>
		
		<td><input type="hidden"
			value="<%=surgeyPaSurgeyDetail.getChargeCode().getId() %>" /><input type="radio" name="selectedSurgery" id="selectSurgery" /></td>
		<td><input type="text" size="43" readonly="readonly"
			value="<%=surgeyPaSurgeyDetail.getChargeCode().getChargeCodeName() %>[<%=surgeyPaSurgeyDetail.getChargeCode().getId() %>]" /></td>

		<td><input type="text" size="10" readonly 
			value="<%=surgeyPaSurgeyDetail.getChargeCode().getChargeCodeCode() %>" /></td>
	</tr>
	<%
		}
			inc++;
			}
		}
	%>

	<tr>
		
	<td><input type="radio" name="selectedSurgery" id="selectSurgery" /></td>
	<td><input type="text" value="" tabindex="2" id="chargeCodeName1" size="43" name="chargeCodeName1"
		onblur="if(validateSurgeryAutoComplete(this.value,'1')){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillChargeCode&rowVal=1','chargeCodeVal1');}" />
	<div id="ac2update6" class="autocomplete"></div>
	<script type="text/javascript" language="javascript" charset="utf-8">
	  new Ajax.Autocompleter('chargeCodeName1','ac2update6','ot?method=getSurgeyForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
	</script></td>
	<td id="chargeCodeVal1"><input type="text" id="chargeCode1"	name="chargeCode1" size="10" readonly="" tabindex="2" /></td>
	</tr>
</table>

<div class="clear"></div>
<div class="paddingTop5"></div>

<h4>Anesthesiologist(s)</h4>
 
 <input tabindex="2" name="AddA" type="button" class="buttonAdd" value="" onclick="addRowForAnesthesiologist();" />
 <input tabindex="2" name="DeleteA" type="button" class="buttonDel" value="" onclick="removeRowForAnesthesiologist();" />

<table	id="anesthesiologistGrid" class="cmntable">
	<tr>

		<th scope="col">Anesthesiologist's Name</th>
	</tr>
	<%
		Set<OtBookSurgeon> setA = new HashSet<OtBookSurgeon>();
		setA = otbook.getOtBookSurgeons();
		String empName="";
		for (OtBookSurgeon otBookSurgeonA : setA) {
			if(otBookSurgeonA.getRole().startsWith("Anesthetist")){
			empName=otBookSurgeonA.getEmployee().getFirstName();
			if(otBookSurgeonA.getEmployee().getLastName() !=null){
				empName=empName+" "+otBookSurgeonA.getEmployee().getLastName();
			}
	%>
	<tr>
		<td><input type="hidden"
			value="<%=otBookSurgeonA.getEmployee().getId() %>" /><input tabindex="2" type="text" size="43" readonly
			value="<%=empName %>[<%=otBookSurgeonA.getEmployee().getId() %>]" /></td>

	</tr>
	<%
			}}
	%>
	<%String empName1="";
		if (otPostAnaesthesiaProcedureList != null) {
			for (Iterator iter = otPostAnaesthesiaProcedureList.iterator(); iter
					.hasNext();) {
				OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure = (OtPostAnaesthesiaProcedure) iter
						.next();

				Set<OtSurgeyPaAnesthesiologistDetail> setAA = new HashSet<OtSurgeyPaAnesthesiologistDetail>();
				setAA = otPostAnaesthesiaProcedure
						.getOtSurgeyPaAnesthesiologistDetails();
				for (OtSurgeyPaAnesthesiologistDetail surgeyPaAnesthesiologistDetail : setAA) {
					empName1=surgeyPaAnesthesiologistDetail.getEmployee().getFirstName();
					if(surgeyPaAnesthesiologistDetail.getEmployee().getLastName() !=null){
						empName1=empName1+" "+surgeyPaAnesthesiologistDetail.getEmployee().getLastName();
					}
	%>
	<tr>
		<td><input type="hidden"
			value="<%=surgeyPaAnesthesiologistDetail.getEmployee().getId() %>" /><input tabindex="2" type="text" size="43" readonly
			value="<%=empName1 %>[<%=surgeyPaAnesthesiologistDetail.getEmployee().getId() %>]" /></td>

	</tr>
	<%
		}
			}
		}
	%>
	<tr>

		<%
			int inc2 = 1;
		%>


		<td><input type="text" value="" tabindex="2" id="empName1"
			size="43" name="empName1"
			onblur="if(validateAnesthesiologistAutoComplete(this.value,'<%=inc2 %>')){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillEmpNameAnesthesiologist&rowVal=1','');}" />
		</td>
	</tr>
</table>
<div id="ac2update4" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('empName1','ac2update4','ot?method=getSergonForAutoComplete',{parameters:'requiredField=empName1'});
			</script><input type="hidden" value="1" name="hiddenValueAnesthesiologist"	id="hiddenValueAnesthesiologist" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<h4>Anesthesia Time</h4>
<div class="clear"></div>
<label>From</label> <input tabindex="2" onkeyup="mask(this.value,this,'2',':');"
	name="anaesthesia_from_time" type="text" maxlength="5"	id="anesthesiaFromTime"
	onblur="IsValidTime(this.value,'anesthesiaFromTime')" /> <label>To</label>
<input tabindex="2" name="anaesthesia_to_time" type="text" maxlength="5"  onkeyup="mask(this.value,this,'2',':');"
	id='anesthesiaToTime'
	onblur="IsValidTime(this.value,'anesthesiaToTime')" />
<div class="clear"></div>

<h4>Surgeon's</h4>
<div class="clear"></div>
<input tabindex="2"
	name="AddSurgeon" type="button" class="buttonAdd" value=""
	onclick="addRowForSurgeon();" /> <input tabindex="2"
	name="DeleteSurgeon" type="button" class="buttonDel" value=""
	onclick="removeRowForSurgeon();" />



<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="sergonGrid">
	<tr>

		<th scope="col">Surgeon's Name</th>

	</tr>
	<%
		Set<OtBookSurgeon> setSS = new HashSet<OtBookSurgeon>();
		setSS = otbook.getOtBookSurgeons();
		for (OtBookSurgeon otBookSurgeonSS : setSS) {
	%>
	<tr>
		<td><input type="hidden"
			value="<%=otBookSurgeonSS.getEmployee().getId() %>" />
		<%String surgName=""; 
		surgName=otBookSurgeonSS.getEmployee().getFirstName();
		
		if(otBookSurgeonSS.getEmployee().getLastName() !=null){
			surgName=surgName+" "+otBookSurgeonSS.getEmployee().getLastName();
		}
		%>
		
		<input tabindex="2" type="text" size="43" readonly
			value="<%=surgName %>[<%=otBookSurgeonSS.getEmployee().getId() %>]" /></td>

	</tr>
	<%
		}
	%>

	<%
		if (otPostAnaesthesiaProcedureList != null) {
			for (Iterator iter = otPostAnaesthesiaProcedureList.iterator(); iter
					.hasNext();) {
				OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure = (OtPostAnaesthesiaProcedure) iter
						.next();

				Set<OtBookSurgeon> set = new HashSet<OtBookSurgeon>();
				set = otbook.getOtBookSurgeons();
				for (OtBookSurgeon otBookSurgeon : set) {
	%>
	<tr>
		<td><input type="hidden" value="<%=otBookSurgeon.getEmployee().getId() %>"
			name="<%=EMPLOYEE_ID%>" />
			<%String surgnName=""; 
			surgnName=otBookSurgeon.getEmployee().getFirstName();
		
		if(otBookSurgeon.getEmployee().getLastName() !=null){
			surgnName=surgnName+" "+otBookSurgeon.getEmployee().getLastName();
		}
		%>
		<input type="text" size="43" readonly
			value="<%=surgnName %>[<%=otBookSurgeon.getEmployee().getId() %>]" /></td>

	</tr>
	<%
		}
	%>
	<%
		Set<OtSurgeyPaEmployeeDetail> setE = new HashSet<OtSurgeyPaEmployeeDetail>();
				setE = otPostAnaesthesiaProcedure
						.getOtSurgeyPaEmployeeDetails();
				for (OtSurgeyPaEmployeeDetail surgeyPaEmployeeDetail : setE) {
	%>
	<tr>
		<td><input type="hidden"
			value="<%=surgeyPaEmployeeDetail.getEmployee().getId() %>"
			name="<%=EMPLOYEE_ID%>" />
		<%String surgnNamee=""; 
		surgnNamee=surgeyPaEmployeeDetail.getEmployee().getFirstName();
		
		if(surgeyPaEmployeeDetail.getEmployee().getLastName() !=null){
			surgnNamee=surgnNamee+" "+surgeyPaEmployeeDetail.getEmployee().getLastName();
		}
		%>
		<input type="text" size="43" readonly
			value="<%=surgnNamee%>[<%=surgeyPaEmployeeDetail.getEmployee().getId() %>]" /></td>

	</tr>
	<%
		}
			}
		}
	%>
	<tr>

		<%
			int inc1 = 1;
		%>


		<td><input type="text" value="" tabindex="2" id="empNameS1"
			size="43" name="empNameS1"
			onblur="if(validateSergonAutoComplete(this.value,'<%=inc1 %>')){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillEmpNameSergon&rowVal=1','');}" />
		</td>
	</tr>



</table><div id="ac2update5"class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('empNameS1','ac2update5','ot?method=getSergonForAutoComplete',{parameters:'requiredField=empNameS1'});
			</script><input type="hidden" value="1" name="hiddenValueSergon"
			id="hiddenValueSergon" />
<div class="clear"></div>
<h4>Surgery Time</h4>
<div class="clear"></div>
<label>From</label> 
<input tabindex="2"	id="surgeryfromTime" name="surgey_from_time" type="text"
	onblur="IsValidTime(this.value,'surgeryfromTime')" onkeyup="mask(this.value,this,'2',':');"  maxlength="5"/>
<label>To</label><input name="surgey_to_time" id="surgertToTime" tabindex="2" type="text"
	onblur="IsValidTime(this.value,'surgertToTime')" maxlength="5"  onkeyup="mask(this.value,this,'2',':');"/>
<label>Anesthesia</label>
<select id="anesthesia_id" name="anesthesia_id"	validate="Anesthesia,string,no" tabindex="2" onchange="anesthesiaCheck();">
	<option value="0">Select</option>
	<%		for (MasAnesthesia masAnesthesia : anesthesiaList) {	%>
	<option value="<%=masAnesthesia.getId() %>"><%=masAnesthesia.getAnesthesiaName()%></option>
	<%
		}
	%>
</select>
<div class="clear"></div>
<h4>Premedication/ Induction/ Maintenance</h4> 
<div class="clear"></div>
<input	name="Add2" type="button" class="buttonAdd" value="" onclick="addRowForPremedication();" tabindex="2" /> 
<input	name="Delete" type="button" class="buttonDel" value="" onclick="removeRowForPremedication();" tabindex="2" />

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="premedicationGrid">
	<tr>
		<th scope="col">Type</th>
		<th scope="col">Item Name</th>
		<th scope="col">Item Code</th>
		<th scope="col">Dose</th>
		<th scope="col">Route</th>
		<th scope="col">Time</th>
	</tr>

	<%
		Set<OtPreAnaesthesiaProcNotesMain> setPrM = new HashSet<OtPreAnaesthesiaProcNotesMain>();
		setPrM = otbook.getOtPreAnaesthesiaProcNotesMains();
		if(setPrM !=null && setPrM.size() >0){
		for (OtPreAnaesthesiaProcNotesMain otr : setPrM) {
			Set<OtPreAnaesthesiaProNotesSub> setPrS = new HashSet<OtPreAnaesthesiaProNotesSub>();
			setPrS = otr.getOtPreAnaesthesiaProNotesSubs();
			
			for (OtPreAnaesthesiaProNotesSub OtPreAnaesthesiaProNotesSub : setPrS) {
				
	%>
	<tr>
		<td><input type="hidden"
			value="<%=OtPreAnaesthesiaProNotesSub.getStoreItem().getId() %>" /><input type="text" value="Premedication" size="10"
			readonly="readonly" /></td>

		<td><input type="text"
			value="<%=OtPreAnaesthesiaProNotesSub.getStoreItem().getNomenclature() %>"
			size="43" readonly="readonly" /></td>
		<td><input type="text"
			value="<%=OtPreAnaesthesiaProNotesSub.getStoreItem().getPvmsNo() %>"
			readonly="readonly" size="10" /></td>
		<td><input type="text"
			value="<%=OtPreAnaesthesiaProNotesSub.getDose()%>"
			readonly="readonly" size="10" /></td>
		<td><input type="text"
			value="<%=OtPreAnaesthesiaProNotesSub.getRoute()%>"
			readonly="readonly" size="5" />
			<script type="text/javascript">
				dataTempNum = <%=setPrS.size() %>;
			</script></td>
	</tr>
	<%
		}
		}}
	%>

	<%
		if (otPostAnaesthesiaProcedureList != null) {
			for (Iterator iter = otPostAnaesthesiaProcedureList.iterator(); iter
					.hasNext();) {
				OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure = (OtPostAnaesthesiaProcedure) iter
						.next();

				Set<OtSurgeyPaPremedicationDetail> surgeyPaPremedicationDetailSet = new HashSet<OtSurgeyPaPremedicationDetail>();
				surgeyPaPremedicationDetailSet = otPostAnaesthesiaProcedure
						.getOtSurgeyPaPremedicationDetails();
				for (OtSurgeyPaPremedicationDetail surgeyPaPremedicationDetail : surgeyPaPremedicationDetailSet) {
	%>
	<tr>
		<td><input type="hidden"
			value="<%=surgeyPaPremedicationDetail.getItem().getId() %>" />
		<%
			if (surgeyPaPremedicationDetail
								.getSurgeyPaPremedicationDetailType() != "p"
								|| surgeyPaPremedicationDetail
										.getSurgeyPaPremedicationDetailType()
										.equals("p")) {
		%> <input type="text" value="Premedication" readonly /> <%
 	} else if (surgeyPaPremedicationDetail
 						.getSurgeyPaPremedicationDetailType() != "i"
 						|| surgeyPaPremedicationDetail
 								.getSurgeyPaPremedicationDetailType()
 								.equals("i")) {
 %> <input type="text" value="Induction" readonly /> <%
 	} else if (surgeyPaPremedicationDetail
 						.getSurgeyPaPremedicationDetailType() != "m"
 						|| surgeyPaPremedicationDetail
 								.getSurgeyPaPremedicationDetailType()
 								.equals("m")) {
 %> <input type="text" value="Maintenance" readonly /> <%
 	} else {
 %> <label class="value">-</label> <%
 	}
 %></td>

		<td><input type="text"
			value="<%=surgeyPaPremedicationDetail.getItem().getNomenclature() %>"
			size="43" readonly="readonly" /></td>
		<td><input type="text"
			value="<%=surgeyPaPremedicationDetail.getItem().getPvmsNo() %>"
			readonly="readonly" size="10" /></td>
		<td><input type="text"
			value="<%=surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailDosa()%>"
			readonly="readonly" size="10" /></td>
		<td><input type="text"
			value="<%=surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailRoute()%>"
			readonly="readonly" size="5" /></td>
	</tr>
	<%
		}
			}
		}
	%>
	<tr>
		<td><select name="typePIM1" id="typePIM1" tabindex="2">
			<option value="">Select</option>
			<option value="p">Premedication</option>
			<option value="i">Induction</option>
			<option value="m">Maintenance</option>
		</select></td>
		<td><input type="text" value="" tabindex="2" id="nomenclaturePr1"
			size="43" name="nomenclaturePr1" onblur="populatePVMSPr1(this.value)" />
		</td>
		<td><input type="text" name="pvmsNoPr1" id="pvmsNoPr1" size="10"
			readonly="readonly" /></td>



		<td><input type="text" size="10" id="dv1" name="dv1"
			maxlength="20" tabindex="2" /></td>


		<td><select name="route1" id="route1" tabindex="2">
			<option value="">Select</option>
			<option value="1/V">1/V</option>
			<option value="1/M">1/M</option>
			<option value="Oral">Oral</option>
			<option value="S.C.">S.C.</option>
		</select></td>
		<td><input type="text" name="premedicateTime1" size="10" value="<%=currentTime %>" readonly="readonly" /></td>
	</tr>
</table>
<div id="ac2update3" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclaturePr1','ac2update3','ot?method=getItemPrListForAutoComplete',{parameters:'requiredField=nomenclaturePr1'});
			</script><input type="hidden" value="1" name="hiddenValuePremedication"
			id="hiddenValuePremedication" />
<div class="clear"></div>
</div><%---
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<h4>Procedure Details </h4>
<div class="clear"></div>
<div class="Block"><div class="clear"></div>
 <input name="AddP" type="button" class="buttonAdd" value="" onclick="addRowForProcedure();" tabindex="2" />
<input name="DeleteP" type="button" class="buttonDel" value="" onclick="removeRowForProcedure();" tabindex="2" />
<div class="clear"></div>
<table id="procedureGrid" class="cmntable">
	<tr>
		<th scope="col">Anesthesia</th>
		<th scope="col">Item Name</th>
		<th scope="col">Item Code</th>
		<th scope="col">Dose</th>
		<th scope="col">level</th>
		<th scope="col">Catheter</th>
	</tr>


	<%
		if (otPostAnaesthesiaProcedureList != null) {
			for (Iterator iter = otPostAnaesthesiaProcedureList.iterator(); iter
					.hasNext();) {
				OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure = (OtPostAnaesthesiaProcedure) iter
						.next();

				Set<OtSurgeyPaProcedureDetail> surgeyPaProcedureDetailSet = new HashSet<OtSurgeyPaProcedureDetail>();
				surgeyPaProcedureDetailSet = otPostAnaesthesiaProcedure
						.getOtSurgeyPaProcedureDetails();
				for (OtSurgeyPaProcedureDetail surgeyPaProcedureDetail : surgeyPaProcedureDetailSet) {
	%>
	<tr>

		<input type="hidden" value="<%=surgeyPaProcedureDetail.getItem().getId() %>" />
		<td><input type="text"	value="<%=surgeyPaProcedureDetail.getSurgeyPaProcedureDetailAnesthesia()%>" readonly="readonly" size="5" /></td>
		<td><input type="text"	value="<%=surgeyPaProcedureDetail.getItem().getNomenclature() %>" size="43" readonly="readonly" /></td>
		<td><input type="text" 	value="<%=surgeyPaProcedureDetail.getItem().getPvmsNo() %>"	readonly="readonly" size="10" /></td>
		<td><input type="text" value="<%=surgeyPaProcedureDetail.getSurgeyPaProcedureDetailDosa()%>" readonly="readonly" size="10" /></td>
		<td><input type="text" value="<%=surgeyPaProcedureDetail.getSurgeyPaProcedureDetailLevel()%>" readonly="readonly" size="5" /></td>
		<td><input type="text" value="<%=surgeyPaProcedureDetail.getSurgeyPaProcedureDetailCatheter()%>" readonly="readonly" size="5" /></td>
	</tr>
	<%
		}
			}
		}
	%>

	<tr>
		<td id=s1>-</td>

		<td id=s2 style="display: none;"><select name="anesthesia1" id="anesthesia1" tabindex="2" onchange="anesthesiaCobom();">
			<option value="">Select</option>
			<option value="EACath">EA + Cath</option>
			<option value="RA">RA</option>
			<option value="SA">SA</option>
			<option value="Caudal">Caudal</option>
			<option value="EA">EA</option>


		</select></td>

		<td><input type="text" value="" tabindex="2" id="nomenclatureP1"
			size="43" name="nomenclatureP1" onblur="populatePVMSP1(this.value)" />
		<div id="ac2update2" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclatureP1','ac2update2','ot?method=getItemPListForAutoComplete',{parameters:'requiredField=nomenclatureP1'});
			</script></td>

		<td><input type="text" name="pvmsNoP1" id="pvmsNoP1" size="10"
			readonly="readonly" /></td>

		<td><input type="text" size="10" id="d1" name="d1" maxlength="20"
			tabindex="2" /></td>

		<td id="s3">-</td>
		<td id="s4" style="display: none;"><select name="level1"
			id="level1" tabindex="2">
			<option value="">Select</option>
			<option value="L1-2">L1-2</option>
			<option value="L2-3">L2-3</option>
			<option value="L3-L4">L3-L4</option>

		</select></td>


		<td id="s5" style="display: none;"><select name="level1"
			id="level1" tabindex="2">
			<option value="">Select</option>
			<option value="T1-2">T1-2</option>
			<option value="T2-3">T2-3</option>
			<option value="T3-4">T3-4</option>
			<option value="T4-5">T4-5</option>
			<option value="T5-6">T5-6</option>
			<option value="T6-7">T6-7</option>
			<option value="T8-L1">T8-L1</option>
			<option value="L1-L2">L1-L2</option>
			<option value="L2-L3">L2-L3</option>
			<option value="L3-L4">L3-L4</option>
		</select></td>


		<td><input type="text" size="10" id="c1" name="c1" maxlength="20" 	tabindex="2" /></td>
		<input type="hidden" value="1" name="hiddenValueProcedure"	id="hiddenValueProcedure" />
	</tr>
</table><div class="clear"></div>
</div>--%>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>ETT/ LMA</label> <select name="ett_lma" id="ett_lma" tabindex="2">
	<option value="">Select</option>
	<option value="e">ETT Size</option>
	<option value="l">LMA Size</option>

</select> <input name="ett_lma_text" type="text" maxlength="7"
	validate="ETT/ LMA Text,num,no" tabindex="2" />

<div class="clear"></div>
<h4>Monitoring</h4>
<div class="clear"></div>
<div class="paddingTop5"></div>
<input type="button" value="Patient History" class="buttonBig" onclick="showPatientHistory();" />
<!-- <input type="button" value="Medicine Advised" class="buttonBig" onclick="getMedicineDetails();" /> -->
<div class="clear"></div>
 
<label>NIBP</label> <input
	name="nibp" type="text" tabindex="2" maxlength="7" /> <label
	class="smallAuto">mm Hg </label>

<label>CVP</label> <input class="auto5" name="cvp" type="text" tabindex="2"
	maxlength="3" /> <label class="smallAuto">cm H<sub>2</sub>O </label> 
<div class="clear"></div>
	<label>Temp</label> <input name="temp" type="text" size="5"
	tabindex="2" maxlength="15" />

<label>O<sub>2</sub></label> <input name="sp02" type="text"
	tabindex="2" maxlength="15" /> <label> BP</label> <input name="labp"
	type="text" tabindex="2" maxlength="7" /> <label class="smallAuto">mm
Hg </label>
<div class="clear"></div>
<label>UO</label> <input name="uo" type="text" tabindex="2"
	maxlength="3" /> <label class="smallAuto">ml</label>

<label>Patient Position</label>
<select name="patientPosition" id="patientPositionId">
<option value="">Select</option>
<option value="S">Supine</option>
<option value="P">Propped Up</option>
<option value="T">Trendelen</option>
<option value="L">LATER</option>
</select>
<label>Care Of</label>
<select name="careOf" id="careOfId" class="multiple" multiple="multiple" size="5">
<option value="">Select</option>
<option value="IV Line">IV Line</option>
<option value="Central Line apidural">Central Line apidural</option>
<option value="Central Line apidural">Central Line apidural</option>
<option value="RYLES Tube">RYLES Tube</option>
<option value="Foley Catheter">Foley Catheter</option>
</select>

<h4>PAIN MANAGEMENT</h4>
<input type="button" value="Periscope Reading" class="buttonBig" onclick="showPatientAllReading();" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="paddingTop5"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="periscopeGrid">
	<tr>
		<th scope="col">Effective Part</th>
		<th scope="col">Periscope Scale</th>
		<th scope="col">Type of Pain</th>
		
		
	</tr>
<tr>
		<td><input type="text" name="bodyPart" id="bodyPart" value=""  size="50" /></td>
		<td><select name="periscopeValue" id="periscopeValue" tabindex="2" onchange="getperiscopeName(this.value);" >
			<option value="">Select</option>
			<option value="0">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
			<option value="10">10</option>
		</select></td>
			<td><input type="text" value="" name="periscopeName" id="periscopeName" 
		    size="10"	readonly="readonly" size="10" /></td>
	
	</tr>

</table>

<input	name="Add2" type="button" class="buttonAdd"  onclick="addPeriscopeReading('postAnesthesiaProcedure');" tabindex="2" value="" /> 
<!-- <input	name="Delete" type="button" class="buttonDel" value="" onclick="removeRowForPremedication();" tabindex="2" /> -->

</div>
<div class="clear"></div>
<div class="painManagement" name="painManagement" id="painManagement">
 </div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<h4>IV Fluids </h4>
<div class="Block"><div class="clear"></div>
<input name="Add4" type="button"
	class="buttonAdd" value="" onclick="addRowForFluids();" tabindex="2" />
<input name="Delete4" type="button" class="buttonDel" value=""
	onclick="removeRowForFluids();" tabindex="2" />
<div class="clear"></div>
<table id="fluidsGrid" width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>

		<th scope="col">Item Name</th>
		<th scope="col">Item Code</th>
		<th scope="col">Fluid Name</th>
		<th scope="col">Volume (ml)</th>
	</tr>

	<%
		if (otPostAnaesthesiaProcedureList != null) {
			for (Iterator iter = otPostAnaesthesiaProcedureList.iterator(); iter
					.hasNext();) {
				OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure = (OtPostAnaesthesiaProcedure) iter
						.next();

				Set<OtSurgeyPaIvFluidsDetail> surgeyPaIvFluidsDetailSet = new HashSet<OtSurgeyPaIvFluidsDetail>();
				surgeyPaIvFluidsDetailSet = otPostAnaesthesiaProcedure
						.getOtSurgeyPaIvFluidsDetails();
				for (OtSurgeyPaIvFluidsDetail surgeyPaIvFluidsDetail : surgeyPaIvFluidsDetailSet) {
	%>

	<tr>
		<td><input type="hidden"
			value="<%=surgeyPaIvFluidsDetail.getItem().getId() %>" /><input type="text"
			value="<%=surgeyPaIvFluidsDetail.getItem().getNomenclature() %>"
			size="43" readonly="readonly" /></td>
		<td><input type="text"
			value="<%=surgeyPaIvFluidsDetail.getItem().getPvmsNo() %>"
			readonly="readonly" size="10" /></td>
		<td><input type="text"
			value="<%=surgeyPaIvFluidsDetail.getSurgeyPaIvFluidsDetailFluidsName()%>"
			readonly="readonly" size="10" /></td>
		<td><input type="text"
			value="<%=surgeyPaIvFluidsDetail.getSurgeyPaIvFluidsDetailVolume()%>"
			readonly="readonly" size="5" />
			<script type="text/javascript">
				dataTempNum2 = <%=surgeyPaIvFluidsDetailSet.size() %>;
			</script></td>


	</tr>

	<%
		}
			}
		}
	%>
	<tr>


		<td><input type="text" value="" tabindex="2" id="nomenclature1"
			size="43" name="nomenclature1" onblur="populatePVMS(this.value)" />
		</td>
		<td><input type="text" name="pvmsNo1" id="pvmsNo1" size="10" readonly="" /></td>
		<td><input name="fluidName1" id="fluidName1" type="text" size="10" maxlength="30" tabindex="2" /></td>

		<td><input type="text" size="5" id="v1" name="v1" maxlength="3"	validate="Volume,num,no" tabindex="2" /></td>
	</tr>
</table><div id="ac2update1" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature1','ac2update1','ot?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature1'});
			</script><input type="hidden" value="1" name="hiddenValueFluids"	id="hiddenValueFluids" />
<div class="clear"></div>
</div>
<div class="paddingTop15"></div>
<h4>Reversal</h4>
<div class="clear"></div>
<div class="Block"><label>Neostigmine</label> <input
	name="neostigmine" type="text" tabindex="2" maxlength="7" class="auto4"
	validate="Neostigmine,num,no" /> <label class="smallAuto">mg</label> <label
	class="">Glycophyrrolate</label> <input name="glycophyrrolate"
	type="text" tabindex="2" maxlength="7"
	validate="Glycophyrrolate,num,no" /> <label class="smallAuto">mm</label>

<label>Others</label> <input name="others" type="text" tabindex="2"
	maxlength="7" validate="Others Reversal,num,no" /> 

<div class="clear"></div>
<label>Recovery</label>
<textarea maxlength="200" onkeyup="return ismaxlength(this)" class="textareaMediua"
	name="recovery" cols="0" rows="0" tabindex="2"></textarea>

<label>E/ Others</label> <select
	name="e_others" id="eo1" tabindex="2">
	<option value="">Select</option>
	<option value="e">E</option>
	<option value="o">Others</option>

</select> 
<label>Level of Anesthesia</label>
<textarea rows="8" cols="10" maxlength="20" name="levelOfAnesthesia" class="textareaMediua"></textarea>

<div class="clear"></div>
<label>Remarks</label> <textarea maxlength="100" class="textareaMediua"
	onkeyup="return ismaxlength(this)" name="remarks" cols="0" rows="0"
	tabindex="2"></textarea>
<div class="clear"></div>
<h4>Discharge Vitals</h4>
<div class="clear"></div>

<!-- <label>Height</label>
<input type="text" name="height" id="height" value="" />
<label>Weight</label>
<input type="text" name="weight" id="weight" value="" onblur="calculateBmi();" />
<label>Bmi</label>
<input type="text" name="bmi" id="bmi" value="" />
<div class="clear"></div>
<label>Bmi Status</label>
<input type="text" name="bmicat" readonly="readonly" id="bmicat" value="" />
 -->
 <label>ECG</label> <input name="ecg"
	type="text" tabindex="2" maxlength="15" />
<label>Pulse</label>
<input type="text" name="Pulse" id="Pulse" value="" />
<label>BP</label>
<input type="text" name="BP" id="BP" value="" />
<div class="clear"></div>
<label>Respiratory Rate</label>
<input type="text" name="resp" id="resp" value="" />
<label>Remarks</label>
<textarea name="reamarksForDisschargeVitals" class="textareaMediua" style="width:353px !important;">

</textarea>
</div>
<div class="clear"></div>
<input type="button" name="Submit" class="button" value="Sign Out"
	onclick="submitForm ('postAnesthesiaProcedure','ot?method=submitOtPostAnesthesiaProcedure')" />
<input type="button" name="Search" class="button" value="Search"
	onclick="submitForm ('postAnesthesiaProcedure','ot?method=searchOtPostAnesthesiaProcedure')" />
<input type="button" name="Back" class="button" value="Back"
	onclick="showBack('postAnesthesiaProcedure')" />
<div class="clear"></div>
<div class="division"></div>


<!--Bottom labels starts--> 
<input name="userName" id="userName" type="hidden" value="<%=userName %>" /> <input type="hidden"name="orderNo" value="<%=otbook.getOrderNo() %>"/>
<input name="hinId" type="hidden" value="<%=otbook.getHin().getId()%>" /> <input name="departmentId" type="hidden"
	value="<%=otbook.getDepartment().getId()%>" />
 <%	if (otbook.getVisit() != null) {%>
 <input name="visitId" type="hidden" value="<%=otbook.getVisit().getId()%>" /> <%	} else if (otbook.getInpatient() != null) {
 %> <input name="inpatientId" type="hidden" value="<%=otbook.getInpatient().getId()%>" /> <%
 	}
 %> <input name="hospitalId" type="hidden" value="<%=hospitalId%>" /> <input name="changedDate" type="hidden" value="<%=currentDate %>" />
	 <input	name="changedTime" type="hidden" value="<%=currentTime %>" />
<div class="bottom"><label>Changed By </label> <label class="value"><%=userName%></label>
<label>Changed Date </label> <label	class="value"><%=currentDate%></label>
<label>Changed Time </label> <label	class="value"><%=currentTime%></label>

<div class="clear"></div>
<div class="paddingTop40"></div>
</div>
</form>

<script type="text/javascript" language="javascript">

//----------------------------------------------  Premedication-------------------------	
		function populatePVMSPr1(val){
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvmsNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var brandName=val.substring(0,indexForBrandName);
	 
	  if(pvmsNo == "")
	  {
	   	document.getElementById('nomenclaturePr1').value="";
	    document.getElementById('pvmsNoPr1').value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNoPr1').value=pvmsNo
	 }
	}	
function addRowForPremedication(){
		
	  var tbl = document.getElementById('premedicationGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValuePremedication');
	  hdb.value=iteration+1

 	var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('Select');
	   e1.name='typePIM'+(iteration+1);
	  e1.id='typePIM'+(iteration+1);
	  e1.classname='smalllabel'
	   e1.options[0] = new Option('Select', '');
	   e1.options[1] = new Option('Premedication', 'p');
	   e1.options[2] = new Option('Induction', 'i');
	   e1.options[3] = new Option('Maintenance', 'm');
	  	   
	   cellRight1.appendChild(e1); 
	 
	
    var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
	  						
                   var val=e0.value
                   if(val != "")
		{
    	
	    var index1 = val.lastIndexOf("[");
	    var indexForPvms=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForPvms=indexForPvms--;
	    var nomenclature=val.substring(0,indexForPvms);
	   	 if(pvmsNo =="")
	    {
	    		document.getElementById('nomenclaturePr'+(iteration+1)).value="";
							document.getElementById('pvmsNoPr'+(iteration+1)).value="";
	     return;
	    }
	    else
  						document.getElementById('pvmsNoPr'+(iteration+1)).value=pvmsNo
	   }
			  };
	  e0.name = 'nomenclaturePr' + (iteration+1);
	  e0.id = 'nomenclaturePr' + (iteration+1);
	 
	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclaturePr'+(iteration+1),'ac2update3','ot?method=getItemPrListForAutoComplete',{parameters:'requiredField=nomenclaturePr'+(iteration+1)});
	
	  
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoPr'+(iteration+1);
	  sel.id='pvmsNoPr'+(iteration+1)
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	 
	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'dv' + (iteration+1);
	  e3.id = 'dv' + (iteration+1);
	  e3.size = '10'
	  cellRight3.appendChild(e3);
	 
	 var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('Select');
	 
	  e4.name='route'+(iteration+1);
	  e4.id='route'+(iteration+1);
	  e4.classname='smalllabel'
	   e4.options[0] = new Option('Select', '');
	   e4.options[1] = new Option('1/V', '1/V');
	   e4.options[2] = new Option('1/M', '1/M');
	   e4.options[3] = new Option('Oral', 'Oral');
	    e4.options[4] = new Option('S.C.', 'S.C.');
	   cellRight4.appendChild(e4);
	   
	      var cellRight3 = row.insertCell(5);
		  var e5 = document.createElement('input');
		  e5.type = 'text';
		  e5.name = 'premedicateTime' + (iteration+1);
		  e5.id = 'premedicateTime' + (iteration+1);
		  e5.size = '10'
		  e5.value='<%=currentTime%>'
		  cellRight3.appendChild(e5); 
	 
	}
	function removeRowForPremedication()
	{
	  var tbl = document.getElementById('premedicationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > dataTempNum+1) 
	  {
	  tbl.deleteRow(lastRow - 1);
	  var hdb = document.getElementById('hiddenValuePremedication');
	  hdb.value=lastRow - 1;
	  }
	}	
	
</script>
<script type="text/javascript" language="javascript">
	
	//-------------------------------Procedure --------------------------------
	
		function populatePVMSP1(val){
		//alert("in method--")
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvmsNoP = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var brandName=val.substring(0,indexForBrandName);
	 
	  if(pvmsNoP == "")
	  {
	   	document.getElementById('nomenclatureP1').value="";
	    document.getElementById('pvmsNoP1').value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNoP1').value=pvmsNoP
	 }
	}	
	
<%---
function addRowForProcedure(){
		
	  var tbl = document.getElementById('procedureGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValueProcedure');
	  hdb.value=iteration+1
	 
 	var val = document.getElementById('anesthesia_id').value;
	if(val != 0){
 	var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('Select');
	 
	  e1.name='anesthesia'+(iteration+1);
	  e1.id='anesthesia'+(iteration+1);
	  e1.classname='smalllabel'
	   e1.options[0] = new Option('Select', '');
	   e1.options[1] = new Option('SA', 'SA');
	   e1.options[2] = new Option('EACath', 'EACath');
	   e1.options[3] = new Option('EA', 'EA');
	   e1.options[4] = new Option('RA', 'RA');
	   e1.options[5] = new Option('Caudal', 'Caudal');
	        	   
	           cellRight1.appendChild(e1); 	   
	        	   e1.onblur=function(){
	  						
                    var val=e1.value
                    if(val == "SA")
			{
	    		var cellRight0 = row.insertCell(1);
					var e0 = document.createElement('input');
						e0.type = 'text';
						e0.name = 'nomenclatureP' + (iteration+1);
						e0.id = 'nomenclatureP' + (iteration+1);
						e0.value='Bupivacaie HCL Inj 0.5% heavy amp of 4ml [010116]'
						e0.size = '43'
					cellRight0.appendChild(e0);
		    						    
						var cellRightSel = row.insertCell(2);
						var sel = document.createElement('input');
						sel.type = 'text';
						sel.name='pvmsNoP'+(iteration+1);
				  sel.id='pvmsNoP'+(iteration+1)
				  sel.value='010116'
				  sel.size = '10'
				  cellRightSel.appendChild(sel);
				  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'd' + (iteration+1);
	  e3.id = 'd' + (iteration+1);
	  e3.size = '10'
	  cellRight3.appendChild(e3);
								
	 var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('Select');
	 
	  e4.name='level'+(iteration+1);
	  e4.id='level'+(iteration+1);
	  e4.classname='smalllabel'
	   e4.options[0] = new Option('Select', '');
	   e4.options[1] = new Option('L1-2', 'L1-2');
	   e4.options[2] = new Option('L2-3', 'L2-3');
	   e4.options[3] = new Option('L3-4', 'L3-4');
	   cellRight4.appendChild(e4); 

	 	 
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'c' + (iteration+1);
	  e5.id = 'c' + (iteration+1);
	
	  e5.size = '10'
	  cellRight5.appendChild(e5);
	   
  }
	   else if(val == "EA")
	   {
	   var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'nomenclatureP' + (iteration+1);
	  e0.id = 'nomenclatureP' + (iteration+1);
	  e0.value='Bupivacaine HCL 0.5% vial of 20 ml[010115]'
	  e0.size = '43'
	  cellRight0.appendChild(e0);
	
	
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoP'+(iteration+1);
	  sel.id='pvmsNoP'+(iteration+1)
	    sel.value='010115'
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	  
	  											
	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'd' + (iteration+1);
	  e3.id = 'd' + (iteration+1);
	  e3.size = '10'
	  cellRight3.appendChild(e3);
	  
  	 var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('Select');
	 
	  e4.name='level'+(iteration+1);
	  e4.id='level'+(iteration+1);
	  e4.classname='smalllabel'
	   e4.options[0] = new Option('Select', '');
	     
	    e4.options[1] = new Option('T1-2', 'T1-2');
	   e4.options[2] = new Option('T2-3', 'T2-3');
	     e4.options[3] = new Option('T3-4', 'T3-4');
	   e4.options[4] = new Option('T4-5', 'T4-5');
	   e4.options[5] = new Option('T6-7', 'T6-7');
	     e4.options[6] = new Option('T8-L1', 'T8-L1');
	   e4.options[7] = new Option('L1-2', 'L1-2');
	   e4.options[8] = new Option('L2-3', 'L2-3');
	   e4.options[9] = new Option('L3-4', 'L3-4');
	   cellRight4.appendChild(e4); 
	 	 
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'c' + (iteration+1);
	  e5.id = 'c' + (iteration+1);
	
	  e5.size = '10'
	  cellRight5.appendChild(e5);	   
						   
						   
	   }
	   else if(val=="Caudal")
	   {
		var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'nomenclatureP' + (iteration+1);
	  e0.id = 'nomenclatureP' + (iteration+1);
	  e0.value='Bupivacaine HCL 0.5% vial of 20 ml[010115]'
	  e0.size = '43'
	  cellRight0.appendChild(e0);
	
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoP'+(iteration+1);
	  sel.id='pvmsNoP'+(iteration+1)
	  sel.value='010115'
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	  
	  
	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'd' + (iteration+1);
	  e3.id = 'd' + (iteration+1);
	  e3.size = '10'
	  cellRight3.appendChild(e3);
	 
  	var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	 
	  e4.name='level'+(iteration+1);
	  e4.id='level'+(iteration+1);
	   e4.value='-';
	e4.size = '2'
 	cellRight4.appendChild(e4); 
 
  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'c' + (iteration+1);
	  e5.id = 'c' + (iteration+1);
	
	  e5.size = '10'
	  cellRight5.appendChild(e5);	

   }
   else
   {
						   
	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
	  						
       var val=e0.value
        if(val != "")
	{
   	
    var index1 = val.lastIndexOf("[");
    var indexForPvms=index1;
    var index2 = val.lastIndexOf("]");
    index1++;
    var pvmsNo = val.substring(index1,index2);
    var indexForPvms=indexForPvms--;
    var nomenclature=val.substring(0,indexForPvms);
   	 if(pvmsNo =="")
    {
    		document.getElementById('nomenclatureP'+(iteration+1)).value="";
			document.getElementById('pvmsNoP'+(iteration+1)).value="";
     return;
    }
    else
 			document.getElementById('pvmsNoP'+(iteration+1)).value=pvmsNo
   }
	  					  };
	  e0.name = 'nomenclatureP' + (iteration+1);
	  e0.id = 'nomenclatureP' + (iteration+1);
	 
	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclatureP'+(iteration+1),'ac2update2','ot?method=getItemPListForAutoComplete',{parameters:'requiredField=nomenclatureP'+(iteration+1)});
	  
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoP'+(iteration+1);
	  sel.id='pvmsNoP'+(iteration+1)
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
						   
				  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'd' + (iteration+1);
	  e3.id = 'd' + (iteration+1);
	  e3.size = '10'
	  cellRight3.appendChild(e3);
	 
	  	var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	 
	  e4.name='level'+(iteration+1);
	  e4.id='level'+(iteration+1);
	   e4.value='-';
	e4.size = '2'
	
	 cellRight4.appendChild(e4); 
	 	 
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'c' + (iteration+1);
	  e5.id = 'c' + (iteration+1);
	
	  e5.size = '10'
	  cellRight5.appendChild(e5);
						   
	}
 };
	}
	else
	{
	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	 
	  e1.name='anesthesia'+(iteration+1);
	  e1.id='anesthesia'+(iteration+1);
	  e1.value='-';
	  e1.size = '2'
	   cellRight1.appendChild(e1); 
	 
	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
	  						
         var val=e0.value
         if(val != "")
		{
    	
	    var index1 = val.lastIndexOf("[");
	    var indexForPvms=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForPvms=indexForPvms--;
	    var nomenclature=val.substring(0,indexForPvms);
	   	 if(pvmsNo =="")
	    {
	    		document.getElementById('nomenclatureP'+(iteration+1)).value="";
							document.getElementById('pvmsNoP'+(iteration+1)).value="";
	     return;
	    }
	    else
  						document.getElementById('pvmsNoP'+(iteration+1)).value=pvmsNo
	   }
			  };
	  e0.name = 'nomenclatureP' + (iteration+1);
	  e0.id = 'nomenclatureP' + (iteration+1);
	 
	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclatureP'+(iteration+1),'ac2update2','ot?method=getItemPList',{parameters:'requiredField=nomenclatureP'+(iteration+1)});
	  
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoP'+(iteration+1);
	  sel.id='pvmsNoP'+(iteration+1)
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	   
	     var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'd' + (iteration+1);
	  e3.id = 'd' + (iteration+1);
	  e3.size = '10'
	  cellRight3.appendChild(e3);
	 
	  	var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	 
	  e4.name='level'+(iteration+1);
	  e4.id='level'+(iteration+1);
	   e4.value='-';
	e4.size = '2'
 cellRight4.appendChild(e4); 
 
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'c' + (iteration+1);
	  e5.id = 'c' + (iteration+1);
	
	  e5.size = '10'
	  cellRight5.appendChild(e5);
	 
	}
	
	}
	function removeRowForProcedure()
	{
	  var tbl = document.getElementById('procedureGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 1) 
	  {
	  tbl.deleteRow(lastRow - 1);
	  var hdb = document.getElementById('hiddenValueProcedure');
	  hdb.value=lastRow - 1;
	  }
	  
	  
	}	--%>
	

//-------------------------------IV  Fluids --------------------------------
		function populatePVMS(val){
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvmsNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var brandName=val.substring(0,indexForBrandName);
	  if(pvmsNo == "")
	  {
	   	document.getElementById('nomenclature1').value="";
	    document.getElementById('pvmsNo1').value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNo1').value=pvmsNo
	 }
	}	
	
function addRowForFluids(){
		
	  var tbl = document.getElementById('fluidsGrid');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValueFluids');
	  hdb.value=iteration+1	
	 
	 var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
	  						
	                       var val=e0.value
	                       if(val != "")
							{
					    	
						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);
						   	 if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclature'+(iteration+1)).value="";
	   								document.getElementById('pvmsNo'+(iteration+1)).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNo'+(iteration+1)).value=pvmsNo
						   }
	  					  };
	  					
	  e0.name = 'nomenclature' +(iteration+1);
	  e0.id = 'nomenclature' +(iteration+1);
	 
	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclature'+(iteration+1),'ac2update1','ot?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature'+(iteration+1)});
	  
	  var cellRightSel = row.insertCell(1);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNo'+(iteration+1);
	  sel.id='pvmsNo'+(iteration+1);
	  sel.size = '10';
	  sel.setAttribute("readonly","");
	  cellRightSel.appendChild(sel);
	 
	   var cellRight3 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'fluidName' + (iteration+1);
	  e3.id = 'fluidName' + (iteration+1);
	
	  e3.size = '10'
	  cellRight3.appendChild(e3);
	 
	 
	  var cellRight4 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'v' + (iteration+1);
	  e4.id = 'v' + (iteration+1);
	  e4.size = '5'
	  cellRight4.appendChild(e4);
	 
	}
	function removeRowForFluids()
	{
	  var tbl = document.getElementById('fluidsGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > dataTempNum2+1) 
	  {
	  tbl.deleteRow(lastRow - 1);
	  var hdb = document.getElementById('hiddenValueFluids');
	  hdb.value=lastRow- 1;
	  }
	}	
			
		</script>
<script type="text/javascript" language="javascript">
		
function validateSurgeryAutoComplete(strValue,inc ) {
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    if(id =="")
		    {
    			document.getElementById('chargeCodeName'+inc).value="";
  				document.getElementById('chargeCode'+inc).value="";
				return ;
 			}
 			return true;
		}	
		
		
function addRowForInvestigation(){
		
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration+1
	  
	  var cellRightSel = row.insertCell(0);
	  //cellRightSel.id='selectedSurgery';
	  var sel = document.createElement('input');
	  sel.type = 'radio';
	  sel.name='selectedSurgery';
	  sel.id='selectedSurgery'
	  cellRightSel.appendChild(sel);
	 
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.onblur=function(){
	  					if(validateSurgeryAutoComplete(this.value,(iteration+1))){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillChargeCode&rowVal='+(iteration+1),'chargeCodeVal'+(iteration+1));}
	  				};
	  		
	 				
	  e1.name = 'chargeCodeName' + (iteration+1);
	  e1.id = 'chargeCodeName' + (iteration+1);
	  e1.size = '43'
	  
	    var newdiv = document.createElement('div');
   		newdiv.setAttribute('id', 'ac2update6');
   		newdiv.className = "autocomplete";
   		newdiv.style.display = 'none';
       	//newdiv.style.padding-right = '10px';
		//newdiv.style.font-weight = 'normal';
   		//newdiv.style.background = '#FFF';
   		//newdiv.style.border = '1px solid #000';
        cellRight1.appendChild(newdiv);
	    cellRight1.appendChild(e1);
	
	  new Ajax.Autocompleter('chargeCodeName'+(iteration+1),'ac2update6','ot?method=getSurgeyForAutoComplete',{parameters:'requiredField=chargeCodeName'+(iteration+1)});
	 
	  var cellRightSel = row.insertCell(2);
	  cellRightSel.id='chargeCodeVal'+(iteration+1);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='chargeCode'+(iteration+1);
	  sel.id='chargeCode'+(iteration+1)
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	 
}
	function removeRowForInvestigation()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	   for(counter=0;counter<document.getElementsByName('selectedSurgery').length;counter++)
	   {
			 if (document.getElementsByName('selectedSurgery')[counter].checked == true) 
			  {
			  	tbl.deleteRow(counter+1);
			 	var hdb = document.getElementById('hiddenValue');
			 	hdb.value=lastRow- 1;
			 	
			  }
		}
		
	}	
	</script>
<script type="text/javascript" language="javascript">
//----------------------------- Surgeon -----------------------------
	
	function validateSergonAutoComplete( strValue1,inc1 ) {
 			 
 			var index1 = strValue1.lastIndexOf("[");
		    var index2 = strValue1.lastIndexOf("]");
		    index1++;
		    var id = strValue1.substring(index1,index2);
		    
		    if(id =="")
		    {
		    		document.getElementById('empNameS'+inc1).value="";
		    		
	   				return ;
 			}
 			
 			return true;
		}	
		
function addRowForSurgeon(){
		
	  var tbl = document.getElementById('sergonGrid');
	  var lastRow = tbl.rows.length;
	 
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdbS = document.getElementById('hiddenValueSergon');
	  hdbS.value=iteration+1
	 
	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e1.onblur=function(){
			
			if(validateSergonAutoComplete(this.value,(iteration+1))){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillEmpNameSergon&rowVal='+(iteration+1),''+(iteration+1));}
			
		  };
	  e1.name = 'empNameS' + (iteration+1);
	  e1.id = 'empNameS' + (iteration+1);
	  e1.size = '43'
	  cellRight1.appendChild(e1);
	new Ajax.Autocompleter('empNameS'+(iteration+1),'ac2update5','ot?method=getSergonForAutoComplete',{parameters:'requiredField=empNameS'+(iteration+1)});
	 
	 
	}
	function removeRowForSurgeon()
	{
	  var tbl = document.getElementById('sergonGrid');
	  var lastRow = tbl.rows.length;
		  if (lastRow > 1) 
	  {
	  tbl.deleteRow(lastRow - 1);
	  var hdb = document.getElementById('hiddenValueSergon');
	  hdb.value=lastRow- 1;
	  }
	}	
	</script>
<script type="text/javascript" language="javascript">
//-------------------- 		Anesthesiologist----------------------
	function validateAnesthesiologistAutoComplete( strValue2,inc2 ) {
 			 
 			var index1 = strValue2.lastIndexOf("[");
		    var index2 = strValue2.lastIndexOf("]");
		    index1++;
		    var id = strValue2.substring(index1,index2);
		    
		    if(id =="")
		    {
		    		document.getElementById('empName'+inc2).value="";
		    		
	   				return ;
 			}
 			return true;
		}	
		
		
function addRowForAnesthesiologist(){
		
	  var tbl = document.getElementById('anesthesiologistGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdbS = document.getElementById('hiddenValueAnesthesiologist');
	  hdbS.value=iteration+1
	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e1.onblur=function(){
	  						
			if(validateAnesthesiologistAutoComplete(this.value,(iteration+1))){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillEmpNameAnesthesiologist&rowVal='+(iteration+1),''+(iteration+1));}
			
		  };
	  e1.name = 'empName' + (iteration+1);
	  e1.id = 'empName' + (iteration+1);
	  //alert("name--"+e0.name)
	  e1.size = '43'
	  cellRight1.appendChild(e1);
	new Ajax.Autocompleter('empName'+(iteration+1),'ac2update4','ot?method=getAnesthesiologistForAutoComplete',{parameters:'requiredField=empName'+(iteration+1)});
	}
	function removeRowForAnesthesiologist()
	{
	  var tbl = document.getElementById('anesthesiologistGrid');
	  var lastRow = tbl.rows.length;
		  if (lastRow > 1) 
	  {
	  tbl.deleteRow(lastRow - 1);
	  var hdb = document.getElementById('hiddenValueAnesthesiologist');
	  hdb.value=lastRow- 1;
	  }
	}
	
	function anesthesiaCheck()
	{
	var val = document.getElementById('anesthesia_id').value;
	if(val != 0){
			document.getElementById('s1').style.display = 'none';
			document.getElementById('s2').style.display = 'block';
			}else{
			document.getElementById('s1').style.display = 'block';
			document.getElementById('s2').style.display = 'none';
			}
	}
		function anesthesiaCobom()
	{
	var val = document.getElementById('anesthesia1').value;
	if(val == "SA"){
			document.getElementById('s3').style.display = 'none';
			document.getElementById('s4').style.display = 'block';
			document.getElementById('s5').style.display = 'none';
	
			}
	else if(val == "EA"){
			document.getElementById('s3').style.display = 'none';
			document.getElementById('s4').style.display = 'none';
			document.getElementById('s5').style.display = 'block';

			}
			else {
			document.getElementById('s3').style.display = 'block';
			document.getElementById('s4').style.display = 'none';
			document.getElementById('s5').style.display = 'none';
			
			}
	}
	

	
</script>

<script>
function calculateBmi(){
	
	var height="";
	var weight="";
	var bmicat;
	height=document.getElementById('height').value;
	weight=document.getElementById('weight').value;
	
	 bmicat=(weight*10000/(height*height)).toFixed(2);
	 //alert("bmicat-->>"+bmicat);
	 document.getElementById('bmi').value=bmicat;
	 if(bmicat<18.5){
		 document.getElementById('bmicat').value="Underweight";
		 document.getElementById('bmicat').style.color='#F65C5C';
		 //$("#bmicat").css('color', '#F65C5C');
	}else if(bmicat>=18.5 && bmicat<25){
		document.getElementById('bmicat').value="Healthy Range";	
		document.getElementById('bmicat').style.color='green';
		//$("#bmicat").css('color', 'green');
	}else if(bmicat>=25 && bmicat<=30){
		document.getElementById('bmicat').value="Overweight";
		document.getElementById('bmicat').style.color='#574F4F';
		//$("#bmicat").css('color', '#574F4F');
	}else if(bmicat>=30 && bmicat<=35){
		document.getElementById('bmicat').value="Obese";
		document.getElementById('bmicat').style.color='#C40707';
		//$("#bmicat").css('color', '#C40707');
	}else if(bmicat>35){
		document.getElementById('bmicat').value="Severely obese ";
		document.getElementById('bmicat').style.color='#AD0C0C';
		//$("#bmicat").css('color', '#AD0C0C');
	}
}
function showPatientHistory(){
    //document.opdMain.action="/hms/hms/enquiry?method=showPatientDetails&hinNo="+hinNo;
    //document.opdMain.submit();
   // var visitId = document.getElementById("visitId").value;
   var hinNo=document.getElementById('hinNoUHID').value;
    var url='/hms/hms/enquiry?method=showPatientDetails&hinNo='+hinNo;;
    newwindow=window.open(url,'opd_window',"left=100,top=100,height=700,width=1024,status=1,scrollbars=yes,resizable=0");
    
 }
function showPatientAllReading(){
    //document.opdMain.action="/hms/hms/enquiry?method=showPatientDetails&hinNo="+hinNo;
    //document.opdMain.submit();
   // var visitId = document.getElementById("visitId").value;
    var hinNo=document.getElementById('hinNoUHID').value;
    var hospitalId=document.getElementById('hospitalId').value;
    var otBookingId = document.getElementById('otBookingId').value;
    var url='/hms/hms/ot?method=showPatientAllPeriscopeReading&hinNo='+hinNo+'&hospitalId='+hospitalId+'&otBookingId='+otBookingId;
    newwindow=window.open(url,'opd_window',"left=110,top=100,height=550,width=960,status=1,scrollbars=yes,resizable=0");
    
 }
</script>
<script>
function getperiscopeName(value){
	if(value==0){
		document.getElementById('periscopeName').value="No Pain";
		document.getElementById('periscopeName').style.color='#447F09';
	}
	if(value>=1&& value<=2 ){
		document.getElementById('periscopeName').value="Mild";	
		document.getElementById('periscopeName').style.color='#07FF07';
	}
	if(value>=3&& value<=4 ){
		document.getElementById('periscopeName').value="Moderate";
		document.getElementById('periscopeName').style.color='#FFD732';
	}
	if(value>=5&& value<=6 ){
		document.getElementById('periscopeName').value="Severe";
		document.getElementById('periscopeName').style.color='#FFA732';
	}
	if(value>=7&& value<=8 ){
		document.getElementById('periscopeName').value="Very Severe";
		document.getElementById('periscopeName').style.color='#FF5B32';
	}
	if(value>=9&& value<=10 ){
		document.getElementById('periscopeName').value="Worst";	
		document.getElementById('periscopeName').style.color='#EE0808';
	}
}
function addPeriscopeReading(formName){
	 
	  var periscopeValue = document.getElementById('periscopeValue').value;
	  var periscopeName = document.getElementById('periscopeName').value;
	  var bodyPart = document.getElementById('bodyPart').value;
	  var otBookingId = document.getElementById('otBooking').value;
	  
	  submitProtoAjaxWithDivNameForBilling('postAnesthesiaProcedure','/hms/hms/ot?method=saveOtPostAnaesthesiaReadingJsp&flag=s&periscopeValue='
			  +periscopeValue+'&periscopeName='+periscopeName+'&bodyPart='
			  +bodyPart+'&otBookingId='+otBookingId,'painManagement');
}
    var i = 0;
    function buttonClick() {
        document.getElementById('inc').value = ++i;
    }
   
    function savePeriscopePending(formName){
    	 var hospitalId=document.getElementById('hospitalId').value;
    	 var otBookingId = document.getElementById('otBookingId').value;
    	 submitProtoAjaxWithDivNameForBilling('postAnesthesiaProcedure','/hms/hms/ot?method=saveOtPostAnaesthesiaFinalReadingJsp&flag=m&otBookingId='+otBookingId,'painManagement');
    }

  
</script>