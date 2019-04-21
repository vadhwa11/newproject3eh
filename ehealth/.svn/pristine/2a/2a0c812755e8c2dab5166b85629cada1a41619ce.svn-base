<%@page import="jkt.hms.masters.business.DgSubMasInvestigation"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
}
List<DgSubMasInvestigation> subInvestigationList = new ArrayList<DgSubMasInvestigation>();
if(map.get("subInvestigationList") != null){
	subInvestigationList = (List)map.get("subInvestigationList");
}
int inc = 0;
if(map.get("rowVal") != null){
	inc = (Integer)map.get("rowVal");
}

%>
<script type="text/javascript">
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';

</script>
<%if(subInvestigationList.size()>0){ %>
<input type="hidden" class="largTextBoxOpd textYellow" type="text" name="subInvInc" id="subInvInc" value="<%=subInvestigationList.size()%>" />
<script>

document.getElementById('testResult<%=inc%>').style.display = "none";
document.getElementById('resultStatus<%=inc%>').style.display = "none";

</script>

<td>&nbsp;</td>
<td>&nbsp;</td> 
<td>&nbsp;</td> 
<td colspan="2">
<table border="0" align="center" cellpadding="0" cellspacing="0" style="border-top:1px solid #C0C0C0;">

<%
int k = 0,ii=0;
	for(DgSubMasInvestigation dgMasInvestigation : subInvestigationList){
		inc++;
		
%>

<tr>


<td style="width:312px;"><%=dgMasInvestigation.getSubInvestigationName() != null?dgMasInvestigation.getSubInvestigationName():"" %>
<input type="hidden" class="radioCheck" name="chargeRadioDermotology<%=inc %>" id="chargeRadioDermotology<%=inc %>" value="" /> 
<input type="hidden" class="largTextBoxOpd textYellow" type="text" name="chargeCodeNameDermotology<%=inc %>" id="chargeCodeNameDermotology<%=inc %>" value="<%=dgMasInvestigation.getSubInvestigationName()%>" />
<input type="hidden" class="largTextBoxOpd textYellow" type="text" name="subInvestigationId<%=inc %>" id="subInvestigationId<%=inc %>" value="<%=dgMasInvestigation.getId()%>" />
<input type="hidden" class="largTextBoxOpd textYellow" type="text" name="investigationType<%=inc %>" id="investigationType<%=inc %>" value="<%=dgMasInvestigation.getInvestigation().getInvestigationType()%>" /></td>
<td><input type="text" class="largTextBoxOpd textYellow" type="text" name="testResult<%=inc %>" id="testResult<%=inc %>" /></td>
<%-- <td> <input type="checkbox" class="radioCheck" value="y" name="resultStatus<%=inc %>" id="resultStatus<%=inc %>" /> </td> --%>

</tr>
<script>document.getElementById('hiddenValueDermotology').value= '<%=inc%>';</script>
<%ii++;}%>
</table>
<input type="hidden" class="largTextBoxOpd textYellow" type="text" name="parameterSize" id="parameterSize" value="<%=ii%>" />
</td>
<td valign="top">
<table border="0" align="center" cellpadding="0" cellspacing="0" style="border-top:1px solid #C0C0C0;">
<%
int indexStatus = 0;
	for(DgSubMasInvestigation dgMasInvestigation : subInvestigationList){
		indexStatus++;
		
%>
<tr>
<td><input type="checkbox" class="radioCheck" value="y" name="resultStatus<%=indexStatus %>" id="resultStatus<%=indexStatus %>" style="margin:4px 0px 5px 0px;"></td>
</tr>
<%} %>
</table>
</td>
<%k++;}%>
