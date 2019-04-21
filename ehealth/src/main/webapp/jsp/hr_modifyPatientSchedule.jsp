<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.PrjSiteResMap"%>
<%@page import="jkt.hrms.masters.business.PrjAddPtHeader"%>
<%@page import="jkt.hrms.masters.business.PrjAddPtDetail"%>
<script type="text/javascript" language="javascript" src="../jsp/js/proto.js"></script>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<PrjSiteResMap> prjSiteResMapSiteList = new ArrayList<PrjSiteResMap>();
				List<PrjAddPtHeader> prjAddPatientHeaderList1 = new ArrayList<PrjAddPtHeader>();
				List<PrjAddPtHeader> prjAddPatientHeaderList = new ArrayList<PrjAddPtHeader>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("prjAddPatientHeaderList1")!= null){
					prjAddPatientHeaderList1 = (List)map.get("prjAddPatientHeaderList1");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("prjAddPatientHeaderList")!= null){
					prjAddPatientHeaderList = (List)map.get("prjAddPatientHeaderList");
				}
				if(map.get("prjSiteResMapSiteList")!= null){
					prjSiteResMapSiteList = (List)map.get("prjSiteResMapSiteList");
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
				int   projectId    = 0;
				String projectName = "";
				String projectCode = "";
				String sponsorName  = "";
				String trialPhase = "";
				String protocolNo = "";
				String projectType = "";
				String projectStatus = "";
				
				if(projectList.size()>0){
					for (MstrProject mstrProject :projectList){
						projectId     =	mstrProject.getId();				
						projectName   = mstrProject.getPrjName();
						projectCode   = mstrProject.getPrjCode();
						sponsorName   = mstrProject.getSponsor().getSponsorName();
						trialPhase    = mstrProject.getTrialPhase().getTrialPhaseName();
						protocolNo    = mstrProject.getPrjProtocalno();
						projectType   = mstrProject.getProjectType().getProjectName();
						projectStatus = mstrProject.getProjectStatus().getPrjsName();
					}
				}
				int siteId= 0;
				String siteName = "";
				if(prjSiteResMapSiteList.size()>0){
					for(PrjSiteResMap prjSiteResMap:prjSiteResMapSiteList){
						siteId = prjSiteResMap.getSiteHeader().getId();
						siteName = prjSiteResMap.getSiteHeader().getSiteName();
				 }
				}
				Set<PrjAddPtDetail> prjAddPatientDetailSet = new HashSet();
				int addPatientHeaderId = 0;
				if(prjAddPatientHeaderList.size()>0){
					for(PrjAddPtHeader prjAddPtHeader :prjAddPatientHeaderList){
						
						prjAddPatientDetailSet = prjAddPtHeader.getPrjAddPtDetails();
						addPatientHeaderId = prjAddPtHeader.getId();
					}
				}
				
	%>
 

<%@page import="jkt.hrms.masters.business.PrjFesStudyHeader"%>

<script>
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

</script>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>

<div class="titleBg"> <h2>Modify Patient Schedule</h2></div>

<div class="clear"></div>
<form name="modifyPatientSchedule" method="post" action="" >
<div class="clear"></div>
<div class="Block">
<label>Project Name</label>
<label ><%=projectName %></label>
<label>Project Code</label>
<label><%=projectCode %></label>
<label>Project Status </label>
<label><%=projectStatus %></label>
<div class="clear"></div>
<label>Trial Phase </label>
<label><%=trialPhase %></label>
<label>Protocol No </label>
<label><%=protocolNo %></label>
<label>Project Type</label>
<label><%=projectType %></label>
<label>Site Name</label>
<label class = "auto"><%=siteName %></label>
<div class="clear"></div>
<div class="clear"></div>
<label><span>*</span>Patient </label>
<select  name="<%=ADD_PATIENT_HEADER_ID %>" onchange="submitForm('modifyPatientSchedule','projectTracking?method=saveModifyPatientSchedule');"  >
<option value="0">Select</option>
<%
for(PrjAddPtHeader prjAddPtHeader :prjAddPatientHeaderList1){
	if(prjAddPtHeader.getId().equals(addPatientHeaderId)){
%>
<option value="<%=prjAddPtHeader.getId() %>" selected="selected"><%=prjAddPtHeader.getPatientInitials()%></option>
<%}else{ %>
<option value="<%=prjAddPtHeader.getId() %>"><%=prjAddPtHeader.getPatientInitials()%></option>
<%} }%>
</select>
</div>


<div class="clear"></div>
<div class="division"></div>
<div id="pageNavPosition"></div>
<table id="searchresulttable">
<tr>
<th>VisitName</th>
<th>Interval</th>
<th>Plan.Date</th>
<th>Rev.Date</th>
<th>Act.Date</th>
<th>Variation</th>
<th>Status</th>
<th>Comment</th>

</tr>
<tbody id="tableData">
<%
int i = 0;	
int count = 0;
String klass = "even";
if(prjAddPatientDetailSet.size()>0){
			for(PrjAddPtDetail prjAddPtDetail : prjAddPatientDetailSet){
				String id = "";
		 		id = "id" + count;
		 		count++;
		 		
		 		if(count%2==0){
		 			klass = "even"; 
		 		}
		 		else
		 		{
		 			klass= "odd";
		 		}
	
				
String revisedDate = "";
if(prjAddPtDetail.getRevisedDate()!= null){
	revisedDate = HMSUtil.convertDateToStringWithoutTime(prjAddPtDetail.getRevisedDate());
}


%>
<tr class=<%= klass%> id="<%=count%>">
<td width="20%"><%=prjAddPtDetail.getPv().getPatientVisit().getPatientVisitName() %></td>
<td width="20%"><%=prjAddPtDetail.getVisitInterval() %></td>
<td width="20%"><%=HMSUtil.convertDateToStringWithoutTime(prjAddPtDetail.getPlannedDate())%>
<td width="40%"><input id="actualDateId<%=i%>" class="small" type="text"   name="<%=REVISED_DATE %><%=i%>" value="<%=revisedDate%>"  class="date"  readonly="readonly" validate="Randomization date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('actualDateId<%=i %>'),event)"/></td>
 <%if(prjAddPtDetail.getActualDate()!= null){ %>
 <td width="20%"><%=HMSUtil.convertDateToStringWithoutTime(prjAddPtDetail.getActualDate())%></td>
 <%}else{ %>
 <td width="20%">--</td>
 <%} %>
 <%if(prjAddPtDetail.getVariation()!= null){ %>
 <td width="20%"><%=prjAddPtDetail.getVariation()%></td>
 <%}else{ %>
 <td width="20%">--</td>
 <%} %>
  <%if(prjAddPtDetail.getScheduleStatus()!= null){ %>
 <td><%=prjAddPtDetail.getScheduleStatus()%></td>
<%}else{ %>
 <td>--</td>
 <%} %>
   <%if(prjAddPtDetail.getComments()!= null){ %>
<td ><%=prjAddPtDetail.getComments()%>
<%}else{ %>
 <td>--</td>
 <%} %>
<input type="hidden" name="<%=ADD_PATIENT_DETAIL_ID %><%=i%>"   value="<%=prjAddPtDetail.getId() %>" />
</td>
</tr>
<%
	i++;
	}} %>
	</tbody>
</table>
<input type="hidden" name="<%=PROJECT_ID%>"   value="<%=projectId %>" />
<input type="hidden" name="<%=SITE_ID%>"   value="<%=siteId%>" />
 <input type="hidden" id="countId" name="counter" value="<%=i%>">
<input type="button" name="add" id="addbutton" value="Submit" class="button" onClick="submitForm('modifyPatientSchedule','projectTracking?method=updateModifyPatientScheduleByPL');" accesskey="a" tabindex=1/>

<script type="text/javascript">
		var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
		

</script>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>