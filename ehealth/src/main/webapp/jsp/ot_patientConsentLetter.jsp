
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.OtBooking"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@page import="jkt.hms.masters.business.OtPreAnesthesiaDetails"%>
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
		Map<String, Object> patientMap = new HashMap<String, Object>();
		
		List<OtPreAnesthesiaDetails> patientList = new ArrayList<OtPreAnesthesiaDetails>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();
		String otProcedure="";
		String url="";
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		
		if(patientMap.get("patientList") != null){
			patientList= (List<OtPreAnesthesiaDetails>)patientMap.get("patientList");
		}
		if(patientMap.get("sexList") != null){
			sexList= (List<MasAdministrativeSex>)patientMap.get("sexList");
		}
	%> <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
    %>
    
    
<h2>Ot Consent Letter</h2>
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
	onclick="if(checkBlank()){submitForm('search','/hms/hms/ot?method=showUploadOtConsentLetter');}"/>
</div>
</form>
<div class="clear"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<form name="consentLetter" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


 <script type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"servNo"], [2,"hin"], [3,"patName"], [4,"serviceType"], [5,"sPersonName"], [6,"rank"], [7,"visitId"], [8,"inpatientId"]];
	 statusTd = 7;
	</script>
</div></form>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	data_header[0] = new Array;
	data_header[0][0] = "Service No"
	data_header[0][1] = "hide";
	data_header[0][2] = "7%";
	data_header[0][3] = "servNo"
	
	data_header[1] = new Array;
	data_header[1][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patName";
	
	data_header[3] = new Array;
	data_header[3][0] = "Service Type"
	data_header[3][1] = "hide";
	data_header[3][2] = "10%";
	data_header[3][3] = "serviceType"
	
	data_header[4] = new Array;
	data_header[4][0] = "Service Person Name"
	data_header[4][1] = "hide";
	data_header[4][2] = "15%";
	data_header[4][3] = "sPersonName";
	
	data_header[5] = new Array;
	data_header[5][0] = "Rank"
	data_header[5][1] = "hide";
	data_header[5][2] = "10%";
	data_header[5][3] = "rank";
	
	data_header[6] = new Array;
	data_header[6][0] = "Unit"
	data_header[6][1] = "hide";
	data_header[6][2] = "10%";
	data_header[6][3] = "unit";
	
	data_header[7] = new Array;
	data_header[7][0] = "InpatientId"
	data_header[7][1] = "hide";
	data_header[7][2] = "10%";
	data_header[7][3] = "inpatientId"
	
	
		
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>
	
	<% 	for(OtPreAnesthesiaDetails otBooking : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= otBooking.getHin().getId()%>
			data_arr[<%= counter%>][1] = ""
			data_arr[<%= counter%>][2] = "<%=otBooking.getHin().getHinNo()%>"
			<%
					String middleName = "";
					String lastName = "";
					if(otBooking.getHin().getPMiddleName() != null){
						middleName = otBooking.getHin().getPMiddleName();
					}
					if(otBooking.getHin().getPLastName() != null){
						lastName = otBooking.getHin().getPLastName();
					}
					
					%>
			data_arr[<%= counter%>][3] = "<%=otBooking.getHin().getPFirstName()%> <%=middleName%> <%=lastName%>";
			data_arr[<%= counter%>][4] = ""
			data_arr[<%= counter%>][5] = ""
			data_arr[<%= counter%>][6] = ""
			data_arr[<%= counter%>][7] = "<%=otBooking.getVisit()!=null?otBooking.getVisit().getId():""%>";
			data_arr[<%= counter%>][8] = "<%=otBooking.getInpatient()!=null?otBooking.getInpatient().getId():""%>";
			
		<%
				
				     counter++;
		    	}
			}
		%>
	
    	formName = "consentLetter";
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
	</script>
