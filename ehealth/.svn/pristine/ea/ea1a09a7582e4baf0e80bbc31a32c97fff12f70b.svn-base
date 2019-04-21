<%@page import="jkt.hms.masters.business.BloodResultEntryHeader"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BloodResultEntryHeader"%>
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

<title>Pending List For Result Validation</title>

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
<%
Map<String, Object> map = new HashMap<String, Object>();
List<BloodResultEntryHeader> resultList = new ArrayList<BloodResultEntryHeader>();

/* List<DgMasInvestigation> investionList = new ArrayList<DgMasInvestigation>();
List<BloodSampleScreeningDetail> screenDetailList = new ArrayList<BloodSampleScreeningDetail>();
 */
if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
 if(map.get("resultList") != null)
 {
	 resultList=(List<BloodResultEntryHeader>)map.get("resultList");
 }
System.out.println();
%>
<div class="titleBg">
<h2>Pending List For Result Entry</h2>
</div>
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
<input type="button" class="button" value="Search" onclick="addRow('dataTable')" align="right" /> 	
<div class="clear"></div>
<div class="paddingTop5"></div>

<table id="" width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>			
			<th> Date</th>
			<th>Bag Number</th>
			<th>Tube Number</th>
			<th>Quantity Collected(ml)</th>
		</tr>
</thead>
<%

for(BloodResultEntryHeader resulth:resultList){ %>
		
		<%-- <tr onclick="populateResultEntryValidation('<%=resulth.getId()%>')">
		<td><%= HMSUtil.convertDateToStringTypeDateOnly(resulth.getScreeningTest().getSampleCollection().getLastChgDate())  %></td>
		<td><%=resulth.getScreeningTest().getSampleCollection().getBagNumber() %></td>
		<td><%=resulth.getScreeningTest().getSampleCollection().getTubeNumber() %></td>
		<td><%=resulth.getScreeningTest().getSampleCollection().getComponentQuantity() %></td>
		</tr> --%>
		<tr onclick="populateResultEntryValidation('<%=resulth.getId()%>')" style="cursor: pointer;">
		<td><%= HMSUtil.convertDateToStringTypeDateOnly(resulth.getSampleCollection().getLastChgDate())  %></td>
		<td><%=resulth.getSampleCollection().getBagNumber() %></td>
		<td><%=resulth.getSampleCollection().getTubeNumber() %></td>
		<td><%=resulth.getSampleCollection().getComponentQuantity() %></td>
		</tr>
		
	<%} %>
	</table>	
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
function populateResultEntryValidation(Id){
	
	 // new Ajax.Request('bloodBank?method=resultEntryFormJsp&Id='+Id, {});
	window.location.href = 'bloodBank?method=resultEntryValidationJsp&Id='+Id+'&'+csrfTokenName+'='+csrfTokenValue; 
} 

</script>
