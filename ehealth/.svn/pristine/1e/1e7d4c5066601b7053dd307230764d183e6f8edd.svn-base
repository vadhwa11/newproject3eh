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


<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>

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
		List<Patient>listBasedonHinNo=new ArrayList<Patient>();
		int inc=0;
		String url ;
		boolean hinNoExist=false;

		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		if(map.get("inc")!=null)
		{
			inc=(Integer)map.get("inc");
		}

		if(map.get("listBasedonHinNo")!=null){
			listBasedonHinNo=(List<Patient>)map.get("listBasedonHinNo");
		}

		if(map.get("hinNoExist")!=null )
			hinNoExist=(Boolean)map.get("hinNoExist");



%>

<%if(map.get("hinNoExist")!=null && listBasedonHinNo!=null && hinNoExist==true)
			 	{
			 			if (listBasedonHinNo!=null && listBasedonHinNo.size() > 0 )
	     				{
	     					for (Iterator iterator = listBasedonHinNo.iterator(); iterator.hasNext();) {
	    					Patient patient=(Patient)iterator.next();
	    		%>
	    		
	    		<input type="hidden" id="hinId<%=inc%>" name="<%=HIN_ID %>" value="<%=patient.getId()%>" />
				<td>
					<input type="text"  id="patientName<%=inc%>" name="<%=PATIENT_NAME%>" readonly="readonly" value="<%=patient.getPFirstName() %>" MAXLENGTH="30" validate="Patient Name,fullName,no"  />
				</td>
				
				<%if(patient.getMobileNumber()!=null){ %>
				<td>
					<input type="text" size=10 id="mobileNo<%=inc%>" name="<%=MOBILE_NO%>" readonly="readonly" MAXLENGTH="10" value="<%=patient.getMobileNumber()%>" validate="Mobile No.,int,no"/>
				</td>
				<%}else{ %>
	 			<td>
	 				<input type="text" size=10 id="mobileNo<%=inc%>" name="<%=MOBILE_NO%>" readonly="readonly" MAXLENGTH="10" value="" validate="Mobile No.,int,no"  />
				</td>
				<%} %>

				<%if(patient.getSex().getAdministrativeSexCode().equals("M")){ %>
				<td>
					<select id="sex<%=inc%>" name="<%=SEX%>"  class="small">
					<option value="M" selected="selected">M</option>
					<option value="F">F</option>
					</select>
				</td>
				<%}else if(patient.getSex().getAdministrativeSexCode().equals("F")){ %>
				<td>
					<select id="sex<%=inc%>" name="<%=SEX%>" class="small">
						<option value="F" selected="selected">F</option>
						<option value="M">M</option>
					</select>
				</td>
				<%} %>
				<td>
				<input type="text" size=1 id="age<%=inc%>" name="<%=AGE%>" MAXLENGTH="2"
	 readonly="readonly" value="<%=patient.getAge()%>" />

<select id="ageUnit<%=inc%>" name="<%=AGEUNIT%>" class="small">
	<option value="0">Select</option>
	<option value="Years">Years</option>
	<option value="Months">Months</option>
</select>
</td>


	
	


<%		}
			 		}

			 	}
			 	else {
			 %>
<input type="hidden" id="hinId<%=inc%>" name="<%=HIN_ID %>" value="" />
<td>
<input type="text" size=16 id="patientName<%=inc%>"
	name="<%=PATIENT_NAME%>" disabled="disabled" value="" MAXLENGTH="30"
	validate="Patient Name,fullName,no"  />
	</td>
	<td>
<input type="text" size=10 id="mobileNo<%=inc%>" name="<%=MOBILE_NO%>"
	disabled="disabled" MAXLENGTH="10" value=""
	validate="Mobile No.,int,no"  />
	</td>
	<td>
<select id="sex<%=inc%>" name="<%=SEX%>" class="small"
	disabled="disabled">
	<option value="M" selected="selected">M</option>
	<option value="F">F</option>
</select></td>
<td>
<input type="text" size=1 id="age<%=inc%>" name="<%=AGE%>" MAXLENGTH="2"
	disabled="disabled" value="" />
<select id="ageUnit<%=inc%>" name="<%=AGEUNIT%>" disabled="disabled"
	class="small">
	<option value="0">Select</option>
	<option value="Years">Years</option>
	<option value="Months">Months</option>
</select>
</td>
<script>
							alert("wrong HIN No ....");
							document.getElementById("hinNo"+<%=inc%>).value="";
							</script>
<%} %>
