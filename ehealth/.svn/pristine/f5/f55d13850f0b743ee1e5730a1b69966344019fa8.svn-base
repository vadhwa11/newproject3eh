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



<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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
		
		
	</script>


<h2 align="left" class="style1">Fatal Documents Tracking</h2>

<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 			
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	String hinNo=null;
			 	//String dateOfDeath=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<Object> list = null;
			 	
			 	Date dateOfDeath=null;
			 	
			 		
			 	
			 	if (map.get("showList") != null) {
			 		list = (List<Object>) map.get("showList");
			 		session.setAttribute("list", list);
			 	}
			 				 
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>

<%    
					   
					  }		 	
			 %>

<form name="fatalCase" method="post" action="">
<%if(session.getAttribute("hinNo")!=null)
				 {
				 		hinNo=(String)session.getAttribute("hinNo");
				 }
				 else
				 {	 hinNo="";
				 }%> <label class="bodytextB">Service No:</label> <input
	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""
	class="textbox_date" MAXLENGTH="30" validate="serviceNo,string,no"
	onblur="submitProtoAjaxWithDivName('fatalCase','mis?method=getHinAdNoDetailsFatalCase&flag=hin','hinDiv')" />
<div id="hinDiv"><label class="bodytextB"> HIN:</label> <input
	type="text" name="<%=HIN_NO%>" value="" class="textbox_date"
	MAXLENGTH="30" validate="hinNo,metachar,no"
	onchange="submitProtoAjaxWithDivName('fatalCase','mis?method=getAdmissionNoList&flag=admission&fatalCase=yes','testDiv')" />
</div>
<div id="testDiv"><label class="bodytextB"><font
	id="error">*</font>IP No:</label> <input type="text" id="frwSlno"
	name="<%=AD_NO%>" value="" validate="AD No.,metachar,yes" class="textbox_date"
	MAXLENGTH="30"
	onblur="submitProtoAjaxWithDivName('fatalCase','mis?method=showFatalCase','show');" />
</div>
<div id="show">
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
			<td>
			<%if(session.getAttribute("dateOfDeath")!=null){ %> <input type="text"
				id="dateOfExpiryId" name="<%=DATE_OF_DEATH%>"
				value="<%=session.getAttribute("dateOfDeath")%>"
				class="textbox_date" readonly="readonly" MAXLENGTH="30" validate="DOD,date,no"/> <%}else{%>
			<input type="text" id="dateOfExpiryId" name="<%=DATE_OF_DEATH%>"
				value="" class="textbox_date" readonly="readonly" MAXLENGTH="30" validate="DOD,date,no"/>
			<%} %>
			</td>
			<td><input name="<%=DEATH_REMARK %>" type="text" size="55" validate="Remark,remarks,no"></td>
		</tr>
		<tr>
			<td height="22">2.</td>
			<td>Postmortem</td>
			<td><select id="postmortem" name="<%=POSTMORTEM %>" validate="postmortem,string,no">
				<option value="y">Held</option>
				<option value="n">Not Held</option>
			</select></td>
			<td><input name="<%=POSTMORTEM_REMARK %>" type="text" size="55" validate="postmortemR,string,no"></td>
		</tr>
		<tr>
			<td height="22">3.</td>
			<td>Date of Postmortem Received</td>
			<td><input type="text" name="<%=DATE_OF_POSTMORTEM %>" value=""
				class="textbox_size20" tabindex=3 readonly="readonly" validate="DOP,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_POSTMORTEM%>,event)" />
			</td>
			<td><input name="<%=POSTMORTEM_DATE_REMARK %>" type="text"
				size="55" validate="postmortemR,date,no"></td>
		</tr>
		<tr>
			<td height="22">4.</td>
			<td>Documents H/O spl concerned Date</td>
			<td><input type="text" name="<%=DATE_OF_CONCERNED %>" value=""
				class="textbox_size20" tabindex=3 readonly="readonly" validate="DOC,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_CONCERNED%>,event)" />
			</td>
			<td><input name="<%=CONCERNED_DATE_REMARK %>" type="text"
				size="55" validate="CoDR,string,no"></td>
		</tr>
		<tr>
			<td height="22">5.</td>
			<td>Received from spl with opinion and Date</td>
			<td><input type="text" name="<%=DATE_OF_OPINION %>" value=""
				class="textbox_size20" tabindex=3 readonly="readonly" validate="DOOp,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_OPINION%>,event)" />
			</td>
			<td><input name="<%=OPINION_DATE_REMARK %>" type="text"
				size="55" validate="CoOpR,string,no"></td>
		</tr>
		<tr>
			<td height="22">6.</td>
			<td>Completion of documents by Ward Master and Date</td>
			<td><input type="text" name="<%=DATE_OF_WARD_MASTER %>" value=""
				class="textbox_size20" tabindex=3 readonly="readonly" validate="DOWM,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_WARD_MASTER%>,event)" />
			</td>
			<td><input name="<%=WARD_MASTER_DATE_REMARK %>" type="text"
				size="55" validate="WardM,string,no"></td>
		</tr>
		<tr>
			<td height="22">7.</td>
			<td>Signature of MO i/c Ward</td>
			<td><input type="text" name="<%=DATE_OF_MO_WARD %>" value=""
				class="textbox_size20" tabindex=3 readonly="readonly"  validate="DOS,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_MO_WARD%>,event)" />
			</td>
			<td><input name="<%=WARD_REMARK %>" type="text" size="55" validate="WardM,string,no"></td>
		</tr>
		<tr>
			<td height="22">8.</td>
			<td>HOD persual on (Date)</td>
			<td><input type="text" name="<%=DATE_OF_HOD %>" value=""
				class="textbox_size20" tabindex=3 readonly="readonly" validate="DOS,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_HOD%>,event)" />
			</td>
			<td><input name="<%=HOD_DATE_REMARK%>" type="text" size="55" validate="HOD,string,no">
			<%-- <textarea name="<%=HOD_DATE_REMARK %>" cols="53" rows="3"
				onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				maxlength="50" tabindex="1" /> --%></td>
		</tr>
		<tr>
			<td height="22">9.</td>
			<td>Date of submission of Stats by Ward Master</td>
			<td><input type="text" name="<%=DATE_OF_STATS %>" value=""
				class="textbox_size20" tabindex=3 readonly="readonly" validate="DOS,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_STATS%>,event)" />
			</td>
			<td><input name="<%=STATS_DATE_REMARK %>" type="text" size="55" validate="SDR,string,no"></td>
		</tr>
		<tr>
			<td height="22">10.</td>
			<td>Date of submission for remarks of commandant</td>
			<td><input type="text" name="<%=DATE_OF_COMMANDANT %>" value=""
				class="textbox_size20" tabindex=3 readonly="readonly" validate="DOS,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_COMMANDANT%>,event)" />
			</td>
			<td><input name="<%=COMMANDANT_DATE_REMARK %>" type="text" size="55" validate="CDR,string,no">
			<%-- <textarea name="<%=COMMANDANT_DATE_REMARK %>"
				validate="Kin Address,string,Yes" id="nokAddr" cols="53" rows="3"
				onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				maxlength="50" tabindex="1" /> --%></td>
		</tr>
		<tr>
			<td height="22">11.</td>
			<td>Date of Dispatch to Senior Advisor Pathology for Persual</td>
			<td><input type="text" name="<%=DATE_OF_PATHOLOGY %>" value=""
				class="textbox_size20" tabindex=3 readonly="readonly" validate="DODt,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_PATHOLOGY%>,event)" />
			</td>
			<td><input name="<%=PATHOLOGY_DATE_REMARK %>" type="text" size="55" validate="PDR,string,no"></td>
		</tr>
		<tr>
			<td height="22">12.</td>
			<td>Date of Dispatch to Senior Advisor for Persual</td>
			<td><input type="text" name="<%=DATE_OF_SENIOR_ADVISOR_1 %>"
				value="" class="textbox_size20" tabindex=3 readonly="readonly" validate="DOP,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_SENIOR_ADVISOR_1%>,event)" />
			</td>
			<td><input name="<%=SA1_DATE_REMARK %>" type="text" size="55" validate="DOPR,string,no"></td>
		</tr>
		<tr>
			<td height="22">13.</td>
			<td>Date of Dispatch to Senior Advisor for Persual</td>
			<td><input type="text" name="<%=DATE_OF_SENIOR_ADVISOR_2 %>"
				value="" class="textbox_size20" tabindex=3 readonly="readonly" validate="DOP,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_SENIOR_ADVISOR_2%>,event)" />
			</td>
			<td><input name="<%=SA2_DATE_REMARK %>" type="text" size="55" validate="DOPR,string,no"></td>
		</tr>
		<tr>
			<td height="22">14.</td>
			<td>Date of Dispatch to Senior Advisor for Persual</td>
			<td><input type="text" name="<%=DATE_OF_SENIOR_ADVISOR_3 %>"
				value="" class="textbox_size20" tabindex=3 readonly="readonly" validate="DOP,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_SENIOR_ADVISOR_3%>,event)" />
			</td>
			<td><input name="<%=SA3_DATE_REMARK %>" type="text" size="55" validate="DOPR,string,no"></td>
		</tr>
		<tr>
			<td height="22">15.</td>
			<td>Date of Dispatch to Senior Advisor for Persual</td>
			<td><input type="text" name="<%=DATE_OF_SENIOR_ADVISOR_4 %>"
				value="" class="textbox_size20" tabindex=3 readonly="readonly" validate="DOP,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_SENIOR_ADVISOR_4%>,event)" />
			</td>
			<td><input name="<%=SA4_DATE_REMARK %>" type="text" size="55" validate="DOPR,string,no"></td>
		</tr>
		<tr>
			<td height="22">16.</td>
			<td>Date of Dispatch to Concerned Command for Persual</td>
			<td><input type="text" name="<%=DATE_OF_CONCERNED_COMMAND %>"
				value="" class="textbox_size20" tabindex=3 readonly="readonly" validate="DOP,date,no"/> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_CONCERNED_COMMAND%>,event)" />
			</td>
			<td><input name="<%=CONCERNED_COMMAND_DATE_REMARK %>" type="text" size="55" validate="DOPR,string,no"></td>
		</tr>
	</tbody>
</table>
</div>

<input type="hidden" name="<%=EXPIRY_ID%>" value="" class="textbox_date"
	MAXLENGTH="10" /> <br />

<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>"
	class="textbox_size20" readonly="readonly" MAXLENGTH="8" / tabindex=3 />
<input type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <input
	type="button" name="edit" value="Submit" class="button"
	onClick="submitForm('fatalCase','mis?method=editFatalCase');" /></div>
<div id="edited"></div>
<!-- <label>&nbsp;</label> -->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
 