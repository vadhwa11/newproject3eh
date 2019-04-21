<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.BloodDonationEntryHeader"%>

<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("donationNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	errorMsg=errorMsg+document.getElementById("hinNo").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>

<form name="bloodEntry" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<BloodDonationEntryHeader> donorList = new ArrayList<BloodDonationEntryHeader>();
		int bloodDonationId=0;
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("donorList") != null){
			donorList= (List<BloodDonationEntryHeader>)patientMap.get("donorList");
		}
		if(map.get("bloodDonationId") != null){
			bloodDonationId=(Integer)map.get("bloodDonationId");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	</script>
<div class="titleBg">
<h2>Donor Search</h2>
</div>
<div class="clear"></div>
<div class="Block"><label>Donation No.</label> <input type="text"
	name="<%=DONATION_NO %>" value="" MAXLENGTH="50" id="donationNo" /> <label>Donor
Name</label> <input type="text" name="<%=DONOR_NAME %>" value="" MAXLENGTH="15"
	id="pFName" />
<div class="clear"></div>
<label>HIN</label> <input type="text" name="<%=HIN_NO %>" value=""
	MAXLENGTH="15" id="hinNo" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="search" id="addbutton" onclick="submitForm('bloodEntry','/hms/hms/bloodBank?method=searchPatientForUpdateDonation');" value="Search" class="button" accesskey="a" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="searchBloodDonor" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script
	type="text/javascript">
	formFields = [
			[0, "bloodDonationId", "id"], [1,"donationNo"], [2,"donorName"],[3,"hinNo"]];
	 statusTd = 3;
	</script>
	
	</form>
</div>

<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Donation No"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "donationNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "Donor Name"
	data_header[1][1] = "data";
	data_header[1][2] = "25%";
	data_header[1][3] = "donorName";
	
	data_header[2] = new Array;
	data_header[2][0] = "HIN"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "hinNo";

	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (donorList != null && donorList.size() > 0) { %>
	
	<% 	for(BloodDonationEntryHeader bloodDonationEntryHeader : donorList){
		
	%>
            data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= bloodDonationEntryHeader.getId()%>
			data_arr[<%= counter%>][1] = "<%=bloodDonationEntryHeader.getDonationNo()%>"
			<%try{%>
			data_arr[<%= counter%>][2] = "<%=bloodDonationEntryHeader.getDonerName()%> "
			<%if(bloodDonationEntryHeader.getHin()!=null){%>
			data_arr[<%= counter%>][3] = "<%=bloodDonationEntryHeader.getHin().getHinNo()%> "
			<%}else{%>
				data_arr[<%= counter%>][3] = "- "
			<%}%>
			
		<%
			}catch(Exception e){
				e.printStackTrace();
			}
				     counter++;
			}
		}
		%>
		 formName = "searchBloodDonor"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>