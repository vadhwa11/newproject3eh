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
<label><span>*</span> Institute Type</label>
<select name="instituteType" validate="Institute Type,int,yes" id="instituteType" class="" onclick="enableRadio();">
				<option value="0">ALL</option>
				<option value="1">Sub-Center</option>
				<option value="2">Basic-Section</option>
			</select>
<label><span>*</span>BasicSection/Subcenter</label>
<select name="base" id="base" validate="Basic-Section/Sub-Center,int,yes" onclick="enableRadio();">
<%	if(chcList.size() >0){%>
				<option value="0">Select</option>
				 <%
				 for (MasHospital dis : chcList) {
				  %>
				  <option value="<%=dis.getId()%>"><%=dis.getHospitalName()%></option>
				  <%}}else{  %>
					   <option value="0">ALL</option>
					   <%} %>

</select>

</div>