<%@page import="jkt.hms.masters.business.OtMasUnitDay"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.HospitalDoctorUnitM"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<String>unitDayList=new ArrayList<String>();
if(map.get("unitDayList")!=null){
	unitDayList=(List<String>)map.get("unitDayList");
}
int hinId=0;
if(map.get("hinId")!=null){
	hinId=(Integer)map.get("hinId");
}
%>
<form name="opSurgeryPlanning" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>

<label>Days</label>
<select name="dayName" id="dayNameId" onchange="if(validateDays()){submitProtoAjaxWithDivName('opSurgeryPlanning','ot?method=getBookingDetails&hinId=<%=hinId %>','BooingDetailsDiv');}">
<option value="0">Select</option>
<%for(String hospitalDoctorUnitM:unitDayList){ %>
<option value="<%=hospitalDoctorUnitM%>"><%=hospitalDoctorUnitM%></option>
<%} %>
</select>

<div id="BooingDetailsDiv"></div>
</form>