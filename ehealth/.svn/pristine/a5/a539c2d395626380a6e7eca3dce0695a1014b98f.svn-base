<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/opd_LP.js"></script>
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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
int tempId=0;
String tempName="";
Box box=HMSUtil.getBox(request);
if(map.get("tempId")!=null)
{
	tempId =(Integer)map.get("tempId");
}
if(map.get("tempId")!=null)
{
	tempName =(String)map.get("tempId");
}
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
<%}else{ %>
</span>

<form method="post" id="templateForm" action="/hms/hms/opd?method=submitPrescriptionTamplate">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<br><br><label>Tamplate Name<span style="color:red;">* </span> </label>
<input type="text" name="tamplatename" id="tamplatename" maxlength="30" value="<%=box.getString("tamplatename")!=null?box.getString("tamplatename"):""%>">
<div style="clear:both;"><div><br><br><table border="2" align="center" cellpadding="2" cellspacing="2" style="float:left;">
<tbody><tr>
<th scope="col">Item Name</th>
<th scope="col">Route</th>
<th scope="col">Dosage</th>
<th scope="col">Frequency</th>
<th scope="col">No of Days</th>
<th scope="col">Instruction </th>
<th scope="col">Total</th>
</tr>
<%int totalItem = box.getInt("total");

for (int i = 1; i <= totalItem; i++) {
%>
<tr><td><input type="hidden" name="pvms<%=i %>" value="<%=box.getString("pvms"+i)%>">
<input type="hidden" name="nomenclature<%=i %>" value="<%=box.getString("nomenclature"+i)%>"><%=box.getString("nomenclature"+i)%></td>
<td><input type="hidden" name="route<%=i %>" value="<%=box.getString("route"+i)%>">
	<input type="hidden" name="routename<%=i %>" value="<%=box.getString("routename"+i)%>"><%=box.getString("routename"+i)%>
</td>
<td><input type="hidden" name="dosage<%=i %>" value="<%=box.getString("dosage"+i)%>"><%=box.getString("dosage"+i)%></td>
<td><input type="hidden" name="frequency<%=i %>" value="<%=box.getString("frequency"+i)%>">
<input type="hidden" name="frequencyname<%=i %>" value="<%=box.getString("frequencyname"+i)%>">
<%=box.getString("frequencyname"+i)%></td><td>
<input type="hidden" name="noOfDays<%=i %>" value="<%=box.getString("noOfDays"+i)%>"><%=box.getString("noOfDays"+i)%></td><td>
<input type="hidden" name="instrunction<%=i %>" value="<%=box.getString("dosage"+i)%>">
<input type="hidden" name="instrunctionname<%=i %>" value="<%=box.getString("instrunctionname"+i)%>">
<%=box.getString("instrunctionname"+i)%>
</td>
<td><input type="hidden" name="total<%=i %>" value="<%=box.getString("total"+i)%>"><%=box.getString("total"+i)%></td>
</tr>
<%} %>
</tbody></table><input type="hidden" id="total" name="total" value="<%=totalItem%>">
<div style="clear:both;">
<br><br>
<div><input type="submit" id="submit" value="Save" onclick="" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" id="close1" value="Close"  onclick="window.close();" />
<%} %>
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="close" value="Close"  onclick="window.close();" />
</div></div></div></form>

<script>
/* function setVal(){
	getTemplate('local','p','','y');
	
	setTimeout("window.close()",1000);
} */
getTemplate('local','p','','y');
</script>