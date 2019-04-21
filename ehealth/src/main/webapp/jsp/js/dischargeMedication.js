function addRowTreatmentDM(){
	var tbl = document.getElementById('DMgridtreatment');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('DMhdbtreatment');
	iteration = parseInt(hdb.value)+1;
	hdb.value=iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name='DMitemRadiotreatment'+iteration;
	e1.id='DMitemRadiotreatment'+iteration;
	e1.className='radioCheck';
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='DMnomenclaturetreatment'+iteration;
	e1.id='DMnomenclaturetreatment'+iteration;
	e1.onblur=function(){validatePrescriptionAutocompleteDM('opmain',this.value,iteration );populatePVMSDM(this.value,iteration); displayAuDM(this.value,iteration);checkForAllergyDM(this.value,iteration);/* checkItem(iteration),*/};
	e1.size='30'
	 e1.onblur=function(){
		populatePVMSDM(this.value,iteration); 
	     displayAuDM(this.value,iteration);
	     checkForAllergyDM(this.value,iteration);
	     checkIPItemDM(iteration);
	     validatePrescriptionAutocompleteDM('opmain',this.value,iteration );
	}; 

	cellRight1.appendChild(e1);
	var newdiv = document.createElement('div');
	newdiv.setAttribute('id', 'DMac2updatestreatment'+iteration);
	newdiv.style.display = 'none';
	newdiv.className = "autocomplete";
	cellRight1.appendChild(newdiv);
	new Ajax.Autocompleter('DMnomenclaturetreatment'+iteration,'DMac2updatestreatment'+iteration,'opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=DMnomenclaturetreatment'+iteration+'&countertreatment='+iteration});

	var cellRight1 = row.insertCell(2);
	
	var e1 = document.createElement('input');
	e1.type = 'hidden';
	e1.name='DMpvmsNotreatment'+iteration;
	e1.id='DMpvmsNotreatment'+iteration;
	cellRight1.appendChild(e1);
	
	
	 var e1 = document.createElement('input');
	 e1.type = 'hidden';
	 e1.name='DMactualDispensingQty'+iteration;
	 e1.id='DMactualDispensingQty'+iteration;
	 cellRight1.appendChild(e1);
	  
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='DMdosagetreatment'+iteration;
	e1.id='DMdosagetreatment'+iteration;
	e1.size='2';
	e1.onblur=function()
	{
		fillTotalForTreatmentDM(iteration);
	};
	/* e1.className='small'; */
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(3);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='DMunittreatment'+iteration;
	e1.id='DMunittreatment'+iteration;
	e1.size='2';
	/* e1.className='small'; */
	e1.readOnly='readOnly';
	cellRight1.appendChild(e1);
	

	var cellRight1 = row.insertCell(4);
	var e1 = document.createElement('Select');
	e1.name='DMfrequencytreatment'+iteration;
	e1.id='DMfrequencytreatment'+iteration;
	//e1.className='smallest';//changed by govind 24-12-2016
	e1.options[0] = new Option('Select', '0');
	 for(var i = 0;i<frequencyArray.length;i++ ){
	e1.options[frequencyArray[i][0]] = new Option(frequencyArray[i][1],frequencyArray[i][0]);
	}
	//e1.onblur=function()//changed by govind 24-12-2016
	 e1.onchange=function()
		{
		 getFrequencyValueDM(this.value,iteration);fillValueFromFrequencyDM(this.value,iteration);displaySOSQtyDM(this.value,iteration);
		 fillTotalForTreatmentDM(iteration);
		}; 
	cellRight1.appendChild(e1);
	var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='DMsosQty'+iteration;
	  e21.id='DMsosQty'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight1.appendChild(e21);
	  
	  var e21 = document.createElement('input');
	  e21.type = 'hidden';
	  e21.name='DMfrequencyValue'+iteration;
	  e21.id='DMfrequencyValue'+iteration;
	  e21.size='5';
	  e21.setAttribute('tabindex','1');
	  cellRight1.appendChild(e21);

	var cellRight1 = row.insertCell(5);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='DMnoOfDaystreatment'+iteration;
	e1.id='DMnoOfDaystreatment'+iteration;
	e1.size='3';
	/*e1.onblur=function()//changed by govind 24-12-2016
	{
		fillTotalForTreatmentDM(iteration);
	};*/
	e1.onblur=function()
	{
		fillValueFromFrequencyDM(this.value,iteration);
		fillTotalForTreatmentDM(iteration);
	};
	e1.oninput=function()
	{
		fillValueFromFrequencyDM(this.value,iteration);
		fillTotalForTreatmentDM(iteration);
	};//changed by govind 24-12-2016 end
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(6);
	var e1 = document.createElement('Select');
	e1.name='DMinstructiontreatment'+iteration;
	e1.id='DMinstructiontreatment'+iteration;
	//e1.className='smallest';
	e1.options[0] = new Option('Select', '0');
	 for(var i = 0;i<instructionArray.length;i++ ){
			e1.options[instructionArray[i][0]] = new Option(instructionArray[i][1],instructionArray[i][0]);
			}
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(7);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.size = '15';
	e1.name='DMspslinstructiontreatment'+iteration;
	e1.id='DMspslinstructiontreatment'+iteration;
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(8);
	var e1 = document.createElement('Select');
	e1.name='DMroutetreatment'+iteration;
	e1.id='DMroutetreatment'+iteration;
	//e1.className='smallest';
	e1.options[0] = new Option('Select', '0');
	 for(var i = 0;i<roteArray.length;i++ ){
			e1.options[roteArray[i][0]] = new Option(roteArray[i][1],roteArray[i][0]);
			}
	cellRight1.appendChild(e1);

	var cellRight1 = row.insertCell(9);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='DMtotaltreatment'+iteration;
	e1.id='DMtotaltreatment'+iteration;
	e1.size='2';
	e1.onblur=function()
	{
		fillTotalForTreatmentDM(iteration);
	};
	cellRight1.appendChild(e1);


	}

function removeRowTreatmentDM()
{
  var tbl = document.getElementById('DMgridtreatment');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('DMhdbtreatment');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  for(var i=1;i<=iteration;i++)
	  {
	  if(document.getElementById("DMitemRadiotreatment"+i)!=null && (typeof  document.getElementById("DMitemRadiotreatment"+i).checked)!='undefined' && document.getElementById("DMitemRadiotreatment"+i).checked )
		  {
		  totalSelected=totalSelected+1;
		  }
	  }
      if(totalSelected==0)
	  {
	  alert('Please select atleast 1 row to delete');
	  }
      else  if(lastRow==2 || lastRow==(totalSelected+1))
	  {
    	  alert('You can not delete all Row.');
      }
      else if (lastRow > 2){
    	  for(var i=1;i<=iteration;i++)
    	  {
		  if(document.getElementById("DMitemRadiotreatment"+i)!=null && (typeof  document.getElementById("DMitemRadiotreatment"+i).checked)!='undefined' && document.getElementById("DMitemRadiotreatment"+i).checked )
    		  {
    		  var deleteRow= document.getElementById("DMitemRadiotreatment"+i).parentNode.parentNode;
    		  document.getElementById("DMitemRadiotreatment"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
    		  }
    	  }
    	 /*  for(var i=1;i<document.getElementById('DMgrid').rows.length;i++)
    		  {
    		  document.getElementById('DMgrid').rows[i].cells[0].innerHTML=i;
    		  } */
  }
}

function populatePVMSDM(val,inc){
	if(val != "")
	{
	    var index1 = val.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvmsNo = val.substring(index1,index2);
	    var indexForBrandName=indexForBrandName--;
	    var brandName=val.substring(0,indexForBrandName);

	  if(pvmsNo == "")
	  {
	   	document.getElementById('DMnomenclaturetreatment'+inc).value="";
	    document.getElementById('DMpvmsNotreatment'+inc).value="";
	    document.getElementById('DMdosagetreatment'+inc).value="";
	      document.getElementById('DMnoOfDaystreatment'+inc).value="";
	      document.getElementById('DMunittreatment'+inc).value="";
	   return;
	   }
	   else
		   {
	      document.getElementById('DMpvmsNotreatment'+inc).value=pvmsNo;
	      document.getElementById('DMdosagetreatment'+inc).value=1;
	      document.getElementById('DMnoOfDaystreatment'+inc).value=1;
	      
	      new Ajax.Request('ipd?method=updateItemUnit&pvmsNo='+pvmsNo+'&'+csrfTokenName+'='+csrfTokenValue, {
	    	  onSuccess: function(response) {
	    	      if(response.responseText.trim()!='')
	    	    	  {
	    	    	  var str=response.responseText.trim().split("###");
	    	    	  document.getElementById('DMunittreatment'+inc).value=str[0];
	    	    	  }
	    	  }
	    	});
	 }
	}
	else
		{
		document.getElementById('DMnomenclaturetreatment'+inc).value="";
	    document.getElementById('DMpvmsNotreatment'+inc).value="";
	    document.getElementById('DMdosagetreatment'+inc).value="";
	      document.getElementById('DMnoOfDaystreatment'+inc).value="";
	      document.getElementById('DMunittreatment'+inc).value="";
	      }
}

function  fillValueDM(value,inc){
	  var freq=document.getElementById('DMfrequency'+inc).value;
	  var dosage=document.getElementById('DMdosage'+inc).value;
	  //added by amit das on 19-11-2016
		var mixable = document.getElementById('DMmixable' + inc).value;
		var mixtureUnit = document.getElementById('DMmixtureUnit' + inc).value;
		var mixtureQuantity = document.getElementById('DMmixtureQuantity' + inc).value;
		var dispenseQty = document.getElementById('DMactualDispensingQty' + inc).value;
		// condition added by amit das on 19-11-2016 
		if(mixable=='Y'){
			var finalQty;
			// var solutionMixAmount =  parseFloat(diluteLiquidQuantity) + parseFloat(dispenseQty);
			actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity)) * parseFloat(noOfDays*value*dosage);
			if(actualFinalQty != '0.00'){
				finalQty = parseFloat(actualFinalQty) / parseFloat(dispenseQty);
			}
			document.getElementById('DMtotal' + inc).value = total;
			if(document.getElementById('DMactualTotalAfterMix' + inc)!=null){
			document.getElementById('DMactualTotalAfterMix' + inc).value = finalQty;
			}
			
		} else {
	  			document.getElementById('DMtotal'+inc).value=freq*value*dosage;
		}
	 }

function displayAuDM(val,inc){
    if(val != "")
    {
        var index1 = val.lastIndexOf("[");
        var indexForBrandName=index1;
        var index2 = val.lastIndexOf("]");
        index1++;
        var pvmsNo = val.substring(index1,index2);
        var indexForBrandName=indexForBrandName--;
        var brandName=val.substring(0,indexForBrandName);
	      if(pvmsNo == "")
	      {
	        document.getElementById('DMnomenclaturetreatment'+inc).value="";
	        document.getElementById('DMpvmsNotreatment'+inc).value="";
	       return;
	       }
	       else
	            var xmlHttp;
	              try {
	                // Firefox, Opera 8.0+, Safari
	                xmlHttp=new XMLHttpRequest();
	              }catch (e){
	                // Internet Explorer
	                try{
	                  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	                }catch (e){
	                        alert(e)
	                  try{
	                    xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	                  }catch (e){
	                    alert("Your browser does not support AJAX!");
	                    return false;
	                  }
	                 }
	               }
	            
	                xmlHttp.onreadystatechange=function()
	                {
	                  if(xmlHttp.readyState==4){
	                          var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
	                          for (loop = 0; loop < items.childNodes.length; loop++) {
	                                   var item = items.childNodes[loop];
	                                
	                            var au  = item.getElementsByTagName("au")[0];
	                            var actualDispensingQty = item.getElementsByTagName("actualDispensingQty")[0];
	                            var stock = item.getElementsByTagName("stock")[0];
	                            
	                         // added by amit das on 19-11-2016
	        					var mixable = item.getElementsByTagName("mixable")[0];
	        					var mixtureQuantity = item.getElementsByTagName("mixtureQuantity")[0];
	        					var mixtureUnit = item.getElementsByTagName("mixtureUnit")[0];
	        					var tapered = item.getElementsByTagName("tapered")[0];
	        					
	                            
	                            if(document.getElementById('DMau'+inc) && au.childNodes[0] != undefined ){
	                                    document.getElementById('DMau'+inc).value = au.childNodes[0].nodeValue;
	                            }
	                         /*    if(document.getElementById('DMclosingStock'+inc) && stock.childNodes[0] != undefined){
	                                    document.getElementById('DMclosingStock'+inc).value = stock.childNodes[0].nodeValue;
	                                    if(stock.childNodes[0].nodeValue == 0){
	                                       alert("Stock is not available...");
	                                    }
	                            }else{
	                            } */
	                            if(document.getElementById('DMactualDispensingQty'+inc)){
	                            if(actualDispensingQty.childNodes[0]!=undefined){
	                                    document.getElementById('DMactualDispensingQty'+inc).value = actualDispensingQty.childNodes[0].nodeValue;
	                            }else{
	                                    document.getElementById('DMactualDispensingQty'+inc).value = 0;
	
	                            }
	                            }
	                            var dangerousDrug = item.getElementsByTagName("dangerousDrug")[0];
	                            if(dangerousDrug.childNodes[0]!=undefined && dangerousDrug.childNodes[0].nodeValue == 'y'){
	                                    alert("This drug is dangerous.");
	                            }
	                            
	                        	// added by amit das on 19-11-2016
	        					if (document.getElementById('DMmixable' + inc)
	        							&& mixable.childNodes[0] != undefined) {
	        						document.getElementById('DMmixable' + inc).value = mixable.childNodes[0].nodeValue;
	        					}
	        					// added by amit das on 19-11-2016
	        					if (document.getElementById('DMmixtureQuantity' + inc)
	        							&& mixtureQuantity.childNodes[0] != undefined) {
	        						document.getElementById('DMmixtureQuantity' + inc).value = mixtureQuantity.childNodes[0].nodeValue;
	        					}
	        					
	        					// added by amit das on 19-11-2016
	        					if (document.getElementById('DMmixtureUnit' + inc)
	        							&& mixtureUnit.childNodes[0] != undefined) {
	        						document.getElementById('DMmixtureUnit' + inc).value = mixtureUnit.childNodes[0].nodeValue;
	        					}
	        				
	        					if (document.getElementById('tapered' + inc)
	        							&& tapered.childNodes[0] != undefined) {
	        						document.getElementById('tapered' + inc).value = tapered.childNodes[0].nodeValue;
	        					}
	                          }
	                  }
	                 }
	                var url="/hms/hms/opd?method=displayAU&pvmsNo="+pvmsNo;
		    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	                xmlHttp.open("GET",url,true);
	                xmlHttp.setRequestHeader("Content-Type", "text/xml");
	                xmlHttp.send(null);
	            }
}

function checkForAllergyDM(val,inc){
	//alert(val+"<<<-------val======inc------>>"+inc);
	var visitId=document.getElementById('inpatientId').value; 
	//alert("visitId---->>>>"+visitId);
	var id;
	if(val!=""){

		  var xmlHttp;
		  try {
		    // Firefox, Opera 8.0+, Safari
		    xmlHttp=new XMLHttpRequest();
		  }catch (e){
		    // Internet Explorer
		    try{
		      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		    }catch (e){
		    	alert(e)
		      try{
		        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }catch (e){
		        alert("Your browser does not support AJAX!");
		        return false;
		      }
		     }
		   }

		xmlHttp.onreadystatechange=function()
		{
		  if(xmlHttp.readyState==4){
			var b="false";
		  	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		  	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		         icdString  = item.getElementsByTagName('allergyString')[0];
		      //  alert("icdString"+icdString);
		         b =icdString.childNodes[0].nodeValue
		      // alert("b-->>"+b);
		       
		        // var val=document.getElementById('DMicd').value;
		         var index1 = val.lastIndexOf("[");
				    var index2 = val.lastIndexOf("]");
				    index1++;
				    id = val.substring(index1,index2);
				  //  alert("id------>>>"+id);
				    if(id ==""){
					  return;
					}
				  
				    if(b=='true'){
						   alert("Patient is allergic to this message!!");
						   document.getElementById('DMnomenclaturetreatment'+inc).value="";
					   }
				    }
					
		  }
		  }
		//var url="/hms/hms/opd?method=getIcdWithIcdCode&icdCode="+encodeURIComponent(icdCode)
		  	
		 
				var url="/hms/hms/ipd?method=getItemForAllergy&val="+val+"&visitId="+visitId;
	    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
		xmlHttp.open("GET",url,true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);

			
	}
}

function checkIPItemDM(cnt) {
	//alert("govind checkIPItem");
	var tbl = document.getElementById('DMgridtreatment');
	var lastRow = tbl.rows.length;
	var iteration = lastRow - 1;

	// var pvmsNo=document.getElementById("DMpvmsNo"+iteration).value
	//var visitId = document.getElementById("DMvisitId").value
	var nomenclature = document.getElementById("DMnomenclaturetreatment" + cnt).value;
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
							$("#DMnomenclaturetreatment" + cnt).css({
								'color' : 'red',
							});
						}else{
							$("#DMnomenclaturetreatment" + cnt).css({
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

function  fillValueFromFrequencyDM(inc){
	   var noOfDays=document.getElementById('DMnoOfDays'+inc).value;
	  var dosage=document.getElementById('DMdosage'+inc).value;
	  var frequency=document.getElementById('DMfrequencyValue'+inc).value;//changed by govind 24-12-2016
	    //added by amit das on 19-11-2016
		var mixable = document.getElementById('DMmixable' + inc).value;
		var mixtureUnit = document.getElementById('DMmixtureUnit' + inc).value;
		var mixtureQuantity = document.getElementById('DMmixtureQuantity' + inc).value;
			
		var dispenseQty = document.getElementById('DMactualDispensingQty' + inc).value;
		// condition added by amit das on 19-11-2016 
		var total = noOfDays*frequency*dosage;
		if(mixable=='Y'){
			var finalQty;
			//var solutionMixAmount =  parseFloat(diluteLiquidQuantity) + parseFloat(dispenseQty);
			actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity)) * parseFloat(total);
			if(actualFinalQty != '0.00'){
				finalQty = parseFloat(actualFinalQty) / parseFloat(dispenseQty);
			}
			document.getElementById('DMtotal' + inc).value = total;
			document.getElementById('DMactualTotalAfterMix' + inc).value = finalQty;
			
		} else {
	  			document.getElementById('DMtotal'+inc).value=noOfDays*value*dosage;
		}
	 }

function checkItem(cnt) {
	var tbl = document.getElementById('DMgrid');
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
								'font-size' : '125%'
							});
							$("#nomenclaturepTab" + cnt).css({
								'color' : 'red',
								'font-size' : '125%'
							});
							$("#prescription_availableStatus" + cnt).val('y');
							$("#prescription_availableStatuspTab" + cnt).val(
									'y');
						} else {
							$("#nomenclature" + cnt).css({
								'color' : 'black',
								'font-size' : '125%'
							});
							$("#nomenclaturepTab" + cnt).css({
								'color' : 'black',
								'font-size' : '125%'
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


function  fillTotalForTreatmentDM(inc){
    if(!isNaN(document.getElementById('DMnoOfDaystreatment'+inc).value) 
    		&& !isNaN(document.getElementById('DMdosagetreatment'+inc).value)
    		&& !isNaN(document.getElementById('DMfrequencytreatment'+inc).value) 
    		&& document.getElementById('DMfrequencytreatment'+inc).value>0)
    	{
    	
    	// added by amit das on 19-11-2016
    	if(document.getElementById('DMmixable' + inc)!=null){
    		var mixable = document.getElementById('DMmixable' + inc).value;
    	}
       if(document.getElementById('DMmixtureUnit' + inc)!=null){
    		var mixtureUnit = document.getElementById('DMmixtureUnit' + inc).value;
    	}
		if(document.getElementById('DMmixtureQuantity' + inc)!=null){
			var mixtureQuantity = document.getElementById('DMmixtureQuantity' + inc).value;
		}
		if(document.getElementById('DMactualDispensingQty' + inc)!=null){
			var dispenseQty = document.getElementById('DMactualDispensingQty' + inc).value;
		}
		
    	var selectedFrequency=0;
    		 for(var i = 0;i<frequencyArray.length;i++ ){
    			 if(frequencyArray[i][0]==document.getElementById('DMfrequencytreatment'+inc).value)
    				 {
    				 selectedFrequency=frequencyArray[i][2];
    				 break;
    				 }
    			}
    		 if(selectedFrequency!=0)
    			 {
    			// condition added by amit das on 19-11-2016 
 				if(mixable=='Y'){
 				//	var solutionMixAmount =  parseFloat(diluteLiquidQuantity) + parseFloat(dispenseQty);
 					actualFinalQty = (parseFloat(dispenseQty) / parseFloat(mixtureQuantity)) * parseFloat(document.getElementById('DMnoOfDaystreatment'+inc).value*document.getElementById('DMdosagetreatment'+inc).value*selectedFrequency);
 					if(actualFinalQty != '0.00'){
 						finalQty = parseFloat(actualFinalQty) / parseFloat(dispenseQty);
 					}
 					document.getElementById('DMtotaltreatment' + inc).value = document.getElementById('DMnoOfDaystreatment'+inc).value*document.getElementById('DMdosagetreatment'+inc).value*selectedFrequency;
 					document.getElementById('DMactualTotalAfterMix' + inc).value = finalQty;
 					
 				} else {
    			 document.getElementById('DMtotaltreatment'+inc).value=Math.round(document.getElementById('DMnoOfDaystreatment'+inc).value*document.getElementById('DMdosagetreatment'+inc).value*selectedFrequency); 
 				} 
 				}
    	}
 }

function  fillValueFromFrequencyDM(value,inc){
 	  var dosage = document.getElementById('DMdosagetreatment'+inc).value;
	  var noOfDays=document.getElementById('DMnoOfDaystreatment'+inc).value
	  var freq=document.getElementById('DMfrequencyValue'+inc).value
	  document.getElementById('DMtotaltreatment'+inc).value=Math.round(noOfDays*freq*dosage);
	  var dispenseQty = document.getElementById('DMactualDispensingQty'+inc).value;
 	  var sosQty = document.getElementById('DMsosQty'+inc).value;
	  var total = freq*noOfDays*dosage;
	  var finalQty;
	  if(document.getElementById('DMfrequencytreatment'+inc).value != 13 ){
	  if(document.getElementById('DMactualDispensingQty'+inc).value != 0){
		  var totalQty = (parseFloat(total)/parseFloat(dispenseQty)).toFixed(2)
		  if(totalQty != '0.00'){
			  finalQty = Math.ceil(totalQty);
		  }
		  document.getElementById('DMtotaltreatment'+inc).value=Math.round(finalQty);
		  document.getElementById('DMactualTotalAfterMix' + inc).value = finalQty;
		 }else{
			  document.getElementById('DMtotaltreatment'+inc).value=Math.round(noOfDays*freq*dosage);
		  }
	  }else{
		  if(document.getElementById('DMactualDispensingQty'+inc).value != 0){
			  var totalQty = (parseFloat(freq*sosQty*dosage)/parseFloat(dispenseQty)).toFixed(2)
			  if(totalQty != '0.00'){
				  finalQty = Math.ceil(totalQty);
			  }
			  document.getElementById('DMtotaltreatment'+inc).value=Math.round(finalQty);
		
			 }else{
				  document.getElementById('DMtotaltreatment'+inc).value=Math.round(sosQty*freq*dosage);
			  }
	  }
	 } 

function displaySOSQtyDM(val,inc){
	if(val == '13'){
		document.getElementById('DMsosQty'+inc).style.display = 'block';
		document.getElementById('DMnoOfDaystreatment'+inc).disabled = true;
	 }else{
	  document.getElementById('DMsosQty'+inc).style.display  = 'none';
	  document.getElementById('DMnoOfDaystreatment'+inc).disabled = false;
	 }
	}

function validatePrescriptionAutocompleteDM(flag, strValue, inc) {
	if (flag == 'opmain') {
		var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		var id = strValue.substring(index1, index2);
		var count = document.getElementById('DMhdbtreatment').value;
		if (id == "") {
			document.getElementById('DMnomenclaturetreatment' + inc).value = "";
			return;
		}
		for (var i = 0; i < count; i++) {
			if (document.getElementById('DMnomenclaturetreatment' + i) != null
					&& document.getElementById('DMnomenclaturetreatment' + i).value == strValue
					&& i != inc) {
				if(document.getElementById('tapered' + i)!=null && document.getElementById('tapered' + i).value!='y' ){
					alert('This Prescription is already selected.');
					document.getElementById('DMnomenclaturetreatment' + inc).value = "";
					return false;
				}
			}
		}
		return true;
	} 
	if (flag == 'opmainTM') {
		var index1 = strValue.lastIndexOf("[");
		var index2 = strValue.lastIndexOf("]");
		index1++;
		var id = strValue.substring(index1, index2);
		var count = document.getElementById('hdbtreatment').value;
		if (id == "") {
			document.getElementById('nomenclaturetreatment' + inc).value = "";
			return;
		}
		for (var i = 0; i < count; i++) {
			if (document.getElementById('nomenclaturetreatment' + i) != null
					&& document.getElementById('nomenclaturetreatment' + i).value == strValue
					&& i != inc) {
				if(document.getElementById('tapered' + i)!=null && document.getElementById('tapered' + i).value!='y' ){
				alert('This Prescription is already selected.');
				document.getElementById('nomenclaturetreatment' + inc).value = "";
				return false;
				}
			}
		}
		return true;
	} 

}
function getIPPrescriptionDetails() {
	inpatientId=document.getElementById('inpatientId').value;
	var url = "/hms/hms/ipd?method=getIPPrescriptionDetails&inpatientId="
			+ inpatientId + "&" + csrfTokenName + "="
			+ csrfTokenValue;
	newwindow = window.open(url, 'name', 'height=500,width=800,status=1');
	return false;

}