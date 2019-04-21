
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasStoreFinancial"%>
<%@page import="jkt.hms.masters.business.StoreAnnualIndentSetup"%>
<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
		month1="0"+month1;
		}
		if(date1.length()<2){
		date1="0"+date1;
		}
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>'
	</script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>	
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasStoreFinancial> masStoreFinancialList = new ArrayList<MasStoreFinancial>();
	List<StoreAnnualIndentSetup> storeAnnualIndentSetupList = new ArrayList<StoreAnnualIndentSetup>();
	
	if(map.get("masStoreFinancialList")!=null){
		masStoreFinancialList = (List<MasStoreFinancial>)map.get("masStoreFinancialList");
	}
	
	if(map.get("storeAnnualIndentSetupList")!=null){
		storeAnnualIndentSetupList = (List<StoreAnnualIndentSetup>)map.get("storeAnnualIndentSetupList");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int userId =0;
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
	}
	int hospitalId =0;
	if(session.getAttribute("hospitalId") != null){
		hospitalId = (Integer)session.getAttribute("hospitalId");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
	%>
	
<h4><%=message %></h4>
		<%  }
 %>
 

<div class="titleBg">
<h2>Annual Indent Creation Admin Set Up</h2>
</div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="clear"></div>
<div class="Block">

<label>Financial Year</label>
<select name="<%=FINANCIAL_ID %>" id="<%=FINANCIAL_ID %>" >
<option value="0">Select</option>
<%
	if(masStoreFinancialList.size()>0){
		for(MasStoreFinancial f : masStoreFinancialList){
	%>
	<option value="<%=f.getId() %>"><%=f.getFinancialYear() %></option>
		<%}
	}
%>
</select>
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','stores?method=searchAnnualIndentAdminSetup')" tabindex=1 /> 
<input type="reset" name ="add" id="reset" value ="Generate Report" class="buttonBig" onclick="submitForm('search','stores?method=generateReportForGeneralMasters');" accesskey="r"  tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_depot_unit" validate="jasperFileName,metachar,no"/> 
</div>	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
	if(map.get("search") != null)
	  {
	 %> <h4><a href="stores?method=showAnnualIndentAdminSetupJsp">Show All Records</a></h4> <%
    }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= FINANCIAL_ID%>"], [2,"<%= FROM_DATE %>"],[3,"<%= TO_DATE %>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>
	<div class="clear paddingTop15"></div>
<form name="annualIndentAdminSetUp" method="post" action="">
<div class="Block">
<label>Financial Year <span>*</span> </label> 
<select name="<%=FINANCIAL_ID %>" validate="Financial Year,string,yes">
<option value="0">Select</option>
<%
	if(masStoreFinancialList.size()>0){
		for(MasStoreFinancial f : masStoreFinancialList){
	%>
	<option value="<%=f.getId() %>"><%=f.getFinancialYear() %></option>
		<%}
	}
%>
</select>
 <label>From Date</label>
<input type="text" name="<%=FROM_DATE %>" value="<%=date %>" readonly="readonly" class="date"  validate="fromDate,date,no"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.annualIndentAdminSetUp.<%= FROM_DATE%>,event)" />
	

<label>To Date</label>
<input type="text" name="<%=TO_DATE %>" value="<%=date %>" readonly="readonly" class="date"  validate="toDate,date,no"/>
 <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender" tabindex="1"	onClick="setdate('<%=date%>',document.annualIndentAdminSetUp.<%= TO_DATE%>,event)" />
	
 <script>
				document.annualIndentAdminSetUp.<%=FINANCIAL_ID%>.focus();
			</script> <br />

</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button"	onClick="submitForm('annualIndentAdminSetUp','stores?method=addAnnualIndentAdminSetup');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none"	onClick="submitForm('annualIndentAdminSetUp','stores?method=updateAnnualIndentAdminSetup')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none"	onClick="submitForm('annualIndentAdminSetUp','stores?method=deleteAnnualIndentAdminSetup&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="submitFormForButton('search','stores?method=showAnnualIndentAdminSetupJsp')" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" validate="status,metachar,no"/> 
<input	type="hidden" name="<%= COMMON_ID%>" value="" validate="commonId,int,no"/>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName %></label>

<label>Changed Date:</label>
<label class="value"><%=date %></label>

<label>Changed Time:</label>
<label class="value"><%=time %></label>
<input type="hidden" name="<%=USER_ID%>" value="<%=userId%>" /> 
<input type="hidden" name="<%=HOSPITAL_ID%>" value="<%=hospitalId%>" validate="hospitalId,int,no"/>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div id="edited"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Financial Year"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= FINANCIAL_ID%>"


data_header[1] = new Array;
data_header[1][0] = "From Date"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= FROM_DATE %>";

data_header[2] = new Array;
data_header[2][0] = "To Date"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= TO_DATE %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "0";
data_header[5][3] = "<%= CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";
data_arr = new Array();

<%
          int  counter=0;
         for(StoreAnnualIndentSetup annualIndentAdminSetUp :storeAnnualIndentSetupList){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= annualIndentAdminSetUp.getId()%>"
	<%
	for(MasStoreFinancial a : masStoreFinancialList){
		 if(annualIndentAdminSetUp.getFinancialYear().getId().equals(a.getId()) && a.getStatus().equals("y")){ 
			 %>
			data_arr[<%= counter%>][1] = "<%=a.getFinancialYear()%>"
		<%}else if(annualIndentAdminSetUp.getFinancialYear().getId().equals(a.getId()) && a.getStatus().equals("n")){%>
			data_arr[<%= counter%>][1] = "<span>*</span>Parent InActivated--<%=a.getFinancialYear()%>";
			
		<%}
}%>
data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(annualIndentAdminSetUp.getFromDate()) %>"
	data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(annualIndentAdminSetUp.getToDate()) %>"
data_arr[<%= counter%>][4] = "<%= annualIndentAdminSetUp.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(annualIndentAdminSetUp.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= annualIndentAdminSetUp.getLastChgTime() %>"

<% if(annualIndentAdminSetUp.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "annualIndentAdminSetUp"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
