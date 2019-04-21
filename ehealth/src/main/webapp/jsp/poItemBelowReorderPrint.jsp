<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasManufacturer"%>
<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>


<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calender.js" type="text/javascript"></script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<StorePoHeader> poNumberList = new ArrayList<StorePoHeader>();
	List<String> poList = new ArrayList<String>();
	
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	if(map.get("poList") != null)
	{
		poList = (List<String>) map.get("poList");
	}
	
	if(map.get("message") != null)
	{
		String message = (String)map.get("message");
%>
		<h4><span><%=message %></span></h4>
<%
	}
%>

<script type="text/javascript" language="javascript">
 function showReport(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=printLocalPoFormatJsp";
  obj.submit();
}
 function showReportWithStock(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/purchaseOrder?method=printLocalPoFormatJsp&withStock=true";
  obj.submit();
}

</script>

<form name="grnReport" id=grnReport method="post" action=""	target="_blank">
<div class="titleBg">
<h2>PURCHASE ORDER REPORT</h2>
</div>
<div class="clear"></div>
<%
		Iterator iterator = poList.iterator();
		while(iterator.hasNext())
		{	
			String poNo = (String) iterator.next();
%>
		
			<input type="radio" name="<%=PO_NO%>" value="<%=poNo%>" id="<%=PO_NO%>" class="radioCheck"/><label class="auto"><%=poNo%></label>
			<div class="clear"></div>
<%
	}
%>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="print" type="submit" class="button"	value="Print" onClick="showReport('grnReport');"> 
<input	type="button" name="print" type="submit" class="buttonBig2"	value="Print With Stock Details" onClick="showReportWithStock('grnReport');"> </input>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>