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
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="java.math.BigDecimal"%>
<%
	Map map = new HashMap();
	BigDecimal chargeAmountAfterDis = new BigDecimal("0");
	boolean flag = false;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	if (map.get("chargeCodeList") != null) {
		chargeCodeList = (List<MasChargeCode>) map.get("chargeCodeList");
	}
	String rowVal = "";
	if (map.get("rowVal") != null) {
		rowVal = (String) map.get("rowVal");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap =  HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String discTypeDB = "";
	
	String charge = "";
	BigDecimal rate = new BigDecimal(0);
	BigDecimal rateaftrStdDedu = new BigDecimal(0);
	BigDecimal discountPercent = new BigDecimal(0);
	BigDecimal discountAmt = new BigDecimal(0);
	BigDecimal stdDeduction = new BigDecimal(0);
	BigDecimal chargeAmt = new BigDecimal(0);

	int subLdId = 0;
	if (chargeCodeList.size() > 0) {
		System.out.println("calculating data == +++");
		MasChargeCode masChargeCode =  chargeCodeList.get(0);
		if(masChargeCode.getChargeType().getChargeTypeCode().equals("DIAG")){
			if(masChargeCode.getDgMasInvestigations() == null || masChargeCode.getDgMasInvestigations().size() ==0){
				flag = true;
			}
		}

		if(flag == false){
		if (masChargeCode.getSubAccount() != null) {
			subLdId = masChargeCode.getSubAccount().getId();
		}
		if (map.get("chargeAfterSD") != null) {
			rateaftrStdDedu = (BigDecimal) map.get("chargeAfterSD");
		}
		if (map.get("ChargeAmt") != null) {
			chargeAmt = (BigDecimal) map.get("ChargeAmt");
		}
		if (map.get("chargeAmountAfterDis") != null) {
			chargeAmountAfterDis = (BigDecimal) map.get("chargeAmountAfterDis");
			charge = chargeAmountAfterDis.toString();
		}
		if (map.get("rate") != null) {
			rate = (BigDecimal) map.get("rate");
		}
		if (map.get("discAmt") != null) {
			discountAmt = (BigDecimal)map.get("discAmt");
			
		}
		
		if (map.get("discPercnt") != null) {
			discountPercent = (BigDecimal)map.get("discPercnt");
		}
		if (map.get("stdDeduction") != null) {
			stdDeduction = (BigDecimal)map.get("stdDeduction");
		}
		if (map.get("discTypeDB") != null) {
			discTypeDB = (String)map.get("discTypeDB");
		}
		int chargeCodeId = masChargeCode.getId();
		if(discountAmt.compareTo(new BigDecimal(0)) > 0 && !discTypeDB.equalsIgnoreCase("T")){
%>
<%@page import="jkt.hms.masters.business.MasChargeCodeRates"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script>

   		// document.getElementById('dispercent<%=rowVal%>').disabled = true;
   		//document.getElementById('disamount<%=rowVal%>').disabled = true;
   		</script>
<%}else{
		%>
<script>
   			// document.getElementById('disamount<%=rowVal%>').disabled = true;
		     //	document.getElementById('dispercent<%=rowVal%>').disabled = true;
		   		</script>
<%
		}
%>

<script>
document.getElementById('discTypeDB').value = '<%=discTypeDB%>';
</script>

<%
		if (masChargeCode.getEditable().equals("y")) {
%>
<script>
if(document.getElementById('discountOnBillId').value == "" || document.getElementById('discountOnBillId').value == "0")
   	   document.getElementById('resrate<%=rowVal%>').readOnly = false;
   	   </script>

<%
		} else {
%>
<script>
 		document.getElementById('resrate<%=rowVal%>').readOnly = true;
	</script>

<%
	}
%>
<%
	if(map.get("type").equals("op")){
		System.out.println("op calculating data == ++***+++"+rate);
		/* System.out.println("discountAmt == "+discountAmt);
		System.out.println("discountPercent == "+discountPercent); */
		
%>
<input id="resrate<%=rowVal %>" type="text" size="12"
	name="<%=RATE%><%=rowVal%>"
	value="<%=rate.setScale(0,BigDecimal.ROUND_HALF_UP) %>" tabindex="1"
	onblur="calculateDisForChangedRate(this.value,<%=rowVal %>);calcProportionalDisc(<%=rowVal %>);calculateTotalAmt();"
	maxlength="9" readonly="readonly" />
<%}else if(map.get("type").equals("ip")){  System.out.println("calculating data == ++***+++");%>
<input id="resrate<%=rowVal %>" type="text" size="12"
	name="<%=RATE%><%=rowVal%>"
	value="<%=rate.setScale(0,BigDecimal.ROUND_HALF_UP) %>" tabindex="1"
	onblur="calculateDisForChangedRate(this.value,<%=rowVal %>);calcProportionalDisc(<%=rowVal %>);calculateTotalAmtForIp();"
	maxlength="9" readonly="readonly" />
<%} %>

<input type="hidden" id="txtDiscountAmt<%=rowVal %>"
	value="<%=discountAmt %>" />
<input type="hidden" id="txtChargeAmt<%=rowVal %>"
	value="<%=chargeAmt.setScale(0,BigDecimal.ROUND_HALF_UP) %>" />
<input type="hidden" id="actualRateId<%=rowVal %>"
	value="<%=rate.setScale(0,BigDecimal.ROUND_HALF_UP) %>" />
<input type="hidden" id="chargeId<%=rowVal %>"
	name="<%=CHARGE_CODE_ID%><%=rowVal %>" value="<%=chargeCodeId%>" />
<input type="hidden" name="<%=MAIN_CHARGECODE_ID%><%=rowVal %>"
	value="<%=masChargeCode.getMainChargecode().getId()%>" />
<input type="hidden" name="<%=SUB_CHARGECODE_ID%><%=rowVal %>"
	value="<%=masChargeCode.getSubChargecode().getId()%>" />
<input id="discntPercentId<%=rowVal %>" type="hidden"
	name="discntPercent<%=rowVal %>" value="<%=discountPercent%>" />
<input type="hidden" name="<%=FA_ACCOUNT_ID%><%=rowVal %>"
	value="<%=masChargeCode.getAccount()!=null?masChargeCode.getAccount().getId():""%>" />
<input type="hidden" name="<%=FA_SUB_LED_ID%><%=rowVal %>"
	value="<%=subLdId%>" />
<input id="discountTypeDbId<%=rowVal %>" type="hidden"
	name="discountTypeDbId<%=rowVal %>" value="<%=discTypeDB%>" />
<script type="text/javascript"> 
<%-- <%
if(!discTypeDB.equals("T")){
%> --%>

document.getElementById('dispercent<%=rowVal%>').disabled = false;
document.getElementById('dispercent<%=rowVal%>').value = "<%=discountPercent%>";
document.getElementById('dispercent<%=rowVal%>').readOnly = true;
document.getElementById('disamount<%=rowVal%>').disabled = false;
<% if(discTypeDB!=null && discTypeDB.equalsIgnoreCase("f")) {%>

document.getElementById('amount<%=rowVal%>').value = "<%=discountAmt%>";

<% } else {%>
document.getElementById('disamount<%=rowVal%>').value = "<%=discountAmt%>";
<% } %>

document.getElementById('disamount<%=rowVal%>').readOnly = true;


<%-- <%}%> --%>

<%-- <%
	if(masChargeCode.getMainChargecode().getMainChargecodeCode().equals("XRAY"))
	{
%>
		document.getElementById('printReq<%=rowVal%>').disabled = false;
<%
	}else
	{
%>
		document.getElementById('printReq<%=rowVal%>').disabled = true;
<%
	}
%> --%>
<%-- document.getElementById('standardDeductionId<%=rowVal%>').value = "<%=stdDeduction%>"; --%>

<% if(discTypeDB!=null && discTypeDB.equalsIgnoreCase("f")) {%>

document.getElementById('amount<%=rowVal%>').value = "<%=discountAmt%>";
document.getElementById('netamount<%=rowVal%>').value = "<%=discountAmt%>";

<% } else { %>
document.getElementById('amount<%=rowVal%>').value = "<%=rateaftrStdDedu.setScale(0,BigDecimal.ROUND_HALF_UP)%>";
document.getElementById('netamount<%=rowVal%>').value = "<%=chargeAmountAfterDis.setScale(0,BigDecimal.ROUND_HALF_UP)%>";

<% } %>
 <%-- document.getElementById('resrate<%=rowVal%>').focus();
  --%> 
  document.getElementById('resrate<%=rowVal%>').onblur();
  
</script>

<%
		if(masChargeCode.getMainChargecode().getDepartment() != null && masChargeCode.getMainChargecode().getDepartment().getDepartmentType()!=null){
	%>
<input type="hidden" name="<%=DEPARTMENT_TYPE_CODE%><%=rowVal %>"
	value="<%=masChargeCode.getMainChargecode().getDepartment().getDepartmentType().getDepartmentTypeCode()%>" />
<input type="hidden" name="<%=DEPARTMENT_ID%><%=rowVal %>"
	value="<%=masChargeCode.getMainChargecode().getDepartment().getId()%>" />
<%}
	%>

<%
		}else{
			%>
<input id="rate<%=rowVal %>" type="text" size="12"
	name="<%=RATE%><%=rowVal%>" value="" readonly="readonly" />

<script>
			alert("No Data in Mas Investigation for this charge code.");
			document.getElementById('qty<%=rowVal%>').readOnly = true;
			document.getElementById('chargeCode<%=rowVal%>').value = "";
			document.getElementById('qty<%=rowVal%>').value = "";

			</script>
<%
	}
	}
%>

<%
	if(((String)map.get("type")).equalsIgnoreCase("op")){
	
%>
<script type="text/javascript">


<%-- <% if(discTypeDB!=null && !discTypeDB.equalsIgnoreCase("f")) {
%> --%>
<%-- document.getElementById('rate<%=rowVal%>').onblur(); --%> // commented by amit das on 26-05-2016
document.getElementById('resrate<%=rowVal%>').onblur(); // added by amit das on 26-05-2016
<%-- <% } %> --%>

calculateDiscPercentForOpService(document.getElementById('discountAmtBillId').value,'op');

document.getElementById('adjusetCreditId').onblur();
/* document.getElementById('amt1').onblur();
document.getElementById('actualColAmtId').onblur();
document.getElementById('balToBeRId').onblur(); */


</script>
<%} else if(((String)map.get("type")).equalsIgnoreCase("ip")){ %>
<script type="text/javascript">
<%-- document.getElementById('rate<%=rowVal%>').onblur(); --%>
calculatePerDisOnBill(document.getElementById('discountOnBIllRsId').value,'op');
document.getElementById('adjusetCreditId').onblur();
</script>
<%} %>

<script>
   			document.getElementById('disamount<%=rowVal%>').disabled = true;
		   	document.getElementById('dispercent<%=rowVal%>').disabled = true;
		   		</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
