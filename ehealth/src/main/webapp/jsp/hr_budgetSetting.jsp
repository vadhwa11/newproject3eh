<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<MstrBudgetType>budgetTypeList = new ArrayList<MstrBudgetType>();
				List<MstrBudgetSubhead> budgetSubHeadList = new ArrayList<MstrBudgetSubhead>();
				List<MstrTaskType> taskTypeList = new ArrayList<MstrTaskType>();
				List<MstrTask> projectTaskList = new ArrayList<MstrTask>();
				List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
				List<PrjBudgetSetting> prjBudgetsettingList = new ArrayList<PrjBudgetSetting>();
				List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("prjRoleWiseResourceList")!= null){
					prjRoleWiseResourceList = (List)map.get("prjRoleWiseResourceList");
				}
				if(map.get("prjBudgetsettingList")!= null){
					prjBudgetsettingList = (List)map.get("prjBudgetsettingList");
				}
				if(map.get("budgetTypeList")!= null){
					budgetTypeList = (List)map.get("budgetTypeList");
				}
				if(map.get("budgetSubHeadList")!= null){
					budgetSubHeadList = (List)map.get("budgetSubHeadList");
				}
				if(map.get("taskTypeList")!= null){
					taskTypeList = (List)map.get("taskTypeList");
				}
				if(map.get("projectRoleList")!= null){
					projectRoleList = (List)map.get("projectRoleList");
				}
				if(map.get("projectTaskList")!= null){
					projectTaskList = (List)map.get("projectTaskList");
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
<%@page import="jkt.hrms.masters.business.MstrBudgetType"%>
<%@page import="jkt.hrms.masters.business.MstrBudgetSubhead"%>
<%@page import="jkt.hrms.masters.business.MstrTaskType"%>
<%@page import="jkt.hrms.masters.business.MstrTask"%>
<%@page import="jkt.hrms.masters.business.MstrProjectrole"%>
<%@page import="jkt.hrms.masters.business.MstrPtvisit"%>
<%@page import="jkt.hrms.masters.business.PrjBudgetSetting"%>
<%@page import="jkt.hrms.masters.business.PrjRolewiseResourceReq"%>
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
	
	
	function calculateTotalCost()
	{
		
		var reqNo = document.getElementById('reqResourceId').value;
		var costperHr = document.getElementById('costperHrId').value;
		var reqHr = document.getElementById('reqHr').value;
		if(reqNo != "" && costperHr!=""  && reqHr!="")
		{
		var reqResource = parseFloat(reqNo);
		var costHr = parseFloat(costperHr);
		var totalReqHr = parseFloat(reqHr);
		var totalCost = reqResource*costHr*totalReqHr;
		document.getElementById('totalCostId').value=totalCost;
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
  		 obj.action = "projectTracking?method=showSitePaymentScheduleJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	
	}
	
	
</script>
<script type="text/javascript">
	function display(idvalue) {
	
	<%
	for(PrjRolewiseResourceReq prjRolewiseResourceReq:prjRoleWiseResourceList){
		int id =prjRolewiseResourceReq.getPjr().getId();
		
	%>
	
	if(idvalue == <%=id%> ){
	
    document.getElementById('reqResourceId').value = '<%= prjRolewiseResourceReq.getResCount() %>'
    document.getElementById('costperHrId').value = '<%= prjRolewiseResourceReq.getCostPerHr() %>'
    
        
	
	}
<%
	}
	
%>

}
</script>
<div class="titleBg"><h2>Budget Setting </h2></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Project Name</label>
<label ><%=projectName %></label>
<label>Project Code</label>
<label><%=projectCode %>&nbsp;</label>
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
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>

<script type="text/javascript">

formFields = [
[0, "<%= BUDGET_SETTING_ID%>", "id"], [1,"<%=BUDGET_TYPE_ID%>"], [2,"<%= BUDGET_SUBHEADING_ID %>"],[3,"<%=TASK_TYPE_ID%>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],
[7,"<%=TASK_ID%>"],[8,"<%=PROJECT_ROLE_ID%>"],[9,"<%=REQUIRED_NO%>"],[10,"<%=HR_REQ%>"],[11,"<%=COST_PER_HOUR%>"],[12,"<%=TOTAL_COST%>"],[13,"<%=STATUS%>"]];
statusTd =13;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>

<form name="budgetSetting" method="post" action="" >
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label><span>*</span>Budget Type </label>
<select  name="<%=BUDGET_TYPE_ID %>" validate="Budget Type,string,yes"  >
<option value="0">Select</option>
<%
	for(MstrBudgetType mstrBudgetType :budgetTypeList){
%>
<option value="<%=mstrBudgetType.getId() %>"><%=mstrBudgetType.getBudgetTypeName() %></option>
<%} %>
</select>
<input type="hidden" name="<%=PROJECT_ID %>"  value="<%=projectId %>" />
<label><span>*</span>Budget Sub Heading</label>
<select  name="<%=BUDGET_SUBHEADING_ID %>" validate="Budget SubHead,string,yes"  >
<option value="0">Select</option>
<%
	for(MstrBudgetSubhead mstrBudgetSubhead :budgetSubHeadList){
%>
<option value="<%=mstrBudgetSubhead.getId() %>"><%=mstrBudgetSubhead.getBudName() %></option>
<%} %>
</select>
<label><span>*</span>Task Type </label>
<select id="currencyId" name="<%=TASK_TYPE_ID %>" validate="Task Type,string,yes" onChange="populateTask(this.value,'budgetSetting')"  >
<option value="0">Select</option>
<%
	for(MstrTaskType msrMstrTaskType:taskTypeList){
%>
<option value="<%=msrMstrTaskType.getId() %>"><%=msrMstrTaskType.getTaskTypeName() %></option>
<%} %>
</select>
<div class="clear"></div>
<label><span>*</span> Task </label>
<select id="currencyId" name="<%=TASK_ID %>" validate="Task,string,yes"  >
<option value="0">Select</option>
<%
	for(MstrTask mstrTask :projectTaskList){
%>
<option value="<%=mstrTask.getId() %>"><%=mstrTask.getTaskName() %></option>
<%} %>
</select>

<script type="text/javascript">
<%
int count=0;
for (MstrTaskType mstrTaskType :taskTypeList) 
{
for (MstrTask mstrTask:projectTaskList) 
{
if(mstrTask.getTaskType() != null){
if(mstrTaskType.getId().equals(mstrTask.getTaskType().getId())){
%>
taskArr[<%=count%>] = new Array();
taskArr[<%=count%>][0] = <%=mstrTaskType.getId()%>;
taskArr[<%=count%>][1] = <%=mstrTask.getId()%>;									
taskArr[<%=count%>][2] = "<%=mstrTask.getTaskName()%>";
<%
count++;
}
}
}
}
%>
</script> 
<label><span>*</span>Role </label>
<select id="currencyId" name="<%=PROJECT_ROLE_ID %>" validate="Project Role,string,yes"  onchange="display(this.value);" >
<option value="0">Select</option>
<%
for(PrjRolewiseResourceReq prjRolewiseResourceReq:prjRoleWiseResourceList){
%>
<option value="<%=prjRolewiseResourceReq.getPjr().getId() %>"><%=prjRolewiseResourceReq.getPjr().getPjrName() %></option>
<%} %>
</select>

<label><span>*</span>Req. No </label>
<input type="text" id="reqResourceId"    name="<%=REQUIRED_NO %>" readonly="readonly"  value=""  validate="Required No.,int,yes"   maxlength="4" />

<div class="clear"></div>
<label><span>*</span>Hr Req.</label>
<input type="text" id="reqHr"  name="<%=HR_REQ %>"  onblur="calculateTotalCost()"  validate="Description,string,yes"    maxlength="40" />

<label><span>*</span>Cost/Hr </label>
<input type="text" id="costperHrId"  name="<%=COST_PER_HOUR %>" onblur="calculateTotalCost()" readonly="readonly"  validate="Cost per hr,float,yes"   maxlength="40" />


<label><span>*</span>Total Cost</label>
<input type="text" id="totalCostId"  name="<%=TOTAL_COST %>"   validate="total Cost,float,no" onblur="calculateTotalCost()"  maxlength="40" />

<div class="clear"></div>
</div>

<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('budgetSetting','projectTracking?method=saveBudgetSetting');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('budgetSetting','projectTracking?method=updateBudgetSetting')" accesskey="u" tabindex=1 />
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
			 <input type="hidden" name="<%= BUDGET_SETTING_ID%>" value="" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Budget Type"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= BUDGET_TYPE_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Budget SubHead"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= BUDGET_SUBHEADING_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Task Type"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=TASK_TYPE_ID%>";

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
data_header[6][0] = "Task"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=TASK_ID%>";

data_header[7] = new Array;
data_header[7][0] = "Role"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=PROJECT_ROLE_ID%>";

data_header[8] = new Array;
data_header[8][0] = "Req.No"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=REQUIRED_NO%>";

data_header[9] = new Array;
data_header[9][0] = "Hr.Req"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=HR_REQ%>";

data_header[10] = new Array;
data_header[10][0] = "CostPerHr"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=COST_PER_HOUR%>";

data_header[11] = new Array;
data_header[11][0] = "TotalCost"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%=TOTAL_COST%>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=STATUS%>";



data_arr = new Array();

<%


Iterator itr=prjBudgetsettingList.iterator();
int  counter=0;
while(itr.hasNext())
{
	PrjBudgetSetting prjPrjBudgetSetting= (PrjBudgetSetting)itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjPrjBudgetSetting.getId()%>
<%
	if(budgetTypeList.size()>0){
		for(MstrBudgetType mstrBudgetType :budgetTypeList){
			if(prjPrjBudgetSetting.getBudtid()!= null){
		if(mstrBudgetType.getId().equals(prjPrjBudgetSetting.getBudtid().getId())){
%>
data_arr[<%= counter%>][1] = "<%=mstrBudgetType.getBudgetTypeName() %>";
<%
		}
			}
		}
	}
		
%>
<%
	if(budgetSubHeadList.size()>0){
		for(MstrBudgetSubhead mstrBudgetSubhead :budgetSubHeadList){
			if(prjPrjBudgetSetting.getBudid()!= null){
		if(mstrBudgetSubhead.getId().equals(prjPrjBudgetSetting.getBudid().getId())){
%>
data_arr[<%= counter%>][2] = "<%=mstrBudgetSubhead.getBudName() %>";
<%
		}
			}
		}
	}
		
%>
<%
	if(taskTypeList.size()>0){
		for(MstrTaskType mstrTaskType :taskTypeList){
			if(prjPrjBudgetSetting.getTaskType()!= null){
		if(mstrTaskType.getId().equals(prjPrjBudgetSetting.getTaskType().getId())){
%>
data_arr[<%= counter%>][3] = "<%=mstrTaskType.getTaskTypeName() %>";
<%
		}
			}
		}
	}
		
%>
data_arr[<%= counter%>][4] = "<%= prjPrjBudgetSetting.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(prjPrjBudgetSetting.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= prjPrjBudgetSetting.getLastChgTime() %>"
<%
	if(projectTaskList.size()>0){
		for(MstrTask mstrTask :projectTaskList){
			if(prjPrjBudgetSetting.getTask()!= null){
			if(mstrTask.getId().equals(prjPrjBudgetSetting.getTask().getId())){
				%>
				data_arr[<%= counter%>][7] = "<%=mstrTask.getTaskName().trim() %>";
				<%
		}
			}
		}
	}
		
%>
<%
	if(projectRoleList.size()>0){
		for(MstrProjectrole mstrProjectrole :projectRoleList){
			if(prjPrjBudgetSetting.getPjr()!= null){
		if(mstrProjectrole.getId().equals(prjPrjBudgetSetting.getPjr().getId())){
%>
data_arr[<%= counter%>][8] = "<%=mstrProjectrole.getPjrName() %>";
<%
		}
			}
		}
	}
		
%>
<% if(prjPrjBudgetSetting.getReqResource() != null){%>
data_arr[<%= counter%>][9] = "<%=prjPrjBudgetSetting.getReqResource()%>";
<%
	}else{
%>
data_arr[<%= counter%>][9] = ""
<%
	}
%>
<% if(prjPrjBudgetSetting.getReqHr() != null){%>
data_arr[<%= counter%>][10] = "<%=prjPrjBudgetSetting.getReqHr()%>";
<%
	}else{
%>
data_arr[<%= counter%>][10] = ""
<%
	}
%>

<% if(prjPrjBudgetSetting.getCostPerHr() != null){%>
data_arr[<%= counter%>][11] = "<%=prjPrjBudgetSetting.getCostPerHr()%>";
<%
	}else{
%>
data_arr[<%= counter%>][11] = ""
<%
	}
%>



<% if(prjPrjBudgetSetting.getTotlCost() != null){%>
data_arr[<%= counter%>][12] = "<%=prjPrjBudgetSetting.getTotlCost()%>";
<%
	}else{
%>
data_arr[<%= counter%>][12] = ""
<%
	}
%>

<% 
if(prjPrjBudgetSetting.getStatus().equals("y")){ %>
data_arr[<%= counter%>][13] = "Active"
<%}else{%>
data_arr[<%= counter%>][13] = "InActive"
<%}%>

<%

counter++;
}
%>


formName = "budgetSetting"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	

