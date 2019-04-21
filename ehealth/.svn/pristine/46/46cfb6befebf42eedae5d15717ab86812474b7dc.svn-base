<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<MstrVitals>  vitalsMasterList = new ArrayList<MstrVitals>();
				List<ProjectVitals>	projectVitalsList = new ArrayList<ProjectVitals>();	
				List<MasCurrency> currencyList = new ArrayList<MasCurrency>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
			    if(map.get("vitalsMasterList") != null){
			    	vitalsMasterList = (List)map.get("vitalsMasterList");
			    }
			    if(map.get("currencyList") != null){
			    	currencyList = (List)map.get("currencyList");
			    }
			    if(map.get("projectVitalsList") != null){
			    	projectVitalsList = (List)map.get("projectVitalsList");
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
 
<%@page import="jkt.hrms.masters.business.MstrVitals"%>
<%@page import="jkt.hrms.masters.business.ProjectVitals"%>
<%@page import="jkt.hms.masters.business.MasCurrency"%>
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

<div class="titleBg"> <h2>Project Vitals</h2></div>

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


<script type="text/javascript">

/*	function validateDate(methodName)
	{       
		var plannedDate = document.projectVitals.//PLANNED_DATE%>.value;
		var revisedDate = document.projectVitals. //REVISED_DATE%>.value;
        var actualDate  = document.projectVitals.//ACTUAL_DATE%>.value; 	
        
        		
		if(revisedDate != "")
		{  
		   var	plannedDate = new Date(plannedDate.substring(6),(plannedDate.substring(3,5) - 1) ,plannedDate.substring(0,2));
		   var revisedDate = new Date(revisedDate.substring(6),(revisedDate.substring(3,5) - 1) ,revisedDate.substring(0,2));
		    
		    if(plannedDate > revisedDate)
			{
				alert("Please ensure that the Revised Date is greater than or equal to the Planned Date.");
				document.getElementById('revisedDate').focus();
				return false;
			}else{
				if(actualDate != "")
				{   var actualDate  = new Date(actualDate.substring(6),(actualDate.substring(3,5) - 1) , actualDate.substring(0,2))
						if(revisedDate > actualDate){
							alert("Please ensure that the Actual Date is greater than or equal to the Revised Date.");
							document.getElementById('actualDate').focus();
							return false;
						}else{
						   if(methodName =="add"){
								submitForm('projectVitals','projectTracking?method=addProjectVital');
							}else if(methodName =="update"){
								submitForm('projectVitals','projectTracking?method=editProjectVital');
							}
				   		}
				   }else{
				   		if(methodName =="add"){
							submitForm('projectVitals','projectTracking?method=addProjectVital');
						}else if(methodName =="update"){
							submitForm('projectVitals','projectTracking?method=editProjectVital');
						}
				   }
			   }	
		}else{
			if(methodName =="add"){
				submitForm('projectVitals','projectTracking?method=addProjectVital');
			}else if(methodName =="update"){
				submitForm('projectVitals','projectTracking?method=editProjectVital');
			}
		}
		
	} */
		
</script>

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
				   			 document.getElementById('actualDateId').innerHTML = 'Actual Value';
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
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= PROJECT_ID%>"], [2,"<%= VITAL_ID%>"], [3,"<%= PLANNED_DATE %>"],[4,"<%= REMARK_ONE %>"],
			[5,"<%= REVISED_DATE %>"],[6,"<%= REMARK_TWO %>"],[7,"<%= ACTUAL_DATE %>"],[8,"<%= REMARK_THREE %>"],[9,"<%=CHANGED_BY%>"],
			 [10,"<%= CHANGED_DATE %>"],[11,"<%= CHANGED_TIME %>"],[12,"<%=STATUS%>"],[13, "<%=FLAG%>", "flag"],[14, "<%=AMOUNT_FLAG%>", "amountFlag"],[15, "<%=CURRENCY_ID%>"]];
	 statusTd = 12;
	</script>

<div class="clear"></div>
<div class="division"></div>
<form name="projectVitals" method="post" action="" >
<div class="Block">

	<label>Project Vital</label> 
	<select id="vitalsId" name="<%= VITAL_ID %>" validate="Project Vital,string,yes" onchange="changeLabel(this.value);" tabindex=1>
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
	<input type="hidden" id="flagId" name="<%=FLAG%>" value="" />
  	  <input type="hidden" id="amountFlagId" name="amountFlag" value="" />
    <div class="clear"></div>
	<label id="plannedDateId"><span>*</span>Planned Date</label>
	<input type="text"  name="<%=PLANNED_DATE%>"  value=""  validate="Planned Date,string,yes" class="textbox_size20" MAXLENGTH="15" / tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="plannedDate" validate="Pick a date" class="calender" onclick="setdate('',document.projectVitals.<%=PLANNED_DATE%>,event)"/>
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
    <input type="text" name="<%= REMARK_ONE %>" value="" validate="Remarks,string,no"   MAXLENGTH="100" tabindex=1/>
    
    <div class="clear"></div>
    <label id="revisedDateId">Revised Date</label>
	<input type="text" name="<%=REVISED_DATE%>"   value=""  validate="Revised Date,string,no"  class="textbox_size20" MAXLENGTH="15" / tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="revisedDate" validate="Pick a date" class="calender"  onclick="setdate('',document.projectVitals.<%=REVISED_DATE%>,event)"/>
    <label>Remarks</label>
    <input type="text" name="<%= REMARK_TWO %>" value="" validate="Remarks,string,no"   MAXLENGTH="100" tabindex=1/>
    
    <div class="clear"></div>
    <label id="actualDateId">Actual Date  </label>
	<input type="text" name="<%=ACTUAL_DATE%>"   value=""  validate="Actual Date,string,no" class="textbox_size20" MAXLENGTH="15" / tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" id="actualDate" validate="Pick a date" class="calender" onclick="setdate('',document.projectVitals.<%=ACTUAL_DATE%>,event)"/>
    <label>Remarks</label>
    <input type="text" name="<%= REMARK_THREE %>" value="" validate="Remarks,string,no"  MAXLENGTH="100" tabindex=1/>
    
	<div class="clear"></div>
    </div>
            
           <div class="clear"></div>
            <div id="edited"></div>
            <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('projectVitals','projectTracking?method=addProjectVital');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('projectVitals','projectTracking?method=editProjectVital');" accesskey="u" tabindex=1 />

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
data_header[3][3] = "<%=REMARK_ONE%>";

data_header[4] = new Array;
data_header[4][0] = "Revised"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=REVISED_DATE %>";

data_header[5] = new Array;
data_header[5][0] = "Remark"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=REMARK_TWO%>";

data_header[6] = new Array;
data_header[6][0] = "Actual"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=ACTUAL_DATE%>";

data_header[7] = new Array;
data_header[7][0] = "Remark"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=REMARK_THREE%>";

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
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=FLAG %>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "<%=AMOUNT_FLAG %>";


data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "<%=CURRENCY_ID %>";

data_arr = new Array();

<%
if(projectVitalsList !=null && projectVitalsList.size() >= 0){
	
Iterator itr=projectVitalsList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  ProjectVitals projectVitals = (ProjectVitals)itr.next();
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= projectVitals.getId()%>
data_arr[<%= counter%>][1] = "<%= projectVitals.getPrj().getPrjName()%>"
data_arr[<%= counter%>][2] = "<%= projectVitals.getVital().getVitalDescription()%>"
<%
	if(projectVitals.getFlag().equals("D")){
%>
data_arr[<%= counter%>][3] = "<%=HMSUtil.convertDateToStringWithoutTime(projectVitals.getPlannedDate())%>"
<%}else if(projectVitals.getFlag().equals("V")){%>
data_arr[<%= counter%>][3] = "<%=projectVitals.getPlannedValue()%>"
<%}else{%>
data_arr[<%= counter%>][3] = ""
<%}%>
data_arr[<%= counter%>][4] = "<%= projectVitals.getRemarkOne()%>"
<%
	if(projectVitals.getFlag().equals("D")){
%>
data_arr[<%= counter%>][5] = "<%=HMSUtil.convertDateToStringWithoutTime(projectVitals.getRevisedDate())%>"
<%}else if(projectVitals.getFlag().equals("V")){%>
data_arr[<%= counter%>][5] = "<%=projectVitals.getRevisedValue()%>"
<%}else{%>
data_arr[<%= counter%>][5] = ""
<%}%>
data_arr[<%= counter%>][6] = "<%= projectVitals.getRemarkTwo()%>"

<%
	if(projectVitals.getFlag().equals("D")){
%>
data_arr[<%= counter%>][7] = "<%=HMSUtil.convertDateToStringWithoutTime(projectVitals.getActualDate())%>"
<%}else if(projectVitals.getFlag().equals("V")){%>
data_arr[<%= counter%>][7] = "<%=projectVitals.getActualValue()%>"
<%}else{%>
data_arr[<%= counter%>][7] = ""
<%}%>
data_arr[<%= counter%>][8] = "<%= projectVitals.getRemarkThree()%>"
data_arr[<%= counter%>][9] = "<%= projectVitals.getLastChgBy() %>"
data_arr[<%= counter%>][10] = "<%= HMSUtil.convertDateToStringWithoutTime(projectVitals.getLastChgDate()) %>"
data_arr[<%= counter%>][11] = "<%= projectVitals.getLastChgTime() %>" 
<% if(projectVitals.getStatus().equals("y")){ %>
data_arr[<%= counter%>][12] = "Active"
<%}else{%>
data_arr[<%= counter%>][12] = "InActive"
<%}%>

<%if(projectVitals.getFlag()!= null){ %>
data_arr[<%= counter%>][13] = "<%= projectVitals.getFlag()%>"
<%}else{%>
data_arr[<%= counter%>][13] = ""
<%}%>

<%if(projectVitals.getAmountFlag()!= null){ %>
data_arr[<%= counter%>][14] = "<%= projectVitals.getAmountFlag() %>"
<%}else{%>
data_arr[<%= counter%>][14] = ""
<%}%>
<%
	if(currencyList.size()>0){
		for(MasCurrency masCurrency:currencyList){
			if(projectVitals.getCurrency() != null){
			if(masCurrency.getId().equals(projectVitals.getCurrency().getId())){
%>
data_arr[<%= counter%>][15] = "<%= masCurrency.getCurrencyCode()%>"
<%}}else{%>

data_arr[<%= counter%>][15] = ""
<%}}}%>

<%
		     counter++;
}
%>
 
formName = "projectVitals"

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
     obj.action = "projectTracking?method=showOtherVitalsJsp&projectId="+id;
     obj.submit();
     return true;
 
 }
</script>	

