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
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.Users"%>

<script src="/hms/jsp/js/surveyTarget.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript">
	<%
	String superAdmin = "";
	int userType = 0; /* user type 4 for general user */
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
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
			String currentDate = (String)utilMap.get("currentDate");  
			String currentTime = (String)utilMap.get("currentTime");
			if(session.getAttribute("userName") != null){
				userName = (String)session.getAttribute("userName");
			}
		Map<String, Object> map=new HashMap<String, Object>();
		List<PhHouseSurvey> phHouseSurveys=new ArrayList<PhHouseSurvey>();
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}
		if(map.get("phHouseSurveys")!=null){
			phHouseSurveys=(List<PhHouseSurvey>)map.get("phHouseSurveys");
		}
		int districtId = 0,instType=0;
		if(map.get("districtId")!=null){
			districtId = (Integer)map.get("districtId");
		}else if(session.getAttribute("districtId")!=null){
			districtId = (Integer)session.getAttribute("districtId");
		}
		int hospitalId=0;
		if(map.get("hospitalId")!=null){
			hospitalId= (Integer)map.get("hospitalId");
		}	
		else{
			hospitalId= (Integer)session.getAttribute("hospitalId");
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
		List<MasHospital> healthBlock = new ArrayList<MasHospital>();
		if(map.get("healthBlock") !=null){
			healthBlock=(List<MasHospital>)map.get("healthBlock");
		}
		
		List<MasWard> ward = new ArrayList<MasWard>();
		if(map.get("ward") !=null){
			ward=(List<MasWard>)map.get("ward");
		}
		List<MasDistrict> district = new ArrayList<MasDistrict>();
		if(map.get("masDistrict") !=null){
			district=(List<MasDistrict>)map.get("masDistrict");
		}
		List<MasHospital> chcList = new ArrayList<MasHospital>();
		if(map.get("chcList") !=null){
			chcList=(List<MasHospital>)map.get("chcList");
		}
		if(session.getAttribute("hospitalTypeId")!=null){
			instType = (Integer)session.getAttribute("hospitalTypeId");
		} else {
			if (map.get("instType") != null) {
				instType =(Integer)(map.get("instType"));
			}
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
<form name="dashboardTarget" onsubmit="return checkForm()" method="post">
<input type="hidden" name="instType" id="instType" value="<%=instType %>" >
<% if(userType <= 3){ %>
<div class="titleBg">
<h2>Supervisory Dashboard</h2>
</div>
<%}%>
<div class="clear"></div>
<div class="Block">
<% if(userType <= 1){ %>
<input type="hidden" name="currentDate"  value="<%= currentDate%>">
<input type="hidden" id="hospitalId" name="hospitalId" value="<%= hospitalId %>">
<%if(map.get("instituteTypeShortName") != null && (map.get("instituteTypeShortName").toString().equalsIgnoreCase("Admn") || map.get("instituteTypeShortName").toString().equalsIgnoreCase("DH"))) {%>
<label><span>*</span> District</label><select name="district" id="district" validate="District Name,int,yes" onchange="submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=gethealthblocklist&district='+this.value,'healthblock');submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=getBasicCenterList&chcphc='+this.value,'testDiv');getListCenter();"  required><!-- enableRadio(); -->
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
		<select name="healthBlock" id="healthBlockId" validate="Health Block,int,yes" class="" onchange="submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=gethealthblocklist&district='+this.value,'healthblock');">
			<option value="0">ALL</option>
		</select>
		</div>
		<label><span>*</span> List of center</label>
		<select name="ListOfCenter" id="ListOfCenterId"  validate="List of center,int,yes" onchange="getListCenter();">
			<option value="0">ALL</option>
			<option value="1">CHC</option>
			<option value="2">PHC</option>
			<option value="3">PPUnit</option>
		</select>

		<div id="tDiv">
 <label><span>*</span> CHC </label>
    	<select name="chcphc" id="chcphc" validate="CHC,int,yes">
			<option value="0">ALL</option>
		</select>
		
		<label><span>*</span> Institute Type </label>
 			<select name="instituteType" id="instituteType" validate="Institute Type,int,yes" class="" onclick="enableRadio();">
				<option value="0">ALL</option>
				<option value="1">Sub-Center</option>
				<option value="2">Basic-Section</option>
			</select>	
		<label><span>*</span>BasicSection/Subcenter </label>
 			<select name="base" id="base" class="" validate="BasicSection/Subcenter,int,yes">
				<option value="0">ALL</option>
			</select>
	</div>
		
<% } }%>
<div class="clear"></div>
<% if(userType == 2){ %>
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
		<select name="ListOfCenter" id="ListOfCenterId" validate="List of center,int,yes"   onchange="getListCenter();">
			<option value="0">ALL</option>
			<option value="1">CHC</option>
			<option value="2">PHC</option>
			<option value="3">PPUnit</option>
		</select>
 </div>
 
 <div id="tDiv">
 <label><span>*</span> CHC </label>
    	<select name="chcphc" id="chcphc">
			<option value="0">ALL</option>
		</select>
		<label><span>*</span> Institute Type </label>
 			<select name="instituteType" id="instituteType" validate="Institute Type,int,yes" class="" onclick="enableRadio();">
				<option value="0">ALL</option>
				<option value="1">Sub-Center</option>
				<option value="2">Basic-Section</option>
			</select>	
		<label><span>*</span>BasicSection/Subcenter </label>
 			<select name="base" id="base" class="">
				<option value="0">ALL</option>
			</select>
	</div>
		
<%} %>
<% if(userType == 3 || userType == 5){ %>
<div class="clear"></div>
<input type="hidden" name="district" id="district" value="<%=districtId%>">
<input type="hidden" name="healthBlock" id="healthBlockId" value="<%=healthBlocksId%>">
<label><span>*</span> List of center</label>
		<select name="ListOfCenter" id="ListOfCenterId" validate="List of center,int,yes"  onchange="getListCenter();">
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

<% if(userType == 4){ %>
<input type="hidden" name="district" id="district" value="<%=districtId%>">
<input type="hidden" name="healthBlock" id="healthBlockId" value="<%=healthBlocksId%>">
<input type="hidden" name="instType" id="instType" value="<%=instType %>" >
<input type="hidden" name="chcphc" id="chcphc" value="<%=chcphc%>">
<input type="hidden" name="ListOfCenterId" id="ListOfCenterId" value="<%=ListOfCenterId%>">
<div id="testDiv">
<label><span>*</span> Institute Type </label>
 			<select name="instituteType" id="instituteType" validate="CHC,int,yes" class="" onclick="submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=getBasicCenterList&chcphc=<%=chcphc%>','testDiv');">
				<option value="0">ALL</option>
				<option value="1">Sub-Center</option>
				<option value="2">Basic-Section</option>
			</select>
				
		<label><span>*</span>BasicSection/SubCenter</label>
 			<select name="base" id="base" class="" validate="BasicSection/Subcenter,int,yes">
				<option value="0">ALL</option>
			</select>
</div>
<div class="clear"></div>
	<div class="clear"></div>		
	<div class="clear"></div>
<%} %>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="titleBg">
<h2>Supervisory Dashboard Target</h2>
</div>
<div class="Block">
 <div class="clear"></div>
<div class="blocklevelClass" id="blocklevelId">
</div>
<div class="districtlevelClass" id="districtlevelClass"></div>
<label>House Survey Target</label> <input id="houseTargetId" type="text" value=""  name="houseSurveyTarget" validate="House Survey Target,int,no" class="supervisorclass">
<label>Member Survey Target</label> <input id="memeberTargetId" type="text" value="" maxlength="8" validate="Member Survey Target,int,no" name="memberSurveyTarget" class="supervisorclass">
 <label>House Visit Target</label> <input id="annualhvisitedtargetId" type="text" value="" maxlength="8" validate="House Visit Target,int,no" class="supervisorclass" name="annualhouseVisitTarget">
<div class="clear"></div>
 <label><span>*</span> Target From Date </label>
<input 	type="text" name="houseSurveyFromDate" id="houseSurveyFromDate" value="<%=currentDate%>"
	class="date" validate="Target From Date,date,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.dashboardTarget.houseSurveyFromDate,event);" />
<label><span>*</span> Target To Date </label> <input type="text"
	class="date" name="houseSurveyTodate" id="houseSurveyTodate"  value="<%=currentDate%>"
	validate="Target To Date,date,yes" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.dashboardTarget.houseSurveyTodate,event);" />
<div class="clear"></div>
 
<!-- <label>Status</label> --> <input id="status" type="hidden" value="" maxlength="10" class="supervisorclass" name="Status">
<label>Remarks</label> <input id="remarks" type="text" value="" maxlength="30" class="supervisorclass" name="remarks"> 
<div class="clear"></div>
</div>

<div class="clear"></div> 
<input type="hidden" id="userType" name="userType" value="<%= userType%>"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<input type="button" value="Submit"  onclick="submitForm('dashboardTarget','/hms/hms/pubHealth?method=addSupervisoryDashboardTarget');"/>
	<div class="bottom">
	</div>
	
	<script type="text/javascript">
	function enableRadio(){
     var x=document.getElementById("district").value;
		if(x > 0 ){
   			document.getElementById("divEnchashment").style.display ='block';
		}
		else {
			 document.getElementById("divEnchashment").style.display ='none';	
		}
	}	
	
	function checkForm() { 
        if((document.getElementById("district")).selectedIndex == 0)
       {
           alert('District name is required');
           return false;
       } 
        else{
       return true;  
        }
}
	</script>
