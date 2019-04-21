<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
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
 Map<String, Object> map = new HashMap<String, Object>();
 Map<String, Object> utilMap = new HashMap<String, Object>();
  List<MasItemCategory> masItemCategoryList = new ArrayList<MasItemCategory>();
 utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
 String currentDate = (String)utilMap.get("currentDate");  
 String currentTime = (String)utilMap.get("currentTime");
 if(request.getAttribute("map") != null){
  map = (Map<String, Object>)request.getAttribute("map");
 }
 if(map.get("masItemCategoryList") != null){
	 masItemCategoryList = (List<MasItemCategory>) map.get("masItemCategoryList"); 

 } 
%>
 serverdate = '<%=date+"/"+month1+"/"+year1%>'
 function storeSelectField(){
	 }
</script>

<form name="priceList" method="post">
<div class="titleBg">
<h2>Print Price List</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Item Category</label> 
<select	id="itemCategoryCode" name="itemCategoryCode">
http://localhost:8080/hms/hms/stores?method=showDefectiveDrugJsp&appId=A210	<option value="0">Select</option>
	<%
       for (MasItemCategory masItemCategory : masItemCategoryList) {
    
      %>
	<option value="<%=masItemCategory.getId() %>"><%=masItemCategory.getItemCategoryName()%></option>
	<%   
  
       }
     %>
</select> <label>Item Name/Item Code</label> <input type="text"
	name="<%= SEARCH_NAME %>" id="<%= SEARCH_NAME %>" value=""
	MAXLENGTH="30" tabindex=1 validate="search_name,string,no"/>
<div id="ac3update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
   
    
    function eventCallback(element, entry){
					return entry + "&itemCategoryCode=" + document.getElementById('itemCategoryCode').value; 
			}
			 new Ajax.Autocompleter('<%=SEARCH_NAME%>','ac3update','stores?method=getAutoCompleteForPriceList',{parameters:'requiredField='+document.getElementById('<%= SEARCH_NAME %>').value+'',callback: eventCallback});
			 
  </script>
<div class="clear"></div>

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"	onclick="submitForm('priceList','stores?method=printItemPriceList');" />
<input type="reset" name="Reset" value="Clear" class="buttonBig"	accesskey="r" />	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<script type="text/javascript">
<!--
// Main vBulletin Javascript Initialization
vBulletin_init();
//-->
</script>
