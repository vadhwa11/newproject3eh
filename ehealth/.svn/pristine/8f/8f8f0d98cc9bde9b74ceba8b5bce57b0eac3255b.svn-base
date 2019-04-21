<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.HesEquipmentBreakdownEntry"%><script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>

<%	
		Map map = new HashMap();
		String includedJsp="";
		List<HesEquipmentBreakdownEntry> searchList = new ArrayList<HesEquipmentBreakdownEntry>();
		
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
			e.printStackTrace();
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
			[0, <%=COMMON_ID%>, "id"],[1, "<%=RADIO_FOR_TABLE%>"], [2,"Entry No"], [3,"Entry Date"], [4,"Equipment Name"], [5,"<%=STATUS%>"] ];
	 statusTd =5;

</script></div>
<div class="clear"></div>
<form name="eBreakForm" method="post" action="">
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
		data_header[3][0] = "Equipment Name"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "Equipment Name";
		
				
		data_header[4] = new Array;
		data_header[4][0] = "Status"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=STATUS %>";
		
		data_arr = new Array();
		
<%		
			if(searchList != null || ! searchList.equals(""))
			{
				for(HesEquipmentBreakdownEntry hesBreakdownObj : searchList){
	        	int counter = 0;
%>					
					data_arr[<%= counter%>] = new Array();
					
					data_arr[<%= counter%>][0] = <%= hesBreakdownObj.getId()%> 			
					data_arr[<%= counter%>][1] =   '<input type="radio"  name="parent" value="<%=hesBreakdownObj.getId()%>" id="radio" />'
					data_arr[<%= counter%>][2] = "<%=hesBreakdownObj.getEntryNo()%>"
					data_arr[<%= counter%>][3] = "<%= hesBreakdownObj.getDate() %>"
					data_arr[<%= counter%>][4] = "<%= hesBreakdownObj.getEquipmentMaster().getEquipmentName() %>"
					data_arr[<%= counter%>][5] = "<%= hesBreakdownObj.getStatus() %>"
<% 
					if(hesBreakdownObj.equals("y"))
					{
%>
						data_arr[<%= counter%>][6] = "Active"
<%					}
					else
					{%>
						data_arr[<%= counter%>][6] = "InActive"
<%
					}
%>
<%
				     counter++;
		        	}
				}
%>

	formName = "eBreakForm"
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
		makeTable(start,end);
		
	intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
