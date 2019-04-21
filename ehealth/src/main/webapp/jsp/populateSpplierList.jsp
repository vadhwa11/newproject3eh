<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.*"%>
<%
	Map<String, Object> map=new HashMap<String, Object>();
	List<MasStoreSupplier> suppliers=new ArrayList<MasStoreSupplier>();
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("suppliers")!=null){
		suppliers=(List<MasStoreSupplier>)map.get("suppliers");
	}
%>

<select name="SupplierName">
	<option value="">Select</option>
	<%for(MasStoreSupplier supplier:suppliers){ %>
	<option value="<%=supplier.getId()%>"><%=supplier.getSupplierName()%></option>
	<%} %>
</select>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
