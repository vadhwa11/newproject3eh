<%@page import="jkt.hms.masters.business.BloodIssueDetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BloodReactionEntry"%>

<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("bloodBagNo").value;
	errorMsg=errorMsg+document.getElementById("reactionNo").value;
	errorMsg=errorMsg+document.getElementById("pLName").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	errorMsg=errorMsg+document.getElementById("donorName").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>
<script type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
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
</script>
<%
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> patientMap = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
//List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
List<BloodIssueDetail> bloodIssueDetailList = new ArrayList<BloodIssueDetail>(); 

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("patientMap") != null){
	patientMap= (Map<String, Object>)map.get("patientMap");
}
if(patientMap.get("bloodIssueDetailList") != null){
	bloodIssueDetailList= (List<BloodIssueDetail>)patientMap.get("bloodIssueDetailList");
}
String message = "";
String deptType = "";
if(map.get("message") != null){
	message= (String)map.get("message");
}
if (map.get("deptType") != null) {
	deptType = (String) map.get("deptType");
}
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
	if(!message.equalsIgnoreCase("")){
%>
<h4><span><%=message %></span></h4>

<%} %>
<form name="bloodEntry" method="post">
<div class="titleBg">
<h2>Investigation Pending Transfusion Reaction</h2>
</div>
<div class="Block">
<h4>Patient Search</h4>
<label>Blood Bag No.</label> <input type="text"
	name="<%=BLOOD_BAG_NO %>" value="" MAXLENGTH="50" id="bloodBagNo" /> <label>Reaction
No.</label> <input type="text" name="<%=ENTRY_NO %>" value="" MAXLENGTH="20"
	id="reactionNo" /> <label>Donor Name</label> <input type="text"
	name="<%=DONOR_NAME %>" value="" MAXLENGTH="15" id="donorName" />

<div class="clear"></div>

<label>Patient First Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" id="pFName" /> <label>Patient
Last Name</label> <input type="text" name="<%=P_LAST_NAME %>" value=""
	MAXLENGTH="15" id="pLName" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="search" id="addbutton"	onclick="if(checkBlankSearch())submitForm('bloodEntry','/hms/hms/bloodBank?method=searchPatientForTransfussionReaction');"	value="Search" class="button" accesskey="a" />
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="searchPndTransReaction" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script
	type="text/javascript">
	formFields = [
			[0, "<%=BLOOD_ISSUE_DETAIL_ID%>", "id"], [1,"bloodBagNo"], [2,"reactionNo"], [3,"reactionDate"],[4,"patName"]];
	 statusTd =4;
	</script></form>
</div>

<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	data_header[0] = new Array;
	data_header[0][0] = "Blood Bag No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "bloodBagNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Reaction No"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "reactionNo";
	
	data_header[2] = new Array;
	data_header[2][0] = "Blood Issued Date"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "issuedDate";
	
	data_header[3] = new Array;
	data_header[3][0] = "Patient Name"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "patName";
	
	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (bloodIssueDetailList != null && bloodIssueDetailList.size() > 0) { %>
	
	<% 	for(BloodIssueDetail reactionEntry : bloodIssueDetailList){
		if(reactionEntry.getStockDetail().getBloodBagNo() != null){
	%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= reactionEntry.getId()%>
			data_arr[<%= counter%>][1] = "<%=reactionEntry.getStockDetail().getBloodBagNo()%>"
			data_arr[<%= counter%>][2] = ""
			data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(reactionEntry.getIssueHeader().getIssueDate())%>"
			<%if(reactionEntry.getIssueHeader().getBloodRequestHd().getHin() != null){%>
			data_arr[<%= counter%>][4] = "<%=reactionEntry.getIssueHeader().getBloodRequestHd().getHin().getFullName()%>"
			<%}else{%>
				data_arr[<%= counter%>][4] = "<%=reactionEntry.getIssueHeader().getBloodRequestHd().getHin().getFullName()%>"
			<%}%>
		<%
				     counter++;
			}
			}
		}
		%>
		 formName = "searchPndTransReaction"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>