<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<% 
	Map<String,Object> map = new HashMap<String,Object>();
	String url="";
	String url1="";
	String bagNo="";
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}	
%>
<div class="titleBg">
<h2>Actual Stock Report</h2>
</div>
<form name="bagBarCode" method="post">
<div class="Block">
<label>Bag No.<span>*</span></label>
<input type="text" name="bagNo" value="" validate="Bag No,string,yes"/>
<div class="clear"></div>
<input type="button" class="button" name="Print Barcode" id="reset" value="Print Barcode"
	onclick="submitForm('bagBarCode','/hms/hms/bloodBank?method=printBarcode');" accesskey="r" tabindex=1 />	
</div>		
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
