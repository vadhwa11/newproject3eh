<%@page import="jkt.hms.util.HMSUtil"%>
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
Map<String,Object> utilMap = new HashMap<String,Object>();
Map<String,Object> mapForDS= new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");  
String currentTime = (String)utilMap.get("currentTime");
String consultationDate = (String)utilMap.get("currentDate");
String consultationTime = (String)utilMap.get("currentTime");

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
List<RouteOfAdministration>route=new ArrayList<RouteOfAdministration>();
if(map.get("route") != null){
	route = (List<RouteOfAdministration>)map.get("route");
}
List<MasFrequency>frequencyList=new ArrayList<MasFrequency>();
if(map.get("frequencyList") != null){
	frequencyList = (List<MasFrequency>)map.get("frequencyList");
}
List<OpdInstructionTreatment>instrunction=new ArrayList<OpdInstructionTreatment>();
if(map.get("instrunction") != null){
	instrunction = (List<OpdInstructionTreatment>)map.get("instrunction");
}
%>
<%if(template.size()>0){%>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="prescriptionTabGrid">
<tr>
		<th scope="col">&nbsp;</th>
		<th scope="col">Item Name</th>
		<th scope="col">Dosage</th>
		<th scope="col">Unit</th>
		<th scope="col">Frequency</th>
		<th scope="col">No of Days</th>
		<th scope="col">Instruction </th>
		<th scope="col">Route</th>
		<th scope="col">Total</th>
		<th scope="col">Start Date</th>
		<th scope="col">End Date</th>
		<th scope="col">Nursing Care</th>
	</tr>
	<%int incr=0; %>
	<%for(int i=0;i<template.size();i++){
		 OpdTemplateTreatment temp=(OpdTemplateTreatment)template.get(i);
		 Integer itemId=temp.getItem().getId();
		 String pvmsNo=temp.getItem().getPvmsNo();
		 incr =i+1;
		 String str=temp.getItem().getNomenclature()+"("+itemId+")["+pvmsNo+"]";
	%>
	 <tr>
		<td><input type="checkbox" class="radioCheck" id="itemRadiopTab<%=incr%>" name="itemRadiopTab<%=incr%>"  tabindex="31"/></td>
		<td id="nomenclatureDiv<%=incr%>">
		<input  type="text" class="nomeclatureOpdgridText" tabindex="32"	id="nomenclaturepTab<%=incr%>" size="35" name="nomenclaturepTab<%=incr%>" value="<%=str%>"
			<%-- onblur="populatePVMS(this.value,'<%=incr%>');checkItem('<%=incr%>');copyToPrescriptionTAb('<%=incr%>','opconsult');"  --%>/>
		<%-- <div id="ac2updates<%=incr%>" style="display: none;" class="autocomplete"></div> 
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('nomenclature<%=incr%>','ac2updates<%=incr%>','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclature1&counter=<%=incr%>'});
		</script> --%>
		</td>
		<input type="hidden" name="pvmsNopTab<%=incr %>" tabindex="33" id="pvmsNopTab<%=incr %>" value=""	size="10" readonly="readonly" />
		<td><input class="grdTextSmall" type="text" name="dosagepTab<%=incr%>"  id="dosagepTab<%=incr%>" size="10"  maxlength="45" tabindex="34" value="<%=temp.getDosage()%>" onblur="fillValue(this.value,<%=incr%>);"/>
		<div id="testDiv<%=incr%>">
		</div>
		</td><td>
			<input type="text" name="unitpTab<%=incr %>" tabindex="35" class="grdTextSmall" id="unitpTab<%=incr %>" readonly="readonly" size="5" onblur="fillValue(this.value,<%=incr%>);"/>
		</td>
		<td><select style="width:70px;" name="frequencypTab<%=incr%>" id="frequencypTab<%=incr%>"   tabindex="36" onblur="fillValue(this.value,<%=incr%>);" >
			<option value="0">Select</option>
			 <%
				  MasFrequency  masFrequency = new MasFrequency();
			      for(MasFrequency masFrequency2 : frequencyList){
			       int id = masFrequency2.getId();
			       String name = masFrequency2.getFrequencyName();
	          %>
	          	<%if(temp.getFrequency().getId()==id){ %>
				<option value="<%=id %>" selected="selected"><%=name%></option>
				<%}else{ %>
				<option value="<%=id %>" selected="selected"><%=name%></option>
				<%} %>
			<%} %>
		</select>
		</td>
		<td>
			<input type="text" name="noOfDayspTab<%=incr%>"	id="noOfDayspTab<%=incr%>" class="grdTextSmall" size="3" maxlength="3" validate="No Of Days,num,no" tabindex="37" value="<%=temp.getNoofdays()%>"/>
		</td>
		<td><select style="width:70px;" name="instrunctionpTab<%=incr%>" tabindex="38" id="instrunctionpTab<%=incr%>" >
				 <option value="0">Select</option>
				<%
					for(OpdInstructionTreatment instructionTreatment:instrunction)
					{
				       int id = instructionTreatment.getId();
				       String name = instructionTreatment.getOpdInstructionTreatmentName();
		          %>
		          <%if(temp.getOpdInstructionTreatment().getId()==id){ %>
					<option value="<%=id %>" selected="selected"><%=name%></option>
					<%}else{%>
						<option value="<%=id %>" selected="selected"><%=name%></option>
					<%}	%> 
					<%}	%> 
			</select>
			
		</td>
		<td><select name="routepTab<%=incr%>" id="routepTab<%=incr%>" tabindex="39"  style="width:70px;" onblur="fillRouteOnTAb('<%=incr%>');">
					 <option value="0">Select</option>
					<%
					      for(RouteOfAdministration routeOfAdministration : route){
					    	  
					       int id = routeOfAdministration.getId();
					       String name = routeOfAdministration.getRouteName();
			          %>
						<option value="<%=id %>"><%=name%></option>
					<%
					}%>
				</select>
		</td>
		<td><input type="text" name="totalpTab<%=incr%>" id="totalpTab<%=incr%>"  size="5" class="grdTextSmall" validate="Total,num,no" readonly="readonly" tabindex="40"/>
			<input type="hidden" name="pvmsNopTab<%=incr%>" id="pvmsNopTab<%=incr%>" size="10" value=""/>
		</td>
		<td><div style="width:145px;">
			<input size="5" type="text" name="startDate<%=incr%>" class="small"	id="startDate<%=incr%>" validate="startDate<%=incr%>,string,no" readonly="readonly"/>
			<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
				onclick="setdate('<%=currentDate%>',document.opdMain.startDate<%=incr%>,event);" /></div>
		</td>
		<td><div style="width:145px;">
			<input size="5" type="text" name="endDate<%=incr%>" class="small"	id="endDate<%=incr%>" validate="endDate1,string,no" readonly="readonly" />
			<img src="/hms/jsp/images/cal.gif"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.opdMain.endDate<%=incr%>,event);" /></div>
		</td>
		<td><input class="radioCheck" type="checkbox" name="dpStatuspTab<%=incr%>"	id="dpStatuspTab<%=incr%>" tabindex="41" validate="dpStatuspTab<%=incr%>,num,no" onchange="checkpTabDPStatus(<%=incr%>)"/></td>
			
	</tr>
	<%}	%>
	
</table>
<input type="hidden" name="pTabhdb" value="<%=incr%>" id="pTabhdb" />

<%}else{ %>

<table border="0" align="center" cellpadding="0" cellspacing="0" id="prescriptionTabGrid">
	<tr>
		<th scope="col">&nbsp;</th>
		<th scope="col">Item Name</th>
		<th scope="col">Dosage</th>
		<th scope="col">Unit</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. of Days</th>
		<th scope="col">Instruction </th>
		<th scope="col">Route</th>
		<th scope="col">Total</th>
		<th scope="col">Start Date</th>
		<th scope="col">End Date</th>
		<th scope="col">Nursing Care</th>
	</tr>
	<%
		int incr = 1;
	%>
	<tr>
		<td><input type="checkbox" class="radioCheck" id="itemRadiopTab1" name="itemRadiopTab1" /></td>
		<td id="nomenclatureDivpTab<%=incr%>">
		<input  type="text" class=nomeclatureOpdgridText value=""	id="nomenclaturepTab<%=incr%>" size="35" name="nomenclaturepTab<%=incr%>"
			onblur="populatePVMS(this.value,'<%=incr%>');checkItem('<%=incr%>');" />

		<div id="ac2updatespTab<%=incr%>" style="display: none;" class="autocomplete"></div> 
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('nomenclaturepTab<%=incr%>','ac2updatespTab<%=incr%>','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclaturepTab1&counter=<%=incr%>'});
		</script>
		</td>
		<td><input class="grdTextSmall" type="text" name="dosagepTab<%=incr%>" onblur="fillValuepTab(this.value,<%=incr%>);"  id="dosagepTab<%=incr%>" size="10"  maxlength="45"  />
		<div id="testDivpTab<%=incr%>">
		</div>
		</td><td>
	<input type="text" name="unitpTab1" class="grdTextSmall" id="unitpTab1" readonly="readonly" size="5" validate="unit1,string,no" />
		</td>
		<td><select style="width:70px;" name="frequencypTab<%=incr%>" id="frequencypTab<%=incr%>"     onblur="fillValuepTab(this.value,<%=incr%>);" >
			<option value="0">Select</option>
			<%
			      for(MasFrequency masFrequency2 : frequencyList){
			       int id = masFrequency2.getId();
			       String name = masFrequency2.getFrequencyName();
	          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select>
		</td>
		<td>
			<input type="text" name="noOfDayspTab<%=incr%>"	id="noOfDayspTab<%=incr%>" class="grdTextSmall" 	size="3" maxlength="3" validate="No Of Days,num,no"  onblur="fillValuepTab(this.value,<%=incr%>);" />
		</td>
		<td><select style="width:70px;" name="instrunctionpTab<%=incr%>" id="instrunctionpTab<%=incr%>"><option value="0">Select</option>
				<%
					for(OpdInstructionTreatment instructionTreatment:instrunction)
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
		<td>	<select name="routepTab<%=incr%>" id="routepTab<%=incr%>"  style="width:70px;" >
					<option value="0">Select</option>
					<%
					      for(RouteOfAdministration routeOfAdministration : route){
					    	  
					       int id = routeOfAdministration.getId();
					       String name = routeOfAdministration.getRouteName();
			          %>
						<option value="<%=id %>"><%=name%></option>
					<%
					}%>
				</select>
		</td>
		<td><input type="text" name="totalpTab1" id="totalpTab1" class="grdTextSmall" size="5" validate="Total,num,no" readonly="readonly" />
			<input type="hidden" name="pvmsNopTab<%=incr%>" id="pvmsNopTab<%=incr%>" size="10" value=""/>
		</td>
		<td><div style="width:145px;">
			<input size="5" type="text" name="startDate1" class="small"	id="startDate1" validate="startDate1,string,no" readonly="readonly"/>
			<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
				onclick="setdate('<%=currentDate%>',document.opdMain.startDate1,event);" /></div>
		</td>
		<td><div style="width:145px;">
			<input size="5" type="text" name="endDate1" class="small"	id="endDate1" validate="endDate1,string,no" readonly="readonly" />
			<img src="/hms/jsp/images/cal.gif"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.opdMain.endDate1,event);" /></div>
		</td>
		<td><input class="radioCheck" type="checkbox" name="dpStatuspTab1"	id="dpStatuspTab1"/></td>
	</tr>
</table>
 <input type="hidden" name="pTabhdb" value="1" id="pTabhdb" />
<%} %>