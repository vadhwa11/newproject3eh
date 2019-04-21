<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar2.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript">
		   var icdArray=new Array();
		   var icdArray1=new Array();
		   
</script>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
		 List<RouteOfAdministration> routeOfAdministrationList = new   ArrayList<RouteOfAdministration>();
			if(map.get("routeOfAdministrationList") != null)
			{
				routeOfAdministrationList=(List<RouteOfAdministration>)map.get("routeOfAdministrationList");
			}
			
			
			List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
			if(map.get("frequencyList") != null){
			frequencyList=(List)map.get("frequencyList");
			}
		
		
		if(map.get("message") != null){
		 String  message = (String)map.get("message");
		 
		
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %>


<div class="titleBg">
<h2>Prescription Mapping</h2>
</div>
<div class="clear"></div>
<div class="Block">
<form name="prescriptionMapping" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
					<div class="addDeleteButton">
						<input type="button" class="buttonDel" value=""		onclick="removeRow();" /> 
						<input type="button" class="buttonAdd"	onclick="addRow();" value="" />
					</div>
					
					<div class="clear"></div>
		
								<table border="0" align="center" cellpadding="0" cellspacing="0"	id="grid">
									<tr>
										<th scope="col">&nbsp;</th>
										<th scope="col">Item Name</th>
										<th scope="col">Unit</th>
										<th scope="col">Route</th>
										<th scope="col">Dosage</th>
										<th scope="col">Frequency</th>
										<th scope="col">Duration</th>
									</tr>
									<%
	int incr = 0,len=1;
	int inxRow=1;
	String frequecnyType="";
	for(;incr< len;incr++,inxRow++){
		
	%>
	<tr>
	
	<td>
	<input	type="checkbox" 	class="radioCheck" id="itemRadio<%=incr %>"		name="itemRadio<%=incr %>" 	 /> 
	</td>
	
	<td>
	<input type="text"	  value="" id="nomenclature<%=incr%>" size="35"		name="nomenclature<%=incr%>"		onblur="displayAu(this.value,'<%=incr%>');" />
	<div id="ac2updates<%=incr%>" style="display: none;"	class="autocomplete"></div>
	<script type="text/javascript"	language="javascript" charset="utf-8">
			new Ajax.Autocompleter('nomenclature<%=incr%>','ac2updates<%=incr%>','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclature<%=incr%>'});
	</script>
	<input type="hidden" name="pvmsNo<%=incr %>" id="pvmsNo<%=incr %>" value=""	size="10" readonly="readonly" /> 
	</td>
				
	<td><input type="text" name="unit<%=incr %>"	value=""	class="textYellow opdTextBoxTSmall" id="unit<%=incr %>"		readonly="readonly" size="5" onblur="" /></td>
	
	<td><input type="text" name="route<%=incr %>"	value=""	class="textYellow opdTextBoxTSmall" id="route<%=incr %>"		readonly="readonly" size="10" />
<%-- 	
	<select name="route<%=incr%>"	id="route<%=incr%>"		style="width: 90px; background: #FFFF99">
			<option value="0">Select</option>
			<% for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
			   	  
							       int id = routeOfAdministration.getId();
							       String name = routeOfAdministration.getRouteName();
			 %>
												
											
							<option  value="<%=id %>"><%=name%></option>
											
							<%}%>
							</select>  --%>
							
							
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
			</td>
			<td><input class="textYellow opdTextBoxTSmall" 	 type="text"		name="dosage<%=incr%>" id="dosage<%=incr%>"		value="" size="10"		maxlength="45" /></td>
									
			<td> <select style="width: 90px; background: #FFFF99"		name="frequency<%=incr%>"	id="frequency<%=incr%>"	 onchange="displaFrequencyType(this,<%=incr%>)">
					<option value="0">Select</option>
					<%
												      for(MasFrequency masFrequency2 : frequencyList){
												       int id = masFrequency2.getId();
												       String name = masFrequency2.getFrequencyName();
												       String type = masFrequency2.getFrequencyType();
					%>
												
												<option  id="<%=type %>"   value="<%=id %>"><%=name%></option>
<%} %>
										</select>
										
										<%	MasFrequency  masFrequency3 = null;
										        for (int i = 0; i < frequencyList.size(); i++) {
										      	 masFrequency3 = (MasFrequency) frequencyList.get(i);
							     		 %> <script>
								          icdArray[<%=i%>]= new Array();
								          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
								          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
								          icdArray[<%=i%>][2] = "<%=masFrequency3.getFrequencyType()%>";
							            </script> <% }%>
	          					  </td>
										
										
										
										<td>
											<div style="width:100px; float: left;">
											<input type="text"	 name="noOfDays<%=incr%>"	id="noOfDays<%=incr%>" value="" 	class="textYellow opdTextBoxTSmall" size="3" maxlength="3"
											validate="No Of Days,num,no"/>
										
									<p style="line-height:0px;" id="frequencyType<%=incr %>" ><%=frequecnyType %></p>
                                         </div>
                                         <input type="hidden" name="presMapId<%=incr %>" value="" id="presMapId<%=incr %>" />
										</td>
										
									</tr>
									<%} %>
					
								</table>
								<input type="hidden" name="hdb" value="<%=incr %>" id="hdb" />
															
						<!-- </div> -->
					</div>

					<div class="clear"></div>
	

			<input  type="button" align="right" class="button" value="Submit"	onclick="submitForm('prescriptionMapping','/hms/hms/opdMaster?method=submitPrescriptionMapping');" />
					

</form>
</div>


<script>


function displayAu(val, inc) {
	
	if (val != "") {
		var index1 = val.lastIndexOf("[");
		var indexForBrandName = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvmsNo = val.substring(index1, index2);
		var indexForBrandName = indexForBrandName--;
		var brandName = val.substring(0, indexForBrandName);
		document.getElementById('pvmsNo' + inc).value = pvmsNo;
		if (pvmsNo == "") {
			document.getElementById('nomenclature' + inc).value = "";
			document.getElementById('pvmsNo' + inc).value = "";
			return;
		} else
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
				var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
				for (loop = 0; loop < items.childNodes.length; loop++) {
					var item = items.childNodes[loop];

					var au = item.getElementsByTagName("au")[0];
					var route = item.getElementsByTagName("route")[0];
					var dosage = item.getElementsByTagName("dosage")[0];
					var noOfDays = item.getElementsByTagName("noOfDays")[0];
					var freq = item.getElementsByTagName("freq")[0];
					var freqType = item.getElementsByTagName("freqType")[0];
					var presMapId = item.getElementsByTagName("presMapId")[0];
					
					
					if (document.getElementById('unit' + inc)	&& au.childNodes[0] != undefined) {
						document.getElementById('unit' + inc).value = au.childNodes[0].nodeValue;
					}
					if (document.getElementById('route' + inc)	&& route.childNodes[0] != undefined) {
						document.getElementById('route' + inc).value = route.childNodes[0].nodeValue;
					}
					
					if(dosage.childNodes[0]!=undefined && dosage.childNodes[0].nodeValue!=undefined){
						document.getElementById('dosage' + inc).value = dosage.childNodes[0].nodeValue;
					}
					if(noOfDays.childNodes[0]!=undefined && noOfDays.childNodes[0].nodeValue!=undefined){
						document.getElementById('noOfDays' + inc).value = noOfDays.childNodes[0].nodeValue;
					}
					if(freq.childNodes[0]!=undefined && freq.childNodes[0].nodeValue!=undefined){
						document.getElementById('frequency' + inc).value = freq.childNodes[0].nodeValue;
					}
					if(freqType.childNodes[0]!=undefined && freqType.childNodes[0].nodeValue!=undefined){
						document.getElementById('frequencyType'+inc).innerHTML = freqType.childNodes[0].nodeValue;
					}
					if(presMapId.childNodes[0]!=undefined && presMapId.childNodes[0].nodeValue!=undefined){
						document.getElementById('presMapId'+inc).value = presMapId.childNodes[0].nodeValue;
					}
					
					
					
				
					
				}
			}
		}
		
		var url = "/hms/hms/opdMaster?method=displayAU&pvmsNo=" + pvmsNo + "&"
				+ csrfTokenName + "=" + csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
}




function addRow() {

	
	
	var tbl = document.getElementById('grid');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdb');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	/* e1.onchange = function() {
		checkPrescriptionCheck(iteration);
	}; */
	cellRight1.appendChild(e1);

	
	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'nomenclature' + iteration;
	e1.id = 'nomenclature' + iteration;
	e1.onblur = function() {
		displayAu(this.value, iteration);
	
		
	};
	e1.size = '35';
	cellRight1.appendChild(e1);
	e1.focus();

	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'ac2updates' + iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	new Ajax.Autocompleter('nomenclature' + iteration,
			'ac2updates' + iteration,
			'opd?method=getItemListForAutoCompleteItem', {
				minChars : 3,
				parameters : 'requiredField=nomenclature' + iteration
			});

	
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'pvmsNo' + iteration;
	e1.id = 'pvmsNo' + iteration;
	cellRight1.appendChild(e1);
	
	
	
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'unit' + iteration;
	e1.id = 'unit' + iteration;
	e1.className = 'textYellow opdTextBoxTSmall';
	e1.readOnly = 'readOnly';
	cellRight1.appendChild(e1);
	

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.name = 'route' + iteration;
	e1.id = 'route' + iteration;
	e1.className = 'textYellow opdTextBoxTSmall';
	e1.readOnly="readonly";
	e1.size="10" ;
	/* e1.style.width = "90px";
	e1.style.background = "#FFFF99";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < routeArray.length; i++) {
		e1.options[i + 1] = new Option(routeArray[i][1], routeArray[i][0]);
	}
	e1.onblur = function() {
		fillRouteOnTAb(iteration);
	}; */
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.name = 'dosage' + iteration;
	e1.id = 'dosage' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	
	cellRight1.appendChild(e1);

	

	var cellRight1 = row.insertCell(5);
	
	
	var e1 = document.createElement('Select');
	e1.name = 'frequency' + iteration;
	e1.id = 'frequency' + iteration;
	e1.style.width = "90px";
	e1.style.background = "#FFFF99";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < icdArray.length; i++) {
		// this part is added by amit das 
		 var opt = document.createElement('option'); 
		 	opt.id = icdArray[i][2];
		 	opt.value = icdArray[i][0];
		    opt.innerHTML = icdArray[i][1];
		    e1.appendChild(opt);
		 //e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]); // this part is commented by amit das
	}
	e1.onchange = function() {
		displaFrequencyType(this,iteration);
	};
	
	cellRight1.appendChild(e1);
	
	
	
	

	
	
	var cellRight1 = row.insertCell(6);
	var e21Div = document.createElement('div');
	e21Div.style = 'width:100px; float: left;';
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'noOfDays' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.id = 'noOfDays' + iteration;
	e1.size = '3';
	/* 	e1.onblur = function() {
		fillValueDays(iteration);
		fillValue(this.value, iteration);
	}; */
	
	e21Div.appendChild(e1);
	var ef21 = document.createElement('p');
	ef21.style = 'line-height:0px;';
	ef21.id = 'frequencyType' + iteration;
	e21Div.appendChild(ef21);
	cellRight1.appendChild(e21Div);
	
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'presMapId' + iteration;
	e1.id = 'presMapId' + iteration;
	cellRight1.appendChild(e1);
	
}


function fillRouteOnTAb(iteration) {
	if(document.getElementById("route" + iteration)!=null){
	var e = document.getElementById("route" + iteration);
	var index = e.selectedIndex;
	var strValue = e.options[e.selectedIndex].value;
	var stText = e.options[e.selectedIndex].text;
	}
	

}




function removeRow() {
	var tbl = document.getElementById('grid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdb');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	if (confirm("Do you want to delete !")) {
		for (var i = 0; i <= iteration; i++) {

			if (document.getElementById("itemRadio" + i) != null
					&& (typeof document.getElementById("itemRadio" + i).checked) != 'undefined'
					&& document.getElementById("itemRadio" + i).checked) {
				totalSelected = totalSelected + 1;
			}
		}

		if (totalSelected == 0) {
			alert('Please select atleast 1 row to delete');
		}
			for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("itemRadio" + i) != null
					&& (typeof document.getElementById("itemRadio" + i).checked) != 'undefined'
					&& document.getElementById("itemRadio" + i).checked) {
				var deleteRow = document.getElementById("itemRadio" + i).parentNode.parentNode;
				document.getElementById("itemRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	
	}
	
}
function displaFrequencyType(i,incr){
	var frequencyType = i.options[i.selectedIndex].id;
	document.getElementById('frequencyType'+incr).innerHTML = frequencyType;
	
}

</script>