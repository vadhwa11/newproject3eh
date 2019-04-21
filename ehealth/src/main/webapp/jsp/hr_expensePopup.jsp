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
				List<TempTrvsub> temExpensesAttachList = new ArrayList<TempTrvsub>();
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
				if(map.get("temExpensesAttachList")!= null){
					temExpensesAttachList = (List)map.get("temExpensesAttachList");
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
			int expensesAttachId = 0;
			if(temExpensesAttachList.size()>0){
				for(TempTrvsub tempTrvsub :temExpensesAttachList){
					expensesAttachId = tempTrvsub.getId();
				}
			}
		%>
				
	
<%@page import="jkt.hrms.masters.business.TempTrvsub"%>


<%@page import="jkt.hrms.masters.business.EtrTravelreq"%>
<%@page import="jkt.hrms.masters.business.TempTickattach"%>
<form name="expensesFile" method="post" action="" enctype="multipart/form-data">
<div class="titleBg"> <h2>Download File </h2></div>
<table id="searchresulttable" >
<tr>
<th>File</th>
<th>Comments</th>
</tr>
<%
	int i = 0;
	if(temExpensesAttachList.size()>0){
		for(TempTrvsub tempTrvsub :temExpensesAttachList){
%>
<tr>

<td><a href="etravel?method=viewExpenseDocuments&filename=<%=tempTrvsub.getTdsaDfilename() %>"><%=tempTrvsub.getTdsaDfilename()%></a></td>
<td><%=tempTrvsub.getTdsaCmts() %>
<input type="hidden" id="travelRequestId" name="<%=TRAVEL_REQUEST_ID %>" value="<%=travelRequestId %>" /> 
<input type="hidden"  name="<%=EMPLOYEE_ID %>" value="<%=employeeId %>" /> </td>
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

