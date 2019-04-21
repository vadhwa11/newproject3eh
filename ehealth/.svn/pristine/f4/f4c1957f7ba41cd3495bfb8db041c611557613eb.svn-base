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

<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasRelation"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
-->
</script>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	List<Inpatient> inpatientList =new ArrayList<Inpatient>();
	
	
	if(map.get("inpatientList") != null){
		inpatientList = (List<Inpatient>)map.get("inpatientList");
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
<h2>Today Admission</h2>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="viewAdmission" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="button" value="Back" class="button"
	onClick="submitForm('viewAdmission','commandent?method=showBedStateJsp');"
	accesskey="a" tabindex=1 /></form>



<script type="text/javascript">
 
 formFields = [
	[0, "<%= COMMON_ID%>", "id"], [1,"<%=AD_NO%>"], [2,"<%=SERVICE_NO%>"], [3,"<%= RANK %>"], [4,"<%=S_FIRST_NAME%>"],[5,"<%= TRADE_ID %>"],[6,"<%=RR_NO%>"],[7,"<%=PATIENT_NAME%>"],[8,"<%=WARD_ID%>"],[9,"<%=DATE%>"],[10,"<%=TIME%>"],[11,"<%=NEXT_OF_KIN_NAME%>"],[12,"<%=NEXT_OF_KIN_RELATION_ID%>"],[13,"<%= AGE%>"],[14,"<%= ICD_ID%>"],[15,"<%= UNIT_ID%>"]];
  statusTd = 15;
 </script></div>
<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "<%=prop.getProperty("com.jkt.hms.ipd_no")%>"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%=AD_NO%>"

data_header[1] = new Array;
data_header[1][0] = "Service No"
data_header[1][1] = "hide";
data_header[1][2] = "10%";
data_header[1][3] = "<%=SERVICE_NO%>"

data_header[2] = new Array;
data_header[2][0] = "Rank"
data_header[2][1] = "hide";
data_header[2][2] = "10%";
data_header[2][3] = "<%= RANK %>"

data_header[3] = new Array;
data_header[3][0] = "Name"
data_header[3][1] = "hide";
data_header[3][2] = "10%";
data_header[3][3] = "<%=S_FIRST_NAME%>"

data_header[4] = new Array;
data_header[4][0] = "Trade"
data_header[4][1] = "hide";
data_header[4][2] = "10%";
data_header[4][3] = "<%= TRADE_ID%>"

data_header[5] = new Array;
data_header[5][0] = "Relation Name"
data_header[5][1] = "hide";
data_header[5][2] = "10%";
data_header[5][3] = "<%=RR_NO%>"

data_header[6] = new Array;
data_header[6][0] = "Patient Name"
data_header[6][1] = "data";
data_header[6][2] = "10%";
data_header[6][3] = "<%= PATIENT_NAME %>"

data_header[7] = new Array;
data_header[7][0] = "Ward"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%= WARD_ID %>"

data_header[8] = new Array;
data_header[8][0] = "<%=prop.getProperty("com.jkt.hms.ipd_date")%>"
data_header[8][1] = "data";
data_header[8][2] = "10%";
data_header[8][3] = "<%= DATE %>"

data_header[9] = new Array;
data_header[9][0] = "<%=prop.getProperty("com.jkt.hms.ipd_time")%>"
data_header[9][1] = "data";
data_header[9][2] = "10%";
data_header[9][3] = "<%= TIME %>"


data_header[10] = new Array;
data_header[10][0] = "Relative Name"
data_header[10][1] = "data";
data_header[10][2] = "40%";
data_header[10][3] = "<%= NEXT_OF_KIN_NAME %>"

data_header[11] = new Array;
data_header[11][0] = "Relation"
data_header[11][1] = "data";
data_header[11][2] = "40%";
data_header[11][3] = "<%= NEXT_OF_KIN_RELATION_ID %>"


data_header[12] = new Array;
data_header[12][0] = "Age"
data_header[12][1] = "data";
data_header[12][2] = "15%";
data_header[12][3] = "<%= AGE%>"

data_header[13] = new Array;
data_header[13][0] = "Present diagnosis"
data_header[13][1] = "data";
data_header[13][2] = "40%";
data_header[13][3] = "<%=ICD_ID%>"

data_header[14] = new Array;
data_header[14][0] = "Unit name"
data_header[14][1] = "hide";
data_header[14][2] = "40%";
data_header[14][3] = "<%= UNIT_ID%>"



data_arr = new Array();
<%
Iterator itr=inpatientList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             Inpatient  inpatient = (Inpatient)itr.next(); 
             Patient patient = (Patient)inpatient.getHin();
             MasDepartment masDepartment = (MasDepartment)inpatient.getDepartment();
             MasIcd masIcd = (MasIcd)inpatient.getDiagnosis();
            // MasRelation masRelation = (MasRelation)patient.getRelation();
            // MasTrade masTrade =(MasTrade)patient.getTrade();
            // MasRank masRank = (MasRank)patient.getRank();
             MasRelation nextOfKinRelation = (MasRelation)patient.getNextOfKinRelation();
           //  MasUnit masUnit = (MasUnit)patient.getUnit();
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] ="<%= inpatient.getId()%>"
data_arr[<%= counter%>][1] ="<%= inpatient.getAdNo()%>"
data_arr[<%= counter%>][2] = ""
data_arr[<%= counter%>][3] = ""
data_arr[<%= counter%>][4] = ""
data_arr[<%= counter%>][5] = ""
data_arr[<%= counter%>][6] = ""
<%if(patient.getPFirstName() != null && !patient.getPFirstName().equals("")){
	String pName="";
	pName=patient.getPFirstName();
	if(patient.getPMiddleName()!=null){
		pName+=" "+patient.getPMiddleName();
	}
	if(patient.getPLastName()!=null){
		pName+=" "+patient.getPLastName();
	}
%>
data_arr[<%= counter%>][7] = "<%= pName%>"
<%}else{%>
data_arr[<%= counter%>][7] = ""
<%}if(masDepartment.getDepartmentName() != null && !masDepartment.getDepartmentName().equals("")){
%>
data_arr[<%= counter%>][8] = "<%= masDepartment.getDepartmentName()%>"
<%}else{%>
data_arr[<%= counter%>][8] = ""
<%}%>
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(inpatient.getDateOfAddmission()) %>"
data_arr[<%= counter%>][10] = "<%= inpatient.getTimeOfAddmission()%>"
<%	if(patient.getNextOfKinName() != null && !patient.getNextOfKinName().equals("")){
%>
data_arr[<%= counter%>][11] = "<%= patient.getNextOfKinName()%>"
<%}else{
%>
data_arr[<%= counter%>][11] = ""
<%	}
if(nextOfKinRelation!=null && nextOfKinRelation.getRelationName() != null && !nextOfKinRelation.getRelationName().equals("")){
%>
data_arr[<%= counter%>][12] = "<%= nextOfKinRelation.getRelationName()%>"
<%}else{%>
data_arr[<%= counter%>][12] = ""
<%}
if(inpatient.getAge() != null && !inpatient.getAge().equals("")){
%>
data_arr[<%= counter%>][13] = "<%= inpatient.getAge()%>"
<% }else{%>
	data_arr[<%= counter%>][13] = ""


<%}
if(masIcd!=null && masIcd.getIcdName() != null && !masIcd.getIcdName().equals("")){
%>
data_arr[<%= counter%>][14] = "<%= masIcd.getIcdName()%>"
<% }else{%>
	data_arr[<%= counter%>][14] = ""


<%}%>
data_arr[<%= counter%>][15] = ""

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

