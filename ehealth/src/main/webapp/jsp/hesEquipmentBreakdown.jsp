<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HesEquipmentBreakdownEntry"%>

<%
	Map map = new HashMap(); 
    String entryNo="";
    String actionId="";
    String repairId="";
    String serviceById="";
    String entryNoEmergeny="";
	
		 if(request.getAttribute("map") != null)
		 {
			map = (Map) request.getAttribute("map");
		 }
	
		 	 if (map.get("num")!=null)
			 entryNoEmergeny = (String)map.get("num").toString();
  	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	//String date = (String)utilMap.get("currentDate");	 
	//String time = (String)utilMap.get("currentTime");
	
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	
	List<HesEquipmentBreakdownEntry> searchCountryList = new ArrayList<HesEquipmentBreakdownEntry>();
	
	if(map.get("searchCountryList")!=null){
		searchCountryList =(List) map.get("searchCountryList");
	}
	HesEquipmentBreakdownEntry hesEntry=(HesEquipmentBreakdownEntry)searchCountryList.get(0);
		
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
<%} %>
<%@page import="jkt.hms.util.RequestConstants"%><div class="titleBg">
<h2>Emergency Call Entry for Equipment Breakdown</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="searchByDepartment" method="post" action="">
<label>Department Name:</label>
<input type="text" id="searchField" name="<%= RequestConstants.DEPARTMENT_ID%>"  validate="Department Name,string,no" MAXLENGTH="50" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('searchByDepartment','hes?method=searchEmergencyEquipmentBreakdown','checkSearch')" tabindex=1 />
<%--- Report Button   --%>
<%--- <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> --%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
</div>
</div>

<form name="dSearch" method="post" action="">
 <div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<!--Bottom labels starts-->

<div class="bottom"><input type="hidden" name="lastChgBy" value="<%=userName%>" /> 
<input type="hidden" name="lastChgDate" value="<%=currentDate%>" /> 
<input type="hidden" name="lastChgTime" value="<%=currentTime%>" /> 
<label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currentDate%></label> 
<label>Changed Time</label> <label class="value"><%=currentTime%></label>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
