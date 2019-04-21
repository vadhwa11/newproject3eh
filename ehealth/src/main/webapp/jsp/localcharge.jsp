<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * scheme.jsp  
 * Purpose of the JSP -  This is for Block Details.
 * @author  Mansi
 * @author  Vishal
 * Create Date: 25th Aug, 2015 
 * Revision Date:      
 * Revision By: 
 * @version 1.11  
--%>


<%@page import="jkt.hms.masters.business.ChargeCode"%>
<%@page import="jkt.hms.masters.business.MasChargeCode"%>
<%@page import="jkt.hms.masters.business.MasChargeCodeRates"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>

<%

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasChargeCodeRates> masChargeCodeRates = new ArrayList<MasChargeCodeRates>();
	List<MasChargeCode> chargecodes=new ArrayList<MasChargeCode>();
	List<MasChargeCode> chargecodesAll=new ArrayList<MasChargeCode>();
	String message = "";
	String userName = "";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("masChargeCodeRates") != null){
		masChargeCodeRates = (List<MasChargeCodeRates>)map.get("masChargeCodeRates");
	}
	
	if(map.get("chargecodes") != null){
		chargecodes = (List<MasChargeCode>)map.get("chargecodes");
	}
	
	if(map.get("chargecodesAll") != null){
		chargecodesAll = (List<MasChargeCode>)map.get("chargecodesAll");
	}
	
	if(map.get("message") != null){
		 
	}
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		
		ex.printStackTrace();
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
		 <%}
%>
<div class="titleBg">
<h2>Scheme Master</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<div class="Scheme">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Service Code</label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioCheckCol1" /> 
<label>Service Name</label> 
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radioCheckCol1" /> 
<input type="hidden" name="colCode" value="charge_code">
<input type="hidden" name="colName" value="charge_name">
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Charge Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'billingMaster?method=searchLocalCharge')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','billingMaster?method=searchLocalCharge','checkSearch')"	tabindex=1 />
<%--- Report Button   --%> <%-- <input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','billingMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_scheme"> --%>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

</div>
</div>
<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(masChargeCodeRates.size() == 0)
		 {
			
	%>
	 <h4><a href="billingMaster?method=showLocalCharge">Show All Records </a></h4>

<%
			}
	 %>  <script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%=CHANGED_BY%>"], [4,"<%=CHANGED_DATE%>"],[5,"<%=CHANGED_TIME%>"],[6,"<%=STATUS%>"],[7,"<%=CHARGE_CODE%>"],[8,"<%=CHARGE%>"]];	 
		 statusTd = 6;
	</script></div>

<form name="localchrge" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%-- <input type="hidden" name="<%= POJO_NAME %>" value="MasChargeCodeRates"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SchemeName">
<input type="hidden" name="title" value="Local Charge"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="localcharge"> 
<input	type="hidden" name="pojoPropertyCode" value="SchemeCode"> --%>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Scheme">
<div class="Block">
<label><span>*</span> Service </label>
<select id="codeId" type="text" name="<%=CHARGE_CODE%>" value="" validate="Service,int,yes" class="textbox_size20"	tabindex=1 >
<option value="">Select</option>
<%for(MasChargeCode chargeCode:chargecodes) {%>
<option value="<%=chargeCode.getId()%>"><%=chargeCode.getChargeCodeName() %> </option>
<%} %>
</select>
<label><span>*</span> Charge </label> 
<input type="text" name="<%=CHARGE%>" value="" validate="Charge,float,yes" class="textbox_size20" MAXLENGTH="10" tabindex=1 />
 <script>
 		document.localchrge.<%=CHARGE_CODE%>.focus();
			</script>


<div class="clear"></div>
</div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onclick="submitForm('localchrge','billingMaster?method=addLocalCharge');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onclick="submitForm('localchrge','billingMaster?method=editLocalCharge')" accesskey="u" tabindex=1 /> 

<div style="display: none;">
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('localchrge','billingMaster?method=deleteLocalCharge&flag='+this.value)" accesskey="d" tabindex=1 /> 
</div>
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
	<input type="hidden"
	name="<%=CODE %>" value="" />
	<input type="hidden"
	name="<%=SEARCH_NAME %>" value="" />
	


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName%></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div></form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Service"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Charge"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";



data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = "Admin"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME%>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_header[6] = new Array;
data_header[6][0] = "<%=CHARGE_CODE %>"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHARGE_CODE %>";

data_header[7] = new Array;
data_header[7][0] = "<%=CHARGE_CODE %>"
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=CHARGE_CODE %>";

data_arr = new Array();

<%
Iterator itr=masChargeCodeRates.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasChargeCodeRates  mascChargeCodeRate = (MasChargeCodeRates)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= mascChargeCodeRate.getId()%>
<%
String status="";
if(!mascChargeCodeRate.getChargeCode().getStatus().equalsIgnoreCase("y"))
{
	status="Parent Deactivated.";
}
%>
	data_arr[<%= counter%>][0] = "<%=mascChargeCodeRate.getId()%>"
	data_arr[<%= counter%>][1] = "<%=mascChargeCodeRate.getChargeCode().getChargeCodeName()%><%=status%>"
	data_arr[<%= counter%>][2] = "<%= mascChargeCodeRate.getRate()!=null?mascChargeCodeRate.getRate().toString():""%>"
 	data_arr[<%= counter%>][3] = ""
	data_arr[<%= counter%>][4] = ""
	data_arr[<%= counter%>][5] = ""
	data_arr[<%= counter%>][6] = "Active"
	data_arr[<%= counter%>][7] = "<%=mascChargeCodeRate.getChargeCode().getId()%>"
	data_arr[<%= counter%>][8] = "<%= mascChargeCodeRate.getRate()!=null?mascChargeCodeRate.getRate().toString():""%>"

<%
		     counter++;
}
%>
 
formName = "localchrge"

 nonEditable = ['<%= CHARGE_CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
