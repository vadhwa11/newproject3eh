<%@page import="jkt.hms.masters.business.IpdInvestigationMonitoring"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>

<script type="text/javascript" language="javascript"  src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
Map map = new HashMap();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<Object[]> invList = new ArrayList<Object[]>();
if(map.get("invList")!=null){
	invList = (List<Object[]>)map.get("invList");
}
List<IpdInvestigationMonitoring> invMontList = new ArrayList<IpdInvestigationMonitoring>();
if(map.get("invMontList")!=null){
	invMontList = (List<IpdInvestigationMonitoring>)map.get("invMontList");
}
Inpatient inpatient =(Inpatient)map.get("inpatient");
String uhid="";
String patientName="";
String gender="";
String meritalStatus="";
String age="";
String patientCategory="";
String departmentName="";
if(inpatient!=null){
	Patient patient=inpatient.getHin();
	uhid=inpatient.getHinNo();	
	if(patient.getPFirstName()!=null)
		patientName=patient.getPFirstName();
	if(patient.getPMiddleName()!=null)
		patientName=patient.getPMiddleName()+" "+patientName;
	if(patient.getPLastName()!=null)
		patientName=patient.getPLastName()+" "+patientName;
	if(patient.getSex()!=null)
		gender=patient.getSex().getAdministrativeSexName();
	if(patient.getMaritalStatus()!=null)
	meritalStatus=patient.getMaritalStatus().getMaritalStatusName();
	age=patient.getAge();
	session.setAttribute("inpatient",inpatient);
}

%>
<div class="titleBg"><h2>Monitor Investigation</h2></div>

<h4>Patient Details</h4>
<div class="clear"></div>
<%@include file="PatientDetails.jsp" %>
<form name="monitorInvestigation" method="post" action="">
<input name="inpatientId" type="hidden"	value="<%=inpatient.getId()%>" />
<div class="clear"></div>
<div class="clear"></div>
<div  class="floatRight" style="margin-right: 10px;">
<input type="button" class="buttonDel"  alt="Delete" value="&nbsp;"	onclick="removeRowForInvestigation();"  />
<input	type="button" class="buttonAdd" alt="Add"  value="&nbsp;" onclick="addRowForInvestigation();"  />
</div>
<table  id="investigationGrid">
<tr>
<th></th>
	<th>Investigation Name</th>
	</tr>
	
	<% int inc=0; %>
		<% if(invMontList.size()>0){
			for(IpdInvestigationMonitoring invMon : invMontList) {
				inc++;
			%>
		
	<tr>
	<td><input type="hidden" value="<%=invMon.getId()%>" name="invMonId<%=inc %>" id="invMonId<%=inc %>" />
	<input type="checkbox"  class="radioCheck" name="chargeRadio<%=inc %>" id="chargeRadio<%=inc %>"  /></td>
	<td>
	<input type="text"  value="<%=invMon.getChargeCode().getChargeCodeName()+"["+invMon.getChargeCode().getId()+"]" %>" id="chargeCodeName<%=inc %>" size="65" name="chargeCodeName<%=inc %>" />
		
		
	</td>
	</tr>
	<%}
		}else{inc++; %>
	<tr>
	<td><input type="checkbox"  class="radioCheck" name="chargeRadio<%=inc %>" id="chargeRadio<%=inc %>" /></td>
	<td>
<input    type="text" class="textYellow largTextBoxOpd popper" data-popbox="pop1" value="" id="chargeCodeName<%=inc %>" size="65" name="chargeCodeName<%=inc %>" 
			 onblur="validateInvestigationAutoComplete(this.value,<%=inc%>);"/>
		
		<div id="ac2update<%=inc %>" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
				  new Ajax.Autocompleter('chargeCodeName<%=inc %>','ac2update<%=inc %>','opd?method=getInvestigationListForAutoComplete',{minChars:3,parameters:'requiredField=chargeCodeName<%=inc %>'});
		</script>
	</td>
	</tr>
	<%} %>
	<%-- <%
		for(Object[] obj : invList){
	%>
	<tr>
		<td><%=obj[1] %></td>
		<td><input type="checkbox" name="chargeCodeId" value="<%=obj[0]%>"/></td>
	</tr>
	<%} %> --%>
</table>
<input type="hidden"  name="hiddenValue" id="hiddenValue" value="<%=inc%>"/>
<div class="clear"></div>
<input type="button"	name="sss" class="button" value="Submit" onclick="submitForm('monitorInvestigation','ipd?method=submitInvestigationMonitoring')" style="margin-left:5px;" />
<input type="button" class="button" value="Back" onClick="submitForm('monitorInvestigation','ipd?method=showPatientListJsp');" />
<input type="reset" name="reset" value="Reset" class="button"/>	
<script>

function validateInvestigationAutoComplete(strValue,inc ) {

		var index1 = strValue.lastIndexOf("[");
    var index2 = strValue.lastIndexOf("]");
    index1++;
    var id = strValue.substring(index1,index2);
    var count=document.getElementById('hiddenValue').value;
    
    if(id =="")
    {		
    		document.getElementById('chargeCodeName'+inc).value="";
				return ;
		}
    
    for(var i=0;i<=count;i++)
	{
	if(document.getElementById('chargeCodeName'+i)!=null && document.getElementById('chargeCodeName'+i).value==strValue  && i!=inc)
		{
		alert('This Investigation is already selected.');
		document.getElementById('chargeCodeName'+inc).value="";
		return false;
		}
	}
		return true;
}

function addRowForInvestigation(){

	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  iteration = parseInt(hdb.value)+1;
	  hdb.value=iteration;

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'checkbox';
	  e0.name='chargeRadio'+iteration;
	  e0.id='chargeRadio'+iteration;
	  e0.className='radioCheck';
	  cellRight0.appendChild(e0);  	  
	  
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name = 'chargeCodeName' + iteration;
	  e1.id = 'chargeCodeName' + iteration;
	  e1.onblur=function(){validateInvestigationAutoComplete(this.value,iteration);};
	  e1.size = '65';
	  e1.className = "textYellow nomeclatureOpdgridText";
	  cellRight1.appendChild(e1);

	  var updatediv = document.createElement('div');
	  updatediv.setAttribute('id', 'ac2update'+iteration);
	  updatediv.style.display = 'none';
	  updatediv.className = "autocomplete";
	  cellRight1.appendChild(updatediv);

	  new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update'+iteration,'opd?method=getInvestigationListForAutoComplete',
			  {minChars:3, parameters:'requiredField=chargeCodeName'+iteration+''});

}

function removeRowForInvestigation ()
{
  var tbl = document.getElementById('investigationGrid');
  var lastRow = tbl.rows.length;
  var hdb = document.getElementById('hiddenValue');
  var iteration = parseInt(hdb.value);
  var totalSelected=0;
  if(confirm("Do you want to delete !")){
			  for(var i=1;i<=iteration;i++)
			  {
			  if(document.getElementById("chargeRadio"+i)!=null && (typeof  document.getElementById("chargeRadio"+i).checked)!='undefined' && document.getElementById("chargeRadio"+i).checked )
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
		    		  if(document.getElementById("chargeRadio"+i)!=null && (typeof  document.getElementById("chargeRadio"+i).checked)!='undefined' && document.getElementById("chargeRadio"+i).checked )
		    		  {
		    			 	  var deleteRow= document.getElementById("chargeRadio"+i).parentNode.parentNode;
			    		  document.getElementById("chargeRadio"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
		    		  }
		    	  }
		  }
  }
 
}
</script>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	

