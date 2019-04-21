<%@ page import = "static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
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
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script>
	
	  <form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	  Map<String,Object> map = new HashMap<String,Object>();

	  if (request.getAttribute("map") != null) {
	  	map = (Map<String,Object>) request.getAttribute("map");

	  }
	  
	  String dispensingRequired = "";
	  if(map.get("dispensingRequired") != null){
		  dispensingRequired = (String)map.get("dispensingRequired");
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
<div class="clear"></div>
	  <h4><%=message %></h4>
<div class="titleBg"><h2>Payment Advice</h2></div>
<div class="Block">	 
<div id="searcharea">
<div id="searchbar">
<label>Servicing</label>
<input type="radio" id="servId" value="servicing" name="<%=BILL_TYPE%>" class="radioCheck"  checked="checked" />
</div>
</div>
</div>
<div class="Block">
<div class="clear"></div>		
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label>
<input type="text" name="<%=HIN_NO%>" id="hinNoId" value="" MAXLENGTH="30" onblur="callAjax('billNo');"/>
			
		<!--  	<div id="testDiv">
			<label>Bill No.</label>
			<input type="text" name="<%=BILL_NO%>" id="billNoId" value="" MAXLENGTH="30" onblur="callAjax('advNo');"/>
			</div> -->
			
<div id="pymtAdvDiv">
<label>Payment Advice No.</label>
<input type="text" id="paymentAdviceNo" name="<%=PAYMENT_ADVICE_NO%>" value="" 
readonly="readonly" MAXLENGTH="30" onblur="if(this.value != ''){submitForm('search','opBilling?method=getPaymentAdviceNoForAdviceRep');}"/>
</div>
		
<div class="clear"></div>
</div>

<div id="error"></div>
</form>
	
			<%
			String includedJsp ="";
			if(map.get("includedJsp") != null){
				includedJsp = (String)map.get("includedJsp");
			}
			
			if(!includedJsp.equals("")){
			%>		
			<jsp:include page="<%=includedJsp%>"  flush="true"/>
			<%} %>
		
			
<script type="text/javascript">
function checkBillNo(){
	if(document.getElementById('billNoId').value == "" ){
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

	function callAjax(parameter)
	{
 		var billType;
		if(document.getElementById('servId').checked)
		{
			billType = "servicing";
		}
		else if(document.getElementById('dispId').checked)
		{
			billType = "dispensing";
		}
		document.getElementById('paymentAdviceNo').readonly = false;	
		
		if (checkHin())
		{
			submitProtoAjaxWithDivName('search','opBilling?method=getPaymentAdviceNoForAdviceRep&<%=BILL_TYPE%>='+billType,'pymtAdvDiv');
		}
}

document.getElementById('hinNoId').focus();
	
	</script>

		
		

	
		  		 