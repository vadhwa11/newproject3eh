<!-- ----By Dipali -11/nov/2010-->
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.PatientPrescriptionHeader"%>
<%@page import="jkt.hms.masters.business.Patient"%>

<%@page import="jkt.hms.util.HMSUtil"%>


<form name="strPatientIssueEntry" action="" method="post">
<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<PatientPrescriptionHeader> patientList = new ArrayList<PatientPrescriptionHeader>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}

		if(patientMap.get("patientList") != null){
			patientList= (List<PatientPrescriptionHeader>)patientMap.get("patientList");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
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
	function checkNameLength(value,fieldName){

		if(value!=""){
			var len=value.length;
			if(parseInt(len)<3){
				alert("Please Enter min three charecter "+fieldName);
				return false;
			}
		}else{
			return false;
			}
	}


	function checkNameLengthOnSubmit(){
		var pFirstName="";
		var pMiddleName="";
		var pLastName="";

		pFirstName=document.getElementById("pFirstName").value;
		pMiddleName=document.getElementById("pMiddleName").value;
		pLastName=document.getElementById("pLastName").value;
		var hinNo="";
		hinNo=document.getElementById("hinNo").value;

		var flag="1";
		var message="Please Enter min three charecter Patient ";
		if(pFirstName!=""){
			var len=pFirstName.length;
			if(parseInt(len)<3){
				//alert("Please Enter min three charecter "+fieldName);
				flag="2";
				message+=" First Name";
			}
		}
		if(pMiddleName!=""){
			var len=pMiddleName.length;
			if(parseInt(len)<3){
				flag="2";
				message+=", Mid Name";
			}
		}
		if(pLastName!=""){
			var len=pLastName.length;
			if(parseInt(len)<3){
				flag="2";
				message+=", Last Name";
			}
		}

		var blankFlag="1";
		if(pFirstName=="" && pMiddleName=="" && pLastName=="" && hinNo==""){
			blankFlag="2";
		}/*else if(pMiddleName==""){
			blankFlag="2";
		}else if(pLastName==""){
			blankFlag="2";
		}else if(hinNo==""){
			blankFlag="2";
		}/*/

		if(flag=="2"){
				alert(message);
				return false;
		}else{
			if(blankFlag=="2"){
				alert("Please fill any one of value...!");
				return false;
			}else{
			submitForm('strPatientIssueEntry','/hms/hms/stores?method=searchPatientIssueEntry');
			return true;
			}
		}
	}
</script>



<div class="titleBg">
<h2>Patient Issue Entry</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<input type="text"	name="<%=HIN_NO %>" id="hinNo" value="" MAXLENGTH="30"/>
<label>Patient First Name</label>
<input type="text"	name="<%=P_FIRST_NAME %>" id="<%=P_FIRST_NAME %>"  value="" MAXLENGTH="15"
					 onchange="checkNameLength(this.value,'Patient First Name')"/>
<label>Patient Mid Name</label>
<input type="text" name="<%=P_MIDDLE_NAME %>" id="<%=P_MIDDLE_NAME %>" value="" MAXLENGTH="15"
	 				 onchange="checkNameLength(this.value,'Patient Mid Name')"/>
<div class="clear"></div>
<label>Patient Last Name</label>
<input type="text"	name="<%=P_LAST_NAME%>" id="<%=P_LAST_NAME%>" value="" MAXLENGTH="15"
					onchange="checkNameLength(this.value,'Patient Last Name')"/>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="submit" name="Submit" id="addbutton"  value="Search" class="button"
    	onclick="checkNameLengthOnSubmit();"accesskey="a" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<form name="patientIssue" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<script	type="text/javascript">
	formFields = [
	          	[0, "<%= HIN_ID%>", "id"], [1,"hin"], [2,"patName"], [3,"add"], [4,"visit_no"], [5,"visit_date"] ];
	 statusTd = 3;
</script>
 <script	type="text/javascript">
	 function cheackBeforesubmit(){

	 var hin=document.strPatientIssueEntry.<%=HIN_NO %>.value;
	 if(hin!=""){
	 return true;
	 }
	 else{
	 return false;
	 }


	 }
	</script>
</form>
</div>

<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = "<%=prop.getProperty("com.jkt.hms.registration_no")%>"
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "hin";

	data_header[1] = new Array;
	data_header[1][0] = "Visit No"
	data_header[1][1] = "data";
	data_header[1][2] = "30%";
	data_header[1][3] = "visit_no";

	data_header[2] = new Array;
	data_header[2][0] = "Visit Date"
	data_header[2][1] = "data";
	data_header[2][2] = "30%";
	data_header[2][3] = "visit_date";

	data_header[3] = new Array;
	data_header[3][0] = "Patient Name"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "patName";

	data_header[4] = new Array;
	data_header[4][0] = "Address"
	data_header[4][1] = "hide";
	data_header[4][2] = "30%";
	data_header[4][3] = "add";

	data_arr = new Array();
	<%
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) {

			Iterator itr=patientList.iterator();
         	 while(itr.hasNext())
           	{

         		PatientPrescriptionHeader  prescriptionHeader = (PatientPrescriptionHeader)itr.next();
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= prescriptionHeader.getId()%>
			data_arr[<%= counter%>][1] = "<%=prescriptionHeader.getVisit().getHin().getHinNo()%>"
			<%
			if(prescriptionHeader.getVisit()!=null){
				String visitDate="";
				if(prescriptionHeader.getVisit()!=null){
					visitDate=HMSUtil.convertDateToStringTypeDateOnly(prescriptionHeader.getVisit().getVisitDate());
				}
				%>
				data_arr[<%= counter%>][2] = "<%=prescriptionHeader.getVisit().getVisitNo()%>"
				data_arr[<%= counter%>][3] = "<%=visitDate%>"
				<%
			}else{
				%>
				data_arr[<%= counter%>][2] = ""
				data_arr[<%= counter%>][3] = ""
				<%
			}

					String middleName = "";
					String lastName = "";
					if(prescriptionHeader.getVisit().getHin().getPMiddleName() != null){
						middleName = prescriptionHeader.getVisit().getHin().getPMiddleName();
					}
					if(prescriptionHeader.getVisit().getHin().getPLastName() != null){
						lastName = prescriptionHeader.getVisit().getHin().getPLastName();
					}

					%>
			data_arr[<%= counter%>][4] = "<%=prescriptionHeader.getVisit().getHin().getPFirstName()%> <%=middleName%> <%=lastName%>"

			data_arr[<%= counter%>][5] = "-"
		<%
 
				     counter++;
	}
			}
		%>

    formName = "patientIssue"

	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;

	}

	makeTable(start,end);
	</script>
