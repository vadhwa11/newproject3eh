<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="java.io.InputStream"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript">
	function checkSubmitNomenclature() {
 			 var chargeCode=document.getElementById('itemName1').value
 			var index1 = chargeCode.lastIndexOf("[");
		    var index2 = chargeCode.lastIndexOf("]");
		    index1++;
		    var id = chargeCode.substring(index1,index2);
		    if(id =="")
		    {
		    	// if(!displayAlert("Please Enter The Item."))
			    	alert("Please Enter The Item.");
		    	
		    	// getShadow('itemName1');
				return false ;
 			}
 			return true;
		}	
</script>

<script type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(Calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(getDate.length()<2){
			getDate="0"+getDate;
		}
	%>
		serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>

<%
	Map map = new HashMap();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	String userName = "";
	int prescribedDepartmentId=0;
	int hospitalId=0;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String yearlySerialNo="";
	String monthlySerialNo="";
	 List<OtPreAnaesthesiaProNotesSub> otDetailList = new ArrayList<OtPreAnaesthesiaProNotesSub>();
	 List patientDetailList = new ArrayList();
	 List departmentList = new ArrayList();
	 List otList = new ArrayList();
	 OtBooking booking=null;
	 if(map.get("patientDetailList") != null){
		 booking=(OtBooking)map.get("booking");
		}
	if(map.get("patientDetailList") != null){
		patientDetailList=(List)map.get("patientDetailList");
	}
	if(map.get("departmentList") != null){
		departmentList=(List)map.get("departmentList");
	}
    if(map.get("otList") != null){
		otList=(List)map.get("otList");
	}
	if(map.get("otDetailList") != null){
		otDetailList=(List)map.get("otDetailList");
	}
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("monthSerialNo")!=null){
		monthlySerialNo=(String)map.get("monthSerialNo");
	}
	if(map.get("yearlySerialNo")!=null){
		yearlySerialNo=(String)map.get("yearlySerialNo");
	}
	if(patientDetailList!=null && patientDetailList.size()>0){
		 OpdSurgeryHeader otBooking=(OpdSurgeryHeader)patientDetailList.get(0);
		
	    String patientName="";
		if(otBooking.getHin().getPFirstName()!= null){
			patientName=otBooking.getHin().getPFirstName();
		}
		if(otBooking.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+otBooking.getHin().getPMiddleName();
		}
		if(otBooking.getHin().getPLastName()!= null){
			patientName=patientName+" "+otBooking.getHin().getPLastName();
		}
		
		Inpatient inpatient=null;
		Patient patient=null;
		if(otBooking!=null)
		{
			if(otBooking.getInpatient()!=null){
			inpatient=otBooking.getInpatient();
			patient = inpatient.getHin();
			}else if(otBooking.getVisit()!=null){
				patient = otBooking.getVisit().getHin();
			}
		}
		 
%>

<!--main content placeholder starts here-->
<title>Pre-Anesthesia Notes</title>
<form name="otBooking" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Pre OP Advice (Anesthesia)</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Yearly Serial No. </label> 
<input type="text" readonly="readonly" value="<%=yearlySerialNo %>" />
<input type="hidden"	id="yearlySqNo" name="yearlySqNo" value="<%=yearlySerialNo %>" /> 
<label>Monthly Serial No. </label> 
<input type="text" readonly="readonly" value="<%=monthlySerialNo%>" />
<input type="hidden" id="monthlySqNo" name="monthlySqNo" value="<%=monthlySerialNo %>" />
<div class="clear"></div>
</div>
<!--Block One Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%if(inpatient!=null) {
	session.setAttribute("inpatient",inpatient);
%>
<%@include file="PatientDetails.jsp" %>
<%} %>

<input type="hidden" name="<%=RequestConstants.HIN_ID %>"  value="<%=otBooking.getHin()!=null?otBooking.getHin().getId():"" %>"/>
<input type="hidden" name="<%=RequestConstants.VISIT_ID %>" value="<%=otBooking.getVisit()!=null?otBooking.getVisit().getId():"" %>" />
<input type="hidden" name="<%=RequestConstants.INPATIENT_ID %>"  value="<%=otBooking.getInpatient()!=null?otBooking.getInpatient().getId():"" %>"  />
<input
	name="opdSurgeryHeaderId" type="hidden"
	value="<%=otBooking.getId() %>" /> 
<label>Requisition Date</label> 
<input type="text" readonly="readonly" value="<%=otBooking.getRequisitionDate() %>" />
<label>Requisition No.</label> 
<input type="text" readonly="readonly" value="<%=otBooking.getOrderNo() %>" />

 
<div class="clear"></div>

<input type="hidden" name="bookingId" id="bookingId"	value="<%=booking!=null?booking.getId():"" %>" />
<div class="clear"></div>
<label>Pre Operative Advice</label>
 <textarea name="preOperativeAdvice" cols="0" rows="0" class="large"	id="preOperativeAdvice" oninput="return checkMaxLengthMoz(this)"
onpaste="return checkOnPaste(this)" 	onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="45"></textarea>
<div class="clear"></div>
<%-- <td><input name="selectCheckBox" id="selectCheckBox" type="button" value="<%=otBooking.getId() %>" onClick="javascript:openPopupWindow(this.value);" /></td> --%>
 <input type="hidden" id="requestId" value="<%=otBooking.getHin().getId() %>"/>
<input type="button" name="Submit" class="button" value="Allergy"
	onclick="javascript:openPopupWindow();" />
</div>
<div class="clear"></div>
<h4>Patient Advice</h4>
<div class="clear"></div>
<div class="Block">
<label>Patient Advise</label>
 <textarea name="patientAdvise" class="textareaMediua" validate="patientAdvise,string,no" id="patientAdvise" cols="0"	rows="0" maxlength="500" tabindex="5" onkeyup="return checkLength(this)"></textarea>
<input type="button" class="buttonAuto-buttn"  value="+" onclick="getMedicationHistoryTemplate(csrfTokenName+'='+csrfTokenValue)"  />	
	
<label>Doctor's Notes</label> 
<textarea name="referralNote" class="textareaMediua" validate="referralNote,string,no" id="referralNote" cols="0"	rows="0" maxlength="500" tabindex="5" onkeyup="return checkLength(this)"></textarea>
<input type="button" class="buttonAuto-buttn"  value="+" onclick="getGeneralExaminationTemplate(csrfTokenName+'='+csrfTokenValue);"  />
<div class="clear"></div>
<label>Multiple Drug</label>
<textarea class="large" name="multipleDrug">
</textarea>
</div>
<div class="clear"></div>
<h4>Premedication</h4><div class="clear"></div>
<div class="Block"><div class="clear"></div>
<div class="clear"></div>
<input name="Add" type="button" class="button" value="Add"
	onclick="addRowForSurgery()" /> 
	<input name="Delete" type="button"
	class="button" value="Delete" onclick="removeRow()" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="investigationGrid">
	<tr>
		<th scope="col">SI No.</th>
		<th scope="col">Item Code</th>
		<th scope="col">Item Name</th>
		<th scope="col">Dose</th>
		<th scope="col">Route</th>
	</tr>
	<tr>
		<td><input type="text" name="textfield" readonly="readonly" size=2 value="1" /></td>
		<td id="nomenclaturetd1"><input type="text" name="nomenclature1"
			id="nomenclature1" size=10 /></td>

		<td>
		<%int inc=1; %> <input type="text" name="itemName1" id="itemName1"
			size=43 value=""
			onblur="if(validateItemForAutoComplete(this.value,'<%=inc %>'))
			{submitProtoAjaxWithDivName('otBooking','/hms/hms/ot?method=fillStoreItem&rowVal=1','nomenclaturetd1');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('itemName1','ac2update2','ot?method=getStoreItemForAutoComplete',{parameters:'requiredField=itemName1'});
	</script></td>
		<td><input type="hidden" value="1" name="hiddenValue" id="hiddenValue" /><input type="text" name="dose" id="dose1" size=10 /></td>
		<td><select name="route" id="route1">
			<option value="1/V">1/V</option>
			<option value="1/M">1/M</option>
			<option value="Oral">Oral</option>
			<option value="S.C.">S.C.</option>
		</select></td>
	</tr>
</table>
<div class="clear"></div>
</div><div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block"><label>Remarks</label> 
<textarea name="remarks"  id="remarks" cols="0" rows="0" class="large"onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" onkeydown="return checkMaxLength(this)" onkeyup="finalCheck(this)"	maxlength="45"></textarea>
<div class="clear"></div>
<input name="hinId" type="hidden" value="<%=otBooking.getHin().getId() %>" />
</div>

 <input name="patientStatus" type="hidden" value="<%=otBooking.getPatientStatus() %>" /> 
 <input name="orderNo" type="hidden" value="<%=otBooking.getOrderNo() %>" />


<%}%>  
<input name="hospitalId" type="hidden"	value="" /> <input name="changedBy" type="hidden" value="<%=userName %>" /> 
<input name="changedDate" type="hidden"	value="<%=date %>" /> <input name="changedTime" type="hidden" value="<%=time %>" />



<!-- <input type="button" name="Submit" class="button" value="Submit"
	onclick="if(checkSubmitNomenclature()){submitForm ('otBooking','ot?method=submitPreAneaesthesiaProcNotesEntryJsp');}" /> -->

<input type="button" name="Submit" class="button" value="Submit"
	onclick="submitForm ('otBooking','ot?method=submitPreAneaesthesiaProcNotesEntryJsp');" />	
	
<input name="back" type="button" class="button"	value="Back" onclick="submitForm ('otBooking','ot?method=showOtPatientDetails&otProcedure=no')" />

<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> <label class="value"><%=userName %></label>
<label>Changed Date</label> <label class="value"><%=date %></label> <label>Changed Time</label> <label class="value"><%=time %></label>

<div class="clear paddingTop10" ></div>
</div>
<br />
<br />
<br />
</form>

<script type="text/javascript">
function openPopupWindow(){
   var requestId=document.getElementById("requestId").value.trim();
	
 window.open("/hms/hms/ot?method=showAllergy&requestId="+requestId+"&"+csrfTokenName+"="+csrfTokenValue,"_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=100, left=100, width=850, height=400");
}
function validateItemForAutoComplete( strValue,inc ) {
 			 
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    
		    if(id =="")
		    {
		    		document.getElementById('itemName'+inc).value="";
	   				document.getElementById('nomenclature'+inc).value="";
 					return ;
 			}
 			return true;
		}	
  
	function removeRow()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}
 function addRowForSurgery(){
		
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	 
	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('input');
	  sel.value=hdb.value;
	  sel.size='2';
	  sel.type='text';
	  sel.setAttribute("readonly","readonly");
	  cellRightSel.appendChild(sel);
	  
	  var cellRightSel = row.insertCell(1);
	  cellRightSel.id='nomenclaturetd'+iteration;
	  
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='nomenclature'+iteration;
	  sel.id='nomenclature'+iteration
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	 
	 
	  var cellRight1 = row.insertCell(2);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
	  						
		if(validateItemForAutoComplete(this.value,iteration)){submitProtoAjaxWithDivName('otBooking','/hms/hms/ot?method=fillStoreItem&rowVal='+iteration,'nomenclaturetd'+iteration);}
		
	  };
	  e0.name = 'itemName' + iteration;
	  e0.id = 'itemName' + iteration;
	  //alert("name--"+e0.name)
	  e0.size = '43'
	  cellRight1.appendChild(e0);
	    var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update2');
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
    cellRight1.appendChild(newdiv);
    
	   new Ajax.Autocompleter('itemName'+iteration,'ac2update2','ot?method=getStoreItemForAutoComplete',{parameters:'requiredField=itemName'+iteration});
	  
	  var cellRightSel = row.insertCell(3);
	  cellRightSel.id='tdDose'+iteration;
	  
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='dose';
	  sel.id='dose'+iteration
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	  
	  var cellRightSel = row.insertCell(4);
	  cellRightSel.id='tdRoute'+iteration;
	  
	  var sel = document.createElement('select');
 	 sel.name = 'route';
  		sel.options[0] = new Option('1/V', '1/V');
  		sel.options[1] = new Option('1/M', '1/M');
  		sel.options[2] = new Option('Oral', 'Oral');
  		sel.options[3] = new Option('S.C.', 'S.C.');
  		cellRightSel.appendChild(sel);
	}
 
 function getMedicationHistoryTemplate(csrf) {
		var url = '/hms/hms/opd?method=showPopUpMedicationHistory&' + csrf + '&'
				+ csrfTokenName + '=' + csrfTokenValue+'&flag=preAneshesia';
		popwindow(url);
	}
 function popwindow(url) {
		url = url + '&' + csrfTokenName + '=' + csrfTokenValue;
		newwindow = window.open(url, 'name', 'height=500,width=800,status=1');
		if (window.focus) {
			newwindow.focus()
		}
		newwindow.createPopup();
	}

function getGeneralExaminationTemplate(csrf){
	 var url = '/hms/hms/opd?method=showPopUpGeneralExamination&' + csrf + '&'
		+ csrfTokenName + '=' + csrfTokenValue+'&flag=preAneshesiaDoctorNotes';
  popwindow(url);
}
 
</script>