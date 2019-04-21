<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<StoreDefectiveDrugM> defectiveDrugsList = new ArrayList<StoreDefectiveDrugM>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if(map.get("defectiveDrugsList")!=null){
		defectiveDrugsList =(List) map.get("defectiveDrugsList");
		
	}
%>

<form name="grnReport" id=grnReport method="post" action="">

<div class="titleBg">
<h2>DEFECTIVE DRUG REPORT</h2>
</div>
<div class="panelbar">
<div class="clear"></div>
<label>Entry No  </label> 
<select name="<%=ENTRY_NO%>">
	<option value="0">Select</option>
	<%
	for (StoreDefectiveDrugM storeDefectiveDrugM : defectiveDrugsList) {
	%>
	<option value="<%=storeDefectiveDrugM.getEntryNo()%>"><%=storeDefectiveDrugM.getEntryNo() %></option>
	<%
	}
	%>
</select> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Report"	class="button"	onClick="submitForm('grnReport','stores?method=printDefectiveDrugJsp');" accesskey="g" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>