<%@page import="jkt.hms.masters.business.MortuaryRegisterDetails"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	
	List<MasEmployee>doctorList = new ArrayList<MasEmployee>();
	List<MasEmployee>employeeList = new ArrayList<MasEmployee>();
	List<MortuaryRegisterDetails> mortuaryDetails= new ArrayList<MortuaryRegisterDetails>();
	
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	if(map.get("doctorList") != null){
		doctorList =(List)map.get("doctorList");
	}
	if(map.get("employeeList") != null){
		employeeList =(List)map.get("employeeList");
	}
	if(map.get("mortuaryDetails") != null){
		mortuaryDetails =(List)map.get("mortuaryDetails");
	}
	
	String msg = "";
	if(map.get("msg") != null){
		msg = (String)map.get("msg");
	}
	int empId  = 0;	
%>	

<form name="postMortemExamination" method="post" action="">
<div class="titleBg">
<h2> POSTMORTEM EXAMINATION</h2>
</div>
<div class="Block">
<label><span>*</span> UHID</label> 
<input name="uhinId" id="uhinId" validate="UHID,string,yes" readonly="readonly" value="<%=(mortuaryDetails.size()>0 && mortuaryDetails.get(0).getPatientWiseMlc().getHin().getHinNo()!=null)?mortuaryDetails.get(0).getPatientWiseMlc().getHin().getHinNo():""%>">
<div class="clear"></div>
<div class="paddingTop5"></div>
<label>Name</label>
<input type="text"  readonly="readonly" id="pname" name="pname" value="<%=(mortuaryDetails.size()>0 && mortuaryDetails.get(0).getPatientWiseMlc().getHin().getFullName()!=null)?mortuaryDetails.get(0).getPatientWiseMlc().getHin().getFullName():"" %>"/>
	
<label>Age</label>
<input type="text"  id="age"  name="name" readonly="readonly" value="<%=(mortuaryDetails.size()>0 && mortuaryDetails.get(0).getPatientWiseMlc().getHin().getAge()!=null)?mortuaryDetails.get(0).getPatientWiseMlc().getHin().getAge():""%>"/>
    
<input type="hidden" name="mortuaryRegdDetailId" value="<%=(mortuaryDetails.size()>0 && mortuaryDetails.get(0).getId()!=null)?mortuaryDetails.get(0).getId():"" %>" />

<label>Gender</label>
<input type="text"  name="gender" id="gender" value="<%=(mortuaryDetails.size()>0 && mortuaryDetails.get(0).getPatientWiseMlc().getHin().getSex().getAdministrativeSexName()!=null)?mortuaryDetails.get(0).getPatientWiseMlc().getHin().getSex().getAdministrativeSexName():"" %>">

<div class="clear"></div>
<label>Crime No</label>
<input type="text"  name="crimeNo" id="crimeNo" value="" maxlength="128">

<label>Crime Date</label>
<input 	type="text" name="crimeDate" id="crimeDate" value="<%=currentDate%>" class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30" readonly="readonly" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.postMortemExamination.crimeDate,event);" />

<label>Police Station</label>
<input type="text"  name="policeStation" id="policeStation"  value="">

<div class="clear"></div>
<label>Requisition From</label>
<textarea  id="requisitionFrom" name="requisitionFrom" class="textareaMediua" maxlength="1024">  </textarea>

<label class="heightAuto">Alleged Cause of Death as Per Inquest</label>
<input type="text"  name="allegedDeathInquest" id="allegedDeathInquest" value="" maxlength="256">

<label class="heightAuto">Name & Designation of Medical Officer</label>
   <select name="medicalOfficer" id="medicalOfficer" validate="">
    <option value="0">Select</option>
    <%if(doctorList.size()>0){
    	for(MasEmployee masEmployee :doctorList){%>
  
    <option value="<%=masEmployee.getId()%>"><%=masEmployee.getEmployeeName() %></option>
    <%}} %>
	</select>
<div class="clear"></div>	
<label>Assisted By1</label>
   <select name="assistedBy1" id="assistedBy1" class=""  validate="">
    <option value="0">Select</option>
    <%if(employeeList.size()>0){
    	for(MasEmployee masEmployee :employeeList){%>
  
    <option value="<%=masEmployee.getId()%>"><%=masEmployee.getEmployeeName() %></option>
    <%}} %>
	</select>
	<label>Assisted By2</label>
   <select name="assistedBy2" id="assistedBy2" class=""  validate="">
    <option value="0">Select</option>
    <%if(employeeList.size()>0){
    	for(MasEmployee masEmployee :employeeList){%>
  
    <option value="<%=masEmployee.getId()%>"><%=masEmployee.getEmployeeName() %></option>
    <%}} %>
	</select>
<div class="clear"></div>
<label>Remarks if Any</label>
<textarea name="remarksAny" id="remarksAny" cols="0" rows="0" maxlength="1024" style="width:353px;"></textarea>

<div class="clear"></div>
<input type="button" name="Submit" id="Submit" value="Submit" class="buttonBig" onClick="submitForm('postMortemExamination','mlc?method=updatePostMortemExamination');" accesskey="a" tabindex=1 />

<input type="reset" tabindex="1" onclick="resetCheck();" accesskey="r" class="buttonHighlight" value="Reset" id="reset" name="Reset">
<div class="clear"></div> 
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</div>
</form>




