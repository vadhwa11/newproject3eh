 /*Grid for Ward Mgmt. By VIKAS------------*/

showOnSamePage = true;
addAction = true;
rowsPerPage = 10;
totalPages =""
currentColor = "odd";
totRec="";
st="";
patientStatus="";
VisitId="";
uhidNum="";

function makeGridForPatient(starter, end){
    totalPages = Math.ceil(data_arr.length/rowsPerPage);
    document.getElementById("total").innerHTML=totalPages
    document.getElementById("currEnd").innerHTML=data_arr.length
    if(totalPages==0){
	    document.getElementById('searchtable').style.width = "100%"
    	document.getElementById('searchtable').style.textAlign = "left"
        document.getElementById('searchtable').innerHTML = '<h4>No Records Found</h4>'
		document.getElementById('resultnavigation').style.display="none";
        return;
    }
    else if(totalPages == 1){
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"
    }
    if(totalPages>1){//added by govind 18-02-2017
    if(st!=null){
    if(st==0){	
    	document.getElementById("totalRecs").innerHTML=rowsPerPage
    	document.getElementById("current").innerHTML=1;
    	document.getElementById("currStart").innerHTML=1;
    	document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"
    }
    }
    }	
    if(totRec!=null){
    if(totRec<=10){
    	document.getElementById("totalRecs").innerHTML=totRec;
    }
    }
    //added by govind 18-02-2017 end
    document.getElementById('resultnavigation').style.display="inline";
    var patientStatus="";
    if(document.getElementById("patientStatus"))
    	patientStatus = document.getElementById("patientStatus").value;  //Added By Om Tripathi 11/08/2017
    var VisitId = "";
    if(document.getElementById("VisitId"))
    	VisitId =	document.getElementById("VisitId").value; 
    var uhidNum ="";
    if(document.getElementById("uhidNum"))
    	uhidNum = document.getElementById("uhidNum").value;
    
    //document.getElementById('pageno').length=totalPages
    for(pg=1;pg<=totalPages;pg++){
        //document.getElementById('pageno')[pg-1].value = pg
        //document.getElementById('pageno')[pg-1].text = pg
    }
    st=1;//added by govind 18-02-2017
    start = starter;
    if(data_header){
                tempTable = '<table border="0" cellspacing="0"  cellpadding="0" width="100%"><thead><tr>'
        for(cols=0;cols<data_header.length;cols++){
            if(data_header[cols][1]=="data"){
                tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            }
            else if(data_header[cols][1]=="hide"){
                    tempTable += '<th class="hide">&nbsp;</th>'
            }else if(data_header[cols][1]=="radio"){
            		 tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            	}
        }
        tempTable += '<tr></thead><tbody id="searchresulttable">'
        for(rows=start;rows<end; rows++){
	        	var colorVar="";
	        	 if(formName=="opd_OP_Clinic_Waiting_PatientList"){
	        		 if(data_arr[rows][9]=='1'){
		            	colorVar="background-color: #FE5A4C";
	        		 }else if(data_arr[rows][9]=='2'){
		            	colorVar="background-color: #9CCB19";
		             }else {
		            	 if(data_arr[rows][8]=='1')
			            		colorVar="background-color: #FFF0F5";
			            	if(data_arr[rows][8]=='2')
			            		colorVar="background-color: #F5F5DC";
			            	if(data_arr[rows][8]=='3')
			            		if(data_arr[rows][11]=='Y'){
			         				colorVar="background-color: #FFE4C4"; 
				        		 }
			            		else
			            		colorVar="background-color: #ADD8E6";	
		             }             
	            	tempTable += '<tr id="'+data_arr[rows][0]+'" style="'+colorVar+'" class="'
	            }else if(formName=="opd_nurse_waiting_PatientList"){
	            	if(data_arr[rows][10]=='1' || data_arr[rows][10]=='1')
	            		colorVar="background-color: #FFF0F5";
	            	if(data_arr[rows][10]=='2' || data_arr[rows][10]=='2')
	            		colorVar="background-color: #F5F5DC";
	            	if(data_arr[rows][10]=='3' || data_arr[rows][10]=='3')
	            		colorVar="background-color: #FFE4C4";
	            	tempTable += '<tr id="'+data_arr[rows][0]+'" style="'+colorVar+'" class="'
	            }
	            else{
	            	tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
	            }
               // tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
				if(rows%rowsPerPage == 0 && rows != 0){
					currentColor = "odd"
				}
                tempTable += currentColor;
				currentColor = (currentColor == "odd")?"even" : "odd";
                tempTable += '">'
                for(columns=1;columns<=data_header.length;columns++){
                    tempTable += '<td '
                    if(data_header[columns-1][1] == "hide")
                        tempTable += 'class="hide"';
                    tempTable +='>'
                    if(formName=="opdPatientVisit" || formName=="prevOpdPhysiotherapyForm"){
                     	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    }else if(formName=="opd_nurse_waiting_PatientList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    }else if(formName=="observation_ward_dashboard_List"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    }else if(formName=="op_nursingcare_Waiting_List"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][4]+'\',\''+data_arr[rows][12]+'\')">';
                    }else if(formName=="opd_OP_Clinic_Waiting_PatientList_forRecall"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\', document.getElementById(\'opdType\'))">';
                    }else if(formName=="opdPhysiotherapyList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    }
                    // added by amit das on 21-04-2017
                    else if(formName=="opd_OP_Clinic_Waiting_PatientList"){
                    	if(data_header[columns-1][0]!="Skip Reason")
                    		tempTable += '<a href="javascript: if(checkForCounter()){RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\', document.getElementById(\'skip'+rows+'\'))}">';
                    }else if(formName=="ipdPhysiotherapyList" || formName=="ipdPhysiotherapyList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    } else if(formName=="ipdDialysisList" || formName=="ipdDialysisList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    } else if(formName=='serviceRequest'){
                    	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    }else if(formName=='mAssignResource'){
                    	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    }else if(formName=='mServiceRequest'){
                    	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    }else if(formName=='pendingForServiceOrderComletion'){
                    	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    }else if(formName=='mTransferServiceRequest'){
                    	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    }else if(formName=='mPreventiveMaintenance'){
                    	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    } else if(formName=="relievingWaiting" || formName=="joiningWaiting" ){
                     	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    } else if(formName=="waitingTermSusp"){
                     	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\',\''+data_arr[rows][9]+'\')">';
                    }  else if(formName=="joinWaiting"){
                     	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+data_arr[rows][9]+'\',\''+data_arr[rows][2]+'\')">';
                    } else if(formName=="immunizationSearch"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    } else if(formName=="immun_nursingcare_Waiting_List"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][4]+'\',\''+data_arr[rows][12]+'\')">';
                    }
                    
                    else if(formName=="opd_OP_Clinic_Waiting_PatientList_new"){
                    	if(data_header[columns-1][0]!="Skip Reason")
                     	tempTable += '<a href="javascript: if(checkForCounter()){openOpdLite(\''+data_arr[rows][0]+'\' ,\''+rows+'\', document.getElementById(\'skip'+rows+'\'))}">';
                    } else if(formName=="opd_OP_Clinic_Waiting_PatientList_new_detail"){
                    	if(data_header[columns-1][0]!="Skip Reason")
                     	tempTable += '<a href="javascript: if(checkForCounter()){openDetail(\''+data_arr[rows][0]+'\',\''+rows+'\', document.getElementById(\'skip'+rows+'\'))}">';
                    }
                    
                    
                 //   else if(formName=="opdPhysiotherapyList"){
                 //    	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                //    }
                else if(showOnSamePage){
                    	if(formName!="nursingCareEntryDetail" && formName != "patientList"  && formName!='opd_OP_Clinic_Waiting_PatientList_new'){
                    	tempTable += '<a href="javascript:editRecord(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    	}
               		}
                    else if(addAction)
                    	tempTable += '<a href="'+ goToUrl +'&id='+data_arr[rows][0]+'">';

                    else
                    	tempTable += '<a href="'+ goToUrl +'&'+data_arr[rows][0]+'.action">';

                    tempTable +=data_arr[rows][columns]
                    tempTable +='</a></td>'
                }
               tempTable += '</tr>'
        }
        tempTable += '</tbody></table>'

        document.getElementById('searchtable').innerHTML = tempTable;
    }

    if(document.paging.pageno && document.paging.pageno.value == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"

    }
}

function makeGridForPatientNursingWaitingList(starter, end){

    totalPages = Math.ceil(data_arr.length/rowsPerPage);
    document.getElementById("total").innerHTML=totalPages
    document.getElementById("currEnd").innerHTML=data_arr.length
    if(totalPages==0){
	    document.getElementById('searchtable').style.width = "100%"
    	document.getElementById('searchtable').style.textAlign = "left"
        document.getElementById('searchtable').innerHTML = '<h4>No Records Found</h4>'
		document.getElementById('resultnavigation').style.display="none";
        return;
    }
    else if(totalPages == 1){
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"
    }
    document.getElementById('resultnavigation').style.display="inline";
    //document.getElementById('pageno').length=totalPages
    for(pg=1;pg<=totalPages;pg++){
        //document.getElementById('pageno')[pg-1].value = pg
        //document.getElementById('pageno')[pg-1].text = pg
    }
    start = starter;
    if(data_header){
                tempTable = '<table border="0" cellspacing="0"  cellpadding="0" width="100%"><thead><tr>'
        for(cols=0;cols<data_header.length;cols++){
            if(data_header[cols][1]=="data"){
                tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            }
            else if(data_header[cols][1]=="hide"){
                    tempTable += '<th class="hide">&nbsp;</th>'
            }else if(data_header[cols][1]=="radio"){
            		 tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            	}
        }
        tempTable += '<tr></thead><tbody id="searchresulttable">'
        for(rows=start;rows<end; rows++){
                tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
				if(rows%rowsPerPage == 0 && rows != 0){
					currentColor = "odd"
				}

                tempTable += currentColor;
				currentColor = (currentColor == "odd")?"even" : "odd";
                tempTable += '">'
                for(columns=1;columns<=data_header.length;columns++){
                    tempTable += '<td '
                    if(data_header[columns-1][1] == "hide")
                        tempTable += 'class="hide"';
                    tempTable +='>'
                    if(formName=="opdPatientVisit" || formName=="prevOpdPhysiotherapyForm"){
                     	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    }
                    else if(formName=="opdPatientList" || formName=="opdPhysiotherapyList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    }else if(formName=="ipdPhysiotherapyList" || formName=="ipdPhysiotherapyList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    } else if(formName=="ipdDialysisList" || formName=="ipdDialysisList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    } 
                    
                    
                    
                 //   else if(formName=="opdPhysiotherapyList"){
                 //    	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                //    }
                else if(showOnSamePage){
                    	if(formName!="nursingCareEntryDetail" && formName != "patientList"  && formName!='opd_OP_Clinic_Waiting_PatientList_new'){
                    	tempTable += '<a href="javascript:editRecord(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    	}
               		}
                    else if(addAction)
                    	tempTable += '<a href="'+ goToUrl +'&id='+data_arr[rows][0]+'">';

                    else
                    	tempTable += '<a href="'+ goToUrl +'&'+data_arr[rows][0]+'.action">';

                    tempTable +=data_arr[rows][columns]
                    tempTable +='</a></td>'
                }
               tempTable += '</tr>'
        }
        tempTable += '</tbody></table>'

        document.getElementById('searchtable').innerHTML = tempTable;
    }

    if(document.paging.pageno.value == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"

    }
}

function makeGridForPatientNursingWaitingList(starter, end){

    totalPages = Math.ceil(data_arr.length/rowsPerPage);
    document.getElementById("total").innerHTML=totalPages
    document.getElementById("currEnd").innerHTML=data_arr.length
    if(totalPages==0){
	    document.getElementById('searchtable').style.width = "100%"
    	document.getElementById('searchtable').style.textAlign = "left"
        document.getElementById('searchtable').innerHTML = '<h4>No Records Found</h4>'
		document.getElementById('resultnavigation').style.display="none";
        return;
    }
    else if(totalPages == 1){
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"
    }
    document.getElementById('resultnavigation').style.display="inline";
    //document.getElementById('pageno').length=totalPages
    for(pg=1;pg<=totalPages;pg++){
        //document.getElementById('pageno')[pg-1].value = pg
        //document.getElementById('pageno')[pg-1].text = pg
    }
    start = starter;
    if(data_header){
                tempTable = '<table border="0" cellspacing="0"  cellpadding="0" width="100%"><thead><tr>'
        for(cols=0;cols<data_header.length;cols++){
            if(data_header[cols][1]=="data"){
                tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            }
            else if(data_header[cols][1]=="hide"){
                    tempTable += '<th class="hide">&nbsp;</th>'
            }else if(data_header[cols][1]=="radio"){
            		 tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            	}
        }
        tempTable += '<tr></thead><tbody id="searchresulttable">'
        for(rows=start;rows<end; rows++){
                tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
				if(rows%rowsPerPage == 0 && rows != 0){
					currentColor = "odd"
				}

                tempTable += currentColor;
				currentColor = (currentColor == "odd")?"even" : "odd";
                tempTable += '">'
                for(columns=1;columns<=data_header.length;columns++){
                    tempTable += '<td '
                    if(data_header[columns-1][1] == "hide")
                        tempTable += 'class="hide"';
                    tempTable +='>'
                    if(formName=="opdPatientVisit" || formName=="prevOpdPhysiotherapyForm"){
                     	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    }
                    else if(formName=="opdPatientList" || formName=="opdPhysiotherapyList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    }else if(formName=="ipdPhysiotherapyList" || formName=="ipdPhysiotherapyList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    } else if(formName=="ipdDialysisList" || formName=="ipdDialysisList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    } else if(formName=='serviceRequest'){
                    	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    }
                    
                    
                    
                 //   else if(formName=="opdPhysiotherapyList"){
                 //    	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                //    }
                else if(showOnSamePage){
                    	if(formName!="nursingCareEntryDetail" && formName != "patientList" && formName!='opd_OP_Clinic_Waiting_PatientList_new'){
                    	tempTable += '<a href="javascript:editRecord(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    	}
               		}
                    else if(addAction)
                    	tempTable += '<a href="'+ goToUrl +'&id='+data_arr[rows][0]+'">';

                    else
                    	tempTable += '<a href="'+ goToUrl +'&'+data_arr[rows][0]+'.action">';

                    tempTable +=data_arr[rows][columns]
                    tempTable +='</a></td>'
                }
               tempTable += '</tr>'
        }
        tempTable += '</tbody></table>'

        document.getElementById('searchtable').innerHTML = tempTable;
    }

    if(document.paging.pageno.value == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"

    }
}



function makeGridForWaitingPatient(starter, end){
    totalPages = Math.ceil(data_arr.length/rowsPerPage);
    document.getElementById("total").innerHTML=totalPages
    document.getElementById("currEnd").innerHTML=data_arr.length
    if(totalPages==0){
	    document.getElementById('searchtable').style.width = "100%"
    	document.getElementById('searchtable').style.textAlign = "left"
        document.getElementById('searchtable').innerHTML = '<h4>No Records Found</h4>'
		document.getElementById('resultnavigation').style.display="none";
        return;
    }
    else if(totalPages == 1){
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"
    }
    document.getElementById('resultnavigation').style.display="inline";
    //document.getElementById('pageno').length=totalPages
    for(pg=1;pg<=totalPages;pg++){
        //document.getElementById('pageno')[pg-1].value = pg
        //document.getElementById('pageno')[pg-1].text = pg
    }
    start = starter;
    if(data_header){
                tempTable = '<table border="0" cellspacing="0"  cellpadding="0" width="100%"><thead><tr>'
        for(cols=0;cols<data_header.length;cols++){
            if(data_header[cols][1]=="data"){
                tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            }
            else if(data_header[cols][1]=="hide"){
                    tempTable += '<th class="hide">&nbsp;</th>'
            }else if(data_header[cols][1]=="radio"){
            		 tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            	}
        }
        tempTable += '<tr></thead><tbody id="searchresulttable">'
        for(rows=start;rows<end; rows++){
                tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
				if(rows%rowsPerPage == 0 && rows != 0){
					currentColor = "odd"
				}

        }
    }
  }      
function makeGridForWaitingPatient(starter, end){
    totalPages = Math.ceil(data_arr.length/rowsPerPage);
    document.getElementById("total").innerHTML=totalPages
    document.getElementById("currEnd").innerHTML=data_arr.length
    if(totalPages==0){
	    document.getElementById('searchtable').style.width = "100%"
    	document.getElementById('searchtable').style.textAlign = "left"
        document.getElementById('searchtable').innerHTML = '<h4>No Records Found</h4>'
		document.getElementById('resultnavigation').style.display="none";
        return;
    }
    else if(totalPages == 1){
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"
    }
    document.getElementById('resultnavigation').style.display="inline";
    //document.getElementById('pageno').length=totalPages
    for(pg=1;pg<=totalPages;pg++){
        //document.getElementById('pageno')[pg-1].value = pg
        //document.getElementById('pageno')[pg-1].text = pg
    }
    start = starter;
    if(data_header){
                tempTable = '<table border="0" cellspacing="0"  cellpadding="0" width="100%"><thead><tr>'
        for(cols=0;cols<data_header.length;cols++){
            if(data_header[cols][1]=="data"){
                tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            }
            else if(data_header[cols][1]=="hide"){
                    tempTable += '<th class="hide">&nbsp;</th>'
            }else if(data_header[cols][1]=="radio"){
            		 tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            	}
        }
        tempTable += '<tr></thead><tbody id="searchresulttable">'
        for(rows=start;rows<end; rows++){
	        	var colorVar="";
	            if(formName=="opd_OP_Clinic_Waiting_PatientList"||formName=="opd_nurse_waiting_PatientList"){
	            	if(data_arr[rows][9]=='1')
	            		colorVar="background-color: #FFF0F5";
	            	if(data_arr[rows][9]=='2')
	            		colorVar="background-color: #F5F5DC";
	            	if(data_arr[rows][9]=='3')
	            		colorVar="background-color: #FFE4C4";
	            	tempTable += '<tr id="'+data_arr[rows][0]+'" style="'+colorVar+'" class="'
	            }else{
	            	tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
	            }
                //tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
				if(rows%rowsPerPage == 0 && rows != 0){
					currentColor = "odd"
				}

                tempTable += currentColor;
				currentColor = (currentColor == "odd")?"even" : "odd";
                tempTable += '">'
                for(columns=1;columns<=data_header.length;columns++){
                    tempTable += '<td '
                    if(data_header[columns-1][1] == "hide")
                        tempTable += 'class="hide"';
                    tempTable +='>'
                    if(formName=="opdPatientVisit" || formName=="prevOpdPhysiotherapyForm"){
                     	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    }
                    else if(formName=="opd_nurse_waiting_PatientList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    }else if(formName=="opd_OP_Clinic_Waiting_PatientList_forRecall"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    }else if(formName=="opd_OP_Clinic_Waiting_PatientList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    }else if(formName=="ipdPhysiotherapyList" || formName=="ipdPhysiotherapyList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    } else if(formName=="ipdDialysisList" || formName=="ipdDialysisList"){
                     	tempTable += '<a href="javascript:RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\')">';
                    } else if(formName=='serviceRequest'){
                    	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    }
                    
        
                else if(showOnSamePage){
                    	if(formName!="nursingCareEntryDetail" && formName != "patientList"  && formName!='opd_OP_Clinic_Waiting_PatientList_new'){
                    	tempTable += '<a href="javascript:editRecord(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    	}
               		}
                    else if(addAction)
                    	tempTable += '<a href="'+ goToUrl +'&id='+data_arr[rows][0]+'">';

                    else
                    	tempTable += '<a href="'+ goToUrl +'&'+data_arr[rows][0]+'.action">';

                    tempTable +=data_arr[rows][columns]
                    tempTable +='</a></td>'
                }
               tempTable += '</tr>'
        }
        tempTable += '</tbody></table>'

        document.getElementById('searchtable').innerHTML = tempTable;
    }

    if(document.paging.pageno.value == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"

    }
}


function RequestForToken(obj,formName,rowVal,tokenObj,extraArg)
{
	//alert("ss");
	if(formName == 'opd_nurse_waiting_PatientList'){
		 if(rowVal==0)
		 {
			visit = obj.id;
			token = tokenObj;
		    obj1 = eval('document.'+formName)
		    var url;
		    if(formName == 'opd_nurse_waiting_PatientList')
		    	url = "/hms/hms/opd?method=getNursingScreenJSP&fromFlag=w&visitId="+visit+"&token="+token;
			obj1.action = url;
			obj1.submit();
		 }else{
		   if(alertBeforeSubmit(rowVal))
		   {
		    visit = obj.id;
		    token = tokenObj;
		    obj1 = eval('document.'+formName)
		    var url;
		    if(formName == 'opd_nurse_waiting_PatientList')
		    	url = "/hms/hms/opd?method=getNursingScreenJSP&fromFlag=w&visitId="+visit+"&token="+token;
		   	obj1.action = url;
		    obj1.submit();
		   }
		 }
		 }
	if(formName == 'opd_OP_Clinic_Waiting_PatientList'){
		//alert(bReleaseClick);
		if(bReleaseClick == 'N')
		{
		 var searchFlag = 	document.getElementById('searchFlag').value;
			
		 if(rowVal==0 && searchFlag=='0')
		 {
			visit = obj.id;
			token = tokenObj;
		    obj1 = eval('document.'+formName)
		    var url;
		    if(formName == 'opd_OP_Clinic_Waiting_PatientList')
		   		url = "/hms/hms/opd?method=showOPDMainJsp&visitId="+visit+"&token="+token;
		    	//url = "/hms/hms/opd?method=getNursingScreenJSP&visitId="+visit+"&token="+token;
		    obj1.action = url;
			obj1.submit();
		 }else{
		   if(confirm("You are Skipping the patient ?"))
		   {
		    visit = obj.id;
		    token = tokenObj;
		    obj1 = eval('document.'+formName)
		    var url;
		    if(formName == 'opdPatientList')
		   		//url = "/hms/hms/opd?method=showOPDMainJsp&visitId="+visit+"&token="+token;
		    	url = "/hms/hms/opd?method=getNursingScreenJSP&visitId="+visit+"&token="+token;
		    else if(formName == 'opd_OP_Clinic_Waiting_PatientList')
		    	url = "/hms/hms/opd?method=showOPDMainJsp&visitId="+visit+"&token="+token+"&skipped=E&searchFlag="+searchFlag;
		    
		   	obj1.action = url;
		    obj1.submit();
		   }
		 }
		} // close if bReleaseClick
		 }
	if(formName == 'opd_OP_Clinic_Waiting_PatientList_forRecall'){
		 if(rowVal==0)
		 {
			visit = obj.id;
			token = tokenObj;
		    obj1 = eval('document.'+formName)
		    var url;
		    if(formName == 'opd_OP_Clinic_Waiting_PatientList_forRecall'){
		   		//url = "/hms/hms/opd?method=showOPDMainForRecallJsp&visitId="+visit+"&token="+token;
		    	if(extraArg && extraArg.value=='opdLite'){
		    		url = "/hms/hms/opd?method=showOpdLiteJsp&visitId="+visit+"&token="+token+"&recall=y";
		    	}
		    	else if(extraArg.value=='opdDeatail'){
		    		url = "/hms/hms/opd?method=showOpdDetailJsp&visitId="+visit+"&token="+token+"&recall=y";
		    	}
		    	else{	
		    		url = "/hms/hms/opd?method=showOPDMainJsp&visitId="+visit+"&token="+token+"&recall=y";
		    	}
		    } 
		    obj1.action = url;
			obj1.submit();
		 }else{
		  /* if(alertBeforeSubmit()) //commented by govind 21-02-2017 for remove for recall patient message
		   {*/
		    visit = obj.id;
		    token = tokenObj;
		    obj1 = eval('document.'+formName)
		    var url;
		    if(formName == 'opd_OP_Clinic_Waiting_PatientList_forRecall'){
		    	if(extraArg && extraArg.value=='opdLite')
		    		url = "/hms/hms/opd?method=showOpdLiteJsp&visitId="+visit+"&token="+token+"&recall=y";
		    		else if(extraArg.value=='opdDeatail')
			    		url = "/hms/hms/opd?method=showOpdDetailJsp&visitId="+visit+"&token="+token+"&recall=y";
		    		else
		    		url = "/hms/hms/opd?method=showOPDMainJsp&visitId="+visit+"&token="+token+"&recall=y";
		 	}
		   	obj1.action = url;
		    obj1.submit();
		   //}
		 }
		 }
	if(formName == 'ipdPhysiotherapyList'){
		var ipId = obj.id;
		//token = tokenObj;
 	    obj1 = eval('document.'+formName)
	    var url;
	    if(formName == 'ipdPhysiotherapyList')
	   		url = "/hms/hms/ipd?method=showIPDPhysiotherapyJsp&inpatientId="+ipId;
		obj1.action = url;
		obj1.submit();
	
	}
	if(formName == 'op_nursingcare_Waiting_List'){
		
		var injAppId = obj.id;
		var date= tokenObj;
		var visitId = extraArg;
		obj1 = eval('document.'+formName)
	    var url = "/hms/hms/opd?method=getOPNursingCareScreenJSP&injAppId="+injAppId+"&opdDate="+date+"&visitId="+visitId;
		obj1.action = url;
		obj1.submit();
	
	}
	if(formName == 'observation_ward_dashboard_List'){
		var opdId = obj.id;
		//alert("opdId  "+opdId+"  formName"+formName);
 	    obj1 = eval('document.'+formName)
	    var url = "/hms/hms/opd?method=getObservationWard&opdId="+opdId;
		obj1.action = url;
		obj1.submit();
	
	}
	if(formName == 'ipdDialysisList'){
		//alert("formName-->"+formName);
		var ipId = obj.id;
		//token = tokenObj;
 	    obj1 = eval('document.'+formName)
	    var url;
	    if(formName == 'ipdDialysisList')
	   		url = "/hms/hms/ipd?method=showIPDDialysisListDetails&inpatientId="+ipId;
		obj1.action = url;
		obj1.submit();
	
	}
	
	
	if(formName == 'opdPhysiotherapyList')
	{
		
		 if(rowVal==0)
		 {
			visit = obj.id;
			token = tokenObj;
	 	    obj1 = eval('document.'+formName)
		    var url;
		    if(formName == 'opdPhysiotherapyList')
		   		url = "/hms/hms/opd?method=showOPDPhysiotherapyJsp&visitId="+visit+"&token="+token;
			obj1.action = url;
			obj1.submit();
		 }else{
		   if(alertBeforeSubmit())
		   {
		    visit = obj.id;
		    token = tokenObj;
		    obj1 = eval('document.'+formName)
		    var url;
		    if(formName == 'opdPhysiotherapyList')
		   		url = "/hms/hms/opd?method=showOPDPhysiotherapyJsp&visitId="+visit+"&token="+token;
		   	obj1.action = url;
		    obj1.submit();
		   }
		 }
		
	}

	if(formName == 'immunizationSearch'){
		 if(rowVal==0)
		 {
			visit = obj.id;
			token = tokenObj;
		    obj1 = eval('document.'+formName)
		    var url;
		    if(formName == 'immunizationSearch')
		   		url = "/hms/hms/pubHealth?method=showVaccineDetailJsp&visitId="+visit+"&token="+token;
		    obj1.action = url;
			obj1.submit();
		 }else{
		   if(alertBeforeSubmit())
		   {
		    visit = obj.id;
		    token = tokenObj;
		    obj1 = eval('document.'+formName)
		    var url;
		    if(formName == 'immunizationSearch')
		    	url = "/hms/hms/pubHealth?method=showVaccineDetailJsp&visitId="+visit+"&token="+token;
		   	obj1.action = url;
		    obj1.submit();
		   }
		 }
		 }

	if(formName == 'immun_nursingcare_Waiting_List'){
		
		var injAppId = obj.id;
		var date= tokenObj;
		var visitId = extraArg;
		obj1 = eval('document.'+formName)
	    var url = "/hms/hms/pubHealth?method=getImmunNursingCareScreenJSP&injAppId="+injAppId+"&opdDate="+date+"&visitId="+visitId;
		obj1.action = url;
		obj1.submit();
	
	}
}
	function Request(obj,formName,rowVal)
		{
		    visit = obj.id;
		    obj1 = eval('document.'+formName)
		    
		    var url;
		    if(formName == 'opdPatientVisit')
		    {
		   		url = "/hms/hms/opd?method=viewPreviousVisit&visitId="+visit;
		    }
		   	obj1.action = url;
		    obj1.submit();
		    

		if(formName == 'prevOpdPhysiotherapyForm'){
			 	visit = obj.id;

			    obj1 = eval('document.'+formName)
			    var url;
			    if(formName == 'prevOpdPhysiotherapyForm')
			    	{
			   		url = "/hms/hms/opd?method=showPhysiotherapyPreviousDetails&visitId="+visit;
			    	}
			   	obj1.action = url;
			    obj1.submit();
		}
		if(formName == 'relievingWaiting' ){
			visit = obj.id;
			url = "/hms/hrms/training?method=showEmpRelievingJsp&id="+visit;
			obj1.action = url;
		    obj1.submit();
		}
		if(formName == 'joinWaiting'){
			visit = obj.id;
			url = "/hms/hrms/training?method=showEmpjoiningJsp&id="+visit+"&mode="+rowVal;
			//url = "/hms/hrms/training?method=showEmpjoiningJsp&id="+visit;
			obj1.action = url;
		    obj1.submit();
		}
		if(formName == 'serviceRequest'){
			url = "/hms/hms/maintenance?method=serviceRequest&requestId="+visit;
			obj1.action = url;
		    obj1.submit();
		}
		if(formName == 'mAssignResource'){
			url = "/hms/hms/maintenance?method=showAssignResourceJsp&requestId="+visit;
			obj1.action = url;
		    obj1.submit();
		}
		if(formName == 'mServiceRequest'){
			url = "/hms/hms/maintenance?method=showInspectionReport&requestId="+visit;
			obj1.action = url;
		    obj1.submit();
		}
		if(formName == 'pendingForServiceOrderComletion'){
			url = "/hms/hms/maintenance?method=serviceOrderCompletion&requestId="+visit;
			obj1.action = url;
		    obj1.submit();
		}
		if(formName == 'mTransferServiceRequest'){
			url = "/hms/hms/maintenance?method=showTransferService&requestId="+visit;
			obj1.action = url;
		    obj1.submit();
		}
		if(formName == 'mPreventiveMaintenance'){
			url = "/hms/hms/maintenance?method=showCreateServiceRequestJsp&equipment="+visit;
			obj1.action = url;
		    obj1.submit();
		}
		if(formName == 'waitingTermSusp'){
			visit = obj.id;
			url = "/hms/hrms/training?method=showEmpRelievingTerminAndSusp&id="+visit;
			obj1.action = url;
		    obj1.submit();
		}
		
	}

	function alertBeforeSubmit(i){
	    if(confirm("You are Skipping the patient ?"))
		{ i.value='E';
	    	if(i.value!='0')
	    		return true;
	    	else{
	    		alert('Please select skipping reason !');
	    		return false;
	    	}
	    		
		}
 }
/*
  for editing the grid
  */
	subtest_arr = new Array();
	currentRowClicked=""
	nonEditable="";


function editRecord(obj,formName){

	tmptext = ""
	if(currentRowClicked != "" ){
		if(subtest_arr.length>0){
			document.chargeCode.multipleresults.checked= false;
			document.getElementById('multiplebutton').style.display = 'none';
		}
		if(nonEditable){
			for(m=0;m<nonEditable.length;m++){
				nonEditableObj = eval("document."+ formName + "."  + nonEditable[m])
				if(nonEditableObj){
					if(nonEditableObj.type == "select-one"){
						nonEditableObj.disabled = false;
					}
					else
						nonEditableObj.readOnly = false;
				}
			}
		}
		if(document.getElementById(currentRowClicked))
			document.getElementById(currentRowClicked).style.backgroundColor = "";
		document.getElementById('edited').innerHTML = " "
		if(document.getElementById('addbutton'))
			document.getElementById('addbutton').style.display = 'none'
		if(document.getElementById('editbutton'))
			document.getElementById('editbutton').style.display = 'none';
		if(document.getElementById('deletebutton'))
			document.getElementById('deletebutton').style.display = 'none';
		for(i=0;i<formFields.length;i++){

			temp = eval("document."+ formName + "." +  formFields[i][1])
	
			if(temp){
				if(temp.type == "select-one")
					temp.selectedIndex = 0;
				else if(temp.type == "checkbox"){
						temp.checked = false;
				}
				else
					temp.value = "";
			}
		}
	}

	if(currentRowClicked != obj.id){

		if(document.getElementById('editbutton'))
			document.getElementById('editbutton').style.display = 'inline'
		if(document.getElementById('deletebutton'))
			document.getElementById('deletebutton').style.display = 'inline'
		if(document.getElementById('addbutton'))
			document.getElementById('addbutton').style.display = 'none';
		if(subtest_arr.length>0){
			chkMultipleTest(obj.id);
		}
		if(nonEditable){
			for(m=0;m<nonEditable.length;m++){
				nonEditableObj = eval("document."+ formName + "."  + nonEditable[m])
				if(nonEditableObj){
					if(nonEditableObj.type == "select-one"){
						nonEditableObj.disabled = true;
					}
					else
						nonEditableObj.readOnly = true;
				}
			}
		}
		obj.style.backgroundColor = '#9CCEF8'
		currentRowClicked=obj.id;
		for(i=0;i<formFields.length;i++){
			temp = eval("document."+ formName + "."  +  formFields[i][1])
			if(formFields[i][1] == "addEditBy")
				tmptext += "<label>last Edited By</label><span'>"+ obj.cells[formFields[i][0]-1].childNodes[0].innerHTML +"</span>"
			if(formFields[i][1] == "addEditOn")
				tmptext += "<label>On</label><span'>"+ obj.cells[formFields[i][0]-1].childNodes[0].innerHTML +"</span>"
			if(temp){
				if(temp.type == "select-one"){
					if(formName == "subTest")
						temp.selectedIndex = findElementIndex(temp, obj.cells[formFields[i][0]-1].innerHTML);
					else
						temp.selectedIndex = findElementIndex(temp, obj.cells[formFields[i][0]-1].childNodes[0].innerHTML);
				}
				else if(temp.type == "radio"){
					if(obj.cells[formFields[i][0]-1].childNodes[0].innerHTML == '1' || obj.cells[formFields[i][0]-1].childNodes[0].innerHTML == 'y')
						temp.checked = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
				}
				else if(temp.type == "checkbox"){
					if(obj.cells[formFields[i][0]-1].childNodes[0].innerHTML == '1' || 	obj.cells[formFields[i][0]-1].childNodes[0].innerHTML=='y'){
						temp.checked = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
					}
				}
				else{
					if(i==0)
						temp.value = obj.id;
					else{
						if(formName == "subTest"){
							temp.value = obj.cells[formFields[i][0]-1].innerHTML;
						}
						else
							temp.value = obj.cells[formFields[i][0]-1].childNodes[0].innerHTML;
						if(temp.value.indexOf('&amp;') != -1){
							temp.value = replaceSubstring(temp.value, '&amp;', '&')
						}
					}
				}
			}
		}
	}
	else if(currentRowClicked == obj.id){
		if(subtest_arr.length>0){
			document.chargeCode.multipleresults.checked= false;
			document.getElementById('multiplebutton').style.display = 'none';
		}
		currentRowClicked = "";
	}
	if(tmptext != ""){
		document.getElementById('edited').innerHTML = tmptext;
	}
}

  /*
  for editing the grid
  */






function navigateIPD(obj){

	document.paging.firstpage.style.border = "none"
	document.paging.nextpage.style.border = "none"
	document.paging.lastpage.style.border = "none"
	document.paging.prevpage.style.border = "none"
	//currentPage = document.paging.pageno.value;
	initTabButtons()
	if(obj.value == 'f' && data_arr.length>rowsPerPage){
		makeGridForPatient(0,rowsPerPage);
		//document.getElementById('pageno').value=1

		document.getElementById("current").innerHTML=1

		document.getElementById("currStart").innerHTML=1
		document.getElementById("totalRecs").innerHTML=10
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"

		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"
	}
	else if(obj.value == 'p'){
		if(start-rowsPerPage>=0){
			document.paging.lastpage.disabled= false;
			document.paging.nextpage.disabled= false;
			document.paging.lastpage.className="next"
			document.paging.nextpage.className="singleNext"
			if(start==rowsPerPage){
				document.paging.firstpage.disabled= true;
				document.paging.prevpage.disabled= true;
				document.paging.firstpage.className="previousDisable"
				document.paging.prevpage.className="singlePrevDisable"
			}
			else{
				document.paging.firstpage.disabled= false;
				document.paging.prevpage.disabled= false;
				document.paging.firstpage.className="previous"
				document.paging.prevpage.className="singlePrev"
			}
			makeGridForPatient(start-rowsPerPage,start);
			//document.getElementById('pageno').value--;
			document.getElementById("currStart").innerHTML=(document.getElementById("current").innerHTML-2)*10+1
				document.getElementById("totalRecs").innerHTML=(document.getElementById("current").innerHTML-1)*10
				document.getElementById("current").innerHTML--;

		}

	}
	else if(obj.value == 'n'){
		if(start+rowsPerPage*2<data_arr.length){
			makeGridForPatient(start+rowsPerPage,start+(rowsPerPage*2));

			//document.getElementById('pageno').value++;
			var tt=document.getElementById("current").innerHTML;

			document.getElementById("currStart").innerHTML=(tt)*10+1
				document.getElementById("totalRecs").innerHTML=((tt*1)+1)*10
			document.getElementById("current").innerHTML++;

			document.paging.firstpage.disabled= false;
			document.paging.prevpage.disabled= false;
			document.paging.firstpage.className="previous"
			document.paging.prevpage.className="singlePrev"

		}
		else if(start+rowsPerPage<data_arr.length){
			makeGridForPatient(start+rowsPerPage,data_arr.length);
			//document.getElementById('pageno').value++;
			document.getElementById("currStart").innerHTML=(document.getElementById("current").innerHTML)*10+1
				document.getElementById("totalRecs").innerHTML=data_arr.length
			document.getElementById("current").innerHTML++;
			document.paging.lastpage.disabled= true;
			document.paging.nextpage.disabled= true;
			document.paging.lastpage.className="nextDisable"
			document.paging.nextpage.className="singleNextDisable"

			document.paging.firstpage.disabled= false;
			document.paging.prevpage.disabled= false;
			document.paging.firstpage.className="previous"
			document.paging.prevpage.className="singlePrev"
		}
	}
	else if(obj.value == 'l'){
		if(data_arr.length % rowsPerPage == 0) {
			makeGridForPatient(data_arr.length - rowsPerPage, data_arr.length);
			//document.getElementById('pageno').value=totalPages;
			document.getElementById("currStart").innerHTML=data_arr.length-9
				document.getElementById("totalRecs").innerHTML=data_arr.length
			document.getElementById("current").innerHTML=totalPages
		} else {
			makeGridForPatient((data_arr.length - (data_arr.length % rowsPerPage)), data_arr.length);
			//document.getElementById('pageno').value=totalPages;
			//document.getElementById("currStart").innerHTML=data_arr.length-9
			document.getElementById("currStart").innerHTML=data_arr.length - (data_arr.length % rowsPerPage)+1;//added by govind 18-02-2017
				document.getElementById("totalRecs").innerHTML=data_arr.length
			document.getElementById("current").innerHTML=totalPages
		}
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"

		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"
	}
	if(!obj.disabled){
		obj.style.border = "none;"
	}
}

var sortNo;
function sortGrid(no,dir){
	document.paging.firstpage.disabled= true;
	document.paging.prevpage.disabled= true;
	document.paging.firstpage.className="previousDisable"
	document.paging.prevpage.className="singlePrevDisable"
	document.paging.lastpage.disabled= false;
	document.paging.nextpage.disabled= false;
	document.paging.lastpage.className="next"
	document.paging.nextpage.className="singleNext"
    sortNo = no;
    data_arr.sort(mysortfn)
        if(dir == 'dn'){
            data_arr.reverse();
        }

    if(data_arr.length<rowsPerPage)
  	  makeGridForPatient(0,data_arr.length)
  	else
	    makeGridForPatient(0,rowsPerPage)
    //document.getElementById('pageno').value=1
    document.getElementById("currStart").innerHTML=1
				document.getElementById("totalRecs").innerHTML=10
    document.getElementById("current").innerHTML=1
}




function goToPageForPatient(pageno){


	if( (pageno>totalPages) || (pageno<=0) || (pageno%1!=0) )
	{
	alert("Please Enter Correct Page No.")
	document.paging.pageno.value=""
	return false;
	}
	if(pageno == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"

		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"
	}
	else if(pageno == totalPages){

		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"

		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"
	}
	else{

		document.paging.firstpage.disabled= false;
		document.paging.prevpage.disabled= false;
		document.paging.firstpage.className="previous"
		document.paging.prevpage.className="singlePrev"

		document.paging.lastpage.disabled= false;
		document.paging.nextpage.disabled= false;
		document.paging.lastpage.className="next"
		document.paging.nextpage.className="singleNext"
	}
	if(pageno*rowsPerPage<data_arr.length){
	//alert("INside If")
		makeGridForPatient(pageno*rowsPerPage-rowsPerPage,pageno*rowsPerPage)
	}
	else
	{
	//alert("INside ELSE")
		makeGridForPatient(pageno*rowsPerPage-rowsPerPage,data_arr.length)
	}

		document.getElementById("currStart").innerHTML=(pageno-1)*10+1

		document.getElementById("totalRecs").innerHTML=(pageno)*10

		document.getElementById("current").innerHTML=pageno





}
/*Grid for Ward Mgmt. By VIKAS---------Ends*/



function makeGridForNextAllPatients(starter, end, tableId){
    totalPages = Math.ceil(data_arr.length/rowsPerPage);
    document.getElementById("total").innerHTML=totalPages
    document.getElementById("currEnd").innerHTML=data_arr.length
    if(totalPages==0){
	    document.getElementById(tableId).style.width = "100%"
    	document.getElementById(tableId).style.textAlign = "left"
        document.getElementById(tableId).innerHTML = ''
	    return;
    }
    else if(totalPages == 1){
		document.paging.lastpage.disabled= true;
		document.paging.nextpage.disabled= true;
		document.paging.lastpage.className="nextDisable"
		document.paging.nextpage.className="singleNextDisable"
    }
   
    var patientStatus="";
    if(document.getElementById("patientStatus"))
    	patientStatus = document.getElementById("patientStatus").value;  //Added By Om Tripathi 11/08/2017
    var VisitId = "";
    if(document.getElementById("VisitId"))
    	VisitId =	document.getElementById("VisitId").value; 
    var uhidNum ="";
    if(document.getElementById("uhidNum"))
    	uhidNum = document.getElementById("uhidNum").value;
    
    start = starter;
    if(data_header){
                tempTable = '<table border="0" cellspacing="0"  cellpadding="0" width="100%"><thead><tr>'
        for(cols=0;cols<data_header.length;cols++){
            if(data_header[cols][1]=="data"){
                tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            }
            else if(data_header[cols][1]=="hide"){
                    tempTable += '<th class="hide">&nbsp;</th>'
            }else if(data_header[cols][1]=="radio"){
            		 tempTable += '<th width="';
                if(data_header[cols][2]!=0)
                    tempTable +=  data_header[cols][2];
                tempTable += '">'+data_header[cols][0]+'</th>'
            	}
        }
        tempTable += '<tr></thead><tbody id="searchresulttable">'
        for(rows=start;rows<end; rows++){
	        	var colorVar="";
	        	 if(formName=="opd_OP_Clinic_Waiting_PatientList"){
	        		 if(data_arr[rows][9]=='1'){
		            	colorVar="background-color: #FE5A4C";
	        		 }else if(data_arr[rows][9]=='2'){
		            	colorVar="background-color: #9CCB19";
		             }else {
		            	 if(data_arr[rows][8]=='1')
			            		colorVar="background-color: #FFF0F5";
			            	if(data_arr[rows][8]=='2')
			            		colorVar="background-color: #F5F5DC";
			            	if(data_arr[rows][8]=='3')
			            		if(data_arr[rows][11]=='Y'){
			         				colorVar="background-color: #FFE4C4"; 
				        		 }
			            		else
			            		colorVar="background-color: #ADD8E6";	
		             }             
	            	tempTable += '<tr id="'+data_arr[rows][0]+'" style="'+colorVar+'" class="'
	            }else{
	            	tempTable += '<tr id="'+data_arr[rows][0]+'" class="'
	            }
                if(rows%rowsPerPage == 0 && rows != 0){
					currentColor = "odd"
				}
                tempTable += currentColor;
				currentColor = (currentColor == "odd")?"even" : "odd";
                tempTable += '">'
                for(columns=1;columns<=data_header.length;columns++){
                    tempTable += '<td '
                    if(data_header[columns-1][1] == "hide")
                        tempTable += 'class="hide"';
                    tempTable +='>'
                    if(formName=="opdPatientVisit" || formName=="prevOpdPhysiotherapyForm"){
                     	tempTable += '<a href="javascript:Request(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\')">';
                    }
                    else if(formName=="opd_OP_Clinic_Waiting_PatientList"){
                    	if(data_header[columns-1][0]!="Skip Reason")
                    		tempTable += '<a href="javascript: if(checkForCounter()){RequestForToken(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\',\''+rows+'\',\''+data_arr[rows][2]+'\', document.getElementById(\'skip'+rows+'\'))}">';
                    }else if(formName=="opd_OP_Clinic_Waiting_PatientList_new"){
                    	if(data_header[columns-1][0]!="Skip Reason")
                     	tempTable += '<a href="javascript: if(checkForCounter()){openOpdLite(\''+data_arr[rows][0]+'\' ,\''+rows+'\', document.getElementById(\'skip'+rows+'\'))}">';
                    } else if(formName=="opd_OP_Clinic_Waiting_PatientList_new_detail"){
                    	if(data_header[columns-1][0]!="Skip Reason")
                     	tempTable += '<a href="javascript: if(checkForCounter()){openDetail(\''+data_arr[rows][0]+'\',\''+rows+'\', document.getElementById(\'skip'+rows+'\'))}">';
                    }else if(showOnSamePage){
                    	if(formName!="nursingCareEntryDetail" && formName != "patientList"  && formName!='opd_OP_Clinic_Waiting_PatientList_new'){
                    	tempTable += '<a href="javascript:editRecord(document.getElementById(\''+data_arr[rows][0]+'\'),\''+formName+'\')">';
                    	}
               		}
                    else if(addAction)
                    	tempTable += '<a href="'+ goToUrl +'&id='+data_arr[rows][0]+'">';

                    else
                    	tempTable += '<a href="'+ goToUrl +'&'+data_arr[rows][0]+'.action">';

                    tempTable +=data_arr[rows][columns]
                    tempTable +='</a></td>'
                }
               tempTable += '</tr>'
        }
        tempTable += '</tbody></table>'

        document.getElementById(tableId).innerHTML = tempTable;
    }

    if(document.paging.pageno.value == 1){
		document.paging.firstpage.disabled= true;
		document.paging.prevpage.disabled= true;
		document.paging.firstpage.className="previousDisable"
		document.paging.prevpage.className="singlePrevDisable"

    }
}









