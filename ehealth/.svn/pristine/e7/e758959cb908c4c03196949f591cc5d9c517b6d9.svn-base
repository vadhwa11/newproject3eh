<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasItaxSecInvestment"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hrms.masters.business.HrMasFinancialYear"%>

<script>
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
<%
Map map = new HashMap();
List<MasEmployee> masEmployeeList = new ArrayList<MasEmployee>();
List<HrMasItaxSecInvestment> hrMasItaxSecInvestmentList = new ArrayList<HrMasItaxSecInvestment>();
List<HrMasFinancialYear> financialYearList = new ArrayList<HrMasFinancialYear>();
if(request.getAttribute("map")!=null)
{
	map= (Map)request.getAttribute("map");
}
if(map.get("masEmployeeList")!= null){
	masEmployeeList = (List)map.get("masEmployeeList");
}
if(map.get("hrMasItaxSecInvestmentList")!= null){
	hrMasItaxSecInvestmentList = (List)map.get("hrMasItaxSecInvestmentList");
}
if(map.get("financialYearList")!= null){
	financialYearList = (List<HrMasFinancialYear>)map.get("financialYearList");
}
String userName = "";
if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
}
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String sdate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
%>
<div class="titleBg">
<h2>Employee Investment</h2>
</div>

<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<form name="employeeInvestment" method="post">
<%if(masEmployeeList!=null && masEmployeeList.size() > 0)
	{
		
%>
<div id="pageNavPosition"></div>
<div class="clear"></div>
<table id="employeeList">
	<tr>
		<th>Employee Code</th>
		<th>Employee Name</th>
		<th>Date Of Join</th>
		<th>Status</th>
	</tr>
	<tbody id="tableData">
		<%int i=1;
		      for(MasEmployee obj : masEmployeeList){
			  if(i%2==0)
		   		{%>
		<tr class="odd"
			onclick="populateEmpInfo('<%=obj.getId() %>','<%=obj.getEmployeeCode() %>','<%=obj.getFirstName() %>','<%=obj.getLastName()%>');">
			<%}else{%>

			<tr class="even"
				onclick="populateEmpInfo('<%=obj.getId() %>','<%=obj.getEmployeeCode() %>','<%=obj.getFirstName() %>','<%=obj.getLastName()%>');">
				<%} %>
				<td><%=obj.getEmployeeCode() %></td>
				<td><%=(obj.getFirstName()!=null?obj.getFirstName():"")+" "+ (obj.getMiddleName()!=null?obj.getMiddleName():"")+" "+ (obj.getLastName()!=null?obj.getLastName():"")%></td>
				<td><%=HMSUtil.convertDateToStringWithoutTime(obj.getJoinDate())%></td>
				<td><%=obj.getStatus() %></td>
			</tr>
			<%i++;}%>

			<%	}else{ %>
			<h4><span>No Record Found</span></h4>

			<%} %>
		
	</tbody>

</table>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div id="labelsDiv" style="display: none;"><input name="empid"
	id="empid" type="hidden" value=""><label>Employee Code</label>
<label id="Ecode"> </label> <label>Emplyee Name</label> <label
	id="Ename"> </label> <label>Year</label> <select id="invYear"
	name="invYear">
	<%
		      for(HrMasFinancialYear obj : financialYearList)
			 
		   		{%>
	<option value="<%=obj.getId() %>"><%=obj.getYearDescription() %></option>
	<%} %>
</select></div>




<table id="secInvestList" width="100%">
	<tr>
		<th>Section</th>
		<th>Investment</th>
		<th>Amount</th>
		<th>Investment Date</th>
		<th>Max. Amount</th>
	</tr>
	<tbody id="tableData12">
		<%int i=1;
			if(hrMasItaxSecInvestmentList!=null && hrMasItaxSecInvestmentList.size()>0)
			{
				%>
		<input type="hidden" name="listLen" id="listLen"
			value="<%=hrMasItaxSecInvestmentList.size()%>"> <%
		      for(HrMasItaxSecInvestment obj : hrMasItaxSecInvestmentList){
			  if(i%2==0)
		   		{%>
		<tr class="odd" onclick="">
			<%}else{%>

			<tr class="even" onclick="">
				<%} %>

				<input type="hidden" name="invSec<%=i %>" id="invSec<%=i %>"
					value="<%=obj.getId() %>">
				<td width="20%" id="td1<%=i %>"><%=obj.getHrMasItaxExemption().getSectionCode() %></td>
				<td width="40%" id="td2<%=i %>"><%=obj.getInvestmentType().getInvestmentDescription()%></td>
				<td width="10%" id="td3<%=i %>">
				<div align="center"><input type="text" name="amount<%=i %>"
					id="amount<%=i %>" validation='Amount,int,yes'
					onchange="chkIfEmpSelected(this)"
					onblur="setDateOfEntry(this.value,'<%=i %>')"></div>
				</td>
				<td width="20%" id="td4<%=i %>"><input type="text"
					id="date<%=i %>" name="date<%=i %>" value="" class="date"
					readonly="readonly" validate="Date,date,no" MAXLENGTH="30" /> <img
					src="/hms/jsp/images/cal.gif"
					onClick="javascript:setdate('',document.getElementById('date<%=i %>'),event)"
					width="16" height="16" border="0" validate="Pick a date"
					class="calender" /></td>
				<td width="10%" id="td5<%=i %>"><%=obj.getMaxAmount() %></td>
			</tr>
			<%i++;}}%>
		
	</tbody>

</table>

<div class="paddingTop40"></div>
<div><input type="button" name="update" value="Update"
	class="button"><input type="button" name="cancel"
	value="Cancel" class="button"><input type="button" name="save"
	value="Save" class="button"
	onclick="submitForm('employeeInvestment','/hms/hrms/incomeTaxMaster?method=saveEmployeeInvestment')"></div>

<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=sdate%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=sdate%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
<script>
		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
</script>
<script type="text/javascript">
		function populateEmpInfo(eid,empCode,Fname,Lname)
		{
			document.getElementById("empid").value=eid;
			
			document.getElementById('labelsDiv').style.display="block";
			document.getElementById('Ecode').innerHTML=empCode;
			document.getElementById('Ename').innerHTML=Fname+" "+Lname;
			//document.getElementById('year').innerHTML=2009;
		}

		function setDateOfEntry(val,index)
		{
			if(val==="")
			{
			document.getElementById("date"+index).value='';
			}
			else{
			document.getElementById("date"+index).value='<%= HMSUtil.convertDateToStringWithoutTime(new Date())%>';
			}
		}
		function chkIfEmpSelected(field)
		{
			if(document.getElementById('labelsDiv').style.display==="none")
			{
				alert("Please Select Employee First !");
				field.value="";
				document.getElementById("employeeList").focus();
			}
		}
		
</script>