var icdArray=new Array();
function addRow1() {

	var tbl = document.getElementById('ftTable');
	var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex').value) + 1;
	document.getElementById('hdbTabIndex').value = hdbTabIndex;

	var lastRow = tbl.rows.length;

	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio' + iteration;
	e1.id = 'itemRadio' + iteration;
	e1.className = 'radioCheck';
	e1.tabIndex = "1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ftdate' + iteration;
	e1.id = 'ftdate' + iteration;
	e1.size = '8';
	e1.readOnly=true;
	e1.className="dateTextSmall validateDate";
	e1.onblur = function(event) {
		checkTrimDate('ftdate' , iteration,'1');ValidateLMPandTrim1Date();openPopupForExamination(iteration,'1');
		/*calculateTrimsterGestationalAge(iteration);*/
	};
	e1.tabIndex ="1";
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
	e1.name = 'ftWeight' + iteration;
	e1.id = 'ftWeight' + iteration;
	e1.setAttribute('validate', 'Weight,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.size = '10';
	e1.tabIndex = "1";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.onblur = function(event) {
	openPopupForExamination(iteration,'1');
	};
	e1.maxLength = '5';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ftGA1' + iteration;
	e1.id = 'ftGA1' + iteration;
	e1.className = "opdTextBoxTSmall";
	e1.placeholder = "Weeks";
	e1.readOnly=true;
	e1.setAttribute('validate', 'Weeks,num,no');
	e1.setAttribute("style", "width:38px"); 
	e1.tabIndex = "1";
	cellRight1.appendChild(e1);

	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ftGA2' + iteration;
	e1.id = 'ftGA2' + iteration;
	e1.readOnly=true;
	e1.setAttribute('validate', 'Days,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.placeholder = "Days";
	e1.tabIndex = "1";
	e1.setAttribute("style", "width:26px"); 
	cellRight1.appendChild(e1);	
	
	/*var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', 'S');
	e1.options[1] = new Option('Yes', 'Y');
	e1.options[2] = new Option('No', 'N');
	e1.name = 'ftPallor' + iteration;
	e1.id = 'ftPallor' + iteration;
	e1.tabIndex ="1";
	e1.className="YesNo"
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', 'S');
	e1.options[1] = new Option('Yes', 'Y');
	e1.options[2] = new Option('No', 'N');
	e1.name = 'ftOdemia' + iteration;
	e1.id = 'ftOdemia' + iteration;
	e1.tabIndex ="1";
	e1.className="YesNo"
	cellRight1.appendChild(e1);*/

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ftsystolic' + iteration;
	e1.id = 'ftsystolic' + iteration;
	e1.setAttribute('validate', 'Systolic,num,no');
	e1.className = "allownumericwithoutdecimal textSmall";
	e1.placeholder = "Systolic";
	e1.tabIndex ="1";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.onblur = function(event) {
		checkSystolicDiastolic('ftsystolic' + iteration,'ftdiastolic' + iteration);
		openPopupForExamination(iteration,'1');

	};
	e1.setAttribute("style", "width:41px"); 
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
	e3.tabIndex = "1";
	e3.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e3.onblur = function(event) {
		checkSystolicDiastolic('ftsystolic' + iteration,'ftdiastolic' + iteration);openPopupForExamination(iteration,'1');

	};
	e3.setAttribute("style", "width:43px"); 
	cellRight1.appendChild(e3);

	/*var e4 = document.createElement('label');
	e4.innerHTML = "mm&nbsp;Hg";
	e4.className = "smallAuto autoSpace";
	cellRight1.appendChild(e4);*/
	
	/*var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', 'S');
	e1.options[1] = new Option('Pallor', 'Pallor');
	e1.options[2] = new Option('Icterus', 'Icterus');
	e1.options[3] = new Option('Cyanosis', 'Cyanosis');
	e1.options[4] = new Option('Lymphadenopathy', 'Lymphadenopathy');
	e1.options[5] = new Option('Edema', 'Edema');
	e1.name = 'ftGeneralExaminationTrim' + iteration;
	e1.id = 'ftGeneralExaminationTrim' + iteration;
	e1.tabIndex = "1";
	cellRight1.appendChild(e1);*/
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('textarea');
	e1.className = 'autoWidthFocus';
	e1.name = 'ftGeneralExaminationTrim' + iteration;
	e1.id = 'ftGeneralExaminationTrim' + iteration;
	e1.tabIndex = "1";
	e1.maxLength = '250';
	e1.size="10";
	e1.onblur = function() {
		openPopupForExamination(iteration,'1');
	};
	e1.setAttribute("placeholder","WNL");
	cellRight1.appendChild(e1);
	


	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('textarea');
	e1.className = 'autoWidthFocus';
	e1.name = 'ftSystemicExam' + iteration;
	e1.id = 'ftSystemicExam' + iteration;
	e1.tabIndex = "1";
	e1.size="10";
	e1.maxLength = '250';
	e1.setAttribute("placeholder","WNL");
	e1.onblur = function() {
		openPopupForExamination(iteration,'1');
	};
	cellRight1.appendChild(e1);
	
	
	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('textarea');
	e1.className = 'autoWidthFocus';
	e1.name = 'ftPA' + iteration;
	e1.id = 'ftPA' + iteration;
	e1.tabIndex ="1";
	e1.setAttribute("placeholder","WNL");
	e1.maxLength = '50';
	e1.onblur = function() {
		openPopupForExamination(iteration,'1');
	};
	e1.size ="10";
	cellRight1.appendChild(e1);
	
	
	/*var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ftFhs' + iteration;
	e1.id = 'ftFhs' + iteration;
	e1.setAttribute("style", "width:28px"); 
	e1.setAttribute('validate', 'ftFhs,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.tabIndex ="1";
	cellRight1.appendChild(e1);
*/
	

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('textarea');
	e1.className = 'autoWidthFocus';
	e1.name = 'ftPV' + iteration;
	e1.id = 'ftPV' + iteration;
	e1.tabIndex ="1";
	e1.size="10";
	e1.setAttribute("placeholder","Not Done");
	e1.maxLength = '50';
	e1.onblur = function() {
		openPopupForExamination(iteration,'1');
	};
	/*e1.tabIndex = hdbTabIndex + "8";*/
	cellRight1.appendChild(e1);

	
	
	/*var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ftObsRi' + iteration;
	e1.id = 'ftObsRi' + iteration;
	e1.tabIndex = "1";
	cellRight1.appendChild(e1);*/
	
	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('select');
	if(document.getElementById('riskId')!=null && document.getElementById('riskId').value=="High")
		e1.options[0] = new Option('High', 'High');	
	else
		{
		e1.options[0] = new Option('Low', 'Low');
		e1.options[1] = new Option('High', 'High');	
		}
	
	e1.name = 'ftObsRi' + iteration;
	e1.id = 'ftObsRi' + iteration;
	e1.onblur = function(event) {
		openPopupForExamination(iteration,'1');
		};
	e1.tabIndex = "1";
	
	e1.className="smallnew";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ftothersTrim' + iteration;
	e1.id = 'ftothersTrim' + iteration;
	e1.setAttribute('validate', 'othersFirstTrim,string,no');
	//e1.className = "opdTextBoxTSmall";
	e1.tabIndex ="1";
	e1.size ="22";
	e1.maxLength = '50';
	e1.onblur = function() {
		openPopupForExamination(iteration,'1');
	};
	cellRight1.appendChild(e1);
	
	getWeight('ftWeight' + iteration);
	//calculateTrimsterGestationalAge(iteration);
	
}

function addRow2() {
	var tbl = document.getElementById('stTable');
	var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex1').value) + 1;
	document.getElementById('hdbTabIndex1').value = hdbTabIndex;

	var lastRow = tbl.rows.length;

	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdb1');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio1' + iteration;
	e1.id = 'itemRadio1' + iteration;
	e1.className = 'radioCheck';
	e1.tabIndex = "1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stdate' + iteration;
	e1.id = 'stdate' + iteration;
	e1.size = '8';
	e1.className="dateTextSmall ValidateLMPandTrim2Date";
/*	e1.value = document.getElementById('inputDate').value;*/
	e1.onblur = function(event) {
		checkTrimDate('stdate' , iteration,'2');ValidateLMPandTrim2Date();openPopupForExamination(iteration,'2');

		/*calculateSecondTrimsterGestationalAge(iteration);*/
	};
	e1.tabIndex ="1";


	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';
	img1.onclick = function(event) {
		var obj = document.getElementById('stdate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};
	

	var dv = document.createElement("div");
	dv.style.width = "115px";
	dv.style.float = "left";
	dv.appendChild(e1);
	dv.appendChild(img1);
	cellRight1.appendChild(dv);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stGA1' + iteration;
	e1.id = 'stGA1' + iteration;
	e1.setAttribute('validate', 'Weeks,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.placeholder = "Weeks";
	e1.readOnly = true;
	e1.tabIndex = "1";
	e1.setAttribute("style", "width:38px");
	e1.onblur = function(event) {
		openPopupForExamination(iteration,'2');
		};
	
	
	var dv = document.createElement("div");
	dv.style.width = "85px";
	dv.style.float = "left";
	dv.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stGA2' + iteration;
	e1.id = 'stGA2' + iteration;
	e1.setAttribute('validate', 'Days,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.placeholder = "Days";
	e1.readOnly = true;
	e1.tabIndex ="1";
	e1.setAttribute("style", "width:26px"); 
	dv.appendChild(e1);
	cellRight1.appendChild(dv);
	
	

	
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stWeight' + iteration;
	e1.id = 'stWeight' + iteration;
	e1.setAttribute('validate', 'Weight,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.size = '10';
	e1.tabIndex = "1";
	e1.maxLength = '5';
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.onblur = function() {
		openPopupForExamination(iteration,'2');
	};

	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('textarea');
	e1.className = 'autoWidthFocus';
	e1.name = 'stGeneralExaminationTrim' + iteration;
	e1.id = 'stGeneralExaminationTrim' + iteration;
	e1.setAttribute("placeholder","WNL");
	e1.size = '10';
	e1.tabIndex = "1";
	e1.maxLength = '250';
	e1.onblur = function() {
		openPopupForExamination(iteration,'2');
	};
	cellRight1.appendChild(e1);
	
	/*var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', 'S');
	e1.options[1] = new Option('Yes', 'Y');
	e1.options[2] = new Option('No', 'N');
	e1.name = 'stPallor' + iteration;
	e1.id = 'stPallor' + iteration;
	e1.tabIndex ="1";
	e1.className="YesNo"
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', 'S');
	e1.options[1] = new Option('Yes', 'Y');
	e1.options[2] = new Option('No', 'N');
	e1.name = 'stOdemia' + iteration;
	e1.id = 'stOdemia' + iteration;
	e1.className="YesNo"
	e1.tabIndex = "1";
	cellRight1.appendChild(e1);*/

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stsystolic' + iteration;
	e1.id = 'stsystolic' + iteration;
	e1.setAttribute('validate', 'Systolic,num,no');
	e1.className = "allownumericwithoutdecimal textSmall";
	e1.placeholder = "Systolic";
	e1.setAttribute("style", "width:43px"); 
	e1.tabIndex ="1";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.onblur = function(event) {
		checkSystolicDiastolic('stsystolic' + iteration,'stdiastolic' + iteration);openPopupForExamination(iteration,'2');
	
	};

	var dv = document.createElement("div");
		dv.style.width = "146px";
		dv.style.float = "left";
		dv.appendChild(e1);
		var e2 = document.createElement('label');
		e2.innerHTML = "/";
		e2.className = "smallAuto autoSpace";
		dv.appendChild(e2);
		var e3 = document.createElement('input');
		e3.type = 'text';
		e3.name = 'stdiastolic' + iteration;
		e3.id = 'stdiastolic' + iteration;
		e1.setAttribute('validate', 'Diastolic,num,no');
		e3.className = "allownumericwithoutdecimal textSmall";
		e3.placeholder = "Diastolic";
		e3.tabIndex = "1";
		e3.setAttribute("style", "width:43px"); 
		e3.onkeypress = function (event) {
			  javascript: return isNumber(event);
		};
		e3.onblur = function(event) {
			checkSystolicDiastolic('stsystolic' + iteration,'stdiastolic' + iteration);
		};
		dv.appendChild(e3);
	cellRight1.appendChild(dv);





	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('textarea');
	e1.className = 'autoWidthFocus';
	e1.name = 'stPA' + iteration;
	e1.id = 'stPA' + iteration;
	e1.setAttribute("placeholder","WNL");
	e1.tabIndex = "1";
	e1.placeholder="NAD";
	e1.size="10";
	e1.maxLength = '50';
	e1.onblur = function() {
		openPopupForExamination(iteration,'2');
	};
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stFhs' + iteration;
	e1.id = 'stFhs' + iteration;
	e1.setAttribute('validate', 'stFhs,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.setAttribute("style", "width:28px"); 
	e1.tabIndex = "1";
	e1.onblur = function(event) {
		openPopupForExamination(iteration,'2');
		};
	cellRight1.appendChild(e1);	
	
	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stFh' + iteration;
	e1.id = 'stFh' + iteration;
	e1.setAttribute("placeholder","+");
	e1.setAttribute('validate', 'stFh,string,no');
	e1.className = "opdTextBoxTSmall";
	e1.setAttribute("style", "width:28px"); 
	e1.tabIndex = "1";
	e1.onblur = function(event) {
		openPopupForExamination(iteration,'2');
		};
	cellRight1.appendChild(e1);
		
	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('textarea');
	e1.className = 'autoWidthFocus';
	e1.name = 'stSystemicExam' + iteration;
	e1.id = 'stSystemicExam' + iteration;
	e1.maxLength = '250';
	e1.setAttribute("placeholder","WNL");
	e1.tabIndex ="1";
	e1.onblur = function() {
		openPopupForExamination(iteration,'2');
	};
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stUrinAl' + iteration;
	e1.id = 'stUrinAl' + iteration;
	e1.setAttribute('validate', 'Urine Albumin,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.size = '10';
	e1.tabIndex = "1";
	e1.onblur = function(event) {
		openPopupForExamination(iteration,'2');
		};
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(11);	
	var e1 = document.createElement('select');
	if(document.getElementById('riskId')!=null && document.getElementById('riskId').value=="High")
		e1.options[0] = new Option('High', 'High');	
	else
		{
		e1.options[0] = new Option('Low', 'Low');
		e1.options[1] = new Option('High', 'High');	
		}
	
	

	e1.name = 'stObsRi' + iteration;
	e1.id = 'stObsRi' + iteration;
	e1.tabIndex ="1";
	e1.className="smallnew";
	e1.onblur = function(event) {
		openPopupForExamination(iteration,'2');
		};
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(12);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'stothersTrim' + iteration;
	e1.id = 'stothersTrim' + iteration;
	e1.setAttribute('validate', 'othersSecondTrim,string,no');
	//e1.className = "opdTextBoxTSmall";
	e1.tabIndex ="1";
	e1.maxLength = '50';
	e1.size ="22";
	e1.onblur = function(event) {
		openPopupForExamination(iteration,'2');
		};
	cellRight1.appendChild(e1);

	getWeight('stWeight' + iteration);
	//calculateSecondTrimsterGestationalAge(iteration);

}



function addRow3() {

	var tbl = document.getElementById('ttTable');
	var hdbTabIndex = parseInt(document.getElementById('hdbTabIndex2').value) + 1;
	document.getElementById('hdbTabIndex2').value = hdbTabIndex;

	var lastRow = tbl.rows.length;

	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hdb2');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'itemRadio2' + iteration;
	e1.id = 'itemRadio2' + iteration;
	e1.className = 'radioCheck';
	e1.tabIndex ="1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttdate' + iteration;
	e1.id = 'ttdate' + iteration;
	e1.className="dateTextSmall ValidateLMPandTrim3Date";
/*	e1.value = document.getElementById('inputDate').value;*/
	e1.size = '8';
	e1.onblur = function(event) {
		checkTrimDate('ttdate' , iteration,'3');ValidateLMPandTrim3Date();openPopupForExamination(iteration,'3');
	
		/*calculateThirdTrimsterGestationalAge(iteration);*/
	};
	e1.tabIndex ="1";

	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';
	img1.onclick = function(event) {
		var obj = document.getElementById('ttdate' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};
	

	var dv = document.createElement("div");
	dv.style.width = "115px";
	dv.style.float = "left";
	dv.appendChild(e1);
	dv.appendChild(img1);
	cellRight1.appendChild(dv);
	
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttGA1' + iteration;
	e1.id = 'ttGA1' + iteration;
	e1.setAttribute('validate', 'Weeks,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.readOnly=true;
	e1.placeholder = "Weeks";
	e1.tabIndex = "1";
	e1.setAttribute("style", "width:38px"); 

	var dv = document.createElement("div");
	dv.style.width = "85px";
	dv.style.float = "left";
	dv.appendChild(e1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttGA2' + iteration;
	e1.id = 'ttGA2' + iteration;
	e1.setAttribute('validate', 'Days,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.readOnly=true;
	e1.placeholder = "Days";
	e1.tabIndex = "1";
	e1.setAttribute("style", "width:26px"); 
	dv.appendChild(e1);
	cellRight1.appendChild(dv);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttWeight' + iteration;
	e1.id = 'ttWeight' + iteration;
	e1.setAttribute('validate', 'Weight,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.size = '10';
	e1.tabIndex ="1";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.onblur = function() {
		openPopupForExamination(iteration,'3');
	};
	e1.maxLength = '5';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(4);	
	var e1 = document.createElement('textarea');
	e1.className = 'autoWidthFocus';
	e1.name = 'ttGeneralExaminationTrim' + iteration;
	e1.id = 'ttGeneralExaminationTrim' + iteration;
	e1.tabIndex ="1";
	e1.maxLength = '250';
	e1.onblur = function() {
		openPopupForExamination(iteration,'3');
	};
	e1.setAttribute("placeholder","WNL");
	cellRight1.appendChild(e1);	
	
	
	/*var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', 'S');
	e1.options[1] = new Option('Yes', 'Y');
	e1.options[2] = new Option('No', 'N');
	e1.name = 'ttPallor' + iteration;
	e1.id = 'ttPallor' + iteration;
	e1.tabIndex = "1";
	e1.className="YesNo"
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', 'S');
	e1.options[1] = new Option('Yes', 'Y');
	e1.options[2] = new Option('No', 'N');
	e1.name = 'ttOdemia' + iteration;
	e1.id = 'ttOdemia' + iteration;
	e1.tabIndex = "1";
	e1.className="YesNo"
	cellRight1.appendChild(e1);*/

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttsystolic' + iteration;
	e1.id = 'ttsystolic' + iteration;
	e1.setAttribute('validate', 'Systolic,num,no');
	e1.setAttribute("style", "width:41px"); 
	e1.className = "allownumericwithoutdecimal textSmall";
	e1.placeholder = "Systolic";
	e1.tabIndex = "1";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.onblur = function(event) {
		checkSystolicDiastolic('ttsystolic' + iteration,'ttdiastolic' + iteration);openPopupForExamination(iteration,'3');

	};
	cellRight1.appendChild(e1);
	
	var dv = document.createElement("div");
	dv.style.width = "146px";
	dv.style.float = "left";
	dv.appendChild(e1);
	var e2 = document.createElement('label');
	e2.innerHTML = "/";
	e2.className = "smallAuto autoSpace";
	dv.appendChild(e2);

	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name = 'ttdiastolic' + iteration;
	e3.id = 'ttdiastolic' + iteration;
	e1.setAttribute('validate', 'Diastolic,num,no');
	e3.className = "allownumericwithoutdecimal textSmall";
	e3.placeholder = "Diastolic";
	e3.setAttribute("style", "width:43px"); 
	e3.tabIndex = "1";
	e3.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e3.onblur = function(event) {
		checkSystolicDiastolic('ttsystolic' + iteration,'ttdiastolic' + iteration);openPopupForExamination(iteration,'3');
	};
	dv.appendChild(e3);
	cellRight1.appendChild(dv);
	

	
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('textarea');
	e1.className = 'autoWidthFocus';
	e1.name = 'ttPA' + iteration;
	e1.id = 'ttPA' + iteration;
	e1.tabIndex = "1";
	e1.size="10";
	e1.placeholder="WNL";
	e1.maxLength = '50';
	e1.onblur = function() {
		openPopupForExamination(iteration,'3');
	};
	cellRight1.appendChild(e1);

	/*var e4 = document.createElement('label');
	e4.innerHTML = "mm&nbsp;Hg";
	e4.className = "smallAuto autoSpace";
	cellRight1.appendChild(e4);*/
	
	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttFhs' + iteration;
	e1.id = 'ttFhs' + iteration;
	e1.setAttribute('validate', 'ttFhs,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.setAttribute("style", "width:28px"); 
	e1.tabIndex = "1";
	e1.onblur = function() {
		openPopupForExamination(iteration,'3');
	};
	cellRight1.appendChild(e1);
			
	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttFh' + iteration;
	e1.id = 'ttFh' + iteration;
	e1.style.width="28px";
	e1.setAttribute("placeholder","+");
	e1.tabIndex = "1";
	e1.onblur = function() {
		openPopupForExamination(iteration,'3');
	};
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('textarea');
	e1.className = 'autoWidthFocus';
	e1.name = 'ttSystemicExam' + iteration;
	e1.id = 'ttSystemicExam' + iteration;
	e1.setAttribute("placeholder","WNL");
	e1.tabIndex = "1";
	e1.onblur = function() {
		openPopupForExamination(iteration,'3');
	};
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ttUrinAl' + iteration;
	e1.id = 'ttUrinAl' + iteration;
	e1.setAttribute('validate', 'Urine Albumin,num,no');
	e1.className = "opdTextBoxTSmall";
	e1.size = '10';
	e1.maxLength = '5';
	e1.tabIndex = "1";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('select');
	if(document.getElementById('riskId')!=null && document.getElementById('riskId').value=="High")
		e1.options[0] = new Option('High', 'High');	
	else
		{
		e1.options[0] = new Option('Low', 'Low');
		e1.options[1] = new Option('High', 'High');	
		}
	e1.name = 'ttObsRi' + iteration;
	e1.id = 'ttObsRi' + iteration;
	e1.tabIndex = "1";
	e1.className="smallnew";
	e1.onblur = function() {
		openPopupForExamination(iteration,'3');
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(12);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'ttothersTrim' + iteration;
	e1.id = 'ttothersTrim' + iteration;
	e1.setAttribute('validate', 'othersThirdTrim,string,no');
	//e1.className = "opdTextBoxTSmall";
	e1.tabIndex ="1";
	e1.size ="22";
	e1.maxLength = '50';
	e1.onblur = function() {
		openPopupForExamination(iteration,'3');
	};
	
	cellRight1.appendChild(e1);
	//getWeight('ttWeight' + iteration);
	//calculateThirdTrimsterGestationalAge(iteration);
	
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

	if (form == 'pastMedHistTable') {
		hdb = document.getElementById('pmhhdb');
		radio = "pmhitemRadio";
	}
	if (form == 'infectionTable') {
		hdb = document.getElementById('ancInfCount');
		radio = "ancInfRadio";
	}
	if (form == 'surgeryTable') {
		hdb = document.getElementById('surgeryCount');
		radio = "surgeryRadio";
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
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById(radio + i) != null
					&& (typeof document.getElementById(radio + i).checked) != 'undefined'
					&& document.getElementById(radio + i).checked) {
				var deleteRow = document.getElementById(radio + i).parentNode.parentNode;
				document.getElementById(radio + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
				openPopupForExamination(iteration,'1');
				openPopupForExamination(iteration,'2');
				openPopupForExamination(iteration,'3');
			}
		}

	}
}


// first trimester validation
function ftTrimValid() {
	var result = false;
	var count = 0;
	var iteration;
	var hdb = document.getElementById('hdb');
	iteration = parseInt(hdb.value) + 1;
	var sg, ga1, ga2, bp1, bp2, pv, pa, weight;

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


function addRowAntTable() {
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
	e1.tabIndex ="1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'year' + iteration;
	e1.id = 'year' + iteration;
	e1.setAttribute('validate', 'Year,num,no');
	e1.size = '3';
	e1.maxLength = '2';
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.tabIndex  ="1";

	/*e1.oninput = function(event) {
		callAge('year' + iteration, 'ageUnit' + iteration);
	};*/
	e1.readOnly = 'readOnly';
	e1.value = iteration;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'ageUnit' + iteration;
	e1.id = 'ageUnit' + iteration;
	e1.setAttribute('validate', 'Age,num,no');
	e1.onchange = function(){checkMotherPreviousPregnancyAge(this.value,this.id);checkNoOfPreganancy(iteration);};
	e1.tabIndex  = "1";
	e1.size = '3';
	e1.maxLength = '2';
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('select', '');
	e1.options[1] = new Option('FTND', 'FTND');
	e1.options[2] = new Option('Vacuum', 'Vacuum');
	e1.options[3] = new Option('Forceps', 'Forceps');
	e1.options[4] = new Option('LSCS', 'LSCS');
	e1.options[5] = new Option('Abortion', 'Abortion');
	e1.options[6] = new Option('Ectopic', 'Ectopic');
	e1.options[7] = new Option('Vesicular Mole', 'Vesicular Mole');
	e1.options[8] = new Option('Pre Term', 'Pre Term');
	e1.options[9] = new Option('VBAC', 'VBAC');
	e1.name = 'pregnancyOutcome' + iteration;
	e1.id = 'pregnancyOutcome' + iteration;
	e1.className= "smallnew";
	e1.onchange = function(){displayPreTermValue(this.value,iteration);};
	e1.tabIndex = "1";
	var e11 = document.createElement('input');
	e11.type = 'text';
	e11.name = 'preTermValue' + iteration;
	e11.id = 'preTermValueId' + iteration;
	e11.setAttribute('validate', 'Oters,string,no');
	e11.tabIndex ="1";
	e11.size = '11';
	e11.style.display='none';
	e11.style.display='margin-top:5px';
	cellRight1.appendChild(e1);
	cellRight1.appendChild(e11);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('CHC', 'CHC');
	e1.options[2] = new Option('PHC', 'PHC');
	e1.options[3] = new Option('District Hospital', 'District Hospital');
	e1.options[4] = new Option('Private', 'Private');
	e1.options[5] = new Option('Others', 'Others');
	e1.name = 'placeOfDelivery' + iteration;
	e1.id = 'placeOfDelivery' + iteration;
	e1.className= "smallnew";
	e1.onchange = function(){displayOthersValue(this.value,iteration);};
	e1.tabIndex = "1";
	var e11 = document.createElement('input');
	e11.type = 'text';
	e11.name = 'placeOfDeliveryOthers' + iteration;
	e11.id = 'placeOfDeliveryOtherId' + iteration;
	e11.setAttribute('validate', 'Others,string,no');
	e11.tabIndex ="1";
	e11.size = '11';
	e11.maxLength = 100;
	e11.style.display='none';
	e11.style.display='margin-top:5px';
	cellRight1.appendChild(e1);
	cellRight1.appendChild(e11);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Live', 'Live');
	e1.options[2] = new Option('Still Birth', 'Still Birth');
	e1.options[3] = new Option('IUD', 'IUD');
	e1.options[4] = new Option('NND', 'NND');
	e1.name = 'deliveryOutcome' + iteration;
	e1.id = 'deliveryOutcome' + iteration;
	e1.className= "smallnew";
	e1.tabIndex ="1";
	e1.onchange = function(){displayLiveBirthValue(this.value,iteration);};
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('select');
	e1.name = 'sex' + iteration;
	e1.id = 'sex' + iteration;
	e1.tabIndex = "1";
	e1.className= "smallnew";
	e1.options[0] = new Option('Select', '');
	for (var i = 0; i < icdArray.length; i++) {
		e1.options[i + 1] = new Option(icdArray[i][1], icdArray[i][0]);
	}
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'previousGestationalAge' + iteration;
	e1.id = 'previousGestationalAgeId' + iteration;
	//e1.size = '5';
	e1.setAttribute("style", "width:35px");
	e1.maxLength = '3';
	e1.tabIndex ="1";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.onchange = function(){checkGAInPreviousPregnancy(this.value,this.id);};
	cellRight1.appendChild(e1);

	/*var e2 = document.createElement('label');
	e2.innerHTML = "weeks";
	e2.className = "smallAuto autoSpace";
	cellRight1.appendChild(e2);*/

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'birthWeight' + iteration;
	e1.id = 'birthWeight' + iteration;
	//e1.size = '5';
	e1.setAttribute("style", "width:35px");
	e1.maxLength = '5';
	e1.tabIndex ="1";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	cellRight1.appendChild(e1);

	/*var e2 = document.createElement('label');
	e2.innerHTML = "/kg";
	e2.className = "smallAuto autoSpace";
	cellRight1.appendChild(e2);*/

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'antenatal' + iteration;
	e1.id = 'antenatal' + iteration;
	// e1.size = '20';
	e1.tabIndex = "1";
	e1.setAttribute("style", "width:60px");
	e1.maxLength = '220';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'intraPartum' + iteration;
	e1.id = 'intraPartum' + iteration;
	e1.tabIndex = "1";
	e1.setAttribute("style", "width:60px");
	e1.maxLength = '220';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'postPartum' + iteration;
	e1.id = 'postPartum' + iteration;
	e1.maxLength = '220';
	e1.setAttribute("style", "width:60px");
	e1.tabIndex ="1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(12);
	var e1 = document.createElement('select');
	e1.options[0] = new Option('Select', 'S');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	e1.name = 'BloodTransfusion' + iteration;
	e1.id = 'BloodTransfusion' + iteration;
	e1.tabIndex = "1";
	e1.className= "YesNo"
	cellRight1.appendChild(e1);

}

// Antenatal validation
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
			$("#AntCount").val(1);
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

function selectYesNo(yesId, NoId, childId, name) {
	jQuery(function($) {
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
	});
}

function gravidaAbortionTwo() {
	jQuery(function($) {
	if ($("#b4").val() == 2 && $("#b6").val() == 2) {
		$("#b5").val(0);
		$("#b7").val(0);
	}
	});
}


function checkDate() {
	var vDate = new Date();
	var result = false;
	var dobDate1 = document.getElementById('lmpId').value;
	var dobDate3 = document.getElementById('date3Id').value;
	var dobDate4 = document.getElementById('date4Id').value;
	if (dobDate1 != "") {
		var d1 = new Date(dobDate1.substring(6),
				(dobDate1.substring(3, 5) - 1), dobDate1.substring(0, 2));
		if (vDate < d1) {
			alert("Please enter valid Lmp date.");
			document.getElementById('lmpId').value = "";
			document.getElementById('eddId').value = "";
			result = false;
		} else {
			result = true;
		}
	}

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

	return result;

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
	jQuery(function($) {
	var weight = $("#b27").val();
	$("#" + curId).val(weight);
	});
}

function setWeight() {
	jQuery(function($) {
	var weight = $("#b27").val();
	$("#ftWeight0").val(weight);
	$("#stWeight0").val(weight);
	$("#ttWeight0").val(weight);
	$("#f4tWeight0").val(weight);
	});
}

function addPMHRow() {
	var tbl = document.getElementById('pastMedHistTable');
	var hdbTabIndex = parseInt(document.getElementById('pmhhdbTabIndex').value) + 1;
	document.getElementById('pmhhdbTabIndex').value = hdbTabIndex;

	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('pmhhdb');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	var patAge= document.getElementById('patAge').value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'pmhitemRadio' + iteration;
	e1.id = 'pmhitemRadio' + iteration;
	e1.className = 'radioCheck';
	e1.tabIndex = "1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('select');
	e1.onchange = function(){ShowHideDisease(iteration);};
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Diabetes Mellitus - Type I', 'Diabetes Mellitus - Type I');
	e1.options[2] = new Option('Diabetes Mellitus - Type II', 'Diabetes Mellitus - Type II');
	e1.options[3] = new Option('Hypertension', 'Hypertension');
	e1.options[4] = new Option('Coronary Artery Disease', 'Coronary Artery Disease');
	e1.options[5] = new Option('Cancer', 'Cancer');
	e1.options[6] = new Option('Chronic Kidney Disease', 'Chronic Kidney Disease');
	e1.options[7] = new Option('Seizure disorder', 'Seizure disorder');
	e1.options[8] = new Option('Heart disease', 'Heart disease');
	e1.options[9] = new Option('Asthma', 'Asthma');
	e1.options[10] = new Option('Psychiatric disease', 'Psychiatric disease');
	e1.options[11] = new Option('Thrombotic disease', 'Thrombotic disease');
	e1.options[12] = new Option('Hematological disease', 'Hematological disease');
	e1.options[13] = new Option('Renal disease', 'Renal disease');
	e1.options[14] = new Option('SLE', 'SLE');
	e1.options[15] = new Option('PCOD', 'PCOD');
	e1.options[16] = new Option('Hepatitis B Carrier', 'Hepatitis B Carrier');
	e1.options[17] = new Option('VDRL +ve', 'VDRL +ve');
	e1.options[18] = new Option('HCV carrier', 'HCV carrier');
	e1.options[19] = new Option('HIV +ve', 'HIV +ve');
	e1.options[20] = new Option('APLA', 'APLA');	
	
	e1.options[21] = new Option('Osteoporosis', 'Osteoporosis');
	e1.options[22] = new Option('Osteogenesis', 'Osteogenesis');
	e1.options[23] = new Option('Connective tissue disorder', 'Connective tissue disorder');
	e1.options[24] = new Option('CPD', 'CPD');
	e1.options[25] = new Option('Congenital diseases', 'Congenital diseases');
	
	e1.options[26] = new Option('Others', 'Others');
	e1.name = 'comorbidity' + iteration;
	e1.id = 'comorbidity' + iteration;
	//e1.tabIndex =  "1";
	e1.onchange = function() {
		populatePastHistorySummary();
	};
	e1.onchange = function() {
		ShowHideDisease(iteration);
	};
	cellRight1.appendChild(e1);
	
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'comChronicDisease' + iteration;
	e1.id = 'comChronicDisease' + iteration;
	e1.style.cssText = 'display : none;'
	e1.placeholder='Chronic Disease';
	e1.onkeyup = function() {
		populatePastHistorySummary();
	};
	// e1.size = '20';
	//e1.tabIndex = "1";
	cellRight1.appendChild(e1);
	
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'comOtherDisease' + iteration;
	e1.id = 'comOtherDisease' + iteration;
	e1.style.cssText = 'display : none;'
	e1.placeholder='Other Disease';
	e1.onkeyup = function() {
		populatePastHistorySummary();
	};
	// e1.size = '20';
	//e1.tabIndex =  "1";
	e1.maxLength = 300;
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'comYears' + iteration;
	e1.id = 'comYears' + iteration;
	e1.size = '3';
	e1.maxLength = '2';
	//e1.tabIndex = "1";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.onblur = function() {
		yearValidation('comYears'+iteration, patAge);
	};
	e1.onkeyup = function() {
		populatePastHistorySummary();
	};
	cellRight1.appendChild(e1);

	var e2 = document.createElement('label');
	e2.innerHTML = "Years";
	e2.className = "smallAuto";
	cellRight1.appendChild(e2);

	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'comMonths' + iteration;
	e1.id = 'comMonths' + iteration;
	e1.size = '3';
	e1.maxLength = '2';
	//e1.tabIndex =  "1";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.onchange = function(){monthValidation(this.value,this.id);};
	e1.onkeyup = function() {
		populatePastHistorySummary();
	};
	cellRight1.appendChild(e1);

	var e2 = document.createElement('label');
	e2.innerHTML = "Months";
	e2.className = "smallAuto";
	cellRight1.appendChild(e2);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'comRemarks' + iteration;
	e1.id = 'comRemarks' + iteration;
	e1.onkeypress = function() {
		selectSNOMEDCT('ACTIVE', 'DISORDER', 'ALL', returnlimit_IN,
				callbck_index, 'comRemarks' + iteration);
	};
	e1.onkeyup = function() {
		populatePastHistorySummary();
	};
	// e1.size = '20';
	e1.maxLength = '250';
	//e1.tabIndex =  "1";
	cellRight1.appendChild(e1);

}

function ShowHideDisease(inc) {
	
	var value = document.getElementById('comorbidity' + inc).value;
	if(value == 'Chronic Disease') {
		document.getElementById("comChronicDisease" + inc).style.display = 'block';
	} else {
		document.getElementById("comChronicDisease" + inc).style.display = 'none';
	}
	if(value == 'Others') {
		document.getElementById("comOtherDisease" + inc).style.display = 'block';
	} else {
		document.getElementById("comOtherDisease" + inc).style.display = 'none';
	}
}

function pmhValid() {
	var result = false;
	var count = 0;
	var iteration;
	var hdb = document.getElementById('pmhhdb');
	iteration = parseInt(hdb.value) + 1;

	var sg, pmhYear, pmhMonth;

	for (var i = 0; i < iteration; i++) {
		if (document.getElementById('comorbidity' + i) != null) {
			sg = document.getElementById('comorbidity' + i).value;
		}
		if (document.getElementById('comYears' + i) != null) {
			pmhYear = document.getElementById('comYears' + i).value;
		}
		if (document.getElementById('comMonths' + i) != null) {
			pmhMonth = document.getElementById('comMonths' + i).value;
		}

		if (sg != "") {
			if (pmhYear == "") {
				count = 1;

			} else if (sg != "" && pmhYear != "") {
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
		alert("please enter post medical history details");
		$("#pmhCount").val(0);
		result = false;
	}
	if (count == 0) {
		$("#pmhCount").val(0);
		result = true;
	}
	if (count == 2) {
		$("#pmhCount").val(1);
		result = true;
	}

	return result;
}

function runRadioCheck(consanguineousYes, degree, infertilityYes, factor) {
jQuery(function($) {
	if (consanguineousYes == 'Yes') {
		document.getElementById("consanguineousYes").checked = true;
		$("#degreeYes").show();
	} else {
		document.getElementById("consanguineousYes").checked = false;
	}

	if (consanguineousYes == 'No') {
		document.getElementById("consanguineousNo").checked = true;
		$("#degreeYes").hide();
	} else {
		document.getElementById("consanguineousNo").checked = false;
	}
	if (degree == "Degree 1") {
		document.getElementById("degree1").checked = true;
	} else {
		document.getElementById("degree1").checked = false;
	}
	if (degree == "Degree 2") {
		document.getElementById("degree2").checked = true;
	} else {
		document.getElementById("degree2").checked = false;
	}
	if (degree == "Degree 3") {
		document.getElementById("degree3").checked = true;
	} else {
		document.getElementById("degree3").checked = false;
	}

	if (infertilityYes == "Yes") {
		document.getElementById("infertilityYes").checked = true;
		$("#factorYes").show();
	} else {
		document.getElementById("infertilityYes").checked = false;
	}
	if (infertilityYes == "No") {
		document.getElementById("infertilityNo").checked = true;
		$("#factorYes").hide();
	} else {
		document.getElementById("infertilityNo").checked = false;
	}

	if (factor == "Male Factor") {
		document.getElementById("maleFactor").checked = true;
	} else {
		document.getElementById("maleFactor").checked = false;
	}
	if (factor == "Female Factor") {
		document.getElementById("femaleFactor").checked = true;
	} else {
		document.getElementById("femaleFactor").checked = false;
	}
	if (factor == "Both") {
		document.getElementById("both").checked = true;
	} else {
		document.getElementById("both").checked = false;
	}
	if (factor == "Un Explained") {
		document.getElementById("unExplained").checked = true;
	} else {
		document.getElementById("unExplained").checked = false;
	}
});
}

function checkTrimDate(trimDate,inc,trimNo) {
	var vDate = new Date();
	var result = false;
	var trimDate1 = document.getElementById(trimDate+inc).value;
	if (trimDate1 != "") {
		var prefix;
		if(trimNo==1)
			prefix = "ft";
		else if(trimNo==2)
			prefix = "st";
		else if(trimNo==3)
			prefix = "tt";
		var d1 = new Date(trimDate1.substring(6),
				(trimDate1.substring(3, 5) - 1), trimDate1.substring(0, 2));
		if (vDate < d1) {
			alert("Please enter valid date");
			document.getElementById(trimDate+inc).value = "";
			document.getElementById(prefix+"GA1"+inc).value = "";
			document.getElementById(prefix+"GA2"+inc).value = "";
			result = false;
		} else {
			calculateTrimesterGA(trimDate1,inc,trimNo);
/*				if(trimNo==1)
					calculateTrimsterGestationalAge(inc);
				else if(trimNo==2)
					calculateSecondTrimsterGestationalAge(inc);
				else if(trimNo==3)
					calculateThirdTrimsterGestationalAge(inc);*/
				
				
			result = true;
		}
	}
	return result;

}


//------------------------------jsp java script-------------------------------------------

function changeClass(title,t)
{
//animatedcollapse.toggle(title,t);
setTimeout(function(){ animatedcollapse.toggle(title,t); }, 3000)
}

function showHideTrim(div1,id){
	var str=document.getElementById(id).getAttribute('class');
	if(str=="minus"){
	document.getElementById(id).setAttribute('class','plus');
	}else if(str==null){
		document.getElementById(id).setAttribute('class','minus');
	}else{
		document.getElementById(id).setAttribute('class','minus');
	}
	
$("#"+div1).animate({
	height: 'toggle'
});
}

function displayYes(){
    document.getElementById("degreeYes").style.display = 'block';
}
function displayNo(){
    document.getElementById("degreeYes").style.display = 'none';
    document.getElementById("degree1").checked = false;
    document.getElementById("degree2").checked = false;
    document.getElementById("degree3").checked = false;
}
function displayFactor(){
    document.getElementById("factorYes").style.display = 'block';
}
function displayFactorNo(){
    document.getElementById("factorYes").style.display = 'none';
    document.getElementById("maleFactor").checked = false;
    document.getElementById("femaleFactor").checked = false;
    document.getElementById("both").checked = false;
    document.getElementById("unExplained").checked = false;
}

function chronicDisease(inc) {
	var value = document.getElementById("comorbidity"+inc).value;
	if(value == 'Chronic Disease') {
		document.getElementById("comChronicDisease" + inc).style.display = 'block';
	} else {
		document.getElementById("comChronicDisease" + inc).style.display = 'none';
	}
	if(value == 'Others') {
		document.getElementById("comOtherDisease" + inc).style.display = 'block';
	} else {
		document.getElementById("comOtherDisease" + inc).style.display = 'none';
	}
};

function displayPreTermValue(val,inc){
	
	
	 var x=document.getElementById("pregnancyOutcome");
	    for (var i = 0; i < x.options.length; i++) {
	    	if(x.options[i].selected){
	    	   if(x.options[i].value == 'Pre Term') {
	    	  		document.getElementById("preTermValueId").style.display = 'block';
	    	  		break;
	    	  	} else {
	    	  		document.getElementById("preTermValueId").style.display = 'none';
	    	  	}
	    	  }
	    }
	
}
	
	function displayOthersValue(val,inc){
		if(val == 'Others') {
			document.getElementById("placeOfDeliveryOtherId").style.display = 'block';
		} else {
			document.getElementById("placeOfDeliveryOtherId").style.display = 'none';
		}
	}
	function selectReferredFrom(val){
		if(val == 'Yes') {
			document.getElementById('referredFromPrivateValueDiv').style.display = 'block';
		} else {
			document.getElementById('referredFromPrivateValueDiv').style.display = 'none';
		}
		
	}
	function selectPastSurgicalHistory(val){
		if(val == 'Yes') {
			document.getElementById("pastSurgHistDiv").style.display = 'block';
		} else {
			document.getElementById("pastSurgHistDiv").style.display = 'none';
		}
		
	}
	
	function calculateGestationalAge(){
	var lmpDate = document.getElementById('lmpId').value;
	var scannedEdcdate = document.getElementById('scannedEdc').value;
	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);

	var one_day=1000*60*60*24;
	var weeks=1000*60*60*24*7;
	if(scannedEdcdate==''){
	    var lmp=lmpDate.split("/");
	    var date2=new Date(lmp[2],(lmp[1]-1),lmp[0]);
	
	     diff=Math.floor((currentDate.getTime()-date2.getTime())/(one_day));
	    var weeks= Math.floor(diff/7);
	    var weekDays = weeks*7;
	    var days = diff- weekDays;
	    if(!isNaN(weeks)){
	    	document.getElementById('gestationalAgeWeeksId').value =weeks;
	   }
	    if(!isNaN(days)){
	    if(days==0){
	    	document.getElementById('gestationalAgeDaysId').value= '';
	    	 
	    }else{
	 	 document.getElementById('gestationalAgeDaysId').value= days;
	    }
	  }
 }else{
	 var s = new Date(scannedEdcdate.substring(6),(scannedEdcdate.substring(3,5) - 1) ,scannedEdcdate.substring(0,2));
     s.setMonth((s.getMonth()) - 9);
     s.setDate(s.getDate() - 7);
     
    var curr_date = s.getDate();
    var curr_month = s.getMonth()+1;
    var curr_year = s.getFullYear();
    
    var month;
    var date;
    if(s.getDate() < 10){
    		date = "0"+curr_date;
     		}else{
     			date = curr_date;
     		}
     		
     		if(s.getMonth()+1 < 10){
     			month = "0"+curr_month
     		}else{
     			month = curr_month
     		}
    
    var myDate = (date + "/" + month + "/" + curr_year);
	  document.getElementById('duplicateLMP').value=myDate;
	
	    var scan=myDate.split("/");
	    var date3=new Date(scan[2],(scan[1]-1),scan[0]);
	
	    scandiff=Math.floor((currentDate.getTime()-date3.getTime())/(one_day));
	    var scanweeks= Math.floor(scandiff/7);
	    var scanweekDays = scanweeks*7;
	    var scandays = scandiff- scanweekDays;
	    if(!isNaN(scanweeks)){
	    	document.getElementById('gestationalAgeWeeksId').value =scanweeks;
	   }
	    if(!isNaN(scandays)){
	    if(scandays==0){
	    	document.getElementById('gestationalAgeDaysId').value= '';
	    	 
	    }else{
	 	 document.getElementById('gestationalAgeDaysId').value= scandays;
	    }
	  }
 	} 
    
 }
	
	
	function calculateGestationalAgeForScanEdc(){
		var lmpDate = document.getElementById('lmpId').value;
		var scannedEdcdate = document.getElementById('scannedEdc').value;
		var correctedEdcdate = document.getElementById('edcDate').value;
		currentDate = new Date();
		var month = currentDate.getMonth() + 1
		var day = currentDate.getDate()
		var year = currentDate.getFullYear()
		var seperator = "/"
		currentDate = new Date(month + seperator + day + seperator + year);

		var one_day=1000*60*60*24;
		var weeks=1000*60*60*24*7;
		if(correctedEdcdate!="" || scannedEdcdate!="")
		{
			var s;
			if(correctedEdcdate!="")
		       s = new Date(correctedEdcdate.substring(6),(correctedEdcdate.substring(3,5) - 1) ,correctedEdcdate.substring(0,2));
			else 
				s = new Date(scannedEdcdate.substring(6),(scannedEdcdate.substring(3,5) - 1) ,scannedEdcdate.substring(0,2));
	     s.setMonth((s.getMonth()) - 9);
	     s.setDate(s.getDate() - 7);
	     var curr_date = s.getDate();
		    var curr_month = s.getMonth()+1;
		    var curr_year = s.getFullYear();
		    
		    var month;
		    var date;
		    if(s.getDate() < 10){
		    		date = "0"+curr_date;
		     		}else{
		     			date = curr_date;
		     		}
		     		
		     		if(s.getMonth()+1 < 10){
		     			month = "0"+curr_month
		     		}else{
		     			month = curr_month
		     		}
		    
		    var myDate = (date + "/" + month + "/" + curr_year);
			  document.getElementById('duplicateLMP').value=myDate;
			
			    var scan=myDate.split("/");
			    var date3=new Date(scan[2],(scan[1]-1),scan[0]);
			
			    scandiff=Math.floor((currentDate.getTime()-date3.getTime())/(one_day));
			    var scanweeks= Math.floor(scandiff/7);
			    var scanweekDays = scanweeks*7;
			    var scandays = scandiff- scanweekDays;
			    if(!isNaN(scanweeks)){
			    	document.getElementById('gestationalAgeWeeksId').value =scanweeks;
			   }
			    if(!isNaN(scandays)){
			    if(scandays==0){
			    	document.getElementById('gestationalAgeDaysId').value= '';
			    	 
			    }else{
			 	 document.getElementById('gestationalAgeDaysId').value= scandays;
			    }
			  }
		
		}
	else if(lmpDate !='')
		{
		var lmp=lmpDate.split("/");
	    var date2=new Date(lmp[2],(lmp[1]-1),lmp[0]);
	
	     diff=Math.floor((currentDate.getTime()-date2.getTime())/(one_day));
	    var weeks= Math.floor(diff/7);
	    var weekDays = weeks*7;
	    var days = diff- weekDays;
	    if(!isNaN(weeks)){
	    	document.getElementById('gestationalAgeWeeksId').value =weeks;
	   }
	    if(!isNaN(days)){
	    if(days==0){
	    	document.getElementById('gestationalAgeDaysId').value= '';
	    	 
	    }else{
	 	 document.getElementById('gestationalAgeDaysId').value= days;
	    }
	  }
		
		
		}
		
		
/*	if(lmpDate !=''){	
		if(scannedEdcdate==''){
		    var lmp=lmpDate.split("/");
		    var date2=new Date(lmp[2],(lmp[1]-1),lmp[0]);
		
		     diff=Math.floor((currentDate.getTime()-date2.getTime())/(one_day));
		    var weeks= Math.floor(diff/7);
		    var weekDays = weeks*7;
		    var days = diff- weekDays;
		    if(!isNaN(weeks)){
		    	document.getElementById('gestationalAgeWeeksId').value =weeks;
		   }
		    if(!isNaN(days)){
		    if(days==0){
		    	document.getElementById('gestationalAgeDaysId').value= '';
		    	 
		    }else{
		 	 document.getElementById('gestationalAgeDaysId').value= days;
		    }
		  }
	 }else{
		 var s = new Date(scannedEdcdate.substring(6),(scannedEdcdate.substring(3,5) - 1) ,scannedEdcdate.substring(0,2));
	     s.setMonth((s.getMonth()) - 9);
	     s.setDate(s.getDate() - 7);
	     
	    var curr_date = s.getDate();
	    var curr_month = s.getMonth()+1;
	    var curr_year = s.getFullYear();
	    
	    var month;
	    var date;
	    if(s.getDate() < 10){
	    		date = "0"+curr_date;
	     		}else{
	     			date = curr_date;
	     		}
	     		
	     		if(s.getMonth()+1 < 10){
	     			month = "0"+curr_month
	     		}else{
	     			month = curr_month
	     		}
	    
	    var myDate = (date + "/" + month + "/" + curr_year);
		  document.getElementById('duplicateLMP').value=myDate;
		
		    var scan=myDate.split("/");
		    var date3=new Date(scan[2],(scan[1]-1),scan[0]);
		
		    scandiff=Math.floor((currentDate.getTime()-date3.getTime())/(one_day));
		    var scanweeks= Math.floor(scandiff/7);
		    var scanweekDays = scanweeks*7;
		    var scandays = scandiff- scanweekDays;
		    if(!isNaN(scanweeks)){
		    	document.getElementById('gestationalAgeWeeksId').value =scanweeks;
		   }
		    if(!isNaN(scandays)){
		    if(scandays==0){
		    	document.getElementById('gestationalAgeDaysId').value= '';
		    	 
		    }else{
		 	 document.getElementById('gestationalAgeDaysId').value= scandays;
		    }
		  }
	 	} 
	}else{
		
		document.getElementById('scannedEdc').value=''
	}*/
	    
	 }
	//alert("Please Enter LMP1");
	
	function calculateTrimsterGestationalAge(i){
		var lmpDate = document.getElementById('lmpId').value;
		var scannedEdcdate = document.getElementById('scannedEdc').value;
		var correctedEdcdate = document.getElementById('edcDate').value;
		currentDate = new Date();
		var month = currentDate.getMonth() + 1
		var day = currentDate.getDate()
		var year = currentDate.getFullYear()
		var seperator = "/"
		currentDate = new Date(month + seperator + day + seperator + year);

		var one_day=1000*60*60*24;
		var weeks=1000*60*60*24*7;
		if(correctedEdcdate!="" || scannedEdcdate!="")
		{
			var s;
			if(correctedEdcdate!="")
		       s = new Date(correctedEdcdate.substring(6),(correctedEdcdate.substring(3,5) - 1) ,correctedEdcdate.substring(0,2));
			else 
				s = new Date(scannedEdcdate.substring(6),(scannedEdcdate.substring(3,5) - 1) ,scannedEdcdate.substring(0,2));
	     s.setMonth((s.getMonth()) - 9);
	     s.setDate(s.getDate() - 7);
	     var curr_date = s.getDate();
		    var curr_month = s.getMonth()+1;
		    var curr_year = s.getFullYear();
		    
		    var month;
		    var date;
		    if(s.getDate() < 10){
		    		date = "0"+curr_date;
		     		}else{
		     			date = curr_date;
		     		}
		     		
		     		if(s.getMonth()+1 < 10){
		     			month = "0"+curr_month
		     		}else{
		     			month = curr_month
		     		}
		    
		    var myDate = (date + "/" + month + "/" + curr_year);
			  document.getElementById('duplicateLMP').value=myDate;
			
			    var scan=myDate.split("/");
			    var date3=new Date(scan[2],(scan[1]-1),scan[0]);
			
			    scandiff=Math.floor((currentDate.getTime()-date3.getTime())/(one_day));
			    var scanweeks= Math.floor(scandiff/7);
			    var scanweekDays = scanweeks*7;
			    var scandays = scandiff- scanweekDays;
			    if(!isNaN(scanweeks)){
			    	document.getElementById('ftGA1'+i).value =scanweeks;
			   }
			    if(!isNaN(scandays)){
			    if(scandays==0){
			    	document.getElementById('ftGA2'+i).value= '';
			    	 
			    }else{
			 	 document.getElementById('ftGA2'+i).value= scandays;
			    }
			  }
		
		}
	else if(lmpDate !='')
		{
		var lmp=lmpDate.split("/");
	    var date2=new Date(lmp[2],(lmp[1]-1),lmp[0]);
	
	     diff=Math.floor((currentDate.getTime()-date2.getTime())/(one_day));
	    var weeks= Math.floor(diff/7);
	    var weekDays = weeks*7;
	    var days = diff- weekDays;
	    if(!isNaN(weeks)){
	    	document.getElementById('ftGA1'+i).value =weeks;
	   }
	    if(!isNaN(days)){
	    if(days==0){
	    	document.getElementById('ftGA2'+i).value= '';
	    	 
	    }else{
	 	 document.getElementById('ftGA2'+i).value= days;
	    }
	  }
		
		
		}
		
		
	}
	
	function calculateSecondTrimsterGestationalAge(i){
		

		var lmpDate = document.getElementById('lmpId').value;
		var scannedEdcdate = document.getElementById('scannedEdc').value;
		var correctedEdcdate = document.getElementById('edcDate').value;
		currentDate = new Date();
		var month = currentDate.getMonth() + 1
		var day = currentDate.getDate()
		var year = currentDate.getFullYear()
		var seperator = "/"
		currentDate = new Date(month + seperator + day + seperator + year);

		var one_day=1000*60*60*24;
		var weeks=1000*60*60*24*7;
		if(correctedEdcdate!="" || scannedEdcdate!="")
		{
			var s;
			if(correctedEdcdate!="")
		       s = new Date(correctedEdcdate.substring(6),(correctedEdcdate.substring(3,5) - 1) ,correctedEdcdate.substring(0,2));
			else 
				s = new Date(scannedEdcdate.substring(6),(scannedEdcdate.substring(3,5) - 1) ,scannedEdcdate.substring(0,2));
	     s.setMonth((s.getMonth()) - 9);
	     s.setDate(s.getDate() - 7);
	     var curr_date = s.getDate();
		    var curr_month = s.getMonth()+1;
		    var curr_year = s.getFullYear();
		    
		    var month;
		    var date;
		    if(s.getDate() < 10){
		    		date = "0"+curr_date;
		     		}else{
		     			date = curr_date;
		     		}
		     		
		     		if(s.getMonth()+1 < 10){
		     			month = "0"+curr_month
		     		}else{
		     			month = curr_month
		     		}
		    
		    var myDate = (date + "/" + month + "/" + curr_year);
			  document.getElementById('duplicateLMP').value=myDate;
			
			    var scan=myDate.split("/");
			    var date3=new Date(scan[2],(scan[1]-1),scan[0]);
			
			    scandiff=Math.floor((currentDate.getTime()-date3.getTime())/(one_day));
			    var scanweeks= Math.floor(scandiff/7);
			    var scanweekDays = scanweeks*7;
			    var scandays = scandiff- scanweekDays;
			    if(!isNaN(scanweeks)){
			    	document.getElementById('stGA1'+i).value =scanweeks;
			   }
			    if(!isNaN(scandays)){
			    if(scandays==0){
			    	document.getElementById('stGA2'+i).value= '';
			    	 
			    }else{
			 	 document.getElementById('stGA2'+i).value= scandays;
			    }
			  }
		
		}
	else if(lmpDate !='')
		{
		var lmp=lmpDate.split("/");
	    var date2=new Date(lmp[2],(lmp[1]-1),lmp[0]);
	
	     diff=Math.floor((currentDate.getTime()-date2.getTime())/(one_day));
	    var weeks= Math.floor(diff/7);
	    var weekDays = weeks*7;
	    var days = diff- weekDays;
	    if(!isNaN(weeks)){
	    	document.getElementById('stGA1'+i).value =weeks;
	   }
	    if(!isNaN(days)){
	    if(days==0){
	    	document.getElementById('stGA2'+i).value= '';
	    	 
	    }else{
	 	 document.getElementById('stGA2'+i).value= days;
	    }
	  }
		
		}
   }
	
	function calculateThirdTrimsterGestationalAge(i){
		

		var lmpDate = document.getElementById('lmpId').value;
		var scannedEdcdate = document.getElementById('scannedEdc').value;
		var correctedEdcdate = document.getElementById('edcDate').value;
		currentDate = new Date();
		var month = currentDate.getMonth() + 1
		var day = currentDate.getDate()
		var year = currentDate.getFullYear()
		var seperator = "/"
		currentDate = new Date(month + seperator + day + seperator + year);

		var one_day=1000*60*60*24;
		var weeks=1000*60*60*24*7;
		if(correctedEdcdate!="" || scannedEdcdate!="")
		{
			var s;
			if(correctedEdcdate!="")
		       s = new Date(correctedEdcdate.substring(6),(correctedEdcdate.substring(3,5) - 1) ,correctedEdcdate.substring(0,2));
			else 
				s = new Date(scannedEdcdate.substring(6),(scannedEdcdate.substring(3,5) - 1) ,scannedEdcdate.substring(0,2));
	     s.setMonth((s.getMonth()) - 9);
	     s.setDate(s.getDate() - 7);
	     var curr_date = s.getDate();
		    var curr_month = s.getMonth()+1;
		    var curr_year = s.getFullYear();
		    
		    var month;
		    var date;
		    if(s.getDate() < 10){
		    		date = "0"+curr_date;
		     		}else{
		     			date = curr_date;
		     		}
		     		
		     		if(s.getMonth()+1 < 10){
		     			month = "0"+curr_month
		     		}else{
		     			month = curr_month
		     		}
		    
		    var myDate = (date + "/" + month + "/" + curr_year);
			  document.getElementById('duplicateLMP').value=myDate;
			
			    var scan=myDate.split("/");
			    var date3=new Date(scan[2],(scan[1]-1),scan[0]);
			
			    scandiff=Math.floor((currentDate.getTime()-date3.getTime())/(one_day));
			    var scanweeks= Math.floor(scandiff/7);
			    var scanweekDays = scanweeks*7;
			    var scandays = scandiff- scanweekDays;
			    if(!isNaN(scanweeks)){
			    	document.getElementById('ttGA1'+i).value =scanweeks;
			   }
			    if(!isNaN(scandays)){
			    if(scandays==0){
			    	document.getElementById('ttGA2'+i).value= '';
			    	 
			    }else{
			 	 document.getElementById('ttGA2'+i).value= scandays;
			    }
			  }
		
		}
	else if(lmpDate !='')
		{
		var lmp=lmpDate.split("/");
	    var date2=new Date(lmp[2],(lmp[1]-1),lmp[0]);
	
	     diff=Math.floor((currentDate.getTime()-date2.getTime())/(one_day));
	    var weeks= Math.floor(diff/7);
	    var weekDays = weeks*7;
	    var days = diff- weekDays;
	    if(!isNaN(weeks)){
	    	document.getElementById('ttGA1'+i).value =weeks;
	   }
	    if(!isNaN(days)){
	    if(days==0){
	    	document.getElementById('ttGA2'+i).value= '';
	    	 
	    }else{
	 	 document.getElementById('ttGA2'+i).value= days;
	    }
	  }
		
		}
   }
	
	
	function checkDurationOfTheYear(val){
	var marriageAtYears =	document.getElementById('b14').value;
	var durationofMonth = document.getElementById('durationOfMarriageMonthId').value;
	if(parseInt(marriageAtYears)<parseInt(val)){
		alert("Duration Of Marriage is not greater than age at Marriage.");
		document.getElementById('durationOfMarriageYearId').value="";
		document.getElementById('durationOfMarriageMonthId').value="";
	}else if(parseInt(marriageAtYears)==parseInt(val) && durationofMonth != ''){
		alert("Duration Of Marriage is not greater than age at Marriage.");
		document.getElementById('durationOfMarriageYearId').value="";
		document.getElementById('durationOfMarriageMonthId').value="";
	}
	}

function bmiCalculate() {
	jQuery(function($) {
	$("#b18").val("");
	$("#bmicat").val("");
	if($("#b17").val() != "" && $("#b16").val() !="" && !isNaN($("#b17").val()) && !isNaN($("#b16").val()) && parseInt($("#b17").val())!=0 && parseInt($("#b16").val())!=0 )
	{
	 var height = parseFloat($("#b17").val())/100;
	 var weight = 	$("#b16").val();
	 
	 $("#b18").val((weight/(height*height)).toFixed(2));
	 bmicat=(weight/(height*height)).toFixed(2);
	
	 $("#bmicat").val(" ");
	 if(bmicat<18.5){
		 $("#bmicat").val("Underweight");
		 $("#bmicat").prev().css('color', '#F65C5C');
		 $("#bmicat").css('color', '#F65C5C');
	}else if(bmicat>=18.5 && bmicat<25){
		$("#bmicat").val("Healthy Range");	
		$("#bmicat").prev().css('color', 'green');
		$("#bmicat").css('color', 'green');
	}else if(bmicat>=25 && bmicat<=30){
		$("#bmicat").val("Overweight");
		$("#bmicat").prev().css('color', '#574F4F');
		$("#bmicat").css('color', '#574F4F');
	}else if(bmicat>=30 && bmicat<=35){
		$("#bmicat").val("Obese");
		$("#bmicat").prev().css('color', '#C40707');
		$("#bmicat").css('color', '#C40707');
	}else if(bmicat>35){
		$("#bmicat").val("Severely obese ");
		$("#bmicat").prev().css('color', '#AD0C0C');
		$("#bmicat").css('color', '#AD0C0C');
	}
	}
	$("#bmicat").val();
	});
};


function yearValid(){
	var d = new Date();
	var yearNow=d.getFullYear()-1;
	var year = document.getElementById('yearTxt').value ;
	var objRegExp  =  /(^-?\d\d*\.\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/;
		if(!(objRegExp.test(year)))
		{
			alert("Year should be a number");
			document.getElementById('yearTxt').value ="";
			document.getElementById('yearTxt').focus();
		}
		else
		{
			if(year<=yearNow)
			{
				alert("Please Not before year from  current year");
				document.getElementById('yearTxt').value ="";
				document.getElementById('yearTxt').focus();
				return false;
			}
			else
			{
				return true;
			}
		}
	}



function addMonths()
{
if(document.getElementById('lmpId') != undefined){	
var lmp = document.getElementById('lmpId').value ;
if(lmp!="")
{
	var v = new Date(lmp.substring(6),(lmp.substring(3,5) - 1) ,lmp.substring(0,2));

      
       v.setMonth((v.getMonth()) + 9);
       v.setDate(v.getDate() + 7);
       
      var curr_date = v.getDate();
      var curr_month = v.getMonth()+1;
      var curr_year = v.getFullYear();
      
      var mth;
      var dt;
      if(v.getDate() < 10){
       			
       			dt = "0"+curr_date;
       		}
       		else
       		{
       			dt = curr_date;
       		}
       		
       		if(v.getMonth()+1 < 10){
       			mth = "0"+curr_month
       		}
       		else
       		{
       			mth = curr_month
       			
       		}
      
      var myDate = (dt + "/" + mth + "/" + curr_year);

	  document.getElementById('eddId').value=myDate;
	}
}
	else
	{
	  document.getElementById('eddId').value="";
	}
}

function eddF()
{	
	var edd = document.getElementById('eddId').value ;
	if(edd=="")
	{
	  alert("Please Enter LMP2")
	  return false;
	}
	else
	{
	return true;
	}
}

function displayObstetricScoreValues(){
var obstetricScore,mtp,abortion,iud,stillBirth,neonatalDeath;
var gravida,parity,liveBirth,ectopic,vesicularMode

	if(document.getElementById('b4').value  != "" && document.getElementById('b4').value  != 0){
		 gravida = document.getElementById('b4').value;
		obstetricScore = gravida;
		document.getElementById('ObstetricValues').value = obstetricScore;
	}
	if(document.getElementById('b5').value != "" && document.getElementById('b5').value != 0){
		 parity = document.getElementById('b5').value;
		 obstetricScore = gravida+" P"+parity;
		 document.getElementById('ObstetricValues').value = obstetricScore;
	}
	if(document.getElementById('b10').value != "" && document.getElementById('b10').value != 0){
		 liveBirth = document.getElementById('b10').value;
		obstetricScore = obstetricScore+" L"+liveBirth;
		 document.getElementById('ObstetricValues').value = obstetricScore;
	}
	
	
	
	if(document.getElementById('b6').value != "" && document.getElementById('b6').value != 0){
			 abortion = document.getElementById('b6').value;
			obstetricScore = obstetricScore+" A"+abortion;
			document.getElementById('ObstetricValues').value = obstetricScore;
	}
	if(document.getElementById('b11').value != "" && document.getElementById('b11').value != 0){
			 iud = document.getElementById('b11').value;
			obstetricScore = obstetricScore+" IUD"+iud;
			document.getElementById('ObstetricValues').value = obstetricScore;
	}
	if(document.getElementById('b12').value != "" && document.getElementById('b12').value != 0){
			 stillBirth = document.getElementById('b12').value;
			obstetricScore = obstetricScore+" SB"+stillBirth;
			document.getElementById('ObstetricValues').value = obstetricScore;
	}
	
	if(document.getElementById('b9').value != "" && document.getElementById('b9').value != 0){
		 mtp = document.getElementById('b9').value;
			 obstetricScore = obstetricScore+" M"+mtp;
			 document.getElementById('ObstetricValues').value = obstetricScore;
		
	}
	if(document.getElementById('b7').value != "" && document.getElementById('b7').value != 0){
		 ectopic = document.getElementById('b7').value;
		 obstetricScore = obstetricScore+" E"+ectopic;
		 document.getElementById('ObstetricValues').value = obstetricScore;
	}

	if(document.getElementById('b8').value != "" && document.getElementById('b8').value != 0){
		 vesicularMode = document.getElementById('b8').value;
			 obstetricScore = obstetricScore+" VM"+vesicularMode;
			 document.getElementById('ObstetricValues').value = obstetricScore;
		
	}
	
	if(document.getElementById('b13').value != "" && document.getElementById('b13').value != 0){
			 neonatalDeath =document.getElementById('b13').value;
			obstetricScore = obstetricScore+" NND"+neonatalDeath;
			document.getElementById('ObstetricValues').value = obstetricScore;
	}
	
}


/*animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('title3', 'fade=0,speed=400,group=pets,hide=1,persist=0,hide=0')
animatedcollapse.addDiv('title4', 'fade=0,speed=400,group=pets,hide=0')
animatedcollapse.addDiv('title5', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title6', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title7', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title8', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.init()
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}*/


function showHide()
{
   var div = document.getElementById("maritalHistoryDiv");
   if (div.style.display !== "none") {
	    div.style.display = "none";
	    document.getElementById("maritalHistoryDivId").value="+";
	 }else {
		 document.getElementById("maritalHistoryDivId").value="-";
	    div.style.display = "block";
}
}


function showHideMenstrualHistory()
{
   var div = document.getElementById("menstrualHistoryDiv");
   if (div.style.display !== "none") {
	    div.style.display = "none";
	    document.getElementById("menstrualHistoryDivId").value="+";
	 }else {
		 document.getElementById("menstrualHistoryDivId").value="-";
	    div.style.display = "block";
}
}
function showUSGReport()
{
   var div = document.getElementById("usgDiv");
if (div.style.display !== "block") {
   div.style.display = "block";
}
else {
   div.style.display = "none";
}
}

function showHidePreviousPregnancyDetails()
{
   var div = document.getElementById("previousPregnancyDiv");
   if (div.style.display !== "none") {
	    div.style.display = "none";
	    document.getElementById("previousPregnancyDivId").value="+";
	 }else {
		 document.getElementById("previousPregnancyDivId").value="-";
	    div.style.display = "block";
}
}

function displayCollapsibleTab(val)
{
  if(val=='Obstetric Score'){
	var div = document.getElementById("obstetricScoreDiv");
	if (div.style.display !== "none") {
	   div.style.display = "none";
	   document.getElementById("obstetricScoreDivId").value="+";

	}else {
		document.getElementById("obstetricScoreDivId").value="-";
	   div.style.display = "block";

	}
 }else if(val=='usg First'){
	 var div = document.getElementById("usgFirstDiv");
	 if (div.style.display !== "none") {
	    div.style.display = "none";
	    document.getElementById("usgFirstDivId").value="+";
	 }else {
		 document.getElementById("usgFirstDivId").value="-";
	    div.style.display = "block";
	 }
 }else if(val=='usg Second'){
	 var div = document.getElementById("usgSecondDiv");
	 if (div.style.display !== "none") {
		    div.style.display = "none";
		    document.getElementById("usgSecondDivId").value="+";
		 }else {
			 document.getElementById("usgSecondDivId").value="-";
		    div.style.display = "block";
	 }
}else if(val=='usg Third'){
	 var div = document.getElementById("usgThirdDiv");
	 if (div.style.display !== "none") {
		    div.style.display = "none";
		    document.getElementById("usgThirdDivId").value="+";
		 }else {
			 document.getElementById("usgThirdDivId").value="-";
		    div.style.display = "block";
	 }

  }else if(val=='First Trimester'){
		 var div = document.getElementById("firstTrimesterDiv");
		 if (div.style.display !== "none") {
			    div.style.display = "none";
			    document.getElementById("firstTrimesterDivId").value="+";
			 }else {
				 document.getElementById("firstTrimesterDivId").value="-";
			    div.style.display = "block";
		 }

 }else if(val=='Second Trimester'){
	 var div = document.getElementById("secondTrimesterDiv");
	 if (div.style.display !== "none") {
		    div.style.display = "none";
		    document.getElementById("Trimester2SummeryId").value="+";
		 }else {
			 document.getElementById("Trimester2SummeryId").value="-";
		    div.style.display = "block";
	 }

 }else if(val=='Third Trimester'){
		 var div = document.getElementById("thirdTrimesterDiv");
		 if (div.style.display !== "none") {
			    div.style.display = "none";
			    document.getElementById("thirdTrimesterDivId").value="+";
			 }else {
				 document.getElementById("thirdTrimesterDivId").value="-";
			    div.style.display = "block";
		 }

  }else if(val=='Past Medical History'){
		 var div = document.getElementById("pastMedicalHistory");
		 if (div.style.display !== "none") {
			    div.style.display = "none";
			    document.getElementById("pastMedicalHistoryId").value="+";
			 }else {
				 document.getElementById("pastMedicalHistoryId").value="-";
			    div.style.display = "block";
		 }

  }else if(val=='General Examination'){
		 var div = document.getElementById("generalExamination");
		 if (div.style.display !== "none") {
			    div.style.display = "none";
			    document.getElementById("generalExaminationId").value="+";
			 }else {
				 document.getElementById("generalExaminationId").value="-";
			    div.style.display = "block";
		 }

  }else if(val=='Lab Result First Trimester'){
		 var div = document.getElementById("labResultFirstTrimester");
		 if (div.style.display !== "none") {
			    div.style.display = "none";
			    document.getElementById("labResultFirstTrimesterId").value="+";
			 }else {
				 document.getElementById("labResultFirstTrimesterId").value="-";
			    div.style.display = "block";
		 }

	  }else if(val=='Lab Result Second Trimester'){
			 var div = document.getElementById("labResultSecondTrimester");
			 if (div.style.display !== "none") {
				    div.style.display = "none";
				    document.getElementById("labResultSecondTrimesterId").value="+";
				 }else {
					 document.getElementById("labResultSecondTrimesterId").value="-";
				    div.style.display = "block";
			 }

   }else if(val=='Lab Result Third Trimester'){
		 var div = document.getElementById("labResultThirdTrimester");
		 if (div.style.display !== "none") {
			    div.style.display = "none";
			    document.getElementById("labResultThirdTrimesterId").value="+";
			 }else {
				 document.getElementById("labResultThirdTrimesterId").value="-";
			    div.style.display = "block";
		 }

	  }else if(val=='IP Admissions'){
			 var div = document.getElementById("ipAdmissionsDiv");
			 if (div.style.display !== "none") {
				    div.style.display = "none";
				    document.getElementById("ipAdmissionsDivId").value="+";
				 }else {
					 document.getElementById("ipAdmissionsDivId").value="-";
				    div.style.display = "block";
			 }

		  }else if(val=='Family Planning'){
				 var div = document.getElementById("familyPlanningDiv");
				 if (div.style.display !== "none") {
					    div.style.display = "none";
					    document.getElementById("familyPlanningDivId").value="+";
					 }else {
						 document.getElementById("familyPlanningDivId").value="-";
					    div.style.display = "block";
				 }

			  }
}

function hideLmpCalenderDiv(val){
	if(val != ''){
		document.getElementById("lmpCalenderDiv").style.display = "none";
	}else{
		document.getElementById("lmpCalenderDiv").style.display = "block";	
	}
	
}


function openPopupForLabResultsForSpeciality(csrf,orderNo,investigationId) {
	window.open("/hms/hms/opd?method=printResultValidationLabForSpeciality&parent="+ orderNo+"&investigationId="+ investigationId+"&"+ csrf + "&" + csrfTokenName + "=" + csrfTokenValue,
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
}
function openPopupForLabResultsForSubParameter(csrf,investigationId,resultDate,hinId,testTime) {
	window.open("/hms/hms/opd?method=displaySubParameterResult&hinId="+ hinId+"&resultDate="+ resultDate+"&resultTime="+testTime+"&investigationId="+ investigationId+"&"+ csrf + "&" + csrfTokenName + "=" + csrfTokenValue,
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
}

function calculateDurationOfMarriage(){
	if(document.getElementById('b14').value){
		var marriageYear = document.getElementById('b14').value;
		var marriageMonth = document.getElementById('b15').value;
		//var patientAgeInDaysId = document.getElementById('patientAgeInDaysId').value;
		var patientAgeInMonthId = document.getElementById('patientAgeInMonthId').value;
		//var ageAtMarriageIndays;
		var ageAtMarriageInMonth;
		var durationOfMarriage;
		var durationInMonth;
		var durationInyear;
		if(marriageYear != '' && marriageYear != 0){
			if(marriageMonth != ''){	
				ageAtMarriageInMonth = parseInt(marriageYear*12)+parseInt(marriageMonth);
			var durationOfMarriageInMonth = patientAgeInMonthId- ageAtMarriageInMonth;
			 durationInyear= Math.floor(durationOfMarriageInMonth/12);
			 var yearMonth = durationInyear*12;
		     var remainMonth = durationOfMarriageInMonth- yearMonth;
		      durationInMonth= Math.floor(remainMonth);
		     if(!isNaN(durationInyear)){
		     	document.getElementById('durationOfMarriageYearId').value =durationInyear;
		    }
		     if(!isNaN(remainMonth)){
		     if(remainMonth==0){
		     	document.getElementById('durationOfMarriageMonthId').value= '';
		     	 
		     }else{
		  	 document.getElementById('durationOfMarriageMonthId').value= durationInMonth;
		     }
		    }
		  }else{
			  ageAtMarriageInMonth = parseInt(marriageYear*12)+parseInt(marriageMonth);
				var durationOfMarriageInMonth = patientAgeInMonthId- ageAtMarriageInMonth;
				 durationInyear= Math.floor(durationOfMarriageInMonth/12);
				 var yearMonth = durationInyear*12;
			     var remainMonth = durationOfMarriageInMonth- yearMonth;
			      durationInMonth= Math.floor(remainMonth);
			     if(!isNaN(durationInyear)){
			     	document.getElementById('durationOfMarriageYearId').value =durationInyear;
			    }
			     if(!isNaN(remainMonth)){
			     if(remainMonth==0){
			     	document.getElementById('durationOfMarriageMonthId').value= '';
			     	 
			     }else{
			  	 document.getElementById('durationOfMarriageMonthId').value= durationInMonth;
			     }
			    }
		  }
		 }else{
			  
			  alert("Please Enter Age at Marriage!!!")
			  return false;
		  }
		
		
	}
		return true;
	}

	function checkMotherPreviousPregnancyAge(val,id){
		/*var patientAgeInDaysId = document.getElementById('patientAgeInDaysId').value;	
		if(val != '' && val != 0){
		var ageOfPregancyInDays =val*365;
		if(ageOfPregancyInDays>patientAgeInDaysId){
			alert("Mothers Pregnancy Age is not greater than Mother's Age!");
			document.getElementById(id).value='';
			return false;
		}else if(val<18){
			alert("Mothers Pregnancy Age is  greater atleast 18 Years!");
			document.getElementById(id).value='';
			
		}
		}else{
			alert("Please Enter Valid Age of Mother at birth!!!!");
		}*/
		var ageUnit = document.getElementById('ageUnit').value;
		var noOfPr = document.getElementById('year').value;
	
		if(ageUnit != '' && ageUnit != ''){
			if(ageUnit<18){
				alert("Mothers Pregnancy Age is  greater atleast 18 Years!");
				document.getElementById("ageUnit").value='';}
				else if(parseInt(noOfPr)<parseInt(ageUnit)){
				alert("Age of mother at pregnancy should not be greater than mother's current age!!!");
				document.getElementById('ageUnit').value='';}
		}
}
	
/*	function checkNoOfPreganancy(i){
		
		var ageUnit = document.getElementById('ageUnit'+i).value;
		var noOfPr = document.getElementById('year'+i).value;
		if(ageUnit != '' && ageUnit != ''){
			if(parseInt(noOfPr)>parseInt(ageUnit))
				alert("No. of Pregnancy should not be greater than Age of Mother at birth.!!!");
				//document.getElementById('year'+i).value='';
		}
	}*/
	
	
	
	/*function checkGAInPreviousPregnancy(val,id){
		if(val != '' && val != 0){
		
		if(val>40){
			alert("Please Enter Valid GA Weeks!!!!");
			document.getElementById(id).value='';
			
		}
		}else{
			alert("Please Enter Valid GA Weeks!!!!");
		}
 }*/
	
	function monthValidation(val,id){
		if(val>12){
			alert("Please Enter Valid Month!!!!");
			document.getElementById(id).value='';
		}
 }
	
	function monthValidationForAge(val){
		if(val>12){
			alert("Please Enter Valid Month!!!!");
			document.getElementById('b15').value='';
		}
 }
	
	
	
	function checkGAInPreviousPregnancy(val,id){
		var str="";
		if(val != '' && val != 0){
		
		if(val>40){
			alert("Please Enter Valid GA Weeks!!!!");
			document.getElementById(id).value='';
			
		}
		else if(val<37)
			{
		    var x=document.getElementById("pregnancyOutcome");
		    for (var i = 0; i < x.options.length; i++) {
		    	if(x.options[i].value=="Pre Term"){
		    		x.options[i].selected =true;
		    		document.getElementById("preTermValueId").style.display = 'block';
		    	  }
		    	if(x.options[i].value=="FTND")
	    			x.options[i].selected =false;
		    	
			}
			for (var ii = 0; ii < x.options.length; ii++) {
		    	if (x.options[ii].selected) {
		    		str = str+x.options[ii].value+",";
		    	}
		    	}
		    document.getElementById('pregnancyOutComeSelection').innerHTML = str;
		    document.getElementById('pregnancyOutComeSelection').style.display="block";
			} else {
				 var x=document.getElementById("pregnancyOutcome");
				    for (var i = 0; i < x.options.length; i++) {
				    	if(x.options[i].value=="Pre Term"){
				    		x.options[i].selected =false;
				    		document.getElementById("preTermValueId").style.display = 'none';
				    		break;
				    	  }
					}
	    	  }
		}/*else{
			alert("Please Enter Valid GA Weeks!!!!");
		}*/
}


	/*function calculateDurationOfMarriage(){
		if(document.getElementById('b14').value){
			var marriageYear = document.getElementById('b14').value;
			var marriageMonth = document.getElementById('b15').value;
			//var patientAgeInDaysId = document.getElementById('patientAgeInDaysId').value;
			var patientAgeInMonthId = document.getElementById('patientAgeInMonthId').value;
			//var ageAtMarriageIndays;
			var ageAtMarriageInMonth;
			var durationOfMarriage;
			var durationInMonth;
			var durationInyear;
			if(marriageYear != '' && marriageYear != 0){
				if(marriageMonth != ''){	
					ageAtMarriageInMonth = parseInt(marriageYear*12)+parseInt(marriageMonth);
				var durationOfMarriageInMonth = patientAgeInMonthId- ageAtMarriageInMonth;
				 durationInyear= Math.floor(durationOfMarriageInMonth/12);
				 var yearMonth = durationInyear*12;
			     var remainMonth = durationOfMarriageInMonth- yearMonth;
			      durationInMonth= Math.floor(remainMonth);
			     if(!isNaN(durationInyear)){
			     	document.getElementById('durationOfMarriageYearId').value =durationInyear;
			    }
			     if(!isNaN(remainMonth)){
			     if(remainMonth==0){
			     	document.getElementById('durationOfMarriageMonthId').value= '';
			     	 
			     }else{
			  	 document.getElementById('durationOfMarriageMonthId').value= durationInMonth;
			     }
			    }
			  }else{
				  ageAtMarriageInMonth = parseInt(marriageYear*12)+parseInt(marriageMonth);
					var durationOfMarriageInMonth = patientAgeInMonthId- ageAtMarriageInMonth;
					 durationInyear= Math.floor(durationOfMarriageInMonth/12);
					 var yearMonth = durationInyear*12;
				     var remainMonth = durationOfMarriageInMonth- yearMonth;
				      durationInMonth= Math.floor(remainMonth);
				     if(!isNaN(durationInyear)){
				     	document.getElementById('durationOfMarriageYearId').value =durationInyear;
				    }
				     if(!isNaN(remainMonth)){
				     if(remainMonth==0){
				     	document.getElementById('durationOfMarriageMonthId').value= '';
				     	 
				     }else{
				  	 document.getElementById('durationOfMarriageMonthId').value= durationInMonth;
				     }
				    }
			  }
			 }else{
				  
				  alert("Please Enter Age at Marriage!!!")
				  return false;
			  }
			
			
		}
			return true;
		}
	*/
	


function validationForAgeAtMarriage(){
	if(document.getElementById('b14').value){
		var marriageYear = document.getElementById('b14').value;
		var marriageMonth = document.getElementById('b15').value;
		var patientAgeInMonthId = document.getElementById('patientAgeInMonthId').value;
		var ageAtMarriageInMonth;
		if(marriageYear != '' && marriageYear != 0){
			if(marriageMonth != ''){
				ageAtMarriageInMonth = parseInt(marriageYear*12)+parseInt(marriageMonth);
				//alert("ageAtMarriageInMonth=11111="+ageAtMarriageInMonth);
				  // alert("patientAgeInMonthId=="+patientAgeInMonthId);
			 if(parseInt(ageAtMarriageInMonth)>patientAgeInMonthId){
				 //alert("111111111111111111111111111")
				/* var durationOfMarriageInMonth = patientAgeInMonthId- ageAtMarriageInMonth;
				 durationInyear= Math.floor(durationOfMarriageInMonth/12);
				 var yearMonth = durationInyear*12;
			     var remainMonth = durationOfMarriageInMonth- yearMonth;
			      durationInMonth= Math.floor(remainMonth);
			     if(!isNaN(durationInyear)){
			     	document.getElementById('durationOfMarriageYearId').value =durationInyear;
			    }
			     if(!isNaN(remainMonth)){
			     if(remainMonth==0){
			     	document.getElementById('durationOfMarriageMonthId').value= '';
			     	 
			     }else{
			  	 document.getElementById('durationOfMarriageMonthId').value= durationInMonth;
			     }
			    }*/
				 alert("Age at Marriage should not be greater than  Patient Age!!!");
				 document.getElementById('b14').value = "";
				 document.getElementById('b15').value = "";
				 document.getElementById('durationOfMarriageYearId').value = "";
				 document.getElementById('durationOfMarriageMonthId').value = "";
				 return false;
				}else if(parseInt(ageAtMarriageInMonth)<patientAgeInMonthId){
					// alert("222222222222222222222222")
					 var durationOfMarriageInMonth = patientAgeInMonthId- ageAtMarriageInMonth;
					 durationInyear= Math.floor(durationOfMarriageInMonth/12);
					 var yearMonth = durationInyear*12;
				     var remainMonth = durationOfMarriageInMonth- yearMonth;
				     
				      durationInMonth= Math.floor(remainMonth);
				      console.log("durationInyear="+durationInyear +" yearMonth="+yearMonth +"remainMonth="+remainMonth +"durationInMonth ="+durationInMonth +"patientAgeInMonthId="+patientAgeInMonthId);
				     if(!isNaN(durationInyear)){
				     	document.getElementById('durationOfMarriageYearId').value =durationInyear;
				    }
				     if(!isNaN(remainMonth)){
				     if(remainMonth==0){
				     	document.getElementById('durationOfMarriageMonthId').value= '';
				     	 
				     }else{
				  	 document.getElementById('durationOfMarriageMonthId').value= durationInMonth;
				     }
				    }
					 /*alert("Age at Marriage is not greater than  Patient Age!!!");
					 document.getElementById('b14').value = "";
					 document.getElementById('b15').value = "";
					 document.getElementById('durationOfMarriageYearId').value = "";
					 document.getElementById('durationOfMarriageMonthId').value = "";*/
					 return false;
				}else if(parseInt(ageAtMarriageInMonth)==patientAgeInMonthId){
					 //alert("3333333333333333")
					 alert("Age at Marriage should not be equal to  Patient Age!!!");
					 document.getElementById('b14').value = "";
					 document.getElementById('b15').value = "";
					 document.getElementById('durationOfMarriageYearId').value = "";
					 document.getElementById('durationOfMarriageMonthId').value = "";
					  return false;
				}
			 
		   }else{
			   ageAtMarriageInMonth = parseInt(marriageYear*12);
			   //alert("ageAtMarriageInMonth=2222="+ageAtMarriageInMonth);
			   //alert("patientAgeInMonthId=="+patientAgeInMonthId);
			   if(ageAtMarriageInMonth > patientAgeInMonthId){
				   //alert("444444444444444444444444444444")
				   ageAtMarriageInMonth = parseInt(marriageYear*12)+parseInt(marriageMonth);
					/*var durationOfMarriageInMonth = patientAgeInMonthId- ageAtMarriageInMonth;
					 durationInyear= Math.floor(durationOfMarriageInMonth/12);
					 var yearMonth = durationInyear*12;
				     var remainMonth = durationOfMarriageInMonth- yearMonth;
				      durationInMonth= Math.floor(remainMonth);
				     if(!isNaN(durationInyear)){
				     	document.getElementById('durationOfMarriageYearId').value =durationInyear;
				    }
				     if(!isNaN(remainMonth)){
				     if(remainMonth==0){
				     	document.getElementById('durationOfMarriageMonthId').value= '';
				     	 
				     }else{
				  	 document.getElementById('durationOfMarriageMonthId').value= durationInMonth;
				     }
				    }*/
				   alert("Age at Marriage should not be greater than  Patient Age!!!");
					 document.getElementById('b14').value = "";
					 document.getElementById('durationOfMarriageYearId').value = "";
					 document.getElementById('durationOfMarriageMonthId').value = "";
					 
					 
					  return false;
				}else if(ageAtMarriageInMonth < patientAgeInMonthId){
					
					// ageAtMarriageInMonth = parseInt(marriageYear*12);
						var durationOfMarriageInMonth = patientAgeInMonthId- ageAtMarriageInMonth;
						 durationInyear= Math.floor(durationOfMarriageInMonth/12);
						 //alert("5555555555555555555555=="+durationInyear);
						 var yearMonth = durationInyear*12;
					     var remainMonth = durationOfMarriageInMonth- yearMonth;
					      durationInMonth= Math.floor(remainMonth);
					      //alert("555555555555555555555115=="+durationInMonth);
					     if(!isNaN(durationInyear)){
					     	document.getElementById('durationOfMarriageYearId').value =durationInyear;
					    }
					     if(!isNaN(remainMonth)){
					     if(remainMonth==0){
					     	document.getElementById('durationOfMarriageMonthId').value= '';
					     	 
					     }else{
					  	 document.getElementById('durationOfMarriageMonthId').value= durationInMonth;
					     }
					    }
					  return false;
				}else if(ageAtMarriageInMonth==patientAgeInMonthId){
					//alert("666666666666")
					 alert("Age at Marriage should not be equal to  Patient Age!!!");
					 document.getElementById('b14').value = "";
					 document.getElementById('durationOfMarriageYearId').value = "";
					 document.getElementById('durationOfMarriageMonthId').value = "";
					  return false;
				}
		   }
		  }else{
			  
			  alert("Please Enter Valid Age at Marriage!!!")
			  document.getElementById('b14').value = "";
			  return false;
		  }
		
		
	}
		return true;
	}

 function checkValue(val,cnt){
	if(val== 'Absent'){
		if(cnt == '1') {
			document.getElementById("b3").readOnly=true;
		} else {
			document.getElementById("b3").readOnly=false;
		}	
		
		if(cnt == '2') {
			document.getElementById("days1").readOnly=true;
		} else {
			document.getElementById("days1").readOnly=false;
		}
		
		if(cnt == '3') {
			document.getElementById("days2").readOnly=true;
		} else {
			document.getElementById("days2").readOnly=false;
		}
		
		if(cnt == '4') {
			document.getElementById("days3").readOnly=true;
		} else {
			document.getElementById("days3").readOnly=false;
		}
		
	} 
	 
 }


	function displayPreviousPregnancyDetail(val){
		if(val != 'Primi') {
			document.getElementById("previousPregnancyDetailsDiv").style.display = 'block';
		} else {
			document.getElementById("previousPregnancyDetailsDiv").style.display = 'none';
		}
	}

	
	function displayLiveBirthValue(val,inc){
	/*	if(val == 'Live') {
			document.getElementById("previousGestationalAgeId").value="";
			document.getElementById("previousGestationalAgeId").disabled = true;
		} else {
			document.getElementById("previousGestationalAgeId").disabled = false;
		}*/
	}
	
	function disableBloodGroup(val){
		if(document.getElementById("verbalBloodStatus").checked==true){
			document.getElementById("verbalBloodStatus").disabled = false;
			document.getElementById("bloodStatus").disabled = true;
		}else if(document.getElementById("bloodStatus").checked==true){
			document.getElementById("verbalBloodStatus").disabled = true;
			document.getElementById("bloodStatus").disabled = false;
		}else{
			document.getElementById("verbalBloodStatus").disabled = false;
			document.getElementById("bloodStatus").disabled = false;
		}
		
	}
	
	
	function toggleBloodGroupTest(){
		//if(document.getElementById("verbalBloodStatus").checked==true){
		
		var testInsertion = checkBloodTest();
		
		if(document.getElementById("verbalBloodStatus").checked==true && testInsertion<0)
			{var totalTest = document.getElementById("hiddenValue").value;
			  for(var i=0;i<=totalTest;i++)
			  {
			   if(document.getElementById("chargeCodeName"+i).value=="")
				   {
				   document.getElementById("chargeCodeName"+i).value = "Blood Group["+document.getElementById("bloodGroupChargeId").value+"]";
				   break;
				   }
				   
			  }
			}
	else if(testInsertion>=0){
		document.getElementById("chargeCodeName"+testInsertion).value="";
	}
		
	
			
			
	/*	}else if(document.getElementById("bloodStatus").checked==true){
			
		}else{
			document.getElementById("verbalBloodStatus").disabled = false;
			document.getElementById("bloodStatus").disabled = false;
		}*/
		
	}
	
function  checkBloodTest()
{
	 var totalTest = document.getElementById("hiddenValue").value;
	  for(var i=0;i<=totalTest;i++)
	  {
	   if(document.getElementById("chargeCodeName"+i).value=="Blood Group["+document.getElementById("bloodGroupChargeId").value+"]")
	   {
	     return i;
	   }
		   
	  }
	  
	  return -1;
}

/*ddaccordion.init({
	headerclass: "expandable", //Shared CSS class name of headers group that are expandable
	contentclass: "categoryitems", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "normal", //speed of animation: "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
});*/


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

//Anc screen change
function openAncCity(evt, cityName,divId) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("inAncTabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace("inActive", "");
    }
    document.getElementById(cityName).style.display = "block";
    document.getElementById(divId).className = "tablinks inActive";
   // evt.currentTarget.className += " inActive";   
   
}
//end

function enableOpDetail(flag)
{
	if(flag=="y")
		document.getElementById('opdCommon').style.display='block';
	else
		document.getElementById('opdCommon').style.display='none';
		
}


//added by swarup 13-12-2017
function dataAntenantalDivTwins() {
	 
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivMeanSacDiaTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivMeanSacDiaTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivMeanSacDiaTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivMeanSacDiaTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivMeanSacDiaTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivMeanSacDiaTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivusgYolkSacTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivusgYolkSacTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivusgYolkSacTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivusgYolkSacTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivusgYolkSacTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivusgYolkSacTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivFetalPoleTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFetalPoleTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivFetalPoleTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFetalPoleTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivFetalPoleTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFetalPoleTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivFetalHeartTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFetalHeartTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivFetalHeartTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFetalHeartTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivFetalHeartTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFetalHeartTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivCrownRumpLengthTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCrownRumpLengthTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivCrownRumpLengthTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCrownRumpLengthTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivCrownRumpLengthTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCrownRumpLengthTwinsColThree').style.display = 'none';
    }
	
	
	/*if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivScanEDCTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivScanEDCTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivScanEDCTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivScanEDCTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivScanEDCTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivScanEDCTwinsColThree').style.display = 'none';
    }*/
	 	
	//changes for remarks
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivRemarksTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivRemarksTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins').checked==true) {
		document.getElementById('dataDivRemarksTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTwinsColThree').style.display = 'none';
    }
	
	// end
}
 
function dataAntenantalDivTriplets() {
	 
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivMeanSacDiaTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivMeanSacDiaTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivMeanSacDiaTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivMeanSacDiaTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivMeanSacDiaTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivMeanSacDiaTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivusgYolkSacTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivusgYolkSacTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivusgYolkSacTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivusgYolkSacTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivusgYolkSacTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivusgYolkSacTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivFetalPoleTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFetalPoleTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivFetalPoleTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFetalPoleTripletsColTwo').style.display = 'none';
    }

	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivFetalPoleTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFetalPoleTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivFetalHeartTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFetalHeartTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivFetalHeartTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFetalHeartTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivFetalHeartTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFetalHeartTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivCrownRumpLengthTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCrownRumpLengthTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivCrownRumpLengthTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCrownRumpLengthTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivCrownRumpLengthTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCrownRumpLengthTripletsColThree').style.display = 'none';
    }
	
	
	/*if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivScanEDCTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivScanEDCTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivScanEDCTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivScanEDCTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivScanEDCTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivScanEDCTripletsColThree').style.display = 'none';
    }*/
	
	//changes for remarks
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivRemarksTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivRemarksTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true) {
		document.getElementById('dataDivRemarksTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTripletsColThree').style.display = 'none';
    }
	
	// end
	
}


function dataAntenantalDivTwins1() {
	 	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivCrlTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCrlTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivCrlTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCrlTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivCrlTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCrlTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivNtTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNtTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivNtTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNtTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivNtTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNtTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivNbTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNbTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivNbTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNbTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivNbTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNbTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivGaTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivGaTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivGaTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivGaTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivGaTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivGaTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivImpressionTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivImpressionTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivImpressionTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTwinsColThree').style.display = 'none';
    }
	
	// changes for remarks
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivRemarksTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivRemarksTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTwins1').checked==true) {
		document.getElementById('dataDivRemarksTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTwinsColThree').style.display = 'none';
    }
	
	
	//end
	
	 	
}
 
function dataAntenantalDivTriplets1() {
	 
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivCrlTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCrlTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivCrlTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCrlTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivCrlTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCrlTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivNtTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNtTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivNtTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNtTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivNtTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNtTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivNbTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNbTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivNbTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNbTripletsColTwo').style.display = 'none';
    }

	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivNbTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNbTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivGaTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivGaTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivGaTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivGaTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivGaTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivGaTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivImpressionTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivImpressionTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivImpressionTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTripletsColThree').style.display = 'none';
    }
	
	//changes for remarks
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivRemarksTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivRemarksTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgFirstTrimTriplets1').checked==true) {
		document.getElementById('dataDivRemarksTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTripletsColThree').style.display = 'none';
    }
	
	//end
	
	 
}


function dataSecondTrimAntenantalDivTwins() {
	 
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivLmpGaTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLmpGaTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivLmpGaTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLmpGaTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivLmpGaTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLmpGaTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivUsgGaTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivUsgGaTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivUsgGaTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivUsgGaTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivUsgGaTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivUsgGaTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivBpdTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBpdTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivBpdTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBpdTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivBpdTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBpdTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivHcTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHcTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivHcTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHcTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivHcTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHcTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivAcTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAcTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivAcTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAcTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivAcTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAcTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivFlTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFlTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivFlTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFlTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivFlTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFlTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivAfiTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAfiTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivAfiTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAfiTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivAfiTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAfiTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivPlacentaTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivPlacentaTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivPlacentaTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivPlacentaTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivPlacentaTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivPlacentaTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivEbwTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEbwTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivEbwTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEbwTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivEbwTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEbwTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivCxLengthTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCxLengthTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivCxLengthTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCxLengthTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivCxLengthTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCxLengthTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivAnomaliesTwins').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAnomaliesTwins').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivAnomaliesTwinsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAnomaliesTwinsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivAnomaliesTwinsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAnomaliesTwinsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivImpressionTwins2t').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTwins2t').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivImpressionTwinsColTwo2t').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTwinsColTwo2t').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivImpressionTwinsColThree2t').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTwinsColThree2t').style.display = 'none';
    }
	 
	// changes for remarks
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivRemarksTwins2t').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTwins2t').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivRemarksTwinsColTwo2t').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTwinsColTwo2t').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTwins').checked==true) {
		document.getElementById('dataDivRemarksTwinsColThree2t').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTwinsColThree2t').style.display = 'none';
    }
	
	//end
	
	
}
 
function dataSecondTrimAntenantalDivTriplets() {
	 
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivLmpGaTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLmpGaTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivLmpGaTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLmpGaTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivLmpGaTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLmpGaTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivUsgGaTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivUsgGaTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivUsgGaTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivUsgGaTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivUsgGaTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivUsgGaTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivBpdTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBpdTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivBpdTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBpdTripletsColTwo').style.display = 'none';
    }

	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivBpdTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBpdTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivHcTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHcTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivHcTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHcTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivHcTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHcTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivAcTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAcTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivAcTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAcTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivAcTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAcTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivFlTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFlTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivFlTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFlTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivFlTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFlTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivAfiTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAfiTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivAfiTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAfiTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivAfiTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAfiTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivPlacentaTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivPlacentaTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivPlacentaTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivPlacentaTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivPlacentaTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivPlacentaTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivEbwTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEbwTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivEbwTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEbwTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivEbwTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEbwTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivCxLengthTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCxLengthTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivCxLengthTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCxLengthTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivCxLengthTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCxLengthTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivAnomaliesTriplets').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAnomaliesTriplets').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivAnomaliesTripletsColTwo').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAnomaliesTripletsColTwo').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivAnomaliesTripletsColThree').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAnomaliesTripletsColThree').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivImpressionTriplets2t').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTriplets2t').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivImpressionTripletsColTwo2t').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTripletsColTwo2t').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivImpressionTripletsColThree2t').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTripletsColThree2t').style.display = 'none';
    }
	
	// changes for remarks
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivRemarksTriplets2t').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTriplets2t').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivRemarksTripletsColTwo2t').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTripletsColTwo2t').style.display = 'none';
    }
	
	if (document.getElementById('usgSecondTrimTriplets').checked==true) {
		document.getElementById('dataDivRemarksTripletsColThree2t').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTripletsColThree2t').style.display = 'none';
    }
	
	// end
 
	
}

function dataThirdTrimAntenantalDivTwins() {
	 
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivLmpGaTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLmpGaTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivLmpGaTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLmpGaTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivLmpGaTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLmpGaTwinsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivUsgGaTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivUsgGaTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivUsgGaTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivUsgGaTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivUsgGaTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivUsgGaTwinsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivBpdTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBpdTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivBpdTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBpdTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivBpdTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBpdTwinsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivHcTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHcTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivHcTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHcTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivHcTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHcTwinsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivAcTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAcTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivAcTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAcTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivAcTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAcTwinsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivFlTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFlTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivFlTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFlTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivFlTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFlTwinsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivAfiTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAfiTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivAfiTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAfiTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivAfiTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAfiTwinsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivPlacentaTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivPlacentaTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivPlacentaTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivPlacentaTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivPlacentaTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivPlacentaTwinsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivEbwTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEbwTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivEbwTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEbwTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivEbwTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEbwTwinsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivBppTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBppTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivBppTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBppTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivBppTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBppTwinsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivDopplerTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivDopplerTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivDopplerTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivDopplerTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivDopplerTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivDopplerTwinsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivImpressionTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivImpressionTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivImpressionTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTwinsColThree1').style.display = 'none';
    }
	
	//Remarks changes
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivRemarksTwins1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTwins1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivRemarksTwinsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTwinsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTwins').checked==true) {
		document.getElementById('dataDivRemarksTwinsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTwinsColThree1').style.display = 'none';
    }
	
	// end
	
	
}
 
function dataThirdTrimAntenantalDivTriplets() {
	 
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivLmpGaTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLmpGaTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivLmpGaTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLmpGaTripletsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivLmpGaTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLmpGaTripletsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivUsgGaTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivUsgGaTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivUsgGaTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivUsgGaTripletsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivUsgGaTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivUsgGaTripletsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivBpdTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBpdTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivBpdTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBpdTripletsColTwo1').style.display = 'none';
    }

	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivBpdTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBpdTripletsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivHcTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHcTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivHcTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHcTripletsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivHcTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHcTripletsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivAcTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAcTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivAcTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAcTripletsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivAcTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAcTripletsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivFlTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFlTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivFlTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFlTripletsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivFlTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivFlTripletsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivAfiTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAfiTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivAfiTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAfiTripletsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivAfiTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAfiTripletsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivPlacentaTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivPlacentaTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivPlacentaTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivPlacentaTripletsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivPlacentaTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivPlacentaTripletsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivEbwTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEbwTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivEbwTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEbwTripletsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivEbwTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEbwTripletsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivBppTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBppTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivBppTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBppTripletsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivBppTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivBppTripletsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivDopplerTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivDopplerTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivDopplerTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivDopplerTripletsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivDopplerTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivDopplerTripletsColThree1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivImpressionTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivImpressionTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTripletsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivImpressionTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivImpressionTripletsColThree1').style.display = 'none';
    }
	
	//Remarks changes
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivRemarksTriplets1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTriplets1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivRemarksTripletsColTwo1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTripletsColTwo1').style.display = 'none';
    }
	
	if (document.getElementById('usgThirdTrimTriplets').checked==true) {
		document.getElementById('dataDivRemarksTripletsColThree1').style.display = 'inline';
    } else {
    	document.getElementById('dataDivRemarksTripletsColThree1').style.display = 'none';
    }
	
	//end
	
}

function addInfectRow() {
	var tbl = document.getElementById('infectionTable');
	var infctInd = parseInt(document.getElementById('ancTabIndex').value) + 1;
	document.getElementById('ancTabIndex').value = infctInd;
	//document.getElementById('ancTabIndex').value = hdbTabIndex;

	/*var patAge1=document.getElementById('infectPatAge').value;*/
	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('ancInfCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;
	// document.getElementById('pulse').value=hdb.value;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'ancInfRadio' + iteration;
	e1.id = 'ancInfRadio' + iteration;
	e1.className = 'radioCheck';
	//e1.tabIndex = "1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('select');
	e1.name = 'ancInfection' + iteration;
	e1.id = 'ancInfection' + iteration;
	e1.tabIndex =  "1";
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Chicken pox','Chicken pox');
	e1.options[2] = new Option('Rubella','Rubella');
	e1.options[3] = new Option('Toxoplasma','Toxoplasma');
	e1.options[4] = new Option('Cytomegalovirus','Cytomegalovirus');
	e1.options[5] = new Option('Upper respiratory Infection', 'Upper respiratory Infection');
	e1.options[6] = new Option('Urinary Tract Infection', 'Urinary Tract Infection');
	e1.options[7] = new Option('Malaria', 'Malaria');
	e1.options[8] = new Option('Others', 'Others');
	e1.addEventListener("change", function(e) {
		showInfectOthers(iteration);
		  }, false);
	e1.onchange = function() {
		populatePastHistorySummary();
	};
	
	cellRight1.appendChild(e1);	
	
	
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'infectOthers' + iteration;
	e1.id = 'infectOthers' + iteration;
	e1.style.cssText = 'display : none; float: right;'
	e1.placeholder='Other Disease';
	e1.onkeyup = function() {
		populatePastHistorySummary();
	};
	// e1.size = '20';
	//e1.tabIndex =  "1";
	e1.maxLength = 300;
	cellRight1.appendChild(e1);

	/*var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'infectYear' + iteration;
	e1.id = 'infectYear' + iteration;
	e1.size = '5';
	e1.maxLength = '2';
	e1.tabIndex = "1";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.onblur = function() {
		yearValidation('infectYear'+iteration, patAge1);
	};
	cellRight1.appendChild(e1);

	var e2 = document.createElement('label');
	e2.innerHTML = "Years";
	e2.className = "smallAuto autoSpace";
	cellRight1.appendChild(e2);

	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'infectMonth' + iteration;
	e1.id = 'infectMonth' + iteration;
	e1.size = '5';
	e1.maxLength = '2';
	e1.tabIndex =  "1";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.onchange = function(){monthValidation(this.value,this.id);};
	cellRight1.appendChild(e1);

	var e2 = document.createElement('label');
	e2.innerHTML = "Months";
	e2.className = "smallAuto autoSpace";
	cellRight1.appendChild(e2);*/

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'infectRemarks' + iteration;
	e1.id = 'infectRemarks' + iteration;
	e1.onkeypress = function() {
		selectSNOMEDCT('ACTIVE', 'DISORDER', 'ALL', returnlimit_IN,
				callbck_index, 'infectRemarks' + iteration);
	};
	e1.onkeyup = function() {
		populatePastHistorySummary();
	};
	//e1.className = "historyAutoComplete";
	// e1.size = '20';
	e1.maxLength = '250';
	//e1.tabIndex =  "1";
	cellRight1.appendChild(e1);
}


function showInfectOthers(inc) {
	var value = document.getElementById("ancInfection"+inc).value;
	if(value == 'Others') {
		document.getElementById("infectOthers" + inc).style.display = 'block';
	} else {
		document.getElementById("infectOthers" + inc).style.display = 'none';
	}
	
}


function addPastSurgeryRow() {
	var tbl = document.getElementById('surgeryTable');
	var surgeryId = parseInt(document.getElementById('surgeryTabIndex').value) + 1;
	document.getElementById('surgeryTabIndex').value = surgeryId;

	var lastRow = tbl.rows.length;

	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('surgeryRowsCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'surgeryRadio' + iteration;
	e1.id = 'surgeryRadio' + iteration;
	e1.className = 'radioCheck';
	//e1.tabIndex = "1";
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'pastSurgeryName' + iteration;
	e1.id = 'pastSurgeryName' + iteration;
	e1.style.width="215px";
	//e1.className = 'historyAutoComplete';
	e1.onkeypress = function() {
		selectSNOMEDCT('ACTIVE', 'DISORDER', 'ALL', returnlimit_IN,
				callbck_index, 'pastSurgeryName' + iteration);
	};
	e1.onkeyup = function() {
		populatePastHistorySummary();
	};
	// e1.size = '20';
	e1.maxLength = '256';
	//e1.tabIndex =  "1";
	e1.placeholder="Nil Relevant"
	cellRight1.appendChild(e1);
	

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'pastSurgeryYear' + iteration;
	e1.id = 'pastSurgeryYear' + iteration;
	e1.size = '5';
	e1.maxLength = '4';
//	e1.tabIndex = "1";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};	
	e1.onkeyup = function() {
		populatePastHistorySummary();
	};
	
	e1.onblur = function() {
		validateSurgeryYear(this.id);
	};
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'pastSurgeryHostpital' + iteration;
	e1.id = 'pastSurgeryHostpital' + iteration;
	e1.onkeyup = function() {
		populatePastHistorySummary();
	};
	//e1.size = '5';
	e1.maxLength = '128';
	//e1.tabIndex = "1";	
	cellRight1.appendChild(e1);
	

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'pastSurgeryRemarks' + iteration;
	e1.id = 'pastSurgeryRemarks' + iteration;
	e1.style.width="215px";
	//e1.className = "historyAutoComplete";
	e1.onkeypress = function() {
		selectSNOMEDCT('ACTIVE', 'DISORDER', 'ALL', returnlimit_IN,
				callbck_index, 'pastSurgeryRemarks' + iteration);
	};
	e1.onkeyup = function() {
		populatePastHistorySummary();
	};
	e1.maxLength = '250';
	//e1.tabIndex =  "1";
	cellRight1.appendChild(e1);
}

function populatePastHistorySummary() {
	var tbl = document.getElementById('pastMedHistTable');
	var hdbTabIndex = parseInt(document.getElementById('pmhhdbTabIndex').value);
	document.getElementById('pmhhdbTabIndex').value = hdbTabIndex;
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('pmhhdb');
	iteration = parseInt(hdb.value);
	hdb.value = iteration;
	var comorbidity = "";
	var comorbidityYear="";
	var comorbidityMonths="";
	var comorbidityRemarks="";
	var comorbidityText="";
	var comorbidityOtherText="";
	var pastMedicalHistory="";
	var prevMedicalHistory="";
	if(document.getElementById('pastHistoryText')!=null)
		prevMedicalHistory = document.getElementById('pastHistoryText').value;
	var i=0;
	for(; i<=iteration; i++ ){	
	if(document.getElementById('comorbidity'+ i) !=null && document.getElementById('comorbidity'+ i) !=''){
	comorbidity=document.getElementById('comorbidity'+ i).value;
	comorbidityOtherText = document.getElementById('comOtherDisease'+ i).value;
	comorbidityYear = document.getElementById('comYears'+ i).value;
	comorbidityMonths = document.getElementById('comMonths'+ i).value;
	comorbidityRemarks = document.getElementById('comRemarks'+ i).value;
	
	if(comorbidity!=null && comorbidity !=''){		
	comorbidityText = comorbidityText + "<b>Patient is having</b> "+comorbidity;
	
	if(comorbidityOtherText !=null && comorbidityOtherText.trim()!='')
		comorbidityText = comorbidityText+"---"+comorbidityOtherText ;
	
	if(comorbidityYear !=null && comorbidityYear.trim()!='')
	comorbidityText = comorbidityText + " for "+comorbidityYear+" <b>years</b> ";
	
	if(comorbidityMonths !=null && comorbidityMonths.trim()!='')
 	 comorbidityText = comorbidityText + " for "+comorbidityMonths+" <b>Months</b>";
	
	if(comorbidityRemarks !=null && comorbidityRemarks.trim()!='')
	comorbidityText = comorbidityText + "--<b>Remarks :</b>"+comorbidityRemarks;
	
	comorbidityText = comorbidityText + "<br\>";
	}
	if(comorbidityText !="")		
		comorbidityText ="\n"+comorbidityText;			
	
	}
	}
	var tbl1 = document.getElementById('infectionTable');
	var infctInd = parseInt(document.getElementById('ancTabIndex').value) + 1;
	document.getElementById('ancTabIndex').value = infctInd;

	var lastRow1 = tbl1.rows.length;

	var iteration1 = lastRow1;
	var row1 = tbl1.insertRow(lastRow1);
	var hdb1 = document.getElementById('ancInfCount');
	iteration1 = parseInt(hdb1.value);
	hdb1.value = iteration1;
	
	var infection = "";
	var infectionYear="";
	var infectionMonths="";
	var infectionRemarks="";
	var infectionText="";
	var infectionOthersText="";
	var j=0;
	
	for(; j<=iteration1; j++ ){	
		if(document.getElementById('ancInfection'+ j) !=null && document.getElementById('ancInfection'+ j) !=''){
		infection=document.getElementById('ancInfection'+ j).value;
		infectionOthersText=document.getElementById('infectOthers'+ j).value;
		
		infectionRemarks = document.getElementById('infectRemarks'+ j).value;
		if(infection != null && infection !=''){
			infectionText = infectionText + "<b>Patient had</b> "+infection;
			
			if(infectionOthersText != null && infectionOthersText !='')
				infectionText = infectionText + "---- "+infectionOthersText;
			
			if(infectionRemarks !=null && infectionRemarks.trim()!='')
				infectionText= infectionText + "--<b>Remarks :</b>"+infectionRemarks+"<br\>";			
		}
		if(infectionText !="")		
			infectionText =infectionText;			
		
		}
	}
	var tbl2 = document.getElementById('surgeryTable');
	var surgeryId = parseInt(document.getElementById('surgeryTabIndex').value) + 1;
	document.getElementById('surgeryTabIndex').value = surgeryId;
	var lastRow2 = tbl2.rows.length;
	var iteration2 = lastRow2;
	var row2 = tbl2.insertRow(lastRow2);
	var hdb2 = document.getElementById('surgeryTabIndex');
	iteration2 = parseInt(hdb2.value);
	hdb2.value = iteration2;
	
	var surgery = "";
	var surgeryYear="";
	var surgeryHospital="";
	var surgeryRemarks="";
	var surgeryText="";
	var k=0;
    for(; k<=iteration2; k++ ){	
		if(document.getElementById('pastSurgeryName'+ k)!=null && document.getElementById('pastSurgeryName'+ k) !=''){
	surgery=document.getElementById('pastSurgeryName'+ k).value;
	surgeryYear = document.getElementById('pastSurgeryYear'+ k).value;
	surgeryHospital = document.getElementById('pastSurgeryHostpital'+ k).value;
	surgeryRemarks = document.getElementById('pastSurgeryRemarks'+ k).value;
	if(surgery != null && surgery !=''){
		surgeryText = surgeryText + "<b>Patient under gone </b>"+surgery;
		if(surgeryYear !=null && surgeryYear!='')
		surgeryText = surgeryText + " on "+surgeryYear;
		
		if(surgeryHospital !=null && surgeryHospital.trim()!='')
		surgeryText = surgeryText + " <b>at</b> "+surgeryHospital;
		
		if(surgeryRemarks !=null && surgeryRemarks.trim()!='')
		surgeryText = surgeryText + "---<b>Remarks :</b>"+surgeryRemarks+"<br\>";
	}
		if(surgeryText !="")		
			surgeryText =surgeryText;			
		
		}	
    }	
    if(comorbidityText !=''){
    	 pastMedicalHistory = "<b>Past History:</b>";
    	pastMedicalHistory = pastMedicalHistory +"<br/>" +comorbidityText;
    }
    if(infectionText != ''){
    	pastMedicalHistory = pastMedicalHistory + "<br/>" +infectionText;
    }
    if(surgeryText != ''){
    	pastMedicalHistory = pastMedicalHistory + "<br/>" +surgeryText;
    }
    pastMedicalHistory = prevMedicalHistory+"<br/>" +pastMedicalHistory;
	document.getElementById('pastHistorySummary').innerHTML=pastMedicalHistory;
}


function displayNSavePregnancyDetails(counter,displayOnly)
{
	
	var pregnancyOutcome = "";
	    var x=document.getElementById("pregnancyOutcome");	    
	    for (var i = 0; i < x.options.length; i++) {
	    	if(x.options[i].selected){
	    	      pregnancyOutcome +=  pregnancyOutcome==""?x.options[i].value:","+x.options[i].value;
	    	  }
	    }
	  
	var preTermValue;
	if(document.getElementById("preTermValueId"))
		preTermValue =document.getElementById("preTermValueId").value;
	 
	var deliveryOutcome = document.getElementById("deliveryOutcome").value
	
	var gen=document.getElementById("sex");
	 var sex="";
	 if(gen.options[gen.selectedIndex].value!="0")
	 sex=gen.options[gen.selectedIndex].value;
	
	var previousGestationalAge = document.getElementById("previousGestationalAgeId").value;
	var birthWeight = document.getElementById("birthWeight").value;
	var antenatal = document.getElementById("antenatal").value;
	var intraPartum = document.getElementById("intraPartum").value;
	var postPartum = document.getElementById("postPartum").value;
	var remarkforPrePreg = document.getElementById("remarkforPrePreg").value;
	var placeOfDelivery = document.getElementById("placeOfDelivery").value;
	var placeOfDeliveryOthers;
	if(document.getElementById("placeOfDeliveryOtherId")!=null)
		placeOfDeliveryOthers = document.getElementById("placeOfDeliveryOtherId").value;
	var totalPreDt = document.getElementById("totalPreDt").value;
	var prevTotal = document.getElementById("prevTotal").value;
	
	var noOfPregnancy = document.getElementById("noOfPregnancy").value;
	var ageUnit = document.getElementById("ageUnit").value;
	var BloodTransfusion = document.getElementById("BloodTransfusion").value;
	
	if(displayOnly!="y"){
	if(ageUnit==""){
		alert("Enter mother's age");return}
	else if( !pregnancyOutcome.includes('Abortion') && !pregnancyOutcome.includes('Ectopic') && !pregnancyOutcome.includes('Vesicular Mole') && (sex=="" || deliveryOutcome=="")){
	   if (confirm("Delivery Outcome and Gender should be entered")) {
              return;		   
	   }
	   
	}
		
	}
	
/*	if(displayOnly=="y" ||(ageUnit!="" && sex!="" && deliveryOutcome!="")){*/
	submitProtoAjaxNew('opdMain',
			'/hms/hms/opd?method=storePrevPregnancyDetatls&counter='+counter+'&placeOfDelivery='+placeOfDelivery+'&placeOfDeliveryOthers='+ '&prevTotal='+prevTotal+
			placeOfDeliveryOthers+'&preTermValue='+preTermValue+ '&pregnancyOutcome=' +pregnancyOutcome + '&deliveryOutcome=' + deliveryOutcome+ '&sex=' +sex+'&previousGestationalAge=' +
			previousGestationalAge+'&totalPreDt='+totalPreDt+'&displayOnly='+displayOnly+ '&noOfPregnancy='+noOfPregnancy+'&ageUnit='+ageUnit+
					'&birthWeight=' +birthWeight+'&antenatal=' +antenatal+'&intraPartum=' +intraPartum+'&postPartum=' +postPartum+'&remarkforPrePreg=' +remarkforPrePreg +'&BloodTransfusion='+BloodTransfusion,
			'prevPregnancyDtDiv');
	/*}
	else
		alert("Age of Mother, Delivery Outcome and Gender are mandatory");*/
}


function saveExaminationForTrimester1(counter,trimester)
{
	  var divId;
	  var generalExaminationTrim;
	  var systemicExam;
	  var PA;
	  var PV;
	  var Date;
	  if(trimester==1){
	var ftGeneralExaminationTrim = document.getElementById("ftGeneralExaminationTrim"+counter).value
	var ftSystemicExam = document.getElementById("ftSystemicExam"+counter).value;
	var ftPA = document.getElementById("ftPA"+counter).value;
	var ftPV = document.getElementById("ftPV"+counter).value;
	var ftdate = document.getElementById("ftdate"+counter).value;
	divId ="firstTrimesterSummery";
	  }
  
    
	
	if(displayOnly=="y" ||(ageUnit!="" && sex!="" && deliveryOutcome!="")){
	submitProtoAjaxNew('opdMain',
			'/hms/hms/opd?method=storePrevPregnancyDetatls&counter='+counter+'&1='+systemicExam+'&2='+
			systemicExam+'&3='+PA+ '&4=' +PV,
			divId);
	}
	else
		alert("Age of Mother, Delivery Outcome and Gender are mandatory");
}

function openPopupForExamination(counter,trimesterNo, id) {

    //var textVal = prompt(textName+" for Trimester "+trimesterNo, val);
   // document.getElementById(id).value = textVal;

 /*   var url = '/hms/hms/opd?method=trimesterExamPopup&val='+val+'&fieldId='+id+"&fieldText="+textName+" for Trimester "+trimesterNo +"&trimesterNo="+trimesterNo+"&counter="+counter;
    window
	.open(url, 'opd_window',
			"left=500,top=10,height=180,width=300,status=1,scrollbars=yes,resizable=0");*/
	
	  var divId="";
	  var trimType;
	  var displayString="";
	  var ftGeneralExaminationTrim="";
	  var ftSystemicExam="";
	  var ftPA = "";
	  var ftPV ="";
	  var ftdate="";
	  var ftWeight ="";
	  var ftGA="";
	  var ftsystolic="";
	  var ftdiastolic="";
	  var ftObsRi="";
	  var ftothersTrim="";
	  var stFhs="";
	  var stFh="";
	  var stUrinAl="";
	  var ftGA1="";
	  var ftGA2="";
	  
	  if(trimesterNo==1){
		  trimType="ft";
		  divId ="Trimester1Summery";
	  }
	  else if(trimesterNo==2){
		  trimType="st";
		  divId ="Trimester2Summery";
	  }
	  else if(trimesterNo==3){
		  trimType="tt";
		  divId ="Trimester3Summery";
	  }
	  var j=0;
	  
	  for(var i=0;i<=counter;i++){
		  if(document.getElementById(trimType+"GeneralExaminationTrim"+i)!=null)
			  {
			  
			 ftGeneralExaminationTrim =document.getElementById(trimType+"GeneralExaminationTrim"+i).value
			 ftSystemicExam =document.getElementById(trimType+"SystemicExam"+i).value;
			 ftPA =document.getElementById(trimType+"PA"+i).value;
			 if(document.getElementById(trimType+"PV"+i)!=null)
			 ftPV =document.getElementById(trimType+"PV"+i).value;
			 if(document.getElementById(trimType+"Weight"+i)!=null)
				 ftWeight =document.getElementById(trimType+"Weight"+i).value;
			 if(document.getElementById(trimType+"date"+i)!=null)
				 ftdate =document.getElementById(trimType+"date"+i).value;
			if(document.getElementById(trimType+"systolic"+i)!=null)
				ftsystolic =document.getElementById(trimType+"systolic"+i).value;
			if(document.getElementById(trimType+"diastolic"+i)!=null)
				ftdiastolic =document.getElementById(trimType+"diastolic"+i).value;
			if(document.getElementById(trimType+"ObsRi"+i)!=null)
				ftObsRi =document.getElementById(trimType+"ObsRi"+i).value;
			if(document.getElementById(trimType+"othersTrim"+i)!=null)
				ftothersTrim =document.getElementById(trimType+"othersTrim"+i).value;
			if(document.getElementById(trimType+"Fhs"+i)!=null)
				stFhs =document.getElementById(trimType+"Fhs"+i).value;
			if(document.getElementById(trimType+"UrinAl"+i)!=null)
				stUrinAl =document.getElementById(trimType+"UrinAl"+i).value;
			if(document.getElementById(trimType+"Fh"+i)!=null)
				stFh =document.getElementById(trimType+"Fh"+i).value;
			if(document.getElementById(trimType+"GA1"+i)!=null)
				ftGA1 =document.getElementById(trimType+"GA1"+i).value;
			if(document.getElementById(trimType+"GA2"+i)!=null)
				ftGA2 =document.getElementById(trimType+"GA2"+i).value;
			
			 if(ftGeneralExaminationTrim!="" ||ftSystemicExam!="" ||ftPA!="" ||ftPV!="" ||ftWeight!="" || ftdate!="" || ftsystolic!=""
				 || ftdiastolic!=""  || ftObsRi!="" || ftothersTrim!="" || stFhs!="" || UrinAl!=""  || stFh!="" || ftGA1!="" || ftGA2!=""){
			j++;
			 
			//displayString =displayString + displayString!=""?"<hr>":""+  j +") ";
			if(displayString=="")
			displayString = displayString+ j +") ";
			else
				displayString = displayString+"<hr>"+ j +") ";	
			 
			if(ftdate!="")
			displayString = displayString+"<b> Date: </b>"+ftdate+" ";	
			if(ftWeight!="")
				displayString = displayString+"<b> Weight: </b>"+ftWeight+" ";
			if(ftGA1!="")
				displayString = displayString+"<b> GA Weeks: </b>"+ftGA1+" ";
			if(ftGA2!="")
				displayString = displayString+"<b> GA Days: </b>"+ftGA2+" ";
			if(ftsystolic!="")
				displayString = displayString+"<b> BP systolic: </b>"+ftsystolic+" ";
			if(ftdiastolic!="")
				displayString = displayString+"<b> BP diastolic: </b>"+ftdiastolic+" ";
			if(ftGeneralExaminationTrim!="")
				displayString = displayString+"<b> General Examination: </b>"+ftGeneralExaminationTrim+" ";
			if(stUrinAl!="")
				displayString = displayString+"<b> U.Alb: </b>"+stUrinAl+" ";
			if(ftSystemicExam!="")
				displayString = displayString+"<b> Systemic Examination: </b>"+ftSystemicExam+" ";
			
			if(ftPA!="")
				displayString = displayString+"<b> PA: </b>"+ftPA+" ";
			
			if(stFhs!="")
				displayString = displayString+"<b> SFH: </b>"+stFhs+" ";
			if(stFh!="")
				displayString = displayString+"<b> FH: </b>"+stFh+" ";
			
			if(ftPV!="")
				displayString = displayString+"<b> PV: </b>"+ftPV+" ";
			if(ftObsRi!="")
				displayString = displayString+"<b> Risk: </b>"+ftObsRi+" ";
			if(ftothersTrim!="")
				displayString = displayString+"<b> Advice: </b>"+ftothersTrim+" ";
		
			 }
			
			}
	  }
	
	 document.getElementById(divId).innerHTML =displayString;
    
    //displayTrimesterExaminationSummery(counter,trimesterNo);
}

function toggleBabyDetails(){
	
	
	 var x=document.getElementById("pregnancyOutcome");
	 var matched = false;
	 
	    for (var i = 0; i < x.options.length; i++) {
	    	if(x.options[i].selected){
	    		if(x.options[i].value == 'Abortion' || x.options[i].value == 'Ectopic' || x.options[i].value == 'Vesicular Mole') {
	    			document.getElementById("deliveryOutcome").value = "";
	    			document.getElementById("deliveryOutcome").disabled = true;
	    	  		document.getElementById("sex").disabled = true;
	    	  		document.getElementById("sex").value = "0";
	    	  		document.getElementById("previousGestationalAgeId").readOnly = true;
	    	  		document.getElementById("previousGestationalAgeId").value = "";
	    	  		document.getElementById("birthWeight").readOnly= true;
	    	  		document.getElementById("birthWeight").value = "";
	    	  		matched = true;
	    	  		break;
	    	  	}
	    		
	    	  }
	    }
	    
	    if(!matched)
	    	{
	    	document.getElementById("deliveryOutcome").disabled = false;
	  		document.getElementById("sex").disabled = false;
	  		document.getElementById("previousGestationalAgeId").readOnly = false;
	  		document.getElementById("birthWeight").readOnly= false;
	    	}
	
}

function checkSystolicDiastolic(id1, id2)
{
	var val1 = document.getElementById(id1).value;
	var val2 = document.getElementById(id2).value;
	
	if(val1!="" && parseInt(val1)>300)
		{
		 alert("Enter valid Range");
		 document.getElementById(id1).value="";
		 document.getElementById(id1).focus();
		}
	else if(val2!="" && parseInt(val2)>300)
	{
		 alert("Enter valid Range");
		 document.getElementById(id2).value="";
		 document.getElementById(id2).focus();
	}
	else if(val1!="" && val2!="" && parseInt(val1) < parseInt(val2)){
		alert("Diastolic should be less than Systolic");
		document.getElementById(id2).value="";
		document.getElementById(id2).focus();
	}
}

function checkMaxLimit(val,id, range)
{
	if(id!=""&& parseFloat(val)> range){
		alert("Value can't be more than "+range);
		document.getElementById(id).value="";
	}
}

function yearValidation(id,val2)
{
	var val1=document.getElementById(id).value;
	if(parseInt(val1) > parseInt(val2))
		{
		
		alert("Year should be less than Patient's age!!");
		document.getElementById(id).value="";
		return;		
		}
}

function firstTirmUsgWeeks10()
{
	if (document.getElementById('usgFirstTrimTwins').checked==true){
		
	document.getElementById('dataDivMeanSacDiaTwins').style.display = 'block';
	document.getElementById('dataDivMeanSacDiaTwinsColTwo').style.display = 'block';
	document.getElementById('dataDivMeanSacDiaTwinsColThree').style.display = 'block';
	
	document.getElementById('dataDivusgYolkSacTwins').style.display = 'block';
	document.getElementById('dataDivusgYolkSacTwinsColTwo').style.display = 'block';
	document.getElementById('dataDivusgYolkSacTwinsColThree').style.display = 'block';
	
	document.getElementById('dataDivFetalPoleTwins').style.display = 'block';
	document.getElementById('dataDivFetalPoleTwinsColTwo').style.display = 'block';
	document.getElementById('dataDivFetalPoleTwinsColThree').style.display = 'block';
	
	document.getElementById('dataDivFetalHeartTwins').style.display = 'block';
	document.getElementById('dataDivFetalHeartTwinsColTwo').style.display = 'block';
	document.getElementById('dataDivFetalHeartTwinsColThree').style.display = 'block';
	
	document.getElementById('dataDivCrownRumpLengthTwins').style.display = 'block';
	document.getElementById('dataDivCrownRumpLengthTwinsColTwo').style.display = 'block';
	document.getElementById('dataDivCrownRumpLengthTwinsColThree').style.display = 'block';
	
	document.getElementById('dataDivRemarksTwins').style.display = 'block';
	document.getElementById('dataDivRemarksTwinsColTwo').style.display = 'block';
	document.getElementById('dataDivRemarksTwinsColThree').style.display = 'block';
	}
	
	else {
		document.getElementById('dataDivMeanSacDiaTwins').style.display = 'none';
		document.getElementById('dataDivMeanSacDiaTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivMeanSacDiaTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivusgYolkSacTwins').style.display = 'none';
		document.getElementById('dataDivusgYolkSacTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivusgYolkSacTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivFetalPoleTwins').style.display = 'none';
		document.getElementById('dataDivFetalPoleTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivFetalPoleTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivFetalHeartTwins').style.display = 'none';
		document.getElementById('dataDivFetalHeartTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivFetalHeartTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivCrownRumpLengthTwins').style.display = 'none';
		document.getElementById('dataDivCrownRumpLengthTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivCrownRumpLengthTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivRemarksTwins').style.display = 'none';
		document.getElementById('dataDivRemarksTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivRemarksTwinsColThree').style.display = 'none';	
	}
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true){
		
		//show div for tweens
		document.getElementById('dataDivMeanSacDiaTwins').style.display = 'block';
		document.getElementById('dataDivMeanSacDiaTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivMeanSacDiaTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivusgYolkSacTwins').style.display = 'block';
		document.getElementById('dataDivusgYolkSacTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivusgYolkSacTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivFetalPoleTwins').style.display = 'block';
		document.getElementById('dataDivFetalPoleTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivFetalPoleTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivFetalHeartTwins').style.display = 'block';
		document.getElementById('dataDivFetalHeartTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivFetalHeartTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivCrownRumpLengthTwins').style.display = 'block';
		document.getElementById('dataDivCrownRumpLengthTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivCrownRumpLengthTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivRemarksTwins').style.display = 'block';
		document.getElementById('dataDivRemarksTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivRemarksTwinsColThree').style.display = 'block';
		
		//
		
		document.getElementById('dataDivMeanSacDiaTriplets').style.display = 'block';
		document.getElementById('dataDivMeanSacDiaTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivMeanSacDiaTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivusgYolkSacTriplets').style.display = 'block';
		document.getElementById('dataDivusgYolkSacTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivusgYolkSacTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivFetalPoleTriplets').style.display = 'block';
		document.getElementById('dataDivFetalPoleTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivFetalPoleTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivFetalHeartTriplets').style.display = 'block';
		document.getElementById('dataDivFetalHeartTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivFetalHeartTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivCrownRumpLengthTriplets').style.display = 'block';
		document.getElementById('dataDivCrownRumpLengthTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivCrownRumpLengthTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivRemarksTriplets').style.display = 'block';
		document.getElementById('dataDivRemarksTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivRemarksTripletsColThree').style.display = 'block';
		
	} else {
		document.getElementById('dataDivMeanSacDiaTriplets').style.display = 'none';
		document.getElementById('dataDivMeanSacDiaTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivMeanSacDiaTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivusgYolkSacTriplets').style.display = 'none';
		document.getElementById('dataDivusgYolkSacTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivusgYolkSacTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivFetalPoleTriplets').style.display = 'none';
		document.getElementById('dataDivFetalPoleTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivFetalPoleTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivFetalHeartTriplets').style.display = 'none';
		document.getElementById('dataDivFetalHeartTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivFetalHeartTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivCrownRumpLengthTriplets').style.display = 'none';
		document.getElementById('dataDivCrownRumpLengthTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivCrownRumpLengthTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivRemarksTriplets').style.display = 'none';
		document.getElementById('dataDivRemarksTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivRemarksTripletsColThree').style.display = 'none';
		
	}
}

function diabledAgeAtMarriage(val)
{
	if(val=="Unmarried"||val=="Living Together"){
		document.getElementById("b14").value="";
		document.getElementById("b15").value="";
		document.getElementById("durationOfMarriageYearId").value="";
		document.getElementById("durationOfMarriageMonthId").value="";
		document.getElementById("b14").readOnly = true;
		document.getElementById("b15").readOnly = true;
	}
	else
		{
		document.getElementById("b14").readOnly = false;
		document.getElementById("b15").readOnly = false;
		}
	}
function displayEDCValue()
{
	var edc;
	if(document.getElementById('edcDate').value!="")
		edc = document.getElementById('edcDate').value;
	else if(document.getElementById('scannedEdc').value!="")
		edc = document.getElementById('scannedEdc').value;
	else
		edc = document.getElementById('eddId').value;
	
	document.getElementById('edcDisplay').innerHTML=edc;
}

function populateLabelValue(val, fieldId)
{
	document.getElementById(fieldId).innerHTML=val;
}


function firstTirmUsg10to14Weeks()
{
	if (document.getElementById('usgFirstTrimTwins1').checked==true){
		
		
	document.getElementById('dataDivCrlTwins').style.display = 'block';
	document.getElementById('dataDivCrlTwinsColTwo').style.display = 'block';
	document.getElementById('dataDivCrlTwinsColThree').style.display = 'block';
	
	document.getElementById('dataDivNtTwins').style.display = 'block';
	document.getElementById('dataDivNtTwinsColTwo').style.display = 'block';
	document.getElementById('dataDivNtTwinsColThree').style.display = 'block';
	
	document.getElementById('dataDivNbTwins').style.display = 'block';
	document.getElementById('dataDivNbTwinsColTwo').style.display = 'block';
	document.getElementById('dataDivNbTwinsColThree').style.display = 'block';
	
	document.getElementById('dataDivGaTwins').style.display = 'block';
	document.getElementById('dataDivGaTwinsColTwo').style.display = 'block';
	document.getElementById('dataDivGaTwinsColThree').style.display = 'block';
	
	document.getElementById('dataDivImpressionTwins').style.display = 'block';
	document.getElementById('dataDivImpressionTwinsColTwo').style.display = 'block';
	document.getElementById('dataDivImpressionTwinsColThree').style.display = 'block';
	
	document.getElementById('dataDivRemarksTwins1').style.display = 'block';
	document.getElementById('dataDivRemarksTwinsColTwo1').style.display = 'block';
	document.getElementById('dataDivRemarksTwinsColThree1').style.display = 'block';
	}else {
		document.getElementById('dataDivCrlTwins').style.display = 'none';
		document.getElementById('dataDivCrlTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivCrlTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivNtTwins').style.display = 'none';
		document.getElementById('dataDivNtTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivNtTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivNbTwins').style.display = 'none';
		document.getElementById('dataDivNbTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivNbTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivGaTwins').style.display = 'none';
		document.getElementById('dataDivGaTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivGaTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivImpressionTwins').style.display = 'none';
		document.getElementById('dataDivImpressionTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivImpressionTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivRemarksTwins1').style.display = 'none';
		document.getElementById('dataDivRemarksTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivRemarksTwinsColThree1').style.display = 'none';
	}
		
	if (document.getElementById('usgFirstTrimTriplets1').checked==true){
		
		//show div for twins
		document.getElementById('dataDivCrlTwins').style.display = 'block';
		document.getElementById('dataDivCrlTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivCrlTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivNtTwins').style.display = 'block';
		document.getElementById('dataDivNtTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivNtTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivNbTwins').style.display = 'block';
		document.getElementById('dataDivNbTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivNbTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivGaTwins').style.display = 'block';
		document.getElementById('dataDivGaTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivGaTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivImpressionTwins').style.display = 'block';
		document.getElementById('dataDivImpressionTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivImpressionTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivRemarksTwins1').style.display = 'block';
		document.getElementById('dataDivRemarksTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivRemarksTwinsColThree1').style.display = 'block';
		
		//end
		
		document.getElementById('dataDivCrlTriplets').style.display = 'block';
		document.getElementById('dataDivCrlTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivCrlTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivNtTriplets').style.display = 'block';
		document.getElementById('dataDivNtTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivNtTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivNbTriplets').style.display = 'block';
		document.getElementById('dataDivNbTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivNbTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivGaTriplets').style.display = 'block';
		document.getElementById('dataDivGaTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivGaTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivImpressionTriplets').style.display = 'block';
		document.getElementById('dataDivImpressionTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivImpressionTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivRemarksTriplets1').style.display = 'block';
		document.getElementById('dataDivRemarksTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivRemarksTripletsColThree1').style.display = 'block';		
	} else {
		document.getElementById('dataDivCrlTriplets').style.display = 'none';
		document.getElementById('dataDivCrlTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivCrlTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivNtTriplets').style.display = 'none';
		document.getElementById('dataDivNtTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivNtTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivNbTriplets').style.display = 'none';
		document.getElementById('dataDivNbTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivNbTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivGaTriplets').style.display = 'none';
		document.getElementById('dataDivGaTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivGaTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivImpressionTriplets').style.display = 'none';
		document.getElementById('dataDivImpressionTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivImpressionTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivRemarksTriplets1').style.display = 'none';
		document.getElementById('dataDivRemarksTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivRemarksTripletsColThree1').style.display = 'none';
	}
}

function usgSecondTrimDivShowHide()
{
	if (document.getElementById('usgSecondTrimTwins').checked==true){
		
		document.getElementById('dataDivLmpGaTwins').style.display = 'block';
		document.getElementById('dataDivLmpGaTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivLmpGaTwinsColThree').style.display = 'block';		
		
		document.getElementById('dataDivUsgGaTwins').style.display = 'block';
		document.getElementById('dataDivUsgGaTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivUsgGaTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivBpdTwins').style.display = 'block';
		document.getElementById('dataDivBpdTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivBpdTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivHcTwins').style.display = 'block';
		document.getElementById('dataDivHcTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivHcTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivAcTwins').style.display = 'block';
		document.getElementById('dataDivAcTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivAcTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivFlTwins').style.display = 'block';
		document.getElementById('dataDivFlTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivFlTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivAfiTwins').style.display = 'block';
		document.getElementById('dataDivAfiTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivAfiTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivPlacentaTwins').style.display = 'block';
		document.getElementById('dataDivPlacentaTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivPlacentaTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivEbwTwins').style.display = 'block';
		document.getElementById('dataDivEbwTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivEbwTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivCxLengthTwins').style.display = 'block';
		document.getElementById('dataDivCxLengthTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivCxLengthTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivAnomaliesTwins').style.display = 'block';
		document.getElementById('dataDivAnomaliesTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivAnomaliesTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivImpressionTwins2t').style.display = 'block';
		document.getElementById('dataDivImpressionTwinsColTwo2t').style.display = 'block';
		document.getElementById('dataDivImpressionTwinsColThree2t').style.display = 'block';
		
		document.getElementById('dataDivRemarksTwins2t').style.display = 'block';
		document.getElementById('dataDivRemarksTwinsColTwo2t').style.display = 'block';
		document.getElementById('dataDivRemarksTwinsColThree2t').style.display = 'block';
		
	} else {
		
		document.getElementById('dataDivLmpGaTwins').style.display = 'none';
		document.getElementById('dataDivLmpGaTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivLmpGaTwinsColThree').style.display = 'none';		
		
		document.getElementById('dataDivUsgGaTwins').style.display = 'none';
		document.getElementById('dataDivUsgGaTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivUsgGaTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivBpdTwins').style.display = 'none';
		document.getElementById('dataDivBpdTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivBpdTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivHcTwins').style.display = 'none';
		document.getElementById('dataDivHcTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivHcTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivAcTwins').style.display = 'none';
		document.getElementById('dataDivAcTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivAcTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivFlTwins').style.display = 'none';
		document.getElementById('dataDivFlTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivFlTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivAfiTwins').style.display = 'none';
		document.getElementById('dataDivAfiTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivAfiTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivPlacentaTwins').style.display = 'none';
		document.getElementById('dataDivPlacentaTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivPlacentaTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivEbwTwins').style.display = 'none';
		document.getElementById('dataDivEbwTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivEbwTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivCxLengthTwins').style.display = 'none';
		document.getElementById('dataDivCxLengthTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivCxLengthTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivAnomaliesTwins').style.display = 'none';
		document.getElementById('dataDivAnomaliesTwinsColTwo').style.display = 'none';
		document.getElementById('dataDivAnomaliesTwinsColThree').style.display = 'none';
		
		document.getElementById('dataDivImpressionTwins2t').style.display = 'none';
		document.getElementById('dataDivImpressionTwinsColTwo2t').style.display = 'none';
		document.getElementById('dataDivImpressionTwinsColThree2t').style.display = 'none';
		
		document.getElementById('dataDivRemarksTwins2t').style.display = 'none';
		document.getElementById('dataDivRemarksTwinsColTwo2t').style.display = 'none';
		document.getElementById('dataDivRemarksTwinsColThree2t').style.display = 'none';
		
	}
	if (document.getElementById('usgSecondTrimTriplets').checked==true){
		
		//Tweens div display
		document.getElementById('dataDivLmpGaTwins').style.display = 'block';
		document.getElementById('dataDivLmpGaTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivLmpGaTwinsColThree').style.display = 'block';		
		
		document.getElementById('dataDivUsgGaTwins').style.display = 'block';
		document.getElementById('dataDivUsgGaTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivUsgGaTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivBpdTwins').style.display = 'block';
		document.getElementById('dataDivBpdTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivBpdTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivHcTwins').style.display = 'block';
		document.getElementById('dataDivHcTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivHcTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivAcTwins').style.display = 'block';
		document.getElementById('dataDivAcTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivAcTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivFlTwins').style.display = 'block';
		document.getElementById('dataDivFlTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivFlTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivAfiTwins').style.display = 'block';
		document.getElementById('dataDivAfiTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivAfiTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivPlacentaTwins').style.display = 'block';
		document.getElementById('dataDivPlacentaTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivPlacentaTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivEbwTwins').style.display = 'block';
		document.getElementById('dataDivEbwTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivEbwTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivCxLengthTwins').style.display = 'block';
		document.getElementById('dataDivCxLengthTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivCxLengthTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivAnomaliesTwins').style.display = 'block';
		document.getElementById('dataDivAnomaliesTwinsColTwo').style.display = 'block';
		document.getElementById('dataDivAnomaliesTwinsColThree').style.display = 'block';
		
		document.getElementById('dataDivImpressionTwins2t').style.display = 'block';
		document.getElementById('dataDivImpressionTwinsColTwo2t').style.display = 'block';
		document.getElementById('dataDivImpressionTwinsColThree2t').style.display = 'block';
		
		document.getElementById('dataDivRemarksTwins2t').style.display = 'block';
		document.getElementById('dataDivRemarksTwinsColTwo2t').style.display = 'block';
		document.getElementById('dataDivRemarksTwinsColThree2t').style.display = 'block';
		
		//end
		
		document.getElementById('dataDivLmpGaTriplets').style.display = 'block';
		document.getElementById('dataDivLmpGaTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivLmpGaTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivUsgGaTriplets').style.display = 'block';
		document.getElementById('dataDivUsgGaTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivUsgGaTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivBpdTriplets').style.display = 'block';
		document.getElementById('dataDivBpdTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivBpdTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivHcTriplets').style.display = 'block';
		document.getElementById('dataDivHcTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivHcTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivAcTriplets').style.display = 'block';
		document.getElementById('dataDivAcTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivAcTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivFlTriplets').style.display = 'block';
		document.getElementById('dataDivFlTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivFlTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivAfiTriplets').style.display = 'block';
		document.getElementById('dataDivAfiTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivAfiTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivPlacentaTriplets').style.display = 'block';
		document.getElementById('dataDivPlacentaTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivPlacentaTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivEbwTriplets').style.display = 'block';
		document.getElementById('dataDivEbwTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivEbwTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivCxLengthTriplets').style.display = 'block';
		document.getElementById('dataDivCxLengthTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivCxLengthTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivAnomaliesTriplets').style.display = 'block';
		document.getElementById('dataDivAnomaliesTripletsColTwo').style.display = 'block';
		document.getElementById('dataDivAnomaliesTripletsColThree').style.display = 'block';
		
		document.getElementById('dataDivImpressionTriplets2t').style.display = 'block';
		document.getElementById('dataDivImpressionTripletsColTwo2t').style.display = 'block';
		document.getElementById('dataDivImpressionTripletsColThree2t').style.display = 'block';
		
		document.getElementById('dataDivRemarksTriplets2t').style.display = 'block';
		document.getElementById('dataDivRemarksTripletsColTwo2t').style.display = 'block';
		document.getElementById('dataDivRemarksTripletsColThree2t').style.display = 'block';
	} else {
		
		document.getElementById('dataDivLmpGaTriplets').style.display = 'none';
		document.getElementById('dataDivLmpGaTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivLmpGaTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivUsgGaTriplets').style.display = 'none';
		document.getElementById('dataDivUsgGaTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivUsgGaTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivBpdTriplets').style.display = 'none';
		document.getElementById('dataDivBpdTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivBpdTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivHcTriplets').style.display = 'none';
		document.getElementById('dataDivHcTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivHcTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivAcTriplets').style.display = 'none';
		document.getElementById('dataDivAcTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivAcTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivFlTriplets').style.display = 'none';
		document.getElementById('dataDivFlTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivFlTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivAfiTriplets').style.display = 'none';
		document.getElementById('dataDivAfiTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivAfiTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivPlacentaTriplets').style.display = 'none';
		document.getElementById('dataDivPlacentaTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivPlacentaTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivEbwTriplets').style.display = 'none';
		document.getElementById('dataDivEbwTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivEbwTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivCxLengthTriplets').style.display = 'none';
		document.getElementById('dataDivCxLengthTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivCxLengthTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivAnomaliesTriplets').style.display = 'none';
		document.getElementById('dataDivAnomaliesTripletsColTwo').style.display = 'none';
		document.getElementById('dataDivAnomaliesTripletsColThree').style.display = 'none';
		
		document.getElementById('dataDivImpressionTriplets2t').style.display = 'none';
		document.getElementById('dataDivImpressionTripletsColTwo2t').style.display = 'none';
		document.getElementById('dataDivImpressionTripletsColThree2t').style.display = 'none';
		
		document.getElementById('dataDivRemarksTriplets2t').style.display = 'none';
		document.getElementById('dataDivRemarksTripletsColTwo2t').style.display = 'none';
		document.getElementById('dataDivRemarksTripletsColThree2t').style.display = 'none';
	}
}


function calculateTrimesterGA(dateVal,inc,trimesterNo){
	var lmpDate = document.getElementById('lmpId').value;
	var scannedEdcdate = document.getElementById('scannedEdc').value;
	var correctedEdcdate = document.getElementById('edcDate').value;
	if(dateVal!="" && (lmpDate!="" ||scannedEdcdate!="" ||correctedEdcdate!="" )){
		var prefix;
		if(trimesterNo==1)
			prefix = "ft";
		else if(trimesterNo==2)
			prefix = "st";
		else if(trimesterNo==3)
			prefix = "tt";
		
currentDateg = new Date();

var seperator = "/"
	//currentDate = new Date();
var currentDate = new Date(dateVal.substring(6),(dateVal.substring(3,5) - 1) ,dateVal.substring(0,2));
var month = currentDate.getMonth() + 1
var day = currentDate.getDate()
var year = currentDate.getFullYear()
currentDate = new Date(month + seperator + day + seperator + year);
var one_day=1000*60*60*24;
var weeks=1000*60*60*24*7;
if(correctedEdcdate!="")
	s = new Date(correctedEdcdate.substring(6),(correctedEdcdate.substring(3,5) - 1) ,correctedEdcdate.substring(0,2));
else if(scannedEdcdate!="")
	s = new Date(scannedEdcdate.substring(6),(scannedEdcdate.substring(3,5) - 1) ,scannedEdcdate.substring(0,2));
else if(lmpDate!="")
	s =  new Date(lmpDate.substring(6),(lmpDate.substring(3,5) - 1) ,lmpDate.substring(0,2));
if(correctedEdcdate!="" || scannedEdcdate!=""){
 s.setMonth((s.getMonth()) - 9);
 s.setDate(s.getDate() - 7);}
 
var curr_date = s.getDate();
var curr_month = s.getMonth()+1;
var curr_year = s.getFullYear();

var month;
var date;
if(s.getDate() < 10){
		date = "0"+curr_date;
 		}else{
 			date = curr_date;
 		}
 		
 		if(s.getMonth()+1 < 10){
 			month = "0"+curr_month
 		}else{
 			month = curr_month
 		}

var myDate = (date + "/" + month + "/" + curr_year);
  document.getElementById('duplicateLMP').value=myDate;

    var scan=myDate.split("/");
    var date3=new Date(scan[2],(scan[1]-1),scan[0]);

    scandiff=Math.floor((currentDate.getTime()-date3.getTime())/(one_day));
    var scanweeks= Math.floor(scandiff/7);
    var scanweekDays = scanweeks*7;
    var scandays = scandiff- scanweekDays;
    if(!isNaN(scanweeks)){
    	document.getElementById(prefix+'GA1'+inc).value =scanweeks;
   }
    if(!isNaN(scandays)){
    if(scandays==0){
    	document.getElementById(prefix+'GA2'+inc).value= '';
    	 
    }else{
    	
 	 document.getElementById(prefix+'GA2'+inc).value= scandays;
    }
  }
    
	}    
} 

function checkFirstDose(val)
{
	//alert("Received value: "+val);
	var firstDose= document.getElementById('date3Id').value;
	if( val=='' && firstDose=='' )
		alert("First dose of TT not given!!!");
		return;
	
	}


function usgThirdTrimDivShowHide()
{
	if (document.getElementById('usgThirdTrimTwins').checked==true){
		
		document.getElementById('dataDivLmpGaTwins1').style.display = 'block';
		document.getElementById('dataDivLmpGaTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivLmpGaTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivUsgGaTwins1').style.display = 'block';
		document.getElementById('dataDivUsgGaTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivUsgGaTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivBpdTwins1').style.display = 'block';
		document.getElementById('dataDivBpdTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivBpdTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivHcTwins1').style.display = 'block';
		document.getElementById('dataDivHcTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivHcTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivAcTwins1').style.display = 'block';
		document.getElementById('dataDivAcTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivAcTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivFlTwins1').style.display = 'block';
		document.getElementById('dataDivFlTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivFlTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivAfiTwins1').style.display = 'block';
		document.getElementById('dataDivAfiTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivAfiTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivPlacentaTwins1').style.display = 'block';
		document.getElementById('dataDivPlacentaTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivPlacentaTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivEbwTwins1').style.display = 'block';
		document.getElementById('dataDivEbwTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivEbwTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivBppTwins1').style.display = 'block';
		document.getElementById('dataDivBppTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivBppTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivDopplerTwins1').style.display = 'block';
		document.getElementById('dataDivDopplerTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivDopplerTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivImpressionTwins1').style.display = 'block';
		document.getElementById('dataDivImpressionTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivImpressionTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivThirdRemarksTwins1').style.display = 'block';
		document.getElementById('dataDivThirdRemarksTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivThirdRemarksTwinsColThree1').style.display = 'block';
		
	} else {
		document.getElementById('dataDivLmpGaTwins1').style.display = 'none';
		document.getElementById('dataDivLmpGaTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivLmpGaTwinsColThree1').style.display = 'none';
		
		document.getElementById('dataDivUsgGaTwins1').style.display = 'none';
		document.getElementById('dataDivUsgGaTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivUsgGaTwinsColThree1').style.display = 'none';
		
		document.getElementById('dataDivBpdTwins1').style.display = 'none';
		document.getElementById('dataDivBpdTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivBpdTwinsColThree1').style.display = 'none';
		
		document.getElementById('dataDivHcTwins1').style.display = 'none';
		document.getElementById('dataDivHcTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivHcTwinsColThree1').style.display = 'none';
		
		document.getElementById('dataDivAcTwins1').style.display = 'none';
		document.getElementById('dataDivAcTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivAcTwinsColThree1').style.display = 'none';
		
		document.getElementById('dataDivFlTwins1').style.display = 'none';
		document.getElementById('dataDivFlTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivFlTwinsColThree1').style.display = 'none';
		
		document.getElementById('dataDivAfiTwins1').style.display = 'none';
		document.getElementById('dataDivAfiTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivAfiTwinsColThree1').style.display = 'none';
		
		document.getElementById('dataDivPlacentaTwins1').style.display = 'none';
		document.getElementById('dataDivPlacentaTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivPlacentaTwinsColThree1').style.display = 'none';
		
		document.getElementById('dataDivEbwTwins1').style.display = 'none';
		document.getElementById('dataDivEbwTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivEbwTwinsColThree1').style.display = 'none';
		
		document.getElementById('dataDivBppTwins1').style.display = 'none';
		document.getElementById('dataDivBppTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivBppTwinsColThree1').style.display = 'none';
		
		document.getElementById('dataDivDopplerTwins1').style.display = 'none';
		document.getElementById('dataDivDopplerTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivDopplerTwinsColThree1').style.display = 'none';
		
		document.getElementById('dataDivImpressionTwins1').style.display = 'none';
		document.getElementById('dataDivImpressionTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivImpressionTwinsColThree1').style.display = 'none';
		
		document.getElementById('dataDivThirdRemarksTwins1').style.display = 'none';
		document.getElementById('dataDivThirdRemarksTwinsColTwo1').style.display = 'none';
		document.getElementById('dataDivThirdRemarksTwinsColThree1').style.display = 'none';
	}
	if (document.getElementById('usgThirdTrimTriplets').checked==true){
		
		
		//twins Div Display
		document.getElementById('dataDivLmpGaTwins1').style.display = 'block';
		document.getElementById('dataDivLmpGaTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivLmpGaTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivUsgGaTwins1').style.display = 'block';
		document.getElementById('dataDivUsgGaTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivUsgGaTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivBpdTwins1').style.display = 'block';
		document.getElementById('dataDivBpdTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivBpdTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivHcTwins1').style.display = 'block';
		document.getElementById('dataDivHcTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivHcTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivAcTwins1').style.display = 'block';
		document.getElementById('dataDivAcTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivAcTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivFlTwins1').style.display = 'block';
		document.getElementById('dataDivFlTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivFlTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivAfiTwins1').style.display = 'block';
		document.getElementById('dataDivAfiTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivAfiTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivPlacentaTwins1').style.display = 'block';
		document.getElementById('dataDivPlacentaTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivPlacentaTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivEbwTwins1').style.display = 'block';
		document.getElementById('dataDivEbwTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivEbwTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivBppTwins1').style.display = 'block';
		document.getElementById('dataDivBppTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivBppTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivDopplerTwins1').style.display = 'block';
		document.getElementById('dataDivDopplerTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivDopplerTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivImpressionTwins1').style.display = 'block';
		document.getElementById('dataDivImpressionTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivImpressionTwinsColThree1').style.display = 'block';
		
		document.getElementById('dataDivThirdRemarksTwins1').style.display = 'block';
		document.getElementById('dataDivThirdRemarksTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivThirdRemarksTwinsColThree1').style.display = 'block';
		
		
		//End
		
		
		document.getElementById('dataDivLmpGaTriplets1').style.display = 'block';
		document.getElementById('dataDivLmpGaTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivLmpGaTripletsColThree1').style.display = 'block';
		
		document.getElementById('dataDivUsgGaTriplets1').style.display = 'block';
		document.getElementById('dataDivUsgGaTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivUsgGaTripletsColThree1').style.display = 'block';
		
		document.getElementById('dataDivBpdTriplets1').style.display = 'block';
		document.getElementById('dataDivBpdTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivBpdTripletsColThree1').style.display = 'block';
		
		document.getElementById('dataDivHcTriplets1').style.display = 'block';
		document.getElementById('dataDivHcTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivHcTripletsColThree1').style.display = 'block';
		
		document.getElementById('dataDivAcTriplets1').style.display = 'block';
		document.getElementById('dataDivAcTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivAcTripletsColThree1').style.display = 'block';
		
		document.getElementById('dataDivFlTriplets1').style.display = 'block';
		document.getElementById('dataDivFlTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivFlTripletsColThree1').style.display = 'block';
		
		document.getElementById('dataDivAfiTriplets1').style.display = 'block';
		document.getElementById('dataDivAfiTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivAfiTripletsColThree1').style.display = 'block';
		
		document.getElementById('dataDivPlacentaTriplets1').style.display = 'block';
		document.getElementById('dataDivPlacentaTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivPlacentaTripletsColThree1').style.display = 'block';
		
		document.getElementById('dataDivEbwTriplets1').style.display = 'block';
		document.getElementById('dataDivEbwTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivEbwTripletsColThree1').style.display = 'block';
		
		document.getElementById('dataDivBppTriplets1').style.display = 'block';
		document.getElementById('dataDivBppTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivBppTripletsColThree1').style.display = 'block';
		
		document.getElementById('dataDivDopplerTriplets1').style.display = 'block';
		document.getElementById('dataDivDopplerTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivDopplerTripletsColThree1').style.display = 'block';
		
		document.getElementById('dataDivImpressionTriplets1').style.display = 'block';
		document.getElementById('dataDivImpressionTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivImpressionTripletsColThree1').style.display = 'block';
		
		document.getElementById('dataDivThirdRemarksTriplets1').style.display = 'block';
		document.getElementById('dataDivThirdRemarksTripletsColTwo1').style.display = 'block';
		document.getElementById('dataDivThirdRemarksTripletsColThree1').style.display = 'block';
	} else {		
		
		
		document.getElementById('dataDivLmpGaTriplets1').style.display = 'none';
		document.getElementById('dataDivLmpGaTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivLmpGaTripletsColThree1').style.display = 'none';
		
		document.getElementById('dataDivUsgGaTriplets1').style.display = 'none';
		document.getElementById('dataDivUsgGaTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivUsgGaTripletsColThree1').style.display = 'none';
		
		document.getElementById('dataDivBpdTriplets1').style.display = 'none';
		document.getElementById('dataDivBpdTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivBpdTripletsColThree1').style.display = 'none';
		
		document.getElementById('dataDivHcTriplets1').style.display = 'none';
		document.getElementById('dataDivHcTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivHcTripletsColThree1').style.display = 'none';
		
		document.getElementById('dataDivAcTriplets1').style.display = 'none';
		document.getElementById('dataDivAcTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivAcTripletsColThree1').style.display = 'none';
		
		document.getElementById('dataDivFlTriplets1').style.display = 'none';
		document.getElementById('dataDivFlTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivFlTripletsColThree1').style.display = 'none';
		
		document.getElementById('dataDivAfiTriplets1').style.display = 'none';
		document.getElementById('dataDivAfiTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivAfiTripletsColThree1').style.display = 'none';
		
		document.getElementById('dataDivPlacentaTriplets1').style.display = 'none';
		document.getElementById('dataDivPlacentaTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivPlacentaTripletsColThree1').style.display = 'none';
		
		document.getElementById('dataDivEbwTriplets1').style.display = 'none';
		document.getElementById('dataDivEbwTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivEbwTripletsColThree1').style.display = 'none';
		
		document.getElementById('dataDivBppTriplets1').style.display = 'none';
		document.getElementById('dataDivBppTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivBppTripletsColThree1').style.display = 'none';
		
		document.getElementById('dataDivDopplerTriplets1').style.display = 'none';
		document.getElementById('dataDivDopplerTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivDopplerTripletsColThree1').style.display = 'none';
		
		document.getElementById('dataDivImpressionTriplets1').style.display = 'none';
		document.getElementById('dataDivImpressionTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivImpressionTripletsColThree1').style.display = 'none';
		
		document.getElementById('dataDivThirdRemarksTriplets1').style.display = 'none';
		document.getElementById('dataDivThirdRemarksTripletsColTwo1').style.display = 'none';
		document.getElementById('dataDivThirdRemarksTripletsColThree1').style.display = 'none';
	}

}

function unknownLmp()
{
	document.getElementById('lmpId').value = "";
	document.getElementById('eddId').value = "";
}

function checkUnknownLMP()
{
	if(document.getElementById('UnknownLmpStatus').checked)
	{alert("Please unckeck unknown lmp");
		document.getElementById('lmpId').value = "";
		document.getElementById('eddId').value = "";
		return false;
	}
	return true;
}


function addRowForAllergyAntenatal() {
	var tbl = document.getElementById('alergyGrid1');
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
	//e1.style.width='62px';
	e1.options[0] = new Option('Select', '0');
	for (var i = 0; i < allergyTypeArray.length; i++) {
		e1.options[i + 1] = new Option(allergyTypeArray[i][1],
				allergyTypeArray[i][0]);
	}
	e1.onchange=function(){
		validateForAllergy(this.id,iteration)
	};

	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'allergyName' + iteration;
	e1.id = 'allergyName' + iteration;
	e1.readOnly=true;
	//e1.className = "largTextBoxOpd textYellow";
	e1.onkeypress = function() {
		selectSNOMEDCT('ACTIVE', 'DISORDER', 'ALL', returnlimit_IN,
				callbck_index, 'allergyName' + iteration);
	};
	//e1.maxLength = "60";
	e1.size = '20';
	e1.style.width='166px';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'allergy_remarks' + iteration;
	e1.id = 'allergy_remarks' + iteration;
	e1.readOnly=true;
	//e1.className = "small textYellow";
	e1.maxLength = "30";
	e1.style.width='166px';
	cellRight1.appendChild(e1);
}

function removeRowForAllergyAntenatal() {
	var tbl = document.getElementById('alergyGrid1');
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

function openPopupWindowAllergyForANC(csrf)  {
	var requestId = document.getElementById("requestId").value.trim();

	window
			.open(
					"/hms/hms/ot?method=showAllergy&requestId=" + requestId
							+ "&" + csrf + "&" + csrfTokenName + "="
							+ csrfTokenValue + "&LP=y",
					"_blank",
					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
}

function removeRowForPastMedicalHistory(from) {
	var tbl = document.getElementById(from);
	var lastRow = tbl.rows.length;
	
	if (from == 'pastMedHistTable') {
		hdb = document.getElementById('pmhhdb');
		radio = "pmhitemRadio";
	}
	
	if (from == 'infectionTable') {
		hdb = document.getElementById('ancInfCount');
		radio = "ancInfRadio";
	}
	if (from == 'surgeryTable') {
		hdb = document.getElementById('surgeryRowsCount');
		radio = "surgeryRadio";
	}
	
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 0; i <= iteration; i++) {
		if (document.getElementById(radio + i) != null
				&& (typeof document.getElementById(radio + i).checked) != 'undefined'
				&& document.getElementById(radio + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById(radio + i) != null
					&& (typeof document.getElementById(radio + i).checked) != 'undefined'
					&& document.getElementById(radio + i).checked) {
				var deleteRow = document.getElementById(radio + i).parentNode.parentNode;
				document.getElementById(radio + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
				populatePastHistorySummary();
			}
		}
	}
}

function displayPregnancyOutComeSelection(val){
	
	if (val) {
		document.getElementById('pregnancyOutComeSelection').style.display = 'block';
		var str="",i;
        var element = document.getElementById('pregnancyOutcome');
		for (i=0;i < element.options.length;i++) {
		    if (element.options[i].selected) {
		    	if(str.trim()!='')
		    		str = str+ ", "
		    	
		    		str =	str+element.options[i].value;	
		    		
		    }
		}
		document.getElementById('pregnancyOutComeSelection').innerHTML = str;
	} else {
		document.getElementById('pregnancyOutComeSelection').style.display = 'none';
	}
	
}

function setUsgFlag()
{
	if(document.getElementById('usgFirstTrimTwins').checked==true)
		document.getElementById('usgFlag').value='Twins';
	else if(document.getElementById('usgFirstTrimTriplets').checked==true)
		 document.getElementById('usgFlag').value='Triplets';
	else
		document.getElementById('usgFlag').value='Single';	
	
}


function setThirdUsgFlag()
{
	if(document.getElementById('usgThirdTrimTwins').checked==true)
		document.getElementById('usgFlagThirdTrim').value='Twins';
	else if(document.getElementById('usgThirdTrimTriplets').checked==true)
		 document.getElementById('usgFlagThirdTrim').value='Triplets';
	else
		document.getElementById('usgFlagThirdTrim').value='Single';	
	
}


function setUsgFlagGrid2()
{
	if(document.getElementById('usgFirstTrimTwins1').checked==true)
		document.getElementById('usgFlagSecondGrid').value='Twins';
	else if(document.getElementById('usgFirstTrimTriplets1').checked==true)
		 document.getElementById('usgFlagSecondGrid').value='Triplets';
	else
		document.getElementById('usgFlagSecondGrid').value='Single';	
}

function setSecondUsgFlag()
{
	if(document.getElementById('usgSecondTrimTwins').checked==true)
		document.getElementById('usgFlagSecondTrim').value='Twins';
	else if(document.getElementById('usgSecondTrimTriplets').checked==true)
		 document.getElementById('usgFlagSecondTrim').value='Triplets';
	else
		document.getElementById('usgFlagSecondTrim').value='Single';	
}

function validateSurgeryYear(id)
{
	if(document.getElementById(id).value > document.getElementById('currentYear').value ){
		alert("Year should be less then equal to the current year!!!");
		document.getElementById(id).value='';
	}
	
}
function validateForAllergy(id,incr)
{
	if(document.getElementById(id).value == '0'){
		
		document.getElementById('allergyName'+incr).value='';
		document.getElementById('allergy_remarks'+incr).value='';
		
		document.getElementById('allergyName'+incr).readOnly=true;
		document.getElementById('allergy_remarks'+incr).readOnly=true;
	} else {
		document.getElementById('allergyName'+incr).readOnly=false;
		document.getElementById('allergy_remarks'+incr).readOnly=false;
	}
	
}

function familyPlanningValidation(id)
{
	if(document.getElementById(id).checked==true)
		{
		document.getElementById('ocps').checked = false;
		document.getElementById('ocps').disabled=true;
		document.getElementById('ppiucd').checked = false;
		document.getElementById('ppiucd').disabled=true;
		document.getElementById('tubalLigation').checked = false;
		document.getElementById('tubalLigation').disabled=true;
		document.getElementById('vasectomy').checked = false;
		document.getElementById('vasectomy').disabled=true;
		document.getElementById('condom').checked = false;
		document.getElementById('condom').disabled=true;
		document.getElementById('intervalIucd').checked = false;
		document.getElementById('intervalIucd').disabled=true;
		document.getElementById('fplam').checked = false;
		document.getElementById('fplam').disabled=true;
		
		}
	else{
		document.getElementById('ocps').disabled=false;
		document.getElementById('ppiucd').disabled=false;
		document.getElementById('tubalLigation').disabled=false;
		document.getElementById('vasectomy').disabled=false;
		document.getElementById('condom').disabled=false;
		document.getElementById('intervalIucd').disabled=false;
		document.getElementById('fplam').disabled=false;
		
	}

}


function checkPrimiValue(id)
{
	if(document.getElementById(id).value == 'Primi'){
		
		document.getElementById('b5').value = '';
		document.getElementById('b10').value = '';
		document.getElementById('b6').value = '';
		document.getElementById('b11').value = '';
		document.getElementById('b12').value = '';
		document.getElementById('b13').value = '';
		document.getElementById('b9').value = '';
		document.getElementById('b7').value = '';
		document.getElementById('b8').value = '';
		
		
		document.getElementById('b5').readOnly=true;
		document.getElementById('b10').readOnly=true;
		document.getElementById('b6').readOnly=true;
		document.getElementById('b11').readOnly=true;
		document.getElementById('b12').readOnly=true;
		document.getElementById('b13').readOnly=true;
		document.getElementById('b9').readOnly=true;
		document.getElementById('b7').readOnly=true;
		document.getElementById('b8').readOnly=true;
		
	} else
		{
		
		document.getElementById('b5').readOnly=false;
		document.getElementById('b10').readOnly=false;
		document.getElementById('b6').readOnly=false;
		document.getElementById('b11').readOnly=false;
		document.getElementById('b12').readOnly=false;
		document.getElementById('b13').readOnly=false;
		document.getElementById('b9').readOnly=false;
		document.getElementById('b7').readOnly=false;
		document.getElementById('b8').readOnly=false;
		}
	
 }

function checkForFTND(){

	    var x=document.getElementById("pregnancyOutcome");
	    var ftndID;
	    for (var i = 0; i < x.options.length; i++) {
	    	if(x.options[i].selected && x.options[i].value == 'FTND'){
	    		ftndID=i;
     	  		break;
	    	  	} 
	    }
	    
	    for (var i = 0; i < x.options.length; i++) {
	    	   if(x.options[i].selected && x.options[i].value == 'Pre Term' && (typeof x.options[ftndID]) != 'undefined') {
	    		   x.options[ftndID].selected = false;
	    	  		break;
	    	  	} 
	    }
	return;
}


function setFirstTrimFirstVisitFlag(){
	document.getElementById('firstTrimFirstVisitFlag').value=1;
}
function setFirstTrimSecondVisitFlag(){
	document.getElementById('firstTrimSecondVisitFlag').value=1;
}
function setFirstTrimThirdVisitFlag(){
	document.getElementById('firstTrimThirdVisitFlag').value=1;
}


function firstTirmUsgWeeks10Revisit()
{
	if (document.getElementById('usgFirstTrimTwins').checked==true){
		
	if(document.getElementById('usgFlagRevisit').value =='NO' )
	document.getElementById('dataDivMeanSacDiaTwinsColTwo').style.display = 'block';
	if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
	document.getElementById('dataDivMeanSacDiaTwinsColThree').style.display = 'block';
	
	if(document.getElementById('usgFlagRevisit').value =='NO' )
	document.getElementById('dataDivusgYolkSacTwinsColTwo').style.display = 'block';
	if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
	document.getElementById('dataDivusgYolkSacTwinsColThree').style.display = 'block';
	
	if(document.getElementById('usgFlagRevisit').value =='NO' )
	document.getElementById('dataDivFetalPoleTwinsColTwo').style.display = 'block';
	if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
	document.getElementById('dataDivFetalPoleTwinsColThree').style.display = 'block';
	
	if(document.getElementById('usgFlagRevisit').value =='NO' )
	document.getElementById('dataDivFetalHeartTwinsColTwo').style.display = 'block';
	if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
	document.getElementById('dataDivFetalHeartTwinsColThree').style.display = 'block';
	
	if(document.getElementById('usgFlagRevisit').value =='NO' )
	document.getElementById('dataDivCrownRumpLengthTwinsColTwo').style.display = 'block';
	if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
	document.getElementById('dataDivCrownRumpLengthTwinsColThree').style.display = 'block';
	
	if(document.getElementById('usgFlagRevisit').value =='NO' )
	document.getElementById('dataDivRemarksTwinsColTwo').style.display = 'block';
	if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
	document.getElementById('dataDivRemarksTwinsColThree').style.display = 'block';
	}
	
	else {
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivMeanSacDiaTwinsColTwo').style.display = 'none';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivMeanSacDiaTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivusgYolkSacTwinsColTwo').style.display = 'none';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivusgYolkSacTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivFetalPoleTwinsColTwo').style.display = 'none';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFetalPoleTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivFetalHeartTwinsColTwo').style.display = 'none';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFetalHeartTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivCrownRumpLengthTwinsColTwo').style.display = 'none';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivCrownRumpLengthTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTwinsColTwo').style.display = 'none';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivRemarksTwinsColThree').style.display = 'none';	
	}
	
	if (document.getElementById('usgFirstTrimTriplets').checked==true){
		
		//show div for tweens
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivMeanSacDiaTwinsColTwo').style.display = 'block';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivMeanSacDiaTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivusgYolkSacTwinsColTwo').style.display = 'block';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivusgYolkSacTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivFetalPoleTwinsColTwo').style.display = 'block';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFetalPoleTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivFetalHeartTwinsColTwo').style.display = 'block';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFetalHeartTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivCrownRumpLengthTwinsColTwo').style.display = 'block';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivCrownRumpLengthTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTwinsColTwo').style.display = 'block';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivRemarksTwinsColThree').style.display = 'block';
		
		//
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivMeanSacDiaTripletsColTwo').style.display = 'block';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivMeanSacDiaTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivusgYolkSacTripletsColTwo').style.display = 'block';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivusgYolkSacTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivFetalPoleTripletsColTwo').style.display = 'block';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFetalPoleTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivFetalHeartTripletsColTwo').style.display = 'block';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFetalHeartTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivCrownRumpLengthTripletsColTwo').style.display = 'block';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivCrownRumpLengthTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTripletsColTwo').style.display = 'block';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivRemarksTripletsColThree').style.display = 'block';
		
	} else {
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivMeanSacDiaTripletsColTwo').style.display = 'none';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivMeanSacDiaTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivusgYolkSacTripletsColTwo').style.display = 'none';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivusgYolkSacTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivFetalPoleTripletsColTwo').style.display = 'none';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFetalPoleTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivFetalHeartTripletsColTwo').style.display = 'none';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFetalHeartTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivCrownRumpLengthTripletsColTwo').style.display = 'none';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivCrownRumpLengthTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTripletsColTwo').style.display = 'none';
		if(document.getElementById('usgFlagRevisitThirdV').value <= 0 )
		document.getElementById('dataDivRemarksTripletsColThree').style.display = 'none';
		
	}
}


function ValidateLmp(id){
	  var startDateObj = document.getElementById("lmpId").value; 
	  var duplicateLMP = document.getElementById("duplicateLMP").value;
	  
	 
	  var endDateObj = document.getElementById(id).value;
	 
	  if(startDateObj != null && startDateObj !='')
		  {
		  var vStart = startDateObj.split("/");   
			var vEnd = endDateObj.split("/");
			var startDate = new Date(vStart[2],(vStart[1]-1),vStart[0]); //date format(Fullyear,month,date) 
			var endDate = new Date(vEnd[2],(vEnd[1]-1),vEnd[0]);
		
			if(startDate >= endDate)
			{	
				alert("Date should be grater than LMP Date .");
				
				document.getElementById(id).value = "";
			}
		  		  	  }
    
	  else  if(duplicateLMP != null && duplicateLMP !='')
		 		{
		 		
		 		  var dt1 = document.getElementById('duplicateLMP').value.split('/');
		 		  var dt2 = document.getElementById(id).value.split('/');
		 		  var d1=new Date(dt1[2], dt1[1] - 1, dt1[0]);
		 		  var d2=new Date(dt2[2], dt2[1] - 1, dt2[0]);
		 		  
		 		  if (d1 >= d2) { 
		 			  
		 		alert("Date should be grater than LMP Date");
		 		document.getElementById(id).value = "";
		 		  }
		 		}
		 		}	

function setfirstTrimSecondGridFirstVisitFlag(){
	document.getElementById('firstTrimSecondGridFirstVisitFlag').value='SecondGrid';
}
function setfirstTrimSecondGridSecondVisitFlag(){
	document.getElementById('firstTrimSecondGridSecondVisitFlag').value='SecondGrid';
}
function setfirstTrimSecondGridThirdVisitFlag(){
	document.getElementById('firstTrimSecondGridThirdVisitFlag').value='SecondGrid';
}


function firstTirmUsg10to14WeeksRevisit()
{
	if (document.getElementById('usgFirstTrimTwins1').checked==true){
		
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
	    document.getElementById('dataDivCrlTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
	   document.getElementById('dataDivCrlTwinsColThree').style.display = 'block';
	
	if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
	document.getElementById('dataDivNtTwinsColTwo').style.display = 'block';
	if(document.getElementById('secondGridRevisitThirdV').value <=0 )
	document.getElementById('dataDivNtTwinsColThree').style.display = 'block';
	
	if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
	document.getElementById('dataDivNbTwinsColTwo').style.display = 'block';
	if(document.getElementById('secondGridRevisitThirdV').value <=0 )
	document.getElementById('dataDivNbTwinsColThree').style.display = 'block';
	
	if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
	document.getElementById('dataDivGaTwinsColTwo').style.display = 'block';
	if(document.getElementById('secondGridRevisitThirdV').value <=0 )
	document.getElementById('dataDivGaTwinsColThree').style.display = 'block';
	
	if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
	document.getElementById('dataDivImpressionTwinsColTwo').style.display = 'block';
	if(document.getElementById('secondGridRevisitThirdV').value <=0 )
	document.getElementById('dataDivImpressionTwinsColThree').style.display = 'block';
	
	if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
	document.getElementById('dataDivRemarksTwinsColTwo1').style.display = 'block';
	if(document.getElementById('secondGridRevisitThirdV').value <=0 )
	document.getElementById('dataDivRemarksTwinsColThree1').style.display = 'block';
	}else {
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivCrlTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivCrlTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivNtTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivNtTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivNbTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivNbTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivGaTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivGaTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivImpressionTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTwinsColTwo1').style.display = 'none';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivRemarksTwinsColThree1').style.display = 'none';
	}
		
	if (document.getElementById('usgFirstTrimTriplets1').checked==true){
		
		//show div for twins
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivCrlTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivCrlTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivNtTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivNtTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivNbTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivNbTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivGaTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivGaTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivImpressionTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTwinsColTwo1').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivRemarksTwinsColThree1').style.display = 'block';
		
		//end
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivCrlTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivCrlTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivNtTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivNtTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivNbTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivNbTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivGaTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivGaTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivImpressionTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTripletsColTwo1').style.display = 'block';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivRemarksTripletsColThree1').style.display = 'block';		
	} else {
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivCrlTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivCrlTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivNtTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivNtTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivNbTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivNbTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivGaTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivGaTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivImpressionTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondGridRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTripletsColTwo1').style.display = 'none';
		if(document.getElementById('secondGridRevisitThirdV').value <=0 )
		document.getElementById('dataDivRemarksTripletsColThree1').style.display = 'none';
	}
}

function setSecondTrimFirstVisitFlag(){
	document.getElementById('secondTrimFirstVisitFlag').value='SecondTrim';
}
function setSecondTrimSecondVisitFlag(){
	document.getElementById('secondTrimSecondVisitFlag').value='SecondTrim';
}
function setSecondTrimThirdVisitFlag(){
	document.getElementById('secondTrimThirdVisitFlag').value='SecondTrim';
}

function setThirdTrimFirstVisitFlag(){
	document.getElementById('thirdTrimFirstVisitFlag').value='ThirdTrim';
}
function setThirdTrimSecondVisitFlag(){
	document.getElementById('thirdTrimSecondVisitFlag').value='ThirdTrim';
}
function setThirdTrimThirdVisitFlag(){
	document.getElementById('thirdTrimThirdVisitFlag').value='ThirdTrim';
}

function usgSecondTrimDivShowHideRevisit()
{
	
	if (document.getElementById('usgSecondTrimTwins').checked==true){
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivLmpGaTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivLmpGaTwinsColThree').style.display = 'block';		
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivUsgGaTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivUsgGaTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivBpdTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivBpdTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivHcTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivHcTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAcTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAcTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivFlTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFlTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAfiTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAfiTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivPlacentaTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivPlacentaTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivEbwTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivEbwTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivCxLengthTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivCxLengthTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAnomaliesTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAnomaliesTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTwinsColTwo2t').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivImpressionTwinsColThree2t').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTwinsColTwo2t').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivRemarksTwinsColThree2t').style.display = 'block';
		
	} else {
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivLmpGaTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivLmpGaTwinsColThree').style.display = 'none';		
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivUsgGaTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivUsgGaTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivBpdTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivBpdTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivHcTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivHcTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAcTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAcTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivFlTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFlTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAfiTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAfiTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivPlacentaTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivPlacentaTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivEbwTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivEbwTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivCxLengthTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivCxLengthTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAnomaliesTwinsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAnomaliesTwinsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTwinsColTwo2t').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivImpressionTwinsColThree2t').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTwinsColTwo2t').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivRemarksTwinsColThree2t').style.display = 'none';
		
	}
	if (document.getElementById('usgSecondTrimTriplets').checked==true){
		
		//Tweens div display
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivLmpGaTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivLmpGaTwinsColThree').style.display = 'block';		
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivUsgGaTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivUsgGaTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivBpdTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivBpdTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivHcTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivHcTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAcTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAcTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivFlTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFlTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAfiTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAfiTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivPlacentaTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivPlacentaTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivEbwTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivEbwTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivCxLengthTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivCxLengthTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAnomaliesTwinsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAnomaliesTwinsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTwinsColTwo2t').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivImpressionTwinsColThree2t').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTwinsColTwo2t').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivRemarksTwinsColThree2t').style.display = 'block';
		
		//end
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivLmpGaTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivLmpGaTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivUsgGaTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivUsgGaTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivBpdTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivBpdTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivHcTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivHcTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAcTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAcTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivFlTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFlTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAfiTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAfiTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivPlacentaTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivPlacentaTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivEbwTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivEbwTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivCxLengthTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivCxLengthTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAnomaliesTripletsColTwo').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAnomaliesTripletsColThree').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTripletsColTwo2t').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivImpressionTripletsColThree2t').style.display = 'block';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTripletsColTwo2t').style.display = 'block';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivRemarksTripletsColThree2t').style.display = 'block';
	} else {
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivLmpGaTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivLmpGaTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivUsgGaTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivUsgGaTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivBpdTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivBpdTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivHcTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivHcTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAcTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAcTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivFlTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivFlTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAfiTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAfiTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivPlacentaTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivPlacentaTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivEbwTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivEbwTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivCxLengthTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivCxLengthTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivAnomaliesTripletsColTwo').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivAnomaliesTripletsColThree').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTripletsColTwo2t').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivImpressionTripletsColThree2t').style.display = 'none';
		
		if(document.getElementById('usgFlagSecondTrimRevisit').value =='NO' )
		document.getElementById('dataDivRemarksTripletsColTwo2t').style.display = 'none';
		if(document.getElementById('secondTrimRevisitThirdV').value <= 0 )
		document.getElementById('dataDivRemarksTripletsColThree2t').style.display = 'none';
	}
}

function usgThirdTrimDivShowHideRevisit()
{
	
	if (document.getElementById('usgThirdTrimTwins').checked==true){
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivLmpGaTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivLmpGaTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivUsgGaTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivUsgGaTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivBpdTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivBpdTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivHcTwinsColTwo1').style.display = 'block';
		document.getElementById('dataDivHcTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivAcTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivAcTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivFlTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivFlTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivAfiTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivAfiTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivPlacentaTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivPlacentaTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivEbwTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivEbwTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivBppTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivBppTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivDopplerTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivDopplerTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivImpressionTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivThirdRemarksTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivThirdRemarksTwinsColThree1').style.display = 'block';
		
	} else {
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivLmpGaTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivLmpGaTwinsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivUsgGaTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivUsgGaTwinsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivBpdTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivBpdTwinsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivHcTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivHcTwinsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivAcTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivAcTwinsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivFlTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivFlTwinsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivAfiTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivAfiTwinsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivPlacentaTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivPlacentaTwinsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivEbwTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivEbwTwinsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivBppTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivBppTwinsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivDopplerTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivDopplerTwinsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivImpressionTwinsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivThirdRemarksTwinsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivThirdRemarksTwinsColThree1').style.display = 'none';
	}
	if (document.getElementById('usgThirdTrimTriplets').checked==true){
		
		
		//twins Div Display
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivLmpGaTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivLmpGaTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivUsgGaTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivUsgGaTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivBpdTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivBpdTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivHcTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivHcTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivAcTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivAcTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivFlTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivFlTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivAfiTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivAfiTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivPlacentaTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivPlacentaTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivEbwTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivEbwTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivBppTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivBppTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivDopplerTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivDopplerTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivImpressionTwinsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivThirdRemarksTwinsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivThirdRemarksTwinsColThree1').style.display = 'block';
		
		
		//End
		
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivLmpGaTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivLmpGaTripletsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivUsgGaTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivUsgGaTripletsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivBpdTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivBpdTripletsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivHcTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivHcTripletsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivAcTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivAcTripletsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivFlTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivFlTripletsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivAfiTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivAfiTripletsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivPlacentaTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivPlacentaTripletsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivEbwTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivEbwTripletsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivBppTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivBppTripletsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivDopplerTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivDopplerTripletsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivImpressionTripletsColThree1').style.display = 'block';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivThirdRemarksTripletsColTwo1').style.display = 'block';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivThirdRemarksTripletsColThree1').style.display = 'block';
	} else {		
		
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivLmpGaTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivLmpGaTripletsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivUsgGaTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivUsgGaTripletsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivBpdTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivBpdTripletsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivHcTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivHcTripletsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivAcTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivAcTripletsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivFlTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivFlTripletsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivAfiTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivAfiTripletsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivPlacentaTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivPlacentaTripletsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivEbwTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivEbwTripletsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivBppTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivBppTripletsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivDopplerTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivDopplerTripletsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivImpressionTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivImpressionTripletsColThree1').style.display = 'none';
		
		if(document.getElementById('thirdTrimRevisit').value =='NO' )
		document.getElementById('dataDivThirdRemarksTripletsColTwo1').style.display = 'none';
		if(document.getElementById('thirdTrimRevistThirdV').value <= 0 )
		document.getElementById('dataDivThirdRemarksTripletsColThree1').style.display = 'none';
	}

}

function ValidateLMPandTrim1Date(){

	var x = document.getElementsByClassName("validateDate");
	var y = document.getElementById("lmpId").value;
	
		for(var i=0; i<x.length; i++)
        {
        
		  var dt1 = x[i].value.split('/');
		  var d1 = new Date(dt1[2],(dt1[1]-1),dt1[0]);
		  var y1 = y.split('/');
		  var d2 =new Date(y1[2],(y1[1]-1),y1[0]);  // alert(d1+'\n'+d2);
		  if (d1 < d2){
        
        	 alert("Date should be grater than LMP Date");
        	 x[i].value="";
        	
        	 document.getElementById("ftGA1"+i).value="";
        	 document.getElementById("ftGA2"+i).value="";
        	 
            }     	   
        }   }


	function checkDischargeDate(inc) {
		if(document.getElementById('DateofDischarge'+inc).value != '' && document.getElementById('DateofAdmission'+inc).value != '' )
		var dischargeDate = document.getElementById('DateofDischarge'+inc).value;
		var admissionDate = document.getElementById('DateofAdmission'+inc).value;
		if(dischargeDate < admissionDate)
		  {
		   alert("Discharge Date should be greater than equal to admission Date");
		   document.getElementById('DateofDischarge'+inc).value="";
		   return false;
		  }
		return true;
	    }



function ValidateLMPandTrim2Date(){

	var x = document.getElementsByClassName("ValidateLMPandTrim2Date");
	var y = document.getElementById("lmpId").value;
	
		for(var i=0; i<x.length; i++)
        {
        
		  var dt1 = x[i].value.split('/');
		 
		  var d1 = new Date(dt1[2],(dt1[1]-1),dt1[0]);
		  
		  var y1 = y.split('/');
		
		  var d2 =new Date(y1[2],(y1[1]-1),y1[0]); 
		  
          if (d1 < d2){
        
        	 alert("Date should be grater than LMP Date");
        	 x[i].value="";
        	 
        	 document.getElementById("stGA1"+i).value="";
        	 document.getElementById("stGA2"+i).value="";
        	 
            }     	   
        }   }



function ValidateLMPandTrim3Date(){

	var x = document.getElementsByClassName("ValidateLMPandTrim3Date");
	var y = document.getElementById("lmpId").value;
	
		for(var i=0; i<x.length; i++)
        {
		  var dt1 = x[i].value.split('/');
		 
		  var d1 = new Date(dt1[2],(dt1[1]-1),dt1[0]);
		  
		  var y1 = y.split('/');
		
		  var d2 =new Date(y1[2],(y1[1]-1),y1[0]);  ;
		  
          if (d1 < d2){
        
        	 alert("Date should be grater than LMP Date");
        	 x[i].value="";
        	 
        	 document.getElementById("ttGA1"+i).value="";
        	 document.getElementById("ttGA2"+i).value="";
        	 
            }     	   
        }   }




function calculateWeeksForUSG14(){
	var lmpDate = document.getElementById('lmpId').value;
	var scannedEdcdate = document.getElementById('scannedEdc').value;
	var correctedEdcdate = document.getElementById('edcDate').value;
	currentDate = new Date();
	var month = currentDate.getMonth() + 1
	var day = currentDate.getDate()
	var year = currentDate.getFullYear()
	var seperator = "/"
	currentDate = new Date(month + seperator + day + seperator + year);

	var one_day=1000*60*60*24;
	var weeks=1000*60*60*24*7;
	if(correctedEdcdate!="" || scannedEdcdate!="")
	{
		var s;
		if(correctedEdcdate!="")
	       s = new Date(correctedEdcdate.substring(6),(correctedEdcdate.substring(3,5) - 1) ,correctedEdcdate.substring(0,2));
		else 
			s = new Date(scannedEdcdate.substring(6),(scannedEdcdate.substring(3,5) - 1) ,scannedEdcdate.substring(0,2));
     s.setMonth((s.getMonth()) - 9);
     s.setDate(s.getDate() - 7);
     var curr_date = s.getDate();
	    var curr_month = s.getMonth()+1;
	    var curr_year = s.getFullYear();
	    
	    var month;
	    var date;
	    if(s.getDate() < 10){
	    		date = "0"+curr_date;
	     		}else{
	     			date = curr_date;
	     		}
	     		
	     		if(s.getMonth()+1 < 10){
	     			month = "0"+curr_month
	     		}else{
	     			month = curr_month
	     		}
	    
	        var myDate = (date + "/" + month + "/" + curr_year);
		    var scan=myDate.split("/");
		    var date3=new Date(scan[2],(scan[1]-1),scan[0]);
		
		    scandiff=Math.floor((currentDate.getTime()-date3.getTime())/(one_day));
		    var scanweeks= Math.floor(scandiff/7);
		    var scanweekDays = scanweeks*7;
		    var scandays = scandiff- scanweekDays;
		    if(!isNaN(scanweeks)){
		    	if(scanweeks >= 10)		    	
		    	document.getElementById('14weeksDiv').style.display = 'block';
		    	else
		    	document.getElementById('14weeksDiv').style.display = 'none';	
		   }	
	}
else if(lmpDate !='')
	{
	var lmp=lmpDate.split("/");
    var date2=new Date(lmp[2],(lmp[1]-1),lmp[0]);

     diff=Math.floor((currentDate.getTime()-date2.getTime())/(one_day));
    var weeks= Math.floor(diff/7);
    var weekDays = weeks*7;
    var days = diff- weekDays;
    if(!isNaN(weeks)){
    	if(weeks >= 10)
    	document.getElementById('14weeksDiv').style.display = 'block';
    	else
    	document.getElementById('14weeksDiv').style.display = 'none';	
   }
	
	}
    
 }



function addRowIPadm() {
	var tbl = document.getElementById('IpTable');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('ipAdmissionCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'NBUVBRadio' + iteration;
	e1.id = 'NBUVBRadioCheck' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);
	
	
	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'DateofAdmission' + iteration;
	e1.id = 'DateofAdmission' + iteration;
	e1.style.width = "85px";
	e1.onblur = function(event) {
		ValidateLmp('DateofAdmission'+ iteration);
	};
	cellRight1.appendChild(e1);	
	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';
	img1.onclick = function(event) {
		var obj = document.getElementById('DateofAdmission' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};
	var dv = document.createElement("div");
	dv.appendChild(e1);
	dv.appendChild(img1);
	cellRight1.appendChild(dv);
	
	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'IPNo' + iteration;
	e1.id = 'IPNo' + iteration;
	e1.maxLength = "256";
	e1.style.width = "128px";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'IPDiagnosis' + iteration;
	e1.id = 'IPDiagnosis' + iteration;
	e1.maxLength = "256";
	e1.style.width = "150px";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('textarea');
	e1.type = 'text';
	e1.name = 'IPManagement' + iteration;
	e1.id = 'IPManagement' + iteration;
	e1.maxLength = "256";
	e1.style.width = "150px";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('textarea');
	e1.type = 'textarea';
	e1.name = 'IPAdvice' + iteration;
	e1.id = 'IPAdvice' + iteration;
	e1.maxLength = "128";
	e1.style.width = "150px";
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'DateofDischarge' + iteration;
	e1.id = 'DateofDischarge' + iteration;
	e1.maxLength = "128";
	e1.style.width = "85px";
	e1.onblur = function(event) {
		ValidateLmp('DateofDischarge'+ iteration);checkDischargeDate(iteration);
	};
	cellRight1.appendChild(e1);
	var img1 = document.createElement('img');
	img1.src = '/hms/jsp/images/cal.gif';
	img1.onclick = function(event) {
		var obj = document.getElementById('DateofDischarge' + iteration);
		setdate(document.getElementById('inputDate').value, obj, event);
	};
	var dv = document.createElement("div");
	dv.appendChild(e1);
	dv.appendChild(img1);
	cellRight1.appendChild(dv);
}



function removeRowIpAdmission() {
	var tbl = document.getElementById('IpTable');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('ipAdmissionCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 0; i <= iteration; i++) {
		if (document.getElementById("NBUVBRadioCheck" + i) != null
				&& (typeof document.getElementById("NBUVBRadioCheck" + i).checked) != 'undefined'
				&& document.getElementById("NBUVBRadioCheck" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 0; i <= iteration; i++) {
			if (document.getElementById("NBUVBRadioCheck" + i) != null
					&& (typeof document.getElementById("NBUVBRadioCheck" + i).checked) != 'undefined'
					&& document.getElementById("NBUVBRadioCheck" + i).checked) {
				var deleteRow = document.getElementById("NBUVBRadioCheck" + i).parentNode.parentNode;
				document.getElementById("NBUVBRadioCheck" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}


function validateUSGDate(id){
	
    enteredDate = document.getElementById(id).value;
    if(enteredDate != null && enteredDate !=''){
    	
    	var enteredDateSplit = enteredDate.split('/');
    	var dateEntered = new Date(enteredDateSplit[2],enteredDateSplit[1],enteredDateSplit[0]); 
    	
	var today = new Date();
	var dd = today.getDate();
	var mm = today.getMonth()+1; 

	var yyyy = today.getFullYear();
	if(dd<10){
	    dd='0'+dd;
	} 
	if(mm<10){
	    mm='0'+mm;
	} 
	
	//var today = dd+'/'+mm+'/'+yyyy;	
	var  today = new Date(yyyy,mm,dd); 
	if(dateEntered > today ){
		alert("Entered date should be less than current date!!! ");
		document.getElementById(id).value="";
		return;
	}
		
    }

	return;
	
}


function checkValidWeight(value)
{
        if (value <= 1000) {
        	
	    return true;
        }
        else{
            alert("Please enter valid weight (Maximum weight allowed is 999kg)!!!");
            document.getElementById('b16').value="";
        	return false;
        }
}

function checkSecondDoseDate(secondDoseId,firstDoseId){
	
	var firstDoseDate = document.getElementById(firstDoseId).value;
	var secondDoseDate = document.getElementById(secondDoseId).value;
	
	if(firstDoseDate !=null && firstDoseDate !='' && secondDoseDate !=null && secondDoseDate !='' ){
		
		var firstDoseDateSplit = firstDoseDate.split('/');
		var secondDoseDateSplit = secondDoseDate.split('/');
		
		var fDate = new Date(firstDoseDateSplit[2],firstDoseDateSplit[1],firstDoseDateSplit[0]); 
		var sDate = new Date(secondDoseDateSplit[2],secondDoseDateSplit[1],secondDoseDateSplit[0]);
		
		if(sDate <= fDate ){
			alert("Second TT dose date should be greater than first TT dose date");
			document.getElementById(secondDoseId).value = "";
			return;
		}
		
	}
	
	
}

function validateScanEdcDate(scanEdcId, usgDateId){
	
	var scanEdcDate = document.getElementById(scanEdcId).value;
	var usgDate = document.getElementById(usgDateId).value;
	
	if(usgDate !=null && usgDate != '' && scanEdcDate !=null && scanEdcDate != '')
		{
		  var scanEdcDateSplit = scanEdcDate.split('/');
		  var usgDateSplit = usgDate.split('/');
		  
		  var uDate = new Date(usgDateSplit[2],usgDateSplit[1],usgDateSplit[0]); 
		  var sDate = new Date(scanEdcDateSplit[2],scanEdcDateSplit[1],scanEdcDateSplit[0]);
		  if(sDate > uDate){
			  alert("Scan EDC date can't be greater than USG date!!");
				document.getElementById(scanEdcId).value = "";
				return;
		  }
		}
	
	return;
	
	
}
