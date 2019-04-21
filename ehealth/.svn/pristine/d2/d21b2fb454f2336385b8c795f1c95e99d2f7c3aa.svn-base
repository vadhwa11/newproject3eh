<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * poDetail.jsp  
 * Purpose of the JSP -  This is for PO Details .
 * @author  Amit Gupta
 * Revision Date:      
 * Revision By:  
 * @version 1.3
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.HesEquipmentMaintenance"%>

<%@page import="jkt.hms.util.RequestConstants"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script> 

<script type="text/javascript" language="javascript">

</script>
<%	
		Map map = new HashMap();
		String includedJsp="";
		//List searchList = new ArrayList();
		List<HesEquipmentMaintenance> searchEquipmentMaintenanceList = new ArrayList<HesEquipmentMaintenance>();
		
		if(request.getAttribute("map") != null)
		{
			map = (Map) request.getAttribute("map");	
		}
		
		try
		{
			searchEquipmentMaintenanceList = (List)map.get("searchEquipmentMaintenanceList");
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
			[0, "<%=RequestConstants.Hes_Maintenance_Id%>", "id"],[1, "<%=RADIO_FOR_TABLE%>"], [2,"Entry No"], [3,"Entry Date"], [4,"Department Name"],[5,"Equipment Name"],[6,"<%=STATUS%>"] ];
	 statusTd =6;

</script></div>
<div class="clear"></div>
<form name="maintenanceDetails" method="post" action="">
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
		data_header[4][0] = "Equipment Name"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "Equipment Name";
		
		data_header[5] = new Array;
		data_header[5][0] = "Status"
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=STATUS %>";
		
		data_arr = new Array();
		
<%		
			if(searchEquipmentMaintenanceList != null)
			{
				Iterator itr = searchEquipmentMaintenanceList.iterator();
	        	int  counter=0;
	        	String st="";
	        	
			          while(itr.hasNext())
			           {           
			        	  HesEquipmentMaintenance  poHeader = (HesEquipmentMaintenance)itr.next(); 
			             %>
	        	   
					data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = <%= poHeader.getId()%>
					data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%= poHeader.getId()%>" id="radio" />'
					data_arr[<%= counter%>][2] = "<%=poHeader.getEntryNo()%>"
					data_arr[<%= counter%>][3] = "<%=poHeader.getDate()%>"
					data_arr[<%= counter%>][4] = "<%= poHeader.getDepartment().getDepartmentName()%>"
					data_arr[<%= counter%>][5] = "<%= poHeader.getEquipmentMaster().getEquipmentName()%>"
<% 
					if(poHeader.equals("y"))
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

	formName = "maintenanceDetails"
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
		makeTable(start,end);
		
	intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
