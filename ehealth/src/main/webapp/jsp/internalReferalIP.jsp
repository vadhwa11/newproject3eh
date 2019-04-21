<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.WardRemarks"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>

<%
Map<String,Object>map=new HashMap<String,Object>();
if(request.getAttribute("map")!=null){
	map=(Map<String,Object>)request.getAttribute("map");
}
List<WardRemarks>wardList=new ArrayList<WardRemarks>();
if(map.get("wardList")!=null){
	wardList=(List<WardRemarks>)map.get("wardList");
}
if(wardList.size()>0){
%>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>


 <script type="text/javascript">

formFields = [
			[0, "ID", "id"], [1,"UHID"], [2,"PatientName"], [3,"Remarks"],[4,"Status"] ];
	 statusTd = 4;
	</script></div><form name="internalReferal" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<div id="edited">
</div>
	
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "UHID"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "UHID"

data_header[1] = new Array;
data_header[1][0] = "PatientName"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "Patient Name";

data_header[2] = new Array;
data_header[2][0] = "Remarks "
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "Remarks";

data_header[3] = new Array;
data_header[3][0] = "Status"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "Status"


data_arr = new Array();

<%
Iterator itr=wardList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {

             WardRemarks  wardRemarks = (WardRemarks)itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= wardRemarks.getInpatient().getId()%>
data_arr[<%= counter%>][1] = "<%=wardRemarks.getInpatient().getHin().getHinNo()%>"
data_arr[<%= counter%>][2] = "<%=wardRemarks.getInpatient().getHin().getPFirstName()%>"
	data_arr[<%= counter%>][3] = "<%=wardRemarks.getRemarks().trim()%>"
<% if(wardRemarks.getStatus().equalsIgnoreCase("P")){ %>
data_arr[<%= counter%>][4] = "Active"
<%}else{%>
data_arr[<%= counter%>][4] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "internalReferal"

<%-- nonEditable = ['<%= CODE%>']; --%>
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>

<%}else{ %>
<h4>No Records Found!!</h4>
<%} %>
</form>