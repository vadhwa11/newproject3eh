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

<script>
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

String userName="";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
String message="";
if(map.get("message") != null){
	   message = (String)map.get("message");
}
%>
<h2><%= message%></h2>
<form name="drunkcert" method="post">
<div class="titleBg">
<h2>Search</h2>
</div>
<div class="Block">
<label><span>*</span> UHID</label>
<input name="uhinId" id="uhinId" validate="UHID,string,yes"  onblur="patientList(this.value,'drunkcert');"> 
</div>
<div class="titleBg">
<h2>REFERRING A POSTMORTEM EXAMINATION TO POLICE SURGEON</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>R M No</label>
<input type="text" name="reqname" id="reqname" />
 <label>Date</label> 
<input type="text" class="date"	name="postdate" id="postdate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.<%=FROM_DATE%>,event)" />
 
<div class="clear"></div>
<label>Name :</label>
<input type="text" id="pname" name="pname"/>
  <label>Age :</label>
<input type="text" id="age"  name="age" readonly="readonly"/>
 <input type="hidden"  id="hinId"  name="hinId" readonly="readonly"/>
<label>Sex :</label>
<input type="text" d="Gender"  name="Gender" readonly="readonly"/>
<div class="clear"></div>
<label>Address:</label>
<textarea class="textareaMediua" name="address" id="address" rows="4" cols="50"></textarea>
<label>Crime No:</label>
<input type="text" id="crno"  name="crno" />
 <label>Police Station</label>
<input type="text" name="ofPolice" id="ofPolice" />
<div class="clear"></div>
<label>Received From</label>
<input type="text" id="crno"  name="crno" />
<label>Time</label>
<input type="text" id="crno"  name="crno" />
 <label>Rc. Date</label> 
<input type="text" class="date"	name="postdate" id="postdate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.<%=FROM_DATE%>,event)" />
 <div class="clear"></div>
   <h4>Vide His Letter</h4>
<label>Crime No:</label>
<input type="text" id="crno"  name="crno" />
 <label>Date</label> 
<input type="text" class="date"	name="postdate" id="postdate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.<%=FROM_DATE%>,event)" />
<label>PC No:</label>
<input type="text" id="crno"  name="crno" />
<div class="clear"></div>
<label>At</label>
<input type="text" id="crno"  name="crno" />
 <label>P.M. Date</label> 
<input type="text" class="date"	name="postdate" id="postdate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.<%=FROM_DATE%>,event)" />
 <label>Cause Of Death</label>
<textarea class="textareaMediua" name="address" id="address" rows="4" cols="50"></textarea>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
 <input type="hidden" name="<%=CHANGED_DATE %>" value="<%= currentDate%>" /> 
 <input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input class="buttonBig" type="button" onclick="submitForm('drunkcert','mlc?method=');" value="Submit">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>