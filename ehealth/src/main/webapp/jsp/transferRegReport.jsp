<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="java.net.URL"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
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
	</script> <%
			Map<String, Object> map = new HashMap<String, Object>();
			Map<String, Object> utilMap = new HashMap<String, Object>();
		 	
			utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		 	String time = (String) utilMap.get("currentTime");
		 	
		 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		 	
		 	if(request.getAttribute("map") != null){
				map = (Map<String, Object>)request.getAttribute("map");
			}
			if(map.get("departmentList") != null){
				departmentList = (List<MasDepartment>) map.get("departmentList");
			}
			if(map.get("serviceTypeList") != null){
				serviceTypeList = (List<MasServiceType>) map.get("serviceTypeList");
			}
			
			Properties properties = new Properties();
			URL resourcePath = Thread.currentThread().getContextClassLoader()
					.getResource("adt.properties");
			try {
				properties.load(resourcePath.openStream());
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			String departmentTypeCodeForWard = properties.getProperty("departmentTypeCodeForWard");

	%> <br />
<h2 align="left" class="style1">Transfer Register</h2>
<br />

<form name="ipAdmissionRegister" target="_blank" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="divId"><label class="bodytextB"> From Date:</label> <input
	type="text" id="fromDateId" name="<%=FROM_DATE %>"
	value="<%=currenDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currenDate %>',document.ipAdmissionRegister.<%=FROM_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <label class="bodytextB">
To Date:</label> <input type="text" id="ToDateId" name="<%=TO_DATE %>"
	value="<%=currenDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currenDate %>',document.ipAdmissionRegister.<%=TO_DATE%>)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a></div>
<br />
<label class="bodytextB">From Dept:</label> <select id="departmentd"
	name="<%=DEPARTMENT_ID %>">
	<option value="0">Select</option>
	<%
							for (MasDepartment masDepartment : departmentList) {
								if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForWard)){
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%			}
							}
					%>
</select> <label class="bodytextB">To Dept:</label> <select id="departmentd"
	name="<%=DEPARTMENT_ID_TEMP %>">
	<option value="0">Select</option>
	<%
							for (MasDepartment masDepartment : departmentList) {
								if(masDepartment.getDepartmentType().getDepartmentTypeCode().equals(departmentTypeCodeForWard)){
						%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
	<%			}
							}
					%>
</select> <br />

<br />

<input type="button" name="OK" value="Print" class="button"
	onClick="submitForm('ipAdmissionRegister','adt?method=printTransferRegReport');" />
<input type="button" name="Reset" value="Back" class="button"
	onclick="location.reload();" accesskey="r" /></form>
</div>



<script type="text/javascript">
	function checkAsOn(){

	  if(document.getElementById('hospitalStaffId').value=='y'){
		document.getElementById('divId').style.display = 'none';
		}else{
		alert("-")
		submitForm('ipAdmissionRegister','/hms/hms/adt?method=showIpAdmissionRegisterReportJsp');
		}
		
	}
    </script>