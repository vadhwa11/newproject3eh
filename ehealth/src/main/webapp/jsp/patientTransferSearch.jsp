<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientTransferSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * @Rework  Date: 21 July 2010    Name: Mukesh Naarayan Singh
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript">
function checkBlankSearch(){
	var errorMsg =""
	errorMsg=document.getElementById("hinNo").value;
	errorMsg=errorMsg+document.getElementById("adNo").value;
	errorMsg=errorMsg+document.getElementById("pFName").value;
	errorMsg=errorMsg+document.getElementById("pMName").value;
	errorMsg=errorMsg+document.getElementById("pLName").value;
	
		if(document.getElementById("wardId").value !=0)
	errorMsg=errorMsg+document.getElementById("wardId").value;
	
	if(errorMsg==""){
		alert("Please fill any one of value...!");
		return false
	}else{
		return true
	}
}
</script> 
<form name="patientTransferSearch" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();
		
		List<Inpatient> inpatientList = new ArrayList<Inpatient>();
		
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("serviceTypeList") != null){
			serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
		}
		if(map.get("rankList") != null){
			rankList= (List<MasRank>)map.get("rankList");
		}
		if(map.get("unitList") != null){
			unitList= (List<MasUnit>)map.get("unitList");
		}
		if(map.get("wardList") != null){
			wardList= (List<MasDepartment>)map.get("wardList");
		}
		if(patientMap.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)patientMap.get("inpatientList");
		}
	%>
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 21 July 2010
 -->
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<div class="titleBg">
<h2>Patient Search</h2>
</div>
<div class="clear"></div>
<div class="Block"><label><%=prop.getProperty("com.jkt.hms.ipd_no") %></label> <input type="text"
	name="<%=AD_NO %>" value="" MAXLENGTH="30" id="adNo" /> 
	<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<input type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50"
	id="hinNo" /> <label>Ward</label> <select name="<%=WARD_ID %>"
	id="wardId">
	<option value="0">Select Ward</option>
	<%
for(MasDepartment masDepartment : wardList)
{
%>
	<option value="<%=masDepartment.getId()%>"><%=masDepartment.getDepartmentName()%></option>
	<%
}
%>
</select>

<div class="clear"></div>

<label>Patient Name</label> <input type="text" name="<%=P_FIRST_NAME %>"
	value="" MAXLENGTH="15" id="pFName" /> <label>Patient Mid Name</label>
<input type="text" name="<%=P_MIDDLE_NAME %>" value="" MAXLENGTH="15"
	id="pMName" /> <label>Patient Last Name</label> <input type="text"
	name="<%=P_LAST_NAME%>" value="" MAXLENGTH="15" id="pLName" />

<div class="clear"></div>
</div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
<div class="clear"></div>
<input type="button" name="Search" id="addbutton"
	onclick="if(checkBlankSearch()){submitForm('patientTransferSearch','/hms/hms/adt?method=searchPatientDetailsForTransfer');}"
	value="Search" class="button" accesskey="a" />

<%String msg ="";
for(Inpatient inpatient2:inpatientList){
	if(inpatient2.getAdStatus().equals("W")){
		msg=inpatient2.getHin().getPFirstName()+" "+inpatient2.getHin().getPMiddleName()+" "+inpatient2.getHin().getPLastName()+" ("+inpatient2.getHin().getRelation().getRelationName()+" of "+inpatient2.getHin().getRank().getRankName()+" "+inpatient2.getHin().getSFirstName()+" "+inpatient2.getHin().getSMiddleName()+" "+inpatient2.getHin().getSLastName()+") Admitted (But not Acknowledged)  ";
	%>
<h2><font id="error"><%=msg%></font></h2>
<%}} %>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="patientTransfer" method="post" action=""><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"servNo"],[2,"hin"], [3,"a&dNo"], [4,"ward"]];
	 statusTd = 4;
</script>
</div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	
	
	data_header[0] = new Array;
	data_header[0][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "hin";
	
	data_header[1] = new Array;
	data_header[1][0] = "<%=prop.getProperty("com.jkt.hms.ipd_no") %>"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "a&dNo";
	
	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patName";
	
	
	
	data_header[3] = new Array;
	data_header[3][0] = "Ward"
	data_header[3][1] = "data";
	data_header[3][2] = "30%";
	data_header[3][3] = "ward";
	
	
	data_arr = new Array();
	<%
		
	    int  counter=0;
		if (inpatientList != null && inpatientList.size() > 0) { %>
	
	<% 	for(Inpatient inpatient : inpatientList){
		if(inpatient.getAdStatus().equals("A")){
		Patient patient = inpatient.getHin();
		String patientName="";
		patientName=patient.getPFirstName();
		if(patient.getPMiddleName()!=null){
			patientName+=" "+patient.getPMiddleName();	
		}
		if(patient.getPLastName()!=null){
			patientName+=" "+patient.getPLastName();	
		}
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= inpatient.getId()%>
			data_arr[<%= counter%>][1] = "<%=patient.getHinNo()%>"
			data_arr[<%= counter%>][2] = "<%=inpatient.getAdNo()%>"
			data_arr[<%= counter%>][3] = "<%=patientName%>"
			
		<%
			if(inpatient.getDepartment()!= null){
			%>
				data_arr[<%= counter%>][4] = "<%= inpatient.getDepartment().getDepartmentName()%>"
		<%	}else{%>
				data_arr[<%= counter%>]4] = ""
			<%
					}
				     counter++;
	}//for if	    	
	}
			}
		%>
		
	
    formName = "patientTransfer"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
	
		
</script>
