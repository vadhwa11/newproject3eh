<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

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
		serverdate = '<%=date+"/"+month+"/"+year%>';
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
 	
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");

    List<StoreItemBatchStock> masItemList = new ArrayList<StoreItemBatchStock>();
	
 	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
 	
 	if(map.get("masItemList") != null){
 		masItemList = (List<StoreItemBatchStock>)map.get("masItemList") ;
	}
			
	%>
<div class="titleBg">
<h2>Stock Register Report</h2>
</div>
<div class="clear"></div>

<form name="stockRegisterReport" target="_blank" method="post" action="">

<div class="Block">
<label>From Date<span>*</span></label> 
<input type="text"	id="fromDate" validate="fromDate,char,yes" name="<%=FROM_DATE%>" value="<%=currentDate %>"	class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.stockRegisterReport.<%=FROM_DATE%>,event)" />
<label> To Date <span>*</span></label> 
<input type="text" id="toDate"  validate="toDate,char,yes" name="<%=TO_DATE%>" value="<%=currentDate %>" class="date" readonly="readonly" MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="javascript:setdate('',document.stockRegisterReport.<%=TO_DATE%>,event)" />
<label>Item Name</label> 
<select id="itemId" name="<%=ITEM_ID%>" validate="Item Name,String,yes">
<option value="0">Select</option>
<%	if(masItemList!=null){ 
	for(StoreItemBatchStock storeItemBatchStock: masItemList){%>
		<option value="<%=storeItemBatchStock.getItem().getId()%>"><%=(storeItemBatchStock.getItem().getNomenclature()!=null)?storeItemBatchStock.getItem().getNomenclature().concat(" "):""%></option>
	<%} }%>
</select>
 
<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="Print Stock Register" class="button" onClick="submitForm('stockRegisterReport','stores?method=printDetailedStockRegisterReport');" />
<input type="button" name="OK" value="Print Sub Stock Register" class="button" onClick="submitForm('stockRegisterReport','stores?method=printDetailedSubStockRegisterReport');" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>