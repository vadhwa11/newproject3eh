function checkForViewSurveys() {
	 	var userType= document.getElementById("userType").value; 
		var districtId= document.getElementById("districtId").value;
		var fromDate= document.getElementById("fromDateId").value;
		var toDate= document.getElementById("toDateId").value;
		var instName= document.getElementById("Institute").value;
		var instType= document.getElementById("instType").value;
		
		var id;
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
					var dupl1 = item.getElementsByTagName('alreadyIssued1')[1];
					b = dupl.childNodes[0].nodeValue;
					b1 = dupl1.childNodes[0].nodeValue;
					 document.getElementById('memeberId').value=b;
					 document.getElementById('houseId').value=b1;
				}
			}
		}
				var url = "/hms/hms/pubHealth?method=showDashboardSurveyCount&userType="+userType +"&districtId="+ districtId + 
				"&fromDate=" + fromDate + "&toDate=" + toDate + "&instName=" + instName + "&instType=" + instType +  "&" + csrfTokenName + "="+ csrfTokenValue;
		
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
}


function checkSurveyForYearAndMonth() {
		var districtId= document.getElementById("district").value;
		var fromDate= document.getElementById("fromDate").value;
		var toDate= document.getElementById("toDate").value;
		var instType= document.getElementById("instType").value;
		var healthBlockId= document.getElementById("healthBlockId").value;
		var ListOfCenterId= document.getElementById("ListOfCenterId").value; 
		var chcphc= document.getElementById("chcphc").value;
		var base= document.getElementById("base").value;
		var instituteType = document.getElementById("instituteType").value;
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
				var items = xmlHttp.responseXML.getElementsByTagName('items1')[0];
				for (loop = 0; loop < items.childNodes.length; loop++) {
					var item = items.childNodes[loop];
					var dupl = item.getElementsByTagName('alreadyIssued2')[0];
					var dupl1 = item.getElementsByTagName('alreadyIssued2')[1];
					var dupl2 = item.getElementsByTagName('alreadyIssued2')[2];
					var dupl3 = item.getElementsByTagName('alreadyIssued2')[3];
					var dupl4 = item.getElementsByTagName('alreadyIssued2')[4];
					var dupl5 = item.getElementsByTagName('alreadyIssued2')[5];
					var dupl6 = item.getElementsByTagName('alreadyIssued2')[6];
					var dupl7 = item.getElementsByTagName('alreadyIssued2')[7];
					var dupl8 = item.getElementsByTagName('alreadyIssued2')[8];
					var dupl9 = item.getElementsByTagName('alreadyIssued2')[9];
					var dupl10 = item.getElementsByTagName('alreadyIssued2')[10];
					var dupl11= item.getElementsByTagName('alreadyIssued2')[11];
					var dupl12= item.getElementsByTagName('alreadyIssued2')[12];
					/*var dupl13= item.getElementsByTagName('alreadyIssued2')[13];*/
					var dupl14= item.getElementsByTagName('alreadyIssued2')[14];
					var dupl15= item.getElementsByTagName('alreadyIssued2')[15];
					/*var dupl16= item.getElementsByTagName('alreadyIssued2')[16];
					var dupl17= item.getElementsByTagName('alreadyIssued2')[17];*/
					var dupl18= item.getElementsByTagName('alreadyIssued2')[18];
					var dupl19= item.getElementsByTagName('alreadyIssued2')[19];
					var dupl20= item.getElementsByTagName('alreadyIssued2')[20];
					
					var dupl21= item.getElementsByTagName('alreadyIssued2')[21];
					var dupl22= item.getElementsByTagName('alreadyIssued2')[22];
					var dupl23= item.getElementsByTagName('alreadyIssued2')[23];
					var dupl24= item.getElementsByTagName('alreadyIssued2')[24];
					var dupl25= item.getElementsByTagName('alreadyIssued2')[25];
					
					b = dupl.childNodes[0].nodeValue;
					b1 = dupl1.childNodes[0].nodeValue;
					b2 = dupl2.childNodes[0].nodeValue;
					b3 = dupl3.childNodes[0].nodeValue;
					if(dupl4.childNodes[0]!=null){
						b4 = dupl4.childNodes[0].nodeValue;
						if('null' !=b4){
							document.getElementById('remarks').value=b4;
						}else{
							document.getElementById('remarks').value='';
						}
						 
					}
					if(dupl5.childNodes[0]!=null){
						b5 = dupl5.childNodes[0].nodeValue;
						if('null' !=b5){
						document.getElementById('status').value=b5; 
						}else{
							document.getElementById('status').value='';
						}
					}
					if(dupl6.childNodes[0]!=null){
						b6 = dupl6.childNodes[0].nodeValue;
						if('null' !=b6){
						document.getElementById('publicHealthNurseId').value=b6; 
						}else{
							document.getElementById('publicHealthNurseId').value='';
						}
					}
					if(dupl7.childNodes[0]!=null){
						b7 = dupl7.childNodes[0].nodeValue;
						if('null' !=b7){
						document.getElementById('districtPublicHealthNurseId').value=b7; 
						}else{
							document.getElementById('districtPublicHealthNurseId').value='';
						}
					}
					if(dupl8.childNodes[0]!=null){
						b8 = dupl8.childNodes[0].nodeValue;
						if('null' !=b8){
						document.getElementById('publicHealthNurseSupervisorId').value=b8; 
						}else{
							document.getElementById('publicHealthNurseSupervisorId').value='';
						}
					}
					
					if(dupl9.childNodes[0]!=null){
						b9 = dupl9.childNodes[0].nodeValue;
						if('null' !=b9){
							 //document.getElementById('fromDateId').value=b9;	
						}else{
							//document.getElementById('fromDateId').value=0;		
						}
					}
					if(dupl10.childNodes[0]!=null){
						b10 = dupl10.childNodes[0].nodeValue;
						if( 'null' != b10){
							//document.getElementById('toDateId').value=b10;	
						}else{
							//document.getElementById('toDateId').value=0;	
						}
					}
					if(dupl11.childNodes[0]!=null &&dupl11.childNodes[0]!='null'){
						b11 = dupl11.childNodes[0].nodeValue;
						if( 'null' != b11){
							document.getElementById('targetIds').value=b11;	
						}else{
							document.getElementById('targetIds').value=0;	
						}
					}
					/*b11 = dupl11.childNodes[0].nodeValue;*/
					b12 = dupl12.childNodes[0].nodeValue;
					/*b13 = dupl13.childNodes[0].nodeValue;*/
					b14 = dupl14.childNodes[0].nodeValue;
					b15 = dupl15.childNodes[0].nodeValue;
					/*b16 = dupl16.childNodes[0].nodeValue;*/
					/*b17 = dupl17.childNodes[0].nodeValue;*/
					
					b20 = dupl20.childNodes[0].nodeValue;
					if ('null' != b) {
						 document.getElementById('monthlyhvId').value=b; 
					} else {
						 document.getElementById('monthlyhvId').value=''; 
					}if ('null' != b1) {
						 document.getElementById('hvcummulativeId').value=b1;   
					} else {
						 document.getElementById('hvcummulativeId').value='';   
					}if ('null' != b3) {
						document.getElementById('monthlyhstargetId').value=Math.round(b20/12); 
					} else {
						document.getElementById('monthlyhstargetId').value=''; 
					}if ('null' != b20) {
						 document.getElementById('annualhvisitedtargetId').value=b20; 
					} else {
						 document.getElementById('annualhvisitedtargetId').value=''; 
					}if ('null' != b3) {
						 document.getElementById('houseTargetId').value=b3; 
					} else {
						 document.getElementById('houseTargetId').value=''; 
					}/*if ('null' != b11) {
						document.getElementById('targetIds').value=b11;
					} else {
						document.getElementById('targetIds').value='';
					}*/if ('null' != b12) {
						 document.getElementById('memeberTargetId').value=b12;
					} else {
						 document.getElementById('memeberTargetId').value='';
					}/*if ('null' != b13) {
						 document.getElementById('monthlyMemberSurveyTargetId').value=b13;
					} else {
						 document.getElementById('monthlyMemberSurveyTargetId').value='';
					}*/if ('null' != b14) {
						 document.getElementById('houseId').value=b14;
					} else {
						 document.getElementById('houseId').value='';
					}if ('null' != b15) {
						 document.getElementById('memeberId').value=b15;
					} else {
						 document.getElementById('memeberId').value='';
					}
					 if( 'null'!=b14 && 'null'!=b3 &&  b14!=0 && b3!=0){
							var annuallyPercent = (b14/b3)*100;
							 var annuallyPercentFinal=Math.round(annuallyPercent);
							
							 document.getElementById('housePercentId').value =annuallyPercentFinal;
						 }else{
							
							 document.getElementById('housePercentId').value =0;
						 }
					 
					/*if( b!=null && b2!=null && 'null'!=b && 'null'!=b2 &&  b!=0 && b2!=0){
						var monthlyPercent = (b/b2)*100;
						 var monthlyPercentFinal=Math.round(monthlyPercent);
						 document.getElementById('monthlyhspercentId').value =monthlyPercentFinal;
						 }else{
						document.getElementById('monthlyhspercentId').value =0;
						 }*/
					
					if( b1!=null && b20!=null && 'null'!=b1 && 'null'!=b20 &&  b1!=0 && b20!=0){
						var monthlyPercent = (b1/b20)*100;
						 var finalPercentFinal=Math.round(monthlyPercent);
						 var monthlyPercent = Math.round(finalPercentFinal/12);
						 document.getElementById('hvmhspercentId').value = finalPercentFinal;
						 document.getElementById('monthlyhspercentId').value = monthlyPercent;
						 }else{
						document.getElementById('hvmhspercentId').value =0;
						document.getElementById('monthlyhspercentId').value = 0;
						 }
					
					if( b15!=null && b12!=null &&'null'!=b15 &&'null'!=b12 &&  b15!=0 && b12!=0){
						var monthlyPercent = (b15/b12)*100;
						 var monthlyPercentFinal=Math.round(monthlyPercent);
						 document.getElementById('memberPercentId').value =monthlyPercentFinal;
						 }else{
						document.getElementById('memberPercentId').value =0;	 
						 }
						if(dupl18.childNodes[0]!=null){
							b18 = dupl18.childNodes[0].nodeValue;
							if('null' !=b18){
								document.getElementById('healthsupervisor').value=b18;
							}else{
								document.getElementById('healthsupervisor').value='';
							}
							 
						}
					if(dupl19.childNodes[0]!=null){
						b19 = dupl19.childNodes[0].nodeValue;
						if('null' !=b19){
							document.getElementById('healthinspector').value=b19;
						}else{
							document.getElementById('healthinspector').value='';
						}
					}
					
					if(dupl21.childNodes[0]!=null){
						b21 = dupl21.childNodes[0].nodeValue;
						if('null' !=b21){
							document.getElementById('districtMedicalOfficer').value=b21;
						}else{
							document.getElementById('districtMedicalOfficer').value='';
						}
					}
					
					if(dupl22.childNodes[0]!=null){
						b22 = dupl22.childNodes[0].nodeValue;
						if('null' !=b22){
							document.getElementById('regionalcho').value=b22;
						}else{
							document.getElementById('regionalcho').value='';
						}
						 
					}
					
					if(dupl23.childNodes[0]!=null){
						b23 = dupl23.childNodes[0].nodeValue;
						if('null' !=b23){
							document.getElementById('medicalchc').value=b23;
						}else{
							document.getElementById('medicalchc').value='';
						}
						 
					}
					if(dupl24.childNodes[0]!=null){
						b24 = dupl24.childNodes[0].nodeValue;
						if('null' !=b24){
							document.getElementById('technicalAss2').value=b24;
						}else{
							document.getElementById('technicalAss2').value='';
						}
						 
					}
					if(dupl25.childNodes[0]!=null){
						b25 = dupl25.childNodes[0].nodeValue;
						if('null' !=b25){
							document.getElementById('medicalphcId').value=b25;
						}else{
							document.getElementById('medicalphcId').value='';
						}
						 
					}
					
				}
			}
		}
				var url = "/hms/hms/pubHealth?method=showDashboardCumulativeSurveyCount&userType="+userType +
				"&districtId="+ districtId+"&fromDate="+fromDate +"&toDate="+toDate + "&instType="+ instType + "&healthBlockId="+ healthBlockId + "&ListOfCenterId="+ ListOfCenterId + "&chcphc="+ chcphc 
				+"&base="+base +"&instituteType="+instituteType +"&" + csrfTokenName + "="+ csrfTokenValue;
				
		xmlHttp.open("GET", url, true);
		xmlHttp.setRequestHeader("Content-Type", "text/xml");
		xmlHttp.send(null);
}


function AuthenticateSurvey() {
	var districtId = document.getElementById("district").value;
	var fromDate = document.getElementById("fromDate").value;
	var toDate = document.getElementById("toDate").value;
	var instType = document.getElementById("instType").value;
	var healthBlockId = document.getElementById("healthBlockId").value;
	var ListOfCenterId = document.getElementById("ListOfCenterId").value;
	var chcphc = document.getElementById("chcphc").value;
	var base = document.getElementById("base").value;
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
			var items = xmlHttp.responseXML.getElementsByTagName('items1')[0];
			for (loop = 0; loop < items.childNodes.length; loop++) {
				var item = items.childNodes[loop];
				var dupl = item.getElementsByTagName('alreadyIssued2')[0];
				var dupl1 = item.getElementsByTagName('alreadyIssued2')[1];
				var dupl2 = item.getElementsByTagName('alreadyIssued2')[2];
				var dupl3 = item.getElementsByTagName('alreadyIssued2')[3];
				var dupl4 = item.getElementsByTagName('alreadyIssued2')[4];
				var dupl5 = item.getElementsByTagName('alreadyIssued2')[5];
				/*
				 * var dupl6 = item.getElementsByTagName('alreadyIssued2')[6];
				 * var dupl7 = item.getElementsByTagName('alreadyIssued2')[7];
				 * var dupl8 = item.getElementsByTagName('alreadyIssued2')[8];
				 */
				var dupl9  = item.getElementsByTagName('alreadyIssued2')[9];
				var dupl10 = item.getElementsByTagName('alreadyIssued2')[10];
				var dupl11 = item.getElementsByTagName('alreadyIssued2')[11];
				var dupl12 = item.getElementsByTagName('alreadyIssued2')[12];
				/*var dupl13 = item.getElementsByTagName('alreadyIssued2')[13];*/
				var dupl14 = item.getElementsByTagName('alreadyIssued2')[14];
				var dupl15 = item.getElementsByTagName('alreadyIssued2')[15];
				/*var dupl16 = item.getElementsByTagName('alreadyIssued2')[16];
				var dupl17 = item.getElementsByTagName('alreadyIssued2')[17];
				*/var dupl18 = item.getElementsByTagName('alreadyIssued2')[18];
				var dupl19 = item.getElementsByTagName('alreadyIssued2')[19];
				var dupl20 = item.getElementsByTagName('alreadyIssued2')[20];

				 b = dupl.childNodes[0].nodeValue;
				b1 = dupl1.childNodes[0].nodeValue;
				b2 = dupl2.childNodes[0].nodeValue;
				b3 = dupl3.childNodes[0].nodeValue;
				if (dupl4.childNodes[0] != null) {
					b4 = dupl4.childNodes[0].nodeValue;
					if ('null' != b4) {
						document.getElementById('remarks').value = b4;
					} else {
						document.getElementById('remarks').value = '';
					}

				}
				if (dupl5.childNodes[0] != null) {
					b5 = dupl5.childNodes[0].nodeValue;
					if ('null' != b5) {
						document.getElementById('status').value = b5;
					} else {
						document.getElementById('status').value = '';
					}
				}
				/* b6 = dupl6.childNodes[0].nodeValue; */
				/*
				 * b7 = dupl7.childNodes[0].nodeValue; b8 =
				 * dupl8.childNodes[0].nodeValue;
				 */
				if (dupl9.childNodes[0] != null) {
					b9 = dupl9.childNodes[0].nodeValue;
					if ('null' != b9 && null!=b9) {
						//document.getElementById('fromDateId').value = b9;
					} else {
						//document.getElementById('fromDateId').value = 0;
					}
				}
				if (dupl10.childNodes[0] != null) {
					b10 = dupl10.childNodes[0].nodeValue;
					if ('null' != b10) {
						//document.getElementById('toDateId').value = b10;
					} else {
						//document.getElementById('toDateId').value = 0;
					}
				}
				if(dupl11.childNodes[0]!=null){
					b11 = dupl11.childNodes[0].nodeValue;
					if( 'null' != b11){
						document.getElementById('targetIds').value=b11;	
					}else{
						document.getElementById('targetIds').value=0;	
					}
				}
				/*b11 = dupl11.childNodes[0].nodeValue;*/
				b12 = dupl12.childNodes[0].nodeValue;
				/*b13 = dupl13.childNodes[0].nodeValue;*/
				b14 = dupl14.childNodes[0].nodeValue;
				b15 = dupl15.childNodes[0].nodeValue;
				/*b16 = dupl16.childNodes[0].nodeValue;
				b17 = dupl17.childNodes[0].nodeValue;*/
				b18 = dupl18.childNodes[0].nodeValue;
				b19 = dupl19.childNodes[0].nodeValue;
				b20 = dupl20.childNodes[0].nodeValue;
				if ('null' != b) {
					document.getElementById('monthlyhvId').value = b;
				} else {
					document.getElementById('monthlyhvId').value = '';
				}
				if ('null' != b1) {
					document.getElementById('hvcummulativeId').value = b1;
				} else {
					document.getElementById('hvcummulativeId').value = '';
				}
				if ('null' != b20) {
					document.getElementById('annualhvisitedtargetId').value = b20;
				} else {
					document.getElementById('annualhvisitedtargetId').value = '';
				}
				if ('null' != b3) {
					document.getElementById('monthlyhVisitTargetId').value = Math.round(b20/12);
				} else {
					document.getElementById('monthlyhVisitTargetId').value = '';
				}
				if ('null' != b3) {
					document.getElementById('dailyhVisitTargetId').value = Math.round(b20/240);
				} else {
					document.getElementById('dailyhVisitTargetId').value = '';
				}
				if ('null' != b3) {
					document.getElementById('houseTargetId').value = b3;
				} else {
					document.getElementById('houseTargetId').value = '';
				}
				if ('null' != b11) {
					document.getElementById('targetIds').value = b11;
				} else {
					document.getElementById('targetIds').value = '';
				}
				if ('null' != b12) {
					document.getElementById('memeberTargetId').value = b12;
				} else {
					document.getElementById('memeberTargetId').value = '';
				}
				/*if ('null' != b13) {
					document.getElementById('monthlyMemberSurveyTargetId').value = b13;
				} else {
					document.getElementById('monthlyMemberSurveyTargetId').value = '';
				}*/
				if ('null' != b14) {
					document.getElementById('houseId').value = b14;
				} else {
					document.getElementById('houseId').value = '';
				}if ('null' != b15) {
					document.getElementById('memeberId').value = b15;
				} else {
					document.getElementById('memeberId').value = '';
				}/*if ('null' != b16) {
					document.getElementById('totalmemberSurveyCountdb').value = b16;
				} else {
					document.getElementById('totalmemberSurveyCountdb').value = '';
				}if ('null' != b17) {
					document.getElementById('totalhouseSurveyCountdb').value = b17;
				} else {
					document.getElementById('totalhouseSurveyCountdb').value = '';
				}*/if ('null' != b18) {
					document.getElementById('healthsupervisor').value = b18;
				} else {
					document.getElementById('healthsupervisor').value = '';
				}if ('null' != b19) {
					document.getElementById('healthinspector').value = b19;
				} else {
					document.getElementById('healthinspector').value = '';
				}if ('null' != b2) {
					//document.getElementById('monthlyhstargetId').value = b2;
				} else {
					//document.getElementById('monthlyhstargetId').value = '';
				}
				
				if ('null' != b14 && 'null' != b3 && b14 != 0 && b3 != 0) {
					var annuallyPercent = (b14 / b3) * 100;
					var annuallyPercentFinal = Math.round(annuallyPercent);
					document.getElementById('hvmhspercentId').value = annuallyPercentFinal;
					document.getElementById('housePercentId').value = annuallyPercentFinal;
				} else {
					document.getElementById('hvmhspercentId').value = 0;
					document.getElementById('housePercentId').value = 0;
				}

				if (b != null && b2 != null && 'null' != b && 'null' != b2
						&& b != 0 && b2 != 0) {
					var monthlyPercent = (b / b2) * 100;
					var monthlyPercentFinal = Math.round(monthlyPercent);
					document.getElementById('monthlyhspercentId').value = monthlyPercentFinal;
				} else {
					document.getElementById('monthlyhspercentId').value = 0;
				}
				if (b15 != null && b12 != null && 'null' != b15
						&& 'null' != b12 && b15 != 0 && b12 != 0) {
					var monthlyPercent = (b15 / b12) * 100;
					var monthlyPercentFinal = Math.round(monthlyPercent);
					document.getElementById('memberPercentId').value = monthlyPercentFinal;
				} else {
					document.getElementById('memberPercentId').value = 0;
				}
			}
		}
	}
	var url = "/hms/hms/pubHealth?method=showDashboardTargetDetails&userType="
			+ userType
			+ "&districtId="
			+ districtId
			+ "&fromDate="
			+ fromDate
			+ "&toDate="
			+ toDate
			+ "&instType="
			+ instType
			+ "&healthBlockId="
			+ healthBlockId
			+ "&ListOfCenterId="
			+ ListOfCenterId
			+ "&chcphc="
			+ chcphc + "&base=" + base
	"&" + csrfTokenName + "=" + csrfTokenValue;

	xmlHttp.open("GET", url, true);
	xmlHttp.setRequestHeader("Content-Type", "text/xml");
	xmlHttp.send(null);
}


function annualMemberSurveyPercent(){
	var memeberId = document.getElementById('memeberId').value ;
	 var memeberTargetId=document.getElementById('memeberTargetId').value ;
	
	 if(memeberId!=null && memeberTargetId!=null&& memeberId!=0&& memeberTargetId!=0){
		
		var annuallymsPercent = (memeberId/memeberTargetId)*100;
		 var monthlymsPercent = annuallymsPercent/12;
		var finalannualpercent=Math.round(annuallymsPercent);
		var finalmonthlypercent= Math.round(monthlymsPercent);
		 document.getElementById('memberPercentId').value =finalannualpercent;
		 }
 }


function validatesurveytarget(){
	var annualhvisitedtargetId = document.getElementById('annualhvisitedtargetId').value ;
	 var totalhouseSurveyCountdb = document.getElementById('totalhouseSurveyCountdb').value ;
	
	 if(annualhvisitedtargetId!=null && totalhouseSurveyCountdb!=null&& annualhvisitedtargetId!=0&& totalhouseSurveyCountdb!=0){
		 if(parseInt(annualhvisitedtargetId) >= parseInt(totalhouseSurveyCountdb)){
			 var b=0;
			 document.getElementById('annualhvisitedtargetId').value =b;
			 alert('annual house survey target is not more than house count');
			 document.getElementById('monthlyhstargetId').value =0;
			 document.getElementById('hvmhspercentId').value =0;
			 document.getElementById('annualhvisitedtargetId').value =0;
			 }
		 }
 }
function monthlyHouseSurveyPercent(){
	var monthlyhvId= document.getElementById('monthlyhvId').value;
	 var monthlyhstargetId=document.getElementById('monthlyhstargetId').value ;
	 if(monthlyhvId!=null && monthlyhstargetId!=null && monthlyhvId==0 && monthlyhstargetId!=0){
		var monthlyPercent = (monthlyhvId/monthlyhstargetId)*100;
		 var monthlyPercentFinal=Math.round(monthlyPercent);
		 document.getElementById('monthlyhspercentId').value =monthlyPercentFinal;
		 }
 
}

function annualhouseSurveyPerent(){
	var hvcummulativeId= document.getElementById('hvcummulativeId').value;
	 var annualhvisitedtargetId=document.getElementById('annualhvisitedtargetId').value ;
	 if(annualhvisitedtargetId!=null && hvcummulativeId!=null && annualhvisitedtargetId!=0 && hvcummulativeId!=0){
		var annuallyPercent = (hvcummulativeId/annualhvisitedtargetId)*100;
		 var annuallyPercentFinal=Math.round(annuallyPercent);
		 document.getElementById('hvmhspercentId').value =annuallyPercentFinal;
		 }
 }


function popupforGraph(url) { 

	var instType= document.getElementById('instType').value;   
	var healthBlockId = document.getElementById('healthBlockId').value;
	var base = document.getElementById('base').value;
	var ListOfCenterId = document.getElementById('ListOfCenterId').value;
	var chcphc = document.getElementById('chcphc').value;
	var districtId = document.getElementById('district').value;
	var fromDate = document.getElementById('fromDate').value; 
	var hospitalId = document.getElementById('hospitalId').value; 
	var toDate	= document.getElementById('toDate').value;
	var height = 400;
	var width = 750;
	var left = (screen.width / 2) - (width / 2);
	var top = (screen.height / 2) - (height / 3);
	url = url+"&instType="+instType+"&hospitalIds="+hospitalId+"&ListOfCenterId="+ListOfCenterId+"&chcphc="+chcphc+"&base="+base+"&healthBlockId="+healthBlockId+"&districtId="+districtId +"&fromDate="+fromDate +"&toDate="+toDate +"&"+ csrfTokenName + '=' + csrfTokenValue;
	window.open(url, "Patient Details",
			"resizable=0,scrollbars=no, status = no, height = " + height
					+ ", width =" + width + ",top=" + top + ", left=" + left)
}

function checkCheckBoxes() {

	var checkbox = document.getElementById("verify");
	if (checkbox.checked == false) {
		alert('Please select the check boxes for verification! ');
		return false;
	} else {
		return true;
	}
}

function getListCenter() {
	var district = document.getElementById('district').value;
	var healthblock = document.getElementById('healthBlockId').value;
	var listOfCenterId = document.getElementById('ListOfCenterId').value;
	
	submitProtoAjaxWithDivName('dashboardTarget',
			'/hms/hms/pubHealth?method=getPhcChclist&district=' + district
					+ '&healthblock=' + healthblock + '&listOfCenterId='
					+ listOfCenterId, 'tDiv');
}

function getListCenterWithoutHB(){
	var district = document.getElementById('district').value;
	//var healthblock = document.getElementById('healthBlockId').value;
	var listOfCenterId = document.getElementById('ListOfCenterId').value;
	submitProtoAjaxWithDivName('dashboardTarget',
			'/hms/hms/pubHealth?method=getPhcChclist&district=' + district
					+ '&listOfCenterId='
					+ listOfCenterId, 'tDiv');  //+ '&healthblock=' + healthblock 
}

window.onload = function enableRadios(){
    var x=document.getElementById("instituteType").value;
    if(x==0){
		 document.getElementById("blocklevelId").style.display ='inline';	
		 document.getElementById("districtlevelClass").style.display ='inline';
	}
    else if(x == 1 ){
  			document.getElementById("districtlevelClass").style.display ='block';
  		 	document.getElementById("blocklevelId").style.display ='none';	
		}
		else if(x == 2) {
			 document.getElementById("blocklevelId").style.display ='block';	
			 document.getElementById("districtlevelClass").style.display ='none';
		} 
			
	}
	 function enableRadio(){
	     var x=document.getElementById("instituteType").value;
	     if(x==0){
			 document.getElementById("blocklevelId").style.display ='inline';	
			 document.getElementById("districtlevelClass").style.display ='inline';
		}
	     else if(x == 1 ){
	   			document.getElementById("districtlevelClass").style.display ='none';
	   		 	document.getElementById("blocklevelId").style.display ='block';	
			}
			else if(x == 2) {
				 document.getElementById("blocklevelId").style.display ='none';	
				 document.getElementById("districtlevelClass").style.display ='block';
			} 
				
		}
	