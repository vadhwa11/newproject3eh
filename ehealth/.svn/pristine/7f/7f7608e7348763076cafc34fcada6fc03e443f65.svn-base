<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * authorizer.jsp  
 * Purpose of the JSP -  This is for Authorizer.
 * @author  Vishal
 * Create Date: 14st Jan,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.9  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasAuthorizer"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/csrfToken.js"></script>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchAuthorizerList = (ArrayList)map.get("searchAuthorizerList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   %>
		   <h4><span><%=message %></span></h4>
<%} %>

<div class="titleBg">
<h2>Authorizer</h2>
</div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<label>Authorizer Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" validate="Gender Code,int,no" />
<label>Authorizer Name</label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" validate="Gender Code,int,no" />

<input type="hidden" name="colCode" value="authorizer_code" validate="Authorizer Code,string,no">
<input type="hidden" name="colName" value="authorizer_name" validate="Authorizer Code,string,no">
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Authorizer Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=searchAuthorizer')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','hospital?method=searchAuthorizer','checkSearch')" tabindex=1 />
<%--- Report Button    <input type="button" name="Report" value="Generate Report Based on Search" class="button" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>  --%>
<input type="button" name="Report" value="Generate Report" class="buttonBig" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> 
<input type="hidden"name="<%=JASPER_FILE_NAME%>" value="Mas_authorizer">
</form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchAuthorizerList.size()>0)
		 {
			String strForCode = (String)map.get("authorizerCode");
			String strForCodeDescription = (String)map.get("authorizerName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%><h4> <a href="hospital?method=showAuthorizerJsp">Show All Records</a></h4> <%
			}
		 }
	if(searchAuthorizerList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="hospital?method=showAuthorizerJsp">Show All Records</a></h4> <%
  }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%=MIN_AUTHORIZE_AMOUNT%>"], [4,"<%=MAX_AUTHORIZE_AMOUNT%>"], [5,"<%=CHANGED_BY%>"], [6,"<%=CHANGED_DATE%>"],[7,"<%=CHANGED_TIME%>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script></div>


<form name="authorizer" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%= POJO_NAME %>" value="MasAuthorizer">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="AuthorizerName">
<input type="hidden" name="title" value="Authorizer"><input type="hidden" name="<%=JSP_NAME %>" value="authorizer">
<input type="hidden" name="pojoPropertyCode" value="AuthorizerCode">
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Authorizer Code</label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Authorizer Code,string,no" MAXLENGTH="8" tabindex=1 />
<label><span>*</span> Authorizer Name</label> 
<input type="text" id="nameId" name="<%= SEARCH_NAME %>" value="" validate="Authorizer Name,string,no" MAXLENGTH="30" tabindex=1 /> 
<script>
	document.authorizer.<%=CODE%>.focus();
</script>

<div class="clear"></div>

<label><span>*</span> Min Authorize Amount</label> 
<input type="text" id="minAthId" name="<%= MIN_AUTHORIZE_AMOUNT %>" value="" validate="Min Authorize Amount,float,no" MAXLENGTH="7" tabindex=1 onkeypress="return submitenter(this,event,'hospital?method=addAuthorizer')" />
<label><span>*</span> Max Authorize Amount</label> 
<input id="maxAthId" type="text" name="<%= MAX_AUTHORIZE_AMOUNT%>" value="" validate="Max Authorize Amount,float,no" MAXLENGTH="7" tabindex=1 />
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add"	class="button"	onClick="submitForm('authorizer','hospital?method=addAuthorizer','checkFieldsOnSubmit');"
	accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('authorizer','hospital?method=editAuthorizer','checkFieldsOnSubmit')"
	accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('authorizer','hospital?method=deleteAuthorizer&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset" value="Reset" class="buttonHighlight"
	onclick="resetCheck();" accesskey="r" /> 
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input type="hidden" name="<%=COMMON_ID%>" value="" />
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="clear"></div>
</div>

<div class="bottom">
<label>Changed By:</label> 
<label class="value"><%=userName%></label> 
<label>Changed Date:</label> 
<label class="value"><%=date%></label> 
<label>Changed Time:</label> 
<label	class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Authorizer Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Authorizer Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Min Authorize Amount"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= MIN_AUTHORIZE_AMOUNT %>"

data_header[3] = new Array;
data_header[3][0] = "Max Authorize Amount"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%= MAX_AUTHORIZE_AMOUNT %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_TIME%>"

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";
data_arr = new Array();

<%


Iterator itr=searchAuthorizerList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasAuthorizer  masAuthorizer = (MasAuthorizer)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masAuthorizer.getId()%>
data_arr[<%= counter%>][1] = "<%=masAuthorizer.getAuthorizerCode()%>"
data_arr[<%= counter%>][2] = "<%= masAuthorizer.getAuthorizerName()%>"
<%
	if(masAuthorizer.getMinAuthorizeAmt() != null){
%>
data_arr[<%= counter%>][3] = "<%=masAuthorizer.getMinAuthorizeAmt()%>"
<%}else{%>
data_arr[<%= counter%>][3] = "";
<%}%>

<%
	if(masAuthorizer.getMaxAuthorizeAmt() != null){
%>
data_arr[<%= counter%>][4] = "<%=masAuthorizer.getMaxAuthorizeAmt()%>"
<%}else{%>
data_arr[<%= counter%>][4] = "";
<%}%>

data_arr[<%= counter%>][5] = "<%= masAuthorizer.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masAuthorizer.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masAuthorizer.getLastChgTime() %>"
<% if(masAuthorizer.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "authorizer"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>


<script>
function checkFieldsOnSubmit(){
var errMsg = "";
	if(document.getElementById('codeId').value == ""){
		errMsg += "Authorizer Code cannot be blank\n";
	}
	if(document.getElementById('nameId').value == ""){
		errMsg += "Authorizer Name cannot be blank\n";
	}
	if(document.getElementById('minAthId').value == ""){
		errMsg += "Max Authorize Amount cannot be blank\n";
	}
	if(document.getElementById('maxAthId').value == ""){
		errMsg += "Min Authorize Amount cannot be blank\n";
	}
	if(errMsg != ""){
		alert(errMsg);
		return false;
	}
return true;
}

</script>
