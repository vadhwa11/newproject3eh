<%@page import="jkt.hms.masters.business.MasCharityType"%>
<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<SCRIPT SRC="/hms/jsp/js/ssm.js" language="JavaScript1.2"></SCRIPT>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	
<script>
<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>

<%
	Patient patient=null;
 	Map<String, Object> map = new HashMap<String, Object>(); 
 	List<PhMemberSurvey> memberSurveys=new ArrayList<PhMemberSurvey>();
 	List<MasCharityType> masCharityTypes=new ArrayList<MasCharityType>();
 	List<Patient> membersPatientListDetail=new ArrayList<Patient>();
 	String message = "";
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}  	
	if(map.get("memberSurveys")!=null){ 
		memberSurveys = (List<PhMemberSurvey>)map.get("memberSurveys"); 	
	} 
	if(map.get("masCharityTypes")!=null){ 
		masCharityTypes = (List<MasCharityType>)map.get("masCharityTypes"); 	
	}
	if(map.get("patient")!=null){ 
		patient = (Patient)map.get("patient"); 	
	}
	if(map.get("membersPatientListDetail")!=null){ 
		membersPatientListDetail = (List<Patient>)map.get("membersPatientListDetail"); 	
	}
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}  
%>

<!--Block One Starts-->
<form name="searchPatientTransfer" action="" method="post">
	<%
	if(!message.equals("")){
		%>

	<h4>
		<span><%=message %></span>
	</h4>
	<div class="clear"></div>

	<%	}
%>
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
	<div class="clear"></div>
	<div class="titleBg">
		<h2>Patient Advance</h2>
	</div>
	<div class="clear"></div>
	<%
		if (patient != null) {
			String pFirstName = "";
			String pLastName = "";
			String PMiddleName = "";
			String gender = ""; 
			String familyId = "";
			String age = "";
			String patientType = "";
			String dueAmount="0";
			if (patient.getPFirstName() != null) {
				pFirstName = patient.getPFirstName();
			}
			if (patient.getPLastName() != null) {
				pLastName = patient.getPLastName();
			}
			if (patient.getPMiddleName() != null) {
				PMiddleName = patient.getPMiddleName();
			}
			if (patient.getSex() != null) {
				gender = patient.getSex().getAdministrativeSexName();
			}
			if (patient.getAge() != null) {
				age = patient.getAge();
			}
			if (patient.getFamily() != null) {
				familyId = patient.getFamily().getFamilyId();
			}
			if (patient.getPatientType() != null) {
				patientType = patient.getPatientType().getPatientTypeName();
			}
			if(patient.getPastDue()!=null){
				dueAmount=patient.getPastDue();
			}
	%>
	<h4>Patient Details</h4>
	<div class="Block">
		<input type="hidden" name="transferFrom" value="<%=patient.getId()%>"/>
		<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label><label
			class="value"><%=patient.getHinNo()%></label> <label>Patient
			Name</label> <label class="value"><%=pFirstName + " " + PMiddleName + " " + pLastName%></label>
		<label>Age</label> <label class="value"><%=age%></label>
		<div class="clear"></div>
		<label>Gender</label> <label class="value"><%=gender%></label> <label>Patient
			Category</label> <label class="valueAuto" style="color: black;"><%=patientType%></label><label>Family
			Id</label><label class="value"><%=familyId%></label>
		<div class="clear"></div>
	</div>
	<h4>Transfer To</h4>
	<div class="Block">
		<label>Family Member</label> <input type="radio" value="familyMember"
			name="transferTo" onclick="transferToDiv('0');" id="transferToFamilyId" checked="checked"/>
		<label>Charity Trust</label> <input type="radio" value="charityName"
			name="transferTo" onclick="transferToDiv('1');" id="transferToCharityId"/>
	</div>
	<div id="familyMemberDetail" style="display: show;">
		<h4>Family Member Details</h4>
		<div class="Block">
			<label>Family Id</label> <label class="value"><%=familyId%></label> <label>Members</label>
			<select name="familyMemberId" validate="Member,int,no" onChange="showUhidNo(this.value);"> 
				<option value="">Select</option>

				<%
				if(memberSurveys.size()>0){ 
				for(PhMemberSurvey member:memberSurveys){
					if(member.getName()!=null && (member.getId()!=patient.getMember().getId())){%>
				<option value="<%=member.getId()%>"><%=member.getName()%></option>
				<%}	
				}}
				%>
			</select>
			<%
			for(Patient memberPatient:membersPatientListDetail){%>
				<input type="hidden" value="<%=memberPatient.getHinNo()%>" id="memberUhno<%=memberPatient.getMember().getId()%>"/>
				<input type="hidden" value="<%=memberPatient.getId()%>" name="transferToMember<%=memberPatient.getMember().getId()%>"/>
			<%
			} 
			%>
			
			 <label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
			<input type="text" name="memberUhidNo" id="familyMemberUhid" readonly="readonly"/>
			<div class="clear"></div>
			<label>Mobile No</label> <input type="text" name="memberMobileNO" />
		</div>
	</div>
	<div id="charityDetail" style="display: none;">
		<h4>Charity Details</h4>
		<div class="Block">
			<label>Charity Name</label> <input type="text" name="charityName" id="charityNameId" value=""/>
			<label>Charity Type</label> <select name="charityType" id="charityTypeId">
				<option value="">Select</option>
				<%if(masCharityTypes.size()>0){
					for(MasCharityType charityType:masCharityTypes){%>
				<option value="<%=charityType.getId()%>"><%=charityType.getCharityTypeName()%></option>
				<%}
				} %>
			</select>
		</div>
	</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="Block">

		<label>Available Credit</label> <input type="text"
			name="availableCredit" readonly="readonly" value="<%=dueAmount%>"
			id="amountCredit" /> <label>Transfer Amount</label> <input
			type="text" name="transferAmount" id="amountTransfer"
			onblur="fillAmount();" /> <label>Balance Amount</label> <input
			type="text" name="balanceAmount" readonly="readonly"
			id="balanceAmount" />
		<!-- <label>Total Amount</label> <input
			type="text" name="totalAmount" /> -->
	</div>
	<div class="clear"></div>
	<input type="button" name="Submit" value="Submit" class="button"
		onclick="if(checkAllCondition()){submitForm('searchPatientTransfer','/hms/hms/opBilling?method=submitPatientAdvanceFamilyNCahrity')}" />
	<div class="paddingTop15"></div>

	<div class="clear"></div>
	<div id="error"></div>
	<%
		}
	%>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
<script type="text/javascript">
	function transferToDiv(val) {
		if (val == 0) {
			document.getElementById("familyMemberDetail").style.display = 'block';
			document.getElementById("charityDetail").style.display = 'none';

		} else if (val == 1) {
			document.getElementById("charityDetail").style.display = 'block';
			document.getElementById("familyMemberDetail").style.display = 'none';
		}
	}
	function fillAmount() { 
		var amountCr = document.getElementById("amountCredit").value;
		var amountTrans = document.getElementById("amountTransfer").value;
		if(amountTrans=='' || isNaN(amountTrans))
			{
			document.getElementById("amountTransfer").value='0.00';
			document.getElementById("balanceAmount").value='0.00';
			alert("Please Enter Valid amount");
			return;
			}
		if(parseFloat(amountTrans)<0)
			{
			document.getElementById("amountTransfer").value='0.00';
			document.getElementById("balanceAmount").value='0.00';
			alert("Amount is less than zero.");
			return;

			}
		else if(parseFloat(amountCr)<parseFloat(amountTrans))
			{
			document.getElementById("amountTransfer").value='0.00';
			document.getElementById("balanceAmount").value='0.00';
			alert("Amount is greater than available amount");
			return;

			}
		document.getElementById("balanceAmount").value = parseInt(amountCr) - parseInt(amountTrans);
	}
	function checkAllCondition() {
		var amountCr = document.getElementById("amountCredit").value;
		var amountTrans = document.getElementById("amountTransfer").value; 
		var transferToFamily = document.getElementById("transferToFamilyId"); 
		var familyMemberUhid = document.getElementById("familyMemberUhid").value; 
		var transferToCharity = document.getElementById("transferToCharityId");
		var charityName = document.getElementById("charityNameId").value; 
		var charityType = document.getElementById("charityTypeId").value; 
		if (parseFloat(amountCr) < parseFloat(amountTrans) || amountTrans=='') {
			alert("Transfer amount should not grater than credit amount")
			return false;
		}else if(transferToCharity.checked){ 
			if(charityName==null || charityName==''){
				alert("Charity Name Required");
				return false;
			}if(charityType==null || charityType==''){
				alert("Charity Type Required");
				return false;
			} 
			return true;
			
		}else if(transferToFamily.checked){ 
			if(familyMemberUhid==null || familyMemberUhid==''){
				alert("Member UHID No Required");
				return false;
			} 
			return true;
		}  
		else {
			alert("a");
			return true;
		}

	}
	function showUhidNo(value){ 
		if(document.getElementById("memberUhno"+value).value==null ||document.getElementById("memberUhno"+value).value=='')
			{
			alert("Please Register First Memeber For Uhid");
			return false;
			}
		else
			{
			document.getElementById("familyMemberUhid").value=document.getElementById("memberUhno"+value).value;
			return false;
			}
		  return true;
	}
</script>
