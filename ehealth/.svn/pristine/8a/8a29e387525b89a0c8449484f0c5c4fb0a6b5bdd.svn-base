<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.BloodReactionEntry"%>

<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<BloodReactionEntry> reactionList = new ArrayList<BloodReactionEntry>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("reactionList") != null){
			reactionList= (List<BloodReactionEntry>)patientMap.get("reactionList");
		}
		String message = "";
		String deptType = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
			if(!message.equalsIgnoreCase("")){
				%>
<h4><span><%=message %></span></h4>
<%} %>

<form name="bloodEntry" action="" method="post">
<div class="titleBg">
<h2>Update Blood Reaction Form Entry</h2>
</div>
<div class="Block"><label>Enrty No.</label> <input type="text"
	name="<%=ENTRY_NO %>" value="" MAXLENGTH="50" id="entryNo" /> <label>HIN</label>
<input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="20"
	id="hinNo" />

<div class="clear"></div>

<label> Name</label> <input type="text" name="<%=PATIENT_NAME %>"
	value="" MAXLENGTH="15" id="pFName" />

<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="search" id="addbutton" value="Search" class="button"	onclick="submitForm('bloodEntry','/hms/hms/bloodBank?method=searchPatientForUpdateReaction');" accesskey="a" />
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="searchReaction" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script
	type="text/javascript">
	formFields = [
			[0, "<%=BLOOD_REACTION_ID%>", "id"], [1,"entryNo"], [2,"donorName"]];
	 statusTd = 2;
	</script></form>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Entry No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "entryNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Name"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "donorName";
	

	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (reactionList != null && reactionList.size() > 0) { %>
	
	<% 	for(BloodReactionEntry reactionEntry : reactionList){
	
	%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= reactionEntry.getId()%>
			data_arr[<%= counter%>][1] = "<%=reactionEntry.getEntryNo()%>"
			<%try{%>
				<%if(reactionEntry.getHin() != null){%>
			data_arr[<%= counter%>][2] = "<%=reactionEntry.getHin().getPFirstName()%>"
			<%}else{%>
				data_arr[<%= counter%>][2] = "<%=reactionEntry.getDonorName()%>"
			<%}%>

			
		<%
			}catch(Exception e){
				e.printStackTrace();
			}
				     counter++;
			}
			}
		%>
		 formName = "searchReaction"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>