
<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page
	import="jkt.hrms.recruitment.masters.business.ResourceRequisition"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Users"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();

				Map<String,Object> mapresourceRequisition = new HashMap<String,Object>();
				if(request.getAttribute("map") != null){
				mapresourceRequisition = (Map<String,Object>) request.getAttribute("map");
				session.setAttribute("mapresourceRequisition",map);
				}
				List<ResourceRequisition> searchresourceRequisitionList = new ArrayList<ResourceRequisition>();
				if(mapresourceRequisition.get("searchresourceRequisitionList") != null){
					searchresourceRequisitionList = (List)mapresourceRequisition.get("searchresourceRequisitionList");
					session.setAttribute("mapresourceRequisition",mapresourceRequisition);
				}
				Users users=null;
				String message=null;
				int resourceRequisitionId = 0;
				int hospitalId = 0;
				int employeeId = 0;
				
				String userFirstName="";
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
					
				}
				if(map.get("resourceRequisitionList")!= null){
					searchresourceRequisitionList = (List)map.get("resourceRequisitionList");
				}

				if(map.get("message") != null){
					   message = (String)map.get("message");
					   //out.println(message);
				}
				
				if(map.get("users")!= null){
					users = (Users)map.get("users");
					userFirstName = users.getEmployee().getFirstName();
				}
				MasRank intermediateApproverDesignation = null;
				if(map.get("intermediateApproverDesignation")!= null){
					intermediateApproverDesignation = (MasRank)map.get("intermediateApproverDesignation");
					
				}
				
				MasRank finalApproverDesignation = null;
				if(map.get("finalApproverDesignation")!= null){
					finalApproverDesignation = (MasRank)map.get("finalApproverDesignation");
					
				}
				if(session.getAttribute("users") != null){
					users = (Users)session.getAttribute("users");
					MasEmployee masEmployee = users.getEmployee();
					employeeId = masEmployee.getId();
				
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String currentDate = (String)utilMap.get("currentDate");	 
				
%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<script>
<%	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
	date1 = '<%=date+"/"+month+"/"+year%>'
	
function check(){
	var SDate = document.resourceSearch.<%= FROM_DATE%>.value;
	var EDate = document.resourceSearch.<%= TO_DATE %>.value;


	var	endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
	var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))

	if(startDate > endDate)
	{
		alert("Please ensure that the To Date is greater than or equal to the From Date.");
		// document.calldate.next_day.focus();
		return false;
	}
}
</script>

<div class="titleBg">
<h2>Search Manpower Requisitions</h2>
</div>
<div class="clear"></div>
<!--Main Div starts here-->

<form name="resourceSearch" method="post" action="">
<div class="Block">
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<label>From Date </label> <input name="<%=FROM_DATE_FOR_VALIDATION%>"
	type="text" class="date" validate="From Date,date,yes" readonly /> <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.resourceSearch.<%=FROM_DATE_FOR_VALIDATION%>,event)" />


<label class="auto">To Date </label> <input
	name="<%=TO_DATE_FOR_VALIDATION %>" type="text" class="date" readonly />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.resourceSearch.<%=TO_DATE_FOR_VALIDATION%>,event)" />


<input type="hidden" name="<%=HOSPITAL_ID %>" value="<%=hospitalId%>" />
<input type="hidden" name="<%=EMPLOYEE_ID %>" value="<%=employeeId%>" />


<input name="save" type="button" class="button" value="Search"
	onClick="checkAndSubmit()" ; /> <input type="button" name="Report"
	value="Generate Report" class="buttonBig"
	onClick="location.href='report?method=generateReportForRecruitmentRequisition'"
	accesskey="g" tabindex=1 /> <input name="back" type="button"
	class="button" value="Back" onClick="javascript:history.back()" />

<div class="clear"></div>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />


<div class="clear"></div>

<!--Main Div ends here-->

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="requestResource" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= RESOURCE_REQUEST_ID%>", "id"], [1,"initiatorName"],[2,"empType"], [3,"depName"], [4,"totPositions"], [5,"positionOccupied"],[5,"status"]];
	 statusTd = 9;
	</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Req. Id"
	data_header[0][1] = "data";
	data_header[0][2] = "";
	data_header[0][3] = "initiatorName"
	
	
	data_header[1] = new Array;
	data_header[1][0] = "Initiator Name"
	data_header[1][1] = "data";
	data_header[1][2] = "";
	data_header[1][3] = "initiatorName"
	
	data_header[2] = new Array;
	data_header[2][0] = "Employee Type"
	data_header[2][1] = "data";
	data_header[2][2] = "";
	data_header[2][3] = "empType";
	
	data_header[3] = new Array;
	data_header[3][0] = "Department Name"
	data_header[3][1] = "data";
	data_header[3][2] = "";
	data_header[3][3] = "depName";
	
	data_header[4] = new Array;
	data_header[4][0] = "Total Positions"
	data_header[4][1] = "data";
	data_header[4][2] = "";
	data_header[4][3] = "totPositions";
	
	data_header[5] = new Array;
	data_header[5][0] = "Positions Occupied"
	data_header[5][1] = "data";
	data_header[5][2] = "";
	data_header[5][3] = "positionsOccupied";
	
	data_header[6] = new Array;
	data_header[6][0] = "Status"
	data_header[6][1] = "data";
	data_header[6][2] = "";
	data_header[6][3] = "status";
	
	data_header[7] = new Array;
	data_header[7][0] = "Action Date"
	data_header[7][1] = "data";
	data_header[7][2] = "";
	data_header[7][3] = "date";
	
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (searchresourceRequisitionList != null && searchresourceRequisitionList.size() > 0) { %>
	
	<% 	for(ResourceRequisition resourceRequisition : searchresourceRequisitionList){
		String requistionStatus = "new";
  		if((resourceRequisition.getApprovingManager().getRank().getId().equals(intermediateApproverDesignation.getId())  && resourceRequisition.getHrResourceRequisitionStatus().getCurrentLevel().equals(1)) || ( resourceRequisition.getApprovingManager().getRank().getId().equals(finalApproverDesignation.getId()) &&  resourceRequisition.getHrResourceRequisitionStatus().getCurrentLevel().equals(2)))
  		{
  			requistionStatus = "Initiated By " + resourceRequisition.getInitiator().getFirstName() + " " + resourceRequisition.getInitiator().getLastName();
  		}
  		else
  		{
  			requistionStatus = resourceRequisition.getHrResourceRequisitionStatus().getRequestStatusMaster().getStatusDesc() + " by " + resourceRequisition.getHrResourceRequisitionStatus().getMasEmployee().getFirstName() + " " +resourceRequisition.getHrResourceRequisitionStatus().getMasEmployee().getLastName() ;
  		}
  		Date actionDate = null; 
  		if(resourceRequisition.getHrResourceRequisitionStatus().getActionDate() !=null)
  			actionDate = resourceRequisition.getHrResourceRequisitionStatus().getActionDate(); 
		
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= resourceRequisition.getId()%>
			data_arr[<%= counter%>][1] = <%= resourceRequisition.getId()%>
			data_arr[<%= counter%>][2] = "<%=resourceRequisition.getInitiator().getFirstName() + " " +resourceRequisition.getInitiator().getLastName()%>"
			data_arr[<%= counter%>][3] = "<%=resourceRequisition.getEmployeeType().getEmpType()%>"
			data_arr[<%= counter%>][4] = "<%=resourceRequisition.getDepartment().getDepartmentName()%>"
			data_arr[<%= counter%>][5] = "<%=resourceRequisition.getTotalNoPosition()%>"
			data_arr[<%= counter%>][6] = "<%=resourceRequisition.getNoOfPositionOccupied()%>"
			data_arr[<%= counter%>][7] = "<%=requistionStatus%>"
			data_arr[<%= counter%>][8] = "<%=actionDate%>"
		<%		
			counter++;
			}
			} %>
				
    formName = "requestResource"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	intializeHover('searchresulttable', 'TR', ' tableover');
		
	</script>

<script>

function checkAndSubmit()
{
	val = dateCompare1('resourceSearch');
	
	if(val == true){
	submitForm('resourceSearch','recruitment?method=searchResourceRequests');
	}
}
</script>
