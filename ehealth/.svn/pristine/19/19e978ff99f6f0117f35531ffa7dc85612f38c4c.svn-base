
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
%>
<div id="testDivs">
<label>Taluk</label>
<!-- <select name="talukId" validate="Taluk,string,yes"   tabindex=1   onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=getVillageList&taluk='+this.value,'tDiv');">
 -->
 <select name="talukId" validate="Taluk,string,no"   tabindex=1  );">
 
 <%	if(talukList.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = talukList.iterator(); iterator.hasNext();) {
					 MasTaluk t = (MasTaluk) iterator.next();
				  %>
				  <option value="<%=t.getId()%>"><%=t.getTalukName().trim()%></option>
				  <%
				  	 	}
				   %>
	 <%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	
	<label>Ward</label>
<select name="wardId" validate="wardID,string,no"   tabindex=1 onblur="submitProtoAjaxWithDivNameToShowStatus('hospital','/hms/hms/user?method=populateLocalityByWardId&ward='+this.value,'tDiv');" >
<%	if(maswardlist.size() !=0){%>
	
			
				<option value="0">Select</option>
				 <%
				 for (Iterator iterator = maswardlist.iterator(); iterator.hasNext();) {
					 MasWard t = (MasWard) iterator.next();
				  %>
				  <option value="<%=t.getId()%>"><%=t.getWardName().trim()%></option>
				  <%
				  	 	}
				   %>
	 <%}else{%>
	<option value="0">Not Data Found</option>
	
	<%} %>
	</select>
	
<div id="tDiv">

<label>Locality</label>
   <select name="locality" id="locality" validate="Locality,string,no">
    <option value="0">Select</option>
        </select>
        
       

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


<label>Post Office</label>

<select name="postOfficeId" validate="Post Office,string,no"  onchange="populatePinCode(this.value);"  tabindex=1  >
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
  
  <label>PIN</label>
   <input type="text" name="pincode"  id="pincode"	value="" validate="PIN,string,no" MAXLENGTH="20" tabindex=1 />

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
 <div class="clear"></div>

<!-- 
 <label>Panchayat</label>
   
   
 <select name="panchayat"  id="panchayat" validate="Panchayat,string,no" tabindex=1  >
<option value="0">No Data</option>

</select>
 -->



</div>
	
