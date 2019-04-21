<%--
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientVisitSearch.jsp
	 * Tables Used         :
	 * Description         :
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By:
	 * @version 1.0

--%>


<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar2.js"></script>

<div class="titleBg">
<h2>In Patient Search</h2>
</div>
<div class="clear"></div>
<form name="search" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> patientMap = new HashMap<String, Object>();

		List<Inpatient> patientList = new ArrayList<Inpatient>();

		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("patientMap") != null){
			patientMap= (Map<String, Object>)map.get("patientMap");
		}

		if(patientMap.get("patientList") != null){
			patientList= (List<Inpatient>)patientMap.get("patientList");

		}
	%>
	<%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %>


<div class="Block">
<input type="hidden" name="<%=SERVICE_NO %>"	value="" MAXLENGTH="20" />
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<input type="text"	name="<%=HIN_NO %>" value="" MAXLENGTH="50" />
<input type="hidden"	name="<%=S_FIRST_NAME %>" value="" MAXLENGTH="15" />
<input	type="hidden" name="<%=S_MIDDLE_NAME %>" value="" MAXLENGTH="15" />
<input	type="hidden" name="<%=S_LAST_NAME%>" value="" 	MAXLENGTH="15" />
<label>Patient First Name</label>
<input	type="text" name="<%=P_FIRST_NAME %>" value="" MAXLENGTH="15" />
<label>Patient Mid Name</label>
<input type="text" name="<%=P_MIDDLE_NAME %>" value=""	MAXLENGTH="15" />
<div class="clear"></div>
<label>Patient Last Name</label>
<input type="text"	name="<%=P_LAST_NAME%>" value=""  MAXLENGTH="15" />
<div class="clear"></div>
</div>
</form>
<div class="clear"></div>
<input type="button" name="Submit" id="addbutton"	onclick="submitForm('search','/hms/hms/opd?method=showPatientDetails');"	value="Search" class="button" accesskey="a" />
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<div class="clear"></div>
<form name="patientSearch" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><script
	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"], [1,"ipno"], [2,"hin"], [3,"patName"], [4,"serviceType"], [5,"sPersonName"], [6,"rank"], [7,"unit"]];
	 statusTd = 7;
	</script>
<div class="clear"></div>
</form>
</div>
<script type="text/javascript" language="javascript">

	data_header = new Array();


	data_header[0] = new Array;
	data_header[0][0] = "<%=prop.getProperty("com.jkt.hms.ipd_no") %>"
	data_header[0][1] = "data";
	data_header[0][2] = "7%";
	data_header[0][3] = "ipno"

	data_header[1] = new Array;
	data_header[1][0] = "<%=prop.getProperty("com.jkt.hms.registration_no") %>"
	data_header[1][1] = "data";
	data_header[1][2] = "15%";
	data_header[1][3] = "hin";

	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "20%";
	data_header[2][3] = "patName";

	data_header[3] = new Array;
	data_header[3][0] = "Service Type"
	data_header[3][1] = "hide";
	data_header[3][2] = "10%";
	data_header[3][3] = "serviceType"

	data_header[4] = new Array;
	data_header[4][0] = "Service Person Name"
	data_header[4][1] = "hide";
	data_header[4][2] = "15%";
	data_header[4][3] = "sPersonName";

	data_header[5] = new Array;
	data_header[5][0] = "Rank"
	data_header[5][1] = "hide";
	data_header[5][2] = "10%";
	data_header[5][3] = "rank";

	data_header[6] = new Array;
	data_header[6][0] = "Unit"
	data_header[6][1] = "hide";
	data_header[6][2] = "10%";
	data_header[6][3] = "unit"




	data_arr = new Array();
	<%

	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>

	<% 	for(Inpatient inpatient : patientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= inpatient.getHin().getId()%>
			data_arr[<%= counter%>][1] = "<%=inpatient.getAdNo()%>"
			data_arr[<%= counter%>][2] = "<%=inpatient.getHin().getHinNo()%>"
			<%
					String middleName = "";
					String lastName = "";
					if(inpatient.getHin().getPMiddleName() != null){
						middleName = inpatient.getHin().getPMiddleName();
					}
					if(inpatient.getHin().getPLastName() != null){
						lastName = inpatient.getHin().getPLastName();
					}

					%>
			data_arr[<%= counter%>][3] = "<%=inpatient.getHin().getPFirstName()%> <%=middleName%> <%=lastName%>"
			<%if(inpatient.getHin().getServiceType()!=null){%>
			data_arr[<%= counter%>][4] = "<%=inpatient.getHin().getServiceType().getServiceTypeName()%> "
			<%}else{%>
				data_arr[<%= counter%>][4] ="";
				<%}%>
			<%
			if(inpatient.getHin().getSFirstName() != null  && !(inpatient.getHin().getSFirstName().equals(""))){

				String sMiddleName = "";
				String sLastName = "";
				if(inpatient.getHin().getSMiddleName() != null){
					sMiddleName = inpatient.getHin().getSMiddleName();
				}
				if(inpatient.getHin().getSLastName() != null){
					sLastName = inpatient.getHin().getSLastName();
				}
				String sName = inpatient.getHin().getSFirstName()+" "+sMiddleName+" "+sLastName;
			%>
				data_arr[<%= counter%>][5] = "<%=sName%>"
				<%}else{%>
				data_arr[<%= counter%>][5] = ""
				<%}
				if(inpatient.getHin().getRank() != null){
				%>
				data_arr[<%= counter%>][6] = "<%=inpatient.getHin().getRank().getRankName()%> "
				<%}else{%>
				data_arr[<%= counter%>][6] = ""
				<%}
				if(inpatient.getHin().getUnit() != null){
				%>
				data_arr[<%= counter%>][7] = "<%=inpatient.getHin().getUnit().getUnitName()%> "
				<%}else{%>
				data_arr[<%= counter%>][7] = ""


		<%
				}
				     counter++;
		    	}
			}
		%>

    formName = "patientSearch"

	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;

	}

	makeTable(start,end);


	</script>
<%
patientList.clear();

%>