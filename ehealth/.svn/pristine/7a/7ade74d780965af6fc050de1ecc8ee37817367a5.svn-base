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

<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>
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
		List<Object> admissionNoList = new ArrayList<Object>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		
		if (map.get("admissionNoList") != null)
			admissionNoList =(List)map.get("admissionNoList");
  	    
%>
	
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 27 July 2010
 -->	
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<label><span>*</span><%=prop.getProperty("com.jkt.hms.ipd_no") %></label>
<select name="<%=AD_NO%>" validate="<%=prop.getProperty("com.jkt.hms.ipd_no") %>,string,yes" id="adNo"
	onchange="submitProtoAjax('search','adt?method=getMlcNo')">
	<option value="">Select</option>
	<% 
	     	if (admissionNoList!=null && admissionNoList.size() > 0 ) 
	     	{ 
	     		for (Iterator iterator = admissionNoList.iterator(); iterator.hasNext();) {
	    			Object[] object = (Object[]) iterator.next();
					Inpatient inpatient = (Inpatient)object[0];
				//	if( inpatient.getMlc().equals("y")){
					//	if( !inpatient.getAdStatus().equals("C")){
				%>
	<option value="<%=inpatient.getAdNo()%>"><%=inpatient.getAdNo()%>
	</option>
	<% 
  		     		//	}
				//	}
	     		}
			} 
	     	 else
	     	 {
			 %>
	<script>
			 	alert(" No Record Found!!");
			 </script>
	<%
			  } 
	     	 %>
</select>
