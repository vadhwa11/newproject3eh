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
				List<PrjAddPtHeader> prjAddPatientHeaderList = new ArrayList<PrjAddPtHeader>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("prjAddPatientHeaderList")!= null){
					prjAddPatientHeaderList = (List)map.get("prjAddPatientHeaderList");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
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
				if(prjAddPatientHeaderList.size()>0){
					for(PrjAddPtHeader prjAddPtHeader :prjAddPatientHeaderList){
						
						prjAddPatientDetailSet = prjAddPtHeader.getPrjAddPtDetails();
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
<script language="JavaScript" type="text/javascript">

function daysdifference(inc) {
		var plannedDate = document.getElementById('plannedDateId'+inc).value;
		var actualDate = document.getElementById('actualDateId'+inc).value;
		    var oneday = 1000 * 60 * 60 * 24;
		     var pDate=plannedDate.split("/");
   			 var date1=new Date(pDate[2],(pDate[1]-1),pDate[0]);
   			 
   			 var aDate=actualDate.split("/");
   			 var date2=new Date(aDate[2],(aDate[1]-1),aDate[0]);
   			 
		    var pdate1 = date1.getTime();
		    var adate2 = date2.getTime();
			
		    // Calculate the difference in milliseconds
		    var diff = Math.abs(pdate1 - adate2)
		    // Convert back to days and return
		    var variation =  Math.round(diff/oneday)
		    document.getElementById('variationId'+inc).value = variation;
}
</script>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>

<div class="titleBg"> <h2>Add Patient Schedule</h2></div>

<div class="clear"></div>
<form name="addPatientSchedule" method="post" action="" >
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

		String actualDate = "";
		int variation = 0;
		String comment = "";
		if(prjAddPtDetail.getActualDate()!= null){
		actualDate =HMSUtil.convertDateToStringWithoutTime(prjAddPtDetail.getActualDate());
		}
		if(prjAddPtDetail.getVariation()!= null){ 
			variation = prjAddPtDetail.getVariation();
		}
		if(prjAddPtDetail.getComments()!= null){
			comment = prjAddPtDetail.getComments();
		}
%>
<tr class=<%= klass%> id="<%=count%>">
<td width="20%"><%=prjAddPtDetail.getPv().getPatientVisit().getPatientVisitName() %></td>
<td width="20%"><%=prjAddPtDetail.getVisitInterval() %></td>
<td width="20%"><%=HMSUtil.convertDateToStringWithoutTime(prjAddPtDetail.getPlannedDate()) %>
<input type="hidden" id="plannedDateId<%=i%>" name="<%=PLANNED_DATE %><%=i%>"  value="<%=HMSUtil.convertDateToStringWithoutTime(prjAddPtDetail.getPlannedDate())%>"  /></td>
<td width="20%"></td>
<td width="40%"><input id="actualDateId<%=i%>" class="small" type="text"   name="<%=ACTUAL_DATE %><%=i%>" value="<%=actualDate%>"  class="date"  readonly="readonly" validate="Randomization date ,date,no" onblur="daysdifference(<%=i %>);" MAXLENGTH="30" />

 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('actualDateId<%=i %>'),event)"/></td>

 <td width="20%"><input type="text" id="variationId<%=i%>" name="<%=VARIATION %><%=i%>" class="small"  value="<%=variation%>" validate="Screening No.,string,no"   maxlength="40" /></td>
 <td>
 <select  name="<%=STATUS%><%=i%>"  >
<option value="0">Select</option>
<option value="monitored">Monitored</option>
<option value="pMonitored">PartiallyMonitored</option>
<option value="nMonitored">NotMonitored</option>
</select></td>

<td ><input type="text" name="<%=COMMENTS %><%=i%>"  value="<%=comment%>" validate="Screening No.,string,no"   maxlength="40" />

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
<input name="add" type="button" class="button" value="Add" onClick="submitForm('addPatientSchedule','projectTracking?method=updateAddPatientSchedule);"/>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script language="javascript">
var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);

function jsImport()
{
	if (document.getElementById('fileNameId').value == "")
		
	{
	alert('Pl. Select a file to Import!.....');
	return;
	}
	var fname = document.getElementById('fileNameId').value;
	
	
	//var st = fname.length;
	//st = st-3;
	//if (fname.substring(st)!="zip")
	//{
	//alert('Only zip files are Allowed. Please Zip all the Excel Files and Give the file as input !....For further Help, Refer User Manual.');
	//return;
	//}
	var ind1 = fname.lastIndexOf("\\");
	
	var filename = fname.substring(ind1+1);
	alert("filename--"+filename);
	document.addPatientSchedule.method="post";
	submitForm('addPatientSchedule','projectTracking?method=updateAddPatientSchedule&filename='+filename);
	
}

</script>
