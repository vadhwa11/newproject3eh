<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.PrjSiteResMap"%>
<%@page import="jkt.hrms.masters.business.PrjAddPtHeader"%>
<%@page import="jkt.hrms.masters.business.MstrSiteHeader"%>
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
				if(map.get("prjSiteResMapSiteList")!= null){
					prjSiteResMapSiteList = (List)map.get("prjSiteResMapSiteList");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
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
				//int projectId = 0;
			//	if(map.get("projectId")!= null){
				//	projectId = (Integer)map.get("projectId");
				//}
				//int siteId = 0;
				//for(MstrSiteHeader mstrSiteHeader :siteHeaderList){
					//siteId = mstrSiteHeader.getId();
				//}
		int addPatientHeaderId = 0;
				if(prjAddPatientHeaderList.size()>0){
					for(PrjAddPtHeader prjAddPtHeader :prjAddPatientHeaderList){
						
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

<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>

<div class="titleBg"> <h2>Add Patient</h2></div>

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
<label class = "auto"><%=siteName %></label>
<div class="clear"></div>
<div class="clear"></div>

</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>


<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>
    <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= PROJECT_ID%>"], [2,"<%= SITE_HEADER_ID%>"], [3,"<%= ENROLLMENT_NO %>"],[4,"<%= PATIENT_INITIALS %>"],[5,"<%=CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%= SCREENING_NO %>"],[9,"<%= SCREENING_DATE %>"],[10,"<%= RANDOMIZATION_NO %>"],[11,"<%= RANDOMIZATION_DATE %>"],[12,"<%= INITIALIZATION_DATE %>"],[13,"<%= STATUS %>"]];
	 statusTd = 13;
	</script>

<div class="clear"></div>
<div class="division"></div>
<form name="addPatient" method="post" action="" >
<div class="Block">
<input type="hidden" name="<%=PROJECT_ID %>"  value="<%=projectId %>" />
<input type="hidden" name="<%=SITE_ID %>"  value="<%=siteId %>" />
<label><span>*</span>Enrollment No</label> 
<input type="text"   name="<%=ENROLLMENT_NO %>"   validate="Enrollment No.,string,yes"   maxlength="40" />

<label><span>*</span>Patient Initials</label> 
<input type="text"   name="<%=PATIENT_INITIALS %>"   validate="Patient Initials,string,yes"   maxlength="40" />

<label>Screening No</label> 
<input type="text"   name="<%=SCREENING_NO %>"   validate="Screening No.,string,no"   maxlength="40" />
   
   <div class="clear"></div>
<label>Screening Date</label> 
<input id="contractDateId" type="text"  name="<%=SCREENING_DATE %>" value="" class="date"  readonly="readonly" validate="Screening date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('contractDateId'),event)"/> 

<label>Randomization No</label> 
<input type="text" id="purchaseOrderNoId"  name="<%=RANDOMIZATION_NO %>"   validate="PurchaseOrder No.,string,no"   maxlength="40" /> 

<label>Randomization Date</label> 
<input id="randomDateId" type="text"  name="<%=RANDOMIZATION_DATE %>" value="" class="date"  readonly="readonly" validate="Randomization date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('randomDateId'),event)"/> 
    <div class="clear"></div>
    <label>Initialization Date</label> 
<input id="initialDateId" type="text"  name="<%=INITIALIZATION_DATE %>" value="" class="date"  readonly="readonly" validate="Initial date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('initialDateId'),event)"/> 
   	    <div class="clear"></div>
    
     
     
	
   
    
	<div class="clear"></div>
    </div>
            
           <div class="clear"></div>
            <div id="edited"></div>
            <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('addPatient','projectTracking?method=saveAddPatientDetails');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="validateDate('update')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('projectVitals','projectTracking?method=deleteProjectVital&flag='+this.value)" accesskey="d" tabindex=1/>		
			
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
            
            <input type="button" name="back" id="back" value="Back" class="button" onClick="backProjectSetting();" accesskey="b" tabindex=1 />
            
            <input type="button" name="next" id="next" value="Next" class="button" onClick="nextProjectSetting();" accesskey="n" tabindex=1 />
            
            <div class="clear"></div>
            <div class="division"></div>
            
            <div class="bottom">
			<label>Changed By</label>   
			<label class="value"><%=userName%></label>
			        
			<label>Changed Date</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   			</div>	
   				
		    
	       	<input type="hidden" name="<%=STATUS %>" value="" /><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
			</form>
			
	<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = ""
data_header[0][1] = "hide";
data_header[0][2] = "20%";
data_header[0][3] = "<%= PROJECT_ID%>";

data_header[1] = new Array;
data_header[1][0] = ""
data_header[1][1] = "hide";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SITE_HEADER_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Enrollment No"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=ENROLLMENT_NO %>";

data_header[3] = new Array;
data_header[3][0] = "Patient Initials"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=PATIENT_INITIALS%>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_BY %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_DATE%>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME%>";

data_header[7] = new Array;
data_header[7][0] = "Scr.No"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=SCREENING_NO%>";

data_header[8] = new Array;
data_header[8][0] = "Scr.Date"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=SCREENING_DATE%>";

data_header[9] = new Array;
data_header[9][0] = "Rand.No."
data_header[9][1] = "data";
data_header[9][2] = "15%";
data_header[9][3] = "<%=RANDOMIZATION_NO%>";


data_header[10] = new Array;
data_header[10][0] = "Rand.Date"
data_header[10][1] = "data";
data_header[10][2] = "15%";
data_header[10][3] = "<%=RANDOMIZATION_DATE%>";

data_header[11] = new Array;
data_header[11][0] = "Initi.Date"
data_header[11][1] = "data";
data_header[11][2] = "15%";
data_header[11][3] = "<%=INITIALIZATION_DATE%>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=STATUS%>";



data_arr = new Array();

<%
	
Iterator itr=prjAddPatientHeaderList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  PrjAddPtHeader prjAddPtHeader= (PrjAddPtHeader)itr.next();
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjAddPtHeader.getId()%>
data_arr[<%= counter%>][1] = "<%= prjAddPtHeader.getPrj().getPrjName()%>"

data_arr[<%= counter%>][2] = "<%= prjAddPtHeader.getSiteHeader().getSiteName()%>"

data_arr[<%= counter%>][3] = "<%=prjAddPtHeader.getEnrollmentNo() %>"
data_arr[<%= counter%>][4] = "<%= prjAddPtHeader.getPatientInitials()%>"
data_arr[<%= counter%>][5] = "<%= prjAddPtHeader.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(prjAddPtHeader.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= prjAddPtHeader.getLastChgTime() %>" 
data_arr[<%= counter%>][8] = "<%= prjAddPtHeader.getScreeningNo() %>"
data_arr[<%= counter%>][9] = "<%=HMSUtil.convertDateToStringWithoutTime(prjAddPtHeader.getScreeningDate()) %>"
data_arr[<%= counter%>][10] = "<%= prjAddPtHeader.getRandomizationNo() %>"
data_arr[<%= counter%>][11] = "<%=HMSUtil.convertDateToStringWithoutTime(prjAddPtHeader.getRandomizationDate()) %>"
data_arr[<%= counter%>][12] = "<%=HMSUtil.convertDateToStringWithoutTime(prjAddPtHeader.getInitialVisitDate()) %>"
<% 
if(prjAddPtHeader.getStatus().equals("y")){ %>
data_arr[<%= counter%>][13] = "Active"
<%}else{%>
data_arr[<%= counter%>][13] = "InActive"
<%}%>

<%

counter++;
}
%>
 
formName = "addPatient"

nonEditable = ['<%= COMMON_ID%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	



function backProjectSetting()
 {
   obj = eval('document.'+formName)
     obj.action = "projectTracking?method=showProjectTrackingMenuJsp";
     obj.submit();
     return true;
 
 }
 
 
</script>	

