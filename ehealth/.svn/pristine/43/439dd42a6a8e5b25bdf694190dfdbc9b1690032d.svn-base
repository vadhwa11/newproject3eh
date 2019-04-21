<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>

<script>
	<%
	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'


	//window.onload =clearUploadDirectory();
	///window.onunload=clearUploadDirectory();

	function clearUploadDirectory()
	{

		submitForm('viewDocuments','opd?method=removeFilesInUploadFolder');
	}
</script>

<%
	String date = "";
	String time = "";
	String userName = "";
	String imageUrl="";
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map")!=null)
	{
		map=(Map)request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<UploadDocuments>patientList=new ArrayList<UploadDocuments>();
	List<UploadDocuments>inpatientList=new ArrayList<UploadDocuments>();
	List<Visit>visitList=new ArrayList<Visit>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
 	if(map.get("imageUrl")!=null)
 	{
 		imageUrl=(String)map.get("imageUrl");
 	}

  	//Map map = new HashMap();
	String message = null;


	if(map.get("message") != null){
		 message = (String)map.get("message");
		%>

<h4><span><%=message %></span></h4>


<%

	}

	if (session.getAttribute("hospitalId") != null)
	{
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}

	if (session.getAttribute("deptId") != null)
	{
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
	if(map.get("patientList")!=null)
	{
		patientList=(List<UploadDocuments>)map.get("patientList");
	}
	if(map.get("inpatientList")!=null)
	{
		inpatientList=(List<UploadDocuments>)map.get("inpatientList");
	}
	Inpatient inpatient=null;
	
	if(map.get("inpatient")!=null)
	{
		inpatient=(Inpatient)map.get("inpatient");
	}


%>

<!--Main div starts-->
<div class="titleBg">
<h2> View Documents</h2>
</div>
<div class="clear"></div>
<form name="viewDocuments" method="post" enctype="multipart/form-data">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<input type="hidden" name="flag" value="view" id="flag">
<div class="clear"></div>

<div class="Block">
<input type="hidden" name="hospitalId" size="5"	value="<%=hospitalId%>" />
<input type="hidden" name="deptId" size="5"	value="<%=deptId%>" />
<input type="hidden" name="date" size="5"	value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_BY%>"	value="<%=userName%>" readonly="readonly"	MAXLENGTH="8" tabindex=3 />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"	readonly="readonly" tabindex=3 />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" readonly="readonly" tabindex=3 />
<div class="clear"></div>

<h4>Patient Details </h4>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<%

if(inpatient!=null)
{
	session.setAttribute("inpatient",inpatient);
%>

<%@include file="PatientDetails.jsp" %>
<%} %>


<div class="clear"></div>
</div>
<div class="clear"></div>


<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th>S.No.</th>
		<th>Files</th>
		<th>Description</th>
	</tr>
	<%if(inpatientList!=null && inpatientList.size()>0){
		for(int i=0;i<inpatientList.size();i++){
	%>
	<tr>
		<td><%=i+1 %></td>
		<td><a
			href="opd?method=viewPatientDocuments&<%=HIN_NO %>=<%=inpatient.getHin().getHinNo() %>&filename=<%=inpatientList.get(i).getFileName()%>.<%=inpatientList.get(i).getFileExtension()%>&csrfTokenName=csrfTokenValue"><%=inpatientList.get(i).getFileName()%>.<%=inpatientList.get(i).getFileExtension()%>
		</a></td>
		<%if(inpatientList.get(i).getDescription()!=null){ %>
		<td><%=inpatientList.get(i).getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%		}
		}
	%>
	<%if(patientList!=null && patientList.size()>0){
		for(int i=0;i<patientList.size();i++){
	%>
	<tr>
		<td><%=i+1 %></td>
		<td><a
			href="opd?method=viewPatientDocuments&<%=HIN_NO %>=<%=inpatient.getHin().getHinNo() %>&filename=<%=patientList.get(i).getFileName()%>.<%=patientList.get(i).getFileExtension()%>&csrfTokenName=csrfTokenValue">
		<%=patientList.get(i).getFileName()%>.<%=patientList.get(i).getFileExtension()%>
		</a></td>
		<%if(patientList.get(i).getDescription()!=null){ %>
		<td><%=patientList.get(i).getDescription()%></td>
		<%}else{%>
		<td>-</td>
		<%} %>
	</tr>
	<%		}
		}%>
</table>

<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>

<input name="" type="button" class="button"	value="Back" onClick="history.back();" />
<div class="clear"></div>
	</form>

<!--Main div starts-->
 
 
 
 
 
 




<!--Main div starts-->
