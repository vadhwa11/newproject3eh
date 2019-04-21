<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * scheme.jsp  
 * Purpose of the JSP -  This is for Block Details.
 * @author  Mansi
 * @author  Vishal
 * @author  Amit
 * Create Date: 25th Aug, 2015 
 * Revision Date:      
 * Revision By: 
 * @version 1.11  
--%>


<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.FaSchemeAccountMapping"%>
<%@page import="jkt.hms.masters.business.FaMasAccount"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasScheme"%>


<%
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	
	List<MasScheme> masSchemeList = new ArrayList<MasScheme>();
	List<FaMasAccount> faMasAccountList = new ArrayList<FaMasAccount>();
	List<MasAdministrativeSex> masAdministrativeSexList = new ArrayList<MasAdministrativeSex>(); // Added by Amit Das 26-02-2016
	List<MasScheme> masSchemePriorityList = new ArrayList<MasScheme>(); // Added by Amit Das 26-05-2016
	String message = "";
	String userName = "";
	
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("masSchemeList") != null){
		masSchemeList = (ArrayList)map.get("masSchemeList");
	}
	if(map.get("faMasAccountList") != null){
		faMasAccountList = (ArrayList)map.get("faMasAccountList");
	}
	
	 // Added by Amit Das 26-02-2016
	if(map.get("masAdministrativeSexList") != null){
		masAdministrativeSexList = (ArrayList)map.get("masAdministrativeSexList");
	}
	
	 // Added by Amit Das 26-05-2016
	if(map.get("masSchemePriorityList") != null){
		masSchemePriorityList = (ArrayList)map.get("masSchemePriorityList");
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
<div class="Block">
<div class="Scheme">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Scheme Code </label>
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radiobutMargin" /> 
<label>Scheme Name</label> 
<input type="radio"	name="<%=SELECTED_RADIO %>" value="2" class="radiobutMargin" /> 


<input type="hidden" name="colCode" value="scheme_code">
<input type="hidden" name="colName" value="scheme_name">

<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Scheme Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'billingMaster?method=searchScheme')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','billingMaster?method=searchScheme','checkSearch')"	tabindex=1 />
 <input type="button" name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 /> <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_scheme">  
 

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
		if(masSchemeList.size() > 0)
		 {
			String strForCode = (String)map.get("schemeCode");
			String strForCodeDescription = (String)map.get("schemeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h4><a href="billingMaster?method=showSchemeJsp">Show All Records </a></h4>

<%
			}
		 }
	 if(masSchemeList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="billingMaster?method=showSchemeJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">

	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%=CHANGED_BY%>"], [4,"<%=CHANGED_DATE%>"],[5,"<%=CHANGED_TIME%>"],[6,"<%=STATUS%>"],[7,"letterFlag"],[8,"schemeType"],[9,"accountId"], [10,"genderId"], [11,"priority"], [12,"fromAge"], [13,"toAge"], [14,"fromAgeUnit"], [15,"toAgeUnit"], [16,"patientStatus"], [17,"limit"]];	 
		 statusTd = 6;
	</script></div>

<form name="scheme" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
<input type="hidden" name="<%= POJO_NAME %>" value="MasScheme"> 
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="SchemeName">
<input type="hidden" name="title" value="Scheme"> 
<input	type="hidden" name="<%=JSP_NAME %>" value="scheme"> 
<input	type="hidden" name="pojoPropertyCode" value="SchemeCode">
<div class="paddingTop5"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span> Scheme Code </label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Scheme Code,string,yes" class="textbox_size20" MAXLENGTH="8"	tabindex=1 /> 

<label><span>*</span> Scheme Name </label> 
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Scheme  Name,string,yes" class="textbox_size20" MAXLENGTH="120" tabindex=1 />

<label>Letter</label>
<input id="letterFlag" name="letterFlag" type="radio" value="Y" class="checkbox"/>

<div class="clear"></div>
<label>Type</label>
<select name="schemeType" id="schemeType">
<option value="">Select</option>
<option value="GOI">GOI</option>
<option value="GOK">GOK</option>
</select>


<script>
 		document.scheme.<%=CODE%>.focus();
</script>
<label>Account</label>
<select id="accountId"	name="accountId" multiple="multiple" class="multiple1" size="5">
			<%
				for (FaMasAccount  faMasAccount : faMasAccountList){
			  %>
			<option value="<%=faMasAccount.getId()%>"><%=faMasAccount.getAccDesc()%></option>
			<%}%>
</select>
		<div class="clear"></div>
		<label>Funding Agency<span> *</span> </label>
		<select name="fundedBy" id="fundedBy" validate="Funding Agency,string,yes">
<option value="">Select</option>
<option value="NHM">NHM</option>
<option value="HMC">HMC</option>
<option value="DHS">DHS</option>
</select>

 <!-- Added by Amit Das 26-02-2016 -->
<label>Gender</label>
<select id="genderId"	name="genderId">
			<option value="0">Select</option>
			<%
				for (MasAdministrativeSex masAdministrativeSex :  masAdministrativeSexList){
			  %>
			<option value="<%=masAdministrativeSex.getId()%>"><%=masAdministrativeSex.getAdministrativeSexName()%></option>
			<%}%>
</select>

<!-- Added by Amit Das 26-02-2016 -->
<label>Priority</label>
<select id="priority"	name="priority" >
	<option value="0">Select</option>
	<% 
	boolean priorityFlag = true;
	for(int i=1; i<=30; i++){ 
		for(MasScheme scheme : masSchemePriorityList){
			if(scheme.getPriority()!=null && scheme.getPriority()==i){
				priorityFlag = false;
				break;
			}
		}
		if(priorityFlag){
	%>
	<option value="<%=i%>"><%=i%></option>
	<% } 
	priorityFlag =true;	
	}%>
		
</select>



<div class="clear"></div>
<!-- Added by Amit Das 26-02-2016 -->
<div id="ageDiv">
<label id="fromAgelabel"> From Age</label>
<input type="text" name="fromAge" id="fromAge" class="inputSmall" maxlength="3" tabindex="1" validate="From Age,int,no" />
<select id="fromAgeUnit" name="fromAgeUnit" validate="From AgeUnit,string,no" tabindex="1" class="small_age" >
	<option value="Year">Year</option>
	<option value="Month">Month</option>
	<option value="Day">Day</option>
</select> 
<label id="toAgeLabel" > To Age</label>
<input type="text" name="toAge" id="toAge" class="inputSmall" maxlength="3" tabindex="1" validate="To Age,int,no" /> 
<select id="toAgeUnit" name="toAgeUnit" validate="To AgeUnit,string,no" tabindex="1" class="small_age" >
	<option value="Year">Year</option>
	<option value="Month">Month</option>
	<option value="Day">Day</option>
</select>
</div>
 <!-- Added by Amit Das 26-02-2016 -->
<label>Patient Type</label>
<select id="patientStatus"	name="patientStatus" >
		<option value="0">Select</option>
		<option value="IP">In Patient</option>
		<option value="OP">Out Patient</option>
		
</select>

<div class="clear"></div>
<!-- Added by Amit Das 02-03-2016 -->
<label>Limit</label>
<input type="text" name="limit" id="limit" class="textbox_size20" maxlength="8" tabindex="1" validate="Limit,int,no" /> 

<!-- Added by Amit Das 07-03-2016 -->
<label>Package</label>
<input id="pkgFlag" name="pkgFlag" type="checkbox" value="y" class="checkbox"/> 

<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onclick="submitForm('scheme','billingMaster?method=addScheme');" accesskey="a" tabindex=1 /> 
<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;" onclick="submitForm('scheme','billingMaster?method=editScheme')" accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" style="display: none;" onclick="submitForm('scheme','billingMaster?method=deleteScheme&flag='+this.value)" accesskey="d" tabindex=1 /> 
<input type="reset"  name="Reset" id="reset" value="Reset" class="buttonHighlight" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden" name="<%=STATUS %>" value="" /> 
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
</div>

<div class="bottom">
<label>Changed By:</label> 
<label class="value"><%=userName%></label> 
<label>Changed Date:</label> 
<label class="value"><%=date%></label> 
<label>Changed Time:</label> 
<label class="value"><%=time%></label> 
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Scheme Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Scheme Name"
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
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_header[6] = new Array;
data_header[6][0] = "flag"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "letterFlag";

data_header[7] = new Array;
data_header[7][0] = "Type"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "schemeType";



data_header[8] = new Array;
data_header[8][0] = "Account"
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "accountId";

data_header[9] = new Array;
data_header[9][0] = "Gender"
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "genderId";

data_header[10] = new Array;
data_header[10][0] = "Priority"
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "priority";

data_header[11] = new Array;
data_header[11][0] = "FromAge"
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "fromAge";

data_header[12] = new Array;
data_header[12][0] = "ToAge"
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "toAge";


data_header[13] = new Array;
data_header[13][0] = "FromAgeUnit"
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "fromAgeUnit";

data_header[14] = new Array;
data_header[14][0] = "ToAgeUnit"
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "toAgeUnit";

data_header[15] = new Array;
data_header[15][0] = "PatientStatus"
data_header[15][1] = "hide";
data_header[15][2] = "15%";
data_header[15][3] = "patientStatus";

data_header[16] = new Array;
data_header[16][0] = "Limit"
data_header[16][1] = "hide";
data_header[16][2] = "15%";
data_header[16][3] = "limit";


data_arr = new Array();

<%
Iterator itr=masSchemeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasScheme  masScheme = (MasScheme)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masScheme.getId()%>
data_arr[<%= counter%>][1] = "<%=masScheme.getSchemeCode()%>"
data_arr[<%= counter%>][2] = "<%= masScheme.getSchemeName()%>"





 data_arr[<%= counter%>][3] = "<%= masScheme.getLastChgBy()!=null?(masScheme.getLastChgBy().getId()!=null?masScheme.getLastChgBy().getId():"0" ):"0"%>"
	data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masScheme.getLastChgDate()) %>"
	data_arr[<%= counter%>][5] = "<%= masScheme.getLastChgTime() %>"
<% if(masScheme.getStatus().equalsIgnoreCase("Y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>

<% if(masScheme.getLetterFlag() !=null && masScheme.getLetterFlag().equalsIgnoreCase("Y")){
	%>
data_arr[<%= counter%>][7] = "Y"
<%}else{%>
data_arr[<%= counter%>][7] = "N"
<%}%>
<% if(masScheme.getSchemeType()!=null){ %>
data_arr[<%= counter%>][8] = "<%= masScheme.getSchemeType()%>"
<%}else{%>
data_arr[<%= counter%>][8] = "-"
<%}%>



<% 
Set<FaSchemeAccountMapping> schemeAccountMappingSet = new HashSet<FaSchemeAccountMapping>();
if(masScheme.getFaSchemeAccountMappings() != null){
	schemeAccountMappingSet  =masScheme.getFaSchemeAccountMappings();
}
String tempValue = "";
if(schemeAccountMappingSet.size()>0){
	for(FaSchemeAccountMapping schemeAccountMapping :schemeAccountMappingSet){
		if(!tempValue.equals("")){
			tempValue += ","+schemeAccountMapping.getAccount().getId();
	}else{
		tempValue += schemeAccountMapping.getAccount().getId();
	}
}
%>

data_arr[<%= counter%>][9] = "<%=tempValue%>"

data_arr[<%= counter%>][10] = "<%=(masScheme.getSex()!=null)?masScheme.getSex().getId():0%>"
		
data_arr[<%= counter%>][11] = "<%=(masScheme.getPriority()!=null)?masScheme.getPriority():0%>"

data_arr[<%= counter%>][12] = "<%=(masScheme.getFromAge()!=null)?masScheme.getFromAge().intValue():""%>"
		
data_arr[<%= counter%>][13] = "<%=(masScheme.getToAge()!=null)?masScheme.getToAge().intValue():""%>"

data_arr[<%= counter%>][14] = "<%=(masScheme.getFromAgeUnit()!=null)?masScheme.getFromAgeUnit():"Year"%>"
		
data_arr[<%= counter%>][15] = "<%=(masScheme.getToAgeUnit()!=null)?masScheme.getToAgeUnit():"Year"%>"
		
data_arr[<%= counter%>][16] = "<%=(masScheme.getPatientStatus()!=null)?masScheme.getPatientStatus():0%>"

data_arr[<%= counter%>][17] = "<%=(masScheme.getAmountLimit()!=null)?masScheme.getAmountLimit():"-"%>"

	<%}


		     counter++;
}
%>
 
formName = "scheme"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
