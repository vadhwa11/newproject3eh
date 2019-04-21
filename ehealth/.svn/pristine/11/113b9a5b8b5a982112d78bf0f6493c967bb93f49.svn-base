<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="java.math.BigDecimal"%>

<script type="text/javascript">

	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script> 
<form name="closingFinancialYear" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();


	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}



String message = "";
	if(map.get("message") != null){
		message = (String)map.get("message");
		%>
<h4><span><%=message %></span></h4>
	<%}
%>
<div class="clear"></div>
<div class="paddingTop15"></div>

<div class="titleBg">
<h2>Closing Financial Year</h2>
</div>
<div class="clear"></div>

<input name="rb"  class="radioCheck"  type="radio" value="1"  />
<label>Transfer the Balance</label>
<div class="clear"></div>
<input name="rb"  class="radioCheck"  type="radio" value="2"   />
<label>Close The Year</label>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('closingFinancialYear','account?method=closingFinancialYear');" accesskey="a" tabindex=1 />

<div class="clear"></div>




<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>