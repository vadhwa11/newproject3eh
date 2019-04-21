<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<PrjPatvisitsch> patientVisitScheduleList = new ArrayList<PrjPatvisitsch>();		
				List<MstrPtvisit> patientVisitList = new ArrayList<MstrPtvisit>();
				List<HrMasVisitType> masVisitTypeList = new ArrayList<HrMasVisitType>();
				List<UserButtonRights> userRightsList= new ArrayList<UserButtonRights>();
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
								
				if (map.get("patientVisitScheduleList") != null) {
					patientVisitScheduleList = (List) map.get("patientVisitScheduleList");
				}
				
				if(map.get("patientVisitList") !=null){
					patientVisitList = (List) map.get("patientVisitList");
				}
				if(map.get("masVisitTypeList") !=null){
					masVisitTypeList = (List) map.get("masVisitTypeList");
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
				BigDecimal budget = new BigDecimal("0");
				Date StartDate = new Date();
				Date endDate = new Date();
				Date loiDate = new Date();
				Date purchaseDate = null;
				Date conTractDate = null;
				String purchaseOrderNo = "";
				String contractNo = "";
				String loino = "";
				BigDecimal expectedBudget = new BigDecimal(0);
								
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
						expectedBudget = mstrProject.getPrjExpectedbudget();
						StartDate      = mstrProject.getPrjStdt();
						endDate        = mstrProject.getPrjEddt();
						loiDate        = mstrProject.getPrjLoidt();
						purchaseDate   = mstrProject.getPurchasOrderDate();
						conTractDate   = mstrProject.getContractDate();
						purchaseOrderNo = mstrProject.getPurchaseOrderNo();
						contractNo      = mstrProject.getContractNo();
						loino           = mstrProject.getPrjLoino();
						
					}
				}
				
				
				
	%>
<script>
function backProjectSetting()
 {
   obj = eval('document.'+formName)
     obj.action = "projectTracking?method=showProjectVitalsJsp";
     obj.submit();
     return true;
 
 }
 
 function nextProjectSetting()
 {
   var id = <%=projectId%>
   obj = eval('document.'+formName)
     obj.action = "projectTracking?method=showVendorContractJsp&projectId="+id;
     obj.submit();
     return true;
 
 }
</script>


<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="org.apache.poi.hssf.record.CountryRecord"%>
<%@page import="jkt.hrms.masters.business.CntrReqPat"%>

<%@page import="jkt.hrms.masters.business.PrjOthervitals"%>
<%@page import="jkt.hrms.masters.business.PrjPatvisitsch"%>
<%@page import="jkt.hrms.masters.business.MstrPtvisit"%>
<%@page import="jkt.hrms.masters.business.HrMasVisitType"%>
<%@page import="jkt.hms.masters.business.UserButtonRights"%>
<div class="titleBg"> <h2>Visit Schedule</h2></div>

<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
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
<label><%=protocolNo %>&nbsp;</label>
<label>Project Type</label>
<label><%=projectType %></label>
<div class="clear"></div>
<label>Project Status </label>
<label><%=projectStatus %>&nbsp;</label>
<label>Expected Budget </label>
<label><%=expectedBudget %>&nbsp;</label>
<label>Start Date</label>
<%if(StartDate != null){%>
<label><%=HMSUtil.convertDateToStringWithoutTime(StartDate) %></label>
<%}else{%>
<label>&nbsp;</label>
<%} %>
<label>End Date </label>
<%if(endDate !=null){ %>
<label><%=HMSUtil.convertDateToStringWithoutTime(endDate)%></label>
<%}else{%>
<label>&nbsp;</label>
<%} %>
<label>LOI Date </label>
<%if(loiDate != null ){ %>
<label><%=HMSUtil.convertDateToStringWithoutTime(loiDate)%></label>
<%}else{%>
<label>&nbsp;</label>
<%} %>
<label>LOI No</label>
<label><%=loino %></label>
<div class="clear"></div>
<div class="clear"></div>
<label>Purchase Date </label>
<%if(purchaseDate != null){ %>
<label><%=HMSUtil.convertDateToStringWithoutTime(purchaseDate)%></label>
<%}else{%>
<label>&nbsp;</label>
<%} %>
<label>Purchase No </label>
<%if(purchaseOrderNo !=null){ %>
<label><%=purchaseOrderNo %></label>
<%}else{%>
<label>&nbsp;</label>
<%} %>
<label>Contract Date</label>
<%if(conTractDate !=null){ %>
<label><%=HMSUtil.convertDateToStringWithoutTime(conTractDate)%></label>
<%}else{%>
<label>&nbsp;</label>
<%} %>
<div class="clear"></div>
<label>Contract No</label>
<%if(contractNo !=null) { %>
<label><%=contractNo %></label>
<%}else{%>
<label>&nbsp;</label>
<%} %>
<div class="clear"></div>
<div class="clear"></div>
</div>


<div class="clear"></div>	
<div class="Block">
<div id="searcharea">
<div id="searchbar">
		  
<form name="search" method="post" action="">
	<label>Visit Type:</label>		    
	<input type="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" class="radioCheck"/>
	<label>Visit Name:</label>
	<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheck"/>
    <input type="hidden" name="projectIdWithSearch" id="projectIdWithSearch" value="<%=projectId%>" />
	
	<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Visit Type Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'projectTracking?method=searchVisitDetails')"/>
    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','projectTracking?method=searchVisitDetails','checkSearch')" tabindex=1  />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

</div>
</div>
<div class="clear"></div>
</div>



<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>
	<%
	if(patientVisitScheduleList.size() >= 0 && map.get("search") != null) { %>
				<a href="projectTracking?method=showPatientVisitScheduleJsp&projectId=<%=projectId%>">Show All Records</a>
	 <% } %>

    <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= PROJECT_ID%>"], [2,"<%= PATIENT_VISIT_TYPE %>"], [3,"<%= PATIENT_VISIT_NAME %>"], [4,"<%= VISIT_INTERVAL %>"],[5,"<%= BETWEEN_VISIT %>"],[6,"<%= ENTIRE_SCHEDULE %>"],[7,"<%=CHANGED_BY%>"], [8,"<%= CHANGED_DATE %>"],[9,"<%= CHANGED_TIME %>"],[10,"<%=STATUS%>"]];
	 statusTd = 10;
	</script>
<div class="clear"></div>
<div class="division"></div>

<form name="patientVisitInterval" method="post" action="" >
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
	<label>Visit Type</label> 
	<select name="<%= PATIENT_VISIT_TYPE %>" id="<%= PATIENT_VISIT_TYPE %>" validate="P Visit Type,string,yes"
		onchange="populateVisitType(this.value,'patientVisitInterval');" tabindex=1>
		<option value="0">Select</option>
		<%
			for (HrMasVisitType hrMasVisitType: masVisitTypeList ) { %>
				<option value="<%=hrMasVisitType.getId()%>"><%=hrMasVisitType.getVisitType()%></option>
		<%
			}
		%>
	</select>
     
	<label>Visit Name</label> 
	<select name="<%= PATIENT_VISIT_NAME %>" id="<%=PATIENT_VISIT_NAME%>" validate="P Visit Name,string,yes" tabindex=1>
		<option value="0">Select</option>
		<%
			for (MstrPtvisit mstrPtvisit: patientVisitList ) {
		%>
	
		<option value="<%=mstrPtvisit.getId()%>"><%=mstrPtvisit.getPatientVisitName()%></option>
	
		<%
			}
		%>
	</select>
	<script type="text/javascript">
<%
	int counter1 = 0;
	
	for (HrMasVisitType masVisitType : masVisitTypeList)
	{
		for (MstrPtvisit maPtvisit : patientVisitList) 
		{
			if(maPtvisit.getVisitType() != null){
				if(masVisitType.getId().equals(maPtvisit.getVisitType().getId() )){
%>
					visitTypeArray[<%=counter1%>] = new Array();
					visitTypeArray[<%=counter1%>][0]=<%=masVisitType.getId()%>;
					visitTypeArray[<%=counter1%>][1] = <%=maPtvisit.getId()%>;									
					visitTypeArray[<%=counter1%>][2] = "<%=maPtvisit.getPatientVisitName()%>";
	<%
	counter1++;
	} } } }

%>
</script>
	
	<label>Interval</label> 
	<input type="text" name="<%= VISIT_INTERVAL %>" value="" validate="Visit Interval,int,yes" class="textbox_size20"
		MAXLENGTH="6" / tabindex=1 /><label class="auto">Days</label>
	   <div class="clear"></div>
	   <label>Window Period :-</label> 
	   </div>
	   <div class="Block" >
	   <div class="clear"></div>	
       <label>Between Visit +-</label> 
       <input type="text" name="<%= BETWEEN_VISIT %>" value="" validate="Between Visit,int,no" class="textbox_size20"
		MAXLENGTH="6" / tabindex=1 /><label class= auto>Days</label>
       <label>Entire Schedule +-</label> 
       <input type="text" name="<%= ENTIRE_SCHEDULE %>" value="" validate="Entire Schedule,int,no" class="textbox_size20"
		MAXLENGTH="6" / tabindex=1 /><label class="auto">Days</label>
		</div>
       <div class="clear"></div>
       
       
            
           <div class="clear"></div>
            <div id="edited"></div>
	<%for(UserButtonRights  userButtonRights : userRightsList){
			if(userButtonRights.getButton().getFormName().equals("Schedule Entry")) {
				if(userButtonRights.getButton().getButtonName().equalsIgnoreCase("Add")){ %>
		            <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('patientVisitInterval','projectTracking?method=addPatientVisitSchedule');" accesskey="a" tabindex=1/>
			  <%} else if(userButtonRights.getButton().getButtonName().equalsIgnoreCase("Update")){%>
					<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('patientVisitInterval','projectTracking?method=editPatientVisitSchedule')" accesskey="u" tabindex=1 />			  
			  <%} %>
	<%}}%>

			<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('patientVisitInterval','projectTracking?method=deletePatientVisitSchedule&flag='+this.value)" accesskey="d" tabindex=1/>		

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
   				
		    <input type="hidden" name="projectId" id="projectId" value="<%=projectId%>" />
	       	<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			
	<div class="clear"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Project Name"
data_header[0][1] = "hide";
data_header[0][2] = "20%";
data_header[0][3] = "<%= PROJECT_ID%>";

data_header[1] = new Array;
data_header[1][0] = "Visit Type"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= PATIENT_VISIT_TYPE %>";

data_header[2] = new Array;
data_header[2][0] = "Visit Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= PATIENT_VISIT_NAME %>";

data_header[3] = new Array;
data_header[3][0] = "Visit Interval"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=VISIT_INTERVAL %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=BETWEEN_VISIT %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=ENTIRE_SCHEDULE %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=CHANGED_BY %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%=CHANGED_DATE %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%=CHANGED_TIME %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=STATUS %>";

data_arr = new Array();

<%

if(patientVisitScheduleList !=null && patientVisitScheduleList.size() != 0){
	
Iterator itr=patientVisitScheduleList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             PrjPatvisitsch prjPatvisitsch = (PrjPatvisitsch)itr.next();

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjPatvisitsch.getId()%>
data_arr[<%= counter%>][1] = "<%= prjPatvisitsch.getPrj().getPrjName()%>"

data_arr[<%= counter%>][2] = "<%= prjPatvisitsch.getPatientVisit().getVisitType().getVisitType()%>"
data_arr[<%= counter%>][3] = "<%= prjPatvisitsch.getPatientVisit().getPatientVisitName()%>"
data_arr[<%= counter%>][4] = "<%= prjPatvisitsch.getPvInt()%>"
data_arr[<%= counter%>][5] = "<%= prjPatvisitsch.getBetweenVisit()%>"
data_arr[<%= counter%>][6] = "<%= prjPatvisitsch.getEntireSchedule()%>"
data_arr[<%= counter%>][7] = "<%= prjPatvisitsch.getLastChgBy() %>"
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(prjPatvisitsch.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= prjPatvisitsch.getLastChgTime() %>" 
<% if(prjPatvisitsch.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "patientVisitInterval"

nonEditable = ['<%= COMMON_ID%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
<%}%>	


 
</script>	
			
