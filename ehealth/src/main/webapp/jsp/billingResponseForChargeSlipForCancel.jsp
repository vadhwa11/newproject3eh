<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.BlChargeSlipMain"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.BlChargeSlipDetail"%><link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />


<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<BlChargeSlipMain> chargeSlipList = new ArrayList<BlChargeSlipMain>();

	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}

	if(map.get("chargeSlipList") != null){
		chargeSlipList = (List<BlChargeSlipMain>)map.get("chargeSlipList");
	}
	if(chargeSlipList.size() > 0){

%>

<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col"></th>
		<th scope="col">Charge Slip No</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Charge Slip Amount</th>
		<th scope="col">Receipt Amount</th>
		<th scope="col">Outstanding Amount</th>
		<th scope="col">Charge Slip Date</th>
	</tr>
	<%
   		 for(BlChargeSlipMain blChargeSlipMain : chargeSlipList){
   			 boolean canceled = true;
   			 if(blChargeSlipMain.getBlChargeSlipDetails() != null){
				for(BlChargeSlipDetail chargeSlipDt : blChargeSlipMain.getBlChargeSlipDetails()){
					if(chargeSlipDt.getStatus().equals("y")){
						canceled = false;
						break;
					}
				}
   			 }
   			 if(canceled== false)
   			 {
   				 String pName = blChargeSlipMain.getHin().getPFirstName();
   				 if(blChargeSlipMain.getHin().getPMiddleName() != null)
   				 {
   					pName = pName.concat(" ").concat(blChargeSlipMain.getHin().getPMiddleName());
   				 }
   				 if(blChargeSlipMain.getHin().getPLastName() != null)
   				 {
   					pName = pName.concat(" ").concat(blChargeSlipMain.getHin().getPLastName());
   				 }
   	    %>
	<tr>
		<td><input type="radio" name="<%=CHARGE_SLIP_ID %>" onclick="submitProtoAjaxWithDivName('searchChargeSlipCancel','billing?method=getChargeSlipDetails&chargeSlipId=<%=blChargeSlipMain.getId() %>','detailsDiv');"	value="<%=blChargeSlipMain.getId() %>"/></td>
		<td><%=blChargeSlipMain.getChargeSlipNo() %></td>
		<td><%=pName %></td>
		<td><%=blChargeSlipMain.getChgSlpAmt() %></td>
		<%
			if(blChargeSlipMain.getReceiptAmt() != null){
		%>
		<td><%=blChargeSlipMain.getReceiptAmt() %></td>
		<%}else{ %>
		<td>0.00</td>
		<%} %>
		<td><%=blChargeSlipMain.getOsAmt()!=null ? blChargeSlipMain.getOsAmt():"" %></td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(blChargeSlipMain.getChgSlpDate()) %></td>
	</tr>
	<%} %>
	<%} %>
</table>
<div class="clear"></div>

<div class="clear"></div>
<%}else{ %>
<div class="clear"></div>
<h4><span>No Record found!</span></h4>
<div class="clear"></div>
<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
