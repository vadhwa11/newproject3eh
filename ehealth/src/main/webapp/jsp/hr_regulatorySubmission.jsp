<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<MstrRegulatoryStatus> regulatoryStatusLst = new ArrayList<MstrRegulatoryStatus>();
				List<MstrDoctype> documentTypeList = new ArrayList<MstrDoctype>();
				List<MstrDocument> documentList = new ArrayList<MstrDocument>();
				List<PrjReglSub>   regulatorySubList = new ArrayList<PrjReglSub>();
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				
				if(map.get("regulatoryStatusLst") != null){
					regulatoryStatusLst = (List) map.get("regulatoryStatusLst");
				}
			    
				if(map.get("documentTypeList") != null){
					documentTypeList = (List) map.get("documentTypeList");
				}
				
				if(map.get("documentList") != null){
					documentList = (List) map.get("documentList");
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
<%@page import="jkt.hrms.masters.business.MstrRegulatoryStatus"%>
<%@page import="jkt.hrms.masters.business.MstrDoctype"%>
<%@page import="jkt.hrms.masters.business.MstrDocument"%>
<%@page import="jkt.hrms.masters.business.PrjReglSub"%>
<div class="titleBg"> <h2>Regulatory Submission</h2></div>

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
			[0, "<%= COMMON_ID%>", "id"],[1,"radioId"], [2,"<%= PROJECT_ID%>"], [3,"<%= SUBMISSION_DATE %>"], [4,"<%= APPROVAL_DATE %>"],[5,"<%= REGULATORY_STATUST_ID %>"],[6,"<%= REGULATORY_COMMENTS %>"],[7,"<%= DOCUMENT_TYPE_ID %>"],[8,"<%= REFERENCE_CODE %>"],[9,"documentNames"],[10,"<%= DOCUMENT_ID %>"],[11,"<%= REMARKS %>"],[12,"<%=CHANGED_BY%>"], [13,"<%= CHANGED_DATE %>"],[14,"<%= CHANGED_TIME %>"],[15,"<%=STATUS%>"]];
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
    		
		function getDocumentList(id){
			var sel1 = document.getElementById("documentId");
			removeAllOptions(sel1);
			var sel = document.getElementById("documentId");
			sel.options.add(new Option('Select', '0'));
			<%
			for(MstrDocument mstrDocument: documentList){
			%>
			if(<%=mstrDocument.getDocType().getId()%> == id){
				sel.options.add(new Option('<%=mstrDocument.getDocName()%>' , '<%=mstrDocument.getId()%>',false,false));
				}
			<%} //End of MstrDocument For loop. %>  
		}
		
		function removeAllOptions(selectbox)
		{
			var i;
			for(i=selectbox.options.length-1;i>=0;i--)
			{
				selectbox.remove(i);
			}
		}	
		
		
		function check(methodName){
	
		var SDate = document.regulatorySubmission.<%= SUBMISSION_DATE%>.value;
		var ADate = document.regulatorySubmission.<%= APPROVAL_DATE %>.value;
	    if(ADate != ""){
	    var submissionDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))
		var	aprovalDate    =new Date(ADate.substring(6),(ADate.substring(3,5) - 1) ,ADate.substring(0,2))
		
		if(submissionDate > aprovalDate)
		{
			alert("Please ensure that the Approval Date is greater than or equal to the Submission Date.");
			document.getElementById('approvalDate').focus();
			return false;
		}else{
			if(methodName =="add"){
				submitForm('regulatorySubmission','projectTracking?method=addRegulatorySubmission');
			}else if(methodName =="update"){
				submitForm('regulatorySubmission','projectTracking?method=editRegulatorySubmission')
			}
		}
		}else{
			if(methodName =="add"){
				submitForm('regulatorySubmission','projectTracking?method=addRegulatorySubmission');
			}else if(methodName =="update"){
				submitForm('regulatorySubmission','projectTracking?method=editRegulatorySubmission')
			}
		}
	}
		
		
</script>

	<div class="clear"></div>
	<div class="division"></div>
	<form name="regulatorySubmission" method="post" action="" >
	<div class="Block">
     
    <label><span>*</span>Submission Date</label>
    <input type="text" name="<%=SUBMISSION_DATE%>" value="" readonly="readonly" validate="Submission Date,string,yes" class="textbox_size20" MAXLENGTH="15"/ tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.regulatorySubmission.<%=SUBMISSION_DATE%>,event)" />
     
    <label>Approval Date</label>
    <input type="text" name="<%=APPROVAL_DATE%>" id="approvalDate" value="" readonly="readonly" validate="Approval Date,string,no" class="text_size20" MAXLENGTH="15"/ tabindex=1 />
    <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" onclick="setdate('',document.regulatorySubmission.<%=APPROVAL_DATE%>,event)" /> 
     
     <div class="clear"></div>
       
     <label><span>*</span>Status</label>
     <select name="<%=REGULATORY_STATUST_ID %>" value="" validate="Status,string,yes" tabindex=1>
     <option value="1">Pending</option>
     <%
     	for(MstrRegulatoryStatus mstrRegulatoryStatus: regulatoryStatusLst){
     %>  
     <option value="<%=mstrRegulatoryStatus.getId() %>"><%=mstrRegulatoryStatus.getRegulatoryStatusDesc()%></option>
     <%} %>
     </select>
     <label>Comments</label>
     <input type="text" name="<%=REGULATORY_COMMENTS %>" value="" validate="Comments,string,no" class="large" MAXLENGTH="250" / tabindex=1 />
    
     <div class="clear"></div>
     <label>Document Type</label>
     <select name="<%=DOCUMENT_TYPE_ID %>" value="" vailidate="Document Type,string,no" onclick="getDocumentList(this.value)" onKeyUp="getDocumentList(this.value)" tabindex=1 >
     <option value="0">Select</option>
     <%
     	for(MstrDoctype mstrDoctype: documentTypeList){
     %>
     <option value="<%=mstrDoctype.getId() %>"><%=mstrDoctype.getDocTypeName()%></option>
     <%} %>
     </select>
     <label><span>*</span>Reference Code</label>
     <input type="text" name="<%=REFERENCE_CODE %>" value="" validate="Reference Code,string,yes" class="textbox_size20" MAXLENGTH="15" tabindex=1 />
     
     <div class="clear"></div>
     
     <label>Document</label>
     <select name="<%=DOCUMENT_ID%>" id="documentId" 
     	class="list" multiple="multiple" vailidate="Document,string,no" tabindex=1 >
     <option value="">Select</option>
     <%for(MstrDocument mstrDocument: documentList){%> 
     	<option value="<%= mstrDocument.getId() %>"> <%=mstrDocument.getDocName() %></option>
     <%} %>
     </select>
     
     <label>Remarks</label>
     <input type="text" name="<%=REMARKS %>" value="" validate="Remarks,string,no" class="large" MAXLENGTH="150" tabindex=1 />
     </div>
     <div class="clear"></div>
       
            <div id="edited"></div>
            <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="check('add')" accesskey="a" tabindex=1/>
		
			<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="check('update')" accesskey="u" tabindex=1 />
            
            <input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('regulatorySubmission','projectTracking?method=deleteRegulatorySubmission&flag='+this.value)" accesskey="d" tabindex=1/>
            
			<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
            
            <input type="button" name="back" id="back" value="Back" class="button" onClick="backProjectSetting();" accesskey="b" tabindex=1 /> 
            
            <input type="button" name="next" id="next" value="Next" class="button" onClick="nextProjectSetting();" accesskey="n" tabindex=1 />
            
            <input type="button" name="attach" id="attach"  value="Attach Files" style="display: inline;" class="button" onClick="if(validateRadio()){javascript:openPopupWindow()};" />
            
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
			{ var id = 0; 
				 for(var i = 0; i < document.getElementsByName('regulatorySubmissionRd').length; i++){
					  if(document.getElementsByName('regulatorySubmissionRd')[i].checked == true)
		              {
						id = document.getElementsByName('regulatorySubmissionRd')[i].value;
					  }		
		  		}
		  		var url="/hms/hrms/projectTracking?method=displayAttachment&commonId="+id+"";
		 		newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
		 	
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
data_header[0][0] = "Select"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "radioId";

data_header[1] = new Array;
data_header[1][0] = "Project Name"
data_header[1][1] = "hide";
data_header[1][2] = "20%";
data_header[1][3] = "<%= PROJECT_ID%>";

data_header[2] = new Array;
data_header[2][0] = "Submission Date"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= SUBMISSION_DATE %>";

data_header[3] = new Array;
data_header[3][0] = "Approval Date"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=APPROVAL_DATE %>";

data_header[4] = new Array;
data_header[4][0] = "Status"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=REGULATORY_STATUST_ID %>";

data_header[5] = new Array;
data_header[5][0] = "Comments"
data_header[5][1] = "data";
data_header[5][2] = "25%";
data_header[5][3] = "<%=REGULATORY_COMMENTS %>";

data_header[6] = new Array;
data_header[6][0] = "Document Type"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=DOCUMENT_TYPE_ID %>";

data_header[7] = new Array;
data_header[7][0] = "Reference Code"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%=REFERENCE_CODE %>";

data_header[8] = new Array;
data_header[8][0] = "Document"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "documentNames";

data_header[9] = new Array;
data_header[9][0] = "Document Ids"
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%=DOCUMENT_ID %>";

data_header[10] = new Array;
data_header[10][0] = "Remarks"
data_header[10][1] = "data";
data_header[10][2] = "25%";
data_header[10][3] = "<%=REMARKS %>";

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "<%=CHANGED_BY %>";

data_header[12] = new Array;
data_header[12][0] = ""
data_header[12][1] = "hide";
data_header[12][2] = 0;
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

if(regulatorySubList !=null && regulatorySubList.size() != 0){
	
Iterator itr=regulatorySubList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             PrjReglSub  prjreglSub = (PrjReglSub)itr.next();

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjreglSub.getId()%>
data_arr[<%= counter%>][1] = '<input name="regulatorySubmissionRd"  class="radioCheck"  id="rb" type="radio" value="<%=prjreglSub.getId()%>" />';

data_arr[<%= counter%>][2] = "<%= prjreglSub.getPrj().getPrjName()%>"

data_arr[<%= counter%>][3] = "<%if(prjreglSub.getSubDate() != null){%><%= HMSUtil.convertDateToStringWithoutTime(prjreglSub.getSubDate())%><%}%>"
data_arr[<%= counter%>][4] = "<%if(prjreglSub.getApprDate() != null){%><%= HMSUtil.convertDateToStringWithoutTime(prjreglSub.getApprDate())%><%}%>"
data_arr[<%= counter%>][5] = "<%= prjreglSub.getRegulatoryStatus().getRegulatoryStatusDesc()%>"
data_arr[<%= counter%>][6] = "<%= prjreglSub.getComments()%>"
data_arr[<%= counter%>][7] = "<%if(prjreglSub.getDocType() != null){%><%= prjreglSub.getDocType().getDocTypeName()%><%}%>"
data_arr[<%= counter%>][8] = "<%= prjreglSub.getReferenceCode()%>"
<%
Set<MstrDocument> docSet = prjreglSub.getDoc();
StringBuffer documentIds = new StringBuffer();
StringBuffer documentNames = new StringBuffer();

for (MstrDocument mstrDocument : docSet) {
	if (documentIds.toString().length() > 0) {
		documentIds.append(",");
		documentIds.append(mstrDocument.getId());
		
		documentNames.append(",");
		documentNames.append(mstrDocument.getDocName());
	}else{
		documentIds.append(mstrDocument.getId());
		documentNames.append(mstrDocument.getDocName());	
	}
}
%>
data_arr[<%= counter%>][9] = "<%=documentNames.toString()%>"

data_arr[<%= counter%>][10] = "<%=documentIds.toString()%>"

data_arr[<%= counter%>][11] = "<%= prjreglSub.getRemark()%>"

data_arr[<%= counter%>][12] = "<%= prjreglSub.getLastChgBy() %>"
data_arr[<%= counter%>][13] = "<%= HMSUtil.convertDateToStringWithoutTime(prjreglSub.getLastChgDate()) %>"
data_arr[<%= counter%>][14] = "<%= prjreglSub.getLastChgTime() %>" 

<% if(prjreglSub.getStatus().equals("y")){ %>
data_arr[<%= counter%>][15] = "Active"
<%}else{%>
data_arr[<%= counter%>][15] = "InActive"
<%}%>


<%
		     counter++;
}
%>
 
formName = "regulatorySubmission"

nonEditable = ['<%= COMMON_ID%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
<%}%>	


	function validateRadio(){
			 for(var i = 0; i < document.getElementsByName('regulatorySubmissionRd').length; i++){
			  if(document.getElementsByName('regulatorySubmissionRd')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please select the regulatory submission record to attach documnt...");
		return false;
		
	}
 
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
	     obj.action = "projectTracking?method=showQueryEntryJsp&projectId="+id;
	     obj.submit();
	     return true;
	 
	 }
 
</script>	
			
