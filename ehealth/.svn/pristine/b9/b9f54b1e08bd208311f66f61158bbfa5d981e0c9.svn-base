<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasTitle"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasReligion"%>
<%@ page import="jkt.hrms.masters.business.MasApplicant"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hrms.masters.business.MasJob"%>

<%@ page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.net.URL"%>
<%@ page import="java.util.Properties"%>


<html xmlns="http://www.w3.org/1999/xhtml">
<link href="../HrmsJsp/EHA/css/style.css" rel="stylesheet"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"></meta>
<title>EHA Hospital Management System</title>
<script type="text/javascript"
	src="../HrmsJsp/EHA/js/jquery-1.2.2.pack.js"></script> <script
	type="text/javascript" src="../HrmsJsp/EHA/js/proto.js"></script> <script
	type="text/javascript" src="../HrmsJsp/EHA/js/tabcontent.js"></script>
<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/common.js"></script> <script
	type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/hms.js"></script> <script type="text/javascript"
	src="../HrmsJsp/EHA/js/ajax.js"></script> <script
	type="text/javascript" src="../HrmsJsp/EHA/js/animatedcollapse.js"></script>
<script type="text/javascript">
animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets')
animatedcollapse.init()
</script> <script type="text/javascript">
function checkForNok(){
var errorMessage="";
	formName="applicantMaster"
	obj = eval('document.'+formName)
	
	var objRegExp  = /^((\+\d{1,3}(-| )?\(?\d\)?(-| )?\d{1,5})|(\(?\d{2,6}\)?))(-| )?(\d{3,4})(-| )?(\d{4})(( x| ext)\d{1,5}){0,1}$/;
  		var i= objRegExp.test(document.getElementById('mobileNo').value) ;
		if(!i){
		errorMessage+=(document.getElementById('mobileNo').value)+"is not a vaild Mobile No";
		
	
	if(errorMessage !=""){
	alert(errorMessage)
	return false;
	}else{
	return true
	}
	
	
}
</script> <!--Main Div starts here-->
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<div id="main"><!--tab content starts-->
<form name="applicantMaster" action="" id="applicantMaster"
	method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">	
<%
	String applicantCode = "";
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	List<MasRelation> relationList = new ArrayList<MasRelation>();

	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();
	MasApplicant masApplicant=null;
	List<MasReligion> religionList = new ArrayList<MasReligion>();
	List<MasCountry> countryList = new ArrayList<MasCountry>();
	List<MasState> stateList = new ArrayList<MasState>();
	List<MasDistrict> districtList = new ArrayList<MasDistrict>();

	List<MasJob> jobList = new ArrayList<MasJob>();
	
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	
	if (map.get("titleList") != null) {
		titleList = (List<MasTitle>) map.get("titleList");
	}
	if (map.get("masApplicant") != null) {
		masApplicant = (MasApplicant) map.get("masApplicant");
	}
	
	if (map.get("maritalStatusList") != null) {
		maritalStatusList = (List<MasMaritalStatus>) map
				.get("maritalStatusList");
	}

	if (map.get("religionList") != null) {
		religionList = (List<MasReligion>) map.get("religionList");
	}
	if (map.get("countryList") != null) {
		countryList = (List<MasCountry>) map.get("countryList");
	}
	if (map.get("stateList") != null) {
		stateList = (List<MasState>) map.get("stateList");
	}
	if (map.get("districtList") != null) {
		districtList = (List<MasDistrict>) map.get("districtList");
	}

	if (map.get("relationList") != null) {
		relationList = (List<MasRelation>) map.get("relationList");
	}
	if (map.get("applicantCode") != null) {
		applicantCode = (String) map.get("applicantCode");
	}
	if (map.get("jobList") != null) {
		jobList = (List<MasJob>) map.get("jobList");
	}

	if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map
				.get("departmentList");
	}
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader()
			.getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}

	String bangaloreDistrictCode = properties
			.getProperty("bangaloreDistrictCode");
	String karnatakaStateCode = properties
			.getProperty("karnatakaStateCode");
	String indiaCode = properties.getProperty("indiaCode");
	String selectedTitleForReg = properties
			.getProperty("selectedTitleForReg");
%> <script type="text/javascript">
		<%
			int counter1 = 0;
			for (MasState masState : stateList)
			{
				for (MasDistrict masDistrict : districtList) 
				{
					if(masDistrict.getState() != null){
						if(masState.getId().equals(masDistrict.getState().getId() )){
								%>
									districtArray[<%=counter1%>] = new Array();
									districtArray[<%=counter1%>][0]=<%=masState.getId()%>;
									districtArray[<%=counter1%>][1] = <%=masDistrict.getId()%>;									
									districtArray[<%=counter1%>][2] = "<%=masDistrict.getDistrictName()%>";

								<%
								counter1++;
						}
					}
				}
			}
			
		%>
			
		</script> <!---Application Master Starts--->

<div class="titleBg"><a
	href="javascript:animatedcollapse.toggle('title1')">
<h2>Application Details</h2>
</a></div>
<div class="clear"></div>
<div class="Block" id="title1"><label>Applicant Code</label> <input
	name="code" type="text" value="<%=applicantCode%>" class="readOnly"
	readonly="readonly"></input> <label>Title <span> *</span></label> <select
	id="titleId" name="<%=TITLE%>" validate="Title,string,no" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasTitle masTitle : titleList)

		{
			if (masTitle.getTitleCode().equals(selectedTitleForReg)) {
	%>
	<option value="<%=masTitle.getId() %>" selected="selected"><%=masTitle.getTitleName()%></option>
	<%
		} else {
	%>
	<option value="<%=masTitle.getId()%>"><%=masTitle.getTitleName()%></option>
	<%
		}
		}
	%>
</select>

<div class="clear"></div>
<label>First Name <span>*</span></label> <input name="<%=FIRST_NAME%>"
	type="text" validate="First Name,String,no"></input> <label>Middle
Name</label> <input name="<%=MIDDLE_NAME%>" type="text"></input> <label>Last
Name <span>*</span></label> <input name="<%=LAST_NAME%>" type="text"
	validate="Last Name,String,no"></input>

<div class="clear"></div>


<label>Cell No.</label> <input name="<%=MOBILE%>" type="text"
	maxlength="15" onchange="checkForNOK();"></input> <label>Tel
No. <span>*</span></label> <input name="<%=TELEPHONE_NO%>" type="text"
	validate="Telephone No,phone,no"></input>

<div class="clear"></div>

<label>City <span>*</span></label> <select id="districtId"
	name="<%=DISTRICT%>" validate="District,string,no" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasDistrict masDistrict : districtList) {
			if (masDistrict.getState() != null) {
				if (masDistrict.getState().getStateCode().equals(
						karnatakaStateCode)) {
					if (masDistrict.getDistrictCode().equals(
							bangaloreDistrictCode)) {
	%>
	<option value="<%=masDistrict.getId()%>" selected="selected"><%=masDistrict.getDistrictName()%></option>
	<%
		} else {
	%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
	<%
		}
				}
			}

		}
	%>
</select> <label>State <span>*</span></label> <select id="stateId"
	name="<%=STATE%>" validate="State,string,no" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasState masState : stateList) {
			if (masState.getCountry() != null) {
				if (masState.getCountry().getCountryCode()
						.equals(indiaCode)) {
					if (masState.getStateCode().equals(karnatakaStateCode)) {
	%>
	<option value="<%=masState.getId() %>" selected="selected"><%=masState.getStateName()%></option>
	<%
		} else {
	%>
	<option value="<%=masState.getId() %>"><%=masState.getStateName()%></option>
	<%
		}
				}
			}
		}
	%>

</select> <label>Country <span>*</span></label> <select id="countryId"
	name="<%=COUNTRY%>" validate="Country,string,no" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasCountry masCountry : countryList)

		{
	%>
	<option value="<%=masCountry.getId() %>" selected="selected"><%=masCountry.getCountryName()%></option>
	<%
		}
	%>

</select>

<div class="clear"></div>

<label>Zip Code</label> <input name="<%=ZIPCODE%>" type="text">
</input> <label>Email <span>*</span></label> <input name="<%=EMAIL_ID%>"
	type="text" validate="Email,email,no"></input> <label>Address <span>*</span></label>
<textarea name="<%=ADDRESS %>" cols="0" rows="0"></textarea>

<div class="clear"></div>

<label>Dept. Applied for</label> <select id="departmentId"
	name="<%=DEPARTMENT_ID%>" validate="Department,string,no" tabindex="1"
	class="select_adt"
	onchange="submitProtoAjaxDynamic('applicantMaster','applicantReg?method=getDepartmentCode',departmentDiv);">
	<option value="0">Select</option>
	<%
		for (MasDepartment masDepartment : departmentList)

		{
	%>
	<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName()%></option>
	<%
		}
	%>

</select>

<div id="departmentDiv"></div>
<div class="clear"></div>

<label>Job Applied for <span>*</span></label> <select id="jobId"
	name="<%=JOB_ID%>" validate="job,string,no" tabindex="1"
	class="select_adt"
	onchange="submitProtoAjaxDynamic('applicantMaster','applicantReg?method=getJobCode',jobDiv);">
	<option value="0">Select</option>
	<%
		for (MasJob masJob : jobList)

		{
	%>
	<option value="<%=masJob.getId() %>" selected="selected"><%=masJob.getJobName()%></option>
	<%
		}
	%>

</select> <br />
<div id="jobDiv"></div>





<div class="clear"></div>
<div class="division"></div>


</div>


<div class="titleBg"><a
	href="javascript:animatedcollapse.toggle('title2')">
<h2>Reference Details</h2>
</a></div>
<div class="clear"></div>
<div class="Block" id="title2"><label>Reference Detail 1</label> <label>Reference
Detail 2</label>



<div class="clear"></div>
<label>Name 1</label> <input name="rName1" type="text"> </input> <label>Name
2</label> <input name="rName2" type="text"> </input>

<div class="clear"></div>
<label>Address 1</label> <textarea name="rAddress1" cols="0" rows="0"></textarea>
<label>Address 2</label> <textarea name="rAddress2" cols="0" rows="0"></textarea>
<div class="clear"></div>




<label>City 1</label> <select id="rDistrictId1" name="rDistrict1"
	validate="String,string,no" tabindex="1" class="select_adt">
	<option value="0" selected>Select</option>
	<%
		for (MasDistrict masDistrict : districtList) {
		
	%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
	<%
	
	
		

		}
	%>
</select> <label>City 2</label> <select id="rDistrictId2" name="rDistrict2"
	validate="String,string,no" tabindex="1" class="select_adt">
	<option value="0" selected>Select</option>
	<%
		for (MasDistrict masDistrict : districtList) {
			
	%>
	<option value="<%=masDistrict.getId()%>"><%=masDistrict.getDistrictName()%></option>
	<%
	

		}
	%>
</select>
<div class="clear"></div>




<label>State 1</label> <select id="rStateId1" name="rState1"
	validate="String,string,no" tabindex="1" class="select_adt">
	<option value="0" selected>Select</option>
	<%
		for (MasState masState : stateList) {
		%>
	<option value="<%=masState.getId() %>" selected="selected"><%=masState.getStateName()%></option>
	<%
	
		}
	%>
</select> <label>State 2</label> <select id="rStateId2" name="rState2"
	validate="String,string,no" tabindex="1" class="select_adt">
	<option value="0" selected>Select</option>
	<%
		for (MasState masState : stateList) {
			
	%>
	<option value="<%=masState.getId() %>" selected="selected"><%=masState.getStateName()%></option>
	<%
		} 
	%>


</select>



<div class="clear"></div>

<label>Country 1</label> <select id="rCountryId1" name="rCountry1"
	validate="String,string,no" tabindex="1" class="select_adt">
	<option value="0" selected>Select</option>
	<%
		for (MasCountry masCountry : countryList)

		{
	%>
	<option value="<%=masCountry.getId() %>" selected="selected"><%=masCountry.getCountryName()%></option>
	<%
		}
	%>
</select> <label>Country 2</label> <select id="rCountryId2" name="rCountry2"
	validate="String,string,no" tabindex="1" class="select_adt">
	<option value="0" selected>Select</option>
	<%
		for (MasCountry masCountry : countryList)

		{
	%>
	<option value="<%=masCountry.getId() %>" selected="selected"><%=masCountry.getCountryName()%></option>
	<%
		}
	%>
</select>
<div class="clear"></div>




<label>Pin Code 1</label> <input name="rZipCode1" type="text"> </input>
<label>Pin Code 2</label> <input name="rZipCode2" type="text"> </input>
<div class="clear"></div>





<label>Phone No. 1</label> <input name="rPhoneNo1" type="text"></input>
<label>Phone No. 2</label> <input name="rPhoneNo2" type="text">
</input>
<div class="clear"></div>
<label>Company Name. 1</label> <input name="rCompany1" type="text"></input>
<label>Company Name. 2</label> <input name="rCompany2" type="text">
</input>
<div class="clear"></div>
<label>Designation. 1</label> <input name="rDesignation1" type="text">
</input> <label>Designation. 2</label> <input name="rDesignation2" type="text">
</input>
<div class="clear"></div>



<label>Comments 1</label> <textarea name="rComments1" cols="0" rows="0"></textarea>
<label>Comments 2</label> <textarea name="rComments1" cols="0" rows="0"></textarea>

<div class="clear"></div>


</div>
<div class="division"></div>
<input type="button" name="Submit" value="Update" tabindex="1"
	class="buttonBig"
	onClick="submitForm('applicantMaster','applicantReg?method=updateMasterDetails&applicantId="<%=masApplicant.getId()%>"');"></input>
<input type="button" name="Submit" value="Save &amp; Continue"
	tabindex="1" class="buttonBig"
	onClick="submitForm('applicantMaster','applicantReg?method=saveMasterDetails');"></input>
<div class="clear"></div>

</form>



</div>
<!--Main Div ends here-->
</html>
<%countryList.clear();
departmentList.clear();
districtList.clear();
jobList.clear();
%>