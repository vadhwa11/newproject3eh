<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
	<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(Calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(date.length()<2){
	date="0"+date;
	}
	%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
		</script>

<form name="bloodConsentStored" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message ="";
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	if(map.get("message") !=null){
	message =""+map.get("message");
	}
int deptId1=0;
if(map.get("deptId")!=null){
	deptId1=(Integer)map.get("deptId");
}
List<Patient>patientList=new ArrayList<Patient>();
if(map.get("patientDetailList")!=null){
	patientList=(List<Patient>)map.get("patientDetailList");
}
String hin_no="";
String inpatient_no="";
String name="";
String age="";
String sex="";
int hinId=0;
int visitId=0;
int inpatientId = 0;

if(map.get("inpatientId")!=null){
	inpatientId=(Integer)map.get("inpatientId");
}
if(map.get("visitId")!=null){
	visitId=(Integer)map.get("visitId");
}

for(Patient inp:patientList){
	hinId=inp.getId();
	hin_no=inp.getHinNo();
	name=inp.getPFirstName();
	age=inp.getAge();
	sex=inp.getSex().getAdministrativeSexName();
}
	
%> 
	
	
	
	<%if(!message.equals("")){ %> <h4><span><%=message %></span></h4> <% }%>

<div class="clear"></div>
<div class="titlebg">
<h2>Blood Consent Letter Upload and Download</h2>
</div>
<div class="Block">

<h4>Patient Details</h4>

<input type="hidden" name="hinId" id="hinId" value="<%=hinId %>"/>
<input type="hidden" name="visitId" id="visitId" value="<%=visitId %>"/>
<input type="hidden" name="inpatientId" id="inpatientId" value="<%=inpatientId %>"/>
<label >UHID</label> 
<label class="value"><%=hin_no %></label>

<label >Name</label> 
<label class="value"><%=name %></label>

<label >Age</label> 
<label class="value"><%=age %></label><div class="clear"></div>
<label >Gender</label> 
<label class="value"><%=sex %></label>
<div class="clear"></div>
</div>
<div class="Block">
<h4>Consent Letter</h4>
<a href="javascript:popwindowUploadDocuments();" >Upload and View Document</a>
</div>
<div class="clear"></div>
<div class="division"></div>

<div id="searchbar">
	<input type="button" name="Back" value="Back" class="buttonHighlight"	tabindex="1" onclick="showBack('bloodConsentStored')" />	
							
</div>
<div class="clear"></div>
</form>

<script type="text/javascript">
function popwindowUploadDocuments() {
	var patienthinid=document.getElementById('hinId').value;
	
	if(patienthinid !=""){
		var url="/hms/hms/bloodBank?method=openUploadPopWindow&hinId="+patienthinid+"&visitId="+<%=visitId%>+"&inpatientId="+<%=inpatientId%>+"&otConsent=y"+"&"+csrfTokenName+"="+csrfTokenValue;
 		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=1024,status=1,scrollbars=1,resizable=0");
	}
}

function showBack(formName)
{
  obj = eval('document.'+formName);
  obj.action = "/hms/hms/bloodBank?method=showUploadBloodConsentLetter";
  obj.submit();
}
</script>