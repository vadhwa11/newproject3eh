
<%@page import="jkt.hms.masters.business.PhMasPanchayat"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<PhMasPanchayat> panchayatList= new ArrayList<PhMasPanchayat>();
if(map.get("panchayatList") != null){
	panchayatList = (List)map.get("panchayatList");
	
}


%>
<div id="aDiv">
<label>Panchayat</label>
<select name="panchayat" validate="Panchayat,string,no"   tabindex=1   >
<%	if(panchayatList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = panchayatList.iterator(); iterator.hasNext();) {
					 PhMasPanchayat pp= (PhMasPanchayat) iterator.next();
				  %>
				  <option value="<%=pp.getId ()%>"><%=pp.getPanchayatName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	



</div>
	
