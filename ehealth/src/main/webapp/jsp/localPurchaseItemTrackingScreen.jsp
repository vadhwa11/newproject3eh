
<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* registration.jsp
* Purpose of the JSP -  This is for Registration.
* @author  Ujjwal Kashyap
* Create Date: 31st Dec 2015
* Revision Date:
* Revision By:
* @version 1
--%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
   <%@page import="java.util.Calendar"%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.UHID_FOR_QUALITY_TESTING"%>

<div class="clear"></div>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
List<StorePoHeader> poHeaderList=new ArrayList<StorePoHeader>();
if(map.get("poHeaderList") != null)
{
	poHeaderList=(List<StorePoHeader>)map.get("poHeaderList");
}
List<Object[]>aList=new ArrayList<Object[]>();
if(map.get("aList") != null)
{
	aList=(List<Object[]>)map.get("aList");
}

System.out.println("aList size -======>>>"+aList.size()
);
%>
<table>
		<tr>
			<th>Item Name</th>
			<th>Po No</th>
			<th>PO Date</th>
			<th>GRN No</th>
			<th>GRN Date</th>
			<th>Quantity Ordered</th>
			<th>Quantity Received</th>
			<th>Quantity Left</th>

		</tr>
		<%
			for(Object[] sample:aList){
		%>
		<tr>
			<%
				if(sample[0]!=null && sample[3]!=null && !"".equalsIgnoreCase(sample[0].toString())){
			%>
			<td><input type="text" name="diagNo" id="diagNo"
				value="<%=sample[0]%>" /></td>
			<td><input type="text" name="inv" readonly="readonly" id="inv"				value="<%=sample[1]%>" /></td>
			
			<td>
			<%
			String date = "";
			SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
			date =formatterOut.format(formatterIn.parse(""+sample[2]));
				
			String date1 = "";
			date1 =formatterOut.format(formatterIn.parse(""+sample[4]));
			

		
			%>
			
			 <input type="text" name="inv_id"	id="inv_id" value="<%=date%>" /></td>
				<td> <input type="text" 	name="order_id" id="order_id" value="<%=sample[3]%>" /></td>
			
			<td><input type="text"
				name="order_id" id="order_id" value="<%=date1 %>"  /></td>
			<td><input type="text"
				name="order_id" id="order_id" value="<%=sample[5]%>" /></td>
			<td><input type="text"
				name="order_id" id="order_id" value="<%=sample[6]%>" /></td>
				
<td><input type="text"	name="order_id" id="order_id" value="<%=sample[7]%>" /></td>
		
		<%
			} else{
			%>
			<td colspan="8"> No Record Found</td>
			
			<%}%>
			</tr>
			<% }
		%>


	</table>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    