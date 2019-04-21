
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



List<Object[]> phClassDetailsList= new ArrayList<Object[]>();
if(map.get("phClassDetailsList") != null){
	phClassDetailsList = (List<Object[]>)map.get("phClassDetailsList");
	
}


%>
<div id="testClass">

<label>Class</label> 
<select  name="schoolClass" id="schoolClass" onclick="submitProtoAjaxWithDivNameToShowStatus('student','/hms/hms/pubHealth?method=getSectionList','testSection');">
      <option value="">Select</option>
     
     
      <% 			
			if(phClassDetailsList.size() >0){
				 for (Object[]  phClassDetails : phClassDetailsList) {
					
				  %>
             
           
         
          <option value="<%=phClassDetails[0]%>" ><%=phClassDetails[0]%></option>
         
   
<%}}%>
</select>  
<div id="testSection">
<label>Section</label> 
<select  name="section" validate="Section,string,no" tabindex="1" >
<option value="0">Select</option>
</select>
</div>
</div>



	
