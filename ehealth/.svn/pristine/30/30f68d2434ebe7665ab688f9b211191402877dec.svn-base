<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>


<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>
<script>
function fillValues(){
	if(document.issueMedice.nomenclature.value != "")
	{
	var val = document.issueMedice.nomenclature.value;

    var index1 = val.lastIndexOf("[");
    var index2 = val.lastIndexOf("]");
    index1++;
    var pvms = val.substring(index1,index2);
   		 if (pvms!="")
   	 	{
    	document.getElementById("item_id").value=pvms;

		}
	}
		else
		{
			document.getElementById("item_id").value=0;

		}
	submitForm('issueMedice','/hms/hms/stores?method=printIssueMedicine');




}
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
	int year1=calendar.get(Calendar.YEAR);
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
<form name="issueMedice" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Issue Sales Register</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span>From Date </label> <input
	validate="fromDate,date,yes" type="text" name="<%= FROM_DATE %>" value="<%=currentDate%>"
	class="date" maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.issueMedice.<%= FROM_DATE%>,event);" />
<label><span>*</span>To Date </label> <input type="text"
	validate="toDate,date,yes" name="<%= TO_DATE %>" value="<%=currentDate%>" class="date"
	maxlength="30" tabindex=1 /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.issueMedice.<%= TO_DATE%>,true);" />

	<label>Item Name </label> <input type="text"
	value="" id="nomenclature" name="nomenclature" validate="nomenclature,string,no"/>
<div id="ac2update" style="display: none;"
			class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
					new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'});
					</script>
					<input
	type="hidden" name="item_id" size="5" id="item_id" onblur="fillValues();" onchange="fillValues();"/>
	<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"
	onclick="fillValues()">
</input>

</form>