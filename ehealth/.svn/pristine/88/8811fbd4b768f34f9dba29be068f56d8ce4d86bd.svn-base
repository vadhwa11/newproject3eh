<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opd_inpatientprescription.jsp
 * Purpose of the JSP -  This is for Inpatient Previous Prescription details.
 * @author  Ramdular
 * Create Date: 16/12/2010
 * Revision Date:
 * Revision By:
 * @version 1.5
--%>


<%@page import="java.util.*,java.math.BigDecimal,jkt.hms.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>


<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%
	Map map = new HashMap();
	String nomenclature1="";
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List<InpatientPrescriptionDetails> patientPrescriptionList= new ArrayList<InpatientPrescriptionDetails>();
	if(map.get("patientPrescriptionList")!=null){
		patientPrescriptionList = (List)map.get("patientPrescriptionList");

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

	%>
<script type="text/javascript">
	function cancelForm(){
  	 close();
   	}
	   var icdArray=new Array();


</script>
<div id="contentHolder">
<div class="titleBg">
<h2>InPatient Prev. Prescription Details</h2>
</div>
<div class="clear"></div>


<form name="patientPrescription" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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

<div class="cmntableWithHeight">
<table  border="0" align="center" cellpadding="0" cellspacing="0" class="small"	>
		<tr>
	<th scope="col" style="width: 50px;">Repeat Prescription</th>
			<th scope="col">Prescription Date</th>
			<th scope="col">Item Name</th>
				<!--<th scope="col">Brand Name</th>
			<th scope="col">Manufacturer</th>-->
			<th scope="col" style="width: 50px;">Dosage</th>
			<th scope="col" style="width: 100px;">Frequency</th>
			<th scope="col" style="width: 50px;">No.of Days</th>
			<th scope="col" style="width: 50px;">Total</th>


		</tr>
<%
					int i=1;
  					Iterator itr= patientPrescriptionList.iterator();
  					Iterator itr1= storeItemBatch.iterator();
  					while(itr.hasNext())
  					{
  						BigDecimal dml= new BigDecimal(0.0);
  						if(itr1.hasNext()){
  							 dml=(BigDecimal)itr1.next();
   						}
  						 String dateOfExpiryInString= null;
  						 InpatientPrescriptionDetails patientPrescriptionDetails=(InpatientPrescriptionDetails)itr.next();
  						 MasStoreBrand brand=new MasStoreBrand();
  			         	 int itemId=patientPrescriptionDetails.getItem().getId();
  			         	 String pvms = patientPrescriptionDetails.getItem().getPvmsNo();
  			         	String brandName = null;
  			         	int brandId =0;
  			         	 if(patientPrescriptionDetails.getBrand()!=null){
	  			         	 brandName = patientPrescriptionDetails.getBrand().getBrandName();
	  			         	 brandId = patientPrescriptionDetails.getBrand().getId();
  			         	 }
  			         	 String presDate="";
  			         	 if(patientPrescriptionDetails.getPrescription().getPrescriptionDate()!=null ){
  			         		 presDate=HMSUtil.changeDateToddMMyyyy(patientPrescriptionDetails.getPrescription().getPrescriptionDate());
  			         	 }
  	 %>
   <%
  			         	 String manufacturer =null;
  			          if(patientPrescriptionDetails.getManufacturer()!=null)
  			          {
  			        	  manufacturer = patientPrescriptionDetails.getManufacturer().getManufacturerName();
  			          }
  			         	 int manufactureId =patientPrescriptionDetails.getManufacturer().getId();
  			        	 String nomenclature=patientPrescriptionDetails.getItem().getNomenclature();
  			        	 String dosage=patientPrescriptionDetails.getDosage();
  			        	 String frequency=patientPrescriptionDetails.getFrequency().getFrequencyName();
  			        	 int frequencyId=patientPrescriptionDetails.getFrequency().getId();
  			        	 int total=patientPrescriptionDetails.getTotal();
  			        	 int noOfDays=patientPrescriptionDetails.getNoOfDays();
  			        	 String typeLeftRight=patientPrescriptionDetails.getType();
 %>

		<tr>
			 <td>
			 <%if(dml!=null && dml.compareTo(new BigDecimal(0))>0 ) {
	  				%>
			 <input type="checkbox" style="width: 50px;"
				name="repeatPrescription<%=i %>" id="repeatPrescription<%=i %>" class="radioCheck" value="" />
				<% }else{ %>
				 <input type="checkbox" disabled="true" style="width: 50px;"
				name="repeatPrescription<%=i %>" id="repeatPrescription<%=i %>" class="radioCheck" value="" />
				<%} %>
				</td>
			<%if(presDate!=null && presDate!="") {%>
			<td> <input type="text" id="presDate<%=i%>" name="presDate<%=i %>" 
			value="<%=presDate %>" readonly="readonly"/></td>
			<%}else{%>
			<td> <input type="text" readonly="readonly" id="presDate<%=i%>" name="presDate<%=i %> "
			value="%>"/></td>
			<%} %>
			<td><input type="text" size="50" id="nomenclature<%=i%>" name="nomenclature<%=i%>"
				readonly="readonly" value="<%=nomenclature %>" />
				<div id="ac2update1" style="font-weight: normal; display: none; border: 1px solid black;
				 padding-right: 10px; background-color: white;"> </div>
		       
		        <input type="hidden" name="pvmsNo<%=i%>" id="pvmsNo<%=i%>" size="10" value="<%=pvms%>"/>
		        <input	type="hidden" name="itemId<%=i%>" id="itemId<%=i%>" value="<%=itemId%>" />
		        <input type="hidden" id="brandId<%=i%>" name="brandId<%=i%>" value="<%=brandId%>"/>
		        <input type="hidden" id="manufacturer<%=i%>" name="manufacturer<%=i%>" readonly="readonly" value="<%=manufacturer%>"/>
		       <input type="hidden" name="brandName<%=i%>" id="brandName<%=i%>" value="<%=brandName%>"></input>
			   <input type="hidden" id="manufactureId<%=i%>" name="manufactureId<%=i %>" value="<%=manufactureId%>" />
		       </td>
			 <td><input type="text" id="dosage<%=i%>" name="dosage<%=i%>" style="width: 50px;"
				readonly="readonly" value="<%=dosage %>" /></td>

			<td><select name="frequency<%=i %>" id="frequency<%=i %>" disabled="disabled" style="width: 100px;"
			tabindex="1" >
			<option value="0">Select</option>
			<%

		      for(MasFrequency frequency2 : frequencyList){
		       int id = frequency2.getId();
		       String name = frequency2.getFrequencyName();
		       if(frequency.equals(name)){ %>
			<option value="<%=id %>" selected="selected"><%=name%></option>
			<% }else{ %>
			<option value="<%=id %>"><%=name%></option>
			<% }
          %>

			<%} %>
		</select>
</td>

			<td><input type="text" id="noOfDays<%=i%>" name="noOfDays<%=i%>" style="width: 50px;"
				readonly="readonly" value="<%=noOfDays %>" /></td>
			<td><input type="text" id="total<%=i%>" name="total<%=i%>" style="width: 50px;"
				readonly="readonly" value="<%=total %>" /></td>
			</tr>
			<%
  	 	i++;
  	   }
  	 %>


</table>
</div>
<div class="clear"></div>
<div id="edited"></div>
<input id="save" property="save" type="button" tabindex="1" name="save"	value="Repeat" 
class="button"	onclick="setValuesInParentForPrescription(patientPrescription)" />

<input	type="button" name="cancel" id="addbutton" value="Close"	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />
<input	type="hidden" name="counter" id="counter" value="<%=i %>" />
</div>
<div class="clear"></div>
	<%}else{ %>
<h4><span>No Records Found!</span></h4>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="cancel" id="addbutton" value="Close" class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />

	 <%} %>

<div class="clear"></div>
</form>
</div>

<script type="text/javascript">

	function setValuesInParentForPrescription(formname){
  		formName=formname.name;

  		var grid = window.opener.document.getElementById("grid").rows.length;
  	//	var investigationGrid = window.opener.document.getElementById("investigationGrid").rows.length;
		//alert(investigationGrid)
		//if(investigationGrid>2){
		// var rows=investigationGrid-2
		//  alert("Please Delete "+ rows+"  rows From Investigation.")
		//  return;
		//}


		//alert("value of counter--"+document.patientPrescription.counter.value)
		var hdbVal = window.opener.document.getElementById('hdb').value;
 		var nomenclatureVal = window.opener.document.getElementById('nomenclature1').value;

 		if(hdbVal == 1 && nomenclatureVal == ''){
			var len = window.opener.document.getElementById("grid").rows.length;
			var r1 = window.opener.document.getElementById("grid").deleteRow(len-1);
			 window.opener.document.getElementById('hdb').value='0';
		}


		for(var index = 1; index < parseInt(document.patientPrescription.counter.value); index++ ){
		var toEval = "document.patientPrescription.repeatPrescription" + index;
		var repeatIn = eval(toEval);

		if(repeatIn.checked == true){
		 var len = window.opener.document.getElementById("grid").rows.length;
		 var r = window.opener.document.getElementById("grid").insertRow(len);

			  var c1 = r.insertCell(0);
			  c1.id='nomenclatureDiv'+len;
			  var c2 = r.insertCell(1);
			  c2.id="testDiv"+len;
			  var c3 = r.insertCell(2);
			  c3.id='manufacturereDiv'+len;
			  var c4 = r.insertCell(3);
			  var c5 = r.insertCell(4);
			  var c6 = r.insertCell(5);
			  var c7=r.insertCell(6);
			  var c8 = r.insertCell(7);

			  var nomenclature=eval('document.'+formName+'.nomenclature' + index + '.value')
			  var pvmsNo=eval('document.'+formName+'.pvmsNo' + index + '.value')
			  var itemId=eval('document.'+formName+'.itemId' + index + '.value')
			  var brandId=eval('document.'+formName+'.brandId' + index + '.value')
			  var brandName=eval('document.'+formName+'.brandName' + index + '.value')

			  var manufacturer=eval('document.'+formName+'.manufacturer' + index + '.value')
			  var manufactureId=eval('document.'+formName+'.manufactureId' + index + '.value')

			/*  var divElement = document.createElement('div');
			  divElement.setAttribute('id','ac2updates'+len);
			  divElement.style.display = 'none';
			  divElement.style.paddingRight = '10px;';
			  c1.appendChild(divElement);

			  var x1 = document.createElement('input');
			  x1.type = 'text';
			  x1.name='nomenclature'+len;
			  x1.id='nomenclature'+len;
			  x1.size = '50';
  			  x1.setAttribute('tabindex','1');
			  x1.value = nomenclature+"["+pvmsNo+"]";
			  x1.onblur=function(){

				  prescriptionForm.populatebrand(this.value, len);
					prescriptionForm.checkItem(len);
                };
			  //x1.setAttribute("readonly","readonly");
			  c1.appendChild(x1);
  			  new Ajax.Autocompleter('nomenclature'+len,'ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+len});
		    var x3 = document.createElement('input');
			  x3.type = 'hidden';
			  x3.name='pvmsNo'+len;
			  x3.id='pvmsNo'+len;
			  x3.setAttribute('tabindex','1');
			  x3.value = pvmsNo;
			  //x1.setAttribute("readonly","readonly");
			  c1.appendChild(x3);*/

		    /*-- var divElement1 = document.createElement('div');
			  divElement1.setAttribute('id','testDiv1');
			  divElement1.style.display = 'none';
			  divElement1.style.paddingRight = '10px;';
			  c2.appendChild(divElement1);--*/

				  /*var x2 = document.createElement('input');
			  x2.type = 'hidden';
			  x2.name='brandId'+len;
			  x2.id='brandId'+len;
			  x2.value = brandId;
  			  x2.setAttribute('tabindex','1');
			  c1.appendChild(x2);

				 var x4 = document.createElement('input');
				  x4.type = 'hidden';
				  x4.name='manufacturer'+len;
				  x4.id='manufacturer'+len;
				  x4.setAttribute('tabindex','1');
				  x4.value = manufacturer;
				  x4.size='10';
				  //x1.setAttribute("readonly","readonly");
				  c1.appendChild(x4);

				 var x5 = document.createElement('input');
					  x5.type = 'hidden';
					  x5.name='manufactureId'+len;
					  x5.id='manufactureId'+len;
					  x5.setAttribute('tabindex','1');
					  x5.value = manufactureId;
					  //x1.setAttribute("readonly","readonly");
					  c1.appendChild(x5);

				 var x6 = document.createElement('input');
					  x6.type = 'text';
					  x6.name='dosage'+len;
					  x6.id='dosage'+len;
					  x6.size = '10';
		  			  x6.setAttribute('tabindex','1');
					  x6.value = eval('document.'+formName+'.dosage' + index + '.value');
					  x6.onblur=function()
				      {
						  prescriptionForm.fillValue(this.value,len);
					    };
					  //x3.setAttribute("readonly","readonly");
					  c2.appendChild(x6);



					  var x7 = document.createElement('Select');
					  x7.name='frequency'+len;
					  x7.id='frequency'+len;
					  x7.classname='smalllabel';
					  x7.options[0] = new Option('Select', '0');
					  selectedFrequency = eval('document.'+formName+'.frequency' + index + '.value');
		   		      for(var i = 0;i<icdArray.length;i++ ){
		   		      	if(selectedFrequency == icdArray[i][0]){
		   		      		x7.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
		   		      		x7.options[i+1].setAttribute('Selected','Selected');
		   		      	}else{
		      		  		x7.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
		   		      	}
		      		  }
				      x7.setAttribute('tabindex','1');
				      x7.onblur=function()
				      {
				    	  prescriptionForm.fillValue(this.value,len);
					    };
					  c3.appendChild(x7);

					  var x8 = document.createElement('input');
					  x8.type = 'text';
					  x8.name='noOfDays'+len;
					  x8.id='noOfDays'+len;
					  x8.size = '3';
		  			  x8.setAttribute('tabindex','1');
					  x8.value = eval('document.'+formName+'.noOfDays' + index + '.value');
					  x8.onblur=function()
				      {
						  prescriptionForm.fillValue(this.value,len);
					    };
					  //x5.setAttribute("readonly","readonly");
					  c4.appendChild(x8);

					  var x9 = document.createElement('input');
					  x9.type = 'text';
					  x9.name='total'+len;
					  x9.id='total'+len;
					  x9.size = '5';
		  			  x9.setAttribute('tabindex','1');
					  x9.value = eval('document.'+formName+'.total' + index + '.value');
					  //x6.setAttribute("readonly","readonly");
					  c5.appendChild(x9);


						 var x11 = document.createElement('input');
						  x11.type = 'hidden';
						  x11.name='brandName'+len;
						  x11.id='brandName'+len;
						  x11.setAttribute('tabindex','1');
						  x11.value = brandName;
						  //x1.setAttribute("readonly","readonly");
						  c3.appendChild(x11);*/

			      //var x12 = window.opener.document.getElementById('hdb');
					
			       //x12.value=len;
			      
			   window.opener.addRowNewWin();
			    
					var nn= window.opener.document.getElementById('hdb').value;
					//var nn1=parseInt(nn)-1
			 if(window.opener.document.getElementById('nomenclature' + nn)==null ||
			    window.opener.document.getElementById('nomenclature' + nn).value=="12" ){
			    window.opener.document.getElementById('nomenclature' + nn).value = 
			    nomenclature+"["+pvmsNo+"]";
			    }
			if(window.opener.document.getElementById('brandId'+ nn)==null ||
			   window.opener.document.getElementById('brandId'+ nn).value=="12" ){
			   window.opener.document.getElementById('brandId'+ nn).value = brandId;
			   }
			if(window.opener.document.getElementById('manufactureId'+ nn)==null ||
			   window.opener.document.getElementById('manufactureId'+ nn).value=="12" ){
			   window.opener.document.getElementById('manufactureId'+ nn).value = manufactureId;
			   }
			if(window.opener.document.getElementById('dosage'+ nn)==null ||
					   window.opener.document.getElementById('dosage'+ nn).value=="12" ){
					   window.opener.document.getElementById('dosage'+ nn).value = 
						   eval('document.'+formName+'.dosage' + index + '.value');
					   }
			if(window.opener.document.getElementById('frequency'+ nn)==null ||
					   window.opener.document.getElementById('frequency'+ nn).value=="0" ){
					   window.opener.document.getElementById('frequency'+ nn).value = 
						   eval('document.'+formName+'.frequency' + index + '.value');
					   }
			if(window.opener.document.getElementById('noOfDays'+ nn)==null ||
					   window.opener.document.getElementById('noOfDays'+ nn).value=="12" ){
					   window.opener.document.getElementById('noOfDays'+ nn).value = 
						   eval('document.'+formName+'.noOfDays' + index + '.value');
					   }
			if(window.opener.document.getElementById('total'+ nn)==null ||
					   window.opener.document.getElementById('total'+ nn).value=="12" ){
					   window.opener.document.getElementById('total'+ nn).value = 
						   eval('document.'+formName+'.total' + index + '.value');
					   }
			if(window.opener.document.getElementById('pvmsNo'+ nn)==null ||
					   window.opener.document.getElementById('pvmsNo'+ nn).value=="12" ){
					   window.opener.document.getElementById('pvmsNo'+ nn).value = pvmsNo;
					   }
			}
		}

	window.close();
						//  document.getElementById('nomenclature' + nn1).value;
  	}


</script>
