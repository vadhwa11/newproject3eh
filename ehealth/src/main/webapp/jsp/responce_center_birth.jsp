<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<script src="/hms/jsp/js/surveyTarget.js" type="text/javascript"></script>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<MasHospital> chcList = new ArrayList<MasHospital>();
if(map.get("chcList") !=null){
	chcList=(List<MasHospital>)map.get("chcList");
}
%>
 <div id="testDiv">

<label>Basic-Section / Sub-center</label>
<select name="base" id="base">
<%	if(chcList.size() >0){%>
				<option value="0">Select</option>
				 <%
				 for (MasHospital dis : chcList) {
				  %>
				  <option value="<%=dis.getId()%>"><%=dis.getHospitalName()%></option>
				  <%
				  	 	}}
				   %>

</select>
</div>
