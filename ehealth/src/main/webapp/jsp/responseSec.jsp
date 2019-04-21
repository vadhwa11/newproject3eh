
<%@page import="jkt.hms.masters.business.PhClassDetails"%>
<%@page import="jkt.hms.masters.business.PhVillageSurvey"%>
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
List<PhClassDetails> phSectionList= new ArrayList<PhClassDetails>();
if(map.get("phSectionList") != null){
	phSectionList = (List)map.get("phSectionList");
	
}



%>
<div id="testSection">




<label>Section</label>

<select name="sectionId" validate="Section,string,no"   tabindex=1    >
<%	if(phSectionList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = phSectionList.iterator(); iterator.hasNext();) {
					 PhClassDetails s = (PhClassDetails) iterator.next();
				  %>
				  <option value="<%=s.getId()%>"><%=s.getSchoolSection().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>


</div>
	
