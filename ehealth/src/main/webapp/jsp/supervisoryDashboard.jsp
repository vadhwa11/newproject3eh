<%-- 
	 * Copyright 2017 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : supervisorytarget.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 28.10.2017    Name: Om Tripathi
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@ page import="static jkt.hms.util.RequestConstants.FROM_DATE" %>
<%@ page import="static jkt.hms.util.RequestConstants.TO_DATE" %>

<script src="/hms/jsp/js/surveyTarget.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript">

	<%
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> map = new HashMap<String,Object>();
 	int template = 0;
 	String message="";
 	if(request.getAttribute("map") != null)
	{
		map = (Map<String,Object>) request.getAttribute("map");
	}

 	List<Object[]> hospitalList = new ArrayList<Object[]>();
	if(map.get("hospitalList")!=null){
		hospitalList = (List<Object[]>)map.get("hospitalList");
	}
	
	int hospitalId=0;
	if(map.get("hospitalId")!=null){
		hospitalId= (Integer)map.get("hospitalId");
	}	
	else{
		hospitalId= (Integer)session.getAttribute("hospitalId");
	}

	MasHospital hospital = new MasHospital();
	int districtId = 0,instType=0;
	if(map.get("districtId")!=null){
		districtId = (Integer)map.get("districtId");
	}else if(session.getAttribute("districtId")!=null){
		districtId = (Integer)session.getAttribute("districtId");
	}
	List<MasHospitalType> mhospitalTypetList = new ArrayList<MasHospitalType>();
	if(map.get("mhospitalTypetList")!=null){
		mhospitalTypetList=(List<MasHospitalType>)map.get("mhospitalTypetList");
	}
	int healthBlocksId=0;
	if(map.get("healthBlocksId")!=null){
		healthBlocksId=(Integer)map.get("healthBlocksId");
		System.out.println("healthBlocksId jsp"+healthBlocksId);
	}
	int chcphc=0;
	if(map.get("chcphc") != null){
		chcphc = (Integer)map.get("chcphc");
		System.out.println("chcphc jsp"+chcphc);
	}
	int base=0;
	if(map.get("base") != null){
		base = (Integer)map.get("base");
		System.out.println("base jsp"+base);
	}	
	
	int ListOfCenterId=0;String instituteTypeShortName=null;
	
	if(map.get("instituteTypeShortName") != null){
		instituteTypeShortName = (String)map.get("instituteTypeShortName");
		if(instituteTypeShortName.equals("CHC")){
			ListOfCenterId=1;
		}else if(instituteTypeShortName.equals("PHC") || instituteTypeShortName.equals("PHC-24x7") || instituteTypeShortName.equals("PHC-NHM")){
			ListOfCenterId=2;
		}
		else if(instituteTypeShortName.equals("PPU")){
			ListOfCenterId=3;
		}
	}
	
	if(session.getAttribute("hospitalTypeId")!=null){
		instType = (Integer)session.getAttribute("hospitalTypeId");
	} else {
		if (map.get("instType") != null) {
			instType =(Integer)(map.get("instType"));
		}
	}
	String shortName= "";
	for(Object[] mh:hospitalList){ 
		if(hospitalId==(Integer)mh[0]){
			 	shortName=(String)mh[2];
			break;
			 }
		 }
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	if(request.getAttribute("responsemessage") != null)
	{
		message=(String) request.getAttribute("responsemessage");
	}
	
	String superAdmin = "";
	int userType = 0; 
	if(session.getAttribute("users") != null){
		 Users user = (Users)session.getAttribute("users");
		 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
		 userType = user.getUserType()!=null?user.getUserType():4;
	}
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
		String userName = "";
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String currentTime = (String)utilMap.get("currentTime");
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		List<PhHouseSurvey> phHouseSurveys=new ArrayList<PhHouseSurvey>();
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}
		if(map.get("phHouseSurveys")!=null){
			phHouseSurveys=(List<PhHouseSurvey>)map.get("phHouseSurveys");
		}
		List<MasWard> ward = new ArrayList<MasWard>();
		if(map.get("ward") !=null){
			ward=(List<MasWard>)map.get("ward");
		}
		List<MasDistrict> district = new ArrayList<MasDistrict>();
		if(map.get("masDistrict") !=null){
			district=(List<MasDistrict>)map.get("masDistrict");
			System.out.println("district"+district.size());
		}
		List<MasHospital> chcList = new ArrayList<MasHospital>();
		if(map.get("chcList") !=null){
			chcList=(List<MasHospital>)map.get("chcList");
		}
		
		List<MasHospital> healthBlock = new ArrayList<MasHospital>();
		if(map.get("healthBlock") !=null){
			healthBlock=(List<MasHospital>)map.get("healthBlock");
		}

		String CurrentDate=date+"/"+month+"/"+year;
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		
	function checkData(){
			var start= new Date(document.getElementById("fromDate").value.split("/")[2], document.getElementById("fromDate").value.split("/")[1], document.getElementById("fromDate").value.split("/")[0]);
			 var end= new Date(document.getElementById("toDate").value.split("/")[2], document.getElementById("toDate").value.split("/")[1], document.getElementById("toDate").value.split("/")[0]);
			 if(start<=end){
				 return true;
			 }else{alert("Date is Incorrect.");return false;}
		}
</script>


<form name="dashboardTarget" method="post">
<input type="hidden" name="instType" id="instType" value="<%=instType %>" >
<div class="titleBg">
<h2>Supervisory Dashboard</h2>
</div>
<div class="clear"></div>
<div class="Block">

<input type="hidden" name="currentDate"  value="<%= currentDate%>">
<input type="hidden" id="hospitalId" name="hospitalId" value="<%= hospitalId %>">
<% if(userType <= 1){%>
<%if(map.get("instituteTypeShortName") != null && (map.get("instituteTypeShortName").toString().equalsIgnoreCase("Admn") || map.get("instituteTypeShortName").toString().equalsIgnoreCase("DH"))) {%>
<label><span>*</span> District</label><select name="district" validate="District,int,yes" id="district" onchange="submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=gethealthblocklist&district='+this.value,'healthblock');submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=getBasicCenterList&chcphc='+this.value,'testDiv');getListCenter();"  ><!-- enableRadio(); -->
<%	if(district.size() >0){%>
				<option value="0">ALL</option>
				 <%
				 for (MasDistrict dis : district) {
				  %>
	  <option value="<%=dis.getId ()%>"><%=dis.getDistrictName()%></option>
				  <%
		}
	}
				   %>
</select>

<div id="healthblock">
		<label><span>*</span> Health Block</label>
		<select name="healthBlock" id="healthBlockId" class="" validate="Health Block,int,yes" onchange="submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=gethealthblocklist&district='<%=districtId %>,'healthblock');">
			<option value="0">ALL</option>
		</select>
		</div>
				
		<label><span>*</span> List of center</label>
		<select name="ListOfCenter" id="ListOfCenterId"   validate="List of center,int,yes" onchange="getListCenter();defaultColor(this.value);">
			<option value="0">ALL</option>
			<option value="1">CHC</option>
			<option value="2">PHC</option>
			<option value="3">PPUnit</option>
		</select>
 <div id="tDiv">
 <label><span>*</span> CHC </label>
    	<select name="chcphc" id="chcphc" onchange="defaultColor(this.value);" validate="CHC,int,yes">
			<option value="0">ALL</option>
		</select>
		
		<label><span>*</span> Institute Type </label>
 			<select name="instituteType" id="instituteType"  validate="Institute Type,int,yes" class="" onchange="defaultColor(this.value);" onclick="enableRadio();">
				<option value="0">ALL</option>
				<option value="1">Sub-Center</option>
				<option value="2">Basic-Section</option>
			</select>	
		<label><span>*</span>BasicSection/SubCenter</label>
 			<select name="base" id="base" class="" onchange="defaultColor(this.value);" validate="BasicSection/Subcenter,int,yes">
				<option value="0">ALL</option>
			</select>
	</div>
		
		
<% }} %>

<%if(userType ==2){ %>
<div id="healthblock">
<input type="hidden" name="district" id="district" value="<%=districtId%>">
 <label><span>*</span> Health Block</label>
<select name="healthBlock" id="healthBlockId" validate="Health block,int,yes" onchange="submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=getBasicCenterList&chcphc='+this.value,'testDiv');getListCenter();">
<%	if(healthBlock.size() >0){%>
				<option value="0">ALL</option>
				 <%
				 for (MasHospital obj : healthBlock) {
				  %>
				  <option value="<%=obj.getId ()%>"><%=obj.getHospitalName()%></option>
				  <%
				  	}
				 } else{
				   %>
				   <option value="0">ALL</option>
				   <%} %>

</select>
 
 <label><span>*</span> List of center</label>
		<select name="ListOfCenter" id="ListOfCenterId" validate="List of center,int,yes"  onchange="defaultColor(this.value);getListCenter();">
			<option value="0">ALL</option>
			<option value="1">CHC</option>
			<option value="2">PHC</option>
			<option value="3">PPUnit</option>
		</select>
 </div>
 
 <div id="tDiv">
 <label><span>*</span> CHC </label>
    	<select name="chcphc" id="chcphc" validate="List of center,int,yes">
			<option value="0">ALL</option>
		</select>
		<label><span>*</span> Institute Type </label>
 			<select name="instituteType" id="instituteType" validate="CHC,int,yes" class="" onclick="enableRadio();">
				<option value="0">ALL</option>
				<option value="1">Sub-Center</option>
				<option value="2">Basic-Section</option>
			</select>	
		<label><span>*</span>BasicSection/Subcenter </label>
 			<select name="base" id="base" class="" validate="BasicSection/Subcenter,int,yes">
				<option value="0">ALL</option>
			</select>
	</div>
<%} %>
<% if(userType == 3 || userType == 5){ %>
<div class="clear"></div>
<input type="hidden" name="district" id="district" value="<%=districtId%>">
<input type="hidden" name="healthBlockId" id="healthBlockId" value="<%=healthBlocksId%>">
<label><span>*</span> List of center</label>
		<select name="ListOfCenter" id="ListOfCenterId" validate="List of center,int,yes"  onchange="defaultColor(this.value);getListCenter();">
			<option value="0">ALL</option>
			<option value="1">CHC</option>
			<option value="2">PHC</option>
			<option value="3">PPUnit</option>
		</select>
		<div id="tDiv">
 <label><span>*</span> CHC </label>
    	<select name="chcphc" id="chcphc" validate="List of center,int,yes">
			<option value="0">ALL</option>
		</select>
		<label><span>*</span> Institute Type </label>
 			<select name="instituteType" id="instituteType" validate="CHC,int,yes" class="" onclick="enableRadio();">
				<option value="0">ALL</option>
				<option value="1">Sub-Center</option>
				<option value="2">Basic-Section</option>
			</select>	
		<label><span>*</span>BasicSection/Subcenter</label>
 			<select name="base" id="base" class="" validate="BasicSection/Subcenter,int,yes">
				<option value="0">ALL</option>
			</select>
	</div>
		
 <%} %>
<div class="clear"></div>
<% if(userType == 4){ %>
<input type="hidden" name="district" id="district" value="<%=districtId%>">
<input type="hidden" name="healthBlockId" id="healthBlockId" value="<%=healthBlocksId%>">
<input type="hidden" name="instType" id="instType" value="<%=instType %>" >
<input type="hidden" name="chcphc" id="chcphc" value="<%=chcphc%>">

<input type="hidden" name="ListOfCenterId" id="ListOfCenterId" value="<%=ListOfCenterId%>">

<div id="testDiv">
<label><span>*</span> Institute Type </label>
 			<select name="instituteType" id="instituteType" validate="CHC,int,yes" class="" onchange="defaultColor(this.value);" onclick="enableRadio();submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=getBasicCenterList&chcphc=<%=chcphc%>','testDiv');">
				<option value="0">ALL</option>
				<option value="1">Sub-Center</option>
				<option value="2">Basic-Section</option>
			</select>
				
		<label><span>*</span>BasicSection/Subcenter </label>
 			<select name="base" id="base" class="" onchange="defaultColor(this.value);" validate="BasicSection/Subcenter,int,yes">
				<option value="0">ALL</option>
			</select>
</div>
<div class="clear"></div>
<%} %>
<label><span>*</span> From Date </label>
<input 	type="text" name="FromDate" id="fromDate" value="<%=currentDate%>"
	class="date" validate="From Date,date,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.dashboardTarget.FromDate,event);" />
<label><span>*</span> To Date </label> 
<input type="text"
	class="date" name="ToDate" id="toDate"  value="<%=currentDate%>"
	validate="To Date,date,yes" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.dashboardTarget.ToDate,event);" />
<div class="clear"></div>
 <input type="button" name="add" id="addbutton" value="View Survey" class="buttonBig"
	onClick="showResponses();checkSurveyForYearAndMonth();checkColor();"
	accesskey="a" tabindex=1 />	
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="responsediv"  id="responsediv"></div>
<div class="response_div"  id=""></div>

<div id ="supervisorId" class="response" style="display:none;">
<div class="shortsize">
<input type="hidden" name="targetIds" id="targetIds" value="">

<label>House Survey </label><input id="houseId" type="text" value="" class="supervisorclass" readonly="readonly"  name="houseId" >
<label>Member Survey </label><input id="memeberId" type="text" value="" class="supervisorclass" readonly="readonly" maxlength="8" name="memeberId" >
<!-- <label>Status</label>  --><input id="status" type="hidden" value="" maxlength="10" class="supervisorclass" readonly="readonly" name="Status">
<label>Remarks</label> <input id="remarks" type="text" value="" maxlength="30" readonly="readonly" class="supervisorclass" name="remarks">
<div class="clear"></div>
<label>House Survey Target</label> <input id="houseTargetId" type="text" value="" readonly="readonly" name="houseSurveyTarget" class="supervisorclass" onchange="SetPercentHouse();">
<label>Member Survey Target</label> <input id="memeberTargetId" type="text" value="" maxlength="8" readonly="readonly" name="memberSurveyTarget" class="supervisorclass" onchange="SetPercentMember();">
  
<div class="clear"></div>

<label>House Survey %(RO)</label> <input id="housePercentId" type="text" value=""  readonly="readonly" class="supervisorclass" name="houseSurveyPercent">
<label>Member Survey %(RO)</label> <input type="text" id="memberPercentId" value="" maxlength="8" readonly="readonly" name="memberSurveyPercent"  class="supervisorclass">
 
<div class="clear"></div><br>
<input type = "button"  id="graph1" value="View House Survey" name = "graph1" onclick="popupforGraph('pubHealth?method=publicHealthPieChart&SurveyGraph=HS&'+csrfTokenName+'='+csrfTokenValue)" />
<input type = "button"  id="graph1" value="View Member Survey" name = "graph1" onclick="popupforGraph('pubHealth?method=publicHealthPieChart&SurveyGraph=MS&'+csrfTokenName+'='+csrfTokenValue)" />
<div class="clear"></div>
<div class="clear"></div>
<br><br>
<label>Annual HV Target</label> <input id="annualhvisitedtargetId" type="text" value="" maxlength="8" readonly="readonly" class="supervisorclass" name="annualhstarget" onblur="monthlyhsTarget(this.value);annualhouseSurveyPerent();monthlyHouseSurveyPercent();annualMemberSurveyPercent();">
<label>Annual HV %(RO)</label> <input id="hvmhspercentId" type="text" value="" class="supervisorclass" readonly="readonly" name="hvmhspercent"> 
<label>House Visited Cum.</label> <input id="hvcummulativeId" type="text" value="" readonly="readonly" class="supervisorclass" maxlength="8" name="hvmhs"> 
<div class="clear"></div>
<label>Monthly HV Target(RO)</label> <input id="monthlyhstargetId" type="text" value="" maxlength="8" readonly="readonly" class="supervisorclass" name="monthlyhstargetId">
<label>Monthly HV%(RO)</label> <input id="monthlyhspercentId" type="text" value="" readonly="readonly" class="supervisorclass" name="monthlyhspercent">
<label>Monthly House Visited</label> <input id="monthlyhvId" type="text" value="" class="supervisorclass" readonly="readonly" name="monthlyhv">
<div class="clear"></div>

</div>

<div class="clear"></div>
<label>Verification Details</label> 
<div class="clear"></div>
<input type="hidden" id="instituteNameId" name="instType" value="">
<div class="districtlevelClass" id="districtlevelClass">

<input type="hidden" name="publicHealthNurseId" id="publicHealthNurseId" value="">
<input type="hidden" name="districtPublicHealthNurse" id="districtPublicHealthNurseId" value="">
<input type="hidden" name="publicHealthNurseSupervisor" id="publicHealthNurseSupervisorId" value="">
<input type="hidden" name="healthsupervisor" id="healthsupervisor" value="">
<input type="hidden" name="healthinspector" id="healthinspector" value="">
<input type="hidden" name="technicalAss2" id="technicalAss2" value="">
<input type="hidden" name="medicalchc" id="medicalchc" value="">
<input type="hidden" name="regionalcho" id="regionalcho" value="">
<input type="hidden" name="districtMedicalOfficer" id="districtMedicalOfficer" value="">
<input type="hidden" name="medicalphc" id="medicalphcId" value=""> 
<% if(userType <= 1){%>

<c:out value="${param.publicHealthNurse}" />
<c:set var="healthinspectorV" value="${value.healthinspector}"/>
       <label class="varifiedStatusclass" style="color:#FF0000">DMO </label><input id="districtMedicalOfficerId" type="text"  value="" class="district" style="width:18px; height: 16px; background-color:pink;"   name="DMO">       
       <label class="varifiedStatusclass" style="color:#FF0000">TA </label> <input id="technicalAss2Id" type="text" value="" class="district" name="TA" style="width:18px; height: 16px; background-color:pink;">    

<% } %>
<% if(userType <= 2){ %>
       <label class="varifiedStatusclass" style="color:#0000FF">MOCHC </label> <input id="MOCHC" type="text" value="" readonly="readonly"  class="district" name="MOCHC" style="width:18px; height: 16px; background-color:pink;">    
       <label class="varifiedStatusclass" style="color:#0000FF">HS </label> <input id="healthsupervisorId" type="text" value="" readonly="readonly" class="district" name="HS" style="width:18px; height: 16px; background-color:pink;">     
       <input id="medicalphcIds" type="hidden" value="" readonly="readonly" class="district" name="MOPHC" style="width:18px; height: 16px; background-color:pink;">
<%} %>
        <input id="MOCHC" type="hidden" value="" readonly="readonly"  class="district" name="MOCHC" style="width:18px; height: 16px; background-color:pink;">
      <label class="varifiedStatusclass" style="color:#FF9900">MOPHC </label> <input id="medicalphcIds" type="text" value="" readonly="readonly" class="district" name="MOPHC" style="width:18px; height: 16px; background-color:pink;">  
      <label class="varifiedStatusclass"  style="color:#FF9900">HI </label> <input id="healthinspectorId" type="text" value="" class="district" readonly="readonly" style="width:18px; height: 16px; background-color:pink;" name="HI">          
      
</div>
<div class="clear"></div> 

<div class="blocklevelClass" id="blocklevelId">
<% if(userType <= 1){ %>
      <label class="block" style="color:#FF0000">RCHO </label> <input id="regionalchoId" type="text" value="" class="blockclass" name="RCHO" readonly="readonly" style="width:18px; height: 16px; background-color:pink;">         
      <label class="block" style="color:#FF0000">DPHN/MCH </label> <input id="districtPublicHealthNurseIds" type="text" value="" class="blockclass"readonly="readonly" style="width:18px; height: 16px; background-color:pink;" name="DPHN/MCH">      
<% } %>
<% if(userType <= 2){ %>
    <input id="regionalchoId" type="hidden" value="" class="blockclass" name="RCHO" readonly="readonly" style="width:18px; height: 16px; background-color:pink;">
   <input id="medicalphcIds1" type="hidden" value="" class="blockclass" readonly="readonly" style="width:18px; height: 16px; background-color:pink;" name="MOPHC">
  <label class="block" style="color:#0000FF">MOCHC </label> <input id="medicalchcId" type="text" value="" class="blockclass" readonly="readonly" style="width:18px; height: 16px; background-color:pink;" name="DPHN/MCH">      
   <label class="block" style="color:#0000FF">PHNS </label> <input id="publicHealthNurseSupervisorIds" type="text" value="" class="" readonly="readonly" style="width:18px; height: 16px; background-color:pink;" name="PHNS">              

<% } %>
   <input id="regionalchoId" type="hidden" value="" class="blockclass" name="RCHO" readonly="readonly" style="width:18px; height: 16px; background-color:pink;">
   <input id="medicalchcId" type="hidden" value="" class="blockclass" readonly="readonly" style="width:18px; height: 16px; background-color:pink;" name="DPHN/MCH">
  <label class="block" style="color:#FF9900">MOPHC </label> <input id="medicalphcIds1" type="text" value="" class="blockclass" readonly="readonly" style="width:18px; height: 16px; background-color:pink;" name="MOPHC">               
  <label class="block" style="color:#FF9900">PHN </label> <input id="publicHealthNurses" type="text" value="" class="blockclass1"  readonly="readonly"style="width:18px; height: 16px; background-color:pink;" name="PHN">               
</div>
<div class="clear"></div> 
<div class="floatLeft" style=" margin: 5px 0px;">
<label class="auto"><img src="/hms/jsp/images/red_rectangle.jpg" width="14" height="14" />
District Level</label>
</div>
<div class="floatLeft" style=" margin: 5px 0px;">
<label class="auto"><img src="/hms/jsp/images/blue_rectangle.png" width="14" height="14" />
Block Level</label>
</div>
<div class="floatLeft" style=" margin: 5px 0px;">
<label class="auto"><img src="/hms/jsp/images/orange_rectangle.png" width="14" height="14" />
PHC Level</label>
</div>
<div class="clear"></div> 
</div>
<div id="divEnchashment"></div>
</div>
<input type="hidden" id="userType" name="userType" value="<%= userType%>"/>
<input type="hidden" id="hositalStatus" name="hositalStatus" value="0"/>
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">

</div>
<div class="Block">
<div class="clear"></div>
</div>
<input type="hidden" id="userType" name="userType" value="<%= userType%>"/>
<input type="hidden" id="hositalStatus" name="hositalStatus" value="0"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="bottom">
</div>
	
<script type="text/javascript">
	function showResponses() {
	    var divs = document.getElementsByTagName('div');
	    for(var i = divs.length; i-- ;) {
	        var div = divs[i];
	        if(div.className === 'response') {
	            div.style.display = 'inline';
	        };
	    };
	}
	
	function checkColor() {
		var publicHealthNurseId = document.getElementById("publicHealthNurseId");
		var healthsupervisor = document.getElementById("healthsupervisor");
		var healthinspector = document.getElementById("healthinspector");
		var technicalAss2 = document.getElementById("technicalAss2");
		var medicalchc = document.getElementById("medicalchc");
		var regionalcho = document.getElementById("regionalcho");
		var districtMedicalOfficer = document.getElementById("districtMedicalOfficer");
		var districtPublicHealthNurseId = document.getElementById("districtPublicHealthNurseId");
		var publicHealthNurseSupervisorId = document.getElementById("publicHealthNurseSupervisorId");
		var medicalphcId = document.getElementById("medicalphcId");
		
		if (publicHealthNurseId.value == "Y") {        
			document.getElementById("publicHealthNurses").style.backgroundColor = "green";
		          }else if(document.getElementById("publicHealthNurses")!=null){
		            	document.getElementById("publicHealthNurses").style.backgroundColor = "pink";	
		          }
	if (healthsupervisor.value == "Y") {        
		document.getElementById("healthsupervisorId").style.backgroundColor = "green";
	          }else if(document.getElementById("healthsupervisorId")!=null){
	            	document.getElementById("healthsupervisorId").style.backgroundColor = "pink";	
	          }
	    
	    if (healthinspector.value == "Y") {        
			document.getElementById("healthinspectorId").style.backgroundColor = "green";
		          }else if(document.getElementById("healthinspectorId")!=null){
		            	document.getElementById("healthinspectorId").style.backgroundColor = "pink";	
		          }
	    
	    if (medicalphcId.value == "Y") {       
		      	document.getElementById("medicalphcIds").style.backgroundColor = "green";
		      	document.getElementById("medicalphcIds1").style.backgroundColor = "green";
		          }else if(document.getElementById("medicalphcId").value!=null){
		            	document.getElementById("medicalphcIds").style.backgroundColor = "pink";
		            	document.getElementById("medicalphcIds1").style.backgroundColor = "pink";
		          }
	    /* if (medicalphcId1.value == "Y") {       
	      	document.getElementById("medicalphcIds1").style.backgroundColor = "green";
	          }else if(document.getElementById("medicalphcId1").value!=null){
	            	document.getElementById("medicalphcIds1").style.backgroundColor = "pink";
	          } */
		    if (technicalAss2.value == "Y") {        
				document.getElementById("technicalAss2Id").style.backgroundColor = "green";
			          }else if(document.getElementById("technicalAss2Id")!=null){
			            	document.getElementById("technicalAss2Id").style.backgroundColor = "pink";	
			          }
			    
			    if (medicalchc.value == "Y") { 
			    	document.getElementById("MOCHC").style.backgroundColor = "green";
					document.getElementById("medicalchcId").style.backgroundColor = "green";
				          }else if(document.getElementById("medicalchcId")!=null){
				            	document.getElementById("medicalchcId").style.backgroundColor = "pink";	
				            	document.getElementById("MOCHC").style.backgroundColor = "pink";
				          }
				    if (regionalcho.value == "Y") {        
						document.getElementById("regionalchoId").style.backgroundColor = "green";
					          }else if(document.getElementById("regionalchoId")!=null){
					            	document.getElementById("regionalchoId").style.backgroundColor = "pink";	
					          }
					    if (districtMedicalOfficer.value == "Y") {        
							document.getElementById("districtMedicalOfficerId").style.backgroundColor = "green";
						          }else if(document.getElementById("districtMedicalOfficerId")!=null){
						            	document.getElementById("districtMedicalOfficerId").style.backgroundColor = "pink";	
						          }
						    if (publicHealthNurseSupervisorId.value == "Y") {        
								document.getElementById("publicHealthNurseSupervisorIds").style.backgroundColor = "green";
							          }else if(document.getElementById("publicHealthNurseSupervisorIds")!=null){
							            	document.getElementById("publicHealthNurseSupervisorIds").style.backgroundColor = "pink";	
							          }
							    
							    if (districtPublicHealthNurseId.value == "Y") {        
									document.getElementById("districtPublicHealthNurseIds").style.backgroundColor = "green";
								          }else if(document.getElementById("districtPublicHealthNurseIds")!=null){
								            	document.getElementById("districtPublicHealthNurseIds").style.backgroundColor = "pink";	
								          };
							    
			};
	
</script>
<script>
function defaultColor(val){
	document.getElementById("medicalphcIds").style.backgroundColor = "pink";
	document.getElementById("medicalphcIds1").style.backgroundColor = "pink";
	document.getElementById("medicalchcId").style.backgroundColor = "pink";	
	document.getElementById("MOCHC").style.backgroundColor = "pink";
};
</script>
