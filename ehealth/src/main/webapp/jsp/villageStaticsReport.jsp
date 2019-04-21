<%@page import="jkt.hms.masters.business.HospitalParameters"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
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
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
HospitalParameters hospitalParameters = new HospitalParameters();
if(map.get("hospitalParameters")!=null){
	hospitalParameters=(HospitalParameters)map.get("hospitalParameters");
}
String blockStatus="";
if(hospitalParameters.getBlock()!=null){
	blockStatus=hospitalParameters.getBlock().trim();
}
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
	String currentTime = (String)utilMap.get("currentTime");

%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<form name="villageStatics" method="post">
<div class="titleBg">
<h2>Village Wise Statistics Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date </label>
<input type="text" name="<%= FROM_DATE %>" value="<%=currentDate %>" class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.villageStatics.<%= FROM_DATE%>,event);" />
<label><span>*</span> To Date </label>
<input type="text" name="<%= TO_DATE %>" value="<%=currentDate%>" class="date" maxlength="30" tabindex=1 />
<img id="calendar"src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.villageStatics.<%= TO_DATE%>,true);" />
<div class="clear"></div>
<label> Village</label>
<input type="radio" class="inputRadiobutton" name="reportName" value="Villagewisestatistics" checked="checked" />
<%
	if(blockStatus.equalsIgnoreCase("Y")){
%>
<label>Block</label>
<input type="radio" name="reportName" class="inputRadiobutton" value="Blockstatistics" />
<%
	}
%>
 <label> District</label>
<input type="radio" name="reportName" class="radioCheck" value="Districtstatistics" />
<%
	if(blockStatus.equalsIgnoreCase("Y")){
%>
<div class="clear"></div>
<%
	}
%>



<input type="hidden" class="radioCheck" name="reportName" value="Statestatistics" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="buttonBig" value="Generate Report" onclick="submitForm('villageStatics','/hms/hms/adt?method=printVillageStaticsReport','validateFromToDate');"> </input>
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>

<script type="text/javascript" language="javascript">

	function validateFromToDate(){

		var nowDate=new Date();

		obj1 = eval(document.villageStatics.fromDate)
		obj2 = eval(document.villageStatics.toDate)

		if(obj1.value != "" && obj2.value != "")
		{

		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));

			if(validFromDate<=nowDate)
				{
					if(validFromDate > validToDate)
					{
							alert("From Date should be smaller than To Date\n");
							return false;
					}
				}

			else
				{
				alert("From Date should not be greater than Current date\n");
				return false;
				}

		}
		return true;
	}
</script>