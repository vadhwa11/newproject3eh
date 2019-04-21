<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd_LP.js"></script>
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript"> 
// var csrfTokenName='<csrf:tokenname />';
// var csrfTokenValue='<csrf:tokenvalue />';
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';

</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
map = (Map<String,Object>) request.getAttribute("map");
}

Box box=HMSUtil.getBox(request);
%>
<br/>
<br/>
<br/>
<br/>
<span style="color: red;font-weight: bold;">
<%
if(map.get("message")!=null)
{
%>
<%= map.get("message")%>
<%} %>
</span>

<form method="post" id="templateForm" action="/hms/hms/opd?method=submitInvestigationTamplate">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<br><br><label>Template Name<span style="color:red;">* </span> </label>
<input type="text" name="tamplatename" id="tamplatename" maxlength="30" value="<%=box.getString("tamplatename")!=null?box.getString("tamplatename"):""%>">
<div style="clear:both;"><div><br><br><table border="2" align="center" cellpadding="2" cellspacing="2" style="float:left;">
<tbody>
<tr>
<th scope="col">Test Name</th>
<th scope="col">Clinical Notes</th>
</tr>
<%int totalItem = box.getInt("total");
for (int i = 1; i <= totalItem; i++) {
%>
<tr><td><input type="hidden" name="chargeCode<%=i%>" value="<%=box.getString("chargeCode"+i)%>">
<input type="hidden" name="chargeCodeName<%=i%>" value="<%=box.getString("chargeCodeName"+i)%>">
<%=box.getString("chargeCodeName"+i)%></td>
<td><input type="hidden" name="clinicalNotes<%=i%>" value="<%=box.getString("clinicalNotes"+i)%>">
<%=box.getString("clinicalNotes"+i)%>
</td></tr>
<%} %>
</tbody></table><input type="hidden" id="total" name="total" value="<%=totalItem%>">
<%	if(box.getString("fromIp")!=null && !box.getString("fromIp").equals(""))
{ %>
<input type="hidden" id="fromIp" name="fromIp" value="ipd" />
<%} %>
<div style="clear:both;">
<br><br>
<div><input type="submit" id="submit" value="Save" onclick="" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" id="close" value="Close"  onclick="window.close();" />
</div></div></div></form>

<script>
getTemplate('local','i','');
</script>