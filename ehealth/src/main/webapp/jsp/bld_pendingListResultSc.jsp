<%@page import="jkt.hms.masters.business.BloodResultEntryHeader"%>
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

<div class="titleBg">
<h2>Pending List For Serum Grouping</h2>
</div>

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
List<BloodResultEntryHeader> pendingscreeningList = new ArrayList<BloodResultEntryHeader>();

Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
if(null !=map.get("pendingscreeningList")){
	pendingscreeningList=(List<BloodResultEntryHeader>)map.get("pendingscreeningList");
}

%>
<form name="resultEntryList">
<div class="Block">
<label>From Date <span>*</span></label> 
<input type="text" class="date"
	id="lastDateId" name="FDate" value=""
	validate="FDate,date,no" MAXLENGTH="10" tabindex="1" /> 
	<img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.resultEntryList.FDate,event)" />
	
<label>To Date <span>*</span> </label> 
<input type="text" class="date"
	id="lastDateId" name="expiryDate" value=""
	validate="expiryDate,date,no" MAXLENGTH="10" tabindex="1" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.resultEntryList.expiryDate,event)" />	

<label>Bag Number</label>
<input type="text"  value="" validate="Bag,metachar,no"/>
<div class="clear"></div>
<input type="button" class="button" value="Search"	onclick="addRow('dataTable')"	align="right" /> 
	
<div class="clear"></div>
<div class="paddingTop5"></div>
<%-- <c:if test="${not empty requestScope.map.pendingscreeningList}"> --%>
<%if(null !=pendingscreeningList && pendingscreeningList.size()>0){
	
%>
 <table id="" width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			
			<th>Date</th>
			<th>Bag Number</th>
			<th>Tube Number</th>
			<th>Quantity Collected(ml)</th>

		</tr>
		<%-- <c:forEach var="donorScreeningList" items="${requestScope.map.pendingscreeningList}"> --%>
		<%for(BloodResultEntryHeader breh:pendingscreeningList){
			%>
		
		<%-- <tr onclick="submitForm('resultEntryList','/hms/hms/bloodBank?method=resultEntryFormJsp&Id=${donorScreeningList[4]}')"> --%>
		<tr onclick="populateResultEntry('<%=breh.getId()%>')" style="cursor: pointer;">
		<td><%=HMSUtil.convertDateTypeToStringWithoutTime(breh.getSampleCollection().getSampleCollectionDate()) %></td>
		<td><%=breh.getSampleCollection().getBagNumber() %></td>
		<td><%=breh.getSampleCollection().getTubeNumber() %></td>
		<td><%=breh.getSampleCollection().getComponentQuantity() %></td>
		
		</tr>
		<%} %>
		<%-- </c:forEach> --%>
	</thead>
	</table>
	<%} %>
</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
function populateResultEntry(Id){
	//alert();
	 // new Ajax.Request('bloodBank?method=resultEntryFormJsp&Id='+Id, {});
	window.location.href = 'bloodBank?method=resultEntryFormScJsp&Id='+Id+'&'+csrfTokenName+'='+csrfTokenValue; 
} 

</script>

