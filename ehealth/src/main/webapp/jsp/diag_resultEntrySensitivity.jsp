<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgTemplate"%>
<%@page import="jkt.hms.masters.business.DgMasOrganismGroup"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>

<script type="text/javascript">
function fillOrganism(){
  var orGroupId ="";
   var x=document.getElementById("organismId")
	for (var i=0; i<x.options.length-1;i++) {
	if (x.options[i].selected) {
	orGroupId=orGroupId+x.options[i].value+"."
	
	}
}
	 //----------------------AJAX PART------------Start------
  
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
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById("organismDiv").innerHTML='<font id="error">Loading...</font>'
      document.getElementById("sensitivityDiv").innerHTML=""
    }else
      if(xmlHttp.readyState==4){
         document.getElementById("organismDiv").innerHTML = xmlHttp.responseText;
      }
    }
     
    xmlHttp.open("GET","/hms/hms/investigation?method=getOrganismList&orGroupId="+orGroupId+"&"+csrfTokenName+"="+csrfTokenValue,true);
    
    xmlHttp.send(null);
//----------------------AJAX PART------------End------

}

function fillSensitivity(val){
var noOfOrg=document.getElementById("noOfOrg").value
 var x=document.getElementById("organismId")
 var orIds="";
for (var i=1; i<=noOfOrg;i++) {
	if (document.getElementById(("chkBox"+i)).checked) {
	orIds=orIds+document.getElementById(("chkBox"+i)).value+"."
	}}
 //----------------------AJAX PART------------Start------
  
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
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById("sensitivityDiv").innerHTML='<font id="error">Loading...</font>'
    }else
      if(xmlHttp.readyState==4){
         document.getElementById("sensitivityDiv").innerHTML = xmlHttp.responseText;
      }
    }
     
    xmlHttp.open("GET","/hms/hms/investigation?method=getSensitivityList&orIds="+orIds+"&"+csrfTokenName+"="+csrfTokenValue,true);
    
    xmlHttp.send(null);
//----------------------AJAX PART------------End------
}
  function resetResult(){
 
	   document.getElementById('abc').value="";
	   document.getElementById('additionalRemarks').value="";
	   
   }


<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String dateCal=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(dateCal.length()<2){
dateCal="0"+dateCal;
}
%>
serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<%
	int pageNo=1;
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
	List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
	List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	List<DgMasOrganismGroup> dgMasOrganismGroupList = new ArrayList<DgMasOrganismGroup>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	Box box = HMSUtil.getBox(request);
	
	String userName = "";
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("pageNo") != null){
	pageNo=(Integer)map.get("pageNo");
	}
	if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
	String message = (String)map.get("message");
	out.println(message);
	}
	if(map.get("employeeList") != null){
	employeeList = (List<MasEmployee>)map.get("employeeList");
	}
	int userId =0;
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
	}
	if(map.get("investigationList") != null){
	investigationList = (ArrayList)map.get("investigationList");
	}
	Map detailsMap = new HashMap();
	if(map.get("detailsMap") !=null){
	detailsMap=(Map<String, Object>)map.get("detailsMap");
	}
	   if(detailsMap.get("dgMasOrganismGroupList") != null){
		   dgMasOrganismGroupList  = (List<DgMasOrganismGroup>)detailsMap.get("dgMasOrganismGroupList");
		}
	 
	String deptName="";
	if(session.getAttribute("deptName") != null){
		deptName = (String)session.getAttribute("deptName");
	}
	int deptId =0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	String deptType="";
	if(session.getAttribute("deptType") != null){
		deptType = (String)session.getAttribute("deptType");
	}
	
	try{
	if(map.get("sampleCollectionList") != null){
	sampleCollectionList=(List)map.get("sampleCollectionList");
	
	}
	}catch(Exception e){
	e.printStackTrace();
	}
	
	
	DgSampleCollectionDetails dgDetails = new DgSampleCollectionDetails();
	Patient patient = new Patient();
	if(sampleCollectionList != null)
	{
	dgDetails=(DgSampleCollectionDetails) sampleCollectionList.get(0);
	patient = (Patient) dgDetails.getSampleCollectionHeader().getHin();
	
	}
	DgSampleCollectionDetails dgsampleDetails=new DgSampleCollectionDetails();
	
	if(sampleCollectionList != null){
	dgsampleDetails = (DgSampleCollectionDetails) sampleCollectionList.get(0);
	
	}
%>

<!--main content placeholder starts here-->

<form name="sensitivity" method="post" action="">
<div class="titleBg">
<h2>Result Entry-Sensitivity</h2>
</div>
<div class="clear"></div>
<%
	String subDept = "";
	String dept="";
	int SubChargeId=0;
	int mainChargeId=0;
	int hinId = 0;
	String patientName = "";
	String age = "";
	String sex = "";
	String hinNo = "";
	String currentAge = "";
	String maritalStatus = "";
	
	for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
	if(dgCollection.getInvestigation()!= null){
	subDept = dgCollection.getInvestigation().getSubChargecode().getSubChargecodeName();
	dept = dgCollection.getInvestigation().getMainChargecode().getMainChargecodeName();
	SubChargeId=dgCollection.getInvestigation().getSubChargecode().getId();
	mainChargeId=dgCollection.getInvestigation().getMainChargecode().getId();
	DgSampleCollectionHeader sampleHeader = dgCollection.getSampleCollectionHeader();
	Set<DgOrderdt> set = new HashSet<DgOrderdt>();
	set = dgCollection.getSampleCollectionHeader().getOrder().getDgOrderdts();
	for(DgOrderdt orderDt : set){
	if(orderDt.getBill() != null){
		BlOpBillHeader  billHeader = orderDt.getBill();
		if(billHeader.getHin() != null ){
		patientName=billHeader.getHin().getPFirstName();
		age=billHeader.getHin().getAge();
		sex=billHeader.getHin().getSex().getAdministrativeSexName();
		hinNo=billHeader.getHin().getHinNo();
		hinId=billHeader.getHin().getId();
		currentAge = HMSUtil.calculateAgeForADT(age, sampleHeader.getHin().getRegDate());
		if(billHeader.getHin().getMaritalStatus() != null){
		maritalStatus = billHeader.getHin().getMaritalStatus().getMaritalStatusName();
		}
		}else {
			patientName=billHeader.getPatientName();
			age=billHeader.getAge();
			sex=billHeader.getSex().getAdministrativeSexName();
			currentAge=billHeader.getAge();
			hinNo="--";
			maritalStatus="--";
		}
		}
	else{
		DgOrderhd  orderhd = orderDt.getOrderhd();
		if(orderhd.getHin() != null){
			patientName=orderhd.getHin().getPFirstName();
			age=orderhd.getHin().getAge();
			currentAge = HMSUtil.calculateAgeForADT(age, orderhd.getHin().getRegDate());
			if(orderhd.getHin().getMaritalStatus() != null){
			maritalStatus = orderhd.getHin().getMaritalStatus().getMaritalStatusName();
			}
			sex=orderhd.getHin().getSex().getAdministrativeSexName();
			hinNo=orderhd.getHin().getHinNo();
		}
	}
	}
 }
  } %>

<div class="clear"></div>
<div class="Block"><label> Department</label> <label class="value"
	name="<%=MAIN_CHARGECODE_NAME %>"><%=deptName%></label> <input
	name="<%= DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID %>" type="hidden"
	value="<%= deptId %>" /> <label>Sub Department</label> <label
	class="value" name="<%=SUB_CHARGECODE_NAME %>"><%=subDept%></label> <input
	name="<%= SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID %>"
	type="hidden" value="<%= SubChargeId %>" /> <input
	name="<%= MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID %>"
	type="hidden" value="<%= mainChargeId %>" /> <label>Order No.</label>
<%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%= dgDetails.getSampleCollectionHeader().getOrder().getOrderNo()%></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>

<div class="paddLeft25"><label>Order Date</label></div>
<%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %> <label
	class="value"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getOrder().getOrderDate())%></label>
<%}else{%> <label class="value">-</label> <%}%> <label>Order Time</label> <%if(dgDetails.getSampleCollectionHeader().getOrder() != null){ %>
<label class="value"><%= dgDetails.getSampleCollectionHeader().getOrder().getOrderTime()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>Order By</label> <%if(dgDetails.getSampleCollectionHeader().getOrder().getDepartment() != null){ %>
<label class="value"><%=dgDetails.getSampleCollectionHeader().getOrder().getDepartment().getDepartmentName()%></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="hidden" name="<%=SAMPLE_COLLECTION_ID %>"
	id="<%= SAMPLE_COLLECTION_ID%>"
	value="<%=dgDetails.getSampleCollectionHeader().getId() %>" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=hinId %>" /> <!--Block Two Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label> HIN</label> <%if(hinNo != null){ %> <label class="value"><%=hinNo%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label>Patient
Name</label> <label class="value"><%=patientName%></label> <label> Sex</label> <label
	class="value"><%=sex %></label>
<div class="clear"></div>
<label>Age</label> <%if(currentAge != null){ %> <label class="value"><%=currentAge%></label>
<%}else{ %> <label class="value">-</label> <% }%> <label> Marital
Status</label> <%if(maritalStatus !=null){ %> <label class="value"><%=maritalStatus%></label>
<%}else{ %> <label class="value">-</label> <% }%>
<div class="clear"></div>

<input type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getDepartment().getId() %>" />



<%if(dgDetails.getSampleCollectionHeader().getInpatient() != null){ %> <input
	type="hidden" name="<%=INPATIENT_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getInpatient().getId()%>" />
<%}%>
</div>

<!--Block Two Ends-->
<div class="clear"></div>
<div class="paddingTop15"></div>
<!-- Block Three Starts -->
<h4>Report Details</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Report Date</label> <label class="value"><%=date%></label> <label>Report
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=SAMPLE_COLLECTION_DATE%>" value="<%=date%>" /> <input
	type="hidden" name="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" />
<%
String resultSeqNo="";
if(map.get("resultSeqNo") != null){
resultSeqNo = (String)map.get("resultSeqNo");
}
%> <input type=hidden name="<%=RESULT_NO %>" value="<%=resultSeqNo %>" />


<label><span>*</span> Report Prepared By</label> <select
	name="<%= RESULT_ENTERED_BY  %>"
	validate="Report Entered By,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
			for (MasEmployee masEmployeecode : employeeList) {
				if (userId ==(masEmployeecode.getId())) {
		%>
	<option value="<%=masEmployeecode.getId ()%>" selected="selected"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%}else{ %>
	<option value="<%=masEmployeecode.getId ()%>"><%=masEmployeecode.getEmployeeCode()%>
	- <%=masEmployeecode.getFirstName()%> <%=masEmployeecode.getMiddleName()%>
	<%=masEmployeecode.getLastName()%></option>
	<%	}}		%>
</select>
<div class="clear"></div>
<%if(deptType.equalsIgnoreCase("DIAG")){ %> <label>Sample
Validated Date</label> <%}else if(deptType.equalsIgnoreCase("RADIO")){ %> <label>Report
Collection Date</label> <%}else{ %> <label>Sample Validated Date</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getSampleValidationDate() != null){ %>
<label class="value"><%=HMSUtil.changeDateToddMMyyyy(dgDetails.getSampleCollectionHeader().getSampleValidationDate()) %></label>
<%}else{ %> <label class="value">-</label> <%} %> <%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label>Sample Validated Time</label> <%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
<label>Report Collection Time</label> <%}else{ %> <label>Sample
Validated Time</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getSampleValidationTime() != null){ %>
<label class="value"><%=dgDetails.getSampleCollectionHeader().getSampleValidationTime() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <%if(deptType.equalsIgnoreCase("DIAG")){ %>
<label>Sample Validated By</label> <%}else if(deptType.equalsIgnoreCase("RADIO")){ %>
<label>Report Collected By</label> <%}else{ %> <label>Sample
Validated By</label> <%} %> <%if(dgDetails.getSampleCollectionHeader().getValidatedBy() != null) {
%> <input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
	value="<%=dgDetails.getSampleCollectionHeader().getValidatedBy().getId() %>" />
<label class="value"> <%=dgDetails.getSampleCollectionHeader().getValidatedBy().getFirstName()+" "+ dgDetails.getSampleCollectionHeader().getValidatedBy().getLastName() %></label>
<%}else { %> <input type="hidden" id="<%=EMPLOYEE_ID %>"
	name="<%=EMPLOYEE_ID %>" value="" /> <label class="value">-</label> <%} %>
<div class="clear"></div>
<label>Brief Clinical Notes</label> <%if(dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() != null){ %>
<label class="valueAuto"><%=dgDetails.getSampleCollectionHeader().getOrder().getClinicalNote() %></label>
<%}else{ %> <label class="valueAuto">-</label> <%} %>
<div class="clear"></div>

<input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /></div>

<div class="clear"></div>
<!-- Block Three Ends  -->
<div class="paddingTop15"></div>
<div class="Block"> <label>Growth</label>
	<input type="radio" class="radioCheck" name="screenSens" value="g"  checked="checked" onclick="showDiv();""/>
	<label>Other</label>
	<input type="radio" class="radioCheck" name="screenSens" value="o" onclick="showDiv();" "/>
	<div class="clear"></div></div>
<script type="text/javascript">
		function showDiv()
		{
		if(document.sensitivity.screenSens[0].checked)
		{
		
			if(document.getElementById("growthDiv").style.display=="none")
				{
					document.getElementById("otherDiv").style.display="none";
					document.getElementById("growthDiv").style.display="block";
					
				}
		}
		if(document.sensitivity.screenSens[1].checked)
		{
	
			if(document.getElementById("otherDiv").style.display=="none")
				{
					
					document.getElementById("growthDiv").style.display="none";
					document.getElementById("otherDiv").style.display="block";
					
				}
		}
		
		}
		</script> <!--  -->
<div class="clear"></div>
<div class="division"></div>
<table border="0" cellspacing="0" width="100%" cellpadding="0">

	<tr>
		<%if(deptType.equalsIgnoreCase("DIAG")){ %>
		<th width=7%>Sample</th>
		<%}%>
		<th scope="col">Test Name</th>

		<%

Set<DgMasInvestigation> masSet= new HashSet<DgMasInvestigation>();
Set<DgTemplate> templateSet= new HashSet<DgTemplate>();
DgMasInvestigation masInv = new DgMasInvestigation();
String normalValue="";
String charge="";
int chargeId=0;
int investigationId=0;
String resultType="";
String result="";
int i =0;
for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
masInv = dgCollection.getInvestigation();
templateSet = masInv.getDgTemplates();

if(dgCollection.getInvestigation().getChargeCode()!= null)
{
charge=dgCollection.getInvestigation().getChargeCode().getChargeCodeName();
chargeId=dgCollection.getInvestigation().getChargeCode().getId();
investigationId =dgCollection.getInvestigation().getId();
resultType = dgCollection.getInvestigation().getInvestigationType();
}
 

i++;

%>

		<tr>
			<%if(deptType.equalsIgnoreCase("DIAG")){ %>
			<td>
			<%if(dgCollection.getSample() != null){ %> <label
				name=<%=SAMPLE_CODE %> id=<%=SAMPLE_CODE %>><%=dgCollection.getSample().getSampleDescription() %></label>
			<%}else{ %> <label name=<%=SAMPLE_CODE %> id=<%=SAMPLE_CODE %>>-</label>
			<%} %>
			</td>
			<%} %>
			<td><input name="<%=RESULT_TYPE %>" id="<%=RESULT_TYPE %>"
				value="v" type="hidden"><input name="<%=INVESTIGATION_ID %>"
				id="<%=INVESTIGATION_ID %>" value=<%= investigationId%>
				type="hidden"><input name="<%=CHARGE_CODE_ID %>"
				id="<%=CHARGE_CODE_ID %>" value=<%= chargeId%> type="hidden"><input
				name="<%=DG_SAMPLE_DETAIL_ID %>" id="<%=DG_SAMPLE_DETAIL_ID %>"
				value=<%= dgCollection.getId()%> type="hidden"> <%if(dgCollection.getInvestigation().getInvestigationName() !=null){
%> <label><%=dgCollection.getInvestigation().getInvestigationName() %></label>
			<input name="<%=INVESTIGATION_NAME %>" type="hidden"
				value="<%=dgCollection.getInvestigation().getInvestigationName() %>"
				readonly /> <%}else { %> <label>-</label> <input
				name="<%=INVESTIGATION_NAME %>" type="hidden" value="" readonly />
			<%} %> <%} %>
			
		</tr>
</table>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div id="otherDiv" style="display: none;">
<div class="clear"></div>
<div class="tableAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Result 1</th>

	</tr>
	<tr>
		<td><textarea name="result1"></textarea></td>

	</tr>

</table>
</div>
<div class="paddLeft35">
<div class="tableAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Result 2</th>
	</tr>
	<tr>
		<td><textarea name="result2"></textarea></td>
	</tr>
</table>
</div>
</div>
<div class="division"></div>
</div>


<!--  -->

<div id="growthDiv" style="display: block;">
<div class="clear"></div>
<div class="tableAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Organism Group</th>
	</tr>
	<tr>
		<td><select name="organism" id="organismId" class="list"
			multiple="multiple" size="10" validate="Result Entered By,string,no"
			tabindex=1 onchange="fillOrganism();">
			<%for(DgMasOrganismGroup dgMasOrganismGroup : dgMasOrganismGroupList ){ %>
			<option value="<%=dgMasOrganismGroup.getId() %>"><%=dgMasOrganismGroup.getOrganismGroupName() %></option>
			<%} %>
		</select></td>
	</tr>
</table>
</div>
<!--Start of Organism Div-->
<div id="organismDiv">
<div class="paddLeft35">
<div class="tableAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th width="8%" scope="col">&nbsp;</th>
		<th colspan="2" scope="col">Organism</th>
	</tr>

	<tr>
		<td>&nbsp;</td>
		<td width="9%">&nbsp;</td>
		<td width="71%">&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

</table>

</div>
</div>
</div>
<!--End of Organism Div-->
<div class="clear"></div>
<div class="division"></div>

<div class="tableAuto"><!--Start of Sensitivity Div-->
<div id="sensitivityDiv">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th width="7%" scope="col">&nbsp;</th>
		<th colspan="2" scope="col">Sensitivity</th>
		<th width="12%" scope="col">&nbsp;</th>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td width="9%">&nbsp;</td>
		<td width="72%">&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</div>
<!--End of Organism Div--></div>
</div>
<!--  -->



<div class="tableAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Remarks</th>
	</tr>
	<tr>
		<td>
		<%if(dgDetails.getRemarks() != null && dgDetails.getRemarks() !=""){ %>
		<textarea name="remarks" onkeyup="chkLength(this,100);"><%=dgDetails.getRemarks() %></textarea>
		<%}else{ %> <textarea name="remarks" onkeyup="chkLength(this,100);"></textarea>
		<%}%>
		</td>
	</tr>
</table>

</div>

<div class="clear"></div>
<div class="division"></div>

<div class="tableAuto">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>

		<th scope="col" colspan="2">NOSOCOMIAL</th>

	</tr>
	<tr>
		<td><label>Yes</label> <input type="radio" class="small"
			checked="checked" name="NOSOCOMIAL" value="Y"></td>
		<td><label>No</label> <input type="radio" class="small"
			name="NOSOCOMIAL" value="N"></td>
	</tr>
</table>
</div>


<div class="clear"></div>
<!-- Table Ends -->

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" class="button" value="Submit" id="addbutton"
	onclick="submitForm('sensitivity','investigation?method=saveSensitivity');"
	align="right" /> <input name="Reset" type="button" id="reset"
	class="buttonHighlight" value="Reset" onclick="resetResult();" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!--Bottom labels starts-->
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<div class="clear"></div>
<div class="paddingTop40"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

