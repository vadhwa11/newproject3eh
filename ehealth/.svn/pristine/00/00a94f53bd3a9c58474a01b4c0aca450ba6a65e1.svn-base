function addUSGRow() {

	var tbl = document.getElementById('usgTable');
	var hdbTabIndex = parseInt(document.getElementById('usghdbTabIndex').value) + 1;
	document.getElementById('usghdbTabIndex').value = hdbTabIndex;

	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('usghdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'usgitemRadio' + iteration;
	e1.id = 'usgitemRadio' + iteration;
	e1.className = 'radioCheck';
	e1.tabIndex = hdbTabIndex + "1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'usgDate' + iteration;
	e1.id = 'usgDate' + iteration;
	e1.size = '8';
	e1.tabIndex = hdbTabIndex + "2";
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('usgDate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'usgFld' + iteration;
	e1.id = 'usgFld' + iteration;
	e1.className = "opdMainTextArea yellowBackground";
	// e1.size = '10';
	e1.tabIndex = hdbTabIndex + "3";
	cellRight1.appendChild(e1);

}

function addRow1() {

	var tbl = document.getElementById('ftTable');
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
	e1.tabIndex = hdbTabIndex + "1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ftdate' + iteration;
	e1.id = 'ftdate' + iteration;
	e1.size = '8';
	e1.tabIndex = hdbTabIndex + "2";
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('ftdate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ftGA1' + iteration;
	e1.id = 'ftGA1' + iteration;
	e1.className = "opdTextBoxTSmall";
	e1.placeholder = "Weeks";
	e1.setAttribute('validate', 'Weeks,num,no');
	e1.tabIndex = hdbTabIndex + "3";
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ftGA2' + iteration;
	e1.id = 'ftGA2' + iteration;
	e1.setAttribute('validate', 'Days,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.placeholder = "Days";
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ftsystolic' + iteration;
	e1.id = 'ftsystolic' + iteration;
	e1.setAttribute('validate', 'Systolic,num,no');
	e1.className = "allownumericwithoutdecimal textSmall";
	e1.placeholder = "Systolic";
	e1.tabIndex = hdbTabIndex + "5";
	cellRight1.appendChild(e1);

	var e2 = document.createElement('label');
	e2.innerHTML = "/";
	e2.className = "smallAuto autoSpace";
	cellRight1.appendChild(e2);

	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name = 'ftdiastolic' + iteration;
	e3.id = 'ftdiastolic' + iteration;
	e1.setAttribute('validate', 'Diastolic,num,no');
	e3.className = "allownumericwithoutdecimal textSmall";
	e3.placeholder = "Diastolic";
	e3.tabIndex = hdbTabIndex + "6";
	cellRight1.appendChild(e3);

	var e4 = document.createElement('label');
	e4.innerHTML = "mm&nbsp;Hg";
	e4.className = "smallAuto autoSpace";
	cellRight1.appendChild(e4);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'ftPA' + iteration;
	e1.id = 'ftPA' + iteration;
	// 1.className = "opdTextBoxTSmall";
	// e1.size = '10';
	e1.tabIndex = hdbTabIndex + "7";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'ftPV' + iteration;
	e1.id = 'ftPV' + iteration;
	// e1.className = "opdTextBoxTSmall";
	// e1.size = '10';
	e1.tabIndex = hdbTabIndex + "8";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ftWeight' + iteration;
	e1.id = 'ftWeight' + iteration;
	e1.setAttribute('validate', 'Weight,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.size = '10';
	e1.tabIndex = hdbTabIndex + "9";
	cellRight1.appendChild(e1);

	getWeight('ftWeight' + iteration);
}

function addRow2() {
	var tbl = document.getElementById('stTable');
	var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex1').value) + 1;
	document.getElementById('hdbTabIndex1').value = hdbTabIndex;

	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdb1');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio1' + iteration;
	e1.id = 'itemRadio1' + iteration;
	e1.className = 'radioCheck';
	e1.tabIndex = hdbTabIndex + "1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stdate' + iteration;
	e1.id = 'stdate' + iteration;
	e1.size = '8';
	e1.tabIndex = hdbTabIndex + "2";
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';
	img1.onclick = function(event) {
		var obj = document.getElementById('stdate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};
	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stGA1' + iteration;
	e1.id = 'stGA1' + iteration;
	e1.setAttribute('validate', 'Weeks,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.placeholder = "Weeks";
	e1.tabIndex = hdbTabIndex + "3";
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stGA2' + iteration;
	e1.id = 'stGA2' + iteration;
	e1.setAttribute('validate', 'Days,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.placeholder = "Days";
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stsystolic' + iteration;
	e1.id = 'stsystolic' + iteration;
	e1.setAttribute('validate', 'Systolic,num,no');
	e1.className = "allownumericwithoutdecimal textSmall";
	e1.placeholder = "Systolic";
	e1.tabIndex = hdbTabIndex + "5";
	cellRight1.appendChild(e1);

	var e2 = document.createElement('label');
	e2.innerHTML = "/";
	e2.className = "smallAuto autoSpace";
	cellRight1.appendChild(e2);

	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name = 'stdiastolic' + iteration;
	e3.id = 'stdiastolic' + iteration;
	e1.setAttribute('validate', 'Diastolic,num,no');
	e3.className = "allownumericwithoutdecimal textSmall";
	e3.placeholder = "Diastolic";
	e3.tabIndex = hdbTabIndex + "6";
	cellRight1.appendChild(e3);

	var e4 = document.createElement('label');
	e4.innerHTML = "mm&nbsp;Hg";
	e4.className = "smallAuto autoSpace";
	cellRight1.appendChild(e4);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'stPA' + iteration;
	e1.id = 'stPA' + iteration;
	// e1.className = "opdTextBoxTSmall";
	// e1.size = '10';
	e1.tabIndex = hdbTabIndex + "7";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stWeight' + iteration;
	e1.id = 'stWeight' + iteration;
	e1.setAttribute('validate', 'Weight,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.size = '10';
	e1.tabIndex = hdbTabIndex + "8";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stUrinAl' + iteration;
	e1.id = 'stUrinAl' + iteration;
	e1.setAttribute('validate', 'Urine Albumin,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.size = '10';
	e1.tabIndex = hdbTabIndex + "9";
	cellRight1.appendChild(e1);

	getWeight('stWeight' + iteration);
}

function addRow3() {

	var tbl = document.getElementById('ttTable');
	var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex2').value) + 1;
	document.getElementById('hdbTabIndex2').value = hdbTabIndex;

	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdb2');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio2' + iteration;
	e1.id = 'itemRadio2' + iteration;
	e1.className = 'radioCheck';
	e1.tabIndex = hdbTabIndex + "1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttdate' + iteration;
	e1.id = 'ttdate' + iteration;
	e1.size = '8';
	e1.tabIndex = hdbTabIndex + "2";
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';
	img1.onclick = function(event) {
		var obj = document.getElementById('ttdate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};
	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttGA1' + iteration;
	e1.id = 'ttGA1' + iteration;
	e1.setAttribute('validate', 'Weeks,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.placeholder = "Weeks";
	e1.tabIndex = hdbTabIndex + "3";
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttGA2' + iteration;
	e1.id = 'ttGA2' + iteration;
	e1.setAttribute('validate', 'Days,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.placeholder = "Days";
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttsystolic' + iteration;
	e1.id = 'ttsystolic' + iteration;
	e1.setAttribute('validate', 'Systolic,num,no');
	e1.className = "allownumericwithoutdecimal textSmall";
	e1.placeholder = "Systolic";
	e1.tabIndex = hdbTabIndex + "5";
	cellRight1.appendChild(e1);

	var e2 = document.createElement('label');
	e2.innerHTML = "/";
	e2.className = "smallAuto autoSpace";
	cellRight1.appendChild(e2);

	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name = 'ttdiastolic' + iteration;
	e3.id = 'ttdiastolic' + iteration;
	e1.setAttribute('validate', 'Diastolic,num,no');
	e3.className = "allownumericwithoutdecimal textSmall";
	e3.placeholder = "Diastolic";
	e3.tabIndex = hdbTabIndex + "6";
	cellRight1.appendChild(e3);

	var e4 = document.createElement('label');
	e4.innerHTML = "mm&nbsp;Hg";
	e4.className = "smallAuto autoSpace";
	cellRight1.appendChild(e4);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'ttPA' + iteration;
	e1.id = 'ttPA' + iteration;
	// e1.className = "opdTextBoxTSmall";
	// e1.size = '10';
	e1.tabIndex = hdbTabIndex + "7";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttWeight' + iteration;
	e1.id = 'ttWeight' + iteration;
	e1.setAttribute('validate', 'Weight,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.size = '10';
	e1.tabIndex = hdbTabIndex + "8";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttUrinAl' + iteration;
	e1.id = 'ttUrinAl' + iteration;
	e1.setAttribute('validate', 'Urine Albumin,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.size = '10';
	e1.tabIndex = hdbTabIndex + "9";
	cellRight1.appendChild(e1);

	getWeight('ttWeight' + iteration);
}

function addRow4() {

	var tbl = document.getElementById('f4tTable');
	var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex3').value) + 1;
	document.getElementById('hdbTabIndex3').value = hdbTabIndex;

	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdb3');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio3' + iteration;
	e1.id = 'itemRadio3' + iteration;
	e1.className = 'radioCheck';
	e1.tabIndex = hdbTabIndex + "1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'f4tdate' + iteration;
	e1.id = 'f4tdate' + iteration;
	e1.size = '8';
	e1.tabIndex = hdbTabIndex + "2";
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';
	img1.onclick = function(event) {
		var obj = document.getElementById('f4tdate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};
	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'f4tGA1' + iteration;
	e1.id = 'f4tGA1' + iteration;
	e1.setAttribute('validate', 'Weeks,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.placeholder = "Weeks";
	e1.tabIndex = hdbTabIndex + "3";
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'f4tGA2' + iteration;
	e1.id = 'f4tGA2' + iteration;
	e1.setAttribute('validate', 'Days,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.placeholder = "Days";
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'f4tsystolic' + iteration;
	e1.id = 'f4tsystolic' + iteration;
	e1.setAttribute('validate', 'Systolic,num,no');
	e1.className = "allownumericwithoutdecimal textSmall";
	e1.placeholder = "Systolic";
	e1.tabIndex = hdbTabIndex + "5";
	cellRight1.appendChild(e1);

	var e2 = document.createElement('label');
	e2.innerHTML = "/";
	e2.className = "smallAuto autoSpace";
	cellRight1.appendChild(e2);

	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name = 'f4tdiastolic' + iteration;
	e3.id = 'f4tdiastolic' + iteration;
	e1.setAttribute('validate', 'Diastolic,num,no');
	e3.className = "allownumericwithoutdecimal textSmall";
	e3.placeholder = "Diastolic";
	e3.tabIndex = hdbTabIndex + "6";
	cellRight1.appendChild(e3);

	var e4 = document.createElement('label');
	e4.innerHTML = "mm&nbsp;Hg";
	e4.className = "smallAuto autoSpace";
	cellRight1.appendChild(e4);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'f4tPA' + iteration;
	e1.id = 'f4tPA' + iteration;
	// e1.className = "opdTextBoxTSmall";
	// e1.size = '10';
	e1.tabIndex = hdbTabIndex + "7";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'f4tWeight' + iteration;
	e1.id = 'f4tWeight' + iteration;
	e1.setAttribute('validate', 'Weight,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.size = '10';
	e1.tabIndex = hdbTabIndex + "8";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'f4tUrinAl' + iteration;
	e1.id = 'f4tUrinAl' + iteration;
	e1.setAttribute('validate', 'Urine Albumin,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.size = '10';
	e1.tabIndex = hdbTabIndex + "9";
	cellRight1.appendChild(e1);

	getWeight('f4tWeight' + iteration);

}

function removeRow1(form) {
	var tbl = document.getElementById(form);
	var lastRow = tbl.rows.length;
	var hdb;
	var radio = "";
	if (form == 'ftTable') {
		hdb = document.getElementById('hdb');
		radio = "itemRadio";
	}
	if (form == 'stTable') {
		hdb = document.getElementById('hdb1');
		radio = "itemRadio1";
	}
	if (form == 'ttTable') {
		hdb = document.getElementById('hdb2');
		radio = "itemRadio2";
	}

	if (form == 'f4tTable') {
		hdb = document.getElementById('hdb3');
		radio = "itemRadio3";
	}
	if (form == 'usgTable') {
		hdb = document.getElementById('usghdb');
		radio = "usgitemRadio";
	}

	if (form == 'opdAntTable') {
		hdb = document.getElementById('opdhdb');
		radio = "itemRadioAnt";
	}

	if (form == 'opdMensHistTable') {
		hdb = document.getElementById('hdbMH');
		radio = "itemRadioMH";
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

function usgValid() {
	var result = false;
	var count = 0;
	var iteration;
	var hdb = document.getElementById('usghdb');
	iteration = parseInt(hdb.value) + 1;

	var sg, usgDet;

	for (var i = 0; i < iteration; i++) {
		if (document.getElementById('usgDate' + i) != null) {
			sg = document.getElementById('usgDate' + i).value;
		}
		if (document.getElementById('usgFld' + i) != null) {
			usgDet = document.getElementById('usgFld' + i).value;
		}

		if (sg != "") {
			if (usgDet == "") {
				count = 1;

			} else if (sg != "" && usgDet != "") {
				count = 2;
			}
		} else {
			count = 0;
		}
		if (count == 1) {
			break;
		}

	}

	if (count == 1) {
		alert("please enter usg details");
		$("#usgCount").val(0);
		result = false;
	}
	if (count == 0) {
		$("#usgCount").val(0);
		result = true;
	}
	if (count == 2) {
		$("#usgCount").val(1);
		result = true;
	}

	return result;
}

// first trimester validation
function ftTrimValid() {
	var result = false;
	var count = 0;
	var iteration;
	var hdb = document.getElementById('hdb');
	iteration = parseInt(hdb.value) + 1;
	var sg, ga1, ga2, bp1, bp2, pv, pa, weight;

	// var sg1 = document.getElementById('ftDate' + 0).value;
	// alert("sg "+sg1);
	for (var i = 0; i < iteration; i++) {
		if (document.getElementById('ftdate' + i) != null) {
			sg = document.getElementById('ftdate' + i).value;
		}
		if (document.getElementById('ftGA1' + i) != null) {
			ga1 = document.getElementById('ftGA1' + i).value;
		}
		if (document.getElementById('ftGA2' + i) != null) {
			ga2 = document.getElementById('ftGA2' + i).value;
		}

		if (document.getElementById('ftsystolic' + i) != null) {
			bp1 = document.getElementById('ftsystolic' + i).value;
		}
		if (document.getElementById('ftdiastolic' + i) != null) {
			bp2 = document.getElementById('ftdiastolic' + i).value;
		}
		if (document.getElementById('ftPA' + i) != null) {
			pa = document.getElementById('ftPA' + i).value;
		}
		if (document.getElementById('ftPV' + i) != null) {
			pv = document.getElementById('ftPV' + i).value;
		}
		if (document.getElementById('ftWeight' + i) != null) {
			weight = document.getElementById('ftWeight' + i).value;
		}

		if (sg != "") {

			if (ga1 == "" || ga2 == "" || bp1 == "" || bp2 == "" || pa == ""
					|| pv == "" || weight == "") {

				count = 1;

			}
		}
		if (sg != "" && ga1 != "" && ga2 != "" && bp1 != "" && bp2 != ""
				&& pa != "" && pv != "" && weight != "") {
			count = 2;

		}
		if (sg == "" && ga1 == "" && ga2 == "" && bp1 == "" && bp2 == ""
				&& pa == "" && pv == "" && weight == "") {
			count = 0;

		}

		if (count == 1) {
			break;
		}

	}

	if (count == 1) {
		alert("please enter all details in First Trimester");
		$("#ftCount").val(0);
		result = false;
	}
	if (count == 0) {
		$("#ftCount").val(0);
		result = true;
	}
	if (count == 2) {
		$("#ftCount").val(1);
		result = true;
	}

	return result;
}

// second trimester validation
function stTrimValid() {
	var result = false;
	var count = 0;
	var iteration;
	var sg, ga1, ga2, bp1, bp2, pv, pa, weight;
	var hdb = document.getElementById('hdb1');
	iteration = parseInt(hdb.value) + 1;

	for (var i = 0; i < iteration; i++) {
		if (document.getElementById('stdate' + i) != null) {
			sg = document.getElementById('stdate' + i).value;
		}
		if (document.getElementById('stGA1' + i) != null) {
			ga1 = document.getElementById('stGA1' + i).value;
		}
		if (document.getElementById('stGA2' + i) != null) {
			ga2 = document.getElementById('stGA2' + i).value;
		}

		if (document.getElementById('stsystolic' + i) != null) {
			bp1 = document.getElementById('stsystolic' + i).value;
		}
		if (document.getElementById('stdiastolic' + i) != null) {
			bp2 = document.getElementById('stdiastolic' + i).value;
		}
		if (document.getElementById('stPA' + i) != null) {
			pa = document.getElementById('stPA' + i).value;
		}
		if (document.getElementById('stUrinAl' + i) != null) {
			pv = document.getElementById('stUrinAl' + i).value;
		}
		if (document.getElementById('stWeight' + i) != null) {
			weight = document.getElementById('stWeight' + i).value;
		}

		if (sg != "") {

			if (ga1 == "" || ga2 == "" || bp1 == "" || bp2 == "" || pa == ""
					|| pv == "" || weight == "") {

				count = 1;

			}
		}
		if (sg != "" && ga1 != "" && ga2 != "" && bp1 != "" && bp2 != ""
				&& pa != "" && pv != "" && weight != "") {
			count = 2;

		}
		if (sg == "" && ga1 == "" && ga2 == "" && bp1 == "" && bp2 == ""
				&& pa == "" && pv == "" && weight == "") {
			count = 0;

		}
		if (count == 1) {
			break;
		}
	}
	if (count == 1) {
		alert("please enter all details in Second Trimester");
		$("#stCount").val(0);
		result = false;
	}
	if (count == 0) {
		$("#stCount").val(0);
		result = true;
	}
	if (count == 2) {
		$("#stCount").val(1);
		result = true;
	}

	return result;
}

// third trimester validation
function ttTrimValid() {
	var result = false;
	var count = 0;
	var iteration;
	var sg, ga1, ga2, bp1, bp2, pv, pa, weight;
	var hdb = document.getElementById('hdb2');
	iteration = parseInt(hdb.value) + 1;

	for (var i = 0; i < iteration; i++) {
		if (document.getElementById('ttdate' + i) != null) {
			sg = document.getElementById('ttdate' + i).value;
		}
		if (document.getElementById('ttGA1' + i) != null) {
			ga1 = document.getElementById('ttGA1' + i).value;
		}
		if (document.getElementById('ttGA2' + i) != null) {
			ga2 = document.getElementById('ttGA2' + i).value;
		}

		if (document.getElementById('ttsystolic' + i) != null) {
			bp1 = document.getElementById('ttsystolic' + i).value;
		}
		if (document.getElementById('ttdiastolic' + i) != null) {
			bp2 = document.getElementById('ttdiastolic' + i).value;
		}
		if (document.getElementById('ttPA' + i) != null) {
			pa = document.getElementById('ttPA' + i).value;
		}
		if (document.getElementById('ttUrinAl' + i) != null) {
			pv = document.getElementById('ttUrinAl' + i).value;
		}
		if (document.getElementById('ttWeight' + i) != null) {
			weight = document.getElementById('ttWeight' + i).value;
		}

		if (sg != "") {

			if (ga1 == "" || ga2 == "" || bp1 == "" || bp2 == "" || pa == ""
					|| pv == "" || weight == "") {

				count = 1;

			}
		}
		if (sg != "" && ga1 != "" && ga2 != "" && bp1 != "" && bp2 != ""
				&& pa != "" && pv != "" && weight != "") {
			count = 2;

		}
		if (sg == "" && ga1 == "" && ga2 == "" && bp1 == "" && bp2 == ""
				&& pa == "" && pv == "" && weight == "") {
			count = 0;

		}
		if (count == 1) {
			break;
		}
	}
	if (count == 1) {
		alert("please enter all details in Third Trimester");
		$("#ttCount").val(0);
		result = false;
	}
	if (count == 0) {
		$("#ttCount").val(0);
		result = true;
	}
	if (count == 2) {
		$("#ttCount").val(1);
		result = true;
	}

	return result;
}

// Fourth trimester validation
function f4tTrimValid() {
	var result = false;
	var count = 0;
	var iteration;
	var sg, ga1, ga2, bp1, bp2, pv, pa, weight;
	var hdb = document.getElementById('hdb3');
	iteration = parseInt(hdb.value) + 1;

	for (var i = 0; i < iteration; i++) {
		if (document.getElementById('f4tdate' + i) != null) {
			sg = document.getElementById('f4tdate' + i).value;
		}
		if (document.getElementById('f4tGA1' + i) != null) {
			ga1 = document.getElementById('f4tGA1' + i).value;
		}
		if (document.getElementById('f4tGA2' + i) != null) {
			ga2 = document.getElementById('f4tGA2' + i).value;
		}

		if (document.getElementById('f4tsystolic' + i) != null) {
			bp1 = document.getElementById('f4tsystolic' + i).value;
		}
		if (document.getElementById('f4tdiastolic' + i) != null) {
			bp2 = document.getElementById('f4tdiastolic' + i).value;
		}
		if (document.getElementById('f4tPA' + i) != null) {
			pa = document.getElementById('f4tPA' + i).value;
		}
		if (document.getElementById('f4tUrinAl' + i) != null) {
			pv = document.getElementById('f4tUrinAl' + i).value;
		}
		if (document.getElementById('f4tWeight' + i) != null) {
			weight = document.getElementById('f4tWeight' + i).value;
		}

		if (sg != "") {

			if (ga1 == "" || ga2 == "" || bp1 == "" || bp2 == "" || pa == ""
					|| pv == "" || weight == "") {

				count = 1;

			}
		}
		if (sg != "" && ga1 != "" && ga2 != "" && bp1 != "" && bp2 != ""
				&& pa != "" && pv != "" && weight != "") {
			count = 2;

		}
		if (sg == "" && ga1 == "" && ga2 == "" && bp1 == "" && bp2 == ""
				&& pa == "" && pv == "" && weight == "") {
			count = 0;

		}
		if (count == 1) {
			break;
		}
	}
	if (count == 1) {
		alert("please enter all details in Fourth Trimester");
		$("#f4tCount").val(0);
		result = false;
	}
	if (count == 0) {
		$("#f4tCount").val(0);
		result = true;
	}
	if (count == 2) {
		$("#f4tCount").val(1);
		result = true;
	}

	return result;
}

function addRowAntTable() {
	// alert("addRowAntTable");
	// icdArray[document.getElementById('sexCount').value] = new Array();
	var tbl = document.getElementById('opdAntTable');
	var hdbTabIndex = parseInt(document.getElementById('opdhdbTabIndex').value) + 1;
	document.getElementById('opdhdbTabIndex').value = hdbTabIndex;

	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('opdhdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadioAnt' + iteration;
	e1.id = 'itemRadioAnt' + iteration;
	e1.className = 'radioCheck';
	e1.tabIndex = hdbTabIndex + "1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'year' + iteration;
	e1.id = 'year' + iteration;
	e1.setAttribute('validate', 'Year,num,no');
	e1.size = '4';
	e1.tabIndex = hdbTabIndex + "2";

	e1.oninput = function(event) {
		callAge('year' + iteration, 'ageUnit' + iteration);
	};

	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ageUnit' + iteration;
	e1.id = 'ageUnit' + iteration;
	e1.setAttribute('validate', 'Age,num,no');
	e1.tabIndex = hdbTabIndex + "3";
	e1.size = '3';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('FTND', '1');
	e1.options[2] = new Option('Vacuum', '2');
	e1.options[3] = new Option('Forceps', '3');
	e1.options[4] = new Option('LSCS', '4');
	e1.options[5] = new Option('Abortion', '5');
	e1.options[6] = new Option('Ectopic', '6');
	e1.options[7] = new Option('Vesicular Mole', '7');
	e1.options[8] = new Option('Others', '8');
	e1.name = 'pregnancyOutcome' + iteration;
	e1.id = 'pregnancyOutcome' + iteration;
	e1.tabIndex = "4";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', 'S');
	e1.options[1] = new Option('Home', '1');
	e1.options[2] = new Option('Hospital', '2');
	e1.options[3] = new Option('Transit', '3');
	e1.name = 'placeOfDelivery' + iteration;
	e1.id = 'placeOfDelivery' + iteration;
	e1.tabIndex = "5";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Live', '1');
	e1.options[2] = new Option('Still Birth', '2');
	e1.options[3] = new Option('IUD', '3');
	e1.options[4] = new Option('NND', '4');
	e1.name = 'deliveryOutcome' + iteration;
	e1.id = 'deliveryOutcome' + iteration;
	e1.tabIndex = "6";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('select');
	e1.name = 'sex' + iteration;
	e1.id = 'sex' + iteration;
	e1.tabIndex = "7";
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < icdArray.length; i++) {
		e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]);
	}
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'birthWeight' + iteration;
	e1.id = 'birthWeight' + iteration;
	e1.size = '5';
	e1.maxLength = '4';
	e1.tabIndex = hdbTabIndex + "8";
	cellRight1.appendChild(e1);

	var e2 = document.createElement('label');
	e2.innerHTML = "/gm";
	e2.className = "smallAuto autoSpace";
	cellRight1.appendChild(e2);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'complications' + iteration;
	e1.id = 'complications' + iteration;
	// e1.size = '20';
	e1.tabIndex = hdbTabIndex + "9";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'breastFeeding' + iteration;
	e1.id = 'breastFeeding' + iteration;
	// e1.size = '10';
	e1.tabIndex = hdbTabIndex + "10";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'generalHealth' + iteration;
	e1.id = 'generalHealth' + iteration;
	// e1.size = '10';
	e1.tabIndex = hdbTabIndex + "11";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', 'S');
	e1.options[1] = new Option('Yes', 'Y');
	e1.options[2] = new Option('No', 'N');
	e1.name = 'BloodTransfusion' + iteration;
	e1.id = 'BloodTransfusion' + iteration;
	e1.tabIndex = "12";
	cellRight1.appendChild(e1);

}

// Fourth trimester validation
function antenValid() {

	var result = true;
	var count = 0;
	var iteration;
	var sg, ga1, ga2, bp1, bp2, pv, pa, weight, generalHealth;

	var hdb = document.getElementById('opdhdb');
	iteration = parseInt(hdb.value) + 1;

	for (var i = 0; i < iteration; i++) {
		if (document.getElementById('pregnancyOutcome' + i) != null) {
			sg = document.getElementById('pregnancyOutcome' + i).value;

		} else {
			count = 2;
		}
		if (document.getElementById('sex' + i) != null) {
			ga1 = document.getElementById('sex' + i).value;

		} else {
			count = 2;
		}
		if (document.getElementById('ageUnit' + i) != null) {
			ga2 = document.getElementById('ageUnit' + i).value;
		} else {
			count = 2;
		}

		if (document.getElementById('birthWeight' + i) != null) {
			bp1 = document.getElementById('birthWeight' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('deliveryOutcome' + i) != null) {
			bp2 = document.getElementById('deliveryOutcome' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('year' + i) != null) {
			pa = document.getElementById('year' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('complications' + i) != null) {
			pv = document.getElementById('complications' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('breastFeeding' + i) != null) {
			weight = document.getElementById('breastFeeding' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('generalHealth' + i) != null) {
			generalHealth = document.getElementById('generalHealth' + i).value;
		} else {
			count = 2;
		}

		if (sg == 0 || ga1 == 0 || ga2 == "" || bp1 == "" || bp2 == 0
				|| pa == "" || pv == "" || weight == "" || generalHealth == "") {

			count = 1;

		}

		if (sg != 0 && ga1 != 0 && ga2 != "" && bp1 != "" && bp2 != 0
				&& pa != "" && pv != "" && weight != "" && generalHealth != "") {
			count = 2;

		}
		if (count == 1) {
			break;
		}
	}

	if (count == 1) {
		if (confirm("do you want to continue?")) {
			$("#AntCount").val(0);
			result = true;
		} else {
			$("#AntCount").val(0);
			result = false;
		}

	}
	if (count == 2) {
		$("#AntCount").val(1);
		result = true;
	}

	return result;
}

// govind added on 22-8-2016
function selectYesNo(yesId, NoId, childId, name) {
	// alert("test "+$("#"+yesId).val()+$("#"+NoId).val());
	// alert("yes checked "+document.getElementById(yesId).checked);
	// alert("No checked "+document.getElementById(NoId).checked);
	//	
	document.getElementById(yesId).checked = true;
	document.getElementById(NoId).checked = false;

	if (yesId == "hypertenPreYes") {

		var e1 = document.getElementById('mildNameMedicn');
		var e2 = document.getElementById('mildDetctTreat');
		var e3 = document.getElementById('severNameMedicn');
		var e4 = document.getElementById('severDetctTreat');
		if ($("#" + yesId).val() == 'Y') {
			$("#" + childId).show();
			e1.setAttribute('validate', 'Mild Name of medicine,string,yes');
			e2.setAttribute('validate',
					'Mild Detection to treatment interval,string,yes');
			e3.setAttribute('validate', 'Severe Name of medicine,string,yes');
			e4.setAttribute('validate',
					'Severe Detection to treatment interval,string,yes');
		} else {
			$("#mildNameMedicn").val("");
			$("#mildDetctTreat").val("");
			$("#severNameMedicn").val("");
			$("#severDetctTreat").val("");
			$("#" + childId).hide();
			e1.removeAttribute('validate');
			e2.removeAttribute('validate');
			e3.removeAttribute('validate');
			e4.removeAttribute('validate');

		}
	} else {
		var e1 = document.getElementById(childId);
		if ($("#" + yesId).val() == 'Y') {
			$("#" + childId).show();
			e1.setAttribute('validate', name + ',string,yes');
		} else {
			$("#" + childId).hide();
			$("#" + childId).val("");
			e1.removeAttribute('validate')
		}
	}
}

function runRadioCheck(AnemiaYes, dmYes, heartDisYes, hypertenPreYes, helpYes,
		didSheReceivYes, eclampsiaYes, anyPrevAbdomSurgYes, cerclageYes) {

	if (pregConfrm1 == 'Y') {
		document.getElementById("pregConfrm").checked = true;
		callPregConfirm();
	} else {
		document.getElementById("pregConfrm").checked = false;
		callPregConfirm();
	}

	if (AnemiaYes == "Y") {
		document.getElementById("AnemiaYes").checked = true;
	}
	if (AnemiaYes == "N") {
		document.getElementById("AnemiaNo").checked = true;

	}

	if (dmYes == "Y") {
		document.getElementById("dmYes").checked = true;
	}
	if (dmYes == "N") {
		document.getElementById("dmNo").checked = true;
	}

	if (heartDisYes == "Y") {
		document.getElementById("heartDisYes").checked = true;
		$("#heartDis").show();
	}
	if (heartDisYes == "N") {
		document.getElementById("heartDisNo").checked = true;
		$("#heartDis").hide();
	}

	if (hypertenPreYes == "Y") {
		document.getElementById("hypertenPreYes").checked = true;
		$("#hyperBloc").show();
	}
	if (hypertenPreYes == "N") {
		document.getElementById("hypertenPreNo").checked = true;
		$("#hyperBloc").hide();
	}

	if (helpYes == "Y") {
		document.getElementById("helpYes").checked = true;
	}
	if (helpYes == "N") {
		document.getElementById("helpNo").checked = true;
	}

	if (didSheReceivYes == "Y") {
		document.getElementById("didSheReceivYes").checked = true;
		$("#didSheReceiv").show();
	}
	if (didSheReceivYes == "N") {
		document.getElementById("didSheReceivNo").checked = true;
		$("#didSheReceiv").hide();
	}

	if (eclampsiaYes == "Y") {
		document.getElementById("eclampsiaYes").checked = true;
		$("#eclampsia").show();
	}
	if (eclampsiaYes == "N") {
		document.getElementById("eclampsiaNo").checked = true;
		$("#eclampsia").hide();
	}

	if (anyPrevAbdomSurgYes == "Y") {
		document.getElementById("anyPrevAbdomSurgYes").checked = true;
		$("#anyPrevAbdomSurg").show();
	}
	if (anyPrevAbdomSurgYes == "N") {
		document.getElementById("anyPrevAbdomSurgNo").checked = true;
		$("#anyPrevAbdomSurg").hide();
	}
	if (cerclageYes == "Y") {
		document.getElementById("cerclageYes").checked = true;
		$("#cerclage").show();
	}
	if (cerclageYes == "N") {
		document.getElementById("cerclageNo").checked = true;
		$("#cerclage").hide();
	}
}

function gravidaAbortionTwo() {
	if ($("#b4").val() == 2 && $("#b6").val() == 2) {
		$("#b5").val(0);
		$("#b7").val(0);
	}

}

// added by govind 30-8-2016
function addRowMensHistTable() {

	var tbl = document.getElementById('opdMensHistTable');
	var hdbTabIndex = parseInt(document.getElementById('hdbTabIndexMH').value) + 1;
	document.getElementById('hdbTabIndexMH').value = hdbTabIndex;

	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbMH');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadioMH' + iteration;
	e1.id = 'itemRadioMH' + iteration;
	e1.className = 'radioCheck';
	e1.tabIndex = hdbTabIndex + "1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'mhDate' + iteration;
	e1.id = 'mhDate' + iteration;
	e1.value = document.getElementById('inputDate').value;
	e1.size = '8';
	e1.tabIndex = hdbTabIndex + "2";
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('mhDate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};
	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'mhTime' + iteration;
	e1.id = 'mhTime' + iteration;
	e1.value = document.getElementById('inputTime').value;
	e1.tabIndex = hdbTabIndex + "3";
	e1.size = '3';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'plScore' + iteration;
	e1.id = 'plScore' + iteration;
	e1.setAttribute('validate', 'PL Score,num,no');
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lmpDate' + iteration;
	e1.id = 'lmpDate' + iteration;
	e1.size = '8';
	e1.tabIndex = hdbTabIndex + "5";
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('lmpDate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};
	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'pmpDate' + iteration;
	e1.id = 'pmpDate' + iteration;
	e1.size = '8';
	e1.tabIndex = hdbTabIndex + "6";
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('pmpDate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};
	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Irregular', '1');
	e1.options[2] = new Option('Regular', '2');
	e1.options[3] = new Option('Absent', '3');
	e1.name = 'regulartyCycle' + iteration;
	e1.id = 'regulartyCycle' + iteration;
	e1.tabIndex = "7";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'cycleDuration' + iteration;
	e1.id = 'cycleDuration' + iteration;
	e1.tabIndex = hdbTabIndex + "8";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Frequent', '1');
	e1.options[2] = new Option('Normal', '2');
	e1.options[3] = new Option('Infrequent', '3');
	e1.name = 'frequency' + iteration;
	e1.id = 'frequency' + iteration;
	e1.tabIndex = "9";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'duration' + iteration;
	e1.id = 'duration' + iteration;
	e1.tabIndex = hdbTabIndex + "3";
	e1.size = '10';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Normal', '1');
	e1.options[2] = new Option('Scanty', '2');
	e1.options[3] = new Option('Moderate', '3');
	e1.options[4] = new Option('Heavy', '4');
	e1.name = 'volume' + iteration;
	e1.id = 'volume' + iteration;
	e1.tabIndex = "11";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'characterstic' + iteration;
	e1.id = 'characterstic' + iteration;
	e1.tabIndex = hdbTabIndex + "12";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(12);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'assoctComplain' + iteration;
	e1.id = 'assoctComplain' + iteration;
	e1.tabIndex = hdbTabIndex + "13";
	cellRight1.appendChild(e1);

}

// added by govind 1-9-2016
function checkDate() {
	var vDate = new Date();
	var result = false;
	var dobDate1 = document.getElementById('lmpId').value;
	var dobDate3 = document.getElementById('date3Id').value;
	var dobDate4 = document.getElementById('date4Id').value;
	// var dobDate2 = document.getElementById('date2Id').value;

	// var dobDate5 = document.getElementById('date5Id').value ;

	// var d2 = new Date(dobDate2.substring(6), (dobDate2.substring(3, 5) - 1),
	// dobDate2.substring(0, 2));

	// var d5 = new Date(dobDate5.substring(6),(dobDate5.substring(3,5) - 1)
	// ,dobDate5.substring(0,2));
	if (dobDate1 != "") {
		var d1 = new Date(dobDate1.substring(6),
				(dobDate1.substring(3, 5) - 1), dobDate1.substring(0, 2));
		if (vDate < d1) {
			alert("Please enter valid date of Date Of Lmp.");
			document.getElementById('lmpId').value = "";
			document.getElementById('eddId').value = "";
			result = false;
		} else {
			result = true;
		}
	}
	// if (dobDate2 != "") {
	// if (vDate > d2) {
	// alert("Please enter valid date of examination.");
	// document.getElementById('date2Id').value = "";
	// return false;
	// } else {
	// return true;
	// }
	// }

	if (dobDate3 != "") {
		var d3 = new Date(dobDate3.substring(6),
				(dobDate3.substring(3, 5) - 1), dobDate3.substring(0, 2));

		if (vDate < d3) {
			alert("Please enter valid Date of 1st Dose on.");
			document.getElementById('date3Id').value = "";
			result = false;
		} else {
			result = true;
		}
	}
	if (dobDate4 != "") {
		var d4 = new Date(dobDate4.substring(6),
				(dobDate4.substring(3, 5) - 1), dobDate4.substring(0, 2));
		if (vDate < d4) {
			alert("Please enter valid Date of 2nd Dose on.");
			document.getElementById('date4Id').value = "";
			result = false;
		} else {
			result = true;
		}
	}
	// if (vDate > d5) {
	// alert("Please enter valid Date of Next Visit.");
	// document.getElementById('date5Id').value = "";
	// return false;
	// } else {
	// return true;
	// }

	return result;

}

function callPregConfirm() {
	if (document.getElementById("pregConfrm").checked == true) {
		addMonths();
		$("#eddDiv").show();
	} else {
		$("#eddId").val("");
		$("#eddDiv").hide();
	}
}

function callAge(year, age) {
	var dob = patDOB.split("/");
	var dobYear = dob[2];
	var pateYear = document.getElementById(year).value;
	if (pateYear.length == 4) {
		document.getElementById(age).value = pateYear - dobYear;
	}
}

function getWeight(curId) {
	var weight = $("#b27").val();
	$("#" + curId).val(weight);
}

function setWeight() {
	var weight = $("#b27").val();
	$("#ftWeight0").val(weight);
	$("#stWeight0").val(weight);
	$("#ttWeight0").val(weight);
	$("#f4tWeight0").val(weight);

}