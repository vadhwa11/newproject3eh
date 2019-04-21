<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.StoreBalanceM"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript">
		<!--
		var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
		var IMGDIR_MISC = "images/misc";
		var vb_disable_ajax = parseInt("0", 10);
		// -->
</script>
<script>
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
			month1="0"+month1;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
			
	%>
		serverdate = '<%=date1+"/"+month1+"/"+year1%>'
</script>

<%		List<StoreBalanceM> searchStoreBalanceMList= new ArrayList<StoreBalanceM>();
		StringBuffer orderDateOnly = new StringBuffer();
		GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
	
		int dateOfMonth = gregorianCalendar1.get(Calendar.DAY_OF_MONTH);
		if (dateOfMonth < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(dateOfMonth);
		} else {
			orderDateOnly.append(dateOfMonth);
		}
	
		orderDateOnly.append("/");
	
		int month = gregorianCalendar1.get(Calendar.MONTH) + 1;
		if (month < 10) {
			orderDateOnly.append("0");
			orderDateOnly.append(month);
		} else {
			orderDateOnly.append(month);
		}
	
		orderDateOnly.append("/");
		int year = gregorianCalendar1.get(Calendar.YEAR);
		orderDateOnly.append(year);
		String currentDate = new String(orderDateOnly);
	%>
<%	
	Map<String,Object> map = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<StoreBalanceM> gridIndentHeaderList= new ArrayList<StoreBalanceM>();
		
		try{
			gridIndentHeaderList=(List)map.get("indentHeaderList");
			searchStoreBalanceMList=(List)map.get("searchStoreBalanceMList");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		ArrayList gridApprovedByList = (ArrayList)map.get("approvedByEmployeeList");
		
			
		
	%>




<div class="clear"></div>
<form name="searchBalance" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<input
	type="hidden" name="tempRadioValue" id="tempRadioValue" />
<div class="clear"></div>
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>


<input type="button" name="Add" type="submit" value="Add" class="button"
	onClick="submitForm('searchBalance','stores?method=showBalanceJsp');" />
<%
	if(gridIndentHeaderList.size() > 0){
%> <input type="button" name="Modify" value="Modify" class="button"
	onClick="submitForm('searchBalance','stores?method=modifyBalance','validateRadio');" />
<%} %>
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<form name="searchPanel" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="paddingTop40"></div>
<form action="searchPanel" method="post"><input type="hidden"
	name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
	type="hidden" name="do" value="process" /> <input type="hidden"
	name="searchthread" value="1" /> <input type="hidden" name="showposts"
	value="1" /> <input type="hidden" name="searchthreadid" value="85875" />

<label>From Date :</label> <input type="text" name="<%= FROM_DATE %>"
	value="<%=currentDate %>" MAXLENGTH="30" tabindex=1 class="date" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.searchBalance.<%= FROM_DATE%>,event)" />

<label>To Date :</label> <input type="text" name="<%= TO_DATE %>"
	value="<%=currentDate %>" MAXLENGTH="30" tabindex=1 /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date"
	onClick="setdate('<%=currentDate%>',document.searchBalance.<%= TO_DATE%>,event)" />
<div class="clear"></div>

<label>Opening Balance No. :</label> <select
	name="<%= SEARCH_BALANCE_NO%>">
	<option value="0">Select</option>
	<%
					for (StoreBalanceM storeBalanceM :searchStoreBalanceMList ) {
				%>

	<option value=<%=storeBalanceM.getBalanceNo()%>><%=storeBalanceM.getBalanceNo()%></option>

	<%
					}
				%>
</select> <input type="image" src="/hms/jsp/images/go.gif" name="Submit"
	id="addbutton" class="button"
	onClick="submitForm('searchBalance','stores?method=searchBalance');" />
</td>
 

 </form>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>



</div>

<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= BALANCE_ID%>", "id"],[1, "<%= BALANCE_NO%>"], [2,"<%= BALANCE_DATE%>"], [3,"<%= APPROVED_BY_EMPLOYEE_ID_BALANCE %>"],[4,"<%=REMARKS%>"] ];
	 statusTd =4;

</script> <script type="text/javascript" language="javascript">
		function checkRadio(id){
		
		document.getElementById("tempRadioValue").value =id
		
		}
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Balance No."
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= BALANCE_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Balance Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= BALANCE_DATE %>";
		
			
		data_header[3] = new Array;
		data_header[3][0] = "Approved By"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=APPROVED_BY_EMPLOYEE_ID_BALANCE %>";
		
		
		data_header[4] = new Array;
		data_header[4][0] = "Remarks"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=REMARKS %>";
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridIndentHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  StoreBalanceM  storeBalanceM = (StoreBalanceM)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= storeBalanceM.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= storeBalanceM.getId()%>" onclick="checkRadio(<%= storeBalanceM.getId()%>);" id="radio" />'
			data_arr[<%= counter%>][2] = "<%=storeBalanceM.getBalanceNo()%>"
			data_arr[<%= counter%>][3]= "<%= HMSUtil.changeDateToddMMyyyy(storeBalanceM.getBalanceDate())%>"
			
	
            
             <%
		Iterator itrGridApprovedByList=gridApprovedByList.iterator();
		 while(itrGridApprovedByList.hasNext())
            {try{
             MasEmployee  approvedByGrid = (MasEmployee)itrGridApprovedByList.next(); 
			 if(storeBalanceM.getApprovedBy().getId().equals(approvedByGrid.getId()) && approvedByGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=approvedByGrid.getFirstName()%> <%=approvedByGrid.getLastName()%>"
			<%}else if(storeBalanceM.getId().equals(approvedByGrid.getId()) && approvedByGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=approvedByGrid.getFirstName()%> <%=approvedByGrid.getLastName()%>";
				
			<%}
            }catch(Exception e){
            	e.printStackTrace();
            	
            }}%>
            
   
            
            	data_arr[<%= counter%>][5] = "<%=storeBalanceM.getRemarks()%>"
            
			
			
		<% counter++;
			}
		%>
		 
		formName = "searchBalance"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
		
		
		
			
function validateRadio(){
			
			 for(var i = 0; i < document.getElementsByName('parent').length; i++){
			  if(document.getElementsByName('parent')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please select the row")
		return false;
		
	}
		
</script> <script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script></form>