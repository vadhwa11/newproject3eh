

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*"%>

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<title>Surgery Scheduling</title>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<%

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
	
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		
		
		
	
		List pacList = new ArrayList();
		List otList = new ArrayList();
		if (map.get("pacList") != null) {
			pacList = (List) map.get("pacList");
		}
		if (map.get("otList") != null) {
			otList = (List) map.get("otList");
		}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	
%>

<% String message = "";
		if(map.get("message") != null){
			message = (String)map.get("message");
		  }
    %>
<div class="clear"></div>
<%
	if(!message.equals("")){
%>
<H4><span><%=message %></span></H4>

<%} %>
<div class="titleBg">
<h2>OT Booking Patient List</h2>
</div>
<div class="Clear"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>

<form name="otPacClearedList" method="post" action=""><!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div id="test" class="wid">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.SERVICE_NO%>"], [3,"<%= RequestConstants.HIN_NO %>"], [4,"<%= RequestConstants.PATIENT_NAME %>"],[5,"<%= RequestConstants.SERVICE_TYPE_NAME %>"],[6,"<%= RequestConstants.SERVICE_PERSON_NAME %>"],[7,"<%=RequestConstants.AGE%>"],[8,"<%= RequestConstants.SEX %>"],[9,"<%=RequestConstants.PATIENT_TYPE%>"],[10,"<%=RequestConstants.PAC%>"] ];
	 statusTd =12;

</script></div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
</div>

<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = " "
		data_header[0][1] = "hide";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Service No"
		data_header[1][1] = "hide";
		data_header[1][2] = "8%";
		data_header[1][3] = "<%=RequestConstants.SERVICE_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
		data_header[2][1] = "data";
		data_header[2][2] = "10%";
		data_header[2][3] = "<%= RequestConstants.HIN_NO %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Patient Name"
		data_header[3][1] = "data";
		data_header[3][2] = "5%";
		data_header[3][3] = "<%=RequestConstants.PATIENT_NAME %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Service Type"
		data_header[4][1] = "hide";
		data_header[4][2] = "6%";
		data_header[4][3] = "<%=RequestConstants.SERVICE_TYPE_NAME %>";
		
		data_header[5] = new Array;
		data_header[5][0] = "Service Person Name"
		data_header[5][1] = "hide";
		data_header[5][2] = "5%";
		data_header[5][3] = "<%=RequestConstants.SERVICE_PERSON_NAME %>";
		
		data_header[6] = new Array;
		data_header[6][0] = "AGE"
		data_header[6][1] = "data";
		data_header[6][2] = "5%";
		data_header[6][3] = "<%=RequestConstants.AGE %>";
		
		data_header[7] = new Array;
		data_header[7][0] = "SEX"
		data_header[7][1] = "data";
		data_header[7][2] = "10%";
		data_header[7][3] = "<%=RequestConstants.SEX %>";
		
		data_header[8] = new Array;
		data_header[8][0] = "Patient Type"
		data_header[8][1] = "data";
		data_header[8][2] = "6%";
		data_header[8][3] = "<%=RequestConstants.PATIENT_TYPE %>";
		
		data_header[9] = new Array;
		data_header[9][0] = "PAC Status"
		data_header[9][1] = "data";
		data_header[9][2] = "1%";
		data_header[9][3] = "<%=RequestConstants.PAC%>";
		
		data_arr = new Array();
		
		<%
		int  i=0;
		int deptId=0;
		String patientStatus="";
		try{
			String st="";
		
			Iterator iterator=pacList.iterator();
		    
		          while(iterator.hasNext())
		           {   
		        	  OpdSurgeryHeader opdSurgeryHeader=(OpdSurgeryHeader) iterator.next();
		        	  if(opdSurgeryHeader.getBookingStatus()==null || opdSurgeryHeader.getBookingStatus().equalsIgnoreCase("pending")){
		        	  String patientName="";
		        	  if(opdSurgeryHeader.getHin().getPFirstName()!= null){
		        	   patientName=opdSurgeryHeader.getHin().getPFirstName();
	   	        	  }
					if(opdSurgeryHeader.getHin().getPMiddleName()!= null){
						patientName=patientName+" "+opdSurgeryHeader.getHin().getPMiddleName();
					}
					if(opdSurgeryHeader.getHin().getPLastName()!= null)
					{
						patientName=patientName+" "+opdSurgeryHeader.getHin().getPLastName();
					}
						deptId=opdSurgeryHeader.getPrescribedDepartment().getId();
						
						patientStatus= opdSurgeryHeader.getPatientStatus();
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=opdSurgeryHeader.getId()%>
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= opdSurgeryHeader.getId()%>" id="parent" />'
			
			data_arr[<%= i%>][2] = ""
			<%
			   if(opdSurgeryHeader.getHin()!=null)
			   {
			%>
			data_arr[<%= i%>][3]="<%=opdSurgeryHeader.getHin().getHinNo()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][3]=""
			<%
				}
			   if(opdSurgeryHeader.getHin()!= null )
			   {
			%>
			data_arr[<%= i%>][4] = "<%=patientName%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][4] = ""
			<%
			   }
			%>
			data_arr[<%= i%>][5] = ""
			data_arr[<%= i%>][6] = ""
			<%
			   if(opdSurgeryHeader.getHin() != null )
			   {
			%>
			data_arr[<%= i%>][7] = "<%=opdSurgeryHeader.getHin().getAge()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][7] = ""
			
			<%
			  }
			   if(opdSurgeryHeader.getHin().getSex() != null )
			   {
			%>
			data_arr[<%= i%>][8] = "<%=opdSurgeryHeader.getHin().getSex().getAdministrativeSexName()%>"
			<%
			   }else{
			 %>
			 data_arr[<%= i%>][8] = ""
		    <%}
			   if(opdSurgeryHeader.getPatientStatus() != null)
			   {
			%>
			
			data_arr[<%= i%>][9] = "<%=patientStatus%>"
            <%
			   }else{
            %> 			
			data_arr[<%= i%>][9] = ""
		<%   }if(opdSurgeryHeader.getPacStatus() != null || opdSurgeryHeader.getPatientStatus() != ""){
		%>
			data_arr[<%= i%>][10] = "<%=opdSurgeryHeader.getPacStatus()!=null?opdSurgeryHeader.getPacStatus():"Pending"%>"
		<%
		  	}else{
		%>
			data_arr[<%= i%>][10] = ""
		<%}
			i++;
		  }//end of while loop
         }   //end of if loop     
		}catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "otPacClearedList"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script> <input type="hidden" name="counter" id="counter" value="<%=i %>" /> <input
	type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <script
	type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script></form>
</div>
