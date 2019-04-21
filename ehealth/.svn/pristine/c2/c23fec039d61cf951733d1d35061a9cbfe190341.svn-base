function calculateStunting(val)
{
	if(val!="" && document.getElementById("expectedHt") && document.getElementById("expectedHt").value!="")
		    document.getElementById("stunting").value = (parseFloat(val)/parseFloat(document.getElementById("expectedHt").value)*100).toFixed(1);
}

function calculateStuntingPaeditrics(height)
{
	var stuntingStatus = "";
	var expectedHeight = document.getElementById("expectedHt").value;
	var actualHeight = height;
	//alert("actualHeight: "+actualHeight);	
	//alert("expectedHeight: "+expectedHeight);	
	
	var diffPercentageHeight = (parseFloat(actualHeight))/(parseFloat(expectedHeight))*100;		
		
		//alert("diffPercentageHeight: "+diffPercentageHeight);
		if(diffPercentageHeight > 95)
		{
			stuntingStatus = "No Stunting";
		}else if(diffPercentageHeight >= 90 && diffPercentageHeight <= 95)
			{
			stuntingStatus = "Grade 1";
			}else if(diffPercentageHeight >= 85 && diffPercentageHeight <= 90)
			{
				stuntingStatus = "Grade 2";
			}else if(diffPercentageHeight < 85)
			{
				stuntingStatus = "Grade 3";
			}
		//alert("stuntingStatus: "+stuntingStatus);
		document.getElementById("stunting").value = stuntingStatus;
}



function calculatePEM(val)
{
	if(val!="" && document.getElementById("expectedWt") && document.getElementById("expectedWt")!="")
		document.getElementById("pem").value = ((parseFloat(val)/parseFloat(document.getElementById("expectedWt").value))*100).toFixed(1);
		
}

function calculatePEMPaeditrics(val)
{
	
	var expectedWeight = document.getElementById("expectedWt").value;
	var pemStatus="";
	//alert("expectedWeight: "+expectedWeight);
	//alert("Actual Wiight: "+val);
	var diffPercentageWeight = (parseFloat(val))/(parseFloat(expectedWeight))*100;	
	//alert("diffPercentageWeight: "+diffPercentageWeight);
	if(diffPercentageWeight > 80)
		{
		pemStatus = "Normal";
		} else if(diffPercentageWeight >=71 && diffPercentageWeight <=80 )
			{
			pemStatus = "Grade 1";
			} else if(diffPercentageWeight >=61 && diffPercentageWeight <=70 )
				{
				pemStatus = "Grade 2";
				}else if(diffPercentageWeight >=51 && diffPercentageWeight <=60 )
				{
					pemStatus = "Grade 3";
				}else if(diffPercentageWeight <=50 )
				{
					pemStatus = "Grade 4";
				}
		//alert("pemStatus: "+pemStatus);
		document.getElementById("pem").value = pemStatus;
}

function openPopupForPatientPrescriptionLP(visitNo, hinId, visitId,opdType, csrf) {

	if (visitNo >= 1) {
		// var nomenclature1=document.getElementById("nomenclature1").value;
		var url = "/hms/hms/opd?method=showPatientPreviousPrescription&visitNo="
				+ visitNo
				+ "&hinId="
				+ hinId
				+ "&visitId="
				+ visitId
				+ "&opdType="+opdType
				+ "&"
				+ csrfTokenName + "=" + csrfTokenValue;
		newwindow = window.open(url, 'opd_window',
				"height=420,width=1050,status=1,scrollbars=yes");
	} else {
		alert("This Is Patient's first Visit.")
	}

}

function openPopupForPatientInvestigationLP(visitNo, hinId,opdType, csrf) {
	if (visitNo > 1) {
		var chargeCodeName1 = document.getElementById("chargeCodeName1").value;
		var url = "/hms/hms/opd?method=showPatientPreviousInvestigation&chargeCodeName1="
				+ chargeCodeName1
				+ "&visitNo="
				+ visitNo
				+ "&hinId="
				+ hinId
				+ "&opdType="+opdType
				+ "&" + csrf + "&" + csrfTokenName + "=" + csrfTokenValue;
		newwindow = window.open(url, 'name',
				"height=300,width=800,status=1,scrollbars=yes");
	} else {
		alert("This is Patient's First Visit. ")
	}
}

function  checkdiagnosis(val,id)
{
	var diagnosisArray=val.split(",");
	var match=false;
	alert(diagnosisArray);
	for(var i=0;i<diagnosisArray.length;i++)
		{
		var options = document.getElementById("snomedList").options;
			 for (var j = 0; j < options.length; j++){
		    if(options[j].value==diagnosisArray[j]){
		    	match = true;
		    	break;
		    }
		  }
		if(!match){
			diagnosisArray[i]="";
		 }
		}
	
	document.getElementById(id).value = diagnosisArray;

}

function fillICDValue(val2, from,diagnosisStatus) {

	var b = false;
	if (val2 != 0) {

		var $ = jQuery.noConflict();
		document.getElementById('icd1').value = val2;
		var tempVal2 = val2;
		tempVal2 = tempVal2.replace(".", "_");
		tempVal2 = tempVal2.replace("*", "idid");
		var tempVal22 = tempVal2.split("@@@");
		if (from == "op") {
			var text = $("#icdName option:selected").text();
			$('#icdNameExm').prop('selectedIndex',
					$("select[name='icdName'] option:selected").index());
		} else if (from == "exm") {
			var text = $("#icdNameExm option:selected").text();
			$('#icdName').prop('selectedIndex',
					$("select[name='icdNameExm'] option:selected").index());
		}

		if (from == "op") {
			document.getElementById('icd1').value = $(
					"#icdName option:selected").text();
		} else if (from == "exm") {
			document.getElementById('icd1').value = $(
					"#icdNameExm option:selected").text();
		}

		tempArray = val2.split("@@@");
		var ICdId = tempArray[0];
		var SnomedId = tempArray[1];
		document.getElementById('icdCode').value = ICdId;

		if (ICdId == "") {
			return;
		} else {
			var obj = document.getElementById('diagnosisId');

			for (var i = 0; i < obj.length; i++) {
				var temp = $("#diagnosisId option").eq(i).val();

				var BothId = new Array();
				BothId = temp.split("-");

				var tempArray = new Array();
				tempArray = BothId[0].split("@@@");
				var tempICdId = tempArray[0];
				var tempSnomedId = tempArray[1];
				/*
				 * alert("ICdId="+ICdId); alert("tempICdId="+tempICdId);
				 */

				/*if (ICdId == tempICdId) {
					alert("ICD  Already taken");
					document.getElementById('icd').value = ""
					document.getElementById('icd2').value = ""
					b = true;
					break
				}*/
			}
		}
		var flag = 2;
		var obj = document.getElementById('diagnosisId');
		for (var x = 0; x < obj.length; x++) {

			var temp = $("#diagnosisId option").eq(x).val();

			var BothId = temp.split("-");
			var tempArray = new Array();
			tempArray = BothId[0].split("@@@");
			var tempICdId = tempArray[0];
			var tempSnomedId = tempArray[1];

			if (SnomedId == tempSnomedId) {
				flag = 1;
				break;
			}
		}

		if (flag != 1) {
			var obj = document.getElementById('diagnosisId');
			var length = obj.length + 1;

			$("#diagnosisId").append(
					"<option value=" + val2 + "-0-"+diagnosisStatus+">" + text + "</option>");
			obj.options[obj.length - 1].selected = true;

			if (document.getElementById('diagnosisId1') != null) {
				obj = document.getElementById('diagnosisId1');
				var tableRow = obj.rows.length;
				var row = obj.insertRow(tableRow);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				cell1.innerHTML = text;
				cell2.innerHTML = "<input type='checkbox' id='" + tempVal22[0]
						+ "' class='radioCheckCol2' value='" + tempVal22[0]
						+ "' onclick='fnCopyToComorbidityTab(\"" + tempVal22[0]
						+ "\")'/>";
				cell3.innerHTML = "<img src='/hms/jsp/images/removeImg.jpg' style='width:16px;height:16px' title='Remove diagnosis' onclick='deleteRow(this);'/>"
			}
			notifiablePregisterCheck(tempVal22[0], text);
		} else {
			alert("Diagnosis already exist");
		}

	}// if close
}



function getICDListBasedOnSnomedId(snomedVal,diagnosis_status) {

	var $ = jQuery.noConflict();
	var val = "";
	if ($("#snomedTermConceptIdEXM").val() != "") {
		val = $("#snomedTermConceptIdEXM").val();
	}
	if ($("#snomedTermConceptId").val() != "") {
		val = $("#snomedTermConceptId").val();
	}
	var temp = val;
	/* $("#icdName").empty();
	$("#divIcdName").hide();

	$("#icdNameExm").empty();
	$("#divIcdNameExm").hide(); */
	console.log("val"+val);
	if (val != "") {
		// console.log("val="+val);
		// var index1 = val.lastIndexOf("[");
		// var index2 = val.lastIndexOf("]");
		// index1++;
		var id = val; // val.substring(index1,index2);

		//var tempStr = $("#snomed").val(); // val.substring(0,index1-1);
		var tempStr =snomedVal;
		var objsnomedList = document.getElementById('snomedList');
		var SnStatus = false;
		for (var i = 0; i < objsnomedList.length; i++) {
			var temp = $("#snomedList option").eq(i).text();
			if (temp == tempStr)
				SnStatus = true;
		}
		if (!SnStatus && tempStr != "") {
			$("#snomedList").append(
					"<option value='" + tempStr + "'>" + tempStr + "</option>");
			objsnomedList.options[objsnomedList.length - 1].selected = true;
		}

		var data = "snomedId=" + id;
		var url = "opd?method=getICDListBasedOnSnomedId&" + csrfTokenName + '='
				+ csrfTokenValue;

		$("#icdName").empty();
		document.getElementById('icdCode').value = "";
		document.getElementById('icd1').value = "";

		jQuery(function($) {

			$
					.ajax({
						type : "POST",
						url : url,
						data : data,
						dataType : "json",
						cache : false,
						success : function(msg) {
							var jsonData = msg;
							var totalMatches = jsonData.length;
							/*
							 * if(totalMatches == 0) { alert("ICD Name does not
							 * exist with this Snomed Name"); return }
							 */
							 console.log("totalMatches= "+totalMatches);
							if (totalMatches == 1) {

								var b = false;
								document.getElementById('icd1').value = jsonData[0].IndName
										+ "["
										+ jsonData[0].IcdCode
										+ "@@@"
										+ jsonData[0].SnomedId + "]";
								document.getElementById('icdCode').value = "["
										+ jsonData[0].IcdCode + "]";

								var val = document.getElementById('icd1').value;
								var index1 = val.lastIndexOf("[");
								var index2 = val.lastIndexOf("]");
								index1++;
								var BothId = val.substring(index1, index2);
								var tempArray = new Array();
								tempArray = BothId.split("@@@");
								var ICdId = tempArray[0];
								var SnomedId = tempArray[1];

								var tempIcdId = ICdId;
								tempIcdId = tempIcdId.replace(".", "_");
								tempIcdId = tempIcdId.replace("*", "idid");
								tempIcdId = tempIcdId.replace("?", "~");
								console.log("id="+id);
								if (id == "") {
									return;
								} else {
									var obj = document
											.getElementById('diagnosisId');
									for (var i = 0; i < obj.length; i++) {
										var temp = $("#diagnosisId option").eq(
												i).val();
										/*
										 * var temp = obj.options[i].value; var
										 * length=obj.length-1;
										 */
										var BothId = new Array();
										BothId = temp.split("-");

										var tempArray = new Array();
										tempArray = BothId[0].split("@@@");
										var tempICdId = tempArray[0];
										var tempSnomedId = tempArray[1];
										/*
										 * alert("ICdId="+ICdId);
										 * alert("tempICdId="+tempICdId);
										 */

										if (ICdId == tempICdId) {
											alert("ICD  Already taken");
											if(document.getElementById('icd')!=null){
											document.getElementById('icd').value = "";
											document.getElementById('icd2').value = "";
											}
											b = true;
											break;
										}
									}
								}
								if (!b) {
									var flag = 2;
									var obj = document
											.getElementById('diagnosisId');

									for (var x = 0; x < obj.length; x++) {

										var temp = $("#diagnosisId option").eq(
												x).val();
										/* alert(temp); */
										var BothId = temp.split("-");
										var tempArray = new Array();
										tempArray = BothId[0].split("@@@");
										var tempICdId = tempArray[0];
										var tempSnomedId = tempArray[1];

										if (SnomedId == tempSnomedId) {
											flag = 1;
											break;
										}
									}

									if (flag != 1) {
										var obj = document
												.getElementById('diagnosisId');
										var length = obj.length + 1;

										$("#diagnosisId").append(
												"<option value="
														+ jsonData[0].IcdCode
														+ "@@@"
														+ jsonData[0].SnomedId
														+ "-0-"+diagnosis_status+">"
														+ jsonData[0].IndName
														+ "["
														+ jsonData[0].IcdCode
														+ "]</option>");

										obj.options[obj.length - 1].selected = true;
										if (document
												.getElementById('diagnosisId1') != null) {
											obj = document
													.getElementById('diagnosisId1');
											var tableRow = obj.rows.length;
											var row = obj.insertRow(tableRow);
											var cell1 = row.insertCell(0);
											var cell2 = row.insertCell(1);
											var cell3 = row.insertCell(2);
											cell1.innerHTML = jsonData[0].IndName
													+ "["
													+ jsonData[0].IcdCode
													+ "]";
											cell2.innerHTML = "<input type='checkbox' id='"
													+ tempIcdId
													+ "' class='radioCheckCol2' value='"
													+ tempIcdId
													+ "' onclick='fnCopyToComorbidityTab(\""
													+ tempIcdId + "\")'/>";
											cell3.innerHTML = "<img src='/hms/jsp/images/removeImg.jpg' style='width:16px;height:16px' title='Remove diagnosis' onclick='deleteRow(this);'/>"
										}
										notifiablePregisterCheck(tempIcdId,
												jsonData[0].IndName + "["
														+ jsonData[0].IcdCode
														+ "]");
									} else {
										alert("Diagnosis already exist");
									}
								}
							}

							if (parseInt(totalMatches) > 1) {

								$("#divIcdName").show();
							/* 	$("#icdName").append(
										"<option value='0'>Select</option>"); */
								for (i = 0; i < jsonData.length; i++) {

									$("#icdName").append(
											"<option value="
													+ jsonData[i].IcdCode
													+ "@@@"
													+ jsonData[i].SnomedId
													+ ">" + jsonData[i].IndName
													+ "[" + jsonData[i].IcdCode
													+ "]</option>");
									console.log($('select#icdName option').eq(0).val());
									fillICDValue($('select#icdName option').eq(0).val(),'op',diagnosis_status);
									break;
								}
							
								$("#divIcdNameExm").show();
								$("#icdNameExm").append(
										"<option value='0'>Select</option>");
								for (i = 0; i < jsonData.length; i++) {

									$("#icdNameExm").append(
											"<option value="
													+ jsonData[i].IcdCode
													+ "@@@"
													+ jsonData[i].SnomedId
													+ ">" + jsonData[i].IndName
													+ "[" + jsonData[i].IcdCode
													+ "]</option>");

								}

							}

						},
						error : function(msg) {

							// alert("An error has occurred while contacting the
							// server");

						}

					});
		});

	}// close else
	//$("#snomed").val("");
	/* $("#icd2").val("");
	$("#snomedTermConceptId").val("");
	$("#snomedTermConceptIdEXM").val(""); */

}

function openPopupForSaveInvestigationLP() {
	var totalRow = document.getElementById('hiddenValue').value;
	var htmlText = "";
	var count = 0;
	if (!isNaN(totalRow) && totalRow > 0) {
		htmlText += '<form method="post" action="/hms/hms/opd?method=submitInvestigationTamplate">'
				+ '<input type="hidden" name="'
				+ csrfTokenName
				+ '"value="'
				+ csrfTokenValue
				+ '"/>'
				+ '<br/><br/><label>Template Name<span style="color:red;">* </span> </label><input type="text" name="tamplatename" maxlength="30" /><div style="clear:boath;"><div><br/><br/>';
		htmlText += '<table width="100%" border="2" align="center" cellpadding="2" cellspacing="2" style="float:left;" >';
		for (var i = 0; i <= totalRow; i++) {
			if (document.getElementById('chargeCodeName' + i) != null
					&& document.getElementById('chargeCodeName' + i).value != '') {

				if (count == 0) {
					htmlText += '' + '<tr>' + '<th scope="col">Test Name</th>'
							+ '</tr>';
				}
				count++;
				htmlText += '' + '<tr>' + '<td>'
				// +'<input type="hidden" name="chargeCode'+count+'"
				// value="'+document.getElementById('chargeCode'+i).value+'" />'
				+ '<input type="hidden" name="chargeCodeName' + count
						+ '" value="'
						+ document.getElementById('chargeCodeName' + i).value
						+ '" />' + ''
						+ document.getElementById('chargeCodeName' + i).value
				htmlText += '</td>'

				+ '</tr>';

			}

		}
		htmlText += '</table>'
				+ '<div style="clear:both;"><div><br/><br/><input type="hidden" id="total" name="total" value="'
				+ count
				+ '" /><br/><br/><div>'
				+ '<div><input type="submit" id="submit" value="Save"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'
				+ '<input type="button" id="close" value="Close"  onclick="window.close()" />'
				+ '</div></div></div></form>';
	}
	// alert(htmlText);
	if (count == 0) {
		alert('Please enter some data to save Template');
	} else {
		var myWindow = window.open("", "saveprescriptionWindow",
				"width=500, height=500");
		myWindow.document
				.write('<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />');
		myWindow.document.write(htmlText);
	}

}

function deferredDiagnosisChk(obj)
{
	if(obj.checked)
		{
		document.getElementById('snomed').value ="";
		document.getElementById('snomed').readOnly = true;
		document.getElementById('finalDiagnosis').value ="";
		document.getElementById('finalDiagnosis').readOnly = true;
		document.getElementById('differentialDiagnosis').value ="";
		document.getElementById('differentialDiagnosis').readOnly = true;
		$("#diagnosisId option").remove();
		$("#snomedList option").remove();
		}
	else
		{
		document.getElementById('snomed').readOnly = false;
		document.getElementById('finalDiagnosis').readOnly = false;
		document.getElementById('differentialDiagnosis').readOnly = false;
		}
}


function openPopupForSavePrescriptiontamplate() {
	 //alert("govind test openPopupForSavePrescriptiontamplate");
	var totalRow = document.getElementById('pTabhdb').value;
	// alert("govind test totalRow "+totalRow);
	// add one for total number or row for adding local templete by rajat singh
	totalRow = parseInt(totalRow) + 1;
	var htmlText = "";
	var count = 0;
	var tempLatePrescription = document.getElementById('tempLatePrescription').value;

	var sel = document.getElementById("tempLatePrescription");
	if (sel.options[sel.selectedIndex] != undefined) {
		var tempName = sel.options[sel.selectedIndex].text;
	}
	// alert("govind tempLatePrescription value "+tempLatePrescription);
	// alert("govind selectedText "+tempName);
	//alert(document.getElementById('tempLatePrescription').value);
	if (!isNaN(totalRow) && totalRow > 0 && tempLatePrescription == 0) {
		// alert("govind tempLatePrescription==0 ");
		htmlText += '<script type="text/javascript" src="/hms/jsp/js/common.js"></script>';
		
		htmlText += '<form method="post" action="" name="presTemplate">'
				+ '<input type="hidden" name="'
				+ csrfTokenName
				+ '"value="'
				+ csrfTokenValue
				+ '"/>'
				+ '<br/><br/><label>Template Name<span style="color:red;">* </span> </label><input type="text" name="tamplatename" maxlength="30" validate="Template Name,string,yes"/><div style="clear:boath;"><div><br/><br/>';
		htmlText += '<table border="2" align="center" cellpadding="2" cellspacing="2" style="float:left;" >';
		for (var i = 0; i < totalRow; i++) {

			if (document.getElementById('nomenclature' + i) != null
					&& document.getElementById('nomenclature' + i).value != ''
					&& document.getElementById('pvmsNo' + i).value != ''
					&& document.getElementById('pvmsNo' + i).value != '0') {

				if (count == 0) {
					htmlText += '' + '<tr>' + '<th scope="col">Item Name</th>'
							+ '<th scope="col">Route</th>'
							+ '<th scope="col">Dosage</th>'
							+ '<th scope="col">Frequency</th>'
							+ '<th scope="col">Days</th>'
							+ '<th scope="col">Instruction </th>'
							+ '<th scope="col">Special Instruction </th>'
							+ '<th scope="col">Total</th>' + '</tr>';
				}
				count++;
				htmlText += '' + '<tr>' + '<td>'
						+ '<input type="hidden" name="pvms' + count
						+ '" value="'
						+ document.getElementById('pvmsNo' + i).value + '" />'
						+ '<input type="hidden" name="nomenclature' + count
						+ '" value="'
						+ document.getElementById('nomenclature' + i).value
						+ '" />' + ''
						+ document.getElementById('nomenclature' + i).value;
				+'</td>'

				htmlText += '<td>' + '<input type="hidden" name="route' + count
						+ '" value="'
						+ document.getElementById('route' + i).value + '" />';
				if (document.getElementById('route' + i).value != 0) {
					// htmlText +='<input type="hidden"
					// name="routename'+count+'"
					// value="'+document.getElementById('route'+i).options[document.getElementById('route'+i).selectedIndex].text+'"
					// />';
					htmlText += '<input type="hidden" name="routename'
							+ count
							+ '" value="'
							+ document.getElementById('route' + i).options[document
									.getElementById('route' + i).selectedIndex].text
							+ '" />';

					// htmlText
					// +=''+document.getElementById('route'+i).options[document.getElementById('route'+i).selectedIndex].text;
					htmlText += ''
							+ document.getElementById('route' + i).options[document
									.getElementById('route' + i).selectedIndex].text;
				}

				htmlText += '</td>'

				+ '<td>' + '<input type="hidden" name="dosage' + count
						+ '" value="'
						+ document.getElementById('dosage' + i).value + '" />'
						+ '' + document.getElementById('dosage' + i).value

						+ '</td>' + '<td>'

						+ '<input type="hidden" name="frequency' + count
						+ '" value="'
						+ document.getElementById('frequency' + i).value
						+ '" />';
				if (document.getElementById('frequency' + i).value != 0) {
					htmlText += '<input type="hidden" name="frequencyname'
							+ count
							+ '" value="'
							+ document.getElementById('frequency' + i).options[document
									.getElementById('frequency' + i).selectedIndex].text
							+ '" />';
					htmlText += ''
							+ document.getElementById('frequency' + i).options[document
									.getElementById('frequency' + i).selectedIndex].text;
				}
				htmlText += '</td>' + '<td>'
						+ '<input type="hidden" name="noOfDays' + count
						+ '" value="'
						+ document.getElementById('noOfDays' + i).value
						+ '" />' + ''
						+ document.getElementById('noOfDays' + i).value
						+ '</td>' + '<td>'
						+ '<input type="hidden" name="instrunction' + count
						+ '" value="'
						+ document.getElementById('instrunction' + i).value
						+ '" />';
				if (document.getElementById('instrunction' + i).value != 0) {
					htmlText += '<input type="hidden" name="instrunctionname'
							+ count
							+ '" value="'
							+ document.getElementById('instrunction' + i).options[document
									.getElementById('instrunction' + i).selectedIndex].text
							+ '" />';

					htmlText += ''
							+ document.getElementById('instrunction' + i).options[document
									.getElementById('instrunction' + i).selectedIndex].text;
				}
				htmlText += '</td>' + '<td>'
if( document.getElementById('splInstrunction' + i)!=null){
				htmlText += '<input type="hidden" id="splInstructions' + count
						+ '"name="splInstructions' + count + '"value="'
						+ document.getElementById('splInstrunction' + i).value
						+ '" />' + ''
						+ document.getElementById('splInstrunction' + i).value;
				htmlText += '</td>' + '<td>'
}
else
	htmlText += '</td>' + '<td>'
				htmlText += '<input type="hidden" id="total' + count
						+ '" name="total' + count + '" value="'
						+ document.getElementById('total' + i).value + '" />'
						+ '' + document.getElementById('total' + i).value
						+ '</td>';

				+'</tr>';
			}
		}
		var formName = 'presTemplate';
		var url = '/hms/hms/opd?method=submitPrescriptionTamplate';
		htmlText += '</table>'
				+ '<div style="clear:boath;"><div><br/><br/>'+'<input type=\'hidden\' value=\''+(totalRow-1)+'\' id=\'total\' name=\'total\' >'+'<input type="hidden" id="hdb" name="hdb" value="'
				+ count
				+ '" /><br/><br/><div><input type="button" id="save" value="Save" onclick="submitForm(\''+formName+'\',\''+url+'\')" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="close" value="Close" onclick="window.close()" /></div>';
		+'</form>';
	}
	var updateVar = 0;
	// added by govind 15-9-2016
	if (!isNaN(totalRow) && totalRow > 0 && tempLatePrescription > 0) {
		updateVar++;
		// alert("govind tempLatePrescription>0 ");
		htmlText += '<script type="text/javascript" src="/hms/jsp/js/common.js"></script>';
		htmlText += '<form method="post" action="" name="presTemplate">'
				+ '<input type="hidden" name="'
				+ csrfTokenName
				+ '"value="'
				+ csrfTokenValue
				+ '"/>'
				+ '<br/><br/><label>Tamplate Name<span style="color:red;">* </span> </label><input type="text" name="tamplatename" maxlength="30" value="'
				+ tempName
				+ '"/>'
				+ '<br><input type="hidden" name="tamplateId" maxlength="30" value="'
				+ tempLatePrescription
				+ '"/><div style="clear:boath;"><div><br/><br/>';
		htmlText += '<table border="2" align="center" cellpadding="2" cellspacing="2" style="float:left;" >';
		for (var i = 0; i < totalRow; i++) {

			if (document.getElementById('nomenclature' + i) != null
					&& document.getElementById('nomenclature' + i).value != ''
					&& document.getElementById('pvmsNo' + i).value != ''
					&& document.getElementById('pvmsNo' + i).value != '0') {

				if (count == 0) {
					htmlText += '' + '<tr>' + '<th scope="col">Item Name</th>'
							+ '<th scope="col">Route</th>'
							+ '<th scope="col">Dosage</th>'
							+ '<th scope="col">Frequency</th>'
							+ '<th scope="col">Days</th>'
							+ '<th scope="col">Instruction </th>'
							+ '<th scope="col">Special Instruction</th>'
							+ '<th scope="col">Total</th>' + '</tr>';
				}
				count++;

				htmlText += '' + '<tr>' + '<td>'
						+ '<input type="hidden" name="pvms' + count
						+ '" value="'
						+ document.getElementById('pvmsNo' + i).value + '" />'
						+ '<input type="hidden" name="nomenclature' + count
						+ '" value="'
						+ document.getElementById('nomenclature' + i).value
						+ '" />' + ''
						+ document.getElementById('nomenclature' + i).value;
				+'</td>'

				htmlText += '<td>' + '<input type="hidden" name="route' + count
						+ '" value="'
						+ document.getElementById('route' + i).value + '" />';
				if (document.getElementById('treatTemplteId' + i) != null) {
					htmlText += '<input type="hidden" name="treatTemplteId'
							+ count
							+ '" value="'
							+ document.getElementById('treatTemplteId' + i).value
							+ '" />';
				}
				if (document.getElementById('route' + i).value != 0) {
					// htmlText +='<input type="hidden"
					// name="routename'+count+'"
					// value="'+document.getElementById('route'+i).options[document.getElementById('route'+i).selectedIndex].text+'"
					// />';
					htmlText += '<input type="hidden" name="routename'
							+ count
							+ '" value="'
							+ document.getElementById('route' + i).options[document
									.getElementById('route' + i).selectedIndex].text
							+ '" />';

					// htmlText
					// +=''+document.getElementById('route'+i).options[document.getElementById('route'+i).selectedIndex].text;
					htmlText += ''
							+ document.getElementById('route' + i).options[document
									.getElementById('route' + i).selectedIndex].text;
				}

				htmlText += '</td>'

				+ '<td>' + '<input type="hidden" name="dosage' + count
						+ '" value="'
						+ document.getElementById('dosage' + i).value + '" />'
						+ '' + document.getElementById('dosage' + i).value

						+ '</td>' + '<td>'

						+ '<input type="hidden" name="frequency' + count
						+ '" value="'
						+ document.getElementById('frequency' + i).value
						+ '" />';
				if (document.getElementById('frequency' + i).value != 0) {
					htmlText += '<input type="hidden" name="frequencyname'
							+ count
							+ '" value="'
							+ document.getElementById('frequency' + i).options[document
									.getElementById('frequency' + i).selectedIndex].text
							+ '" />';
					htmlText += ''
							+ document.getElementById('frequency' + i).options[document
									.getElementById('frequency' + i).selectedIndex].text;
				}
				htmlText += '</td>' + '<td>'
						+ '<input type="hidden" name="noOfDays' + count
						+ '" value="'
						+ document.getElementById('noOfDays' + i).value
						+ '" />' + ''
						+ document.getElementById('noOfDays' + i).value
						+ '</td>' + '<td>'
						+ '<input type="hidden" name="instrunction' + count
						+ '" value="'
						+ document.getElementById('instrunction' + i).value
						+ '" />';
				if (document.getElementById('instrunction' + i).value != 0) {
					htmlText += '<input type="hidden" name="instrunctionname'
							+ count
							+ '" value="'
							+ document.getElementById('instrunction' + i).options[document
									.getElementById('instrunction' + i).selectedIndex].text
							+ '" />';

					htmlText += ''
							+ document.getElementById('instrunction' + i).options[document
									.getElementById('instrunction' + i).selectedIndex].text;
				}
				htmlText += '</td>' + '<td>'
			if(document.getElementById('splInstrunction' + i)!=null){
				htmlText += '<input type="hidden" id="splInstructions' + count
						+ '"name="splInstructions' + count + '"value="'
						+ document.getElementById('splInstrunction' + i).value
						+ '" />' + ''
						+ document.getElementById('splInstrunction' + i).value;
				htmlText += '</td>' + '<td>'
			}
				else
					htmlText += '</td>' + '<td>'
					
				htmlText += '<input type="hidden" id="total' + count
						+ '" name="total' + count + '" value="'
						+ document.getElementById('total' + i).value + '" />'
						+ '' + document.getElementById('total' + i).value
						+ '</td>';

				+'</tr>';
			}
		}
		var formName = 'presTemplate';
		var url = '/hms/hms/opd?method=updatePrescriptionTamplate';
		htmlText += '</table>'
				+ '<div style="clear:boath;"><div><br/><br/><input type="hidden" id="hdb" name="hdb" value="'
				+ count
				+ '" /><br/><br/><div><input type="button" id="update"  onclick="submitForm(\''+formName+'\',\''+url+'\')" value="Update"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="close" value="Close" onclick="window.close()" /></div>';
		+'</form>';
	}
	// alert(htmlText);
	if (count == 0) {
		alert('Please enter some data to save Tamplate');
	} else {
		var myWindow = window.open("", "saveprescriptionWindow",
				"width=900, height=500");
		myWindow.document
				.write('<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />');
		myWindow.document.write(htmlText);
	}

}


function toggleOtherTextbox1(obj, textBoxName, textLength, spanId,textWidth,textBoxId) {
	
	var span = document.getElementById(spanId);
	if (obj.options[obj.selectedIndex].text == 'Others' || obj.options[obj.selectedIndex].text == 'y') {
		var other = document.createElement("input");
		other.type = "text";
		other.name = textBoxName;
		if(textBoxId!=undefined)
		other.id = textBoxId;
		else
			other.id = textBoxName;
		other.className='textYellow';
		other.setAttribute('maxlength', textLength);
		if(textWidth!=undefined)
		other.style.width=textWidth;
		span.appendChild(other);
	} else
		span.innerHTML = "";

}



function checkForBlockedMedicine(val, inc) {
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
				
				var responseJson = JSON.parse(this.responseText);
				
				if(responseJson.matched==true){
					var message="";
					if(responseJson.blockedDays!=null && responseJson.blockedDays!="" && responseJson.blockedDays!=0){
						message="This Medicine is Blocked By "+responseJson.blockedDoctor+" For "+responseJson.blockedDays+" Days. Do You Want to UnBlock It?";
					}else{
						message="This Medicine is Blocked By "+responseJson.blockedDoctor+" Do You Want to UnBlock It?";
					}
					document.getElementById("blockMedicineMsg").innerHTML=message;
					
					document.getElementById("blockMedicineMsg").value=responseJson.allergyTid;
					document.getElementById("incrementNum").value=inc;
					 
					var modal = document.getElementById('myModal');
					modal.style.display = "block";	
				}
				
			}
		}
		var url = "/hms/hms/opd?method=checkForBlockedMedicine&val=" + val
				+ "&visitId=" + visitId + "&" + csrfTokenName + "="
				+ csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
}

function closePopUp(){
	var incr=document.getElementById("incrementNum").value;
	var val=document.getElementById("nomenclature"+incr).value;
	document.getElementById("nomenclature"+incr).value="";
	var modal = document.getElementById('myModal');
	modal.style.display = "none";
}

function unBlockMedicine(){
	var medicineTableId=document.getElementById("blockMedicineMsg").value;
	if (medicineTableId != "") {

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
				var modal = document.getElementById('myModal');
				modal.style.display = "none";

			}
		}
		var url = "/hms/hms/opd?method=unBlockMedicine&medicineTableId=" + medicineTableId;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
	
}

function pacRequesting(increment){
	if(document.getElementById("chkpacNeed"+increment).checked){
		document.getElementById("chkpacNeed"+increment).value="y";
	}else{
		document.getElementById("chkpacNeed"+increment).value="n";
	}
	
}

function getPacStatus(surgeryId,lastVisit,otPreAnesthesiaDtlId){
	var url='/hms/hms/ot?method=showOpPacHistory&'+csrfTokenName+'='+csrfTokenValue+'&opdSurgeryId='+surgeryId+'&lastVisit='+lastVisit+'&otPreAnesthesiaDtlId='+otPreAnesthesiaDtlId;
    newwindow=window.open(url,'opd_window',"left=100,top=100,height=600,width=1100,status=1,scrollbars=yes,resizable=0");
}
function checkReferDate(referDate) {
	if(referDate !=""){
	var refDate = new Date(referDate.substring(6),(referDate.substring(3,5) - 1) ,referDate.substring(0,2))
	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);
	if(refDate<currentDate){
		
		alert("Refer Date is greater than equal to Current Date");
		document.getElementById('referVisitDate').value=""
		return false;
	}
		
	}
	return true;
}

function checkPrescriptionCheck(iteration) {
	if (document.getElementById("itemRadioCheck" + iteration).checked) {
		if (document.getElementById("itemRadiopTab" + iteration) != null) {
			document.getElementById("itemRadiopTab" + iteration).checked = true;
		}
	} else {
		if (document.getElementById("itemRadiopTab" + iteration) != null) {
			document.getElementById("itemRadiopTab" + iteration).checked = false;
		}
	}
}
