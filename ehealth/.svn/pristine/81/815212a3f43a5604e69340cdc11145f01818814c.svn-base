
function dataMicturitionDiv(val){
	
	if(val=='Increased'){
		document.getElementById('MicturitionDiv').style.display = 'inline';
	}
	else if(val=='Decreased'){
		document.getElementById('MicturitionDiv').style.display = 'inline';
	}
	else{
		document.getElementById('MicturitionDiv').style.display = 'none';
	}
	return true;
}

function dataSputumDiv(val){
	
	
	if(val=='Yes'){
		document.getElementById('SputumDiv').style.display = 'inline';
	}else{
		document.getElementById('SputumDiv').style.display = 'none';
	}
	return true;
}

function dataSalivaryGlands(val){
	if(val=='Palpable'){
		document.getElementById('salivaryGlandsDiv').style.display = 'inline';
	}
	if(val=='NonPalpable'){
		document.getElementById('salivaryGlandsDiv').style.display = 'none';
	}
    return true;
}
function lactation()
{
	
      for(var counter=0;counter<document.getElementsByName('lactation').length;counter++)
       {
               if (document.getElementsByName('lactation')[counter].checked == true)
               {
            	   document.getElementById('lactationDiv').style.display = 'inline';

               }else{
            	   document.getElementById('lactationDiv').style.display = 'none';
               }
       }
}



function addDentalRow(){
    var tbl = document.getElementById('soft');
    var lastRow = tbl.rows.length;

    var row = tbl.insertRow(lastRow);
    var hdb = document.getElementById('hiddenValueCharge');
    var iteration = parseInt(hdb.value)+1;
    hdb.value = iteration;


    var cell0 = row.insertCell(0);
    var e0 = document.createElement('input');
    e0.type = 'radio';
    e0.name='selectedChrage';
    e0.className='radioCheck';
    e0.value=(iteration);
    cell0.appendChild(e0);


    var cell1 = row.insertCell(1);
    var e1 = document.createElement('select');
    e1.name='symptoms'+ (iteration);
    e1.id='symptoms'+(iteration);
    e1.options[0] = new Option('Select', '');
    e1.options[1] = new Option('Lip (Vermilion border)','Lip');
    e1.options[2] = new Option('Labial mucosa','LabialMucosa');
    e1.options[3] = new Option('Labial sulcus','LabialSulcus');
    e1.options[4] = new Option('Labial commissure','LabialCommissure');
    e1.options[5] = new Option('Buccel Mucosa','BuccelMucosa');
    e1.options[6] = new Option('Buccel Sulcus','BuccelSulcus');
    e1.options[7] = new Option('Anterior 2/3 tongue','Anterior');
    e1.options[8] = new Option('Posterior 1/3 tongue','Posterior');
    e1.options[9] = new Option('Tip of tongue', 'Tip');
    e1.options[10] = new Option('Lateral borders of tongue', 'Lateral');
    e1.options[11] = new Option('Ventral surface of tongue', 'Ventral');
    e1.options[12] = new Option('Hard palate', 'HardPalate');
    e1.options[13] = new Option('HardPalate','SoftPalate');
    e1.options[14] = new Option('FloorOfMouth', 'Floor of mouth');
    e1.options[15] = new Option('Gingiva', 'Gingiva');
    e1.options[16] = new Option('AlveolarRidge', 'Alveolar Ridge');
           
   
    cell1.appendChild(e1);
    
    
    
    var cell2 = row.insertCell(2);
    var e2 = document.createElement('select');
    e2.name='burning'+ (iteration);
    e2.id='burning'+(iteration);
    e2.options[0] = new Option('Select', '');
    e2.options[1] = new Option('Yes','Yes');
    e2.options[2] = new Option('No','No');
    cell2.appendChild(e2);
   
    
    var cell3 = row.insertCell(3);
    var e3 = document.createElement('select');
    e3.name='hyper'+ (iteration);
    e3.id='hyper'+(iteration);
    e3.options[0] = new Option('Select', '');
    e3.options[1] = new Option('Yes','Yes');
    e3.options[2] = new Option('No','No');
    cell3.appendChild(e3);
    
    var cell4 = row.insertCell(4);
    var e4 = document.createElement('select');
    e4.name='patches'+ (iteration);
    e4.id='patches'+(iteration);
    e4.options[0] = new Option('Select', '');
    e4.options[1] = new Option('Yes','Yes');
    e4.options[2] = new Option('No','No');
    cell4.appendChild(e4);
    
    var cell5 = row.insertCell(5);
    var e5 = document.createElement('select');
    e5.name='patchesNon'+ (iteration);
    e5.id='patchesNon'+(iteration);
    e5.options[0] = new Option('Select', '');
    e5.options[1] = new Option('Yes','Yes');
    e5.options[2] = new Option('No','No');
    cell5.appendChild(e5);
    
    var cell6 = row.insertCell(6);
    var e6 = document.createElement('select');
    e6.name='patchesWhite'+ (iteration);
    e6.id='patchesWhite'+(iteration);
    e6.options[0] = new Option('Select', '');
    e6.options[1] = new Option('Yes','Yes');
    e6.options[2] = new Option('No','No');
    cell6.appendChild(e6);
    
    var cell7 = row.insertCell(7);
    var e7 = document.createElement('select');
    e7.name='patchesNonWhite'+ (iteration);
    e7.id='patchesNonWhite'+(iteration);
    e7.options[0] = new Option('Select', '');
    e7.options[1] = new Option('Yes','Yes');
    e7.options[2] = new Option('No','No');
    cell7.appendChild(e7);
    
    var cell17 = row.insertCell(8);
    var e17 = document.createElement('select');
    e17.name='patchesStriae'+ (iteration);
    e17.id='patchesStriae'+(iteration);
    e17.options[0] = new Option('Select', '');
    e17.options[1] = new Option('Yes','Yes');
    e17.options[2] = new Option('No','No');
    cell17.appendChild(e17);
    
    
    var cell8 = row.insertCell(9);
    var e8 = document.createElement('select');
    e8.name='swelling'+ (iteration);
    e8.id='swelling'+(iteration);
    e8.options[0] = new Option('Select', '');
    e8.options[1] = new Option('Yes','Yes');
    e8.options[2] = new Option('No','No');
    cell8.appendChild(e8);
    
    var cell9 = row.insertCell(10);
    var e9 = document.createElement('select');
    e9.name='ulcers'+ (iteration);
    e9.id='ulcers'+(iteration);
    e9.options[0] = new Option('Select', '');
    e9.options[1] = new Option('Yes','Yes');
    e9.options[2] = new Option('No','No');
    cell9.appendChild(e9);
    
    
    var cell10 = row.insertCell(11);
    var e10 = document.createElement('select');
    e10.name='roughness'+ (iteration);
    e10.id='roughness'+(iteration);
    e10.options[0] = new Option('Select', '');
    e10.options[1] = new Option('Yes','Yes');
    e10.options[2] = new Option('No','No');
    cell10.appendChild(e10);
    
}

function removeDentalRow()
{
       var tbl = document.getElementById('soft');
        var tblRows  = tbl.getElementsByTagName("tr");

         if(tblRows.length-2==0){
                alert("Can not delete all rows")
                return false;
    }

       for(var counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
       {
               if (document.getElementsByName('selectedChrage')[counter].checked == true)
               {
                         tbl.deleteRow(counter+1);

               }
       }
}
function dataHiddenVal()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValue').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('data'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('data'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('data'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('data'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValue').value=hidVal;
	
	
}
function dataHiddenValAnother()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueAnother').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('dataAnother'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('dataAnother'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('dataAnother'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('dataAnother'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueAnother').value=hidVal;
	
	
}






function dataHiddenMissingVal()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValue').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('missingTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('missingTeeth'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('missingTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('missingTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValue').value=hidVal;
	
	
}
function dataHiddenValCarious()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueAnother').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('cariousTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('cariousTeeth'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('cariousTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('cariousTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueAnother').value=hidVal;
	
	
}


function dataHiddenValeExposedOne()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueOne').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('exposedTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('exposedTeeth'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('exposedTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('exposedTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueOne').value=hidVal;
	
	
}

function dataHiddenValeOne()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueOne').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('dataAnotherOne'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('dataAnotherOne'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('dataAnotherOne'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('dataAnotherOne'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueOne').value=hidVal;
	
	
}

function dataHiddenValeTwo()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueTwo').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('dataAnotherTwo'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('dataAnotherTwo'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('dataAnotherTwo'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('dataAnotherTwo'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueTwo').value=hidVal;
	
	
}

function dataHiddenValeThree()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueThree').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('dataAnotherThree'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('dataAnotherThree'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('dataAnotherThree'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('dataAnotherThree'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueThree').value=hidVal;
	
	
}

function dataHiddenValeFour()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueFour').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('dataAnotherFour'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('dataAnotherFour'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('dataAnotherFour'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('dataAnotherFour'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueFour').value=hidVal;
	
	
}


function dataHiddenValeFive()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueFive').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('dataAnotherFive'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('dataAnotherFive'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('dataAnotherFive'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('dataAnotherFive'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueFive').value=hidVal;
	
	
}


function dataHiddenValeSix()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueSix').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('dataAnotherSix'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('dataAnotherSix'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('dataAnotherSix'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('dataAnotherSix'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueSix').value=hidVal;
	
	
}


function dataHiddenValeMobility()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueTwo').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('mobilityTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('mobilityTeeth'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('mobilityTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('mobilityTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueTwo').value=hidVal;
	
	
}



function dataHiddenValeColour()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueOne').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('colourTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('colourTeeth'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('colourTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('colourTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueOne').value=hidVal;
	
	
}


function dataHiddenValePockets()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValue').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('pocketsTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('pocketsTeeth'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('pocketsTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('pocketsTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValue').value=hidVal;
	
	
}


function dataHiddenValeAbrasion()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueFour').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('abrasionTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('abrasionTeeth'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('abrasionTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('abrasionTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueFour').value=hidVal;
	
	
}


function dataHiddenValeEvidence()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueThree').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('evidenceTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('evidenceTeeth'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('evidenceTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('evidenceTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueThree').value=hidVal;
	
	
}





function dataHiddenValeOcclusal()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueFive').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('occlusalTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('occlusalTeeth'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('occlusalTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('occlusalTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueFive').value=hidVal;
	
	
}




function dataHiddenValeRestorations()
{
	
	var hidVal ='';
	document.getElementById('dentalhiddenValueSix').value = '';
	for(var i=18;i>=11;i--){
		if(document.getElementById('restorationsTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=21;i<=28;i++){
		if(document.getElementById('restorationsTeeth'+i).checked){
			
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=48;i>=41;i--){
		if(document.getElementById('restorationsTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	for(var i=31;i<=38;i++){
		if(document.getElementById('restorationsTeeth'+i).checked){
			if(hidVal!=''){
				hidVal += ","+i;
			}
			else{
				hidVal = i;
			}
		}
	}
	document.getElementById('dentalhiddenValueSix').value=hidVal;
	
	
}


function data() {
	
	if (document.getElementById('data18p').checked==true)
    {
		document.getElementById('dataDiv18').style.display = 'inline';

    }else{
    	document.getElementById('dataDiv18').style.display = 'none';
    }
	
	if (document.getElementById('data17p').checked==true)
    {
		document.getElementById('dataDiv17').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv17').style.display = 'none';
    }
	
	if (document.getElementById('data16p').checked==true)
    {
		document.getElementById('dataDiv16').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv16').style.display = 'none';
    }
	
	
	if (document.getElementById('data15p').checked==true)
    {
		document.getElementById('dataDiv15').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv15').style.display = 'none';
    }
	
	
	if (document.getElementById('data14p').checked==true)
    {
		document.getElementById('dataDiv14').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv14').style.display = 'none';
    }
	
	
	if (document.getElementById('data13p').checked==true)
    {
		document.getElementById('dataDiv13').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv13').style.display = 'none';
    }
	if (document.getElementById('data12p').checked==true)
    {
		document.getElementById('dataDiv12').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv12').style.display = 'none';
    }
	if (document.getElementById('data11p').checked==true)
    {
		document.getElementById('dataDiv11').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv11').style.display = 'none';
    }
	
	
	if (document.getElementById('data21p').checked==true)
    {
		document.getElementById('dataDiv21').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv21').style.display = 'none';
    }
	
	
	if (document.getElementById('data22p').checked==true)
    {
		document.getElementById('dataDiv22').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv22').style.display = 'none';
    }
	
	
	if (document.getElementById('data23p').checked==true)
    {
		document.getElementById('dataDiv23').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv23').style.display = 'none';
    }
	
	
	
	if (document.getElementById('data24p').checked==true)
    {
		document.getElementById('dataDiv24').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv24').style.display = 'none';
    }
	
	
	if (document.getElementById('data25p').checked==true)
    {
		document.getElementById('dataDiv25').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv25').style.display = 'none';
    }
	
	
	if (document.getElementById('data26p').checked==true)
    {
		document.getElementById('dataDiv26').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv26').style.display = 'none';
    }
	
	
	if (document.getElementById('data27p').checked==true)
    {
		document.getElementById('dataDiv27').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv27').style.display = 'none';
    }
	
	if (document.getElementById('data28p').checked==true)
    {
		document.getElementById('dataDiv28').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv28').style.display = 'none';
    }
	if (document.getElementById('data48p').checked==true)
    {
		document.getElementById('dataDiv48').style.display = 'inline';

    }else{
    	document.getElementById('dataDiv48').style.display = 'none';
    }
	
	if (document.getElementById('data47p').checked==true)
    {
		document.getElementById('dataDiv47').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv47').style.display = 'none';
    }
	
	if (document.getElementById('data46p').checked==true)
    {
		document.getElementById('dataDiv46').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv46').style.display = 'none';
    }
	
	
	if (document.getElementById('data45p').checked==true)
    {
		document.getElementById('dataDiv45').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv45').style.display = 'none';
    }
	
	
	if (document.getElementById('data44p').checked==true)
    {
		document.getElementById('dataDiv44').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv44').style.display = 'none';
    }
	
	
	if (document.getElementById('data43p').checked==true)
    {
		document.getElementById('dataDiv43').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv43').style.display = 'none';
    }
	if (document.getElementById('data42p').checked==true)
    {
		document.getElementById('dataDiv42').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv42').style.display = 'none';
    }
	if (document.getElementById('data41p').checked==true)
    {
		document.getElementById('dataDiv41').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv41').style.display = 'none';
    }
	
	
	if (document.getElementById('data31p').checked==true)
    {
		document.getElementById('dataDiv31').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv31').style.display = 'none';
    }
	
	
	if (document.getElementById('data32p').checked==true)
    {
		document.getElementById('dataDiv32').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv32').style.display = 'none';
    }
	
	
	if (document.getElementById('data33p').checked==true)
    {
		document.getElementById('dataDiv33').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv33').style.display = 'none';
    }
	
	
	
	if (document.getElementById('data34p').checked==true)
    {
		document.getElementById('dataDiv34').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv34').style.display = 'none';
    }
	
	
	if (document.getElementById('data35p').checked==true)
    {
		document.getElementById('dataDiv35').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv35').style.display = 'none';
    }
	
	
	if (document.getElementById('data36p').checked==true)
    {
		document.getElementById('dataDiv36').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv36').style.display = 'none';
    }
	
	
	if (document.getElementById('data37p').checked==true)
    {
		document.getElementById('dataDiv37').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv37').style.display = 'none';
    }
	
	if (document.getElementById('data38p').checked==true)
    {
		document.getElementById('dataDiv38').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv38').style.display = 'none';
    }
	
	if (document.getElementById('data51p').checked==true)
    {
		document.getElementById('dataDiv51').style.display = 'inline';

    }else{
    	document.getElementById('dataDiv51').style.display = 'none';
    }
	
	if (document.getElementById('data52p').checked==true)
    {
		document.getElementById('dataDiv52').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv52').style.display = 'none';
    }
	
	if (document.getElementById('data53p').checked==true)
    {
		document.getElementById('dataDiv53').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv53').style.display = 'none';
    }
	
	
	if (document.getElementById('data54p').checked==true)
    {
		document.getElementById('dataDiv54').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv54').style.display = 'none';
    }
	
	
	if (document.getElementById('data55p').checked==true)
    {
		document.getElementById('dataDiv55').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv55').style.display = 'none';
    }
	
	
	if (document.getElementById('data65p').checked==true)
    {
		document.getElementById('dataDiv65').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv65').style.display = 'none';
    }
	if (document.getElementById('data64p').checked==true)
    {
		document.getElementById('dataDiv64').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv64').style.display = 'none';
    }
	if (document.getElementById('data63p').checked==true)
    {
		document.getElementById('dataDiv63').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv63').style.display = 'none';
    }
	
	
	if (document.getElementById('data62p').checked==true)
    {
		document.getElementById('dataDiv62').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv62').style.display = 'none';
    }
	
	
	if (document.getElementById('data61p').checked==true)
    {
		document.getElementById('dataDiv61').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv61').style.display = 'none';
    }
	
	
	if (document.getElementById('data81p').checked==true)
    {
		document.getElementById('dataDiv81').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv81').style.display = 'none';
    }
	
	
	
	if (document.getElementById('data82p').checked==true)
    {
		document.getElementById('dataDiv82').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv82').style.display = 'none';
    }
	
	
	if (document.getElementById('data83p').checked==true)
    {
		document.getElementById('dataDiv83').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv83').style.display = 'none';
    }
	
	
	if (document.getElementById('data84p').checked==true)
    {
		document.getElementById('dataDiv84').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv84').style.display = 'none';
    }
	
	
	if (document.getElementById('data85p').checked==true)
    {
		document.getElementById('dataDiv85').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv85').style.display = 'none';
    }
	
	if (document.getElementById('data71p').checked==true)
    {
		document.getElementById('dataDiv71').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv71').style.display = 'none';
    }
	if (document.getElementById('data72p').checked==true)
    {
		document.getElementById('dataDiv72').style.display = 'inline';

    }else{
    	document.getElementById('dataDiv72').style.display = 'none';
    }
	
	if (document.getElementById('data73p').checked==true)
    {
		document.getElementById('dataDiv73').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv73').style.display = 'none';
    }
	
	if (document.getElementById('data74p').checked==true)
    {
		document.getElementById('dataDiv74').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv74').style.display = 'none';
    }
	
	
	if (document.getElementById('data75p').checked==true)
    {
		document.getElementById('dataDiv75').style.display = 'inline';

    }
	else{
    	document.getElementById('dataDiv75').style.display = 'none';
    }
	
		
	/*if (document.getElementById('lactation').checked==true)
    {
		document.getElementById('lactationDiv').style.display = 'inline';

    }
	else{
    	document.getElementById('lactationDiv').style.display = 'none';
    }*/
return true;
}



function dataAnother() {
	
	if (document.getElementById('dataAnother18').checked==true)
    {
		document.getElementById('dataAnotherDiv18').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherDiv18').style.display = 'none';
    }
	
	if (document.getElementById('dataAnother17').checked==true)
    {
		document.getElementById('dataAnotherDiv17').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv17').style.display = 'none';
    }
	
	if (document.getElementById('dataAnother16').checked==true)
    {
		document.getElementById('dataAnotherDiv16').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv16').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother15').checked==true)
    {
		document.getElementById('dataAnotherDiv15').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv15').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother14').checked==true)
    {
		document.getElementById('dataAnotherDiv14').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv14').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother13').checked==true)
    {
		document.getElementById('dataAnotherDiv13').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv13').style.display = 'none';
    }

	if (document.getElementById('dataAnother12').checked==true)
    {
		document.getElementById('dataAnotherDiv12').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherDiv12').style.display = 'none';
    }
	
	if (document.getElementById('dataAnother11').checked==true)
    {
		document.getElementById('dataAnotherDiv11').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherDiv11').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother21').checked==true)
    {
		document.getElementById('dataAnotherDiv21').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv21').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother22').checked==true)
    {
		document.getElementById('dataAnotherDiv22').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv22').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother23').checked==true)
    {
		document.getElementById('dataAnotherDiv23').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv23').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnother24').checked==true)
    {
		document.getElementById('dataAnotherDiv24').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv24').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother25').checked==true)
    {
		document.getElementById('dataAnotherDiv25').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv25').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother26').checked==true)
    {
		document.getElementById('dataAnotherDiv26').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv26').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother27').checked==true)
    {
		document.getElementById('dataAnotherDiv27').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv27').style.display = 'none';
    }
	
	if (document.getElementById('dataAnother28').checked==true)
    {
		document.getElementById('dataAnotherDiv28').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv28').style.display = 'none';
    }
	if (document.getElementById('dataAnother48').checked==true)
    {
		document.getElementById('dataAnotherDiv48').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherDiv48').style.display = 'none';
    }
	
	if (document.getElementById('dataAnother47').checked==true)
    {
		document.getElementById('dataAnotherDiv47').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv47').style.display = 'none';
    }
	
	if (document.getElementById('dataAnother46').checked==true)
    {
		document.getElementById('dataAnotherDiv46').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv46').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother45').checked==true)
    {
		document.getElementById('dataAnotherDiv45').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv45').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother44').checked==true)
    {
		document.getElementById('dataAnotherDiv44').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv44').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother43').checked==true)
    {
		document.getElementById('dataAnotherDiv43').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv43').style.display = 'none';
    }
	if (document.getElementById('dataAnother42').checked==true)
    {
		document.getElementById('dataAnotherDiv42').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv42').style.display = 'none';
    }
	if (document.getElementById('dataAnother41').checked==true)
    {
		document.getElementById('dataAnotherDiv41').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv41').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother31').checked==true)
    {
		document.getElementById('dataAnotherDiv31').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv31').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother32').checked==true)
    {
		document.getElementById('dataAnotherDiv32').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv32').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother33').checked==true)
    {
		document.getElementById('dataAnotherDiv33').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv33').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnother34').checked==true)
    {
		document.getElementById('dataAnotherDiv34').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv34').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother35').checked==true)
    {
		document.getElementById('dataAnotherDiv35').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv35').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother36').checked==true)
    {
		document.getElementById('dataAnotherDiv36').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv36').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnother37').checked==true)
    {
		document.getElementById('dataAnotherDiv37').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv37').style.display = 'none';
    }
	
	if (document.getElementById('dataAnother38').checked==true)
    {
		document.getElementById('dataAnotherDiv38').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherDiv38').style.display = 'none';
    }
	
	
return true;
}





function dataAnotherSix() {
	
	if (document.getElementById('dataAnotherSix18').checked==true)
    {
		document.getElementById('dataAnotherSixDiv18').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherSixDiv18').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherSix17').checked==true)
    {
		document.getElementById('dataAnotherSixDiv17').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv17').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherSix16').checked==true)
    {
		document.getElementById('dataAnotherSixDiv16').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv16').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix15').checked==true)
    {
		document.getElementById('dataAnotherSixDiv15').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv15').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix14').checked==true)
    {
		document.getElementById('dataAnotherSixDiv14').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv14').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix13').checked==true)
    {
		document.getElementById('dataAnotherSixDiv13').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv13').style.display = 'none';
    }
	if (document.getElementById('dataAnotherSix12').checked==true)
    {
		document.getElementById('dataAnotherSixDiv12').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv12').style.display = 'none';
    }
	if (document.getElementById('dataAnotherSix11').checked==true)
    {
		document.getElementById('dataAnotherSixDiv11').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv11').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix21').checked==true)
    {
		document.getElementById('dataAnotherSixDiv21').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv21').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix22').checked==true)
    {
		document.getElementById('dataAnotherSixDiv22').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv22').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix23').checked==true)
    {
		document.getElementById('dataAnotherSixDiv23').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv23').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnotherSix24').checked==true)
    {
		document.getElementById('dataAnotherSixDiv24').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv24').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix25').checked==true)
    {
		document.getElementById('dataAnotherSixDiv25').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv25').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix26').checked==true)
    {
		document.getElementById('dataAnotherSixDiv26').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv26').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix27').checked==true)
    {
		document.getElementById('dataAnotherSixDiv27').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv27').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherSix28').checked==true)
    {
		document.getElementById('dataAnotherSixDiv28').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv28').style.display = 'none';
    }
	if (document.getElementById('dataAnotherSix48').checked==true)
    {
		document.getElementById('dataAnotherSixDiv48').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherSixDiv48').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherSix47').checked==true)
    {
		document.getElementById('dataAnotherSixDiv47').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv47').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherSix46').checked==true)
    {
		document.getElementById('dataAnotherSixDiv46').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv46').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix45').checked==true)
    {
		document.getElementById('dataAnotherSixDiv45').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv45').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix44').checked==true)
    {
		document.getElementById('dataAnotherSixDiv44').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv44').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix43').checked==true)
    {
		document.getElementById('dataAnotherSixDiv43').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv43').style.display = 'none';
    }
	if (document.getElementById('dataAnotherSix42').checked==true)
    {
		document.getElementById('dataAnotherSixDiv42').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv42').style.display = 'none';
    }
	if (document.getElementById('dataAnotherSix41').checked==true)
    {
		document.getElementById('dataAnotherSixDiv41').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv41').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix31').checked==true)
    {
		document.getElementById('dataAnotherSixDiv31').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv31').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix32').checked==true)
    {
		document.getElementById('dataAnotherSixDiv32').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv32').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix33').checked==true)
    {
		document.getElementById('dataAnotherSixDiv33').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv33').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnotherSix34').checked==true)
    {
		document.getElementById('dataAnotherSixDiv34').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv34').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix35').checked==true)
    {
		document.getElementById('dataAnotherSixDiv35').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv35').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix36').checked==true)
    {
		document.getElementById('dataAnotherSixDiv36').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv36').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherSix37').checked==true)
    {
		document.getElementById('dataAnotherSixDiv37').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv37').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherSix38').checked==true)
    {
		document.getElementById('dataAnotherSixDiv38').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherSixDiv38').style.display = 'none';
    }
	
	
return true;
}



function dataAnotherFive() {
	
	if (document.getElementById('dataAnotherFive18').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv18').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherFiveDiv18').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherFive17').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv17').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv17').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherFive16').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv16').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv16').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive15').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv15').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv15').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive14').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv14').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv14').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive13').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv13').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv13').style.display = 'none';
    }
	if (document.getElementById('dataAnotherFive12').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv12').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv12').style.display = 'none';
    }
	if (document.getElementById('dataAnotherFive11').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv11').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv11').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive21').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv21').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv21').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive22').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv22').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv22').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive23').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv23').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv23').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnotherFive24').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv24').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv24').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive25').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv25').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv25').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive26').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv26').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv26').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive27').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv27').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv27').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherFive28').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv28').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv28').style.display = 'none';
    }
	if (document.getElementById('dataAnotherFive48').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv48').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherFiveDiv48').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherFive47').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv47').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv47').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherFive46').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv46').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv46').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive45').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv45').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv45').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive44').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv44').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv44').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive43').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv43').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv43').style.display = 'none';
    }
	if (document.getElementById('dataAnotherFive42').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv42').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv42').style.display = 'none';
    }
	if (document.getElementById('dataAnotherFive41').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv41').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv41').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive31').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv31').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv31').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive32').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv32').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv32').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive33').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv33').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv33').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnotherFive34').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv34').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv34').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive35').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv35').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv35').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive36').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv36').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv36').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFive37').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv37').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv37').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherFive38').checked==true)
    {
		document.getElementById('dataAnotherFiveDiv38').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFiveDiv38').style.display = 'none';
    }
	
	
return true;
}


function dataAnotherFour() {
	
	if (document.getElementById('dataAnotherFour18').checked==true)
    {
		document.getElementById('dataAnotherFourDiv18').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherFourDiv18').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherFour17').checked==true)
    {
		document.getElementById('dataAnotherFourDiv17').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv17').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherFour16').checked==true)
    {
		document.getElementById('dataAnotherFourDiv16').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv16').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour15').checked==true)
    {
		document.getElementById('dataAnotherFourDiv15').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv15').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour14').checked==true)
    {
		document.getElementById('dataAnotherFourDiv14').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv14').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour13').checked==true)
    {
		document.getElementById('dataAnotherFourDiv13').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv13').style.display = 'none';
    }
	if (document.getElementById('dataAnotherFour12').checked==true)
    {
		document.getElementById('dataAnotherFourDiv12').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv12').style.display = 'none';
    }
	if (document.getElementById('dataAnotherFour11').checked==true)
    {
		document.getElementById('dataAnotherFourDiv11').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv11').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour21').checked==true)
    {
		document.getElementById('dataAnotherFourDiv21').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv21').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour22').checked==true)
    {
		document.getElementById('dataAnotherFourDiv22').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv22').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour23').checked==true)
    {
		document.getElementById('dataAnotherFourDiv23').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv23').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnotherFour24').checked==true)
    {
		document.getElementById('dataAnotherFourDiv24').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv24').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour25').checked==true)
    {
		document.getElementById('dataAnotherFourDiv25').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv25').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour26').checked==true)
    {
		document.getElementById('dataAnotherFourDiv26').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv26').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour27').checked==true)
    {
		document.getElementById('dataAnotherFourDiv27').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv27').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherFour28').checked==true)
    {
		document.getElementById('dataAnotherFourDiv28').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv28').style.display = 'none';
    }
	if (document.getElementById('dataAnotherFour48').checked==true)
    {
		document.getElementById('dataAnotherFourDiv48').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherFourDiv48').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherFour47').checked==true)
    {
		document.getElementById('dataAnotherFourDiv47').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv47').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherFour46').checked==true)
    {
		document.getElementById('dataAnotherFourDiv46').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv46').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour45').checked==true)
    {
		document.getElementById('dataAnotherFourDiv45').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv45').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour44').checked==true)
    {
		document.getElementById('dataAnotherFourDiv44').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv44').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour43').checked==true)
    {
		document.getElementById('dataAnotherFourDiv43').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv43').style.display = 'none';
    }
	if (document.getElementById('dataAnotherFour42').checked==true)
    {
		document.getElementById('dataAnotherFourDiv42').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv42').style.display = 'none';
    }
	if (document.getElementById('dataAnotherFour41').checked==true)
    {
		document.getElementById('dataAnotherFourDiv41').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv41').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour31').checked==true)
    {
		document.getElementById('dataAnotherFourDiv31').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv31').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour32').checked==true)
    {
		document.getElementById('dataAnotherFourDiv32').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv32').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour33').checked==true)
    {
		document.getElementById('dataAnotherFourDiv33').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv33').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnotherFour34').checked==true)
    {
		document.getElementById('dataAnotherFourDiv34').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv34').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour35').checked==true)
    {
		document.getElementById('dataAnotherFourDiv35').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv35').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour36').checked==true)
    {
		document.getElementById('dataAnotherFourDiv36').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv36').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherFour37').checked==true)
    {
		document.getElementById('dataAnotherFourDiv37').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv37').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherFour38').checked==true)
    {
		document.getElementById('dataAnotherFourDiv38').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherFourDiv38').style.display = 'none';
    }
	
	
return true;
}


function dataAnotherThree() {
	
	if (document.getElementById('dataAnotherThree18').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv18').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherThreeDiv18').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherThree17').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv17').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv17').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherThree16').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv16').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv16').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree15').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv15').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv15').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree14').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv14').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv14').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree13').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv13').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv13').style.display = 'none';
    }
	if (document.getElementById('dataAnotherThree12').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv12').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv12').style.display = 'none';
    }
	if (document.getElementById('dataAnotherThree11').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv11').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv11').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree21').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv21').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv21').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree22').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv22').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv22').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree23').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv23').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv23').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnotherThree24').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv24').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv24').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree25').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv25').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv25').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree26').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv26').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv26').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree27').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv27').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv27').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherThree28').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv28').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv28').style.display = 'none';
    }
	if (document.getElementById('dataAnotherThree48').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv48').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherThreeDiv48').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherThree47').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv47').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv47').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherThree46').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv46').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv46').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree45').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv45').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv45').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree44').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv44').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv44').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree43').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv43').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv43').style.display = 'none';
    }
	if (document.getElementById('dataAnotherThree42').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv42').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv42').style.display = 'none';
    }
	if (document.getElementById('dataAnotherThree41').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv41').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv41').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree31').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv31').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv31').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree32').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv32').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv32').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree33').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv33').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv33').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnotherThree34').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv34').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv34').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree35').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv35').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv35').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree36').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv36').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv36').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherThree37').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv37').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv37').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherThree38').checked==true)
    {
		document.getElementById('dataAnotherThreeDiv38').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherThreeDiv38').style.display = 'none';
    }
	
	
return true;
}


function dataAnotherTwo() {
	
	if (document.getElementById('dataAnotherTwo18').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv18').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherTwoDiv18').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherTwo17').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv17').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv17').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherTwo16').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv16').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv16').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo15').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv15').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv15').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo14').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv14').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv14').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo13').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv13').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv13').style.display = 'none';
    }
	if (document.getElementById('dataAnotherTwo12').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv12').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv12').style.display = 'none';
    }
	if (document.getElementById('dataAnotherTwo11').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv11').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv11').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo21').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv21').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv21').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo22').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv22').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv22').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo23').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv23').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv23').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnotherTwo24').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv24').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv24').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo25').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv25').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv25').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo26').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv26').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv26').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo27').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv27').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv27').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherTwo28').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv28').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv28').style.display = 'none';
    }
	if (document.getElementById('dataAnotherTwo48').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv48').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherTwoDiv48').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherTwo47').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv47').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv47').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherTwo46').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv46').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv46').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo45').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv45').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv45').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo44').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv44').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv44').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo43').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv43').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv43').style.display = 'none';
    }
	if (document.getElementById('dataAnotherTwo42').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv42').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv42').style.display = 'none';
    }
	if (document.getElementById('dataAnotherTwo41').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv41').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv41').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo31').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv31').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv31').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo32').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv32').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv32').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo33').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv33').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv33').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnotherTwo34').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv34').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv34').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo35').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv35').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv35').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo36').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv36').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv36').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherTwo37').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv37').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv37').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherTwo38').checked==true)
    {
		document.getElementById('dataAnotherTwoDiv38').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherTwoDiv38').style.display = 'none';
    }
	
	
return true;
}



function dataAnotherOne() {
	
	if (document.getElementById('dataAnotherOne18').checked==true)
    {
		document.getElementById('dataAnotherOneDiv18').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherOneDiv18').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherOne17').checked==true)
    {
		document.getElementById('dataAnotherOneDiv17').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv17').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherOne16').checked==true)
    {
		document.getElementById('dataAnotherOneDiv16').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv16').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne15').checked==true)
    {
		document.getElementById('dataAnotherOneDiv15').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv15').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne14').checked==true)
    {
		document.getElementById('dataAnotherOneDiv14').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv14').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne13').checked==true)
    {
		document.getElementById('dataAnotherOneDiv13').style.display = 'inline';
    }
	else{
    	document.getElementById('dataAnotherOneDiv13').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne12').checked==true)
    {
		document.getElementById('dataAnotherOneDiv12').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherOneDiv12').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne11').checked==true)
    {
		document.getElementById('dataAnotherOneDiv11').style.display = 'inline';
    }else{
    	document.getElementById('dataAnotherOneDiv11').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne21').checked==true)
    {
		document.getElementById('dataAnotherOneDiv21').style.display = 'inline';
    }
	else{
    	document.getElementById('dataAnotherOneDiv21').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne22').checked==true)
    {
		document.getElementById('dataAnotherOneDiv22').style.display = 'inline';
    }else{
    	document.getElementById('dataAnotherOneDiv22').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne23').checked==true)
    {
		document.getElementById('dataAnotherOneDiv23').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv23').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnotherOne24').checked==true)
    {
		document.getElementById('dataAnotherOneDiv24').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv24').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne25').checked==true)
    {
		document.getElementById('dataAnotherOneDiv25').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv25').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne26').checked==true)
    {
		document.getElementById('dataAnotherOneDiv26').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv26').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne27').checked==true)
    {
		document.getElementById('dataAnotherOneDiv27').style.display = 'inline';
    }
	else{
    	document.getElementById('dataAnotherOneDiv27').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherOne28').checked==true)
    {
		document.getElementById('dataAnotherOneDiv28').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv28').style.display = 'none';
    }
	if (document.getElementById('dataAnotherOne48').checked==true)
    {
		document.getElementById('dataAnotherOneDiv48').style.display = 'inline';

    }else{
    	document.getElementById('dataAnotherOneDiv48').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherOne47').checked==true)
    {
		document.getElementById('dataAnotherOneDiv47').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv47').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherOne46').checked==true)
    {
		document.getElementById('dataAnotherOneDiv46').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv46').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne45').checked==true)
    {
		document.getElementById('dataAnotherOneDiv45').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv45').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne44').checked==true)
    {
		document.getElementById('dataAnotherOneDiv44').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv44').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne43').checked==true)
    {
		document.getElementById('dataAnotherOneDiv43').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv43').style.display = 'none';
    }
	if (document.getElementById('dataAnotherOne42').checked==true)
    {
		document.getElementById('dataAnotherOneDiv42').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv42').style.display = 'none';
    }
	if (document.getElementById('dataAnotherOne41').checked==true)
    {
		document.getElementById('dataAnotherOneDiv41').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv41').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne31').checked==true)
    {
		document.getElementById('dataAnotherOneDiv31').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv31').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne32').checked==true)
    {
		document.getElementById('dataAnotherOneDiv32').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv32').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne33').checked==true)
    {
		document.getElementById('dataAnotherOneDiv33').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv33').style.display = 'none';
    }
	
	
	
	if (document.getElementById('dataAnotherOne34').checked==true)
    {
		document.getElementById('dataAnotherOneDiv34').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv34').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne35').checked==true)
    {
		document.getElementById('dataAnotherOneDiv35').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv35').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne36').checked==true)
    {
		document.getElementById('dataAnotherOneDiv36').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv36').style.display = 'none';
    }
	
	
	if (document.getElementById('dataAnotherOne37').checked==true)
    {
		document.getElementById('dataAnotherOneDiv37').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv37').style.display = 'none';
    }
	
	if (document.getElementById('dataAnotherOne38').checked==true)
    {
		document.getElementById('dataAnotherOneDiv38').style.display = 'inline';

    }
	else{
    	document.getElementById('dataAnotherOneDiv38').style.display = 'none';
    }
	
	
return true;
}


function dataAge(val,id)
{
	if(val!= ""){
	if (val >= 1 && val<100){
		
				return true;        
		}else{
			alert("The age must be a number more 1");
			document.getElementById(id).focus;
			document.getElementById(id).value = "";
			return false;
		}
	return true;
	}
	
}
function displayDentalVisitValue(val)
{
	
	if(val=="No")
	{
		document.getElementById("dentalvisitNoDiv").style.display = 'block';
		}
	else{
		document.getElementById("dentalvisitNoDiv").style.display = 'none';
	}

}

function displayDentalExperienceValue(val)
{
	
	if(val=="Yes")
	{
		document.getElementById("dentalExperienceYesDiv").style.display = 'block';
		}
	else{
		document.getElementById("dentalExperienceYesDiv").style.display = 'none';
	}

}

function displayInjuryToTeethValue(val)
{
	
	if(val=="Yes")
	{
		document.getElementById("injuryToTeethYesDiv").style.display = 'block';
		}
	else{
		document.getElementById("injuryToTeethYesDiv").style.display = 'none';
	}

}


function checkAllvalues(){
	
	if(document.getElementById('dentureSecondarySelectAll').checked){
	for(var i=11; i <=18;i++){
		document.getElementById('data'+i).checked=true;
	}
	for(var i=21; i <=28;i++){
		document.getElementById('data'+i).checked=true;
	}
	
	for(var i=41; i <=48;i++){
		document.getElementById('data'+i).checked=true;
	}
	for(var i=31; i <=38;i++){
		document.getElementById('data'+i).checked=true;
	}
	
	}	else{
		
		for(var i=11; i <=18;i++){
			if(document.getElementById('data'+i).checked)
			document.getElementById('data'+i).checked=false;
		}
		for(var i=21; i <=28;i++){
			if(document.getElementById('data'+i).checked)
			document.getElementById('data'+i).checked=false;
		}
		
		for(var i=41; i <=48;i++){
			if(document.getElementById('data'+i).checked)
			document.getElementById('data'+i).checked=false;
		}
		for(var i=31; i <=38;i++){
			if(document.getElementById('data'+i).checked)
			document.getElementById('data'+i).checked=false;
		}
	}
}

function checkAllvaluesPrimary(){

	if(document.getElementById('denturePrimarySelectAll').checked){
		for(var i=51; i <= 55;i++){
			document.getElementById('data'+i).checked=true;
		}
		for(var i=61; i <= 65;i++){
			document.getElementById('data'+i).checked=true;
		}
		
		for(var i=81; i <= 85;i++){
			document.getElementById('data'+i).checked=true;
		}
		for(var i=71; i <=75;i++){
			document.getElementById('data'+i).checked=true;
		}
		
		}	else{
			
			for(var i=51; i <=55;i++){
				if(document.getElementById('data'+i).checked)
				document.getElementById('data'+i).checked=false;
			}
			for(var i=61; i <=65;i++){
				if(document.getElementById('data'+i).checked)
				document.getElementById('data'+i).checked=false;
			}
			
			for(var i=81; i <=85;i++){
				if(document.getElementById('data'+i).checked)
				document.getElementById('data'+i).checked=false;
			}
			for(var i=71; i <=75;i++){
				if(document.getElementById('data'+i).checked)
				document.getElementById('data'+i).checked=false;
			}
		}
	
}
