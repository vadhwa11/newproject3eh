<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 22.04.2008    Name: Dipali
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
		int inc=0;
		String url ;

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		if(map.get("inc")!=null)
		{
			inc=(Integer)map.get("inc");
		}
%>

<input type="text" size=16 id="patientName<%=inc%>"
	name="<%=PATIENT_NAME%>" value="" MAXLENGTH="30"
	validate="Patient Name,string,yes" class="floatLeft" />

<input type="text" size=10 id="mobileNo<%=inc%>" name="<%=MOBILE_NO%>"
	MAXLENGTH="10" value="" validate="Mobile No.,int,yes" class="floatLeft" />
<select id="sex<%=inc%>" name="<%=SEX%>" class="smallFltLeft" />
<option value="M" selected="selected">M</option>
<option value="F" selected="selected">F</option>

</select>
<input type="text" size=1 id="age<%=inc%>" name="<%=AGE%>" MAXLENGTH="2"
	validate="Age,int,yes" />
<select id="ageUnit<%=inc%>" name="<%=AGEUNIT%>" class="small"
	validate="Patient Name,string,yes">
	<option value="0">Select</option>
	<option value="Years">Years</option>
	<option value="Months">Months</option>
</select>
