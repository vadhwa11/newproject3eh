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
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<%if(kitIssueDetailsList!=null && kitIssueDetailsList.size()>0)
	{%>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  class="center">
	<tr>
		<th scope="col">Sl No.</th>
<th scope="col">Item Name</th>
<th scope="col">Qty Issued</th>
<th scope="col">Select</th>
	</tr>
	<% int j=1;
		for(IpdKitIssueMasterTemplateT kitIssueMasterTemplateT :kitIssueDetailsList ){
			if(kitIssueMasterTemplateT.getStatus().equalsIgnoreCase("y")){
	%>
	<tr>
		<td><%=j%></td>
		<td><input type="text" value="<%=kitIssueMasterTemplateT.getItemName() %>" tabindex="1" id="nomenclature<%=j %>"
			size="100" name="nomenclature<%=j %>"
			onblur="if(this.value!=''){checkForNomenclature(this.value,<%=j %>);}" />
	    <input type="hidden" name="kitIssueDetailsId<%=j %>"  value="0"/>

		<div id="ac2update1" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
		//	  new Ajax.Autocompleter('nomenclature1','ac2update1','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature1'});
			</script>
			
			</td>
			<td id="batchDiv1" style="display: none;">
		<input type="hidden" id="itemId<%=j %>" name="itemId<%=j %>" value="">
		</td>	
		<td>
		  <input type="text" value="<%=kitIssueMasterTemplateT.getAuthQuantity() %>" tabindex="1" id="issueQuantity<%=j %>" size="40"
			name="issueQuantity<%=j %>"></td>
		<td><input type="checkbox" name="kitDetailId<%=j %>" id="kitDetailId<%=j %>"></td>
		<%-- <td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('grid','hdb',this);setIdForDelete('<%=kitIssueMasterTemplateT.getId() %>','');" tabindex="1" />
			</td> --%>
	</tr>
	<%j++;}
			}%>
			</table>
		<input type="hidden" id="deleteKitId" name="deleteKitId" value="">
<input type="hidden" name="hdb" value="<%=j-1 %>" id="hdb" />
			<%
			}
			else
		{
			%>
			<table id="grid" class="cmntable">
	<tbody><tr>		

<th scope="col">Sl No.</th>
<th scope="col">Item Name</th>
<th scope="col">Qty Issued</th>
<th scope="col">Select</th>
	</tr>
	<tr>
		<td>1</td>
		<td><input type="text" value="" tabindex="1" id="nomenclature1" si
			size="100" name="nomenclature1"
			onblur="if(this.value!=''){checkForNomenclature(this.value,1);}" />
	    <input type="hidden" name="kitIssueDetailsId"  value="0"/>

		<div id="ac2update1" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('nomenclature1','ac2update1','inPatientMaster?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature1'});
		</script>
			
			</td>
			<td id="batchDiv1" style="display: none;">
		<input type="hidden" id="itemId1" name="itemId1" value="">
		</td>	
		<td>
		  <input type="text" value="" tabindex="1" id="issueQuantity1" size="40"
			name="issueQuantity1"></td>
		<td><input type="checkbox" name="kitDetailId1" id="kitDetailId1"></td>
		<%-- <td><input type="button" name="delete" value="" class="buttonDel"
			onclick="removeRow('grid','hdb',this);setIdForDelete('<%=kitIssueMasterTemplateT.getId() %>','');" tabindex="1" />
			</td> --%>
	</tr>
	
</tbody></table>
<input type="hidden" name="hdb" value="1" id="hdb" />
			<%
		}%>

