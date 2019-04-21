<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="jkt.hrms.masters.business.MstrSponsor"%>
<%@page import="jkt.hrms.masters.business.MstrTherapeutic"%>
<%@page import="jkt.hrms.masters.business.MstrProjecttype"%>
<%@page import="jkt.hrms.masters.business.MstrProjectStatus"%>
<%@page import="jkt.hrms.masters.business.MstrTrialphase"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>
<script type="text/javascript" language="javascript" src="../jsp/js/proto.js"></script>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject>projectList = new ArrayList<MstrProject>();
				List<MstrSponsor> sponsorList = new ArrayList<MstrSponsor>();
				List<MstrTherapeutic> therapeuticAreaList = new ArrayList<MstrTherapeutic>();
				List<MstrProjecttype> projectTypeList = new ArrayList<MstrProjecttype>();
				List<MstrProjectStatus> projectStatusList = new ArrayList<MstrProjectStatus>();
				List<MstrTrialphase> trialPhaseList = new ArrayList<MstrTrialphase>();
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("sponsorList")!= null){
					sponsorList = (List)map.get("sponsorList");
				}
				if(map.get("therapeuticAreaList")!= null){
					therapeuticAreaList = (List)map.get("therapeuticAreaList");
				}
				if(map.get("projectTypeList")!= null){
					projectTypeList = (List)map.get("projectTypeList");
				}
				if(map.get("projectStatusList")!= null){
					projectStatusList = (List)map.get("projectStatusList");
				}
				if(map.get("trialPhaseList")!= null){
					trialPhaseList = (List)map.get("trialPhaseList");
				}
				if(map.get("currencyList")!= null){
					currencyList = (List)map.get("currencyList");
				}
				String message = "";
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				
				
				
	%>
	

<script type="text/javascript">
	
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}
			
	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
	
</script>
<script type="text/javascript">
	function display(idvalue) {
	<%
	for(MstrProject mstrProject :projectList){
		int id = mstrProject.getId();
		
	%>
	if(idvalue == <%=id%> ){
      document.getElementById('sponsorId').value = '<%= mstrProject.getSponsor().getId() %>'
      document.getElementById('projctCodeId').value = '<%= mstrProject.getPrjCode() %>'
      document.getElementById('descId').value = '<%= mstrProject.getPrjDesc() %>'
      document.getElementById('protocolNoId').value = '<%= mstrProject.getPrjProtocalno() %>'
      document.getElementById('loiNoId').value = '<%= mstrProject.getPrjLoino() %>'
      document.getElementById('projectTypeId').value = '<%= mstrProject.getProjectType().getId() %>'
      document.getElementById('trialPhaseId').value = '<%= mstrProject.getTrialPhase().getId() %>'
      document.getElementById('projectstatusId').value = '<%= mstrProject.getProjectStatus().getId() %>'
   	   document.getElementById('currencyId').value = '<%= mstrProject.getCurrency().getId() %>'
       document.getElementById('thpId').value = '<%= mstrProject.getThp().getId() %>'
        
	
	}
<%
	}
	
%>

}
</script>

<div class="titleBg"> <h2>Project Creation</h2></div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Project Status</label>
<select  name="<%=SEARCH_PROJECT_STATUS_ID %>" validate="Project Status,string,no"  >
<option value="0">Select</option>
<%
	for(MstrProjectStatus mstrProjectStatus :projectStatusList){
%>
<option value="<%=mstrProjectStatus.getId() %>"><%=mstrProjectStatus.getPrjsName() %></option>
<%} %>
</select>
<label>Project Name</label>
<input type="text"  name="<%=SEARCH_PROJECT_NAME%>" value=""  validate="Payroll Description,string,no"   MAXLENGTH="20" tabindex=1/>
<div class="clear"></div>
<label>Protocol No</label>
<input type="text"  name="<%=SEARCH_PROTOCOL_NO%>" value=""  validate="Payroll Description,string,no"   MAXLENGTH="20" tabindex=1/>

<label>Project Code</label>
<input type="text"  name="<%=SEARCH_PROJECT_CODE%>" value=""  validate="Payroll Description,string,no"   MAXLENGTH="20" tabindex=1/>
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTracking?method=searchProjectCreation')" tabindex=1  />
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
if(map.get("search") != null)
{
%>
<a href="projectTracking?method=showProjectCreationJsp">Show All Records</a>

<%
}
%>
<script type="text/javascript">

formFields = [
[0, "<%= PROJECT_ID%>", "id"], [1,"<%=PROJECT_NAME%>"], [2,"<%= SPONSOR_ID %>"],[3,"<%=DESCRIPTION%>"],[4,"<%= PROJECT_CODE%>"],[5,"<%= PROTOCOL_NO%>"],[6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=LOI_NO%>"],
[10,"<%=PROJECT_TYPE_ID%>"],[11,"<%=PROJECT_TRIAL_PHASE_ID%>"],[12,"<%=PROJECT_STATUS_ID%>"],[13,"<%=BUDGET%>"],[14,"<%=CURRENCY_ID%>"],[15,"<%=START_DATE%>"],[16,"<%=END_DATE%>"],[17,"<%=LOI_DATE%>"],[18,"<%=PURCHASE_ORDER_NO%>"],[19,"<%=PURCHASE_ORDER_DATE%>"],[20,"<%=CONTRACT_NO%>"],[21,"<%=CONTRACT_DATE%>"]
,[22,"<%=BILLABLE%>"],[23,"<%=THP_ID%>"],[24,"<%=EXTENSION%>"],[25,"<%=STATUS%>"]];
statusTd = 25;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="projectCreation" method="post" action="" >

<div class="clear"></div>
<%
	if(message!= null){
%>
<h4><%=message %></h4>
<%} %>
<div class="clear"></div>
<input name="Submit" type="button" class="button" value="New" onclick="submitProtoAjax('projectCreation','projectTracking?method=insertNewProjectForAjax');"/>
<input name="ViewRequest" type="button"  class="button" value="Extension" onclick="submitProtoAjax('projectCreation','projectTracking?method=getExistingProjectListForAjax');"/>
<div class="clear"></div>

<div class="Block">
<label><span>*</span>Project Code </label>
<input type="text" id="projctCodeId"  name="<%=PROJECT_CODE %>"  disabled="disabled"  validate="Project Code,string,no"   maxlength="25" />
<label ><span>*</span>Protocol No. </label>
<input type="text" id="protocolNoId"  name="<%=PROTOCOL_NO %>"   validate="Protocol No,string,yes"   maxlength="20" />
<label><span>*</span>Project Name</label>
<div id="testDiv">
<input type="text" id="projectId"  name="<%=PROJECT_NAME %>"   validate="Project,string,yes"    />
</div>
<div class="clear"></div>
<label><span>*</span>Sponsor Name </label>
<select id="sponsorId" name="<%=SPONSOR_ID %>" validate="Sponsor,string,yes"  >
<option value="0">Select</option>
<%
	for(MstrSponsor mstrSponsor:sponsorList){
%>
<option value="<%=mstrSponsor.getId() %>"><%=mstrSponsor.getSponsorName() %></option>
<%} %>
</select>

<label>Description </label>
<input type="text" id="descId" name="<%=DESCRIPTION %>"   validate="Description,string,no"   maxlength="200" />
<label><span>*</span>Project Type</label>
<select  id="projectTypeId" name="<%=PROJECT_TYPE_ID %>" validate="Project Type,string,yes"  >
<option value="0">Select</option>
<%
	for(MstrProjecttype mstrProjecttype:projectTypeList){
%>
<option value="<%=mstrProjecttype.getId() %>"><%=mstrProjecttype.getProjectName() %></option>
<%} %>
</select>
<div class="clear"></div>
<label><span>*</span>Therapeutic Area </label>
<select id="thpId" name="<%=THP_ID %>" validate="Therapeutic Area,string,yes"  >
<option value="0">Select</option>
<%
	for(MstrTherapeutic mstrTherapeutic:therapeuticAreaList){
%>
<option value="<%=mstrTherapeutic.getId() %>"><%=mstrTherapeutic.getThpDesc() %></option>
<%} %>
</select>
<label><span>*</span>Trial Phase</label>
<select id="trialPhaseId" name="<%=PROJECT_TRIAL_PHASE_ID %>" validate="Trial Phase,string,yes" >
<option value="0">Select</option>
<%
	for(MstrTrialphase mstrTrialphase :trialPhaseList){
%>
<option value="<%=mstrTrialphase.getId() %>"><%=mstrTrialphase.getTrialPhaseName() %></option>
<%} %>
</select>
<label><span>*</span>Project Status</label>
<select id="projectstatusId" name="<%=PROJECT_STATUS_ID %>" validate="Project Status,string,yes"  >
<option value="0">Select</option>
<%
	for(MstrProjectStatus mstrProjectStatus :projectStatusList){
%>
<option value="<%=mstrProjectStatus.getId() %>"><%=mstrProjectStatus.getPrjsName() %></option>
<%} %>
</select>
<div class="clear"></div>
<label>LOI Date </label>
<input id="loiDateId" type="text"  name="<%=LOI_DATE %>" value="" class="date"  readonly="readonly" validate="LOI date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('loiDateId'),event)"/>
<label>LOI No. </label>
<input type="text" id="loiNoId"  name="<%=LOI_NO %>"   validate="LOI No,string,no"   maxlength="50" />

<label>Work Order Date </label>
<input id="purchaseDateId" type="text"  name="<%=PURCHASE_ORDER_DATE %>" value="" class="date"  readonly="readonly" validate="Purchase date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('purchaseDateId'),event)"/>
<div class="clear"></div>
<label>Work Order No </label>
<input type="text" id="purchaseOrderNoId"  name="<%=PURCHASE_ORDER_NO %>"   validate="PurchaseOrder No.,string,no"   maxlength="40" />

<label>Contract  No </label>
<input type="text" id="contractNoId" name="<%=CONTRACT_NO %>"   validate="Contract No,string,no"   maxlength="40" />

<label>Contract  Date </label>
<input id="contractDateId" type="text"  name="<%=CONTRACT_DATE %>" value="" class="date"  readonly="readonly" validate="Contract date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('contractDateId'),event)"/>
<div class="clear"></div>
<label>Budget </label>
<input type="text" id="budgetId"  name="<%=BUDGET %>"   validate="Budget,float,no"   maxlength="9" />
<label><span>*</span>Currency</label>
<select id="currencyId" name="<%=CURRENCY_ID %>" validate="Currency,string,yes"  >
<option value="0">Select</option>
<%
	for(MasCurrency masCurrency :currencyList){
%>
<option value="<%=masCurrency.getId() %>"><%=masCurrency.getCurrencyCode() %></option>
<%} %>
</select>
<label>Billable </label>
<input  type="checkbox" id="billableId" name="<%=BILLABLE%>"  value=""  class="radioCheck" />
<div class="clear"></div>
<label><span>*</span>Start Date </label>
<input id="startDateId" type="text"  name="<%=START_DATE %>" value="" class="date"  readonly="readonly" validate="Start date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('startDateId'),event)"/>

<label><span>*</span>End Date </label>
<input id="endDateId" type="text"  name="<%=END_DATE %>" value="" class="date"  readonly="readonly" validate="End date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('endDateId'),event)"/>
 <div id="exten" style="display: none;">
	 <label>Extension </label>
	<input  type="checkbox"  id= "extensionss" name="<%=EXTENSION%>"  value=""  class="radioCheck" />
 </div>

 <div class="clear"></div>
</div>

<div class="clear"></div>
<div class="division"></div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('projectCreation','projectTracking?method=saveProjectCreation');" accesskey="a" tabindex=1/>

<input type="button" name="edit" id="editbutton" value="Update" class="button" style="display: none;"  onClick="submitForm('projectCreation','projectTracking?method=updateProjectCreation');" accesskey="u" tabindex=1 />

<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;"  onClick="submitForm('projectCreation','projectTracking?method=deletePayroll&flag='+this.value)" accesskey="d" tabindex=1/>		

<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<div class="clear"></div>
<label>Last Changed By</label>
<label class="value"></label>

<label>Last Changed DATE</label>
<label class="value"><%=date%></label>

<label>Last Changed Time</label>
<label class="value"><%=time%></label>

</div>
		
			<input type="hidden" name="<%=CHANGED_BY%>" value="" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
		 <input type="hidden" name="<%=STATUS %>" value="" />	
			<input type="hidden" name="<%= PROJECT_ID%>" value="" />

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Project Name"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= PROJECT_NAME %>";

data_header[1] = new Array;
data_header[1][0] = "Sponsor Name"
data_header[1][1] = "hide";
data_header[1][2] = "25%";
data_header[1][3] = "<%= SPONSOR_ID %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = "10%"
data_header[2][3] = "<%=DESCRIPTION%>";

data_header[3] = new Array;
data_header[3][0] = "Project Code"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= PROJECT_CODE%>";

data_header[4] = new Array;
data_header[4][0] = "Protocol No"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= PROTOCOL_NO%>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "LOI No"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=LOI_NO %>";

data_header[9] = new Array;
data_header[9][0] = "Type"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=PROJECT_TYPE_ID %>";

data_header[10] = new Array;
data_header[10][0] = "Trial Phase"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=PROJECT_TRIAL_PHASE_ID %>";

data_header[11] = new Array;
data_header[11][0] = "Project Status"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%=PROJECT_STATUS_ID %>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=BUDGET %>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "<%=CURRENCY_ID %>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "<%=START_DATE %>";

data_header[15] = new Array;
data_header[15][0] = ""
data_header[15][1] = "hide";
data_header[15][2] = "15%";
data_header[15][3] = "<%=END_DATE%>";

data_header[16] = new Array;
data_header[16][0] = ""
data_header[16][1] = "hide";
data_header[16][2] = "15%";
data_header[16][3] = "<%=LOI_DATE%>";

data_header[17] = new Array;
data_header[17][0] = ""
data_header[17][1] = "hide";
data_header[17][2] = "15%";
data_header[17][3] = "<%=PURCHASE_ORDER_NO%>";

data_header[18] = new Array;
data_header[18][0] = ""
data_header[18][1] = "hide";
data_header[18][2] = "15%";
data_header[18][3] = "<%=PURCHASE_ORDER_DATE%>";

data_header[19] = new Array;
data_header[19][0] = ""
data_header[19][1] = "hide";
data_header[19][2] = "15%";
data_header[19][3] = "<%=CONTRACT_NO%>";

data_header[20] = new Array;
data_header[20][0] = ""
data_header[20][1] = "hide";
data_header[20][2] = "15%";
data_header[20][3] = "<%=CONTRACT_DATE%>";

data_header[21] = new Array;
data_header[21][0] = ""
data_header[21][1] = "hide";
data_header[21][2] = "15%";
data_header[21][3] = "<%=BILLABLE%>";

data_header[22] = new Array;
data_header[22][0] = ""
data_header[22][1] = "hide";
data_header[22][2] = "15%";
data_header[22][3] = "<%=THP_ID%>";

data_header[23] = new Array;
data_header[23][0] = ""
data_header[23][1] = "hide";
data_header[23][2] = "15%";
data_header[23][3] = "<%=EXTENSION%>";


data_header[24] = new Array;
data_header[24][0] = ""
data_header[24][1] = "hide";
data_header[24][2] = "15%";
data_header[24][3] = "<%=STATUS%>";

data_arr = new Array();

<%


Iterator itr=projectList.iterator();
int  counter=0;
while(itr.hasNext())
{


	MstrProject mstrProject= (MstrProject)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= mstrProject.getId()%>

data_arr[<%= counter%>][1] = "<%=mstrProject.getPrjName()%>";
	
<%
if(sponsorList.size()>0){
	for(MstrSponsor mstrSponsor :sponsorList){
	if(mstrSponsor.getId().equals(mstrProject.getSponsor().getId())){
%>

data_arr[<%= counter%>][2] = "<%=mstrSponsor.getSponsorName()%>";
<%
		}
			}
}
%>

data_arr[<%= counter%>][3] = "<%=mstrProject.getPrjDesc()%>";


data_arr[<%= counter%>][4] = "<%=mstrProject.getPrjCode()%>";

data_arr[<%= counter%>][5] = "<%=mstrProject.getPrjProtocalno()%>"
data_arr[<%= counter%>][6] = "<%= mstrProject.getLastChgBy() %>"
<% if(mstrProject.getLastChgDate() != null){%>
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(mstrProject.getLastChgDate()) %>"
<%}%>
data_arr[<%= counter%>][8] = "<%= mstrProject.getLastChgTime() %>"
data_arr[<%= counter%>][9] = "<%=mstrProject.getPrjLoino() %>"
<%
if(projectTypeList.size()>0){
	 for(MstrProjecttype mstrProjecttype :projectTypeList){
		if(mstrProjecttype.getId().equals(mstrProject.getProjectType().getId())){	 
	
%>

data_arr[<%= counter%>][10] = "<%=mstrProjecttype.getProjectName()%>"
<%}}} %>
<%
	if(trialPhaseList.size()>0){
		for(MstrTrialphase mstrTrialphase :trialPhaseList){	
		 if(mstrTrialphase.getId().equals(mstrProject.getTrialPhase().getId())){
%>
data_arr[<%= counter%>][11] = "<%=mstrTrialphase.getTrialPhaseName()%>"
<%
		}}}
%>
<%
	if(projectStatusList.size()>0){
		for(MstrProjectStatus mstrProjectStatus :projectStatusList){	
		 if(mstrProjectStatus.getId().equals(mstrProject.getProjectStatus().getId())){
%>
data_arr[<%= counter%>][12] = "<%=mstrProjectStatus.getPrjsName()%>"
<%
		}}}
%>

data_arr[<%= counter%>][13] = "<%=mstrProject.getPrjExpectedbudget()%>"
<%
	if(currencyList.size()>0){
		for(MasCurrency masCurrency :currencyList){	
			if(mstrProject.getCurrency().getId() != null ){
		 if(masCurrency.getId().equals(mstrProject.getCurrency().getId())){
%>
data_arr[<%= counter%>][14] = "<%=masCurrency.getCurrencyCode()%>"
<%
		 }}}}
%>
data_arr[<%= counter%>][15] = "<%=HMSUtil.convertDateToStringWithoutTime(mstrProject.getPrjStdt())%>"
<% if(mstrProject.getPrjEddt() != null){%>
data_arr[<%= counter%>][16] = "<%=HMSUtil.convertDateToStringWithoutTime(mstrProject.getPrjEddt())%>"<%
	}else{
%>
data_arr[<%= counter%>][16] = ""
<%
	}
%>
<% if(mstrProject.getPrjLoidt() != null){%>
data_arr[<%= counter%>][17] = "<%=HMSUtil.convertDateToStringWithoutTime(mstrProject.getPrjLoidt())%>";
<%
	}else{
%>
data_arr[<%= counter%>][17] = ""
<%
	}
%>
<% if(mstrProject.getPurchaseOrderNo() != null){%>
data_arr[<%= counter%>][18] = "<%=mstrProject.getPurchaseOrderNo()%>";
<%
	}else{
%>
data_arr[<%= counter%>][18] = ""
<%
	}
%>
<% if(mstrProject.getPurchasOrderDate() != null){%>
data_arr[<%= counter%>][19] = "<%=HMSUtil.convertDateToStringWithoutTime(mstrProject.getPurchasOrderDate())%>";
<%
	}else{
%>
data_arr[<%= counter%>][19] = ""
<%
	}
%>
<% if(mstrProject.getContractNo() != null){%>
data_arr[<%= counter%>][20] = "<%=mstrProject.getContractNo()%>";
<%
	}else{
%>
data_arr[<%= counter%>][20] = ""
<%
	}
%>
<% if(mstrProject.getContractDate() != null){%>
data_arr[<%= counter%>][21] = "<%=HMSUtil.convertDateToStringWithoutTime(mstrProject.getContractDate())%>";
<%
	}else{
%>
data_arr[<%= counter%>][21] = ""
<%
	}
%>
data_arr[<%= counter%>][22] = "<%=mstrProject.getBillable()%>";
<%
	if(therapeuticAreaList.size()>0){
		for(MstrTherapeutic mstrTherapeutic :therapeuticAreaList){	
			if(mstrProject.getThp()!= null){
		 if(mstrTherapeutic.getId().equals(mstrProject.getThp().getId())){
%>
data_arr[<%= counter%>][23] = "<%=mstrTherapeutic.getThpDesc()%>"
<%
		 }}}}
%>
data_arr[<%= counter%>][24] = "<%=mstrProject.getExtension()%>";
<% 
if(mstrProject.getStatus().equals("y")){ %>
data_arr[<%= counter%>][25] = "Active"
<%}else{%>
data_arr[<%= counter%>][25] = "InActive"
<%}%>
<%

counter++;
}
%>


formName = "projectCreation"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	

