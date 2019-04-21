<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
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

<form name="wardRemarks" action="" method="post">
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
	List<MasDepartment>masDepartmentList=new ArrayList<MasDepartment>();
if(map.get("masDepartmentList")!=null){
	masDepartmentList=(List)map.get("masDepartmentList");
}
int deptId1=0;
if(map.get("deptId")!=null){
	deptId1=(Integer)map.get("deptId");
}
List<Patient>patientList=new ArrayList<Patient>();
if(map.get("patientDetailList")!=null){
	patientList=(List<Patient>)map.get("patientDetailList");
}
List<MasRelation>relationList=new ArrayList<MasRelation>();
if(map.get("relationList")!=null){
	relationList=(List<MasRelation>)map.get("relationList");
}
String hin_no="";
String inpatient_no="";
String name="";
String age="";
String sex="";
int hinId=0;
int inpatientId = 0;

if(map.get("inpatientId")!=null){
	inpatientId=(Integer)map.get("inpatientId");
}


for(Patient inp:patientList){
	hinId=inp.getId();
	hin_no=inp.getHinNo();
	//inpatient_no=inp.getAdNo();
	if(inp.getPLastName() != null){
	name=inp.getPFirstName()+" "+inp.getPLastName();
	}else{
		name=inp.getPFirstName();
	}
	age=inp.getAge();
	sex=inp.getSex().getAdministrativeSexName();
}
	
%> 
	
	
	
	<%if(!message.equals("")){ %> <h4><span><%=message %></span></h4> <% }%>

<div class="clear"></div>
<div class="titlebg">
<h2>Consent Form Entry</h2>
</div>
<div class="Block">

<h4>Patient Details</h4>

<input type="hidden" name="hinId" id="hinId" value="<%=hinId %>"/>
<label >Reg. No.</label> 
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
<h4>Consent Form</h4>
<label>Procedure Explained</label>
<select name="checkpro" id="checkpro" onchange="checkForLegal();" tabindex="1">
<option value="">Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>
<div id="legal" style="display: none;">
<div class="clear"></div>
<h4>Legal Representation</h4>
<div class="clear"></div>
<label>Name</label>
<input type="text" name="legalName" id="legalName" value="" tabindex="1"/>
<label>Date</label>
<input type="text" id="dobId" name="<%=DATE%>" tabindex="13" value="<%=currentDate %>" class="date" readonly="readonly" onchange="calculateAgeInAjax('registration');" maxlength="30"  />
<img id="" src="/hms/jsp/images/cal.gif" 	width="16" height="16" border="0"onclick="setdate('<%=currentDate %>',document.wardRemarks.<%=DATE_OF_BIRTH%>,event)"	validate="Pick a date" tabindex="1" />

<label>Phone</label>
<input type="text" name="phone" id="phone" value="" maxlength="11" tabindex="1"/><div class="clear"></div>
<label>Address</label>
<textarea rows="5" cols="5" name="address" id="address" tabindex="1" class="textareaMediua"></textarea>
<label>Relation<span>*</span></label>
<select name="relation" id="relationId" tabindex="1" validate="Relation,metachar,yes">
<option value="">Select</option>
<%for(MasRelation relation:relationList){ %>
<option value="<%=relation.getId() %>"><%=relation.getRelationName() %></option>
<%} %>
</select>
<!-- added by amit das on 26-09-2016 -->
<label >Procedure Template</label> 
<select name="procedureTemplate" id="procedureTemplate" >
<option value="">Select</option>
<option value="Angiography">Angiography</option>
<option value="Angioplasty">Angioplasty</option>
</select>
<input type="hidden"  name="inpatientId" id="inpatientId" value="<%=inpatientId%>">
<div class="clear"></div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Submit"
class="button" onclick="submitForm('wardRemarks','ot?method=submitConsentForOt');" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" tabindex="1"/> 
<div class="clear"></div>
</form>

<script>
function checkForLegal(){
var legalId=document.getElementById('checkpro').value;
if(legalId=='Yes'){
	document.getElementById("legal").style.display='block';
}else{
	document.getElementById("legal").style.display='none';
}
}
</script>	
