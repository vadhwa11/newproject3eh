<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calender.js" type="text/javascript"></script>
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
<script type="text/javascript">
function printBarCode(){
var val=document.getElementById("nameItem").value;
var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
document.getElementById("itemCode").value=pvms;
submitForm('stockRegisterReport','/hms/hms/stores?method=printBarCode');
}
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
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Create Bar Code</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Item Name </label> 
<input	type="text" id="nameItem" name="nameItem" class="bigcaption"	tabindex="1" />
<div id="ac6update" class="autocomplete" style="display: none;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('nameItem','ac6update','stores?method=getItemListForNomenclature',{parameters:'requiredField=nameItem'});
</script> 
<label><span>*</span> Batch No </label> 
<input type="text"	id="batchNo" name="batchNo" class="bigcaption" tabindex="1" />
<div class="clear"></div>
<input type="hidden" id="itemCode" name="itemCode" class="bigcaption"	tabindex="1" /></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate BarCode"	onclick="printBarCode();"> </input>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>