<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>




<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>';
	</script>

<form name="search" method="post" action="">
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 23 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>

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

<div class="clear"></div>
<div class="titleBg">
<h2>IP Final Bill </h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text" name="<%=HIN_NO%>" id="hinNoId"
	value="" MAXLENGTH="30"
	onblur="if(checkHin()){submitProtoAjax('search','billing?method=getAdNo&flag=billing');}" />

<div id="testDiv">
<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
 <input type="text"	name="<%=AD_NO%>" id="adNoId" value="<%=AD_NO%>" MAXLENGTH="30"
	onclick="submitForm('search','billing?method=getPatientDetailsForFinalBill','checkAdNo');" />
</div>
<div class="clear"></div>
</div>
<h4><span><%=message %></span></h4>
<div id="error"></div>
<script type="text/javascript">
function checkAdNo(){
	if(document.getElementById('adNoId').value == "" ){
		return false;
	}
	return true;
}

function checkHin(){
	if(document.getElementById('hinNoId').value == "" ){
		return false;
	}
	return true;
}
document.getElementById('hinNoId').focus();

</script><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<%
			String includedJsp ="";
			if(map.get("includedJsp") != null){
				includedJsp = (String)map.get("includedJsp");
			}
			
			if(!includedJsp.equals("")){
			%>
<jsp:include page="<%=includedJsp%>" flush="true" />
<%} %>






