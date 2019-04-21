<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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
 utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
 String currentDate = (String)utilMap.get("currentDate");  
 String currentTime = (String)utilMap.get("currentTime");
 if(request.getAttribute("map") != null){
  map = (Map<String, Object>)request.getAttribute("map");
 }
%>
 serverdate = '<%=date+"/"+month1+"/"+year1%>'
 function storeSelectField(){
 document.getElementById("itemCategoryCode").value=0;
 document.getElementById("itemCategoryCode").value=document.getElementById("itemd").value
 alert(document.getElementById("itemCategoryCode").value)
 }
</script>

<form name="aboveStockLevel" method="post">
<div class="titleBg">
<h2>Print Item Above Maximum Stock Level</h2>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="reportName"	value="<%=PRINT_ABOVE_STOCK_LEVEL %>" validate="reportName,metachar,no">
<input type="button" class="buttonBig" value="Generate Report"	onclick="submitForm('aboveStockLevel','stores?method=printAboveStockLevel');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
<!--
// Main vBulletin Javascript Initialization
vBulletin_init();
//-->
</script>
