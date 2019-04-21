<%@ page import="static jkt.hms.util.RequestConstants.HOSPITAL_STAFF"%>
<%@ page import="static jkt.hms.util.RequestConstants.TOKEN_NO"%>
<%@ page import="static jkt.hms.util.RequestConstants.DIAGNOSIS_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.CASE_TYPE_ID"%>
<%@ page import="static jkt.hms.util.RequestConstants.CONSULTING_DOCTOR"%>
<%@ page import="static jkt.hms.util.RequestConstants.PATIENT_DEPARTMENT"%>
<%@ page import="static jkt.hms.util.RequestConstants.COMPLAINT_ID"%>
<%@page import="jkt.hms.masters.business.MasComplaint"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasCaseType"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%
Map<String, Object> map = new HashMap<String, Object>();
List<MasComplaint> complaintList = new ArrayList<MasComplaint>();
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
List<Object[]> doctorList = new ArrayList<Object[]>();
List<MasCaseType> caseTypeList = new ArrayList<MasCaseType>();
List<MasDiagnosisConclusion> diagnosisList = new ArrayList<MasDiagnosisConclusion>();

if(request.getAttribute("map") != null)
{
	map=(Map<String, Object>)request.getAttribute("map");
}

if (map.get("complaintList") != null) 
{
	complaintList = (List<MasComplaint>) map.get("complaintList");
}
if (map.get("departmentList") != null) 
{
	departmentList = (List<MasDepartment>) map.get("departmentList");
}
if(map.get("doctorList") != null)
{
	doctorList = (List<Object[]>)map.get("doctorList");
}
if (map.get("caseTypeList") != null) 
{
	caseTypeList = (List<MasCaseType>) map.get("caseTypeList");
}
if (map.get("diagnosisList") != null) 
{
	diagnosisList = (List<MasDiagnosisConclusion>) map.get("diagnosisList");
}
%>

<label>Complaint</label> 
		<select id="compltId" name="<%=COMPLAINT_ID%>" validate="Complaint,string,no" tabindex="39">
		<option value="0">Select</option>
<%

		for(MasComplaint masComplaint : complaintList)
		{
%>
			<option value="<%=masComplaint.getId() %>"><%=masComplaint.getComplaintName() %></option>
<%
		}
%>
		</select> 
		
		<label><span>*</span> Department</label> 
		<select id="deptId" name="<%=PATIENT_DEPARTMENT %>" tabindex="40">
		<option value="0">Select</option>
<%
		int departmentId = 0;
		for(MasDepartment masDepartment : departmentList)
		{
%>
			<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
<%
		} 
%>

		</select> 

		<label><span>*</span> Consulting Doc.</label> 
		<select name="<%=CONSULTING_DOCTOR %>" id="consultingDocId" tabindex="41" title="Consulting Doctor & Total Current Visit">
		<option value="0">Select</option>
<%
		for(Object[] masEmployee : doctorList)
		{
			//if(masEmployee[29] != null)
			//{

%>
				<option value="<%=masEmployee[0] %>"><%=masEmployee[4]+" "+masEmployee[5] %></option>
<%
			//}
		}
%>
		</select>

		<div class="clear"></div>

		<label><span>*</span> Case Type</label> 
		<select name="<%=CASE_TYPE_ID %>" validate="Case Type,string,no" tabindex="42">
		<option value="0">Select</option>
<%
		for(MasCaseType masCaseType : caseTypeList)
		{
%>
			<option value="<%=masCaseType.getId() %>"><%=masCaseType.getCaseTypeName() %></option>
<%
		} 
%>
		</select> 
		
		<label>Diagnosis</label> 
		<select name="<%=DIAGNOSIS_ID %>" validate="Diagnosis,string,no" tabindex="43">
		<option value="0">Select</option>
<%
		for(MasDiagnosisConclusion masDiagnosisConclusion : diagnosisList)
		{
%>
			<option value="<%=masDiagnosisConclusion.getId() %>"><%=masDiagnosisConclusion.getDiagnosisConclusionName() %></option>
<%
		} 
%>
		</select>
		
		<label>Token No.</label> 
		
		<div id="testDiv">
			<input type="text" name="<%=TOKEN_NO %>" value="" validate="Token no.,int,no" maxlength="3" class="readOnly">
		</div>

		<div class="clear"></div>
		
		<input type="hidden" id="hospitalStaffId" name="<%=HOSPITAL_STAFF %>" value="y" tabindex="44" class="radioCheck">
<Script>
	document.getElementById("loadvIndicator").style.display="none";
	document.getElementById("loadVBlock").style.display="";
	document.getElementById("loadV").setAttribute("onfocus","");
	document.getElementById("loadV").removeAttribute("tabindex");
	document.getElementById("loadV").style.cursor="default";
	document.getElementById("compltId").focus();
</Script>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
