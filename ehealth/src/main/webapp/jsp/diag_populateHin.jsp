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

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>



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
		List<Object> patientList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("patientList") != null)
			patientList =(List)map.get("patientList");
		
  	    String flag = "";
  	  	
  	 	 if (map.get("flag") != null)
			flag =(String)map.get("flag");
  	 	 
  	 	 String url = "";
  	 	if(flag.equals("lab")){
   	 		url = "lab?method=getVisitNo";
  	 	 }
  	 	
  	 	int count=0;
     
%>
<div id="hinDiv"><label class="bodytextB">HIN: </label> <%
			if (patientList!=null && patientList.size() > 0 ) 
	     	{ 
			%> <select id="hinId" name="<%=HIN_ID%>" validate="HIN,string,yes"
	onblur="submitProtoAjax('search','<%=url %>');">

	<% 
	     	
	     		for (Iterator iterator = patientList.iterator(); iterator.hasNext();) {
	    				Patient patient = (Patient)iterator.next();
	    				
				%>
	<option name="name" value="<%=patient.getId()%>"><%=patient.getHinNo()%>
	</option>

	<% }%>




</select> <script>
	   	document.getElementById("hinId").focus();
	    
	   </script> <%  } %>
</div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

