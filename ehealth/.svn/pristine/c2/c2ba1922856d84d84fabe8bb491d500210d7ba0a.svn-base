<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.StoreTenderInvitationLetter"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<style>
<!--
html,body {
	overflow: auto;
}
-->
</style>
<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>

<script type="text/javascript">
/***********************************************
* Textarea Maxlength script-
***********************************************/
function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}
</script>



<style type="text/css">
<!--
.locatorArrow {
	COLOR: #666666;
	FONT-FAMILY: Verdana;
	FONT-SIZE: 12px
}
</style>

<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;

	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	Map<String,Object> map = new HashMap<String,Object>();
	StoreTenderInvitationLetter storeTenderInvitationLetter = null;
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
		}

	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
	}

	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	} %>


<script>


function jsAdd(act)
{
		if (tenderInvitationDraftingForm.<%=TENDER_INVITATION_LETTER_FILE_NO%>.value=="" ||
			tenderInvitationDraftingForm.<%=TENDER_INVITATION_LETTER_FILE_DATE%>.value=="" ||
			tenderInvitationDraftingForm.<%=TENDER_INVITATION_LETTER_SUBJECT%>.value=="" ||
			tenderInvitationDraftingForm.<%=TENDER_INVITATION_LETTER_CONTENT%>.value=="")
			{
			alert("Pl. check your input.....");
			return;
			}

		//if (document.getElementById('upload_filename').value == "")
		//{
		//alert('Pl. Select upload document!.....');
		//return;
		//}
		var fname = document.getElementById('upload_filename').value;
		var ind1 = fname.lastIndexOf("\\");
		if(fname!=""){
			var upload_filename = fname.substring(ind1+1);
			if(upload_filename.lastIndexOf(".doc")==-1){
			alert("File Type is InCorrect choose Another");
			document.getElementById('upload_filename').value="";
			return false;
			}
		}
		
		var tenderInvitationFileNo;
		var tenderInvitationFileDate;
		var tenderInvitationLetterSubject;
		var tenderInvitationLetterContent;
		
		tenderInvitationFileNo=tenderInvitationDraftingForm.<%=TENDER_INVITATION_LETTER_FILE_NO%>.value;
		tenderInvitationFileDate=tenderInvitationDraftingForm.<%=TENDER_INVITATION_LETTER_FILE_DATE%>.value;
		tenderInvitationLetterSubject=tenderInvitationDraftingForm.<%=TENDER_INVITATION_LETTER_SUBJECT%>.value;
		tenderInvitationLetterContent=tenderInvitationDraftingForm.<%=TENDER_INVITATION_LETTER_CONTENT%>.value;
		
		tenderInvitationDraftingForm.method="post";
		submitForm('tenderInvitationDraftingForm','tender?method=addInvitationLetterDetails&action='+act+'&upload_filename='+upload_filename+'&tenderInvitationFileNo='+tenderInvitationFileNo+'&tenderInvitationFileDate='+tenderInvitationFileDate+'&tenderInvitationLetterSubject='+tenderInvitationLetterSubject+'&tenderInvitationLetterContent='+tenderInvitationLetterContent+'&'+csrfTokenName+'='+csrfTokenValue);
		jsClose();
}


function jsClose()
{
  window.opener.location.href = "tender?method=showInvitationForTenderJspWithGridData&currPage=1&<%=TENDER_SUPPLIER_GROUP_ID%>="+tenderInvitationDraftingForm.<%=TENDER_SUPPLIER_GROUP_ID%>.value + "&<%=TENDER_LETTER_NO%>="+tenderInvitationDraftingForm.<%=TENDER_LETTER_NO%>.value + "&<%=TENDER_NO%>="+tenderInvitationDraftingForm.<%=TENDER_NO%>.value + "&numOfRows=7&pageCount=10";
  if (window.opener.progressWindow)
	 {
    	window.opener.progressWindow.close()
  	 }
  window.close();
}
function checkImportFile()
{

	
}
</script>
<div class="titleBg">
<h2>Tender Invitation Letter Drafting</h2></div>
<div class="clear"></div>

<form name="tenderInvitationDraftingForm"  enctype="multipart/form-data">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="hidden"
	name="<%=TENDER_SUPPLIER_GROUP_ID%>"
	value="<%=box.get(TENDER_SUPPLIER_GROUP_ID) %>"> <input
	type="hidden" name="<%=TENDER_LETTER_NO %>"
	value="<%=box.get(TENDER_LETTER_NO)%>"> <input type="hidden"
	name="<%=TENDER_NO %>" value="<%=box.get(TENDER_NO)%>"> <input
	type="hidden" name="flag" value="<%=box.get("flag")%>">

<h4>Invitation Letter</h4>

<div class="clear"></div>
<div class="Block">
<label>File No:</label> 
<input
	type="text" class="large" name="<%=TENDER_INVITATION_LETTER_FILE_NO%>"
	value="<%=(map.get(TENDER_INVITATION_LETTER_FILE_NO)==null)?"":map.get(TENDER_INVITATION_LETTER_FILE_NO)%>"
	maxlength="50" /> 
	<div class="clear"></div>
	<label>Letter Date:</label> <input type="text"
	class="calDate" name="<%=TENDER_INVITATION_LETTER_FILE_DATE%>"
	value="<%=(map.get(TENDER_INVITATION_LETTER_FILE_DATE)==null)?"":map.get(TENDER_INVITATION_LETTER_FILE_DATE)%>"
	validate="Pick a Date" readonly /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender" tabindex="1"
	onClick="setdate('<%=date%>',document.tenderInvitationDraftingForm.<%=TENDER_INVITATION_LETTER_FILE_DATE%>,event)" />

<div class="clear"></div>

<label>Subject</label> <textarea
	name="<%=TENDER_INVITATION_LETTER_SUBJECT%>" cols="50" rows="2"
	maxlength="100" onkeyup="return ismaxlength(this)" class="large"><%=(map.get(TENDER_INVITATION_LETTER_SUBJECT)==null)?"":map.get(TENDER_INVITATION_LETTER_SUBJECT)%></textarea>

<div class="clear"></div>

<label>Content</label> <textarea
	name="<%=TENDER_INVITATION_LETTER_CONTENT%>" cols="100" rows="20"
	maxlength="4000" class="large2" onkeyup="return ismaxlength(this)"
	class="textarea"><%=(map.get(TENDER_INVITATION_LETTER_CONTENT)==null)?"":map.get(TENDER_INVITATION_LETTER_CONTENT)%></textarea>
<div class="clear"></div>
<label>Upload Document</label>
<input type="file" name="upload_filename" id="upload_filename" class="browse">
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<% if (box.getString("flag").equals("Add")) { %> <input type="button"
	name="Submit" id="addbutton" value="Add" class="button"
	onClick="jsAdd('A');" accesskey="a" /> <input type="reset"
	name="Reset" value="Reset" class="button" onclick="location.reload();"
	accesskey="r" /> <input type="button" name="Close" value="Close"
	class="button" onclick="jsClose();" /> <% } else { %>
	
	
<%--
String fileName = "D:/MNS/1.doc";


BufferedReader is = new BufferedReader(new FileReader(fileName));


String fileData = "";


while((fileData = is.readLine()) != null)
{
out.println(fileData);
}
--%>
<%
String upload_filename="";
if(map.get("upload_filename")!=null){
	upload_filename=(String)map.get("upload_filename");
}
if(upload_filename!=""){
%>
<label>View Document</label>
<a href="tender?method=viewTenderDocuments&filename=<%=upload_filename%>"><%=upload_filename%></a>
<%	
}
%>


<div class="clear"></div>
	 <label>&nbsp;</label>
<input type="button" name="Update" id="addbutton" value="Update"
	class="button" onClick="jsAdd('U');" /> <input type="button"
	name="Close" value="Close" class="button" onclick="jsClose();" /> <% } %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
</div>
