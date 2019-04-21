<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdTemplateInvestigation"%>

<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasChargeCodeRates"%>
<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<OpdTemplateInvestigation> investigationTemplateList= new ArrayList<OpdTemplateInvestigation>();
	
	if(map.get("investigationTemplateList") != null){
		investigationTemplateList = (List)map.get("investigationTemplateList");
	}
	BigDecimal totalRate = new BigDecimal(0);
	String type = "";
	int hin = 0;
	String registrationType = "";
	if(map.get("type") != null){
		type = (String)map.get("type");
	}
	if(map.get("hin") != null){
		hin = (Integer)map.get("hin");
	}
	if(map.get("registrationType") != null){
		registrationType = (String)map.get("registrationType");
	}
	%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails" class="cmntable">
	<tr>
		<th scope="col"></th>
		<th scope="col">Charge Description</th>
		<th scope="col">Qty</th>
		<th scope="col">Rate</th>
		<th scope="col">Std. Deduction</th>
		<th scope="col">Amount</th>
		<th scope="col">Discount(%)</th>
		<th scope="col">Discount Amt</th>
		<th scope="col">Charity</th>
		<th scope="col">Net Amount</th>
		<th scope="col">&nbsp;</th>
	</tr>
	
	<% 
	    BigDecimal charge = new BigDecimal(0.00);
	    Date currentDate = new Date();
	    int inc=0;
	    if(investigationTemplateList.size() > 0){
	    	for(OpdTemplateInvestigation opdInvestigation : investigationTemplateList){
	    		inc = inc+1;
	    	  Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
	  		  if(opdInvestigation.getChargeCode().getMasChargeCodeRates() != null){
	  			chargeSet = opdInvestigation.getChargeCode().getMasChargeCodeRates();
	  			if(chargeSet.size() > 0){
	  				for(MasChargeCodeRates chargeRate : chargeSet){
	  					if(currentDate.compareTo(chargeRate.getEffectiveFromDate()) >= 0 && (chargeRate.getEffectiveToDate() == null || currentDate.compareTo(chargeRate.getEffectiveToDate()) <= 0)){
	  						charge = chargeRate.getRate();
	  						break;
	  					}else{
	  						charge = new BigDecimal(opdInvestigation.getChargeCode().getCharge());
	  					}
	  					
	  				}
	  				
	  			}else{
	  				charge = new BigDecimal(opdInvestigation.getChargeCode().getCharge());
	  			}
	  			
	  		}else{
	  			charge = new BigDecimal(opdInvestigation.getChargeCode().getCharge());
	  		}
	     
	    	  totalRate = totalRate.add((charge.multiply(new BigDecimal(opdInvestigation.getTemplateInvestigationQty()))));
	    	  
	      
	    %>
	<tr>
		<td><input type="radio" value="<%=inc%>" name="selectedChrage"
			class="radioCheck" /></td>
		<td><input type="text" name="chargeCode<%=inc%>"
			id="chargeCode<%=inc%>" value="<%=opdInvestigation.getChargeCode().getChargeCodeName()+"["+opdInvestigation.getChargeCode().getChargeCodeCode()+"]" %>"
			onblur="if(validateChargeCodeForBillingAutoComplete(this.value, '<%=inc %>','op')){submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge1='+encodeURIComponent(this.value)+'&rowVal=1&hin=<%=hin%>&type=<%=type %>','rateVal');}"
			tabindex="1" />
		<div id="ac2update<%=inc%>" style="display: none;"
			class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			   function eventCallback(element, entry){
					return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value; 
				}
			    new Ajax.Autocompleter('chargeCode<%=inc%>','ac2update<%=inc%>','opBilling?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode<%=inc%>', callback: eventCallback});
			  
			</script>
			
			 <input type="hidden" id="chargeId<%=inc %>"
			name="<%=CHARGE_CODE_ID%><%=inc %>"
			value="<%=opdInvestigation.getChargeCode().getId()%>" /></td>
		<td><input type="text" size="5" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc%>" value="<%= opdInvestigation.getTemplateInvestigationQty()%>" validate="Qty,int,no"
			onblur="if(validateQtyForBilling(this.value,this.id,<%=inc %>)){calculateNetAmount(<%=inc %>);calcProportionalDisc(<%=inc %>);calculateTotalAmt();}"
			maxlength="3" readonly="readonly" /></td>
		<td id="rateVal"><input type="text" size="12" value="<%=charge %>"
			id="resrate<%=inc%>" name="<%=RATE%><%=inc%>"
			validate="Rate,float,no" readonly="readonly" /></td>

		<%
		BigDecimal stdDedGen = new BigDecimal(0.00);
		BigDecimal stdDedSpl = new BigDecimal(0.00);
		if(registrationType.equals("G")){ 
			if(opdInvestigation.getChargeCode().getStdDeductionGen() != null){
				stdDedGen = opdInvestigation.getChargeCode().getStdDeductionGen();
			}
		%>

		<td><input type="text" size="12" value="<%=stdDedGen %>"
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%}else if(registrationType.equals("S")){
			if(opdInvestigation.getChargeCode().getStdDeductionSpl() != null){
				stdDedSpl = opdInvestigation.getChargeCode().getStdDeductionSpl();
			}
			%>
		<td><input type="text" size="12" value="<%=stdDedSpl %>"
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%}else{ %>
		<td><input type="text" size="12" value=""
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%} %>
		<td><input type="text" value="" id="amount<%=inc%>" size="13"
			name="<%=AMOUNT%><%=inc%>" validate="Amount,float,no"
			readonly="readonly" /></td>
		<td><input type="text" value="" id="dispercent<%=inc%>"
			name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" size="10"
			validate="Discount Persentage,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt();}"
			maxlength="3" disabled="disabled" /></td>
		<td><input type="text" value="" id="disamount<%=inc%>"
			name="<%=DISCOUNT %><%=inc%>" validate="Discount Amount,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
			maxlength="7" disabled="disabled" size="10" /></td>
		<td><input type="text" value="" id="prprtnlDis<%=inc%>"
			name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
			validate="Proporational Discount,string,no" readonly="readonly"
			size="10" /></td>
		<td><input type="text" value="" id="netamount<%=inc%>"
			name="<%=NET_AMOUNT %><%=inc%>" validate="Net Amount,string,no"
			readonly="readonly" size="10" /></td>
		<td><input type="button" name="add" value="" class="buttonAdd"
			onclick="addRow();" tabindex="1" /></td>
	</tr>
	<script>
	calculateNetAmount(<%=inc %>);calcProportionalDisc(<%=inc %>);calculateTotalAmt();
	</script>
	<%}
	    	}else{
	    		inc = inc +1;
	    	%>
	    	<tr>

		<td><input type="radio" value="<%=inc%>" name="selectedChrage"
			class="radioCheck" /></td>
		<td><input type="text" name="chargeCode<%=inc%>"
			id="chargeCode<%=inc%>"
			onblur="if(validateChargeCodeForBillingAutoComplete(this.value, '<%=inc %>','op')){submitProtoAjaxWithDivNameForBilling('billServicing','/hms/hms/opBilling?method=fillChargeCode&charge1='+encodeURIComponent(this.value)+'&rowVal=1&hin=<%=hin%>&type=op','rateVal');}"
			tabindex="1" />
		<div id="ac2update<%=inc%>" style="display: none;"
			class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			   function eventCallback(element, entry){
					return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value; 
				}
			    new Ajax.Autocompleter('chargeCode<%=inc%>','ac2update<%=inc%>','opBilling?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode<%=inc%>', callback: eventCallback});
			  
			</script></td>
		<td><input type="text" size="5" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc%>" value="" validate="Qty,int,no"
			onblur="if(validateQtyForBilling(this.value,this.id,<%=inc %>)){calculateNetAmount(<%=inc %>);calcProportionalDisc(<%=inc %>);calculateTotalAmt();}"
			maxlength="3" readonly="readonly" /></td>
		<td id="rateVal"><input type="text" size="12" value=""
			id="resrate<%=inc%>" name="<%=RATE%><%=inc%>"
			validate="Rate,float,no" readonly="readonly" /></td>

		<%if(registrationType.equals("G")){ %>

		<td><input type="text" size="12" value=""
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%}else if(registrationType.equals("S")){ %>
		<td><input type="text" size="12" value=""
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%}else{ %>
		<td><input type="text" size="12" value=""
			id="standardDeductionId<%=inc%>"
			name="<%=STANDARD_DEDUCTION%><%=inc%>"
			validate="Standard Deduction,float,no" readonly="readonly" /></td>

		<%} %>
		<td><input type="text" value="" id="amount<%=inc%>" size="13"
			name="<%=AMOUNT%><%=inc%>" validate="Amount,float,no"
			readonly="readonly" /></td>
		<td><input type="text" value="" id="dispercent<%=inc%>"
			name="<%=DISCOUNT_PERCENTAGE %><%=inc%>" size="10"
			validate="Discount Persentage,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){calculateDiscountAmt(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt();}"
			maxlength="3" disabled="disabled" /></td>
		<td><input type="text" value="" id="disamount<%=inc%>"
			name="<%=DISCOUNT %><%=inc%>" validate="Discount Amount,string,no"
			onchange="if(checkDiscountAmt(<%=inc %>)){validateDiscAmt(this.value,<%=inc %>);disableDiscountPercent(<%=inc%>);calculateNetAmount(<%=inc %>);calculateTotalAmt()};"
			maxlength="7" disabled="disabled" size="10" /></td>
		<td><input type="text" value="" id="prprtnlDis<%=inc%>"
			name="<%=PROPORTIONAL_DISCOUNT%><%=inc%>"
			validate="Proporational Discount,string,no" readonly="readonly"
			size="10" /></td>
		<td><input type="text" value="" id="netamount<%=inc%>"
			name="<%=NET_AMOUNT %><%=inc%>" validate="Net Amount,string,no"
			readonly="readonly" size="10" /></td>
		<td><input type="button" name="add" value="" class="buttonAdd"
			onclick="addRow();" tabindex="1" /></td>
	</tr>
	<script>
	calculateNetAmount(<%=inc %>);calcProportionalDisc(<%=inc %>);calculateTotalAmt();
	</script>
    	<%}%>

<div class="clear"></div>

<script type="text/javascript">
	document.getElementById('hiddenValueCharge').value = '<%=inc%>'
	</script>




		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
