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
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
			
		}
		List<MasStoreSupplier> searchSupplierList= new ArrayList<MasStoreSupplier>();
		List<StorePoDetail> searchPoDetailList = new ArrayList<StorePoDetail>();
		List<StorePoHeader> searchPoHeaderList = new ArrayList<StorePoHeader>();
		try{
			searchSupplierList=(List)map.get("searchSupplierList");
			searchPoDetailList=(List)map.get("searchPoDetailList");
			searchPoHeaderList=(List)map.get("searchPoHeaderList");
		}catch(Exception e){
		}
		
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
	
	%>


<br />

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= PO_DETAIL_ID%>", "id"],[1, "<%= RADIO_FOR_TABLE%>"], [2,"<%= PO_NO%>"], [3,"<%= PO_DATE %>"], [4,"<%= SUPPLIER_NAME %>"],[5,"<%= STORE_CODE %>"],[6,"<%= NET_AMOUT %>"],[7,"<%=STATUS%>"] ];
	 statusTd =7;

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
		data_header[1][0] = "P.O. No"
		data_header[1][1] = "data";
		data_header[1][2] = "15%";
		data_header[1][3] = "<%= PO_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "P.O. Date"
		data_header[2][1] = "data";
		data_header[2][2] = "15%";
		data_header[2][3] = "<%= PO_DATE %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Supplier"
		data_header[3][1] = "data";
		data_header[3][2] = "15%";
		data_header[3][3] = "<%=SUPPLIER_NAME %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Store Code"
		data_header[4][1] = "data";
		data_header[4][2] = "15%";
		data_header[4][3] = "<%=STORE_CODE %>";
		
		data_header[5] = new Array;
		data_header[5][0] = "Net Amount"
		data_header[5][1] = "data";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=NET_AMOUT %>";
		
		
		
		data_header[6] = new Array;
		data_header[6][0] = "Status"
		data_header[6][1] = "data";
		data_header[6][2] = "15%";
		data_header[6][3] = "<%=STATUS %>";
		
		data_arr = new Array();
		
		<%String st="";
		Iterator itrrr=searchPoHeaderList.iterator();
		          int  counter=0;
		          int rowv=0;
		          while(itrrr.hasNext())
		           {           
		        	  StorePoHeader  poHeader = (StorePoHeader)itrrr.next(); 
		             %>
		
			data_arr[<%= counter%>] = new Array();
			
			data_arr[<%= counter%>][0] = <%= poHeader.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio"  name="parent"  value="<%= poHeader.getId()%>"  id="radio<%=rowv%>" />'
			data_arr[<%= counter%>][2] = "<%=poHeader.getPoNumber()%>"
			data_arr[<%= counter%>][3]="<%=HMSUtil.convertDateToStringWithoutTime(poHeader.getPoDate())%>"
			 
             			<% if(poHeader.getSupplier().getStatus().equals("y")){
             				 
             			%>
             			
             			data_arr[<%= counter%>][4]="<%= poHeader.getSupplier().getSupplierName()%>"
             			<%
             			  }else if(poHeader.getSupplier().getStatus().equals("n")){
             			%>
             			data_arr[<%= counter%>][4]="<font id='error'>*</font>Parent InActivated--<%= poHeader.getSupplier().getSupplierName()%>"
             			<%
             			}%>
             			<% 
             			if(poHeader.getDepartment().getStatus().equals("y")){
             				 
             			%>
             			
             			data_arr[<%= counter%>][5]="<%= poHeader.getDepartment().getDepartmentName()%>"
             			<%
             			  }else if(poHeader.getDepartment().getStatus().equals("n")){
             			%>
						data_arr[<%= counter%>][5]="<font id='error'>*</font>Parent InActivated--<%= poHeader.getDepartment().getDepartmentName()%>"
             			<%
             			}%>
             			
             			
			
		
		
			data_arr[<%= counter%>][6] = "<%= poHeader.getNetAmount() %>"
		
				<%if(!poHeader.getStatus().equals("c")){%>
						data_arr[<%= counter%>][7]="Active"
						<%}else{%>
						data_arr[<%= counter%>][7]="InActive"
						<%}%>
		<% counter++;
		rowv++;
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
<input type="hidden" name="rowVal" value="<%=searchPoHeaderList.size()%>" id="rowVal"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>