
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
List<PhVillageSurvey> phVillageSurveyList= new ArrayList<PhVillageSurvey>();
if(map.get("phVillageSurveyList") != null){
	phVillageSurveyList = (List)map.get("phVillageSurveyList");
	
}

int localityIdMap=0;  
if(map.get("localityIdMap") != null){
	localityIdMap = (Integer)map.get("localityIdMap");
	
}
int schoolTypeMap=0;
if(map.get("schoolTypeMap") != null){
	schoolTypeMap = (Integer)map.get("schoolTypeMap");
	
}

System.out.println("schoolTypeMap--"+schoolTypeMap);
%>
<div id="testDivss">
<!-- <div class="clear"></div> -->
<input type="hidden" value="<%=localityIdMap %>" name="localityIdMap" />
<input type="hidden" value="<%=schoolTypeMap %>" />
<label><span>*</span>Name of Anganwadi </label>
<select name="schoolNameId" id="schoolANameId" validate="Name Of Anganwadi,string,no"   tabindex=1   
onblur="submitProtoAjaxWithDivNameToShowStatus('schoolRegistration','/hms/hms/pubHealth?method=getNameDetailList&schoolTypeMap=<%=schoolTypeMap%>&villageSurveyId='+this.value,'wADiv');"
onchange="submitProtoAjaxWithDivNameToShowStatus('schoolRegistration','/hms/hms/pubHealth?method=getNameDetailList&schoolTypeMap=<%=schoolTypeMap%>&villageSurveyId='+this.value,'wADiv');" >
<%	if(phVillageSurveyList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = phVillageSurveyList.iterator(); iterator.hasNext();) {
					 PhVillageSurvey w = (PhVillageSurvey) iterator.next();
					 if(w.getId()!=0 && !w.getPlaceName().equals("") && !w.getPlaceName().equals("null") && w.getPlaceName()!=null){
				  %>
				  <option value="<%=w.getId()%>"><%=w.getPlaceName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>

<div id="wADiv">





</div>



</div>
	
