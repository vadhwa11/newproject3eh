<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.MstrPtvisit"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
				List<MstrSiteHeader> siteHeaderList = new ArrayList<MstrSiteHeader>();
				List<MstrTherapeutic> therapeuticList = new ArrayList<MstrTherapeutic>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<MstrSiteDetail> siteDetailList = new ArrayList<MstrSiteDetail>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("siteHeaderList")!= null){
					siteHeaderList = (List)map.get("siteHeaderList");
				}
				if(map.get("therapeuticList")!= null){
					therapeuticList = (List)map.get("therapeuticList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("feasibilityHeaderList")!= null){
					feasibilityHeaderList = (List)map.get("feasibilityHeaderList");
				}
				if(map.get("siteDetailList")!= null){
					siteDetailList = (List)map.get("siteDetailList");
				}
				
				
				if(map.get("message") != null){
					String message = (String)map.get("message");
					out.println(message);
					}
				
				Map<String,Object> utilMap = new HashMap<String,Object>();
				utilMap = (Map)HMSUtil.getCurrentDateAndTime();
				String date = (String)utilMap.get("currentDate");	 
				String time = (String)utilMap.get("currentTime");
					
				
				String userName = "";
				if(session.getAttribute("userName") != null){
					userName = (String)session.getAttribute("userName");
				}
				String projectName = "";
				String projectCode = "";
				String sponsorName  = "";
				String trialPhase = "";
				String protocolNo = "";
				String projectType = "";
				String projectStatus = "";
				BigDecimal budget = new BigDecimal("0");
				Date StartDate = new Date();
				Date endDate = new Date();
				String loiDate = "";
				String purchaseDate = "";
				String conTractDate = "";
				String purchaseOrderNo = "";
				String contractNo = "";
				String loino = "";
				String therapeuticArea = "";
				int projectId = 0;
				if(projectList.size()>0){
					for (MstrProject mstrProject :projectList){
						projectName= mstrProject.getPrjName();
						projectCode = mstrProject.getPrjCode();
						sponsorName = mstrProject.getSponsor().getSponsorName();
						trialPhase = mstrProject.getTrialPhase().getTrialPhaseName();
						if(mstrProject.getPrjProtocalno()!= null){
						protocolNo = mstrProject.getPrjProtocalno();
						}
						projectType = mstrProject.getProjectType().getProjectName();
						projectStatus = mstrProject.getProjectStatus().getPrjsName();
						if(mstrProject.getPrjExpectedbudget()!= null){
						budget = mstrProject.getPrjExpectedbudget();
						}
						StartDate = mstrProject.getPrjStdt();
						endDate  = mstrProject.getPrjEddt();
						if(mstrProject.getPrjLoidt()!= null){
						loiDate = HMSUtil.convertDateToStringWithoutTime(mstrProject.getPrjLoidt());
						}
						if(mstrProject.getPrjLoino()!= null){
						loino = mstrProject.getPrjLoino();
						}
						if(mstrProject.getPurchasOrderDate()!= null ){
							purchaseDate = HMSUtil.convertDateToStringWithoutTime(mstrProject.getPurchasOrderDate());
						}
						if(mstrProject.getContractDate()!= null){
							conTractDate = HMSUtil.convertDateToStringWithoutTime(mstrProject.getContractDate());
						}
						if(mstrProject.getContractNo()!= null){
							contractNo = mstrProject.getContractNo();
						}
						if(mstrProject.getPurchaseOrderNo()!= null){
							purchaseOrderNo = mstrProject.getPurchaseOrderNo();
						}
						if(mstrProject.getThp().getThpDesc()!= null){
							therapeuticArea = mstrProject.getThp().getThpDesc();
						}
						projectId = mstrProject.getId();
					}
				}
				int feasibilityHeaderId = 0;
				if(feasibilityHeaderList.size()>0){
					for(PrjFesStudyHeader prjFesStudyHeader :feasibilityHeaderList){
						feasibilityHeaderId = prjFesStudyHeader.getId();
					}
					
				}
				
	%>
<%@page import="jkt.hrms.masters.business.PrjMilestone"%>
<%@page import="jkt.hrms.masters.business.PrjFesStudyHeader"%>
<%@page import="jkt.hrms.masters.business.MstrSiteHeader"%>
<%@page import="jkt.hrms.masters.business.MstrTherapeutic"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.MstrSiteDetail"%>
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
	function calculateAmount()
	{
		var totalAmount = document.getElementById('totalAmountId').value;
		var paymentPercentage = document.getElementById('paymentPercentageId').value;
		if(totalAmount != "" && paymentPercentage!=""  )
		{
		var totalAmt = parseFloat(totalAmount);
		var amtInpercentage = parseFloat(paymentPercentage);
		var amount = (totalAmt * paymentPercentage)/100;
		document.getElementById('amountId').value=amount;
		 }
	}
	
	
	function backProjectSetting()
	{
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showProjectVitalsJsp";
  		 obj.submit();
  		 return true;
	
	}
	
	function showComboAccordingToSQVisit(sqVisit){
	if(sqVisit=='yes'){
		document.getElementById('visitStatusId').style.display='block';
	}
	else{
		document.getElementById('visitStatusId').style.display='none';
		}
	}
	
	function showComboAccordingToSQVisitStatus(sqVisitStatus){
	if(sqVisitStatus=='delegate'){
		document.getElementById('departmentId').style.display='block';
		document.getElementById('employeeId').style.display='block';
	}
	else{
		document.getElementById('departmentId').style.display='none';
		document.getElementById('employeeId').style.display='none';
		}
	}
	
	function nextrojectSetting()
	{
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showSqVisitUpdateJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	
	}
</script>
<div class="titleBg"><h2>Assign Sites</h2></div>


<div class="clear"></div>

<div class="Block">
<label>Project Name</label>
<label ><%=projectName %></label>
<label>Project Code</label>
<label><%=projectCode %></label>
<label>Sponsor Name</label>
<label class="auto"><%=sponsorName %></label>
<div class="clear"></div>
<label>Trial Phase </label>
<label><%=trialPhase %></label>
<label>Protocol No </label>
<label><%=protocolNo %></label>
<label>Project Type</label>
<label><%=projectType %></label>
<div class="clear"></div>
<label>Project Status </label>
<label><%=projectStatus %></label>
<label>Expected Budget </label>
<label><%=budget %></label>
<label>Start Date</label>
<label><%=HMSUtil.convertDateToStringWithoutTime(StartDate) %></label>
<div class="clear"></div>
<label>End Date </label>
<label><%=HMSUtil.convertDateToStringWithoutTime(endDate )%></label>
<label>LOI Date </label>
<label><%=loiDate %>&nbsp;</label>
<label>LOI No</label>
<label><%=loino %>&nbsp;</label>
<div class="clear"></div>
<div class="clear"></div>
<label>Purchase Date </label>
<label><%=purchaseDate %>&nbsp;</label>
<label>Purchase Order No </label>
<label><%=purchaseOrderNo %>&nbsp;</label>
<label>Contract Date</label>
<label><%=conTractDate %>&nbsp;</label>

<div class="clear"></div>
<label>Contract No</label>
<label><%=contractNo %>&nbsp;</label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>
<script type="text/javascript">
formFields = [
[0, "<%= FES_STUDY_HEADER_ID%>", "id"], [1,"<%=SITE_HEADER_ID%>"], [2,"<%= SQ_VISIT %>"],[3,"<%=SQ_VISIT_STATUS%>"],[4,"<%=EMPLOYEE_ID%>"],[5,"<%=PLANNED_DATE%>"],[6,"<%=DEPARTMENT_ID%>"],[7,"<%=STATUS%>"]];
statusTd =7;
</script>
</div>

<form name="assignSiteForPI" method="post" action="" >
<input type="hidden" name="<%=PROJECT_ID %>"  value="<%=projectId %>" />
<div class="Block">
<div class="clear"></div>

<label>Therpeutic Area </label>
<label><%=therapeuticArea %>&nbsp;</label>

<label><span>*</span>Site </label>
<select id="siteHeaderId" name="<%=SITE_HEADER_ID %>" validate="Site,string,yes"   >
<option value="0">Select</option>
<%
	for(MstrSiteDetail mstrSiteDetail :siteDetailList){
%>
<option value="<%=mstrSiteDetail.getSiteHeader().getId() %>"><%=mstrSiteDetail.getSiteHeader().getSiteName() %></option>
<%} %>
</select>

<label><span>*</span>SQ Visit</label>
<select id="currencyId" name="<%=SQ_VISIT %>" validate="Sq Visit,string,yes"  onchange="showComboAccordingToSQVisit(this.value);"  >
<option value="0">Select</option>
<option value="yes">Yes</option>
<option value="no">NO</option>
</select>
<div class="clear"></div>
<div id="visitStatusId" style="display:none;">
<label><span>*</span>SQ Visit Status</label>
<select id="visitStatusId" name="<%=SQ_VISIT_STATUS %>" validate="Sq Visit Status,string,yes" onchange="showComboAccordingToSQVisitStatus(this.value);" >
<option value="0">Select</option>
<option value="self">Self</option>
<option value="delegate">Delegate</option>
</select>
</div>
<div id="departmentId" style="display:none;">
<label>Department </label>
<select id="departmentId" name="<%=DEPARTMENT_ID %>" validate="Department,string,no" onChange="populateEmp(this.value,'assignSiteForPI')" >
<option value="0">Select</option>
<%
	for(MasDepartment masDepartment :departmentList){
%>
<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName()%></option>
<%} %>
</select>
</div>
<div id="employeeId" style="display:none;">
<label>Employee </label>
<select id="employeeId" name="<%=EMPLOYEE_ID %>" validate="Employee,string,no" >
<option value="0">Select</option>
<%
	for(MasEmployee masEmployee :employeeList){
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName() %></option>
<%} %>
</select>
</div>
<div class="clear"></div>
<label>Planned Date </label>
<input id="fromDateId" type="text"  name="<%=PLANNED_DATE %>" value="" class="date"  readonly="readonly" validate="Planned date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('fromDateId'),event)"/>
<div class="clear"></div>
</div>
<script type="text/javascript">
<%
int count=0;
for (MasDepartment masDepartment :departmentList) 
{
for (MasEmployee masEmployee :employeeList) 
{
if(masEmployee.getDepartment() != null){
if(masDepartment.getId().equals(masEmployee.getDepartment().getId())){
%>
empployeeArr[<%=count%>] = new Array();
empployeeArr[<%=count%>][0] = <%=masDepartment.getId()%>;
empployeeArr[<%=count%>][1] = <%=masEmployee.getId()%>;									
empployeeArr[<%=count%>][2] = "<%=masEmployee.getFirstName() +" "+masEmployee.getLastName()%>";
<%
count++;
}
}
}
}
%>
</script> 
<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('assignSiteForPI','projectTracking?method=saveAssignSiteDetails');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('sitePaymentSchedule','projectTracking?method=updateSitePaymentSchedule')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('projectCreation','training?method=deleteTrainingMaster&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="add" id="addbutton" value="Back" class="button" onClick="backProjectSetting();" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Next" class="button" onClick="nextrojectSetting();" accesskey="a" tabindex=1 />


			 <input type="hidden" name="<%=STATUS %>" value="" />	 
			 <input type="hidden" name="<%= FES_STUDY_HEADER_ID%>" value="<%=feasibilityHeaderId%>" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Site"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= SITE_HEADER_ID %>";

data_header[1] = new Array;
data_header[1][0] = ""
data_header[1][1] = "hide";
data_header[1][2] = "25%";
data_header[1][3] = "<%=SQ_VISIT %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = "10%"
data_header[2][3] = "<%=SQ_VISIT_STATUS%>";

data_header[3] = new Array;
data_header[3][0] = "Delegate"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= EMPLOYEE_ID%>";

data_header[4] = new Array;
data_header[4][0] = "Planned Visit Date"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= PLANNED_DATE %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%= DEPARTMENT_ID %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= STATUS %>";





data_arr = new Array();

<%


Iterator itr=feasibilityHeaderList.iterator();
int  counter=0;
while(itr.hasNext())
{


	PrjFesStudyHeader prjFesStudyHeader= (PrjFesStudyHeader)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjFesStudyHeader.getId()%>
<%
for(MstrSiteHeader mstrSiteHeader:siteHeaderList){
		if(prjFesStudyHeader.getSiteHeader()!= null){
			if(prjFesStudyHeader.getSiteHeader().getId().equals(mstrSiteHeader.getId())){
%>
data_arr[<%= counter%>][1] = "<%=mstrSiteHeader.getSiteName() %>";
<%}}else{ %>
data_arr[<%= counter%>][1] = ""
<%
	}}
%>

data_arr[<%= counter%>][2] = "<%=prjFesStudyHeader.getSqVisit() %>";



data_arr[<%= counter%>][3] = "<%=prjFesStudyHeader.getSqVisitStatus()%>";
<%
for(MasEmployee masEmployee :employeeList){
		if(prjFesStudyHeader.getDelegateEmp()!= null){
			if(prjFesStudyHeader.getDelegateEmp().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][4] = "<%= masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName()%>";
<%}}else{ %>
data_arr[<%= counter%>][4] = ""
<%
	}}
%>


<%if(prjFesStudyHeader.getPlannedVisitDate()!= null){%>
data_arr[<%= counter%>][5] = "<%=HMSUtil.convertDateToStringWithoutTime(prjFesStudyHeader.getPlannedVisitDate()) %>";
<%
	}else{
%>
data_arr[<%= counter%>][5] = ""
<%
	}
%>

<%
for(MasEmployee masEmployee :employeeList){
		if(prjFesStudyHeader.getDelegateEmp()!= null){
			if(prjFesStudyHeader.getDelegateEmp().getId().equals(masEmployee.getId())){
%>
data_arr[<%= counter%>][6] = "<%= masEmployee.getDepartment().getId()%>";
<%}}else{ %>
data_arr[<%= counter%>][6] = ""
<%
	}}
%>


<% 
if(prjFesStudyHeader.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>

<%

counter++;
}
%>


formName = "assignSiteForPI"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	
