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
	System.out.println("hospitalid "+hospitalId);

	MasHospital hospital = new MasHospital();
	int districtId = 0,instType=0;
	if(map.get("districtId")!=null){
		districtId = (Integer)map.get("districtId");
	}else if(session.getAttribute("districtId")!=null){
		districtId = (Integer)session.getAttribute("districtId");
	}
	
	List<MasHospital> healthBlock = new ArrayList<MasHospital>();
	if(map.get("healthBlock") !=null){
		healthBlock=(List<MasHospital>)map.get("healthBlock");
	}
	if(session.getAttribute("hospitalTypeId")!=null){
		instType = (Integer)session.getAttribute("hospitalTypeId");
	} else {
		if (map.get("instType") != null) {
			instType =(Integer)(map.get("instType"));
		}
	}
	
	List<Object[]> districtList = new ArrayList<Object[]>();
	if(map.get("districtList") != null){
		districtList = (List<Object[]>)map.get("districtList");
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
	int userType = 0; /* user type 4 for general user */
	if(session.getAttribute("users") != null){
		 Users user = (Users)session.getAttribute("users");
		 superAdmin = user.getSuperuser()!=null?user.getSuperuser():"n";
		 userType = user.getUserType()!=null?user.getUserType():4;
		 System.out.println("userType"+userType);
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
		}
		List<MasHospital> chcList = new ArrayList<MasHospital>();
		if(map.get("chcList") !=null){
			chcList=(List<MasHospital>)map.get("chcList");
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
<h2>Supervisory Dashboard Authentication</h2>
</div>
<div class="clear"></div>
<div class="Block">
<% if(userType <= 1){%>
<input type="hidden" name="currentDate"  value="<%= currentDate%>">
<input type="hidden" id="hospitalId" name="hospitalId" value="<%= hospitalId %>">
<%if(map.get("instituteTypeShortName") != null && (map.get("instituteTypeShortName").toString().equalsIgnoreCase("Admn") || map.get("instituteTypeShortName").toString().equalsIgnoreCase("DH"))) {%>
<label><span>*</span> District </label><select name="district"  validate="District,int,yes" id="district" onchange="submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=gethealthblocklist&district='+this.value,'healthblock');submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=getBasicCenterList&chcphc='+this.value,'testDiv');getListCenter();"  ><!-- enableRadio(); -->
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
		<select name="healthBlock" id="healthBlockId" class="" validate="Health Block,int,yes" onchange="submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=gethealthblocklist&district='+this.value,'healthblock');">
			<option value="0">ALL</option>
		</select>
		</div>
		<label><span>*</span> List of center</label>
		<select name="ListOfCenter" id="ListOfCenterId" validate="List of center,int,yes"  onchange="getListCenter();">
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
 			<select name="instituteType" id="instituteType" class=""  validate="Institute Type,int,yes" onclick="enableRadio();">
				<option value="0">ALL</option>
				<option value="1">Sub-Center</option>
				<option value="2">Basic-Section</option>
			</select>	
		<label><span>*</span>BasicSection/Subcenter </label>
 			<select name="base" id="base" class=""  validate="BasicSection/Subcenter,int,yes">
				<option value="0">ALL</option>
			</select>
	</div>
		
<% } }%>
<% if(userType == 2){%>
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
		<select name="ListOfCenter" id="ListOfCenterId" validate="List of center,int,yes"  onchange="getListCenter();">
			<option value="0">ALL</option>
			<option value="1">CHC</option>
			<option value="2">PHC</option>
			<option value="3">PPUnit</option>
		</select>
 </div>
 
 <div id="tDiv">
 <label><span>*</span> CHC </label>
    	<select name="chcphc" id="chcphc" validate="CHC,int,yes" >
			<option value="0">ALL</option>
		</select>
		<label><span>*</span> Institute Type </label>
 			<select name="instituteType" id="instituteType" validate="Institute Type,int,yes" class="" > 
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
<% if(userType == 3 || userType == 5){%>
<div class="clear"></div>
<input type="hidden" name="district" id="district" value="<%=districtId%>">
<input type="hidden" name="healthBlockId" id="healthBlockId" value="<%=healthBlocksId%>">
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
<div class="clear"></div>

<% if(userType == 4){ %>
<input type="hidden" name="district" id="district" value="<%=districtId%>">
<input type="hidden" name="healthBlockId" id="healthBlockId" value="<%=healthBlocksId%>">
<input type="hidden" name="instType" id="instType" value="<%=instType %>" >
<input type="hidden" name="chcphc" id="chcphc" value="<%=chcphc%>">
<input type="hidden" name="ListOfCenterId" id="ListOfCenterId" value="<%=ListOfCenterId%>">

<div id="testDiv">
<label><span>*</span> Institute Type </label>
 			<select name="instituteType" id="instituteType" validate="CHC,int,yes" class="" onclick="enableRadio();submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=getBasicCenterList&chcphc=<%=chcphc%>','testDiv');">
				<option value="0">ALL</option>
				<option value="1">Sub-Center</option>
				<option value="2">Basic-Section</option>
			</select>
				
		<label><span>*</span>BasicSection/Subcenter</label>
 			<select name="base" id="base" class="" validate="BasicSection/Subcenter,int,yes">
				<option value="0">ALL</option>
			</select>
			</div>
<div class="clear"></div>
<%} %>


<label><span>*</span> From Date </label> 
 <input type="text" name="FromDate" id="fromDate" value="<%=currentDate%>"
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
	readonly="readonly" />  <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.dashboardTarget.ToDate,event);" />
<div class="clear"></div>
 <input type="button" name="add" id="addbutton" value="View Survey" class="buttonBig"
	onClick="showResponses();AuthenticateSurvey();"
	accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div id="testdiv"></div>

<div class="responsediv"  id="responsediv"></div>
<div class="response_div"  id=""></div>

<div id ="supervisorId" class="response" style="display:none;">
<div class="shortsize">
<input type="hidden" name="targetIds" id="targetIds" value="">
<input type="hidden" name="monthlyMemberSurveyTargetId" id="monthlyMemberSurveyTargetId" value="">
<input type="hidden" name="totalhouseSurveyCountdb" id="totalhouseSurveyCountdb" value="">
<input type="hidden" name="totalmemberSurveyCountdb" id="totalmemberSurveyCountdb" value="">
<label>House Survey </label><input id="houseId" type="text" value="" class="supervisorclass" readonly="readonly"  name="houseId" >
<label>Member Survey </label><input id="memeberId" type="text" value="" class="supervisorclass" readonly="readonly" maxlength="8" name="memeberId" >
<!-- <label>Status</label>  --><input id="status" type="hidden" value="" maxlength="10" class="supervisorclass" name="Status">
<label>Remarks</label> <input id="remarks" type="text" value="" maxlength="30" class="supervisorclass" name="remarks">

<div class="clear"></div>
<label>House Survey Target</label> <input id="houseTargetId" type="text" value=""  name="houseSurveyTarget" class="supervisorclass" onchange="SetPercentHouse();">
<label>Member Survey Target</label> <input id="memeberTargetId" type="text" value="" maxlength="8"  name="memberSurveyTarget" class="supervisorclass" onchange="SetPercentMember();">
  
<div class="clear"></div>

<label>House Survey %(RO)</label> <input id="housePercentId" type="text" value=""  readonly="readonly" class="supervisorclass" name="houseSurveyPercent">
<label>Member Survey %(RO)</label> <input type="text" id="memberPercentId" value="" maxlength="8" readonly="readonly" name="memberSurveyPercent"  class="supervisorclass">
 
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<br>
<label>Annual HV Target</label> <input id="annualhvisitedtargetId" type="text" value="" maxlength="8" class="supervisorclass" name="annualhstarget" onblur="monthlyhsTarget(this.value);annualhouseSurveyPerent();monthlyHouseSurveyPercent();annualMemberSurveyPercent();">
<label>House Visited Cum.</label> <input id="hvcummulativeId" type="text" value="" readonly="readonly" class="supervisorclass" maxlength="8" name="hvmhs">
 <label>Annual HV %(RO)</label> <input id="hvmhspercentId" type="text" value="" class="supervisorclass" readonly="readonly" name="hvmhspercent">
 
<div class="clear"></div>
<label>Monthly HV Target(RO)</label> <input id="monthlyhVisitTargetId" type="text" value="" maxlength="8" readonly="readonly" class="supervisorclass" name="monthlyhVisitTarget">
 
<label>Monthly House Visited</label> <input id="monthlyhvId" type="text" value="" class="supervisorclass" readonly="readonly" name="monthlyhv">
<label>Monthly HV%(RO)</label> <input id="monthlyhspercentId" type="text" value="" readonly="readonly" class="supervisorclass" name="monthlyhspercent">
<div class="clear"></div>
<label>Daily HV Target(RO)</label> <input id="dailyhVisitTargetId" type="text" value="" maxlength="8" readonly="readonly" class="supervisorclass" name="dailyhVisitTarget">
<!-- <label>Previous House Visited</label> <input id="lasthVisitedId" type="text" value="" maxlength="8" readonly="readonly" class="supervisorclass" name="lasthVisited">
 -->
<!-- <label>Target From Date</label> <input id="fromDateId" type="text" value="" readonly="readonly" class="supervisorclass" name="fromDate">
<label>Target To Date</label> <input id="toDateId" type="text" value="" readonly="readonly" class="supervisorclass" name="toDate">
 -->
<div class="clear"></div>
<div class="clear"></div>
</div>

<div class="clear"></div>
<label>Verification Details</label> 
 <label ><span>*</span> Verify</label> <input id="verify" type="checkbox" value="Y" validate="verified,string,yes" class="supervisorclass" name="verified" required>
<div class="clear"></div>
<input type="hidden" id="instituteNameId" name="instType" value="">
<div class="districtlevelClass" id="districtlevelClass">
<input type="hidden" name="healthsupervisor" id="healthsupervisor" value="">
<input type="hidden" name="healthinspector" id="healthinspector" value="">
 <input name="healthinspector" type="hidden" value=<%=request.getParameter("healthinspector") %>>
           
</div>
<div class="clear"></div> 
<div class="blocklevelClass" id="blocklevelId">
</div>
<div class="clear"></div> 
<input type="button" value="Submit" onclick="if(checkCheckBoxes()){submitForm('dashboardTarget','/hms/hms/pubHealth?method=dashboardAuthentication');}"/>
</div>

</div>
<input type="hidden" id="userType" name="userType" value="<%= userType%>"/>
<input type="hidden" id="hositalStatus" name="hositalStatus" value="0"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
</div>
<div class="Block">
 <div class="clear"></div>
</div>

</form>
<div id="divEnchashment"></div>
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

	function showResponses() {
	    var divs = document.getElementsByTagName('div');
	    for(var i = divs.length; i-- ;) {
	        var div = divs[i];
	        if(div.className === 'response') {
	            div.style.display = 'inline';
	        }
	    }
	}
		/* function healthblocks(){
			var healthBlockId = document.getElementById('healthBlockId').value;
			if(healthBlockId!='null'){
			alert(healthBlockId);
				//	document.getElementById('healthBlocks').value=healthBlockId;
			}else {alert('else');
				//document.getElementById('healthBlocks').value=0;
				}
		}; */
		function getListCenter(){
			var district=document.getElementById('district').value;
			var healthblock=document.getElementById('healthBlockId').value;
			var listOfCenterId=document.getElementById('ListOfCenterId').value;
			submitProtoAjaxWithDivName('dashboardTarget','/hms/hms/pubHealth?method=getPhcChclist&district='+district+'&healthblock='+healthblock+'&listOfCenterId='+listOfCenterId,'tDiv');
					};
		
	</script>
