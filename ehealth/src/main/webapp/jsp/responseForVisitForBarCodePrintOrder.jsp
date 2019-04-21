<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
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
List<DgSampleCollectionHeader>orderList=new ArrayList<DgSampleCollectionHeader>();
if(map.get("ptList")!=null){
	orderList=(List<DgSampleCollectionHeader>)map.get("ptList");
}
%>
<script lang="javascript" src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<label>Order No.</label>
<select name="orderId" onchange="submitProtoAjaxWithDivName('reportForBarCode','/hms/hms/investigation?method=getSamepleDetails','sampleId');">
<option value="0">Select</option>
<%for(DgSampleCollectionHeader visit:orderList){ %>
<option value="<%=visit.getOrder().getId()%>"><%=visit.getOrder().getOrderNo()%></option>
<%} %>
</select>

<div id="sampleId"></div>
