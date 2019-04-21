<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp  
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.15
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.util.HMSUtil"%>


<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>


<%
 
	Map map = new HashMap();
	int waitingCount = 0;
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
 }
	List<OpdSurgeryHeader> pacList = new ArrayList<OpdSurgeryHeader>();
	List sexList = new ArrayList();

	if (map.get("pacList") != null) {
		pacList = (List) map.get("pacList");
	}
	
	if (map.get("sexList") != null) {
		sexList = (List) map.get("sexList");
	}
	 String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	String fromScreen="";
	if(map.get("fromScreen")!=null&&map.get("fromScreen")!=""){
		fromScreen=(String)map.get("fromScreen");
	}
 	 
%>

<div class="titleBg">
<h2>PAC Clearance List</h2>
</div>
<div class="Block">
<div class="clear"></div> 
<title>PAC Clearance List</title>
<form name="search" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label>UHID</label> <input type="text" id="uhid" name="uhid"  maxlength="16"></input>
 <label>Patient Name</label> <input type="text" id="pname" name="pname" maxlength="20"></input>
<label>IP No.</label> <input type="text" id="ipno" name="ipno" maxlength="20"></input>
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
	<%if(fromScreen.equalsIgnoreCase("opClinic")){ %>
<input type="button" name="Search" value="Search" class="button"
		onClick="submitForm('search','/hms/hms/ot?method=showPACClearanceList&screenFrom=opClinic');" /> 
 
 <% }else{%>
	<input type="button" name="Search" value="Search" class="button"
		onClick="submitForm('search','/hms/hms/ot?method=showPACClearanceList');" />
<%} %>	
 </div>
 </form>
 <jsp:include page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>
<div class="clear"></div>
<form name="pacList" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div id="test" class="wid">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
  
<div id="edited"></div>

<div id="statusMessage">
 </div>
</div>
 
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = " "
		data_header[0][1] = "radio";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		 
		
	    data_header[1] = new Array;
		data_header[1][0] = "UHID "
		data_header[1][1] = "data";
		data_header[1][2] = "5%";
		data_header[1][3] = " "
		 
		
		data_header[2] = new Array;
		data_header[2][0] = "Patient Name"
		data_header[2][1] = "data";
		data_header[2][2] = "8%";
		data_header[2][3] = " ";
		
		data_header[3] = new Array;
		data_header[3][0] = "IP No."
		data_header[3][1] = "data";
		data_header[3][2] = "5%";
		data_header[3][3] = " ";
		
		data_header[4] = new Array;
		data_header[4][0] = "Age"
		data_header[4][1] = "data";
		data_header[4][2] = "6%";
		data_header[4][3] = " ";
		
	 
		
		data_header[5] = new Array;
		data_header[5][0] = "Gender"
		data_header[5][1] = "data";
		data_header[5][2] = "5%";
		data_header[5][3] = " ";
		

		 
		

		data_header[6] = new Array;
		data_header[6][0] = "Department"
		data_header[6][1] = "data";
		data_header[6][2] = "5%";
		data_header[6][3] = " ";
		
		data_header[7] = new Array;
		data_header[7][0] = "Surgeon Name"
		data_header[7][1] = "data";
		data_header[7][2] = "5%";
		data_header[7][3] = " ";
		
		data_header[8] = new Array;
		data_header[8][0] = "Procedure Name"
		data_header[8][1] = "data";
		data_header[8][2] = "5%";
		data_header[8][3] = " ";
		
		data_header[9] = new Array;
		data_header[9][0] = "Priority"
		data_header[9][1] = "data";
		data_header[9][2] = "5%";
		data_header[9][3] = " ";
		
		data_header[10] = new Array;
		data_header[10][0] = "Status"
		data_header[10][1] = "data";
		data_header[10][2] = "5%";
		data_header[10][3] = " ";
		
		data_header[11] = new Array;
		data_header[11][0] = "PType"
		data_header[11][1] = "data";
		data_header[11][2] = "8%";
		data_header[11][3] = " ";
		
	 	data_arr = new Array();
		
		<%
		int  i=0;
		try{
			 
			 iterator=pacList.iterator();
		          while(iterator.hasNext())
		           {   
		        	  OpdSurgeryHeader opdSurgeryHeader= (OpdSurgeryHeader)iterator.next();
		        	  if(opdSurgeryHeader.getVisit()!=null || (opdSurgeryHeader.getInpatient()!=null && (opdSurgeryHeader.getInpatient().getAdStatus().equalsIgnoreCase("A") || opdSurgeryHeader.getInpatient().getAdStatus().equalsIgnoreCase("R")))){
		        	  String patientName="";
		        	  if(opdSurgeryHeader.getHin().getPFirstName()!= null)
		        	  {
		        		  patientName=opdSurgeryHeader.getHin().getPFirstName();
		        	  }
		        	  if(opdSurgeryHeader.getHin().getPMiddleName()!= null)
		        	  {
		        		  patientName +=" "+opdSurgeryHeader.getHin().getPMiddleName();
		        	  }
		        	  if(opdSurgeryHeader.getHin().getPLastName()!= null)
		        	  {
		        		  patientName +=" "+opdSurgeryHeader.getHin().getPLastName();
		        	  }
		        	  String requisitionDate =HMSUtil.changeDateToddMMyyyy(opdSurgeryHeader.getRequisitionDate());
		        	 
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=opdSurgeryHeader.getId()%>
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radioCheck" name="opdSurgeryId" value="<%= opdSurgeryHeader.getId()%>" id="parent" />'
			
			<%
				if(opdSurgeryHeader.getPrescribedDepartment().getDepartmentName()!=null)
				{
			%>
			data_arr[<%= i%>][7] = "<%=opdSurgeryHeader.getPrescribedDepartment().getDepartmentName()%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][7] = ""
			<%
				}
			   if(opdSurgeryHeader.getPacStatus()!= null)
			   {
			%>
			data_arr[<%= i%>][11]="<%=opdSurgeryHeader.getPacStatus()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][11]=""
			<%
				}
			   if(opdSurgeryHeader.getHin().getHinNo() !=null )
			   {
			%>
			data_arr[<%= i%>][2] = "<%=opdSurgeryHeader.getHin().getHinNo()%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][2] = ""
			<%
			   }
			   if(patientName != null )
			   {
			%>
			data_arr[<%= i%>][3] = "<%=patientName%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][3] = ""
			<%
			   }
			   %>
			   <%
			   if(opdSurgeryHeader.getInpatient()!=null && opdSurgeryHeader.getInpatient().getAdNo()!= null ){
			   %>
			   data_arr[<%= i%>][4] = "<%= opdSurgeryHeader.getInpatient().getAdNo()%>";
			   
			   <%
			   }else{
			%>
			data_arr[<%= i%>][4] = ""
			<%
			   }
			   %>
			   
			   <%
				    if(opdSurgeryHeader.getInpatient()!=null && opdSurgeryHeader.getInpatient().getAge() != null )
				   {
				%>
				data_arr[<%= i%>][5] = "<%=opdSurgeryHeader.getInpatient().getAge()%>"
				<%
				   }else  if(opdSurgeryHeader.getVisit()!=null && opdSurgeryHeader.getVisit().getAge() != null )
				   {
				%>
				data_arr[<%= i%>][5] = "<%=opdSurgeryHeader.getVisit().getAge()%>"
				<%
				   }else{
				%>
				data_arr[<%= i%>][5] = ""
				<%
				   }
				   %>
				   
				   <%
				    if(opdSurgeryHeader.getHin().getSex().getAdministrativeSexName()!= null )
				   {
				%>
				data_arr[<%= i%>][6] = "<%=opdSurgeryHeader.getHin().getSex().getAdministrativeSexName()%>"
				<%
				   }else{
				%>
				data_arr[<%= i%>][6] = ""
				<%
				   }
				   %>
				   
				   <%
				    if(opdSurgeryHeader.getOpdSurgeryDetails() != null )
				   {
				%>
				data_arr[<%= i%>][9] = "<%=((OpdSurgeryDetail)(opdSurgeryHeader.getOpdSurgeryDetails().toArray()[0])).getChargeCode().getChargeCodeName()%>"
				<%
				   }else{
				%>
				data_arr[<%= i%>][9] = ""
				<%
				   }
				   %>
				   
				   <%
				    if(opdSurgeryHeader.getInpatient()!=null && opdSurgeryHeader.getInpatient().getPriority()!= null )
				   {
				%>
				data_arr[<%= i%>][10] = "<%=opdSurgeryHeader.getInpatient().getPriority()%>"
				<%
				   }else{
				%>
				data_arr[<%= i%>][10] = "-"
				<%
				   }
				   %>
				   
				   <%
				    if(opdSurgeryHeader.getInpatient()!= null )
				   {
				%>
				data_arr[<%= i%>][8] = "<%=opdSurgeryHeader.getEmployee().getEmployeeName() %>"
				<%
				   }else{
				%>
				data_arr[<%= i%>][8] = " "
				<%
				   }
				   %>
				   
			    <%
				   if(opdSurgeryHeader.getInpatient()!=null && opdSurgeryHeader.getInpatient().getAdNo()  != null )
				   {
				%>
				data_arr[<%= i%>][4] = "<%=opdSurgeryHeader.getInpatient().getAdNo()%>"
				<%
				   }else{
				%> 
				data_arr[<%= i%>][4] = ""
			   
					<%
				   }
			    %>
			    data_arr[<%= i%>][12] = "<%=opdSurgeryHeader.getInpatient()!=null?"InPatient":"OutPatient"%>";
				 <% 
		 	i++;
		   }
		           }
		 }catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "pacList"
		 start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>  
 <input type="hidden" name="counter" id="counter" value="<%=i %>" /> 

<%
if(pacList!=null && pacList.size()>0){ if(fromScreen.equalsIgnoreCase("opClinic")){ %>
<input name="Submit" type="button" class="buttonBig"
	value="PAC Entry Form"
	onclick="submitForm('pacList','ot?method=showOpPreAnesthesiaForm','validateRadioForPAC');" />
<%}else{ %>

<input name="Submit" type="button" class="buttonBig"
	value="PAC Entry Form"
	onclick="submitForm('pacList','ot?method=showPreAnesthesiaForm','validateRadioForPAC');" />

<%}} %>
 
</form>
 <script type="text/javascript">
		 function validateRadioForPAC(){
			
			 for(var i = 0; i < document.getElementsByName('opdSurgeryId').length; i++){
			//alert("i-- "+i)
			//alert("document.getElementsByName('parent').length"+ document.getElementsByName('parent').length)
			  if(document.getElementsByName('opdSurgeryId')[i].checked == true)
              {
				return true;
			  }		
  		}
			 if(!displayAlert("Please select the patient"))
				 alert("Please select the patient");
		return false;
		
	} 
 </script>
 
