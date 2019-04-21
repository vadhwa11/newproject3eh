<%@page import="java.util.*"%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

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

<script type="text/javascript"><!--
	function updateTemplate(){
	 WYSIWYG.updateTextArea('abc');
	//document.getElementById("abc").innerHTML   = document.getElementById('wysiwygabc').contentWindow.document.body.innerHTML;  
	var templateData =document.getElementById("abc").value;
	
	var TEMPLATE_ID=document.getElementById("<%=TEMPLATE_ID%>").value;

	submitForm('chargeCode','investigation?method=updateTemplate&'+csrfTokenName+'='+csrfTokenValue);

	}
	function see()
	{
	fName=document.getElementById("upload").value;
	var extension =fName.substring(fName.length-4);
	if(fName !=""){
	if( extension != '.txt' && extension != '.TXT' && extension !='.rtf')
	{
	//alert("Uploaded Document can only be in .txt or .TXT format\n");
	//return false;
	}
	document.chargeCode.browse.value="browse";

	submitForm('chargeCode','investigation?method=getFileName&browse=browse&'+csrfTokenName+'='+csrfTokenValue);
	}
	return true;
	}

	function callback(http_request) {
	if (http_request.readyState == 4 || http_request.readyState=="complete") {
	alert('http_request.responseText'+http_request.responseText);
	alert(document.getElementById("abc").value)
	document.getElementById('abc').value=http_request.responseText;
	}
	}
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	if(session.getAttribute("url")!=null){
		session.removeAttribute("url");
	}
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
		session.setAttribute("map",map);
	}
	if(map.get("message") != null)
	{
	String message = (String)map.get("message");

	out.println(message);
	}
	String deptType="";
	if (session.getAttribute("deptType") != null) {
		deptType = (String) session.getAttribute("deptType");

	out.println("deptType--->"+deptType);
	}

	String appendedHtml="";
	int mainChargecodeId=0;
	int subChargeCodeId=0;
	int chargeCodeId=0; String chargeCodeName="";
	if(map.get("mainChargecodeId") != null){
		mainChargecodeId =(Integer) map.get("mainChargecodeId");
	}
	if(map.get("subChargeCodeId") != null){
		subChargeCodeId =(Integer) map.get("subChargeCodeId");

	}
	if(map.get("appendedHtml") != null){

		appendedHtml =(String) map.get("appendedHtml");

	}
	
	System.out.println("====="+appendedHtml+"====");
	if(map.get("chargeCodeId") != null){
		chargeCodeId =(Integer) map.get("chargeCodeId");
	}
	int sampleId=0;
	String investigationName="";
	String confidential="";
	String investigationType="";
	String dischargeSummary="";
	if(map.get("investigationName") != null){
		investigationName =(String) map.get("investigationName");
	}
	if(map.get("confidential") != null){
		confidential =(String) map.get("confidential");

	}
	if(map.get("investigationType") != null){
		investigationType =(String) map.get("investigationType");
	}
	if(map.get("dischargeSummary") != null){
		dischargeSummary =(String) map.get("dischargeSummary");
	}
	if(map.get("sampleId") != null){
		sampleId =(Integer) map.get("sampleId");

	}
	String quantity ="";
	if(map.get("quantity") != null){
		quantity =(String) map.get("quantity");
	}
	ArrayList  <MasSubChargecode> subChargecodeList = new ArrayList<MasSubChargecode>();
	if(map.get("subChargecodeList") != null){
	subChargecodeList = (ArrayList)map.get("subChargecodeList");
	}

	ArrayList  <MasMainChargecode> mainChargecodeList = new ArrayList<MasMainChargecode>();
	if(map.get("mainChargecodeList") != null){
	mainChargecodeList = (ArrayList)map.get("mainChargecodeList");
	}
	ArrayList<MasChargeCode>chargeCodeList = new ArrayList<MasChargeCode>();
	if(map.get("chargeCodeList") != null){
	chargeCodeList=(ArrayList)map.get("chargeCodeList");
	}
%>
<div class="titleBg">
<h2>Template</h2>
</div>
<div class="clear"></div>
<form name="chargeCode" enctype="multipart/form-data" method="post"
	action=""><input type="hidden" name="<%= POJO_NAME %>"
	value="DgMasInvestigation"> <input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="InvestigationName"> <input
	type="hidden" name="<%=JSP_NAME %>" value="investigationSubTest">
<input type="hidden" name="pojoPropertyCode" value="InvestigationCode">

<input type="hidden" id="browse" name="browse" value=""> <input
	type="hidden" id="<%=MAIN_CHARGECODE_ID %>"
	name="<%=MAIN_CHARGECODE_ID %>" value="<%=mainChargecodeId%>">
<input type="hidden" id="<%=SUB_CHARGECODE_ID %>"
	name="<%=SUB_CHARGECODE_ID %>" value="<%=subChargeCodeId%>"> <input
	type="hidden" id="<%=CHARGE_CODE_ID %>" name="<%=CHARGE_CODE_ID %>"
	value="<%=chargeCodeId%>"> <input type="hidden"
	id="<%=INVESTIGATION_NAME %>" name="<%=INVESTIGATION_NAME %>"
	value="<%= investigationName%>"> <input type="hidden"
	id="<%=INVESTIGATION_TYPE %>" name="<%=INVESTIGATION_TYPE %>"
	value="<%= investigationType%>"> <input type="hidden"
	id="<%=DSICHARGE_SUMMARY %>" name="<%=DSICHARGE_SUMMARY %>"
	value="<%= dischargeSummary%>"> <input type="hidden"
	id="<%=CONFIDENTIAL %>" name="<%=CONFIDENTIAL %>"
	value="<%= confidential%>"> <input type="hidden"
	id="<%=SAMPLE_ID %>" name="<%=SAMPLE_ID %>" value="<%=sampleId %>">
<input type="hidden" id="<%=QUANTITY %>" name="<%=QUANTITY %>"
	value="<%=quantity %>"> <%
	String mainChargecodeName="";
	int mainId=0;
	if(mainChargecodeList != null){
	for (MasMainChargecode masMainChargecode : mainChargecodeList)
	{
		mainId=masMainChargecode.getId();

		if(mainChargecodeId == mainId){
		mainChargecodeId=masMainChargecode.getId();

		mainChargecodeName=masMainChargecode.getMainChargecodeName();
		%>
<div class="Block"><label class="common">Lab Name</label> <input
	type="text" name="<%=MAIN_CHARGECODE_NAME %>"
	id="<%=MAIN_CHARGECODE_NAME %>"
	value="<%=masMainChargecode.getMainChargecodeName() %>"
	class="readOnly" readonly="readonly" /> <% 	}}}%> <%
	String subChargecodeName="";
	int subId=0;
	if(subChargecodeList != null){
	for (MasSubChargecode massubChargecode : subChargecodeList)
	{
		subId=massubChargecode.getId();
		if(subChargeCodeId == subId){
			subChargeCodeId=massubChargecode.getId();
		subChargecodeName=massubChargecode.getSubChargecodeName();
		%> <label class="common">LabGroup Name</label> <input type="text"
	name="<%=SUB_CHARGECODE_NAME %>" id="<%=SUB_CHARGECODE_NAME %>"
	value="<%=massubChargecode.getSubChargecodeName() %>" class="readOnly"
	readonly="readonly" /> <% 	}}}%> <%
	String chargecodeName="";
	int chargeId=0;
	if(chargeCodeList != null){
	for (MasChargeCode masChargeCode : chargeCodeList)
	{
		chargeId=masChargeCode.getId();
		if(chargeCodeId == chargeId){
			chargeCodeId=masChargeCode.getId();
		chargecodeName=masChargeCode.getChargeCodeName();
		%> <label class="common">Charge Name</label> <input type="text"
	name="<%=CHARGE_CODE_NAME %>" id="<%=CHARGE_CODE_NAME %>"
	value="<%=masChargeCode.getChargeCodeName()%>" class="readOnly"
	readonly="readonly" /> <% 	}}}%> <%
/** for investigation List**/
	List<DgTemplate> templateList = new ArrayList<DgTemplate>();
	if(map.get("templateList") != null){
		templateList =(List) map.get("templateList");
	}
	byte result[]=null;
	int templateId=0;
		result = templateList.get(0).getResult();
		templateId =templateList.get(0).getId();
  %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<label>Result</label> <input type="file" id="upload"
	name="<%=UPLOAD_FILENAME%>" class="Browse" size="50" onchange="see()" />
<div class="clear"></div>
<div class="paddingTop15"></div>
<!--Rich text editor-->
<div id="rtf">
<table border="0" cellpadding="2" cellspacing="0" width="100%">
	<tr>
		<td colspan="2">
		<table border="0" cellpadding="2" cellspacing="0" width="100%">
			<tr>
				<td><input type="hidden" name="<%=TEMPLATE_ID %>"
					value="<%=templateId %>" id="<%=TEMPLATE_ID %>" /> <%if(map.get("browse")!=null){%>

				<textarea id="abc" name="test2" class="tableTextareaEditor""> <%@include file="/temp/temp.html"%>
			  </textarea> <% }
		else{
			if(templateList.get(0).getResult() != null){

			String templateData="";
				templateData=new String(templateList.get(0).getResult());
	%>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<div class="clear"></div>
<!--Rich text editor ends--> <textarea id="abc" name="test2"
	class="tableTextareaEditor""> <%=appendedHtml %>
  </textarea> <%}} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" class="button" value="Update" align="left"
	onclick="updateTemplate();" />
<div class="clear"></div>
<div class="division"></div>
<div id="hiddenTextArea" style="display: none"><textarea
	id="appendedHtml" name="appendedHtml"><%=appendedHtml %></textarea></div>
<div class="clear"></div>
<div class="division"></div>

<%--<%if(deptType.equalsIgnoreCase("radio")){
	%>
	<input type="button"
	class="button" value="Back" align="left"
	onClick="submitFormForButton('chargeCode','investigation?method=showInvestigationForRadiologyJsp');" />
	<%}else{%>


	<input type="button" class="button" value="Back" align="left"
	onClick="submitFormForButton('chargeCode','investigation?method=showInvestigationJsp');" />

	<%}%>--%>
	<input type="button" class="button" value="Back" align="left"
	onClick="javascript: history.go(-1)"/>

<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

<div class="paddingTop40"></div>

