
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
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
List<PhMasParliyamentAssembly> assemblyList= new ArrayList<PhMasParliyamentAssembly>();
if(map.get("assemblyList") != null){
	assemblyList = (List)map.get("assemblyList");
	
}


%>
<div id="pDiv">

<label><span>*</span>Assembly</label>
<!-- <select name="assembly" validate="Assembly,string,yes"   tabindex=1   onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getPanchayatList&assemblyId='+this.value,'aDiv');"> -->
 <select name="assembly" validate="Assembly,string,yes"   tabindex=1   > 
<%	if(assemblyList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = assemblyList.iterator(); iterator.hasNext();) {
					 PhMasParliyamentAssembly a= (PhMasParliyamentAssembly) iterator.next();
				  %>
				  <option value="<%=a.getId ()%>"><%=a.getName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	<!-- 
<div id="aDiv">

 <label><span>*</span>Panchayat</label>
      
 <select name="panchayat"  id="panchayat" validate="Panchayat,string,yes" tabindex=1  >
<option value="0">No Data</option>

</select>
	</div>
 -->
 
 <div class="clear"></div>
</div>
	
