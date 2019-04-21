<%@page import="javax.print.attribute.HashAttributeSet"%>
<%@page import="jkt.hms.masters.business.OpdPatientSecondOpinion"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%> 
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>


<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js?n=1"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
 <META HTTP-EQUIV="REFRESH" CONTENT="20"> 
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
	
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


			
	List patientList = new ArrayList();
	int totalPatient=0;
	if(map.get("patientList") != null)
	{
		patientList=(List)map.get("patientList");
	}

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

	%>

<div class="titleBg">
<h2>Immunization</h2>
</div>
<%-- <span><%=message1 %></span> --%>
<div class="Block">
<h4>Immunization Waiting list</h4>
<form name="immunizationSearch" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label class="auto">Token No</label>
<input type="text" name="tokenNo" id="tokenNo" validate="tokenNo,num,no" />
<label class="auto">Patient Name </label>
<input type="text" name="patientName" id="patientName" validate="patientName,alphanumeric,no"/>
<label class="auto">UHID</label>
<input type="text" name="uhid" id="uhid" validate="uhid,alphanumeric,no"/>
<input type="hidden" name="searchFlag" id="searchFlag" value="1"/>
<input type="button" class="buttonAuto"  id="search" name="search" value="Search" onClick="validate();" />
</form>

</div>

<div class="clear"></div>

<div class="floatleft">
<!-- <div style="display:none"> -->
<jsp:include page="searchResultBlockForIPD.jsp" />
<!-- </div>
 -->
 </div>
<div class="clear"></div>	
<div id="test" class="">
<div id="searchresults" tabindex=2>
<div class="cmnTable"  id="searchtable" class="small" tabindex=2>

</div>
</div>
<div id="edited"></div>
<div id="statusMessage"></div>
</div>

<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";
	/*data_header[0][3] = */<%--"<%= RequestConstants.RADIO_FOR_TABLE%>"--%>

	data_header[1] = new Array;
	data_header[1][0] =  "Token No.<b>&nbsp;/&nbsp;</b>Queue No."
	data_header[1][1] = "data";
	data_header[1][2] = "8%";
	/*data_header[1][3] =*/ <%--"<%= RequestConstants.TOKEN_NO%>"--%>

	data_header[2] = new Array;
	data_header[2][0] = "UHID"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";
	/*data_header[2][3] = */<%--"<%=RequestConstants.HIN_NO %>";--%>

	data_header[3] = new Array;
	data_header[3][0] = "Patient Name"
	data_header[3][1] = "data";
	data_header[3][2] = "5%";
	/*data_header[3][3] =*/ <%--"<%=RequestConstants.VISIT_DATE %>";--%>

	data_header[4] = new Array;
	data_header[4][0] = "Age"
	data_header[4][1] = "data";
	data_header[4][2] = "6%";
	/*data_header[4][3] = */<%--"<%=RequestConstants.VISIT_TIME %>";--%>

	data_header[5] = new Array;
	data_header[5][0] = "Gender"
	data_header[5][1] = "data";
	data_header[5][2] = "5%";
	/*data_header[5][3] =*/<%-- "<%=RequestConstants.HIN_NO %>";--%>

	data_header[6] = new Array;
	data_header[6][0] = "Status"
	data_header[6][1] = "data";
	data_header[6][2] = "1%";

	data_arr = new Array();

	<%
	int  i=0;
	int j=1;
	try{
	String st="";
	Iterator iterator=patientList.iterator();
	while(iterator.hasNext())
	{
		Visit visit= (Visit) iterator.next();
		if(visit!=null && !visit.getVisitStatus().equalsIgnoreCase("c"))
		{
		Patient patientHin=(Patient)visit.getHin();
		//System.out.println("patientHin size "+visit.getVisitStatus());
		String patientName="";
		String age="";
		if(visit.getHin().getPFirstName()!= null){
			patientName=visit.getHin().getPFirstName();
			
			if(visit.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+visit.getHin().getPMiddleName();
			}
			if(visit.getHin().getPLastName()!= null)
			{
			patientName=patientName+" "+visit.getHin().getPLastName();
			}
			
			
		}else if(visit.getHin().getFullName()!=null){
			patientName = visit.getHin().getFullName();
		}
		//System.out.println("patientHin size "+patientName);
		String visitStatus="";
		if(visit.getVisitStatus().equalsIgnoreCase("W")){
			visitStatus="Waiting";
		}
		else if(visit.getVisitStatus().equalsIgnoreCase("n")){
			visitStatus="Assessment Done.";
		}
		else if(visit.getVisitStatus().equalsIgnoreCase("s")){
			visitStatus="Second Opinion";
		}
		else if(visit.getVisitStatus().equalsIgnoreCase("p")){
			visitStatus="Parked";
		}else{
			visitStatus="Waiting";
		}
	
		String yearMonth = "";
		if(visit.getHin().getDateOfBirth()!=null){
			Date dob=visit.getHin().getDateOfBirth();
			String ymd=HMSUtil.calculateYearMonthDay(dob);
			String d[]=ymd.split("&");
			int year1=Integer.parseInt(d[0].toString());
			int months1=Integer.parseInt(d[1].toString());
			int days1=Integer.parseInt(d[2].toString());
			yearMonth = year1 != 0 ? d[0] + " Y " : "";
			yearMonth += year1 < 18 && months1 != 0 ? d[1] + " M " : "";
			yearMonth += year1 < 5 && days1 != 0 ? d[2] + " D" : "";
		}
		
		MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
			String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		if(visit.getHin().getAge()!=null && !visit.getHin().getAge().equals("0")){
			age=visit.getHin().getAge();
		}
		%>

		data_arr[<%= i%>] = new Array();

		data_arr[<%= i%>][0] =<%=visit.getId()%>
	
		<%
		if(visit.getTokenNo()!=null)
		{
		%>
		data_arr[<%= i%>][2] = "<%=visit.getTotalHospitalVisit()+"/"+visit.getTokenNo()%> " 
		<%
		}else{
		%>
		data_arr[<%= i%>][2] = ""
		<%
		}

		if(visit.getHin()!=null)
		{
		%>
		data_arr[<%= i%>][3]="<%=visit.getHin().getHinNo()%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][3]=""
		<%
		}

		if(visit.getHin()!= null )
		{
		%>
		data_arr[<%= i%>][4] = "<%=patientName%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][4] = ""
		<%
		}

		if(visit.getAge()!= null )
		{
		%>
		data_arr[<%= i%>][5] =  "<%=yearMonth%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][5] = ""
		<%
		}

		if(masAdministrativeSex!=null && (masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""))
		{
		%>
		data_arr[<%= i%>][6] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
		<%
		}else{
		%>
		data_arr[<%= i%>][6] = ""
		<%
		}

		if(visit.getVisitStatus()!= null)
		{%>
			data_arr[<%= i%>][7] = "<%=visitStatus%>"
		<%}else{%>
			data_arr[<%= i%>][7] = ""
		<%}%>

		<%	
		i++;
		}
	}
	}catch(Exception e){
	e.printStackTrace();
	}
	%>

	formName = "immunizationSearch"

	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;

	makeGridForPatient(start,end);

	//intializeHover('searchresulttable', 'TR', ' tableover');
	</script>
<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=i %>" /> <input
	type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <input
	type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
<script type="text/javascript">

	function validate(){
		var patientName=document.getElementById("patientName").value;
		if(!chkInputLength(patientName))
			{alert("Patient Name should be 1 character");}
		else
			//onclick="submitForm('immunizationSearch','pubHealth?method=searchImmunizationDetail');"
			submitForm('immunizationSearch','pubHealth?method=showImmunizationJsp');
	}
	function chkInputLength(strValue){
			if(strValue!="" && strValue.length<0){
				return false;
			}
			return true;
	}
	
</script>

<%patientList=null;%>