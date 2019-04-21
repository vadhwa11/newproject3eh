//Labour Room1
function addRowLabRoom1Table() {
	// alert("addRowAntTable");

	var tbl = document.getElementById('lbRoom1Table');
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
	cellRight1.style.width = '100px';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb1date' + iteration;e1.className="dateTextSmall";
	e1.id = 'lb1date' + iteration;
	e1.size = '8';
	e1.readOnly = 'readonly';
	e1.tabIndex = hdbTabIndex + "2";
	e1.value = document.getElementById('inputDate').value;
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('lb1date' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb1Time' + iteration;
	e1.id = 'lb1Time' + iteration;
	e1.tabIndex = hdbTabIndex + "3";
	e1.size = '6';
	e1.readOnly = 'readonly';
	e1.value = document.getElementById('inputTime').value;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb1MaterPulse' + iteration;
	e1.id = 'lb1MaterPulse' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb1RespRate' + iteration;
	e1.id = 'lb1RespRate' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "5";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb1BP' + iteration;
	e1.id = 'lb1BP' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "6";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb1LungBase' + iteration;
	e1.id = 'lb1LungBase' + iteration;
	e1.size = '20';
	e1.tabIndex = hdbTabIndex + "7";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('+', '1');
	e1.options[2] = new Option('-', '2');
	e1.name = 'lb1KneeJerk' + iteration;
	e1.id = 'lb1KneeJerk' + iteration;
	e1.tabIndex = "8";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb1FatalHeart' + iteration;
	e1.id = 'lb1FatalHeart' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "9";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Base line heart rate', '1');
	e1.options[2] = new Option('Beat to beat variability', '2');
	e1.options[3] = new Option('Accelerations', '3');
	e1.options[4] = new Option('Deceleration', '4');
	e1.name = 'lb1NST' + iteration;
	e1.id = 'lb1NST' + iteration;
	e1.tabIndex = "10";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb1Contraction' + iteration;
	e1.id = 'lb1Contraction' + iteration;
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "11";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb1IO' + iteration;
	e1.id = 'lb1IO' + iteration;
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "12";
	cellRight1.appendChild(e1);

}

function removeRow(form) {
	var tbl = document.getElementById(form);
	var lastRow = tbl.rows.length;
	var hdb;
	var radio = "";
	if (form == 'lbRoom1Table') {
		hdb = document.getElementById('hdb');
		radio = "itemRadio";
	}
	
	if (form == 'lbRoom2Table') {
		hdb = document.getElementById('hdb');
		radio = "itemRadio";
	}
	
	if (form == 'lbRoom3Table') {
		hdb = document.getElementById('hdb');
		radio = "itemRadio";
	}
	
	if (form == 'lbRoom4Table') {
		hdb = document.getElementById('hdb');
		radio = "itemRadio";
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

// LaborRoom1 Validation
function labRoom1Valid() {
	var result = true;
	var count = 0;
	var iteration;
	var sg, ga1, ga2, bp1, bp2, pv, pa, weight, generalHealth, lb1Contraction, lb1IO;

	var hdb = document.getElementById('hdb');
	iteration = parseInt(hdb.value) + 1;
	//alert("hdb "+iteration);	

	for (var i = 0; i < iteration; i++) {
		if (document.getElementById('lb1date' + i) != null) {
			sg = document.getElementById('lb1date' + i).value;

		} else {
			count = 2;
		}
		if (document.getElementById('lb1Time' + i) != null) {
			ga1 = document.getElementById('lb1Time' + i).value;

		} else {
			count = 2;
		}
		if (document.getElementById('lb1MaterPulse' + i) != null) {
			ga2 = document.getElementById('lb1MaterPulse' + i).value;
		} else {
			count = 2;
		}

		if (document.getElementById('lb1RespRate' + i) != null) {
			bp1 = document.getElementById('lb1RespRate' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb1BP' + i) != null) {
			bp2 = document.getElementById('lb1BP' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb1LungBase' + i) != null) {
			pa = document.getElementById('lb1LungBase' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb1KneeJerk' + i) != null) {
			pv = document.getElementById('lb1KneeJerk' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb1FatalHeart' + i) != null) {
			weight = document.getElementById('lb1FatalHeart' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb1NST' + i) != null) {
			generalHealth = document.getElementById('lb1NST' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb1Contraction' + i) != null) {
			lb1Contraction = document.getElementById('lb1Contraction' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb1IO' + i) != null) {
			lb1IO = document.getElementById('lb1IO' + i).value;
		} else {
			count = 2;
		}

		if (sg == "" || ga1 =="" || ga2 == "" || bp1 == "" || bp2 == ""
				|| pa == "" || pv == 0 || weight == "" || generalHealth == 0
				|| lb1Contraction == "" || lb1IO == "") {

			count = 1;

		}

		if (sg != "" && ga1 != "" && ga2 != "" && bp1 != "" && bp2 != ""
				&& pa != "" && pv != 0 && weight != "" && generalHealth != 0
				&& lb1Contraction != "" && lb1IO != "") {
			count = 2;

		}
		if (count == 1) {
			break;
		}
	}
	
	if (count == 1) {
		alert("Please enter all fields in Labor Details");
		document.getElementById('lbRoomCount').value=0;
		result = false;

	}
	if (count == 2) {
		document.getElementById('lbRoomCount').value=1;
		result = true;
	}

	return result;
}

//Labour Room2
function addRowLabRoom2Table() {
	// alert("addRowAntTable");

	var tbl = document.getElementById('lbRoom2Table');
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
	cellRight1.style.width = '100px';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2date' + iteration;
	e1.id = 'lb2date' + iteration;
	e1.size = '8';
	e1.readOnly = 'readonly';
	e1.tabIndex = hdbTabIndex + "2";
	e1.value = document.getElementById('inputDate').value;
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('lb2date' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2Time' + iteration;
	e1.id = 'lb2Time' + iteration;
	e1.tabIndex = hdbTabIndex + "3";
	e1.size = '6';
	e1.readOnly = 'readonly';
	e1.value = document.getElementById('inputTime').value;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2MaterPulse' + iteration;
	e1.id = 'lb2MaterPulse' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2RespRate' + iteration;
	e1.id = 'lb2RespRate' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "5";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2BP' + iteration;
	e1.id = 'lb2BP' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "6";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2LungBase' + iteration;
	e1.id = 'lb2LungBase' + iteration;
	e1.size = '20';
	e1.tabIndex = hdbTabIndex + "7";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('+', '1');
	e1.options[2] = new Option('-', '2');
	e1.name = 'lb2KneeJerk' + iteration;
	e1.id = 'lb2KneeJerk' + iteration;
	e1.tabIndex = "8";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2FatalHeart' + iteration;
	e1.id = 'lb2FatalHeart' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "9";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Base line heart rate', '1');
	e1.options[2] = new Option('Beat to beat variability', '2');
	e1.options[3] = new Option('Accelerations', '3');
	e1.options[4] = new Option('Deceleration', '4');
	e1.name = 'lb2NST' + iteration;
	e1.id = 'lb2NST' + iteration;
	e1.tabIndex = "10";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2OxyInfRate' + iteration;
	e1.id = 'lb2OxyInfRate' + iteration;
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "11";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2Contraction' + iteration;
	e1.id = 'lb2Contraction' + iteration;
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "12";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(12);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2IO' + iteration;
	e1.id = 'lb2IO' + iteration;
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "13";
	cellRight1.appendChild(e1);

}


//LaborRoom2 Validation
function labRoom2Valid() {
	//alert("labRoom2Valid");
	var result = true;
	var count = 0;
	var iteration;
	var sg, ga1, ga2, bp1, bp2, pv, pa, weight, generalHealth, lb2Contraction, lb2IO,lb2OxyInfRate;

	var hdb = document.getElementById('hdb');
	iteration = parseInt(hdb.value) + 1;
	//alert("hdb "+iteration);	

	for (var i = 0; i < iteration; i++) {
		if (document.getElementById('lb2date' + i) != null) {
			sg = document.getElementById('lb2date' + i).value;

		} else {
			count = 2;
		}
		if (document.getElementById('lb2Time' + i) != null) {
			ga1 = document.getElementById('lb2Time' + i).value;

		} else {
			count = 2;
		}
		if (document.getElementById('lb2MaterPulse' + i) != null) {
			ga2 = document.getElementById('lb2MaterPulse' + i).value;
		} else {
			count = 2;
		}

		if (document.getElementById('lb2RespRate' + i) != null) {
			bp1 = document.getElementById('lb2RespRate' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb2BP' + i) != null) {
			bp2 = document.getElementById('lb2BP' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb2LungBase' + i) != null) {
			pa = document.getElementById('lb2LungBase' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb2KneeJerk' + i) != null) {
			pv = document.getElementById('lb2KneeJerk' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb2FatalHeart' + i) != null) {
			weight = document.getElementById('lb2FatalHeart' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb2NST' + i) != null) {
			generalHealth = document.getElementById('lb2NST' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb2OxyInfRate' + i) != null) {
			lb2OxyInfRate = document.getElementById('lb2OxyInfRate' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb2Contraction' + i) != null) {
			lb2Contraction = document.getElementById('lb2Contraction' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb2IO' + i) != null) {
			lb2IO = document.getElementById('lb2IO' + i).value;
		} else {
			count = 2;
		}

		if (sg == "" || ga1 =="" || ga2 == "" || bp1 == "" || bp2 == ""
				|| pa == "" || pv == 0 || weight == "" || generalHealth == 0
				|| lb2Contraction == "" || lb2IO == "" || lb2OxyInfRate == "") {
			count = 1;

		}

		if (sg != "" && ga1 != "" && ga2 != "" && bp1 != "" && bp2 != ""
				&& pa != "" && pv != 0 && weight != "" && generalHealth != 0
				&& lb2Contraction != "" && lb2IO != "" && lb2OxyInfRate != "") {
			count = 2;

		}
		if (count == 1) {
			break;
		}
	}
	
	if (count == 1) {
		alert("Please enter all fields in Labor Details");
		document.getElementById('lbRoomCount').value=0;
		result = false;

	}
	if (count == 2) {
		document.getElementById('lbRoomCount').value=1;
		result = true;
	}
	
	
	var hdbpv = document.getElementById('hdbpv').value;
	var hdbfetal = document.getElementById('hdbfetal').value;
	var hdbdd = document.getElementById('hdbdd').value;
	var hdbCont = document.getElementById('hdbCont').value;
	var hdbprbp = document.getElementById('hdbprbp').value;
	var hdbtemp = document.getElementById('hdbtemp').value;
	var hdbua = document.getElementById('hdbua').value;
	result = true;
	var table_name="";
	var count=0;
	for (var i = 1; i <=hdbpv; i++) {
		count=0;
		if(isBlank("lb1pvdate"+i))
			count++;
		if(isBlank("lb1pvTime"+i))
			count++;
		if(isBlank("lb1Findings"+i))
			count++;
	   if(count>2 && count!=3)
		   {
		   result = false;
		   table_name="PV Examination";
			break;} 
	}
	if(result){
		for (var i = 1; i <=hdbfetal; i++) {
			count=0;
			if(isBlank("lb2pfdate"+i))
				count++;
			if(isBlank("lb2fdTime"+i))
				count++;
			if(isBlank("fetalAmFluid"+i))
				count++;
			if(isBlank("fetalMouldingSkull"+i))
				count++;
		   if(count>2 && count!=4)
			   {
			   result = false;
			   table_name="Fetal Well Being";
				break;} 
		}}
	
	if(result){
		for (var i = 1; i <=hdbdd; i++) {
			count=0;
			if(isBlank("lb2dddate"+i))
				count++;
			if(isBlank("lb2ddTime"+i))
				count++;
			if(isBlank("dilatation"+i))
				count++;
			if(isBlank("descent"+i))
				count++;
		   if(count>2 && count!=4)
			   {
			   result = false;
			   table_name="Dilatation and Descent";
				break;} 
		}}
	
	if(result){
		for (var i = 1; i <=hdbCont; i++) {
			count=0;
			if(isBlank("lb2Cdate"+i))
				count++;
			if(isBlank("lb2CTime"+i))
				count++;
			if(isBlank("contraction_type"+i))
				count++;
		   if(count>2 && count!=3)
			   {
			   result = false;
			   table_name="Contraction";
				break;} 
		}}
	
	if(result){
		for (var i = 1; i <=hdbprbp; i++) {
			count=0;
			if(isBlank("lb2prbpdate"+i))
				count++;
			if(isBlank("lb2prbpTime"+i))
				count++;
			if(isBlank("pulse"+i))
				count++;
			if(isBlank("systolic"+i))
				count++;
			if(isBlank("diastolic"+i))
				count++;
		   if(count>2 && count!=5)
			   {
			   result = false;
			   table_name="Pulse Rate and BP";
				break;} 
		}}
	
	if(result){
		for (var i = 1; i <=hdbtemp; i++) {
			count=0;
			if(isBlank("lb2tempdate"+i))
				count++;
			if(isBlank("lb2tempTime"+i))
				count++;
			if(isBlank("temperature"+i))
				count++;
		   if(count>2 && count!=3)
			   {
			   result = false;
			   table_name="Temperature";
				break;} 
		}}
	
	if(result){
		for (var i = 1; i <=hdbua; i++) {
			count=0;
			if(isBlank("lb2uadate"+i))
				count++;
			if(isBlank("lb2uaTime"+i))
				count++;
			if(isBlank("volume"+i))
				count++;
			if(isBlank("albumin"+i))
				count++;
			if(isBlank("acetone"+i))
				count++;
			if(isBlank("glucose"+i))
				count++;
			alert(count);
		   if(count>2 && count!=6)
			   {
			   result = false;
			   table_name="Urine Analysis";
				break;} 
		}}
	if(!result){
	alert("Please enter all fields in "+table_name);
	}
	return result;
}

//Labor Room 3
function addRowLabRoom3Table() {
	//alert("addRowLabRoom3Table");

	var tbl = document.getElementById('lbRoom3Table');
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
	cellRight1.style.width = '100px';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb3date' + iteration;
	e1.id = 'lb3date' + iteration;
	e1.size = '8';
	e1.readOnly = 'readonly';
	e1.tabIndex = hdbTabIndex + "2";
	e1.value = document.getElementById('inputDate').value;
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('lb3date' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb3Time' + iteration;
	e1.id = 'lb3Time' + iteration;
	e1.tabIndex = hdbTabIndex + "3";
	e1.size = '6';
	e1.readOnly = 'readonly';
	e1.value = document.getElementById('inputTime').value;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb3MaterPulse' + iteration;
	e1.id = 'lb3MaterPulse' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb3RespRate' + iteration;
	e1.id = 'lb3RespRate' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "5";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb3BP' + iteration;
	e1.id = 'lb3BP' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "6";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb3LungBase' + iteration;
	e1.id = 'lb3LungBase' + iteration;
	e1.size = '20';
	e1.tabIndex = hdbTabIndex + "7";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('+', '1');
	e1.options[2] = new Option('-', '2');
	e1.name = 'lb3KneeJerk' + iteration;
	e1.id = 'lb3KneeJerk' + iteration;
	e1.tabIndex = "8";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb3FatalHeart' + iteration;
	e1.id = 'lb3FatalHeart' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "9";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Base line heart rate', '1');
	e1.options[2] = new Option('Beat to beat variability', '2');
	e1.options[3] = new Option('Accelerations', '3');
	e1.options[4] = new Option('Deceleration', '4');
	e1.name = 'lb3NST' + iteration;
	e1.id = 'lb3NST' + iteration;
	e1.tabIndex = "10";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb3OxyInfRate' + iteration;
	e1.id = 'lb3OxyInfRate' + iteration;
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "11";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb3Contraction' + iteration;
	e1.id = 'lb3Contraction' + iteration;
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "12";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(12);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb3IO' + iteration;
	e1.id = 'lb3IO' + iteration;
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "13";
	cellRight1.appendChild(e1);

}

//Labor Room 4
function addRowLabRoom4Table() {
	//alert("addRowLabRoom4Table");

	var tbl = document.getElementById('lbRoom4Table');
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
	cellRight1.style.width = '100px';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb4date' + iteration;
	e1.id = 'lb4date' + iteration;
	e1.size = '8';
	e1.readOnly = 'readonly';
	e1.tabIndex = hdbTabIndex + "2";
	e1.value = document.getElementById('inputDate').value;
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('lb4date' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb4Time' + iteration;
	e1.id = 'lb4Time' + iteration;
	e1.tabIndex = hdbTabIndex + "3";
	e1.size = '6';
	e1.readOnly = 'readonly';
	e1.value = document.getElementById('inputTime').value;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb4MaterPulse' + iteration;
	e1.id = 'lb4MaterPulse' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "4";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb4RespRate' + iteration;
	e1.id = 'lb4RespRate' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "5";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb4BP' + iteration;
	e1.id = 'lb4BP' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "6";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb4LungBase' + iteration;
	e1.id = 'lb4LungBase' + iteration;
	e1.size = '20';
	e1.tabIndex = hdbTabIndex + "7";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('+', '1');
	e1.options[2] = new Option('-', '2');
	e1.name = 'lb4KneeJerk' + iteration;
	e1.id = 'lb4KneeJerk' + iteration;
	e1.tabIndex = "8";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb4FatalHeart' + iteration;
	e1.id = 'lb4FatalHeart' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "9";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Base line heart rate', '1');
	e1.options[2] = new Option('Beat to beat variability', '2');
	e1.options[3] = new Option('Accelerations', '3');
	e1.options[4] = new Option('Deceleration', '4');
	e1.name = 'lb4NST' + iteration;
	e1.id = 'lb4NST' + iteration;
	e1.tabIndex = "10";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb4OxyInfRate' + iteration;
	e1.id = 'lb4OxyInfRate' + iteration;
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "11";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb4Contraction' + iteration;
	e1.id = 'lb4Contraction' + iteration;
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "12";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(12);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb4IO' + iteration;
	e1.id = 'lb4IO' + iteration;
	e1.size = '6';
	e1.tabIndex = hdbTabIndex + "13";
	cellRight1.appendChild(e1);

}


//LaborRoom3 Validation
function labRoom3Valid() {
	//alert("labRoom2Valid");
	var result = true;
	var count = 0;
	var iteration;
	var sg, ga1, ga2, bp1, bp2, pv, pa, weight, generalHealth, lb3Contraction, lb3IO,lb3OxyInfRate;

	var hdb = document.getElementById('hdb');
	iteration = parseInt(hdb.value) + 1;
	//alert("hdb "+iteration);	

	for (var i = 0; i < iteration; i++) {
		if (document.getElementById('lb3date' + i) != null) {
			sg = document.getElementById('lb3date' + i).value;

		} else {
			count = 2;
		}
		if (document.getElementById('lb3Time' + i) != null) {
			ga1 = document.getElementById('lb3Time' + i).value;

		} else {
			count = 2;
		}
		if (document.getElementById('lb3MaterPulse' + i) != null) {
			ga2 = document.getElementById('lb3MaterPulse' + i).value;
		} else {
			count = 2;
		}

		if (document.getElementById('lb3RespRate' + i) != null) {
			bp1 = document.getElementById('lb3RespRate' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb3BP' + i) != null) {
			bp2 = document.getElementById('lb3BP' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb3LungBase' + i) != null) {
			pa = document.getElementById('lb3LungBase' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb3KneeJerk' + i) != null) {
			pv = document.getElementById('lb3KneeJerk' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb3FatalHeart' + i) != null) {
			weight = document.getElementById('lb3FatalHeart' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb3NST' + i) != null) {
			generalHealth = document.getElementById('lb3NST' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb3OxyInfRate' + i) != null) {
			lb3OxyInfRate = document.getElementById('lb3OxyInfRate' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb3Contraction' + i) != null) {
			lb3Contraction = document.getElementById('lb3Contraction' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb3IO' + i) != null) {
			lb3IO = document.getElementById('lb3IO' + i).value;
		} else {
			count = 2;
		}

		if (sg == "" || ga1 =="" || ga2 == "" || bp1 == "" || bp2 == ""
				|| pa == "" || pv == 0 || weight == "" || generalHealth == 0
				|| lb3Contraction == "" || lb3IO == "" || lb3OxyInfRate == "") {
			count = 1;

		}

		if (sg != "" && ga1 != "" && ga2 != "" && bp1 != "" && bp2 != ""
				&& pa != "" && pv != 0 && weight != "" && generalHealth != 0
				&& lb3Contraction != "" && lb3IO != "" && lb3OxyInfRate != "") {
			count = 2;

		}
		if (count == 1) {
			break;
		}
	}
	
	if (count == 1) {
		alert("Please enter all fields in Labor Details");
		document.getElementById('lbRoomCount').value=0;
		result = false;

	}
	if (count == 2) {
		document.getElementById('lbRoomCount').value=1;
		result = true;
	}

	return result;
}


//LaborRoom4 Validation
function labRoom4Valid() {
	//alert("labRoom2Valid");
	var result = true;
	var count = 0;
	var iteration;
	var sg, ga1, ga2, bp1, bp2, pv, pa, weight, generalHealth, lb4Contraction, lb4IO,lb4OxyInfRate;

	var hdb = document.getElementById('hdb');
	iteration = parseInt(hdb.value) + 1;
	//alert("hdb "+iteration);	

	for (var i = 0; i < iteration; i++) {
		if (document.getElementById('lb4date' + i) != null) {
			sg = document.getElementById('lb4date' + i).value;

		} else {
			count = 2;
		}
		if (document.getElementById('lb4Time' + i) != null) {
			ga1 = document.getElementById('lb4Time' + i).value;

		} else {
			count = 2;
		}
		if (document.getElementById('lb4MaterPulse' + i) != null) {
			ga2 = document.getElementById('lb4MaterPulse' + i).value;
		} else {
			count = 2;
		}

		if (document.getElementById('lb4RespRate' + i) != null) {
			bp1 = document.getElementById('lb4RespRate' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb4BP' + i) != null) {
			bp2 = document.getElementById('lb4BP' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb4LungBase' + i) != null) {
			pa = document.getElementById('lb4LungBase' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb4KneeJerk' + i) != null) {
			pv = document.getElementById('lb4KneeJerk' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb4FatalHeart' + i) != null) {
			weight = document.getElementById('lb4FatalHeart' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb4NST' + i) != null) {
			generalHealth = document.getElementById('lb4NST' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb4OxyInfRate' + i) != null) {
			lb4OxyInfRate = document.getElementById('lb4OxyInfRate' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb4Contraction' + i) != null) {
			lb4Contraction = document.getElementById('lb4Contraction' + i).value;
		} else {
			count = 2;
		}
		if (document.getElementById('lb4IO' + i) != null) {
			lb4IO = document.getElementById('lb4IO' + i).value;
		} else {
			count = 2;
		}

		if (sg == "" || ga1 =="" || ga2 == "" || bp1 == "" || bp2 == ""
				|| pa == "" || pv == 0 || weight == "" || generalHealth == 0
				|| lb4Contraction == "" || lb4IO == "" || lb4OxyInfRate == "") {
			count = 1;

		}

		if (sg != "" && ga1 != "" && ga2 != "" && bp1 != "" && bp2 != ""
				&& pa != "" && pv != 0 && weight != "" && generalHealth != 0
				&& lb4Contraction != "" && lb4IO != "" && lb4OxyInfRate != "") {
			count = 2;

		}
		if (count == 1) {
			break;
		}
	}
	
	if (count == 1) {
		alert("Please enter all fields in Labor Details");
		document.getElementById('lbRoomCount').value=0;
		result = false;

	}
	if (count == 2) {
		document.getElementById('lbRoomCount').value=1;
		result = true;
	}

	return result;
}

function isNumberKey(evt)
{
   var charCode = (evt.which) ? evt.which : evt.keyCode;
   if (charCode != 46 && charCode > 31 
     && (charCode < 48 || charCode > 57))
      return false;

   return true;
}

//////
function addRowProcDoneLabRoom1() {
	// alert("addRowAntTable");

	var tbl = document.getElementById('lbRoom1PVTable');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbpv');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	cellRight1.style.width = '100px';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2pvdate' + iteration;
	e1.className="dateTextSmall";
	e1.id = 'lb2pvdate' + iteration;
	e1.size = '9';
	e1.readOnly = 'readonly';
	e1.value = document.getElementById('inputDate').value;
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('lb2pvdate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2pvTime' + iteration;
	e1.id = 'lb2pvTime' + iteration;
	e1.size = '6';
	e1.value = document.getElementById('inputTime').value;
	 e1.setAttribute("onblur", "IsValidTime(this.value,this.id)");
	 e1.setAttribute("onkeyup", "mask(this.value,this,'2',':')");
	cellRight1.appendChild(e1)

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('textarea');
	e1.name = 'lab1Findings' + iteration;
	e1.id = 'lab1Findings' + iteration;
	e1.className='large';
	e1.maxLength = '256';
	cellRight1.appendChild(e1);

}

function addRowInductionLabRoom1() {

	var tbl = document.getElementById('lbRoom1InductionTable');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbInduction');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb1InductionTime' + iteration;
	e1.id = 'lb1InductionTime' + iteration;
	e1.size = '6';
	e1.value = document.getElementById('inputTime').value;
	 e1.setAttribute("onblur", "IsValidTime(this.value,this.id)");
	 e1.setAttribute("onkeyup", "mask(this.value,this,'2',':')");
	cellRight1.appendChild(e1)

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('PGE1', '1');
	e1.options[2] = new Option('PGE2', '2');
	e1.name = 'MedicineGiven' + iteration;
	e1.id = 'MedicineGiven' + iteration;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '0');
	e1.options[1] = new Option('Yes', 'y');
	e1.options[2] = new Option('No', 'n');
	e1.name = 'lb1ARM' + iteration;
	e1.id = 'lb1ARM' + iteration;
	cellRight1.appendChild(e1);
	}
function addRowFetalLabRoom2() {
	// alert("addRowAntTable");

	var tbl = document.getElementById('lbRoom2FetalTable');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbfetal');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	cellRight1.style.width = '100px';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2pfdate' + iteration;e1.className="dateTextSmall";
	e1.id = 'lb2pfdate' + iteration;
	e1.size = '8';
	e1.readOnly = 'readonly';
	e1.tabIndex = hdbTabIndex + "2";
	e1.value = document.getElementById('inputDate').value;
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('lb2pfdate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2fdTime' + iteration;
	e1.id = 'lb2fdTime' + iteration;
	e1.size = '6';
	e1.value = document.getElementById('inputTime').value;
	 e1.setAttribute("onblur", "IsValidTime(this.value,this.id)");
	 e1.setAttribute("onkeyup", "mask(this.value,this,'2',':')");
	cellRight1.appendChild(e1)

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'fetalheartbeat' + iteration;
	e1.id = 'fetalheartbeat' + iteration;
	e1.onkeypress = function() {
		return isNumberKey(event);
	};
	e1.maxLength='5';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('I', 'I');
	e1.options[2] = new Option('C', 'C');
	e1.options[3] = new Option('M', 'M');
	e1.name = 'fetalAmFluid' + iteration;
	e1.id = 'fetalAmFluid' + iteration;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('0', '0');
	e1.options[2] = new Option('+', '+');
	e1.options[3] = new Option('++', '++');
	e1.options[4] = new Option('+++', '+++');
	e1.name = 'fetalMouldingSkull' + iteration;
	e1.id = 'fetalMouldingSkull' + iteration;
	cellRight1.appendChild(e1);
}

function addRowDDLabRoom2() {
	// alert("addRowAntTable");

	var tbl = document.getElementById('lbRoom2ddTable');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbdd');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);
	var cellRight1 = row.insertCell(1);
	cellRight1.style.width = '100px';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2dddate' + iteration;e1.className="dateTextSmall";
	e1.id = 'lb2dddate' + iteration;
	e1.size = '8';
	e1.readOnly = 'readonly';
	e1.tabIndex = hdbTabIndex + "2";
	e1.value = document.getElementById('inputDate').value;
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('lb2dddate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2ddTime' + iteration;
	e1.id = 'lb2ddTime' + iteration;
	e1.size = '6';
	e1.value = document.getElementById('inputTime').value;
	 e1.setAttribute("onblur", "IsValidTime(this.value,this.id)");
	 e1.setAttribute("onkeyup", "mask(this.value,this,'2',':')");
	cellRight1.appendChild(e1)

	
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '');
	for(var i=0,j=1;i<=10;i++,j++){
	e1.options[j] = new Option(i, i);
	}
	e1.name = 'dilatation' + iteration;
	e1.id = 'dilatation' + iteration;
	cellRight1.appendChild(e1);

	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'descent' + iteration;
	e1.id = 'descent' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.maxLength='5';
	cellRight1.appendChild(e1);
	
	
}

function addRowContractionLabRoom2() {
	// alert("addRowAntTable");

	var tbl = document.getElementById('lbRoom2ContractionTable');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbCont');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	cellRight1.style.width = '100px';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2Cdate' + iteration;e1.className="dateTextSmall";
	e1.id = 'lb2Cdate' + iteration;
	e1.size = '8';
	e1.readOnly = 'readonly';
	e1.tabIndex = hdbTabIndex + "2";
	e1.value = document.getElementById('inputDate').value;
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('lb2cdate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2CTime' + iteration;
	e1.id = 'lb2CTime' + iteration;
	e1.size = '6';
	e1.value = document.getElementById('inputTime').value;
	 e1.setAttribute("onblur", "IsValidTime(this.value,this.id)");
	 e1.setAttribute("onkeyup", "mask(this.value,this,'2',':')");
	cellRight1.appendChild(e1)

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Mild-Less than 20', '1');
	e1.options[2] = new Option('Moderate 20-40 Sec', '2');
	e1.options[3] = new Option('Strong greater than 40 Sec', '3');
	e1.name = 'contraction_type' + iteration;
	e1.id = 'contraction_type' + iteration;
	cellRight1.appendChild(e1);
	

}


function addRowPRBPLabRoom2() {
	// alert("addRowAntTable");

	var tbl = document.getElementById('lbRoom2PRBPTable');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbprbp');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	cellRight1.style.width = '100px';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2prbpdate' + iteration;e1.className="dateTextSmall";
	e1.id = 'lb2prbpdate' + iteration;
	e1.size = '8';
	e1.readOnly = 'readonly';
	e1.tabIndex = hdbTabIndex + "2";
	e1.value = document.getElementById('inputDate').value;
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('lb2prbpdate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2prbpTime' + iteration;
	e1.id = 'lb2prbpTime' + iteration;
	e1.size = '6';
	e1.value = document.getElementById('inputTime').value;
	 e1.setAttribute("onblur", "IsValidTime(this.value,this.id)");
	 e1.setAttribute("onkeyup", "mask(this.value,this,'2',':')");
	cellRight1.appendChild(e1)

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'pulse' + iteration;
	e1.id = 'pulse' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.onkeyup = function(event) {
		return mask(this.value,this,'3','/');
	};
	e1.maxLength='5';
	e1.size="5";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'systolic' + iteration;
	e1.id = 'systolic' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.maxLength='5';
	e1.size="5";
	cellRight1.appendChild(e1);
	
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'diastolic' + iteration;
	e1.id = 'diastolic' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.maxLength='5';
	e1.size="5";
	cellRight1.appendChild(e1);
	
	
}


function addRowTempLabRoom2() {
	// alert("addRowAntTable");

	var tbl = document.getElementById('lbRoom2TempTable');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbtemp');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	cellRight1.style.width = '100px';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb1tempdate' + iteration;e1.className="dateTextSmall";
	e1.id = 'lb1tempdate' + iteration;
	e1.size = '8';
	e1.readOnly = 'readonly';
	e1.tabIndex = hdbTabIndex + "2";
	e1.value = document.getElementById('inputDate').value;
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('lb1tempdate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb1tempTime' + iteration;
	e1.id = 'lb1tempTime' + iteration;
	e1.size = '6';
	e1.value = document.getElementById('inputTime').value;
	 e1.setAttribute("onblur", "IsValidTime(this.value,this.id)");
	 e1.setAttribute("onkeyup", "mask(this.value,this,'2',':')");
	cellRight1.appendChild(e1)

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'temperature' + iteration;
	e1.id = 'temperature' + iteration;
	e1.onkeypress = function(event) {
		return isNumberKey(event);
	};
	e1.maxLength='5';
	e1.size="5";
	cellRight1.appendChild(e1);
}


function addRowUALabRoom2() {
	// alert("addRowAntTable");

	var tbl = document.getElementById('lbRoom2UATable');
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdbua');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	cellRight1.style.width = '100px';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2uadate' + iteration;e1.className="dateTextSmall";
	e1.id = 'lb2uadate' + iteration;
	e1.size = '8';
	e1.readOnly = 'readonly';
	e1.tabIndex = hdbTabIndex + "2";
	e1.value = document.getElementById('inputDate').value;
	cellRight1.appendChild(e1);

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';

	img1.onclick = function(event) {
		var obj = document.getElementById('lb2uadate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};

	cellRight1.appendChild(img1);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'lb2uaTime' + iteration;
	e1.id = 'lb2uaTime' + iteration;
	e1.size = '6';
	e1.value = document.getElementById('inputTime').value;
	 e1.setAttribute("onblur", "IsValidTime(this.value,this.id)");
	 e1.setAttribute("onkeyup", "mask(this.value,this,'2',':')");
	cellRight1.appendChild(e1)

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'volume' + iteration;
	e1.id = 'volume' + iteration;
	e1.maxLength='5';
	e1.size="5";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('+', '1');
	e1.options[2] = new Option('-', '2');
	e1.name = 'albumin' + iteration;
	e1.id = 'albumin' + iteration;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('+', '1');
	e1.options[2] = new Option('-', '2');
	e1.name = 'acetone' + iteration;
	e1.id = 'acetone' + iteration;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('+', '1');
	e1.options[2] = new Option('-', '2');
	e1.name = 'glucose' + iteration;
	e1.id = 'glucose' + iteration;
	cellRight1.appendChild(e1);
}
function removeRow(form,hdbVal) {
	var tbl = document.getElementById(form);
	var lastRow = tbl.rows.length;
	var hdb;
	var radio = "";
	hdb = document.getElementById(hdbVal);
	radio = "itemRadio";

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


function displayCollapsibleTab(val,obj)
{
	var div = document.getElementById(val);
	if (div.style.display !== "block") {
	   div.style.display = "block";
	   obj.value="-";
	}else {
	   div.style.display = "none";
	   obj.value="+";
	}
}


function validateBpValue(obj,bpObj){
	//var bpObj = document.getElementById('bp');
/*	 var bool =validateBpWithSlash(obj)
	if(bool)
	{*/

	if(obj != ""){
	var index=obj.indexOf('/');
	if(index != 3){
		 alert("BP should be in max/min Format.")
		 bpObj.value="";
		 bpObj.focus();
		 return false;
		 }


		 var pairs2 = obj.substring(0,obj.length).split('/');
		 if (pairs2.length!=2) {
			 alert("Invalid  Format.")
			return false;
			}

		val3=eval(pairs2[0]);
		if (val3>240) {
		  alert("Maximum BP should be less than 240.")
		 return false;}

		val2=eval(pairs2[1]);
		if (val2<60 ) {
		  alert("Minimum BP should not be less than 60")
		  return false;}


	//}
	return true;
	}
	bpObj.value="";
	bpObj.focus();
	return false;
	}

function isBlank(fId)
{
	 if(document.getElementById(fId)!=null && document.getElementById(fId)!="")
	     return false;
	   else
	    	 return true;
	
	
}