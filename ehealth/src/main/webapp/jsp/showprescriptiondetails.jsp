<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionDetails"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script src="/hms/jsp/js/opd.js"></script>
<script>jQuery.noConflict();</script>

<%

List<InpatientPrescriptionDetails>  inPatientPrescriptionList = new ArrayList<InpatientPrescriptionDetails>();

Map<String,Object> map = new HashMap<String,Object>();
	String detailId ="";
	String opOrString ="";
	
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
if(map.get("inPatientPrescriptionList") != null)	{
	inPatientPrescriptionList = (List<InpatientPrescriptionDetails>)map.get("inPatientPrescriptionList");
}
%>
<h4>Prescription Details</h4>
<div class="clear"></div>
<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
<tr>
<th scope="col">Item Name</th>
<th scope="col">Dosage</th>
<th scope="col">Unit</th>
<th scope="col">Frequency</th>
<!-- <th scope="col">No Of Days</th> -->
<th scope="col">Duration</th>
<th scope="col">Instruction</th>
<th scope="col" >Special Instruction</th>
<th scope="col" >Route</th>
<th scope="col">Total</th>
</tr>
<%for(InpatientPrescriptionDetails details:inPatientPrescriptionList)
{ %>
<tr>
<td>
<%=details.getItem().getNomenclature() %>
</td>
<td>
<%=details.getDosage() %>
</td>
<td>
<%if(details.getItem()!=null && details.getItem().getItemConversion()!=null && details.getItem().getItemConversion().getIssueUnit()!=null){ %>
	<%=details.getItem().getItemConversion().getIssueUnit().getUnitName()%>
<%} %>
</td>
<td> <%=details.getFrequency()!=null ?details.getFrequency().getFrequencyName():""%>
</td>

<td>
<%=details.getNoOfDays()+" "+details.getFrequency().getFrequencyType()%>
</td>
<td>
<%=details.getInsrtuction()!=null?details.getInsrtuction().getOpdInstructionTreatmentName():"" %>
</td>
<td><%=details.getSplInstruction()!=null?details.getSplInstruction():"" %>
</td>
<td>
<%=details.getRoute()!=null?details.getRoute().getRouteName():"" %>
</td>
<td>
<%=details.getTotal() %>
</td>
</tr>
<%}
%>
</table>
</div>