<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Properties"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
Map<String, Object> utilMap = new HashMap<String, Object>(); 
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
Map<String,Object> map = new HashMap<String, Object>();
List<MasHospital> hospitalList=new ArrayList<MasHospital>();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	String userName = "";
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("hospitalList") != null) {
		hospitalList = (List<MasHospital>) map.get("hospitalList");
	}
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
%>
<script type="text/javascript" language="javascript">
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
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<script type="text/javascript">
	function showDetailForOrderBooking(radioObj) {
		
		if (radioObj.value === 'individualOrderBooking') {
			document.getElementById("investigationOrderBookingId").show();
			document.getElementById("testDetailtable").show();
			document.getElementById("patientDetailDiv").show();
			document.getElementById("patientDetailtable").hide();
			document.getElementById("testDetailDiv").hide(); 
		} else if (radioObj.value === 'bulkOrderBooking') {
			document.getElementById("investigationOrderBookingId").show();
			document.getElementById("testDetailDiv").show();
			document.getElementById("testDetailtable").show();
			document.getElementById("patientDetailtable").show();
			document.getElementById("patientDetailDiv").hide(); 
		} else {
			return false;
		}

	}
	function removeRow(id,checkboxName)
	{ 
		var tbl = document.getElementById(id);
		 var tblRows  = tbl.getElementsByTagName("tr");

	  	if(tblRows.length-2==0){
	         	alert("Can not delete all rows")
	         	return false;
	     }

		for(counter=0;counter<document.getElementsByName(checkboxName).length;counter++)
		{
			if (document.getElementsByName(checkboxName)[counter].checked == true)
			{
			  	tbl.deleteRow(counter+1);
			  	totalCost();
			}
		}
	}
	function addRow(id){

		var tbl = document.getElementById(id);
		var lastRow = tbl.rows.length;

		var row = tbl.insertRow(lastRow);
		var hdb;
		if(id==='patientDetails'){
			hdb = document.getElementById('hiddenPatientdetails');
		}else{
			hdb = document.getElementById('hiddenValueCharge');
		}
		
		var iteration = parseInt(hdb.value)+1;
		hdb.value = iteration;

		var cell0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'checkbox';
		if(id==='patientDetails'){
			e0.name='selectedPatient';
		}else{
			e0.name='selectedChrage';
		} 
		e0.className = 'radioCheck';
		e0.value=(iteration);
		cell0.appendChild(e0);

		 var cell1 = row.insertCell(1);
		var e1 = document.createElement('input');
		e1.type = 'text';
		if(id==='patientDetails'){
			e1.name='patientName'+ (iteration);
			e1.id = 'patientName'+(iteration);
			e1.tabIndex="1"; 
			e1.maxLength="20";
			cell1.appendChild(e1); 
		}else{
			e1.onblur=function(){
				if(validateChargeCodeForAutoComplete(this.value, (iteration))){submitProtoAjaxWithDivName('bulkOrderRequisition','/hms/hms/lab?method=fillChargeCode&rowVal='+(iteration)+'&hin=0','rateVal'+(iteration));}

						  };
			e1.name = 'chargeCode'+ (iteration);
			e1.id = 'chargeCode' + (iteration);
			e1.tabIndex="1";
			var newdiv = document.createElement('div');
		   	newdiv.setAttribute('id', 'ac2update');
		   	newdiv.style.display = 'none';
		   	newdiv.style.background = '#FFF';
		   	newdiv.style.border = '1px solid #000';
		   	cell1.appendChild(e1);
		    cell1.appendChild(newdiv); 
			new Ajax.Autocompleter('chargeCode'+ (iteration),'ac2update','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCode'+ (iteration)});
			var e2 = document.createElement('input');
			e2.type = 'hidden';
			e2.name='<%=CHARGE_NAME%>'+ (iteration);
			e2.id = 'chargeName'+(iteration);
			e2.tabIndex="1";
			e2.readOnly = true;
			cell1.appendChild(e2);
			e2.size='20';
		} 
		
		var cell2 = row.insertCell(2);
		var e2 = document.createElement('input');
		e2.type = 'text';
		if(id==='patientDetails'){
			e2.name='patientAge'+ (iteration);
			e2.id = 'patientAge'+(iteration);
			e2.tabIndex="1";
			e2.maxLength="3"; 
			cell2.appendChild(e2); 
		}else{ 
			e2.name='<%=QUANTITY%>'+ (iteration);
			e2.id = 'qty'+(iteration)
			e2.maxLength="3";
			e2.onblur = function(){
							validateQty(this.value,this.id);calculateAmt(iteration);totalCost();
			};
			cell2.appendChild(e2);
			e2.size='20';
			
		}
		

		var cell3 = row.insertCell(3);
		var e3 = document.createElement('input');
		e3.type = 'text';
		if(id==='patientDetails'){
			var e3 = document.createElement('SELECT');
			e3.setAttribute("id", "patientGenderId"+iteration); 
			e3.name='patientGender'+ (iteration); 
			
			 var z0 = document.createElement("option");
			 z0.setAttribute("value", "-1");
			 var t0 = document.createTextNode("Select");
			 z0.appendChild(t0);  
			 e3.appendChild(z0); 
			 
			 var z1 = document.createElement("option");
			 z1.setAttribute("value", "2");
			 var t1 = document.createTextNode("Male");
			 z1.appendChild(t1);
			 e3.appendChild(z1); 
			 
			 var z2 = document.createElement("option");
			 z2.setAttribute("value", "3");
			 var t2 = document.createTextNode("Female");
			 z2.appendChild(t2);
			 e3.appendChild(z2); 
			 
			cell3.appendChild(e3);  
		}else{ 
			cell3.id='rateVal'+(iteration);
			var e3 = document.createElement('input');
			e3.type = 'text';
			e3.name='<%=RATE%>'+ (iteration);
			e3.readOnly = true;
			e3.id='rate'+(iteration);
			e3.onblur = function(){
							calculateAmt((iteration));
					};
			cell3.appendChild(e3);
			e3.size='15';
		}  
		if(!(id==='patientDetails')){ 
			<%-- e1.name = '<%=HIN_NO%>'+ (iteration);
			e1.id = '<%=HIN_NO%>' + (iteration);
			e1.tabIndex="1";
			cell1.appendChild(e1); --%>
			var cell4 = row.insertCell(4);
			var e4 = document.createElement('input');
			e4.type = 'text';
			e4.name='<%=AMOUNT%>'+ (iteration);
			e4.readOnly = true;
			e4.id='amount'+(iteration);
			e4.onblur = function(){
							totalCost();
					};
			cell4.appendChild(e4);
		}else if(id==='patientDetails'){
			var cell4 = row.insertCell(4);
			var e4 = document.createElement('SELECT');
			e4.setAttribute("id", "idType"+iteration); 
			e4.name='idType'+ (iteration); 
			e4.onchange=function(){
				idMakeReadOnly(iteration);
				};
			 var z0 = document.createElement("option");
			 z0.setAttribute("value", "0");
			 var t0 = document.createTextNode("No Id");
			 z0.appendChild(t0);  
			 e4.appendChild(z0); 
			 
			 var z1 = document.createElement("option");
			 z1.setAttribute("value", "ADHAR");
			 var t1 = document.createTextNode("Addhar No");
			 z1.appendChild(t1);
			 e4.appendChild(z1); 
			 
			 var z2 = document.createElement("option");
			 z2.setAttribute("value", "DL");
			 var t2 = document.createTextNode("Driving Licience");
			 z2.appendChild(t2);
			 e4.appendChild(z2); 
			 
			 var z3 = document.createElement("option");
			 z3.setAttribute("value", "VOTAR ID");
			 var t3 = document.createTextNode("Votar Id");
			 z3.appendChild(t3);
			 e4.appendChild(z3); 
			 
			 var z4 = document.createElement("option");
			 z4.setAttribute("value", "PAN");
			 var t4 = document.createTextNode("PAN");
			 z4.appendChild(t4);
			 e4.appendChild(z4);  
			 cell4.appendChild(e4);   
		} 
		if(!(id==='patientDetails')){
			var cell5 = row.insertCell(5);
			var e5 = document.createElement('input');
			e5.type = 'text';
			e5.name='<%=CLINICAL_NOTE%>'+ (iteration); 
			e5.tabIndex="1"; 
			cell5.appendChild(e5);
		}else if(id==='patientDetails'){
			var cell5 = row.insertCell(5);
			var e5 = document.createElement('input');
			e5.type = 'text';
			e5.setAttribute("id", "idNo"+iteration); 
			e5.name='idNo'+ (iteration); 
			e5.tabIndex="1"; 
			e5.readOnly=true; 
			cell5.appendChild(e5);
		} 
		if(id==='patientDetails'){
			var cell6 = row.insertCell(6);
			var e6 = document.createElement('input');
			e6.type = 'text';
			e6.name='address'+ (iteration); 
			e6.tabIndex="1"; 
			cell6.appendChild(e6);
		}
		if(id==='patientDetails'){
			var cell7 = row.insertCell(7);
			var e7 = document.createElement('input');
			e7.type = 'text';
			e7.name='mobileNo'+ (iteration); 
			e7.tabIndex="1"; 
			cell7.appendChild(e7);
		}
	}	
	
	function validateChargeCodeForAutoComplete(strValue,inc ) {  
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
	function checkTestRow()
	{


		var msg =""; 
		var count = document.getElementById('hiddenValueCharge').value;
		  	for(var i=1;i<=count;i++){

		  	 	if(document.getElementById('chargeCode'+i) != null){
		  	 		if(document.getElementById('chargeCode'+i).value != ""){
			  			if(document.getElementById('qty'+i).value == ""){
			  				msg += "Quantity can not be blank.\n";
			  			}
			  			if(document.getElementById('amount'+i).value == ""){
			  				msg += "Amount can not be blank.\n";
			  			}

			  			if(msg != ""){
			  				break;
			  			}
		  			}
		  			else{
		  				alert("Please fill atleast one charge to submit.");
		  				return false;
		  			}
		  		}
		  	}
		  	if(msg != ""){
		  		alert(msg)
		  		return false;
		  	}else{
		  		return true;
		  	}
		}
	function submitFormToDisableSubmit1(formName,action,extraFunction,extraFunction2,extraFunction3){

		errorMsgDisableSubmit="";
				ob1 = true;
				ob2 = true;
				ob3 = true;
				obj = eval('document.'+formName);

				if(eval("window."+extraFunction))
			    	ob1 =  eval(extraFunction+"()")

					if(eval("window."+extraFunction2))
			        	ob2 = eval(extraFunction2+"()")

					if(eval("window."+extraFunction3))
			        	ob3 = eval(extraFunction3+"()")

					if(validateFieldsForDisableSubmit(formName)== true & ob1 & ob2 &ob3){
						if(document.getElementById('submitForDisable') != null){
							document.getElementById('submitForDisable').disabled=true
						}
			        	obj.action = action;
						obj.submit();
					}else{
						if(errorMsgDisableSubmit != ""){
							alert(errorMsgDisableSubmit);
				       		return false;
				       	}
				       	return true;
			    	}
			}
	
function idMakeReadOnly(val){
	var ObjType=document.getElementById("idType"+val).value;
	var obj=document.getElementById("idNo"+val);
	if(0==ObjType){ 
		obj.clear();
		obj.readOnly=true;
		obj.setAttribute("validate","Id,string,no");  
	}else{
		obj.readOnly=false;
		obj.setAttribute("validate","Id,string,yes");  
	}
	
}
	
</script>
<div id="mainIn">
	<div class="titleBg">
		<h2>Bulk Order</h2>
	</div>
	<input type="hidden" value="Laboratory (35)" id="deptName"
		name="deptName">
	<div class="Clear"></div>
	<form action="" method="post" name="bulkOrderRequisition"> 
		<div id="investigationOrderBookingId">

			<div class="clear"></div>
			<div class="clear"></div>
			<div class="Block" id="testDetailDiv">
				<label>Institute</label> <input type="text"></input> 
				<label> Date</label> <input type="text" class="date" id="fromDateId"
					name="<%=DATE%>" value="<%=currentDate%>" readonly="readonly"
					MAXLENGTH="30" /> 
				
				<label><span></span>Remarks</label>
				<textarea rows="10" cols="25" class="textareaMediua" name="<%=RequestConstants.REMARKS%>"></textarea>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
			<div class="clear"></div> 
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="clear"></div>
			<div id="testDetailtable">
				<input type="button" tabindex="1" onclick="addRow('chargeDetails');"
					class="buttonAdd" value="" name="add" style="float: right;"><input
					type="button"
					onclick="removeRow('chargeDetails','selectedChrage');"
					class="buttonDel" value="" name="delete" style="float: right;">
				<div class="clear"></div>
				<div class="tableHolderAuto">
					<table width="100%" cellspacing="0" cellpadding="0" border="0"
						id="chargeDetails">
						<tbody>
							<tr>
								<th scope="col"></th>
								<!-- <th scope="col">Test Code</th> -->
								<th scope="col">Test Name</th>
								<th scope="col">Qty</th>
								<th scope="col">Rate</th>
								<th scope="col">Amount</th>
								<th scope="col">Clinical Note</th>
							</tr>

							<%
										int inc = 1;
										%>
							<tr>
								<td><input type="checkbox" class="radioCheck"
									name="selectedChrage" value="<%=inc%>"></td>
								<td><input type="text" tabindex="1"
									onblur="if(validateChargeCodeForAutoComplete(this.value, '<%=inc %>')){submitProtoAjaxWithDivName('bulkOrderRequisition','/hms/hms/lab?method=fillChargeCode&rowVal=1&hin=0','rateVal');}"
									id="chargeCode<%=inc%>" name="chargeCode<%=inc%>" />
									<div class="autocomplete" style="display: none;" id="ac2update"></div>
									<script type="text/javascript" language="javascript"
										charset="utf-8"> 
			   										new Ajax.Autocompleter('chargeCode<%=inc%>','ac2update','opd?method=getInvestigationListForAutoComplete',{parameters:'requiredField=chargeCode<%=inc%>'}); 
													</script></td>
								<input type="hidden" value="" name="<%=CHARGE_CODE_ID%>"
									id="chargeCodeId<%=inc%>" />
								<input type="hidden" value="" name="<%=MAIN_CHARGECODE_ID%>"
									id="mainChargeId<%=inc%>" />
								<input type="hidden" value="" name="<%=SUB_CHARGECODE_ID%>"
									id="subCharegId<%=inc%>" />
								<input type="hidden" id="chargeName<%=inc%>"
									name="<%=CHARGE_NAME%>" value="" class="readonly" />
								<!-- <td></td> -->
								<td><input type="text" id="qty<%=inc%>"
									name="<%=QUANTITY%>" value="" readonly="readonly"
									validate="Qty,int,yes" MAXLENGTH="3"
									onblur="if(this.readOnly== false){validateQty(this.value,this.id);calculateAmt(<%=inc%>);totalCost();}" />
								</td>
								<td id="rateVal"><input type="text" value=""
									id="resrate<%=inc%>" name="<%=RATE%><%=inc%>"
									validate="Rate,float,no"
									onblur="calculateAmt(<%=inc%>);totalCost();"
									readonly="readonly" size="15" maxlength="12" /></td>
								<td><input type="text" id="amount<%=inc%>" value=""
									name="<%=AMOUNT%><%=inc%>" onblur="totalCost();"
									class="readonly" readonly="readonly" /></td>
								<!-- <td><input type="button" tabindex="1"
												onclick="addRow();" class="buttonAdd" value="" name="add"></td> -->
								<td><input id="clinicalNote" type="text"
									name="<%=CLINICAL_NOTE%><%=inc%>" tabindex="1" /></td>
							</tr>

							<input type="hidden" id="dgOrderhdId" name="dgOrderhdId"
								value="0">
						</tbody>
					</table>
					<input type="hidden" id="totalCostId" name="<%=TOTAL_AMOUNT%>"
						value="0" class="readOnly" readOnly /> <input type="hidden"
						id="hiddenValueCharge" name="hiddenValueCharge" value="<%=inc%>">
				</div>
			</div>
			<div class="clear"></div>
			<div class="clear"></div>
			<div id="patientDetailtable">
				<h4>Paitent Details</h4>
				<input type="button" tabindex="1"
					onclick="addRow('patientDetails');" class="buttonAdd" value=""
					name="add" style="float: right;"><input type="button"
					onclick="removeRow('patientDetails','selectedPatient');"
					class="buttonDel" value="" name="delete" style="float: right;">
				<div class="clear"></div>
				<table width="100%" cellspacing="0" cellpadding="0" border="0"
					id="patientDetails">
					<tbody>
						<tr>
							<th scope="col"></th>
							<%-- <th scope="col"><%=prop.getProperty("com.jkt.hms.registration_no")%></th> --%>
							<th scope="col">Name</th>
							<th scope="col">Age (In Year)</th>
							<th scope="col">Gender</th>
							<th scope="col">ID Type</th>
							<th scope="col">ID No</th>
							<th scope="col">Address</th>
							<th scope="col">Mobile No.</th>
						</tr>
						<%
							int sn = 1;
						%>
						<tr>
							<td><input type="checkbox" class="radioCheck"
								name="selectedPatient<%=sn%>" value="<%=sn%>"></td>
							<%-- <td><input type="text" name="<%=HIN_NO%><%=sn%>"
											tabindex="1"></td> --%>
							<td><input type="text" tabindex="1" onblur=""
								id="patientNameId<%=sn%>" name="patientName<%=sn%>"
								validate="Patient Name,string,yes" maxlength="20"></td>
							<td><input type="text" class="readonly"
								name="patientAge<%=sn%>" id="patientAgeId<%=sn%>" tabindex="1"></td>

							<td><select name="patientGender<%=sn%>"
								id="patientGenderId<%=sn%>" tabindex="1"
								validate="Paitent Gender,string,yes">
									<option value="0">Select</option>
									<option value="3">Male</option>
									<option value="2">Female</option>
							</select></td>
							<td><select name="idType<%=sn%>" id="idType<%=sn%>"
								tabindex="1" onChange="idMakeReadOnly(<%=sn%>)">
									<option value="0">No Id</option>
									<option value="ADHAR">Addhar No</option>
									<option value="DL">Driving Licience</option>
									<option value="VOTAR ID">Votar Id</option>
									<option value="PAN">PAN No</option>
							</select></td>
							<td><input type="text" name="idNo<%=sn%>" id="idNo<%=sn%>"
								tabindex="1" readonly="readonly"></td>
							<td><input type="text" name="address<%=sn%>"
								id="addressId<%=sn%>" tabindex="1"></td>
							<td><input type="text" name="mobileNo<%=sn%>"
								id="moileNoId<%=sn%>" tabindex="1" maxlength="10" validate="Mobile No,int,no"></td>
						</tr>

						<input type="hidden" id="dgOrderhdId" name="dgOrderhdId" value="0">
					</tbody>
				</table>
				<input type="hidden" id="hiddenPatientdetails"
					name="hiddenPatientdetails" value="<%=sn%>">
			</div>
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="paddFltRight110"></div>
			<div class="clear"></div>

			<div class="clear"></div>
			<input type="hidden" value="1" id="counter" name="counter">


			<div class="clear"></div>
			<div class="division"></div>
			<input type="button"
				onclick="if(checkTestRow()){submitFormToDisableSubmit1('bulkOrderRequisition','lab?method=submitOrderBookingFromBulkOrder');}"
				id="submitForDisable" value="Submit" class="button"> <input
				type="button" onclick="form.reset();resetAjaxValueForBilling();"
				value="Reset" class="buttonHighlight"> <input type="hidden"
				value="1" id="rr" name="rows"> <input type="button"
				align="right" onclick="history.go(-1);return false;" class="button"
				value="Back" alt="Back" src="images/phaseII/delete.gif" name="Back">
			<div class="clear"></div>
			<div class="division"></div>
			<div class="bottom">
				<label>Changed By</label> <label class="value"><%=userName%></label>
				<label>Changed Date</label> <label class="value"><%=currentDate%></label>
				<label>Changed Time</label> <label class="value"><%=time%></label>
			</div>
			<!--Bottom labels ends-->
			<div class="clear"></div>
			<div class="paddingTop40"></div>
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
</div>
