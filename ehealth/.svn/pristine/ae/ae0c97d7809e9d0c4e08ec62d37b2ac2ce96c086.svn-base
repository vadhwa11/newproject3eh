<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryDetail"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>

<script
	type="text/javascript" language="javascript">
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
	</script> <%
	    Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		Map<String, Object> utilMap = new HashMap<String, Object>();
		List<BloodDonationEntryDetail> patientDetailList = new ArrayList<BloodDonationEntryDetail>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String userName = "";
		String message = "";
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("detailsMap") !=null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}
		if(patientMap.get("patientDetailList") != null){
			patientDetailList= (List<BloodDonationEntryDetail>)patientMap.get("patientDetailList");
		}
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		if (map.get("fromDate") != null) {
	 		fromDate = (Date) map.get("fromDate");
	 		session.setAttribute("fromDate", fromDate);
	 	}
		if (map.get("toDate") != null) {
	 		toDate = (Date) map.get("toDate");
	 		session.setAttribute("toDate", toDate);
	 	}
		if(session.getAttribute("userName") != null){
		 userName = (String)session.getAttribute("userName");
		}
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
		<%}	%>
</script> <script type="text/javascript">
	function check(){
		var FDate = document.patientSearch.<%= FROM_DATE%>.value;
		var TDate = document.patientSearch.<%= TO_DATE %>.value;
		
		if (FDate == '' || TDate == '') {
		alert("Please enter both Date....");
		return false;
	   }

		var toDate =new Date(TDate.substring(6),(TDate.substring(3,5) - 1) ,TDate.substring(0,2))
		var fromDate =new Date(FDate.substring(6),(FDate.substring(3,5) - 1) ,FDate.substring(0,2))
	    if(fromDate > toDate)
		{
			alert("Please ensure that To Date is greater than or equal to the From Date.");
			document.calldate.next_day.focus();
			return false;
		}
	}
</script>

<form name="pendingSamlpeScreening" action="" method="post">
<div class="titleBg">
<h2>Pending For Sample Cross Checking</h2>
</div>

<div class="Block">
<h4>Patient Search</h4>
<!-- <input type="button" name="search" id="addbutton" 
value="Scan Bar Code" class="buttonBig" onclick="" accesskey="a" />
 -->
<div class="clear"></div>
<label> Bag Number</label>
 <input type="text" name="bagNumber" value="" MAXLENGTH="15" /> 

<label> <span>*</span> From Date</label> 
<input type="text" class="date"
	id="fromDateId" name="fromDate" value=""
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.pendingSamlpeScreening.fromDate,event)" />

<label> <span>*</span> To Date</label> <input type="text" class="date"
	id="ToDateId" name="toDate" value=""
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.pendingSamlpeScreening.toDate,event)" />
<div class="clear"></div>
<label>Tube Number</label> <input type="text" name="tubeNumber" value="" MAXLENGTH="15" /> 

<div class="clear"></div>
<input type="button" name="search" 
value="Search" class="button" onclick="submitForm('pendingSamlpeScreening','/hms/hms/bloodBank?method=showDonorPendingSampleScreeningJsp')"  />

<div class="clear"></div>

<c:if test="${not empty requestScope.map.sampleScreeningList}">

<table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			<th>Bag Number</th>
			<th>Tube Number</th>
			<th>Quantity Collected(ml)</th>
		</tr>
		
		<c:forEach var="samplescreening" items="${requestScope.map.sampleScreeningList }">
		<tr onclick="submitForm('pendingSamlpeScreening','/hms/hms/bloodBank?method=showbloodBagCrossCheckDetailJsp&samplId=${samplescreening.id}')">
		<input type="hidden" name="sampleCollectionId${samplescreening.id}" value="${samplescreening.id}"/>
		<input type="hidden" name="bagNum${samplescreening.id}" value="${samplescreening.bagNumber}"/>
		<input type="hidden" name="tubNum${samplescreening.id}" value="${samplescreening.tubeNumber}"/>
		<input type="hidden" name="quantityNum${samplescreening.id}" value="${samplescreening.componentQuantity}"/>
		<td>${samplescreening.bagNumber}</td>
		<td>${samplescreening.tubeNumber}</td>
		<td>${samplescreening.componentQuantity}</td>
		
		</tr>
		</c:forEach>
	</thead>
	</table>
	</c:if>
<c:if test="${empty requestScope.map.sampleScreeningList}">	
<h4>No Data Found</h4>
</c:if>

<div class="clear"></div>
</div>
<div class="clear"></div>

<c:if test="${requestScope.map.currentPage >= 2}">
 <td><a href="/hms/hms/bloodBank?method=showDonorPendingSampleScreeningJsp&page=${requestScope.map.currentPage - 1}">Previous</a></td>
 </c:if>

<div class="clear"></div>
<table border="0" cellpadding="2" cellspacing="1">
        <tr>
            <c:forEach begin="1" end="${requestScope.map.noOfPages}" var="i">
                <c:choose>
                    <c:when test="${requestScope.map.currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                      <td><a href="/hms/hms/bloodBank?method=showDonorPendingSampleScreeningJsp&page=${i}">${i}</a></td> 
                     <%--    <td onclick="submitFormForButton('donorSearch',
        '/hms/hms/bloodBank?method=showDonorAssesstmentMasterJsp&page=${i}')"${i}</td> --%>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
    
    <c:if test="${requestScope.map.currentPage lt requestScope.map.noOfPages}">
     <td><a href="/hms/hms/bloodBank?method=showDonorPendingSampleScreeningJsp&page=${requestScope.map.currentPage + 1}">Next</a></td>
        <%--  <td onclick="submitFormForButton('donorSearch',
        '/hms/hms/bloodBank?method=showDonorAssesstmentMasterJsp&page=${requestScope.map.currentPage + 1}')"Next</td> --%>
    </c:if>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>

<div id="searchresults" tabindex="2"></div>
<div id="searchtable" tabindex="2"></div>

