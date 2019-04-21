<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<form name="otBillServicingOpSearch" method="post" onload="form.reset();">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<%
Map<String,Object> map = new HashMap<String,Object>();

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
String message = "";
if(map.get("message") != null){
	message = (String)map.get("message");
	
	}
%> <%
	if(map.get("inpatientList") != null){
%> <script type="text/javascript">
	alert("Patient is admitted.");
</script> <%		
	}
%>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

<h4><%=message %></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Bill Servicing(OT)</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<label style="display: none;">Registered</label>
<input type="radio" name="" value="1" checked="checked" class="radioCheck" style="display: none;">
<label style="display: none;">Un-Registered</label>
<input type="radio" name="" value="2" class="radioCheck" style="display: none;"
onclick="submitForm('billServicingOpSearch','opBilling?method=getPatientDetailsForOpBilling&registered=no');">
<div class="clear"></div></div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="paddingTop15"></div>
<div class="Block"><label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" id="searchField" name="<%=HIN_NO %>" value="" validate="HIN,string,no"
	onblur="if(this.value != ''){submitProtoAjax('otBillServicingOpSearch','ot?method=getOtOrderNoTempBillNoForBilling&registered=yes');}"
	MAXLENGTH="30" tabindex=1 />
<div id="testDiv"><label>Order No.</label> <input type="text"
	id="orderNoId" name="<%=ORDER_NO %>" value=""
	validate="Order no,string,no" MAXLENGTH="30" tabindex=1
	onblur="disableFields(this)" /> <label>Temporary Bill No.</label> <input
	type="text" id="tempBillNoId" name="tempBillNo" value=""
	validate="Temporary Bill No,string,no" MAXLENGTH="30" tabindex=1
	onblur="disableFields(this);submitForm('billServicingOpSearch','opBilling?method=getPatientDetailsForOpBilling&registered=yes','checkHinValue');" />

</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<!-- 	
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" name="save" value="Search" onclick="submitForm('billServicingOpSearch','opBilling?method=getPatientDetailsForOpBilling&registered=yes','checkHinValue');" align="right" />
<input type="reset" class="button"  value="Reset"/>
<div class="clear"></div>
<div class="division"></div>
 -->
<div class="clear"></div>

<%
	String msg = "";
	if(map.get("msg") != null){
		msg = (String)map.get("msg");
	}
%>

<h4><%=msg %></h4>
<script type="text/javascript">
	function checkHinValue(){
		if(document.getElementById('searchField').value == "" && document.getElementById('orderNoId').value == ""  && document.getElementById('tempBillNoId').value == ""){
			alert("Please enter either Reg. No. or Order No or Temporary Bill No.");
			return false;
		}else{
			return true
		}
	
	}

document.getElementById('searchField').focus();

</script></form>