<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<% 
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
}
BigDecimal crvAmount = null;
float totalAmount = 0.0f;
float poAmount = 0.0f;
float spendAmount = 0.0f;

	if(map.get("crvAmount") != null){
	   crvAmount = (BigDecimal)map.get("crvAmount");
	}
	if(map.get("totalAmount") != null){
	   totalAmount = (Float)map.get("totalAmount");
	}
	if(map.get("poAmount") != null){
	   poAmount = (Float)map.get("poAmount");
	}
	if(map.get("spendAmount") != null){
		spendAmount = (Float)map.get("spendAmount");
	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	List budgetDetailsList = new ArrayList();
		
	if(map.get("budgetDetailsList")!=null){
		budgetDetailsList = (List) map.get("budgetDetailsList");
	}
%>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<div class="clear"></div>
<label class="bodytextB">Total Allocated Amt</label>
<input type="text" id="totalAmt" name="<%=TOTAL_ALLOCATED_AMOUNT %>" value="<%=totalAmount %>" readonly="readonly" class="readOnly"	MAXLENGTH="8" tabindex=1 />
<label class="bodytextB">CRV Committed Amt</label>
<input type="text" id="crvAmt" name="<%=CRV_COMMITTED_AMOUNT %>" value="<%=crvAmount == null?"":crvAmount %>" readonly="readonly" class="readOnly" MAXLENGTH="8" tabindex=1 />
<label class="bodytextB">SO Committed Amt</label>
<input type="text" id="soAmt" name="<%=PO_COMMITTED_AMOUNT %>" value="<%=poAmount %>" readonly="readonly" class="readOnly" MAXLENGTH="8" tabindex=1 />
<div class="clear"></div>

<label class="bodytextB">Cumulative Spent Amt</label>
<input type="text" id="prevSpendAmt" name="<%=PREVIOUS_SPEND_AMOUNT %>"	value="<%=spendAmount%>" readonly="readonly" class="readOnly" MAXLENGTH="8" tabindex=1 />
<label class="bodytextB"><span>*</span>Spent Amt</label>
<input type="text" id="spendAmt" name="<%= SPEND_AMOUNT%>" value=""	validate="Spent Amt,float,yes" onblur="calulateBalanceAmount(this.value)" MAXLENGTH="15" tabindex=1 />
<label class="bodytextB">Balance Amt</label>
<input type="text" id="balance" name="<%= BALANCE_AMOUNT%>" value="" readonly="readonly" class="readOnly" MAXLENGTH="15" tabindex=1 />

<div class="clear"></div>
<h4>Budget Entry Details</h4>
<div class="clear"></div>

<label><span>*</span>Authority Letter No.</label>
<input type="text" name="<%= AUTHORITY_LETTER_NO%>" value="" validate="Authority Letter No.,string,yes" MAXLENGTH="15" tabindex=1 />

<label><span>*</span>Projected Amt</label>
<input type="text" name="<%= PROJECT_AMOUNT%>" value="" validate="Projected Amt,float,yes" MAXLENGTH="15" tabindex=1 />

<label><span>*</span>Budgeted Amt</label>
<input type="text" name="<%= BUDGETED_AMOUNT%>" value="" validate="Budgeted Amt,float,yes" MAXLENGTH="15" tabindex=1 />

<label>Additional Allocated Amt</label>
<input type="text" name="<%= ADDITIONAL_ALLOCATED_AMOUNT%>" value="" validate="Additional Allocated Amt,float,no" MAXLENGTH="15" tabindex=1 />
<div class="clear"></div>

<label>Changed By:</label>
<label class="value"><%=userName%></label>
<label>Changed Date:</label>
<label class="value"><%=date%></label>
<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="clear"></div>
<input type="button" name="sss" align="right" class="button" value="Submit"	onclick="submitForm('budgetEntryGrid','pharmacy?method=addBudgetDetails')" />
<div class="clear"></div>

<fieldset style="width:1135px;">
<legend>Budget Entry Details</legend>

<div class="clear"></div>
<div class="paddingTop5"></div>

<div style="overflow: auto; width:100%; height:160px;">
<table width="100%" id="budgetEntryDetails" border="0" cellpadding="0" cellspacing="0" style="border-top:1px solid #C0C0C0;">
	<thead>
		<tr>
			<td width="5%"><label>S.No.</label></td>			
			<td width="13%"><label>Authority Letter No.</label></td>			
			<td width="10%"><label>Projected Amount</label></td>			
			<td width="13%"><label>Budgeted Amount</label></td>
			<td width="13%"><label>Additional Allocated Amount</label></td>
		</tr>

	</thead>
	<tbody>
	
		<% 	
		int srNo = 1;
	for (Iterator iterator = budgetDetailsList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();
		//int srNo = (Integer)object[0];
		String authorityLetterNo = (String)object[1];
		BigDecimal projectAmt = (BigDecimal)object[2];
		BigDecimal budgetedAmt = (BigDecimal)object[3];
		BigDecimal additionalAmt = (BigDecimal)object[4];			
	%>

		<tr>
			<td width="5%"><input type="text" size="2" value="<%=srNo++%>"
				class="readOnly" name="" readonly="readonly" /></td>

			<td width="10%">
			<% if(authorityLetterNo != null){%> <input type="text"
				value="<%=authorityLetterNo%>" class="readOnly" name=""
				readonly="readonly" tabindex="2" /> <%}else{ %> <input type="text"
				value="" class="readOnly" name="" readonly="readonly" tabindex="2" />
			<%} %>
			</td>

			<td width="10%">
			<% if(projectAmt != null){%> <input type="text" value="<%=projectAmt%>"
				class="readOnly" name="" readonly="readonly" tabindex="2" /> <%}else{ %>
			<input type="text" value="" class="readOnly" name=""
				readonly="readonly" tabindex="2" /> <%} %>
			</td>

			<td width="3%">
			<% if(budgetedAmt != null){%> <input type="text" class="readOnly"
				value="<%=budgetedAmt%>" name="" readonly="readonly" tabindex="2" />
			<%}else{ %> <input type="text" class="readOnly" value="" name=""
				readonly="readonly" tabindex="2" /> <%} %>
			</td>

			<td width="3%">
			<% if(additionalAmt != null){%> <input type="text" class="readOnly"
				value="<%=additionalAmt%>" name="" readonly="readonly" tabindex="2" />
			<%}else{ %> <input type="text" class="readOnly" value="" name=""
				readonly="readonly" tabindex="2" /> <%} %>
			</td>
		</tr>
		<input type="hidden" name="<%=SR_NO %>" value="<%=srNo %>" /> <%} %>
		
	</tbody>

</table>
</div>

</fieldset>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<script type="text/javascript">
	<!--
		// Main vBulletin Javascript Initialization
		vBulletin_init();
	//-->
	</script>
<input type="hidden" name="rows" id="rr" value="1" />






