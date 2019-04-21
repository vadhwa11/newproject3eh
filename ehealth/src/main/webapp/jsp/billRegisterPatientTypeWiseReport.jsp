
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
	function check(){
	var currentdate=new Date();
	var SDate = document.search.<%= FROM_DATE%>.value;
	var EDate = document.search.<%= TO_DATE %>.value;


	var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
	var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

	if(endDate>currentdate)
		{
		alert("Please ensure that the To Date is less than or equal to the Current Date.");
		document.calldate.next_day.focus();
		return false;
		}
	else if(startDate > endDate)
	{
	alert("Please ensure that the To Date is greater than or equal to the From Date.");
	document.calldate.next_day.focus();
	return false;
	}
	else
	{
	return true;
	}
	}
</script>

<form name="search" method="post" action="">
<div class="titleBg">
<h2>Cash Collection Statistics</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>
From </label> <input type="text" name="<%= FROM_DATE%>" value="<%=currentDate %>" class="date"
	MAXLENGTH="30" readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.search.<%= FROM_DATE%>,event);" />

<label><span>*</span> To </label> <input type="text"
	name="<%= TO_DATE%>" value="<%=currentDate %>" class="date" MAXLENGTH="30"
	readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.search.<%= TO_DATE%>,event);" />

<div class="clear"></div>


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
<%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="if(check()){submitForm('search','billing?method=printPatientTyprWiseReport')};"
	accesskey="g" tabindex=1 />
	<input type="reset" name="clear" id="clearbutton" value="Clear" class="button" " accesskey="a" tabindex=1 />	
</div>	
<script type="text/javascript">
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

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>