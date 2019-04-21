<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

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

<div class="titleBig"><h2>Inspections Detail</h2></div>
<form name="inspectionDetail">
	<div class="Block">
		<label>Work Order Type</label>
		<select><option>Select</option></select>
		<label><a href="#">View Document</a></label>
		<div class="clear"></div>
		
		<label>Planned Start Date</label> 
 	    <input id="mlcDateId" class="date" type="text" maxlength="30" readonly="readonly" value="18/03/2015" name="fromDate">
	    <img width="16" height="16" border="0" onclick="javascript:setdate('',document.inspectionDetail.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
	    <label>Planned End Date</label>
	    <input id="mlcDateId" class="date" type="text" maxlength="30" readonly="readonly" value="18/03/2015" name="toDate">
	    <img width="16" height="16" border="0" onclick="javascript:setdate('',document.inspectionDetail.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
	    <label>Total Duration</label> <input type="text"	name="" value="" MAXLENGTH="30" id="adNo" />
	    <div class="clear"></div>
		
		<label>Planned Cost</label>
		<input type="text" readonly="readonly" />
		<label>Cost Center/Project Code</label>
		<input type="text" readonly="readonly" />
		<label>Account Code</label>
		<input type="text" readonly="readonly" />
		
		<label>Description Of Work</label>
		<textarea rows="4" cols="25"></textarea>
		<label>Resource Requirement</label>
		<textarea rows="4" cols="25"></textarea>
		<label>Remark</label>
		<textarea rows="4" cols="25"></textarea>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<label>Safety Procedure Materials</label>
		<table style="width: 80%">
			<tr><th></th><th>Item Code</th><th>Item Name</th><th>Qty</th></tr>
			<tr><td><input type="checkbox" /></td><td></td><td></td><td></td></tr>
		</table>
	</div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>