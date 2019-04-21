<%@page import="jkt.hms.masters.business.DgHistoSampleCollectionDetails"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.DgSampleCollectionDetails"%>
<%@page import="jkt.hms.masters.business.DgTemplate"%>
<%@page import="jkt.hms.masters.business.DgResultEntryDetail"%>
<%@page import="org.apache.commons.codec.binary.Base64"%>


<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<!-- 
Include the WYSIWYG javascript files
-->
<script type="text/javascript" src="/hms/jsp/js/wysiwyg.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-color.js"></script>
<script type="text/javascript" src="/hms/jsp/js/wysiwyg-settings.js"></script>
<!-- 
Attach the editor on the textareas
-->
<script type="text/javascript">
// Use it to attach the editor to all textareas with full featured setup
//WYSIWYG.attach('all', full);

// Use it to attach the editor directly to a defined textarea

WYSIWYG.attach('abc', full); // full featured setup

// Use it to display an iframes instead of a textareas
//WYSIWYG.display('all', full);  
</script>



<script type="text/javascript">
	function chkLength(field,maxLimit)
	{
	if(field.value.length > maxLimit)
	{
	 alert('you crossed the maximum limit of '+maxLimit+' characters');
	 var val=field.value.substring(0,maxLimit);
	 field.value=val;
	 //alert(field.value);
	}
}
  function resetResult(){
 
	   document.getElementById('abc').value="";
	   document.getElementById('additionalRemarks').value="";
	   
   }
function see()
{
document.sampleCollection.method="post";
  
				// alert(updatedtemplate);
				  var hinNo=document.getElementById("hinNo").value;
				  var inpatientId=document.getElementById("inpatientId").value;
				 var sampleCollectionDetailId = document.getElementById("<%=DG_SAMPLE_DETAIL_ID%>").value;
				// var sampleCollectionDetailId= document.getElementById("sampleCollectionDetailId").value;
				 var departmentId=document.getElementById("departmentId").value;
			fName=document.getElementById("upload").value;
				var extension =fName.substring(fName.length-4);
			if(fName !=""){
	if( extension != '.txt' && extension != '.TXT' && extension !='.rtf')
	{	
		//alert("Uploaded Document can only be in .txt or .TXT format\n");
	//return false;
	}
	var updatedtemplate= sampleCollection.test2.value;
 	sampleCollection.browse.value="browse";

	var combinedIds = document.getElementById('CombinedIds').value;
	var RESULT_ENTERED_BY=document.getElementById("<%=RESULT_ENTERED_BY%>").value;var SAMPLE_COLLECTION_ID=document.getElementById("<%=SAMPLE_COLLECTION_ID%>").value;
	var RESULT_NO=document.getElementById("<%=RESULT_NO%>").value;
	var DG_SAMPLE_DETAIL_ID=document.getElementById("<%=DG_SAMPLE_DETAIL_ID%>").value;
	

//window.location.href ='investigation?method=getFileName&sampleCollectionDetailId='+sampleCollectionDetailId+'&hinNo='+hinNo+'&inpatientId='+inpatientId+'&parameterName=fromResultEntry&formName=sampleCollection&test2='+updatedtemplate+'';
  //reportPreparedByObj = document.getElementById('<%= RESULT_ENTERED_BY  %>');
  //reportPreparedByObj.setAttribute("validate","Report Prepared By,string,no");
  
submitForm('sampleCollection','investigation?method=getFileNameForLab&resultNoTemplate='+RESULT_NO+'&resultEnteredBy='+RESULT_ENTERED_BY+'&dgSampleDetailIdForTemplate='+DG_SAMPLE_DETAIL_ID+'&CombinedIds='+combinedIds+'&parameterName=fromResultEntry&formName=sampleCollection&browseInResultEntry=browse&test2='+ updatedtemplate + "&" + csrfTokenName + "="+ csrfTokenValue); 
}
return true;
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
Map detailsMap = new HashMap();
int sampleCollectionDetailId = 0;
String resultSeqNo = "";
int resultEnteredBy = 0;
Map<String,Object> utilMap = new HashMap<String,Object>();
String CombinedIds = "";
List<DgMasInvestigation> investigationList = new ArrayList<DgMasInvestigation>();
List<DgSampleCollectionDetails> sampleCollectionList = new ArrayList<DgSampleCollectionDetails>();
List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
List<Patient> patientList = new ArrayList<Patient>();
List<DgResultEntryDetail> dgResultEntryDetailListForResult = new ArrayList<DgResultEntryDetail>();

utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
String appendedHtml = "";

List inPatientDetailList = new ArrayList();
Box box = HMSUtil.getBox(request);

String userName = "";
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
	
}
if(map.get("appendedHtml")!=null){
	appendedHtml=(String)map.get("appendedHtml");
}
if(map.get("pageNo") != null)
{
pageNo=(Integer)map.get("pageNo");
}
if(map.get("detailsMap") != null)
{
	detailsMap=(Map)map.get("detailsMap");
}
if(detailsMap.get("sampleCollectionDetailId") != null)
{
	sampleCollectionDetailId = (Integer)detailsMap.get("sampleCollectionDetailId");
}
if(detailsMap.get("resultEnteredBy") != null)
{
	resultEnteredBy = (Integer)detailsMap.get("resultEnteredBy");
}
if(detailsMap.get("resultSeqNo") != null)
{
	resultSeqNo = (String)detailsMap.get("resultSeqNo");
}
if(detailsMap.get("CombinedIds") != null)
{
	CombinedIds = (String)detailsMap.get("CombinedIds");
}


if(map.get("pageNo") != null)
{
	detailsMap=(Map)map.get("detailsMap");
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

if(map.get("investigationList") != null){
investigationList = (ArrayList)map.get("investigationList");
}
if(map.get("dgResultEntryDetailListForResult") != null){
	dgResultEntryDetailListForResult = (List)map.get("dgResultEntryDetailListForResult");
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


Properties properties = new Properties();
URL resourcePath = Thread.currentThread().getContextClassLoader().getResource("adt.properties");
try {
	properties.load(resourcePath.openStream());
	} catch (Exception e) {
	e.printStackTrace();
}
%>
<script type="text/javascript">
   history.forward();
</script>
<!--main content placeholder starts here-->

<form name="sampleCollection" method="post"
	enctype="multipart/form-data" action="">
	<div class="clear"></div>
	<div class="clear"></div>

	<div class="titleBg">
		<h2>Result Entry</h2>
	</div>
	<%
	Set<DgHistoSampleCollectionDetails> histoCollectionDetailsSet=sampleCollectionList.get(0).getSampleCollectionHeader().getDgHistoSampleCollectionDetails();
	if(histoCollectionDetailsSet.size()>0){int count=1;%>
	<div class="cmntable">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">

			<tr>
				<th scope="col">S.No.</th>
				<th scope="col">Test Name</th>
				<th scope="col">Section Type</th>
				<th scope="col">Sample</th>
				<th scope="col">Container</th>
				<th scope="col">Remark</th>
				<th scope="col">Identification No.</th>
			</tr>
			<%for(DgHistoSampleCollectionDetails histoObj:histoCollectionDetailsSet){%>
			<tr>
				<td><%=count%></td>
				<td><label><%=histoObj
						.getChargeCode().getChargeCodeName()%></label></td>
				<%if("S".equalsIgnoreCase(histoObj.getOrderStatus())){%>
				<td><label>Specimen</label></td>
				<%}else if("G".equalsIgnoreCase(histoObj.getOrderStatus())){%>
				<td><label>Gross</label></td>
				<%}else if("B".equalsIgnoreCase(histoObj.getOrderStatus())){%>
				<td><label>Block</label></td>
				<%}else{%>
				<td><label>Slide</label></td>
				<%}%>

				<td><label><%=histoObj
									.getSample().getSampleDescription()%></label></td>
				<td>1</td>
				<td><label><%=histoObj
									.getRemarks()%></td>
				<td><%=histoObj.getIdentificationNo()%></td>
			</tr>
			<%count++;}%>
		</table>
	</div>
	<%} %>


	<%
String subDept = "";
String dept="";
int SubChargeId=0;
int mainChargeId=0;
String hinNo="";

for(DgSampleCollectionDetails dgCollection :sampleCollectionList){
	if(dgCollection.getInvestigation().getChargeCode().getSubChargecode()!= null){
		subDept = dgCollection.getInvestigation().getChargeCode().getSubChargecode().getSubChargecodeName();
		dept = dgCollection.getInvestigation().getMainChargecode().getMainChargecodeName();
		SubChargeId=dgCollection.getInvestigation().getChargeCode().getSubChargecode().getId();
		mainChargeId=dgCollection.getInvestigation().getChargeCode().getSubChargecode().getMainChargecode().getId();
		hinNo = dgCollection.getSampleCollectionHeader().getHin().getHinNo();
%>
	<%
	}
}%>
	<input name="<%= DEPARTMENT_ID %>" id="<%= DEPARTMENT_ID %>"
		type="hidden" value="<%=(Integer)session.getAttribute("deptId")%>" />
	<input name="<%= SAMPLE_COLLECTION_DETAIL_ID %>"
		id="<%= SAMPLE_COLLECTION_DETAIL_ID %>" type="hidden"
		value="<%=box.getInt( SAMPLE_COLLECTION_DETAIL_ID) %>" /> <input
		name="<%=SUB_CHARGECODE_ID %>" id="<%= SUB_CHARGECODE_ID%>"
		type="hidden" value="<%=SubChargeId %>" /> <input
		name="<%=MAIN_CHARGECODE_ID %>" id="<%= MAIN_CHARGECODE_ID%>"
		type="hidden" value="<%=mainChargeId %>" /> <input type="hidden"
		id="browse" name="browse" value="">
		<div class="clear"></div> <input type="hidden"
		name="<%=SAMPLE_COLLECTION_ID %>" id="<%= SAMPLE_COLLECTION_ID%>"
		value="<%=dgDetails.getSampleCollectionHeader().getId() %>" /> <input
		type="hidden" name="<%=TEST_ORDER_NO_TEMPLATE_VALUE%>"
		id="<%= TEST_ORDER_NO_TEMPLATE_VALUE%>"
		value="<%=dgDetails.getInvestigation().getTestOrderNo()%>" /> <!--Block One Starts-->

		<!--Block one Ends--> <!--Block Two Starts-->

		<div>
			<input type="hidden" name="<%=DEPARTMENT_ID %>"
				id="<%=DEPARTMENT_ID %>"
				value="<%=dgDetails.getSampleCollectionHeader().getDepartment().getId() %>" />
			<input type="hidden" name="<%=HIN_ID %>" id="<%=HIN_ID %>"
				value="<%=patient.getId() %>" /> <input type="hidden"
				name="<%=HIN_NO %>" id="<%=HIN_NO %>"
				value="<%=patient.getHinNo() %>" />
		</div> <%if(dgDetails.getSampleCollectionHeader().getInpatient() != null){ %>
		<input type="hidden" name="<%=INPATIENT_ID %>" id="<%=INPATIENT_ID %>"
		value="<%=dgDetails.getSampleCollectionHeader().getInpatient().getId()%>" />
		<%}else{ %> <input type="hidden" name="<%=INPATIENT_ID %>"
		id="<%=INPATIENT_ID %>" value="" /> <%} %> <!--Block Two Ends--> <!-- Block Three Starts -->

		<input type="hidden" name="<%=SAMPLE_COLLECTION_DATE%>"
		id="<%=SAMPLE_COLLECTION_DATE %>" value="<%=date%>" /> <input
		type="hidden" name="<%=SAMPLE_COLLECTION_TIME %>"
		id="<%=SAMPLE_COLLECTION_TIME %>" value="<%=time%>" /> <input
		type="hidden" name="<%=RESULT_NO %>" id="<%=RESULT_NO %>"
		value="<%=resultSeqNo %>" /> <input type="hidden"
		name="<%= RESULT_ENTERED_BY %>" id="<%= RESULT_ENTERED_BY %>"
		value="<%=resultEnteredBy%>" />

		<div class="clear"></div> <%if(dgDetails.getSampleCollectionHeader().getValidatedBy() != null) {
%> <input type="hidden" id="<%=EMPLOYEE_ID %>" name="<%=EMPLOYEE_ID %>"
		value="<%=dgDetails.getSampleCollectionHeader().getValidatedBy().getId() %>" />
		<%}else { %> <input type="hidden" id="<%=EMPLOYEE_ID %>"
		name="<%=EMPLOYEE_ID %>" value="" /> <%} %>
		<div class="clear"></div>

		<div class="clear"></div> <input type="hidden" value="0"
		name="pagecounter2" /> <input type="hidden" name="pageNo" id="pageNo"
		value="<%=pageNo%>" /> <input type="hidden" name="CombinedIds"
		id="CombinedIds" value="<%=CombinedIds%>" /> <!-- Block Three Ends -->
		<div class="clear"></div> <!-- Table Starts --> <%

Set<DgMasInvestigation> masSet= new HashSet<DgMasInvestigation>();
Set<DgTemplate> templateSet= new HashSet<DgTemplate>();
DgMasInvestigation masInv = new DgMasInvestigation();
String normalValue="";
String charge="";
int chargeId=0;
int investigationId=0;
String resultType="";
byte result[]=null;
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

%> <input name="<%=RESULT_TYPE %>" id="<%=RESULT_TYPE %>" value="t"
		type="hidden"> <input name="<%=INVESTIGATION_ID %>"
			id="<%=INVESTIGATION_ID %>" value=<%= investigationId%> type="hidden">
				<input name="<%=CHARGE_CODE_ID %>" id="<%=CHARGE_CODE_ID %>"
				value=<%= chargeId%> type="hidden"> <input
					name="<%=DG_SAMPLE_DETAIL_ID %>" id="<%=DG_SAMPLE_DETAIL_ID %>"
					value=<%= dgCollection.getId()%> type="hidden"> <label>Result</label>

						<input type="file" id="upload" name="<%=UPLOAD_FILENAME%>"
						class="Browse" size="50" onchange="see()"
						style="width: 150px; height: 22px;" /> <input type="button" id=""
						name="" class="buttonBig2" value="Upload/View Document" onclick="">
					</input>
						<div class="clear"></div>
						<h4>
							<span>(It will accept only html format.)</span>
						</h4>
						<div class="clear"></div>
						<div id="hiddenTextArea" style="display: none">
							<textarea id="appendedHtml" name="appendedHtml"><%=appendedHtml
 %></textarea>
						</div>
						<div id="rtf">
							<%if(dgResultEntryDetailListForResult.size() > 0){ %>
							<%if(session.getAttribute("browseInResultEntry")!=null){ 
  session.removeAttribute("browseInResultEntry"); %>
							<textarea value="" id="abc" name="test2"
								class="tableTextareaEditor"><%@include
									file="/temp/temp.html"%>  </textarea>
							<%}else if(dgResultEntryDetailListForResult.get(0).getResult() != null){
  String templateData= new String( dgResultEntryDetailListForResult.get(0).getResult());
%>
							<textarea id="abc" name="test2" class="tableTextareaEditor"><%=templateData %></textarea>

							<%}else{
  %>
							<textarea value="" id="abc" name="test2"
								class="tableTextareaEditor"><%@include
									file="/temp/temp.html"%>  </textarea>
							<%} %>
							<% }else if(templateSet.size()>0){ 
  for(DgTemplate dgTemp : templateSet){
	result = dgTemp.getResult();
	
 %>
							<%if(session.getAttribute("browseInResultEntry")!=null){ 
  session.removeAttribute("browseInResultEntry"); %>
							<textarea value="" id="abc" name="test2"
								class="tableTextareaEditor"><%@include
									file="/temp/temp.html"%>  </textarea>
							<%}else if(dgTemp.getResult() != null){
  String templateData= new String(Base64.decodeBase64(dgTemp.getResult()));

%>
							<textarea id="abc" name="test2" class="tableTextareaEditor"><%=templateData %></textarea>

							<%}else{ 
  %>
							<textarea value="" id="abc" name="test2"
								class="tableTextareaEditor"><%@include
									file="/temp/temp.html"%>  </textarea>
							<%} %>
							<%} 
}else {%>
							<%if(session.getAttribute("browseInResultEntry")!=null){ 
  session.removeAttribute("browseInResultEntry");
  }
  %>
							<textarea value="" id="abc" name="test2"
								class="tableTextareaEditor"><%@include
									file="/temp/temp.html"%>  </textarea>
							<% }%>
						</div>
						<div class="clear"></div>
						<div class="clear"></div> <input type="button" id="clearButton"
						name="clearButton" class="buttonBig" value="clear Template"
						onclick="clearTemplateData();" style="margin-top: 12px;">
					</input> <!-- <label class="common">Put up for validation:</label> --> <input
						type="hidden" id="putForValidation" name="reportEnteredFinally"
						value="" /> <input type="hidden" name="reportEnteredFinally1"
						id="reportEnteredFinally" value="y" onclick="putForFinally();"
						class="checkbox" tabindex="1" />

						<div class="clear"></div> <label class="common"
						style="margin-top: 6px;">Additional Remarks</label> <%if(dgCollection.getRemarks() != null){ %>
						<textarea id="<%=ADDITIONAL_REMARKS%>"
							value="<%=dgCollection.getRemarks()%>"
							onkeyup="chkLength(this,100);" name="<%=ADDITIONAL_REMARKS %>"
							style="margin-top: 15px;"><%=dgCollection.getRemarks()%></textarea>
						<script>document.sampleCollection.<%=ADDITIONAL_REMARKS%>.innerHTML = "<%=dgCollection.getRemarks()%>"</script>
						<%}else if(dgResultEntryDetailListForResult.size()>0){ %> <textarea
							value="" onkeyup="chkLength(this,100);"
							id="<%=ADDITIONAL_REMARKS %>" name="<%=ADDITIONAL_REMARKS %>"><%=dgResultEntryDetailListForResult.get(0).getRemarks()%></textarea>
						<%}else{%> <textarea value="" onkeyup="chkLength(this,100);"
							id="<%=ADDITIONAL_REMARKS %>" name="<%=ADDITIONAL_REMARKS %>"></textarea>
						<%} %> <%} %> 
						<div class="clear"></div> <!-- Table Ends --> <!--Bottom labels starts-->
						<div class="clear"></div>
						<div class="division"></div> <input type="button" class="button"
						value="Submit" id="addbutton" onclick="formSubmission();"
						align="right" /> <input name="Reset" type="button" id="reset"
						class="buttonHighlight" value="Reset" onclick="resetResult();" />
<!-- 						<input name="Button" type="button" class="button" value="Back" -->
<!-- 						onclick="history.back();" /> changed by govind 4-11-2016-->
						
						<input name="Button" type="button" class="button" value="Back"
						onclick="submitForm('sampleCollection','/hms/hms/investigation?method=searchPatientForLab&sampleCollectionDetailId=<%=CombinedIds%>' + '&'+'${_csrf.parameterName}'+'='+'${_csrf.token}');" />
						
						<div class="clear"></div>
						<div class="division"></div>
						<div class="bottom">
							<div class="clear"></div>
							<label>Changed By</label> <label class="value"><%=userName%></label>
							<label>Changed Date</label> <label class="value"><%=date%></label>
							<label>Changed Time</label> <label class="value"><%=time%></label>
						</div> <!--Bottom labels ends-->
						<div class="clear"></div>
						<div class="division"></div>
						<div class="paddingTop40"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<!--Bottom labels starts-->
<script language="Javascript">
function putForFinally()
{
if(document.getElementById('reportEnteredFinally').checked==true)
{
document.getElementById('putForValidation').value="y";
}
else{
document.getElementById('putForValidation').value="";
}

}

function formSubmission(){

	var filmSizeUsed='';
	//var filmSizeUsed=document.getElementById("filmSizeUsed").value;
	var filmUsed='';
	//var filmUsed=document.getElementById("filmUsed").value;
	//var REMARKS=document.getElementById("remarks").value;
	var MAIN_CHARGECODE_ID=document.getElementById("<%=MAIN_CHARGECODE_ID%>").value;
	var DEPARTMENT_ID=document.getElementById("<%=DEPARTMENT_ID%>").value;
	var SUB_CHARGECODE_ID=document.getElementById("<%=SUB_CHARGECODE_ID%>").value;
	var HIN_ID=document.getElementById("<%=HIN_ID%>").value;
	var INPATIENT_ID=document.getElementById("<%=INPATIENT_ID%>").value;
	var SAMPLE_COLLECTION_ID=document.getElementById("<%=SAMPLE_COLLECTION_ID%>").value;
	var TEST_ORDER_NO_TEMPLATE_VALUE=document.getElementById("<%=TEST_ORDER_NO_TEMPLATE_VALUE%>").value;
	
	var EMPLOYEE_ID=document.getElementById("<%=EMPLOYEE_ID%>").value;
	var RESULT_TYPE=document.getElementById("<%=RESULT_TYPE%>").value;
	var test2=document.getElementById("abc").value;
	var ADDITIONAL_REMARKS=document.getElementById("<%=ADDITIONAL_REMARKS%>").value;
	var INVESTIGATION_ID=document.getElementById("<%=INVESTIGATION_ID%>").value;
	var combinedIds = document.getElementById('CombinedIds').value;
	var RESULT_ENTERED_BY=document.getElementById("<%=RESULT_ENTERED_BY%>").value;
	var SAMPLE_COLLECTION_ID=document.getElementById("<%=SAMPLE_COLLECTION_ID%>").value;
	var RESULT_NO=document.getElementById("<%=RESULT_NO%>").value;
	var DG_SAMPLE_DETAIL_ID = document.getElementById("<%=DG_SAMPLE_DETAIL_ID%>").value;
		var reportEnteredFinally = document
				.getElementById("reportEnteredFinally").checked;

		WYSIWYG.updateTextArea('abc');
		//var templateData =document.getElementById("abc").value;
		//if(reportEnteredFinally == true){
		//	if(confirm("Are you sure.\nYou want to submit report for validation.")){
		//		submitForm("sampleCollection","investigation?method=submitResultEntryForTempelate&dgSampleDetailId="+DG_SAMPLE_DETAIL_ID+"&resultNo="+RESULT_NO+"&filmSizeUsed="+filmSizeUsed+"&filmUsed="+filmUsed+"&mainChargecodeId="+MAIN_CHARGECODE_ID+"&departmentId="+DEPARTMENT_ID+"&subChargeCodeId="+SUB_CHARGECODE_ID+"&hinId="+HIN_ID+"&inpatientId="+INPATIENT_ID+"&sampleCollectionId="+SAMPLE_COLLECTION_ID+"&employeeId="+EMPLOYEE_ID+"&resultEnteredBy="+RESULT_ENTERED_BY+"&resultType="+RESULT_TYPE+"&additionalRemarks="+ADDITIONAL_REMARKS+"&investigationId="+INVESTIGATION_ID+"");	
		//	}else{
		//		return false;
		//	}	
		//}else{progress
		if (reportEnteredFinally == true) {
			if (confirm("Are you sure.\nYou want to submit report for validation.")) {
				submitForm("sampleCollection",
						"investigation?method=submitResultEntryForTempelateLab&dgSampleDetailId="
								+ DG_SAMPLE_DETAIL_ID + "&resultNo="
								+ RESULT_NO + "&filmSizeUsed=" + filmSizeUsed
								+ "&filmUsed=" + filmUsed
								+ "&mainChargecodeId=" + MAIN_CHARGECODE_ID
								+ "&departmentId=" + DEPARTMENT_ID
								+ "&subChargeCodeId=" + SUB_CHARGECODE_ID
								+ "&hinId=" + HIN_ID + "&inpatientId="
								+ INPATIENT_ID + "&sampleCollectionId="
								+ SAMPLE_COLLECTION_ID + "&employeeId="
								+ EMPLOYEE_ID + "&resultEnteredBy="
								+ RESULT_ENTERED_BY + "&resultType="
								+ RESULT_TYPE + "&additionalRemarks="
								+ ADDITIONAL_REMARKS + "&investigationId="
								+ INVESTIGATION_ID + "&reportEnteredFinally="
								+ reportEnteredFinally + "&combinedIds="
								+ combinedIds + "&testOrderNoForTemplate="
								+ TEST_ORDER_NO_TEMPLATE_VALUE + "&"+csrfTokenName+"="+csrfTokenValue);
				//window.opener.document.getElementById('templateButtonDiv').style.display='none';  	  
				//window.opener.document.getElementById('resultEntryMessageDiv').style.display='block';
				//window.opener.document.getElementById('resultEntryMessageDiv').innerHTML='<label style="font-weight: bold;color: red;">Result Entered Successfully</label>';
			} else {
				return false;
			}
		} else {
			submitForm("sampleCollection",
					"investigation?method=submitResultEntryForTempelateLab&dgSampleDetailId="
							+ DG_SAMPLE_DETAIL_ID + "&resultNo=" + RESULT_NO
							+ "&filmSizeUsed=" + filmSizeUsed + "&filmUsed="
							+ filmUsed + "&mainChargecodeId="
							+ MAIN_CHARGECODE_ID + "&departmentId="
							+ DEPARTMENT_ID + "&subChargeCodeId="
							+ SUB_CHARGECODE_ID + "&hinId=" + HIN_ID
							+ "&inpatientId=" + INPATIENT_ID
							+ "&sampleCollectionId=" + SAMPLE_COLLECTION_ID
							+ "&employeeId=" + EMPLOYEE_ID
							+ "&resultEnteredBy=" + RESULT_ENTERED_BY
							+ "&resultType=" + RESULT_TYPE
							+ "&additionalRemarks=" + ADDITIONAL_REMARKS
							+ "&investigationId=" + INVESTIGATION_ID
							+ "&reportEnteredFinally=" + reportEnteredFinally
							+ "&combinedIds=" + combinedIds
							+ "&testOrderNoForTemplate="
							+ TEST_ORDER_NO_TEMPLATE_VALUE + "&"+csrfTokenName+"="+csrfTokenValue);
			//window.opener.document.getElementById('templateButtonDiv').style.display='block';  	  
			//window.opener.document.getElementById('resultEntryMessageDiv').style.display='block';
			//window.opener.document.getElementById('resultEntryMessageDiv').innerHTML='<label style="font-weight: bold;color: red;"></label>';
		}

		submitForm("sampleCollection",
				"investigation?method=submitResultEntryForTempelateLab&dgSampleDetailId="
						+ DG_SAMPLE_DETAIL_ID + "&resultNo=" + RESULT_NO
						+ "&filmSizeUsed=" + filmSizeUsed + "&filmUsed="
						+ filmUsed + "&mainChargecodeId=" + MAIN_CHARGECODE_ID
						+ "&departmentId=" + DEPARTMENT_ID
						+ "&subChargeCodeId=" + SUB_CHARGECODE_ID + "&hinId="
						+ HIN_ID + "&inpatientId=" + INPATIENT_ID
						+ "&sampleCollectionId=" + SAMPLE_COLLECTION_ID
						+ "&employeeId=" + EMPLOYEE_ID + "&resultEnteredBy="
						+ RESULT_ENTERED_BY + "&resultType=" + RESULT_TYPE
						+ "&additionalRemarks=" + ADDITIONAL_REMARKS
						+ "&investigationId=" + INVESTIGATION_ID + "&"+csrfTokenName+"="+csrfTokenValue);

		//window.opener.location.href = '/hms/hms/investigation?method=searchPatientForLab&sampleCollectionDetailId='+combinedIds;
		self.close();

		//}
	}

	function mm() {
		alert('cccc');
	}
	function getTemplateEditor(n) {
		return $("wysiwyg" + n);
	}

	function clearTemplateData() {
		//alert(document.getElementById('abc').value);
		//document.getElementById('templateDivToShow').style.display='block';
		document.getElementById('abc').value = '';
		//$('abc').value ='';
		getTemplateEditor('abc').contentWindow.document.body.innerHTML = '';
	}
	function openHelpPage() {
		window.location.href = 'lab?method=showTemplateHelpJsp';
	}
	function closePopUp() {
		self.close();
	}
	
	function BackAction(){
		submitForm("sampleCollection",
				"/hms/hms/investigation?method=searchPatientForLab&sampleCollectionDetailId="
						+ <%=CombinedIds%> + "&"+csrfTokenName+"="+csrfTokenValue);
	}
</script>
<!--main content placeholder ends here-->
