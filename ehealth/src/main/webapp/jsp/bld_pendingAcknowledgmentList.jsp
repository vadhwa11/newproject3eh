<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.BloodIndentIssueM"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@page import="java.util.Calendar"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
	 <script type="text/javascript" src="/hms/jsp/js/jquery-1.4.2.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pending Acknowledgment List</title>
<div class="titleBg">
<h2>Pending Acknowledgment List</h2>
</div>

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

</head>
<body>
<%
Map map = new HashMap();

List<BloodIndentIssueM>  bldIndentIssueMList=new ArrayList<BloodIndentIssueM>();

if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

if(map.get("bldIndentIssueMList") != null){
	bldIndentIssueMList=(List<BloodIndentIssueM>)map.get("bldIndentIssueMList");
}


%>
<div class="Block">
<form name="bloodAcknowledgmentForm" method="post">


<label>Form Date<span>*</span> </label> 
<input type="text" class="date"
	id="fromDateId" name="fromDate" value=""
	validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" />
	 <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.bloodAcknowledgmentForm.fromDate,event)" />

<label>To Date<span>*</span> </label> 
<input type="text" class="date"
	id="lastDateId" name="lastDate" value=""
	validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" />
	 <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.bloodAcknowledgmentForm.lastDate,event)" />
		
<label>Issue Number</label> 
	<input type="text"  name="" value="" validate="BP,string,no" maxlength="3"
	tabindex="1" /> 	
<div class="clear"></div>



<label>Indent Number</label> 
	<input type="text"  name="" value="" validate="BP,string,no" maxlength="3"
	tabindex="1" />
	<div class="clear"></div>
	
    
	<input type="button" class="button" value="Search" align="right"/> 
	
	<div class="clear"></div>	
	<% int count=1;
	if(null !=bldIndentIssueMList){%>
	
	<table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			<th>Issue Date </th>
			<th>Issue Number</th>
			<th>Indent Number</th>
			
			<th>     </th>
		</tr>
		<%
		for(BloodIndentIssueM bldIndentIssueM:bldIndentIssueMList){
		%>
		
		<tr>
			<td><%=HMSUtil.convertDateToStringTypeDateOnly(bldIndentIssueM.getIndentIssueDate())  %></td>
			<td></td>
			<td><%=bldIndentIssueM.getRequestHeader().getOrderNo() %></td>
			<td>  
			<input type="button" class="buttonBig2"
			  value="Acknowledgment"
			onclick="displayAndHideDiv(<%=count %>,<%=bldIndentIssueM.getId() %>)" />
		    </td>
		</tr>
		<%count++;} %>
	</thead>
	</table>
	<%} %>
	<div class="clear"></div>
<div class="clear"></div>
<% int inc=1;
if(null !=bldIndentIssueMList){
	
	
	for(BloodIndentIssueM bldIndentIssueM:bldIndentIssueMList){
		
	
	%>


	<div id="Div_1<%=inc %>" class="Block" style="display: none; ">
	
	<label>Acknowledgement Date </label> 

<input type="text" class="date"
	id="lastDateId" name="" value=""
	validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" />
	 <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.bloodDonationEntry.expiryDate,event)" />
	
	<label>Acknowledgement By </label> 
	
<select name="" tabindex="1">
	<option value="0">Select</option>
	
</select>
	
     <div class="clear"></div>
      <div class="clear"></div>
      
     <table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			
			<th>Blood Bag Number</th>
			<th>Quantity(ml)</th>
			<th>Select</th>
		</tr>
		<tr>
		<td>Bag1</td>
		<td>100</td>
		<td><input type="checkbox" name="vehicle" value="Bike"></td>
		</tr>
		
	</thead>
	</table>
     <div class="clear"></div>
     <div class="clear"></div>
      <div class="clear"></div>
      
     <label>Quantity Required</label>
     <input id="" type="text"
				name="<%=BLOOD_BAG_NO%>" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" />
				
	<label>Quantity Issued</label>
     <input id="" type="text"
				name="<%=BLOOD_BAG_NO%>" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" />
		<label>Quantity Received</label>
     <input id="" type="text"
				name="<%=BLOOD_BAG_NO%>" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" />		
		<div class="clear"></div>		
	<input type="button" class="button"
	name="Reset"  value="Submit"
	onclick="" accesskey="r" />
							
    </div>
    
    <% inc++;}
	
	} %>
	
	

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</body>
<script type="text/javascript">

function displayAndHideDiv(count,indentId){
	
	window.location.href='bloodBank?method=populateIssueIndentBagDetal&indentId='+indentId;
	
	/* var elem=document.getElementById('Div_1'+count);
	if(elem.style.display=='block')
	{
	document.getElementById('Div_1'+count).style.display = 'none';
	}
	else{
		document.getElementById('Div_1'+count).style.display = 'block';	
		 populateBagDetalForIndent
		  populateIssueIndentBagDetal(indentId);
	} */
	
	
}

</script>
</html>