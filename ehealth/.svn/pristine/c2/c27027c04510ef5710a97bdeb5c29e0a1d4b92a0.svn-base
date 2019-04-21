<%@page import="jkt.hms.masters.business.BloodReactionEntryDetails"%>
<%@page import="jkt.hms.masters.business.BloodTransfussionReactionHd"%>
<%@page import="jkt.hms.masters.business.BloodTransfussionReactionDt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@page import="jkt.hms.masters.business.BloodReactionEntry"%>


<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<% 
Map<String,Object> map = new HashMap<String,Object>(); 

if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}


List<BloodReactionEntryDetails> transfusionFeedbackList = new ArrayList<BloodReactionEntryDetails>();
if(map.get("transfusionFeedbackList") != null){
	transfusionFeedbackList=(List<BloodReactionEntryDetails>)map.get("transfusionFeedbackList");
	System.out.print(transfusionFeedbackList.size());
}
%>
<body>
<div class="block">
<form name="transfusionFeedbackD" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2> TransFussion Feedback</h2>
</div>
<div class="clear"></div>

<%if(null !=transfusionFeedbackList && transfusionFeedbackList.size()>0){ %>
	 <table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
		
		<th>Reaction Name</th>
			
		</tr>
		</thead>
		<%for(BloodReactionEntryDetails bTRD:transfusionFeedbackList){ %>
		
		<td><%=bTRD.getBloodReactionName() %></td>
		</tr>
		<%}%>
	
	</table>
	<%}else{ %>
<h4>No record found</h4>
<%} if(null !=transfusionFeedbackList && transfusionFeedbackList.size()>0){
	for(BloodReactionEntryDetails bTRD:transfusionFeedbackList){%>
	<label> Blood Bag No. </label><input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getBloodBagNo()%>"/>
	<label> Issued Hospital Name </label><input type="text" readonly="readonly" value="<%=bTRD.getHospital().getHospitalName()%>"/>
	<div class="clear"></div>
	<h4>Before Transfusion</h4>
	<label> Temperature  </label><input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getTemperature()%>"/>
	<label> Pulse  </label><input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getPulse()%>"/>
	<div class="clear"></div>
	<label> BP  </label><input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getBpMin()%>"/>
	<input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getBpMax()%>"/>
	
	<div class="clear"></div>
	
	<h4>During Transfusion</h4>
	<label> Temperature  </label>
	<input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getTempDuringTransfusion()%>"/>
	
	<label> Pulse  </label><input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getPulseDuringTransfusion()%>"/>
	
	<div class="clear"></div>
	<label> BP  </label>
	<input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getBpMinDuringTransfusion()%>"/>
	
	<input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getBpMaxDuringTransfusion()%>"/>
	
	
	
	
	<div class="clear"></div>
	<h4>After Transfusion</h4>
	<label> Temperature  </label>
	<input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getTempAfterTransfusion()%>"/>
	<label> Pulse  </label><input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getPulseAfterTransfusion()%>"/>
	<div class="clear"></div>
	<label> BP  </label>
	<input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getBpMinAfterTransfusion()%>"/>
	<input type="text" readonly="readonly" value="<%=bTRD.getEntryHeader().getBpMaxAfterTransfusion()%>"/>
	
	<div class="clear"></div>
	<h4>Other Signs and symptoms</h4>
	<label> (a) Chills </label><label> <%=((bTRD.getEntryHeader().getChills()).equalsIgnoreCase("y"))?"yes":"No" %> </label>
	<label> (b) Rigor  </label><label> <%=((bTRD.getEntryHeader().getRigor()).equalsIgnoreCase("y"))?"yes":"No" %> </label>
	<label> (c) Rash/Itching  </label><label><%=((bTRD.getEntryHeader().getRashItching()).equalsIgnoreCase("y"))?"yes":"No" %> </label>
	<label> (d) Pain:- Back </label><label><%=((bTRD.getEntryHeader().getPainBack()).equalsIgnoreCase("y"))?"yes":"No" %> </label>
	<label>Head  </label><label><%=((bTRD.getEntryHeader().getPainHead()).equalsIgnoreCase("y"))?"yes":"No" %> </label>
	<label> Chest  </label><label><%=((bTRD.getEntryHeader().getPainChest()).equalsIgnoreCase("y"))?"yes":"No" %> </label>
	<label> Elsewhere  </label><label><%=((bTRD.getEntryHeader().getPainChest()).equalsIgnoreCase("y"))?"yes":"No" %> </label>
	<label> (e) Haemoglobinuana  </label><label><%=((bTRD.getEntryHeader().getHaemoglobinuana()).equalsIgnoreCase("y"))?"yes":"No" %> </label>
	<label> (f) Pulmonary oedema  </label><label><%=((bTRD.getEntryHeader().getPulmonaryOedema()).equalsIgnoreCase("y"))?"yes":"No" %> </label>
	<label> (g) Jaundice  </label><label><%=((bTRD.getEntryHeader().getJaundice()).equalsIgnoreCase("y"))?"yes":"No" %> </label>
	<label> (h) Any Other signs</label><label><%=((bTRD.getEntryHeader().getAnyOtherSigns()).equalsIgnoreCase("y"))?"yes":"No" %> </label>
	
	
<%}}%>
	
	<div class="clear"></div>

<div class="clear"></div>


<input type="button" name="no" value="Back" 
class="button" onclick="submitForm('transfusionFeedbackD','/hms/hms/bloodBank?method=showTransfussionFeedback','checkTargetForNo');" />


    
    </form>
    </div>
</body>
</html>