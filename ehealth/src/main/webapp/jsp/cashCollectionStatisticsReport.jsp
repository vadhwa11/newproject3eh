
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<META content="Evrsoft First Page" name=GENERATOR><SCRIPT
	language=javascript src="/hms/jsp/js/common.js" type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT> <SCRIPT language=javascript
	src="/hms/jsp/js/calendar.js" type=text/javascript></SCRIPT> <SCRIPT>
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
		</SCRIPT>
		
<LINK href="/hms/jsp/css/hms_style.css" type=text/css rel=stylesheet>
<LINK href="/hms/jsp/css/phaseII.css" type=text/css rel=stylesheet>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		List<MasMainChargecode> mainChargeList = new ArrayList<MasMainChargecode>();
		List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
		
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		if(map.get("mainChargeList") != null){
			mainChargeList = (List)map.get("mainChargeList");
		}
		if(map.get("itemCategoryList") != null){
			itemCategoryList = (List)map.get("itemCategoryList");
		}
		
		String dispensingRequired = "";
		if(map.get("dispensingRequired") != null){
			dispensingRequired = (String)map.get("dispensingRequired");
		}
	
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
%>
<script type="text/javascript">
	function check()
	{
		var SDate = document.report.<%= FROM_DATE%>.value;
		var EDate = document.report.<%= TO_DATE %>.value;
		var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
		var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))
		
		if(startDate > endDate)
		{
			alert("Please ensure that the To Date is greater than or equal to the From Date.");
			document.calldate.next_day.focus();
			return false;
		}
	}
</script>

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Cash Collection Statistics</h2>
</div>
<div class="clear"></div>
<div class="Block"><label>Month</label> <input type="radio"
	class="inputRadiobutton" name="reportType" value="1"
	onclick="displayFields(this.value);" /> <label>Year</label> <input
	type="radio" class="inputRadiobutton" name="reportType" value="2"
	checked="checked" onclick="displayFields(this.value);" />

<div class="clear"></div>
<div id="yrDiv"><label><span>*</span>From Year</label> <input
	type="text" name="fromYear" value="" MAXLENGTH="4" /> <label><span>*</span>
To Year</label> <input type="text" name="toYear" value="" MAXLENGTH="4" /></div>
<div class="clear"></div>

<div id="mnthDiv" style="display: none;"><label><span>*</span>
From </label> <input type="text" name="<%= FROM_DATE%>" value=""
	MAXLENGTH="30" readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.search.<%= FROM_DATE%>,event);" />

<label><span>*</span> To </label> <input type="text"
	name="<%= TO_DATE%>" value="" class="date" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.search.<%= TO_DATE%>,event);" />
</div>
<div class="clear"></div>
<label>Servicing</label> <input type="radio" class="inputRadiobutton"
	name="billType" value="1" checked="checked"
	onclick="displayForType(this.value);" />
<%
	if(!dispensingRequired.equals("n"))
	{	
%>		
			<label>Dispensing</label> <input
			type="radio" class="inputRadiobutton" name="billType" value="2"
			onclick="displayForType(this.value);" />
<%
	}
%>

<div class="clear"></div>

<label>Main Charge</label> <select id="mainChargeId"
	name="<%=MAIN_CHARGECODE_ID %>">
	<option value="0">Select</option>
	<%
		for(MasMainChargecode mainChargecode : mainChargeList){
	%>
	<option value="<%=mainChargecode.getId() %>"><%=mainChargecode.getMainChargecodeName() %></option>

	<%} %>
</select>
<%
	if(!dispensingRequired.equals("n"))
	{	
%>
	<label>Item Category</label>
	<select id="itemCatId" name="<%=ITEM_CATEGORY_ID %>" disabled="disabled">
		<option value="0">Select</option>
<%
			for(MasItemCategory itemCategory : itemCategoryList)
			{	
%>
				<option value="<%=itemCategory.getId() %>"><%=itemCategory.getItemCategoryName() %></option>
<%
			}
%>
	</select>
<%
	}
%>
<div class="clear"></div>

<div class="clear"></div>
<%--- Report Button   --%> <input type="button" name="Report"
	value="Generate Report" class="buttonBig"
	onClick="submitForm('search','opBilling?method=printCashCollectionStatisticsReport');"
	accesskey="g" tabindex=1 /> <input type="reset" name="clear"
	id="clearbutton" value="Clear" class="button" " accesskey="a"
	tabindex=1 /> <script type="text/javascript">
function displayFields(val){
	if(val == 1){
		document.getElementById('mnthDiv').style.display = 'block';
		document.getElementById('yrDiv').style.display = 'none';
		
	}else if(val == 2){
		document.getElementById('mnthDiv').style.display = 'none';
		document.getElementById('yrDiv').style.display = 'block';
	}
}

function displayForType(billType){
	if(billType == 1){
		document.getElementById('mainChargeId').disabled = false;
		document.getElementById('itemCatId').disabled = true;
		
	}else if(billType == 2){
		document.getElementById('mainChargeId').disabled = true;
		document.getElementById('itemCatId').disabled = false;
	}

}
</script>
</div>
</form>

