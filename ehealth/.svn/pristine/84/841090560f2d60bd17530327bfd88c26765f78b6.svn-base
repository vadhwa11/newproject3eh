

<%@page import="jkt.hms.masters.business.PhOsTravelHistory"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet">
</script>
<script type="text/javascript">
var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />';
</script>
<script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<%
				Map<String, Object> map = new HashMap<String, Object>();
// 				 List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
				 /*List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>(); */
				List<PhOsTravelHistory> phTravelHistoryList =new ArrayList<PhOsTravelHistory>();
				String message = "";
				int hinId=0;
				int visitId=0;
				int inpatientId=0;
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("phTravelHistoryList")!= null){
					phTravelHistoryList = (List)map.get("phTravelHistoryList");
				}
				PhOsTravelHistory travelHistory = new PhOsTravelHistory();	
		if(phTravelHistoryList.size()>0){
			 travelHistory = (PhOsTravelHistory)phTravelHistoryList.get(0);
			
		}
		%>
				
	



<%-- <%@page import="jkt.erp.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.erp.hrms.masters.business.TempTickattach"%> --%>
<form name="travelHistory" method="post" action="" >
<div class="titleBg"> <h2>Travel History</h2></div>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>
<label>Date Of Departure</label>
<input type="text" name="dateOfDeparture" id="dateOfDeparture" value="<%=travelHistory.getDateOfDeparture() != null?HMSUtil.convertDateToStringWithoutTime(travelHistory.getDateOfDeparture()):""%>">
<label>Date Of Arrival</label>
<input type="text" name="dateOfArrival" id="dateOfArrival" value="<%=travelHistory.getDateOfArrival() != null?HMSUtil.convertDateToStringWithoutTime(travelHistory.getDateOfArrival()):""%>">
<div class="clear"></div>
<label>Country</label>
<input type="text" name="state" id="state" value="<%=travelHistory.getCountry() != null?travelHistory.getCountry().getCountryName():""%>">

<label>State</label>
<input type="text" name="district" id="district" value="<%=travelHistory.getState() != null?travelHistory.getState().getStateName():""%>">
<div class="clear"></div>
<label>District</label>
<input type="text" name="country" id="country" value="<%=travelHistory.getDistrict() != null?travelHistory.getDistrict().getDistrictName():""%>">
<div class="clear"></div>

<div class="clear"></div>
</div>


<div class="clear"></div>
<div class="division"></div>





<!-- <input name="Delete" type="button"  class="button" value="Delete" onClick="if(validate()){submitForm('attachFile','maintenance?method=deleteAttachFile');}" />
<input name="add" type="button" class="button" value="Close" onClick="window.close();"/> -->





<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

