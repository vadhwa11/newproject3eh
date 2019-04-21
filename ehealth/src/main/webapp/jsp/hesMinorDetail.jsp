<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * poDetail.jsp  
 * Purpose of the JSP -  This is for PO Details .
 * @author  Deepti Tevatia
 * Create Date: 12th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


<%@page import="jkt.hms.masters.business.MasStoreSupplier"%>
<%@page import="jkt.hms.masters.business.StorePoDetail"%>
<%@page import="jkt.hms.masters.business.StorePoHeader"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script> 
<script type="text/javascript" language="javascript">

</script>
<%	
		Map map = new HashMap();
		String includedJsp="";
		List searchList = new ArrayList();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");	
		}
		
		try
		{
			searchList = (List)map.get("searchList");
		}
		catch(Exception e)
		{
		}
		
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
	%>
<br/>

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "MinorId", "id"],[1, "<%=RADIO_FOR_TABLE%>"], [2,"Entry No"], [3,"Entry Date"], [4,"Department Name"],[5,"Work Particular Name"],[6,"<%=STATUS%>"] ];
	 statusTd =6;

</script></div>
<div class="clear"></div>
<form name="poDetails" method="post" action="">
<div id="edited"></div>
<label>&nbsp;</label>
<div id="statusMessage" class="messagelabel">
<div class="clear"></div>
</div>

<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Radio"
		data_header[0][1] = "radio";
		data_header[0][2] = "15%";
		data_header[0][3] = "<%= RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Entry No"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "Entry No"
		
		data_header[2] = new Array;
		data_header[2][0] = "Entry Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "Entry Date";
		
		data_header[3] = new Array;
		data_header[3][0] = "Department Name"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "Department Name";
		
		data_header[4] = new Array;
		data_header[4][0] = "Work Particular Name"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "Work Particular Name";
		
		data_header[5] = new Array;
		data_header[5][0] = "Status"
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=STATUS %>";
		
		data_arr = new Array();
		
<%		
			if(searchList != null)
			{
				Iterator itr = searchList.iterator();
	        	int  counter=0;
	        	String st="";
	        	while(itr.hasNext())
	        	{    
	        		Object[] object = (Object[])itr.next();
%>
					data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = "<%=object[0]%>"
					data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%=object[0]%>" id="radio" />'
					data_arr[<%= counter%>][2] = "<%= object[1]%>"
					data_arr[<%= counter%>][3] = "<%= object[2]%>"
					data_arr[<%= counter%>][4] = "<%= object[3]%>"
					data_arr[<%= counter%>][5] = "<%= object[4]%>"
<% 
					if(object[5].equals("y"))
					{
%>
						data_arr[<%= counter%>][6] = "Active"
<%					}
					else
					{
%>
						data_arr[<%= counter%>][6] = "InActive"
<%
					}
%>
<%
				     counter++;
		        	}
				}
%>

	formName = "poDetails"
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
		makeTable(start,end);
		
	intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
