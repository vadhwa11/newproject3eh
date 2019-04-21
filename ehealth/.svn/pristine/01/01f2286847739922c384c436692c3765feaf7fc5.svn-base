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
<%@page import="jkt.hms.masters.business.PhMemberSurvey"%>
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
		List<PhMemberSurvey> phEligbleCoupleRegs=new ArrayList<PhMemberSurvey>();
		if(request.getAttribute("map")!=null){
			map=(Map<String ,Object>)request.getAttribute("map");
		}
		if(map.get("phEligbleCoupleRegs")!=null){
			phEligbleCoupleRegs=(List<PhMemberSurvey>)map.get("phEligbleCoupleRegs");
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
<h2>Member Survey</h2>
</div>
<div class="clear"></div>

<div class="Block">
<%if(phEligbleCoupleRegs.size()>0){ 
	%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"      id="voucherDetails" class="cmntable">
	 <tr>
   		<th scope="col">Member Name</th>
		<th scope="col">Gender</th>
		<th scope="col">Date Of Birth</th>
		<th scope="col">Contact No.</th>
		</tr>
	<%for(PhMemberSurvey eligbleCoupleReg:phEligbleCoupleRegs){
%>

 <tr>
 <td><%=eligbleCoupleReg.getName() !=null ? eligbleCoupleReg.getName():""%></td>
 <td><%=eligbleCoupleReg.getGender() !=null ? eligbleCoupleReg.getGender().getAdministrativeSexName():""%></td>
 <td><%=eligbleCoupleReg.getDateOfBirth() !=null ? HMSUtil.convertDateTypeToStringWithoutTime(eligbleCoupleReg.getDateOfBirth()):""%></td>
 <td><%=eligbleCoupleReg.getContactNo() !=null ? eligbleCoupleReg.getContactNo():""%></td>
 </tr>


	<%}}else{ %>
	 <tr><td  colspan="4">No Records Available.</td></tr>
	<%} %>
	</table>
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
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>