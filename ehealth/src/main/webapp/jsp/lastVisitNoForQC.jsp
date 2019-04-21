<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in ipAdmissionReprt.jsp
	 *   Name: Dipali
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

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
		int visitId =0 ;
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
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("visitNoList") != null)
			visitNoList =(List)map.get("visitNoList");
		
 	 	if (map.get("flag") != null)
		 flag =(String)map.get("flag");
	
	 	 if(flag.equals("lab")){
	 		 url = "lab?method=getPatientDetailsForQC";
	 	 }
	 	int previousVisitNo = 0;
		String maxSequenceNo= "";
%>
<div id="testDiv">
<%
	     if (visitNoList!=null && visitNoList.size() > 0 ) 
	     	{ 
	    	
				if(flag.equals("lab")){
				%> <select id="vId" name="<%=VISIT_NUMBER %>"
	validate="Visit No,string,no"
	onfocus="submitForm('search','lab?method=getPatientDetailsForQC');">
	<%}else{%>
	<select id="vId" name="<%=VISIT_NUMBER %>"
		validate="Visit No,string,no">

		<%} %>

		<% 
	     	ArrayList visitNoSequenceList = new ArrayList();
	     	ArrayList visitIdSequenceList = new ArrayList();
			for (Visit visit : visitNoList) {
				previousVisitNo = visit.getVisitNo();
				visitNoSequenceList.add(previousVisitNo);
				visitIdSequenceList.add(visit.getId());
			}
			visitId =0 ;
			if(visitNoSequenceList.size() > 0){
				maxSequenceNo = Collections.max(visitNoSequenceList).toString();
				visitId = (Integer)Collections.max(visitIdSequenceList);
			}
	     			
				%>
		<option value="<%=visitId %>"><%=maxSequenceNo %></option>
	</select>
	<input type="hidden" name="visitId" value="<%=visitId%>" />
	<input type="hidden" name="hinId" value="" name="<%=HIN_NO %>" />
	<script>
	   	document.getElementById("vId").focus();
	   </script>
	<%  } else { %>
	<input type="text" id="visitId" name="<%=VISIT_NUMBER %>" value=""
		onchange="submitForm('search','lab?method=getPatientDetailsForQC');"
		validate="Visit No ,String,yes" readonly="readonly" />
	<script>
  		    	   alert("Visit No. not exist for this HIN")
  		    	   document.getElementById("hinId").value = "";
  		    	</script>
	<% }%>
</div>

<%
			String includedJsp ="";
			if (request.getAttribute("map") != null) {
				map = (Map<String,Object>) request.getAttribute("map");
			}
			if(map.get("includedJsp") != null){
				includedJsp = (String)map.get("includedJsp");
			}
			
			if(!includedJsp.equals("")){
			%>
<jsp:include page="<%=includedJsp%>" flush="true" />
<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
