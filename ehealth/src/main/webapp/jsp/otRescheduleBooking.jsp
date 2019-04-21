<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">

	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
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
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");

	 List opdSurgeryList = new ArrayList();
	 List opdSurgeryDetailList= new ArrayList();
	 List<MasOt> otList = new ArrayList<MasOt>();
	 List empList= new ArrayList();
	 List preAnesthesiaList= new ArrayList();
	List<OtBooking> otBookingList = new ArrayList<OtBooking>();
	List<OtBookSurgeon> otBookSurgeonList = new ArrayList<OtBookSurgeon>();
	
	if(map.get("otBookSurgeonList") != null){
		otBookSurgeonList=(List<OtBookSurgeon>)map.get("otBookSurgeonList");
	}
	
	if(map.get("opdSurgeryList") != null){
		opdSurgeryList=(List)map.get("opdSurgeryList");
	}
	if(map.get("opdSurgeryDetailList") != null){
		opdSurgeryDetailList=(List)map.get("opdSurgeryDetailList");
	}
	if(map.get("otList") != null){
		otList=(List<MasOt>)map.get("otList");
	}
	if(map.get("empList") != null){
		empList=(List)map.get("empList");
	}
	
	if(map.get("otBookingList") != null){
		otBookingList=(List<OtBooking>)map.get("otBookingList");
	}

	if(map.get("preAnesthesiaList") != null){
		preAnesthesiaList=(List)map.get("preAnesthesiaList");
	}
	OpdSurgeryHeader opdSurgeryHeader=(OpdSurgeryHeader)opdSurgeryList.get(0);

	String patientName="";
	String servicePersonName="";
	
	 String requisitionDateInString ="";
	if(otBookingList.size()>0)
	{
		
		if(otBookingList.get(0).getHin().getPFirstName()!= null){
			patientName=otBookingList.get(0).getHin().getPFirstName();
		}
		if(otBookingList.get(0).getHin().getPMiddleName()!= null){
			patientName=patientName+" "+otBookingList.get(0).getHin().getPMiddleName();
		}
		if(otBookingList.get(0).getHin().getPLastName()!= null){
			patientName=patientName+" "+otBookingList.get(0).getHin().getPLastName();
		}
		
		
		
		if(otBookingList.get(0).getHin().getSFirstName()!= null){
			servicePersonName=otBookingList.get(0).getHin().getSFirstName();
		}
		if(otBookingList.get(0).getHin().getSMiddleName()!= null){
			servicePersonName=servicePersonName+" "+otBookingList.get(0).getHin().getSMiddleName();
		}
		if(otBookingList.get(0).getHin().getSLastName()!= null){
			servicePersonName=servicePersonName+" "+otBookingList.get(0).getHin().getSLastName();
		}
		 requisitionDateInString =HMSUtil.changeDateToddMMyyyy(otBookingList.get(0).getSurgeryDate());
		
		
		
		
		
	}
	
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

	%>


<!--main content placeholder starts here-->
<form name="otBooking" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>OT-Booking</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<%if(otBookingList.size()>0){
	
	if(otBookingList.get(0).getOrderNo()!=null)
			{
	%>

<label>Order Number</label> <label class="value"><%=opdSurgeryHeader.getOrderNo()%></label>
<%}else{%>
<label>Order Number</label> <label class="value">-</label>
<%} %>
<%if(otBookingList.get(0).getDepartment().getId()!=null){ %>
<label>Department</label> <label class="value"><%=otBookingList.get(0).getDepartment().getDepartmentName() %></label>
<input type="hidden" name="<%=DEPT_ID%>"
	value="<%=otBookingList.get(0).getDepartment().getId()%>" />
	<%} %>
	
<input type="hidden" name="surgeryId" id="surgeryId" value="<%=otBookingList.get(0).getOpdSurgeryHeader().getId() %>"/> 
<input type="hidden" name="chargeCodeId" id="chargeCodeId" value="<%=otBookingList.get(0).getChargeCode().getId() %>"/>

	 <label>Date</label>
<label class="value"><%=currentDate %></label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<!--Block One Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <%if(otBookingList.get(0).getHin().getId()!= null){ %> <label
	class="value"><%=otBookingList.get(0).getHin().getHinNo() %></label> <%}else{ %>
<label class="value">-</label> <%} %> 
<label>Patient Name </label> <%if(otBookingList.get(0).getHin().getId()!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label>Age</label> <%if(otBookingList.get(0).getHin().getAge()!= null){ %>
<label class="value"><%=otBookingList.get(0).getHin().getAge() %></label> <%}else{ %>
<label class="value">-</label> <%} %>

<div class="clear"></div>

<label>REQ. Date </label> <%if(requisitionDateInString != null){ %> <label
	class="value"><%=requisitionDateInString %></label> <%}else{ %> <label
	class="value">-</label> <%} %>
	<label>Patient Type </label> <%if(opdSurgeryHeader.getPatientStatus()!= null){ %>
<label class="value"><%=opdSurgeryHeader.getPatientStatus() %></label> <input
	type="hidden" name="patientStatus"
	value="<%=opdSurgeryHeader.getPatientStatus() %>" /> <%}else{ %> <label
	class="value">-</label> <%}
	  if(opdSurgeryHeader.getPatientStatus().equalsIgnoreCase("OutPatient")){
	%> <label>Visit No. </label> <%if(opdSurgeryHeader.getVisit()!= null){ %>
<label class="value"><%=opdSurgeryHeader.getVisit().getVisitNo() %></label>
<input name="visitId" type="hidden"
	value="<%=opdSurgeryHeader.getVisit().getId() %>" /> <%}else{ %> <label
	class="value">-</label> <%}
	}%>

<div class="clear"></div>
<%if(opdSurgeryHeader.getPatientStatus().equalsIgnoreCase("InPatient")){
		%> <label>IP No. </label> <%if(opdSurgeryHeader.getInpatient()!= null){ %>
<label class="value"><%=opdSurgeryHeader.getInpatient().getAdNo() %></label>
<input name="inPatientId" type="hidden"
	value="<%=opdSurgeryHeader.getInpatient().getId() %>" /> <%}else{ %> <label
	class="value">-</label> <%}} %>


<div class="clear"></div>
</div>
<h4>OT Booking</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>



<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
 <label>OT Name<span>*</span></label> <select name="otId" id="otId"
	validate="OT To be Booked ,string,yes" class="listSm">
	<option value="0">Select</option>
	<%
					 
					
					for(MasOt ot:otList)
					{
					if(otBookingList.get(0).getOt().getId()==ot.getId())
					{
					%>
										
					
	<option value="<%=ot.getId() %>"   selected="selected"><%=ot.getOtName() %></option>
	<%}else{ %>
	<option value="<%=ot.getId() %>"><%=ot.getOtName() %></option>
	<%
	 }}
	%>
</select>
<%if(otBookingList.get(0).getSurgery().getId()!=null){
	
	String surgeryName="";
	int surgeryId=0;
	String finalSurgery="";
	surgeryName=otBookingList.get(0).getSurgery().getChargeCode().getChargeCodeName();
	surgeryId=otBookingList.get(0).getSurgery().getId();
	finalSurgery=surgeryName+"["+surgeryId +"]";
	%>
<label>Surgery Name<span>*</span></label>
<input type="text" id="chargeCodeName" name="chargeName" value="<%=finalSurgery%>" validate="Charge Code Name.,String,yes"
onblur="submitProtoAjaxWithDivName('otBooking','/hms/hms/ot?method=getOtTime','rateVal');"
 />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">

function eventCallback(element, entry){
	 //var r;
	// if(document.getElementById('rareCommon1').checked == true){
	// r=document.getElementById('rareCommon1').value;
	// }else {
	// r=document.getElementById('rareCommon2').value;
	// }
				return entry + "&otId=" + document.getElementById('otId').value;
		}

new Ajax.Autocompleter('chargeCodeName','ac2update','ot?method=getChargeCodeListForAutoComplete',{parameters:'requiredField=chargeCodeName', callback: eventCallback});
</script>
<%}else{ %>

<label>Surgery Name<span>*</span></label>
<input type="text" id="chargeCodeName" name="chargeName" validate="Charge Code Name.,String,yes"
onblur="submitProtoAjaxWithDivName('otBooking','/hms/hms/ot?method=getOtTime','rateVal');"
 />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">

function eventCallback(element, entry){
	 //var r;
	// if(document.getElementById('rareCommon1').checked == true){
	// r=document.getElementById('rareCommon1').value;
	// }else {
	// r=document.getElementById('rareCommon2').value;
	// }
				return entry + "&otId=" + document.getElementById('otId').value;
		}

new Ajax.Autocompleter('chargeCodeName','ac2update','ot?method=getChargeCodeListForAutoComplete',{parameters:'requiredField=chargeCodeName', callback: eventCallback});
</script>

<%} %>
<%if(otBookingList.get(0).getSurgeryDate()!=null){ %>
	<label>Surgery Date<span>*</span></label> <input type="text"
	id="surgeryDate" name="surgeryDate" value="<%=HMSUtil.convertDateToStringWithoutTime(otBookingList.get(0).getSurgeryDate())%>" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onclick="setdate('<%=currentDate %>',document.otBooking.surgeryDate,event);"
	validate="Pick a date" class="calender" />
	<%}else{ %>
	<label>Surgery Date<span>*</span></label> <input type="text"
	id="surgeryDate" name="surgeryDate" value="" class="date"
	readonly="readonly" MAXLENGTH="30" /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	onclick="setdate('<%=currentDate %>',document.otBooking.surgeryDate,event);"
	validate="Pick a date" class="calender" />
	<%} %>	
	<%if(otBookingList.get(0).getSurgeryTime()!=null){ %>
	<label>Surgery Time</label>
	<input type="text" name="surgeryTime" id="surgeryTime" maxlength="5" value="<%=otBookingList.get(0).getSurgeryTime() %>"
	onKeyUp="mask(this.value,this,'2',':');"
	onblur="timeVal(this.value);" />
	<%}else{ %>
	
	<label>Surgery Time</label>
	<input type="text" name="surgeryTime" id="surgeryTime" maxlength="5" 
	onKeyUp="mask(this.value,this,'2',':');"
	onblur="timeVal(this.value);" />
	
	
	<%} %>

	<input type="hidden" name="endTime" id="endTime" value="<%=otBookingList.get(0).getSurgeryEndTime()%>"/>
	<input type="hidden" name="orderId" id="orderId" value="<%=otBookingList.get(0).getId()%>"/>


<div class="clear"></div>

<label>Booked By<span>*</span></label> <select name="empId" id="empId"
	validate="Booked By,string,yes" class="listSm">
	<option value="0">Select</option>
	<%
					  Iterator itr2= empList.iterator();
					  while(itr2.hasNext())
					  {
						  MasEmployee masEmployee=(MasEmployee)itr2.next();
						int empId=masEmployee.getId();
						String empName="";
						if(masEmployee.getFirstName()!= null)
						    empName=masEmployee.getFirstName();
						if(masEmployee.getMiddleName()!= null)
							empName=empName + masEmployee.getMiddleName();
						if(masEmployee.getLastName()!= null)
							empName=empName + masEmployee.getLastName();
					if(otBookingList.get(0).getBookedBy().getId()==empId)
					{
						%>
	<option value="<%=empId %>" selected="selected"><%=empName %></option>
	<%}else{ %>
	<option value="<%=empId %>"><%=empName %></option>
				<%
	 			 }
				}
				%>
</select> 

<%if(preAnesthesiaList!=null && preAnesthesiaList.size()>0){
	   OtPreAnesthesiaDetails otPreAnesthesiaDetails=(OtPreAnesthesiaDetails)preAnesthesiaList.get(0);

	%> 
	
	<label>Anesth. Type</label> 
	<%if(otPreAnesthesiaDetails.getAnesthticTechnique()!=null){ %>
	<label class="value"><%=otPreAnesthesiaDetails.getAnesthticTechnique().getAnesthesiaName() %></label>
<%}else{ %>
	<label class="value">-</label>
<%} %>

<%
	  if(otPreAnesthesiaDetails.getAsaGrade()!= null && !otPreAnesthesiaDetails.getAsaGrade().equals("")){
		  if(otPreAnesthesiaDetails.getAsaGrade().equals("III")|| otPreAnesthesiaDetails.getAsaGrade().equals("IV")|| otPreAnesthesiaDetails.getAsaGrade().equals("V")) {
	%> <label class="mediumRed">ASA GRADE</label> <%}else{ %> <label>ASA
GRADE</label> <%} %> <label class="value"><%=otPreAnesthesiaDetails.getAsaGrade() %></label>
<%}else{ %> <label class="value">-</label> <%}
}%>

<div class="clear"></div>


<%if(otBookingList.get(0).getBookingType()!=null){
	if(otBookingList.get(0).getBookingType().equalsIgnoreCase("N"))
	{
	%>

<label>Booking Type</label> <select name="bookingType" id="bookingType"
	validate="Booking Type,string,yes" class="listSm">
	<option value="">Select</option>
	<option value="N" selected="selected">Normal</option>
	<option value="E">Emergency</option>
</select>
<%}else{ %>

<label>Booking Type</label> <select name="bookingType" id="bookingType"
	validate="Booking Type,string,yes" class="listSm">
	<option value="">Select</option>
	<option value="N" >Normal</option>
	<option value="E" selected="selected">Emergency</option>
</select>
<%}} %>
<div class="clear"></div>
</div>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<h4>Surgeon's List</h4>
<div class="clear"></div>

<input type="button" class="button" alt="Delete" value="Delete"
	onclick="removeRow();" align="right" /> <input type="button"
	class="button" alt="Add" value="Add" onclick="addRowForSurgeon();"
	align="right" />
<div class="clear"></div>

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="surgeonGrid">
	<tr>
		<th scope="col">S.No</th>
		<th scope="col">Surgeon Name</th>
	</tr>

	<%
	
	int i=1;
	for(OtBookSurgeon otBookSurgeon:otBookSurgeonList){
		String empName="";
		if(otBookSurgeon.getEmployee().getFirstName()!=null)
		{
		empName=otBookSurgeon.getEmployee().getFirstName();
		}
		
				
		if(otBookSurgeon.getEmployee().getLastName()!=null)
		{
		empName+=" "+otBookSurgeon.getEmployee().getLastName();
		}
		empName+="["+otBookSurgeon.getEmployee().getId() +"]";
		%>
	<tr>
		<td><input type="text" size="2" value="<%=i%>" /></td>
		<td>
		 <input type="text"  tabindex="1"
			id="surgeonName<%=i%>" size="43" name="surgeonName<%=i %>" value="<%=empName %>"/>
		<div id="ac2update2" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('surgeonName<%=i%>','ac2update2','ot?method=getSurgeonListForAutoComplete',{parameters:'requiredField=surgeonName<%=i%>'});
				</script></td>
		
	</tr>
	
	<%
	i=i+1;
	} %>
	<input type="hidden" value="<%=otBookSurgeonList.size()%>" name="hiddenValue" id="hiddenValue" />
</table>
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="Submit" class="button" value="Submit"
	onclick="if(validateSurgeonForOTBooking()){submitForm ('otBooking','ot?method=submitOTRescheduleBookingDetails','validateSurgeryDate');}" />
<input name="back" type="button" class="button" value="Back"
	onclick="showBack('otBooking')" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom">

<div class="clear"></div>
<label>Changed By</label> <label class="value"><%=userName %></label> <label>Changed
Date</label> <label class="value"><%=currentDate %></label> <label>Changed
Time</label> <label class="value"><%=currentTime %></label></div>
<input name="hinId" type="hidden"
	value="<%=opdSurgeryHeader.getHin().getId() %>" /> <input
	name="patientStatus" type="hidden"
	value="<%=opdSurgeryHeader.getPatientStatus() %>" /> <input
	name="orderNo" type="hidden"
	value="<%=opdSurgeryHeader.getOrderNo() %>" /> <input
	name="hospitalId" type="hidden" value="<%=hospitalId %>" /> <input
	name="changedBy" type="hidden" value="<%=userName %>" /> <input
	name="changedDate" type="hidden" value="<%=currentDate %>" /> <input
	name="changedTime" type="hidden" value="<%=currentTime %>" />
<div id="rateVal">
<input type=hidden name="hidden" id="hidden" value="<%=otBookingList.get(0).getSurgery().getApproxDuration() %>"/>
</div>
<div class="clear"></div>
<div class="paddingTop40"></div>


<%} %>

</form>
<script type="text/javascript">

function submitProtoAjaxWithDivName(formName,action,divName){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
        	new Ajax.Updater(divName,url,
			   {asynchronous:false, evalScripts:true });
	       	return true;
    }

    function removeRow()
	{
	  var tbl = document.getElementById('surgeonGrid');
	  document.getElementById('hiddenValue').value=document.getElementById('hiddenValue').value-1;
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}

 	function addRowForSurgeon(){

	  var tbl = document.getElementById('surgeonGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)


	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('input');
	  sel.value=hdb.value;
	  sel.size='2'
	  cellRightSel.appendChild(sel);


	  var cellRight1 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'

	  e0.name = 'surgeonName' + iteration;
	  e0.id = 'surgeonName' + iteration;
	  //alert("name--"+e0.name)
	  e0.size = '43'

	  var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update2');
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
    cellRight1.appendChild(newdiv);

	  cellRight1.appendChild(e0);
	new Ajax.Autocompleter('surgeonName'+iteration,'ac2update2','ot?method=getSurgeonListForAutoComplete',{parameters:'requiredField=surgeonName'+iteration});


	}


	function showBack(formName)
	{
	  obj = eval('document.'+formName)
	  obj.action = "/hms/hms/ot?method=showPacClearedListForOTBookingJsp";
	  obj.submit();
	}

	function validateSurgeryDate(){

			var surgeryDate=document.getElementById('surgeryDate').value
 			//alert("surgeryDate----"+ surgeryDate)
		     if(surgeryDate =="")
		    {
				alert("Please Enter The Surgery Date.")
				return false ;
 			}
			return true;
		}


		function validateSurgeonForOTBooking(){
			//alert("document.getElementById('hiddenValue').value---- "+document.getElementById('hiddenValue').value)
			 for(var i = 1; i <= document.getElementById('hiddenValue').value; i++){


			var surgeonName=document.getElementById('surgeonName'+i).value
 			//alert("surgeonName----"+ surgeonName)
		     if(surgeonName !="")
		    {
				return true ;
 			}

  		}
		alert("Please Enter The Surgeon Name.")
		return false;

	}

		function timeVal(timeStr)
		{

			var durationTime=document.getElementById('hidden').value;
			var durationHours=durationTime.substring(0, 2);
			var durationMinutes=durationTime.substring(3, 5);
			durationHours=parseInt(durationHours);
			durationMinutes=parseInt(durationMinutes);

			var strHours=timeStr.substring(0, 2);
			strHours=parseInt(strHours);
			var strMinute=timeStr.substring(3, 5);
			//strHours=parseInt(strHours);
			strMinute=parseInt(strMinute);

			if(strHours==0)
			{
				strHours=timeStr.substring(1, 2);
			}

			var totalMinutes=parseInt(durationMinutes)+parseInt(strMinute);
			//if(strHours>=8 && strHours<10)

			var totalHours=((durationHours)+(parseInt(strHours)));


var remHour=0;
var remMin=0;
var finalHours=0;
var finalMinutes=0;

			if(totalMinutes>=60)
			{
				remHour=Math.floor(totalMinutes/60);

				remMin=totalMinutes%60;
				finalHours=totalHours+remHour;
				finalMinutes=remMin;

			}
			else
			{
				finalHours=totalHours;
				finalMinutes=totalMinutes;

			}
if(finalMinutes<10)
{
	finalMinutes="0"+finalMinutes;

}
if(finalHours<10)
{
	finalHours="0"+finalHours;

}
			var endtime=finalHours+":"+finalMinutes;

			
			document.getElementById('endTime').value=endtime;



getBookingTime();




		}

function getBookingTime()
{
	var surgeryDate=document.getElementById('surgeryDate').value;
	submitProtoAjaxWithDivNameForBooking('otBooking','/hms/hms/ot?method=getOtDateList&surgeryDate='+surgeryDate);
}


function submitProtoAjaxWithDivNameForBooking(formName,action) {
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
	    var url=action;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	    var surgeryEndTime=document.getElementById('endTime').value
	    var surgeryStartTime=document.getElementById('surgeryTime').value
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);
	    xmlHttp.onreadystatechange=function()
	    {
	      if(xmlHttp.readyState==4){
	      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];





	      	for (loop = 0; loop < items.childNodes.length; loop++)
	      	{

			   	    var item = items.childNodes[loop];





		        var id  = item.getElementsByTagName("id")[0];
		        var stime = item.getElementsByTagName("stime")[0];
		        var etime  = item.getElementsByTagName("etime")[0];

			        if(((surgeryStartTime<stime.childNodes[0].nodeValue) && (surgeryEndTime<stime.childNodes[0].nodeValue)) || ((surgeryStartTime>etime.childNodes[0].nodeValue) && (surgeryEndTime>etime.childNodes[0].nodeValue)))
		        {


			    }

			        else
			        {

			        	alert("OT already Booked for this Time Slot......");
						 document.getElementById('surgeryTime').value="";
						 document.getElementById('surgeryTime').focus;
						return true
				     }

	      }
	    }
	  }
	}

	</script>
