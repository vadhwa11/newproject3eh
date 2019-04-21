<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.util.Properties"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

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

Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();


if (request.getAttribute("map") != null) {
	map = (Map<String, Object>) request.getAttribute("map");
}

List<Patient> patientList = new   ArrayList<Patient>();
if(map.get("patientList") != null)
{
	patientList=(List<Patient>)map.get("patientList");
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



URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
String message="";

if(map.get("message") != null){
	   message = (String)map.get("message");
}
String userName="";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}


%>	
<h4>
	<span><%=message %></span>
</h4>

<form name="treatment" method="post" action="">
<div class="clear"></div>

<div class="titleBg">
<h2>Search</h2>
</div>
<div class="Block">
<label><span>*</span> UHID</label>
<input name="uhinId" id="uhinId" validate="UHID,string,yes"  onblur="submitProtoAjaxWithDivName('treatment','/hms/hms/mlc?method=getMedicolegalRegisterDetail','tDiv');"> 
</div>

<div class="clear"></div>


<div id="tDiv">

<div class="titleBg">
<h2>Medico-legal Register</h2>
</div>
<div class="Block">
<div id="titleBg">


<label>Serial NO</label>

<select name="docName" id="serialNo" class=""  validate="">
      
</select> 
<div class="clear"></div>


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


<div class="clear"></div>

<div class="clear"></div>

<label>Address</label>
<textarea rows="4" cols="50" id="address" name="address" class="textareaMediua"></textarea>

<label>Ref.Crime No</label>
<input type="text"  name="crno" >



<label>Police Station</label>
<input type="text"  name="policestation" >

<div class="clear"></div>

<label>Requistion Form</label>
<textarea rows="4" cols="50" id="reqForm" name="reqForm" class="textareaMediua"></textarea>


	
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


<input type="button" name="Submit"  value="Submit" class="buttonBig" onClick="submitForm('treatment','mlc?method=submmitMedicoRegister');"
	accesskey="a" tabindex=1 />
	
<input type="reset" tabindex="1" onclick="resetCheck();" accesskey="r" class="buttonHighlight" value="Reset" id="reset" name="Reset">	

	</div>
</div>	
</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>







