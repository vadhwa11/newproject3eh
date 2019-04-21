<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.DgUom"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">
function submitProtoAjaxWithDivNameSample(formName,action,divName){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;

	//alert('::formName::-'+formName+'\n::action::-'+action+'\n::divName::-'+divName);
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	if(divName == "defaultList"){
        	document.getElementById('defaultList').style.display = 'inline';
        	}

        	new Ajax.Updater(divName,url,
			   {asynchronous:true, evalScripts:true });


	       	return true;
    }
function ValidateResult()
{

	var machineName=document.getElementById('machineName').value;
	var SampleNo=document.getElementById('SampleNo').value;

	if(machineName=="")
	{
		alert("Please Select Machine Name");
		return false;
	}
	if(SampleNo=="")
	{
		alert("Please Select Sample No.");
		return false;
	}
	return true;
}
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
<%
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null)
{
map = (Map<String,Object>) request.getAttribute("map");
}

String message="";
if(map.get("message") != null)
{
message=(String)map.get("message");

}
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
%>
<div class="titleBg">
<h2>Search Analyzer Records Details</h2></div>
<div class="clear"></div>
<h2><font id="error"><%=message %></font></h2>
<div class="clear"></div>


<form name="analyzerResultForm" method="post" action="">
<h4>Enter Details</h4>

<div class="clear"></div>
<div class="Block">

<label>Date</label>
<input type="text" id="<%=FROM_DATE%>" name="<%=FROM_DATE%>" value="<%=currentDate %>" class="date" readonly="readonly" validate="Date Of Resignation,date,no"  MAXLENGTH="30"  />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="javascript:setdate('',document.analyzerResultForm.<%=FROM_DATE%>,event)" validate="Pick a date" class="calender" />

<label> Machine Name </label>
<select id="machineName" name="<%=MACHINE_NAME%>" validate="machineName,string,no" tabindex=1 onchange="submitProtoAjaxWithDivNameSample('analyzerResultForm','lab?method=checkSampleNo&fromDate='+document.getElementById('fromDate').value+'&machineName='+this.value,'sampleNoDiv')">
<option value="">Select</option>
	<option value="kx21" >KX 21</option>
	<option value="xl300" >XL 300</option>
</select>

<label>Sample No </label>

<div id="sampleNoDiv">

     <select  id="SampleNo" name="SampleNo"   tabindex=1 >
			<option value="">Select</option>
	</select>

</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="SampleNo" id="SampleNo" value=""/>
<input type="button" name="show" value="Show" class="button"
onClick="if(ValidateResult()){submitForm('analyzerResultForm','lab?method=LabResultValidateDetails1')}" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>


<h6>Validate Analyzer Records Details</h6>
<form name="sampleForm" method="post" action="">
<div class="Clear"></div>
<div class="tableHolderAuto">

<table width="100%" id="chargeDetails" cellpadding="0"	cellspacing="0">

<div class="tableHolderAuto">

<table width="100%"  id="chargeDetails" cellpadding="0"	cellspacing="0">

	<tr>
		<th>Diagnostic No </th>
		<th>Parameter Name </th>
		<th>Measurement Value</th>
		<th>Unit </th>
		<th>Investigation Name </th>
		<th>Sub Investigation Name </th>

	</tr>
	<tr><td>		<input type="text" name="<%=DIAGNOSIS_NO%>" value="" readonly="readonly"/></td>
		<td><input type="text" name="parameterName" value="" readonly="readonly"/></td>
		<td>	<input type="text" name="<%=MEASUREMENT_VALUE %>" value="" readonly="readonly"/></td>
		<td>	<input type="text" name="unit" value="" readonly="readonly"/></td>
		<td>	<input type="text" name="invesId" value="" readonly="readonly"/></td>
           <td>   <input type="text" name="subiigationId" value="" readonly="readonly"/></td>
					        						        						        						        			
	</tr>
</table>
</div>
	<input type="button" name="validate"
	id="addbutton" value="Validate" class="button"
	onClick="submitForm('sampleForm','lab?method=addAnalyserResult')"
	accesskey="u" tabindex=1 />
	<input type="button" name="invalidate" id="addbutton" value="InValidate" class="button" accesskey="r"
	 onClick="submitForm('sampleForm','lab?method=invalidateAnalyserResult')" tabindex=1 />
   <input type="button" name="back" id="backid" value="Back" class="button" accesskey="r" onClick="submitForm('sampleForm','lab?method=showLabTestResultJsp')"  tabindex=2 />
