<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<MstrVitals>  vitalsMasterList = new ArrayList<MstrVitals>();
				List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();	
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				List<MstrCalendar> calendarList = new ArrayList<MstrCalendar>();
				List<HrPrjSiteCalendar> siteCalendarList = new ArrayList<HrPrjSiteCalendar>();
				List<PrjSiteVital> siteVitalList = new ArrayList<PrjSiteVital>();
				List<UserButtonRights> userRightsList= new ArrayList<UserButtonRights>();
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("currencyList")!= null){
					currencyList = (List)map.get("currencyList");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("siteCalendarList")!= null){
					siteCalendarList = (List)map.get("siteCalendarList");
				}
				if(map.get("vitalsMasterList") != null){
			    	vitalsMasterList = (List)map.get("vitalsMasterList");
			    }
			    if(map.get("fesStudyHeaderList") != null){
			    	fesStudyHeaderList = (List)map.get("fesStudyHeaderList");
			    }
			    if(map.get("siteVitalList") != null){
			    	siteVitalList = (List)map.get("siteVitalList");
			    }
				if(map.get("calendarList")!= null){
					calendarList = (List)map.get("calendarList");
				}
				if (map.get("userRightsList") != null) {
					userRightsList = (List<UserButtonRights>)map.get("userRightsList") ;
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
				
	%>
 
<%@page import="jkt.hrms.masters.business.MstrVitals"%>
<%@page import="jkt.hrms.masters.business.ProjectVitals"%>
<%@page import="jkt.hrms.masters.business.PrjFesStudyHeader"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>
<%@page import="jkt.hrms.masters.business.PrjSiteVital"%>
<%@page import="jkt.hrms.masters.business.MstrCalendar"%>
<%@page import="jkt.hrms.masters.business.HrPrjSiteCalendar"%>
<%@page import="jkt.hms.masters.business.UserButtonRights"%>
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

<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>

<div class="titleBg"> <h2>Site Calendar</h2></div>

<div class="clear"></div>
<form name="projectInformation" method="post" action="" >
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
<label>Site Code</label>
<label><%=siteCode %></label>
<label>Pi Name</label>
<label><%=piName %></label>
<div class="clear"></div>
<label>Site Initiate Date</label>
<label><%=siteInitiateDate %></label>
<div class="clear"></div>

</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">

function backSiteSetting()
 {
     obj = eval('document.'+formName)
     obj.action = "projectTracking?method=showProjectSitesList";
     obj.submit();
     return true;
 
 }
 
 function nextSiteSetting()
 {
   var id = <%=projectId%>
   obj = eval('document.'+formName)
     obj.action = "projectTracking?method=showSiteResourceMappingJsp&projectId="+id;
     obj.submit();
     return true;
 
 }

</script>


<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>

<script type="text/javascript">

formFields = [
[0, "<%= SITE_CALENDAR_ID%>", "id"], [1,"<%=CALENDAR_ID%>"], [2,"<%= PLANNED_DATE %>"],[3,"<%=PLANNED_REMARK%>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],
[7,"<%=REVISED_DATE%>"],[8,"<%=REVISED_REMARK%>"],[9,"<%=ACTUAL_DATE%>"],[10,"<%=ACTUAL_REMARK%>"],[11,"<%=NO_OF_DAYS%>"],[12,"<%=STATUS%>"]];
statusTd =12;
</script>
</div>
<div class="clear"></div>
<form name="siteCalendar" method="post" action="" >
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
<input type="hidden" name="<%=SITE_ID %>"  value="<%=siteId%>" />

<div class="clear"></div>
<label><span>*</span>Planned </label>
<input id="plannedDateId" type="text"  name="<%=PLANNED_DATE %>" value="" class="date"  readonly="readonly" validate="Planned date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('plannedDateId'),event)"/>

<label>Remark </label>
<input type="text" id="paymentPercentageId"  name="<%=PLANNED_REMARK %>" class="large" validate="Planned Remark,string,no"   maxlength="80" />
<div class="clear"></div>
<label>Revised</label>
<input id="revisedDateId" type="text"  name="<%=REVISED_DATE %>" value="" class="date"  readonly="readonly" validate="Revised date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('revisedDateId'),event)"/>

<label>Remark </label>
<input type="text" id="paymentPercentageId"  name="<%=REVISED_REMARK %>"  class="large" validate="Revised Remark,string,no"   maxlength="80" />
<div class="clear"></div>
<label><span>*</span>Actual</label>
<input id="actualDateId" type="text"  name="<%=ACTUAL_DATE %>" value="" class="date"  readonly="readonly" validate="Actual date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('actualDateId'),event)"/>

<label>Remark </label>
<input type="text" id="paymentPercentageId"  name="<%=ACTUAL_REMARK %>"  validate="Remark,string,no"  class="large"   maxlength="40" />
<div class="clear"></div>
<label>No.Of Days </label>
<input type="text" id="paymentPercentageId"  name="<%=NO_OF_DAYS %>"   validate="No.Of Days,float,no"   maxlength="3" />
<div class="clear"></div>
</div>

<div class="clear"></div>

<div id="edited"></div>
			<%for(UserButtonRights userButtonRights : userRightsList){
					if(userButtonRights.getButton().getFormName().equalsIgnoreCase("Site Calendar")) {
						if(userButtonRights.getButton().getButtonName().equalsIgnoreCase("Add")){ %>
							<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('siteCalendar','projectTracking?method=saveSiteCalendar','checkRevisedDate','checkActualDate');" accesskey="a" tabindex=1 />
					  <%} else if(userButtonRights.getButton().getButtonName().equalsIgnoreCase("Update")){%>
							<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('siteCalendar','projectTracking?method=updateSiteCalendar','checkRevisedDate','checkActualDate')" accesskey="u" tabindex=1 />							
					  <%} %>
			<%}}%>

<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('siteCalendar','projectTracking?method=deleteSiteCalendar&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="add" id="addbutton" value="Back" class="button" onClick="backSiteSetting();" accesskey="a" tabindex=1 />
<input type="button" name="add" id="addbutton" value="Next" class="button" onClick="nextSiteSetting();" accesskey="a" tabindex=1 />
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
			 <input type="hidden" name="<%= SITE_CALENDAR_ID%>" value="" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "CalenderEvent"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= CALENDAR_ID %>";

data_header[1] = new Array;
data_header[1][0] = "Planned Date"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= PLANNED_DATE %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
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
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=REVISED_REMARK%>";

data_header[8] = new Array;
data_header[8][0] = "Actual date"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=ACTUAL_DATE%>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=ACTUAL_REMARK%>";


data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=NO_OF_DAYS%>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "<%=STATUS%>";


data_arr = new Array();

<%


Iterator itr=siteCalendarList.iterator();
int  counter=0;
while(itr.hasNext())
{
	HrPrjSiteCalendar siteCalendar= (HrPrjSiteCalendar)itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= siteCalendar.getId()%>
<%
	if(calendarList.size()>0){
		for(MstrCalendar mstrCalendar :calendarList){
			if(siteCalendar.getCalendar()!= null){
		if(mstrCalendar.getId().equals(siteCalendar.getCalendar().getId())){
%>
data_arr[<%= counter%>][1] = "<%=mstrCalendar.getCalendarName() %>";
<%
		}
			}
		}
	}
		
%>
<%if(siteCalendar.getPlannedDate() != null){%>
data_arr[<%= counter%>][2] = "<%=HMSUtil.convertDateToStringWithoutTime(siteCalendar.getPlannedDate())%>";
<%
	}else{
%>
data_arr[<%= counter%>][2] = ""
<%
	}
%>
<%if(siteCalendar.getPlannedRemark() != null){%>
data_arr[<%= counter%>][3] = "<%=siteCalendar.getPlannedRemark()%>";
<%
	}else{
%>
data_arr[<%= counter%>][3] = ""
<%
	}
%>
data_arr[<%= counter%>][4] = "<%= siteCalendar.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(siteCalendar.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= siteCalendar.getLastChgTime() %>"
<%if(siteCalendar.getRevisedDate()  != null){%>
data_arr[<%= counter%>][7] = "<%=HMSUtil.convertDateToStringWithoutTime(siteCalendar.getRevisedDate()) %>"
<%
	}else{
%>
data_arr[<%= counter%>][7] = ""
<%
	}
%>
<%if(siteCalendar.getRevisedRemark() != null){%>
data_arr[<%= counter%>][8] = "<%=siteCalendar.getRevisedRemark() %>"
<%
	}else{
%>
data_arr[<%= counter%>][8] = ""
<%
	}
%>

<%if(siteCalendar.getActualDate() != null){%>
data_arr[<%= counter%>][9] = "<%=HMSUtil.convertDateToStringWithoutTime(siteCalendar.getActualDate()) %>"
<%
	}else{
%>
data_arr[<%= counter%>][9] = ""
<%
	}
%>

<%if(siteCalendar.getActualRemark() != null){%>
data_arr[<%= counter%>][10] = "<%=siteCalendar.getActualRemark() %>"
<%
	}else{
%>
data_arr[<%= counter%>][10] = ""
<%
	}
%>
<%if(siteCalendar.getNoOfDays() != null){%>
data_arr[<%= counter%>][11] = "<%=siteCalendar.getNoOfDays() %>"
<%
	}else{
%>
data_arr[<%= counter%>][11] = ""
<%
	}
%>



<% 
if(siteCalendar.getStatus().equals("y")){ %>
data_arr[<%= counter%>][12] = "Active"
<%}else{%>
data_arr[<%= counter%>][12] = "InActive"
<%}%>

<%

counter++;
}
%>


formName = "siteCalendar"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	

