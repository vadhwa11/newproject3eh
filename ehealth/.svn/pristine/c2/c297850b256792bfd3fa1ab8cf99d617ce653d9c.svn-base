<%@page import="java.util.Iterator"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BioWasteHandOver"%>
<%@page import="org.bouncycastle.asn1.x509.qualified.BiometricData"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.masters.business.MasWasteContainer"%>
<%@page import="jkt.hms.masters.business.MasWasteCategory"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_DATE "%>
<%@ page import="static jkt.hms.util.RequestConstants.CHEQUE_NO "%>
<%@ page import="static jkt.hms.util.RequestConstants.BANK_NAME "%>

<%
	Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	List<BioWasteHandOver>BioWasteHandOverList=new ArrayList<BioWasteHandOver>();
	List<MasWasteContainer>wasteContainerList=new ArrayList<MasWasteContainer>();
	if(map.get("BioWasteHandOverList")!=null){
		BioWasteHandOverList=(List<BioWasteHandOver>)map.get("BioWasteHandOverList");
	}
	if(map.get("wasteContainerList")!=null){
		wasteContainerList=(List<MasWasteContainer>)map.get("wasteContainerList");
	}
	String message="";
	if(map.get("message")!=null){
		message=(String)map.get("message");
	}
	if(message!=null && !message.equals("")){
%>
<script lang="javascript" src="/hms/jsp/js/common.js" type="text/javascript"></script>


<h4><%=message %></h4>
<%} %>
<div class="titleBg">
<h2>Bio Medical Waste Disposal</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>
<script type="text/javascript">

formFields = [
			[0, "Id", "id"], [1,"wasteCategory"], [2,"wasteContainer"], [3,"department"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>
<div class="clear">
</div>
<div class="paddingTop40">
</div><form name="wasteDisposal" method="post">
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "waste Category"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "wasteCategory"

data_header[1] = new Array;
data_header[1][0] = "Waste Container"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "wasteContainer";

data_header[2] = new Array;
data_header[2][0] = "department "
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "department";

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
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=BioWasteHandOverList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {

             BioWasteHandOver  bioWasteHandOver = (BioWasteHandOver)itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= bioWasteHandOver.getId()%>
data_arr[<%= counter%>][1] = "<%=bioWasteHandOver.getCategory().getWasteCategoryName()%>"
data_arr[<%= counter%>][2] = "<%= bioWasteHandOver.getContainer().getWasteContainerName()%>"
data_arr[<%= counter%>][3] = "<%= bioWasteHandOver.getDepartmentId().getDepartmentName()%>"
data_arr[<%= counter%>][4] = "<%= bioWasteHandOver.getLastChgBy().getUserName() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(bioWasteHandOver.getLasChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= bioWasteHandOver.getLastChgTime() %>"
<% if(bioWasteHandOver.getStatus().equalsIgnoreCase("P")){ %>
data_arr[<%= counter%>][7] = "Pending"
<%}else{%>
data_arr[<%= counter%>][7] = "Complete"
<%}%>
<%
		     counter++;
}
%>
formName = "wasteDisposal"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>	