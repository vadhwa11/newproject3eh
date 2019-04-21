
<%@page import="jkt.hms.masters.business.PhMasLocality"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
<%@page import="jkt.hms.masters.business.MasPostCode"%>
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasTaluk> talukList= new ArrayList<MasTaluk>();
if(map.get("talukList") != null){
	talukList = (List)map.get("talukList");
	
}

List<PhMasParliyamentAssembly> parliyamentList= new ArrayList<PhMasParliyamentAssembly>();
if(map.get("parliyamentList") != null){
	parliyamentList = (List)map.get("parliyamentList");
	
}


List<MasPostCode> postCodeList= new ArrayList<MasPostCode>();
if(map.get("postCodeList") != null){
	postCodeList = (List)map.get("postCodeList");
	
}

List<PhMasParliyamentAssembly> assemblyList= new ArrayList<PhMasParliyamentAssembly>();
if(map.get("assemblyList") != null){
	assemblyList = (List)map.get("assemblyList");
	
}
List<MasWard> maswardlist = new ArrayList<MasWard>();
if(map.get("maswardlist") != null){
	maswardlist = (List<MasWard>)map.get("maswardlist");
	
}

List<PhMasLocality> phmaslocalitylist = new ArrayList<PhMasLocality>();

if(map.get("phmaslocalitylist") != null){
	phmaslocalitylist = (List<PhMasLocality>)map.get("phmaslocalitylist");
	
}
%>
<div id="testDivs">

	
	<label>Locality</label>
   <select name="locality" id="locality" validate="Locality,string,no">
       
<%	if(phmaslocalitylist.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = phmaslocalitylist.iterator(); iterator.hasNext();) {
					 PhMasLocality t = (PhMasLocality) iterator.next();
				  %>
				  <option value="<%=t.getId()%>"><%=t.getLocalityName().trim()%></option>
				  <%
				  	 	}
				   %>
	 <%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	
<div id="tDiv">



<label>Village</label>
 <select name="village"  id="village" validate="Village,string,no" tabindex=1  >
<option value="0">No Data</option>

</select>


<!-- <div class="clear"></div> -->



<!-- <label><span>*</span>Ward</label>
    <select name="wardId" id="wardId" validate="Ward,string,yes">
    <option value="0">Select</option>
        </select>
       -->


</div>


<%-- <label><span>*</span>Post Office</label>

<select name="postOfficeId" validate="Post Office,string,yes"  onchange="populatePinCode(this.value);"  tabindex=1  >
<%	if(postCodeList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = postCodeList.iterator(); iterator.hasNext();) {
					 MasPostCode p = (MasPostCode) iterator.next();
				  %>
				  <option value="<%=p.getId()%>"><%=p.getPostCodeName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	
   
   <div class="clear"></div>
  
  <label><span>*</span>PIN</label>
   <input type="text" name="pincode"  id="pincode"	value="" validate="PIN,string,yes" MAXLENGTH="20" tabindex=1 />
 --%>
<label>Parliament</label>
<!--  <select name="parliament" validate="Parliament,string,yes"   tabindex=1   onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getAssemblyList&parliamentId='+this.value,'pDiv');">-->
  <select name="parliament" validate="Parliament,string,no"   tabindex=1   >
<%	if(parliyamentList.size() !=0){%>
 	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = parliyamentList.iterator(); iterator.hasNext();) {
					 PhMasParliyamentAssembly p = (PhMasParliyamentAssembly) iterator.next();
				  %>
				  <option value="<%=p.getId ()%>"><%=p.getName().trim()%></option>
				  <%
				  	 	}
				   %>
			
			
	
		
	<%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>

<!-- <div id="pDiv"> -->
 <label>Assembly</label>
<!-- <select name="assembly" validate="Assembly,string,yes"   tabindex=1   onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getPanchayatList&assemblyId='+this.value,'aDiv');"> -->
 <select name="assembly" validate="Assembly,string,no"   tabindex=1   > 
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
	<!-- </div> -->
 

<!-- 
 <label>Panchayat</label>
   
   
 <select name="panchayat"  id="panchayat" validate="Panchayat,string,no" tabindex=1  >
<option value="0">No Data</option>

</select>
 -->



</div>
	
