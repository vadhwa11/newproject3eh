<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasServiceCentreCounter"%>
<%@page import="javax.print.attribute.HashAttributeSet"%>
<%@page import="jkt.hms.masters.business.OpdPatientSecondOpinion"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Properties"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.Map.Entry"%>
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
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript">


<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->

	</script>
	
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
	List<MasServiceCentreCounter> serviceCentreCounterList = null;
	MasEmployee employee = null;
	Date visitTimeUpto = null;
	MasHospital masHospital = null;
	int totalPatient=0;
	int assignedPatients = 0;
	int freePatients = 0;
	if(map.get("patientList") != null)
	{
		patientList=(List)map.get("patientList");
	}
	
	if (map.get("assignedPatients") != null) {
		assignedPatients = (Integer) map.get("assignedPatients");
	}
	
	if (map.get("freePatients") != null) {
		freePatients = (Integer) map.get("freePatients");
	}
	
	// added by amit das on 19-04-2017
	if(map.get("serviceCentreCounterList") != null)
	{
		serviceCentreCounterList=(List)map.get("serviceCentreCounterList");
		Set s = new LinkedHashSet(serviceCentreCounterList);
		serviceCentreCounterList.clear();
		serviceCentreCounterList.addAll(s);
	}

	// added by amit das on 19-04-2017
	if(map.get("masHospital") != null){
		masHospital =(MasHospital)map.get("masHospital");
	}
	if(map.get("employee") != null)
	{
		employee=(MasEmployee)map.get("employee");
		visitTimeUpto = employee.getVisitTimeUpto();
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
	userName = (String) session.getAttribute("userName");
	}
	int deptId=0;
	int userId = 0;
	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer)session.getAttribute("hospitalId");
		}
	String patientStatus = ""; /* Added By Om Tripathi 11/08/2017 starts */
	String VisitId="";
	String uhidNum="";
	int employeeId = 0;
	Map contextMaps=null;
	if( application.getAttribute("contextMaps")!=null){
		contextMaps=(Map)application.getAttribute("contextMaps");
		if(contextMaps!=null && contextMaps.size() > 0){
			patientStatus = String.valueOf(contextMaps.get("patientStatus"));
			VisitId = String.valueOf(contextMaps.get("VisitId"));
			uhidNum = String.valueOf(contextMaps.get("uhidNum"));
		}
	}
	String lastOpenAt =null;
	long diffMinutes=0L;
	 //* Added By Om Tripathi 11/08/2017 end */

	if (map.get("deptId") != null) {
	deptId = (Integer) map.get("deptId");
	}
	
	if (map.get("userId") != null) {
		userId = (Integer) map.get("userId");
	}

	String deptName="";
	if (map.get("deptName") != null) {
	deptName = (String) map.get("deptName");
	}
	
	String message1="";
	if (map.get("message1") != null) {
		message1 = (String) map.get("message1");
	}
	if (map.get("openMsg") != null) {
		message1 = (String) map.get("openMsg");
	}
	List<OpdPatientSecondOpinion>opdPSList=null;
	Map<Integer,String>secondOpinionDoc=new HashMap<Integer,String>();
	if (map.get("opdPSList") != null) {
		opdPSList = (List<OpdPatientSecondOpinion>) map.get("opdPSList");
		for(OpdPatientSecondOpinion opd:opdPSList){
			String name=opd.getOpinionDoctor().getFirstName();
			if(opd.getOpinionDoctor()!=null){
				name=name+" "+opd.getOpinionDoctor().getMiddleName();
			}
			if(opd.getOpinionDoctor()!=null){
				name=name+" "+opd.getOpinionDoctor().getLastName();
			}
			secondOpinionDoc.put(opd.getVisit().getId(), name);
		}
	}
	
	String tokenNo="",pName="",hinNo="";
	if (map.get("tokeNo") != null) {
		int tno=Integer.parseInt(map.get("tokeNo").toString());
		if(tno>0){
		tokenNo =""+tno;
		}
	}
	if (map.get("patientName") != null) {
		pName = (String) map.get("patientName");
	}
	if (map.get("uhid") != null) {
		hinNo = (String) map.get("uhid");
	}
	String flag="";
	if (map.get("flag") != null) {
		flag = (String) map.get("flag");
	}

	int searchFlag=0;
	if (map.get("searchFlag") != null) {
		searchFlag = (Integer) map.get("searchFlag");
	}
	
	if(employee!=null){
		employeeId = employee.getId();
	}
	
	%>
<script type="text/javascript">
function listSizeAlert(){
	var deptId=   document.getElementById("deptId").value;
	var doctorId=document.getElementById("doctorId").value;
	var hospitalId=document.getElementById("hospitalId").value
	 var listSize = '<%= session.getAttribute("alertCount") %>';
	if(listSize!='null'){
	var prevListSize='<%= session.getAttribute("alertCount") %>';
	} 
    var url = '/hms/hms/investigation?method=showLabResultDetailAlert&deptId=' + deptId
			+ '&doctorId=' + doctorId+ '&hospitalId=' + hospitalId +'&'+csrfTokenName+'='+csrfTokenValue;
    var jsonData = '';
    var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	jsonData = this.responseText;
	    	if(jsonData!='0'){
	    	 document.getElementById('alert').innerHTML=jsonData;
	    	 document.getElementById('alert').classList.add('countLabResult');
	    	 document.getElementById('labAlert').style.background = 'none';
	    	 document.getElementById('labAlert').style.background = 'red';
	    	}else{
	        	document.getElementById('alert').innerHTML="";
	        }
	    	}
	    };
	xhttp.open("POST", url, true);
	xhttp.send();
}
</script>

<div class="titleBg">
<h2 style="line-height:22px;"><%=deptName %></h2>
</div>
<span><%=message1 %></span>
<div class="Block" style="padding-top:3px;padding-bottom:0px;">

<form name="opWaitingList" action="" method="post">
<h4 style="float:left; width:165px;">OP Clinic Waiting list</h4>

<input type="hidden" id="parkFlag" value="<%=flag%>"/>
<input type="hidden" id="userId" value="<%=userId%>"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<label class="medium">Token No</label>
<input type="text" class="medium" name="tokenNo" id="tokenNo" validate="tokenNo,num,no" value="<%=tokenNo%>" onkeypress="return searchKeyPress(event);"/>
<label class="medium">Patient Name</label>
<input type="text" name="patientName" id="patientName" validate="patientName,alphanumeric,no" value="<%=pName%>" onkeypress="return searchKeyPress(event);"/>
<label class="medium">UHID</label>
<input type="text" name="uhid" id="uhid" validate="uhid,alphanumeric,no" value="<%=hinNo%>" onkeypress="return searchKeyPress(event);"/>
<input type="hidden" name="searchFlag" id="searchFlag" value="<%=searchFlag%>"/>
<input type="hidden" id="patientStatus" name="patientStatus" value="<%=patientStatus %>">
<input type="hidden" id="VisitId" name="VisitId" value="<%=VisitId %>"> 
<input type="hidden" id="uhidNum" name="uhidNum" value="<%=uhidNum %>">
<input type="hidden" id="doctorId" name="doctorId" value="<%=userId %>">
<input type="button" class="buttonAuto"  id="search" name="search" value="Search" onClick="validate();"  />
<input type="hidden" name="hospitalId" id="hospitalId" value="<%=hospitalId %>" />
<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" />
</form>
<div class="clear"></div>
<form name="opd_OP_Clinic_Waiting_PatientList_new_detail" method="post" action=""  onload="javascript:submitProtoAjaxWithDivName('opd_OP_Clinic_Waiting_PatientList_new_detail','/hms/hms/investigation?method=showLabResultDetailAlert','alertdiv');">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="hospitalId" id="hospitalId" value="<%=hospitalId %>" />
<input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" />
<input type="hidden" id="doctorId" name="doctorId" value="<%=userId %>">
<%
if(patientList.size()>0)
{
	totalPatient = patientList.size();
	//System.out.println("patientList "+patientList.size());
}%>
<div class="clear"></div>
<%-- <input type="button" name="openButton" value="Open Token Display"	class="buttonAuto" onclick="openTokenDisplay(<%=deptId%>)"/>
<input type="button" name="closeButton" value="Close Token Display" onclick="closeTokenDisplay()" class="buttonAuto" /> --%>
<input type="button" name="sceondOpinion" value="Second Opinion List" class="buttonAuto" onclick="openSecondOpinion(<%=deptId%>)"/>
<input type="button" name="oprecalllist" value="Recall Patient"	class="buttonAuto" onclick="openWindows()"/>
<input type="button" value="Parked Patient"	class="buttonAuto" onclick="showParkPatient('p')"/>
<input type="button" value="Transfer To Common Pool / Mass Release" class="buttonAuto" onclick="transferToCommonPool('<%=employeeId%>');"/>
<input type="button" name="sceondOpinion" value="Show My Patients" class="buttonAuto" onclick="showDoctorSpecificPatientList()"/>
<input type="button" value="Transfer Patient" class="buttonAuto" onclick="openTransferPatient();" />
<input type="button" name="openLab" id="labAlert" value="Lab-Alert"	class="buttonAuto" onload="listSizeAlert();" onclick=" openLabNotification();"/>
<div id="alertdiv"></div> <!-- -->

<div id="alert"><%-- <%=session.getAttribute("alertCount") %> --%></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(null !=masHospital && null !=masHospital.getCounterWiseTokenDisplay()) {%>
<input type="hidden" id="counterFlag" value="<%=masHospital.getCounterWiseTokenDisplay()%>">
<%} %>
<div class="clear"></div>
<div class="floatleft">
<div class="clear"></div>
<div class="clear"></div>
<input type="hidden" name="docIdForVisitTime" value="<%=(employee!=null)?employee.getId():"0"%>">
<%-- <label style="font-size:15px;">Visit Time Upto</label>
<input type="text" name="visitTimeUpto" id="visitTimeUpto" style="width:134px;margin-right:0px;" validate="visitTimeUpto,string,no" value="<%=(visitTimeUpto!=null)?visitTimeUpto:""%>"  maxlength="5" onKeyUp="mask(this.value,this,'2',':');" /> --%>
<%-- time <%=visitTimeUpto%> <%=visitTimeUpto.compareTo(HMSUtil.getCurrentDateAndTimeObject())%> --%>
<input type="button" class="<%=visitTimeUpto!=null && visitTimeUpto.compareTo(HMSUtil.getCurrentDateAndTimeObject())>0?"disabled":"buttonAuto" %>" style="margin-top: 0;"  id="search" name="search" value="STOP MY REGISTRATION" onclick="stopRegistration();" />
</div>
</form>

<div style="float:right; min-width:400px;">
<label class="auto" style="font-size:15px;margin-right:0;">Doctor's Patients</label>
<label style="font-size:15px;width:32px;margin-left:0;background:#5bc0de;"><%=assignedPatients%></label>
<label class="auto" style="font-size:15px;margin-right:0;">Common Pool Patients</label>
<label style="font-size:15px;width:32px;margin-left:0;background:#5bc0de;"><%=freePatients%></label>
</div>
</div>

<!-- added by amit das on 19-04-2017 -->
<% if(masHospital!=null &&  masHospital.getCounterWiseTokenDisplay()!=null && masHospital.getCounterWiseTokenDisplay().equalsIgnoreCase("y")) {%>

<div class="clear"></div>
<div class="floatleft">
<label style="font-size:15px;">OP Clinic Counter <span>*</span></label>
<select id="counterId" onchange="bookCounterForDoctor();">
<option value="0">Select Counter No</option>
 <% if(serviceCentreCounterList!=null) {
 	for(MasServiceCentreCounter masServiceCentreCounter : serviceCentreCounterList){
 	if( masServiceCentreCounter.getStatus()!=null && masServiceCentreCounter.getStatus().equalsIgnoreCase("b")|| request.getSession().getAttribute("counterId")!=null && request.getSession().getAttribute("counterId").equals(masServiceCentreCounter.getId())){	
 	%>
 <option value="<%=masServiceCentreCounter.getId()%>" selected="selected"><%=masServiceCentreCounter.getCounterNo()%></option>
 <%} else { %>
 <option value="<%=masServiceCentreCounter.getId()%>"><%=masServiceCentreCounter.getCounterNo()%></option>
 <% } 
 } }%>
</select>
</div>
<% } %>

<!-- <div style="display:none"> -->
<jsp:include page="searchResultBlockForIPD.jsp" />
<!-- </div>
 -->
<div class="clear"></div>	
<div id="test">
<div id="searchresults" tabindex=2>
<div class="cmnTable" id="searchtable"  tabindex=2>

</div>
</div>
<div id="edited"></div>
<div id="statusMessage"></div>
</div>

<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="paddingTop5"></div>

<!-- <div class="cmnTable">
---New waiting list table showing here--
</div> -->

<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";
	/*data_header[0][3] = */<%--"<%= RequestConstants.RADIO_FOR_TABLE%>"--%>

	data_header[1] = new Array;
	data_header[1][0] =  "OP No.<b>&nbsp;/&nbsp;</b>Token No."
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
	
	data_header[7] = new Array;
	data_header[7][0] = "Priority"
	data_header[7][1] = "data";
	data_header[7][2] = "6%";
	
	data_header[8] = new Array;
	data_header[8][0] = "Second Opinion Doctor and Status"
	data_header[8][1] = "data";
	data_header[8][2] = "6%";
	
	data_header[9] = new Array;
	data_header[9][0] = "Action"
	data_header[9][1] = "data";
	data_header[9][2] = "6%";

	/* data_header[10] = new Array;
	data_header[10][0] = "Skip Reason"
	data_header[10][1] = "data";
	data_header[10][2] = "6%"; */
	
	/* 
	data_header[10] = new Array;
	data_header[10][0] = ""
	data_header[10][1] = "data";
	data_header[10][2] = "6%";
	
	data_header[11] = new Array;
	data_header[11][0] = ""
	data_header[11][1] = "data";
	data_header[11][2] = "6%";
	
	data_header[12] = new Array;
	data_header[12][0] = "Action"
	data_header[12][1] = "hide";
	data_header[12][2] = "6%";
	 */
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
		if(visit!=null && !visit.getVisitStatus().equalsIgnoreCase("c") && !visit.getVisitStatus().equalsIgnoreCase("x"))
		{
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
		
		/* Added by Arbind on 26-04-2017 */
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
		Integer lastOpenBy=visit.getOpenby()!=null?visit.getOpenby().getId():0;
		 lastOpenAt=visit.getOpenat();
		if(lastOpenAt!=null && !lastOpenAt.equals("") && lastOpenBy!=0){
			String dateStop = HMSUtil.convertDateToStringOnlyTime(new Date());
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date d1 = format.parse(lastOpenAt);
			Date d2 = format.parse(dateStop);
			long diff = d2.getTime() - d1.getTime();
			diffMinutes = diff / (60 * 1000) % 60;
		
		}  
	
		
		%>

		data_arr[<%= i%>] = new Array();
	
		data_arr[<%= i%>][0] =<%=visit.getId()%>
		
		<%
		if(visit.getTokenNo()!=null)
		{
		%> 
		/* changed by amit das on 29-08-2017 */ 
		data_arr[<%= i%>][2] = "<%=(visit.getCreationSource()!=null && visit.getCreationSource().equalsIgnoreCase("L"))?"L"+visit.getTotalHospitalVisit()+"/"+visit.getTokenNo():visit.getTotalHospitalVisit()+"/"+visit.getTokenNo()%> "    
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
		if(visit.getHin().getDateOfBirth()!= null )
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
		
		data_arr[<%= i%>][8] ='<%=prioityNumber%>'
		
		<%if(secondOpinionDoc.get(visit.getId())!=null){%>
			data_arr[<%= i%>][9] ='<%=secondOpinionDoc.get(visit.getId())%>, <%=visit.getVisitStatus().equalsIgnoreCase("o")?"Complete":"Not Complete" %>'
		<%}else{%>
			data_arr[<%= i%>][9] ='';
		<%}%>
		
		var visitid =  <%=visit.getId()%> 
		var tokenNo =  '<%=visit.getTokenNo()%>';
		
		<%-- 
		<%if(visit.getOpCallCount()!=null && visit.getOpCallCount()>=3){%>
		data_arr[<%= i%>][10] ="<input type='button' name='btn' id='btn' value='Release' onclick='doPatientRelease("+visitid+");' />";
		<%}else{%>
		data_arr[<%= i%>][10] = "";
		<%}%> --%>		
		<%-- data_arr[<%= i%>][10] ='<input type="button" name="btn" id="btn" value="Lite" onclick="if(checkForCounter()){openOpdLite(\''+visitid+'\');}" />'; --%>
		data_arr[<%= i%>][10] = "";
		<%-- data_arr[<%= i%>][11] = "<select name='skip<%=i%>' id='skip<%=i%>' ><option value='0'>Select</option><option value='E'>Emergency</option><option value='S'>Special</option></select>"; --%>
		<%-- data_arr[<%= i%>][11] ="<input type='button' name='btn' id='btn' value='Detail' onclick='if(checkForCounter()){openDetail("+visitid+")}' />"; --%> 
		
		<%-- data_arr[<%= i%>][11] =""; --%>
	
		<%-- <%if(visit.getOpenby()!=null && visit.getOpenat()!=null &&  diffMinutes <5){%>
		data_arr[<%= i%>][13] ="Y";
		<%}else{%>
		data_arr[<%= i%>][13] = "N";
		<%}%> --%>
		<%	
		i++;
		}
	}
	}catch(Exception e){
	e.printStackTrace();
	}
	%>

	formName = "opd_OP_Clinic_Waiting_PatientList_new_detail";

	start = 0;
	<% if(searchFlag==1) {%>
		rowsPerPage = 10;
	<% }else{ %>
		rowsPerPage = 3;
	<% } %>
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	
	makeGridForPatient(start,end);

	//intializeHover('searchresulttable', 'TR', ' tableover');
	</script>
<div class="clear"></div>
<input type="hidden" name="counter" id="counter" value="<%=i %>" />
<%-- <input type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> --%>
<input type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
<%-- <input type="hidden" name="hospitalId" id="hospitalId" value="<%=hospitalId %>" /> --%>
<script type="text/javascript">
function openDetail(visitId,rowVal,skipped){
	var searchFlag = 	document.getElementById('searchFlag').value;
	if(rowVal==0  && searchFlag=='0'){
		submitFormForButton('opd_OP_Clinic_Waiting_PatientList_new_detail','/hms/hms/opd?method=showOpdDetailJsp&visitId='+visitId);
	}else{
		   if(confirm("You are Skipping the patient ?")){
			   submitFormForButton('opd_OP_Clinic_Waiting_PatientList_new_detail','/hms/hms/opd?method=showOpdDetailJsp&visitId='+visitId+'&skipped=E&searchFlag='+searchFlag);
		   }
	}
}

function openOpdLite(visitId,rowVal,skipped){
	var searchFlag = 	document.getElementById('searchFlag').value;
	if(rowVal==0  && searchFlag=='0'){
		submitFormForButton('opd_OP_Clinic_Waiting_PatientList_new','/hms/hms/opd?method=showOpdLiteJsp&visitId='+visitId);
	}else{
		   if(confirm("You are Skipping the patient ?")){
			   submitFormForButton('opd_OP_Clinic_Waiting_PatientList_new','/hms/hms/opd?method=showOpdLiteJsp&visitId='+visitId+'&skipped=E');
		   }
	}   
	
}


function openLabNotification(){
	var deptId=   document.getElementById("deptId").value;
	var doctorId=document.getElementById("doctorId").value;
	var hospitalId=document.getElementById("hospitalId").value;
    var url = '/hms/hms/investigation?method=showLabResultDetail&deptId=' + deptId
			+ '&doctorId=' + doctorId+ '&hospitalId=' + hospitalId +'&'+csrfTokenName+'='+csrfTokenValue;
	newwindow = window
			.open(url, 'opd_window',
					"left=100,top=20,height=330,width=1330,status=1,scrollbars=yes,resizable=0");

}
var bReleaseClick='N';
	function openWindows(){
	    obj1 = eval('document.opd_OP_Clinic_Waiting_PatientList_new_detail');
	    var url = "/hms/hms/opd?method=getOPClinicalReadViewList&"+csrfTokenName+"="+csrfTokenValue+"&opdType=opdDeatail";
	    listSizeAlert();
	    obj1.action = url;
		obj1.submit();
		/* obj2 = eval('document.opd_OP_Clinic_Waiting_PatientList');
		 var url= '/hms/hms/investigation?method=showLabResultDetailAlert&deptId=' + deptId
	        + '&doctorId=' + doctorId+ '&hospitalId=' + hospitalId +'&'+csrfTokenName+'='+csrfTokenValue;
         obj2.action = url;
		obj2.submit();
 */	}
	

	function validate(){
		var patientName=document.getElementById("patientName").value;
		if(!chkInputLength(patientName))
			{alert("Patient Name should be 1 characher");}
		else
			document.getElementById("searchFlag").value = '1';
			submitForm('opWaitingList','/hms/hms/opd?method=showNewOPDetailWaitingList&'+csrfTokenName+'='+csrfTokenValue);
	}
	function chkInputLength(strValue){
			if(strValue!="" && strValue.length<0){
				return false;
			}
			return true;
	}

	//window.moveTo(0,0);
	function validateICard(){
	var counter=document.getElementById("counter")
	for(var i = 0; i < document.getElementsByName('parent').length; i++){

	if(document.getElementsByName('parent')[i].checked == true)
	{
	var index=start+i;
	var status=document.getElementById('iCardStatus'+index).value
	if(status=="n")
	{
	alert("I-Card is not available with the patient.")
	return true;
	}
	//alert("I -Card Status for patient----:"+status)
	return true;
	}
	}
	alert("Please select the patient")
	return false;

	}
	function openTokenDisplay(deptId)
	{
	 var url="/hms/hms/opd?method=showPopupTokenJsp&deptId="+deptId+"&"+csrfTokenName+"="+csrfTokenValue;
	 //newwindow=window.open(url,"","status=no,scrollbars=no,resizable=yes,height = 600, width = 800,fullscreen=yes");
	 newwindow=window.open(url,"","status=no,scrollbars=no,resizable=yes,"+'height=' + screen.height + ',width=' + screen.width+"+fullscreen=yes");
	 newwindow.moveTo(1024,0);
	}
	
	function openSecondOpinion(deptId)
	{
	 //var height=550;
	 //var width=1050;
	// var left = (screen.width/2)-(width/2);
	 //var top = (screen.height/2)-(height/2);	
	 var url="/hms/hms/opd?method=showSecondOpnionListJsp&deptId="+deptId+"&"+csrfTokenName+"="+csrfTokenValue;
	 //newwindow=window.open(url,"Second Opinion","status = no, height = "+height+", width =" +width+",top="+top+", left="+left);
	 newwindow=window.open(url,"Second Opinion","left=150,top=100,height=550,width=1050,status=1,scrollbars=1,resizable=0");
	 //newwindow.moveTo(1024,0);
	}
	
	function closeTokenDisplay(){

		if(false == newwindow.closed)
		{
			newwindow.close();
		}
		else
		{
		alert('Window already closed!');
		}
	}
	
	
	function doPatientRelease(visitId)
	{
			bReleaseClick ='Y';
		
				
		 	var data = "visitId="+visitId;
		    var url = "opd?method=doPatientRelease";
		    
		 	    
		  jQuery(function ($) {
		  
		    	$.ajax({
					type:"POST",
					url: url+'&'+csrfTokenName+'='+csrfTokenValue,
					data: data,	 							
					cache: false,
					success: function(msg)
					{									 
						//alert(msg);
						
						
						if(msg.indexOf("success~~~true") != -1)
							{
									alert("Release successfully");
									bReleaseClick ='N';
									window.location ="opd?method=showNewOPWaitingList&selectedAppId=A1641";
									
							}
						else
							{
								bReleaseClick ='N';
								alert("An error has occurred while contacting the server");
							}
						
						
										
						
					},
					error: function(msg)
					{					
						bReleaseClick ='N';
						alert("An error has occurred while contacting the server");
						
					}
					
					});
		    });   
	}
	
	callWaitingList();
	listSizeAlert();
	function callWaitingList(){
		var tokenNo=document.getElementById("tokenNo").value;
	    var pName=document.getElementById("patientName").value;
	    var hinNo=document.getElementById("uhid").value;
	    var parkFlag=document.getElementById("parkFlag").value;
	    var searchFlag=document.getElementById("searchFlag").value;
	   // alert("tokenNo "+tokenNo+" pName "+pName+" hinNo "+hinNo);
	   if(parkFlag=='p'){
		   submitProtoAjaxWithDivName('opWaitingList','/hms/hms/opd?method=getOPWaitingListRefresh&flag=p&newOPD=yes','test');
	   }else{
		   submitProtoAjaxWithDivName('opWaitingList','/hms/hms/opd?method=getOPWaitingListRefresh&searchFlag='+searchFlag+'&tokenNo='+tokenNo+'&patientName='+pName+'&uhid='+hinNo+'&newOPD=yes','test');  
	   }
		setTimeout(callWaitingList, 30000);
	}
	
	//setInterval(callWaitingList(), 10000);
	
	function searchKeyPress(e) {
		// look for window.event in case event isn't passed in
		e = e || window.event;
		if (e.keyCode == 13) {
			document.getElementById('search').click();
			return false;
		}
		return true;
	}
	
	function showParkPatient(status) {
		document.getElementById("parkFlag").value='p';
		/*submitForm('opWaitingList','/hms/hms/opd?method=getOPClinicalWaitingList&flag=p');*/		
		document.opd_OP_Clinic_Waiting_PatientList_new_detail.action = "/hms/hms/opd?method=showNewOPDetailWaitingList&flag="
			+ status+'&opdType=opdDeatail';
	document.opd_OP_Clinic_Waiting_PatientList_new_detail.submit();
	}
	
	
	function bookCounterForDoctor(){
		var e = document.getElementById("counterId");
		var userId = document.getElementById("userId").value;
		var counterId = e.options[e.selectedIndex].value;
		var action = "/hms/hms/opd?method=bookCounterForDoctor&counterId="+counterId+"&userId="+userId;
		if(counterId!='0')
			submitProtoAjax('opd_OP_Clinic_Waiting_PatientList_new_detail', action);
	}
	
	function checkForCounter(){
		if(document.getElementById("counterFlag")){
		var counterFlag = document.getElementById("counterFlag").value;
		if(counterFlag=='y'){
			var e = document.getElementById("counterId");
			var counterId = e.options[e.selectedIndex].value;
			if(counterId=='0'){
				alert("Please select counter first !");
				return false;
			}else{
				return true;
			}
		}else{
			return true;
		}
		return true;
		}else{
			return true;
		}
		return true;
	}
	
   function transferToCommonPool(employeeId,page){
	   
	   var opCounter=document.getElementById("counterId").value;
		 if(opCounter=="0"){
			 alert("Please Select Op Counter !");
			 return;
			 }
		
		 var url="/hms/hms/opd?method=showPlannedLeaveCommonPoolJsp&fromScreen=opd_OP_Clinic_Waiting_PatientList_new_detail&"+csrfTokenName+"="+csrfTokenValue;
		 newwindow=window.open(url,"Common Pool","left=150,top=100,height=130,width=1050,status=1,scrollbars=1,resizable=0");
		 
 }
	
	function openTransferPatient(){
		var hospitalId=document.getElementById("hospitalId").value;
		var deptId=document.getElementById("deptId").value;
		var docId="<%=employeeId%>";
		
		 var url="/hms/hms/registration?method=showTransferPatientListJsp&hospitalId=" + hospitalId + '&'+ csrfTokenName + '=' + csrfTokenValue +'&deptId='+deptId+'&docId='+docId+'&&forTransferPatients=yes';
		 newwindow=window.open(url,"Transfer Patient","left=150,top=100,height=550,width=1050,status=1,scrollbars=1,resizable=0");
	}

	function stopRegistration()
	{
		if(confirm("Are You sure, You want to stop your registration for rest of the day?"))
			submitForm('opd_OP_Clinic_Waiting_PatientList_new_detail','/hms/hms/opd?method=setVisitUptoTimeOfDoctor');
		else
			return false;
		
	}
</script>

<%patientList=null;%>

<style>
.cmnTable table th {height:14px; line-height:14px;}
.cmnTable table td {height:20px; line-height:20px;padding:2px 0px 1px 4px;}
.cmnTable table td select{height:20px;}
</style>

