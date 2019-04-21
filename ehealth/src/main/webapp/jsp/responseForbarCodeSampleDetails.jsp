
<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* registration.jsp
* Purpose of the JSP -  This is for Registration.
* @author  Rajesh
* Create Date: 14th Nov,2008
* Revision Date:
* Revision By:
* @version 1
--%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.HIN_ID"%>


<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
List<DgSampleCollectionDetails>dgSampleCollectionDetailsList=new ArrayList<DgSampleCollectionDetails>();
if(map.get("dgSampleCollectionDetailsList") != null)
{
	dgSampleCollectionDetailsList=(List<DgSampleCollectionDetails>)map.get("dgSampleCollectionDetailsList");
}

System.out.println("<<======in jsp===>>>"+dgSampleCollectionDetailsList.size());
if(dgSampleCollectionDetailsList.size()>0){

%>
<div class="clear"></div>
 <table>
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
				if(sample.getDiagNo()!=null && !sample.getDiagNo().equals("")){
			%>
			<td><input type="text" name="diagNo" id="diagNo"
				value="<%=sample.getDiagNo()%>" /></td>
			<td><input type="text" name="inv" readonly="readonly" id="inv"
				value="<%=sample.getInvestigation().getInvestigationName()%>" /> 
				<input type="hidden" name="inv_id"
				id="inv_id" value="<%=sample.getInvestigation().getId()%>" /> 
				<input type="hidden"
				name="order_id" id="order_id" value="<%=sample.getSampleCollectionHeader().getOrder().getId()%>" /></td>
			<td><input type="button" class="button" name="print" id="parint"
				value="print"
				onclick="generatePrin(<%=sample.getDiagNo()%>,<%=sample.getInvestigation().getId()%>,<%=sample.getSampleCollectionHeader().getOrder().getId()%>);" /></td>
		</tr>
		<%
			} }
		%>


	</table>
<%}else{%>
<h4>No Records Found!!</h4>
<%}%>