<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientVisitSearch.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By:
	 * @version 1.0
--%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="patientEnquirySearch1" action="" method="post"><script
	type="text/javascript" language="javascript">
	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		String time=String.valueOf(calendar.getTime());
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}%>
		 serverdate = '<%=date+"/"+month+"/"+year%>'
		function checkStartDate(){
		var sDate = document.patientEnquirySearch1.<%= FROM_DATE%>.value;
		var eDate = document.patientEnquirySearch1.<%= TO_DATE %>.value;
		var cDate = new Date();
		var month = cDate.getMonth() + 1
		var day = cDate.getDate()
		var year = cDate.getFullYear()
		var seperator = "/"
		var currentDate  = new Date(month + seperator + day + seperator + year);
		var	startDate =new Date(sDate.substring(6),(sDate.substring(3,5) - 1) ,sDate.substring(0,2))
		var endDate =new Date(eDate.substring(6),(eDate.substring(3,5) - 1) ,eDate.substring(0,2))
		if(sDate != "" && eDate != ""){
		if(endDate < startDate )
		{
			alert(" End Date should be greater than Start Date.");
			document.patientEnquirySearch1.<%= FROM_DATE%>.value = "";
			document.patientEnquirySearch1.<%= TO_DATE %>.value = "";
			return false;
		}else if(startDate < currentDate){
			alert(" Start Date should be greater than or equal to Current Date.");
			document.patientEnquirySearch1.<%= FROM_DATE%>.value = "";
			return false;
		}else if(endDate < currentDate){
			alert(" End Date should be greater than or equal to Current Date.");
			document.patientEnquirySearch1.<%= TO_DATE %>.value = "";
			return false;
		}
		}
		else
		{
			if(sDate=="" && eDate != "")
			{
			 alert("Registration from date should not be blank.");
			 return false;
			}
			else if(sDate!="" && eDate == "")
			{
			alert("Registration to date should not be blank.");
			 return false;
			}
		}

		return true;
	}

</script> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		List<MasRelation> relationList = new ArrayList<MasRelation>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();

	 	String currenDate = (String) utilMap.get("currentDate");
	 	String currentTime = (String) utilMap.get("currentTime");

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("serviceTypeList") != null){
			serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
		}
		if(map.get("rankList") != null){
			rankList= (List<MasRank>)map.get("rankList");
		}
		if(map.get("unitList") != null){
			unitList= (List<MasUnit>)map.get("unitList");
		}
		if(map.get("stateList") != null)	{
			stateList = (List<MasState>)map.get("stateList");
		}
		if(map.get("districtList") != null){
			districtList =(List<MasDistrict>)map.get("districtList");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<Patient>)patientMap.get("patientList");
		}
		if(map.get("relationList") != null)	{
			relationList = (List<MasRelation>)map.get("relationList");
		}
	%>

<div class="titleBg">
<h2>Patient Search</h2>
</div><input type="button" name="openButton" value="Ward Wise Patient"	class="buttonBig" onclick="openTokenDisplay()"/>
<div class="clear"></div>
<div class="Block">
<label> Reg. No.</label>
<input type="text" name="<%=HIN_NO %>" id="<%=HIN_NO %>" value="" MAXLENGTH="30" onchange="submitForm('patientEnquirySearch1','/hms/hms/enquiry?method=searchPatientForEnquiry');"/>
<script>
document.patientEnquirySearch1.<%=HIN_NO %>.focus();
</script>
<label>IPD No.</label>
<input type="text" name="<%=AD_NO%>" id="<%=AD_NO%>" value=""	MAXLENGTH="30" />
<label>Patient Name</label>
<input type="text"	name="<%=PATIENT_NAME %>" id="<%=PATIENT_NAME %>" onchange="checkNameLength(this.value,'Patient First Name')" value="" MAXLENGTH="30" />
<div class="clear"></div>
<label>Address</label>
<input type="text" name="<%=ADDRESS %>" id="<%=ADDRESS %>" onchange="checkNameLength(this.value,'Address')" value=""	MAXLENGTH="30" />
<label>Relative Name</label> <input type="text"	name="relativeName" id="relativeName" onchange="checkNameLength(this.value,'Relative Name')" value="" MAXLENGTH="30" />
<label>Relation</label>
<select name="patientRelation" id="patientRelation">
	<option value=0>Select Relation</option>
	<%
				for(MasRelation masRelation : relationList)
				{
				%>	
	<option value="<%=masRelation.getId()%>"><%=masRelation.getRelationName()%></option>
	<%
				}
				%>
</select>
<div class="clear"></div>
<label>Registration From Date</label>
<input type="text"	name="<%=FROM_DATE%>" id="<%=FROM_DATE%>" value="" class="date" readonly="readonly"	MAXLENGTH="30" />

<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="setdate('<%=currenDate %>',document.patientEnquirySearch1.<%=FROM_DATE%>,event);" />
<label>Registration To Date</label>
<input type="text" id="toDateId" name="<%=TO_DATE %>" value="" class="date" readonly="readonly"	MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date" class="calender"	onclick="javascript:setdate('<%=currenDate %>',document.patientEnquirySearch1.<%=TO_DATE%>,event)" />
<label>State</label>
<select name="<%=STATE_ID %>" id="<%=STATE_ID %>">
	<option value="0">Select State</option>
	<%
				for(MasState masState : stateList)
				{
				%>
	<option value="<%=masState.getId()%>"><%=masState.getStateName()%></option>
	<%
				}
				%>
</select>
<div class="clear"></div>
<label>Patient Status</label>
<select name="<%=PATIENT_STATUS %>" id="<%=PATIENT_STATUS %>">
	<!-- <option value="">All</option> -->
	<option value="0">Select</option>
	<option value="Out Patient">Out Patient</option>
	<option value="In Patient">In Patient</option>
	<option value="Expired">Expired</option>
</select>
<label>Village</label>
<input type="text" name="<%=VILLAGE%>" onchange="checkNameLength(this.value,'Village')" 	id="village" maxlength="40" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=VILLAGE%>','ac2update','common?method=getVillegeListForAutoComplete',{parameters:'requiredField=<%=VILLAGE%>'});
		</script>
<label>Police Station</label>
<input type="text"	name="<%=POLICE_STATION%>" id="<%=POLICE_STATION%>" onchange="checkNameLength(this.value,'Police Station')" maxlength="20" />
<div class="clear"></div>
<label>Mobile No.</label>
<input type="text" name="<%=MOBILE_NO%>"	id="<%=MOBILE_NO%>" onchange="checkNameLength(this.value,'Mobile Number')" maxlength="20" />
<div class="clear"></div>
</div>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
<div class="clear"></div>
<input type="button" name="Search"	onclick="if(checkEnquiryForm()){submitForm('patientEnquirySearch1','/hms/hms/enquiry?method=searchPatientForEnquiry');}"	value="Search" class="button" accesskey="a" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
</div>
<form name="patientEnquiry" method="post" action="">
<script	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"servNo"], [2,"hin"], [3,"patName"], [4,"patientType"], [5,"relativeName"], [6,"rank"], [7,"unit"], [8,"add"], [9,"village"], [10,"age"]];
	 statusTd = 10;
	</script>
<div class="clear"></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
<div class="clear"></div>
<script type="text/javascript" language="javascript">
	data_header = new Array();
	data_header[0] = new Array;
	data_header[0][0] = "Service No"
	data_header[0][1] = "hide";
	data_header[0][2] = "7%";
	data_header[0][3] = "servNo"

	data_header[1] = new Array;
	data_header[1][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";

	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patName";

	data_header[3] = new Array;
	data_header[3][0] = "Patient Type"
	data_header[3][1] = "data";
	data_header[3][2] = "10%";
	data_header[3][3] = "patientType"

	data_header[4] = new Array;
	data_header[4][0] = "Relative Name"
	data_header[4][1] = "data";
	data_header[4][2] = "15%";
	data_header[4][3] = "relativeName";

	data_header[5] = new Array;
	data_header[5][0] = "Rank"
	data_header[5][1] = "hide";
	data_header[5][2] = "10%";
	data_header[5][3] = "rank";

	data_header[6] = new Array;
	data_header[6][0] = "Unit"
	data_header[6][1] = "hide";
	data_header[6][2] = "10%";
	data_header[6][3] = "unit"

	data_header[7] = new Array;
	data_header[7][0] = "Address"
	data_header[7][1] = "hide";
	data_header[7][2] = "30%";
	data_header[7][3] = "add";

	data_header[8] = new Array;
	data_header[8][0] = "Village"
	data_header[8][1] = "data";
	data_header[8][2] = "30%";
	data_header[8][3] = "village";

	data_header[9] = new Array;
	data_header[9][0] = "Age"
	data_header[9][1] = "data";
	data_header[9][2] = "30%";
	data_header[9][3] = "age";


	data_arr = new Array();
	<%

	    int  counter=0;
	
		if (patientList != null && patientList.size() > 0) { %>

	<% 	for(Patient patient : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getId()%>
			data_arr[<%= counter%>][1] = ""
			data_arr[<%= counter%>][2] = "<%=patient.getHinNo()%>"
				<%
				  String parient_Name ="";
				  if(patient.getPFirstName()!=null)
				  {
					  parient_Name = patient.getPFirstName();
				  }
				  if(patient.getPMiddleName()!=null)
				  {
					  parient_Name = parient_Name+" "+patient.getPMiddleName();
				  }
				  if(patient.getPLastName()!=null)
				  {
					  parient_Name = parient_Name+" "+patient.getPLastName();
				  }
				%>
			data_arr[<%= counter%>][3] = "<%=parient_Name%> "
			<%
				if(patient.getPatientType() != null){
					
			%>
			data_arr[<%= counter%>][4] = "<%=patient.getPatientType().getPatientTypeName()%>";
			<%}else {%>
			data_arr[<%= counter%>][4] = "";
			<%}%>
			<%
				if(patient.getNextOfKinName() != null){
			%>
			data_arr[<%= counter%>][5] = "<%=patient.getNextOfKinName()%>"
			<%}else {%>
			data_arr[<%= counter%>][5] = "";
			<%}%>
			data_arr[<%= counter%>][6] = ""
			data_arr[<%= counter%>][7] = ""


			data_arr[<%= counter%>][8] = ""
		<%-- <%

			if(patient.getVillage()!=null ){
		%> --%>
	<%-- 		data_arr[<%= counter%>][9] = "<%=patient.getVillage().getVillageName()%>"
		<%}else{%>
			data_arr[<%= counter%>][9] = ""
		<%}%> --%>
			data_arr[<%= counter%>][10] = "<%=patient.getAge()%>"
		<%

				counter++;
		    	}
			}
		%>

    formName = "patientEnquiry"

	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;

	}

	makeTable(start,end);

	</script>
<script type="text/javascript" language="javascript">
function checkNameLength(value,fieldName){

	if(value!=""){
		var len=value.length;
		if(parseInt(len)<3){
			alert("Please Enter min three charecter "+fieldName);
			return false;
		}
	}else{
		return false;
		}
}

function checkEnquiryForm()
{
	    var hin_no = document.getElementById('<%=HIN_NO%>').value;
		var ad_no = document.getElementById('<%=AD_NO%>').value;
		var patient_name = document.getElementById('<%=PATIENT_NAME %>').value;
		var address = document.getElementById('<%=ADDRESS %>').value;
		var relation = document.getElementById('patientRelation').value;
		var from_date = document.getElementById('<%=FROM_DATE%>').value;
		var to_date = document.getElementById('toDateId').value;
		var patient_status = document.getElementById('<%=PATIENT_STATUS %>').value;
		var police = document.getElementById('<%=POLICE_STATION%>').value;
		var mobile = document.getElementById('<%=MOBILE_NO%>').value;
		var state = document.getElementById('<%=STATE_ID %>').value;
		var relativeName =document.getElementById('relativeName').value;
		var village = document.getElementById('village').value;
		if( (hin_no==null || hin_no=='') && (ad_no==null || ad_no=='') && (patient_name==null || patient_name=='')&& (address==null || address=='') && (relativeName==null || relativeName=='') && (relation==null ||relation=='0') && (from_date==null || from_date=='')&& (to_date==null || to_date=='')&& (state==null || state=='0')&& (patient_status==null || patient_status=='0')&&(village==null || village=='')&&(police==null || police=='') && (mobile==null || mobile==''))
		{
			alert('Please Enter at Least one Data to Search The Patient Details !!!');
			return false;
		}else
		{
			return true;
		}
}
function openTokenDisplay()
{
 var url="/hms/hms/enquiry?method=showWardWiseDetails";
 newwindow=window.open(url,'Inquiry_Display','_blank',"left=100,top=100,height=700,width=850,location=0,toolbar=0,menubar=0,status=no,scrollbars=yes,resizable=no");
}
</script>

