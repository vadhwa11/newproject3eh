<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="jkt.hms.masters.business.MasWard"%>
<%@page import="jkt.hms.masters.business.MasTaluk"%>
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasTaluk> talukList = new ArrayList<MasTaluk>();
if(map.get("talukList") !=null){
	talukList=(List<MasTaluk>)map.get("talukList");
}
List<MasWard> ward = new ArrayList<MasWard>();
if(map.get("ward") !=null){
	ward=(List<MasWard>)map.get("ward");
}
List<MasLsg> lsg = new ArrayList<MasLsg>();
if(map.get("lsg") !=null){
	lsg=(List<MasLsg>)map.get("lsg");
}
String flag="";
if(map.get("flag") !=null){
	flag=(String)map.get("flag");
}
%>
 <div id="parameterDiv">
 <div id="tDiv">
 <%if(!flag.equals("village")){ %>
 <label>LSG</label> 
 <select name="lsg" id="lsgId" onchange="submitProtoAjaxWithDivNameToShowStatus('phMapping','/hms/hms/pubHealth?method=getWardList&lsg='+this.value,'tDivs');" >
      <%	if(talukList.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasLsg lsg1 : lsg) {
					
				  %>
				  <option value="<%=lsg1.getId ()%>"><%=lsg1.getLsgTypeName()%></option>
				  <%
				  	 	}}
				   %>

 </select>
<%--   <div class="clear"></div>
<label>Ward</label>
<select name="ward" id="ward" onchange="submitProtoAjaxWithDivNameToShowStatus('phMapping','/hms/hms/pubHealth?method=getlocalityList&ward='+this.value,'tDivs');">
 <%	if(ward.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasWard tal : ward) {
					
				  %>
				  <option value="<%=tal.getId ()%>"><%=tal.getWardName()%></option>
				  <%
				  	 	}}
				   %>
</select>
 <div class="clear"></div>--%>
  <%}else if(flag.equals("village")){ %>
  
  
  
<label>Taluk</label><select name="taluk" id="taluk" onchange="submitProtoAjaxWithDivNameToShowStatus('phMapping','/hms/hms/pubHealth?method=getvilageList&taluk='+this.value,'tDivs');" >
      <%	if(talukList.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasTaluk tal : talukList) {
					
				  %>
				  <option value="<%=tal.getId ()%>"><%=tal.getTalukName()%></option>
				  <%
				  	 	}}
				   %>

</select> 
<%} %>

 <div id="tDivs">
<label>Ward</label>
<select name="ward" id="ward">
				<option value="0">Select</option>
</select>
 <!-- <label>Village</label>
<select name="village" id="village">
				<option value="0">Select</option>
</select>  -->
<div class="clear"></div>

 <label>Locality</label>
<select name="paramId" id="paramId" multiple="multiple" size="3" class="listBig3">
				<option value="0">Select</option>
</select> 
<div class="placeHolderForAddLeftnRight">
<input type="button" name="Add" class="addRight" value="" onclick="copySelectedOptions();" />

<input type="button" name="send" class="addLeft"  onclick="removeSelectedOptions();"/>

</div>

<select name="tempId" id="tempId"  multiple="multiple" size="3" class="listBig3">
     
</select>
</div>
</div>
</div>


