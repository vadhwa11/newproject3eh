<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.CssdAutoclaveReceiptT"%>
<%@page import="jkt.hms.masters.business.CssdInstrumentMaster"%>

<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/acnik.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script language="javascript" type="text/javascript" >
function updateSterilizeInstrumentRecallList()
{
submitProtoAjax('instrumentMaster','/hms/hms/cssd?method=updateSterilizeInstrumentRecallList');

var okToRefresh = confirm("Successfully Updated ! Do you really want to refresh the page?");
if (okToRefresh)
	{
			setTimeout("location.reload(true);",500);
	
}

}

</script>

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
	ArrayList<CssdAutoclaveReceiptT> cssdAutoclaveReceiptTList = (ArrayList<CssdAutoclaveReceiptT>)map.get("cssdAutoclaveReceiptTList");
	ArrayList gridInstrumentList = (ArrayList)map.get("gridInstrumentList");
	ArrayList cssdAutoclaveEntryMList = (ArrayList)map.get("cssdAutoclaveEntryMList");
	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
	 	String msg = "";	
		if (map.get("updateMsg")!=null)
		{
		    msg = map.get("updateMsg").toString();
		}
%>


<%@page import="jkt.hms.masters.business.CssdAutoclaveEntryM"%>
<h4><span><%=message %></span></h4>

<%} %>
<div class="clear"></div>
<div class="titleBg">
<h2>Sterilize Instrument Recall List</h2>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults">
<div id="searchtable"></div>

<script type="text/javascript">
	formFields = [
		[0, "<%= COMMON_ID%>", "id"], [1,"<%= DATE %>"], [2,"<%= TIME %>"],[3,"<%= SEARCH_NAME %>"],[4,"<%= QTY%>"], [5,"<%= LOT_NO %>"],[6,"<%= CHANGED_BY %>"],[7,"<%= CHANGED_DATE %>"],[8,"<%=CHANGED_TIME%>"],[9,"<%= RECEIPT_STATUS %>"]];
	 statusTd = 9;
	</script></div>
<div class="clear"></div>
<form name="instrumentMaster" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="<%= POJO_NAME %>" value="CssdAutoclaveReceiptT">
	<input type="hidden" name="<%=JSP_NAME %>" value="cssdInstrumentMaster">
	
<h2>Details</h2>
<div class="clear"></div>
<div class="clear"></div>	
<label><span>*</span> Date </label> 
<input	id="date" type="text" name="<%= DATE %>" value=""  maxlength="10" tabindex=1 readonly="readonly"/>
	<label><span>*</span> Time</label> 
<input	id="time" type="text" name="<%= TIME %>" value=""  maxlength="10" tabindex=1 readonly="readonly"/>
	
<label><span>*</span> Instrument Name</label> 
<input type="text"	name="<%= SEARCH_NAME %>" value="" validate="Instrument Name,goodString,yes" maxlength="25" tabindex=1	/>

	<label>Lot No. </label> 
<input type="text"	name="<%= LOT_NO %>" value="" maxlength="25" tabindex=1	readonly="readonly"/>
	
<label> <span>*</span> Status</label>
<select	name="<%= RECEIPT_STATUS %>" tabindex=1">
<option value="">Select</option>
<option value="Received">Received</option>
<option value="Not Received">Not Received</option>
</select>

<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>

<input type="hidden" name="add" id="addbutton" value="Add" class="button" /> 
<input type="button" name="Update" class="button" value="Submit"
	onClick="updateSterilizeInstrumentRecallList()" />
<input type="hidden" name="Delete"  id="deletebutton" value="Activate" class="button" style="display: none;" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" tabindex=1 /> 
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> 
<input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="clear"></div>
</div>
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Date"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= DATE%>"

data_header[1] = new Array;
data_header[1][0] = "Time"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= TIME%>"

data_header[2] = new Array;
data_header[2][0] = "Instrument Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= SEARCH_NAME %>";

data_header[3] = new Array;
data_header[3][0] = "Qty"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%= QTY %>"

data_header[4] = new Array;
data_header[4][0] = "Lot No."
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= LOT_NO %>"


data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%= CHANGED_BY %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%=RECEIPT_STATUS %>";


data_arr = new Array();

<%
Iterator<CssdAutoclaveReceiptT> itr= cssdAutoclaveReceiptTList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  CssdAutoclaveReceiptT  cssdAutoclaveReceiptT = (CssdAutoclaveReceiptT)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= cssdAutoclaveReceiptT.getId()%>
data_arr[<%= counter%>][1] = "<%=HMSUtil.convertDateToStringWithoutTime(cssdAutoclaveReceiptT.getReceiptM().getReceiptDate())%>"
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringTypeDate(cssdAutoclaveReceiptT.getReceiptM().getReceiptDate())%>"
<%
		Iterator itrGridInstrumentList=gridInstrumentList.iterator();
		 while(itrGridInstrumentList.hasNext())
            {try{
            	CssdInstrumentMaster  instrumentGrid = (CssdInstrumentMaster)itrGridInstrumentList.next(); 
			 if(cssdAutoclaveReceiptT.getInstrument().getId().equals(instrumentGrid.getId()) && instrumentGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=instrumentGrid.getInstrumentName()%>"
			<%}else if(cssdAutoclaveReceiptT.getId().equals(instrumentGrid.getId()) && instrumentGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=instrumentGrid.getInstrumentName()%>";
				
			<%}
            }catch(Exception e){}}%>
data_arr[<%= counter%>][4] = "<%= cssdAutoclaveReceiptT.getQty()%>"
<%
		Iterator itrGridAutoclaveEntryMList=cssdAutoclaveEntryMList.iterator();
		 while(itrGridAutoclaveEntryMList.hasNext())
            {try{
            	CssdAutoclaveEntryM  cssdAutoclaveEntryMGrid = (CssdAutoclaveEntryM)itrGridAutoclaveEntryMList.next(); 
			 if(cssdAutoclaveReceiptT.getEntryM().getId().equals(cssdAutoclaveEntryMGrid.getId())){%>
				data_arr[<%= counter%>][3] = "<%=cssdAutoclaveEntryMGrid.getLotNo()%>"
			<%}else if(cssdAutoclaveReceiptT.getId().equals(cssdAutoclaveEntryMGrid.getId())){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=cssdAutoclaveEntryMGrid.getLotNo()%>";
				
			<%}
            }catch(Exception e){}}%>
data_arr[<%= counter%>][5] = "<%= cssdAutoclaveReceiptT.getEntryM().getLotNo()%>"
data_arr[<%= counter%>][6] = "<%= cssdAutoclaveReceiptT.getReceiptM().getLastChgBy() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(cssdAutoclaveReceiptT.getReceiptM().getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= cssdAutoclaveReceiptT.getReceiptM().getLastChgTime()%>"
data_arr[<%= counter%>][9] = "<%= cssdAutoclaveReceiptT.getRecallStatus() %>"
<%
   counter++;
}
%>
 
formName = "instrumentMaster"
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	



</script>

