<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
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
List<String> itemStatusList=new ArrayList<String>();
if(map.get("stockStatusList")!=null){
	itemStatusList=(List<String>)map.get("stockStatusList");
}
%>
<%if(template.size()>0){ %>
<!-- <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  >
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
	</tr> --> 
	<tbody >
	<%
		int incr=0;
		int inxRow=0;System.out.println("itemMap "+itemMap.size());
		for(int i=0;i<template.size();i++){
		 OpdTemplateTreatment temp=(OpdTemplateTreatment)template.get(i);
			if(!templatenListNew.contains(temp.getItem().getId()))
			{
				templatenListNew.add(temp.getItem().getId());	
			}
			else
			{
				continue;
			}
		 Integer itemId=temp.getItem().getId();
		 String frequecnyType = temp.getFrequency().getFrequencyType();
		 //add by rajat Singh
		 String treatTemplteId=temp.getId().toString();
		/* if(itemMap!=null && "Y".equalsIgnoreCase(itemMap.get(itemId))){
			 continue;
		 }*/
		 String pvmsNo=temp.getItem().getPvmsNo();
		 incr =updatedLen-1;
		 String str=temp.getItem().getNomenclature()+"("+itemId+")["+pvmsNo+"]";
		 String units="";
		 String conversionStr="";
		 
		 if(temp.getItem().getItemConversion()!=null){
			// conversionStr=temp.getItem().getItemConversion().getItemUnitName(); changed by govind on 13-09-2017
			 conversionStr=temp.getItem().getDispUnit()!=null?temp.getItem().getDispUnit():"";
			 if(conversionStr==""){
				 conversionStr=temp.getItem().getItemConversion()!=null?temp.getItem().getItemConversion().getItemUnitName():"";
			 }
		 }
		 units=temp.getItem().getDispUnit()!=null?temp.getItem().getDispUnit():conversionStr;
		 Integer totals=0;
		 if(temp.getTotal()!=null){
			 totals=temp.getTotal();
		 }
		 String duration="";
		
		 if(temp.getDuration()!=null){
			 duration=temp.getDuration();
		 }
	%>
	 <tr>
		<td>
			<input type="checkbox" class="radioCheck" id="itemRadio<%=incr%>" name="itemRadio<%=incr%>"  onchange="checkPrescriptionCheck(<%=incr %>)"  tabindex="31"/>
			<input type="hidden" class="radioCheck" id="durationPrescription<%=incr%>" name="durationPrescription<%=incr%>" value="<%=temp.getDuration()!=null?temp.getDuration():""%>"/>
			<input type="hidden" name="prescription_availableStatus<%=incr %>"	id="prescription_availableStatus<%=incr %>"/>
		</td>
		<td id="nomenclatureDiv<%=incr%>">
		<input  type="text" class="textYellow largTextBoxOpd" tabindex="32"	id="nomenclature<%=incr%>" size="35" name="nomenclature<%=incr%>" value="<%=str%>" title="<%=str%>" style="color:<%=itemStatusList.size()>0?itemStatusList.get(i):"black"%>"
			onblur="populatePVMS(this.value,'<%=incr%>');populatePVMSTab(this.value,'<%=incr%>');checkItem('<%=incr%>');copyToPrescriptionTAb('<%=incr%>','opconsult'); ValidateCantra();displayAu(this.value,'<%=incr%>');"/>
		</td>
			<input type="hidden" name="pvmsNo<%=incr %>" tabindex="33" id="pvmsNo<%=incr %>" value="<%=pvmsNo %>"	size="10" readonly="readonly" />
			<input type="hidden" name="actualDispensingQty<%=incr%>" tabindex="1" id="actualDispensingQty<%=incr%>" value="<%=temp.getItem().getADispQty()!=null?temp.getItem().getADispQty():"" %>"  size="6"  validate="AU,string,no" />
		<td>
		<input type="hidden" name="treatTemplteId<%=incr%>" tabindex="1" id="treatTemplteId<%=incr%>" value="<%=treatTemplteId %>"  size="6"  validate="AU,string,no" />
			 <select name="route<%=incr%>" id="route<%=incr%>" tabindex="39"  style="width:90px;background: #FFFF99" onblur="fillRouteOnTAb('<%=incr%>');">
					 <option value="0">Select</option>
					<%
					      for(RouteOfAdministration routeOfAdministration : route){
					    	  
					       int id = routeOfAdministration.getId();
					       String name = routeOfAdministration.getRouteName();
			          %>
								<%if(temp.getRoute()!=null && temp.getRoute().getId()==id){ %>
								<option value="<%=id %>" selected="selected"><%=name%></option>
								<%}else{ %>
								<option value="<%=id %>" ><%=name%></option>
								<%} %>
					<%
					}%>
				</select> 
		</td>
		<td><input class="textYellow opdTextBoxTSmall" type="text" name="dosage<%=incr%>"  id="dosage<%=incr%>" size="10"  maxlength="45" tabindex="34" value="<%=temp.getDosage()%>" onblur="fillValue(this.value,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>)"/>
		<div id="testDiv<%=incr%>">
		</div>
		</td><td>
			<input type="text" name="unit<%=incr %>" tabindex="35" value="<%=units!=null?units:"" %>" class="textYellow opdTextBoxTSmall" id="unit<%=incr %>" readonly="readonly" size="5" onblur="fillValue(this.value,<%=incr%>);"/>
		</td>
		<td>
			<input type="hidden name="sosQty<%=incr%>" tabindex="1" id="sosQty<%=incr%>" style="display: none;"   size="3" onblur="fillValue(this.value,<%=incr%>)"	maxlength="3" validate="Sos Qty,num,no" />
			<select style="width:90px;background: #FFFF99" name="frequency<%=incr%>" id="frequency<%=incr%>"   tabindex="36" onchange="getFrequencyValue(this.value,<%=incr%>);fillValue(this.value,<%=incr%>);displaySOSQty(this.value,<%=incr%>);displaFrequencyType(this,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>);" >
			<option value="0">Select</option>
			 <%
			  int freqCnt = 0;
				  MasFrequency  masFrequency = new MasFrequency();
			      for(MasFrequency masFrequency2 : frequencyList){
			       int id = masFrequency2.getId();
			       String name = masFrequency2.getFrequencyName();
			       String type = masFrequency2.getFrequencyType();
	          %>
	          	<%if(temp.getFrequency() !=null && temp.getFrequency().getId()==id){ 
	          		/* freqCnt = temp.getFrequency().getFrequencyCount().intValue(); */
	          		freqCnt = temp.getFrequency().getFrequencyCount();
	          	%>
				<option id="<%=type %>" value="<%=id %>" selected="selected" ><%=name%></option>
				<%}else{ %>
				<option id="<%=type %>" value="<%=id %>" ><%=name%></option>
				<%} %>
			<%} %>
		</select>
		<input type="hidden" name="frequencyValue<%=incr%>" tabindex="1" id="frequencyValue<%=incr%>" value="<%=freqCnt %>"  size="6"   />
			
		</td>
		<td>
			<div style="width:100px; float: left;">
			<input type="text" name="noOfDays<%=incr%>"	id="noOfDays<%=incr%>"  <%=temp.getDuration()!=null?"readonly":"" %> class="textYellow opdTextBoxTSmall" size="3" maxlength="3" validate="No Of Days,num,no" tabindex="37" value="<%=temp.getNoofdays()%>" onblur="fillValueDays(<%=incr%>);fillValue(this.value,<%=incr%>);"/>
			 <p style="line-height:0px;" id="frequencyType<%=incr %>" ><%=frequecnyType %></p>
			</div>
		</td>
			<%int instuctionId=0;
				if(temp.getOpdInstructionTreatment()!=null){
					instuctionId=temp.getOpdInstructionTreatment().getId();
				  }%>
		<td><select style="width:90px;background: #FFFF99" name="instrunction<%=incr%>" tabindex="38" id="instrunction<%=incr%>" >
				 <option value="0">Select</option>
				<%
					for(OpdInstructionTreatment instructionTreatment:instrunction)
					{
				       int id = instructionTreatment.getId();
				       String name = instructionTreatment.getOpdInstructionTreatmentName();
		          %>
		          <%if(instuctionId==id){ %>
					<option value="<%=id %>" selected="selected"><%=name%></option>
					<%}else{%>
					<option value="<%=id %>"><%=name%></option>
					<%}%>
					<%}	%> 
			</select>
		</td>
		<td><input type="text" name="splInstrunction<%=incr %>"  class="textYellow opdTextBoxSmall" value="<%=temp.getSplInstruction()!=null?temp.getSplInstruction():"" %>" id="splInstrunction<%=incr %>"  maxlength="200" onblur=" fillSPLInstrunctionOnPTAb(<%=incr %>);" /></td>
		<td><input type="text" name="total<%=incr%>" id="total<%=incr%>" value="<%=totals %>" size="5" class="textYellow opdTextBoxTSmall" validate="Total,num,no" readonly="readonly" tabindex="40"/>
		<td><input type="hidden" value="<%=conversionStr %>" class="textYellow opdTextBoxTSmall" readonly="readonly" tabindex="40"/>
		<input type="hidden" name="tapered<%=incr %>" id="tapered<%=incr %>" value="<%=temp.getItem().getTapered()!=null?temp.getItem().getTapered():"" %>"/>
		</td>
	</tr>
	<%updatedLen++;}	%>
	
</tbody>
<input type="hidden" name="hdb" value="<%=incr%>" id="hdb" />
<input type="hidden" name="hdbTabIndex" id="hdbTabIndex" value="<%=inxRow-1%>" id="hdbRecordSize" />
<%}//else{ %>
<%-- 
	<!--<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  >
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
	</tr> -->
	<tbody >
	<%
		int incr = 0;
		int inxRow=0; 
		for(;incr<3;incr++,inxRow++){
	%>
	<tr>
		<td><input type="checkbox" class="radioCheck" id="itemRadio<%=incr %>" name="itemRadio<%=incr %>"  tabindex="31"   onchange="checkPrescriptionCheck(<%=incr %>)"/>
			<input type="hidden" name="prescription_availableStatus<%=incr %>"	id="prescription_availableStatus<%=incr %>"/>
		</td>
		 
		<td id="nomenclatureDiv<%=incr%>">
		<input  type="text" class="textYellow largTextBoxOpd" tabindex="32"	id="nomenclature<%=incr%>" size="35" name="nomenclature<%=incr%>"
			onblur="checkForAlreadyIssuedPrescribtion(this.value,<%=incr %>);populatePVMS(this.value,'<%=incr%>');populatePVMSTab(this.value,'<%=incr%>');checkItem('<%=incr%>');copyToPrescriptionTAb('<%=incr%>','opconsult'); ValidateCantra();displayAu(this.value,'<%=incr%>');" />
		
		<div id="ac2updates<%=incr%>" style="display: none;" class="autocomplete"></div> 
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('nomenclature<%=incr%>','ac2updates<%=incr%>','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclature<%=incr%>'});
		</script>
		</td>
			<input type="hidden" name="pvmsNo<%=incr %>" tabindex="33" id="pvmsNo<%=incr %>" value=""	size="10" readonly="readonly" />
			<input type="hidden" name="actualDispensingQty<%=incr%>" tabindex="1" id="actualDispensingQty<%=incr%>" value=""  size="6"  validate="AU,string,no" />
		<td>	<select name="route<%=incr%>" id="route<%=incr%>" tabindex="39"  style="width:90px;background: #FFFF99" onblur="fillRouteOnTAb('<%=incr%>');">
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
		<td><input class="textYellow opdTextBoxTSmall" type="text" name="dosage<%=incr%>"  id="dosage<%=incr%>" size="10"  maxlength="45" tabindex="34" onblur="fillValue(this.value,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>);"/>
		<div id="testDiv<%=incr%>">
		</div>
		</td><td>
			<input type="text" name="unit<%=incr %>"  tabindex="35" class="textYellow opdTextBoxTSmall" id="unit<%=incr %>" readonly="readonly" size="5" onblur="fillValue(this.value,<%=incr%>);"/>
		</td>
		<td>
		
		<input type="hidden" name="sosQty<%=incr%>" id="sosQty<%=incr%>" style="display: none;" size="3" onblur="fillValue(this.value,<%=incr%>)" maxlength="3"	validate="Sos Qty,num,no" />
		
		<select style="width:90px;background: #FFFF99" name="frequency<%=incr%>" id="frequency<%=incr%>"   tabindex="36" onchange="getFrequencyValue(this.value,<%=incr%>);fillValue(this.value,<%=incr%>);displaySOSQty(this.value,<%=incr%>);checkFrequencyForTaperedDrugs(<%=incr%>);" >
			<option value="0">Select</option>
			<%
				  MasFrequency  masFrequency = new MasFrequency();
			      for(MasFrequency masFrequency2 : frequencyList){
			       int id = masFrequency2.getId();
			       String name = masFrequency2.getFrequencyName();
	          %>
			<option value="<%=id %>"><%=name%></option>
			<%} %>
		</select> <%
		    		MasFrequency  masFrequency3 = new MasFrequency();

				         for (int i = 0; i < frequencyList.size(); i++) {
				        	 masFrequency3 = (MasFrequency) frequencyList.get(i);
	     			 %>
	     		 <script>
		          icdArray[<%=i%>]= new Array();
		          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
		          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
	            </script> <% }%>
	            
	    	<input type="hidden" name="frequencyValue<%=incr%>" id="frequencyValue<%=incr%>" value="" size="6" />
	
		</td>
		<td>
			<input type="text" name="noOfDays<%=incr%>"	id="noOfDays<%=incr%>" class="textYellow opdTextBoxTSmall" size="3" maxlength="3" validate="No Of Days,num,no" tabindex="37" onblur="fillValueDays(<%=incr%>);fillValue(this.value,<%=incr%>);"/>
		</td>
		<td><select style="width:90px;background: #FFFF99" name="instrunction<%=incr%>" tabindex="38" id="instrunction<%=incr%>" onblur="fillInstrunctionOnTAb('<%=incr%>');">
		<option value="0">Select</option>
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
		<td><input type="text" name="splInstrunction<%=incr %>"  class="textYellow opdTextBoxSmall"  id="splInstrunction<%=incr %>"  maxlength="200" onblur=" fillSPLInstrunctionOnPTAb(<%=incr %>);" /></td>
		<td><input type="text" name="total<%=incr %>" id="total<%=incr %>"  size="5" class="textYellow opdTextBoxTSmall" validate="Total,num,no" readonly="readonly" tabindex="40"/>
		<td><input type="text" class="textYellow opdTextBoxTSmall"  readonly="readonly" tabindex="40"/>
		<input type="hidden" name="tapered<%=incr %>" id="tapered<%=incr %>" value=""/>
		</td>
	</tr>
	<%} %>
 </tbody> 
<%-- <input type="hidden" name="hdb" value="<%=incr-1%>" id="hdb" />
<input type="hidden" name="hdbTabIndex" id="hdbTabIndex" value="<%=inxRow-1%>" id="hdbRecordSize" /> --%>
<%--<%} %>
--%>
