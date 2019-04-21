<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.BlReceiptHeader"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.math.BigDecimal"%>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	int totalReg = 0;
	int totalVisit = 0;
	int totalOP = 0;
	int totalAdm = 0;
	String tab = "";
	
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>)request.getAttribute("map");
	}
	if(map.get("newRegistrations")!=null){
		totalReg=(Integer)map.get("newRegistrations");
	}
	if(map.get("newVisits")!=null){
		totalVisit=(Integer)map.get("newVisits");
	}
	if(map.get("newAdmission")!=null){
		totalAdm=(Integer)map.get("newAdmission");
	}
	totalOP = totalReg + totalVisit;
	
	if(map.get("tab")!=null){
		tab=(String)map.get("tab");
	}
%>

<%
	if(tab.equalsIgnoreCase("mrd")){
%>

<label>New Registration</label>
<label class="value"><%=totalReg %></label>

<div class="clear"></div>

<label>Repeat Patient</label>
<label class="value"><%=totalVisit %></label>

<div class="clear"></div>

<label>OP Total</label>
<label class="value"><%=totalOP %></label>

<div class="clear"></div>

<label>IP Admission</label>
<label class="value"><%=totalAdm %></label>

<%}else if(tab.equalsIgnoreCase("billing")){
	List<BlReceiptHeader> receiptList  = new ArrayList<BlReceiptHeader>();
	List<BigDecimal> onAccList  = new ArrayList<BigDecimal>();
	List<BigDecimal> finalSettlementList  = new ArrayList<BigDecimal>();
	
	if(map.get("receiptList") != null){
		receiptList = (List<BlReceiptHeader>)map.get("receiptList");
	}
	if(map.get("onAccList") != null){
		onAccList = (List<BigDecimal>)map.get("onAccList");
	}
	if(map.get("finalSettlementList") != null){
		finalSettlementList = (List<BigDecimal>)map.get("finalSettlementList");
	}
	BigDecimal totalServAmt = new BigDecimal(0.00);
	BigDecimal totalDispAmt = new BigDecimal(0.00);
	BigDecimal totalAdvAmt = new BigDecimal(0.00);
	BigDecimal totalFinalStAmt = new BigDecimal(0.00);
	BigDecimal totalOnAccAmt = new BigDecimal(0.00);
	
	if(receiptList.size() > 0){
		for(BlReceiptHeader receiptHeader : receiptList){
			if(receiptHeader.getReceiptType().equals("opb") || receiptHeader.getReceiptType().equals("chs") ){
				totalServAmt = totalServAmt.add(receiptHeader.getAmount());
			}
			if(receiptHeader.getReceiptType().equals("bld")){
				totalDispAmt = totalDispAmt.add(receiptHeader.getAmount());
			}
			if(receiptHeader.getReceiptType().equals("adv")){
				totalAdvAmt = totalAdvAmt.add(receiptHeader.getAmount());
			}
		//	if(receiptHeader.getReceiptType().equals("fs")){
		//		totalFinalStAmt = totalFinalStAmt.add(receiptHeader.getAmount());
		//	}
			
		//	if(receiptHeader.getOpBillHeader() != null){
			//	if(receiptHeader.getOpBillHeader().getOutstanding() !=  null)
			//		totalOnAccAmt = totalOnAccAmt.add(receiptHeader.getOpBillHeader().getOutstanding());
		//	}
		//	if(receiptHeader.getDispensingHeader() != null){
		//		if(receiptHeader.getDispensingHeader().getOutstanding() !=  null)
		//			totalOnAccAmt = totalOnAccAmt.add(receiptHeader.getDispensingHeader().getOutstanding());
		//	}
		//	if(receiptHeader.getChargeSlipMain() != null){
		//		if(receiptHeader.getChargeSlipMain().getOsAmt() !=  null)
		//			totalOnAccAmt = totalOnAccAmt.add(receiptHeader.getChargeSlipMain().getOsAmt());
		//	}
		}
	}
	if(finalSettlementList.size() > 0 && finalSettlementList != null){
		if(finalSettlementList.get(0) != null)
			totalFinalStAmt = (BigDecimal)finalSettlementList.get(0) ;
	}
	if(onAccList.size() > 0 && onAccList != null){
		if(onAccList.get(0) != null)
				totalOnAccAmt = (BigDecimal)onAccList.get(0) ;
	}
%>
<label>OP Servicing Total</label>
<label class="value"><%=totalServAmt %></label>

<div class="clear"></div>

<label>OP Dispensing Total</label>
<label class="value"><%=totalDispAmt %></label>

<div class="clear"></div>

<label>Advance</label>
<label class="value"><%= totalAdvAmt%></label>

<div class="clear"></div>

<label>Final Settlement</label>
<label class="value"><%= totalFinalStAmt%></label>

<div class="clear"></div>

<label>On Account</label>
<label class="value"><%=totalOnAccAmt %></label>

<%}else if(tab.equalsIgnoreCase("pharmacy")){
	 List<Object[]> pendingGrnList = new ArrayList<Object[]>();
	 List<Object[]> pendingPOList = new ArrayList<Object[]>();
	 List<Object[]> pendingDeptIssueList = new ArrayList<Object[]>();
		
	 if(map.get("pendingGrnList") != null){
		 pendingGrnList = (List<Object[]>)map.get("pendingGrnList");
	 }
	 if(map.get("pendingPOList") != null){
		 pendingPOList = (List<Object[]>)map.get("pendingPOList");
	 }		
	 if(map.get("pendingDeptIssueList") != null){
		 pendingDeptIssueList = (List<Object[]>)map.get("pendingDeptIssueList");
	 }	
%>
<%
	int pendingPoCS = 0;
	int pendingPoGS = 0;
	if(pendingPOList.size() > 0){
		for(Object[] obj : pendingPOList){
			if((Integer)obj[1] == 24){
				pendingPoCS = (Integer)obj[0];
			}else if((Integer)obj[1] == 25){
				pendingPoGS = (Integer)obj[0];
			}
		}
		
	}
	int pendingGrnCS = 0;
	int pendingGrnGS = 0;
	if(pendingPOList.size() > 0){
		for(Object[] obj : pendingGrnList){
			if((Integer)obj[1] == 24){
				pendingGrnCS = (Integer)obj[0];
			}else if((Integer)obj[1] == 25){
				pendingGrnGS = (Integer)obj[0];
			}
		}
		
	}
	int pendingDeptIssueCS = 0;
	int pendingDeptIssueGS = 0;
	if(pendingPOList.size() > 0){
		for(Object[] obj : pendingDeptIssueList){
			if((Integer)obj[1] == 24){
				pendingDeptIssueCS = (Integer)obj[0];
			}else if((Integer)obj[1] == 25){
				pendingDeptIssueGS = (Integer)obj[0];
			}
		}
		
	}
%>
<label>Pending PO's Central Store</label>
<label class="value"><%=pendingPoCS %></label>

<div class="clear"></div>

<label>Pending GRN Central Store</label>
<label class="value"><%=pendingGrnCS %></label>
<div class="clear"></div>

<label>Pending PO's General Store</label>
<label class="value"><%=pendingPoGS %></label>

<div class="clear"></div>

<label>Pending GRN General Store</label>
<label class="value"><%=pendingGrnGS %></label>
<div class="clear"></div>
<label>Pending Department Indent Central Store</label>
<label class="value"><%=pendingDeptIssueCS %></label>

<div class="clear"></div>

<label>Pending Department Indent General Store</label>
<label class="value"><%=pendingDeptIssueGS %></label>
<div class="clear"></div>

<%}else if(tab.equalsIgnoreCase("compbill")){ 
	List<BigDecimal> compBillList  = new ArrayList<BigDecimal>();
	List<Object[]> patientTypeBillList  = new ArrayList<Object[]>();
	if(map.get("compBillList") != null){
		compBillList = (List<BigDecimal>)map.get("compBillList");
	}
	 if(map.get("patientTypeBillList") != null){
		 patientTypeBillList = (List<Object[]>)map.get("patientTypeBillList");
	 }
	 
	 BigDecimal compBillAmount = new BigDecimal(0.00);
	 BigDecimal stfBillAmount = new BigDecimal(0.00);
	 BigDecimal stfDepBillAmount = new BigDecimal(0.00);
	 BigDecimal retBillAmount = new BigDecimal(0.00);
	 if(compBillList.size() > 0){
			 if(compBillList.get(0) != null)
		 		compBillAmount = (BigDecimal)compBillList.get(0);
	 }
	 if(patientTypeBillList.size() > 0){
		 for(Object[] obj : patientTypeBillList){
			 if(obj[1] != null){
				 if(obj[1].equals("STF")){
					 stfBillAmount = (BigDecimal)obj[0];
				 }
				 if(obj[1].equals("DEP")){
					 stfDepBillAmount = (BigDecimal)obj[0];
				 }
				 if(obj[1].equals("RET")){
					 retBillAmount = (BigDecimal)obj[0];
				 }
			 }
		 }
	 }
	%>
<label>Company Billing</label>
<label class="value"><%=compBillAmount %></label>

<div class="clear"></div>

<label>Staff Billing</label>
<label class="value"><%= stfBillAmount%></label>

<div class="clear"></div>

<label>Staff Dependent Billing</label>
<label class="value"><%= stfDepBillAmount%></label>

<div class="clear"></div>

<label>Retired</label>
<label class="value"><%=retBillAmount %></label>

<%
	}%>
