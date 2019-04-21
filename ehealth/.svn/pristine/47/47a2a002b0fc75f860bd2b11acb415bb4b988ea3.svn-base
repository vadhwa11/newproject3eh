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
				BigDecimal totalAmountperPatient = new BigDecimal("0");
				String cutoffDate = "";
				if(prjMilstoneList.size()>0){
					for(PrjMilestone prjMilestone :prjMilstoneList){
						if( prjMilestone.getTotalAmtPerPatient()!= null){
						totalAmountperPatient = prjMilestone.getTotalAmtPerPatient();
						}
						if(prjMilestone.getCutOffDate()!= null){
						cutoffDate =HMSUtil.convertDateToStringWithoutTime(prjMilestone.getCutOffDate());
						}
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
	
	function calculatePercentage()
	{
		var totalAmount = document.getElementById('totalAmountId').value;
		var amountPerVisit = document.getElementById('amountId').value;
		if(totalAmount != "" && amountPerVisit!=""  )
		{
		var totalAmt = parseFloat(totalAmount);
		var amount = parseFloat(amountPerVisit);
		var percentage = (amount*100/totalAmt);
		document.getElementById('paymentPercentageId').value=percentage;
		 }
	}
	
	
	function backProjectSetting()
	{
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showProjectVitalsJsp";
  		 obj.submit();
  		 return true;
	
	}
	function nextrojectSetting()
	{
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showRoleResourceMappingJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	
	}
	
	
</script>
<div class="titleBg"><h2>Site Payment Schedule </h2></div>


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
[0, "<%= SITE_PAYMENT_SCHEDULE_ID%>", "id"], [1,"<%=PATIENT_VISIT_ID%>"], [2,"<%= PAYMENT %>"],[3,"<%=AMOUNT%>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],
[7,"<%=AMOUNT_PER_PATIENT%>"],[8,"<%=CUT_OFF_DATE%>"],[9,"<%=STATUS%>"]];
statusTd =9;
</script>
</div>

<form name="sitePaymentSchedule" method="post" action="" >
<input type="hidden" name="<%=PROJECT_ID %>"  value="<%=projectId %>" />
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Payment(amt per Patient) </label>
<input type="text" id="totalAmountId"   name="<%=AMOUNT_PER_PATIENT %>" value=""   onblur="calculateAmount()" validate="Payment per Patient,float,yes"   maxlength="11" />
<script type="text/javascript">
document.getElementById('totalAmountId').value = '<%=totalAmountperPatient%>'
</script>
<label>Cut Off Date </label>
<input id="cutOffDateId" type="text"  name="<%=CUT_OFF_DATE %>" value="" class="date"  validate="Cut Off date ,date,no"  MAXLENGTH="30" />
<script type="text/javascript">
document.getElementById('cutOffDateId').value = '<%=cutoffDate%>'
</script>
<label class="small">DD/MM/YYYY </label>
</div>

<div class="Block">
<div class="clear"></div>
<label><span>*</span>Visit </label>
<select  name="<%=PATIENT_VISIT_ID %>" validate="Patient Visit,string,yes"  >
<option value="0">Select</option>
<%
	for(MstrPtvisit mstrPtvisit :patientVisitList){
%>
<option value="<%=mstrPtvisit.getId() %>"><%=mstrPtvisit.getPatientVisitName() %></option>
<%} %>
</select>

<label><span>*</span>Payment(%) </label>
<input type="text" id="paymentPercentageId"  name="<%=PAYMENT %>" onblur="calculateAmount()"  validate="Payment(%),float,yes"   maxlength="3" />
<div class="clear"></div>
<label><span>*</span>Amount </label>
<input type="text" id="amountId"  name="<%=AMOUNT %>"   validate="Amount,float,yes" onblur="calculatePercentage()"  maxlength="9" />


<div class="clear"></div>
</div>

<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('sitePaymentSchedule','projectTracking?method=saveSitePaymentSchedule');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('sitePaymentSchedule','projectTracking?method=updateSitePaymentSchedule')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('projectCreation','training?method=deleteTrainingMaster&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="add" id="addbutton" value="Back" class="button" onClick="backProjectSetting();" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Next" class="button" onClick="nextrojectSetting();" accesskey="a" tabindex=1 />
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
data_header[0][0] = "Patient Visit"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= PATIENT_VISIT_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Payment"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= PAYMENT %>";

data_header[2] = new Array;
data_header[2][0] = "Amount"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=AMOUNT%>";

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
data_header[6][3] = "<%=AMOUNT_PER_PATIENT%>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=CUT_OFF_DATE%>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS%>";


data_arr = new Array();

<%


Iterator itr=prjMilstoneList.iterator();
int  counter=0;
while(itr.hasNext())
{


	PrjMilestone prjMilestone= (PrjMilestone)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjMilestone.getId()%>
<%
	if(patientVisitList.size()>0){
		for(MstrPtvisit mstrPtvisit :patientVisitList){
			if(prjMilestone.getPatientVisit()!= null){
		if(mstrPtvisit.getId().equals(prjMilestone.getPatientVisit().getId())){
%>
data_arr[<%= counter%>][1] = "<%=mstrPtvisit.getPatientVisitName() %>";
<%
		}
			}
		}
	}
		
%>
<%if(prjMilestone.getMilestonePercentage() != null){%>
data_arr[<%= counter%>][2] = "<%=prjMilestone.getMilestonePercentage() %>";
<%
	}else{
%>
data_arr[<%= counter%>][2] = ""
<%
	}
%>
<%if(prjMilestone.getMilestoneAmount() != null){%>
data_arr[<%= counter%>][3] = "<%=prjMilestone.getMilestoneAmount()%>";
<%
	}else{
%>
data_arr[<%= counter%>][3] = ""
<%
	}
%>
<%if(prjMilestone.getLastChgDate()!= null){%>
data_arr[<%= counter%>][4] = "<%= prjMilestone.getLastChgBy() %>"
<%}else{%>
data_arr[<%= counter%>][4] = ""
<%}%>
<%if(prjMilestone.getLastChgDate()!= null){%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(prjMilestone.getLastChgDate()) %>"
<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>
<%if(prjMilestone.getLastChgTime()!= null){%>
data_arr[<%= counter%>][6] = "<%= prjMilestone.getLastChgTime() %>"
<%}else{%>
data_arr[<%= counter%>][6] = ""
<%}%>
<%if(prjMilestone.getTotalAmtPerPatient() != null){%>
data_arr[<%= counter%>][7] = "<%= prjMilestone.getTotalAmtPerPatient() %>"
<%
	}else{
%>
data_arr[<%= counter%>][7] = ""
<%
	}
%>
<%if(prjMilestone.getCutOffDate() != null){%>
data_arr[<%= counter%>][8] = "<%=HMSUtil.convertDateToStringWithoutTime(prjMilestone.getCutOffDate()) %>"
<%
	}else{
%>
data_arr[<%= counter%>][8] = ""
<%
	}
%>



<% 
if(prjMilestone.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>

<%

counter++;
}
%>


formName = "sitePaymentSchedule"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	

