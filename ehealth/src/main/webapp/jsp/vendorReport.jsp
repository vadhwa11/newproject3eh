<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MasStoreSupplier> searchMasStoreSupplierList = new ArrayList<MasStoreSupplier>();
if(map.get("searchMasStoreSupplierList")!=null)
	searchMasStoreSupplierList = (List) map.get("searchMasStoreSupplierList");
%>
<div id="contentspace">
<div class="titleBg">
<h2>Vendor Report</h2>
</div>
<div class="clear"></div>
<form name="vendor" method="post" action="">
<div class="clear"></div>
<div class="Block">
<label class="bodytextB_blue">Vendor Name</label> 
<select name="<%=VENDOR_NAME%>" >
	<option value=0>Select</option>
	<%
				for (MasStoreSupplier masStoreSupplier :searchMasStoreSupplierList ) {
				%>
	<option value=<%=masStoreSupplier.getId()%>><%=masStoreSupplier.getSupplierName()%>
	</option>
	<%	
					}
				
					
				%>
</select> 
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add"	id="addbutton" value="Ok" class="button"	onClick="submitForm('vendor','stores?method=generateVendorReport');" accesskey="a" tabindex=1 /> 
<input type="button" name="clear"	id="clearbutton" value="Clear" class="button"	onClick="submitForm('vendor','stores?method=showVendorReportJsp');"	accesskey="a" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
</div>