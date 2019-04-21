<%@page import="jkt.hms.masters.business.PatientWiseMlc"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
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
List<OpdPatientDetails> mlcList = new ArrayList<OpdPatientDetails>();
if(map.get("mlcList") != null)
{
	mlcList=(List<OpdPatientDetails>)map.get("mlcList");
}

List<PatientWiseMlc> patientWiseMlcs= new ArrayList<PatientWiseMlc>();
if(map.get("patientWiseMlcs")!=null){
	patientWiseMlcs=(List<PatientWiseMlc>)map.get("patientWiseMlcs");
}
String hinNo="";
String name="";
String age="";
String gender="";
String address="";
int detailId=0;
int hinId=0;
int  inpationId=0;




	  if(mlcList.size()>0){
	 for(PatientWiseMlc mlc:patientWiseMlcs){
		  
		  if(mlc.getHin()!=null){
		hinNo=mlc.getHin().getHinNo();
		  }else if(mlc.getInpatient()!=null){
			  hinNo=mlc.getInpatient().getHinNo();
		   }
		  
		  if(mlc.getHin()!=null){
			  name=mlc.getHin().getFullName();
		}else if(mlc.getInpatient()!=null){
			name=mlc.getInpatient().getHin().getFullName();
		 }
		  
		  if(mlc.getHin()!=null){
			  age=mlc.getHin().getAge();
		}else if(mlc.getInpatient()!=null){
			age=mlc.getInpatient().getHin().getAge();
		 }
		  
		  if(mlc.getHin()!=null){
			  gender=mlc.getHin().getSex().getAdministrativeSexName();
		}else if(mlc.getInpatient()!=null){
			gender=mlc.getInpatient().getHin().getSex().getAdministrativeSexName();
		 }
		
		
		  if(mlc.getHin()!=null){
			  hinId=mlc.getHin().getId();
		}else if(mlc.getInpatient()!=null){
			hinId=mlc.getInpatient().getHin().getId();
		 }
			
		  if(mlc.getInpatient()!=null){
			  inpationId=mlc.getInpatient().getId();
		}
		  if(mlc.getOpdPatientDetail()!=null){
			  detailId=mlc.getOpdPatientDetail().getId();
		}
	   
	 
	 } 
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

<div class="Block">
<label><span>*</span> UHID</label>
<input name="uhinId" id="uhinId" validate="UHID,string,yes" value="<%=hinNo %>" readonly="readonly" > 
 <input type="hidden"  name="detailId"   value="<%= detailId%>"/>
  <input type="hidden"  name="hinId"   value="<%= hinId%>"/>
   <input type="hidden"  name="inPatientId"   value="<%= inpationId%>"/>
</div>

<div class="titleBg">
<h2>Preserved During Postmortem Examination</h2>
</div>

<div class="clear"></div>
 
<div class="Block">

<label>Postmortem No.</label>
<input type="text" name="pmNo" id="pmNo" />
 <label>Date</label> 
<input type="text" class="date"	name="postdate" id="postdate" value="<%=currentDate %>" MAXLENGTH="30" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate%>',document.drunkcert.postdate,event)" />
 
<div class="clear"></div>
<label>Name :</label>
<input type="text" id="pname" name="pname" value="<%=name %>" readonly="readonly" />
  <label>Age :</label>
<input type="text" id="age"  name="age" value="<%=age %>" readonly="readonly" />

<label>Sex :</label>
<input type="text" id="age"  name="age" value="<%=gender %>" readonly="readonly" />
<div class="clear"></div>

<label>Address:</label>
<textarea class="textareaMediua" name="address" id="address" rows="4" cols="50"></textarea>
<label>Crime No:</label>
<input type="text" id="crNo"  name="crNo" />
 <label>Police Station</label>
<input type="text" name="policeStation" id="policeStation" />
<div class="clear"></div>
<h4>Material Objects</h4>
<table width="50%" border="0" cellspacing="0" cellpadding="0" id="materialObj"  class="cmntable">
 <%int i = 1;%>
 <tr></tr>
<tr>
 <td><input type="radio" value="" name="radio" class="radioCheck" /></td>     
<td><input type="text" id="matrial"  name="matrial" class="input"/></td>
<td><input type="button" name="add" value="" class="buttonAdd" onclick="addRow();" tabindex="1" /></td>
<input type="hidden" value="<%=i%>" name="hiddenValueCharge" id="hiddenValueCharge" />
</tr>   
</table>
<input type="button" name="delete" class="buttonDel" onClick="removeRow();" />
<div class="clear"></div>

<label>Packing</label>
<select class="mediumm"  name="packing">
<option value="">Select</option>
<option value="Collected in glass bottles">Collected In Glass Bottles</option>
<option value="wrapped with paper">Wrapped With Paper</option>
</select>
<label>Tied</label><input type="radio" name="radio" value="tied">
<label>Sealed</label><input type="radio" name="radio" value="sealed">
<div class="clear"></div>
<label>Impression seal used</label>
<input type="checkbox" name="impression" value="Impression seal used">

<label>Labels</label>
<select class="mediumm"  name="labels">
<option value="">Select</option>
<option value="Labels in bottles">Labels in Bottles</option>
<option value="Attached to Packages">Attached to Packages</option>
</select>
<label>Cause Of Death</label>
<textarea class="textareaMediua" name="couseDeath" id="couseDeath" rows="4" cols="50"></textarea>
<div class="clear"></div>
<label>Clinical history</label>
<textarea class="textareaMediua" name="clinickHis" id="clinickHis" rows="4" cols="50"></textarea>
<label>Treatment</label>
<textarea class="textareaMediua" name="treatment" id="treatment" rows="4" cols="50"></textarea>
<label>Progress</label>
<textarea class="textareaMediua" name="progress" id="progress" rows="4" cols="50"></textarea>
<div class="clear"></div>
<label>Postmortem brief</label>
<textarea class="textareaMediua" name="pomBrief" id="pomBrief" rows="4" cols="50"></textarea>
<div class="clear"></div>
<h4>Examination Required</h4>
<label>Quantitative</label>
<input type="checkbox" value="Quantitative" name="Quantitative">
<label>Qualitative</label>
<input type="checkbox" value="Qualitative" name="Qualitative">


<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
 <input type="hidden" name="<%=CHANGED_DATE %>" value="<%= currentDate%>" /> 
 <input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
<div class="clear"></div>
</div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input class="buttonBig" type="button" onclick="submitForm('drunkcert','mlc?method=submitPreserveDuringPostmortem');" value="Submit">


<script type="text/javascript">
function addRow(){
       var tbl = document.getElementById('materialObj');
       var lastRow = tbl.rows.length;

       var row = tbl.insertRow(lastRow);
       var hdb = document.getElementById('hiddenValueCharge');
       var iteration = parseInt(hdb.value)+1;
       hdb.value = iteration;

       var cell0 = row.insertCell(0);
       var e0 = document.createElement('input');
       e0.type = 'radio';
       e0.name='radio';
       e0.className='radioCheck';
       cell0.appendChild(e0);
       
       var cell1 = row.insertCell(1);
       var e1 = document.createElement('input');
       e1.type = 'input';
       e1.style = 'width: 138px';
       e1.name='matrial';
       e1.className='input';
       cell1.appendChild(e1);
   
     var cell2 = row.insertCell(2);
 	var e2 = document.createElement('input');
 	e2.type = 'button';
 	e2.name='add';
 	e2.className = 'buttonAdd';
 	e2.tabIndex='1';
 	e2.onclick = function(){
 					addRow();
 	}
 	cell2.appendChild(e2); 
}
function removeRow()
{
      var tbl = document.getElementById('materialObj');
        var tblRows  = tbl.getElementsByTagName("tr");

         if(tblRows.length-2==0){
                alert("Can not delete all rows")
                return false;
    }
       for(counter=0;counter<document.getElementsByName('radio').length;counter++)
       {
               if (document.getElementsByName('radio')[counter].checked == true)
               {
                         tbl.deleteRow(counter+1);
                         document.getElementById('hiddenValueCharge').value=document.getElementsByName('radio').length;
               }        }}

</script>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>