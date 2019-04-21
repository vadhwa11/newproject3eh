<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>
<script type="text/javascript">
	ddaccordion.init({
		headerclass: "expandable", //Shared CSS class name of headers group that are expandable
		contentclass: "categoryitems", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
		defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "normal", //speed of animation: "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
</script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">

	function showJSP(formName)
	{
  		obj = eval('document.'+formName)
  		obj.action = "/hms/hms/opd?method=viewGastroEnterologyEndoscopy&flag=prev&viewScreen=no";
 		obj.submit();
	}
	function showBackJSP(formName)
	{
  		obj = eval('document.'+formName)
  		obj.action = "/hms/hms/opd?method=showWaitingPatientListJsp";
 		obj.submit();
	}
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

</script>
<script type="text/javascript">
function blankSpace()
{

var b1 = document.getElementById('b1').value ;
var b2 = document.getElementById('b2').value ;
var b3= document.getElementById('b3').value ;
var b4 = document.getElementById('b4').value ;
var b5= document.getElementById('b5').value ;
var b6 = document.getElementById('b6').value ;
var b8 = document.getElementById('b8').value ;
var b9 = document.getElementById('b9').value ;


if((b1=="0")&&(b2=="")&&(b3=="")&&(b9==0)&&(b4=="")&&(b5=="")&&(b6=="")&&(b8==""))
{
	alert("Please give some fields.");
	return false;
}
else
{
	return true;
}
}
</script>

<%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
			}

		 List patientDataList = new ArrayList();
			
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}			

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	
	Visit visit=(Visit)patientDataList.get(0);
	int hinId=visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();
	
	
	String patientName="";
	if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
	}
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());

	 
	 List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	 if(map.get("employeeList") != null){
			employeeList = (List<MasEmployee>) map.get("employeeList");
		}
%>
<!--main content placeholder starts here-->
<form name="gastroEnterologyEndoscopy" action="" method="post">
<input	type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=visit.getDepartment().getId() %>" />
	<%if(visit.getDepartment()!= null)
	{ 
	%>
<div class="titleBg">
<h2>Gastro Enterology Endoscopy</h2>
</div>
<div class="clear"></div>
<%} %>
 <!--Block One Starts-->
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label> 
<%
if(visit.getHin().getHinNo()!= null){ 
%>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label> 
<%
}else{
	%>
<label class="valueMedium">-</label> 
<%} %> 
<label>Patient Name </label> 
<%
if(patientName!= null){ 
%>
<label class="value"><%=patientName %> </label> 
<%}else{ %> 
<label
	class="value">- </label> 
	<%} %> 
	<label class="medium">Age</label> 
	<%if(visit.getHin().getAge()!= null){
		%>
<label class="valueMedium"><%=visit.getHin().getAge() %></label> 
<%
}else{ 
%>
<label class="valueMedium">-</label> 
<%} %> 
<label class="medium">Visit Date </label> 
<%
if(visitDateInString != null){ %> 
<label class="valueMedium"><%=visitDateInString %></label>
<%
}else{ 
%> 
<label class="valueMedium">-</label> 
<%} %>
<div class="clear"></div>
<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no") %></label>
 <%
 if(visit.getVisitNo()!= null){ 
 %>
<label class="valueMedium"><%=visit.getVisitNo() %></label> 
<%
}else{ 
%> 
<label	class="valueMedium">-</label> 
	<%} %> 
	<label>Token No. </label> 
	<%
	if(visit.getTokenNo()!= null){ 
	%>
<label class="value"><%=visit.getTokenNo() %></label> 
<%
}else{
	%> 
	<label>-</label>
<%} %>
 <label class="medium">Prev. Diag </label> 
 <%
 if(visit.getDiagnosis()!= null){ 
 %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ 
%> 
<label class="value">-</label> <%} %>
<div class="clear"></div>
</div>
<div class="division"></div>
<!--Block one Ends--> <%
			String reportNo = "";
			if(map.get("reportNo") != null){
				reportNo = (String)map.get("reportNo");
			}
			
		%>

<div class="Block">
<label>Report No </label> 
<input type="text" value="<%=reportNo%>" name="<%=REPORT_NO %>" class="readonly"
	readonly="readonly" /> 
	<label>Report Date </label>
	 <label	class="value"><%=date %></label>
<div class="clear"></div>
<label>Refered By</label> 
<select id="b1" name="<%=EMPLOYEE_ID %>"	validate="Refered By,string,no">
	<option value="0">Select</option>
	<%
							for (MasEmployee masEmployee : employeeList) {
						%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+ masEmployee.getMiddleName()+ masEmployee.getLastName()%></option>
	<%
						}
					%>
</select> 
<label>Diagnosis</label> <%if(visit.getDiagnosis()!= null){ %> 
<label	class="value"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> 
<label class="value">-</label> <%} %>
<div class="clear"></div>
<label>Esophagus</label> 
<input type="text" value="" class="large"	name="<%=ESOPHAGUS %>" id="b2" />
<div class="clear"></div>
<label>Stomach</label> <input type="text" value="" class="large"	name="<%=STOMACH %>" id="b3" />
<div class="clear"></div>
<label>Duodenum</label> 
<input type="text" value="" class="large"	name="<%=DUODENUM %>" id="b4" />
<div class="clear"></div>
<label>Biopsy</label> 
<input type="text" value="" class="large"	name="<%=BIOPSY %>" id="b5" />
<div class="clear"></div>
<label>Gastric antum for H Pylori</label> 
<select id="b6"	name="<%=GASTRIC_ANTUM_FOR_H_PYLORI %>">
	<option value="0">Select one</option>
	<option value="RUT">RUT</option>
	<option value="HPE">HPE</option>
</select>
<div class="clear"></div>
<label>Other/Remarks</label> 
<input type="text" value="" class="large" name="<%=OTHERS_REMARKS %>" id="b8" />
<div class="clear"></div>
<label>Final diagnosis</label> 
<input type="text" value="" class="large"	name="<%=FINAL_DIAGNOSIS %>" id="b9" />
<div class="clear"></div></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"	onclick="submitForm('gastroEnterologyEndoscopy','opd?method=addGastroEnterologyEndoscopy','blankSpace');" align="right" />
<input type="button" class="button" value="View"	onclick="showJSP('gastroEnterologyEndoscopy');" /> 
<input name="Back"	type="button" src="images/phaseII/delete.gif" alt="Back" value="Back"	class="button" onclick="history.go(-1);return false;" align="right" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName %></label>
<label>Changed Date</label> 
<label class="value"><%=date%></label> 
<label>Changed Time</label> 
<label class="value"><%=time%></label>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>"> 
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input	type="hidden" name="<%=VISIT_NUMBER %>"	value="<%=visit.getVisitNo() %>">
<input type="hidden" name="currentVisitId" value="<%=visit.getId() %>"></form>

</div>


