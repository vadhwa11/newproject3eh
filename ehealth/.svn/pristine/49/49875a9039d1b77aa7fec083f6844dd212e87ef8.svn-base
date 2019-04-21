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
		List<Visit> visitNoList = new ArrayList<Visit>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("visitNoList") != null)
			visitNoList =(List)map.get("visitNoList");
  	    
		String hinNo="";
		if (map.get("hinNo") != null)
			hinNo =(String)map.get("hinNo");
  	    
		
		
		
%>
<div id="teDivss">

<input type="hidden" value ="<%=hinNo %>" name="hinNo"/>

<label>Visit No. </label> 
<select	name="visitNo" validate="Visit No,string,yes"  onblur="submitProtoAjaxWithDivNameToShowStatus('search','/hms/hms/stores?method=getPrescriptionList&hinNo=<%=hinNo%>&visitNo='+this.value,'teDiv');" >
	<option value="">Select</option>
	<% 
	     	if (visitNoList!=null && visitNoList.size() > 0 ) 
	     	{ 
	     		for(Visit visit: visitNoList){
	     			
				%>
	<option value="<%=visit.getVisitNo()%>"><%=visit.getVisitNo()%></option>
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
<div id="teDiv">
<label>Prescription No.</label> 
<select name="prescriptionId" id="prescriptionId">
<option value="0"></option>
</select>
</div>

</div>