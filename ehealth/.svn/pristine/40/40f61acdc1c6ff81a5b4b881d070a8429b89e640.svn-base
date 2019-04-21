<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForOpdHinNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Hin Number Combo in patientPrescriptionReport.jsp
	 * @author  Create Date: 25.08.2008    Name: Mansi  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
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
		List<PatientPrescriptionHeader> prescriptionList = new ArrayList<PatientPrescriptionHeader>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("prescriptionList") != null)
			prescriptionList =(List)map.get("prescriptionList");
  	    
		
		
		String hinNo="";
		if (map.get("hinNo") != null)
			hinNo =(String)map.get("hinNo");
  	    
		int visitNo=0;
		if (map.get("visitNo") != null)
			visitNo =(Integer)map.get("visitNo");
  	    
		
		
%>
<div id="teDiv">
<input type="hidden" value ="<%=hinNo %>" name="hinNo"/>
<input type="hidden" value ="<%=visitNo %>" name="visitNo"/>

<label>Prescription No.</label> 
<select name="prescriptionId" id="prescriptionId">
	<option value="0">Select</option>
	<% 
	     	if (prescriptionList!=null && prescriptionList.size() > 0 ) 
	     	{ 
	     		for(PatientPrescriptionHeader pph: prescriptionList){
	     			
				%>
	<option value="<%=pph.getId()%>"><%=pph.getPrescriptionNo()%>
	</option>
	<% 
  		     			
	     		}
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
</select>



</div>