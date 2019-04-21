<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>


<%@page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>


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
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<form name="stockRegisterReport" method="post">
<div class="titleBg">
<h2>Pending Purchase Order Item Wise</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span>Select Item Name </label>
<input type="text" id="itemName" name="itemName" maxlength="100"
	tabindex=1  /> <input type="hidden" name="reportName" validate="reportName,metachar,no"
	value="<%=PENDING_SUPPLY_ORDER_ITEM_WISE %>">
<div id="ac2update" class="autocomplete" style="display: none;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('itemName','ac2update','stores?method=getItemListForNomenclature',{parameters:'requiredField=itemName'});
</script> <input type="hidden" name="itemCode" id="itemCode" value="" />
<div class="clear"></div></div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"
	onclick="cheackBeforeSubmit();"> </input> <script language="Javascript">
function cheackBeforeSubmit(){
if(document.getElementById("itemName").value!=""){
var itemName=document.getElementById("itemName").value;
   var index1 = itemName.lastIndexOf("[");
		      index1++;
		   
		    var index2 = itemName.lastIndexOf("]");
		     var itemCode = itemName.substring(index1,index2);
		     document.getElementById("itemCode").value=itemCode;
submitForm('stockRegisterReport','/hms/hms/stores?method=printReportForPendingPurchaseOrderItemWise');
}
else{
alert("pls enter Item Name")
}}

</script>	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
