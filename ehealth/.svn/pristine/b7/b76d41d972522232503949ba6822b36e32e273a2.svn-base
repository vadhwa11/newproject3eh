<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<PrjQueryEntry> queryEntryList = new ArrayList<PrjQueryEntry>();
				List<PrjAnsEntry>   ansEntryList = new ArrayList<PrjAnsEntry>();
				List<PrjQueryFlwEntry> queryFlwEntryList = new ArrayList<PrjQueryFlwEntry>();
				List<MstrQueryStatus> queryStatusList = new ArrayList<MstrQueryStatus>();
				
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
				
				if(map.get("queryFlwEntryList") != null){
					queryFlwEntryList = (List) map.get("queryFlwEntryList");
				}
			    
				if(map.get("queryStatusList") != null){
					queryStatusList = (List) map.get("queryStatusList");
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
<%@page import="jkt.hrms.masters.business.PrjQueryEntry"%>
<%@page import="jkt.hrms.masters.business.PrjAnsEntry"%>
<%@page import="jkt.hrms.masters.business.PrjQueryFlwEntry"%>
<%@page import="jkt.hrms.masters.business.MstrQueryStatus"%>
<div class="titleBg"> <h2>Query Follow Up Entry</h2></div>

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
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= PROJECT_ID%>"], [2,"<%=QUERY_ENTRY_ID %>"],[3,"<%=ANS_ENTRY_ID %>"],[4,"<%= PLANNED_FLW_DATE %>"],[5,"<%= ACTUAL_FLW_DATE%>"],[6,"<%= NEXT_FLW_DATE %>"],[7,"<%= QUERY_STATUS_ID %>"],[8,"<%= QUERY_FLW_COMMENTS %>"],[9,"<%=CHANGED_BY%>"], [10,"<%= CHANGED_DATE %>"],[11,"<%= CHANGED_TIME %>"],[12,"<%=STATUS%>"]];
	 statusTd = 12;
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
    	
    	
    	function getAnsCodeList(id){
    		var selectBox = document.getElementById('ansEndtryCode');
    		removeAll(selectBox);
    		selectBox.options.add(new Option('Select' ,'0'));
    		<%	for(PrjAnsEntry prjAnsEntry: ansEntryList){	%>
    		if(<%=prjAnsEntry.getQueryEntry().getId()%> == id){
    			selectBox.options.add(new Option('<%=prjAnsEntry.getAnsCode()%>' , '<%=prjAnsEntry.getId()%>'));
    		}
    		<%}%>	
    	}
    	
    	function removeAll(selectBox){
    		var i;
    		for(i = selectBox.options.length - 1; i >=0; i--){
    			selectBox.remove(i);
    		}
    	}
    		
		function getPlannedDate(id){
		<% for(PrjAnsEntry prjAnsEntry: ansEntryList){ %>
			if(<%=prjAnsEntry.getId()%> == id){
				document.getElementById('plannedFlwDate').value = "<%if(prjAnsEntry.getPlannedFlwDate() != null){%><%=HMSUtil.convertDateToStringWithoutTime(prjAnsEntry.getPlannedFlwDate())%><%}%>";
			}
		<%}%>
		}
		
		
		function check(methodName){
	
		var actualFlwDate = document.queryFlwEntry.<%= ACTUAL_FLW_DATE%>.value;
		var nextFlwDate = document.queryFlwEntry.<%= NEXT_FLW_DATE %>.value;
	    
		if(nextFlwDate != ""){
		var actualFlwDate       =new Date(actualFlwDate.substring(6),(actualFlwDate.substring(3,5) - 1) ,actualFlwDate.substring(0,2))
		var	nextFlwDate         =new Date(nextFlwDate.substring(6),(nextFlwDate.substring(3,5) - 1) ,nextFlwDate.substring(0,2))
		if(actualFlwDate > nextFlwDate)
		{
			alert("Please ensure that the Next Follow Up Date is greater than or equal to the Actual Follow Up Date.");
			document.getElementById('nextFlwDate').focus();
			return false;
		}else{
			if(methodName =="add"){
				submitForm('queryFlwEntry','projectTracking?method=addQueryFlwEntry');
			}else if(methodName =="update"){
				submitForm('queryFlwEntry','projectTracking?method=editQueryFlwEntry');
			}
		}
		}else{
			if(methodName =="add"){
				submitForm('queryFlwEntry','projectTracking?method=addQueryFlwEntry');
			}else if(methodName =="update"){
				submitForm('queryFlwEntry','projectTracking?method=editQueryFlwEntry');
			}
		}
	}
		
</script>

	<div class="clear"></div>
	<div class="division"></div>
	<form name="queryFlwEntry" method="post" action="" >
	<div class="Block">
	
		
     <label><span>*</span>Query Code</label>
     <select name="<%=QUERY_ENTRY_ID %>" value="" validate="" validate="Query Code,string,yes" onclick="getAnsCodeList(this.value)" onchange="getAnsCodeList(this.value)" onKeyUp="getAnsCodeList(this.value)" tabindex=1 >
     <option value="0">Select</option>
     <% 
     	for(PrjQueryEntry prjQueryEntry: queryEntryList){
     %>
     <option value="<%=prjQueryEntry.getId() %>"> <%=prjQueryEntry.getQueryCode()%> </option>
     <%} %>
     </select>
     
     <label><span>*</span>Answer Code</label>
     <select name="<%=ANS_ENTRY_ID %>" id="ansEndtryCode" value="" validate="" validate="Ans Code,string,yes" onclick="getPlannedDate(this.value)" onchange="getPlannedDate(this.value)" onKeyUp="getPlannedDate(this.value)" tabindex=1 >
     <option value="0">Select</option>
     <% 
     	for(PrjAnsEntry prjAnsEntry: ansEntryList){
     %>
     <option value="<%=prjAnsEntry.getId() %>"> <%=prjAnsEntry.getAnsCode()%> </option>
     <%} %>
     </select>
     
     <label>&nbsp;Planned Flw Date</label>
     <input type="text" name="plannedFlwDate" id="plannedFlwDate" value="" readonly="readonly" class="textbox_size20" MAXLENGTH="15"/ tabindex=1 />
     
     <div class="clear"></div> 
     
    <label><span>*</span>Actual Flw Date</label>
    <input type="text" name="<%=ACTUAL_FLW_DATE%>" value="" readonly="readonly" validate="Ans Date,string,yes" class="textbox_size20" MAXLENGTH="15"/ tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.queryFlwEntry.<%=ACTUAL_FLW_DATE%>,event)" />
    
         
    <label>Next Flw Date</label>
    <input type="text" name="<%=NEXT_FLW_DATE%>" id="nextFlwDate" value="" readonly="readonly" validate="Planned Flw Date,string,no" class="text_size20" MAXLENGTH="15"/ tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.queryFlwEntry.<%=NEXT_FLW_DATE%>,event)" /> 
     
     <div class="clear"></div>
     
     <label><span>*</span>Query Status</label>
     <select name="<%=QUERY_STATUS_ID %>" value="" validate="Query Status,string,yes" tabindex=1 >
     <option value="0">Select</option>
     <% 
     	for(MstrQueryStatus mstrQueryStatus: queryStatusList){
     %>
     <option value="<%=mstrQueryStatus.getId() %>"> <%=mstrQueryStatus.getQueryStatusDesc()%> </option>
     <%} %>
     </select>
                   
     <label>Comments</label>
     <input type="text" name="<%=QUERY_FLW_COMMENTS%>" value="" validate="Comments,string,no" class="large" MAXLENGTH="350" / tabindex=1 />
    
    <div class="clear"></div>
    </div>
     <div class="clear"></div>
       
            <div id="edited"></div>
            <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="check('add')" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="check('update')" accesskey="u" tabindex=1 />
            
            <input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('queryFlwEntry','projectTracking?method=deleteQueryFlwEntry&flag='+this.value)" accesskey="d" tabindex=1/>
            
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
            
            <input type="button" name="back" id="back" value="Back" class="button" onClick="backProjectSetting();" accesskey="b" tabindex=1 />
            
            
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
					alert("Please select the Query Follow Up record to attach documnt...");
					return false;
				}else{
					var url="/hms/hrms/projectTracking?method=displayQueryFlwEntryAttachment&commonId="+id+"";
			 		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
			 		}
			}
			</script>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   			</div>	
   				
		    <input type="hidden" name="projectId" id="projectId" value="<%=projectId%>" />
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
data_header[2][0] = "Ans Code"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=ANS_ENTRY_ID %>";


data_header[3] = new Array;
data_header[3][0] = "Planned Flw Date"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=PLANNED_FLW_DATE %>";

data_header[4] = new Array;
data_header[4][0] = "Actual Flw Date"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=ACTUAL_FLW_DATE %>";

data_header[5] = new Array;
data_header[5][0] = "Next Flw Date"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=NEXT_FLW_DATE %>";

data_header[6] = new Array;
data_header[6][0] = "Query Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=QUERY_STATUS_ID %>";

data_header[7] = new Array;
data_header[7][0] = "Comments"
data_header[7][1] = "data";
data_header[7][2] = "25%";
data_header[7][3] = "<%=QUERY_FLW_COMMENTS %>";

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

data_arr = new Array();

<%
if(queryFlwEntryList !=null && queryFlwEntryList.size() != 0){
	
Iterator itr=queryFlwEntryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	 PrjQueryFlwEntry prjQueryFlwEntry = (PrjQueryFlwEntry)itr.next();
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjQueryFlwEntry.getId()%>
data_arr[<%= counter%>][1] = "<%= prjQueryFlwEntry.getProject().getPrjName()%>"
data_arr[<%= counter%>][2] = "<%= prjQueryFlwEntry.getQueryEntry().getQueryCode()%>"
data_arr[<%= counter%>][3] = "<%= prjQueryFlwEntry.getAnsEntry().getAnsCode()%>"
data_arr[<%= counter%>][4] = "<%if(prjQueryFlwEntry.getAnsEntry().getPlannedFlwDate() != null){%><%= HMSUtil.convertDateToStringWithoutTime(prjQueryFlwEntry.getAnsEntry().getPlannedFlwDate())%><%}%>"

data_arr[<%= counter%>][5] = "<%if(prjQueryFlwEntry.getActualFlwDate() != null){%><%= HMSUtil.convertDateToStringWithoutTime(prjQueryFlwEntry.getActualFlwDate())%><%}%>"
data_arr[<%= counter%>][6] = "<%if(prjQueryFlwEntry.getNextFlwDate() != null){%><%= HMSUtil.convertDateToStringWithoutTime(prjQueryFlwEntry.getNextFlwDate())%><%}%>"
data_arr[<%= counter%>][7] = "<%= prjQueryFlwEntry.getQueryStatus().getQueryStatusDesc()%>"
data_arr[<%= counter%>][8] = "<%= prjQueryFlwEntry.getQueryFlwComments()%>"

data_arr[<%= counter%>][9]  = "<%= prjQueryFlwEntry.getLastChgBy() %>"
data_arr[<%= counter%>][10] = "<%= HMSUtil.convertDateToStringWithoutTime(prjQueryFlwEntry.getLastChgDate()) %>"
data_arr[<%= counter%>][11] = "<%= prjQueryFlwEntry.getLastChgTime() %>" 
<% if(prjQueryFlwEntry.getStatus().equals("y")){ %>
data_arr[<%= counter%>][12] = "Active"
<%}else{%>
data_arr[<%= counter%>][12] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "queryFlwEntry"

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
 
 
 
</script>	
			
