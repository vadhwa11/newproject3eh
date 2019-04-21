<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>

<%@page import="jkt.hms.masters.business.IpdKitIssueMasterTemplateT"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.IpdKitIssueMasterTemplateM"%>
<div class="Clear"></div>
<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
List<IpdKitIssueMasterTemplateT> kitIssueDetailsList = new ArrayList<IpdKitIssueMasterTemplateT>();
if(map.get("kitIssueDetailsList")!=null){
	kitIssueDetailsList = (List<IpdKitIssueMasterTemplateT>)map.get("kitIssueDetailsList");
}
IpdKitIssueMasterTemplateM kitIssueMasterTemplateM = new IpdKitIssueMasterTemplateM();
if(kitIssueDetailsList.size() > 0){
	kitIssueMasterTemplateM =  kitIssueDetailsList.get(0).getTemplate();
}
%>



<input type="hidden" name="kitIssueMasterId" value="<%= kitIssueMasterTemplateM.getId()%>"/>
<div class="Block">
<label >Template Name</label><input type="text" name="templateName" value="<%=kitIssueMasterTemplateM.getTemplateName() %>" id="templateName" maxlength="30" />
<div class="Clear"></div>

<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<div style="float: right;">
	<input name="Button" type="button" class="buttonAdd" value=""
			onclick="addRow();" tabindex="1" />
	<input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('grid','hdb',this);" tabindex="1" />
		</div>
		<div class="clear"></div>
		<div class="paddingTop15"></div>
	<div class="clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
	<th>Sl No.</th>
		<th >Nomenclature</th>
		<th>Auth. Qty</th>
		<th>Select</th>
		
	</tr>
	<% int j=1;
		for(IpdKitIssueMasterTemplateT kitIssueMasterTemplateT :kitIssueDetailsList ){
			if(kitIssueMasterTemplateT.getStatus().equalsIgnoreCase("y")){
	%>
	<tr>
		<td><%=j %></td>
		<td><input type="text" value="<%=kitIssueMasterTemplateT.getItemName() %>" tabindex="1" id="nomenclature<%=j %>"
			size="100" name="nomenclature<%=j %>"
			onblur="if(this.value!=''){checkForNomenclature(this.value,<%=j %>);}" />
	    <input type="hidden" name="kitIssueDetailsId<%=j %>"  value="<%=kitIssueMasterTemplateT.getId() %>"/>

		<div id="ac2update1" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
		//	  new Ajax.Autocompleter('nomenclature1','ac2update1','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature1'});
			</script>
			
			</td>
			<td id="batchDiv1" style="display: none;">
		<input type="hidden" id="itemId<%=j %>" name="itemId<%=j %>" value="">
		</td>	
		<td>
		  <input type="text" value="<%=kitIssueMasterTemplateT.getAuthQuantity() %>" tabindex="1" id="authQuantity<%=j %>" size="60"
			name="authQuantity<%=j %>"></td>
		<td><input type="checkbox" name="radio<%=j %>" id="radio<%=j %>"></td>
	</tr>
	<%j++;}
			}%>
</table>
		<input type="hidden" id="deleteKitId" name="deleteKitId" value="">
<input type="hidden" name="hdb" value="<%=j-1 %>" id="hdb" />

<div class="clear"></div>
<div class="clear"></div>
		<div class="paddingTop15"></div>
	<div class="clear"></div>
	
<input type="button" name="Submit1" value="Submit" class="button"
	tabindex="1" onclick="submitForm('showKitIssue','/hms/hms/inPatientMaster?method=updateKitIssueMasterDetails')" />
<input type="reset" name="Reset" value="Reset" class="button"
	tabindex="1" onClick="submitForm('showKitIssue','/hms/hms/inPatientMaster?method=showKitIssueJsp')"  accesskey="r" />
	
<%
if(kitIssueMasterTemplateM.getStatus().equalsIgnoreCase("y")){
%>
<input type="button" name="Submit1" value="Inactivate" class="button"
	tabindex="1" onclick="submitForm('showKitIssue','/hms/hms/inPatientMaster?method=deleteKitIssueTemplate&flag=inactive')" />
<%}else{
%>
<input type="button" name="Submit1" value="Activate" class="button"
	tabindex="1" onclick="submitForm('showKitIssue','/hms/hms/inPatientMaster?method=deleteKitIssueTemplate&flag=active')" />
<%} %>

<div class="clear"></div>
		<div class="paddingTop15"></div>
	<div class="clear"></div>
	<div class="clear"></div>
		<div class="paddingTop15"></div>
	<div class="clear"></div>
</div>
	
	
	