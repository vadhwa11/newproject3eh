<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.HrMasVisitType"%>

<%@page import="jkt.hrms.masters.business.PrjScheduleHeader"%>
<%@page import="jkt.hrms.masters.business.PrjScheduleDetail"%>
<%@page import="jkt.hrms.masters.business.PrjPatvisitsch"%>
<%@page import="jkt.hrms.masters.business.MstrPtvisit"%>

<script type="text/javascript" language="javascript" src="../jsp/js/proto.js"></script>
<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
				List<HrMasVisitType> masVisitTypeList = new ArrayList<HrMasVisitType>();
				List<PrjScheduleDetail> prjDetailList = new ArrayList<PrjScheduleDetail>();
				List<PrjPatvisitsch> prjpatientVistList = new ArrayList<PrjPatvisitsch>();
				List<MstrPtvisit> ptVisitList = new ArrayList<MstrPtvisit>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("fesStudyHeaderList")!= null){
					fesStudyHeaderList = (List)map.get("fesStudyHeaderList");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("masVisitTypeList")!= null){
					masVisitTypeList = (List)map.get("masVisitTypeList");
				}
				if(map.get("prjpatientVistList")!= null){
					prjpatientVistList = (List)map.get("prjpatientVistList");
				}
				if(map.get("prjDetailList")!= null){
					prjDetailList = (List)map.get("prjDetailList");
				}
				if(map.get("ptVisitList")!= null){
					ptVisitList = (List)map.get("ptVisitList");
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
				String siteCode = "";
				String piName = "";
				String siteInitiateDate = "";
				if(fesStudyHeaderList.size()>0){
					for(PrjFesStudyHeader prjFesStudyHeader :fesStudyHeaderList){
						siteId = prjFesStudyHeader.getSiteHeader().getId();
						siteName = prjFesStudyHeader.getSiteHeader().getSiteName();
						siteCode = prjFesStudyHeader.getSiteHeader().getSiteCode();
						if(prjFesStudyHeader.getPiHeader().getPiName() != null){
						piName  = prjFesStudyHeader.getPiHeader().getPiName();
						}
						if(prjFesStudyHeader.getSiteInitiateDate()!= null){
							siteInitiateDate =HMSUtil.convertDateToStringWithoutTime(prjFesStudyHeader.getSiteInitiateDate());
						}
				 }
				
				}
				int visitTypeId= 0;
				if(prjDetailList.size()>0){
					for(PrjScheduleDetail prjScheduleDetail:prjDetailList){
						visitTypeId = prjScheduleDetail.getScheduleHeader().getVisit().getId();
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
		//alert(plannedDate);
		//alert(actualDate);
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
		   // alert(variation);
		    document.getElementById('variationId'+inc).value = variation;
}
</script>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>

<div class="titleBg"> <h2>Create Schedule</h2></div>

<div class="clear"></div>
<form name="scheduleSetting" method="post" action="" >
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
<label><%=siteName %></label>
<label>Site Initiation Date</label>
<label><%=siteInitiateDate %><input type="hidden" name="siteInitiationDate"   value="<%=siteInitiateDate %>" /></label>
<div class="clear"></div>
<div class="clear"></div>

</div>

	<label><span>*</span>Visit Type</label> 
	<select name="<%=PATIENT_VISIT_TYPE%>" id="<%= PATIENT_VISIT_TYPE %>" validate="P Visit Type,string,yes"
		 tabindex=1>
		<option value="0">Select</option>
		<%
			
			for (HrMasVisitType hrMasVisitType: masVisitTypeList ) {
				if(hrMasVisitType.getId().equals(visitTypeId) ){
				%>
				<option value="<%=hrMasVisitType.getId()%>" selected="selected"><%=hrMasVisitType.getVisitType()%></option>
		<%
				}else{
		%>
						<option value="<%=hrMasVisitType.getId()%>" ><%=hrMasVisitType.getVisitType()%></option>
		
		<%}} %>
	</select>
	<input type="hidden" name="<%=PROJECT_ID%>"   value="<%=projectId%>" />
<input type="hidden" name="<%=SITE_ID%>"   value="<%=siteId%>" />
            <input type="button" name="add" id="addbutton" value="Create Schedule" class="button" onClick="submitForm('scheduleSetting','projectTracking?method=createSchedule');" accesskey="a" tabindex=1/>
<div class="clear"></div>
<div class="division"></div>
<div id="pageNavPosition"></div>
<table id="searchresulttable">
<tr>
<th>Select</th>
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
if(prjDetailList.size()>0){
			for(PrjScheduleDetail prjScheduleDetail: prjDetailList){
				
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
	

%>
<tr class=<%= klass%> id="<%=count%>" >
<td><input name="scheduleDetailId"  class="radioCheck"  id="scheduleDetailId<%=i%>" type="radio" value="<%=prjScheduleDetail.getId() %>"/>
<input type="hidden" id="scheduleDetailId<%=i%>" name="scheduleDetailId<%=i%>"  value="<%=prjScheduleDetail.getId() %>"  /></td>
<%
if(ptVisitList.size()>0){
for(MstrPtvisit mstrPtvisit:ptVisitList){	
if(prjScheduleDetail.getPatientVisit().getId().equals(mstrPtvisit.getId())){ %>
<td><%=mstrPtvisit.getPatientVisitName()%></td>
<%}}}else{ %>
<td>--</td>
<% }%>
<td><%=prjScheduleDetail.getVisitInterval() %></td>
<td ><%=HMSUtil.convertDateToStringWithoutTime(prjScheduleDetail.getPlannedDate()) %>
<input type="hidden" id="plannedDateId<%=i%>" name="<%=PLANNED_DATE %><%=i%>"  value="<%=HMSUtil.convertDateToStringWithoutTime(prjScheduleDetail.getPlannedDate())%>" onblur="daysdifference(<%=i%>);" /></td>
<td><input id="revisedDateId<%=i%>" class="small" type="text"   name="<%=REVISED_DATE %><%=i%>" value="<%=HMSUtil.convertDateToStringWithoutTime(prjScheduleDetail.getRevisedDate())%>"  class="date"  readonly="readonly" validate="Randomization date ,date,no" MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('revisedDateId<%=i%>'),event)"/></td>
 

<%if( prjScheduleDetail.getActualDate() != null){ %>
<td><input id="actualDateId<%=i%>" class="small" type="text"   name="<%=ACTUAL_DATE %><%=i%>" value="<%=HMSUtil.convertDateToStringWithoutTime(prjScheduleDetail.getActualDate())%>"  class="date"  readonly="readonly" validate="Randomization date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('actualDateId<%=i%>'),event)" onblur="daysdifference(<%=i%>);"/></td>
 <%}else{ %>
 <td><input id="actualDateId<%=i%>" class="small" type="text"   name="<%=ACTUAL_DATE %><%=i%>" value=""  class="date"  readonly="readonly" validate="Randomization date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('actualDateId<%=i%>'),event)" onblur="daysdifference(<%=i%>);"/></td>
 <%} %>
 <%if(prjScheduleDetail.getVariation() != null){ %>
 <td><input type="text" id="variationId<%=i%>" name="<%=VARIATION %><%=i%>" class="small"  value="<%=prjScheduleDetail.getVariation() %>" validate="Screening No.,string,no" onblur="daysdifference(<%=i%>);"   maxlength="40" /></td>
 <%}else{ %>
  <td><input type="text" id="variationId<%=i%>" name="<%=VARIATION %><%=i%>" class="small"  value="" validate="Screening No.,string,no" onblur="daysdifference(<%=i%>);"   maxlength="40" /></td>
 <%} %>
 <td>
 <select id="statusId<%=i%>"  name="<%=STATUS%><%=i%>"  >
<option value="0">Select</option>
<option value="monitored">Monitored</option>
<option value="pMonitored">PartiallyMonitored</option>
<option value="nMonitored">NotMonitored</option>
<option value="complete">Completed</option>
<option value="notComplete">Not Completed</option>
</select></td>
<script>

document.getElementById('statusId<%=i%>').value = '<%=prjScheduleDetail.getScheduleStatus()%>'; 
</script>
<%if(prjScheduleDetail.getComment()!= null){ %>
<td ><input type="text" name="<%=COMMENTS %><%=i%>"  value="<%=prjScheduleDetail.getComment() %>" validate="Screening No.,string,no"   maxlength="40" />
<%}else{ %>
<td ><input type="text" name="<%=COMMENTS %><%=i%>"  value="" validate="Screening No.,string,no"   maxlength="40" />

<%} %>
<input type="hidden" name="scheduleHeaderId<%=i%>"   value="" />
</td>
</tr>
<%i++;}} %>
</tbody>
</table>

 <input type="hidden" id="countId" name="counter" value="<%=i%>">
<input name="add" type="button" class="button" value="Submit" onClick="submitForm('scheduleSetting','projectTracking?method=editScheduleDetails');"/>
<input type="button" name="attach" id="attach"  value="Attach Files" class="button" onClick="if(validateRadio()){javascript:openPopupWindow()};" />
<input type="button" name="attach" id="attach"  value="View Files" class="button" onClick="if(validateRadio()){javascript:openPopupWindow()};" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<script language="javascript">
	var pager = new Pager('tableData',5); 
		pager.init(); 
		pager.showPageNav('pager', 'pageNavPosition'); 
		pager.showPage(1);
		
function openPopupWindow()
			{ var id = 0; 
				 for(var i = 0; i < document.getElementsByName('scheduleDetailId').length; i++){
					  if(document.getElementsByName('scheduleDetailId')[i].checked == true)
		              {
						id = document.getElementsByName('scheduleDetailId')[i].value;
					  }		
		  		}
		  		var url="/hms/hrms/projectTracking?method=attachScheduleDocument&scheduleDetailId="+id+"";
		 		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		 	
			}
			
			
	function validateRadio(){
			 for(var i = 0; i < document.getElementsByName('scheduleDetailId').length; i++){
			  if(document.getElementsByName('scheduleDetailId')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please select Record to attach document...");
		return false;
		
	}		
function openPopupWindow()
			{ var id = 0; 
				 for(var i = 0; i < document.getElementsByName('scheduleDetailId').length; i++){
					  if(document.getElementsByName('scheduleDetailId')[i].checked == true)
		              {
						id = document.getElementsByName('scheduleDetailId')[i].value;
					  }		
		  		}
		  		var url="/hms/hrms/projectTracking?method=viewCreateScheduleDocument&scheduleDetailId="+id+"";
		 		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		 	
			}		
		
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
