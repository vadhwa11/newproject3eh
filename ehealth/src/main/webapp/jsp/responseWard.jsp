
<%@page import="jkt.hms.masters.business.MasWard"%>
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
List<MasWard> wardList= new ArrayList<MasWard>();
if(map.get("wardList") != null){
	wardList = (List)map.get("wardList");
	
}



%>
<div id="vDiv">
<label><span>*</span>Ward</label>
<select name="wardId" validate="Ward,string,yes"   tabindex=1   onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getLocalityList&wards='+this.value,'wDiv');" >
<%	if(wardList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = wardList.iterator(); iterator.hasNext();) {
					 MasWard w = (MasWard) iterator.next();
				  %>
				  <option value="<%=w.getId()%>"><%=w.getWardName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	
<div id="wDiv">
      
<label><span>*</span>Locality</label>
   <select name="locality" id="locality" validate="Locality,string,yes">
    <option value="0">Select</option>
        </select>


</div>


 
</div>



</div>
	
