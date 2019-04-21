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

	String charge = "";
	BigDecimal rate = new BigDecimal(0.00);
	BigDecimal rateaftrStdDedu = new BigDecimal(0.00);
	BigDecimal discountPercent = new BigDecimal(0.00);
	BigDecimal discountAmt = new BigDecimal(0.00);
	BigDecimal stdDeduction = new BigDecimal(0.00);

	int subLdId = 0;
	if (chargeCodeList.size() > 0) {
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
		String discTypeDB = "";
		if (map.get("discTypeDB") != null) {
			discTypeDB = (String)map.get("discTypeDB");
		}
		int chargeCodeId = masChargeCode.getId();
		if(discountAmt.compareTo(new BigDecimal(0)) > 0 && !discTypeDB.equals("T")){
%>
<%@page import="jkt.hms.masters.business.MasChargeCodeRates"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script>
   		document.getElementById('dispercent<%=rowVal%>').disabled = false;
   		document.getElementById('disamount<%=rowVal%>').disabled = false;
   		</script>
<%}else{

		%>
<script>

   			document.getElementById('disamount<%=rowVal%>').disabled = true;
		   	document.getElementById('dispercent<%=rowVal%>').disabled = true;
		   		</script>
<%
		}
%>

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
%>
<input id="resrate<%=rowVal %>" type="text" size="12"
	name="<%=RATE%><%=rowVal%>"
	value="<%=rate.setScale(2,BigDecimal.ROUND_HALF_UP) %>" tabindex="1"
	onblur="calculateTotalAmtForIp();"
	maxlength="9" readonly="readonly" />
<%}else if(map.get("type").equals("ip")){ %>

<input id="resrate<%=rowVal %>" type="text" size="12"
	name="<%=RATE%><%=rowVal%>"
	value="<%=rate.setScale(2,BigDecimal.ROUND_HALF_UP) %>" tabindex="1"
	onblur="calculateTotalAmtForIp();"
	maxlength="9" readonly="readonly" />
<%} %>
<input type="hidden" id="actualRateId<%=rowVal %>"
	value="<%=rate.setScale(2,BigDecimal.ROUND_HALF_UP) %>" />
<input type="hidden" id="chargeId<%=rowVal %>"
	name="<%=CHARGE_CODE_ID%><%=rowVal %>" value="<%=chargeCodeId%>" />
<input type="hidden" name="<%=MAIN_CHARGECODE_ID%><%=rowVal %>"
	value="<%=masChargeCode.getMainChargecode().getId()%>" />
<input type="hidden" name="<%=SUB_CHARGECODE_ID%><%=rowVal %>"
	value="<%=masChargeCode.getSubChargecode().getId()%>" />
<input id="discntPercentId<%=rowVal %>" type="hidden"
	name="discntPercent<%=rowVal %>" value="<%=discountPercent%>" />
<input type="hidden" name="<%=FA_ACCOUNT_ID%><%=rowVal %>"
	value="<%=masChargeCode.getAccount().getId()%>" />
<input type="hidden" name="<%=FA_SUB_LED_ID%><%=rowVal %>"
	value="<%=subLdId%>" />
<script type="text/javascript">
<%
if(!discTypeDB.equals("T")){
%>
document.getElementById('dispercent<%=rowVal%>').disabled = false;
document.getElementById('dispercent<%=rowVal%>').value = "<%=discountPercent%>";
document.getElementById('dispercent<%=rowVal%>').readOnly = true;

document.getElementById('disamount<%=rowVal%>').disabled = false;
document.getElementById('disamount<%=rowVal%>').value = "<%=discountAmt%>";
document.getElementById('disamount<%=rowVal%>').readOnly = true;

<%}%>


document.getElementById('qty<%=rowVal%>').value = "1";
document.getElementById('standardDeductionId<%=rowVal%>').value = "<%=stdDeduction%>";
document.getElementById('amount<%=rowVal%>').value = "<%=rateaftrStdDedu.setScale(2,BigDecimal.ROUND_HALF_UP)%>";
document.getElementById('netamount<%=rowVal%>').value = "<%=chargeAmountAfterDis.setScale(2,BigDecimal.ROUND_HALF_UP)%>";
document.getElementById('resrate<%=rowVal%>').focus();


</script>

<%
		if(masChargeCode.getMainChargecode().getDepartment() != null){
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
	name="<%=RATE%><%=rowVal%>" value="" onblur="calculateTotalAmtForIp();" readonly="readonly" />

<script>
			alert("No Data in Mas Investigation for this charge code.");
			document.getElementById('qty<%=rowVal%>').readOnly = true;
			document.getElementById('chargeCode<%=rowVal%>').value = "";
			

			</script>
<%
	}
	}
%>


