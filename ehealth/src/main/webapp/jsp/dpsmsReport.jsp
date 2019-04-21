<%@page import="java.util.Calendar"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

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
<%--<script type="text/javascript">
function submitForm(action){


			     //if(document.getElementById("serName").value==""){
                  //  alert("Please select Service Name");
                  //  return false;
                  //}

                  if(document.getElementById("fromDate").value==""){
                     alert("Please select From Date");
                     return false;
                  }
                  if(document.getElementById("toDate").value==""){
                     alert("Please select To Date");
                     return false;
                  }


			   	   var obj1 = document.getElementById('dpsmsReport');
		           obj1.action = action;
		           obj1.submit();

	}
</script>
 --%>	<form   method="post" name="dpsmsReport" id="dpsmsReport">
	<div id="formLayoutIn">
	<h4>Service Wise Messaging Report</h4>
	<h2>&nbsp;</h2>
	<div class="clear"></div>
	<label >Service Name :</label>
	<select name="serName" id="serName">
		<option value="">Select</option>
		<option value="EHR">Electronic Health Record</option>
		<option value="UN">LAB</option>
		<option value="PV">RADIO</option>
		<option value="AR">Vendor Data</option>
		<option value="MM">Procurement</option>
		<option value="MO">UHID</option>
		<option value="PH">Hospital Data</option>
		<option value="W">Doctor Details </option>
	</select>
	<label >From Date :</label>
	<input type="text"  name="fromDate" id="fromDate" value="" class="date" readonly="readonly" validate="Due date ,date,yes"  MAXLENGTH="30" />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.dpsmsReport.fromDate,event)"/>
    
	<label>To Date :</label>
	<input type="text"  name="toDate" id="toDate" value="" class="date" readonly="readonly" validate="Due date ,date,yes"  MAXLENGTH="30" />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('toDate'),event)"/>
	<input type="radio"  name="type" value="summary" checked="checked" class="radioCheck" /><label class="auto">Summary :</label>
	<input type="radio"  name="type"  value="detail" class="radioCheck" /><label  class="auto">Details :</label>
	<div class="clear"></div>
	<%--
	<input type="radio"  name="type"  value="consolidated" class="radioCheck" /><label  class="auto">Consolidated(Successful/UnSuccessful) :</label>
	<div class="clear"></div>
	<input type="radio"  name="type"  value="detailall" class="radioCheck" /><label  class="auto">Details(Successful/UnSuccessful) :</label>
	<div class="clear"></div> --%>
	<input type="button" class="button"  name="ok"  value="Print" onclick="submitForm('dpsmsReport','sms?method=printBulkReport');"/>

	</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
