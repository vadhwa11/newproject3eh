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

	%>

<div class="titleBg">
<h2>Refrigerator / Cold Room ReAllocation</h2>
</div>
<div class="clear"></div>
<form name="itemGrid" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<h4>Item Details</h4>

<div class="paddingTop15"></div>
<input name="" value="" id="temp" type="hidden" /> 

<div class="clear"></div>
<input type="hidden" size="2" value="" name="noOfRecords"	id="noOfRecords" />
	<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
  <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="" />

<table width="100%" colspan="7" id="itemDetails" border="0" 	cellpadding="0" cellspacing="0">
	<thead>
		<tr>

			<th width="13%">Item Code</th>
			<th width="10%">Item Name</th>
			<th width="10%">Unit</th>
			<th width="13%">Batch No.</th>
			<th width="13%">From Ref/CR</th>
			<th width="13%">To Ref/CR</th>
			<th width="20%">Stored Qty</th>
			<th width="13%">Min Temperature</th>
			<th width="13%">Max Temperature</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
			<input type="text" name="itemCode" size="5" value=""	tabindex=1  readonly="readonly" id="itemCode" />
			</td>
			
			<td>
			<input type="text" name="itemName" size="10" value=""	tabindex=1  readonly="readonly" id="itemName" />
			</td>
			
			<td>
			<input type="text" name="au" value="" size="5"	tabindex=1  readonly="readonly" id="au" />
			</td>
			
			<td>
			<input type="text" name="barcode" size="10" value=""	tabindex=1   id="barcode" />
			</td>
			
			<td>
			<input type="text" name="barcode" size="10" value=""	tabindex=1   id="barcode" />
			</td>
			
			<td>
			<select name="refCr" >
	<option value="0">Select </option>
			</select>
			</td>
			
			<td>
			<input type="text" name="qty" value="" size="5"	tabindex=1   id="qty" />
			</td>
			
			
			
				<td>
			<input type="text" name="maxTemperature" value=""	size="10"  readonly="readonly" tabindex=1   id="maxTemperature" />
			</td>
			
				<td>
			<input type="text" name="minTemperature" value="" size="10"	 readonly="readonly" tabindex=1   id="minTemperature" />
			</td>
		</tr>
	</tbody>
</table>

<div class="paddingTop15"></div>
<input name="button"  type="button"	value="Submit" class="button"	onclick=""; />
<input name="button"  type="button"	value="Reset" class="button"	onclick=""; />


<div class="clear"></div>
<div id="pagination">
Page <span class="selected">1</span>
</div>

</form>