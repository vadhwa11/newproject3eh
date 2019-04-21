<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				
				List<PrjAnsEntry>    ansEntryList = new ArrayList<PrjAnsEntry>();
				List<PrjAnsEntryDoc> ansEntryDocList = new ArrayList<PrjAnsEntryDoc>();
				
				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("ansEntryList")!= null){
					ansEntryList = (List)map.get("ansEntryList");
				}
				if(map.get("ansEntryDocList")!= null){
					ansEntryDocList = (List)map.get("ansEntryDocList");
				}
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
			int ansEntryId = 0;
			int projectId = 0;
			
			if(ansEntryList.size()>0){
				for(PrjAnsEntry prjAnsEntry: ansEntryList){
					ansEntryId = prjAnsEntry.getId();
					projectId  = prjAnsEntry.getProject().getId();
				}
			}
		%>
				
	
<%@page import="jkt.hrms.masters.business.PrjAnsEntry"%>
<%@page import="jkt.hrms.masters.business.PrjAnsEntryDoc"%>
<script language="javascript">

function jsImport()
{
	if (document.getElementById('fileNameId').value == "")
		
	{
	alert('Pl. Select a file to Import!.....');
	return;
	}
	var fname = document.getElementById('fileNameId').value;
	
	var ind1 = fname.lastIndexOf("\\");
	var filename = fname.substring(ind1+1);
	
	document.attachFile.method="post";
	submitForm('attachFile','projectTracking?method=attachAnsEntryDocFile&filename='+filename);
	
}

</script>

<form name="attachFile" method="post" action="" enctype="multipart/form-data">
<div class="titleBg"> <h2>Upload File </h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<label>File</label>
<input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse" />
<div class="clear"></div>
<label>Comments</label>
<textarea    type="textarea" name="<%=ANS_ENTRY_DOC_COMMENTS %>" value=""  validate="AnsEntryDoc Comments,string,no"  class="large" MAXLENGTH="300" tabindex=1></textarea>
<div class="clear"></div>
<div class="division"></div>


<table id="searchresulttable">
<tr>
<th>Select</th>
<th>File</th>
<th>Comments</th>
</tr>
<%
	int i = 0;
	if(ansEntryDocList.size()>0){
		for(PrjAnsEntryDoc prjAnsEntryDoc :ansEntryDocList){
%>
<tr>
<td><input name="<%=ANS_ENTRY_DOC_ID%><%=i%>"  class="radioCheck"  type="checkbox"  value="<%=prjAnsEntryDoc.getId()%>" onChange="getTrainingId(this.value)"; /></td>
<td><%=prjAnsEntryDoc.getAnsEntryDocFilenmae() %></td>
<td><%=prjAnsEntryDoc.getAnsEntryDocComments()%></td>
</tr>
<%i++;
	}}
%>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i%>">
<input type="hidden" id="ansEntryId"    name="ansEntryId"    value="<%=ansEntryId%>" /> 
<input type="hidden" id="projectId"       name="projectId"       value="<%=projectId%>">
<div class="clear"></div>

<input name="add" type="button" class="button" value="Add" onClick="jsImport();"/>

<input name="Delete" type="button"  class="button" value="Delete" onClick="submitForm('attachFile','projectTracking?method=deleteAttachAnsEntryDocFile&<%=ANS_ENTRY_DOC_ID %>=<%=ANS_ENTRY_DOC_ID%>&'+csrfTokenName+'='+csrfTokenValue);" />

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
<div class="clear"></div>

<script type="text/javascript">



function getTrainingId(val)
	{
		document.attachFile.<%=ANS_ENTRY_DOC_ID%>.value =val;
  	}


</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

