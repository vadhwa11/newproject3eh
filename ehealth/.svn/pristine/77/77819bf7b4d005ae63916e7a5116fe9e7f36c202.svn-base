
function addRowTreatment(){
	var tbl = document.getElementById('gridtreatment');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbtreatment');
	iteration = parseInt(hdb.value)+1;
	hdb.value=iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name='itemRadiotreatment'+iteration;
	e1.id='itemRadiotreatment'+iteration;
	e1.className='radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='nomenclaturetreatment'+iteration;
	e1.id='nomenclaturetreatment'+iteration;
	e1.onblur=function(){populatePVMS(this.value,iteration); displayAu(this.value,iteration);checkForAllergy(this.value,iteration);/* checkItem(iteration),*/};
	e1.size='30'
	 e1.onblur=function(){
		populatePVMS(this.value,iteration); 
	     displayAu(this.value,iteration);
	     checkForAllergy(this.value,iteration);
	     checkIPItem(iteration);
	     validatePrescriptionAutocomplete('opmainTM',this.value,iteration );
	}; 

	cellRight1.appendChild(e1);
	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'ac2updatestreatment'+iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	new Ajax.Autocompleter('nomenclaturetreatment'+iteration,'ac2updatestreatment'+iteration,'opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclaturetreatment'+iteration+'&countertreatment='+iteration});

	var cellRight1 = row.insertCell(2);
	
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name='pvmsNotreatment'+iteration;
	e1.id='pvmsNotreatment'+iteration;
	cellRight1.appendChild(e1);
	
	
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='actualDispensingQty'+iteration;
	 e1.id='actualDispensingQty'+iteration;
	 cellRight1.appendChild(e1);
	 
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='mixable'+iteration;
	 e1.id='mixable'+iteration;
	 cellRight1.appendChild(e1);
	 
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='mixtureQuantity'+iteration;
	 e1.id='mixtureQuantity'+iteration;
	 cellRight1.appendChild(e1);
	 
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='actualTotalAfterMix'+iteration;
	 e1.id='actualTotalAfterMix'+iteration;
	 cellRight1.appendChild(e1);
	 
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='mixtureUnit'+iteration;
	 e1.id='mixtureUnit'+iteration;
	 cellRight1.appendChild(e1);
	 
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='tapered'+iteration;
	 e1.id='tapered'+iteration;
	 cellRight1.appendChild(e1);
	  
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='dosagetreatment'+iteration;
	e1.id='dosagetreatment'+iteration;
	e1.size='2';
	e1.onblur=function()
	{
		fillTotalForTreatment(iteration);checkFrequencyForTaperedDrugsDM(iteration);
	};
	/* e1.className='small'; */
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='unittreatment'+iteration;
	e1.id='unittreatment'+iteration;
	e1.size='2';
	e1.readOnly='readOnly';
	cellRight1.appendChild(e1);
	

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name='frequencytreatment'+iteration;
	e1.id='frequencytreatment'+iteration;
	//e1.className='smallest';//changed by govind 24-12-2016
	e1.options[0] = new Option('Select', '0');
	 for(var i = 0;i<frequencyArray.length;i++ ){
		 var opt = document.createElement('option'); 
		 	opt.id = frequencyArray[i][2];
		 	opt.value = frequencyArray[i][0];
		    opt.innerHTML = frequencyArray[i][1];
		    e1.appendChild(opt);
	//e1.options[frequencyArray[i][0]] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
	}
	e1.onchange=function()//changed by govind 24-12-2016
	 //e1.onchange=function()
		{
		getFrequencyValue(this.value,iteration);fillValueFromFrequency(this.value,iteration);displaySOSQty(this.value,iteration);displaFrequencyType(this, iteration);checkFrequencyForTaperedDrugs(iteration);
		}; 
		/* e1.onchange = function() {
			displaFrequencyType(this, iteration);	
		}; */
	cellRight1.appendChild(e1);
	var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='sosQty'+iteration;
	  e21.id='sosQty'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight1.appendChild(e21);
	  
	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='frequencyValue'+iteration;
	  e21.id='frequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight1.appendChild(e21);

	var cellRight1 = row.insertCell(5);
	
	var e21Div = document.createElement('div');
	e21Div.style = 'width:100px; float: left;';
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='noOfDaystreatment'+iteration;
	e1.id='noOfDaystreatment'+iteration;
	e1.size='2';
	/*e1.onblur=function()//changed by govind 24-12-2016
	{
		fillTotalForTreatment(iteration);
	};*/
	e1.onblur=function()
	{
		fillValueFromFrequency(this.value,iteration);
		//fillTotalForTreatment(iteration);
	};
	e1.oninput=function()
	{
		fillValueFromFrequency(this.value,iteration);
		//fillTotalForTreatment(iteration);
	};//changed by govind 24-12-2016 end
	e21Div.appendChild(e1);
	
	var ef21 = document.createElement('p');
	ef21.style = 'line-height:0px;';
	ef21.id = 'frequencyType' + iteration;
	e21Div.appendChild(ef21);
	cellRight1.appendChild(e21Div);
	//cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('Select');
	e1.name='instructiontreatment'+iteration;
	e1.id='instructiontreatment'+iteration;
	e1.className='smallest';
	e1.options[0] = new Option('Select', '0');
	 for(var i = 0;i<instructionArray.length;i++ ){
			e1.options[instructionArray[i][0]] = new Option(instructionArray[i][1],instructionArray[i][0]);
			}
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.size = '15';
	e1.name='spslinstructiontreatment'+iteration;
	e1.id='spslinstructiontreatment'+iteration;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('Select');
	e1.name='routetreatment'+iteration;
	e1.id='routetreatment'+iteration;
	e1.className='smallest';
	e1.options[0] = new Option('Select', '0');
	 for(var i = 0;i<roteArray.length;i++ ){
			e1.options[roteArray[i][0]] = new Option(roteArray[i][1],roteArray[i][0]);
			}
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='totaltreatment'+iteration;
	e1.id='totaltreatment'+iteration;
	e1.size='2';
	e1.onblur=function()
	{
		fillTotalForTreatment(iteration);
	};
	cellRight1.appendChild(e1);


	}
function checkIPItem(cnt) {
	//alert("govind checkIPItem");
	var tbl = document.getElementById('gridtreatment');
	var lastRow = tbl.rows.length;
	var iteration = lastRow - 1;

	// var pvmsNo=document.getElementById("pvmsNo"+iteration).value
	//var visitId = document.getElementById("visitId").value
	var nomenclature = document.getElementById("nomenclaturetreatment" + cnt).value;
	var index1 = nomenclature.lastIndexOf("[");
	var indexForBrandName = index1;
	var index2 = nomenclature.lastIndexOf("]");
	index1++;

	var pvmsNo = nomenclature.substring(index1, index2);
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
							$("#nomenclaturetreatment" + cnt).css({
								'color' : 'red',
							});
						}else{
							$("#nomenclaturetreatment" + cnt).css({
								'color' : 'black',
							});
						}
					}
				});
			}
		}
		var url = "/hms/hms/ipd?method=checkItem&pvmsNo=" + pvmsNo + "&" + csrfTokenName + "="
				+ csrfTokenValue;

		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
}


function fillcheckDoseFrequency() {

	var hdb = document.getElementById("hdbtreatment").value;
	var i;
	var status = true;

	for (i = 0; i <= hdb; i++) {
		if (document.getElementById("nomenclaturetreatment" + i) != null) {
			var itemName = document.getElementById("nomenclaturetreatment" + i).value;
			// alert(itemName);
			if (itemName) {
				var res = itemName.split("(");
				if (res) {
//					var dosage = document.getElementById("dosage" + i).value;
//					if (!dosage) {
//						alert("Enter the Dosage");
					    //status = false;
//						return;
//					}

					var unit = document.getElementById("unittreatment" + i).value;
					if (unit == "") {
						alert("Unit not available")
						status = false;
						return;
					}
//					if (document.getElementById("frequency" + i).selectedIndex == "0") {
//						alert("Select Frequency")
//						status = false;
//						return;
//					}
//
//					var noOfDays = document.getElementById("noOfDays" + i).value;
//
//					if (!noOfDays) {
//						alert("Enter Days")
//						status = false;
//						return;
//					}

				}
			}
		}
	}

	return status;

}


function openPopupForIssue(rowVal)
{
	var appointmentHeaderId=document.getElementById("appointmentHeaderId"+rowVal).value;
	var appDtId=document.getElementById("appDtId"+rowVal).value;
	var injectionName=document.getElementById("injectionName"+rowVal).value;
	var itemId=document.getElementById("itemId"+rowVal).value;
	var frequency=document.getElementById("freq"+rowVal).value;
	var frequencyCount=document.getElementById("frequencyCount"+rowVal).value;
	var noofDays=document.getElementById("noOfDaysInj"+rowVal).value;
	var nTotalProcedure = parseInt(frequencyCount) * parseInt(noofDays);
	var hinId = document.getElementById("hinId").value;
	
	var url="/hms/hms/ipd?method=openPopupForInjectionIssue&appDtId="+appDtId+"&frequency="+frequency+"&frequencyCount="+frequencyCount+"&hinId="+hinId+"&noofDays="+noofDays+"&injectionName="+injectionName+"&nTotalProcedure="+nTotalProcedure+"&itemId="+itemId+"&appointmentHeaderId="+appointmentHeaderId+'&'+csrfTokenName+'='+csrfTokenValue;
	newwindow=window.open(url,'name',"height=500,width=1210,status=1,left=0, top=0, scrollbars=1,resizable=0, channelmode=no");
	
}

//added by govind 14-10-2016

function addSurgicalRequRow() {

	var tbl = document.getElementById('investigationGrid');
	//var hdbTabIndex = parseInt(document.getElementById('usghdbTabIndex').value) + 1;
	//document.getElementById('usghdbTabIndex').value = hdbTabIndex;

	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('procCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	cellRight1.innerHTML=iteration;

	var cellRight1 = row.insertCell(1);
	cellRight1.innerHTML=document.getElementById('admisDate').value;
	
	var cellRight1 = row.insertCell(2);
	cellRight1.innerHTML=document.getElementById('UHID').value;
	
	var cellRight1 = row.insertCell(3);
	cellRight1.innerHTML=document.getElementById('patName').value;
	
	var cellRight1 = row.insertCell(4);
	cellRight1.innerHTML=document.getElementById('IPNo').value;	
	
	var cellRight1 = row.insertCell(5);
	cellRight1.innerHTML=document.getElementById('deptName').value;	
	
	var cellRight1 = row.insertCell(6);
	cellRight1.innerHTML="";
	
	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	var e2 = document.createElement('input');
	e1.type = 'text';
	e2.type = 'hidden';
	e1.name = 'proscedureName' + iteration;
	e1.id = 'proscedureName' + iteration;
	e1.className = "opdTextBoxSmall textYellow";
	
	e1.onkeypress = function(event) {
		selectSNOMEDCT('ACTIVE','PROCEDURE','ALL',returnlimit_IN,callbck_index,'proscedureName'+iteration);
	};
	e1.onblur = function(event) {
		checkMappedChargeIP(this.value,iteration);
	};
	
	e2.name = 'procedureId' + iteration;
	e2.id = 'procedureId' + iteration;
	
	cellRight1.appendChild(e1);
	cellRight1.appendChild(e2);
	
	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Pending', 'Pending');
	e1.options[2] = new Option('Clear', 'Cleared');
	e1.options[3] = new Option('Not Fit', 'Not Fit');
	e1.name = 'pacstatus' + iteration;
	e1.id = 'pacstatus' + iteration;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'surgeryradio' + iteration;
	e1.id = 'surgeryradio' + iteration;
	e1.className = 'smalll';
	
	var e2 = document.createElement('input');
	e2.type = 'hidden';
	e2.name = 'inpatientId' + iteration;
	e2.id = 'inpatientId' + iteration;
	e2.value=document.getElementById('inpatientId').value;
	
	var e3 = document.createElement('input');
	e3.type = 'hidden';
	e3.name = 'hinId' + iteration;
	e3.id = 'hinId' + iteration;
	e3.value=document.getElementById('hinId').value;
	cellRight1.appendChild(e1);
	cellRight1.appendChild(e2);
	cellRight1.appendChild(e3);	
	
}

function removeRow(form) {
	var tbl = document.getElementById(form);
	var lastRow = tbl.rows.length;
	var hdb;
	var radio = "";
	if (form == 'investigationGrid') {
		hdb = document.getElementById('procCount');
		radio = "surgeryradio";
	}
	

	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	if (confirm("Do you want to delete !")) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById(radio + i) != null
					&& (typeof document.getElementById(radio + i).checked) != 'undefined'
					&& document.getElementById(radio + i).checked) {
				totalSelected = totalSelected + 1;
			}
		}

		if (totalSelected == 0) {
			alert('Please select atleast 1 row to delete');
		}
		/*
		 * else if(lastRow==2 || lastRow==(totalSelected+1)) { alert('You can
		 * not delete all Row.'); } else if (lastRow > 2){
		 */
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById(radio + i) != null
					&& (typeof document.getElementById(radio + i).checked) != 'undefined'
					&& document.getElementById(radio + i).checked) {
				var deleteRow = document.getElementById(radio + i).parentNode.parentNode;
				document.getElementById(radio + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}

	}
}
//added by govind 14-10-2016 end


//govind code 7-10-2016 

function callDiagnoseSet(val,texVal){
	if(val!=""){
	select =document.getElementById("diagnosisId");
	 var opt = document.createElement('option');
	    opt.value = val;
	    opt.innerHTML = texVal;
	    select.appendChild(opt);
	    select.selectedIndex = 0;
	}
}

//govind code 7-10-2016 end
function fillValue(inc) {
	//alert(" inc "+inc);
	var dosage;
	var freq;
//	var dispenseQty;
	var noOfDays;
//	var sosQty;
	
		dosage = document.getElementById('dosage' + inc).value;
		freq = document.getElementById('frequencyValue' + inc).value;
		dispenseQty = document.getElementById('actualDispensingQty' + inc).value;
		noOfDays = document.getElementById('noOfDays' + inc).value;
		sosQty = document.getElementById('sosQty' + inc).value;
		if (freq > 0 && dosage > 0 && noOfDays > 0) {
			total = freq * noOfDays * dosage;
		} else {
			total = 0;
		}
		var finalQty = "";
		if (document.getElementById('frequency' + inc).value != 13) {
			if (document.getElementById('actualDispensingQty' + inc).value != 0) {
				var totalQty = (parseFloat(total) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				document.getElementById('total' + inc).value = finalQty;
			} else {
				document.getElementById('total' + inc).value = total;
			}
		} else {
			if (document.getElementById('actualDispensingQty' + inc).value != 0) {
				var totalQty = (parseFloat(freq * sosQty * dosage) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				document.getElementById('total' + inc).value = finalQty;
			} else {
				document.getElementById('total' + inc).value = sosQty * freq
						* dosage;
			}
		}
}

function displaySOSQty(val, inc) {
	if (val == '13') {
		document.getElementById('sosQty' + inc).style.display = 'block';
		document.getElementById('noOfDays' + inc).disabled = true;
	} else {

		document.getElementById('sosQty' + inc).style.display = 'none';
		document.getElementById('noOfDays' + inc).disabled = false;
	}
}

//added by govind 19-10-2016
function getBatchNoList(pvmsNo,itemId,inc) {
	obj = document.getElementById("itemBatchNoId"+inc);
	obj.length = 0;

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

			var chargeCodes = xmlHttp.responseXML.getElementsByTagName('items')[0];

			for (loop = 0; loop < chargeCodes.childNodes.length; loop++) {

				var item = chargeCodes.childNodes[loop];
				var id = item.getElementsByTagName("id")[0];
				var name = item.getElementsByTagName("name")[0];

				obj.length++;
				obj.options[obj.length - 1].value = id.childNodes[0].nodeValue;
				obj.options[obj.length - 1].text = name.childNodes[0].nodeValue;
			}
			document.getElementById("itemBatchNoId"+inc).selectedIndex = "1";
			getItemStockValue1(document.getElementById("itemBatchNoId"+inc).value,inc);
		}
	}

	xmlHttp.open("GET",
			"/hms/hms/stores?method=getBatchNO&pvmsNo="
					+pvmsNo+"&itemId="+itemId, true);

	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

}

//added by amit das on 04-04-2017
function displaFrequencyType(i,incr){
	var frequencyType = i.options[i.selectedIndex].id;
	document.getElementById('frequencyType'+incr).innerHTML = frequencyType;
}


function getItemStockValue(stockId,inc){	
	 new Ajax.Request('/hms/hms/stores?method=getItemStockValue&stockId='+stockId+'&'+csrfTokenName+'='+csrfTokenValue, {
	   	  onSuccess: function(response) {
	   	      if(response.responseText.trim()!='')
	   	    	  {
	   	    	 var unitAndStock=response.responseText.split(","); 
	   	    	document.getElementById('stockQtyId'+inc).value=unitAndStock[0].trim();
				document.getElementById('stockItemBatchStockId'+inc).value=value=unitAndStock[1].trim();
	   	    	  }
	   	  }
	   	});
}
//added by govind 31-05-2017
function fillRoute(iteration,oral) {
	if(document.getElementById("route" + iteration)!=null){
	var e = document.getElementById("route" + iteration);
	var index = e.selectedIndex;
	var strValue = e.options[e.selectedIndex].value;
	var stText = e.options[e.selectedIndex].text;
	if(iteration==1){
		document.getElementById("route"+iteration).selectedIndex = iteration;
	}else{
	document.getElementById("route"+iteration).selectedIndex = oral;
	}
	}
}