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

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%
	Map map = new HashMap();
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<MasChargeCode> chargeCodeList= new ArrayList<MasChargeCode>(); 
	if(map.get("chargeList") != null){
		chargeCodeList = (List)map.get("chargeList");
	}
	String rowVal= null;
	if(map.get("rowVal") != null){
		rowVal = (String)map.get("rowVal");
	}
	boolean flag = false;
	String charge="";
	int subLdId = 0;
	
	if(chargeCodeList.size() > 0){
       MasChargeCode masChargeCode = (MasChargeCode)chargeCodeList.get(0);
       if(masChargeCode.getChargeType().getChargeTypeCode().equals("DIAG")){
			if(masChargeCode.getDgMasInvestigations() == null || masChargeCode.getDgMasInvestigations().size() ==0){
				flag = true;
			}
		}
   	if(flag ==false){
       if(masChargeCode.getSubAccount() != null){
       		subLdId = masChargeCode.getSubAccount().getId();
       }
	  	   charge=masChargeCode.getCharge().toString();
		
       int chargeCodeId=masChargeCode.getId();
   	 
   		%>

<input id="resrate<%=rowVal %>" type="text" size="12"
	name="<%=RATE%><%=rowVal%>" value="<%=charge %>"
	onblur="calculateTotalAmtForIp();" readonly />
<script>
	document.getElementById('amount<%=rowVal%>').value = '<%=charge %>';
    </script>
<input type="hidden" id="chargeId<%=rowVal %>"
	name="<%=CHARGE_CODE_ID%><%=rowVal %>" value="<%=chargeCodeId%>" />
<input type="hidden" name="<%=FA_ACCOUNT_ID%><%=rowVal %>"
	value="<%=masChargeCode.getAccount().getId()%>" />
<input type="hidden" name="<%=FA_SUB_LED_ID%><%=rowVal %>"
	value="<%=subLdId%>" />
<input type="hidden" name="<%=MAIN_CHARGECODE_ID%><%=rowVal %>"
	value="<%= masChargeCode.getMainChargecode().getId()%>" />
<input type="hidden" name="<%=SUB_CHARGECODE_ID%><%=rowVal %>"
	value="<%= masChargeCode.getSubChargecode().getId()%>" />
<%
		if(masChargeCode.getMainChargecode().getDepartment() != null){
	%>
<input type="hidden" name="<%=DEPARTMENT_TYPE_CODE%><%=rowVal %>"
	value="<%=masChargeCode.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode()%>" />
<input type="hidden" name="<%=DEPARTMENT_ID%><%=rowVal %>"
	value="<%=masChargeCode.getMainChargecode().getDepartment().getId()%>" />
<%} %>
<%}else{
	%>
<input id="rate<%=rowVal %>" type="text" size="12"
	name="<%=RATE%><%=rowVal%>" value="" readonly />

<script>
	alert("No Data in Mas Investigation for this charge code.");
	document.getElementById('qty<%=rowVal%>').readOnly = true;
	document.getElementById('chargeCode<%=rowVal%>').value = "";
	document.getElementById('qty<%=rowVal%>').value = "";
	
	</script>
<%
}
   	}%>


