<%@page import="jkt.hms.masters.business.MasServiceCentreCounter"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasDepartment"%>
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
ArrayList searchServiceCentreCounterList = (ArrayList)map.get("searchServiceCentreCounterList");


List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
if(map.get("departmentList")!=null)
{
departmentList = (List<MasDepartment>)map.get("departmentList");
}
List<Object> masInstituteDepartmentList = new ArrayList<Object>();



//List<MasInstituteDepartment> masInstituteDepartmentList = new ArrayList<MasInstituteDepartment>();
if(map.get("masInstituteDepartmentList")!=null)
{
	masInstituteDepartmentList = (List<Object>)map.get("masInstituteDepartmentList");

}

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
<h2>Service Centre Counter</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Service Centre </label>
<select name="departmentIds" validate="Service Centre ,string,no" tabindex=1>
<option value="0">Select</option>

<%

for (Iterator iterator = masInstituteDepartmentList.iterator(); iterator.hasNext();) {
	Object[] object = (Object[]) iterator.next();

	Integer deptId = (Integer)object[0];
    String departmentName  = (String)object[1];
%>

<option value="<%=deptId%>"><%=departmentName%></option>

<%} %>
</select>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="2" class="radiobutMargin" /> 
<label>Counter No.</label>

<input type="text" tabindex=1 id="counterNos" name="counterNos" value="" class="textbox_date" validate="Counter No.,string,no" MAXLENGTH="10"  />

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','hospital?method=searchServiceCentreCounter')" tabindex=1 />
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
  if(searchServiceCentreCounterList.size()>0)
   {
   String strForGroupName = (String)map.get("counterNo");
   int  strForGroupId = (Integer)map.get("departmentId");
    if(strForGroupName!= null && strForGroupName!= ""  )
   {
 %> <h4><a href="hospital?method=showServiceCentreCounterJsp">Show All Records</a></h4> <%

		  }
	   }
	 if(searchServiceCentreCounterList.size()==0 && map.get("search") != null)
	  {
	 %><h4> <a href="hospital?method=showServiceCentreCounterJsp">Show All Records</a></h4> <%
    }
	%>
<script type="text/javascript">
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"departmentId"], [2,"counterNo"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
  statusTd =6;

 </script></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<form name="otMasChargeDetails" method="post" action="">
<div class="Block">
<label><span>*</span> Service Centre </label>
<select name="departmentId" validate="Service Centre ,string,yes" tabindex=1>
<option value="0">Select</option>

<%

for (Iterator iterator = masInstituteDepartmentList.iterator(); iterator.hasNext();) {
	Object[] object = (Object[]) iterator.next();

	Integer deptId = (Integer)object[0];
    String departmentName  = (String)object[1];
%>

<option value="<%=deptId%>"><%=departmentName%></option>

<%} %>
</select>

<label class="auto"><span>*</span> Counter No.</label>
<input type="text" tabindex=1 id="counterNo" name="counterNo" value="" class="textbox_date" validate="Counter No.,string,yes" MAXLENGTH="10"  />
<div class="clear"></div>

<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('otMasChargeDetails','hospital?method=addServiceCentreCounter');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('otMasChargeDetails','hospital?method=editServiceCentreCounter')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button"	onClick="submitForm('otMasChargeDetails','hospital?method=deleteServiceCentreCounter&flag='+this.value)" accesskey="d" tabindex=1 />
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
data_header[0][0] = "Service Centre "
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "departmentId"


	data_header[1] = new Array;
data_header[1][0] = "Counter No."
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "counterNo"

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
Iterator itr=searchServiceCentreCounterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasServiceCentreCounter  masServiceCentreCounter = (MasServiceCentreCounter)itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masServiceCentreCounter.getId()%>

<%
		Iterator itroTList=departmentList.iterator();
		while(itroTList.hasNext())
      	{
			MasDepartment  masDepartment = (MasDepartment)itroTList.next();
	 		if(masServiceCentreCounter.getDepartment()!=null && masServiceCentreCounter.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equalsIgnoreCase("y"))
	 		{
		 		
	 %>
				data_arr[<%= counter%>][1] = "<%=masDepartment.getDepartmentName()%>"
	<%		}
	 		else if(masServiceCentreCounter.getDepartment()!=null &&  masServiceCentreCounter.getDepartment().getId().equals(masDepartment.getId()) && masDepartment.getStatus().equalsIgnoreCase("n"))
	 		{
	 %>
				data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masDepartment.getDepartmentName()%>"
	<%
			}
		}
%>

data_arr[<%= counter%>][2] = "<%= masServiceCentreCounter.getCounterNo()%>"
	data_arr[<%= counter%>][3] = "<%= masServiceCentreCounter.getLastChgBy()!=null?(masServiceCentreCounter.getLastChgBy().getId()!=null?masServiceCentreCounter.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masServiceCentreCounter.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masServiceCentreCounter.getLastChgTime() %>"
		
		<% if(masServiceCentreCounter.getStatus().equals("y")){ %>
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
