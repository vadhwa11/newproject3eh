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
<%@page import="jkt.hrms.masters.business.MstrStandardAllowance"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	ArrayList<MstrStandardAllowance> searchMstrStandardAllowanceList = (ArrayList)map.get("searchMstrStandardAllowanceList");
	List<MasRank> masRankList=new ArrayList<MasRank>();
	List<MasRankCategory> masRankCategoryList=new ArrayList<MasRankCategory>();
	List<MasCurrency> masCurrencyList=new ArrayList<MasCurrency>();
	List<MstrCode> expenseAndTripTypeList=new ArrayList<MstrCode>();

	String userName = "";
	Integer userId = 0;
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(session.getAttribute("userId") != null){
		userId = (Integer)session.getAttribute("userId");
	}
	if(map.get("masRankList") != null){
		masRankList = (List)map.get("masRankList");
	}
	if(map.get("masRankCategoryList") != null){
		masRankCategoryList = (List)map.get("masRankCategoryList");
	}
	if(map.get("masCurrencyList") != null){
		masCurrencyList = (List)map.get("masCurrencyList");
	}
	if(map.get("expenseAndTripTypeList") != null){
		expenseAndTripTypeList = (List)map.get("expenseAndTripTypeList");
	}
	
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
	}
%>
<div class="titleBg"><h2>Standard Allowance Master</h2></div>
<div class="clear"></div>
<div class="Block">	

	  <div id="searcharea">
	  
		  <div id="searchbar">
			   <form name="search" method="post" action="">
			    <label>Allowance Code:</label>
			    	<input type="radio" name="<%=SELECTED_RADIO  %>" class="radioCheck"  value="1" checked="checked" />
					<label>Allowance Desc :</label>
					<input type="radio" name="<%=SELECTED_RADIO %>" class="radioCheck" value="2"  />
					
					 <input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Desc,string,no"   MAXLENGTH="8" tabindex=1  />
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','eTravelMaster?method=searchStandardAllowance','checkSearch')" tabindex="1"  />

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
		if(searchMstrStandardAllowanceList.size()>0 )
		 {
			String strForCode = (String)map.get("standardAllowanceCode");
			String strForCodeDescription = (String)map.get("standardAllowanceDesc");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
	<br/>
                <a href="eTravelMaster?method=showStandardAllowanceMasterJsp">Show All Records</a>
	<%
			}
		 }
	if(searchMstrStandardAllowanceList.size()==0 && map.get("search") != null)
	  {
    %>
				<a href="eTravelMaster?method=showStandardAllowanceMasterJsp">Show All Records</a>

    <%
           }
         %>

	<script type="text/javascript">
	
	formFields = [
			[0, "<%=COMMON_ID%>", "id"], [1,"<%=CODE%>"], [2,"<%=SEARCH_NAME %>"], [3,"<%= DESIGNATION_ID %>"] ,[4,"<%= EXPENSE_TYPE%>"] ,[5,"<%=AMOUNT%>"] ,[6,"<%=STATUS%>"] ,[7,"<%=TRIP%>"] ,[8,"<%=CURRENCY_ID%>"],[9,"<%=DESIGNATION_TYPE_ID%>"],[10,"<%=DISTRICT_TYPE%>"]];
	 statusTd = 6;
	</script>
	</div>
	 <div class="clear"></div>
    <div class="division"></div>
   <div class="Block"> 
  <form name="hrStandardAllowance" method="post" action="">
	  <input type="hidden" name="<%= POJO_NAME %>" value = "MstrStandardAllowance"/>
	  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value = "AllowanceDesc"/>
	  <input type="hidden" name="title" value = "Standard Allowance"/>
	  <input type="hidden" name="<%=JSP_NAME %>" value = "hrStandardAllowance"/>
	  <input type="hidden" name="pojoPropertyCode" value = "AllowanceCode"/>
  
	  	
        <label>Allowance Code</label>
	  	<input id="<%=CODE%>" type="text" name="<%=CODE%>" value="" 
	  			validate="Allowance Code,string,no" class="textbox_size20" MAXLENGTH="8" tabindex="1" />
		<script>
			document.hrStandardAllowance.<%=CODE%>.focus();
		</script>
	  			
  		<label ><span>*</span> Allowance Desc</label>
		<input type="text" name="<%=SEARCH_NAME%>" value="" 
				validate="Allowance Desc,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex="1" />

		<label ><span>*</span>Designation Type:</label>
			<select name="<%=DESIGNATION_TYPE_ID%>" validate="Designation Type,string,yes"  onChange="populateDesignation(this.value,'hrStandardAllowance')" >
				<option value="">Select</option>
			  	<%for (MasRankCategory masRankCategory : masRankCategoryList){ %>
				  <option value="<%=masRankCategory.getId ()%>"><%=masRankCategory.getRankCategoryName()%></option>
			  	<%}%>
			</select>
		<div class="clear"></div>
		
		<label ><span>*</span>Designation:</label>
			<select  name="<%=DESIGNATION_ID%>" validate="Designation,string,yes" tabindex=1>
				<option value="">Select</option>
			  	<%for (MasRank masRank :masRankList){ %>
				  <option value="<%=masRank.getId ()%>"><%=masRank.getRankName()%></option>
			  	<%}%>
			</select>
<script type="text/javascript">
	<%
	int count=0;
	for (MasRankCategory masRankCategory :masRankCategoryList) 
	{
	for (MasRank masRank:masRankList) 
	{
	if(masRank.getRankName() != null){
	if(masRankCategory.getId().equals(masRank.getRankCategory().getId())){
	%>
	designationArr[<%=count%>] = new Array();
	designationArr[<%=count%>][0] = <%=masRankCategory.getId()%>;
	designationArr[<%=count%>][1] = <%=masRank.getId()%>;									
	designationArr[<%=count%>][2] = "<%=masRank.getRankName()%>";
	<%
	count++;
	}
	}
	}
	}
	%>
</script> 
		<label ><span>*</span>Expense Type:</label>
			<select name="<%=EXPENSE_TYPE%>" validate="Expense Type,string,yes" tabindex=1>
				<option value="">Select</option>
			  	<%for (MstrCode mstrCode : expenseAndTripTypeList){ 
			  		if(mstrCode.getCodeType().equalsIgnoreCase("ExpType")){%>
				  		<option value="<%=mstrCode.getId ()%>"><%=mstrCode.getCodeDesc()%></option>
			  		<%}
			  	}%>
			</select>


		<label ><span>*</span>Trip:</label>
			<select name="<%=TRIP%>" validate="Trip,string,yes" tabindex=1>
				<option value="">Select</option>
			  	<%for (MstrCode mstrCode : expenseAndTripTypeList){ 
			  		if(mstrCode.getCodeType().equalsIgnoreCase("trip")){%>
				  		<option value="<%=mstrCode.getId ()%>"><%=mstrCode.getCodeDesc()%></option>
			  		<%}
			  	}%>
			</select>
				<div class="clear"></div>
			
		<label ><span>*</span>Currency:</label>
			<select name="<%=CURRENCY_ID%>" validate="Currency,string,yes" tabindex=1>
				<option value="">Select</option>
			  	<%for (MasCurrency masCurrency : masCurrencyList){ %>
				  <option value="<%=masCurrency.getId ()%>"><%=masCurrency.getCurrencyCode()%></option>
			  	<%}%>
			</select>
		<label ><span>*</span>City Type:</label>
			<select name="<%=DISTRICT_TYPE %>" validate="District Type,string,yes" tabindex=1 >
			<option value="0">Select</option>
			<option value="m">Metro</option>
			<option value="n">NonMetro</option>
			  
			</select>
	
  		<label ><span>*</span> Amount</label>
		<input type="text" name="<%=AMOUNT%>" value="" 
				validate="Amount,string,yes" class="textbox_size20" MAXLENGTH="30" tabindex="1" />
				<div class="clear"></div>
				</div>
<div class="division"></div>
	<div class="clear"></div>			
			<div id="edited"></div>
		

			<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('hrStandardAllowance','eTravelMaster?method=addStandardAllowance');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('hrStandardAllowance','eTravelMaster?method=editStandardAllowance')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" 
				id="deletebutton" value="Activate" style="display: none;" class="button"
				onClick="submitForm('hrStandardAllowance','eTravelMaster?method=deleteStandardAllowance&flag='+this.value)" 
				accesskey="d" tabindex="1"/>		

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
			 
   </div>	
		
	        
			
		
			<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
	
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Allowance Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Allowance"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Level"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%=DESIGNATION_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Expense Type"
data_header[3][1] = "data";
data_header[3][2] = "25%";
data_header[3][3] = "<%=EXPENSE_TYPE%>";

data_header[4] = new Array;
data_header[4][0] = "Amount"
data_header[4][1] = "data";
data_header[4][2] = "25%";
data_header[4][3] = "<%=AMOUNT%>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_header[6] = new Array;
data_header[6][0] = "Trip"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=TRIP%>";

data_header[7] = new Array;
data_header[7][0] = "Currency"
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=CURRENCY_ID%>";

data_header[8] = new Array;
data_header[8][0] = "Currency"
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%=DESIGNATION_TYPE_ID%>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=DISTRICT_TYPE%>";

data_arr = new Array();

<%
int  counter=0;

for(MstrStandardAllowance mstrStandardAllowance : searchMstrStandardAllowanceList) {
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= mstrStandardAllowance.getId()%>

<%if(mstrStandardAllowance.getAllowanceCode() != null){%>
	data_arr[<%= counter%>][1] = "<%= mstrStandardAllowance.getAllowanceCode() %>";
<%}else{%>
	data_arr[<%= counter%>][1] = "";
<%}%>            

<%if(mstrStandardAllowance.getAllowanceDesc() != null){%>
	data_arr[<%= counter%>][2] = "<%= mstrStandardAllowance.getAllowanceDesc() %>";
<%}else{%>
	data_arr[<%= counter%>][2] = "";
<%}%>            

	<% for(MasRank masRank :masRankList) {
			if(mstrStandardAllowance.getRank().getId().equals(masRank.getId()) && masRank.getStatus().equals("y")) { %>
				data_arr[<%= counter%>][3] = "<%=masRank.getRankName()%>"
			<%} else if(mstrStandardAllowance.getRank().getId().equals(masRank.getId()) && masRank.getStatus().equals("n")) {%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masRank.getRankName()%>";
			<%}
       } %>		


	<% for(MstrCode mstrCode : expenseAndTripTypeList) {
		if(mstrCode.getCodeType().equalsIgnoreCase("ExpType")){
			if(mstrStandardAllowance.getExpenseType().getId() == mstrCode.getId() && mstrCode.getStatus().equals("y")) { %>
				data_arr[<%= counter%>][4] = "<%=mstrCode.getCodeDesc()%>"
			<%} else if(mstrStandardAllowance.getExpenseType().getId().equals(mstrCode.getId()) && mstrCode.getStatus().equals("n")) {%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=mstrCode.getCodeDesc()%>";
			<%}
		}
       } %>		


<%if(mstrStandardAllowance.getAmount() != null){%>
	data_arr[<%= counter%>][5] = "<%= mstrStandardAllowance.getAmount()%>";
<%}else{%>
	data_arr[<%= counter%>][5] = "";
<%}%>            

<%if(mstrStandardAllowance.getStatus()!=null && mstrStandardAllowance.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][6] = "Active";
<%}else{%>
	data_arr[<%= counter%>][6] = "InActive";
<%}%>
	
	<% for(MstrCode mstrCode : expenseAndTripTypeList) {
		if(mstrCode.getCodeType().equalsIgnoreCase("trip")){
			if(mstrStandardAllowance.getTrip().getId().equals(mstrCode.getId()) && mstrCode.getStatus().equals("y")) { %>
				data_arr[<%= counter%>][7] = "<%=mstrCode.getCodeDesc()%>"
			<%} else if(mstrStandardAllowance.getTrip().getId().equals(mstrCode.getId()) && mstrCode.getStatus().equals("n")) {%>
				data_arr[<%= counter%>][7] = "<font id='error'>*</font>Parent InActivated--<%=mstrCode.getCodeDesc()%>";
			<%}
		}
       } %>		
	<% for(MasCurrency masCurrency : masCurrencyList) {
			if(mstrStandardAllowance.getCurrency().getId().equals(masCurrency.getId()) && masCurrency.getStatus().equals("y")) { %>
				data_arr[<%= counter%>][8] = "<%=masCurrency.getCurrencyName()%>"
			<%} else if(mstrStandardAllowance.getCurrency().getId().equals(masCurrency.getId()) && masCurrency.getStatus().equals("n")) {%>
				data_arr[<%= counter%>][8] = "<font id='error'>*</font>Parent InActivated--<%=masCurrency.getCurrencyName()%>";
			<%}
       } %>		
       
       <% for(MasRank masRank :masRankList) {
			if(mstrStandardAllowance.getRank().getId().equals(masRank.getId()) && masRank.getStatus().equals("y")) { %>
				data_arr[<%= counter%>][9] = "<%=masRank.getRankCategory().getRankCategoryName()%>"
			<%} else if(mstrStandardAllowance.getRank().getId().equals(masRank.getId()) && masRank.getStatus().equals("n")) {%>
				data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=masRank.getRankCategory().getRankCategoryName()%>";
			<%}
       } 
       %>		
       <%
if(mstrStandardAllowance.getCityTypeFlag()!=null){
if(mstrStandardAllowance.getCityTypeFlag().equals("m")){%>
data_arr[<%= counter%>][10] = "Metro"
<%}else if(mstrStandardAllowance.getCityTypeFlag().equals("n")){%>
data_arr[<%= counter%>][10] = "NonMetro"
<%}}else{%>
data_arr[<%= counter%>][10] = "";
<%}%>
       
       
       
<%
		     counter++;
}
%>
 
formName = "hrStandardAllowance"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
	  