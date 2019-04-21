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
<%@page import="jkt.hms.util.HMSUtil"%>
<%Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
List<OpdTemplateInvestigation>tempInvestigation=new ArrayList<OpdTemplateInvestigation>();
if(map.get("template") != null){
	tempInvestigation = (List<OpdTemplateInvestigation>)map.get("template");
}
Map<Integer,String>availableStatus=new HashMap<Integer, String>();
if(map.get("availableStatus") != null){
	availableStatus = (Map<Integer,String>)map.get("availableStatus");
}

Integer hinId=null;
if(map.get("hinId") != null){
	hinId = (Integer)map.get("hinId");
}

boolean medicineDepartment = false;;
if(map.get("departmentCode") != null){
	String departmentCode = (String)map.get("departmentCode");
	if(departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeGeneralMedicine")) || departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodeOrthopadics")) || departmentCode.equals(HMSUtil.getValuesFromPropertiesFile("adt.properties", "deptCodePsychiatry")))
			medicineDepartment = true;
}
List<Integer> templatenListNew = new ArrayList<Integer>();

%>
<%if(tempInvestigation.size()>0){ %>
		<table style="width: 100%; border-top: solid 1px #C0C0C0" id="investigationGrid">
				<tr>
					<th style="background: #bdd6ee; padding: 0px;">&nbsp;</th>
					<th style="background: #bdd6ee; text-align: center; padding: 0px;">Test
						Name</th>
				</tr>
			<%int inc=0; %>
			<%for(int i=0;i<tempInvestigation.size();i++){
				 OpdTemplateInvestigation temp=(OpdTemplateInvestigation)tempInvestigation.get(i);
				 if(!templatenListNew.contains(temp.getChargeCode().getId()))
					{
						templatenListNew.add(temp.getChargeCode().getId());	
					}
					else
					{
						continue;
					}
				 Integer chargeId=temp.getChargeCode().getId();
				 String chargeCodeName=temp.getChargeCode().getChargeCodeName();
				 String str=chargeCodeName+"["+chargeId+"]";
				 String cNotes=temp.getClinicalNotes();
				 String avlStatus="";
				 if(availableStatus.get(chargeId)!=null&&availableStatus.get(chargeId).equals("av")){
				 	avlStatus="av";
				  }else{
					 avlStatus="nav";  
				  }
				 System.out.print("jhj"+availableStatus.size() +" n="+avlStatus);
			%>
			<tr>
				<td>
					<%-- <input type="checkbox" class="radioCheck" name="chargeRadio<%=inc %>" id="chargeRadio<%=inc %>" /> --%>
					<input type="hidden" name="availableStatus<%=inc %>" id="availableStatus<%=inc %>" value="<%= avlStatus%>" />
					<input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowForOpdLite(this,'investigation');"> 
				</td>
				<td>
				<input   type="text" style="width: 237px;<%=avlStatus.equals("nav")?"color:red;":""%>" class="popper chargeCodeName" value="<%=str %>" title="<%=str %>" id="chargeCodeName<%=inc %>" size="65" name="chargeCodeName<%=inc %>" style="width: 672px;"
				onblur="if(validateInvestigationAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCode&hinId=<%=hinId%>&rowVal=<%=inc %>','chargeCodeVal<%=inc %>');}"/>
				<div id="ac2update<%=inc %>" style="display: none;" class="autocomplete"></div>
				<script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update<%=inc %>','opd?method=getInvestigationListForAutoComplete',{minChars:3,
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName1&fromOpd=fromOpd'});
				</script>
				<input type="text" name="clinicalNotes<%=inc %>" 
													class="opdTextBoxSmall textYellow" style="display: none;"
													id="clinicalNotes<%=inc %>" size="20" maxlength="45" />
				</td>	
				 <%-- <%if(!medicineDepartment){%>
				<td><input type="input"  class="largTextBoxOpd textYellow" type="text" name="snomedTermsInv<%=inc %>" id="snomedTermsInv<%=inc %>" /></td>
				<td><input type="text" name="clinicalNotes<%=inc %>"  class="opdTextBoxSmall textYellow"  id="clinicalNotes<%=inc %>" value="<%=cNotes%>" /></td>
				<%}%> --%>
			</tr>
			<% inc++;}	%>
		</table>
		<input type="hidden" value="<%=inc %>" name="hiddenValue" id="hiddenValue" />
<%}else{ %>
		<table style="width: 100%; border-top: solid 1px #C0C0C0" id="investigationGrid">
				<tr>
					<th style="background: #bdd6ee; padding: 0px;">&nbsp;</th>
					<th style="background: #bdd6ee; text-align: center; padding: 0px;">Test
						Name</th>
				</tr>
			<%	int inc=0;
				for(;inc<3;inc++){
				%> 
				<tr>
				<td>
					<input type="hidden" name="availableStatus<%=inc %>" id="availableStatus<%=inc %>" />
					<input class="delButSmll" alt="Delete" value="&nbsp;" type="button" onclick="removeRowForOpdLite(this,'investigation');"> 
				</td>	
				<td>
				<input type="text" style="width: 237px;" class="popper chargeCodeName" value="" id="chargeCodeName<%=inc %>" size="65" name="chargeCodeName<%=inc %>" 
				onblur="getUnavailableInvestigation(<%=inc %>);checkInvestigationItem(<%=inc %>);getLoincSnomedList(<%=inc %>);if(validateInvestigationAutoComplete(this.value,'<%=inc %>'))
				{submitProtoAjaxWithDivName('opdMain','/hms/hms/opd?method=fillChargeCode&hinId=<%=hinId%>&rowVal=<%=inc %>','chargeCodeVal<%=inc %>');}" onkeypress="checkTextColor('chargeCodeName<%=inc %>');"/>
				<div id="ac2update<%=inc %>" style="display: none;" class="autocomplete"></div>
				<script type="text/javascript" language="javascript" charset="utf-8">
						  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update<%=inc %>','opd?method=getInvestigationListForAutoComplete',{minChars:3,
							  callback: function(element, entry) {
						            return entry + '&labradiologyCheck=' + document.getElementById('investigationCategory').value;
						        },
							  parameters:'requiredField=chargeCodeName<%=inc %>&fromOpd=fromOpd'});
				</script>
				<input type="text" name="clinicalNotes<%=inc %>" 
													class="opdTextBoxSmall textYellow" style="display: none;"
													id="clinicalNotes<%=inc %>" size="20" maxlength="45" />
				</td>
				<%-- <%if(!medicineDepartment){%>
				<td><input type="input"  class="largTextBoxOpd textYellow" type="text" name="snomedTermsInv<%=inc %>" id="snomedTermsInv<%=inc %>" /></td>
				 <td><input type="text" name="clinicalNotes<%=inc %>"  class="opdTextBoxSmall textYellow"  id="clinicalNotes<%=inc %>" size="20" maxlength="45" /></td>
				 <%} %> --%>
			</tr>
		<%}%> 
		</table>
		<input type="hidden" value="<%=inc %>" name="hiddenValue" id="hiddenValue" />
<%} %>