<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.BloodTestEntryHeader"%>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<BloodTestEntryHeader> testList = new ArrayList<BloodTestEntryHeader>();
		
		String message = "";
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("testList") != null){
			testList= (List<BloodTestEntryHeader>)patientMap.get("testList");
		}
		
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		
			if(!message.equalsIgnoreCase("")){
				%>
<h4><span><%=message %></span></h4>
<%} %>

<form name="bloodEntry" action="" method="post">
<div class="titleBg">
<h2>Update Blood Test Entry</h2>
</div>
<div class="Block">
<h4>Search</h4>
<div class="clear"></div>
<label>Serial No.</label> <input type="text" name="<%=ENTRY_NO %>"
	value="" MAXLENGTH="50" id="slNo" /> <label>HIN</label> <input
	type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="20" id="hinNo" />
<label>Name</label> <input type="text" name="<%=PATIENT_NAME %>"
	value="" MAXLENGTH="15" id="pFName" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="search" id="addbutton"	onclick="submitForm('bloodEntry','/hms/hms/bloodBank?method=searchPatientForUpdateTest');"	value="Search" class="button" accesskey="a" />
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="searchTest" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%=BLOOD_TEST_ID%>", "id"], [1,"entryNo"], [2,"hinNo"], [3,"donorName"]];
	 statusTd = 3;
	</script></form>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Serial No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "entryNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "HIN"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hinNo";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "donorName";

	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (testList != null && testList.size() > 0) { %>
	
	<% 	for(BloodTestEntryHeader testEntryHd : testList){
	
	%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= testEntryHd.getId()%>
			data_arr[<%= counter%>][1] = "<%=testEntryHd.getSerialNo()%>"
			<%if(testEntryHd.getHin() != null){%>
			data_arr[<%= counter%>][2] = "<%=testEntryHd.getHin().getHinNo()%>"
			<%}else{%>
				data_arr[<%= counter%>][2] = "-"
			<%}%>
			<%try{%>
				<%if(testEntryHd.getHin() != null){%>
			data_arr[<%= counter%>][3] = "<%=testEntryHd.getHin().getPFirstName()%>"
			<%}else{%>
				data_arr[<%= counter%>][3] = "<%=testEntryHd.getName()%>"
			<%}%>

			
		<%
			}catch(Exception e){
				e.printStackTrace();
			}
				     counter++;
			}
			}
		%>
		 formName = "searchTest"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>