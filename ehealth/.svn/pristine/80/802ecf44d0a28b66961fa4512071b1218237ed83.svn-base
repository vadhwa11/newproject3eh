<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasDisposedTo"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Visit"%>



<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css"></link>
<div id="show"><script type="text/javascript"
	language="javascript">
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
		serverdate = '<%=date + "/" + month + "/" + year%>'
	</script> <script type="text/javascript">
		function checkLD()
		{
		
		}
	</script> <%
		String userName = "";
		if (session.getAttribute("userName") != null) {
			userName = (String) session.getAttribute("userName");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String currenDate = (String) utilMap.get("currentDate");
		String time = (String) utilMap.get("currentTime");

		Map<String, Object> map = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}

		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasDisposedTo> disposalList = new ArrayList<MasDisposedTo>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Visit> visitList = new ArrayList<Visit>();
		Date toDate = null;
		Date fromDate = null;
		String category = null;

		if (map.get("rankCategoryList") != null) {
			rankCategoryList = (List<MasRankCategory>) map
					.get("rankCategoryList");
		}
		if (map.get("disposalList") != null) {
			disposalList = (List<MasDisposedTo>) map.get("disposalList");
		}
		if (map.get("patientList") != null) {
			patientList = (List<Patient>) map.get("patientList");
		}
		if (map.get("showList") != null) {
			visitList = (List<Visit>) map.get("showList");
		}
		if (map.get("toDate") != null) {
			toDate = (Date) map.get("toDate");
		}
		if (map.get("fromDate") != null) {
			fromDate = (Date) map.get("fromDate");
		}
		if (map.get("category") != null) {
			category = (String) map.get("category");
		}

		if (map.get("message") != null) {
			String message = (String) map.get("message");
	%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message%>
</div>
</div>
<%
		}
	%> <jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript">
		
				formFields = [
					[0, "<%=VISIT_ID%>", "id"],[1,"<%=VISIT_NUMBER%>"],[2,"<%=VISIT_DATE%>"],[3, "<%=SERVICE_NO%>", "id"],[4, "<%=RANK_ID%>", "id"], [5,"<%=PATIENT_NAME%>"], [6,"<%=TRADE_ID%>"],[7,"<%=AGE%>"],[8,"<%=UNIT_NAME%>"],[9,"<%=NO_OF_DAYS%>"],[10,"<%=DATE_OF_ED%>"],[11,"<%=DISPOSAL_ID%>"],[12,"<%=STATUS%>"] ];
		 			statusTd = 12;
		 			
				</script></div>
<br />
<form name="EDReturns">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="hidden" name="<%=POJO_NAME%>"
	value="Visit" /> <input type="hidden" name="<%=POJO_PROPERTY_NAME%>"
	value="VisitNo" /> <input type="hidden" name="title" value="EDReturns" />
<input type="hidden" name="<%=JSP_NAME%>" value="EDReturns" /> <input
	type="hidden" name="pojoPropertyCode" value="VisitNo" /> <input
	type="hidden" name="<%=VISIT_NUMBER%>" value="" class="textbox_size20"
	validate="Visit No. , number,no" MAXLENGTH="20" readonly="readonly" />
<%
			if (visitList.size() > 0) {
		%> <label class="bodytextB"> <font id="error">*</font>Start
Date: </label> <input type="text" id="edDate" name="<%=DATE_OF_ED%>"
	title="ED Date" value="" class="textbox_size20" validate="Date of ED,"
	MAXLENGTH="30" readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currenDate%>',document.EDReturns.<%=DATE_OF_ED%>,event)" />

<label class="bodytextB"> <font id="error">*</font> No. of Days
</label> <input type="text" id="edDays" name="<%=NO_OF_DAYS%>" value=""
	class="textbox_size20" validate="No. of days , number,no" MAXLENGTH="5"
	onblur="addDays();" /> <!-- <label class="bodytextB">Date of LD: </label>
				<input type="text" id="ldDate" name="<%//=DATE_OF_LD%>" title="ED Date" value="" class="textbox_size20"  validate="Date of ED," MAXLENGTH="30" readonly="readonly"/>
				<a href="javascript:setdate('<%//=currenDate %>',document.EDReturns.<%=DATE_OF_LD%>)">
   				<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" /> 
   				</a>
				<label class="bodytextB"> No. of LD Days</label>
				<input type="text" id="ldDays" name="<%//=NO_OF_LD_DAYS%>" value="" class="textbox_size20" validate="No. of days , number,no" MAXLENGTH="5" onchange="addDays();"/>
				--> <input type="hidden" id="edDate1" name="<%=ED_DATE1%>"
	title="ED Date" value="" class="textbox_size20" MAXLENGTH="30"
	readonly="readonly" /> <input type="hidden" id="edDate2"
	name="<%=ED_DATE2%>" title="ED Date" value="" class="textbox_size20"
	MAXLENGTH="30" readonly="readonly" /> <input type="hidden"
	id="edDate3" name="<%=ED_DATE3%>" title="ED Date" value=""
	class="textbox_size20" MAXLENGTH="30" readonly="readonly" /> <label
	class="bodytextB"> <font id="error">*</font>Disposal: </label> <select
	id="edDispose" name="<%=DISPOSAL_NAME%>" validate="Disposal,string,yes"
	onchange="addDays();" onblur="addDays();">
	<option value="0">Select</option>
	<option value="ED">ED</option>
	<option value="LD">LD</option>
	<option value="MD">MD</option>
	<option value="SIQ">SIQ</option>
	<option value="DUTY">DUTY</option>
</select> <label class="bodytextB"> Diagnosis: </label> <input type="text"
	id="<%=DIAGNOSIS_ID%>" name="<%=DIAGNOSIS_ID%>" value="" /> <br />
<div id="edited"></div>
<label> &nbsp; </label> <input type="hidden" id="visitId"
	name="<%=VISIT_ID%>" value="" /> <input type="hidden" name="add"
	id="addbutton" value="Add" class="button"
	onClick="submitForm('EDDetails','generalMaster?method=addOccupation');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Submit" class="button"
	onClick="submitEDReturns('EDDetails','submitEdReturnForm')"
	accesskey="u" tabindex=1 /> <input type="hidden" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('EDDetails','generalMaster?method=deleteOccupation')"
	accesskey="d" tabindex=1 /> <input type="hidden" name="Reset"
	value="Reset" class="buttonHighlight" onclick="location.reload();"
	accesskey="r" /> <input type="hidden" name="<%=STATUS%>" value="" />
<%
			}
		%>
</form>
<script type="text/javascript">
				data_header = new Array();
				
				data_header[0] = new Array;
				data_header[0][0] = "Visit No."
				data_header[0][1] = "data";
				data_header[0][2] = "10%";
				data_header[0][3] = "<%=VISIT_NUMBER%>";
				
				data_header[1] = new Array;
				data_header[1][0] = "Visit Date"
				data_header[1][1] = "data";
				data_header[1][2] = "10%";
				data_header[1][3] = "<%=VISIT_DATE%>";
				
				data_header[2] = new Array;
				data_header[2][0] = "Service No."
				data_header[2][1] = "data";
				data_header[2][2] = "10%";
				data_header[2][3] = "<%=SERVICE_NO%>"
				
				
			  	data_header[3] = new Array;
				data_header[3][0] = "Rank"
				data_header[3][1] = "data";
				data_header[3][2] = "10%";
				data_header[3][3] = "<%=RANK_ID%>"
				
				data_header[4] = new Array;
				data_header[4][0] = "Name"
				data_header[4][1] = "data";
				data_header[4][2] = "40%";
				data_header[4][3] = "<%=PATIENT_NAME%>";
				
				data_header[5] = new Array;
				data_header[5][0] = "Trade"
				data_header[5][1] = "data";
				data_header[5][2] = "10%";
				data_header[5][3] = "<%=TRADE_ID%>";
				
				data_header[6] = new Array;
				data_header[6][0] = "Age"
				data_header[6][1] = "data";
				data_header[6][2] = "10%";
				data_header[6][3] = "<%=AGE%>";
				
				data_header[7] = new Array;
				data_header[7][0] = "Unit"
				data_header[7][1] = "data";
				data_header[7][2] = "8%";
				data_header[7][3] = "<%=UNIT_ID%>";
				
				data_header[8] = new Array;
				data_header[8][0] = "No. of days"
				data_header[8][1] = "hide";
				data_header[8][2] = "12%";
				data_header[8][3] = "<%=NO_OF_DAYS%>";
				
				data_header[9] = new Array;
				data_header[9][0] = "Date of ED"
				data_header[9][1] = "hide";
				data_header[9][2] = "15%";
				data_header[9][3] = "<%=DATE_OF_ED%>";
				
				data_header[10] = new Array;
				data_header[10][0] = "Disposal"
				data_header[10][1] = "hide";
				data_header[10][2] = "13%";
				data_header[10][3] = "<%=DISPOSAL_ID%>";
				
				data_header[11] = new Array;
				data_header[11][0] = "Status"
				data_header[11][1] = "hide";
				data_header[11][2] = "15%";
				data_header[11][3] = "<%=STATUS%>";
				
				
				data_arr = new Array();
				category=document.getElementById('categoryId').value
				<%
				if(visitList!=null){
				int counter=0;
				       for(Visit visit : visitList){
				          
				%>			
						  	data_arr[<%=counter%>] = new Array();
							data_arr[<%=counter%>][0] = <%=visit.getId()%>
							
							data_arr[<%=counter%>][1] = "<%=visit.getVisitNo()%>"
							data_arr[<%=counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(visit
									.getVisitDate())%>"
							
							<%if( visit.getHin()!=null){%>
								data_arr[<%=counter%>][3] = "<%=visit.getHin().getServiceNo()%>"
							<%}else{%>data_arr[<%=counter%>][3] = ""<%}%>
							
							<%if( visit.getHin().getRank()!=null){%>
								data_arr[<%=counter%>][4] = "<%=visit.getHin().getRank().getRankName()%>"
							<%}else{%>data_arr[<%=counter%>][4] = ""<%}%>
							<%if( visit.getHin() !=null){%>
							data_arr[<%=counter%>][5] = "<%=visit.getHin().getPFirstName()%> <%=visit.getHin().getPMiddleName()%> <%=visit.getHin().getPLastName()%>"
							<%}else{%>data_arr[<%=counter%>][5] = ""<%}%>
							
							<%if( visit.getHin().getTrade()!=null){%>
								data_arr[<%=counter%>][6] = "<%=visit.getHin().getTrade()
												.getTradeName()%>"
							<%}else{%>
								data_arr[<%=counter%>][6] = ""
							<%}
							if( visit.getHin().getAge()!=null){%>
								data_arr[<%=counter%>][7] = "<%=visit.getHin().getAge()%>"
							<%}else{%>
								data_arr[<%=counter%>][7] = ""
							<%}%>
							
							<%if( visit.getHin().getUnit()!=null){%>
								
								data_arr[<%=counter%>][8] = "<%=visit.getHin().getUnit().getUnitName()%>"
							<%}
							else{%>
								data_arr[<%=counter%>][8] = ""
							<%}
							if(visit.getEdDays()!=null){
							%>
									data_arr[<%=counter%>][9] = "<%=visit.getEdDays()%>"
							<%}
							else{%>
									data_arr[<%=counter%>][9] = ""
							<%}
							if(visit.getEdStartDate()!=null){
							%>
									data_arr[<%=counter%>][10] = "<%=HMSUtil.convertDateToStringWithoutTime(visit
										.getEdStartDate())%>"
							<%}
							else{%>
									data_arr[<%=counter%>][10] = ""
							<%}
							if(visit.getEdDispose()!=null){
							%>	
										data_arr[<%=counter%>][11] = "<%=visit.getEdDispose()%>"
							<%}
							else{%>
										data_arr[<%=counter%>][11] = ""
							<%}
							if(visit.getEdStatus()!=null){
							%>	
									data_arr[<%=counter%>][12] = "<%=visit.getEdStatus()%>"
							<%}
							else{%>
									data_arr[<%=counter%>][12] = ""
							<%}%>
				<%counter++;}}%>
				formName = "EDReturns"

				start = 0
				if(data_arr.length < rowsPerPage)
					end = data_arr.length;
				else
					end = rowsPerPage;
					
				makeTable(start,end);
				
				intializeHover('searchresulttable', 'TR', ' tableover');		
				</script></div>
