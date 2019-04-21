<%--
* Copyright 2008 JK Technosoft Ltd. All rights reserved.
* Use is subject to license terms.
* showIPDPatientVisit.jsp  
* Purpose of the JSP -  This is for Show IPD Patient Visit.
* @author  Deepti
* @author  Ritu
* Create Date: 04th Feb,2008 
* Revision Date:      
* Revision By:  
* @version 1.4
--%>

<%@ page import="jkt.hms.util.RequestConstants"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.masters.business.Ipdclinical"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>


<%	
Map map = new HashMap();
String includedJsp="";
if(request.getAttribute("map") != null)
{
map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
List inPatientDetailList = new ArrayList();
List ipList = new ArrayList();



try{
if(map.get("inPatientDetailList")!=null)
{
inPatientDetailList=(List)map.get("inPatientDetailList");
session.setAttribute("inPatientDetailList",inPatientDetailList);
}
if(map.get("ipList")!=null)
{
ipList=(List)map.get("ipList");	
}

}catch(Exception e)
{
}
String userName = "";
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
String admissionNumber=null;
if(inPatientDetailList != null)
{
Inpatient inPatientDetail=(Inpatient)inPatientDetailList.get(0);
int hinId=inPatientDetail.getHin().getId();
int inpatientId=inPatientDetail.getId();
String patientName=inPatientDetail.getHin().getPFirstName()+inPatientDetail.getHin().getPMiddleName()+inPatientDetail.getHin().getPLastName();
String consultantName=inPatientDetail.getDoctor().getFirstName()+inPatientDetail.getDoctor().getMiddleName()+inPatientDetail.getDoctor().getLastName();
admissionNumber=inPatientDetail.getAdNo();
session.setAttribute("admissionNumber",admissionNumber);
session.setAttribute("hinId",hinId);
session.setAttribute("inpatientId",inpatientId);
MasDiagnosisConclusion masDiagnosisConclusion=(MasDiagnosisConclusion)inPatientDetail.getDiagnosis();

%>

<div class="clear"></div>
<div class="Block"><label>Pateint Name</label> <label
	class="value"> <%= patientName %></label> <label class="medium">Service
No.</label> <label class="valueMedium"> <%=inPatientDetail.getHin().getServiceNo() %></label>

<label class="medium">IP No.</label> <label class="valueMedium">
<%=inPatientDetail.getAdNo() %></label> <label class="medium">Ward Name</label>
<label class="valueMedium"> <%=inPatientDetail.getDepartment().getDepartmentName() %></label>


<div class="clear"></div>

<label>Age</label> <label class="value"> <%=inPatientDetail.getAge() %></label>

<label class="medium">Sex</label> <label class="valueMedium"> <%=inPatientDetail.getHin().getSex().getAdministrativeSexName() %></label>

<label class="medium">Rank</label> <label class="valueMedium">
1212</label> <label class="medium">Unit</label> <label class="valueMedium">
12345</label>

<div class="clear"></div>

<label>Consultant</label> <label class="value"><%=consultantName %></label>

<label class="medium">Diagnosis</label> <%
if(masDiagnosisConclusion != null )
{
%> <label class="valueAuto"><%=inPatientDetail.getDiagnosis().getDiagnosisConclusionName() %></label>
<%
}else{
%> <label class="valueAuto"></label> <%	
}
%> <%
}
%>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="searchbar">
<h4>Visit Creation</h4>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>

<%
if(map.get("message") != null){
String message = (String)map.get("message");
out.println(message);
}
%>
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="clear"></div>
<form name="ipdPatientVisit" method="post" action="">
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript" language="javascript">

formFields = [
[0, "<%= RequestConstants.IPD_VISIT_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.IPD_VISIT_DATE%>"], [3,"<%= RequestConstants.IPD_VISIT_TIME %>"], [4,"<%= RequestConstants.HIN_NO %>"],[5,"<%= RequestConstants.ADMISSION_NUMBER %>"] ];
statusTd =5;
</script></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="divison"></div>
<div class="clear"></div>
<input type="button" class="button" value="Clinical Details"
	align="left"
	onClick="submitForm('ipdPatientVisit','ipd?method=showClinicalDetailsJsp','validateVisit');" />

<input type="button" class="button" value="Nursing Care" align="left"
	onClick="submitForm('ipdPatientVisit','ipd?method=showNursingDetailsJsp','validateVisit');" />

<input type="button" class="button" value="New" align="left"
	onclick="submitForm('ipdPatientVisit','ipd?method=addIPDPatientVisit');" />

<input type="button" class="button" value="Modify" align="left"
	onclick="" /> <input type="hidden" name="hdb" value="1" id="hdb" />
<div id="edited"></div>
<div id="statusMessage">
<h4></h4>
</div>

<div class="clear"></div>
<div class="divison"></div>
<div class="clear"></div>

<script type="text/javascript" language="javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Radio"
data_header[0][1] = "radio";
data_header[0][2] = "5%";
data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"

data_header[1] = new Array;
data_header[1][0] = "Visit Date"
data_header[1][1] = "data";
data_header[1][2] = "5%";
data_header[1][3] = "<%= RequestConstants.IPD_VISIT_DATE%>"

data_header[2] = new Array;
data_header[2][0] = "Visit Time"
data_header[2][1] = "data";
data_header[2][2] = "5%";
data_header[2][3] = "<%=RequestConstants.IPD_VISIT_TIME %>";

data_header[3] = new Array;
data_header[3][0] = "HIN"
data_header[3][1] = "data";
data_header[3][2] = "5%";
data_header[3][3] = "<%= RequestConstants.HIN_NO %>";

data_header[4] = new Array;
data_header[4][0] = "Admission Number"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=RequestConstants.ADMISSION_NUMBER %>";


data_arr = new Array();

<%

String st="";
Iterator iterator=ipList.iterator();
int  i=0;
while(iterator.hasNext())
{    
Ipdclinical ipdclinical=(Ipdclinical)iterator.next();
// Patient patient=(Patient)ipdclinical.getHin();
String hinNo=ipdclinical.getHin().getHinNo();
Date dateObj=ipdclinical.getIpdvisitdate();
String dateConvert=HMSUtil.changeDateToddMMyyyy(dateObj);


%>

data_arr[<%= i%>] = new Array();

data_arr[<%= i%>][0] =<%=ipdclinical.getId()%>

data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid"  name="parent" value="<%= ipdclinical.getId()%>" id="parent" />'

<%
if(ipdclinical.getIpdvisitdate()!= null )
{
%>
data_arr[<%= i%>][2] = "<%=ipdclinical.getIpdvisitdate()%>"
<%
}else{
%>
data_arr[<%= i%>][2] = ""
<%
}
if(ipdclinical.getIpdvisittime()!= null || ipdclinical.getIpdvisittime()!="")
{
%>
data_arr[<%= i%>][3]="<%=ipdclinical.getIpdvisittime()%>"
<%
}else{
%>
data_arr[<%= i%>][3]=""
<%
}
if(hinNo != null || hinNo !="")
{
%>
data_arr[<%= i%>][4] = "<%=hinNo %>"
<%
}else{
%> 
data_arr[<%= i%>][4] = ""
<%
}if(ipdclinical.getAdNo() != null || ipdclinical.getAdNo() != "")
{
%>
data_arr[<%= i%>][5] = "<%=ipdclinical.getAdNo()%>"
<%
}else{
%>
data_arr[<%= i%>][5] = ""

<% 
}
i++;
}
%>

formName = "ipdPatientVisit"


start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeGrid(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

</div>


</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
</div>
