
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasDisposal"%>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css"></link>
<style>
.pdfExcelDiv {width:60px; float:left; margin-top:4px;}
</style>

<div id="contentspace"><script type="text/javascript"
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
		
		function fillServiceType(){
			var obj = document.getElementById("serviceTypeId");
			var val = obj.value;
			for(i=0;i<obj.length;i++)
			{
				if(obj.options[i].value == val)
				{
					serviceName = obj.options[i].text
					break;
				}
			}
			if(serviceName !="Select"){
				document.getElementById("serviceTypeName").value =serviceName
			}else{
				document.getElementById("serviceTypeName").value =""
			}
			}
			
			
    	function checkTheOptions(){
    	    var obj = document.getElementById("OutType").value;
			if(obj == "Excel"){
			submitForm('totalAdmission','mis?method=totalDischargeExcelSoftCopy','checkFromNTodata');
			}else{
			submitForm('totalAdmission','mis?method=searchTotalDischarge','checkFromNTodata');
			//submitForm('totalAdmission','mis?method=searchTotalAdmission','checkFromNTodata');
			}	
		}
		function setradioValue(type){
		document.getElementById("OutType").value=type;
		}
	</script>
<div class="titleBg">
<h2>Total Discharge in CHAF Bangalore (AFMSF-42)</h2>
</div>
<div class="Block">
<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
			 	List<MasDisposal> disposalList = new ArrayList<MasDisposal>();
			 	List<Object> list = null;
			 	Date toDate  = null;
				Date fromDate=null;
				String category=null;
			 	if (map.get("serviceTypeList") != null) {
			 		serviceTypeList = (List<MasServiceType>) map.get("serviceTypeList");
			 	}
			 	if (map.get("disposalList") != null) {
			 		disposalList = (List<MasDisposal>) map.get("disposalList");
			 	}
			 %>

<form name="totalAdmission" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="OutType" id="OutType" value="Pdf" /> <label
	class="bodytextB"><font id="error">*</font>From Date:</label> <input
	type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currenDate %>" class="date" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currenDate%>',document.totalAdmission.<%=FROM_DATE%>,event)" />


<label class="bodytextB"><font id="error">*</font> To Date:</label> <input
	type="text" id="ToDateId" name="<%=TO_DATE %>" value="<%=currenDate %>"
	class="date" readonly="readonly" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.totalAdmission.<%=TO_DATE%>,event)" />


<label>Service Type:</label> <select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>" onchange="fillServiceType();">
	<option value="0">Select</option>
	>
	<%
							for (MasServiceType masServiceType : serviceTypeList) {
						%>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName()%></option>
	<%
						}
					%>
</select>
<div class="clear"></div>
<input type="hidden" name="<%=SERVICE_TYPE_NAME %>"
	id="serviceTypeName" /> 
<label class="bodytextB"><font id="error">*</font>Output To :</label>
<input type="radio" name="outputType" value="Pdf" checked="checked"	onClick="setradioValue(this.value)" class="radiobutMargin"/>
<div class="pdfExcelDiv">PDF</div>
<input type="radio"	name="outputType" value="Excel" onClick="setradioValue(this.value)" class="radiobutMargin"/>
<div class="pdfExcelDiv">Excel</div>

<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="checkTheOptions();" />
<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
</form>
</div>
</div>





