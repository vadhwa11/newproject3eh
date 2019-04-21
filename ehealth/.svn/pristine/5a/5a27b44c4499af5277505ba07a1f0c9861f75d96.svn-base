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
	</script> <br />
	<div class="titleBg">
<h2>Lab Worksheet Report</h2>
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
<form name="labWorksheet" method="post" action="">
<div class="clear"></div>
	<%
	if(map.get("msg") != null){%>
		<div class="clear"></div>
		<label class="large"><span><%=msg%></span></label>
		<div class="clear"></div>
	 <% }%>
<div class="Block">

<label><span>*</span> From Date </label> 
<input	type="text" name="fromDate" value="<%=currenDate%>"	class="date" maxlength="30" tabindex=1 /> 
<img src="/hms/jsp/images/cal.gif" onClick="javascript:setdate('',document.labWorksheet.fromDate,event)" width="16" height="16" border="0" validate="Pick a date,date,yes" class="calender" />
<label><span>*</span> To Date </label>  
<input type="text"	name="toDate" value="<%=currenDate%>" class="date"	maxlength="30" tabindex=1 /> 
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date,date,yes" onClick="javascript:setdate('',document.labWorksheet.toDate,true);" />

<label> <%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<input type="text" id="hin_no"  name="hin_no"    />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Generate Report" value="Search" class="buttonBig" onClick="submitProtoAjaxWithDivName('labWorksheet','/hms/hms/lab?method=htmlWorksheet','testDiv');" />


<input type="button" name="Generate Report" value="Generate Report" class="buttonBig" onClick="submitForm('labWorksheet','lab?method=printLabWorksheet');" />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onClick="submitFormForButton('labWorksheet','lab?method=showLabWorksheetJsp');"  accesskey="r" />
<div class="clear"></div>

<div id="testDiv">
  <div id="pageNavPosition" style="display: none" ></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0" style="display: none"   class="cmntable" >
   <tr>
   		<th>Sl</th>
   		<th>Sample</th>
		<th>Name</th>
		<th>Age</th>
		<th>Gender</th>
		<th>UHID</th>
		<th>Doctor</th>
		<th>Investigation</th>
		<th>Priority</th>
		<th>Status</th>
		</tr>
		
		
		       
            <tbody id="tableData">
            </tbody>
            </table>
</div>
<div class="division"></div>
<div class="clear"></div>
</div>

</form>
<script>
		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
</script>