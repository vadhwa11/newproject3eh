<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ListIterator"%>

<%@page import="jkt.hrms.util.LeaveManagementUtil"%>  

<%@page import="java.util.ArrayList"%>

<%
    Map<String,Object> map=(Map)request.getAttribute("map");
	
	List<HrMasLeave> leaveTypeList =new ArrayList<HrMasLeave>();
	List<HrMasLeaveTypeNew> masLeaveTypeList =new ArrayList<HrMasLeaveTypeNew>();
	List<HrMasLeaveTypeNew> leaveTypeForEdit =new ArrayList<HrMasLeaveTypeNew>();
	List<Object[]> minDateList =new ArrayList<Object[]>();
	
	HrMasLeaveTypeNew masLeaveType = new HrMasLeaveTypeNew();
	int leaveId = 0;
	
	String message = "";
	

	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("leaveTypeList")!= null){
		leaveTypeList = (List)map.get("leaveTypeList");
	}
	if(map.get("masLeaveTypeList")!= null){
		masLeaveTypeList = (List)map.get("masLeaveTypeList");
	}

//	if(map.get("minDateList")!= null){
//		minDateList = (List)map.get("minDateList");
//		Object[] hh= minDateList.get(0);
//	}

	if(map.get("leaveTypeForEdit")!= null){
		leaveTypeForEdit = (List)map.get("leaveTypeForEdit");
		
		if(leaveTypeForEdit.size()>0){
			masLeaveType = leaveTypeForEdit.get(0);
			leaveId = masLeaveType.getId();
		}
	}

	if(map.get("message")!= null){
		message = (String)map.get("message");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");

	
%>
<%@page import="jkt.hrms.masters.business.HrMasLeaveType"%>
<%@page import="jkt.hrms.masters.business.HrMasLeave"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasLeaveTypeNew"%>
<script type="text/javascript">
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

function checkEncashmentDetails(){
<%-- 	if(document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT_CHECK%>.checked){ --%>
	if(typeof document.<%=LEAVE_TYPE_FORM%>.bufferRequired != 'undefined' && typeof document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%> != 'undefined'){ // added by amit das on 26-10-2016
		if(document.<%=LEAVE_TYPE_FORM%>.bufferRequired.value=="" && document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.value=="")
		{
			alert("Either enter Encashable Percentage or Buffer Required ");
			return false;
		}
	}
		else
		{
		 	return true;
		}
		
	//	if(document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.value==""){
	//		alert("Encashment Percentage can't be blank ");
	//		return false;
	//	}
	//}
	return true;
}

function showLeaveBalance(idvalue){

		if(idvalue == 8 ){
			
			document.<%=LEAVE_TYPE_FORM%>.<%=ALLOWED_DAYS%>.value = '0';
			var a= document.getElementById('allowedDaysToHide');	
			a.setAttribute("validate","");
	    	document.getElementById('divLeaveWithoutPay').style.display ='none';
			
		}
		else{
	    	document.getElementById('divLeaveWithoutPay').style.display ='block';
	    	document.<%=LEAVE_TYPE_FORM%>.<%=ALLOWED_DAYS%>.value = '';
			var a= document.getElementById('allowedDaysToHide');	
			a.setAttribute("validate","Allowed Days,num,yes");
	    	
		}
}

function selectEnchashablePerc(){

	if(document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT_CHECK%>.checked){
		document.getElementById("divEnchashment").style.display ='block';
	}
	else{
		document.getElementById("divEnchashment").style.display ='none';
	}
	
}
var urlForSubmit = '';

function setUrl(){
	fromDate = document.<%=LEAVE_TYPE_FORM%>.<%=FROM_DATE%>.value;
	
	//fromDate = new Date(sdate.substring(6),(sdate.substring(3,5) - 1) ,sdate.substring(0,2));
	currentDate = new Date();
	 if(fromDate<=currentDate){
	 	urlForSubmit = 'leave?method=updateTypeMaster&leaveTypeId=<%=masLeaveType.getId()%>';
	 	
	 	alert("fromdate eq current date :"+urlForSubmit);	 
	 }
	 else{
	 	alert("else");
	 }
}
</script>
<%
		if(message!= null){
	%>
<h4><%=message %></h4>
<%} %>
<form name="<%=LEAVE_TYPE_FORM%>" method="post" action="">
<div class="titleBg">
<h2>Leave type Master</h2>
</div>
<div class="Block">
<label><span>*</span> Leave Type</label> <select name="<%=TYPE%>"
	validate="Leave Type,nothing,yes"
	onkeyup="showLeaveBalance(this.value);"
	onchange="showLeaveBalance(this.value);">
	<option value="">Select</option>
	<%
			for(HrMasLeave hrMasLeave:leaveTypeList)
			{
				
		%>
	<option value="<%= hrMasLeave.getId() %>"><%=hrMasLeave.getDescription()%></option>

	<%} %>
</select> <script type="text/javascript">
			<% if(leaveTypeForEdit.size()>0){ %> 
          		  document.<%=LEAVE_TYPE_FORM%>.<%=TYPE%>.value='<%=masLeaveType.getLeaveType().getId()%>';
          		  document.<%=LEAVE_TYPE_FORM%>.<%=TYPE%>.disabled='disabled';
 			<% } %> 
		</script> <!-- opening div for leave without pay -->
		 <label>Half Day Not Allowed</label> 
		 <%if(masLeaveType.getHalfDayAllow()!=null && masLeaveType.getHalfDayAllow().equals("y")) {%>
<input type="checkbox" name="halfDayAllow" value="y" onclick=""
	class="radioCheck" checked="checked" /> <%}else{ %> <input
	type="checkbox" name="halfDayAllow" value="y" onclick=""
	class="radioCheck" /> <%} %>
<div id="divLeaveWithoutPay" style="display: block">

<label class="auto">Yearly</label>
<div><input type="radio" name="<%=MONTHLY_OR_YEARLY%>" value="yearly" class="radioCheck"/>
 <label class="auto">Monthly</label>
 
<input type="radio" name="<%=MONTHLY_OR_YEARLY%>" value="monthly" class="radioCheck"/>
	
<script type="text/javascript">
 				 document.<%=LEAVE_TYPE_FORM%>.<%=MONTHLY_OR_YEARLY%>[0].checked= true;
		</script> 
		<script type="text/javascript">
			<% if(leaveTypeForEdit.size()>0 && masLeaveType.getMonthlyOrYearly().equals("m")){ %> 
          		  document.<%=LEAVE_TYPE_FORM%>.<%=MONTHLY_OR_YEARLY%>[1].checked= true;
 			<% }else { %>
 				  document.<%=LEAVE_TYPE_FORM%>.<%=MONTHLY_OR_YEARLY%>[0].checked= true;
 			<% }%> 
		</script>
<div class="clear"></div>

<label><span>*</span> Allowed Days</label> <input type="text"
	id="allowedDaysToHide" name="<%=ALLOWED_DAYS%>" maxlength="2"
	validate="Allowed Days,num,yes"
	value="" /> <script type="text/javascript">
			<% if(leaveTypeForEdit.size()>0){ %> 
          		  document.<%=LEAVE_TYPE_FORM%>.<%=ALLOWED_DAYS%>.value='<%=masLeaveType.getAllowedDays()%>';
 			<% } %> 
		</script> <script type="text/javascript">
			<% if((leaveTypeForEdit.size()>0) && (masLeaveType.getLeaveType().getId()== 8) ){ %> 
					
					document.getElementById("divLeaveWithoutPay").style.display ='none'; 
					document.<%=LEAVE_TYPE_FORM%>.<%=ALLOWED_DAYS%>.value = '0'; 
					document.<%=LEAVE_TYPE_FORM%>.<%=ALLOWED_DAYS%>.value = '0';
					a= document.getElementById('allowedDaysToHide');	
					a.setAttribute("validate","");
      		  		
 			<% }else { %>
 				  document.getElementById("divLeaveWithoutPay").style.display ='block';
 			<% }%> 
		</script>


<%-- <label>Encashable Leave</label> 
<input type="checkbox"	name="<%=ENCHASHMENT_CHECK %>" value="y"	onclick="selectEnchashablePerc();" class="radioCheck" />

<div id="divEnchashment" style="display: none;">
<input	type="radio" name="leaveEncash" value="per" class="radioCheck"	onclick="disableOther(this,'p');" checked="checked" /> 
<label class="noWidth" style="margin-left: -170px;">
<span>*</span> Encashable Percentage</label> 
<input	type="text" style="width: 25px; height: 15px" maxlength="3"	name="<%=ENCHASHMENT%>" onkeyup="return chkValue(this);" value="" />
<label class=smallAuto>%</label> <input type="radio"	name="leaveEncash" value="buf" class="radioCheck"	onclick="disableOther(this,'b');" />

<label class="noWidth" style="margin-left: -170px;">

<label ><span>*</span>Buffer Required </label> <input type="text" disabled="disabled" maxlength="3" style="width: 25px; height: 15px; margin-right: -30px;" name="bufferRequired">
</div> --%>
 
<script type="text/javascript">
	 		<% if(leaveTypeForEdit.size()>0 && (masLeaveType.getEncashable().equals("y"))){ %> 
          		  <%-- document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT_CHECK%>.checked=true; --%>
          		  document.getElementById("divEnchashment").style.display ='block';
          		  <%if(masLeaveType.getEncashablePercent()!=null && masLeaveType.getEncashablePercent()!=0){%>
          		  document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.value='<%=masLeaveType.getEncashablePercent()%>';
          		  document.<%=LEAVE_TYPE_FORM%>.bufferRequired.disabled=true;
          		  document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.disabled=false;
          		  document.<%=LEAVE_TYPE_FORM%>.leaveEncash[0].checked=true;
          		 <% }else if(masLeaveType.getBufferRequired()!=null && masLeaveType.getBufferRequired()!=0){%>
          		 document.<%=LEAVE_TYPE_FORM%>.bufferRequired.value='<%=masLeaveType.getBufferRequired()%>';
          		 document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.disabled=true;
          		 document.<%=LEAVE_TYPE_FORM%>.bufferRequired.disabled=false;
          		 document.<%=LEAVE_TYPE_FORM%>.leaveEncash[1].checked=true;
          	<% }} %>
 			
		</script> <script type="text/javascript">
	function chkValue(field)
	{
	if(field.value>100)
	{
	alert("Can't more than 100%");
	field.value="";
	return false;
	}
	}
	function disableOther(field,opt)
	{
		if(opt=='p')
		{
			document.<%=LEAVE_TYPE_FORM%>.bufferRequired.value="";
			document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.value="";
			document.<%=LEAVE_TYPE_FORM%>.bufferRequired.disabled=true;
			document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.disabled=false;
		}
		if(opt=='b')
		{
			document.<%=LEAVE_TYPE_FORM%>.bufferRequired.value="";
			document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.value="";
			document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.disabled=true;
			document.<%=LEAVE_TYPE_FORM%>.bufferRequired.disabled=false;
		}
	}
	function chkPercentage()
	{
		if(typeof document.<%=LEAVE_TYPE_FORM%>.bufferRequired != 'undefined' && typeof document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%> != 'undefined'){ // added by amit das on 26-10-2016
		if(document.<%=LEAVE_TYPE_FORM%>.bufferRequired.value=="" && document.<%=LEAVE_TYPE_FORM%>.<%=ENCHASHMENT%>.value=="")
			{
				alert("Either enter Encashable Percentage or Buffer Required ");
				return false;
			}
		}
		else
		{
		 	return true;
		}
		
	}
	</script>

<!-- <div class="clear"></div> -->

<label>Carry Forward</label> <input type="checkbox"
	name="<%=CARRY_FORWARD%>" value="y" /> <script
	type="text/javascript">
			<% if(leaveTypeForEdit.size()>0 && (masLeaveType.getCrFrdable().equals("y"))){ %> 
          		  document.<%=LEAVE_TYPE_FORM%>.<%=CARRY_FORWARD%>.checked=true;
  			<% } %>
		</script> <!-- closing div for leave without pay div --></div>


<label>Recommend </label>
 <input type="checkbox"	name="<%=RECOMENDED%>" value="r" class="inputRadiobutton" /> <script
	type="text/javascript">
			<% if(leaveTypeForEdit.size()>0 && (masLeaveType.getRecommendApprove().equals("r"))){ %> 
          		  document.<%=LEAVE_TYPE_FORM%>.<%=RECOMENDED%>.checked=true;
  			<% } %>
		</script>

<div class="clear"></div>

<label><span>*</span>Applied From Date</label> <input
	name="<%=FROM_DATE%>" type="text" readonly
	validate='From Date,date,yes' value="" class="date" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	id="calFromDate"
	onclick="javascript:setdate('',document.<%=LEAVE_TYPE_FORM%>.<%=FROM_DATE%>,'event')" />
<script type="text/javascript">
  		<% if(leaveTypeForEdit.size()>0){   %> 
        	document.<%=LEAVE_TYPE_FORM%>.<%=FROM_DATE%>.value='<%=HMSUtil.changeDateToddMMyyyy(masLeaveType.getValidFromDate())%>';
          		  
 		<% } %>
		</script> <label>Remarks</label> <% if(leaveTypeForEdit.size()>0 && masLeaveType.getRemarks()!=null){   %>
<textarea id="remarks" name="<%=REMARKS%>" class="textareaMediua"
	onkeydown="refreshLengthWithoutMeter1(this.id,45)"
	onkeyup="refreshLengthWithoutMeter(this.id,45)">
<%=masLeaveType.getRemarks()%>
</textarea> <% }else{ %> <textarea id="remarks" name="<%=REMARKS%>"
	onkeydown="refreshLengthWithoutMeter1(this.id,45)" class="textareaMediua" 
	onkeyup="refreshLengthWithoutMeter(this.id,45)">
</textarea> <%} %>
<div class="clear"></div>
</div>

<% if(leaveTypeForEdit.size()>0){   %> <%if(masLeaveType.getStatus().equals("y")) {%>
<input type="button" name="inactivate" value="InActivate" class="button"
	onclick="submitForm('<%=LEAVE_TYPE_FORM%>','leave?method=activateInActivateTypeMaster&leaveTypeIdBaseMas=<%=masLeaveType.getLeaveType().getId()%>&leaveTypeId=<%=masLeaveType.getId()%>');" />
<%}else{ %> <input type="button" name="activate" value="Activate"
	class="button"
	onclick="submitForm('<%=LEAVE_TYPE_FORM%>','leave?method=activateInActivateTypeMaster&leaveTypeIdBaseMas=<%=masLeaveType.getLeaveType().getId()%>&leaveTypeId=<%=masLeaveType.getId()%>');" />
<%} %> <input type="button" name="apply" value="Update" class="button"
	onclick="submitForm('<%=LEAVE_TYPE_FORM%>','leave?method=updateTypeMaster&leaveTypeIdBaseMas=<%=masLeaveType.getLeaveType().getId()%>&leaveTypeId=<%=masLeaveType.getId()%>','checkEncashmentDetails');" />

<%} else { %> <input type="button" name="apply" value="Add" class="button"
	onclick="submitForm('<%=LEAVE_TYPE_FORM%>','leave?method=submitTypeMaster');" />

<%} %> <input type="button" name="reset" value="Reset"
	class="buttonHighlight"
	onclick="location.href='leave?method=showLeaveTypeMaster'" />
<div class="clear"></div>
<div class="paddingTop5"></div>
<h4>Leave Types</h4>
<% 
	if(masLeaveTypeList!=null && masLeaveTypeList.size() > 0)
	{		
%>
<div id="pageNavPosition"></div>
<table id="leaveTypeList">
	<tr>
		<th>Leave Type</th>
		<th>Allowed Days</th>
		<th>Applied From Date</th>
		<th>Carry Forward</th>
		<th>Recommend/Approve</th>
		<th>Monthly/Yearly</th>
		<th>Status</th>
	</tr>
	<tbody id="tableData">
		<%	
			int i=1;
			for(HrMasLeaveTypeNew hrMasLeaveType:masLeaveTypeList)
			{
				if(i%2==0)
				{
		%>
		<tr class="odd"
			onclick="location.href='leave?method=showLeaveTypeMaster&leaveTypeId=<%=hrMasLeaveType.getId()%>'">
			<%
		  		}
		  		else
		  		{
		%>

			<tr class="even"
				onclick="location.href='leave?method=showLeaveTypeMaster&leaveTypeId=<%=hrMasLeaveType.getId()%>'">
				<%
		  		}
		%>
				<td><%=hrMasLeaveType.getLeaveType().getDescription() %></td>
				<%
						if(hrMasLeaveType.getLeaveType().getId() == 8){
						%>
				<td>---------</td>
				<%	}else{	%>
				<td><%=hrMasLeaveType.getAllowedDays() %></td>
				<% }%>


				<td><%=LeaveManagementUtil.convertDateToStringWithoutTime(hrMasLeaveType.getValidFromDate())%></td>

				<%
					if(hrMasLeaveType.getLeaveType().getId()!=8){
						%>
				<%if(hrMasLeaveType.getCrFrdable().equals("y")) {%>
				<td>Carry Forward</td>
				<%}else { %>
				<td>Not Carry Forward</td>
				<%} 
					}else{%>
				<td>---------</td>
				<%} %>




				<%
					if(hrMasLeaveType.getLeaveType().getId()!=8){
						%>
				<%if(true) {//hrMasLeaveType.getRecommendApprove().equals("r")%>
				<td>Recommend</td>
				<%}else { %>
				<td>Approve</td>
				<%} 
					}else{%>
				<td>---------</td>
				<%} %>
				<%
					if(hrMasLeaveType.getLeaveType().getId()!=8){
						%>
				<%if(hrMasLeaveType.getMonthlyOrYearly().equals("y")) {%>
				<td>Yearly</td>
				<%}else{ %>
				<td>Monthly</td>
				<%} 
					}else{%>
				<td>---------</td>
				<%} %>

				<%if(hrMasLeaveType.getStatus().equals("y")){ %>
				<td>Active</td>
				<%}else { %>
				<td>InActive</td>
				<%} %>
			</tr>
			<%	
			i++;
		   }
		   }
			else
			{  %>
			<h4>No Leave Record for current period</h4>
			<%	}	%>
		
	</tbody>
</table>
<div class="clear"></div>


<script>
		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
</script>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</div>
</form>
<div class="clear"></div>


