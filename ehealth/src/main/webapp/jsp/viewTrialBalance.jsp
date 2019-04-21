<%@page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Object[]> voucherDetailList = new ArrayList<Object[]>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	} 
	
	if(map.get("voucherDetailList")!= null){
		voucherDetailList = (List<Object[]>)map.get("voucherDetailList");
	}
	String fromDate = "";
	String toDate = "";
	String accountType = "";
	if(map.get("fromDate")!= null){
		fromDate = (String)map.get("fromDate");
	}
	if(map.get("toDate")!= null){
		toDate = (String)map.get("toDate");
	}
	if(map.get("accountType")!= null){
		accountType = (String)map.get("accountType");
	}
	
%>



<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.FaVoucherDetails"%>
<form name="viewTrialBalance" method="post" action="">
<div class="clear"></div>

<div class="paddingTop15"></div>
<h4>Trial Balance</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<div class="right">
<label><%=fromDate %><input type="hidden" name="<%=FROM_DATE %>" id="fromDate" value="<%=fromDate %>" class="calDate" tabindex=1 readonly="readonly" validate="From Date ,date,yes" MAXLENGTH="30" />
</label>
<label class="auto">To</label>
<label><%=toDate %><input type="hidden" name="<%=TO_DATE %>" id="toDate" value="<%=toDate %>" class="calDate" tabindex=1 readonly="readonly" validate="To Date ,date,yes" MAXLENGTH="30" />
</label></div>
<div class="clear"></div>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table>
	<tr>
		
		<th scope="col">Particulars</th>
		<th scope="col">Dr</th>
		<th scope="col">Cr</th>
	</tr>
	<tbody id="tableData">
	<%
	BigDecimal totalDrAmount = new BigDecimal(0.0);
	BigDecimal totalCrAmount = new BigDecimal(0.0);
	BigDecimal drGrandTotal = new BigDecimal(0.0);
	BigDecimal crGrandTotal = new BigDecimal(0.0);
		if(voucherDetailList.size()>0){
			for(Object[] voucherDetails : voucherDetailList){
				if(voucherDetails[0] != null){
				totalDrAmount = (BigDecimal)(voucherDetails[0]);
				drGrandTotal = drGrandTotal.add(totalDrAmount);
				}else{
					totalDrAmount = new BigDecimal(0.00);
					drGrandTotal = drGrandTotal.add(totalDrAmount);
				}
					
				if(voucherDetails[1] != null){
				totalCrAmount = (BigDecimal)(voucherDetails[1]);
				crGrandTotal = crGrandTotal.add(totalCrAmount);
				}else{
					totalCrAmount = new BigDecimal(0.00);
					crGrandTotal = crGrandTotal.add(totalCrAmount);
				}
		%>
	<tr>
	<%if(accountType.equalsIgnoreCase("group")){ %>
	<td onclick="displaySubGroupWiseBalance(<%=voucherDetails[2]%>);"><%=voucherDetails[3] %></td>
	<%}else if(accountType.equalsIgnoreCase("subgroup")){ %>
	<td onclick="displayAccountWiseBalance(<%=voucherDetails[2]%>);"><%=voucherDetails[3] %></td>
	<%}else{ %>
	<td><%=voucherDetails[3] %></td>
	<%} %>
	<%if(totalDrAmount!=null && !totalDrAmount.equals(new BigDecimal(0))){ %>
	<td><%=totalDrAmount %></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(totalCrAmount!=null && !totalCrAmount.equals(new BigDecimal(0))){ %>
	<td><%=totalCrAmount %></td>
<%}else{ %>
<td>--</td>
<%} %>
	</tr>
		<%}} %>
	<tr class="background">
	<td colspan="1" class="right">Grand Total</td>
	<%if(drGrandTotal!=null && !drGrandTotal.equals(new BigDecimal(0))){ %>
	<td><%=drGrandTotal %></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	<%if(crGrandTotal!=null && !crGrandTotal.equals(new BigDecimal(0))){ %>
	<td><%=crGrandTotal %></td>
	<%}else{ %>
	<td>--</td>
	<%} %>
	</tr>
	
	</tbody>

	</table>
<div class="clear"></div>
</div>
<input type="button" name="OK" id="addbutton" value="Back" class="button" onClick="submitForm('viewTrialBalance','account?method=showTrialBalanceJsp');" accesskey="a" tabindex=1 />
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);

		function displaySubGroupWiseBalance(groupId){
			submitForm('viewTrialBalance','account?method=getSubGroupWiseTrialBalance&groupId='+groupId);
		}
		function displayAccountWiseBalance(subGroupId){
			submitForm('viewTrialBalance','account?method=getAccountWiseWiseTrialBalance&subGroupId='+subGroupId);
		}
		
</script>

