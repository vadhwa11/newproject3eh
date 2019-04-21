<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<form name="billServicingOpSearch" method="post" onload="form.reset();">

<%
Map<String,Object> map = new HashMap<String,Object>();

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
String message = "";
if(map.get("message") != null){
	message = (String)map.get("message");
	
	}
%>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

<h4><span><%=message %></span></h4>
<div class="clear"></div>
<div class="titleBg">
<h2>Package Billing For OP</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<!-- <label>Registered</label> <input type="radio"
	name="" value="1" checked="checked" class="radioCheck"> -->
	<!-- <label>Un-Registered</label>
<input type="radio" name="" value="2" class="radioCheck"
	onclick="submitForm('billServicingOpSearch','packageBilling?method=getDetailsForPackageBilling&patientType=OP&registered=no');"> -->
<div class="clear"></div></div>
</div>
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" id="searchField" name="<%=HIN_NO %>" value="" validate="HIN,string,no"
	MAXLENGTH="30" tabindex=1 />

<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" class="button" name="save" value="Search"
	onclick="if(checkHinValue()){submitForm('billServicingOpSearch','packageBilling?method=getDetailsForPackageBilling&patientType=OP&registered=yes','checkHinValue');}"
	align="right" /> <input type="reset" class="buttonHighlight"
	value="Reset" />

<div class="clear"></div>
</div>
<div class="division"></div>
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
		if(document.getElementById('searchField').value == ""){
			alert("Please enter Hin.");
			return false;
		}else{
			return true
		}
	
	}

document.getElementById('searchField').focus();
</script>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>