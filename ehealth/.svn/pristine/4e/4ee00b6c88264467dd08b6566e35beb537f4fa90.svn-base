<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>

<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MisFatalTracking"%>



<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css"></link>

<br />
<div id="contentspace"><script type="text/javascript"
	language="javascript">
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
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <%
	 			
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 			
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	String hinNo=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<Inpatient> inpatientList = new ArrayList<Inpatient>();
				List<MisFatalTracking> misFatalTrackingList = new ArrayList<MisFatalTracking>();
			 	Date dateOfDeath=null;
			 	if (map.get("inpatientList") != null) {
			 		inpatientList = (List<Inpatient>) map.get("inpatientList");
			 	}
			 	
			 	if (map.get("misFatalTrackingList") != null) {
			 		misFatalTrackingList = (List<MisFatalTracking>) map.get("misFatalTrackingList");
			 	}
			 
			 			 	
			 %> <%
			if(inpatientList.size() >0){
				for(Inpatient inpatient :inpatientList){
		%>
<div id="show1">

<div
	style="width: 15px; height: 20px; BORDER-bottom: #3c8ad7 1px solid; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Personnel Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 165px; background-color: #f4f9fe;">


<div style="height: auto; width: auto;"><label class="bodytextB">IP
No.:</label> <%if(inpatient.getAdNo()!=null){ %> <span class="normalspan"><%=inpatient.getAdNo()%></span>
<% session.setAttribute("adNo",inpatient.getAdNo()); 
		}else{%> <span class="normalspan">-</span> <%}%> <br />
<label class="bodytextB">Patient Name:</label> <%if(inpatient.getHin()!=null){ %>
<span class="normalspan"><%=inpatient.getHin().getPFirstName()%>
<%=inpatient.getHin().getPLastName()%></span> <%}else{ %> <span
	class="normalspan">-</span> <%}%> <label class="bodytextB">Sex:</label> <%if(inpatient.getHin()!=null){ %>
<span class="normalspan"><%=inpatient.getHin().getSex().getAdministrativeSexName()%></span>
<%}else{ %> <span class="normalspan">-</span> <%}%> <label class="bodytextB">Sex:</label>
<%if(inpatient.getHin()!=null){ %> <label class="bodytextB">Relation:</label>
<%}else{ %> <span class="normalspan">-</span> <%}%> <%if(inpatient.getHin().getRelation()!=null){ %>
<span class="normalspan"><%=inpatient.getHin().getRelation().getRelationName()%></span>
<%} else{%> <span class="normalspan">-</span> <%}%> <label class="bodytextB">Service
No.</label> <%if(inpatient.getHin().getServiceNo()!=null){ %> <span
	class="normalspan"><%=inpatient.getHin().getServiceNo()%></span> <%} else { %>
<span class="normalspan">-</span> <%} %> <label class="bodytextB">Rank:</label>
<%if(inpatient.getHin().getRank()!=null){ %> <span class="normalspan"><%= inpatient.getHin().getRank().getRankName()%></span>
<%}else {%> <span class="normalspan">-</span> <%} %> <label
	class="bodytextB">Service Name:</label> <%if( inpatient.getHin().getSFirstName()!=null && inpatient.getHin().getSLastName()!=null){ %>
<span class="normalspan"><%= inpatient.getHin().getSFirstName()%>
<%= inpatient.getHin().getSLastName()%></span> <%} else {%> <span
	class="normalspan">-</span> <%}%> <label class="bodytextB">Unit</label> <%if(inpatient.getHin().getUnit()!=null){ %>
<span class="normalspan"><%= inpatient.getHin().getUnit().getUnitName()%></span>
<%} else{%> <span class="normalspan">-</span> <%} %> <label
	class="bodytextB">Service:</label> <%if(inpatient.getHin().getServiceType()!=null){ %>
<span class="normalspan"><%=inpatient.getHin().getServiceType().getServiceTypeName()%></span>
<%} else{%> <span class="normalspan">-</span> <%} %> <br />

<label class="bodytextB">Branch Trade:</label> <%
		if(inpatient.getHin().getTrade()!=null){%> <span class="normalspan"><%=inpatient.getHin().getTrade().getTradeName()%></span>
<%} else{%> <span class="normalspan">-</span> <%} %> <label
	class="bodytextB">Total service:</label> <%if(inpatient.getHin().getServiceYears()!=null){ %>
<span class="normalspan"><%=inpatient.getHin().getServiceYears()%></span>
<%} else{%> <span class="normalspan">-</span> <%} %> <label
	class="bodytextB">Ward </label> <%if(inpatient.getDepartment()!=null){ %>
<span class="normalspan"><%=inpatient.getDepartment().getDepartmentName()%></span>
<%}else{ %> <span class="normalspan">-</span> <%}%> <label class="bodytextB">Age:</label>
<%if(inpatient.getHin()!=null){ %> <span class="normalspan"><%=HMSUtil.calculateAgeForADT(inpatient.getHin().getAge(),inpatient.getHin().getRegDate())%></span>
<%}else{ %> <span class="normalspan">-</span> <%}%> <label class="bodytextB">DOB:</label>
<%if(inpatient.getHin().getDateOfBirth()!=null){ %> <span
	class="normalspan"><%=HMSUtil.convertDateToStringWithoutTime(inpatient.getHin().getDateOfBirth())%></span>
<%} else{%> <span class="normalspan">-</span> <%} %> <label
	class="bodytextB">Date of Death:</label> <%if(inpatient.getDischargeDate()!=null){ %>
<span class="normalspan"><%=HMSUtil.convertDateToStringWithoutTime(inpatient.getDischargeDate())%></span>
<%}else{ %> <span class="normalspan">-</span> <%}%> <label class="bodytextB">Diagnosis:</label>
<input type="hidden" name="hinId"
	value="<%=inpatient.getHin().getId()%>" /> <%}}else{%>
<h4><span>No Records found</span></h4>
<%}%>
</div>
</div>
</div>
<%
	int misFatalId  =0;
	String dod ="";
	String dodRemarks ="";
	
	String postmortem="";
	String postmortemRemarks ="";
	
	String dateOfPostmortem="";
	String dateOfPostmortemRemarks="";
	
	String documents="";
	String documentsRemarks ="";
	
	String receivedFrom ="";
	String receivedFromRemarks ="";
	
	String completion ="";
	String completionRemarks ="";
	
	String signature="";
	String signatureRemarks ="";
	
	String HODPersual="";
	String HODPersualRemarks ="";
	
	String date1="";
	String date1Remarks ="";
	
	String date2="";
	String date2Remarks ="";
	
	String date3="";
	String date3Remarks ="";
	
	String date4="";
	String date4Remarks ="";
	
	String date5="";
	String date5Remarks ="";
	
	String date6="";
	String date6Remarks ="";
	
	String date7="";
	String date7Remarks ="";
	
	String date8="";
	String date8Remarks ="";
	
	
	if(misFatalTrackingList.size() >0){
		for(MisFatalTracking fatalTracking :misFatalTrackingList){
			misFatalId  =fatalTracking.getId();
			if(fatalTracking.getDateofDeath() !=null){
				dod=HMSUtil.convertDateToStringWithoutTime(fatalTracking.getDateofDeath());
			}
			if(fatalTracking .getDateofDeathRem() !=null)
				dodRemarks=fatalTracking .getDateofDeathRem();
			if(fatalTracking .getPostmortem() !=null)
				postmortem =fatalTracking.getPostmortem();
			if(fatalTracking .getPostmortemRem() !=null)
				postmortemRemarks =fatalTracking.getPostmortemRem();
			if(fatalTracking .getDateofPostRec() !=null)
				dateOfPostmortem =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getDateofPostRec());
			if(fatalTracking .getDateofPostRecRem() !=null)
				dateOfPostmortemRemarks =fatalTracking.getDateofPostRecRem();
			if(fatalTracking .getHoSplconceDate() !=null)
				documents =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getHoSplconceDate());
			if(fatalTracking .getHoSplconceRem() !=null)
				documentsRemarks =(fatalTracking.getHoSplconceRem());
			if(fatalTracking .getRecSplOpDate() !=null)
				receivedFrom =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getRecSplOpDate());
			if(fatalTracking .getRecSplOpRem() !=null)
				receivedFromRemarks =(fatalTracking.getRecSplOpRem());
			
			if(fatalTracking.getWardMaster() !=null)
				completion =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getWardMaster());
			if(fatalTracking .getWardMasterRem() !=null)
				completionRemarks =(fatalTracking.getWardMasterRem());
			
			if(fatalTracking .getMoicWard() !=null)
				signature =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getMoicWard());
			if(fatalTracking .getMoicWardRem() !=null)
				signatureRemarks =(fatalTracking.getMoicWardRem());
			
			if(fatalTracking .getHodPerusal() !=null)
				HODPersual =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getHodPerusal());
			if(fatalTracking .getHodPerusalRem() !=null)
				HODPersualRemarks =(fatalTracking.getHodPerusalRem());
			
			if(fatalTracking .getStatasWard() !=null)
				date1 =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getStatasWard());
			if(fatalTracking .getStatasWardRem() !=null)
				date1Remarks =(fatalTracking.getStatasWardRem());
			
			if(fatalTracking .getCommanRemarks() !=null)
				date2 =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getCommanRemarks());
			if(fatalTracking .getCommanRemarksRem() !=null)
				date2Remarks =(fatalTracking.getCommanRemarksRem());
			
			if(fatalTracking .getPatologyHead() !=null)
				date3 =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getPatologyHead());
			if(fatalTracking .getPatologyHeadRem() !=null)
				date3Remarks =(fatalTracking.getPatologyHeadRem());
			
			if(fatalTracking .getSeniorAdvisor1() !=null)
				date4 =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getSeniorAdvisor1());
			if(fatalTracking .getSeniorAdvisor1Rem() !=null)
				date4Remarks =(fatalTracking.getSeniorAdvisor1Rem());
			
			if(fatalTracking .getSeniorAdvisor2() !=null)
				date5 =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getSeniorAdvisor2());
			if(fatalTracking .getSeniorAdvisor2Rem() !=null)
				date5Remarks =(fatalTracking.getSeniorAdvisor2Rem());
			
			if(fatalTracking .getSeniorAdvisor3() !=null)
				date6 =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getSeniorAdvisor3());
			if(fatalTracking .getSeniorAdvisor3Rem() !=null)
				date6Remarks =(fatalTracking.getSeniorAdvisor3Rem());
			
			if(fatalTracking .getSeniorAdvisor4() !=null)
				date7 =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getSeniorAdvisor4());
			if(fatalTracking .getSeniorAdvisor4Rem() !=null)
				date7Remarks =(fatalTracking.getSeniorAdvisor4Rem());
			
			if(fatalTracking .getDespatchCommandant() !=null)
				date8 =HMSUtil.convertDateToStringWithoutTime(fatalTracking.getDespatchCommandant());
			if(fatalTracking .getDespatchCommandantRem() !=null)
				date8Remarks =(fatalTracking.getDespatchCommandantRem());
		}
	} %>
<div style="width: 15px; height: 20px; float: left;"></div>
<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Dispatch Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />
<div style="BORDER: #ffffff 1px solid;">
<table width="98%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header">
	<thead>
		<tr>
			<td width="28" class="gridheaderlabel">S.No.</td>
			<td width="272" class="gridheaderlabel">Details of Dispatch</td>
			<td width="171" class="gridheaderlabel">Date</td>
			<td width="335" class="gridheaderlabel">Remarks</td>
		</tr>

	</thead>
	<tbody>


		<tr>
			<td height="22">1.</td>
			<td>Date of Death</td>
			<td><input type="text" id="dateOfExpiryId"
				name="<%=DATE_OF_DEATH%>" value="<%=dod%>" class="textbox_size20"
				readonly="readonly" MAXLENGTH="30" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_DEATH%>,event)" />
			</td>
			<td><input name="<%=DEATH_REMARK %>" type="text" size="55"
				value="<%=dodRemarks%>"></td>
		</tr>
		<tr>
			<td height="22">2.</td>
			<td>Postmortem</td>
			<td><select id="postmortem" name="<%=POSTMORTEM %>">
				<%if(postmortem.equals("y")){ %>
				<option value="y" selected="selected">Held</option>
				<option value="n">Not Held</option>
				<%}else {%>
				<option value="y">Held</option>
				<option value="n" selected="selected">Not Held</option>
				<%} %>
			</select></td>
			<td><input name="<%=POSTMORTEM_REMARK %>" type="text" size="55"
				value="<%=postmortemRemarks%>"></td>
		</tr>
		<tr>
			<td height="22">3.</td>
			<td>Date of Postmortem Received</td>
			<td><input type="text" name="<%=DATE_OF_POSTMORTEM %>"
				value="<%=dateOfPostmortem %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_POSTMORTEM%>,event)" />
			</td>
			<td><input name="<%=POSTMORTEM_DATE_REMARK %>" type="text"
				size="55" value="<%=dateOfPostmortemRemarks %>"></td>
		</tr>
		<tr>
			<td height="22">4.</td>
			<td>Documents H/O spl concerned Date</td>
			<td><input type="text" name="<%=DATE_OF_CONCERNED %>"
				value="<%=documents %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_CONCERNED%>,event)" />
			</td>
			<td><input name="<%=CONCERNED_DATE_REMARK %>" type="text"
				size="55" value="<%=documentsRemarks %>"></td>
		</tr>
		<tr>
			<td height="22">5.</td>
			<td>Received from spl with opinion and Date</td>
			<td><input type="text" name="<%=DATE_OF_OPINION %>"
				value="<%=receivedFrom %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_OPINION%>,event)" />
			</td>
			<td><input name="<%=OPINION_DATE_REMARK %>" type="text"
				size="55" value="<%=receivedFromRemarks %>"></td>
		</tr>
		<tr>
			<td height="22">6.</td>
			<td>Completion of documents by Ward Master and Date</td>
			<td><input type="text" name="<%=DATE_OF_WARD_MASTER %>"
				value="<%=completion %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_WARD_MASTER%>,event)" />
			</td>
			<td><input name="<%=WARD_MASTER_DATE_REMARK %>" type="text"
				size="55" value="<%=completionRemarks %>"></td>
		</tr>
		<tr>
			<td height="22">7.</td>
			<td>Signature of MO i/c Ward</td>
			<td><input type="text" name="<%=DATE_OF_MO_WARD %>"
				value="<%=signature %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_MO_WARD%>,event)" />
			</td>
			<td><input name="<%=WARD_REMARK %>" type="text" size="55"
				value="<%=signatureRemarks %>"></td>
		</tr>
		<tr>
			<td height="22">8.</td>
			<td>HOD persual on (Date)</td>
			<td><input type="text" name="<%=DATE_OF_HOD %>"
				value="<%=HODPersual %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_HOD%>,event)" />
			</td>
			<td><textarea name="<%=HOD_DATE_REMARK %>"
				validate="Kin Address,string,Yes" id="nokAddr" cols="53" rows="3"
				onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				maxlength="50" tabindex="1" /><%=HODPersualRemarks %></td>
		</tr>
		<tr>
			<td height="22">9.</td>
			<td>Date of submission of Stats by Ward Master</td>
			<td><input type="text" name="<%=DATE_OF_STATS %>"
				value="<%=date1 %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_STATS%>,event)" />
			</td>
			<td><input name="<%=STATS_DATE_REMARK %>" type="text" size="55"
				value="<%=date1Remarks %>"></td>
		</tr>
		<tr>
			<td height="22">10.</td>
			<td>Date of submission for remarks of commandant</td>
			<td><input type="text" name="<%=DATE_OF_COMMANDANT %>"
				value="<%=date2 %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_COMMANDANT%>,event)" />
			</td>
			<td><textarea name="<%=COMMANDANT_DATE_REMARK %>"
				validate="Kin Address,string,Yes" id="nokAddr" cols="53" rows="3"
				onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				maxlength="50" tabindex="1" /><%=date2Remarks %></td>
		</tr>
		<tr>
			<td height="22">11.</td>
			<td>Date of Dispatch to Senior Advisor Pathology for Persual</td>
			<td><input type="text" name="<%=DATE_OF_PATHOLOGY %>"
				value="<%=date3 %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_PATHOLOGY%>,event)" />
			</td>
			<td><input name="<%=PATHOLOGY_DATE_REMARK %>" type="text"
				size="55" value="<%=date3Remarks %>"></td>
		</tr>
		<tr>
			<td height="22">12.</td>
			<td>Date of Dispatch to Senior Advisor for Persual</td>
			<td><input type="text" name="<%=DATE_OF_SENIOR_ADVISOR_1 %>"
				value="<%=date4 %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_SENIOR_ADVISOR_1%>,event)" />
			</td>
			<td><input name="<%=SA1_DATE_REMARK %>" type="text" size="55"
				value="<%=date4Remarks %>"></td>
		</tr>
		<tr>
			<td height="22">13.</td>
			<td>Date of Dispatch to Senior Advisor for Persual</td>
			<td><input type="text" name="<%=DATE_OF_SENIOR_ADVISOR_2 %>"
				value="<%=date5 %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_SENIOR_ADVISOR_2%>,event)" />
			</td>
			<td><input name="<%=SA2_DATE_REMARK %>" type="text" size="55"
				value="<%=date5Remarks %>"></td>
		</tr>
		<tr>
			<td height="22">14.</td>
			<td>Date of Dispatch to Senior Advisor for Persual</td>
			<td><input type="text" name="<%=DATE_OF_SENIOR_ADVISOR_3 %>"
				value="<%=date6 %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_SENIOR_ADVISOR_3%>,event)" />
			</td>
			<td><input name="<%=SA3_DATE_REMARK %>" type="text" size="55"
				value="<%=date6Remarks%>"></td>
		</tr>
		<tr>
			<td height="22">15.</td>
			<td>Date of Dispatch to Senior Advisor for Persual</td>
			<td><input type="text" name="<%=DATE_OF_SENIOR_ADVISOR_4 %>"
				value="<%=date7 %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_SENIOR_ADVISOR_4%>,event)" />
			</td>
			<td><input name="<%=SA4_DATE_REMARK %>" type="text" size="55"
				value="<%=date7Remarks %>"></td>
		</tr>
		<tr>
			<td height="22">16.</td>
			<td>Date of Dispatch to Concerned Command for Persual</td>
			<td><input type="text" name="<%=DATE_OF_CONCERNED_COMMAND %>"
				value="<%=date8 %>" class="textbox_size20" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_CONCERNED_COMMAND%>,event)" />
			</td>
			<td><input name="<%=CONCERNED_COMMAND_DATE_REMARK %>"
				type="text" size="55" value="<%=date8Remarks %>"></td>
		</tr>
	</tbody>
</table>
</div>

<input type="hidden" name="<%=MIS_FATAL_ID%>" value="<%=misFatalId %>"
	class="textbox_date" MAXLENGTH="10" /> <br />

<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>"
	class="textbox_size20" readonly="readonly" MAXLENGTH="8" / tabindex=3 />
<input type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <input
	type="button" name="edit" value="Submit" class="button"
	onClick="submitForm('fatalCase','mis?method=editFatalCase');" />
	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
