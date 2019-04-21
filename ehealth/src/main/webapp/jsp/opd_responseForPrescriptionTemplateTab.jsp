<%@page import="jkt.hms.util.Box"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
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
List<Integer> templatenListNew = new ArrayList<Integer>();

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

Map<Integer,BigDecimal>stockQty=new HashMap<Integer,BigDecimal>();
if(map.get("frequencyList") != null){
	stockQty = (Map<Integer,BigDecimal>)map.get("stockQty");
}


List<MasFrequency>frequencyList=new ArrayList<MasFrequency>();
if(map.get("frequencyList") != null){
	frequencyList = (List<MasFrequency>)map.get("frequencyList");
}
List<OpdInstructionTreatment>instrunction=new ArrayList<OpdInstructionTreatment>();
if(map.get("instrunction") != null){
	instrunction = (List<OpdInstructionTreatment>)map.get("instrunction");
}
List<PatientPrescriptionDetails>ppdList=new ArrayList<PatientPrescriptionDetails>();
if(map.get("ppdList")!=null){
	ppdList=(List<PatientPrescriptionDetails>)map.get("ppdList");
}
Map<Integer,String> itemMap=new HashMap<Integer,String>();
if(ppdList!=null && ppdList.size()>0){
	for(PatientPrescriptionDetails prescriptionDetails:ppdList){
		itemMap.put(prescriptionDetails.getItem().getId(), "Y");
	}
}

Box box=HMSUtil.getBox(request);
int updatedLen = box.getInt("updatedLen") ;
%>
<%if(template.size()>0){%>
<!-- <table border="0" align="center" cellpadding="0" cellspacing="0" id="prescriptionTabGrid">
<tr>
		<th scope="col">&nbsp;</th>
		<th scope="col">Item Name</th>
		<th scope="col">Route</th>
		<th scope="col">Dosage</th>
		<th scope="col">Unit</th>
		<th scope="col">Frequency<span>*</span></th>
		<th scope="col">Days</th>
		<th scope="col">Instruction </th>
		<th scope="col">Special Instruction </th>
		<th scope="col">Total</th>
		<th scope="col"></th>
		<th scope="col">Start Date</th>
		<th scope="col">End Date</th>
	</tr> -->
	<tbody >
	<%int incr=0; %>
	<%for(int i=0;i<template.size();i++){
		 OpdTemplateTreatment temp=(OpdTemplateTreatment)template.get(i);
		 if(!templatenListNew.contains(temp.getItem().getId()))
			{
				templatenListNew.add(temp.getItem().getId());	
			}
			else
			{
				continue;
			}
		 String frequecnyType = null;
		 if(temp.getFrequency()!=null){
			 frequecnyType = temp.getFrequency().getFrequencyType(); 
		 }
		 Integer itemId=0;
		if(temp.getItem()!=null){
			itemId=temp.getItem().getId();	
		}
		 //add by rajat singh
		 if(itemMap!=null && "Y".equalsIgnoreCase(itemMap.get(itemId))){
			 continue;
		 }
		 String pvmsNo=temp.getItem().getPvmsNo();
		 incr =updatedLen-1;
	//	 incr =i;
		 String str=temp.getItem().getNomenclature()+"("+itemId+")["+pvmsNo+"]";
		 String conversionStr="";
		 if(temp.getDuration()!=null){
			 conversionStr=temp.getItem().getItemConversion().getItemUnitName();
		 }
		 String units=temp.getItem().getDispUnit()!=null?temp.getItem().getDispUnit():conversionStr;
		 Integer totals=0;
		 if(temp.getTotal()!=null){
			 totals=temp.getTotal();
		 }
		 
	%>
	 <tr>
		<td>
			<input type="checkbox" class="radioCheck" id="itemRadiopTab<%=incr%>" name="itemRadiopTab<%=incr%>"  tabindex="31"/>
			<input type="hidden" class="radioCheck" id="durationPrescriptionTab<%=incr%>" name="durationPrescriptionTab<%=incr%>" value="<%=temp.getDuration()!=null?temp.getDuration():""%>"/>
			<input type="hidden" name="prescription_availableStatuspTab<%=incr %>"	id="prescription_availableStatuspTab<%=incr %>" value="<%=stockQty.get(itemId)!=null && stockQty.get(itemId).doubleValue()>0?"n":"y" %>"/>
			<input type="hidden" id="parkPrescriptionIds<%=incr%>"	name="parkPrescriptionIds<%=incr%>"	readonly="readonly" /> 
		</td>
		<td id="nomenclatureDiv<%=incr%>">
			<input  type="text" readonly="readonly" class="textYellow largTextBoxOpd" value="<%=str %>"	id="nomenclaturepTab<%=incr%>" size="35" name="nomenclaturepTab<%=incr%>"	onblur="populatePVMSTab(this.value,'<%=incr%>');checkPItem('<%=incr%>');" />
		</td>
		<td>
			<%-- <input type="text" name="routepTab<%=incr %>" tabindex="33" id="routepTab<%=incr %>" value="<%=temp.getRoute()!=null?temp.getRoute().getRouteName():"" %>" class="textYellow opdgridText"	size="10" readonly="readonly" />
			<input type="hidden" name="routepTabId<%=incr %>" tabindex="33" id="routepTabId<%=incr %>" value="<%=temp.getRoute()!=null?temp.getRoute().getId():"" %>" class="textYellow opdgridText"	size="10" readonly="readonly" /> --%>
				
			<select name="routepTab<%=incr%>" id="routepTab<%=incr%>" tabindex="39"  style="width:70px;background: #FFFF99" onblur="fillRouteOnTAb('<%=incr%>');">
					 <option value="0">Select</option>
					<%
					      for(RouteOfAdministration routeOfAdministration : route){
					       int id = routeOfAdministration.getId();
					       String name = routeOfAdministration.getRouteName();
			          %>
							<%if(temp.getRoute()!=null && temp.getRoute().getId()==id){ %>
								<option value="<%=id %>"selected="selected"><%=name%></option>
							<%}else{%>
								<option value="<%=id %>" ><%=name%></option>
							<%}	%> 
					<%
					}%>
				</select> 
		</td>
		<td><input class="textYellow opdTextBoxTSmall" type="text" name="dosagepTab<%=incr%>"  id="dosagepTab<%=incr%>" size="10"  maxlength="45" tabindex="34" value="<%=temp.getDosage()%>" onblur="fillValue(this.value,<%=incr%>);"/>
		</td>
		<td>
			<input type="text" name="unitpTab<%=incr %>" tabindex="35" class="textYellow opdTextBoxTSmall" id="unitpTab<%=incr %>" value="<%=units!=null?units:"" %>" readonly="readonly" size="5" onblur="fillValue(this.value,<%=incr%>);"/>
		</td>
		<td>
			
			<input type="hidden" name="sosQtypTab<%=incr%>" tabindex="1" id="sosQtypTab<%=incr%>"/>
			<select style="width:70px;background: #FFFF99" name="frequencypTab<%=incr%>" id="frequencypTab<%=incr%>"   tabindex="36"onchange="getFrequencyValuepTab(this.value,<%=incr%>);fillValue(this.value,<%=incr%>,'tab');displaySOSQtypTab(this.value,<%=incr%>);displaFrequencyTypeForPrescriptionTab(this,<%=incr%>);"  >
			<option value="0">Select</option>
			 <%int freqCnt = 0;
				  MasFrequency  masFrequency = new MasFrequency();
			      for(MasFrequency masFrequency2 : frequencyList){
			       int id = masFrequency2.getId();
			       String name = masFrequency2.getFrequencyName();
			       String type = masFrequency2.getFrequencyType();
	          %>
	          	<%if(temp.getFrequency()!=null && temp.getFrequency().getId()==id){
	          		freqCnt = temp.getFrequency().getFrequencyCount();
	          		%>
				<option id="<%=type %>" value="<%=id %>" selected="selected"><%=name%></option>
				<%}else{ %>
				<option id="<%=type %>" value="<%=id %>"><%=name%></option>
				<%} %>
			<%} %>
			</select>
			<input type="hidden" name="frequencyValuepTab<%=incr%>" tabindex="1" id="frequencyValuepTab<%=incr%>" value="<%=freqCnt %>"  size="6"   />
		</td>
		<td>
			<div style="width:100px; float: left;">
			<input type="text" name="noOfDayspTab<%=incr%>"	id="noOfDayspTab<%=incr%>"  <%=temp.getDuration()!=null?"readonly":"" %> class="textYellow opdTextBoxTSmall" size="3" maxlength="3" validate="No Of Days,num,no" tabindex="37" value="<%=temp.getNoofdays()%>" onblur="fillValue(this.value,<%=incr%>);setEndDate(this.value,<%=incr %>);"/>
			<p style="line-height:0px;" id="frequencyTypeForPrescriptionTab<%=incr %>" ><%=frequecnyType %></p>
			</div>
		</td>
		<%int instuctionId2=0;
				if(temp.getOpdInstructionTreatment()!=null){
					instuctionId2=temp.getOpdInstructionTreatment().getId();
				  }%>
		<td><select style="width:70px;background: #FFFF99" name="instrunctionpTab<%=incr%>" tabindex="38" id="instrunctionpTab<%=incr%>" >
				 <option value="0">Select</option>
				<%
					for(OpdInstructionTreatment instructionTreatment:instrunction)
					{
				       int id = instructionTreatment.getId();
				       String name = instructionTreatment.getOpdInstructionTreatmentName();
		          %>
		      <%if(instuctionId2==id){ %>
					<option value="<%=id %>" selected="selected"><%=name%></option>
					<%}else{%>
					<option value="<%=id %>"><%=name%></option>
					<%}%>
					<%}	%> 
			</select>
			
		</td>
		<td><input type="text" name="splInstrunctionpTab<%=incr %>"  class="textYellow opdTextBoxSmall" value="<%=temp.getSplInstruction()!=null?temp.getSplInstruction():"" %>" id="splInstrunctionpTab<%=incr %>" maxlength="200" /></td>
		<td><input type="text" name="totalpTab<%=incr%>" id="totalpTab<%=incr%>" value="<%=totals %>" size="5" class="textYellow opdTextBoxTSmall" validate="Total,num,no" readonly="readonly" tabindex="40"/>
			<input type="hidden" name="pvmsNopTab<%=incr%>" id="pvmsNopTab<%=incr%>" size="10" value=""/>
			<input type="hidden" name="actualDispensingQtypTab<%=incr%>" id="actualDispensingQtypTab<%=incr%>"  value="<%=temp.getItem().getADispQty()!=null?temp.getItem().getADispQty():"" %>" />
			<td><input type="text" value="<%=conversionStr %>" class="textYellow opdTextBoxTSmall" readonly="readonly" tabindex="40"/>
		</td>
		<td><div style="width:145px;">
			<input size="5" type="text" name="startDate<%=incr%>" class="textYellow small" value="<%=currentDate%>"	id="startDate<%=incr%>" validate="startDate<%=incr%>,string,no" readonly="readonly"/>
			<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"
				onclick="setdate('<%=currentDate%>',document.opdMain.startDate<%=incr%>,event);" /></div>
		</td>
		<td><div style="width:145px;">
			<input size="5" type="text" name="endDate<%=incr%>" class="textYellow small"	id="endDate<%=incr%>" validate="endDate1,string,no" readonly="readonly" />
			<img src="/hms/jsp/images/cal.gif"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.opdMain.endDate<%=incr%>,event);" /></div>
		</td>
	</tr>
	<% updatedLen++;}	%>
	</tbody>
<!-- </table> -->
<input type="hidden" name="pTabhdb" value="<%=incr%>" id="pTabhdb" />
<input type="hidden" name="hdbTabIndex" id="hdbTabIndex" value="<%=incr-1%>" id="hdbRecordSize" />
<%}//else{ %>
<%--
<!-- 
<table border="0" align="center" cellpadding="0" cellspacing="0" id="prescriptionTabGrid">
	<tr>
		<th scope="col">&nbsp;</th>
		<th scope="col">Item Name</th>
		<th scope="col">Route</th>
		<th scope="col">Dosage</th>
		<th scope="col">Unit</th>
		<th scope="col">Frequency<span>*</span></th>
		<th scope="col">Days</th>
		<th scope="col">Instruction </th>
		<th scope="col">Special Instruction </th>
		<th scope="col">Total</th>
		<th scope="col"></th>
		<th scope="col">Start Date</th>
		<th scope="col">End Date</th>
	</tr> -->
	<tbody>
	<%
		int incr = 0;
	for(;incr<3;incr++){
	%>
	
	<tr>
		<td>
			<input type="checkbox" class="radioCheck" id="itemRadiopTab<%=incr%>" name="itemRadiopTab<%=incr%>" />
			<input type="hidden" name="prescription_availableStatuspTab<%=incr %>"	id="prescription_availableStatuspTab<%=incr %>" />
			<input type="hidden" id="parkPrescriptionIds<%=incr%>"	name="parkPrescriptionIds<%=incr%>"	readonly="readonly" /> 
		</td>
		<td id="nomenclatureDivpTab<%=incr%>">
		<input  type="text" class="textYellow largTextBoxOpd"	id="nomenclaturepTab<%=incr%>" size="35" name="nomenclaturepTab<%=incr%>"
			onblur="checkForAlreadyIssuedPrescribtion(this.value,<%=incr %>);populatePVMS(this.value,'<%=incr%>');checkItem('<%=incr%>');" />

		<div id="ac2updatespTab<%=incr%>" style="display: none;" class="autocomplete"></div> 
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('nomenclaturepTab<%=incr%>','ac2updatespTab<%=incr%>','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclaturepTab<%=incr%>'});
		</script>
		</td>
		<td>	<select name="routepTab<%=incr%>" id="routepTab<%=incr%>"  style="width:70px;background: #FFFF99" >
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
		<td><input class="textYellow opdTextBoxTSmall" type="text" name="dosagepTab<%=incr%>" onblur="fillValue(this.value,<%=incr%>);"  id="dosagepTab<%=incr%>" size="10"  maxlength="45"  />
		
		</td><td>
	<input type="text" name="unitpTab<%=incr%>" class="textYellow opdTextBoxTSmall"  value="" id="unitpTab<%=incr%>" readonly="readonly" size="5" validate="unit<%=incr%>,string,no" />
		</td>
		<td>
		<input type="hidden" name="frequencyValuepTab<%=incr%>" tabindex="1" id="frequencyValuepTab<%=incr%>" value=""  size="6"   />
		<input type="hidden" name="sosQtypTab<%=incr%>" tabindex="1" id="sosQtypTab<%=incr%>" style="display: none;"   size="3" 	maxlength="3" validate="Sos Qty,num,no" />
		<select style="width:70px;background: #FFFF99" name="frequencypTab<%=incr%>" id="frequencypTab<%=incr%>"     onchange="getFrequencyValuepTab(this.value,<%=incr%>);fillValue(this.value,<%=incr%>,'tab');displaySOSQtypTab(this.value,<%=incr%>)"  >
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
			<input type="text" name="noOfDayspTab<%=incr%>"	id="noOfDayspTab<%=incr%>" class="textYellow opdTextBoxTSmall" 	size="3" maxlength="3" validate="No Of Days,num,no"  onblur="fillValue(this.value,<%=incr%>);setEndDate(this.value,<%=incr %>);" />
		</td>
		<td><select style="width:70px;background: #FFFF99" name="instrunctionpTab<%=incr%>" id="instrunctionpTab<%=incr%>"><option value="0">Select</option>
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
		<td><input type="text" name="splInstrunctionpTab<%=incr %>"  class="textYellow opdTextBoxSmall"  id="splInstrunctionpTab<%=incr %>" maxlength="200" /></td>
		<td><input type="text" name="totalpTab<%=incr%>" id="totalpTab<%=incr%>" class="textYellow opdTextBoxTSmall" size="5" validate="Total,num,no" readonly="readonly" />
			<input type="hidden" name="pvmsNopTab<%=incr%>" id="pvmsNopTab<%=incr%>" size="10" value=""/>
			<input type="hidden" name="actualDispensingQtypTab<%=incr%>" id="actualDispensingQtypTab<%=incr%>"   />
			<td><input type="text" class="textYellow opdTextBoxTSmall"  readonly="readonly" tabindex="40"/>
		</td>
		<td><div style="width:145px;">
			<input size="5" type="text" name="startDate<%=incr%>" class="textYellow small"	id="startDate<%=incr%>" validate="startDate<%=incr%>,string,no" readonly="readonly"/>
			<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.opdMain.startDate<%=incr%>,event);" /></div>
		</td>
		<td><div style="width:145px;">
			<input size="5" type="text" name="endDate<%=incr%>" class="textYellow small"	id="endDate<%=incr%>" validate="endDate<%=incr%>,string,no" readonly="readonly" />
			<img src="/hms/jsp/images/cal.gif"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.opdMain.endDate<%=incr%>,event);" /></div>
		</td>
	</tr>
	<%} %>
	</tbody>
<!-- </table> -->
 <input type="hidden" name="pTabhdb" value="<%=incr-1%>" id="pTabhdb" />
 <input type="hidden" name="hdbTabIndex" id="hdbTabIndex" value="<%=incr%>" id="hdbRecordSize" />
<%} %>
--%>


