<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_site_otv.jsp  
 * Purpose of the JSP -  This is for Site Other vitals.
 * @author  Vishal
 * Create Date: 17th August,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>






<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<PrjSiteOthervitals> siteOtherVitalsList = new ArrayList<PrjSiteOthervitals>();		
				List<PrjFesStudyHeader> fesStudyHeaderList  = new ArrayList<PrjFesStudyHeader>();
				List<UserButtonRights> userRightsList= new ArrayList<UserButtonRights>();
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("fesStudyHeaderList")!= null){
					fesStudyHeaderList = (List)map.get("fesStudyHeaderList");
				}
								
				if (map.get("siteOtherVitalsList") != null) {
					siteOtherVitalsList = (List) map.get("siteOtherVitalsList");
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
				int siteId =0;
				String projectName = "";
				String projectCode = "";
				String trialPhase = "";
				String protocolNo = "";
				String projectType = "";
				String projectStatus = "";
				String siteName  = "";
				String siteCode = "";
				String piName = "";
				String siteInitiateDate = "";
								
				if(projectList.size()>0){
					for (MstrProject mstrProject :projectList){
						projectId     =	mstrProject.getId();				
						projectName   = mstrProject.getPrjName();
						projectCode   = mstrProject.getPrjCode();
						trialPhase    = mstrProject.getTrialPhase().getTrialPhaseName();
						protocolNo    = mstrProject.getPrjProtocalno();
						projectType   = mstrProject.getProjectType().getProjectName();
						projectStatus = mstrProject.getProjectStatus().getPrjsName();
						
					}
				}
				if(fesStudyHeaderList.size()>0){
					for (PrjFesStudyHeader prjFesStudyHeader:fesStudyHeaderList){
						siteId     =	prjFesStudyHeader.getSiteHeader().getId();				
						siteName   = prjFesStudyHeader.getSiteHeader().getSiteName();
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



<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="org.apache.poi.hssf.record.CountryRecord"%>
<%@page import="jkt.hrms.masters.business.CntrReqPat"%>

<%@page import="jkt.hrms.masters.business.PrjOthervitals"%>
<%@page import="jkt.hrms.masters.business.PrjSiteOthervitals"%>
<%@page import="jkt.hrms.masters.business.MstrSiteHeader"%>
<%@page import="jkt.hrms.masters.business.PrjFesStudyHeader"%>
<%@page import="jkt.hms.masters.business.UserButtonRights"%>
<div class="titleBg"> <h2>Site Other Vitals</h2></div>

<div class="clear"></div>
<form name="projectInformation" method="post" action="" >
<div class="clear"></div>
<div class="Block">
<label>Project Name</label>
<label ><%=projectName %></label>
<label>Project Code</label>
<label><%=projectCode %></label>
<label>Trial Phase </label>
<label><%=trialPhase %></label>
<div class="clear"></div>
<label>Protocol No </label>
<label><%=protocolNo %>&nbsp;</label>
<label>Project Type</label>
<label><%=projectType %></label>
<label>Project Status </label>
<label><%=projectStatus %>&nbsp;</label>
<div class="clear"></div>
<label>Site Name</label>
<label><%=siteName %></label>
<label>Site Code</label>
<label><%=siteCode %></label>
<label>Pi Name</label>
<label><%=piName %></label>
<div class="clear"></div>
<label>Site Initiate Date</label>
<label><%=siteInitiateDate %></label>

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
			[0, "<%= COMMON_ID%>", "id"],[1,"<%= SITE_OVT_CODE %>"], [2,"<%= SITE_OVT_NAME %>"],[3,"<%= SITE_ID%>"],[4,"<%= PROJECT_ID %>"],[5,"<%=CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%= STATUS %>"]];
	 statusTd = 8;
	</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="siteOtherVitals" method="post" action="" >
<div class="Block">

	<label>Vital Name</label> 
	<input type="text" name="<%= SITE_OVT_CODE %>" value="" validate="Vital Code,string,yes" class="textbox_size20"
		MAXLENGTH="100" / tabindex=1 />	
	<label>Interval</label> 
	<input type="text" name="<%= SITE_OVT_NAME %>" value="" validate="Vital Value,string,yes" class="textbox_size20"
		MAXLENGTH="50" / tabindex=1 /> <label class="auto">Days</label>
       <div class="clear"></div>
       </div>
            
           <div class="clear"></div>
            <div id="edited"></div>
		
			<%for(UserButtonRights userButtonRights : userRightsList){
					if(userButtonRights.getButton().getFormName().equals("Other Vitals")) {
						if(userButtonRights.getButton().getButtonName().equalsIgnoreCase("Add")){ %>
							<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('siteOtherVitals','projectTracking?method=addSiteOtherVitals');" accesskey="a" tabindex=1 />
					  <%} else if(userButtonRights.getButton().getButtonName().equalsIgnoreCase("Update")){%>
							<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('siteOtherVitals','projectTracking?method=editSiteOtherVitals')" accesskey="u" tabindex=1 />
					  <%} %>
			<%}}%>
		
			<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('projectCreation','training?method=deleteMaster&flag='+this.value)" accesskey="d" tabindex=1 />
			<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />            
            <input type="button" name="back" id="back" value="Back" class="button" onClick="backSiteSetting();" accesskey="b" tabindex=1 />
            
            <input type="button" name="next" id="next" value="Next" class="button" onClick="nextSiteSetting();" accesskey="n" tabindex=1 />
           
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
   				
		    <input type="hidden" name="projectId" id="projectId" value="<%=projectId%>" />
		    <input type="hidden" name="siteId" id="siteId" value="<%=siteId%>" />
	       	<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%=COMMON_ID%>" value="" />
			
	<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();



data_header[0] = new Array;
data_header[0][0] = "Vital Desc"
data_header[0][1] = "data";
data_header[0][2] = "40%";
data_header[0][3] = "<%= SITE_OVT_CODE %>";

data_header[1] = new Array;
data_header[1][0] = "Vital Value"
data_header[1][1] = "data";
data_header[1][2] = "15%";
data_header[1][3] = "<%=SITE_OVT_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Site Name"
data_header[2][1] = "hide";
data_header[2][2] = "20%";
data_header[2][3] = "<%=SITE_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Project Name"
data_header[3][1] = "hide";
data_header[3][2] = "20%";
data_header[3][3] = "<%=PROJECT_ID%>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_BY %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_DATE %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";



data_arr = new Array();

<%
if(siteOtherVitalsList !=null && siteOtherVitalsList.size() != 0){
	
Iterator itr=siteOtherVitalsList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  PrjSiteOthervitals prjSiteOthervitals = (PrjSiteOthervitals)itr.next();

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjSiteOthervitals.getId()%>
data_arr[<%= counter%>][1] = "<%= prjSiteOthervitals.getOvtCode()%>"
data_arr[<%= counter%>][2] = "<%= prjSiteOthervitals.getOvtName()%>"

<%
if(projectList.size()>0){
	for(MstrProject mstrProject:projectList){
	if(prjSiteOthervitals.getProject()!= null){
	if(mstrProject.getId().equals(prjSiteOthervitals.getProject().getId())){
%>
data_arr[<%= counter%>][3] = "<%=mstrProject.getPrjName()%>"
<%
		}
	}	}
}
%>
<%
if(prjSiteOthervitals.getSiteHeader()!= null){
%>
data_arr[<%= counter%>][4] = "<%= prjSiteOthervitals.getSiteHeader().getSiteName()%>"
<%}else{%>
data_arr[<%= counter%>][4] = ""

<%}%>
data_arr[<%= counter%>][5] = "<%= prjSiteOthervitals.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(prjSiteOthervitals.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= prjSiteOthervitals.getLastChgTime() %>"
<% 
if(prjSiteOthervitals.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>

<%

counter++;
}}
%>

 
formName = "siteOtherVitals"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	



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
     obj.action = "projectTracking?method=showSiteCalendarJsp&projectId="+id;
     obj.submit();
     return true;
 
 }

</script>	
			
