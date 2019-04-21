<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BldCrossmatchingHeader"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BloodSampleScreeningHeader"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>

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

<%
	    Box box = HMSUtil.getBox(request);
		Map<String, Object> map = new HashMap<String, Object>();
		
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		Map<String, Object> utilMap = new HashMap<String, Object>();
		
		
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");
	 	
	 	Date toDate  = new Date();
		Date fromDate = new Date();
		String message = "";
		
		List<BldCrossmatchingHeader> bldCrossMatchingheaderList=new ArrayList<BldCrossmatchingHeader>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(null !=map.get("bldCrossMatchingheaderList")){
			bldCrossMatchingheaderList=(List<BldCrossmatchingHeader>)map.get("bldCrossMatchingheaderList");
		}
	
		
	 %>

<script type="text/javascript">
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

<form name="patientSearch" action="" method="post">
<div class="titleBg">
<h2>Pending List To Issue Blood </h2>
</div>
<div class="Block">
<h4>Patient Search</h4>
<label> <span>*</span> From Date</label> 
<input type="text" class="date"
	id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate %>"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=FROM_DATE%>,event)" />

<label><span>*</span>To Date</label> <input type="text" id="ToDateId"
	name="<%=TO_DATE %>" value="<%=currentDate %>" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.patientSearch.<%=TO_DATE%>,event)" />
	
	<label>Cross Match Id</label> <input type="text" name="<%=HIN_NO %>" value=""
	MAXLENGTH="50" /> 
	<div class="clear"></div>
	
	<label>UID</label> <input type="text" name="<%=HIN_NO %>" value=""
	MAXLENGTH="50" /> 
	
	<label>IP Number</label> <input type="text"
	name="<%=AD_NO %>" value="" MAXLENGTH="50" /> 
	
	<label>Ward Number</label> <input type="text"
	name="<%=AD_NO %>" value="" MAXLENGTH="50" /> 

<div class="clear"></div>
<label>Patient Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" />

<div class="clear"></div>
<input type="submit" name="submit" id="addbutton" onclick="submitForm('patientSearch','/hms/hms/bloodBank?method=searchPatientForBloodIssue','check()');" value="Search" class="button" accesskey="a" />
<div class="clear"></div>
<%
if(null !=bldCrossMatchingheaderList && bldCrossMatchingheaderList.size()>0){
	
%>
<table width="100%" colspan="7" id="chargeDetails" cellspacing="0">
	<thead>
		<tr>
			<th>Required Date</th>
			<th>UHID Number </th>
			<th>IP Number</th>
			<th>Patient Name</th>
			<th>Age</th>
			<th>Doctor Name</th>
			<th>Ward</th>
			<!-- <th><span>*</span>Result</th> -->
		</tr>
	</thead>
	<% String adNo="";
	String doctorName="";
	String  ward="";
	String sdate="";
	String uhidNo="";
	String patientName="";
	String patientAge="";
	for(BldCrossmatchingHeader bch:bldCrossMatchingheaderList){
		
		if(null !=bch.getBldRequest().getOrderDate())
			sdate=HMSUtil.convertDateToStringTypeDateOnly(bch.getBldRequest().getOrderDate());
		if(null !=bch.getBldRequest().getInpatient()){
			adNo=String.valueOf(bch.getBldRequest().getInpatient().getAdNo());
			doctorName=bch.getBldRequest().getInpatient().getDoctor().getEmployeeName();
			ward=bch.getBldRequest().getInpatient().getAdWard().getDepartmentName();
		}
		if(null !=bch.getBldRequest().getHin()){
			uhidNo=bch.getBldRequest().getHin().getHinNo();
			patientName=bch.getBldRequest().getHin().getPFirstName();
			patientAge=bch.getBldRequest().getHin().getAge();
		}
		
		%>
	<tbody>
		
		<tr onclick="populateBloodIssueForm('<%=bch.getId()%>')" style="cursor: pointer;">
			
			 <td><%=sdate %></td>
			<td><%=uhidNo %></td>
			<td><%=adNo %></td>
			<td><%= patientName%></td>
			<td><%=patientAge %></td>
			<td><%=doctorName %></td>
			<td><%= ward%></td>
			
		</tr>
		
	</tbody>
	<%}} %>
</table>

<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
function populateBloodIssueForm(Id){
	 // new Ajax.Request('bloodBank?method=resultEntryFormJsp&Id='+Id, {});
	window.location.href = 'bloodBank?method=showBloodIssueJsp&crossMatchingId='+Id+'&'+csrfTokenName+'='+csrfTokenValue; 
} 

</script>
<div class="clear"></div>
<%-- <jsp:include page="searchResultBlock.jsp" /> --%>
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>

</div>
