<%@page import="java.util.Map"%>
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hrms.masters.business.HrNoticeBoardData"%>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<div class="paddingTop15"></div>
<div class="clear"></div>


<div class="paddLeft55">
<h3>Welcome To HR Management System</h3>
</div>
<div class="clear"></div>

<%
	Map<String,Object> map=(Map)request.getAttribute("map");;	
	int waitingLeaveListSize=0;
	int todayApprovedLeavesListSize=0;
	int resourceRequisitionListSize = 0;
	int approvedRequestStatusMasterListSize = 0;
	int joinedCandidatesSize =0 ;
	int lateCandidatesSize =0;
	int  hrNoticeBoardListSize = 0;
	List<HrNoticeBoardData> hrNoticeBoardList = new ArrayList<HrNoticeBoardData>();
	
	if(map.get("waitingLeavesListSize")!=null){
		waitingLeaveListSize=(Integer)map.get("waitingLeavesListSize");
	}

	if(map.get("todayApprovedLeavesListSize")!=null){
		todayApprovedLeavesListSize = (Integer)map.get("todayApprovedLeavesListSize");
	}

	if(map.get("resourceRequisitionListSize")!=null){
		resourceRequisitionListSize = (Integer)map.get("resourceRequisitionListSize");
	}

	if(map.get("approvedRequestStatusMasterListSize")!=null){
		approvedRequestStatusMasterListSize = (Integer)map.get("approvedRequestStatusMasterListSize");
	}

	if(map.get("joinedCandidatesSize")!=null){
		joinedCandidatesSize = (Integer)map.get("joinedCandidatesSize");
	}

	if(map.get("lateCandidatesSize")!=null){
		lateCandidatesSize = (Integer)map.get("lateCandidatesSize");
	}

	if(map.get("hrNoticeBoardList")!=null){
		hrNoticeBoardList = (List)map.get("hrNoticeBoardList");
	}

%>

<div class="clear"></div>

<form name="<%=DASH_BOARD %>" method="post" action=""><!--              HR   Data          -->

<div class="red">
<div class="boardTitle"><img
	src="/hms/jsp/images/dashboard/HR.jpg" alt="HR" /></div>
<div class="boardtable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col" class="noBorderRyt">Particulars</th>
		<th scope="col" class="noBorderLft">Status</th>
	</tr>
	<tr>
		<td><a href="/hms/hms/personnel?method=showAllJoinedCandidate">All
		Joined Candidate </a></td>
		<td><%=joinedCandidatesSize %></td>
	</tr>
	<tr>
		<td></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</div>
</div>


<!--              Leave  Data          -->


<div class="blue">
<div class="boardTitle"><img
	src="/hms/jsp/images/dashboard/leave.jpg" alt="Leave" /></div>
<div class="boardtable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col" class="noBorderRyt">Particulars</th>
		<th scope="col" class="noBorderLft">Status</th>
	</tr>
	<tr>
		<td><a href="/hms/hrms/leave?method=showWaitingLeaves">Waiting
		for approval</a></td>
		<td><%=waitingLeaveListSize %></td>
	</tr>
	<tr>
		<td><a
			href="/hms/hrms/leave?method=showApprovedLeavesInCurrentDate">On
		leave (today) </a></td>
		<td><%=todayApprovedLeavesListSize %></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>
</div>
</div>


<!--              Recruitment   Data          -->


<div class="yellow">
<div class="boardTitle"><img
	src="/hms/jsp/images/dashboard/Recruitment.jpg" alt="Recruitment" /></div>
<div class="boardtable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col" class="noBorderRyt">Particulars</th>
		<th scope="col" class="noBorderLft">Status</th>
	</tr>
	<tr>
		<td><a
			href="/hms/hrms/recruitment?method=showRequestApprovalScreen">Pending
		Man Power Request</a></td>
		<td><%=resourceRequisitionListSize %></td>
	</tr>
	<tr>
		<td><a href="/hms/hrms/recruitment?method=showApprovedRequest">
		Approved Requests </a></td>
		<td><%=approvedRequestStatusMasterListSize %></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>


</div>
</div>

<div class="greenLight">
<div class="boardTitle"><img
	src="/hms/jsp/images/dashboard/Attendance.jpg" alt="Attendance" /></div>
<div class="boardtable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col" class="noBorderRyt">Particulars</th>
		<th scope="col" class="noBorderLft">Status</th>
	</tr>
	<tr>
		<td>Waiting for approval</td>
		<td>5</td>
	</tr>
	<tr>
		<td>On leave (today)</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>Disaproved</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>


</div>
</div>
<!--<div class="blankBlock"></div>-->

<div class="noticeBoard">
<div class="noticeTxt">
<%for(HrNoticeBoardData hrNoticeBoardData : hrNoticeBoardList){ %> <%=hrNoticeBoardData.getNoticeData() %><br />

<%} %>
</div>
</div>


<div class="pink">
<div class="boardTitle"><img
	src="/hms/jsp/images/dashboard/loanAdvance.jpg" alt="Loan and Advance" /></div>
<div class="boardtable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col" class="noBorderRyt">Particulars</th>
		<th scope="col" class="noBorderLft">Status</th>
	</tr>
	<tr>
		<td>Waiting for approval</td>
		<td>5</td>
	</tr>
	<tr>
		<td>On leave (today)</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>Disaproved</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>


</div>
</div>

<!--<div class="blankBlock"></div>-->



<div class="violet">
<div class="boardTitle"><img
	src="/hms/jsp/images/dashboard/training.jpg" alt="Training" /></div>
<div class="boardtable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col" class="noBorderRyt">Particulars</th>
		<th scope="col" class="noBorderLft">Status</th>
	</tr>
	<tr>
		<td>Waiting for approval</td>
		<td>5</td>
	</tr>
	<tr>
		<td>On leave (today)</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>Disaproved</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>


</div>
</div>

<div class="saffron">
<div class="boardTitle"><img
	src="/hms/jsp/images/dashboard/PTTS.jpg" alt="PTTS" /></div>
<div class="boardtable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col" class="noBorderRyt">Particulars</th>
		<th scope="col" class="noBorderLft">Status</th>
	</tr>
	<tr>
		<td>Waiting for approval</td>
		<td>5</td>
	</tr>
	<tr>
		<td>On leave (today)</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>Disaproved</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>


</div>
</div>


<div class="green">
<div class="boardTitle"><img
	src="/hms/jsp/images/dashboard/Etrec.jpg" alt="E-Trec" /></div>
<div class="boardtable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col" class="noBorderRyt">Particulars</th>
		<th scope="col" class="noBorderLft">Status</th>
	</tr>
	<tr>
		<td>Waiting for approval</td>
		<td>5</td>
	</tr>
	<tr>
		<td>On leave (today)</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>Disaproved</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
</table>


</div>
</div>
<div class="clear"></div>
<div class="paddingTop40"></div>




<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
