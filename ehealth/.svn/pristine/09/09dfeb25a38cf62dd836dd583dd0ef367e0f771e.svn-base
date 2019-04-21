<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
				List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
				List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<PrjRoleResMappingHeader> roleResMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
				List<MstrRoleTaskMap>roleTaskMappingList = new ArrayList<MstrRoleTaskMap>();
				List<MstrTaskType> taskTypeList = new ArrayList<MstrTaskType>();
				List<MstrTask> taskList = new ArrayList<MstrTask>();
				List<PrjRoleResMappingDetail> prjRoleResourceMappingDetailList = new ArrayList<PrjRoleResMappingDetail>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("prjRoleResourceMappingDetailList")!= null){
					prjRoleResourceMappingDetailList = (List)map.get("prjRoleResourceMappingDetailList");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("projectRoleList")!= null){
					projectRoleList = (List)map.get("projectRoleList");
				}
				if(map.get("prjRoleWiseResourceList")!= null){
					prjRoleWiseResourceList = (List)map.get("prjRoleWiseResourceList");
				}
				if(map.get("departmentList")!= null){
					departmentList = (List)map.get("departmentList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("roleResMappingHeaderList")!= null){
					roleResMappingHeaderList = (List)map.get("roleResMappingHeaderList");
				}
				if(map.get("roleTaskMappingList")!= null){
					roleTaskMappingList = (List)map.get("roleTaskMappingList");
				}
				if(map.get("taskTypeList")!= null){
					taskTypeList = (List)map.get("taskTypeList");
				}
				if(map.get("taskList")!= null){
					taskList = (List)map.get("taskList");
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
				int roleResourceHeaderId = 0;
				String projectRoleName = "";
				if(roleResMappingHeaderList.size()>0){
					for(PrjRoleResMappingHeader prjRoleResMappingHeader :roleResMappingHeaderList){
						roleResourceHeaderId = prjRoleResMappingHeader.getId();
						projectRoleName = prjRoleResMappingHeader.getPjr().getPjrName();
				}
			}
	%>
<%@page import="jkt.hrms.masters.business.PrjMilestone"%>
<%@page import="jkt.hrms.masters.business.MstrProjectrole"%>
<%@page import="jkt.hrms.masters.business.PrjRolewiseResourceReq"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.PrjRoleResMappingHeader"%>
<%@page import="jkt.hrms.masters.business.MstrRoleTaskMap"%>
<%@page import="jkt.hrms.masters.business.MstrTaskType"%>
<%@page import="jkt.hrms.masters.business.MstrTask"%>
<%@page import="jkt.hrms.masters.business.PrjRoleResMappingDetail"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
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
	function backTaskSetting()
	{
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showRoleResourceMappingJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	
	}
	
	function nextrojectSetting()
	{
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showBudgetSettingJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	
	}
	
function assignTask()
	{
		 var id1 = <%=roleResourceHeaderId%>
		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=saveAssignTaskToRoleResourceHeader&projectId="+id+"&roleResourceHeaderId="+id1;
  		 obj.submit();
  		 return true;
	
	}
</script>



<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>
<div class="titleBg"><h2>Task Setting</h2></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
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
</div>
<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>

<script type="text/javascript">

formFields = [
[0, "<%= ROLE_RESOURCE_MAPPING_DETAIL_ID%>", "id"], [1,"<%= TASK_TYPE_ID %>"], [2,"<%= TASK_ID %>"],[3,"<%=BILLABLE%>"] ,[4,"<%=STATUS%>"]];
statusTd =4;
</script>
</div>
<div class="clear"></div>
<form name="taskSetting" method="post" action="" >
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Project Role</label>


<label><%=projectRoleName %></label>

<label><span>*</span>Task Type </label>
<select id="currencyId" name="<%=TASK_TYPE_ID %>" validate="Task Type,string,yes" onChange="populateTask(this.value,'taskSetting')"  >
<option value="0">Select</option>
<%
for(MstrTaskType mstrTaskType :taskTypeList){
%>
<option value="<%=mstrTaskType.getId() %>"><%=mstrTaskType.getTaskTypeName() %></option>
<%} %>
</select>
<input type="hidden" name="<%=PROJECT_ID %>"  value="<%=projectId %>" />
<input type="hidden" name="<%=ROLE_RESOURCE_MAPPING_HEADER_ID %>"  value="<%=roleResourceHeaderId %>" />

<label><span>*</span>Task </label>
<select  name="<%=TASK_ID %>" validate="Task,string,yes"  >
<option value="0">Select</option>
<%
for(MstrTask mstrTask :taskList){
%>
<option value="<%=mstrTask.getId() %>"><%=mstrTask.getTaskName() %></option>
<%} %>
</select>

<script type="text/javascript">
	<%
	int count=0;
	for (MstrTaskType mstrTaskType :taskTypeList) 
	{
	for (MstrTask mstrTask :taskList) 
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
<div class="clear"></div>
<label>Billable </label>
<input  type="checkbox" id="billableId"" name="<%=BILLABLE%>"  value=""  class="radioCheck" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('taskSetting','projectTracking?method=saveTaskInRoleResourceMappingDetail');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('taskSetting','projectTracking?method=updateTaskInRoleResourceMappingDetail')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('projectCreation','training?method=deleteTrainingMaster&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="back" id="backbutton" value="Back" class="button" onClick="backTaskSetting();" accesskey="a" tabindex=1 />
<!-- <input type="button" name="edit" id="editbutton" value="AssignTask"  class="button" onClick="assignTask();" accesskey="u" tabindex=1 /> -->
<div class="clear"></div>

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
			<input type="hidden" name="<%= ROLE_RESOURCE_MAPPING_DETAIL_ID%>" value="" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Task Tupe"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= TASK_TYPE_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Task"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= TASK_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Billable"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=BILLABLE%>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "15%";
data_header[3][3] = "<%=STATUS%>";


data_arr = new Array();

<%


Iterator itr=prjRoleResourceMappingDetailList.iterator();
int  counter=0;
while(itr.hasNext())
{


	PrjRoleResMappingDetail prjRoleResMappingDetail= (PrjRoleResMappingDetail)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjRoleResMappingDetail.getId()%>
<%
	if(taskTypeList.size()>0){
		for(MstrTaskType mastrMstrTaskType :taskTypeList){
			if(prjRoleResMappingDetail.getTaskType()!= null){
		if(mastrMstrTaskType.getId().equals(prjRoleResMappingDetail.getTaskType().getId())){
%>
data_arr[<%= counter%>][1] = "<%= mastrMstrTaskType.getTaskTypeName() %>"
<%
		}
			}
		}
	}
		
%>
<%
	if(taskList.size()>0){
		for(MstrTask mstrTask :taskList){
			if(prjRoleResMappingDetail.getTask()!= null){
		if(mstrTask.getId().equals(prjRoleResMappingDetail.getTask().getId())){
%>
data_arr[<%= counter%>][2] = "<%=mstrTask.getTaskName() %>"
<%
		}
			}
		}
	}
	//}
		
%>
<% if(prjRoleResMappingDetail.getBillable() != null){ %>
data_arr[<%= counter%>][3] = "<%=prjRoleResMappingDetail.getBillable() %>"
<%
	}else{
%>
data_arr[<%= counter%>][3] = ""
<%
	}
%>
<% 
if(prjRoleResMappingDetail.getStatus().equals("y")){ %>
data_arr[<%= counter%>][4] = "Active"
<%}else{%>
data_arr[<%= counter%>][4] = "InActive"
<%}%>

<%

counter++;
}
%>


formName = "taskSetting"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	


