<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasCountry"%>
<%@ page import="jkt.hms.masters.business.MasState"%>
<%@ page import="jkt.hms.masters.business.MasTitle"%>
<%@ page import="jkt.hrms.masters.business.MasTribe"%>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<%@ page import="jkt.hms.masters.business.MasReligion"%>
<%@ page import="jkt.hrms.masters.business.MasNationality"%>
<%@ page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="jkt.hrms.masters.business.MasJob"%>
<%@ page import="jkt.hrms.masters.business.MasApplicant"%>
<%@ page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="jkt.hms.masters.business.MasMaritalStatus"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


<%@page import="java.net.URL"%><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>EHA Hospital Management System</title>
<link href="../HrmsJsp/EHA/css/style.css" rel="stylesheet"
	type="text/css"></link>

<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/animatedcollapse.js"></script>
<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/jquery-1.2.2.pack.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<script type="text/javascript" src="../HrmsJsp/EHA/js/tabcontent.js"></script>
<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/hms.js"></script>

<script type="text/javascript">
animatedcollapse.addDiv('title3', 'fade=0,speed=400,group=pets,hide=0,persist=0')
animatedcollapse.addDiv('title4', 'fade=0,speed=400,group=pets')
animatedcollapse.init()
</script>


<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>serverdate = '<%=dateCal+"/"+month+"/"+year%>'</script>


<script type="text/javascript" language="javascript"
	src="../HrmsJsp/EHA/js/calendar.js"></script>


</head>


<!--Main Div starts here-->
<div id="main"><!--tab content starts--> <%
MasApplicant masApplicant=null;
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

	List<MasTribe> tribeList = new ArrayList<MasTribe>();
	List<MasNationality> nationalityList = new ArrayList<MasNationality>();
	List<MasTitle> titleList = new ArrayList<MasTitle>();
	List<MasMaritalStatus> maritalStatusList = new ArrayList<MasMaritalStatus>();

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
	if (map.get("tribeList") != null) {
		tribeList = (List<MasTribe>) map.get("tribeList");
	}
	if (map.get("religonList") != null) {
		religionList = (List<MasReligion>) map.get("religonList");
	}
	if (map.get("nationalityList") != null) {
		nationalityList = (List<MasNationality>) map
				.get("nationalityList");
	}
	if (map.get("maritalStatusList") != null) {
		maritalStatusList = (List<MasMaritalStatus>) map
				.get("maritalStatusList");
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



	if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map
				.get("departmentList");
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		try {
			properties.load(resourcePath.openStream());
		} catch (Exception e) {
			e.printStackTrace();
		}

		String bangaloreDistrictCode = properties.getProperty("bangaloreDistrictCode");
		String karnatakaStateCode = properties.getProperty("karnatakaStateCode");
		String indiaCode = properties.getProperty("indiaCode");
	String 	selectedTitleForReg=properties.getProperty("selectedTitleForReg");

	}
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

		</script>


<form name="applicantPersonal" action="" id="applicantPersonal"
	method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">	
<div class="titleBg"><a
	href="javascript:animatedcollapse.toggle('title3')">
<h2>Personal Details</h2>
</a></div>
<div class="clear"></div>
<div class="Block" id="title3"><label>Applicant Code</label> <input
	name="code" type="text" value="<%=masApplicant.getApplicantCode()%>"
	class="readOnly" readonly="readonly"></input>


<div class="clear"></div>
<label>Date of Birth <span>*</span></label> <input
	name="<%=DATE_OF_BIRTH%>" type="text" value="" id="<%=DATE_OF_BIRTH %>"
	tabindex="1" class="textbox_date" readonly="readonly"
	validate="Start Date,date,no" MAXLENGTH="30" /> <a
	href="javascript:setdate('',document.applicantPersonal.<%=DATE_OF_BIRTH %>)">
<img src="../HrmsJsp/EHA/images/cal.gif" alt="date" /></a> <label>Gender</label>

<label class="small">Male</label> <input name="<%=GENDER%>" type="radio"
	value="male" class="radioCheck" /> <label class="small">Female</label>
<input name="<%=GENDER%>" type="radio" value="female" class="radioCheck" />


<div class="clear"></div>

<label>Place of Birth</label> <input name="<%=PLACE_OF_BIRTH%>"
	type="text" /> <label>SSS No.</label> <input name="<%=SSC_NO%>"
	type="text" /> <label>PHIC No. </label> <input name="<%=PHIC_NO%>"
	type="text" />

<div class="clear"></div>

<label>TIN No.</label> <input name="<%=TIN_NO%>" type="text" /> <label>Passport
No.</label> <input name="PASSPORT_NO" type="text" /> <label>Driving
License</label> <input name="<%=DRIVING_LICENCE_NO%>" type="text" />

<div class="clear"></div>

<label>Nationality</label> <select id="nationalityId"
	name="<%=NATIONALITY%>" validate="Nationality,string,yes" tabindex="1"
	class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasNationality masNationality : nationalityList) {
	%>
	<option value="<%=masNationality.getId() %>" selected="selected"><%=masNationality.getNationalityName()%></option>
	<%
		}
	%>
</select> <label>Country</label> <select id="countryId" name="<%=COUNTRY%>"
	validate="Country,string,no" tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasCountry masCountry : countryList) {
	%>
	<option value="<%=masCountry.getId() %>" selected="selected"><%=masCountry.getCountryName()%></option>
	<%
		}
	%>
</select> <label>Tribe</label> <select id="tribeId" name="<%=TRIBE%>"
	validate="tribe,string,no" tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasTribe masTribe : tribeList) {
	%>
	<option value="<%=masTribe.getId() %>" selected="selected"><%=masTribe.getTribeName()%></option>
	<%
		}
	%>
</select>

<div class="clear"></div>

<label>Religion</label> <select id="religionId" name="<%=RELIGION%>"
	validate="religion,string,no" tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasReligion masReligion : religionList) {
	%>
	<option value="<%=masReligion.getId() %>" selected="selected"><%=masReligion.getReligionName()%></option>
	<%
		}
	%>
</select> <label> Pan No.</label> <input name="<%=PAN_NO %>" type="text" />
<div class="clear"></div>
<h2>Emergency Details</h2>
<div class="clear"></div>

<label>Person Name</label> <input name="emgPersonName" type="text" /> <label>Address</label>
<textarea name="emgPersonAddress" cols="0" rows="0"></textarea>
<div class="clear"></div>
<label>Emergency Contact No</label> <input name="emgContactNo"
	type="text" />

<div class="clear"></div>
<div class="division"></div>

<div class="clear"></div>
</div>

<div class="division"></div>

<div class="titleBg"><a
	href="javascript:animatedcollapse.toggle('title4')">
<h2>Family Details</h2>
</a></div>
<div class="clear"></div>
<div class="Block" id="title4"><label>Marital Status</label> <select
	id="martialStatusId" name="<%=MARTIAL_STATUS%>"
	validate="martialStatus,string,no" tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<%
		for (MasMaritalStatus masMaritalStatus : maritalStatusList) {
	%>
	<option value="<%=masMaritalStatus.getId() %>" selected="selected"><%=masMaritalStatus.getMaritalStatusName()%></option>
	<%
		}
	%>
</select> <label>Spouse Name</label> <input name="<%=SPOUSE_NAME %>" type="text" />

<label>No. of Children</label> <input name="<%=NO_OF_CHILDREN %>"
	type="text" />

<div class="clear"></div>

<label>Father's Name</label> <input name="<%=FATHER_NAME%>" type="text" />

<label>Mother's Name</label> <input name="<%=MOTHER_NAME%>" type="text" />

<div class="clear"></div>
<h2>Personality Details</h2>
<div class="clear"></div>

<label>General Interest</label> <textarea name="<%=GENERAL_INTEREST%>"
	cols="0" rows="0"></textarea> <label>Likes</label> <textarea
	name="<%=LIKES%>" cols="0" rows="0"></textarea> <label>Dislikes</label>
<textarea name="<%=DISLIKES%>" cols="0" rows="0"></textarea>

<div class="clear"></div>

<label>Strength</label> <textarea name="<%=STRENGHT%>" cols="0" rows="0">
</textarea> <label>Weakness</label> <textarea name="<%=WEEKNESS%>" cols="0"
	rows="0"></textarea>
<div class="clear"></div>

<label>Height</label> <input name="<%=HEIGHT%>" type="text"
	class="small" /> <label class="small">Cm</label>
<div class="paddLeft35"><label>Weight</label> <input
	name="<%=WEIGHT%>" type="text" class="small" /> <label class="small">Kg</label>
<div class="clear"></div>

<div class="clear"></div>

<div class="division"></div>
<input name="save" type="button" value="Save &amp; Continue"
	class="buttonBig"
	onClick="submitForm('applicantPersonal','applicantReg?method=savePersonalDetails');" />
<input name="save" type="button" value="Back" class="button" />
<div class="clear"></div>
</div>


<!--Main Div ends here-->
</form>
</div>

</html>
