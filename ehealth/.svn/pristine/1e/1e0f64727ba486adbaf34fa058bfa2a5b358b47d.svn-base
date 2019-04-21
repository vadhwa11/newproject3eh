
<%@page import="jkt.hms.masters.business.PhFamilySurvey"%>
<%@page import="jkt.hms.masters.business.PhHouseSurvey"%>
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
		List<PhFamilySurvey> phFamilySurveys=new ArrayList<PhFamilySurvey>();
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}
		if(map.get("phFamilySurveys")!=null){
			phFamilySurveys=(List<PhFamilySurvey>)map.get("phFamilySurveys");
		}
		String CurrentDate=date+"/"+month+"/"+year;
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
		
	function checkData(){
// 		 if(start<=end){
				 return true;
// 			 }else{alert("Date is Incorrect.");return false;}
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
<h2>Family Survey</h2>
</div>
<div class="clear"></div>
<div class="Block">
	 <label>Family Name</label> <input type="text"	name="familyName" value="" MAXLENGTH="30" id="adNo" />
	<label>Ration Card</label>
	 <input type="text"	name="rationCard" value="" MAXLENGTH="30" id="adNo" />
	 <label>Contact</label>
	 <input type="hidden" name="requestId" value="<%=phFamilySurveys.size()>0 ? phFamilySurveys.get(0).getFamilyId():"" %>" />
	 <input type="text"	name="contact" value="" MAXLENGTH="30" id="adNo" />
<div class="clear"></div>
</div>
<input type="button" name="Search" id="addbutton"	onclick="if(checkData()){submitForm('search','pubHealth?method=phFamilySurveys');}"	value="Search" class="button"  />


	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<h4>Family Details</h4>
<div class="clear"></div>
<div class="Block">
<%if(phFamilySurveys.size()>0){ %>
<table>
	<tr><th>S.No</th><th>Family Name</th><th>Ration Card No</th><th>Contact No</th></tr>

	<% 
		 int  counter=0; 
 		for(PhFamilySurvey phFamilySurvey:phFamilySurveys){ 
	%> 
			<form name="phHouseSurveys<%= counter+1%>" method="post"><input type="hidden" name="requestId" value="<%=phFamilySurvey.getFamilyId() %>" />
			<tr onclick="submitForm('phHouseSurveys<%= counter+1%>', 'pubHealth?method=phEligibleCouple')" style="cursor: pointer;">
			<td><%= counter+1%></td>
		    <td><%= phFamilySurvey.getFamilyName()!=null ? phFamilySurvey.getFamilyName():"-"%></td>
		    <td><%=phFamilySurvey.getRationCardNo()!=null ? phFamilySurvey.getRationCardNo():"-"%></td>
		    <td><%=phFamilySurvey.getContactNo()!=null ? phFamilySurvey.getContactNo():"-"%></td></tr>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		    </form>
<%		++counter;
				} 
 	%> 
	</table>
	<%}else{ %>
	No Records Available.
	<%} %>
	</div>
   <div class="clear"></div>
   <input type="button" name="Search" id="addbutton"	onclick="javascript:history.back(-1)"	value="Back" class="button"  />
   
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