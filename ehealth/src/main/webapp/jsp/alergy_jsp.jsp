
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.OpdPatientAllergyT"%>
<%@page import="jkt.hms.masters.business.OpdPatientAllergyM"%>
<%@page import="jkt.hms.masters.business.MasSeverityCode"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasAllergyProduct"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
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

<%
	Map<String, Object> map = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String) utilMap.get("currentTime");
	
	Inpatient inpatient=(Inpatient)map.get("inpatient");
	
	List<MasAllergyProduct> allergyProductsList = new ArrayList<MasAllergyProduct>();
	List<MasSeverityCode> saverityCodesList = new ArrayList<MasSeverityCode>();
	
	if(map.get("allergyProductsList") != null){
		allergyProductsList=(List)map.get("allergyProductsList");
	}
	
	if(map.get("saverityCodesList") != null){
		saverityCodesList=(List)map.get("saverityCodesList");
	} 
	
	
	List<OpdPatientAllergyM>  ipdOpdPatientAllergyMList = new ArrayList<OpdPatientAllergyM>();
	 if(map.get("ipdOpdPatientAllergyMList") != null){
		 ipdOpdPatientAllergyMList=(List<OpdPatientAllergyM>)map.get("ipdOpdPatientAllergyMList");
		}
	 session.setAttribute("inpatient",inpatient);	%>


	 <div class="titleBg"><h2>Allergy</h2></div>
	<form name="patientAllergy" method="post">
	
	

	
<input name="hinId" type="hidden"	value="<%=inpatient.getHin().getId()%>" validate="hinId,int,no" />
<input name="inpatientId" type="hidden"	value="<%=inpatient.getId()%>" validate="inpatientId,int,no"/>
<input name="adNo" type="hidden"	value="<%=inpatient.getAdNo()%>" validate="adNo,metachar,no"/>
<input name="hinNo" type="hidden"	value="<%=inpatient.getHin().getHinNo()%>" validate="hinNo,metachar,no" />

<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<div class="clear" ></div>
	<h4>Patient Details</h4>
	<div class="clear"></div>
	<div class="clear paddingTop15"></div>
<%@include file="PatientDetails.jsp" %>

<div class="clear"></div>
<span style="color: black;float: left;">No Known Allergy<input type="checkbox" class="radioCheck" style="float: none;margin: 10px 0px 0px 14px;padding: 0;" /> </span>
<div class="clear"></div>
<div style="float:right;">
<input	type="button" class="buttonAdd" alt="Add" tabindex="4" value="&nbsp;" onclick="addRowForAllergy();" align="right" />
<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;"	onclick="removeRowForAllergy();" align="right" />
</div>
<div class="clear"></div>
<div class="cmnTable">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="alergyGrid">
	<tr>
		<th scope="col">&nbsp;</th>
		<th scope="col">Type</th>
		<th scope="col">Allergen</th>
		<th scope="col">Severity</th>
		<th scope="col">Since:Month</th>
		<th scope="col">Year</th>
		<th scope="col">Status</th>
	</tr>
	<tr>
	<td><input  type="checkbox" class="radioCheck" name="allergyRadio1" id="allergyRadio1" /></td>	
	<td><select name="allergyType1" id="allergyType1" tabindex="1">
		<option value="0">Select</option>
		<%for(MasAllergyProduct msap:allergyProductsList){%>
			<option value="<%=msap.getId()%>"><%=msap.getProductName()%></option>
		<%} %>
		</select>
	</td>
	<td><input size="20" type="text" name="allergyName1" id="allergyName1" maxlength="32"  /></td>
	<td><select name="allergyseverity1" id="allergyseverity1" class="smallest" onchange="" tabindex="1">
		<option value="0">Select</option>
		<%for(MasSeverityCode mssc:saverityCodesList){%>
			<option value="<%=mssc.getId()%>"><%=mssc.getSeverityName()%></option>
		<%} %>
		</select>
	</td>
	<td><select class="smallest" name="allergymonth1" id="allergymonth1" type="text">
	    <option value="1">January</option>
		<option value="2">February</option>
		<option value="3">March</option>
		<option value="4">April</option>
		<option value="5">May</option>
		<option value="6">June</option>
		<option value="7">July</option>
		<option value="8">August</option>
		<option value="9">September</option>
		<option value="10">October</option>
		<option value="11">November</option>
		<option value="12">December</option>
	</select>
	</td>
	<td><input size="20" name="allergyyear1" id="allergyyear1"   type="text" maxlength="2" placeholder="YY" onkeypress="return isNumber(event)"/></td>
	<td><select name="allergystatus1" id="allergystatus1" class="smallest" tabindex="1">
		<option value="0">Select</option>
		<option value="1">Active</option>
		<option value="2">Inactive</option>
		</select>
	</td>
	</tr>
</table>
</div>
<input type="hidden" name="allergyCount" id="allergyCount" value="1" />
<!-- <div style="float: right;">
<label>Page</label>
<select class="small" name="templateId" id="templateId" onchange="showHideDrugTemplateCombo(this.value);" tabindex="1">
<option value="0">Select</option>
</select>

<div class="clear"></div>
</div> -->


<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="paddingTop15"></div>
<%if(ipdOpdPatientAllergyMList.size()>0)
	{%>
	<div class="cmnTable">
	<table border="0" align="center" cellpadding="0" cellspacing="0" id="alergyGrid">
		<tr>
			<th scope="col">Type</th>
			<th scope="col">Allergen</th>
			<th scope="col">Severity</th>
			<th scope="col">Since:Month</th>
			<th scope="col">Year</th>
			<th scope="col">Status</th>
		</tr>
	<%
	for(OpdPatientAllergyM allergyM:ipdOpdPatientAllergyMList)
	{
		
	for(OpdPatientAllergyT allergyT:allergyM.getOpdPatientAllergyTs())
	{%>
		
		<tr>
		<td>
		<%=allergyT.getAllergy().getProductName() %>
		</td>
		<td><%=allergyT.getAllergen() %></td>
		<td><%=allergyT.getSeverity().getSeverityName() %>
		</td>
		<td><%=allergyT.getFromMonth() %></td>
		<td><%=allergyT.getFromYear() %></td>
		<td>
		<%
		if(allergyT.getStatus()!=null && allergyT.getStatus().equals("1"))
		{
			%>
			Active
			<%
		}
		else if(allergyT.getStatus()!=null && allergyT.getStatus().equals("2"))
		{
			%>
			InActive
			<%
		}
		%>
		</td>
		</tr>
	<%}
	}
	%>
		</table>
		</div>
	<%
	}%>
	
<div class="clear"></div>

 
<div class="clear paddingTop25"></div>
<div class="clear paddingTop15"></div>
<div class="clear"></div>


<div class="clear"></div>


<input type="button" name="Submit" id="addbutton" value="Submit" class="button" onClick="submitPatientAllergy()"
	accesskey="a" />
	
	<input type="reset" class="button" value="Reset" align="left" onclick="submitFormForButton('patientAllergy','ipd?method=showAlergyJsp');"	 />
<input type="reset" class="button" name="reset" value="Back" onclick="submitFormForButton('patientAllergy','ipd?method=showPatientListJsp');"/>
	<div class="clear"></div>

 
<div class="clear paddingTop15"></div>
<div class="clear paddingTop15"></div>
<div class="clear"></div>
	
	</div>
	<div class="clear"></div>
 
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
	
	
	
	 <script type="text/javascript">	var	allergyTypeArray= new Array();
                      <%
				         for (int k = 0; k < allergyProductsList.size(); k++) {
				        	 MasAllergyProduct  masAllergyProduct = (MasAllergyProduct) allergyProductsList.get(k);
	     			 %> 
	     			allergyTypeArray[<%=k%>]= new Array();
	     			allergyTypeArray[<%=k%>][0] = "<%=masAllergyProduct.getId()%>";
	     			allergyTypeArray[<%=k%>][1] = "<%=masAllergyProduct.getProductName()%>";
	             <% }%>
	             </script>
	             <script type="text/javascript">	var	saverityCodeArray= new Array();
	            
	            <%
				         for (int k = 0; k < saverityCodesList.size(); k++) {
				        	 MasSeverityCode  masSeverityCode = (MasSeverityCode) saverityCodesList.get(k);
	     			 %> 
	     			saverityCodeArray[<%=k%>]= new Array();
	     			saverityCodeArray[<%=k%>][0] = "<%=masSeverityCode.getId()%>";
	     			saverityCodeArray[<%=k%>][1] = "<%=masSeverityCode.getSeverityName()%>";
	             <% }%>
	             </script>
	             
	<script type="text/javascript">
	
	function addRowForAllergy(){
		var tbl = document.getElementById('alergyGrid');
		var lastRow = tbl.rows.length;
		// if there's no header row in the table, then iteration = lastRow + 1
		var iteration = lastRow;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('allergyCount');
		iteration = parseInt(hdb.value)+1;
		hdb.value=iteration;

		var cellRight1 = row.insertCell(0);
		var e1 = document.createElement('input');
		e1.type = 'checkbox';
		e1.name='allergyRadio'+iteration;
		e1.id='allergyRadio'+iteration;
		e1.className='radioCheck';
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(1);
		var e1 = document.createElement('Select');
		e1.name='allergyType'+iteration;
		e1.id='allergyType'+iteration;
		e1.options[0] = new Option('Select', '0');
		  for(var i = 0;i<allergyTypeArray.length;i++ ){
		e1.options[allergyTypeArray[i][0]] = new Option(allergyTypeArray[i][1],allergyTypeArray[i][0]);
		} 
		cellRight1.appendChild(e1);

		var cellRight1 = row.insertCell(2);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='allergyName'+iteration;
		e1.id='allergyName'+iteration;
		e1.size='20'
		e1.maxLength=32;
		/* e1.onblur=function(){
		populatebrand(this.value, iteration);
		checkItem(iteration);
		}; */
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(3);
		var e1 = document.createElement('Select');
		e1.name='allergyseverity'+iteration;
		e1.id='allergyseverity'+iteration;
		e1.className='smallest';
		e1.options[0] = new Option('Select', '0');
		  for(var i = 0;i<saverityCodeArray.length;i++ ){
		e1.options[saverityCodeArray[i][0]] = new Option(saverityCodeArray[i][1],saverityCodeArray[i][0]);
		} 
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(4);
		var e1 = document.createElement('Select');
		e1.name='allergymonth'+iteration;
		e1.id='allergymonth'+iteration;
		e1.className='smallest';
		e1.options[0] = new Option('January','1');
		e1.options[1] = new Option('Febraury','2');
		e1.options[2] = new Option('March','3');
		e1.options[3] = new Option('April','4');
		e1.options[4] = new Option('May','5');
		e1.options[5] = new Option('June','6');
		e1.options[6] = new Option('July','7');
		e1.options[7] = new Option('August','8');
		e1.options[8] = new Option('Septembet','9');
		e1.options[9] = new Option('October', '10');
		e1.options[10] = new Option('Novamber','11');
		e1.options[11] = new Option('December','12');
		/* e1.onblur=function(){
		populatebrand(this.value, iteration);
		checkItem(iteration);
		}; */
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(5);
		var e1 = document.createElement('input');
		e1.type = 'text';
		e1.name='allergyyear'+iteration;
		e1.id='allergyyear'+iteration;
		e1.size='20'
			e1.maxLength='2';
            e1.placeholder='YY';
		e1.onkeypress=function(){
		
		return isNumber(event);
		}; 
		cellRight1.appendChild(e1);
		
		var cellRight1 = row.insertCell(6);
		var e1 = document.createElement('Select');
		e1.name='allergystatus'+iteration;
		e1.id='allergystatus'+iteration;
		e1.className='smallest';
		e1.options[0] = new Option('Select', '0');
		e1.options[1] = new Option('Active', '1');
		e1.options[2] = new Option('Inactive', '2');
		cellRight1.appendChild(e1);
		}
	
	
	function removeRowForAllergy()
	{
	  var tbl = document.getElementById('alergyGrid');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('allergyCount');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("allergyRadio"+i)!=null && (typeof  document.getElementById("allergyRadio"+i).checked)!='undefined' && document.getElementById("allergyRadio"+i).checked )
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
	    		  if(document.getElementById("allergyRadio"+i)!=null && (typeof  document.getElementById("allergyRadio"+i).checked)!='undefined' && document.getElementById("allergyRadio"+i).checked )
	    		  {
	    		  var deleteRow= document.getElementById("allergyRadio"+i).parentNode.parentNode;
	    		  document.getElementById("allergyRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	  }
	}
	
	
		function submitPatientAllergy() {
			checkValidationForAlergy();
			var count = document.getElementById('allergyCount').value;
			var dataCount=0;
			for (var i = 1; i <= count; i++) {
				if (document.getElementById("allergyName" + i) != null
						&& document.getElementById("allergyName" + i).value != '') {
					dataCount++;
				}
			}
			
			if(dataCount==0)
				{
				alert('Please fill atleast one row.');
				return;
				}
			submitForm('patientAllergy', 'ipd?method=submitAlergyJsp');
		}

		function checkValidationForAlergy() {
			var count = document.getElementById('allergyCount').value;
			for (var i = 1; i <= count; i++) {
				if (document.getElementById("allergyName" + i) != null
						&& document.getElementById("allergyName" + i).value != '') {
					document.getElementById("allergyType" + i).setAttribute(
							"validate", "Allergy Type,string,yes");
					document.getElementById("allergyName" + i).setAttribute(
							"validate", "Allergen,string,yes");
					document.getElementById("allergyseverity" + i)
							.setAttribute("validate", "Allergy,string,yes");
					document.getElementById("allergymonth" + i).setAttribute(
							"validate", "Allergy Month,string,yes");
					document.getElementById("allergyyear" + i).setAttribute(
							"validate", "Allergy Year,string,yes");
					document.getElementById("allergystatus" + i).setAttribute(
							"validate", "Allergy Status,string,yes");
				}
			}
		}
		function isNumber(evt) {
		    evt = (evt) ? evt : window.event;
		    var charCode = (evt.which) ? evt.which : evt.keyCode;
		    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
		    	alert("Enter Numeric Value Only");
		        return false;
		    }
		    return true;
		}
	</script>
	