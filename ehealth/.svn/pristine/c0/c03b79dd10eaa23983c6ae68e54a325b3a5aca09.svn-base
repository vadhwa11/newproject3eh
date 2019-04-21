<%@page import="jkt.hms.masters.business.OpdTemplateInvestigation"%>
<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasNursingCare"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<OpdTemplateInvestigation>tempInvestigation=new ArrayList<OpdTemplateInvestigation>();
if(map.get("template") != null){
	tempInvestigation = (List<OpdTemplateInvestigation>)map.get("template");
}
Integer hinId=null;
if(map.get("hinId") != null){
	hinId = (Integer)map.get("hinId");
}
System.out.println("hinIdhinIdhinIdhinId "+hinId);
%>

<%
int inc=0;
if(tempInvestigation.size()>0){ %>
		<table border="0" align="center" cellpadding="0" cellspacing="0" id="investigationGrid">
			<tr>
	<th scope="col">&nbsp; </th>
		<th scope="col">Test Name </th>
		<th scope="col">Clinical Note</th>
	</tr>
			<%for(int i=0;i<tempInvestigation.size();i++){
				OpdTemplateInvestigation temp=(OpdTemplateInvestigation)tempInvestigation.get(i);
				 Integer chargeId=temp.getChargeCode().getId();
				 String chargeCodeName=temp.getChargeCode().getChargeCodeName();
				 String str=chargeCodeName+"["+chargeId+"]";
				 String cNotes=temp.getClinicalNotes();
			%>
	
<%inc++; %>

<tr>
		<td>
		<input type="checkbox"  class="radioCheck"  tabindex="1" id="investigationtradio<%=inc %>" size="70"  name="investigationtradio<%=inc %>" /></td>
		<td>
		<input type="text" value="<%=str %>" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="40" name="chargeCodeName<%=inc %>" 
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2<%=inc %>" style="display: none;" class="autocomplete">
		</div>
		
		<script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update2<%=inc%>','opd?method=getInvestigationListForAutoComplete',{minChars:3,
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>&fromOpd=fromOpd'});
				</script>
		<%-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update2<%=inc%>','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> --%> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty<%=inc %>"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode<%=inc %>" name="chargeCode<%=inc %>"
			size="10" readonly value="<%=chargeId%>" /> 

		</td>
		<td><input type="text" name="chargecodeclinicalnote<%=inc %>"  id="chargecodeclinicalnote<%=inc%>" value="<%=cNotes!=null?cNotes:""%>" /></td>
	</tr>

			<%}	%>
		</table>
		<input type="hidden" value="<%=inc %>" name="hiddenValue" id="hiddenValue" />
<%}else{ %>
		<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
	<th scope="col">&nbsp; </th>
		<th scope="col">Test Name </th>
		<th scope="col">Clinical Note</th>
	</tr>
<%inc++; %>

<tr>
		<td>
		<input type="checkbox"  class="radioCheck"  tabindex="1" id="investigationtradio<%=inc %>" size="70"  name="investigationtradio<%=inc %>" /></td>
		<td>
		<input type="text" value="" tabindex="1" 
			id="chargeCodeName<%=inc %>" size="40" name="chargeCodeName<%=inc %>"
			onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){checkForChargeCode(this.value,'<%=inc %>','chargeCodeVal');}" />
		<div id="ac2update2<%=inc %>" style="display: none;" class="autocomplete">
		</div>
		
		<script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update2<%=inc%>','opd?method=getInvestigationListForAutoComplete',{minChars:3,
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>&fromOpd=fromOpd'});
				</script>
		<%-- <script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update2<%=inc%>','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCodeName<%=inc %>'});
				</script> --%> <input type="hidden" id="qty<%=inc %>" tabindex="1" name="qty<%=inc %>"
			size="10" maxlength="6" validate="Qty,num,no" /> <input
			type="hidden" tabindex="1" id="chargeCode<%=inc %>" name="chargeCode<%=inc %>"
			size="10" readonly /> 

		</td>
		<td><input type="text" name="chargecodeclinicalnote<%=inc %>"  id="chargecodeclinicalnote<%=inc%>" value="" /></td>
	</tr>

</table>
	<input type="hidden" value="<%=inc %>" name="hiddenValue" id="hiddenValue" />
<%} %>