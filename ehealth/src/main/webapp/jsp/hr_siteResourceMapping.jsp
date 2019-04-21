<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.PrjSiteResMap"%>
<%@page import="jkt.hms.masters.business.UserButtonRights"%>
<script type="text/javascript" language="javascript" src="../jsp/js/proto.js"></script> 
<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<PrjFesStudyHeader> fesStudyHeaderList = new ArrayList<PrjFesStudyHeader>();	
				List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
				List<PrjRolewiseResourceReq> prjRoleWiseResourceList = new ArrayList<PrjRolewiseResourceReq>();
				List<PrjRoleResMappingHeader> roleResourceMappingHeaderList = new ArrayList<PrjRoleResMappingHeader>();
				List<MstrProjectrole> projectRoleList = new ArrayList<MstrProjectrole>();
				List<PrjSiteResMap> prjSiteResMapList = new ArrayList<PrjSiteResMap>();
				List<UserButtonRights> userRightsList= new ArrayList<UserButtonRights>();
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("prjRoleWiseResourceList")!= null){
					prjRoleWiseResourceList = (List)map.get("prjRoleWiseResourceList");
				}
				if(map.get("employeeList")!= null){
					employeeList = (List)map.get("employeeList");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("roleResourceMappingHeaderList")!= null){
					roleResourceMappingHeaderList = (List)map.get("roleResourceMappingHeaderList");
				}
				if(map.get("prjSiteResMapList")!= null){
					prjSiteResMapList = (List)map.get("prjSiteResMapList");
				}
				if(map.get("fesStudyHeaderList")!= null){
					fesStudyHeaderList = (List)map.get("fesStudyHeaderList");
				}
			    if(map.get("projectRoleList") != null){
			    	projectRoleList = (List)map.get("projectRoleList");
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
<%@page import="jkt.hrms.masters.business.PrjRolewiseResourceReq"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hrms.masters.business.PrjRoleResMappingHeader"%>
<%@page import="jkt.hrms.masters.business.MstrProjectrole"%>
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

<div class="titleBg"> <h2>Site Resource Mapping</h2></div>

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
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= PROJECT_ID%>"], [2,"<%= PROJECT_ROLE_ID%>"], [3,"<%= EMPLOYEE_ID %>"],[4,"<%= SITE_ID %>"],[5,"<%=CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%= STATUS %>"],[9,"<%= DEPARTMENT_ID %>"]];
	 statusTd = 8;
	</script>

<div class="clear"></div>
<div class="division"></div>
<form name="siteResourceMapping" method="post" action="" >
<div class="Block">

	<label>Project Role</label> 
	<select id="vitalsId" name="<%=PROJECT_ROLE_ID %>" validate="Project Vital,string,yes"  onchange="submitProtoAjax('siteResourceMapping','projectTracking?method=getResourceListFromAjax')"  tabindex=1>
		<option value="0">Select</option>
<%
	for(PrjRolewiseResourceReq prjRolewiseResourceReq:prjRoleWiseResourceList){
%>
<option value="<%=prjRolewiseResourceReq.getPjr().getId() %>"><%=prjRolewiseResourceReq.getPjr().getPjrName() %></option>
<%} %>
	</select>
	<label>Employee</label> 
<div id="testDiv">	
	<select id="employeeId" name="<%=EMPLOYEE_ID %>" validate="Project Vital,string,yes" multiple="multiple" size="5" class="list" tabindex=1>
		<option value="0">Select</option>
		<%
	for(MasEmployee masEmployee :employeeList){
		
%>
<option value="<%=masEmployee.getId() %>"><%=masEmployee.getFirstName()+" "+masEmployee.getMiddleName()+" "+masEmployee.getLastName() %></option>
<%} %>
	</select>
	</div>
    <div class="clear"></div>
    <input type="hidden" name="<%=PROJECT_ID %>" id="projectId" value="<%=projectId%>" />
     <input type="hidden" name="<%=SITE_ID %>" id="siteId" value="<%=siteId%>" />
     
     
	
   
    
	<div class="clear"></div>
    </div>
            
           <div class="clear"></div>
            <div id="edited"></div>
			<%for(UserButtonRights userButtonRights : userRightsList){
					if(userButtonRights.getButton().getFormName().equalsIgnoreCase("Site Resource Mapping")) {
						if(userButtonRights.getButton().getButtonName().equalsIgnoreCase("Add")){ %>
            				<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('siteResourceMapping','projectTracking?method=saveSiteResourceMapping');" accesskey="a" tabindex=1/>							
					  <%} else if(userButtonRights.getButton().getButtonName().equalsIgnoreCase("Update")){%>
							<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="validateDate('update')" accesskey="u" tabindex=1 />														
					  <%} %>
			<%}}%>

			<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('projectVitals','projectTracking?method=deleteProjectVital&flag='+this.value)" accesskey="d" tabindex=1/>		

			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
            
            <input type="button" name="back" id="back" value="Back" class="button" onClick="backProjectSetting();" accesskey="b" tabindex=1 />
            
            
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
   				
		    
	       	<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" value="" />
			
	<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Project Name"
data_header[0][1] = "hide";
data_header[0][2] = "20%";
data_header[0][3] = "<%= PROJECT_ID%>";

data_header[1] = new Array;
data_header[1][0] = "Project Role"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= PROJECT_ROLE_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Resource Name"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=EMPLOYEE_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "15%";
data_header[3][3] = "<%=SITE_ID%>";

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
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS%>";

data_header[8] = new Array;
data_header[8][0] = "Department"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=DEPARTMENT_ID%>";



data_arr = new Array();

<%
	
Iterator itr=prjSiteResMapList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  PrjSiteResMap prjSiteResMap= (PrjSiteResMap)itr.next();
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjSiteResMap.getId()%>
data_arr[<%= counter%>][1] = "<%= prjSiteResMap.getPrj().getId()%>"

data_arr[<%= counter%>][2] = "<%= prjSiteResMap.getPjr().getPjrName()%>"

data_arr[<%= counter%>][3] = "<%= prjSiteResMap.getEmployee().getFirstName()+" "+prjSiteResMap.getEmployee().getMiddleName()+" "+prjSiteResMap.getEmployee().getLastName()%>"
data_arr[<%= counter%>][4] = "<%= prjSiteResMap.getSiteHeader().getSiteName()%>"
<%if(prjSiteResMap.getLastChgBy()!= null){%>
data_arr[<%= counter%>][5] = "<%=prjSiteResMap.getLastChgBy() %>"
<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>
<%if(prjSiteResMap.getLastChgDate()!= null){%>
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(prjSiteResMap.getLastChgDate()) %>"
<%}else{%>
data_arr[<%= counter%>][6] = ""
<%}%>
<%if(prjSiteResMap.getLastChgTime()!= null){%>
data_arr[<%= counter%>][7] = "<%= prjSiteResMap.getLastChgTime() %>" 
<%}else{%>
data_arr[<%= counter%>][7] = "--"
<%}%>
<% 
if(prjSiteResMap.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
data_arr[<%= counter%>][9] = "<%= prjSiteResMap.getEmployee().getDepartment().getDepartmentName() %>"

<%
counter++;
}
%>
 
formName = "siteResourceMapping"

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
     obj.action = "projectTracking?method=showProjectSitesList";
     obj.submit();
     return true;
 
 }
 
 
</script>	

