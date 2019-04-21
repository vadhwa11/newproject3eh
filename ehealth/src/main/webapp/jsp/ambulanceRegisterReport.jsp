<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 *nursingCareReport.jsp
 * Purpose of the JSP -  This is for Nursing Care Report.
 * @author  Dipali
 * Create Date: 29 March,2008
 * Revision Date:
 * Revision By:
 * @version 1.2
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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
		
		
		
		
			function datevalidation(){
			
			
			var fdate = document.getElementById('FromDateId');
			var tdate = document.getElementById('ToDateId');
			
			frdate  = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2));
			todate  = new Date(tdate.value.substring(6),(tdate.value.substring(3,5) - 1) ,tdate.value.substring(0,2));
			
			
			if(fdate.value != "" && todate.value != ""){
			 if(frdate > todate){
			  alert("To Date should be greater than or equal to the From Date.");
			   return false;
			  }
			}else{
			 return false;
			}
			return true;	
				
				}
				
	</script>

<div class="titleBg">
<h2>Ambulance Run Register</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>


<%
			 	String userName = "";
	 			String hinNo ="";
	 			int deptId =0;
	 			int careType =0;
	 			int nursingCareType =0;

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
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
			 	List<MasNursingCare> nursingCareList = new ArrayList<MasNursingCare>();
			 	List<Object> list = null;
			 	Date toDate  = null;
				Date fromDate=null;

				if (map.get("hinNo") != null) {
					hinNo = (String) map.get("hinNo");
			 	}
				if (map.get("nursingCareType") != null) {
					nursingCareType =Integer.parseInt(""+map.get("nursingCareType")) ;
			 	}
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");
			 	}
			 	if (map.get("nursingCareList") != null) {
			 		nursingCareList = (List<MasNursingCare>) map.get("nursingCareList");
			 	}
			 	if (map.get("toDate") != null) {
			 		toDate = (Date) map.get("toDate");
			 		session.setAttribute("toDate", toDate);
			 	}
			 	if (map.get("careType") != null) {
			 		careType = Integer.parseInt(""+map.get("careType")) ;
			 	}
			 
			 	if (map.get("deptId") != null) {
			 		deptId = Integer.parseInt(""+map.get("deptId")) ;
			 	}
			 	if (map.get("fromDate") != null) {
			 		fromDate = (Date) map.get("fromDate");
			 		session.setAttribute("fromDate", fromDate);
			 	}
			 %>

<form name="ambulanceRegisterReport"  method="post" action="">
<div class="Block">
<label><span>*</span> From Date </label>
<input	type="text" name="<%= FROM_DATE %>" id="FromDateId" value="<%=currenDate%>"class="date" maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"validate="Pick a date"
	onclick="setdate('<%=currenDate%>',document.ambulanceRegisterReport.<%= FROM_DATE%>,event);" />
<label><Span>*</Span> To Date </label>
<input type="text" name="<%= TO_DATE %>" id="ToDateId" value="<%=currenDate %>" class="date"maxlength="30" tabindex=1 />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"validate="Pick a date"
	onclick="setdate('<%=currenDate%>',document.ambulanceRegisterReport.<%= TO_DATE%>,true);" />

<div class="clear"></div>


<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="PRINT" value="PRINT" class="button" onClick="if(datevalidation()){submitForm('ambulanceRegisterReport','/hms/hms/ipd?method=printAmbulanceRegisterReport');}" />

<input type="reset" name="Reset" value="Cancel" class="button" onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

