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
			    if(map.get("vitalsMasterList") != null){
			    	vitalsMasterList = (List)map.get("vitalsMasterList");
			    }
			    if(map.get("fesStudyHeaderList") != null){
			    	fesStudyHeaderList = (List)map.get("fesStudyHeaderList");
			    }
			    if(map.get("siteVitalList") != null){
			    	siteVitalList = (List)map.get("siteVitalList");
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

<div class="titleBg"> <h2>Site Vitals</h2></div>

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
  var vitalsArr = new Array();
  
function changeLabel(vitalsId){
	 if(vitalsId != "0"){
		 for(var i=0;i<vitalsArr.length;i++){
		 	if(vitalsId == vitalsArr[i][0]){
		 		if(vitalsArr[i][1] == "D"){
				   document.getElementById('plannedDateId').innerHTML = 'Planned Date';
				   document.getElementById('revisedDateId').innerHTML = 'Revised Date';
				   document.getElementById('actualDateId').innerHTML = 'Actual Date';
				   document.getElementById('pAmtDiv').style.display = 'none';
				    document.getElementById('plannedDate').style.display = 'block';
				     document.getElementById('revisedDate').style.display = 'block';
				      document.getElementById('actualDate').style.display = 'block';
				      
		 		
		 		}else if(vitalsArr[i][1] == "V"){
		 				if(vitalsArr[i][2] == "yes"){
				 			 document.getElementById('plannedDateId').innerHTML = 'Planned Value';
				  			 document.getElementById('revisedDateId').innerHTML = 'Revised Value';
				   			 document.getElementById('actualDateId').innerHTML = 'Actual Value';
				   			 document.getElementById('pAmtDiv').style.display = 'block';
				 			 document.getElementById('plannedDate').style.display = 'none';
				   			 document.getElementById('revisedDate').style.display = 'none';
				   			 document.getElementById('actualDate').style.display = 'none';
				   		}else if(vitalsArr[i][2] == "no"){
				   			 document.getElementById('plannedDateId').innerHTML = 'Planned Value';
				  			 document.getElementById('revisedDateId').innerHTML = 'Revised Value';
				   			 document.getElementById('revisedDateId').innerHTML = 'Actual Value';
				   			 document.getElementById('pAmtDiv').style.display = 'none';
				 			 document.getElementById('plannedDate').style.display = 'none';
				   			 document.getElementById('revisedDate').style.display = 'none';
				   			 document.getElementById('actualDate').style.display = 'none';
				   		}
		 		}
		 		
		 			document.getElementById('flagId').value =vitalsArr[i][1];
		 			document.getElementById('amountFlagId').value =vitalsArr[i][2];
		 	}
		 }

	 }
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
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= PROJECT_ID%>"], [2,"<%= VITAL_ID%>"], [3,"<%= PLANNED_DATE %>"],[4,"<%= PLANNED_REMARK %>"],[5,"<%= REVISED_DATE %>"],[6,"<%= REVISED_REMARK %>"],[7,"<%= ACTUAL_DATE %>"],[8,"<%= ACTUAL_REMARK %>"],[9,"<%=CHANGED_BY%>"], [10,"<%= CHANGED_DATE %>"],[11,"<%= CHANGED_TIME %>"],[12,"<%= STATUS %>"],[13, "<%=FLAG%>", "flag"]
			,[14, "<%=AMOUNT_FLAG%>", "amountFlag"],[15, "<%=CURRENCY_ID%>"]];
	 statusTd = 12;
	</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="siteVitals" method="post" action="" >
<div class="Block">

	<label>Project Vital</label> 
	<select id="vitalsId" name="<%=VITAL_ID %>" validate="Project Vital,string,yes" onchange="changeLabel(this.value);" tabindex=1>
		<option value="0">Select</option>
		<%
		int count1=0;
			for (MstrVitals mstrVitals : vitalsMasterList) {
		%>
	
		<option value="<%=mstrVitals.getId()%>"><%=mstrVitals.getVitalDescription()%></option>
		<script type="text/javascript">
			  vitalsArr[<%=count1%>] = new Array();
			  vitalsArr[<%=count1%>][0] = <%=mstrVitals.getId()%>;
			  vitalsArr[<%=count1%>][1] = "<%=mstrVitals.getFlag()%>";
			  vitalsArr[<%=count1%>][2] = "<%=mstrVitals.getAmountFlag()%>";         
 
 </script>
		<%
		
		count1++;
			}
		%>
	</select>
    <div class="clear"></div>
    <input type="hidden" name="projectId" id="projectId" value="<%=projectId%>" />
     <input type="hidden" name="<%=SITE_ID%>" id="siteId" value="<%=siteId%>" />
  	<input type="hidden" id="flagId" name="<%=FLAG%>" value="" />
  	  <input type="hidden" id="amountFlagId" name="<%=AMOUNT_FLAG%>" value="" />
	<label id="plannedDateId"><span>*</span>Planned Date</label>
	<input  type="text" name="<%=PLANNED_DATE%>"   value=""  validate="Planned Date,string,yes" class="textbox_size20" MAXLENGTH="15" / tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="plannedDate" validate="Pick a date" class="calender" onclick="setdate('',document.siteVitals.<%=PLANNED_DATE%>,event)"/>
   
  	 <div id="pAmtDiv" style="display: none;">
   	<label>Currency</label> 
	<select id="currencyId" name="<%=CURRENCY_ID %>" validate="Currncy,string,no"  tabindex=1>
		<option value="0">Select</option>
		<%
			for (MasCurrency masCurrency: currencyList) {
		%>
	
		<option value="<%=masCurrency.getId()%>"><%=masCurrency.getCurrencyCode()%></option>
		
		<%	
			}
		%>
	</select>
	
 	 </div>
   
    <label>Remarks</label>
    <input type="text" name="<%=PLANNED_REMARK %>" value="" validate="Remarks,string,no"   MAXLENGTH="100" tabindex=1/>
    
    <div class="clear"></div>
    <label id="revisedDateId">Revised Date</label>
	<input  type="text" name="<%=REVISED_DATE%>"   value=""  validate="Revised Date,string,no"  class="textbox_size20" MAXLENGTH="15" / tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="revisedDate" validate="Pick a date" class="calender"  onclick="setdate('',document.siteVitals.<%=REVISED_DATE%>,event)"/>
    
     
   
    <label>Remarks</label>
    <input type="text" name="<%=REVISED_REMARK%>" value="" validate="Remarks,string,no"   MAXLENGTH="100" tabindex=1/>
    
    <div class="clear"></div>
    <label id="actualDateId" >Actual Date  </label>
	<input type="text" name="<%=ACTUAL_DATE%>"   value=""  validate="Actual Date,string,no" class="textbox_size20" MAXLENGTH="15" / tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="actualDate" validate="Pick a date" class="calender" onclick="setdate('',document.siteVitals.<%=ACTUAL_DATE%>,event)"/>
    
    
 	 
    <label>Remarks</label>
    <input type="text" name="<%=ACTUAL_REMARK%>" value="" validate="Remarks,string,no"   MAXLENGTH="100" tabindex=1/>
    
	<div class="clear"></div>
    </div>
            
           <div class="clear"></div>
            <div id="edited"></div>

		<%for(UserButtonRights userButtonRights : userRightsList){
				if(userButtonRights.getButton().getFormName().equalsIgnoreCase("Site Vitals")) {
					if(userButtonRights.getButton().getButtonName().equalsIgnoreCase("Add")){ %>
			            <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('siteVitals','projectTracking?method=saveSiteVitals');" accesskey="a" tabindex=1/>
				  <%} else if(userButtonRights.getButton().getButtonName().equalsIgnoreCase("Update")){%>
						<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('siteVitals','projectTracking?method=updateSiteVitals');" accesskey="u" tabindex=1 />
				  <%} %>
		<%}}%>
            
		

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
data_header[1][0] = "Project Vital"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= VITAL_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Planned"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=PLANNED_DATE %>";

data_header[3] = new Array;
data_header[3][0] = "Remark"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=PLANNED_REMARK%>";

data_header[4] = new Array;
data_header[4][0] = "Revised"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=REVISED_DATE %>";

data_header[5] = new Array;
data_header[5][0] = "Remark"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=REVISED_REMARK%>";

data_header[6] = new Array;
data_header[6][0] = "Actual"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=ACTUAL_DATE%>";

data_header[7] = new Array;
data_header[7][0] = "Remark"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=ACTUAL_REMARK%>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%=CHANGED_BY %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%=CHANGED_DATE %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=CHANGED_TIME %>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "15%";
data_header[11][3] = "<%=STATUS %>";

data_header[12] = new Array;
data_header[12][0] = "fgd"
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=FLAG %>";

data_header[13] = new Array;
data_header[13][0] = "cvbcb"
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "<%=AMOUNT_FLAG %>";

data_header[14] = new Array;
data_header[14][0] = "cvbcb"
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "<%=CURRENCY_ID%>";


data_arr = new Array();

<%
	
Iterator itr=siteVitalList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  PrjSiteVital prjSiteVital= (PrjSiteVital)itr.next();
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjSiteVital.getId()%>
data_arr[<%= counter%>][1] = "<%= prjSiteVital.getPrj().getPrjName()%>"
<%
	if(vitalsMasterList.size()>0){
		for(MstrVitals mstrVitals :vitalsMasterList){
			if(mstrVitals.getId().equals(prjSiteVital.getVital().getId())){
%>
data_arr[<%= counter%>][2] = "<%= mstrVitals.getVitalDescription()%>"
<%}}}%>
<%
	if(prjSiteVital.getFlag().equals("D")){
%>
data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(prjSiteVital.getPlannedDate())%>"
<%}else if(prjSiteVital.getFlag().equals("V")){%>
data_arr[<%= counter%>][3] = "<%=prjSiteVital.getPlannedValue()%>"
<%}else{%>
data_arr[<%= counter%>][3] = ""
<%}%>
data_arr[<%= counter%>][4] = "<%= prjSiteVital.getPlannedRemark()%>"
<%
	if(prjSiteVital.getFlag().equals("D")){
%>
data_arr[<%= counter%>][5] = "<%=HMSUtil.convertDateToStringWithoutTime(prjSiteVital.getRevisedDate())%>"
<%}else if(prjSiteVital.getFlag().equals("V")){%>
data_arr[<%= counter%>][5] = "<%=prjSiteVital.getRevisedValue()%>"
<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>
data_arr[<%= counter%>][6] = "<%=prjSiteVital.getRevisedRemark()%>"

<%
	if(prjSiteVital.getFlag().equals("D")){
%>
data_arr[<%= counter%>][7] = "<%=HMSUtil.convertDateToStringWithoutTime(prjSiteVital.getActualDate())%>"
<%}else if(prjSiteVital.getFlag().equals("V")){%>
data_arr[<%= counter%>][7] = "<%=prjSiteVital.getActualValue()%>"
<%}else{%>
data_arr[<%= counter%>][7] = ""
<%}%>

data_arr[<%= counter%>][8] = "<%=prjSiteVital.getActualRemark().trim()%>"


data_arr[<%= counter%>][9] = "<%= prjSiteVital.getLastChgBy() %>"
data_arr[<%= counter%>][10] = "<%= HMSUtil.convertDateToStringWithoutTime(prjSiteVital.getLastChgDate()) %>"
data_arr[<%= counter%>][11] = "<%= prjSiteVital.getLastChgTime() %>" 
<% 
if(prjSiteVital.getStatus().equals("y")){ %>
data_arr[<%= counter%>][12] = "Active"
<%}else{%>
data_arr[<%= counter%>][12] = "InActive"
<%}%>
<%if(prjSiteVital.getFlag()!= null){ %>
data_arr[<%= counter%>][13] = "<%= prjSiteVital.getFlag()%>"
<%}else{%>
data_arr[<%= counter%>][13] = ""
<%}%>

<%if(prjSiteVital.getAmountFlag()!= null){ %>
data_arr[<%= counter%>][14] = "<%= prjSiteVital.getAmountFlag() %>"
<%}else{%>
data_arr[<%= counter%>][14] = ""
<%}%>
<%
	if(currencyList.size()>0){
		for(MasCurrency masCurrency:currencyList){
			if(prjSiteVital.getCurrency() != null){
			if(masCurrency.getId().equals(prjSiteVital.getCurrency().getId())){
%>
data_arr[<%= counter%>][15] = "<%= masCurrency.getCurrencyCode()%>"
<%}}else{%>

data_arr[<%= counter%>][15] = ""
<%}}}%>
<%

counter++;
}
%>
 
formName = "siteVitals"

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
 
 function nextProjectSetting()
 {
   var id = <%=projectId%>
   obj = eval('document.'+formName)
     obj.action = "projectTracking?method=showSiteMilesStoneJsp&projectId="+id;
     obj.submit();
     return true;
 
 }
</script>	

