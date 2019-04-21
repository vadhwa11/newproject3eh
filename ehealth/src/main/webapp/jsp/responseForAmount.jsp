<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>


<%@page import="java.math.BigDecimal"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


<%	
		Map map = new HashMap();
		BigDecimal actualAmount=new BigDecimal("0");
		BigDecimal rate=new BigDecimal("0");
		BigDecimal stdDeduction = new BigDecimal(0.00);
		BigDecimal discAmt = new BigDecimal(0.00);
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("amount") != null)
			actualAmount =(BigDecimal)map.get("amount");
  	    
		if(map.get("rate") != null){
			rate = (BigDecimal)map.get("rate");
		}
		if (map.get("stdDeduction") != null) {
			stdDeduction = (BigDecimal)map.get("stdDeduction");
		}
		if (map.get("discAmt") != null) {
			discAmt =  (BigDecimal)map.get("discAmt");
		}
		
%>
<div id="amount"><label>Amount</label> <input type="text"
	name="amt" id="amt"
	value="<%=actualAmount.setScale(2,BigDecimal.ROUND_HALF_UP)%>"
	MAXLENGTH="4" class="readOnly" readonly="readonly" /> <input
	type="hidden" name="billamt" id="billamt" value="<%=rate%>"
	MAXLENGTH="4" class="readOnly" readonly="readonly" /> <input
	type="hidden" name="stdDeduction" id="stdDeduction"
	value="<%=stdDeduction%>" MAXLENGTH="4" class="readOnly"
	readonly="readonly" /> <input type="hidden" name="discAmt"
	id="discAmt" value="<%=discAmt%>" MAXLENGTH="4" class="readOnly"
	readonly="readonly" /></div>