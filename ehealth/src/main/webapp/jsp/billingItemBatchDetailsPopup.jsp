<%@page import="java.util.*"%>


<%@page import="java.math.BigDecimal"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />


<form name="chargePopup" method="post" action="">
<h4>Charge Details</h4>
<div class="division"></div>
<div class="clear"></div>
<%
	
	Map<String,Object> map = new HashMap<String,Object>();
	List<Object[]> itemBatchList = new ArrayList<Object[]>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("itemBatchList") != null){
		itemBatchList = (List<Object[]>)map.get("itemBatchList");
	}
%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">S.No.</th>
		<th scope="col">Bill No</th>
		<th scope="col">Batch No</th>
		<th scope="col">Qty</th>
		<th scope="col">Rate</th>
	</tr>
	<%
   	    	int i=1;
   	 	BigDecimal advQty =new BigDecimal(0);
 		BigDecimal advAmt = new BigDecimal(0);
   	    	for(Object[] batchDetail : itemBatchList){
   	    		BigDecimal qty =new BigDecimal(0);
    			BigDecimal amt =new BigDecimal(0);
    			qty = (BigDecimal)batchDetail[2];
    			amt = (BigDecimal)batchDetail[3];
    			
    			if(batchDetail[4] != null){
					advQty = (BigDecimal)batchDetail[4];
					advAmt = (BigDecimal)batchDetail[5];
    			}
  				
   	    %>
	<tr>
		<td><%=i %></td>
		<td><%=batchDetail[0] %></td>
		<td><%=batchDetail[1] %></td>
		<td><%=qty.subtract(advQty) %></td>
		<td><%= amt.subtract(advAmt)%></td>
	</tr>
	<%
   	    i++;} %>
</table>
<div class="clear"></div>
<input type="button" name="close" value="Close" class="button"
	onclick="window.close();" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>