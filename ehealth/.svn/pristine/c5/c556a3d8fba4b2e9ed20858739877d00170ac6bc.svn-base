<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * modifyMmfDepartment.jsp  
 * Purpose of the JSP -  This is for modify MMF Department.
 * @author  Dipali
 * Create Date: 4th April,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.2
--%>

<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>

<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasServiceStatus"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<SilDilStatus> silDilStatusList =new ArrayList<SilDilStatus>();
	
	
	if(map.get("silDilStatusList") != null){
		silDilStatusList = (List<SilDilStatus>)map.get("silDilStatusList");
	}
	

%>
<div class="titleBg">
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );

%>

<h2>Today Patient SIL DIL</h2>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="viewAdmission" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<input type="button" value="Back" class="button"
	onClick="submitForm('viewAdmission','commandent?method=showBedStateJsp');"
	accesskey="a" tabindex=1 />
<div class="clear"></div>
</form>
<div class="clear"></div>
<script type="text/javascript">
 
 
 formFields = [
	[0, "<%= COMMON_ID%>", "id"], [1,"<%=SERVICE_TYPE_NAME%>"], [2,"<%= RANK %>"], [3,"<%=RELATION_ID%>"],[4,"<%= CONDITION_STATUS %>"],[5,"s"],[6,"x"]];
  statusTd = 6;
 </script></div>

<script type="text/javascript">
data_header = new Array();


data_header[0] = new Array;
data_header[0][0] = "<%=prop.getProperty("com.jkt.hms.registration_no")%>"
data_header[0][1] = "data";
data_header[0][2] = "10%";
data_header[0][3] = "<%=SERVICE_TYPE_NAME%>"

data_header[1] = new Array;
data_header[1][0] = "<%=prop.getProperty("com.jkt.hms.ipd_no")%>"
data_header[1][1] = "data";
data_header[1][2] = "10%";
data_header[1][3] = "<%= RANK %>"


data_header[2] = new Array;
data_header[2][0] = "Patient Name"
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "<%= RELATION_ID %>"

data_header[3] = new Array;
data_header[3][0] = "List"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= CONDITION_STATUS %>"

data_header[4] = new Array;
data_header[4][0] = "Ward"
data_header[4][1]="data";
data_header[4][2] = "25%";
data_header[4][3] = "s"

data_header[5] = new Array;
data_header[5][0] = "Bed"
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "x"


data_arr = new Array();
<%
Iterator itr=silDilStatusList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             SilDilStatus  silDilStatus = (SilDilStatus)itr.next();
             Inpatient inpatient = (Inpatient)silDilStatus.getInpatient();
             Patient patient = (Patient)inpatient.getHin();
             String firstName="";
             String middleName="";
             String lastName="";
             if(patient.getPFirstName()!=null){
            	 firstName=patient.getPFirstName();
             }
             if(patient.getPMiddleName()!=null){
            	 middleName=patient.getPMiddleName();
             }
            
             if(patient.getPLastName()!=null){
            	 lastName=patient.getPLastName();
             }
            String name=firstName+" "+middleName+" "+lastName;
            
            
           
            
             
             
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] ="<%= inpatient.getId()%>"
<%if(!patient.getHinNo().equals("")){
	if(patient.getHinNo() != null && !patient.getHinNo().equals("")){
%>
data_arr[<%= counter%>][1] = "<%=patient.getHinNo()%>"
<%}}else{%>
data_arr[<%= counter%>][1] = ""
<%}if(inpatient.getAdNo()!=null){
if(inpatient.getAdNo()!= null && !inpatient.getAdNo().equals("")){
%>
data_arr[<%= counter%>][2] = "<%=inpatient.getAdNo()%>"
<%}}else{%>
data_arr[<%= counter%>][2] = ""
<%}

if( !name.equals("")){
%>
data_arr[<%= counter%>][3] = "<%= name%>"
<%}else{%>
data_arr[<%= counter%>][3] = ""
<%}
if(silDilStatus!=null){
if(silDilStatus.getConditionStatus()!=null)
{
%>
data_arr[<%= counter%>][4] = "<%= silDilStatus.getConditionStatus()%>"
<%
}}
else
{%>
data_arr[<%= counter%>][4] = ""
<%}if(inpatient.getDepartment()!=null){
	if(inpatient.getDepartment()!=null){
%>
data_arr[<%= counter%>][5] = "<%=inpatient.getDepartment().getDepartmentName()%>"
<%}}else{%>
data_arr[<%= counter%>][5] = ""
<%}if(inpatient.getBed()!=null){
	if(inpatient.getBed()!=null){
%>
data_arr[<%= counter%>][6] = "<%=inpatient.getBed().getBedNo()%>"
<%}}else{%>
data_arr[<%= counter%>][6] = ""
<%}%>

<%
counter++;
}
%>
formName = "viewAdmission"
 
start = 0

if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>

