<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.print.attribute.HashAttributeSet"%>
<%@page import="jkt.hms.masters.business.OpdPatientSecondOpinion"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
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
	List otherNextPatientList = new ArrayList();
	int totalPatient=0;
	if(map.get("patientList") != null)
	{
		patientList=(List)map.get("patientList");
	}
	
	if(map.get("otherNextPatientList") != null)
	{
		otherNextPatientList=(List)map.get("otherNextPatientList");
	}
	
	String lastOpenAt =null;
	long diffMinutes=0L;
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
	
	int searchFlag=0;
	if (map.get("searchFlag") != null) {
		searchFlag = (Integer) map.get("searchFlag");
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
				if(opd.getOpinionDoctor().getMiddleName()!=null){
					name=name+" "+opd.getOpinionDoctor().getMiddleName();
				}
			}
			if(opd.getOpinionDoctor()!=null){
				if(opd.getOpinionDoctor().getLastName()!=null){
					name=name+" "+opd.getOpinionDoctor().getLastName();
				}
			}
			secondOpinionDoc.put(opd.getVisit().getId(), name);
		}
	}
	String flag="";
	if (map.get("flag") != null) {
		flag = (String) map.get("flag");
	}
	
	%>





<%
if(patientList.size()>0)
{
	totalPatient = patientList.size();
	//System.out.println("patientList "+patientList.size());
}%>
<div id="searchresults" tabindex=2>
<div class="cmnTable"  id="searchtable" class="small" tabindex=2>
</div>
</div>

<div class="clear"></div><div class="clear"></div>
<div class="clear"></div><div class="clear"></div>
<div class="clear"></div><div class="clear"></div>
<div class="clear"></div><div class="clear"></div>
<!-- <div class="cmnTable">
---New waiting list table showing here search--
</div> -->
<div id="searchresults1" tabindex=2>
	<div class="cmnTable"  id="searchtable1" class="small" tabindex=2>
	</div>
</div>

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
		if(visit!=null && !visit.getVisitStatus().equalsIgnoreCase("c")  && !visit.getVisitStatus().equalsIgnoreCase("x"))
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
		}else if(patientHin.getAge()!=null) {
			String patientAgeStrArray[]=patientHin.getAge().split("\\s+");
			if(patientAgeStrArray.length==2){
				yearMonth = patientAgeStrArray[0]  +" "+ patientAgeStrArray[1].substring(0, 1);
			}
			
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
		
		if(!yearMonth.equals(""))
		{
		%>
		data_arr[<%= i%>][5] =  "<%=yearMonth%>";
		<%
		}else{
			%>
		data_arr[<%= i%>][5] = "";
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
			data_arr[<%= i%>][9] =''
		<%}%>
		
		var visitid =  <%=visit.getId()%> 
		var tokenNo =  '<%=visit.getTokenNo()%>'
		var releaseButton = "<input type=\"button\" name=\"btn\" id=\"btn\" value=\"Release\" onclick=\"doPatientRelease(\'"+visitid+"\',\'opLite\');\"  />";

	
		 <%-- <%if(visit.getOpCallCount()!=null && visit.getOpCallCount()>=3){%> --%>
		 <%if(visit.getOpCallCount()!=null && visit.getOpCallCount()>=2){%>
		data_arr[<%= i%>][10] = releaseButton;
		<%}else{%>
		data_arr[<%= i%>][10] = "";
		<%}%>		
 
		
		<%--  data_arr[<%= i%>][10] ='<input type="button" name="btn" id="btn" value="Lite" onclick="if(checkForCounter()){openOpdLite(\''+visitid+'\');}" />';
		<%
		
			String detailURL = "submitFormForButton('opd_OP_Clinic_Waiting_PatientList_new','/hms/hms/opd?method=showNewOPDDetailScreen')";
		%>
		 data_arr[<%= i%>][11] ="<input type='button' name='btn' id='btn' value='Detail' onclick='if(checkForCounter()){openDetail("+visitid+")}' />";  --%>
		 
		<%--  data_arr[<%= i%>][10] = ""; --%>
		 <%-- data_arr[<%= i%>][11] = "<select name='skip<%=i%>' id='skip<%=i%>' ><option value='0'>Select</option><option value='E'>Emergency</option></select>"; --%>
		<%--data_arr[<%= i%>][11] ="";--%>
	
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

	formName = "opd_OP_Clinic_Waiting_PatientList_new"
	st=0;
	totRec=<%=patientList.size()%>;
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
	
	
	
	data_arr = new Array();

	<%
	i=1;
	j=1;
	try{
	String st="";
	Iterator iterator=  otherNextPatientList.iterator();
	while(iterator.hasNext())
	{
		
		Visit visit= (Visit) iterator.next();
		if(flag!=null && !flag.equalsIgnoreCase("p") && visit!=null && !visit.getVisitStatus().equalsIgnoreCase("c")  && !visit.getVisitStatus().equalsIgnoreCase("x"))
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
		}else if(patientHin.getAge()!=null) {
			String patientAgeStrArray[]=patientHin.getAge().split("\\s+");
			if(patientAgeStrArray.length==2){
				yearMonth = patientAgeStrArray[0]  +" "+ patientAgeStrArray[1].substring(0, 1);
			}
			
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
		
		if(!yearMonth.equals(""))
		{
		%>
		data_arr[<%= i%>][5] =  "<%=yearMonth%>";
		<%
		}else{
			%>
		data_arr[<%= i%>][5] = "";
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
			data_arr[<%= i%>][9] =''
		<%}%>
		
		var visitid =  <%=visit.getId()%> 
		var tokenNo =  '<%=visit.getTokenNo()%>'
		
	
		 <%-- <%if(visit.getOpCallCount()!=null && visit.getOpCallCount()>=3){%> --%>
		 <%if(visit.getOpCallCount()!=null && visit.getOpCallCount()>=2){%>
		 data_arr[<%= i%>][10] ="<input type='button' name='btn' id='btn' value='Release' onclick='doPatientRelease("+visitid+");'/>";
		<%}else{%>
		data_arr[<%= i%>][10] = "";
		<%}%>		
 		<%-- data_arr[<%= i%>][11] = "<select name='skip<%=i%>' id='skip<%=i%>' ><option value='0'>Select</option><option value='E'>Emergency</option></select>"; --%>
			<%	
		i++;
		}
	  }
	}catch(Exception e){
	e.printStackTrace();
	}
	%>
	
	formName = "opd_OP_Clinic_Waiting_PatientList_new"
		st=0;
		totRec=<%=otherNextPatientList.size()%>;
		start = 1;
		rowsPerPage = 7;
		
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		
		makeGridForNextAllPatients(start,end,'searchtable1');
</script>



