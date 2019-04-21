<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<%@page import="jkt.hrms.util.HrmsRequestConstants"%>
<%@page import="jkt.hms.masters.business.HrTerminationProcess"%>
<%-- <%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %> --%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.HrTerminationProcess"%>
<%@page import="jkt.hms.masters.business.HrEmployeeDeputation"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				 List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
					List<HrEmployeeDeputation> hrEmployeeDeputationList = new ArrayList<HrEmployeeDeputation>();
				 /*List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>(); */
				 List<UploadDocuments> tempdocAttachList = new ArrayList<UploadDocuments>(); 
				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("hrTerminationProcessList")!= null){
					hrTerminationProcessList = (List)map.get("hrTerminationProcessList");
				}
				if(map.get("hrEmployeeDeputationList")!= null){
					hrEmployeeDeputationList = (List)map.get("hrEmployeeDeputationList");
				}	
				 if(map.get("tempdocAttachList")!= null){
					 tempdocAttachList = (List)map.get("tempdocAttachList");
					}
				 System.out.println(">>in jsp>>"+	tempdocAttachList.size());
				/* if(map.get("tempTicketAttachList")!= null){
					tempTicketAttachList = (List)map.get("tempTicketAttachList");
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}*/
			int RequestId = 0;	
			int employeeId = 0;
			if(hrEmployeeDeputationList.size()>0){
				for(HrEmployeeDeputation hep :hrEmployeeDeputationList){
					RequestId = hep.getId();
					if(hep.getEmployee()!= null){
						employeeId = hep.getEmployee().getId();
					}
				}
			}
		
			
			/* int ticketAttachId = 0;
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
	
	var ind1 = fname.lastIndexOf("\\");
	
	var filename = fname.substring(ind1+1);
	document.attachFile.method="post";
	submitForm('attachFile','training?method=addAttachFile&filename='+filename);
	
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
	if(tempdocAttachList.size()>0){
		for(UploadDocuments uploadDoc :tempdocAttachList){
%>
<tr>
<td><input name="<%="TICKET_ATTACH_ID"%><%=i%>"  class="radioCheck"  type="checkbox"  value="<%=uploadDoc.getId()%>"  /></td>
<td><a href="etravel?method=viewBookingDetailDocuments&filename=<%=uploadDoc.getFileName()%>&csrfTokenName=csrfTokenValue"><%=uploadDoc.getFileName()%></a></td>
<td><%= uploadDoc.getDescription() != null ? uploadDoc.getDescription() :"" %></td>
</tr>
<%i++;
	}}
%>
</table>

<input type="hidden" id="countId" name="counter" value="<%="7"%>">
<input type="hidden" id="request_id" name="request_id" value="<%=RequestId %>" /> 
<input type="hidden"  name="<%=EMPLOYEE_ID %>" value="<%=employeeId %>" />  
<div class="clear"></div>

<input name="add" type="button" class="button" value="Add" onClick="jsImport();"/>

<input name="Delete" type="button"  class="button" value="Delete" onClick="submitForm('attachFile','training?method=deleteAttachFileDepute&'+csrfTokenName+'='+csrfTokenValue);" />

<input name="add" type="button" class="button" value="Close" onClick="window.close();"/>
<div class="clear"></div>

<script type="text/javascript">



function getTrainingId(val)
	{
		
	 	<%-- document.attachFile.<%=TICKET_ATTACH_ID%>.value =val; --%>
  	}


</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

