<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	List<MasEmpCategory> masEmpCategoryList = new ArrayList<MasEmpCategory>();
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("masEmpCategoryList")!= null){
		masEmpCategoryList = (List)map.get("masEmpCategoryList");
	}
	System.out.println(">>>>"+(String)map.get("message"));
	if(map.get("message") != null){
		 String  message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%} %>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>

<div class="titleBg">
<h2>Employee Category</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<label class="auto"> Employee Category Code </label>
<input type="radio" name="<%=SELECTED_RADIO%>" value="1" checked="checked" class="radiobutMargin" tabindex=1 />
<label class="auto">Employee Category Name </label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" checked="checked" class="radiobutMargin" />
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Country Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />

<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchEmpCategory','checkSearch')"	tabindex=1 /></form>
</div>
</div>
<div class="clear"></div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<%
if(masEmpCategoryList.size()>0)
{
String strForCode = (String)map.get("empCategoryCode");
String strForCodeDescription = (String)map.get("empCategoryName");
if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
{
%><h4> <a href="personnel?method=showEmployeeCategory">Show All Records</a></h4>
<%
}
}
if(masEmpCategoryList.size()==0 && map.get("search") != null)
{
%> <h4><a href="personnel?method=showEmployeeCategory">Show All Records</a></h4>
<%
}
%> <script type="text/javascript">
formFields = [
			[0, "<%= EMP_CATEGORY_ID%>", "id"], [1,"<%= EMP_CATEGORY_CODE%>"], [2,"<%= EMP_CATEGORY_NAME %>"],  [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"], [7,"category_desc"]];
	 statusTd = 7;
	</script></div>
	<div class="paddingTop5"></div>
<div class="clear"></div>
<form name="employeeCategory" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="Block">

<label><span>*</span> Employee Category Code </label>
<input id="codeId" type="text" name="<%=EMP_CATEGORY_CODE%>" value="" readonly="readonly" validate="Employee category Code,string,yes" MAXLENGTH="8"  tabindex=1>
<label class="auto"><span>*</span> Employee Category Name </label>
<input type="text" name="<%= EMP_CATEGORY_NAME %>" value="" validate="Employee category Name,string,yes"  MAXLENGTH="30"  tabindex=1>
<label> Employee Category Desc </label>
<input type="text" name="category_desc" value="" validate="Employee category Desc,string,no"  MAXLENGTH="200"  tabindex=1>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('employeeCategory','personnel?method=addEmployeeCategory');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('employeeCategory','personnel?method=editEmployeeCategory')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('employeeCategory','personnel?method=deleteEmployeeCategory&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight"	onclick="resetCheck();" accesskey="r" />
<input type="hidden"	name="<%=STATUS %>" value="" />
<input type="hidden"	name="<%= EMP_CATEGORY_ID%>" value="" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName%></label>
<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Employee Category Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%=EMP_CATEGORY_CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Employee Category Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%=EMP_CATEGORY_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Currency "
data_header[2][1] = "hide";
data_header[2][2] = "40%";
data_header[2][3] = "<%=CHANGED_BY %>";

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
data_header[5][2] = 0;
data_header[5][3] = "<%= STATUS %>"

	data_header[6] = new Array;
data_header[6][0] = "Employee Category Desc"
data_header[6][1] = "data";
data_header[6][2] = 0;
data_header[6][3] = "category_desc"

data_arr = new Array();
<%
          int  counter=0;
             for(MasEmpCategory  masEmpCategory:masEmpCategoryList){
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masEmpCategory.getId()%>
data_arr[<%= counter%>][1] = "<%=masEmpCategory.getEmpCategoryCode()%>"
data_arr[<%= counter%>][2] = "<%= masEmpCategory.getEmpCategoryName().trim()%>"
	<%if(masEmpCategory.getLastChgBy() != null){ %>
data_arr[<%= counter%>][3] = "<%= masEmpCategory.getLastChgBy().getUserName() %>"
<%}else{%>
data_arr[<%= counter%>][3] =""
<%}%>

<%
if(masEmpCategory.getLastChgDate()!=null){
	%>
	data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masEmpCategory.getLastChgDate()) %>"
		<%
}else{
	%>
	data_arr[<%= counter%>][4] = "";
	<%
}
%>
<% if(masEmpCategory.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>

<%if(masEmpCategory.getEmpCategoryDesc() != null){ %>
data_arr[<%= counter%>][7] = "<%= masEmpCategory.getEmpCategoryDesc()  %>"
<%}else{%>
data_arr[<%= counter%>][7] = ""
<%}%>



<%
		     counter++;
}
%>

formName = "employeeCategory"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>
