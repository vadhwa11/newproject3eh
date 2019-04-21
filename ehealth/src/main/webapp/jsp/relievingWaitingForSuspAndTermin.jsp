
<%@page import="jkt.hms.masters.business.MasEmployeeDepartment"%>
<%@page import="jkt.hms.masters.business.HrTerminationProcess"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.HrTransferApplicationM"%>
<%@page import="jkt.hms.masters.business.HrTransferApproved"%>
<%@page import="jkt.hms.masters.business.HrTerminationProcess"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">


<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	
	</script>
<%



	Map map = new HashMap();

List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");

	List<MasEmployeeDepartment> deptList = new ArrayList<MasEmployeeDepartment>();
	List<MasRank> desigList = new ArrayList<MasRank>();
	
	if(map.get("hrTerminationProcessList") != null){
		hrTerminationProcessList=(List<HrTerminationProcess>)map.get("hrTerminationProcessList");
		
		}
	System.out.println("hrTerminationProcessList>>>"+hrTerminationProcessList.size());
	if(map.get("departList") != null){
		deptList=(List<MasEmployeeDepartment>)map.get("departList");
		
		}
	if(map.get("desigList") != null){
		desigList=(List<MasRank>)map.get("desigList");
		
		}

	List patientList = new ArrayList();
	int totalPatient=0;
	int searchDeptId=0;
	
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	int deptId=0;

	if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}

	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	
	/* if (map.get("departmentList") != null) {
		departmentList = (List<MasDepartment>) map.get("departmentList");
	} */
	if (map.get("searchDeptId") != null) {
		searchDeptId = (Integer)map.get("searchDeptId");
	}
	
	String message = ""; 
	if(map.get("msg")!=null)
	{
		message = (String)map.get("msg");
	}
	
	%>
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Relieving Waiting</h2>
</div>
<div class="clear"></div>

<!-- <div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div> -->
<!-- thread search menu -->

<div class="Block" >
<form name="relievingWaitingList" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<label class="auto">Employee Name</label>
<input type="text"  name="employee_name" id="employee_name" />
<label class="auto"> Department </label>
<select  name="department" 	tabindex=1  id="department" 	  validate="Department ,String,no" />
			<option value="">Select</option>
						<%
								for (MasEmployeeDepartment md : deptList) {
									
						%>
							<option value="<%=md.getId() %>"><%=md.getEmpDeptName() %></option>
						<%} %>
			  </select>
<label class="auto"> Designation </label>
<select  name="designation" tabindex=1  id="designation" validate="Designation,String,no" />
			<option value="">Select</option>
						<%
						
								
								for (MasRank mr: desigList) {
								
						%>
							<option value="<%=mr.getId() %>"><%=mr.getRankName() %></option>
						<%} %>
			  </select>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="hidden" name="searchFlag" id="searchFlag" value="1"/>
<input type="button" class="button" id="search" name="search" value="Search" onClick="submitForm('relievingWaitingList','/hms/hrms/training?method=searchWaitingForSuspenTermi');" />
<div class="clear"></div>
</form>
<form name="waitingTermSusp" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<div class="clear"></div>
</div>
</form>
<div class="clear"></div>
 <div class="paddingTop15"></div>
<div class="clear"></div>

 <h4>Relieving Waiting List</h4>
 

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
	<script type="text/javascript" language="javascript">
		formFields = [
						[0,"id"],[1,"empName"],[2,"pen"],[3,"desig"],[4,"depart"]
						,[5,"curr_inst"],[6,"trans_inst"],[7,"status"],[8,"Mode"]
					];
				statusTd =7;
	</script>
	 

<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage"></div>


</div>
<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";
	data_header[0][3] = "id"

	data_header[1] = new Array;
	data_header[1][0] = "Employee Name"
	data_header[1][1] = "data";
	data_header[1][2] = "8%";
	data_header[1][3] = "empName"

	data_header[2] = new Array;
	data_header[2][0] = "PEN"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";
	data_header[2][3] = "pen"

	data_header[3] = new Array;
	data_header[3][0] = "Designation"
	data_header[3][1] = "data";
	data_header[3][2] = "5%";
	data_header[3][3] ="desig"

	data_header[4] = new Array;
	data_header[4][0] = "Department Name"
	data_header[4][1] = "data";
	data_header[4][2] = "6%";
	data_header[4][3] = "depart"

	data_header[5] = new Array;
	data_header[5][0] = "Current Institute"
	data_header[5][1] = "data";
	data_header[5][2] = "5%";
	data_header[5][3] ="curr_inst"

	data_header[6] = new Array;
	data_header[6][0] = "Transfer Institute"
	data_header[6][1] = "hide";
	data_header[6][2] = "5%";
	data_header[6][3] ="trans_inst"

	
		data_header[7] = new Array;
		data_header[7][0] = "Status"
		data_header[7][1] = "data";
		data_header[7][2] = "5%";
		data_header[7][3] ="status"
		
		data_header[8] = new Array;
		data_header[8][0] = "Mode"
		data_header[8][1] = "data";
		data_header[8][2] = "5%";
		data_header[8][3] ="Mode"
		
		
	
	data_arr = new Array();

	<%
	int  i=0;
	try{
	String st="";
	
	
	if(hrTerminationProcessList.size()>0){
		Iterator iterator=hrTerminationProcessList.iterator();
		
		while(iterator.hasNext())
		{
			HrTerminationProcess htp= (HrTerminationProcess) iterator.next();
			
			%>
		
			data_arr[<%= i%>] = new Array();
		
			data_arr[<%= i%>][0] =<%=htp.getId()%>
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= htp.getId()%>" id="parent" />'
			
			<%
			if(htp.getEmployeeId()!=null)
			{
			%>
			data_arr[<%= i%>][2] = "<%=htp.getEmployeeId().getEmployeeName()%>"
			<%
			}else{
			%>
			data_arr[<%= i%>][2] = ""
			<%
			}
			
			
			if(htp.getEmployeeId()!=null)
			{
			%>
			data_arr[<%= i%>][3]="<%=htp.getEmployeeId().getPEN() != null ? htp.getEmployeeId().getPEN():""%>"
			<%
			}else{
			%>
			data_arr[<%= i%>][3]=""
			<%
			}
			
			
			if(htp.getEmployeeId()!= null )
			{
			%>
			data_arr[<%= i%>][4] = "<%=htp.getEmployeeId().getRank().getRankName()%>"
			<%
			}else{
			%>
			data_arr[<%= i%>][4] = ""
			<%
			}
			
			if(htp.getEmployeeId() != null)
			{
			%>
			data_arr[<%= i%>][5] =  "<%=htp.getEmployeeId().getEmployeeDepartment().getEmpDeptName()%>"
			<%
			}else{
			%>
			data_arr[<%= i%>][5] = ""
			<%
			}
			
			if(htp.getEmployeeId() != null)
			{
			%>
			data_arr[<%= i%>][6] = "<%=htp.getEmployeeId().getHospital().getHospitalName()%>"
			<%
			}else{
			%>
			data_arr[<%= i%>][6] = ""
			<%
			}
			
			if(htp.getEmployeeId() != null)
			{
				//for(HrTransferApproved approved:hrTransferApprovedList){
						//if(htam.getId() == approved.getTransferApp().getId()){
			%>
			data_arr[<%= i%>][7] ="<%="-"%>"
			<%//}}
			}else{
			%>
			data_arr[<%= i%>][7] = "-"
			<%
			}
			%>
			<% if(htp.getStatus().equalsIgnoreCase("y")) {%>
			data_arr[<%= i%>][8] = "Active"
			<%}else if(htp.getStatus().equalsIgnoreCase("a")){%>
			data_arr[<%= i%>][8] = "Wating For Relieving"
			<%}%>
			data_arr[<%= i%>][9] = "<%=htp.getTerminationMode()%>"
				<%
				
			   %>
			<%
			i++;
			}
			}
	
	
	}
	
	catch(Exception e){
	e.printStackTrace();
	}
	%>

	formName = "waitingTermSusp"

	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	
	makeGridForPatient(start,end);

	//intializeHover('searchresulttable', 'TR', ' tableover');
	</script>

