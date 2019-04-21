<%@page import="jkt.hms.masters.business.BloodIssueDetail"%>
<%@page import="jkt.hms.masters.business.BldCrossmatchDetail"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryDetail"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryHeader" %>

<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	
	errorMsg=errorMsg+document.getElementById("adNo").value;
	if(document.getElementById("departmentId").value !=0)
	 errorMsg=errorMsg+document.getElementById("departmentId").value;
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
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		
		List<BloodIssueDetail> bldIssudeDetailList = new ArrayList<BloodIssueDetail>();
		List<BloodRequestEntryHeader> bldReqHeaderList = new ArrayList<BloodRequestEntryHeader>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		
		
		
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(patientMap.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)patientMap.get("inpatientList");
		}
		
		if(map.get("bldIssudeDetailList") != null){
			bldIssudeDetailList= (List<BloodIssueDetail>)map.get("bldIssudeDetailList");
		}
		if(patientMap.get("bldReqHeaderList") != null){
			bldReqHeaderList= (List<BloodRequestEntryHeader>)patientMap.get("bldReqHeaderList");
			
		}
		
		if(map.get("bldReqHeaderList") != null){
			bldReqHeaderList= (List<BloodRequestEntryHeader>)map.get("bldReqHeaderList");
			//System.out.println("bldReqHeaderList @@@ "+bldReqHeaderList.size());
		}
		
		if(map.get("wardList") != null){
			wardList=(List<MasDepartment>)map.get("wardList");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}

	
	if(!message.equalsIgnoreCase("")){
	%>
<h4><span><%=message %></span></h4>
<%} %>
<form name="bloodEntry" action="" method="post">
<div class="titleBg">
<h2>Blood Reaction Form Entry</h2>
</div>

<div class="Block">
<h4>Patient Search</h4>
<label>UHID</label> 
<input type="text"
	name="<%=HIN_NO %>" value="" class="textbox_size20" MAXLENGTH="50"
	id="hinNo" /> 
	
	<label>IP No.</label> <input type="text"
	name="<%=AD_NO %>" value="" class="textbox_size20" MAXLENGTH="20"
	id="adNo" /> 
	
	<label>Ward</label> 
	
	<select id="departmentId"
	name="<%=DEPARTMENT_ID %>" id="departmentId">
	<option value="0">Select Department</option>
	<% 
			for(MasDepartment masDepartment : wardList){
			%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%	}	%>
</select>
<div class="clear"></div>
<label>Patient Name</label>
 <input type="text"
	name="<%=P_FIRST_NAME %>" value="" class="textbox_size20"
	MAXLENGTH="15" id="pFName" /> 
	
	
	
<div class="clear"></div>
</div>
<div class="clear"></div>
<input type="button" name="search" id="addbutton"
	onclick="if(checkBlankSearch()){submitForm('bloodEntry','/hms/hms/bloodBank?method=searchPatientForBloodReaction');}"
	value="Search" class="button" accesskey="a" />
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="searchReactionEntry" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<script
	type="text/javascript">
	formFields = [
			[0, "inpatientId", "id"],  [1,"hinNo"], [2,"adNo"], [3,"patName"], [4,"age"], [5,"doctorName"], [6,"ward"]];
	 statusTd = 3;
	</script></form>

</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "UHID"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "hinNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "IP No."
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "adNo";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "hin";
	
	data_header[3] = new Array;
	data_header[3][0] = "Age"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "age";
	
	data_header[4] = new Array;
	data_header[4][0] = "Doctor Name"
	data_header[4][1] = "data";
	data_header[4][2] = "20%";
	data_header[4][3] = "doctorName";
	
	data_header[5] = new Array;
	data_header[5][0] = "Ward"
	data_header[5][1] = "data";
	data_header[5][2] = "20%";
	data_header[5][3] = "ward";

	data_arr = new Array();	
	<%
		
	    int  counter=0;
	String name="";
	if (bldIssudeDetailList != null && bldIssudeDetailList.size() > 0) { %>
	<% 	for(BloodIssueDetail bldIssueDetail : bldIssudeDetailList){
		
		if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getPFirstName()!=null)
		{
			name = bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getPFirstName();
			
		}

		
		 if(null !=bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient() ){
		 
		 if(bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getAdStatus().equalsIgnoreCase("A") || bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getAdStatus().equalsIgnoreCase("R"))
   	  {
	%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= bldIssueDetail.getId()%>
			data_arr[<%= counter%>][1] = "<%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getHin().getHinNo()%>"
			<%try{%>
			data_arr[<%= counter%>][2] = "<%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getAdNo()%>"
			data_arr[<%= counter%>][3] = "<%=name%>"
			
			data_arr[<%= counter%>][4] = "<%=(bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getAge()!=null )? bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getAge():""%>"
			data_arr[<%= counter%>][5] = "<%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDoctor().getFirstName()%>"
			data_arr[<%= counter%>][6] = "<%=bldIssueDetail.getIssueHeader().getBloodRequestHd().getInpatient().getDepartment().getDepartmentName()%>"
		<%
			}catch(Exception e){
				e.printStackTrace();
			}
   	  }}
				     counter++;
			}
			}
		%>
		 formName = "searchReactionEntry"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
</script>