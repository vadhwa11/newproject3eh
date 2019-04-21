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
List<BloodTransfussionReactionHd> transfusionList = new ArrayList<BloodTransfussionReactionHd>();

List<BloodReactionEntryDetails> transfusionFeedbackList = new ArrayList<BloodReactionEntryDetails>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

if(map.get("transfusionList") != null){
	transfusionList=(List<BloodTransfussionReactionHd>)map.get("transfusionList");
}

if(map.get("transfusionFeedbackList") != null){
	transfusionFeedbackList=(List<BloodReactionEntryDetails>)map.get("transfusionFeedbackList");
}

%>
<body>
<form name="transfusionFeedback" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2>Pending For TransFussion Feedback</h2>
</div>
<div class="clear"></div>

<%if(null !=transfusionFeedbackList && transfusionFeedbackList.size()>0){ %>
	 <table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
		
		<th>UHID</th>
		<th>Name</th>
		<th>Age</th>
		<th>Feedback</th>	
			
		</tr>BloodReactionEntryDetails
		</thead>
		<%for(BloodReactionEntryDetails bTRD:transfusionFeedbackList){ %>
		<tr onclick="submitForm('transfusionFeedback','/hms/hms/bloodBank?method=showtransfussionDetails&bldReactionEntryDetaiId=<%=bTRD.getId()%>')"
			style="cursor: pointer;">
		
		<td><%=bTRD.getEntryHeader().getHin().getHinNo() %></td>
		<td><%=bTRD.getEntryHeader().getHin().getFullName() %></td>
		<td><%=bTRD.getEntryHeader().getHin().getAge() %></td>
		<td><%=bTRD.getEntryHeader().getRemarks() %></td>
		
		</tr>
		<%}%>
	
	</table>
	<%}else{ %>
<h4>No record found</h4>
<%} %>
	
	<div class="clear"></div>
</div>
<div class="clear"></div>
    
    </form>
</body>
</html>