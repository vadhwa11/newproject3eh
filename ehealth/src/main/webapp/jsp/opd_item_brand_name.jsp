<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Ritu  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@page import="jkt.hms.masters.business.MasStoreBrand"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
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
	List<Object[]> brandList = new ArrayList<Object[]>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("brandList") != null)
			brandList =(List)map.get("brandList");
			String url = "";
			
		
		int i=1;
		
%>
<div id="testDiv"><select name="brandId<%=i%>" validate="Brand Name,,yes"
	onclick="submitProtoAjaxWithDivName('fatalDocumentPanchnamaReport','mis?method=showNotifiableDisease','show');">
	<option value="">Select</option>
	<% 
	     	
	     	if (brandList!=null && brandList.size() > 0 ) 
	     	{ 
	     			for(Object[]  brand :  brandList)
	    			{
	     				i++;
			%>
	<option value="<%=brand[0]%>"><%=brand[1]%>
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
<%
brandList.clear();

%>