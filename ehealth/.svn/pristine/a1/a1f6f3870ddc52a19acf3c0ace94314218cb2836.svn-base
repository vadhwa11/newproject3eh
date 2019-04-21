<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreGrnM"%>
<%@page import="jkt.hms.masters.business.StoreDefectiveDrugM"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>




<script type="text/javascript">
		<!--
		var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
		var IMGDIR_MISC = "images/misc";
		var vb_disable_ajax = parseInt("0", 10);
		// -->
		function search(){
		var parent=document.getElementById("radio").value;
		submitForm('searchGrn','stores?method=modifyDefectiveDrug&parent='+parent);
		}
		<%
		
		Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
	serverdate = '<%=date+"/"+month1+"/"+year1%>'
		</script>
<%
List<StoreDefectiveDrugM> searchDrugList= new ArrayList<StoreDefectiveDrugM>();
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
	Map map = new HashMap();
		String includedJsp="";
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<StoreDefectiveDrugM> gridDefectiveDrugHeaderList = new ArrayList<StoreDefectiveDrugM>();
		try{
			gridDefectiveDrugHeaderList=(List)map.get("gridDefectiveDrugHeaderList");
			searchDrugList=(List)map.get("searchDrugList");
		}catch(Exception e){
		}
		
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
	%>




<div class="clear"></div>


<form name="searchGrn" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="search" id="threadsearch"><a href=""></a> <script
	type="text/javascript"> vbmenu_register("threadsearch"); </script></div>
<div class="clear"></div>









<form action="searchPanel" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="searchBlock" id="threadsearch_menu" style="display: none;">
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<input type="hidden" name="s" value="cccfbaab0a70ed43fad9de8e3733112d" />
<input type="hidden" name="do" value="process" /> <input type="hidden"
	name="searchthread" value="1" /> <input type="hidden" name="showposts"
	value="1" /> <input type="hidden" name="searchthreadid" value="85875" />
<label>From Date :</label> <input type="text" name="<%= FROM_DATE %>"
	MAXLENGTH="30" tabindex=1 /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate%>',document.searchGrn.<%= FROM_DATE%>,event)" />
<div class="clear"></div>
<label>To Date :</label> <input type="text" name="<%= TO_DATE %>"
	MAXLENGTH="30" tabindex=1 /> <img src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate%>',document.searchGrn.<%= TO_DATE%>,event)" />

<div class="clear"></div>

<label>Defective Drug No:</label> <select name="<%=ENTRY_NO%>">
	<%
					for (StoreDefectiveDrugM storeDefectiveDrugM :searchDrugList ) {
				%>

	<option value=<%=storeDefectiveDrugM.getEntryNo()%>><%=storeDefectiveDrugM.getEntryNo()%></option>

	<%
					}
				%>

</select> <input type="image" src="/hms/jsp/images/go.gif" class="button"
	onClick="submitForm('searchGrn','stores?method=searchDefectiveDrug');" />

</div>
 

 </form>

<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>




</div>
<input type="button" name="Modify" type="submit" value="Modify"
	class="button" onClick="search();">
<div class="clear"></div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
<div class="clear"></div>
<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= ENTRY_ID%>", "id"],[1, "<%= ENTRY_NO%>"], [2,"<%= ENTRY_DATE%>"],[3,"<%=STATUS%>"] ];
	 statusTd =3;

</script> <script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Defective Drug No"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= ENTRY_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Entry Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= ENTRY_DATE %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Status"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=STATUS %>";
		
		
	
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridDefectiveDrugHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  StoreDefectiveDrugM  storeDefectiveDrugM = (StoreDefectiveDrugM)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= storeDefectiveDrugM.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent"  value="<%= storeDefectiveDrugM.getId()%>" id="radio" />'
			
			data_arr[<%= counter%>][2] = "<%=storeDefectiveDrugM.getEntryNo()%>"
			data_arr[<%= counter%>][3]="<%= storeDefectiveDrugM.getEntryDate()%>"
			 
             	
				<%if(storeDefectiveDrugM.getStatus().equals("y")){%>
						data_arr[<%= counter%>][4]="Active"
						<%}else{%>
						data_arr[<%= counter%>][4]="InActive"
						<%}%>
		<% counter++;
			}
		%>
		 
		formName = "searchGrn"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script> <script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script></form>