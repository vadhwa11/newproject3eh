<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * country.jsp  
 * Purpose of the JSP -  This is for Country Details.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.15  
--%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.FaMasSubLed"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBlock"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>

<form name="accountSubLedger" method="post" action="">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	
	List<FaMasAccountGroup> districtList = new ArrayList<FaMasAccountGroup>();
	List<Object[]> growerList = new ArrayList<Object[]>();
	districtList = (ArrayList)map.get("accGrpList");
	
	List<FaMasAccountSubGroup> subAccGrpList = new ArrayList<FaMasAccountSubGroup>();
	subAccGrpList = (ArrayList)map.get("subAccGrpList");
List<MasHospital>hospitalList=new ArrayList<MasHospital>();
if(map.get("hospitalList")!=null){
	hospitalList=(List<MasHospital>)map.get("hospitalList");
}
	List<FaMasAccount> accList = new ArrayList<FaMasAccount>();
	accList = (ArrayList)map.get("accList");
	
	ArrayList searchBlockList = (ArrayList)map.get("gridAccGrpList");
	ArrayList gridDistrictList = (ArrayList)map.get("gridaccList");
	ArrayList gridAccounsubLed = (ArrayList)map.get("subLedList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println("<h4>"+message+"</h4>");
		  }
	String unitType="";
	if(session.getAttribute("unitType")!=null){
		unitType=(String)session.getAttribute("unitType");
	}
	String accountGroupName="";

	if(map.get("accountGroupName") != null){
		accountGroupName = (String)map.get("accountGroupName");
		  
		  }
	
	if(map.get("growerList") != null){
		growerList = (List<Object[]>)map.get("growerList");
		  
		  }
	List<MasEmployee>employeeListJphn=new ArrayList<MasEmployee>();
	List<MasEmployee>employeeListJhi=new ArrayList<MasEmployee>();
	if(map.get("employeeListJphn")!=null){
		employeeListJphn=(List<MasEmployee>)map.get("employeeListJphn");
	}
	if(map.get("employeeListJhi")!=null){
		employeeListJhi=(List<MasEmployee>)map.get("employeeListJhi");
	}
	
 %>
<div class="titleBg">
<h2>Account Sub Ledger</h2>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<input type="radio" name="<%=SELECTED_RADIO %>" value="1" checked="checked"	class="inputRadiobutton" />
<label>Code</label>
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="inputRadiobutton" />
<label>Name</label>
<input type="text" id="searchField" name="<%=SEARCH_FIELD %>" value="" validate="Code,string,no" maxlength="15" tabindex=1 onkeypress="return submitenter(this,event,'account?method=searchTitle')" />
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('accountSubLedger','account?method=searchAccountSubLedger','checkSearch')" tabindex=1 />
<input type="button" name="Report" value="Generate Report" class="buttonBig" onclick="submitForm('accountSubLedger','account?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_fa_acc_sub_ledger"/>

</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% System.out.println("accountGroupName==============>"+accountGroupName);
	if(searchBlockList != null && accountGroupName!=null && !accountGroupName.equals(""))
	{%>
		 <h4><a href="account?method=showAccountSubGroup">Show All Records</a></h4>
<% } else { %>
		<%-- <h4><a href="account?method=showAccountSubGroup">Show All Records</a></h4> --%>
		 <%} %>
 <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= ACCOUNT_GROUP_ID %>"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div><div class="clear"></div>
	
<form name="block" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasBlock"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="BlockName">
<input type="hidden" name="title" value="Block"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="block"> 
<input	type="hidden" name="pojoPropertyCode" value="BlockCode"> 
<div class="Block">
<label>Main Account<span>*</span></label>
<select id="mainAccountId"  name="<%=ACCOUNT_ID %>" validate="Main Account ,string,no" onchange="checkForSubLedger(this.value);">
	<option value="0">Select</option>
	<%if(accList.size()>0){
		for(FaMasAccount faMasAccount :accList){
		%>
		<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>
	<%}
		}%>
</select>

<label><span>*</span>Sub Ledger Code:</label>

<input id="subLedgerCodeId" type="text" name="<%= CODE %>" value="" validate="Sub LedgerCode,alphanumeric,yes" MAXLENGTH="45" tabindex=1 />
<div id="slNameDiv" style="display: inline;">
<label><span>*</span>Sub Ledger Name:</label>
<input id="subLedgerId" type="text" name="<%= SEARCH_NAME %>" value="" validate="Sub Ledger,alphanumeric,no" MAXLENGTH="45" tabindex=1 />
</div>
<div id="employeeSlNameDiv" style="display: none;">
<label><span>*</span>Sub Ledger Name:</label>
<select id="subLedgerId" type="text" name="fname11" value="" validate="Sub Ledger,alphanumeric,no" MAXLENGTH="45" tabindex=1 >
<option value="0">Select</option>
<%for(MasEmployee me:employeeListJphn){if(me.getFirstName()!=null ) %>
<option value="<%=me.getId()%>"><%=me.getFirstName()%></option>
<%} %>
</select>

</div>
<div id="employeeSlNameDiv2" style="display: none;">
<label><span>*</span>Sub Ledger Name:</label>
<select id="subLedgerId" type="text" name="<%= EMPLOYEE_ID %>" value="" validate="Sub Ledger,alphanumeric,no" MAXLENGTH="45" tabindex=1 >
<option value="0">Select</option>
<%for(MasEmployee me:employeeListJhi){if(me.getFirstName()!=null ) %>
<option value="<%=me.getId()%>"><%=me.getFirstName()%></option>
<%} %>
</select>

</div>


<%--

<label> Group Name<span>*</span></label>
<select id="accountGroupId" name="<%=ACCOUNT_GROUP_ID %>" validate="Account Group,string,no" onChange="populateSubGroup(this.value,'accountSubLedger')" >
	<option value="0">Select</option>
	<%if(districtList.size()>0){
		for(FaMasAccountGroup faMasAccountGroup :districtList){
		%>
		<option value="<%=faMasAccountGroup.getId() %>"><%=faMasAccountGroup.getAccountGroupDesc() %></option>
	<%}
		}%>
</select>

<script type="text/javascript">
          subGroupArray = new Array();
		<%
			int count = 0;
			for (FaMasAccountGroup faMasAccountGroup :districtList)
			{

				for (FaMasAccountSubGroup faMasAccountSubGroup :subAccGrpList)
				{

					if(faMasAccountGroup.getId().equals(faMasAccountSubGroup.getAccountGroup().getId())){
								%>
									subGroupArray[<%=count%>] = new Array();
									subGroupArray[<%=count%>][0] = <%=faMasAccountGroup.getId()%>;
									subGroupArray[<%=count%>][1] = <%=faMasAccountSubGroup.getId()%>;
									subGroupArray[<%=count%>][2] = "<%=faMasAccountSubGroup.getAccountSubGroupName()%>";

								<%
								count++;
						}	} } %>
		</script>
<div class="clear"></div>
<label> Sub Group<span>*</span> </label>
<select id="subGroupId" name="<%=ACCOUNT_SUB_GROUP_ID %>" validate="Account Sub Group,string,no" onchange="populateMainAccount(this.value,'accountSubLedger')"  >
	<option value="0">Select</option>
	<%if(subAccGrpList.size()>0){
		for(FaMasAccountSubGroup faMasAccountSubGroup :subAccGrpList){
		%>
		<option value="<%=faMasAccountSubGroup.getId() %>"><%=faMasAccountSubGroup.getAccountSubGroupName() %></option>
	<%}
		}%>
</select>

<script type="text/javascript">
          mainAccountArray = new Array();
		<%
			int count1 = 0;
		for (FaMasAccountSubGroup faMasAccountSubGroup :subAccGrpList)
			{

				for (FaMasAccount faMasAccount:accList)
				{

					if(faMasAccountSubGroup.getId().equals(faMasAccount.getAccountSubGroup().getId())){
								%>
									mainAccountArray[<%=count1%>] = new Array();
									mainAccountArray[<%=count1%>][0] = <%=faMasAccountSubGroup.getId()%>;
									mainAccountArray[<%=count1%>][1] = <%=faMasAccount.getId()%>;
									mainAccountArray[<%=count1%>][2] = "<%=faMasAccount.getAccDesc()%>";

								<%
								count1++;
						}	} } %>
		</script> --%>

<div class="clear"></div>

<%--<label>Select Grower Name </label>
		<select name ="ddlGrower" id="ddlGrower" validate="Grower,string,no"  >
		<option value="0">Select</option>
		
			<%
			    
				if(growerList.size()>0)
				{
					for(Object[] list : growerList)
					{
						%>
							<option value="<%=list[0]%>"><%=list[1]%></option>
						<%
					}
				}
			%> 
		</select> --%>
<label>Opening Balance</label>
<input type="text" name="openingBalance"  value="" id="openingBalanceId" MAXLENGTH="11"  />
<select name="accountTypeA" class="small" />
			<option value="Dr" selected="selected">Dr</option>
			<option value="Cr">Cr</option>
			</select>
			<%if(unitType.equals("HO")){ %>
			<label>Sub Ledger Type</label>
			<select name="subLedgerType" id="subLedgerTypeId" class="small" onchange="changeLocationSubLedger(this.value)" />
			<option value="I" selected="selected">Invidual</option>
			<option value="C">Consolidated</option>
			</select>
			<div id="hospitalId" style="display: none;">
			<label>Centre</label>
			<select name="centreName" id="centreId" >
<option value="0">Select</option>
			<%for(MasHospital mh:hospitalList){ %>
<option value="<%=mh.getId()%>"><%=mh.getHospitalName() %></option>			
<%} %>
			</select>
			</div>
			<%} %>
			<div class="clear"></div>
<div class="clear"></div>
<table id="branchDetails" style="display: none" ></table>
<input type="hidden" id="totalBranchId" name="totalBranchId"
	value="0" />
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>


<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('block','account?method=addAccountSubLedger');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('block','account?method=editAccountSubLedger')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('block','account?method=deleteAccountSubLedger&flag='+this.value)" accesskey="d" tabindex=1/>		

			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
			
</div>
<input type="hidden" name="<%=STATUS %>" value="" />
<input	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label>Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   </div>	
   <div id="edited"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<div class="clear"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Sub Led Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Sub Led Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Account  Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=ACCOUNT_GROUP_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_TIME %>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();
data_arr = new Array();

<%
Iterator itr=gridAccounsubLed.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  FaMasSubLed  hrInsuranceDetails = (FaMasSubLed)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrInsuranceDetails.getId()%>
data_arr[<%= counter%>][1] = "<%= hrInsuranceDetails.getSubLedCode()%>"
<%if(hrInsuranceDetails.getSubLedDesc()!=null && !hrInsuranceDetails.getSubLedDesc().equals("")){%>
	data_arr[<%= counter%>][2] = "<%= hrInsuranceDetails.getSubLedDesc()%>"
	<%}else if(hrInsuranceDetails.getEmployee()!=null ){%>
	data_arr[<%= counter%>][2] = "<%= hrInsuranceDetails.getEmployee().getFirstName()%>"
	<%}else{%>
	data_arr[<%= counter%>][2] = "--"
	<%}%>
		data_arr[<%= counter%>][3] = "<%=hrInsuranceDetails.getAccount().getAccDesc()%>"
            
            
            
            
		data_arr[<%= counter%>][4] = ""
			data_arr[<%= counter%>][5] = ""
				data_arr[<%= counter%>][6] = ""
<% if(hrInsuranceDetails.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "block"

nonEditable = ['<%=SEARCH_NAME%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>

<script>
function changeLocationSubLedger(val){
//	alert("val-------------------------------->>>>>"+val);
if(document.getElementById("subLedgerTypeId").value=='C'){
	document.getElementById("hospitalId").style.display="inline";
	} else if(document.getElementById("subLedgerTypeId").value=='I'){
	document.getElementById("hospitalId").style.display="none";
	}
}
</script>

<script>
function checkForSubLedger(value){
	if(value=='1712' ){
		document.getElementById("slNameDiv").style.display="none";
		document.getElementById("employeeSlNameDiv").style.display="inline";
		document.getElementById("employeeSlNameDiv2").style.display="none";
	}else if( value=='1713'){
		document.getElementById("slNameDiv").style.display="none";
		document.getElementById("employeeSlNameDiv2").style.display="inline";
		document.getElementById("employeeSlNameDiv").style.display="none";
	}else{
		document.getElementById("slNameDiv").style.display="inline";
		document.getElementById("employeeSlNameDiv2").style.display="none";
		document.getElementById("employeeSlNameDiv").style.display="none";
		
	}
}

</script>