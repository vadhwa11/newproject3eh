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
List<OpdTemplateTreatment> template = new ArrayList<OpdTemplateTreatment>();
if(map.get("template") != null){
	template = (List<OpdTemplateTreatment>)map.get("template");
}
Integer from=0;
if(map.get("from") != null){
	from = (Integer)map.get("from");
}
List<RouteOfAdministration> routeOfAdministrationList=new ArrayList<RouteOfAdministration>();
if(map.get("route") != null){
	routeOfAdministrationList = (List<RouteOfAdministration>)map.get("route");
}
List<MasFrequency>frequencyList=new ArrayList<MasFrequency>();
if(map.get("frequencyList") != null){
	frequencyList = (List<MasFrequency>)map.get("frequencyList");
}
List<OpdInstructionTreatment> masInstructionMasterList=new ArrayList<OpdInstructionTreatment>();
if(map.get("instrunction") != null){
	masInstructionMasterList = (List<OpdInstructionTreatment>)map.get("instrunction");
}
%>
<%if(template.size()>0){ %>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  >
<tr>
		<th scope="col">&nbsp;</th>
		 <th scope="col">Item Name</th>
		<th scope="col">Dosage</th>
		<th scope="col">Unit</th>
		<th scope="col">Frequency</th>
		<th scope="col">No Of Days</th>
		<th scope="col">Instruction</th>
		<th scope="col" >Special Instruction</th>
		<th scope="col">Route</th>
		<th scope="col">Total</th>
	</tr>
	<%int l=0; %>
	<%for(int i=0;i<template.size();i++){
		 OpdTemplateTreatment temp=(OpdTemplateTreatment)template.get(i);
		 Integer itemId=temp.getItem().getId();
		 String pvmsNo=temp.getItem().getPvmsNo();
		 l =l+1;
		 String str=temp.getItem().getNomenclature()+"("+itemId+")["+pvmsNo+"]";
	%>
	 <tr>
	<td>
	    <input type="checkbox"  tabindex="1" id="itemRadiotreatment<%=l %>"  name="itemRadiotreatment<%=l %>" class="radioCheck"  />
	    </td>
		<td>
	    <input type="text" size="30" value="<%=str %>" tabindex="1" id="nomenclaturetreatment<%=l %>" size="70"  name="nomenclaturetreatment<%=l %>"
	     onblur="populatePVMS(this.value,'<%=l %>');checkItem('<%=l %>'), displayAu(this.value,'<%=l %>')"   />
	     
	   	<div id="ac2updatetreatment<%=l %>" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclaturetreatment<%=l %>','ac2updatetreatment<%=l %>','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclaturetreatment<%=l %>'});
			</script>
	    </td>
		<td><input type="hidden" name="pvmsNotreatment<%=l %>" tabindex="1" id="pvmsNotreatment<%=l %>" value="<%=pvmsNo %>"	size="10" readonly="readonly" />
		<input type="text" name="dosagetreatment<%=l %>" tabindex="1" value="<%=temp.getDosage()!=null?temp.getDosage():"" %>" id="dosagetreatment<%=l %>"	
		size="2" maxlength="5" onblur="fillTotalForTreatment('<%=l %>');" /></td>
		<td><input type="text" size="2" name="unittreatment<%=l %>" readonly="readonly" id="unittreatment<%=l %>" value="" class="smallest" />
		</td>
		<td><select name="frequencytreatment<%=l %>" id="frequencytreatment<%=l %>"  tabindex="1" onchange="fillTotalForTreatment('<%=l %>');" onblur="fillTotalForTreatment('<%=l %>');" >
			<option value="0">Select</option>
			<%
		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			 <%if(temp.getFrequency()!=null && masFrequency.getId()==temp.getFrequency().getId()) 
          {
          %>
          			<option value="<%=id %>" selected="selected" ><%=name%></option>
          
          <%}else{ %>
			<option value="<%=id %>"><%=name%></option>
			<%
			}%>
			<%}%>
		</select> 
		
		</td>
		
		
		<td><input type="text" class="smallest" name="noOfDaystreatment<%=l %>" tabindex="1" id="noOfDaystreatment<%=l %>" 
		value="<%=temp.getNoofdays()!=null?temp.getNoofdays():"" %>" onblur="fillTotalForTreatment('<%=l %>');"  size="2"	maxlength="3" validate="No. of Days,num,no" />
			
		</td>
		
		<td><select name="instructiontreatment<%=l %>" id="instructiontreatment<%=l %>" class="smallest" tabindex="1"  >
			<option value="0">Select</option>
			<%
			for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
			{

		       int id = instructionTreatment.getId();
		       String name = instructionTreatment.getOpdInstructionTreatmentName();

          %>
			 <%if(temp.getOpdInstructionTreatment()!=null && instructionTreatment.getId()==temp.getOpdInstructionTreatment().getId()) 
          {
          %>
          			<option value="<%=id %>" selected="selected" ><%=name%></option>
          
          <%}else{ %>
			<option value="<%=id %>"><%=name%></option>
			<%
			}%>
			<%
			}%>
			
		</select> 
		
		</td>
		
		<td><input type="text" name="spslinstructiontreatment<%=l %>" tabindex="1" id="spslinstructiontreatment<%=l %>" value=""  size="15"	maxlength="50"  />
			
		</td>
		
		<td><select name="routetreatment<%=l %>" id="routetreatment<%=l %>" class="smallest" tabindex="1"  >
			<option value="0">Select</option>
			<%
				for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
		    	  
		       int id = routeOfAdministration.getId();
		       String name = routeOfAdministration.getRouteName();
		      
          %>
          <%if(temp.getRoute()!=null && routeOfAdministration.getId()==temp.getRoute().getId()) 
          {
          %>
          			<option value="<%=id %>" selected="selected" ><%=name%></option>
          
          <%}else{ %>
			<option value="<%=id %>"><%=name%></option>
			<%
			}%>
			<%
			}%>
		</select> 
		
		</td>
		
		<td><input type="text" class="smallest" name="totaltreatment<%=l %>" 
		tabindex="1" id="totaltreatment<%=l %>" value="<%=temp.getTotal()!=null?temp.getTotal():"" %>" onblur="fillTotalForTreatment('<%=l %>')"  size="2"	maxlength="3" validate="Total,num,no" readonly="readonly" />
			
		</td>		
	</tr>
	<%}	%>
	
</table>
	<input type="hidden" name="hdb" value="<%=l %>" id="hdbtreatment" />
<%}else{ %>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  >
	<tr>
		<th scope="col">&nbsp;</th>
		 <th scope="col">Item Name</th>
		<th scope="col">Dosage</th>
		<th scope="col">Unit</th>
		<th scope="col">Frequency</th>
		<th scope="col">No Of Days</th>
		<th scope="col">Instruction</th>
		<th scope="col" >Special Instruction</th>
		<th scope="col">Route</th>
		<th scope="col">Total</th>
	</tr>
	<%
		int l = 1;
	%>
	<tr>
	<td>
	    <input type="checkbox"  tabindex="1" id="itemRadiotreatment<%=l %>"  name="itemRadiotreatment<%=l %>" class="radioCheck"  />
	    </td>
		<td>
	    <input type="text" size="30" value="" tabindex="1" id="nomenclaturetreatment<%=l %>" size="70"  name="nomenclaturetreatment<%=l %>" onblur="populatePVMS(this.value,'<%=l %>');checkItem('<%=l %>'), displayAu(this.value,'<%=l %>')"  />
	   	<div id="ac2updatetreatment<%=l %>" style="display:none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclaturetreatment<%=l %>','ac2updatetreatment<%=l %>','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclaturetreatment<%=l %>'});
			</script>
	    </td>
		<td><input type="hidden" name="pvmsNotreatment<%=l %>" tabindex="1" id="pvmsNotreatment<%=l %>" value=""	size="10" readonly="readonly" />
		<input type="text" name="dosagetreatment<%=l %>" tabindex="1" value="" id="dosagetreatment<%=l %>"	size="2" maxlength="5" onblur="fillTotalForTreatment('<%=l %>');" /></td>
		<td><input type="text" size="2" name="unittreatment<%=l %>" readonly="readonly" id="unittreatment<%=l %>" value="" class="smallest" />
		</td>
		<td><select name="frequencytreatment<%=l %>" id="frequencytreatment<%=l %>"  tabindex="1" onchange="fillTotalForTreatment('<%=l %>');" onblur="fillTotalForTreatment('<%=l %>');" >
			<option value="0">Select</option>
			<%
		      for(MasFrequency masFrequency : frequencyList){
		       int id = masFrequency.getId();
		       String name = masFrequency.getFrequencyName();
          %>
			<option value="<%=id %>"><%=name%></option>
			<%}%>
		</select> 
		
		</td>
		
		
		<td><input type="text" class="smallest" name="noOfDaystreatment<%=l %>" tabindex="1" id="noOfDaystreatment<%=l %>" value="" onblur="fillTotalForTreatment('<%=l %>');"  size="2"	maxlength="3" validate="No. of Days,num,no" />
			
		</td>
		
		<td><select name="instructiontreatment<%=l %>" id="instructiontreatment<%=l %>" class="smallest" tabindex="1"  >
			<option value="0">Select</option>
			<%
			for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
			{

		       int id = instructionTreatment.getId();
		       String name = instructionTreatment.getOpdInstructionTreatmentName();

          %>
			<option value="<%=id %>"><%=name%></option>
			<%
			}
			%>
			
		</select> 
		
		</td>
		
		<td><input type="text" name="spslinstructiontreatment<%=l %>" tabindex="1" id="spslinstructiontreatment<%=l %>" value=""  size="15"	maxlength="50"  />
			
		</td>
		
		<td><select name="routetreatment<%=l %>" id="routetreatment<%=l %>" class="smallest" tabindex="1"  >
			<option value="0">Select</option>
			<%
				for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
		    	  
		       int id = routeOfAdministration.getId();
		       String name = routeOfAdministration.getRouteName();
		      
          %>
			<option value="<%=id %>"><%=name%></option>
			<%
			}%>
		</select> 
		
		</td>
		
		<td><input type="text" class="smallest" name="totaltreatment<%=l %>" tabindex="1" id="totaltreatment<%=l %>" value="" onblur="fillTotalForTreatment('<%=l %>')"  size="2"	maxlength="3" validate="Total,num,no" readonly="readonly" />
			
		</td>
		
		
	</tr>
</table>
	<input type="hidden" name="hdb" value="<%=l %>" id="hdbtreatment" />
<%} %>