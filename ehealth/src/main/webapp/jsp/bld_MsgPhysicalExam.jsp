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
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
		Map<String,Object> dmap = new HashMap<String,Object>();
		
		if (request.getAttribute("map") != null) {
		dmap = (Map<String,Object>) request.getAttribute("map");
		}
		int donorbloodAssessmentEntryM=0;
		if (dmap.get("donorbloodAssessmentEntryM") != null) {
			donorbloodAssessmentEntryM = (Integer) dmap.get("donorbloodAssessmentEntryM");
			}
		
	%>

<form name="PhysicalMessage" method="post">
	<input type="hidden" name="bloodAssessmentM"
		value="${requestScope.map.assesstmentMid}" validate="bloodAssessmentM,metachar,no"/>
		
		<input type="hidden" name="donorAsstId"
		value="${requestScope.map.donorAsstId}" validate="bloodAssessmentM,string,no"/>
		
		<input type="hidden" name="donorbloodAssessmentEntryM"
		value="<%=donorbloodAssessmentEntryM %>" validate="bloodAssessmentM,string,no"/>
		
	<div class="Block">
		<c:if test="${(not empty requestScope.map.temporaryNameList) && (empty requestScope.map.permanentlyNameList)}">
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
				tabindex="1" validate="DeferredTillDate,date,no"/>
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" onClick="setdate('<%=currentDate%>',document.AssessmentMessage.DeferredTillDate,event)" />
			<div class="clear"></div>

			<input type="button" class="button" value="Submit"
				onclick="submitForm('PhysicalMessage','bloodBank?method=submitDonorDeferredStatus&assesstmentMid=${requestScope.map.assesstmentMid}')"
				align="right" tabindex=1 />
		</c:if>

		<c:if test="${(not empty requestScope.map.permanentlyNameList) && (requestScope.map.permanentlyNameList.size()>0)}">
			<label>Donor Permanently Deferred Due To </label>
			<div class="clear"></div>
			<c:forEach var='assesstme'
				items="${requestScope.map.permanentlyNameList}">
				<ul>${assesstme}</ul>
			</c:forEach>
		</c:if>
	</div>
	<div class="clear"></div>
	<h4>
		<span>${requestScope.map.message}</span>
	</h4>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>

	 <input type="button" name="back" value="Back" class="button"
		onclick="submitForm('PhysicalMessage','/hms/hms/bloodBank?method=showDonorSearchJsp','checkTargetForNo');" />
	 
	<%-- <input type="button"
	class="buttonBig2" name="Reset" id="reset" value="Physical Examination"
	onclick="submitForm('AssessmentMessage','bloodBank?method=showPhysicalExaminationJsp&donorAssesstMid=${requestScope.map.assesstmentMid}')"
	 accesskey="r"
	tabindex=1 /> --%>
	
	<input type="button"
	class="buttonBig2" name="Print Declaration Form" id="reset" value="Print Declaration Form"
	onclick="submitForm('PhysicalMessage','/hms/hms/bloodBank?method=printDeclarationFormAfterPhysicalExam');" accesskey="r"
	tabindex=1 />
	
	<input type="button"
	class="buttonBig2" name="Print Declaration Form" id="reset" value="Upload Declaration Form"
	 accesskey="r"
	tabindex=1 />
	
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<%-- <%
if(${requestScope.map.formName} != ""){
%> <input type="button" value="Close" class="button"
	onclick="window.close()"> <%} %> --%>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>