<%@page import="jkt.hms.masters.business.MasHospital"%>
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
List<MasHospital> chcList = new ArrayList<MasHospital>();
if(map.get("chcList") !=null){
	chcList=(List<MasHospital>)map.get("chcList");
}

List<MasHospital> phcList = new ArrayList<MasHospital>();
if(map.get("phcList") !=null){
	phcList=(List<MasHospital>)map.get("phcList");
}

%>
 <div id="tDiv">

<label>CHC</label>
<select name="chcphc" id="chcphc" onblur="submitProtoAjaxWithDivName('birth','/hms/hms/pubHealth?method=getBirthBasicCenterListchc&chcphc='+this.value,'testDiv');" >
<%	if(chcList.size() >0){%>
				<option value="0">Select</option>
				 <%
				 for (MasHospital dis : chcList) {
				  %>
				  <option value="<%=dis.getId ()%>"><%=dis.getHospitalName()%></option>
				  <%
				  	 	}}
				   %>

</select>

<label>PHC</label>
<select name="chcphc" id="chcphc" onblur="submitProtoAjaxWithDivName('birth','/hms/hms/pubHealth?method=getBirthBasicCenterListphc&chcphc='+this.value,'testDiv');" >
<%	if(phcList.size() >0){%>
				<option value="0">Select</option>
				 <%
				 for (MasHospital dis : phcList) {
				  %>
				  <option value="<%=dis.getId ()%>"><%=dis.getHospitalName()%></option>
				  <%
				  	 	}}
				   %>

</select>

<div id="testDiv">
<label>Basic-Section / Sub-center </label>
    <select name="base" id="base" class=""  validate="">
             	<option value="0">Select</option>
	</select>

</div>

</div>



