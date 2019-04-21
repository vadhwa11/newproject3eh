<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="printhrloan" method="post" action="">
<%Map<String,Object> map =new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map) request.getAttribute("map");
}
List<MasEmployee>employeeList=new ArrayList<MasEmployee>();
if(map.get("employeeList")!=null){
	employeeList=(List<MasEmployee>)map.get("employeeList");
}
%><div class="titleBg">
<h2>Loan Statement</h2>
</div>
<div class="clear"></div>
<label>From Employee</label> 
<select name="fromempcode" id="empcode1">
<option value="">Select</option>
<%
for(MasEmployee masEmployee:employeeList)
{%>
<option value="<%= masEmployee.getEmployeeCode() %>"><%=masEmployee.getEmployeeCode()%>-<%=masEmployee.getFirstName()%>
	<%=masEmployee.getMiddleName() %> <%=masEmployee.getLastName()%></option>
<%} %>
</select> 
<label>To Employee</label> 
<select name="toempcode" id="empcode2">
<option value="">Select</option>
<%
for(MasEmployee masEmployee:employeeList)
{%>
<option value="<%= masEmployee.getEmployeeCode() %>"><%=masEmployee.getEmployeeCode()%>-<%=masEmployee.getFirstName()%>
<%=masEmployee.getMiddleName() %> <%=masEmployee.getLastName()%></option>
<%} %>
</select>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="print" name="print"	onclick="submitForm('printhrloan','/hms/hrms/report?method=printloanstatement');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

