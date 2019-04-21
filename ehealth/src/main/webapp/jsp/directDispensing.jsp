<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="java.util.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = ' <%=date+"/"+month+"/"+year%> ';
	
</script> 
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 19 July 2010
 -->
<%
	URL myURL = application
			.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);
%>

<%
	String message="";
	Map map = new HashMap();
	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	boolean lastPrescripitionBasedDispensing = false;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	if (map.get("visitList") != null) {
		departmentList = (ArrayList) map.get("visitList");
	}
	if (map.get("lastPrescripitionBasedDispensing") != null) {
		lastPrescripitionBasedDispensing = Boolean.parseBoolean(map
				.get("lastPrescripitionBasedDispensing").toString());
	}if(map.get("message") != null){
		message=map.get("message").toString();
	}
	List<Visit> visits=new ArrayList<Visit>();
	if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");
	}
	int deptId=0;
	if(map.get("deptId") != null) {
		deptId = (Integer) map.get("deptId");
	}
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	if(map.get("visits") != null){
		visits = (List<Visit>)map.get("visits");
	}
	// Added by Arbind on 21-04-2017
	String issueNo = "";
	if(map.get("issueNo")!=null){
		issueNo=map.get("issueNo").toString();
	}
	//added by govind
List<Visit> patientList = new ArrayList<Visit>();
	int totalPatient=0;
	if(map.get("patientList") != null)
	{
		patientList=(List<Visit>)map.get("patientList");
	}
	System.out.println("patientList jsp "+patientList.size());
	String name="",hNo="",printMessage="";
    if(null !=map.get("hinNo")){
    	hNo=(String)map.get("hinNo");
    	}
    if(null !=map.get("name")){
    	name=(String)map.get("name");
    	} 
    	int issueTId=0,visitId=0,hinId=0;
    	
    	 if(null !=map.get("issueTId")){
    		 issueTId=Integer.parseInt(map.get("issueTId").toString());
    	  }
    	 if(map.get("message")!=null){
    			printMessage=map.get("message").toString();
    		}
    	 if(null !=map.get("visitId")){
    		 visitId=Integer.parseInt(map.get("visitId").toString());
    	  }
    	  if(null !=map.get("hinId")){
    		  hinId=Integer.parseInt(map.get("hinId").toString());
     	  }
    	  int hospitalId=0;
    		if (session.getAttribute("hospitalId") != null
					&& (!"".equals(session.getAttribute("hospitalId")))) {
				hospitalId = Integer.parseInt(session.getAttribute("hospitalId").toString());
			}
    	int departmentId=0;
    	 if(null !=map.get("departmentId")){
    		 departmentId=Integer.parseInt(map.get("departmentId").toString());
    	  }
    	 
    	String paperBased="N";
    	 if(null !=map.get("paperBased")){
    		paperBased=(String)map.get("paperBased");
    	 }
	//added by govind
%>

<% if(issueTId!=0){%>
<form name="Report" method="post" action="">
<h4>
<%=printMessage%> 
</h4> 
<%if(paperBased.equalsIgnoreCase("Y")){%>
<input type="button" value="Print" onclick="PrintPaperReport(<%=issueTId %>,<%=visitId %>,<%=hinId %>,'<%=issueNo %>');" /> 
<%}else{%>
<input type="button" value="Print" onclick="PrintReport('<%=hNo %>',<%=departmentId %>,'<%=issueNo %>');" />
<%}%>
<input type="button" value="Back" onclick="submitForm('Report','stores?method=directDispensing');" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<% }else{%>
<div class="titleBg">
	<h2>Search Patient Visit</h2>
</div>
<div class="clear"></div>
<h4><span><%=message%></span></h4>
<form name="search" method="post" action="">
	<div class="Block">
		<div id="hinDiv">
			<label class="medium"> <%=prop.getProperty("com.jkt.hms.registration_no")%></label>
			<input type="text" name="searchHinNo" value="<%=hNo %>" MAXLENGTH="30" validate="<%=prop.getProperty("com.jkt.hms.registration_no")%>,metachar,no" />
			
			<label class="medium">Patient Name</label>
			<input type="text" name="patientName" value="<%=name %>" MAXLENGTH="30" validate="Patient Name,string,no" />
			
			
		</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	<input type="hidden" name="lastPrescripitionBasedDispensing"
		value="<%=lastPrescripitionBasedDispensing%>" /> 
		<%--
		<input type="button"
		name="Search" value="Search" class="button"
		onClick="submitForm('search','stores?method=getPatientVisitInfo&searchFlag=yes');" />--%>
		
		<input type="button"
		name="Search" value="Search" class="button"
		onClick="submitForm('search','stores?method=searchdirectDispensing');" />
		
	<input type="reset" name="Reset" value="Reset" class="buttonHighlight"
		accesskey="r" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<!-- added by govind --> 
  
<% int currentPage=0;
int noOfPages=0;
if(null !=map.get("currentPage")){
	currentPage=(Integer)map.get("currentPage");
    noOfPages=(Integer)map.get("noOfPages");
	}
	if(patientList.size()>0){%>

	<table class="tableTrhighlights">
		<tr>
			<th>UHID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Address</th>
		</tr>
	<%
	String st="";
	for(Visit visit:patientList){
	
		Patient patientHin=(Patient)visit.getHin();
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
		
		String doctorName="";
		if(visit.getDoctor()!=null){
			if(visit.getDoctor().getFirstName()!=null && !visit.getDoctor().getFirstName().equals(" ")){
				doctorName= visit.getDoctor().getFirstName()+" ";
			}
			 if(visit.getDoctor().getMiddleName()!=null && !visit.getDoctor().getMiddleName().equals(" ")){
				doctorName=doctorName+ visit.getDoctor().getMiddleName()+" ";
			}
			if(visit.getDoctor().getLastName()!=null && !visit.getDoctor().getLastName().equals(" ")){
				doctorName=doctorName+ visit.getDoctor().getLastName();
			} 
		}
		
		
		Integer prioityNumber=3;
		Integer triageCategory=0;
		MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
			String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		if(visit.getHin().getAge()!=null && !visit.getHin().getAge().equals("0")){
			age=visit.getHin().getAge();
		}
		if(visit.getPriorityNumber()!=null)
			prioityNumber=visit.getPriorityNumber();
		if(visit.getTriageCategory()!=null)
			triageCategory=visit.getTriageCategory();
		%>
	
	<tr onclick="submitForm('search','stores?method=getPatientVisitInfo&searchFlag=yes&hinNo=<%=patientHin.getHinNo()%>')">
			<td><%=patientHin.getHinNo()%></td>
			<td><%=patientName%></td>
			<td><%=masAdministrativeSex.getAdministrativeSexName()%></td>
			<td><%=age%></td>
			<td><%="" %></td>
		</tr>
		<%}%>
			</table>
		<%
	if(currentPage !=1){%>

		<a href='/hms/hms/stores?method=searchdirectDispensing&page=<%=currentPage-1%>&hinNo=<%=hNo%>&patientName=<%=name%>'>Previous</a>


	<%}

if(noOfPages>=1){
	for(int i=1;i<=noOfPages;i++){
		if(currentPage==i){%>
	<%=i%>
	<%}else{%>

	<a
		href='/hms/hms/stores?method=searchdirectDispensing&page=<%=i%>&hinNo=<%=hNo%>&patientName=<%=name%>'><%=i%></a>
	<%
	}}
}
if(currentPage <noOfPages){%>

	<a
		href='/hms/hms/stores?method=searchdirectDispensing&page=<%=currentPage+1%>&hinNo=<%=hNo%>&patientName=<%=name%>'>Next</a>
	
	<%}}%>
<div class="clear"></div>
 <!-- added by govind end -->
</form>
<div class="Block">
    <%if(visits.size()>0){ %>
    <table>
        <tr><th>S.No</th><th>Date</th><th>Patient Name</th><th>Department</th></tr>
        <% int sn=1;
        for(Visit visit:visits){ %>
        
        <tr onclick="submitForm('pendingList<%=sn %>', 'stores?method=getPatientVisitInfo')" style="cursor: pointer;">
        <td><%=sn %>
        <form name="pendingList<%=sn %>" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=visit.getId()%>" />
        <input type="hidden" name="<%=HIN_NO %>" value="<%=visit.getHin().getHinNo()%>" />
        <input type="hidden" name="lastPrescripitionBasedDispensing" value="<%=lastPrescripitionBasedDispensing%>" />
        <input type="hidden" name="visitNo" value="<%=visit.getVisitNo()%>" />
        </form>
        </td><td><%=HMSUtil.convertDateToStringWithoutTime(visit.getVisitDate()) %></td>
        <td><%=visit.getHin().getPFirstName() %></td>
        <td><%= visit.getDepartment().getDepartmentName()%></td></tr>
        <% sn++;} %>
         
    </table>
    <%}else{ %>
        No Record Found
        <%} %>
   </div>
   
 
  
<div id="error"></div>
<% }%>
<script>
function PrintPaperReport(issueId,visitId,hinId,issueNo){
	//alert("val---->>>"+val);
	submitForm('Report','stores?method=printDirectDispencing&issueId='+issueId+"&visitId="+visitId+"&hinId="+hinId+"&paperBased=Y"+"&issueNo="+issueNo);
	
}

function PrintReport(hinNo,departmentId,issueNo){
	//alert("val---->>>"+hinNo);
	submitForm('Report','stores?method=printDirectDispencing&hinNo='+hinNo+"&issueNo="+issueNo+"&departmentId="+departmentId);
	
}
</script>
 