<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasMainChargecode"%>
<%@page import="jkt.hms.masters.business.MasSubChargecode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%@page import="java.net.URL"%>
<form name="orderBooking" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%

	int pageNo=1;
	String buttonFlag="";
	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasMainChargecode> mainChargeCodeList = new ArrayList<MasMainChargecode>();
	List<MasSubChargecode> subChargeCodeList = new ArrayList<MasSubChargecode>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<DischargeIcdCode> icdList = new ArrayList<DischargeIcdCode>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date=(String)utilMap.get("currentDate");
	String time=(String)utilMap.get("currentTime");
	List inPatientDetailList = new ArrayList();
	List chargeList = new ArrayList();
	Box box = HMSUtil.getBox(request);
	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
		} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");
	int dgOrderhdId = 0;
	int deptId=0;
	Integer doctorId=null;
	String deptName="";
	String userName = "";
	if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
	}
	if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
	}
	if(map.get("buttonFlag") != null){
	    buttonFlag=(String)map.get("buttonFlag");
	}
	if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	
	if(map.get("deptId") != null) {
		deptId = (Integer) map.get("deptId");
	}
	if(map.get("pageNo") != null){
		pageNo=(Integer)map.get("pageNo");
	}
	if(map.get("dgOrderhdId") != null){
		dgOrderhdId=(Integer)map.get("dgOrderhdId");
	}
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	if(map.get("inPatientDetailList") != null){
	inPatientDetailList = (List<Patient>)map.get("inPatientDetailList");
	}
	if(detailsMap.get("mainChargeCodeList") != null){
	mainChargeCodeList = (List<MasMainChargecode>)detailsMap.get("mainChargeCodeList");
	}
	if(detailsMap.get("subChargeCodeList") != null){
	subChargeCodeList = (List<MasSubChargecode>)detailsMap.get("subChargeCodeList");
	}
	if(detailsMap.get("chargeList") != null){
	chargeList = (List)detailsMap.get("chargeList");
	}
	if(map.get("icdList") != null){
		icdList = (List<DischargeIcdCode>)map.get("icdList");
	}
	if(map.get("doctorId") != null){
	 	 doctorId = (Integer)map.get("doctorId");
	}
	int inpatientId = 0;
	String adNo ="";
	String admissionNumber = "";
	int hinId = 0;
	Inpatient inpatient = null;
	Patient patient =new Patient();
	MasDepartment masDepartment=new MasDepartment();
	int hin = 0;
	if(inPatientDetailList != null )
	{
	Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
	hinId=inPatientDetail.getHin().getId();
	
	try
	{
	inpatient = (Inpatient) inPatientDetailList.get(0);
	patient = (Patient) inpatient.getHin();
	masDepartment=(MasDepartment)inpatient.getDepartment();
	admissionNumber=inPatientDetail.getAdNo();
	session.setAttribute("admissionNumber",admissionNumber);
	
	try{
	if(patient.getInpatients() != null)
	{
		hin = patient.getId();
		Set<Inpatient> inpatientSet = patient.getInpatients();	    
				if(!inpatient.getAdStatus().equals("D")){
				inpatientId = inpatient.getId();
				adNo = inpatient.getAdNo();
	}}} 
	catch (Exception e) 
	{
		admissionNumber = "";
	}}
	catch(Exception e)
	{
	e.printStackTrace();
	}}
%> <script>
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


<div class="titleBg">
<h2>Order Booking</h2>
</div>
<input type="hidden" name="deptName" id="deptName"
	value="<%=deptName %>" />
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><input type="hidden" name="pageNo" id="pageNo"
	value="<%=pageNo%>" /> <%
		String orderSeqNo="";
		if(map.get("orderSeqNo") != null){
			orderSeqNo = (String)map.get("orderSeqNo");
		}
%> <label>Order Number</label> <input id="orderId" type=hidden
	name="<%=ORDER_NO %>" value="<%=orderSeqNo %>" title="Order Number" />

<label class="value"> <%=orderSeqNo %> </label> <input type="hidden"
	id="dgOrderhdId" name="dgOrderhdId" value="<%= dgOrderhdId%>" /> <input
	type="hidden" id="hinId" value="<%= hinId%>" /> <input type="hidden"
	id="admissionNumber" value="<%= admissionNumber%>" /> <label>Order
Date</label> <label class="value"><%= date%></label> <label>Order Time</label> <label
	class="value"><%= time%></label>
<div class="clear"></div>
<%
				if(inpatient.getAdNo() != null && !(inpatient.getAdNo().equals(""))){
	 %>
<div class="clear"></div>
<label>IP No.</label> <label class="value"><%=inpatient.getAdNo().toString()%></label>
<%}else{ %> <label class="value">-</label> <%}%> <label>HIN</label> <label
	class="value"><%=inpatient.getHin().getHinNo() %></label> <label>Patient
Name</label> <label class="value"><%=inpatient.getHin().getPFirstName() + " " + inpatient.getHin().getPMiddleName() + " " 
		+ inpatient.getHin().getPLastName()%></label> <%
				if(inpatient.getAge() != null && !(inpatient.getAge().equals(""))){
	  %> <label>Age/Sex</label> <label class="value"><%=inpatient.getAge()%>/<%=inpatient.getHin().getSex().getAdministrativeSexName() %></label>
<%}else{ %> <label class="value">-</label> <%}%> <%
			if(inpatient.getDepartment()!= null && !(inpatient.getDepartment().equals(""))){
		%>
<div class="lear"></div>
<label>Ward</label> <label class="value"><%= inpatient.getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%}%> <label>Marital
Status</label> <%
					String maritalStatus = "";
				if(inpatient.getHin().getMaritalStatus() != null){
					maritalStatus =inpatient.getHin() .getMaritalStatus().getMaritalStatusName();
				
				%> <label class="value"><%=maritalStatus%></label> <%}else{ %> <label
	class="value">-</label> <% }%>
<div class="clear"></div>
<%
				String religion = "";
				if(inpatient.getHin().getReligion() != null){
					religion = inpatient.getHin().getReligion().getReligionName();
				%> <label>Religion</label> <label class="value"><%= religion%></label>
<%} %> <label>Test Type</label> <select name="<%=TEST_TYPE%>">
	<option value="Regular">Regular</option>
	<option value="Urgent">Urgent</option>
</select>

<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block"><label>Clinical Notes</label> <input
	id="clinicalNote" type="text" name="<%= CLINICAL_NOTE%>" value=""
	validate="Clinical Notes,string,no" MAXLENGTH="100" tabindex=1
	style="width: 600px;" />
<div class="clear"></div>
<label><span>*</span> Prescribed By</label> <select id="placedBy"
	name="<%=EMPLOYEE_ID %>" validate="Prescribed By,string,yes" tabindex=1>
	<option value="0">Select</option>
	<% 
		for (MasEmployee  obj : employeeList){
		if(obj.getEmpCategory() != null){
		if(obj.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor) ){
		
		String doctorMiddleName = "";
		String doctorLastName = "";
		
		doctorMiddleName = obj.getMiddleName();
		doctorLastName = obj.getLastName();
	
	%>
	<option value="<%=obj.getId()%>"><%=obj.getFirstName()+" "+doctorMiddleName+" "+doctorLastName%></option>
	<%  } }
	}%>
</select> <input type="hidden" name="hin" value="<%=patient.getHinNo() %>" /> <input
	type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" /> <input
	type="hidden" name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>" />
<input type="hidden" name="<%=INPATIENT_ID %>" value="<%=inpatientId%>" />
<input type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=inpatient.getDepartment().getId() %>" /> <input
	type="hidden" name="<%=CREATED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <input
	type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <label class="medium">Lab</label>

<select id="mainChargeCodeId" name="<%=MAIN_CHARGECODE_ID %>"
	onchange="populateSubCharge(this.value,'orderBooking');">
	<option value="0">Select</option>
	<%
			for(MasMainChargecode mainChargecode : mainChargeCodeList){
		%>
	<option value="<%=mainChargecode.getId() %>"
		<%=HMSUtil.isSelected(mainChargecode.getId(),Integer.valueOf(box.getInt(MAIN_CHARGECODE_ID)))%>><%=mainChargecode.getMainChargecodeName() %></option>
	<%}%>
</select> <label class="medium">Lab Group</label> <select id="subChargeCodeId"
	name="subChargeCode_id">
	<option value="0">Select</option>
	<%
	for(MasSubChargecode subChargecode : subChargeCodeList){
	%>
	<option value="<%=subChargecode.getId() %>"
		<%=HMSUtil.isSelected(subChargecode.getId(),Integer.valueOf(box.getInt(SUB_CHARGECODE_ID)))%>><%=subChargecode.getSubChargecodeName() %></option>
	<%}%>
</select> <script type="text/javascript">

<%

	int counter1 = 0;
	for (MasMainChargecode mainChargecode : mainChargeCodeList){
	for (MasSubChargecode subChargecode : subChargeCodeList) {
	if(subChargecode.getMainChargecode() != null){
	if(mainChargecode.getId().equals(subChargecode.getMainChargecode().getId() )){
%>
	subChargeArray[<%=counter1%>] = new Array();
	subChargeArray[<%=counter1%>][0]=<%=mainChargecode.getId()%>;
	subChargeArray[<%=counter1%>][1] = <%=subChargecode.getId()%>;									
	subChargeArray[<%=counter1%>][2] = "<%=subChargecode.getSubChargecodeName()%>";
	<%
	counter1++;
	} } } }

%>
</script> <script type="text/javascript">
var amtArray = new Array();
<%
int  counter=0;
	if(chargeList!=null){
	Iterator ite = chargeList.iterator();
	while ( ite.hasNext() ) {
	Object[] pair = (Object[]) ite.next();
	MasChargeCode masChargeCode = (MasChargeCode) pair[0];

%>
	amtArray[<%=counter%>] = new Array();
	amtArray[<%=counter%>][0]=<%=masChargeCode.getId()%>;
	amtArray[<%=counter%>][1] = <%=masChargeCode.getChargeCodeCode()%>;									

<%
counter++;
}}
%>
</script>
<div class="clear"></div>

<label>Common</label> <input type="radio" id="rareCommon1"
	name="<%=RARE_COMMON  %>" class="radioCheck" value="c"
	checked="checked" /> <label>Rare</label> <input type="radio"
	id="rareCommon2" name="<%=RARE_COMMON  %>" class="radioCheck" value="r" />
<div class="clear"></div>
</div>
<input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="delete" value="" class="buttonDel"
	onclick="removeRow();" />
<div class="clear"></div>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="chargeDetails">
	<tr>
		<th scope="col"></th>
		<th scope="col">Test Code</th>
		<th scope="col">Test Name</th>
		<th scope="col">Qty</th>
		<th scope="col">Rate</th>
		<th scope="col">Amount</th>
		<th scope="col">&nbsp;</th>
	</tr>

	<%
		int inc = 1;
	%>
	<tr>
		<input type="hidden" value="<%=dgOrderhdId %>" name="dgOrderhdId"
			id="dgOrderhdId" />
		<td><input type="checkbox" value="<%=inc%>" name="selectedChrage"
			class="radioCheck" /></td>
		<td><input type="text" name="chargeCode<%=inc%>"
			id="chargeCode<%=inc%>"
			onblur="if(validateChargeCodeForAutoComplete(this.value, '<%=inc %>')){submitProtoAjaxWithDivName('orderBooking','/hms/hms/lab?method=fillChargeCode&rowVal=1&hin=<%=hin%>','rateVal');}"
			tabindex="1" />
		<div id="ac2update" class="autocomplete" style="display: none;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			  function eventCallback(element, entry){
			 var r;
			 if(document.getElementById('rareCommon1').checked == true){
			 r=document.getElementById('rareCommon1').value;
			 }else {
			 r=document.getElementById('rareCommon2').value;
			 }
						return entry + "&mainChargeCodeId=" + document.getElementById('mainChargeCodeId').value+"&subChargeCodeId="+document.getElementById('subChargeCodeId').value+"&rareCommon="+r; 
				}
			    new Ajax.Autocompleter('chargeCode<%=inc%>','ac2update','lab?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode<%=inc%>', callback: eventCallback});
			  
			</script></td>
		<input type="hidden" value="" name="<%=CHARGE_CODE_ID%>"
			id="chargeCodeId<%=inc %>" />
		<input type="hidden" value="" name="<%=MAIN_CHARGECODE_ID%>"
			id="mainChargeId<%=inc %>" />
		<input type="hidden" value="" name="<%=SUB_CHARGECODE_ID%>"
			id="subCharegId<%=inc %>" />
		<td><input type="text" id="chargeName<%=inc%>"
			name="<%=CHARGE_NAME%>" value="" /></td>

		<td><input type="text" id="qty<%=inc%>"
			name="<%=QUANTITY %><%=inc%>" value="" validate="Qty,int,yes"
			MAXLENGTH="3"
			onblur="validateQty(this.value,this.id);calculateAmt(<%=inc %>);totalCost();" />
		</td>

		<td id="rateVal"><input type="text" value="" id="resrate<%=inc%>"
			name="<%=RATE%><%=inc%>" validate="Rate,float,no"
			onblur="calculateAmt(<%=inc %>);totalCost();" class="readonly"
			size="15" maxlength="12" /></td>

		<td><input type="text" id="amount<%=inc%>" value=""
			name="<%=AMOUNT%><%=inc%>" onblur="totalCost();" class="readonly"
			readonly="readonly" /></td>
		<td><input type="button" name="add" value="" class="buttonAdd"
			onclick="addRow();" tabindex="1" /></td>

	</tr>

	<!-- -<input type="hidden" value="<%=dgOrderhdId %>" name="dgOrderhdId" id="dgOrderhdId" />--->
</table>

<input type="hidden" value="<%=inc %>" name="hiddenValueCharge"
	id="hiddenValueCharge" /></div>
<div class="clear"></div>
<div class="paddFltRight110"><label class="medium"><a>Total
Cost</a></label> <input type="text" id="totalCostId" name="<%=TOTAL_AMOUNT%>"
	value="0" class="auto" class="readOnly" readOnly /></div>
<div class="clear"></div>

<%
			String diagnosis = "";
			if(icdList.size() > 0){
				for(DischargeIcdCode dischargeIcdCode : icdList){
					if(diagnosis.equals("")){
						if(dischargeIcdCode.getDiagnosisStatus().equals("p"))
						diagnosis = dischargeIcdCode.getIcd().getIcdName();
					}else{
						if(dischargeIcdCode.getDiagnosisStatus().equals("p"))
						diagnosis = diagnosis.concat(" , ").concat(dischargeIcdCode.getIcd().getIcdName());
					}
				}
			}
		%> <label>Provisional Diagnosis</label> <label class="valueNoWidth"><%=diagnosis %></label>

<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=inc %>" />

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"
	onclick="submitForm('orderBooking','lab?method=submitOrderBooking');"
	align="right" /> <input type="reset" class="buttonHighlight"
	name="Reset" id="reset" value="Reset"
	onclick="resetClicked('orderBooking');" accesskey="r" /> <input
	type="hidden" name="rows" id="rr" value="1" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<!--Bottom labels ends-->
<div class="clear"></div>
<div class="paddingTop40"></div>
</form>


<script type="text/javascript">
function validateInteger( strValue ) {
  var objRegExp  = /(^\d\d*$)/;
  return objRegExp.test(strValue);
  if(!validateInteger(trimAll(textValue)))
					errors += name + " should be a number(without spaces).\n";						
}	

function validateQuantity(){
		errors = "";
		inputs = eval('document.'+'orderBooking'+'.elements');
		for(i=0;i<inputs.length;i++){
			if(inputs[i].type == 'text' ){
			textValue = trimAll(inputs[i].value);	
			
		if(textValue!= "" & type == 'int'){
				if(validateInteger(trimAll(textValue)))
					errors += document.getElementsByName('quantity') + " should be a number(without spaces).\n";
				}	
				}
				}
				alert(ggggggg)
					return errors;						
}
function  validateNumeric( strValue ) {
  var objRegExp  =  /(^-?\d\d*\.\d*$)|(^-?\d\d*$)|(^-?\.\d\d*$)/;
  return objRegExp.test(strValue);
}
function validateqty(){
 var qty;
if(document.getElementById('qty'))
		qty = document.getElementById('qty');
		if(qty != ""){
		if(!validateNumeric()){
		alert()
				alert("Quantity Should be numeric");
				document.getElementById('qty').value = "";
				return false;
			}
			
		}
			return true;
}

function totalCost(){
	var amt = 0;
	var count = document.getElementById('hiddenValueCharge').value;
	for(var i=1; i<=count; i++){
		var totalAmt = eval(document.getElementById("amount"+i));
		if(validateFloat(totalAmt.value)){
			if(amt != 0 && totalAmt.value != ""){
				amt = parseInt(amt)+parseInt(totalAmt.value);
			}else if(amt == 0 && totalAmt.value != ""){
				amt = parseInt(totalAmt.value);
			}
		}else{
			alert("Please enter valid Amount value.\n");
			document.getElementById("amount"+i).value = "";
			document.getElementById("amount"+i).focus();
			return false;
		}
	}
	document.getElementById('totalCostId').value = amt;
}
function validateChargeCodeForAutoComplete( strValue,inc ) {
 	if(strValue != "" && strValue !="No Items found")
	{ 
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);
		    if(id =="")
		    {
		    		document.getElementById('chargeCode'+inc).value="";
		    		document.getElementById('chargeName'+inc).value="";
		    		document.getElementById('qty'+inc).value="";
	   				if(document.getElementById('rate'+inc) != null)
		    			document.getElementById('rate'+inc).value="";
		    		if(document.getElementById('resrate'+inc) != null)
		    			document.getElementById('resrate'+inc).value="";
 					return ;
 			}
		 		for(i=1;i<inc;i++){
	 			if(inc != 1){
					if(document.getElementById('chargeCode'+i).value==strValue)
					{
						alert("Test Code already selected...!")
						document.getElementById('chargeCode'+inc).value=""
						var e=eval(document.getElementById('chargeCode'+inc)); 
						e.focus();
						return false;
					} }  }
				
			document.getElementById('qty'+inc).value="1";
			document.getElementById('qty'+inc).readOnly = false;
	      	return true;
	      	
 		}else{
 			document.getElementById('chargeCode'+inc).value="";
 			document.getElementById('chargeName'+inc).value="";
			if(document.getElementById('rate'+inc) != null)
   			document.getElementById('rate'+inc).value="";
   			if(document.getElementById('resrate'+inc) != null)
   			document.getElementById('resrate'+inc).value="";
			document.getElementById('qty'+inc).value="";
 			return false;
 			}
}


function addRow(){
	var tbl = document.getElementById('chargeDetails');
	var lastRow = tbl.rows.length;
	
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('hiddenValueCharge');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;
	
	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'checkbox';
	e0.name='selectedChrage';
	e0.value=(iteration);
	cell0.appendChild(e0);
	
	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.onblur=function(){
				if(validateChargeCodeForAutoComplete(this.value, (iteration))){submitProtoAjaxWithDivName('orderBooking','/hms/hms/lab?method=fillChargeCode&rowVal='+(iteration)+'&hin=<%=hin%>','rateVal'+(iteration));}
				
			  };
	e1.name = 'chargeCode'+ (iteration);
	e1.id = 'chargeCode' + (iteration);
	e1.tabIndex="1";
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update');
   	newdiv.style.display = 'none';
   	newdiv.setAttribute('class', 'autocomplete');
   
   	cell1.appendChild(e1);
    cell1.appendChild(newdiv);

	new Ajax.Autocompleter('chargeCode'+ (iteration),'ac2update','lab?method=getChargeCodeForAutoComplete',{parameters:'requiredField=chargeCode'+ (iteration), callback: eventCallback});
		
	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=CHARGE_NAME%>'+ (iteration);
	e2.id = 'chargeName'+(iteration)
	e2.tabIndex="1";
	e2.readOnly = true;
	cell2.appendChild(e2);
	e2.size='20';
	
	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=QUANTITY%>'+ (iteration);
	e3.id = 'qty'+(iteration)
	e3.maxLength="3";
	e3.onblur = function(){
					validateQty(this.value,this.id);calculateAmt(iteration);totalCost();
	};
	e3.readOnly = true;
	cell3.appendChild(e3);
	e3.size='20';
	
	
	var cell4 = row.insertCell(4);
	cell4.id='rateVal'+(iteration);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=RATE%>'+ (iteration);
	e4.readOnly = true;
	e4.id='rate'+(iteration);
	e4.onblur = function(){
					calculateAmt((iteration));
			};
	cell4.appendChild(e4); 
	e4.size='15';
	
	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='<%=AMOUNT%>'+ (iteration);
	e5.readOnly = true;
	e5.id='amount'+(iteration);
	e5.onblur = function(){
					totalCost();
			};
	cell5.appendChild(e5); 
	
	var cell6 = row.insertCell(6);
	var e6 = document.createElement('input');
	e6.type = 'button';
	e6.name='add';
	e6.className = 'buttonAdd';
	e6.tabIndex="1";
	e6.onclick = function(){
	           	addRow();
	}
	cell6.appendChild(e6); 
	
}

function removeRow()
{
	var tbl = document.getElementById('chargeDetails');
	 var tblRows  = tbl.getElementsByTagName("tr");
	
  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }
	         
	for(counter=0;counter<document.getElementsByName('selectedChrage').length;counter++)
	{
		if (document.getElementsByName('selectedChrage')[counter].checked == true) 
		{
		  	tbl.deleteRow(counter+1);
		}
	}
}
</script>
<script type="text/javascript">
function fillSrNo(rowVal){

	if(document.getElementById('chargeCode'+rowVal).value != ""){
		var pageNo=parseInt(document.getElementById('noOfRecords').value);
  			rowVal=rowVal%8
  		if(rowVal==0){
  			rowVal=8
  	 	}
  		if(!(parseInt(document.getElementById('noOfRecords').value)>parseInt(rowVal))){
 		  	document.getElementById('noOfRecords').value=rowVal
			}
	}else if(document.getElementById('chargeCode'+rowVal).value == "" ){
		if(document.getElementById('noOfRecords').value > 0){
			document.getElementById('noOfRecords').value = parseInt(document.getElementById('noOfRecords').value)-1;
		}
	}
		return true;
}

function checkForChargeCode(val,inc){
		if(val != "")
		{
			var pageNo =parseInt(document.getElementById('pageNo').value) 
			var start=((pageNo-1)*8)+1;
			var end=((pageNo-1)*8)+8;
			
			var index1 = val.lastIndexOf("[");
			var indexForChargeCode = index1;
			var index2 = val.lastIndexOf("]");
			index1++;
			var chargeId = val.substring(index1,index2);
			var indexForChargeCode = indexForChargeCode--;
			var chargeCode = val.substring(0,indexForChargeCode);
		
		if(chargeId =="")
		{
	     document.getElementById('chargeName'+inc).value="";
	  	 document.getElementById('qty'+inc).value="";
	     return;
		}
		for(i=1;i<inc;i++){
		
		if(inc != 1){
		if(document.getElementById('chargeCode'+i).value==val)
		{
			alert("Charge Code already selected...!")
			document.getElementById('chargeCode'+inc).value=""
			var e=eval(document.getElementById('chargeCode'+inc)); 
			e.focus();
			return false;
		} }  }
		
		ajaxFunctionForAutoCompleteChargeCodeName('orderBooking','lab?method=fillItemsForChargeCode&chargeCode=' +  chargeCode , inc);
		
		}else{
			document.getElementById('chargeName'+inc).value = "";
			document.getElementById('qty'+inc).value = "";
		}
}
function checkForNext(){
	  if(document.getElementById('noOfRecords').value<8)
	  {
	  	alert("All rows are not filled.");
	  	return false;
	  }else{
	  	var msg ="";
	  	var count = document.getElementById('noOfRecords').value;
	  	for(var i=1;i<=count;i++){
	  	 	if(document.getElementById('chargeCode'+i).value != ""){
	  			if(document.getElementById('qty'+i).value == ""){
	  				msg += "Quantity can not be blank.\n";
	  			}
	  			if(document.getElementById('chargeName'+i).value == ""){
	  				msg += "Charge Name can not be blank.\n";
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


function clearAllFields(inc){
	var chargeName = document.getElementById('chargeName'+inc).value
	var qty = document.getElementById('qty'+inc).value;
	
}
</script>

