<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.StorePoHeader"%>


<script type="text/javascript" language=javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript">
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
		<%
		String userName = "";
	 	if (session.getAttribute("userName") != null) {
	 		userName = (String) session.getAttribute("userName");
	 	}
		Map<String, Object> utilMap = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String) utilMap.get("currentDate");
	 	String time = (String) utilMap.get("currentTime");

	 	Map<String, Object> map = new HashMap<String, Object>();
	 	if (request.getAttribute("map") != null) {
	 		map = (Map<String, Object>) request.getAttribute("map");
	 	}
	 	List<StorePoHeader> opHeaderList = new ArrayList<StorePoHeader>();
	 	if(map.get("opHeaderList")!=null){
	 		opHeaderList=(List<StorePoHeader>)map.get("opHeaderList");
	 	}
	 	int cnt = 1;
	%>

<div class="titleBg">
<h2> Purchase Order Tracking </h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<form name="poTracking" method="post" action="">
<div class="clear"></div>
<div class="Block">
<label><span>*</span> From Date</label>
<input	type="text" id="fromDateId" name="<%=FROM_DATE %>" value="<%=currentDate%>" readonly="readonly" MAXLENGTH="30" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.poTracking.<%= FROM_DATE%>,event);" />
</a>
<label><span>*</span> To Date</label>
<input type="text" id="ToDateId" name="<%=TO_DATE %>"  value="<%=currentDate%>" readonly="readonly"	MAXLENGTH="30"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.poTracking.<%= TO_DATE%>,event);" />
</a>

<input type="button" name="Submit" value="Submit" class="button" onClick="submitForm('poTracking','stores?method=searchPOTrackingList','validateFromToDate');" />

<input type="button" class="button" name="Submit" value="Search" onclick="submitForm('poTracking','stores?method=searchButtonPOTrackingList');" />
<div class="clear"></div></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="poTrackingScreen" method="post" action=""><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<script	type="text/javascript">
	formFields = [
			[0, "<%= PO_ID%>", "id"],[1,"radio"], [2,"servNo"], [3,"po_no"], [4,"po_date"], [5,"supplier_name"],[6,"status"]];
	 statusTd = 6;
	</script>

<input type="hidden" name="cntField" value="" id="cntFieldId"/>
</form>
<div class="clear"></div>
<div class="clear"></div>
<div id="testDiv">
</div>
</div>
<script type="text/javascript" language="javascript">
	data_header = new Array();
	data_header[0] = new Array;
	data_header[0][0] = ""
	data_header[0][1] = "data";
	data_header[0][2] = "10%";
	data_header[0][3] = "radio"

	data_header[1] = new Array;
	data_header[1][0] = "Sl. No."
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "servNo"

	data_header[2] = new Array;
	data_header[2][0] = "PO No."
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "po_no";

	data_header[3] = new Array;
	data_header[3][0] = "PO Date"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "po_date";

	data_header[4] = new Array;
	data_header[4][0] = "Supplier Name"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "supplier_name"

	data_header[5] = new Array;
	data_header[5][0] = "Status"
	data_header[5][1] = "data";
	data_header[5][2] = "10%";
	data_header[5][3] = "status"
	data_arr = new Array();
	<%

	    int  counter=0;
		if (opHeaderList != null && opHeaderList.size() > 0) { %>

	<% 	for(StorePoHeader poHeader : opHeaderList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = "<%=poHeader.getId()%>"
			data_arr[<%= counter%>][1] = '<input type="radio" class="radiogrid" name="parent" id="parent<%=cnt%>" value="<%=poHeader.getId()%>"  onclick="displayPendingList(<%=cnt%>);"/>'
			data_arr[<%= counter%>][2] = "<%=cnt%>"
		    data_arr[<%= counter%>][3] = "<%=poHeader.getPoNumber()%>"

			data_arr[<%= counter%>][4] = "<%=HMSUtil.changeDateToddMMyyyy(poHeader.getPoDate())%> "

			<%
			String supplierName ="";
				if(poHeader.getSupplier() != null){
					supplierName =poHeader.getSupplier().getSupplierName();
			%>
			data_arr[<%= counter%>][5] = "<%=supplierName%>"
			<%}else {%>
			data_arr[<%= counter%>][5] = "";
			<%}%>
			<% if(poHeader.getStatus().equals("o")){ %>
			data_arr[<%= counter%>][6] = "Open"
			<%}else if(poHeader.getStatus().equals("c")){%>
			data_arr[<%= counter%>][6] = "Cancel/Close"
			<%}else if(poHeader.getStatus().equals("r")){%>
			data_arr[<%= counter%>][6] = "Received"
			<%}else if(poHeader.getStatus().equals("p")){%>
			data_arr[<%= counter%>][6] = "Pending"
			<%}%>

	<%
				cnt++;
				counter++;
		    	}
			}
		%>
		   formName = "poTrackingScreen"
				start = 0
				if(data_arr.length < rowsPerPage){
					end = data_arr.length;
				}
				else{
					end = rowsPerPage;

				}
				makeTable(start,end);
</script>
<input type="hidden" class="button" name="counter" id="counter" value="<%=counter %>" />
<div id="viewPoButton" style="display: none">
<input type="button" class="button" name="Submit" value="View PO" onclick="viewSelectedPO();"/>
</div>
<div id="viewPoButtonOnload">
<input type="button" class="button" name="Submit" value="View PO" onclick="selectRadioButton();"/>
</div>
 <div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By</label><label class="value"><%=userName%></label>
<label>Changed Date</label> <label class="value"><%=currentDate%></label>
<label>Changed Time</label> <label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>

	<script type="text/javascript" language="javascript">

	function validateFromToDate(){

		var nowDate=new Date();

		obj1 = eval(document.poTracking.fromDate)
		obj2 = eval(document.poTracking.toDate)
	   if (obj1.value == '' || obj2.value == '') {
		alert("Please enter both Date....");
		return false;
	   }
		if(obj1.value != "" && obj2.value != ""){

		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));

			if(validFromDate<=nowDate){
					if(validFromDate > validToDate){
							alert("From Date should be smaller than To Date\n");
							return false;
					}
				}else{
				alert("From Date should not be greater than Current date\n");
				return false;
				}
		}
		return true;
	}

</script>

<script language="javascript">
function selectRadioButton(){
	alert("Please Select Radio Button");
}
function viewSelectedPO()
	{
		var cntFieldId = document.getElementById('cntFieldId').value;
		var url='/hms/hms/stores?method=showPoTrackingDetails&id='+cntFieldId;
		 popwindow(url);
	 }
	var newwindow;
	function popwindow(url)
	{
		 newwindow=window.open(url,'name','height=500,width=950,status=1');
		 if (window.focus)
		 {
		 newwindow.focus()
	 }
		newwindow.createPopup();
	}

	function displayPendingList(cnt)
	{
		document.getElementById('viewPoButton').style.display ='inline';
		document.getElementById('viewPoButtonOnload').style.display ='none';

		if(document.getElementById('parent'+cnt).value !=null){
		document.getElementById('cntFieldId').value = document.getElementById('parent'+cnt).value ;
		}else{
			document.getElementById('cntFieldId').value ='0';
		}
	}
	function validateRadio1(){
		var cntFieldId = document.getElementById('cntFieldId').value;
		 for(var i = 0; i < cntFieldId.length; i++){
		  if(document.getElementsByName('cntField')[i].checked == true)
         {
			return true;
		  }
		}
		alert("Please select any item")
	return false;

}
</script>
