<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * department.jsp  
 * Purpose of the JSP -  This is for Department details 
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.16
--%>

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hrms.masters.business.MstrCode"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<style>

#contentspace label{
	text-align: right;
	padding-right: 10px;
	width: 130px;
	float: left;
	height: 9px;
}
</style>

<%
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	ArrayList<MstrCode> searchMstrCodeMasterList = (ArrayList)map.get("searchMstrCodeMasterList");
	String userName = "";
	Integer userId = 0;
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
	}

	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>
<div class="titleBg"><h2>Expense Head Master</h2></div>
<div class="clear"></div>
<div class="Block">	

	  <div id="searcharea">
	  
		  <div id="searchbar">
			   <form name="search" method="post" action="">
			    <label>Expense Code:</label>
			    	<input type="radio" name="<%=SELECTED_RADIO  %>" class="radioCheck"  value="1" checked="checked" />
					<label>Expense Head :</label>
					<input type="radio" name="<%=SELECTED_RADIO %>" class="radioCheck" value="2"  />
					
					 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Desc,string,no"   MAXLENGTH="8" tabindex=1  />
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','eTravelMaster?method=searchExpenseHead','checkSearch')" tabindex="1"  />

		     <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
	<div class="clear"></div>
    <div class="division"></div>				
	<jsp:include page="searchResultBlock.jsp" />
	<div class="clear"></div>
	<div id="searchresults" tabindex=2 >
	<div id="searchtable" tabindex=2 ></div>
	
	<% 
		if(searchMstrCodeMasterList.size()>0 )
		 {
			String strForCode = (String)map.get("expenseCode");
			String strForCodeDescription = (String)map.get("expenseDesc");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
	<br/>
                <a href="eTravelMaster?method=showExpenseHeadMasterJsp">Show All Records</a>
	<%
			}
		 }
	if(searchMstrCodeMasterList.size()==0 && map.get("search") != null)
	  {
    %>
				<a href="eTravelMaster?method=showExpenseHeadMasterJsp">Show All Records</a>

    <%
           }
         %>

	<script type="text/javascript">
	
	formFields = [
			[0, "<%=COMMON_ID%>", "id"], [1,"<%=CODE%>"], [2,"<%=SEARCH_NAME %>"], [3,"<%= COMMENTS %>"] ,[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"fiftyPercentExpnse"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script>
	</div>
	 <div class="clear"></div>
    <div class="division"></div>
   <div class="Block"> 
  <form name="hreTravelMaster" method="post" action="">
	  <input type="hidden" name="<%= POJO_NAME %>" value = "MstrCode"/>
	  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value = "CodeDesc"/>
	  <input type="hidden" name="title" value = "Department"/>
	  <input type="hidden" name="<%=JSP_NAME %>" value = "hreTravelMaster"/>
	  <input type="hidden" name="pojoPropertyCode" value = "ExpenseCode"/>
  
	  	
        <label><span>*</span>Expense Code</label>
	  	<input id="<%=CODE%>" type="text" name="<%=CODE%>" value="" 
	  			validate="Expense Code,string,yes" class="textbox_size20" MAXLENGTH="8" tabindex="1" />
	  			
  		<label ><span>*</span> Expense Head:</label>
		<input type="text" name="<%=SEARCH_NAME%>" value="" 
				validate="Expense Head,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex="1" />
		<script>
			document.hreTravelMaster.<%=CODE%>.focus();
		</script>
			<div class="clear"></div>
  		<label >Comments:</label>
		<input type="text" name="<%= COMMENTS %>" value="" 
				validate="Comments,string,no" class="textbox_size20" MAXLENGTH="220" tabindex="1" />
				<label>Fifty(%) Expense Paid</label>
<input  type="checkbox" name="fiftyPercentExpnse" value="" validate="Taxable Element,string,no"  tabindex=1 class="radioCheck" /></label>
				
			
 </div>
			<div class="clear"></div>
              <div class="division"></div>
				<div class="clear"></div>
			<div id="edited"></div>

			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('hreTravelMaster','eTravelMaster?method=addExpenseHead');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onClick="submitForm('hreTravelMaster','eTravelMaster?method=editExpenseHead')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate"  style="display: none;" class="button" onClick="submitForm('hreTravelMaster','eTravelMaster?method=deleteExpenseHead&flag='+this.value)" accesskey="d" tabindex=1/>		

			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			
            <div class="clear"></div>
            <div class="division"></div>
            <div class="clear"></div>
			<div class="bottom">
			<label>Changed By</label>   
			<label class="value"><%=userName%></label>
			        
			<label>Changed Date</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userId%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   </div>	
		
	      
		
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			
			
	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Expense Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Expense Head"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Comments"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%=COMMENTS%>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "fiftyPercentExpnse";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_arr = new Array();

<%
int  counter=0;

for(MstrCode mstrCode : searchMstrCodeMasterList) {
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= mstrCode.getId()%>

<%if(mstrCode.getExpenseCode() != null){%>
	data_arr[<%= counter%>][1] = "<%= mstrCode.getExpenseCode() %>";
<%}else{%>
	data_arr[<%= counter%>][1] = "";
<%}%>            

<%if(mstrCode.getCodeDesc() != null){%>
	data_arr[<%= counter%>][2] = "<%= mstrCode.getCodeDesc() %>";
<%}else{%>
	data_arr[<%= counter%>][2] = "";
<%}%>            

<%if(mstrCode.getCodeRemarks() != null){%>
	data_arr[<%= counter%>][3] = "<%= mstrCode.getCodeRemarks() %>";
<%}else{%>
	data_arr[<%= counter%>][3] = "";
<%}%>            

<%if(mstrCode.getLastChgBy() != null){%>
	data_arr[<%= counter%>][4] = "<%= mstrCode.getLastChgBy().getId() %>";
<%}else{%>
	data_arr[<%= counter%>][4] = "";
<%}%>            

<%if(mstrCode.getLastChgDate() !=null) {%>
	data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(mstrCode.getLastChgDate()) %>";
<%}else{%>
	data_arr[<%= counter%>][5] = "";
<%}%>

<%if(mstrCode.getLastChgTime() !=null) {%>
	data_arr[<%= counter%>][6] = "<%=mstrCode.getLastChgTime() %>";
<%}else{%>
	data_arr[<%= counter%>][6] = "";
<%}%>

<%if(mstrCode.getFiftyPercentExpensePaid()!=null) {%>
	data_arr[<%= counter%>][7] = "<%=mstrCode.getFiftyPercentExpensePaid() %>";
<%}else{%>
	data_arr[<%= counter%>][7] = "";
<%}%>

<%if(mstrCode.getStatus()!=null && mstrCode.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][8] = "Active";
<%}else{%>
	data_arr[<%= counter%>][8] = "InActive";
<%}%>
<%
		     counter++;
}
%>
 
formName = "hreTravelMaster"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  