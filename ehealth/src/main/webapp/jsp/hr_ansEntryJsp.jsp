<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<PrjQueryEntry> queryEntryList = new ArrayList<PrjQueryEntry>();
				List<PrjAnsEntry>   ansEntryList = new ArrayList<PrjAnsEntry>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				
				if(map.get("queryEntryList") != null){
					queryEntryList = (List) map.get("queryEntryList");
				}
				
				
				if (map.get("ansEntryList") != null) {
					ansEntryList = (List) map.get("ansEntryList");
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
<script type="text/javascript">
	function checkFromDate(){
	
		var sDate = document.getElementById('startDateId').value;
		var eDate =document.getElementById('endDateId').value;
		var	stDate =new Date(sDate.substring(6),(sDate.substring(3,5) - 1) ,sDate.substring(0,2))
		var enDate =new Date(eDate.substring(6),(eDate.substring(3,5) - 1) ,eDate.substring(0,2))
		
		
		
			//alert(document.getElementById('tDateGrid'+i).value)
			var pFlwDate = document.getElementById('plannedFlwDate').value;
			var aAnsDate = document.getElementById('actualAnsDate').value;
			//alert(tGridStr);
			var	planedFlwdate =new Date(pFlwDate.substring(6),(pFlwDate.substring(3,5) - 1) ,pFlwDate.substring(0,2))
			var actualAnsDate =new Date(aAnsDate.substring(6),(aAnsDate.substring(3,5) - 1) ,aAnsDate.substring(0,2))
			
			if(pFlwDate != "" && aAnsDate != ""){
				if(actualAnsDate > planedFlwdate){
					alert("Planned Followup Date should be greater than Actual Followup Date.");
					return false;
				}
			
			}
			
			if(aAnsDate != ""){
				if(actualAnsDate < stDate || actualAnsDate > enDate){
					alert("Actual Followup Date  should be in between Project Start Date End date.");
					return false;
				}
			}
			if(pFlwDate != ""){
				if(planedFlwdate < stDate || planedFlwdate > enDate){
					alert("Planned Followup Date  should be in between Project Start Date End date.");
					return false;
				}
			}
		return true;
			}
	
	</script>


<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.PrjQueryEntry"%>
<%@page import="jkt.hrms.masters.business.PrjAnsEntry"%>
<div class="titleBg"> <h2>Query Answer Entry</h2></div>

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
<label ><%=HMSUtil.convertDateToStringWithoutTime(StartDate) %></label>
<%}else{%>
<label>&nbsp;</label>
<%} %>
<input type="hidden" name="startDate" id="startDateId" value="<%=HMSUtil.convertDateToStringWithoutTime(StartDate) %>" />
<label>End Date </label>
<%if(endDate !=null){ %>
<label><%=HMSUtil.convertDateToStringWithoutTime(endDate)%></label>
<%}else{%>
<label>&nbsp;</label>
<%} %>
<input type="hidden" name="startDate" id="endDateId" value="<%=HMSUtil.convertDateToStringWithoutTime(endDate) %>" />
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
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= PROJECT_ID%>"], [2,"<%=QUERY_ENTRY_ID %>"],[3,"<%=PLANNED_ANS_DATE %>"],[4,"<%= ACTUAL_ANS_DATE %>"],[5,"<%= PLANNED_FLW_DATE%>"],[6,"<%= ANS_DESCRIPTION %>"],[7,"<%=CHANGED_BY%>"], [8,"<%= CHANGED_DATE %>"],[9,"<%= CHANGED_TIME %>"],[10,"<%=STATUS%>"]];
	 statusTd = 10;
	</script>



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
    		
		function getPlannedDate(id){
		<% for(PrjQueryEntry prjQueryEntry: queryEntryList){ %>
			if(<%=prjQueryEntry.getId()%> == id){
				document.getElementById('plannedAnsDate').value = "<%if(prjQueryEntry.getPlannedAnsDate() != null){%><%=HMSUtil.convertDateToStringWithoutTime(prjQueryEntry.getPlannedAnsDate())%><%}%>";
				document.getElementById('queryCode').value = "<%=prjQueryEntry.getQueryCode()%>";
			}
		<%}%>
		}
		
		/*function check(methodName){
	
		var actualAnsDate = document.ansEntry.<%= ACTUAL_ANS_DATE%>.value;
		var plannedFlwDate = document.ansEntry.<%= PLANNED_FLW_DATE %>.value;
	    if(plannedFlwDate != ""){
	    var actualAnsDate       =new Date(actualAnsDate.substring(6),(actualAnsDate.substring(3,5) - 1) ,actualAnsDate.substring(0,2))
		var	plannedFlwDate  =new Date(plannedFlwDate.substring(6),(plannedFlwDate.substring(3,5) - 1) ,plannedFlwDate.substring(0,2))
		
		if(actualAnsDate > plannedFlwDate)
		{
			alert("Please ensure that the Planned Follow Up Date is greater than or equal to the Actual Answer Date.");
			document.getElementById('plannedFlwDate').focus();
			return false;
		}else{
			if(methodName =="add"){
				submitForm('ansEntry','projectTracking?method=addAnsEntry');
			}else if(methodName =="update"){
				submitForm('ansEntry','projectTracking?method=editAnsEntry');
			}
		}
		}else{
			if(methodName =="add"){
				submitForm('ansEntry','projectTracking?method=addAnsEntry');
			}else if(methodName =="update"){
				submitForm('ansEntry','projectTracking?method=editAnsEntry');
			}
		}
	}*/
		
		
</script>

	<div class="clear"></div>
	<div class="division"></div>
	<form name="ansEntry" method="post" action="" >
	<div class="Block">
	
		
     <label><span>*</span>Query Code</label>
     <select name="<%=QUERY_ENTRY_ID %>" value=""  validate="Query Code,string,yes" onclick="getPlannedDate(this.value)" onchange="getPlannedDate(this.value)" onKeyUp="getPlannedDate(this.value)" tabindex=1 >
     <option value="0">Select</option>
     <% 
     	for(PrjQueryEntry prjQueryEntry: queryEntryList){
     %>
     <option value="<%=prjQueryEntry.getId() %>"> <%=prjQueryEntry.getQueryCode()%> </option>
     <%} %>
     </select>
     
     <label>&nbsp;Planned Ans Date</label>
     <input type="text" name="plannedAnsDate" id="plannedAnsDate" value="" readonly="readonly" class="textbox_size20" MAXLENGTH="15"/ tabindex=1 />
     
     <div class="clear"></div> 
     
    <label><span>*</span>Actual Ans Date</label>
    <input id="actualAnsDate" type="text" name="<%=ACTUAL_ANS_DATE%>" value="" readonly="readonly" validate="Ans Date,string,yes" class="textbox_size20" MAXLENGTH="15"/ tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.ansEntry.<%=ACTUAL_ANS_DATE%>,event)" />
    
         
    <label>Planned Flw Date</label>
    <input  type="text" name="<%=PLANNED_FLW_DATE%>" id="plannedFlwDate" value="" readonly="readonly" validate="Planned Flw Date,string,no" class="text_size20" MAXLENGTH="15"/ tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.ansEntry.<%=PLANNED_FLW_DATE%>,event)" /> 
     
     <div class="clear"></div>
          
     <label>Description</label>
     <input type="text" name="<%=ANS_DESCRIPTION%>" value="" validate="Description,string,no" class="large" MAXLENGTH="350" / tabindex=1 />
    <div class="clear"></div>
    </div>
     <div class="clear"></div>
       
            <div id="edited"></div>
            <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('ansEntry','projectTracking?method=addAnsEntry','checkFromDate');" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('ansEntry','projectTracking?method=editAnsEntry');" accesskey="u" tabindex=1 />
            
            <input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('ansEntry','projectTracking?method=deleteAnsEntry&flag='+this.value)" accesskey="d" tabindex=1/>
            
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
            
            <input type="button" name="back" id="back" value="Back" class="button" onClick="backProjectSetting();" accesskey="b" tabindex=1 />
            
            <input type="button" name="next" id="next" value="Next" class="button" onClick="nextProjectSetting();" accesskey="n" tabindex=1 />
            
            <input type="button" name="attach" id="attach"  value="Attach Files" style="display: inline;" class="button" onClick="javascript:openPopupWindow();" />
            
            <div class="clear"></div>
            <div class="division"></div>
            
            <div class="bottom">
			<label>Changed By</label>   
			<label class="value"><%=userName%></label>
			        
			<label>Changed Date</label>   
			<label class="value"><%=date%></label>
			 
			<label>Changed Time</label>   
			<label class="value"><%=time%></label>
			
			<script type="text/javascript">
			function openPopupWindow()
			{   var id = document.getElementById('commonId').value;
				if(id == 0){
					alert("Please select the Answer Entry record to attach documnt...");
					return false;
				}else{
					var url="/hms/hrms/projectTracking?method=displayAnsEntryAttachment&commonId="+id+"";
			 		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
			 		}
			}
			</script>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   			</div>	
   				
		    <input type="hidden" name="projectId" id="projectId" value="<%=projectId%>" />
		    <input type="hidden" name="queryCode" id="queryCode" value="" />
	       	<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= COMMON_ID%>" id="commonId" value="0" />
			
	<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Project Name"
data_header[0][1] = "hide";
data_header[0][2] = "20%";
data_header[0][3] = "<%= PROJECT_ID%>";

data_header[1] = new Array;
data_header[1][0] = "Query Code"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= QUERY_ENTRY_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Planned Ans Date"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=PLANNED_ANS_DATE %>";


data_header[3] = new Array;
data_header[3][0] = "Actual Ans Date"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=ACTUAL_ANS_DATE %>";

data_header[4] = new Array;
data_header[4][0] = "Planned Flw Date"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=PLANNED_FLW_DATE %>";

data_header[5] = new Array;
data_header[5][0] = "Description"
data_header[5][1] = "data";
data_header[5][2] = "25%";
data_header[5][3] = "<%=ANS_DESCRIPTION %>";

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
if(ansEntryList !=null && ansEntryList.size() != 0){
	
Iterator itr=ansEntryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	 PrjAnsEntry prjAnsEntry = (PrjAnsEntry)itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjAnsEntry.getId()%>
data_arr[<%= counter%>][1] = "<%= prjAnsEntry.getProject().getPrjName()%>"
data_arr[<%= counter%>][2] = "<%= prjAnsEntry.getQueryEntry().getQueryCode()%>"
data_arr[<%= counter%>][3] = "<%if(prjAnsEntry.getQueryEntry().getPlannedAnsDate()!= null){%><%= HMSUtil.convertDateToStringWithoutTime(prjAnsEntry.getQueryEntry().getPlannedAnsDate())%><%}%>"

data_arr[<%= counter%>][4] = "<%if(prjAnsEntry.getActualAnsDate() != null){%><%= HMSUtil.convertDateToStringWithoutTime(prjAnsEntry.getActualAnsDate())%><%}%>"
data_arr[<%= counter%>][5] = "<%if(prjAnsEntry.getPlannedFlwDate() != null){%><%= HMSUtil.convertDateToStringWithoutTime(prjAnsEntry.getPlannedFlwDate())%><%}%>"
data_arr[<%= counter%>][6] = "<%= prjAnsEntry.getAnsDescription()%>"

data_arr[<%= counter%>][7] = "<%= prjAnsEntry.getLastChgBy() %>"
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(prjAnsEntry.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= prjAnsEntry.getLastChgTime() %>" 
<% if(prjAnsEntry.getStatus().equals("y")){ %>
data_arr[<%= counter%>][10] = "Active"
<%}else{%>
data_arr[<%= counter%>][10] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "ansEntry"

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
     obj.action = "projectTracking?method=showRequlatoryMenuJsp";
     obj.submit();
     return true;
 
 }
 
 function nextProjectSetting()
 {
   var id = <%=projectId%>
   obj = eval('document.'+formName)
     obj.action = "projectTracking?method=showQueryFlwEntryJsp&projectId="+id;
     obj.submit();
     return true;
 
 }
 
</script>	
			
