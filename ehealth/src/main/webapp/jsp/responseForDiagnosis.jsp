<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * responseForAge.jsp  
 * Purpose of the JSP -  This is for Response Diagnosis for Medical Report.
 * @author  Ritu
 * Create Date: 30th Jan,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.2
--%>

<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<%
	Map map = new HashMap();
	List<DischargeIcdCode> dischargeIcdCodeList = new ArrayList<DischargeIcdCode>();
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	
	if (map.get("dischargeIcdCodeList") != null){
		dischargeIcdCodeList =(List<DischargeIcdCode>)map.get("dischargeIcdCodeList");
	}
	
%>

<div id="testDiv">
<label> Diagnosis </label>

<select name="<%=DIAGNOSIS_ID %>" multiple="multiple" class="multiple" size="2">  
<%if(dischargeIcdCodeList.size() > 0){
	for(DischargeIcdCode d : dischargeIcdCodeList){ 
		if(d.getIcd().getIcdName() != null){
 %>
<option value="<%=d.getIcd().getIcdName() %>"><%=d.getIcd().getIcdName() %></option>
<%}
			}
		}else{%>
		<option value="">No Record Found</option>
		<%} %>
		</select>
		</div>