<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : deliveryDetailsSearch.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 07.03.2009    Name: Tej
	 * Revision Date:      Revision By:
	 * @version 1.0

--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<form name="deliveryDetailsSearch" action="" method="post"><script
	type="">
		function checkValidation(){
		if(document.getElementById('wardId').value==0 && document.getElementById('adNo').value=="" && document.getElementById('hinNo').value ==""){
			alert("Fill value any one of the field")
			return false;
			}else{
			return true
}

		}

	</script> <%

		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();
		List<MasDepartment> wardList = new ArrayList<MasDepartment>();

		List<Inpatient> inpatientList = new ArrayList<Inpatient>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}
		if(map.get("wardList") != null){
			wardList= (List<MasDepartment>)map.get("wardList");
		}
		if(patientMap.get("inpatientList") != null){
			inpatientList= (List<Inpatient>)patientMap.get("inpatientList");
		}
		String message = "";
		if(map.get("message") != null){
			message= (String)map.get("message");
		}
	%> <script type="text/javascript">
	<%
		if(!message.equals("")){
			%>
			var msg = "<%=message%>";
			alert(msg);

		<%}
	%>
</script>
<div class="titleBg">
<h2>Patient Search</h2>
</div>
<div class="clear"></div>
<div class="Block"><%--
  			<label class="bodytextB1">Service No:</label>
			<input type="text" name="<%=SERVICE_NO %>" value="" style="width: 100px" class="textbox_size20" MAXLENGTH="20" />
 --%> <label><%=prop.getProperty("com.jkt.hms.ipd_no")%></label> <input type="text" name="<%=AD_NO %>"
	value="" MAXLENGTH="30" id="adNo" /> <label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <input
	type="text" name="<%=HIN_NO %>" value="" MAXLENGTH="50" id="hinNo" />
<label>Ward </label> <select name="<%=WARD_ID %>" id="wardId">
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
</div>


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Search" id="addbutton" onclick="if(checkValidation()){submitForm('deliveryDetailsSearch','/hms/hms/mis?method=searchDeliveryDetails');}"	value="Search" class="button" accesskey="a" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%String msg ="";
for(Inpatient inpatient2:inpatientList){
	if(inpatient2.getAdStatus().equals("W")){
		msg=inpatient2.getHin().getPFirstName()+" "+inpatient2.getHin().getPMiddleName()+" "+inpatient2.getHin().getPLastName()+" ("+inpatient2.getHin().getRelation().getRelationName()+" of "+inpatient2.getHin().getRank().getRankName()+" "+inpatient2.getHin().getSFirstName()+" "+inpatient2.getHin().getSMiddleName()+" "+inpatient2.getHin().getSLastName()+") Admitted (But not Acknowledged)  ";
	%>
<h5><%=msg%></h5>
<%}} %>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="patientDeliveryDetails" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 <script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1,"hin"], [2,"a&dNo"], [3,"patName"],  [4,"ward"],  [5,"age"]];
	 statusTd = 5;
	</script></form>
<div class="clear"></div>
<script type="text/javascript" language="javascript">
 	data_header = new Array();

 	data_header[0] = new Array;
	data_header[0][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[0][1] = "data";
	data_header[0][2] = "15%";
	data_header[0][3] = "hin";

	data_header[1] = new Array;
	data_header[1][0] = "<%=prop.getProperty("com.jkt.hms.ipd_no")%>"
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

	data_header[4] = new Array;
	data_header[4][0] = "Age"
	data_header[4][1] = "data";
	data_header[4][2] = "30%";
	data_header[4][3] = "age";

	data_arr = new Array();
	<%

	    int  counter=0;
		if (inpatientList != null && inpatientList.size() > 0) { %>

	<% 	for(Inpatient inpatient : inpatientList){
		if(inpatient.getAdStatus().equals("A")){
		Patient patient = inpatient.getHin();
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= inpatient.getId()%>
			data_arr[<%= counter%>][1] = "<%=patient.getHinNo()%>"
			data_arr[<%= counter%>][2] = "<%=inpatient.getAdNo()%>"
			data_arr[<%= counter%>][3] = "<%=patient.getPFirstName()%> <%=patient.getPLastName()%> "
	<%
		if(inpatient.getDepartment()!= null){
		%>
			data_arr[<%= counter%>][4] = "<%= inpatient.getDepartment().getDepartmentName()%>"
	<%	}else{%>
			data_arr[<%= counter%>][4] = ""
		<%
				} %>
			data_arr[<%= counter%>][5] = "<%=patient.getAge()%> "
		<%	     counter++;
	}//for if
	    	}
		}
	%>

    formName = "patientDeliveryDetails"

	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;

	}

	makeTable(start,end);


	</script>