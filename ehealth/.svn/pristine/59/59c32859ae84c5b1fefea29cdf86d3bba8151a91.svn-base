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

<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MlcCase"%>
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
		List<MedicoLegalDetails> mlcNoList = new ArrayList<MedicoLegalDetails>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("mlcNoList") != null)
			mlcNoList =(List)map.get("mlcNoList");
  	    
		
%>
<div id="testDiv"><label>Ip No. </label> <select
	name="inpatientId" validate="Ip No.,string,yes">
	<option value="">Select</option>
	<% 
	     	
	     	if (mlcNoList!=null && mlcNoList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = mlcNoList.iterator(); iterator.hasNext();) {
	     			MedicoLegalDetails medicoLegalDetails = (MedicoLegalDetails)iterator.next();
	     			if(medicoLegalDetails.getInpatient()!=null){
				%>
	<option value="<%=medicoLegalDetails.getInpatient().getId()%>"><%=medicoLegalDetails.getInpatient().getAdNo()%>
	</option>
	<% } }
			} 
	     	 else
	     	 {
			 %>
	<script>
			 	document.getElementById('errorMsg').innerHTML='* No Record Found!!';
			 </script>
	<%
			  } 
	     	 %>
</select></div>