<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<!-- Script for tab content -->
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>
<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script>jQuery.noConflict();</script>
<script type="text/javascript">
var icdArray=new Array();
</script>
<%
		Map map = new HashMap();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		List<MasFrequency> frequencyList= new ArrayList<MasFrequency>();
		if(map.get("frequencyList") != null){
			frequencyList=(List)map.get("frequencyList");
		}
%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<form name="opnursingcareForm" method="post" action="">

<h4>Procedure Ordering</h4>
<div class="Block">


<label>UHID</label>
<input name="tokenNo" id="tokenNo" type="text" value=""	 tabindex="10"/>

<label>Patient Name</label>
<input name="patientName" id="patientName" type="text"	value="" tabindex="10"/>

<label>Doctor Name</label>
<input name="doctorName" id="doctorName" type="text"	value="" tabindex="10"/>

<div class="clear"></div>
<label>Visit Date</label>
<input name="visitDate" id="visitDate" type="text"	value="" tabindex="10"/>

<label>Mobile No</label>
<input name="mobilNo" id="mobilNo" type="text"	value="" tabindex="10"/>
<div class="clear"></div>


<div class="">
<input	type="button" class="buttonBig" alt="Add" tabindex="4" value="Doctor Detail"/>
	<div class="paddFltRight260 ">
	<input type="button" class="buttonDel" tabindex="3" alt="Delete" value="&nbsp;"	onclick="removeRow();" align="right" />
	<input	type="button" class="buttonAdd" alt="Add" tabindex="4" value="&nbsp;" onclick="addRow();" align="right" />
	</div>
</div>


<form action="procedureForm">
<div class="clear"></div>
<div class="" >
<div class="" style="width:900px;">
<div id="divTemplet" >

<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  >
	<tr>
		<th scope="col">&nbsp;</th>
		<th scope="col">Procedure Type</th>
		<th scope="col">Procedure Name</th>
		<th scope="col">Frequency</th>
		<th scope="col">No. Of Days</th>
		<th scope="col">Remark</th>
		<th scope="col">Alert Me</th>
	</tr>
	<%
		int incr = 1;
	%>
	<tr>
		<td><input type="checkbox" class="radioCheck" id="itemRadio1" name="itemRadio1"  tabindex="31"/></td>
		<td>
		<select name="proceduretype<%=incr%>"  id="proceduretype<%=incr%>">
			<option value="1" selected="selected">Minor</option>
			<option value="2">Major</option>
		</select>
		</td>
		<td>
			<input  type="text" class="small" id="procedureName<%=incr%>" size="35" name="procedureName<%=incr%>"/>
			<div id="ac2updates<%=incr%>"  class="autocomplete"></div> 
			<script type="text/javascript" language="javascript" charset="utf-8">
					  new Ajax.Autocompleter('procedureName<%=incr%>','ac2updates<%=incr%>','opd?method=getNursingCareProcedureAutoList',{minChars:3,
						  callback: function(element, entry) {
					            return entry + '&minor_major='+ document.getElementById('proceduretype<%=incr%>').value;
					        }, parameters:'requiredField=procedureName<%=incr%>'});
			</script>
		</td>
		<td><select style="width:90px;" name="frequency<%=incr%>" id="frequency<%=incr%>"   tabindex="36" >
			<option value="0">Select</option>
			 <%
				  MasFrequency  masFrequency = new MasFrequency();
			      for(MasFrequency masFrequency2 : frequencyList){
			       int id = masFrequency2.getId();
			       String name = masFrequency2.getFrequencyName();
	          %> 
			<option value="<%=id %>"><%=name%></option>
			<%} %> 
		</select>   <%
		    		MasFrequency  masFrequency3 = new MasFrequency();
				         for (int i = 0; i < frequencyList.size(); i++) {
				        	 masFrequency3 = (MasFrequency) frequencyList.get(i);
	     			 %>
	     		 <script>
		          icdArray[<%=i%>]= new Array();
		          icdArray[<%=i%>][0] = "<%=masFrequency3.getId()%>";
		          icdArray[<%=i%>][1] = "<%=masFrequency3.getFrequencyName()%>";
	            </script> <% }%>  
		</td>
		<td>
			<input type="text" name="noOfDays<%=incr%>"	id="noOfDays<%=incr%>" class="grdTextSmall" size="5" />
		</td>
		<td><input type="text" name="remark<%=incr%>" id="remark<%=incr%>" class="nomeclatureOpdgridText" /></td>
		<td><input class="radioCheck" type="checkbox" name="alert<%=incr %>"	name="alert<%=incr %>"/></td>
	</tr>
</table>
 <input type="hidden" name="hdb" value="<%=incr %>" id="hdb" />
</div>
</div>
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="" >
<input	type="button" class="buttonBig" alt="Add" tabindex="4" value="Submit" onclick="submitForm('opnursingcareForm','opd?method=submitProcedureOrder');" align="right" />
<input type="button" class="buttonBig" tabindex="3" alt="Delete" value="Reset" align="right" />
</div>
</div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
<script type="text/javascript">
function clearField(incr){
		document.getElementById('procedureName'+incr).value="";
}
function addRowTreatment(){

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
	  var e1 = document.createElement('Select');
	  e1.name='proceduretype'+iteration;
	  e1.id='proceduretype'+iteration;
	  e1.options[0] = new Option('Minor', '1'); 
	  e1.options[1] = new Option('Major', '2'); 
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(2);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='procedureName'+iteration;
	  e1.id='procedureName'+iteration;
	  e1.className="small";
	  e1.size='35';
	  
	  cellRight1.appendChild(e1);
	  var newdiv = document.createElement('div');
	  newdiv.setAttribute('id', 'ac2updates'+iteration);
	  newdiv.style.display = 'none';
	  newdiv.className = "autocomplete";
	  cellRight1.appendChild(newdiv);
	  new Ajax.Autocompleter('procedureName'+iteration,'ac2updates'+iteration,'opd?method=getNursingCareProcedureAutoList',{minChars:3,
		  callback: function(element, entry) {
	            return entry + '&minor_major='+ document.getElementById('proceduretype'+iteration).value;
	        }, parameters:'requiredField=procedureName'+iteration});
      
	  var cellRight1 = row.insertCell(3);
	  var e1 = document.createElement('Select');
	  e1.name='frequency'+iteration;
	  e1.id='frequency'+iteration;
	  e1.style.width = "90px";
	  e1.options[0] = new Option('Select', '0'); 
	   for(var i = 0;i<icdArray.length;i++ ){
	      e1.options[icdArray[i][0]] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(4);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='noOfDays'+iteration;
	  e1.className="grdTextSmall";
	  e1.id='noOfDays'+iteration;
	  e1.size='3';
	  cellRight1.appendChild(e1);
	  
	  var cellRight1 = row.insertCell(5);
	  var e1 = document.createElement('input');
	  e1.name='remark'+iteration;
	  e1.id='remark'+iteration;
	  e1.className="nomeclatureOpdgridText";
	  cellRight1.appendChild(e1);
	 
	  var cellRight1 = row.insertCell(6);
	  var e1 = document.createElement('input');
	  e1.type = 'checkbox';
	  e1.name='alert'+iteration;
	  e1.id='alert'+iteration;
	  e1.className="radioCheck";
	  e1.size='5';
	  cellRight1.appendChild(e1);
	}
		
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
</script>
