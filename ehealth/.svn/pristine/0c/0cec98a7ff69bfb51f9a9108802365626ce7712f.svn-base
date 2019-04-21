<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>


<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
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
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = Integer.parseInt(""+session.getAttribute("deptId"));
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String currentTime = (String)utilMap.get("currentTime");
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");
	}
	List<Object[]> deptList=new ArrayList<Object[]>();
	if(map.get("deptList")!=null){
		deptList=(List<Object[]>)map.get("deptList");
	}
	

	
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
 <!--Patient Photo Place holder-->
<form name="stockRegisterReport" method="post">
<div class="titleBg">
<h2>Prescription Wise Pharmacy Consumption Report </h2>
</div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> From Date </label> 
<input	type="text" name="<%= FROM_DATE %>" value="<%=currentDate%>"	class="date" maxlength="30" tabindex=1 /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.stockRegisterReport.<%= FROM_DATE%>,event);" />
<label><span>*</span> To Date </label> 
<input type="text"	name="<%= TO_DATE %>" value="<%=currentDate%>" class="date"	maxlength="30" tabindex=1 /> <img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.stockRegisterReport.<%= TO_DATE%>,true);" />
<div class="clear"></div>
<label>Department</label> 
<select name="deptId" id="departId" >
<option value="0">Select</option>
<%for(Object[] dept:deptList){ %>
<option value="<%=dept[0] %>"><%=dept[1] %></option>
<%} %>
</select>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!--  <input type="button" class="buttonBig" value="Generate Report"	onclick="submitForm('stockRegisterReport','/hms/hms/stores?method=printStockRegisterReport');"></input>-->
<input type="button" class="buttonBig" value="Generate Report"	onclick="submitForm('stockRegisterReport','/hms/hms/stores?method=generateReportPharmacyConsumptionPrescriptionWise');"></input>
<div class="clear paddingTop40"></div>
<div class="division"></div>
<div class="clear"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>