<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.PrjFesStudyDetail"%>
<script type="text/javascript" language="javascript" src="../jsp/js/proto.js"></script>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<MstrPiHeader> tempList = new ArrayList<MstrPiHeader>();
				List<PrjFesStudyHeader> feasibilityHeaderList = new ArrayList<PrjFesStudyHeader>();
				List<MstrRating> ratingList = new ArrayList<MstrRating>();
				List<MstrPiHeader>mstrPiHeaderList = new ArrayList<MstrPiHeader>();
				List<PrjFesStudyDetail> feasibilityStudyDetailList = new ArrayList<PrjFesStudyDetail>();
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("feasibilityStudyDetailList")!= null){
					feasibilityStudyDetailList = (List)map.get("feasibilityStudyDetailList");
				}
				if(map.get("ratingList")!= null){
					ratingList = (List)map.get("ratingList");
				}
				
				if(map.get("tempList")!= null){
					tempList = (List)map.get("tempList");
				}
				if(map.get("feasibilityHeaderList")!= null){
					feasibilityHeaderList = (List)map.get("feasibilityHeaderList");
				}
				if(map.get("mstrPiHeaderList")!= null){
					mstrPiHeaderList = (List)map.get("mstrPiHeaderList");
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
				String loiDate = "";
				String purchaseDate = "";
				String conTractDate = "";
				String purchaseOrderNo = "";
				String contractNo = "";
				String loino = "";
				String therapeuticArea = "";
				int projectId = 0;
				if(projectList.size()>0){
					for (MstrProject mstrProject :projectList){
						projectName= mstrProject.getPrjName();
						projectCode = mstrProject.getPrjCode();
						sponsorName = mstrProject.getSponsor().getSponsorName();
						trialPhase = mstrProject.getTrialPhase().getTrialPhaseName();
						if(mstrProject.getPrjProtocalno()!= null){
						protocolNo = mstrProject.getPrjProtocalno();
						}
						projectType = mstrProject.getProjectType().getProjectName();
						projectStatus = mstrProject.getProjectStatus().getPrjsName();
						if(mstrProject.getPrjExpectedbudget()!= null){
						budget = mstrProject.getPrjExpectedbudget();
						}
						StartDate = mstrProject.getPrjStdt();
						endDate  = mstrProject.getPrjEddt();
						if(mstrProject.getPrjLoidt()!= null){
						loiDate = HMSUtil.convertDateToStringWithoutTime(mstrProject.getPrjLoidt());
						}
						if(mstrProject.getPrjLoino()!= null){
						loino = mstrProject.getPrjLoino();
						}
						if(mstrProject.getPurchasOrderDate()!= null ){
							purchaseDate = HMSUtil.convertDateToStringWithoutTime(mstrProject.getPurchasOrderDate());
						}
						if(mstrProject.getContractDate()!= null){
							conTractDate = HMSUtil.convertDateToStringWithoutTime(mstrProject.getContractDate());
						}
						if(mstrProject.getContractNo()!= null){
							contractNo = mstrProject.getContractNo();
						}
						if(mstrProject.getPurchaseOrderNo()!= null){
							purchaseOrderNo = mstrProject.getPurchaseOrderNo();
						}
						if(mstrProject.getThp().getThpDesc()!= null){
							therapeuticArea = mstrProject.getThp().getThpDesc();
						}
						projectId = mstrProject.getId();
					}
				}
				
				
				
				
	%>
<%@page import="jkt.hrms.masters.business.PrjMilestone"%>
<%@page import="jkt.hrms.masters.business.MstrPiHeader"%>
<%@page import="jkt.hrms.masters.business.PrjFesStudyHeader"%>
<%@page import="jkt.hrms.masters.business.MstrRating"%>
<script type="text/javascript">
	
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
<script type="text/javascript">
	function calculateAmount()
	{
		var totalAmount = document.getElementById('totalAmountId').value;
		var paymentPercentage = document.getElementById('paymentPercentageId').value;
		if(totalAmount != "" && paymentPercentage!=""  )
		{
		var totalAmt = parseFloat(totalAmount);
		var amtInpercentage = parseFloat(paymentPercentage);
		var amount = (totalAmt * paymentPercentage)/100;
		document.getElementById('amountId').value=amount;
		 }
	}
	
	
	function backProjectSetting()
	{
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=showProjectVitalsJsp";
  		 obj.submit();
  		 return true;
	
	}
	function updateFeasibilityStudy()
	{	
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=updateSelectedPi";
  		 obj.submit();
  		 return true;
	
	}
	function saveFeasibilityStudy()
	{	
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=saveSelectedDoctors";
  		 obj.submit();
  		 return true;
	
	}
	function assignTask()
	{
		var fhId = 0; 
		 for(var i = 0; i < document.getElementsByName('feasibiltyStudyId1').length; i++){
			  if(document.getElementsByName('feasibiltyStudyId1')[i].checked == true)
              {
				fhId = document.getElementsByName('feasibiltyStudyId1')[i].value;
			  }		
  		}
		submitProtoAjax('feasibilityStudy','projectTracking?method=getCallPiDetailForAjax&feasibiltyStudyId='+fhId)
  		 return true;
	
	}
	function saveCalldetail()
	{
		var fhId = 0; 
		 for(var i = 0; i < document.getElementsByName('feasibiltyStudyId1').length; i++){
			  if(document.getElementsByName('feasibiltyStudyId1')[i].checked == true)
              {
				fhId = document.getElementsByName('feasibiltyStudyId1')[i].value;
			  }		
  		}
  		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=saveDoctorsCallDetail&projectId="+id+"&feasibilityStuduId="+fhId;
  		 obj.submit();
  		 return true;
	
	}
	function saveSitedetail()
	{
		var fhId = 0; 
		 for(var i = 0; i < document.getElementsByName('feasibiltyStudyId1').length; i++){
			  if(document.getElementsByName('feasibiltyStudyId1')[i].checked == true)
              {
				fhId = document.getElementsByName('feasibiltyStudyId1')[i].value;
			  }		
  		}
  		 var id = <%=projectId%>
		 obj = eval('document.'+formName)
  		 obj.action = "projectTracking?method=addSiteDetailForPi&projectId="+id+"&feasibilityStuduId="+fhId;
  		// obj.action = "projectTracking?method=addSiteDetailForPi&projectId="+id+"&feasibilityStuduId="+fhId+",'validateRadio'";
  		 obj.submit();
  		 return true;
	
	}
	

function validateRadio(){
			 for(var i = 0; i < document.getElementsByName('feasibiltyStudyId1').length; i++){
			  if(document.getElementsByName('feasibiltyStudyId1')[i].checked == true)
              {
				return true;
			  }		
  		}
  		alert("Please select the PI")
		return false;
		
	}
	
	function validateFieldsForFeasibilityStudy(){
	var errMsg = "";
		var piRating = document.getElementById('piRatingId').value;	
		var pistatus = document.getElementById('statusId').value;	
		if(piRating == "0"){
			errMsg += "Pi can not be blank.\n";
		}
		if(pistatus == "0"){
			errMsg += "Status can not be blank.\n";
		}
		if(errMsg != ""){
			alert(errMsg);
			return false;
		}
		
		return true;
	}
	function validateFieldsForCalldetails(){
		var errMsg = "";
		var callDate = document.getElementById('fromDateId').value;
		var comments = document.getElementById('commentsId').value;
		
		if(callDate == ""){
			errMsg += "Call Date can not be blank.\n";
		}
		if(comments == ""){
			errMsg += "comments can not be blank.\n";
		}
		if(errMsg != ""){
			alert(errMsg);
			return false;
		}
		
		return true;
}
	
	
</script>
<div class="titleBg"><h2>Feasibility Study </h2></div>


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
<label><%=protocolNo %></label>
<label>Project Type</label>
<label><%=projectType %></label>
<div class="clear"></div>
<label>Project Status </label>
<label><%=projectStatus %></label>
<label>Expected Budget </label>
<label><%=budget %>&nbsp;</label>
<label>Start Date</label>
<label><%=HMSUtil.convertDateToStringWithoutTime(StartDate) %></label>
<div class="clear"></div>
<label>End Date </label>
<label><%=HMSUtil.convertDateToStringWithoutTime(endDate )%></label>
<label>LOI Date </label>
<label><%=loiDate %>&nbsp;</label>
<label>LOI No</label>
<label><%=loino %>&nbsp;</label>
<div class="clear"></div>
<div class="clear"></div>
<label>Purchase Date </label>
<label><%=purchaseDate %>&nbsp;</label>
<label>Purchase Order No </label>
<label><%=purchaseOrderNo %>&nbsp;</label>
<label>Contract Date</label>
<label><%=conTractDate %>&nbsp;</label>
<div class="clear"></div>
<label>Contract No</label>
<label><%=contractNo %>&nbsp;</label>
<label>Theapeutic Area</label>
<label><%=therapeuticArea %>&nbsp;</label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>
<script type="text/javascript">
formFields = [
[0, "<%= FEASIBILITY_STUDY_ID%>", "id"],[1,"radioId"], [2,"<%=PI_HEADER_ID%>"], [3,"<%= DESIGNATION %>"],[4,"<%=CONTACT_PHONE%>"],
[5,"<%=MOBILE%>"],[6,"<%=RATING_ID%>"],[7,"<%=EMAIL_ID%>"],[8,"<%=STATUS%>"],[9,"piStatus"]];
statusTd =8;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<form name="feasibilityStudy" method="post" action="" >
<input type="hidden" name="<%=PROJECT_ID %>"  value="<%=projectId %>" />
<div class="clear"></div>
<label><span>*</span>Pi List-Rating </label>
<select id="piRatingId" name="<%=PI_HEADER_ID %>"   >
<option value="0">Select</option>
<%
for(MstrPiHeader mstrPiHeader :tempList){
%>
<option value="<%=mstrPiHeader.getId() %>"><%=mstrPiHeader.getPiName()%></option>
<%} %>
</select>
<label><span>*</span>Status</label>
<select id="statusId" name="piStatus"    >
<option value="0">Select</option>
<option value="confirm">Confirm</option>
<option value="pending">Pending</option>
</select>

<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="if(validateFieldsForFeasibilityStudy()){saveFeasibilityStudy();}" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="updateFeasibilityStudy();" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('projectCreation','training?method=deleteTrainingMaster&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="button" name="add" id="addbutton" value="AddSite" class="button" onClick="if(validateRadio()){saveSitedetail()};" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<div id="testDiv">
<table>
<tr>
<th>Call Date</th>
<th>Comments</th>
</tr>
<%
		if(feasibilityStudyDetailList.size()>0){		
			for(PrjFesStudyDetail prjFesStudyDetail :feasibilityStudyDetailList){
%>
<tr>
<td><%=HMSUtil.convertDateToStringWithoutTime(prjFesStudyDetail.getCallDate()) %></td>
<td><%=prjFesStudyDetail.getCallResponse() %></td>
</tr>
<%}} %>
</table>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="Block">
<label>Call Date </label>
 <input id="fromDateId" type="text"  name="<%=CALL_DATE %>" value="" class="date"  readonly="readonly" validate="Call date ,date,yes"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('fromDateId'),event)"/>
 <label>Comments </label>
<input type="text" id="commentsId"  name="<%=COMMENTS %>"   validate="Comments,string,no"   maxlength="100" />
</div>		
<input type="hidden" name="<%=STATUS %>" value="" />
			<input type="hidden" name="<%= FEASIBILITY_STUDY_ID%>" value="" />
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="if(validateRadio()){if(validateFieldsForCalldetails()){saveCalldetail()}};" accesskey="a" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<br>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
data_header = new Array();


data_header[0] = new Array;
data_header[0][0] = "Select"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "radioId";


data_header[1] = new Array;
data_header[1][0] = "PI Name"
data_header[1][1] = "data";
data_header[1][2] = "20%";
data_header[1][3] = "<%= PI_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Designation"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%= DESIGNATION %>";

data_header[3] = new Array;
data_header[3][0] = "Contact No"
data_header[3][1] = "data";
data_header[3][2] = "10%"
data_header[3][3] = "<%=CONTACT_PHONE%>";

data_header[4] = new Array;
data_header[4][0] = "Mobile"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=MOBILE%>";

data_header[5] = new Array;
data_header[5][0] = "Rating"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=RATING_ID%>";


data_header[6] = new Array;
data_header[6][0] = "Email"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=EMAIL_ID%>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS%>";

data_header[8] = new Array;
data_header[8][0] = "Pi Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "piStatus";


data_arr = new Array();

<%


Iterator itr=feasibilityHeaderList.iterator();
int  counter=0;
while(itr.hasNext())
{


	PrjFesStudyHeader prjFesStudyHeader= (PrjFesStudyHeader)itr.next();

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjFesStudyHeader.getId()%>


data_arr[<%= counter%>][1] = '<input name="feasibiltyStudyId1"  class="radioCheck"  id="rb" type="radio" value="<%=prjFesStudyHeader.getId()%>" onclick="assignTask();" />';
<%
	for(MstrPiHeader mstrPiHeader :mstrPiHeaderList){
		if(prjFesStudyHeader.getPiHeader()!= null){
			if(prjFesStudyHeader.getPiHeader().getId().equals(mstrPiHeader.getId())){
%>
data_arr[<%= counter%>][2] = "<%=mstrPiHeader.getPiName()%>";


<%}}}%>
<%
if(mstrPiHeaderList.size()>0){
	for(MstrPiHeader mstrPiHeader :mstrPiHeaderList){
		if(prjFesStudyHeader.getPiHeader()!= null){
			if(prjFesStudyHeader.getPiHeader().getId().equals(mstrPiHeader.getId())){
				if(mstrPiHeader.getDesignation() != null){
%>
data_arr[<%= counter%>][3] = "<%=mstrPiHeader.getDesignation() %>";

<%}else{
	%>
	data_arr[<%= counter%>][3] = ""
<%}
			}}else{
%>
data_arr[<%= counter%>][3] = ""
<%}}}%>
<%
	for(MstrPiHeader mstrPiHeader :mstrPiHeaderList){
		if(prjFesStudyHeader.getPiHeader()!= null){
			if(prjFesStudyHeader.getPiHeader().getId().equals(mstrPiHeader.getId())){
				if(mstrPiHeader.getPiContactNo() != null){
%>
data_arr[<%= counter%>][4] = "<%=mstrPiHeader.getPiContactNo()%>";
<%}else{
	%>
	data_arr[<%= counter%>][4] = ""
<%}
			}}else{
%>
data_arr[<%= counter%>][4] = ""
<%}}%>
<%
	for(MstrPiHeader mstrPiHeader :mstrPiHeaderList){
		if(prjFesStudyHeader.getPiHeader()!= null){
			if(prjFesStudyHeader.getPiHeader().getId().equals(mstrPiHeader.getId())){
				if(mstrPiHeader.getPiMobileNo()  != null){
%>
data_arr[<%= counter%>][5] = "<%=mstrPiHeader.getPiMobileNo() %>"
<%}else{
	%>
	data_arr[<%= counter%>][5] = ""
<%}
			}}else{
%>
data_arr[<%= counter%>][5] = ""
<%}}%>
<%
for(MstrPiHeader mstrPiHeader :mstrPiHeaderList){
		if(prjFesStudyHeader.getPiHeader()!= null){
			if(prjFesStudyHeader.getPiHeader().getId().equals(mstrPiHeader.getId())){
				if(mstrPiHeader.getRating() != null){
%>
data_arr[<%= counter%>][6] = "<%=mstrPiHeader.getRating().getRatingName() %>"

<%}else{%>
data_arr[<%= counter%>][6] = ""
<%}
	}}}
%>

<%
for(MstrPiHeader mstrPiHeader :mstrPiHeaderList){
		if(prjFesStudyHeader.getPiHeader()!= null){
			if(prjFesStudyHeader.getPiHeader().getId().equals(mstrPiHeader.getId())){
				if(mstrPiHeader.getRating() != null){
%>
data_arr[<%= counter%>][7] = "<%=mstrPiHeader.getPiEmailId()%>"
<%}else{
	%>
	data_arr[<%= counter%>][7] = ""
<%
}}}else{
%>
data_arr[<%= counter%>][7] = ""
<%}}%>

<% 
if(prjFesStudyHeader.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>

<%if(prjFesStudyHeader.getPiStatus()!= null){ %>
data_arr[<%= counter%>][9] = "<%=prjFesStudyHeader.getPiStatus()%>"
<%}else{%>
data_arr[<%= counter%>][9] = ""
<%}%>
<%

counter++;
}
%>


formName = "feasibilityStudy"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	

