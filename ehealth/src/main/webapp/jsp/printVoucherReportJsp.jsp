<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<%@page import="jkt.hms.masters.business.BudVoucherHeader"%>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<BudVoucherHeader> budVoucherHeaderList = new ArrayList<BudVoucherHeader>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	if(map.get("budVoucherHeaderList")!=null){
		budVoucherHeaderList=(List<BudVoucherHeader>)map.get("budVoucherHeaderList");
	}
%>


<form name="voucherReport" id=grnReport method="post" action=""
	target="_blank">

<div class="titleBg">
<h2>Voucher Report</h2>
</div>

<div class="clear"></div>
<div class="Block">
<label>Bill No  </label> 
<select	name="<%= MAJOR_HEAD_ID %>" tabindex=1  validate="Major Head Name,string,yes" >
<option value="0">Select</option>
<%
for (BudVoucherHeader budVoucherHeader: budVoucherHeaderList){
%>
<option value="<%=budVoucherHeader.getBillNo()%>">
<%=budVoucherHeader.getBillNo()%></option>
<%}%>
</select>
<input type="button" name="add" id="addbutton" value="print Voucher Report" class="buttonBig2" onClick="submitForm('voucherReport','budget?method=printVoucherReport');" accesskey="g" tabindex=1 />
<div class="clear"></div>
</div>
 
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>







