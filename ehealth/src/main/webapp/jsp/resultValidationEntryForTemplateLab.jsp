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
<%
Map<String, Object> map = new HashMap<String, Object>();

if(request.getAttribute("map") != null)
{
        map=(Map<String, Object>)request.getAttribute("map");
}
int resultId=0;
if (map.get("resultId") != null) 
{
	resultId = (Integer) map.get("resultId");
}
int dgresultDetailIdTemplate=0;
if (map.get("dgresultDetailIdTemplate") != null) 
{
	dgresultDetailIdTemplate = (Integer) map.get("dgresultDetailIdTemplate");
}


%>


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
  
submitForm('sampleCollection','investigation?method=getFileNameForLab&resultNoTemplate='+RESULT_NO+'&resultEnteredBy='+RESULT_ENTERED_BY+'&dgSampleDetailIdForTemplate='+DG_SAMPLE_DETAIL_ID+'&&CombinedIds='+combinedIds+'&parameterName=fromResultEntry&formName=sampleCollection&browseInResultEntry=browse&test2='+updatedtemplate+''); 
}
return true;
}

 
 
</script>

<script type="text/javascript">
   history.forward();
</script>
<!--main content placeholder starts here-->

<form name="sampleCollection" method="post"
	enctype="multipart/form-data" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<div class="clear"></div>
	<div class="clear"></div>

	<div class="titleBg">
		<h2>Result Validation</h2>
	</div>



<input name="resultId" id="resultId" type="hidden" value=" <%=resultId %>" /> 
	<input name="dgresultDetailIdTemplate" id="dgresultDetailIdTemplate" type="hidden" value="<%=dgresultDetailIdTemplate %> " /> <input name=" " id=" "
		type="hidden" value="" /> <input name=" " id=" " type="hidden"
		value=" " /> <input name=" " id=" " type="hidden" value=" " /> <input
		type="hidden" id="browse" name="browse" value="">
		<div class="clear"></div> <input type="hidden" name=" " id=" "
		value="" /> <input type="hidden" name=" " id=" " value="" /> <!--Block One Starts-->

		<!--Block one Ends--> <!--Block Two Starts-->

		<div>
			<input type="hidden" name=" " id=" " value="" /> <input
				type="hidden" name=" " id=" " value=" " /> <input type="hidden"
				name=" " id=" " value=" " />
		</div> <input type="hidden" name=" " id=" " value="" /> <input
		type="hidden" name=" " id=" " value="" /> <!--Block Two Ends--> <!-- Block Three Starts -->

		<input type="hidden" name=" " id=" " value=" " /> <input
		type="hidden" name=" " id=" " value="" /> <input type="hidden"
		name="" id="" value=" " /> <input type="hidden" name=" "
		id="<%= RESULT_ENTERED_BY %>" value=" " />

		<div class="clear"></div> <input type="hidden" id=" " name=" "
		value="" /> <input type="hidden" id=" " name=" " value="" />
		<div class="clear"></div>

		<div class="clear"></div> <input type="hidden" value="0"
		name="pagecounter2" /> <input type="hidden" name="pageNo" id="pageNo"
		value=" " /> <input type="hidden" name="CombinedIds" id="CombinedIds"
		value=" " /> <!-- Block Three Ends -->
		<div class="clear"></div> <!-- Table Starts --> <input name=" " id=" "
		value="t" type="hidden"> <input name=" " id=" " value=""
			type="hidden"> <input name=" " id=" " value="" type="hidden">
					<input name=" " id=" " value="" type="hidden"> <!--<label>Result</label>
	
						 <input type="file" id="upload" name=" "
						class="Browse" size="50" onchange="see()"
						style="width: 150px; height: 22px;" /> -->

						<div class="tableHolderAutoValidate" style="width: 980px;">
							<table id="chargeDetails" width="100%" cellpadding="0"
								cellspacing="0" style="height: auto;">

								<tr>
									<th width="7%">Diag No</th>

									<th width="7%">Investigation</th>

									<th width="7%">Validate</th>

								</tr>
								<tr>
									<td width="7%">25/03/2015
									</th>

									<td width="7%">Template Test
									</th>

									<td width="7%"><input type="checkbox" />
									</th>

								</tr>

							</table>
						</div>
						<div class="clear"></div><input type="button" id="" name=""
		class="buttonBig" value="View Document" onclick="" style="margin-top: 12px;"> </input>
	<div class="clear"></div>
	<!-- <h4>
		<span>(It will accept only html formate.)</span>
	</h4> -->
	<div class="clear"></div>
	<div id="hiddenTextArea" style="display: none">
		<textarea id="appendedHtml" name="appendedHtml"> </textarea>
	</div>
	<div id="rtf">


		<textarea value="" id="abc" name="test2" class="tableTextareaEditor">
		<%@include file="/temp/temp.html"%>  </textarea>

		<!-- 	<textarea id="abc" name="test2" class="tableTextareaEditor"> </textarea> -->


		<%-- 	<textarea value="" id="abc" name="test2"
								class="tableTextareaEditor"><%@include
									file="/temp/temp.html"%>  </textarea> --%>



		<%-- <textarea value="" id="abc" name="test2"
								class="tableTextareaEditor"><%@include
									file="/temp/temp.html"%>  </textarea> --%>

		<%-- <textarea id="abc" name="test2" class="tableTextareaEditor"> </textarea>

							  					<textarea value="" id="abc" name="test2"
								class="tableTextareaEditor"><%@include
									file="/temp/temp.html"%>  </textarea> --%>


		<%-- 	<textarea value="" id="abc" name="test2"
								class="tableTextareaEditor"><%@include
									file="/temp/temp.html"%>  </textarea> --%>

	</div>
	<div class="clear"></div>
	<div class="clear"></div>
	<!-- <input type="button" id="clearButton"
						name="clearButton" class="buttonBig" value="clear Template"
						onclick="clearTemplateData();" style="margin-top: 12px;"> -->
	</input>
	<!-- <label class="common">Put up for validation:</label> -->
	<input type="hidden" id="putForValidation" name="reportEnteredFinally"
		value="" /> <input type="hidden" name="reportEnteredFinally1"
		id="reportEnteredFinally" value="y" onclick="putForFinally();"
		class="checkbox" tabindex="1" />

	<div class="clear"></div>
	<label class="common" style="margin-top: 6px;">Additional
		Remarks</label>
	<textarea id=" " value="" onkeyup="chkLength(this,100);" name=""
		style="margin-top: 15px;"></textarea>
	<script>document.sampleCollection.a.innerHTML = ""</script>
	<!--  <textarea value="" onkeyup="chkLength(this,100);"
							id=" " name=" "></textarea> -->
	<!-- 
<label class="noWidth">Film Size Used</label>
		<select   name="filmSizeUsed"id="filmSizeUsed" validate="Film Size Used,string,no" >
		<option value="None">Select</option>
		<option value="17X14">17"*14"</option>
		<option value="15X12">15"*12"</option>
		<option value="12X10">12"*10"</option>
		<option value="10X8">10"*8"</option>
		
		</select>
				
<label class="noWidth">Film Used</label>
		<select id="filmUsed" name="filmUsed" id="filmUsed"validate="Film Used,string,no" >
			<option value="">Select</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
			<option value="8">8</option>
			<option value="9">9</option>
		</select>		
 -->
	<div class="clear"></div>
	<!-- Table Ends -->
	<!--Bottom labels starts-->
	<div class="clear"></div>
	<div class="division"></div>
	<input type="button" class="button" value="Submit" id="addbutton"
		onclick="formSubmission();" align="right" /> <input name="Reset"
		type="button" id="reset" class="buttonHighlight" value="Reset"
		onclick="resetResult();" /> <input name="Button" type="button"
		class="button" value="Back" onclick="history.back();" />
	<div class="clear"></div>
	<div class="division"></div>
	<div class="bottom">
		<div class="clear"></div>
		<label>Changed By</label> <label class="value"></label> <label>Changed
			Date</label> <label class="value"> </label> <label>Changed Time</label> <label
			class="value"> </label>
	</div>
	<!--Bottom labels ends-->
	<div class="clear"></div>
	<div class="division"></div>
	<div class="paddingTop40"></div>
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

	<%-- var filmSizeUsed='';
	//var filmSizeUsed=document.getElementById("filmSizeUsed").value;
	var filmUsed='';
	//var filmUsed=document.getElementById("filmUsed").value;
	//var REMARKS=document.getElementById("remarks").value;
	
	if(null !=document.getElementById("<%=MAIN_CHARGECODE_ID%>"))
	 var MAIN_CHARGECODE_ID=document.getElementById("<%=MAIN_CHARGECODE_ID%>").value;
	
	if(null !=document.getElementById("<%=DEPARTMENT_ID%>"))
	var DEPARTMENT_ID=document.getElementById("<%=DEPARTMENT_ID%>").value;
	
	if(null !=document.getElementById("<%=SUB_CHARGECODE_ID%>"))
	var SUB_CHARGECODE_ID=document.getElementById("<%=SUB_CHARGECODE_ID%>").value;
	
	if(null !=document.getElementById("<%=HIN_ID%>"))
	var HIN_ID=document.getElementById("<%=HIN_ID%>").value;
	
	if(null !=document.getElementById("<%=INPATIENT_ID%>"))
	var INPATIENT_ID=document.getElementById("<%=INPATIENT_ID%>").value;
	
	if(null !=document.getElementById("<%=SAMPLE_COLLECTION_ID%>"))
	var SAMPLE_COLLECTION_ID=document.getElementById("<%=SAMPLE_COLLECTION_ID%>").value;
	
	if(null !=document.getElementById("<%=TEST_ORDER_NO_TEMPLATE_VALUE%>"))
	var TEST_ORDER_NO_TEMPLATE_VALUE=document.getElementById("<%=TEST_ORDER_NO_TEMPLATE_VALUE%>").value;
	
	
	if(null !=document.getElementById("<%=EMPLOYEE_ID%>"))
	var EMPLOYEE_ID=document.getElementById("<%=EMPLOYEE_ID%>").value;
	
	if(null !=document.getElementById("<%=RESULT_TYPE%>"))
	var RESULT_TYPE=document.getElementById("<%=RESULT_TYPE%>").value;
	
	if(null !=document.getElementById("abc"))
	var test2=document.getElementById("abc").value;
	alert(test2)
	if(null !=document.getElementById("<%=ADDITIONAL_REMARKS%>"))
	var ADDITIONAL_REMARKS=document.getElementById("<%=ADDITIONAL_REMARKS%>").value;
	
	if(null !=document.getElementById("<%=INVESTIGATION_ID%>"))
	var INVESTIGATION_ID=document.getElementById("<%=INVESTIGATION_ID%>").value;
	
	if(null !=document.getElementById("CombinedIds"))
	var combinedIds = document.getElementById('CombinedIds').value;
	
	if(null !=document.getElementById("<%=RESULT_ENTERED_BY%>"))
	var RESULT_ENTERED_BY=document.getElementById("<%=RESULT_ENTERED_BY%>").value;
	
	if(null !=document.getElementById("<%=SAMPLE_COLLECTION_ID%>"))
	var SAMPLE_COLLECTION_ID=document.getElementById("<%=SAMPLE_COLLECTION_ID%>").value;
	
	if(null !=document.getElementById("<%=RESULT_NO%>"))
	var RESULT_NO=document.getElementById("<%=RESULT_NO%>").value;
	
	if(null !=document.getElementById("<%=DG_SAMPLE_DETAIL_ID%>"))
	var DG_SAMPLE_DETAIL_ID=document.getElementById("<%=DG_SAMPLE_DETAIL_ID%>").value;
 --%>
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
			var resultId=document.getElementById("resultId").value;
		  var dgresultDetailIdTemplate=document.getElementById("dgresultDetailIdTemplate").value;
		/* if (reportEnteredFinally == true) {
			if (confirm("Are you sure.\nYou want to submit report for validation.")) {
				submitForm("sampleCollection",
						"investigation?method=submitResultEntryForTempelateLab&dgSampleDetailId="
								+ resultId + "&resultNo="
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
		}  */
		
			submitForm("sampleCollection",
					"investigation?method=validateResultEntryForTempelateLab&resultId="
							+ resultId + "&dgresultDetailIdTemplate=" + dgresultDetailIdTemplate+ "&"+csrfTokenName+"="+csrfTokenValue);
			//window.opener.document.getElementById('templateButtonDiv').style.display='block';  	  
			//window.opener.document.getElementById('resultEntryMessageDiv').style.display='block';
			//window.opener.document.getElementById('resultEntryMessageDiv').innerHTML='<label style="font-weight: bold;color: red;"></label>';
		

		

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
		window.location.href = 'lab?method=showTemplateHelpJsp&'+csrfTokenName+'='+csrfTokenValue;
	}
	function closePopUp() {
		self.close();
	}
</script>
<!--main content placeholder ends here-->
