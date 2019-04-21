<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>

<%@page import="jkt.hms.masters.business.MasFrequency"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.InjectionRegisterDetails"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.PatientPrescriptionDetails"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.InjAppointmentDetails"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script> 
<script>
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>';
	</script>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");  
		String time = (String)utilMap.get("currentTime");
 
 		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
		String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		}
		List<InjAppointmentDetails> injectionList = new ArrayList<InjAppointmentDetails>();
		if(map.get("injectionList") != null){
			injectionList= (List<InjAppointmentDetails>)map.get("injectionList");
		}
		PatientPrescriptionHeader prescriptionHeader = new PatientPrescriptionHeader();
		if(injectionList.size() > 0){
			prescriptionHeader = injectionList.get(0).getInjAppointmentHeader().getPrescription();
		}
	/*	List<InjectionRegister> injectionList = new ArrayList<InjectionRegister>();
		if(map.get("injectionList") != null){
			injectionList= (List<InjectionRegister>)map.get("injectionList");
		}
		InjectionRegister injectionRegister = new InjectionRegister();
		if(injectionList.size() > 0){
			injectionRegister = injectionList.get(0);
		}*/
		
		List<MasFrequency> freqList = new ArrayList<MasFrequency>();
		
		if(map.get("freqList") != null){
			freqList = (List<MasFrequency>)map.get("freqList");
		}
		Properties properties = new Properties();
		URL resourcePath = Thread.currentThread().getContextClassLoader()
				.getResource("adt.properties");
		int item_category_id=0;
		try {
			properties.load(resourcePath.openStream());
			String item_category_code = properties.getProperty("item_class_id");
			item_category_id=Integer.parseInt(item_category_code);
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
	<h4><%=message %></h4>
	<div class="clear"></div>
	<div class="titleBg"><h2>Injection Appointment</h2></div>
	<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<form name="injectionAppointment" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<input type="hidden" name="hinId" value="<%=prescriptionHeader.getHin().getId() %>" id="hinId"/>
<input type="hidden" name="visitId" value="<%=prescriptionHeader.getVisit().getId() %>" id="visitId"/>
<input type="hidden" name="presHdId" value="<%=prescriptionHeader.getId() %>" id="presHdId"/>
<label>Patient Name</label> 
<%
String middleName = "";
String lastName = "";
if(prescriptionHeader.getHin().getPMiddleName() != null){
	middleName = prescriptionHeader.getHin().getPMiddleName();
}
if(prescriptionHeader.getHin().getPLastName() != null){
	lastName = prescriptionHeader.getHin().getPLastName();
}

%>
<label class="value"><%=prescriptionHeader.getHin().getPFirstName()+" "+middleName+" "+lastName %></label>
<input type="hidden" name="patientName" value="<%=prescriptionHeader.getHin().getPFirstName()+" "+middleName+" "+lastName %>" id="patientName"/>

<label> Age</label> 
<label class="value"><%=(prescriptionHeader.getHin().getAge()!=null ? prescriptionHeader.getHin().getAge(): "")%></label>

<div class="Clear"></div>

<label> Gender</label> 
<label class="value"><%=(prescriptionHeader.getHin().getSex()!=null ? prescriptionHeader.getHin().getSex().getAdministrativeSexName(): "")%></label>


<label> Diagnosis</label> 
<%
Visit visit = new Visit();
String diagnosis = "";
Set<OpdPatientDetails> patientDetails = new HashSet<OpdPatientDetails>();
Set<DischargeIcdCode> icdSet = new HashSet<DischargeIcdCode>();

	if(prescriptionHeader.getVisit()!=null){
		visit = prescriptionHeader.getVisit();
		if(visit.getDischargeIcdCodes()!= null){
			icdSet = visit.getDischargeIcdCodes();
		}
		if(visit.getOpdPatientDetails()!= null){
			patientDetails = visit.getOpdPatientDetails();
			for(OpdPatientDetails opdPatientDetails : patientDetails){
				if(opdPatientDetails.getInitialDiagnosis()!= null){
					diagnosis = opdPatientDetails.getInitialDiagnosis();
				}else{
					if(icdSet.size() > 0){
						for(DischargeIcdCode icdCode : icdSet){
							if(!diagnosis.equals("")){
								diagnosis += ",";
							}
							diagnosis += icdCode.getIcd().getIcdName();
						}
					}
					
				}
			}
		}
		
	}
%>
<label class="value autoSize"><%=diagnosis %></label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Injection Details</h4>
<div class="Clear"></div>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<table border="0" align="center" cellpadding="0" cellspacing="0" id="injection">

	<tr>
	<th scope="col"></th>
		<th scope="col">Injection Name</th>
		<th scope="col">Dose</th>
		<th scope="col">Route</th>
		<th scope="col">Frequency</th>
		<th scope="col">Days</th>
		<th scope="col">A/U</th>
		<th scope="col">Quantity Issued</th>
	</tr>
	<% int i=1;

	String IssuedQtyArray = request.getParameter("IssuedQtyArray");
	String[]IssuedQtyArr=IssuedQtyArray.split(",");
	
	String batchIdArray = request.getParameter("batchIdArray");
	String[]batchIdArr=batchIdArray.split(",");
	
	String batchNoArray = request.getParameter("batchNoArray");
	String[]batchNoArr=batchNoArray.split(",");
	
	String expDateArray = request.getParameter("expDateArray");
	String[]expDateArr=expDateArray.split(",");
	
	
		for(InjAppointmentDetails injAppointmentDetails : injectionList){
			
		if(injAppointmentDetails.getItem().getItemClass()!=null && injAppointmentDetails.getItem().getItemClass().getId()==item_category_id){
		
	%>
	<tr>	
			
	        <td>
	        <input type="hidden" name="appDtId<%=i %>" id="appDtId<%=i %>" value="<%= injAppointmentDetails.getInjAppointmentHeader().getId()%>"/>
	        <input type="checkbox" name="presDtId<%=i %>" id="presDtId<%=i %>" value="<%=  injAppointmentDetails.getPrescriptionDetails().getId()%>" onclick="addRow(this,<%=i %>);"/>
			<input type="hidden" name="appDetailId<%=i %>" id="appDetailId<%=i %>" value="<%=  injAppointmentDetails.getId()%>" />
	
	</td>
		<td><input type="text" name="injectionName<%=i %>" id="injectionName<%=i %>" value="<%= injAppointmentDetails.getItem().getNomenclature() %>" validate="Injection Name,string,yes" onblur="if(this.value!=''){getItemId(this.value,1);}" size="60"/>
</td>
		<td>
		<input type="hidden" name="injectionId<%=i %>" id="injectionId<%=i %>" value="<%=  injAppointmentDetails.getItem().getId()%>"/>
		<input type="text" name="dose<%=i %>" id="dose<%=i %>" value="<%= injAppointmentDetails.getDose()!=null?injAppointmentDetails.getDose():"" %>"size="2" maxlength="4" validate="" /></td>
		<td><input type="text" name="route<%=i %>" id="route<%=i %>" value="<%= injAppointmentDetails.getRoute()!=null? injAppointmentDetails.getRoute():"" %>" class="small"/></td>
		<td><input type="text" name="freq<%=i %>" id="freq<%=i %>" value="<%= injAppointmentDetails.getFrequency()!=null?injAppointmentDetails.getFrequency().getFrequencyName():"" %>" size="5"/>
		<input type="hidden" name="frequencyId<%=i %>" id="frequencyId<%=i %>" value="<%=injAppointmentDetails.getFrequency()!=null? injAppointmentDetails.getFrequency().getId():0 %>" class="small"/>
		</td>
		<td><input type="text" name="noOfDays<%=i %>" id="noOfDays<%=i %>" value="<%= (injAppointmentDetails.getNoOfDays()!=null?injAppointmentDetails.getNoOfDays():"") %>"size="3"/></td>
		<td><input type="text" name="au<%=i %>" value="<%= (injAppointmentDetails.getItem().getItemConversion()!=null?injAppointmentDetails.getItem().getItemConversion().getItemUnitName():"") %>" class="small"/></td>
		
		<td>	<input type="text" id="qtyIssued<%=i %>" name="qtyIssued<%=i %>" value="<%=IssuedQtyArr[i-1] %>" class="small"/>
				<input type="hidden" value="<%=batchIdArr[i-1] %>" name="batchId<%=i%>" id="batchId<%=i %>">
				<input type="hidden" value="<%=batchNoArr[i-1] %>" name="batchNo<%=i%>" id="batchNo<%=i %>">
				<input type="hidden" value="<%=expDateArr[i-1] %>" name="expDate<%=i%>" id="expDate<%=i %>">
				</td>
			
		
	</tr>
	<%i++;
		}
		}%>
</table>
	<input type="hidden" name="injCount" value="<%=i-1 %>" id="injCount" />

<div class="clear"></div>
<input type="hidden" name="injectionRegisterId" value="<%=prescriptionHeader.getId() %>"/>
<div class="clear"></div>
<h4>Appointment List</h4>
<div class="Clear"></div>
<div class="Block">

<label> Next Appointment Date <span>*</span></label> 
<input	type="text" name="injAppDate" id="injAppDate" validate="Appointment Date,string,yes" value="" class="date" readonly="readonly" MAXLENGTH="8" onblur="checkDate(this.value);"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" 
class="calender"	onClick="setdate('<%=currentDate %>',document.injectionAppointment.injAppDate,event)" /> 
<input type="button" name="go" value="Go" class="buttonSm" onclick="submitProtoAjax('injectionAppointment','/hms/hms/registration?method=getInjectionAppointmentDetails');">
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div id="testDiv">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="injectionApp">

	<tr>
		<th scope="col">Time</th>
		<th scope="col">Injection Name</th>
		<th scope="col">Patient Name</th>
	</tr>
	<% int j=0;
	%>
</table>
	<input type="hidden" name="hdb" value="<%=j %>" id="hdb" />
	<input type="hidden" name="checkboxArray" value="" id="checkboxArray" />
	</div>
	
<div class="division"></div>
<input type="button" name="Submit11" id="addbutton"
	onclick="submitForm1('injectionAppointment','/hms/hms/opd?method=saveInjectionAppointment');"
	value="Submit" class="button" accesskey="a" />

<input type="reset" name ="Reset" value ="Reset" class="button" tabindex="1" accesskey="r" />
<div class="Clear"></div>
<div class="division"></div>
 <div class="bottom">
<label>Changed By:</label>   
<label class="value"><%=userName%></label>
        
<label>Changed Date:</label>   
<label class="value"><%=currentDate%></label>
 
<label>Changed Time:</label>   
<label class="value"><%=time%></label>
 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
<div class="Clear"></div>

</div>
</form>

<script>
function getItemId(val){
	var index1 = val.lastIndexOf("[");
    var indexForNomenclature=index1;
    var index2 = val.lastIndexOf("]");
    index1++;
    var pvmsNo = val.substring(index1,index2);
    ajaxFunctionForAutoCompletePVMS('minorSuregery','opdMaster?method=fillItemsInGrid&pvmsNo='+pvmsNo);
}

function addRow(obj,inc){
	var tbl = document.getElementById('injectionApp');
	var appCnt = document.getElementById('hdb').value;
		
		if(obj.checked){
			
			var detailsId = document.getElementById('appDetailId'+inc).value;

		 if(document.getElementById('injAppDate').value!=""){
			
		  var lastRow = tbl.rows.length;
		  var iteration = lastRow;
		  var row = tbl.insertRow(lastRow);
		  var hdb = document.getElementById('hdb');
		  var iteration = detailsId;
		  hdb.value = iteration;
						
		  var cell1 = row.insertCell(0);
		  var e1 = document.createElement('input');
		  e1.type = 'text';
		  e1.size = '10';
		  e1.name='appTime'+iteration;
		  e1.id='appTime'+iteration
		  e1.maxLength='5';
		  e1.onkeyup=function(){if(this.value!=''){mask(this.value,this,'2',':')}}
		  e1.onblur=function(){if(this.value!=''){IsValidTime(this.value,this.id)}}
	
		  var e11 = document.createElement('input');
		  e11.type = 'hidden';
		  e11.name='appPresDtId'+iteration;
		  e11.id='appPresDtId'+iteration
		  e11.value = document.getElementById('presDtId'+inc).value;
		  cell1.appendChild(e1);
		  cell1.appendChild(e11);
	
		  var cell2 = row.insertCell(1);
		  var e2 = document.createElement('input');
		  e2.type = 'text';
		  e2.size = '30';
		  e2.name='appInjectionName'+iteration;
		  e2.id='appInjectionName'+iteration
		  e2.value = document.getElementById('injectionName'+inc).value;
	
		  var e21 = document.createElement('input');
		  e21.type = 'hidden';
		  e21.name='appInjectionId'+iteration;
		  e21.id='appInjectionId'+iteration
		  e21.value = document.getElementById('injectionId'+inc).value;
		  cell2.appendChild(e21);
		  cell2.appendChild(e2);
	
		  var cell4 = row.insertCell(2);
		  var e4 = document.createElement('input');
		  e4.type = 'text';
		  e4.size = '20';
		  e4.name='appPatientName'+iteration;
		  e4.id='appPatientName'+iteration;
		  e4.value = document.getElementById('patientName').value;
		  cell4.appendChild(e4);
	
		  var cell7 = row.insertCell(3);
		  var e7 = document.createElement('input');
		  e7.type = 'text';
		  e7.size = '20';
		  e7.name='appName'+iteration;
		  e7.id='appName'+iteration;
		  e7.value = document.getElementById('name').value;
		  cell7.appendChild(e7);

		  var e71 = document.createElement('input');
		  e71.type = 'hidden';
		  e71.name='appDose'+iteration;
		  e71.id='appDose'+iteration;
		  e71.value = document.getElementById('dose'+inc).value;
		  cell7.appendChild(e71);

		  var e72 = document.createElement('input');
		  e72.type = 'text';
		  e72.name='appFrequencyId'+iteration;
		  e72.id='appFrequencyId'+iteration;
		  e72.value = document.getElementById('frequencyId'+inc).value;
		  cell7.appendChild(e72);

		  var e73 = document.createElement('input');
		  e73.type = 'hidden';
		  e73.name='appRoute'+iteration;
		  e73.id='appRoute'+iteration;
		  e73.value = document.getElementById('route'+inc).value;
		  cell7.appendChild(e73);

		  var e74 = document.createElement('input');
		  e74.type = 'hidden';
		  e74.name='appInjectionId'+iteration;
		  e74.id='appInjectionId'+iteration;
		  e74.value = document.getElementById('injectionId'+inc).value;
		  cell7.appendChild(e74);
		  
		  var e75 = document.createElement('input');
		  e75.type = 'hidden';
		  e75.name='appNoOfDays'+iteration;
		  e75.id='appNoOfDays'+iteration;
		  e75.value = document.getElementById('noOfDays'+inc).value;
		  cell7.appendChild(e75);
		  
		  var cell9 = row.insertCell(4);
		  var e9 = document.createElement('input');
		  e9.type = 'button';
		  e9.className = 'buttonDel';
		  e9.name='remarks'+iteration;
		  e9.setAttribute('onClick', 'removeRow('+document.getElementById('presDtId'+inc).value+',this);'); 
		  e9.setAttribute('tabindex','1');
		  cell9.appendChild(e9);
		}else{
			alert("Please select Appointment Date.");
			document.getElementById('presDtId'+inc).checked = false;
		}
		}
	//}
}

function removeRow(presDt,obj)
{
	var cnt = document.getElementById('injCount').value;
	for(var i=1;i<cnt;i++){
		if(document.getElementById('presDtId'+i) && document.getElementById('presDtId'+i).value == presDt){
			document.getElementById('presDtId'+i).disabled = false;
			document.getElementById('presDtId'+i).checked =false;
		}
	}
	  var i=obj.parentNode.parentNode.rowIndex;
	  document.getElementById('injectionApp').deleteRow(i);
}


function checkDate(appDate){
	currentDate = new Date();
	 var month = currentDate.getMonth() + 1
	 var day = currentDate.getDate()
	 var year = currentDate.getFullYear()
	 var seperator = "/"
	 currentDate = new Date(month + seperator + day + seperator + year);
	 var appointmentDate = new Date(appDate.substring(6),(appDate.substring(3,5) - 1) ,appDate.substring(0,2));
	
	if(currentDate > appointmentDate){
		alert("Appointment Date can not be less than current date.");
		document.getElementById('injAppDate').value = "";
		return false;
	}
	return true;	
}


function validateCheckBox(){

	var injCount = document.getElementById('injCount').value;
	
	for(var i=1;i<=injCount;i++){
		if(document.getElementById('presDtId'+i).checked){
			return true;
		}
	}
	alert("Please select one record.")
	return false;
}


 
 function submitForm1(formName,url,method)
 {
	 if(validateCheckBox())
		 {
		 var injCount = document.getElementById('injCount').value;
			for(var i=1;i<=injCount;i++)
			{
				if(document.getElementById('presDtId'+i).checked)
				{
					if(document.getElementById('qtyIssued'+i).value == "")
						{
								alert("Please enter the issued qty for "+document.getElementById('injectionName'+i).value);
								return false;
						}
					
					
				}
			}
			
			// make a checkbox array of which item/injection is selected
			var checkboxArray = new Array();
			for(var i=1;i<=injCount;i++)
			{
				if(document.getElementById('presDtId'+i).checked)
				{
					if(document.getElementById('qtyIssued'+i).value != "")
						{
						checkboxArray.push(document.getElementById('appDetailId'+i).value);
						}
					
					
				}
			}
			document.getElementById('checkboxArray').value= checkboxArray;
			
		 submitFormForButton(formName,url);
		 }// if close
	 
	
 }

</script>