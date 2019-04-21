<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemBrandWindow.jsp
 * Purpose of the JSP -  This is for Item Brand Window.
 * @author  Govind
 * Create Date: 21st March,2017
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*,java.math.BigDecimal,jkt.hms.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionDetails"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/opd.js"></script>
<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script>jQuery.noConflict();</script>
<script type="text/javascript"> 
// var csrfTokenName='<csrf:tokenname />';
// var csrfTokenValue='<csrf:tokenvalue />';
	var csrfTokenName='${_csrf.parameterName}';
	var csrfTokenValue='${_csrf.token}';

</script>
<%
	Map map = new HashMap();
	String nomenclature1="";
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List<InpatientPrescriptionDetails> ipPrescriptionList=new ArrayList<InpatientPrescriptionDetails>();
	List<RouteOfAdministration> routeOfAdministrationList = new ArrayList<RouteOfAdministration>();
	List<OpdInstructionTreatment> masInstructionMasterList = new ArrayList<OpdInstructionTreatment>();
	
	if(map.get("ipPrescriptionList")!=null){
		ipPrescriptionList=(List<InpatientPrescriptionDetails>)map.get("ipPrescriptionList");
	}
	if(map.get("routeOfAdministrationList")!=null){
		routeOfAdministrationList = (List)map.get("routeOfAdministrationList");
	}
	if(map.get("masInstructionMasterList")!=null){
		masInstructionMasterList = (List)map.get("masInstructionMasterList");
	}
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("frequencyList")!=null){
		frequencyList = (List)map.get("frequencyList");
	}
	List<BigDecimal> storeItemBatch = new ArrayList<BigDecimal>();
	if(map.get("storeItemBatch")!=null){
		storeItemBatch=(List<BigDecimal>)map.get("storeItemBatch");
	}
	if(map.get("nomenclature1")!=null){
		nomenclature1	=(String)map.get("nomenclature1");
	}
	int inpatientId = 0;
	if(map.get("inpatientId")!=null){
		inpatientId = (Integer)map.get("inpatientId");
	}
	String dischargeParam="N";
	if(map.get("dischargeParam")!=null){
		dischargeParam=(String)map.get("dischargeParam");
	}
	//System.out.println("dischargeParam "+dischargeParam);
	%>
<script type="text/javascript">
	function cancelForm(){
  	 close();
   	}
	   var icdArray=new Array();


</script>
<div id="contentHolder">
<div class="titleBg">
<h2>Patient Prescription Details ( Last Prescription)</h2>
</div>
<div class="clear"></div>


<form name="patientPrescription" method="post">
<input type="hidden" name="inpatientId" value="<%=inpatientId%>" id="inpatientId">
<input type="hidden" name="${_csrf.parameterName}" id="${_csrf.parameterName}" value="${_csrf.token}">
<%if(ipPrescriptionList.size() > 0){

				MasFrequency  masFrequency = new MasFrequency();
				
			     for (int i = 0; i < frequencyList.size(); i++) {
			        	 masFrequency = (MasFrequency) frequencyList.get(i);
     			 %>

     			 <script>

	          icdArray[<%=i%>]= new Array();
	          icdArray[<%=i%>][0] = "<%=masFrequency.getId()%>";
	          icdArray[<%=i%>][1] = "<%=masFrequency.getFrequencyName()%>";
            </script> <% }%>
			
			<div class="tableHolderAuto">
			<table  id="indentDetail" class="small">
					<tr>
						<th scope="col">Repeat Prescription</th>
						<th scope="col">Prescription Date</th>
						<th scope="col">Item Name</th>
						<th width="auto">Dosage</th>
						<th width="auto">Frequency</th>
						<th width="auto">Instruction</th>
						<th width="auto">No.of Days</th>
						<th width="auto">Total</th>
						<th width="auto">Prescribed By</th>
					</tr>
			<%
					int i=0;
					int j=0;
  					Iterator itr= ipPrescriptionList.iterator();
  					//Iterator itr1= storeItemBatch.iterator();
  					while(itr.hasNext())
  					{
  						BigDecimal dml= new BigDecimal(0.0);
  						/* if(itr1.hasNext()){
  							 dml=(BigDecimal)itr1.next();
  							 
   						} */
  						 String dateOfExpiryInString= null;
   						String prescriberBy = "";
  						 InpatientPrescriptionDetails InpatientPrescriptionDetails=(InpatientPrescriptionDetails)itr.next();

  						 String prescriptionDate="";
  						 if(InpatientPrescriptionDetails.getPrescription().getPrescriptionDate()!=null){
  							prescriptionDate=HMSUtil.convertDateToStringTypeDateOnly(InpatientPrescriptionDetails.getPrescription().getPrescriptionDate());
  						 }
  						 MasStoreBrand brand=new MasStoreBrand();
  			         	 int itemId=InpatientPrescriptionDetails.getItem().getId();
  			         	 String pvms = InpatientPrescriptionDetails.getItem().getPvmsNo();
  			         	String brandName = null;
  			         	int brandId =0;
  			         	 String manufacturer =null;
  			         	 int manufactureId=0;
  			          if(InpatientPrescriptionDetails.getManufacturer()!=null)
  			          {
  			        	  manufacturer = InpatientPrescriptionDetails.getManufacturer().getManufacturerName();
  			        	manufactureId =InpatientPrescriptionDetails.getManufacturer().getId();
  			          }
  			        	 String nomenclature=InpatientPrescriptionDetails.getItem().getNomenclature()+"("+InpatientPrescriptionDetails.getItem().getId()+")["+InpatientPrescriptionDetails.getItem().getPvmsNo()+"]";;
  			        	 Float dosage= InpatientPrescriptionDetails.getDosage();
  			        	 String frequency=InpatientPrescriptionDetails.getFrequency().getFrequencyName();
  			        	 int frequencyId=InpatientPrescriptionDetails.getFrequency().getId();
  			        	 float total=(float)InpatientPrescriptionDetails.getTotal();
  			        	 int noOfDays=InpatientPrescriptionDetails.getNoOfDays();
  			        	 String typeLeftRight=InpatientPrescriptionDetails.getType();
  			        	int instructionId=0;
  			        	if(InpatientPrescriptionDetails.getInsrtuction()!=null){
  			        	instructionId=InpatientPrescriptionDetails.getInsrtuction().getId();
  			        	}
  			        	if(InpatientPrescriptionDetails.getPrescription().getPrescribedByNurse() != null){
  			        		prescriberBy = InpatientPrescriptionDetails.getPrescription().getPrescribedByNurse();
  			        	}
 %>

		<tr>
			<%--<td><input type="checkbox" name="repeatPrescription<%=i%>" id="repeatPrescription<%=i%>" class="radioCheck" value="" onclick="checkForAlreadyIssuedPrescribtion('<%=nomenclature %>','<%=i %>',csrfTokenName,csrfTokenValue);"/></td> --%>
			<td><input type="checkbox" name="repeatPrescription<%=i%>" id="repeatPrescription<%=i%>" class="radioCheck" value=""/></td>
			<td><%=prescriptionDate%></td>
			<td>
			
				<input type="text" id="nomenclature<%=i%>" name="nomenclature<%=i%>"	readonly="readonly" value="<%=nomenclature %>" />
				<div id="ac2update1" style="font-weight: normal; display: none; border: 1px solid black;
				 padding-right: 10px; background-color: white;"> </div>
		        <input type="hidden" name="pvmsNo<%=i%>" id="pvmsNo<%=i%>" size="10" value="<%=pvms%>"/>
		       <input	type="hidden" name="itemId<%=i%>" id="itemId<%=i%>" value="<%=itemId%>" />
		        <input	type="hidden" name="route<%=i%>" id="route<%=i%>" value="<%=InpatientPrescriptionDetails.getRoute()!=null?InpatientPrescriptionDetails.getRoute().getId():""%>" />
<%--  <input	type="hidden" name="startDate<%=i%>" id="startDate<%=i%>" value="<%=InpatientPrescriptionDetails.getStartDate()!=null?HMSUtil.convertDateToStringWithoutTime(InpatientPrescriptionDetails.getStartDate()):""%>" />
		        <input	type="hidden" name="endtDate<%=i%>" id="endDate<%=i%>" value="<%=InpatientPrescriptionDetails.getEndDate()!=null?HMSUtil.convertDateToStringWithoutTime(InpatientPrescriptionDetails.getEndDate()):""%>" />--%>		
		              <input type="hidden" id="brandId<%=i%>" name="brandId<%=i%>" value="<%=brandId%>"/>
		       <input type="hidden" id="manufacturer<%=i%>" name="manufacturer<%=i%>" readonly="readonly" value="<%=""%>"/>
			   <input type="hidden" name="brandName<%=i%>" id="brandName<%=i%>" value="<%=brandName%>"></input>
			   <input type="hidden" id="manufactureId<%=i%>" name="manufactureId<%=i %>" value="<%=manufactureId%>" />
			    <input type="hidden" name="unit<%=i%>" id="unit<%=i%>" value="<%=InpatientPrescriptionDetails.getItem().getItemConversion()!=null?InpatientPrescriptionDetails.getItem().getItemConversion().getIssueUnit().getUnitName():""%>"></input>
			    </td>
				<td><input type="text" id="dosage<%=i%>" name="dosage<%=i%>" readonly="readonly" value="<%=dosage %>" onblur="fillValue(this.value,<%=i %>);" /></td>
				<td>
					<select name="frequency<%=i %>" id="frequency<%=i %>"	tabindex="1" >
						<option value="0">Select</option>
						<%
						int freqValue = 0;
						for(MasFrequency frequency2 : frequencyList){
					       	int id = frequency2.getId();
					       	String name = frequency2.getFrequencyName();
					      	 if(frequency2.getId()==frequencyId){ 
					      		freqValue = frequency2.getFrequencyCount();
					      	 %>
								<option value="<%=id %>" selected="selected"><%=name%></option>
							<% }else{ %>
								<option value="<%=id %>"><%=name%></option>
							<% }%>
						<%}%>
					</select>					
				<input type="hidden" name="freqValue<%=i%>"	id="freqValue<%=i%>" value="<%=freqValue %>" size="6" /> 
				</td>
				<td><select name="instruction<%=i %>" id="instruction<%=i %>" tabindex="1"  >
			<option value="0">Select</option>
			<%int instructionValue=0;
			for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
			{

		       int id = instructionTreatment.getId();
		       String name = instructionTreatment.getOpdInstructionTreatmentName();
                if(instructionId==id){ 
                	instructionValue = instructionTreatment.getId();
		      	 %>
				<option value="<%=id %>" selected="selected"><%=name%></option>
				<% }else{ %>
			<option value="<%=id %>"><%=name%></option>
			<%
			}
			}
			%>
			
		</select> 
		<input type="hidden" name="instValue<%=i%>"	id="instValue<%=i%>" value="<%=instructionValue %>" size="6" />
		</td>
			<td><input type="text" id="noOfDays<%=i%>" name="noOfDays<%=i%>" onblur="fillValuePopUp(this.value,<%=i %>);" value="<%=noOfDays %>"    /></td>
			<td><input type="text" id="total<%=i%>" name="total<%=i%>"	readonly="readonly" value="<%=total %>" /></td>
			<%if(prescriberBy.equals("y")){ %>
			<td>Nurse</td>
			<%}else{ %>
			<td>Doctor</td>
			<%} %>
			</tr>
			<%
			i++;
  	   }
  	 %>
</table>
</div>

<div class="clear"></div>
<div id="edited"></div>
<%if(dischargeParam.equals("Y")){%>
<input type="button" name="ok" value="Ok" onclick="setValuesInParent();" class="button"/>
<%}else{%>
<input id="save" property="save" type="button" tabindex="1" name="save"	value="Repeat" class="button"	onclick="setValuesInParentForPrescription(patientPrescription);" />
<input	type="button" name="cancel" id="addbutton" value="Cancel"	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />
<%}%>
<input	type="hidden" name="counter" id="counter" value="<%=i %>" />
<div class="clear"></div>
	<%}else{ %>
<h4><span>No Records Found!</span></h4>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="cancel" id="addbutton" value="Cancel" class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />
	 <%} %>
</form>
</div>
<script type="text/javascript">	var	routeArray= new Array();
		              <%
			    		RouteOfAdministration  route = new RouteOfAdministration();
					     for (int k = 0; k < routeOfAdministrationList.size(); k++) {
					    	 route = (RouteOfAdministration) routeOfAdministrationList.get(k);
		     			 %> 
		     			routeArray[<%=k%>]= new Array();
		     			routeArray[<%=k%>][0] = "<%=route.getId()%>";
		     			routeArray[<%=k%>][1] = "<%=route.getRouteName()%>";
	     				<% }%> 
            </script>
            <script type="text/javascript">	var	instructionArray= new Array();
              <%
              OpdInstructionTreatment  instructionMaster = new OpdInstructionTreatment();
			     for (int k = 0; k < masInstructionMasterList.size(); k++) {
			    	 instructionMaster = (OpdInstructionTreatment) masInstructionMasterList.get(k);
     			 %> 
     			instructionArray[<%=k%>]= new Array();
     			instructionArray[<%=k%>][0] = "<%=instructionMaster.getId()%>";
     			instructionArray[<%=k%>][1] = "<%=instructionMaster.getOpdInstructionTreatmentName()%>";
     			<% }%> 
            </script>
<script type="text/javascript">
function  fillValuePopUp(value,inc){
	
//alert("in script function");
    var freq=document.getElementById('frequency'+inc).value;
   // alert("freq--->>"+freq);
    var noOfDays=document.getElementById('noOfDays'+inc).value;
  //  alert("noOfDays--->>"+noOfDays);
    var nomenclature = document.getElementById("nomenclature"+inc).value;
    var groupName   = nomenclature.split('.');
    var groupName1   = nomenclature.split(' ');
    var dosage=document.getElementById('dosage'+inc).value;
    if(groupName[0].toUpperCase()=='DROP' || groupName[0].toUpperCase()=='SYP' )
    {
    	  document.getElementById('total'+inc).value='1';
	  }
    else if(groupName1[0].toUpperCase()=='CREAM')
    {
    	  document.getElementById('total'+inc).value='1';
	  }
	  else if(groupName[0].toUpperCase()=='OINT')
	  {
	    	document.getElementById('total'+inc).value='1';
	  }else{
    	  	document.getElementById('total'+inc).value=freq*dosage*noOfDays;
	   }
 }

/* function setValuesInParentForPrescription(formname){
		formName=formname.name;
		var grid = window.opener.document.getElementById("grid").rows.length;
		var hdbVal1 = window.opener.document.getElementById('hdb').value;
		var counter = document.getElementById('counter').value;
		
		for(var index=0;index<=counter;index++){
			alert(index);
  			if(index>2){
  				window.opener.addRow();
  			}
  			var toEval = document.getElementById("repeatPrescription" + index);
			if(toEval.checked==true){
			  var nomenclature=eval('document.'+formName+'.nomenclature' + index + '.value')
			  var pvmsNo=eval('document.'+formName+'.pvmsNo' + index + '.value')
			  var itemId=eval('document.'+formName+'.itemId' + index + '.value')
			  var brandId=eval('document.'+formName+'.brandId' + index + '.value')
			  var brandName=eval('document.'+formName+'.brandName' + index + '.value')
			  var selectedFrequency = eval('document.'+formName+'.frequency' + index + '.selectedIndex ');
				
			  window.opener.document.getElementById("nomenclature"+index).value=''+nomenclature;
			  window.opener.document.getElementById("pvmsNo"+index).value=''+pvmsNo;
			  window.opener.document.getElementById("dosage"+index).value=''+eval('document.'+formName+'.dosage' + index + '.value');
			  window.opener.document.getElementById("unit"+index).value=''+eval('document.'+formName+'.unit' + index + '.value');
			  window.opener.document.getElementById("frequency"+index).selectedIndex=selectedFrequency;
			  window.opener.document.getElementById("noOfDays"+index).value=eval('document.'+formName+'.noOfDays' + index + '.value');
			  window.opener.document.getElementById("total"+index).value=eval('document.'+formName+'.total' + index + '.value');
			  
		      window.opener.document.getElementById("nomenclaturepTab"+index).value=''+nomenclature;
		      alert("opner=="+window.opener.document.getElementById("nomenclaturepTab"+index).value);
			  window.opener.document.getElementById("pvmsNopTab"+index).value=''+pvmsNo;
			  window.opener.document.getElementById("dosagepTab"+index).value=''+eval('document.'+formName+'.dosage' + index + '.value');
			  window.opener.document.getElementById("unitpTab"+index).value=''+eval('document.'+formName+'.unit' + index + '.value');
			  window.opener.document.getElementById("frequencypTab"+index).selectedIndex=selectedFrequency;
			  window.opener.document.getElementById("noOfDayspTab"+index).value=eval('document.'+formName+'.noOfDays' + index + '.value');
			  window.opener.document.getElementById("totalpTab"+index).value=eval('document.'+formName+'.total' + index + '.value'); 
			  //window.opener.copyToPrescriptionTAb(hdbVal1,'opconsult');
			}	
  		}
		
		window.close() ;
  	}  */
  	
  	 function setValuesInParentForPrescription(formname){
		formName=formname.name;	
		//var grid = window.opener.document.getElementById("DMgridtreatmenttreatment").rows.length;
		var visitId = window.opener.document.getElementById("inpatientId").value;
		var hdbVal = window.opener.document.getElementById('DMhdbtreatment').value;
		// var nomenclature1 = window.opener.document.getElementById('nomenclature1').value;
		
		//var pTabhdbValue = window.opener.document.getElementById('pTabhdb').value;
		//var nomenclaturepTab1 = window.opener.document.getElementById('nomenclaturepTab1').value;
		
		var counter = document.getElementById('counter').value;
		//if(hdbVal == 2 && nomenclature1 == ''){
			var len = window.opener.document.getElementById("DMgridtreatment").rows.length;
			for(i=len-1;i>0;i--)
				var tbl = window.opener.document.getElementById("DMgridtreatment").deleteRow(i);
			
		//}
		
	//	if(pTabhdbValue == 2 && nomenclaturepTab1 == ''){
		/*	var lenTab = window.opener.document.getElementById("DMprescriptionTabGrid").rows.length;
			for(j=lenTab-1;j>0;j--)
				var rTab = window.opener.document.getElementById("DMprescriptionTabGrid").deleteRow(j); */
			//alert("after deletegrid==="+window.opener.document.getElementById("DMgridtreatment").rows.length);
	//	}
		
		for(var index=0;index<counter;index++){
  			 /* if(index>2){
  				window.opener.addRow();
  				
  			} */
  			
  			var toEval = document.getElementById("repeatPrescription" + index);
			if(toEval.checked==true){
				var len = window.opener.document.getElementById("DMgridtreatment").rows.length;
			    var r = window.opener.document.getElementById("DMgridtreatment").insertRow(len);
			  
			 /* var lenTab = window.opener.document.getElementById("DMprescriptionTabGrid").rows.length;
			  var rTab = window.opener.document.getElementById("DMprescriptionTabGrid").insertRow(lenTab);*/
			  
			  
			   var nomenclature=eval('document.'+formName+'.nomenclature' + index + '.value')
			  var pvmsNo=eval('document.'+formName+'.pvmsNo' + index + '.value')
			  var itemId=eval('document.'+formName+'.itemId' + index + '.value')
			  var brandId=eval('document.'+formName+'.brandId' + index + '.value')
			  var brandName=eval('document.'+formName+'.brandName' + index + '.value')
			  var selectedFrequency = eval('document.'+formName+'.frequency' + index + '.selectedIndex ');
			   var dosage = ''+eval('document.'+formName+'.dosage' + index + '.value');
			   var noOfDays = eval('document.'+formName+'.noOfDays' + index + '.value');
			   var total = eval('document.'+formName+'.total' + index + '.value');
			   var unit = ''+eval('document.'+formName+'.unit' + index + '.value');
			   var route =  eval('document.'+formName+'.route' + index + '.value');
			  // var startDate =  eval('document.'+formName+'.startDate' + index + '.value');
			 //  var endDate =  eval('document.'+formName+'.endDate' + index + '.value');
			   var freqValue =  eval('document.'+formName+'.freqValue' + index + '.value');
			   var instValue =  eval('document.'+formName+'.instValue' + index + '.value');
			   var instValueFrequency = eval('document.'+formName+'.instruction' + index + '.selectedIndex ');
			  var cellRight0 = r.insertCell(0);
				var e0 = document.createElement('input');
				e0.type = 'checkbox';
				e0.name = 'DMitemRadiotreatment' + len;
				e0.id = 'DMitemRadiotreatment' + len;
				e0.className = 'radioCheck';
				e0.tabIndex = hdbVal + "1";
				cellRight0.appendChild(e0);
				e0.setAttribute("onClick","checkPrescriptionCheck("+len+")");
				
				
				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'DMprescription_availableStatustreatment' + len;
				e1.id = 'DMprescription_availableStatustreatment' + len;
				//e1.className = "textYellow grdTextSmall";
				cellRight0.appendChild(e1);

				var cellRight1 = r.insertCell(1);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'DMnomenclaturetreatment' + len;
				e1.id = 'DMnomenclaturetreatment' + len;
				//e1.className = "textYellow largTextBoxOpd";
				 e1.value = nomenclature;
				/* e1.onfocus = function() {
					checkEnteredDiagnosis();
					checkFrequency(len, "opc");
				} */
				/* e1.onkeypress = function() {
					checkTextColor('nomenclaturetreatment' + len);
				}; */
				/* e1.onblur = function() {
					checkForAlreadyIssuedPrescribtion(this.value, len);
					populatePVMS(this.value, len);
					checkItem(len);
					copyToPrescriptionTAb(len, 'opconsult');
					ValidateCantra();
					displayAu(this.value, len);
					validatePrescriptionAutocomplete('opmain', this.value, len);
					checkForAllergy(this.value, len);
				};  */
				e1.size = '35';
				e1.tabIndex = hdbVal + "2";
				cellRight1.appendChild(e1);
				//e1.focus();
				e1.setAttribute("onfocus","checkEnteredDiagnosis();checkFrequency("+len+",'opc')");
				e1.setAttribute("onkeypress","checkEnteredDiagnosis();checkFrequency("+len+",'opc')");
				/* e1.setAttribute("onblur","checkForAlreadyIssuedPrescribtion(this.value, "+len+");populatePVMS(this.value,  "+len+");	checkItem( "+len+");	copyToPrescriptionTAb( "+len+", 'opconsult');ValidateCantra();displayAu(this.value,  "+len+");validatePrescriptionAutocomplete('opmain', this.value,  "+len+");checkForAllergy(this.value,  "+len+");"); */
				e1.setAttribute("onblur","populatePVMS(this.value,  "+len+");	checkItem( "+len+");displayAu(this.value,  "+len+");validatePrescriptionAutocomplete('opmain', this.value,  "+len+");checkForAllergy(this.value,  "+len+");");

				var newdiv = document.createElement('div');
				newdiv.setAttribute('id', 'ac2updatestreatment' + len);
				newdiv.style.display = 'none';
				newdiv.className = "autocomplete";
				cellRight1.appendChild(newdiv);
				/* new Ajax.Autocompleter('nomenclaturetreatment' + len,
						'ac2updatestreatment' + len,
						'opd?method=getItemListForAutoCompleteItem', {
							minChars : 3,
							parameters : 'requiredField=nomenclaturetreatment' + len
						}); */

				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'DMbrandIdtreatment' + len;
				e1.id = 'DMbrandIdtreatment' + len;
				e1.value=brandId;
				cellRight1.appendChild(e1);

				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'DMmanufactureIdtreatment' + len;
				e1.id = 'DMmanufactureIdtreatment' + len;
				cellRight1.appendChild(e1);

				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'DMpvmsNotreatment' + len;
				e1.id = 'DMpvmsNotreatment' + len;
				 e1.value = pvmsNo;
				cellRight1.appendChild(e1);

				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'DMactualDispensingQtytreatment' + len;
				e1.id = 'DMactualDispensingQtytreatment' + len;
				cellRight1.appendChild(e1);

				

				var cellRight1 = r.insertCell(2);
				var e1 = document.createElement('input');
				e1.name = 'DMdosagetreatment' + len;
				e1.id = 'DMdosagetreatment' + len;
				e1.style.width = "30px";
				e1.tabIndex = hdbVal + "4";
				e1.value = parseFloat(dosage);
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","fillValue(this.value,"+len+")");

				var cellRight1 = r.insertCell(3);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'DMunittreatment' + len;
				e1.id = 'DMunittreatment' + len;
				//e1.className = 'textYellow opdTextBoxTSmall';
				e1.style.width = "30px";
				e1.readOnly = 'readOnly';
				e1.tabIndex = hdbVal + "5";
				e1.value = unit;
				cellRight1.appendChild(e1);

				var cellRight1 = r.insertCell(4);
				var e1 = document.createElement('Select');
				e1.name = 'DMfrequencytreatment' + len;
				e1.id = 'DMfrequencytreatment' + len;
				e1.tabIndex = hdbVal + "6";
				e1.options[0] = new Option('Select', '0');
				for (var i = 0; i < icdArray.length; i++) {
					e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]);
				}
				e1.selectedIndex = selectedFrequency;
				/* e1.onblur = function() {
					getFrequencyValue(this.value, len);
					fillValue(this.value, len);
					displaySOSQty(this.value, len);
				}; */
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","getFrequencyValue(this.value,"+len+");fillValue(this.value, "+len+");displaySOSQty(this.value, "+len+");");

				

				var e21 = document.createElement('input');
				e21.type = 'hidden';
				e21.name = 'DMsosQtytreatment' + len;
				e21.id = 'DMsosQtytreatment' + len;
				e21.size = '5';
				e21.setAttribute('tabindex', '1');
				cellRight1.appendChild(e21);

				var e21 = document.createElement('input');
				e21.type = 'hidden';
				e21.name = 'DMfrequencyValue' + len;
				e21.id = 'DMfrequencyValue' + len;
				e21.size = '5';
				e21.value=freqValue;
				e21.setAttribute('tabindex', '1');
				cellRight1.appendChild(e21);

				var cellRight1 = r.insertCell(5);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'DMnoOfDaystreatment' + len;
				//e1.className = "textYellow opdTextBoxTSmall";
				e1.id = 'DMnoOfDaystreatment' + len;
				e1.size = '3';
				e1.value = noOfDays;
				e1.tabIndex = hdbVal + "7";
				/* e1.onblur = function() {
					fillValueDays(len);
					fillValue(this.value, len);
				}; */
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","fillValueDays("+len+");fillValue(this.value,"+len+")");


				var cellRight1 = r.insertCell(6);
				var e1 = document.createElement('Select');
				e1.name = 'DMinstructiontreatment' + len;
				e1.id = 'DMinstructiontreatment' + len;
				e1.tabIndex = hdbVal + "8";  
				e1.options[0] = new Option('Select', '0');
				for (var i = 0; i < instructionArray.length; i++) {
					e1.options[i + 1] = new Option(instructionArray[i][1],
							instructionArray[i][0]);
				}
				e1.selectedIndex = instValueFrequency;
				/* e1.onblur = function() {
					fillInstrunctionOnTAb(len);
				}; */
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","fillInstrunctionOnTAb("+len+")");


				var cellRight1 = r.insertCell(7);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'DMsplInstrunctiontreatment' + len;
				e1.id = 'DMsplInstrunctiontreatment' + len;
				e1.tabIndex = hdbVal + "9";
				//e1.className = "textYellow opdTextBoxSmall";
				e1.style.width = "110px";
				e1.size = '5';
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","fillSPLInstrunctionOnPTAb("+len+")");


				
				var cellRight1 = r.insertCell(8);
				var e1 = document.createElement('Select');
				e1.name = 'DMroutetreatment' + len;
				e1.id = 'DMroutetreatment' + len;
				e1.tabIndex = hdbVal + "3";
				e1.options[0] = new Option('Select', '0');
				for (var i = 0; i < routeArray.length; i++) {
					e1.options[i + 1] = new Option(routeArray[i][1], routeArray[i][0]);
				}
				e1.value= route;
				/* e1.onblur = function() {
					fillRouteOnTAb(len);
				}; */
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","fillRouteOnTAb("+len+")");
				
				var cellRight1 = r.insertCell(9);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'DMtotaltreatment' + len;
				e1.id = 'DMtotaltreatment' + len;
				//e1.className = "textYellow opdTextBoxTSmall";
				e1.style.width = "30px";
				e1.readOnly = 'readOnly';
				e1.size = '5';
				e1.value = parseFloat(total);
				cellRight1.appendChild(e1);

				
				window.opener.document.getElementById('DMhdbtreatment').value=len;
			}	
  		}
		
		setTimeout(function(){ window.close() }, 500);
  	}
  	 
function checkRepeatPrescriptionItem(cnt,visitId,pvmsNo) {
  		
  		var tbl = window.opener.document.getElementById('grid');
  		var lastRow = tbl.rows.length;
  		var iteration = lastRow - 1;

  		// var pvmsNo=document.getElementById("pvmsNo"+iteration).value
  		
  		var visitId = visitId;
  		var nomenclature = window.opener.document.getElementById("nomenclature" + cnt).value
  		var index1 = nomenclature.lastIndexOf("[")-1;
  		var indexForBrandName = index1;
  		var index2 = nomenclature.lastIndexOf("]")-1;
  		index1++;
		
  		//var pvmsNo = nomenclature.substring(index1, index2);
  		var prescriptionName = nomenclature.substring(0, (index1 - 1));
  		if (pvmsNo != "") {

  			var xmlHttp;
  			try {
  				// Firefox, Opera 8.0+, Safari
  				xmlHttp = new XMLHttpRequest();
  			} catch (e) {
  				// Internet Explorer
  				try {
  					xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
  				} catch (e) {
  					alert(e)
  					try {
  						xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
  					} catch (e) {
  						alert("Your browser does not support AJAX!");
  						return false;
  					}
  				}
  			}

  			xmlHttp.onreadystatechange = function() {
  				
  				if (xmlHttp.readyState == 4) {
  					jQuery(function($) {
  						
  						var items = xmlHttp.responseXML
  								.getElementsByTagName('items')[0];
  						var items = xmlHttp.responseXML
  								.getElementsByTagName('items')[0];
  							
  						for (loop = 0; loop < items.childNodes.length; loop++) {
  							var item = items.childNodes[loop];
  							var stockStstus = item.getElementsByTagName("stock")[0];
  							if (stockStstus.childNodes[0].nodeValue == '0') {
  								$("#nomenclature" + cnt,opener.document).css({
  									'color' : 'red',
  									'font-size' : '125%'
  								});
  								$("#nomenclaturepTab" + cnt,opener.document).css({
  									'color' : 'red',
  									'font-size' : '125%'
  								});
  								$("#prescription_availableStatus" + cnt,opener.document).val('y');
  								$("#prescription_availableStatuspTab" + cnt,opener.document).val(
  										'y');
  							} else {
  								$("#prescription_availableStatuspTab" + cnt,opener.document).val(
  										'n');
  							}
  						}
  					});
  				}
  			}
  			//alert("pvmsNo==="+pvms);
  			//alert("visitId==="+visitId);
  			var url = "/hms/hms/opd?method=checkItem&pvmsNo=" + pvmsNo
  					+ "&visitId=" + visitId;

  			xmlHttp.open("GET", url, true);
  			xmlHttp.setRequestHeader("Content-Type", "text/xml");
  			xmlHttp.send(null);
  		}
  		
  	}
  	
function getFrequencyValue(feqValue,inc){
	var feqQty;
	<%
	if(frequencyList.size()>0){	
		for(MasFrequency masFrequency :frequencyList){
	%>
	 if(feqValue == '<%=masFrequency.getId()%>'){
		 feqQty = '<%=masFrequency.getFrequencyCount()%>'
	  }

	<%}
	}%>
	 document.getElementById('frequencyValue'+inc).value = feqQty;
	 document.getElementById('frequencyValuepTab'+inc).value = feqQty;
}



function checkForAlreadyIssuedPrescribtion(val, inc, csrfTokenName, csrfTokenValue) {
	var inpatientId = document.getElementById("inpatientId").value;
	var id;
	if (val != "") {

		var xmlHttp;
		try {
			// Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				alert(e)
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("Your browser does not support AJAX!");
					return false;
				}
			}
		}

		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4) {
				var b = "false";
				var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
				for (loop = 0; loop < items.childNodes.length; loop++) {
					var item = items.childNodes[loop];
					var dupl = item.getElementsByTagName('alreadyIssued1')[0];
					b = dupl.childNodes[0].nodeValue
				
					if (b == 'true') {
						alert(" Already Prescibe to Patient!!");
						document.getElementById('repeatPrescription' + inc).checked = false;
					}
				}

			}
		}
		// var
		// url="/hms/hms/opd?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)

		var url = "/hms/hms/ipd?method=checkForAlreadyIssuedIPPrescribtion&val="
				+ val + "&inpatientId=" + inpatientId + "&" + csrfTokenName + "="
				+ csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);

	}
}


function setValuesInParent(){
	var count = document.getElementById('counter').value;
	//alert(count);
	var treatment = ''; 
	for(var i = 0;i<count;i++){
		//alert("in loop");
		if(document.getElementById('repeatPrescription'+i).checked==true){
			//alert("in if"+document.getElementById('nomenclature'+i).value);
			if(treatment!=''){
				treatment += ",\n";
			}
			//alert(""+document.getElementById('chargeCodeName33'+i).value);
			var nomen=(document.getElementById('nomenclature'+i).value).split("(");
			treatment +=nomen[0];
			

		}
	}
	//alert(treatment);
	window.opener.document.getElementById("treatmentId").value = treatment;
	window.close();
}
</script>