<%@page import="java.util.Calendar"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Date"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hrms.masters.business.TblFreezeTimeSheet"%>
<%@page import="java.util.ArrayList"%>


<script>
<%		Calendar calendar=Calendar.getInstance();
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
<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	List<TblFreezeTimeSheet> tblFreezeTimeSheetList = new ArrayList<TblFreezeTimeSheet>();
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	String message="";
	if (map.get("message") != null) {
		message = (String) map.get("message");
		
	}
	if (map.get("tblFreezeTimeSheetList") != null) {
		tblFreezeTimeSheetList = (List<TblFreezeTimeSheet>) map.get("tblFreezeTimeSheetList");
		
	}
%>
<body onload="">
<div class="titleBg">
<h2>Freeze Time Sheet</h2>
</div>
<div class="Block">
<div class="clear"></div>

<form name="freezTimeSheet" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<label><span>*</span>Year</label> <select name="year">
	<option value="">Select Year</option>
	<%
	
	int yr=2009;
	for(int ilop=0;ilop<20;ilop++)
	{
		if((yr+ilop)== year){
	%>
	<option selected="selected" value="<%=yr+ilop %>"><%=yr+ilop %></option>
	<%}{%>
	<option value="<%=yr+ilop %>"><%=yr+ilop %></option>
	<%}
	}
	%>

</select>

<div class="clear"></div>

<div id="allMonthOfYear">
<table id="dateOfMonths" style="width: 80%">

	<!-- Table header -->

	<thead>
		<tr>
			<th scope="col" id="month" style="width: 20%">Month</th>
			<th scope="col" id="dayOfMonth" style="width: 50%;">Set Day and
			Time Of Month To Freeze</th>
		</tr>
	</thead>

	<!-- Table footer -->

	<tfoot>

	</tfoot>

	<!-- Table body -->

	<tbody>
		<%
        for(TblFreezeTimeSheet obj:tblFreezeTimeSheetList)
        {
        	%>
		<tr>

			<td>January</td>
			<td><label style="background-color: white; width: 30px;">Day</label>
			<input type="text" name="date1" id="date1" style="width: 20px"
				maxlength=2 " validate='January Date,string,yes' onblur=""
				onkeyup="setMonth(this);" value="<%=obj.getDate() %>" /> <label
				style="background-color: white; width: 60px;">Max Hrs.</label> <input
				type="text" name="time1" id="time1" style="width: 20px"
				maxlength="2" validate='January Time,string,yes' onblur=""
				onkeyup="setHrs(this);" value="<%=obj.getMaxTime() %>" /> <input
				type="button" id="reset1" class="button" onclick="preset('1')"
				value="Reset"> <input type="button" id="save1"
				class="button" value="Save"></td>
		</tr>
		<tr>
			<td>February</td>
			<td><label style="background-color: white; width: 30px;">Day</label>
			<input type="text" name="date2" id="date2" style="width: 20px"
				maxlength="2" validate='February Date,string,yes' onblur=""
				onkeyup="" value="" /> <label
				style="background-color: white; width: 60px;">Max Hrs.</label> <input
				type="text" name="time2" id="time2" style="width: 20px"
				maxlength="2" validate='February Time,string,yes' onblur=""
				onkeyup="" value="" /> <input type="button" id="reset2"
				class="button" onclick="preset('2')" value="Reset"> <input
				type="button" id="save2" class="button" value="Save"></td>
		</tr>
		<tr>
			<td>March</td>
			<td><label style="background-color: white; width: 30px;">Day</label>
			<input type="text" name="date3" id="date3" style="width: 20px"
				maxlength="2" validate='March Date,string,yes' onblur="" onkeyup=""
				value="" /> <label style="background-color: white; width: 60px;">Max
			Hrs.</label> <input type="text" name="time3" id="time3" style="width: 20px"
				maxlength="2" validate='March Time,string,yes' onblur="" onkeyup=""
				value="" /> <input type="button" id="reset3" class="button"
				onclick="preset('3')" value="Reset"> <input type="button"
				id="save3" class="button" value="Save"></td>
		</tr>
		<tr>
			<td>April</td>
			<td><label style="background-color: white; width: 30px;">Day</label>
			<input type="text" name="date4" id="date4" style="width: 20px"
				maxlength="2" validate='April Date,string,yes' onblur="" onkeyup=""
				value="" /> <label style="background-color: white; width: 60px;">Max
			Hrs.</label> <input type="text" name="time4" id="time4" style="width: 20px"
				maxlength="2" validate='April Time,string,yes' onblur="" onkeyup=""
				value="" /> <input type="button" id="reset4" class="button"
				onclick="preset('4')" value="Reset"> <input type="button"
				id="save4" class="button" value="Save"></td>
		</tr>
		<tr>
			<td>May</td>
			<td><label style="background-color: white; width: 30px;">Day</label>
			<input type="text" name="date5" id="date5" style="width: 20px"
				maxlength="2" validate='May Date,string,yes' onblur="" onkeyup=""
				value="" /> <label style="background-color: white; width: 60px;">Max
			Hrs.</label> <input type="text" name="time5" id="time5" style="width: 20px"
				maxlength="2" validate='May Time,string,yes' onblur="" onkeyup=""
				value="" /> <input type="button" id="reset5" class="button"
				onclick="preset('5')" value="Reset"> <input type="button"
				id="save5" class="button" value="Save"></td>
		</tr>
		<tr>
			<td>June</td>
			<td><label style="background-color: white; width: 30px;">Day</label>
			<input type="text" name="date6" id="date6" style="width: 20px"
				maxlength="2" validate='June Date,string,yes' onblur="" onkeyup=""
				value="" /> <label style="background-color: white; width: 60px;">Max
			Hrs.</label> <input type="text" name="time6" id="time6" style="width: 20px"
				maxlength="2" validate='June Time,string,yes' onblur="" onkeyup=""
				value="" /> <input type="button" id="reset6" class="button"
				onclick="preset('6')" value="Reset"> <input type="button"
				id="save6" class="button" value="Save"></td>
		</tr>
		<tr>
			<td>July</td>
			<td><label style="background-color: white; width: 30px;">Day</label>
			<input type="text" name="date7" id="date7" style="width: 20px"
				maxlength="2" validate='July Date,string,yes' onblur="" onkeyup=""
				value="" /> <label style="background-color: white; width: 60px;">Max
			Hrs.</label> <input type="text" name="time7" id="time7" style="width: 20px"
				maxlength="2" validate='July Time,string,yes' onblur="" onkeyup=""
				value="" /> <input type="button" id="reset7" class="button"
				onclick="preset('7')" value="Reset"> <input type="button"
				id="save7" class="button" value="Save"></td>
		</tr>
		<tr>
			<td>August</td>
			<td><label style="background-color: white; width: 30px;">Day</label>
			<input type="text" name="date8" id="date8" style="width: 20px"
				maxlength="2" validate='August Date,string,yes' onblur="" onkeyup=""
				value="" /> <label style="background-color: white; width: 60px;">Max
			Hrs.</label> <input type="text" name="time8" id="time8" style="width: 20px"
				maxlength="2" validate='August Time,string,yes' onblur="" onkeyup=""
				value="" /> <input type="button" id="reset8" class="button"
				onclick="preset('8')" value="Reset"> <input type="button"
				id="save8" class="button" value="Save"></td>
		</tr>
		<tr>
			<td>September</td>
			<td><label style="background-color: white; width: 30px;">Day</label>
			<input type="text" name="date9" id="date9" style="width: 20px"
				maxlength="2" validate='September Date,string,yes' onblur=""
				onkeyup="" value="" /> <label
				style="background-color: white; width: 60px;">Max Hrs.</label> <input
				type="text" name="time9" id="time9" style="width: 20px"
				maxlength="2" validate='September Time,string,yes' onblur=""
				onkeyup="" value="" /> <input type="button" id="reset9"
				class="button" onclick="preset('9')" value="Reset"> <input
				type="button" id="save9" class="button" value="Save"></td>
		</tr>
		<tr>
			<td>October</td>
			<td><label style="background-color: white; width: 30px;">Day</label>
			<input type="text" name="date10" id="date10" style="width: 20px"
				maxlength="2" validate='October Date,string,yes' onblur=""
				onkeyup="" value="" /> <label
				style="background-color: white; width: 60px;">Max Hrs.</label> <input
				type="text" name="time10" id="time10" style="width: 20px"
				maxlength="2" validate='October Time,string,yes' onblur=""
				onkeyup="" value="" /> <input type="button" id="reset10"
				class="button" onclick="preset('10')" value="Reset"> <input
				type="button" id="save10" class="button" value="Save"></td>
		</tr>
		<tr>
			<td>November</td>
			<td><label style="background-color: white; width: 30px;">Day</label>
			<input type="text" name="date11" id="date11" style="width: 20px"
				maxlength="2" validate='November Date,string,yes' onblur=""
				onkeyup="" value="" /> <label
				style="background-color: white; width: 60px;">Max Hrs.</label> <input
				type="text" name="time11" id="time11" style="width: 20px"
				maxlength="2" validate='November Time,string,yes' onblur=""
				onkeyup="" value="" /> <input type="button" id="reset11"
				id="reset11" class="button" onclick="preset('11')" value="Reset">
			<input type="button" id="save11" class="button" value="Save"></td>
		</tr>
		<tr>
			<td>December</td>
			<td><label style="background-color: white; width: 30px;">Day</label>
			<input type="text" name="date12" id="date12" style="width: 20px"
				maxlength="2" validate='December Date,string,yes' onblur=""
				onkeyup="" value="" /> <label
				style="background-color: white; width: 60px;">Max Hrs.</label> <input
				type="text" name="time12" id="time12" style="width: 20px"
				maxlength="2" validate='December Time,string,yes' onblur=""
				onkeyup="" value="" /> <input type="button" id="reset12"
				class="button" onclick="preset('12')" value="Reset"> <input
				type="button" id="save12" class="button" value="Save"></td>
		</tr>
		<%     }
        %>
	</tbody>
</table>
</div>
<div class="Block">
<div class="clear"></div>
</div>


<input type="button" class="buttonBig" value="Set Freeze Date"
	onclick="submitForm('freezTimeSheet','/hms/hrms/timeSheet?method=saveFreezTimeSheet');">

<div class="paddingTop40"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<div class="division"></div></form>

</div>
</body>
<script>
	
	function  setMonth(field)
	{	
		if( field !=null && field.value>0)
			{
						
				document.getElementById("date2").value=field.value;
				document.getElementById("date3").value=field.value;
				document.getElementById("date4").value=field.value;
				document.getElementById("date5").value=field.value;
				document.getElementById("date6").value=field.value;
				document.getElementById("date7").value=field.value;
				document.getElementById("date8").value=field.value;
				document.getElementById("date9").value=field.value;
				document.getElementById("date10").value=field.value;
				document.getElementById("date11").value=field.value;
				document.getElementById("date12").value=field.value;
			
			}
	}
	function  setHrs(field)
	{	
		if( field !=null && field.value>0)
			{
						
				document.getElementById("time2").value=field.value;
				document.getElementById("time3").value=field.value;
				document.getElementById("time4").value=field.value;
				document.getElementById("time5").value=field.value;
				document.getElementById("time6").value=field.value;
				document.getElementById("time7").value=field.value;
				document.getElementById("time8").value=field.value;
				document.getElementById("time9").value=field.value;
				document.getElementById("time10").value=field.value;
				document.getElementById("time11").value=field.value;
				document.getElementById("time12").value=field.value;
			
			}
	}
	
	function preset(index)
	
	
	
	{
		
		if(index>0)
		{
			document.getElementById("date"+index).value="";
			document.getElementById("time"+index).value="";
		}
	}
	</script>