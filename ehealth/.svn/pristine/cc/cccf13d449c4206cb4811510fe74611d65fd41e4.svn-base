
<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* registration.jsp
* Purpose of the JSP -  This is for Registration.
* @author  Ujjw
* Create Date: 14th Nov,2008
* Revision Date:
* Revision By:
* @version 1
--%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
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
List<DgOrderhd>dgSampleCollectionDetailsList=new ArrayList<DgOrderhd>();
if(map.get("dgSampleCollectionDetailsList") != null)
{
	dgSampleCollectionDetailsList=(List<DgOrderhd>)map.get("dgSampleCollectionDetailsList");
}


%>
<%-- <table>
		<tr>
			<th>Diag. Number </th>
			<th>Investigation Name</th>
			<th>Print</th>
		</tr>
		<%
			for(DgSampleCollectionDetails sample:dgSampleCollectionDetailsList){
		%>
		<tr>
			<%
				if(sample[0]!=null && !"".equalsIgnoreCase(sample[0].toString())){
			%>
			<td><input type="text" name="diagNo" id="diagNo"
				value="<%=sample[0]%>" /></td>
			<td><input type="text" name="inv" readonly="readonly" id="inv"
				value="<%=sample[1]%>" /> <input type="hidden" name="inv_id"
				id="inv_id" value="<%=sample[2]%>" /> <input type="hidden"
				name="order_id" id="order_id" value="<%=sample[3]%>" /></td>
			<td><input type="button" class="button" name="print" id="parint"
				value="print"
				onclick="generatePrin(<%=sample[0]%>,<%=sample[2]%>,<%=sample[3]%>);" /></td>
		</tr>
		<%
			} }
		%>


	</table> --%>
	<%
	String hinNo="";
	for(DgOrderhd hd1:dgSampleCollectionDetailsList){ 
	hinNo=hd1.getHin().getHinNo();
	}
	
	if(!hinNo.equalsIgnoreCase(RequestConstants.UHID_FOR_QUALITY_TESTING)){
	%>
	<label>Order List</label>
	<select name="orderName" id="orderId" onchange="submitProtoAjaxWithDivName('labMachineBarCode','lab?method=getsampleListForOrder','sampleDiv')">
	<option value="0">Select</option>
	<%for(DgOrderhd hd:dgSampleCollectionDetailsList){ %>
	<option value="<%=hd.getId()%>"><%=hd.getOrderNo().concat("  ").concat(HMSUtil.convertDateToStringTypeDate(hd.getOrderDate()).substring(0,10))%></option>
	<%} %>
	</select>
	<%}else{%>
	<h4>Not Applicable!!</h4>
	<%}%>