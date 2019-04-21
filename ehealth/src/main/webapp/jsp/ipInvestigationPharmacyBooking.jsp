<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.net.URL"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.InpatientPrescriptionDetails"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%><script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<form name="ipInvPhrBooking" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%

		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);

	Map<String,Object> map = new HashMap<String,Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	List<Inpatient> patientDetailsList = new ArrayList<Inpatient>();
	List<MasChargeCode> chargeCodeList = new ArrayList<MasChargeCode>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	List<InpatientPrescriptionDetails> inPatientPrescriptionDetailsList = new ArrayList<InpatientPrescriptionDetails>();

	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	}

	if(map.get("detailsMap") != null){
		detailsMap = (Map<String,Object>)map.get("detailsMap");
	}
	if(map.get("patientDetailsList") != null){
		patientDetailsList = (List<Inpatient>)map.get("patientDetailsList");
	}
	if(detailsMap.get("chargeCodeList") != null){
		chargeCodeList = (List<MasChargeCode>)detailsMap.get("chargeCodeList");
	}
	if (map.get("employeeList") != null) {
		employeeList = (List<MasEmployee>) map.get("employeeList");
	}
	if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map.get("departmentList");
	}
	if(map.get("inPatientPrescriptionDetailsList") != null){
		inPatientPrescriptionDetailsList = (List<InpatientPrescriptionDetails>)map.get("inPatientPrescriptionDetailsList");
	}

	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	Properties properties = new Properties();
	URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
	try {
		properties.load(resourcePath.openStream());
	} catch (Exception e) {
		e.printStackTrace();
	}
	String empCategoryCodeForDoctor = properties.getProperty("empCategoryCodeForDoctor");

	int hinId = 0;
	int patientTypeId = 0;
	if(patientDetailsList.size() > 0){
     %> <!--Block One Starts-->
<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%

   		for(Inpatient inpatient : patientDetailsList){
   		 Patient patient = inpatient.getHin();
   		 hinId = patient.getId();
   			patientTypeId = patient.getPatientType().getId();
%>
<div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <%
		    String adNo = "";
	    String ward = "";
		    int inpatientId = 0;
		   	if(!inpatient.getAdStatus().equals("D")){
					inpatientId = inpatient.getId();
					adNo = inpatient.getAdNo();
					ward = inpatient.getDepartment().getDepartmentName();
			}
	    %> <label class="value"> <%=adNo%></label> <label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <label
	class="value"><%=patient.getHinNo() %></label> <label>Ward</label> <label
	class="value"> <%=ward%></label>

<div class="clear"></div>

<label>Patient Name</label> <%
String patientName="";
String firstName="";
String middleName="";
String lastName="";
if(patient.getPFirstName()!=null){
firstName=patient.getPFirstName();
}
if(patient.getPMiddleName()!=null){
middleName=patient.getPMiddleName();}
if(patient.getPLastName()!=null){
lastName=patient.getPLastName();}
patientName=firstName+" "+middleName+" "+lastName;

		%> <label class="value"> <%=patientName%></label>
<label>Age</label> <label class="value"> <%=patient.getAge() %></label>
<label>Sex</label> <label class="value"> <%=patient.getSex().getAdministrativeSexName() %></label>



<label><span>*</span> Consultant Name</label> <select
	name="<%=EMPLOYEE_ID %>" id="cnsltDocId"
	validate="Consultant Name,string,yes" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasEmployee employee : employeeList) {
			if (employee.getEmpCategory() != null) {
				if (employee.getEmpCategory().getEmpCategoryCode().equals(empCategoryCodeForDoctor)) {

					String doctorMiddleName = "";
					String doctorLastName = "";
					if (employee.getMiddleName() != null)
						doctorMiddleName = employee.getMiddleName();
					if (employee.getMiddleName() != null)
						doctorLastName = employee.getLastName();
	%>
	<option value="<%=employee.getId()%>"><%=employee.getFirstName()+ " " + doctorMiddleName + " "+ doctorLastName%></option>
	<%
		}
						}
					}
	%>
</select> <label>Patient Type</label> <label class="value"><%=patient.getPatientType().getPatientTypeName() %></label>

<%
 	if(patient.getCompany() != null){
 		if(patient.getPatientType().getId() == 1){
 %> <label>Company</label> <%}else if(patient.getPatientType().getId() == 4){ %>
<label>Project</label> <%} %> <label class="value"><%=patient.getCompany().getCompanyName() %></label>
<input type="hidden" id="companyId" name="companyId"
	value="<%=patient.getCompany().getId() %>" /> <%} %> <input
	type="hidden" id="patientTypeId" name="<%=PATIENT_TYPE_ID %>"
	value="<%=patientTypeId %>" />
<div class="clear"></div>

<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>"/><input
	type="hidden" name="<%=HIN_NO %>" value="<%=patient.getHinNo() %>"/><input
	type="hidden" name="<%=INPATIENT_ID %>" id="<%=INPATIENT_ID %>" value="<%=inpatientId%>"/><input
	type="hidden" id="<%=AD_NO %>" name="<%=AD_NO %>" value="<%=adNo%>"/><script
	type="text/javascript">

<%
	if(inpatient.getDoctor() != null){
%>
document.getElementById('cnsltDocId').value = '<%=inpatient.getDoctor().getId()%>'
<%}%>
</script> <%} %>
</div>
<script type="text/javascript">
		var amtArray = new Array();
		<%
			int count = 0;
			for (MasChargeCode masChargeCode : chargeCodeList)
			{
			%>
				amtArray[<%=count%>] = new Array();
				amtArray[<%=count%>][0]=<%=masChargeCode.getId()%>;
				amtArray[<%=count%>][1] = <%=masChargeCode.getCharge()%>;

			<%
			count++;
			}
		%>
		</script> <input type="hidden" size="2" value="" name="noOfRecords"
	id="noOfRecords" />
<div class="clear"></div>
<div id="testDiv">

</div>
<div class="clear"></div>
<div class="paddingTop15"></div>

<h4>Item Details</h4>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="delete" value="" class="buttonDel"
	onclick="removeRowDispense();" />
 	 <input type="button" name="add" value="" class="buttonAdd"
			onclick="addRowDispense();" tabindex="1" />
<input type="button" name="openButton" value="Show Prescriptions"	class="buttonBig3" onclick="submitProtoAjaxForOrderRequest('ipInvPhrBooking','/hms/hms/billing?method=viewPrescriptionForOrderBooking')" />

	<label><span>*</span> To
Department</label> <select id="toDeptId" name="toDeptId"
	validate="To Department,string,no">
	<option value="0">Select</option>
	<%
	for(MasDepartment department : departmentList){
		if(department.getDepartmentCode().equalsIgnoreCase("PHAR")){
			%>
<option value="<%=department.getId() %>" selected="selected"><%=department.getDepartmentName() %></option>
	<% }else{
%>
	<option value="<%=department.getStoreType().getId() %>"><%=department.getStoreType().getDepartmentName() %></option>
	<%}
		}%>
</select>
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0"
	id="itemDetails">
	<tr>
		<th scope="col"></th>
		<th scope="col">Item Code</th>
		<th scope="col">Description</th>
		<th scope="col">Qty</th>
		<th scope="col">Dispensing Price</th>
		<th scope="col">Dispensing Amount</th>

 	</tr>
	<%
		int i = 1;
//	for(InpatientPrescriptionDetails details: inPatientPrescriptionDetailsList){

//		 MasStoreItem item = details.getItem();
//		 BigDecimal qty = new BigDecimal("0");
//		 if(details.getIssuedQty()!=null){
//		  qty  =	(BigDecimal)details.getIssuedQty();
//		 }
//		 BigDecimal dispPrice = new BigDecimal("0");
//		 if(details.getDispensingPrice()!=null){
//		   dispPrice = details.getDispensingPrice();
//		 }
	%>
	<tr>
		<td><input type="radio" value="<%=i%>" name="selectedItem"
			class="radioCheck" /></td>
		<td id="codeDiv"><input type="text" name="<%=ITEM_CODE%><%=i%>"
			size="15" id="itemCode<%=i%>" value="" readonly="readonly" /></td>
		<td id="nameDiv"><input type="text" value="" id="itemName<%=i%>"
			name="<%=ITEM_NAME%><%=i%>" size="50" tabindex="1"
			validate="Item Name,string,no "
			onblur="if(validateItemCodeForAutoComplete(this.value,'<%=i %>')){populateDispensingPrice(this.value,<%=i %>);}" />
	<div id="ac2update<%=i%>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
		    new Ajax.Autocompleter('itemName<%=i%>','ac2update<%=i%>','opBilling?method=getItemCodeForAutoComplete',{parameters:'requiredField=itemName<%=i%>'});
		</script> <input type="hidden" id="itemId<%=i %>" name="<%=ITEM_ID%><%=i%>"
			value=" " /></td>
		<td><input type="text" size="5" id="qtyDisp<%=i%>"
			name="qtyDisp<%=i%>" value="" validate="Qty,int,no"
			onblur="calculateDispAmt(this.value,<%=i %>);" maxlength="3"
			tabindex="1" /></td>
		<td><input type="text" size="11" id="dispensingPrice<%=i%>"
			name="dispensingPrice<%=i%>" value=""  maxlength="11"
			tabindex="1" /></td>
		<td><input type="text" size="11" id="dispensingAmount<%=i%>"
			name="dispensingAmount<%=i%>" value=""  maxlength="11"
			tabindex="1" /></td>
 	</tr>
<%}%>
</table>

<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="1" />
<input type="hidden" name="counter0" id="counter0" value="0" />
<input type="hidden" name="hiddenValueCharge" id="hiddenValueCharge" value="1" />

<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit" name="Submit11"
	tabindex="1"
	onclick="submitForm('ipInvPhrBooking','billing?method=submitOrderBookingDetails','checkDepartmentForPhrItem');"
	align="right" /> <input type="button" class="buttonHighlight"
	value="Reset" onclick="form.reset();resetAjaxValueForBilling();" />
<div class="clear"></div>


<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<%// }else{
%> <%
//}
%>
</form>

<div class="division"></div>

<script type="text/javascript">

function addRow(){
	var tbl = document.getElementById('chargeDetailsTable');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('counter');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;

	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.name='selectedChrage';
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.onblur=function(){
				if(validateChargeCodeForOrderRequestAutoComplete(this.value, iteration,'ip')){submitProtoAjaxWithDivName('ipInvPhrBooking','/hms/hms/opBilling?method=fillChargeCode&charge'+iteration+'='+encodeURIComponent(this.value)+'&rowVal='+iteration+'&hin=<%=hinId%>&type=ip','rateVal'+iteration);}

			  };
	e1.name = 'chargeCode'+ (iteration);
	e1.id = 'chargeCode'+ (iteration);
	e1.size = '50';
	e1.tabIndex="1";

	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
   	cell1.appendChild(e1);
   	e1.focus();
    cell1.appendChild(newdiv);

	new Ajax.Autocompleter('chargeCode'+iteration,'ac2update'+iteration,'billing?method=getChargeCode',{parameters:'requiredField=chargeCode'+iteration});


	var cell2 = row.insertCell(2);
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=QUANTITY%>'+ (iteration);
	e2.id = 'qty'+(iteration)
	e2.readOnly = true;
	e2.size='5';
	e2.onblur= function(){calculateAmt(this.value,iteration);};
	cell2.appendChild(e2);


	var cell3 = row.insertCell(3);
	cell3.id='rateVal'+(iteration);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='<%=RATE%>'+ (iteration);
	e3.readOnly = true;
	e3.size='12';
	e3.id='rate'+(iteration);
	cell3.appendChild(e3);

	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='<%=AMOUNT%>'+ (iteration);
	e4.readOnly = true;
	e4.size='13';
	e4.id='amount'+(iteration);
	cell4.appendChild(e4);

	var e5 = document.createElement('input');
	e5.type = 'hidden';
	e5.name='<%=DISCOUNT_PERCENTAGE%>'+ (iteration);
	e5.id='dispercent'+(iteration);
	e5.size = '10';
	e5.maxLength = '3';
	cell4.appendChild(e5);

	var e6 = document.createElement('input');
	e6.type = 'hidden';
	e6.name='<%=DISCOUNT%>'+ (iteration);
	e6.id='disamount'+(iteration);
	e6.maxLength = '7';
	e6.size = '10';
	cell4.appendChild(e6);

	var e7 = document.createElement('input');
	e7.type = 'hidden';
	e7.name='<%=PROPORTIONAL_DISCOUNT%>'+ (iteration);
	e7.id='prprtnlDis'+(iteration);
	e7.readOnly = true;
	e7.size = '10';
	cell4.appendChild(e7);

	var e8 = document.createElement('input');
	e8.type = 'hidden';
	e8.name='<%=NET_AMOUNT%>'+ (iteration);
	e8.id='netamount'+(iteration);
	e8.readOnly = true;
	e8.size = '10';
	cell4.appendChild(e8);

	var cell5 = row.insertCell(5);
	var e9 = document.createElement('input');
	e9.type = 'button';
	e9.name='add';
	e9.className = 'buttonAdd';
	e9.tabIndex="1";
	e9.onclick = function(){
					addRow();
	}
	cell5.appendChild(e9);
}

function removeRow()
{
	var tbl = document.getElementById('chargeDetailsTable');
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
			/*calculateTotalAmtForIp();*/
		}
	}
}

function addRowDispense(){
	var tbl = document.getElementById('itemDetails');
	var lastRow = tbl.rows.length;

	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('counter');
	var iteration = parseInt(hdb.value)+1;
	hdb.value = iteration;
	
	var cell0 = row.insertCell(0);
	var e0 = document.createElement('input');
	e0.type = 'radio';
	e0.className = 'radioCheck';
	e0.name='selectedItem';
	e0.className = 'radioCheck';
	e0.value=(iteration);
	cell0.appendChild(e0);

	var cell1 = row.insertCell(1);
	cell1.id = 'codeDiv'+iteration;
	var e1 = document.createElement('input');
	e1.type = 'text';

	e1.name = '<%=ITEM_CODE%>'+ (iteration);
	e1.id = 'itemCode' + (iteration);
	e1.size = '15';

	var e11 = document.createElement('input');
	e11.type = 'hidden';

	e11.name = '<%=ITEM_ID%>'+ (iteration);
	e11.id = 'itemId' + (iteration);
	cell1.appendChild(e1);
    cell1.appendChild(e11);

	var cell2 = row.insertCell(2);
	cell2.id = 'nameDiv'+iteration;
	var e2 = document.createElement('input');
	e2.type = 'text';
	e2.name='<%=ITEM_NAME%>'+ (iteration);
	e2.id = 'itemName'+(iteration)
	e2.tabIndex="1";
	e2.size = '50';
	var newdiv = document.createElement('div');
   	newdiv.setAttribute('id', 'ac2update'+iteration);
   	newdiv.style.display = 'none';
   	newdiv.className = "autocomplete";
	e2.onblur= function(){
					if(validateItemCodeForAutoComplete(this.value,iteration)){populateDispensingPrice(this.value,iteration)};
					};
	cell2.appendChild(e2);
	cell2.appendChild(newdiv);

	new Ajax.Autocompleter('itemName'+iteration,'ac2update'+iteration,'opBilling?method=getItemCodeForAutoComplete',{parameters:'requiredField=itemName'+iteration});

	var cell3 = row.insertCell(3);
	var e3 = document.createElement('input');
	e3.type = 'text';
	e3.name='qtyDisp'+ (iteration);
	e3.id = 'qtyDisp'+(iteration)
	e3.tabIndex="1";
	e3.maxLength ='3';
	e3.onblur = function(){calculateDispAmt(this.value,iteration);};
	e3.size='5';
	cell3.appendChild(e3);


	var cell4 = row.insertCell(4);
	var e4 = document.createElement('input');
	e4.type = 'text';
	e4.name='dispensingPrice'+ (iteration);
 	e4.id='dispensingPrice'+(iteration);
	e4.size = '11';
	cell4.appendChild(e4);

	var cell5 = row.insertCell(5);
	var e5 = document.createElement('input');
	e5.type = 'text';
	e5.name='dispensingAmount'+ (iteration);
 	e5.id='dispensingAmount'+(iteration);
	e5.size = '11';
	cell5.appendChild(e5);

}


function removeRowDispense()
{
	var tbl = document.getElementById('itemDetails');
	var tblRows  = tbl.getElementsByTagName("tr");

  	if(tblRows.length-2==0){
         	alert("Can not delete all rows")
         	return false;
     }

	for(counter=0;counter<document.getElementsByName('selectedItem').length;counter++)
	{
		if (document.getElementsByName('selectedItem')[counter].checked == true)
		{
		  	tbl.deleteRow(counter+1);
		  	/*calculateTotalAmtForIp();*/
		}
	}
}


function populateDispensingPrice(val,rowVal){

	var pvmsNo="";
	var index1 = val.lastIndexOf("[");
    var index2 = val.lastIndexOf("]");
	index1++;
	pvmsNo = val.substring(index1,index2);

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
		        var dispensingPrice  = item.getElementsByTagName("dispensingPrice")[0];
		        var itemId = item.getElementsByTagName("itemId")[0];

		      	document.getElementById("dispensingPrice"+rowVal).value=(dispensingPrice.childNodes[0].nodeValue);
	        	document.getElementById("itemCode"+rowVal).value = pvmsNo;
	        	document.getElementById("itemId"+rowVal).value = itemId.childNodes[0].nodeValue;
	        	document.getElementById("qtyDisp"+rowVal).value = document.getElementById("qtyDisp"+rowVal).value;
	        	document.getElementById('dispensingAmount'+rowVal).value = (dispensingPrice.childNodes[0].nodeValue)*(document.getElementById("qtyDisp"+rowVal).value);
	      	}
	      }
	      }
	    var url="opd?method=getDispensingPriceForItem&pvmsNo="+pvmsNo;
	 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
	  
	    xmlHttp.open("GET",url,true);
	    xmlHttp.setRequestHeader("Content-Type", "text/xml");
	    xmlHttp.send(null);

}

function calculateAmt(qty,rowVal){
	rate = document.getElementById('resrate'+rowVal).value;
	document.getElementById('amount'+rowVal).value = (parseFloat(rate)*parseFloat(qty)).toFixed(2);

}

function calculateDispAmt(qty,rowVal){
	dispensingPrice = document.getElementById('dispensingPrice'+rowVal).value;
	document.getElementById('dispensingAmount'+rowVal).value = (parseFloat(dispensingPrice)*parseFloat(qty)).toFixed(2);

}


function validateItemCodeForAutoComplete( strValue,inc ) {

 	if(strValue != "" && strValue !="No Items found")
	{
 			var index1 = strValue.lastIndexOf("[");
		    var index2 = strValue.lastIndexOf("]");
		    index1++;
		    var id = strValue.substring(index1,index2);

		    if(id =="")
		    {
		    		document.getElementById('itemName'+inc).value="";
	    			document.getElementById('itemCode'+inc).value="";
	    			document.getElementById('itemId'+inc).value="";
	   				document.getElementById('dispensingPrice'+inc).value="";
   					document.getElementById('dispensingAmount'+inc).value="";
	   				document.getElementById('qtyDisp'+inc).value="";
	   		
 					return ;
 			}

			for(i=1;i<inc;i++){
				if(inc != 1){
					if(document.getElementById('itemName'+i)!=null){
						var item =  document.getElementById('itemName'+i).value;
						var idx1 = item.lastIndexOf("[");
			    		var idx2 = item.lastIndexOf("]");
			   			 idx1++;
			    		var itemCode = item.substring(idx1,idx2);

						if(itemCode == id)
						{
							alert("Item already selected...!")
							document.getElementById('itemName'+inc).value=""
							document.getElementById('qtyDisp'+inc).value="";
							var e=eval(document.getElementById('itemName'+inc));
							e.focus();
							return false;
						}
					}
				}
			}
			document.getElementById('counter').value = parseInt(document.getElementById('counter').value);
			return true;
 		}else{
 				var itemId = document.getElementById('itemId'+inc).value;
 				document.getElementById('itemName'+inc).value="";
    			document.getElementById('itemCode'+inc).value="";
    			document.getElementById('itemId'+inc).value="";
   				document.getElementById('dispensingPrice'+inc).value="";
  				document.getElementById('dispensingAmount'+inc).value="";
   				document.getElementById('qtyDisp'+inc).value="";

		}

  return true;

}

function checkDepartmentForPhrItem(){
	var phrItemCount = document.getElementById('counter').value;
	var flag = false;
	if(parseInt(phrItemCount) > 0){
		for(var i=1;i<=phrItemCount;i++){
			if(document.getElementById('itemName'+i).value != ""){
				flag = true;
				break;
			}
		}
	}
	if(flag){
		if(document.getElementById('toDeptId').value == '0'){
			alert("Please select To Department for pharmacy items");
			return false;
		}
	}
	return true;
}




function submitProtoAjaxForOrderRequest(formName,action){

 var inpatientId = document.getElementById('inpatientId').value;
 //alert(inpatientId);
 	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&inpatientId="+inpatientId;
     	       	new Ajax.Updater('testDiv',url,
			   {asynchronous:true, evalScripts:true });
			return true;
 }

function CheckAll(chk){
	var rowLength=document.getElementById('rowLength').value;
	for (var i=0;i <document.ipInvPhrBooking.elements.length;i++)
		{
			var e = document.ipInvPhrBooking.elements[i];

			if (e.type == "checkbox")
			{
				e.checked = chk.checked;
				for(var j=1;j<=rowLength;j++)
				{
				  document.getElementById('checkId'+j).value="y";
				  document.getElementById('collected'+j).value="y";
				}
			}

		}
	}

function numberForCheckBoxClicked(counter)
{
 	var rowLength=document.getElementById('rowLength').value;
 	if(document.getElementById('checkId'+counter).checked==true)
	{
		document.getElementById('collected'+counter).value="y";
 	}
	else
	{
 		 document.getElementById('collected'+counter).value="n";
	}
 }
function jsAdd()
{
		if(validateButton()){
			var rowLength=document.getElementById('rowLength').value;
			if(rowLength>=1)
			{			
	 					for(var j=1;j<=rowLength;j++)
						{addRowDispense();
 						  document.getElementById('itemCode'+j).value = document.getElementById('itemC'+j).value;
						  document.getElementById('itemName'+j).value = document.getElementById('itemN'+j).value;
						  document.getElementById('itemId'+j).value = document.getElementById('itemI'+j).value;
						  document.getElementById('qtyDisp'+j).value = document.getElementById('qty'+j).value;
					

				}
			}
	}
}
function validateButton()
{
	if (document.ipInvPhrBooking.collected.length)
	{
			 for(var i = 0; i < document.ipInvPhrBooking.collected.length; i++)
			 {
			  if (document.ipInvPhrBooking.collected[i].checked == true)
             		return true;
			 }
	}
	else
	{
		if (document.ipInvPhrBooking.collected.checked == true)
			return true;
	}
 	return false;
}

</script>
