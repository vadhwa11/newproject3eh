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
				 List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
				 /*List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>(); */
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
			if(hrTerminationProcessList.size()>0){
				for(HrTerminationProcess htp :hrTerminationProcessList){
					RequestId = htp.getId();
					if(htp.getEmployeeId().getId()!= null){
						employeeId = htp.getEmployeeId().getId();
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
	alert('Pl. Select a Image to Import!.....');
	return;
	}
	var fname = document.getElementById('fileNameId').value;
	
	var ind1 = fname.lastIndexOf("\\");
	
	var filename = fname.substring(ind1+1);
	document.attachFile.method="post";
	submitForm('attachFile','maintenance?method=addAttachFile&filename='+filename+'&'+csrfTokenName+'='+csrfTokenValue);
	
}

</script>


<%-- <%@page import="jkt.erp.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.erp.hrms.masters.business.TempTickattach"%> --%>
<form name="attachFile" method="post" action="" enctype="multipart/form-data">

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><div class="titleBg"> <h2>Upload File </h2></div>
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

<div class="division"></div>




<input type="hidden" id="countId" name="counter" value="<%="7"%>">
<input type="hidden" id="request_id" name="requestId" value="<%=request.getParameter("RequestId") %>" /> 
<input type="hidden"  name="<%=EMPLOYEE_ID %>" value="<%=employeeId %>" />  
<div class="clear"></div>

<input name="add" type="button" class="button" value="Add" onClick="jsImport();"/>



<script type="text/javascript">



function getTrainingId(val)
	{
		
	 	<%-- document.attachFile.<%=TICKET_ATTACH_ID%>.value =val; --%>
  	}


</script>

</form>

