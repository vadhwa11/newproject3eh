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
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calender.js" type="text/javascript"></script>

<link href="/hms/jsp/css/css/jquery-ui.css" rel="stylesheet" />
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/ipd.js"></script>
<script>jQuery.noConflict();</script>


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
	<div class="Block">

	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
	int deptId = 0;
	int hospitalId = 0;
	String patientIssueNo="";
	 Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	} 
	List<Visit> patientVisitList=new ArrayList<Visit>();
	if(map.get("visitList") != null){
		patientVisitList = (List<Visit>)map.get("visitList");
	}
	List<StoreIssueT> alreadyissuedDrugList = new ArrayList<StoreIssueT>();
	Visit visit =null;
	if(patientVisitList != null && patientVisitList.size()>0) {
		visit = (Visit) patientVisitList.get(0);
	}
	List<PatientPrescriptionDetails> prescriptionDetailsList = new ArrayList<PatientPrescriptionDetails>();  
	/**/
	int presId = 0;
	if(map.get("presId")!=null){
		presId = (Integer) map.get("presId");
	}
	
	List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
	if(map.get("frequencyList") != null){
	frequencyList=(List)map.get("frequencyList");
	}
	
	List<OpdInstructionTreatment> masInstructionMasterList = new   ArrayList<OpdInstructionTreatment>();
	if(map.get("masInstructionMasterList") != null)
	{
	  masInstructionMasterList=(List<OpdInstructionTreatment>)map.get("masInstructionMasterList");
	}
	
	List<RouteOfAdministration> routeOfAdministrationList = new   ArrayList<RouteOfAdministration>();
	if(map.get("routeOfAdministrationList") != null)
	{
		routeOfAdministrationList=(List<RouteOfAdministration>)map.get("routeOfAdministrationList");
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
	if(visit!=null){
		
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
		
	} 
	//added by govind 6-10-2016
	List<StoreItemBatchStock>batchList=new ArrayList<StoreItemBatchStock>();
	if(map.get("batchList")!=null){
		batchList=(List<StoreItemBatchStock>)map.get("batchList");
	}
	if(map.get("hospitalId")!=null){
		hospitalId=Integer.parseInt(map.get("hospitalId").toString());
	}
	if(map.get("deptId")!=null){
		deptId=Integer.parseInt(map.get("deptId").toString());
	}
	//added by govind 6-10-2016 end
	
	//Added by Arbind on 21-04-2017
	if(map.get("patientIssueNo") != null){
		patientIssueNo = (String) map.get("patientIssueNo");
	}
	%>
	<input type="hidden" name="presHdId" id="presHdId" value="<%=presId%>"/>
	<div class="Block">
		<div class="clear"></div>
		<input type="hidden" name="visitId" id="visitId"
			value="<%=visit.getId()%>" validate="visitId,int,no"/> <input type="hidden" name="deptId"
			value="<%=deptId%>" id="deptId" validate="deptId,int,no"/> <input type="hidden" name="hospitalId"
			value="<%=hospitalId%>" validate="hospitalId,int,no" id="hospitalId"/> <input type="hidden" name="hinId"
			value="<%= visit.getHin().getId() %>" validate="hinId,int,no"/> <input type="hidden"
			name="<%=ISSUE_ID%>" id="issueId" value="" validate="issueId,int,no"/> <input type="hidden"
			size="2" value="0" name="noOfRecords" id="noOfRecords" validate="noOfRecords,int,no"/> <label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>

		<label class="value"><%=regNo %></label> <label> Patient Name</label>
		<label class="value"><%=ptName %></label> <label> Age</label> <label
			class="value"><%=age %></label>

		<div class="clear"></div>

		<label> Doctor</label> <label class="value"><%=doctorName %></label> <label>
			Department</label> <label class="value"><%=department %></label> <label>
			Patient Type</label> <label class="value"><%=patType %></label>
		<div class="clear"></div>
		<label> Visit No</label> <label class="value"><%=visit.getVisitNo()%></label>
		<label> Visit Date</label> <label class="value"><%=HMSUtil.changeDateToddMMyyyy(visit.getVisitDate())%></label>
		<!-- Added by Arbind on 21-04-2017 -->
		<label> Issue No.</label> <input type="hidden" name="issueNo"
			value="<%=patientIssueNo %>" tabindex=1 id="issueNo" /> <label
			class="value"><%=patientIssueNo %></label>
		
		<div class="clear"></div>
		<label><span>*</span> Diagnosis</label> <input type="text" value=""
			tabindex="1" id="icd" name="icd"
			onblur="fillDiagnosisCombo(this.value);" validate="Diagnosis,metachar,no" />
		<div id="ac2update22" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		  new Ajax.Autocompleter('icd','ac2update22','opd?method=getICDList',{parameters:'requiredField=icd'});
</script>
		<select name="<%=DIAGNOSIS_ID%>" tabindex="1" multiple="4" size="5"
			id="diagnosisId" class="listBig" ><!-- validate="diagnosisId,metachar,yes" -->
		</select>
		<div class="clear"></div>
		<div  id="phDiv" class="hideHtml">
			<label>Promoter</label>
				<select id="promoter" name="promoter"><option value='0'>Select</option></select>						
			<label>Place of Procedure</label>
				<select id="ppc" name="ppc" onchange='addColumsHospitalName(this.value);'>
						<option value='0'>Select</option>
						<option value='1'>Government</option>
						<option value='2'>Private</option>
				</select>
			<div  id="phDivHos" class="hideHtml">		
				<label>Hospital Name</label>
				<select id="prcHospital" name="prcHospital"><option value='0'>Select</option></select>
				<input type='text' id="prcHospitalText" name="prcHospitalText" class="hideHtml">
			</div>	
			<div class="clear"></div>
			<span class="hideHtml" id="cpspan">Please enter Copper T promter and place of procedure details.</span>	
		</div>
	</div>


	<div class="clear"></div>
	<div class="floatLeft">
		<input type="button" class="buttonDel" tabindex="1" value=""
			onclick="removeRow();" /> <input type="button" class="buttonAdd"
			tabindex="1" onclick="addRow();" value="" />
	</div>
	<div class="clear"></div>
			<div id="divTemplet" style="width:1170px; overflow: scroll; ">
				<table border="0" align="center" cellpadding="0" cellspacing="0"
					id="grid">
					<thead>
					<%
					int incr = 1;
					%>
					<tr>
						<th scope="col">&nbsp;</th>
						<th scope="col">Item Name</th>
						<th scope="col">Batch No.</th>
						<th scope="col">Stock Qty.</th>
						<th scope="col">Doages</th>
						<th scope="col">Unit</th>
						<th scope="col">Frequency</th>
						<!-- <th scope="col">No of Days</th> -->
						<th scope="col">Duration</th>
						<th scope="col">Instruction</th>
						<th scope="col">Route</th>
						<th scope="col">Issue Qty.</th>
						<th scope="col">Remark</th>
						
					</tr>
					</thead>
					<tbody>
					
					<tr>
						<td><input type="checkbox" class="radioCheck" id="itemRadio1"
							name="itemRadio1" /></td>
						<td id="nomenclatureDiv<%=incr%>"><input type="text"
							class="opdgridText" tabindex="1" id="nomenclature<%=incr%>"
							size="35" name="nomenclature<%=incr%>"
							onblur="populatePVMS(this.value,'<%=incr%>');checkExistingItems('patientDrugIssue',this.value,'<%=incr%>');checkItem('<%=incr%>');addColumsPromoter(this.value);" />
							<div id="ac2updates<%=incr%>" style="display: none;"
												class="autocomplete"></div> <script type="text/javascript"
												language="javascript" charset="utf-8">
							  new Ajax.Autocompleter('nomenclature<%=incr%>','ac2updates<%=incr%>','opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclature<%=incr%>'});
					</script> <input type="hidden" name="pvmsNo<%=incr %>" id="pvmsNo<%=incr %>"
											size="10" readonly="readonly" /> <input type="hidden"
											name="actualDispensingQty<%=incr%>"
											id="actualDispensingQty<%=incr%>" size="6"
											validate="AU,string,no" />
								<input type="hidden"
											name="tapered<%=incr%>"
											id="tapered<%=incr%>" 
											validate="tapered,string,no" />
								<input type="hidden" readonly="readonly"
											name="splInstrunction<%=incr %>"
											class="textYellow opdTextBoxSmall"
											id="splInstrunction<%=incr %>" maxlength="200" />
											</td>
						<td><select name="itemBatchNo<%=incr%>"
							id="itemBatchNoId<%=incr%>"
							onchange="getItemStockValue1(this.value,<%=incr%>);">
								<option value="0">Select</option>
									<%for(StoreItemBatchStock str:batchList){ %>
									<option value="<%=str.getBatchNo() %>:<%=str.getId()%>:<%=str.getClosingStock()%>"><%=str.getBatchNo()%></option>
								<%} %>
						</select></td>
						<td><input type="hidden" id="drugItemId<%=incr%>"
							name="drugItemId<%=incr%>"></input><input type="hidden"
							id="stockItemBatchStockId<%=incr%>"
							name="stockItemBatchStockId<%=incr%>"></input> <input type="text"
							readonly="readonly" class="small" size="10" maxlength="45"
							tabindex="1" id="stockQtyId<%=incr%>" name="stockQty<%=incr%>" ></input>
							<input type="hidden" name="pvmsNo<%=incr %>" tabindex="1" id="pvmsNo<%=incr %>" value="" size="10" readonly="readonly" />
						</td>
						<td><input class="small" type="text" name="dosage<%=incr%>"
							id="dosage<%=incr%>" size="10" maxlength="45" tabindex="1"
							onblur="fillValue(<%=incr%>);" />
							<div id="testDiv<%=incr%>"></div></td>
						<td><input type="text" name="unit<%=incr%>" class="small"
							id="unit<%=incr%>" readonly="readonly" size="5"
							 onblur="fillValue(<%=incr%>);" />
						</td>
						<td>
						<input type="hidden" name="frequencyValue<%=incr%>"
											id="frequencyValue<%=incr%>" value="" size="6" /> <input
											type="hidden" name="sosQty<%=incr%>" id="sosQty<%=incr%>"
											style="display: none;" size="3"
											onblur="fillValue(<%=incr%>)" maxlength="3"
											validate="Sos Qty,num,no" />
						<select style="width: 70px;" name="frequency<%=incr%>"
							id="frequency<%=incr%>" tabindex="1"
							onchange="getFrequencyValue(this.value,<%=incr%>);fillValue(<%=incr%>);displaySOSQty(this.value,<%=incr%>)">
								<option value="0">Select</option>
								<%
				  MasFrequency  masFrequency = new MasFrequency();
			      for(MasFrequency masFrequency2 : frequencyList){
			       int id = masFrequency2.getId();
			       String name = masFrequency2.getFrequencyName();
	          %>
								<option value="<%=id %>"><%=name%></option>
								<%} %>
						</select> <%
		    		MasFrequency  masFrequency3 = new MasFrequency();

				         for (int i = 0; i < frequencyList.size(); i++) {
				        	 masFrequency3 = (MasFrequency) frequencyList.get(i);
	     			 %> <script>
		          icdArray[<%=i%>]= new Array();
		          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
		          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
	            </script> <% }%></td>
						<td><input type="text" name="noOfDays<%=incr%>"
							id="noOfDays<%=incr%>" class="small" size="3" maxlength="3"
							validate="No Of Days,int,no" tabindex="1"
							onblur="fillValue(<%=incr%>);" /></td>
						<td><select style="width: 70px;" name="instruction<%=incr%>"
							id="instruction<%=incr%>"><option value="0">Select</option>
								<%
					for(OpdInstructionTreatment instructionTreatment:masInstructionMasterList)
					{
		
				       int id = instructionTreatment.getId();
				       String name = instructionTreatment.getOpdInstructionTreatmentName();
		
		          %>
								<option value="<%=id %>"><%=name%></option>
								<%
					}
					%>
						</select> <script type="text/javascript">	var	instructionArray= new Array();
              <%
              OpdInstructionTreatment  instructionMaster = new OpdInstructionTreatment();
			     for (int k = 0; k < masInstructionMasterList.size(); k++) {
			    	 instructionMaster = (OpdInstructionTreatment) masInstructionMasterList.get(k);
     			 %> 
     			instructionArray[<%=k%>]= new Array();
     			instructionArray[<%=k%>][0] = "<%=instructionMaster.getId()%>";
     			instructionArray[<%=k%>][1] = "<%=instructionMaster.getOpdInstructionTreatmentName()%>";
     			<% }%> 
            </script></td>
						<td>
					  <select name="route<%=incr%>" id="route<%=incr%>"
							style="width: 70px;">
								<option value="0">Select</option>
								<%
					      for(RouteOfAdministration routeOfAdministration : routeOfAdministrationList){
					    	  
					       int id = routeOfAdministration.getId();
					       String name = routeOfAdministration.getRouteName();
				          %>
									<option value="<%=id %>"><%=name%></option>
									<%
						}%>
						</select> <script type="text/javascript">	var	routeArray= new Array();
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
						<td><input type="text" name="total1" id="total1" size="5"
							class="small" validate="Total,int,no" readonly="readonly" /> <input
							type="hidden" name="pvmsNo<%=incr%>" id="pvmsNo<%=incr%>"
							size="10" value="" /></td>
							
						<td><input type="text" name="remark<%=incr%>" validate="remark<%=incr%>,metachar,no"></input></td>
					</tr>
				</tbody>
				</table>
				<input type="hidden" name="hdb" value="<%=incr%>" id="hdb" />
			</div>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<input type="button"
		name="Submit11" class="button" value="Submit"
		onclick="if(checkIssueQtyWithStock(<%=incr%>)){submitForm('patientDrugIssue','stores?method=submitdirectDispensing');}" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<div class="paddingTop40"></div>
	<div class="bottom">
		<div class="clear"></div>
		<div class="clear"></div>
	</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

  <div style="display: none;">
						<table id="taperedMedicne1">
						<th scope="col">Item Id</th>
						<th scope="col">Frequency</th>
				        <th scope="col">Dosage</th>
				        <th scope="col">Dosage Total</th>
				        <th scope="col">Duration</th>
				        <th scope="col">Total</th>
						</table>
						<input type="hidden" id="taperedMedicineHdb1" name="taperedMedicineHdb" value="0"/>
						</div>
		<input type="hidden" id="alreadyEx"/>
		</div>
	</form>
	<form action="" name="taperedForm" style="display: none;">
							<!-- added by govind for tapered Medicine -->
						<div>
						<table id="taperedMedicne">
						<th scope="col">Item Id</th>
						<th scope="col">Frequency</th>
				        <th scope="col">Dosage</th>
				        <th scope="col">Dosage Total</th>
				        <th scope="col">Duration</th>
				        <th scope="col">Total</th>
						</table>
						</div>
						<input type="hidden" id="taperedMedicineHdb" name="taperedMedicineHdb" value="0"/>
						<!-- added by govind for tapered Medicine -->
	</form>
<script type="text/javascript">
function checkIssueQtyWithStock(){
	var tbl = document.getElementById('grid'); 
	document.getElementById('hdb').value=tbl.rows.length-1;
	for(var i=1;i<=tbl.rows.length-1;i++){
		if (!(document.getElementById("tapered" + i))==false) {
		if(document.getElementById('nomenclature'+i)!=null){
			var nomenclature=document.getElementById('nomenclature'+i).value;
			if(nomenclature!=""){
		if(document.getElementById('stockQtyId'+i)!=null && document.getElementById('stockQtyId'+i)!=""){
		var stockQtyValue=document.getElementById('stockQtyId'+i).value;
		var issueQtyValue=parseInt(document.getElementById('total'+i).value);
		var frequency=document.getElementById('frequency'+i).value;
		var itemBatchNoId=document.getElementById('itemBatchNoId'+i).value;
		
		if(itemBatchNoId==0 ||itemBatchNoId==""){
			alert("Please select Batch No");
			return false;
		}
		
		if(stockQtyValue==0){
			alert("Stock quantity should be more than zero");
			return false;
		}
		
		 if(frequency==0){
				alert("Please select Frequency");
				return false;
			}
		 
		 if(issueQtyValue<=0){
			alert("Issue quantity should be more than zero");
			return false;
		}
		 else if(stockQtyValue<issueQtyValue){
			alert("Issue quantity should be more than stock quantity");
			return false;
		}
		
		}
		}
		}
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
	  e1.onblur=function(){populatePVMS(this.value,iteration);checkItem(iteration);addColumsPromoter(this.value);checkExistingItems("patientDrugIssue",this.value,iteration)};
	  e1.size='35';       
	  cellRight1.appendChild(e1);
	  
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
		  e1.name='tapered'+iteration;
		  e1.id='tapered'+iteration;
		  cellRight1.appendChild(e1); 
		  var e1 = document.createElement('input');
		  e1.type = 'hidden';
		  e1.name='splInstrunction'+iteration;
		  e1.id='splInstrunction'+iteration;
		  cellRight1.appendChild(e1);
		/*
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight1.appendChild(newdiv);
	  new Ajax.Autocompleter('nomenclature'+iteration,'ac2updates'+iteration,'opd?method=getItemListForAutoCompleteItem',{minChars:3,parameters:'requiredField=nomenclature'+iteration+'&screenName=pharmacy&counter='+iteration});
*/


	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='brandId'+iteration;
	  e1.id='brandId'+iteration;
	  cellRight1.appendChild(e1);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='manufactureId'+iteration;
	  e1.id='manufactureId'+iteration;
	  cellRight1.appendChild(e1);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='pvmsNo'+iteration;
	  e1.id='pvmsNo'+iteration;
	  
	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='actualDispensingQty'+iteration;
	  e2.id='actualDispensingQty'+iteration;
	  
	  cellRight1.appendChild(e1);
	  cellRight1.appendChild(e2);
	  
	  var cellRight1 = row.insertCell(2);
	  var e1 = document.createElement('Select');
	  e1.name='itemBatchNo'+iteration;
	  e1.id='itemBatchNoId'+iteration; 
	  e1.options[0] = new Option('Select', '0');
	  e1.onchange=function() { getItemStockValue1(this.value,iteration);};
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
	  
	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='stockItemBatchStockId'+iteration;
	  e2.id='stockItemBatchStockId'+iteration;
	  cellRight1.appendChild(e1);	  
	  cellRight1.appendChild(e2);
	  
	  var e1 = document.createElement('input');
	  e1.type = 'hidden';
	  e1.name='drugItemId'+iteration;
	  e1.id='drugItemId'+iteration;
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
	  e1.onchange=function() { getFrequencyValue(this.value,iteration);fillValue(iteration);displaySOSQty(this.value,iteration);};
	  
	  var e2 = document.createElement('input');
	  e2.type = 'hidden';
	  e2.name='frequencyValue'+iteration;
	  e2.id='frequencyValue'+iteration;
	  
	  var e3 = document.createElement('input');
	  e3.type = 'hidden';
	  e3.name='sosQty'+iteration;
	  e3.id='sosQty'+iteration;
	  
	  cellRight1.appendChild(e1);
	  cellRight1.appendChild(e2);
	  cellRight1.appendChild(e3);
	  
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
/*function  fillValue(inc2){
    var freq=document.getElementById('frequency'+inc2).value;
    var noOfDays=document.getElementById('noOfDays'+inc2).value;
    var dosage=document.getElementById('dosage'+inc2).value;
    document.getElementById('total'+inc2).value=freq*dosage*noOfDays;
}*/ //changed by govind 18-10-2016
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

		 /* if(pvmsNo == "") //added by govind 
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
		      var frq = document.getElementById('frequency'+inc);
		      if(val.toLowerCase().indexOf("copper t")>=0){
		    	  frq.options[3].selected = true;
		    	  document.getElementById('total'+inc).value=1;
		      }else{
		    	  frq.disabled = false;		    	  
		      }
		      new Ajax.Request('stores?method=getItemUnitDetail&pvmsNo='+pvmsNo+'&itemId='+itemId+'&'+csrfTokenName+'='+csrfTokenValue, {
		    	  onSuccess: function(response) { 
		    	      if(response.responseText.trim()!='')
		    	    	  {  
		    	    	  var unitAndStock=response.responseText.split("/"); 
		    	    	  document.getElementById('unit'+inc).value=unitAndStock[0].trim();
		    	    	  var e=document.getElementById('itemBatchNoId'+inc);
	    	    		  for(var r=e.length;r>0;r--){
	    	    			  e.remove(r);
	    	    		  }
		    	    	  if(unitAndStock[1]!=null && unitAndStock[1]!=""){  
		    	    		  var batch=unitAndStock[1].split(","); 
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
		    }*/
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
				 document.getElementById("drugItemId"+inc).value=itemId;
				 
				 document.getElementById('stockQtyId'+inc).value="";
					document.getElementById('stockItemBatchStockId'+inc).value=0.00;
					
					new Ajax.Request('stores?method=getItemUnitDetail&pvmsNo='+pvmsNo+'&itemId='+itemId+'&'+csrfTokenName+'='+csrfTokenValue, {
				    	  onSuccess: function(response) { 
				    	      if(response.responseText.trim()!='')
				    	    	  {  
				    	    	  var unitAndStock=response.responseText.split("/"); 
				    	    	  var unitAndStock1=response.responseText.split("###"); 
				    	    	  document.getElementById('unit'+inc).value=unitAndStock1[0].trim();
				    	    	  }
				    	  }
				    	});

					//added by govind on 25-09-2017 for Tapered Medicine
					new Ajax.Request(
							'ipd?method=updateItemUnit&pvmsNo=' + pvmsNo + '&'
									+ csrfTokenName + '=' + csrfTokenValue,
							{
								onSuccess : function(response) {
									if (response.responseText.trim() != '') {
										var str = response.responseText.trim().split(
												"###");
										document.getElementById('tapered' + inc).value = str[3]!=undefined?str[3]:"n";
										
										if(document.getElementById('tapered' + inc)!=null && document.getElementById('tapered' + inc).value=='y' ){
											var nomenclature=document.getElementById('nomenclature' + inc).value;
											var index1 = nomenclature.lastIndexOf("[");
											var index2 = nomenclature.lastIndexOf("]");
											index1++;
											var id = nomenclature.substring(index1, index2);
											var count = document.getElementById('hdb').value;
											var alrady=document.getElementById('alreadyEx').value;
											for (var i = 1; i <= count; i++) {
												if (i != inc && document.getElementById('nomenclature' + i) != null
														&& document.getElementById('nomenclature' + i).value == nomenclature
														) {
													    alrady++;
														alert('This Prescription is already selected.');
														document.getElementById('nomenclature' + inc).value = "";
														break;
												}
												
											}
											if(alrady==0){
												var first = nomenclature.lastIndexOf("(");
												var second = nomenclature.lastIndexOf(")");
												first++;
												var itemId = val.substring(first, second);
												//alert("itemId "+itemId);
												var url = '/hms/hms/opd?method=showTaperdMedicine&nomenclature='+itemId+'&row='+inc+'&' + csrfTokenName + '='
												+ csrfTokenValue;
												openTaperedMedicine(url);
											}
										}
										
									}
								}
							});
					//added by govind on 25-09-2017 for Tapered Medicine end
					
				/* new Ajax.Request('stores?method=getItemUnitDetail&pvmsNo='+pvmsNo+'&itemId='+itemId+'&'+csrfTokenName+'='+csrfTokenValue, {
			    	  onSuccess: function(response) { 
			    	      if(response.responseText.trim()!='')
			    	    	  {  
			    	    	  var unitAndStock=response.responseText.split("/"); 
			    	    	  var unitAndStock1=response.responseText.split("###"); 
			    	    	  document.getElementById('unit'+inc).value=unitAndStock1[0].trim();
			    	    	  var e=document.getElementById('itemBatchNoId'+inc);
		    	    		  for(var r=e.length;r>0;r--){
		    	    			  e.remove(r);
		    	    		  }
			    	    	  if(unitAndStock[1]!=null && unitAndStock[1]!=""){  
			    	    		  var batch=unitAndStock[1].split(","); 
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
			    	});*/
			    	var oral;
			    	for(var i = 0;i<routeArray.length;i++ ){
							var rot=routeArray[i][1];
							var rotid=routeArray[i][0];
						 if(rot=="Oral"){
							oral=routeArray[i][0];
							break;
						  }
							
					 }
			    	getBatchNoList(pvmsNo,itemId,inc);
			    	fillRoute(inc,oral);
			}
		} else {
			document.getElementById('nomenclature' + inc).value = "";
			document.getElementById('pvmsNo' + inc).value = "";
			document.getElementById('dosage' + inc).value = "";
			document.getElementById('noOfDays' + inc).value = "";
			document.getElementById('unit' + inc).value = "";
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
		    	      if(bedStatus!=null && bedStatus.childNodes[0].nodeValue=='yes'){
				        alert("This Drug is Alergic for this patient..!")
				       	document.getElementById("nomenclature"+iteration).value = ""
				       	document.getElementById("pvmsNo"+iteration).value= ""
				       	pvmsNo=pvmsNo.childNodes[0].nodeValue
			      	 return true;
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
	
	function getItemStockValue1(value,inc){
		//alert("value "+value+" inc "+inc+" batch "+document.getElementById('itemBatchNoId'+inc).value);
		if(document.getElementById('nomenclature'+inc).value!=""){
		getItemStockValue(value,inc);
		}else{
			document.getElementById('itemBatchNoId'+inc).selectedIndex=0;
			document.getElementById('dosage'+inc).value="";
			document.getElementById('stockQtyId'+inc).value=""; 
			document.getElementById('unit'+inc).value="";
			document.getElementById('noOfDays'+inc).value="";
			document.getElementById('noOfDays'+inc).value="";
		}
		/*if(value==0){
			document.getElementById('stockQtyId'+inc).value=0.00;
			document.getElementById('stockItemBatchStockId'+inc).value=0.00;
		}else{
			document.getElementById('stockQtyId'+inc).value=stockValueArray[value];
			document.getElementById('stockItemBatchStockId'+inc).value=stockItemIdArray[value];
		}*/ //
		
	} 

			function checkItemIssue(){
	<%
		if(alreadyissuedDrugList != null && alreadyissuedDrugList.size() > 0){
				for (StoreIssueT storeIssueT : alreadyissuedDrugList) {%>
								var invObj =<%= storeIssueT.getItem()%>
								var itemId=document.getElementById('itemId').value
								if(invObj==itemId ){
								alert("Drug is already issued in previous visit...");
 							}
 							<%}}%>
 							}

			 function addColumsPromoter(str){
				 if(str!=""){
					 jQuery(function ($) { 
							new Ajax.Request('stores?method=addPHColums&item='+str+'&'+csrfTokenName+'='+csrfTokenValue, {
						    	  onSuccess: function(response) {
						    	   if(response.responseText.trim()!='No Element')
							    	  {
						    		   $("#phDiv").show();
						    		   $("#promoter").focus();
						    		   $("#cpspan").show();
							    	  } 
						    	 }
						  	  });   
						 }); 
				 }
				 
			}
			
			 function addColumsHospitalName(val){
				  jQuery(function ($) {
					if(val==1){
						new Ajax.Request('stores?method=getHospitalList&'+csrfTokenName+'='+csrfTokenValue, {
					    	  onSuccess: function(response) {
					    	   if(response.responseText.trim()!='')
					    	   {
						 	   $("#phDivHos").show();
						 	   $("#prcHospital").show();
			    			   $("#prcHospital").html("<option value='0'>Select</option>"+response.responseText.trim());   
					    	   }
					    	   $("#cpspan").hide();
					    	   $("#prcHospitalText").hide();
					    	 }
					  	  });  
					}else if(val==2){
						$("#phDivHos").show();
						$("#prcHospital").hide();
						$("#prcHospitalText").show();
					}
				 }); 
			}
			 function checkExistingItems(form, strValue,inc ) {
					if(form=='patientDrugIssue'){
						var index1 = strValue.lastIndexOf("[");
					    var index2 = strValue.lastIndexOf("]");
					    index1++;
					    var id = strValue.substring(index1,index2);
					    var count=document.getElementById('hdb').value;
					    if(id =="")
					    {		
					    		document.getElementById('nomenclature'+inc).value="";
								return ;
						}
					    
					    for(var i=0;i<count;i++)
						{
						if(document.getElementById('nomenclature'+i)!=null && document.getElementById('nomenclature'+i).value==strValue  && i!=inc)
							{
							alert('This Prescription is already selected.');
							document.getElementById('nomenclature'+inc).value="";
							document.getElementById('alreadyEx').value="1";
							return false;
							}else{
								document.getElementById('alreadyEx').value="0";
							}
						}
							return true;	
					}
				}
			 
			 //added by govind 18-10-2016
			 function getFrequencyValue(feqValue,inc){
				var feqQty;
				<%
				if(frequencyList.size()>0){	
					for(MasFrequency masF :frequencyList){
				%>
				 if(feqValue == '<%=masF.getId()%>'){
					 feqQty = '<%=masF.getFrequencyCount()%>'
				  }
		
				<%}
				}%>
				 document.getElementById('frequencyValue'+inc).value = feqQty;
				 //document.getElementById('frequencyValuepTab'+inc).value = feqQty;
		 }		
			 
			//added by govind 25-09-2017
			 function openTaperedMedicine(url) {
			 	/*submitForm('opdMain','/hms/hms/investigation?method=printResultValidationLab&parent='+orderNo);*/
			 	window.open(url,
			 					"opd_window",
			 					"toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=1200, height=400");
			 }

			 function editTaperedMedicine(row,itemId){
			 	//alert("editTaperedMedicine");
			 	var url = '/hms/hms/opd?method=showTaperdMedicine&nomenclature='+itemId+'&'+getFormData('taperedForm')+'&taperedEdit=Y'+'&row='+row+'&' + csrfTokenName + '='
			 	+ csrfTokenValue;
			 	openTaperedMedicine(url);
			 }

			 function getFormData(formName) {
			 	   var str="";
			 	   inputs = eval('document.'+formName+'.elements');
			 	   // alert(inputs.length);
			 	   for(i=0;i<inputs.length;i++){
			 	   	str=str+inputs[i].name+"="+inputs[i].value+"&"
			 	   }
			 	   return str;
			 }
			  //added by govind 25-09-2017
 	</script>