<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import=" static jkt.hms.util.RequestConstants.AD_NO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<Inpatient>dischargeList=new ArrayList<Inpatient>();
if(map.get("ipList")!=null){
	dischargeList=(List<Inpatient>)map.get("ipList");
}
if(dischargeList.size()>0){
%>

<label>IPD No</label>
<select name="<%=AD_NO %>" id="inpatientId">
<option value="0">Select</option>
<%for(Inpatient dis:dischargeList){ %>
<option value="<%=dis.getId() %>"><%=dis.getAdNo() %></option>
<%} %>
</select>

<%}else{
%>
<h4>Wrong UHID</h4>

<%}%>