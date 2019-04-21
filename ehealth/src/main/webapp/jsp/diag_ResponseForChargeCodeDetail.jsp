
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<% 
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<DgMasInvestigation> chargeCodeList= new ArrayList<DgMasInvestigation>(); 
	List<MasChargeCode> chargeCodeList1= new ArrayList<MasChargeCode>();
	if(map.get("chargeCodeList") != null){
		chargeCodeList = (List)map.get("chargeCodeList");
	}
	if(map.get("chargeCodeList1") != null){
		chargeCodeList1 = (List)map.get("chargeCodeList1");
	}
	
	
	BigDecimal chargeAmountAfterDis = new BigDecimal(0.00);
	
	if(map.get("chargeAmountAfterDis") != null){
		chargeAmountAfterDis = (BigDecimal)map.get("chargeAmountAfterDis");
	}
	
	String rowVal= null;
	if(map.get("rowVal") != null){
		rowVal = (String)map.get("rowVal");
		
	}
	BigDecimal charge=new BigDecimal(0.00);
	String chargeName="";
	Date currentDate = new Date();
	if(chargeCodeList.size() > 0){
		DgMasInvestigation masInvestigation = (DgMasInvestigation)chargeCodeList.get(0);
	   chargeName=masInvestigation.getInvestigationName();
	 //  charge=masInvestigation.getChargeCode().getCharge().toString();
	 
	   Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
		if(masInvestigation.getChargeCode().getMasChargeCodeRates() != null){
			chargeSet = masInvestigation.getChargeCode().getMasChargeCodeRates();
			if(chargeSet.size() > 0){
				for(MasChargeCodeRates chargeRate : chargeSet){
					if(currentDate.compareTo(chargeRate.getEffectiveFromDate()) >= 0 && (chargeRate.getEffectiveToDate() == null || currentDate.compareTo(chargeRate.getEffectiveToDate()) <= 0)){
						//charge = chargeRate.getRate().toString();
						charge = chargeAmountAfterDis;
						break;
					}else{
					//	charge = new BigDecimal(masInvestigation.getChargeCode().getCharge()).toString();
						charge = chargeAmountAfterDis;
					}
					
				}
				
			}else{
				//charge = new BigDecimal(masInvestigation.getChargeCode().getCharge()).toString();
				charge = chargeAmountAfterDis;
			}
			
		}else{
			//charge = new BigDecimal(masInvestigation.getChargeCode().getCharge()).toString();
			charge = chargeAmountAfterDis;
		}
   
       int chargeCodeId=masInvestigation.getChargeCode().getId();
    	if (masInvestigation.getChargeCode().getEditable().equals("y")) {
%>
<%@page import="jkt.hms.masters.business.MasChargeCodeRates"%>
<%@page import="java.math.BigDecimal"%>

<%@page import="jkt.hms.masters.business.MasChargeCode"%><script>
   	   document.getElementById('resrate<%=rowVal%>').readOnly = true;
   	   document.getElementById('chargeName<%=rowVal%>').readOnly = true;
   	    document.getElementById('qty<%=rowVal %>').readOnly = true;
 	   document.getElementById('chargeName<%=rowVal%>').value = '<%=chargeName %>';
 </script>

<%
	} else {
%>
<script>
 		document.getElementById('chargeName<%=rowVal%>').readOnly = true;
 		document.getElementById('chargeName<%=rowVal%>').value = '<%=chargeName %>';
</script>

<%	}%>
<input id="resrate<%=rowVal %>" size="15" type="text"
	name="<%=RATE%><%=rowVal%>" value="<%=charge %>"
	onblur="calculateAmt(<%=rowVal %>);totalCost(<%=rowVal %>);" tabindex="1"
	class="readOnly" readonly />
	
<script>

    document.getElementById('resrate<%=rowVal %>').focus();
     document.getElementById('qty<%=rowVal %>').readOnly = false;
    </script>
<input type="hidden" name="<%=CHARGE_CODE_ID%><%=rowVal %>"
	value="<%=chargeCodeId%>" />
<input type="hidden" name="<%=MAIN_CHARGECODE_ID%><%=rowVal %>"
	value="<%= masInvestigation.getChargeCode().getMainChargecode().getId()%>" />
<input type="hidden" name="<%=SUB_CHARGECODE_ID%><%=rowVal %>"
	value="<%= masInvestigation.getChargeCode().getSubChargecode().getId()%>" />

<%}else if(chargeCodeList1.size()>0){ 

		MasChargeCode masInvestigation = (MasChargeCode)chargeCodeList1.get(0);
	   chargeName=masInvestigation.getChargeCodeName();
	 //  charge=masInvestigation.getChargeCode().getCharge().toString();
	 
	   Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
		if(masInvestigation.getMasChargeCodeRates() != null){
			chargeSet = masInvestigation.getMasChargeCodeRates();
			if(chargeSet.size() > 0){
				for(MasChargeCodeRates chargeRate : chargeSet){
					if(currentDate.compareTo(chargeRate.getEffectiveFromDate()) >= 0 && (chargeRate.getEffectiveToDate() == null || currentDate.compareTo(chargeRate.getEffectiveToDate()) <= 0)){
						//charge = chargeRate.getRate().toString();
						charge = chargeAmountAfterDis;
						break;
					}else{
					//	charge = new BigDecimal(masInvestigation.getCharge()).toString();
						charge = chargeAmountAfterDis;
					}
					
				}
				
			}else{
				//charge = new BigDecimal(masInvestigation.getCharge()).toString();
				charge = chargeAmountAfterDis;
			}
			
		}else{
			//charge = new BigDecimal(masInvestigation.getCharge()).toString();
			charge = chargeAmountAfterDis;
		}
   
       int chargeCodeId=masInvestigation.getId();
    	if (masInvestigation.getEditable().equals("y")) {
%>
<%@page import="jkt.hms.masters.business.MasChargeCodeRates"%>
<%@page import="java.math.BigDecimal"%>
<script>
   	   document.getElementById('resrate<%=rowVal%>').readOnly = true;
   	   document.getElementById('chargeName<%=rowVal%>').readOnly = true;
   	    document.getElementById('qty<%=rowVal %>').readOnly = true;
 	   document.getElementById('chargeName<%=rowVal%>').value = '<%=chargeName %>';
 </script>

<%
	} else {
%>
<script>
 		document.getElementById('chargeName<%=rowVal%>').readOnly = true;
 		document.getElementById('chargeName<%=rowVal%>').value = '<%=chargeName %>';
</script>

<%	}%>
<input id="resrate<%=rowVal %>" size="15" type="text"
	name="<%=RATE%><%=rowVal%>" value="<%=charge %>"
	onblur="calculateAmt(<%=rowVal %>);totalCost();" tabindex="1"
	class="readOnly" readonly />
	
<script>

    document.getElementById('resrate<%=rowVal %>').focus();
     document.getElementById('qty<%=rowVal %>').readOnly = false;
    </script>
<input type="hidden" name="<%=CHARGE_CODE_ID%><%=rowVal %>"
	value="<%=chargeCodeId%>" />
<input type="hidden" name="<%=MAIN_CHARGECODE_ID%><%=rowVal %>"
	value="<%= masInvestigation.getMainChargecode().getId()%>" />
<input type="hidden" name="<%=SUB_CHARGECODE_ID%><%=rowVal %>"
	value="<%= masInvestigation.getSubChargecode().getId()%>" />


<%} %>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
