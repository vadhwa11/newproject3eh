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
List<MasDistrict> district = new ArrayList<MasDistrict>();
if(map.get("district") !=null){
	district=(List<MasDistrict>)map.get("district");
}
String flag="";
if(map.get("flag")!=null){
	flag=(String)map.get("flag");
}
System.out.println("flag==------->>>>"+flag);	
	
%>
 <div id="parameterDiv">

<label>District</label><select name="distr" id="distr" onblur="submitProtoAjaxWithDivNameToShowStatus('phMapping','/hms/hms/pubHealth?method=getTalukList&flag=<%=flag %>&district='+this.value,'tDiv');" >
<%	if(district.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasDistrict dis : district) {
					
				  %>
				  <option value="<%=dis.getId ()%>"><%=dis.getDistrictName()%></option>
				  <%
				  	 	}}
				   %>

</select>

<div id="tDiv">
<%if(!flag.equals("village")){ %>
<label>LSG</label>
<select name="lsg" id="lsgId">
				<option value="0">Select</option>
</select>



<!-- <label>Taluk</label>
<select name="taluk" id="taluk">
				<option value="0">Select</option>
</select>


<label>Village</label>
<select name="village" id="village">
				<option value="0">Select</option>
</select> -->

<label>Ward</label>
<select name="ward" id="ward">
				<option value="0">Select</option>
</select>
<%} %>
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
