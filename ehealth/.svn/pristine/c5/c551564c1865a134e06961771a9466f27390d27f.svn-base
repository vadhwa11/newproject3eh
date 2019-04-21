
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>

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
	
	List<MasStoreItem>  itemList = new ArrayList<MasStoreItem>();
	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	Map<String, Object> map = new HashMap<String, Object>();
	int deptId=(Integer)session.getAttribute("deptId");
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("itemList")!=null){
		itemList =(List)map.get("itemList");
	}

%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'

</script>
<label>Item Name</label>
<select name="<%=ITEM_NAME%>" id="itemName"	  onchange="submitProtoAjaxWithDivName('stockRegisterReport','/hms/hms/stores?method=getBatchForItem','itemDiv1');"
onkeyup="submitProtoAjaxWithDivName('stockRegisterReport','/hms/hms/stores?method=getBatchForItem','itemDiv1');">
>
	<option value="0">Select</option>
	<%for(MasStoreItem masStoreItem:itemList){%>
	<option value="<%=masStoreItem.getId()%>"><%=masStoreItem.getNomenclature()%></option>
	<%} %>
</select>