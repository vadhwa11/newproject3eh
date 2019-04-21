<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : responseForAdmissionNo.jsp 
	 * Tables Used         : inpatient ,patient
	 * Description         : This JSP is called thru AJAX to populate Admission Number Combo in ipAdmissionReprt.jsp
	 * @author  Create Date: 18.02.2008    Name: Vivek  
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Inpatient"%>


<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>



<%	
		Map map = new HashMap();
		List<Object> admissionNoList = new ArrayList<Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		List<Patient> patientList = new ArrayList<Patient>();
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");
		}
		String flag="";
		if(map.get("flag") != null)
		{
			flag=""+map.get("flag") ;
		}
		if (map.get("inpatientList") != null)
			inpatientList =(List<Inpatient>)map.get("inpatientList");
		if (map.get("patientList") != null)
			patientList =(List<Patient>)map.get("patientList");
%>
<%if(flag.equals("hin")){ %>
<label class="bodytextB">HIN: </label>
<select name="<%=HIN_ID %>" validate="HIN,,yes"
	onclick="submitProtoAjaxWithDivName('fatalCase','mis?method=getHinAdNoDetailsFatalCase&flag=admission','testDiv');">
	<option value="">Select</option>
	<%for(Patient patient :patientList){ %>
	<option value="<%=patient.getId()%>"><%=patient.getHinNo()%></option>
	<%}%>
</select>
<%}else{ %>
<label class="bodytextB">IP No.: </label>
<select name="<%=AD_NO%>" validate="IP No.,,yes"
	onclick="submitProtoAjaxWithDivName('fatalCase','mis?method=showFatalCase','show');">
	<option value="">Select</option>
	<%for(Inpatient inpatient :inpatientList){ %>
	<option value="<%=inpatient.getId()%>"><%=inpatient.getAdNo()%>
	</option>
	<%} %>
</select>

<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
