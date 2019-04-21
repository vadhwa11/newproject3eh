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

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
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
		List<StoreIssueM> storeIssueMs = new ArrayList<StoreIssueM>();
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("storeIssueMs") != null)
			storeIssueMs =(List)map.get("storeIssueMs");
		
 	 	/* if (map.get("flag") != null)
		 flag =(String)map.get("flag");
	
	 	 if(flag.equals("lab")){
	 		 url = "lab?method=getPatientDetails";
	 	 } */
	 	int previousVisitNo = 0;
		String maxSequenceNo= "";
		int hinId=0;
%>
<div id="testDiv">
<%
	     if (storeIssueMs!=null && storeIssueMs.size() > 0 ) 
	     	{ 
	    	 %> 
	    	 <select id="issueId" name="<%=ISSUE_NO %>" validate="Issue No,string,no" onChange="submitDetails();">
	 	 <option value="0">Select</option>
		<%  
			for (StoreIssueM sIssueM : storeIssueMs) {
				hinId=sIssueM.getHin().getId(); %>
			
				<option value="<%=sIssueM.getId() %>"><%=sIssueM.getIssueNo()+" ["+HMSUtil.changeDateToddMMyyyy(sIssueM.getIssueDate())+"]"%></option>
			<%}%> 
	</select> 
	<input type="hidden" value="<%=hinId%>" name="<%=HIN_ID %>" id="hinId" />
	<script>
	   	document.getElementById("vId").focus();
	   </script>
	<%  } else { %>
	<input type="text" id="issueId" name="<%=ISSUE_NO %>" value=""
		onchange="submitForm('search','stores?method=getPatientDrugDetail');"
		validate="Issue No ,String,yes" readonly="readonly" />
	<script>
  		    	   alert("Issue No. not exist for this UHID")
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
			System.out.println("includedJsp=11==="+includedJsp);
			
			if(!includedJsp.equals("")){
			%>
<jsp:include page="<%=includedJsp%>" flush="true" />
<%} %>
