<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Age.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@page import="com.ibm.db2.jcc.b.s"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<% int i=1;
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	List<MasEmployee>empList=new ArrayList<MasEmployee>();
	List<MasStoreSupplier> supplierList = new ArrayList<MasStoreSupplier>();
	String age = "";
	if(map.get("empList") != null){
		empList = (ArrayList)map.get("empList");
	}
	if(map.get("supplierList") != null){
		supplierList = (ArrayList)map.get("supplierList");
	}
	System.out.println("empList size=======>>>"+empList.size());
	System.out.println("supplierList size=======>>>"+supplierList.size());
%>
<div class="clear"></div>
<div id="valDiv" >


<%if(empList.size()>0){ %>
<table >
  <tr>
    <th>Employee Name</th>
    <th>Phone No</th>
    <th>&nbsp;</th>
  </tr>
  <%
  
 
  for(MasEmployee me:empList){ %>
  <tr>
    <td><%=me.getEmployeeName() %>
    <input type="hidden" name="empName<%=i %>" id="empiD"  value="<%=me.getId() %>" />
    </td>
    <td><%=me.getCellNoEmergency()%>
        <input type="hidden" name="cellNo<%=i %>" id="cellNoID"  value="<%=me.getCellNoEmergency() %>" />
    </td>
   <td><input type="checkbox" name="vendorCheck" id="vendorChekId<%=i %>" onclick="changeForCheck(<%=i %>);" />
   <input type="text" name="vendorCheckStatus<%=i %>" id="vendorChekStatId<%=i %>" value="n" />
   </td>
    
  </tr>
  <%i++;} %>
  <input type="hidden" name="count" id="countId" value="<%=i %>" />
</table>
<%}else if(supplierList.size()>0){ %>
<table >
  <tr>
    <th>Vendor Name</th>
    <th>Phone No</th>
    <th>&nbsp;</th>
  </tr>
  <%for(MasStoreSupplier me:supplierList){ %>
  <tr>
    <td><%=me.getSupplierName() %>
    <input type="hidden" name="empName" id="empiD"  value="<%=me.getId() %>" />
    </td>
    <td><%=me.getMobileNo()%>
        <input type="hidden" name="cellNo" id="cellNoID"  value="<%=me.getMobileNo() %>" />
    </td>
  <td><input type="checkbox" name="vendorCheck" id="vendorChekId<%=i %>" onclick="changeForCheck(<%=i %>);" />
   <input type="text" name="vendorCheckStatus<%=i %>" id="vendorChekStatId<%=i %>" value="n" />
   </td>
    
  </tr>
  <%} %>
</table>
<%}else %>


</div>
<%if(supplierList.size()==0 && empList.size()==0){ %>
<div  id="generalDiv">
	<label>Name</label>
	<input type="text" name="name" id="nameId"  />
	<label>Phone No</label>
	<input type="text" name="phoneNo" id="phoneNoId" maxlength="10"  />
</div>

<%}%>