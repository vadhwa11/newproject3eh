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
				List<EtrTravelreq> etrTravelRequestList = new ArrayList<EtrTravelreq>();
				List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>();
				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				/* if(map.get("etrTravelRequestList")!= null){
					etrTravelRequestList = (List)map.get("etrTravelRequestList");
				}
				if(map.get("tempTicketAttachList")!= null){
					tempTicketAttachList = (List)map.get("tempTicketAttachList");
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
			int travelRequestId = 0;	
			int employeeId = 0;
			if(etrTravelRequestList.size()>0){
				for(EtrTravelreq etrTravelreq :etrTravelRequestList){
					travelRequestId = etrTravelreq.getId();
					if(etrTravelreq.getEmp().getId()!= null){
						employeeId = etrTravelreq.getEmp().getId();
					}
				}
			}
		
			
			int ticketAttachId = 0;
			if(tempTicketAttachList.size()>0){
				for(TempTickattach tempTickattach :tempTicketAttachList){
					ticketAttachId = tempTickattach.getId();
				}
			} */
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
	
	
	//var st = fname.length;
	//st = st-3;
	//if (fname.substring(st)!="zip")
	//{
	//alert('Only zip files are Allowed. Please Zip all the Excel Files and Give the file as input !....For further Help, Refer User Manual.');
	//return;
	//}
	var ind1 = fname.lastIndexOf("\\");
	
	var filename = fname.substring(ind1+1);
	document.attachFile.method="post";
	submitForm('attachFile','etravel?method=addAttachFile&filename='+filename+csrfTokenName+'='+csrfTokenValue);
	
}

</script>


<%-- <%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hrms.masters.business.TempTickattach"%> --%>
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
<%-- <%
	int i = 0;
	if(tempTicketAttachList.size()>0){
		for(TempTickattach tempTickattach :tempTicketAttachList){
%>
<tr>
<td><input name="<%=TICKET_ATTACH_ID%><%=i%>"  class="radioCheck"  type="checkbox"  value="<%=tempTickattach.getId()%>"  /></td>
<td><a href="etravel?method=viewBookingDetailDocuments&filename=<%=tempTickattach.getTdsaDfilename()%>"><%=tempTickattach.getTdsaDfilename()%></a></td>
<td><%=tempTickattach.getTdsaCmts()%></td>
</tr>
<%i++;
	}}
%> --%>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i%>">
<input type="hidden" id="travelRequestId" name="<%=TRAVEL_REQUEST_ID %>" value="<%=travelRequestId %>" /> 
<input type="hidden"  name="<%=EMPLOYEE_ID %>" value="<%=employeeId %>" /> 
<div class="clear"></div>

<input name="add" type="button" class="button" value="Add" onClick="jsImport();"/>

<input name="Delete" type="button"  class="button" value="Delete" onClick="submitForm('attachFile','etravel?method=deleteAttachFile&'+csrfTokenName+'='+csrfTokenValue);" />

<input name="add" type="button" class="button" value="Close" onClick="window.close();"/>
<div class="clear"></div>

<script type="text/javascript">



function getTrainingId(val)
	{
		
	 	document.attachFile.<%=TICKET_ATTACH_ID%>.value =val;
  	}


</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

