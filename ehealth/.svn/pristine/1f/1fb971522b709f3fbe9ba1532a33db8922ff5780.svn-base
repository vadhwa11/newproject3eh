<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.StoreRefrigeratorAllocation"%>
<%@page import="jkt.hms.masters.business.HesEquipmentMaster"%>
<%@page import="jkt.hms.masters.business.StoreGrnT"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>

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
	List<StoreRefrigeratorAllocation> refrigeratorReAllocationList = new ArrayList<StoreRefrigeratorAllocation>();
	List<StoreItemBatchStock> refrigeratorList = new ArrayList<StoreItemBatchStock>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId = 0;
	if (session.getAttribute("deptId") != null) {
		deptId = (Integer) session.getAttribute("deptId");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if(map.get("refrigeratorReAllocationList") != null){
		refrigeratorReAllocationList = (List)map.get("refrigeratorReAllocationList");
	}
	if(map.get("refrigeratorList") != null){
		refrigeratorList = (List)map.get("refrigeratorList");
	}
	int temperatureMonitoringId = 0;
	if(map.get("temperatureMonitoringId") != null){
		temperatureMonitoringId = (Integer)map.get("temperatureMonitoringId");
	}


	%>
<script type="text/javascript">
	var coldArray=new Array();
</script>

<div class="titleBg">
<h2>Refrigerator / Cold Room Re-Allocation</h2>
</div>
<div class="clear"></div>
<form name="coldRoomReAllocation" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<h4>Item Details</h4>

<div class="paddingTop15"></div>
<input name="" value="" id="temp" type="hidden" /> 
<input name="temperatureMonitoringId" value="<%=temperatureMonitoringId %>" id="temperatureMonitoringId" type="hidden" /> 

<div class="clear"></div>
	<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="" />

<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
		<tr>

			<th>Item Code</th>
			<th>Item Name</th>
			<th>Unit</th>
			<!-- <th>Batch No.</th> -->
			<th>From Ref/CR</th>
			<th>To Ref/CR</th>
			<th>Stored Qty</th>
			<!-- <th>Min Temperature</th>
			<th>Max Temperature</th> -->
		</tr>
				<%
				int i= 1;
				if(refrigeratorReAllocationList.size()>0){
					for(StoreRefrigeratorAllocation refrigeratorAllocation :refrigeratorReAllocationList){
				
				
				
				%>
		<tr>
			<td>
			<input type="text" name="itemCode" size="5" value="<%=refrigeratorAllocation.getItem()!= null && refrigeratorAllocation.getItem().getPvmsNo() != null ? refrigeratorAllocation.getItem().getPvmsNo():"" %>"	tabindex=1  readonly="readonly" id="itemCode<%=i %>" />
			</td>
			
			<td>
			<input type="text" name="itemName" size="25" value="<%=refrigeratorAllocation.getItem()!= null && refrigeratorAllocation.getItem().getNomenclature() != null ? refrigeratorAllocation.getItem().getNomenclature():"" %>"	tabindex=1  readonly="readonly" id="itemName<%=i %>" />
			<input type="hidden" name="itemId"  value="<%=refrigeratorAllocation.getItem()!= null && refrigeratorAllocation.getItem().getId() != null ? refrigeratorAllocation.getItem().getId():"" %>"	tabindex=1  readonly="readonly" id="itemId<%=i %>" />
			<input type="hidden" name="reAllocationId"  value="<%=refrigeratorAllocation.getId()!= null? refrigeratorAllocation.getId():"" %>"	tabindex=1  readonly="readonly" id="reAllocationId<%=i %>" />
			</td>
			
			<td>
			<input type="text" name="au" value="<%=refrigeratorAllocation.getItem()!= null && refrigeratorAllocation.getItem().getItemConversion()!= null ? refrigeratorAllocation.getItem().getItemConversion().getItemUnitName():"" %>" size="5"	tabindex=1  readonly="readonly" id="au<%=i %>" />
			</td>
			<%-- <td>
			
			<input type="text" name="batchNo" value="<%=refrigeratorAllocation.getStock()!= null && refrigeratorAllocation.getStock().getBatchNo() != null ? refrigeratorAllocation.getStock().getBatchNo():"" %>" size="8"	tabindex=1  readonly="readonly" id="batchNo<%=i %>" />
			<input type="hidden" name="batchId"  value="<%=refrigeratorAllocation.getStock() != null && refrigeratorAllocation.getStock().getId() != null ? refrigeratorAllocation.getStock().getId():"" %>"	tabindex=1  readonly="readonly" id="batchId<%=i %>" />
			
			</td> --%>
			
			<td><input type="text" name="refrigeratorNo" value="<%=refrigeratorAllocation.getRefrigeratorNo() != null && refrigeratorAllocation.getRefrigeratorNo().getNomenclature()!= null ? refrigeratorAllocation.getRefrigeratorNo().getNomenclature():"" %>" size="15"	tabindex=1  readonly="readonly" id="refrigeratorNo<%=i %>" /></td>
			
			<td>
			<select name="serialNo" id= "serialNo<%=i %>" validate = "Refrigerator,String,yes" >
			<option value="0">Select </option>
			<%
				if(refrigeratorList.size()>0){
					for(StoreItemBatchStock itemBatchStock : refrigeratorList){
			%>
			<option value="<%=itemBatchStock.getItem().getId()%>"><%=itemBatchStock.getItem().getNomenclature()%> </option>
			<%}} %>
			</select>
			
			<% 
			StoreItemBatchStock  itemBatchStock = new StoreItemBatchStock();
		    	    for (int j = 0; j <refrigeratorList.size(); j++)
		    	    {
		    	    	itemBatchStock = (StoreItemBatchStock) refrigeratorList.get(j);
	    %>
			<script>
			coldArray[<%=j%>]= new Array();
			coldArray[<%=j%>][0] = "<%=itemBatchStock.getItem().getId()%>";
			coldArray[<%=j%>][1] = "<%=itemBatchStock.getItem().getNomenclature()%>";
	    	</script>
	    <%
	    			}
	    %>
			<td>
			<input type="text" name="storedQty" value="<%=refrigeratorAllocation.getStoredQty() != null?refrigeratorAllocation.getStoredQty().intValue():"" %>" size="8"	tabindex=1    id="storedQty<%=i %>" />
			</td>
			
				<%-- <td>
			<input type="text" name="minTemperature" value=""	size="5"   tabindex=1   id="minTemperature<%=i %>" />
			</td>
			
				<td>
			<input type="text" name="maxTemperature" value="" size="5"	 tabindex=1   id="maxTemperature<%=i %>" />
			</td> --%>
			
		</tr>
		<%}} %>
</table>
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>" />
<div class="paddingTop15"></div>
<input name="button"  type="button"	value="Submit" class="button"	onClick="submitForm('coldRoomReAllocation','coldChain?method=submitColdRoomReAllocation');" />
<input name="button"  type="button"	value="Reset" class="button"	onclick=""; />


<div class="clear"></div>
<div id="pagination">
Page <span class="selected">1</span>
</div>
<script type="text/javascript">
function calculatePendingQty(inc){
		var storedQty =0;
		var grnQty =0;
		var pendingQty =0;
		
		if (!isNaN(document.getElementById('storedQty'+inc).value))
			storedQty = parseFloat(document.getElementById('storedQty'+inc).value);
		if (!isNaN(document.getElementById('grnQty'+inc).value))
			grnQty = parseFloat(document.getElementById('grnQty'+inc).value);
		
		
		if(!isNaN(storedQty) != "" && !isNaN(grnQty)!= ""){
			if(grnQty>storedQty){
				pendingQty =parseFloat(grnQty)-parseFloat(storedQty);
			document.getElementById('pendingQty'+inc).value = pendingQty;
			}
		}
	
	}
	
	
	

function openPopupWindow()
{
 var url="/hms/hms/coldChain?method=showRefrigeratorAllocationPopup";
 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	
}

function addRow(){
	  var tbl = document.getElementById('itemDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name='itemCode'+iteration;
	  e0.id='itemCode'+iteration;
	  e0.value =document.getElementById('itemCode'+(iteration-1)).value;
	  e0.size='5'
	 cellRight1.appendChild(e0);

	 var cellRight2 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='itemName';
	  e1.id='itemName'+iteration;
	  e1.value =document.getElementById('itemName'+(iteration-1)).value;
	  e1.size='25'
	 cellRight2.appendChild(e1);
	  
	  var e11 = document.createElement('input');
	  e11.type = 'hidden';
	  e11.name = 'itemId';
	  e11.id = 'itemId' + iteration;
	  e11.value =document.getElementById('itemId'+(iteration-1)).value;
	  e11.size = '5';
	  cellRight2.appendChild(e11);
	  
	  var cellRight3 = row.insertCell(2);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.name='au';
	  e2.id='au'+iteration;
	  e2.value =document.getElementById('au'+(iteration-1)).value;
	  e2.size='5'
	 cellRight3.appendChild(e2);
	  
	  
	  var cellRight4 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name='refrigeratorNo';
	  e3.size = '15';
	  e3.id='refrigeratorNo'+iteration;
	  e3.value =document.getElementById('refrigeratorNo'+(iteration-1)).value;
	  cellRight4.appendChild(e3);
	/*   var e31 = document.createElement('input');
	  e31.type = 'hidden';
	  e31.name='batchId';
	  e31.size = '8';
	  e31.id='batchId'+iteration;
	  cellRight4.appendChild(e31); */
			  
	  var cellRight5 = row.insertCell(4);
	  var e4 = document.createElement('select');
	  e4.type = 'text';
	  e4.name='serialNo';
	  e4.id='serialNo'+iteration
	  e4.options[0] = new Option('Select', '0');
   	for(var i = 0;i<coldArray.length;i++ ){
      e4.options[coldArray[i][0]] = new Option(coldArray[i][1],coldArray[i][0]);
    }
	  cellRight5.appendChild(e4);

	 /*  var cellRight6 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.size='8';
	  e5.name='grnQty';
	  e5.id='grnQty'+iteration
	  cellRight6.appendChild(e5);
 */
	  var cellRight6 = row.insertCell(5);
	  var e6 = document.createElement('input');
	  e6.type = 'text';
	  e6.size='8';
	  e6.name='storedQty';
	  e6.id='storedQty'+iteration
	  e6.onblur=function(){calculatePendingQty(iteration);};
	  cellRight6.appendChild(e6);
	  
	 /*  var cellRight8 = row.insertCell(7);
	  var e7 = document.createElement('input');
	  e7.type = 'text';
	  e7.size='8';
	  e7.name='pendingQty';
	  e7.id='pendingQty'+iteration
	  cellRight8.appendChild(e7);
 */

	  var cellRight7 = row.insertCell(6);
	  var e71 = document.createElement('input');
	  e71.type = 'text';
	  e71.size='5';
	  e71.name='minTemperature';
	  e71.id='minTemperature'+iteration
	  e71.onblur=function(){calculateIndentQty(iteration);};
	  cellRight7.appendChild(e71);

	  var cellRight8 = row.insertCell(7);
	  var e8 = document.createElement('input');
	  e8.type = 'text';
	  e8.size='5';
	  e8.name='maxTemperature';
	  e8.id='maxTemperature'+iteration
	  cellRight8.appendChild(e8);
	  
	/*   var cellRight11 = row.insertCell(10);
	  var e9 = document.createElement('input');
	  e9.type = 'text';
	  e9.size='5';
	  e9.name='itemData';
	  e9.id='ItemData'+iteration
	  cellRight11.appendChild(e9); */
	  
	 
}
	
</script>

</form>