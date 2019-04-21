
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
List<String> phClassDetailsList= new ArrayList<String>();
if(map.get("phClassDetailsList") != null){
	phClassDetailsList =  (List<String>)map.get("phClassDetailsList");
	
}
int surveyIdMap=0;
if(map.get("surveyIdMap") != null){
	surveyIdMap = (Integer)map.get("surveyIdMap");
	
}

%>
<div id="testDivSurvey">




<label><span>*</span>Class</label>

<select name="<%=CLASS %>" validate="Class,string,yes"   tabindex=1    onblur="submitProtoAjaxWithDivNameToShowStatus('student','/hms/hms/pubHealth?method=populateSection&surveyIdMap=<%=surveyIdMap%>&classId='+this.value,'testDivSection');">
<%	if(phClassDetailsList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
			
				 for (Iterator iterator = phClassDetailsList.iterator(); iterator.hasNext();) {
						String schoolClass = (String) iterator.next();
						
	
			
				  %>
				  <option value="<%=schoolClass%>"><%=schoolClass%></option>
				  <%
				  	 	}
				   %>
	
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>

	<div id="testDivSection">
<label><span>*</span>Section</label>
<select name="<%= SECTION%>" tabindex="1"	>
	<option value="">Select</option>

</select>








</div>
	
