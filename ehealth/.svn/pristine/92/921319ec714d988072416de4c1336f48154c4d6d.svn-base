<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
	
	List<StoreItemBatchStock>  itemList = new ArrayList<StoreItemBatchStock>();
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	Map<String, Object> map = new HashMap<String, Object>();
	int deptId=(Integer)session.getAttribute("deptId");
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("groupList")!=null){
		itemList =(List)map.get("groupList");
	}

%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'

</script>
<div id="itemDiv1">
<label>Batch No</label>
<select name="<%=BATCH_ID%>" id="batchId"
	validate="Item Name,String,No" >
	<option value="0">Select</option>
	<%for(StoreItemBatchStock masStoreItem:itemList){%>
	<option value="<%=masStoreItem.getBatchNo()%>"><%=masStoreItem.getBatchNo()%></option>
	<%} %>
</select></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
