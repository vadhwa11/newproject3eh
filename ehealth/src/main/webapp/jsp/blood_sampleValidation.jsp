
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.Box"%>

<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="sampleValidation" method="post" action="">
<!--main content placeholder starts here-->
<div class="titleBg">
<h2>Sample Validation</h2>
</div>
<div class="clear"></div>

<div class="clear"></div>

<!--Block Two Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label> UID </label> 
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 

 <label>Patient Name</label> 
	<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 

<label>Gender</label> 
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 

</label>

<div class="clear"></div>
<label>IP Number</label> 
	<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 
 
 
<label>Blood Group</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 

<label>Mobile Number</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 
<div class="clear"></div>
<label>Unit</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 
	<label>Ward</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 	

<label>Bed Number</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 
<div class="clear"></div>
<label>Doctor Name</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>	
<h4>Request Details</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>		
<label>Request Id Number</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 	

<label>Request Date</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 

<label>Request By</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 
<div class="clear"></div>
	
<label>Component Requested</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 

<label>Quantity Request</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 
	
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
		<h4>Sample Details</h4>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>

<label>Sample Validation Date</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 

<label>Sample Validation Time</label>
<input id="donationNoId"
	type="text" name="" value=""
	title="Blood Donation No." tabindex=1 /> 


  <label class="noWidth">
  Validated By<span>*</span></label> <select id="collectedBy" name=""
	validate="Validated By,string,yes" tabindex=1>
	<option value="0">Select</option>	
</select> 

<div class="clear"></div>
<label class="noWidth">
  Blood Group Validated</label> <select id="collectedBy" name=""
	validate="Validated By,string,yes" tabindex=1>
	<option value="0">Select</option>	
</select> 

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			 <th>Sr No</th>
			<th>Component Name</th>
			<th>Quantity (ml)</th>
			<th>Required On Date</th>
			<th>Accepted</th>
			<th>Rejected</th>
			<!-- <th><span>*</span>Result</th> -->
		</tr>
	</thead>
	<tbody>
		<%--  <%
 
    	int temp=0;
    	int inc = 0;    	
    	for(inc=1;inc<=2;inc++){
%>  --%>
		<tr>
			
			 <td><input type="text" size="2" value="1"
				name="" readonly="readonly" /> 
				<input type="hidden"
				id="investigationId" name=""
				value="" />
				</td>
			
			<td>
			
			<input type="text" size="20" id="investigationName"
				name="" value=""
				onblur="" />
			</td>
			<td>
			<input type="text" size="20" id="investigationName"
				name="" value=""
				onblur="" />
			</td>
			<td>
			<input
	type="text" class="date" id="testDate" name="<%=TEST_DATE %>"
	value="" validate="Test Date,date,yes" MAXLENGTH="10"
	onblur="validateRequiredDate();" /> 
	<img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	onClick="" onblur="validateRequiredDate();" />
			</td>
			<td>
			<input type="radio" name="" class="radioCheck" checked="checked" tabindex=1 />
			</td>
			<td>
			<input type="radio" name="" class="radioCheck"
	tabindex=1 />
			</td>
			
			
			
		</tr>
		
	</tbody>
</table>


<input type="hidden" name="" value="" />
<input type="hidden" name=""
	value="" /> <input
	type="hidden" name=""
	value="" />
	
	<div class="clear"></div>
	<div class="clear"></div>
	<div class="clear"></div>
	
	<label class="common">Reason</label> 
	<textarea style="height:100px; width: 400px;" >
</textarea>
	<div class="clear"></div>
	<div class="clear"></div>
<input type="button" class="button" value="Submit"
	onclick="if(checkFilledRow())submitForm('testEntry','bloodBank?method=submitBloodTestEntry');"
	align="right" /> 
	
	<input type="reset" class="button" name="Reset"
	id="reset" value="Reset" onclick="resetClicked('testEntry');"
	accesskey="r" />
	</div>
<div class="clear"></div>
<div class="paddingTop40"></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<!--main content placeholder ends here-->

<script type="text/javascript">
   history.forward();
</script>
<script type="text/javascript">

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