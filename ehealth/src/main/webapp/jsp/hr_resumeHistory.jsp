<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@page import="jkt.hrms.recruitment.masters.business.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<div id="contentspace">
<%
	Map historyMap = (Map)request.getAttribute("map");
	List tableHeaderList = (List)historyMap.get("tableHeaderList");
	List tableValueList = (List)historyMap.get("tableValueList");
	String objectType = (String)historyMap.get("objectType");
	String candidateName = (String)historyMap.get("candidateName");
	if(tableValueList != null && tableValueList.size() > 0)
	{
	
%>

<form name=edit_complaint method=post action="">
<%
	
		if(objectType.equals("technical"))
		{
	 %>
<h3>Technical Evaluation History of <%= candidateName%></h3>
<%	
		for (Iterator iter = tableValueList.iterator(); iter.hasNext();) 
			{
				int j=0;
				Resumetechnicalhistory resumeTechnicalHistory=(Resumetechnicalhistory)iter.next();
				String status = resumeTechnicalHistory.getStatus();
	%>
<fieldset><legend><strong>Updated
Date:&nbsp;&nbsp;<font color=blue><%=HMSUtil.convertDateToStringTypeDate(resumeTechnicalHistory.getDate())%></font></strong></legend>
<label><strong>Status</strong></label><span><%=status %></span><br>
<label><strong><%=tableHeaderList.get(j)%>:</strong></label><span><%= resumeTechnicalHistory.getInterviewerName()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeTechnicalHistory.getRelevantExperience()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeTechnicalHistory.getDateOfInterview()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeTechnicalHistory.getTechnicalKnowledge()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span>
<table>
	<tr>
		<td><%= resumeTechnicalHistory.getMajorStrength()%></td>
	</tr>
</table>
</span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span>
<table>
	<tr>
		<td><%= resumeTechnicalHistory.getMajorWeakness()%></td>
	</tr>
</table>
</span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span>
<table>
	<tr>
		<td><%= resumeTechnicalHistory.getAreaProbed()%></td>
	</tr>
</table>
</span><br />
<%if(status.equals("Selected")){
				status = "Recommended";
			%> <label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= status%></span><br />
<%}
			if(status.equals("OnHold") || status.equals("Rejected")){%> <label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= status%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span>
<table>
	<tr>
		<td><%= resumeTechnicalHistory.getReasonHold()%></td>
	</tr>
</table>
</span><br />
<%}%>

</fieldset>
<br />
<%     }
	  }
	  else if(objectType.equals("hr"))
	  {
	 %>
<h3>HR Evaluation History of <%= candidateName%></h3>
<%
	  	for (Iterator iter = tableValueList.iterator(); iter.hasNext();) 
			{
				int j=0;
				String status = "";
				Resumehrdetailshistory resumeHRHistory=(Resumehrdetailshistory)iter.next();
				if(resumeHRHistory.getRecommended().equalsIgnoreCase("yes"))
				{
					if(resumeHRHistory.getApprovalDirector().equalsIgnoreCase("yes"))
					{
						status="HR Selected";
					}
					else
					{
						status="HR On-Hold";
					}
				}
				else
				{
					status = "HR Rejected";
				}
	%>
<fieldset><legend><strong>Updated
Date:&nbsp;&nbsp;<font color=blue><%=HMSUtil.convertDateToStringTypeDate(resumeHRHistory.getDate())%></font></strong></legend>
<label><strong>Status</strong></label><span><%=status%></span><br>
<label><strong><%=tableHeaderList.get(j)%>:</strong></label><span><%= resumeHRHistory.getInterviewerName()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeHRHistory.getMaritalStatus()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeHRHistory.getLocationPreference()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span>
<table>
	<tr>
		<td><%= resumeHRHistory.getFamilyDetails()%></td>
	</tr>
</table>
</span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span>
<table>
	<tr>
		<td><%= resumeHRHistory.getReportingStructure()%></td>
	</tr>
</table>
</span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span>
<table>
	<tr>
		<td><%= resumeHRHistory.getReasonToLeave()%></td>
	</tr>
</table>
</span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeHRHistory.getHrRatings()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span>
<table>
	<tr>
		<td><%= resumeHRHistory.getOverallAssesment()%></td>
	</tr>
</table>
</span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeHRHistory.getRecommended()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeHRHistory.getApprovalDirector()%></span><br />
</fieldset>
<br />

<%     }
	  }
	  else if(objectType.equalsIgnoreCase("status"))
	  { 
	  	List statusMasterList = (List)historyMap.get("statusMasterList");
	 %>
<h3>Status History of <%= candidateName%></h3>
<%
	  	String status = "";
	  	for (Iterator iter = tableValueList.iterator(); iter.hasNext();) 
		{
				int j = 0;
				Resumestatushistory resumeStatusHistory=(Resumestatushistory)iter.next();
				Iterator statusMasterIterator = statusMasterList.iterator();
				while(statusMasterIterator.hasNext())
			 	{
			 		Resumestatusmaster resumeStatusMaster=(Resumestatusmaster)statusMasterIterator.next();
			 		int statusMasterId=resumeStatusMaster.getId();
			 		int statusHistoryId=resumeStatusHistory.getStatusId();
			 		if(statusMasterId == statusHistoryId)
			 		{
			 			 status = resumeStatusMaster.getStatusDesc();
			 			 break;
			 		}
					 				 	
				}
	%>
<fieldset><legend><strong>Updated
Date:&nbsp;&nbsp;<font color=blue><%=HMSUtil.convertDateToStringTypeDate(resumeStatusHistory.getDate())%></font></strong></legend>
<label><strong><%=tableHeaderList.get(j)%>:</strong></label><span><%= status %></span><br />
<%if("Offered".equalsIgnoreCase(status)) 
			{%> <label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeStatusHistory.getDesignationAssign()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeStatusHistory.getCurrentCTC()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeStatusHistory.getCurrency()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeStatusHistory.getExpectedCTC()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeStatusHistory.getDateOfJoin()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeStatusHistory.getSalaryRemarks()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeStatusHistory.getLocation()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span><%= resumeStatusHistory.getProjectAssign()%></span><br />
<label><strong><%=tableHeaderList.get(++j)%>:</strong></label><span>
<table>
	<tr>
		<td><%= resumeStatusHistory.getRemarks()%></td>
	</tr>
</table>
</span><br />
<%} %>
</fieldset>
<br />

<%    
		 }
	   }
	%> <%
  		}
  		else if(tableValueList == null || (tableValueList.size() == 0))
  		{
   %>
<h2>No History Available.</h2>

<%	
		} 
 	%> <br />
<br />
<br />

<center><input type="button" name="back" value="Back"
	class="button" onClick="history.back()"></center>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>