<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Pain Magt.
 * @author  Awadhesh
 * Create Date: 7th Nov.,2017
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OtPostAnaesthisiaPainManagement"%>
<form name="painManagementResource" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	String flag="";
	if(map.get("flag") != null){
		flag = (String)map.get("flag");
		
	}if(!flag.equals("m")){
	List<OtPostAnaesthisiaPainManagement> painGridList=new ArrayList<OtPostAnaesthisiaPainManagement>(); 
	int painGridSize=0;
	if(map.get("painGridList") != null){
		painGridList = (List)map.get("painGridList");
		painGridSize=painGridList.size();
	}
	if(painGridList.size()!=0){%>
	<div class="paddingTop15"></div>
	<input
				type="hidden" value="<%=painGridSize%>" name="painGridSize"
				id="painGridSize" tabindex=1 /> 
	<div id="nameDiv">
<table width="100%" colspan="7" id="componentDetailsForBlood" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<!-- <th width="3%">&nbsp;</th> -->
			<th width="10%">Body Part</th>
			<th width="7%">Periscope Value</th>
			<th width="10%">Pain Condition</th>
			
		</tr>
	</thead>
	<tbody>
	
		<%int i=0;
		for(OtPostAnaesthisiaPainManagement painGrid:painGridList){
		int otBookingId=painGrid.getOtPostAnaesthisiaProcedure().getId();
		int hospitalId=painGrid.getHospital().getId();
		String bodyPart=painGrid.getPartName();
		int periscopeValue=painGrid.getPeriscopeValue();
		String periscopeName=painGrid.getPeriscopeName();
		int painId=painGrid.getId();
		%>
		<tr>
		<%-- <td width="3"> <input type="radio" value="<%=painGrid %>" 
				id="radioId<%=i%>" name="painId" 
				onclick="populatebloodBankQuantity(this.value);" />
		</td> --%>
		<td width="10%"><%-- <input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" tabindex=1 /> --%>
				<input type="hidden" value="<%=painId %>" 
				id="painId<%=i%>" name="painId">
				<input
				type="hidden" value="<%=otBookingId%>" name="otBookingId<%=i%>"
				id="otBookingId<%=i%>" tabindex=1 /> 
				<input
				type="hidden" value="<%=hospitalId%>" name="hospitalId<%=i%>"
				id="hospitalId<%=i%>" tabindex=1 /> 
				<input
				type="text" value="<%=bodyPart%>" name="bodyPart<%=i%>"
				id="bodyPart<%=i%>" tabindex=1 /> 
				
				
				  </td>
				<td><input type="text" value="<%=periscopeValue%>" id="periscopeValue<%=i%>" name="periscopeValue<%=i%>" readonly="readonly"/></td>
				
				<td><input type="text" value="<%=periscopeName%>" id="periscopeName<%=i%>" name="periscopeName<%=i%>" readonly="readonly"/></td>  
		</tr>
			
			<%
			++i;
		}%>
		</tbody>
</table>
<input type="button" name="Submit" class="button" value="Save Report"
	onclick="savePeriscopePending('dummyFormName');" />
		<% 
	}else{
			%>
		
		
<% }
}else{
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}%>
	<span style="color:red"><%= message%></span>
	<%
}%>	

</div>
</form>

