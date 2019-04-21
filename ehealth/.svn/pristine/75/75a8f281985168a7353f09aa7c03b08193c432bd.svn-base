<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientDischargeSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript">
	<%
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

<form name="search" action="" method="post">
<%  String message="";
	if(map.get("msg")!=null){
		message=(String)map.get("msg");
		out.print(message);
	} 
	%>
<div class="titleBg">
<h2>House Survey</h2>
</div>
<div class="clear"></div>
<div class="Block">

<input type="hidden" name="currentDate"  value="<%= currentDate%>">

<%if(map.get("instituteTypeShortName") != null && (map.get("instituteTypeShortName").toString().equalsIgnoreCase("Admn") || map.get("instituteTypeShortName").toString().equalsIgnoreCase("DH"))) {%>
<label>District</label><select name="district" id="district" onchange="enableRadio();"  >
<%	if(district.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasDistrict dis : district) {
					
				  %>
	  <option value="<%=dis.getId ()%>"><%=dis.getDistrictName()%></option>
				  <%
		}}
				   %>
</select>
<% } %>
<div id="divEnchashment" style="display: none;">
<label>CHC</label><input type="radio" name="center" class="inputRadiobutton" id="center" value="chc" onclick="submitProtoAjaxWithDivName('search','/hms/hms/pubHealth?method=getSearchPhcChclist&district='+this.value,'tDiv');">
<label>PHC</label><input type="radio" name="center" class="inputRadiobutton" id="center" value="phc" onclick="submitProtoAjaxWithDivName('search','/hms/hms/pubHealth?method=getSearchPhcChclist&district='+this.value,'tDiv');">
</div>

<div class="clear"></div>
 <div id="tDiv">
	<%if(map.get("instituteTypeShortName") != null && map.get("instituteTypeShortName").toString().equalsIgnoreCase("CHC")) {%>
		<label>CHC </label>
    	<select name="chcphc" id="chcphc" onblur="submitProtoAjaxWithDivName('search','/hms/hms/pubHealth?method=getBirthBasicCenterListchcphc&chcphc='+this.value,'testDiv');">
			<!-- <option value="0">Select</option> -->
			<option value=<%=map.get("hospitalId") %>><%=map.get("hospitalName") %></option>
		</select>
		
		<div id="testDiv">
			<label>Basic-Section / Sub-center </label>
    		<select name="base" id="base" class=""  validate="">
			<% if(chcList.size() >0){ %>
				<option value="0">Select</option>
				<% for (MasHospital dis : chcList) { %>
					<option value="<%=dis.getId()%>"><%=dis.getHospitalName()%></option>
				<% }
			} %>
			</select>
		</div>
		<div class="clear"></div>
	<% } %>
	<%if(map.get("instituteTypeShortName") != null && map.get("instituteTypeShortName").toString().startsWith("PHC")) {%>
		<label>PHC </label>
		<select name="chcphc" id="chcphc" onblur="submitProtoAjaxWithDivName('search','/hms/hms/pubHealth?method=getBirthBasicCenterListchcphc&chcphc='+this.value,'testDiv');">
			<!-- <option value="0">Select</option> -->
			<option value=<%=map.get("hospitalId") %>><%=map.get("hospitalName") %></option>
		</select>
		
		<div id="testDiv">
			<label>Basic-Section / Sub-center </label>
 			<select name="base" id="base" class=""  validate="">
			<% if(chcList.size() >0){ %>
				<option value="0">Select</option>
				<% for (MasHospital dis : chcList) { %>
					<option value="<%=dis.getId()%>"><%=dis.getHospitalName()%></option>
				<% }
			} %>
			</select>
		</div>
		<div class="clear"></div>
	<% } %>
	
	<%if(map.get("instituteTypeShortName") != null && (map.get("instituteTypeShortName").toString().equalsIgnoreCase("BS") || map.get("instituteTypeShortName").toString().equalsIgnoreCase("FWC"))) {%>
		<label>Basic-Section / Sub-center </label>
		<select name="base" id="" class=""  validate="">
			<option value=<%=map.get("hospitalId") %>><%=map.get("hospitalName") %></option>
		</select>
	<% } %>
</div>
<div class="clear"></div>
 <label><span>* </span>From Date</label> 
 <input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=CurrentDate %>" name="fromDate">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.search.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
	<label><span>* </span>To Date</label>
	 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=CurrentDate %>" name="toDate">
<img width="16" height="16" border="0" onclick="javascript:setdate('',document.search.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	<label>Ward</label><select name="ward" id="ward" onchange="submitProtoAjaxWithDivNameToShowStatus('search','/hms/hms/pubHealth?method=getlocalitySearch&ward='+this.value,'teDivss');" >
<%	if(ward.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasWard wa : ward) {
					
				  %>
				  <option value="<%=wa.getId()%>"><%=wa.getWardName()%></option>
				  <%
				  	 	}}
				   %>

</select>


<div id="teDivss">
<label>Locality</label>
<select name="localityId" id="localityId" >
				<option value="0">Select</option>
</select>

<!-- <div class="clear"></div> -->


</div>
	
	<!--  <label>Village</label> <input type="text"	name="village" value="" MAXLENGTH="30" id="adNo" /> -->
	<!-- <div class="clear"></div> -->
	<label>House No</label>
	 <input type="text"	name="houseNo" value="" MAXLENGTH="30" id="adNo" />
<div class="clear"></div>
<input type="button" name="Search" id="addbutton"	onclick="if(checkData()){submitForm('search','pubHealth?method=showPublicHealthHouseSurveyJsp');}"	value="Search" class="button"  />
<div class="clear"></div>
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<!-- Changed by Arbind on 04-08-2017 -->
<%-- <div class="Block">
<h4>Survey Details</h4>
<div id="pageNavPosition"></div>
<%if(phHouseSurveys.size()>0){ %>
<table>
	<tr><th>S.No</th><th>Survey Date</th><th>Village</th><th>House No</th><th>Address</th></tr>
<tbody id="tableData">
	<% 
		 int  counter=0; 
 		for(PhHouseSurvey phHouseSurvey:phHouseSurveys){ 
	%> 
			<form name="phHouseSurveys<%= counter+1%>" method="post">
			<input type="hidden" name="requestId" value="<%=phHouseSurvey.getHouseHoldId() %>" />
			<tr onclick="submitForm('phHouseSurveys<%=counter+1%>', 'pubHealth?method=phFamilySurveys')" style="cursor: pointer;">
			<td><%= counter+1%></td>
		    <td><%= phHouseSurvey.getHouseSurveyDate()!=null ? HMSUtil.changeDateToddMMyyyy(phHouseSurvey.getHouseSurveyDate()):""%></td>
		    <td><%= phHouseSurvey.getVillage() !=null ? phHouseSurvey.getVillage().getVillageName():""%></td>
		    <td><%= phHouseSurvey.getLsgHouseNo()!=null ? phHouseSurvey.getLsgHouseNo():""%></td>
		    <td><%= phHouseSurvey.getAddress()!=null ? phHouseSurvey.getAddress():""%></td></tr>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		    </form>
<%		++counter;
				} 
 	%> 
 	</tbody>
	</table>
	<%}else{ %>
	No Records Available.
	<%} %>
	
	
	<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
		</script>
	</div> --%>
	
<form name="itemGrid" method="post">
 
 <% int currentPage=0;
int noOfPages=0;
if(null !=map.get("currentPage")){
	currentPage=(Integer)map.get("currentPage");
    noOfPages=(Integer)map.get("noOfPages");
}
if(phHouseSurveys.size()>0){%>
 
 	<div class="Block">
	<table>
		<tr><th>S.No</th><th>Survey Date</th><th>Village</th><th>House No</th><th>Address</th></tr>
    	<% 
		int  counter = (currentPage - 1) * 5; 
 		for(PhHouseSurvey phHouseSurvey:phHouseSurveys){ %> 
			<input type="hidden" name="requestId" value="<%=phHouseSurvey.getHouseHoldId() %>" />
			<tr onclick="submitForm('itemGrid', 'pubHealth?method=phFamilySurveys')" style="cursor: pointer;">
			<td><%= counter+1%></td>
		    <td><%= phHouseSurvey.getHouseSurveyDate()!=null ? HMSUtil.changeDateToddMMyyyy(phHouseSurvey.getHouseSurveyDate()):""%></td>
		    <td><%= phHouseSurvey.getVillage() !=null ? phHouseSurvey.getVillage().getVillageName():""%></td>
		    <td><%= phHouseSurvey.getLsgHouseNo()!=null ? phHouseSurvey.getLsgHouseNo():""%></td>
		    <td><%= phHouseSurvey.getAddress()!=null ? phHouseSurvey.getAddress():""%></td></tr>
 			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			<% ++counter;
		} %>
	</table>
    
	<%if(currentPage !=1){%>
		<a href='/hms/hms/pubHealth?method=showPublicHealthHouseSurveyJsp&page=<%=currentPage-1%>'>Previous</a>
	<%}
	if(noOfPages>=1){%>
		<a href='/hms/hms/pubHealth?method=showPublicHealthHouseSurveyJsp&page=<%=currentPage%>'><%=currentPage%></a>
	<%}
	if(currentPage <noOfPages){%>
		<a href='/hms/hms/pubHealth?method=showPublicHealthHouseSurveyJsp&page=<%=currentPage+1%>'>Next</a>
	<%}%>
	<div class="Block">
		<input type="text" id="inPage" tabindex="2"	maxlength="4" style="width:30px;"/>
		<input type="button" value="Go" tabindex="2" onclick="searchParticularPage();"/> 
		<label> No of Pages :  <%=noOfPages%></label>
	</div>
	<%}
	else{%>
		<font size="4" color="red">No Record Found </font>
	<%}%>
	<div class="clear"></div>
    
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
   <div class="clear"></div>
 <div class="clear"></div>
	<div class="bottom">
		<label>Changed By:</label>
		<label class="value"><%=userName%></label>
		<label>Changed Date:</label>
		<label class="value"><%=currentDate%></label>
		<label>Changed Time:</label>
		<label class="value"><%=currentTime%></label>
	</div>
<!--Block Two Ends-->
	<div class="clear"></div>
	<div class="paddingTop15"></div>
	<div class="clear"></div>
	<!--Bottom labels starts-->
	<div class="bottom">
	<input type="hidden" name="lastChgBy" value="<%=userName%>" />
	<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
	<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
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

	function searchParticularPage(type){
		var curPage=document.getElementById("inPage").value;
		if(!curPage || isNaN(curPage)){
			curPage=1;
		}
		submitForm('itemGrid','/hms/hms/pubHealth?method=showPublicHealthHouseSurveyJsp&page='+curPage);
	}
	</script>