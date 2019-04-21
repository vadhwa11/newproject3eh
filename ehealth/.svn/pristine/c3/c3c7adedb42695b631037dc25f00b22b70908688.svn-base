
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasHospital> masHospitalSCBS= new ArrayList<MasHospital>();
if(map.get("masHospitalSCBS") != null){
	masHospitalSCBS = (List)map.get("masHospitalSCBS");
	
}


%>
<div id="scBs">

<label>Sub Centre/Basic Section</label>
<select name="scBSPHC" id="scBSPHC" >
<%	if(masHospitalSCBS.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = masHospitalSCBS.iterator(); iterator.hasNext();) {
					 MasHospital w = (MasHospital) iterator.next();
					 if(w.getId()!=0 && !w.getHospitalName().equals("") ){
				  %>
				  <option value="<%=w.getId()%>"><%=w.getHospitalName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>




</div>
	
