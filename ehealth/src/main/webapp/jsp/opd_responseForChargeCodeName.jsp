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

<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	BigDecimal chargeAmt = new BigDecimal(0.00);

	List<MasChargeCode> chargeCodeList= new ArrayList<MasChargeCode>();
	if(map.get("chargeCodeList") != null){
		chargeCodeList = (List)map.get("chargeCodeList");
	}
	
	List<MasDiscount>discountList=new ArrayList<MasDiscount>();
	if(map.get("discountList") != null){
		discountList = (List)map.get("discountList");
	}
	
	if(map.get("chargeAmountAfterDis") != null){
		chargeAmt = (BigDecimal)map.get("chargeAmountAfterDis");
	}

	String rowVal= null;
	if(map.get("rowVal")!= null){
		rowVal = (String)map.get("rowVal");
	}
	Date date = new Date();
	int patienttypeId=0;
	if(map.get("patienttypeId") != null){
		patienttypeId = (Integer)map.get("patienttypeId");
	}
	
%>

<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%
   BigDecimal charge=new BigDecimal(0.00);

       MasChargeCode masChargeCode=(MasChargeCode)chargeCodeList.get(0);
       String chargeCode=masChargeCode.getChargeCodeCode();
       int mainChargeCodeId=0;
       mainChargeCodeId=masChargeCode.getMainChargecode().getId();
       int chargeCodeId=masChargeCode.getId();
       String chargeCodeName=masChargeCode.getChargeCodeName();
     //
      Set<MasChargeCodeRates> chargeSet = new HashSet<MasChargeCodeRates>();
      if(chargeCodeName.substring(0,3).equals("HAI") || chargeCodeName.substring(0,3).equals("Q S") || chargeCodeName.substring(0,3).equals("IPL") && patienttypeId==17){
    	  charge=new BigDecimal(masChargeCode.getCharge());
      }else if(mainChargeCodeId==21 && patienttypeId==21){
			
			for(MasDiscount dis:discountList){
				if(dis.getFixedValue()!=null){
				charge =dis.getFixedValue();
			}}
			
			
		} else
    	  if(chargeCodeName.substring(0,3).equals("HAI") || chargeCodeName.substring(0,3).equals("Q S") || chargeCodeName.substring(0,3).equals("IPL") &&  patienttypeId==15){
    		//
    		  charge=new BigDecimal(masChargeCode.getCharge()/2);
        	  chargeCode=""+masChargeCode.getCharge()/2;
          }
       else
		if(masChargeCode.getMasChargeCodeRates() != null){
			chargeSet = masChargeCode.getMasChargeCodeRates();
			if(chargeSet.size() > 0){
				for(MasChargeCodeRates chargeRate : chargeSet){
					
					if(date.compareTo(chargeRate.getEffectiveFromDate()) >= 0 && (chargeRate.getEffectiveToDate() == null || date.compareTo(chargeRate.getEffectiveToDate()) <= 0)){
						charge = chargeAmt;
						
						break;
					}else{
						
						charge = chargeAmt;
					}
				}
			}else{
				charge = chargeAmt;
			}

		}
   %>
<%@page import="jkt.hms.masters.business.MasChargeCodeRates"%>
<%@page import="java.math.BigDecimal"%>
<%// %>

<%@page import="jkt.hms.masters.business.MasDiscount"%>

<input id="chargeCode<%=rowVal %>" type="hidden" id="chargeCode<%=rowVal%>" size="10" name="chargeCode<%=rowVal%>"	value="<%=chargeCode %>" readonly />
<input type="hidden" name="chargeCodeId<%=rowVal%>" value="<%=chargeCodeId%>" />

<script>
  	if(document.getElementById('rate<%=rowVal%>')){
  	  	<%if(patienttypeId==15 || patienttypeId==16){%>
  		document.getElementById('rate<%=rowVal%>').value = '<%=charge.divide(new BigDecimal(2))%>'
  	  		<%} else if(patienttypeId==17){%>
  	  	document.getElementById('rate<%=rowVal%>').value = '<%=charge%>'
  	  		<%} else {%>
  	  	document.getElementById('rate<%=rowVal%>').value = '<%=charge%>'
  	  		<%} %>
  	  	
  		calculateTotalRate();
  		}
  	</script>
<%
chargeCodeList.clear();
chargeSet.clear();
%>



