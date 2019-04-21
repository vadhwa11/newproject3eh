
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.MasManufacturer"%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.StoreWorkOrderM"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<StoreWorkOrderM> workOrderList = new ArrayList<StoreWorkOrderM>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("workOrderList")!=null){
		workOrderList =(List) map.get("workOrderList");
		
	}
%>
<div id="contentspace">
<form name="grnReport" id=grnReport method="post" action=""
	target="_blank">

<div class="panelbar">
<div class="paneltext"">WORK ORDER REPORT</div>
</div>
<br />
<label>WORK ORDER No : </label> <select name="<%=WORK_ORDER_NO%>">
	<option value="0">Select</option>
	<%
	for (StoreWorkOrderM storeWorkOrderM : workOrderList) {
	%>
	<option value="<%=storeWorkOrderM.getWorkOrderNo()%>"><%=storeWorkOrderM.getWorkOrderNo() %></option>
	<%
	}
	%>
</select> <input type="button" name="add" id="addbutton" value="Print"
	class="button"
	onClick="submitForm('grnReport','neStores?method=generateNewWorkRegisterReport');"
	accesskey="g" tabindex=1 />
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>