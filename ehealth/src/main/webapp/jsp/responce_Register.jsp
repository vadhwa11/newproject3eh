<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.util.Calendar"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.masters.business.MedicoLegalDetails"%>
<%@page import="jkt.hms.masters.business.SurveyDetailMails"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.PhMasParliyamentAssembly"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>

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
		
		
			
		
		    function validateHhMm(inputField) {
		        var isValid = /^([0-1]?[0-9]|2[0-4]):([0-5][0-9])(:[0-5][0-9])?$/.test(inputField.value);

		        if (isValid) {
		            inputField.style.backgroundColor = '#bfa';
		        } else {
		            inputField.style.backgroundColor = '#fba';
		        }

		        return isValid;
		    }

			
		
	</script>



<%
Map<String, Object> utilMap = new HashMap<String, Object>();
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}


List<MedicoLegalDetails> medList=new ArrayList<MedicoLegalDetails>();
if(map.get("details") !=null){
	medList=(List<MedicoLegalDetails>)map.get("details");
}
List<MasEmployee> emplist = new ArrayList<MasEmployee>();
if(map.get("emplist") != null)
{
	emplist=(List<MasEmployee>)map.get("emplist");
}



String currentDate ="";
String time ="";
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
 currentDate = (String)utilMap.get("currentDate");
 time = (String)utilMap.get("currentTime");



String message="";

if(map.get("message") != null){
	   message = (String)map.get("message");
}
String userName="";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}

%>
 <div id="tDiv">
 <div id="titleBg">
<h2>Medico-legal Register</h2>
</div>
<div class="Block">
<label>Serial NO</label>

<select name="docName" id="serialNo" class=""  validate="" onblur="submitProtoAjaxWithDivName('treatment','/hms/hms/mlc?method=getDetailAndDisplay','detalDiv');">
       <%	if(medList.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MedicoLegalDetails det : medList) {
					
				  %>
	  <option value="<%=det.getId()%>"><%=det.getSerialNo()%></option>
				  <%
		}}
				   %>
</select> 
<div class="clear"></div>

<div id="detalDiv">
<label>Ref.ML.NO</label>
<input type="text"   id="refNo" name="refNo">

<label>Date</label>
<input 	type="text" name="regDate" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.treatment.<%=FROM_DATE%>,event);" />


<label>Name</label>
<input type="text"   id="pname" name="pname">


<div class="clear"></div>

<label>Sex</label>
<input type="text"  id="gender"  name="gender" readonly="readonly">

<label>Age</label>
<input type="text" id="age"  name="age" readonly="readonly">
 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly"/>

<div class="clear"></div>

<div class="clear"></div>



<label>Address</label>
<textarea rows="4" cols="50" id="address" name="address" class="textareaMediua">

</textarea>

<label>Ref.Crime No</label>
<input type="text"  name="crno" >



<label>Police Station</label>
<input type="text"  name="policestation" >


<div class="clear"></div>
<label>Requistion Form</label>
<textarea rows="4" cols="50" id="reqForm" name="reqForm" class="textareaMediua">

</textarea>


	
<div class="clear"></div>

<label>Date</label>
<input 	type="text" name="reqDate" value="<%=currentDate%>"
	class="date" validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" />
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentDate%>',document.treatment.<%=FROM_DATE%>,event);" />
	



<label>Examination requsted </label>
<input type="text"  name="exareq" >



<label>Doctor Name</label>

<select name="docName" id="docName" class=""  validate="">
       <%	if(emplist.size() >0){%>
			
				<option value="0">Select</option>
	
				 <%
				 for (MasEmployee masEmp : emplist) {
					
				  %>
	  <option value="<%=masEmp.getId()%>"><%=masEmp.getEmployeeName()%></option>
				  <%
		}}
				   %>
</select>

<div class="clear"></div>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>

<input type="button" name="Submit"  value="Submit"
	class="buttonBig"
	onClick="submitForm('treatment','mlc?method=submmitMedicoRegister');"
	accesskey="a" tabindex=1 />

	</div>
	</div>
	</div>

