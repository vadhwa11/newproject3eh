<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<PrjFesStudyHeader> feasibilityStudyHeaderList = new ArrayList<PrjFesStudyHeader>();
 				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				
				if(map.get("feasibilityStudyHeaderList") != null){
					feasibilityStudyHeaderList = (List) map.get("feasibilityStudyHeaderList");
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
function openPopupWindow()
			{ var id = 0; 
				 for(var i = 0; i < document.getElementsByName('fesbilitystudyId').length; i++){
					  if(document.getElementsByName('fesbilitystudyId')[i].checked == true)
		              {
						id = document.getElementsByName('fesbilitystudyId')[i].value;
					  }		
		  		}
		  		var url="/hms/hrms/projectTracking?method=viewSqApprovalDocument&fesbilitystudyId="+id+"";
		 		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		 	
			}
			
			
	function validateRadio(){
			 for(var i = 0; i < document.getElementsByName('fesbilitystudyId').length; i++){
			  if(document.getElementsByName('fesbilitystudyId')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please select Record to view document...");
		return false;
		
	}

</script>

<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.PrjFesStudyHeader"%>
<div class="titleBg"> <h2>SQ Approval</h2></div>

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
			[0, "<%= COMMON_ID%>", "id"], [1,"radioId"], [2,"<%= PROJECT_ID %>"],[3,"<%= SITE_ID %>"],[4,"<%= PLANNED_DATE %>"],[5,"<%= ACTUAL_DATE %>"],[6,"<%= PI_HEADER_ID %>"],[7,"<%= CONTACT_PHONE %>"],[8,"<%=SQ_APPROVAL_STATUS%>"],[9,"<%=SQ_APPROVER_EMP_ID%>"],[10,"<%=SQ_APPROVAL_DATE%>"],[11,"<%=SQ_APPROVAL_COMMENTS%>"], [12,"<%= CHANGED_BY %>"],[13,"<%= CHANGED_DATE %>"],[14,"<%=CHANGED_TIME%>"],[15,"<%=STATUS%>"]];
	 statusTd = 15;
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
    		
		
			
</script>

	<div class="clear"></div>
	<div class="division"></div>
	<form name="sqApprovalStatus" method="post" action="" >
	<div class="Block">
	
		
     <label>PI Name</label>
     <input type="text" name="<%=PI_HEADER_ID%>" value="" readonly="readonly" validate="PI Name,string,no" tabindex=1 />
     
      <label>Planned Date</label>
     <input type="text" name="<%=PLANNED_DATE%>" value="" readonly="readonly" validate="Plaaned Date,string,no" tabindex=1 />
     
     <label>Actual Date</label>
     <input type="text" name="<%=ACTUAL_DATE%>" value="" readonly="readonly" validate="Actual Date,string,no" tabindex=1 />
     
     <div class="clear"></div>
     <label><span>*</span>Status</label>
     <select name="<%=SQ_APPROVAL_STATUS %>" value="" validate="Status,string,yes" tabindex=1 >
     <option value="0">Select</option>
     <option value="Approved">Approved</option>
     <option value="Rejected">Rejected</option>
     <option value="On Hold">On Hold</option>
     </select>
    <label><span>*</span>Date</label>
    <input type="text" name="<%=SQ_APPROVAL_DATE%>" value="" readonly="readonly" validate="Date,string,yes" class="textbox_size20" MAXLENGTH="15"/ tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.sqApprovalStatus.<%=SQ_APPROVAL_DATE%>,event)" />
     
     <div class="clear"></div>
     <label>Comments</label>
     <input type="text" name="<%=SQ_APPROVAL_COMMENTS%>" value="" validate="Comments,string,no" class="large" MAXLENGTH="350" / tabindex=1 />
    <div class="clear"></div>
    </div>
     <div class="clear"></div>
       
            <div id="edited"></div>
            <input type="button" name="add" id="addbutton" value="Add" style="display: none;" class="button" onClick="submitForm('sqApprovalStatus','projectTracking?method=addSQApprovalStatus')" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('sqApprovalStatus','projectTracking?method=updateSQApprovalStatus')" accesskey="u" tabindex=1 />
            
            <input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('sqApprovalStatus','projectTracking?method=deleteSQApprovalStatus&flag='+this.value)" accesskey="d" tabindex=1/>
            
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
            
            <input type="button" name="back" id="back" value="Back" class="button" onClick="backProjectSetting();" accesskey="b" tabindex=1 />
            
            <input type="button" name="next" id="next" value="Next" class="button" onClick="nextProjectSetting();" accesskey="n" tabindex=1 />
            
            <input type="button" name="attach" id="attach"  value="View Files" class="button" onClick="if(validateRadio()){javascript:openPopupWindow()};" />
            
                       
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
			<input type="hidden" name="<%= COMMON_ID%>" id="commonId" value="0" />
			
	<div class="clear"></div>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Select"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "radioId";

data_header[1] = new Array;
data_header[1][0] = "Project Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= PROJECT_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Site Name"
data_header[2][1] = "hide";
data_header[2][2] = "20%";
data_header[2][3] = "<%= SITE_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Planned Date"
data_header[3][1] = "hide";
data_header[3][2] = "20%";
data_header[3][3] = "<%= PLANNED_DATE%>";

data_header[4] = new Array;
data_header[4][0] = "Actual Date"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=ACTUAL_DATE %>";


data_header[5] = new Array;
data_header[5][0] = "PI Name"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=PI_HEADER_ID %>";

data_header[6] = new Array;
data_header[6][0] = "Contact No."
data_header[6][1] = "data";
data_header[6][2] = "25%";
data_header[6][3] = "<%=CONTACT_PHONE %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "25%";
data_header[7][3] = "<%=SQ_APPROVAL_STATUS %>";

data_header[8] = new Array;
data_header[8][0] = "Approved By"
data_header[8][1] = "data";
data_header[8][2] = "25%";
data_header[8][3] = "<%=SQ_APPROVER_EMP_ID %>";

data_header[9] = new Array;
data_header[9][0] = "Approval Date"
data_header[9][1] = "data";
data_header[9][2] = "25%";
data_header[9][3] = "<%=SQ_APPROVAL_DATE %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "<%=SQ_APPROVAL_COMMENTS %>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=CHANGED_BY %>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = "15%";
data_header[12][3] = "<%=CHANGED_DATE %>";

data_header[13] = new Array;
data_header[13][0] = ""
data_header[13][1] = "hide";
data_header[13][2] = "15%";
data_header[13][3] = "<%=CHANGED_TIME %>";

data_header[14] = new Array;
data_header[14][0] = ""
data_header[14][1] = "hide";
data_header[14][2] = "15%";
data_header[14][3] = "<%=STATUS %>";

data_arr = new Array();

<%
if(feasibilityStudyHeaderList !=null && feasibilityStudyHeaderList.size() != 0){
	
Iterator itr=feasibilityStudyHeaderList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  PrjFesStudyHeader prjFesStudyHeader = (PrjFesStudyHeader)itr.next();
        	              
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjFesStudyHeader.getId()%>
data_arr[<%= counter%>][1] = '<input name="fesbilitystudyId"  class="radioCheck"  id="rb" type="radio" value="<%=prjFesStudyHeader.getId()%>" />';

data_arr[<%= counter%>][2] = "<%= prjFesStudyHeader.getPrj().getPrjName()%>"
data_arr[<%= counter%>][3] = "<%if(prjFesStudyHeader.getSiteHeader()!= null ){%><%= prjFesStudyHeader.getSiteHeader().getSiteName()%><%}%>"
data_arr[<%= counter%>][4] = "<%if(prjFesStudyHeader.getPlannedVisitDate() != null){%><%= HMSUtil.convertDateToStringWithoutTime(prjFesStudyHeader.getPlannedVisitDate())%><%}%>"
data_arr[<%= counter%>][5] = "<%if(prjFesStudyHeader.getActuaVisitDate() != null){%><%= HMSUtil.convertDateToStringWithoutTime(prjFesStudyHeader.getActuaVisitDate())%><%}%>"
data_arr[<%= counter%>][6] = "<%= prjFesStudyHeader.getPiHeader().getPiName()%>"
<%if(prjFesStudyHeader.getPiHeader().getPiContactNo()!= null){%>
data_arr[<%= counter%>][7] = "<%= prjFesStudyHeader.getPiHeader().getPiContactNo()%>"
<%}else{%>
data_arr[<%= counter%>][7] = ""

<%}%>
data_arr[<%= counter%>][8] = "<%if(prjFesStudyHeader.getSqApprovalStatus() != null){%><%= prjFesStudyHeader.getSqApprovalStatus()%><%}%>"
data_arr[<%= counter%>][9] = "<%if(prjFesStudyHeader.getSqApproverEmp() != null){%><%= prjFesStudyHeader.getSqApproverEmp().getFirstName()%> <%=prjFesStudyHeader.getSqApproverEmp().getLastName()%><%}%>"
data_arr[<%= counter%>][10] = "<%if(prjFesStudyHeader.getSqApproverDate() != null){%><%= HMSUtil.convertDateToStringWithoutTime(prjFesStudyHeader.getSqApproverDate())%><%}%>"
data_arr[<%= counter%>][11] = "<%if(prjFesStudyHeader.getSqApproverComments() != null){%><%= prjFesStudyHeader.getSqApproverComments()%><%}%>"

data_arr[<%= counter%>][12] = "<%= prjFesStudyHeader.getLastChgBy() %>"
data_arr[<%= counter%>][13] = "<%= HMSUtil.convertDateToStringWithoutTime(prjFesStudyHeader.getLastChgDate()) %>"
data_arr[<%= counter%>][14] = "<%= prjFesStudyHeader.getLastChgTime() %>" 
<% if(prjFesStudyHeader.getStatus().equals("y")){ %>
data_arr[<%= counter%>][15] = "Active"
<%}else{%>
data_arr[<%= counter%>][15] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "sqApprovalStatus"

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
     obj.action = "projectTracking?method=showApprovalSettingJsp";
     obj.submit();
     return true;
 
 }
 
 function nextProjectSetting()
 {
   var id = <%=projectId%>
   obj = eval('document.'+formName)
     obj.action = "projectTracking?method=showQAApprovalStatus&projectId="+id;
     obj.submit();
     return true;
 
 }
 
</script>	
			
