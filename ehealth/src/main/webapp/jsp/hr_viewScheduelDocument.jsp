<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.PrjFesStudyHeader"%>
<%@page import="jkt.hrms.masters.business.PrjFedoc"%>
<%@page import="jkt.hrms.masters.business.PrjScheduleDetail"%>
<%@page import="jkt.hrms.masters.business.PrjScheduleDocument"%>
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
				
	


<form name="expensesFile" method="post" action="" enctype="multipart/form-data">
<div class="titleBg"> <h2>Upload File </h2></div>
<table id="searchresulttable" class="small">
<tr>
<th>File</th>
<th>Comments</th>
</tr>
<%
	int i = 0;
	if(prjScheduleDocumentList.size()>0){
		for(PrjScheduleDocument prjScheduleDocument :prjScheduleDocumentList){
%>
<tr>

<td><a href="projectTracking?method=ShowScheduleDocument&filename=<%=prjScheduleDocument.getFileName()%>csrfTokenName=csrfTokenValue"><%=prjScheduleDocument.getFileName()%></a></td>
<td><%=prjScheduleDocument.getComment()%>
<input type="hidden" id="travelRequestId" name="scheduleDetailId" value="<%=scheduleDetailId %>" /> 
</tr>
<%i++;
	}}
%>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i%>">
<input name="button" type="button"  class="button" value="Close" onClick="window.close();" />
<div class="clear"></div>



<div class="clear"></div>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

