<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
	List<PrjFesStudyDetail> feasibilityStudyDetailList = new ArrayList<PrjFesStudyDetail>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("feasibilityStudyDetailList")!= null){
					feasibilityStudyDetailList = (List)map.get("feasibilityStudyDetailList");
				}
				
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				
				
	%>


<%@page import="jkt.hrms.masters.business.PrjFesStudyDetail"%>
<table>
<tr>
<th>Call Date</th>
<th>Comments</th>
</tr>
<%
		if(feasibilityStudyDetailList.size()>0){		
			for(PrjFesStudyDetail prjFesStudyDetail :feasibilityStudyDetailList){
%>
<tr>
<td><%=HMSUtil.convertDateToStringWithoutTime(prjFesStudyDetail.getCallDate()) %></td>
<td><%=prjFesStudyDetail.getCallResponse() %></td>
</tr>
<%}} %>
</table>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
