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
	function getViewDetals() {
	remarksDate = document.getElementById("remarksDate").value
	var inpatientId=document.getElementById("inpatientId").value
	var deptId=document.getElementById("deptId").value
	//alert("deptId----->"+deptId);
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
	var url="/hms/hms/ipd?method=getWardRemarksDetails&remarksDate="+remarksDate+"&deptId="+deptId+"&inpatientId="+inpatientId;
 	url = url+'&'+csrfTokenName+'='+csrfTokenValue; // added by amit das on 07-07-2016
//alert("url----<>"+url);
	xmlHttp.open("GET",url,true);

	xmlHttp.send(null);
	}

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
List<Inpatient>inpatientList=new ArrayList<Inpatient>();
if(map.get("inpatientList")!=null){
	inpatientList=(List)map.get("inpatientList");
}
//




int deptId1=0;
if(map.get("deptId")!=null){
	deptId1=(Integer)map.get("deptId");
}
	%> <%if(!message.equals("")){ %> <h4><span><%=message %></span></h4> <% }%>

<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<%for(Inpatient ip:inpatientList){ %>
<label>Ad No</label>
<label class="value"><%=ip.getAdNo() %></label>
<input type="hidden"  name="inpatientId" value="<%=ip.getId() %>" id="inpatientId"/>
<label>Patient Name</label>
<label class="value"><%=ip.getHin().getPFirstName().concat(" ").concat(ip.getHin().getPLastName()) %></label>
<label>Hin No.</label>
<label class="value"><%=ip.getHinNo()%></label>
<label>Hin No.</label>
<label class="value"><%=ip.getHinNo()%></label>

<%} %>
</div>
<div class="clear"></div>
<h4>Daily Remarks</h4>
<div class="clear"></div>
<div class="Block"><label ><span> * </span>Date
</label> <input type="text" name="<%=DATE%>" value="<%=currentDate %>"
	class="date" Adm validate="Date,dateOfAdmission,yes" MAXLENGTH="30"
	readonly="readonly" /> <img src="/hms/jsp/images/cal.gif" width="16"
	height="16" border="0" validate="Pick a date" id="imgId"
	onclick="javascript:setdate('',document.wardRemarks.<%=DATE%>,'event')" />

<label ><span> * </span>Time </label> <input type="text"
	name="<%=TIME %>" value="<%=currentTime %>" class="readOnly"
	readonly="readonly" validate="Adm. Time,String,yes" id="admTime"
	onblur="checkTime('admissionByHin','<%=TIME_OF_ADMISSION%>');" /> <label
	><span> * </span>Remarks </label> <textarea
	name="<%=REMARKS %>" rows="5" cols="100" validate="Remarks,string,yes"
	id="nokAddr" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="475" tabindex="1"></textarea>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" onclick="submitForm('wardRemarks','/hms/hms/ipd?method=saveWardRemarks');"	value="Submit" class="button" /> 
<input type="button" name="Back"	class="button" value="Back"	onclick="submitForm('wardRemarks','/hms/hms/ipd?method=showPatientListJsp');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>View</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium"><span>*</span> Date </label> 
<input type="text" name="<%=DATE_OF_REMARKS%>" value="<%=currentDate %>" class="date" readonly="readonly" validate="Date,dateOfAdmission,yes" MAXLENGTH="30" id="remarksDate" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" id="imgId"	onclick="javascript:setdate('',document.wardRemarks.<%=DATE_OF_REMARKS%>,'event')" />
<label >Department</label>
<select name="deptName" id="deptId">
<option value="">Select</option>
<%for(MasDepartment dept:masDepartmentList){ %>
<%if(dept.getId()==deptId1){ %>
<option value="<%=dept.getId() %>" selected="selected"><%=dept.getDepartmentName() %></option>
<%}else{ %>
<option value="<%=dept.getId() %>" ><%=dept.getDepartmentName() %></option>
<%} }%>
</select> 
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Back" class="button" value="View" onclick="getViewDetals();" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="viewDetails"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>