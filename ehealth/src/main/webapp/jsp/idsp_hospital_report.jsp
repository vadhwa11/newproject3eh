<!-- created and modified by amit das --> 
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.HmisParameterMapping"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.HmisDistrictReport"%>
<%@page import="jkt.hms.masters.business.MasHmisParameters"%>
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>

<script>
<%Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';

	
	function getIdspReportList(){
		submitProtoAjaxWithDivName('idspHospitalReportFormP','pubHealth?method=getIdspReportDataHospitalWise','itemList');
	}
	
	function updateIdspReportData(){
		submitForm('idspHospitalReportFormP','pubHealth?method=updateIdspReportDataHospitalWise');
	}
	
	function generateIdspReportFormPExcel(){
		submitForm('idspHospitalReportFormP','pubHealth?method=generatetIdspReportFormP');
	}
	
</script>

<%
Map map = new HashMap();
Map<String,Object> utilMap = new HashMap<String,Object>();
List<MasDepartment> deptList = new ArrayList<MasDepartment>(); //added by amit das on 1-7-2016 
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
//added by amit das on 1-7-2016
if(map.get("deptList")!=null){
	deptList = (List<MasDepartment>)map.get("deptList"); 
}


utilMap = (Map)HMSUtil.getCurrentDateAndTime(); 

String time = (String)utilMap.get("currentTime");
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");
int inc = 0;


if(map.get("message") != null){
	   String message = (String)map.get("message");
	   out.println(message);
}
%>

<div class="titleBg">
<h2>Form P</h2>
</div>
<form name="idspHospitalReportFormP" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<h4>Form P</h4>
	
		<div id="pageNavPosition"></div>
		<div class="clear"></div>
		 <label><span>* </span>From Date</label> 
 	<input id="fromDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=currentDate %>" name="fromDate" validate="From Date,date,yes">
	<img width="16" height="16" border="0" onclick="javascript:setdate('',document.idspHospitalReportFormP.fromDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif"> 
	<label><span>* </span>To Date</label>
	 <input id="toDate" class="date" type="text" maxlength="30" readonly="readonly" value="<%=currentDate %>" name="toDate" validate="To Date,date,yes">
	<img width="16" height="16" border="0" onclick="javascript:setdate('',document.idspHospitalReportFormP.toDate,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
<!-- added by amit das on 1-7-2016 -->
<div style="float: left;">
	<label>Department</label>
	<select name="deptId" id="deptId" validate="Dept list,int,no" >
		<option value="0">Select</option>
		<% if(deptList!=null){
			for(MasDepartment department : deptList){
			%>
			<option value="<%=department.getId()%>"><%=department.getDepartmentName()%></option>
		<% } } %>
	</select>
</div>

<div style="float: left;">
	<input type="button" class="button" value="Generate Excel" align="left" onclick="javascript:generateIdspReportFormPExcel();">
</div>

<div style="float: right;">
	<!-- <input type="button" class="button" value="Search" align="left" onclick="javascript:getIdspReport();"> -->
</div>
		<div class="clear"></div>
		<div class="clear"></div>
<!-- <table border="0" align="center" cellpadding="0" cellspacing="0"
	id="itemGrid">
	<tr>
		<th scope="col">Diseases/Syndromes</th>
		<th scope="col">No Of Cases</th>
	</tr>
	<tbody id="itemList">
	
	</tbody>
</table>
<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
		<div class="clear"></div>
<div style="float: left;">
	<input type="button" class="button" value="Update" align="left" onclick="javascript:updateIdspReportData();">
</div> -->
	</div>
	
</form>
<div id="responseDiv" style="display: none;">
</div>


<script type="text/javascript">
//getIdspReportList();
</script>