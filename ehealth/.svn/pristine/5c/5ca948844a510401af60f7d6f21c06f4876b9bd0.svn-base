
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
System.out.println("opdTemplateTreatmentList=="+opdTemplateTreatmentList.size());
String templateType = "";
if(map.get("templateType") != null){
	templateType = (String)map.get("templateType");
}
if(map.get("message") != null){
	 String  message = (String)map.get("message");
	   %>
	   <h4><span><%=message %></span></h4>
	 <%} %> 

<div class="Block">

<label><span>*</span> Type </label> 
<select name="templateType" validate="Template Type,string,yes"  onchange="searchTemplateParameter(this.value);"  tabindex=1 >
<%if(!templateType.equals("")){ 
	if(templateType.equalsIgnoreCase("Past History")){
%>
	<option value="0">Select</option>
	<option value="Present Complaint">Present Complaint</option>
	<option value="Past History" selected="selected">Past History</option>
	<option value="Personal History">Personal History</option>
	<option value="Medication History">Medication History</option>
	<option value="Family History">Family History</option>
	<option value="General Examination">General Examination</option>
	<option value="Systemic  Examination">Systemic  Examination</option>
<%}else if(templateType.equalsIgnoreCase("Family History")){ %>
	<option value="0">Select</option>
	<option value="Present Complaint">Present Complaint</option>
	<option value="Past History">Past History</option>
	<option value="Personal History">Personal History</option>
	<option value="Medication History">Medication History</option>
	<option value="Family History" selected="selected">Family History</option>
	<option value="General Examination">General Examination</option>
	<option value="Systemic  Examination">Systemic  Examination</option>
<%}else if(templateType.equalsIgnoreCase("General Examination")){ %>
	<option value="0">Select</option>
	<option value="Present Complaint">Present Complaint</option>
	<option value="Past History">Past History</option>
	<option value="Personal History">Personal History</option>
	<option value="Medication History">Medication History</option>
	<option value="Family History">Family History</option>
	<option value="General Examination" selected="selected">General Examination</option>
	<option value="Systemic  Examination">Systemic  Examination</option>
<%}else if(templateType.equalsIgnoreCase("Systemic  Examination")){ %>
	<option value="0">Select</option>
	<option value="Present Complaint">Present Complaint</option>
	<option value="Past History">Past History</option>
	<option value="Personal History">Personal History</option>
	<option value="Medication History">Medication History</option>
	<option value="Family History">Family History</option>
	<option value="General Examination">General Examination</option>
	<option value="Systemic  Examination" selected="selected">Systemic  Examination</option>
<%}else if(templateType.equalsIgnoreCase("Personal History")){ %>
	<option value="0">Select</option>
	<option value="Present Complaint">Present Complaint</option>
	<option value="Past History">Past History</option>
	<option value="Personal History" selected="selected">Personal History</option>
	<option value="Medication History">Medication History</option>
	<option value="Family History">Family History</option>
	<option value="General Examination">General Examination</option>
	<option value="Systemic  Examination">Systemic  Examination</option>
<%}else if(templateType.equalsIgnoreCase("Medication History")){ %>
	<option value="0">Select</option>
	<option value="Present Complaint">Present Complaint</option>
	<option value="Past History">Past History</option>
	<option value="Personal History">Personal History</option>
	<option value="Medication History" selected="selected">Medication History</option>
	<option value="Family History">Family History</option>
	<option value="General Examination">General Examination</option>
	<option value="Systemic  Examination">Systemic  Examination</option>
	
	<%}else if(templateType.equalsIgnoreCase("Present Complaint")){ %>
	<option value="0">Select</option>
	<option value="Present Complaint" selected="selected">Present Complaint</option>
	<option value="Past History">Past History</option>
	<option value="Personal History">Personal History</option>
	<option value="Medication History">Medication History</option>
	<option value="Family History">Family History</option>
	<option value="General Examination">General Examination</option>
	<option value="Systemic  Examination">Systemic  Examination</option>
	
<%}}else{ %>
	<option value="0">Select</option>
	<option value="Present Complaint">Present Complaint</option>
	<option value="Past History">Past History</option>
	<option value="Personal History">Personal History</option>
	<option value="Medication History">Medication History</option>
	<option value="Family History">Family History</option>
	<option value="General Examination">General Examination</option>
	<option value="Systemic  Examination">Systemic  Examination</option>
	<%} %>
</select>

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
		<td><input type="checkbox" size="2" value="<%=i%>" name="<%=SR_NO+i%>" id="srNoId<%=i %>" class="readOnly"  />
		<input type="hidden" size="2"  name="opdTemplateTreatmentId<%=i %>" id="opdTemplateTreatment<%=i %>" value="<%=opdTemplateTreatment.getId() %>" class="readOnly"  />
		
		</td>
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
		<td><input type="text" size="45" tabindex=1 value="" validate="Parameter,string,no" maxlength="100" name="examinationParameter<%=i%>" id="examinationParameter<%=i%>"  /></td>
		</tr>
		<%} %>
		</table>


<input	type="hidden" name="hdb" id="hdb"	value="<%=i %>"  />





