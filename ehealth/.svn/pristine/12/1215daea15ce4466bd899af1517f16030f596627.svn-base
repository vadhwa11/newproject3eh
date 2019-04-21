/**
 * contains all method of opd and ipd page
 */
function loadResultsList(state, semantictag, acceptability, returnlimit, call,
		from, iteration) {
	jQuery(function($) {
		if (document.getElementById("conceptdiv"))
			$("#conceptdiv").remove();

		if (displaySearch == false) {
			if (document.getElementById("conceptdiv"))
				$("#conceptdiv").remove();
			displaySearch = true;
		}
		if (displaySearch == true) {

			var dataValue = document.getElementById(from).value;

			if (dataValue.trim() == '') {
				if (document.getElementById("conceptdiv"))
					$("#conceptdiv").remove();
				var txtBox = document.getElementById(from);
				txtBox.focus();
				return;
			}
			var servURL = '';

			servURL = enumSERVICES.SEARCH.searchbyacceptability_url;

			servURL += "?term=" + encodeURIComponent(dataValue) + "&state="
					+ state + "&semantictag=" + semantictag + "&acceptability="
					+ acceptability + "&returnlimit=" + returnlimit
					+ "&csrfTokenName" + '=' + csrfTokenValue;

			$
					.ajax({
						type : "GET",
						url : servURL,
						dataType : "jsonp",
						crossDomain : true,
						success : function(data, textStatus, jqXHR) {

							var htmlData = '';
							jsonData = data;
							$('#reccount').text(data.length);
							if (data.length == 0) {

								if (document.getElementById("conceptdiv"))
									$("#conceptdiv").remove();
								var txtBox = document.getElementById(from);
								txtBox.focus();
								return;
							}

							displaySearch = false;

							htmlData = '';
							htmlData += '<div class="concept" id="conceptdiv">';

							htmlData += '<table class="bordered">';
							htmlData += '<thead><tr><th>Description&nbsp;&nbsp;</th></tr></thead>';
							currentCountDisplayed = data.length;

							for (var i = 0; i < data.length; ++i) {
								var val = '\'' + data[i].conceptId + '###$$$'
										+ data[i].term + '###$$$' + data[i].id
										+ '\'';

								/*
								 * htmlData += '<tr title="' +
								 * data[i].conceptFsn + '"
								 * onclick="selectValue(\'' + escape(val) +
								 * '\',' + call + ');"><td>' + data[i].term + '</td></tr>';
								 */

								var data = unescape(escape(val));
								var term = data.split('###$$$');
								var returnconceptid_OUT = term[0].replace("'",
										"");
								if (returnconceptid_OUT == "undefined") {
									break;
								}
								if (typeof call === "function") {
									call(returnconceptid_OUT, iteration);
								}

							}

							htmlData += '</table>';
							htmlData += '</div>';
							if (document.getElementById("conceptdiv"))
								$("#conceptdiv").remove();

						},
						error : function(jqXHR, textStatus, errorThrown) {
							console.log(textStatus);
						}
					});
		}
	});
}

/*
 * function selectValue(value, callback) { var data = unescape(value); var term =
 * data.split('###$$$'); var returnterm_OUT = "Description: " + term[1] + "\r\n" +
 * "Concept Id: " + term[0].replace("'", "") + "\r\n" + "Description id: " +
 * term[2].replace("'", "");
 * 
 * var returnconceptid_OUT =term[0].replace("'", "");
 * alert(returnconceptid_OUT); if (typeof callback === "function"){
 * callback(returnconceptid_OUT); } }
 */

function selectSNOMEDCT(state_IN, semantictag_IN, acceptability_IN,
		returnlimit_IN, callback, from, iteration) {
	jQuery(function($) {
		if (returnlimit_IN <= -1 || returnlimit_IN == ''
				|| returnlimit_IN == undefined || returnlimit_IN == null) {
			returnlimit_IN = -1;

		}
		returnlimitParam = returnlimit_IN;

		if (state_IN == -1 || state_IN == null || state_IN == ''
				|| state_IN == undefined) {
			state_IN = enumSTATE.BOTH;
		} else

			state_IN = enumSTATE[state_IN];

		stateParam = state_IN;

		if (semantictag_IN == -1 || semantictag_IN == null
				|| semantictag_IN == undefined || semantictag_IN == '') {
			semantictag_IN = enumSEMANTICTAG.ALL;
		} else
			semantictag_IN = enumSEMANTICTAG[semantictag_IN];

		semantictagParam = semantictag_IN;

		if (acceptability_IN == -1 || acceptability_IN == null
				|| acceptability_IN == undefined || acceptability_IN == '') {
			acceptability_IN = enumACCEPTABILITY.ALL;
		} else
			acceptability_IN = enumACCEPTABILITY[acceptability_IN];

		acceptabilityParam = acceptability_IN;

		jQuery('.ui-dialog button:nth-child(0)').button('disable');
		$('.ui-dialog-buttonpane').find("button").show().filter(
				":contains('.')").hide();

		var txtBox = document.getElementById(from);
		txtBox.focus();

		var xhrRequest = null;
		$("#" + from)
				.autocomplete(
						{
							max : 20,
							minLength : 3,
							cacheLength : 1,
							scroll : false,
							width : 520,
							highlight : false,
							autoFocus : false,
							source : function(request, response) {

								var dataValue = document.getElementById(from).value;

								var servURL = "";
								if (dataValue == '') {
									$("#dialog-form").dialog("option",
											"height", 160);
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									var txtBox = document.getElementById(from);
									txtBox.focus();
									return;
								}

								if (dataValue.length >= 3) {
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									$("#msg3chars").hide();
									$('#nosuggestion').hide();

								} else {
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
								}

								servURL = enumSERVICES.SEARCH.suggestbyacceptability_url;
								var refsetidParam =null ;
								if(document.getElementById('refsetId'))
									refsetidParam = document.getElementById('refsetId').value;
								servURL += "?term="
										+ encodeURIComponent(request.term)
										+ "&state=" + stateParam
										+ "&semantictag=" + semantictagParam
										+ "&acceptability="
										+ acceptabilityParam
										+ "&returnlimit=10&refsetid="+refsetidParam;
								console.log(servURL);

								if (xhrRequest && xhrRequest.readystate != 4)
									xhrRequest.abort();
								xhrRequest = $
										.ajax({
											type : "GET",
											url : servURL,
											dataType : "jsonp",
											crossDomain : true,
											success : function(data,
													textStatus, jqXHR) {
												console.log(data);
												var items = data;

												response(items);
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
												console.log(textStatus);

											}
										});

							},
							select : function(event, ui) {
								var data = document.getElementById(from).value;
								if (data.length >= 3) {
									$("#msg3chars").hide();
									$('#nosuggestion').hide();
									document.getElementById(from).value = ui.item.value;
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									displaySearch = false;
									loadResultsList(stateParam,
											semantictagParam,
											acceptabilityParam,
											returnlimitParam, callback, from,
											iteration);
								} else {
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
								}
							}

						});
	});
}
// integrating snomed with mas_charge_code :2016/08/12
function copyResultsList(state, semantictag, acceptability, returnlimit, call,
		callConceptId) {
	jQuery(function($) {
		$('#reccnt').show();
		$('#reccount').show();
		$('#norec').hide();
		$('#msg3chars').hide();
		$('#nosuggestion').hide();

		if (document.getElementById("conceptdiv"))
			$("#conceptdiv").remove();

		if (displaySearch == false) {

			if (document.getElementById("conceptdiv"))
				$("#conceptdiv").remove();
			displaySearch = true;
		}

		if (displaySearch == true) {

			var dataValue = document.getElementById("txt-snomed-ct-search").value;

			if (dataValue.trim() == '') {
				$("#dialog-form").dialog("option", "height", 160);
				if (document.getElementById("conceptdiv"))
					$("#conceptdiv").remove();
				$('#reccnt').hide();
				$('#reccount').hide();
				$('#norec').show();
				$('#msg3chars').hide();
				$('#nosuggestion').hide();
				var txtBox = document.getElementById("txt-snomed-ct-search");
				txtBox.focus();
				return;
			}

			var servURL = '';

			servURL = enumSERVICES.SEARCH.searchbyacceptability_url;

			servURL += "?term=" + encodeURIComponent(dataValue) + "&state="
					+ state + "&semantictag=" + semantictag + "&acceptability="
					+ acceptability + "&returnlimit=" + returnlimit;

			$
					.ajax({
						type : "GET",
						url : servURL,
						dataType : "jsonp",
						crossDomain : true,
						success : function(data, textStatus, jqXHR) {

							var htmlData = '';
							jsonData = data;
							$('#reccount').text(data.length);
							if (data.length == 0) {
								$("#dialog-form").dialog("option", "height",
										160);
								if (document.getElementById("conceptdiv"))
									$("#conceptdiv").remove();
								$('#reccnt').hide();
								$('#reccount').hide();
								$('#norec').show();
								$('#msg3chars').hide();
								$('#nosuggestion').hide();
								var txtBox = document
										.getElementById("txt-snomed-ct-search");
								txtBox.focus();
								return;
							}

							displaySearch = false;

							htmlData = '';
							htmlData += '<div class="concept" id="conceptdiv">';

							htmlData += '<table class="bordered">';
							htmlData += '<thead><tr><th>Description&nbsp;&nbsp;&nbsp;&nbsp;</th><th><input type="button" id="selectAllTerm" value="select all" onclick="selectAll();"><input type="button" id="selectTerm" value="OK" onclick="copyValue();"></th></tr></thead>';
							currentCountDisplayed = data.length;
							for (var i = 0; i < data.length; ++i) {
								var val = '\'' + data[i].conceptId + '###$$$'
										+ data[i].term + '###$$$' + data[i].id
										+ '\'';

								htmlData += '<tr title="'
										+ data[i].conceptFsn
										+ '"><td>'
										+ '<input type="checkbox" class="conceptIdChecks" name="conceptIdChecks" value="'
										+ data[i].conceptId + "|"
										+ data[i].term + '" />' + '</td><td>'
										+ data[i].term + '</td></tr>';
							}
							$("#dialog-form").dialog("option", "height", "500");
							htmlData += '</table>';
							htmlData += '</div>';
							if (document.getElementById("conceptdiv"))
								$("#conceptdiv").remove();
							$("#dialog-form").append(htmlData);

						},
						error : function(jqXHR, textStatus, errorThrown) {
							console.log(textStatus);
						}
					});
		}
	});
}
function selectAll() {
	jQuery(function($) {
		var $boxes = $('input[name=conceptIdChecks]:checked');
		if ($boxes.length == 0) {
			$(".conceptIdChecks").prop('checked', true);
			$("#selectAllTerm").val("Deselect All");
		} else {
			$(".conceptIdChecks").prop('checked', false);
			$("#selectAllTerm").val("Select All");
		}
	});
}

function copyValue() {
	jQuery(function($) {
		var $boxes = $('input[name=conceptIdChecks]:checked');
		var count = document.getElementById("tableRow").value;
		$boxes
				.each(function() {
					var list = this.value.split("|");
					$('#procedureTable')
							.append(
									'<tbody><tr>'
											+ '<td><input type="hidden" style="text-transform:uppercase" id="code'
											+ count
											+ '" name="code'
											+ count
											+ '"  value="'
											+ list[1].substring(0, 5)
													.toUpperCase()
											+ count
											+ '"></input>'
											+ '<input type="hidden"  id="chargeId'
											+ count
											+ '"  name="chargeId'
											+ count
											+ '" value="'
											+ list[0]
											+ '"></input>'
											+ '<lable>'
											+ list[1]
											+ '</label><input type="hidden" name="charge'
											+ count
											+ '"  id="charge'
											+ count
											+ '" value="'
											+ list[1]
											+ '"></input>'
											+ '</td>'
											+ '<td><input type="text" id="chargerate'
											+ count
											+ '" pattern="[0-9]" name="chargerate'
											+ count + '"></td></tr></tbody>');
					count++;
				});
		$("#tableRow").val(count);
		$("#dialog-form").dialog('close');
	});
}

function copyselectSNOMEDCT(state_IN, semantictag_IN, acceptability_IN,
		returnlimit_IN, callback, callConceptId) {
	jQuery(function($) {
		if (returnlimit_IN <= -1 || returnlimit_IN == ''
				|| returnlimit_IN == undefined || returnlimit_IN == null) {
			returnlimit_IN = -1;

		}
		returnlimitParam = returnlimit_IN;

		if (state_IN == -1 || state_IN == null || state_IN == ''
				|| state_IN == undefined) {
			state_IN = enumSTATE.BOTH;
		} else

			state_IN = enumSTATE[state_IN];

		stateParam = state_IN;

		if (semantictag_IN == -1 || semantictag_IN == null
				|| semantictag_IN == undefined || semantictag_IN == '') {
			semantictag_IN = enumSEMANTICTAG.ALL;
		} else
			semantictag_IN = enumSEMANTICTAG[semantictag_IN];

		semantictagParam = semantictag_IN;

		if (acceptability_IN == -1 || acceptability_IN == null
				|| acceptability_IN == undefined || acceptability_IN == '') {
			acceptability_IN = enumACCEPTABILITY.ALL;
		} else
			acceptability_IN = enumACCEPTABILITY[acceptability_IN];

		acceptabilityParam = acceptability_IN;

		$("#dialog-form").click(
				function(e) {
					if (e.target.id == "srcImg") {
						var dataValue = document
								.getElementById("txt-snomed-ct-search").value;
						if (dataValue.length >= 3) {
							if (document.getElementById("conceptdiv"))
								$("#conceptdiv").remove();
							$('#msg3chars').hide();
							$('#nosuggestion').hide();
							copyResultsList(stateParam, semantictagParam,
									acceptabilityParam, returnlimitParam,
									callback, callConceptId);
						} else {
							if (document.getElementById("conceptdiv"))
								$("#conceptdiv").remove();
							$('#msg3chars').show();
							$('#reccnt').hide();
							$('#reccount').hide();
							$('#norec').hide();
							$('#nosuggestion').hide();
						}
					}

				});

		selectedConceptId = "";

		displaySearch = false;

		$("#dialog-form").dialog("option", "height", 140);
		$("#dialog-form").html(dialogFormHTML);
		jQuery('.ui-dialog button:nth-child(1)').button('disable');
		$('.ui-dialog-buttonpane').find("button").show().filter(
				":contains('.')").hide();
		$("#reccnt").hide();
		$('#reccount').hide();
		$('#norec').hide();
		$('#msg3chars').hide();
		$('#nosuggestion').hide();

		var txtBox = document.getElementById("txt-snomed-ct-search");
		txtBox.focus();

		$("#dialog-form").dialog("open");

		$("#txt-snomed-ct-search").keyup(
				function(e) {
					if (e.which == 13) {
						var dataValue = document
								.getElementById("txt-snomed-ct-search").value;

						if (dataValue == '') {
							$("#dialog-form").dialog("option", "height", 160);
							var txtBox = document
									.getElementById("txt-snomed-ct-search");
							txtBox.focus();
							return;
						}

						if (dataValue.length >= 3) {
							$("#dialog-form").dialog("option", "height", 500);
							if (document.getElementById("conceptdiv"))
								$("#conceptdiv").remove();
							$("#msg3chars").hide();
							$('#nosuggestion').hide();
							var txtBox = document
									.getElementById("txt-snomed-ct-search");
							txtBox.blur();
							copyResultsList(stateParam, semantictagParam,
									acceptabilityParam, returnlimitParam,
									callback, callConceptId);
						} else {
							if (document.getElementById("conceptdiv"))
								$("#conceptdiv").remove();
							$('#reccnt').hide();
							$('#reccount').hide();
							$('#norec').hide();
							$("#msg3chars").show();
							$('#nosuggestion').hide();
						}
					} else {
						$('#reccnt').hide();
						$('#reccount').hide();
						$('#nosuggestion').hide();
					}
				});

		var xhrRequest = null;
		$("#txt-snomed-ct-search")
				.autocomplete(
						{
							max : 20,
							minLength : 3,
							cacheLength : 1,
							scroll : false,
							width : 520,
							highlight : false,
							autoFocus : false,
							source : function(request, response) {

								var dataValue = document
										.getElementById("txt-snomed-ct-search").value;

								var servURL = "";
								if (dataValue == '') {
									$("#dialog-form").dialog("option",
											"height", 160);
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									var txtBox = document
											.getElementById("txt-snomed-ct-search");
									txtBox.focus();
									return;
								}

								if (dataValue.length >= 3) {
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									$("#dialog-form").dialog("option",
											"height", 160);
									$("#msg3chars").hide();
									$('#nosuggestion').hide();

								} else {
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									$("#dialog-form").dialog("option",
											"height", 160);
									$('#reccnt').hide();
									$('#reccount').hide();
									$('#norec').hide();
									$("#msg3chars").show();
									$('#nosuggestion').hide();
								}

								servURL = enumSERVICES.SEARCH.suggestbyacceptability_url;

								servURL += "?term="
										+ encodeURIComponent(request.term)
										+ "&state=" + stateParam
										+ "&semantictag=" + semantictagParam
										+ "&acceptability="
										+ acceptabilityParam
										+ "&returnlimit=10";
								console.log(servURL);

								if (xhrRequest && xhrRequest.readystate != 4)
									xhrRequest.abort();
								xhrRequest = $
										.ajax({
											type : "GET",
											url : servURL,
											dataType : "jsonp",
											crossDomain : true,
											success : function(data,
													textStatus, jqXHR) {
												console.log(data);
												var items = data;
												if (items.length <= 0) {
													$('#reccnt').hide();
													$('#reccount').hide();
													$('#norec').hide();
													$("#msg3chars").hide();
													$('#nosuggestion').show();
												}
												response(items);
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
												console.log(textStatus);

											}
										});

							},
							select : function(event, ui) {
								var data = document
										.getElementById("txt-snomed-ct-search").value;
								if (data.length >= 3) {

									$("#msg3chars").hide();
									$('#nosuggestion').hide();
									document
											.getElementById("txt-snomed-ct-search").value = ui.item.value;
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();

									copyResultsList(stateParam,
											semantictagParam,
											acceptabilityParam,
											returnlimitParam, callback,
											callConceptId);
								} else {
									if (document.getElementById("conceptdiv"))
										$("#conceptdiv").remove();
									$('#reccnt').hide();
									$('#reccount').hide();
									$('#norec').hide();
									$("#msg3chars").show();
									$('#nosuggestion').hide();
								}
							}

						});
	});
}

/* snomed codes ends */

jQuery(function($) {
	$("#referral").change(function() {
		if ($("#referral").val() == 1) {
			$("#admDiv").hide();
			$("#admissionAdvised").prop("checked", false);
			$("#admissionAdvised").prop('disabled', true);
		} else {
			$("#admissionAdvised").prop('disabled', false);
		}
	});
	$("#removesnomedList").click(function() {
		$("#snomedList option:selected").remove();
	});

	$(".primary-items a").click(function() {
		$(this).siblings('#subMenu').slideToggle();
	});

	$('input[name="labradiologyCheck"]').change(
			function() {
				// alert($('input[name="labradiologyCheck"]:checked').val());
				$('#investigationCategory').val(
						$('input[name="labradiologyCheck"]:checked').val());
			});
	$('#investigationCategory').val(
			$('input[name="labradiologyCheck"]:checked').val());
	
	
	$('input[name="pharmacyCheck"]').change(
			function() {
				// alert($('input[name="labradiologyCheck"]:checked').val());
				$('#pharmacyCategory').val(
						$('input[name="pharmacyCheck"]:checked').val());
			});
	$('#investigationCategory').val(
			$('input[name="labradiologyCheck"]:checked').val());
	/*
	 * $("#vitalTrends").click(function(){ var
	 * hinId=document.getElementById("hinId").value;; new
	 * Ajax.Request('opd?method=getPatientVitalTrends&hinId='+hinId, {
	 * onSuccess: function(response) { if(response.responseText.trim()!='No
	 * vital Details') {
	 * $("#vitalUHID").val(document.getElementById("hinNo").value);
	 * $("#vitalPname").val(document.getElementById("patientName").value);
	 * $("#vitalTable").html(response.responseText.trim());
	 * $("#vitalDialog").dialog({width:842,height:332,modal: true}); }else{
	 * alert("No vital details"); } } }); });
	 * $("#calculateBmi").click(function(){ $("#dialog").css("color:black");
	 * $("#dialog").dialog({width: 350,modal: true}); });
	 */

	$("#resetBmi").click(function() {
		$("#height").val("");
		$("#weight").val("");
	});
	/*
	 * $("#submitCalBMI").click(function(){ var bmicat; $("#bmi").val("");
	 * 
	 * if($("#height").val() != "" && $("#weight").val() !="" &&
	 * !isNaN($("#height").val()) && !isNaN($("#weight").val()) &&
	 * parseInt($("#height").val())!=0 && parseInt($("#height").val())!=0 ) {
	 * 
	 * $("#heightHidden").val($("#height").val());
	 * $("#weightHidden").val($("#weight").val());
	 * 
	 * var height = parseFloat($("#height").val())/100; var weight =
	 * $("#weight").val();
	 * 
	 * $("#bmi").val((weight/(height*height)).toFixed(2));
	 * bmicat=(weight/(height*height)).toFixed(2);
	 * 
	 * $("#bmicat").val(" "); if(bmicat<18.5){ $("#bmicat").val("Underweight");
	 * $("#bmicat").prev().css('color', '#F65C5C'); $("#bmicat").css('color',
	 * '#F65C5C'); }else if(bmicat>=18.5 && bmicat<25){
	 * $("#bmicat").val("Healthy Range"); $("#bmicat").prev().css('color',
	 * 'green'); $("#bmicat").css('color', 'green'); }else if(bmicat>=25 &&
	 * bmicat<=30){ $("#bmicat").val("Overweight");
	 * $("#bmicat").prev().css('color', '#574F4F'); $("#bmicat").css('color',
	 * '#574F4F'); }else if(bmicat>=30 && bmicat<=35){
	 * $("#bmicat").val("Obese"); $("#bmicat").prev().css('color', '#C40707');
	 * $("#bmicat").css('color', '#C40707'); }else if(bmicat>35){
	 * $("#bmicat").val("Severely obese "); $("#bmicat").prev().css('color',
	 * '#AD0C0C'); $("#bmicat").css('color', '#AD0C0C'); } } $("#bmicat").val()
	 * $('#dialog').dialog('close'); });
	 */

	$("#temperature").blur(function() {
		if ($("#temperature").val() > 999) {
			alert("Invalid Temperature");
			$("#temperature").focus();
			$("#temperature").val("");
		}
	});

	$(".allownumericwithdecimal")
			.on(
					"keypress keyup blur",
					function(event) {
						// this.value = this.value.replace(/[^0-9\.]/g,'');
						$(this).val($(this).val().replace(/[^0-9\.]/g, ''));
						if ((event.keyCode != 46)
								&& ((event.keyCode != 37))
								&& ((event.keyCode != 39))
								&& (event.keyCode != 9)
								&& (event.keyCode != 8)
								&& (event.which != 46 || $(this).val().indexOf(
										'.') != -1)
								&& (event.which < 48 || event.which > 57)) {
							event.preventDefault();
						}
					});

	$(".allownumericwithoutdecimal").on(
			"keypress keyup blur",
			function(event) {
				$(this).val($(this).val().replace(/[^\d].+/, ""));
				$(this).val($(this).val().replace(/\./g, ""));
				if ((event.keyCode != 46) && ((event.keyCode != 37))
						&& ((event.keyCode != 39)) && (event.keyCode != 9)
						&& (event.keyCode != 8)
						&& (event.which < 48 || event.which > 57)) {
					event.preventDefault();
				}
			});

	$("#generalExamination1").dblclick(
			function() {
				$("#generalExaminationOPC").val(
						$.trim($("#generalExaminationOPC").val()
								+ "\n"
								+ $("#generalExamination1 option:selected")
										.text()));
				$("#generalExaminationEXM").val(
						$.trim($("#generalExaminationEXM").val()
								+ "\n"
								+ $("#generalExamination2 option:selected")
										.text()));
			});
	$("#generalExamination2").dblclick(
			function() {
				$("#generalExaminationOPC").val(
						$.trim($("#generalExaminationOPC").val()
								+ "\n"
								+ $("#generalExamination1 option:selected")
										.text()));
				$("#generalExaminationEXM").val(
						$.trim($("#generalExaminationEXM").val()
								+ "\n"
								+ $("#generalExamination2 option:selected")
										.text()));
			});
	$("#diastolic").blur(function() {
		if (parseInt($("#systolic").val()) < parseInt($("#diastolic").val())) {
			alert("Diastolic should be less than Systolic");
			$("#diastolic").val("");
			$("#diastolic").focus();
		}
	});
	$("#removeOPDisgnosis").click(
			function() {
				if ($("#diagnosisId option:selected").length > 1) {
					alert("You can delete only one option at a time !");
				} else {
					$("#diagnosisId option:selected").remove();
					deleteRowFromOPConsultationTab($(
							"#diagnosisId1 option:selected").index());
				}
			});
	$("#removeOPDisgnosis").click(
			function() {
				if ($("#diagnosisId option:selected").length > 1) {
					alert("You can delete only one option at a time !");
				} else {
					$("#diagnosisId option:selected").remove();
					deleteRowFromOPConsultationTab($(
							"#diagnosisId1 option:selected").index());
				}
			});
	$("#removeSnomed").click(function() {
		document.getElementById("snomed").value = '';
	});
	$("#icd").blur(function() {
		var code1 = {};

		$("select[name='diagnosisId'] > option").each(function() {
			if (code1[this.text]) {
				$(this).remove();
			} else {
				code1[this.text] = this.value;
			}
		});

	});
	$('#admissionAdvised').click(function() {
		$("#admDiv").toggle(this.checked);
	});

	$('#patient_expire').click(function() {
		var checked = $(this).is(':checked');
		$("#referral").val('0');
		if (checked) {
			if ($("#referral").val() == 0) {
				$("#referalDiv").hide();
				$("#referDiv").hide();
				$("#siftedToMortuaryDiv").show();
			}
		} else {
			$("#referalDiv").show();
			$("#referDiv").hide();
			$("#siftedToMortuaryDiv").hide();
		}
	});
	$('#referral').click(function() {
		var selVal = $("#referral").val();
		if (selVal == 0) {
			$("#referDiv").hide();
		} else if (selVal == 1) {
			$("#referDiv").show();
			var deptId = $('#referdepartment').val();
			getSessionForDepartment(deptId);
		}
	});
});

if (!''.trim) {
	String.prototype.trim = function() {
		return this.replace(/^\s+|\s+$/g, '');
	};
}

function fnNurseOpdSubmitPatient(hinId, visitId) {

	if (confirm("Do you want to submit !")) {
		submitForm('injectionAdministration',
				'opd?method=submitNursingDetails&hinId=' + hinId + '&visitId='
						+ visitId);

	}

}

function fnSubmitPatient(from) {
	var str = document.getElementById("presentComplain").value.replace(/(\n)/g,
			',');
	document.getElementById("presentComplain").value = str.substring(0,
			str.length);

	if(document.getElementById("pastIllness")){
		str = document.getElementById("pastIllness").value.replace(/(\n)/g, ',');
		document.getElementById("pastIllness").value = str.substring(0, str.length);
	}
	
	if (document.getElementById("personalHistory")) {
		str = document.getElementById("personalHistory").value.replace(/(\n)/g,
				',');
		document.getElementById("personalHistory").value = str.substring(0,
				str.length);
	}
	if (document.getElementById("familyHistory")) {
	str = document.getElementById("familyHistory").value.replace(/(\n)/g, ',');
	document.getElementById("familyHistory").value = str.substring(0,
			str.length);
	}
	str = document.getElementById("medicationhistory").value.replace(/(\n)/g,
			',');
	document.getElementById("medicationhistory").value = str.substring(0,
			str.length);
	var departmentCode = null;
	var deptCodeENT = null;
	var formVal = null;
	if (document.getElementById("departmentCode") && document.getElementById("deptCodeENT")) {
	departmentCode = document.getElementById("departmentCode").value;
	deptCodeENT = document.getElementById("deptCodeENT").value
	}
	if (document.getElementById("formId")) {
		 formVal = document.getElementById("formId").value;
	}
	
	if (from == 's') {
	if (validateFieldValues(from)) {
	if (confirm("Do you want to submit !")) {
	//Disabled the image annotation code 
	if(departmentCode != null && deptCodeENT != null && (departmentCode == deptCodeENT)){
		exportImages();
	}
	if(formVal != null){
		submitForm('opdMain',
		'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&forms='+formVal);
	}else{
		submitForm('opdMain',
				'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2');
	}
	}
   }
} else if (from == 'n') {
		if (validateFieldValues(from)) {
			if (confirm("Do you want to submit !")) {
				submitForm('opdMain',
						'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1');
			}
		}
	}else if (from == 'nextdetail') {
		if (validateFieldValues(from)) {
			if (confirm("Do you want to submit !")) {
				submitForm('opdMain',
						'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1&forms=opdetail');
			}
		}
	}else if (from == 'nextlite') {
		if (validateFieldValues(from)) {
			if (confirm("Do you want to submit !")) {
				submitForm('opdMain',
						'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1&forms=oplite');
			}
		}
	} else if (from == 'p') {
		if (validateFieldValues(from)) {
			if (confirm("Do you want to park patient !")) {
				submitForm('opdMain',
						'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=3');
			}
		}
	} else if (from == 'secondop') {
		if (validateFieldValues(from)) {
			
				submitForm('opdMain',
						'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=4');
			
		}
	}
}

function jsSetIcdData(icd_no) {
	document.getElementById("icdCode").value = icd_no;
	document.getElementById("icdCode1").value = icd_no;
	document.getElementById("icdCode").focus();
}

function checkFrequency(counter, loc) {
	if (counter > 0 && loc == "opc") {
		var obj = document.getElementById("frequency" + (counter - 1));
		var unit = document.getElementById("unit" + (counter - 1)).value;
		var tapered = document.getElementById("tapered" + (counter - 1)).value;
		if (tapered != "y") {
			if (document.getElementById("nomenclature" + (counter - 1))!=null && document.getElementById("nomenclature" + (counter - 1)).value!=""  && unit == "") {
				alert("Unit not available");
				document.getElementById("nomenclature" + (counter - 1)).focus();
				return;
			}
			if ( document.getElementById("nomenclature" + (counter - 1))!=null && document.getElementById("nomenclature" + (counter - 1)).value!="" && obj.selectedIndex == 0) {
				alert("Select Frequency");
				document.getElementById("frequency" + (counter - 1)).focus();
				return;
			}
		}

	} else if (counter > 0 && loc == "tab") {
		var obj = document.getElementById("frequencypTab" + (counter - 1));
		var unit = document.getElementById("unitpTab" + (counter - 1)).value;
		if (unit == "") {
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
function checkMappedCharge(val, count) {
	jQuery(function($) {
		if (val != "") {
			$
					.ajax({
						url : "/hms/hms/opd?method=checkMappedCharge" + "&"
								+ csrfTokenName + "=" + csrfTokenValue,
						data : {
							chargeName : val
						},
						success : function(result) {
							var str = result.split("|");
							if (str[0] == "success") {
								$("#surgery_code_id" + count).val(str[1]);
								for (var xx = 0; xx <= count - 1; xx++) {
									if ($("#surgery_code_id" + count).val() == $(
											"#surgery_code_id" + xx).val()) {
										$("#surgery_code_id" + count).val("");
										$("#procedureName_surgery" + count)
												.val("");
										alert("charge already taken");
										break;
									}
								}
							} else if (str[0] == "failed") {
								alert(val.toUpperCase()
										+ " charge is not configured. Please configure before prescribe.");
								$("#procedureName_surgery" + count).val("");
							}
						}
					});
		}
	});
}

function deleteRow(r) {
	var i = r.parentNode.parentNode.rowIndex;
	if (document.getElementById("diagnosisId1") != null) {
		document.getElementById("diagnosisId1").deleteRow(i);
		var x = document.getElementById("diagnosisId");
		// x.remove(x.selectedIndex);
		x.remove((i - 1));
	}
}
function deleteRowFromOPConsultationTab(i) {
	if (document.getElementById("diagnosisId1") != null) {
		document.getElementById("diagnosisId1").deleteRow(i);
	}
	// var x = document.getElementById("diagnosisId");
	// x.remove((i-1));
}

function checkEnteredDiagnosis() {
	if (document.getElementById('diagnosisId').length == 0
			&& document.getElementById('OtherDiagnosis').value.trim().length == 0) {
		alert("Please Diagnos the Disease first");
		var cntr = new ddtabcontent("countrytabsIn")
		cntr.setpersist(true)
		cntr.setselectedClassTarget("link")
		cntr.init()
		cntr.expandit(0);
		document.getElementById("snomed").focus();
		return true;
	} else {
		return false;
	}
}

function checkDrugToDiseaseCantra(obj) {
	jQuery(function($) {
		var index1 = obj.value.lastIndexOf("(");
		var index2 = obj.value.lastIndexOf(")");
		index1++;
		var itemId = obj.value.substring(index1, index2);
		var diagObj = document.getElementById("diagnosisId");
		var strText = "";
		if(diagObj){
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
	   }
	});
}

function getLoincSnomedList(inc) {
	jQuery(function($) {
		var labText = $("#chargeCodeName" + inc).val();
		new Ajax.Request(
				'opd?method=getLoincSnomedList&labText=' + labText + '&'
						+ csrfTokenName + '=' + csrfTokenValue,
				{
					onSuccess : function(response) {
						if (response.responseText.trim() != 'No Snomed Mapping Founds') {
							$('#snomedTermsInv' + inc).val(
									response.responseText.trim())
						}
					}
				});
	});
}

function getLoincSnomedListDermotology(inc) {
	jQuery(function($) {
		var labText = $("#chargeCodeNameDermotology" + inc).val();
		new Ajax.Request(
				'opd?method=getLoincSnomedList&labText=' + labText + '&'
						+ csrfTokenName + '=' + csrfTokenValue,
				{
					onSuccess : function(response) {
						if (response.responseText.trim() != 'No Snomed Mapping Founds') {
							$('#snomedTermsInv' + inc).val(
									response.responseText.trim())
						}
					}
				});
	});
}

function deleteKeyword(str) {
	var regex = new RegExp("(^" + str + "$\n|\n^" + str + "$)", "gim");
	var textarea = document.getElementById("systemicExamination");
	textarea.value = textarea.value.replace(regex, "");
}
function checkTextColor(id) {
	jQuery(function($) {
		var text = $("#" + id).val();
		if (text == "") {
			$("#" + id).css({
				'color' : 'black',
				/*'font-size' : '125%'*/
			});
		}
	});
}

function validatePrescriptionAutocomplete(flag, strValue, inc) {
	if (flag == 'opmain') {
		var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		var id = strValue.substring(index1, index2);
		var count = document.getElementById('hdb').value;
		if (id == "") {
			document.getElementById('nomenclature' + inc).value = "";
			return;
		}
		for (var i = 0; i < count; i++) {
			if (document.getElementById('nomenclature' + i) != null
					&& document.getElementById('nomenclature' + i).value == strValue
					&& i != inc) {
				if (document.getElementById('tapered' + i) != null
						&& document.getElementById('tapered' + i).value != 'y') {
					alert('This Prescription is already selected.');
					document.getElementById('nomenclature' + inc).value = "";
					document.getElementById('tapered' + inc).value = "";
					document.getElementById('route' + inc).value = "0";
					document.getElementById('dosage' + inc).value = "";
					document.getElementById('unit' + inc).value = "";
					document.getElementById('noOfDays' + inc).value = "";
					return false;
				}
			}

		}
		return true;
	} else if (flag == 'opPTab') {
		var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		var id = strValue.substring(index1, index2);
		var count = document.getElementById('hdb').value;
		if (id == "") {
			document.getElementById('nomenclaturepTab' + inc).value = "";
			return;
		}

		for (var i = 0; i < count; i++) {
			if (document.getElementById('nomenclaturepTab' + i) != null
					&& document.getElementById('nomenclaturepTab' + i).value == strValue
					&& i != inc) {

				alert('This Prescription is already selected.');
				document.getElementById('nomenclaturepTab' + inc).value = "";
				return false;
			}
		}
		return true;
	} else if (flag == 'opNursingProc') {
		var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		var id = strValue.substring(index1, index2);
		var count = document.getElementById('nursinghdb').value;

		for (var i = 0; i < count; i++) {
			var nxtValue = document.getElementById('procedureName_nursing' + i).value;
			var index3 = nxtValue.lastIndexOf("[");
			var index4 = nxtValue.lastIndexOf("]");
			var nxtId1 = nxtValue.substring(index3, index4);
			var nxtId = "";
			/*
			 * if(nxtId1.charAt(0)=='['){ nxtId=nxtId1.substr(1); }
			 */
			nxtId = nxtId1.replace("[", "");
			if (document.getElementById('procedureName_nursing' + i).value != ""
					&& id != "" && nxtId != "" && id == nxtId && i != inc) {

				alert('This Procedure is already Entered.');
				document.getElementById('procedureName_nursing' + inc).value = "";
				return false;
			}
		}
		return true;
	}

}

function changeTest() {
	var count = document.getElementById("hdb").value;
	var val = document.getElementById("route" + count).value;
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var id = val.substring(index1, index2);
	var text = val.replace("[" + id + "]", "");
	document.getElementById("route" + count).value = text;
	document.getElementById("routeHidden" + count).value = id;
}
function changeTestpTab() {
	var count = document.getElementById('pTabhdb').value;
	var val = document.getElementById("routepTab" + count).value;
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var id = val.substring(index1, index2);
	var text = val.replace("[" + id + "]", "");
	document.getElementById("routepTab" + count).value = text;
	// document.getElementById("routepTabId"+count).value=id;
}

function setEndDate(nod, inc) {
	var nextDay;
	nextDay = new Date();
	nextDay.setDate(nextDay.getDate() + parseInt(nod));
	document.getElementById("endDate" + inc).value = nextDay.getDate() + "/"
			+ (nextDay.getMonth() + 1) + "/" + nextDay.getFullYear();
}
function showParkPatient(status) {
	document.opdMain.action = "/hms/hms/opd?method=getOPClinicalWaitingList&flag="
			+ status;
	document.opdMain.submit();
}

function fillDiagnosisCombo(val) {

	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var id = val.substring(index1, index2);
	if (id == "") {
		return;
	} else {
		var obj = document.getElementById('diagnosisId');
		var b = "false";
		for (var i = 0; i < obj.length; i++) {

			var val1 = obj.options[i].value;
			var length = obj.length - 1;

			if (id == val1) {
				alert("ICD  Already taken");
				document.getElementById('icd').value = ""
				document.getElementById('icd2').value = ""
				b = true;
			}
		}

		if (b == "false") {
			var flag = 2;
			obj = document.getElementById('diagnosisId');
			for (var x = 0; x < obj.length; x++) {
				var dpId = obj.options[x].value;
				dpId = dpId.split("-");
				if (dpId[0] == id) {
					flag = 1;
					break;
				}
			}
			if (flag != 1) {
				obj.length = document.getElementById('diagnosisId').length;
				obj.length++;
				obj.options[obj.length - 1].value = id + "-0";
				document.getElementById('icdCode').value = id;
				id = id.replace(".", "_");
				id = id.replace("*", "idid");
				id = id.replace("?", "~");
				obj.options[obj.length - 1].selected = true;
				obj.options[obj.length - 1].text = val;
				document.getElementById('icd').value = "";
				document.getElementById('icd2').value = "";
				jQuery(function($) {
					$
							.post(
									'opd?method=getDeseaseStatus&icdCode=' + id
											+ '&' + csrfTokenName + '='
											+ csrfTokenValue,
									function(data) {
										try {
											var str = data.split("_");
											var objColor = document
													.getElementById('diagnosisIdNP');
											if (str[0] == "n" || str[0] == "N") {
												var opt = document
														.createElement('option');
												opt.value = id;
												opt.innerHTML = val;
												objColor.appendChild(opt);
												objColor.options[objColor.length - 1].style = "color: #FF0000";
												var code2 = {};
												$(
														"select[name='diagnosisIdNP'] > option")
														.each(
																function() {
																	if (code2[this.value]) {
																		$(this)
																				.remove();
																	} else {
																		code2[this.value] = this.value;
																	}
																});
											}
											if (str[1] == "p" || str[1] == "P") {
												var opt = document
														.createElement('option');
												opt.value = id;
												opt.innerHTML = val;
												objColor.appendChild(opt);
												objColor.options[objColor.length - 1].style = "color:#008000";
												var code2 = {};
												$(
														"select[name='diagnosisIdNP'] > option")
														.each(
																function() {
																	if (code2[this.value]) {
																		$(this)
																				.remove();
																	} else {
																		code2[this.value] = this.value;
																	}
																});
											}
										} catch (e) {
											alert(e);
										}
									});
				});
				obj = document.getElementById('diagnosisId1');
				var tableRow = obj.rows.length;
				var row = obj.insertRow(tableRow);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				cell1.innerHTML = val;
				cell2.innerHTML = "<input type='checkbox' id='" + id
						+ "' class='radioCheckCol2' value='" + id
						+ "' onclick='fnCopyToComorbidityTab(\"" + id
						+ "\")'/>";
				cell3.innerHTML = "<img src='/hms/jsp/images/removeImg.jpg' style='width:16px;height:16px' title='Remove diagnosis' onclick='deleteRow(this);'/>"
			} else {
				alert("Diagnosis already exist.");
			}
		}
	}
}

function getIcd(from) {
	var icdCode;
	if (from == 1) {
		icdCode = document.getElementById("icdCode").value;
	} else if (from == 2) {
		icdCode = document.getElementById("icdCode1").value
	}
	if (icdCode != "") {
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
					icdString = item.getElementsByTagName('icdString')[0];
					document.getElementById('icd').value = icdString.childNodes[0].nodeValue
					document.getElementById('icdCode').value = "";
					document.getElementById('icdCode1').value = "";
					var val = document.getElementById('icd').value;
					var index1 = val.lastIndexOf("[");
					var index2 = val.lastIndexOf("]");
					index1++;
					var id = val.substring(index1, index2);
					if (id == "") {
						return;
					} else {
						var obj = document.getElementById('diagnosisId');
						for (var i = 0; i < obj.length; i++) {
							var val1 = obj.options[i].value;
							var length = obj.length - 1;
							if (id == val1) {
								alert("ICD  Already taken");
								document.getElementById('icd').value = ""
								document.getElementById('icd2').value = ""
								b = true;
							}
						}
					}
					if (!b) {
						var flag = 2;
						var obj = document.getElementById('diagnosisId');
						for (var x = 1; x <= obj.length; x++) {
							var dpId = obj.options[x].value;
							dpId = dpId.split("-");
							if (dpId[0] == id) {
								flag = 1;
								break;
							}
						}
						if (flag != 1) {
							var length = obj.length + 1;
							obj.options[length].text = document
									.getElementById('icd').value;
							obj.options[length].value = id + "-0";
						} else {
							alert("Diagnosis already exist");
						}

					}
				}
			}
		}
		var url = "/hms/hms/opd?method=getIcdWithIcdCode&icdCode="
				+ encodeURIComponent(icdCode) + '&' + csrfTokenName + '='
				+ csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);

	}
}

function checkVitals() {
	jQuery(function($) {
		if ($("#observationStatus").prop("checked")) {
			if ($("#pulse").val() == "") {
				alert("Enter Pulse vital for observation");
				$("#pulse").focus();
			} else if ($("#temperature").val() == "0.0") {
				alert("Enter Temperature vital for observation");
				$("#temperature").focus();
			} else if ($("#diastolic").val() == "") {
				alert("Enter diastolic vital for observation");
				$("#diastolic").focus();
			} else if ($("#systolic").val() == "") {
				alert("Enter systolic vital for observation");
				$("#systolic").focus();
			}
		}
	});
}

function compareDate(idno) {
	var sDate = document.getElementById("startDate" + idno).value;
	var eDate = document.getElementById("endDate" + idno).value;
	if (sDate != "" && eDate != "") {
		stDate = new Date(sDate.substring(6), (sDate.substring(3, 5) - 1),
				sDate.substring(0, 2));
		edDate = new Date(eDate.substring(6), (eDate.substring(3, 5) - 1),
				eDate.substring(0, 2));
		var seperator = "/"
		startDate = new Date();
		endDate = new Date();
		var month = stDate.getMonth() + 1
		var day = stDate.getDate();
		var year = stDate.getFullYear();
		startDate = new Date(month + seperator + day + seperator + year);

		month = edDate.getMonth() + 1
		day = edDate.getDate()
		year = edDate.getFullYear()
		endDate = new Date(month + seperator + day + seperator + year);
		if (startDate > endDate) {
			alert("StartDate should be not greater than EndDate !");
			document.getElementById("startDate" + idno).value = "";
			document.getElementById("endDate" + idno).value = "";
			return false;
		}
		return true;
	}
}

function checkStartDate(nod) {
	var dob = document.getElementById("startDate" + nod).value;
	if (dob != "") {
		adDate = new Date(dob.substring(6), (dob.substring(3, 5) - 1), dob
				.substring(0, 2));
		currentDate = new Date();
		var month = currentDate.getMonth() + 1
		var day = currentDate.getDate()
		var year = currentDate.getFullYear()
		var seperator = "/"
		currentDate = new Date(month + seperator + day + seperator + year);

		if (adDate < currentDate) {
			alert("Date is not valid. please check StartDate!");
			document.getElementById("startDate" + nod).value = "";
			document.getElementById("startDate" + nod).focus();
			return false;
		}
		return true;
	}
}
function checkEndDate(nod) {
	if (document.getElementById("EndDate" + nod) != null) {
		var dob = document.getElementById("EndDate" + nod).value;
		if (dob != "") {
			adDate = new Date(dob.substring(6), (dob.substring(3, 5) - 1), dob
					.substring(0, 2));
			currentDate = new Date();
			var month = currentDate.getMonth() + 1
			var day = currentDate.getDate()
			var year = currentDate.getFullYear()
			var seperator = "/"
			currentDate = new Date(month + seperator + day + seperator + year);

			if (adDate < currentDate) {
				alert("Date is not valid. please check EndDate!");
				document.getElementById("EndDate" + nod).value = "";
				document.getElementById('EndDate' + nod).focus();
				return false;
			}
			return true;
		}
	}
}

function getICDListBasedOnSnomedId() {

	var $ = jQuery.noConflict();
	var val = "";
	if ($("#snomedTermConceptIdEXM").val() != "") {
		val = $("#snomedTermConceptIdEXM").val();
	}
	if ($("#snomedTermConceptId").val() != "") {
		val = $("#snomedTermConceptId").val();
	}
	var temp = val;
	$("#icdName").empty();
	$("#divIcdName").hide();

	$("#icdNameExm").empty();
	$("#divIcdNameExm").hide();

	if (val != "") {
		// console.log("val="+val);
		// var index1 = val.lastIndexOf("[");
		// var index2 = val.lastIndexOf("]");
		// index1++;
		var id = val; // val.substring(index1,index2);

		var tempStr = $("#snomed").val(); // val.substring(0,index1-1);
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
											document.getElementById('icd').value = ""
											document.getElementById('icd2').value = ""
											b = true;
											break
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
														+ "-0>"
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
								$("#icdName").append(
										"<option value='0'>Select</option>");
								for (i = 0; i < jsonData.length; i++) {

									$("#icdName").append(
											"<option value="
													+ jsonData[i].IcdCode
													+ "@@@"
													+ jsonData[i].SnomedId
													+ ">" + jsonData[i].IndName
													+ "[" + jsonData[i].IcdCode
													+ "]</option>");

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
	$("#snomed").val("");
	$("#icd2").val("");
	$("#snomedTermConceptId").val("");
	$("#snomedTermConceptIdEXM").val("");

}

function fillICDValue(val2, from) {

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

				if (ICdId == tempICdId) {
					alert("ICD  Already taken");
					document.getElementById('icd').value = ""
					document.getElementById('icd2').value = ""
					b = true;
					break
				}
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
					"<option value=" + val2 + "-0>" + text + "</option>");
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

function setIcdCodeAndNameFromChildWindow(tempValue) {

	var $ = jQuery.noConflict();
	var b = false;
	document.getElementById('icd1').value = tempValue;

	var index = tempValue.indexOf("@@@");
	var exactValue = tempValue.substring(0, index);
	exactValue = exactValue + "]";

	var val = document.getElementById('icd1').value;
	var index1 = val.lastIndexOf("[");
	var index2 = val.lastIndexOf("]");
	index1++;
	var BothId = val.substring(index1, index2);
	var tempArray = new Array();
	tempArray = BothId.split("@@@");
	var ICdId = tempArray[0];
	var SnomedId = tempArray[1];
	document.getElementById('icdCode').value = "[" + ICdId + "]";

	var tempVal2 = ICdId;
	tempVal2 = tempVal2.replace(".", "_");
	tempVal2 = tempVal2.replace("*", "idid");

	/*
	 * alert("ICdId="+ICdId); alert("SnomedId="+SnomedId);
	 */
	if (ICdId == "") {
		return;
	} else {
		var obj = document.getElementById('diagnosisId');

		for (var i = 0; i < obj.length; i++) {
			var temp = $("#diagnosisId option").eq(i).val();
			/*
			 * var temp = obj.options[i].value; var length=obj.length-1;
			 */
			var BothId = new Array();
			BothId = temp.split("-");

			var tempArray = new Array();
			tempArray = BothId[0].split("@@@");
			var tempICdId = tempArray[0];
			var tempSnomedId = tempArray[1];
			/*
			 * alert("ICdId="+ICdId); alert("tempICdId="+tempICdId);
			 */

			if (ICdId == tempICdId) {
				alert("ICD  Already taken");
				document.getElementById('icd').value = ""
				document.getElementById('icd2').value = ""
				b = true;
				break
			}
		}
	}
	if (!b) {
		var flag = 2;
		var obj = document.getElementById('diagnosisId');

		for (var x = 0; x < obj.length; x++) {

			var temp = $("#diagnosisId option").eq(x).val();
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
			var obj = document.getElementById('diagnosisId');
			var length = obj.length + 1;
			$("#diagnosisId").append(
					"<option value=" + ICdId + "@@@" + SnomedId + "-0>"
							+ exactValue + "</option>");
			obj.options[obj.length - 1].selected = true;

			if (document.getElementById('diagnosisId1') != null) {
				obj = document.getElementById('diagnosisId1');
				var tableRow = obj.rows.length;
				var row = obj.insertRow(tableRow);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				cell1.innerHTML = exactValue;
				cell2.innerHTML = "<input type='checkbox' id='" + tempVal2
						+ "' class='radioCheckCol2' value='" + tempVal2
						+ "' onclick='fnCopyToComorbidityTab(\"" + tempVal2
						+ "\")'/>";
				cell3.innerHTML = "<img src='/hms/jsp/images/removeImg.jpg' style='width:16px;height:16px' title='Remove diagnosis' onclick='deleteRow(this);'/>"
			}
			notifiablePregisterCheck(tempVal2, exactValue);
		} else {
			alert("Diagnosis already exist!");
		}

	}
}
function notifiablePregisterCheck(id, val) {
	jQuery(function($) {
		$
				.post(
						'opd?method=getDeseaseStatus&icdCode=' + id + '&'
								+ csrfTokenName + '=' + csrfTokenValue,
						function(data) {
							try {
								var str = data.split("_");
								var objColor = document
										.getElementById('diagnosisIdNP');
								if (str[0] == "n" || str[0] == "N") {
									var opt = document.createElement('option');
									opt.value = id;
									opt.innerHTML = val;
									objColor.appendChild(opt);
									objColor.options[objColor.length - 1].style = "color: #FF0000";
									var code2 = {};
									$("select[name='diagnosisIdNP'] > option")
											.each(
													function() {
														if (code2[this.value]) {
															$(this).remove();
														} else {
															code2[this.value] = this.value;
														}
													});
								}
								if (str[1] == "p" || str[1] == "P") {
									var opt = document.createElement('option');
									opt.value = id;
									opt.innerHTML = val;
									objColor.appendChild(opt);
									objColor.options[objColor.length - 1].style = "color:#008000";
									var code2 = {};
									$("select[name='diagnosisIdNP'] > option")
											.each(
													function() {
														if (code2[this.value]) {
															$(this).remove();
														} else {
															code2[this.value] = this.value;
														}
													});
								}
							} catch (e) {
								alert(e);
							}
						});
	});
}

function showHideDrugTemplateCombo(valueOfTemplate) {
	if (valueOfTemplate == "0") {
		return false;
	} else {
		// document.getElementById("copyPrevPrescriptionTemplateDiv").style.display='none';
		submitProtoAjaxForOpdMainTemplate('opdMain',
				'/hms/hms/opd?method=showGridInMainJsp', 'divTemplet');
	}
}
function showTreatment() {
	var url = "/hms/hms/opd?method=showTreatmentPopUp" + "&" + csrfTokenName
			+ "=" + csrfTokenValue;
	newwindow = window
			.open(url, 'treatment',
					"left=2,top=100,height=700,width=1010,status=1,scrollbars=yes,resizable=0");
}
// written by rajendra kumar :18-04-2015
function showWaitingList() {
	var url = '/hms/hms/opd?method=getOPClinicalWaitingList' + '&'
			+ csrfTokenName + '=' + csrfTokenValue;
	window.location.href = url;
}

function popwindowImmunization(url) {
	var height = 550;
	var width = 1010;
	var left = (screen.width / 2) - (width / 2);
	var top = (screen.height / 2) - (height / 2);
	url = url + "&" + csrfTokenName + "=" + csrfTokenValue;
	window.open(url, "Patient Details",
			"resizable=0,scrollbars=no, status = no, height = " + height
					+ ", width =" + width + ",top=" + top + ", left=" + left)

}
function popFuturConsultation(url) {
	var height = 250;
	var width = 1100;
	var left = (screen.width / 2) - (width / 2);
	var top = (screen.height / 2) - (height / 2);
	url = url + "&" + csrfTokenName + "=" + csrfTokenValue;
	window.open(url, "Patient Details",
			"resizable=0,scrollbars=no, status = no, height = " + height
					+ ", width =" + width + ",top=" + top + ", left=" + left)

}

/* Template : 17-04-2015 */

function getPresentTemplate(csrf) {
	var url = '/hms/hms/opd?method=showPopUpPresentComplaint&' + csrf + '&'
			+ csrfTokenName + '=' + csrfTokenValue;
	popwindow(url);
}

function getFamilyHistoryTemplate(csrf) {
	var url = '/hms/hms/opd?method=showPopUpFamilyHistory&' + csrf + '&'
			+ csrfTokenName + '=' + csrfTokenValue;
	popwindow(url);
}

function getHistoryOfPastIllnessTemplate(csrf) {
	var url = '/hms/hms/opd?method=showPopUpHistoryOfPastIllness&' + csrf + '&'
			+ csrfTokenName + '=' + csrfTokenValue;
	popwindow(url);
}

function getPersonalHistoryTemplate(csrf) {
	var url = '/hms/hms/opd?method=showPopUpPersonalHistory&' + csrf + '&'
			+ csrfTokenName + '=' + csrfTokenValue;
	popwindow(url);
}

function getMedicationHistoryTemplate(csrf) {
	var url = '/hms/hms/opd?method=showPopUpMedicationHistory&' + csrf + '&'
			+ csrfTokenName + '=' + csrfTokenValue;
	popwindow(url);
}

function getGeneralExaminationTemplate(csrf) {
	var url = '/hms/hms/opd?method=showPopUpGeneralExamination&' + csrf + '&'
			+ csrfTokenName + '=' + csrfTokenValue;
	popwindow(url);
}

function getSystemicExaminationTemplate(csrf) {
	var url = '/hms/hms/opd?method=showPopUpSystemicExamination&' + csrf + '&'
			+ csrfTokenName + '=' + csrfTokenValue;
	popwindow(url);
}

var newwindow;
function popwindow(url) {
	url = url + '&' + csrfTokenName + '=' + csrfTokenValue;
	newwindow = window.open(url, 'name', 'height=500,width=800,status=1');
	if (window.focus) {
		newwindow.focus()
	}
	newwindow.createPopup();
}

function openPopupDiagnosisWindow() {
	var $ = jQuery.noConflict();
	$("#divIcdName").hide();
	$("#snomed").val("");
	var url = "/hms/hms/adt?method=showICDSearchJsp&" + csrfTokenName + "="
			+ csrfTokenValue;
	newwindow = window
			.open(url, 'opd_window',
					"left=100,top=100,height=700,width=1024,status=1,scrollbars=yes,resizable=0");
}

function addTermInSelect(termId, term, action, code) {
	/* Delete duplicate entry options */
	var desSelect = document.getElementById("disorder");
	if (desSelect.length > 0) {
		for (var x = 0; x < desSelect.length; x++) {
			if (desSelect[x].id == termId) {
				desSelect.remove(x);
			}
		}
	}
	desSelect = document.getElementById("finding");
	if (desSelect.length > 0) {
		for (var x = 0; x < desSelect.length; x++) {
			if (desSelect[x].id == termId) {
				desSelect.remove(x);
			}
		}
	}

	/* Add new options */
	var select = null;
	var newOption = document.createElement("option");
	newOption.id = termId;
	newOption.text = term;
	newOption.value = termId + ":" + term;
	newOption.setAttribute("selected", "selected");
	if (code == 1) {
		select = document.getElementById("disorder");
		if (action == 1) {
			select.appendChild(newOption);
		} else if (action == 2) {
			for (var i = 0; i < select.length; i++) {
				if (select.options[i].id == termId)
					select.remove(i);
			}
		}
	} else if (code == 2) {
		select = document.getElementById("finding");
		if (action == 1) {
			select.appendChild(newOption);
		} else if (action == 2) {
			for (var i = 0; i < select.length; i++) {
				if (select.options[i].id == termId)
					select.remove(i);
			}
		}
	}
}

function jsSetSnomedFindingData(findingCode) {
	document.getElementById("finding").value = findingCode;
	document.getElementById("finding").focus();
}

function openPopupWindowSnomedCT(code) {
	var url = "/hms/hms/opd?method=showSnomedCTSearchJsp&code=" + code + "&"
			+ csrfTokenName + "=" + csrfTokenValue;
	newwindow = window
			.open(url, 'opd_window',
					"left=100,top=100,height=640,width=850,status=1,scrollbars=yes,resizable=0");
}

function addRowTreatmentNursingCare() {

	var tbl = document.getElementById('gridNursing');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('nursinghdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'nursingRadio' + iteration;
	e1.id = 'nursingRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'procedureDetailId' + iteration;
	e1.id = 'procedureDetailId' + iteration;
	e1.className = "opdTextBoxSmall textYellow";
	e1.size = '35';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'procedureName_nursing' + iteration;
	e1.id = 'procedureName_nursing' + iteration;
	e1.className = "opdTextBoxSmall textYellow";
	e1.size = '35';
	e1.onblur = function chkProcedure() {
		validatePrescriptionAutocomplete('opNursingProc', document
				.getElementById('procedureName_nursing' + iteration).value,
				iteration);
	}

	cellRight1.appendChild(e1);
	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'ac2updates_nursing' + iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	new Ajax.Autocompleter('procedureName_nursing' + iteration,
			'ac2updates_nursing' + iteration,
			'opd?method=getNursingCareProcedureAutoList', {
				minChars : 3,
				callback : function(element, entry) {
					return entry + '&minor_major=1';
				},
				parameters : 'requiredField=procedureName_nursing' + iteration
			});

	var cellRight2 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'frequency_nursing' + iteration;
	e1.id = 'frequency_nursing' + iteration;
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < icdArray.length; i++) {
		e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]);
	}
	cellRight2.appendChild(e1);

	var cellRight3 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'noOfDays_nursing' + iteration;
	e1.className = "small textYellow";
	e1.id = 'noOfDays_nursing' + iteration;
	cellRight3.appendChild(e1);

	var cellRight4 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.name = 'remark_nursing' + iteration;
	e1.id = 'remark_nursing' + iteration;
	e1.className = "textYellow";
	e1.style.width = "190px";
	cellRight4.appendChild(e1);

	var cellRight5 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'alert' + iteration;
	e1.id = 'alert' + iteration;
	e1.className = "radioCheck";
	e1.size = '5';
	cellRight5.appendChild(e1);
}

function removeRowTreatmentNursingCare() {
	var tbl = document.getElementById('gridNursing');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('nursinghdb');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("nursingRadio" + i) != null
				&& (typeof document.getElementById("nursingRadio" + i).checked) != 'undefined'
				&& document.getElementById("nursingRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("nursingRadio" + i) != null
					&& (typeof document.getElementById("nursingRadio" + i).checked) != 'undefined'
					&& document.getElementById("nursingRadio" + i).checked) {
				var deleteRow = document.getElementById("nursingRadio" + i).parentNode.parentNode;
				document.getElementById("nursingRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowTreatmentSurgery() {

	var tbl = document.getElementById('gridSurgery');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('surgeryhdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'surgeryRadio' + iteration;
	e1.id = 'surgeryRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'surgeryDetailsId' + iteration;
	e1.id = 'surgeryDetailsId' + iteration;
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'procedureName_surgery' + iteration;
	e1.id = 'procedureName_surgery' + iteration;
	e1.className = "opdTextBoxSmall textYellow";
	e1.onkeypress = function() {
		selectSNOMEDCT('ACTIVE', 'PROCEDURE', 'ALL', returnlimit_IN,
				callbck_index, 'procedureName_surgery' + iteration);
	};
	e1.onblur = function() {
		checkMappedCharge(this.value, iteration);
	};
	e1.size = '35';
	cellRight2.appendChild(e1);

	/*
	 * var newdiv = document.createElement('div'); newdiv.setAttribute('id',
	 * 'ac2updates_surgery'+iteration); newdiv.style.display = 'none';
	 * newdiv.className = "autocomplete textYellow";
	 * cellRight1.appendChild(newdiv); new
	 * Ajax.Autocompleter('procedureName_surgery'+iteration,'ac2updates_surgery'+iteration,'opd?method=getNursingCareProcedureAutoList',{minChars:3,
	 * callback: function(element, entry) { return entry + '&minor_major=2'; },
	 * parameters:'requiredField=procedureName_surgery'+iteration});
	 */
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'surgery_code_id' + iteration;
	e1.id = 'surgery_code_id' + iteration;
	cellRight2.appendChild(e1);

	var cellRight3 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'tentativeDate' + iteration;
	e1.id = 'tentativeDate' + iteration;
	e1.size = '5';
	e1.value = "";
	e1.className = 'small textYellow';
	e1.readOnly = true;
	cellRight3.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';
	img1.onclick = function(event) {
		var obj = document.getElementById('tentativeDate' + iteration);
		setdate(document.createElement('consultationDate').value, obj, event);
	};
	cellRight3.appendChild(img1);

	var cellRight4 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.name = 'remark_surgery' + iteration;
	e1.id = 'remark_surgery' + iteration;
	e1.className = "textYellow";
	e1.style.width = "190px";
	cellRight4.appendChild(e1);

	var cellRight5 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'alertToStaff' + iteration;
	e1.id = 'alertToStaff' + iteration;
	e1.onclick = function() {
		displayPhAlert(this.value, iteration)
	};
	e1.size = '5';
	cellRight5.appendChild(e1);

	// var cellRight5 = row.insertCell(5);
	/*
	 * var e1 = document.createElement('select'); e1.options[0] = new
	 * Option('Select', ''); e1.options[1] = new Option('Delivery', 'DL');
	 * e1.options[2] = new Option('Birth', 'BR'); e1.options[3] = new
	 * Option('Communicable Disease', 'CD'); e1.options[4] = new Option('Non
	 * Communicable Disease', 'NCD'); e1.options[5] = new Option('Pregnancy
	 * Diagnosed', 'PD'); e1.options[6] = new Option('MTP', 'MTP');
	 * e1.options[7] = new Option('Abbortion', 'AB'); e1.style.display='none';
	 * e1.name = 'phAlert'+ iteration; e1.id = 'phAlert' + iteration;
	 * e1.tabIndex="1"; cellRight5.appendChild(e1);
	 */

}

function addRowForComorbidity() {

	var tbl = document.getElementById('comorbidityGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('comorbidityCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'comorbidityRadio' + iteration;
	e0.id = 'comorbidityRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight1.appendChild(e0);

	var cellRight0 = row.insertCell(1);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name = 'comorbidityName' + iteration;
	e0.id = 'comorbidityName' + iteration;
	e0.size = '20'
	e0.className = "opdTextBoxSmall textYellow";
	cellRight0.appendChild(e0);

	var updatediv = document.createElement('div');
	updatediv.setAttribute('id', 'ac2updateComorbidity' + iteration);
	updatediv.style.display = 'none';
	updatediv.className = "autocomplete textYellow";
	cellRight0.appendChild(updatediv);
	new Ajax.Autocompleter('comorbidityName' + iteration,
			'ac2updateComorbidity' + iteration, 'opd?method=getICDList', {
				parameters : 'requiredField=icd'
			});

	var cellRight3 = row.insertCell(2);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name = 'comorbidityMonth' + iteration;
	e0.id = 'comorbidityMonth' + iteration;
	e0.size = '20'
	e0.maxLength = "8";	
	e0.className = "opdTextBoxSmall textYellow";
	cellRight3.appendChild(e0);

	var cellRight3 = row.insertCell(2);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name = 'comorbidityYear' + iteration;
	e0.id = 'comorbidityYear' + iteration;
	e0.size = '20'
	e0.maxLength = "8";
	e0.className = "opdTextBoxSmall textYellow";
	cellRight3.appendChild(e0);

	var cellRight3 = row.insertCell(2);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name = 'comorbidityRemark' + iteration;
	e0.id = 'comorbidityRemark' + iteration;
	e0.size = '20'
	e0.maxLength = "150";
	e0.className = "opdTextBoxSmall textYellow";
	cellRight3.appendChild(e0);
}

function removeRowTreatmentSurgery() {
	var tbl = document.getElementById('gridSurgery');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('surgeryhdb');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("surgeryRadio" + i) != null
				&& (typeof document.getElementById("surgeryRadio" + i).checked) != 'undefined'
				&& document.getElementById("surgeryRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("surgeryRadio" + i) != null
					&& (typeof document.getElementById("surgeryRadio" + i).checked) != 'undefined'
					&& document.getElementById("surgeryRadio" + i).checked) {
				var deleteRow = document.getElementById("surgeryRadio" + i).parentNode.parentNode;
				document.getElementById("surgeryRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function checkTemplateId(templateId) {
	// alert(templateId)
	if (templateId == "0") {
		return false;
	} else
		return true;
}

function validateBpValue(obj) {
	var bpObj = document.getElementById('bp');
	var bool = validateBpWithSlash(obj)
	if (bool) {

		if (obj != "") {
			var index = obj.indexOf('/');
			if (index != 3) {
				alert("BP should be in max/min Format.")
				bpObj.value = "";
				bpObj.focus();
				return false;
			}

			var pairs2 = obj.substring(0, obj.length).split('/');
			if (pairs2.length != 2) {
				alert("Invalid  Format.")
				return false;
			}

			val3 = eval(pairs2[0]);
			if (val3 > 240) {
				alert("Maximum BP should be less than 240.")
				return false;
			}

			val2 = eval(pairs2[1]);
			if (val2 < 60) {
				alert("Minimum BP should be greater than 60")
				return false;
			}

		}
		return true;
	}
	bpObj.value = "";
	bpObj.focus();
	return false;
}

function validateInvestigationAutoComplete(strValue, inc) {

	var index1 = strValue.lastIndexOf("[");
	var index2 = strValue.lastIndexOf("]");
	index1++;
	var id = strValue.substring(index1, index2);
	var count = document.getElementById('hiddenValue').value;

	// alert("inc----"+inc)
	if (id == "") {
		document.getElementById('chargeCodeName' + inc).value = "";
		// document.getElementById('chargeCode'+inc).value="";
		return;
	}

	for (var i = 0; i <= count; i++) {
		if (document.getElementById('chargeCodeName' + i) != null
				&& document.getElementById('chargeCodeName' + i).value == strValue
				&& i != inc) {
			alert('This Investigation is already selected.');
			document.getElementById('chargeCodeName' + inc).value = "";
			document.getElementById('chargeCodeName' + inc).title="";
			// document.getElementById('chargeCode'+inc).value="";
			return false;
		}
	}
	document.getElementById('chargeCodeName' + inc).title=strValue;
	return true;
}

function validateBpWithSlash(strValue) {
	if (strValue != "") {
		var objRegExp = "/^(\d{1,}[\/]\d*)$/";
		obj = objRegExp.test(strValue);
		if (!obj) {
			alert("BP is not having Valid Value.");
			return false;
		}
		return true;
	}
}

function validateTemp(strValue) {
	var objRegExp = /^((\+|-)\d)?\d*(\.\d{2})?$/;
	return objRegExp.test(strValue);
}

/*
 * written code by rajendra kumar : 29-04-2015 :add remove row of allegy grid
 * START
 */
function removeRowForAllergy() {
	var tbl = document.getElementById('alergyGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('allergyCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 0; i <= iteration; i++) {
		if (document.getElementById("allergyRadio" + i) != null
				&& (typeof document.getElementById("allergyRadio" + i).checked) != 'undefined'
				&& document.getElementById("allergyRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("allergyRadio" + i) != null
					&& (typeof document.getElementById("allergyRadio" + i).checked) != 'undefined'
					&& document.getElementById("allergyRadio" + i).checked) {
				var deleteRow = document.getElementById("allergyRadio" + i).parentNode.parentNode;
				document.getElementById("allergyRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeForComorbidity() {
	var tbl = document.getElementById('comorbidityGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('comorbidityCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("comorbidityRadio" + i) != null
				&& (typeof document.getElementById("comorbidityRadio" + i).checked) != 'undefined'
				&& document.getElementById("comorbidityRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("comorbidityRadio" + i) != null
					&& (typeof document.getElementById("comorbidityRadio" + i).checked) != 'undefined'
					&& document.getElementById("comorbidityRadio" + i).checked) {
				var deleteRow = document.getElementById("comorbidityRadio" + i).parentNode.parentNode;
				document.getElementById("comorbidityRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowForAllergy() {
	var tbl = document.getElementById('alergyGrid');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('allergyCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'allergyRadio' + iteration;
	e1.id = 'allergyRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'allergyDetailId' + iteration;
	e1.id = 'allergyDetailId' + iteration;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'allergyType' + iteration;
	e1.id = 'allergyType' + iteration;
	e1.style.background = "#FFFF99";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < allergyTypeArray.length; i++) {
		e1.options[i + 1] = new Option(allergyTypeArray[i][1],
				allergyTypeArray[i][0]);
	}

	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'allergyName' + iteration;
	e1.id = 'allergyName' + iteration;
	e1.className = "largTextBoxOpd textYellow historyAutoComplete ui-autocomplete-input";
	e1.maxLength = "60";
	e1.size = '20'
	cellRight1.appendChild(e1);
	/*
	 * var newdiv = document.createElement('div'); newdiv.setAttribute('id',
	 * 'allergy_ac2updates'+iteration); newdiv.style.display = 'none';
	 * newdiv.className = "autocomplete textYellow";
	 * cellRight1.appendChild(newdiv); new
	 * Ajax.Autocompleter('allergyName'+iteration,'allergy_ac2updates'+iteration,'opd?method=getItemListForAutoCompleteItemAllergy',{minChars:3,
	 * callback: function(element, entry) { return entry + '&allergyTypeCheck=' +
	 * document.getElementById('allergyType'+iteration).value;
	 * },parameters:'requiredField=allergyName'+iteration});
	 */

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('Select');
	e1.name = 'allergyseverity' + iteration;
	e1.id = 'allergyseverity' + iteration;
	e1.style.background = "#FFFF99";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < saverityCodeArray.length; i++) {
		e1.options[i + 1] = new Option(saverityCodeArray[i][1],
				saverityCodeArray[i][0]);
	}
	cellRight1.appendChild(e1);
	
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'allergyyear' + iteration;
	e1.id = 'allergyyear' + iteration;
	e1.size = '20';
	e1.maxLength = "2";
	e1.validate = "Allergy Year,int,no";
	e1.className = 'small textYellow';
	cellRight1.appendChild(e1);
	

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'allergymonth' + iteration;
	e1.id = 'allergymonth' + iteration;
	e1.size = '20';
	e1.maxLength = "2";
	e1.validate = "Allergy Month,int,no";
	e1.className = "small textYellow";
	cellRight1.appendChild(e1);
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.onchange = function(){monthValidation(this.value,this.id);};
	cellRight1.appendChild(e1);

	

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('Select');
	e1.name = 'allergystatus' + iteration;
	e1.id = 'allergystatus' + iteration;
	e1.style.background = "#FFFF99";
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Active', '1');
	e1.options[2] = new Option('Inactive', '2');
	cellRight1.appendChild(e1);
}

/*
 * written code by rajendra kumar : 29-04-2015 :add remove row of allegy grid
 * END
 */
function addRow() {
	var tbl = document.getElementById('grid');
	var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex').value) + 1;
	document.getElementById('hdbTabIndex').value = hdbTabIndex;

	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	e1.onchange = function() {
		checkPrescriptionCheck(iteration);
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
	e1.name = 'nomenclature' + iteration;
	e1.id = 'nomenclature' + iteration;
	e1.className = "textYellow largTextBoxOpd";
	e1.onfocus = function() {
		// Commented by Arbind on 31-01-2017
		// checkEnteredDiagnosis();
		checkFrequency(iteration, "opc");
	}
	e1.onkeypress = function() {
		checkTextColor('nomenclature' + iteration);
	};
	e1.onblur = function() {
		checkForAlreadyIssuedPrescribtion(this.value, iteration);
		populatePVMS(this.value, iteration);
		checkItem(iteration);
		copyToPrescriptionTAb(iteration, 'opconsult');
		ValidateCantra();
		displayAu(this.value, iteration);
		validatePrescriptionAutocomplete('opmain', this.value, iteration);
		checkForAllergy(this.value, iteration);
		checkForBlockedMedicine(this.value, iteration);

	};
	e1.size = '35';
	e1.tabIndex = hdbTabIndex + "2";
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
	e1.name = 'actualDispensingQty' + iteration;
	e1.id = 'actualDispensingQty' + iteration;
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
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'alreadyPres' + iteration;
	e1.id = 'alreadyPres' + iteration;
	e1.value = 'N';
	cellRight1.appendChild(e1);
	/*
	 * var cellRight1 = row.insertCell(2); var e1 =
	 * document.createElement('input'); e1.name='route'+iteration;
	 * e1.id='route'+iteration; e1.className="textYellow opdgridText";
	 * e1.onblur=function() { fillRouteOnTAb(iteration);};
	 * cellRight1.appendChild(e1);
	 * 
	 * var e1 = document.createElement('input'); e1.type = 'hidden';
	 * e1.name='routeHidden'+iteration; e1.id='routeHidden'+iteration;
	 * e1.className="textYellow opdgridText"; cellRight1.appendChild(e1);
	 * 
	 * var newdiv = document.createElement('div'); newdiv.setAttribute('id',
	 * 'ac2updatesRoute'+iteration); newdiv.style.display = 'none';
	 * newdiv.className = "autocomplete"; cellRight1.appendChild(newdiv); new
	 * Ajax.Autocompleter('route'+iteration,'ac2updatesRoute'+iteration,'opd?method=getRouteAutoList',{minChars:1,parameters:'requiredField=route'+iteration,afterUpdateElement :
	 * changeTest});
	 */
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'route' + iteration;
	e1.id = 'route' + iteration;
	e1.style.width = "90px";
	e1.style.background = "#FFFF99";
	e1.tabIndex = hdbTabIndex + "3";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < routeArray.length; i++) {
		e1.options[i + 1] = new Option(routeArray[i][1], routeArray[i][0]);
	}
	e1.onblur = function() {
		fillRouteOnTAb(iteration);
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.name = 'dosage' + iteration;
	e1.id = 'dosage' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.style.width="75px";
	e1.maxlength='8';
	e1.onblur = function() {
		fillValue(this.value, iteration);
		checkFrequencyForTaperedDrugs(iteration);
	};
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'unit' + iteration;
	e1.id = 'unit' + iteration;
	e1.className = 'textYellow opdTextBoxTSmall';
	e1.style.width="46px";
	e1.readOnly = 'readOnly';
	e1.tabIndex = hdbTabIndex + "5";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.name = 'frequency' + iteration;
	e1.id = 'frequency' + iteration;
	e1.style.width = "90px";
	e1.style.background = "#FFFF99";
	e1.tabIndex = hdbTabIndex + "6";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < icdArray.length; i++) {
		// this part is added by amit das
		var opt = document.createElement('option');
		opt.id = icdArray[i][2];
		opt.value = icdArray[i][0];
		opt.innerHTML = icdArray[i][1];
		e1.appendChild(opt);
		// e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]); //
		// this part is commented by amit das
	}
	e1.onblur = function() {
		getFrequencyValue(this.value, iteration);
		fillValue(this.value, iteration);
		displaySOSQty(this.value, iteration);
		checkFrequencyForTaperedDrugs(iteration);
	};

	e1.onchange = function() { // added by amit das
		displaFrequencyType(this, iteration);
	};

	cellRight1.appendChild(e1);

	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'sosQty' + iteration;
	e21.id = 'sosQty' + iteration;
	e21.size = '5';
	e21.setAttribute('tabindex', '1');
	cellRight1.appendChild(e21);

	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'frequencyValue' + iteration;
	e21.id = 'frequencyValue' + iteration;
	e21.size = '5';
	e21.setAttribute('tabindex', '1');
	cellRight1.appendChild(e21);

	var cellRight1 = row.insertCell(6);

	var e21Div = document.createElement('div');
	e21Div.style = 'width:100px; float: left;';

	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'noOfDays' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";	
	e1.id = 'noOfDays' + iteration;
	e1.size = '3';
	e1.tabIndex = hdbTabIndex + "7";
	e1.onblur = function() {
		fillValueDays(iteration);
		fillValue(this.value, iteration);
	};
	e21Div.appendChild(e1);

	var ef21 = document.createElement('p');
	ef21.style = 'line-height:0px;';
	ef21.id = 'frequencyType' + iteration;
	e21Div.appendChild(ef21);
	cellRight1.appendChild(e21Div);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('Select');
	e1.name = 'instrunction' + iteration;
	e1.id = 'instrunction' + iteration;
	e1.style.width = "90px";
	e1.style.background = "#FFFF99";
	e1.tabIndex = hdbTabIndex + "8";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < instructionArray.length; i++) {
		e1.options[i + 1] = new Option(instructionArray[i][1],
				instructionArray[i][0]);
	}
	e1.onblur = function() {
		fillInstrunctionOnTAb(iteration);
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'splInstrunction' + iteration;
	e1.id = 'splInstrunction' + iteration;
	e1.tabIndex = hdbTabIndex + "9";
	e1.className = "textYellow opdTextBoxSmall";
	e1.style.width="135px";
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

	/*var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'unitLable' + iteration;
	e1.id = 'unitLable' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.style.width="136px";
	e1.readOnly = 'readOnly';
	e1.size = '5';
	cellRight1.appendChild(e1);*/

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
		/*
		 * else if(lastRow==2 || lastRow==(totalSelected+1)) { alert('You can
		 * not delete all Row.'); } else if (lastRow > 2){
		 */
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("itemRadio" + i) != null
					&& (typeof document.getElementById("itemRadio" + i).checked) != 'undefined'
					&& document.getElementById("itemRadio" + i).checked) {
				// added by govind on 15-9-2016
				/*
				 * if (document.getElementById("treatTemplteId" + i) != null) {
				 * var tempId = document
				 * .getElementById('tempLatePrescription').value; var
				 * tempTreatId = document.getElementById("treatTemplteId" +
				 * i).value; added by govind on 4-10-2016
				 * submitProtoAjaxNew('opdMain',
				 * 'opd?method=deletePrescriptionTamplate&templTreateId=' +
				 * tempTreatId + '&templateId=' + tempId, 'divTemplet1'); //
				 * added by govind on 4-10-2016 end
				 * fnGetPrescriptionTemplate(tempId);
				 * document.getElementById('tempLatePrescription').value = 0; }
				 */
				// added by govind on 15-9-2016
				var deleteRow = document.getElementById("itemRadio" + i).parentNode.parentNode;
				document.getElementById("itemRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
		// }
		removeRowPrescriptionTab('opc');
	}
	setDisablePharmacy();
}

function removeRowPrescriptionTab(from) {
	setDisablePharmacy();
	var tbl = document.getElementById('prescriptionTabGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('pTabhdb');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;

	if (from != 'opc' ? confirm("Do you want to delete !") : true) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("itemRadiopTab" + i) != null
					&& (typeof document.getElementById("itemRadiopTab" + i).checked) != 'undefined'
					&& document.getElementById("itemRadiopTab" + i).checked) {
				totalSelected = totalSelected + 1;
			}
		}

		if (totalSelected == 0) {
			if (from != 'opc')
				alert('Please select atleast 1 row to delete');
		}
		/*
		 * else if(lastRow==2 || lastRow==(totalSelected+1)) { alert('You can
		 * not delete all Row.'); } else if (lastRow > 2){
		 */
		var flag = 0;
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("itemRadiopTab" + i) != null
					&& (typeof document.getElementById("itemRadiopTab" + i).checked) != 'undefined'
					&& document.getElementById("itemRadiopTab" + i).checked) {
				jQuery(function($) {
					if (document.getElementById("parkPrescriptionIds" + i) != null) {
						var ids = document.getElementById("parkPrescriptionIds"
								+ i).value;
						if (ids != "" && ids != "0") {
							$.post('opd?method=deleteOPDdetails&ids=' + ids
									+ "&for=" + "prc" + "&" + csrfTokenName
									+ "=" + csrfTokenValue, function(data) {
								try {
									flag = 1;
									msgFlag = data;
								} catch (e) {
									alert(e);
								}
							});
						}
					}
				});

				var deleteRow = document.getElementById("itemRadiopTab" + i).parentNode.parentNode;
				document.getElementById("itemRadiopTab" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
	// }
}

function display(obj, val, type) {
	var splName = document.getElementById("splName").value;
	 //alert("splName==="+splName);
	 //alert("val==="+val);
	if (val == 'Nicu Case Record') {
		var patientAge = document.getElementById("patientAge").value;
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;

		if (splName == '' || splName != val) {
			document.getElementById("splName").value ="Nicu Case Record";
			if (parseInt(patientAge) > 18) {
				alert("More than 18 Years Patient not allowed for Paediatrics Template.");
			} else {
				submitProtoAjaxNew('opdMain',
						'/hms/hms/opd?method=showNicuCaseRecordJsp&hinId='
								+ hinId + '&visitId=' + visitId,
						'specialityDiv');
			}
		}
	} else if (val == 'Deaddiction Center') {
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Deaddiction Center";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showDeaddictionCentreJsp',
					'specialityDiv');
	 }
	} else if (val == 'ENT Examination') {
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="ENT Examination";
			//alert("visitId===="+document.getElementById("visitId").value);
			var visitId = document.getElementById("visitId").value;
			var hinId = document.getElementById("hinId").value;
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showENTExaminationJsp&visitId=' + visitId+'&hinId='+hinId,'specialityDiv');
		}

	} else if (val == 'Leprosy Proforma') {
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		var patientAge = document.getElementById("patientAge").value;
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Leprosy Proforma";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showDermatologyLeprosyProformaJsp&hinId=' + hinId
					+ '&visitId=' + visitId + '&patientAge='+patientAge, 'specialityDiv');
		}
	} else if (val == 'General Proforma') {
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		var patientAge = document.getElementById("patientAge").value;
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="General Proforma";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showDermatologyGeneralProformaJsp&hinId=' + hinId
					+ '&visitId=' + visitId + '&patientAge='+patientAge,'specialityDiv');
		}

 	} else if (val == 'Psychogeriatric Clinic') {
		if (splName == '' || splName != val){
			var hinId = document.getElementById("hinId").value;
			document.getElementById("splName").value ="Psychogeriatric Clinic";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showPsychogeriatricClinicJsp&hinId=' + hinId,
					'specialityDiv');
		}

	} else if (val == 'Medicine') {
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Medicine";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showMedicineTempleJsp&hinId=' + hinId
							+ '&visitId=' + visitId, 'specialityDiv');
		}
	} else if (val == 'Orthopedic') {
		if (splName == '' || splName != val) {
			var hinId = document.getElementById("hinId").value;
			var visitId = document.getElementById("visitId").value;
			document.getElementById("splName").value = "Orthopedic";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showOrthopedicJsp&hinId=' + hinId
							+ '&visitId=' + visitId, 'specialityDiv');
		}
	} else if (val == 'Orthopedic Summary') { //Added by Arbind on 01-01-2018
		if (splName == '' || splName != val) {
			var hinId = document.getElementById("hinId").value;
			document.getElementById("splName").value = "Orthopedic";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showOrthopedicJsp&hinId=' + hinId
							+ '&Summary=Summary', 'specialitySummaryDiv');
		}
	}else if (val == 'Dermatology Summary') { //Added by swarup on 04-01-2018
		if (splName == '' || splName != val) {
			var hinId = document.getElementById("hinId").value;
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showDermatologySpecialitySummaryJsp&hinId=' + hinId
							+ '&Summary=Summary', 'specialitySummaryDiv');
		}
	}

	/* added by swarup 13/11/2017-begin */
	else if (val == 'Audiological Examination') {
		if (splName == '' || splName != val) {
			var hinId = document.getElementById("hinId").value;
			var visitId = document.getElementById("visitId").value;
			document.getElementById("splName").value = "Audiological Examination";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showAudiologicalExaminationJsp&hinId='
							+ hinId + '&visitId=' + visitId, 'specialityDiv');
		}

	}
	
	/* added by abhishek 24/11/2017-begin */
	else if (val == 'Nephrology Case Sheet') {
			var hinId = document.getElementById("hinId").value;
			var visitId = document.getElementById("visitId").value;
			if (splName == '' || splName != val) 
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showNephrologyCaseSheetJsp&hinId='
							+ hinId + '&visitId=' + visitId, 'specialityDiv');
		}

	/* added by swarup 01-11-2017*/
	else if (val == 'Family Planning') {
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val) 
		submitProtoAjaxNew('opdMain',
				'/hms/hms/opd?method=showFamilyPlanningGynecologyJsp&hinId='
						+ hinId + '&visitId=' + visitId, 'specialityDiv');
	}
	/*Added for Hemo Dialysis*/
	else if (val == 'Hemo Dialysis') {
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val) 
		submitProtoAjaxNew('opdMain',
				'/hms/hms/opd?method=showHemoDialysis&hinId='
						+ hinId + '&visitId=' + visitId, 'specialityDiv');
	}
	/*end*/
	else if (val == 'General Surgery') {
		if (splName == '' || splName != val)
			{
			document.getElementById("splName").value = "General Surgery";
			if (type == 'OP') {
			
				var hinId = document.getElementById("hinId").value;
				
						submitProtoAjaxNew(
						'opdMain',
						'/hms/hms/ipd?method=showGeneralSurgrySpecialityTemplateJsp&hinId='+hinId,
						'specialityDiv');
			}else{
				var inpatientId=document.getElementById('inpatientId').value;
				submitProtoAjaxNew(
						'ipdCaseSheet',
						'/hms/hms/ipd?method=showGeneralSurgrySpecialityTemplateJsp&inpatientId='+inpatientId,
						'specialityDiv');	
			}
			}
			
	} else if (val == 'Respiratory Clinic') {
		var hinId = document.getElementById("hinId").value;
		var patientAge = document.getElementById("patientAge").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val) {
			if (parseInt(patientAge) > 18) {
				alert("More than 18 Years Patient not allowed for Paediatrics Template.");
			} else {
				submitProtoAjaxNew('opdMain',
						'/hms/hms/opd?method=showRespiratoryClinicJsp&hinId='
								+ hinId + '&visitId=' + visitId,
						'specialityDiv');
			}
		}
	} else if (val == 'Neonatal Case Record Sheet') {
		var inpatientId = document.getElementById("inpatientId").value;
		var hinId = document.getElementById("hinId").value;
		var patientAge = document.getElementById("patientAge").value;

		var motherHinNo = document.getElementById("motherHinNo").value;
		if (splName == '' || splName != val) {
			if (parseInt(patientAge) > 18) {
				alert("More than 18 Years Patient not allowed for Paediatrics Template.");
			} else {
				submitProtoAjaxNew('ipdCaseSheet',
						'/hms/hms/ipd?method=showNeonatalSpecialityScreenJsp&inpatientId='
								+ inpatientId + '&motherHinNo=' + motherHinNo
								+ '&hinId=' + hinId, 'specialityDiv');
			}
		}
	}
	// Added by Arbind on 18-04-2017
	else if (val == 'Antenatal Card') {
		var visitId = document.getElementById("visitId").value;
		var hinId = document.getElementById("hinId").value
		var gender = document.getElementById("gender").value;
		if (splName == '' || splName != val) {
			if (gender == 'Female') {
				// openPopupForAntenatal('opd?method=showAntenatalCardJsp2&visitId='
				// + visitId);
				if (type == 'OP') {
					document.getElementById("splName").value ="Antenatal Card";
					submitProtoAjaxNew('opdMain',
							'/hms/hms/opd?method=showAntenatalCardJsp2&visitId='
									+ visitId + '&hinId=' + hinId,
							'specialityDiv');
				} else {
					submitProtoAjaxNew('ipdCaseSheet',
							'/hms/hms/opd?method=showAntenatalCardJsp2&visitId='
									+ visitId + '&hinId=' + hinId,
							'specialityDiv');
				}
			} else {
				alert("Antenatal Card Template allow for Female Patient.");
			}
		}
	} else if (val == 'Infertility Clinic') {
		var visitId = document.getElementById("visitId").value;
		var hinId = document.getElementById("hinId").value;
		var gender = document.getElementById("gender").value;
		if (splName == '' || splName != val)
			if (gender == 'Female') {
				// openPopupForAntenatal('opd?method=showOBGONEJsp&visitId=' +
				// visitId);
				submitProtoAjaxNew('opdMain',
						'/hms/hms/opd?method=showInfertilityClinic&visitId='
								+ visitId + '&hinId=' + hinId, 'specialityDiv');
			} else {
				alert("Infertility Clinic Template allow for Female Patient.");
			}
	} else if (val == 'Oral Medicine') {
		var visitId = document.getElementById("visitId").value;
		// var hinId = document.getElementById("hinId").value;
		if (splName == '' || splName != val)
			// submitProtoAjaxNew('opdMain','/hms/hms/opd?method=showInfertilityClinic&visitId='+
			// visitId+'&hinId='+ hinId,'specialityDiv');
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showOralMedicine', 'specialityDiv');
	} else if (val == 'Pre Assessment Clinic') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showPreAssessmentClinic',
					'specialityDiv');
	} else if (val == 'Maxillofacial Trauma - Proforma') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showMaxillofacialTraumaProforma',
					'specialityDiv');

	} else if (val == 'Case Record Periodontics') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showCaseRecordOfPeriodontics',
					'specialityDiv');

	} else if (val == 'Oral and Maxillofacial Surgery') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showOralAndMaxillofacialSurgery',
					'specialityDiv');

	} else if (val == 'Implant Planning') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showImplantPlanning', 'specialityDiv');

	} else if (val == 'Removable Partial Prosthodontics') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showRemovablePartialProsthodontics',
					'specialityDiv');

	}

	else if (val == 'Fixed Prosthodontics') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showFixedProsthodontics',
					'specialityDiv');

	} else if (val == 'Endodontics') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showEndodontics', 'specialityDiv');

	} else if (val == 'Diagnostic Record Prosthodontics') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showDiagnosticRecordProsthodontics',
					'specialityDiv');

	} else if (val == 'Maxillofacial Prosthesis') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showMaxillofacialProsthesis',
					'specialityDiv');

	} else if (val == 'Oral Medicine Pathology') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showOralMedicinePathology',
					'specialityDiv');

	} 
	
	 else if (val == 'Gynecology Case Sheet') {
			if (splName == '' || splName != val)
				submitProtoAjaxNew('opdMain',
						'/hms/hms/opd?method=showGynecologyCaseSheetJsp',
						'specialityDiv');
		}
	
	 else if (val == 'General Adult Psychiatry Case Record') {
			if (splName == '' || splName != val)
				submitProtoAjaxNew('opdMain',
						'/hms/hms/opd?method=showGeneralPsychiatricCaseRecord',
						'specialityDiv');
		}
	else if (val == 'Community Oral Health') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showCommunityOralHealthCaseHistory',
					'specialityDiv');
	} else if (val == 'PG CASE RECORD - Orthodontics') {

		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showPgCaseRecordOrthodontics',
					'specialityDiv');

	}

	else if (val == 'Pedodontics Vital Statistics') {
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showPedodonticsVitalStatistics',
					'specialityDiv');

	} else if (val == 'Contact Lens') {
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val)
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showContactLensTempleJsp&hinId='
							+ hinId + '&visitId=' + visitId, 'specialityDiv');
	}  else if (val == 'Phototherapy Proforma') { //Added by Arbind on 29-11-2017
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Phototherapy Proforma";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showPhototherapyProforma&hinId='
					+ hinId + '&visitId=' + visitId+'&tempLateName='+val, 'specialityDiv');
		}
	}else if (val == 'History') {
		var hinNo = document.getElementById("hinNo").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Medicine";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/enquiry?method=showPatientDetails&hinNo=' + hinNo
							+ '&visitId=' + visitId, 'historyDiv');
		}
	}
	else if (val == 'UploadDocument') {
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Medicine";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=openUploadPopWindow&hinId=' + hinId
							+ '&visitId=' + visitId, 'uploadDocumentDiv');
		}
	}
	
	else if (val == 'ResultEntry') {
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Medicine";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/investigation?method=showPendingResultEntryTemplateOPD&hinId=' + hinId
					 + "&RequisitionFrom=OPD&" + '&visitId=' + visitId, 'ResultEntryDiv');
		}
	}
	
	else if (val == 'Allergy') {
		var hinNo = document.getElementById("hinNo").value;
		var requestId = document.getElementById("requestId").value.trim();
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Medicine";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/ot?method=showAllergy&requestId=' + requestId
						+'&LP=y'	+ '&visitId=' + visitId, 'AllergyDiv');
		}
	}
	
	else if (val == 'NCDClinic') {
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Medicine";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showNCDPattern&hinId=' + hinId	+ "&" + csrfTokenName + "=" + csrfTokenValue+ '&visitId=' + visitId, 'NCDClinicDiv');
		}
	}
	
	else if (val == 'RNTCPDetail') {
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Medicine";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showRNTCPDetail&hinId=' + hinId	+ "&" + csrfTokenName + "=" + csrfTokenValue+ '&visitId=' + visitId, 'RNTCPDetailDiv');
		}
	}
	
	else if (val == 'FPISDetail') {
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Medicine";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=showFpisRecord&hinId=' + hinId	+ "&" + csrfTokenName + "=" + csrfTokenValue, 'FPISDetailDiv');
		}
	}
	
	else if (val == 'LabResult') {
		var OrderId = document.getElementById("OrderId").value;
		var visitId = document.getElementById("visitId").value;
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Medicine";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/investigation?method=printResultValidationLab&parent=' + OrderId
							+ '&visitId=' + visitId, 'LabResultDiv');
		}
	}
	
	else if (val == 'listOfParkedPatient') {
		if (splName == '' || splName != val){
			document.getElementById("splName").value ="Medicine";
			submitProtoAjaxNew('opdMain',
					'/hms/hms/opd?method=getOPClinicalWaitingLists&flag=p', 'listOfParkedPatientDiv');
		}
	}
	
	else {
		if (splName == '' || splName != val) {
			if (document.getElementById('inpatientId') != null) {
				submitProtoAjaxNew('ipdCaseSheet',
						'/hms/hms/opd?method=getGroupAndParameterValues&tempLate='
								+ obj + '&tempLateName=' + val, 'specialityDiv');

			} else {
				if (val == 'Neonatology Unit'
						|| val == 'Paediatric Case Record') {
					var patientAge = document.getElementById("patientAge").value;
					var hinId = document.getElementById("hinId").value;
					if (parseInt(patientAge) > 18) {
						alert("More than 18 Years Patient not allowed for Paediatrics Template.");
					} else {
						submitProtoAjaxNew('opdMain',
								'/hms/hms/opd?method=getGroupAndParameterValues&tempLate='
										+ obj + '&tempLateName=' + val
										+ '&hinId=' + hinId, 'specialityDiv');
					}
				} else {
					if (splName == '' || splName != val){
					//alert(val);
					var hinId = document.getElementById("hinId").value;
					var visitId = document.getElementById("visitId").value;
					document.getElementById("splName").value = val;
					submitProtoAjaxNew('opdMain',
							'/hms/hms/opd?method=getGroupAndParameterValues&tempLate='+ obj + '&tempLateName=' + val+'&hinId='+hinId+'&visitId='+visitId,
							'specialityDiv');
					}

				}
			}

		}
		/*
		 * if (splName == '' || splName != val) { submitProtoAjaxNew('opdMain',
		 * '/hms/hms/opd?method=getGroupAndParameterValues&tempLate='+
		 * obj+'&tempLateName='+ val, 'specialityDiv');
		 *  }
		 */
	}
}

var setAlert = 0;
function fnGetPrescriptionTemplate(tempId,opdType) {
	
	
	var result = "";
	var icount = 0;	
	for (var i = 0; i < tempId.options.length; i++) {
		opt = tempId.options[i];
		if (opt.selected) {
			result += opt.value + ",";
			icount++;
		}
	}
	if(icount >=2 && setAlert == 0) {
		alert("Note : You have selected more than one prescription templates");
		setAlert = 1;
	}
	
	var len = document.getElementById("grid").rows.length;

	for (i = len - 1; i > 0; i--) {
		if (document.getElementById("nomenclature" + (i - 1)) != null
				&& document.getElementById("nomenclature" + (i - 1)).value == '')
			var tbl = document.getElementById("grid").deleteRow(i);
	}
	var updatedLen = document.getElementById("grid").rows.length;

	var tablen = 0;
	if(document.getElementById("prescriptionTabGrid"))
	tablen = document.getElementById("prescriptionTabGrid").rows.length;
	
	for (i = tablen - 1; i > 0; i--) {
		if (document.getElementById("nomenclaturepTab" + (i - 1)) != null
				&& document.getElementById("nomenclaturepTab" + (i - 1)).value == '')
			var tabtbl = document.getElementById("prescriptionTabGrid")
					.deleteRow(i);
	}
	
	var updatedTabLen = 0;
	if(document.getElementById("prescriptionTabGrid"))
		updatedTabLen = document.getElementById("prescriptionTabGrid").rows.length;

	var visitId = document.getElementById("visitId").value;
	var hinId = document.getElementById("hinId").value;

	if (tempId.value != -1) {
		submitProtoAjaxNew('opdMain',
				"/hms/hms/opd?method=getPrescriptionTemplateOP&templateId="
						+ result + "&updatedLen=" + updatedLen + "&hinId="
						+ hinId + "&visitId=" + visitId+ "&opdType=" +opdType, 'divTemplet1');
		submitProtoAjaxNew('opdMain',
				"/hms/hms/opd?method=getPrescriptionTemplateTab&templateId="
						+ result + "&updatedLen=" + updatedTabLen + "&hinId="
						+ hinId + "&visitId=" + visitId, 'divTemplet2');
	}

	setDisablePharmacy();
}

/** ************************************* */
function changeDiagnosisStaus(status) {
	if (status == 1) {
		document.getElementById("diagnosis_status_p1").checked = true;
		document.getElementById("diagnosis_status_p2").checked = true;
	} else if (status == 2) {
		document.getElementById("diagnosis_status_f1").checked = true;
		document.getElementById("diagnosis_status_f2").checked = true;
	}
}

function fnShowHideMLCTab() {
	if (document.getElementById("mlcCheck").checked)
		document.getElementById("mlcTab").style.display = 'block';
	else
		document.getElementById("mlcTab").style.display = 'none';
}

function fnGetDistrictHospital() {
	var hospitalTypeId = document.getElementById('referHospitalType').value;
	var districtId = document.getElementById('referdistrict').value;
	if (districtId != 0 && hospitalTypeId != 0) {
		new Ajax.Request(
				'opd?method=getDistrictHospital&districtId=' + districtId
						+ '&hospitalTypeId=' + hospitalTypeId + '&'
						+ csrfTokenName + '=' + csrfTokenValue,
				{
					onSuccess : function(response) {
						if (response.responseText.trim() != '') {
							document.getElementById('referhospital').innerHTML = response.responseText
									.trim();
						}
					}
				});
	}
}
// deptId added by Arbind on 15-03-2017
function fnGetHospitalDepartment(hospitalId, referType, deptId) {
	// var referInternal = document.getElementById('referInternal').value;
	// var referExternal = document.getElementById('referExternal').value;

	new Ajax.Request(
			'opd?method=getHospitalDepartment&hospitalId=' + hospitalId
					+ '&referType=' + referType + '&deptId=' + deptId + '&'
					+ csrfTokenName + '=' + csrfTokenValue,
			{
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						document.getElementById('referdepartment').innerHTML = response.responseText
								.trim();
					}
				}
			});
}

function checkVal(val) {
	if (parseInt(val) > 299) {
		alert("Pulse should be less than 300");
		document.getElementById('pulse').focus;
	}
}
function showDiagnosis(csrf) {
	var msg = "Decision making is finally according to the judgment of the treating doctor";
	if (confirm(msg)) {
		var url = "/hms/hms/opd?method=showDiagnosisPopUp&" + csrf + "&"
				+ csrfTokenName + "=" + csrfTokenValue;
		;
		newwindow = window
				.open(url, 'Diagnosis',
						"left=0,top=0,height=700,width=1010,status=1,scrollbars=1,resizable=1");
	}

}

function validateFieldValues(from) {
	var dateSelected;
	var tab;
	
	if(document.getElementById("reviewDate"))
		dateSelected = document.getElementById("reviewDate").value;
	
	if(document.getElementById("tab"))
		tab = document.getElementById("tab").value;

	if (from == 'n') {
		if (confirm("Do you want to skip this patient!")) {
			if(check)
			submitForm('opdMain',
					'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1&skip=1');
		}
		return false;
	} else {
		/*
		 * if (document.getElementById('diagnosisId').length == 0 &&
		 * document.getElementById('OtherDiagnosis').value.trim().length == 0) {
		 * alert("Please Enter the diagnosis of the Patient.");
		 * document.getElementById("snomed").focus(); if (from != 's' && from !=
		 * 'p') { if (confirm("Do you want to skip this patient!")) {
		 * submitForm('opdMain',
		 * 'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1&skip=1'); } }
		 * return false; }
		 */
		if (from == 'nextlite') {
			if (confirm("Do you want to skip this patient!")) {
				if(check)
				submitForm('opdMain',
						'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1&skip=1&forms=oplite');

				return false;
			}
		}else if (from == 'nextdetail'){
			if (confirm("Do you want to skip this patient!")) {
				if(check)
				submitForm('opdMain',
						'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1&skip=1&forms=opdetail');

				return false;
			}
		}
		
		
		
		if (from != 's' && from != 'p' && from != 'secondop') {
			if (confirm("Do you want to skip this patient!")) {
				if(check)
				submitForm('opdMain',
						'opd?method=submitOPDPatientDetails&flag=opd&submitFrom=2&from=1&skip=1');
			}
		}
		return true;// commented and added by govind 31-01-2017
	}

	if (dateSelected != "") {
		var visitDate = new Date(dateSelected.substring(6), (dateSelected
				.substring(3, 5) - 1), dateSelected.substring(0, 2))
		var currentDate = new Date(serverdate.substring(6), (serverdate
				.substring(3, 5) - 1), serverdate.substring(0, 2))
		if (visitDate < currentDate) {
			document.getElementById("reviewDate").value = document
					.createElement('consultationDate').value;
			alert("Please enter the correct Visit date.")
			return false;
		}
	}

	var systolic = document.getElementById("systolic").value;
	var diastolic = document.getElementById("diastolic").value;
	if (diastolic != null && diastolic != ''
			&& (systolic == null || systolic == '')) {
		alert('please fill systolic');
		return false;
	} else if (systolic != null && systolic != ''
			&& (diastolic == null || diastolic == '')) {
		alert('please fill diastolic');
		return false;
	}
	// code for chaecking investigation requistion grid
	var tbl = document.getElementById('grid');
	var ptbl = document.getElementById('prescriptionTabGrid');
	var lastRow = parseInt(tbl.rows.length);
	var plastRow = parseInt(ptbl.rows.length);
	var nomenclature = "";
	var pnomenclature = "";
	if (tab == 1) {
		for (var i = 1; i < lastRow; i++) {
			if (document.getElementById("dosage" + i).value == "") {
				alert("Please fill dosage in row " + i + " On Consultaion")
				return false;
			}
			if (document.getElementById("frequency" + i).value == "0") {
				alert("Please select frequency in row " + i + " On Consultaion")
				return false;
			}
			if (document.getElementById("noOfDays" + i).value == "") {
				alert("Please fill noOfDays in row " + i + " On Consultaion")
				return false;
			}
			if (document.getElementById("instrunction" + i).value == "") {
				alert("Please fill instrunction in row " + i
						+ " On Consultaion")
				return false;
			}
		}
	} else if (tab == 2) {
		for (var i = 1; i < plastRow; i++) {
			if (document.getElementById("dosagepTab" + i).value == "") {
				alert("Please fill dosage in row " + i + " On Prescription")
				return false;
			}
			if (document.getElementById("frequencypTab" + i).value == "0") {
				alert("Please select frequency in row " + i
						+ " On Prescription")
				return false;
			}
			if (document.getElementById("noOfDayspTab" + i).value == "") {
				alert("Please fill noOfDays in row " + i + " On Prescription")
				return false;
			}
			if (document.getElementById("instrunctionpTab" + i).value == "") {
				alert("Please fill instrunction in row " + i
						+ " On Prescription")
				return false;
			}
		}
	}
	if (document.getElementById('mlscasetype').length != 0) {
		var x = document.getElementById("mlscasetype");
		var val = "";
		for (var i = 0; i < x.options.length; i++) {
			if (x.options[i].selected == true) {
				val = x.options[i].value;
				// alert(val);
				// alert(val.contains('postmortem'));
				if (val.indexOf("postmortem") > -1) {
					if (document.getElementById('patient_expire').checked == false) {
						alert("Please check Patient is dead as you are referring for postmortem examination.");
						return false;
					}
				}
			}
		}
	}
	return true;
}

function fnGetDoctorDepartment(departmentId) {
	var hospitalId = 0;
		if(document.getElementById('referExternal').checked)
			hospitalId=	document.getElementById('referhospital').value;
		else
			hospitalId =document.getElementById('hospitalId').value;
	new Ajax.Request(
			'opd?method=getDoctorDepartment&departmentId=' + departmentId
					+ '&hospitalId=' + hospitalId + '&' + csrfTokenName + '='
					+ csrfTokenValue,
			{
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						document.getElementById('refereddoctor').innerHTML = response.responseText
								.trim();
					}
				}
			});
}

function fnGetDoctorDepartmentForNursing(departmentId) {

	var hospitalId = document.getElementById('hospitalId').value;
	new Ajax.Request(
			'opd?method=getDoctorDepartment&departmentId=' + departmentId
					+ '&hospitalId=' + hospitalId + '&' + csrfTokenName + '='
					+ csrfTokenValue,
			{
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						document.getElementById('refereddoctor').innerHTML = response.responseText
								.trim();
					}
				}
			});
}

function checkTab(tab) {
	document.getElementById("tab").value = tab;
}

function validateFieldaddrow() {

	var tbl = document.getElementById('grid');
	var lastRow = tbl.rows.length;
	lastRow = parseInt(lastRow) - 1;
	if (document.getElementById("brandId" + lastRow).value == "") {
		alert("Please Select The Brand Name " + lastRow);
		return false;
	} else {
		// document.getElementById("brandId"+lastRow).selectedIndex=true;

	}
	return true;
}

function validateFieldValuesPediatricsOpd() {

	var ageId = document.getElementById("ageId").value
	var age = ageId.substring(0, 2);
	var ageIntoInt = parseInt(age);
	if (ageIntoInt <= 15) {
		var dateSelected = document.getElementById("nextVisitDate").value;
		/*
		 * if (document.getElementById('diagnosisId').length == 0) { //commented
		 * by govind 31-01-2017 alert("Please Enter the diagnosis of the
		 * Patient."); return false; }
		 */
		if (dateSelected != "") {
			var visitDate = new Date(dateSelected.substring(6), (dateSelected
					.substring(3, 5) - 1), dateSelected.substring(0, 2))
			var currentDate = new Date(serverdate.substring(6), (serverdate
					.substring(3, 5) - 1), serverdate.substring(0, 2))
			if (visitDate < currentDate) {
				document.getElementById("nextVisitDate").value = "";
				alert("Please enter the correct Visit date.")
				return false;
			}
		}
		return true;
	} else {
		alert("Not more 15 years.");
		return false;
	}
	return true;
}

function fnShowBroughtBy() {
	document.getElementById('policeDiv').style.display = 'none';
	document.getElementById('otherSelfDiv').style.display = 'none';
	if (document.getElementById('PoliceCheck').checked) {
		document.getElementById('policeDiv').style.display = 'block';
	} else if (document.getElementById('OtherCheck').checked) {
		document.getElementById('otherSelfDiv').style.display = 'block';
	} else if (document.getElementById('SelfCheck').checked) {
		document.getElementById('otherSelfDiv').style.display = 'block';
	}
}

function putSystemicExamiantionText(id, text) {
	var putText = document.getElementById('systemicExamination').value;
	var nad = document.getElementById("nad");
	var cvs = document.getElementById("cvs");
	var cns = document.getElementById("cns");
	var rs = document.getElementById('rs');
	var grs = document.getElementById('grs');
	if (nad.checked == true) {
		cvs.disabled = true;
		cns.disabled = true;
		rs.disabled = true;
		grs.disabled = true;
		document.getElementById('systemicExamination').value = "";
		document.getElementById('systemicExamination').value = text;
	} else {
		nad.disabled = true;
		cvs.disabled = false;
		cns.disabled = false;
		rs.disabled = false;
		grs.disabled = false;
		if (cvs.checked == true) {
			document.getElementById('systemicExamination').value = (putText
					+ "\n" + text).trim();
		} else if (cns.checked == true) {
			document.getElementById('systemicExamination').value = (putText
					+ "\n" + text).trim();
		} else if (rs.checked == true) {
			document.getElementById('systemicExamination').value = (putText
					+ "\n" + text).trim();
		} else if (grs.checked == true) {
			document.getElementById('systemicExamination').value = (putText
					+ "\n" + text).trim();
		} else {
			nad.disabled = false;
			document.getElementById('systemicExamination').value = "";
		}
	}

}

function populatePVMSTab(val, inc) {
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
			document.getElementById('noOfDayspTab' + inc).value = "";
			document.getElementById('unitpTab' + inc).value = "";
			return;
		} else {// alert("pvmsNo "+pvmsNo);
			document.getElementById('pvmsNopTab' + inc).value = pvmsNo;
			document.getElementById('dosagepTab' + inc).value = 1;
			document.getElementById('noOfDayspTab' + inc).value = 1;

			new Ajax.Request(
					'ipd?method=updateItemUnit&pvmsNo=' + pvmsNo + '&'
							+ csrfTokenName + '=' + csrfTokenValue,
					{
						onSuccess : function(response) {
							if (response.responseText.trim() != '') {
								var str = response.responseText.trim().split(
										"###");
								/*
								 * document.getElementById('unitpTab'+inc).value=response.responseText.trim();
								 * document.getElementById('unit'+inc).value=response.responseText.trim();
								 */
								document.getElementById('unit' + inc).value = str[0];
								document.getElementById('unitpTab' + inc).value = str[0];
								document.getElementById('unitLable' + inc).value = str[1] != undefined ? str[1]
										: "";
								document.getElementById('unitLablepTab' + inc).value = str[1] != undefined ? str[1]
										: "";

							}
						}
					});
		}
	} else {
		document.getElementById('nomenclaturepTab' + inc).value = "";
		document.getElementById('pvmsNopTab' + inc).value = "";
		document.getElementById('dosagepTab' + inc).value = "";
		document.getElementById('noOfDayspTab' + inc).value = "";
		document.getElementById('unitpTab' + inc).value = "";
	}
}
function getUnavailableInvestigation(cnt) {
	var tbl = document.getElementById('investigationGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow - 1;
	var chargeCodeName = document.getElementById("chargeCodeName" + cnt).value;
	var index1 = chargeCodeName.lastIndexOf("[");
	var indexForBrandName = index1;
	var index2 = chargeCodeName.lastIndexOf("]");
	index1++;
	var chargeCode = chargeCodeName.substring(index1, index2);
	// alert("chargeCode----->>>"+chargeCode)
}

function getUnavailableInvestigationDermotology(cnt) {
	var tbl = document.getElementById('investigationGridDermotology');
	var lastRow = tbl.rows.length;
	//var iteration = lastRow - 1;
	var iteration = parseInt(document.getElementById('hiddenValueDermotology').value)-parseInt(1);
	if(document.getElementById("chargeCodeNameDermotology" + cnt)){
		var chargeCodeName = document.getElementById("chargeCodeNameDermotology" + cnt).value;
		var index1 = chargeCodeName.lastIndexOf("[");
		var indexForBrandName = index1;
		var index2 = chargeCodeName.lastIndexOf("]");
		index1++;
		var chargeCode = chargeCodeName.substring(index1, index2);
	}
	// alert("chargeCode----->>>"+chargeCode)
}

function checkInvestigationItem(cnt) {
	var tbl = document.getElementById('investigationGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow - 1;
	var chargeCodeName = document.getElementById("chargeCodeName" + cnt).value;
	var index1 = chargeCodeName.lastIndexOf("[");
	var indexForBrandName = index1;
	var index2 = chargeCodeName.lastIndexOf("]");
	index1++;

	var chargeCode = chargeCodeName.substring(index1, index2);
	if (chargeCode != "") {
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
					if (xmlHttp.response == "B") {
						$("#chargeCodeName" + cnt).css({
							'color' : 'blue',
							/*'font-size' : '125%'*/
						});
						$("#availableStatus" + cnt).val("nav");
						alert("Investigation temporarily blocked by lab/radiology department");
					} else if (xmlHttp.response != "A") {
						$("#chargeCodeName" + cnt).css({
							'color' : 'red',
							/*'font-size' : '125%'*/
						});
						$("#availableStatus" + cnt).val("nav");
					} else {
						$("#availableStatus" + cnt).val("av");
					}
				});
			}
		}
		var url = "/hms/hms/opd?method=checkInvestigationItem&chargeCode="
				+ chargeCode + "&" + csrfTokenName + "=" + csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
}

function checkInvestigationItemDermotology(cnt) {
	var tbl = document.getElementById('investigationGridDermotology');
	var lastRow = tbl.rows.length;
	//var iteration = lastRow - 1;
	var iteration = parseInt(document.getElementById('hiddenValueDermotology').value)-parseInt(1);
	if(document.getElementById("chargeCodeNameDermotology" + cnt)){
	var chargeCodeName = document.getElementById("chargeCodeNameDermotology" + cnt).value;
	var index1 = chargeCodeName.lastIndexOf("[");
	var indexForBrandName = index1;
	var index2 = chargeCodeName.lastIndexOf("]");
	index1++;

	var chargeCode = chargeCodeName.substring(index1, index2);
	if (chargeCode != "") {
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
					if (xmlHttp.response == "B") {
						$("#chargeCodeNameDermotology" + cnt).css({
							'color' : 'blue',
							/*'font-size' : '125%'*/
						});
						$("#availableStatus" + cnt).val("nav");
						alert("Investigation temporarily blocked by lab/radiology department");
					} else if (xmlHttp.response != "A") {
						$("#chargeCodeNameDermotology" + cnt).css({
							'color' : 'red',
							/*'font-size' : '125%'*/
						});
						$("#availableStatus" + cnt).val("nav");
					} else {
						$("#availableStatus" + cnt).val("av");
					}
				});
			}
		}
		var url = "/hms/hms/opd?method=checkInvestigationItem&chargeCode="
				+ chargeCode + "&" + csrfTokenName + "=" + csrfTokenValue;
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
	}
	}
}

/* for op constulatation tab Start */
function fillValueDays(inc) {
	if(document.getElementById('noOfDayspTab' + inc))
		document.getElementById('noOfDayspTab' + inc).value = document.getElementById('noOfDays' + inc).value;
}

function fillValue(value, inc, from) {
	var dosage;
	var freq;
	var dispenseQty;
	var noOfDays;
	var sosQty;
	// added by amit das on 19-11-2016
	var unit;
	var mixtuerUnit;
	var mixable;
	var mixtureQuantity;

	// added by govind 24-01-2017
	setDisablePharmacy();
	// added by govind 24-01-2017 end
	if (from != 'tab') {
		dosage = document.getElementById('dosage' + inc).value;
		freq = document.getElementById('frequencyValue' + inc).value;
		dispenseQty = document.getElementById('actualDispensingQty' + inc).value;
		noOfDays = document.getElementById('noOfDays' + inc).value;
		sosQty = document.getElementById('sosQty' + inc).value;

		// added by amit das on 19-11-2016
		unit = document.getElementById('unit' + inc).value;
		/*
		 * mixable = document.getElementById('mixable' + inc).value;//commented
		 * by govind 23-12-2016 mixtureUnit =
		 * document.getElementById('mixtureUnit' + inc).value; mixtureQuantity =
		 * document.getElementById('mixtureQuantity' + inc).value;
		 */

		if (document.getElementById('mixable' + inc) != null) {
			mixable = document.getElementById('mixable' + inc).value;
		}
		if (document.getElementById('mixtureUnit' + inc) != null) {
			mixtureUnit = document.getElementById('mixtureUnit' + inc).value;
		}
		if (document.getElementById('mixtureQuantity' + inc) != null) {
			mixtureQuantity = document.getElementById('mixtureQuantity' + inc).value;
		}
		// commented by govind 23-12-2016 end

		if (document.getElementById('frequency' + inc).value == 24 && noOfDays > 0) {
			total = noOfDays;
		} else if (freq > 0 && dosage > 0 && noOfDays > 0) {
			total = Math.round(freq * noOfDays * dosage);
		} else {
			total = 0;
		}

		var finalQty = "";
		var actualFinalQty = "";
		if (document.getElementById('frequency' + inc).value != 13) {
			if (document.getElementById('actualDispensingQty' + inc).value != 0) {

				// condition added by amit das on 19-11-2016
				if (mixable == 'Y') {
					// var solutionMixAmount = parseFloat(mixtureQuantity) +
					// parseFloat(dispenseQty);
					actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity))
							* parseFloat(total);
					if (actualFinalQty != '0.00') {
						finalQty = parseFloat(actualFinalQty)
								/ parseFloat(dispenseQty);
					}
					document.getElementById('total' + inc).value = total;
					document.getElementById('totalpTab' + inc).value = total;
					document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
					document.getElementById('unitLable' + inc).value = mixtureUnit;

				} else {
					var totalQty = (parseFloat(total) / parseFloat(dispenseQty))
							.toFixed(2);
					if (totalQty != '0.00') {
						finalQty = freq > 0 ? Math.ceil(totalQty) : "";
					}
					document.getElementById('total' + inc).value = finalQty;
					document.getElementById('totalpTab' + inc).value = finalQty;
				}
			} else {

				document.getElementById('total' + inc).value = total;
				document.getElementById('totalpTab' + inc).value = total;

			}
		} else {
			if (document.getElementById('actualDispensingQty' + inc).value != 0) {

				// condition added by amit das on 19-11-2016
				if (diluteable == 'Y') {
					// var solutionMixAmount = parseFloat(mixtureQuantity) +
					// parseFloat(dispenseQty);
					actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity))
							* parseFloat(total);
					if (actualFinalQty != '0.00') {
						finalQty = parseFloat(actualFinalQty)
								/ parseFloat(dispenseQty);
					}
					document.getElementById('total' + inc).value = total;
					document.getElementById('totalpTab' + inc).value = total;
					document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
					document.getElementById('unitLable' + inc).value = mixtureUnit;

				} else {

					var totalQty = (parseFloat(freq * sosQty * dosage) / parseFloat(dispenseQty))
							.toFixed(2);
					if (totalQty != '0.00') {
						finalQty = freq > 0 ? Math.ceil(totalQty) : "";
					}
					document.getElementById('total' + inc).value = finalQty;
					document.getElementById('totalpTab' + inc).value = finalQty;
				}
			} else {

				document.getElementById('total' + inc).value = sosQty * freq
						* dosage;
				document.getElementById('totalpTab' + inc).value = sosQty
						* freq * dosage;
			}
		}

		document.getElementById('dosagepTab' + inc).value = dosage;
		document.getElementById('noOfDayspTab' + inc).value = noOfDays;
		document.getElementById('frequencyValuepTab' + inc).value = freq;
		document.getElementById('actualDispensingQtypTab' + inc).value = dispenseQty;
		document.getElementById('sosQtypTab' + inc).value = sosQty;
		document.getElementById('frequencypTab' + inc).value = document
				.getElementById('frequency' + inc).value;
		document.getElementById('frequencyValuepTab' + inc).text = document
				.getElementById('frequencyValue' + inc).text;

	} else {
		dosage = document.getElementById('dosagepTab' + inc).value
		noOfDays = document.getElementById('noOfDayspTab' + inc).value
		freq = document.getElementById('frequencyValuepTab' + inc).value
		document.getElementById('totalpTab' + inc).value = noOfDays * freq
				* dosage
		dispenseQty = document.getElementById('actualDispensingQtypTab' + inc).value;
		sosQty = document.getElementById('sosQtypTab' + inc).value;
		unit = document.getElementById('unit' + inc).value;

		if (freq > 0 && dosage > 0 && noOfDays > 0) {
			total = Math.ceil(freq * noOfDays * dosage);
		} else {
			total = 0;
		}

		var finalQty = "";
		if (document.getElementById('frequencypTab' + inc).value != 13) {
			if (document.getElementById('actualDispensingQtypTab' + inc).value != 0) {
				var totalQty = (parseFloat(total) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				document.getElementById('totalpTab' + inc).value = finalQty;
				document.getElementById('total' + inc).value = finalQty;
			} else {
				document.getElementById('totalpTab' + inc).value = total;
				document.getElementById('total' + inc).value = total;
			}
		} else {

			if (document.getElementById('actualDispensingQtypTab' + inc).value != 0) {
				var totalQty = (parseFloat(freq * sosQty * dosage) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				document.getElementById('totalpTab' + inc).value = finalQty;
				document.getElementById('total' + inc).value = finalQty;
			} else {
				document.getElementById('totalpTab' + inc).value = sosQty
						* freq * dosage;
				document.getElementById('total' + inc).value = sosQty * freq
						* dosage;
			}
		}

		document.getElementById('dosage' + inc).value = dosage;
		document.getElementById('noOfDays' + inc).value = noOfDays;
		document.getElementById('frequencyValue' + inc).value = freq;
		document.getElementById('actualDispensingQty' + inc).value = dispenseQty;
		document.getElementById('sosQty' + inc).value = sosQty;
		document.getElementById('frequency' + inc).value = document
				.getElementById('frequencypTab' + inc).value;
		document.getElementById('frequencyValue' + inc).text = document
				.getElementById('frequencyValuepTab' + inc).text;
	}
}
/*
 * function fillValueFromFrequency(value,inc){ var dosage =
 * document.getElementById('dosage'+inc).value; var
 * noOfDays=document.getElementById('noOfDays'+inc).value var
 * freq=document.getElementById('frequencyValue'+inc).value
 * document.getElementById('total'+inc).value=noOfDays*freq*dosage var
 * dispenseQty = document.getElementById('actualDispensingQty'+inc).value; var
 * sosQty = document.getElementById('sosQty'+inc).value; if(freq>0 && dosage>0 &&
 * noOfDays>0){ total = freq*noOfDays*dosage; }else{ total=0; } var finalQty="";
 * if(document.getElementById('frequency'+inc).value != 13 ){
 * if(document.getElementById('actualDispensingQty'+inc).value != 0){ var
 * totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2);
 * if(totalQty != '0.00'){ finalQty = freq>0?Math.ceil(totalQty):""; }
 * document.getElementById('total'+inc).value=finalQty;
 * document.getElementById('totalpTab'+inc).value=finalQty; }else{
 * document.getElementById('total'+inc).value=noOfDays*freq*dosage
 * document.getElementById('totalpTab'+inc).value=noOfDays*freq*dosage } }else{
 * if(document.getElementById('actualDispensingQty'+inc).value != 0){ var
 * totalQty =
 * (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2);
 * if(totalQty != '0.00'){ finalQty = freq>0?Math.ceil(totalQty):""; }
 * document.getElementById('total'+inc).value=finalQty;
 * document.getElementById('totalpTab'+inc).value=finalQty;
 * 
 * }else{ document.getElementById('total'+inc).value=sosQty*freq*dosage
 * document.getElementById('totalpTab'+inc).value=sosQty*freq*dosage } } dosage =
 * document.getElementById('dosagepTab'+inc).value=dosage;
 * document.getElementById('noOfDayspTab'+inc).value=noOfDays;
 * document.getElementById('frequencyValuepTab'+inc).value=freq;
 * document.getElementById('actualDispensingQtypTab'+inc).value=dispenseQty;
 * document.getElementById('sosQtypTab'+inc).value=sosQty;
 * document.getElementById('frequencypTab'+inc).value=document.getElementById('frequency'+inc).value;
 * document.getElementById('frequencypTab'+inc).text=document.getElementById('frequency'+inc).text; }
 */

function displaySOSQty(val, inc,opdType) {
	if (val == '13') {
		document.getElementById('sosQty' + inc).style.display = 'block';
		document.getElementById('noOfDays' + inc).disabled = true;
		if(opdType!=null && opdType!='opdLite'){
			document.getElementById('sosQtypTab' + inc).style.display = 'block';
			document.getElementById('noOfDayspTab' + inc).disabled = true;
		}
	} else {

		document.getElementById('sosQty' + inc).style.display = 'none';
		document.getElementById('noOfDays' + inc).disabled = false;
		if(opdType!=null && opdType!='opdLite'){
			document.getElementById('sosQtypTab' + inc).style.display = 'none';
			document.getElementById('noOfDayspTab' + inc).disabled = false;
		}
	}
}

function displayAu(val, inc,type) {
	if (val != "") {
		var index1 = val.lastIndexOf("[");
		var indexForBrandName = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvmsNo = val.substring(index1, index2);
		var indexForBrandName = indexForBrandName--;
		var brandName = val.substring(0, indexForBrandName);
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
					var actualDispensingQty = item
							.getElementsByTagName("actualDispensingQty")[0];
					var stock = item.getElementsByTagName("stock")[0];

					// added by amit das on 19-11-2016
					var mixable = item.getElementsByTagName("mixable")[0];
					var mixtureQuantity = item
							.getElementsByTagName("mixtureQuantity")[0];
					var mixtureUnit = item.getElementsByTagName("mixtureUnit")[0];
					var tapered = item.getElementsByTagName("tapered")[0];

					var dosage = item.getElementsByTagName("dosage")[0];
					var noOfDays = item.getElementsByTagName("noOfDays")[0];
					var freq = item.getElementsByTagName("freq")[0];
					var freqType = item.getElementsByTagName("freqType")[0];
					var freqCount = item.getElementsByTagName("freqCount")[0];
					
					document.getElementById('nomenclature'+ inc).title= val;
					if (document.getElementById('au' + inc)
							&& au.childNodes[0] != undefined) {
						document.getElementById('au' + inc).value = au.childNodes[0].nodeValue;
					}
					/*
					 * if(document.getElementById('closingStock'+inc) &&
					 * stock.childNodes[0] != undefined){
					 * document.getElementById('closingStock'+inc).value =
					 * stock.childNodes[0].nodeValue;
					 * if(stock.childNodes[0].nodeValue == 0){ alert("Stock is
					 * not available..."); } }else{ }
					 */
					if (document.getElementById('actualDispensingQty' + inc)) {
						if (actualDispensingQty.childNodes[0] != undefined) {
							document
									.getElementById('actualDispensingQty' + inc).value = actualDispensingQty.childNodes[0].nodeValue;
						} else {
							document
									.getElementById('actualDispensingQty' + inc).value = 0;

						}
					}
					var dangerousDrug = item
							.getElementsByTagName("dangerousDrug")[0];
					if (dangerousDrug.childNodes[0] != undefined
							&& dangerousDrug.childNodes[0].nodeValue == 'y') {
						alert("This drug is dangerous.");
					}

					// added by amit das on 19-11-2016
					if (document.getElementById('mixable' + inc)
							&& mixable.childNodes[0] != undefined) {
						document.getElementById('mixable' + inc).value = mixable.childNodes[0].nodeValue;
					}
					// added by amit das on 19-11-2016
					if (document.getElementById('mixtureQuantity' + inc)
							&& mixtureQuantity.childNodes[0] != undefined) {
						document.getElementById('mixtureQuantity' + inc).value = mixtureQuantity.childNodes[0].nodeValue;
					}

					// added by amit das on 19-11-2016
					if (document.getElementById('mixtureUnit' + inc)
							&& mixtureUnit.childNodes[0] != undefined) {
						document.getElementById('mixtureUnit' + inc).value = mixtureUnit.childNodes[0].nodeValue;
					}

					if (document.getElementById('tapered' + inc)
							&& tapered.childNodes[0] != undefined) {
						document.getElementById('tapered' + inc).value = tapered.childNodes[0].nodeValue;
					}

					if (dosage.childNodes[0] != undefined
							&& dosage.childNodes[0].nodeValue != undefined) {
						document.getElementById('dosage' + inc).value = dosage.childNodes[0].nodeValue;
					}
					if (freq.childNodes[0] != undefined
							&& freq.childNodes[0].nodeValue != undefined) {
						document.getElementById('frequency' + inc).value = freq.childNodes[0].nodeValue;
					}
					if (freqType.childNodes[0] != undefined
							&& freqType.childNodes[0].nodeValue != undefined) {
						document.getElementById('frequencyType' + inc).innerHTML = freqType.childNodes[0].nodeValue;
					}
					if (noOfDays.childNodes[0] != undefined
							&& noOfDays.childNodes[0].nodeValue != undefined) {
						document.getElementById('noOfDays' + inc).value = noOfDays.childNodes[0].nodeValue;
					}
					if (freqCount.childNodes[0] != undefined
							&& freqCount.childNodes[0].nodeValue != undefined) {
						document.getElementById('frequencyValue' + inc).value = freqCount.childNodes[0].nodeValue;
					}
					if (freqType.childNodes[0] != undefined
							&& freqType.childNodes[0].nodeValue != undefined) {
						if(type!=null && type=='opdlite')
							fillValueForOpdLite(this.value, inc);
						else	
							fillValue(this.value, inc);
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

/*
 * function fillValueFromFrequencypTab(value,inc){ var dosage =
 * document.getElementById('dosagepTab'+inc).value var
 * noOfDays=document.getElementById('noOfDayspTab'+inc).value var
 * freq=document.getElementById('frequencyValuepTab'+inc).value
 * document.getElementById('totalpTab'+inc).value=noOfDays*freq*dosage var
 * dispenseQty = document.getElementById('actualDispensingQtypTab'+inc).value;
 * var sosQty = document.getElementById('sosQty'+inc).value; var total =
 * freq*noOfDays*dosage; var finalQty;
 * if(document.getElementById('frequencypTab'+inc).value != 13 ){
 * if(document.getElementById('actualDispensingQtypTab'+inc).value != 0){ var
 * totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2) if(totalQty !=
 * '0.00'){ finalQty = Math.ceil(totalQty); }
 * document.getElementById('totalpTab'+inc).value=finalQty; }else{
 * document.getElementById('totalpTab'+inc).value=noOfDays*freq*dosage } }else{
 * if(document.getElementById('actualDispensingQtypTab'+inc).value != 0){ var
 * totalQty =
 * (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
 * if(totalQty != '0.00'){ finalQty = Math.ceil(totalQty); }
 * document.getElementById('totalpTab'+inc).value=finalQty;
 * 
 * }else{ document.getElementById('totalpTab'+inc).value=sosQty*freq*dosage } } }
 */

function displayAupTab(val, inc) {
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
					var actualDispensingQty = item
							.getElementsByTagName("actualDispensingQtypTab")[0];
					var stock = item.getElementsByTagName("stock")[0];

					if (document.getElementById('au' + inc)
							&& au.childNodes[0] != undefined) {
						document.getElementById('au' + inc).value = au.childNodes[0].nodeValue;
					}
					/*
					 * if(document.getElementById('closingStock'+inc) &&
					 * stock.childNodes[0] != undefined){
					 * document.getElementById('closingStock'+inc).value =
					 * stock.childNodes[0].nodeValue;
					 * if(stock.childNodes[0].nodeValue == 0){ alert("Stock is
					 * not available..."); } }else{ }
					 */
					if (document
							.getElementById('actualDispensingQtypTab' + inc)) {
						if (actualDispensingQty.childNodes[0] != undefined) {
							document
									.getElementById('actualDispensingQty' + inc).value = actualDispensingQty.childNodes[0].nodeValue;
						} else {
							document.getElementById('actualDispensingQtypTab'
									+ inc).value = 0;

						}
					}
					var dangerousDrug = item
							.getElementsByTagName("dangerousDrug")[0];
					if (dangerousDrug.childNodes[0] != undefined
							&& dangerousDrug.childNodes[0].nodeValue == 'y') {
						alert("This drug is dangerous.");
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

function parent_disable() {
	if (newwindow && !newwindow.closed)
		newwindow.focus();
}
function showPatientHistory(hinNo, csrf) {
	var visitId = document.getElementById("visitId").value;
	var url = '/hms/hms/enquiry?method=showPatientDetails&hinNo=' + hinNo
			+ '&visitId=' + visitId + '&' + csrf + '&' + csrfTokenName + '='
			+ csrfTokenValue;
	newwindow = window
			.open(url, 'opd_window',
					"left=100,top=10,height=630,width=1330,status=1,scrollbars=yes,resizable=0");

}

function showImmunization(hinNo) {
	document.opdMain.action = "/hms/hms/opd?method=showImmunization&hinNo="
			+ hinNo;
	document.opdMain.submit();
}

function showPreviousStudentVisit(hinId) {
	document.opdMain.action = "/hms/hms/opd?method=showStudentPreviousVisit&hinId=<%=visit.getHin().getId()%>";
	document.opdMain.submit();
}
function openPopupForPatientInvestigation(visitNo, hinId, csrf) {
	if (visitNo > 1) {
		var chargeCodeName1 = document.getElementById("chargeCodeName1").value;
		var url = "/hms/hms/opd?method=showPatientPreviousInvestigation&chargeCodeName1="
				+ chargeCodeName1
				+ "&visitNo="
				+ visitNo
				+ "&hinId="
				+ hinId
				+ "&" + csrf + "&" + csrfTokenName + "=" + csrfTokenValue;
		newwindow = window.open(url, 'name',
				"height=300,width=800,status=1,scrollbars=yes");
	} else {
		alert("This is Patient's First Visit. ")
	}
}

function openPopupForLabResults(csrf, visitId, hinId) {
	window
			.open(
					"/hms/hms/opd?method=showPatientLabResult&visitId="
							+ visitId + "&hinId=" + hinId + "&" + csrf + "&"
							+ csrfTokenName + "=" + csrfTokenValue,
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
}

function openPopupForOphthalmology(url) {

	var height = 450;
	var width = 1170;
	var left = (screen.width / 2) - (width / 2);
	var top = (screen.height / 2) - (height / 2);
	url = url + '&' + csrfTokenName + '=' + csrfTokenValue;
	window.open(url, "Patient Details",
			"resizable=0,scrollbars=no, status = no, height = " + height
					+ ", width =" + width + ",top=" + top + ", left=" + left);

}

function openPopupForAntenatal(url) {

	var height = 450;
	var width = 1170;
	var left = (screen.width / 2) - (width / 2);
	var top = (screen.height / 2) - (height / 2);
	url = url + '&' + csrfTokenName + '=' + csrfTokenValue;
	window.open(url, "Patient Details",
			"resizable=0,scrollbars=no, status = no, height = " + height
					+ ", width =" + width + ",top=" + top + ", left=" + left);

}

function populateManufacturer(val, count) {

	var counter1 = document.getElementById('hdb').value
	if (val != "0") {
		for (i = 1; i <= counter1; i++) {
			if (count != i) {
				if (document.getElementById('brandId' + i).value == val) {
					alert("Brand Name already selected...!");
					document.getElementById('brandId' + count).value = "0";
					document.getElementById('nomenclature' + count).value = "";
					document.getElementById('manufactureId' + count).value = "";
					var e = eval(document.getElementById('brandId' + count));
					e.focus();
					return false;
				}
			}

		}
		submitProtoAjaxForManufacturerClass('opdMain',
				'/hms/hms/opd?method=getItemBrandManufacturerName&brandId='
						+ val + '&counter=' + count, count);
		submitProtoAjaxForNomenClature('opdMain',
				'/hms/hms/opd?method=getNomenclature&brandId=' + val
						+ '&counter=' + count, count);
	}
}

function checkDrugType(rowVal) {

	var pvmsNo = document.getElementById("pvmsNo" + rowVal).value;
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
				var drugType = item.getElementsByTagName("drugType")[0];
				if (drugType.childNodes[0] != undefined) {
					if (drugType.childNodes[0].nodeValue == 'Drops') {
						document.getElementById('typeLeftRight' + rowVal).disabled = false;
					} else {
						document.getElementById('typeLeftRight' + rowVal).disabled = true;
					}
				}
			}
		}
	}
	var url = "opd?method=getDrugTypeOfItem&pvmsNo=" + pvmsNo + "&"
			+ csrfTokenName + "=" + csrfTokenValue;

	xmlHttp.open("GET", url, true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);

}

function populatebrand(val, incr) {
	// var itemId=document.getElementById('itemIdForPvms'+incr).value;

	var pvmsNo;
	if (val != "") {
		var index1 = val.lastIndexOf("[");
		var index2 = val.lastIndexOf("]");
		index1++;
		pvmsNo = val.substring(index1, index2);

		document.getElementById('pvmsNo' + incr).value = pvmsNo;
		if (pvmsNo != "") {
			for (i = 1; i < incr; i++) {

				if (incr != 1) {
					if (val != "") {
						if (document.getElementById('nomenclature' + i).value == val) {
							alert("Item Name already selected...!");
							document.getElementById('nomenclature' + incr).value = "";
							document.getElementById('pvmsNo' + incr).value = "";
							var e = eval(document.getElementById('nomenclature'
									+ incr));
							e.focus();
						}
					} else {
						return false;
					}

				}
			}

			submitProtoAjaxForLionClass('opdMain',
					'/hms/hms/opd?method=getItemBrandName&pvmsNo=' + pvmsNo
							+ '&counter=' + incr + '&' + csrfTokenName + '='
							+ csrfTokenValue, incr);
		}
	}
}

/* for prescription tab tab Start */
/*
 * function fillValuepTab(value,inc){ var dosage =
 * document.getElementById('dosagepTab'+inc).value var
 * freq=document.getElementById('frequencyValuepTab'+inc).value; var
 * noOfDays=document.getElementById('noOfDayspTab'+inc).value var dispenseQty =
 * document.getElementById('actualDispensingQtypTab'+inc).value; var sosQty =
 * document.getElementById('sosQtypTab'+inc).value; var total =
 * freq*noOfDays*dosage; var finalQty;
 * if(document.getElementById('frequencypTab'+inc).value != 13 ){
 * if(document.getElementById('actualDispensingQtypTab'+inc).value != 0){ var
 * totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2) if(totalQty !=
 * '0.00'){ finalQty = Math.ceil(totalQty); }
 * document.getElementById('totalpTab'+inc).value=finalQty; }else{
 * document.getElementById('totalpTab'+inc).value=freq*value*dosage; } }else{
 * if(document.getElementById('actualDispensingQtypTab'+inc).value != 0){ var
 * totalQty =
 * (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
 * if(totalQty != '0.00'){ finalQty = Math.ceil(totalQty); }
 * document.getElementById('totalpTab'+inc).value=finalQty; }else{
 * document.getElementById('totalpTab'+inc).value=freq*sosQty*dosage; } } }
 */

function displaySOSQtypTab(val, inc) {
	if (val == '13') {
		document.getElementById('sosQtypTab' + inc).style.display = 'block';
		document.getElementById('noOfDayspTab' + inc).disabled = true;
	} else {

		document.getElementById('sosQtypTab' + inc).style.display = 'none';
		document.getElementById('noOfDayspTab' + inc).disabled = false;
	}
}

function openPopupForPatientPrescription(visitNo, hinId, visitId, csrf) {

	if (visitNo >= 1) {
		// var nomenclature1=document.getElementById("nomenclature1").value;
		var url = "/hms/hms/opd?method=showPatientPreviousPrescription&visitNo="
				+ visitNo
				+ "&hinId="
				+ hinId
				+ "&visitId="
				+ visitId
				+ "&"
				+ csrfTokenName + "=" + csrfTokenValue;
		newwindow = window.open(url, 'opd_window',
				"height=420,width=1050,status=1,scrollbars=yes");
	} else {
		alert("This Is Patient's first Visit.")
	}

}

// ADDED BY OM TRIPATHI
// openPopupForPersonalReviewSubmit('<%=departmentId%>','<%=hospitalId%>','<%=uhid%>','<%=appointmentDate%>')
function openPopupForPersonalReviewSubmit(deptNo, hospitalId, uhid, reviewDate,
		csrfTokenName) {
	alert('hospital');
	// if ( hospitalId > 1) {
	var reviewDate = document.getElementById("reviewDate").value;
	alert("review date" + reviewDate)
	var url = "/hms/hms/appointment?method=submitPatientAppointment&appointmentType="
			+ "A"
			+ "&department="
			+ deptNo
			+ "&appointmentDate="
			+ reviewDate
			+ "&uhid=" + uhid + "&hospitalId=" + hospitalId;
	newwindow = window.open(url, 'opd_window',
			"height=420,width=1050,status=1,scrollbars=yes");
	// } else {
	alert("Patient visit already created .");
	// if(checkFilledField()){submitForm('OnlineAppointment',
	// '/hms/hms/appointment?method=submitPatientAppointment&appointmentType=')}

	// }

}

// Added By Om Tripathi For Personal Review Popup
function openPopupForPersonalReview(deptNo, uhid, hospitalId, csrf) {

	var reviewDate = document.getElementById("reviewDate").value;
	var value = document.getElementById('checked').checked;
	if (reviewDate != "") {
		if (value == true) {
			var url = "/hms/hms/appointment?method=getPriorityQueueByDepartment&hospitalId="
					+ hospitalId
					+ "&department="
					+ deptNo
					+ "&appointmentDate=" + reviewDate + "&uhid=" + uhid
					// + "&futureConsultFlag="+"A"
					+ "&csrfTokenName=" + csrfTokenValue;

			newwindow = window.open(url, 'opd_window',
					"height=420,width=1050,status=1,scrollbars=yes");
		}
	} else {
		alert("Please select the review date");
	}
}

/* OM tripathi26/08/2017 start */

function popFuturConsultationReview(url) {
	var value = document.getElementById('checked').checked;

	if (value != false) {
		var height = 450;
		var width = 1070;
		var left = (screen.width / 2) - (width / 2);
		var top = (screen.height / 2) - (height / 2);
		url = url + "&" + csrfTokenName + "=" + csrfTokenValue;
		window.open(url, "Patient Details",
				"resizable=0,scrollbars=no, status = no, height = " + height
						+ ", width =" + width + ",top=" + top + ", left="
						+ left)
	}
}

/* OM tripathi26/08/2017 end */

function submitProtoAjaxForNomenClature(formName, action, counter1) {

	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.' + formName);
	obj.action = action;

	var url = action + "&" + getNameAndData(formName);
	new Ajax.Updater('nomenclatureDiv' + counter1, url, {
		asynchronous : true,
		evalScripts : true
	});
	// document.getElementById('nomenclature'+counter1).style.display='none';
	return true;
}

function submitProtoAjaxForManufacturerClass(formName, action, counter1) {

	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.' + formName);
	obj.action = action;

	var url = action + "&" + getNameAndData(formName);
	new Ajax.Updater('manufacturereDiv' + counter1, url, {
		asynchronous : true,
		evalScripts : true
	});
	// document.getElementById('manufacturer'+counter1).style.display='none';
	return true;
}

function submitProtoAjaxForLionClass(formName, action, incr) {

	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.' + formName);
	obj.action = action;
	var url = action + "&" + getNameAndData(formName);

	new Ajax.Updater('testDiv' + incr, url, {
		asynchronous : true,
		evalScripts : true
	});

	// document.getElementById('brandId'+incr).style.display='none';
	return true;
}

function populatePvmsNo(val, inc) {
	if (val != "") {
		var index1 = val.lastIndexOf("[");
		var indexForBrandName = index1;

		var index2 = val.lastIndexOf("]");

		index1++;
		var pvmsNo = val.substring(index1, index2);

		var indexForBrandName = indexForBrandName--;
		var brandName = val.substring(0, indexForBrandName);

		var index3 = brandName.lastIndexOf("[");
		index3++;
		var index4 = brandName.lastIndexOf("]");
		var itemId = val.substring(index3, index4);
		if (pvmsNo == "") {
			document.getElementById('nomenclature' + inc).value = "";
			document.getElementById('pvmsNooo' + inc).value = "";
			document.getElementById('itemId' + inc).value = "";
			return;
		} else
			document.getElementById('pvmsNooo' + inc).value = pvmsNo;
		document.getElementById('itemId' + inc).value = itemId;

	}
}

function calculateTotalDispensingPrice() {
	var cnt = document.getElementById('hdb').value;
	var totalDispPrice = 0;
	for (var i = 1; i <= cnt; i++) {
		if (document.getElementById("dispensingPrice" + i) != null) {
			if (document.getElementById("dispensingPrice" + i).value != "")
				totalDispPrice = parseFloat(totalDispPrice)
						+ (parseFloat(document.getElementById("dispensingPrice"
								+ i).value) * parseFloat(parseFloat(document
								.getElementById("total" + i).value)));
		}
	}
	document.getElementById("totalDispPrice").value = totalDispPrice;
}

function calculateTotalRate() {
	var cntRate = document.getElementById('hiddenValue').value;
	var totalRate = 0;
	for (var i = 1; i <= cntRate; i++) {
		if (document.getElementById("rate" + i) != null) {
			if (document.getElementById("rate" + i).value != "")
				totalRate = parseFloat(totalRate)
						+ (parseFloat(document.getElementById("rate" + i).value));
		}
	}
	document.getElementById("totalRate").value = totalRate;
}

function displayPhAlert(val, i) {
	if (document.getElementById('alertToStaff' + i).checked == true) {
		document.getElementById('phAlert' + i).style.display = 'inline';
	} else {
		document.getElementById('phAlert' + i).style.display = 'none';
	}

}

function checkPayWard(payward) {
	var flag;
	if (document.getElementById(payward).checked) {
		flag = "y";
	} else {
		flag = "n";
	}
	new Ajax.Request(
			'opd?method=getPayward&flag=' + flag + '&' + csrfTokenName + '='
					+ csrfTokenValue,
			{
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						document.getElementById('admissionWard').innerHTML = response.responseText
								.trim();
					}
				}
			});
}

function getAllTemplate() {
	var e1 = document.getElementById('tempLateInvestigation');

	e1.length = 0;
	e1.innerHTML = "";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < tempArrayTemp.length; i++) {
		e1.length++;
		e1.options[e1.length - 1] = new Option(tempArrayTemp[i][1],
				tempArrayTemp[i][0]);
	}
}

function getTemplate(type, from, frompTab) {
	new Ajax.Request(
			'opd?method=getTemplate&type=' + type + '&from=' + from + '&'
					+ csrfTokenName + '=' + csrfTokenValue,
			{
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						if (from == 'i')
							document.getElementById('tempLateInvestigation').innerHTML = response.responseText
									.trim();
						else if (from == 'p' && frompTab == '')
							document.getElementById('tempLatePrescription').innerHTML = response.responseText
									.trim();
						else if (frompTab == 'ptab') {
							document.getElementById('tempLatePrescriptionTab').innerHTML = response.responseText
									.trim();
						}
					}
				}
			});
}

function addRowPrescriptionTab() {
	/** For prescription tab : START */
	var tbl = document.getElementById('prescriptionTabGrid');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('pTabhdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadiopTab' + iteration;
	e1.id = 'itemRadiopTab' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'prescription_availableStatuspTab' + iteration;
	e1.id = 'prescription_availableStatuspTab' + iteration;
	e1.className = 'textYellow grdTextSmall';
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'parkPrescriptionIds' + iteration;
	e1.id = 'parkPrescriptionIds' + iteration;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'nomenclaturepTab' + iteration;
	e1.id = 'nomenclaturepTab' + iteration;
	e1.size = '35'
	e1.className = 'textYellow largTextBoxOpd';
	e1.onfocus = function() {
		checkEnteredDiagnosis();
		checkFrequency(iteration, "tab");
	}
	e1.onkeypress = function() {
		checkTextColor('nomenclaturepTab' + iteration);
	};
	e1.onblur = function() {
		populatePVMSTab(this.value, iteration);
		checkPItem(iteration);
		validatePrescriptionAutocomplete('opPTab', this.value, iteration);
		checkForAllergy(this.value, iteration);
	};

	cellRight1.appendChild(e1);
	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'ac2updatespTab' + iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	new Ajax.Autocompleter('nomenclaturepTab' + iteration, 'ac2updatespTab'
			+ iteration, 'opd?method=getItemListForAutoCompleteItem', {
		minChars : 3,
		parameters : 'requiredField=nomenclaturepTab' + iteration
	});
	e1.focus();

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'brandIdpTab' + iteration;
	e1.id = 'brandId' + iteration;
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'manufactureIdpTab' + iteration;
	e1.id = 'manufactureId' + iteration;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'routepTab' + iteration;
	e1.id = 'routepTab' + iteration;
	e1.style.width = "70px";
	e1.style.background = "#FFFF99";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < routeArray.length; i++) {
		e1.options[i + 1] = new Option(routeArray[i][1], routeArray[i][0]);
	}
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'actualDispensingQtypTab' + iteration;
	e1.id = 'actualDispensingQtypTab' + iteration;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.name = 'dosagepTab' + iteration;
	e1.id = 'dosagepTab' + iteration;
	e1.maxlength = '8';
	e1.className = "textYellow opdTextBoxTSmall";
	e1.onblur = function() {
		fillValue(this.value, iteration, 'tab');
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'unitpTab' + iteration;
	e1.id = 'unitpTab' + iteration;
	e1.className = 'textYellow opdTextBoxTSmall';
	e1.readOnly = 'readOnly';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.name = 'frequencypTab' + iteration;
	e1.id = 'frequencypTab' + iteration;
	e1.style.width = "70px";
	e1.style.background = "#FFFF99";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < icdArray.length; i++) {
		e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]);
	}
	e1.onchange = function() {
		getFrequencyValuepTab(this.value, iteration);
		fillValue(this.value, iteration, 'tab');
		displaySOSQtypTab(this.value, iteration)
	};
	cellRight1.appendChild(e1);

	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'sosQtypTab' + iteration;
	e21.id = 'sosQtypTab' + iteration;
	e21.size = '5';
	e21.setAttribute('tabindex', '1');
	cellRight1.appendChild(e21);

	var e21 = document.createElement('input');
	e21.type = 'hidden';
	e21.name = 'frequencyValuepTab' + iteration;
	e21.id = 'frequencyValuepTab' + iteration;
	e21.size = '5';
	e21.setAttribute('tabindex', '1');
	cellRight1.appendChild(e21);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'noOfDayspTab' + iteration;
	e1.id = 'noOfDayspTab' + iteration;
	e1.size = '3';
	e1.maxlength = '3';
	e1.className = 'textYellow opdTextBoxTSmall';
	e1.onblur = function() {
		fillValue(this.value, iteration, 'tab');
		setEndDate(this.value, iteration);
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('Select');
	e1.name = 'instrunctionpTab' + iteration;
	e1.id = 'instrunctionpTab' + iteration;
	e1.style.width = "70px";
	e1.style.background = "#FFFF99";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < instructionArray.length; i++) {
		e1.options[i + 1] = new Option(instructionArray[i][1],
				instructionArray[i][0]);
	}
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.maxlength = '200';
	e1.name = 'splInstrunctionpTab' + iteration;
	e1.id = 'splInstrunctionpTab' + iteration;
	e1.className = "textYellow opdTextBoxSmall";

	e1.size = '5';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'totalpTab' + iteration;
	e1.id = 'totalpTab' + iteration;
	e1.size = '5';
	e1.readOnly = true;
	e1.className = 'textYellow opdTextBoxTSmall';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'unitLablepTab' + iteration;
	e1.id = 'unitLablepTab' + iteration;
	e1.className = "textYellow opdTextBoxTSmall";
	e1.readOnly = 'readOnly';
	e1.size = '5';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'startDate' + iteration;
	e1.id = 'startDate' + iteration;
	e1.size = '5';
	e1.value = document.getElementById('consultationDate').value;
	e1.className = 'textYellow small';
	e1.readOnly = true;
	e1.onblur = function() {
		compareDate(iteration);
	};
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';
	img1.onclick = function(event) {
		var obj = document.getElementById('startDate' + iteration);
		setdate(document.getElementById('consultationDate').value, obj, event);
	};
	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(12);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'endDate' + iteration;
	e1.id = 'endDate' + iteration;
	e1.size = '5';
	e1.value = "";
	e1.readOnly = true;
	e1.className = 'textYellow small';
	e1.readOnly = true;
	e1.onblur = function() {
		compareDate(iteration);
	};
	cellRight1.appendChild(e1);

	var img2 = document.createElement('img');
	img2.src = '/hms/jsp/images/cal.gif';
	img2.onclick = function(event) {
		var obj = document.getElementById('endDate' + iteration);
		setdate(document.getElementById('consultationDate').value, obj, event);
	};
	cellRight1.appendChild(img2);

	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name = 'pvmsNopTab' + iteration;
	e1.id = 'pvmsNopTab' + iteration;
	cellRight1.appendChild(e1);

	/** For prescription tab : END */
}

function addRowForInvestigation() {

	var tbl = document.getElementById('investigationGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValue');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'chargeRadio' + iteration;
	e0.id = 'chargeRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight1.appendChild(e0);

	var e0 = document.createElement('input');
	e0.type = 'hidden';
	e0.name = 'availableStatus' + iteration;
	e0.id = 'availableStatus' + iteration;
	e0.size = '20';
	cellRight1.appendChild(e0);

	var e0 = document.createElement('input');
	e0.type = 'hidden';
	e0.name = 'parkInvestigationId' + iteration;
	e0.id = 'parkInvestigationId' + iteration;
	cellRight1.appendChild(e0);

	var cellRight0 = row.insertCell(1);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name = 'chargeCodeName' + iteration;
	e0.id = 'chargeCodeName' + iteration;
	e0.onkeypress = function() {
		checkTextColor('chargeCodeName' + iteration);
	};
	e0.onblur = function() {
		getUnavailableInvestigation(iteration);
		checkInvestigationItem(iteration);
		getLoincSnomedList(iteration);
		if (validateInvestigationAutoComplete(this.value, iteration)) {
			submitProtoAjaxNew('opdMain',
					"/hms/hms/opd?method=fillChargeCode&hinId="
							+ document.getElementById("hinId").value
							+ "&rowVal=" + iteration, 'chargeCodeVal'
							+ iteration);
		}
	};
	e0.size = '65';
	e0.className = "textYellow largTextBoxOpd";
	cellRight0.appendChild(e0);

	var updatediv = document.createElement('div');
	updatediv.setAttribute('id', 'ac2update' + iteration);
	updatediv.style.display = 'none';
	updatediv.className = "autocomplete";
	cellRight0.appendChild(updatediv);

	new Ajax.Autocompleter('chargeCodeName' + iteration, 'ac2update'
			+ iteration, 'opd?method=getInvestigationListForAutoComplete', {
		minChars : 3,
		callback : function(element, entry) {
			return entry + '&labradiologyCheck='
					+ document.getElementById('investigationCategory').value;
		},
		parameters : 'requiredField=chargeCodeName' + iteration
				+ '&fromOpd=fromOpd'
	});

	var cellRight3 = row.insertCell(2);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name = 'snomedTermsInv' + iteration;
	e0.id = 'snomedTermsInv' + iteration;
	e0.size = '20';
	e0.className = "largTextBoxOpd textYellow";
	cellRight3.appendChild(e0);

	// var cellRightSel = row.insertCell(3);
	// cellRightSel.id='chargeCodeVal'+iteration;
	var sel = document.createElement('input');
	sel.type = 'hidden';
	sel.name = 'chargeCode' + iteration;
	sel.id = 'chargeCode' + iteration;
	sel.size = '15';
	cellRight3.appendChild(sel);

	var cellRight3 = row.insertCell(3);
	var e0 = document.createElement('input');
	e0.type = 'text';
	e0.name = 'clinicalNotes' + iteration;
	e0.id = 'clinicalNotes' + iteration;
	e0.size = '20';
	e0.className = "opdTextBoxSmall textYellow";
	cellRight3.appendChild(e0);
}

function fillSPLInstrunctionOnPTAb(iteration) {
	document.getElementById("splInstrunctionpTab" + iteration).value = document
			.getElementById("splInstrunction" + iteration).value;
}

function fillInstrunctionOnTAb(iteration) {
	var e = document.getElementById("instrunction" + iteration);
	var index = e.selectedIndex;
	var strValue = e.options[e.selectedIndex].value;
	var stText = e.options[e.selectedIndex].text;

	var eTab = document.getElementById("instrunctionpTab" + iteration);
	eTab.selectedIndex = index;
	eTab.options[e.selectedIndex].value = strValue;
	eTab.options[e.selectedIndex].text = stText;
}

function fillRouteOnTAb(iteration) {
	if (document.getElementById("route" + iteration) != null) {
		var e = document.getElementById("route" + iteration);
		var index = e.selectedIndex;
		var strValue = e.options[e.selectedIndex].value;
		var stText = e.options[e.selectedIndex].text;
	}

	if (document.getElementById("routepTab" + iteration) != null) {
		var eTab = document.getElementById("routepTab" + iteration);
		eTab.selectedIndex = index;
		eTab.options[e.selectedIndex].value = strValue;
		eTab.options[e.selectedIndex].text = stText;
	}
}

function removeRowForInvestigation() {
	var tbl = document.getElementById('investigationGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hiddenValue');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	if (confirm("Do you want to delete !")) {
		for (var i = 0; i < iteration; i++) {
			if (document.getElementById("chargeRadio" + i) != null
					&& (typeof document.getElementById("chargeRadio" + i).checked) != 'undefined'
					&& document.getElementById("chargeRadio" + i).checked) {
				totalSelected = totalSelected + 1;
			}
		}
		if (totalSelected == 0) {
			alert('Please select atleast 1 row to delete');
		} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
			alert('You can not delete all Row.');
		} else if (lastRow > 2) {
			for (var i = 0; i < iteration; i++) {
				if (document.getElementById("chargeRadio" + i) != null
						&& (typeof document.getElementById("chargeRadio" + i).checked) != 'undefined'
						&& document.getElementById("chargeRadio" + i).checked) {
					jQuery(function($) {
						var ids = "";
						if (document.getElementById("parkInvestigationId" + i) != null) {
							ids = document.getElementById("parkInvestigationId"
									+ i).value;
						}

						if (ids != "" && ids != "0-0-0") {
							$.post("opd?method=deleteOPDdetails&ids=" + ids
									+ "&for=" + "Inv" + "&" + csrfTokenName
									+ "=" + csrfTokenValue, function(data) {
								try {
									flag = 1;
									msgFlag = data;
								} catch (e) {
									alert(e);
								}
							});
						}
					});
					var deleteRow = document.getElementById("chargeRadio" + i).parentNode.parentNode;
					document.getElementById("chargeRadio" + i).parentNode.parentNode.parentNode
							.removeChild(deleteRow);
				}
			}
		}
	}

}

function checkForAllergy(val, inc) {
	// alert(val+"<<<-------val======inc------>>"+inc);
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
						alert("Patient is allergic to this medicine!!");
						document.getElementById('nomenclature' + inc).value = "";
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

function SecondOpinion() {
	var height = 350;
	var width = 700;
	var csrf = csrfTokenName + '=' + csrfTokenValue;
	var visitId = document.getElementById("visitId").value;
	var hinId = document.getElementById("hinId").value;
	var hinNo = document.getElementById("hinNo").value;

	var left = (screen.width / 2) - (width / 2);
	var top = (screen.height / 2) - (height / 2);
	window.open("/hms/hms/opd?method=getSecondOpinionScreenJSP&visitId="
			+ visitId + "&hinNo=" + hinId + "&uhidNo=" + hinNo + "&" + csrf
			+ "&" + csrfTokenName + "=" + csrfTokenValue, "Second Opinion",
			"scrollbars=no, status = no, height = " + height + ", width ="
					+ width + ",top=" + top + ", left=" + left)
}

function patientDetails(csrf) {
	var height = 400;
	var width = 900;
	var visitId = document.getElementById("visitId").value;
	var left = (screen.width / 2) - (width / 2);
	var top = (screen.height / 2) - (height / 2);
	window.open("/hms/hms/opd?method=getPatientDetails&hinId=" + visitId + "&"
			+ csrf + "&" + csrfTokenName + "=" + csrfTokenValue,
			"Patient Details", "scrollbars=no, status = no, height = " + height
					+ ", width =" + width + ",top=" + top + ", left=" + left)
}

function AboutEmrEhr() {
	var height = 400;
	var width = 700;
	var left = (screen.width / 2) - (width / 2);
	var top = (screen.height / 2) - (height / 2);
	window.open("../jsp/EmrEhr.jsp", "About EMR and EHR",
			"status = no, height = " + height + ", width =" + width + ",top="
					+ top + ", left=" + left)
}

function fnGetInvestigationTemplate(tempId,opdType) {
	var result = "";
	var icount = 0;	
	for (var i = 0; i < tempId.options.length; i++) {
		opt = tempId.options[i];
		if (opt.selected) {
			result += opt.value + ",";
			icount++;
		}
	}
	if(icount >=2 && setAlert == 0) {
		alert("Note : You have selected more than one priscription templates");
		setAlert = 1;
	}
	if (tempId.value != 0) {
		submitProtoAjaxNew('opdMain',
				"/hms/hms/opd?method=getLabInvestigationTemplate&templateid="
						+ result + "&hinId="
						+ document.getElementById("hinId").value +"&opdType="+opdType + "&"
						+ csrfTokenName + "=" + csrfTokenValue, "labInvDiv");
	}
}

// =========To get Icd String with icd code==========================

function fnCopyToComorbidityTab(diagnosis) {
	jQuery(function($) {
		var action = 1;
		var hospitalId = document.getElementById("hospitalId").value;
		var hinId = document.getElementById("hinId").value;
		var visitId = document.getElementById("visitId").value;
		if (document.getElementById(diagnosis).checked) {
			action = 1;
		} else {
			action = 0;
		}
		$.post('opd?method=saveAndGetTempComorbidity&diagnosis=' + diagnosis
				+ '&visitNo=' + visitId + '&hospitalId=' + hospitalId
				+ '&hinId=' + hinId + '&action=' + action + '&' + csrfTokenName
				+ '=' + csrfTokenValue, function(data) {
			$("#divComorbidity").html(data);
		});
	});

}

function getDetails() {
	var hinId = document.getElementById("hinId").value;
	var visitId = document.getElementById("visitId").value;
	var url = "/hms/hms/opd?method=getTodayOtherPrescription&visitId="
			+ visitId + "&hinId=" + hinId + "&" + csrfTokenName + "="
			+ csrfTokenValue;
	newwindow = window.open(url, 'name', 'height=500,width=800,status=1');
	return false;

}

function previousSystemPatientPrescriptions() {
	var hinNo = document.getElementById("hinNo").value;
	var url = "/hms/hms/opd?method=showPreviousSystemPatientPrescriptions&hinNo="
			+ hinNo + "&" + csrfTokenName + "=" + csrfTokenValue;
	newwindow = window.open(url, 'opd_window',
			"height=300,width=750,status=1,scrollbars=yes");
}

function checkForAlreadyIssuedPrescribtion(val, inc) {
	// var value1 = document.getElementsByName('nomenclature' + inc).value;
	// alert(val+"<<<-------val======inc------>>"+value1);
	var visitId = document.getElementById("visitId").value;
	var prescriptionId =""; 
	
		if(document.getElementById("parkPrescriptionIds"+inc)!=null && document.getElementById("parkPrescriptionIds"+inc).value!="")
	     prescriptionId =document.getElementById("parkPrescriptionIds"+inc).value;
	
	var id;
	if (val != "" && prescriptionId=="") {

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
						document.getElementById('nomenclature' + inc).value = "";
						// document.getElementById('alreadyPres' + inc).value =
						// "Y";
						document.getElementById('tapered' + inc).value = "";
						document.getElementById('route' + inc).value = "0";
						document.getElementById('dosage' + inc).value = "";
						document.getElementById('unit' + inc).value = "";
						document.getElementById('noOfDays' + inc).value = "";
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

function checkReferTO(id, deptId) {

	if (document.getElementById('referInternal').checked == true) {
		document.getElementById('referdistrictLabel').style.display = 'none';
		document.getElementById('referHospitalTypeLabel').style.display = 'none';
		document.getElementById('priorityLabelId').style.display = 'block';
		document.getElementById('priorityId').style.display = 'block';
		document.getElementById('referhospitalLabel').style.display = 'none';
		document.getElementById('referdistrict').style.display = 'none';
		document.getElementById('referHospitalType').style.display = 'none';
		document.getElementById('referhospital').style.display = 'none';
		document.getElementById('refersessionLabel').style.display = 'block';
		document.getElementById('opsession').style.display = 'block';
		document.getElementById("opsession").options.length = 0;
		fnGetHospitalDepartment(document.getElementById("hospitalId").value,
				id, deptId);
	} else {
		document.getElementById('referdistrictLabel').style.display = 'block';
		document.getElementById('referHospitalTypeLabel').style.display = 'block';
		document.getElementById('referhospitalLabel').style.display = 'block'
		document.getElementById('referdistrict').style.display = 'block';
		document.getElementById('referHospitalType').style.display = 'block';
		document.getElementById('referhospital').style.display = 'block';
		document.getElementById('priorityLabelId').style.display = 'none';
		document.getElementById('priorityId').style.display = 'none';
		if (document.getElementById("referCheck") == null) {
			document.getElementById("referdepartment").options.length = 1;
		}
		document.getElementById('refersessionLabel').style.display = 'none';
		document.getElementById('opsession').style.display = 'none';
		document.getElementById("opsession").options.length = 0;
		fnGetHospitalDepartment(document.getElementById("hospitalId").value,
				id, deptId);
	}
}

function ValidateCantra() {
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

		for (; cantraCounter <= $("#hdb").val(); cantraCounter++) {
			if (document.getElementById("nomenclature" + cantraCounter) != undefined
					&& $("#nomenclature" + cantraCounter).val() != "") {
				var nomenclature = $("#nomenclature" + cantraCounter).val();
				var index1 = nomenclature.lastIndexOf("[");
				var index2 = nomenclature.lastIndexOf("]");
				index1++;
				ids = nomenclature.substring(index1, index2) + "," + ids;
				var matchIds = nomenclature.substring(index1, index2)
				var matchPres = nomenclature.substring(0, (index1 - 1));
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

function checkAdmte() {
	var dob = document.getElementById('admissionDate').value;
	adDate = new Date(dob.substring(6), (dob.substring(3, 5) - 1), dob
			.substring(0, 2));
	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);

	if (adDate < currentDate) {
		alert("Admission Date is not valid.");
		document.getElementById('admissionDate').value = document
				.getElementById("consultationDate").value;
		document.getElementById('admissionDate').focus();
		return false;
	}
	return true;

}

function populatePVMS(val, inc) {
	if (val != "") {
		var index1 = val.lastIndexOf("[");
		var indexForBrandName = index1;
		var index2 = val.lastIndexOf("]");
		index1++;
		var pvmsNo = val.substring(index1, index2);
		var indexForBrandName = indexForBrandName--;
		var brandName = val.substring(0, indexForBrandName);

		if (pvmsNo == "") {
			document.getElementById('nomenclature' + inc).value = "";
			document.getElementById('pvmsNo' + inc).value = "";
			document.getElementById('dosage' + inc).value = "";
			document.getElementById('noOfDays' + inc).value = "";
			document.getElementById('unit' + inc).value = "";

			return;
		} else {
			document.getElementById('pvmsNo' + inc).value = pvmsNo;
			document.getElementById('dosage' + inc).value = 1;
			document.getElementById('noOfDays' + inc).value = 1;

			new Ajax.Request(
					'ipd?method=updateItemUnit&pvmsNo=' + pvmsNo + '&'
							+ csrfTokenName + '=' + csrfTokenValue,
					{
						onSuccess : function(response) {
							if (response.responseText.trim() != '') {
								var str = response.responseText.trim().split(
										"###");
								document.getElementById('unit' + inc).value = str[0];
								if (document.getElementById('unitpTab' + inc) != null) {
									document.getElementById('unitpTab' + inc).value = str[0];
								}
								if (document.getElementById('unitLable' + inc) != null) {
									document.getElementById('unitLable' + inc).value = str[1] != undefined ? str[1]
											: "";
								}
								if (document.getElementById('unitLablepTab'
										+ inc) != null) {
									document.getElementById('unitLablepTab'
											+ inc).value = str[1] != undefined ? str[1]
											: "";
								}
								document.getElementById('route' + inc).value = str[2] != undefined ? str[2]
										: "0";
								document.getElementById('tapered' + inc).value = str[3] != undefined ? str[3]
										: "n";

								// added by govind on 20-09-2017 for Tapered
								// Medicine
								if (document.getElementById('tapered' + inc) != null
										&& document.getElementById('tapered'
												+ inc).value == 'y') {
									var nomenclature = document
											.getElementById('nomenclature'
													+ inc).value;
									var index1 = nomenclature.lastIndexOf("[");
									var index2 = nomenclature.lastIndexOf("]");
									index1++;
									var id = nomenclature.substring(index1,
											index2);
									var count = document.getElementById('hdb').value;
									var alrady = 0;
									for (var i = 0; i < count; i++) {
										if (document
												.getElementById('nomenclature'
														+ i) != null
												&& document
														.getElementById('nomenclature'
																+ i).value == nomenclature
												&& i != inc) {
											alert('This Prescription is already selected.');
											alrady++;
											document
													.getElementById('nomenclature'
															+ inc).value = "";
										}

									}
									/*
									 * var alPres=
									 * document.getElementById('alreadyPres' +
									 * inc).value; if(alPres=="Y"){ alrady++; }
									 */
									if (alrady == 0) {
										var first = nomenclature
												.lastIndexOf("(");
										var second = nomenclature
												.lastIndexOf(")");
										first++;
										var itemId = val.substring(first,
												second);
										// alert("itemId "+itemId);
										var url = '/hms/hms/opd?method=showTaperdMedicine&nomenclature='
												+ itemId
												+ '&row='
												+ inc
												+ '&'
												+ csrfTokenName
												+ '='
												+ csrfTokenValue;
										openTaperedMedicine(url);
									}
								}
								// added by govind on 20-09-2017 for Tapered
								// Medicine end

							}
						}
					});
		}
	} else {
		document.getElementById('nomenclature' + inc).value = "";
		document.getElementById('pvmsNo' + inc).value = "";
		document.getElementById('dosage' + inc).value = "";
		document.getElementById('noOfDays' + inc).value = "";
		document.getElementById('unit' + inc).value = "";
	}

}

function checkPayWard() {
	var flag;
	if (document.getElementById("payward").checked) {
		flag = "y";
	} else {
		flag = "n";
	}
	new Ajax.Request(
			'opd?method=getPayward&flag=' + flag + '&' + csrfTokenName + '='
					+ csrfTokenValue,
			{
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						document.getElementById('admissionWard').innerHTML = response.responseText
								.trim();
					}
				}
			});
}
/*
 * function openPopupWindow() { var $ = jQuery.noConflict();
 * //$("#icdName").empty(); //$("#icdName").hide(); $("#divIcdName").hide();
 * $("#snomed").val(""); var url="/hms/hms/adt?method=showICDSearchJsp";
 * newwindow=window.open(url,'opd_window',"left=100,top=100,height=700,width=1024,status=1,scrollbars=yes,resizable=0"); }
 * 
 */

function getTemplate(type, from, frompTab) {
	type="123";
	var localTempl="";
	var personal;
	var local;
	var global;
	
	if(from == 'p')
		{
		personal = "presTempType_personal";
		local = "presTempType_local";
		global = "presTempType_global";
		
		}
	else
		{
		personal = "invTempType_personal";
		local = "invTempType_local";
		global = "invTempType_global";
		}
	
	if(window.opener==null){
	if(document.getElementById(personal).checked){
		type=type.replace("1","y");}
	if(document.getElementById(local).checked){
		type=type.replace("2","y");}
	if(document.getElementById(global).checked){
		type=type.replace("3","y");}
	var tempId="";
	}
	else{
		window.opener.document.getElementById(local).checked = false;
		window.opener.document.getElementById(global).checked = false;
		type="ynn";
	}
	
	
	if(window.opener!=null&&window.opener.document.getElementById("tempLatePrescription")!=null){
	var selTemp = window.opener.document.getElementById("tempLatePrescription");
	if (selTemp.options[selTemp.selectedIndex] != undefined) {
		var tempId = selTemp.options[selTemp.selectedIndex].value;
	}
	}
	new Ajax.Request(
			'opd?method=getTemplate&type=' + type + '&from=' + from +'&tempId='+tempId+ '&'
					+ csrfTokenName + '=' + csrfTokenValue,
			{
				onSuccess : function(response) {
					if (response.responseText.trim() != '') {
						if (from == 'i'){
							if(window.opener!=null && window.opener.document.getElementById('tempLateInvestigation')!=null)
							window.opener.document.getElementById('tempLateInvestigation').innerHTML = response.responseText
									.trim();
							else
								document.getElementById('tempLateInvestigation').innerHTML = response.responseText
								.trim();
						}
						else if (from == 'p' && frompTab == ''){
					if(window.opener!=null && window.opener.document.getElementById('tempLatePrescription')!=null)
							window.opener.document.getElementById('tempLatePrescription').innerHTML = response.responseText
									.trim();
							else
								document.getElementById('tempLatePrescription').innerHTML = response.responseText
								.trim();
						}
						else if (frompTab == 'ptab') {
							document.getElementById('tempLatePrescriptionTab').innerHTML = response.responseText
									.trim();
						}
					}
				}
			});
}

function getAllTemplate() {
	var e1 = document.getElementById('tempLateInvestigation');
	e1.length = 0;
	e1.innerHTML = "";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < tempArrayTemp.length; i++) {
		e1.length++;
		e1.options[e1.length - 1] = new Option(tempArrayTemp[i][1],
				tempArrayTemp[i][0]);
	}
}

function checkPItem(cnt) {

	var tbl = document.getElementById('grid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow - 1;

	// var pvmsNo=document.getElementById("pvmsNo"+iteration).value
	var visitId = document.getElementById("visitId").value
	var nomenclature = document.getElementById("nomenclaturepTab" + cnt).value
	var index1 = nomenclature.lastIndexOf("[");
	var indexForBrandName = index1;
	var index2 = nomenclature.lastIndexOf("]");
	index1++;

	var pvmsNo = nomenclature.substring(index1, index2);
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

				var items = xmlHttp.responseXML.getElementsByTagName('items')[0];
				for (loop = 0; loop < items.childNodes.length; loop++) {
					var item = items.childNodes[loop];
					var stockStstus = item.getElementsByTagName("stock")[0];
					jQuery(function($) {
						if (stockStstus.childNodes[0].nodeValue == '0') {
							$("#nomenclaturepTab" + cnt).css({
								'color' : 'red',
								/*'font-size' : '125%'*/
							});
							$("#prescription_availableStatuspTab" + cnt).val(
									'y');
						} else {
							$("#prescription_availableStatuspTab" + cnt).val(
									'n');
						}
					});
				}
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

function copyToPrescriptionTAb(incr, flag) {

	if (flag == "opconsult") {
		var pTabhdbValue = document.getElementById('pTabhdb').value;
		var hdbValue = document.getElementById('hdb').value;
		if (document.getElementById("nomenclature" + incr).value != "") {
			var tbl1 = document.getElementById('grid');
			var tbl2 = document.getElementById('prescriptionTabGrid');
			var lastRow1 = tbl1.rows.length;
			var lastRow2 = tbl2.rows.length;
			/*
			 * if(pTabhdb<hdbValue) {
			 * document.getElementById('pTabhdb').value=document.getElementById('hdb').value-1; }
			 */

			if (hdbValue > pTabhdbValue) {
				addRowPrescriptionTab();
			}
		}
		if (document.getElementById("nomenclaturepTab" + incr) != null) {
			document.getElementById("nomenclaturepTab" + incr).value = document
					.getElementById("nomenclature" + incr).value;
		}
		if (document.getElementById("dosagepTab" + incr) != null) {
			document.getElementById("dosagepTab" + incr).value = document
					.getElementById("dosage" + incr).value;
		}
		if (document.getElementById("unitpTab" + incr) != null) {
			document.getElementById("unitpTab" + incr).value = document
					.getElementById("unit" + incr).value;
		}
		if (document.getElementById("noOfDayspTab" + incr) != null) {
			document.getElementById("noOfDayspTab" + incr).value = document
					.getElementById("noOfDays" + incr).value;
		}
		if (document.getElementById("routepTab" + incr) != null) {
			document.getElementById("routepTab" + incr).value = document
					.getElementById("route" + incr).value;
		}
	}
}

function checkPrescriptionCheck(iteration) {
	if (document.getElementById("itemRadio" + iteration).checked) {
		if (document.getElementById("itemRadiopTab" + iteration) != null) {
			document.getElementById("itemRadiopTab" + iteration).checked = true;
		}
	} else {
		if (document.getElementById("itemRadiopTab" + iteration) != null) {
			document.getElementById("itemRadiopTab" + iteration).checked = false;
		}
	}
}

function checkItem(cnt) {
	var tbl = document.getElementById('grid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow - 1;

	// var pvmsNo=document.getElementById("pvmsNo"+iteration).value
	var visitId = document.getElementById("visitId").value
	var nomenclature = document.getElementById("nomenclature" + cnt).value
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
							$("#nomenclature" + cnt).css({
								'color' : 'red',
								/*'font-size' : '125%'*/
							});
							$("#nomenclaturepTab" + cnt).css({
								'color' : 'red',
								/*'font-size' : '125%'*/
							});
							$("#prescription_availableStatus" + cnt).val('y');
							$("#prescription_availableStatuspTab" + cnt).val(
									'y');
						} else {
							$("#nomenclature" + cnt).css({
								'color' : 'black',
								/*'font-size' : '125%'*/
							});
							$("#nomenclaturepTab" + cnt).css({
								'color' : 'black',
								/*'font-size' : '125%'*/
							});
							$("#prescription_availableStatuspTab" + cnt).val(
									'n');
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

function validateReferredDate() {
	var dob = document.forms["ospdMain"]["referVisitDate"].value;
	var pattern = /^([0-9]{2})-([0-9]{2})-([0-9]{4})$/;
	if (dob == null || dob == "" || !pattern.test(dob)) {
		alert("Please enter dd-mm-yy!!");
		document.forms["opdMain"]["referVisitDate"].value = "";
		return false;
	} else {
		return true
	}
}

function selectReferBack(val) {

	// alert(val);
	var temp = new Array();
	temp = val.split("@@@");
	var districtId = temp[0];
	var hospitalId = temp[1];
	var deptId = temp[2];
	var referType = temp[3];
	var deptNameforExternal = temp[4];
//	var referredSession = temp[5];
	var referDocId = temp[5];
	var referDocName = temp[6];

	var $ = jQuery.noConflict();

	if (referType == 'NA') {
		// do nothing
	}
	if (referType == 'Internal') {
		$("#referdepartment option[value=" + temp[2] + "]").prop("selected",
				"selected");
		$("#referredSession option[value=" + temp[5] + "]").prop("selected",
		"selected");
	}

	if (referType == 'External') {
		$("#referdistrict option[value=" + temp[0] + "]").prop("selected",
				"selected");
		$("#referhospital option[value=" + temp[1] + "]").prop("selected",
				"selected");
		$("#referdepartment").append(
				"<option value=" + deptId + ">" + deptNameforExternal
						+ "</option>");
		$("#referdepartment option[value=" + temp[2] + "]").prop("selected",
				"selected");
		$("#referredSession option[value=" + temp[5] + "]").prop("selected",
		"selected");
	}
	
	
	         var x = document.getElementById("refereddoctor");
	        x.remove(x.selectedIndex);
	        var option = document.createElement('option');
	        option.value = referDocId;
	        option.text =  referDocName;
	        x.add(option, 0);
	    
	
	getSessionForDepartment(deptId);

	// alert(Id);

}

function selectReferBackOpNursing(val) {

	// alert(val);
	var temp = new Array();
	temp = val.split("@@@");

	var hospitalId = temp[0];
	var deptId = temp[1];
	var referType = 'Internal';
	var deptNameforExternal = temp[2];

	var $ = jQuery.noConflict();

	if (referType == 'NA') {
		// do nothing
	}
	if (referType == 'Internal') {

		/*
		 * $("#referdepartment option[value=" + temp[2] + "]").prop("selected",
		 * "selected");
		 */
		fnGetDoctorDepartmentForNursing(deptId);
	}

	if (referType == 'External') {
		$("#referdistrict option[value=" + temp[0] + "]").prop("selected",
				"selected");
		$("#referhospital option[value=" + temp[1] + "]").prop("selected",
				"selected");
		$("#referdepartment").append(
				"<option value=" + deptId + ">" + deptNameforExternal
						+ "</option>");
		$("#referdepartment option[value=" + temp[2] + "]").prop("selected",
				"selected");
	}

	// alert(Id);

}

function popwindowUploadDocuments(tempId, csrf) {
	var array = new Array();
	array = tempId.split("@@@");
	var hinId = array[0];
	var visitId = array[1];
	var url = "/hms/hms/opd?method=openUploadPopWindow&hinId=" + hinId
			+ "&visitId=" + visitId + "&" + csrf + "&" + csrfTokenName + "="
			+ csrfTokenValue;
	newwindow = window
			.open(url, 'name',
					"left=100,top=100,height=700,width=1024,status=1,scrollbars=1,resizable=0");
}

function openPopupWindowAllergy(csrf) {
	var requestId = document.getElementById("requestId").value.trim();

	window
			.open(
					"/hms/hms/ot?method=showAllergy&requestId=" + requestId
							+ "&" + csrf + "&" + csrfTokenName + "="
							+ csrfTokenValue,
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
}

function openPopupWindowNCDPattern(csrf, hinId) {
	window
			.open(
					"/hms/hms/opd?method=showNCDPattern&hinId=" + hinId + "&"
							+ csrf + "&" + csrfTokenName + "=" + csrfTokenValue,
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
}

function openPopupWindowRNTCPDetail(csrf, hinId, visitId) {
	window
			.open(
					"/hms/hms/opd?method=showRNTCPDetail&hinId=" + hinId + "&visitId="+visitId+ "&"
							+ csrf + "&" + csrfTokenName + "=" + csrfTokenValue,
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
}

function openPopupWindowFpis(csrf, hinId) {
	window
			.open(
					"/hms/hms/opd?method=showFpisRecord&hinId=" + hinId + "&"
							+ csrf + "&" + csrfTokenName + "=" + csrfTokenValue,
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
}

function openPopupWindowPhTravelHistory(surveyId, csrf) {
	// var requestId=document.getElementById("requestId").value.trim();
	var url = "/hms/hms/opd?method=displayTravelHistory&surveyId=" + surveyId
			+ "&" + csrf + "&" + csrfTokenName + "=" + csrfTokenValue;
	newwindow = window
			.open(url, 'name',
					"left=100,top=100,height=700,width=1024,status=1,scrollbars=1,resizable=0");
}

function popwindowResultEntry(tempId) {
	var array = new Array();
	array = tempId.split("@@@");
	var hinId = array[0];
	var visitId = array[1];
	var url = "/hms/hms/investigation?method=showPendingResultEntryTemplateOPD&hinId="
			+ hinId
			+ "&RequisitionFrom=OPD&"
			+ csrfTokenName
			+ '='
			+ csrfTokenValue;
	newwindow = window
			.open(url, 'name',
					"left=100,top=100,height=700,width=1124,status=1,scrollbars=1,resizable=0");
}

function popwindowResultEntryForAntenatal(tempValue) {
	// alert("Hello");
	var array = new Array();
	array = tempValue.split("@@@");
	var hinId = array[0];
	var visitId = array[1];
	var url = "/hms/hms/opd?method=showOutSideResultEntryForAntenatal&hinId="
			+ hinId + "&visitId=" + visitId + "&RequisitionFrom=OPD&"
			+ csrfTokenName + '=' + csrfTokenValue;
	newwindow = window
			.open(url, 'name',
					"left=100,top=100,height=700,width=1124,status=1,scrollbars=1,resizable=0");
}
var newwindow = null;
function popwindowResultEntryForDermotology(tempValue) {
	var array = new Array();
	array = tempValue.split("@@@");
	var hinId = array[0];
	var visitId = array[1];
	var templateFlag = array[2];
	//alert(templateFlag);
	var url = "/hms/hms/opd?method=showOutSideResultEntryDermotology&hinId="
			+ hinId + "&visitId=" + visitId +"&from=1" + "&templateFlag="+templateFlag;
	newwindow = window
			.open(url, 'name',
					"left=170,top=10,height=640,width=1000,status=1,scrollbars=1,resizable=0");
}

function parent_disable() {
    if (newwindow && !newwindow.closed)
    	newwindow.focus();
                 }


function getBedStatus(val) {
	submitProtoAjaxNew('opdMain', 'opd?method=getBedStatus&deptId=' + val,
			'bedDiv');
}
function submitSecondOpinion() {

	opener.fnSubmitPatient('secondop');
	submitForm('secondopinion', '/hms/hms/opd?method=submitSecondOpinion')
	self.close();
}

function openPopupForSaveInvestigation() {
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
				+ '<br/><br/><label>Tamplate Name<span style="color:red;">* </span> </label><input type="text" name="tamplatename" maxlength="30" /><div style="clear:boath;"><div><br/><br/>';
		htmlText += '<table width="100%" border="2" align="center" cellpadding="2" cellspacing="2" style="float:left;" >';
		for (var i = 0; i <= totalRow; i++) {
			if (document.getElementById('chargeCodeName' + i) != null
					&& document.getElementById('chargeCodeName' + i).value != '') {

				if (count == 0) {
					htmlText += '' + '<tr>' + '<th scope="col">Test Name</th>'
							+ '<th scope="col">Clinical Notes</th>'

							+ '</tr>';
				}
				count++;
				htmlText += '' + '<tr>' + '<td>'
				// +'<input type="hidden" name="chargeCode'+count+'"
				// value="'+document.getElementById('chargeCode'+i).value+'" />'
				+ '<input type="hidden" name="chargeCodeName' + count
						+ '" value="'
						+ document.getElementById("chargeCodeName" + i).value
						+ '" />' + ''
						+ document.getElementById("chargeCodeName" + i).value
						+ '</td>' + '<td>'
						+ '<input type="hidden" name="clinicalNotes' + count
						+ '" value="'
						+ document.getElementById("clinicalNotes" + i).value
						+ '" />' + ''
						+ document.getElementById("clinicalNotes" + i).value

						+ '</td>'
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

function openPopupForSavePrescriptiontamplateTab() {
	var totalRow = document.getElementById('pTabhdb').value;
	var htmlText = "";
	var count = 0;
	if (!isNaN(totalRow) && totalRow > 0) {
		htmlText += '<form method="post" action="/hms/hms/opd?method=submitPrescriptionTamplate">'
				+ '<input type="hidden" name="'
				+ csrfTokenName
				+ '"value="'
				+ csrfTokenValue
				+ '"/>'
				+ '<br/><br/><label>Tamplate Name<span style="color:red;">* </span> </label><input type="text" name="tamplatename" maxlength="30" /><div style="clear:boath;"><div><br/><br/>';
		htmlText += '<table border="2" align="center" cellpadding="2" cellspacing="2" style="float:left;" >';
		for (var i = 0; i < totalRow; i++) {

			if (document.getElementById('nomenclaturepTab' + i) != null
					&& document.getElementById('nomenclaturepTab' + i).value != ''
					&& document.getElementById('pvmsNopTab' + i).value != ''
					&& document.getElementById('pvmsNopTab' + i).value != '0') {

				if (count == 0) {
					htmlText += '' + '<tr>' + '<th scope="col">Item Name</th>'
							+ '<th scope="col">Route</th>'
							+ '<th scope="col">Dosage</th>'
							+ '<th scope="col">Frequency</th>'
							+ '<th scope="col">Days</th>'
							+ '<th scope="col">Instruction </th>'
							+ '<th scope="col">Total</th>' + '</tr>';
				}
				count++;
				htmlText += '' + '<tr>' + '<td>'
						+ '<input type="hidden" name="pvms' + count
						+ '" value="'
						+ document.getElementById('pvmsNopTab' + i).value
						+ '" />' + '<input type="hidden" name="nomenclature'
						+ count + '" value="'
						+ document.getElementById('nomenclaturepTab' + i).value
						+ '" />' + ''
						+ document.getElementById('nomenclaturepTab' + i).value;

				htmlText += '<td>' + '<input type="hidden" name="route' + count
						+ '" value="'
						+ document.getElementById('routepTab' + i).value
						+ '" />';
				if (document.getElementById('routepTab' + i).value != 0) {
					// htmlText +='<input type="hidden"
					// name="routename'+count+'"
					// value="'+document.getElementById('routepTab'+i).options[document.getElementById('routepTab'+i).selectedIndex].text+'"
					// />';
					htmlText += '<input type="hidden" name="routename' + count
							+ '" value="'
							+ document.getElementById('routepTab' + i).value
							+ '" />';

					// htmlText
					// +=''+document.getElementById('routepTab'+i).options[document.getElementById('routepTab'+i).selectedIndex].text;

					htmlText += ''
							+ document.getElementById('routepTab' + i).value;
				}

				htmlText += '</td>' + '</td>' + '<td>'
						+ '<input type="hidden" name="dosage' + count
						+ '" value="'
						+ document.getElementById('dosage' + i).value + '" />'
						+ '' + document.getElementById('dosagepTab' + i).value
						+ '</td>' + '<td>'
						+ '<input type="hidden" name="frequency' + count
						+ '" value="'
						+ document.getElementById('frequencypTab' + i).value
						+ '" />';
				if (document.getElementById('frequencypTab' + i).value != 0) {
					htmlText += '<input type="hidden" name="frequencyname'
							+ count
							+ '" value="'
							+ document.getElementById('frequencypTab' + i).options[document
									.getElementById('frequencypTab' + i).selectedIndex].text
							+ '" />';
					htmlText += ''
							+ document.getElementById('frequencypTab' + i).options[document
									.getElementById('frequencypTab' + i).selectedIndex].text;
				}
				htmlText += '</td>' + '<td>'
						+ '<input type="hidden" name="noOfDays' + count
						+ '" value="'
						+ document.getElementById('noOfDayspTab' + i).value
						+ '" />' + ''
						+ document.getElementById('noOfDayspTab' + i).value
						+ '</td>' + '<td>'
						+ '<input type="hidden" name="instrunction' + count
						+ '" value="'
						+ document.getElementById('instrunctionpTab' + i).value
						+ '" />';
				if (document.getElementById('instrunctionpTab' + i).value != 0) {
					htmlText += '<input type="hidden" name="instrunctionname'
							+ count
							+ '" value="'
							+ document.getElementById('instrunctionpTab' + i).options[document
									.getElementById('instrunctionpTab' + i).selectedIndex].text
							+ '" />';

					htmlText += ''
							+ document.getElementById('instrunctionpTab' + i).options[document
									.getElementById('instrunctionpTab' + i).selectedIndex].text;
				}
				htmlText += '<td>' + '<input type="hidden" name="route' + count
						+ '" value="'
						+ document.getElementById('routepTab' + i).value
						+ '" />';
				if (document.getElementById('routepTab' + i).value != 0) {
					htmlText += '<input type="hidden" name="routename'
							+ count
							+ '" value="'
							+ document.getElementById('routepTab' + i).options[document
									.getElementById('routepTab' + i).selectedIndex].text
							+ '" />';

					htmlText += ''
							+ document.getElementById('routepTab' + i).options[document
									.getElementById('routepTab' + i).selectedIndex].text;
				}

				htmlText += '</td>' + '<td>'
						+ '<input type="hidden" name="total' + count
						+ '" value="'
						+ document.getElementById('total' + i).value + '" />'
						+ '' + document.getElementById('total' + i).value;
				htmlText += '</td>'

				+ '</tr>';

			}

		}
		htmlText += '</table>'
				+ '<div style="clear:boath;"><div><br/><br/>'+'<input type=\'hidden\' value=\''+totalRow+'\' id=\'total\' name=\'total\' >'+'<input type="hidden" id="pTabhdb" name="pTabhdb" value="'
				+ count
				+ '" /><br/><br/><div><input type="submit" id="submit" value="Save" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="close" value="Close" onclick="window.close()" /></div>';
		+'</form>';
	}
	// alert(htmlText);
	if (count == 0) {
		alert('Please enter some data to save Tamplate');
	} else {
		var myWindow = window.open("", "saveprescriptionWindow",
				"width=500, height=500");
		myWindow.document
				.write('<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />');
		myWindow.document.write(htmlText);
	}

}

function openPopupForSavePrescriptiontamplate() {
	// alert("govind test openPopupForSavePrescriptiontamplate");
	var totalRow = document.getElementById('hdb').value;
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

	if (!isNaN(totalRow) && totalRow > 0 && tempLatePrescription == 0) {
		// alert("govind tempLatePrescription==0 ");
		htmlText += '<form method="post" action="/hms/hms/opd?method=submitPrescriptionTamplate">'
				+ '<input type="hidden" name="'
				+ csrfTokenName
				+ '"value="'
				+ csrfTokenValue
				+ '"/>'
				+ '<br/><br/><label>Template Name<span style="color:red;">* </span> </label><input type="text" name="tamplatename" maxlength="30" /><div style="clear:boath;"><div><br/><br/>';
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

				htmlText += '<input type="hidden" id="splInstructions' + count
						+ '"name="splInstructions' + count + '"value="'
						+ document.getElementById('splInstrunction' + i).value
						+ '" />' + ''
						+ document.getElementById('splInstrunction' + i).value;
				htmlText += '</td>' + '<td>'

				htmlText += '<input type="hidden" id="total' + count
						+ '" name="total' + count + '" value="'
						+ document.getElementById('total' + i).value + '" />'
						+ '' + document.getElementById('total' + i).value
						+ '</td>';

				+'</tr>';
			}
		}
		htmlText += '</table>'
				+ '<div style="clear:boath;"><div><br/><br/>'+'<input type=\'hidden\' value=\''+(totalRow-1)+'\' id=\'total\' name=\'total\' >'+'<input type="hidden" id="hdb" name="hdb" value="'
				+ count
				+ '" /><br/><br/><div><input type="submit" id="submit" value="Save"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="close" value="Close" onclick="window.close()" /></div>';
		+'</form>';
	}
	var updateVar = 0;
	// added by govind 15-9-2016
	if (!isNaN(totalRow) && totalRow > 0 && tempLatePrescription > 0) {
		updateVar++;
		// alert("govind tempLatePrescription>0 ");
		htmlText += '<form method="post" action="/hms/hms/opd?method=updatePrescriptionTamplate">'
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

				htmlText += '<input type="hidden" id="splInstructions' + count
						+ '"name="splInstructions' + count + '"value="'
						+ document.getElementById('splInstrunction' + i).value
						+ '" />' + ''
						+ document.getElementById('splInstrunction' + i).value;
				htmlText += '</td>' + '<td>'

				htmlText += '<input type="hidden" id="total' + count
						+ '" name="total' + count + '" value="'
						+ document.getElementById('total' + i).value + '" />'
						+ '' + document.getElementById('total' + i).value
						+ '</td>';

				+'</tr>';
			}
		}
		htmlText += '</table>'
				+ '<div style="clear:boath;"><div><br/><br/><input type="hidden" id="hdb" name="hdb" value="'
				+ count
				+ '" /><br/><br/><div><input type="submit" id="submit" value="UPDATE"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="close" value="Close" onclick="window.close()" /></div>';
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

function populateNoOfDaysForNursingProcedure(value, incr) {

	var procedureName_nursing = document.getElementById('procedureName_nursing'
			+ incr).value;

	if (procedureName_nursing) {
		if (value > 0) {
			document.getElementById('noOfDays_nursing' + incr).value = 1;
		}
	}

}

function fillcheckDoseFrequency() {

	var hdb = document.getElementById("hdb").value;

	var i;
	var status = true;

	for (i = 0; i <= hdb; i++) {
		if (document.getElementById("nomenclature" + i) != null) {
			if (document.getElementById("tapered" + i)!=null){
			if (document.getElementById("tapered" + i).value.length==0) {
				var itemName = document.getElementById("nomenclature" + i).value;
				// alert(itemName);
				if (itemName) {
					var res = itemName.split("(");
					if (res) {
						var dosage = document.getElementById("dosage" + i).value;
						if (!dosage) {
							status = false;
							alert("Enter the Dosage")
							return;
						}

						var unit = document.getElementById("unit" + i).value;
						if (unit == "") {
							alert("Unit not available")
							status = false;
							return;
						}
						if (document.getElementById("frequency" + i).selectedIndex == "0") {
							alert("Select Frequency")
							status = false;
							return;
						}

						var noOfDays = document.getElementById("noOfDays" + i).value;

						if (!noOfDays) {
							alert("Enter Days")
							status = false;
							return;
						}

					}
				}
			}}
		}
	}

	return status;

}

function checkForProcedure() {
	var i;
	var procstatus = true;

	var hdb = document.getElementById("nursinghdb").value;

	for (i = 0; i <= hdb; i++) {

		var itemName = document.getElementById("procedureName_nursing" + i).value;

		if (itemName) {
			var res = itemName.split("(");
			if (res) {
				if (document.getElementById("frequency_nursing" + i).selectedIndex == "0") {
					alert("Select Procedure Frequency")
					procstatus = false;

				}

				var noOfDays = document.getElementById("noOfDays_nursing" + i).value;

				if (noOfDays <= 0) {
					alert("Enter Procedure No.Of Days")
					procstatus = false;
				}

			}
		}

	}
	return procstatus;
}

function checkForValidMortuary() {

	var mlscasetype = document.getElementById("mlscasetype");
	var patientExpire = document.getElementById("patient_expire");
	var i;
	var count = 0;
	var mortuaryFlag = false;
	var remainingFlag = false;
	for (i = 0; i < mlscasetype.length; i++) {
		if (mlscasetype.options[i].selected
				&& mlscasetype.options[i].value == 'Mortuary') {
			count++;
			if (patientExpire.checked) {
				mortuaryFlag = true;
				break;
			} else {
				remainingFlag = false;
				break;
			}
		} else if (mlscasetype.options[i].selected) {
			count++;
			remainingFlag = true;
		}

	}

	if (mortuaryFlag)
		return true;
	else if (remainingFlag)
		return true;
	else if (!mortuaryFlag && !remainingFlag && count > 0) {
		alert("Please select Patient is Dead !");
		return false;
	} else if (count == 0)
		return true;

}

function displaySpecialty(splName) {
	document.getElementById("splName").value = splName;
	var cntr = new ddtabcontent("countrytabsIn")
	cntr.setpersist(true)
	cntr.setselectedClassTarget("link")
	cntr.init()
	cntr.expandit(7);

}

function setValueInText(radVal, count) {
	document.getElementById("radioId" + count).value = radVal;
}

// coded by mansi: added by rajendra

function enableSplTextField(obj, count) {

	if (obj.checked) {
		if (document.getElementById('textValue' + count)) {
			document.getElementById('textValue' + count).readOnly = true;
			document.getElementById('textValue' + count).value = '';
		}
		if (document.getElementById('textVal1' + count)) {
			document.getElementById('textVal1' + count).readOnly = true;
			document.getElementById('textVal1' + count).value = '';
		}
	} else {
		if (document.getElementById('textValue' + count)) {
			document.getElementById('textValue' + count).readOnly = false;
			document.getElementById('textValue' + count).value = '';
		}
		if (document.getElementById('textVal1' + count)) {
			document.getElementById('textVal1' + count).readOnly = false;
			document.getElementById('textVal1' + count).value = '';
		}
	}
}

function showEnvironmentYes(val) {
	if (val == "Yes") {
		document.getElementById('divEnvironment').style.display = "inline";
	} else {
		document.getElementById('divEnvironment').style.display = "none";
		document.getElementById('specify').value = '';
		document.getElementById('noOfDays').value = '';
	}
}

function showPreviousAttemptsAtAbstinenceYes(val) {
	if (val == "Yes") {
		document.getElementById('divPreviousAttemptsAtAbstinence').style.display = "inline";
	} else {
		document.getElementById('divPreviousAttemptsAtAbstinence').style.display = "none";

	}
}

function addRowForDrugUseHistory() {
	var tbl = document.getElementById('drugUseHistoryGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('drugUseHistoryCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'drugUseHistoryRadio' + iteration;
	e1.id = 'drugUseHistoryRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'nameOfDrug' + iteration;
	e1.id = 'nameOfDrug' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Alcohol', 'Cannabis');
	e1.options[2] = new Option('Cannabis', 'Cannabis');
	e1.options[3] = new Option('Opiates', 'Opiates');
	e1.options[4] = new Option('Nicotine', 'Nicotine');
	e1.options[5] = new Option('Minor Tranquilizers', 'Minor Tranquilizers');
	e1.options[6] = new Option('Others', 'Others');
	
	e1.onchange=function(){
		chkDrugHistory(this.value,iteration);
	}
	
	cellRight1.appendChild(e1);
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'txtOtherDrugName' + iteration;
	e1.id = 'txtOtherDrugName' + iteration;
	e1.style.display='none';
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'currentUse' + iteration;
	e1.id = 'currentUse' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'yearsOfReqularUse' + iteration;
	e1.id = 'yearsOfReqularUse' + iteration;
	e1.maxLength = 3;
	e1.onkeypress=function(event){
		var iKeyCode = (event.which) ? event.which : event.keyCode
				if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
					return false;

				return true;
	} 

	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'routeDrug' + iteration;
	e1.id = 'routeDrug' + iteration;
	e1.size = '20';
	e1.maxLength = 8;
	cellRight1.appendChild(e1);
}

function removeRowForDrugUseHistory() {
	var tbl = document.getElementById('drugUseHistoryGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('drugUseHistoryCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("drugUseHistoryRadio" + i) != null
				&& (typeof document.getElementById("drugUseHistoryRadio" + i).checked) != 'undefined'
				&& document.getElementById("drugUseHistoryRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("drugUseHistoryRadio" + i) != null
					&& (typeof document.getElementById("drugUseHistoryRadio"
							+ i).checked) != 'undefined'
					&& document.getElementById("drugUseHistoryRadio" + i).checked) {
				var deleteRow = document.getElementById("drugUseHistoryRadio"
						+ i).parentNode.parentNode;
				document.getElementById("drugUseHistoryRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}
function addRowForSymptoms() {
	var tbl = document.getElementById('symptomsGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('symptomsCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'symptomsRadio' + iteration;
	e1.id = 'symptomsRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'symptoms' + iteration;
	e1.id = 'symptoms' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Cough', 'Cough');
	e1.options[2] = new Option('Wheezing', 'Wheezing');
	e1.options[3] = new Option('Breathlessness', 'Breathlessness');
	e1.options[4] = new Option('Chest tightness', 'Chest tightness');
	e1.options[5] = new Option('Chest Pain', 'Chest Pain');
	e1.options[6] = new Option('Exercise Limitation', 'Exercise Limitation');
	e1.options[7] = new Option('Others', 'Others');
	e1.setAttribute("onchange", "symptomsOtherVal(this.value,'"+iteration+"');");
	cellRight1.appendChild(e1);
	
	var ele = document.createElement("div");
    ele.setAttribute("id","showsymptomsOthersDiv" + iteration);
    ele.style.display='none';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.className = "medium";
	e1.name = 'showsymptomsOthers' + iteration;
	e1.id = 'showsymptomsOthers' + iteration;
	e1.maxLength = 16;
	e1.tabIndex ="1";
	ele.appendChild(e1);
	cellRight1.appendChild(ele);
	

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'durationSymptoms' + iteration;
	e1.id = 'durationSymptoms' + iteration;
	// e1.validate = "Duration,int,no";
	e1.setAttribute('validate', 'Duration,float,no');
	e1.onkeypress = function (event) {
		  javascript: return isNumberDecimal(event)
	};
	e1.maxLength = 5;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'frequencySymptoms' + iteration;
	e1.id = 'frequencySymptoms' + iteration;
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event)
	};
	e1.setAttribute('validate', 'Frequency,int,no');
	e1.maxLength = 3;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'remarksSymptoms' + iteration;
	e1.id = 'remarksSymptoms' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);
}

function removeRowForSymptoms() {

	var tbl = document.getElementById('symptomsGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('symptomsCount');
	var iteration = parseInt(hdb.value);

	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("symptomsRadio" + i) != null
				&& (typeof document.getElementById("symptomsRadio" + i).checked) != 'undefined'
				&& document.getElementById("symptomsRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}

	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("symptomsRadio" + i) != null
					&& (typeof document.getElementById("symptomsRadio" + i).checked) != 'undefined'
					&& document.getElementById("symptomsRadio" + i).checked) {
				var deleteRow = document.getElementById("symptomsRadio" + i).parentNode.parentNode;
				document.getElementById("symptomsRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowForCurrentTreatment() {
	var tbl = document.getElementById('currentTreatmentGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('currentTreatmentCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'currentTreatmentRadio' + iteration;
	e1.id = 'currentTreatmentRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'currentTreatment' + iteration;
	e1.id = 'currentTreatment' + iteration;
	e1.maxLength = 50;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'durationCurrentTreatment' + iteration;
	e1.id = 'durationCurrentTreatment' + iteration;
	// e1.validate = "Duration,int,no";
	e1.setAttribute('validate', 'Duration,float,no');
	e1.onkeypress = function (event) {
		  javascript: return isNumberDecimal(event)
	};
	e1.maxLength = 3;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'responseCurrentTreatment' + iteration;
	e1.id = 'responseCurrentTreatment' + iteration;
	e1.size = '20';
	e1.maxLength = 32;
	cellRight1.appendChild(e1);
}
function addRowForTreatmentHistory() {
	var tbl = document.getElementById('treatmentHistoryGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('treatmentHistoryCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'treatmentHistoryRadio' + iteration;
	e1.id = 'treatmentHistoryRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'medications' + iteration;
	e1.id = 'medications' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Bronchodilators', 'Bronchodilators');
	e1.options[2] = new Option('Inhaled steroids', 'Inhaled steroids');
	e1.options[3] = new Option('Oral steroids', 'Oral steroids');
	e1.options[4] = new Option('Antibiotics', 'Antibiotics');
	e1.options[5] = new Option('Anti TB treatment', 'Anti TB treatment');
	e1.options[6] = new Option('Others', 'Others');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'everUsedTreatment' + iteration;
	e1.id = 'everUsedTreatment' + iteration;
	e1.maxLength = 120;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'durationTreatment' + iteration;
	e1.id = 'durationTreatment' + iteration;
	e1.maxLength = 3;
	// e1.validate = "Duration,int,no";
	e1.setAttribute('validate', 'Duration,float,no');
	e1.onkeypress = function (event) {
		  javascript: return isNumberDecimal(event)
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'nameTreatment' + iteration;
	e1.id = 'nameTreatment' + iteration;
	e1.size = '20';
	e1.maxLength = 50;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'responseTreatment' + iteration;
	e1.id = 'responseTreatment' + iteration;
	e1.size = '20';
	e1.maxLength = 50;
	cellRight1.appendChild(e1);
}
function removeRowForTreatmentHistory() {

	var tbl = document.getElementById('treatmentHistoryGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('treatmentHistoryCount');
	var iteration = parseInt(hdb.value);
	alert("lastRow==" + lastRow);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("treatmentHistoryRadio" + i) != null
				&& (typeof document.getElementById("treatmentHistoryRadio" + i).checked) != 'undefined'
				&& document.getElementById("treatmentHistoryRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("treatmentHistoryRadio" + i) != null
					&& (typeof document.getElementById("treatmentHistoryRadio"
							+ i).checked) != 'undefined'
					&& document.getElementById("treatmentHistoryRadio" + i).checked) {
				var deleteRow = document.getElementById("treatmentHistoryRadio"
						+ i).parentNode.parentNode;
				document.getElementById("treatmentHistoryRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowForCurrentTreatment() {

	var tbl = document.getElementById('currentTreatmentGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('currentTreatmentCount');
	var iteration = parseInt(hdb.value);

	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("currentTreatmentRadio" + i) != null
				&& (typeof document.getElementById("currentTreatmentRadio" + i).checked) != 'undefined'
				&& document.getElementById("currentTreatmentRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("currentTreatmentRadio" + i) != null
					&& (typeof document.getElementById("currentTreatmentRadio"
							+ i).checked) != 'undefined'
					&& document.getElementById("currentTreatmentRadio" + i).checked) {
				var deleteRow = document.getElementById("currentTreatmentRadio"
						+ i).parentNode.parentNode;
				document.getElementById("currentTreatmentRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowFamilyHistoryForRelation() {

	var tbl = document.getElementById('familyHistoryGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('familyHistoryCount');
	var iteration = parseInt(hdb.value);

	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("familyHistoryRadio" + i) != null
				&& (typeof document.getElementById("familyHistoryRadio" + i).checked) != 'undefined'
				&& document.getElementById("familyHistoryRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("familyHistoryRadio" + i) != null
					&& (typeof document
							.getElementById("familyHistoryRadio" + i).checked) != 'undefined'
					&& document.getElementById("familyHistoryRadio" + i).checked) {
				var deleteRow = document.getElementById("familyHistoryRadio"
						+ i).parentNode.parentNode;
				document.getElementById("familyHistoryRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowForPrimaryLesionForGeneralProforma(val) {
	var tbl = document.getElementById('primaryLessionGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('primaryLesionCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'primaryLesionRadio' + iteration;
	e1.id = 'primaryLesionRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'primaryLesion' + iteration;
	e1.className = "medium2";
	e1.id = 'primaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Macule', 'Macule');
	e1.options[2] = new Option('Papule', 'Papule');
	e1.options[3] = new Option('Plaque', 'Plaque');
	e1.options[4] = new Option('Nodule', 'Nodule');
	e1.options[5] = new Option('Wheal', 'Wheal');
	e1.options[6] = new Option('Bulla', 'Bulla');
	e1.options[7] = new Option('Pustule', 'Pustule');
	e1.options[8] = new Option('Comedone', 'Comedone');
	e1.options[9] = new Option('Burrow', 'Burrow');
	e1.options[10] = new Option('Tumor', 'Tumor');
	e1.options[11] = new Option('Vesicle', 'Vesicle');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'primaryLesionNo' + iteration;
	e1.className = "medium2";
	e1.id = 'primaryLesionNo' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Single', 'Single');
	e1.options[2] = new Option('Multiple', 'Multiple');
	e1.options[3] = new Option('Generalized', 'Generalized');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('Select');
	e1.className = "medium2";
	e1.name = 'primaryLesionSite' + iteration;
	e1.id = 'primaryLesionSite' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Scalp', 'Scalp');
	e1.options[2] = new Option('Face', 'Face');
	e1.options[3] = new Option('Neck', 'Neck');
	e1.options[4] = new Option('Upper Limb', 'Upper Limb');
	e1.options[5] = new Option('Trunk', 'Trunk');
	e1.options[6] = new Option('Lower Limb', 'Lower Limb');
	
	/*e1.type = 'text';
	e1.className = "medium";
	e1.name = 'primaryLesionSite' + iteration;
	e1.id = 'primaryLesionSite' + iteration;
	e1.maxLength = 32;*/
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name = 'typeOfPrimaryLesion' + iteration;
	e1.style.width = "75px";
	e1.id = 'typeOfPrimaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Discrete', 'Discrete');
	e1.options[2] = new Option('Confluent', 'Confluent');
	cellRight1.appendChild(e1);

	/*
	 * commented by swarup
	 * 
	 * var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.name = 'primaryPigmentation' + iteration;
	e1.style.width = "105px";
	e1.id = 'primaryPigmentation' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	cellRight1.appendChild(e1);
	var e1 = document.createElement('Select');
	e1.name = 'primaryPigmentationValue' + iteration;
	e1.style.width = "105px";
	e1.id = 'primaryPigmentationValue' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Erythematous', 'Erythematous');
	e1.options[2] = new Option('Hypo pigmented', 'Hypo pigmented');
	e1.options[3] = new Option('Hyper pigmented', 'Hyper pigmented');
	e1.options[4] = new Option('De pigmented', 'De pigmented');
	cellRight1.appendChild(e1);*/

	//added by swarup 30-12-2017
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	e1.name = 'primaryPigmentation' + iteration;
	e1.id = 'primaryPigmentation' + iteration;
	e1.style.width = "105px";
	e1.setAttribute("onchange", "displayprimaryPigmentationValue(this.value,'"+iteration+"');");
	cellRight1.appendChild(e1);
	var ele = document.createElement("div");
    ele.setAttribute("id","primaryPigmentationValueDiv" + iteration);
    ele.style.display='none';
    var e1 = document.createElement('Select');
	e1.style.width = "105px"; 
	e1.name = 'primaryPigmentationValue' + iteration;
	e1.id = 'primaryPigmentationValue' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Erythematous', 'Erythematous');
	e1.options[2] = new Option('Violaceous', 'Violaceous');
	e1.options[3] = new Option('Hypo pigmented', 'Hypo pigmented');
	e1.options[4] = new Option('Hyper pigmented', 'Hyper pigmented');
	e1.options[5] = new Option('De pigmented', 'De pigmented');
	ele.appendChild(e1);
	cellRight1.appendChild(ele);
 	
	  var cellRight1 = row.insertCell(6); var e1 =
	 document.createElement('Select'); e1.name = 'primaryCharacter' +
	  iteration; e1.id = 'primaryCharacter' + iteration; e1.options[0] = new
	  Option('Select', ''); e1.options[1] = new Option('Flat', 'Flat');
	  e1.options[2] = new Option('Raised', 'Raised'); 
	  e1.options[3] = new
	  Option('Fluid Filled', 'Fluid Filled'); 
	  e1.options[4] = new
	  Option('Pustule', 'Pustule');
	  e1.className = "smaller";
	  cellRight1.appendChild(e1);
	 
	

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('Select');
	e1.name = 'primaryBorder' + iteration;
	e1.id = 'primaryBorder' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Well defined', 'Well defined');
	e1.options[2] = new Option('Partially Ill Defined', 'Partially Ill Defined');
	e1.options[3] = new Option('Fluid Filled', 'Fluid Filled');
	e1.className = "smaller";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('Select');
	e1.name = 'primarySurface' + iteration;
	e1.className = "smaller";
	e1.id = 'primarySurface' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Smooth', 'Smooth');
	e1.options[2] = new Option('Rough', 'Rough');
	e1.options[3] = new Option('Dry', 'Dry');
	cellRight1.appendChild(e1);

	var dv = document.createElement("div");
	dv.style.width = "155px";
	dv.style.float = "left";
	
	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.className = "medium"
	e1.name = 'primarySmallestSize' + iteration;
	e1.id = 'primarySmallestSize' + iteration;
	e1.maxLength = 10;
	e1.setAttribute('validate', 'Size,int,no');
/*	cellRight1.appendChild(e1)*/;
dv.appendChild(e1);
	
	var e11 = document.createElement('Label');
	e11.name = 'Smallest Lesion' + iteration;
	e11.className = "smallAuto"
	e11.innerHTML = "Smallest Lesion";
	/*cellRight1.appendChild(e11);*/
	dv.appendChild(e11);
	
	var cleardv = document.createElement("div");
	cleardv.className="clear";
	dv.appendChild(cleardv);
	
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.className = "medium"
	e1.name = 'primaryLargestSize' + iteration;
	e1.id = 'primaryLargestSize' + iteration;
	e1.maxLength = 10;
	e1.setAttribute('validate', 'Size,int,no');
	dv.appendChild(e1);
	/*cellRight1.appendChild(e1);*/
	var e12 = document.createElement('Label');
	e12.name = 'Largest Lesion' + iteration;
	e12.className = "smallAuto"
	e12.innerHTML = "Largest Lesion";
	/*cellRight1.appendChild(e12);*/
	dv.appendChild(e12);
	
/*	dv.appendChild(e1);*/
	
	cellRight1.appendChild(dv);
	
	
	
	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('Select');
	e1.name = 'hairOnPrimaryLesion' + iteration;
	e1.className = "medium2"
	e1.id = 'hairOnPrimaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Normal', 'Normal');
	e1.options[2] = new Option('De pigmented', 'De pigmented');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.className = "medium"
	e1.name = 'primaryAdditionalFeature' + iteration;
	e1.id = 'primaryAdditionalFeature' + iteration;
	e1.maxLength = 100;
	cellRight1.appendChild(e1);

}

function removeRowForSecondaryLesion() {
	var tbl = document.getElementById('secondaryLessionGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('secondaryLesionCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 0; i <= iteration; i++) {
		if (document.getElementById("secondaryLesionRadio" + i) != null
				&& (typeof document.getElementById("secondaryLesionRadio" + i).checked) != 'undefined'
				&& document.getElementById("secondaryLesionRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("secondaryLesionRadio" + i) != null
					&& (typeof document.getElementById("secondaryLesionRadio" + i).checked) != 'undefined'
					&& document.getElementById("secondaryLesionRadio" + i).checked) {
				var deleteRow = document.getElementById("secondaryLesionRadio" + i).parentNode.parentNode;
				document.getElementById("secondaryLesionRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowForPrimaryLesion() {
	var tbl = document.getElementById('primaryLessionGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('primaryLesionCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 0; i <= iteration; i++) {
		if (document.getElementById("primaryLesionRadio" + i) != null
				&& (typeof document.getElementById("primaryLesionRadio" + i).checked) != 'undefined'
				&& document.getElementById("primaryLesionRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("primaryLesionRadio" + i) != null
					&& (typeof document.getElementById("primaryLesionRadio" + i).checked) != 'undefined'
					&& document.getElementById("primaryLesionRadio" + i).checked) {
				var deleteRow = document.getElementById("primaryLesionRadio" + i).parentNode.parentNode;
				document.getElementById("primaryLesionRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}
function addRowForPrimaryLesion(val) {
	var tbl = document.getElementById('primaryLessionGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('primaryLesionCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'primaryLesionRadio' + iteration;
	e1.id = 'primaryLesionRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	if (val == 'General Performa') {
		var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('Select');
		e1.name = 'primaryLesion' + iteration;
		e1.id = 'primaryLesion' + iteration;
		e1.options[0] = new Option('Select', '');
		e1.options[1] = new Option('Macule', 'Macule');
		e1.options[2] = new Option('Papule', 'Papule');
		e1.options[3] = new Option('Plaque', 'Plaque');
		e1.options[4] = new Option('Nodule', 'Nodule');
		e1.options[5] = new Option('Wheal', 'Wheal');
		e1.options[6] = new Option('Bulla', 'Bulla');
		e1.options[7] = new Option('Pustule', 'Pustule');
		e1.options[8] = new Option('Comedone', 'Comedone');
		e1.options[9] = new Option('Burrow', 'Burrow');
		e1.options[10] = new Option('Tumor', 'Tumor');
		e1.options[11] = new Option('Vesicle', 'Vesicle');
		cellRight1.appendChild(e1);

	} else if (val == 'Vesiculo-bullous disorders') {
		var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('Select');
		e1.name = 'primaryLesion' + iteration;
		e1.id = 'primaryLesion' + iteration;
		e1.options[0] = new Option('Select', '');
		e1.options[1] = new Option('Macule', 'Macule');
		e1.options[2] = new Option('Papule', 'Papule');
		e1.options[3] = new Option('Plaque', 'Plaque');
		e1.options[4] = new Option('Nodule', 'Nodule');
		e1.options[5] = new Option('Wheal', 'Wheal');
		e1.options[6] = new Option('Bulla', 'Bulla');
		e1.options[7] = new Option('Pustule', 'Pustule');
		e1.options[8] = new Option('Vesicle', 'Vesicle');
		e1.options[9] = new Option('Haemorrhagic', 'Haemorrhagic');
		cellRight1.appendChild(e1);

	}

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'primaryLesionNo' + iteration;
	e1.id = 'primaryLesionNo' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Single', 'Single');
	e1.options[2] = new Option('Multiple', 'Multiple');
	e1.options[3] = new Option('Generalized', 'Generalized');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'primaryLesionSite' + iteration;
	e1.id = 'primaryLesionSite' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name = 'typeOfPrimaryLesion' + iteration;
	e1.id = 'typeOfPrimaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Discrete', 'Discrete');
	e1.options[2] = new Option('Confluent', 'Confluent');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.name = 'primaryPigmentation' + iteration;
	e1.id = 'primaryPigmentation' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	cellRight1.appendChild(e1);
	var e1 = document.createElement('Select');
	e1.name = 'primaryPigmentationValue' + iteration;
	e1.id = 'primaryPigmentationValue' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Erythematous', 'Erythematous');
	e1.options[2] = new Option('Hypo pigmented', 'Hypo pigmented');
	e1.options[3] = new Option('Hyper pigmented', 'Hyper pigmented');
	e1.options[4] = new Option('De pigmented', 'De pigmented');
	cellRight1.appendChild(e1);

	/*
	 * var cellRight1 = row.insertCell(6); var e1 =
	 * document.createElement('Select'); e1.name = 'primaryCharacter' +
	 * iteration; e1.id = 'primaryCharacter' + iteration; e1.options[0] = new
	 * Option('Select', ''); e1.options[1] = new Option('Flat', 'Flat');
	 * e1.options[2] = new Option('Raised', 'Raised'); e1.options[3] = new
	 * Option('Fluid Filled', 'Fluid Filled'); cellRight1.appendChild(e1);
	 */

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('Select');
	e1.name = 'primaryBorder' + iteration;
	e1.id = 'primaryBorder' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Well defined', 'Well defined');
	e1.options[2] = new Option('Partially Ill Defined', 'Partially Ill Defined');
	e1.options[3] = new Option('Fluid Filled', 'Fluid Filled');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('Select');
	e1.name = 'primarySurface' + iteration;
	e1.id = 'primarySurface' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Smooth', 'Smooth');
	e1.options[2] = new Option('Rough', 'Rough');
	e1.options[3] = new Option('Dry', 'Dry');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'primarySmallestSize' + iteration;
	e1.id = 'primarySmallestSize' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);
	var e11 = document.createElement('Label');
	e11.name = 'Smallest Lesion' + iteration;
	e11.innerHTML = "Smallest Lesion";
	cellRight1.appendChild(e11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'primaryLargestSize' + iteration;
	e1.id = 'primaryLargestSize' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);
	var e12 = document.createElement('Label');
	e12.name = 'Largest Lesion' + iteration;
	e12.innerHTML = "Largest Lesion";
	cellRight1.appendChild(e12);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('Select');
	e1.name = 'hairOnPrimaryLesion' + iteration;
	e1.id = 'hairOnPrimaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Normal', 'Normal');
	e1.options[2] = new Option('De pigmented', 'De pigmented');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('Select');
	e1.name = 'primaryAggravatingFactors' + iteration;
	e1.id = 'primaryAggravatingFactors' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Sweating', 'Sweating');
	e1.options[2] = new Option('Sun exposure', 'Sun exposure');
	e1.options[3] = new Option('Topical Application', 'Topical Application');
	e1.options[4] = new Option('Others-Option to capture',
			'Others-Option to capture');
	cellRight1.appendChild(e1);

}

function addRowForPrimaryLesionVesiculoTemplate(val) {
	var tbl = document.getElementById('primaryLessionGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('primaryLesionCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'primaryLesionRadio' + iteration;
	e1.id = 'primaryLesionRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'primaryLesion' + iteration;
	e1.id = 'primaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Macule', 'Macule');
	e1.options[2] = new Option('Papule', 'Papule');
	e1.options[3] = new Option('Plaque', 'Plaque');
	e1.options[4] = new Option('Nodule', 'Nodule');
	e1.options[5] = new Option('Wheal', 'Wheal');
	e1.options[6] = new Option('Bulla', 'Bulla');
	e1.options[7] = new Option('Pustule', 'Pustule');
	e1.options[8] = new Option('Vesicle', 'Vesicle');
	e1.options[9] = new Option('Haemorrhagic', 'Haemorrhagic');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'primaryLesionNo' + iteration;
	e1.id = 'primaryLesionNo' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Single', 'Single');
	e1.options[2] = new Option('Multiple', 'Multiple');
	e1.options[3] = new Option('Generalized', 'Generalized');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'primaryLesionSite' + iteration;
	e1.id = 'primaryLesionSite' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name = 'typeOfPrimaryLesion' + iteration;
	e1.id = 'typeOfPrimaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Discrete', 'Discrete');
	e1.options[2] = new Option('Confluent', 'Confluent');
	e1.options[3] = new Option('Grooping', 'Grooping');
	cellRight1.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'typeOfLesionValue' + iteration;
	e1.id = 'typeOfLesionValue' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

	/*
	 * var cellRight1 = row.insertCell(5); var e1 =
	 * document.createElement('Select'); e1.name = 'primaryPigmentation' +
	 * iteration; e1.id = 'primaryPigmentation' + iteration; e1.options[0] = new
	 * Option('Select', ''); e1.options[1] = new Option('Yes', 'Yes');
	 * e1.options[2] = new Option('No', 'No'); cellRight1.appendChild(e1); var
	 * e1 = document.createElement('Select'); e1.name =
	 * 'primaryPigmentationValue' + iteration; e1.id =
	 * 'primaryPigmentationValue' + iteration; e1.options[0] = new
	 * Option('Select', ''); e1.options[1] = new Option('Erythematous',
	 * 'Erythematous'); e1.options[2] = new Option('Hypo pigmented', 'Hypo
	 * pigmented'); e1.options[3] = new Option('Hyper pigmented', 'Hyper
	 * pigmented'); e1.options[4] = new Option('De pigmented', 'De pigmented');
	 * cellRight1.appendChild(e1);
	 */

	/*
	 * var cellRight1 = row.insertCell(6); var e1 =
	 * document.createElement('Select'); e1.name = 'primaryCharacter' +
	 * iteration; e1.id = 'primaryCharacter' + iteration; e1.options[0] = new
	 * Option('Select', ''); e1.options[1] = new Option('Flat', 'Flat');
	 * e1.options[2] = new Option('Raised', 'Raised'); e1.options[3] = new
	 * Option('Fluid Filled', 'Fluid Filled'); cellRight1.appendChild(e1);
	 */

	/*
	 * var cellRight1 = row.insertCell(6); var e1 =
	 * document.createElement('Select'); e1.name = 'primaryBorder' + iteration;
	 * e1.id = 'primaryBorder' + iteration; e1.options[0] = new Option('Select',
	 * ''); e1.options[1] = new Option('Well defined', 'Well defined');
	 * e1.options[2] = new Option('Partially Ill Defined', 'Partially Ill
	 * Defined'); e1.options[3] = new Option('Fluid Filled', 'Fluid Filled');
	 * cellRight1.appendChild(e1);
	 * 
	 * var cellRight1 = row.insertCell(7); var e1 =
	 * document.createElement('Select'); e1.name = 'primarySurface' + iteration;
	 * e1.id = 'primarySurface' + iteration; e1.options[0] = new
	 * Option('Select', ''); e1.options[1] = new Option('Smooth', 'Smooth');
	 * e1.options[2] = new Option('Rough', 'Rough'); e1.options[3] = new
	 * Option('Dry', 'Dry'); cellRight1.appendChild(e1);
	 */

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'primarySmallestSize' + iteration;
	e1.id = 'primarySmallestSize' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);
	var e11 = document.createElement('Label');
	e11.name = 'Smallest Lesion' + iteration;
	e11.innerHTML = "Smallest Lesion";
	cellRight1.appendChild(e11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'primaryLargestSize' + iteration;
	e1.id = 'primaryLargestSize' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);
	var e12 = document.createElement('Label');
	e12.name = 'Largest Lesion' + iteration;
	e12.innerHTML = "Largest Lesion";
	cellRight1.appendChild(e12);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('Select');
	e1.name = 'hairOnPrimaryLesion' + iteration;
	e1.id = 'hairOnPrimaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Normal', 'Normal');
	e1.options[2] = new Option('De pigmented', 'De pigmented');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'primaryAdditionalFeature' + iteration;
	e1.id = 'primaryAdditionalFeature' + iteration;
	cellRight1.appendChild(e1);

}

function addRowForSecondaryLesion() {
	var tbl = document.getElementById('secondaryLessionGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('secondaryLesionCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'secondaryLesionRadio' + iteration;
	e1.id = 'secondaryLesionRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'secondaryLesion' + iteration;
	e1.className = "medium2";
	e1.id = 'secondaryLesion' + iteration;

	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Erosion', 'Erosion');
	e1.options[2] = new Option('Ulcer', 'Ulcer');
	e1.options[3] = new Option('Scale', 'Scale');
	e1.options[4] = new Option('Crust', 'Crust');
	e1.options[5] = new Option('Lichenification', 'Lichenification');
	e1.options[6] = new Option('Vesicle', 'Vesicle');

	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'secondaryLesionNo' + iteration;
	e1.className = "medium2";
	e1.id = 'secondaryLesionNo' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Single', 'Single');
	e1.options[2] = new Option('Multiple', 'Multiple');
	e1.options[3] = new Option('Generalized', 'Generalized');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('Select');
	e1.className = "medium2";
	e1.name = 'secondaryLesionSite' + iteration;
	e1.id = 'secondaryLesionSite' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Scalp', 'Scalp');
	e1.options[2] = new Option('Face', 'Face');
	e1.options[3] = new Option('Neck', 'Neck');
	e1.options[4] = new Option('Upper Limb', 'Upper Limb');
	e1.options[5] = new Option('Trunk', 'Trunk');
	e1.options[6] = new Option('Lower Limb', 'Lower Limb');
	/*e1.type = 'text';
	e1.className = "medium";
	e1.name = 'secondaryLesionSite' + iteration;
	e1.id = 'secondaryLesionSite' + iteration;
	e1.maxLength = '32';*/
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name = 'typeOfSecondaryLesion' + iteration;
	e1.className = "medium2";
	e1.id = 'typeOfSecondaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Discrete', 'Discrete');
	e1.options[2] = new Option('Confluent', 'Confluent');
	cellRight1.appendChild(e1);

	/*var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.name = 'secondaryPigmentation' + iteration;
	e1.style.width = "105px";
	e1.id = 'secondaryPigmentation' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	cellRight1.appendChild(e1);
	var e1 = document.createElement('Select');
	e1.name = 'secondaryPigmentationValue' + iteration;
	e1.id = 'secondaryPigmentationValue' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.style.width = "105px";
	e1.options[1] = new Option('Erythematous', 'Erythematous');
	e1.options[2] = new Option('Hypo pigmented', 'Hypo pigmented');
	e1.options[3] = new Option('Hyper pigmented', 'Hyper pigmented');
	e1.options[4] = new Option('De pigmented', 'De pigmented');
	cellRight1.appendChild(e1);*/
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	e1.name = 'secondaryPigmentation' + iteration;
	e1.id = 'secondaryPigmentation' + iteration;
	e1.style.width = "105px";
	e1.setAttribute("onchange", "displaysecondaryPigmentationValue(this.value,'"+iteration+"');");
	cellRight1.appendChild(e1);
	var ele = document.createElement("div");
    ele.setAttribute("id","secondaryPigmentationValueDiv" + iteration);
    ele.style.display='none';
    var e1 = document.createElement('Select');
	e1.style.width = "105px"; 
	e1.name = 'secondaryPigmentationValue' + iteration;
	e1.id = 'secondaryPigmentationValue' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Erythematous', 'Erythematous');
	e1.options[2] = new Option('Violaceous', 'Violaceous');
	e1.options[3] = new Option('Hypo pigmented', 'Hypo pigmented');
	e1.options[4] = new Option('Hyper pigmented', 'Hyper pigmented');
	e1.options[5] = new Option('De pigmented', 'De pigmented');
	e1.tabIndex ="1";
	ele.appendChild(e1);
	cellRight1.appendChild(ele);


	/*var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('Select');
	e1.name = 'secondaryCharacter' + iteration;
	e1.id = 'secondaryCharacter' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Flat', 'Flat');
	e1.options[2] = new Option('Raised', 'Raised');
	e1.options[3] = new Option('Ill Defined', 'Ill Defined');
	cellRight1.appendChild(e1);*/

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('Select');
	e1.name = 'secondaryBorder' + iteration;
	e1.id = 'secondaryBorder' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Well defined', 'Well defined');
	e1.options[2] = new Option('Partially Ill Defined', 'Partially Ill Defined');
	e1.options[3] = new Option('Ill Defined', 'Ill Defined');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('Select');
	e1.name = 'secondarySurface' + iteration;
	e1.className = "smaller";
	e1.id = 'secondarySurface' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Smooth', 'Smooth');
	e1.options[2] = new Option('Rough', 'Rough');
	e1.options[3] = new Option('Dry', 'Dry');
	cellRight1.appendChild(e1);

	
	var dv = document.createElement("div");
	dv.style.width = "155px";
	dv.style.float = "left";
	
	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.className = "medium";
	e1.name = 'secondarySmallestSize' + iteration;
	e1.id = 'secondarySmallestSize' + iteration;
	e1.maxLength = '10';
	e1.setAttribute('validate', 'Size,int,no');
	/*cellRight1.appendChild(e1);*/
	dv.appendChild(e1);
	
	var e11 = document.createElement('Label');
	e11.name = 'Smallest Lesion' + iteration;
	e11.className = "smallAuto";
	e11.innerHTML = "Smallest Lesion";
	/*cellRight1.appendChild(e11);*/
	dv.appendChild(e11);
	
	var cleardv = document.createElement("div");
	cleardv.className="clear";
	dv.appendChild(cleardv);
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.className = "medium";
	e1.name = 'secondaryLargestSize' + iteration;
	e1.id = 'secondaryLargestSize' + iteration;
	e1.maxLength = '10';
	e1.setAttribute('validate', 'Size,int,no');
	/*cellRight1.appendChild(e1);*/
	dv.appendChild(e1);
	
	var e12 = document.createElement('Label');
	e12.name = 'Largest Lesion' + iteration;
	e12.className = "smallAuto";
	e12.innerHTML = "Largest Lesion";
	/*cellRight1.appendChild(e12);*/
	dv.appendChild(e12);
	cellRight1.appendChild(dv);
	
	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('Select');
	e1.name = 'hairOnSecondaryLesion' + iteration;
	e1.className = "medium2";
	e1.id = 'hairOnSecondaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Normal', 'Normal');
	e1.options[2] = new Option('De pigmented', 'De pigmented');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.className = "medium";
	e1.name = 'secondaryAdditionalFeature' + iteration;
	e1.id = 'secondaryAdditionalFeature' + iteration;
	e1.maxLength = 100;
	cellRight1.appendChild(e1);

}

function getOralCavityWnl(val) {
	if (document.getElementById("oralCavityWnl").checked) {
		document.getElementById("oralCavity").style.display = "inline";

	} else {
		document.getElementById("oralCavity").style.display = "none";

	}

}

function getTongueWnl(val) {
	if (document.getElementById("tongueWnl").checked) {
		document.getElementById("tongue").style.display = "inline";

	} else {
		document.getElementById("tongue").style.display = "none";

	}

}

function getThroatWnl(val) {
	if (document.getElementById("throatWnl").checked) {
		document.getElementById("throat").style.display = "inline";

	} else {
		document.getElementById("throat").style.display = "none";

	}

}

function getAbdomenWnl(val) {
	if (document.getElementById("abdomenWnl").checked) {
		document.getElementById("abdomen").style.display = "inline";

	} else {
		document.getElementById("abdomen").style.display = "none";

	}

}

function getRenalAnglesWnl(val) {
	if (document.getElementById("renalAnglesWnl").checked) {
		document.getElementById("renalAngles").style.display = "inline";

	} else {
		document.getElementById("renalAngles").style.display = "none";

	}

}

function getTraubeSpaceWnl(val) {
	if (document.getElementById("traubeSpaceWnl").checked) {
		document.getElementById("traubeSpace").style.display = "inline";

	} else {
		document.getElementById("traubeSpace").style.display = "none";

	}

}

function getPrExaminationWnl(val) {
	if (document.getElementById("prExaminationWnl").checked) {
		document.getElementById("prExamination").style.display = "inline";

	} else {
		document.getElementById("prExamination").style.display = "none";

	}

}

function getExternalGenitaliaWnl(val) {
	if (document.getElementById("externalGenitaliaWnl").checked) {
		document.getElementById("externalGenitalia").style.display = "inline";

	} else {
		document.getElementById("externalGenitalia").style.display = "none";

	}

}

function getsoundsWnl(val) {
	if (document.getElementById("soundsWnl").checked) {
		document.getElementById("sounds").style.display = "inline";

	} else {
		document.getElementById("sounds").style.display = "none";

	}

}

function addRowFamilyHistoryForRelation() {
	var tbl = document.getElementById('familyHistoryGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('familyHistoryCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'familyHistoryRadio' + iteration;
	e1.id = 'familyHistoryRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'relation' + iteration;
	e1.id = 'relation' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Mother', 'Mother');
	e1.options[2] = new Option('Father', 'Father');
	e1.options[3] = new Option('Sibilings', 'Sibilings');
	e1.options[4] = new Option('2° relatives', '2  relatives');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'asthma' + iteration;
	e1.id = 'asthma' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('Select');
	e1.name = 'nasalAllergy' + iteration;
	e1.id = 'nasalAllergy' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name = 'eczema' + iteration;
	e1.id = 'eczema' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.name = 'foodAllergy' + iteration;
	e1.id = 'foodAllergy' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	cellRight1.appendChild(e1);
}

function addRowForPeripheralNerve() {
	var tbl = document.getElementById('peripheralNerveGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('nerveCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'srNo' + iteration;
	e1.id = 'srNo' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'nerve' + iteration;
	e1.id = 'nerve' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Supraorbital', 'Supraorbital');
	e1.options[2] = new Option('Supratrochlear', 'Supratrochlear');
	e1.options[3] = new Option('Infraorbital', 'Infraorbital');
	e1.options[4] = new Option('Infratrochlear', 'Infratrochlear');
	e1.options[5] = new Option('Greater auricular', 'Greater auricular');
	e1.options[6] = new Option('Transverse Cervical', 'Transverse Cervical');
	e1.options[7] = new Option('Supraclavicular', 'Supraclavicular');
	e1.options[8] = new Option('Radial', 'Radial');
	e1.options[9] = new Option('Ulnar', 'Ulnar');
	e1.options[10] = new Option('Median', 'Median');
	e1.options[11] = new Option('Radial cutaneous', 'Radial cutaneous');
	e1.options[12] = new Option('Common peroneal', 'Common peroneal');
	e1.options[13] = new Option('Superficial peroneal', 'Superficial peroneal');
	e1.options[14] = new Option('Sural', 'Sural');
	e1.options[15] = new Option('Saphenous', 'Saphenous');
	e1.options[16] = new Option('Tibial', 'Tibial');
	e1.options[17] = new Option('Perilesional Nerve Twigs',
			'Perilesional Nerve Twigs');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'rightNerve' + iteration;
	e1.id = 'rightNerve' + iteration;
	e1.maxLength = 30;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'leftNerve' + iteration;
	e1.id = 'leftNerve' + iteration;
	e1.size = '20';
	e1.maxLength = 30;
	cellRight1.appendChild(e1);
}

function addFamilyHistoryRelation() {
	var tbl = document.getElementById('familyHistoryGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('familyHistoryCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'srNo' + iteration;
	e1.id = 'srNo' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'relation' + iteration;
	e1.id = 'relation' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Mother', 'Mother');
	e1.options[2] = new Option('Father', 'Father');
	e1.options[3] = new Option('Son', 'Son');
	e1.options[4] = new Option('Daughter', 'Daughter');
	e1.options[5] = new Option('Uncle', 'Uncle');
	e1.options[6] = new Option('Aunt', 'Aunt');
	e1.options[7] = new Option('Grand Father', 'Grand Father');
	e1.options[8] = new Option('Grand Mother', 'Grand Mother');
	e1.options[9] = new Option('Others', 'Others');
	e1.addEventListener("change", function(e) {
		displayFamilyHistoryLeprosyOther(iteration);
		  }, false);
	
	
	cellRight1.appendChild(e1);		
	
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'familyHistoryLeprosyOthers' + iteration;
	e1.id = 'familyHistoryLeprosyOthers' + iteration;
	e1.style.display = 'none';
	e1.maxLength = 32;
	cellRight1.appendChild(e1);
	
	
	


	/*var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'familyHistoryLeprosyOthers' + iteration;
	e1.id = 'familyHistoryLeprosyOthers' + iteration;
	e1.size = '20';
	e1.maxLength = 128;
	cellRight1.appendChild(e1);*/
	
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.type = 'text';
	e1.name = 'leprosyType' + iteration;
	e1.id = 'leprosyType' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('PB', 'PB');
	e1.options[2] = new Option('MB', 'MB');
	e1.options[3] = new Option('I', 'I');
	e1.options[4] = new Option('TT', 'TT');
	e1.options[5] = new Option('BT', 'BT');
	e1.options[6] = new Option('BB', 'BB');
	e1.options[7] = new Option('BL', 'BL');
	e1.options[8] = new Option('LL', 'LL');
	e1.options[9] = new Option('PN', 'PN');
	cellRight1.appendChild(e1);

}

function addSensoryExamination() {
	var tbl = document.getElementById('sensoryGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('sensoryCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'srNo' + iteration;
	e1.id = 'srNo' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'site' + iteration;
	e1.id = 'site' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Face', 'Face');
	e1.options[2] = new Option('Upper Limb', 'Upper Limb');
	e1.options[3] = new Option('Anterior Trunk', 'Anterior Trunk');
	e1.options[4] = new Option('Posterior Trunk', 'Posterior Trunk');
	e1.options[5] = new Option('Lower Limb', 'Lower Limb');
	cellRight1.appendChild(e1);

	//As per vivin sir commented by abhishek 20/11/2017 
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'temperature' + iteration;
	e1.id = 'temperature' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'touch' + iteration;
	e1.id = 'touch' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'pain' + iteration;
	e1.id = 'pain' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

}
/*
 * function addRowForPeripheralNerve() { var tbl =
 * document.getElementById('peripheralNerveGrid'); var lastRow =
 * tbl.rows.length; var iteration = lastRow; var row = tbl.insertRow(lastRow);
 * var hdb = document.getElementById('nerveCount'); iteration =
 * parseInt(hdb.value) + 1; hdb.value = iteration;
 * 
 * var cellRight1 = row.insertCell(0); var e1 = document.createElement('input');
 * e1.type = 'checkbox'; e1.name = 'srNo' + iteration; e1.id = 'srNo' +
 * iteration; e1.className = 'radioCheck'; cellRight1.appendChild(e1);
 * 
 * var cellRight1 = row.insertCell(1); var e1 =
 * document.createElement('Select'); e1.name = 'nerve' + iteration; e1.id =
 * 'nerve' + iteration; e1.options[0] = new Option('Select', ''); e1.options[1] =
 * new Option('Supraorbital', 'Supraorbital'); e1.options[2] = new
 * Option('Supratrochlear', 'Supratrochlear'); e1.options[3] = new
 * Option('Infraorbital', 'Infraorbital'); e1.options[4] = new
 * Option('Infratrochlear', 'Infratrochlear'); e1.options[5] = new
 * Option('Greater auricular', 'Greater auricular'); e1.options[6] = new
 * Option('Transverse Cervical', 'Transverse Cervical'); e1.options[7] = new
 * Option('Supraclavicular', 'Supraclavicular'); e1.options[8] = new
 * Option('Radial', 'Radial'); e1.options[9] = new Option('Ulnar', 'Ulnar');
 * e1.options[10] = new Option('Median', 'Median'); e1.options[11] = new
 * Option('Radial cutaneous', 'Radial cutaneous'); e1.options[12] = new
 * Option('Common peroneal', 'Common peroneal'); e1.options[13] = new
 * Option('Superficial peroneal', 'Superficial peroneal'); e1.options[14] = new
 * Option('Sural', 'Sural'); e1.options[15] = new Option('Saphenous',
 * 'Saphenous'); e1.options[16] = new Option('Tibial', 'Tibial');
 * cellRight1.appendChild(e1);
 * 
 * var cellRight1 = row.insertCell(2); var e1 = document.createElement('input');
 * e1.type = 'text'; e1.name = 'rightNerve' + iteration; e1.id = 'rightNerve' +
 * iteration; e1.maxLength = 30; cellRight1.appendChild(e1);
 * 
 * var cellRight1 = row.insertCell(3); var e1 = document.createElement('input');
 * e1.type = 'text'; e1.name = 'leftNerve' + iteration; e1.id = 'leftNerve' +
 * iteration; e1.size = '20'; e1.maxLength = 30; cellRight1.appendChild(e1); }
 */

/*
 * function addFamilyHistoryRelation() { var tbl =
 * document.getElementById('familyHistoryGrid'); var lastRow = tbl.rows.length;
 * var iteration = lastRow; var row = tbl.insertRow(lastRow); var hdb =
 * document.getElementById('familyHistoryCount'); iteration =
 * parseInt(hdb.value) + 1; hdb.value = iteration;
 * 
 * var cellRight1 = row.insertCell(0); var e1 = document.createElement('input');
 * e1.type = 'checkbox'; e1.name = 'srNo' + iteration; e1.id = 'srNo' +
 * iteration; e1.className = 'radioCheck'; cellRight1.appendChild(e1);
 * 
 * var cellRight1 = row.insertCell(1); var e1 =
 * document.createElement('Select'); e1.name = 'relation' + iteration; e1.id =
 * 'relation' + iteration; e1.options[0] = new Option('Select', '');
 * e1.options[1] = new Option('Mother', 'Mother'); e1.options[2] = new
 * Option('Father', 'Father'); e1.options[3] = new Option('Son', 'Son');
 * e1.options[4] = new Option('Daughter', 'Daughter'); e1.options[5] = new
 * Option('Uncle', 'Uncle'); e1.options[6] = new Option('Aunt', 'Aunt');
 * cellRight1.appendChild(e1);
 * 
 * var cellRight1 = row.insertCell(2); var e1 =
 * document.createElement('Select'); e1.type = 'text'; e1.name = 'leprosyType' +
 * iteration; e1.id = 'leprosyType' + iteration; e1.options[0] = new
 * Option('Select', ''); e1.options[1] = new Option('PB', 'PB'); e1.options[2] =
 * new Option('MB', 'MB'); e1.options[3] = new Option('I', 'I'); e1.options[4] =
 * new Option('TT', 'TT'); e1.options[5] = new Option('BT', 'BT'); e1.options[6] =
 * new Option('BB', 'BB'); e1.options[7] = new Option('BL', 'BL'); e1.options[8] =
 * new Option('LL', 'LL'); e1.options[9] = new Option('PN', 'PN');
 * cellRight1.appendChild(e1);
 *  }
 */

function removeSensoryExamination() {
	var tbl = document.getElementById('sensoryGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('sensoryCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 0; i <= iteration; i++) {
		if (document.getElementById("srNo" + i) != null
				&& (typeof document.getElementById("srNo" + i).checked) != 'undefined'
				&& document.getElementById("srNo" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("srNo" + i) != null
					&& (typeof document.getElementById("srNo" + i).checked) != 'undefined'
					&& document.getElementById("srNo" + i).checked) {
				var deleteRow = document.getElementById("srNo" + i).parentNode.parentNode;
				document.getElementById("srNo" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowForPeripheralNerve() {
	var tbl = document.getElementById('peripheralNerveGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('nerveCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 0; i <= iteration; i++) {
		if (document.getElementById("srNo" + i) != null
				&& (typeof document.getElementById("srNo" + i).checked) != 'undefined'
				&& document.getElementById("srNo" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("srNo" + i) != null
					&& (typeof document.getElementById("srNo" + i).checked) != 'undefined'
					&& document.getElementById("srNo" + i).checked) {
				var deleteRow = document.getElementById("srNo" + i).parentNode.parentNode;
				document.getElementById("srNo" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}


function removeFamilyHistory() {
	var tbl = document.getElementById('familyHistoryGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('familyHistoryCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 0; i <= iteration; i++) {
		if (document.getElementById("srNo" + i) != null
				&& (typeof document.getElementById("srNo" + i).checked) != 'undefined'
				&& document.getElementById("srNo" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("srNo" + i) != null
					&& (typeof document.getElementById("srNo" + i).checked) != 'undefined'
					&& document.getElementById("srNo" + i).checked) {
				var deleteRow = document.getElementById("srNo" + i).parentNode.parentNode;
				document.getElementById("srNo" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}



function addRowForDrugs() {
	var tbl = document.getElementById('drugsGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('drugsCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'drugsRadio' + iteration;
	e1.id = 'drugsRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'drugName' + iteration;
	e1.id = 'drugName' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

	// swarup 16/11/2017
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ageOfInitial' + iteration;
	e1.id = 'ageOfInitial' + iteration;
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event)
	};
	e1.size = '20';
	e1.setAttribute('validate','Age of Initiation,int,no');
	e1.maxLength = 3;
	cellRight1.appendChild(e1);
	

	var cellRight1 = row.insertCell(3);
	var e11 = document.createElement('input');
	e11.type = 'text';
	e11.name = 'regularUseAgeOfOnSet' + iteration;
	e11.id = 'regularUseAgeOfOnSet' + iteration;
	e11.size = '24';
	e11.onkeypress = function (event) {
		  javascript: return isNumber(event)
	};
	e11.maxLength = 3;
	e11.setAttribute('validate','Regular Use Age OnSet,int,no');
	cellRight1.appendChild(e11);
	
	

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'regularUseDurationOnset' + iteration;
	e1.id = 'regularUseDurationOnset' + iteration;
	e1.size = '24';
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event)
	};
	e1.maxLength = 16;
	e1.setAttribute('validate','Regular Use Duration,int,no');
	cellRight1.appendChild(e1);
	

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'dependenceAgeOfOnset' + iteration;
	e1.id = 'dependenceAgeOfOnset' + iteration;
	e1.size = '24';
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event)
	};
	e1.maxLength = 3;
	e1.setAttribute('validate','Dependance Age of On Set,int,no');
	cellRight1.appendChild(e1);
	
	
}

function removeRowForDrugs() {
	var tbl = document.getElementById('drugsGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('drugsCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("drugsRadio" + i) != null
				&& (typeof document.getElementById("drugsRadio" + i).checked) != 'undefined'
				&& document.getElementById("drugsRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("drugsRadio" + i) != null
					&& (typeof document.getElementById("drugsRadio" + i).checked) != 'undefined'
					&& document.getElementById("drugsRadio" + i).checked) {
				var deleteRow = document.getElementById("drugsRadio" + i).parentNode.parentNode;
				document.getElementById("drugsRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowForCurrentDrugUsePattern() {
	var tbl = document.getElementById('currentDrugUsePatternGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('currentDrugUsePatternCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'currentDrugUsePatternRadio' + iteration;
	e1.id = 'currentDrugUsePatternRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'drugNameValue' + iteration;
	e1.id = 'drugNameValue' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'frequencyDrug' + iteration;
	e1.id = 'frequencyDrug' + iteration;
	e1.size = '12';
	e1.maxLength = 10;
	e1.onkeypress = function (event) {
		  javascript: return isNumberDecimal(event)
	};
	e1.setAttribute('validate', 'Frequency of Consumption,float,no');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'avgAmt' + iteration;
	e1.id = 'avgAmt' + iteration;
	e1.maxLength = 10;
	e1.onkeypress = function (event) {
		  javascript: return isNumberDecimal(event)
	};
	e1.size = '12';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'heaviest' + iteration;
	e1.id = 'heaviest' + iteration;
	e1.size = '12';
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'withdrawal' + iteration;
	e1.id = 'withdrawal' + iteration;
	e1.size = '12';
	e1.maxLength = 15;
	cellRight1.appendChild(e1);

	// added by swarup 16/11/2017
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'primaryDrugOfAbuse' + iteration;
	e1.id = 'primaryDrugOfAbuse' + iteration;
	e1.size = '15';
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'secondaryDrugOfAbuse' + iteration;
	e1.id = 'secondaryDrugOfAbuse' + iteration;
	e1.size = '15';
	e1.maxLength = 32;
	cellRight1.appendChild(e1);
	// ended by swarup 16/11/2017
}

function removeRowForCurrentDrugUsePattern() {
	var tbl = document.getElementById('currentDrugUsePatternGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('currentDrugUsePatternCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("currentDrugUsePatternRadio" + i) != null
				&& (typeof document.getElementById("currentDrugUsePatternRadio"
						+ i).checked) != 'undefined'
				&& document.getElementById("currentDrugUsePatternRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("currentDrugUsePatternRadio" + i) != null
					&& (typeof document
							.getElementById("currentDrugUsePatternRadio" + i).checked) != 'undefined'
					&& document
							.getElementById("currentDrugUsePatternRadio" + i).checked) {
				var deleteRow = document
						.getElementById("currentDrugUsePatternRadio" + i).parentNode.parentNode;
				document.getElementById("currentDrugUsePatternRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowForLastUse() {
	var tbl = document.getElementById('lastUseGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('lastUseCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'lastUseRadio' + iteration;
	e1.id = 'lastUseRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'nameOfDrugsss' + iteration;
	e1.id = 'nameOfDrugsss' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

	var cell1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'dateLastUse' + (iteration);
	e1.size = '10';
	e1.id = 'dateLastUse' + (iteration);
	e1.className = 'date';
/*	var eImg = document.createElement('img');
	eImg.src = '/hms/jsp/images/cal.gif';
	eImg.style.display = 'inline';
	eImg.onclick = function(event) {
		setdate('', document.getElementById('dateLastUse' + iteration), event)
	};
	*/
	e1.maxLength = 10;
	e1.onkeypress = function() {
		mask(this.value,this,'2,5','/');
	};
	e1.setAttribute('validate', 'Date,date,no');
	cell1.appendChild(e1);
	/*cell1.appendChild(eImg);*/

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'amt' + iteration;
	e1.id = 'amt' + iteration;
	e1.onkeypress = function (event) {
		  javascript: return isNumberDecimal(event)
	};
	e1.size = '20';
	e1.maxLength = 10;
	cellRight1.appendChild(e1);

}

function removeRowForLastUse() {
	var tbl = document.getElementById('lastUseGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('lastUseCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("lastUseRadio" + i) != null
				&& (typeof document.getElementById("lastUseRadio" + i).checked) != 'undefined'
				&& document.getElementById("lastUseRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("lastUseRadio" + i) != null
					&& (typeof document.getElementById("lastUseRadio" + i).checked) != 'undefined'
					&& document.getElementById("lastUseRadio" + i).checked) {
				var deleteRow = document.getElementById("lastUseRadio" + i).parentNode.parentNode;
				document.getElementById("lastUseRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowForPeriod() {
	var tbl = document.getElementById('periodGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('periodCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'periodRadio' + iteration;
	e1.id = 'periodRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'timePeriod' + iteration;
	e1.id = 'timePeriod' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'periodInWeeks' + iteration;
	e1.id = 'periodInWeeks' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'selfWithMedicalHelp' + iteration;
	e1.id = 'selfWithMedicalHelp' + iteration;
	e1.size = '20';
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

}

function removeRowForPeriod() {
	var tbl = document.getElementById('periodGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('periodCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("periodRadio" + i) != null
				&& (typeof document.getElementById("periodRadio" + i).checked) != 'undefined'
				&& document.getElementById("periodRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("periodRadio" + i) != null
					&& (typeof document.getElementById("periodRadio" + i).checked) != 'undefined'
					&& document.getElementById("periodRadio" + i).checked) {
				var deleteRow = document.getElementById("periodRadio" + i).parentNode.parentNode;
				document.getElementById("periodRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

// added by amit das on 06-09-2016
function showPastEpisodeDiv() {
	document.getElementById("pastEpisodeDiv").style.display = "block";
	document.getElementById("EpisodeNameDiv").style.display = "none";
}

function hidePastEpisodeDiv() {
	document.getElementById("pastEpisodeDiv").style.display = "none";
	document.getElementById("episodeId").value = "0";
	document.getElementById("EpisodeNameDiv").style.display = "block";
}

function getEpisodeDetail(i, patientType) {
	var episodeId = i.options[i.selectedIndex].value;
	document.getElementById("episodeId").value = episodeId;
	if (patientType == 'inpatient')
		submitProtoAjaxNew('ipdCaseSheet',
				'opd?method=getEpisodeDetails&episodeId=' + episodeId,
				'patientEpisodeDetail');
	else if (patientType == 'outpatient')
		submitProtoAjaxNew('opdMain', 'opd?method=getEpisodeDetails&episodeId='
				+ episodeId, 'patientEpisodeDetail');
}

function closeUpdateTemplateTreateList() {
	window.close();
}

function addRowForCardiovascularSystem() {
	var tbl = document.getElementById('cardiovascularSystemGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('cardiovascularSystemCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'srNo' + iteration;
	e1.id = 'srNo' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'site' + iteration;
	e1.id = 'site' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Radial', 'Radial');
	e1.options[2] = new Option('Brachial', 'Brachial');
	e1.options[3] = new Option('Carotid', 'Carotid');
	e1.options[4] = new Option('Femoral', 'Femoral');
	e1.options[5] = new Option('Popliteal', 'Popliteal');
	e1.options[6] = new Option('Abdominal Aorta', 'Abdominal Aorta');
	e1.options[7] = new Option('DP and TP arteries of foot',
			'DP and TP arteries of foot');
	e1.options[8] = new Option('Other', 'Other');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.setAttribute('style','width:36px;');
	e1.name = 'rate' + iteration;
	e1.id = 'rate' + iteration;
	e1.maxLength = 3;
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event)
	};
	var e11 = document.createElement('Label');
	e11.className='smallAuto';
	e11.name = 'beats/min' + iteration;
	e11.innerHTML = 'beats/min';

	cellRight1.appendChild(e1);
	cellRight1.appendChild(e11);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('Select');
	e1.name = 'rhythm' + iteration;
	e1.id = 'rhythm' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Regular', 'Regular');
	e1.options[2] = new Option('Regularly Irregular', 'Regularly Irregular');
	e1.options[3] = new Option('Irregularly Irregular', 'Irregularly Irregular');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name = 'volume' + iteration;
	e1.id = 'volume' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Normal', 'Normal');
	e1.options[2] = new Option('Low', 'Low');
	e1.options[3] = new Option('High', 'High');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.name = 'csCharacter' + iteration;
	e1.id = 'csCharacter' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Normal', 'Normal');
	e1.options[2] = new Option('Anacrotic', 'Anacrotic');
	e1.options[3] = new Option('Dicrotic', 'Dicrotic');
	e1.options[4] = new Option('Bisferiens', 'Bisferiens');
	e1.options[5] = new Option('Collapsing', 'Collapsing');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('Select');
	e1.name = 'conditionOfTheVesselWell' + iteration;
	e1.id = 'conditionOfTheVesselWell' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Normal', 'Normal');
	e1.options[2] = new Option('Thickened', 'Thickened');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('Select');
	e1.name = 'radioFemoralDelay' + iteration;
	e1.id = 'radioFemoralDelay' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Present', 'Present');
	e1.options[2] = new Option('Absent', 'Absent');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('Select');
	e1.name = 'palpitationOfPeripheralVessel' + iteration;
	e1.id = 'palpitationOfPeripheralVessel' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('0/Absent', '0/Absent');
	e1.options[2] = new Option('+/Feeble', '+/Feeble');
	e1.options[3] = new Option('++/Normal', '++/Normal');
	e1.options[4] = new Option('+++/Bounding', '+++/Bounding');
	cellRight1.appendChild(e1);

}

function addRowForArterialBloodPressure() {
	var tbl = document.getElementById('arterialBloodPressureGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('arterialBloodPressureCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'srNoo' + iteration;
	e1.id = 'srNoo' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'abpPosition' + iteration;
	e1.id = 'abpPosition' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('RT UL Sitting', 'RT UL Sitting');
	e1.options[2] = new Option('RT UL Supine', 'RT UL Supine');
	e1.options[3] = new Option('LT UL Sitting', 'LT UL Sitting');
	e1.options[4] = new Option('LT UL Supine', 'LT UL Supine');
	e1.options[5] = new Option('RT LL', 'RT LL');
	e1.options[6] = new Option('LT LL', 'LT LL');
	e1.options[7] = new Option('Ankle Brachial Index', 'Ankle Brachial Index');
	e1.options[8] = new Option('Others', 'Others');
	e1.setAttribute("onchange", "toggleOtherTextbox(this.value,'otherPosition"
			+ iteration + "','15','otherPositionSpan" + iteration + "')");
	cellRight1.appendChild(e1);

	var dateSpan = document.createElement('span');
	dateSpan.id = 'otherPositionSpan' + iteration;
	cellRight1.appendChild(dateSpan);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'systolic' + iteration;
	e1.id = 'systolic' + iteration;
	e1.className = 'textSmall';
	e1.maxLength = 3;
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event)
	};
	
	var e11 = document.createElement('Label');
	e11.name = 'mm Hg' + iteration;
	e11.innerHTML = "mm Hg";
	cellRight1.appendChild(e11);
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'diastolic' + iteration;
	e1.className = 'textSmall';
	e1.id = 'diastolic' + iteration;
	e1.maxLength = 3;
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event)
	};
	var e12 = document.createElement('Label');
	e12.name = 'mm Hg' + iteration;
	e12.innerHTML = "mm Hg";
	cellRight1.appendChild(e1);
	cellRight1.appendChild(e12);

}

function getPulsusParadoxus(val) {
	if (val == 'Present') {
		document.getElementById("pulsusParadoxusDiv").style.display = "inline";

	} else {
		document.getElementById("pulsusParadoxusDiv").style.display = "none";
		document.getElementById("systolicPulsusParadoxus").value = "";
		/*document.getElementById("diastolicPulsusParadoxus").value = "";*/
	}

}
function getPulsusAlternans(val) {
	if (val == 'Present') {
		document.getElementById("pulsusAlternansDiv").style.display = "inline";

	} else {
		document.getElementById("pulsusAlternansDiv").style.display = "none";
		document.getElementById("systolicPulsusAlternans").value = "";
		document.getElementById("diastolicPulsusAlternans").value = "";
	}

}

// added by swarup 15/11/2017 fro de addiction center
function getPathologicalUsePattern(val) {
	if (val == 'No') {
		document.getElementById("pathologicalUsePatternDiv").style.display = "inline";

	} else {
		document.getElementById("pathologicalUsePatternDiv").style.display = "none";
	}
}

// added by swarup 15/11/2017
function getSubstanceUse(val) {
	if (val == 'Yes') {
		document.getElementById("substanceUseDiv").style.display = "inline";

	} else {
		document.getElementById("substanceUseDiv").style.display = "none";
	}
}

// swarup
function myFunction() {
	var x = document.getElementById("mySelect").value;
	document.getElementById("demo").innerHTML = x;
}

// added by swarup 15/11/2017
function getPastHistoryOfPhysicalIllness(val) {
	if (val == 'y') {
		document.getElementById("pastHistoryOfPhysicalIllnessDiv").style.display = "inline";

	} else {
		document.getElementById("pastHistoryOfPhysicalIllnessDiv").style.display = "none";
	}
}

// added by swarup 15/11/2017
function checkOtherPhysicalIllness(val) {
	if (document.getElementById('physicalIllness').checked) {
		document.getElementById('physicalIllnessValue').style.display = 'block';
	} else {
		document.getElementById('physicalIllnessValue').style.display = 'none';
	}
}


//Added by swarup 22-11-2017 inprocess
function calculate(val){
	 if(val=="0"){
		 document.getElementById("easiTotalScoreZero").value=parseInt(document.getElementById("easiTotalScoreZero").value)+1;
		 document.getElementById("easiTotalScoreOne").value=parseInt(document.getElementById("easiTotalScoreOne").value)-1;
	 }else if(val=="1"){
		 document.getElementById("easiTotalScoreZero").value=parseInt(document.getElementById("easiTotalScoreZero").value)-1;
		 document.getElementById("easiTotalScoreOne").value=parseInt(document.getElementById("easiTotalScoreOne").value)+1;
		 
	 }
}
function calcMiddleTable(val){
	if(val=="0"){
		 document.getElementById("txtMiddleTableTotalZeros").value=parseInt(document.getElementById("txtMiddleTableTotalZeros").value)+1;
		 document.getElementById("txtMiddleTableTotal").value=parseInt(document.getElementById("txtMiddleTableTotal").value)-1;
	 }else if(val=="1"){
		 document.getElementById("txtMiddleTableTotalZeros").value=parseInt(document.getElementById("txtMiddleTableTotalZeros").value)-1;
		 document.getElementById("txtMiddleTableTotal").value=parseInt(document.getElementById("txtMiddleTableTotal").value)+1;
		 
	 }
}
function calMiddleTabChkBox(val,checkBox,hiddenId){
	if(checkBox.checked){
		if(hiddenId!=undefined){
			document.getElementById("txtMiddleTableTotal").value=parseInt(document.getElementById("txtMiddleTableTotal").value)+parseInt(val)-hiddenId.value;
			hiddenId.value = val;
		}
		else
		document.getElementById("txtMiddleTableTotal").value=parseInt(document.getElementById("txtMiddleTableTotal").value)+parseInt(val);
	}else{
		document.getElementById("txtMiddleTableTotal").value=parseInt(document.getElementById("txtMiddleTableTotal").value)-parseInt(val);
	}
}
function calcLastTable(val){
	 if(val=="0"){
		 document.getElementById("totZeros").value=parseInt(document.getElementById("totZeros").value)+1;
		 document.getElementById("totalScore").value=parseInt(document.getElementById("totalScore").value)-1;
	 }else if(val=="1"){
		 document.getElementById("totZeros").value=parseInt(document.getElementById("totZeros").value)-1;
		 document.getElementById("totalScore").value=parseInt(document.getElementById("totalScore").value)+1;
		 
	 }
}

function removeRowForArterialBloodPressure() {
	var tbl = document.getElementById('arterialBloodPressureGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('arterialBloodPressureCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("srNoo" + i) != null
				&& (typeof document.getElementById("srNoo" + i).checked) != 'undefined'
				&& document.getElementById("srNoo" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("srNoo" + i) != null
					&& (typeof document.getElementById("srNoo" + i).checked) != 'undefined'
					&& document.getElementById("srNoo" + i).checked) {
				var deleteRow = document.getElementById("srNoo" + i).parentNode.parentNode;
				document.getElementById("srNoo" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowForCardiovascularSystem() {
	var tbl = document.getElementById('cardiovascularSystemGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('cardiovascularSystemCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("srNo" + i) != null
				&& (typeof document.getElementById("srNo" + i).checked) != 'undefined'
				&& document.getElementById("srNo" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("srNo" + i) != null
					&& (typeof document.getElementById("srNo" + i).checked) != 'undefined'
					&& document.getElementById("srNo" + i).checked) {
				var deleteRow = document.getElementById("srNo" + i).parentNode.parentNode;
				document.getElementById("srNo" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function checkNatureOfInjuryValue(val) {
	if (document.getElementById('natureOfInjuryOther').checked) {
		document.getElementById('natureOfInjuryValueOther').style.display = 'block';
	} else {
		document.getElementById('natureOfInjuryValueOther').style.display = 'none';
	}
}


function checkNeckValue(val) {
	if (document.getElementById('neck').checked) {
		document.getElementById('neckValue').style.display = 'block';
	} else {
		document.getElementById('neckValue').value="";
		document.getElementById('neckValue').style.display = 'none';
	}
}
function checkMidBackValue(val) {
	if (document.getElementById('midBack').checked) {
		document.getElementById('midBackValue').style.display = 'block';
	} else {
		document.getElementById('midBackValue').value="";
		document.getElementById('midBackValue').style.display = 'none';
	}
}
function checkGirdleValue(val) {
	if (document.getElementById('girdle').checked) {
		document.getElementById('girdleValue').style.display = 'block';
	} else {
		document.getElementById('girdleValue').value="";
		document.getElementById('girdleValue').style.display = 'none';
	}
}
function checkLowbackValue(val) {
	if (document.getElementById('lowBack').checked) {
		document.getElementById('lowBackValue').style.display = 'block';
	} else {
		document.getElementById('lowBackValue').value="";
		document.getElementById('lowBackValue').style.display = 'none';
	}
}
function checkHipValue(val) {
	if (document.getElementById('hip').checked) {
		document.getElementById('hipType').style.display = 'block';
	} else {
		document.getElementById('hipType').style.display = 'none';
		document.getElementById('hipValue').style.display = 'none';
		document.getElementById('leftHiplabelId').style.display = 'none';
		document.getElementById('rightHiplabelId').style.display = 'none';
		if(document.getElementById('hipValueAnother') != null)
			document.getElementById('hipValueAnother').style.display = 'none';
		document.getElementById('hipType').value = '';
		document.getElementById('hipValue').value = '';
		if(document.getElementById('hipValueAnother') != null)
			document.getElementById('hipValueAnother').value = '';
		
	}
}
function checkHipValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('hipValue').style.display = 'block';
		if(document.getElementById('hipValueAnother') != null) {
			document.getElementById('hipValueAnother').style.display = 'none';
			document.getElementById('hipValueAnother').value = '';
			document.getElementById('leftHiplabelId').style.display = 'none';
			document.getElementById('rightHiplabelId').style.display = 'none';
		}
	} else if(val=="Left & Right") {
		document.getElementById('hipValue').style.display = 'block';
		if(document.getElementById('hipValueAnother') != null)
			document.getElementById('hipValueAnother').style.display = 'block';
			document.getElementById('leftHiplabelId').style.display = 'block';
			document.getElementById('rightHiplabelId').style.display = 'block';
	} 
	else {
		document.getElementById('hipValue').style.display = 'none';
		if(document.getElementById('hipValueAnother') != null) {
			document.getElementById('hipValueAnother').style.display = 'none';
			document.getElementById('hipValueAnother').value = '';
			document.getElementById('leftHiplabelId').style.display = 'none';
			document.getElementById('rightHiplabelId').style.display = 'none';
		}
		document.getElementById('hipValue').value = '';
	}
}

function checkSacroiliacValue(val) {
	if (document.getElementById('sacroiliac').checked) {
		document.getElementById('sacroiliacType').style.display = 'block';
		
	} else {
		document.getElementById('sacroiliacType').style.display = 'none';
		document.getElementById('sacroiliacValue').style.display = 'none';
		if(document.getElementById('sacroiliacValueAnother') != null) {
			document.getElementById('sacroiliacValueAnother').style.display = 'none';
			document.getElementById('sacroiliacValueAnother').value = '';
		}
		document.getElementById('sacroiliacType').value = '';
		document.getElementById('sacroiliacValue').value = '';
		document.getElementById('leftSacroiliaclabelId').style.display = 'none';
		document.getElementById('rightSacroiliaclabelId').style.display = 'none';
		
	}
}
function checkSacroiliacValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('sacroiliacValue').style.display = 'block';
		if(document.getElementById('sacroiliacValueAnother') != null) {
			document.getElementById('sacroiliacValueAnother').style.display = 'none';
			document.getElementById('sacroiliacValueAnother').value = '';
			document.getElementById('leftSacroiliaclabelId').style.display = 'none';
			document.getElementById('rightSacroiliaclabelId').style.display = 'none';
		}
	} else if(val=="Left & Right")
		{
		document.getElementById('sacroiliacValue').style.display = 'block';
		if(document.getElementById('sacroiliacValueAnother') != null)
			document.getElementById('sacroiliacValueAnother').style.display = 'block';
			document.getElementById('leftSacroiliaclabelId').style.display = 'block';
			document.getElementById('rightSacroiliaclabelId').style.display = 'block';
			} 
	else {
		document.getElementById('sacroiliacValue').style.display = 'none';
		if(document.getElementById('sacroiliacValueAnother') != null) {
			document.getElementById('sacroiliacValueAnother').style.display = 'none';
			document.getElementById('sacroiliacValueAnother').value = '';
			document.getElementById('leftSacroiliaclabelId').style.display = 'none';
			document.getElementById('rightSacroiliaclabelId').style.display = 'none';
		}
		document.getElementById('sacroiliacValue').value = '';
	}
}



function checkPelvisValue(val) {
	if (document.getElementById('pelvis').checked) {
		document.getElementById('pelvisType').style.display = 'block';
		
	} else {
		document.getElementById('pelvisType').style.display = 'none';
		document.getElementById('pelvisValue').style.display = 'none';
		if(document.getElementById('pelvisValueAnother') != null) {
			document.getElementById('pelvisValueAnother').style.display = 'none';
			document.getElementById('pelvisValueAnother').value = '';
		}
		document.getElementById('pelvisType').value = '';
		document.getElementById('pelvisValue').value = '';
		document.getElementById('leftPelvislabelId').style.display = 'none';
		document.getElementById('rightPelvislabelId').style.display = 'none';
		
	}
}
function checkPelvisValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('pelvisValue').style.display = 'block';
		if(document.getElementById('pelvisValueAnother') != null) {
			document.getElementById('pelvisValueAnother').style.display = 'none';
			document.getElementById('pelvisValueAnother').value = '';
			document.getElementById('leftPelvislabelId').style.display = 'none';
			document.getElementById('rightPelvislabelId').style.display = 'none';
		}
	} else if(val=="Left & Right") {
		document.getElementById('pelvisValue').style.display = 'block';
		if(document.getElementById('pelvisValueAnother') != null)
			document.getElementById('pelvisValueAnother').style.display = 'block';
			document.getElementById('leftPelvislabelId').style.display = 'block';
			document.getElementById('rightPelvislabelId').style.display = 'block';
	} else {
		document.getElementById('pelvisValue').style.display = 'none';
		if(document.getElementById('pelvisValueAnother') != null) {
			document.getElementById('pelvisValueAnother').style.display = 'none';
			document.getElementById('pelvisValueAnother').value = '';
			document.getElementById('leftPelvislabelId').style.display = 'none';
			document.getElementById('rightPelvislabelId').style.display = 'none';
		}
		document.getElementById('pelvisValue').value = '';
	}
}




function checkThighValue(val) {
	if (document.getElementById('thigh').checked) {
		document.getElementById('thighType').style.display = 'block';
		
	} else {
		document.getElementById('thighType').style.display = 'none';
		document.getElementById('thighValue').style.display = 'none';
		if(document.getElementById('thighValueAnother') != null) {
			document.getElementById('thighValueAnother').style.display = 'none';
			document.getElementById('thighValueAnother').value = '';
		}
		document.getElementById('thighType').value = '';
		document.getElementById('thighValue').value = '';
		document.getElementById('leftThighlabelId').style.display = 'none';
		document.getElementById('rightThighlabelId').style.display = 'none';
		
	}
}
function checkThighValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('thighValue').style.display = 'block';
		if(document.getElementById('thighValueAnother') != null) {
			document.getElementById('thighValueAnother').style.display = 'none';
			document.getElementById('thighValueAnother').value = '';
			document.getElementById('leftThighlabelId').style.display = 'none';
			document.getElementById('rightThighlabelId').style.display = 'none';
		}
	} else if(val=="Left & Right") {
		document.getElementById('thighValue').style.display = 'block';
		if(document.getElementById('thighValueAnother') != null)
			document.getElementById('thighValueAnother').style.display = 'block';
			document.getElementById('leftThighlabelId').style.display = 'block';
			document.getElementById('rightThighlabelId').style.display = 'block';
	} else {
		document.getElementById('thighValue').style.display = 'none';
		if(document.getElementById('thighValueAnother') != null) {
			document.getElementById('thighValueAnother').style.display = 'none';
			document.getElementById('thighValueAnother').value = '';
			document.getElementById('leftThighlabelId').style.display = 'none';
			document.getElementById('rightThighlabelId').style.display = 'none';
		}
		document.getElementById('thighValue').value = '';
	}
}

function checkKneeValue(val) {
	if (document.getElementById('knee').checked) {
		document.getElementById('kneeType').style.display = 'block';
		
	} else {
		document.getElementById('kneeType').style.display = 'none';
		document.getElementById('kneeValue').style.display = 'none';
		if(document.getElementById('kneeValueAnother') != null) {
			document.getElementById('kneeValueAnother').style.display = 'none';
			document.getElementById('kneeValueAnother').value = '';
		}
		document.getElementById('kneeType').value = '';
		document.getElementById('kneeValue').value = '';
		document.getElementById('leftKneelabelId').style.display = 'none';
		document.getElementById('rightKneelabelId').style.display = 'none';
	}
}
function checkKneeValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('kneeValue').style.display = 'block';
		if(document.getElementById('kneeValueAnother') != null) {
			document.getElementById('kneeValueAnother').style.display = 'none';
			document.getElementById('kneeValueAnother').value = '';
			document.getElementById('leftKneelabelId').style.display = 'none';
			document.getElementById('rightKneelabelId').style.display = 'none';
		}
	} else if(val=="Left & Right") {
		document.getElementById('kneeValue').style.display = 'block';
		if(document.getElementById('kneeValueAnother') != null)
			document.getElementById('kneeValueAnother').style.display = 'block';
			document.getElementById('leftKneelabelId').style.display = 'block';
			document.getElementById('rightKneelabelId').style.display = 'block';
	} else {
		document.getElementById('kneeValue').style.display = 'none';
		if(document.getElementById('kneeValueAnother') != null) {
			document.getElementById('kneeValueAnother').style.display = 'none';
			document.getElementById('kneeValueAnother').value = '';
			document.getElementById('leftKneelabelId').style.display = 'none';
			document.getElementById('rightKneelabelId').style.display = 'none';
		}
		document.getElementById('kneeValue').value = '';
	}
}

function checkLegValue(val) {
	if (document.getElementById('leg').checked) {
		document.getElementById('legType').style.display = 'block';
		
	} else {
		document.getElementById('legType').style.display = 'none';
		document.getElementById('legValue').style.display = 'none';
		if(document.getElementById('legValueAnother') != null) {
			document.getElementById('legValueAnother').style.display = 'none';
			document.getElementById('legValueAnother').value = '';
		}
		document.getElementById('legType').value = '';
		document.getElementById('legValue').value = '';
		document.getElementById('leftLeglabelId').style.display = 'none';
		document.getElementById('rightLeglabelId').style.display = 'none';
	}
}
function checkLegValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('legValue').style.display = 'block';
		if(document.getElementById('legValueAnother') != null) {
			document.getElementById('legValueAnother').style.display = 'none';
			document.getElementById('legValueAnother').value = '';
			document.getElementById('leftLeglabelId').style.display = 'none';
			document.getElementById('rightLeglabelId').style.display = 'none';
		}
	} 
	else if(val=="Left & Right") {
		document.getElementById('legValue').style.display = 'block';
		if(document.getElementById('legValueAnother') != null)
			document.getElementById('legValueAnother').style.display = 'block';
			document.getElementById('leftLeglabelId').style.display = 'block';
			document.getElementById('rightLeglabelId').style.display = 'block';
	} else {
		document.getElementById('legValue').style.display = 'none';
		if(document.getElementById('legValueAnother') != null) {
			document.getElementById('legValueAnother').style.display = 'none';
			document.getElementById('legValueAnother').value = '';
			document.getElementById('leftLeglabelId').style.display = 'none';
			document.getElementById('rightLeglabelId').style.display = 'none';
		}
		document.getElementById('legValue').value = '';
	}
}


function checkAnkleValue(val) {
	if (document.getElementById('ankle').checked) {
		document.getElementById('ankleType').style.display = 'block';
		
	} else {
		document.getElementById('ankleType').style.display = 'none';
		document.getElementById('ankleValue').style.display = 'none';
		if(document.getElementById('ankleValueAnother') != null) {
			document.getElementById('ankleValueAnother').style.display = 'none';
			document.getElementById('ankleValueAnother').value = '';
		}
		document.getElementById('ankleType').value = '';
		document.getElementById('ankleValue').value = '';
		document.getElementById('leftAnklelabelId').style.display = 'none';
		document.getElementById('rightAnklelabelId').style.display = 'none';
	}
}
function checkAnkleValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('ankleValue').style.display = 'block';
		if(document.getElementById('ankleValueAnother') != null) {
			document.getElementById('ankleValueAnother').style.display = 'none';
			document.getElementById('ankleValueAnother').value = '';
			document.getElementById('leftAnklelabelId').style.display = 'none';
			document.getElementById('rightAnklelabelId').style.display = 'none';
		}
	} else if(val=="Left & Right") {
		document.getElementById('ankleValue').style.display = 'block';
		if(document.getElementById('ankleValueAnother') != null)
			document.getElementById('ankleValueAnother').style.display = 'block';
			document.getElementById('leftAnklelabelId').style.display = 'block';
			document.getElementById('rightAnklelabelId').style.display = 'block';
	} else {
		document.getElementById('ankleValue').style.display = 'none';
		if(document.getElementById('ankleValueAnother') != null) {
			document.getElementById('ankleValueAnother').style.display = 'none';
			document.getElementById('ankleValueAnother').value = '';
			document.getElementById('leftAnklelabelId').style.display = 'none';
			document.getElementById('rightAnklelabelId').style.display = 'none';
		}
		document.getElementById('ankleValue').value = '';
	}
}



function checkFootValue(val) {
	if (document.getElementById('foot').checked) {
		document.getElementById('footType').style.display = 'block';
		
	} else {
		document.getElementById('footType').style.display = 'none';
		document.getElementById('footValue').style.display = 'none';
		if(document.getElementById('footValueAnother') != null) {
			document.getElementById('footValueAnother').style.display = 'none';
			document.getElementById('footValueAnother').value = '';
		}
		document.getElementById('footType').value = '';
		document.getElementById('footValue').value = '';
		document.getElementById('leftFootlabelId').style.display = 'none';
		document.getElementById('rightFootlabelId').style.display = 'none';
	}
}
function checkFootValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('footValue').style.display = 'block';
		if(document.getElementById('footValueAnother') != null) {
			document.getElementById('footValueAnother').style.display = 'none';
			document.getElementById('footValueAnother').value = '';
			document.getElementById('leftFootlabelId').style.display = 'none';
			document.getElementById('rightFootlabelId').style.display = 'none';
		}
	} else if(val=="Left & Right") {
		document.getElementById('footValue').style.display = 'block';
		if(document.getElementById('footValueAnother') != null)
			document.getElementById('footValueAnother').style.display = 'block';
			document.getElementById('leftFootlabelId').style.display = 'block';
			document.getElementById('rightFootlabelId').style.display = 'block';
	} else {
		document.getElementById('footValue').style.display = 'none';
		if(document.getElementById('footValueAnother') != null) {
			document.getElementById('footValueAnother').style.display = 'none';
			document.getElementById('footValueAnother').value = '';
			document.getElementById('leftFootlabelId').style.display = 'none';
			document.getElementById('rightFootlabelId').style.display = 'none';
		}
		document.getElementById('footValue').value = '';
	}
}


function checkShoulderValue(val) {
	if (document.getElementById('shoulder').checked) {
		document.getElementById('shoulderType').style.display = 'block';
		
	} else {
		document.getElementById('shoulderType').style.display = 'none';
		document.getElementById('shoulderValue').style.display = 'none';
		if(document.getElementById('shoulderValueAnother') != null) {
			document.getElementById('shoulderValueAnother').style.display = 'none';
			document.getElementById('shoulderValueAnother').value = '';
		}
		document.getElementById('shoulderType').value = '';
		document.getElementById('shoulderValue').value = '';
		document.getElementById('leftShoulderlabelId').style.display = 'none';
		document.getElementById('rightShoulderlabelId').style.display = 'none';
	}
}
function checkShoulderValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('shoulderValue').style.display = 'block';
		if(document.getElementById('shoulderValueAnother') != null) {
			document.getElementById('shoulderValueAnother').style.display = 'none';
			document.getElementById('shoulderValueAnother').value = '';
			document.getElementById('leftShoulderlabelId').style.display = 'none';
			document.getElementById('rightShoulderlabelId').style.display = 'none';
		}
	} else if(val=="Left & Right") {
		document.getElementById('shoulderValue').style.display = 'block';
		if(document.getElementById('shoulderValueAnother') != null)
			document.getElementById('shoulderValueAnother').style.display = 'block';
			document.getElementById('leftShoulderlabelId').style.display = 'block';
			document.getElementById('rightShoulderlabelId').style.display = 'block';
	} else {
		document.getElementById('shoulderValue').style.display = 'none';
		if(document.getElementById('shoulderValueAnother') != null) {
			document.getElementById('shoulderValueAnother').style.display = 'none';
			document.getElementById('shoulderValueAnother').value = '';
			document.getElementById('leftShoulderlabelId').style.display = 'none';
			document.getElementById('rightShoulderlabelId').style.display = 'none';
		}
		document.getElementById('shoulderValue').value = '';
	}
}


function checkInterscapularValue(val) {
	if (document.getElementById('interscapular').checked) {
		document.getElementById('interscapularType').style.display = 'block';
		
	} else {
		document.getElementById('interscapularType').style.display = 'none';
		document.getElementById('interscapularValue').style.display = 'none';
		if(document.getElementById('interscapularValueAnother') != null) {
			document.getElementById('interscapularValueAnother').style.display = 'none';
			document.getElementById('interscapularValueAnother').value = '';
		}
		document.getElementById('interscapularType').value = '';
		document.getElementById('interscapularValue').value = '';
		document.getElementById('leftInterscapularlabelId').style.display = 'none';
		document.getElementById('rightInterscapularlabelId').style.display = 'none';
	}
}

function checkInterscapularValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('interscapularValue').style.display = 'block';
		if(document.getElementById('interscapularValueAnother') != null) {
			document.getElementById('interscapularValueAnother').style.display = 'none';
			document.getElementById('interscapularValueAnother').value = '';
			document.getElementById('leftInterscapularlabelId').style.display = 'none';
			document.getElementById('rightInterscapularlabelId').style.display = 'none';
		}
	} else if(val=="Left & Right") {
		document.getElementById('interscapularValue').style.display = 'block';
		if(document.getElementById('interscapularValueAnother') != null)
			document.getElementById('interscapularValueAnother').style.display = 'block';
			document.getElementById('leftInterscapularlabelId').style.display = 'block';
			document.getElementById('rightInterscapularlabelId').style.display = 'block';
	} else {
		document.getElementById('interscapularValue').style.display = 'none';
		document.getElementById('interscapularValue').value = '';
		if(document.getElementById('interscapularValueAnother') != null) {
			document.getElementById('interscapularValueAnother').style.display = 'none';
			document.getElementById('interscapularValueAnother').value = '';
			document.getElementById('leftInterscapularlabelId').style.display = 'none';
			document.getElementById('rightInterscapularlabelId').style.display = 'none';
		}
	}
}

function checkArmValue(val) {
	if (document.getElementById('arm').checked) {
		document.getElementById('armType').style.display = 'block';
		
	} else {
		document.getElementById('armType').style.display = 'none';
		document.getElementById('armValue').style.display = 'none';
		if(document.getElementById('armValueAnother') != null) {
			document.getElementById('armValueAnother').style.display = 'none';
			document.getElementById('armValueAnother').value = '';
		}
		document.getElementById('armType').value = '';
		document.getElementById('armValue').value = '';
		document.getElementById('leftArmlabelId').style.display = 'none';
		document.getElementById('rightArmlabelId').style.display = 'none';
	}
}
function checkArmValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('armValue').style.display = 'block';
		if(document.getElementById('armValueAnother') != null) {
			document.getElementById('armValueAnother').style.display = 'none';
			document.getElementById('armValueAnother').value = '';
			document.getElementById('leftArmlabelId').style.display = 'none';
			document.getElementById('rightArmlabelId').style.display = 'none';
		}
	} else if(val=="Left & Right") {
		document.getElementById('armValue').style.display = 'block';
		if(document.getElementById('armValueAnother') != null)
			document.getElementById('armValueAnother').style.display = 'block';
			document.getElementById('leftArmlabelId').style.display = 'block';
			document.getElementById('rightArmlabelId').style.display = 'block';
	} else {
		document.getElementById('armValue').style.display = 'none';
		document.getElementById('armValue').value = '';
		if(document.getElementById('armValueAnother') != null) {
			document.getElementById('armValueAnother').style.display = 'none';
			document.getElementById('armValueAnother').value = '';
			document.getElementById('leftArmlabelId').style.display = 'none';
			document.getElementById('rightArmlabelId').style.display = 'none';
		}
	}
}

function checkElbowValue(val) {
	if (document.getElementById('elbow').checked) {
		document.getElementById('elbowType').style.display = 'block';
		
	} else {
		document.getElementById('elbowType').style.display = 'none';
		document.getElementById('elbowValue').style.display = 'none';
		document.getElementById('elbowType').value = '';
		document.getElementById('elbowValue').value = '';
		document.getElementById('leftElbowlabelId').style.display = 'none';
		document.getElementById('rightElbowlabelId').style.display = 'none';
		if(document.getElementById('elbowValueAnother') != null) {
			document.getElementById('elbowValueAnother').style.display = 'none';
			document.getElementById('elbowValueAnother').value = '';
		}
	}
}
function checkElbowValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('elbowValue').style.display = 'block';
		if(document.getElementById('elbowValueAnother') != null) {
			document.getElementById('elbowValueAnother').style.display = 'none';
			document.getElementById('elbowValueAnother').value = '';
			document.getElementById('leftElbowlabelId').style.display = 'none';
			document.getElementById('rightElbowlabelId').style.display = 'none';
		}
	} else if(val=="Left & Right") {
		document.getElementById('elbowValue').style.display = 'block';
		if(document.getElementById('elbowValueAnother') != null)
			document.getElementById('elbowValueAnother').style.display = 'block';
			document.getElementById('leftElbowlabelId').style.display = 'block';
			document.getElementById('rightElbowlabelId').style.display = 'block';
	} else {
		document.getElementById('elbowValue').style.display = 'none';
		document.getElementById('elbowValue').value = '';
		if(document.getElementById('elbowValueAnother') != null) {
			document.getElementById('elbowValueAnother').style.display = 'none';
			document.getElementById('elbowValueAnother').value = '';
			document.getElementById('leftElbowlabelId').style.display = 'none';
			document.getElementById('rightElbowlabelId').style.display = 'none';
		}
	}
}

function checkForearmValue(val) {
	if (document.getElementById('forearm').checked) {
		document.getElementById('forearmType').style.display = 'block';
		
	} else {
		document.getElementById('forearmType').style.display = 'none';
		document.getElementById('forearmValue').style.display = 'none';
		if(document.getElementById('forearmValueAnother') != null) {
			document.getElementById('forearmValueAnother').style.display = 'none';
			document.getElementById('forearmValueAnother').value = '';
		}
		document.getElementById('forearmType').value = '';
		document.getElementById('forearmValue').value = '';
		document.getElementById('leftForearmlabelId').style.display = 'none';
		document.getElementById('rightForearmlabelId').style.display = 'none';
	}
}
function checkForearmValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('forearmValue').style.display = 'block';
		if(document.getElementById('forearmValueAnother') != null) {
			document.getElementById('forearmValueAnother').style.display = 'none';
			document.getElementById('forearmValueAnother').value = '';
			document.getElementById('leftForearmlabelId').style.display = 'none';
			document.getElementById('rightForearmlabelId').style.display = 'none';
		}
	} else if(val=="Left & Right") {
		document.getElementById('forearmValue').style.display = 'block';
		if(document.getElementById('forearmValueAnother') != null)
			document.getElementById('forearmValueAnother').style.display = 'block';
			document.getElementById('leftForearmlabelId').style.display = 'block';
			document.getElementById('rightForearmlabelId').style.display = 'block';
	} else {
		document.getElementById('forearmValue').style.display = 'none';
		document.getElementById('forearmValue').value = '';
		if(document.getElementById('forearmValueAnother') != null) {
			document.getElementById('forearmValueAnother').style.display = 'none';
			document.getElementById('forearmValueAnother').value = '';
			document.getElementById('leftForearmlabelId').style.display = 'none';
			document.getElementById('rightForearmlabelId').style.display = 'none';
		}
	}
}

function checkWristValue(val) {
	if (document.getElementById('wrist').checked) {
		document.getElementById('wristType').style.display = 'block';
		
	} else {
		document.getElementById('wristType').style.display = 'none';
		document.getElementById('wristValue').style.display = 'none';
		if(document.getElementById('wristValueAnother') != null) {
			document.getElementById('wristValueAnother').style.display = 'none';
			document.getElementById('wristValueAnother').value = '';
		}
		document.getElementById('wristType').value = '';
		document.getElementById('wristValue').value = '';
		document.getElementById('leftWristlabelId').style.display = 'none';
		document.getElementById('rightWristlabelId').style.display = 'none';
	}
}
function checkWristValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('wristValue').style.display = 'block';
		if(document.getElementById('wristValueAnother') != null) {
			document.getElementById('wristValueAnother').style.display = 'none';
			document.getElementById('wristValueAnother').value = '';
			document.getElementById('leftWristlabelId').style.display = 'none';
			document.getElementById('rightWristlabelId').style.display = 'none';
		}
	} else if(val=="Left & Right") {
		document.getElementById('wristValue').style.display = 'block';
		document.getElementById('wristValueAnother').style.display = 'block';
		document.getElementById('leftWristlabelId').style.display = 'block';
		document.getElementById('rightWristlabelId').style.display = 'block';
	} else {
		document.getElementById('wristValue').style.display = 'none';
		document.getElementById('wristValue').value = '';
		if(document.getElementById('wristValueAnother') != null) {
			document.getElementById('wristValueAnother').style.display = 'none';
			document.getElementById('wristValueAnother').value = '';
			document.getElementById('leftWristlabelId').style.display = 'none';
			document.getElementById('rightWristlabelId').style.display = 'none';
		}
	}
}

function checkHandValue(val) {
	if (document.getElementById('hand').checked) {
		document.getElementById('handType').style.display = 'block';
		
	} else {
		document.getElementById('handType').style.display = 'none';
		document.getElementById('handValue').style.display = 'none';
		if(document.getElementById('handValueAnother') != null) {
			document.getElementById('handValueAnother').style.display = 'none';
			document.getElementById('handValueAnother').value = '';
		}
		document.getElementById('handType').value = '';
		document.getElementById('handValue').value = '';
		document.getElementById('leftHandlabelId').style.display = 'none';
		document.getElementById('rightHandlabelId').style.display = 'none';
	}
}
function checkHandValueAnother(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('handValue').style.display = 'block';
		if(document.getElementById('handValueAnother') != null) {
			document.getElementById('handValueAnother').style.display = 'none';
			document.getElementById('handValueAnother').value = '';
			document.getElementById('leftHandlabelId').style.display = 'none';
			document.getElementById('rightHandlabelId').style.display = 'none';
		}
	}  else if(val=="Left & Right") {
		document.getElementById('handValue').style.display = 'block';
		if(document.getElementById('handValueAnother') != null)
			document.getElementById('handValueAnother').style.display = 'block';
			document.getElementById('leftHandlabelId').style.display = 'block';
			document.getElementById('rightHandlabelId').style.display = 'block';
	} else {
		document.getElementById('handValue').style.display = 'none';
		document.getElementById('handValue').value = '';
		if(document.getElementById('handValueAnother') != null) {
			document.getElementById('handValueAnother').style.display = 'none';
			document.getElementById('handValueAnother').value = '';
			document.getElementById('leftHandlabelId').style.display = 'none';
			document.getElementById('rightHandlabelId').style.display = 'none';
		}
	}
}


function checkUpperLimb(val) {
	if (document.getElementById('upperLimb').checked) {
		document.getElementById('upperLimbType').style.display = 'block';
		
	} else {
		document.getElementById('upperLimbType').style.display = 'none';
		document.getElementById('upperLimbValue').style.display = 'none';
		if(document.getElementById('upperLimbValueAnother') != null) {
			document.getElementById('upperLimbValueAnother').style.display = 'none';
			document.getElementById('upperLimbValueAnother').value = '';
		}
		document.getElementById('upperLimbType').value = '';
		document.getElementById('upperLimbValue').value = '';
		document.getElementById('leftupperLimblabelId').style.display = 'none';
		document.getElementById('rightupperLimblabelId').style.display = 'none';
		document.getElementById('upperLimbDiv').style.display = 'none';
	}
}

function checkUpperLimbValue(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('upperLimbValue').style.display = 'block';
		document.getElementById('upperLimbDiv').style.display = 'block';
		if(document.getElementById('upperLimbValueAnother') != null) {
			document.getElementById('upperLimbValueAnother').style.display = 'none';
			document.getElementById('upperLimbValueAnother').value = '';
			document.getElementById('leftupperLimblabelId').style.display = 'none';
			document.getElementById('rightupperLimblabelId').style.display = 'none';
		}
	}  else if(val=="Left & Right") {
		document.getElementById('upperLimbValue').style.display = 'block';
		document.getElementById('upperLimbDiv').style.display = 'block';
		if(document.getElementById('upperLimbValueAnother') != null)
			document.getElementById('upperLimbValueAnother').style.display = 'block';
			document.getElementById('leftupperLimblabelId').style.display = 'block';
			document.getElementById('rightupperLimblabelId').style.display = 'block';
	} else {
		document.getElementById('upperLimbValue').style.display = 'none';
		document.getElementById('upperLimbDiv').style.display = 'none';
		document.getElementById('upperLimbValue').value = '';
		if(document.getElementById('upperLimbValueAnother') != null) {
			document.getElementById('upperLimbValueAnother').style.display = 'none';
			document.getElementById('upperLimbValueAnother').value = '';
			document.getElementById('leftupperLimblabelId').style.display = 'none';
			document.getElementById('rightupperLimblabelId').style.display = 'none';
		}
	}
}

function checkLowerLimb(val) {
	if (document.getElementById('lowerLimb').checked) {
		document.getElementById('lowerLimbType').style.display = 'block';
		
	} else {
		document.getElementById('lowerLimbType').style.display = 'none';
		document.getElementById('lowerLimbValue').style.display = 'none';
		if(document.getElementById('lowerLimbValueAnother') != null) {
			document.getElementById('lowerLimbValueAnother').style.display = 'none';
			document.getElementById('lowerLimbValueAnother').value = '';
		}
		document.getElementById('lowerLimbType').value = '';
		document.getElementById('lowerLimbValue').value = '';
		document.getElementById('leftLowerLimblabelId').style.display = 'none';
		document.getElementById('rightLowerLimblabelId').style.display = 'none';
		document.getElementById('lowerLimbDiv').style.display = 'none';
	}
}

function checkLowerLimbValue(val) {
	if (val=="Left" || val=="Right" || val=="Bilateral" ) {
		document.getElementById('lowerLimbValue').style.display = 'block';
		document.getElementById('lowerLimbDiv').style.display = 'block';
		if(document.getElementById('lowerLimbValueAnother') != null) {
			document.getElementById('lowerLimbValueAnother').style.display = 'none';
			document.getElementById('lowerLimbValueAnother').value = '';
			document.getElementById('leftLowerLimblabelId').style.display = 'none';
			document.getElementById('rightLowerLimblabelId').style.display = 'none';
		}
	}  else if(val=="Left & Right") {
		document.getElementById('lowerLimbValue').style.display = 'block';
		document.getElementById('lowerLimbDiv').style.display = 'block';
		if(document.getElementById('lowerLimbValueAnother') != null)
			document.getElementById('lowerLimbValueAnother').style.display = 'block';
			document.getElementById('leftLowerLimblabelId').style.display = 'block';
			document.getElementById('rightLowerLimblabelId').style.display = 'block';
	} else {
		document.getElementById('lowerLimbValue').style.display = 'none';
		document.getElementById('lowerLimbDiv').style.display = 'none';
		document.getElementById('lowerLimbValue').value = '';
		if(document.getElementById('lowerLimbValueAnother') != null) {
			document.getElementById('lowerLimbValueAnother').style.display = 'none';
			document.getElementById('lowerLimbValueAnother').value = '';
			document.getElementById('leftLowerLimblabelId').style.display = 'none';
			document.getElementById('rightLowerLimblabelId').style.display = 'none';
		}
	}
}
/*function checkLowerLimbValue(val) {
	if (document.getElementById('lowerLimb').checked) {
		document.getElementById('lowerLimbDiv').style.display = 'block';

	} else {
		document.getElementById('lowerLimbValue').value = "";
		document.getElementById('lowerLimbLength').value = "";
		document.getElementById('lowerLimbDiscrepancy').value = "";
		document.getElementById('anyOtherLowerLimb').value = "";
		document.getElementById('lowerLimbDiv').style.display = 'none';

	}
}*/
function SelectPainValue(val) {
	if (val == 'Yes') {
		document.getElementById('painDiv').style.display = 'block';

	} else {
		
		document.getElementById('painSite').value = "";
		document.getElementById('natureOfPain').value = "";
		document.getElementById('radiation').value = "";
		document.getElementById('exacerbatingFactor').value = "";
		document.getElementById('relievingFactor').value = "";
		
		document.getElementById('painDiv').style.display = 'none';

	}
}

function displayStiffnessValue(val) {
	if (val == 'Yes') {
		document.getElementById('stiffnessValue').style.display = 'block';
		document.getElementById('stiffnessDiv').style.display = 'block';

	} else {
		document.getElementById('stiffnessValue').value = "";
		document.getElementById('stiffnessValue').style.display = 'none';
		document.getElementById('stiffnessDiv').style.display = 'none';
		
		document.getElementById('morningStiffness').value = "";
		document.getElementById('weakness').value = "";
		document.getElementById('inabilityToUseALimb').value = "";
		document.getElementById('disabilityToUseALimb').value = "";
		document.getElementById('limbSwelling').value = "";
		
		document.getElementById('morningStiffnessValue').value = "";
		document.getElementById('morningStiffnessValue').style.display = 'none';
		document.getElementById('weaknessValue').value = "";
		document.getElementById('weaknessValue').style.display = 'none';
		document.getElementById('disabilityToUseALimbValue').value = "";
		document.getElementById('disabilityToUseALimbValue').style.display = 'none';
		document.getElementById('inabilityToUseALimbValue').value = "";
		document.getElementById('inabilityToUseALimbValue').style.display = 'none';
		document.getElementById('limbSwellingValue').value = "";
		document.getElementById('limbSwellingValue').style.display = 'none';		

	}
}
function displayMorningStiffnessValue(val) {
	if (val == 'Yes') {
		document.getElementById('morningStiffnessValue').style.display = 'block';

	} else {
		document.getElementById('morningStiffnessValue').value = "";
		document.getElementById('morningStiffnessValue').style.display = 'none';

	}
}
function displayWeaknessValue(val) {
	if (val == 'Yes') {
		document.getElementById('weaknessValue').style.display = 'block';

	} else {
		document.getElementById('weaknessValue').value = "";
		document.getElementById('weaknessValue').style.display = 'none';

	}
}
function displayDisabilityInUsingALimbValue(val) {
	if (val == 'Yes') {
		document.getElementById('disabilityToUseALimbValue').style.display = 'block';

	} else {
		document.getElementById('disabilityToUseALimbValue').value = "";
		document.getElementById('disabilityToUseALimbValue').style.display = 'none';

	}
}
function displayInabilityToUseLimbValue(val) {
	if (val == 'Yes') {
		document.getElementById('inabilityToUseALimbValue').style.display = 'block';

	} else {
		document.getElementById('inabilityToUseALimbValue').value = "";
		document.getElementById('inabilityToUseALimbValue').style.display = 'none';

	}
}
function displaySwelling(val) {
	if (val == 'Yes') {
		document.getElementById('limbSwellingValue').style.display = 'block';

	} else {
		document.getElementById('limbSwellingValue').value = "";
		document.getElementById('limbSwellingValue').style.display = 'none';

	}
}
function displayNatureOfInjury(val) {
	var others = "";
	if (val) {
		document.getElementById('natureOfInjuryValue').style.display = 'block';
		var str="",i;
        var element = document.getElementById('natureOfInjury');
		for (i=0;i < element.options.length;i++) {
		    if (element.options[i].selected) {
		    	if(str.trim()!='')
		    		str = str+ ", "
		    	
		    		str =	str+element.options[i].value;
		    		if(others == "" && element.options[i].value == "Others")
		    			others = "Others";
		    }
		}
		document.getElementById('natureOfInjuryValue').value = str;
	} else {
		document.getElementById('natureOfInjuryValue').style.display = 'none';
	}
	if(others == 'Others') {
		document.getElementById('natureOfInjuryOthersValue').style.display = 'block';
	} else {
		document.getElementById('natureOfInjuryOthersValue').value = "";
		document.getElementById('natureOfInjuryOthersValue').style.display = 'none';
	}
}
function displaySite(val) {
	if (val == 'Yes') {
		document.getElementById('siteDiv').style.display = 'block';

	} else {
		
		document.getElementById('site').value = "";
		document.getElementById('natureOfGrowth').value = "";
		document.getElementById('size').value = "";
		document.getElementById('surface').value = "";
		document.getElementById('shape').value = "";
		document.getElementById('consistency').value = "";
		document.getElementById('planeOfTheSwelling').value = "";
		
		document.getElementById('siteDiv').style.display = 'none';

	}
}

function displayGrowthValue(val){
	if(val=='Pressure Symptoms'){
		document.getElementById('natureDiv').style.display = 'inline';
	}else{
	document.getElementById('natureDiv').style.display = 'none';	
	}
	
}

function displayTextValue(val, textLabel) {

	if (textLabel == 'Posterior') {
		if (val == 'Abnormal') {
			document.getElementById('posteriorEndOfSeptumValue').style.display = 'block';
		} else {
			document.getElementById('posteriorEndOfSeptumValue').style.display = 'none';
		}
	} else if (textLabel == 'VestibuleR') {
		if (val == 'Abnormal') {
			document.getElementById('rightVestibuleValue').style.display = 'block';
		} else {
			document.getElementById('rightVestibuleValue').style.display = 'none';
		}
	} else if (textLabel == 'VestibuleL') {
		if (val == 'Abnormal') {
			document.getElementById('leftVestibuleValue').style.display = 'block';
		} else {
			document.getElementById('leftVestibuleValue').style.display = 'none';
		}
		/*Columella changes*/
	}else if (textLabel == 'ColumellaR') {
			if (val == 'Abnormal') {
				document.getElementById('rightColumellaValue').style.display = 'block';
			} else {
				document.getElementById('rightColumellaValue').style.display = 'none';
			}
	}else if (textLabel == 'ColumellaL') {
		if (val == 'Abnormal') {
			document.getElementById('leftColumellaValue').style.display = 'block';
		} else {
			document.getElementById('leftColumellaValue').style.display = 'none';
		}
		/*Columella changes end*/
	} else if (textLabel == 'ChoaneL') {
		if (val == 'Abnormal') {
			document.getElementById('leftChoaneValue').style.display = 'block';
		} else {
			document.getElementById('leftChoaneValue').style.display = 'none';
		}
	} else if (textLabel == 'ChoaneR') {
		if (val == 'Abnormal') {
			document.getElementById('rightChoaneValue').style.display = 'block';
		} else {
			document.getElementById('rightChoaneValue').style.display = 'none';
		}
	} else if (textLabel == 'RoofL') {
		if (val == 'Abnormal') {
			document.getElementById('leftPostnatalRoofValue').style.display = 'block';
		} else {
			document.getElementById('leftPostnatalRoofValue').style.display = 'none';
		}
	} else if (textLabel == 'RoofR') {
		if (val == 'Abnormal') {
			document.getElementById('rightPostnatalRoofValue').style.display = 'block';
		} else {
			document.getElementById('rightPostnatalRoofValue').style.display = 'none';
		}
	} else if (textLabel == 'EtOnliaeL') {
		if (val == 'Abnormal') {
			document.getElementById('leftEtOnliaeValue').style.display = 'block';
		} else {
			document.getElementById('leftEtOnliaeValue').style.display = 'none';
		}
	} else if (textLabel == 'EtOnliaeR') {
		if (val == 'Abnormal') {
			document.getElementById('rightEtOnliaeValue').style.display = 'block';
		} else {
			document.getElementById('rightEtOnliaeValue').style.display = 'none';
		}
	} else if (textLabel == 'ForL') {
		if (val == 'Abnormal') {
			document.getElementById('leftForValue').style.display = 'block';
		} else {
			document.getElementById('leftForValue').style.display = 'none';
		}
	} else if (textLabel == 'ForR') {
		if (val == 'Abnormal') {
			document.getElementById('rightForValue').style.display = 'block';
		} else {
			document.getElementById('rightForValue').style.display = 'none';
		}
	} else if (textLabel == 'TurbinatesL') {
		if (val == 'Abnormal') {
			document.getElementById('leftPosteriorTurbinatesValue').style.display = 'block';
		} else {
			document.getElementById('leftPosteriorTurbinatesValue').style.display = 'none';
		}
	} else if (textLabel == 'TurbinatesR') {
		if (val == 'Abnormal') {
			document.getElementById('rightPosteriorTurbinatesValue').style.display = 'block';
		} else {
			document.getElementById('rightPosteriorTurbinatesValue').style.display = 'none';
		}
	} else if (textLabel == 'Teeth') {
		if (val == 'Abnormal') {
			document.getElementById('teethValue').style.display = 'block';
		} else {
			document.getElementById('teethValue').style.display = 'none';
		}
		
	} else if (textLabel == 'Gums') {
		if (val == 'Abnormal') {
			document.getElementById('gumsValue').style.display = 'block';
		} else {
			document.getElementById('gumsValue').style.display = 'none';
		}
		
	} else if (textLabel == 'RetromolarL') {
		if (val == 'Abnormal') {
			document.getElementById('retroMolarLeftValue').style.display = 'block';
		} else {
			document.getElementById('retroMolarLeftValue').style.display = 'none';
		}
	} else if (textLabel == 'RetromolarR') {
		if (val == 'Abnormal') {
			document.getElementById('retroMolarRightValue').style.display = 'block';
		} else {
			document.getElementById('retroMolarRightValue').style.display = 'none';
		}
	} else if (textLabel == 'Tongue') {
		if (val == 'Abnormal') {
			document.getElementById('tongueValue').style.display = 'block';
		} else {
			document.getElementById('tongueValue').style.display = 'none';
		}
	} else if (textLabel == 'Mouth') {
		if (val == 'Abnormal') {
			document.getElementById('mouthValue').style.display = 'block';
		} else {
			document.getElementById('mouthValue').style.display = 'none';
		}
	} else if (textLabel == 'LipsU') {
		if (val == 'Abnormal') {
			document.getElementById('upperLipsValue').style.display = 'block';
		} else {
			document.getElementById('upperLipsValue').style.display = 'none';
		}
	} else if (textLabel == 'LipsL') {
		if (val == 'Abnormal') {
			document.getElementById('lowerLipsValue').style.display = 'block';
		} else {
			document.getElementById('lowerLipsValue').style.display = 'none';
		}
	} else if (textLabel == 'Appearance') {
		if (val == 'Abnormal') {
			document.getElementById('externalAppearanceValue').style.display = 'block';
		} else {
			document.getElementById('externalAppearanceValue').style.display = 'none';
		}
	} else if (textLabel == 'Lymphnodes') {
		if (val == 'Yes') {
			document.getElementById('lymphnodesDiv').style.display = 'block';
		} else {
			document.getElementById('lymphnodesDiv').style.display = 'none';
		}
	} else if (textLabel == 'Swelling') {
		if (val == 'Yes') {
			document.getElementById('swellingDiv').style.display = 'block';
		} else {
			document.getElementById('swellingDiv').style.display = 'none';
		}
	} else if (textLabel == 'Laryngeal') {
		if (val == 'Abnormal') {
			document.getElementById('laryngealFrameworkValue').style.display = 'block';
		} else {
			document.getElementById('laryngealFrameworkValue').style.display = 'none';
		}
	} else if (textLabel == 'MastoidTendernessL') {
		if (val == 'Yes') {
			document.getElementById('tragalTendernessLeftList').style.display = 'block';
		} else {
			document.getElementById('tragalTendernessLeftList').style.display = 'none';
		}
	} else if (textLabel == 'MastoidTendernessR') {
		if (val == 'Yes') {
			document.getElementById('tragalTendernessRightList').style.display = 'block';
		} else {
			document.getElementById('tragalTendernessRightList').style.display = 'none';
		}
	} else if (textLabel == 'Spontaneous') {
		if (val == 'Yes') {
			document.getElementById('spontaneousDiv').style.display = 'block';
		} else {
			document.getElementById('spontaneousDiv').style.display = 'none';
		}
	} else if (textLabel == 'FistulaSignL') {
		if (val == 'Positive') {
			document.getElementById('leftFistulaSignDiv').style.display = 'block';
		} else {
			document.getElementById('leftFistulaSignDiv').style.display = 'none';
		}
	} else if (textLabel == 'FistulaSignR') {
		if (val == 'Positive') {
			document.getElementById('rightFistulaSignDiv').style.display = 'block';
		} else {
			document.getElementById('rightFistulaSignDiv').style.display = 'none';
		}
	} else if (textLabel == 'FacialNerveL') {
		if (val == 'Palsy') {
			document.getElementById('leftGradingDiv').style.display = 'block';
		} else if ('Normal') {
			document.getElementById('leftGradingDiv').style.display = 'none';

		}
	} else if (textLabel == 'FacialNerveR') {
		if (val == 'Palsy') {
			document.getElementById('rightGradingDiv').style.display = 'block';
		} else if ('Normal') {
			document.getElementById('rightGradingDiv').style.display = 'none';

		}
	} else if (textLabel == 'Fixity') {
		if (val == 'Yes') {
			document.getElementById('fixityToDeeperStructuresValue').style.display = 'block';
		} else {
			document.getElementById('fixityToDeeperStructuresValue').style.display = 'none';
		}
	} else if (textLabel == 'MobilityL') {
		if (val == 'Abnormal') {
			document.getElementById('leftMobilityValue').style.display = 'block';
		} else {
			document.getElementById('leftMobilityValue').style.display = 'none';
		}
	} else if (textLabel == 'MobilityR') {
		if (val == 'Abnormal') {
			document.getElementById('rightMobilityValue').style.display = 'block';
		} else {
			document.getElementById('rightMobilityValue').style.display = 'none';
		}
	} else if (textLabel == 'SurfaceL') {
		if (val == 'Regular') {
			document.getElementById('leftSurfaceValue').style.display = 'block';
		} else if (val == 'Irregular') {
			document.getElementById('leftSurfaceValue').style.display = 'block';
		} else {
			document.getElementById('leftSurfaceValue').style.display = 'none';
		}
	} else if (textLabel == 'SurfaceR') {
		if (val == 'Regular') {
			document.getElementById('rightSurfaceValue').style.display = 'block';
		} else if (val == 'Irregular') {
			document.getElementById('rightSurfaceValue').style.display = 'block';
		} else {
			document.getElementById('rightSurfaceValue').style.display = 'none';
		}
	} else if (textLabel == 'Deviation') {
		if (val == 'Yes') {
			document.getElementById('deviationDiv').style.display = 'block';
		} else {
			document.getElementById('deviationDiv').style.display = 'none';
		}
	} else if (textLabel == 'Lymphadenopathy') {
		if (val == 'Yes') {
			document.getElementById('lymphadenopathyValue').style.display = 'block';
		} else {
			document.getElementById('lymphadenopathyValue').style.display = 'none';
		}
	} else if (textLabel == 'LymphadenopathyGEN') {
		if (val == 'Yes') {
			document.getElementById('lymphadenopathyGenExamValue').style.display = 'block';
		} else {
			document.getElementById('lymphadenopathyGenExamValue').style.display = 'none';
		}
	} else if (textLabel == 'Oral Lesions') {
		if (val == 'Present') {
			document.getElementById('oralLesionsDiv').style.display = 'block';
		} else {
			document.getElementById('oralLesionsDiv').style.display = 'none';
		}
	} else if (textLabel == 'Preprosthetic Procedures') {
		if (document.getElementById('preprostheticProcedures').checked) {
			document.getElementById('preprostheticProceduresDiv').style.display = 'block';
		} else {
			document.getElementById('preprostheticProceduresDiv').style.display = 'none';
		}
	} else if (textLabel == 'Surgical Procedures') {
		if (document.getElementById('minorSurgicalProcedures').checked) {
			document.getElementById('minorSurgicalDiv').style.display = 'block';
		} else {
			document.getElementById('minorSurgicalDiv').style.display = 'none';
		}
	} else if (textLabel == 'Root Stumps') {
		if (val == 'Present') {
			document.getElementById('rootStumpsDiv').style.display = 'block';
		} else {
			document.getElementById('rootStumpsDiv').style.display = 'none';
		}
	} else if (textLabel == 'Mobile Teeth') {
		if (val == 'Present') {
			document.getElementById('mobileTeethDiv').style.display = 'block';
		} else {
			document.getElementById('mobileTeethDiv').style.display = 'none';
		}
	} else if (textLabel == 'Plaque') {
		if (val == 'Present') {
			document.getElementById('plaqueDiv').style.display = 'block';
		} else {
			document.getElementById('plaqueDiv').style.display = 'none';
		}
	} else if (textLabel == 'Calculus') {
		if (val == 'Present') {
			document.getElementById('calculusDiv').style.display = 'block';
		} else {
			document.getElementById('calculusDiv').style.display = 'none';
		}
	} else if (textLabel == 'Allergy') {
		if (val == 'Yes') {
			document.getElementById('historyOfAllergyDiv').style.display = 'block';
		} else {
			document.getElementById('historyOfAllergyDiv').style.display = 'none';
		}
	} else if (textLabel == 'DeviationM') {
		if (val == 'Present') {
			document.getElementById('deviationDiv').style.display = 'block';
		} else {
			document.getElementById('deviationDiv').style.display = 'none';
		}
	} else if (textLabel == 'Pain') {
		if (val == 'Present') {
			document.getElementById('painDiv').style.display = 'block';
		} else {
			document.getElementById('painDiv').style.display = 'none';
		}
	} else if (textLabel == 'Clicking') {
		if (val == 'Present') {
			document.getElementById('clickingDiv').style.display = 'block';
		} else {
			document.getElementById('clickingDiv').style.display = 'none';
		}
	} else if (textLabel == 'Mobility') {
		if (val == 'Yes') {
			document.getElementById('mobilityDiv').style.display = 'block';
		} else {
			document.getElementById('mobilityDiv').style.display = 'none';
		}
	} else if (textLabel == 'Fremitus') {
		if (val == 'Yes') {
			document.getElementById('fremitusDiv').style.display = 'block';
		} else {
			document.getElementById('fremitusDiv').style.display = 'none';
		}
	} else if (textLabel == 'Mucogingival') {
		if (val == 'Present') {
			document.getElementById('mucogingivalProblemsDiv').style.display = 'block';
		} else {
			document.getElementById('mucogingivalProblemsDiv').style.display = 'none';
		}
	} else if (textLabel == 'Furcation Involvement') {
		if (val == 'Yes') {
			document.getElementById('furcationInvolvementDiv').style.display = 'block';
		} else {
			document.getElementById('furcationInvolvementDiv').style.display = 'none';
		}
	} else if (textLabel == 'Chief Complaint') {
		if (val == 'Others') {
			document.getElementById('chiefComplaintDiv').style.display = 'block';
		} else {
			document.getElementById('chiefComplaintDiv').style.display = 'none';
		}
	} else if (textLabel == 'Facial Swelling') {
		if (val == 'Yes') {
			document.getElementById('facialSwellingaDiv').style.display = 'block';
		} else {
			document.getElementById('facialSwellingaDiv').style.display = 'none';
		}
	} else if (textLabel == 'Lymph Node Enlargement') {
		if (val == 'Yes') {
			document.getElementById('lymphNodeEnlargementDiv').style.display = 'block';
		} else {
			document.getElementById('lymphNodeEnlargementDiv').style.display = 'none';
		}
	} else if (textLabel == 'Sinus Tract') {
		if (val == 'Yes') {
			document.getElementById('sinusTractDiv').style.display = 'block';
		} else {
			document.getElementById('sinusTractDiv').style.display = 'none';
		}
	} else if (textLabel == 'LymphadenopathyO') {
		if (val == 'Present') {
			document.getElementById('lymphadenopathyDiv').style.display = 'block';
		} else {
			document.getElementById('lymphadenopathyDiv').style.display = 'none';
		}
	} else if (textLabel == 'Bacterial') {
		if (document.getElementById('bacterial').checked) {
			document.getElementById('bacterialValue').style.display = 'block';
		} else {
			document.getElementById('bacterialValue').style.display = 'none';
		}
	} else if (textLabel == 'Viral') {
		if (document.getElementById('viral').checked) {
			document.getElementById('viralValue').style.display = 'block';
		} else {
			document.getElementById('viralValue').style.display = 'none';
		}
	} else if (textLabel == 'Parasitic') {
		if (document.getElementById('parasitic').checked) {
			document.getElementById('parasiticValue').style.display = 'block';
		} else {
			document.getElementById('parasiticValue').style.display = 'none';
		}
	} else if (textLabel == 'diseasesN') {
		if (val == "other") {
			document.getElementById('natalHistoryValue').style.display = 'block';
		} else {
			document.getElementById('natalHistoryValue').style.display = 'none';
		}
	} else if (textLabel == 'Speech') {
		if (val == "Abnormal") {
			document.getElementById('speechValue').style.display = 'block';
		} else {
			document.getElementById('speechValue').style.display = 'none';
		}
	} else if (textLabel == 'Deglutition') {
		if (val == "Abnormal") {
			document.getElementById('deglutitionDiv').style.display = 'block';
		} else {
			document.getElementById('deglutitionDiv').style.display = 'none';
		}
	} else if (textLabel == 'Palpable') {
		if (val == "Yes") {
			document.getElementById('palpablePulsationValue').style.display = 'block';
		} else {
			document.getElementById('palpablePulsationValue').style.display = 'none';
		}
	}
	
	else if (textLabel == 'Precipitation') {
		if (val == 'Yes') {
			document.getElementById('precipitationSpecifyDiv').style.display = 'block';
		} else {
			document.getElementById('precipitationSpecifyDiv').style.display = 'none';
		}

	}
	else if (textLabel == 'OthersSourceOfReferral') {
		if (val == 'Yes') {
			document.getElementById('othersSourceOfReferralDiv').style.display = 'block';
		} else {
			document.getElementById('othersSourceOfReferralDiv').style.display = 'none';
		}

	}
	else if (textLabel == 'CongitiveSymptoms') {
		if (val == 'Present') {
			document.getElementById('congitiveSymptomsVal').style.display = 'block';
		} else {
			document.getElementById('congitiveSymptomsVal').style.display = 'none';
		}

	}
	else if (textLabel == 'OnsetCongitiveSymptoms') {
		if (document.getElementById("onsetCongitiveSymptoms").checked) {
			document.getElementById('onsetCongitiveSymptomsVal').style.display = 'block';
		} else {
			document.getElementById('onsetCongitiveSymptomsVal').style.display = 'none';
			document.getElementById('overShort').value="";
			document.getElementById('gradual').value="";
		}

	}
	else if (textLabel == 'DistrurbedConsciousness') {
		if (document.getElementById("distrurbedConsciousness").checked) {
			document.getElementById('distrurbedConsciousnessVal').style.display = 'block';
		} else {
			document.getElementById('distrurbedConsciousnessVal').style.display = 'none';
			document.getElementById('rcoaoe').value="";
			document.getElementById('iaac').value="";
		}

	}
	
	
	else if (textLabel == 'PsychoticSymptoms') {
		if (val == 'Present') {
			document.getElementById('psychoticSymptomsVal').style.display = 'block';
		} else {
			document.getElementById('psychoticSymptomsVal').style.display = 'none';
		}

	}
	else if (textLabel == 'ManicSymptoms') {
		if (val == 'Present') {
			document.getElementById('manicSymptomsVal').style.display = 'block';
		} else {
			document.getElementById('manicSymptomsVal').style.display = 'none';
		}

	}
	else if (textLabel == 'DepressiveSymptoms') {
		if (val == 'Present') {
			document.getElementById('depressiveSymptomsVal').style.display = 'block';
		} else {
			document.getElementById('depressiveSymptomsVal').style.display = 'none';
		}

	}
	
	
	else if (textLabel == 'AnxietySymptoms') {
		if (val == 'Present') {
			document.getElementById('anxietySymptomsDiv').style.display = 'block';
		} else {
			document.getElementById('anxietySymptomsDiv').style.display = 'none';
		}

	}
	
	
	else if (textLabel == 'Sagis') {
		if (val == 'Present') {
			document.getElementById('sagisDiv').style.display = 'block';
		} else {
			document.getElementById('sagisDiv').style.display = 'none';
		}

	}
	
	
	else if (textLabel == 'EatingSymptoms') {
		if (val == 'Present') {
			document.getElementById('eatingSymptomsDiv').style.display = 'block';
		} else {
			document.getElementById('eatingSymptomsDiv').style.display = 'none';
		}

	}
	
	
	else if (textLabel == 'SleepSymptoms') {
		if (val == 'Present') {
			document.getElementById('sleepSymptomsDiv').style.display = 'block';
		} else {
			document.getElementById('sleepSymptomsDiv').style.display = 'none';
		}

	}
	
	
	else if (textLabel == 'ImpulseDyscontrolSymptoms') {
		if (val == 'Present') {
			document.getElementById('impulseDyscontrolSymptomsDiv').style.display = 'block';
		} else {
			document.getElementById('impulseDyscontrolSymptomsDiv').style.display = 'none';
		}

	}
	
	else if (textLabel == 'PastPsychiatricHistory') {
		if (val == 'Present') {
			document.getElementById('pastPsychiatricHistoryDiv').style.display = 'block';
		} else {
			document.getElementById('pastPsychiatricHistoryDiv').style.display = 'none';
		}

	}
	else if (textLabel == 'PastHistoryOfDeliberateSelfHarm') {
		if (val == 'Present') {
			document.getElementById('pastHistoryOfDeliberateSelfHarmDiv').style.display = 'block';
		} else {
			document.getElementById('pastHistoryOfDeliberateSelfHarmDiv').style.display = 'none';
		}

	}
	else if (textLabel == 'SubstanceHistory') {
		if (val == 'Present') {
			document.getElementById('substanceHistoryDiv').style.display = 'block';
		} else {
			document.getElementById('substanceHistoryDiv').style.display = 'none';
		}

	}
	
	
	else if (textLabel == 'SubstanceOfChoiceVal') {
		if (val == 'Others') {
			document.getElementById('substanceOfChoiceVal').style.display = 'block';
		} else {
			document.getElementById('substanceOfChoiceVal').style.display = 'none';
		}

	}
	

	else if (textLabel == 'SubstanceRelatedLegalProblem') {
		if (document.getElementById("substanceRelatedLegalProblem").checked) {
			document.getElementById('substanceRelatedLegalProblemVal').style.display = 'block';
		} else {
			document.getElementById('substanceRelatedLegalProblemVal').style.display = 'none';
			
			
		}
	

	}
	else if (textLabel == 'Current') {
		if (document.getElementById("currentWs").checked) {
			document.getElementById('currentWsVal').style.display = 'block';
		} else {
			document.getElementById('currentWsVal').style.display = 'none';
			
			
		}
	

	}
	
	else if (textLabel == 'Past') {
		if (document.getElementById("pastWs").checked) {
			document.getElementById('pastWsVal').style.display = 'block';
		} else {
			document.getElementById('pastWsVal').style.display = 'none';
			
			
		}
	

	}
	else if (textLabel == 'ptfsud') {
		if (val == 'Yes') {
			document.getElementById('ptfsudVal').style.display = 'block';
		} else {
			document.getElementById('ptfsudVal').style.display = 'none';
		}

	}
	else if (textLabel == 'AbnormalPersonality') {
		if (val == 'Present') {
			document.getElementById('abnormalPersonalityDiv').style.display = 'block';
		} else {
			document.getElementById('abnormalPersonalityDiv').style.display = 'none';
		}

	}
	
	
	
	else if (textLabel == 'TalkImpaired') {
		if (val == 'Impaired') {
			document.getElementById('talkImpairedVal').style.display = 'block';
		} else {
			document.getElementById('talkImpairedVal').style.display = 'none';
		}

	}
	else if (textLabel == 'MuteImpaired') {
		if (val == 'Impaired') {
			document.getElementById('muteImpairedVal').style.display = 'block';
		} else {
			document.getElementById('muteImpairedVal').style.display = 'none';
		}

	}
	else if (textLabel == 'Mute') {
		if (document.getElementById("mute").checked) {
			document.getElementById('muteDiv').style.display = 'block';
		} else {
			document.getElementById('muteDiv').style.display = 'none';
		}

	}
	else if (textLabel == 'OrienationImpaired') {
		if (val == 'Impaired') {
			document.getElementById('orienationImpairedVal').style.display = 'block';
		} else {
			document.getElementById('orienationImpairedVal').style.display = 'none';
		}

	}
	
	else if (textLabel == 'PersonImpaired') {
		if (val == 'Impaired') {
			document.getElementById('personImpairedVal').style.display = 'block';
		} else {
			document.getElementById('personImpairedVal').style.display = 'none';
		}

	}
	
	else if (textLabel == 'TimeImpaired') {
		if (val == 'Impaired') {
			document.getElementById('timeImpairedVal').style.display = 'block';
		} else {
			document.getElementById('timeImpairedVal').style.display = 'none';
		}

	}
	
	
	else if (textLabel == 'PlaceImpaired') {
		if (val == 'Impaired') {
			document.getElementById('placeImpairedVal').style.display = 'block';
		} else {
			document.getElementById('placeImpairedVal').style.display = 'none';
		}

	}
	else if (textLabel == 'Perception') {
		if (val == 'Present') {
			document.getElementById('perceptionVal').style.display = 'block';
		} else {
			document.getElementById('perceptionVal').style.display = 'none';
		}

	}
	
	
	
	else if (textLabel == 'Hallucinations') {
		if (val == 'Present') {
			document.getElementById('hallucinationsDiv').style.display = 'block';
		} else {
			document.getElementById('hallucinationsDiv').style.display = 'none';
		}

	}
	
	
	
	else if (textLabel == 'Auditory') {
		if (document.getElementById("auditory").checked) {
			document.getElementById('auditoryDiv').style.display = 'block';
		} else {
			document.getElementById('auditoryDiv').style.display = 'none';
		}

	}
	
	else if (textLabel == 'Memory') {
		if (val == 'Impaired') {
			document.getElementById('memoryImpaired').style.display = 'block';
		} else {
			document.getElementById('memoryImpaired').style.display = 'none';
		}

	}
	
	else if (textLabel == 'LanguageImpaired') {
		if (val == 'Impaired') {
			document.getElementById('languageImpairedVal').style.display = 'block';
		} else {
			document.getElementById('languageImpairedVal').style.display = 'none';
		}

	}
	
	else if (textLabel == 'checkNoKnow') {
		if (document.getElementById("notKnow").checked) {
			document.getElementById('noKnowVal').style.display = 'block';
		} else {
			document.getElementById('noKnowVal').style.display = 'none';
			document.getElementById('onset').value="";
			
		}

	}
	else if (textLabel == 'Delusional') {
		if (document.getElementById("delusional").checked) {
			document.getElementById('delusionalValDiv').style.display = 'block';
		} else {
			document.getElementById('delusionalValDiv').style.display = 'none';
			
			
		}

	}
	
	else if (textLabel == 'Suicidal') {
		if (val == 'Plan' || val == 'Present') {
			document.getElementById('suicidalOther').style.display = 'block';
		} else {
			document.getElementById('suicidalOther').style.display = 'none';
		}

	}
	else if (textLabel == 'Homicidal') {
		if (val == 'Plan' || val == 'Present') {
			document.getElementById('homicidalOther').style.display = 'block';
		} else {
			document.getElementById('homicidalOther').style.display = 'none';
		}

	}
	}

function displayOtherValue(val, textLabel) {
	if (textLabel == '18') {
		if (val == 'Others') {
			document.getElementById('18Div').style.display = 'block';
		} else {
			document.getElementById('18Div').style.display = 'none';
		}
	} else if (textLabel == '17') {
		if (val == 'Others') {
			document.getElementById('17Div').style.display = 'block';
		} else {
			document.getElementById('17Div').style.display = 'none';
		}
	} else if (textLabel == '16') {
		if (val == 'Others') {
			document.getElementById('16Div').style.display = 'block';
		} else {
			document.getElementById('16Div').style.display = 'none';
		}
	} else if (textLabel == '15') {
		if (val == 'Others') {
			document.getElementById('15Div').style.display = 'block';
		} else {
			document.getElementById('15Div').style.display = 'none';
		}
	} else if (textLabel == '14') {
		if (val == 'Others') {
			document.getElementById('14Div').style.display = 'block';
		} else {
			document.getElementById('14Div').style.display = 'none';
		}
	} else if (textLabel == '13') {
		if (val == 'Others') {
			document.getElementById('13Div').style.display = 'block';
		} else {
			document.getElementById('13Div').style.display = 'none';
		}
	} else if (textLabel == '12') {
		if (val == 'Others') {
			document.getElementById('12Div').style.display = 'block';
		} else {
			document.getElementById('12Div').style.display = 'none';
		}
	} else if (textLabel == '11') {
		if (val == 'Others') {
			document.getElementById('11Div').style.display = 'block';
		} else {
			document.getElementById('11Div').style.display = 'none';
		}
	} else if (textLabel == '21') {
		if (val == 'Others') {
			document.getElementById('21Div').style.display = 'block';
		} else {
			document.getElementById('21Div').style.display = 'none';
		}
	} else if (textLabel == '22') {
		if (val == 'Others') {
			document.getElementById('22Div').style.display = 'block';
		} else {
			document.getElementById('22Div').style.display = 'none';
		}
	} else if (textLabel == '23') {
		if (val == 'Others') {
			document.getElementById('23Div').style.display = 'block';
		} else {
			document.getElementById('23Div').style.display = 'none';
		}
	} else if (textLabel == '24') {
		if (val == 'Others') {
			document.getElementById('24Div').style.display = 'block';
		} else {
			document.getElementById('24Div').style.display = 'none';
		}
	} else if (textLabel == '25') {
		if (val == 'Others') {
			document.getElementById('25Div').style.display = 'block';
		} else {
			document.getElementById('25Div').style.display = 'none';
		}
	} else if (textLabel == '26') {
		if (val == 'Others') {
			document.getElementById('26Div').style.display = 'block';
		} else {
			document.getElementById('26Div').style.display = 'none';
		}
	} else if (textLabel == '27') {
		if (val == 'Others') {
			document.getElementById('27Div').style.display = 'block';
		} else {
			document.getElementById('27Div').style.display = 'none';
		}
	} else if (textLabel == '28') {
		if (val == 'Others') {
			document.getElementById('28Div').style.display = 'block';
		} else {
			document.getElementById('28Div').style.display = 'none';
		}
	} else if (textLabel == '48') {
		if (val == 'Others') {
			document.getElementById('48Div').style.display = 'block';
		} else {
			document.getElementById('48Div').style.display = 'none';
		}
	} else if (textLabel == '47') {
		if (val == 'Others') {
			document.getElementById('47Div').style.display = 'block';
		} else {
			document.getElementById('47Div').style.display = 'none';
		}
	} else if (textLabel == '46') {
		if (val == 'Others') {
			document.getElementById('46Div').style.display = 'block';
		} else {
			document.getElementById('46Div').style.display = 'none';
		}
	} else if (textLabel == '45') {
		if (val == 'Others') {
			document.getElementById('45Div').style.display = 'block';
		} else {
			document.getElementById('45Div').style.display = 'none';
		}
	} else if (textLabel == '44') {
		if (val == 'Others') {
			document.getElementById('44Div').style.display = 'block';
		} else {
			document.getElementById('44Div').style.display = 'none';
		}
	} else if (textLabel == '43') {
		if (val == 'Others') {
			document.getElementById('43Div').style.display = 'block';
		} else {
			document.getElementById('43Div').style.display = 'none';
		}
	} else if (textLabel == '42') {
		if (val == 'Others') {
			document.getElementById('42Div').style.display = 'block';
		} else {
			document.getElementById('42Div').style.display = 'none';
		}
	} else if (textLabel == '41') {
		if (val == 'Others') {
			document.getElementById('41Div').style.display = 'block';
		} else {
			document.getElementById('41Div').style.display = 'none';
		}
	} else if (textLabel == '31') {
		if (val == 'Others') {
			document.getElementById('31Div').style.display = 'block';
		} else {
			document.getElementById('31Div').style.display = 'none';
		}
	} else if (textLabel == '32') {
		if (val == 'Others') {
			document.getElementById('32Div').style.display = 'block';
		} else {
			document.getElementById('32Div').style.display = 'none';
		}
	} else if (textLabel == '33') {
		if (val == 'Others') {
			document.getElementById('33Div').style.display = 'block';
		} else {
			document.getElementById('33Div').style.display = 'none';
		}
	} else if (textLabel == '34') {
		if (val == 'Others') {
			document.getElementById('34Div').style.display = 'block';
		} else {
			document.getElementById('34Div').style.display = 'none';
		}
	} else if (textLabel == '35') {
		if (val == 'Others') {
			document.getElementById('35Div').style.display = 'block';
		} else {
			document.getElementById('35Div').style.display = 'none';
		}
	} else if (textLabel == '36') {
		if (val == 'Others') {
			document.getElementById('36Div').style.display = 'block';
		} else {
			document.getElementById('36Div').style.display = 'none';
		}
	} else if (textLabel == '37') {
		if (val == 'Others') {
			document.getElementById('37Div').style.display = 'block';
		} else {
			document.getElementById('37Div').style.display = 'none';
		}
	} else if (textLabel == '38') {
		if (val == 'Others') {
			document.getElementById('38Div').style.display = 'block';
		} else {
			document.getElementById('38Div').style.display = 'none';
		}
	}

}

function displayRadioOtherValue(val, textLabel) {
	if (textLabel == '18') {
		if (val == 'Others') {
			document.getElementById('18AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('18AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '17') {
		if (val == 'Others') {
			document.getElementById('17AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('17AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '16') {
		if (val == 'Others') {
			document.getElementById('38AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('38AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '15') {
		if (val == 'Others') {
			document.getElementById('15AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('15AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '14') {
		if (val == 'Others') {
			document.getElementById('14AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('14AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '13') {
		if (val == 'Others') {
			document.getElementById('13AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('13AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '12') {
		if (val == 'Others') {
			document.getElementById('12AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('12AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '11') {
		if (val == 'Others') {
			document.getElementById('11AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('11AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '21') {
		if (val == 'Others') {
			document.getElementById('21AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('21AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '22') {
		if (val == 'Others') {
			document.getElementById('22AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('22AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '23') {
		if (val == 'Others') {
			document.getElementById('23AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('23AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '24') {
		if (val == 'Others') {
			document.getElementById('24AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('24AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '25') {
		if (val == 'Others') {
			document.getElementById('25AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('25AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '26') {
		if (val == 'Others') {
			document.getElementById('26AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('26AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '27') {
		if (val == 'Others') {
			document.getElementById('27AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('27AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '28') {
		if (val == 'Others') {
			document.getElementById('28AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('28AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '48') {
		if (val == 'Others') {
			document.getElementById('48AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('48AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '47') {
		if (val == 'Others') {
			document.getElementById('47AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('47AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '46') {
		if (val == 'Others') {
			document.getElementById('46AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('46AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '45') {
		if (val == 'Others') {
			document.getElementById('45AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('45AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '44') {
		if (val == 'Others') {
			document.getElementById('44AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('44AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '43') {
		if (val == 'Others') {
			document.getElementById('43AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('43AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '42') {
		if (val == 'Others') {
			document.getElementById('42AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('42AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '41') {
		if (val == 'Others') {
			document.getElementById('41AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('41AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '31') {
		if (val == 'Others') {
			document.getElementById('31AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('31AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '32') {
		if (val == 'Others') {
			document.getElementById('32AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('32AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '33') {
		if (val == 'Others') {
			document.getElementById('33AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('33AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '34') {
		if (val == 'Others') {
			document.getElementById('348AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('34AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '35') {
		if (val == 'Others') {
			document.getElementById('35AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('35AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '36') {
		if (val == 'Others') {
			document.getElementById('36AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('36AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '37') {
		if (val == 'Others') {
			document.getElementById('37AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('37AnotherDiv').style.display = 'none';
		}
	} else if (textLabel == '38') {
		if (val == 'Others') {
			document.getElementById('38AnotherDiv').style.display = 'block';
		} else {
			document.getElementById('38AnotherDiv').style.display = 'none';
		}
	}

}

// added by govind 14-10-2016 end
function checkMappedChargeIP(val, count) {
	jQuery(function($) {
		if (val != "") {
			$
					.ajax({
						url : "/hms/hms/opd?method=checkMappedCharge" + "&"
								+ csrfTokenName + "=" + csrfTokenValue,
						data : {
							chargeName : val
						},
						success : function(result) {
							var str = result.split("|");
							if (str[0] == "success") {
								$("#procedureId" + count).val(str[1]);
								for (var xx = 0; xx <= count - 1; xx++) {
									if ($("#procedureId" + count).val() == $(
											"#procedureId" + xx).val()) {
										$("#procedureId" + count).val("");
										$("#proscedureName" + count).val("");
										alert("charge already taken");
										break;
									}
								}
							} else if (str[0] == "failed") {
								alert(val.toUpperCase()
										+ " charge is not configured. Please configure before prescribe.");
								$("#proscedureName" + count).val("");
								$("#procedureId" + count).val("");
							}
						}
					});
		}
	});
}// added by govind 14-10-2016 end

function addRowForPastHistory() {
	var tbl = document.getElementById('pastHistoryGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('pastHistoryCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'pastHistoryRadio' + iteration;
	e1.id = 'pastHistoryRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'disease' + iteration;
	e1.id = 'disease' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Allergy', 'Allergy');
	e1.options[2] = new Option('Diabetes Mellitus', 'Diabetes Mellitus');
	e1.options[3] = new Option('Hypertension', 'Hypertension');
	e1.options[4] = new Option('Tuberculosis', 'Tuberculosis');
	e1.options[5] = new Option('Bronchial Asthma', 'Bronchial Asthma');
	e1.options[6] = new Option('Cardiovascular disease','Cardiovascular disease');
	e1.options[7] = new Option('Kidney disease', 'Kidney disease');
	e1.options[8] = new Option('Malignancy', 'Malignancy');
	e1.options[9] = new Option('Acid peptic disease', 'Acid peptic disease');
	e1.options[10] = new Option('Swellings', 'Swellings');
	e1.options[11] = new Option('Varicose veins', 'Varicose veins');
	e1.options[12] = new Option('Claudication', 'Claudication');
	e1.options[13] = new Option('Collagen diseases', 'Collagen diseases');
	e1.options[14] = new Option('Genetic Illness', 'Genetic Illness');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'duration' + iteration;
	e1.id = 'duration' + iteration;
	e1.maxLength = 5;
	e1.onkeypress = function (event) {
		  javascript: return isNumberDecimal(event)
	};
	e1.setAttribute('validate', 'Duration,float,no');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'numberOfEpisodes' + iteration;
	e1.id = 'numberOfEpisodes' + iteration;
	e1.setAttribute('style', 'width:95px;');
	e1.maxLength = 2;
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event)
	};
	e1.setAttribute('validate', 'Number Of Episodes,int,no');
	
	var e22 = document.createElement('input');
	e22.type = 'text';
	e22.name = 'detailsOne' + iteration;
	e22.id = 'detailsOne' + iteration;
	e22.maxLength = 32;
	e22.setAttribute('style', 'width:95px;');
	cellRight1.appendChild(e1);
	cellRight1.appendChild(e22);
	

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'drugs' + iteration;
	e1.id = 'drugs' + iteration;
	e1.setAttribute('style', 'width:95px;');
	e1.maxLength = 32;

	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name = 'detailsTwo' + iteration;
	e2.id = 'detailsTwo' + iteration;
	e2.setAttribute('style', 'width:95px;');
	e2.maxLength = 32;
	cellRight1.appendChild(e2);
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'anyOtherSpecifyAnother' + iteration;
	e1.id = 'anyOtherSpecifyAnother' + iteration;
	e1.maxLength = 32;

	cellRight1.appendChild(e1);
}

function addRowForFamilyHistory() {
	var tbl = document.getElementById('familyHistoryGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('familyHistoryCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'familyHistoryRadio' + iteration;
	e1.id = 'familyHistoryRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'diseaseF' + iteration;
	e1.id = 'diseaseF' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Allergy', 'Allergy');
	e1.options[2] = new Option('Diabetes Mellitus', 'Diabetes Mellitus');
	e1.options[3] = new Option('Hypertension', 'Hypertension');
	e1.options[4] = new Option('Tuberculosis', 'Tuberculosis');
	e1.options[5] = new Option('Bronchial Asthma', 'Bronchial Asthma');
	e1.options[6] = new Option('Cardiovascular disease',
			'Cardiovascular disease');
	e1.options[7] = new Option('Kidney disease', 'Kidney disease');
	e1.options[8] = new Option('Malignancy', 'Malignancy');
	e1.options[9] = new Option('Acid peptic disease', 'Acid peptic disease');
	e1.options[10] = new Option('Swellings', 'Swellings');
	e1.options[11] = new Option('Varicose veins', 'Varicose veins');
	e1.options[12] = new Option('Claudication', 'Claudication');
	e1.options[13] = new Option('Collagen diseases', 'Collagen diseases');
	e1.options[14] = new Option('Genetic Illness', 'Genetic Illness');

	cellRight1.appendChild(e1);

	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'realationF' + iteration;
	e1.id = 'realationF' + iteration;
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < relationArray.length; i++) {
		e1.options[i + 1] = new Option(relationArray[i][1],	relationArray[i][0]);
	}

	cellRight1.appendChild(e1);
	
	/*var e1 = document.createElement('Select');
	e1.name = 'realationF' + iteration;
	e1.id = 'realationF' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Father', 'Father');
	e1.options[2] = new Option('Mother', 'Mother');
	e1.options[3] = new Option('Son', 'Son');
	e1.options[4] = new Option('Daughter', 'Daughter');
	e1.options[5] = new Option('PSO', 'PSO');
	e1.options[6] = new Option('Self', 'Self');
	e1.options[7] = new Option('Brother', 'Brother');
	e1.options[8] = new Option('Wife', 'Wife');
	e1.options[9] = new Option('Husband', 'Husband');
	e1.options[10] = new Option('Sister', 'Sister');
	e1.options[11] = new Option('Others', 'Others');
	e1.options[12] = new Option('Friend', 'Friend');
	e1.options[13] = new Option('Police', 'Police');
	e1.options[14] = new Option('Mother in law', 'Mother in law');
	e1.options[15] = new Option('Father in law', 'Father in law');
	e1.options[16] = new Option('Son in law', 'Son in law');
	e1.options[17] = new Option('Daugther in law', 'Daugther in law');
	
	cellRight1.appendChild(e1);*/
	
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'durationF' + iteration;
	e1.id = 'durationF' + iteration;
	e1.maxLength = 5;
	e1.onkeypress = function (event) {
		  javascript: return isNumberDecimal(event)
	};
	e1.setAttribute('validate', 'Duration,float,no');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'anyOtherSpecify' + iteration;
	e1.id = 'anyOtherSpecify' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

}

function addRowForCurrentPreviousSurgeries() {
	var tbl = document.getElementById('previousSurgeriesGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('previousSurgeriesCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'previousSurgeriesRadio' + iteration;
	e1.id = 'previousSurgeriesRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('textarea');
	e1.name = 'typeP' + iteration;
	e1.id = 'typeP' + iteration;
	e1.onblur=function(){
		setVitalValue(this.value,'typePTemp'+iteration);
		}
	e1.size = '30';
	e1.style.margin="0px 5px"; 
	e1.style.width="231px";
	e1.style.height="30px;"
	e1.maxLength = 150;
	cellRight1.appendChild(e1);

	var cell1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'dateYear' + (iteration);
	e1.size = '10';
	e1.id = 'dateYear' + (iteration);
	e1.className = 'date';
	var eImg = document.createElement('img');
	eImg.src = '/hms/jsp/images/cal.gif';
	eImg.style.display = 'inline';
	eImg.onclick = function(event) {
		setdate('', document.getElementById('dateYear' + iteration), event)
	};
	e1.maxLength = 4;
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event)
	};
	e1.onblur=function(){
		yearFormatDate(iteration);
		yearTempFormatDate(iteration);
		setVitalValue(this.value,'dateYear'+iteration);
		setVitalValue(this.value,'dateYearTemp'+iteration);
	}
	cell1.appendChild(e1);
	cell1.appendChild(eImg);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'institution' + iteration;
	e1.id = 'institution' + iteration;
	e1.size = '20';
	e1.onblur=function(){
		setVitalValue(this.value,'institutionTemp'+iteration);
		}
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'hospitalizationDuration' + iteration;
	e1.id = 'hospitalizationDuration' + iteration;
	e1.maxLength = 5;
	e1.onblur=function(){
		setVitalValue(this.value,'hospitalizationDurationTemp'+iteration);
		}
	e1.onkeypress = function (event) {
		  javascript: return isNumberDecimal(event)
	};
	e1.setAttribute('validate', 'Hospitalization Duration,float,no');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.onblur=function(){
		setVitalValue(this.value,'complicationsTemp'+iteration);
		}
	e1.name = 'complications' + iteration;
	e1.id = 'complications' + iteration;
	e1.maxLength = 32;
	cellRight1.appendChild(e1);

}

function removeRowForFamilyHistory() {
	var tbl = document.getElementById('familyHistoryGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('familyHistoryCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("familyHistoryRadio" + i) != null
				&& (typeof document.getElementById("familyHistoryRadio" + i).checked) != 'undefined'
				&& document.getElementById("familyHistoryRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("familyHistoryRadio" + i) != null
					&& (typeof document
							.getElementById("familyHistoryRadio" + i).checked) != 'undefined'
					&& document.getElementById("familyHistoryRadio" + i).checked) {
				var deleteRow = document.getElementById("familyHistoryRadio"
						+ i).parentNode.parentNode;
				document.getElementById("familyHistoryRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowForPastHistory() {
	var tbl = document.getElementById('pastHistoryGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('pastHistoryCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("pastHistoryRadio" + i) != null
				&& (typeof document.getElementById("pastHistoryRadio" + i).checked) != 'undefined'
				&& document.getElementById("pastHistoryRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("pastHistoryRadio" + i) != null
					&& (typeof document.getElementById("pastHistoryRadio" + i).checked) != 'undefined'
					&& document.getElementById("pastHistoryRadio" + i).checked) {
				var deleteRow = document.getElementById("pastHistoryRadio" + i).parentNode.parentNode;
				document.getElementById("pastHistoryRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowForCurrentPreviousSurgeries() {
	var tbl = document.getElementById('previousSurgeriesGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('previousSurgeriesCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("previousSurgeriesRadio" + i) != null
				&& (typeof document
						.getElementById("previousSurgeriesRadio" + i).checked) != 'undefined'
				&& document.getElementById("previousSurgeriesRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("previousSurgeriesRadio" + i) != null
					&& (typeof document.getElementById("previousSurgeriesRadio"
							+ i).checked) != 'undefined'
					&& document.getElementById("previousSurgeriesRadio" + i).checked) {
				var deleteRow = document
						.getElementById("previousSurgeriesRadio" + i).parentNode.parentNode;
				document.getElementById("previousSurgeriesRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function displayGeneralSurgryTextValue(val, textLabel) {

	if (textLabel == 'Bleeding') {
		if (val == 'Yes') {
			document.getElementById('bleedingDiv').style.display = 'block';
		} else {
			document.getElementById('bleedingDiv').style.display = 'none';
		}
	} else if (textLabel == 'Claudication') {
		if (val == 'Yes') {
			document.getElementById('claudicationDiv').style.display = 'block';
		} else {
			document.getElementById('claudicationDiv').style.display = 'none';
		}
	} else if (textLabel == 'Constipation') {
		if (val == 'Yes') {
			document.getElementById('constipationDiv').style.display = 'block';
		} else {
			document.getElementById('constipationDiv').style.display = 'none';
		}
	} else if (textLabel == 'Cough') {
		if (val == 'Yes') {
			document.getElementById('coughDiv').style.display = 'block';
		} else {
			document.getElementById('coughDiv').style.display = 'none';
		}
	} else if (textLabel == 'DilatedVeins') {
		if (val == 'Yes') {
			document.getElementById('dilatedVeinsDiv').style.display = 'block';
		} else {
			document.getElementById('dilatedVeinsDiv').style.display = 'none';
		}
	} else if (textLabel == 'Discharge') {
		if (val == 'Yes') {
			document.getElementById('dischargeDiv').style.display = 'block';
		} else {
			document.getElementById('dischargeDiv').style.display = 'none';
		}
	} else if (textLabel == 'Discoloration') {
		if (val == 'Yes') {
			document.getElementById('discolorationDiv').style.display = 'block';
		} else {
			document.getElementById('discolorationDiv').style.display = 'none';
		}
	} else if (textLabel == 'Distension') {
		if (val == 'Yes') {
			document.getElementById('distensionDiv').style.display = 'block';
		} else {
			document.getElementById('distensionDiv').style.display = 'none';
		}
	} else if (textLabel == 'Dysphagia') {
		if (val == 'Yes') {
			document.getElementById('dysphagiaDiv').style.display = 'block';
		} else {
			document.getElementById('dysphagiaDiv').style.display = 'none';
		}
	} else if (textLabel == 'Dyspnea') {
		if (val == 'Yes') {
			document.getElementById('dyspneaDiv').style.display = 'block';
		} else {
			document.getElementById('dyspneaDiv').style.display = 'none';
		}
	} else if (textLabel == 'Dysuria') {
		if (val == 'Yes') {
			document.getElementById('dysuriaDiv').style.display = 'block';
		} else {
			document.getElementById('dysuriaDiv').style.display = 'none';
		}
	} else if (textLabel == 'Fever') {
		if (val == 'Yes') {
			document.getElementById('feverDiv').style.display = 'block';
		} else {
			document.getElementById('feverDiv').style.display = 'none';
		}
	} else if (textLabel == 'Haematochezia') {
		if (val == 'Yes') {
			document.getElementById('haematocheziaDiv').style.display = 'block';
		} else {
			document.getElementById('haematocheziaDiv').style.display = 'none';
		}
	} else if (textLabel == 'Haemetemesis') {
		if (val == 'Yes') {
			document.getElementById('haemetemesisDiv').style.display = 'block';
		} else {
			document.getElementById('haemetemesisDiv').style.display = 'none';
		}
	} else if (textLabel == 'Heartburn') {
		if (val == 'Yes') {
			document.getElementById('heartburnDiv').style.display = 'block';
		} else {
			document.getElementById('heartburnDiv').style.display = 'none';
		}
	} else if (textLabel == 'Jaundice') {
		if (val == 'Yes') {
			document.getElementById('jaundiceDiv').style.display = 'block';
		} else {
			document.getElementById('jaundiceDiv').style.display = 'none';
		}
	} else if (textLabel == 'Malena') {
		if (val == 'Yes') {
			document.getElementById('malenaDiv').style.display = 'block';
		} else {
			document.getElementById('malenaDiv').style.display = 'none';
		}
	} else if (textLabel == 'Nausea') {
		if (val == 'Yes') {
			document.getElementById('nauseaDiv').style.display = 'block';
		} else {
			document.getElementById('nauseaDiv').style.display = 'none';
		}
	} else if (textLabel == 'Pain') {
		if (val == 'Yes') {
			document.getElementById('painDiv').style.display = 'block';
		} else {
			document.getElementById('painDiv').style.display = 'none';
		}
	} else if (textLabel == 'Swelling') {
		if (val == 'Yes') {
			document.getElementById('swellingDiv').style.display = 'block';
		} else {
			document.getElementById('swellingDiv').style.display = 'none';
		}
	} else if (textLabel == 'Trauma') {
		if (val == 'Yes') {
			document.getElementById('traumaDiv').style.display = 'block';
		} else {
			document.getElementById('traumaDiv').style.display = 'none';
		}
	} else if (textLabel == 'Ulcer') {
		if (val == 'Yes') {
			document.getElementById('ulcerDiv').style.display = 'block';
		} else {
			document.getElementById('ulcerDiv').style.display = 'none';
		}
	} else if (textLabel == 'Urinary') {
		if (val == 'Yes') {
			document.getElementById('urinaryObstructionDiv').style.display = 'block';
		} else {
			document.getElementById('urinaryObstructionDiv').style.display = 'none';
		}
	} else if (textLabel == 'Vomiting') {
		if (val == 'Yes') {
			document.getElementById('vomitingDiv').style.display = 'block';
		} else {
			document.getElementById('vomitingDiv').style.display = 'none';
		}
	} else if (textLabel == 'PersonalHabits') {
		if (val == 'yes') {
			document.getElementById('personalHabitsDiv').style.display = 'block';
		} else {
			document.getElementById('personalHabitsDiv').style.display = 'none';
		}
	} else if (textLabel == 'Smoking') {
		if (document.getElementById('smokingValue').checked) {
			document.getElementById('smokingDiv').style.display = 'block';
		} else {
			document.getElementById('smokingDiv').style.display = 'none';
		}
	} else if (textLabel == 'Alcohol') {
		if (document.getElementById('alcoholValue').checked) {
			document.getElementById('alcoholDiv').style.display = 'block';
		} else {
			document.getElementById('alcoholDiv').style.display = 'none';
		}
	} else if (textLabel == 'Addictions') {
		if (val == 'yes') {
			document.getElementById('otherAddictionsDiv').style.display = 'block';
		} else {
			document.getElementById('otherAddictionsDiv').style.display = 'none';
		}
	} else if (textLabel == 'SwellingsCheck') {
		if (val.checked == true) {
			document.getElementById('swellings').style.display = 'block';
		} else {
			document.getElementById('swellings').style.display = 'none';
		}
	} else if (textLabel == 'Liver') {
		if (val.checked == true) {
			document.getElementById('liver').style.display = 'block';
		} else {
			document.getElementById('liver').style.display = 'none';
		}
	} else if (textLabel == 'Lesion') {
		if (val == 'Yes') {
			document.getElementById('lesionYesDiv').style.display = 'block';
		} else {
			document.getElementById('lesionYesDiv').style.display = 'none';
		}
	} else if (textLabel == 'Lymph') {
		if (val == 'Yes') {
			document.getElementById('localLymphYesDiv').style.display = 'block';
		} else {
			document.getElementById('localLymphYesDiv').style.display = 'none';
		}
	} else if (textLabel == 'Vessels') {
		if (document.getElementById('localVessel').checked) {
			document.getElementById('localVesselPresentDiv').style.display = 'block';
		} else {
			document.getElementById('localVesselPresentDiv').style.display = 'none';
		}
	} else if (textLabel == 'Nerves') {
		if (document.getElementById('localNerves').checked) {
			document.getElementById('localNervesYesDiv').style.display = 'block';
		} else {
			document.getElementById('localNervesYesDiv').style.display = 'none';
		}
	} else if (textLabel == 'Joints') {
		if (document.getElementById('localJoints').checked) {
			document.getElementById('localJointsYesDiv').style.display = 'block';
		} else {
			document.getElementById('localJointsYesDiv').style.display = 'none';
		}
	} else if (textLabel == 'Nerves') {
		if (val == 'Yes') {
			document.getElementById('localNervesYesDiv').style.display = 'block';
		} else {
			document.getElementById('localNervesYesDiv').style.display = 'none';
		}
	} else if (textLabel == 'cavity') {
		if (val.checked == true) {
			document.getElementById('oralCavity').style.display = 'block';
		} else {
			document.getElementById('oralCavity').style.display = 'none';
		}
	} else if (textLabel == 'Tongue') {
		if (val.checked == true) {
			document.getElementById('tongue').style.display = 'block';
		} else {
			document.getElementById('tongue').style.display = 'none';
		}
	} else if (textLabel == 'Throat') {
		if (val.checked == true) {
			document.getElementById('throat').style.display = 'block';
		} else {
			document.getElementById('throat').style.display = 'none';
		}
	} else if (textLabel == 'Abdomen') {
		if (val.checked == true) {
			document.getElementById('abdomen').style.display = 'block';
		} else {
			document.getElementById('abdomen').style.display = 'none';
		}
	} else if (textLabel == 'Tenderness') {
		if (val == 'Yes') {
			document.getElementById('tendernessYesDiv').style.display = 'block';
		} else {
			document.getElementById('tendernessYesDiv').style.display = 'none';
		}
	} else if (textLabel == 'angles') {
		if (val.checked == true) {
			document.getElementById('renalAngles').style.display = 'block';
		} else {
			document.getElementById('renalAngles').style.display = 'none';
		}
	} else if (textLabel == 'space') {
		if (val.checked == true) {
			document.getElementById('traubeSpace').style.display = 'block';
		} else {
			document.getElementById('traubeSpace').style.display = 'none';
		}
	} else if (textLabel == 'Bruit') {
		if (val == 'Yes') {
			document.getElementById('bruitYesDiv').style.display = 'block';
		} else {
			document.getElementById('bruitYesDiv').style.display = 'none';
		}
	} else if (textLabel == 'PRExamination') {
		if (document.getElementById('prExaminationWnl').checked) {
			document.getElementById('rectalExm').style.display = 'block';
		} else {
			document.getElementById('rectalExm').style.display = 'none';
			document.getElementById('gentialExamWnl').checked = false;
			document.getElementById('gentialExamWnlValue').style.display = 'none';
		}
	}else if (textLabel == 'gentialExamWnl') {
		if (document.getElementById('gentialExamWnl').checked) {
			document.getElementById('gentialExamWnlValue').style.display = 'block';
		} else {
			
			document.getElementById('gentialExamWnlValue').style.display = 'none';
		}
	}else if (textLabel == 'Genitalia') {
		if (document.getElementById('externalGenitaliaWnl').checked) {
			document.getElementById('externalGenitalia').style.display = 'block';
		} else {
			document.getElementById('externalGenitalia').style.display = 'none';
		}
	} else if (textLabel == 'TendernessR') {
		if (val == 'Yes') {
			document.getElementById('tendernessRYesDiv').style.display = 'block';
		} else {
			document.getElementById('tendernessRYesDiv').style.display = 'none';
		}
	} else if (textLabel == 'Rhonchi') {
		if (val == 'Yes') {
			document.getElementById('rhonchiYesDiv').style.display = 'block';
		} else {
			document.getElementById('rhonchiYesDiv').style.display = 'none';
		}
	} else if (textLabel == 'Crepitiation') {
		if (val == 'Yes') {
			document.getElementById('crepitaionsYesDiv').style.display = 'block';
		} else {
			document.getElementById('crepitaionsYesDiv').style.display = 'none';
		}
	} else if (textLabel == 'Sounds') {
		if (val.checked == true) {
			document.getElementById('sounds').style.display = 'block';
		} else {
			document.getElementById('sounds').style.display = 'none';
		}
	} else if (textLabel == 'AirEntry') {
		if (val == 'Reduced') {
			document.getElementById('airEntryReducedDiv').style.display = 'block';
		} else {
			document.getElementById('airEntryReducedDiv').style.display = 'none';
		}
	} else if (textLabel == 'GCS') {
		if (val == 'Yes') {
			document.getElementById('GCSDiv').style.display = 'block';
		} else {
			document.getElementById('GCSDiv').style.display = 'none';
			document.getElementById('eyeOpeningResponse').value="";
			document.getElementById('verbalResponse').value="";
			document.getElementById('motorResponse').value="";
			
			
		}
	} else if (textLabel == 'Lymphadenopathy Generalized') {
		if (val == 'Yes') {
			document.getElementById('generalizedLymphadenopathyDiv').style.display = 'block';
		} else {
			document.getElementById('generalizedLymphadenopathyDiv').style.display = 'none';
		}
	}
	else if (textLabel == 'GeneralizedOthers') {
		if (val == 'Others') {
			document.getElementById('othersData').style.display = 'block';
		} else {
			document.getElementById('othersData').style.display = 'none';
			document.getElementById('othersData').value="";
		}
	}
}

function calculateHeadInjuryClassification() {
	var eyeResponse = document.getElementById('eyeOpeningResponse').value;
	var verbalResponse = document.getElementById('verbalResponse').value;
	var motorResponse = document.getElementById('motorResponse').value;
	var score;
	if (eyeResponse != "" && verbalResponse != "" && motorResponse != "") {
		score = parseInt(eyeResponse) + parseInt(verbalResponse)
				+ parseInt(motorResponse)
		if (score > 3 && score < 8) {
			document.getElementById('headInjury').selectedIndex = "1";
		} else if (score <= 8) {
			document.getElementById('headInjury').selectedIndex = "2";
		} else if (score >= 9 && score <= 12) {
			document.getElementById('headInjury').selectedIndex = "3";
		} else if (score >= 13 && score <= 15) {
			document.getElementById('headInjury').selectedIndex = "4";
		}
	}
}

function selectPreviousHistory(val) {
	if (val == 'Present') {
		document.getElementById('leprosyTypeDiv').style.display = 'block';

	} else {
		document.getElementById('leprosyTypeDiv').style.display = 'none';

	}
}

function displayRelapseType(val) {
	if (val == 'Yes') {
		document.getElementById('relapseTypeDiv').style.display = 'block';

	} else {
		document.getElementById('relapseTypeDiv').style.display = 'none';

	}
}
function selectPlantarUlcer(val) {
	if (val == 'Present') {
		document.getElementById('plantarUlcerValueDiv').style.display = 'block';

	} else {
		document.getElementById('plantarUlcerValueDiv').style.display = 'none';

	}
}
function mucousMembraneValue(val) {
	if (val.checked == true) {
		document.getElementById('otherSitesValueDiv').style.display = 'block';

	} else {
		document.getElementById('otherSitesValueDiv').style.display = 'none';

	}
}

function selectGloveAndStockingAnesthesia(val) {
	if (val == 'Present') {
		document.getElementById('gloveAndStockingAnesthesiaValueDiv').style.display = 'block';

	} else {
		document.getElementById('gloveAndStockingAnesthesiaValueDiv').style.display = 'none';

	}
}

function displayLeprosyNeighboursValue(val) {
	if (val == 'Present') {
		document.getElementById('leprosyNeighboursValueDiv').style.display = 'block';

	} else {
		document.getElementById('leprosyNeighboursValueDiv').style.display = 'none';

	}
}

function selectLepraReaction(val) {
	if (val == 'Present') {
		document.getElementById('lepraReactionValueDiv').style.display = 'block';

	} else {
		document.getElementById('lepraReactionValueDiv').style.display = 'none';
		document.getElementById('lepraReactionParameterValueDiv').style.display = 'none';

	}
}



function selectLepraReactionParameter(val) {
	if (val) {
		document.getElementById('lepraReactionParameterValueDiv').style.display = 'block';
		var id = document.getElementById('lepraReactionParameterValue');
		id.value="";

	} else {
		document.getElementById('lepraReactionParameterValueDiv').style.display = 'none';

	}
}

function displayRelationLeprosyDetail(val) {
	if (val == 'Present') {
		document.getElementById('familyHistoryDiv').style.display = 'block';

	} else {
		document.getElementById('familyHistoryDiv').style.display = 'none';

	}
}

// added by swarup 15/11/2017
function displayPsychogeriatricClinic(val) {
	if (val == 'Yes') {
		document.getElementById('physicalHistoryDiv').style.display = 'block';

	} else {
		document.getElementById('physicalHistoryDiv').style.display = 'none';

	}
}

function setValForCheckBox(obj, cnt) {
	if (obj.checked) {
		document.getElementById("parameter" + cnt).value = "y";
	} else {
		document.getElementById("parameter" + cnt).value = "";
	}

}

function displayDrug(val) {
	if (val == 'Yes') {
		document.getElementById('drugDiv').style.display = 'block';

	} else {
		document.getElementById('drugDiv').style.display = 'none';

	}
}
function displayIllness(val) {
	if (val == 'Other') {
		document.getElementById('illnessDiv').style.display = 'block';

	} else {
		document.getElementById('illnessDiv').style.display = 'none';

	}
}
function displayAntenatalSteroids(val) {
	if (val == 'Yes') {
		document.getElementById('antenatalSteroidsDiv').style.display = 'block';

	} else {
		document.getElementById('antenatalSteroidsDiv').style.display = 'none';

	}
}

function displayIndicationForCaesareanApplicable(val) {
	if (val == 'Other') {
		document.getElementById('indicationForCaesareanApplicableDiv').style.display = 'block';

	} else {
		document.getElementById('indicationForCaesareanApplicableDiv').style.display = 'none';

	}
}

function displayDeliveryAttendedBy(val) {
	if (val == 'Other') {
		document.getElementById('deliveryAttendedByDiv').style.display = 'block';

	} else {
		document.getElementById('deliveryAttendedByDiv').style.display = 'none';

	}
}

function displayBleeding(val) {
	if (val == 'Yes') {
		document.getElementById('bleedingDiv').style.display = 'block';

	} else {
		document.getElementById('bleedingDiv').style.display = 'none';

	}
}
function displayCongenitalMalformation(val) {
	if (val == 'Other') {
		document.getElementById('congenitalMalformationAnotherDiv').style.display = 'block';

	} else {
		document.getElementById('congenitalMalformationAnotherDiv').style.display = 'none';

	}
}

function displayJaundice(val) {
	if (val == 'Yes') {
		document.getElementById('jaundiceDiv').style.display = 'block';

	} else {
		document.getElementById('jaundiceDiv').style.display = 'none';

	}
}

function agebw() {

	var oneDay = 24 * 60 * 60 * 1000;
	var firstDate = document.getElementById('bDateId').value;
	var secondDate = document.getElementById('aDateId').value;
	alert("firstDate" + firstDate);
	alert("secondDate" + secondDate);
	var diffDays = Math.round(Math.abs((firstDate.getTime() - secondDate
			.getTime())
			/ (oneDay)));
	alert(diffDays);

}

function checkExpired() {
	var expiredId = document.getElementById('expiredId').value;
	if (expiredId == 'Expired') {
		alert("Invalid Submission,Patient expired!");
		return false;
	} else {
		return true;
	}
}

function openPopupForLabResultsNew(csrf, orderNo) {

	/* submitForm('opdMain','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo); */
	window
			.open(
					"/hms/hms/investigation?method=printResultValidationLab&parent="
							+ orderNo + "&" + csrf + "&" + csrfTokenName + "="
							+ csrfTokenValue,
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
}

// added by amit das on 04-04-2017
function displaFrequencyType(i, incr) {
	var frequencyType = i.options[i.selectedIndex].id;
	document.getElementById('frequencyType' + incr).innerHTML = frequencyType;

}

// added by amit das on 04-04-2017
function displaFrequencyTypeForPrescriptionTab(i, incr) {
	var frequencyType = i.options[i.selectedIndex].id;
	document.getElementById('frequencyTypeForPrescriptionTab' + incr).innerHTML = frequencyType;
}

// added by govind 24-01-2017
function setDisablePharmacy() {
	var count = 0;
	if (document.getElementById('hdb') != null) {
		var tot = document.getElementById('hdb').value

		for (var i = 0; i <= tot; i++) {
			 //alert("i = "+i);
			if (document.getElementById('nomenclature' + i) != null) {
				// alert("test 1")
				var freVal = document.getElementById('nomenclature' + i).value;
				// alert("nomenclature "+freVal);
				if (document.getElementById('nomenclature' + i).value != "") {
					// alert("not equal");
					count = count + 1;
					// document.getElementById("PharmacyqueueId").disabled=
					// true;
				}
			}
		}
	}
//alert(count);
	if (document.getElementById('pTabhdb') != null) {
		var totTab = document.getElementById('pTabhdb').value

		for (var i = 0; i <= totTab; i++) {
			// alert("i = "+i);
			if (document.getElementById('nomenclaturepTab' + i) != null) {
				// alert("test 1")
				var freVal = document.getElementById('nomenclaturepTab' + i).value;
				// alert("nomenclature "+freVal);
				if (document.getElementById('nomenclaturepTab' + i).value != "") {
					// alert("not equal");
					count = count + 1;
					// document.getElementById("PharmacyqueueId").disabled=
					// true;
				}
			}
		}
	}

	// alert("count "+count);
	
		if(document.getElementById("PharmacyqueueId")){
			if (count > 0) {
				document.getElementById("PharmacyqueueId").disabled = true;
				if (document.getElementById("PharmacyqueueId").checked == true) 
					document.getElementById("PharmacyqueueId").checked = false;
				
			} else {
				if(document.getElementById("PharmacyqueueId"))
					document.getElementById("PharmacyqueueId").disabled = false;
			}
		}	

}
// added by govind 24-01-2017 end

function checkFrequencyForTaperedDrugs(inc) {
	var count = document.getElementById('hdb').value;

	for (var i = 0; i < count; i++) {

		if (document.getElementById('nomenclature' + i) != null
				&& document.getElementById('nomenclature' + i).value == document
						.getElementById('nomenclature' + inc).value && i != inc) {
			if (document.getElementById('frequency' + i).value != '0'
					&& document.getElementById('dosage' + i).value != '') {

				if (document.getElementById('frequency' + i).value == document
						.getElementById('frequency' + inc).value
						&& document.getElementById('dosage' + i).value == document
								.getElementById('dosage' + inc).value) {
					alert('This Prescription is already selected with same dosage and frequency.');
					document.getElementById('frequency' + inc).value = "0";
					return false;
				}

			}
		}
	}
	return true;
}

function removeRowDynamic(argIndex, idName) {

	var table = document.getElementById(idName);
	var tblRows = table.getElementsByTagName("tr");
	var check = 0;

	for (i = tblRows.length - 1; i > 0; i--) {
		var tblCtrl = tblRows[i].getElementsByTagName("input");

		for (j = 0; j < tblCtrl.length; j++) {
			if (tblCtrl[j].type == 'checkbox') {
				if (tblCtrl[j].checked)
					check = check + 1;
			}
		}
	}
	if (tblRows.length - 1 == check) {
		alert("Can not delete all rows")
		return false;
	}

	for (i = tblRows.length - 1; i > 0; i--) {
		var tblCtrl = tblRows[i].getElementsByTagName("input");

		for (j = 0; j < tblCtrl.length; j++) {
			if (tblCtrl[j].type == 'checkbox') {
				if (tblCtrl[j].checked)
					document.getElementById(idName).deleteRow(i);
			}
		}
	}
}
function generateRowDynamic(idName) {

	var d = document.getElementById(idName).getElementsByTagName("tr");
	lastTr = d[d.length - 1]

	clone = lastTr.cloneNode(true);

	lastTr.parentNode.insertBefore(clone, lastTr.nextSibling);

	var tblCtrl = d[d.length - 1].getElementsByTagName("input");
	var tblCtrlSel = d[d.length - 1].getElementsByTagName("select");
	var tblCtrlTextarea = d[d.length - 1].getElementsByTagName("textarea");

	var name = '';
	var nameCnt = 0;
	var idCnt = 0;
	var prevIdCnt = 0;

	if (tblCtrl.length > 0) {
		name = tblCtrl[0].name;
	} else if (tblCtrlSel.length) {
		name = tblCtrlSel[0].name;
	} else if (tblCtrlTextarea.length) {
		name = tblCtrlTextarea[0].name;
	}
	//length of charge radio 11-----
	nameCnt = parseInt(name.substring(11) )+ 1;
	console.log(nameCnt)

	for (var i = 0; i < tblCtrl.length; i++) {
		if (tblCtrl[i].type == 'text')
			tblCtrl[i].value = "";
		else if (tblCtrl[i].type == 'checkbox' || tblCtrl[i].type == 'radio')
			tblCtrl[i].checked = false;

		if (i == 0) {

			tblCtrl[i].setAttribute("name", "chargeRadio" + nameCnt);
			tblCtrl[i].setAttribute("id", "chargeRadio" + nameCnt);
		} else {

			if (tblCtrl[i].id != '') {
				prevIdCnt = parseInt(tblCtrl[i].id
						.substring((tblCtrl[i].id.length) - 1));
				idCnt = prevIdCnt + 1;
				if (tblCtrl[i].id == 'multiSelectText' + prevIdCnt) {
					tblCtrl[i].setAttribute("id", "multiSelectText" + idCnt);
				} else if (tblCtrl[i].id == 'radioId' + prevIdCnt) {
					tblCtrl[i].setAttribute("id", "radioId" + idCnt);
				}
			}
			if (tblCtrl[i].type == 'radio') {
				tblCtrl[i].setAttribute("name", "radioPara" + (idCnt));

				tblCtrl[i].setAttribute("onclick", "setValueInText(this.value,"
						+ idCnt + ")");
			}else if (tblCtrl[i].type == 'hidden' && tblCtrl[i].name=='parameterType'+parseInt(name.substring(11) )) {
				tblCtrl[i].setAttribute("name", "parameterType" + nameCnt);

				
			}
			
			else {
				tblCtrl[i].setAttribute("name", "parameter" + nameCnt);
			}
		}
	}
	for (var i = 0; i < tblCtrlSel.length; i++) {
		tblCtrlSel[i].value = "";
		if (!tblCtrlSel[i].multiple)
			tblCtrlSel[i].setAttribute("name", "parameter" + nameCnt);
		else if (tblCtrlSel[i].multiple) {
			tblCtrlSel[i].setAttribute("onblur",
					"displayMultipleSelection(this,'" + idCnt
							+ "','multiSelectText')");
		}
	}
	for (var i = 0; i < tblCtrlTextarea.length; i++) {
		tblCtrlTextarea[i].value = "";
		tblCtrlTextarea[i].setAttribute("name", "parameter" + nameCnt);
	}
}

function addRowMaxillary() {

	var tbl = document.getElementById('gridMaxillary');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbMaxillary');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'maxillaryRadio' + iteration;
	e0.id = 'maxillaryRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'maxClinicalFeature' + iteration;
	e1.id = 'maxClinicalFeature' + iteration;
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Colour', 'Colour');
	e1.options[2] = new Option('Contour', 'Contour');
	e1.options[3] = new Option('Position', 'Position');
	e1.options[4] = new Option('Surface Texture', 'Surface Texture');
	e1.options[5] = new Option('Consistency', 'Consistency');
	e1.options[6] = new Option('Size', 'Size');
	e1.options[7] = new Option('Exudation', 'Exudation');
	e1.options[8] = new Option('Bleeding on Probing', 'Bleeding on Probing');
	e1.options[9] = new Option('Adequacy of Gingiva', 'Adequacy of Gingiva');
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.name = 'maxRightPosterior' + iteration;
	e2.id = 'maxRightPosterior' + iteration;
	e2.maxLength = 128;
	// e2.className = "largTextBoxOpd textYellow";
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'maxAnterior' + iteration;
	e3.id = 'maxAnterior' + iteration;
	e3.maxLength = 128;
	// e2.className = "largTextBoxOpd textYellow";
	cellRight3.appendChild(e3);

	var cellRight4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.name = 'maxLeftPosterior' + iteration;
	e4.id = 'maxLeftPosterior' + iteration;
	e4.maxLength = 128;
	// e2.className = "largTextBoxOpd textYellow";
	cellRight4.appendChild(e4);

}

function removeRowMaxillary() {
	var tbl = document.getElementById('gridMaxillary');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbMaxillary');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("maxillaryRadio" + i) != null
				&& (typeof document.getElementById("maxillaryRadio" + i).checked) != 'undefined'
				&& document.getElementById("maxillaryRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("maxillaryRadio" + i) != null
					&& (typeof document.getElementById("maxillaryRadio" + i).checked) != 'undefined'
					&& document.getElementById("maxillaryRadio" + i).checked) {
				var deleteRow = document.getElementById("maxillaryRadio" + i).parentNode.parentNode;
				document.getElementById("maxillaryRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowMandibular() {

	var tbl = document.getElementById('gridMandibular');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbMandibular');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'mandibularRadio' + iteration;
	e0.id = 'mandibularRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'manClinicalFeature' + iteration;
	e1.id = 'manClinicalFeature' + iteration;
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Colour', 'Colour');
	e1.options[2] = new Option('Contour', 'Contour');
	e1.options[3] = new Option('Position', 'Position');
	e1.options[4] = new Option('Surface Texture', 'Surface Texture');
	e1.options[5] = new Option('Consistency', 'Consistency');
	e1.options[6] = new Option('Size', 'Size');
	e1.options[7] = new Option('Exudation', 'Exudation');
	e1.options[8] = new Option('Bleeding on Probing', 'Bleeding on Probing');
	e1.options[9] = new Option('Adequacy of Gingiva', 'Adequacy of Gingiva');
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.name = 'manRightPosterior' + iteration;
	e2.id = 'manRightPosterior' + iteration;
	e2.maxLength = 128;
	// e2.className = "largTextBoxOpd textYellow";
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'manAnterior' + iteration;
	e3.id = 'manAnterior' + iteration;
	e3.maxLength = 128;
	// e2.className = "largTextBoxOpd textYellow";
	cellRight3.appendChild(e3);

	var cellRight4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.name = 'manLeftPosterior' + iteration;
	e4.id = 'manLeftPosterior' + iteration;
	e4.maxLength = 128;
	// e2.className = "largTextBoxOpd textYellow";
	cellRight4.appendChild(e4);

}

function removeRowMandibular() {
	var tbl = document.getElementById('gridMandibular');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbMandibular');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("mandibularRadio" + i) != null
				&& (typeof document.getElementById("mandibularRadio" + i).checked) != 'undefined'
				&& document.getElementById("mandibularRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("mandibularRadio" + i) != null
					&& (typeof document.getElementById("mandibularRadio" + i).checked) != 'undefined'
					&& document.getElementById("mandibularRadio" + i).checked) {
				var deleteRow = document.getElementById("mandibularRadio" + i).parentNode.parentNode;
				document.getElementById("mandibularRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowInspection() {

	var tbl = document.getElementById('gridInspection');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbInspection');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'inspectionRadio' + iteration;
	e0.id = 'inspectionRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.name = 'site' + iteration;
	e1.id = 'site' + iteration;
	e1.maxLength = 50;
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.name = 'numberInspection' + iteration;
	e2.id = 'numberInspection' + iteration;
	e2.maxLength = 50;
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'size' + iteration;
	e3.id = 'size' + iteration;
	e3.maxLength = 50;
	cellRight3.appendChild(e3);

	var cellRight4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.name = 'shape' + iteration;
	e4.id = 'shape' + iteration;
	e4.maxLength = 50;
	cellRight4.appendChild(e4);

	var cellRight5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.name = 'colour' + iteration;
	e5.id = 'colour' + iteration;
	e5.maxLength = 50;
	cellRight5.appendChild(e5);

	var cellRight6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.name = 'discharge' + iteration;
	e6.id = 'discharge' + iteration;
	e6.maxLength = 50;
	cellRight6.appendChild(e6);

	var cellRight7 = row.insertCell(7);
	var e7 = document.createElement('Select');
	e7.name = 'surface' + iteration;
	e7.id = 'surface' + iteration;
	e7.options[0] = new Option('Select', '');
	e7.options[1] = new Option('Smooth', 'Smooth');
	e7.options[2] = new Option('Nodular', 'Nodular');
	e7.options[3] = new Option('Lobular', 'Lobular');
	e7.options[4] = new Option('Rough', 'Rough');
	e7.options[5] = new Option('Irregular', 'Irregular');
	e7.maxLength = 50;
	cellRight7.appendChild(e7);

	var cellRight8 = row.insertCell(8);
	var e8 = document.createElement('Select');
	e8.name = 'skinOverTheSwelling' + iteration;
	e8.id = 'skinOverTheSwelling' + iteration;
	e8.options[0] = new Option('Select', '');
	e8.options[1] = new Option('Smooth', 'Smooth');
	e8.options[2] = new Option('Engorged Vessels', 'Engorged Vessels');
	e8.options[3] = new Option('Pigmentation', 'Pigmentation');
	e8.options[4] = new Option('Scar', 'Scar');
	e8.maxLength = 50;
	cellRight8.appendChild(e8);

}

function removeRowInspection() {
	var tbl = document.getElementById('gridInspection');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbInspection');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("inspectionRadio" + i) != null
				&& (typeof document.getElementById("inspectionRadio" + i).checked) != 'undefined'
				&& document.getElementById("inspectionRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("inspectionRadio" + i) != null
					&& (typeof document.getElementById("inspectionRadio" + i).checked) != 'undefined'
					&& document.getElementById("inspectionRadio" + i).checked) {
				var deleteRow = document.getElementById("inspectionRadio" + i).parentNode.parentNode;
				document.getElementById("inspectionRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowSoftTissueInjury() {

	var tbl = document.getElementById('gridSoftTissueInjury');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbSoftTissueInjury');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'softTissueInjuryRadio' + iteration;
	e0.id = 'softTissueInjuryRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'site' + iteration;
	e1.id = 'site' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Face', 'Face');
	e1.options[2] = new Option('Frontal', 'Frontal');
	e1.options[3] = new Option('Supraorbital', 'Supraorbital');
	e1.options[4] = new Option('Nasal', 'Nasal');
	e1.options[5] = new Option('Circumorbital', 'Circumorbital');
	e1.options[6] = new Option('Zygomatic', 'Zygomatic');
	e1.options[7] = new Option('Buccal', 'Buccal');
	e1.options[8] = new Option('Lips', 'Lips');
	e1.options[9] = new Option('Mandible', 'Mandible');
	e1.options[10] = new Option('Submandibular', 'Submandibular');
	e1.options[11] = new Option('Neck', 'Neck');
	e1.options[12] = new Option('Eyelids', 'Eyelids');
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('Select');
	e2.name = 'typeOfInjury' + iteration;
	e2.id = 'typeOfInjury' + iteration;
	e2.options[0] = new Option('Select', '');
	e2.options[1] = new Option('Edema', 'Edema');
	e2.options[2] = new Option('Abrasion Size', 'Abrasion Size');
	e2.options[3] = new Option('Laceration Size', 'Laceration Size');
	e2.options[4] = new Option('Macerated wounds', 'Macerated wounds');
	e2.options[5] = new Option('Loss of tissue wounds', 'Loss of tissue wounds');
	e2.options[6] = new Option('Echymosis', 'Echymosis');
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'checkbox';
	e3.name = 'leftSoftTissue' + iteration;
	e3.id = 'leftSoftTissue' + iteration;
	cellRight3.appendChild(e3);

	var cellRight4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'checkbox';
	e4.name = 'rightSoftTissue' + iteration;
	e4.id = 'rightSoftTissue' + iteration;
	// e2.className = "largTextBoxOpd textYellow";
	cellRight4.appendChild(e4);

	var cellRight5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.name = 'size' + iteration;
	e5.id = 'size' + iteration;
	e5.maxLength = 50;
	cellRight5.appendChild(e5);

	var cellRight6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.name = 'commentsSoftTissue' + iteration;
	e6.id = 'commentsSoftTissue' + iteration;
	e6.maxLength = 50;
	cellRight6.appendChild(e6);

}

function removeRowSoftTissueInjury() {
	var tbl = document.getElementById('gridSoftTissueInjury');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbSoftTissueInjury');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("softTissueInjuryRadio" + i) != null
				&& (typeof document.getElementById("softTissueInjuryRadio" + i).checked) != 'undefined'
				&& document.getElementById("softTissueInjuryRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("softTissueInjuryRadio" + i) != null
					&& (typeof document.getElementById("softTissueInjuryRadio"
							+ i).checked) != 'undefined'
					&& document.getElementById("softTissueInjuryRadio" + i).checked) {
				var deleteRow = document.getElementById("softTissueInjuryRadio"
						+ i).parentNode.parentNode;
				document.getElementById("softTissueInjuryRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function displayTextValueDiv() {

	if (document.getElementById("edema").checked)
		document.getElementById("edemaDiv").style.display = 'inline';
	else
		document.getElementById("edemaDiv").style.display = 'none';

	if (document.getElementById("chestPain").checked)
		document.getElementById("chestPainDiv").style.display = 'inline';
	else
		document.getElementById("chestPainDiv").style.display = 'none';

	if (document.getElementById("palpitation").checked)
		document.getElementById("palpitationDiv").style.display = 'inline';
	else
		document.getElementById("palpitationDiv").style.display = 'none';

	if (document.getElementById("palpitation").checked)
		document.getElementById("palpitationDiv").style.display = 'inline';
	else
		document.getElementById("palpitationDiv").style.display = 'none';

	if (document.getElementById("hypertension").checked)
		document.getElementById("hypertensionDiv").style.display = 'inline';
	else
		document.getElementById("hypertensionDiv").style.display = 'none';

	if (document.getElementById("murmers").checked)
		document.getElementById("murmersDiv").style.display = 'inline';
	else
		document.getElementById("murmersDiv").style.display = 'none';

	if (document.getElementById("cough").checked) {
		document.getElementById("coughDiv").style.display = 'inline';
	} else {
		document.getElementById("coughDiv").style.display = 'none';
	}

	if (document.getElementById("wheezing").checked)
		document.getElementById("wheezingDiv").style.display = 'inline';
	else
		document.getElementById("wheezingDiv").style.display = 'none';

	if (document.getElementById("dyspnoea").checked)
		document.getElementById("dyspnoeaDiv").style.display = 'inline';
	else
		document.getElementById("dyspnoeaDiv").style.display = 'none';

	if (document.getElementById("nasalBlock").checked)
		document.getElementById("nasalBlockDiv").style.display = 'inline';
	else
		document.getElementById("nasalBlockDiv").style.display = 'none';

	if (document.getElementById("dizziness").checked)
		document.getElementById("dizzinessDiv").style.display = 'inline';
	else
		document.getElementById("dizzinessDiv").style.display = 'none';

	if (document.getElementById("tremors").checked)
		document.getElementById("tremorsDiv").style.display = 'inline';
	else
		document.getElementById("tremorsDiv").style.display = 'none';

	if (document.getElementById("headache").checked)
		document.getElementById("headacheDiv").style.display = 'inline';
	else
		document.getElementById("headacheDiv").style.display = 'none';

	if (document.getElementById("vommitting").checked)
		document.getElementById("vommittingDiv").style.display = 'inline';
	else
		document.getElementById("vommittingDiv").style.display = 'none';

	if (document.getElementById("parathesisa").checked)
		document.getElementById("parathesisaDiv").style.display = 'inline';
	else
		document.getElementById("parathesisaDiv").style.display = 'none';

	if (document.getElementById("convulsion").checked)
		document.getElementById("convulsionDiv").style.display = 'inline';
	else
		document.getElementById("convulsionDiv").style.display = 'none';

	if (document.getElementById("polyuria").checked)
		document.getElementById("polyuriaDiv").style.display = 'inline';
	else
		document.getElementById("polyuriaDiv").style.display = 'none';

	if (document.getElementById("oligouria").checked)
		document.getElementById("oligouriaDiv").style.display = 'inline';
	else
		document.getElementById("oligouriaDiv").style.display = 'none';

	if (document.getElementById("heamatuia").checked)
		document.getElementById("heamatuiaDiv").style.display = 'inline';
	else
		document.getElementById("heamatuiaDiv").style.display = 'none';

	if (document.getElementById("buccal").checked)
		document.getElementById("buccalDiv").style.display = 'inline';
	else
		document.getElementById("buccalDiv").style.display = 'none';

	if (document.getElementById("canine").checked)
		document.getElementById("canineDiv").style.display = 'inline';
	else
		document.getElementById("canineDiv").style.display = 'none';

	if (document.getElementById("pericoronal").checked)
		document.getElementById("pericoronalDiv").style.display = 'inline';
	else
		document.getElementById("pericoronalDiv").style.display = 'none';

	if (document.getElementById("masseteric").checked)
		document.getElementById("massetericDiv").style.display = 'inline';
	else
		document.getElementById("massetericDiv").style.display = 'none';

	if (document.getElementById("submandiblar").checked)
		document.getElementById("submandiblarDiv").style.display = 'inline';
	else
		document.getElementById("submandiblarDiv").style.display = 'none';

	if (document.getElementById("sublingual").checked)
		document.getElementById("sublingualDiv").style.display = 'inline';
	else
		document.getElementById("sublingualDiv").style.display = 'none';

	if (document.getElementById("submetal").checked)
		document.getElementById("submetalDiv").style.display = 'inline';
	else
		document.getElementById("submetalDiv").style.display = 'none';

	if (document.getElementById("retromolar").checked)
		document.getElementById("retromolarDiv").style.display = 'inline';
	else
		document.getElementById("retromolarDiv").style.display = 'none';

	if (document.getElementById("pterygomandibular").checked)
		document.getElementById("pterygomandibularDiv").style.display = 'inline';
	else
		document.getElementById("pterygomandibularDiv").style.display = 'none';

	if (document.getElementById("lateralPharyngeal").checked)
		document.getElementById("lateralPharyngealDiv").style.display = 'inline';
	else
		document.getElementById("lateralPharyngealDiv").style.display = 'none';

	if (document.getElementById("retroopharyngeal").checked)
		document.getElementById("retroopharyngealDiv").style.display = 'inline';
	else
		document.getElementById("retroopharyngealDiv").style.display = 'none';

	if (document.getElementById("mediastemitis").checked)
		document.getElementById("mediastemitisDiv").style.display = 'inline';
	else
		document.getElementById("mediastemitisDiv").style.display = 'none';

	if (document.getElementById("maxillaryDentoAlveolarFracture").checked)
		document.getElementById("maxillaryDentoAlveolarFractureDiv").style.display = 'inline';
	else
		document.getElementById("maxillaryDentoAlveolarFractureDiv").style.display = 'none';

	if (document.getElementById("lefort1Fracture").checked)
		document.getElementById("lefort1FractureDiv").style.display = 'inline';
	else
		document.getElementById("lefort1FractureDiv").style.display = 'none';

	if (document.getElementById("lefort2Fracture").checked)
		document.getElementById("lefort2FractureDiv").style.display = 'inline';
	else
		document.getElementById("lefort2FractureDiv").style.display = 'none';

	if (document.getElementById("lefort3Fracture").checked)
		document.getElementById("lefort3FractureDiv").style.display = 'inline';
	else
		document.getElementById("lefort3FractureDiv").style.display = 'none';

	if (document.getElementById("nasalBoneFracture").checked)
		document.getElementById("nasalBoneFractureDiv").style.display = 'inline';
	else
		document.getElementById("nasalBoneFractureDiv").style.display = 'none';

	if (document.getElementById("zygomaticArchFracture").checked)
		document.getElementById("zygomaticArchFractureDiv").style.display = 'inline';
	else
		document.getElementById("zygomaticArchFractureDiv").style.display = 'none';

	if (document.getElementById("zygomaticComplex").checked)
		document.getElementById("zygomaticComplexDiv").style.display = 'inline';
	else
		document.getElementById("zygomaticComplexDiv").style.display = 'none';

	if (document.getElementById("orbitalFracture").checked)
		document.getElementById("orbitalFractureDiv").style.display = 'inline';
	else
		document.getElementById("orbitalFractureDiv").style.display = 'none';

	if (document.getElementById("frontalBoneFracture").checked)
		document.getElementById("frontalBoneFractureDiv").style.display = 'inline';
	else
		document.getElementById("frontalBoneFractureDiv").style.display = 'none';

	if (document.getElementById("dentoalveolar").checked)
		document.getElementById("dentoalveolarDiv").style.display = 'inline';
	else
		document.getElementById("dentoalveolarDiv").style.display = 'none';

	if (document.getElementById("symphysis").checked)
		document.getElementById("symphysisDiv").style.display = 'inline';
	else
		document.getElementById("symphysisDiv").style.display = 'none';

	if (document.getElementById("ramus").checked)
		document.getElementById("ramusDiv").style.display = 'inline';
	else
		document.getElementById("ramusDiv").style.display = 'none';

	if (document.getElementById("angle").checked)
		document.getElementById("angleDiv").style.display = 'inline';
	else
		document.getElementById("angleDiv").style.display = 'none';

	if (document.getElementById("body").checked)
		document.getElementById("bodyDiv").style.display = 'inline';
	else
		document.getElementById("bodyDiv").style.display = 'none';

	if (document.getElementById("condyle").checked)
		document.getElementById("condyleDiv").style.display = 'inline';
	else
		document.getElementById("condyleDiv").style.display = 'none';

	if (document.getElementById("coronoid").checked)
		document.getElementById("coronoidDiv").style.display = 'inline';
	else
		document.getElementById("coronoidDiv").style.display = 'none';

	if (document.getElementById("subcondylar").checked)
		document.getElementById("subcondylarDiv").style.display = 'inline';
	else
		document.getElementById("subcondylarDiv").style.display = 'none';

	if (document.getElementById("maxilla").checked)
		document.getElementById("maxillaDiv").style.display = 'inline';
	else
		document.getElementById("maxillaDiv").style.display = 'none';

	if (document.getElementById("mandible").checked)
		document.getElementById("mandibleDiv").style.display = 'inline';
	else
		document.getElementById("mandibleDiv").style.display = 'none';

	if (document.getElementById("buccalMucosa1").checked)
		document.getElementById("buccalMucosaDiv").style.display = 'inline';
	else
		document.getElementById("buccalMucosaDiv").style.display = 'none';

	if (document.getElementById("tongue1").checked)
		document.getElementById("tongueDiv").style.display = 'inline';
	else
		document.getElementById("tongueDiv").style.display = 'none';

	if (document.getElementById("retromolarMucosa").checked)
		document.getElementById("retromolarMucosaDiv").style.display = 'inline';
	else
		document.getElementById("retromolarMucosaDiv").style.display = 'none';

	if (document.getElementById("floorOfMouth1").checked)
		document.getElementById("floorOfMouthDiv").style.display = 'inline';
	else
		document.getElementById("floorOfMouthDiv").style.display = 'none';

	if (document.getElementById("alveolus").checked)
		document.getElementById("alveolusDiv").style.display = 'inline';
	else
		document.getElementById("alveolusDiv").style.display = 'none';

	if (document.getElementById("ewigsSarcoma").checked)
		document.getElementById("ewigsSarcomaDiv").style.display = 'inline';
	else
		document.getElementById("ewigsSarcomaDiv").style.display = 'none';

	if (document.getElementById("lips").checked)
		document.getElementById("lipsDiv").style.display = 'inline';
	else
		document.getElementById("lipsDiv").style.display = 'none';

	if (document.getElementById("preCancerousLesions").checked)
		document.getElementById("preCancerousLesionsDiv").style.display = 'inline';
	else
		document.getElementById("preCancerousLesionsDiv").style.display = 'none';

	if (document.getElementById("preCancerousConditions").checked)
		document.getElementById("preCancerousConditionsDiv").style.display = 'inline';
	else
		document.getElementById("preCancerousConditionsDiv").style.display = 'none';

	if (document.getElementById("others").checked)
		document.getElementById("othersDiv").style.display = 'inline';
	else
		document.getElementById("othersDiv").style.display = 'none';

	if (document.getElementById("fibrousDysplasia").checked)
		document.getElementById("fibrousDysplasiaDiv").style.display = 'inline';
	else
		document.getElementById("fibrousDysplasiaDiv").style.display = 'none';

	if (document.getElementById("lymphangioma").checked)
		document.getElementById("lymphangiomaDiv").style.display = 'inline';
	else
		document.getElementById("lymphangiomaDiv").style.display = 'none';

	if (document.getElementById("lymphangioma").checked)
		document.getElementById("lymphangiomaDiv").style.display = 'inline';
	else
		document.getElementById("lymphangiomaDiv").style.display = 'none';

	if (document.getElementById("hemangioma").checked)
		document.getElementById("hemangiomaDiv").style.display = 'inline';
	else
		document.getElementById("hemangiomaDiv").style.display = 'none';

	if (document.getElementById("centralGiant").checked)
		document.getElementById("centralGiantDiv").style.display = 'inline';
	else
		document.getElementById("centralGiantDiv").style.display = 'none';

	if (document.getElementById("peripheralGiant").checked)
		document.getElementById("peripheralGiantDiv").style.display = 'inline';
	else
		document.getElementById("peripheralGiantDiv").style.display = 'none';

	if (document.getElementById("anteriovenousMalfromation").checked)
		document.getElementById("anteriovenousMalfromationDiv").style.display = 'inline';
	else
		document.getElementById("anteriovenousMalfromationDiv").style.display = 'none';

	if (document.getElementById("excision").checked)
		document.getElementById("excisionDiv").style.display = 'inline';
	else
		document.getElementById("excisionDiv").style.display = 'none';

	if (document.getElementById("resection").checked)
		document.getElementById("resectionDiv").style.display = 'inline';
	else
		document.getElementById("resectionDiv").style.display = 'none';

	if (document.getElementById("others1").checked)
		document.getElementById("others1Div").style.display = 'inline';
	else
		document.getElementById("others1Div").style.display = 'none';

	if (document.getElementById("dentigerousCysts").checked)
		document.getElementById("dentigerousCystsDiv").style.display = 'inline';
	else
		document.getElementById("dentigerousCystsDiv").style.display = 'none';

	if (document.getElementById("okc").checked)
		document.getElementById("okcDiv").style.display = 'inline';
	else
		document.getElementById("okcDiv").style.display = 'none';

	if (document.getElementById("periapicalCysts").checked)
		document.getElementById("periapicalCystsDiv").style.display = 'inline';
	else
		document.getElementById("periapicalCystsDiv").style.display = 'none';

	if (document.getElementById("dermoidCyst").checked)
		document.getElementById("dermoidCystDiv").style.display = 'inline';
	else
		document.getElementById("dermoidCystDiv").style.display = 'none';

	if (document.getElementById("sebeceousCyst").checked)
		document.getElementById("sebeceousCystDiv").style.display = 'inline';
	else
		document.getElementById("sebeceousCystDiv").style.display = 'none';

	if (document.getElementById("marsupialization").checked)
		document.getElementById("marsupializationDiv").style.display = 'inline';
	else
		document.getElementById("marsupializationDiv").style.display = 'none';

	if (document.getElementById("enucleation").checked)
		document.getElementById("enucleationDiv").style.display = 'inline';
	else
		document.getElementById("enucleationDiv").style.display = 'none';

	if (document.getElementById("others3").checked)
		document.getElementById("others3Div").style.display = 'inline';
	else
		document.getElementById("others3Div").style.display = 'none';

	if (document.getElementById("inflammatory").checked)
		document.getElementById("inflammatoryDiv").style.display = 'inline';
	else
		document.getElementById("inflammatoryDiv").style.display = 'none';

	if (document.getElementById("obstructive").checked)
		document.getElementById("obstructiveDiv").style.display = 'inline';
	else
		document.getElementById("obstructiveDiv").style.display = 'none';

	if (document.getElementById("mucocele").checked)
		document.getElementById("mucoceleDiv").style.display = 'inline';
	else
		document.getElementById("mucoceleDiv").style.display = 'none';

	if (document.getElementById("ranula").checked)
		document.getElementById("ranulaDiv").style.display = 'inline';
	else
		document.getElementById("ranulaDiv").style.display = 'none';

	if (document.getElementById("inflammation").checked)
		document.getElementById("inflammationDiv").style.display = 'inline';
	else
		document.getElementById("inflammationDiv").style.display = 'none';

	if (document.getElementById("ankylosisBony").checked)
		document.getElementById("ankylosisBonyDiv").style.display = 'inline';
	else
		document.getElementById("ankylosisBonyDiv").style.display = 'none';

	if (document.getElementById("ankylosisFibrous").checked)
		document.getElementById("ankylosisFibrousDiv").style.display = 'inline';
	else
		document.getElementById("ankylosisFibrousDiv").style.display = 'none';

	if (document.getElementById("dislocationAcute").checked)
		document.getElementById("dislocationAcuteDiv").style.display = 'inline';
	else
		document.getElementById("dislocationAcuteDiv").style.display = 'none';

	if (document.getElementById("dislocationChronic").checked)
		document.getElementById("dislocationChronicDiv").style.display = 'inline';
	else
		document.getElementById("dislocationChronicDiv").style.display = 'none';

	if (document.getElementById("dislocationSubluxation").checked)
		document.getElementById("dislocationSubluxationDiv").style.display = 'inline';
	else
		document.getElementById("dislocationSubluxationDiv").style.display = 'none';

	if (document.getElementById("openBite").checked)
		document.getElementById("openBiteDiv").style.display = 'inline';
	else
		document.getElementById("openBiteDiv").style.display = 'none';

	if (document.getElementById("asymmetry").checked)
		document.getElementById("asymmetryDiv").style.display = 'inline';
	else
		document.getElementById("asymmetryDiv").style.display = 'none';

	if (document.getElementById("anteriorMaxillaryOsteotomy").checked)
		document.getElementById("anteriorMaxillaryOsteotomyDiv").style.display = 'inline';
	else
		document.getElementById("anteriorMaxillaryOsteotomyDiv").style.display = 'none';

	if (document.getElementById("leforte1Osteotomy").checked)
		document.getElementById("leforte1OsteotomyDiv").style.display = 'inline';
	else
		document.getElementById("leforte1OsteotomyDiv").style.display = 'none';

	if (document.getElementById("bsso").checked)
		document.getElementById("bssoDiv").style.display = 'inline';
	else
		document.getElementById("bssoDiv").style.display = 'none';

	if (document.getElementById("ivro").checked)
		document.getElementById("ivroDiv").style.display = 'inline';
	else
		document.getElementById("ivroDiv").style.display = 'none';

	if (document.getElementById("subapical").checked)
		document.getElementById("subapicalDiv").style.display = 'inline';
	else
		document.getElementById("subapicalDiv").style.display = 'none';

	if (document.getElementById("condyletomy").checked)
		document.getElementById("condyletomyDiv").style.display = 'inline';
	else
		document.getElementById("condyletomyDiv").style.display = 'none';

	if (document.getElementById("genioplasty").checked)
		document.getElementById("genioplastyDiv").style.display = 'inline';
	else
		document.getElementById("genioplastyDiv").style.display = 'none';

	if (document.getElementById("distractionOsteogenesis").checked)
		document.getElementById("distractionOsteogenesisDiv").style.display = 'inline';
	else
		document.getElementById("distractionOsteogenesisDiv").style.display = 'none';

	if (document.getElementById("trgeminalNeuralgia").checked)
		document.getElementById("trgeminalNeuralgiaDiv").style.display = 'inline';
	else
		document.getElementById("trgeminalNeuralgiaDiv").style.display = 'none';

	if (document.getElementById("facialParalysis").checked)
		document.getElementById("facialParalysisDiv").style.display = 'inline';
	else
		document.getElementById("facialParalysisDiv").style.display = 'none';

	if (document.getElementById("others4").checked)
		document.getElementById("others4Div").style.display = 'inline';
	else
		document.getElementById("others4Div").style.display = 'none';

	if (document.getElementById("medical").checked)
		document.getElementById("medicalDiv").style.display = 'inline';
	else
		document.getElementById("medicalDiv").style.display = 'none';

	if (document.getElementById("surgical").checked)
		document.getElementById("surgicalDiv").style.display = 'inline';
	else
		document.getElementById("surgicalDiv").style.display = 'none';

	if (document.getElementById("cleftLip").checked)
		document.getElementById("cleftLipDiv").style.display = 'inline';
	else
		document.getElementById("cleftLipDiv").style.display = 'none';

	if (document.getElementById("cleftPalate").checked)
		document.getElementById("cleftPalateDiv").style.display = 'inline';
	else
		document.getElementById("cleftPalateDiv").style.display = 'none';

	if (document.getElementById("others5").checked)
		document.getElementById("others5Div").style.display = 'inline';
	else
		document.getElementById("others5Div").style.display = 'none';

	if (document.getElementById("others3Value").checked)
		document.getElementById("others3ValueDiv").style.display = 'inline';
	else
		document.getElementById("others3ValueDiv").style.display = 'none';

}

function displayTextValueDivImplantPlanning() {

	if (document.getElementById("historyOfAllergyImplantPlanning").checked)
		document.getElementById("historyOfAllergyImplantPlanningDiv").style.display = 'inline';
	else
		document.getElementById("historyOfAllergyImplantPlanningDiv").style.display = 'none';
	document.getElementById("historyOfAllergyImplantPlanningValue").value = "";

}

function displayTextValueRPP() {
	if (document.getElementById("historyOfAllergy").checked)
		document.getElementById("historyOfAllergyDiv").style.display = 'inline';
	else
		document.getElementById("historyOfAllergyDiv").style.display = 'none';
	document.getElementById("historyOfAllergyValue").value = "";

	if (document.getElementById("clicking").checked)
		document.getElementById("clickingDiv").style.display = 'inline';
	else
		document.getElementById("clickingDiv").style.display = 'none';
	document.getElementById("clickingValue").value = "";

	if (document.getElementById("pain").checked)
		document.getElementById("painDiv").style.display = 'inline';
	else
		document.getElementById("painDiv").style.display = 'none';
	document.getElementById("painValue").value = "";

	if (document.getElementById("deviation").checked)
		document.getElementById("deviationDiv").style.display = 'inline';
	else
		document.getElementById("deviationDiv").style.display = 'none';
	document.getElementById("deviationValue").value = "";
}

function displayTextValueFP() {
	if (document.getElementById("historyOfAllergy").checked)
		document.getElementById("historyOfAllergyDiv").style.display = 'inline';
	else
		document.getElementById("historyOfAllergyDiv").style.display = 'none';
	document.getElementById("historyOfAllergyValue").value = "";

	if (document.getElementById("clicking").checked)
		document.getElementById("clickingDiv").style.display = 'inline';
	else
		document.getElementById("clickingDiv").style.display = 'none';
	document.getElementById("clickingValue").value = "";

	if (document.getElementById("pain").checked)
		document.getElementById("painDiv").style.display = 'inline';
	else
		document.getElementById("painDiv").style.display = 'none';
	document.getElementById("painValue").value = "";

	if (document.getElementById("deviation").checked)
		document.getElementById("deviationDiv").style.display = 'inline';
	else
		document.getElementById("deviationDiv").style.display = 'none';
	document.getElementById("deviationValue").value = "";

	if (document.getElementById("residualRoots").checked)
		document.getElementById("residualRootsDiv").style.display = 'inline';
	else
		document.getElementById("residualRootsDiv").style.display = 'none';
	document.getElementById("residualRootsValue").value = "";

	if (document.getElementById("periapicalStatusD").checked)
		document.getElementById("periapicalStatusDiv").style.display = 'inline';
	else
		document.getElementById("periapicalStatusDiv").style.display = 'none';
	document.getElementById("periapicalStatusValue").value = "";

	if (document.getElementById("rootResorption").checked)
		document.getElementById("rootResorptionDiv").style.display = 'inline';
	else
		document.getElementById("rootResorptionDiv").style.display = 'none';
	document.getElementById("rootResorptionValue").value = "";

	if (document.getElementById("crownRootRatio").checked)
		document.getElementById("crownRootRatioDiv").style.display = 'inline';
	else
		document.getElementById("crownRootRatioDiv").style.display = 'none';
	document.getElementById("crownRootRatioValue").value = "";

	if (document.getElementById("continuityOfLaminaDura").checked)
		document.getElementById("continuityOfLaminaDuraDiv").style.display = 'inline';
	else
		document.getElementById("continuityOfLaminaDuraDiv").style.display = 'none';
	document.getElementById("continuityOfLaminaDuraValue").value = "";

	if (document.getElementById("verticalHorizontal").checked)
		document.getElementById("verticalHorizontalDiv").style.display = 'inline';
	else
		document.getElementById("verticalHorizontalDiv").style.display = 'none';
	document.getElementById("verticalHorizontaValue").value = "";
}

function addRowForTreatmentPlan() {

	var tbl = document.getElementById('gridTreatmentPlan');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbTreatmentPlan');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'treatmentPlanRadio' + iteration;
	e0.id = 'treatmentPlan' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'toothTreatmentPlan' + iteration;
	e1.id = 'toothTreatmentPlan' + iteration;
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('18', '18');
	e1.options[2] = new Option('17', '17');
	e1.options[3] = new Option('16', '16');
	e1.options[4] = new Option('15', '15');
	e1.options[5] = new Option('14', '14');
	e1.options[6] = new Option('13', '13');
	e1.options[7] = new Option('12', '12');
	e1.options[8] = new Option('11', '11');
	e1.options[9] = new Option('21', '21');
	e1.options[10] = new Option('22', '22');
	e1.options[11] = new Option('23', '23');
	e1.options[12] = new Option('24', '24');
	e1.options[13] = new Option('25', '25');
	e1.options[14] = new Option('26', '26');
	e1.options[15] = new Option('27', '27');
	e1.options[16] = new Option('28', '28');
	e1.options[17] = new Option('48', '48');
	e1.options[18] = new Option('47', '47');
	e1.options[19] = new Option('47', '46');
	e1.options[20] = new Option('45', '45');
	e1.options[21] = new Option('44', '44');
	e1.options[22] = new Option('43', '43');
	e1.options[23] = new Option('42', '42');
	e1.options[24] = new Option('41', '41');
	e1.options[25] = new Option('31', '31');
	e1.options[26] = new Option('32', '32');
	e1.options[27] = new Option('33', '33');
	e1.options[28] = new Option('34', '34');
	e1.options[29] = new Option('35', '35');
	e1.options[30] = new Option('36', '36');
	e1.options[31] = new Option('37', '37');
	e1.options[32] = new Option('38', '38');
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('Select');
	e2.name = 'treatmentTreatmentPlan' + iteration;
	e2.id = 'treatmentTreatmentPlan' + iteration;
	e2.options[0] = new Option('Select', '');
	e2.options[1] = new Option('Amalgam', 'Amalgam');
	e2.options[2] = new Option('Composite', 'Composite');
	e2.options[3] = new Option('GIC', 'GIC');
	e2.options[4] = new Option('IRM', 'IRM');
	e2.options[5] = new Option('Temporary filling', 'Temporary filling');
	e2.options[6] = new Option('Inlay / Onlay', 'Inlay / Onlay');
	e2.options[7] = new Option('Exudation', 'Exudation');
	e2.options[8] = new Option('Veneers', 'Veneers');
	e2.options[9] = new Option('Jacket crown fabrication',
			'Jacket crown fabrication');
	e2.options[10] = new Option('RCT', 'RCT');
	e2.options[11] = new Option('Re-RCT', 'Re-RCT');
	e2.options[12] = new Option('Perforation / Resorption repair',
			'Perforation / Resorption repair');
	e2.options[13] = new Option('Fibre Post and Core build up',
			'Fibre Post and Core build up');
	e2.options[14] = new Option('Cast post fabrication',
			'Cast post fabrication');
	e2.options[15] = new Option('Direct pulp capping', 'Direct pulp capping');
	e2.options[16] = new Option('Indirect pulp capping',
			'Indirect pulp capping');
	e2.options[17] = new Option('Pulpotomy', 'Pulpotomy');
	e2.options[18] = new Option('Apexogenesis / Apexification',
			'Apexogenesis / Apexification');
	e2.options[19] = new Option('Regenerative therapy', 'Regenerative therapy');
	e2.options[20] = new Option('Vital bleaching', 'Vital bleaching');
	e2.options[21] = new Option('Non - Vital Bleaching',
			'Non - Vital Bleaching');
	e2.options[22] = new Option('desensitizing agent', 'desensitizing agent');
	e2.options[23] = new Option('selective Grinding', 'selective Grinding');
	e2.options[24] = new Option('Apicoectomy', 'Apicoectomy');
	e2.options[25] = new Option('Peripical surgery', 'Peripical surgery');
	e2.options[26] = new Option('I and D', 'I and D');
	e2.options[27] = new Option('Orthodontic / Surgical Extrusion',
			'Orthodontic / Surgical Extrusion');
	e2.options[28] = new Option('Gingivectomy', 'Gingivectomy');
	e2.options[29] = new Option('Spliniting', 'Spliniting');
	e2.options[30] = new Option('Interdisciplinary approach',
			'Interdisciplinary approach');
	e2.options[31] = new Option('No active intervention needed',
			'No active intervention needed');
	e2.options[32] = new Option('Extraction', 'Extraction');
	e2.options[33] = new Option('Patient not willing for treatment',
			'Patient not willing for treatment');
	e2.options[34] = new Option('Others', 'Others');
	e2.style.width = '200px';
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'remarksTreatmentPlan' + iteration;
	e3.id = 'remarksTreatmentPlan' + iteration;
	e3.maxLength = "128";
	e3.className='largTextBoxOpd popper'; 
	cellRight3.appendChild(e3);

}

function removeRowForTreatmentPlan() {
	var tbl = document.getElementById('gridTreatmentPlan');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbTreatmentPlan');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("treatmentPlanRadio" + i) != null
				&& (typeof document.getElementById("treatmentPlanRadio" + i).checked) != 'undefined'
				&& document.getElementById("treatmentPlanRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("treatmentPlanRadio" + i) != null
					&& (typeof document
							.getElementById("treatmentPlanRadio" + i).checked) != 'undefined'
					&& document.getElementById("treatmentPlanRadio" + i).checked) {
				var deleteRow = document.getElementById("treatmentPlanRadio"
						+ i).parentNode.parentNode;
				document.getElementById("treatmentPlanRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowForTreatmentDone() {

	var tbl = document.getElementById('gridTreatmentDone');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbTreatmentDone');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'treatmentDoneRadio' + iteration;
	e0.id = 'treatmentDone' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'toothTreatmentDone' + iteration;
	e1.id = 'toothTreatmentDone' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('18', '18');
	e1.options[2] = new Option('17', '17');
	e1.options[3] = new Option('16', '16');
	e1.options[4] = new Option('15', '15');
	e1.options[5] = new Option('14', '14');
	e1.options[6] = new Option('13', '13');
	e1.options[7] = new Option('12', '12');
	e1.options[8] = new Option('11', '11');
	e1.options[9] = new Option('21', '21');
	e1.options[10] = new Option('22', '22');
	e1.options[11] = new Option('23', '23');
	e1.options[12] = new Option('24', '24');
	e1.options[13] = new Option('25', '25');
	e1.options[14] = new Option('26', '26');
	e1.options[15] = new Option('27', '27');
	e1.options[16] = new Option('28', '28');
	e1.options[17] = new Option('48', '48');
	e1.options[18] = new Option('47', '47');
	e1.options[19] = new Option('47', '46');
	e1.options[20] = new Option('45', '45');
	e1.options[21] = new Option('44', '44');
	e1.options[22] = new Option('43', '43');
	e1.options[23] = new Option('42', '42');
	e1.options[24] = new Option('41', '41');
	e1.options[25] = new Option('31', '31');
	e1.options[26] = new Option('32', '32');
	e1.options[27] = new Option('33', '33');
	e1.options[28] = new Option('34', '34');
	e1.options[29] = new Option('35', '35');
	e1.options[30] = new Option('36', '36');
	e1.options[31] = new Option('37', '37');
	e1.options[32] = new Option('38', '38');
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('Select');
	e2.name = 'treatmentTreatmentDone' + iteration;
	e2.id = 'treatmentTreatmentDone' + iteration;
	e2.options[0] = new Option('Select', '');
	e2.options[1] = new Option('Amalgam', 'Amalgam');
	e2.options[2] = new Option('Composite', 'Composite');
	e2.options[3] = new Option('GIC', 'GIC');
	e2.options[4] = new Option('IRM', 'IRM');
	e2.options[5] = new Option('Temporary filling', 'Temporary filling');
	e2.options[6] = new Option('Inlay / Onlay', 'Inlay / Onlay');
	e2.options[7] = new Option('Exudation', 'Exudation');
	e2.options[8] = new Option('Veneers', 'Veneers');
	e2.options[9] = new Option('Jacket crown fabrication',
			'Jacket crown fabrication');
	e2.options[10] = new Option('RCT', 'RCT');
	e2.options[11] = new Option('Re-RCT', 'Re-RCT');
	e2.options[12] = new Option('Perforation / Resorption repair',
			'Perforation / Resorption repair');
	e2.options[13] = new Option('Fibre Post and Core build up',
			'Fibre Post and Core build up');
	e2.options[14] = new Option('Cast post fabrication',
			'Cast post fabrication');
	e2.options[15] = new Option('Direct pulp capping', 'Direct pulp capping');
	e2.options[16] = new Option('Indirect pulp capping',
			'Indirect pulp capping');
	e2.options[17] = new Option('Pulpotomy', 'Pulpotomy');
	e2.options[18] = new Option('Apexogenesis / Apexification',
			'Apexogenesis / Apexification');
	e2.options[19] = new Option('Regenerative therapy', 'Regenerative therapy');
	e2.options[20] = new Option('Vital bleaching', 'Vital bleaching');
	e2.options[21] = new Option('Non - Vital Bleaching',
			'Non - Vital Bleaching');
	e2.options[22] = new Option('desensitizing agent', 'desensitizing agent');
	e2.options[23] = new Option('selective Grinding', 'selective Grinding');
	e2.options[24] = new Option('Apicoectomy', 'Apicoectomy');
	e2.options[25] = new Option('Peripical surgery', 'Peripical surgery');
	e2.options[26] = new Option('I and D', 'I and D');
	e2.options[27] = new Option('Orthodontic / Surgical Extrusion',
			'Orthodontic / Surgical Extrusion');
	e2.options[28] = new Option('Gingivectomy', 'Gingivectomy');
	e2.options[29] = new Option('Spliniting', 'Spliniting');
	e2.options[30] = new Option('Interdisciplinary approach',
			'Interdisciplinary approach');
	e2.options[31] = new Option('No active intervention needed',
			'No active intervention needed');
	e2.options[32] = new Option('Extraction', 'Extraction');
	e2.options[33] = new Option('Patient not willing for treatment',
			'Patient not willing for treatment');
	e2.options[34] = new Option('Others', 'Others');
	e2.style.width = '200px';
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'remarksTreatmentDone' + iteration;
	e3.id = 'remarksTreatmentDone' + iteration;
	e3.maxLength = "128";
	e3.className='largTextBoxOpd popper';
	cellRight3.appendChild(e3);

}

function removeRowForTreatmentDone() {
	var tbl = document.getElementById('gridTreatmentDone');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbTreatmentDone');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("treatmentDoneRadio" + i) != null
				&& (typeof document.getElementById("treatmentDoneRadio" + i).checked) != 'undefined'
				&& document.getElementById("treatmentDoneRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("treatmentDoneRadio" + i) != null
					&& (typeof document
							.getElementById("treatmentDoneRadio" + i).checked) != 'undefined'
					&& document.getElementById("treatmentDoneRadio" + i).checked) {
				var deleteRow = document.getElementById("treatmentDoneRadio"
						+ i).parentNode.parentNode;
				document.getElementById("treatmentDoneRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function dentalHistoryDiv(val) {
	if (val == "Yes") {
		document.getElementById("dentalHistoryDiv").style.display = 'block';
	} else {
		document.getElementById("dentalHistoryDiv").style.display = 'none';
	}

}
function habitsRelatedDiv(val) {
	if (val == "Yes") {
		document.getElementById("habitsRelatedDiv").style.display = 'block';
	} else {
		document.getElementById("habitsRelatedDiv").style.display = 'none';
	}

}

function showMedicalHistory() {
	if (document.getElementById('medicalHistory').checked == true) {
		document.getElementById("medicalHistoryDiv").style.display = 'inline';
	} else {
		document.getElementById("medicalHistoryDiv").style.display = 'none';
	}

}

function displayMeanValue(val, flag, i) {
	if (flag == 'Cranial') {
		if (val == 'Ar-Ptm (11HP)') {
			document.getElementById('meanValueCranial' + i).value = '36.3-38.3 mm';
		} else {
			document.getElementById('meanValueCranial' + i).value = '52.1-54.1 mm';
		}
	} else if (flag == 'Horizontal') {
		if (val == 'N-Apg (angle)') {
			document.getElementById('meanValueHorizontal' + i).value = '+ 5.75 - + 5.9';
		} else if (val == 'N-A (11HP)') {
			document.getElementById('meanValueHorizontal' + i).value = '+ 0.75 -+ 2.8 mm';
		} else if (val == 'N-B (11HP))') {
			document.getElementById('meanValueHorizontal' + i).value = '- 5.75 - 3.6 mm';
		} else if (val == 'N-Pg (11HP)') {
			document.getElementById('meanValueHorizontal' + i).value = '- 4.3 - 2.1 mm';
		}
	} else if (flag == 'Vertical') {
		if (val == 'N-ANS') {
			document.getElementById('meanValueVertical' + i).value = '52.5-55.55 mm';
		} else if (val == 'AMS-Gn') {
			document.getElementById('meanValueVertical' + i).value = '63.1 - 68.1 mm';
		} else if (val == 'PNS-N') {
			document.getElementById('meanValueVertical' + i).value = '50.9 - 55.8 mm';
		} else if (val == 'MP-HP (angle)') {
			document.getElementById('meanValueVertical' + i).value = '20 - 18.3';
		} else if (val == '1-NF') {
			document.getElementById('meanValueVertical' + i).value = '29.2 - 30.8 mm';
		} else if (val == '1-MP') {
			document.getElementById('meanValueVertical' + i).value = '36.8 - 42 mm';
		} else if (val == '6-NF') {
			document.getElementById('meanValueVertical' + i).value = '24.5 - 25.9 mm';
		} else if (val == '6-MP') {
			document.getElementById('meanValueVertical' + i).value = '30.2 - 34.1 mm';
		}
	} else if (flag == 'Maxilla') {
		if (val == 'PNS - ANS (11HP)') {
			document.getElementById('meanValueMaxilla' + i).value = '55.6 - 60.2 mm';
		} else if (val == 'Ar - Go (linear)') {
			document.getElementById('meanValueMaxilla' + i).value = '51.3 - 57.4 mm';
		} else if (val == 'Go-Pg (linear)') {
			document.getElementById('meanValueMaxilla' + i).value = '74.9 - 79.8 mm';
		} else if (val == 'B-Pg (11MP)') {
			document.getElementById('meanValueMaxilla' + i).value = '6.1 - 6.6 mm';
		} else if (val == 'Ar-Go-Gn (angle)') {
			document.getElementById('meanValueMaxilla' + i).value = '125.3 - 123.5';
		}

	} else if (flag == 'Dental') {
		if (val == 'OP upper - HP (angle)') {
			document.getElementById('meanValueDental' + i).value = '6.9 - 4.9';
		} else if (val == 'OP lower - HP (angle)') {
			document.getElementById('meanValueDental' + i).value = '';
		} else if (val == 'A-b (11 OP)') {
			document.getElementById('meanValueDental' + i).value = '-1.3 - -3mm';
		} else if (val == '1 - NF (angle)') {
			document.getElementById('meanValueDental' + i).value = '118.3 - 116';
		} else if (val == '1 - MP (angle)') {
			document.getElementById('meanValueDental' + i).value = '105.6 - 105.2';
		}
	} else if (flag == 'SoftTissueAnalysis') {
		if (val == 'Facial Angle') {
			document.getElementById('meanValueParticulars' + i).value = '90';
		} else if (val == 'Upper Lip Curve') {
			document.getElementById('meanValueParticulars' + i).value = '2.5';
		} else if (val == 'Skeletal Convexity at pt. A') {
			document.getElementById('meanValueParticulars' + i).value = '-2 to + 2 mm';
		} else if (val == 'H - line Angle') {
			document.getElementById('meanValueParticulars' + i).value = '7 to 15â�°';
		} else if (val == 'Nose Tip to H Line') {
			document.getElementById('meanValueParticulars' + i).value = '12 mm (max)';
		} else if (val == 'Upper Sulcus Depth') {
			document.getElementById('meanValueParticulars' + i).value = '5 mm';
		} else if (val == 'Upper Lip Thickness') {
			document.getElementById('meanValueParticulars' + i).value = '15 mm';
		} else if (val == 'Upper Lip Strain') {
			document.getElementById('meanValueParticulars' + i).value = '14 - 16';
		} else if (val == 'Lower Lip to H Line') {
			document.getElementById('meanValueParticulars' + i).value = '-1 to +2 mm';
		} else if (val == 'Lower Sulcus Depth') {
			document.getElementById('meanValueParticulars' + i).value = '5 mm';
		} else if (val == 'Soft Tissue Chin Thickness') {
			document.getElementById('meanValueParticulars' + i).value = '10 to 12 mm';
		} else if (val == 'Nasolabial Angle') {
			document.getElementById('meanValueParticulars' + i).value = '102 Â±8';
		} else if (val == 'Se') {
			document.getElementById('meanValueParticulars' + i).value = '22';
		} else if (val == 'FMA') {
			document.getElementById('meanValueParticulars' + i).value = '25â�°';
		} else if (val == 'IMPA') {
			document.getElementById('meanValueParticulars' + i).value = '90Â±5â�°';
		} else if (val == 'FMIA') {
			document.getElementById('meanValueParticulars' + i).value = '65â�°';
		} else if (val == 'WITS appraisal') {
			document.getElementById('meanValueParticulars' + i).value = '0/1';
		} else if (val == 'Ant. Face ht.') {
			document.getElementById('meanValueParticulars' + i).value = '';
		} else if (val == 'Post Face ht.') {
			document.getElementById('meanValueParticulars' + i).value = '';
		} else if (val == 'Post: Ant Face ht.56-62% clockwise65-80% counter-clockwise') {
			document.getElementById('meanValueParticulars' + i).value = '';
		} else if (val == 'Y axis') {
			document.getElementById('meanValueParticulars' + i).value = '58.4â�°';
		} else if (val == 'E plane') {
			document.getElementById('meanValueParticulars' + i).value = 'L/Lip -2 to 0';
		} else if (val == 'Effective Maxillary length') {
			document.getElementById('meanValueParticulars' + i).value = '';
		} else if (val == 'Upper facial height:Lower facial height') {
			document.getElementById('meanValueParticulars' + i).value = '';
		} else if (val == 'Nasion perpendicular to Point A') {
			document.getElementById('meanValueParticulars' + i).value = '0-1 mm';
		} else if (val == 'Nasion perpendicular to Pog') {
			document.getElementById('meanValueParticulars' + i).value = '-4 to 0 mm';
		} else if (val == 'Lower incisor to A-Pog Line') {
			document.getElementById('meanValueParticulars' + i).value = '1-3 mm';
		}
	} else if (flag == 'CEPHALOMETRICANALYSIS') {
		if (val == 'SNA') {
			var superText = "0";
			document.getElementById('steinerRefNorm' + i).value = document
					.write("82" + superText.sup());

			document.getElementById('kearalNorm' + i).value = '84.14â�°';
		} else if (val == 'SNB') {
			document.getElementById('steinerRefNorm' + i).value = '90â�°';
			document.getElementById('kearalNorm' + i).value = '81.85â�°';
		} else if (val == 'ANB') {
			document.getElementById('steinerRefNorm' + i).value = '2â�°';
			document.getElementById('kearalNorm' + i).value = '2.27â�°';
		} else if (val == 'SND') {
			document.getElementById('steinerRefNorm' + i).value = '76â�°';
			document.getElementById('kearalNorm' + i).value = '79.36â�°';
		} else if (val == '1 to NA') {
			document.getElementById('steinerRefNorm' + i).value = '22â�°';
			document.getElementById('kearalNorm' + i).value = '27.44â�°';
		} else if (val == '1 to  NA') {
			document.getElementById('steinerRefNorm' + i).value = '4';
			document.getElementById('kearalNorm' + i).value = '7.46';
		} else if (val == '1 to NB') {
			document.getElementById('steinerRefNorm' + i).value = '25â�°';
			document.getElementById('kearalNorm' + i).value = '30.75â�°';
		} else if (val == '1 to  NB') {
			document.getElementById('steinerRefNorm' + i).value = '4';
			document.getElementById('kearalNorm' + i).value = '7.5';
		} else if (val == 'Po to NB') {
			document.getElementById('steinerRefNorm' + i).value = 'Not Est';
			document.getElementById('kearalNorm' + i).value = '1.06';
		} else if (val == 'Po to 1 to NB') {
			document.getElementById('steinerRefNorm' + i).value = '1:1';
			document.getElementById('kearalNorm' + i).value = '1:1';
		} else if (val == '1 to 1') {
			document.getElementById('steinerRefNorm' + i).value = '131â�°';
			document.getElementById('kearalNorm' + i).value = '119.69â�°';
		} else if (val == 'Occl to SN') {
			document.getElementById('steinerRefNorm' + i).value = '14â�°';
			document.getElementById('kearalNorm' + i).value = '11.79â�°';
		} else if (val == 'GoGn to SN') {
			document.getElementById('steinerRefNorm' + i).value = '32â�°';
			document.getElementById('kearalNorm' + i).value = '27.91â�°';
		}

		else if (val == 'SL') {
			document.getElementById('steinerRefNorm' + i).value = '51';
			document.getElementById('kearalNorm' + i).value = '59.66';
		}

		else if (val == 'Se') {
			document.getElementById('steinerRefNorm' + i).value = '22';
			document.getElementById('kearalNorm' + i).value = '21.46';
		} else if (val == 'FMA') {
			document.getElementById('steinerRefNorm' + i).value = '25â�°';

		} else if (val == 'IMPA') {
			document.getElementById('steinerRefNorm' + i).value = '90Â±5â�°';

		} else if (val == 'FMIA') {
			document.getElementById('steinerRefNorm' + i).value = '65â�°';

		} else if (val == 'WITS appraisal') {
			document.getElementById('steinerRefNorm' + i).value = '0/1';
			document.getElementById('kearalNorm' + i).value = '84.14â�°';
		} else if (val == 'Ant. Face ht.') {
			document.getElementById('steinerRefNorm' + i).value = '82â�°';
			document.getElementById('kearalNorm' + i).value = '84.14â�°';
		} else if (val == 'Post Face ht.') {
			document.getElementById('steinerRefNorm' + i).value = '82â�°';
			document.getElementById('kearalNorm' + i).value = '84.14â�°';
		} else if (val == 'Post: Ant Face ht.56-62% clockwise65-80% counter-clockwise') {
			document.getElementById('steinerRefNorm' + i).value = '82â�°';
			document.getElementById('kearalNorm' + i).value = '84.14â�°';
		} else if (val == 'Y axis') {
			document.getElementById('steinerRefNorm' + i).value = '58.4â�°';
			document.getElementById('kearalNorm' + i).value = '62â�°';
		} else if (val == 'E plane') {
			document.getElementById('steinerRefNorm' + i).value = 'L/Lip -2 to 0';

		} else if (val == 'Effective Maxillary length') {
			document.getElementById('steinerRefNorm' + i).value = '';
			document.getElementById('kearalNorm' + i).value = '';
		} else if (val == 'Upper facial height:Lower facial height') {
			document.getElementById('steinerRefNorm' + i).value = '';
			document.getElementById('kearalNorm' + i).value = '';
		} else if (val == 'Nasion perpendicular to Point A') {
			document.getElementById('steinerRefNorm' + i).value = '0-1 mm';
			document.getElementById('kearalNorm' + i).value = '84.14â�°';
		} else if (val == 'Nasion perpendicular to Pog') {
			document.getElementById('steinerRefNorm' + i).value = '-4 to 0 mm';
			document.getElementById('kearalNorm' + i).value = '';
		} else if (val == 'Lower incisor to A-Pog Line') {
			document.getElementById('steinerRefNorm' + i).value = '1-3 mm';
			document.getElementById('kearalNorm' + i).value = '';
		}
	}

}

function addRowForCEPHALOMETRICANALYSIS() {

	var tbl = document.getElementById('gridCEPHALOMETRICANALYSIS');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbCEPHALOMETRICANALYSIS');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'CEPHALOMETRICANALYSISRadio' + iteration;
	e0.id = 'CEPHALOMETRICANALYSISRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'measurement' + iteration;
	e1.id = 'measurement' + iteration;
	e1.className = 'smallest'
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('SNA', 'SNA');
	e1.options[2] = new Option('SNB', 'SNB');
	e1.options[3] = new Option('ANB', 'ANB');
	e1.options[4] = new Option('SND', 'SND');
	e1.options[5] = new Option('1 to NA', '1 to NA');
	e1.options[6] = new Option('1 to  NA', '1 to  NA');
	e1.options[7] = new Option('1 to NB', '1 to NB');
	e1.options[8] = new Option('1 to  NB', '1 to  NB');
	e1.options[9] = new Option('Po to NB', 'Po to NB');
	e1.options[10] = new Option('Po to 1 to NB', 'Po to 1 to NB');
	e1.options[11] = new Option('1 to 1', '1 to 1');
	e1.options[12] = new Option('Occl to SN', 'Occl to SN');
	e1.options[13] = new Option('GoGn to SN', 'GoGn to SN');
	e1.options[14] = new Option('SL', 'SL');
	e1.options[15] = new Option('Se', 'Se');
	e1.options[16] = new Option('FMA', 'FMA');
	e1.options[17] = new Option('IMPA', 'IMPA');
	e1.options[18] = new Option('FMIA', 'FMIA');
	e1.options[19] = new Option('WITS appraisal', 'WITS appraisal');
	e1.options[20] = new Option('Ant. Face ht.', 'Ant. Face ht.');
	e1.options[21] = new Option('Post Face ht.', 'Post Face ht.');
	e1.options[22] = new Option(
			'Post: Ant Face ht.56-62% clockwise65-80% counter-clockwise',
			'Post: Ant Face ht.56-62% clockwise65-80% counter-clockwise');
	e1.options[23] = new Option('Y axis', 'Y axis');
	e1.options[24] = new Option('E plane', 'E plane');
	e1.options[25] = new Option('Effective Maxillary length',
			'Effective Maxillary length');
	e1.options[26] = new Option('Upper facial height:Lower facial height',
			'Upper facial height:Lower facial height');
	e1.options[27] = new Option('Nasion perpendicular to Point A',
			'Nasion perpendicular to Point A');
	e1.options[28] = new Option('Nasion perpendicular to Pog',
			'Nasion perpendicular to Pog');
	e1.options[29] = new Option('Lower incisor to A-Pog Line',
			'Lower incisor to A-Pog Line');

	e1.onchange = function() {
		displayMeanValue(this.value, 'CEPHALOMETRICANALYSIS', iteration)
	};
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('Select');
	var e2 = document.createElement('input');
	e2.name = 'steinerRefNorm' + iteration;
	e2.id = 'steinerRefNorm' + iteration;
	e2.className = 'small'
	e2.maxLength = 50;
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'kearalNorm' + iteration;
	e3.id = 'kearalNorm' + iteration;
	e3.className = 'small'
	e3.maxLength = 50;
	cellRight3.appendChild(e3);

	var cellRight4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.name = 'preTrt' + iteration;
	e4.id = 'preTrt' + iteration;
	e4.className = 'small'
	e4.maxLength = 50;
	cellRight4.appendChild(e4);

	var cellRight5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.name = 'postTrt' + iteration;
	e5.id = 'postTrt' + iteration;
	e5.className = 'small'
	e5.maxLength = 50;
	cellRight5.appendChild(e5);

	var cellRight6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.name = 'diff' + iteration;
	e6.id = 'diff' + iteration;
	e6.className = 'small'
	e6.maxLength = 50;
	cellRight6.appendChild(e6);
}

function removeRowForCEPHALOMETRICANALYSIS() {
	var tbl = document.getElementById('gridCEPHALOMETRICANALYSIS');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbCEPHALOMETRICANALYSIS');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("CEPHALOMETRICANALYSISRadio" + i) != null
				&& (typeof document.getElementById("CEPHALOMETRICANALYSISRadio"
						+ i).checked) != 'undefined'
				&& document.getElementById("CEPHALOMETRICANALYSISRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("CEPHALOMETRICANALYSISRadio" + i) != null
					&& (typeof document
							.getElementById("CEPHALOMETRICANALYSISRadio" + i).checked) != 'undefined'
					&& document
							.getElementById("CEPHALOMETRICANALYSISRadio" + i).checked) {
				var deleteRow = document
						.getElementById("CEPHALOMETRICANALYSISRadio" + i).parentNode.parentNode;
				document.getElementById("CEPHALOMETRICANALYSISRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowForCranial() {

	var tbl = document.getElementById('gridCranial');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbCranial');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'cranialRadio' + iteration;
	e0.id = 'cranialRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'measurementCranial' + iteration;
	e1.id = 'measurementCranial' + iteration;
	e1.className = 'smallest'
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Ar-Ptm (11HP)', 'Ar-Ptm (11HP)');
	e1.options[2] = new Option('Ptm-N (11HP)', 'Ptm-N (11HP)');
	e1.onchange = function() {
		displayMeanValue(this.value, 'Cranial', iteration)
	};
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('Select');
	var e2 = document.createElement('input');
	e2.name = 'meanValueCranial' + iteration;
	e2.id = 'meanValueCranial' + iteration;
	e2.className = 'small'
	e2.maxLength = 50;
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'valueCranial' + iteration;
	e3.id = 'valueCranial' + iteration;
	e3.className = 'small'
	e3.maxLength = 50;
	cellRight3.appendChild(e3);

}

function addRowForDental() {

	var tbl = document.getElementById('gridDental');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbDental');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'dentalRadio' + iteration;
	e0.id = 'dentalRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'measurementDental' + iteration;
	e1.id = 'measurementDental' + iteration;
	e1.className = 'smallest'
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('OP upper - HP (angle)', 'OP upper - HP (angle)');
	e1.options[2] = new Option('OP lower - HP (angle)', 'OP lower - HP (angle)');
	e1.options[3] = new Option('A-b (11 OP)', 'A-b (11 OP)');
	e1.options[4] = new Option('1 - NF (angle)', '1 - NF (angle)');
	e1.options[5] = new Option('1 - MP (angle)', '1 - MP (angle)');
	e1.onchange = function() {
		displayMeanValue(this.value, 'Dental', iteration)
	};
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('Select');
	var e2 = document.createElement('input');
	e2.name = 'meanValueDental' + iteration;
	e2.id = 'meanValueDental' + iteration;
	e2.className = 'small'
	e2.maxLength = 50;	
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'valueDental' + iteration;
	e3.id = 'valueDental' + iteration;
	e3.className = 'small'
	e3.maxLength = 50;	
	cellRight3.appendChild(e3);

}

function addRowForMaxilla() {

	var tbl = document.getElementById('gridMaxilla');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbMaxilla');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'maxillaRadio' + iteration;
	e0.id = 'maxillaRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'measurementMaxilla' + iteration;
	e1.id = 'measurementMaxilla' + iteration;
	e1.className = 'smallest'
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('PNS - ANS (11HP)', 'PNS - ANS (11HP)');
	e1.options[2] = new Option('Ar - Go (linear)', 'Ar - Go (linear)');
	e1.options[3] = new Option('Go-Pg (linear)', 'Go-Pg (linear)');
	e1.options[4] = new Option('B-Pg (11MP)', 'B-Pg (11MP)');
	e1.options[5] = new Option('Ar-Go-Gn (angle)', 'Ar-Go-Gn (angle)');
	e1.onchange = function() {
		displayMeanValue(this.value, 'Maxilla', iteration)
	};
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('Select');
	var e2 = document.createElement('input');
	e2.name = 'meanValueMaxilla' + iteration;
	e2.id = 'meanValueMaxilla' + iteration;
	e2.className = 'small'
	e2.maxLength = 50;
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'valueMaxilla' + iteration;
	e3.id = 'valueMaxilla' + iteration;
	e3.className = 'small'
	e3.maxLength = 50;
	cellRight3.appendChild(e3);

}

function addRowForModelAnalysis() {

	var tbl = document.getElementById('gridModelAnalysis');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbModelAnalysis');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'modelAnalysislRadio' + iteration;
	e0.id = 'modelAnalysislRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'noOne' + iteration;
	e1.id = 'noOne' + iteration;
	e1.className = 'smallest'
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('11', '11');
	e1.options[2] = new Option('12', '12');
	e1.options[3] = new Option('13', '13');
	e1.options[4] = new Option('14', '14');
	e1.options[5] = new Option('15', '15');
	e1.options[6] = new Option('16', '16');
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.name = 'noOneText' + iteration;
	e2.id = 'noOneText' + iteration;
	e2.className = 'small'
	e2.maxLength = 50;
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('Select');
	e3.name = 'noTwo' + iteration;
	e3.id = 'noTwo' + iteration;
	e3.className = 'smallest'
	e3.options[0] = new Option('Select', '');
	e3.options[1] = new Option('21', '11');
	e3.options[2] = new Option('22', '22');
	e3.options[3] = new Option('23', '23');
	e3.options[4] = new Option('24', '24');
	e3.options[5] = new Option('25', '25');
	e3.options[6] = new Option('26', '26');
	cellRight3.appendChild(e3);

	var cellRight4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.name = 'noTwoText' + iteration;
	e4.id = 'noTwoText' + iteration;
	e4.className = 'small'
	e4.maxLength = 50;
	cellRight4.appendChild(e4);

	var cellRight5 = row.insertCell(5);
	var e5 = document.createElement('Select');
	e5.name = 'noThree' + iteration;
	e5.id = 'noThree' + iteration;
	e5.className = 'smallest'
	e5.options[0] = new Option('Select', '');
	e5.options[1] = new Option('31', '31');
	e5.options[2] = new Option('32', '32');
	e5.options[3] = new Option('33', '33');
	e5.options[4] = new Option('34', '34');
	e5.options[5] = new Option('35', '35');
	e5.options[6] = new Option('36', '36');
	cellRight5.appendChild(e5);

	var cellRight6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.name = 'noThreeText' + iteration;
	e6.id = 'noThreeText' + iteration;
	e6.className = 'small'
	e6.maxLength = 50;
	cellRight6.appendChild(e6);

	var cellRight7 = row.insertCell(7);
	var e7 = document.createElement('Select');
	e7.name = 'noFour' + iteration;
	e7.id = 'noFour' + iteration;
	e7.className = 'smallest'
	e7.options[0] = new Option('Select', '');
	e7.options[1] = new Option('41', '41');
	e7.options[2] = new Option('42', '42');
	e7.options[3] = new Option('43', '43');
	e7.options[4] = new Option('44', '44');
	e7.options[5] = new Option('45', '45');
	e7.options[6] = new Option('46', '46');
	cellRight7.appendChild(e7);

	var cellRight8 = row.insertCell(8);
	var e8 = document.createElement('input');
	e8.name = 'noFourText' + iteration;
	e8.id = 'noFourText' + iteration;
	e8.className = 'small'
	e8.maxLength = 50;
	cellRight8.appendChild(e8);

}

function addRowForVertical() {

	var tbl = document.getElementById('gridVertical');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbVertical');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'verticalRadio' + iteration;
	e0.id = 'verticalRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'measurementVertical' + iteration;
	e1.id = 'measurementVertical' + iteration;
	e1.className = 'smallest'
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('N-ANS', 'N-ANS');
	e1.options[2] = new Option('AMS-Gn', 'AMS-Gn');
	e1.options[3] = new Option('PNS-N', 'PNS-N');
	e1.options[4] = new Option('MP-HP (angle)', 'MP-HP (angle)');
	e1.options[5] = new Option('1-NF', '1-NF');
	e1.options[6] = new Option('1-MP', '1-MP');
	e1.options[7] = new Option('6-NF', '6-NF');
	e1.options[8] = new Option('6-MP', '6-MP');
	e1.onchange = function() {
		displayMeanValue(this.value, 'Vertical', iteration)
	};
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('Select');
	var e2 = document.createElement('input');
	e2.name = 'meanValueVertical' + iteration;
	e2.id = 'meanValueVertical' + iteration;
	e2.className = 'small'
	e2.maxLength = 50;
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'valueVertical' + iteration;
	e3.id = 'valueVertical' + iteration;
	e3.className = 'small'
	e3.maxLength = 50;
	cellRight3.appendChild(e3);

}

function addRowForSoftTissueAnalysis() {

	var tbl = document.getElementById('gridSoftTissueAnalysis');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbSoftTissueAnalysis');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'softTissueAnalysisRadio' + iteration;
	e0.id = 'softTissueAnalysisRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'particulars' + iteration;
	e1.id = 'particulars' + iteration;
	e1.className = 'smallest'
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Facial Angle', 'Facial Angle');
	e1.options[2] = new Option('Upper Lip Curve', 'Upper Lip Curve');
	e1.options[3] = new Option('Skeletal Convexity at pt. A',
			'Skeletal Convexity at pt. A');
	e1.options[4] = new Option('H - line Angle', 'H - line Angle');
	e1.options[5] = new Option('Nose Tip to H Line', 'Nose Tip to H Line');
	e1.options[6] = new Option('Upper Sulcus Depth', 'Upper Sulcus Depth');
	e1.options[7] = new Option('Upper Lip Thickness', 'Upper Lip Thickness');
	e1.options[8] = new Option('Upper Lip Strain', 'Upper Lip Strain');
	e1.options[9] = new Option('Lower Lip to H Line', 'Lower Lip to H Line');
	e1.options[10] = new Option('Lower Sulcus Depth', 'Lower Sulcus Depth');
	e1.options[11] = new Option('Soft Tissue Chin Thickness',
			'Soft Tissue Chin Thickness');
	e1.options[12] = new Option('Nasolabial Angle', 'Nasolabial Angle');
	e1.options[13] = new Option('Se', 'Se');
	e1.options[14] = new Option('FMA', 'FMA');
	e1.options[15] = new Option('IMPA', 'IMPA');
	e1.options[16] = new Option('FMIA', 'FMIA');
	e1.options[17] = new Option('WITS appraisal', 'WITS appraisal');
	e1.options[18] = new Option('Ant. Face ht.', 'Ant. Face ht.');
	e1.options[19] = new Option('Post Face ht.', 'Post Face ht.');
	e1.options[20] = new Option(
			'Post: Ant Face ht.56-62% clockwise65-80% counter-clockwise',
			'Post: Ant Face ht.56-62% clockwise65-80% counter-clockwise');
	e1.options[21] = new Option('Y axis', 'Y axis');
	e1.options[22] = new Option('E plane', 'E plane');
	e1.options[23] = new Option('Effective Maxillary length',
			'Effective Maxillary length');
	e1.options[24] = new Option('Upper facial height:Lower facial height',
			'Upper facial height:Lower facial height');
	e1.options[25] = new Option('Nasion perpendicular to Point A',
			'Nasion perpendicular to Point A');
	e1.options[26] = new Option('Nasion perpendicular to Pog',
			'Nasion perpendicular to Pog');
	e1.options[27] = new Option('Lower incisor to A-Pog Line',
			'Lower incisor to A-Pog Line');

	e1.onchange = function() {
		displayMeanValue(this.value, 'SoftTissueAnalysis', iteration)
	};
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('Select');
	var e2 = document.createElement('input');
	e2.name = 'meanValueParticulars' + iteration;
	e2.id = 'meanValueParticulars' + iteration;
	e2.className = 'small'
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'preTrt' + iteration;
	e3.id = 'preTrt' + iteration;
	e3.className = 'small'
	e3.maxLength = 50;	
	cellRight3.appendChild(e3);

	var cellRight4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.name = 'postTrt' + iteration;
	e4.id = 'postTrt' + iteration;
	e4.className = 'small'
	e4.maxLength = 50;	
	cellRight4.appendChild(e4);

}

function addRowForHorizontal() {

	var tbl = document.getElementById('gridHorizontal');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbHorizontal');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'horizontalRadio' + iteration;
	e0.id = 'horizontalRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'measurementHorizontal' + iteration;
	e1.id = 'measurementHorizontal' + iteration;
	e1.className = 'smallest'
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('N-Apg (angle)', 'N-Apg (angle)');
	e1.options[2] = new Option('N-A (11HP)', 'N-A (11HP)');
	e1.options[3] = new Option('N-A (11HP)', 'N-A (11HP)');
	e1.options[4] = new Option('N-B (11HP)', 'N-B (11HP)');
	e1.options[5] = new Option('N-Pg (11HP)', 'N-Pg (11HP)');
	e1.onchange = function() {
		displayMeanValue(this.value, 'Horizontal', iteration)
	};
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('Select');
	var e2 = document.createElement('input');
	e2.name = 'meanValueHorizontal' + iteration;
	e2.id = 'meanValueHorizontal' + iteration;
	e2.className = 'small'
	e2.maxLength = 50;
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'valueHorizontal' + iteration;
	e3.id = 'valueHorizontal' + iteration;
	e3.className = 'small'
	e3.maxLength = 50;
	cellRight3.appendChild(e3);

}

function removeRowForVertical() {
	var tbl = document.getElementById('gridVertical');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbVertical');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("verticalRadio" + i) != null
				&& (typeof document.getElementById("verticalRadio" + i).checked) != 'undefined'
				&& document.getElementById("verticalRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("verticalRadio" + i) != null
					&& (typeof document.getElementById("verticalRadio" + i).checked) != 'undefined'
					&& document.getElementById("verticalRadio" + i).checked) {
				var deleteRow = document.getElementById("verticalRadio" + i).parentNode.parentNode;
				document.getElementById("verticalRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowForModelAnalysis() {
	var tbl = document.getElementById('gridModelAnalysis');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbModelAnalysis');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("modelAnalysisRadio" + i) != null
				&& (typeof document.getElementById("modelAnalysisRadio" + i).checked) != 'undefined'
				&& document.getElementById("modelAnalysisRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("modelAnalysisRadio" + i) != null
					&& (typeof document
							.getElementById("modelAnalysisRadio" + i).checked) != 'undefined'
					&& document.getElementById("modelAnalysisRadio" + i).checked) {
				var deleteRow = document.getElementById("modelAnalysisRadio"
						+ i).parentNode.parentNode;
				document.getElementById("modelAnalysisRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowForMaxilla() {
	var tbl = document.getElementById('gridMaxilla');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbMaxilla');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("maxillaRadio" + i) != null
				&& (typeof document.getElementById("maxillaRadio" + i).checked) != 'undefined'
				&& document.getElementById("maxillaRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("maxillaRadio" + i) != null
					&& (typeof document.getElementById("maxillaRadio" + i).checked) != 'undefined'
					&& document.getElementById("maxillaRadio" + i).checked) {
				var deleteRow = document.getElementById("maxillaRadio" + i).parentNode.parentNode;
				document.getElementById("maxillaRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowForDental() {
	var tbl = document.getElementById('gridDental');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbDental');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("dentalRadio" + i) != null
				&& (typeof document.getElementById("dentalRadio" + i).checked) != 'undefined'
				&& document.getElementById("dentalRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("dentalRadio" + i) != null
					&& (typeof document.getElementById("dentalRadio" + i).checked) != 'undefined'
					&& document.getElementById("dentalRadio" + i).checked) {
				var deleteRow = document.getElementById("dentalRadio" + i).parentNode.parentNode;
				document.getElementById("dentalRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowForCranial() {
	var tbl = document.getElementById('gridCranial');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbCranial');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("cranialRadio" + i) != null
				&& (typeof document.getElementById("cranialRadio" + i).checked) != 'undefined'
				&& document.getElementById("cranialRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("cranialRadio" + i) != null
					&& (typeof document.getElementById("cranialRadio" + i).checked) != 'undefined'
					&& document.getElementById("cranialRadio" + i).checked) {
				var deleteRow = document.getElementById("cranialRadio" + i).parentNode.parentNode;
				document.getElementById("cranialRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowForSoftTissueAnalysis() {
	var tbl = document.getElementById('gridSoftTissueAnalysis');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbSoftTissueAnalysis');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("softTissueAnalysisRadio" + i) != null
				&& (typeof document.getElementById("softTissueAnalysisRadio"
						+ i).checked) != 'undefined'
				&& document.getElementById("softTissueAnalysisRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("softTissueAnalysisRadio" + i) != null
					&& (typeof document
							.getElementById("softTissueAnalysisRadio" + i).checked) != 'undefined'
					&& document.getElementById("softTissueAnalysisRadio" + i).checked) {
				var deleteRow = document
						.getElementById("softTissueAnalysisRadio" + i).parentNode.parentNode;
				document.getElementById("softTissueAnalysisRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function removeRowForHorizontal() {
	var tbl = document.getElementById('gridHorizontal');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbHorizontal');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("horizontalRadio" + i) != null
				&& (typeof document.getElementById("horizontalRadio" + i).checked) != 'undefined'
				&& document.getElementById("horizontalRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("horizontalRadio" + i) != null
					&& (typeof document.getElementById("horizontalRadio" + i).checked) != 'undefined'
					&& document.getElementById("horizontalRadio" + i).checked) {
				var deleteRow = document.getElementById("horizontalRadio" + i).parentNode.parentNode;
				document.getElementById("horizontalRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowForDietary() {

	var tbl = document.getElementById('gridDietary');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbDietary');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'dietaryRadio' + iteration;
	e0.id = 'dietaryRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.name = 'formOfFood' + iteration;
	e1.id = 'formOfFood' + iteration;
	e1.className = 'smallest'
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Liquids', 'Liquids');
	e1.options[2] = new Option('Solid and Sticky', 'Solid and Sticky');
	e1.options[3] = new Option('Slowly Dissolving', 'Slowly Dissolving');
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('Select');
	e2.name = 'typeOfFood' + iteration;
	e2.id = 'typeOfFood' + iteration;
	e2.options[0] = new Option('Select', '');
	e2.options[1] = new Option('Soft Drinks', 'Soft Drinks');
	e2.options[2] = new Option('Fruit Drinks', 'Fruit Drinks');
	e2.options[3] = new Option('Cocoa Sugar Inbeverages',
			'Cocoa Sugar Inbeverages');
	e2.options[4] = new Option('Cake', 'Cake');
	e2.options[5] = new Option('Cupcake', 'Cupcake');
	e2.options[6] = new Option('Sweet Rolls', 'Sweet Rolls');
	e2.options[7] = new Option('Pastries', 'Pastries');
	e2.options[8] = new Option('Coffee Chocolates', 'Coffee Chocolates');
	e2.options[9] = new Option('Caramel', 'Caramel');
	e2.options[10] = new Option('Jelly Jam', 'Jelly Jam');
	e2.options[11] = new Option('Candy', 'Candy');
	e2.options[12] = new Option('Hard Candies', 'Hard Candies');
	e2.options[13] = new Option('Breathmints', 'Breathmints');
	e2.options[14] = new Option('Antacid Tablets', 'Antacid Tablets');

	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'timeOfIntake' + iteration;
	e3.id = 'timeOfIntake' + iteration;
	e3.className = 'small'
	e3.maxLength = 128;
	cellRight3.appendChild(e3);

	var cellRight4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.name = 'quantitySugarExposure' + iteration;
	e4.id = 'quantitySugarExposure' + iteration;
	e4.className = 'small'
	e4.maxLength = 128;	
	cellRight4.appendChild(e4);

	var cellRight5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.name = 'frequency' + iteration;
	e5.id = 'frequency' + iteration;
	e5.className = 'small'
	e5.maxLength = 5;	
	cellRight5.appendChild(e5);

	var cellRight6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.name = 'points' + iteration;
	e6.id = 'points' + iteration;
	e6.className = 'small'
	e6.maxLength = 5;	
	cellRight6.appendChild(e6);

}

function removeRowForDietary() {
	var tbl = document.getElementById('gridDietary');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbDietary');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("dietaryRadio" + i) != null
				&& (typeof document.getElementById("dietaryRadio" + i).checked) != 'undefined'
				&& document.getElementById("dietaryRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("dietaryRadio" + i) != null
					&& (typeof document.getElementById("dietaryRadio" + i).checked) != 'undefined'
					&& document.getElementById("dietaryRadio" + i).checked) {
				var deleteRow = document.getElementById("dietaryRadio" + i).parentNode.parentNode;
				document.getElementById("dietaryRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function displayOtherVal(val) {
	if (val.checked == true) {
		document.getElementById('othersPast').style.display = 'block';
	} else {
		document.getElementById('othersPast').style.display = 'none';
	}

}

function displayInformarValue(val) {
	if (val == "Any Other") {
		document.getElementById("informarDiv").style.display = 'block';
	} else {
		document.getElementById("informarDiv").style.display = 'none';
	}
}
function displayAnyOtherValue(val) {
	if (val == "Yes") {
		document.getElementById("anyOtherDiv").style.display = 'block';
	} else {
		document.getElementById("anyOtherDiv").style.display = 'none';
	}
}

function displayTypeOfDeliveryValue(val) {
	if (val == "Other") {
		document.getElementById("typeOfDeliveryDiv").style.display = 'block';
	} else {
		document.getElementById("typeOfDeliveryDiv").style.display = 'none';
	}
}
function displayBreastFedValue(val) {
	if (val == "Yes") {
		document.getElementById("breastFedDiv").style.display = 'block';
	} else {
		document.getElementById("breastFedDiv").style.display = 'none';
	}
}

function displayCombinationValue(val) {

	if (val == "Yes") {
		document.getElementById("combinationDiv").style.display = 'block';
	} else {
		document.getElementById("combinationDiv").style.display = 'none';
	}

}
function displayMouthBreathingValue(val) {

	if (val == "Yes") {
		document.getElementById("mouthBreathingValue").style.display = 'block';
	} else {
		document.getElementById("mouthBreathingValue").style.display = 'none';
	}

}

function displayTongueThrustingValue(val) {

	if (val == "Yes") {
		document.getElementById("tongueThrustingDiv").style.display = 'block';
	} else {
		document.getElementById("tongueThrustingDiv").style.display = 'none';
	}

}

function displayThumbFingerSuckingValue(val) {

	if (val == "Yes") {
		document.getElementById("thumbFingerSuckingDiv").style.display = 'block';
	} else {
		document.getElementById("thumbFingerSuckingDiv").style.display = 'none';
	}

}

function displayLipBitingSuckingValue(val) {

	if (val == "Yes") {
		document.getElementById("lipBitingSuckingDiv").style.display = 'block';
	} else {
		document.getElementById("lipBitingSuckingDiv").style.display = 'none';
	}

}

function displayNailBitingValue(val) {
	if (val == "Yes") {
		document.getElementById("nailBitingDiv").style.display = 'block';
	} else {
		document.getElementById("nailBitingDiv").style.display = 'none';
	}
}

function displayHairNormalValue(val) {
	if (val == "Normal") {
		document.getElementById("hairNormalDiv").style.display = 'block';
	} else {
		document.getElementById("hairNormalDiv").style.display = 'none';
	}
}

function displaySkinNormalValue(val) {
	if (val == "Normal") {
		document.getElementById("skinNormalDiv").style.display = 'block';
	} else {
		document.getElementById("skinNormalDiv").style.display = 'none';
	}
}

function displayNailsNormal(val) {
	if (val == "Normal") {
		document.getElementById("nailsNormalDiv").style.display = 'block';
	} else {
		document.getElementById("nailsNormalDiv").style.display = 'none';
	}
}

function displayEyesNormal(val) {
	if (val == "Normal") {
		document.getElementById("eyesValueDiv").style.display = 'block';
	} else {
		document.getElementById("eyesValueDiv").style.display = 'none';
	}
}

function displayEarsNormal(val) {
	if (val == "Normal") {
		document.getElementById("earsNormalDiv").style.display = 'block';
	} else {
		document.getElementById("earsNormalDiv").style.display = 'none';
	}
}
function displayNoseNormal(val) {
	if (val == "Normal") {
		document.getElementById("noseNormalDiv").style.display = 'block';
	} else {
		document.getElementById("noseNormalDiv").style.display = 'none';
	}
}

function displayTherapyDuringPregnancyValue(val) {
	if (val == "Yes") {
		document.getElementById("therapyDuringPregnancyDiv").style.display = 'block';
	} else {
		document.getElementById("therapyDuringPregnancyDiv").style.display = 'none';
	}
}

function displayNormalMovementValue() {
	if (document.getElementById('normalMovement').checked == true) {
		document.getElementById("normalMovementDiv").style.display = 'inline';
	} else {
		document.getElementById("normalMovementDiv").style.display = 'none';
	}

}
function displayClickingValue() {
	if (document.getElementById('clicking').checked == true) {
		document.getElementById("clickingDiv").style.display = 'inline';
	} else {
		document.getElementById("clickingDiv").style.display = 'none';
	}

}
function displayCrepitusValue() {
	if (document.getElementById('crepitus').checked == true) {
		document.getElementById("crepitusDiv").style.display = 'inline';
	} else {
		document.getElementById("crepitusDiv").style.display = 'none';
	}

}

function displayAnteriorDisplacementValue() {
	if (document.getElementById('anteriorDisplacement').checked == true) {
		document.getElementById("anteriorDisplacementDiv").style.display = 'inline';
	} else {
		document.getElementById("anteriorDisplacementDiv").style.display = 'none';
	}

}
function displayPosteriorDisplacementValue() {
	if (document.getElementById('posteriorDisplacement').checked == true) {
		document.getElementById("posteriorDisplacementDiv").style.display = 'inline';
	} else {
		document.getElementById("posteriorDisplacementDiv").style.display = 'none';
	}

}

function displayMucosaValue(val) {
	if (val == "Normal") {
		document.getElementById("mucosaDiv").style.display = 'block';
	} else {
		document.getElementById("mucosaDiv").style.display = 'none';
	}
}

function displayMucosaValue(val) {
	if (val == "Normal") {
		document.getElementById("mucosaDiv").style.display = 'block';
	} else {
		document.getElementById("mucosaDiv").style.display = 'none';
	}
}

function displayPalateValue(val) {
	if (val == "Normal") {
		document.getElementById("palateDiv").style.display = 'block';
	} else {
		document.getElementById("palateDiv").style.display = 'none';
	}
}
function displayPharynxValue(val) {
	if (val == "Normal") {
		document.getElementById("pharynxDiv").style.display = 'block';
	} else {
		document.getElementById("pharynxDiv").style.display = 'none';
	}
}

function displayFloorOfTheMouthValue(val) {
	if (val == "Normal") {
		document.getElementById("floorOfTheMouthDiv").style.display = 'block';
	} else {
		document.getElementById("floorOfTheMouthDiv").style.display = 'none';
	}
}

function displayTongueValue(val) {
	if (val == "Normal") {
		document.getElementById("tongueDiv").style.display = 'block';
	} else {
		document.getElementById("tongueDiv").style.display = 'none';
	}
}
function displayFrenalAttachmentsValue(val) {
	if (val == "Normal") {
		document.getElementById("frenalAttachmentsDiv").style.display = 'block';
	} else {
		document.getElementById("frenalAttachmentsDiv").style.display = 'none';
	}
}

function displayGingivaValue(val) {
	if (val == "Normal") {
		document.getElementById("gingivaDiv").style.display = 'block';
	} else {
		document.getElementById("gingivaDiv").style.display = 'none';
	}
}

function displayDiastemaValue(val) {
	if (val == "Present") {
		document.getElementById("diastemaDiv").style.display = 'block';
	} else {
		document.getElementById("diastemaDiv").style.display = 'none';
	}
}

function displayBottleFedValue(val) {
	if (val == "Yes") {
		document.getElementById("bottleFedDiv").style.display = 'block';
	} else {
		document.getElementById("bottleFedDiv").style.display = 'none';
	}
}

function addRowForDietRecordChart() {

	var tbl = document.getElementById('gridDiet');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbDiet');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name = 'dietRadio' + iteration;
	e0.id = 'dietRadio' + iteration;
	e0.className = 'radioCheck';
	cellRight0.appendChild(e0);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.name = 'breakfastTypeQuantity' + iteration;
	e1.id = 'breakfastTypeQuantity' + iteration;
	e1.maxLength = 45;
	cellRight1.appendChild(e1);

	var cellRight2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.name = 'breakfastPreparation' + iteration;
	e2.id = 'breakfastPreparation' + iteration;
	e2.maxLength = 45;
	cellRight2.appendChild(e2);

	var cellRight3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.name = 'snacksTypeQuantity' + iteration;
	e3.id = 'snacksTypeQuantity' + iteration;
	e3.maxLength = 45;
	cellRight3.appendChild(e3);

	var cellRight4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.name = 'snacksPreparation' + iteration;
	e4.id = 'snacksPreparation' + iteration;
	e4.maxLength = 45;
	cellRight4.appendChild(e4);

	var cellRight5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.name = 'lunchTypeQuantity' + iteration;
	e5.id = 'lunchTypeQuantity' + iteration;
	e5.maxLength = 45;
	cellRight5.appendChild(e5);

	var cellRight6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.name = 'lunchPreparation' + iteration;
	e6.id = 'lunchPreparation' + iteration;
	e6.maxLength = 45;
	cellRight6.appendChild(e6);

	var cellRight7 = row.insertCell(7);
	var e7 = document.createElement('input');
	e7.name = 'snacksTypeQuantityOne' + iteration;
	e7.id = 'snacksTypeQuantityOne' + iteration;
	e7.maxLength = 45;
	cellRight7.appendChild(e7);

	var cellRight8 = row.insertCell(8);
	var e8 = document.createElement('input');
	e8.name = 'snacksPreparationOne' + iteration;
	e8.id = 'snacksPreparationOne' + iteration;
	e8.maxLength = 45;
	cellRight8.appendChild(e8);

	var cellRight9 = row.insertCell(9);
	var e9 = document.createElement('input');
	e9.name = 'dinnerTypeQuantity' + iteration;
	e9.id = 'dinnerTypeQuantity' + iteration;
	e9.maxLength = 45;
	cellRight9.appendChild(e9);

	var cellRight10 = row.insertCell(10);
	var e10 = document.createElement('input');
	e10.name = 'dinnerPreparation' + iteration;
	e10.id = 'dinnerPreparation' + iteration;
	e10.maxLength = 45;
	cellRight10.appendChild(e10);

	var cellRight11 = row.insertCell(11);
	var e11 = document.createElement('input');
	e11.name = 'beforeBedQuantity' + iteration;
	e11.id = 'beforeBedQuantity' + iteration;
	e11.maxLength = 45;
	cellRight11.appendChild(e11);

	var cellRight12 = row.insertCell(12);
	var e12 = document.createElement('input');
	e12.name = 'beforeBedPreparation' + iteration;
	e12.id = 'beforeBedPreparation' + iteration;
	e12.maxLength = 45;
	cellRight12.appendChild(e12);

}

function removeRowForDietRecordChart() {
	var tbl = document.getElementById('gridDiet');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdbDiet');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("dietRadio" + i) != null
				&& (typeof document.getElementById("dietRadio" + i).checked) != 'undefined'
				&& document.getElementById("dietRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("dietRadio" + i) != null
					&& (typeof document.getElementById("dietRadio" + i).checked) != 'undefined'
					&& document.getElementById("dietRadio" + i).checked) {
				var deleteRow = document.getElementById("dietRadio" + i).parentNode.parentNode;
				document.getElementById("dietRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function displayBacterial(val) {
	if (val == "Yes") {
		document.getElementById("bacterialDiv").style.display = 'block';
	} else {
		document.getElementById("bacterialDiv").style.display = 'none';
	}
}

function displayViral(val) {
	if (val == "Yes") {
		document.getElementById("viralDiv").style.display = 'block';
	} else {
		document.getElementById("viralDiv").style.display = 'none';
	}
}

function displayParasitic(val) {
	if (val == "Yes") {
		document.getElementById("parasiticDiv").style.display = 'block';
	} else {
		document.getElementById("parasiticDiv").style.display = 'none';
	}
}

function displayOtherDis(val) {
	if (val == "OtherDis") {
		document.getElementById("natalHistoryDiv").style.display = 'block';
	} else {
		document.getElementById("natalHistoryDiv").style.display = 'none';
	}
}

function showInfertilityClinicTab(val) {
	if (val == 'SOCIOECONOMIC HISTORY') {
		var div = document.getElementById("title1");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'COMPLAINTS') {
		var div = document.getElementById("title2");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'MENSTRUALl') {
		var div = document.getElementById("title3");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'PAST SURGICAL HISTORY') {
		var div = document.getElementById("title4");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'Past Medical History') {
		var div = document.getElementById("title5");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'OBSTETRIC HISTORY') {
		var div = document.getElementById("title6");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'SEXUAL HISTORY') {
		var div = document.getElementById("title7");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'CLINICAL EXAMINATION') {
		var div = document.getElementById("title8");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'Endocrine Status') {
		var div = document.getElementById("title9");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'GYNAECOLOGICAL EXAMINATIONAL') {
		var div = document.getElementById("title10");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'INVESTIAGATIONS') {
		var div = document.getElementById("title11");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'HORMONAL TESTS') {
		var div = document.getElementById("title12");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'ULTRASONOGRAPHY') {
		var div = document.getElementById("title13");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	}
}

function displayInvestigationDiv(val) {
	// alert(val);
	if (val == "Clinical Summary") {
		document.getElementById("invDiv").style.display = 'none';
	} else if (val == "Examination") {
		document.getElementById("invDiv").style.display = 'none';
	} else if (val == "OP Consultation") {
		document.getElementById("invDiv").style.display = 'block';
	} else if (val == "Allergy") {
		document.getElementById("invDiv").style.display = 'none';
	} else if (val == "Treatment") {
		document.getElementById("invDiv").style.display = 'none';
	} else if (val == "Prescription") {
		document.getElementById("invDiv").style.display = 'none';
	} else if (val == "Comorbidity") {
		document.getElementById("invDiv").style.display = 'none';
	} else if (val == "Speciality") {
		document.getElementById("invDiv").style.display = 'block';
	} else if (val == "Speciality Summary") {
		document.getElementById("invDiv").style.display = 'none';
	}else if (val == "MLC") {
		document.getElementById("invDiv").style.display = 'none';
	} else if (val == "Delivery Details") {
		document.getElementById("invDiv").style.display = 'none';
	} else if (val == "PNC") {
		document.getElementById("invDiv").style.display = 'none';
	}

}

// added by govind 23-09-2017
function openTaperedMedicine(url) {
	/* submitForm('opdMain','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo); */
	window
			.open(
					url,
					"opd_window",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
}

function editTaperedMedicine(row, itemId) {
	// alert("editTaperedMedicine");
	var url = '/hms/hms/opd?method=showTaperdMedicine&nomenclature=' + itemId
			+ '&' + getFormData('taperedForm') + '&taperedEdit=Y' + '&row='
			+ row + '&' + csrfTokenName + '=' + csrfTokenValue;
	openTaperedMedicine(url);
}

function getFormData(formName) {
	var str = "";
	inputs = eval('document.' + formName + '.elements');
	// alert(inputs.length);
	for (i = 0; i < inputs.length; i++) {
		str = str + inputs[i].name + "=" + inputs[i].value + "&"
	}
	return str;
}
// added by govind 23-09-2017

function showCollapasbleTab(val) {
	if (val == 'Ear') {
		var div = document.getElementById("earTitle");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'Nose') {
		var div = document.getElementById("noseTitle");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'Neck') {
		var div = document.getElementById("neckTitle");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	} else if (val == 'ENT') {
		var div = document.getElementById("entTitle");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	}
	
	
	else if (val == 'oralCavity') {
		var div = document.getElementById("oralCavityTitle");
		if (div.style.display !== "block") {
			div.style.display = "block";
		} else {
			div.style.display = "none";
		}
	}
	
	
	
}

function isNumber(evt) {
	var iKeyCode = (evt.which) ? evt.which : evt.keyCode
	if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
		return false;

	return true;
}

function isNumberWithSign(evt) {
	var iKeyCode = (evt.which) ? evt.which : evt.keyCode
	if (iKeyCode != 45 && iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
		return false;

	return true;
}

function isNumberDecimal(evt) {
	var iKeyCode = (evt.which) ? evt.which : evt.keyCode
			 if (iKeyCode != 46 && iKeyCode > 31 
			            && (iKeyCode < 48 || iKeyCode > 57))
		return false;

	return true;
}

// General Medicine
function toggleOtherTextbox(val, textBoxName, textLength, spanId) {
	var span = document.getElementById(spanId);
	if (val == 'Others' || val == 'y') {
		var other = document.createElement("input");
		other.type = "text";
		other.name = textBoxName;
		other.setAttribute('maxlength', textLength);
		span.appendChild(other);
	} else
		span.innerHTML = "";

}




function setVitalValue(val, fieldId) {
	if(document.getElementById(fieldId))
		document.getElementById(fieldId).value = val;
}
function populateValueInOtherFields(val, parameterName, indx) {
	if (parameterName == 'weight' || parameterName == 'Weight') {
		document.getElementById('weight').value = val;

	}
	if (parameterName == 'Length' || parameterName == 'length') {
		document.getElementById('height').value = val;

	}
	if (parameterName == 'Head Circumference'
			|| parameterName == 'head circumference') {
		document.getElementById('headCircumference').value = val;

	}

}

function alphanumericOnly(e) {
	var k;
	document.all ? k = e.keyCode : k = e.which;
	return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k >= 48 && k <= 57));
}

// Contact Lens
function isClickedCB(cbId, textBoxId) {
	if (document.getElementById(cbId) != null
			&& !document.getElementById(cbId).checked) {
		document.getElementById(textBoxId).value = "";
		alert("Please select the checkbox first");
	}
}

// end
function chkDrugHistory(val,increment){
	if(val=="Others"){
		document.getElementById("txtOtherDrugName"+increment).style.display='block';
	}else{
		document.getElementById("txtOtherDrugName"+increment).style.display='none';
	}
}
function chkpreviousAttemptsAtAbstinence(val){
	if(val=="Yes"){
		document.getElementById("txtpreviousAttemptsAtAbstinence").style.display='block';
	}else{
		document.getElementById("txtpreviousAttemptsAtAbstinence").style.display='none';
	}
}
function chkreasonsForSeeking(val){
	if(val=="Others"){
		document.getElementById("txtreasonsForSeeking").style.display='block';
	}else{
		document.getElementById("txtreasonsForSeeking").style.display='none';
	}
}
function chkformulationPlan(val){
	if(val=="Others"){
		document.getElementById("txtformulationPlan").style.display='block';
	}else{
		document.getElementById("txtformulationPlan").style.display='none';
	}
}

//added by abhishek for nephrocasesheet 24-11-2017
function checkDerangedRftDetails(val) {
	if (document.getElementById('derangedRft').checked) {
		document.getElementById('derangedRftDuration').style.display = 'block';
		document.getElementById('derangedRftDetails').style.display = 'block';
	} else {
		document.getElementById('derangedRftDuration').style.display = 'none';
		document.getElementById('derangedRftDetails').style.display = 'none';
	}
} 

function checkOliguriaDetails(val) {
	if (document.getElementById('oliguria').checked) {
		document.getElementById('oliguriaDuration').style.display = 'block';
		document.getElementById('oliguriaDetails').style.display = 'block';
	} else {
		document.getElementById('oliguriaDuration').style.display = 'none';
		document.getElementById('oliguriaDetails').style.display = 'none';
	}
} 

function checkEdmaFacialDetails(val) {
	if (document.getElementById('edmaFacial').checked) {
		document.getElementById('edmaFacialDuration').style.display = 'block';
		document.getElementById('edmaFacialDetails').style.display = 'block';
	} else {
		document.getElementById('edmaFacialDuration').style.display = 'none';
		document.getElementById('edmaFacialDetails').style.display = 'none';
	}
} 

function checkEdmaPedalDetails(val) {
	if (document.getElementById('edmaPedal').checked) {
		document.getElementById('edmaPedalDuration').style.display = 'block';
		document.getElementById('edmaPedalDetails').style.display = 'block';
	} else {
		document.getElementById('edmaPedalDuration').style.display = 'none';
		document.getElementById('edmaPedalDetails').style.display = 'none';
	}
} 

function checkVomatingBiliousDetails(val) {
	if (document.getElementById('vomatingBilious').checked) {
		document.getElementById('vomatingBiliousDuration').style.display = 'block';
		document.getElementById('vomatingBiliousDetails').style.display = 'block';
	} else {
		document.getElementById('vomatingBiliousDuration').style.display = 'none';
		document.getElementById('vomatingBiliousDetails').style.display = 'none';
	}
} 

function checkHermaturiaCoffeeColouredDetails(val) {
	if (document.getElementById('hermaturiaCoffeeColoured').checked) {
		document.getElementById('hermaturiaCoffeeColouredDuration').style.display = 'block';
		document.getElementById('hermaturiaCoffeeColouredDetails').style.display = 'block';
	} else {
		document.getElementById('hermaturiaCoffeeColouredDuration').style.display = 'none';
		document.getElementById('hermaturiaCoffeeColouredDetails').style.display = 'none';
	}
} 

function checkHermaturiaPainfulDetails(val) {
	if (document.getElementById('hermaturiaPainful').checked) {
		document.getElementById('hermaturiaPainfulDuration').style.display = 'block';
		document.getElementById('hermaturiaPainfulDetails').style.display = 'block';
	} else {
		document.getElementById('hermaturiaPainfulDuration').style.display = 'none';
		document.getElementById('hermaturiaPainfulDetails').style.display = 'none';
	}
} 

function checkFeverIntermittentDetails(val) {
	if (document.getElementById('feverIntermittent').checked) {
		document.getElementById('feverIntermittentDuration').style.display = 'block';
		document.getElementById('feverIntermittentDetails').style.display = 'block';
	} else {
		document.getElementById('feverIntermittentDuration').style.display = 'none';
		document.getElementById('feverIntermittentDetails').style.display = 'none';
	}
} 

function checkFeverChillsRigorsDetails(val) {
	if (document.getElementById('feverChillsRigors').checked) {
		document.getElementById('feverChillsRigorsDuration').style.display = 'block';
		document.getElementById('feverChillsRigorsDetails').style.display = 'block';
	} else {
		document.getElementById('feverChillsRigorsDuration').style.display = 'none';
		document.getElementById('feverChillsRigorsDetails').style.display = 'none';
	}
} 

function checkhemoptysisDetails(val) {
	if (document.getElementById('hemoptysis').checked) {
		document.getElementById('hemoptysisDuration').style.display = 'block';
		document.getElementById('hemoptysisDetails').style.display = 'block';
	} else {
		document.getElementById('hemoptysisDuration').style.display = 'none';
		document.getElementById('hemoptysisDetails').style.display = 'none';
	}
} 

function checkPruritusDetails(val) {
	if (document.getElementById('pruritus').checked) {
		document.getElementById('pruritusDuration').style.display = 'block';
		document.getElementById('pruritusDetails').style.display = 'block';
	} else {
		document.getElementById('pruritusDuration').style.display = 'none';
		document.getElementById('pruritusDetails').style.display = 'none';
	}
} 

function checkCkdDetails(val) {
	if (document.getElementById('ckd').checked) {
		document.getElementById('ckdDuration').style.display = 'block';
		document.getElementById('ckdDetails').style.display = 'block';
	} else {
		document.getElementById('ckdDuration').style.display = 'none';
		document.getElementById('ckdDetails').style.display = 'none';
	}
} 

function checkHeadacheDetails(val) {
	if (document.getElementById('headache').checked) {
		document.getElementById('headacheDuration').style.display = 'block';
		document.getElementById('headacheDetails').style.display = 'block';
	} else {
		document.getElementById('headacheDuration').style.display = 'none';
		document.getElementById('headacheDetails').style.display = 'none';
	}
} 

function checkHypertensionDetails(val) {
	if (document.getElementById('hypertension').checked) {
		document.getElementById('hypertensionDuration').style.display = 'block';
		document.getElementById('hypertensionDetails').style.display = 'block';
	} else {
		document.getElementById('hypertensionDuration').style.display = 'none';
		document.getElementById('hypertensionDetails').style.display = 'none';
	}
} 

function checkLutsFrequencyDetails(val) {
	if (document.getElementById('lutsFrequency').checked) {
		document.getElementById('lutsFrequencyDuration').style.display = 'block';
		document.getElementById('lutsFrequencyDetails').style.display = 'block';
	} else {
		document.getElementById('lutsFrequencyDuration').style.display = 'none';
		document.getElementById('lutsFrequencyDetails').style.display = 'none';
	}
} 

function checkLutsUrgencyDetails(val) {
	if (document.getElementById('lutsUrgency').checked) {
		document.getElementById('lutsUrgencyDuration').style.display = 'block';
		document.getElementById('lutsUrgencyDetails').style.display = 'block';
	} else {
		document.getElementById('lutsUrgencyDuration').style.display = 'none';
		document.getElementById('lutsUrgencyDetails').style.display = 'none';
	}
} 

function checkLutsObstructedDetails(val) {
	if (document.getElementById('lutsObstructed').checked) {
		document.getElementById('lutsObstructedDuration').style.display = 'block';
		document.getElementById('lutsObstructedDetails').style.display = 'block';
	} else {
		document.getElementById('lutsObstructedDuration').style.display = 'none';
		document.getElementById('lutsObstructedDetails').style.display = 'none';
	}
} 

function checkLutsNocturiaDetails(val) {
	if (document.getElementById('lutsNocturia').checked) {
		document.getElementById('lutsNocturiaDuration').style.display = 'block';
		document.getElementById('lutsNocturiaDetails').style.display = 'block';
	} else {
		document.getElementById('lutsNocturiaDuration').style.display = 'none';
		document.getElementById('lutsNocturiaDetails').style.display = 'none';
	}
} 

function checkCoughDetails(val) {
	if (document.getElementById('cough').checked) {
		document.getElementById('coughDuration').style.display = 'block';
		document.getElementById('coughDetails').style.display = 'block';
	} else {
		document.getElementById('coughDuration').style.display = 'none';
		document.getElementById('coughDetails').style.display = 'none';
	}
} 

function checkChronicOnMhd(val) {
	if (document.getElementById('chronicOnMhd').checked) {
		document.getElementById('').style.display = 'block';
		document.getElementById('').style.display = 'block';
	} else {
		document.getElementById('').style.display = 'none';
		document.getElementById('').style.display = 'none';
	}
} 

function checkChronicNotOnMhd(val) {
	if (document.getElementById('chronicNotOnMhd').checked) {
		document.getElementById('').style.display = 'block';
		document.getElementById('').style.display = 'block';
	} else {
		document.getElementById('').style.display = 'none';
		document.getElementById('').style.display = 'none';
	}
} 

function checkCapd(val) {
	if (document.getElementById('capd').checked) {
		document.getElementById('').style.display = 'block';
		document.getElementById('').style.display = 'block';
	} else {
		document.getElementById('').style.display = 'none';
		document.getElementById('').style.display = 'none';
	}
} 

function checkTransplantation(val) {
	if (document.getElementById('transplantation').checked) {
		document.getElementById('').style.display = 'block';
		document.getElementById('').style.display = 'block';
	} else {
		document.getElementById('').style.display = 'none';
		document.getElementById('').style.display = 'none';
	}
} 

function checkBreathlessnessNyhaClassDetails(val) {
	if (document.getElementById('breathlessnessNyhaClass').checked) {
		document.getElementById('breathlessnessNyhaClassDuration').style.display = 'block';
		document.getElementById('breathlessnessNyhaClassDetails').style.display = 'block';
	} else {
		document.getElementById('breathlessnessNyhaClassDuration').style.display = 'none';
		document.getElementById('breathlessnessNyhaClassDetails').style.display = 'none';
	}
}

function checkFrothingDetails(val) {
	if (document.getElementById('frothing').checked) {
		document.getElementById('frothingDuraton').style.display = 'block';
		document.getElementById('frothingDetails').style.display = 'block';
	} else {
		document.getElementById('frothingDuraton').style.display = 'none';
		document.getElementById('frothingDetails').style.display = 'none';
	}
}

function checkDysuriaDetails(val) {
	if (document.getElementById('dysuria').checked) {
		document.getElementById('dysuriaDuration').style.display = 'block';
		document.getElementById('dysuriaDetails').style.display = 'block';
	} else {
		document.getElementById('dysuriaDuration').style.display = 'none';
		document.getElementById('dysuriaDetails').style.display = 'none';
	}
}

function checkChestPainDetails(val) {
	if (document.getElementById('chestPain').checked) {
		document.getElementById('chestPainDuration').style.display = 'block';
		document.getElementById('chestPainDetails').style.display = 'block';
	} else {
		document.getElementById('chestPainDuration').style.display = 'none';
		document.getElementById('chestPainDetails').style.display = 'none';
	}
}

function checkAbdominalPainDetails(val) {
	if (document.getElementById('abdominalPain').checked) {
		document.getElementById('abdominalPainDuration').style.display = 'block';
		document.getElementById('abdominalPainDetails').style.display = 'block';
	} else {
		document.getElementById('abdominalPainDuration').style.display = 'none';
		document.getElementById('abdominalPainDetails').style.display = 'none';
	}
}

function checkLithuriaDetails(val) {
	if (document.getElementById('lithuria').checked) {
		document.getElementById('lithuriaDuration').style.display = 'block';
		document.getElementById('lithuriaDetails').style.display = 'block';
	} else {
		document.getElementById('lithuriaDuration').style.display = 'none';
		document.getElementById('lithuriaDetails').style.display = 'none';
	}
}

function checkfitnessProcedureDetails(val) {
	if (document.getElementById('fitnessProcedure').checked) {
		document.getElementById('fitnessProcedureDuration').style.display = 'block';
		document.getElementById('fitnessProcedureDetails').style.display = 'block';
	} else {
		document.getElementById('fitnessProcedureDuration').style.display = 'none';
		document.getElementById('fitnessProcedureDetails').style.display = 'none';
	}
}

function checkVisualSymptomsDetails(val) {
	if (document.getElementById('visualSymptoms').checked) {
		document.getElementById('visualSymptomsDuration').style.display = 'block';
		document.getElementById('visualSymptomsDetails').style.display = 'block';
	} else {
		document.getElementById('visualSymptomsDuration').style.display = 'none';
		document.getElementById('visualSymptomsDetails').style.display = 'none';
	}
}

function checkVomatingBloodVomitusDetails(val) {
	if (document.getElementById('vomatingBloodVomitus').checked) {
		document.getElementById('vomatingBloodVomitusDuration').style.display = 'block';
		document.getElementById('vomatingBloodVomitusDetails').style.display = 'block';
	} else {
		document.getElementById('vomatingBloodVomitusDuration').style.display = 'none';
		document.getElementById('vomatingBloodVomitusDetails').style.display = 'none';
	}
} 

function checkJvpRaised(val) {
	if (document.getElementById('jvpcheckbox').checked) {
		document.getElementById('jvp').style.display = 'block';
		document.getElementById('jvpRaised').style.display = 'block';
	} else {
		document.getElementById('jvp').style.display = 'none';
		document.getElementById('jvpRaised').style.display = 'none';
	}
} 

function chronicKidneyDiseaseRemark(val) {
	if (document.getElementById('chronicKidneyDisease').checked) {
		document.getElementById('chronicKidneyDiseaseDiv').style.display = 'block';

	} else {
		document.getElementById('chronicKidneyDiseaseDiv').style.display = 'none';

	}
}

function checkLymphadenopathy(val) {
	if (document.getElementById('lymphadenopathy').checked) {
		document.getElementById('lymphadenopathyValue').style.display = 'block';
	} else {
		document.getElementById('lymphadenopathyValue').style.display = 'none';
	}
}

function checkDysmenorrheaRemarks(val) {
	if (document.getElementById('dysmenorrhea').checked) {
		document.getElementById('dysmenorrheaRemarks').style.display = 'block';
	} else {
		document.getElementById('dysmenorrheaRemarks').style.display = 'none';
	}
}

function checkMenorrhagiaRemarks(val) {
	if (document.getElementById('menorrhagia').checked) {
		document.getElementById('menorrhagiaRemarks').style.display = 'block';
	} else {
		document.getElementById('menorrhagiaRemarks').style.display = 'none';
	}
}

function checkfamilyHistoryChronicKidenyDiseaseValue(val) {
	if (document.getElementById('familyHistoryChronicKidenyDisease').checked) {
		document.getElementById('familyHistoryChronicKidenyDiseaseDiv').style.display = 'block';

	} else {
		document.getElementById('familyHistoryChronicKidenyDiseaseDiv').style.display = 'none';

	}
}

 
 


function showListBoxValueInTextArea(val,id1,id2) {
    var str="",i;
    var element = document.getElementById(id1);
	for (i=0;i < element.options.length;i++) {
	    if (element.options[i].selected) {
	    	if(str.trim()!='')
	    		str = str+ ", "
	    	
	    		str =	str+element.options[i].value;	
	    }
	}
	document.getElementById(id2).innerHTML = str;

}


function calculateDermotologyBMI() {
		var height = document.getElementById("dermoHeight").value;
		var weight = document.getElementById("dermoWeight").value;
		document.getElementById("dermoBmi").value = "";
		
		if(height != null && weight != null && height != "" && weight != "") {
			var height = 	parseFloat(height)/100;
			var val=((weight/(height*height)).toFixed(2));
			if(val=="NaN")
				{
				document.getElementById("dermoBmi").value ="";
				document.getElementById("bmi").value ="";
				}else{
			document.getElementById("dermoBmi").value = ((weight/(height*height)).toFixed(2));
			document.getElementById("bmi").value = ((weight/(height*height)).toFixed(2));
				}
		}
		DermotologyBmiCat();
	}

	function DermotologyBmiCat (){
		var bmicat;
		var height = document.getElementById("dermoHeight").value;
		var weight = document.getElementById("dermoWeight").value;
		if(height != null && weight != null && height != "" && weight != "") {
			var height = 	parseFloat(height)/100;
			bmicat=(weight/(height*height)).toFixed(2);

			document.getElementById("demoBmiCat").innerHTML = " ";
			document.getElementById("bmiCat").innerHTML= "";
			 if(bmicat<18.5){
				 document.getElementById("demoBmiCat").innerHTML = "Underweight";
				 document.getElementById("demoBmiCat").style.color = '#F65C5C';				 
				 document.getElementById("bmiCat").innerHTML = "Underweight";
				 document.getElementById("bmiCat").style.color = '#F65C5C';				 
				 document.getElementById("dermoBmi").style.color = '#F65C5C';
				 document.getElementById("bmi").style.color = '#F65C5C';
			}else if(bmicat>=18.5 && bmicat<25){
				document.getElementById("demoBmiCat").innerHTML = "Healthy Range" ;	
				document.getElementById("demoBmiCat").style.color = 'green';				
				document.getElementById("bmiCat").innerHTML = "Healthy Range" ;	
				document.getElementById("bmiCat").style.color = 'green';				
				document.getElementById("dermoBmi").style.color = 'green';
				document.getElementById("bmi").style.color = 'green';
			}else if(bmicat>=25 && bmicat<=30){
				document.getElementById("demoBmiCat").innerHTML = "Overweight";
				document.getElementById("demoBmiCat").style.color = '#574F4F';				
				document.getElementById("bmiCat").innerHTML = "Overweight";
				document.getElementById("bmiCat").style.color = '#574F4F';				
				document.getElementById("dermoBmi").style.color = '#574F4F';
				document.getElementById("bmi").style.color = '#574F4F';
			}else if(bmicat>=30 && bmicat<=35){
				document.getElementById("demoBmiCat").innerHTML = "Obese";
				document.getElementById("demoBmiCat").style.color = '#C40707';				
				document.getElementById("bmiCat").innerHTML = "Obese";
				document.getElementById("bmiCat").style.color = '#C40707';				
				document.getElementById("dermoBmi").style.color = '#C40707';
				document.getElementById("bmi").style.color = '#C40707';
			}else if(bmicat>35){
				document.getElementById("demoBmiCat").innerHTML = "Severely obese ";
				document.getElementById("demoBmiCat").style.color = '#AD0C0C';				
				document.getElementById("bmiCat").innerHTML = "Severely obese ";
				document.getElementById("bmiCat").style.color = '#AD0C0C';				
				document.getElementById("dermoBmi").style.color = '#AD0C0C';
				document.getElementById("bmi").style.color = '#AD0C0C';
			}else{
				document.getElementById("demoBmiCat").innerHTML = "";
				document.getElementById("bmiCat").innerHTML = "";
			}
			}
			else{
				
				document.getElementById("demoBmiCat").innerHTML = "";
				document.getElementById("bmiCat").innerHTML = "";
			}		
	}

	
	function calculateleprosyBMI() {
			var height = document.getElementById("leprosyHeight").value;
			var weight = document.getElementById("leprosyWeight").value;
			document.getElementById("leprosyBmi").value = "";
			if(height != null && weight != null && height != "" && weight != "") {
				var height = 	parseFloat(height)/100;
				var val=((weight/(height*height)).toFixed(2))
				if(val=='NaN'){
					document.getElementById("leprosyBmi").value ="";
					document.getElementById("bmi").value ="";
				}
				else{
				document.getElementById("leprosyBmi").value = ((weight/(height*height)).toFixed(2));
				document.getElementById("bmi").value = ((weight/(height*height)).toFixed(2));
					}
			}
			leprosyBmiCat();
		}

	function leprosyBmiCat(){
			var bmicat;
			var height = document.getElementById("leprosyHeight").value;
			var weight = document.getElementById("leprosyWeight").value;
			if(height != null && weight != null && height != "" && weight != "") {
				var height = 	parseFloat(height)/100;
				bmicat=(weight/(height*height)).toFixed(2);

				document.getElementById("leprosyBmiCat").innerHTML = " ";
				 if(bmicat<18.5){
					 document.getElementById("leprosyBmiCat").innerHTML = "Underweight";
					 document.getElementById("leprosyBmiCat").style.color = '#F65C5C';					 
					 document.getElementById("bmiCat").innerHTML = "Underweight";
					 document.getElementById("bmiCat").style.color = '#F65C5C';					 
					 document.getElementById("leprosyBmi").style.color = '#F65C5C';
					 document.getElementById("bmi").style.color = '#F65C5C';
				}else if(bmicat>=18.5 && bmicat<25){
					document.getElementById("leprosyBmiCat").innerHTML = "Healthy Range" ;	
					document.getElementById("leprosyBmiCat").style.color = 'green';					
					document.getElementById("bmiCat").innerHTML = "Healthy Range" ;	
					document.getElementById("bmiCat").style.color = 'green';					
					document.getElementById("leprosyBmi").style.color = 'green';
					document.getElementById("bmi").style.color = 'green';
				}else if(bmicat>=25 && bmicat<=30){
					document.getElementById("leprosyBmiCat").innerHTML = "Overweight";
					document.getElementById("leprosyBmiCat").style.color = '#574F4F';					
					document.getElementById("bmiCat").innerHTML = "Overweight";
					document.getElementById("bmiCat").style.color = '#574F4F';					
					document.getElementById("leprosyBmi").style.color = '#574F4F';
					document.getElementById("bmi").style.color = '#574F4F';
				}else if(bmicat>=30 && bmicat<=35){
					document.getElementById("leprosyBmiCat").innerHTML = "Obese";
					document.getElementById("leprosyBmiCat").style.color = '#C40707';					
					document.getElementById("bmiCat").innerHTML = "Obese";
					document.getElementById("bmiCat").style.color = '#C40707';					
					document.getElementById("leprosyBmi").style.color = '#C40707';
					document.getElementById("bmi").style.color = '#C40707';
				}else if(bmicat>35){
					document.getElementById("leprosyBmiCat").innerHTML = "Severely obese ";
					document.getElementById("leprosyBmiCat").style.color = '#AD0C0C';					
					document.getElementById("bmiCat").innerHTML = "Severely obese ";
					document.getElementById("bmiCat").style.color = '#AD0C0C';					
					document.getElementById("leprosyBmi").style.color = '#AD0C0C';
					document.getElementById("bmi").style.color = '#AD0C0C';
				}else{
					document.getElementById("leprosyBmiCat").innerHTML = "";
					document.getElementById("bmiCat").innerHTML = "";
				}
				}
				else{
					
					document.getElementById("leprosyBmiCat").innerHTML = "";
					document.getElementById("bmiCat").innerHTML = "";
				}		
		}
	
	/*function displayCollapsibleTabForLabResultDermoLeprosy()
	{
		var div = document.getElementById("labResult");
		if (div.style.display !== "block") {
		   div.style.display = "block";
		}else {
		   div.style.display = "none";
		}
	}*/
	
	function addRowForInvestigationDermotology() {

		var tbl = document.getElementById('investigationGridDermotology');
		var lastRow = tbl.rows.length;
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('hiddenValueDermotology');
		iteration = parseInt(hdb.value) + 1;
		hdb.value = iteration;

		var cellRight1 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'checkbox';
		e0.name = 'chargeRadioDermotology' + iteration;
		e0.id = 'chargeRadioDermotology' + iteration;
		e0.className = 'radioCheck';
		cellRight1.appendChild(e0);

		var e0 = document.createElement('input');
		e0.type = 'hidden';
		e0.name = 'availableStatusDermotology' + iteration;
		e0.id = 'availableStatusDermotology' + iteration;
		e0.size = '20';
		cellRight1.appendChild(e0);

		var e0 = document.createElement('input');
		e0.type = 'hidden';
		e0.name = 'parkInvestigationIdDermotology' + iteration;
		e0.id = 'parkInvestigationIdDermotology' + iteration;
		cellRight1.appendChild(e0);

		
		var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'testDate' + iteration;
		e1.id = 'testDate' + iteration;
		e1.className = "dateTextSmall";
		e1.size = '8';
		e1.value = document.getElementById('testDate').value;
		e1.onblur = function(event) {
			checkTrimDate('testDate' + iteration);
		};
		e1.tabIndex ="1";
		cellRight1.appendChild(e1);
		
		
		var cellRight0 = row.insertCell(2);
		var e0 = document.createElement('input');
		e0.type = 'text';
		e0.name = 'chargeCodeNameDermotology' + iteration;
		e0.id = 'chargeCodeNameDermotology' + iteration;
		e0.onkeypress = function() {
			checkTextColor('chargeCodeNameDermotology' + iteration);
		};
		e0.onblur = function() {
			getUnavailableInvestigation(iteration);
			checkInvestigationItem(iteration);
			getLoincSnomedList(iteration);
			if (validateInvestigationAutoComplete(this.value, iteration)) {
				submitProtoAjaxNew('opdMain',
						"/hms/hms/opd?method=fillChargeCode&hinId="
								+ document.getElementById("hinId").value
								+ "&rowVal=" + iteration, 'chargeCodeVal'
								+ iteration);
			}
		};
		e0.size = '65';
		e0.className = "textYellow largTextBoxOpd";
		cellRight0.appendChild(e0);

		var updatediv = document.createElement('div');
		updatediv.setAttribute('id', 'ac2update' + iteration);
		updatediv.style.display = 'none';
		updatediv.className = "autocomplete";
		cellRight0.appendChild(updatediv);

		new Ajax.Autocompleter('chargeCodeNameDermotology' + iteration, 'ac2update'
				+ iteration, 'opd?method=getInvestigationListForAutoComplete', {
			minChars : 3,
			callback : function(element, entry) {
				return entry + '&labradiologyCheckDermotology='
						+ document.getElementById('investigationCategoryDermotology').value;
			},
			parameters : 'requiredField=chargeCodeNameDermotology' + iteration
					+ '&fromOpd=fromOpd'
		});

		var cellRight3 = row.insertCell(3);
		var e0 = document.createElement('input');
		e0.type = 'text';
		e0.name = 'testResult' + iteration;
		e0.id = 'testResult' + iteration;
		e0.size = '20';
		e0.className = "largTextBoxOpd textYellow";
		cellRight3.appendChild(e0);

		var sel = document.createElement('input');
		sel.type = 'hidden';
		sel.name = 'chargeCodeDermotology' + iteration;
		sel.id = 'chargeCodeDermotology' + iteration;
		sel.size = '15';
		cellRight3.appendChild(sel);
		
	}
	
	function removeRowForInvestigationDermotology() {
		var tbl = document.getElementById('investigationGridDermotology');
		var lastRow = tbl.rows.length;
		var hdb = document.getElementById('hiddenValueDermotology');
		var iteration = parseInt(hdb.value);
		var totalSelected = 0;
		if (confirm("Do you want to delete !")) {
			for (var i = 0; i < iteration; i++) {
				if (document.getElementById("chargeRadioDermotology" + i) != null
						&& (typeof document.getElementById("chargeRadioDermotology" + i).checked) != 'undefined'
						&& document.getElementById("chargeRadioDermotology" + i).checked) {
					totalSelected = totalSelected + 1;
				}
			}
			if (totalSelected == 0) {
				alert('Please select atleast 1 row to delete');
			} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
				alert('You can not delete all Row.');
			} else if (lastRow > 2) {
				for (var i = 0; i < iteration; i++) {
					if (document.getElementById("chargeRadioDermotology" + i) != null
							&& (typeof document.getElementById("chargeRadioDermotology" + i).checked) != 'undefined'
							&& document.getElementById("chargeRadioDermotology" + i).checked) {
						jQuery(function($) {
							var ids = "";
							if (document.getElementById("parkInvestigationIdDermotology" + i) != null) {
								ids = document.getElementById("parkInvestigationIdDermotology"
										+ i).value;
							}

							if (ids != "") {
								$.post("opd?method=deleteOPDdetails&ids=" + ids
										+ "&for=" + "Inv" + "&" + csrfTokenName
										+ "=" + csrfTokenValue, function(data) {
									try {
										flag = 1;
										msgFlag = data;
									} catch (e) {
										alert(e);
									}
								});
							}
						});
						var deleteRow = document.getElementById("chargeRadioDermotology" + i).parentNode.parentNode;
						document.getElementById("chargeRadioDermotology" + i).parentNode.parentNode.parentNode
								.removeChild(deleteRow);
					}
				}
			}
		}

	}
	
	
	
	function displayExtraField(obj,idIdx){
	
		if(obj.type=='checkbox'){
			if(document.getElementById('textValue'+idIdx)){
				if(obj.checked){
					document.getElementById('textValue'+idIdx).style.display = 'block';
	
				}else{
					document.getElementById('textValue'+idIdx).style.display = 'none';
					document.getElementById('textValue'+idIdx).value="";
				}
			}
			
		}else if(obj.type=='radio'){
			if(document.getElementById('validationVal'+idIdx) && document.getElementById('validationVal'+idIdx).value == obj.value){
				if(document.getElementById('textValue'+idIdx)){
					
						document.getElementById('textValue'+idIdx).style.display = 'block';
		
				}
				if(document.getElementById('extraLovId'+idIdx)){
					
					document.getElementById('extraLovId'+idIdx).style.display = 'block';
					
				}
			}else{
				if(document.getElementById('textValue'+idIdx)){
					document.getElementById('textValue'+idIdx).style.display = 'none';
					document.getElementById('textValue'+idIdx).value="";
				}
				else if(document.getElementById('extraLovId'+idIdx)){
					document.getElementById('extraLovId'+idIdx).style.display ='none';
					
					document.getElementById('extraLovId'+idIdx).value="";
				}
			}
		}else if(obj.type=='select-one'){
			
			if(document.getElementById('textValue'+idIdx)){
				if(document.getElementById('validationVal'+idIdx) && document.getElementById('validationVal'+idIdx).value == obj.value){

					document.getElementById('textValue'+idIdx).style.display = 'block';


				}else{
					document.getElementById('textValue'+idIdx).style.display = 'none';
					document.getElementById('textValue'+idIdx).value="";
				}
			}
			if(document.getElementById('stdDiv')){
			if(obj.value == 'Homosexual'){ // change value here
				document.getElementById('stdDiv').style.display = 'block';
				
			}else{
				document.getElementById('stdDiv').style.display = 'none';
			}
			}
		}
	}
  
	function displayWeaknessValue1(val) {
		if (val == 'Yes') {
			document.getElementById('othersValue').style.display = 'block';

		} else {
			document.getElementById('othersValue').style.display = 'none';
			document.getElementById('othersValue').value="";
		}
	}
	
	
	
	
	function checkSpecify11(val) {
		if (val=="Others") {
			document.getElementById('specifyOthers').style.display = 'block';

		}  
		else {
			document.getElementById('specifyOthers').style.display = 'none';
			document.getElementById('specifyOthers').value = '';
		
		}
	}
	function othersCurrent11(val) {
		if (val=="Y") {
			document.getElementById('othersCurrentValue').style.display = 'block';

		}  
		else {
			document.getElementById('othersCurrentValue').style.display = 'none';
			document.getElementById('othersCurrentValue').value = '';
		
		}
	}
	
	function othersPast11(val) {
		if (val=="Y") {
			document.getElementById('othersPastValue').style.display = 'block';

		}  
		else {
			document.getElementById('othersPastValue').style.display = 'none';
			document.getElementById('othersPastValue').value = '';
		
		}
	}
	
	
	function checkEpisodicType(val) {
		if (val!="") {
			document.getElementById('episodicTypeValue').style.display = 'block';

		}  
		else {
			document.getElementById('episodicTypeValue').style.display = 'none';
			document.getElementById('episodicTypeValue').value = '';
		
		}
	}
	

	
	//Added by swarup 05-12-2017 
	function calculateScore(val,val1){
		if(val1==1){
			 document.getElementById("TotalScore").value=val;
		}
		if(val1==2){
			 document.getElementById("TotalScore2").value=val;
		}
		if(val1==3){
			 document.getElementById("TotalScore3").value=val;
		}
		if(val1==4){
			 document.getElementById("TotalScore4").value=val;
		}
		if(val1==5){
			 document.getElementById("TotalScore5").value=val;
		}
		if(val1==6){
			 document.getElementById("TotalScore6").value=val;
		}
		if(val1==7){
			 document.getElementById("TotalScore7").value=val;
		}
		if(val1==8){
			 document.getElementById("TotalScore8").value=val;
		}
		if(val1==9){
			 document.getElementById("TotalScore9").value=val;
		}
		if(val1==10){
			 document.getElementById("TotalScore10").value=val;
		}
		if(val1==11){
			 document.getElementById("TotalScore11").value=val;
		}
		if(val1==12){
			 document.getElementById("TotalScore12").value=val;
		}
		if(val1==13){
			 document.getElementById("TotalScore13").value=val;
		}
		if(val1==14){
			 document.getElementById("TotalScore14").value=val;
		}
		 		
	}
	
	function addRowForInvestigationForOpdLite() {

		var tbl = document.getElementById('investigationGrid');
		var lastRow = tbl.rows.length;
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('hiddenValue');
		iteration = parseInt(hdb.value)+1 ;
		hdb.value = iteration;

		var cellRight1 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'hidden';
		e0.name = 'availableStatus' + iteration;
		e0.id = 'availableStatus' + iteration;
		e0.size = '20';
		cellRight1.appendChild(e0);

		var e0 = document.createElement('input');
		e0.type = 'hidden';
		e0.name = 'parkInvestigationId' + iteration;
		e0.id = 'parkInvestigationId' + iteration;
		cellRight1.appendChild(e0);
		
		var e0 = document.createElement('input');
		e0.type = 'button';
		e0.alt = 'Delete';
		e0.onclick = function() {
			removeRowForOpdLite(this,'investigation');
		};
		e0.className = 'delButSmll';
		e0.id = 'investigationDelete'+iteration;
		cellRight1.appendChild(e0);
		
		var cellRight0 = row.insertCell(1);
		var e0 = document.createElement('input');
		e0.type = 'text';
		e0.name = 'chargeCodeName' + iteration;
		e0.id = 'chargeCodeName' + iteration;
		e0.onkeypress = function() {
			checkTextColor('chargeCodeName' + iteration);
		};
		e0.tabIndex='1';
		e0.onblur = function() {
			getUnavailableInvestigation(iteration);
			checkInvestigationItem(iteration);
			getLoincSnomedList(iteration);
			if (validateInvestigationAutoComplete(this.value, iteration)) {
				submitProtoAjaxNew('opdMain',
						"/hms/hms/opd?method=fillChargeCode&hinId="
								+ document.getElementById("hinId").value
								+ "&rowVal=" + iteration, 'chargeCodeVal'
								+ iteration);
			}
		};
		e0.size = '35';
		e0.style="width:226px;"
		e0.className = "popper chargeCodeName";
		cellRight0.appendChild(e0);

		var updatediv = document.createElement('div');
		updatediv.setAttribute('id', 'ac2update' + iteration);
		updatediv.style.display = 'none';
		updatediv.className = "autocomplete";
		cellRight0.appendChild(updatediv);

		new Ajax.Autocompleter('chargeCodeName' + iteration, 'ac2update'
				+ iteration, 'opd?method=getInvestigationListForAutoComplete', {
			minChars : 3,
			callback : function(element, entry) {
				return entry + '&labradiologyCheck='
						+ document.getElementById('investigationCategory').value;
			},
			parameters : 'requiredField=chargeCodeName' + iteration
					+ '&fromOpd=fromOpd'
		});

		var sel = document.createElement('input');
		sel.type = 'hidden';
		sel.name = 'chargeCode' + iteration;
		sel.id = 'chargeCode' + iteration;
		sel.size = '15';
		cellRight1.appendChild(sel);
		
		var cellRight3 = row.insertCell(2);
		var e0 = document.createElement('input');
		e0.type = 'hidden';
		e0.name = 'clinicalNotes' + iteration;
		e0.id = 'clinicalNotes' + iteration;
		e0.size = '20';
		e0.className = "opdTextBoxSmall textYellow";
		cellRight3.appendChild(e0);

	}
	

	
	function fillValueForOpdLite(value, inc, from) {
	var dosage;
	var freq;
	var dispenseQty;
	var noOfDays;
	var sosQty;
	var unit;
	var mixtuerUnit;
	var mixable;
	var mixtureQuantity;

	setDisablePharmacy();

	dosage = document.getElementById('dosage' + inc).value;
	freq = document.getElementById('frequencyValue' + inc).value;
	dispenseQty = document.getElementById('actualDispensingQty' + inc).value;
	noOfDays = document.getElementById('noOfDays' + inc).value;
	sosQty = document.getElementById('sosQty' + inc).value;
	unit = document.getElementById('unit' + inc).value;

	if (document.getElementById('mixable' + inc) != null) {
		mixable = document.getElementById('mixable' + inc).value;
	}
	if (document.getElementById('mixtureUnit' + inc) != null) {
		mixtureUnit = document.getElementById('mixtureUnit' + inc).value;
	}
	if (document.getElementById('mixtureQuantity' + inc) != null) {
		mixtureQuantity = document.getElementById('mixtureQuantity' + inc).value;
	}

	if (document.getElementById('frequency' + inc).value == 24 && noOfDays > 0) {
		total = noOfDays;
	} else if (freq > 0 && dosage > 0 && noOfDays > 0) {
		total = Math.round(freq * noOfDays * dosage);
	} else {
		total = 0;
	}

	var finalQty = "";
	var actualFinalQty = "";
	if (document.getElementById('frequency' + inc).value != 13) {
		if (document.getElementById('actualDispensingQty' + inc).value != 0) {
			if (mixable == 'Y') {
				actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity))
						* parseFloat(total);
				if (actualFinalQty != '0.00') {
					finalQty = parseFloat(actualFinalQty)
							/ parseFloat(dispenseQty);
				}
				document.getElementById('total' + inc).value = total;
				document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
				document.getElementById('unitLable' + inc).value = mixtureUnit;

			} else {
				var totalQty = (parseFloat(total) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				document.getElementById('total' + inc).value = finalQty;
				
			}
		} else {

			document.getElementById('total' + inc).value = total;

		}
	} else {
		if (document.getElementById('actualDispensingQty' + inc).value != 0) {
			if (diluteable == 'Y') {
				actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity))
						* parseFloat(total);
				if (actualFinalQty != '0.00') {
					finalQty = parseFloat(actualFinalQty)
							/ parseFloat(dispenseQty);
				}
				document.getElementById('total' + inc).value = total;
				document.getElementById('actualTotalAfterMix' + inc).value = finalQty;
				document.getElementById('unitLable' + inc).value = mixtureUnit;

			} else {

				var totalQty = (parseFloat(freq * sosQty * dosage) / parseFloat(dispenseQty))
						.toFixed(2);
				if (totalQty != '0.00') {
					finalQty = freq > 0 ? Math.ceil(totalQty) : "";
				}
				document.getElementById('total' + inc).value = finalQty;
			}
		} else {

			document.getElementById('total' + inc).value = sosQty * freq
					* dosage;
			document.getElementById('totalpTab' + inc).value = sosQty * freq
					* dosage;
		}
	}

}	
	
	
	function addRowForOpdLite() {
		var tbl = document.getElementById('grid');
		var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex').value) + 1;
		document.getElementById('hdbTabIndex').value = hdbTabIndex;

		var lastRow = tbl.rows.length;
		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('hdb');
		iteration = parseInt(hdb.value) + 1;
		hdb.value = iteration;
		
		/*if(document.getElementsByName('hdb')){
			var pHdb =	document.getElementsByName('hdb')[0];
			pHdb.value = iteration;
		}*/
		
		// document.getElementById('pulse').value=hdb.value;

		var cellRight1 = row.insertCell(0);
		var e1 = document.createElement('input');
		e1.type = 'button';
		e1.className = 'delButSmll';
		e1.alt = 'Delete';
		e1.onclick =   function(){
			removeRowForOpdLite(this,'prescription');
		}
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
		e1.className = 'nomenclaturepTab';
		e1.name = 'nomenclaturepTab' + iteration;
		e1.id = 'nomenclature' + iteration;
		e1.onfocus = function() {
			// Commented by Arbind on 31-01-2017
			// checkEnteredDiagnosis();
			checkFrequency(iteration, "opc");
		}
		e1.onkeypress = function() {
			checkTextColor('nomenclature' + iteration);
		};
		e1.onblur = function() {
			checkForAlreadyIssuedPrescribtion(this.value, iteration);
			populatePVMS(this.value, iteration);
			checkItem(iteration);
			//copyToPrescriptionTAb(iteration, 'opconsult');
			ValidateCantra();
			displayAu(this.value, iteration);
			validatePrescriptionAutocomplete('opmain', this.value, iteration);
			checkForAllergy(this.value, iteration);
			checkForBlockedMedicine(this.value, iteration);

		};
		e1.size = '35';
		e1.style = 'width : 146px';
		e1.tabIndex = 1;
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
					callback : function(element, entry) {
						return entry + '&pharmacyCheck='
								+ document.getElementById('pharmacyCategory').value;
					},
					parameters : 'requiredField=nomenclaturepTab' + iteration
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
		e1.name = 'pvmsNopTab' + iteration;
		e1.id = 'pvmsNo' + iteration;
		cellRight1.appendChild(e1);

		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'actualDispensingQty' + iteration;
		e1.id = 'actualDispensingQty' + iteration;
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
		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'alreadyPres' + iteration;
		e1.id = 'alreadyPres' + iteration;
		e1.value = 'N';
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(2);
		var e1 = document.createElement('Select');
		e1.name = 'routepTab' + iteration;
		e1.id = 'route' + iteration;
		e1.style = 'width: 56px; margin-left: 0px !important; background: #FFFF99';
		e1.tabIndex = '1';
		e1.options[0] = new Option('Select', '0');
		for (var i = 0; i < routeArray.length; i++) {
			e1.options[i + 1] = new Option(routeArray[i][1], routeArray[i][0]);
		}
		e1.onblur = function() {
			fillRouteOnTAb(iteration);
		};
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(3);
		var e1 = document.createElement('input');
		e1.name = 'dosagepTab' + iteration;
		e1.id = 'dosage' + iteration;
		e1.className = "textYellow opdTextBoxTSmall";
		e1.onblur = function() {
			fillValue(this.value, iteration);
			checkFrequencyForTaperedDrugs(iteration);
		};
		e1.tabIndex = '1';
		e1.style = 'width: 34px;';
		e1.setAttribute('validate', 'Dosage,num,no');
		e1.maxLength = '4';
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(4);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'unit' + iteration;
		e1.id = 'unit' + iteration;
		e1.className = 'textYellow opdTextBoxTSmall';
		e1.readOnly = 'readOnly';
		e1.tabIndex = 1;
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(5);
		var e1 = document.createElement('Select');
		e1.name = 'frequencypTab' + iteration;
		e1.id = 'frequency' + iteration;
		e1.style = 'width: 56px; margin-left: 0px !important;';
		e1.tabIndex ='1';
		e1.options[0] = new Option('Select', '0');
		for (var i = 0; i < icdArray.length; i++) {
			// this part is added by amit das
			var opt = document.createElement('option');
			opt.id = icdArray[i][2];
			opt.value = icdArray[i][0];
			opt.innerHTML = icdArray[i][1];
			e1.appendChild(opt);
			// e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]); //
			// this part is commented by amit das
		}
		e1.onblur = function() {
			getFrequencyValue(this.value, iteration);
			fillValue(this.value, iteration);
			displaySOSQty(this.value, iteration);
			checkFrequencyForTaperedDrugs(iteration);
		};

		e1.onchange = function() { // added by amit das
			displaFrequencyType(this, iteration);
		};

		cellRight1.appendChild(e1);

		var e21 = document.createElement('input');
		e21.type = 'hidden';
		e21.name = 'sosQty' + iteration;
		e21.id = 'sosQty' + iteration;
		e21.size = '5';
		e21.setAttribute('tabindex', '1');
		cellRight1.appendChild(e21);

		var e21 = document.createElement('input');
		e21.type = 'hidden';
		e21.name = 'frequencyValue' + iteration;
		e21.id = 'frequencyValue' + iteration;
		e21.size = '5';
		e21.setAttribute('tabindex', '1');
		cellRight1.appendChild(e21);

		var cellRight1 = row.insertCell(6);

		var e21Div = document.createElement('div');
		e21Div.style = 'width:63px; float: left;';

		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'noOfDayspTab' + iteration;
		e1.className = "textYellow opdTextBoxTSmall";
		e1.id = 'noOfDays' + iteration;
		e1.size = '2';
		e1.setAttribute('validate', 'No Of Days,num,no');
		e1.maxLength = '3';
		e1.style = 'width: 14px;';
		e1.tabIndex = '1';
		e1.onblur = function() {
			fillValueDays(iteration);
			fillValueForOpdLite(this.value, iteration);
		};
		e21Div.appendChild(e1);

		var ef21 = document.createElement('p');
		ef21.style = 'line-height:0px;';
		ef21.id = 'frequencyType' + iteration;
		e21Div.appendChild(ef21);
		cellRight1.appendChild(e21Div);

		var cellRight1 = row.insertCell(7);
		var e1 = document.createElement('Select');
		e1.name = 'instrunctionpTab' + iteration;
		e1.id = 'instrunction' + iteration;
		e1.style.width = "80px";
		e1.style.background = "#FFFF99";
		e1.tabIndex = '1';
		e1.options[0] = new Option('Select', '0');
		for (var i = 0; i < instructionArray.length; i++) {
			e1.options[i + 1] = new Option(instructionArray[i][1],
					instructionArray[i][0]);
		}
		e1.onblur = function() {
			fillInstrunctionOnTAb(iteration);
		};
		cellRight1.appendChild(e1);

		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'total' + iteration;
		e1.id = 'total' + iteration;
		e1.size = '5';
		cellRight1.appendChild(e1);
		
		 var cellRight1 = row.insertCell(8);
		  var e1 = document.createElement('input');
		  e1.type = 'checkbox';
		  e1.name='ct'+iteration;
		  e1.id='ct'+iteration
		  e1.size='10';
		  e1.className='radio';
		  e1.value='y';
		  e1.setAttribute('tabindex','1');
		 cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(9);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'splInstrunction' + iteration;
		e1.id = 'splInstrunction' + iteration;
		e1.tabIndex = '1';
		e1.className = "textYellow opdTextBoxSmall";
		e1.style.width="60px";
		e1.setAttribute('validate', 'Remarks,string,no');
		e1.maxLength = '100';
		e1.onblur = function() {
			fillSPLInstrunctionOnPTAb(iteration);
		};
		e1.size = '5';
		cellRight1.appendChild(e1);
	}
	
	
	function addRowTreatmentNursingCareOpdLite() {

		var tbl = document.getElementById('gridNursing');
		var lastRow = tbl.rows.length;

		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('nursinghdb');
		iteration = parseInt(hdb.value) + 1;
		hdb.value = iteration;

		var cellRight1 = row.insertCell(0);
		/*var e1 = document.createElement('input');
		e1.type = 'checkbox';
		e1.name = 'nursingRadio' + iteration;
		e1.id = 'nursingRadio' + iteration;
		e1.className = 'radioCheck';
		cellRight1.appendChild(e1);*/

		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'procedureDetailId' + iteration;
		e1.id = 'procedureDetailId' + iteration;
		e1.size = '1';
		cellRight1.appendChild(e1);
		
		var e1 = document.createElement('input');
		e1.type = 'button';
		e1.className = 'delButSmll';
		e1.alt = 'Delete';
		e1.onclick =   function(){
			removeRowForOpdLite(this,'procedure');
		}
		cellRight1.appendChild(e1);
		

		var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.className = 'procedure';
		e1.name = 'procedureName_nursing' + iteration;
		e1.id = 'procedureName_nursing' + iteration;
		e1.style= 'width:180px';
		e1.size = '35';
		e1.tabIndex='1';
		e1.onblur = function chkProcedure() {
			validatePrescriptionAutocomplete('opNursingProc', document
					.getElementById('procedureName_nursing' + iteration).value,
					iteration);
		}

		cellRight1.appendChild(e1);
		var newdiv = document.createElement('div');
		newdiv.setAttribute('id', 'ac2updates_nursing' + iteration);
		newdiv.style.display = 'none';
		newdiv.className = "autocomplete";
		cellRight1.appendChild(newdiv);
		new Ajax.Autocompleter('procedureName_nursing' + iteration,
				'ac2updates_nursing' + iteration,
				'opd?method=getNursingCareProcedureAutoList&minor_major=1', {
					minChars : 3,
					callback : function(element, entry) {
						return entry;
					},
					parameters : 'requiredField=procedureName_nursing' + iteration
				});

		var cellRight2 = row.insertCell(2);
		var e1 = document.createElement('Select');
		e1.style = 'width:80px;';
		e1.name = 'frequency_nursing' + iteration;
		e1.tabIndex='1';
		e1.id = 'frequency_nursing' + iteration;
		e1.options[0] = new Option('Select', '0');
		for (var i = 0; i < icdArray.length; i++) {
			e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]);
		}
		cellRight2.appendChild(e1);

		var cellRight3 = row.insertCell(3);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'noOfDays_nursing' + iteration;
		e1.className = "textSmall";
		e1.id = 'noOfDays_nursing' + iteration;
		e1.style='width:50px;';
		e1.tabIndex='1';
		e1.setAttribute('validate', 'No Of Days,num,no');
		e1.maxLength = '3';
		e1.size = '5';
		cellRight3.appendChild(e1);

		var cellRight4 = row.insertCell(4);
		var e1 = document.createElement('input');
		e1.name = 'remark_nursing' + iteration;
		e1.id = 'remark_nursing' + iteration;
		e1.style= 'width:164px;'; 
		e1.tabIndex='1';
		e1.setAttribute('validate', 'Remarks,string,no');
		e1.maxLength = '100';
		cellRight4.appendChild(e1);

	}

	function addRowTreatmentSurgeryOpdLite() {

		var tbl = document.getElementById('gridSurgery');
		var lastRow = tbl.rows.length;

		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('surgeryhdb');
		iteration = parseInt(hdb.value) + 1;
		hdb.value = iteration;

		var cellRight1 = row.insertCell(0);
				var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'surgeryDetailsId' + iteration;
		e1.id = 'surgeryDetailsId' + iteration;
		cellRight1.appendChild(e1);

		var e1 = document.createElement('input');
		e1.type = 'button';
		e1.className = 'delButSmll';
		e1.alt = 'Delete';
		e1.onclick =   function(){
			removeRowForOpdLite(this,'surgery');
		}
		cellRight1.appendChild(e1);
		
		var cellRight2 = row.insertCell(1);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.className = 'surgery';
		e1.name = 'procedureName_surgery' + iteration;
		e1.tabIndex='1';
		e1.id = 'procedureName_surgery' + iteration;
		e1.style='width:190px;';
		e1.onkeypress = function() {
			selectSNOMEDCT('ACTIVE', 'PROCEDURE', 'ALL', returnlimit_IN,
					callbck_index, 'procedureName_surgery' + iteration);
		};
		e1.onblur = function() {
			checkMappedCharge(this.value, iteration);
		};
		e1.size = '35';
		cellRight2.appendChild(e1);

		/*
		 * var newdiv = document.createElement('div'); newdiv.setAttribute('id',
		 * 'ac2updates_surgery'+iteration); newdiv.style.display = 'none';
		 * newdiv.className = "autocomplete textYellow";
		 * cellRight1.appendChild(newdiv); new
		 * Ajax.Autocompleter('procedureName_surgery'+iteration,'ac2updates_surgery'+iteration,'opd?method=getNursingCareProcedureAutoList',{minChars:3,
		 * callback: function(element, entry) { return entry + '&minor_major=2'; },
		 * parameters:'requiredField=procedureName_surgery'+iteration});
		 */
		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'surgery_code_id' + iteration;
		e1.id = 'surgery_code_id' + iteration;
		cellRight2.appendChild(e1);

		var cellRight3 = row.insertCell(2);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name = 'tentativeDate' + iteration;
		e1.id = 'tentativeDate' + iteration;
		e1.size = '5';
		e1.value = "";
		e1.className = 'small';
		e1.readOnly = true;
		e1.width='16';
		e1.height='16';
		cellRight3.appendChild(e1);

		var img1 = document.createElement('img');
		img1.src = '/hms/jsp/images/cal.gif';
		img1.onclick = function(event) {
			var obj = document.getElementById('tentativeDate' + iteration);
			setdate(document.createElement('consultationDate').value, obj, event);
			checkTentativeDates(iteration);
		};
		img1.tabIndex='1';
		cellRight3.appendChild(img1);

		var cellRight4 = row.insertCell(3);
		var e1 = document.createElement('input');
		e1.name = 'remark_surgery' + iteration;
		e1.id = 'remark_surgery' + iteration;
		e1.style = 'width: 198px;';
		e1.tabIndex='1';
		e1.setAttribute('validate', 'Remarks,string,no');
		e1.maxLength ='200';
		cellRight4.appendChild(e1);
		
		var cellRight5 = row.insertCell(4);
		var e1 = document.createElement('input');
		e1.type="checkbox";
		e1.name = 'chkpacNeed' + iteration;
		e1.id = 'chkpacNeed' + iteration;
		e1.tabIndex='1';
		//e1.style = 'width: 205px;';
		e1.onchange=function(){
			pacRequesting(iteration);
		};
		cellRight5.appendChild(e1);
		
	}

	
	function removeRowForOpdLite(i,boxtype,flag) {
		var rowCounter ;
		
		if(boxtype=='investigation'){
			rowCounter = document.getElementsByClassName('chargeCodeName').length;
		}else if(boxtype=='prescription'){
			rowCounter = document.getElementsByClassName('nomenclaturepTab').length;
		} else if(boxtype=='procedure'){
			rowCounter = document.getElementsByClassName('procedure').length;
		} else if(boxtype=='surgery'){
			rowCounter = document.getElementsByClassName('surgery').length;
		}else if(boxtype=='allergy'){
			rowCounter = document.getElementsByClassName('allergy').length;
		}
		
		if(rowCounter>1){
			
			if(flag && flag=='template'){
				var toBeDeletedInvestigation	=		i.parentNode.nextElementSibling.children[0].value;
				var deleteRow 					= 		i.parentNode.parentNode;
				i.parentNode.parentNode.parentNode.removeChild(deleteRow);
				
				if(boxtype=='prescription'){
					setDisablePharmacy();
				}
				
				if(boxtype=='investigation'){
					uncheckFixedInvestigation(toBeDeletedInvestigation);
				}
			} else if (confirm("Do you want to delete !")) {
				var toBeDeletedInvestigation	=		i.parentNode.nextElementSibling.children[0].value;
				var deleteRow 					= 		i.parentNode.parentNode;
				i.parentNode.parentNode.parentNode.removeChild(deleteRow);
				
				if(boxtype=='prescription'){
					setDisablePharmacy();
				}
				
				if(boxtype=='investigation'){
					uncheckFixedInvestigation(toBeDeletedInvestigation);
				}
			}
		}else{
			alert("You can not delete all rows !")
		}
		
	}
	
	function uncheckFixedInvestigation(selectedInvestigation){
		var fixedInvestigations = document.getElementsByName('fixedInvestigation');
		for(var i=0;i<fixedInvestigations.length;i++){
			if(selectedInvestigation == fixedInvestigations[i].value){
				fixedInvestigations[i].checked = false;
			}
		}
	}
	
	function displayCollapsibleTabForLabResultDermoLeprosy(val)
	{
	  if(val=='Lab Result Leprosy'){
		var div = document.getElementById("labResultLeprosy");
		if (div.style.display !== "block") {
		   div.style.display = "block";
		   document.getElementById("labResultLeprosyId").value="-"
		}else {
		   div.style.display = "none";
		   document.getElementById("labResultLeprosyId").value="+"
		}
	 }
	}	
	
	function displayCollapsibleTabForLabResultDermotelogy(val)
	{
		if(val=='Lab Result Vesiculo'){
				var div = document.getElementById("labResultVesiculo");
			if (div.style.display !== "block") {
			   div.style.display = "block";
			}
			else {
			   div.style.display = "none";
			}
		}else if(val=='Lab Result STD'){
			var div = document.getElementById("labResultStd");
			if (div.style.display !== "block") {
			   div.style.display = "block";
			}
			else {
			   div.style.display = "none";
			}
			
		}
	}
		
		
		
	
	
	function displayFamilyHistoryLeprosyOther(val) {
	var compareVal=document.getElementById('relation' + val).value;
		if (compareVal == "Others") {
			document.getElementById('familyHistoryLeprosyOthers' + val).style.display = 'block';	
		
		} else {
			document.getElementById('familyHistoryLeprosyOthers' + val).style.display = 'none';

		}
	}
	
	function showPatientDetailsForOPDLite(hinNo, csrf) {
		var visitId = document.getElementById("visitId").value;
		var deptId = document.getElementById("deptId").value;
		var url = '/hms/hms/opd?method=showPatientDetailOPDLite&hinNo=' + hinNo
				+ '&visitId=' + visitId + '&deptId=' + deptId + '&' + csrf + '&' + csrfTokenName + '='
				+ csrfTokenValue;
		newwindow = window
				.open(url, 'opd_window',
						"left=100,top=10,height=630,width=1330,status=1,scrollbars=yes,resizable=0");

	}
	
	function showHideTestBox(val,destVal)
	{
		if(val == 'Absent')
			{
			document.getElementById(destVal).style.display = 'none';	
			}
		else{
			document.getElementById(destVal).style.display = 'block';
		}
			
	}
	
	function entShowDiv(val,destVal){
		if(val == 'Perforation')
		{
			document.getElementById("parseFlaccidaValueRight").style.display = 'none';
			document.getElementById("rightParseTensa").style.display = 'none';	
			document.getElementById('rightDischarge').style.display = 'none';
			document.getElementById('marginalValueRight').style.display = 'none';
			document.getElementById('rightMiddleEarMucosa').style.display = 'none';
			document.getElementById('rightCentral').style.display = 'none';
		    document.getElementById(destVal).style.display = 'block';	
		}
		else{
		document.getElementById(destVal).style.display = 'none';
		
		document.getElementById('tympanicRightPerforation').style.display = 'none';
		document.getElementById('tympanicRightPerforation').value = "";
		document.getElementById('rightParseTensa').style.display = 'none';
		document.getElementById('rightParseTensa').value = "";
		document.getElementById('rightDischarge').value = "";
		document.getElementById('marginalValueRight').value = "";
		document.getElementById('rightMiddleEarMucosa').value = "";
		document.getElementById('rightDischarge').style.display = 'none';
		document.getElementById('marginalValueRight').style.display = 'none';
		document.getElementById('rightMiddleEarMucosa').style.display = 'none';
		document.getElementById('rightMiddleEarMucosa').value = "";
		document.getElementById('rightCentral').style.display = 'none';
		document.getElementById('rightCentral').value = "";
		document.getElementById('parseFlaccidaValueRight').style.display = 'none';
		document.getElementById('parseFlaccidaValueRight').value = "";
		}
	
	}
	
	
	function entShowDivLeft(val,destVal){
		if(val == 'Perforation')
		{
			document.getElementById("parseFlaccidaValueLeft").style.display = 'none';
			document.getElementById("leftParseTensa").style.display = 'none';	
			document.getElementById('leftDischarge').style.display = 'none';
			document.getElementById('marginalValueLeft').style.display = 'none';
			document.getElementById('leftMiddleEarMucosa').style.display = 'none';
			document.getElementById('leftCentral').style.display = 'none';
		    document.getElementById(destVal).style.display = 'block';	
		}
		else{
			document.getElementById('tympanicLeftPerforation').style.display = 'none';
			document.getElementById('tympanicLeftPerforation').value = "";
			document.getElementById('leftParseTensa').style.display = 'none';
			document.getElementById('leftParseTensa').value = "";
			document.getElementById('leftMiddleEarMucosa').value = "";
			document.getElementById('leftCentral').value = "";
			
			document.getElementById('leftDischarge').style.display = 'none';
			document.getElementById('leftMiddleEarMucosa').style.display = 'none';
			document.getElementById('leftMiddleEarMucosa').value = "";
			document.getElementById('leftCentral').style.display = 'none';
			document.getElementById('leftCentral').value = "";
			document.getElementById('marginalValueLeft').style.display = 'none';
			document.getElementById('marginalValueLeft').value = "";
			document.getElementById('parseFlaccidaValueLeft').style.display = 'none';
			document.getElementById('parseFlaccidaValueLeft').value = "";
		}
	
	}
	
	
	function entShowparseFlaccidaValue(val,destVal,destVal1){
		if(val == 'Pars Flaccida')
		{
		document.getElementById('rightMiddleEarMucosa').style.display = 'none';	
		document.getElementById('marginalValueRight').style.display = 'none';	
		document.getElementById('rightCentral').style.display = 'none';	
		document.getElementById('rightDischarge').style.display = 'none';
		document.getElementById(destVal).style.display = 'none';
		document.getElementById(destVal1).style.display = 'block';	
		} 
		if(val == 'Pars Tensa')
		{ 
			document.getElementById(destVal).style.display = 'block';	
			document.getElementById(destVal1).style.display = 'none';		
			document.getElementById('parseFlaccidaValueRight').style.display = 'none';
			
		}
		}
	
	
	function entShowparseFlaccidaValueLeft(val,destVal,destVal1){
		if(val == 'Pars Flaccida')
		{
		document.getElementById('leftMiddleEarMucosa').style.display = 'none';	
		document.getElementById('marginalValueLeft').style.display = 'none';	
		document.getElementById('leftCentral').style.display = 'none';	
		document.getElementById('leftDischarge').style.display = 'none';
		document.getElementById(destVal).style.display = 'none';
		document.getElementById(destVal1).style.display = 'block';	
		} 
		if(val == 'Pars Tensa')
		{ 
			document.getElementById(destVal).style.display = 'block';	
			document.getElementById(destVal1).style.display = 'none';		
			document.getElementById('parseFlaccidaValueLeft').style.display = 'none';
			
		}
		if(val == 'Discharge'){
			document.getElementById('marginalValueLeft').value = "";
			document.getElementById('leftMiddleEarMucosa').value = "";
			document.getElementById('leftCentral').value = "";
			
			document.getElementById('marginalValueLeft').style.display = 'none';
			document.getElementById('leftMiddleEarMucosa').style.display = 'none';
			document.getElementById('leftCentral').style.display = 'none';
			document.getElementById('leftDischarge').style.display = 'block';
	    }
		}
		
	
	function entShowparseTensaValue(val){
		if(val == 'Central'){
			
			document.getElementById('rightDischarge').value = "";
			document.getElementById('marginalValueRight').value = "";
			document.getElementById('rightMiddleEarMucosa').value = "";
			
			document.getElementById('rightDischarge').style.display = 'none';
			document.getElementById('marginalValueRight').style.display = 'none';
			document.getElementById('rightMiddleEarMucosa').style.display = 'none';
			
			document.getElementById('rightCentral').style.display = 'block';
		} 
		if(val == 'Marginal'){
			document.getElementById('rightDischarge').value = "";
			document.getElementById('rightMiddleEarMucosa').value = "";
			document.getElementById('rightCentral').value = "";
			
			document.getElementById('rightDischarge').style.display = 'none';
			document.getElementById('rightMiddleEarMucosa').style.display = 'none';
			document.getElementById('rightCentral').style.display = 'none';
			document.getElementById('marginalValueRight').style.display = 'block';
		}
		if(val == 'Middle Ear Mucosa'){
			
			document.getElementById('rightDischarge').value = "";
			document.getElementById('marginalValueRight').value = "";
			document.getElementById('rightCentral').value = "";
			
			document.getElementById('rightDischarge').style.display = 'none';
			document.getElementById('marginalValueRight').style.display = 'none';
			document.getElementById('rightCentral').style.display = 'none';
			document.getElementById('rightMiddleEarMucosa').style.display = 'block';
		}
		if(val == 'Discharge'){
			document.getElementById('marginalValueRight').value = "";
			document.getElementById('rightMiddleEarMucosa').value = "";
			document.getElementById('rightCentral').value = "";
			
			document.getElementById('marginalValueRight').style.display = 'none';
			document.getElementById('rightMiddleEarMucosa').style.display = 'none';
			document.getElementById('rightCentral').style.display = 'none';
			document.getElementById('rightDischarge').style.display = 'block';
	    }
			
		}
		
	
	function entShowparseTensaValueLeft(val){
			if(val == 'Central'){
			
			document.getElementById('leftDischarge').value = "";
			document.getElementById('marginalValueLeft').value = "";
			document.getElementById('leftMiddleEarMucosa').value = "";
			
			document.getElementById('leftDischarge').style.display = 'none';
			document.getElementById('marginalValueLeft').style.display = 'none';
			document.getElementById('leftMiddleEarMucosa').style.display = 'none';
			
			document.getElementById('leftCentral').style.display = 'block';
		} 
		if(val == 'Marginal'){
			document.getElementById('leftDischarge').value = "";
			document.getElementById('leftMiddleEarMucosa').value = "";
			document.getElementById('leftCentral').value = "";
			
			document.getElementById('leftDischarge').style.display = 'none';
			document.getElementById('leftMiddleEarMucosa').style.display = 'none';
			document.getElementById('leftCentral').style.display = 'none';
			document.getElementById('marginalValueLeft').style.display = 'block';
		}
		if(val == 'Middle Ear Mucosa'){
			
			document.getElementById('leftDischarge').value = "";
			document.getElementById('marginalValueRight').value = "";
			document.getElementById('leftCentral').value = "";
			
			document.getElementById('leftDischarge').style.display = 'none';
			document.getElementById('leftCentral').style.display = 'none';
			document.getElementById('leftMiddleEarMucosa').style.display = 'block';
		}
		if(val == 'Discharge'){
			document.getElementById('marginalValueLeft').value = "";
			document.getElementById('leftMiddleEarMucosa').value = "";
			document.getElementById('leftCentral').value = "";
			
			document.getElementById('marginalValueLeft').style.display = 'none';
			document.getElementById('leftMiddleEarMucosa').style.display = 'none';
			document.getElementById('leftCentral').style.display = 'none';
			document.getElementById('leftDischarge').style.display = 'block';
	    }
		}
	
	function entDisplayRinneValue(val,destVal) {
		if (val == 'Other') {
			document.getElementById(destVal).style.display = 'block';

		} else {
			document.getElementById(destVal).style.display = 'none';

		}
	}
	
	function validateInvestigationAutoCompleteOpdLite(strValue, inc,investigationIdnName) {

		var chargeCode;
		var fixedInvestigations;
		if(investigationIdnName)
			strValue = investigationIdnName.value;
		
		var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		
		var id = strValue.substring(index1, index2);
		var count = document.getElementById('hiddenValue').value;

		if (id == "") {
			document.getElementById('chargeCodeName' + inc).value = "";
			return;
		}

		for (var i = 0; i <= count; i++) {
			chargeCode = 	document.getElementById('chargeCodeName' + i);
			if (chargeCode != null){
			if(chargeCode.value == strValue && i!=inc)
			{
				alert('This Investigation is already selected.');
				if(document.getElementById('chargeCodeName' + inc))
					document.getElementById('chargeCodeName' + inc).value = "";
				if(investigationIdnName)
					investigationIdnName.checked = false;
					
				return false;
			}
		}
		}
		
		fixedInvestigations = document.getElementsByName('fixedInvestigation');
		count = fixedInvestigations.length;
		for (var i = 0; i < count; i++) {
			chargeCode = 	fixedInvestigations[i];
			if (chargeCode.checked){
				if (chargeCode.value == strValue && investigationIdnName!=chargeCode){
					alert('This Investigation is already selected.');
					chargeCode.checked = false;
					return false;
				}
			}
		}
	  
		return true;
	}
	
	function maxDigitAllowed(obj,max)
	{
		if(parseInt(obj.value)==0 || parseInt(obj.value)> parseInt(max))
			{
			document.getElementById(obj.id).value="";
			alert("Value should be between 1 and "+max);
			return false;
			}
		return true;
	}
	
	function symptomsOtherVal(symptomsOtherValue,inc) {
		if (symptomsOtherValue=="Others") {
			document.getElementById('showsymptomsOthersDiv'+inc).style.display = 'inline';
		} else {
			document.getElementById('showsymptomsOthersDiv'+inc).style.display = 'none';
		}
	}
	function immunizationRoutineValue(immunizationRoutineVal) {
		if (immunizationRoutineVal=="Partial") {
			document.getElementById('partialValueDiv').style.display = 'inline';
		} else {
			document.getElementById('partialValueDiv').style.display = 'none';
		}
	}
		function shapeValueDisplay(shapeVal) {
			if (shapeVal=="Abnormal") {
				document.getElementById('shapeValueDiv').style.display = 'inline';
			} else {
				document.getElementById('shapeValueDiv').style.display = 'none';
			}
		}		
			function breathSoundsDisaply(breathSoundsVal) {
				if (breathSoundsVal=="Abnormal") {
					document.getElementById('breathSoundsValDiv').style.display = 'inline';
				} else {
					document.getElementById('breathSoundsValDiv').style.display = 'none';
				}
	}	
	
			
			function displayTotalScore(val) {
				var num=0;
				

					if (document.getElementById('alcohol').value == '1-absent or false') {
						
						num=(num)+1;
						
					} 
					if (document.getElementById('alcohol').value == '2-Subthreshold') {
						num=num+2;
						
						
					}
					
					if (document.getElementById('alcohol').value == '3-Threshold or true') {
						num=num+3;
						
					}
					

					if (document.getElementById('persistent').value  == '1-absent or false') {
						num=num+1;
						
					} 
					if (document.getElementById('persistent').value == '2-Subthreshold') {
						num=num+2;
					}
					
					if (document.getElementById('persistent').value == '3-Threshold or true') {
						num=num+3;
					}
				
					if (document.getElementById('greatDeal').value == '1-absent or false') {
						num=num+1;
						
					} 
					if (document.getElementById('greatDeal').value == '2-Subthreshold') {
						num=num+2;
					}
					
					if (document.getElementById('greatDeal').value == '3-Threshold or true') {
						num=num+3;
					}
				
					if (document.getElementById('craving').value == '1-absent or false') {
						num=num+1;
						
					} 
					if (document.getElementById('craving').value == '2-Subthreshold') {
						num=num+2;
					}
					
					if (document.getElementById('craving').value == '3-Threshold or true') {
						num=num+3;
					}
				
					if (document.getElementById('recurrent').value == '1-absent or false') {
						num=num+1;
						
					} 
					if (document.getElementById('recurrent').value == '2-Subthreshold') {
						num=num+2;
					}
					
					if (document.getElementById('recurrent').value == '3-Threshold or true') {
						num=num+3;
					}
					
				
					if (document.getElementById('continued').value == '1-absent or false') {
						num=num+1;
						
					} 
					if (document.getElementById('continued').value == '2-Subthreshold') {
						num=num+2;
					}
					
					if (document.getElementById('continued').value == '3-Threshold or true') {
						num=num+3;
					}
				
					if (document.getElementById('important').value == '1-absent or false') {
						num=num+1;
						
					} 
					if (document.getElementById('important').value == '2-Subthreshold') {
						num=num+2;
					}
					
					if (document.getElementById('important').value == '3-Threshold or true') {
						num=num+3;
					}
				
					if (document.getElementById('recurrentAlcohol').value == '1-absent or false') {
						num=num+1;
						
					} 
					if (document.getElementById('recurrentAlcohol').value == '2-Subthreshold') {
						num=num+2;
					}
					
					if (document.getElementById('recurrentAlcohol').value == '3-Threshold or true') {
						num=num+3;
					}
				
				
					if (document.getElementById('alcoholUse').value == '1-absent or false') {
						num=num+1;
						
					} 
					if (document.getElementById('alcoholUse').value == '2-Subthreshold') {
						num=num+2;
					}
					
					if (document.getElementById('alcoholUse').value == '3-Threshold or true') {
						num=num+3;
					}
				
				
					if (document.getElementById('tolerance').value == '1-absent or false') {
						num=num+1;
						
					} 
					if (document.getElementById('tolerance').value == '2-Subthreshold') {
						num=num+2;
					}
					
					if (document.getElementById('tolerance').value == '3-Threshold or true') {
						num=num+3;
					}
				
					if (document.getElementById('withdrawal').value == '1-absent or false') {
						num=num+1;
						
					} 
					if (document.getElementById('withdrawal').value == '2-Subthreshold') {
						num=num+2;
					}
					
					if (document.getElementById('withdrawal').value == '3-Threshold or true') {
						num=num+3;
					}

				document.getElementById("totalSource").value=num;
					

			}
	
	
	/*======Inner Tab function Aanand=====*/
	function openCity(evt, cityName) {		
	    var i, tabcontent, tablinks;
	    tabcontent = document.getElementsByClassName("inTabcontent");
	    for (i = 0; i < tabcontent.length; i++) {
	        tabcontent[i].style.display = "none";
	    }
	    tablinks = document.getElementsByClassName("tablinks");
	    for (i = 0; i < tablinks.length; i++) {
	        tablinks[i].className = tablinks[i].className.replace("inActive", "");
	    }
	    document.getElementById(cityName).style.display = "block";
	    evt.currentTarget.className += " inActive"; 	   
	}
	
	
	function addRowForOpdLiteAllergy() {
		var tbl = document.getElementById('alergyGrid');
		var lastRow = tbl.rows.length;
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('allergyCount');
		iteration = parseInt(hdb.value) + 1;
		hdb.value = iteration;

		var cellRight1 = row.insertCell(0);
		var e1 = document.createElement('input');
		e1.type = 'button';
		e1.className = 'delButSmll allergy';
		e1.alt = 'Delete';
		e1.onclick =   function(){
			removeRowForOpdLite(this,'allergy');
		}
		cellRight1.appendChild(e1);
		
		
		var e1 = document.createElement('input');
		e1.type = 'hidden';
		e1.name = 'allergyDetailId' + iteration;
		e1.id = 'allergyDetailId' + iteration;
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('Select');
		e1.name = 'allergyType' + iteration;
		e1.id = 'allergyType' + iteration;
		e1.style.background = "#FFFF99";
		e1.style.width = "62px";
		e1.tabIndex = "1";
		e1.options[0] = new Option('Select', '0');
		for (var i = 0; i < allergyTypeArray.length; i++) {
			e1.options[i + 1] = new Option(allergyTypeArray[i][1],
					allergyTypeArray[i][0]);
		}

		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(2);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.tabIndex = "1";
		e1.className = 'allergy';
		e1.name = 'allergyName' + iteration;
		e1.id = 'allergyName' + iteration;
		e1.setAttribute("validate",'Allergy,string,no');
		e1.className = "largTextBoxOpd textYellow historyAutoComplete ui-autocomplete-input";
		e1.onkeypress = function() {
			selectSNOMEDCT('ACTIVE', 'DISORDER', 'ALL', returnlimit_IN,
					callbck_index, 'allergyName' + iteration);
		};
		e1.maxLength = "60";
		e1.size = '20'
		e1.style.width = '68px';	
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(3);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.tabIndex = "1";
		e1.name = 'allergy_remarks' + iteration;
		e1.id = 'allergy_remarks' + iteration;
		e1.className = "small textYellow";
		e1.setAttribute('validate', 'Allergy Remark,string,no');
		e1.maxLength = "30";
		cellRight1.appendChild(e1);
		
	}
	
	
	function toogleFixedInvestigationToList(i){
		var investigationNameAndId =  i.value;
		var investigationCounterElement = document.getElementById('hiddenValue');
		var investigationCounter = investigationCounterElement.value;
		var investigationInList ;
		var datafilled = false;
		if(i.checked){
			for(var j=0; j<=investigationCounter; j++){
				if(document.getElementById('chargeCodeName'+j)){
				investigationInList = document.getElementById('chargeCodeName'+j);
				if(investigationInList){
				if(investigationInList.value.trim() != ''){
					if(investigationInList.value ==  investigationNameAndId){
						alert('Test is already selected !');
						i.checked = false;
						return false;
					}
				}else{
					investigationInList.value = investigationNameAndId;
					datafilled = true;
					investigationInList.onblur();
					return true;
				}
				}
			}
			}
			if(!datafilled){
				addRowForInvestigationForOpdLiteOther();
				
				investigationInList = document.getElementById('chargeCodeName'+j);
				investigationInList.value = investigationNameAndId;
				investigationInList.onblur();
			}
		}else{
			for(var j=0; j<=investigationCounter; j++){
				if(document.getElementById('chargeCodeName'+j)){
				investigationInList = document.getElementById('chargeCodeName'+j);
				if(investigationInList){
				if((investigationInList.value) && (investigationInList.value ==  investigationNameAndId)){
					addRowForInvestigationForOpdLite();
					removeRowForOpdLite(document.getElementById('investigationDelete'+j), 'investigation');
					return true;
				}
				}
			  }
			}
		}	
	}
	
	 function displayMultipleSelection(obj,cnt){
			var multiSelectionValue="";
				for(var i = 1; i <=obj.length; i++){
					if(obj[i].selected != ""){
						multiSelectionValue +=  obj[i].value  +', ';
					  	
					 }
					document.getElementById('multiSelectText'+cnt).value = multiSelectionValue;
					}
				}
	function displayTotalScoreNicu(val) {
		var num=0;
		var nums=0;
		
				if(document.getElementById('posture1').checked)
					num=num+parseInt(document.getElementById('posture1').value);
				if(document.getElementById('posture2').checked)
					num=num+parseInt(document.getElementById('posture2').value);
				if(document.getElementById('posture3').checked)
					num=num+parseInt(document.getElementById('posture3').value);
				if(document.getElementById('posture4').checked)
					num=num+parseInt(document.getElementById('posture4').value);
				
			
				
				if(document.getElementById('squareWindow1').checked)
					num=num+parseInt(document.getElementById('squareWindow1').value);
				if(document.getElementById('squareWindow2').checked)
					num=num+parseInt(document.getElementById('squareWindow2').value);
				if(document.getElementById('squareWindow3').checked)
					num=num+parseInt(document.getElementById('squareWindow3').value);
				if(document.getElementById('squareWindow4').checked)
					num=num+parseInt(document.getElementById('squareWindow4').value);
				if(document.getElementById('squareWindow5').checked)
					num=num+parseInt(document.getElementById('squareWindow5').value);
				if(document.getElementById('squareWindow6').checked)
					num=num+parseInt(document.getElementById('squareWindow6').value);
				
	
				
				if(document.getElementById('armRecoil1').checked)
					num=num+parseInt(document.getElementById('armRecoil1').value);
				if(document.getElementById('armRecoil2').checked)
					num=num+parseInt(document.getElementById('armRecoil2').value);
				if(document.getElementById('armRecoil3').checked)
					num=num+parseInt(document.getElementById('armRecoil3').value);
				if(document.getElementById('armRecoil4').checked)
					num=num+parseInt(document.getElementById('armRecoil4').value);
				if(document.getElementById('armRecoil5').checked)
					num=num+parseInt(document.getElementById('armRecoil5').value);
				
				
				
				if(document.getElementById('poplitcalAngle1').checked)
					num=num+parseInt(document.getElementById('poplitcalAngle1').value);
				if(document.getElementById('poplitcalAngle2').checked)
					num=num+parseInt(document.getElementById('poplitcalAngle2').value);
				if(document.getElementById('poplitcalAngle3').checked)
					num=num+parseInt(document.getElementById('poplitcalAngle3').value);
				if(document.getElementById('poplitcalAngle4').checked)
					num=num+parseInt(document.getElementById('poplitcalAngle4').value);
				if(document.getElementById('poplitcalAngle5').checked)
					num=num+parseInt(document.getElementById('poplitcalAngle5').value);
				if(document.getElementById('poplitcalAngle6').checked)
					num=num+parseInt(document.getElementById('poplitcalAngle6').value);
				if(document.getElementById('poplitcalAngle7').checked)
					num=num+parseInt(document.getElementById('poplitcalAngle7').value);
				
				
				if(document.getElementById('scarfSign1').checked)
					num=num+parseInt(document.getElementById('scarfSign1').value);
				if(document.getElementById('scarfSign2').checked)
					num=num+parseInt(document.getElementById('scarfSign2').value);
				if(document.getElementById('scarfSign3').checked)
					num=num+parseInt(document.getElementById('scarfSign3').value);
				if(document.getElementById('scarfSign4').checked)
					num=num+parseInt(document.getElementById('scarfSign4').value);
				if(document.getElementById('scarfSign5').checked)
					num=num+parseInt(document.getElementById('scarfSign5').value);
				if(document.getElementById('scarfSign6').checked)
					num=num+parseInt(document.getElementById('scarfSign6').value);
				
				if(document.getElementById('heelToEar1').checked)
					num=num+parseInt(document.getElementById('heelToEar1').value);
				if(document.getElementById('heelToEar2').checked)
					num=num+parseInt(document.getElementById('heelToEar2').value);
				if(document.getElementById('heelToEar3').checked)
					num=num+parseInt(document.getElementById('heelToEar3').value);
				if(document.getElementById('heelToEar4').checked)
					num=num+parseInt(document.getElementById('heelToEar4').value);
				if(document.getElementById('heelToEar5').checked)
					num=num+parseInt(document.getElementById('heelToEar5').value);
				if(document.getElementById('heelToEar6').checked)
					num=num+parseInt(document.getElementById('heelToEar6').value);
				
				
				
				
				if(document.getElementById('skin1').checked)
					nums=nums-1;
				if(document.getElementById('skin2').checked)
					nums=nums+0;
				if(document.getElementById('skin3').checked)
					nums=nums+1;
				if(document.getElementById('skin4').checked)
					nums=nums+2;
				if(document.getElementById('skin5').checked)
					nums=nums+3;
				if(document.getElementById('skin6').checked)
					nums=nums+4;
				if(document.getElementById('skin7').checked)
					nums=nums+4;
				
	
				if(document.getElementById('lanuge1').checked)
					nums=nums-1;
				if(document.getElementById('lanuge2').checked)
					nums=nums+0;
				if(document.getElementById('lanuge3').checked)
					nums=nums+1;
				if(document.getElementById('lanuge4').checked)
					nums=nums+2;
				if(document.getElementById('lanuge5').checked)
					nums=nums+3;
				if(document.getElementById('lanuge6').checked)
					nums=nums+4;
				
				
				
				if(document.getElementById('planterSurface1').checked)
					nums=nums-1;
				if(document.getElementById('planterSurface2').checked)
					nums=nums+0;
				if(document.getElementById('planterSurface3').checked)
					nums=nums+1;
				if(document.getElementById('planterSurface4').checked)
					nums=nums+2;
				if(document.getElementById('planterSurface5').checked)
					nums=nums+3;
				if(document.getElementById('planterSurface6').checked)
					nums=nums+4;
				
				
				
				if(document.getElementById('breast1').checked)
					nums=nums-1;
				if(document.getElementById('breast2').checked)
					nums=nums+0;
				if(document.getElementById('breast3').checked)
					nums=nums+1;
				if(document.getElementById('breast4').checked)
					nums=nums+2;
				if(document.getElementById('breast5').checked)
					nums=nums+3;
				if(document.getElementById('breast6').checked)
					nums=nums+4;
				
				
				
				if(document.getElementById('eyeEar1').checked)
					nums=nums-1;
				if(document.getElementById('eyeEar2').checked)
					nums=nums+0;
				if(document.getElementById('eyeEar3').checked)
					nums=nums+1;
				if(document.getElementById('eyeEar4').checked)
					nums=nums+2;
				if(document.getElementById('eyeEar5').checked)
					nums=nums+3;
				if(document.getElementById('eyeEar6').checked)
					nums=nums+4;
				
				if(document.getElementById('genilalsMale1').checked)
					nums=nums-1;
				if(document.getElementById('genilalsMale2').checked)
					nums=nums+0;
				if(document.getElementById('genilalsMale3').checked)
					nums=nums+1;
				if(document.getElementById('genilalsMale4').checked)
					nums=nums+2;
				if(document.getElementById('genilalsMale5').checked)
					nums=nums+3;
				if(document.getElementById('genilalsMale6').checked)
					nums=nums+4;
				
				if(document.getElementById('genilalsFemale1').checked)
					nums=nums-1;
				if(document.getElementById('genilalsFemale2').checked)
					nums=nums+0;
				if(document.getElementById('genilalsFemale3').checked)
					nums=nums+1;
				if(document.getElementById('genilalsFemale4').checked)
					nums=nums+2;
				if(document.getElementById('genilalsFemale5').checked)
					nums=nums+3;
				if(document.getElementById('genilalsFemale6').checked)
					nums=nums+4;
			document.getElementById("totalSource").value=num;
			
		
		
		document.getElementById("totalSources").value=nums;
		
		document.getElementById("grandtotalSources").value=num+nums;

	}

	  function displayClinicalSummary(val){
		 if(val>1){
			 document.getElementById("inTab1").style.display = 'none';
			 document.getElementById("opdCommon").style.display = 'none';
			 document.getElementById("inTab2").style.display = 'block';	
		//	 document.getElementById("commButton").style.display = 'none';	
		 }else{
			 document.getElementById("inTab1").style.display = 'block';
			 document.getElementById("opdCommon").style.display = 'block';
			 document.getElementById("inTab2").style.display = 'none';	 
			// document.getElementById("commButton").style.display = 'block';	
		 }
	  }
	  //function added By Rajdeo 18/12/2017
	  function getTextBox(select){
			var selectedValue = select.options[select.selectedIndex].value;
			/*if(selectedValue="4"){
				document.getElementById("mlcTextBox_divId").style.display = "block";
			}*/
			 if(selectedValue=="0")
				document.getElementById("mlcTextBox_divId").style.display = "none";
			 else
				 document.getElementById("mlcTextBox_divId").style.display = "block";
		}
		
		function displayMLCRefered(){
			if(document.getElementById('mlc').checked){
				
			document.getElementById("mlcRefered_div").style.display="block";
			}else{
				document.getElementById("mlcRefered_div").style.display="none";
			}
		}
		
		function commonDiastolicSystolic() {
			if (parseInt(document.getElementById("systolicTemp").value) < parseInt(document.getElementById("dermoDiastolic").value)) {
				alert("Diastolic should be less than Systolic");
				document.getElementById("dermoDiastolic").value="";
				document.getElementById("dermoDiastolic").focus();
			}
		}
		function commonDiastolicSystolic1() {
			if (parseInt(document.getElementById("systolicTemp").value) < parseInt(document.getElementById("diastolicTemp").value)) {
				alert("Diastolic should be less than Systolic");
				document.getElementById("diastolicTemp").value="";
				document.getElementById("diastolicTemp").focus();
			}
		}
			function commonDiastolicSystolic2() {
				if (parseInt(document.getElementById("ptSystolic").value) < parseInt(document.getElementById("ptDiastolic").value)) {
					alert("Diastolic should be less than Systolic");
					document.getElementById("ptDiastolic").value="";
					document.getElementById("ptDiastolic").focus();
				}
		}

			
			function displayTotalScoreGCSS(val) {
				var num=0;
				

					if (document.getElementById('eyeOpeningResponse').value == 'Spontaneous--open with blinking at baseline 4 points') {
						
						num=(num)+4;
						
					} 
					if (document.getElementById('eyeOpeningResponse').value == 'To verbal stimuli, command, speech 3 points') {
						num=num+2;
						
						
					}
					
					if (document.getElementById('eyeOpeningResponse').value == 'To pain only (not applied to face) 2 points') {
						num=num+2;
						
					}
					if (document.getElementById('eyeOpeningResponse').value == 'No response 1 point') {
						num=num+1;
						
					}


					if (document.getElementById('verbalResponse').value == 'Oriented 5 points') {
						
						num=(num)+5;
						
					} 
					if (document.getElementById('verbalResponse').value == 'Confused conversation, but able to answer questions 4 points') {
						num=num+4;
						
						
					}
					
					if (document.getElementById('verbalResponse').value == 'Inappropriate words 3 points') {
						num=num+3;
						
					}
					if (document.getElementById('verbalResponse').value == 'Incomprehensible speech 2 points') {
						num=num+2;
						
					}
					if (document.getElementById('verbalResponse').value == 'No response 1 point') {
						num=num+1;
						
					}
					
					
					if (document.getElementById('motorResponse').value == 'Obeys commands for movement 6 points') {
						
						num=(num)+6;
						
					} 
					if (document.getElementById('motorResponse').value == 'Purposeful movement to painful stimulus 5 points') {
						num=num+5;
						
						
					}
					
					if (document.getElementById('motorResponse').value == 'Withdraws in response to pain 4 points') {
						num=num+4;
						
					}
					if (document.getElementById('motorResponse').value == 'Flexion in response to pain (decorticate posturing) 3 points') {
						num=num+3;
						
					}
					if (document.getElementById('motorResponse').value == 'Extension response in response to pain (decerebrate posturing) 2 points') {
						num=num+2;
						
					}
					
if (document.getElementById('motorResponse').value == 'No response 1 point') {
						
						num=(num)+1;
						
					}
					
				document.getElementById("totalSourceGCSS").value=num;
					

			}
		
		//function added by rajdeo 21/12/2017
		function getSelectedAudiogramRight(val,destVal){
			//alert("aaaaaa");
			//alert("destVal:: "+destVal);
			if(val == 'Normal' || val == 'select'){
				document.getElementById(destVal).style.display = 'none';
				document.getElementById('right_otherText').value = "";
				document.getElementById('right_otherText').style.display = 'none';
				
			}else{
				var selectedOptions = document.getElementById("right_dropdown").selectedOptions;
			    for(var i = 0; i < selectedOptions.length; i++){
			        selectedOptions[i].selected = false;
			    }
				document.getElementById('right_dropdown').style.display = 'none';
				document.getElementById('right_otherText').value = "";
				document.getElementById('right_otherText').style.display = 'none';				
				document.getElementById(destVal).style.display = 'block';
			}
			
		
		}
		function getSelectedAudiogramTextBox(val, destValue){
			//alert("bbb");
			//alert("destValue ::"+destValue);
			if(val == 'Others'){
				document.getElementById(destValue).style.display = 'block';
			}else{
				document.getElementById('right_otherText').style.display = 'none';	
				document.getElementById(destValue).style.display = 'none';
			}
		}
		
		function getSelectedAudiogramLeft(val,destVal){
			//alert("cccc");
			//alert("destVal:: "+destVal);
			if(val == 'Normal' || val == 'select'){
				document.getElementById(destVal).style.display = 'none';
				document.getElementById('left_otherText').value = "";
				document.getElementById('left_otherText').style.display = 'none';
				
			}else{
				var selectedOptions = document.getElementById("left_dropdown").selectedOptions;
			    for(var i = 0; i < selectedOptions.length; i++){
			        selectedOptions[i].selected = false;
			    }
				document.getElementById('left_dropdown').style.display = 'none';	
				document.getElementById('left_otherText').value = "";
				document.getElementById('left_otherText').style.display = 'none';
				document.getElementById(destVal).style.display = 'block';
			}
			
		
		}
		function getSelectedAudiogramTextBoxLeft(val, destValue){
			//alert("ddd");
			//alert("destValue ::"+destValue);
			if(val == 'Others'){
				document.getElementById(destValue).style.display = 'block';
			}else{
				document.getElementById('left_otherText').style.display = 'none';	
				document.getElementById(destValue).style.display = 'none';
			}
		}
		
		function addAACMedicineRow(){
			var tbl = document.getElementById('grid');
			var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex').value) + 1;
			document.getElementById('hdbTabIndex').value = hdbTabIndex;

			var lastRow = tbl.rows.length;
			// if there's no header row in the table, then iteration = lastRow + 1
			var iteration = lastRow;
			var row = tbl.insertRow(lastRow);
			var hdb = document.getElementById('hdb');
			iteration = parseInt(hdb.value) + 1;
			hdb.value = iteration;
			// document.getElementById('pulse').value=hdb.value;

			var cellRight1 = row.insertCell(0);
			var e1 = document.createElement('input');
			e1.type = 'checkbox';
			e1.name = 'itemRadio' + iteration;
			e1.id = 'itemRadio' + iteration;
			e1.className = 'radioCheck';
			e1.onchange = function() {
				checkPrescriptionCheck(iteration);
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
			e1.name = 'nomenclature' + iteration;
			e1.id = 'nomenclature' + iteration;
			e1.className = "textYellow largTextBoxOpd";
			e1.onfocus = function() {
				// Commented by Arbind on 31-01-2017
				// checkEnteredDiagnosis();
				checkFrequency(iteration, "opc");
			}
			e1.onkeypress = function() {
				checkTextColor('nomenclature' + iteration);
			};
			e1.onblur = function() {
				checkForAlreadyIssuedPrescribtion(this.value, iteration);
				populatePVMS(this.value, iteration);
				checkItem(iteration);
				copyToPrescriptionTAb(iteration, 'opconsult');
				ValidateCantra();
				displayAu(this.value, iteration);
				validatePrescriptionAutocomplete('opmain', this.value, iteration);
				checkForAllergy(this.value, iteration);

			};
			e1.size = '35';
			e1.tabIndex = hdbTabIndex + "2";
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
			e1.name = 'actualDispensingQty' + iteration;
			e1.id = 'actualDispensingQty' + iteration;
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
			var e1 = document.createElement('input');
			e1.type = 'hidden';
			e1.name = 'alreadyPres' + iteration;
			e1.id = 'alreadyPres' + iteration;
			e1.value = 'N';
			cellRight1.appendChild(e1);
			/*
			 * var cellRight1 = row.insertCell(2); var e1 =
			 * document.createElement('input'); e1.name='route'+iteration;
			 * e1.id='route'+iteration; e1.className="textYellow opdgridText";
			 * e1.onblur=function() { fillRouteOnTAb(iteration);};
			 * cellRight1.appendChild(e1);
			 * 
			 * var e1 = document.createElement('input'); e1.type = 'hidden';
			 * e1.name='routeHidden'+iteration; e1.id='routeHidden'+iteration;
			 * e1.className="textYellow opdgridText"; cellRight1.appendChild(e1);
			 * 
			 * var newdiv = document.createElement('div'); newdiv.setAttribute('id',
			 * 'ac2updatesRoute'+iteration); newdiv.style.display = 'none';
			 * newdiv.className = "autocomplete"; cellRight1.appendChild(newdiv); new
			 * Ajax.Autocompleter('route'+iteration,'ac2updatesRoute'+iteration,'opd?method=getRouteAutoList',{minChars:1,parameters:'requiredField=route'+iteration,afterUpdateElement :
			 * changeTest});
			 */
			var cellRight1 = row.insertCell(2);
			var e1 = document.createElement('Select');
			e1.name = 'route' + iteration;
			e1.id = 'route' + iteration;
			e1.style.width = "90px";
			e1.style.background = "#FFFF99";
			e1.tabIndex = hdbTabIndex + "3";
			e1.options[0] = new Option('Select', '0');
			for (var i = 0; i < routeArray.length; i++) {
				e1.options[i + 1] = new Option(routeArray[i][1], routeArray[i][0]);
			}
			e1.onblur = function() {
				fillRouteOnTAb(iteration);
			};
			cellRight1.appendChild(e1);

			var cellRight1 = row.insertCell(3);
			var e1 = document.createElement('input');
			e1.name = 'dosage' + iteration;
			e1.id = 'dosage' + iteration;
			e1.className = "textYellow opdTextBoxTSmall";
			e1.onblur = function() {
				fillValue(this.value, iteration);
				checkFrequencyForTaperedDrugs(iteration);
			};
			e1.tabIndex = hdbTabIndex + "4";
			cellRight1.appendChild(e1);

			var cellRight1 = row.insertCell(4);
			var e1 = document.createElement('input');
			e1.type = 'text';
			e1.name = 'unit' + iteration;
			e1.id = 'unit' + iteration;
			e1.className = 'textYellow opdTextBoxTSmall';
			e1.readOnly = 'readOnly';
			e1.tabIndex = hdbTabIndex + "5";
			cellRight1.appendChild(e1);

			var cellRight1 = row.insertCell(5);
			var e1 = document.createElement('Select');
			e1.name = 'frequency' + iteration;
			e1.id = 'frequency' + iteration;
			e1.style.width = "90px";
			e1.style.background = "#FFFF99";
			e1.tabIndex = hdbTabIndex + "6";
			e1.options[0] = new Option('Select', '0');
			for (var i = 0; i < icdArray.length; i++) {
				// this part is added by amit das
				var opt = document.createElement('option');
				opt.id = icdArray[i][2];
				opt.value = icdArray[i][0];
				opt.innerHTML = icdArray[i][1];
				e1.appendChild(opt);
				// e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]); //
				// this part is commented by amit das
			}
			e1.onblur = function() {
				getFrequencyValue(this.value, iteration);
				fillValue(this.value, iteration);
				displaySOSQty(this.value, iteration);
				checkFrequencyForTaperedDrugs(iteration);
			};

			e1.onchange = function() { // added by amit das
				displaFrequencyType(this, iteration);
			};

			cellRight1.appendChild(e1);

			var e21 = document.createElement('input');
			e21.type = 'hidden';
			e21.name = 'sosQty' + iteration;
			e21.id = 'sosQty' + iteration;
			e21.size = '5';
			e21.setAttribute('tabindex', '1');
			cellRight1.appendChild(e21);

			var e21 = document.createElement('input');
			e21.type = 'hidden';
			e21.name = 'frequencyValue' + iteration;
			e21.id = 'frequencyValue' + iteration;
			e21.size = '5';
			e21.setAttribute('tabindex', '1');
			cellRight1.appendChild(e21);

			var cellRight1 = row.insertCell(6);

			var e21Div = document.createElement('div');
			e21Div.style = 'width:100px; float: left;';

			var e1 = document.createElement('input');
			e1.type = 'text';
			e1.name = 'noOfDays' + iteration;
			e1.className = "textYellow opdTextBoxTSmall";
			e1.id = 'noOfDays' + iteration;
			e1.size = '3';
			e1.tabIndex = hdbTabIndex + "7";
			e1.onblur = function() {
				fillValueDays(iteration);
				fillValue(this.value, iteration);
			};
			e21Div.appendChild(e1);

			var ef21 = document.createElement('p');
			ef21.style = 'line-height:0px;';
			ef21.id = 'frequencyType' + iteration;
			e21Div.appendChild(ef21);
			cellRight1.appendChild(e21Div);

			var cellRight1 = row.insertCell(7);
			var e1 = document.createElement('Select');
			e1.name = 'instrunction' + iteration;
			e1.id = 'instrunction' + iteration;
			e1.style.width = "90px";
			e1.style.background = "#FFFF99";
			e1.tabIndex = hdbTabIndex + "8";
			e1.options[0] = new Option('Select', '0');
			for (var i = 0; i < instructionArray.length; i++) {
				e1.options[i + 1] = new Option(instructionArray[i][1],
						instructionArray[i][0]);
			}
			e1.onblur = function() {
				fillInstrunctionOnTAb(iteration);
			};
			cellRight1.appendChild(e1);

			var cellRight1 = row.insertCell(8);
			var e1 = document.createElement('input');
			e1.type = 'text';
			e1.name = 'splInstrunction' + iteration;
			e1.id = 'splInstrunction' + iteration;
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
			e1.name = 'unitLable' + iteration;
			e1.id = 'unitLable' + iteration;
			e1.className = "textYellow opdTextBoxTSmall";
			e1.readOnly = 'readOnly';
			e1.size = '5';
			cellRight1.appendChild(e1);
			
			var cellRight1 = row.insertCell(11);
			var e1 = document.createElement('input');
			e1.type = 'checkbox';
			e1.name = 'blockMedicine' + iteration;
			e1.id = 'blockMedicine' + iteration;
			e1.className = 'radioCheck';
			e1.onchange = function() {
				blockMedicine(this,iteration);
			};
			cellRight1.appendChild(e1);
			
			var cellRight1 = row.insertCell(12);
			var e1 = document.createElement('input');
			e1.type = 'text';
			e1.name = 'blockDays' + iteration;
			e1.id = 'blockDays' + iteration;
			e1.className = "textYellow opdTextBoxTSmall";
			e1.maxLength = '2';
			e1.readOnly = true;
			e1.onkeypress = function (event) {
				  javascript: return isNumber(event)
			};
			cellRight1.appendChild(e1);
		}
		
		function blockMedicine(blockCheckbox,increment){
			if(blockCheckbox.checked){
				document.getElementById("blockDays"+increment).readOnly = false;
			}else{
				document.getElementById("blockDays"+increment).readOnly = true;
				document.getElementById("blockDays"+increment).value = "";
			}
		}		
		function displayLeproPresenting(val) {
			if (val == 'Others') {
				document.getElementById('leprosyPresenting').style.display = 'block';

			} else {
				document.getElementById('leprosyPresenting').style.display = 'none';

			}
		}
		function openPopupForLabResultsForSpeciality(csrf,orderNo,investigationId) {
			window.open("/hms/hms/opd?method=printResultValidationLabForSpeciality&parent="+ orderNo+"&investigationId="+ investigationId+"&"+ csrf + "&" + csrfTokenName + "=" + csrfTokenValue,
							"_blank",
							"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
		}
		
		
		
		//Added by swarup 29-12-2017
		function displayfamilyHistoryOfSimilarIllnessValue(val) {
			if (val == 'Present') {
				document.getElementById('familyHistoryOfSimilarIllnessValueDiv').style.display = 'block';
			} else {
				document.getElementById('familyHistoryOfSimilarIllnessValueDiv').style.display = 'none';

			}
		}
	 	
	 	function displaydrugHistoryValue(val) {
			if (val == 'Yes') {
				document.getElementById('drugHistoryValueDiv').style.display = 'block';
			} else {
				document.getElementById('drugHistoryValueDiv').style.display = 'none';

			}
		}
	 	
	 	/*
	 	 * commented by swarup
	 	 * function displaysecondaryPigmentationValue(val) {
			if (val == 'Yes') {
				document.getElementById('secondaryPigmentationValueDiv').style.display = 'block';
			} else {
				document.getElementById('secondaryPigmentationValueDiv').style.display = 'none';

			}
		} 
	 	
	 	function displayprimaryPigmentationValue(val) {
			if (val == 'Yes') {
				document.getElementById('primaryPigmentationValueDiv').style.display = 'block';
			} else {
				document.getElementById('primaryPigmentationValueDiv').style.display = 'none';

			}
		}*/
	 	
	 	function displayprimaryPigmentationValue(primaryPigmentationValue,inc) {
			if (primaryPigmentationValue == "Yes") {
				document.getElementById('primaryPigmentationValueDiv'+inc).style.display = 'inline';
			} else {
				document.getElementById('primaryPigmentationValueDiv'+inc).style.display = 'none';

			}
		}
	 	
	 	function displaysecondaryPigmentationValue(secondaryPigmentationValue,inc) {
			if (secondaryPigmentationValue == "Yes") {
				document.getElementById('secondaryPigmentationValueDiv'+inc).style.display = 'inline';
			} else {
				document.getElementById('secondaryPigmentationValueDiv'+inc).style.display = 'none';

			}
		}
	 	
	 	function commonDiastolicSystolicforGeneralProforma() {
			if (parseInt(document.getElementById("systolicTempforgp").value) < parseInt(document.getElementById("diastolicTempforgp").value)) {
				alert("Diastolic should be less than Systolic");
				document.getElementById("diastolicTempforgp").value="";
				document.getElementById("diastolicTempforgp").focus();
			}
		}
	 		

	  	  function displayPrsentingComplaints(val) {
	 		var others = "";
	 		if (val) {
	 			document.getElementById('presentingComplaintValue').style.display = 'block';
	 			var str="",i;
	 	        var element = document.getElementById('presentingComplaints');
	 			for (i=0;i < element.options.length;i++) {
	 			    if (element.options[i].selected) {
	 			    	if(str.trim()!='')
	 			    		str = str+ ", ";
	 			    	
	 			    		str =	str+element.options[i].value;	
	 			    		if(others == "" && element.options[i].value == "Others")
	 			    			others = "Others";
	 			    }
	 			}
	 			document.getElementById('presentingComplaintValue').innerHTML = str;
	 		} else {
	 			document.getElementById('presentingComplaintValue').style.display = 'none';
	 		}
	 		if(others == 'Others') {
	 			document.getElementById('presentingComplaintsOthersValue').style.display = 'block';
	 		} else {
	 			document.getElementById('presentingComplaintsOthersValue').style.display = 'none';
	 		}
	 	} 
	 	
 	 	function displayAggravatingFactors(val) {
		 		var others = "";
		 		if (val) {
		 			document.getElementById('aggravatingFactorsValue').style.display = 'block';
		 			var str="",i;
		 	        var element = document.getElementById('aggravatingFactors');
		 			for (i=0;i < element.options.length;i++) {
		 			    if (element.options[i].selected) {
		 			    	if(str.trim()!='')
		 			    		str = str+ ", ";
		 			    	
		 			    		str =	str+element.options[i].value;	
		 			    		if(others == "" && element.options[i].value == "Others")
		 			    			others = "Others";
		 			    }
		 			}
		 			document.getElementById('aggravatingFactorsValue').innerHTML = str;
		 		} else {
		 			document.getElementById('aggravatingFactorsValue').style.display = 'none';
		 		}
		 		if(others == 'Others') {
		 			document.getElementById('aggravatingFactorsOthersValue').style.display = 'block';
		 		} else {
		 			document.getElementById('aggravatingFactorsOthersValue').style.display = 'none';
		 		}
		 	}
	 	
	 	function displayPastHistoryNew(val) {
	 		var others = "";
	 		if (val) {
	 			document.getElementById('pastHistoryValue11').style.display = 'block';
	 			var str="",i;
	 	        var element = document.getElementById('pastHistory11');
	 			for (i=0;i < element.options.length;i++) {
	 			    if (element.options[i].selected) {
	 			    	if(str.trim()!='')
	 			    		str = str+ ", ";
	 			    	
	 			    		str =	str+element.options[i].value;	
	 			    		if(others == "" && element.options[i].value == "Others")
	 			    			others = "Others";
	 			    }
	 			}
	 			document.getElementById('pastHistoryValue11').innerHTML = str;
	 		} else {
	 			document.getElementById('pastHistoryValue11').style.display = 'none';
	 		}
	 		if(others == 'Others') {
	 			document.getElementById('pastHistoryOthersValue11').style.display = 'block';
	 		} else {
	 			document.getElementById('pastHistoryOthersValue11').style.display = 'none';
	 		}
	 	}
	 	
	 	function displayMucousMembrane(val) {
	 		var others = "";
	 		if (val) {
	 			document.getElementById('mucousMenbraneValue').style.display = 'block';
	 			var str="",i;
	 	        var element = document.getElementById('mucousMembrane');
	 			for (i=0;i < element.options.length;i++) {
	 			    if (element.options[i].selected) {
	 			    	if(str.trim()!='')
	 			    		str = str+ ", ";
	 			    	
	 			    		str =	str+element.options[i].value;	
	 			    		if(others == "" && element.options[i].value == "Others")
	 			    			others = "Others";
	 			    }
	 			}
	 			document.getElementById('mucousMenbraneValue').innerHTML = str;
	 		} else {
	 			document.getElementById('mucousMenbraneValue').style.display = 'none';
	 		}
	 		if(others == 'Others') {
	 			document.getElementById('mucousMenbraneOthersValue').style.display = 'block';
	 		} else {
	 			document.getElementById('mucousMenbraneOthersValue').style.display = 'none';
	 		}
	 	}
	 	
	  	function displayHair(val) {
	 		var others = "";
	 		if (val) {
	 			document.getElementById('hairValue').style.display = 'block';
	 			var str="",i;
	 	        var element = document.getElementById('hair');
	 			for (i=0;i < element.options.length;i++) {
	 			    if (element.options[i].selected) {
	 			    	if(str.trim()!='')
	 			    		str = str+ ", ";
	 			    	
	 			    		str =	str+element.options[i].value;	
	 			    		if(others == "" && element.options[i].value == "Others")
	 			    			others = "Others";
	 			    }
	 			}
	 			document.getElementById('hairValue').innerHTML = str;
	 		} else {
	 			document.getElementById('hairValue').style.display = 'none';
	 		}
	 		if(others == 'Others') {
	 			document.getElementById('hairOthersValue').style.display = 'block';
	 		} else {
	 			document.getElementById('hairOthersValue').style.display = 'none';
	 		}
	 	}
	 	
	  	function displayNails(val) {
	 		var others = "";
	 		if (val) {
	 			document.getElementById('nailsValue').style.display = 'block';
	 			var str="",i;
	 	        var element = document.getElementById('nails');
	 			for (i=0;i < element.options.length;i++) {
	 			    if (element.options[i].selected) {
	 			    	if(str.trim()!='')
	 			    		str = str+ ", ";
	 			    	
	 			    		str =	str+element.options[i].value;	
	 			    		if(others == "" && element.options[i].value == "Others")
	 			    			others = "Others";
	 			    }
	 			}
	 			document.getElementById('nailsValue').innerHTML = str;
	 		} else {
	 			document.getElementById('nailsValue').style.display = 'none';
	 		}
	 		if(others == 'Others') {
	 			document.getElementById('nailsOthersValue').style.display = 'block';
	 		} else {
	 			document.getElementById('nailsOthersValue').style.display = 'none';
	 		}
	 	}
	 	
	 	function displaySystemIllness(val) {
	 		var others = "";
	 		if (val) {
	 			document.getElementById('systemIllnessValue').style.display = 'block';
	 			var str="",i;
	 	        var element = document.getElementById('systemIllness');
	 			for (i=0;i < element.options.length;i++) {
	 			    if (element.options[i].selected) {
	 			    	if(str.trim()!='')
	 			    		str = str+ ", ";
	 			    	
	 			    		str =	str+element.options[i].value;	
	 			    		if(others == "" && element.options[i].value == "Others")
	 			    			others = "Others";
	 			    }
	 			}
	 			document.getElementById('systemIllnessValue').innerHTML = str;
	 		} else {
	 			document.getElementById('systemIllnessValue').style.display = 'none';
	 		}
	 		if(others == 'Others') {
	 			document.getElementById('systemIllnessOthersValue').style.display = 'block';
	 		} else {
	 			document.getElementById('systemIllnessOthersValue').style.display = 'none';
	 		}
	 	}
	 	
	  	function displaySigns(val) {
	 		var others = "";
	 		if (val) {
	 			document.getElementById('signsValue').style.display = 'block';
	 			var str="",i;
	 	        var element = document.getElementById('signs');
	 			for (i=0;i < element.options.length;i++) {
	 			    if (element.options[i].selected) {
	 			    	if(str.trim()!='')
	 			    		str = str+ ", ";
	 			    	
	 			    		str =	str+element.options[i].value;	
	 			    		if(others == "" && element.options[i].value == "Others")
	 			    			others = "Others";
	 			    }
	 			}
	 			document.getElementById('signsValue').innerHTML = str;
	 		} else {
	 			document.getElementById('signsValue').style.display = 'none';
	 		}
	 		if(others == 'Others') {
	 			document.getElementById('signsOthersValue').style.display = 'block';
	 		} else {
	 			document.getElementById('signsOthersValue').style.display = 'none';
	 		}
	 	}
		
		//ended by swarup 29-12-2017
	  	
	  	function yearFormatDate(i)
	  	{
	  		var year=document.getElementById('dateYear'+i).value ;
	  		if(year!="" && year.length ==4)
	  		{
	  		var dateStr="01/01/"+year;
	  		document.getElementById('dateYear'+i).value = dateStr;
	  		}
	  			  		
	  	}
	
	  	function yearTempFormatDate(i)
	  	{
	  		var year=document.getElementById('dateYearTemp'+i).value ;
	  		if(year!="" && year.length ==4)
	  		{
	  		var dateStr="01/01/"+year;
	  		document.getElementById('dateYearTemp'+i).value = dateStr;
	  		}
	  			  		
	  	}



	  	function addRowForCurrentPreviousSurgeriesTemp() {
	  		var tbl = document.getElementById('previousSurgeriesGridTemp');
	  		var lastRow = tbl.rows.length;
	  		var iteration = lastRow;
	  		var row = tbl.insertRow(lastRow);
	  		var hdb = document.getElementById('previousSurgeriesCountTemp');
	  		iteration = parseInt(hdb.value) + 1;
	  		hdb.value = iteration;

	  		var cellRight1 = row.insertCell(0);
	  		var e1 = document.createElement('input');
	  		e1.type = 'checkbox';
	  		e1.name = 'previousSurgeriesRadioTemp' + iteration;
	  		e1.id = 'previousSurgeriesRadioTemp' + iteration;
	  		
	  		e1.className = 'radioCheck';
	  		cellRight1.appendChild(e1);

	  		var cellRight1 = row.insertCell(1);
	  		var e1 = document.createElement('textarea');
	  		e1.name = 'typePTemp' + iteration;
	  		e1.id = 'typePTemp' + iteration;
	  		e1.onblur=function(){
	  			setVitalValue(this.value,'typeP'+iteration);
	  			}
	  		e1.size = '30';
	  		e1.style.margin="0px 5px"; 
	  		e1.style.width="231px";
	  		e1.style.height="30px;"
	  		e1.maxLength = 150;
	  		cellRight1.appendChild(e1);

	  		var cell1 = row.insertCell(2);
	  		var e1 = document.createElement('input');
	  		e1.type = 'text';
	  		e1.name = 'dateYearTemp' + (iteration);
	  		e1.size = '10';
	  		e1.id = 'dateYearTemp' + (iteration);
	  		e1.className = 'date';
	  		var eImg = document.createElement('img');
	  		eImg.src = '/hms/jsp/images/cal.gif';
	  		eImg.style.display = 'inline';
	  		eImg.onclick = function(event) {
	  			setdate('', document.getElementById('dateYearTemp' + iteration), event)
	  		};
	  		e1.maxLength = 4;
	  		e1.onkeypress = function (event) {
	  			  javascript: return isNumber(event)
	  		};
	  		e1.onblur=function(){
	  			yearTempFormatDate(iteration);
	  			yearFormatDate(iteration);
	  			setVitalValue(this.value,'dateYearTemp'+iteration);
	  			setVitalValue(this.value,'dateYear'+iteration);
	  		}
	  		cell1.appendChild(e1);
	  		cell1.appendChild(eImg);

	  		var cellRight1 = row.insertCell(3);
	  		var e1 = document.createElement('input');
	  		e1.type = 'text';
	  		e1.name = 'institutionTemp' + iteration;
	  		e1.id = 'institutionTemp' + iteration;
	  		e1.size = '20';
	  		e1.onblur=function(){
	  			setVitalValue(this.value,'institution'+iteration);
	  			}
	  		e1.maxLength = 32;
	  		cellRight1.appendChild(e1);

	  		var cellRight1 = row.insertCell(4);
	  		var e1 = document.createElement('input');
	  		e1.type = 'text';
	  		e1.name = 'hospitalizationDurationTemp' + iteration;
	  		e1.id = 'hospitalizationDurationTemp' + iteration;
	  		e1.maxLength = 5;
	  		e1.onblur=function(){
	  			setVitalValue(this.value,'hospitalizationDuration'+iteration);
	  			}
	  		e1.onkeypress = function (event) {
	  			  javascript: return isNumberDecimal(event)
	  		};
	  		e1.setAttribute('validate', 'Hospitalization Duration,float,no');
	  		cellRight1.appendChild(e1);

	  		var cellRight1 = row.insertCell(5);
	  		var e1 = document.createElement('input');
	  		e1.type = 'text';
	  		e1.onblur=function(){
	  			setVitalValue(this.value,'complications'+iteration);
	  			}
	  		e1.name = 'complicationsTemp' + iteration;
	  		e1.id = 'complicationsTemp' + iteration;
	  		e1.maxLength = 32;
	  		cellRight1.appendChild(e1);

	  	}

	  	function removeRowForCurrentPreviousSurgeriesTemp() {
	  		var tbl = document.getElementById('previousSurgeriesGridTemp');
	  		var lastRow = tbl.rows.length;
	  		var hdb = document.getElementById('previousSurgeriesCountTemp');
	  		var iteration = parseInt(hdb.value);
	  		var totalSelected = 0;
	  		for (var i = 1; i <= iteration; i++) {
	  			if (document.getElementById("previousSurgeriesRadioTemp" + i) != null
	  					&& (typeof document
	  							.getElementById("previousSurgeriesRadioTemp" + i).checked) != 'undefined'
	  					&& document.getElementById("previousSurgeriesRadioTemp" + i).checked) {
	  				totalSelected = totalSelected + 1;
	  			}
	  		}
	  		if (totalSelected == 0) {
	  			alert('Please select atleast 1 row to delete');
	  		} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
	  			alert('You can not delete all Row.');
	  		} else if (lastRow > 2) {
	  			for (var i = 1; i <= iteration; i++) {
	  				if (document.getElementById("previousSurgeriesRadioTemp" + i) != null
	  						&& (typeof document.getElementById("previousSurgeriesRadioTemp"
	  								+ i).checked) != 'undefined'
	  						&& document.getElementById("previousSurgeriesRadioTemp" + i).checked) {
	  					var deleteRow = document
	  							.getElementById("previousSurgeriesRadioTemp" + i).parentNode.parentNode;
	  					document.getElementById("previousSurgeriesRadioTemp" + i).parentNode.parentNode.parentNode
	  							.removeChild(deleteRow);
	  				}
	  			}
	  		}
	  	}
	  
	  	
	  	
	  	//Addedd by swarup 12-01-2018
	  	function displayTextValueFPhistoryOfAllergy(val) {
	  		if (val == "Yes") {
	  			document.getElementById("historyOfAllergyDiv").style.display = 'block';
	  		}else{
	  			document.getElementById("historyOfAllergyDiv").style.display = 'none';
	  		document.getElementById("historyOfAllergyValue").value = "";
	  		}
	  	}
	  		
	  	function displayTextValueFPclicking(val) {
	  		if (val == "Present") {
	  			document.getElementById("clickingDiv").style.display = 'block';
	  		}else{
	  			document.getElementById("clickingDiv").style.display = 'none';
	  		document.getElementById("clickingValue").value = "";
	  		}
	  	}
	  		
	  	function displayTextValueFPpain(val) {	
	  	if (val == "Present") {
	  			document.getElementById("painDiv").style.display = 'block';
	  		}else{ 
	  			document.getElementById("painDiv").style.display = 'none';
	  		document.getElementById("painValue").value = "";
	  		}
	  	}
	  	
	  	function displayTextValueFPdeviation(val) {
	  		if (val == "Present") {
	  			document.getElementById("deviationDiv").style.display = 'block';
	  		}else{
	  			document.getElementById("deviationDiv").style.display = 'none';
	  		document.getElementById("deviationValue").value = "";
	  		}
	  	}
	  	
	  	function displayTextValueFPresidualRoots(val) {
	  		if (val == "Present") {
	  			document.getElementById("residualRootsDiv").style.display = 'block';
	  		}else{
	  			document.getElementById("residualRootsDiv").style.display = 'none';
	  		document.getElementById("residualRootsValue").value = "";
	  		}
	  	}
	  	
	  	function displayTextValueFPperiapicalStatusH(val) {
	  		if (val == "Diseased") {
	  			document.getElementById("periapicalStatusDiv").style.display = 'block';
	  		}else{
	  			document.getElementById("periapicalStatusDiv").style.display = 'none';
	  		document.getElementById("periapicalStatusValue").value = "";
	  		}
	  	}

	  	function displayTextValueFProotResorption(val) {
	  		if (val == "Present") {
	  			document.getElementById("rootResorptionDiv").style.display = 'block';
	  		}else{
	  			document.getElementById("rootResorptionDiv").style.display = 'none';
	  		document.getElementById("rootResorptionValue").value = "";
	  		}
	  	}
	  		
	  	function displayTextValueFPcrownRootRatio(val) {
	  		if (val == "Ideal") {
	  			document.getElementById("crownRootRatioDiv").style.display = 'block';
	  		}else{
	  			document.getElementById("crownRootRatioDiv").style.display = 'none';
	  		document.getElementById("crownRootRatioValue").value = "";
	  		}
	  	}
	  		
	  	function displayTextValueFPcontinuityOfLaminaDura(val) {
	  		if (val == "Continuous") {
	  			document.getElementById("continuityOfLaminaDuraDiv").style.display = 'block';
	  		}else{
	  			document.getElementById("continuityOfLaminaDuraDiv").style.display = 'none';
	  		document.getElementById("continuityOfLaminaDuraValue").value = "";
	  		}
	  	}

	  	function displayTextValueFPverticalHorizontal(val) {
	  		if (val == "Present") {
	  			document.getElementById("verticalHorizontalDiv").style.display = 'block';
	  		}else{
	  			document.getElementById("verticalHorizontalDiv").style.display = 'none';
	  		document.getElementById("verticalHorizontaValue").value = "";
	  			}
	  		}
	  	
		function addRowForInvestigationForOpdLiteOther() {

			var tbl = document.getElementById('investigationGrid');
			var lastRow = tbl.rows.length;
			var iteration = lastRow;
			var row = tbl.insertRow(lastRow);
			var hdb = document.getElementById('hiddenValue');
			iteration = parseInt(hdb.value)+ 1;
			hdb.value = iteration;

			var cellRight1 = row.insertCell(0);
			var e0 = document.createElement('input');
			e0.type = 'hidden';
			e0.name = 'availableStatus' + iteration;
			e0.id = 'availableStatus' + iteration;
			e0.size = '20';
			cellRight1.appendChild(e0);

			var e0 = document.createElement('input');
			e0.type = 'hidden';
			e0.name = 'parkInvestigationId' + iteration;
			e0.id = 'parkInvestigationId' + iteration;
			cellRight1.appendChild(e0);
			
			var e0 = document.createElement('input');
			e0.type = 'button';
			e0.alt = 'Delete';
			e0.onclick = function() {
				removeRowForOpdLite(this,'investigation');
			};
			e0.className = 'delButSmll';
			e0.id = 'investigationDelete'+iteration;
			cellRight1.appendChild(e0);
			
			var cellRight0 = row.insertCell(1);
			var e0 = document.createElement('input');
			e0.type = 'text';
			e0.name = 'chargeCodeName' + iteration;
			e0.id = 'chargeCodeName' + iteration;
			e0.onkeypress = function() {
				checkTextColor('chargeCodeName' + iteration);
			};
			e0.onblur = function() {
				getUnavailableInvestigation(iteration);
				checkInvestigationItem(iteration);
				getLoincSnomedList(iteration);
				if (validateInvestigationAutoComplete(this.value, iteration)) {
					submitProtoAjaxNew('opdMain',
							"/hms/hms/opd?method=fillChargeCode&hinId="
									+ document.getElementById("hinId").value
									+ "&rowVal=" + iteration, 'chargeCodeVal'
									+ iteration);
				}
			};
			e0.size = '35';
			e0.style="width: 240px;"
			e0.className = "popper chargeCodeName";
			cellRight0.appendChild(e0);

			var updatediv = document.createElement('div');
			updatediv.setAttribute('id', 'ac2update' + iteration);
			updatediv.style.display = 'none';
			updatediv.className = "autocomplete";
			cellRight0.appendChild(updatediv);

			new Ajax.Autocompleter('chargeCodeName' + iteration, 'ac2update'
					+ iteration, 'opd?method=getInvestigationListForAutoComplete', {
				minChars : 3,
				callback : function(element, entry) {
					return entry + '&labradiologyCheck='
							+ document.getElementById('investigationCategory').value;
				},
				parameters : 'requiredField=chargeCodeName' + iteration
						+ '&fromOpd=fromOpd'
			});

			/*var sel = document.createElement('input');
			sel.type = 'hidden';
			sel.name = 'chargeCode' + iteration;
			sel.id = 'chargeCode' + iteration;
			sel.size = '15';
			cellRight1.appendChild(sel);*/
			
			var cellRight3 = row.insertCell(2);
			var e0 = document.createElement('input');
			e0.type = 'hidden';
			e0.name = 'clinicalNotes' + iteration;
			e0.id = 'clinicalNotes' + iteration;
			e0.size = '20';
			e0.className = "opdTextBoxSmall textYellow";
			cellRight3.appendChild(e0);

		}
		
	  //Added by swarup 20/09/2018
	  	function getMultiSelectValue1(select, complaintValue) {
	  		var myMap = new Map();
	  		var previousSelection = document.getElementById(complaintValue).value;
	  		if(previousSelection !=null && previousSelection !='' ){
	  			var previousSelection = document.getElementById(complaintValue).value;
	  			var temp = new Array();
	  			temp = previousSelection.split("\n");
	  			if(temp !=null && temp !=''){
	  				
	  				for(var k=0; k<temp.length;k++){
	  					var temp1 = new Array();
	  					var temp1 = temp[k].split("-");
	  				
	  				myMap.set(temp1[0], temp1[1]);
	  				}
	  			}
	  		}
	  		
   		  return [].reduce.call(select.options, function(values, option) {
   			  if(option.selected){
   				  if (myMap.has(option.value)) {
   					values.push(option.value+"-"+ myMap.get(option.value));
   				  } else {
   					values.push(option.value+"-" + "," );
   				  }
   				  
   			  }  //option.selected? values.push(option.value.concat('-')) : null;
	 		    return values;
	 		  }, []);
	 		}
  		function showValues1(select,complaintValue){
  			var values = getMultiSelectValue1(select, complaintValue);
  			 document.getElementById(complaintValue).value = values.join('\n');
	 		} 	
	 	function displayGeneralProformaValueDivGp1(val,complaintValueDiv,complaint,complaintValue,otherValueId,othersValueDiv) {
			if (val != null && val != '') {
				document.getElementById(complaintValueDiv).style.display = 'block';
				var i;
		       var element = document.getElementById(complaint);
	 				for (i=0;i < element.options.length;i++) {
	 			    if (element.options[i].selected) {
	 			    	if (element.options[i].value == 'Others') {
	 						document.getElementById(othersValueDiv).style.display = 'block';
	 					} else {
	 						 document.getElementById(otherValueId).value = "";
	 						 document.getElementById(othersValueDiv).style.display = 'none';
	 					}
	 			    }
	 			}
	 		} else {
				document.getElementById(complaintValueDiv).style.display = 'none';
			}
		} 
	  	
 		
		function getMultiSelectValue2(select) {
	 		  return [].reduce.call(select.options, function(values, option) {
	 		    option.selected? values.push(option.value) : null;
	 		    return values;
	 		  }, []);
	 		}
		function showValues2(values){
	 		  document.getElementById('aggravatingFactorsValue').value = values.join('\n');
	 		} 	
 		function displayGeneralProformaValueDivGp2(val) {
 			if (val != null && val != '') {
				document.getElementById('aggravatingFactorsValueDivGp').style.display = 'block';
				var i;
		       var element = document.getElementById('aggravatingFactors');
	 				for (i=0;i < element.options.length;i++) {
	 			    if (element.options[i].selected) {
	 			    	if (element.options[i].value == 'Others') {
	 						document.getElementById('aggravatingFactorsOthersValue').style.display = 'block';
	 					} else {
	 						document.getElementById('aggravatingFactorsOthersValue').style.display = 'none';
	 					}
	 			    }
	 			}
	 		} else {
				document.getElementById('aggravatingFactorsValueDivGp').style.display = 'none';
			}
		} 
 			 
 			 
 	  	function getMultiSelectValue3(select) {
	 		  return [].reduce.call(select.options, function(values, option) {
	 		    option.selected? values.push(option.value) : null;
	 		    return values;
	 		  }, []);
	 		}
		function showValues3(values){
	 		  document.getElementById('pastHistoryValue').value = values.join('\n');
	 		} 	
	 	function displayGeneralProformaValueDivGp3(val) {
	 		if (val == 'Diabetes - '||val=='Hypertension - '||val=='Atopy - '||val=='Epilepsy - '||val=='TB - '	||val=='Asthma - '||val=='Drug Allergy - '||val=='Jaundice - '||val=='Blood transfusion - '||val=='Thyroid disorders - '
	 				||val=='Surgery - '||val=='Similar Illness - '||val=='Others - '	) {
	 			
	 	  		document.getElementById('pastHistoryValueDivGp').style.display = 'block';
				var i;
		       var element = document.getElementById('pastHistory11');
	 				for (i=0;i < element.options.length;i++) {
	 			    if (element.options[i].selected) {
	 			    	if (element.options[i].value == 'Others - ') {
	 						document.getElementById('pastHistoryOthersValue').style.display = 'block';
	 					} else {
	 						document.getElementById('pastHistoryOthersValue').style.display = 'none';
	 					}
	 			    }
	 			}
	 		} else {
				document.getElementById('pastHistoryValueDivGp').style.display = 'none';
			}
		}
	 		 
	  	 
	  	function getMultiSelectValue44(select) {
	 		  return [].reduce.call(select.options, function(values, option) {
	 		    option.selected? values.push(option.value) : null;
	 		    return values;
	 		  }, []);
	 		}
		function showValues44(values){
	 		  document.getElementById('distributionValue').value = values.join('\n');
	 		} 	
		function displayGeneralProformaValueDivGp44(val) {
			if (val == 'Scalp - '||val=='Face - '||val=='Upper Limbs - ' ||val=='Trunk - ' ||val=='Lower limbs - ') {
				document.getElementById('distributionValueDivGp').style.display = 'block';
			} else {
				document.getElementById('distributionValueDivGp').style.display = 'none';

			}
	 	} 
		
		
		function getMultiSelectValue4(select) {
	 		  return [].reduce.call(select.options, function(values, option) {
	 		    option.selected? values.push(option.value) : null;
	 		    return values;
	 		  }, []);
	 		}
 		function showValues4(values){
	 		  document.getElementById('mucousMenbraneValue').value = values.join('\n');
	 		} 	
	 	function displayGeneralProformaValueDivGp4(val) {
			 if (val == 'Oral - '||val=='Eyes - ' ||val == 'Nasal - '||val=='Genital - ' ||val == 'Others - ') {
					document.getElementById('mucousMenbraneValueDivGp').style.display = 'block';
					var i;
			       var element = document.getElementById('mucousMembrane');
		 				for (i=0;i < element.options.length;i++) {
		 			    if (element.options[i].selected) {
		 			    	if (element.options[i].value == 'Others - ') {
		 						document.getElementById('mucousMenbraneOthersValue').style.display = 'block';
		 					} else {
		 						document.getElementById('mucousMenbraneOthersValue').style.display = 'none';
		 					}
		 			    }
		 			}
		 		} else {
					document.getElementById('mucousMenbraneValueDivGp').style.display = 'none';
				}
			}	  
			 
		 	
	  	function getMultiSelectValue5(select) {
	 		  return [].reduce.call(select.options, function(values, option) {
	 		    option.selected? values.push(option.value) : null;
	 		    return values;
	 		  }, []);
	 		}
	 	function showValues5(values){
	 		  document.getElementById('hairValue').value = values.join('\n');
	 		} 	
	 	function displayGeneralProformaValueDivGp5(val) {
	 		 if (val == 'Normal - '||val=='Diffuse alopecia - '||val=='Alopecia Areata - '|| val=='Androgenic Alopecia - '|| val=='Alopecia Totalis Alopecia Universalis - '|| val=='Hirsutism - '|| val=='Scarring Alopecia - '||val=='Others - ' ) {
					document.getElementById('hairValueDivGp').style.display = 'block';
					var i;
			       var element = document.getElementById('hair');
		 				for (i=0;i < element.options.length;i++) {
		 			    if (element.options[i].selected) {
		 			    	if (element.options[i].value == 'Others - ') {
		 						document.getElementById('hairOthersValue').style.display = 'block';
		 					} else {
		 						document.getElementById('hairOthersValue').style.display = 'none';
		 					}
		 			    }
		 			}
		 		} else {
					document.getElementById('hairValueDivGp').style.display = 'none';
				}
			}	
	 		 
	  	 
		function getMultiSelectValue6(select) {
	 		  return [].reduce.call(select.options, function(values, option) {
	 		    option.selected? values.push(option.value) : null;
	 		    return values;
	 		  }, []);
	 		}
		function showValues6(values){
	 		  document.getElementById('nailsValue').value = values.join('\n');
	 		} 	
		function displayGeneralProformaValueDivGp6(val) {
			 if (val == 'Normal - '|| val=='Onycholysis - '||val=='Onychomadesis - '||val=='Paronychia - '||val=='Dystrophy - '||val=='Pitting - '||val=='Longitudinal melanonychia - '||val=='Subungual hyperkeratosis - '||val=='Others - ') {
					document.getElementById('nailsValueDivGp').style.display = 'block';
					var i;
			       var element = document.getElementById('nails');
		 				for (i=0;i < element.options.length;i++) {
		 			    if (element.options[i].selected) {
		 			    	if (element.options[i].value == 'Others - ') {
		 						document.getElementById('nailsOthersValue').style.display = 'block';
		 					} else {
		 						document.getElementById('nailsOthersValue').style.display = 'none';
		 					}
		 			    }
		 			}
		 		} else {
					document.getElementById('nailsValueDivGp').style.display = 'none';
				}
			}	
			 
			 
	  	function getMultiSelectValue7(select) {
	 		  return [].reduce.call(select.options, function(values, option) {
	 		    option.selected? values.push(option.value) : null;
	 		    return values;
	 		  }, []);
	 		}
		function showValues7(values){
	 		  document.getElementById('systemIllnessValue').value = values.join('\n');
	 		} 	
		function displayGeneralProformaValueDivGp7(val) {
		 	 if (val == 'CVS - '|| val=='CNS - '|| val=='GIT - '|| val=='Musculoskeletal System - '|| val=='Pulmonary - '|| val=='Absent - '|| val=='Others - ') {
		 	 		document.getElementById('systemIllnessValueDivGp').style.display = 'block';
					var i;
			       var element = document.getElementById('systemIllness');
		 				for (i=0;i < element.options.length;i++) {
		 			    if (element.options[i].selected) {
		 			    	if (element.options[i].value == 'Others - ') {
		 						document.getElementById('systemIllnessOthersValue').style.display = 'block';
		 					} else {
		 						document.getElementById('systemIllnessOthersValue').style.display = 'none';
		 					}
		 			    }
		 			}
		 		} else {
					document.getElementById('systemIllnessValueDivGp').style.display = 'none';
				}
			}	
			 
			 
	 	 function getMultiSelectValue8(select) {
	 		  return [].reduce.call(select.options, function(values, option) {
	 		    option.selected? values.push(option.value) : null;
	 		    return values;
	 		  }, []);
	 		}
			function showValues8(values){
	 		  document.getElementById('signsValue').value = values.join('\n');
	 		} 	
		 function displayGeneralProformaValueDivGp8(val) {
			 if (val == 'Auspitz - '|| val=='Bullae Spread - '|| val=='Nikolsky - '|| val=='Carpet Tack - '|| val=='Others signs - '|| val=='Others - ' ) {
		 	 		document.getElementById('signsValueDivGp').style.display = 'block';
					var i;
			       var element = document.getElementById('signs');
		 				for (i=0;i < element.options.length;i++) {
		 			    if (element.options[i].selected) {
		 			    	if (element.options[i].value == 'Others - ') {
		 						document.getElementById('signsOthersValue').style.display = 'block';
		 					} else {
		 						document.getElementById('signsOthersValue').style.display = 'none';
		 					}
		 			    }
		 			}
		 		} else {
					document.getElementById('signsValueDivGp').style.display = 'none';
				}
			}	
		 
		 
		  	function getMultiSelectValueLp(select) {
		   		  return [].reduce.call(select.options, function(values, option) {
			 		    option.selected? values.push(option.value) : null;
			 		    return values;
			 		  }, []);
			 		}
		  	function showValuesLp(values){
			 		  document.getElementById('presentingComplaints').value = values.join('\n');
			 		} 	
			function displayLeprosyProformaValueDivLp(val) {
					if (val == 'Itching - '|| val == 'Wheals - '|| val == 'Scaling - '|| val == 'Oozing And Crusting - '
						||val=='Pain - '||val=='Burning Sensation - '||val=='Fever - '||val=='Numbness - '||val=='Parasthesia - ' 
						||val=='Weakness of Limbs - '||val=='Plantar Ulcer - '||val=='Dry Skin - '||val=='Motor Palsy - '||val=='Others - '
						
					) {
						document.getElementById('presentingComplaintsValueDivLp').style.display = 'block';
						var i;
				       var element = document.getElementById('presentingComplaintsLp');
			 				for (i=0;i < element.options.length;i++) {
			 			    if (element.options[i].selected) {
			 			    	if (element.options[i].value == 'Others - ') {
			 						document.getElementById('presentingComplaintsValue').style.display = 'block';
			 					} else {
			 						document.getElementById('presentingComplaintsValue').style.display = 'none';
			 					}
			 			    }
			 			}
			 		} else {
						document.getElementById('presentingComplaintsValueDivLp').style.display = 'none';
					}
				} 
			  	
			
	 		function getMultiSelectValuePt(select) {
		 		  return [].reduce.call(select.options, function(values, option) {
		 		    option.selected? values.push(option.value) : null;
		 		    return values;
		 		  }, []);
		 		}
			function showValuesPt(values){
		 		  document.getElementById('distributionValue').value = values.join('\n');
		 		} 	
			function displayPhototherapyProformaValueDivPt(val) {
				if (val == 'Scalp - '|| val=='Face - '||val=='Upper Limbs - ' ||val=='Trunk - ' ||val=='Lower limbs - ') {
					document.getElementById('distributionValueDivPt').style.display = 'block';
				} else {
					document.getElementById('distributionValueDivPt').style.display = 'none';

				}
		 	} 
			
			
	 		function getMultiSelectValuePt2(select) {
		 		  return [].reduce.call(select.options, function(values, option) {
		 		    option.selected? values.push(option.value) : null;
		 		    return values;
		 		  }, []);
		 		}
		 	function showValuesPt2(values){
		 		  document.getElementById('hair').value = values.join('\n');
		 		} 	
		 	function displayPhototherapyProformaValueDivPt2(val) {
		 		 if (val == 'Normal - '|| val=='Diffuse alopecia - '||val=='Alopecia Areata - '|| val=='Androgenic Alopecia - '|| val=='Alopecia Totalis Alopecia Universalis - '|| val=='Hirsutism - '|| val=='Scarring Alopecia - '||val=='Others - ' ) {
						document.getElementById('hairValueDivPt').style.display = 'block';
						var i;
				       var element = document.getElementById('hairPt');
			 				for (i=0;i < element.options.length;i++) {
			 			    if (element.options[i].selected) {
			 			    	if (element.options[i].value == 'Others - ') {
			 						document.getElementById('hairValue').style.display = 'block';
			 					} else {
			 						document.getElementById('hairValue').style.display = 'none';
			 					}
			 			    }
			 			}
			 		} else {
						document.getElementById('hairValueDivPt').style.display = 'none';
					}
				}
			
 
		 	function getMultiSelectValuePt3(select) {
		 		  return [].reduce.call(select.options, function(values, option) {
		 		    option.selected? values.push(option.value) : null;
		 		    return values;
		 		  }, []);
		 		}
			function showValuesPt3(values){
		 		  document.getElementById('nails').value = values.join('\n');
		 		} 	
			function displayPhototherapyProformaValueDivPt3(val) {
				 if (val == 'Normal - '|| val=='Onycholysis - '||val=='Onychomadesis - '||val=='Paronychia - '||val=='Dystrophy - '||val=='Pitting - '||val=='Longitudinal melanonychia - '||val=='Subungual hyperkeratosis - '||val=='Others - ') {
						document.getElementById('nailsValueDivPt').style.display = 'block';
						var i;
				       var element = document.getElementById('ptNails');
			 				for (i=0;i < element.options.length;i++) {
			 			    if (element.options[i].selected) {
			 			    	if (element.options[i].value == 'Others - ') {
			 						document.getElementById('nailsValue').style.display = 'block';
			 					} else {
			 						document.getElementById('nailsValue').style.display = 'none';
			 					}
			 			    }
			 			}
			 		} else {
						document.getElementById('nailsValueDivPt').style.display = 'none';
					}
				}	
			
function yearValidationDermo(id1,id2)
{
	var patientAge=document.getElementById('patientAge').value;
	var durationOfIllness = document.getElementById(id1).value;
	var durationParameter = document.getElementById(id2).value;
	var durationOfIllnessInDays='';
	var ageInDays = patientAge * 365;
	if(durationParameter=='Days'){
		if(parseInt(durationOfIllness) > parseInt(ageInDays)){
			alert("Year should be less than Patient's age!!");
			document.getElementById(id1).value="";
			document.getElementById(id2).value="";
			return;		
		}
	} 
	if(durationParameter=='Weeks'){
		 durationOfIllnessInDays = durationOfIllness * 7;
		if(parseInt(durationOfIllnessInDays) > parseInt(ageInDays)){
			alert("Year should be less than Patient's age!!");
			document.getElementById(id1).value="";
			document.getElementById(id2).value="";
			return;		
		}
	} 
	if(durationParameter=='Months'){
		durationOfIllnessInDays = durationOfIllness * 30;
		if(parseInt(durationOfIllnessInDays) > parseInt(ageInDays)){
			alert("Year should be less than Patient's age!!");
			document.getElementById(id1).value="";
			document.getElementById(id2).value="";
			return;		
		}
	} 
	if(durationParameter=='Years'){
		durationOfIllnessInDays = durationOfIllness * 365;
		if(parseInt(durationOfIllnessInDays) > parseInt(ageInDays)){
			alert("Year should be less than Patient's age!!");
			document.getElementById(id1).value="";
			document.getElementById(id2).value="";
			return;		
		}
	}
		
}

//Added By Swarup 08/02/2018
function openPopupForPatientPrescriptionForOpLite(visitNo, hinId, visitId, csrf) {

	if (visitNo >= 1) {
		
		var url = "/hms/hms/opd?method=showPatientPreviousPrescription&visitNo="
				+ visitNo
				+ "&hinId="
				+ hinId
				+ "&visitId="
				+ visitId
				+ "&opdType="
				+ "LP"
				+ "&"
				+ csrfTokenName + "=" + csrfTokenValue;
		newwindow = window.open(url, 'opd_window',
				"height=420,width=1050,status=1,scrollbars=yes");
	} else {
		alert("This Is Patient's first Visit.")
	}

}

function openPopupForPatientPrescriptionForOpDetailed(visitNo, hinId, visitId, csrf) {

	if (visitNo >= 1) {
		
		var url = "/hms/hms/opd?method=showPatientPreviousPrescription&visitNo="
				+ visitNo
				+ "&hinId="
				+ hinId
				+ "&visitId="
				+ visitId
				+ "&opdType="
				+ "LP"
				+ "&"
				+ csrfTokenName + "=" + csrfTokenValue;
		newwindow = window.open(url, 'opd_window',
				"height=420,width=1050,status=1,scrollbars=yes");
	} else {
		alert("This Is Patient's first Visit.")
	}

}

function waitGainCalculation() {
	
	var preHdWeight = document.getElementById("preHdWeight").value;
	var postHdWeight = document.getElementById("postHdWeight").value;	
	var weightgain = postHdWeight - preHdWeight;
	document.getElementById("weightGain").value=weightgain.toFixed(2);
	
}

function vitalDetails(hinId) {
	var height = 400;
	var width = 900;
	var left = (screen.width / 2) - (width / 2);
	var top = (screen.height / 2) - (height / 2);
	window.open("/hms/hms/opd?method=getVitalDetails&hinId=" + hinId,
			"Vital Details", "scrollbars=no, status = no, height = " + height
					+ ", width =" + width + ",top=" + top + ", left=" + left)
}

function patientDetailsHemoDialysis(hinId) {
	var height = 400;
	var width = 900;
	var left = (screen.width / 2) - (width / 2);
	var top = (screen.height / 2) - (height / 2);
	window.open("/hms/hms/opd?method=getpatientDetailsHemoDialysis&hinId=" + hinId,
			"Vital Details", "scrollbars=no, status = no, height = " + height
					+ ", width =" + width + ",top=" + top + ", left=" + left)
}

function openPopupForViewImages(csrf, hinId) {
	window.open("/hms/hms/opd?method=viewENTExaminationImages&hinId="
							+ hinId + "&" + csrf + "&" + csrfTokenName + "="
							+ csrfTokenValue,
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
}

function openPopupForFamilyTreeEntry(hinId)  {
/*	window
			.open(
					"/hms/hms/budget?method=showFamilyTree&hinId=" + hinId
							,
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");*/
	
/*	var url = '/hms/hms/opd?method=showPopUpPresentComplaint&' + csrf + '&'
	+ csrfTokenName + '=' + csrfTokenValue;*/
popwindow("/hms/hms/opd?method=showFamilyTreeEntryJsp&hinId=" + hinId);
	
}
function openPopupForFamilyTree(hinId)  {
	
	popwindow("/hms/hms/opd?method=showFamilyTree&hinId=" + hinId);
}


function addRowTree(){
    var tbl = document.getElementById('TreeTable');
    var lastRow = tbl.rows.length;
    var iteration = lastRow;
    var row = tbl.insertRow(lastRow);
    var hdb = document.getElementById('treeCount');
    iteration = parseInt(hdb.value) + 1;
    hdb.value = iteration;

    var cellRight1 = row.insertCell(0);
    var e1 = document.createElement('input');
    e1.type = 'checkbox';
    e1.name = 'TreeRadio' + iteration;
    e1.id = 'TreeRadio' + iteration;
    e1.className = 'radioCheck';
    cellRight1.appendChild(e1);
    
    
    var cellRight1 = row.insertCell(1);
    var e1 = document.createElement('input');
    e1.type = 'text';
    e1.name = 'name' + iteration;
    e1.id = 'name' + iteration;
    cellRight1.appendChild(e1);    
    
    
  /*  var cellRight1 = row.insertCell(2);
    var e1 = document.createElement('input');
    e1.type = 'text';
    e1.name = 'rel2' + iteration;
    e1.id = 'rel2' + iteration;
    e1.maxLength = "256";
    e1.style.width = "150px";
    cellRight1.appendChild(e1);*/

    var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'rel' + iteration;
	e1.id = 'rel' + iteration;
	e1.options[0] = new Option('Select', '');
	for (var i = 0; i < relArray.length; i++) {
		e1.options[i + 1] = new Option(relArray[i][1], relArray[i][0]);
	}
	  
	  e1.onchange = function() {
	    	openRelationGenderValid(this.value, iteration);familyMembersDuplicacyCheck(this.value, iteration);
		};
	    cellRight1.appendChild(e1);
   
    
    var cellRight1 = row.insertCell(3);
    var e1 = document.createElement('select');
    //e1.type = 'text';
    e1.options[0] = new Option('Select', '');    
    e1.options[1] = new Option('Female', 'F');    
    e1.options[2] = new Option('Male', 'M');    
    e1.name = 'gen' + iteration;
    e1.id = 'gen' + iteration;
    e1.disabled =true;
    e1.maxLength = "256";
    e1.className="smallnew";
    cellRight1.appendChild(e1);
    
    var e2 = document.createElement('input');
    e2.type = 'hidden';
    e2.name = 'genVal' + iteration;
    e2.id = 'genVal' + iteration;
    e2.maxLength = "1";
    cellRight1.appendChild(e2);
    
    var cellRight1 = row.insertCell(4);
    var e1 = document.createElement('input');
    e1.type = 'text';
    e1.name = 'diag' + iteration;
    e1.id = 'diag' + iteration;
    e1.maxLength = "50";
    e1.style.width = "187px";
    cellRight1.appendChild(e1);
    
    var cellRight1 = row.insertCell(5);
    var e1 = document.createElement('select');
    //e1.type = 'textarea';
        
    e1.options[0] = new Option('Active','y');    
    
    e1.name = 'Stat' + iteration;
    e1.id = 'Stat' + iteration;
    e1.maxLength = "50";
    e1.className="smallnew";
    cellRight1.appendChild(e1);
    
    
}


function removeRowTree() {
    var tbl = document.getElementById('TreeTable');
    var lastRow = tbl.rows.length;
    var hdb = document.getElementById('treeCount');
    var iteration = parseInt(hdb.value);
    var totalSelected = 0;
    for (var i = 0; i <= iteration; i++) {
        if (document.getElementById("TreeRadio" + i) != null
                && (typeof document.getElementById("TreeRadio" + i).checked) != 'TreeRadio'
                && document.getElementById("TreeRadio" + i).checked) {
            totalSelected = totalSelected + 1;
        }
    }
    if (totalSelected == 0) {
        alert('Please select atleast 1 row to delete');
    } else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
        alert('You can not delete all Row.');
    } else if (lastRow > 2) {
        for (var i = 0; i <= iteration; i++) {
            if (document.getElementById("TreeRadio" + i) != null
                    && (typeof document.getElementById("TreeRadio" + i).checked) != 'undefined'
                    && document.getElementById("TreeRadio" + i).checked) {
                var deleteRow = document.getElementById("TreeRadio" + i).parentNode.parentNode;
                document.getElementById("TreeRadio" + i).parentNode.parentNode.parentNode
                        .removeChild(deleteRow);
            }
        }
    }
}

function openRelationGenderValid(id,inc){
	
	if(id!=""){
	for (var k = 0; k< relTreeArray.length; k++) {
		if(relTreeArray[k][0] ==id)
			{
			 document.getElementById("gen" + inc).value= relTreeArray[k][1];
			 document.getElementById("genVal" + inc).value= relTreeArray[k][1];
			 break;
			
			}
	}
	}
	else {
		 document.getElementById("gen" + inc).value= "";
	     document.getElementById("genVal" + inc).value= "";}
	
	
}


function familyMembersDuplicacyCheck(relId,inc)
{
	
     total = document.getElementById("treeCount").value;
	for(var i=0;i<total;i++)
		{
		if( (validMultipleMembers.indexOf(relId) > -1)  && i!=inc && document.getElementById("rel"+i)!=null && document.getElementById("rel"+i).value==relId)
			{
			alert("Already selected");
			document.getElementById("rel"+inc).value ="";
			return;
			}
		}
}

function checkFamilyTreeFields()
{
	
	    var hdb = document.getElementById('treeCount').value;
	    for (var i = 0; i <= hdb; i++) {
	

	    if(document.getElementById('name'+ i)!=null && document.getElementById('name'+ i).value !=""){
	    	
	    	if((document.getElementById('rel'+ i)!=null && document.getElementById('rel'+ i).value=="") ||( document.getElementById('genVal'+ i)!=null) && (document.getElementById('gen'+ i)!=null && document.getElementById('genVal'+ i).value=="")){
	        alert("Enter Relation and Gender for all rows");
	        return false;
	    	}
	
           }
	    }
	    
	 return true;
	    	
}

function openPopupForLabResultsForSubParameter(csrf,investigationId,resultDate,hinId,testTime) {
	
	window.open("/hms/hms/opd?method=displaySubParameterResult&hinId="+ hinId+"&resultDate="+ resultDate+"&resultTime="+testTime+"&investigationId="+ investigationId+"&"+ csrf + "&" + csrfTokenName + "=" + csrfTokenValue,
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
}
