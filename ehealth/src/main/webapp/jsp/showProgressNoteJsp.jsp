<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
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
	List<MasUnit> unitList = new ArrayList<MasUnit>();
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

<form name="wardRemarks" action="" method="post">
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
	List<MasDepartment>masDepartmentList=new ArrayList<MasDepartment>();
if(map.get("masDepartmentList")!=null){
	masDepartmentList=(List)map.get("masDepartmentList");
}
int deptId1=0;
if(map.get("deptId")!=null){
	deptId1=(Integer)map.get("deptId");
}
List<Inpatient>inpatientList=new ArrayList<Inpatient>();
if(map.get("inpatientList")!=null){
	inpatientList=(List<Inpatient>)map.get("inpatientList");
}
String hin_no="";
String inpatient_no="";
String name="";
String age="";
String sex="";
int inpatientId=0;
for(Inpatient inp:inpatientList){
	inpatientId=inp.getId();
	hin_no=inp.getHinNo();
	inpatient_no=inp.getAdNo();
	name=inp.getHin().getPFirstName().concat(" ").concat(inp.getHin().getPLastName());
	age=inp.getAge();
	sex=inp.getHin().getSex().getAdministrativeSexName();
}
	
%> 
	
	
	
	<%if(!message.equals("")){ %> <h4><span><%=message %></span></h4> <% }%>

<div class="clear"></div>
<h4>Progress Note</h4>
<div class="clear"></div>
<div class="Block">
<label ><span> * </span>Date</label> 
<input type="text" name="<%=DATE%>" value="<%=currentDate %>" class="date" Adm validate="Date,dateOfAdmission,yes" MAXLENGTH="30" readonly="readonly" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" id="imgId" onclick="javascript:setdate('',document.wardRemarks.<%=DATE%>,'event')" />
<label ><span> * </span>Time </label> 
<input type="text" name="<%=TIME %>" value="<%=currentTime %>" class="readOnly" readonly="readonly" validate="Adm. Time,String,yes" id="admTime" onblur="checkTime('admissionByHin','<%=TIME_OF_ADMISSION%>');" />
<div class="clear"></div>
<label >Name</label> 
<label class="value"><%=name %></label>
<input type="hidden" name="inpatientId" id="inpatientId" value="<%=inpatientId %>"/>
<label >Reg. No.</label> 
<label class="value"><%=hin_no %></label>
<label >AD No.</label> 
<label class="value"><%=inpatient_no %></label>
<div class="clear"></div>
<label >Age</label> 
<label class="value"><%=age %></label>
<label >Sex</label> 
<label class="value"><%=sex %></label>


<label ><span> * </span>Progress Note </label> <textarea
	name="<%=REMARKS %>" rows="5" cols="100" validate="Progress Notes,string,yes"
	id="nokAddr" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="475" tabindex="1"></textarea>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" onclick="submitForm('wardRemarks','/hms/hms/ipd?method=saveProgressNotes');"	value="Submit" class="button" /> 
<input type="button" name="Back"	class="button" value="Back"	onclick="submitForm('wardRemarks','/hms/hms/ipd?method=showPatientListJsp');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<h4>View</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium"><span>*</span> Date </label> 
<input type="text" name="<%=DATE_OF_REMARKS%>" value="<%=currentDate %>" class="date" readonly="readonly" validate="Date,dateOfAdmission,yes" MAXLENGTH="30" id="remarksDate" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" id="imgId"	onclick="javascript:setdate('',document.wardRemarks.<%=DATE_OF_REMARKS%>,'event')" />
<div class="clear"></div>
</div><div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Back" class="button" value="View" onclick="getViewDetals();" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="viewDetails"></div>


<div class="paddingTop15"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
<script>
function getViewDetals() {
	var remarksDate = document.getElementById("remarksDate").value
	var inpatientId=document.getElementById("inpatientId").value
	//alert("inpatientId----->"+inpatientId);
	var xmlHttp;
	try {
	// Firefox, Opera 8.0+, Safari
	xmlHttp=new XMLHttpRequest();
	}catch (e){
	// Internet Explorer
	try{
	xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	}catch (e){
	try{
	xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	}catch (e){
	alert("Your browser does not support AJAX!");
	return false;
	}
	}
	}
	xmlHttp.onreadystatechange=function()
	{
	if(xmlHttp.readyState==4){
	document.getElementById("viewDetails").innerHTML = xmlHttp.responseText;
	}
	}
	var url="/hms/hms/ipd?method=getProgressNoteDetails&remarksDate="+remarksDate+"&inpatientId="+inpatientId+"&"+csrfTokenName+"="+csrfTokenValue
//alert("url----<>"+url);
	xmlHttp.open("GET",url,true);

	xmlHttp.send(null);
	}

	</script>


</script>