<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasPerineumMaintenance"%>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasPerineumMaintenance> perineumMaintenanceList = new ArrayList<MasPerineumMaintenance>();
	
	String message = "";
	String userName = "";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("perineumMaintenanceList") != null){
		perineumMaintenanceList = (List)map.get("perineumMaintenanceList");
	}
	
	
	if(map.get("message") != null){

	}
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %> 
<div class="titleBg">
<h2>Perineum Maintenance Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label class="auto">Perineum Maintenance Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label class="auto">Perineum Maintenance Description </label> 
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Perineum Maintenance  Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'inPatientMaster?method=searchPerineumMaintenance ')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','inPatientMaster?method=searchPerineumMaintenance ','checkSearch')" tabindex=1 />
<%--- Report Button   
<input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','inPatientMaster?method=generateReportForInPatientMaster');" accesskey="g" tabindex=1/> --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_perineum_maintenance">	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if( perineumMaintenanceList.size() > 0)
		 {
			String strForCode = (String)map.get("perineumMaintenanceCode");
			String strForCodeDescription = (String)map.get("perineumMaintenanceName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="inPatientMaster?method=showPerineumMaintenanceJsp">Show
All Records </a></h4> <%
			}
		 }
	 if(perineumMaintenanceList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="inPatientMaster?method=showPerineumMaintenanceJsp">Show
All Records</a></h4> <%
     }
	%> <script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],  [3,"<%=CHANGED_BY%>"], [4,"<%=CHANGED_DATE%>"],[5,"<%=CHANGED_TIME%>"],[6,"<%=STATUS%>"] ];
	 
		 statusTd = 6;
	</script></div>

<form name="PerineumMaintenance" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="MasPerineumMaintenance">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="PerineumMaintenanceName">
<input type="hidden" name="title" value="PerineumMaintenance"> 
<input type="hidden" name="<%=JSP_NAME %>" value="PerineumMaintenance"> 
<input type="hidden" name="pojoPropertyCode" value="PerineumMaintenanceCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<div class="Outside Treatment">
<label class="auto"><span>*</span> Perineum Maintenance Code </label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="perineum Maintenance Code,string,yes" class="textbox_size20" MAXLENGTH="8" tabindex=1 />
<label class="auto"><span>*</span> Perineum Maintenance Name</label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="perineum Maintenance  Name,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex=1 /> 
<script>
				document.PerineumMaintenance.<%=CODE%>.focus();
			</script>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onclick="submitForm('PerineumMaintenance','inPatientMaster?method=addPerineumMaintenance')"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onclick="submitForm('PerineumMaintenance','inPatientMaster?method=editPerineumMaintenance')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	style="display: none;"
	onclick="submitForm('PerineumMaintenance','inPatientMaster?method=deletePerineumMaintenance&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Perineum Maintenance Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Perineum Maintenance Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";


data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = "Admin"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME%>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";


data_arr = new Array();

<%
Iterator itr=perineumMaintenanceList.iterator();
         
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  MasPerineumMaintenance masPerineumMaintenance = (MasPerineumMaintenance)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masPerineumMaintenance.getId()%>
data_arr[<%= counter%>][1] = "<%=masPerineumMaintenance.getPerineumMaintenanceCode()%>"
data_arr[<%= counter%>][2] = "<%= masPerineumMaintenance.getPerineumMaintenanceName()%>"
	 data_arr[<%= counter%>][3] = "<%= masPerineumMaintenance.getLastChgBy()!=null?(masPerineumMaintenance.getLastChgBy().getId()!=null?masPerineumMaintenance.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masPerineumMaintenance.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masPerineumMaintenance.getLastChgTime() %>"

<% if(masPerineumMaintenance.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "PerineumMaintenance"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
