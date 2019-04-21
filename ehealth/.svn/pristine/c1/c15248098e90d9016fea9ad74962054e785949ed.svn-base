<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<PrjReglSub>    regulatorySubList = new ArrayList<PrjReglSub>();
				List<PrjReglSubDoc> regulatorySubDocList = new ArrayList<PrjReglSubDoc>();
				
				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("regulatorySubList")!= null){
					regulatorySubList = (List)map.get("regulatorySubList");
				}
				if(map.get("regulatorySubDocList")!= null){
					regulatorySubDocList = (List)map.get("regulatorySubDocList");
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
			int regulatorySubId = 0;
			int projectId = 0;
			
			if(regulatorySubList.size()>0){
				for(PrjReglSub prjreglSub: regulatorySubList){
					regulatorySubId = prjreglSub.getId();
					projectId       = prjreglSub.getPrj().getId();
				}
			}
		%>
				
	
<%@page import="jkt.hrms.masters.business.PrjReglSub"%>
<%@page import="jkt.hrms.masters.business.PrjReglSubDoc"%>
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
	submitForm('attachFile','projectTracking?method=AttachReglSubDocFile&filename='+filename+'&'+csrfTokenName+'='+csrfTokenValue);
	
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
<textarea    type="textarea" name="<%=REGULATORY_DOC_COMMENTS %>" value=""  validate="Regulatory Doc Comments,string,no"  class="large" MAXLENGTH="200" tabindex=1></textarea>
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
	if(regulatorySubDocList.size()>0){
		for(PrjReglSubDoc prjreglsubDoc :regulatorySubDocList){
%>
<tr>
<td><input name="<%=REGULATORY_SUB_DOC_ID%><%=i%>"  class="radioCheck"  type="checkbox"  value="<%=prjreglsubDoc.getId()%>" onChange="getTrainingId(this.value)"; /></td>
<td><%=prjreglsubDoc.getPrjReglSubFilename() %></td>
<td><%=prjreglsubDoc.getDocComments()%></td>
</tr>
<%i++;
	}}
%>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i%>">
<input type="hidden" id="regulatorySubId" name="regulatorySubId" value="<%=regulatorySubId%>" /> 
<input type="hidden" id="projectId"       name="projectId"       value="<%=projectId%>">
<div class="clear"></div>

<input name="add" type="button" class="button" value="Add" onClick="jsImport();"/>

<input name="Delete" type="button"  class="button" value="Delete" onClick="submitForm('attachFile','projectTracking?method=deleteAttachReglSubDocFile&<%=REGULATORY_SUB_DOC_ID %>=<%=REGULATORY_SUB_DOC_ID%>&'+csrfTokenName+'='+csrfTokenValue);" />

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
<div class="clear"></div>

<script type="text/javascript">



function getTrainingId(val)
	{
		document.attachFile.<%=REGULATORY_SUB_DOC_ID%>.value =val;
  	}


</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

