<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : ac_paymentVoucher.jsp 
	 * Tables Used         : 
	 * Description         : For Payment Voucher For A/C .
	 * @author Name        : Vishal
	 * Revision Date:      
	 * Revision By: 
	 * @version 1.0  
--%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.Users"%>

<%@page import="jkt.hms.masters.business.FaMasAccountType"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasCostCenterCode"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="jkt.hms.masters.business.MasAccountType"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<form name="paymentVoucher" method="post" action=""><script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script> <%
		
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		List<FaMasAccountType> faMasAccountTypeList = new ArrayList<FaMasAccountType>();
		List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
		List<FaMasSubLed>  faMasSubLedList = new ArrayList<FaMasSubLed>();
		List<FaMasCostCenterCode>  faMasCostCenterCodeList = new ArrayList<FaMasCostCenterCode>();
		String voucherNo = "";
		
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date=(String)utilMap.get("currentDate");
		String time=(String)utilMap.get("currentTime");
		Box box = HMSUtil.getBox(request);
		
		if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
		}
		if(map.get("faMasAccountTypeList") != null){
					faMasAccountTypeList = (ArrayList)map.get("faMasAccountTypeList");
					
		}
		if(map.get("faMasAccountList") != null){
					faMasAccountList     = (ArrayList)map.get("faMasAccountList");
		}
		if(map.get("faMasSubLedList") != null){
			faMasSubLedList   = (ArrayList)map.get("faMasSubLedList");
		}
		if(map.get("faMasCostCenterCodeList") != null){
			faMasCostCenterCodeList   = (ArrayList)map.get("faMasCostCenterCodeList");
		}
		if(map.get("voucherNo") != null){
		 	voucherNo   = (String)(map.get("voucherNo"));
		}
%>
<div class="titleBg">
<h2>Payment Voucher</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Voucher Number</label> 
<input	id="voucherNumber" value=<%=voucherNo%> type=text name="voucherNumber"	class="readOnly" readonly="readonly" /> 
<label>Voucher Date</label> 
<label	class="value"><%= date%></label> 
<label>Voucher Time</label> 
<label	class="value"><%= time%></label>
<div class="clear"></div>
<label class="common">Narration</label> 
<input id="Narration"	type="text" name="<%=M_NARRATION%>" value=""	validate="Narration,string,yes" MAXLENGTH="150" tabindex=1	style="width: 600px;" />
<div class="clear"></div>
</div>
<div class="division"></div>
<table width="100%" id="chargeDetails" border="0" cellspacing="0"
	cellpadding="0">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Main Account</th>
		<th scope="col">Sub Account</th>
		<th scope="col">C C Code</th>
		<th scope="col">Narration</th>
		<th scope="col">Amount</th>
	</tr>


	<% int i = 0;
	for(int faCount=1;faCount<=4; faCount++, i++){	%>
	<tr>
		<td><input type="text" size="2" value=<%=faCount %> name="srno"
			class="readOnly" readonly="readonly" /></td>

		<td><select id="acc_id<%=faCount %>"
			name="<%=FA_ACCOUNT_ID %><%=faCount %>"
			onchange="populateMasSubLedForAccount(this.value,'paymentVoucher',<%=faCount %>)">
			<option value="0">Select</option>
			<% 
				for (FaMasAccount  faMasAccount : faMasAccountList){
			  %>
			<option value="<%=faMasAccount.getId()%>"><%=faMasAccount.getAccDesc()%></option>
			<%}%>
		</select></td>

		<td><select id="faMasSubLed<%=faCount %>"
			name="<%=FA_MAS_SUB_LED %><%=faCount %>" tabindex="1">
			<option value="0">Select</option>
			<% 
				for (FaMasSubLed  faMasSubLed : faMasSubLedList){
					
				%>
			<option value="<%=faMasSubLed.getId()%>"><%=faMasSubLed.getSlDesc()%></option>
			<%}%>
		</select></td>
		<td><select id="cost_center_code_id<%=faCount %>"
			name="cost_center_code_id<%=faCount %>">
			<option value="0">Select</option>
			<% 
				for (FaMasCostCenterCode  faMasCostCenterCode : faMasCostCenterCodeList){
			  %>
			<option value="<%=faMasCostCenterCode.getId()%>"><%=faMasCostCenterCode.getCostCenterCodeName()%></option>
			<%}%>
		</select></td>
		<td><input type="text" size="70" id="naration<%=faCount %>"
			name="<%=NARRATION%><%=faCount %>" value="" /></td>
		<td><input type="text" id="amount<%=faCount %>"
			name="<%=AMOUNT%><%=faCount %>"
			onblur="calcNetAmount('paymentVoucher',<%=faCount %>);" maxlength="4"
			tabindex="1" /></td>
	</tr>

	<%} %>

	<input type="hidden" id="noOfRec" name="noOfRec" value="<%=i%>" />
	<script type="text/javascript">
<%
int counter=0;
for (FaMasAccount faMasAccount : faMasAccountList) 
{
	for (FaMasSubLed faMasSubLed : faMasSubLedList) 
	{
		if(faMasSubLed.getAccount() != null){
			if(faMasAccount.getId().equals(faMasSubLed.getAccount().getId())){
					%>
						faMasSubLedArray[<%=counter%>] = new Array();
						faMasSubLedArray[<%=counter%>][0]=<%=faMasAccount.getId()%>;
						faMasSubLedArray[<%=counter%>][1] = "<%=faMasSubLed.getId()%>";
					  	faMasSubLedArray[<%=counter%>][2] = "<%=faMasSubLed.getSlDesc()%>";
					<%
					counter++;
			}
		}
	}
}
%>
</script>
</table>
<!--table ends-->
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label class="floatRight">Total Amount</label>
<input type="text" id="totalNetId" name="<%=FA_NET_AMOUNT %>" class="readOnly" readOnly />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button"	value="Submit"	onclick="{submitForm('paymentVoucher','account?method=submitpaymentVoucher');}"	align="right" /> 
<input type="reset" class="buttonHighlight"	name="Reset" id="reset" value="Reset"	onclick="resetClicked('paymentVoucher');" accesskey="r" /> 
<input	type="hidden" name="rows" id="rr" value="1" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<%
faMasAccountList.clear();
faMasAccountTypeList.clear();
faMasCostCenterCodeList.clear();
faMasSubLedList.clear();
%>