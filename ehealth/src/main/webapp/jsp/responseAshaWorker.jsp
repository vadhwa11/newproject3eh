<%@page import="jkt.hms.masters.business.AshaWorker"%>
<%@page import="jkt.hms.masters.business.MasLsg"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>
<%@page import="java.util.Iterator"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<MasHospital>list= new ArrayList<MasHospital>();
List<MasHospital>parent_masHospitals= new ArrayList<MasHospital>();

List<MasLsg>masLsgs= new ArrayList<MasLsg>();
if(map.get("hospitals") != null){
	list = (List<MasHospital>)map.get("hospitals");
}

if(map.get("parent_masHospitals") != null){
	parent_masHospitals = (List<MasHospital>)map.get("parent_masHospitals");
}

if(map.get("masLsgs") != null){
	masLsgs = (List<MasLsg>)map.get("masLsgs");
}
AshaWorker asha=new AshaWorker();
if(map.get("asha") != null){
	asha = (AshaWorker)map.get("asha");
}
%>
<%if(map.get("ashaId")!=null){ %>
<div>
<label>Asha Worker Name</label><label class="auto" style="background-color: white;"><%=asha.getAshaName() %></label>
<label>Hospital Type</label><label class="auto" style="background-color: white;"><%=asha.getHospitalType().getHospitalTypeName()%></label>
<div class="clear"></div>
<label>Hospital</label><label class="auto" style="background-color: white;"><%=asha.getHospital().getHospitalName()%></label>
</div>
<div>
<table>
<thead>
<tr><th>Hospital Name</th></tr>
</thead>
<tbody>
	<%for(MasHospital mos:list) {%>
		<tr><td><%=mos.getHospitalName() %></td></tr>
	<%}%>
</tbody>
</table>
</div>
<%}else if(map.get("hospitalTypeId")!=null){%>
	<%for(MasHospital hos:list){%>
	<option value="<%=hos.getId()%>"><%=hos.getHospitalName()%></option>
<%}
}else if(map.get("districtId")!=null){ %>
		<option value="0">Select</option>
		<%for(MasLsg lsg:masLsgs){%>
	     <option value="<%=lsg.getId()%>"><%=lsg.getLsgTypeName()%></option>
       <%}
}else if(map.get("hospitalId")!=null){ %>
		<%for(MasHospital msh:parent_masHospitals){%>
	     <option value="<%=msh.getId()%>"><%=msh.getHospitalName()%></option>
 <%}
} %>



