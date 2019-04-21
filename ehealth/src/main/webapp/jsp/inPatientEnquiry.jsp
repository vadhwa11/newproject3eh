<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calender.js" type="text/javascript"></script> 
<title>In Patient Search</title>
<div class="clear"></div>
<form name="searchIP" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
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
		if(map.get("wardList") != null){
			wardList= (List<MasDepartment>)map.get("wardList");
		}
		if(patientMap.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)patientMap.get("inpatientList");
		}
	%>

<div class="clear"></div>
<div class="titleBg">
<h2>In Patient Search</h2>
</div>
<div class="clear"></div>

<div class="Block"><label><%=prop.getProperty("com.jkt.hms.registration_no") %>:</label>
<input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50"
	onblur="if(this.value!=''){submitForm('searchIP','/hms/hms/enquiry?method=searchIP');}" onchange="if(this.value!=''){submitForm('searchIP','/hms/hms/enquiry?method=searchIP');}" />
	<script>
document.searchIP.<%=HIN_NO %>.focus();
</script>
<label><%=prop.getProperty("com.jkt.hms.ipd_no") %>:</label> <input
	type="text" name="<%=AD_NO %>" id="<%=AD_NO %>" value="" MAXLENGTH="30" /> <label>Ward</label>
<select name="<%=WARD_ID %>" id="<%=WARD_ID %>">
	<option value="0"><--Select Ward--></option>
	<%
				for(MasDepartment masDepartment : wardList)
				{
				%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%
				}
				%>
</select>
<div class="clear"></div>
<label>Patient First Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" id="<%=P_FIRST_NAME %>" onchange="checkNameLength(this.value,'Patient First Name')" value="" MAXLENGTH="15" /> <label>Patient
Mid Name</label> <input type="text" name="<%=P_MIDDLE_NAME %>" id="<%=P_MIDDLE_NAME %>" onchange="checkNameLength(this.value,'Patient Middle Name')" value=""
	MAXLENGTH="15" /> <label>Patient Last Name </label> <input type="text"
	name="<%=P_LAST_NAME%>" id="<%=P_LAST_NAME%>" onchange="checkNameLength(this.value,'Patient Last Name')" value="" MAXLENGTH="15" />
<div class="clear"></div>


<label>Village</label> <input type="text" name="<%=VILLAGE%>"
	id="village" maxlength="40"  onchange="checkNameLength(this.value,'Village Name')"/>
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('<%=VILLAGE%>','ac2update','common?method=getVillegeListForAutoComplete',{parameters:'requiredField=<%=VILLAGE%>'});
		</script> <label>Police Station</label> <input type="text"
	name="<%=POLICE_STATION%>" id="<%=POLICE_STATION%>" onchange="checkNameLength(this.value,'Police Station')" maxlength="20" />
<div class="clear"></div>
</div>
<div class="clear"></div>
</form>
<div class="clear"></div>
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="if(checkEnquiryForm()){submitForm('searchIP','/hms/hms/enquiry?method=searchIP');}"
	value="Search" class="button" accesskey="a" />
	<!-- onclick="if(checkEnquiryForm()){submitForm('searchIP','/hms/hms/enquiry?method=searchIP');}" -->
<div class="clear"></div>
<div class="division"></div>
<%String msg ="";
for(Inpatient inpatient2:inpatientList){
	if(inpatient2.getAdStatus().equals("W")){
		msg=inpatient2.getHin().getPFirstName()+" "+inpatient2.getHin().getPMiddleName()+" "+inpatient2.getHin().getPLastName()+" ("+inpatient2.getHin().getRelation().getRelationName()+" of "+inpatient2.getHin().getRank().getRankName()+" "+inpatient2.getHin().getSFirstName()+" "+inpatient2.getHin().getSMiddleName()+" "+inpatient2.getHin().getSLastName()+") Admitted (But not Acknowledged)  ";
	%>
<h4><span><%=msg%></span></h4>
<%}} %>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="ipPatientEnquiry" method="post" action="">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"servNo"],[2,"a&dNo","ipd"], [3,"hin"], [4,"patName"], [5,"serviceType"], [6,"sPersonName"], [7,"rank"], [8,"bedNo"], [9,"ward"], [10,"Admit Date"], [11,"Discharge Date"], [12,"Status"]];
	 statusTd = 12;
</script>
</div>
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
	data_header[1][0] = "<%=prop.getProperty("com.jkt.hms.ipd_no") %>"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "a&dNo";
	data_header[2] = new Array;
	data_header[2][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "hin";
	data_header[3] = new Array;
	data_header[3][0] = "Patient Name"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "patName";
	data_header[4] = new Array;
	data_header[4][0] = "Service Type"
	data_header[4][1] = "hide";
	data_header[4][2] = "10%";
	data_header[4][3] = "serviceType"
	data_header[5] = new Array;
	data_header[5][0] = "Service Person Name"
	data_header[5][1] = "hide";
	data_header[5][2] = "15%";
	data_header[5][3] = "sPersonName";
	data_header[6] = new Array;
	data_header[6][0] = "Rank"
	data_header[6][1] = "hide";
	data_header[6][2] = "10%";
	data_header[6][3] = "rank";
	data_header[7] = new Array;
	data_header[7][0] = "Bed No"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "bedNo"
	data_header[8] = new Array;
	data_header[8][0] = "Ward"
	data_header[8][1] = "data";
	data_header[8][2] = "30%";
	data_header[8][3] = "ward";
	data_header[9] = new Array;
	data_header[9][0] = "Admit Date"
	data_header[9][1] = "data";
	data_header[9][2] = "30%";
	data_header[9][3] = "addDate";
	data_header[10] = new Array;
	data_header[10][0] = "Discharge Date"
	data_header[10][1] = "data";
	data_header[10][2] = "30%";
	data_header[10][3] = "disDate";
	data_header[11] = new Array;
	data_header[11][0] = "Status"
	data_header[11][1] = "data";
	data_header[11][2] = "30%";
	data_header[11][3] = "status";

	data_arr = new Array();
<%
	int  counter=0;
	if (inpatientList != null && inpatientList.size() > 0)
	{ 
		for(Inpatient inpatient : inpatientList)
		{
			//if(inpatient.getAdStatus().equals("A"))
			//{
				Patient patient = inpatient.getHin();
%>
		  		data_arr[<%= counter%>] = new Array();
				data_arr[<%= counter%>][0] = <%=patient.getId()%>
				data_arr[<%= counter%>][1] = ""
				data_arr[<%= counter%>][2] = "<%=inpatient.getAdNo()%>"
				data_arr[<%= counter%>][3] = "<%=patient.getHinNo()%>"
<%
				String patient_Name ="";
				if(patient.getPFirstName()!=null)
				{
					patient_Name=patient.getPFirstName();
				}
				if(patient.getPMiddleName()!=null)
				{
					patient_Name=patient_Name+" "+patient.getPMiddleName();
				}
			 	if(patient.getPLastName()!=null)
			 	{
					 patient_Name=patient_Name+" "+patient.getPLastName();
			 	}
%>
				data_arr[<%= counter%>][4] = "<%=patient_Name%>"
				data_arr[<%= counter%>][5] = ""
				data_arr[<%= counter%>][6] = ""
				data_arr[<%= counter%>][7] = ""
				data_arr[<%= counter%>][8] = "<%=inpatient.getBed().getBedNo()%>"
<%
				if(inpatient.getDepartment()!= null)
				{
%>
					data_arr[<%= counter%>][9] = "<%= inpatient.getDepartment().getDepartmentName()%>"
<%				}
				else
				{
%>
					data_arr[<%= counter%>][9] = ""
<%
				}
				if(inpatient.getDateOfAddmission()!= null)
				{
%>
					data_arr[<%= counter%>][10] = "<%=HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission())%>"
<%
				}
				else
				{
%>
					data_arr[<%= counter%>][10] = ""
<%
				}
				if(inpatient.getDischargeDate()!= null)
				{
%>
					data_arr[<%= counter%>][11] = "<%=HMSUtil.convertDateToStringWithoutTime(inpatient.getDischargeDate())%>"
<%
				}
				else
				{
%>
					data_arr[<%= counter%>][11] = ""
<%
				}
				if(inpatient.getAdStatus().equals("A"))
				{
%>	
					data_arr[<%= counter%>][12] = "Admit"
<%
				}
				else if(inpatient.getAdStatus().equals("D"))
				{
%>
					data_arr[<%= counter%>][12] = "Discharge"
<%
				}
				
		    	counter++;
			//}
		}
	}
%>

    formName = "ipPatientEnquiry"
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
	    var ad_no = document.getElementById('<%=AD_NO %>').value;
	    var ward = document.getElementById('<%=WARD_ID %>').value;
	    var firstName = document.getElementById('<%=P_FIRST_NAME %>').value;
	    var middleName = document.getElementById('<%=P_MIDDLE_NAME %>').value;
	    var LastName = document.getElementById('<%=P_LAST_NAME%>').value;
	    var Village = document.getElementById('village').value;
	    var police = document.getElementById('<%=POLICE_STATION%>').value;

	    if((ad_no==null || ad_no=='') && (ward==null || ward=='0')&& (firstName==null || firstName=='')&& (middleName==null || middleName=='') && (LastName==null || LastName=='') && (Village==null || Village=='') )
		    // && (firstName==null || firstName=='') && (middleName==null || middleName=='') && (LastName==null || LastName=='') && (police==null || police=='') )
		{
			alert('Please Enter at Least one Data for Search !!!');
			return false;
		}else
		{
			return true;
		}
}
</script>
