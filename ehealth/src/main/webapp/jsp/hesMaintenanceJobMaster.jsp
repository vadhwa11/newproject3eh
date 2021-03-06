<%@page import="jkt.hms.masters.business.HesMaintenanceJobMaster"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%
	Map map = new HashMap();
	
	if(request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
	}
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	ArrayList searchCountryList = (ArrayList)map.get("searchCountryList");
		
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
%>

<div class="titleBg">
<h2>Maintenance Job Master</h2>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>

<div class="Block">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">

<input type="radio" name="<%=SELECTED_RADIO%>" value="1" checked="checked" class="radioCheck" tabindex=1 />
<label>Maintenance Type Code:</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" checked="checked" class="radioCheck" />
<label>Maintenance Type Name:</label>
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Maintenance Type Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','hes?method=searchMaintenanceType','checkSearch')" tabindex=1 />
<%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
</div>

<div class="clear"></div>
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>

<% 
		if(searchCountryList != null)
		{
			if(searchCountryList.size()>0)
		 	{
				String strForCode = (String)map.get("workCode");
				String strForCodeDescription = (String)map.get("workName");
				
				if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
				{
%>
				 	<a href="hes?method=showMaintenanceJobMasterJsp">Show All Records</a> <%
				}
		 	}

	 		if(searchCountryList.size()==0 && map.get("search") != null)
	  		{
%>
			 	<a href="hes?method=showMaintenanceJobMasterJsp">Show All Records</a>
<%
     		}
		}
%>

<script type="text/javascript">
	
formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
</script>
</div>

<form name="maintenanceJobMaster" method="post" action="">
<input type="hidden" name="<%= POJO_NAME %>" value="HesMaintenanceJobMaster">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="MaintenanceName">
<input type="hidden" name="title" value="Maintenance Job Master">
<input type="hidden" name="<%=JSP_NAME %>" value=hesMaintenanceJobMaster>
<input type="hidden" name="pojoPropertyCode" value="MaintenanceCode">

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">

<label style="width: 15%"><span>*</span>Maintenance Type Code</label>
<input id="cylinderTId" type="text" name="<%= CODE%>" value="" validate="Maintenance Type Code,string,yes" class="textbox_size20" MAXLENGTH="8" / tabindex=1>
<label style="width: 17%"><span>*</span>Maintenance Type Name:</label>
<input id="cylinderTName" type="text" name="<%= SEARCH_NAME %>" value="" validate="Maintenance Type Name,string,yes" class="textbox_size20" MAXLENGTH="30" / tabindex=2>

<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('maintenanceJobMaster','hes?method=addMaintenanceType');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('maintenanceJobMaster','hes?method=editMaintenanceType')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none" onClick="submitForm('maintenanceJobMaster','hes?method=deleteMaintenanceType&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom">

<label>Changed By</label>
<label class="value"><%=userName%></label>

<label>Changed Date</label>
<label class="value"><%=date%></label>

<label>Changed Time</label>
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>
<div class="paddingTop40"></div>

<script type="text/javascript">

data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Maintenance Type Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Maintenance Type Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
		if(searchCountryList != null)
		{	
			Iterator itr=searchCountryList.iterator();
        	int  counter=0;
        	
        	while(itr.hasNext())
        	{    
        		HesMaintenanceJobMaster  hesWork = (HesMaintenanceJobMaster)itr.next(); 
%>
			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= hesWork.getId()%>
			data_arr[<%= counter%>][1] = "<%=hesWork.getMaintenanceCode()%>"
			data_arr[<%= counter%>][2] = "<%= hesWork.getMaintenanceName()%>"
			data_arr[<%= counter%>][3] = "<%= hesWork.getLastChgBy().getUserName() %>"
			data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(hesWork.getLastChgDate()) %>"
			data_arr[<%= counter%>][5] = "<%= hesWork.getLastChgTime() %>"
<% 
			if(hesWork.getStatus().equals("y"))
			{
%>
				data_arr[<%= counter%>][6] = "Active"
<%			}
			else
			{
%>
				data_arr[<%= counter%>][6] = "InActive"
<%
			}
%>
<%
		     counter++;
        	}
		}
%>

formName = "maintenanceJobMaster"
nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
