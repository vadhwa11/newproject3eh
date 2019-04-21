
<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * opdTemplate.jsp  
 * Purpose of the JSP -  This is for All OpdTemplate Master.
 * @author  Mansi
 * Create Date: 25 June,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.5
--%>
<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.util.User"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
<%@ page import="jkt.hms.masters.business.OpdTemplate"%>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
List<OpdTemplateTreatment>opdTemplateTreatmentList = new ArrayList<OpdTemplateTreatment>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
if(map.get("opdTemplateTreatmentList") != null){
	opdTemplateTreatmentList = (List)map.get("opdTemplateTreatmentList");
}
String templateType = "";
if(map.get("templateType") != null){
	templateType = (String)map.get("templateType");
}
if(map.get("message") != null){
	 String  message = (String)map.get("message");
	   %>
	   <h4><span><%=message %></span></h4>
	 <%} %> 
<div class="titleBg">
<h2>Opd Examination Template</h2>
</div>
<div class="clear"></div>

<form name="opdExaminationTemplate" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="testDiv">
<div class="Block">

<label><span>*</span> Type </label> 
<select name="templateType" validate="Template Type,string,yes" id="templateType"  onchange="searchTemplateParameter(this.value);"  tabindex=1 >
	<option value="0">Select</option>
	<option value="Present Complaint">Present Complaint</option>
	<option value="Past History">Past History</option>
	<option value="Personal History">Personal History</option>
	<option value="Medication History">Medication History</option>
	<option value="Family History">Family History</option>
	<option value="General Examination">General Examination</option>
	<option value="Systemic  Examination">Systemic  Examination</option>
	

</select>
<script>
<%
	if(!templateType.equals("")){
%>
	document.getElementById('templateType').value = '<%=templateType%>';


<%}%>
</script>

</div>
<input type="button" name="Add" type="submit" class="buttonAdd" value="" onClick="addRow();" />
   <input type="button" name="Delete" type="submit" class="buttonDel" value="" onClick="removeRow()" />
 
	<div class="cmntable">
			<table width="100%"  id="parameterDetails" >
				
					<tr>

						<th>S.No.</th>
						<th>Parameter</th>
						
						
						
					</tr>
					<%
					int i =1;
					if(opdTemplateTreatmentList.size()>0){
					for(OpdTemplateTreatment opdTemplateTreatment :opdTemplateTreatmentList){
					%>
		 <tr>
		<td><input type="checkbox" size="2" value="<%=i%>" name="<%=SR_NO%><%=i %>" id="srNoId<%=i %>" class="readOnly"  />
		<input type="hidden" size="2"  name="opdTemplateTreatmentId<%=i %>" id="opdTemplateTreatment<%=i %>" value="<%=opdTemplateTreatment.getId() %>" class="readOnly"  /></td>
		<%if(templateType.equalsIgnoreCase("Past History")){ %>
		<td><input type="text" size="35" tabindex=1 value="<%=opdTemplateTreatment.getPastIllnessHistory() %>" validate="Parameter,string,no" maxlength="100" name="examinationParameter<%=i%>" id="examinationParameter<%=i%>"  /></td>
		
		<%}else if(templateType.equalsIgnoreCase("Family History")){ %>
			<td><input type="text" size="35" tabindex=1 value="<%=opdTemplateTreatment.getFamilyHistory() %>" validate="Parameter,string,no" maxlength="100" name="examinationParameter<%=i%>" id="examinationParameter<%=i%>"  /></td>
		
		<%}else if(templateType.equalsIgnoreCase("General Examination")){ %>
			<td><input type="text" size="35" tabindex=1 value="<%=opdTemplateTreatment.getGeneralExamination() %>" validate="Parameter,string,no" maxlength="100" name="examinationParameter<%=i%>" id="examinationParameter<%=i%>"  /></td>
		
		<%}else if(templateType.equalsIgnoreCase("Systemic  Examination")){ %>
		<td><input type="text" size="35" tabindex=1 value="<%=opdTemplateTreatment.getSystemicExamination() %>" validate="Parameter,string,no" maxlength="100" name="examinationParameter<%=i%>" id="examinationParameter<%=i%>"  /></td>
	
		<%}else if(templateType.equalsIgnoreCase("Personal History")){ %>
			<td><input type="text" size="45" tabindex=1 value="<%=opdTemplateTreatment.getPersonalHistory() %>" validate="Parameter,string,no" maxlength="100" name="examinationParameter<%=i%>" id="examinationParameter<%=i%>"  /></td>
			
		<%}else if(templateType.equalsIgnoreCase("Medication History")){ %>
			<td><input type="text" size="45" tabindex=1 value="<%=opdTemplateTreatment.getMedicationHistory() %>" validate="Parameter,string,no" maxlength="100" name="examinationParameter<%=i%>" id="examinationParameter<%=i%>"  /></td>
		
		<%}else if(templateType.equalsIgnoreCase("Present Complaint")){ %>
			<td><input type="text" size="45" tabindex=1 value="<%=opdTemplateTreatment.getPresentComplaintHistory() %>" validate="Parameter,string,no" maxlength="100" name="examinationParameter<%=i%>" id="examinationParameter<%=i%>"  /></td>
		
		
		</tr>
		<%}i++;}}else{ %>
		
		<tr>
		<td><input type="checkbox" size="2" value="<%=i%>" name="<%=SR_NO+i%>" id="srNoId<%=i %>" class="readOnly" />
		<input type="hidden" size="2"  name="opdTemplateTreatmentId<%=i %>" id="opdTemplateTreatment<%=i %>" value="0" class="readOnly"  /></td>
		<td><input type="text" size="45" tabindex=1 value="" validate="Parameter,string,yes" maxlength="100" name="examinationParameter<%=i%>" id="examinationParameter<%=i%>"  /></td>
		</tr>
		<%} %> 
		</table>
<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>"  />

</div>

<div class="clear"></div></div>
<input	type="hidden" name="deletedIds" id="deletedIds"	value=""  />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Save" class="button" onClick="submitForm('opdExaminationTemplate','opdMaster?method=addOpdExaminationTemplate');" accesskey="a" tabindex=1 />
<!-- <input type="button" name="add" id="addbutton" value="Delete" class="button" onClick="submitForm('opdExaminationTemplate','opdMaster?method=updateOpdExaminationTemplate');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('opdTemplate','opdMaster?method=editOpdTemplate')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('opdTemplate','opdMaster?method=deleteOpdTemplate&flag='+this.value)" accesskey="d" tabindex=1 /> --> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>

<script>
 function removeRow() {
	var tbl = document.getElementById('parameterDetails');
	var lastRow = tbl.rows.length;
	var hdb = document.getElementById('hdb');
	var iteration = parseInt(hdb.value);
	var totalSelected = 0;
	if (confirm("Do you want to delete !")) {
		for (var i = 1; i <= iteration; i++) {

			if (document.getElementById("srNoId" + i) != null
					&& (typeof document.getElementById("srNoId" + i).checked) != 'undefined'
					&& document.getElementById("srNoId" + i).checked) {
				totalSelected = totalSelected + 1;
			}
		}
		if (totalSelected ==0) {
			alert('Please select atleast 1 row to delete');
		}
		var totalDeleteRow = new Array();
		var result = "";
		var idForDel = '';
		for (var i = 1; i <= iteration; i++) {
			if (document.getElementById("srNoId" + i) != null
					&& (typeof document.getElementById("srNoId" + i).checked) != 'undefined'
					&& document.getElementById("srNoId" + i).checked) {
					
				if(idForDel==''){
					idForDel = document.getElementById('opdTemplateTreatment'+i).value;
				}else{
					idForDel = idForDel +','+document.getElementById('opdTemplateTreatment'+i).value;
				}
				var deleteRow = document.getElementById("srNoId" + i).parentNode.parentNode;
			
				document.getElementById("srNoId" + i).parentNode.parentNode.parentNode.removeChild(deleteRow);
			
			}
		}
		document.getElementById('deletedIds').value = idForDel;
		
	}} 
	



function searchTemplateParameter(templateName){
	
	submitProtoAjax('opdExaminationTemplate','opdMaster?method=searchOpdExaminationTemplate&templateName='+templateName);
	
}
function addRow(){
	  var tbl = document.getElementById('parameterDetails');
	  var lastRow = tbl.rows.length;
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  var cellRight1 = row.insertCell(0);
	  var e0 = document.createElement('input');
	  e0.type = 'checkbox';
	  e0.setAttribute("readonly", "readonly");
	  e0.name='<%=SR_NO%>'+iteration;
	  e0.value =iteration
	  e0.id='srNoId'+iteration;
	  e0.size='3'
	 cellRight1.appendChild(e0);
	  
	  var e0 = document.createElement('input');
	  e0.type = 'hidden';
	  e0.setAttribute("readonly", "readonly");
	  e0.name='opdTemplateTreatment'+iteration;
	  e0.value =0
	  e0.id='opdTemplateTreatment'+iteration;
	  e0.size='3'
	 cellRight1.appendChild(e0);

	 var cellRight2 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.name='examinationParameter'+iteration;
	  e1.id='examinationParameter'+iteration;
	  e1.size='35'
	 cellRight2.appendChild(e1);
		 
	
	  
	}




</script>
