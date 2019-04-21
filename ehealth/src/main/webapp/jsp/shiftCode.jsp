<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasShiftCodes"%>
<%@page import="jkt.hrms.masters.business.MasShiftCodes"%>

<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
List<HrMasShiftCodes> masShiftCodesList = new ArrayList<HrMasShiftCodes>(); 
if(map.get("masShiftCodesList")!= null){
masShiftCodesList = (List)map.get("masShiftCodesList");
}
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

String userName = "";
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
%>
<% 
if(map.get("message") != null){
String message = (String)map.get("message");
%>
<h4><span><%=message %></span></h4>
<%
}
%>

<div class="titleBg">
<h2>Shift Code Master</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Shift
Code</label> <input type="radio" name="<%=SELECTED_RADIO %>" value="1"
	checked="checked" class="radioCheck" /> <label>Shift Name</label> <input
	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck" />

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Shift Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'attendance?method=searchShiftCode')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','attendance?method=searchShiftCode','checkSearch')"
	tabindex=1 /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>

</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop5"></div>

<jsp:include page="searchResultBlock.jsp" />

<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
if(masShiftCodesList.size()>0)
{
String strForCode = (String)map.get("shiftCode");
String strForCodeDescription = (String)map.get("shiftName");
if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
{
%> <a href="attendance?method=showShiftCodeJsp">Show All Records</a> <%
}
}
if(masShiftCodesList.size()==0 && map.get("search") != null)
{
%> <a href="attendance?method=showShiftCodeJsp">Show All Records</a> <%
}
%> <script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
statusTd = 6;
</script></div>
<div class="clear"></div>
<form name="shiftCode" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block"><label><span>*</span> Shift Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Shift Code,string,yes" MAXLENGTH="20" tabindex=1 /> <label
	id=biglabel><span>*</span> Shift Name</label> <input type="text"
	name="<%= SEARCH_NAME %>" value="" validate="Shift Name,string,yes"
	MAXLENGTH="30" tabindex=1
	onkeypress="return submitenter(this,event,'attendance?method=saveShiftCode')" />
<script>
document.shiftCode.<%=CODE%>.focus();
</script>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('shiftCode','attendance?method=saveShiftCode');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('shiftCode','attendance?method=editShiftCode')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('shiftCode','attendance?method=deleteShiftCode&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>

<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Shift Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Shift Name"
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
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%


Iterator itr=masShiftCodesList.iterator();
int  counter=0;
while(itr.hasNext())
{


HrMasShiftCodes hrMasShiftCodes= (HrMasShiftCodes)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasShiftCodes.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasShiftCodes.getShiftCode()%>"
data_arr[<%= counter%>][2] = "<%= hrMasShiftCodes.getShiftName()%>"

data_arr[<%= counter%>][3] = "<%= hrMasShiftCodes.getLastChgBy()!=null?hrMasShiftCodes.getLastChgBy().getId():"0"%>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasShiftCodes.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= hrMasShiftCodes.getLastChgTime() %>"
<% if(hrMasShiftCodes.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
counter++;
}
%>

formName = "shiftCode"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
