<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

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
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
	}
	List<Object[]> batchStockList=new ArrayList<Object[]>();
	if(map.get("batchStockList")!=null){
		batchStockList=(List<Object[]>)map.get("batchStockList");
	}
	

	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
 <!--Patient Photo Place holder-->
<form name="stockRegisterReport" method="post">
<div class="titleBg">
<h2>Department Wise Reorder Level </h2>
</div>
<div class="clear"></div>
<div class="cmntableWithHeight">
<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">

	<tr>
		<th width="2%">Sr. No.</th>
		<th>Item Name</th>
		<th>Maximum Stock</th>
		<th>Minimum Stock</th>
		<th>Rol</th>
	</tr>
	<%
	int inc=1;
	for(Object[] sample:batchStockList){
	%>
<tr>
<td><input type="text" name="srNo" id="srNo" readonly="readonly" value="<%=inc %>" /></td>
	<td>
	<input id="itemName<%=inc %>" type="text" tabindex="1" readonly="readonly" size="45" value="<%=sample[0]+" ["+sample[1]+"] "%>" name="<%=ITEM_NAME%>" />
	</td>
	<%if(sample[2]!=null){ %>
	<td>
	<input type="text" name="max_stock" id="max_stock_id"  tabindex="1" value="<%=sample[2] %>" /></td>
	<%}else{ %>
	<td>
	<input type="text" name="max_stock" id="max_stock_id"  tabindex="1" value="" /></td>
	<%} %>
	<%if(sample[3]!=null ){ %>
	<td><input type="text" name="min_stock" id="min_stock_id"  tabindex="1" value="<%=sample[3] %>" /></td>
	<%}else { %>
	<td><input type="text" name="min_stock" id="min_stock_id"  tabindex="1" value="" /></td>    
    <%} %>
    <%if(sample[4]!=null){ %>
    <td><input type="text" name="rol" id="rol_id"  tabindex="1" value="<%=sample[4] %>" /></td>
    <%}else{ %>
    <td><input type="text" name="rol" id="rol_id"  tabindex="1" value="" /></td>
    <%} %>    
    </tr>
    <%
        inc++;
	} %>

	</table>
    </div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!--  <input type="button" class="buttonBig" value="Generate Report"	onclick="submitForm('stockRegisterReport','/hms/hms/stores?method=printStockRegisterReport');"></input>-->
<input type="button" class="buttonBig" value="Submit"	onclick="submitForm('stockRegisterReport','/hms/hms/stores?method=submitReorderLevelPharmacy');"></input>
<input type="button" class="buttonBig" value="Search and Update"	onclick="submitForm('stockRegisterReport','/hms/hms/stores?method=searchReorderLevelPharmacy');"></input>
<div class="clear paddingTop40"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>