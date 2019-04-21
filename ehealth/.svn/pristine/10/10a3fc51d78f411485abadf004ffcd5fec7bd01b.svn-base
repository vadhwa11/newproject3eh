<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>




<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<div id="contentHolder"><script type="text/javascript"
	language="javascript">
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
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		int deptId=0;
		if(map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
	%>
<h6>Order Booking</h6>
<input type="hidden" name="deptName" id="deptName"
	value="<%=deptName %>" />
<div class="Clear"></div>
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="header"><label>Service No.</label> <input type="text"
	id="serviceNo." name="<%=SERVICE_NO%>" value="" tabindex="1"
	validate="" MAXLENGTH="30"
	onchange="submitProtoAjaxWithDivName('search','lab?method=getPatientNameForOrderBooking&flag=lab','patientNameDiv')"
	tabindex=1 />
<div id="patientNameDiv"><label>Patient Name</label> <input
	type="text" id="patientName" name="<%=PATIENT_NAME%>" value=""
	MAXLENGTH="30"
	onchange="submitProtoAjax('search','lab?method=getVisitNo&flag=lab');"
	validate="Patient Name ,String,yes" tabindex=1 /></div>
<label>Visit No </label>
<div id="testDiv"><input type="text" id="visitId"
	name="<%=VISIT_NUMBER %>" value=""
	onchange="submitForm('search','lab?method=getPatientDetails');"
	validate="Visit No ,String,yes" class="readOnly" readonly="readonly"
	tabindex=1 /></div>
</div>
</form>
<div class="division"></div>

<%
			String includedJsp ="";
			if (request.getAttribute("map") != null) {
				map = (Map<String,Object>) request.getAttribute("map");
			}
			if(map.get("includedJsp") != null){
				includedJsp = (String)map.get("includedJsp");
			}
			
			if(!includedJsp.equals("")){
			%> <jsp:include page="<%=includedJsp%>" flush="true" /> <%} %>