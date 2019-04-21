
<%@page import="jkt.hms.masters.business.MasVillage"%>
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
List<MasVillage> villageList= new ArrayList<MasVillage>();
if(map.get("villageList") != null){
	villageList = (List)map.get("villageList");
	
	
}


%>
<div id="tDiv">
<label><span>*</span>Village</label>
<select name="village" validate="Village,string,yes"   tabindex=1   onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getWardList&villageId='+this.value,'vDiv');">
<%	if(villageList.size() >0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = villageList.iterator(); iterator.hasNext();) {
					 MasVillage v = (MasVillage) iterator.next();
				  %>
				  <option value="<%=v.getId()%>"><%=v.getVillageName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	
<div id="vDiv">
<div class="clear"></div>
<label><span>*</span>Ward</label>
    <select name="wardId" id="wardId" validate="Ward,string,yes">
    <option value="0">Select</option>
        </select>
      
<label><span>*</span>Locality</label>
   <select name="locality" id="locality" validate="Locality,string,yes">
    <option value="0">Select</option>
        </select>
 



 
</div>



</div>
	
