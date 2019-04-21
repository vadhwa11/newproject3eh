<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleCollection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>  
	
	
	<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Pending List For Result Entry</title>
<div class="titleBg">
<h2>Pending List For Result Entry</h2>
</div>
</head>

<body>
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
<form name="resultEntryList">
<div class="Block">
<label>From Date <span>*</span></label> 
<input type="text" class="date"
	id="lastDateId" name="FDate" value=""
	validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" /> 
	<img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.resultEntryList.FDate,event)" />
	
	<label>To Date <span>*</span> </label> 
<input type="text" class="date"
	id="lastDateId" name="expiryDate" value=""
	validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.resultEntryList.expiryDate,event)" />
	
	

<label>Bag Number</label>
<input type="text"  value="" />
<div class="clear"></div>
<div class="clear"></div>

<input type="button" class="button" value="Search"
	onclick="addRow('dataTable')"
	align="right" /> 

	
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<c:if test="${not empty requestScope.map.pendingscreeningList}">

<table id="" width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			
			<th> Date</th>
			<th>Bag Number</th>
			<th>Tube Number</th>
			<th>Quantity Collected(ml)</th>

		</tr>
		<c:forEach var="donorScreeningList" items="${requestScope.map.pendingscreeningList}">
		<%-- <tr onclick="submitForm('resultEntryList','/hms/hms/bloodBank?method=resultEntryFormJsp&Id=${donorScreeningList[4]}')"> --%>
		<tr onclick="populateResultEntry('${donorScreeningList[5]}')" style="cursor: pointer;">
		<td>${donorScreeningList[3] }</td>
		<td>${donorScreeningList[0] }</td>
		<td>${donorScreeningList[1] }</td>
		<td>${donorScreeningList[2] }</td>
		</tr>
		</c:forEach>
	</thead>
	</table>
	</c:if>
</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
function populateResultEntry(Id){
	//alert();
	 // new Ajax.Request('bloodBank?method=resultEntryFormJsp&Id='+Id, {});
	window.location.href = 'bloodBank?method=resultEntryFormJsp&Id='+Id+'&'+csrfTokenName+'='+csrfTokenValue; 
} 

</script>
</body>
</html>