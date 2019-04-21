
<%@page import="jkt.hms.masters.business.HmisDistrictReport"%>
<%@page import="jkt.hms.masters.business.MasHmisParameters"%>
<%@ page import="java.util.*" %>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil" %>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/prototype.js"></script>
 
 <script>
<%Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<%
Map map = new HashMap();
String reportName = null;
String districtName = null;
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");

//List<PhMemberSurvey> phmsList = new ArrayList<PhMemberSurvey>();

List<HmisDistrictReport> list = new ArrayList<HmisDistrictReport>();
if(map.get("list") != null){
	list=(List<HmisDistrictReport> ) map.get("list");	
}
 
if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
	  }

//added by amit das on 06-12-2016
if(map.get("reportName") != null){
	reportName=(String) map.get("reportName");	
}
//added by amit das on 06-12-2016
if(map.get("districtName") != null){
	districtName=(String) map.get("districtName");	
}

%>

<div class="clear"></div>
<form name="hmisreport" method="post">
<h4>HMIS</h4>
<div class="clear"></div>
<div class="Block">


<label><span>*</span>From Month</label>
<select  validate="Month,string,no" name="frommonths" >
<%
if(month.equalsIgnoreCase("01")){ %>
<option value="1" selected="selected">January</option>
<%} else { %>
<option value="1">January</option>
<%}
if(month.equalsIgnoreCase("02")){ %>
<option value="2" selected="selected">February</option>
<%} else { %>
<option value="2">February</option>
<%}
if(month.equalsIgnoreCase("03")){ %>
<option value="3" selected="selected">March</option>
<%} else { %>
<option value="3">March</option>
<%}
if(month.equalsIgnoreCase("04")){ %>
<option value="4" selected="selected">April</option>
<%} else { %>
<option value="4">April</option>
<%}
if(month.equalsIgnoreCase("05")){ %>
<option value="5" selected="selected">May</option>
<%} else { %>
<option value="5">May</option>
<%}
if(month.equalsIgnoreCase("06")){ %>
<option value="6" selected="selected">June</option>
<%} else { %>
<option value="6">June</option>
<%}
if(month.equalsIgnoreCase("07")){ %>
<option value="7" selected="selected">July</option>
<%} else { %>
<option value="7">July</option>
<%}
if(month.equalsIgnoreCase("08")){ %>
<option value="8" selected="selected">August</option>
<%} else { %>
<option value="8">August</option>
<%}
if(month.equalsIgnoreCase("09")){ %>
<option value="9" selected="selected">September</option>
<%} else { %>
<option value="9">September</option>
<%}
if(month.equalsIgnoreCase("10")){ %>
<option value="10" selected="selected">October</option>
<%} else { %>
<option value="10">October</option>
<%}
if(month.equalsIgnoreCase("11")){ %>
<option value="11" selected="selected">November</option>
<%} else { %>
<option value="11">November</option>
<%}
if(month.equalsIgnoreCase("12")){ %>
<option value="12" selected="selected">December</option>
<%} else { %>
<option value="12">December</option>
<%} %>
</select>

<label><span>*</span>To Month</label>
<select  validate="Month,string,no" name="tomonths" >
<option value="">Select</option>
<%
if(month.equalsIgnoreCase("01")){ %>
<option value="1" selected="selected">January</option>
<%} else { %>
<option value="1">January</option>
<%}
if(month.equalsIgnoreCase("02")){ %>
<option value="2" selected="selected">February</option>
<%} else { %>
<option value="2">February</option>
<%}
if(month.equalsIgnoreCase("03")){ %>
<option value="3" selected="selected">March</option>
<%} else { %>
<option value="3">March</option>
<%}
if(month.equalsIgnoreCase("04")){ %>
<option value="4" selected="selected">April</option>
<%} else { %>
<option value="4">April</option>
<%}
if(month.equalsIgnoreCase("05")){ %>
<option value="5" selected="selected">May</option>
<%} else { %>
<option value="5">May</option>
<%}
if(month.equalsIgnoreCase("06")){ %>
<option value="6" selected="selected">June</option>
<%} else { %>
<option value="6">June</option>
<%}
if(month.equalsIgnoreCase("07")){ %>
<option value="7" selected="selected">July</option>
<%} else { %>
<option value="7">July</option>
<%}
if(month.equalsIgnoreCase("08")){ %>
<option value="8" selected="selected">August</option>
<%} else { %>
<option value="8">August</option>
<%}
if(month.equalsIgnoreCase("09")){ %>
<option value="9" selected="selected">September</option>
<%} else { %>
<option value="9">September</option>
<%}
if(month.equalsIgnoreCase("10")){ %>
<option value="10" selected="selected">October</option>
<%} else { %>
<option value="10">October</option>
<%}
if(month.equalsIgnoreCase("11")){ %>
<option value="11" selected="selected">November</option>
<%} else { %>
<option value="11">November</option>
<%}
if(month.equalsIgnoreCase("12")){ %>
<option value="12" selected="selected">December</option>
<%} else { %>
<option value="12">December</option>
<%} %>
</select>

<label>Year</label>
 <%-- <input type="text"	class="date" name="year" value="<%=year%>"	readonly="readonly" /> --%> 
 <input type="text"	class="date" name="year" value="<%=year%>" maxlength="4" validate="Year,int,yes" />

<div class="clear"></div>
<!-- both parameters added by amit das on 06-12-2016 -->
<input type="hidden" name="reportName" value="<%=reportName%>">
<input type="hidden" name="districtName" value="<%=districtName%>">

<input name="save" type="button" class="button" value="Report" onclick="submitForm('hmisreport','pubHealth?method=genratehmisReport');"/>
<input name="save" type="button" class="button" value="Excel" onclick="submitForm('hmisreport','pubHealth?method=createHmisbyMonthExcelList');"/>
 </div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>



