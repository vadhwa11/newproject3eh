<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * edReport.jsp  
 * Purpose of the JSP -  This is for Appropration Register Report.
 * @author  Ujjwal
 * Create Date: 13th May , 2011 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BudEstimateEntry"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>

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
<div class="titleBg">
<h2>Expired Patient Report</h2>
</div>
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
					
			 	List<BudEstimateEntry> budEstimateEntryList = new ArrayList<BudEstimateEntry>();
			 	
				
			 	if (map.get("budEstimateEntryList") != null) {
			 		budEstimateEntryList = 			(List<BudEstimateEntry>) map.get("budEstimateEntryList"); 	

			 	}
			 	String msg="";
			 	if (map.get("msg") != null) {
			 		msg = (String) map.get("msg"); 	
			 	}
			 %>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);	 %>
<form name="voucherReport" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<%
	if(map.get("msg") != null){%>
		<div class="clear"></div>
		<label class="large"><span><%=msg%></span></label>
		<div class="clear"></div>
	 <% }%>
<div class="Block">
<label><span>*</span> <%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<input type="text" id="hin_no"  name="hin_no"  validate="Reg. No,integer,yes"   onblur="getPatientList();"/><!--Changed by govind 16-11-2016-->
<label><span>*</span> From Date </label> 
<input	type="text" name="fromDate" value="<%=currenDate%>"	class="date" maxlength="30" tabindex=1 /> 
<img src="/hms/jsp/images/cal.gif" onClick="javascript:setdate('',document.voucherReport.fromDate,event)" width="16" height="16" border="0" validate="Pick a date" class="calender" />
<label><span>*</span> To Date </label>  
<input type="text"	name="toDate" value="<%=currenDate%>" class="date"	maxlength="30" tabindex=1 /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" onClick="javascript:setdate('',document.voucherReport.toDate,true);" />
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="patientList">
</div>
<!--  
<input type="button" name="Generate Report" value="Generate Report" class="buttonBig" onClick="if(this.value!=''){submitForm('voucherReport','enquiry?method=printPatientEpfReport&flag=exp');}" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />-->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</div>
</form>
<SCRIPT language=Javascript>//script for entering only integer
      <!--
      function isNumberKey(evt)
      {
         var charCode = (evt.which) ? evt.which : event.keyCode;
         if (charCode > 31 && (charCode < 46 || charCode > 57))
            return false;

         return true;
      }
      //-->
      <!--Changed by govind 16-11-2016-->
        function getPatientList(){
    	var hinNo = document.getElementById("hin_no").value; 
		submitProtoAjaxNew('voucherReport','enquiry?method=getPatientList&hin_no='+hinNo,'patientList');
	  }
	  <!--Changed by govind 16-11-2016 end-->
</SCRIPT> 

