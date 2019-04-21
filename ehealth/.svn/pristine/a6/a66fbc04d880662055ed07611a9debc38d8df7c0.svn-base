<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<PrjScheduleDetail> prjScheduleDetailList = new ArrayList<PrjScheduleDetail>();
				List<PrjScheduleDocument> prjScheduleDocumentList = new ArrayList<PrjScheduleDocument>();
				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("prjScheduleDetailList")!= null){
					prjScheduleDetailList = (List)map.get("prjScheduleDetailList");
				}
				if(map.get("prjScheduleDocumentList")!= null){
					prjScheduleDocumentList = (List)map.get("prjScheduleDocumentList");
				}
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				int scheduleDetailId = 0;
			if(prjScheduleDetailList.size()>0){
				for(PrjScheduleDetail prjScheduleDetail:prjScheduleDetailList){
					scheduleDetailId = prjScheduleDetail.getId();
				}
			}
			int scheduleDocumentId= 0;
			if(prjScheduleDocumentList.size()>0){
				for(PrjScheduleDocument prjScheduleDocument:prjScheduleDocumentList){
					scheduleDocumentId = prjScheduleDocument.getId();
				}
			}
		%>
				
	
<%@page import="jkt.hrms.masters.business.PrjScheduleDetail"%>
<%@page import="jkt.hrms.masters.business.PrjScheduleDocument"%>
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
	var trId = '<%=scheduleDocumentId%>';
	//alert("filename--"+filename);

	document.attachScheduleDocument.method="post";
	submitForm('attachScheduleDocument','projectTracking?method=addCreateScheduleFile&filename='+filename+'&scheduleDocumentId='+trId+'&'+csrfTokenName+'='+csrfTokenValue);
}


function openPopupWindow()
			{ var id = 0; 
				 for(var i = 0; i < document.getElementsByName('fesbilitystudyId').length; i++){
					  if(document.getElementsByName('fesbilitystudyId')[i].checked == true)
		              {
						id = document.getElementsByName('fesbilitystudyId')[i].value;
					  }		
		  		}
		  		var url="/hms/hrms/projectTracking?method=viewSqApprovalDocument&fesbilitystudyId="+id+"&"+csrfTokenName+"="+csrfTokenValue;
		 		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		 	
			}

</script>


<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hrms.masters.business.TempTickattach"%>
<form name="attachScheduleDocument" method="post" action="" enctype="multipart/form-data">
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


<table id="searchresulttable" class="small">
<tr>

<th>Select</th>
<th>File</th>
<th>Comments</th>
</tr>
<%
	
	int i = 0;
	if(prjScheduleDocumentList.size()>0){
		for(PrjScheduleDocument prjScheduleDocument:prjScheduleDocumentList){
%>

<tr>
<td><input name="sqvisitUpdateId+i"  class="radioCheck"  type="checkbox"  value="<%=scheduleDocumentId%>" /></td>
<td><%=prjScheduleDocument.getFileName()%></td>
<td><%=prjScheduleDocument.getComment()%></td></tr>
<%i++;
	}}
%>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i%>">
<input type="hidden" id="travelRequestId" name="scheduleDetailId" value="<%=scheduleDetailId %>" /> 
<div class="clear"></div>

<input name="add" type="button" class="button" value="Add" onClick="jsImport();"/>
<input name="add" type="button" class="button" value="Close" onClick="window.close();"/>


<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

