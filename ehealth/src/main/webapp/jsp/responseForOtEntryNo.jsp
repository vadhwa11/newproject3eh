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
<%@page import="jkt.hms.masters.business.OtPostAnaesthesiaProcedure"%>
<%@page import="jkt.hms.masters.business.OtSpecimenDispatchEntry"%>



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
		List<Object> visitNoList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("visitNoList") != null)
			visitNoList =(List)map.get("visitNoList");
  	    
		
%>
<div id="testDiv"><label class="bodytextB">Entry No.: </label> <select
	name="<%=VISIT_NUMBER%>" validate="Entry No,string,yes">
	<option value="">Select</option>
	<% 
	     	if (visitNoList!=null && visitNoList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = visitNoList.iterator(); iterator.hasNext();) {
	    			//Object[] object = (Object[]) iterator.next();
	    			OtSpecimenDispatchEntry visit = (OtSpecimenDispatchEntry)iterator.next();
	    			
				%>
	<option value="<%=visit.getEntryNo()%>"><%=visit.getEntryNo()%>
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
</select></div>