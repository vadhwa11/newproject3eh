<%--
 * Copyright 2011 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showUserAssinedTemplet.jsp  
 * Purpose of the JSP   This is for Assigned Templet To User 
 * @author  Ujjwal Kashyap
 * Create Date:  
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>
<%@page import="jkt.hms.masters.business.MasWard"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>
<%@page import="jkt.hms.masters.business.FaVoucherDetails"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.FaVoucherHeader"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>


<%@page import="jkt.hms.masters.business.UserTemplate"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	int voucherId=0;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<FaVoucherDetails> faVoucherDetailList = new ArrayList<FaVoucherDetails>();
	List<MasHospital> masHospitalList = new ArrayList<MasHospital>();
	List<MasCostCenter> costCenterList=new ArrayList<MasCostCenter> ();
	List<MasWard
	>wardList=new ArrayList<MasWard>();
	if(map.get("faVoucherDetailList")!=null){
		faVoucherDetailList =(List) map.get("faVoucherDetailList");
		
	}
	
System.out.println("faVoucherDetailList.size()---jsp->>"+faVoucherDetailList.size());
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	
	String message="";
	if(map.get("message")!=null){
		message=(String)map.get("message");
	}
	
	%>

<form name="voucherApprovalStatus" method="post">
<div class="clear"></div>
<%if(message!=null && !message.equals("")){ %>
<h4><%=message %></h4>
<%} %>
<table width="100%" border="0" cellspacing="0" cellpadding="0"	id="voucherDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col" width="4"></th>
		<th scope="col">Account</th>
		<th scope="col">S L</th>
		<th scope="col">Ward</th>
		<th scope="col">CostCenter</th> 
		<th scope="col">Narration</th>
		<th scope="col">Dr</th>
		<th scope="col">Cr</th>
		<th scope="col">&nbsp;</th>
	</tr>

	<%for(FaVoucherDetails fvd:faVoucherDetailList){
		voucherId=fvd.getVoucherHeader().getId();
	%>
	<tr>
	<td><input type="radio" value="" name="selectedChrage" class="radioAuto" /></td>
	<td width="4">
	
	<select id="drcr" name="drCr" class="smallest" onchange="changeField(this.value);" validate="DrCr,metachar,yes" tabindex=1 >
		<%if(fvd.getDrAmount()!=null && !fvd.getDrAmount().equals(new BigDecimal(0))){ %>
		<option selected="selected" value="dr">Dr</option>
		<%}else{ %>
		<option selected="selected" value="cr">Cr</option>
		<%} %>
		</select></td>
	<td> <input id="accountNameId" type="text" readonly="readonly" readonly="readonly" readonly="readonly" size="30"  name="accountName" value="<%=fvd.getAccount().getAccDesc() %>" validate="Account,string,yes" tabindex=1 onblur="validateAccountName(this.value,'slId')" />
	</td>
	<td id="slId"> 
	
	<%if(fvd.getSubLed()!=null){ %>
	<input  type="text" readonly="readonly" readonly="readonly"  readonly="readonly" name="<%=SUB_LEDGER_CODE_BANK%>" value="<%=fvd.getSubLed().getSubLedDesc() %>" size="12" />
	<%}else{ %>
	<input  type="text" readonly="readonly" readonly="readonly"  readonly="readonly" name="<%=SUB_LEDGER_CODE_BANK%>" value="--" size="12" />
	'<%} %>
	</td>
	<td>
	<%if(fvd.getVoucherHeader().getWard()!=null){ %>
	<input type="text" readonly="readonly" value="<%=fvd.getVoucherHeader().getWard().getWardName() %>" />
	<%}else{ %>
	<input type="text" readonly="readonly" value="--" />
	<%} %>
	</td>
	
	<td><%if(fvd.getCostCenter()!=null){ %>
	<input type="text" readonly="readonly" value="<%=fvd.getCostCenter().getCostCenterName() %>" />
	<%}else{ %>
	<input type="text" readonly="readonly" value="--" />
	<%} %>
	
	</td>
	<td> 
	<%if(fvd.getNarration()!=null){ %>
	<input id="accountNarrationId" type="text" readonly="readonly" readonly="readonly" size="18" 
	class="large"  name="<%=ACCOUNT_NARRATION%>" value="<%=fvd.getNarration() %>"  MAXLENGTH="100" tabindex=1 />
	<%}else{ %>
	<input id="accountNarrationId" type="text" readonly="readonly" readonly="readonly" size="18" 
	class="large"  name="<%=ACCOUNT_NARRATION%>" value="--"  MAXLENGTH="100" tabindex=1 />
	<%} %>
	</td>

	<td> 
	<%if(fvd.getDrAmount()!=null && !fvd.getDrAmount().equals(new BigDecimal(0))){ %>
	<input id="drAmountId" type="text" readonly="readonly" readonly="readonly"  size="10" name="<%=DR_AMOUNT%>" value="<%=fvd.getDrAmount() %>" validate="DrAmount,float,no"   onblur="totalDrCrAmount('dr');"  MAXLENGTH="12" tabindex=1 />
	<%}else{ %>
<input id="drAmountId" type="text" readonly="readonly" readonly="readonly"  size="10" name="<%=DR_AMOUNT%>" value="" validate="DrAmount,float,no"   onblur="totalDrCrAmount('dr');"  MAXLENGTH="12" tabindex=1 />	
	<%} %>
	</td>
	<td>
	<%if(fvd.getCrAmount()!=null && !fvd.getCrAmount().equals(new BigDecimal(0))){ %>
	 <input id="crAmountId" type="text" readonly="readonly" readonly="readonly"  size="10" name="<%=CR_AMOUNT%>" value="<%=fvd.getCrAmount() %>"  validate="CrAmount,float,no" onblur="totalDrCrAmount('cr');"  MAXLENGTH="12" tabindex=1 />
	 <%}else{ %>
<input id="crAmountId" type="text" readonly="readonly" readonly="readonly"  size="10" name="<%=CR_AMOUNT%>" value=""  validate="CrAmount,float,no" onblur="totalDrCrAmount('cr');"  MAXLENGTH="12" tabindex=1 />	 
	 <%} %>
	 </td>
	</tr>
	<%} %>
	<%-- <tr class="background">
		<td colspan=6 class="right">Total</td>
		<td><input id="totalDrAmountId" type="text" readonly="readonly" readonly="readonly" size="10" class="readOnlySmall" readonly="readonly" name="<%=TOTAL_DR_AMOUNT %>" value="" validate="Total DrAmount,float,yes"   MAXLENGTH="15" tabindex=1 /></td>
		<td colspan=2><input id="totalCrAmountId" size="10" type="text" readonly="readonly" readonly="readonly" class="readOnlySmall" readonly="readonly" name="<%=TOTAL_CR_AMOUNT %>" value="" validate="Total CrAmount,float,yes"   MAXLENGTH="15" tabindex=1 /></td>
	</tr>
	<tr class="background">
		<td colspan=6 class="right">Total Journal Voucher Control Fig.</td>
		
		<td><input id="totalDrId" type="text" readonly="readonly" readonly="readonly" size="10" class="readOnlySmall" readonly="readonly" name="totalDr" value="<%=totalAmountDr!= null?totalAmountDr:"" %>" validate="Total DrAmount,float,no"   MAXLENGTH="15" tabindex=1 /></td>
		<td colspan=2><input id="totalCrId" size="10" type="text" readonly="readonly" readonly="readonly" class="readOnlySmall" readonly="readonly" name="totalCr" value="<%=totalAmountCr!= null?totalAmountCr:"" %>" validate="Total CrAmount,float,no"   MAXLENGTH="15" tabindex=1 /></td>
	</tr> --%>
	</table>

<div class="clear"></div>
<div class="paddingTop15"></div>
<%
int employeeLevel=0;

if(session.getAttribute("employeeLevel")!=null){
	employeeLevel=(Integer)session.getAttribute("employeeLevel");
}
%>
<div class="Block">
<label>Remarks For Rejection</label>
<textarea name="remarksForReject" id="remarksForRejectId">
</textarea>
</div>
<input type="button" value="approve" onclick="submitForm('voucherApprovalStatus','account?method=aproveVoucher&employeeLevel=<%=employeeLevel %>&voucherId=<%=voucherId %>');" />
<input type="button" value="reject" onclick="submitForm('voucherApprovalStatus','account?method=rejecttVoucher&employeeLevel=<%=employeeLevel %>&voucherId=<%=voucherId %>');" />
<div class="clear"></div>
<div class="paddingTop15"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>