<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<PrjReglSub>   regulatorySubList = new ArrayList<PrjReglSub>();
				List<PrjQueryEntry> queryEntryList = new ArrayList<PrjQueryEntry>();
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				
				if(map.get("queryEntryList") != null){
					queryEntryList = (List) map.get("queryEntryList");
				}
				
				
				if (map.get("regulatorySubList") != null) {
					regulatorySubList = (List) map.get("regulatorySubList");
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
<%@page import="jkt.hrms.masters.business.PrjReglSub"%>
<%@page import="jkt.hrms.masters.business.PrjQueryEntry"%>
<%@page import="jkt.hrms.masters.business.PrjReglSubDoc"%>
<div class="titleBg"> <h2>Query Entry</h2></div>

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
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= PROJECT_ID%>"], [2,"<%= REGULATORY_SUB_ID %>"], [3,"<%= QUERY_DATE %>"],[4,"<%= PLANNED_ANS_DATE %>"],[5,"<%= QUERY_DESCRIPTION %>"],[6,"<%=CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"]];
	 statusTd = 9;
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
    		
	function getReferenceCode(id){
		<% for(PrjReglSub prjReglSub: regulatorySubList){%>
		   if(<%=prjReglSub.getId()%> == id){
		   	  	document.getElementById('referenceCode').value = "<%=prjReglSub.getReferenceCode()%>" ;
			}
		<%}%>
	}
	
	function check(methodName){
	
		var qDate = document.queryEntry.<%= QUERY_DATE%>.value;
		var plnADate = document.queryEntry.<%= PLANNED_ANS_DATE %>.value;
	    if(plnADate != ""){
	    var queryDate       =new Date(qDate.substring(6),(qDate.substring(3,5) - 1) ,qDate.substring(0,2))
		var	plannedAnsDate  =new Date(plnADate.substring(6),(plnADate.substring(3,5) - 1) ,plnADate.substring(0,2))
		
		if(queryDate > plannedAnsDate)
		{
			alert("Please ensure that the Planned Ans Date is greater than or equal to the Query Date.");
			document.getElementById('plannedAnsDate').focus();
			return false;
		}else{
			if(methodName =="add"){
				submitForm('queryEntry','projectTracking?method=addQueryEntry');
			}else if(methodName =="update"){
				submitForm('queryEntry','projectTracking?method=editQueryEntry');
			}
		}
		}else{
			if(methodName =="add"){
				submitForm('queryEntry','projectTracking?method=addQueryEntry');
			}else if(methodName =="update"){
				submitForm('queryEntry','projectTracking?method=editQueryEntry');
			}
		}
	}
		
</script>

	<div class="clear"></div>
	<div class="division"></div>
	<form name="queryEntry" method="post" action="" >
	<div class="Block">
	
		
     <label><span>*</span>Reference Code</label>
     <select name="<%=REGULATORY_SUB_ID %>" value="" validate="" validate="Reference Code,string,yes" onclick="getReferenceCode(this.value)" onKeyUp="getReferenceCode(this.value)" tabindex=1 >
     <option value="0">Select</option>
     <% 
     	for(PrjReglSub prjReglSub: regulatorySubList){
     %>
     <option value="<%=prjReglSub.getId() %>"> <%=prjReglSub.getReferenceCode() %> </option>
     <%} %>
     </select>
    <label><span>*</span>Query Date</label>
    <input type="text" name="<%=QUERY_DATE%>" value="" readonly="readonly" validate="Query Date,string,yes" class="textbox_size20" MAXLENGTH="15"/ tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.queryEntry.<%=QUERY_DATE%>,event)" />
     
    <div class="clear"></div> 
    <label>Planned Ans Date</label>
    <input type="text" name="<%=PLANNED_ANS_DATE%>" id="plannedAnsDate" value="" readonly="readonly" validate="Planned Ans Date,string,no" class="text_size20" MAXLENGTH="15"/ tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.queryEntry.<%=PLANNED_ANS_DATE%>,event)" /> 
          
     <label>Description</label>
     <input type="text" name="<%=QUERY_DESCRIPTION%>" value="" validate="Description,string,no" class="large" MAXLENGTH="350" / tabindex=1 />
    <div class="clear"></div>
    </div>
     <div class="clear"></div>
       
            <div id="edited"></div>
            <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="check('add')" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="check('update')" accesskey="u" tabindex=1 />
            
            <input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('queryEntry','projectTracking?method=deleteQueryEntry&flag='+this.value)" accesskey="d" tabindex=1/>
            
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
					alert("Please select the Query Entry record to attach documnt...");
					return false;
				}else{
					var url="/hms/hrms/projectTracking?method=displayQueryEntryAttachment&commonId="+id+"";
			 		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
			 		}
			}
			</script>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   			</div>	
   				
		    <input type="hidden" name="projectId" id="projectId" value="<%=projectId%>" />
		    <input type="hidden" name="referenceCode" id="referenceCode" value="" />
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
data_header[1][0] = "Reference Code"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= REGULATORY_SUB_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Query Date"
data_header[2][1] = "data";
data_header[2][2] = "15%";
data_header[2][3] = "<%=QUERY_DATE %>";

data_header[3] = new Array;
data_header[3][0] = "Planned Ans Date"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=PLANNED_ANS_DATE %>";

data_header[4] = new Array;
data_header[4][0] = "Description"
data_header[4][1] = "data";
data_header[4][2] = "25%";
data_header[4][3] = "<%=QUERY_DESCRIPTION %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_BY %>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=CHANGED_DATE %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";

data_arr = new Array();

<%
if(queryEntryList !=null && queryEntryList.size() != 0){
	
Iterator itr=queryEntryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	 PrjQueryEntry prjqueryEntry = (PrjQueryEntry)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjqueryEntry.getId()%>
data_arr[<%= counter%>][1] = "<%= prjqueryEntry.getProject().getPrjName()%>"
data_arr[<%= counter%>][2] = "<%= prjqueryEntry.getReglSub().getReferenceCode()%>"

data_arr[<%= counter%>][3] = "<%if(prjqueryEntry.getQueryDate() != null){%><%= HMSUtil.convertDateToStringWithoutTime(prjqueryEntry.getQueryDate())%><%}%>"
data_arr[<%= counter%>][4] = "<%if(prjqueryEntry.getPlannedAnsDate() != null){%><%= HMSUtil.convertDateToStringWithoutTime(prjqueryEntry.getPlannedAnsDate())%><%}%>"
data_arr[<%= counter%>][5] = "<%= prjqueryEntry.getQueryDesc()%>"

data_arr[<%= counter%>][6] = "<%= prjqueryEntry.getLastChgBy() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(prjqueryEntry.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= prjqueryEntry.getLastChgTime() %>" 
<% if(prjqueryEntry.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "queryEntry"

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
     obj.action = "projectTracking?method=showAnsEntryJsp&projectId="+id;
     obj.submit();
     return true;
 
 }
 
</script>	
			
