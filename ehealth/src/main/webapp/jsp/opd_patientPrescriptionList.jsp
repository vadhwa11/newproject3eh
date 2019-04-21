<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemBrandWindow.jsp
 * Purpose of the JSP -  This is for Item Brand Window.
 * @author  Vivek
 * @author  Deepti
 * Create Date: 21st Feb,2008
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
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
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
	List<PatientPrescriptionDetails> patientPrescriptionList= new ArrayList<PatientPrescriptionDetails>();
	List<RouteOfAdministration> routeOfAdministrationList = new ArrayList<RouteOfAdministration>();
	List<OpdInstructionTreatment> masInstructionMasterList = new ArrayList<OpdInstructionTreatment>();
	if(map.get("patientPrescriptionList")!=null){
		patientPrescriptionList = (List)map.get("patientPrescriptionList");

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
	int visitId = 0;
	if(map.get("visitId")!=null){
		visitId = (Integer)map.get("visitId");
	}

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
<input type="hidden" name="visitId" value="<%=visitId%>" id="visitId">
<input type="hidden" name="${_csrf.parameterName}" id="${_csrf.parameterName}" value="${_csrf.token}">
<%if(patientPrescriptionList.size() > 0){

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
						<!-- <th width="auto">No.of Days</th> -->
						<th width="auto">Duration</th>
						<th width="auto">Total</th>
					</tr>
			<%
					int i=0;
					int j=0;
  					Iterator itr= patientPrescriptionList.iterator();
  					//Iterator itr1= storeItemBatch.iterator();
  					while(itr.hasNext())
  					{
  						BigDecimal dml= new BigDecimal(0.0);
  						/* if(itr1.hasNext()){
  							 dml=(BigDecimal)itr1.next();
  							 
   						} */
  						 String dateOfExpiryInString= null;
  						 PatientPrescriptionDetails patientPrescriptionDetails=(PatientPrescriptionDetails)itr.next();

  						 String prescriptionDate="";
  						 if(patientPrescriptionDetails.getPrescription().getPrescriptionDate()!=null){
  							prescriptionDate=HMSUtil.convertDateToStringTypeDateOnly(patientPrescriptionDetails.getPrescription().getPrescriptionDate());
  						 }
  						 MasStoreBrand brand=new MasStoreBrand();
  			         	 int itemId=patientPrescriptionDetails.getItem().getId();
  			         	 String pvms = patientPrescriptionDetails.getItem().getPvmsNo();
  			         	String brandName = null;
  			         	int brandId =0;
  			         	 String manufacturer =null;
  			         	 int manufactureId=0;float total=0.0f;
  			          if(patientPrescriptionDetails.getManufacturer()!=null)
  			          {
  			        	  manufacturer = patientPrescriptionDetails.getManufacturer().getManufacturerName();
  			        	manufactureId =patientPrescriptionDetails.getManufacturer().getId();
  			          }
  			        	 String nomenclature=patientPrescriptionDetails.getItem().getNomenclature()+"("+patientPrescriptionDetails.getItem().getId()+")["+patientPrescriptionDetails.getItem().getPvmsNo()+"]";;
  			        	 Float dosage= 0.0f;
  			        	if(patientPrescriptionDetails.getDosage()!=0.0f){
  			        		dosage = patientPrescriptionDetails.getDosage();
  			        	}
  			        	 String frequency="";
  			        	String type="";
  			        	int frequencyId=0;
  			        	 if(patientPrescriptionDetails.getFrequency()!=null){
  			        	 if(patientPrescriptionDetails.getFrequency().getId()!=0){
  			        		frequencyId=patientPrescriptionDetails.getFrequency().getId();
  			        		frequency=patientPrescriptionDetails.getFrequency().getFrequencyName();
  			        	    type = patientPrescriptionDetails.getFrequency().getFrequencyType();
  			        		}
  			          }
  			        	 
  			        	 if(patientPrescriptionDetails.getTotal()!=null && patientPrescriptionDetails.getTotal()!=0.0f && !patientPrescriptionDetails.getTotal().equals("")){
  			        		total = (float)patientPrescriptionDetails.getTotal();
  			        	 }
  			        	int noOfDays=0;
  			        	if(patientPrescriptionDetails.getNoOfDays()!=null){
  			        		noOfDays=patientPrescriptionDetails.getNoOfDays();
  			        	}
  			        	 String typeLeftRight=patientPrescriptionDetails.getType();
  			        	
 %>

		<tr>
			<td><input type="checkbox" name="repeatPrescription<%=i%>" id="repeatPrescription<%=i%>" class="radioCheck" value="" onclick="checkForAlreadyIssuedPrescribtion('<%=nomenclature %>','<%=i %>',csrfTokenName,csrfTokenValue);"/></td>
			<td><%=prescriptionDate%></td>
			<td>
				<input type="text" id="nomenclature<%=i%>" name="nomenclature<%=i%>"	readonly="readonly" value="<%=nomenclature %>" />
				<div id="ac2update1" style="font-weight: normal; display: none; border: 1px solid black;
				 padding-right: 10px; background-color: white;"> </div>
		        <input type="hidden" name="pvmsNo<%=i%>" id="pvmsNo<%=i%>" size="10" value="<%=pvms%>"/>
		       <input	type="hidden" name="itemId<%=i%>" id="itemId<%=i%>" value="<%=itemId%>" />
		       <%if(patientPrescriptionDetails.getRoute()!=null){ %>
		       <input	type="hidden" name="route<%=i%>" id="route<%=i%>" value="<%=patientPrescriptionDetails.getRoute().getId()!=null?patientPrescriptionDetails.getRoute().getId():""%>" />
		        <%}else{ %>
		         <input	type="hidden" name="route<%=i%>" id="route<%=i%>" value=""/>
		        <%} %>
		     
		        <input	type="hidden" name="startDate<%=i%>" id="startDate<%=i%>" value="<%=patientPrescriptionDetails.getStartDate()!=null?HMSUtil.convertDateToStringWithoutTime(patientPrescriptionDetails.getStartDate()):""%>" />
		        <input	type="hidden" name="endtDate<%=i%>" id="endDate<%=i%>" value="<%=patientPrescriptionDetails.getEndDate()!=null?HMSUtil.convertDateToStringWithoutTime(patientPrescriptionDetails.getEndDate()):""%>" />
		       <input type="hidden" id="brandId<%=i%>" name="brandId<%=i%>" value="<%=brandId%>"/>
		       <input type="hidden" id="manufacturer<%=i%>" name="manufacturer<%=i%>" readonly="readonly" value="<%=manufacturer%>"/>
			   <input type="hidden" name="brandName<%=i%>" id="brandName<%=i%>" value="<%=brandName%>"></input>
			   <input type="hidden" id="manufactureId<%=i%>" name="manufactureId<%=i %>" value="<%=manufactureId%>" />
			    <input type="hidden" name="unit<%=i%>" id="unit<%=i%>" value="<%=patientPrescriptionDetails.getItem().getItemConversion()!=null?patientPrescriptionDetails.getItem().getItemConversion().getIssueUnit().getUnitName():""%>"></input>
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
					      		/* freqValue = frequency2.getFrequencyCount().intValue(); */
					      		freqValue = frequency2.getFrequencyCount();
					      	 %>
								<option value="<%=id %>" selected="selected"><%=name%></option>
							<% }else{ %>
								<option value="<%=id %>"><%=name%></option>
							<% }%>
						<%}%>
					</select>
				</td>
				<input type="hidden" name="freqValue<%=i%>"	id="freqValue<%=i%>" value="<%=freqValue %>" size="6" /> 
			<td><input type="text" id="noOfDays<%=i%>" name="noOfDays<%=i%>" onblur="fillValuePopUp(this.value,<%=i %>);" value="<%=noOfDays+" "+type %>"    /></td>
			<td><input type="text" id="total<%=i%>" name="total<%=i%>"	readonly="readonly" value="<%=total %>" /></td>
			</tr>
			<%
			i++;
  	   }
  	 %>
</table>
</div>

<div class="clear"></div>
<div id="edited"></div>
<input id="save" property="save" type="button" tabindex="1" name="save"	value="Repeat" class="button"	onclick="setValuesInParentForPrescription(patientPrescription);" />
<input	type="button" name="cancel" id="addbutton" value="Cancel"	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />
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
		//var grid = window.opener.document.getElementById("grid").rows.length;
		var visitId = window.opener.document.getElementById("visitId").value;
		var hdbVal = window.opener.document.getElementById('hdb').value;
		var nomenclature1 = window.opener.document.getElementById('nomenclature1').value;
		
		var pTabhdbValue = window.opener.document.getElementById('pTabhdb').value;
		var nomenclaturepTab1 = window.opener.document.getElementById('nomenclaturepTab1').value;
		
		var counter = document.getElementById('counter').value;
		//if(hdbVal == 2 && nomenclature1 == ''){
			var len = window.opener.document.getElementById("grid").rows.length;
			for(i=len-1;i>0;i--)
				var tbl = window.opener.document.getElementById("grid").deleteRow(i);
			
		//}
		
	//	if(pTabhdbValue == 2 && nomenclaturepTab1 == ''){
			var lenTab = window.opener.document.getElementById("prescriptionTabGrid").rows.length;
			for(j=lenTab-1;j>0;j--)
				var rTab = window.opener.document.getElementById("prescriptionTabGrid").deleteRow(j);
			//alert("after deletegrid==="+window.opener.document.getElementById("grid").rows.length);
	//	}
		
		for(var index=0;index<counter;index++){
  			 /* if(index>2){
  				window.opener.addRow();
  				
  			} */
  			
  			var toEval = document.getElementById("repeatPrescription" + index);
			if(toEval.checked==true){
				var len = window.opener.document.getElementById("grid").rows.length;
			    var r = window.opener.document.getElementById("grid").insertRow(len);
			  
			  var lenTab = window.opener.document.getElementById("prescriptionTabGrid").rows.length;
			  var rTab = window.opener.document.getElementById("prescriptionTabGrid").insertRow(lenTab);
			  
			  
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
			   var startDate =  eval('document.'+formName+'.startDate' + index + '.value');
			   var endDate =  eval('document.'+formName+'.endDate' + index + '.value');
			   var freqValue =  eval('document.'+formName+'.freqValue' + index + '.value');
			 
			  var cellRight0 = r.insertCell(0);
				var e0 = document.createElement('input');
				e0.type = 'checkbox';
				e0.name = 'itemRadio' + len;
				e0.id = 'itemRadio' + len;
				e0.className = 'radioCheck';
				e0.tabIndex = hdbVal + "1";
				cellRight0.appendChild(e0);
				e0.setAttribute("onClick","checkPrescriptionCheck("+len+")");
				
				
				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'prescription_availableStatus' + len;
				e1.id = 'prescription_availableStatus' + len;
				e1.className = "textYellow grdTextSmall";
				cellRight0.appendChild(e1);

				var cellRight1 = r.insertCell(1);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'nomenclature' + len;
				e1.id = 'nomenclature' + len;
				e1.className = "textYellow largTextBoxOpd";
				 e1.value = nomenclature;
				/* e1.onfocus = function() {
					checkEnteredDiagnosis();
					checkFrequency(len, "opc");
				} */
				/* e1.onkeypress = function() {
					checkTextColor('nomenclature' + len);
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
				e1.setAttribute("onblur","checkForAlreadyIssuedPrescribtion(this.value, "+len+");populatePVMS(this.value,  "+len+");	checkItem( "+len+");	copyToPrescriptionTAb( "+len+", 'opconsult');ValidateCantra();displayAu(this.value,  "+len+");validatePrescriptionAutocomplete('opmain', this.value,  "+len+");checkForAllergy(this.value,  "+len+");");

				var newdiv = document.createElement('div');
				newdiv.setAttribute('id', 'ac2updates' + len);
				newdiv.style.display = 'none';
				newdiv.className = "autocomplete";
				cellRight1.appendChild(newdiv);
				/* new Ajax.Autocompleter('nomenclature' + len,
						'ac2updates' + len,
						'opd?method=getItemListForAutoCompleteItem', {
							minChars : 3,
							parameters : 'requiredField=nomenclature' + len
						}); */

				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'brandId' + len;
				e1.id = 'brandId' + len;
				e1.value=brandId;
				cellRight1.appendChild(e1);

				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'manufactureId' + len;
				e1.id = 'manufactureId' + len;
				cellRight1.appendChild(e1);

				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'pvmsNo' + len;
				e1.id = 'pvmsNo' + len;
				 e1.value = pvmsNo;
				cellRight1.appendChild(e1);

				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'actualDispensingQty' + len;
				e1.id = 'actualDispensingQty' + len;
				cellRight1.appendChild(e1);

				
				var cellRight1 = r.insertCell(2);
				var e1 = document.createElement('Select');
				e1.name = 'route' + len;
				e1.id = 'route' + len;
				e1.style.width = "90px";
				e1.style.background = "#FFFF99";
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
				

				var cellRight1 = r.insertCell(3);
				var e1 = document.createElement('input');
				e1.name = 'dosage' + len;
				e1.id = 'dosage' + len;
				e1.className = "textYellow opdTextBoxTSmall";
				/* e1.onblur = function() {
					fillValue(this.value, len);
				}; */
				e1.tabIndex = hdbVal + "4";
				e1.value = dosage;
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","fillValue(this.value,"+len+")");

				var cellRight1 = r.insertCell(4);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'unit' + len;
				e1.id = 'unit' + len;
				e1.className = 'textYellow opdTextBoxTSmall';
				e1.readOnly = 'readOnly';
				e1.tabIndex = hdbVal + "5";
				e1.value = unit;
				cellRight1.appendChild(e1);

				var cellRight1 = r.insertCell(5);
				var e1 = document.createElement('Select');
				e1.name = 'frequency' + len;
				e1.id = 'frequency' + len;
				e1.style.width = "90px";
				e1.style.background = "#FFFF99";
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
				e21.name = 'sosQty' + len;
				e21.id = 'sosQty' + len;
				e21.size = '5';
				e21.setAttribute('tabindex', '1');
				cellRight1.appendChild(e21);

				var e21 = document.createElement('input');
				e21.type = 'hidden';
				e21.name = 'frequencyValue' + len;
				e21.id = 'frequencyValue' + len;
				e21.size = '5';
				e21.value=freqValue;
				e21.setAttribute('tabindex', '1');
				cellRight1.appendChild(e21);

				var noOfdayarr = noOfDays.split(" ");
				var duration = noOfdayarr[0];
				var durationUnit = noOfdayarr[1];
				
				var cellRight1 = r.insertCell(6);
				var eDiv = document.createElement('div');
				eDiv.setAttribute("style","width:100px; float: left");
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'noOfDays' + len;
				e1.className = "textYellow opdTextBoxTSmall";
			
				e1.id = 'noOfDays' + len;
				e1.size = '3';
				e1.value = duration;
				e1.tabIndex = hdbVal + "7";
				var e11 = document.createElement('p');
				e11.setAttribute("style","line-height:0px;");
				e11.id="frequencyTypeForPrescriptionTab"+len; 
				
				e11.innerHTML = durationUnit;
				cellRight1.appendChild(eDiv);
				eDiv.appendChild(e1);
				eDiv.appendChild(e11);
				/* e1.onblur = function() {
					fillValueDays(len);
					fillValue(this.value, len);
				}; */
				e1.setAttribute("onblur","fillValueDays("+len+");fillValue(this.value,"+len+")");


				var cellRight1 = r.insertCell(7);
				var e1 = document.createElement('Select');
				e1.name = 'instrunction' + len;
				e1.id = 'instrunction' + len;
				e1.style.width = "90px";
				e1.style.background = "#FFFF99";
				e1.tabIndex = hdbVal + "8";
				e1.options[0] = new Option('Select', '0');
				for (var i = 0; i < instructionArray.length; i++) {
					e1.options[i + 1] = new Option(instructionArray[i][1],
							instructionArray[i][0]);
				}
				/* e1.onblur = function() {
					fillInstrunctionOnTAb(len);
				}; */
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","fillInstrunctionOnTAb("+len+")");


				var cellRight1 = r.insertCell(8);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'splInstrunction' + len;
				e1.id = 'splInstrunction' + len;
				e1.tabIndex = hdbVal + "9";
				e1.className = "textYellow opdTextBoxSmall";
			/* 	e1.onblur = function() {
					fillSPLInstrunctionOnPTAb(len);
				}; */
				e1.size = '5';
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","fillSPLInstrunctionOnPTAb("+len+")");


				var cellRight1 = r.insertCell(9);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'total' + len;
				e1.id = 'total' + len;
				e1.className = "textYellow opdTextBoxTSmall";
				e1.readOnly = 'readOnly';
				e1.size = '5';
				e1.value = total;
				cellRight1.appendChild(e1);

				var cellRight1 = r.insertCell(10);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'unitLable' + len;
				e1.id = 'unitLable' + len;
				e1.className = "textYellow opdTextBoxTSmall";
				e1.readOnly = 'readOnly';
				e1.size = '5';
				cellRight1.appendChild(e1);
				
				
				
				
				
				var cellRight1 = rTab.insertCell(0);
				var e1 = document.createElement('input');
				e1.type = 'checkbox';
				e1.name = 'itemRadiopTab' + lenTab;
				e1.id = 'itemRadiopTab' + lenTab;
				e1.className = 'radioCheck';
				/* e1.onChange = function() {
					checkPrescriptionCheck(lenTab);
				}; */
				e1.tabIndex = hdbVal + "1";
				cellRight1.appendChild(e1);
				//e1.setAttribute("onChange","checkPrescriptionCheck("+lenTab+")");


				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'prescription_availableStatuspTab' + lenTab;
				e1.id = 'prescription_availableStatuspTab' + lenTab;
				e1.className = "textYellow grdTextSmall";
				cellRight1.appendChild(e1);
				
				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'parkPrescriptionIds' + lenTab;
				e1.id = 'parkPrescriptionIds' + lenTab;
				cellRight1.appendChild(e1);

				var cellRight1 = rTab.insertCell(1);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'nomenclaturepTab' + lenTab;
				e1.id = 'nomenclaturepTab' + lenTab;
				e1.className = "textYellow largTextBoxOpd";
				 e1.value = nomenclature;
				/* e1.onfocus = function() {
					checkEnteredDiagnosis();
					checkFrequency(lenTab, "opc");
				} */
				/* e1.onkeypress = function() {
					checkTextColor('nomenclaturepTab' + lenTab);
				}; */
				/* e1.onblur = function() {
					checkForAlreadyIssuedPrescribtion(this.value, lenTab);
					populatePVMS(this.value, lenTab);
					checkItem(lenTab);
					copyToPrescriptionTAb(lenTab, 'opconsult');
					ValidateCantra();
					displayAu(this.value, lenTab);
					validatePrescriptionAutocomplete('opmain', this.value, lenTab);
					checkForAllergy(this.value, lenTab);
				};  */
				e1.size = '35';
				e1.tabIndex = hdbVal + "2";
				cellRight1.appendChild(e1);
				e1.focus();
				e1.setAttribute("onfocus","checkEnteredDiagnosis();checkFrequency("+lenTab+",'tab')");
				e1.setAttribute("onkeypress","checkTextColor('nomenclaturepTab'"+lenTab+")");
				e1.setAttribute("onblur","populatePVMSTab(this.value,"+lenTab+");checkPItem("+lenTab+");validatePrescriptionAutocomplete('opPTab',this.value,"+lenTab+");checkForAllergy(this.value,"+lenTab+");");


				var newdiv = document.createElement('div');
				newdiv.setAttribute('id', 'ac2updates' + lenTab);
				newdiv.style.display = 'none';
				newdiv.className = "autocomplete";
				cellRight1.appendChild(newdiv);
				/* new Ajax.Autocompleter('nomenclature' + lenTab,
						'ac2updates' + lenTab,
						'opd?method=getItemListForAutoCompleteItem', {
							minChars : 3,
							parameters : 'requiredField=nomenclature' + lenTab
						}); */

				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'brandId' + lenTab;
				e1.id = 'brandId' + lenTab;
				e1.value=brandId;
				cellRight1.appendChild(e1);

				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'manufactureId' + lenTab;
				e1.id = 'manufactureId' + lenTab;
				cellRight1.appendChild(e1);

				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'pvmsNopTab' + lenTab;
				e1.id = 'pvmsNopTab' + lenTab;
				 e1.value = pvmsNo;
				cellRight1.appendChild(e1);

				var e1 = document.createElement('input');
				e1.type = 'hidden';
				e1.name = 'actualDispensingQtypTab' + lenTab;
				e1.id = 'actualDispensingQtypTab' + lenTab;
				cellRight1.appendChild(e1);

				var cellRight1 = rTab.insertCell(2);
				var e1 = document.createElement('Select');
				e1.name = 'routepTab' + lenTab;
				e1.id = 'routepTab' + lenTab;
				e1.style.width = "90px";
				e1.style.background = "#FFFF99";
				e1.tabIndex = hdbVal + "3";
				e1.options[0] = new Option('Select', '0');
				for (var i = 0; i < routeArray.length; i++) {
					e1.options[i + 1] = new Option(routeArray[i][1], routeArray[i][0]);
				}
				e1.value= route;
				/* e1.onblur = function() {
					fillRouteOnTAb(lenTab);
				}; */
				cellRight1.appendChild(e1);
				
				
				var cellRight1 = rTab.insertCell(3);
				var e1 = document.createElement('input');
				e1.name = 'dosagepTab' + lenTab;
				e1.id = 'dosagepTab' + lenTab;
				e1.className = "textYellow opdTextBoxTSmall";
				/* e1.onblur = function() {
					fillValue(this.value, lenTab);
				}; */
				e1.tabIndex = hdbVal + "4";
				e1.value = dosage;
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","fillValue(this.value,"+lenTab+",'tab')");
				
				
				var cellRight1 = rTab.insertCell(4);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'unitpTab' + lenTab;
				e1.id = 'unitpTab' + lenTab;
				e1.className = 'textYellow opdTextBoxTSmall';
				e1.readOnly = 'readOnly';
				e1.tabIndex = hdbVal + "5";
				e1.value = unit;
				cellRight1.appendChild(e1);

				var cellRight1 = rTab.insertCell(5);
				var e1 = document.createElement('Select');
				e1.name = 'frequencypTab' + lenTab;
				e1.id = 'frequencypTab' + lenTab;
				e1.style.width = "90px";
				e1.style.background = "#FFFF99";
				e1.tabIndex = hdbVal + "6";
				e1.options[0] = new Option('Select', '0');
				for (var i = 0; i < icdArray.length; i++) {
					e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]);
				}
				e1.selectedIndex = selectedFrequency;
				/* e1.onblur = function() {
					getFrequencyValue(this.value, lenTab);
					fillValue(this.value, lenTab);
					displaySOSQty(this.value, lenTab);
				}; */
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","getFrequencyValuepTab(this.value,"+lenTab+");fillValue(this.value,"+lenTab+",'tab');displaySOSQtypTab(this.value,"+lenTab+")");
				
				var e1 = document.createElement('hidden');
				e1.name = 'frequencyValuepTab' + lenTab;
				e1.id = 'frequencyValuepTab' + lenTab;
				e1.value=freqValue;
				cellRight1.appendChild(e1);

				var e21 = document.createElement('input');
				e21.type = 'hidden';
				e21.name = 'sosQtypTab' + lenTab;
				e21.id = 'sosQtypTab' + lenTab;
				e21.size = '5';
				e21.setAttribute('tabindex', '1');
				cellRight1.appendChild(e21);

				var eDiv = document.createElement('div');
				eDiv.setAttribute("style","width:100px; float: left");

				var cellRight1 = rTab.insertCell(6);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'noOfDayspTab' + lenTab;
				e1.className = "textYellow opdTextBoxTSmall";
				e1.id = 'noOfDayspTab' + lenTab;
				e1.size = '3';
				e1.value = duration;
				e1.tabIndex = hdbVal + "7";
				/* e1.onblur = function() {
					fillValueDays(lenTab);
					fillValue(this.value, lenTab);
				}; */
				var e11 = document.createElement('p');
				e11.setAttribute("style","line-height:0px;");
				e11.id="frequencyTypeForPrescriptionTab"+len; 
				
				e11.innerHTML = durationUnit;
				cellRight1.appendChild(eDiv);
				eDiv.appendChild(e1);
				eDiv.appendChild(e11);
				
				e1.setAttribute("onblur","fillValue(this.value,"+lenTab+",'tab');setEndDate(this.value,"+lenTab+");");
				

				var cellRight1 = rTab.insertCell(7);
				var e1 = document.createElement('Select');
				e1.name = 'instrunctionpTab' + lenTab;
				e1.id = 'instrunctionpTab' + lenTab;
				e1.style.width = "90px";
				e1.style.background = "#FFFF99";
				e1.tabIndex = hdbVal + "8";
				e1.options[0] = new Option('Select', '0');
				for (var i = 0; i < instructionArray.length; i++) {
					e1.options[i + 1] = new Option(instructionArray[i][1],
							instructionArray[i][0]);
				}
			/* 	e1.onblur = function() {
					fillInstrunctionOnTAb(lenTab);
				}; */
				cellRight1.appendChild(e1);
				
				

				var cellRight1 = rTab.insertCell(8);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'splInstrunctionpTab' + lenTab;
				e1.id = 'splInstrunctionpTab' + lenTab;
				e1.tabIndex = hdbVal + "9";
				e1.className = "textYellow opdTextBoxSmall";
				/* e1.onblur = function() {
					fillSPLInstrunctionOnPTAb(lenTab);
				}; */
				e1.size = '5';
				cellRight1.appendChild(e1);
				
				

				var cellRight1 = rTab.insertCell(9);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'totalpTab' + lenTab;
				e1.id = 'totalpTab' + lenTab;
				e1.className = "textYellow opdTextBoxTSmall";
				e1.readOnly = 'readOnly';
				e1.size = '5';
				e1.value = total;
				cellRight1.appendChild(e1);

				var cellRight1 = rTab.insertCell(10);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'unitLablepTab' + lenTab;
				e1.id = 'unitLablepTab' + lenTab;
				e1.className = "textYellow opdTextBoxTSmall";
				e1.readOnly = 'readOnly';
				e1.size = '5';
				cellRight1.appendChild(e1);
				
				var cellRight1 = rTab.insertCell(11);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'startDate' + lenTab;
				e1.id = 'startDate' + lenTab;
				e1.size = '5';
				e1.value = startDate;
				e1.className = 'textYellow small';
				e1.readOnly = true;
				/* e1.onblur = function() {
					compareDate(iteration);
				}; */
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","compareDate("+lenTab+");checkStartDate("+lenTab+")");
				

				var img1 = document.createElement('img');
				img1.src = '/hms/jsp/images/cal.gif';
				var obj = document.getElementById('startDate' + lenTab);
				/* img1.onclick = function(event) {
					setdate(document.getElementById('startDate').value, obj, event);
				}; */
				cellRight1.appendChild(img1);
				img1.setAttribute("onclick","setdate("+startDate+","+obj+",event)");
				
				
				
				var cellRight1 = rTab.insertCell(12);
				var e1 = document.createElement('input');
				e1.type = 'text';
				e1.name = 'endDate' + lenTab;
				e1.id = 'endDate' + lenTab;
				e1.size = '5';
				e1.value = endDate;
				e1.readOnly = true;
				e1.className = 'textYellow small';
				e1.readOnly = true;
				/* e1.onblur = function() {
					compareDate(iteration);
				}; */
				cellRight1.appendChild(e1);
				e1.setAttribute("onblur","compareDate("+lenTab+");checkEndDate("+lenTab+")");
				
				
				var img2 = document.createElement('img');
				img2.src = '/hms/jsp/images/cal.gif';
					var obj = document.getElementById('endDate' + lenTab);
				/* img2.onclick = function(event) {
					setdate(document.getElementById('endDate').value, obj, event);
				}; */
				cellRight1.appendChild(img2);
				img2.setAttribute("onclick","setdate("+endDate+","+obj+",event)");
				
				
				
				window.opener.document.getElementById('hdb').value=len;
				window.opener.document.getElementById('hdbTabIndex').value=parseInt(window.opener.document.getElementById('hdbTabIndex').value)+1;
				window.opener.document.getElementById('pTabhdb').value=lenTab;
				checkRepeatPrescriptionItem(len,visitId,pvmsNo);
				
			 /*  window.opener.document.getElementById("nomenclature"+index).value=''+nomenclature;
			  window.opener.document.getElementById("pvmsNo"+index).value=''+pvmsNo;
			  window.opener.document.getElementById("dosage"+index).value=''+eval('document.'+formName+'.dosage' + index + '.value');
			  window.opener.document.getElementById("unit"+index).value=''+eval('document.'+formName+'.unit' + index + '.value');
			  window.opener.document.getElementById("frequency"+index).selectedIndex=selectedFrequency;
			  window.opener.document.getElementById("noOfDays"+index).value=eval('document.'+formName+'.noOfDays' + index + '.value');
			  window.opener.document.getElementById("total"+index).value=eval('document.'+formName+'.total' + index + '.value');
			  
			  window.opener.document.getElementById("nomenclaturepTab"+index).value=''+nomenclature;
			  window.opener.document.getElementById("pvmsNopTab"+index).value=''+pvmsNo;
			  window.opener.document.getElementById("dosagepTab"+index).value=''+eval('document.'+formName+'.dosage' + index + '.value');
			  window.opener.document.getElementById("unitpTab"+index).value=''+eval('document.'+formName+'.unit' + index + '.value');
			  window.opener.document.getElementById("frequencypTab"+index).selectedIndex=selectedFrequency;
			  window.opener.document.getElementById("noOfDayspTab"+index).value=eval('document.'+formName+'.noOfDays' + index + '.value');
			  window.opener.document.getElementById("totalpTab"+index).value=eval('document.'+formName+'.total' + index + '.value');*/
			  //window.opener.copyToPrescriptionTAb(hdbVal1,'opconsult'); 
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
	var visitId = document.getElementById("visitId").value;
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

		var url = "/hms/hms/opd?method=checkForAlreadyIssuedPrescribtion&val="
				+ val + "&visitId=" + visitId + "&" + csrfTokenName + "="
				+ csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);

	}
}
</script>