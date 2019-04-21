<%--
 * Copyright 2009 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hr_site_miles_stone.jsp  
 * Purpose of the JSP -  This is for Site Other vitals.
 * @author  Vishal
 * Create Date: 18th August,2009 
 * Revision Date:      
 * Revision By: 
 * @version 1.1 
--%>

<%@ page import="static jkt.hrms.util.HrmsRequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hrms.masters.business.MstrProject"%>
<%@page import="jkt.hrms.masters.business.MstrSiteHeader"%>
<%@page import="jkt.hrms.masters.business.PrjFesStudyHeader"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hrms.masters.business.MstrPtvisit"%>
<%@page import="jkt.hrms.masters.business.PrjSiteMilestone"%>

<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<MstrProject> projectList = new ArrayList<MstrProject>();
				List<PrjFesStudyHeader> fesStudyHeaderList  = new ArrayList<PrjFesStudyHeader>();
				List<MstrPtvisit> patientVisitList = new ArrayList<MstrPtvisit>();
				List<PrjSiteMilestone> prjSiteMilestoneList = new ArrayList<PrjSiteMilestone>();
				List<UserButtonRights> userRightsList= new ArrayList<UserButtonRights>();
				
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("projectList")!= null){
					projectList = (List)map.get("projectList");
				}
				if(map.get("fesStudyHeaderList")!= null){
					fesStudyHeaderList = (List)map.get("fesStudyHeaderList");
				}
				if(map.get("prjSiteMilestoneList")!= null){
					prjSiteMilestoneList = (List)map.get("prjSiteMilestoneList");
				}
				if(map.get("patientVisitList")!= null){
					patientVisitList = (List)map.get("patientVisitList");
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
				String projectName   = "";
				String projectCode   = "";
				String trialPhase    = "";
				String protocolNo    = "";
				String projectType   = "";
				String projectStatus = "";
				String siteName      = "";
				int projectId 		 = 0 ;
				int siteId    		 = 0 ;
				String siteCode = "";
				String piName = "";
				String siteInitiateDate = "";
				
				if(projectList.size()>0){
					for (MstrProject mstrProject :projectList){
						projectName= mstrProject.getPrjName();
						projectCode = mstrProject.getPrjCode();
						trialPhase = mstrProject.getTrialPhase().getTrialPhaseName();
						if(mstrProject.getPrjProtocalno()!= null){
						protocolNo = mstrProject.getPrjProtocalno();
						}
						projectType = mstrProject.getProjectType().getProjectName();
						projectStatus = mstrProject.getProjectStatus().getPrjsName();
						projectId = mstrProject.getId();
					}
				}
				if(fesStudyHeaderList.size()>0){
					for (PrjFesStudyHeader prjFesStudyHeader :fesStudyHeaderList){
						siteName= prjFesStudyHeader.getSiteHeader().getSiteName();
						siteId = prjFesStudyHeader.getSiteHeader().getId();
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
<%@page import="jkt.hms.masters.business.UserButtonRights"%>
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
  		 obj.action = "projectTracking?method=showProjectSitesList";
  		 obj.submit();
  		 return true;
	
	}
	 function nextProjectSetting()
 {
   var id = <%=projectId%>
   obj = eval('document.'+formName)
     obj.action = "projectTracking?method=showSiteOtherVitalsJsp&projectId="+id;
     obj.submit();
     return true;
 
 }
	
	
</script>
<div class="titleBg"><h2>Site Miles Stone </h2></div>


<div class="clear"></div>

<div class="Block">
<label>Project Name</label>
<label ><%=projectName %></label>
<label>Project Code</label>
<label><%=projectCode %></label>
<label>Trial Phase </label>
<label><%=trialPhase %></label>
<div class="clear"></div>
<label>Protocol No </label>
<label><%=protocolNo %></label>
<label>Project Type</label>
<label><%=projectType %></label>
<label>Project Status </label>
<label><%=projectStatus %>&nbsp;</label>
<div class="clear"></div>
<label>Site Name</label>
<label><%=siteName %>&nbsp;</label>
<label>Site Code</label>
<label><%=siteCode %></label>
<label>Pi Name</label>
<label><%=piName %></label>
<div class="clear"></div>
<label>Site Initiate Date</label>
<label><%=siteInitiateDate %></label>
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
[0, "<%= SITE_MILES_STONE_ID%>", "id"], [1,"<%=SITE_HEADER_ID%>"], [2,"<%= PROJECT_ID %>"],[3,"<%=PATIENT_VISIT_ID%>"],[4,"<%=SITE_MILES_STONE_AMOUNT%>"],[5,"<%=SITE_MILES_STONE_PERCENTAGE%>"],[6,"<%=SITE_TOTAL_AMOUNT_PER_PATIENT%>"],[7,"<%=SITE_CUT_OF_DATE%>"],[8,"<%= CHANGED_BY%>"], [9,"<%= CHANGED_DATE %>"],[10,"<%= CHANGED_TIME %>"],[11,"<%=STATUS%>"]];
statusTd =11;
</script>
</div>

<form name="siteMilesStone" method="post" action="" >
<input type="hidden" name="<%=PROJECT_ID %>"  value="<%=projectId %>" />
<input type="hidden" name="<%=SITE_ID %>"  value="<%=siteId %>" />
<div class="Block">
<div class="clear"></div>
<label><span>*</span>Visit </label>
<select  name="<%=PATIENT_VISIT_ID %>" validate="Patient Visit,string,yes"  >
<option value="0">Select</option>
<%
	for(MstrPtvisit mstrPtvisit :patientVisitList){
%>
<option value="<%=mstrPtvisit.getId() %>"><%=mstrPtvisit.getPatientVisitName() %></option>
<%} %>
</select>
<label><span>*</span>Payment </label>
<input type="text" id="totalAmountId"   name="<%=SITE_MILES_STONE_AMOUNT %>"  onblur="calculateAmount()" validate="Payment per Patient,float,yes"   maxlength="11" />
<label><span>*</span>Payment(%) </label>
<input type="text" id="paymentPercentageId"  name="<%=SITE_MILES_STONE_PERCENTAGE %>" onblur="calculateAmount()"  validate="Payment(%),float,yes"   maxlength="3" />
<div class="clear"></div>
<label><span>*</span>Amount (amt per Patient) </label>
<input type="text" id="amountId"  name="<%=SITE_TOTAL_AMOUNT_PER_PATIENT %>"   validate="Amount,float,yes"   maxlength="9" />

<label>Cut Off Date </label>
<input id="cutOffDateId" type="text"  name="<%=SITE_CUT_OF_DATE %>" value="" class="date"  readonly="readonly" validate="Cut Off date ,date,no"  MAXLENGTH="30" />
 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onclick="setdate('',document.getElementById('cutOffDateId'),event)"/>

<div class="clear"></div>
</div>

<div class="clear"></div>

<div id="edited"></div>
		<%for(UserButtonRights userButtonRights : userRightsList){
				if(userButtonRights.getButton().getFormName().equalsIgnoreCase("MileStone")) {
					if(userButtonRights.getButton().getButtonName().equalsIgnoreCase("Add")){ %>
						<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('siteMilesStone','projectTracking?method=addSiteMilesStone');" accesskey="a" tabindex=1 />
				  <%} else if(userButtonRights.getButton().getButtonName().equalsIgnoreCase("Update")){%>
						<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('siteMilesStone','projectTracking?method=editSiteMilesStone')" accesskey="u" tabindex=1 />
				  <%} %>
		<%}}%>

<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" style="display: none;" onClick="submitForm('siteMilesStone','projectTracking?method=deleteSiteMilesStone&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="button" name="back" id="addbutton" value="Back" class="button" onClick="backProjectSetting();" accesskey="a" tabindex=1 />
<input type="button" name="next" id="next" value="Next" class="button" onClick="nextProjectSetting();" accesskey="n" tabindex=1 />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<div class="clear"></div>
<label>Last Changed By</label>
<label class="value"><%=userName%></label>
<label>Last Changed DATE</label>
<label class="value"><%=date%></label>

<label>Last Changed Time</label>
<label class="value"><%=time%></label>
</div>
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" /> 
			<input type="hidden" name="<%=STATUS %>" value="" />	 
			<input type="hidden" name="<%= SITE_MILES_STONE_ID%>" value="" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = ""
data_header[0][1] = "hide";
data_header[0][2] = "0";
data_header[0][3] = "<%= SITE_HEADER_ID %>";

data_header[1] = new Array;
data_header[1][0] = ""
data_header[1][1] = "hide";
data_header[1][2] = "0";
data_header[1][3] = "<%= PROJECT_ID %>";

data_header[2] = new Array;
data_header[2][0] = "Patient Visit"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=PATIENT_VISIT_ID%>";

data_header[3] = new Array;
data_header[3][0] = "Site Amount"
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=SITE_MILES_STONE_AMOUNT%>";

data_header[4] = new Array;
data_header[4][0] = "Percentage"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=SITE_MILES_STONE_PERCENTAGE%>";

data_header[5] = new Array;
data_header[5][0] = "Amount Per Patient"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=SITE_TOTAL_AMOUNT_PER_PATIENT%>";

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=SITE_CUT_OF_DATE%>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "10%";
data_header[7][3] = "<%= CHANGED_BY%>";

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%= CHANGED_DATE %>";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "<%= CHANGED_TIME %>";

data_header[10] = new Array;
data_header[10][0] = ""
data_header[10][1] = "hide";
data_header[10][2] = "15%";
data_header[10][3] = "<%=STATUS%>";


data_arr = new Array();

<%


Iterator itr=prjSiteMilestoneList.iterator();
int  counter=0;
while(itr.hasNext())
{


	PrjSiteMilestone prjSiteMilestone= (PrjSiteMilestone)itr.next();


%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= prjSiteMilestone.getId()%>

<% if(prjSiteMilestone.getSiteHeader().getSiteName() != null){
	StringBuffer output_str = new StringBuffer();
	StringTokenizer s = new StringTokenizer(prjSiteMilestone.getSiteHeader().getSiteName().toString(),"\""); 
	
	while (s.hasMoreTokens())
	{
		output_str.append(s.nextToken());
		if (s.hasMoreTokens())
		{
		output_str.append("\\");
 	        output_str.append("\"");
		}
	}
	StringBuffer output_str1= new StringBuffer();;
StringTokenizer s1 = new StringTokenizer(output_str.toString(),"\'"); 
	
	while (s1.hasMoreTokens())
	{
		output_str1.append(s1.nextToken());
		if (s1.hasMoreTokens())
		{
		output_str1.append("\\");
 	        output_str1.append(" ");
		}
	}
%>
data_arr[<%= counter%>][1] = "<%= output_str1.toString()%>";
<%}%>
<%
	if(projectList.size()>0){
		for(MstrProject mstrProject:projectList){
			if(prjSiteMilestone.getPrj()!= null){
		if(mstrProject.getId().equals(prjSiteMilestone.getPrj().getId())){
%>
data_arr[<%= counter%>][2] = "<%=mstrProject.getPrjName()%>"
<%
		}
			}
		}
	}
		
%>
<%
	if(patientVisitList.size()>0){
		for(MstrPtvisit mstrPtvisit :patientVisitList){
			if(prjSiteMilestone.getPatientVisit()!= null){
		if(mstrPtvisit.getId().equals(prjSiteMilestone.getPatientVisit().getId())){
%>
data_arr[<%= counter%>][3] = "<%=mstrPtvisit.getPatientVisitName()%>";
<%
		}
			}
		}
	}
		
%>
<%if(prjSiteMilestone.getMilesStoneAmount() != null){%>
data_arr[<%= counter%>][4] = "<%=prjSiteMilestone.getMilesStoneAmount() %>";
<%
	}else{
%>
data_arr[<%= counter%>][4] = ""
<%
	}
%>

<%if(prjSiteMilestone.getMilesStonePercentage() != null){%>
data_arr[<%= counter%>][5] = "<%=prjSiteMilestone.getMilesStonePercentage()%>";
<%
	}else{
%>
data_arr[<%= counter%>][5] = ""
<%
	}
%>
<%if(prjSiteMilestone.getTotalAmountPerPatient() != null){%>
data_arr[<%= counter%>][6] = "<%= prjSiteMilestone.getTotalAmountPerPatient() %>"
<%
	}else{
%>
data_arr[<%= counter%>][6] = ""
<%
	}
%>
<%if(prjSiteMilestone.getCutOfDate() != null){%>
data_arr[<%= counter%>][7] = "<%=HMSUtil.convertDateToStringWithoutTime(prjSiteMilestone.getCutOfDate()) %>"
<%
	}else{
%>
data_arr[<%= counter%>][7] = ""
<%
	}
%>
data_arr[<%= counter%>][8] = "<%= prjSiteMilestone.getLastChgBy() %>"
data_arr[<%= counter%>][9] = "<%= HMSUtil.convertDateToStringWithoutTime(prjSiteMilestone.getLastChgDate()) %>"
data_arr[<%= counter%>][10] = "<%= prjSiteMilestone.getLastChgTime() %>"





<% 
if(prjSiteMilestone.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
<%}%>

<%

counter++;
}
%>


formName = "siteMilesStone"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');	
	

</script>	

