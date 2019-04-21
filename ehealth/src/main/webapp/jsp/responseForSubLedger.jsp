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

<%@page import="java.text.DecimalFormat"%>
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>

<%
	Map map = new HashMap();
	BigDecimal chargeAmountAfterDis = new BigDecimal("0");
	boolean flag = false;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<FaMasSubLed> subLedgerList = new ArrayList<FaMasSubLed>();
	if (map.get("subLedgerList") != null) {
		subLedgerList = (List) map.get("subLedgerList");
	}
	String rowVal = "";
	if (map.get("rowVal") != null) {
		rowVal = (String) map.get("rowVal");
	}
	int accountId = 0;
	if (map.get("accountId") != null) {
		accountId = (Integer) map.get("accountId");
	}
	int groupId = 0;
	int subGroupId = 0;
	if (map.get("groupId") != null) {
		groupId = (Integer) map.get("groupId");
	}
	if (map.get("subGroupId") != null) {
		subGroupId = (Integer) map.get("subGroupId");
	}
	BigDecimal closingBalance = new BigDecimal(0.0);
	if (map.get("closingBalance") != null) {
		closingBalance = (BigDecimal) map.get("closingBalance");
	}
	String flagForSL = "";
	if(map.get("flagForSL") != null){
		flagForSL =(String) map.get("flagForSL");
	}
	int financialYearId = 0;
	if(map.get("financialYearId") != null){
		financialYearId = (Integer)map.get("financialYearId");
	}

%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%
BigDecimal amt = new BigDecimal(0.00);
if(subLedgerList.size()>0){
%>
<%
	if(flagForSL.equalsIgnoreCase("bank")){
		
%>
<select id="resrate<%=rowVal %>"   name="<%=SUB_LEDGER_CODE_BANK%><%=rowVal%>"  tabindex="1" onchange="checkSubLed(this.value,<%=rowVal%>); " onblur="checkvalue(<%=rowVal%>);" />
<%}else{
%>
<select id="resrate<%=rowVal %>"   name="<%=SUB_LEDGER_CODE%><%=rowVal%>"  tabindex="1"  onchange="checkSubLed(this.value,<%=rowVal%>);" onblur="checkvalue(<%=rowVal%>);" />
<%} %>
<option value="0">Select</option>
<%

	for(FaMasSubLed faMasSubLed :subLedgerList){
if(faMasSubLed.getSubLedDesc()!=null && !faMasSubLed.getSubLedDesc().equals("")){
	%>

<option value="<%=faMasSubLed.getId()%>"><%=faMasSubLed.getSubLedDesc() %></option>
<%}else if(faMasSubLed.getEmployee()!=null){%>
<option value="<%=faMasSubLed.getId()%>"><%=faMasSubLed.getEmployee().getFirstName() %></option>
<%}} %>
</select>
<%}else{ %>
<%
	if(flagForSL.equalsIgnoreCase("bank")){
%>
 <input  type="text"  name="<%=SUB_LEDGER_CODE_BANK%><%=rowVal%>" value="" readonly="readonly" size="12"  />
 <%}else{ %>
<input  type="text"  name="<%=SUB_LEDGER_CODE%><%=rowVal%>" value="" readonly="readonly" size="12"  />
<%} %>

<%} %>

<input id="accountId<%=rowVal%>" type="hidden"   name="accountId<%=rowVal%>" value="<%=accountId %>"  />
<input id="groupId<%=rowVal%>" type="hidden"   name="groupId<%=rowVal%>" value="<%=groupId %>"  />
<input id="subGroupId<%=rowVal%>" type="hidden"   name="subGroupId<%=rowVal%>" value="<%=subGroupId %>"  />
<input id="financialYearId" type="hidden"  name="financialYearId" value="<%=financialYearId %>"   />
<script language="text/javascript">
if(document.getElementById('accountNameId<%=rowVal%>')){
document.getElementById('accountNameId<%=rowVal%>').setAttribute('title','<%=closingBalance%>');
}else{

document.getElementById('accountNameBankId<%=rowVal%>').setAttribute('title','<%=closingBalance%>');
}
</script>


