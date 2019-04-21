<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * searchSoc.jsp  
 * Purpose of the JSP -  This is for Search for SOC.
 * @author  Deepali
 * @author  Mansi
 * Create Date: 04th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.StoreSoc"%>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>

<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
		function rCh()
		{	
			for(var i = 0; i < document.getElementsByName('parent').length; i++){
  				 if(document.getElementsByName('parent')[i].checked == true)
  				 {
  					 return true;
  					 break;
  				}else{
  					alert('Please select radio button.');
   				 	return false;
  				}
  					
 			}
			
		}

	
		<!--
		var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
		var IMGDIR_MISC = "images/misc";
		var vb_disable_ajax = parseInt("0", 10);
		// -->
		</script> <%		List<StoreSoc> searchSocList= new ArrayList<StoreSoc>();
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
	%> <%	
	Map<String,Object> map = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<StoreSoc> gridSocHeaderList= new ArrayList<StoreSoc>();
		
		try{
			gridSocHeaderList=(List)map.get("gridSocHeaderList");
			searchSocList=(List)map.get("searchSocList");
		}catch(Exception e){
		}
		
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		if(map.get("message") != null){
			   String message = (String)map.get("message");
			   out.println(message);
			  }
	%>



<div id="contentspace"><br />

<form name="searchSoc" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 

<table class="tborder" width="100%" align="center">
	<tr>
		<td width="20%" nowrap="nowrap" class="vbmenu_control"
			id="threadsearch"><a href="">Search</a> <script
			type="text/javascript"> vbmenu_register("threadsearch"); </script></td>
		<td width="80%"><label>&nbsp;</label><label>&nbsp;</label><label>&nbsp;</label>




		<table width="20%" align="right" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="5%"><IMG SRC="/hms/jsp/images/toolBar_01.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
				<td width="7%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Add" type="submit" value="Add"
					onClick="submitForm('searchSoc','stores?method=showSocJsp');"
					class="toolbutton"></td>
				<td width="1%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="10%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" name="Modify" type="submit" value="Modify"
					class="toolbutton"
					onClick="submitForm('searchSoc','stores?method=modifySoc','validateRadio');"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					name="Reset" type="reset" value="Reset" class="buttonHighlight"></td>
				<td width="2%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="9%" background="/hms/jsp/images/toolbuttBack.gif"><input
					type="button" value="Delete"
					onClick="submitForm('searchSoc','stores?method=deleteSoc','validateRadio');"
					class="toolbutton"></td>
				<td width="4%" background="/hms/jsp/images/toolbuttBack.gif"></td>
				<td width="39%"><IMG SRC="/hms/jsp/images/closeButton.gif"
					WIDTH=24 HEIGHT=28 ALT=""></td>
			</tr>
		</table>
		</td>
	</tr>
</table>



<div align="center">
<div style="padding: 0px 25px 0px 25px"><!-- thread search menu -->
<div class="vbmenu_popup" id="threadsearch_menu" style="display: none">

<form action="searchPanel" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<table cellpadding="4" cellspacing="1" border="0">
	<tr>
		<td class="thead">Search Panel<a name="goto_threadsearch"></a></td>
	</tr>
	<tr>
		<td class="vbmenu_option" title="nohilite"><input type="hidden"
			name="s" value="cccfbaab0a70ed43fad9de8e3733112d" /> <input
			type="hidden" name="do" value="process" /> <input type="hidden"
			name="searchthread" value="1" /> <input type="hidden"
			name="showposts" value="1" /> <input type="hidden"
			name="searchthreadid" value="85875" /> <label class="bodytextB_blue">From
		Date :</label> <input type="text" name="<%= FROM_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.searchSoc.<%= FROM_DATE%>,true);"
			class="calender" /> <label class="bodytextB_blue">To Date :</label>

		<input type="text" name="<%= TO_DATE %>" class="textbox_date"
			MAXLENGTH="30" / tabindex=1 /> <img id="calendar"
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date"
			onClick="setdate('<%=currentDate%>',document.searchSoc.<%= TO_DATE%>,true);"
			class="calender" /> <br />
		<label class="bodytextB_blue">Indent No:</label> <select
			name="<%= INDENT_NO_FOR_SEARCH%>">
			<option value="0">Select</option>
			<%
							for (StoreSoc storeSoc :searchSocList ) {
						%>

			<option value=<%=storeSoc.getIndentNo()%>><%=storeSoc.getIndentNo()%></option>

			<%
							}
						%>
		</select> <input type="button" class="smbutton" value="Go!"
			onClick="submitForm('searchSoc','stores?method=searchSoc');" /></td>
	</tr>

</table>
 
 </form>
</div>
</div>
</div>
<jsp:include page="searchResultPO.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

</div>
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel"><br />
</div>
</div>
<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= SOC_ID%>", "id"],[1, "<%= INDENT_NO%>"], [2,"<%= INDENT_DATE%>"], [3,"<%= ITEM_ID %>"], [4,"<%= STATUS %>"] ];
	 statusTd =4;

</script> <script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "INDENT No"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= INDENT_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "INDENT Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= INDENT_DATE %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Item"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=ITEM_ID %>";
		
		
		data_header[4] = new Array;
		data_header[4][0] = "Status"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=STATUS %>";
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=gridSocHeaderList.iterator();
		          int  counter=0;
		          while(itrrr.hasNext())
		           {           
		        	  StoreSoc  storeSoc = (StoreSoc)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= storeSoc.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= storeSoc.getId()%>" id="radio" />'
			data_arr[<%= counter%>][2] = "<%=storeSoc.getIndentNo()%>"
			data_arr[<%= counter%>][3]="<%= HMSUtil.changeDateToddMMyyyy(storeSoc.getIndentDate())%>"
			 data_arr[<%= counter%>][4]="<%= storeSoc.getItem().getNomenclature()%>"
			              	
				<%if(storeSoc.getStatus().equals("y")){%>
						data_arr[<%= counter%>][5]="Active"
						<%}else{%>
						data_arr[<%= counter%>][5]="InActive"
						<%}%>
		<% counter++;
			}
		%>
		 
		formName = "searchSoc"
		
		
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
</script>
</form>