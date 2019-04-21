<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script>
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;

	if(errorMsg==""){
		alert("Please enter Reg No...!");
		return false
	}else{
		return true
	}
}

</script>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");

	}
	String flag = "";
	String url1 = "";
	String url2 = "";
	String label = "";
	if(map.get("flag") != null){
		flag = (String)map.get("flag");
	}
	if(flag.equals("chargeSlip")){
		url1 = "billing?method=getAdNo&flag=cancelChargeSlip";
		url2 = "billing?method=searchChargeSlipForCancellation";
		label = "Charge Slip Cancellation";
	}else if(flag.equals("dispensingBill")){
		url1 = "billing?method=getAdNo&flag=cancelDispensingBill";
		url2 = "billing?method=searchBillForCancellation";
		label = "IP Dispensing Bill Cancellation";
	}

%>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

<!--Block One Starts-->
<form name="searchChargeSlipCancel" action="" method="post">

<div class="clear"></div>
<div class="titleBg">
<h2><%=label %></h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar"><label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" id="hinNoId" name="<%=HIN_NO %>" value="" MAXLENGTH="50"
	onblur="if(checkHin()){submitProtoAjax('searchChargeSlipCancel','<%=url1 %>');}" />

<div id="testDiv"><label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label>
<input type="text" name="<%=AD_NO%>" id="adNoId" value="" MAXLENGTH="30"
	onblur="submitProtoAjaxWithDivName('searchChargeSlipCancel','<%=url2 %>','chargeSlipDiv');" />
</div>
<div class="clear"></div>
</div>
</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div id="chargeSlipDiv"></div>
<div id="detailsDiv"></div>
<script type="text/javascript">
function checkHin(){
	if(document.getElementById('hinNoId').value == "" ){
		return false;
	}
	return true;
}
document.getElementById('hinNoId').focus();




function checkAllRow(chk)
{
for (var i=0;i < document.searchChargeSlipCancel.elements.length;i++)
	{
		var e = document.searchChargeSlipCancel.elements[i];

		if (e.type == "checkbox")
		{
			e.checked = chk.checked;
		}
	}
}
</script>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

