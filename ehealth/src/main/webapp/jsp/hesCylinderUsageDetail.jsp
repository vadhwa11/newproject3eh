<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>



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
			[0, "CylinderUsage", "id"],[1, "<%=RADIO_FOR_TABLE%>"], [2,"Entry No"], [3,"Entry Date"], [4,"<%=STATUS%>"] ];
	 statusTd =4;

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
		data_header[3][0] = "Status"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=STATUS %>";
		
		data_arr = new Array();
		
<%		
			if(searchList != null)
			{
				Iterator itr = searchList.iterator();
	        	int counter = 0;
	        	while(itr.hasNext())
	        	{    
	        		Object[] object = (Object[])itr.next();
%>
					data_arr[<%= counter%>] = new Array();
					data_arr[<%= counter%>][0] = "<%=object[0]%>"
					data_arr[<%= counter%>][1] = '<input type="radio"  name="parent" value="<%=object[0]%>" id="radio" />'
					data_arr[<%= counter%>][2] = "<%= object[1]%>"
					data_arr[<%= counter%>][3] = "<%= object[2]%>"
<% 
					if(object[3].equals("y"))
					{
%>
						data_arr[<%= counter%>][4] = "Active"
<%					}
					else
					{
%>
						data_arr[<%= counter%>][4] = "InActive"
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
