
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryHeader"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar2.js"></script>


<title>Patient Search For Consent Letter</title>
<div class="clear"></div>
<form name="search" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);

		Map<String, Object> map = new HashMap<String, Object>();
		
		List<BloodRequestEntryHeader> patientList = new ArrayList<BloodRequestEntryHeader>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		String url="";
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientList") != null){
			patientList= (List<BloodRequestEntryHeader>)map.get("patientList");
		}
		if(map.get("sexList") != null){
			sexList= (List<MasAdministrativeSex>)map.get("sexList");
		}
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		}
    %>
    
    
<h2>Blood Consent Letter</h2>
<div class="clear"></div>
<div class="Block">
<h4>Patient Search</h4>
<div class="clear"></div><div class="clear"></div>
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input type="text"
	name="<%=HIN_NO %>" id="hinNo" value="" maxlength="20" />

<label>Patient Name</label> 
<input type="text" name="<%=P_FIRST_NAME %>" id="fName" value="" maxlength="15" />
<label>Gender</label> 
<select id="gender" name="gender">
<option value="0">Select </option>
<%Iterator iterator=sexList.iterator();
while(iterator.hasNext())
{   
	  MasAdministrativeSex administrativeSex= (MasAdministrativeSex)iterator.next(); %>
	  <option value="<%=administrativeSex.getId()%>"><%=administrativeSex.getAdministrativeSexName() %></option>
	  
	  <%} %>
</select>

<div class="clear"></div>

<div class="clear"></div>
<script type="text/javascript">
   function checkBlank(){
     var hin=document.getElementById('hinNo').value;
     var fName=document.getElementById('fName').value;
     var gender=document.getElementById('gender').value;
       if(hin =="" & fName=="" & gender=="0")
       {
			alert("Please Enter any Value For Search!!");
			return false;
       }else
         return true;
   }
 </script> 
 <input type="button" name="Submit" id="addbutton" value="Search" class="button" accesskey="a"
	onclick="if(checkBlank()){submitForm('search','/hms/hms/bloodBank?method=showUploadBloodConsentLetter');}"/>
</div>
</form>
<div class="clear"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="bloodConsentLetter" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


 <script type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"hin"], [2,"patName"], [3,"gender"], [4,"inpatientId"], [5,"visitId"]];
	</script>
</div></form>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "hin";
	
	data_header[1] = new Array;
	data_header[1][0] = "Patient Name"
	data_header[1][1] = "data";
	data_header[1][2] = "20%";
	data_header[1][3] = "patName";
	
	data_header[2] = new Array;
	data_header[2][0] = "Gender"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";
	data_header[2][3] = "gender"
	
	data_header[3] = new Array;
	data_header[3][0] = "InpatientId"
	data_header[3][1] = "hide";
	data_header[3][2] = "10%";
	data_header[3][3] = "inpatientId";
	
	data_header[4] = new Array;
	data_header[4][0] = "VisitId"
	data_header[4][1] = "hide";
	data_header[4][2] = "10%";
	data_header[4][3] = "visitId";


	data_arr = new Array();
	<%
	int  counter=0;
	if (patientList != null && patientList.size() > 0) { %>
		<% for(BloodRequestEntryHeader bldEntry : patientList){ %>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= bldEntry.getHin().getId()%>
			data_arr[<%= counter%>][1] = "<%=bldEntry.getHin().getHinNo()%>";
			data_arr[<%= counter%>][2] = "<%=bldEntry.getHin().getPFirstName()%>";
			data_arr[<%= counter%>][3] = "<%=bldEntry.getHin().getSex()!=null?bldEntry.getHin().getSex().getAdministrativeSexName():""%>";
			data_arr[<%= counter%>][4] = "<%=bldEntry.getInpatient()!=null?bldEntry.getInpatient().getId():""%>";
			data_arr[<%= counter%>][5] = "<%=bldEntry.getVisit()!=null?bldEntry.getVisit().getId():""%>";
			<%
			counter++;
	    }
	}
	%>
	
    formName = "bloodConsentLetter";
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
