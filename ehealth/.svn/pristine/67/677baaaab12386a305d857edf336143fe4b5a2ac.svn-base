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
				if(map.get("etrTravelRequestList")!= null){
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
			String refNo = "";
			Date fromDate = new Date();
			Date toDate = new Date();
			int travelTypeId  = 0;
			String tripName = "";
			String empName = "";
			String rankName = "";
			if(etrTravelRequestList.size()>0){
				for(EtrTravelreq etrTravelreq :etrTravelRequestList){
					travelRequestId = etrTravelreq.getId();
					if(etrTravelreq.getEmp().getId()!= null){
						employeeId = etrTravelreq.getEmp().getId();
						 refNo =etrTravelreq.getRefNo();
						 fromDate =etrTravelreq.getJfdate();
						 toDate = etrTravelreq.getJtdate();
						 if(etrTravelreq.getTrip().getId()!= null){
								travelTypeId = etrTravelreq.getTrip().getId();
						 		tripName = etrTravelreq.getTrip().getCodeDesc();
						 }
						 empName = etrTravelreq.getEmp().getFirstName()+" "+etrTravelreq.getEmp().getLastName();
						
					}
				}
			}
			int ticketAttachId = 0;
			if(tempTicketAttachList.size()>0){
				for(TempTickattach tempTickattach:tempTicketAttachList){
					ticketAttachId = tempTickattach.getId();
				}
			}
		%>
				
	
<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hrms.masters.business.TempTickattach"%>
<form name="viewBookingDetail1" method="post" action="" enctype="multipart/form-data">
<div class="titleBg"> <h2>Download File </h2></div>
<div class="clear"></div>
<div class="Block">
<label>Ref.No</label>
<input name="<%=REFERENCE_NO %>"  value="<%=refNo %>"  validate="No. Of Days,string,yes"   maxlength="8" />

<label>Employee</label>
<input name = "<%=EMPLOYEE_ID %>" value="<%=empName %> "   validate="Start Time,string,yes"   maxlength="8" />
<input type="hidden"  name="<%=EMPLOYEE_HIDDEN_ID %>" value="<%=employeeId%>">


<div class="clear"></div>
<label>Trip </label>
<input name="<%=TRIP_ID %>"  value="<%=tripName %>"    maxlength="8" />

<label>From Date </label>
<input type="text"  name="<%=FROM_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(fromDate)%>"   readonly="readonly" validate="From date ,date,yes"  MAXLENGTH="30" />
<div class="clear"></div>
<label>To Date </label>
<input type="text"  name="<%=TO_DATE %>" value="<%=HMSUtil.convertDateToStringWithoutTime(toDate)%>"   readonly="readonly" onblur="calculateNoOfDays();" validate="To date ,date,yes"  MAXLENGTH="30" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<table id="searchresulttable" class="small">
<tr>
<th>File</th>
<th>Comments</th>
</tr>
<%
	int i = 0;
	if(tempTicketAttachList.size()>0){
		for(TempTickattach tempTickattach :tempTicketAttachList){
%>
<tr>
<td><a href="etravel?method=viewBookingDetailDocuments&filename=<%=tempTickattach.getTdsaDfilename()%>&csrfTokenName=csrfTokenValue"><%=tempTickattach.getTdsaDfilename()%></a>
</td>
<td><%=tempTickattach.getTdsaCmts() %>
<input type="hidden" id="travelRequestId" name="<%=TRAVEL_REQUEST_ID%>" value="<%=travelRequestId %>" /> 
<input type="hidden"  name="<%=EMPLOYEE_ID%>" value="<%=employeeId %>" /> </td>
</tr>
<%i++;
	}}
%>
</table>
<input type="hidden" id="countId" name="counter" value="<%=i%>">

<input name="add" type="button" class="button" value="Close" onClick="window.close();"/>
 <!--   <input type="button" name="add" id="addbutton" value="Back" class="button" onClick="backProjectSetting();" accesskey="a" tabindex=1 />-->
<div class="clear"></div>


<script type="text/javascript">
function backProjectSetting()
	{
		 obj = eval('document.viewBookingDetail1')
		 
  		 obj.action = "/hms/hrms/etravel?method=showTravelRequestJsp&"+csrfTokenName+"="+csrfTokenValue;
  		 obj.submit();
  		 return true;
	
	}
	</script>

<div class="clear"></div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

