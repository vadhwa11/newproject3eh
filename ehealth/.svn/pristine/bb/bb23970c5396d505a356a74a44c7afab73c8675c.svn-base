<%@page import="jkt.hms.masters.business.BloodIssueDetail"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.BloodIndentIssueT"%>
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
<title>Blood Issue Acknowledgment</title>

<div class="titleBg">
<h2>Blood Issue Acknowledgment </h2>
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
Map<String,Object> map = new HashMap<String,Object>();

List<BloodIssueDetail>  bldIssueAckList=new ArrayList<BloodIssueDetail>();

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");

String username="";

List<BloodIndentIssueT>  bldIndentIssueTList=new ArrayList<BloodIndentIssueT>();

if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

if(map.get("bldIndentIssueTList") != null){
	bldIndentIssueTList=(List<BloodIndentIssueT>)map.get("bldIndentIssueTList");
}

if(map.get("bldIssueAckList") != null){
	bldIssueAckList=(List<BloodIssueDetail>)map.get("bldIssueAckList");
}

username=(String)map.get("AckuserName");

//int userId=(Integer)map.get("userId");

String oderIndentNumber="";
for(BloodIndentIssueT bldIndentIssueT:bldIndentIssueTList){
	//System.out.println();
	oderIndentNumber=bldIndentIssueT.getIndentM().getRequestHeader().getOrderNo();
	
}

%>
<div class="Block">
<form name="bloodAcknowledgmentForm" method="post">	
    
	<label>Acknowledgement Date </label> 

<input type="text" class="date"
	id="lastDateId" name="" value="<%=currentDate %>"
	validate="Date of Collection,date,no"  readonly="readonly" tabindex="1" />
	<!--  <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.bloodDonationEntry.expiryDate,event)" />
	 -->
	<label>Acknowledgement By </label> 
	
	<input type="text" class="date"
	id="AcknowledgementNameId" name="AcknowledgementName" value="<%=username %>"  readonly="readonly" tabindex="1" />
	
	<%-- <input type="hidden" 
	id="AcknowledgementId" name="AcknowledgementId" value="<%=userId %>"  readonly="readonly" tabindex="1" /> --%>
	
<!-- <select name="" tabindex="1">
	<option value="0">Select</option>
	
</select>
	 -->
     <div class="clear"></div>
      <div class="clear"></div>
      <% if(null !=bldIssueAckList){
    	  
      %>
      
     <table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			
			<th>Bag Number</th>
			<th>Quantity(ml)</th>
			<th>Select</th>
		</tr>
		<%for(BloodIssueDetail bldIndentIssueM:bldIssueAckList){ %>
		 <input type="hidden" name="bldIndentIssueMName" id="bldIndentIssueMNameId" value="<%= bldIndentIssueM.getId()%>"/>
		<tr onclick="populateIssueQuantityDetails(<%= bldIndentIssueM.getId()%>)">
		<td><%=bldIndentIssueM.getStockDetail().getBloodBagNo() %></td>
		<td><%=bldIndentIssueM.getStockDetail().getQty() %></td>
		<td><input type="checkbox" name="vehicle" value=""></td>
		</tr>
		<%} %>
	</thead>
	</table>
	
    <!--  <div class="clear"></div>
     
     
      
     <label>Quantity Required</label>
     <input  type="text"
				name="quantityRequired" id="quantityRequiredId" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" />
				
	<label>Quantity Issued</label>
     <input  type="text"
				name="quantityIssued" id="quantityIssuedId" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" />
		<label>Quantity Received</label>
     <input  type="text"
				name="quantityRecived" id="quantityRecivedId" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" />		 -->
	
							
   <%} %>
	
		<div class="clear"></div>		
	<input type="button" class="button" name="Reset"  value="save" 
	onclick="submitForm('bloodAcknowledgmentForm','/hms/hms/bloodBank?method=saveAcknownledgeData')" accesskey="r" />
	

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</body>


</script>
</html>