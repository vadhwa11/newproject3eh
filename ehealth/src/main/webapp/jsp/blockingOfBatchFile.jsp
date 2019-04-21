<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<%@page import="jkt.hrms.util.HrmsRequestConstants"%>
<%@page import="jkt.hms.masters.business.HrTerminationProcess"%>
<%-- <%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %> --%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.HrTerminationProcess"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				 List<UploadDocuments> uploadDocuments=new ArrayList<UploadDocuments>();
				String message = "";
				Integer requestId=0;
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("uploadDocuments")!= null){
					uploadDocuments = (List)map.get("uploadDocuments");
				}
				if(request.getParameter("RequestId")!=null){
					requestId=Integer.parseInt((String)request.getParameter("RequestId"));
				}

			int RequestId = 0;	
			int employeeId = 0;

		%>
				
	
<script language="javascript">

function jsImport()
{
	if (document.getElementById('fileNameId').value == "")
		
	{
	alert('Pl. Select a file to Import!.....');
	return;
	}
	var fname = document.getElementById('fileNameId').value;
	var requestId= document.getElementById("RequestId").value;
	var ind1 = fname.lastIndexOf("\\");
	var filename = fname.substring(ind1+1);
	document.getElementById("fileName").value=filename;
	document.attachFile.method="post";
	submitForm('attachFile','maintenance?method=addAttachFile');
	
}

</script>


<%-- <%@page import="jkt.erp.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.erp.hrms.masters.business.TempTickattach"%> --%>
<form name="attachFile" method="post" action="" enctype="multipart/form-data">
<div class="titleBg"> <h2>Upload File </h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>File</label>
<%--  <input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse">  --%>
 <input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse"> 
<div class="clear"></div>
<label>Comments</label>
<textarea    type="textarea" name="comments" value=""  validate="Comments,string,no"  class="large" MAXLENGTH="60" tabindex=1></textarea>
<div class="clear"></div>
</div>
<div class="division"></div>


<table id="searchresulttable" class="small">
<tr>
<th>Select</th>
<th>File</th>
<th>Comments</th>
</tr>
 <%
	int i = 0;
	if(uploadDocuments.size()>0){
		for(UploadDocuments doc :uploadDocuments){
			requestId=doc.getRequest().getId();
%>
<tr>
<td><input name="DocumentId"  class="radioCheck"  type="checkbox"  value="<%=doc.getId()%>"  /></td>
<td><a href="maintenance?method=viewBookingDetailDocuments&filename=<%=doc.getFileName()%>&csrfTokenName=csrfTokenValue"><%=doc.getFileName()%></a></td>
<td><%=!doc.getDescription().equals( "") ? doc.getDescription(): " - "%></td>
</tr>
<%i++;
	}}
%> 
</table>

<input type="hidden" id="countId" name="counter" value="<%=i%>">
<input type="hidden" id="RequestId" name="RequestId" value="<%=requestId %>" /> 
<input type="hidden"  name="<%=EMPLOYEE_ID %>" value="<%=employeeId %>" />  
<input type="hidden" id="fileName" name="fileName" vale="" />
<div class="clear"></div>

<input name="add" type="button" class="button" value="Add" onClick="jsImport();"/>
<input name="Delete" type="button"  class="button" value="Delete" onClick="if(validate()){submitForm('attachFile','maintenance?method=deleteAttachFile&'+csrfTokenName+'='+csrfTokenValue);}" />
<input name="add" type="button" class="button" value="Close" onClick="window.close();"/>
<div class="clear"></div>

<script type="text/javascript">

 function validate(){
	 var DocumentId=document.getElementsByName("DocumentId");
	 var checkLength=0;
	 for(var i=0;i<DocumentId.length;i++){
		 if(DocumentId[i].checked){
			 checkLength=checkLength+1;
		 }
	 }
	 if(checkLength>0){
		 return true;
	 }else{
		 alert("Select File");
		 return false;
	 }
 }



</script>


		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

