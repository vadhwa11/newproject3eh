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
				List<MstrPtvisit> patientVisitList = new ArrayList<MstrPtvisit>();
				List<PrjMilestone> prjMilstoneList = new ArrayList<PrjMilestone>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				
				if(map.get("prjMilstoneList")!= null){
					prjMilstoneList = (List)map.get("prjMilstoneList");
				}
				if(map.get("patientVisitList")!= null){
					patientVisitList = (List)map.get("patientVisitList");
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
						projectId = mstrProject.getId();
					}
				}
				
				
	%>
<%@page import="jkt.hrms.masters.business.PrjMilestone"%>
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
     obj.action = "projectTracking?method=showApprovalSettingJsp";
     obj.submit();
     return true;
 
 }
 
 
	
	
</script>
<div class="titleBg"><h2>Project Approval </h2></div>


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
<label><%=projectStatus %>&nbsp;</label>
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
[0, "<%= SITE_PAYMENT_SCHEDULE_ID%>", "id"], [1,"<%=PROJECT_ID%>"], [2,"<%= STATUS_DESC %>"],[3,"<%=APPROVAL_DATE%>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],
[7,"<%=COMMENTS%>"][8,"<%=STATUS%>"]];
statusTd =8;
</script>
</div>

<form name="projectApproval" method="post" action="" >
<input type="hidden" name="<%=PROJECT_ID %>"  value="<%=projectId %>" />
<div class="Block">
<div class="clear"></div>
<label><span>*</span>Status </label>
<select  name="<%=STATUS_DESC%>" validate="Status,string,yes"  >
<option value="0">Select</option>
<option value="Approved">Approved</option>
<option value="reject">Reject</option>
<option value="hold">Hold</option>
</select>
<label>Approval Date</label>
<input id="cutOffDateId" type="text"  name="<%=APPROVAL_DATE %>" value="" class="date"  readonly="readonly" validate="Cut Off date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('cutOffDateId'),event)"/>
<label>Comment </label>
<input type="text" id="purchaseOrderNoId"  name="<%=COMMENTS%>"   validate="Comments.,string,no"   maxlength="40" />
<div class="clear"></div>
</div>

<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('projectApproval','projectTracking?method=approveProject');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('sitePaymentSchedule','projectTracking?method=updateSitePaymentSchedule')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('projectCreation','training?method=deleteTrainingMaster&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="add" id="addbutton" value="Back" class="button" onClick="backProjectSetting();" accesskey="a" tabindex=1 />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<div class="clear"></div>
<label>Last Changed By</label>
<label class="value"><%=userName%></label>
<label>Last Changed DATE</label>
<label class="value"><%=date%></label>

<label>Last Changed Time</label>
<label class="value"><%=time%></label>
</div>
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" /> 
			 <input type="hidden" name="<%=STATUS %>" value="" />	 
			 <input type="hidden" name="<%= SITE_PAYMENT_SCHEDULE_ID%>" value="" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Project Name"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= PROJECT_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Status"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= STATUS_DESC %>";

data_header[2] = new Array;
data_header[2][0] = "Approval Date"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=APPROVAL_DATE%>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "10%";
data_header[3][3] = "<%= CHANGED_BY%>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%= CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=COMMENTS%>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS%>";




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
data_arr[<%= counter%>][1] = "<%= mstrProject.getPrjName()%>";
<%if(mstrProject.getPrjAppstatus()!= null){%>
data_arr[<%= counter%>][2] = "<%=mstrProject.getPrjAppstatus() %>";
<%}else{%>
data_arr[<%= counter%>][2] = "";
<%}%>
<%if(mstrProject.getPrjAppDate()!= null){%>
data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(mstrProject.getPrjAppDate()) %>"
<%}else{%>
data_arr[<%= counter%>][3] = ""
<%}%>
<%if(mstrProject.getLastChgBy() != null){%>
data_arr[<%= counter%>][4] = "<%= mstrProject.getLastChgBy() %>"
<%}else{%>
data_arr[<%= counter%>][4] = ""
<%}%>
<%if(mstrProject.getLastChgDate() != null){%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(mstrProject.getLastChgDate()) %>"
<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>
<%if(mstrProject.getLastChgTime() != null){%>
data_arr[<%= counter%>][6] = "<%= mstrProject.getLastChgTime() %>"
<%}else{%>
data_arr[<%= counter%>][6] = ""
<%}%>
<%if(mstrProject.getPrjAppcmts() != null){%>
data_arr[<%= counter%>][7] = "<%=mstrProject.getPrjAppcmts() %>"
<%
	}else{
%>
data_arr[<%= counter%>][7] = ""
<%
	}
%>
<% 
if(mstrProject.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>

<%

counter++;
}
%>


formName = "projectApproval"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	

