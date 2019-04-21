<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientVisitSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionDetails"%>



<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>


<title>Patient Search For Pre Anesthesia Procedure Notes Entry</title>
<div class="clear"></div>
<form name="search" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		
		List<InpatientPrescriptionDetails> patientList = new ArrayList<InpatientPrescriptionDetails>();
		String otProcedure="";
		String url="";
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		
		if(patientMap.get("ipdList") != null){
			patientList= (List<InpatientPrescriptionDetails>)patientMap.get("ipdList");
		}
		if(map.get("otProcedure") != null){
			otProcedure= (String)map.get("otProcedure");
		}
		if(otProcedure.equals("yes"))
		{
			
		}
		else if(otProcedure.equals("no"))
		{
			
		}
	%> <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %> 
    
    <div class="clear"></div>
<table colspan="7" id="indentDetails">
	<thead>
		<tr>
			<th width="5%">S.No.</th>
			<th width="13%">Item No</th>
			<th width="10%">Item Name</th>
			<th width="13%">A/U</th>
			<th width="13%">Available Stock</th>
			<th width="13%">Qty Requested</th>
			<th width="13%">Qty Issued</th>
			<th width="13%">&nbsp;</th>
		</tr>
	</thead>
	<tbody>
		<% int inc = 1;
		int hinId=0;
		int patientTypeId=0;
		String deptCode="";
	  	for(InpatientPrescriptionDetails patientStoreIndentDetails : patientList){
	  		String pvmsNo="";
	  		if(patientStoreIndentDetails.getItem()!=null){
		  		pvmsNo=patientStoreIndentDetails.getItem().getPvmsNo();
	  		}
	  		hinId=patientStoreIndentDetails.getPrescription().getHin().getId();
	  		patientTypeId=patientStoreIndentDetails.getPrescription().getHin().getPatientType().getId();
	  		deptCode=patientStoreIndentDetails.getPrescription().getDepartment().getDepartmentCode();
	  		%>
		<tr>
			<td><input type="hidden" size="2"
				value="<%=patientStoreIndentDetails.getId() %>" MAXLENGTH="7"
				name="patientIndentDetailsId<%=inc %>"
				id="patientIndentHeaderId<%=inc %>" /> <input type="text" size="2"
				tabindex="1" value="<%=inc %>" id="srNo<%=inc %>" name="<%=SR_NO%>"
				readonly="readonly" /></td>
			<td><input type="text" size="8" tabindex="1"
				name="<%=ITEM_CODE%><%=inc %>"
				value="<%=pvmsNo %>"
				id="itemCode<%=inc %>" /> <input type="hidden" size="2"
				value="<%=patientStoreIndentDetails.getItem().getId() %>"
				MAXLENGTH="7" name="<%=ITEM_ID%><%=inc %>" id="itemId<%=inc %>" />
			</td>
			<td><input type="text" size="50" tabindex="1"
				value="<%=patientStoreIndentDetails.getItem().getNomenclature() %>"
				id="" name="<%=NOMENCLATURE%><%=inc %>" /></td>
			<td><input type="text" size="8" value="" id="au<%=inc %>"
				readonly /></td>
			<td><input type="text" size="8" value=""
				id="availableStock<%=inc %>" readonly /></td>
			<td><input type="text" size="8"
				value="<%=patientStoreIndentDetails.getTotal() %>"
				readonly="readonly" name="<%=QTY_IN_REQUEST%><%=inc %>" id="" /></td>
			<td><input type="text" size="8" tabindex="1" readonly="readonly"
				value="" name="<%=QUANTITY%><%=inc %>" tabindex="2"
				id="qty<%=inc %>" /></td>
			<td><input type="button" class="buttonIssue" tabindex="1"
				onclick="{openPopupForItem(<%=inc%>);}" name="Submit2"  />
			<input type="hidden" size="10" value="" id="amount<%=inc%>"
				name="<%=AMOUNT%><%=inc%>" validate="Amount,float,no"
				readonly="readonly" /> <input type="hidden" value="" size="11"
				id="salesTaxAmt<%=inc%>" name="<%=SALES_TAX_AMOUNT %><%=inc%>"
				readonly="readonly" validate="Sales Tax Persentage,string,no" /> <input
				type="hidden" value="" id="dispercent<%=inc%>"
				name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" size="8"
				validate="Discount Persentage,string,no"
				onchange="if(checkDiscountAmt(<%=inc %>)){calculateBatchWiseDiscount(<%=inc %>); calculateDiscountAmt(<%=inc%>);calculateNetAmtForDispensing(<%=inc %>);calculateTotalAmt();};"
				maxlength="3" /> <input type="hidden" value=""
				id="disamount<%=inc%>" size="10" name="<%=DISCOUNT %><%=inc%>"
				validate="Discount Amount,string,no"
				onchange="validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateBatchWiseDiscount(<%=inc %>);calculateNetAmtForDispensing(<%=inc %>);calculateTotalAmt();"
				maxlength="7" /> <input type="hidden" value=""
				id="prprtnlDis<%=inc%>" name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
				validate="Proporational Discount,string,no" readonly="readonly"
				size="12" /> <input type="hidden" size="10" value=""
				id="netamount<%=inc%>" name="<%=NET_AMOUNT %><%=inc%>"
				validate="Net Amount,float,no" readonly="readonly" /> <input
				type="hidden" id="itemBatchCount<%=inc %>" value="" /> <input
				type="hidden" name="<%=FA_ACCOUNT_ID %><%=inc%>"
				id="accountId<%=inc%>" value="" /> <input type="hidden"
				name="<%=FA_SUB_LED_ID %><%=inc%>" id="subAccountId<%=inc%>"
				value="" /> <input type="hidden" name="issued<%=inc%>"
				id="issued<%=inc%>" value="" /></td>
		</tr>
		<%inc++;} %>

	</tbody>

</table>
<input type="hidden" value="<%=inc %>" name="hiddenValueItem"
	id="hiddenValueCharge" />
  <script>
function openPopupForItem(rowVal){
	var code = "";
	code = document.getElementById('itemCode'+rowVal).value;
		if(code !=""){
			window.open('opBilling?method=showItemBatchNoPopUp&itemCode='+encodeURIComponent(code)+'&rowVal='+rowVal+'&hinId='+<%=hinId%>+'&patientTypeId=<%=patientTypeId%>&deptCode=<%=deptCode%>','mywindow','target="_blank", width=780,height=300');

		}

	}
</script>
</form>
