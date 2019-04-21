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
<%@page import="java.util.*,java.math.BigDecimal,jkt.hms.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<!--<script type="text/javascript">
	ddaccordion.init({
		headerclass: "expandable", //Shared CSS class name of headers group that are expandable
		contentclass: "categoryitems", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false
		defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen: true, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
</script>-->
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<link rel="stylesheet" href="/hms/jsp/css/style.css" type="text/css" />
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>

<%
	Map map = new HashMap();
	String chargeCodeName1="";
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	List<PatientInvestigationDetails> patientInvestigationList= new ArrayList<PatientInvestigationDetails>();	
	if(map.get("patientInvestigationList")!=null){
		patientInvestigationList = (List)map.get("patientInvestigationList");
	
	}
	if(map.get("chargeCodeName1")!=null){
		chargeCodeName1 = (String)map.get("chargeCodeName1");
	
	}
	%>
<script type="text/javascript">
	function cancelForm(){
  	 close();
   	}


</script>
<div id="contentHolder">
<div class="titleBg">
<h2>Patient Investigation  Details</h2>
</div>
<div class="clear"></div>


<form name="patientInvestigation" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(patientInvestigationList.size() > 0){ %>

<div class="tableHolderAuto">
<table  id="indentDetails" class="small">
 

		<tr>

			<th width="5%">Test Name</th>
			<th width="13%">Test Code</th>
			<th width="10%">Rate</th>
			<th width="13%">Clinical Notes</th>
			<th width="13%">Repeat Investigation</th>

		</tr>

 

 
		<% 
			
 		 
  					int i=1;
  					Iterator itr= patientInvestigationList.iterator();
  					while(itr.hasNext())
  					{
  						 String dateOfExpiryInString= null;
  						 BigDecimal rate =new BigDecimal(0.00);
  						 PatientInvestigationDetails patientInvestigationDetails=(PatientInvestigationDetails)itr.next();
  						 
  			         	 int investigationId=patientInvestigationDetails.getId();
  			         	 String chargeCode=patientInvestigationDetails.getChargeCode().getChargeCodeCode();
  			         	 String ChargeCodeName=patientInvestigationDetails.getChargeCode().getChargeCodeName();
  			         	 int chargeId=patientInvestigationDetails.getChargeCode().getId();
  			        	 rate=patientInvestigationDetails.getRate();
  			        	 String clinicalNotes=patientInvestigationDetails.getClinicalNotes();
  			        	 
 			%>

		<tr>
			<td width="5%"><input type="text" name="ChargeCodeName<%=i %>"
				readonly="readonly" value="<%=ChargeCodeName %>" /> <input
				type="hidden" name="investigationId<%=i %>"
				value="<%=investigationId %>" /> <input type="hidden"
				name="chargeId<%=i %>" value="<%=chargeId %>" /></td>

			<td width="13%"><input type="text" id="chargeCode<%=i %>"
				name="chargeCode<%=i %>" readonly="readonly"
				value="<%=chargeCode %>" /></td>

			<td width="10%"><input type="text" name="rate<%=i%>"
				readonly="readonly" value="<%=rate%>" /></td>

			<td width="13%"><input type="text" name="clinicalNotes<%=i %>"
				readonly="readonly" value="<%=clinicalNotes %>" /></td>

			<td width="13%"><input type="checkbox"
			id="repeatInvestigation<%=i %>"	name="repeatInvestigation<%=i %>" value="" class="radioCheck" /></td>
	</tr>
	
		<%
  	 	i++;
  	   }
  	 %>
  	 <input type="hidden" id="checkForRadio" value="<%=i %>"/> 
</table>
</div>
<div class="clear"></div>
<div id="edited"></div>
<input id="save" property="save" type="button" tabindex="1"	name="repeat" value="Repeat" class="button"	onclick="if(checkRepeat()){setValuesInParent(patientInvestigation)}" />
<input	type="button" name="cancel" id="addbutton" value="Cancel"	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />
<input	type="hidden" name="counter" id="counter" value="<%=i %>" />
<div class="clear"></div>
<%}else{ %>
<h4><span> No Records Found!</span></h4>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="cancel" id="addbutton" value="Cancel"	class="button" onClick="cancelForm();" accesskey="a" tabindex=1 />
<%} %>
</form>
</div>

<script type="text/javascript">

	function setValuesInParent(formname){
  		var formName=formname.name;
 		 

  		var hiddenValue = window.opener.document.getElementById('hiddenValue').value;
 		var chargeCodeNameVal = window.opener.document.getElementById('chargeCodeName1').value;

		if(hiddenValue == 1 && chargeCodeNameVal == ''){
			var len = window.opener.document.getElementById("investigationGrid").rows.length;
			var r1 = window.opener.document.getElementById("investigationGrid").deleteRow(len-1);
		}
  	   
		//window.opener.document.getElementById('date').value
		//var qtyIssuedList = document.getElementsByName("qtyIssued");
		//alert("value of counter--"+document.patientInvestigation.counter.value)
		for(var index = 1; index <parseInt(document.patientInvestigation.counter.value); index++ ){
		var toEval = "document.patientInvestigation.repeatInvestigation" + index;
		var repeatIn = eval(toEval);
		if(repeatIn.checked == true){
		
			  var len = window.opener.document.getElementById("investigationGrid").rows.length;
			 
			  var r = window.opener.document.getElementById("investigationGrid").insertRow(len);

			  var c1 = r.insertCell(0);
			  var c2 = r.insertCell(1);
			  var c3 = r.insertCell(2);
			  var c4 = r.insertCell(3);

			  var chargeCodeName=eval('document.'+formName+'.ChargeCodeName' + index + '.value')
			  var chargeId=eval('document.'+formName+'.chargeId' + index + '.value')
			   
			  var x1 = window.opener.document.createElement('input');
			  x1.type = 'text';
			  x1.name='chargeCodeName'+len;
			  x1.id='chargeCodeName'+len;
			  x1.size = '65';
  			  x1.setAttribute('tabindex','1');						  
			  x1.value = chargeCodeName+"["+chargeId+"]";
			  //x1.setAttribute("readonly","readonly");
			  c1.appendChild(x1);

			  var divElement = window.opener.document.createElement('div');
			  divElement.id='ac2update2';
			  divElement.style.display = 'none';
			  //divElement.style.fontWeight = 'normal;';
			  //divElement.style.border = '0px solid white;';
			  //divElement.style.paddingRight = '10px;';
			 // divElement.style.backgroundColor = 'white;';
			  c1.appendChild(divElement);

			  var chargeCode=eval('document.'+formName+'.chargeCode' + index + '.value')
			  
			  var x2 = window.opener.document.createElement('input');
			  x2.type = 'text';
			  x2.name='chargeCode'+len;
			  x2.id='chargeCode'+len;
			  x2.size='15';
			  x2.value = chargeCode;
  			  x2.setAttribute('tabindex','1');				  
			  x2.setAttribute("readonly","readonly");
			  c2.appendChild(x2);

			  var rate = eval('document.'+formName+'.rate' + index + '.value');
			  
			  var x3 = window.opener.document.createElement('input');
			  x3.type = 'text';
			  x3.name='rate'+len;
			  x3.id='rate'+len;
			  x3.size='8';
  			  x3.setAttribute('tabindex','1');				  
			  x3.value = rate;
			  x3.setAttribute("readonly","readonly");
			  c3.appendChild(x3);
			  
			  var clinicalNotes = eval('document.'+formName+'.clinicalNotes' + index + '.value');
			  
			  var x4 = window.opener.document.createElement('input');
			  x4.type = 'text';
			  x4.name='clinicalNotes'+len;
			  x4.id='clinicalNotes'+len;
  			  x4.setAttribute('tabindex','1');				  
			  x4.value = clinicalNotes;
			  x4.size = '20';
			  x4.setAttribute("readonly","readonly");
			  c4.appendChild(x4);
			  var x5 = window.opener.document.getElementById('hiddenValue');
			   x5.value =len;
			}
		}
	
		window.close() ;
  	}
		
	function checkRepeat(){
var inc = document.getElementById('checkForRadio').value;
for(i=1;i<inc;i++){
	if(document.getElementById('repeatInvestigation'+i).checked == true){
return true;

	}	
		}
alert("Please Select Atleast One Test To Repeat");
return false;
		}
		
</script>



