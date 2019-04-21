<%--
 * Copyright 2016 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * individualStudentDetails.jsp  
 * @author Kaushal Mishra 
 * Revision Date:      
 * Revision By: 
--%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.PhStudentHealthDetails"%>
<%@page import="jkt.hms.masters.business.MasSpecialityDeptGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script> 
<script type="text/javascript" language="javascript">

	<%

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String getDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(getDate.length()<2){
			getDate="0"+getDate;
		}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>
<%
Map<String,Object> map = new HashMap<String,Object>();
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");  
String time = (String)utilMap.get("currentTime");

if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

List<PhStudentHealthDetails> phStudHealthList= new ArrayList<PhStudentHealthDetails>();
if(map.get("phStudHealthList") != null){
	phStudHealthList =  (List<PhStudentHealthDetails>)map.get("phStudHealthList");
	
}

List<MasSpecialityDeptGroup> masForGorupParameter=new ArrayList<MasSpecialityDeptGroup>();
if(map.get("masForGorupParameter") != null){
masForGorupParameter = (List<MasSpecialityDeptGroup>)map.get("masForGorupParameter");
}

List<OpdSpecialityDetails> opdSpecialityDetails= new ArrayList<OpdSpecialityDetails>();
if(map.get("opdSpecialityDetails") != null){
	opdSpecialityDetails =  (List<OpdSpecialityDetails>)map.get("opdSpecialityDetails");
	
}
			if (phStudHealthList.size() > 0) {
				for (PhStudentHealthDetails pst : phStudHealthList) {
		%>

<h2>Preliminary Medical Screening</h2>

<div class="detailsDiv">
<div class="detailsDivLeft"><h4>Student  Details</h4></div>
<div class="detailsDivRight"><h4><a href="#" onclick="getBackPages();">Back</a></h4></div>
<div class="clear"></div>
</div>
<form method="post" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">
<label>UHID No. </label> 
<%if(pst.getStudent().getMembersurvey().getAadhaarNo() !=null){ %>
<input type="text" value="<%=pst.getStudent().getMembersurvey().getAadhaarNo()%>" readonly="readonly"></input>
<%}else{ %>
<input type="text" value="-"  readonly="readonly"></input>
<%} %>

<label>Gender </label>
<input  type="text" name="gender" readonly="readonly" value="<%=pst.getStudent().getMembersurvey().getGender().getAdministrativeSexName()!=null?pst.getStudent().getMembersurvey().getGender().getAdministrativeSexName():""%>" validate="Gender,string,yes" maxlength="49" tabindex=1 	onkeyup="validateStudent(this.value);" id="studentName"/>

<label>Guardian Name </label>
<%if(pst.getStudent().getGuardianName()!=null && !pst.getStudent().getGuardianName().equals("")){ %>
<input  type="text" name="gender" readonly="readonly" value="<%=pst.getStudent().getGuardianName()%>" validate="Guardian Name,string,no" maxlength="49" tabindex=1 	onkeyup="validateStudent(this.value);" id="studentName"/>
<%}else{ %>
<input  type="text" name="gender" readonly="readonly" value="-" validate="Guardian Name,string,no" maxlength="49" tabindex=1 	 id="studentName"/>
<%} %>
 
 <div class="clear"></div>
<label>Student Name </label>
<input  type="text" name="studentName" readonly="readonly" value="<%=pst.getStudent().getMembersurvey().getName()!=null?pst.getStudent().getMembersurvey().getName():""%>" validate="Student Name,string,yes" maxlength="49" tabindex=1 	onkeyup="validateStudent(this.value);" id="studentName"/>
<input type="hidden" id="studentId" value="<%=pst.getStudent().getId()!=null?pst.getStudent().getId():"" %>" >
<label>DOB</label>
<%if(pst.getStudent().getMembersurvey().getDateOfBirth()!=null){ %>
<input type="text" id="dobId" name="dob"	readonly="readonly" value="<%=HMSUtil.convertDateToStringWithoutTime(pst.getStudent().getMembersurvey().getDateOfBirth()) %>" class="date" >
 <%}else{ %>
 <input type="text" id="dobId" name="dob"	readonly="readonly" value="" class="date" >
 <%} %>
<div>
<label>Contact No.</label>
<input  type="text" readonly="readonly" value="<%=pst.getStudent().getMembersurvey().getContactNo()!=null?pst.getStudent().getMembersurvey().getContactNo():""%>"/>

</div>

   <div class="clear"></div>
<h4>General Measurements</h4>
   <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  class="sortable">  
  <tr><th>Pulse Rate</th>
  <td><input  tabindex="11" name="pulse" type="text" id="pulse"	validate="pulse,num,no" maxlength="3" value="<%=pst.getPulse()!=null?pst.getPulse():"" %>"  readonly="readonly"/></td>
  <th>Blood Pressure SBP</th>
  <td><input  tabindex="11" name="sbp" type="text" id="sbp"	validate="SBP,num,no" maxlength="3" value="<%=pst.getSbp()!=null?pst.getSbp():"" %>"  readonly="readonly" validate="SBP,int,no"/></td>
  <th>Weight</th>
  <td><input type="text"  id="weight" maxlength="3" class="allownumericwithoutdecimal"  value="<%=pst.getWeight()!=null?pst.getWeight():"" %>"  readonly="readonly" name="weight" validate="Weight,int,no"  /><span>Kg.</span></td>
  </tr>

  <tr><th>DBP</th>
  <td><input  tabindex="11" name="dbp" type="text" id="dbp"	validate="DBP,num,no" maxlength="3" value="<%=pst.getDbp()!=null?pst.getDbp():"" %>"  readonly="readonly" validate="DBP,int,no"/>  </td>
  <th>BMI</th>
  <td><input type="text" maxlength="3" class="allownumericwithoutdecimal" value="<%=pst.getBmi()!=null?pst.getBmi():"" %>"  readonly="readonly" name="bmi" id="bmi" validate="BMI,int,no" /></td>
  <th>Height</th>
  <td>  <input type="text" maxlength="3" class="allownumericwithoutdecimal" value="<%=pst.getHeight()!=null?pst.getHeight():"" %>"  readonly="readonly" id="height" validate="Height,int,no" name="height"/><span>Cms.</span>
  </td>
  </tr>
<tr>
<th>Age at Puberly</th>
<%if(pst.getStudent().getMembersurvey().getDateOfBirth()!=null){ %>
  <td><input type="text" maxlength="3" name="age" class="allownumericwithoutdecimal" value="<%=HMSUtil.calculateAgeByDOB(pst.getStudent().getMembersurvey().getDateOfBirth())%>" readonly="readonly" /><span>years</span></td>
  <%}else{ %>
  <td><input type="text" maxlength="3"  value="" readonly="readonly" /><span>years</span></td>
  <%} %>
  </tr>
  
</table>
 <div class="clear"></div>
      
<h4>Immunization Details</h4>
  	 
  <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  class="sortable">  
  <tr><th>Immunization</th>
  <th>Due Date</th>
  <th>Immunization Date</th>
  </tr>
  <tr>
  <th>BCG </th>
  <%if(pst.getBcgDueDate()!=null) {%>
  <td> <input	type="text" id="bcgDueDate" name="bcgDueDate" value="<%=HMSUtil.convertDateToStringWithoutTime(pst.getBcgDueDate()) %>" class="date" readonly="readonly" validate="Joining Date,date,no"	MAXLENGTH="30" />
  </td>
  <%}else{ %>
 <td> <input type="text"  value="" class="date" readonly="readonly"	MAXLENGTH="30" /></td>
 <%}%>
  <%if(pst.getBcgImmDate()!=null) {%>
  <td> <input	type="text" id="bcgImmDate" name="bcgImmDate" value="<%=HMSUtil.convertDateToStringWithoutTime(pst.getBcgImmDate())%>"	class="date" readonly="readonly" MAXLENGTH="30" /></td>
  <%}else{ %>
  <td> <input	type="text" id="bcgImmDate" name="bcgImmDate" value=""	class="date" readonly="readonly" MAXLENGTH="30" /></td>
  <%}%>
 </tr>
  
  <tr><th>OPV-O</th> 
   <%if(pst.getOpvODueDate()!=null) {%> 
  <td> <input type="text" id="opvODueDate" name="opvODueDate" value="<%=HMSUtil.convertDateToStringWithoutTime(pst.getOpvODueDate()) %>" class="date" readonly="readonly" /></td>
  <%}else{ %>
  <td> <input type="text" id="opvODueDate" name="opvODueDate" value=""	class="date" readonly="readonly" /></td>
  <%}%>
  <%if(pst.getOpvOImmDate()!=null) {%>
  <td> <input type="text" id="opvOImmDate" name="opvOImmDate" value="<%=HMSUtil.convertDateToStringWithoutTime(pst.getOpvOImmDate()) %>" class="date" readonly="readonly"  /></td>
  <%}else{ %>
   <td> <input type="text" id="opvOImmDate" name="opvOImmDate" value=""	class="date" readonly="readonly"  /></td>
    <%}%>
  </tr>
  
  <tr><th>Hepatities - BO</th>
  <%if(pst.getHepatitiesBoDueDate()!=null) {%>
  <td> <input type="text" id="hepatitiesBoDueDate" name="hepatitiesBoDueDate" value="<%=HMSUtil.convertDateToStringWithoutTime(pst.getHepatitiesBoDueDate()) %>" class="date" readonly="readonly"  /></td>
  <%}else{ %>
  <td> <input	type="text" id="hepatitiesBoDueDate" name="hepatitiesBoDueDate" value="" class="date" readonly="readonly"  /></td>
  <%}%>
  <%if(pst.getHepatitiesBoImmDate()!=null) {%>
  <td><input type="text" id="hepatitiesBoImmDate" name="hepatitiesBoImmDate" value="<%=HMSUtil.convertDateToStringWithoutTime(pst.getHepatitiesBoImmDate()) %>"	class="date" readonly="readonly"  /></td>
   <%}else{ %>
  <td><input type="text" id="hepatitiesBoImmDate" name="hepatitiesBoImmDate" value=""	class="date" readonly="readonly"  /></td>
  <%}%>
  </tr> 
  </table>
  <div class="clear"></div>
 <div class="clear"></div>
  <div class="clear"></div>
  <div class="clear"></div>	
  
  	
		<%
		if(opdSpecialityDetails.size()>0){%>
		
		 <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  class="sortable">
   <tr>
		
		<%	
		Set<Integer> set=new HashSet<Integer>();
		 
		if(masForGorupParameter.size()>0)
		{int i=0;
			for(MasSpecialityDeptGroup deptGroup: masForGorupParameter)
		{
		
		if(set.add(deptGroup.getSpGroup().getSpGroup().getId())){%>
	
    
        <th><%=deptGroup.getSpGroup().getSpGroup().getSpGroupName()%></th>

        <%  if(!deptGroup.getValueType().equalsIgnoreCase("Check Box") && !deptGroup.getValueType().equalsIgnoreCase("Radio Button")){%>
        <th>DETAILS REMARKS</th>
		<th>ACTION TAKEN</th>
		<%} else						 	
        if(deptGroup.getValueType().equalsIgnoreCase("Check Box")){%>
        <th>DETAILS</th>
		<%}} %>							
        </tr>
		<tr>
	    <% if(deptGroup.getSpGroup().getSpParameter().getStatus().equalsIgnoreCase("Y")) 
	    { %>
	    <td><%=deptGroup.getSpGroup().getSpParameter().getSpParameterName()!=null?deptGroup.getSpGroup().getSpParameter().getSpParameterName():""%></td>
		<%}
		if(deptGroup.getTextField()!=null)
		{
		if(deptGroup.getTextField().equalsIgnoreCase("t")  )
		{
		if(opdSpecialityDetails.get(i).getSpValues()!=null && !opdSpecialityDetails.get(i).getSpValues().equals("")){ 
  if(opdSpecialityDetails.get(i).getSpValues().equalsIgnoreCase("y")){
  %>
  <td><input  type="text"  readonly="readonly" value="Yes" /></td>
  <%}else{ %>
<td><input  type="text"  readonly="readonly" value="<%=opdSpecialityDetails.get(i).getSpValues()%>" /></td>
<%}}else{ %>
<td><input  type="text"  readonly="readonly" value="---" /></td>
<%}
			
}}%>
<td><%  if(!deptGroup.getValueType().equalsIgnoreCase("Check Box") && !deptGroup.getValueType().equalsIgnoreCase("Radio Button")){ %>

<input  type="text"  readonly="readonly" value="<%=opdSpecialityDetails.get(i).getActionTaken().getActionTakenName()!=null?opdSpecialityDetails.get(i).getActionTaken().getActionTakenName():""%>" />

<%
}if(deptGroup.getValueType().equalsIgnoreCase("Check Box") || deptGroup.getValueType().equalsIgnoreCase("Radio Button")){
  if(opdSpecialityDetails.get(i).getSpValues()!=null && !opdSpecialityDetails.get(i).getSpValues().equals("")){ 
  if(opdSpecialityDetails.get(i).getSpValues().equalsIgnoreCase("y")){
  %>
  <input  type="text"  readonly="readonly" value="Yes" />
  <%}else{ %>
<input  type="text"  readonly="readonly" value="<%=opdSpecialityDetails.get(i).getSpValues()%>" />
<%}}else{ %>
<input  type="text"  readonly="readonly" value="---" />
<%}}%>
		</td></tr>
		<%
		i++;
		}}%></table>
		<%}%>
	 
		<%-- <%}}%> --%>
 <div class="clear"></div>
      <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  class="sortable">
    <tr>
    <th>Does the child have any known allergy ?</th>
    <%if(pst.getAllergy()!=null && !pst.getAllergy().equals("")){ %>
    <td><input type="text"	 value="<%=pst.getAllergy() %>" maxlength="49" tabindex=1  readonly="readonly"/></td>
<%}else{ %>
<td><input type="text"	 value="" maxlength="49" tabindex=1  readonly="readonly"/></td>
<%} %>
</tr>
  	</table>
    <div class="clear"></div>
     <h4>Referral</h4>
 <table border="0" align="center" cellpadding="0" cellspacing="0" id="grid"  class="sortable">
   <tr>
    
    <th>District</th>
    <th>Hospital Type</th>
    <th>Hospital</th>
    </tr>
    <tr>
    <td><%=pst.getDistrict().getDistrictName()!=null?pst.getDistrict().getDistrictName():"" %></td>
    <td><%=pst.getHospitalType().getHospitalTypeName()!=null?pst.getHospitalType().getHospitalTypeName():""%></td>
    <td><%=pst.getHospital().getHospitalName()!=null?pst.getHospital().getHospitalName():"" %></td>
    </tr>
 </table>
 <%} }%>
</div>
</form>
  
<div class="clear"></div>

 <script language="javascript">

function getBackPages()
{
	
	if(document.getElementById('studentId').value!=null){
	var studentId=document.getElementById('studentId').value;
	window.location = "/hms/hms/pubHealth?method=getStudentAllDetailsById&studentId="+studentId;
    }
		}
</script>	
 