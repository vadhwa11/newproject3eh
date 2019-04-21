<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>

<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	errorMsg=errorMsg+document.getElementById("pLName").value;
	errorMsg=errorMsg+document.getElementById("adNo").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)patientMap.get("inpatientList");
		}
		%>

<div class="clear"></div>
<form name="patientSearch" action="" method="post">
<div class="titleBg">
<h2>Consent for Blood Transfusion Entry</h2>
</div>
<div class="Block" id="testDiv">
<h4>Patient Search</h4>
<label>IP No.</label> <input type="text" name="<%=AD_NO %>" value=""
	class="textbox_size20" MAXLENGTH="20" id="adNo" /> <label>HIN</label>
<input type="text" name="<%=HIN_NO %>" value="" class="textbox_size20"
	MAXLENGTH="50" id="hinNo" /> <label>First Name</label> <input
	type="text" name="<%=P_FIRST_NAME %>" value="" class="textbox_size20"
	MAXLENGTH="15" id="pFName" />
<div class="clear"></div>
<label>Last Name</label> <input type="text" name="<%=P_LAST_NAME %>"
	value="" class="textbox_size20" MAXLENGTH="15" id="pLName" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="search" id="addbutton" class="button"
	onclick="if(checkBlankSearch()){submitForm('patientSearch','/hms/hms/bloodBank?method=searchPatientForBloodTransfusion');}"
	value="Search" accesskey="a" />
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="paddingTop5"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="searchBloodTransfusion" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script
	type="text/javascript">
			formFields = [
					[0, "<%= INPATIENT_ID%>", "id"], [1,"hin"], [2,"patName"], [3,"adNo"]];
			 statusTd = 3;
</script>
</form>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "HIN"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "hin"
	
	data_header[1] = new Array;
	data_header[1][0] = "Patient Name"
	data_header[1][1] = "data";
	data_header[1][2] = "20%";
	data_header[1][3] = "patName";
	
	data_header[2] = new Array;
	data_header[2][0] = "IP No."
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "adNo";

	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (inpatientList != null && inpatientList.size() > 0) { %>
	
	<% 	for(Inpatient inpatient : inpatientList){
		 if(inpatient.getAdStatus().equalsIgnoreCase("A") || inpatient.getAdStatus().equalsIgnoreCase("R"))
   	  {
		
	%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= inpatient.getId()%>
			data_arr[<%= counter%>][1] = "<%=inpatient.getHin().getHinNo()%>"
			<%try{%>
			data_arr[<%= counter%>][2] = "<%=inpatient.getHin().getPFirstName()%> <%=inpatient.getHin().getPLastName()%> "
			data_arr[<%= counter%>][3] = "<%=inpatient.getAdNo()%>"
			
		<%
			}catch(Exception e){
				e.printStackTrace();
			}}
				     counter++;
	}
		}
		%>
		 formName = "searchBloodTransfusion"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>