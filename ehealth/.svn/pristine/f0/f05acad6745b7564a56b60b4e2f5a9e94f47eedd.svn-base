<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<MasCountry> countryList = new ArrayList<MasCountry>();
				List<MasCountry> gridCountryList = new ArrayList<MasCountry>();
				List<CntrReqPat> patientRequiredList = new ArrayList<CntrReqPat>();	
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				
								
				if (map.get("countryList") != null) {
					countryList = (List) map.get("countryList");
				}
				
				if (map.get("gridCountryList") != null) {
					gridCountryList = (List) map.get("gridCountryList");
				}
				
							
				if(map.get("patientRequiredList") !=null){
					patientRequiredList =(List) map.get("patientRequiredList");
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



<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="org.apache.poi.hssf.record.CountryRecord"%>
<%@page import="jkt.hrms.masters.business.CntrReqPat"%>

<%@page import="jkt.hrms.masters.business.MstrPtvisit"%>
<div class="titleBg"> <h2>Country Wise Patient</h2></div>

<div class="clear"></div>
<form name="projectInformation" method="post" action="" >
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
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= PROJECT_ID%>"], [2,"<%= COUNTRY %>"], [3,"<%= PATIENT_REQUIRED %>"],[4,"<%=CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"]];
	 statusTd = 7;
	</script>

<div class="clear"></div>
<div class="division"></div>
<form name="patientRequired" method="post" action="" >
<div class="Block">

	<label>  Country</label> 
	<select name="<%= COUNTRY %>" validate="Country,string,no" tabindex=1>
		<option value="1">India</option>
		<%
			for (MasCountry masCountry : countryList) {
		%>
	
		<option value="<%=masCountry.getId ()%>"><%=masCountry.getCountryName()%></option>
	
		<%
			}
		%>
	</select>
	
	<label>Total Patient</label> 
	<input type="text" name="<%= PATIENT_REQUIRED %>" value="" validate="Patient Required,int,yes" class="textbox_size20"
		MAXLENGTH="5" / tabindex=1 />
       <div class="clear"></div>
       </div>
            
           <div class="clear"></div>
            <div id="edited"></div>
            <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('patientRequired','projectTracking?method=addPatientRequired');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('patientRequired','projectTracking?method=editPatientRequired')" accesskey="u" tabindex=1 />

			<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('patientRequired','projectTracking?method=deletePatientRequired&flag='+this.value)" accesskey="d" tabindex=1/>		

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
			
	<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Project Name"
data_header[0][1] = "hide";
data_header[0][2] = "20%";
data_header[0][3] = "<%= PROJECT_ID%>";

data_header[1] = new Array;
data_header[1][0] = "Country"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= COUNTRY %>";

data_header[2] = new Array;
data_header[2][0] = "Patient Required"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=PATIENT_REQUIRED %>";


data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_DATE %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%=CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
if(patientRequiredList !=null && patientRequiredList.size() != 0){
	
Iterator itr=patientRequiredList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             CntrReqPat  cntrReqPat = (CntrReqPat)itr.next(); 
          
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= cntrReqPat.getId()%>
data_arr[<%= counter%>][1] = "<%= cntrReqPat.getPrj().getPrjName()%>"

<%
		Iterator itrGridCountryList=gridCountryList.iterator();
		 while(itrGridCountryList.hasNext())
            {try{
             MasCountry  masCoutryGrid = (MasCountry)itrGridCountryList.next(); 
			 if(cntrReqPat.getCountry().getId().equals(masCoutryGrid.getId()) && masCoutryGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][2] = "<%=masCoutryGrid.getCountryName()%>"
			<%}else if(cntrReqPat.getId().equals(masCoutryGrid.getId()) && masCoutryGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masCoutryGrid.getCountryName()%>";
			<%}
            }catch(Exception e){e.printStackTrace();}}%>     

data_arr[<%= counter%>][3] = <%= cntrReqPat.getPatientRequired()%>
data_arr[<%= counter%>][4] = "<%= cntrReqPat.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(cntrReqPat.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= cntrReqPat.getLastChgTime() %>" 
<% if(cntrReqPat.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "patientRequired"

nonEditable = ['<%= COMMON_ID%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
<%}%>	

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
     obj.action = "projectTracking?method=showPatientVisitScheduleJsp&projectId="+id;
     obj.submit();
     return true;
 
 }

</script>	
			
