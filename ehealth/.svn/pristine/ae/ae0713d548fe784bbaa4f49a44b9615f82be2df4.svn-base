<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * budget_status.jsp
 * Purpose of the JSP -  This is for showing Budget Status
 * @author  Priyanka
 * Create Date: 11th Feb,2008
 * Revision Date:
 * Revision By:
 * @version 1.3
--%>

<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.math.BigDecimal"%>

<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.MasStoreBudget"%>
<%@page import="java.util.ArrayList"%>


<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<%
Map<String, Object> map = new HashMap<String, Object>();
List<MasStoreBudget> budgetStatusList = new ArrayList<MasStoreBudget>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("budgetStatusList") != null){
	budgetStatusList = (List<MasStoreBudget>)map.get("budgetStatusList");
}
%>
<form name="attach" method="post">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<h4>Budget Status</h4>
<div class="clear"></div>

<%
BigDecimal totalAllocatedAmount  = null;
BigDecimal poCommitedAmount = null;
BigDecimal balForFreshCommitments = null;


if(budgetStatusList.size() > 0){
	for(MasStoreBudget obj : budgetStatusList){
		try
		{
			totalAllocatedAmount = new BigDecimal(obj.getTotalAllocatedAmount());
		}
		catch(Exception e)
		{
			totalAllocatedAmount = new BigDecimal(0);
		}

		try
		{
			poCommitedAmount = new BigDecimal(obj.getPoComittedAmount());

		}
		catch(Exception e)
		{
			poCommitedAmount  = new BigDecimal(0);
		}

		try
		{
			balForFreshCommitments = totalAllocatedAmount.subtract(poCommitedAmount);

		}
		catch(Exception e)
		{
			balForFreshCommitments  = totalAllocatedAmount;
		}
%>
<div class="Block"><label id="biglabel">Budget Code :</label> <% if(obj.getBudgetCode() != null){ %>
<label class="value"><%=obj.getBudgetCode()%></label> <%} %>

<div class="clear"></div>

<label id="biglabel">Total Allocated Amount :</label> <label
	class="value"><%=totalAllocatedAmount%></label>

<div class="clear"></div>

<label id="biglabel">Balance for Fresh Commitments :</label> <label
	class="value"><%=balForFreshCommitments%></label>

<div class="clear"></div>

<label id="biglabel">Commitments Already made during Current
Financial Year :</label> <label class="value"><%=poCommitedAmount%></label>

<div class="clear"></div>

<label id="biglabel">Bills In Process :</label> <% if(obj.getCrvComittedAmount() != null){ %>
<label class="value"><%=obj.getCrvComittedAmount()%></label> <%} %>
<div class="clear"></div>
</div>

<!--  <div id=biglabel class="bodytextB_blue">Amount Committed in this Supply Order :</div>
	<label></label>
	<br />


	<div id=biglabel class="bodytextB_blue">Amount Balance :</div>
	<label></label>

	--> <%} }%>
<div id="edited"></div>
<input type="button" name="close" value="Close" class="button"
	onClick="window.close();" />

<div id="statusMessage">
<h4></h4>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>