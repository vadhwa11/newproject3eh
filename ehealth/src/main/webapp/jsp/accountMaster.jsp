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
<%@page import="jkt.hms.masters.business.FaAccountHospitalTypeMapping"%>
<%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasAccountSchedule"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@page import="jkt.hms.masters.business.FaMasAccountSubGroup"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBlock"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<script type="text/javascript" language="javascript"	src="/erp/jsp/js/ajax.js"></script>
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
	List<FaMasAccountGroup> districtList = new ArrayList<FaMasAccountGroup>();
	List<MasAccountSchedule> scheduleList = new ArrayList<MasAccountSchedule>();
	List<MasHospitalType> hospitalTypeList = new ArrayList<MasHospitalType>();
	if(map.get("gridMasAccountGroupList")!=null){
	districtList = (ArrayList)map.get("gridMasAccountGroupList");
	}
	if(map.get("scheduleList")!=null){
		scheduleList = (ArrayList)map.get("scheduleList");
		}
	List<FaMasAccountSubGroup>gridMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();
	if(map.get("gridMasAccountSubGroupList")!=null){
	gridMasAccountSubGroupList = (ArrayList)map.get("gridMasAccountSubGroupList");
	}
	//System.out.println("size===>>"+gridMasAccountSubGroupList.size());
	List<FaMasAccount>faMasAccountList=new ArrayList<FaMasAccount>();
	List<FaMasAccountSubGroup>faMasAccountSubGroupList=new ArrayList<FaMasAccountSubGroup>();
	faMasAccountSubGroupList = (List<FaMasAccountSubGroup>)map.get("faMasAccountSubGroupList");
	List<FaMasAccountGroup> gridDistrictList =new ArrayList(); 
	if(map.get("gridMasAccountGroupList")!=null){
		gridDistrictList =(ArrayList)map.get("gridMasAccountGroupList");
	}
	if(map.get("faMasAccountList")!=null){
		faMasAccountList=(List<FaMasAccount>)map.get("faMasAccountList");
	}
	if(map.get("hospitalTypeList")!=null){
		hospitalTypeList=(List<MasHospitalType>)map.get("hospitalTypeList");
	}
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println("<h4>"+message+"</h4>");
		  }
	
	String accountGroupName="";

	if(map.get("accountGroupName") != null){
		accountGroupName = (String)map.get("accountGroupName");
		  
		  }
 %>
<div class="titleBg">
<h2>Account  Master</h2>
</div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">

<label>Account Code</label> 
<input type="radio"	class="inputRadiobutton" name="<%=SELECTED_RADIO  %>" value="1"  checked="checked" /> 

<label>Account Name</label> 
<input type="radio"	class="inputRadiobutton" name="<%=SELECTED_RADIO %>" value="2"  checked="checked" />

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>"	value="" validate="Account Sub Group Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'masters?method=searchBlock')" />

<input type="hidden" name="colCode" value="block_code">
<input type="hidden" name="colName" value="block_name">
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','account?method=searchAccountMaster','checkSearch')"	tabindex=1 />

 <%--- Report Button  
<input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','masters?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_block">
 --%> 

	<input type="button" name="Report" value="Generate Report" class="buttonBig" onclick="submitForm('search','account?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
<input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_fa_acc_sub_group"/>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% System.out.println("accountGroupName==============>"+accountGroupName);
	if(faMasAccountList != null && !faMasAccountList.equals(""))
	 { %>
<div class="Block">
<h4><a href="account?method=showAccountMasterJsp">Show All Records</a></h4>
<% } else { %>
		<%-- <h4><a href="account?method=showAccountSubGroup">Show All Records</a></h4> --%>
		 <%} %>
 <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= DISTRICT_ID %>"], [4,"subGroupName"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"],[9,"parentStatus"],[10,"mainAccountId"],[11,"subLedgerStatus"],[12,"scheduleDr"],[13,"accountRight"],[14,"scheduleCr"],[15,"hospitalTypeId"] ];
	 statusTd = 8;
	</script></div>
<form name="accountMaster" method="post" action="">
<div class="Block">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasBlock"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="BlockName">
<input type="hidden" name="title" value="Block"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="block"> 
<input	type="hidden" name="pojoPropertyCode" value="BlockCode"> 
<label> Account Code <span>*</span></label> 
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Account Sub Group Code,alphanumeric,yes" class="textbox_size20" MAXLENGTH="8"  tabindex=1> 
<label> Account Name<span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value=""	validate="Account Sub Group Name,String,yes" class="textbox_size20"	MAXLENGTH="100"  tabindex=1> 
<script>
				document.accountMaster.<%=CODE%>.focus();
			</script> 
<label> Account Group Name <span>*</span></label>
<select name="<%= DISTRICT_ID %>" id="agnId" validate="Account Group Name ,alphanumeric,yes" tabindex=1 onChange="populateSubGroup(this.value,'accountMaster')"  onkeypress="return submitenter(this,event,'masters?method=addCountry')">
<option value="0">Select</option>
	<% 
	for (FaMasAccountGroup  masDistrict : districtList){
		System.out.println("FaMasAccountGroup         "+masDistrict.getAccountGroupDesc());
				%>
	<option value="<%=masDistrict.getId ()%>"><%=masDistrict.getAccountGroupDesc()%></option>
	<%}%>
</select>
<div class="clear"></div>
<label> Account Sub Group Name <span>*</span></label>
<select name="subGroupName" validate="Account Group Name ,alphanumeric,yes" id="subGroupId" tabindex=1 onkeypress="return submitenter(this,event,'masters?method=addCountry')">
<option value="0">Select</option>
	<% 
	for (FaMasAccountSubGroup  masDistrict : faMasAccountSubGroupList){
				%>
	<option value="<%=masDistrict.getId ()%>"><%=masDistrict.getAccountSubGroupName()%></option>
	<%}%>
</select>
<div id="parentDiv" style="display: inline;">
<label> Parent Required</label>
<input id="parentStatusId" type="checkbox" name="parentStatus" value="y" validate="Parent Required,alphanumeric,no" tabindex=1 class="radioCheck" onchange="displayMainAcc();" onclick="displayMainAcc();" />
<div id="mainAccountDiv" style="display: none;">
<label> Main Account</label>
<select id="mainAccountId" name="<%=ACCOUNT_ID %>" validate="Account Type,alphanumeric,no"  >
	<option value="0">Select</option>
	<%if(faMasAccountList.size()>0){
		for(FaMasAccount faMasAccount :faMasAccountList){
		%>
		<option value="<%=faMasAccount.getId() %>"><%=faMasAccount.getAccDesc() %></option>
	<%}
		}%>
</select>
</div>
<div class="clear"></div>
<label> SL Required</label>
<input id="subLedgerId" type="checkbox" name="subLedgerStatus" value="y" validate="SL Required,alphanumeric,no" tabindex=1 class="inputRadiobutton" />
<%--<label>Opening Balance</label>
<input type="text" id="openingBalanceId" name="openingBalance" value=""  MAXLENGTH="11"   />
<select name="accountTypeA" class="small" />
			<option value="0">Select</option>
			<option value="Dr" selected="selected">Dr</option>
			<option value="Cr">Cr</option>
			</select> 
<div class="clear"></div>

<div id="bankDiv" style="display: none">
<label>Bank Name</label>
<select id="bankId" name="bankId" validate="Bank Name,string,no"  />
	<option value="0">Select</option>
	
</select>--%>
<label>Schedule(Dr)</label>
<select id="scheduleDrId" name="scheduleDr" validate="Schedule,string,no" >
	<option value="0">Select</option>
	<%
	if(scheduleList.size()>0){
	 for(MasAccountSchedule scheduleDr : scheduleList){ %>
	<option value="<%=scheduleDr.getId() %>"><%=scheduleDr.getScheduleName() %></option>
	<%} }%>
</select>
<label>Schedule(Cr)</label>
<select id="scheduleCrId" name="scheduleCr" validate="Schedule,string,no" >
	<option value="0">Select</option>
	<%
	if(scheduleList.size()>0){
	 for(MasAccountSchedule scheduleCr : scheduleList){ %>
	<option value="<%=scheduleCr.getId() %>"><%=scheduleCr.getScheduleName() %></option>
	<%} }%>
</select>


<label>Account Rights</label>
<select name="accountRight">
<option value="AL">All</option>
<option value="CN">Centres</option>
<option value="HO">HO</option>
</select>
</div>
<label>Hospital Type</label> 
<select name="hospitalTypeId" id="hospitalTypeId" tabindex=1 multiple="multiple" class="multiple1" size="5">
	<%
		for (MasHospitalType masHospitalType : hospitalTypeList) {
	%>
	<option value="<%=masHospitalType.getId()%>"><%=masHospitalType.getHospitalTypeName()%></option>
	<%
		}
	%>

	
</select>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div style="display: none;" id="edited"></div>
<input type="button" name="Submit11" id="addbutton" value="Add" class="button" onClick="submitForm('accountMaster','account?method=addAccountMaster','validateAccountMasterField');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" style="display: none" class="button" onClick="submitForm('accountMaster','account?method=editAccountMaster')"	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" style="display: none" class="button"	onClick="submitForm('accountMaster','account?method=deleteAccountSubGroupNew&flag='+this.value)"	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="submitFormForButton('search','account?method=showAccountMasterJsp')" accesskey="r" />
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
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
</div>	
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">	
</form>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Account Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Account Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Account Group Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=DISTRICT_ID %>";

data_header[3] = new Array;
data_header[3][0] = "Account Sub Group Name"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "subGroupName"

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
data_header[6][3] = "<%= CHANGED_TIME %>"

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";

data_header[8] = new Array;
data_header[8][0] = "Parent Required"
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "parentStatus";

data_header[9] = new Array;
data_header[9][0] = "Main Account"
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "accountId";

data_header[10] = new Array;
data_header[10][0] = "SL Required"
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "subLedgerId";

data_header[11] = new Array;
data_header[11][0] = "scheduleDr"
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "scheduleDr";

data_header[12] = new Array;
data_header[12][0] = "Account Rights"
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "accountRight";


data_header[13] = new Array;
data_header[13][0] = "scheduleCr"
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "scheduleCr";

data_header[14] = new Array;
data_header[14][0] = "hospitalTypeId"
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "hospitalTypeId";



data_arr = new Array();

<%

if(faMasAccountList != null)
{
Iterator itr=faMasAccountList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             FaMasAccount  masBlock = (FaMasAccount)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masBlock.getId()%>
data_arr[<%= counter%>][1] = "<%=masBlock.getAccCode()%>"
	data_arr[<%= counter%>][2] = "<%= masBlock.getAccDesc()%>"
		
			<%
			Iterator itrGridDistrictList=gridDistrictList.iterator();
			 while(itrGridDistrictList.hasNext())
	            {
				 try{
	             FaMasAccountGroup  districtGrid = (FaMasAccountGroup)itrGridDistrictList.next(); 
				 if(masBlock.getAccountSubGroup().getAccountGroup().getId().equals(districtGrid.getId()) && districtGrid.getStatus().equals("y")){%>
					data_arr[<%= counter%>][3] = "<%=districtGrid.getAccountGroupDesc()%>"
				<%}else if(masBlock.getAccountSubGroup().getId().equals(districtGrid.getId()) && districtGrid.getStatus().equals("n")){%>
					data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=districtGrid.getAccountGroupDesc()%>";
					
				<%}
	            }catch(Exception e){}}%>
	            
	            <%
				Iterator itrGridSubGroup1=gridMasAccountSubGroupList.iterator();
				 while(itrGridSubGroup1.hasNext())
		            {
					 try{
		             FaMasAccountSubGroup  subGroup = (FaMasAccountSubGroup)itrGridSubGroup1.next(); 
					 if(masBlock.getAccountSubGroup().getId().equals(subGroup.getId()) && subGroup.getStatus().equals("y")){%>
						data_arr[<%= counter%>][4] = "<%=subGroup.getAccountSubGroupName()%>"
					<%}else if(masBlock.getAccountSubGroup().getId().equals(subGroup.getId()) && subGroup.getStatus().equals("n")){%>
						data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=subGroup.getAccountSubGroupName()%>";
						
					<%}
		            }catch(Exception e){}}%>
	            
	            
	            
	                 
	            
            data_arr[<%= counter%>][5] = "<%= masBlock.getLastChgBy()!=null?(masBlock.getLastChgBy().getId()!=null?masBlock.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masBlock.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masBlock.getLastChgTime() %>"
<% if(masBlock.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
data_arr[<%= counter%>][9] = "<%=masBlock.getParentStatus()%>"

	data_arr[<%= counter%>][10] = "<%=masBlock.getParent()!=null? masBlock.getParent().getId():""%>"
			
		data_arr[<%= counter%>][11] = "<%=masBlock.getSubLedger()%>"
		
			data_arr[<%= counter%>][12] = "<%=masBlock.getScheduleDr()!=null?masBlock.getScheduleDr().getScheduleName():""%>"
					
				data_arr[<%= counter%>][13] = "<%=masBlock.getAccountRight()%>"
				
					data_arr[<%= counter%>][14] = "<%=masBlock.getScheduleCr()!=null?masBlock.getScheduleCr().getScheduleName():""%>"
							
							
							<% 
							Set<FaAccountHospitalTypeMapping> accountMappingSet = new HashSet<FaAccountHospitalTypeMapping>();
							if(masBlock.getFaAccountHospitalTypeMappings() != null){
								accountMappingSet  =masBlock.getFaAccountHospitalTypeMappings();
							}
							String tempValue = "";
							if(accountMappingSet.size()>0){
								for(FaAccountHospitalTypeMapping accountMapping :accountMappingSet){
									if(!tempValue.equals("")){
										tempValue += ","+accountMapping.getHospitalType().getId();
								}else{
									tempValue += accountMapping.getHospitalType().getId();
								}
							}
							%>
					
						data_arr[<%= counter%>][15] = "<%=tempValue%>"
								<%}

		     counter++;
}
          }
%>
formName = "accountMaster"

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
function displayMainAcc(){	
if(document.getElementById("parentStatusId").checked==true){
	document.getElementById("mainAccountDiv").style.display="inline";
}else if(document.getElementById("parentStatusId").checked==false){
	document.getElementById("mainAccountDiv").style.display="none";
}
	
}


subGroupArray = new Array();
<%
	int count = 0;
	for (FaMasAccountGroup faMasAccountGroup :gridDistrictList)
	{

		for (FaMasAccountSubGroup faMasAccountSubGroup :gridMasAccountSubGroupList)
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