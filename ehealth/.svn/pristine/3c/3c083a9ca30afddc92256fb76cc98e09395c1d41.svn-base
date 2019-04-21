<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
				List<PrjFedoc> sqVisitupdateList = new ArrayList<PrjFedoc>();
				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("sqVisitupdateList")!= null){
					sqVisitupdateList = (List)map.get("sqVisitupdateList");
				}
				if(map.get("feasibilityHeaderList")!= null){
					feasibilityHeaderList = (List)map.get("feasibilityHeaderList");
				}
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				int feasibilityHeaderId = 0;
			if(feasibilityHeaderList.size()>0){
				for(PrjFesStudyHeader prjFesStudyHeader :feasibilityHeaderList){
					feasibilityHeaderId = prjFesStudyHeader.getId();
				}
			}
			int squpdatefileId= 0;
			if(sqVisitupdateList.size()>0){
				for(PrjFedoc prjFedoc:sqVisitupdateList){
					squpdatefileId = prjFedoc.getId();
				}
			}
		%>
				
	
<%@page import="jkt.hrms.masters.business.PrjFesStudyHeader"%>
<%@page import="jkt.hrms.masters.business.PrjFedoc"%>
<script language="javascript">

function jsImport()
{
	if (document.getElementById('fileNameId').value == "")
		
	{
	alert('Pl. Select a file to Import!.....');
	return;
	}
	var fname = document.getElementById('fileNameId').value;
	
	//var st = fname.length;
	//st = st-3;
	//if (fname.substring(st)!="zip")
	//{
	//alert('Only zip files are Allowed. Please Zip all the Excel Files and Give the file as input !....For further Help, Refer User Manual.');
	//return;
	//}
	var ind1 = fname.lastIndexOf("\\");
	
	var filename = fname.substring(ind1+1);
	var trId = '<%=squpdatefileId%>';
	//alert("filename--"+filename);

	document.attachSQVisitUpdateDocument.method="post";
	submitForm('attachSQVisitUpdateDocument','projectTracking?method=addSqVisitUpdateFile&filename='+filename+'&sqvisitUpdateId='+trId+'&'+csrfTokenName+'='+csrfTokenValue);
}

</script>


<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hrms.masters.business.TempTickattach"%>
<form name="attachSQVisitUpdateDocument" method="post" action="" enctype="multipart/form-data">
<div class="titleBg"> <h2>Upload File </h2></div>
<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<label>File</label>
<input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse">
<div class="clear"></div>
<label>Comments</label>
<textarea    type="textarea" name="comments" value=""  validate="HotelDesc,string,no"  class="large" MAXLENGTH="60" tabindex=1></textarea>
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
	if(sqVisitupdateList.size()>0){
		for(PrjFedoc prjFedoc:sqVisitupdateList){
%>

<tr>
<td><input name="sqvisitUpdateId+i"  class="radioCheck"  type="checkbox"  value="<%=squpdatefileId%>" onChange="getTrainingId(this.value)"; /></td>
<td><%=prjFedoc.getFedOfilename()%></td>
<td><%=prjFedoc.getFedCmts()%></td></tr>
<%i++;
	}}
%>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i%>">
<input type="hidden" id="travelRequestId" name="<%=FES_STUDY_HEADER_ID%>" value="<%=feasibilityHeaderId %>" /> 
<div class="clear"></div>

<input name="add" type="button" class="button" value="Add" onClick="jsImport();"/>



<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

