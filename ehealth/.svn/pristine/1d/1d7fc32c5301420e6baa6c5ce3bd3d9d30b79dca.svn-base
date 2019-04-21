<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasLaundryMachine"%>

<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String ,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList<MasLaundryMachine> searchLaundryList = (ArrayList<MasLaundryMachine>)map.get("searchLaundryList");
	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}	
%>
<script>
function checkSpecialChar(){
var code;
code = document.getElementById('codeId').value;
if(code.match("\"")){
alert('Please Do not enter " as Entry field')
return false;
}else if(code.match("\<")){
 alert('Please Do not enter < as Entry field')
 return false;
 }
 else{
 return true;
 }
}
</script>
<% 
if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
<h4><span><%=message%></span></h4>
<% 
		   
		  }
%>

<div class="titleBg">
<h2>Laundry Machine Master</h2>
</div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Machine Name</label> 
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Machine Name,string,yes" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'laundry?method=searchLaundry')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','laundry?method=searchLaundry','checkSearch')" tabindex=1 />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<% 
		if(searchLaundryList.size()>0)
		 {
			String strForCodeDescription = (String)map.get("machineName");
			if(strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4> <a href="laundry?method=showLaundryJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchLaundryList.size()==0 && map.get("search") != null)
	  {
	 %><h4> <a href="laundry?method=showLaundryJsp">Show All Records</a> </h4> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],[1,"<%= NAME%>"],[2,"<%= CHANGED_BY%>"],[3,"<%= CHANGED_DATE %>"],[4,"<%= CHANGED_TIME %>"],[5,"<%=STATUS%>"] ];
	 statusTd =5;
	</script></div>
<div class="clear"></div>
<form name="poolCategory" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input
	type="hidden" name="<%= POJO_NAME %>" value="MasLaundryMachine"><input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="MahineName"><input
	type="hidden" name="title" value="Laundry"><input type="hidden"
	name="<%=JSP_NAME %>" value="laundryMaster">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block"><label><span>*</span> Machine Name</label> <input
	id="codeId" type="text" name="<%= NAME%>" value=""
	validate="Machine Name,string,yes" maxlength="30" tabindex=1
	onkeypress="return submitenter(this,event,'laundry?method=addLaundry ')" />

<script>
				document.poolCategory.<%=NAME%>.focus();
			</script>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>


<div class="clear"></div>

<div id="edited"></div>


<input type="button" name="add" id="addbutton" value="Save"
	class="button"
	onClick="if(checkSpecialChar()){submitForm('poolCategory','laundry?method=addLaundry');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" style="display: none;" class="button"
	onClick="if(checkSpecialChar()){submitForm('poolCategory','laundry?method=editLaundry');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" style="display: none;"
	class="button"
	onClick="submitForm('poolCategory','laundry?method=deleteLaundry&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" tabindex="1" /> <input
	type="hidden" name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="clear"></div></form>
</div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Machine Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= NAME%>"


data_header[1] = new Array;
data_header[1][0] = ""
data_header[1][1] = "hide";
data_header[1][2] = 0;
data_header[1][3] = "<%= CHANGED_BY %>"

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_DATE %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "15%";
data_header[3][3] = "<%= CHANGED_TIME %>";

data_header[4] = new Array;
data_header[4][0] = "Status"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator<MasLaundryMachine> itr=searchLaundryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            MasLaundryMachine  masLaundry = (MasLaundryMachine)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masLaundry.getId()%>
data_arr[<%= counter%>][1] = "<%=masLaundry.getMahineName()%>"
data_arr[<%= counter%>][2] = "<%= masLaundry.getLastChgBy() %>"
data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(masLaundry.getLastChgDate()) %>"
data_arr[<%= counter%>][4] = "<%= masLaundry.getLastChgTime()%>"
<% if(masLaundry.getStatus().equals("y")){ %>
data_arr[<%= counter%>][5] = "Active"
<%}else{%>
data_arr[<%= counter%>][5] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "poolCategory"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
