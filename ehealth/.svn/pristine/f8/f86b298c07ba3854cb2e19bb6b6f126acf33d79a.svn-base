<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * printerdetails.jsp  
 * Purpose of the JSP -  This is for Printer Detals .
 * @author  Anand 
  * Create Date: 22 Jun,2010 
 * Revision Date:      
 * Revision By: 
 * @version 1.11
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchPrinterList = (ArrayList)map.get("searchPrinterList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}

%>
<%@page import="jkt.hms.masters.business.PrinterCofiguration"%>
<div class="titleBig">
<h2>Printer Details</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SYSTEMIP%>"], [2,"<%= TYPE %>"], [3,"<%= PRINTERNAME%>"] ];
			 statusTd = 3;
	
	</script>
	</div>


<form name="printerDetails" method="post" action="">
<input 	type="hidden" name="<%= POJO_NAME %>" value="PrinterCofiguration">
<input 	type="hidden" name="<%=POJO_PROPERTY_NAME %>" 	value="PrinterCofiguration">
<input type="hidden" name="title" value="printerDetails">
<input type="hidden" name="<%=JSP_NAME %>" value="printerDetails">
<input 	type="hidden" name="pojoPropertyCode" value="PrinterCofiguration">
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">

<label><span>*</span>System IP</label>
<input type="text" name="<%= SYSTEMIP%>" id="systemIp" value="" validate="System IP,String,yes" class="textbox_size20" />

<label><span>*</span>Type</label>
<input type="text" name="type" id="type" value="" validate="Type,String,yes" class="textbox_size20" />

<label><span>*</span>Printer Name</label>
<input type="text" name="printerName" id="printerName" value="" validate="Type,String,yes" class="textbox_size20" />

<div class="clear"></div>

</div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="add" class="button" 
onclick="submitForm('printerDetails','hospital?method=addPrinterName&flag='+this.value)" />

	 <input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button"
	onClick="submitForm('printerDetails','hospital?method=editPrinterDetails')" accesskey="u" tabindex=1 />
	 <input type="hidden" name="Delete" id="deletebutton" value="Activate"
	class="button"  onClick="submitForm('printerDetails','hospital?method=deleteMainChargecode&flag='+this.value)"
	accesskey="d" tabindex=1 /> 
	<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> 
	<input type="hidden" name="<%=STATUS %>" value="" /> 
</div>
<div class="clear"></div>


<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> 
	<label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
	<input type="hidden" 	name="<%= COMMON_ID%>" value="" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "System IP"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SYSTEMIP%>"

data_header[1] = new Array;
data_header[1][0] = "Type"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= TYPE%>"
data_header[2] = new Array;
data_header[2][0] = "Printer Name"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%= PRINTERNAME%>"

data_arr = new Array();


<%
Iterator itr=searchPrinterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             PrinterCofiguration  printerCofiguration = (PrinterCofiguration)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= printerCofiguration.getId()%>
data_arr[<%= counter%>][1] = "<%=printerCofiguration.getSystemIp()%>"
data_arr[<%= counter%>][2] = "<%= printerCofiguration.getType()%>"

data_arr[<%= counter%>][3] = "<%= printerCofiguration.getPrinterName() %>"

<%
		     counter++;
}
%>
 
formName = "printerDetails"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

</div>