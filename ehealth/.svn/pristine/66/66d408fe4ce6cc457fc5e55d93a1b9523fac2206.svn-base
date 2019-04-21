<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
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
				if(map.get("projectRoleList")!= null){
					projectRoleList = (List)map.get("projectRoleList");
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
<%@page import="jkt.hrms.masters.business.MstrProjectrole"%>
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
  		 obj.action = "projectTracking?method=showBudgetSettingJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	
	}
	
</script>


<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>
<div class="titleBg"><h2>Role Wise Required </h2></div>
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
<label><%=budget %>&nbsp;</label>
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
[0, "<%= ROLE_WISE_RESOURCE_REQ_ID%>", "id"], [1,"<%=PROJECT_ROLE_ID%>"], [2,"<%= REQUIRED_NO %>"],[3,"<%=COST_PER_HOUR%>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],
[7,"<%=PROJECT_ID%>"],[8,"<%=STATUS%>"]];
statusTd =8;
</script>
</div>
<div class="clear"></div>
<form name="roleWiseResourceRequired" method="post" action="" >
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>

<label><span>*</span>Project Role </label>
<select id="currencyId" name="<%=PROJECT_ROLE_ID %>" validate="Project Role,string,yes"  >
<option value="0">Select</option>
<%
	for(MstrProjectrole mstrProjectrole :projectRoleList){
%>
<option value="<%=mstrProjectrole.getId() %>"><%=mstrProjectrole.getPjrName() %></option>
<%} %>
</select>
<input type="hidden" name="<%=PROJECT_ID %>"  value="<%=projectId %>" />
<label><span>*</span>Required No </label>
<input type="text"    name="<%=REQUIRED_NO %>"  validate="Reqouired No,int,yes"   maxlength="4" />
<label><span>*</span>Cost/Hr </label>
<input type="text"   name="<%=COST_PER_HOUR %>"   validate="Cost Per Hr,float,yes"   maxlength="12" />

<div class="clear"></div>
</div>

<div class="clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('roleWiseResourceRequired','projectTracking?method=saveRoleWiseResourceRequired');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('roleWiseResourceRequired','projectTracking?method=updateRoleWiseResourceRequired')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('projectCreation','training?method=deleteTrainingMaster&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="add" id="addbutton" value="Back" class="button" onClick="backProjectSetting();" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Next" class="button" onClick="nextrojectSetting();" accesskey="a" tabindex=1 />
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
			<input type="hidden" name="<%= ROLE_WISE_RESOURCE_REQ_ID%>" value="" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Project Role"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= PROJECT_ROLE_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Required No"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= REQUIRED_NO %>";

data_header[2] = new Array;
data_header[2][0] = "Cost/Hr"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=COST_PER_HOUR%>";

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
data_header[6][3] = "<%=PROJECT_ID%>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS%>";


data_arr = new Array();

<%


Iterator itr=prjRoleWiseResourceList.iterator();
int  counter=0;
while(itr.hasNext())
{


	PrjRolewiseResourceReq prjRolewiseResourceReq= (PrjRolewiseResourceReq)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjRolewiseResourceReq.getId()%>
<%
	if(projectRoleList.size()>0){
		for(MstrProjectrole mstrProjectrole :projectRoleList){
			if(prjRolewiseResourceReq.getPjr()!= null){
		if(mstrProjectrole.getId().equals(prjRolewiseResourceReq.getPjr().getId())){
%>
data_arr[<%= counter%>][1] = "<%=mstrProjectrole.getPjrName() %>";
<%
		}
			}
		}
	}
		
%>
<% if(prjRolewiseResourceReq.getResCount()!= null){%>
data_arr[<%= counter%>][2] = "<%=prjRolewiseResourceReq.getResCount() %>";
<%
	}else{
%>
data_arr[<%= counter%>][2] = ""
<%
	}
%>
<% if(prjRolewiseResourceReq.getCostPerHr()!= null){%>
data_arr[<%= counter%>][3] = "<%=prjRolewiseResourceReq.getCostPerHr()%>";
<%
	}else{
%>
data_arr[<%= counter%>][3] = ""
<%
	}
%>
<% if(prjRolewiseResourceReq.getLastChgBy()!= null){%>
data_arr[<%= counter%>][4] = "<%= prjRolewiseResourceReq.getLastChgBy() %>"
<%
	}else{
%>
data_arr[<%= counter%>][4] = ""
<%
	}
%>
<% if(prjRolewiseResourceReq.getLastChgDate()!= null){%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(prjRolewiseResourceReq.getLastChgDate()) %>"
<%
	}else{
%>
data_arr[<%= counter%>][5] = ""
<%
	}
%>
<% if(prjRolewiseResourceReq.getLastChgDate()!= null){%>
data_arr[<%= counter%>][6] = "<%= prjRolewiseResourceReq.getLastChgTime() %>"
<%
	}else{
%>
data_arr[<%= counter%>][6] = ""
<%
	}
%>
<%
	if(projectList.size()>0){
		for(MstrProject mstrProject :projectList){
			if(prjRolewiseResourceReq.getPrj()!= null){
		if(mstrProject.getId().equals(prjRolewiseResourceReq.getPrj().getId())){
%>
data_arr[<%= counter%>][7] = "<%= mstrProject.getId() %>"
<%
		}
			}
		}
	}
		
%>

<% 

if(prjRolewiseResourceReq.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>

<%

counter++;
}
%>


formName = "roleWiseResourceRequired"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	


