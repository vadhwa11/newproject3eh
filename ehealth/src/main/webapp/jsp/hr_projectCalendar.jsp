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
				List<ProjectCalendar> projectCalendarList = new ArrayList<ProjectCalendar>();
				List<MstrCalendar> calendarList = new ArrayList<MstrCalendar>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				
				if(map.get("projectCalendarList")!= null){
					projectCalendarList = (List)map.get("projectCalendarList");
				}
				if(map.get("calendarList")!= null){
					calendarList = (List)map.get("calendarList");
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
<%@page import="jkt.hrms.masters.business.ProjectCalendar"%>
<%@page import="jkt.hrms.masters.business.MstrCalendar"%>
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
  		 obj.action = "projectTracking?method=showVendorContractJsp&projectId="+id;
  		 obj.submit();
  		 return true;
	
	}
	function checkRevisedDate(){
		var pDate = document.getElementById('plannedDateId').value;
		var rDate =document.getElementById('revisedDateId').value;
		
		var	plannedDate =new Date(pDate.substring(6),(pDate.substring(3,5) - 1) ,pDate.substring(0,2))
		var revisedDate =new Date(rDate.substring(6),(rDate.substring(3,5) - 1) ,rDate.substring(0,2))
		
		if(pDate != "" && rDate != ""){
			if(revisedDate < plannedDate){
				alert(" Revised Date should be greater than equal to  Planned Date.");
				document.getElementById('revisedDateId').value = "";
				return false;
		}
		}
		return true;
	}
	function checkActualDate(){
		var rDate =document.getElementById('revisedDateId').value;
		var aDate =document.getElementById('actualDateId').value;
		
		var revisedDate =new Date(rDate.substring(6),(rDate.substring(3,5) - 1) ,rDate.substring(0,2))
		var actualDate =new Date(aDate.substring(6),(aDate.substring(3,5) - 1) ,aDate.substring(0,2))
		
		if(rDate != "" && aDate != ""){
			 if(actualDate < revisedDate)
			{
				alert(" Actual Date should be greater than equal to  Revised Date.");
				document.getElementById('actualDateId').value= "";
				return false;
			}
		}
		return true;
	}
	
</script>

<div class="titleBg"><h2>Project Calendar </h2></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
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
[0, "<%= PROJECT_CALENDAR_ID%>", "id"], [1,"<%=CALENDAR_ID%>"], [2,"<%= PLANNED_DATE %>"],[3,"<%=PLANNED_REMARK%>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],
[7,"<%=REVISED_DATE%>"],[8,"<%=REVISED_REMARK%>"],[9,"<%=ACTUAL_DATE%>"],[10,"<%=ACTUAL_REMARK%>"],[11,"<%=NO_OF_DAYS%>"],[12,"<%=STATUS%>"]];
statusTd =12;
</script>
</div>
<div class="clear"></div>
<form name="projectCalendar" method="post" action="" >
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label><span>*</span> Project Event </label>
<select  name="<%=CALENDAR_ID %>" validate="Patient Visit,yes"  >
<option value="0">Select</option>
<%
	for(MstrCalendar mstrCalendar :calendarList){
%>
<option value="<%=mstrCalendar.getId() %>"><%=mstrCalendar.getCalendarName() %></option>
<%} %>
</select>
<input type="hidden" name="<%=PROJECT_ID %>"  value="<%=projectId %>" />
<div class="clear"></div>
<label><span>*</span>Planned Date </label>
<input id="plannedDateId" type="text"  name="<%=PLANNED_DATE %>" value="" class="date"  readonly="readonly" validate="Planned date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('plannedDateId'),event)"/>

<label>Remark </label>
<input type="text" id="paymentPercentageId"  name="<%=PLANNED_REMARK %>" class="large" validate="Planned Remark,string,no"   maxlength="50" />
<div class="clear"></div>
<label>Revised Date</label>
<input id="revisedDateId" type="text"  name="<%=REVISED_DATE %>" value="" class="date"  readonly="readonly" validate="Revised date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('revisedDateId'),event)"/>

<label>Remark </label>
<input type="text" id="paymentPercentageId"  name="<%=REVISED_REMARK %>"  class="large" validate="Revised Remark,string,no"   maxlength="50" />
<div class="clear"></div>
<label><span>*</span>Actual Date</label>
<input id="actualDateId" type="text"  name="<%=ACTUAL_DATE %>" value="" class="date"  readonly="readonly" validate="Actual date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('actualDateId'),event)"/>

<label>Remark </label>
<input type="text" id="paymentPercentageId"  name="<%=ACTUAL_REMARK %>"  validate="Remark,string,no"  class="large"   maxlength="50" />
<div class="clear"></div>
<label>No. Of Days </label>
<input type="text" id="paymentPercentageId"  name="<%=NO_OF_DAYS %>"   validate="No.Of Days,float,no"   maxlength="3" />
<div class="clear"></div>
</div>

<div class="clear"></div>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('projectCalendar','projectTracking?method=saveProjectCalendar','checkRevisedDate','checkActualDate');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('projectCalendar','projectTracking?method=updateProjectCalendar','checkRevisedDate','checkActualDate')" accesskey="u" tabindex=1 />
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
			 <input type="hidden" name="<%= PROJECT_CALENDAR_ID%>" value="" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Calender Event"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CALENDAR_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Planned Date"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= PLANNED_DATE %>";

data_header[2] = new Array;
data_header[2][0] = "Planned Remark"
data_header[2][1] = "data";
data_header[2][2] = "10%"
data_header[2][3] = "<%=PLANNED_REMARK%>";

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
data_header[6][0] = "Revised date"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=REVISED_DATE%>";

data_header[7] = new Array;
data_header[7][0] = "Revised Remark"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=REVISED_REMARK%>";

data_header[8] = new Array;
data_header[8][0] = "Actual date"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=ACTUAL_DATE%>";

data_header[9] = new Array;
data_header[9][0] = "Actual remark"
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=ACTUAL_REMARK%>";


data_header[10] = new Array;
data_header[10][0] = "No. Of Days"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=NO_OF_DAYS%>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "<%=STATUS%>";


data_arr = new Array();

<%


Iterator itr=projectCalendarList.iterator();
int  counter=0;
while(itr.hasNext())
{


	ProjectCalendar projectCalendar= (ProjectCalendar)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= projectCalendar.getId()%>
<%
	if(calendarList.size()>0){
		for(MstrCalendar mstrCalendar :calendarList){
			if(projectCalendar.getCalendar()!= null){
		if(mstrCalendar.getId().equals(projectCalendar.getCalendar().getId())){
%>
data_arr[<%= counter%>][1] = "<%=mstrCalendar.getCalendarName() %>";
<%
		}
			}
		}
	}
		
%>
<%if(projectCalendar.getPlannedDate() != null){%>
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(projectCalendar.getPlannedDate())%>";
<%
	}else{
%>
data_arr[<%= counter%>][2] = ""
<%
	}
%>
<%if(projectCalendar.getPlannedRemark() != null){%>
data_arr[<%= counter%>][3] = "<%=projectCalendar.getPlannedRemark()%>";
<%
	}else{
%>
data_arr[<%= counter%>][3] = ""
<%
	}
%>
data_arr[<%= counter%>][4] = "<%= projectCalendar.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(projectCalendar.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= projectCalendar.getLastChgTime() %>"
<%if(projectCalendar.getRevisedDate()  != null){%>
data_arr[<%= counter%>][7] = "<%=HMSUtil.convertDateToStringWithoutTime(projectCalendar.getRevisedDate()) %>"
<%
	}else{
%>
data_arr[<%= counter%>][7] = ""
<%
	}
%>
<%if(projectCalendar.getRevisedRemark() != null){%>
data_arr[<%= counter%>][8] = "<%=projectCalendar.getRevisedRemark() %>"
<%
	}else{
%>
data_arr[<%= counter%>][8] = ""
<%
	}
%>

<%if(projectCalendar.getActualDate() != null){%>
data_arr[<%= counter%>][9] = "<%=HMSUtil.convertDateToStringWithoutTime(projectCalendar.getActualDate()) %>"
<%
	}else{
%>
data_arr[<%= counter%>][9] = ""
<%
	}
%>

<%if(projectCalendar.getActualRemark() != null){%>
data_arr[<%= counter%>][10] = "<%=projectCalendar.getActualRemark() %>"
<%
	}else{
%>
data_arr[<%= counter%>][10] = ""
<%
	}
%>
<%if(projectCalendar.getNoOfDays() != null){%>
data_arr[<%= counter%>][11] = "<%=projectCalendar.getNoOfDays() %>"
<%
	}else{
%>
data_arr[<%= counter%>][11] = ""
<%
	}
%>



<% 
if(projectCalendar.getStatus().equals("y")){ %>
data_arr[<%= counter%>][12] = "Active"
<%}else{%>
data_arr[<%= counter%>][12] = "InActive"
<%}%>

<%

counter++;
}
%>


formName = "projectCalendar"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	

