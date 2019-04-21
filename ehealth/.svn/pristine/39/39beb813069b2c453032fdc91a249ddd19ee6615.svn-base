
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.TransactionSequence"%>



<%
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}

List<TransactionSequence> searchTransSeqSetupList = new ArrayList<TransactionSequence>();


	
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");
	if(map.get("searchTransSeqSetupList")!= null){
		searchTransSeqSetupList= (List<TransactionSequence>)map.get("searchTransSeqSetupList");
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if (map.get("message") != null) {
		String message = (String) map.get("message");
		out.println(message);
	}
	
%>


<div class="titleBg">
<h2>Transaction Sq Gen</h2>
</div>
<div class="clear"></div>
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><label class="auto">Transaction
Seq. Prefix</label> <input type="radio" name="<%=SELECTED_RADIO  %>" value="1"
	checked="checked" class="radioCheck" /> <label class="auto">Transaction
Seq. Name</label> <input type="radio" name="<%=SELECTED_RADIO %>" value="2"
	class="radioCheck" /> <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value="" MAXLENGTH="16" tabindex=1
	onkeypress="return submitenter(this,event,'sysParam?method=searchTransSeqSetupList')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','sysParam?method=searchTransSeqSetupList','checkSearch')"
	tabindex=1 /> <%--- Report Button     <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_relation">--%>



</form>
</div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<jsp:include page="/jsp/searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchTransSeqSetupList.size()>0)
		 {
			String strForCode = (String) map.get("transactionSqName");
			String strForCodeDescription = (String) map.get("transactionPrefix");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			  {
				 %> <br />
<a href="sysParam?method=showTransactionSeqSetupJsp">Show All
Records</a> <%
							}
						 }
	if(searchTransSeqSetupList.size()==0 && map.get("search") != null)
	{
	%> <a href="sysParam?method=showTransactionSeqSetupJsp">Show All
Records</a> <%
	}
	%> <script type="text/javascript">

 formFields = [
   [0, "<%= COMMON_ID%>", "id"],[1,"<%= TRANSACTION_SEQUENCE_NUMBER%>"],[2,"<%= SEARCH_NAME%>"],[3,"<%= CODE%>"], [4,"<%= TRANS_TABLENAME%>"], [5,"<%=TRANS_CREATEDBY  %>"], [6,"<%=STATUS%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=IDGENSEQ%>"]];
  statusTd = 9;
 
 </script></div>
<div class="clear"></div>
<form name="transactionSq" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input
	type="hidden" name="<%= POJO_NAME %>" value="TransactionSequence" /> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="TransactionSequenceName" /> <input type="hidden" name="prefix"
	value="TransactionPrefix" /> <input type="hidden"
	name="<%=JSP_NAME %>" value="transSeqSetup" /> <input type="hidden"
	name="pojoPropertyCode" value="TransactionPrefix" />

<div class="paddingTop15"></div>
<div class="Block"><label class="auto"><span>*</span>
Transaction Sequence No</label> <input type="text"
	name="<%=TRANSACTION_SEQUENCE_NUMBER%>" value="" maxlength="30"
	tabindex=1 /> <label class="auto"><span>*</span> Transaction
Prefix </label> <input id="codeId" type="text" name="<%= CODE%>" value=""
	maxlength="8" tabindex=1 />

<div class="clear"></div>

<label class="auto"><span>*</span> Transaction Sequence Name</label> <input
	type="text" name="<%= SEARCH_NAME %>" value="" maxlength="30"
	tabindex=1 /> <label class="auto"><span>*</span> Table Name</label> <input
	type="text" name="<%= TRANS_TABLENAME%>" value="" maxlength="30"
	tabindex=1 /> <label class="auto"><span>*</span> Seq Revision
By </label> <select name="<%=IDGENSEQ %>">
	<option value="">Select</option>
	<option value="m">Monthly</option>
	<option value="y">Yearly</option>
	<option value="c">Continuously</option>
</select> <script>
	    document.transactionSq.<%=TRANSACTION_SEQUENCE_NUMBER%>.focus();
	   </script>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onclick="submitForm('transactionSq','sysParam?method=addTransactionSq');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('transactionSq','sysParam?method=editTransactionSq')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('transactionSq','sysParam?method=deleteTransactionSq&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By</label> <label class="value"><%=userName%></label>

<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

<div class="clear"></div>
<div class="paddingTop40"></div>
</form>

<script type="text/javascript">
 
  
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Transaction Seq No"
	data_header[0][1] = "data";
	data_header[0][2] = "10%";
	data_header[0][3] = "<%= TRANSACTION_SEQUENCE_NUMBER%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Transaction Seq name"
	data_header[1][1] = "data";
	data_header[1][2] = "25%";
	data_header[1][3] = "<%= SEARCH_NAME%>"
	
	data_header[2] = new Array;
	data_header[2][0] = "Trasaction Prefix"
	data_header[2][1] = "data";
	data_header[2][2] = 0;
	data_header[2][3] = "<%= CODE%>"

	data_header[3] = new Array;
	data_header[3][0] = "Transaction Table"
	data_header[3][1] = "data";
	data_header[3][2] = 0;
	data_header[3][3] = "<%= TRANS_TABLENAME%>"
	
	data_header[4] = new Array;
	data_header[4][0] = "CREATED BY"
	data_header[4][1] = "hide";
	data_header[4][2] = "15%";
	data_header[4][3] ="<%= TRANS_CREATEDBY%>"
	
	data_header[5] = new Array;
	data_header[5][0] = "Status"
	data_header[5][1] = "data";
	data_header[5][2] = "15%";
	data_header[5][3] = "<%=STATUS %>";
	
	data_header[6] = new Array;
	data_header[6][0] = "Date"
	data_header[6][1] = "hide";
	data_header[6][2] = "15%";
	data_header[6][3] ="<%= CHANGED_DATE%>"
	
	data_header[7] = new Array;
	data_header[7][0] = "Time"
	data_header[7][1] = "hide";
	data_header[7][2] = "15%";
	data_header[7][3] ="<%= CHANGED_TIME%>"
	
	data_header[8] = new Array;
	data_header[8][0] = "Seq Revision"
	data_header[8][1] = "data";
	data_header[8][2] = "15%";
	data_header[8][3] ="<%= IDGENSEQ%>"
	
	data_arr = new Array();
	
	<%
Iterator itr=searchTransSeqSetupList.iterator();
	
          int  counter=0;
          while(itr.hasNext())
           {
        	 
             TransactionSequence  transactionSequence = (TransactionSequence)itr.next(); 
   
%>

	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= transactionSequence.getId()%>
	
	data_arr[<%= counter%>][1] = "<%=transactionSequence.getTransactionSequenceNumber()%>"
	data_arr[<%= counter%>][2] = "<%=transactionSequence.getTransactionSequenceName()%>"
	data_arr[<%= counter%>][3] = "<%=transactionSequence.getTransactionPrefix()%>"
	data_arr[<%= counter%>][4] = "<%=transactionSequence.getTablename() %>"
	data_arr[<%= counter%>][5]= "<%= transactionSequence.getCreatedbyId() %>"
	<% if(transactionSequence.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][6] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][6] = "InActive"
	<%}%>
	
	
	<%
	if(transactionSequence.getLastChgDate() != null){
	%>
	data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(transactionSequence.getLastChgDate()) %>"
	<%}else{%>
	data_arr[<%= counter%>][7] = "";
	<%}%>
	<%
	if(transactionSequence.getLastChgTime() != null){
	%>
	data_arr[<%= counter%>][8] = "<%= transactionSequence.getLastChgTime()%>"
	<%}else{%>
	data_arr[<%= counter%>][8] = "";
	<%}%>
	<%
	if(transactionSequence.getIdGenSeq() != null){
	if(transactionSequence.getIdGenSeq().equals("m")){ %>
			data_arr[<%= counter%>][9] = "Monthly"
	<%}if(transactionSequence.getIdGenSeq().equals("y")){%>
			data_arr[<%= counter%>][9] = "Yearly"
	<%}else if(transactionSequence.getIdGenSeq().equals("c")){%>
			data_arr[<%= counter%>][9] = "Continuously"
	<%}
	}else{%>
			data_arr[<%= counter%>][9] = ""
	<% }
       counter++;
}%>

formName = "transactionSq"

	nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>

