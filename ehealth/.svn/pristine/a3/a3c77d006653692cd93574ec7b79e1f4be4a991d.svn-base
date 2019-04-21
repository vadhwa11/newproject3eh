<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.MasVillage"%>
<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="jkt.hms.masters.business.MasIdCard"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
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
%>
serverdate = '<%=dateCal+"/"+month+"/"+year%>'	
	</script>

	<%
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currentDate = (String) utilMap.get("currentDate");
		System.out.print(currentDate);
		String time = (String) utilMap.get("currentTime");
	%>

<form name="AssessmentMessage" method="post">
	<input type="hidden" name="bloodAssessmentM"
		value="${requestScope.map.assesstmentMid}" />
	<div class="Block">
		<c:if
			test="${(not empty requestScope.map.temporaryNameList) && (empty requestScope.map.permanentlyNameList)}">
			<label>Donor Temporarily Deferred Due To </label>
			<div class="clear"></div>
			<c:forEach var='assesstment'
				items="${requestScope.map.temporaryNameList}">
				<ul>${assesstment }</ul>
			</c:forEach>

			<div class="clear"></div>

			<label>Deferred Till Date</label>
			
			<input type="text" class="date" id="DeferredTillDate"
				name="DeferredTillDate" value="<%=currentDate%>"
				tabindex="1" />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" onClick="setdate('<%=currentDate%>',document.AssessmentMessage.DeferredTillDate,event)" />
			<div class="clear"></div>

			<input type="button" class="button" value="Submit"
				onclick="submitForm('AssessmentMessage','bloodBank?method=submitDonorDeferredDate&assesstmentMid=${requestScope.map.assesstmentMid}')"
				align="right" tabindex=1 />
		</c:if>

		<c:if test="${(not empty requestScope.map.permanentlyNameList) && (requestScope.map.permanentlyNameList.size()>0)}">
			<label>Donor Permanently Deferred Due To </label>
			<div class="clear"></div>
			<c:forEach var='assesstme'
				items="${requestScope.map.permanentlyNameList}">
				<ul>${assesstme}</ul>
			</c:forEach>
			 <input type="button" name="back" value="Back" class="button"
		onclick="submitForm('AssessmentMessage','/hms/hms/bloodBank?method=showDonorSearchJsp','checkTargetForNo');" />
	 
		</c:if>
	</div>
	<div class="clear"></div>
	<h4>
		<span>${requestScope.map.message}</span>
	</h4>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>

	<%-- <input type="button" name="back" value="Back" class="button"
		onclick="submitForm('AssessmentMessage','/hms/hms/bloodBank?method=showDonorAssessmentJsp&assesstmentMid=${requestScope.map.assesstmentMid}','checkTargetForNo');" />
	 --%>
	 <c:if test="${ empty requestScope.map.permanentlyNameList && ( empty requestScope.map.temporaryNameList)}">
			<input type="button"
	class="buttonBig2" name="Reset" id="reset" value="Physical Examination"
	onclick="submitForm('AssessmentMessage','bloodBank?method=showPhysicalExaminationJsp&donorAssesstMid=${requestScope.map.assesstmentMid}')"
	 accesskey="r"
	tabindex=1 />
		</c:if>
	
	
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<%-- <%
if(${requestScope.map.formName} != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %> --%>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>