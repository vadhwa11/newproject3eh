<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<%--For AutoComplete Through Ajax--%>

<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>


<script language="javascript">

var $j = jQuery.noConflict();
</script>


<script language=javascript src="/hms/jsp/js/common.js" type=text/javascript></script>
<script language=javascript src="/hms/jsp/js/hms.js"	type=text/javascript></script> 
<script language=javascript	src="/hms/jsp/js/calendar.js" type=text/javascript></script> 
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<script type="text/javascript">
function check(){
var SDate = document.bankBook.<%= FROM_DATE%>.value;
var EDate = document.bankBook.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))
if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>

<form name="voucher" method="post" action="">
<h4 id='divResult' class='success'></h4>
<div class="titleBg">
<h2>Voucher Report</h2>
</div>
<div class="Block">
<label><span>*</span> From Date</label> 
<input type="text" name="<%= FROM_DATE%>" id="from_date" value="" validate="From Date,date,yes" class="date" MAXLENGTH="30" readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.voucher.<%=FROM_DATE%>,event)" />

<label><span>*</span> To Date</label> 
<input type="text" name="<%= TO_DATE%>" id="to_date"  value="" validate="To Date,date,yes"	class="date" MAXLENGTH="30" readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="javascript:setdate('',document.voucher.<%=TO_DATE%>,event)" />

<label>Voucher Type<span>*</span></label>
<select name="voucherType" id="voucherType">
<option value="">Select</option>
<option value="JV">Journal Voucher</option>
<option value="PV">Payment Voucher</option>
<option value="SV">Sales Voucher</option>
<option value="SR">Sales Return Voucher</option>
<option value="PU">Purchase Voucher</option>
<option value="PR">Purchase Return Voucher</option>
<option value="RV">Receipt Voucher</option>
</select>

<div class="clear"></div>
	


<%-- <input type="hidden" name="reportName" value="<%=PRINT_REQUISITION_TO_STORE %>"> 
 --%>
<input type="button" class="buttonBig" value="Generate Report" onclick="submitForm('voucher','account?method=generateVoucherRpt');" /></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>

