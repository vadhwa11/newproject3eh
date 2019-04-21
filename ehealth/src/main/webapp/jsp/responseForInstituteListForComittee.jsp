<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script> <script
	type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}

	List<MasHospital> instituteList = new ArrayList<MasHospital>();
	if(map.get("instituteList") != null){
		instituteList = (List<MasHospital>)map.get("instituteList");
	}
%>

	<%    
   	 for(MasHospital masHospital:instituteList) {
   %>
	<option value="<%=masHospital.getId()%>">
	<%=masHospital.getHospitalName()%></option>
	<%	
}
%>