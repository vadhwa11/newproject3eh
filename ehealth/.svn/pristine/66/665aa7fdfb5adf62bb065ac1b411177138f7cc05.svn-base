<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForDischarge.jsp  
 * Purpose of the JSP -  This is for Response Discharge.
 * @author  Abha
* Create Date: 27th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>


<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StoreIndentM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.masters.business.MasStoreAirForceDepot"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script>
 var flag;
</script> <%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<MasStoreAirForceDepot> unitForAfmsdList= new ArrayList<MasStoreAirForceDepot>();
	List<MasStoreAirForceDepot> unitList= new ArrayList<MasStoreAirForceDepot>();
	List<MasStoreSupplier> supplierList= new ArrayList<MasStoreSupplier>();
	List<StoreIndentM> indentForAfmsdList= new ArrayList<StoreIndentM>();
	List<StoreIndentM> indentList= new ArrayList<StoreIndentM>();
	List<StorePoHeader> poList= new ArrayList<StorePoHeader>();
	
	String choice="";
	if(map.get("choice") != null)
	{
	choice=(String)map.get("choice");		
	}

	if (choice.equalsIgnoreCase("p"))
	{
		supplierList=(List)map.get("first_combo");
	}
	else if (choice.equalsIgnoreCase("d"))
	{
		unitList  = (List) map.get("first_combo");	
	}
	else if (choice.equalsIgnoreCase("s"))
	{
		supplierList  = (List) map.get("first_combo");
	}
	else if(choice.equalsIgnoreCase("g"))
	{
		unitList=(List)map.get("first_combo");
	}
	else
	{
		supplierList=(List)map.get("first_combo");
	}
%>

<div id=suppDiv>
<%
	if (choice.equalsIgnoreCase("p"))
	{ %> <label class="bodytextB">Vendor Name</label> <select
	name="<%=RequestConstants.SUPPLIER_ID %>" id="supplierCombo"
	validate="Vendor Name, String ,yes">
	<option value="">Select</option>
	<% for (MasStoreSupplier masStoreSupplier : supplierList)
	  	   {   %>
	<option value="<%=masStoreSupplier.getId ()%>"><%=masStoreSupplier.getSupplierName()%></option>
	<% } %>
</select> <% } else if (choice.equalsIgnoreCase("m")) { %> <label class="bodytextB">Vendor
Name</label> <select name="<%=RequestConstants.SUPPLIER_ID %>"
	id="supplierCombo" validate="Vendor Name, String ,yes">
	<option value="">Select</option>
	<% for (MasStoreSupplier masStoreSupplier1 : supplierList)
	  	   {   %>
	<option value="<%=masStoreSupplier1.getId ()%>"><%=masStoreSupplier1.getSupplierName()%></option>
	<% } %>
</select> <% } else if (choice.equalsIgnoreCase("s")) { %> <label class="bodytextB">Vendor
Name</label> <select name="<%=RequestConstants.SUPPLIER_ID %>"
	id="supplierCombo" validate="Vendor Name, String ,yes"
	onchange="submitProtoAjaxforIndent('grnGrid','/hms/hms/neStores?method=responseIndentList');">
	<option value="">Select</option>
	<% for (MasStoreSupplier masStoreSupplier2 : supplierList)
	  	   {   %>
	<option value="<%=masStoreSupplier2.getId ()%>"><%=masStoreSupplier2.getSupplierName()%></option>
	<% } %>
</select> <% } else if(choice.equalsIgnoreCase("g")) {%> <label class="bodytextB">Unit
Name</label> <select name="<%=RequestConstants.SUPPLIER_ID %>"
	id="supplierCombo" validate="Unit Name, String ,yes">
	<option value="">Select</option>
	<% for (MasStoreAirForceDepot unit1 : unitList)
	  	   {   %>
	<option value="<%=unit1.getId ()%>"><%=unit1.getAirForceDepotName()%></option>
	<% } %>
</select> <% } else {%> <label class="bodytextB">Unit Name</label> <select
	name="<%=RequestConstants.SUPPLIER_ID %>" id="supplierCombo"
	validate="Unit Name, String ,yes"
	onchange="submitProtoAjaxforIndent('grnGrid','/hms/hms/neStores?method=responseIndentList');">
	<option value="">Select</option>
	<% for (MasStoreAirForceDepot unit : unitList)
	  	   {   %>
	<option value="<%=unit.getId ()%>"><%=unit.getAirForceDepotName()%></option>
	<% } %>
</select> <%} %>
</div>