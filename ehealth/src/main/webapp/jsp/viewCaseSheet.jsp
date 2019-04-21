<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdVaccinationPlan"%>
<%@page import="jkt.hms.masters.business.OpdCaseSheet"%>

<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
</script>
<script>
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
<!--main content placeholder starts here-->
<div id="contentHolder">
<form name="pediatricCaseSheet" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	List<Visit> patientDataList = new ArrayList<Visit>();
	List<OpdCaseSheet> opdCaseSheetList = new ArrayList<OpdCaseSheet>();
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	if(detailsMap.get("patientDataList") != null){
		patientDataList=(List<Visit>)detailsMap.get("patientDataList");
	}	
	if(map.get("opdCaseSheetList") != null){
		opdCaseSheetList=(List<OpdCaseSheet>)map.get("opdCaseSheetList");
	}	
	int currentVisitId = 0;
	if(map.get("currentVisitId") != null){
		currentVisitId = (Integer)map.get("currentVisitId");
	}
	 List opdVaccinationPlanList = new ArrayList();
		if(map.get("opdVaccinationPlanList") != null){
			opdVaccinationPlanList=(List)map.get("opdVaccinationPlanList");
		}
%> <%

	Visit visit = new Visit();
	if(patientDataList.size() > 0){
		visit = patientDataList.get(0);
	}
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
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

	
%> <!--main content placeholder starts here-->

<form name="pediatricCaseSheet" action="" method="post">
 	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=visit.getDepartment().getId() %>" /> <%if(visit.getDepartment()!= null){ %>
<div class="titleBg">
<h2>Pediatric Case Sheet</h2>
</div>
<div class="clear"></div>
<%} %> <!--Block One Starts-->
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label> 
<%
if(visit.getHin().getHinNo()!= null)
{ 
%>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label>
 <%
 }
else
{
	%>
<label class="valueMedium">-</label> 
<%
} 
%> 
<label>Patient Name </label> 
<%
if(patientName!= null)
{ 
%>
<label class="value"><%=patientName %> </label>
 <%
 }
else
{ 
%> 
<label	class="value">- </label> 
<%
} 
%> 
<label class="medium">Age</label> 
<%
if(visit.getHin().getAge()!= null)
{
	%>
<label class="valueMedium"><%=visit.getHin().getAge() %></label> 
<%}else{ %>
<label class="valueMedium">-</label> <%} %> 
<label class="medium">Visit Date </label> 
<%
if(visitDateInString != null)
{ 
%> 
<label class="valueMedium"><%=visitDateInString %></label>
<%}
else{ %> 
<label class="valueMedium">-</label> 
<%} %>
<div class="clear"></div>
<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no") %> </label> 
<%
if(visit.getVisitNo()!= null){ 
%>
<label class="valueMedium"><%=visit.getVisitNo() %></label> 
<%}else{ %>
 <label	class="valueMedium">-</label> 
 <%} %> 
 <label>Token No. </label> 
 <%if(visit.getTokenNo()!= null){ 
 %>
<label class="value"><%=visit.getTokenNo() %></label> 
<%}else{ %> 
<label>-</label>
<%} %> 
<label class="medium">Prev. Diag </label> 
<%
if(visit.getDiagnosis()!= null)
{
	%>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
</div>
<!--Block one Ends--> <!--Block two Start-->
<div class="clear"></div>
<div class="division"></div>
<!--Block one Ends--> <% 
if(opdCaseSheetList.size() > 0){
	OpdCaseSheet opdCaseSheet = new OpdCaseSheet();
	opdCaseSheet = opdCaseSheetList.get(0);
	%> <!--Block one Ends-->
<h4>Vaccine Plan</h4>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<div class="tableHolderAuto">
<%
if(opdVaccinationPlanList.size()!=0) { 
Iterator itrObj=opdVaccinationPlanList.iterator();
%>
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">
	<tr>
		<th width="7%">Vaccine</th>
		<th width="10%">Vaccine Date</th>
		<th width="7%">Completion Date</th>
		<th width="7%">Remarks</th>
	</tr>
	<%      int i=1;
while(itrObj.hasNext())
{
OpdVaccinationPlan opdVaccinMstObj=(OpdVaccinationPlan)itrObj.next();
%>
	<tr>
		<td width="7%">
		<input type="hidden" name="<%=VACCINATION_ID %>" value="<%=opdVaccinMstObj.getId() %>" id="vaccinationId<%=i %>">
		<input type="hidden" value="<%=opdVaccinMstObj.getVaccin().getId() %>" name="<%=VACCINE_ID%>" id="vaccineId<%=i %>"	validate="Vaccine Id,num,no" /> 
		<input type="text" size="12" tabindex="1" name="<%=VACCINE_NAME%>"			value="<%=opdVaccinMstObj.getVaccin().getVaccinName() %>"			id="vaccineCode<%=i %>" validate="Vaccine,string,no" readonly /></td>
		<td width="10%">
		<%if(opdVaccinMstObj.getVaccinDate()==null)
	{
	%> 
	<input type="text" value="" id="totalId<%=i %>" size="8" validate="Vaccine Date" tabindex="1" name="<%=VACCINE_DATE 
%>"readonly="readonly" /> 
<%} else{%> 
<input type="text"	value="<%=HMSUtil.changeDateToddMMyyyy(opdVaccinMstObj.getVaccinDate()) %>"	id="totalId<%=i %>" size="8" validate="Vaccine Date" tabindex="1"name="<%=VACCINE_DATE %>" readonly="readonly" /> <%} %>
		</td>
		<td width="7%">
		<%if(opdVaccinMstObj.getVaccinCompleteDate()==null)
{
%> 
<input type="text" id="CompletionDate<%=i %>" tabindex="1"	name="<%=COMPLETION_DATE %>" value="" readonly="readonly" onblur="checkDate
(<%=i %>)" size="8" /> <%} 
		else{%> 
		<input type="text" id="CompletionDate<%=i %>" tabindex="1" name="<%=COMPLETION_DATE %>"	value="<%=HMSUtil.changeDateToddMMyyyy(opdVaccinMstObj.getVaccinCompleteDate()) %>" readonly="readonly" onblur="checkDate(<%=i %>)" size="8" /> 
		<%} %>
		</td>
		<td width="7%">
		<%if(opdVaccinMstObj.getRemarks()==null)
{
%>
 <input type="text" id="remarks<%=i %>" tabindex="1"
			name="<%=REMARKS %>" value="" size="10" readonly="readonly"
			validate="Remarks,String,no" /> 
<%} else{%> 
<input type="text" id="remarks<%=i %>" size="10" tabindex="1" name="<%=REMARKS %>" value="<%=opdVaccinMstObj.getRemarks() %>" readonly="readonly" validate="Remarks,String,no" /> 
<%} %>
		</td>
	</tr>
	<%
i++;}
}  else {
%>
</table>
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">
	<tr>
		<th width="7%">Vaccine</th>
		<th width="10%">Vaccine Date</th>
		<th width="7%">Completion Date</th>
		<th width="7%">Remarks</th>
	</tr>
	<tr>
		<td width="7%">
<input type="text" tabindex="1"	name="<%=VACCINE_NAME%>2" value="" size="12" id="vaccineCode" validate="Vaccine,string,no" readonly /></td>
		<td width="10%">
			<input type="text" value="" id="totalId" size="8" validate="Vaccine Date" tabindex="1" name="<%=VACCINE_DATE %>" readonly="readonly" /></td>
		<td width="7%">
			<input type="text" id="CompletionDate"tabindex="1" name="<%=COMPLETION_DATE %>" value="" size="8" readonly="readonly" /></td>
		<td width="7%">
			<input type="text" id="remarks" tabindex="1"			name="<%=REMARKS %>" value="" readonly="readonly"			validate="Remarks,String,no" size="10" /></td>
		<%}%>
	</tr>
</table>
</div>
<div class="clear"></div>
</div>
<div class="division"></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Date of Birth</label>
 <%
 if(opdCaseSheet.getDob()!=null){ 
	String dobInString =HMSUtil.changeDateToddMMyyyy(opdCaseSheet.getDob());
%> 
<input type="text" id="startDateId" name="<%=DATE_OF_BIRTH%>" value="<%=dobInString%>" class="readOnly" readonly="readonly"	validate="Date Of Birth,date,no" MAXLENGTH="30" tabindex="1" /> 
<%}else{ %>
<label class="value">- </label>
 <%} %> 
<label>Referred By</label> 
<%
if(opdCaseSheet.getReferedBy()!=null)
{ 
%>
<label class="value"><%=opdCaseSheet.getReferedBy().getFirstName() %><%=opdCaseSheet.getReferedBy().getMiddleName() %><%=opdCaseSheet.getReferedBy().getLastName() %></label>
<%}else{ %> 
<label class="value">- </label> 
<%} %>
<div class="clear"></div>
<label>Wt</label> 
<input type="text" id="b10" name="<%=WEIGHT %>"	value="<%=opdCaseSheet.getWt() %>" readonly="readonly"	class="readOnlySmall" validate="Wt,num,no" MAXLENGTH="4" tabindex="1" />
<label	class="small">(19.8-39.7)</label> 
<label>Ht</label>
<input type="text"	id="b11" name="<%=HEIGHT %>" value="<%=opdCaseSheet.getHt() %>"	readonly="readonly" class="readOnlySmall" validate="Ht,num,no"MAXLENGTH="4" tabindex="1" />
<label class="small">(119-144)</label> 
<label>Hc</label>
<input type="text" id="b12" name="<%=HIV %>" value="<%=opdCaseSheet.getHc() %>" readonly="readonly" class="readOnlySmall" validate="Hc,num,no" MAXLENGTH="4" tabindex="1" />
<label class="small">(119-144)</label>
<div class="clear"></div>
<label>OFC</label> 
<input type="text" id="b22" name="<%=OFC%>" class="readOnly" readonly="readonly" value="<%=opdCaseSheet.getOfc() %>" validate="OFC,float,no" MAXLENGTH="5" tabindex="1" /> 
<label class="small">cm</label> 
<label>RR</label>
<input type="text" id="b23" name="<%=RR%>" class="readOnly" readonly="readonly" value="<%=opdCaseSheet.getRr() %>" validate="RR,float,no" MAXLENGTH="5" tabindex="1" /> 
<label
	class="small">min</label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<!--tab content starts-->
<ul id="countrytabs" class="shadetabs">
	<li><a href="#" rel="country1" class="selected">Clinical Notes</a></li>
	<li><a href="#" rel="country2">Exp. HT</a></li>
	<li><a href="#" rel="country3">BMI</a></li>
</ul>
<div class="tabcontainer">
<div id="country1" class="tabcontent">
<label></label> 
<label	class="valueTextarea" readonly="readonly"><%=opdCaseSheet.getClinicalNote() %></label>
<div class="clear"></div>
</div>
<div id="country2" class="tabcontent">
<div class="paddLeft30">
<label class="common">Father</label><!-------->
<label	class="common">Mother</label></div>
<div class="clear"></div>
<label>Height in CM</label><!--------> 
<input id="b3" type="text"	readonly="readonly" maxlength="3" value="<%=opdCaseSheet.getHeightInCmFather() %>"	name="<%=HEIGHT_IN_CM_FATHER %>" class="readOnly"	validate="Height in CM Father,num,no" />
<div class="paddLeft50"><input id="b4" type="text"	readonly="readonly" name="<%=HEIGHT_IN_CM_MOTHER %>"	value="<%=opdCaseSheet.getHeightInCmMother() %>" maxlength="3" class=""	readOnly"" validate="Height in CM Mother,num,no" /></div>
<div class="clear"></div>
<label>Child's Age</label> 
<input id="b5" type="text"	readonly="readonly" value="<%=opdCaseSheet.getAge() %>" maxlength="2"	name="<%=AGE %>" class="readOnly" validate="Child's Age,num,no" />
<div class="paddLeft50">
<input type="button" class="button"	value="Calculate" onclick="calculated();" />
</div>
<input type="button" class="button" value="History"	onclick="submitForm('pediatricCaseSheet','opd?method=showPatientHistoryJsp&visitId=<%=visit.getId() %>');" />
<div class="clear"></div>
<div class="Height10"></div>
<div class="paddLeft30"><label class="common">Child</label></div>
<div class="clear"></div>
<div class="Height10"></div>
<label>Height in CM</label>
<input id="b6" type="text"	name="<%=HEIGHT_IN_CM_CHILD %>"	value="<%=opdCaseSheet.getHeightInCmChild() %>" maxlength="3" class="readOnl" " validate="Height in CM Child,num,no" readonly="readonly" />
<div class="clear"></div>
<label>3rd Percentile</label> 
<input id="b7" type="text" name="<%=RD_PERCENDTILE %>" value="<%=opdCaseSheet.getRdPercentile() %>" maxlength="20" class="readOnly" validate="3rd Percentile,num,no" readonly="readonly" />
<div class="clear"></div>
<label>97th Percentile</label> 
<input id="b8" type="text"	name="<%=TH_PERCENDTILE %>"	value="<%=opdCaseSheet.getThPercentile() %>" maxlength="20"	class="readOnly" validate="97th Percentile,num,no" readonly="readonly" />
<div class="clear"></div>
<label>Remarks</label> 
<textarea maxlength="50"	onkeyup="return ismaxlength(this)"	value="<%=opdCaseSheet.getRemarks() %>" readonly="readonly"	name="<%=REMARKS_TEMP %>" id="b9"></textarea>
<div class="clear"></div>
</div>
<div id="country3" class="tabcontent">
<div class="paddLeft25">
<label class="auto"> <u>Bodymass index (BMI)</u> is measure of body fat based on height and weight that applies to both adult men and women. </label>
<div class="clear"></div>
<label class="valuenoWidth"> <b><u>BMI Categories</u></b> </label>
<div class="clear"></div>
<li>Normal weight = 18.5-24.9</li>
<li>Overweight = 25-29.9</li>
<li>Obesity = BMI of 30 or greater</li>
</div>
<TABLE WIDTH="600" CELLPADDING="0" CELLSPACING="0" BORDER="0"
	SUMMARY="This table is used for layout purposes only.">
	<TR>
		<TD ALIGN="LEFT"></TD>
	</TR>
	<TR>
		<TD COLSPAN="2" ALIGN="LEFT"></TD>
	</TR>
</TABLE>
<div class="clear"></div>
<TABLE WIDTH="600"
	SUMMARY="This table is used for layout purposes only.">
	<TR>
		<TD>
		<TABLE BORDER="0" CELLSPACING="0" WIDTH="185" BGCOLOR="#FFFFFF"	CELLPADDING="2"	SUMMARY="This table is used for layout purposes only.">
			<TR>
				<TD COLSPAN="2" ALIGN="center">
				<TABLE CELLSPACING="0" CELLPADDING="0" BORDER="0" WIDTH="143"		SUMMARY="This table is used for layout purposes only.">
					<TR>
						<TD ROWSPAN="3" ALIGN="right" WIDTH="50">
						<IMG SRC="/hms/jsp/images/BMI/bmi_1-4.gif" ALT=" " WIDTH="36"HEIGHT="201"></TD>
						<TD VALIGN="top" WIDTH="50">
						<img src="/hms/jsp/images/BMI/bmi_2-4.gif" alt=" " width="50" height="76" /></TD>
						<TD ROWSPAN="3" ALIGN="left" WIDTH="92">
						<IMG SRC="/hms/jsp/images/BMI/bmi_4-4.gif" ALT=" " WIDTH="57" HEIGHT="201"></TD>
					</TR>
					<TR>
						<TD ALIGN="center">
						<INPUT NAME="bmiS" TYPE="text" value="<%=opdCaseSheet.getBmi()%>" readonly="readonly" SIZE="10" 	STYLE="width: 30px; float: none;" id="yourbmi"></TD>
						</TR>
					<TR>
						<TD VALIGN="bottom">
						<img src="/hms/jsp/images/BMI/bmi_3-4.gif" alt=" " width="50" height="96" /></TD>
					</TR>
				</TABLE>
				</TD>
			</TR>
			<TR>
				<TD WIDTH="50%"><SPAN STYLE="font-size: 10pt;">
				<B><LABEL FOR="htcS">&nbsp;Your Height:</LABEL></B></SPAN></TD>
				<TD WIDTH="50%" ALIGN="left">
				<INPUT TYPE="text" NAME="htcS" size="3" ID="htcS" MAXLENGTH="4" readonly="readonly" value="<%=opdCaseSheet.getHt() %>" validate="Height,num,no" onblur="heightValidation1();" onmousedown="heightValidation1();">
				</TD>
							</TR>
			<TR>
				<TD WIDTH="50%"><SPAN STYLE="font-size: 10pt;">&nbsp;</SPAN></TD>
				<TD WIDTH="50%" ALIGN="left"><B><SPAN
					STYLE="font-size: 10pt;"> (centimeters)</SPAN></B></TD>
			</TR>
			<TR>
				<TD WIDTH="50%">
				<SPAN STYLE="font-size: 10pt;">
				<B>
				<LABEL FOR="kgS">&nbsp;Your Weight:</LABEL></B></SPAN></TD>
				<TD WIDTH="50%" ALIGN="left">
				<P>
				<INPUT TYPE="text" NAME="kgS" size="3" MAXLENGTH="4" ID="kgS"	readonly="readonly" value="<%=opdCaseSheet.getWt() %>"	validate="Weight,num,no" onblur="weightValidation1();"	onmousedown="weightValidation1();"></P>
				</TD>
			</TR>
			<TR>
				<TD WIDTH="50%"><SPAN STYLE="font-size: 10pt;">&nbsp;</SPAN></TD>
				<TD WIDTH="50%" ALIGN="left"><B><SPAN	STYLE="font-size: 10pt;"> (kilograms)</SPAN></B></TD>
			</TR>
			<TR>
				<TD COLSPAN="2" ALIGN="center"></TD>
			</TR>
		</TABLE>
		<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="10" WIDTH="600">
			<TR>
				<TD VALIGN="top" COLSPAN="3"></TD>
			</TR>
			<TR>
				<TD VALIGN="top"></TD>
				<TD ALIGN="center" VALIGN="top"></TD>
				<TD VALIGN="top"></TD>
			</TR>
			<TR>
				<TD VALIGN="top">&nbsp;</TD>
				<TD ALIGN="center" VALIGN="top"></TD>
				<TD VALIGN="top">&nbsp;</TD>
			</TR>
		</TABLE>
		</TD>
	</TR>
</TABLE>

</div>
</div>
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>

<div class="clear"></div>
<div class="division"></div>
<input name="prev" type="button" class="button" value="Prev"	onclick="submitForm('pediatricCaseSheet','opd?method=viewPediatricCaseSheet&flag=prev');">
<input name="next" type="button" class="button" value="Next"	onclick="submitForm('pediatricCaseSheet','opd?method=viewPediatricCaseSheet&flag=next');">
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
%> 
<input name="Back" type="button" src="images/phaseII/delete.gif"	alt="Back" value="Back" class="button"	onclick="submitForm('pediatricCaseSheet','opd?method=showPediatricCaseSheetJsp&visitId=<%=visit.getId() %>');"	align="right" />
<div class="clear"></div>
<div class="division"></div>
</div>
<%}%>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label>
<div class="clear"></div>

<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>"> 
<input type="hidden"	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> 
<input	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<div class="paddingTop40"></div>
<script type="text/javascript">
function showVaccination(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/opd?method=showPediatricVaccinationPlanJsp&visitId=<%=visit.getId()%>";
  obj.submit();
}
</script>
<%}else{%>
<h4>No Record Found!!</h4>
<div clas="clear"></div>
<div class="division"></div>
<div clas="clear"></div>
<input name="Back" type="button"	src="images/phaseII/delete.gif" alt="Back" value="Back" class="button"	onclick="submitForm('pediatricCaseSheet','opd?method=showPediatricCaseSheetJsp&visitId=<%=visit.getId() %>');" align="right" />
<div clas="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div clas="clear"></div>
</div>
<!--Bottom labels ends-->
<%} %>
<div class="clear"></div>

</form>