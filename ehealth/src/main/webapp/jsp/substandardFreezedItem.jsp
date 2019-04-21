

<%@page import="jkt.hms.masters.business.MasStoreItem"%>
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
function fillValues(){
	if(document.itemsNearing.nomenclature.value != "")
	{
	var val = document.itemsNearing.nomenclature.value;

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
			document.getElementById("item_id").value="";

		}
	


}
</script>

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
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	List<MasStoreItem> masStoreItemList = new ArrayList<MasStoreItem>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}

if(map.get("masStoreItemList") != null){
	masStoreItemList = (List<MasStoreItem>)map.get("masStoreItemList") ;
	}

	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	
%>
<div class="titleBg">
<h2>Substandard / Freezed Item </h2>
</div>
<form name="itemsNearing" method="post" action="">
<div class="clear"></div>
<div class="Block">


<label>Item Name </label> 
	<input type="text"	value="" id="nomenclature" name="nomenclature" validate="nomenclature,string,no" onblur="fillValues();"/>
<div id="ac2update" style="display: none;"			class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getAutoCompleteForItemList',{parameters:'requiredField=nomenclature'});
</script>


<input	type="hidden" name="item_id" size="5" id="item_id" onblur="fillValues();" onchange="fillValues();"/>

<label>Substandard</label>
<input type="radio"	name="radioSelect" value="1" checked="checked"class="radioCheckCol1" /> 
<label>Freezed</label>
<input type="radio"	name="radioSelect" value="2" class="radioCheckCol1" /> 


<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Generate Report"	class="buttonBig"	onClick="submitForm('itemsNearing','stores?method=printSubstandardFreezedItem');"	accesskey="a" tabindex=1 />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>






