<%@page import="jkt.hms.masters.business.MasPatientType"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasMenuType"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>

<script>
 <%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(dateCal.length()<2){
	dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<%

Box box=HMSUtil.getBox(request);
	int pageNo=1;
	Map<String,Object> map = new HashMap<String,Object>();
	
	List<MasDiet> masDietList = new ArrayList<MasDiet>();
	List<MasMenuType> masMenuTypeList = new ArrayList<MasMenuType>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<Inpatient> inpatientList=new ArrayList<Inpatient>();
	List<MasPatientType> patientTypeForSocialCategory=new ArrayList<MasPatientType>();
	List<MasPatientType> patientTypeForOtherCategory=new ArrayList<MasPatientType>();
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	String userName="";
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
	
		
		if (session.getAttribute("userName") != null) {
			  userName = (String) session.getAttribute("userName");
			}
		
		List<Patient> patientList = new ArrayList<Patient>();
		
		if(map.get("masDietList") != null){
			masDietList= (List<MasDiet>)map.get("masDietList");
		}
		if(map.get("masMenuTypeList") != null){
			masMenuTypeList= (List<MasMenuType>)map.get("masMenuTypeList");
		}
		if(map.get("departmentList") != null){
			departmentList= (List<MasDepartment>)map.get("departmentList");
		}
		if(map.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)map.get("inpatientList");
		}
		if(map.get("patientTypeForSocialCategory") != null){
			patientTypeForSocialCategory= (List<MasPatientType>)map.get("patientTypeForSocialCategory");
		}
		if(map.get("patientTypeForOtherCategory") != null){
			patientTypeForOtherCategory= (List<MasPatientType>)map.get("patientTypeForOtherCategory");
		}
		if(map.get("box")!=null)
		{
			box=(Box)map.get("box");
		}
	
		
%> 
<%-- <form name="bloodEntry" method="post" action="">
<div class="titleBg">
<h2>Blood Request Entry</h2>
</div>
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block" id="testDiv"><input type="hidden" name="pageNo"
	id="pageNo" value="<%=pageNo%>" /> <%
		String orderSeqNo="";
		if(map.get("orderSeqNo") != null){
			orderSeqNo = (String)map.get("orderSeqNo");
		}
%> <label>Order Number</label> <input id="orderNoId" type=hidden
	name="<%=ORDER_NO %>" value="<%=orderSeqNo %>" title="Order Number" />

<label class="value"><%=orderSeqNo %></label> <input type="hidden"
	id="BloodhdId" name="BloodhdId" value="<%= BloodhdId%>" /> <label>Order
Date</label> <label class="value"><%=currentDate %></label>

<div class=clear></div>
<% for (Patient patient:patientList) {%> <label>HIN</label> <label
	class="value"><%=patient.getHinNo()%></label> <label>Patient
Name</label> <label class="value"><%=patient.getPFirstName()+" "+patient.getPMiddleName()+" "+patient.getPLastName() %></label>

<label class="medium">Age </label> <%if(patient.getAge() !=null){ %> <label
	class="value"><%=patient.getAge()%></label> <%}else{ %> <label
	class="value"> - </label> <%} %>

<div class=clear></div>

<label>Blood Group</label> <%if(patient.getBloodGroup() !=null){ %> <label
	class="value"><%=patient.getBloodGroup().getBloodGroupName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %> <%
			int inpatientId =0;
			Set<Inpatient> set = new HashSet<Inpatient>();
			set = patient.getInpatients();
			for(Inpatient inpatient : set){
				if(inpatient.getAdStatus().equals("A")){
					inpatientId = inpatient.getId();
								
%> <label>IP No.</label> <%if(inpatient.getAdNo() != null){ %> <label
	class="value"><%=inpatient.getAdNo()%></label> <%}%> <input type="hidden"
	name="<%=INPATIENT_ID %>" value="<%=inpatient.getId()%>" /> <label>Ward</label>
<%if(inpatient.getDepartment() != null){ %> <label class="valueNoWidth"><%=inpatient.getDepartment().getDepartmentName()%></label>
<%}%>
<div class=clear></div>

<label class="auto">Diagnosis &amp; Brief</label> <%if(inpatient.getDiagnosis() != null){ %>
<label class="value"><%=inpatient.getDiagnosis().getIcdName()%></label>
<%} %> <input type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=inpatient.getDepartment().getId() %>" /> <%}}%> <input
	type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" /> <%} %>


<label>Request Type</label> <select name="<%=REQUEST_TYPE%>" tabindex=1>
	<option value="n">Not Urgent</option>
	<option value="u">Urgent</option>
	<option value="most">Most Urgent</option>
</select> <label class="auto">Date &amp; no. of bottles given</label> <input
	type="text" class="date" id="fromDateId" name="<%=DATE %>" value=""
	readonly="readonly" MAXLENGTH="30" tabindex=1 /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('<%=currentDate %>',document.bloodEntry.<%=DATE%>,event)"
	tabindex=1 /> <input id="bottles" type="text" name="<%= BOTTLES_NO%>"
	value="" validate=" No. of Bottles ,int,no" class="small" MAXLENGTH="3"
	tabindex=1 />
<label> Hb % </label> 
<input id="hbId" type="text" name="<%= HB%>" value="" validate="Hb,string,no" MAXLENGTH="10" tabindex=1 />
<label	class="small">Gm%</label>

<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block" id="testDiv">
<h4>Presence</h4>
<div class="clear"></div>
<label class="smallAuto">1.</label> <input id="presence1Id" type="text"
	name="<%= PRESENCE1%>" value="" validate="1,string,no" size="60"
	class="large" MAXLENGTH="50" tabindex=1 /> <label class="smallAuto">2.</label>
<label class="auto"> Fever</label> <input id="feverId" type="text"
	name="<%= FEVER%>" value="" validate="Fever,string,no" MAXLENGTH="30"
	tabindex=1 /> <label class="noWidth">of Time</label> <input
	id="ofTimeId" type="text" name="<%= OF_TIME%>" value="" class="small"
	validate="Of Time,string,no" onKeyUp="mask(this.value,this,'2',':');"
	onBlur="IsValidTime(this.value,this.id);" MAXLENGTH="5" tabindex=1 />

<div class="clear"></div>

<label class="smallAuto">3.</label> <input id="presence2Id" type="text"
	class="large" name="<%= IF_ANY%>" value="" validate="if any,string,no"
	class="Auto" size="60" MAXLENGTH="50" tabindex=1 class="large" /><label
	class="small">(if any)</label>
<div class="clear"></div>
<label class="smallAuto">4.</label> <label class="auto">History
of Pregnancies(if any)</label> <input id="pregnanciesId" type="text"
	name="<%= PREGNANCIES%>" value=""
	validate="History of Pregnancies,string,no" MAXLENGTH="50" tabindex=1
	class="large" size="60" />
<div class="clear"></div>
<label class="smallAuto">5. </label> <label class="auto">With
specific reference and diagnostic disease of new born</label> <input
	id="diagnosticId" type="text" name="<%= SPECIFIC_REFERENCE%>" value=""
	validate="With specific reference and diagnostic disease of new born of Pregnancies,string,no"
	size="60" class="large" MAXLENGTH="50" tabindex=1 /> <input
	type="hidden" size="2" value="" name="noOfRecords" id="noOfRecords" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="3%">SR No</th>
			<th width="10%">Component Name</th>
			<th width="7%">Qty(ml)</th>
			<th width="10%">Required on Date</th>
		</tr>
	</thead>
	<tbody>
		<%
    	int detailCounter=8; 
    	int temp=0;
    	int inc = 0;    	
    	if(pageNo!=1){
    		temp=detailCounter*(pageNo-1);
    	} 
    	for(inc=1;inc<=8;inc++){
    	    	  
    %>

		<tr>

			<td width="5%"><input type="text" size="2" value="<%=temp+inc%>"
				name="<%=SR_NO%>" readonly="readonly" tabindex=1 /> <input
				type="hidden" value="" name="<%=BLOOD_COMPONENT_ID%><%=inc %>"
				id="bloodComponentId<%=inc %>" tabindex=1 /></td>
			<td><input type="text" size="40" id="componentName<%=inc%>"
				name="<%=BLOOD_COMPONENT_NAME%><%=inc %>"
				onblur="if(fillSrNo('<%=inc %>')){checkForComponentCode(this.value, '<%=inc %>');}"
				tabindex=1 />
			<div id="ac2update6" style="display: none;" class="autocomplete"></div>
			<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('componentName<%=inc %>','ac2update6','bloodBank?method=getComponentNameForAutoComplete',{parameters:'requiredField=<%=BLOOD_COMPONENT_NAME%><%=inc %>'});
		</script></td>

			<td><input type="text" id="quantity<%=inc%>"
				name="<%=QUANTITY %><%=inc %>" value="" validate="Qty,int,no"
				MAXLENGTH="3" tabindex=1 /></td>
			<td><input type="text" class="date" id="reqDateId<%=inc%>"
				name="<%=REQUIRED_DATE %><%=inc %>" value="" readonly="readonly"
				MAXLENGTH="30" onblur="validateRequiredDate(<%=inc %>);" tabindex=1 />
			<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date"
				onClick="setdate('<%=currentDate%>',document.getElementById('reqDateId<%=inc%>'),event);"
				onblur="validateRequiredDate(<%=inc %>);" tabindex=1 /></td>
		</tr>
		<%} %>
	</tbody>
</table>
<input type="hidden" name="rowCount" value="<%=inc %>"> <!--Bottom labels starts-->
<div class="clear"></div>
<div class="division"></div>
<!--Bottom labels starts--> <input type="button" class="button"
	value="Add"
	onclick="if(checkFilledRow()){submitForm('bloodEntry','bloodBank?method=submitBloodRequestEntry');}"
	align="right" tabindex=1 /> <input type="reset"
	class="buttonHighlight" name="Reset" id="reset" value="Reset"
	onclick="resetClicked('bloodEntry',<%=inc %>);" accesskey="r"
	tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=currentDate%></label>

<label>Changed Time</label> <label class="value"><%=time%></label> <input
	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
<input type="hidden" name="counter" value=<%=inc %>></div>
<!--Bottom labels ends-->
<div class="clear"></div>
<div class="paddingTop40"></div></form>

<script type="text/javascript">
function fillSrNo(rowVal){

	if(document.getElementById('componentName'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('componentName'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}

function clearAllFields(inc){
	var componentCode = document.getElementById('componentCode'+inc).value
	var quantity = document.getElementById('quantity'+inc).value;
	var reqDate = document.getElementById('reqDateId'+inc).value;
	
}

function checkForComponentCode(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForComponentName= index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var componentId = val.substring(index1,index2);
			var indexForComponentName = indexForComponentName--;
			var componentName = val.substring(0,indexForComponentName);
		
		if(componentId =="")
		{
	  	 document.getElementById('quantity'+inc).value="";
	     return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('componentName'+i).value==val)
		{
			alert("Component Name already selected...!")
			document.getElementById('componentName'+inc).value=""
			var e=eval(document.getElementById('componentName'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteComponentName('bloodEntry','bloodBank?method=fillItemsForComponentname&componentName=' +  componentName , inc);
		
		}else{
			document.getElementById('quantity'+inc).value = "";
		}
}



function checkFilledRow(){
	var msg ="";
	if(document.getElementById('noOfRecords').value==0 || document.getElementById('noOfRecords').value ==""){
	  	alert("Please fill atleast one Component to submit.");
	  	return false;
	  }else{
	  var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	
	  	 	if(document.getElementById('componentName'+i).value != ""){
	  			if(document.getElementById('quantity'+i).value == ""){
	  				msg += "Quantity can not be blank.\n";
	  			}
	  			if(document.getElementById('reqDateId'+i).value == ""){
	  				msg += "Required Date can not be blank.\n";
	  			}
	  			if(msg != ""){
	  				break;
	  			}
	  		}
	  	}
	  		if(msg != ""){
	  			alert(msg)
	  			return false;
	  		}else
	  			return true;
	  }
	 }
	 
	function validateRequiredDate(inc){
		var currentDate = new Date();
		
		obj1 = eval(document.getElementById("reqDateId"+inc))
		
		 var validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		if(obj1.value != ""){
			if(validFromDate < currentDate)
				{
				alert("Required Date should not be Past date\n");
				document.getElementById("reqDateId"+inc).value=""
				return false;
				}
		}
	
		return true;
	}
</script> --%>
<div class="Block">
<form name="dietscheduling" method="post" action="">
 <div class="titleBg">
<h2>DietScheduling/Requisition</h2>
</div> 

<div class="clear"></div>

<label>Date<span>*</span></span></label>

<%if(!box.getString(REQUEST_DATE).equals("")){ %>

<input type="text"  class="date" name="<%=REQUEST_DATE%>" id="<%=REQUEST_DATE%>" readonly="readonly"  value="<%=box.getString(REQUEST_DATE)%>"/>
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=dateCal+"/"+month+"/"+year%>',document.dietscheduling.<%=REQUEST_DATE%>,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
 
<%}else{ %>
<input type="text"  class="date" name="<%=REQUEST_DATE%>" id="<%=REQUEST_DATE%>" readonly="readonly" value="<%=dateCal+"/"+month+"/"+year%>"/>
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=dateCal+"/"+month+"/"+year%>',document.dietscheduling.<%=REQUEST_DATE%>,event)" validate="Pick a date" src="/hms/jsp/images/cal.gif">
 
<%} %>
<label>Requisition To<span>*</span></label>

<select name="requisitionTo" id="requisitionTo">
<option value="">select</option>
<%
for(MasDepartment department : departmentList)
{
%>
<%if(box.getInt("requisitionTo")!=0 && box.getInt("requisitionTo")==department.getId())
	{%>
	<option value="<%=	department.getId()%>" selected="selected"><%=department.getDepartmentName()%></option>
	
	<%}else
		{%>
		<option value="<%=	department.getId()%>"><%=department.getDepartmentName()%></option>
		<% }%>

<%} %>
</select> 


<label>Requisition for Date<span>*</span></label>
<%if(!box.getString("dietForDate").equals("")) {%>
<script type="text/javascript">
var requisitiondate='<%=box.getString("dietForDate")%>';
</script>
<input type="text"  class="date" name="dietForDate" id="dietForDate" readonly="readonly" value="<%=box.getString("dietForDate")%>" onblur="onRequisitiondateChange(this.value);" />
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=dateCal+"/"+month+"/"+year%>',document.dietscheduling.dietForDate,event);" validate="Pick a date" src="/hms/jsp/images/cal.gif">
 
<%}else{ %>
<script type="text/javascript">
var requisitiondate='<%=dateCal+"/"+month+"/"+year%>';
</script>
<input type="text"  class="date" name="dietForDate" id="dietForDate" readonly="readonly" value="<%=dateCal+"/"+month+"/"+year%>"    onblur="onRequisitiondateChange(this.value);" />
<img width="16" height="16" border="0" onclick="javascript:setdate('<%=dateCal+"/"+month+"/"+year%>',document.dietscheduling.dietForDate,event);" validate="Pick a date" src="/hms/jsp/images/cal.gif">
 
<%} %>
 <div class="clear"></div>
 
 <label>Diet Time<span>*</span></label>
<select name="<%=DIET_MENU_ITEM_ID %>" id="<%=DIET_MENU_ITEM_ID %>" onchange="onChangeSearchCriteria();">
<option value="">select</option>
<%
for(MasMenuType menuType : masMenuTypeList)
{
%>
<%if(box.getInt(DIET_MENU_ITEM_ID)==menuType.getId()) {%>
<option value="<%=	menuType.getId()%>" selected="selected"><%=menuType.getMenuName()%></option>

<% }else{%>

<option value="<%=	menuType.getId()%>"><%=menuType.getMenuName()%></option>

<% }%>

<%} %>
</select>

<label>Diet Type<span>*</span></label>

<select name="<%=DIET_TYPE_ID %>" id="<%=DIET_TYPE_ID %>">
<option value="">select</option>
<%
for(MasDiet diet : masDietList)
{
%>

<%if(box.getInt(DIET_MENU_ITEM_ID)==diet.getId()) {%>
<option value="<%=	diet.getId()%>" selected="selected"><%=diet.getDietName()%></option>

<% }else{%>

<option value="<%=	diet.getId()%>"><%=diet.getDietName()%></option>

<% }%>

<%} %>
</select> 

<div class="clear"></div>
		
			<label>Family Income Status</label>
			<%if(box.getString("bplStatus").equals("")){ %>
			<label class="auto">BPL</label>
			 <input type="radio" value="bpl" name="bplStatus" id="bplStatus1" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();"  /> 
			 <label class="auto">APL</label>
			 <input type="radio" value="apl" name="bplStatus" id="bplStatus2" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();" /> 
			<%}else  if(box.getString("bplStatus").equals("bpl")){%>
			<label class="auto">BPL</label>
			 <input type="radio" value="bpl" name="bplStatus" id="bplStatus1"style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();" checked="checked" /> 
			 <label class="auto">APL</label>
			 <input type="radio" value="apl" name="bplStatus" id="bplStatus2" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();" /> 
			<%}else  if(box.getString("bplStatus").equals("apl")){%>
			<label class="auto">BPL</label>
			 <input type="radio" value="bpl" name="bplStatus"  id="bplStatus1" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();" /> 
			 <label class="auto">APL</label>
			 <input type="radio" value="apl" name="bplStatus" id="bplStatus2" style="margin:0;padding: 0;" onchange="onChangeSearchCriteria();" checked="checked" /> 
			<%} %>
			<label>Social Category</label>
			 <select onblur="" tabindex="1" name="patientTypeId" id="patientTypeId" style="background-color: yellow;" onchange="onChangeSearchCriteria();" >
				<option value="0">Select</option>
				<%for(MasPatientType patientType:patientTypeForSocialCategory) {%>
				
				<%if(patientType.getId()==box.getInt("patientTypeId")) {%>
				<option value="<%=patientType.getId()%>" selected="selected"><%=patientType.getPatientTypeName()%></option>
				<%}else{ %>
				<option value="<%=patientType.getId()%>"><%=patientType.getPatientTypeName()%></option>
				<%} %>
				<%} %>
			</select>
			<label>Other Category</label> 
			<select name="otherCategory" size="5" class="multiple" id="otherCategoryId">
				<%for(MasPatientType patientType:patientTypeForOtherCategory) {%>
				
				<%-- <%if(patientType.getId()==box.getInt("otherCategory")) {%>
				<option value="<%=patientType.getId()%>" selected="selected"><%=patientType.getPatientTypeName()%></option>
				<%}else{ %> --%>
				<option value="<%=patientType.getId()%>"><%=patientType.getPatientTypeName()%></option>
				<%-- <%} %> --%>
				<%} %>
			</select>
<!-- <label>patient Category</label>
<label class="value">
<select>
<option>select</option>
</select> </label> -->
<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>
<!-- <input type="button" class="button" style=""
	value="Delete"
	onclick=""
	align="right" tabindex=1 /> -->
	
	<div class="clear"></div>
	<div class="" id="testDiv">
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<table width="100%" colspan="7" id="componentDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>
			<th width="3%">&nbsp;</th>
			<th>IP No.</th>
			<th>Patient Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Category</th>
			<th>Bed No</th>
			<th>Diagnosis</th>
			<th>Adm Date</th>
			<th>Doctor Name</th>
			<!-- <th>Diet Name</th> -->
			<th>Extra Diet</th>
			<!-- <th>Diet Name</th>
			<th>Qty</th>
			<th>Remarks</th> -->
		</tr>
	</thead>
	<tbody>
	
	<%
	int patientCount=0;
	for(Inpatient inpatient:inpatientList) 
	{
		patientCount++;
		String patientName = "-";
		try
		{
			patientName=inpatient.getHin().getPFirstName();
			if(inpatient.getHin().getPMiddleName()!=null){
				patientName += " "+inpatient.getHin().getPMiddleName();
			}
			if(inpatient.getHin().getPLastName()!=null){
				patientName += " "+inpatient.getHin().getPLastName();
		}
		}
		catch (Exception e)
		{
		patientName = "-";
		}
		
		String gender="-";
		try
		{
			gender = inpatient.getHin().getSex().getAdministrativeSexName();
		}
		catch(Exception exception)
		{
			gender="-";
		}
		
		String currentAge = "-";
		try
		{
					String age = inpatient.getHin().getAge();
				try{
					if(age!= null && !age.equals(""))
					currentAge = HMSUtil.calculateAgeForADT(age,inpatient.getHin().getRegDate());
				}catch(Exception ex){
					ex.printStackTrace();
				}
		}
		catch(Exception exception)
		{
			currentAge="-";
		}
		
		String consultingDoctor="-";
		try
		{
			consultingDoctor=inpatient.getDoctor().getFirstName();
			if(inpatient.getDoctor().getMiddleName()!=null)
			{
				consultingDoctor +=" "+inpatient.getDoctor().getMiddleName();
			}
			
			if(inpatient.getDoctor().getLastName()!=null)
			{
				consultingDoctor+=" "+inpatient.getDoctor().getLastName();
			}
		}
		catch(Exception exception)
		{
			consultingDoctor="-";
		}
	%>
	<tr>
	<td>
	<input type="checkbox" name="<%=INPATIENT_ID%><%=patientCount %>" id="<%=INPATIENT_ID%><%=patientCount %>" value="<%=inpatient.getId() %>" onchange="openDietCombination('<%=patientCount %>','<%=inpatient.getId() %>')" />
	</td>
	<td><%=inpatient.getAdNo() %></td>
	<td><%=patientName %></td>
		<td><%=currentAge %></td>
	<td><%=gender %></td>
	<td>&nbsp;</td>
		<td><%=inpatient.getBed().getBedNo() %></td>
		<td>&nbsp;</td>
		<td><%=HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission()) %></td>
	<td><%=consultingDoctor%></td>
	<td><input type="checkbox" name="extradiet<%=patientCount%>" id="extradiet<%=patientCount%>" onchange="openExtraDiet('<%=patientCount %>','<%=inpatient.getId() %>')" />
	<div id="extradiet<%=inpatient.getId() %>">
	
	<input type="hidden" name="extracount<%=inpatient.getId() %>" id="extracount<%=inpatient.getId() %>" value="0" />
	</div>
	<div id="selectedDiet<%=inpatient.getId() %>">
	
	
	<input type="hidden" name="dietCount<%=inpatient.getId() %>" id="dietCount<%=inpatient.getId() %>" value="0" />
	</div>
	</td>
	</tr>
	
	<%} %>
		
		
	</tbody>
</table>
<input type="hidden" name="patientCount" id="patientCount" value="<%=patientCount%>" />
<div style="float: right;display: none;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" onchange="showHideDrugTemplateCombo(this.value);" tabindex="1">
<option value="0">Select</option>
</select>
</div>


<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<h4>Total Diet Required</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<%
int itemrequired=0;
%>
<table  id="itemrequiredTable" >
	<thead>
		<tr>
			<th>Item</th>
			<th>Qty</th>
			<!-- <th>Remarks</th> -->
		</tr>
	</thead>
	<tbody>
	
	</tbody>
</table>
<input type="hidden" name="itemRequired" id="itemRequired" value="<%=itemrequired%>" />

 <div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
</div>

<div class="clear"></div>
<input type="button" class="button"
	value="Submit" onclick="submitDietScheduling();"
	
	align="right" tabindex=1 />
	<input type="button" class="button"
	value="Reset"
	
	align="right" tabindex=1 />
	
	<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="paddingTop15"></div>

<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
<script type="text/javascript">
var newwindow=null;
function openWindow(url){
    newwindow=window.open(url,'name',"left=2,top=100,height=500,width=900,status=1,scrollbars=1,resizable=0");
}

function openExtraDiet(index,inpatientId)
{
	
	if(requisitiondate==null || requisitiondate!=document.getElementById('dietForDate').value)
	{
	return;
	}
	
	if(document.getElementById('extracount'+inpatientId)==null)
		{
		  var e3 = document.createElement('input');
		  e3.type = 'hidden';
		  e3.name='extracount'+inpatientId;
		  e3.id='extracount'+inpatientId;
		  e3.value='0';
		  document.getElementById('extradiet'+inpatientId).appendChild(e3);
		}
	if(document.getElementById('extracount'+inpatientId).value>0)
		{
		var tbl = document.getElementById('itemrequiredTable');
		var itemRequiredCount=document.getElementById('itemRequired').value;
		var patientDietCount=document.getElementById('extracount'+inpatientId).value;
		for(var i=1;i<=patientDietCount;i++)
			{
			var deleteRow=0;
			for(var j=1;j<=itemRequiredCount;j++)
				{
				if(document.getElementById('dietId'+j)!=null)
					{
					deleteRow=deleteRow+1;
					}
				if(document.getElementById('dietId'+j)!=null && document.getElementById('extraDietId'+inpatientId+''+i).value==document.getElementById('dietId'+j).value)
				{
					
					
					var quantity=parseInt(document.getElementById('dietItemCount'+j).value)-parseInt(document.getElementById('extraDietquantity'+inpatientId+''+i).value);
					 document.getElementById('dietItemCountView'+j).innerHTML='';
					var e3 = document.createElement('input');
					  e3.type = 'hidden';
					  e3.name='dietItemCount'+j;
					  e3.id='dietItemCount'+j
					  e3.value=quantity;
					  document.getElementById('dietItemCountView'+j).appendChild(e3);	
					var e3 = document.createElement('label');
					  e3.innerHTML =document.getElementById('dietItemCount'+j).value;
					 document.getElementById('dietItemCountView'+j).appendChild(e3);	
					if(document.getElementById('dietItemCount'+j).value<=0)
						{
						tbl.deleteRow(deleteRow);
						}
					break;
				}
				}
			}
		}
	
	document.getElementById('extradiet'+inpatientId).innerHTML='';
	/* var e3 = document.createElement('input');
	  e3.type = 'hidden';
	  e3.name='extracount'+inpatientId;
	  e3.id='extracount'+inpatientId;
	  e3.value='0';
	  document.getElementById('extradiet'+inpatientId).appendChild(e3); */
	
	if(document.getElementById('extradiet'+index).checked)
		{
		openWindow('/hms/hms/ipd?method=showExtraDietJsp&parent='+inpatientId);
		}
	else
		{
		var e3 = document.createElement('input');
		  e3.type = 'hidden';
		  e3.name='extracount'+inpatientId;
		  e3.id='extracount'+inpatientId;
		  e3.value='0';
		  document.getElementById('extradiet'+inpatientId).appendChild(e3);
		 // newwindow.close();
		}
	
	
}

function openDietCombination(index,inpatientId)
{
	
	if(requisitiondate==null || requisitiondate!=document.getElementById('dietForDate').value)
	{
	return;
	}
	if(document.getElementById('dietCount'+inpatientId)==null)
		{
		  var e3 = document.createElement('input');
		  e3.type = 'hidden';
		  e3.name='dietCount'+inpatientId;
		  e3.id='dietCount'+inpatientId;
		  e3.value='0';
		  document.getElementById('selectedDiet'+inpatientId).appendChild(e3);
		}
	if(document.getElementById('dietCount'+inpatientId).value>0)
		{
		var tbl = document.getElementById('itemrequiredTable');
		var itemRequiredCount=document.getElementById('itemRequired').value;
		var patientDietCount=document.getElementById('dietCount'+inpatientId).value;
		for(var i=1;i<=patientDietCount;i++)
			{
			var deleteRow=0;
			for(var j=1;j<=itemRequiredCount;j++)
				{
				if(document.getElementById('dietId'+j)!=null)
					{
					deleteRow=deleteRow+1;
					}
				if(document.getElementById('dietId'+j)!=null && document.getElementById('dietcombinationDietId'+inpatientId+''+i).value==document.getElementById('dietId'+j).value)
				{
					
					var quantity=parseInt(document.getElementById('dietItemCount'+j).value)-parseInt(document.getElementById('dietcombinationquantity'+inpatientId+''+i).value);
					document.getElementById('dietItemCountView'+j).innerHTML='';
					var e3 = document.createElement('input');
					  e3.type = 'hidden';
					  e3.name='dietItemCount'+j;
					  e3.id='dietItemCount'+j
					  e3.value=quantity;
					  document.getElementById('dietItemCountView'+j).appendChild(e3);	
					var e3 = document.createElement('label');
					  e3.innerHTML =document.getElementById('dietItemCount'+j).value;
					  document.getElementById('dietItemCountView'+j).appendChild(e3);
					if(document.getElementById('dietItemCount'+j).value<=0)
						{
						tbl.deleteRow(deleteRow);
						}
					break;
				}
				}
			}
		}
	
	document.getElementById('selectedDiet'+inpatientId).innerHTML='';
	/* var e3 = document.createElement('input');
	  e3.type = 'hidden';
	  e3.name='extracount'+inpatientId;
	  e3.id='extracount'+inpatientId;
	  e3.value='0';
	  document.getElementById('extradiet'+inpatientId).appendChild(e3); */
	
	if(document.getElementById('inpatientId'+index).checked)
		{
		
		<%-- alert(document.getElementById('<%=DIET_MENU_ITEM_ID %>').value=='');
		alert(document.getElementById('<%=DIET_TYPE_ID %>').value==''); --%>
		if(document.getElementById('<%=DIET_MENU_ITEM_ID %>')==null || document.getElementById('<%=DIET_MENU_ITEM_ID %>').value=='')
			{
			alert('Please select Diet Time');
			document.getElementById('inpatientId'+index).checked=false;
			return;
			}
		
		if(document.getElementById('<%=DIET_TYPE_ID %>')==null || document.getElementById('<%=DIET_TYPE_ID %>').value=='')
		{
		alert('Please select Diet Type');
		document.getElementById('inpatientId'+index).checked=false;
		return;
		}
		
		if(document.getElementById('dietForDate')==null || document.getElementById('dietForDate').value=='')
		{
		alert('Please select Diet Date');
		document.getElementById('inpatientId'+index).checked=false;
		return;
		}
		openWindow('/hms/hms/ipd?method=showDietCombinationjsp&parent='+inpatientId+'&<%=DIET_TYPE_ID%>='+document.getElementById('<%=DIET_TYPE_ID %>').value+'&<%=DIET_MENU_ITEM_ID%>='+document.getElementById('<%=DIET_MENU_ITEM_ID %>').value+'&dietForDate='+document.getElementById('dietForDate').value);
		}
	
	
	
}

function onRequisitiondateChange(value)
{
	if(requisitiondate!=null && requisitiondate!=value)
		{
		onChangeSearchCriteria();
		}
}

function onChangeSearchCriteria()
{
	removeValidationOnDiet();
	var tbl = document.getElementById('itemrequiredTable');
	  var lastRow = tbl.rows.length;
	  if(lastRow>1)
		  {
		  if(confirm("All selected will be erased."))
			  submitForm('dietscheduling',"/hms/hms/ipd?method=showDietSetupJsp");
		  }
	  else
		  {		  
		  submitForm('dietscheduling',"/hms/hms/ipd?method=showDietSetupJsp");
		  }
	  
	}
	
	function submitDietScheduling()
	{		
		var patientCount=document.getElementById('patientCount').value;
		var selectedCount=0;
		for(var i=1;i<=patientCount;i++)
			{
			if(document.getElementById('<%=INPATIENT_ID%>'+i).checked)
				{
				selectedCount=selectedCount+1;
				}
			}
		if(selectedCount==0)
			{
			alert('Please select atleast one patient before submitting.');
			return;
			}
		for(var i=1;i<=patientCount;i++)
		{
		if(document.getElementById('<%=INPATIENT_ID%>'+i).checked)
			{
			if(document.getElementById('dietCount'+document.getElementById('<%=INPATIENT_ID%>'+i).value).value==0)
				{
				alert('You have not selected any diet for few patients.');
				return;
				}
			}
		}
		
		applyValidationOnDiet();
		
		submitForm('dietscheduling',"/hms/hms/ipd?method=submitDietSetupJsp");
	}
	
	function applyValidationOnDiet()
	{
		 document.getElementById("<%=REQUEST_DATE%>").setAttribute("validate", "Request Date,date,yes");
		 document.getElementById("requisitionTo").setAttribute("validate", "Requisition To,int,yes");
		 document.getElementById("dietForDate").setAttribute("validate", "Requisition for Date,date,yes");
		 document.getElementById("<%=DIET_MENU_ITEM_ID %>").setAttribute("validate", "Diet Time,int,yes");
		 document.getElementById("<%=DIET_TYPE_ID%>").setAttribute("validate", "Diet Type,int,yes");
		 document.getElementById("bplStatus1").setAttribute("validate", "Family Income Status,metachar,no");
		 document.getElementById("bplStatus2").setAttribute("validate", "Family Income Status,metachar,no");
		 document.getElementById("patientTypeId").setAttribute("validate", "Social Category,int,no");

	}
	
	function removeValidationOnDiet()
	{
		 document.getElementById("<%=REQUEST_DATE%>").setAttribute("validate", "");
		 document.getElementById("requisitionTo").setAttribute("validate", "");
		 document.getElementById("dietForDate").setAttribute("validate", "");
		 document.getElementById("<%=DIET_MENU_ITEM_ID %>").setAttribute("validate", "");
		 document.getElementById("<%=DIET_TYPE_ID%>").setAttribute("validate", "");
		 document.getElementById("bplStatus1").setAttribute("validate", "");
		 document.getElementById("bplStatus2").setAttribute("validate", "");
		 document.getElementById("patientTypeId").setAttribute("validate", "");

	}

</script>
