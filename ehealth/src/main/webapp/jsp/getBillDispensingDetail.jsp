<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
Map<String,Object> map=new HashMap<String,Object>();
List<Object[]> ipWardConsumptionDetailList=new ArrayList<Object[]>();

if(request.getAttribute("map")!=null)
{
	map=(Map<String,Object>)request.getAttribute("map");
}
if(map.get("ipWardConsumptionDetailList")!=null)
{
	ipWardConsumptionDetailList=(List<Object[]>)map.get("ipWardConsumptionDetailList");
}
%>

<%
BigDecimal dispensingNetTotal=new BigDecimal(0.00);
BigDecimal dispensingTotal=new BigDecimal(0.00);
BigDecimal discountTotal=new BigDecimal(0.00);


	if(ipWardConsumptionDetailList.size() > 0){
%>
<h4>Dispensing Details</h4>
<div class="clear"></div>

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetailsTable">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Item Description</th>
		<th scope="col">Qty</th>
		<th scope="col">Amount</th>
	</tr>
<%
int i=1;

for(Object[] objects:ipWardConsumptionDetailList){
%>
<tr>
<td>
<%=i %>
<input type="hidden" name="<%=RequestConstants.BATCH_ITEM_ID+i %>" value="<%=objects[0] %>" />
<input type="hidden" name="<%=RequestConstants.BATCH_ID+i %>" value="<%=objects[8] %>" />
<input type="hidden" name="<%=RequestConstants.ISSUE_QUANTITY+i %>" value="<%=objects[3] %>" />
<input type="hidden" name="batchAmt<%=i %>" value="<%=objects[4] %>" />
<input type="hidden" name="batchDisPer<%=i %>" value="<%=objects[6] %>" />
<input type="hidden" name="batchDisAmt<%=i %>" value="<%=objects[7] %>" />
<input type="hidden" name="batchNetAmt<%=i %>" value="<%=objects[5] %>" />



</td>
<td>
<%=objects[2] %>
</td>
<td>
<%=objects[3] %>
</td>
<td>
<%=objects[5] %>
<%dispensingNetTotal=dispensingNetTotal.add(new BigDecimal(objects[5].toString())); %>
<%dispensingTotal=dispensingTotal.add(new BigDecimal(objects[4].toString())); %>
<%discountTotal=discountTotal.add(new BigDecimal(objects[7].toString())); %>

</td>
</tr>
<%
i++;
}
%>
</table>
<input type="hidden" name="totalDispensing" value="<%=i-1 %>" />
<input type="hidden" name="totalAmmount" value="<%=dispensingTotal %>" />
<input type="hidden" name="totalNetAmmount" value="<%=dispensingNetTotal %>" />
<input type="hidden" name="totalDisAmmount" value="<%=discountTotal %>" />

<%}	
	//totalAmt = totalAmtForCharge.add(totalAmtDispense).add(totalAmtPkg);
	%>
	
	<script type="text/javascript">
<%-- 	document.getElementById('netAmtId').value=parseFloat(document.getElementById('pastDue1').value)+parseFloat('<%=dispensingNetTotal%>');
 --%>	document.getElementById('totalAmtId').value=parseFloat(document.getElementById('totalAmtId1').value)+parseFloat('<%=dispensingNetTotal%>');
	document.getElementById('pastDue').value=parseFloat(document.getElementById('pastDue1').value)+parseFloat('<%=dispensingNetTotal%>');
	document.getElementById('netAmtHiddenId').value=parseFloat(document.getElementById('pastDue1').value)+parseFloat('<%=dispensingNetTotal%>');
	</script>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    