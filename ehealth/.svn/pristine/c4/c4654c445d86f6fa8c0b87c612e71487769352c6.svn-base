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
		List<Object[]> itemIdList = new ArrayList<Object[]>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("itemIdList") != null){
			itemIdList =(List)map.get("itemIdList");
			}
  	    
	int patientTypeId=0;
	if(map.get("patientTypeId")!=null){
		patientTypeId=(Integer)map.get("patientTypeId");
	}
if(patientTypeId==9){
%>
<div id="studentDiv1">
<label>School</label> 
<select	name="schoolId" id="schoolId" validate="School,String,yes" >
	<option value="">Select</option>
	<% 
	     	if (itemIdList!=null && itemIdList.size() > 0 ) 
	     	{ 
	     		for(Object[] object: itemIdList){
				%>
	<option value="<%=object[0]%>"><%=object[1]+" "+"["+object[2]+"]"%>
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
	     	 <label>Gr No</label>
	      <input type="text" name="gr_no" id="gr_no" value="" onblur="submitProtoAjaxWithDivName('registration','opd?method=getstudentDetail1','studentDiv1');"/>
</div>
</div>
<%}%>