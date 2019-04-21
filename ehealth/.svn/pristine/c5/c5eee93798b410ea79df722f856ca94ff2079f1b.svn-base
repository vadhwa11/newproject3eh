<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreInternalIndentM"%>


<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar2.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<StoreInternalIndentM> deptIndentNumberList = new ArrayList<StoreInternalIndentM>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	if (map.get("deptIndentNumberList") != null) {
		deptIndentNumberList = (List) map.get("deptIndentNumberList");
	}
%>
<form name="departmentIndent" id=departmentIndent method="post"	action="">
<div class="titleBg">
<h2>DEPARTMENT INDENT REPORT</h2>
</div>
<div class="panelbar">
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Demand No </label> <select name="<%=DEMAND_NO%>"
	validate="Demand No,String,yes">
	<option value="0">Select</option>
	<%
		for (StoreInternalIndentM storeInternalIndentM : deptIndentNumberList) {
	%>
	<option value="<%=storeInternalIndentM.getDemandNo()%>"><%=storeInternalIndentM.getDemandNo()%></option>
	<%
		}
	%>
</select> 
</div>
<div class="clear" ></div>
<div class="division"></div>
<div class="clear" ></div>
<input type="button" name="add" id="addbutton" value="Report" class="button" onClick="submitForm('departmentIndent','stores?method=printDepartmentIndentJsp');"	accesskey="g" tabindex=1 />
<div class="clear" ></div>
<div class="division"></div>
<div class="clear" ></div>
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>