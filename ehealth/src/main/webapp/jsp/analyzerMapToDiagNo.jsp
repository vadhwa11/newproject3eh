<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.DgUom"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<script type="text/javascript" language="javascript">

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
<%
    Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null)
	{
		map = (Map<String,Object>) request.getAttribute("map");
	}

	String message="";
	if(map.get("message") != null)
	{
		message=(String)map.get("message");

	}
	 Map<String, Object> utilMap = new HashMap<String, Object>();
     utilMap = (Map) HMSUtil.getCurrentDateAndTime();
     String currentDate = (String) utilMap.get("currentDate");
     String time = (String) utilMap.get("currentTime");

	%>
<script type="text/javascript">
 function checkSelectValue()
 {
		if(document.getElementById("machineName").value=="")
         {
             alert("Please Select Machine Name...");
             return false;
         }
       return true;
	}

	</script>

<div class="titleBg">
<h2>Search Analyzer Machine Records Details</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<h4><%=message %></h4>
<div class="clear"></div>
<form name="analyzerForm" method="post" action="">
<h4>Enter Details</h4>
<div class="clear"></div>
<div class="Block">
<label> Machine Name </label>
<select id="machineName" name="<%=MACHINE_NAME%>" validate="machineName,string,no"  tabindex=1>
			<option value="">Select</option>
			<option value="EM360" >EM360</option>
		 	<!-- <option value="KX21" >KX-21</option>
		 	<option value="XL-300" >XL-300</option> -->
			</select>

<label>Date</label>
<input	type="text" id="fromDateId" name="<%=FROM_DATE %>"	value="<%=currentDate %>" class="calDate" readonly="readonly" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	class="calender" onClick="setdate('<%=currentDate%>',document.analyzerForm.<%=FROM_DATE%>,event)" />
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="show" value="Show" class="button" onClick="if(checkSelectValue()){submitForm('analyzerForm','lab?method=findSampleNoDetails')}" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

