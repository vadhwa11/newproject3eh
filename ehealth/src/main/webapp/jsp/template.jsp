<%@page import="org.apache.commons.codec.binary.Base64"%>
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
<%String fileData=""; %>
<script type="text/javascript"><!--
function updateTemplate(){
 //WYSIWYG.updateTextArea('abc');
 document.getElementById("abc").innerHTML   = document.getElementById('wysiwygabc').contentWindow.document.body.innerHTML;
var templateData =document.getElementById("abc").value;
submitForm('chargeCode','investigation?method=updateTemplate'+csrfTokenName+'='+csrfTokenValue);
}
function submitTemplatee(){
WYSIWYG.updateTextArea('abc');
//var templateData =document.getElementById("abc").value;
//document.getElementById("abc").innerHTML   = document.getElementById('wysiwygabc').contentWindow.document.body.innerHTML;
submitForm('chargeCode','investigation?method=submitTemplate&submitFirstTime=y&'+csrfTokenName+'='+csrfTokenValue);
}
function see()
{document.chargeCode.method="post";
fName=document.getElementById("upload").value;
var extension =fName.substring(fName.length-4);
if(fName !=""){
if( extension != '.txt' && extension != '.TXT' && extension !='.rtf')
{	
//alert("Uploaded Document can only be in .txt or .TXT format\n");
//return false;
}
var updatedtemplate= document.chargeCode.test2.value;

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
<script type="text/javascript">
function openHelpPage(){
 window.location.href='lab?method=showTemplateHelpJsp';
}
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
		session.setAttribute("map",map);
	}
	int mainChargecodeId=0;
	int subChargeCodeId=0;
	int chargeCodeId=0; String chargeCodeName="";
	String deptType="";
	if (session.getAttribute("deptType") != null) {
		deptType = (String) session.getAttribute("deptType");
	
	}
	if(map.get("mainChargecodeId") != null){
		mainChargecodeId =(Integer) map.get("mainChargecodeId");
	}
	if(map.get("subChargeCodeId") != null){
		subChargeCodeId =(Integer) map.get("subChargeCodeId");
		
	}
	if(map.get("chargeCodeId") != null){
		chargeCodeId =(Integer) map.get("chargeCodeId");
	} 
	int sampleId=0;
	String investigationName="";
	String confidential="";
	String investigationType="";
	String dischargeSummary="";
	String appendedHtml="";
	String quantity ="";
	int collectionCenterId =0;
	if(map.get("investigationName") != null){
		investigationName =(String) map.get("investigationName");
	}
	if(map.get("confidential") != null){
		confidential =(String) map.get("confidential");
	}
	if(map.get("appendedHtml") != null){
		appendedHtml =(String) map.get("appendedHtml");
	}
	System.out.println("====="+appendedHtml+"====");
	if(map.get("investigationType") != null){
		investigationType =(String) map.get("investigationType");
}
	if(map.get("dischargeSummary") != null){
		dischargeSummary =(String) map.get("dischargeSummary");
	}
	if(map.get("sampleId") != null){
		sampleId =(Integer) map.get("sampleId");
	}
	if(map.get("collectionCenterId") != null){
		collectionCenterId =(Integer) map.get("collectionCenterId");
	}
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
	}%>
	
<%
if(map.get("message") != null){
	String message = (String)map.get("message");
	%>
<h4><span><%=message %></span></h4>

<%}	%>
<form name="chargeCode" enctype="multipart/form-data" method="post"
	action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Template</h2>
</div>
<div class="clear"></div>

<input type="hidden" name="<%=POJO_NAME%>" value="DgMasInvestigation" validate="pojoName,metachar,no">

<input type="hidden" name="<%=POJO_PROPERTY_NAME%>"
	value="InvestigationName" validate="pojoPropertyName,metachar,no"> <input type="hidden"
	name="<%=JSP_NAME %>" value="investigationSubTest" validate="jspName,metachar,no"> <input
	type="hidden" name="pojoPropertyCode" value="InvestigationCode" validate="pojoPropertyCode,metachar,no">

<input type="hidden" id="<%=MAIN_CHARGECODE_ID %>"
	name="<%=MAIN_CHARGECODE_ID %>" value="<%=mainChargecodeId%>" validate="mainChargecodeId,int,no">
<input type="hidden" id="<%=SUB_CHARGECODE_ID %>"
	name="<%=SUB_CHARGECODE_ID %>" value="<%=subChargeCodeId%>" validate="subChargeCodeId,int,no"> <input
	type="hidden" id="<%=CHARGE_CODE_ID %>" name="<%=CHARGE_CODE_ID %>"
	value="<%=chargeCodeId%>" validate="chargeCodeId,int,no"> <input type="hidden"
	id="<%=INVESTIGATION_NAME %>" name="<%=INVESTIGATION_NAME %>"
	value="<%= investigationName%>" validate="investigationName,metachar,no"> <input type="hidden"
	id="<%=INVESTIGATION_TYPE %>" name="<%=INVESTIGATION_TYPE %>"
	value="<%=investigationType%>" validate="investigationType,metachar,no"> <input type="hidden"
	id="<%=DSICHARGE_SUMMARY %>" name="<%=DSICHARGE_SUMMARY %>"
	value="<%= dischargeSummary%>" validate="dischargeSummary,metachar,no"> <input type="hidden"
	id="<%=CONFIDENTIAL %>" name="<%=CONFIDENTIAL %>"
	value="<%= confidential%>" validate="confidential,metachar,no"> <input type="hidden"
	id="<%=SAMPLE_ID %>" name="<%=SAMPLE_ID %>" value="<%=sampleId %>" validate="sample_id,int,no">
<input type="hidden" id="<%=QUANTITY %>" name="<%=QUANTITY %>"
	value="<%=quantity %>" validate="quantity,metachar,no"> <input type="hidden"
	id="<%=COLLECTION_CENTER_ID %>" name="<%=COLLECTION_CENTER_ID %>"
	value="<%=collectionCenterId %>" validate="collectionCenterId,int,no"> <input type="hidden"
	id="browse" name="browse" value="" validate="browse,metachar,no"> <input type="hidden"
	id="alreadySavedOrNot" name="alreadySavedOrNot" value="" validate="alreadySavedOrNot,metachar,no"> <%
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
<div class="Block"><label>Lab Name</label> <input type="text"
	name="<%=MAIN_CHARGECODE_NAME %>" id="<%=MAIN_CHARGECODE_NAME %>"
	value="<%=masMainChargecode.getMainChargecodeName() %>" validate="mainChargecodeName,metachar,no"
	class="readOnly" readonly="readonly" /> <% 	}}
}
%> <%
String subChargecodeName="";
int subId=0;
if(subChargecodeList != null){
for (MasSubChargecode massubChargecode : subChargecodeList) 
{
	subId=massubChargecode.getId();
	if(subChargeCodeId == subId){
		subChargeCodeId=massubChargecode.getId();
	subChargecodeName=massubChargecode.getSubChargecodeName();
	%> <label>LabGroup Name</label> <input type="text"
	name="<%=SUB_CHARGECODE_NAME %>" id="<%=SUB_CHARGECODE_NAME %>"
	value="<%=massubChargecode.getSubChargecodeName() %>"  validate="subChargeCodeName,metachar,no"class="readOnly"
	readonly="readonly" /> <% 	}}
}
%> <%
String chargecodeName="";
int chargeId=0;
if(chargeCodeList != null){
for (MasChargeCode masChargeCode : chargeCodeList) 
{
	chargeId=masChargeCode.getId();
	if(chargeCodeId == chargeId){
		chargeCodeId=masChargeCode.getId();
	chargecodeName=masChargeCode.getChargeCodeName();
	%> <label>Charge Name</label> <input type="text"
	name="<%=CHARGE_CODE_NAME %>" id="<%=CHARGE_CODE_NAME %>"
	value="<%=masChargeCode.getChargeCodeName()%>" validate="chargeCodeName,metachar,no" class="readOnly"
	readonly="readonly" /> <% 	}}
}
%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<label>Result</label> <input type="file" id="upload"
	name="<%=UPLOAD_FILENAME%>" class="browse" size="40" onchange="see()" validate="upload_filename,metachar,no" />
<%-- <label class="auto">&nbsp;</label><label><a href="lab?method=showTemplateHelpJsp" title="Help For Template Upload">Help</a></label>--%>

<div class="clear"></div>
<h4><span>(It will accept only html formate.)</span></h4>
<div class="clear"></div>
<!--Rich text editor-->
<div id="rtf">
<table border="0" cellpadding="2" cellspacing="0" width="100%">
	<tr>
		<td colspan="2">
		<table border="0" cellpadding="2" cellspacing="0" width="100%">
			<tr>
				<td><textarea id="abc" name="test2" value=""
					class="tableTextareaEditor" /> <%if(map.get("templateList")!=null){
	  String templateData="";
	  List<DgTemplate>templateList1=(List<DgTemplate>)map.get("templateList");
	  int listSize=((List<DgTemplate>)map.get("templateList")).size();
		DgTemplate dgTemplate=((List<DgTemplate>)map.get("templateList")).get(listSize-1);
	  templateData= new String  (dgTemplate.getResult());
	  %> 
	  <%-- <%=templateData %> --%>
	  <%=appendedHtml%>
	  <%-- <%=Base64.decodeBase64(dgTemplate.getResult()) %> --%>
	  <%}else if(map.get("browse")!=null){
      %> <jsp:include
					page="/temp/temp.html" flush="true" /> <%} %> </textarea></td>
				
			</tr>
		</table>
		</td>
	</tr>
</table>
<div class="clear"></div>
<div id="hiddenTextArea" style="display: none"><textarea
	id="appendedHtml" name="appendedHtml"><%=appendedHtml %></textarea></div>
<!--Rich text editor ends--> <% if(map.get("templateList")!=null){
	int listSize=((List<DgTemplate>)map.get("templateList")).size();
	DgTemplate dgTemplate=((List<DgTemplate>)map.get("templateList")).get(listSize-1);
	int templateId=dgTemplate.getId();
%> <input type="hidden" name="<%=TEMPLATE_ID %>"
	value="<%=templateId %>" id="<%=TEMPLATE_ID %>" validate="templateId,int,no" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="update" align="left"
	onClick="updateTemplate();" /> <% }else{%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>

<input type="button" class="button" value="Submitererer" align="left"
	onClick="submitTemplatee();" /> <% }%> 
	<%if(deptType.equalsIgnoreCase("radio")){
	%>
	<input type="button"
	class="button" value="Back" align="left"
	onClick="submitFormForButton('chargeCode','investigation?method=showInvestigationForRadiologyJsp&'+csrfTokenName+'='+csrfTokenValue);" />
	<%}else{%>
	
	 <input type="button"
	class="button" value="Back" align="left"
	onClick="submitFormForButton('chargeCode','investigation?method=showInvestigationJsp&'+csrfTokenName+'='+csrfTokenValue);" />
	
	<%}%>
<div class="clear"></div>
<div class="division"></div></form>
<div class="paddingTop40"></div>