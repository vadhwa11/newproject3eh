<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>




<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css"></link>
<br />
<div id="contentspace"><script type="text/javascript"
	language="javascript">
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
	</script> <br />
<h2 align="left" class="style1">Fatal Document Panchnama</h2>
<br />


<form name="fatalDocumentPanchnamaReport" target="_blank" method="post"
	action=""><label class="bodytextB">Service No.:</label> <input
	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""
	class="textbox_date" MAXLENGTH="30"
	onblur="getHinNo('fatalDocumentPanchnamaReport','mis?method=getHinAdNoFatalPanchanama&flag=hin')" />
<div id="hinDiv"><label class="bodytextB">HIN:</label> <input
	type="text" name="<%=HIN_NO%>" value="" class="textbox_date"
	MAXLENGTH="30" validate="HIN,,yes"
	onchange="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','mis?method=getAdmissionNoList&flag=admission','testDiv')" />
</div>
<div id="testDiv"><label class="bodytextB">IP No.:</label> <input
	type="text" id="frwSlno" name="<%=AD_NO%>" value=""
	class="textbox_date" MAXLENGTH="30" /></div>
<br />
<br />
<div style="padding-left: 15px;"><input type="button" name="OK"
	value="OK" class="button"
	onClick="submitForm('fatalDocumentPanchnamaReport','mis?method=showFatalDocumentPanchnamaReport');" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /></div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>





