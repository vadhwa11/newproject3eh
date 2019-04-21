<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	List investigationTemplateList= new ArrayList();

	if(map.get("investigationTemplateList") != null){
		investigationTemplateList = (List)map.get("investigationTemplateList");
	}
	BigDecimal totalRate = new BigDecimal(0);

	%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdTemplateInvestigation"%>

<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasChargeCodeRates"%>
<div id="gridview" >
<div class="tableForTab">
<table id="investigationGrid" border="0" cellspacing="0" cellpadding="0">
	<tr>


		<th scope="col">Test Name</th>
		<th scope="col">Test Code</th>
		<th scope="col">Rate</th>
		<th scope="col">Clinical Notes</th>

	</tr>
	<%
	    BigDecimal charge = new BigDecimal(0.00);
	    Date currentDate = new Date();
	    int i=1;
	       Iterator itr=investigationTemplateList.iterator();
	      while(itr.hasNext())
	      {
	    	  OpdTemplateInvestigation opdInvestigation=(OpdTemplateInvestigation)itr.next();

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
		<td><input type="text" name="chargeCodeName<%=i%>"
			value="<%=opdInvestigation.getChargeCode().getChargeCodeName()%>[<%=opdInvestigation.getChargeCode().getId()%>]"
			readonly size="35" />
		<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"
			tabindex="1"></div>
		</td>
		<td id="chargeCodeVal"><input type="text" name="chargeCode<%=i%>"
			value="<%=opdInvestigation.getChargeCode().getChargeCodeCode()%>"
			readonly size="15" /></td>
		<td><input type="text" name="rate<%=i %>" id="rate<%=i %>"
			value="<%=charge %>" size="8" readonly="readonly" /></td>

		<td><input type="text" name="clinicalNotes<%=i%>"
			value="<%=opdInvestigation.getClinicalNotes() %>" size="20" /></td>
	</tr>
	<%i++;} %>
</table>
<input type="hidden" value="<%=i-1%>" name="hiddenValue" id="hiddenValue" />
<div class="clear"></div>

<script type="text/javascript">
	document.getElementById('totalRate').value = '<%=totalRate%>'
	</script></div>
	</div>



