<%@page import="jkt.hms.masters.business.StoreTemperatureMonitoringT"%>
<%@page import="jkt.hms.masters.business.StoreRefrigeratorAllocation"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" language="javascript"  src="/hms/jsp/js/pops_menu.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/ajax.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/prototype.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/scriptaculous.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/unittest.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calender.js"></script>
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
serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>



<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<StoreRefrigeratorAllocation> refrigeratorAllocationList = new ArrayList<StoreRefrigeratorAllocation>();
	List<StoreTemperatureMonitoringT> temperatureMonitoringTList = new ArrayList<StoreTemperatureMonitoringT>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	int monitorongMId = 0;
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("refrigeratorAllocationList") != null){
		refrigeratorAllocationList = (List)map.get("refrigeratorAllocationList");
	}
	if(map.get("temperatureMonitoringTList") != null){
		temperatureMonitoringTList = (List)map.get("temperatureMonitoringTList");
	}
	if(map.get("monitorongMId") != null){
		monitorongMId = (Integer)map.get("monitorongMId");
	}
	

	%>

<div class="titleBg">
<h2>Temperature Validation</h2>
</div>
<div class="clear"></div>

<!-- thread search menu -->
<form name="temperatureTracker" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<h4>Item Details</h4>

<div class="paddingTop15"></div>
	<input type="hidden" name="monitorongMId" value="<%=monitorongMId %>" id="monitorongMId" validate="monitorongMId,int,no"/>
<div class="cmntable">
<table width="100%"  id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th>Item Code</th>
			<th>Item Name</th>
			<th>Unit</th>
			<!-- <th>Batch No.</th> -->
			<th>Ref/CR</th>
			<th>Stored Qty</th>
				<!-- <th>Ref. Min Temp.</th>
			<th>Ref. Max Temp.</th> -->
			<%
			int k = 1;
			if(temperatureMonitoringTList.size()>0){
				for(StoreTemperatureMonitoringT temperatureMonitoringT : temperatureMonitoringTList){ %>
			<th colspan="2">Records<%=k %></th>
			
			<%k++;}} %>
			<th>Discard</th>
			<th>Retain</th>
		<%-- 	<th>Transfer</th>--%>
			
		</tr>
		
		<tr>
		<!-- <th></th>
			<th></th> -->
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<th></th>
			<!-- <th></th> -->
			<%
			int j = 1;
			if(temperatureMonitoringTList.size()>0){
				for(StoreTemperatureMonitoringT temperatureMonitoringT : temperatureMonitoringTList){ %>
			<th>Time<%=j %></th>
			<th>Temp<%=j %></th>
			<%j++;}} %>
				<th></th>
			<th></th>
			<!-- <th></th>
			<th></th> -->
			
			
		</tr>
<%
		int i = 1;	
if(refrigeratorAllocationList.size()>0){
				for(StoreRefrigeratorAllocation refrigeratorAllocation :refrigeratorAllocationList){
					
				
		
		%>
		<tr>
			<td>
			<input type="text" name="itemCode" size="5" value="<%=refrigeratorAllocation.getItem()!= null?refrigeratorAllocation.getItem().getPvmsNo():"" %>"	tabindex=1 size="3"  readonly="readonly" id="itemCode" validate="itemCode,string,no"/>
			<input type="hidden" name="refrigeratorAllocationId<%=i %>" value="<%=refrigeratorAllocation.getId()!= null?refrigeratorAllocation.getId():"" %>"	tabindex=1 size="3"  readonly="readonly" id="refrigeratorAllocationId" validate="refrigeratorAllocationId,int,no"/>
			</td>
			
			<td>
			<input type="text" name="itemName" value="<%=refrigeratorAllocation.getItem()!= null?refrigeratorAllocation.getItem().getNomenclature():"" %>" size="30"	tabindex=1  readonly="readonly" id="itemName" validate="itemName,string,no"/>
			</td>
			
			<td>
			<input type="text" name="au" value="<%=refrigeratorAllocation.getItem()!= null && refrigeratorAllocation.getItem().getItemConversion()!= null?refrigeratorAllocation.getItem().getItemConversion().getItemUnitName():"" %>" size="5"	tabindex=1  readonly="readonly" id="au" validate="au,string,no"/>
			</td>
			
			<%-- <td>
			<input type="text" name="batchNo" value="<%=refrigeratorAllocation.getStock()!= null && refrigeratorAllocation.getStock().getBatchNo() != null?refrigeratorAllocation.getStock().getBatchNo():"" %>" size="5"	tabindex=1   id="barcode" validate="batchNo,metachar,no"/>
			</td> --%>
			
			<td>
			<input type="text" name="refrigeratorNo" value="<%=refrigeratorAllocation.getRefrigeratorNo()!= null?refrigeratorAllocation.getRefrigeratorNo().getNomenclature():"" %>" size="15"	tabindex=1   id="refrigeratorNo" validate="refrigeratorNo,metachar,no"/>
			<input type="hidden" name="refrigeratorId<%=i %>" value="<%=refrigeratorAllocation.getRefrigeratorNo()!= null?refrigeratorAllocation.getRefrigeratorNo().getId():"" %>" size="5"	tabindex=1   id="refrigeratorId" validate="refrigeratorId,int,no"/>
			
			</td>
			
			<td>
			<input type="text" name="storedQty" value="<%=refrigeratorAllocation.getStoredQty()!= null?refrigeratorAllocation.getStoredQty().intValue():"" %>" size="5"	tabindex=1   id="barcode" validate="storedQty,float,no"/>
			</td>
			
			
			<%-- <td>
			<input type="text" name="minTemperature" value="<%=refrigeratorAllocation.getMinTemp()!= null?(refrigeratorAllocation.getMinTemp()).intValue():"" %>" size="3"	 readonly="readonly" tabindex=1   id="minTemperature" validate="minTemperature,string,no"/>
			</td>
			
				<td>
			<input type="text" name="maxTemperature" value="<%=refrigeratorAllocation.getMaxTemp()!= null?(refrigeratorAllocation.getMaxTemp()).intValue():"" %>" size="3"	 readonly="readonly" tabindex=1   id="maxTemperature" validate="maxTemperature,string,no"/>
			</td> --%>
			<%
				String time1 = "";String time2 = "";
				String temp1 = "";String temp2 = "";
				if(temperatureMonitoringTList.size()>0){
					for(StoreTemperatureMonitoringT temperatureMonitoringT : temperatureMonitoringTList){
						
					
			%>
			
			<td>
			<input type="text" name="time1" value="<%=temperatureMonitoringT.getMonitoringTime()!= null?temperatureMonitoringT.getMonitoringTime():"" %>" size="3"	tabindex=1  readonly="readonly" id="time1" validate="time1,string,no"/>
			</td>
			
			<td>
			<input type="text" name="temp1" value="<%=temperatureMonitoringT.getTemperature()!= null?(temperatureMonitoringT.getTemperature()).intValue():"" %>" size="3"	tabindex=1  readonly="readonly" id="temp1" validate="temp1,string,no"/>
			</td>
			<% }} %>
		<%--	
			<td>
			<input type="text" name="time2" value="" size="3"	tabindex=1  readonly="readonly" id="time2" />
			</td>
			
			<td>
			<input type="text" name="temp2" value="" size="3"	tabindex=1  readonly="readonly" id="temp2" />
			</td>
			
			<td>
			<input type="text" name="time3" value="" size="3"	tabindex=1  readonly="readonly" id="time3" />
			</td>
			
			<td>
			<input type="text" name="temp3" value="" size="3"	tabindex=1  readonly="readonly" id="temp3" />
			</td>
			
			<td>
			<input type="text" name="time4" value="" size="3"	tabindex=1  readonly="readonly" id="time4" />
			</td>
			<td>
			<input type="text" name="temp4" value="" size="3"	tabindex=1  readonly="readonly" id="temp4" /> --%>
			</td>
			<td>
			<input type="checkbox" class="radioCheck" name="discard<%=i %>" value="discard"	size="3" tabindex=1  readonly="readonly" id="time5" validate="discard,metachar,no"/>
			</td>
			<td>
			<input type="checkbox"  class="radioCheck" name="retain<%=i %>" value="retain"	size="3" tabindex=1  readonly="readonly" id="time5" validate="retain,metachar,no"/>
			</td>
		<%-- 	<td>
			<input type="checkbox" class="radioCheck" name="transfer<%=i %>" value="y"	size="3" tabindex=1  readonly="readonly" id="time5" />
			</td>--%>
			
		</tr>
		<%i++;}} %>
</table>
</div>
<input	type="hidden" name="count" id="count"	value="<%=i %>" validate="count,int,no"/>

<div id="Block">

<label>Remarks</label>
<textarea rows="" cols=""  name="remarks" validate="remarks,metachar,no"></textarea>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input name="button"  type="button"	value="Submit" class="button" onClick="submitForm('temperatureTracker','coldChain?method=submitTemperatureValidation');" />
<input name="button"  type="button"	value="Reset" class="button"	onclick=""; />


<div class="clear"></div>
<div id="pagination">
Page <span class="selected">1</span>
</div>

</form>