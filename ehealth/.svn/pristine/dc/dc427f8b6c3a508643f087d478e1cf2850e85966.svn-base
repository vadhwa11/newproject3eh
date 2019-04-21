<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>


<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<MasDistrict> districtList=new ArrayList<MasDistrict>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("patientList") != null){
			patientList= (List<Patient>)patientMap.get("patientList");
		}
		if(patientMap.get("districtList") != null){
			districtList= (List<MasDistrict>)patientMap.get("districtList");
			
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
		List<String> visitIdList=new ArrayList<String>();
		if(patientMap.get("visitIdList")!=null){
			visitIdList=(List<String>)patientMap.get("visitIdList");
		}
	%>

<script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);
			
		<%}
	%>
	</script>
<form name="bloodEntry" action="" method="post">
<div class="titleBg">
<h2>Blood Request Entry</h2>
</div>
<div class="Block">
<h4>Patient Search</h4>
<label>UHID</label> <input type="text"
	name="<%=HIN_NO %>" value="" MAXLENGTH="16" id="hinNo" /> <label>Patient
Type</label> <select id="pType" name="<%=PATIENT_TYPE%>">
	<option value="">Select</option>
	<option value="In Patient">In Patient</option>
	<option value="Out Patient">Out Patient</option>
</select>
<label>Patient Name</label> <input type="text"
	name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="30" id="pFName" />
<div class="clear"></div>
 <label>District</label>
 
 <select id="districtId" name="district">
	<option value="">Select</option>
	<%
	if(null !=districtList && districtList.size()>0){
		for(MasDistrict district:districtList){%>
			<option value="<%= district.getId()%>"><%= district.getDistrictName()%></option>
		<%}
	}
	%>
	
</select>
<div class="clear"></div>

<%-- <label>Patient Last Name</label> <input type="text"
	name="<%=P_LAST_NAME%>" value="" MAXLENGTH="30" id="pLName" /> --%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="search" id="addbutton" value="Search"	
class="button"	onclick="if(checkBlankSearch()){submitForm('bloodEntry','/hms/hms/bloodBank?method=searchPatientForBloodRequest');}" accesskey="a" />
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
	
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="bloodRequestEntry" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script
	type="text/javascript">
	formFields = [
			[0, "hinId", "id"], [1,"hin"], [2,"patName"], [3,"pType"],[4,"visitId"]];
	 statusTd = 3;
	</script></form>
</div>

<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "UHID"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "hin"
	
	data_header[1] = new Array;
	data_header[1][0] = "Patient Name"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "patName";
	
	data_header[2] = new Array;
	data_header[2][0] = "P Type"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "pType";
	
	data_header[3] = new Array;
	data_header[3][0] = "Visit Id"
	data_header[3][1] = "hide";
	data_header[3][2] = "20%";
	data_header[3][3] = "visitId";
	

	data_arr = new Array();	
	<%
		
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>
	
	<% 	for(Patient patient : patientList){
	
	%>
data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= patient.getId()%>
			data_arr[<%= counter%>][1] = "<%=patient.getHinNo()%>"
			<%try{%>
			data_arr[<%= counter%>][2] = "<%=patient.getPFirstName()%> "
			data_arr[<%= counter%>][3] = "<%=patient.getPatientStatus()%>"
			data_arr[<%= counter%>][4] = "<%=visitIdList.size()>0?visitIdList.get(counter):0%>"
			
		<%
			}catch(Exception e){
				e.printStackTrace();
			}
				     counter++;
			}
			}
		%>
		 formName = "bloodRequestEntry"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	
	 if(document.getElementById("pType").value != null)
	 errorMsg=errorMsg+document.getElementById("pType").value;
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script>