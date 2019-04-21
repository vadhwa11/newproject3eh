<%@page import="jkt.hms.masters.business.MasAnalyzerParameter"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%--For AutoComplete Through Ajax--%>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");
String time = (String)utilMap.get("currentTime");
ArrayList searchAnalyzerParameterList = (ArrayList)map.get("searchAnalyzerParameterList");



String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}
if(map.get("message") != null){
	 String  message = (String)map.get("message");
	   %>
	   <h4><span><%=message %></span></h4>
	 <%}

%>
<div class="titleBg">
<h2>Analyzer Parameter</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 

<label>Machine Name </label>
<select name="machineNames" validate="Machine Name,string,no" tabindex=1>
<option value="0">Select</option>
<option value="EM306">EM306</option>
</select>

<input type="radio"	name="<%=SELECTED_RADIO  %>" value="2" class="radiobutMargin" /> 
<label>Parameter Name </label>

<input type="text" tabindex=1 id="parameterNames" name="parameterNames" value="" class="textbox_date" validate="Parameter Name,string,no" MAXLENGTH="30"  />

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','laboratory?method=searchAnalyzerParameter')" tabindex=1 />
<%--- Report Button  --%>
<!-- <input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> -->

</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<%
  if(searchAnalyzerParameterList.size()>0)
   {
   String strForGroupName = (String)map.get("parameterName");
   String strForGroupId = (String)map.get("machineName");
   
    if(strForGroupName!= null && strForGroupName!= "" || strForGroupId!= null && strForGroupId!= ""  )
   {
 %> <h4><a href="laboratory?method=showAnalyzerParameterJsp">Show All Records</a></h4> <%

		  }
	   }
	 if(searchAnalyzerParameterList.size()==0 && map.get("search") != null)
	  {
	 %><h4> <a href="laboratory?method=showAnalyzerParameterJsp">Show All Records</a></h4> <%
    }
	%>
<script type="text/javascript">
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"machineName"], [2,"parameterName"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
  statusTd =6;

 </script></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<form name="otMasChargeDetails" method="post" action="">
<div class="Block">

<label>Machine Name<span>*</span> </label>
<select name="machineName" validate="Machine Name,string,yes" tabindex=1>
<option value="0">Select</option>
<option value="EM306">EM306</option>
</select>

<label>Parameter Name<span>*</span>  </label>

<input type="text" tabindex=1 id="parameterName" name="parameterName" value="" class="textbox_date" validate="Parameter Name,string,yes" MAXLENGTH="30"  />
<div class="clear"></div>

<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('otMasChargeDetails','laboratory?method=addAnalyzerParameter');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('otMasChargeDetails','laboratory?method=editAnalyzerParameter')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button"	onClick="submitForm('otMasChargeDetails','laboratory?method=deleteAnalyzerParameter&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset"	id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" />
<input type="hidden"	name="<%=STATUS %>" value="" />
<input type="hidden"	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

<div class="bottom">
<label>Changed By:</label>
<label	class="value"><%=userName%></label>
<label>Changed Date:</label>
<label	class="value"><%=date%></label>
<label>Changed Time:</label>
<label	class="value"><%=time%></label>
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" />
 <input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />

 </div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Machine Name"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "machineName"


	data_header[1] = new Array;
data_header[1][0] = "Parameter Name"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "parameterName"

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>";


data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();
<%
Iterator itr=searchAnalyzerParameterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasAnalyzerParameter  masAnalyzerParameter = (MasAnalyzerParameter)itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masAnalyzerParameter.getId()%>
data_arr[<%= counter%>][1] = "<%= masAnalyzerParameter.getMachineName().trim()%>"
data_arr[<%= counter%>][2] = "<%= masAnalyzerParameter.getParameterName()%>"
	data_arr[<%= counter%>][3] = "<%= masAnalyzerParameter.getLastChgBy()!=null?(masAnalyzerParameter.getLastChgBy().getId()!=null?masAnalyzerParameter.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masAnalyzerParameter.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masAnalyzerParameter.getLastChgTime() %>"
		
		<% if(masAnalyzerParameter.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>

formName = "otMasChargeDetails"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');


</script> 
