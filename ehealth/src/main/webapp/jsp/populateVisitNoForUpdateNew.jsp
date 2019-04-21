<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
	</script>

<%	
		Map map = new HashMap();
		String flag = "";
		String url = "";
		List<Visit> visitNoList = new ArrayList<Visit>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("visitNoList") != null)
			visitNoList =(List)map.get("visitNoList");
		
 	 	if (map.get("flag") != null)
		 flag =(String)map.get("flag");
	
	 	 if(flag.equals("lab")){
	 		 url = "lab?method=getPatientDetails";
	 	 }
%>
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 10 Aug 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div id="testDiv">
<%
	     if (visitNoList!=null && visitNoList.size() > 0 ) 
	     	{ %> 
	     	<select name="visitId" validate="<%=prop.getProperty("com.jkt.hms.opd_no") %>,string,yes" id="visitId">


	<option value="0">Select</option>
	<% 
	     	for (Iterator iterator = visitNoList.iterator(); iterator.hasNext();) {
    			
				Visit visit = (Visit)iterator.next();
	     			
				%>
	<option value="<%=visit.getId()%>"><%=visit.getVisitNo()%>
	</option>
	<% } 
	     	 %>
</select> <%}else{ %> <input type="text" name="visitId" value="" 	MAXLENGTH="6" class="readOnly" validate="<%=prop.getProperty("com.jkt.hms.opd_no") %>,String,yes" readonly="readonly"  /> 
<script>
     			document.getElementById('error').innerHTML='<h4> No Record Found!!</h4>';
    		</script> <%} %>
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
