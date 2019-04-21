<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.PrjFesStudyHeader"%>
<%@page import="jkt.hrms.masters.business.PrjFedoc"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
				List<PrjFedoc> prjFeasibilityDocumentList = new ArrayList<PrjFedoc>();
				String message = "";
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("feasibilityHeaderList")!= null){
					feasibilityHeaderList = (List)map.get("feasibilityHeaderList");
				}
				if(map.get("prjFeasibilityDocumentList")!= null){
					prjFeasibilityDocumentList = (List)map.get("prjFeasibilityDocumentList");
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
				int prjFedocId= 0;
				if(prjFeasibilityDocumentList.size()>0){
					for(PrjFedoc prjFedoc:prjFeasibilityDocumentList){
						prjFedocId = prjFedoc.getId();
					}
				}
		%>
				
	


<form name="expensesFile" method="post" action="" enctype="multipart/form-data">
<div class="titleBg"> <h2>Download File </h2></div>
<table id="searchresulttable" class="small">
<tr>
<th>File</th>
<th>Comments</th>
</tr>
<%
	int i = 0;
	if(prjFeasibilityDocumentList.size()>0){
		for(PrjFedoc prjFedoc :prjFeasibilityDocumentList){
%>
<tr>

<td><a href="projectTracking?method=ShowQaApprovalDocument&filename=<%=prjFedoc.getFedDfilename()%>&csrfTokenName=csrfTokenValue"><%=prjFedoc.getFedDfilename()%></a></td>
<td><%=prjFedoc.getFedCmts() %>
<input type="hidden" id="travelRequestId" name="<%=FES_STUDY_HEADER_ID %>" value="<%=feasibilityHeaderId %>" /> 
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

