<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@ page import="jkt.hms.masters.business.MasPatientCategory"%>
<%@ page import="jkt.hms.masters.business.MasScheme"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<%
        
	/* URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in); */

	Map<String,Object> utilMap1 = new HashMap<String,Object>();
	utilMap1 = (Map)HMSUtil.getCurrentDateAndTime();
	String date1 = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasPatientCategory>patientCategoryList=new ArrayList<MasPatientCategory>();
	List<MasScheme>schemeList=new ArrayList<MasScheme>();
    Map<String, Object> map = new HashMap<String, Object>();
    
    if(request.getAttribute("map") != null)
    {
            map=(Map<String, Object>)request.getAttribute("map");
    }
	if(map.get("patientCategoryList")!=null){
		patientCategoryList=(List<MasPatientCategory>)map.get("patientCategoryList");
	}
	if(map.get("schemeList")!=null){
		schemeList=(List<MasScheme>)map.get("schemeList");
	}
	%>

<form name="stockRegisterReport" method="post">
<div class="titleBg">
<h2>Scheme Wise Billing Statistics</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>From Date </label> <input
	type="text" name="<%= FROM_DATE %>" value="<%=currentDate %>"
	class="date" maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.stockRegisterReport.<%= FROM_DATE%>,event);" />
<label><span>*</span>To Date </label> <input type="text"
	name="<%= TO_DATE %>" value="<%=currentDate %>" class="date"
	maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.stockRegisterReport.<%= TO_DATE%>,true);" />
<div class="clear"></div>
<label>UHID</label>
<input  type="text" name="<%=HIN_NO %>" id="hinId" value="" />
 <label>Scheme</label>
<select name="schemeName" id="schemeId">
<option value="0">Select</option>
<%for(MasScheme scheme:schemeList){ %>
<option value="<%=scheme.getId()%>"><%=scheme.getSchemeName()%></option>
<%} %>
</select>
 <label>Patient Category</label>
<select name="patientCategory" id="patientCategoryId">
<option value="0">Select</option>
<%for(MasPatientCategory patientCategory:patientCategoryList){ %>
<option value="<%=patientCategory.getId()%>"><%=patientCategory.getPatientCategoryName()%></option>
<%} %>
</select>

<input type="hidden" name="reportName" value="<%=CASH_COLLECTION_REPORT %>" />
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="buttonBig" value="Generate Report" onclick="submitForm('stockRegisterReport','/hms/hms/opBilling?method=printReportForSchemeWiseBillingStat');"></input>
<div class="clear"></div>
</div>
<div class="division"></div>
 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>