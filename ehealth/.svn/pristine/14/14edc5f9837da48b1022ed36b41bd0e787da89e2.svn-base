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
	
	function openPopupWindow()
			{ var id = 0; 
				 for(var i = 0; i < document.getElementsByName('fesbilitystudyId').length; i++){
					  if(document.getElementsByName('fesbilitystudyId')[i].checked == true)
		              {
						id = document.getElementsByName('fesbilitystudyId')[i].value;
					  }		
		  		}
		  		var url="/hms/hrms/projectTracking?method=displaySqVisitUpdateAttachment&fesbilitystudyId="+id+"";
		 		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		 	
			}
			
			
	function validateRadio(){
			 for(var i = 0; i < document.getElementsByName('fesbilitystudyId').length; i++){
			  if(document.getElementsByName('fesbilitystudyId')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please select Record to attach document...");
		return false;
		
	}
</script>
<div class="titleBg"><h2>SQ Visit Update</h2></div>


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
[0, "<%= FES_STUDY_HEADER_ID%>", "id"], [1,"radioId"], [2,"<%= SITE_HEADER_ID %>"],[3,"<%=PI_HEADER_ID%>"],[4,"<%=EMPLOYEE_ID%>"],[5,"<%=PLANNED_DATE%>"],[6,"<%=ACTUAL_DATE%>"],[7,"<%=COMMENTS%>"],[8,"<%=STATUS%>"]];
statusTd =7;
</script>
</div>

<form name="sqVisitUpdate" method="post" action="" >
<input type="hidden" name="<%=PROJECT_ID %>"  value="<%=projectId %>" />
<div class="Block">
<div class="clear"></div>

<label><span>*</span>Actual Visit date </label>
<input id="fromDateId" type="text"  name="<%=ACTUAL_DATE %>" value="" class="date"  readonly="readonly" validate="Actual date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('fromDateId'),event)"/>

 <label>Comments</label>
     <input type="text" name="<%=COMMENTS%>" value="" validate="Comments,string,no" class="large" MAXLENGTH="100" / tabindex=1 />
<div class="clear"></div>

</div>

<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('sqVisitUpdate','projectTracking?method=saveSQVisitUpdateDetails');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('sqVisitUpdate','projectTracking?method=updateSQVisitUpdateDetails')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('projectCreation','training?method=deleteTrainingMaster&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="add" id="addbutton" value="Back" class="button" onClick="backProjectSetting();" accesskey="a" tabindex=1 />
<input type="button" name="attach" id="attach"  value="Attach Files" class="button" onClick="if(validateRadio()){javascript:openPopupWindow()};" />


			 <input type="hidden" name="<%=STATUS %>" value="" />	 
			 <input type="hidden" name="<%= FES_STUDY_HEADER_ID%>" id="feasibilityHeaderId" value="<%=feasibilityHeaderId%>" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Select"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "radioId";

data_header[1] = new Array;
data_header[1][0] = "Site"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%=SITE_HEADER_ID %>";

data_header[2] = new Array;
data_header[2][0] = "PI"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=PI_HEADER_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Delegate"
data_header[3][1] = "data";
data_header[3][2] = "10%";
data_header[3][3] = "<%= EMPLOYEE_ID%>";

data_header[4] = new Array;
data_header[4][0] = "Planned date"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= PLANNED_DATE %>";

data_header[5] = new Array;
data_header[5][0] = "Actual Date"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%= ACTUAL_DATE %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= COMMENTS %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= STATUS %>";



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

data_arr[<%= counter%>][1] = '<input name="fesbilitystudyId"  class="radioCheck"  id="rb" type="radio" value="<%=prjFesStudyHeader.getId()%>" />';

<%
for(MstrSiteHeader mstrSiteHeader:siteHeaderList){
		if(prjFesStudyHeader.getSiteHeader()!= null){
			if(prjFesStudyHeader.getSiteHeader().getId().equals(mstrSiteHeader.getId())){
%>
data_arr[<%= counter%>][2] = "<%=mstrSiteHeader.getSiteName() %>";
<%}}else{ %>
data_arr[<%= counter%>][2] = ""
<%
	}}
%>

data_arr[<%= counter%>][3] = "<%=prjFesStudyHeader.getPiHeader().getPiName() %>";



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

<%if(prjFesStudyHeader.getActuaVisitDate() != null){%>
data_arr[<%= counter%>][6] = "<%=HMSUtil.convertDateToStringWithoutTime(prjFesStudyHeader.getActuaVisitDate())%>";
<%
	}else{
%>
data_arr[<%= counter%>][6] = ""
<%
	}
%>
<%if(prjFesStudyHeader.getComments() != null){%>
data_arr[<%= counter%>][7] = "<%=prjFesStudyHeader.getComments()%>";
<%
	}else{
%>
data_arr[<%= counter%>][7] = ""
<%
	}
%>

<% 
if(prjFesStudyHeader.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>

<%

counter++;
}
%>


formName = "sqVisitUpdate"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	

