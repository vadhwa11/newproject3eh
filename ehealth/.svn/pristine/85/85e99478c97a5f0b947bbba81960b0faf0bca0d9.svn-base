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

<%@page import="java.math.BigDecimal"%>
<%@ page import="java.util.*"%>
<%
	Map map = new HashMap();
	Map chargeMap = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	String billNo = "";
	BigDecimal amount = new BigDecimal(0.00);
	BigDecimal amt = new BigDecimal(0.00);
	BigDecimal chargeAfterSD=new BigDecimal(0.00);
	BigDecimal stdDeduction = new BigDecimal(0.00);
	BigDecimal rate = new BigDecimal(0.00);
	BigDecimal discAmt = new BigDecimal(0.00);
	
	
	if (map.get("billNo") != null) {
		billNo = (String) map.get("billNo");
	}

	if (map.get("amount") != null) {
		amount = (BigDecimal) map.get("amount");
	}
	if (map.get("amt") != null) {
		amt = (BigDecimal) map.get("amt");
	}
	//
	if (map.get("discAmt") != null) {
		discAmt = (BigDecimal) map.get("discAmt");
	}

	if (map.get("chargeMap") != null) {
		chargeMap = (Map) map.get("chargeMap");
	}
	if (chargeMap.get("chargeAfterSD") != null)
		chargeAfterSD =(BigDecimal)chargeMap.get("chargeAfterSD");

	if (map.get("stdDeduction") != null) {
		stdDeduction = (BigDecimal)map.get("stdDeduction");
	}
	if (map.get("rate") != null) {
		rate = (BigDecimal)map.get("rate");
	}
%>
<!--
<label> Bill No.</label>
<input type="text" id="resBillNo" class="readOnly" name="billNo" value="<%=billNo %>" readonly="readonly" tabindex="1" title="Bill No of the Patient"  validate="Bill No,int,no"   MAXLENGTH="15"/> -->
<div id="amount"><label>Amount</label> 
<%if(!amt.equals("0") || !amt.equals("0.0")){ %>
<input type="text"
	id="resAmt" name="amt" value="<%=amt %>" MAXLENGTH="4"
	readonly="readonly" class="readOnly" /> 
	<%}else { %>
<input type="text"
	id="resAmt" name="amt" value="<%=amount %>" MAXLENGTH="4"
	readonly="readonly" class="readOnly" /> 
	
	<%} %>
	
	<input type="hidden"
	name="billamt" id="billamt" value="<%=chargeAfterSD%>" MAXLENGTH="4"
	class="readOnly" readonly="readonly" />
	 <input type="hidden"
	name=rate id="rate" value="<%=rate%>" MAXLENGTH="10"
	class="readOnly" readonly="readonly" />
	 <input type="hidden"
	name=discAmt id="discAmt" value="<%=discAmt%>" MAXLENGTH="10"
	class="readOnly" readonly="readonly" />
	 <input type="hidden"
	name="stdDeduction" id="stdDeduction" value="<%=stdDeduction%>"
	MAXLENGTH="4" class="readOnly" readonly="readonly" /></div>