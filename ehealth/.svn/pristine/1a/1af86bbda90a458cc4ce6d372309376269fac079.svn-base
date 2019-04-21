<%@page import="jkt.hms.masters.business.OpdSurgeryHeader"%>
<%@page import="jkt.hms.masters.business.ProcedureHeader"%>
<%@page import="jkt.hms.masters.business.BlOpBillHeader"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="java.util.HashMap"%>

<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<form name="billServicingOpSearch" method="post" onload="form.reset();">

<%
Map<String,Object> map = new HashMap<String,Object>();
List<DgOrderhd> dgOrderhdList=new ArrayList<DgOrderhd>();



if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}
String message = "";
if(map.get("message") != null){
	message = (String)map.get("message");
	
	}
List<OpdPatientDetails> patientDetailList = new ArrayList<OpdPatientDetails>();
if(map.get("patientDetailList") != null){
	patientDetailList= (List<OpdPatientDetails>)map.get("patientDetailList");
}
if(map.get("dgOrderhdList") != null){
	dgOrderhdList= (List<DgOrderhd>)map.get("dgOrderhdList");
}
List<ProcedureHeader> procedureList = new ArrayList<ProcedureHeader>();
if(map.get("procedureList") != null){
	procedureList= (List<ProcedureHeader>)map.get("procedureList");
}
List<OpdSurgeryHeader> surgeryList = new ArrayList<OpdSurgeryHeader>();
if(map.get("surgeryList") != null){
	surgeryList= (List<OpdSurgeryHeader>)map.get("surgeryList");
}

%> <%
	if(map.get("inpatientList") != null){
%> <script type="text/javascript">
	displayAlert("Patient is admitted.");
</script> <%		
	}
%>
<h4><%=message %></h4>
<div class="titleBg">
<h2>Bill Servicing</h2>
</div>

<div class="Block">

<label>UHID</label> <input type="text"
	id="searchField" name="<%=HIN_NO %>" value="" validate="UHID,alphanumeric,no"
	onblur=""
	maxlength="30" tabindex=1 />
<label>Patient Name</label> <input type="text"
	id="pName" name="pName" value="" validate="Patient Name,alphanumeric,no"
	onblur=""
	maxlength="30" tabindex=1 />
	
	<label>Mobile Number</label> <input type="text"
	id="mobile" name="mobile" value="" validate="Mobile Number,number,no"
	onblur=""
	maxlength="30" tabindex=1 />
	
<div class="clear"></div>
<label>Lab/Radio/ECG</label>
<input type="radio" class="inputRadiobutton"  name="billService" value="lab" id="labId" checked="checked"/>
<label>Nursing Procedure </label>
<input type="radio" class="inputRadiobutton"  name="billService" value="nursing" id="nursingId"/>

<label>Surgical Procedure</label>
<input type="radio" class="inputRadiobutton"  name="billService" value="surgical" id="procId" />

<div class="clear"></div>
<input type="button" class="button" name="save" value="Search" onclick="submitForm('billServicingOpSearch','opBilling?method=showBillServicingJsp&registered=yes');" align="right" />
<input type="reset" class="button"  value="Reset"/>
<div class="clear"></div>
</div>

<div class="clear"></div>

<%
	String msg = "";
	if(map.get("msg") != null){
		msg = (String)map.get("msg");
	}
%>

<h4><%=msg %></h4>
<script type="text/javascript">
	function checkHinValue(){
		if(document.getElementById('searchField').value == "" && document.getElementById('pName').value == ""  && document.getElementById('mobile').value == ""){
				alert("Please enter either UHID or Patient Name or Mobile Number");
			return false;
		}else{
			return true
		}
	
	}

document.getElementById('searchField').focus();

</script>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="opdPatientBillStatus" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
	<script type="text/javascript">
	formFields = [
			[0, "hinId", "id"],[1,"TokenNo"],[2,"hinNo"], [3,"patientName"], [4,"referBy"], [5,"hospitalName"],[6,"dgOrderHdId"],[7,"billType"]];
	 statusTd = 7;
	</script>
	</div>
	
	</form>
	<script type="text/javascript" language="javascript">
	data_header = new Array();
	data_header[0] = new Array;
	data_header[0][0] = "Token No.<b>&nbsp;/&nbsp;</b>Queue No."
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "TokenNo";
	
	data_header[1] = new Array;
	data_header[1][0] = "UHID"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hinNo";
	
	
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "patientName";
	
	data_header[3] = new Array;
	data_header[3][0] = "Referred By"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "referBy";
		
	data_header[4] = new Array;
	data_header[4][0] = "Hospital Name"
	data_header[4][1] = "data";
	data_header[4][2] = "30%";
	data_header[4][3] = "hospitalName";

	data_header[5] = new Array;
	data_header[5][0] = "Order Id"
	data_header[5][1] = "data";
	data_header[5][2] = "30%";
	data_header[5][3] = "dgOrderHdId";

	data_header[6] = new Array;
	data_header[6][0] = "Bill Type"
	data_header[6][1] = "hide";
	data_header[6][2] = "30%";
	data_header[6][3] = "billType";
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (dgOrderhdList != null && dgOrderhdList.size() > 0) { 
	 	for(DgOrderhd dgOrderhd : dgOrderhdList){
	 		//if(patientDetails.getReferredDoctor() !=null){
	 			String referBy="";
	 			String mRefBy="";	
	 			String lRefBy="";
	 			
				String patientName="";
				String mPatName="";	
				String lPatName="";
				
				String refTo=""; String 
				lrefTo="";
				patientName=dgOrderhd.getVisit().getHin().getPFirstName();
				if(dgOrderhd.getVisit().getHin().getPMiddleName() !=null){
					mPatName=dgOrderhd.getVisit().getHin().getPMiddleName();}
				if(dgOrderhd.getVisit().getHin().getPLastName() !=null){
					lPatName=dgOrderhd.getVisit().getHin().getPLastName();}
				patientName=patientName+" "+mPatName+" "+lPatName;
				/* 
				if(dgOrderhd.getVisit().getDoctor()!=null)
				{
				referBy=dgOrderhd.getVisit().getDoctor().getFirstName();
				if(dgOrderhd.getVisit().getDoctor().getMiddleName() !=null){
					mRefBy=dgOrderhd.getVisit().getDoctor().getMiddleName();}
				if(dgOrderhd.getVisit().getDoctor().getLastName() !=null){
				lRefBy=dgOrderhd.getVisit().getDoctor().getLastName();}
				referBy=referBy+" "+mRefBy+" "+lRefBy;
				}
				 */
				 if(dgOrderhd.getPrescribedBy()!=null)
					{
					referBy=dgOrderhd.getPrescribedBy().getFirstName();
					if(dgOrderhd.getPrescribedBy().getMiddleName() !=null){
						mRefBy=dgOrderhd.getPrescribedBy().getMiddleName();}
					if(dgOrderhd.getPrescribedBy().getLastName() !=null){
					lRefBy=dgOrderhd.getPrescribedBy().getLastName();}
					referBy=referBy+" "+mRefBy+" "+lRefBy;
					}
			%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] =<%= dgOrderhd.getVisit().getHin().getId()%> 
			<%
			if(dgOrderhd.getVisit().getTokenNo()!=null)
			{
			%>
			data_arr[<%= counter%>][1] = "<%=dgOrderhd.getVisit().getTotalHospitalVisit()+"/"+dgOrderhd.getVisit().getTokenNo()%> " 
			<%
			}else{
			%>
			data_arr[<%= counter%>][1] = ""
			
			<%}%>
			data_arr[<%= counter%>][2] = "<%=dgOrderhd.getVisit().getHin().getHinNo()%>"
			data_arr[<%= counter%>][3] = "<%=patientName%> "
			data_arr[<%= counter%>][4] = "<%=referBy%>"
			data_arr[<%= counter%>][5] = "<%=dgOrderhd.getVisit().getHospital()!=null?dgOrderhd.getVisit().getHospital().getHospitalName():""%>"
			data_arr[<%= counter%>][6] = "<%=dgOrderhd.getId()%>"
			data_arr[<%= counter%>][7] = "lab";
			<%
			counter++;
			//}
	 	}
		}else if(procedureList.size() > 0){ 
		 	for(ProcedureHeader proHd : procedureList){
		 			String referBy="";
		 			String mRefBy="";	
		 			String lRefBy="";
		 			
					String patientName="";
					String mPatName="";	
					String lPatName="";
					
					String refTo=""; String 
					lrefTo="";
					patientName=proHd.getVisit().getHin().getPFirstName();
					if(proHd.getVisit().getHin().getPMiddleName() !=null){
						mPatName=proHd.getVisit().getHin().getPMiddleName();}
					if(proHd.getVisit().getHin().getPLastName() !=null){
						lPatName=proHd.getVisit().getHin().getPLastName();}
					patientName=patientName+" "+mPatName+" "+lPatName;
					
							 
					if(proHd.getOpdPatientDetails()!=null && proHd.getOpdPatientDetails().getEmployee()!=null)
					{
						referBy=proHd.getOpdPatientDetails().getEmployee().getFirstName();
					if(proHd.getOpdPatientDetails().getEmployee().getMiddleName() !=null){
						mRefBy=proHd.getOpdPatientDetails().getEmployee().getMiddleName();}
					if(proHd.getOpdPatientDetails().getEmployee().getLastName() !=null){
						lRefBy=proHd.getOpdPatientDetails().getEmployee().getLastName();}
						referBy=referBy+" "+mRefBy+" "+lRefBy;
					}
						
			
				%>
				data_arr[<%= counter%>] = new Array();
				data_arr[<%= counter%>][0] =<%= proHd.getVisit().getHin().getId()%> 
				<%
				if(proHd.getVisit().getTokenNo()!=null)
				{
				%>
				data_arr[<%= counter%>][1] = "<%=proHd.getVisit().getTotalHospitalVisit()+"/"+proHd.getVisit().getTokenNo()%> " 
				<%
				}else{
				%>
				data_arr[<%= counter%>][1] = ""
				
				<%}%>
				data_arr[<%= counter%>][2] = "<%=proHd.getVisit().getHin().getHinNo()%>";
				data_arr[<%= counter%>][3] = "<%=patientName%> ";
				data_arr[<%= counter%>][4] = "<%=referBy%>";
				data_arr[<%= counter%>][5] = "<%=proHd.getVisit().getHospital()!=null?proHd.getVisit().getHospital().getHospitalName():""%>"
				data_arr[<%= counter%>][6] = "<%=proHd.getId()%>";
				data_arr[<%= counter%>][7] = "nursing";
				<%
				counter++;
				}
		 	}else if(surgeryList.size() > 0){ 
		 		for(OpdSurgeryHeader surgeryHd : surgeryList){
		 			String referBy="";
		 			String mRefBy="";	
		 			String lRefBy="";
		 			
					String patientName="";
					String mPatName="";	
					String lPatName="";
					
					String refTo=""; String 
					lrefTo="";
					patientName=surgeryHd.getVisit().getHin().getPFirstName();
					if(surgeryHd.getVisit().getHin().getPMiddleName() !=null){
						mPatName=surgeryHd.getVisit().getHin().getPMiddleName();}
					if(surgeryHd.getVisit().getHin().getPLastName() !=null){
						lPatName=surgeryHd.getVisit().getHin().getPLastName();}
					patientName=patientName+" "+mPatName+" "+lPatName;
					
					if(surgeryHd.getEmployee()!=null)
					{
						referBy=surgeryHd.getEmployee().getFirstName();
					if(surgeryHd.getEmployee().getMiddleName() !=null){
						mRefBy=surgeryHd.getEmployee().getMiddleName();}
					if(surgeryHd.getEmployee().getLastName() !=null){
						lRefBy=surgeryHd.getEmployee().getLastName();}
						referBy=referBy+" "+mRefBy+" "+lRefBy;
					}
					
			
				%>
				data_arr[<%= counter%>] = new Array();
				data_arr[<%= counter%>][0] =<%= surgeryHd.getVisit().getHin().getId()%> 
				<%
				if(surgeryHd.getVisit().getTokenNo()!=null)
				{
				%>
				data_arr[<%= counter%>][1] = "<%=surgeryHd.getVisit().getTotalHospitalVisit()+"/"+surgeryHd.getVisit().getTokenNo()%> " 
				<%
				}else{
				%>
				data_arr[<%= counter%>][1] = ""
				
				<%}%>
				data_arr[<%= counter%>][2] = "<%=surgeryHd.getVisit().getHin().getHinNo()%>";
				data_arr[<%= counter%>][3] = "<%=patientName%> ";
				data_arr[<%= counter%>][4] = "<%=referBy%>";
				data_arr[<%= counter%>][5] = "<%=surgeryHd.getVisit().getHospital()!=null?surgeryHd.getVisit().getHospital().getHospitalName():""%>"
				data_arr[<%= counter%>][6] = "<%=surgeryHd.getId()%>";
				data_arr[<%= counter%>][7] = "surgical";
				<%
				counter++;
				}
		 	}
			
		%>
		formName = "opdPatientBillStatus";

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
		makeTable(start,end);
		//makeTable(start,end);
intializeHover('searchresulttable', 'TR', ' tableover');  
</script>