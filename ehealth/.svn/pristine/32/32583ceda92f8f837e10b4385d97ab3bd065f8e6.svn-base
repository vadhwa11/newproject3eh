<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * department.jsp  
 * Purpose of the JSP -  This is for Department details 
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/phaseII.css" />



<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />

<div id="contentspace">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentdate = (String)utilMap.get("currentDate");	 
	String currenttime = (String)utilMap.get("currentTime");
	List <OtBooking> otBookingList = new ArrayList<OtBooking>();
	List <MasOt> masOtList = new ArrayList<MasOt>();
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
	if(map.get("otBookingList") != null){
		otBookingList = (List)map.get("otBookingList");
		  }
	if(map.get("masOtList") != null){
		masOtList = (List)map.get("masOtList");
		  }
%>
<h2 align="left" class="style1">OT List Change</h2>

<form name="OtListChange" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><script
	type="text/javascript" language="javascript">
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		String time=String.valueOf(calendar.getTime());
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	</script> <label>Booking Date:</label> <input type="text" id="bookingDate"
	name="bookingDate" value="21/11/2008" MAXLENGTH="30" /> <a
	href="javascript:setdate('<%=currentdate %>',document.OtListChange.bookingDate)">
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender" /> </a> <input type="button"
	name="<%=LOAD_OT_SCHEDULE%>" value="Load All OT Schedule" class="large"
	ID="loadOtSchedule"
	onclick="submitForm('OtListChange','ot?method=getOTSchedule');" /></form>

<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>



<script type="text/javascript">
	
	formFields = [
			[0, "<%= OT_BOOKING_ID%>", "id"], [1,"<%=SR_NO%>"], [2,"<%=OT_NAME%>"], [3,"<%= RELATION_NAME %>"],[4,"<%=SERVICE_NO%>"],  [5,"<%= RANK_NAME%>"], [6,"<%= PATIENT_NAME%>"],[7,"<%=AGE%>"],[8,"<%=UNIT%>"],
			 [9,"<%=DIAGNOSIS_ID%>"],[10,"<%=SURGERY%>"],[11,"<%=ANAE%>"],[12,"<%=WARD_NAME%>"],[13,"<%=DOCTOR_NAME%>"],[14,"<%=STATUS%>"]];
	 statusTd = 14;
	</script></div>
<br />
<form name="OtListChange1" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="<%= POJO_NAME %>" value="OtBooking"><input
	type="hidden" name="title" value="OtListChange"><input
	type="hidden" name="<%=JSP_NAME %>" value="ot_list_change"><br>
<div id=contentoperation><input type="hidden"
	name="<%=OT_BOOKING_ID%>" value="" id="otBookingId" />
<div class="Clear"></div>
<label>Current OT:</label> <input type="text" value=""
	name="<%=OT_NAME%>" id="otName" /> <label>Current S.No.:</label> <input
	type="text" value="" name="<%=SR_NO%>" id="srNo" />
<div class="Clear"></div>

<input type="button" name="<%=LOAD_SL_NO%>" value="Load S.No."
	class="large" id="loadSlNo"
	onclick="submitForm('OtListChange','ot?method=getOTSchedule');" /> <label
	class="bodytextB_blue">Change to OT:</label> <select id="otId"
	name="<%=NEW_OT%>" validate="OT,number,no"
	onchange="checkForAppmtDate()" />
<option value="0">Select</option>
<%
				for (MasOt masOt : masOtList) {
			%>
<option value="<%=masOt.getId()%>"><%=masOt.getOtName()%></option>
<%	
			}
			%> </select> <input id="codeId" type="text" name="<%= NEW_OT%>" value=""
	validate="Sl No. Code,string,yes" class="textbox_size20" MAXLENGTH="8"
	/ tabindex=1><label class="bodytextB_blue">Change Sl.
No To:</label>
<div id="testDiv"><input type="text" name="<%= NEW_SL_NO %>"
	value="" validate="Department,string,yes" class="textbox_size20"
	MAXLENGTH="30" / tabindex=1></div>
<div class="Clear"></div>
<label class="bodytextB_blue">Change Booking Date To:</label> <input
	type="text" name="<%= NEW_BOOKING_DATE%>" value=""
	validate="Department,string,yes" class="textbox_size20" MAXLENGTH="30"
	/ tabindex=1><label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentdate%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=currenttime%>" /></div>

<br />

<div id="edited"></div>
<label>&nbsp;</label> <input type="hidden" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('department','systemRelatedMaster?method=addDepartment');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('department','systemRelatedMaster?method=editDepartment')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('department','systemRelatedMaster?method=deleteDepartment&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="hidden" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" /> <br />
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "S.No."
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%=SR_NO%>"

data_header[1] = new Array;
data_header[1][0] = "OT Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=OT_NAME%>";

data_header[2] = new Array;
data_header[2][0] = "Rel"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%=RELATION_NAME%>";

data_header[3] = new Array;
data_header[3][0] = "Service No."
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%=SERVICE_NO%>";

data_header[4] = new Array;
data_header[4][0] = "Rank"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%=RANK_NAME%>"

data_header[5] = new Array;
data_header[5][0] = "Name"
data_header[5][1] = "data";
data_header[5][2] = 0;
data_header[5][3] = "<%=PATIENT_NAME%>"

data_header[6] = new Array;
data_header[6][0] = "Age(yrs)"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=AGE%>";

data_header[7] = new Array;
data_header[7][0] = "Unit"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=UNIT%>";

data_header[8] = new Array;
data_header[8][0] = "Diagnosis"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=DIAGNOSIS_ID%>";

data_header[9] = new Array;
data_header[9][0] = "Operation"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=SURGERY%>";

data_header[10] = new Array;
data_header[10][0] = "Anae"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=ANAE%>";

data_header[11] = new Array;
data_header[11][0] = "Ward"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%=WARD_NAME%>";

data_header[12] = new Array;
data_header[12][0] = "Surgeon"
data_header[12][1] = "data";
data_header[12][2] = "15%";
data_header[12][3] = "<%=DOCTOR_NAME%>";

data_header[12] = new Array;
data_header[12][0] = "Status"
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=STATUS%>";

data_arr = new Array();

<%if(otBookingList!=null){
Iterator itr=otBookingList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             		OtBooking  otBooking = (OtBooking)itr.next(); 

%>

					data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = <%= otBooking.getId()%>
					data_arr[<%= counter%>][1] = "<%=otBooking.getSlNo()%>"
					data_arr[<%= counter%>][2] = "<%= otBooking.getOt().getOtName()%>"
					data_arr[<%= counter%>][3] = "<%= otBooking.getHin().getRelation().getRelationName() %>"
					data_arr[<%= counter%>][4] = "<%= otBooking.getHin().getServiceNo()%>"
					data_arr[<%= counter%>][5] = "<%= otBooking.getHin().getRank().getRankName()%>"
					data_arr[<%= counter%>][6] = "<%= otBooking.getHin().getPFirstName()%>"
					data_arr[<%= counter%>][7] = "<%= otBooking.getHin().getAge()%>"
					data_arr[<%= counter%>][8] = "<%= otBooking.getHin().getUnit().getUnitName()%>"
					<%if(otBooking.getInpatient()!=null){%>
						data_arr[<%= counter%>][9] = "<%= otBooking.getInpatient().getInitDiagnosis()%>"
					<%}else{%>
						data_arr[<%= counter%>][9] = ""
					<%}%>
					data_arr[<%= counter%>][10] = "<%= otBooking.getChargeCode().getChargeCodeName()%>"
					data_arr[<%= counter%>][11] = ""
					data_arr[<%= counter%>][12] = "<%= otBooking.getDepartment().getDepartmentName()%>"
					data_arr[<%= counter%>][13] = "<%= otBooking.getBookedBy().getFirstName()%>"
					data_arr[<%= counter%>][14] = ""
					<%
							     counter++;
			}//end of WHILE
}//end of IF
%>
 
formName = "OtListChange1"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>