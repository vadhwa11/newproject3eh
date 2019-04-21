function dataPhototherapyDiv() {
	if (document.getElementById('ptGenExamAnemia').checked==true) {
		document.getElementById('dataDivAnemia').style.display = 'inline';
    } else {
    	document.getElementById('dataDivAnemia').style.display = 'none';
    }
	
	if (document.getElementById('ptGenExamCyanosis').checked==true) {
		document.getElementById('dataDivCyanosis').style.display = 'inline';
    } else {
    	document.getElementById('dataDivCyanosis').style.display = 'none';
    }
	
	if (document.getElementById('ptGenExamJaundice').checked==true) {
		document.getElementById('dataDivJaundice').style.display = 'inline';
    } else {
    	document.getElementById('dataDivJaundice').style.display = 'none';
    }
	
	if (document.getElementById('ptGenExamClubbing').checked==true) {
		document.getElementById('dataDivClubbing').style.display = 'inline';
    } else {
    	document.getElementById('dataDivClubbing').style.display = 'none';
    }
	
	if (document.getElementById('ptGenExamEdema').checked==true) {
		document.getElementById('dataDivEdema').style.display = 'inline';
    } else {
    	document.getElementById('dataDivEdema').style.display = 'none';
    }
	
	if (document.getElementById('ptGenExamLymphadenopathy').checked==true) {
		document.getElementById('dataDivLymphadenopathy').style.display = 'inline';
    } else {
    	document.getElementById('dataDivLymphadenopathy').style.display = 'none';
    }
	
	if (document.getElementById("ptFamilyHistoryOfSimilarIllness").checked==true) {
		document.getElementById('dataDivFamilyIllness').style.display = 'inline';
	} else {
		document.getElementById('dataDivFamilyIllness').style.display = 'none';
	}
	
	if (document.getElementById('ptPrimaryLessionOthers').checked==true) {
		document.getElementById('dataDivOthers').style.display = 'inline';
    } else {
    	document.getElementById('dataDivOthers').style.display = 'none';
    }
	
	if (document.getElementById('ptSecondaryLessionOthers').checked==true) {
		document.getElementById('dataDivSecOthers').style.display = 'inline';
    } else {
    	document.getElementById('dataDivSecOthers').style.display = 'none';
    }

	if (document.getElementById('hairOthers').checked==true) {
		document.getElementById('dataDivHair').style.display = 'inline';
    } else {
    	document.getElementById('dataDivHair').style.display = 'none';
    }
	
	if (document.getElementById('nailsOthers').checked==true) {
		document.getElementById('dataDivNails').style.display = 'inline';
    } else {
    	document.getElementById('dataDivNails').style.display = 'none';
    }
	return true;
}

function calculatePhototherapyBMI() {
	var ptHeight = document.getElementById("ptHeight").value;
	var ptWeight = document.getElementById("ptWeight").value;
	document.getElementById("ptBmi").value = "";
	if(ptHeight != null && ptWeight != null && ptHeight != "" && ptWeight != "") {
		ptHeight = 	parseFloat(ptHeight)/100;
		var valBmi= ((ptWeight/(ptHeight*ptHeight)).toFixed(2));
		if(valBmi=='NaN'){
			document.getElementById("ptBmi").value ="";
		}else{
		document.getElementById("ptBmi").value = ((ptWeight/(ptHeight*ptHeight)).toFixed(2));
		}
	}
	bmiPhototherapyCat();
}

function bmiPhototherapyCat(){
	var ptBmiCat;
	var ptHeight = document.getElementById("ptHeight").value;
	var ptWeight = document.getElementById("ptWeight").value;
	if(ptHeight != null && ptWeight != null && ptHeight != "" && ptWeight != "") {
		ptHeight = 	parseFloat(ptHeight)/100;
		ptBmiCat=(ptWeight/(ptHeight*ptHeight)).toFixed(2);

		document.getElementById("ptBmiCat").innerHTML = " ";
		 if(ptBmiCat<18.5){
			 document.getElementById("ptBmiCat").innerHTML = "Underweight";
			 document.getElementById("ptBmiCat").style.color = '#F65C5C';
			 document.getElementById("ptBmi").style.color = '#F65C5C';
		}else if(ptBmiCat>=18.5 && ptBmiCat<25){
			document.getElementById("ptBmiCat").innerHTML = "Healthy Range" ;	
			document.getElementById("ptBmiCat").style.color = 'green';
			document.getElementById("ptBmi").style.color = 'green';
		}else if(ptBmiCat>=25 && ptBmiCat<=30){
			document.getElementById("ptBmiCat").innerHTML = "Overweight";
			document.getElementById("ptBmiCat").style.color = '#574F4F';
			document.getElementById("ptBmi").style.color = '#574F4F';
		}else if(ptBmiCat>=30 && ptBmiCat<=35){
			document.getElementById("ptBmiCat").innerHTML = "Obese";
			document.getElementById("ptBmiCat").style.color = '#C40707';
			document.getElementById("ptBmi").style.color = '#C40707';
		}else if(ptBmiCat>35){
			document.getElementById("ptBmiCat").innerHTML = "Severely obese ";
			document.getElementById("ptBmiCat").style.color = '#AD0C0C';
			document.getElementById("ptBmi").style.color = '#AD0C0C';
		}else{
			document.getElementById("ptBmiCat").innerHTML = "";
		}
		}
		else{
			
			document.getElementById("ptBmiCat").innerHTML = "";
		}		
}

function illnessDivShow() {
	if (document.getElementById("ptSystemIllness").checked==true) {
		document.getElementById('illnessDiv').style.display = 'inline';
	} else {
		document.getElementById('illnessDiv').style.display = 'none';
	}
}

function showNbuvbDiv() {
	if (document.getElementById("ptNbuvb").checked==true) {
		document.getElementById('nbuvbDiv').style.display = 'inline';
	} else {
		document.getElementById('nbuvbDiv').style.display = 'none';
	}
}

function showPuvaDiv() {
	if (document.getElementById("ptPuva").checked==true) {
		document.getElementById('puvaDiv').style.display = 'inline';
	} else {
		document.getElementById('puvaDiv').style.display = 'none';
	}
}

function showPrimaryLesionOthers(ptPrimaryLesionvalue,inc) {
	if (ptPrimaryLesionvalue=="Others") {
		document.getElementById('ptPrimaryLesionOthersDiv'+inc).style.display = 'inline';
	} else {
		document.getElementById('ptPrimaryLesionOthersDiv'+inc).style.display = 'none';
	}
}

function showSecondaryLesionOthers(ptSecondaryLesionvalue,inc) {
	if (ptSecondaryLesionvalue=="Others") {
		document.getElementById('ptSecondaryLessionOthersDiv'+inc).style.display = 'inline';
	} else {
		document.getElementById('ptSecondaryLessionOthersDiv'+inc).style.display = 'none';
	}
}

function addRowForPrimaryLesionForPhototherapy(val) {
	var tbl = document.getElementById('ptPrimaryLessionGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('ptPrimaryLesionCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'ptPrimaryLesionRadio' + iteration;
	e1.id = 'ptPrimaryLesionRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Macule', 'Macule');
	e1.options[2] = new Option('Papule', 'Papule');
	e1.options[3] = new Option('Plaque', 'Plaque');
	e1.options[4] = new Option('Nodule', 'Nodule');
	e1.options[5] = new Option('Others', 'Others');
	e1.name = 'ptPrimaryLesion' + iteration;
	e1.id = 'ptPrimaryLesion' + iteration;
	e1.setAttribute('style','width:65px;');
	e1.setAttribute("onchange", "showPrimaryLesionOthers(this.value,'"+iteration+"');");
	cellRight1.appendChild(e1);
	
	var ele = document.createElement("div");
    ele.setAttribute("id","ptPrimaryLesionOthersDiv" + iteration);
    ele.style.display='none';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.className = "medium";
	e1.name = 'ptPrimaryLesionOthers' + iteration;
	e1.id = 'ptPrimaryLesionOthers' + iteration;
	e1.maxLength = 16;
	e1.tabIndex ="1";
	ele.appendChild(e1);
	cellRight1.appendChild(ele);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'ptPrimaryLesionNo' + iteration;
	e1.setAttribute('style','width:83px;');
	e1.id = 'ptPrimaryLesionNo' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Single', 'Single');
	e1.options[2] = new Option('Multiple', 'Multiple');
	e1.options[3] = new Option('Generalized', 'Generalized');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('Select');
	e1.setAttribute('style','width:84px;');
	e1.name = 'ptPrimaryLesionSite' + iteration;
	e1.id = 'ptPrimaryLesionSite' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Scalp', 'Scalp');
	e1.options[2] = new Option('Face', 'Face');
	e1.options[3] = new Option('Neck', 'Neck');
	e1.options[4] = new Option('Upper Limb', 'Upper Limb');
	e1.options[5] = new Option('Trunk', 'Trunk');
	e1.options[6] = new Option('Lower Limb', 'Lower Limb');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name = 'typeOfPtPrimaryLesion' + iteration;
	e1.style.width = "75px";
	e1.id = 'typeOfPtPrimaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Discrete', 'Discrete');
	e1.options[2] = new Option('Confluent', 'Confluent');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.name = 'ptPrimaryPigmentation' + iteration;
	e1.style.width = "105px";
	e1.id = 'ptPrimaryPigmentation' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	cellRight1.appendChild(e1);
	var e1 = document.createElement('Select');
	e1.name = 'ptPrimaryPigmentationValue' + iteration;
	e1.style.width = "105px";
	e1.id = 'ptPrimaryPigmentationValue' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Erythematous', 'Erythematous');
	e1.options[2] = new Option('Hypo pigmented', 'Hypo pigmented');
	e1.options[3] = new Option('Hyper pigmented', 'Hyper pigmented');
	e1.options[4] = new Option('De pigmented', 'De pigmented');
	cellRight1.appendChild(e1);

	
	var cellRight1 = row.insertCell(6); var e1 =
	document.createElement('Select'); e1.name = 'ptPrimaryCharacter' +
	iteration; e1.id = 'ptPrimaryCharacter' + iteration; e1.options[0] = new
	Option('Select', ''); e1.options[1] = new Option('Flat', 'Flat');
	e1.options[2] = new Option('Raised', 'Raised'); 
	e1.options[3] = new Option('Fluid Filled', 'Fluid Filled'); 
	e1.options[4] = new Option('Pustule', 'Pustule'); 
	e1.style.width = "82px";
	cellRight1.appendChild(e1);
	 
	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('Select');
	e1.name = 'ptPrimaryBorder' + iteration;
	e1.id = 'ptPrimaryBorder' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Well defined', 'Well defined');
	e1.options[2] = new Option('Partially Ill Defined', 'Partially Ill Defined');
	e1.options[3] = new Option('Ill Defined', 'Ill Defined');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('Select');
	e1.name = 'ptPrimarySurface' + iteration;
	e1.className = "smaller";
	e1.id = 'ptPrimarySurface' + iteration;
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
	e1.className = "medium";
	e1.name = 'ptPrimarySmallestSize' + iteration;
	e1.id = 'ptPrimarySmallestSize' + iteration;
	e1.maxLength = 10;
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
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
	e1.name = 'ptPrimaryLargestSize' + iteration;
	e1.id = 'ptPrimaryLargestSize' + iteration;
	e1.maxLength = 10;
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.setAttribute('validate', 'Size,int,no');
	/*cellRight1.appendChild(e1);*/
	dv.appendChild(e1);
	
	var e12 = document.createElement('Label');
	e12.name = 'Largest Lesion' + iteration;
	e12.className = "smallAuto";
	e12.style.width = "72px";
	e12.innerHTML = "Largest Lesion";
	/*cellRight1.appendChild(e12);*/
	dv.appendChild(e12);
	cellRight1.appendChild(dv);

	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('Select');
	e1.name = 'ptHairOnPrimaryLesion' + iteration;
	e1.className = "medium2";
	e1.id = 'ptHairOnPrimaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Normal', 'Normal');
	e1.options[2] = new Option('De pigmented', 'De pigmented');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(11);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.className = "medium";
	e1.name = 'ptPrimaryAdditionalFeature' + iteration;
	e1.id = 'ptPrimaryAdditionalFeature' + iteration;
	e1.maxLength = 100;
	cellRight1.appendChild(e1);

}

function removeRowForPrimaryLesionForPhototherapy() {
	var tbl = document.getElementById('ptPrimaryLessionGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('ptPrimaryLesionCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("ptPrimaryLesionRadio" + i) != null
				&& (typeof document.getElementById("ptPrimaryLesionRadio" + i).checked) != 'undefined'
				&& document.getElementById("ptPrimaryLesionRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("ptPrimaryLesionRadio" + i) != null
					&& (typeof document.getElementById("ptPrimaryLesionRadio" + i).checked) != 'undefined'
					&& document.getElementById("ptPrimaryLesionRadio" + i).checked) {
				var deleteRow = document.getElementById("ptPrimaryLesionRadio" + i).parentNode.parentNode;
				document.getElementById("ptPrimaryLesionRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowForSecondaryLesionForPhototherapy(val) {
	var tbl = document.getElementById('ptSecondaryLessionGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('ptSecondaryLesionCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'ptSecondaryLesionRadio' + iteration;
	e1.id = 'ptSecondaryLesionRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('Select');
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Scale', 'Scale');
	e1.options[2] = new Option('Crust', 'Crust');
	e1.options[3] = new Option('Others', 'Others');
	e1.name = 'ptSecondaryLession' + iteration;
	e1.id = 'ptSecondaryLession' + iteration;
	e1.style.width = "65px";
	e1.setAttribute("onchange", "showSecondaryLesionOthers(this.value,'"+iteration+"');");
	cellRight1.appendChild(e1);
	
	var ele = document.createElement("div");
    ele.setAttribute("id","ptSecondaryLessionOthersDiv" + iteration);
    ele.style.display='none';
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.className = "medium";
	e1.name = 'ptSecondaryLessionOthers' + iteration;
	e1.id = 'ptSecondaryLessionOthers' + iteration;
	e1.maxLength = 16;
	e1.tabIndex ="1";
	ele.appendChild(e1);
	cellRight1.appendChild(ele);
	

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('Select');
	e1.name = 'ptSecondaryLesionNo' + iteration;
	e1.style.width = "83px";
	e1.id = 'ptSecondaryLesionNo' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Single', 'Single');
	e1.options[2] = new Option('Multiple', 'Multiple');
	e1.options[3] = new Option('Generalized', 'Generalized');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('Select');
	e1.style.width = "84px";
	e1.name = 'ptSecondaryLesionSite' + iteration;
	e1.id = 'ptSecondaryLesionSite' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Scalp', 'Scalp');
	e1.options[2] = new Option('Face', 'Face');
	e1.options[3] = new Option('Neck', 'Neck');
	e1.options[4] = new Option('Upper Limb', 'Upper Limb');
	e1.options[5] = new Option('Trunk', 'Trunk');
	e1.options[6] = new Option('Lower Limb', 'Lower Limb');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name = 'typeOfptSecondaryLesion' + iteration;
	e1.style.width ="75px";
	e1.id = 'typeOfptSecondaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Discrete', 'Discrete');
	e1.options[2] = new Option('Confluent', 'Confluent');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('Select');
	e1.name = 'ptSecondaryPigmentation' + iteration;
	e1.style.width = "105px";
	e1.id = 'ptSecondaryPigmentation' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Yes', 'Yes');
	e1.options[2] = new Option('No', 'No');
	cellRight1.appendChild(e1);
	var e1 = document.createElement('Select');
	e1.name = 'ptSecondaryPigmentationValue' + iteration;
	e1.style.width = "105px";
	e1.id = 'ptSecondaryPigmentationValue' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Erythematous', 'Erythematous');
	e1.options[2] = new Option('Hypo pigmented', 'Hypo pigmented');
	e1.options[3] = new Option('Hyper pigmented', 'Hyper pigmented');
	e1.options[4] = new Option('De pigmented', 'De pigmented');
	cellRight1.appendChild(e1);
	 
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('Select');
	e1.name = 'ptSecondaryBorder' + iteration;
	e1.id = 'ptSecondaryBorder' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Well defined', 'Well defined');
	e1.options[2] = new Option('Partially Ill Defined', 'Partially Ill Defined');
	e1.options[3] = new Option('Ill Defined', 'Ill Defined');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('Select');
	e1.name = 'ptSecondarySurface' + iteration;
	e1.className = "smaller";
	e1.id = 'ptSecondarySurface' + iteration;
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
	e1.name = 'ptSecondarySmallestSize' + iteration;
	e1.id = 'ptSecondarySmallestSize' + iteration;
	e1.maxLength = 10;
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
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
	e1.name = 'ptSecondaryLargestSize' + iteration;
	e1.id = 'ptSecondaryLargestSize' + iteration;
	e1.maxLength = 10;
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	e1.setAttribute('validate', 'Size,int,no');
	/*cellRight1.appendChild(e1);*/
	dv.appendChild(e1);
	var e12 = document.createElement('Label');
	e12.name = 'Largest Lesion' + iteration;
	e12.className = "smallAuto";
	e12.style.width = "72px";;
	e12.innerHTML = "Largest Lesion";
	/*cellRight1.appendChild(e12);*/
	dv.appendChild(e12);
	cellRight1.appendChild(dv);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('Select');
	e1.name = 'ptHairOnSecondaryLesion' + iteration;
	e1.className = "medium2";
	e1.id = 'ptHairOnSecondaryLesion' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('Normal', 'Normal');
	e1.options[2] = new Option('De pigmented', 'De pigmented');
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(10);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.className = "medium";
	e1.name = 'ptSecondaryAdditionalFeature' + iteration;
	e1.id = 'ptSecondaryAdditionalFeature' + iteration;
	e1.maxLength = 100;
	cellRight1.appendChild(e1);

}

function removeRowForSecondaryLesionForPhototherapy() {
	var tbl = document.getElementById('ptSecondaryLessionGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('ptSecondaryLesionCount');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("ptSecondaryLesionRadio" + i) != null
				&& (typeof document.getElementById("ptSecondaryLesionRadio" + i).checked) != 'undefined'
				&& document.getElementById("ptSecondaryLesionRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("ptSecondaryLesionRadio" + i) != null
					&& (typeof document.getElementById("ptSecondaryLesionRadio" + i).checked) != 'undefined'
					&& document.getElementById("ptSecondaryLesionRadio" + i).checked) {
				var deleteRow = document.getElementById("ptSecondaryLesionRadio" + i).parentNode.parentNode;
				document.getElementById("ptSecondaryLesionRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			}
		}
	}
}

function addRowForNBUVB() {
	var tbl = document.getElementById('nbUvbGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('nbuvbCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'NBUVBRadio' + iteration;
	e1.id = 'NBUVBRadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'srNoNbuvb' + iteration;
	e1.id = 'srNoNbuvb' + iteration;
	e1.className = 'sNumb';
	e1.readOnly = 'readOnly';
	e1.value = iteration;
	cellRight1.appendChild(e1);
	
	var cell1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'nbuvbDate' + (iteration);
	e1.id = 'nbuvbDate' + (iteration);
	e1.readOnly = 'readOnly';
	e1.value = document.getElementById('currentDateJs').value;
	e1.className = 'small';
	var eImg = document.createElement('img');
	eImg.src = '/hms/jsp/images/cal.gif';
	eImg.style.display = 'inline';
	eImg.onclick = function(event) {
		setdate(document.getElementById('currentDateJs').value, document.getElementById('nbuvbDate' + iteration), event);
	};
	cell1.appendChild(e1);
	cell1.appendChild(eImg);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('Select');
	e1.name = 'nbuvbIncrement' + iteration;
	e1.className = "medium2";
	e1.id = 'nbuvbIncrement' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('0 %', '0');
	e1.options[2] = new Option('20 %', '20');
	e1.setAttribute("onchange", "setNbuvbDosage(this.value,'"+iteration+"');");
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'nbuvbDosage' + (iteration);
	e1.id = 'nbuvbDosage' + (iteration);
	var dosage = document.getElementById('nbuvbDosage' + (parseInt(iteration)-1)).value;
	e1.value = dosage;
	e1.className = "small";
	e1.readOnly = 'readOnly';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'nbuvbScore' + (iteration);
	e1.id = 'nbuvbScore' + (iteration);
	e1.maxLength = 6;
	e1.className = "small";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'nbuvbRemarks' + (iteration);
	e1.id = 'nbuvbRemarks' + (iteration);
	e1.maxLength = 128;
	e1.style.width = "350px";
	cellRight1.appendChild(e1);
}

//added by swarup 12-12-2017
function removeRowForNBUVB() {
	var tbl = document.getElementById('nbUvbGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('nbuvbCount');
	var iteration = parseInt(hdb.value);
	var inc = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("NBUVBRadio" + i) != null
				&& (typeof document.getElementById("NBUVBRadio" + i).checked) != 'undefined'
				&& document.getElementById("NBUVBRadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("NBUVBRadio" + i) != null
					&& (typeof document.getElementById("NBUVBRadio" + i).checked) != 'undefined'
					&& document.getElementById("NBUVBRadio" + i).checked) {
				var deleteRow = document.getElementById("NBUVBRadio" + i).parentNode.parentNode;
				document.getElementById("NBUVBRadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
				inc--;
			}
		}
	}
	document.getElementById('nbuvbCount').value = inc;
}
function addRowForPUVA() {
	var tbl = document.getElementById('puvaGrid');
	var lastRow = tbl.rows.length;
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('puvaCount');
	iteration = parseInt(hdb.value) + 1;
	hdb.value = iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name = 'PUVARadio' + iteration;
	e1.id = 'PUVARadio' + iteration;
	e1.className = 'radioCheck';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'srNoPuva' + iteration;
	e1.id = 'srNoPuva' + iteration;
	e1.className = 'sNumb';
	e1.readOnly = 'readOnly';
	e1.value = iteration;
	cellRight1.appendChild(e1);
	
	var cell1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'puvaDate' + (iteration);
	e1.id = 'puvaDate' + (iteration);
	e1.value = document.getElementById('currentDateJs').value;
	e1.readOnly = 'readOnly';
	e1.className = 'small';
	var eImg = document.createElement('img');
	eImg.src = '/hms/jsp/images/cal.gif';
	eImg.style.display = 'inline';
	eImg.onclick = function(event) {
		setdate(document.getElementById('currentDateJs').value, document.getElementById('puvaDate' + iteration), event);
	};
	cell1.appendChild(e1);
	cell1.appendChild(eImg);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('Select');
	e1.name = 'puvaIncrement' + iteration;
	e1.className = "medium2";
	e1.id = 'puvaIncrement' + iteration;
	e1.options[0] = new Option('Select', '');
	e1.options[1] = new Option('0', '0');
	e1.options[2] = new Option('+0.5', '0.5');
	e1.setAttribute("onchange", "setPuvaDosage(this.value,'"+iteration+"');");
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'puvaDosage' + (iteration);
	e1.id = 'puvaDosage' + (iteration);
	var dosage = document.getElementById('puvaDosage' + (parseInt(iteration)-1)).value;
	e1.value = dosage;
	e1.className = "small";
	e1.readOnly = 'readOnly';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'puvaScore' + (iteration);
	e1.id = 'puvaScore' + (iteration);
	e1.maxLength = 6;
	e1.className = "small";
	e1.onkeypress = function (event) {
		  javascript: return isNumber(event);
	};
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name = 'puvaRemarks' + (iteration);
	e1.id = 'puvaRemarks' + (iteration);
	e1.maxLength = 100;
	e1.style.width = "350px";
	cellRight1.appendChild(e1);
}

//added by swarup 12-12-2017
function removeRowForPUVA() {
	var tbl = document.getElementById('puvaGrid');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('puvaCount');
	var iteration = parseInt(hdb.value);
	var inc = parseInt(hdb.value);
	var totalSelected = 0;
	for (var i = 1; i <= iteration; i++) {
		if (document.getElementById("PUVARadio" + i) != null
				&& (typeof document.getElementById("PUVARadio" + i).checked) != 'undefined'
				&& document.getElementById("PUVARadio" + i).checked) {
			totalSelected = totalSelected + 1;
		}
	}
	if (totalSelected == 0) {
		alert('Please select atleast 1 row to delete');
	} else if (lastRow == 2 || lastRow == (totalSelected + 1)) {
		alert('You can not delete all Row.');
	} else if (lastRow > 2) {
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("PUVARadio" + i) != null
					&& (typeof document.getElementById("PUVARadio" + i).checked) != 'undefined'
					&& document.getElementById("PUVARadio" + i).checked) {
				var deleteRow = document.getElementById("PUVARadio" + i).parentNode.parentNode;
				document.getElementById("PUVARadio" + i).parentNode.parentNode.parentNode
						.removeChild(deleteRow);
			inc--;
			}
		}
	}
	document.getElementById('puvaCount').value = inc;
}
function setNbuvbDosage(nbuvbDosageValue,val) {
	var inc =parseInt(val)-1;
	var dosage = document.getElementById('nbuvbDosage' + inc).value;
	var dosageValue = parseFloat(dosage)+parseFloat(nbuvbDosageValue)*parseFloat(dosage)/100;
	document.getElementById('nbuvbDosage' + val).value = dosageValue.toFixed(2);
}

function setPuvaDosage(puvaDosageValue,iteration) {
	var inc =parseInt(iteration)-1;
	var dosage = document.getElementById('puvaDosage' + inc).value;
	var dosageValue = parseFloat(dosage)+parseFloat(puvaDosageValue);
	document.getElementById('puvaDosage' + iteration).value = dosageValue;
}


 