<%@page import="jkt.hms.masters.business.AccountMainTransac"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.AccountMainTransac"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.FaVoucherDetails"%>
<script type="text/javascript" src="/erp/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.datePicker.js"></script>
<script type="text/javascript" src="/erp/jsp/js/jquery.common.js"></script>
<script language="javascript">
var $j = jQuery.noConflict();
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	List<AccountMainTransac> accountBalanceList = new ArrayList<AccountMainTransac>();
	List<FaVoucherDetails> voucherDtList = new ArrayList<FaVoucherDetails>();
	if(map.get("accountBalanceList") != null){
		accountBalanceList = (List<AccountMainTransac>)map.get("accountBalanceList");
	}
	if(map.get("voucherHeaderList") != null){
		voucherDtList = (List<FaVoucherDetails>)map.get("voucherHeaderList");
	}
	System.out.println("voucherDtList==ujjwal="+voucherDtList.size());
%>
<%for(FaVoucherDetails d:voucherDtList){%>
<input type="text" value="<%=d.getDrAmount()%>"  />
<%}%>