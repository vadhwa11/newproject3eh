<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.AppPatientAppointments"%>
<%@page import="jkt.hms.masters.business.AppSetup"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<Integer> tokenList = new ArrayList<Integer>();

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}

if (map.get("tokenList") != null) 
{
	tokenList = (List<Integer>) map.get("tokenList");
}

%>
<%if(tokenList.size()==0){ %>
<h4>No appointments available for the selected service center</h4>
<%}else{ %>
<h4>Select Queue Priority</h4>
<!-- <input type="button" name="Submit11" value="Submit" tabindex="" class="button" tabindex="1"
			onClick="if(checkFilledField()){if(checkUnit()){submitForm('OnlineAppointment','/hms/hms/appointment?method=submitPatientAppointment&appointmentType=')}}"/> -->
<div class="clear"></div>
<div class="paddingTop5"></div>	
<div class="cmntable" >
<table align="center" cellspacing="0" cellpadding="0" border="0">
<tr>
<% for(Integer tokenNo : tokenList) {%>
<td><input type="button" id="Id<%=tokenNo%>" name="OnlineToken" value="<%=tokenNo%>" onclick="getPriorityNumber(this.value)"></td>
<% } %>
</tr>
</table>
</div>
<%}%>
<style>
table {border:0 !important; margin:0px 0px 10px 0px !important; }
table td {border:0 !important;}
</style>
