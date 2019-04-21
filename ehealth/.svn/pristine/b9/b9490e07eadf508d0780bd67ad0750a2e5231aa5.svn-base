<%@page import="jkt.hms.masters.business.MasInstructionMaster"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.RouteOfAdministration"%>
<%@page import="jkt.hms.masters.business.OpdInstructionTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.URL"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="java.util.Properties"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@page import="java.math.BigDecimal"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/addRow.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script> 
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
	
	var icdArray=new Array(); 
	var brandArray=new Array();
	var allergyTypeArray=new Array();
	var saverityCodeArray=new Array();
	var stockValueArray=new Array();
	var stockItemIdArray=new Array();
	
</script>
<div class="titleBg">
	<h2>DISPENSING DETAILS</h2>
</div>
<form name="patientDrugIssue" method="post" action="">
	<div class="clear"></div>

	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
	int deptId = 0;
	int hospitalId = 0;
	String patientIssueNo="";
	boolean lastPrescripitionBasedDispensing=false;
	 Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	PatientPrescriptionHeader prescriptionHeader = new PatientPrescriptionHeader();
	Set<PatientPrescriptionDetails> prescriptionDetailsSet = new HashSet<PatientPrescriptionDetails>();
	List<StoreItemBatchStock>itemBatchStockList = new ArrayList<StoreItemBatchStock>();
	List<RouteOfAdministration> routeOfAdministrationList = new ArrayList<RouteOfAdministration>();
	List<Visit> patientVisitList=new ArrayList<Visit>();
	List<MasFrequency> frequencyList = new ArrayList<MasFrequency>();
	List<OpdInstructionTreatment> masInstructionMasterList = new ArrayList<OpdInstructionTreatment>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}   
	if(map.get("visitList") != null){
		patientVisitList = (List<Visit>)map.get("visitList");
	} 
	if(map.get("patientPrescriptionHeader") != null){
		prescriptionHeader = (PatientPrescriptionHeader)map.get("patientPrescriptionHeader");
	}
	if(map.get("frequencyList") != null){
		frequencyList = (List)map.get("frequencyList");
	}
	if(map.get("routeOfAdministrationList") != null){
		routeOfAdministrationList = (List)map.get("routeOfAdministrationList");
	}
	
	if(map.get("masInstructionMasterList") != null){
		masInstructionMasterList = (List)map.get("masInstructionMasterList");
	}
	if(map.get("itemBatchStockList") != null){
		itemBatchStockList = (List)map.get("itemBatchStockList");
	}
	
	Visit visit = new Visit();
	if(patientVisitList != null) {
		visit = (Visit) patientVisitList.get(0);
	}
	if(prescriptionHeader!=null){
		prescriptionDetailsSet=prescriptionHeader.getPatientPrescriptionDetails();
	} 
	 int visitId=0;
	String regNo="";
	String ptName="";
	String lastName="";
	String age="";
	String sex="";
	String diagnosis="";
	String department="";
	String patType="";
	String doctorName="";
	if(visit.getDoctor()!=null && visit.getDoctor().getEmployeeName()!=null){
		 doctorName=visit.getDoctor().getEmployeeName();
	} 
	regNo=visit.getHin().getHinNo();
	visitId=visit.getId();
	if(visit.getHin().getPatientType()!=null){
		 patType=visit.getHin().getPatientType().getPatientTypeName();
	}
	
	
	if(visit.getHin().getPLastName()!=null){
		lastName=visit.getHin().getPLastName();
	}
	ptName=visit.getHin().getPFirstName()+" "+lastName;
	if(visit.getHin().getAge()!=null){
		age=visit.getHin().getAge();	
	}
	
	if(visit.getHin().getSex()!=null){
	sex=visit.getHin().getSex().getAdministrativeSexName();
	}
	if(visit.getDiagnosis()!=null){
		diagnosis=visit.getDiagnosis().getDiagnosisConclusionName();
	}else{
		diagnosis="-";
	}
	if(visit.getDepartment()!=null){
		department=visit.getDepartment().getDepartmentName();
	} 
	List<Object[]> patientPrescriptionDetailList = new ArrayList<Object[]>();
	if(map.get("patientPrescriptionDetailList") != null){
		patientPrescriptionDetailList = (List<Object[]>)map.get("patientPrescriptionDetailList");
	}
	%>
	<div class="Block"> 
		<div class="clear"></div>
		<input type="hidden" name="visitId" id="visitId"
			value="<%=visit.getId()%>" /> <input type="hidden" name="deptId"
			value="<%=deptId%>" /> <input type="hidden" name="hospitalId"
			value="<%=hospitalId%>" /> <input type="hidden" name="hinId"
			value="<%= visit.getHin().getId() %>" /> <input type="hidden"
			name="<%=ISSUE_ID%>" id="issueId" value="" /> <input type="hidden"
			size="2" value="0" name="noOfRecords" id="noOfRecords" /> <label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>

		<label class="value"><%=regNo %></label> <label> Patient Name</label>
		<label class="value"><%=ptName %></label> <label> Age</label> <label
			class="value"><%=age %></label>

		<div class="clear"></div>

		<label> Doctor</label> <label class="value"><%=doctorName %></label> <label>
			Department</label> <label class="value"><%=department %></label> <label>
			Patient Type</label> <label class="value"><%=patType %></label>
		<div class="clear"></div>
		<%-- <label> Visit No./Date</label> 
		<select onchange="submitProtoAjaxWithDivName('patientDrugIssue','stores?method=getAllPrescription','testDiv');" name="visitIdNo">
		<option value="-1">Select</option>
		<%for(Visit vn:patientVisitList){%>
			
			<option value="<%=vn.getId()%>"><%=vn.getVisitNo()+"["+HMSUtil.changeDateToddMMyyyy(vn.getVisitDate())+"]"%></option> 
		<%}%> 
		</select> --%>
		<div class="clear"></div>
		<label><span>*</span> Diagnosis</label> <input type="text" value=""
			tabindex="1" id="icd" name="icd"
			onblur="fillDiagnosisCombo(this.value);" validate="required" />
		<div id="ac2update22" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update22','opd?method=getICDList',{parameters:'requiredField=icd'});
	</script>
		<select name="<%=DIAGNOSIS_ID%>" tabindex="1" multiple="4" size="5"
			id="diagnosisId" class="listBig" validate="diagnosisId,string,no">
		</select>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<div class="floatLeft">
		<input type="button" class="buttonDel" tabindex="1" value=""
			onclick="removeRow();" /> <input type="button" class="buttonAdd"
			tabindex="1" onclick=" addRow();" value="" />
	</div>  
	<div class="clear"></div>
	<%//if(patientPrescriptionDetailList.size()>0){ %>
	<div class="cmntable">
		<table border="0" align="center" cellpadding="0" cellspacing="0"
		id="grid">
		<tr>
			<th scope="col">&nbsp;</th>
			<th scope="col">Item Name</th>
			<th scope="col">Batch No.</th>
			<th scope="col">Stock Qty.</th>
			<th scope="col">Dosages</th>
			<th scope="col">Unit</th>
			<th scope="col">Frequency</th>
			<!-- <th scope="col">No of Days</th> -->
			<th scope="col">Duration</th>
			<th scope="col">Instruction</th>
			<th scope="col">Route</th>
			<th scope="col">Issue Qty.</th>
			<th scope="col">Remark</th>

		</tr>
		<%
		 	int incr = 1;
		
 			//for(Object[] prescriptionDetails:patientPrescriptionDetailList){
						 
		%>
		 
		<tr>
			<td><input type="checkbox" class="radioCheck" id="itemRadio1"
				name="itemRadio1" />
				<input type="hidden" id="prescriptionDetailId<%=incr%>"
				name="prescriptionDetailId<%=incr%>" value=""></input>
			</td>
			<td><input type="text"  tabindex="1" id="nomenclature<%=incr%>" size="35" name="nomenclature<%=incr%>" value="" onblur="checkForDefectiveDrugs(this.value, 'nomenclature','<%=incr %>');"/> 
				<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-10">
			new Ajax.Autocompleter('nomenclature<%=incr %>','ac2update','stores?method=getItemListForOtc',{minChars:1,parameters:'requiredField=nomenclature<%=incr%>'});
			</script>
			</td>
					<%-- <%
					Set<StoreItemBatchStock>itemBatchStockSet= new HashSet<StoreItemBatchStock>();
					itemBatchStockSet = (Set<StoreItemBatchStock>)prescriptionDetails[11];
					if(itemBatchStockSet.size()>0){
					for(StoreItemBatchStock batchStock:itemBatchStockSet){
						if(batchStock.getDepartment().getId()==deptId){%>  
						
					<%}}}%> --%>
			<td><select name="itemBatchNo<%=incr%>" id="itemBatchNoId<%=incr%>" onchange="getClosingStock(this.value,<%=incr%>);">
					<option value="">Select</option>
				 <%-- <%
					
					if(itemBatchStockList.size()>0){
					for(StoreItemBatchStock batchStock:itemBatchStockList){
						//System.out.println("item=11="+batchStock.getItem().getId());
						//System.out.println("sssss=11="+prescriptionDetails[0]);
						if(batchStock.getItem().getId().equals(prescriptionDetails[0])){  
						%>
						<option value="<%=batchStock.getBatchNo()+"-"+batchStock.getId()+"-"+batchStock.getClosingStock()%>"><%=batchStock.getBatchNo()%></option> 
						
					<%}}}%>   --%>
				</select></td> 
			<td><input type="hidden" id="drugItemId<%=incr%>" name="drugItemId<%=incr%>" value=""></input>
				<input type="hidden" id="stockItemBatchStockId<%=incr%>" name="stockItemBatchStockId<%=incr%>"></input>
				 <input type="text" readonly="readonly" class="small" size="10" maxlength="45" tabindex="1" id="stockQtyId<%=incr%>" name="stockQty<%=incr%>"></input>
			</td> 
			<td><input class="small" type="text" name="dosage<%=incr%>" id="dosage<%=incr%>" tabindex="1" size="5" value="" onblur="fillValue(<%=incr%>);"/>
			</td>
			<td><input type="text" name="unit<%=incr%>" class="small"
				id="unit<%=incr%>" readonly="readonly" size="5" value=""/>
			</td>
			<td> 
			<%-- <input type="text" tabindex="1" id="frequency<%=incr%>"  name="frequency<%=incr%>" readonly="readonly" value="" class="small" size="5"/> --%>
			<select style="width: 70px;" name="frequency<%=incr%>" id="frequency<%=incr%>" tabindex="1" onblur="fillValue(<%=incr%>);" onchange="displaFrequency(this,<%=incr%>);">
								<option value="0">Select</option>
								<%
				  if(frequencyList.size()>0){
			      for(MasFrequency masFrequency : frequencyList){
			       
	          %>
								<option id="<%=masFrequency.getFrequencyType() %>" value="<%=masFrequency.getId() %>"><%=masFrequency.getFrequencyName()%></option>
								<%}} %>
						</select>
						<%
		    		MasFrequency  masFrequency3 = new MasFrequency();

				         for (int i = 0; i < frequencyList.size(); i++) {
				        	 masFrequency3 = (MasFrequency) frequencyList.get(i);
	     			 %> <script>
		          icdArray[<%=i%>]= new Array();
		          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
		          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
	            </script> <% }%></td>
				   
			<td>
			<div style="width:100px; float: left;">
			<input type="text" name="noOfDays<%=incr%>" id="noOfDays<%=incr%>" class="small" tabindex="1"  value="" onblur="fillValue(<%=incr%>);"  size="5"/>
			<p style="line-height:0px;" id="frequencyType<%=incr %>" ></p>
			</div>
			
			</td>
			<td>
			<%-- <input type="text" name="instrunction<%=incr%>" id="instrunction<%=incr%>" class="small" tabindex="1" readonly="readonly" value="" size="5"/> --%>
			<select style="width: 70px;" name="instruction<%=incr%>"
							id="instruction<%=incr%>"><option value="0">Select</option>
								<%
					for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
					{
		
		
		          %>
								<option value="<%=instructionTreatment.getId() %>"><%=instructionTreatment.getOpdInstructionTreatmentName()%></option>
								<%
					}
					%>
						</select> 
						<script type="text/javascript">	var	instructionArray= new Array();
              <%
              OpdInstructionTreatment  instructionMaster = new OpdInstructionTreatment();
			     for (int k = 0; k < masInstructionMasterList.size(); k++) {
			    	 instructionMaster = (OpdInstructionTreatment) masInstructionMasterList.get(k);
     			 %> 
     			instructionArray[<%=k%>]= new Array();
     			instructionArray[<%=k%>][0] = "<%=instructionMaster.getId()%>";
     			instructionArray[<%=k%>][1] = "<%=instructionMaster.getOpdInstructionTreatmentName()%>";
     			<% }%> 
            </script>
			</td>
				 
			<td>
				<%-- <input type="text" name="route<%=incr%>" id="route<%=incr%>" class="small" tabindex="1"  value="" readonly="readonly" size="5"/> --%>
				<select name="route<%=incr%>" id="route<%=incr%>"style="width: 70px;">
								<option value="0">Select</option>
								<%
					      for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
					    
			          %>
								<option value="<%=routeOfAdministration.getId() %>"><%=routeOfAdministration.getRouteName()%></option>
								<%
					}%>
						</select>
						<script type="text/javascript">	var	routeArray= new Array();
		              <%
			    		RouteOfAdministration  route = new RouteOfAdministration();
					     for (int k = 0; k < routeOfAdministrationList.size(); k++) {
					    	 route = (RouteOfAdministration) routeOfAdministrationList.get(k);
		     			 %> 
		     			routeArray[<%=k%>]= new Array();
		     			routeArray[<%=k%>][0] = "<%=route.getId()%>";
		     			routeArray[<%=k%>][1] = "<%=route.getRouteName()%>";
	     				<% }%> 
            </script>
			  
			</td>
				  
					<td>
				
					<input type="text" name="total1" id="total1" size="5"
							class="small" validate="Total,num,no" value=""/> <input
							type="hidden" name="pvmsNo<%=incr%>" id="pvmsNo<%=incr%>"
							size="10" value="" /></td>
					<td><input type="text" name="remark<%=incr%>"></input></td>
				
		</tr> 
	<%//} %>	
	</table>
	</div>
	<input type="hidden" name="hdb" value="1" id="hdb" />

<%-- <%}else{%>
		<h2><span>No Record Found</span></h2>
<%}%>
	 --%>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<input type="hidden" name="totalNumberOfPrescription"
		id="totalNumberOfPrescriptionId" /> <input type="button"
		name="Submit11" class="button" value="Submit"
		onclick="if(checkIssueQtyWithStock(<%=1%>)){submitForm('patientDrugIssue','stores?method=submitOTCDirectDispensing');}" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<div class="paddingTop40"></div>
	<div class="bottom">
		<div class="clear"></div>
		<div class="clear"></div>
	</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script type="text/javascript">

//added by amit das on 04-04-2017
function displaFrequency(i,incr){
	var frequencyType = i.options[i.selectedIndex].id;
	document.getElementById('frequencyType'+incr).innerHTML = frequencyType;
}

function checkForDefectiveDrugs(val,a,inc)
{
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
		ajaxFunctionForAutoCompleteInOtc('patientDrugIssue','stores?method=fillItemsForOtcDrugs&pvmsNo=' + pvms, inc);
		
}  
function ajaxFunctionForAutoCompleteInOtc(formName,action,rowVal) {

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

	      //	var brandId="brandId"+rowVal;
	      	var batchId="itemBatchNoId"+rowVal;
	      //	var batchName ="batchName"+rowVal;
	      //	alert(batchName);
		//	obj1 =document.getElementById(brandId);
			obj = document.getElementById(batchId);
			//obj1 = document.getElementById(batchName);
			obj.length = 1;
			//obj1.length =1;

	      	for (loop = 0; loop < items.childNodes.length; loop++) {
		   	    var item = items.childNodes[loop];
		      
		         var batchLength  = item.getElementsByTagName("batchs")[0];
		         var msg  = item.getElementsByTagName("msg")[0];
		         var unit  = item.getElementsByTagName("unit")[0];
		         var itemId  = item.getElementsByTagName("itemId")[0];
		     //alert("batchLength===="+batchLength);  
		if(batchLength !=undefined ){
	        	for(innerLoop = 0;innerLoop < batchLength.childNodes.length;innerLoop++)
	        	{
	        		var batch = batchLength.childNodes[innerLoop];
	        		//alert("batch==="+ batch.getElementsByTagName("batchId")[0]);
		        	var batchId  = batch.getElementsByTagName("batchId")[0];
		        	var batchName  = batch.getElementsByTagName("batchName")[0];
		        	var closingStock = batch.getElementsByTagName("closingStock")[0];
		        	obj.length++;
					obj.options[obj.length-1].value=batchId.childNodes[0].nodeValue;
					obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
					//obj.options[obj.length-1].text=batchName.childNodes[0].nodeValue;
					
					
	        	}
		}
	        	 /* if(msg !=undefined && msg.childNodes[0] !=undefined){
					   alert(msg.childNodes[0].nodeValue);
				} */
	        	 if(unit.childNodes[0] != undefined){
			        	document.getElementById('unit'+rowVal).value = unit.childNodes[0].nodeValue
			         }
	        	 if(itemId.childNodes[0] != undefined){
			        	document.getElementById('drugItemId'+rowVal).value = itemId.childNodes[0].nodeValue
			         }

	        	/* for(innerLoop = 0;innerLoop < brandLength.childNodes.length;innerLoop++){
	        		var brand = brandLength.childNodes[innerLoop];
		        	var brandId  = brand.getElementsByTagName("brandId")[0];
		        	var brandName  = brand.getElementsByTagName("brandName")[0];

		        	obj1.length++;
					obj1.options[obj1.length-1].value=brandId.childNodes[0].nodeValue;
					obj1.options[obj1.length-1].text=brandName.childNodes[0].nodeValue;

	        	}*/

	      	}
	      }
	    }
	    var url=action+"&"+getNameAndData(formName);
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);


	  }
function getClosingStock(batchId,rowVal){
	 

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
		   	   
		        var stockAvailable  = item.getElementsByTagName("stockAvailable")[0];
		       
		          if(stockAvailable.childNodes[0] != undefined){
		        	document.getElementById('stockQtyId'+rowVal).value = stockAvailable.childNodes[0].nodeValue
		          }
		         
	      	} 
	      }
	    }
	     url="stores?method=getclosingStock&batchId="+batchId;
 	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    
	 }

function checkIssueQtyWithStock(){
	var tbl = document.getElementById('grid'); 
	document.getElementById('totalNumberOfPrescriptionId').value=tbl.rows.length-1;
	for(var i=1;i<=tbl.rows.length-1;i++){
		var stockQtyValue=document.getElementById('stockQtyId'+i).value;
		var issueQtyValue=parseInt(document.getElementById('total'+i).value);
		 if(issueQtyValue<=0){
			alert("Issue quantity should be more than zero");
			return false;
		}
		 else if(stockQtyValue<issueQtyValue){
			alert("Issue quantity should be more than stock quantity");
			return false;
		}
	}  
	return true;
}
function notAvailable(rowVal)
{
	
	var hinId=0;
 var prescriptionDetailsId=document.getElementById("presId"+rowVal).value;
 var itemId=document.getElementById("itemId"+rowVal).value;
	var prescriptionNo=document.getElementById("prescriptionId"+rowVal).value;
	hinId=prescriptionNo;
	
	alert("prescriptionDetailsId--"+prescriptionDetailsId+"itemId--"+itemId+"prescriptionNo-----"+prescriptionNo);
	var x = document.getElementById("notAvailable1"+rowVal).checked;
	//alert("value of x--"+ x);
	if(x==true){
		alert("true");
		submitProtoAjax('patientDrugIssue','stores?method=setNotAvailable&itemId='+itemId+'&prescriptionDetailsId='+prescriptionDetailsId+'&prescriptionNo='+prescriptionNo+'&hinId='+hinId);
	} 
		
	
	//var url="/hms/hms/stores?method=setNotAvailable&itemId="+itemId+"&presId="+presId;
	
	
	}
	
function referToEmpanneled(rowVal)
{
	
	var hinId=0;
	 var prescriptionDetailsId=document.getElementById("presId"+rowVal).value;
	 var itemId=document.getElementById("itemId"+rowVal).value;
		var prescriptionNo=document.getElementById("prescriptionId"+rowVal).value;
		hinId=prescriptionNo;
		
		alert("prescriptionDetailsId--"+prescriptionDetailsId+"itemId--"+itemId+"prescriptionNo-----"+prescriptionNo);
		var x = document.getElementById("referToEmpanneled1"+rowVal).checked;
		//alert("value of x--"+ x);
		if(x==true){
			alert("true");
			submitProtoAjax('patientDrugIssue','stores?method=setForEmpanelled&itemId='+itemId+'&prescriptionDetailsId='+prescriptionDetailsId+'&prescriptionNo='+prescriptionNo+'&hinId='+hinId);
		} 
	
	
	}

function addRow(){

	  var tbl = document.getElementById('grid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration;
	  
	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.name='itemRadio'+iteration;
	  e1.id='itemRadio'+iteration;
	  e1.className='radioCheck';
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='nomenclature'+iteration;
	  e1.id='nomenclature'+iteration;
	  e1.className="opdgridText";
	  e1.onblur=function(){checkForDefectiveDrugs(this.value,'nomenclature',iteration);};
	  e1.size='35';
	  
      
	  cellRight1.appendChild(e1);
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight1.appendChild(newdiv);
	  new Ajax.Autocompleter('nomenclature'+iteration,'ac2updates'+iteration,'stores?method=getItemListForOtc',{minChars:1,parameters:'requiredField=nomenclature'+iteration+'&counter='+iteration});


	  /* var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='brandId'+iteration;
	  e1.id='brandId'+iteration;
	  cellRight1.appendChild(e1);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='manufactureId'+iteration;
	  e1.id='manufactureId'+iteration;
	  cellRight1.appendChild(e1); */
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='pvmsNo'+iteration;
	  e1.id='pvmsNo'+iteration;
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(2);
	  var e1 = document.createElement('Select');
	  e1.name='itemBatchNo'+iteration;
	  e1.id='itemBatchNoId'+iteration; 
	  e1.options[0] = new Option('Select', '');    
	  e1.onchange=function() { getClosingStock(this.value,iteration);};
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(3);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='stockQty'+iteration;
	  e1.id='stockQtyId'+iteration;
	  e1.className="small";
	  e1.size='10';
	  e1.maxlength='45';
	  e1.tabindex='1';
	  e1.readOnly='readOnly'; 
	  cellRight1.appendChild(e1);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='drugItemId'+iteration;
	  e1.id='drugItemId'+iteration;
	  cellRight1.appendChild(e1);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='stockItemBatchStockId'+iteration;
	  e1.id='stockItemBatchStockId'+iteration;
	  cellRight1.appendChild(e1);
	  
	  
	  var cellRight1 = row.insertCell(4);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='dosage'+iteration;
	  e1.id='dosage'+iteration;
	  e1.className="small";
	  e1.size='10';
	  e1.maxlength='45';
	  e1.tabindex='1';
	  e1.validate="dosage"+iteration+",int,yes";
	  e1.onblur=function() {fillValue(iteration); };  
	  cellRight1.appendChild(e1);
	 
	  var cellRight1 = row.insertCell(5);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='unit'+iteration;
	  e1.id='unit'+iteration;
	  e1.className='small';
	  e1.readOnly='readOnly';
	  e1.size='5';
	  e1.tabindex='1';
	  e1.onblur=function(){fillValue(this.value,iteration);};
	  cellRight1.appendChild(e1);
	  
	  
	  var cellRight1 = row.insertCell(6);
	  var e1 = document.createElement('Select');
	  e1.name='frequency'+iteration;
	  e1.id='frequency'+iteration;
	  e1.style.width = "70px";
	  e1.options[0] = new Option('Select', '0'); 
	   for(var i = 0;i<icdArray.length;i++ ){
	      e1.options[icdArray[i][0]] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  e1.onblur=function() { fillValue(iteration);};
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(7);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='noOfDays'+iteration;
	  e1.className="small";
	  e1.id='noOfDays'+iteration;
	  e1.size='3';
	  e1.onblur=function() {fillValue(iteration); };  
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(8);
	  var e1 = document.createElement('Select');
	  e1.name='instruction'+iteration;
	  e1.id='instruction'+iteration;
	  e1.style.width = "70px";
	  e1.options[0] = new Option('Select', '0');
	  for(var i = 0;i<instructionArray.length;i++ ){
	      e1.options[instructionArray[i][0]] = new Option(instructionArray[i][1],instructionArray[i][0]);
	      }	
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(9);
	  var e1 = document.createElement('Select');
	  e1.name='route'+iteration;
	  e1.id='route'+iteration;
	  e1.style.width = "70px";
	  e1.options[0] = new Option('Select', '0');
	  for(var i = 0;i<routeArray.length;i++ ){
		e1.options[routeArray[i][0]] = new Option(routeArray[i][1],routeArray[i][0]);
	  }
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(10);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='total'+iteration;
	  e1.id='total'+iteration;
	  e1.className="small";
	  e1.readOnly='readOnly';
	  e1.size='5';
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(11);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='remark'+iteration;
	  e1.id='remark'+iteration; 
	  cellRight1.appendChild(e1); 
	}
function  fillValue(inc2){
    var freq=document.getElementById('frequency'+inc2).value;
    var noOfDays=document.getElementById('noOfDays'+inc2).value;
    var dosage=document.getElementById('dosage'+inc2).value;
    document.getElementById('total'+inc2).value=freq*dosage*noOfDays;
}
	function removeRow ()
	{
		var tbl = document.getElementById('grid');
		  var lastRow = tbl.rows.length;
		  var hdb = document.getElementById('hdb');
		  var iteration = parseInt(hdb.value);
		  var totalSelected=0;
		  for(var i=1;i<=iteration;i++)
			  {
			  if(document.getElementById("itemRadio"+i)!=null && (typeof  document.getElementById("itemRadio"+i).checked)!='undefined' && document.getElementById("itemRadio"+i).checked )
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
		    		  if(document.getElementById("itemRadio"+i)!=null && (typeof  document.getElementById("itemRadio"+i).checked)!='undefined' && document.getElementById("itemRadio"+i).checked )
		    		  {
		    		  var deleteRow= document.getElementById("itemRadio"+i).parentNode.parentNode;
		    		  document.getElementById("itemRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
		    		  }
		    	  }
		  }
	}
	 
	
	function populatePVMS(val,inc){
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvmsNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var brandName=val.substring(0,indexForBrandName);
		    
		    var itemIndex1 = val.lastIndexOf("(");
		    var itemIndex2 = val.lastIndexOf(")");
		    var itemId= val.substring(itemIndex1+1,itemIndex2);

		  if(pvmsNo == "")
		  {
		   	document.getElementById('nomenclature'+inc).value="";
		    document.getElementById('pvmsNo'+inc).value="";
		    document.getElementById('dosage'+inc).value="";
		    document.getElementById('noOfDays'+inc).value="";
		    document.getElementById('unit'+inc).value="";
		    document.getElementById('drugItemId'+inc).value=itemId;
		    
		   return;
		   }
		   else
			   {
		      document.getElementById('pvmsNo'+inc).value=pvmsNo;
		      document.getElementById('dosage'+inc).value=1;
		      document.getElementById('noOfDays'+inc).value=1;
		      document.getElementById('drugItemId'+inc).value=itemId;
		      
		      new Ajax.Request('stores?method=getItemUnitDetail&pvmsNo='+pvmsNo+'&itemId='+itemId+'&'+csrfTokenName+'='+csrfTokenValue, {
		    	  onSuccess: function(response) {
		    	      if(response.responseText.trim()!='')
		    	    	  { 
		    	    	  var unitAndStock=response.responseText.split("/"); 
		    	    	  document.getElementById('unit'+inc).value=unitAndStock[0];
		    	    	  if(unitAndStock[1]!=null && unitAndStock[1]!=""){
		    	    		  var batch=unitAndStock[1].split(","); 
		    	    		  var e=document.getElementById('itemBatchNoId'+inc);
		    	    		  for(var r=e.length;r>0;r--){
		    	    			  e.remove(r);
		    	    		  }
		    	    		  for(var i = 0;i<batch.length-1;i++ ){ 
		    	    			  var option=document.createElement('option');
		    	    			  option.value=i;
		    	    			  option.text=batch[i];
		    	    				e.add(option);
		    	    			  }  
		    	    	  }if(unitAndStock[2]!=null && unitAndStock[2]!=""){ 
		    	    		  stockValueArray=unitAndStock[2].split(",");  
		    	    	  }if(unitAndStock[3]!=null && unitAndStock[3]!=""){
		    	    		  stockItemIdArray=unitAndStock[3].split(",");  
		    	    	  }
		    	    	  }
		    	  }
		    	});
		 }
		}
		else
			{
			document.getElementById('nomenclature'+inc).value="";
		    document.getElementById('pvmsNo'+inc).value="";
		    document.getElementById('dosage'+inc).value="";
		    document.getElementById('noOfDays'+inc).value="";
		    document.getElementById('unit'+inc).value="";
		    }
	}
	
	function checkItem(cnt){

		
		var tbl = document.getElementById('grid');
		var lastRow = tbl.rows.length;
		var iteration = lastRow-1;

		//var pvmsNo=document.getElementById("pvmsNo"+iteration).value
		var visitId=document.getElementById("visitId").value
		var nomenclature = document.getElementById("nomenclature"+cnt).value
		 var index1 = nomenclature.lastIndexOf("[");
	    var indexForBrandName=index1;
	    var index2 = nomenclature.lastIndexOf("]");
	    	index1++;

	    var pvmsNo = nomenclature.substring(index1,index2);

		if(pvmsNo !=""){

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
			        var bedStatus  = item.getElementsByTagName("bedStatus")[0];
		    	      if(bedStatus.childNodes[0].nodeValue=='yes'){
			        alert("This Drug is Alergic for this patient..!")
			       	document.getElementById("nomenclature"+iteration).value = ""
			       	document.getElementById("pvmsNo"+iteration).value= ""
			       	pvmsNo=pvmsNo.childNodes[0].nodeValue
			       return true
			       }else{
			       	document.getElementById("visitId").selectedIndex=0
			        pvmsNo=0
			       	return false;
			       }

		      	}
		      }
		      }
		    var url="/hms/hms/opd?method=checkItem&pvmsNo="+pvmsNo+"&visitId="+visitId;
    	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016

		    xmlHttp.open("GET",url,true);
		    xmlHttp.setRequestHeader("Content-Type", "text/xml");
		    xmlHttp.send(null);
		}
		}
	
	
	
	function fillDiagnosisCombo(val) {

	  	  var index1 = val.lastIndexOf("[");
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var id = val.substring(index1,index2);
		    //alert("function called---"+id)
		    if(id ==""){
			  return;
			}else{
			   obj =document.getElementById('diagnosisId');
					obj.length = document.getElementById('diagnosisId').length;
		        	obj.length++;
					obj.options[obj.length-1].value=id
					obj.options[obj.length-1].text=val
					obj.options[obj.length-1].selected=true
					document.getElementById('icd').value ="" 	
			}

	  }
	
	function copyToPrescriptionTAb(incr)
	{	
		if(incr > 1 && document.getElementById("nomenclature"+incr).value!="" ){
				document.getElementById('pTabhdb').value=document.getElementById('hdb').value-1;
				var tbl1 = document.getElementById('grid');
				var tbl2 = document.getElementById('prescriptionTabGrid');
				var lastRow1 = tbl1.rows.length;
				var lastRow2 = tbl2.rows.length;
				if(lastRow1>lastRow2){
					addRowPrescriptionTab();
				}
		}	
		document.getElementById("nomenclaturepTab"+incr).value=document.getElementById("nomenclature"+incr).value;
		document.getElementById("dosagepTab"+incr).value=document.getElementById("dosage"+incr).value;
		document.getElementById("unitpTab"+incr).value=document.getElementById("unit"+incr).value;
		document.getElementById("noOfDayspTab"+incr).value=document.getElementById("noOfDays"+incr).value;
		document.getElementById("routepTab"+incr).value=document.getElementById("route"+incr).value;
	}
	
	function getItemStockValue(value,inc){
		var unitAndStock=value.split("-");  
		if(value==-1){
			document.getElementById('stockQtyId'+inc).value=0.00;
			document.getElementById('stockItemBatchStockId'+inc).value=0.00;
		}else{
			document.getElementById('stockQtyId'+inc).value=unitAndStock[2];
			document.getElementById('stockItemBatchStockId'+inc).value=unitAndStock[1];
		}
		
	}  	 

 	</script>