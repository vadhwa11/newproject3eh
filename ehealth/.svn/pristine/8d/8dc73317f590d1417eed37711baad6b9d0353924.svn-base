<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="java.util.*"%>
<%
	Map<String, Object> map=new HashMap<String, Object>();
	List<MasStoreSupplier> supplierList=new ArrayList<MasStoreSupplier>();
	if(request.getAttribute("map")!=null){
		map=(Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("supplierList")!=null){
		supplierList=(List<MasStoreSupplier>)map.get("supplierList");
	}
	String address = "";
	if(supplierList.size()>0){
		MasStoreSupplier masStoreSupplier = supplierList.get(0);
		if(masStoreSupplier.getAddress1()!= null){
			address = masStoreSupplier.getAddress1();
		}
	}
%>

<label>Address</label>
<input type="text" name="address"  value="<%=address!= null?address:"" %>" id="addressId" class="large" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
