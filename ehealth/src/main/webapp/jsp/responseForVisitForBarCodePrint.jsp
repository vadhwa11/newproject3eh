<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();

if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<Visit>visitList=new ArrayList<Visit>();
if(map.get("visitList")!=null){
	visitList=(List<Visit>)map.get("visitList");
}
int hinId=0;
if(map.get("hinId")!=null){
	hinId=(Integer)map.get("hinId");
}
%>
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<label>Visit No.</label>
<input type="hidden" name="hinId" value="<%=hinId %>" />
<select name="visitId" onchange="submitProtoAjaxWithDivName('reportForBarCode','/hms/hms/investigation?method=getOrderDetails','orderId');">
<option value="0">Select</option>
<%for(Visit visit:visitList){ %>
<option value="<%=visit.getId()%>"><%=visit.getVisitNo()%></option>
<%} %>
</select>

<div id="orderId"></div>
