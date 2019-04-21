<%@page import="jkt.hms.masters.business.StoreInternalIndentT"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
 
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
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>';
</script>
<% 
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	 	
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
 
	String message="";
	if(map.get("message") != null){
	message = (String)map.get("message"); 
		}
	List<StoreInternalIndentT> indenList = new ArrayList<StoreInternalIndentT>();
	if(map.get("indentTs") !=null){
		indenList=(List<StoreInternalIndentT>)map.get("indentTs");
	}
	 
	%>
 
<div class="titleBg">
<h2>View NAC Item </h2>
</div> 
<form name="nac" method="post">
<div class="clear"></div> 
<div class="Block">  
<label>FromDate</label> 
<input type="text" class="date"	name="<%=FROM_DATE%>" id="fromDateId" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.nac.<%=FROM_DATE%>,event)" />
 
 <label>ToDate</label> 
<input type="text" class="date"	name="<%=TO_DATE%>" id="toDateId"  value="<%=currentDate %>" MAXLENGTH="30" validate="toDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.nac.<%=TO_DATE%>,event)" />
<div class="clear"></div>
</div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<input type="button" name="Submit" value="Submit" onClick="submitProtoAjaxForSurvey('nac','/hms/hms/stores?method=viewNacItemJsp','tDiv');" />
 
<div class="clear"></div>
<div id="tDiv">
<table width="98%"  id="defectiveDetails" >	
			<tr>
				<th>Item Code</th>
				<th>Item Name</th>
				<th>a/u</th>
				<th>NAC Qty</th>
			</tr>
</table>
</div>  
 
<div class="clear"></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>

