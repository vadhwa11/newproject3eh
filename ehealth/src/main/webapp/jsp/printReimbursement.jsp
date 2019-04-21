<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hrms.masters.business.HrMasReimbersement"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="printhrEmployee" method="post" action="">
<%Map<String,Object> map =new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map) request.getAttribute("map");
}
List<HrMasReimbersement>reimbursementList=new ArrayList<HrMasReimbersement>();
if(map.get("reimbursementList")!=null){
	reimbursementList=(List<HrMasReimbersement>)map.get("reimbursementList");
}
%> <select name="empId" id="empId">
	<option value="">Select</option>
	<%
    	for(HrMasReimbersement hrMasReimbersement:reimbursementList){
			hrMasReimbersement.getReimbCode();
			hrMasReimbersement.getReimbDesc();
			hrMasReimbersement.getMaxAmount();
			hrMasReimbersement.getTaxable();
				
		%>
	<option value="<%= hrMasReimbersement.getReimbCode() %>"><%=hrMasReimbersement.getReimbDesc()%>
	<%=hrMasReimbersement.getMaxAmount() %> <%=hrMasReimbersement.getTaxable() %></option>

	<%} %>
</select> <input type="button" value="print" name="print"
	onclick="submitForm('printhrEmployee','/hms/hrms/report?method=printReimbursement');" />

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
