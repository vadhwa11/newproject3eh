
<%@page import="jkt.hms.masters.business.PhMasLocality"%>
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
List<PhMasLocality> localityList= new ArrayList<PhMasLocality>();
if(map.get("localityList") != null){
	localityList = (List)map.get("localityList");
	
}


System.out.println(localityList.size()+"-----jsp------------");

%>
<div id="wDiv">
<label><span>*</span>Locality</label>
<select name="locality" validate="Locality,string,yes"   tabindex=1   >
<%	if(localityList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = localityList.iterator(); iterator.hasNext();) {
					 PhMasLocality l = (PhMasLocality) iterator.next();
				  %>
				  <option value="<%=l.getId()%>"><%=l.getLocalityName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	



</div>
	
