<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();

if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<MasAuthorizer>MasAuthorizerList =new ArrayList<MasAuthorizer>();
if(map.get("MasAuthorizerList")!=null){
	MasAuthorizerList=(List<MasAuthorizer>)map.get("MasAuthorizerList");
}
int hinId=0;
if(map.get("hinId")!=null){
	hinId=(Integer)map.get("hinId");
}Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
%>

<script>
<%

               Calendar calendar=Calendar.getInstance();
               String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
               String curDate=String.valueOf(calendar.get(Calendar.DATE));
               int year=calendar.get(calendar.YEAR);
               if(month.length()<2){
                       month="0"+month;
               }
               if(curDate.length()<2){
                       curDate="0"+curDate;
               }

       %>

               serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<form name="camrForm" method="post"> 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="titleBg">
<h2>Consolidated & Authorizer- wise waived amount report </h2>
 </div>
 <div class="clear"></div>
  <div class="clear"></div>
   <div class="Block">
<label>Authorizer</label>
<select name="authId">
<option value="0">Select</option>
<%for(MasAuthorizer MasAuthorizer:MasAuthorizerList){ %>
<option value="<%=MasAuthorizer.getId()%>"><%=MasAuthorizer.getAuthorizerName()%></option>
<%} %>
</select>
<label>Waived Off</label>
<input type="radio" name="cawr" id="cawr1" value="W" />
<label>Pay Later</label>
<input type="radio" name="cawr" id="cawr1" value="PL" />
<div class="clear"></div>
<label>From Date</label>
	<input type="text"	tabindex="1" name="fromDate" value="<%=currentDate %>" class="date"	readonly="readonly" 
		validate=""	MAXLENGTH="30" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"	
		onclick="setdate('<%=currentDate %>',document.camrForm.fromDate,event)" />
<label>To Date</label>
	<input type="text"	tabindex="1" name="toDate" value="<%=currentDate %>" class="date"	readonly="readonly" 
		validate=""	MAXLENGTH="30" /> 
	
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date,date,no"	
		onclick="setdate('<%=currentDate %>',document.camrForm.toDate,event)" />

</div>
<div class="clear"></div>
  <div class="clear"></div>
  <input type="button" value="Print" onclick="submitForm('camrForm','/hms/hms/billing?method=printConsolidateReportForWaiveOffPayLaterJsp')" />
  </form>