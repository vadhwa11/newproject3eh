<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>


<script>
	 var nameArray=new Array();
	 var itemsArray1=new Array();
</script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
function checkBeforSubmit(){
//var mainChargeId=document.getElementById("mainChargeId").value;
var reportName="";
//if(mainChargeId=="all"||mainChargeId=="0"){
reportName="ABCanalysis";

//}
//else{
//reportName="ABCanalysisMainChargewise";
//if(document.getElementById("mainChargeId").value=="r"){
//document.getElementById("mainDepartmentId").value=1;
//}
//else{
//document.getElementById("mainDepartmentId").value=2;
//}

//}
document.getElementById("reportName").value=reportName;
return true;
}

</script>
<script>
<%

	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasDepartment>departmentList=new ArrayList<MasDepartment>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("departmentList")!=null)
	{
		departmentList=(List<MasDepartment>)map.get("departmentList");
	}
	
%>
serverdate = '<%=date+"/"+month1+"/"+year1%>';
</script>
<form name="abcAnalysis" method="post">
<div class="titleBg">
<h2>ABC Analysis Report</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span>From Date </label> 
<input	type="text" name="<%= FROM_DATE %>" value="<%= currentDate %>"	class="date" maxlength="30" tabindex=1 validate="fromDate,date,yes"/> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.abcAnalysis.<%= FROM_DATE%>,event);" />

<label><span>*</span>To Date </label> 
<input type="text"	name="<%= TO_DATE %>" value="<%= currentDate %>" class="date"	maxlength="30" tabindex=1 validate="toDate,date,yes"/> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.abcAnalysis.<%= TO_DATE%>,true);" />

<div class="clear"></div>

<label><span>*</span>Select Main Charge</label> 
<select	name="mainChargeId" id="mainChargeId">
	<option value="0">select</option>
	<%for(MasDepartment dept:departmentList){ %>
	<option value="<%=dept.getId()%>" selected="selected"><%=dept.getDepartmentName()%></option>
	<%} %>
</select> 

<input type="hidden" name="mainDepartmentId" id="mainDepartmentId" validate="mainDepartmentId,int,no"/>
<input type="hidden" name="reportName" id="reportName" validate="reportName,metachar,no"/>
<div class="clear"></div>
</div>

<div class="clear"></div>
<input type="button" class="buttonBig" value="Generate Report"	onclick="if(checkBeforSubmit()){submitForm('abcAnalysis','/hms/hms/investigation?method=printAbcAnalysisReport');}" />


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
