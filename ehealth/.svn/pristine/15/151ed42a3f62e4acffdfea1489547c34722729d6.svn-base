<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script type="text/javascript">
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/ot?method=showPostAnaesthesiaPatientDetails";
  obj.submit();
}
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
	
		
		 List<MasAnesthesia> anesthesiaList = new ArrayList<MasAnesthesia>();
		 if(map.get("anesthesiaList") != null){
			 anesthesiaList = (List<MasAnesthesia>) map.get("anesthesiaList");
			}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");	 
	String currentTime = (String)utilMap.get("currentTime");
	
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	 List patientDetailList = new ArrayList();
	 List departmentList = new ArrayList();
	 
			
	if(map.get("patientDetailList") != null){
		
		patientDetailList=(List)map.get("patientDetailList");
		
	}
	if(map.get("departmentList") != null){
			
		departmentList=(List)map.get("departmentList");
			
		}

	if(patientDetailList.size() > 0 && patientDetailList!= null){
	for (Iterator iter1 = patientDetailList.iterator(); iter1.hasNext();) {
		OtBooking otbook = (OtBooking) iter1.next();
	
	List<OtPostAnaesthesiaProcedure> otPostAnaesthesiaProcedureList = new ArrayList<OtPostAnaesthesiaProcedure>();
	if(map.get("otPostAnaesthesiaProcedureList") != null){
		otPostAnaesthesiaProcedureList=(List<OtPostAnaesthesiaProcedure>)map.get("otPostAnaesthesiaProcedureList");
	}	
	if(otPostAnaesthesiaProcedureList.size() > 0 && otPostAnaesthesiaProcedureList!= null){
		
		for (Iterator iter = otPostAnaesthesiaProcedureList.iterator(); iter.hasNext();) {
			OtPostAnaesthesiaProcedure otPostAnaesthesiaProcedure = (OtPostAnaesthesiaProcedure) iter.next();
		
		
		List<OtSurgeyPaEmployeeDetail> surgeyPaEmployeeDetailList = new ArrayList<OtSurgeyPaEmployeeDetail>();
		if(map.get("surgeyPaEmployeeDetailList") != null){
			surgeyPaEmployeeDetailList=(List<OtSurgeyPaEmployeeDetail>)map.get("surgeyPaEmployeeDetailList");
		}
		List<OtSurgeyPaSurgeyDetail> surgeyPaSurgeyDetailList = new ArrayList<OtSurgeyPaSurgeyDetail>();
		if(map.get("surgeyPaSurgeyDetailList") != null){
			surgeyPaSurgeyDetailList=(List<OtSurgeyPaSurgeyDetail>)map.get("surgeyPaSurgeyDetailList");
		}
		List<OtSurgeyPaAnesthesiologistDetail> surgeyPaAnesthesiologistDetailList = new ArrayList<OtSurgeyPaAnesthesiologistDetail>();
		if(map.get("surgeyPaAnesthesiologistDetailList") != null){
			surgeyPaAnesthesiologistDetailList=(List<OtSurgeyPaAnesthesiologistDetail>)map.get("surgeyPaAnesthesiologistDetailList");
		}
		List<OtSurgeyPaIvFluidsDetail> surgeyPaIvFluidsDetailList = new ArrayList<OtSurgeyPaIvFluidsDetail>();
		if(map.get("surgeyPaIvFluidsDetailList") != null){
			surgeyPaIvFluidsDetailList=(List<OtSurgeyPaIvFluidsDetail>)map.get("surgeyPaIvFluidsDetailList");
		}
		List<OtSurgeyPaPremedicationDetail> surgeyPaPremedicationDetailList = new ArrayList<OtSurgeyPaPremedicationDetail>();
		if(map.get("surgeyPaPremedicationDetailList") != null){
			surgeyPaPremedicationDetailList=(List<OtSurgeyPaPremedicationDetail>)map.get("surgeyPaPremedicationDetailList");
		}
		List<OtSurgeyPaProcedureDetail> surgeyPaProcedureDetailList = new ArrayList<OtSurgeyPaProcedureDetail>();
		if(map.get("surgeyPaProcedureDetailList") != null){
			surgeyPaProcedureDetailList=(List<OtSurgeyPaProcedureDetail>)map.get("surgeyPaProcedureDetailList");
		}
		
		
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	String patientName="";
	if(otPostAnaesthesiaProcedure.getHin().getPFirstName()!= null){
		patientName=otPostAnaesthesiaProcedure.getHin().getPFirstName();
	}
	if(otPostAnaesthesiaProcedure.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+otPostAnaesthesiaProcedure.getHin().getPMiddleName();
	}
	if(otPostAnaesthesiaProcedure.getHin().getPLastName()!= null){
		patientName=patientName+" "+otPostAnaesthesiaProcedure.getHin().getPLastName();
	}
	String servicePersonName="";
	if(otPostAnaesthesiaProcedure.getHin().getSFirstName()!= null){
		servicePersonName=otPostAnaesthesiaProcedure.getHin().getSFirstName();
	}
	if(otPostAnaesthesiaProcedure.getHin().getSMiddleName()!= null){
		servicePersonName=servicePersonName+" "+otPostAnaesthesiaProcedure.getHin().getSMiddleName();
	}
	if(otPostAnaesthesiaProcedure.getHin().getSLastName()!= null){
		servicePersonName=servicePersonName+" "+otPostAnaesthesiaProcedure.getHin().getSLastName();
	}
	
%>
<script type="text/javascript">
function get_valueForPACDeatil(patientId)
{

   		var url="/hms/hms/ot?method=showPACDetailJsp&orderNo=<%=otbook.getOrderNo()%>&hinId=<%=otbook.getHin().getId()%>";
   		popwindowGravidagram(url);
  
}
 
 
 function popwindowGravidagram(url)
{

 newwindow=window.open(url,'name',"height=1000, width=1000, scrollbars=yes");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();
 //window.close();
}
</script>









<div class="titleBg">
<h2>Post-Anesthesia Procedure Notes Entry</h2>
</div>
<div class="clear"></div>
<form name="postAnesthesiaProcedure" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="Block"><label>Yearly Serial No</label> <input
	type="text" class="readOnly" readonly="readonly"
	value="<%=otPostAnaesthesiaProcedure.getYearlySlNo() %>"
	name="yearlySlNo" readonly="readonly" /> <label>Monthly Serial
No</label> <input type="text" class="readOnly" readonly="readonly"
	value="<%=otPostAnaesthesiaProcedure.getMonthlySlNo() %>"
	name="monthlySlNo" readonly="readonly" /> <label>Date</label> <input
	type="text" readonly="readonly" id="startDateId" name="<%=START_DATE%>"
	value="<%=HMSUtil.changeDateToddMMyyyy(otPostAnaesthesiaProcedure.getDateOfPost()) %>"
	class="textbox_date" readonly="readonly" validate="Date,date,yes"
	MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" class="date"
	onclick="javascript:setdate('',document.postAnesthesiaProcedure.<%=START_DATE%>,event)" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<!--Block One Starts-->
<div class="Block">
<h4>Patient Details</h4>
<div class="clear"></div>
<label>HIN</label> <%if(otPostAnaesthesiaProcedure.getHin().getHinNo()!= null){ %>
<label class="value"><%=otPostAnaesthesiaProcedure.getHin().getHinNo() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Patient
Name. </label> <%if(patientName!= null){ %> <label class="value"><%=patientName %>
</label> <%}else{ %> <label class="value">- </label> <%} %> <label>Age</label> <%if(otPostAnaesthesiaProcedure.getHin().getAge()!= null){ %>
<label class="value"><%=otPostAnaesthesiaProcedure.getHin().getAge() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Patient
Status </label> <%if(otPostAnaesthesiaProcedure.getHin().getPatientStatus() != null){ %>
<label class="value"><%=otPostAnaesthesiaProcedure.getHin().getPatientStatus() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>

<label>Reg.Date </label> <%if(otPostAnaesthesiaProcedure.getHin().getRegDate()!= null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(otPostAnaesthesiaProcedure.getHin().getRegDate()) %></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>


</div>
<div class="clear"></div>
<div class="Block">
<h4>PAC Details</h4>
<input tabindex="2" name="PAC Preview" type="button" value="PAC Preview"
	class="button"
	onclick="get_valueForPACDeatil(<%=otbook.getOrderNo()%>,<%=otbook.getHin().getId()%>);" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Procedure</h4>
<div class="clear"></div>
<label>Surgery Name</label>

<table id="investigationGridaaa">
	<tr>

		<th scope="col">Surgery Name</th>
		<th scope="col">Surgery Code</th>

	</tr>

	<% if(otbook.getChargeCode()!=null){ %>
	<tr>
		<input type="hidden" value="<%=otbook.getChargeCode().getId() %>" />

		<td><input type="text" readonly="readonly" size="43"
			value="<%=otbook.getChargeCode().getChargeCodeName() %>[<%=otbook.getChargeCode().getId() %>]" /></td>

		<td><input type="text" readonly="readonly" readonly="readonly"
			size="10" value="<%=otbook.getChargeCode().getChargeCodeCode() %>" /></td>

	</tr>
	<%}%>


	<%
	    int q=0;
	    	Iterator surgeyPaSurgeyDetailItr= surgeyPaSurgeyDetailList.iterator();
	    	while(surgeyPaSurgeyDetailItr.hasNext())
	    	{
	    		OtSurgeyPaSurgeyDetail surgeyPaSurgeyDetail=(OtSurgeyPaSurgeyDetail)surgeyPaSurgeyDetailItr.next();
	    		
	    		
	    	
	    %>
	<tr>


		<td><input type="text" readonly="readonly"
			name="chargeCodeName<%=q %>" id="chargeCodeName<%=q %>"
			value="<%=surgeyPaSurgeyDetail.getChargeCode().getChargeCodeName() %>"
			size="43" /></td>

		<td><input type="text" readonly="readonly"
			name="chargeCode<%=q %>" id="chargeCode<%=q %>"
			value="<%=surgeyPaSurgeyDetail.getChargeCode().getChargeCodeCode() %>"
			size="10" /></td>




	</tr>
	<%
	   q++;	}
	  %>
	<tr>
		<%int inc=1; %>

		<td><input type="text" readonly="readonly" value="" tabindex="2"
			id="chargeCodeName1" size="43" name="chargeCodeName1"
			onblur="if(validateSurgeryAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillChargeCode&rowVal=1','chargeCodeVal');}" />
		<div id="ac2update6"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('chargeCodeName1','ac2update6','ot?method=getSurgeyForAutoComplete',{parameters:'requiredField=chargeCodeName1'});
			</script></td>

		<td id="chargeCodeVal"><input type="text" readonly="readonly"
			id="chargeCode1" name="chargeCode1" size="10" tabindex="2" /></td>

		<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />

	</tr>

</table>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<label>Surgeon's Name</label>
<table id="sergonGridaaa">
	<tr>

		<th scope="col">Sergon'S Name</th>

	</tr>
	<% 
  
  Set<OtBookSurgeon> setSS = new HashSet<OtBookSurgeon>();
	setSS = otbook.getOtBookSurgeons();
	for(OtBookSurgeon otBookSurgeonSS : setSS){
	
  	 	%>
	<tr>
		<input type="hidden"
			value="<%=otBookSurgeonSS.getEmployee().getId() %>" />

		<td><input tabindex="2" type="text" readonly="readonly" size="43"
			value="<%=otBookSurgeonSS.getEmployee().getFirstName() %>[<%=otBookSurgeonSS.getEmployee().getId() %>]" /></td>

	</tr>
	<%}%>
	<%
	    int w=0;
	    	Iterator surgeyPaEmployeeDetailItr= surgeyPaEmployeeDetailList.iterator();
	    	while(surgeyPaEmployeeDetailItr.hasNext())
	    	{
	    		OtSurgeyPaEmployeeDetail surgeyPaEmployeeDetail=(OtSurgeyPaEmployeeDetail)surgeyPaEmployeeDetailItr.next();
	    		
	    		
	    	
	    %>
	<tr>


		<td><input type="text" readonly="readonly" name="empNameS<%=w %>"
			id="empNameS<%=w %>"
			value="<%=surgeyPaEmployeeDetail.getEmployee().getFirstName() %>"
			size="43" /></td>





	</tr>
	<%
	   w++;	}
	  %>
	<tr>

		<%int inc1=1; %>


		<td><input type="text" readonly="readonly" value="" tabindex="2"
			id="empNameS1" size="43" name="empNameS1"
			onblur="if(validateSergonAutoComplete(this.value,'<%=inc1 %>')){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillEmpNameSergon&rowVal=1','');}" />
		<div id="ac2update5"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('empNameS1','ac2update5','ot?method=getSergonForAutoComplete',{parameters:'requiredField=empNameS1'});
			</script></td>

		<input type="hidden" value="1" name="hiddenValueSergon"
			id="hiddenValueSergon" />


	</tr>



</table>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<label>Surgery Time</label>
<div class="clear"></div>
<label>From</label> <%if(otPostAnaesthesiaProcedure.getSurgeyFromTime() != "" && otPostAnaesthesiaProcedure.getSurgeyFromTime()!=null){ %>
<input tabindex="2" class="readOnly" readonly="readonly"
	name="surgey_from_time" type="text" readonly="readonly"
	readonly="readonly" maxlength="7"
	value="<%=otPostAnaesthesiaProcedure.getSurgeyFromTime() %>" /> <%}else{ %>
<input tabindex="2" class="readOnly" readonly="readonly"
	name="surgey_from_time" type="text" readonly="readonly"
	readonly="readonly" maxlength="7" /> <%} %> <label>To</label> <%if(otPostAnaesthesiaProcedure.getSurgeyToTime() != "" && otPostAnaesthesiaProcedure.getSurgeyToTime()!=null){ %>
<input name="surgey_to_time" class="readOnly" readonly="readonly"
	tabindex="2" type="text" readonly="readonly" readonly="readonly"
	maxlength="7"
	value="<%=otPostAnaesthesiaProcedure.getSurgeyToTime() %>" /> <%}else{ %>
<input name="surgey_to_time" class="readOnly" readonly="readonly"
	tabindex="2" type="text" readonly="readonly" readonly="readonly"
	maxlength="7" /> <%} %> <label>Anesthesia</label> <select
	id="anesthesia_id" readonly="readonly" name="anesthesia_id"
	validate="Anesthesia,string,no" tabindex="2"
	onchange="anesthesiaCheck();">

	<option value="0">Select</option>
	<%
	 		for(MasAnesthesia obj : anesthesiaList){
	 		%>
	<option value="<%=obj.getId() %>"><%=obj.getAnesthesiaName()%></option>
	<%
	 			}%>
</select> <script type="text/javascript">
          	<%  if(otPostAnaesthesiaProcedure.getAnesthesia()  != null){
			 			int aId = otPostAnaesthesiaProcedure.getAnesthesia().getId() ;
					%>
					document.postAnesthesiaProcedure.anesthesia_id.value = '<%=aId %>';
               <%		
			 		}%>
           </script>



<div class="clear"></div>
<label>Anesthesiologist(s)</label>
<table id="anesthesiologistGridaaa">
	<tr>

		<th scope="col">Anesthesiologist's Name</th>
	</tr>
	<% 
  
  Set<OtBookSurgeon> setA = new HashSet<OtBookSurgeon>();
	setA = otbook.getOtBookSurgeons();
	for(OtBookSurgeon otBookSurgeonA : setA){
	
  	 	%>
	<tr>
		<input type="hidden"
			value="<%=otBookSurgeonA.getEmployee().getId() %>" />

		<td><input tabindex="2" type="text" readonly="readonly"
			readonly="readonly" size="43"
			value="<%=otBookSurgeonA.getEmployee().getFirstName() %>[<%=otBookSurgeonA.getEmployee().getId() %>]"
			readonly="readonly" /></td>

	</tr>
	<%}%>

	<%
	    int u=0;
	    	Iterator surgeyPaAnesthesiologistDetailItr= surgeyPaAnesthesiologistDetailList.iterator();
	    	while(surgeyPaAnesthesiologistDetailItr.hasNext())
	    	{
	    		OtSurgeyPaAnesthesiologistDetail surgeyPaAnesthesiologistDetail=(OtSurgeyPaAnesthesiologistDetail)surgeyPaAnesthesiologistDetailItr.next();
	    		
	    		
	    	
	    %>
	<tr>


		<td><input type="text" readonly="readonly" readonly="readonly"
			readonly="readonly" name="empName<%=u %>" id="empName<%=u %>"
			value="<%=surgeyPaAnesthesiologistDetail.getEmployee().getFirstName() %>"
			size="43" /></td>





	</tr>
	<%
	   u++;	}
	  %>
	<tr>

		<%int inc2=1; %>


		<td><input type="text" readonly="readonly" readonly="readonly"
			value="" tabindex="2" id="empName1" size="43" name="empName1"
			onblur="if(validateAnesthesiologistAutoComplete(this.value,'<%=inc2 %>')){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillEmpNameAnesthesiologist&rowVal=1','');}" />
		<div id="ac2update4"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('empName1','ac2update4','ot?method=getSergonForAutoComplete',{parameters:'requiredField=empName1'});
			</script></td>


		<input type="hidden" value="1" name="hiddenValueAnesthesiologist"
			id="hiddenValueAnesthesiologist" />


	</tr>



</table>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<label>Anesthesia Time</label><label class="valueNoWidth">From</label> <%if(otPostAnaesthesiaProcedure.getAnaesthesiaFromTime() != "" && otPostAnaesthesiaProcedure.getAnaesthesiaFromTime()!=null){ %>

<input tabindex="2" name="anaesthesia_from_time" type="text"
	class="readOnly" readonly="readonly" readonly="readonly" maxlength="7"
	value="<%=otPostAnaesthesiaProcedure.getAnaesthesiaFromTime() %>" /> <%}else{ %>
<input tabindex="2" name="anaesthesia_from_time" type="text"
	class="readOnly" readonly="readonly" readonly="readonly" maxlength="7" />
<%} %> <label>To</label> <%if(otPostAnaesthesiaProcedure.getAnaesthesiaToTime() != "" && otPostAnaesthesiaProcedure.getAnaesthesiaToTime()!=null){ %>
<input name="anaesthesia_to_time" tabindex="2" type="text"
	readonly="readonly" readonly="readonly" maxlength="7"
	value="<%=otPostAnaesthesiaProcedure.getAnaesthesiaToTime() %>" /> <%}else{ %>
<input name="anaesthesia_to_time" tabindex="2" type="text"
	readonly="readonly" readonly="readonly" maxlength="7" /> <%} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<label>Premedication/ Induction/ Maintenance </label>

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="premedicationGridaaa">
	<tr>
		<th scope="col">Type</th>
		<th scope="col">Nomenclature</th>
		<th scope="col">PVMS/ NIV No.</th>
		<th scope="col">Dose</th>
		<th scope="col">Route</th>
	</tr>

	<%
	    int i=0;
	    	Iterator surgeyPaPremedicationDetailItr= surgeyPaPremedicationDetailList.iterator();
	    	while(surgeyPaPremedicationDetailItr.hasNext())
	    	{
	    		OtSurgeyPaPremedicationDetail surgeyPaPremedicationDetail=(OtSurgeyPaPremedicationDetail)surgeyPaPremedicationDetailItr.next();
	    		
	    		
	    	
	    %>
	<tr>


		<td>
		<%if(surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailType()!= "p" && surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailType().equals("p"))
 { %> <input type="text" readonly="readonly" readonly="readonly"
			name="typePIM1<%=i %>" id="typePIM1<%=i %>" value="Premedication" />
		<%}else if(surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailType()!= "i" && surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailType().equals("i")){ %>
		<input type="text" readonly="readonly" readonly="readonly"
			name="typePIM1<%=i %>" id="typePIM1<%=i %>" value="Induction" /> <%}else if(surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailType()!= "m" && surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailType().equals("m")){ %>
		<input type="text" readonly="readonly" readonly="readonly"
			name="typePIM1<%=i %>" id="typePIM1<%=i %>" value="Maintenance" /> <%}else{ %>
		<label class="value">-</label> <%} %>
		</td>
		<td><input type="text" readonly="readonly" readonly="readonly"
			name="nomenclaturePr1<%=i %>" id="nomenclaturePr1<%=i %>"
			value="<%=surgeyPaPremedicationDetail.getItem().getNomenclature() %>"
			size="43" /></td>

		<td><input type="text" readonly="readonly" readonly="readonly"
			name="pvmsNoPr1<%=i %>" id="pvmsNoPr1<%=i %>"
			value="<%=surgeyPaPremedicationDetail.getItem().getPvmsNo() %>"
			size="10" /></td>


		<td><input type="text" readonly="readonly" readonly="readonly"
			name="dv1<%=i %>" id="dv1<%=i %>"
			value="<%=surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailDosa() %>"
			size="10" /></td>

		<td><input type="text" readonly="readonly" readonly="readonly"
			name="route1<%=i %>" id="route1<%=i %>"
			value="<%=surgeyPaPremedicationDetail.getSurgeyPaPremedicationDetailRoute() %>"
			size="10" /></td>


	</tr>
	<%
	   i++;	}
	  %>
	<tr>
		<td><select name="typePIM1" id="typePIM1" tabindex="2">
			<option value="">Select</option>
			<option value="p">Premedication</option>
			<option value="i">Induction</option>
			<option value="m">Maintenance</option>
		</select></td>
		<td><input type="text" readonly="readonly" readonly="readonly"
			value="" tabindex="2" id="nomenclaturePr1" size="43"
			name="nomenclaturePr1" onblur="populatePVMSPr1(this.value)" />
		<div id="ac2update3"
			style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclaturePr1','ac2update3','ot?method=getItemPrListForAutoComplete',{parameters:'requiredField=nomenclaturePr1'});
			</script></td>
		<td><input type="text" readonly="readonly" readonly="readonly"
			name="pvmsNoPr1" id="pvmsNoPr1" size="10" /></td>



		<td><input type="text" readonly="readonly" readonly="readonly"
			size="10" id="dv1" name="dv1" maxlength="20" tabindex="2" /></td>


		<td><select name="route1" id="route1" tabindex="2">
			<option value="">Select</option>
			<option value="1/V">1/V</option>
			<option value="1/M">1/M</option>
			<option value="Oral">Oral</option>
			<option value="S.C.">S.C.</option>
		</select></td>
		<input type="hidden" value="1" name="hiddenValuePremedication"
			id="hiddenValuePremedication" />
	</tr>
</table>


<div class="clear"></div>
<label>Procedure Details </label>

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="procedureGridaa">
	<tr>
		<th scope="col">Anesthesia</th>
		<th scope="col">Nomenclature</th>
		<th scope="col">PVMS/ NIV No.</th>
		<th scope="col">Dose</th>
		<th scope="col">level</th>
		<th scope="col">Catheter</th>
	</tr>



	<%
	    int x=0;
	    	Iterator surgeyPaProcedureDetailItr= surgeyPaProcedureDetailList.iterator();
	    	while(surgeyPaProcedureDetailItr.hasNext())
	    	{
	    		OtSurgeyPaProcedureDetail surgeyPaProcedureDetail=(OtSurgeyPaProcedureDetail)surgeyPaProcedureDetailItr.next();
	    		
	    		
	    	
	    %>
	<tr>


		<td><input type="text" readonly="readonly" readonly="readonly"
			name="anesthesia1<%=x %>" id="anesthesia1<%=x %>"
			value="<%=surgeyPaProcedureDetail.getSurgeyPaProcedureDetailAnesthesia() %>" />
		</td>
		<td><input type="text" readonly="readonly" readonly="readonly"
			name="nomenclatureP1<%=x %>" id="nomenclatureP1<%=x %>"
			value="<%=surgeyPaProcedureDetail.getItem().getNomenclature() %>"
			size="43" /></td>

		<td><input type="text" readonly="readonly" readonly="readonly"
			name="pvmsNoP1<%=x %>" id="pvmsNoP1<%=x %>"
			value="<%=surgeyPaProcedureDetail.getItem().getPvmsNo() %>" size="10" />
		</td>


		<td><input type="text" readonly="readonly" readonly="readonly"
			name="d1<%=x %>" id="d1<%=x %>"
			value="<%=surgeyPaProcedureDetail.getSurgeyPaProcedureDetailDosa() %>"
			size="10" /></td>

		<td><input type="text" readonly="readonly" readonly="readonly"
			name="level1<%=x %>" id="level1<%=x %>"
			value="<%=surgeyPaProcedureDetail.getSurgeyPaProcedureDetailLevel() %>"
			size="10" /></td>
		<td><input type="text" readonly="readonly" readonly="readonly"
			name="c1<%=x %>" id="c1<%=x %>"
			value="<%=surgeyPaProcedureDetail.getSurgeyPaProcedureDetailCatheter() %>"
			size="10" /></td>

	</tr>
	<%
	   x++;	}
	  %>

	<tr>

		<% if(otPostAnaesthesiaProcedure.getAnesthesia()==null){ %>
		<td id=s1>-</td>
		<%}else{ %>
		<td id=s2 style="display: none;"><select name="anesthesia1"
			id="anesthesia1" tabindex="2" onchange="anesthesiaCobom();">
			<option value="">Select</option>
			<option value="EACath">EA + Cath</option>
			<option value="RA">RA</option>
			<option value="SA">SA</option>
			<option value="Caudal">Caudal</option>
			<option value="EA">EA</option>
		</select></td>
		<%}%>
		<td><input type="text" readonly="readonly" readonly="readonly"
			value="" tabindex="2" id="nomenclatureP1" size="43"
			name="nomenclatureP1" onblur="populatePVMSP1(this.value)" />
		<div id="ac2update2"
			style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclatureP1','ac2update2','ot?method=getItemPListForAutoComplete',{parameters:'requiredField=nomenclatureP1'});
			</script></td>
		<td><input type="text" readonly="readonly" readonly="readonly"
			name="pvmsNoP1" id="pvmsNoP1" size="10" /></td>



		<td><input type="text" readonly="readonly" readonly="readonly"
			size="10" id="d1" name="d1" maxlength="20" tabindex="2" /></td>

		<td id="s3">-</td>
		<td id="s4" style="display: none;"><select name="level1"
			id="level1" tabindex="2">
			<option value="">Select</option>
			<option value="L1-2">L1-2</option>
			<option value="L2-3">L2-3</option>
			<option value="L3-L4">L3-L4</option>

		</select></td>


		<td id="s5" style="display: none;"><select name="level1"
			id="level1" tabindex="2">
			<option value="">Select</option>
			<option value="T1-2">T1-2</option>
			<option value="T2-3">T2-3</option>
			<option value="T3-4">T3-4</option>
			<option value="T4-5">T4-5</option>
			<option value="T5-6">T5-6</option>
			<option value="T6-7">T6-7</option>
			<option value="T8-L1">T8-L1</option>
			<option value="L1-L2">L1-L2</option>
			<option value="L2-L3">L2-L3</option>
			<option value="L3-L4">L3-L4</option>
		</select></td>


		<td><input type="text" readonly="readonly" readonly="readonly"
			size="10" id="c1" name="c1" maxlength="20" tabindex="2" /></td>
		<input type="hidden" value="1" name="hiddenValueProcedure"
			id="hiddenValueProcedure" />
	</tr>
</table>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="Block"><label>ETT/ LMA</label> <select name="ett_lma"
	id="ett_lma" tabindex="2">
	<%

   if(otPostAnaesthesiaProcedure.getEttLma().equals("e")) {%>

	<option value="e" selected="selected">ETT Size</option>
	<option value="l">LMA Size</option>
	<%}else if(otPostAnaesthesiaProcedure.getEttLma().equals("l")){ %>
	<option value="e">ETT Size</option>
	<option value="l" selected="selected">LMA Size</option>


	<%}else{ %>

	<option value="">Select</option>
	<option value="e">ETT Size</option>
	<option value="l">LMA Size</option>



	<%}%>
</select> <%if(otPostAnaesthesiaProcedure.getEttLmaText() != 0 ){ %> <input
	name="ett_lma_text" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" maxlength="7" validate="ETT/ LMA Text,num,no"
	tabindex="2" value="<%=otPostAnaesthesiaProcedure.getEttLmaText() %>" />
<%}else{ %> <input name="ett_lma_text" type="text" class="readOnly"
	readonly="readonly" readonly="readonly" maxlength="7"
	validate="ETT/ LMA Text,num,no" tabindex="2" /> <%} %>


<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Monitoring</h4>
<div class="Block"><label>ECG</label> <%if(otPostAnaesthesiaProcedure.getEcg() != "" && otPostAnaesthesiaProcedure.getEcg()!=null){ %>
<input name="ecg" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" tabindex="2" maxlength="15"
	value="<%=otPostAnaesthesiaProcedure.getEcg() %>" /> <%}else{ %> <input
	name="ecg" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" tabindex="2" maxlength="15" /> <%} %> <label>NIBP</label>

<%if(otPostAnaesthesiaProcedure.getNibp() != "" && otPostAnaesthesiaProcedure.getNibp()!=null){ %>
<input name="nibp" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" class="calDate" tabindex="2" maxlength="7"
	value="<%=otPostAnaesthesiaProcedure.getNibp() %>" /> <%}else{ %> <input
	name="nibp" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" class="calDate" tabindex="2" maxlength="7" /> <%} %>
<label class="unit">mm Hg </label> <label>CVP</label> <%if(otPostAnaesthesiaProcedure.getCvp() != "" && otPostAnaesthesiaProcedure.getCvp()!=null){ %>
<input name="cvp" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" class="calDate" tabindex="2" maxlength="3"
	value="<%=otPostAnaesthesiaProcedure.getCvp() %>" /> <%}else{ %> <input
	name="cvp" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" class="calDate" tabindex="2" maxlength="3" /> <%} %>
<label class="unit">cm H<sub>2</sub>O </label> <label>Temp</label> <%if(otPostAnaesthesiaProcedure.getTemp() != "" && otPostAnaesthesiaProcedure.getTemp()!=null){ %>
<input name="temp" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" size="5" tabindex="2" maxlength="15"
	value="<%=otPostAnaesthesiaProcedure.getTemp() %>" /> <%}else{ %> <input
	name="temp" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" size="5" tabindex="2" maxlength="15" /> <%} %>

<div class="clear"></div>
<label>S<sub>p</sub>O<sub>2</sub></label> <%if(otPostAnaesthesiaProcedure.getSp02() != "" && otPostAnaesthesiaProcedure.getSp02()!=null){ %>
<input name="sp02" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" tabindex="2" maxlength="15"
	value="<%=otPostAnaesthesiaProcedure.getSp02() %>" /> <%}else{ %> <input
	name="sp02" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" tabindex="2" maxlength="15" /> <%} %> <label>LABP</label>

<%if(otPostAnaesthesiaProcedure.getIabp() != "" && otPostAnaesthesiaProcedure.getIabp()!=null){ %>

<input name="labp" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" tabindex="2" maxlength="7"
	value="<%=otPostAnaesthesiaProcedure.getIabp() %>" /> <%}else{ %> <input
	name="labp" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" tabindex="2" maxlength="7" /> <%} %> <label
	class="unit">mm Hg </label> <label>UO</label> <%if(otPostAnaesthesiaProcedure.getUo() != "" && otPostAnaesthesiaProcedure.getUo()!=null){ %>
<input name="uo" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" tabindex="2" maxlength="3"
	value="<%=otPostAnaesthesiaProcedure.getUo() %>" /> <%}else{ %> <input
	name="uo" type="text" class="readOnly" readonly="readonly"
	readonly="readonly" tabindex="2" maxlength="3" /> <%} %> <label
	class="unit">ml</label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<label>IV Fluids </label>
<table width="100%" border="0" cellspacing="0" cellpadding="0" id="asas">
	<tr>

		<th scope="col">Nomenclature</th>
		<th scope="col">PVMS/ NIV No.</th>
		<th scope="col">Fluid Name</th>
		<th scope="col">Volume (ml)</th>
	</tr>



	<%
	    int y=0;
	    	Iterator surgeyPaIvFluidsDetailItr= surgeyPaIvFluidsDetailList.iterator();
	    	while(surgeyPaIvFluidsDetailItr.hasNext())
	    	{
	    		OtSurgeyPaIvFluidsDetail surgeyPaIvFluidsDetail=(OtSurgeyPaIvFluidsDetail)surgeyPaIvFluidsDetailItr.next();
	    		
	    		
	    	
	    %>
	<tr>


		<td><input type="text" readonly="readonly" readonly="readonly"
			name="nomenclature1<%=y %>" id="nomenclature1<%=y %>"
			value="<%=surgeyPaIvFluidsDetail.getItem().getNomenclature() %>"
			size="43" /></td>

		<td><input type="text" readonly="readonly" readonly="readonly"
			name="pvmsNo1<%=y %>" id="pvmsNo1<%=y %>"
			value="<%=surgeyPaIvFluidsDetail.getItem().getPvmsNo() %>" size="10" />
		</td>


		<td>
		<%if(surgeyPaIvFluidsDetail.getSurgeyPaIvFluidsDetailFluidsName() != "" && surgeyPaIvFluidsDetail.getSurgeyPaIvFluidsDetailFluidsName()!=null){ %>
		<input type="text" readonly="readonly" readonly="readonly"
			name="fluidName<%=y %>" id="fluidName<%=y %>"
			value="<%=surgeyPaIvFluidsDetail.getSurgeyPaIvFluidsDetailFluidsName() %>"
			size="10" /> <%}else{ %> <label class="value">-</label> <%} %>
		</td>


		<td><input type="text" readonly="readonly" readonly="readonly"
			name="v1<%=y %>" id="v1<%=y %>"
			value="<%=surgeyPaIvFluidsDetail.getSurgeyPaIvFluidsDetailVolume() %>"
			size="10" /></td>

	</tr>
	<%
	   y++;	}
	  %>



	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		id="fluidsGrid">
		<tr>


			<td><input type="text" readonly="readonly" readonly="readonly"
				value="" tabindex="2" id="nomenclature1" size="43"
				name="nomenclature1" onblur="populatePVMS(this.value)" />
			<div id="ac2update1"
				style="font-weight: normal; display: none; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			  new Ajax.Autocompleter('nomenclature1','ac2update1','ot?method=getItemListForAutoComplete',{parameters:'requiredField=nomenclature1'});
			</script></td>
			<td><input type="text" readonly="readonly" readonly="readonly"
				name="pvmsNo1" id="pvmsNo1" size="10" /></td>


			<td><input name="fluidName1" id="fluidName1" type="text"
				readonly="readonly" readonly="readonly" size="10" maxlength="30"
				tabindex="2" /></td>

			<td><input type="text" readonly="readonly" readonly="readonly"
				size="5" id="v1" name="v1" maxlength="3" validate="Volume,num,no"
				tabindex="2" /></td>
			<input type="hidden" value="1" name="hiddenValueFluids"
				id="hiddenValueFluids" />
		</tr>




	</table>
	<div class="clear"></div>
	<div class="division"></div>
	<div class="clear"></div>
	<h4>Reversal</h4>
	<div class="clear"></div>
	<div class="Block"><label>Neostigmine</label> <%if(otPostAnaesthesiaProcedure.getNeostigmine() != 0){ %>
	<input name="neostigmine" type="text" class="readOnly"
		readonly="readonly" readonly="readonly" tabindex="2" maxlength="7"
		validate="Neostigmine,num,no"
		value="<%=otPostAnaesthesiaProcedure.getNeostigmine() %>" /> <%}else{ %>
	<input name="neostigmine" type="text" class="readOnly"
		readonly="readonly" readonly="readonly" tabindex="2" maxlength="7"
		validate="Neostigmine,num,no" /> <%} %> <label class="small">mg</label>
	<label>Glycophyrrolate</label> <%if(otPostAnaesthesiaProcedure.getGlycophyrrolate() != 0){ %>
	<input name="glycophyrrolate" type="text" class="readOnly"
		readonly="readonly" readonly="readonly" tabindex="2" maxlength="7"
		validate="Glycophyrrolate,num,no"
		value="<%=otPostAnaesthesiaProcedure.getGlycophyrrolate() %>" /> <%}else{ %>
	<input name="glycophyrrolate" type="text" class="readOnly"
		readonly="readonly" readonly="readonly" tabindex="2" maxlength="7"
		validate="Glycophyrrolate,num,no" /> <%} %> <label class="small">mm&nbsp;&nbsp;
	&nbsp;&nbsp; </label> <label>Others</label> <%if(otPostAnaesthesiaProcedure.getOthers() != 0){ %>
	<input name="others" type="text" class="readOnly" readonly="readonly"
		readonly="readonly" tabindex="2" maxlength="7"
		validate="others,num,no"
		value="<%=otPostAnaesthesiaProcedure.getOthers() %>" /> <%}else{ %> <input
		name="others" type="text" class="readOnly" readonly="readonly"
		readonly="readonly" tabindex="2" maxlength="7"
		validate="others,num,no" /> <%} %>

	<div class="clear"></div>
	<label>Recovery</label> <%if(otPostAnaesthesiaProcedure.getRecovery() != "" && otPostAnaesthesiaProcedure.getRecovery()!=null){ %>
	<input type="text" readonly="readonly" class="readOnly"
		readonly="readonly"
		value="<%=otPostAnaesthesiaProcedure.getRecovery() %>" name="recovery">
	<%}else{ %> <textarea maxlength="200" onkeyup="return ismaxlength(this)"
		name="recovery" cols="0" rows="0" tabindex="2"></textarea> <%} %>
	<div class="clear"></div></div>

	<div class="clear"></div>
	<div class="Block">
	<div class="clear"></div>
	<label>Risk Grade</label> <%if(otPostAnaesthesiaProcedure.getRiskGrade() != "" && otPostAnaesthesiaProcedure.getRiskGrade()!=null){ %>
	<input type="text" class="readOnly" readonly="readonly"
		value="<%=otPostAnaesthesiaProcedure.getRiskGrade() %>"
		name="risk_grade" id="risk1"> <%}else{ %> <select
		name="risk_grade" id="risk1" class="date" tabindex="2">
		<option value="">Select</option>
		<option value="I">I</option>
		<option value="II">II</option>
		<option value="3">III</option>
		<option value="IV">IV</option>
	</select> <%} %> <label>E/ Others</label> <select name="e_others" id="eo1"
		class="date" tabindex="2">
		<%

   if(otPostAnaesthesiaProcedure.getEOthers().equals("e")) {%>

		<option value="e" selected="selected">E</option>
		<option value="o">Others</option>
		<%}else if(otPostAnaesthesiaProcedure.getEOthers().equals("o")){ %>
		<option value="e">E</option>
		<option value="o" selected="selected">Others</option>


		<%}else{ %>

		<option value="">Select</option>
		<option value="e">E</option>
		<option value="o">Others</option>



		<%}%>
	</select> <label>Remarks</label> <%if(otPostAnaesthesiaProcedure.getRemarks() != "" && otPostAnaesthesiaProcedure.getRemarks()!=null){ %>
	<input type="text" class="readOnly" readonly="readonly"
		value="<%=otPostAnaesthesiaProcedure.getRemarks() %>" name="remarks">

	<%}else{ %> <textarea maxlength="100" readonly="readonly"
		onkeyup="return ismaxlength(this)" name="remarks" cols="0" rows="0"
		tabindex="2"></textarea> <%} %>
	<div class="clear"></div></div>

	<div class="clear"></div>


	<!-- <input type="button" name="update"  class="button" value="Update" onclick="submitForm ('postAnesthesiaProcedure','ot?method=updateOtPostAnesthesiaProcedure')"/>--->

	<input type="button" name="Back" class="button" value="Back"
		onclick="submitForm ('postAnesthesiaProcedure','ot?method=searchOtPostAnesthesiaProcedure')" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="bottom"><label>Changed By</label> <label
		class="value"><%=userName %></label> <label>Changed Date</label> <label
		class="value"><%=currentDate %></label> <label>Changed Time</label> <label
		class="value"><%=currentTime %></label> <input name="userName"
		id="userName" type="hidden" value="<%=userName %>" /> <input
		type="hidden" name="orderNo" value="<%=otbook.getOrderNo() %>" /> <input
		name="hinId" type="hidden" value="<%=otbook.getHin().getId()%>" /> <input
		name="departmentId" type="hidden"
		value="<%=otbook.getDepartment().getId()%>" /> <input
		name="hospitalId" type="hidden" value="<%=hospitalId%>" /> <input
		name="changedDate" type="hidden" value="<%=currentDate %>" /> <input
		name="changedTime" type="hidden" value="<%=currentTime %>" /> <input
		name="postId" type="hidden"
		value="<%=otPostAnaesthesiaProcedure.getId()%>" />
	<div class="clear"></div>
	<div class="paddingTop40"></div>
	<div class="clear"></div>
	</div>
	 


 </form>
	<%}}}}%>





	<script type="text/javascript" language="javascript">

//----------------------------------------------  Premedication-------------------------	
		function populatePVMSPr1(val){
		//alert("in method--")
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvmsNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var brandName=val.substring(0,indexForBrandName);
		   //  alert("pvms no--"+pvmsNo)	
		   
	   
	 
	  if(pvmsNo == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)	
	   	document.getElementById('nomenclaturePr1').value="";
	    document.getElementById('pvmsNoPr1').value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNoPr1').value=pvmsNo
	 }
	}	
function addRowForPremedication(){
		
	  var tbl = document.getElementById('premedicationGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValuePremedication');
	  hdb.value=iteration+1
	//   alert("iteration row--"+iteration)
	 

 	var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('Select');
	   e1.name='typePIM'+(iteration+1);
	  e1.id='typePIM'+(iteration+1);
	  e1.classname='smalllabel'
	   e1.options[0] = new Option('Select', '');
	   e1.options[1] = new Option('Premedication', 'p');
	   e1.options[2] = new Option('Induction', 'i');
	   e1.options[3] = new Option('Maintenance', 'm');
	  	   
	   cellRight1.appendChild(e1); 
	 
	
    var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
	  						
	                      // alert('event added--'+e0.value+"iteration--"+iteration);
	                       var val=e0.value
	                       if(val != "")
							{
					    	
						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);
						    	//alert("nomenclature---"+nomenclature)
						   	 if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclaturePr'+(iteration+1)).value="";
	   								document.getElementById('pvmsNoPr'+(iteration+1)).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNoPr'+(iteration+1)).value=pvmsNo
						   }
	  					  };
	  e0.name = 'nomenclaturePr' + (iteration+1);
	  e0.id = 'nomenclaturePr' + (iteration+1);
	 
	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclaturePr'+(iteration+1),'ac2update3','ot?method=getItemPrList',{parameters:'requiredField=nomenclaturePr'+(iteration+1)});
	
	  
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoPr'+(iteration+1);
	  sel.id='pvmsNoPr'+(iteration+1)
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	  
	  
	 
	 
	  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'dv' + (iteration+1);
	  e3.id = 'dv' + (iteration+1);
	  e3.size = '10'
	  cellRight3.appendChild(e3);
	 
	 
	 
	 
	 var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('Select');
	 
	  e4.name='route'+(iteration+1);
	  e4.id='route'+(iteration+1);
	  e4.classname='smalllabel'
	   e4.options[0] = new Option('Select', '');
	   e4.options[1] = new Option('1/V', '1/V');
	   e4.options[2] = new Option('1/M', '1/M');
	   e4.options[3] = new Option('Oral', 'Oral');
	    e4.options[4] = new Option('S.C.', 'S.C.');
	   cellRight4.appendChild(e4); 
	 	 

	 
	}
	function removeRowForPremedication()
	{
	  var tbl = document.getElementById('premedicationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 1) 
	  {
	  tbl.deleteRow(lastRow - 1);
	  var hdb = document.getElementById('hiddenValuePremedication');
	  hdb.value=lastRow - 1;
	  }
	}	
	

	
	//-------------------------------Procedure --------------------------------
	
		function populatePVMSP1(val){
		//alert("in method--")
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvmsNoP = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var brandName=val.substring(0,indexForBrandName);
		   //  alert("pvms no--"+pvmsNo)	
		   
	   
	 
	  if(pvmsNoP == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)	
	   	document.getElementById('nomenclatureP1').value="";
	    document.getElementById('pvmsNoP1').value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNoP1').value=pvmsNoP
	 }
	}	
	

function addRowForProcedure(){
		
	  var tbl = document.getElementById('procedureGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValueProcedure');
	  hdb.value=iteration+1
	//   alert("iteration row--"+iteration)
	 
 	var val = document.getElementById('anesthesia_id').value;
	if(val != 0){
 	var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('Select');
	 
	  e1.name='anesthesia'+(iteration+1);
	  e1.id='anesthesia'+(iteration+1);
	  e1.classname='smalllabel'
	   e1.options[0] = new Option('Select', '');
	   e1.options[1] = new Option('SA', 'SA');
	   e1.options[2] = new Option('EACath', 'EACath');
	   e1.options[3] = new Option('EA', 'EA');
	   e1.options[4] = new Option('RA', 'RA');
	   e1.options[5] = new Option('Caudal', 'Caudal');
	        	   
	           cellRight1.appendChild(e1); 	   
	        	   e1.onblur=function(){
	  						
	                       var val=e1.value
	                       if(val == "SA")
							{
					    		var cellRight0 = row.insertCell(1);
	 							var e0 = document.createElement('input');
	  							e0.type = 'text';
	  							e0.name = 'nomenclatureP' + (iteration+1);
	  							e0.id = 'nomenclatureP' + (iteration+1);
	  							e0.value='Bupivacaie HCL Inj 0.5% heavy amp of 4ml [010116]'
	  							e0.size = '43'
	 							cellRight0.appendChild(e0);
						    						    
		  						var cellRightSel = row.insertCell(2);
	  							var sel = document.createElement('input');
	  							sel.type = 'text';
	  							sel.name='pvmsNoP'+(iteration+1);
								  sel.id='pvmsNoP'+(iteration+1)
								  sel.value='010116'
								  sel.size = '10'
								  cellRightSel.appendChild(sel);
								
								
											
				  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'd' + (iteration+1);
	  e3.id = 'd' + (iteration+1);
	  e3.size = '10'
	  cellRight3.appendChild(e3);

								
									 var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('Select');
	 
	  e4.name='level'+(iteration+1);
	  e4.id='level'+(iteration+1);
	  e4.classname='smalllabel'
	   e4.options[0] = new Option('Select', '');
	   e4.options[1] = new Option('L1-2', 'L1-2');
	   e4.options[2] = new Option('L2-3', 'L2-3');
	   e4.options[3] = new Option('L3-4', 'L3-4');
	   cellRight4.appendChild(e4); 

	 	 
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'c' + (iteration+1);
	  e5.id = 'c' + (iteration+1);
	
	  e5.size = '10'
	  cellRight5.appendChild(e5);
	   
	   
	   
  }
						   else if(val == "EA")
						   {
						   var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'nomenclatureP' + (iteration+1);
	  e0.id = 'nomenclatureP' + (iteration+1);
	  e0.value='Bupivacaine HCL 0.5% vial of 20 ml[010115]'
	  e0.size = '43'
	  cellRight0.appendChild(e0);
	
	
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoP'+(iteration+1);
	  sel.id='pvmsNoP'+(iteration+1)
	    sel.value='010115'
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	  
	  											
				  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'd' + (iteration+1);
	  e3.id = 'd' + (iteration+1);
	  e3.size = '10'
	  cellRight3.appendChild(e3);
	  
	  
	  
	  	 var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('Select');
	 
	  e4.name='level'+(iteration+1);
	  e4.id='level'+(iteration+1);
	  e4.classname='smalllabel'
	   e4.options[0] = new Option('Select', '');
	     
	    e4.options[1] = new Option('T1-2', 'T1-2');
	   e4.options[2] = new Option('T2-3', 'T2-3');
	     e4.options[3] = new Option('T3-4', 'T3-4');
	   e4.options[4] = new Option('T4-5', 'T4-5');
	   e4.options[5] = new Option('T6-7', 'T6-7');
	     e4.options[6] = new Option('T8-L1', 'T8-L1');
	   e4.options[7] = new Option('L1-2', 'L1-2');
	   e4.options[8] = new Option('L2-3', 'L2-3');
	   e4.options[9] = new Option('L3-4', 'L3-4');
	   cellRight4.appendChild(e4); 
	  

	 	 
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'c' + (iteration+1);
	  e5.id = 'c' + (iteration+1);
	
	  e5.size = '10'
	  cellRight5.appendChild(e5);	   
						   
						   
						   }
						   else if(val=="Caudal")
						   {
		var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	  e0.name = 'nomenclatureP' + (iteration+1);
	  e0.id = 'nomenclatureP' + (iteration+1);
	  e0.value='Bupivacaine HCL 0.5% vial of 20 ml[010115]'
	  e0.size = '43'
	  cellRight0.appendChild(e0);
	
	
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoP'+(iteration+1);
	  sel.id='pvmsNoP'+(iteration+1)
	  sel.value='010115'
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	  
	  
	  				  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'd' + (iteration+1);
	  e3.id = 'd' + (iteration+1);
	  e3.size = '10'
	  cellRight3.appendChild(e3);
	  
	  
	 
	  	var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	 
	  e4.name='level'+(iteration+1);
	  e4.id='level'+(iteration+1);
	   e4.value='-';
	e4.size = '2'
 	cellRight4.appendChild(e4); 
 
  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'c' + (iteration+1);
	  e5.id = 'c' + (iteration+1);
	
	  e5.size = '10'
	  cellRight5.appendChild(e5);	
 
 
 
 
						   }
						   else
						   {
						   
	  
	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
	  						
	                      // alert('event added--'+e0.value+"iteration--"+iteration);
	                       var val=e0.value
	                       if(val != "")
							{
					    	
						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);
						    	//alert("nomenclature---"+nomenclature)
						   	 if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclatureP'+(iteration+1)).value="";
	   								document.getElementById('pvmsNoP'+(iteration+1)).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNoP'+(iteration+1)).value=pvmsNo
						   }
	  					  };
	  e0.name = 'nomenclatureP' + (iteration+1);
	  e0.id = 'nomenclatureP' + (iteration+1);
	 
	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclatureP'+(iteration+1),'ac2update2','ot?method=getItemPList',{parameters:'requiredField=nomenclatureP'+(iteration+1)});
	   //alert("name--"+e0.name)
	  
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoP'+(iteration+1);
	  sel.id='pvmsNoP'+(iteration+1)
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
						   
						
						
				  var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'd' + (iteration+1);
	  e3.id = 'd' + (iteration+1);
	  e3.size = '10'
	  cellRight3.appendChild(e3);
	 
	 	 
	 
	  	var cellRight4 = row.insertCell(4);
	  var e4 = document.createElement('input');
	 
	  e4.name='level'+(iteration+1);
	  e4.id='level'+(iteration+1);
	   e4.value='-';
	e4.size = '2'
	
	 cellRight4.appendChild(e4); 
	 	 
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'c' + (iteration+1);
	  e5.id = 'c' + (iteration+1);
	
	  e5.size = '10'
	  cellRight5.appendChild(e5);
	 		
						   
						   
	}
						   
						   
						   
						   
						   
 };
	  	   
	        	   
	
	 
	}
	else
	{
	var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	 
	  e1.name='anesthesia'+(iteration+1);
	  e1.id='anesthesia'+(iteration+1);
	   e1.value='-';
	e1.size = '2'
	  	        	   
	   cellRight1.appendChild(e1); 
	   
	   
	   			   
	  
	  var cellRight0 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
	  						
	                      // alert('event added--'+e0.value+"iteration--"+iteration);
	                       var val=e0.value
	                       if(val != "")
							{
					    	
						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);
						    	//alert("nomenclature---"+nomenclature)
						   	 if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclatureP'+(iteration+1)).value="";
	   								document.getElementById('pvmsNoP'+(iteration+1)).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNoP'+(iteration+1)).value=pvmsNo
						   }
	  					  };
	  e0.name = 'nomenclatureP' + (iteration+1);
	  e0.id = 'nomenclatureP' + (iteration+1);
	 
	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclatureP'+(iteration+1),'ac2update2','ot?method=getItemPList',{parameters:'requiredField=nomenclatureP'+(iteration+1)});
	   //alert("name--"+e0.name)
	  
	  var cellRightSel = row.insertCell(2);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNoP'+(iteration+1);
	  sel.id='pvmsNoP'+(iteration+1)
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	   
	   
	   
	   
	     var cellRight3 = row.insertCell(3);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'd' + (iteration+1);
	  e3.id = 'd' + (iteration+1);
	  e3.size = '10'
	  cellRight3.appendChild(e3);
	 
	 	 
	 
	  	var cellRight4 = row.insertCell(4);
	  var e1 = document.createElement('input');
	 
	  e4.name='level'+(iteration+1);
	  e4.id='level'+(iteration+1);
	   e4.value='-';
	e4.size = '2'
 cellRight4.appendChild(e4); 
 
	  var cellRight5 = row.insertCell(5);
	  var e5 = document.createElement('input');
	  e5.type = 'text';
	  e5.name = 'c' + (iteration+1);
	  e5.id = 'c' + (iteration+1);
	
	  e5.size = '10'
	  cellRight5.appendChild(e5);
	 
	   
	}
	
		
	  
	 
	
	}
	function removeRowForProcedure()
	{
	  var tbl = document.getElementById('procedureGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 1) 
	  {
	  tbl.deleteRow(lastRow - 1);
	  var hdb = document.getElementById('hiddenValueProcedure');
	  hdb.value=lastRow - 1;
	  }
	  
	  
	}	
	

//-------------------------------IV  Fluids --------------------------------
		function populatePVMS(val){
		//alert("in method--")
		if(val != "")
		{
		    var index1 = val.lastIndexOf("[");
		    var indexForBrandName=index1;
		    var index2 = val.lastIndexOf("]");
		    index1++;
		    var pvmsNo = val.substring(index1,index2);
		    var indexForBrandName=indexForBrandName--;
		    var brandName=val.substring(0,indexForBrandName);
		   //  alert("pvms no--"+pvmsNo)	
		   
	   
	 
	  if(pvmsNo == "")
	  {
	   // alert("pvms no1111--"+pvmsNo)	
	   	document.getElementById('nomenclature1').value="";
	    document.getElementById('pvmsNo1').value="";
	   return;
	   }
	   else
	      document.getElementById('pvmsNo1').value=pvmsNo
	 }
	}	
	
function addRowForFluids(){
		
	  var tbl = document.getElementById('fluidsGrid');
	  var lastRow = tbl.rows.length;
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValueFluids');
	  hdb.value=iteration+1	//   alert("iteration row--"+iteration)
	 

	 
	 
	 var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){
	  						
	                      // alert('event added--'+e0.value+"iteration--"+iteration);
	                       var val=e0.value
	                       if(val != "")
							{
					    	
						    var index1 = val.lastIndexOf("[");
						    var indexForPvms=index1;
						    var index2 = val.lastIndexOf("]");
						    index1++;
						    var pvmsNo = val.substring(index1,index2);
						    var indexForPvms=indexForPvms--;
						    var nomenclature=val.substring(0,indexForPvms);
						    	//alert("nomenclature---"+nomenclature)
						   	 if(pvmsNo =="")
						    {
						    		document.getElementById('nomenclature'+(iteration+1)).value="";
	   								document.getElementById('pvmsNo'+iteration+1).value="";
						     return;
						    }
						    else
	      						document.getElementById('pvmsNo'+(iteration+1)).value=pvmsNo
						   }
	  					  };
	  					
	  e0.name = 'nomenclature' +(iteration+1);
	  e0.id = 'nomenclature' +(iteration+1);
	 
	  e0.size = '43';
	  cellRight0.appendChild(e0);
	  new Ajax.Autocompleter('nomenclature'+(iteration+1),'ac2update1','ot?method=getItemList',{parameters:'requiredField=nomenclature'+(iteration+1)});
	   //alert("name--"+e0.name)
	  
	  var cellRightSel = row.insertCell(1);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='pvmsNo'+(iteration+1);
	  sel.id='pvmsNo'+(iteration+1);
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	 
	 
	 	 
	 
	   var cellRight3 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.name = 'fluidName' + (iteration+1);
	  e3.id = 'fluidName' + (iteration+1);
	
	  e3.size = '10'
	  cellRight3.appendChild(e3);
	 
	 
	  var cellRight4 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.name = 'v' + (iteration+1);
	  e4.id = 'v' + (iteration+1);
	
	  e4.size = '2'
	  cellRight4.appendChild(e4);
	 
	 
	}
	function removeRowForFluids()
	{
	  var tbl = document.getElementById('fluidsGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 1) 
	  {
	  tbl.deleteRow(lastRow - 1);
	  var hdb = document.getElementById('hiddenValueFluids');
	  hdb.value=lastRow- 1;
	  }
	}	
	
	
		
function validateSurgeryAutoComplete( strValue,inc ) {
 			 
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    //alert("id----"+id)
		    
		    if(id =="")
		    {
		    		document.getElementById('chargeCodeName'+inc).value="";
	   				document.getElementById('chargeCode'+inc).value="";
 					return ;
 			}

 			
 			return true;
		}	
		
		
function addRowForInvestigation(){
		
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration+1
	  // alert("iteration row--"+iteration)
	 

	 
	 
	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e1.onblur=function(){
	  						
	  						if(validateSurgeryAutoComplete(this.value,(iteration+1))){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillChargeCode&rowVal='+(iteration+1),'chargeCodeVal'+(iteration+1));}
	  						
	  					  };
	  e1.name = 'chargeCodeName' + (iteration+1);
	  e1.id = 'chargeCodeName' + (iteration+1);
	  //alert("name--"+e0.name)
	  e1.size = '43'
	  cellRight1.appendChild(e1);
	new Ajax.Autocompleter('chargeCodeName'+(iteration+1),'ac2update6','ot?method=getSurgeyForAutoComplete',{parameters:'requiredField=chargeCodeName'+(iteration+1)});
	 
	
	  
	  
	  var cellRightSel = row.insertCell(1);
	  cellRightSel.id='chargeCodeVal'+(iteration+1);
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='chargeCode'+(iteration+1);
	  sel.id='chargeCode'+(iteration+1)
	  sel.size = '10'
	  cellRightSel.appendChild(sel);
	 
	 
	
	 
	 
	}
	function removeRowForInvestigation()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	 if (lastRow > 1) 
	  {
	  tbl.deleteRow(lastRow - 1);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=lastRow- 1;
	  }
	}	
	
//----------------------------- Surgeon -----------------------------
	
	function validateSergonAutoComplete( strValue1,inc1 ) {
 			 
 			var index1 = strValue1.lastIndexOf("[");
		    var index2 = strValue1.lastIndexOf("]");
		    index1++;
		    var id = strValue1.substring(index1,index2);
		    //alert("id----"+id)
		    
		    if(id =="")
		    {
		    		document.getElementById('empNameS'+inc1).value="";
		    		
	   				return ;
 			}

 			
 			return true;
		}	
		
		
function addRowForSurgeon(){
		
	  var tbl = document.getElementById('sergonGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdbS = document.getElementById('hiddenValueSergon');
	  hdbS.value=iteration+1
	  // alert("iteration row--"+iteration)
	 

	 
	 
	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e1.onblur=function(){
	  						
	  						if(validateSergonAutoComplete(this.value,(iteration+1))){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillEmpNameSergon&rowVal='+(iteration+1),''+(iteration+1));}
	  						
	  					  };
	  e1.name = 'empNameS' + (iteration+1);
	  e1.id = 'empNameS' + (iteration+1);
	  //alert("name--"+e0.name)
	  e1.size = '43'
	  cellRight1.appendChild(e1);
	new Ajax.Autocompleter('empNameS'+(iteration+1),'ac2update5','ot?method=getSergonForAutoComplete',{parameters:'requiredField=empNameS'+(iteration+1)});
	 
	
	
	
	 
	 
	}
	function removeRowForSurgeon()
	{
	  var tbl = document.getElementById('sergonGrid');
	  var lastRow = tbl.rows.length;
		  if (lastRow > 1) 
	  {
	  tbl.deleteRow(lastRow - 1);
	  var hdb = document.getElementById('hiddenValueSergon');
	  hdb.value=lastRow- 1;
	  }
	}	
	
//-------------------- 		Anesthesiologist----------------------


	function validateAnesthesiologistAutoComplete( strValue2,inc2 ) {
 			 
 			var index1 = strValue2.lastIndexOf("[");
		    var index2 = strValue2.lastIndexOf("]");
		    index1++;
		    var id = strValue2.substring(index1,index2);
		    //alert("id----"+id)
		    
		    if(id =="")
		    {
		    		document.getElementById('empName'+inc2).value="";
		    		
	   				return ;
 			}

 			
 			return true;
		}	
		
		
function addRowForAnesthesiologist(){
		
	  var tbl = document.getElementById('anesthesiologistGrid');
	  var lastRow = tbl.rows.length;
	 
	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdbS = document.getElementById('hiddenValueAnesthesiologist');
	  hdbS.value=iteration+1
	  // alert("iteration row--"+iteration)
	 

	 
	 
	  var cellRight1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e1.onblur=function(){
	  						
	  						if(validateAnesthesiologistAutoComplete(this.value,(iteration+1))){submitProtoAjaxWithDivName('postAnesthesiaProcedure','/hms/hms/ot?method=fillEmpNameAnesthesiologist&rowVal='+(iteration+1),''+(iteration+1));}
	  						
	  					  };
	  e1.name = 'empName' + (iteration+1);
	  e1.id = 'empName' + (iteration+1);
	  //alert("name--"+e0.name)
	  e1.size = '43'
	  cellRight1.appendChild(e1);
	new Ajax.Autocompleter('empName'+(iteration+1),'ac2update4','ot?method=getAnesthesiologistForAutoComplete',{parameters:'requiredField=empName'+(iteration+1)});
	 
	
	
	
	 
	 
	}
	function removeRowForAnesthesiologist()
	{
	  var tbl = document.getElementById('anesthesiologistGrid');
	  var lastRow = tbl.rows.length;
		  if (lastRow > 1) 
	  {
	  tbl.deleteRow(lastRow - 1);
	  var hdb = document.getElementById('hiddenValueAnesthesiologist');
	  hdb.value=lastRow- 1;
	  }
	}
	
	function anesthesiaCheck()
	{
	var val = document.getElementById('anesthesia_id').value;
	if(val != 0){
			document.getElementById('s1').style.display = 'none';
			document.getElementById('s2').style.display = 'block';
			}else{
			document.getElementById('s1').style.display = 'block';
			document.getElementById('s2').style.display = 'none';
			}
	}
		function anesthesiaCobom()
	{
	var val = document.getElementById('anesthesia1').value;
	if(val == "SA"){
			document.getElementById('s3').style.display = 'none';
			document.getElementById('s4').style.display = 'block';
			document.getElementById('s5').style.display = 'none';

			}
	else if(val == "EA"){
			document.getElementById('s3').style.display = 'none';
			document.getElementById('s4').style.display = 'none';
			document.getElementById('s5').style.display = 'block';

			}
		
			else {
			document.getElementById('s3').style.display = 'block';
			document.getElementById('s4').style.display = 'none';
			document.getElementById('s5').style.display = 'none';
		
			}
	}
	

	
</script>