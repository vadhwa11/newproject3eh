// Created by Om Tripathi 22/08/2017

function displaFrequencyTypeList(i,incr){
				var frequencyTypeOut = i.options[i.selectedIndex].id;
				document.getElementById('frequencyTypeOut'+incr).innerHTML = frequencyTypeOut;
				
			}
function displaySOSQtyList(val, inc) {
	if (val == '13') { // this value ????
		document.getElementById('sosQtyout' + inc).style.display = 'block';
		document.getElementById('noOfDaysOut' + inc).disabled = true;
		document.getElementById('sosQtypTab' + inc).style.display = 'block';
		document.getElementById('noOfDaysOut' + inc).disabled = true;
	} else {

		document.getElementById('sosQtyout' + inc).style.display = 'none';
		document.getElementById('noOfDaysOut' + inc).disabled = false;
		document.getElementById('sosQtypTab' + inc).style.display = 'none';
		document.getElementById('noOfDaysOut' + inc).disabled = false;
	}
}

function fillValueDay(inc) {
	document.getElementById('noOfDaysOut' + inc).value = document
			.getElementById('noOfDaysOut' + inc).value;
}

function checkFrequencyList(counter, loc) {
	if (counter > 0 && loc == "opc") {
		var obj = document.getElementById("frequencyValueOut" + (counter - 1));
		var unitOut = document.getElementById("unitOut" + (counter - 1)).value;
		if (unitOut == "") {
			alert("Unit not available");
			document.getElementById("nomenclatures" + (counter - 1)).focus();
			return;
		}
		if (obj.selectedIndex == 0) {
			alert("Select Frequency");
			document.getElementById("frequencyValueOut" + (counter - 1)).focus();
			return;
		}

	} else if (counter > 0 && loc == "tab") {
		var obj = document.getElementById("frequencypTab" + (counter - 1));
		var unitOut = document.getElementById("unitOut" + (counter - 1)).value;
		if (unitOut == "") {
			alert("Unit not available");
			document.getElementById("nomenclaturepTab" + (counter - 1)).focus();
			return;
		}
		if (obj.selectedIndex == 0) {
			alert("Select Frequency");
			document.getElementById("frequencypTab" + (counter - 1)).focus();
			return;
		}

	}
}

function copyToPrescriptionTAbList(incr, flag) {

	if (flag == "opconsult") {
		var pTabhdbValue = document.getElementById('pTabhdb').value;
		var hdbValue = document.getElementById('hdb1').value;
		if (document.getElementById("nomenclatures" + incr).value != "") {
			var tbl1 = document.getElementById('gridForPrescription');
			var tbl2 = document.getElementById('prescriptionTabGrid');
			var lastRow1 = tbl1.rows.length;
			var lastRow2 = tbl2.rows.length;

			if (hdbValue > pTabhdbValue) {
				addRowPrescriptionTab();
			}
		}
		if(document.getElementById("nomenclaturepTab" + incr)!=null){
		document.getElementById("nomenclaturepTab" + incr).value = document
				.getElementById("nomenclatures" + incr).value;
	    }
		if(document.getElementById("dosagepTab" + incr)!=null){
		document.getElementById("dosagepTab" + incr).value = document
				.getElementById("dosagesOut" + incr).value;
		}
		if(document.getElementById("unitOut" + incr)!=null){
		document.getElementById("unitOut" + incr).value = document
				.getElementById("unitOut" + incr).value;
		}
		if(document.getElementById("noOfDaysOut" + incr)!=null){
		document.getElementById("noOfDaysOut" + incr).value = document
				.getElementById("noOfDaysOut" + incr).value;
		}
		if(document.getElementById("routesOut" + incr)!=null){
		document.getElementById("routesOut" + incr).value = document
				.getElementById("routesOut" + incr).value;
		}
	}
}

function checkDrugToDiseaseCantraList(obj) {
	jQuery(function($) {
		var index1 = obj.value.lastIndexOf("(");
		var index2 = obj.value.lastIndexOf(")");
		index1++;
		var itemId = obj.value.substring(index1, index2);
		var diagObj = document.getElementById("diagnosisId");
		var strText = "";
		for (var i = 0; i < diagObj.options.length; i++) {
			if (diagObj.options[i].selected == true) {
				var icdCode = diagObj.options[i].value.split("@@@")[0];
				new Ajax.Request(
						'opd?method=checkDrugCantraIndicative&icdCode='
								+ icdCode + "&itemId=" + itemId + '&'
								+ csrfTokenName + '=' + csrfTokenValue, {
							onSuccess : function(response) {
								if (response.responseText.trim() != " ") {
									strText = response.responseText.trim();
									$("#cantraMsgDisease").html(strText);
									$("#cantralabelDisease").show();
								} else {
									$("#cantralabelDisease").hide();
								}
							}
						});
			}
		}
	});
}

function displayAuList(val, inc) {
	if (val != "") {
		var index1 = val.lastIndexOf("[");
		var indexForBrandName = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvmsNo = val.substring(index1, index2);
		var indexForBrandName = indexForBrandName--;
		var brandName = val.substring(0, indexForBrandName);
		if (pvmsNo == "") {
			document.getElementById('nomenclatures' + inc).value = "";
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
					var actualDispensingQtys = item
							.getElementsByTagName("actualDispensingQtys")[0];
					var stock = item.getElementsByTagName("stock")[0];
					
					var mixable = item.getElementsByTagName("mixable")[0];
					var mixtureQuantity = item.getElementsByTagName("mixtureQuantity")[0];
					var mixtureUnit = item.getElementsByTagName("mixtureUnit")[0];
					var tapered = item.getElementsByTagName("tapered")[0];
					
					if (document.getElementById('au' + inc)
							&& au.childNodes[0] != undefined) {
						document.getElementById('au' + inc).value = au.childNodes[0].nodeValue;
					}
					
					if (document.getElementById('actualDispensingQtys' + inc)) {
						if (actualDispensingQtys.childNodes[0] != undefined) {
							document
									.getElementById('actualDispensingQtys' + inc).value = actualDispensingQtys.childNodes[0].nodeValue;
						} else {
							document
									.getElementById('actualDispensingQtys' + inc).value = 0;

						}
					}
					var dangerousDrug = item
							.getElementsByTagName("dangerousDrug")[0];
					if (dangerousDrug.childNodes[0] != undefined
							&& dangerousDrug.childNodes[0].nodeValue == 'y') {
						alert("This drug is dangerous.");
					}
					
					
					if (document.getElementById('mixable' + inc)
							&& mixable.childNodes[0] != undefined) {
						document.getElementById('mixable' + inc).value = mixable.childNodes[0].nodeValue;
					}
					
					if (document.getElementById('mixtureQuantity' + inc)
							&& mixtureQuantity.childNodes[0] != undefined) {
						document.getElementById('mixtureQuantity' + inc).value = mixtureQuantity.childNodes[0].nodeValue;
					}
					
					
					if (document.getElementById('mixtureUnit' + inc)
							&& mixtureUnit.childNodes[0] != undefined) {
						document.getElementById('mixtureUnit' + inc).value = mixtureUnit.childNodes[0].nodeValue;
					}
					
					if (document.getElementById('tapered' + inc)
							&& tapered.childNodes[0] != undefined) {
						document.getElementById('tapered' + inc).value = tapered.childNodes[0].nodeValue;
					}
				}
			}
		}
		var url = "/hms/hms/opd?method=displayAU&pvmsNo=" + pvmsNo + "&"
				+ csrfTokenName + "=" + csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
}

function ValidateCantraList() {
	var ids = "";
	var cantraCounter = 0;

	jQuery(function($) {
		var code2 = "";
		$("select[name='diagnosisId'] > option").each(function() {
			if (code2 == "") {
				code2 = this.value;
			} else {
				code2 = this.value + "," + code2;
			}

		});

		for (; cantraCounter <= $("#hdb1").val(); cantraCounter++) {
			if (document.getElementById("nomenclatures" + cantraCounter) != undefined
					&& $("#nomenclatures" + cantraCounter).val() != "") {
				var nomenclatures = $("#nomenclatures" + cantraCounter).val();
				var index1 = nomenclatures.lastIndexOf("[");
				var index2 = nomenclatures.lastIndexOf("]");
				index1++;
				ids = nomenclatures.substring(index1, index2) + "," + ids;
				var matchIds = nomenclatures.substring(index1, index2)
				var matchPres = nomenclatures.substring(0, (index1 - 1));
				$.post('opd?method=checkDrugCantraIndicative&ids=' + ids
						+ "&code2=" + code2 + "&hinId="
						+ document.getElementById("hinId").value + "&"
						+ csrfTokenName + "=" + csrfTokenValue, function(data) {
					try {
						var dt = "";
						if (data != "") {
							$("#cantralabel").show();
							$("#cantraMsg").html(data);
						} else {
							$("#cantraMsg").html("");
							$("#cantralabel").hide();
						}
					} catch (e) {
						alert(e);
					}
				});
			}
		}
	});
}



function checkItemList(cnt) {
	var tbl = document.getElementById('gridForPrescription');
	var lastRow = tbl.rows.length;
	var iteration = lastRow - 1;

	// var pvmsNo=document.getElementById("pvmsNo"+iteration).value
	var visitId = document.getElementById("visitId").value
	var nomenclatures = document.getElementById("nomenclatures" + cnt).value
	var index1 = nomenclatures.lastIndexOf("[");
	var indexForBrandName = index1;
	var index2 = nomenclatures.lastIndexOf("]");
	index1++;

	var pvmsNo = nomenclatures.substring(index1, index2);
	var prescriptionName = nomenclatures.substring(0, (index1 - 1));
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
							$("#nomenclatures" + cnt).css({
								'color' : 'red',
								'font-size' : '125%'
							});
						
							$("#prescription_availableStatus" + cnt).val('y');
						
						} else {
							$("#nomenclatures" + cnt).css({
								'color' : 'black',
								'font-size' : '125%'
							});
							
						
							$("#prescription_availableStatus" + cnt).val('n');
						}
					}
				});
			}
		}
		var url = "/hms/hms/opd?method=checkItem&pvmsNo=" + pvmsNo
				+ "&visitId=" + visitId + "&" + csrfTokenName + "="
				+ csrfTokenValue;

		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
}

function populatePVMSTabList(val, inc) {
	if (val != "") {
		var index1 = val.lastIndexOf("[");
		var indexForBrandName = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvmsNo = val.substring(index1, index2);
		var indexForBrandName = indexForBrandName--;
		var brandName = val.substring(0, indexForBrandName);

		if (pvmsNo == "") {
			document.getElementById('nomenclaturepTab' + inc).value = "";
			document.getElementById('pvmsNopTab' + inc).value = "";
			document.getElementById('dosagepTab' + inc).value = "";
			document.getElementById('noOfDaysOut' + inc).value = "";
			document.getElementById('unitOut' + inc).value = "";
			return;
		} else {// alert("pvmsNo "+pvmsNo);
			document.getElementById('pvmsNopTab' + inc).value = pvmsNo;
			document.getElementById('dosagepTab' + inc).value = 1;
			document.getElementById('noOfDaysOut' + inc).value = 1;

			new Ajax.Request(
					'ipd?method=updateItemUnit&pvmsNo=' + pvmsNo + '&'
							+ csrfTokenName + '=' + csrfTokenValue,
					{
						onSuccess : function(response) {
							if (response.responseText.trim() != '') {
								var str = response.responseText.trim().split(
										"###");
								/*
								 * document.getElementById('unitOut'+inc).value=response.responseText.trim();
								 * document.getElementById('unitOut'+inc).value=response.responseText.trim();
								 */
								document.getElementById('unitOut' + inc).value = str[0];
								document.getElementById('unitOut' + inc).value = str[0];
								document.getElementById('unitLables' + inc).value = str[1] != undefined ? str[1]
										: "";
								document.getElementById('unitLablepTab' + inc).value = str[1] != undefined ? str[1]
										: "";

							}
						}
					});
		}
	} else {
		document.getElementById('nomenclatures' + inc).value = "";
		document.getElementById('pvmsNopTab' + inc).value = "";
		document.getElementById('dosagesOut' + inc).value = "";
		document.getElementById('noOfDaysOut' + inc).value = "";
		document.getElementById('unitOut' + inc).value = "";
	}
}

function populatePVMSList(val, inc) {
	if (val != "") {
		
		
		
		var indexForBrandName = indexForBrandName--;
		var brandName = val.substring(0, indexForBrandName);

		if (pvmsNo == "") {
			document.getElementById('nomenclatures' + inc).value = "";
			document.getElementById('pvmsNo' + inc).value = "";
			document.getElementById('dosagesOut' + inc).value = "";
			document.getElementById('noOfDaysOut' + inc).value = "";
			document.getElementById('unitOut' + inc).value = "";

			return;
		} else {
			document.getElementById('pvmsNo' + inc).value = pvmsNo;
			document.getElementById('dosagesOut' + inc).value = 1;
			document.getElementById('noOfDaysOut' + inc).value = 1;

			new Ajax.Request(
					'ipd?method=updateItemUnit&pvmsNo=' + pvmsNo + '&'
							+ csrfTokenName + '=' + csrfTokenValue,
					{
						onSuccess : function(response) {
							if (response.responseText.trim() != '') {
								var str = response.responseText.trim().split(
										"###");
								document.getElementById('unitOut' + inc).value = str[0];
								document.getElementById('unitLables' + inc).value = str[1] != undefined ? str[1]
										: "";
								
								document.getElementById('routesOut' + inc).value = str[2]!=undefined?str[2]:"0";
							}
						}
					});
		}
	} else {
		document.getElementById('nomenclatures' + inc).value = "";
		document.getElementById('pvmsNo' + inc).value = "";
		document.getElementById('dosagesOut' + inc).value = "";
		document.getElementById('noOfDaysOut' + inc).value = "";
		document.getElementById('unitOut' + inc).value = "";
	}
}

function checkForAllergyList(val, inc) {
	
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
					icdString = item.getElementsByTagName('allergyString')[0];
					// alert("icdString"+icdString);
					b = icdString.childNodes[0].nodeValue
					// alert("b-->>"+b);

					// var val=document.getElementById('icd').value;
					var index1 = val.lastIndexOf("[");
					var index2 = val.lastIndexOf("]");
					index1++;
					id = val.substring(index1, index2);
					// alert("id------>>>"+id);
					if (id == "") {
						return;
					}

					if (b == 'true') {
						alert("Medicine is allergic to Patient!!");
						document.getElementById('nomenclatures' + inc).value = "";
					}
				}

			}
		}
		var url = "/hms/hms/opd?method=getItemForAllergy&val=" + val
				+ "&visitId=" + visitId + "&" + csrfTokenName + "="
				+ csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
}

function checkPrescriptionCheckList(iteration) {
	if (document.getElementById("itemRadios" + iteration).checked) {
		if(document.getElementById("itemRadiopTab" + iteration)!=null){
		document.getElementById("itemRadiopTab" + iteration).checked = true;
		}
	} else {
		if(document.getElementById("itemRadiopTab" + iteration)!=null){
		document.getElementById("itemRadiopTab" + iteration).checked = false;
		}
	}
}

function checkDrugToDiseaseCantraList(obj) {
	jQuery(function($) {
		var index1 = obj.value.lastIndexOf("(");
		var index2 = obj.value.lastIndexOf(")");
		index1++;
		var itemId = obj.value.substring(index1, index2);
		var diagObj = document.getElementById("diagnosisId");
		var strText = "";
		for (var i = 0; i < diagObj.options.length; i++) {
			if (diagObj.options[i].selected == true) {
				var icdCode = diagObj.options[i].value.split("@@@")[0];
				new Ajax.Request(
						'opd?method=checkDrugCantraIndicative&icdCode='
								+ icdCode + "&itemId=" + itemId + '&'
								+ csrfTokenName + '=' + csrfTokenValue, {
							onSuccess : function(response) {
								if (response.responseText.trim() != " ") {
									strText = response.responseText.trim();
									$("#cantraMsgDisease").html(strText);
									$("#cantralabelDisease").show();
								} else {
									$("#cantralabelDisease").hide();
								}
							}
						});
			}
		}
	});
}

function checkTextColorList(id) {
	jQuery(function($) {
		var text = $("#" + id).val();
		if (text == "") {
			$("#" + id).css({
				'color' : 'black',
				'font-size' : '125%'
			});
		}
	});
}


function checkForAlreadyIssuedPrescribtionList(val, inc) {
//	var value1 = document.getElementsByName('nomenclatures' + inc).value;
	// alert(val+"<<<-------val======inc------>>"+value1);
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
					// alert("icdString"+icdString);
					b = dupl.childNodes[0].nodeValue
					// alert("b-->>"+b);

					// var val=document.getElementById('icd').value;
					/*
					 * var index1 = val.lastIndexOf("["); var index2 =
					 * val.lastIndexOf("]"); index1++; id =
					 * val.substring(index1,index2); //alert("id------>>>"+id);
					 * if(id ==""){ return; }
					 */
					if (b == 'true') {
						alert(" Already Prescibe to Patient!!");
						document.getElementById('nomenclatures' + inc).value = "";
					}
				}

			}
		}
		

		var url = "/hms/hms/opd?method=checkForAlreadyIssuedPrescribtionList&val="
				+ val + "&visitId=" + visitId + "&" + csrfTokenName + "="
				+ csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);

	}
}


function validatePrescriptionAutocompleteList(flag, strValue, inc) {
	if(strValue!="")
		document.getElementById('nomenclatures' + inc).title = strValue;
	/*	var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		var id = strValue.substring(index1, index2);
		var count = document.getElementById('hdb1').value;
		if (id == "") {
			document.getElementById('nomenclatures' + inc).value = "";
			return;
		}
		*/
}


function fillRouteOnTAbList(iteration) {
	if(document.getElementById("routesOut" + iteration)!=null){
	var e = document.getElementById("routesOut" + iteration);
	var index = e.selectedIndex;
	var strValue = e.options[e.selectedIndex].value;
	var stText = e.options[e.selectedIndex].text;
	}
	
	if(document.getElementById("routesOut" + iteration)!=null){
	var eTab = document.getElementById("routesOut" + iteration);
	eTab.selectedIndex = index;
	eTab.options[e.selectedIndex].value = strValue;
	eTab.options[e.selectedIndex].text = stText;
	}
}

function fillValueList(value, inc, from) {
	var dosagesOut;
	var freq;
	var dispenseQty=0;
	var noOfDaysOut;
	var sosQtyout;
	
	var unitOut;
	var mixtuerUnit;
	var mixable;
	var mixtureQuantity;
	
	
	//setDisablePharmacyList();
	
		dosagesOut = document.getElementById('dosagesOut' + inc).value
		noOfDaysOut = document.getElementById('noOfDaysOut' + inc).value
		freq = document.getElementById('frequencyValueOut' + inc).value
		document.getElementById('totalOut' + inc).value = noOfDaysOut * freq	* dosagesOut
		sosQtyout = document.getElementById('sosQtyout' + inc).value;
			
		if (freq > 0 && dosagesOut > 0 && noOfDaysOut > 0) {
			total =  Math.round(freq * noOfDaysOut * dosagesOut);
		} else {
			total = 0;
		}
	
		
		var finalQty = "";
		if (document.getElementById('frequencyValueOut' + inc).value != 13) {
			
				document.getElementById('total' + inc).value = total;
				document.getElementById('totalOut' + inc).value = total;
			
		} else {
			
			
				document.getElementById('totalOut' + inc).value = sosQtyout
						* freq * dosagesOut;
				document.getElementById('totalOut' + inc).value = sosQtyout
				* freq * dosagesOut;
		
		}
		
		document.getElementById('dosagesOut' + inc).value = dosagesOut;
		document.getElementById('noOfDaysOut' + inc).value = noOfDaysOut;
		document.getElementById('frequencyValueOut' + inc).value = freq;
		document.getElementById('sosQtyout' + inc).value = sosQtyout;
		document.getElementById('frequencyValueOut' + inc).value = document
				.getElementById('frequencyValueOut' + inc).value;
	
	
}

function checkFrequencyForTaperedDrugList(inc){
			var count = document.getElementById('hdb1').value;
					
			for (var i = 0; i < count; i++) {
				
				if (document.getElementById('nomenclatures' + i) != null
						&& document.getElementById('nomenclatures' + i).value == document.getElementById('nomenclatures' + inc).value
						&& i != inc) {
						if(document.getElementById('frequencyValueOut' + i).value!='0' &&  document.getElementById('dosagesOut' + i).value!=''){
							
							if(document.getElementById('frequencyValueOut' + i).value==document.getElementById('frequencyValueOut' + inc).value && document.getElementById('dosagesOut' + i).value==document.getElementById('dosagesOut' + inc).value){
								alert('This Prescription is already selected with same dosagesOut and frequencies.');
								document.getElementById('frequencyValueOut' + inc).value = "0";
								return false;
						}
						
					}
				}
			}
			return true;
		}

function addOutsideMedicines(csrfTokenValue) {
		
	var totalRow = document.getElementById('hdb1').value;
	totalRow = totalRow + 1;
	
	var nomenclatures='';
	var nomenclatur=[];
	
	if (!isNaN(totalRow) && totalRow > 0 ) {
		for (var i = 0; i < totalRow; i++) {
			if (document.getElementById('nomenclatures' + i) != null
					&& document.getElementById('nomenclatures' + i).value != '') { 
				nomenclatures=document.getElementById('nomenclatures'+i).value;
				nomenclatur+=nomenclatures+',';
			}else{
			}
		}
	}
	var url = "/hms/hms/pharmacy?method=addOutsideMedicines&csrfTokenName=" 
		+ csrfTokenValue
		+ "&totalRow="+ totalRow
		+ "&nomenclatur="+ nomenclatur;
	alert('url'+url);
	submitForm('opdMain', url);
	
		} 

function addNewRowForPrescription() {
	var tbl = document.getElementById('gridForPrescription');
	var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex1').value) + 1;
	document.getElementById('hdbTabIndex1').value = hdbTabIndex;

	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb1 = document.getElementById('hdb1');
	iteration = parseInt(hdb1.value) + 1;
	hdb1.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadios' + iteration;
	e1.id = 'itemRadios' + iteration;
	e1.className = 'radioCheck';
	e1.onchange = function() {
		checkPrescriptionCheckList(iteration);
	};
	e1.tabIndex = hdbTabIndex + "1";
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'prescription_availableStatus' + iteration;
	e1.id = 'prescription_availableStatus' + iteration;
	e1.className = "textYellow grdTextSmall";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'nomenclatures' + iteration;
	e1.id = 'nomenclatures' + iteration;
	e1.className = "textYellow largTextBoxOpd";
	e1.onfocus = function() {
		checkFrequencyList(iteration, "opc");
	}
	e1.onkeypress = function() {
		checkTextColorList('nomenclatures' + iteration);
	};
	e1.onblur = function() {
		checkForAlreadyIssuedPrescribtionList(this.value, iteration);
		populatePVMSList(this.value, iteration);
		checkItemList(iteration);
		copyToPrescriptionTAbList(iteration, 'opconsult');
		ValidateCantraList();
		//displayAuList(this.value, iteration);
		validatePrescriptionAutocompleteList('opmain', this.value, iteration);
		checkForAllergyList(this.value, iteration);
		
	};
	e1.size = '35';
	e1.tabIndex = hdbTabIndex + "2";
	cellRight1.appendChild(e1);
	e1.focus();

	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'ac2update1' + iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	new Ajax.Autocompleter('nomenclatures' + iteration,
			'ac2update1' + iteration,
			'opd?method=getItemListForAutoCompleteItem', {
				minChars : 3,
				parameters : 'requiredField=nomenclatures' + iteration
			});

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'brandId' + iteration;
	e1.id = 'brandId' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'manufactureId' + iteration;
	e1.id = 'manufactureId' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'pvmsNo' + iteration;
	e1.id = 'pvmsNo' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'actualDispensingQtys' + iteration;
	e1.id = 'actualDispensingQtys' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'mixable' + iteration;
	e1.id = 'mixable' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'mixtureQuantity' + iteration;
	e1.id = 'mixtureQuantity' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'mixtureUnit' + iteration;
	e1.id = 'mixtureUnit' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'actualTotalAfterMix' + iteration;
	e1.id = 'actualTotalAfterMix' + iteration;
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'tapered' + iteration;
	e1.id = 'tapered' + iteration;
	cellRight1.appendChild(e1);
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'routesOut' + iteration;
	e1.id = 'routesOut' + iteration;
	e1.style.width = "90px";
	e1.style.background = "#FFFF99";
	e1.tabIndex = hdbTabIndex + "3";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < routeArray.length; i++) {
		e1.options[i + 1] = new Option(routeArray[i][1], routeArray[i][0]);
	}
	e1.onblur = function() {
		fillRouteOnTAbList(iteration);
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.name = 'dosagesOut' + iteration;
	e1.id = 'dosagesOut' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.onblur = function() {
		fillValueList(this.value, iteration);
	};
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'unitOut' + iteration;
	e1.id = 'unitOut' + iteration;
	e1.className = 'textYellow opdTextBoxTSmall';
	e1.readOnly = 'readOnly';
	e1.tabIndex = hdbTabIndex + "5";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.name = 'frequencyValueOut' + iteration;
	e1.id = 'frequencyValueOut' + iteration;
	e1.style.width = "90px";
	e1.style.background = "#FFFF99";
	e1.tabIndex = hdbTabIndex + "6";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < icdArray.length; i++) {
		
		 var opt = document.createElement('option'); 
		 	opt.id = icdArray[i][2];
		 	opt.value = icdArray[i][0];
		    opt.innerHTML = icdArray[i][1];
		    e1.appendChild(opt);
	}
	e1.onblur = function() {
		getFrequencyValueList(this.value, iteration);
		fillValueList(this.value, iteration);
		displaySOSQtyList(this.value, iteration);	
		
	};
	
	e1.onchange = function() { 
		displaFrequencyTypeList(this, iteration);	
	};
	
	cellRight1.appendChild(e1);
	
	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'sosQtyout' + iteration;
	e21.id = 'sosQtyout' + iteration;
	e21.size = '5';
	e21.setAttribute('tabindex', '1');
	cellRight1.appendChild(e21);

	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'frequencyValueOut' + iteration;
	e21.id = 'frequencyValueOut' + iteration;
	e21.size = '5';
	e21.setAttribute('tabindex', '1');
	cellRight1.appendChild(e21);

	var cellRight1 = row.insertCell(6);
	
	var e21Div = document.createElement('div');
	e21Div.style = 'width:100px; float: left;';
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'noOfDaysOut' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.id = 'noOfDaysOut' + iteration;
	e1.size = '3';
	e1.tabIndex = hdbTabIndex + "7";
	e1.onblur = function() {
		fillValueDay(iteration);
		fillValueList(this.value, iteration);
	};
	e21Div.appendChild(e1);
	
	var ef21 = document.createElement('p');
	ef21.style = 'line-height:0px;';
	ef21.id = 'frequencyTypeOut' + iteration;
	e21Div.appendChild(ef21);
	cellRight1.appendChild(e21Div);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('Select');
	e1.name = 'instrunctionOut' + iteration;
	e1.id = 'instrunctionOut' + iteration;
	e1.style.width = "90px";
	e1.style.background = "#FFFF99";
	e1.tabIndex = hdbTabIndex + "8";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < instructionArray.length; i++) {
		e1.options[i + 1] = new Option(instructionArray[i][1],
				instructionArray[i][0]);
	}
	e1.onblur = function() {
		fillInstrunctionOnTAbs(iteration);
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'splInstrunctionsOut' + iteration;
	e1.id = 'splInstrunctionsOut' + iteration;
	e1.tabIndex = hdbTabIndex + "9";
	e1.className = "textYellow opdTextBoxSmall";
	e1.onblur = function() {
		fillSPLInstrunctionOnPTAb(iteration);
	};
	e1.size = '5';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'total' + iteration;
	e1.id = 'total' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.readOnly = 'readOnly';
	e1.size = '5';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'unitLables' + iteration;
	e1.id = 'unitLables' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.readOnly = 'readOnly';
	e1.size = '5';
	cellRight1.appendChild(e1);
	
}

function removeForPrescriptionRow() {
	var tbl = document.getElementById('gridForPrescription');
	var lastRow = tbl.rows.length;
	var hdb1 = document.getElementById('hdb1');
	var iteration = parseInt(hdb1.value);
	var totalSelected = 0;
	if (confirm("Do you want to delete !")) {
		for (var i = 0; i <= iteration; i++) {

			if (document.getElementById("itemRadios" + i) != null
					&& (typeof document.getElementById("itemRadios" + i).checked) != 'undefined'
					&& document.getElementById("itemRadios" + i).checked) {
				totalSelected = totalSelected + 1;
			}
		}

		if (totalSelected == 0) {
			alert('Please select atleast 1 row to delete');
		}
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("itemRadios" + i) != null
					&& (typeof document.getElementById("itemRadios" + i).checked) != 'undefined'
					&& document.getElementById("itemRadios" + i).checked) {
				var deleteRow = document.getElementById("itemRadios" + i).parentNode.parentNode;
				document.getElementById("itemRadios" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
		removeRowPrescriptionTab('opc');
	}
	setDisablePharmacyList();
}

function setDisablePharmacyList(){
	var count=0;
	if(document.getElementById('hdb1')!=null){
	var tot=document.getElementById('hdb1').value
	
	
	for (var i = 0; i <= tot; i++) {
		//alert("i = "+i);
	    if(document.getElementById('nomenclatures' + i)!=null){
	    	//alert("test 1")
			var freVal = document.getElementById('nomenclatures' + i).value;
			//alert("nomenclature "+freVal);
			if (document.getElementById('nomenclatures' + i).value!="") {
				//alert("not equal");
				count=count+1;
				//document.getElementById("PharmacyqueueId").disabled= true;
			}
	   }
	}
	}
}

function fillInstrunctionOnTAbs(iteration) {
	var e = document.getElementById("instrunctionOut" + iteration);
	var index = e.selectedIndex;
	var strValue = e.options[e.selectedIndex].value;
	var stText = e.options[e.selectedIndex].text;
	
	if(document.getElementById("instrunctionpTab" + iteration)){
	var eTab = document.getElementById("instrunctionpTab" + iteration);
	eTab.selectedIndex = index;
	eTab.options[e.selectedIndex].value = strValue;
	eTab.options[e.selectedIndex].text = stText;
	}
}

