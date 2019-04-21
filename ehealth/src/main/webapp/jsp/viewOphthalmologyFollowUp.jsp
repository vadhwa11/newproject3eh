<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdOphFollowUp"%>


<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>
<script type="text/javascript">
animatedcollapse.addDiv('title1', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title2', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('title3', 'fade=0,speed=400,group=pets,hide=1,persist=0,hide=0')
animatedcollapse.addDiv('title4', 'fade=0,speed=400,group=pets,hide=0')
animatedcollapse.addDiv('title5', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title6', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title7', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title8', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.addDiv('title9', 'fade=0,speed=400,group=pets,persist=0,hide=0')
animatedcollapse.init()
</script>
<!--main content placeholder starts here-->
<form name="viewOphthalmologyFollowUp" method="post" action="">
<div class="titleBg">
<h2>Ophthalmology Follow Up</h2>
</div>
<div class="clear"></div>
<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		
		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdOphFollowUp> ophFollowUpList = new ArrayList<OpdOphFollowUp>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}		
		
		if(detailsMap.get("patientDataList") != null){
			patientDataList=(List<Visit>)detailsMap.get("patientDataList");
		}	
		if(map.get("ophFollowUpList") != null){
			ophFollowUpList=(List<OpdOphFollowUp>)map.get("ophFollowUpList");
		}	
		int visitId = 0;
		int currentVisitId = 0;
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}
		if(map.get("currentVisitId") != null){
			currentVisitId = (Integer)map.get("currentVisitId");
		}
%> <%
if(ophFollowUpList.size() > 0){
	
	OpdOphFollowUp ophFollowUp = new OpdOphFollowUp();
	ophFollowUp = ophFollowUpList.get(0);
	
	Visit visit = new Visit();
	if(patientDataList.size() > 0){
		visit = patientDataList.get(0);
	}

	String patientName="";
	if(visit.getHin().getPFirstName()!= null){
		patientName=visit.getHin().getPFirstName();
	}
	if(visit.getHin().getPMiddleName()!= null){
		patientName=patientName+" "+visit.getHin().getPMiddleName();
	}
	if(visit.getHin().getPLastName()!= null){
		patientName=patientName+" "+visit.getHin().getPLastName();
	}
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	
%> <!--Block One Starts-->

<div class="clear"></div>

<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><label class="medium">HIN</label> <%
if(visit.getHin().getHinNo()!= null)
{
	%> <label class="valueMedium"><%=visit.getHin().getHinNo() %></label> <%
}
else
{
	%> <label class="valueMedium">-</label> <%
} 
%> <label>Patient Name </label> <%
 if(patientName!= null)
 {
	 %> <label class="value"><%=patientName %> </label> <%
}
 else
 { 
 %> <label class="value">- </label> <%
} 
%> <label class="medium">Age</label> <%
if(visit.getHin().getAge()!= null)
{
	%> <label class="valueMedium"><%=visit.getHin().getAge() %></label> <%
}
else
{
	%> <label class="valueMedium">-</label> <%
}
%> <label class="medium">Visit Date </label> <%
if(visitDateInString != null)
{
	%> <label class="valueMedium"><%=visitDateInString %></label> <%
}
else
{ 
%> <label class="valueMedium">-</label> <%} %>
<div class="clear"></div>
<label class="medium">Visit No. </label> <%
if(visit.getVisitNo()!= null)
{
	%> <label class="valueMedium"><%=visit.getVisitNo() %></label> <%
}
else
{ 
%> <label class="valueMedium">-</label> <%
}
%> <label>Token No. </label> <%
if(visit.getTokenNo()!= null)
{ 
%> <label class="value"><%=visit.getTokenNo() %></label> <%
}
else
{ 
%> <label>-</label> <%
} 
%> <label class="medium">Prev. Diag </label> <%
if(visit.getDiagnosis()!= null)
{
	%> <label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%
}
%>
<div class="clear"></div>
</div>
<!--Block one Ends-->
<div class="clear"></div>
<div class="division"></div>
<!--Block Three Starts-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>System Functional Assesment</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title1">
<div class="clear"></div>
<h4>Vision</h4>
<div class="clear"></div>
<label>Ant Segment</label> 
<label class="valueNoWidth">RE</label>
 <%
	if(ophFollowUp.getAntSegmentRe() != null){
%> 
<input name="<%=ANT_SEGMENT_RE %>" type="text" class="readOnly"	value="<%= ophFollowUp.getAntSegmentRe()%>" maxlength="20" readonly="readonly"> <%
}
	else
	{ 
	%> 
<input name="<%=ANT_SEGMENT_RE %>" type="text" class="readOnly"	value="" maxlength="20" readonly="readonly"> 
<%
} 
%> 
<label class="valueNoWidth">LE</label> <%  
if(ophFollowUp.getAntSegmentLe() != null){
%> 
<input name="<%=ANT_SEGMENT_LE%>" type="text" class="readOnly" value="<%=ophFollowUp.getAntSegmentLe() %>" size="10" maxlength="20"	readonly="readonly">
 <%
}
else
{ 
%> <input name="<%=ANT_SEGMENT_LE%>" type="text" class="readOnly"
	value="" size="10" maxlength="20" readonly="readonly"> <%
} 
%>
<div class="clear"></div>
<label>IOP</label> 
<label class="valueNoWidth">&nbsp;&nbsp;&nbsp;&nbsp;</label>
<%
	if(ophFollowUp.getIop() != null){
%> 
<input name="<%=IOP%>" type="text" class="readOnly"	value="<%=ophFollowUp.getIop() %>" size="10" maxlength="20"readonly="readonly"> <%
}
	else
	{ 
	%> 
<input name="<%=IOP%>" type="text" class="readOnly" value="" size="10" maxlength="20" readonly="readonly"> 
<%
} 
%>
<div class="clear"></div>
<h4>Fundus</h4>
<div class="clear"></div>
<label>RE</label> 
<input name="<%=FUNDUS_RE %>" type="text" value="" size="10" maxlength="20"> 
<%
if(ophFollowUp.getFundusRe() != null){
%> 
<input name="<%=FUNDUS_RE %>" type="text" class="readOnly"	value="<%=ophFollowUp.getFundusRe() %>" size="10" maxlength="20" readonly="readonly"> 
<%
}
	else
	{ 
%> 
<input name="<%=FUNDUS_RE %>" type="text" class="readOnly" value="" size="10" maxlength="20" readonly="readonly"> <%
} 
%> 
<label class="noWidth">LE</label> <%	if(ophFollowUp.getFundusLe() != null)
{
%> 
<input name="<%=FUNDUS_LE%>" type="text" class="readOnly" value="<%=ophFollowUp.getFundusLe() %>" size="10" maxlength="20" readonly="readonly"> 
<%
}
else
{
	%> 
<input name="<%=FUNDUS_LE%>" type="text" class="readOnly" value="" size="10" maxlength="20" readonly="readonly"> 
<%
}
%> 
<label class="noWidth">Adv</label> 
<%	
if(ophFollowUp.getAdv() != null){
%> 
<input name="<%=ADV%>" type="text" class="readOnly"	value="<%=ophFollowUp.getAdv() %>" size="10" maxlength="20" readonly="readonly"> < % } else { %> 
<input name="<%=ADV%>"	type="text" class="readOnly" value="" size="10" maxlength="20" readonly="readonly"> 
<%
 } 
 %>
</div>
<div class="clear"></div>
<div class="division"></div>
<!--Bottom labels starts--> 
<input name="prev" type="button" class="button" value="Prev" onclick="submitForm('viewOphthalmologyFollowUp','opd?method=viewOphthalmologyFollowUp&flag=prev');">
<input name="next" type="button" class="button" value="Next" onclick="submitForm('viewOphthalmologyFollowUp','opd?method=viewOphthalmologyFollowUp&flag=next');">
<input name="back" type="button" class="button" value="Back" onclick="submitForm('viewOphthalmologyFollowUp','opd?method=showOphthalmologyFollowUpJsp&visitId=<%=currentVisitId %>');">
<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>"> 
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visitId %>"> 
<input	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>">
<input type="hidden" name="currentVisitId" value="<%=currentVisitId %>"> <!--Bottom labels ends-->
<%}else{%> No Record Found!! <!--Bottom labels starts-->
<div class="bottom">
<input name="back" type="button" class="button" value="Back" onclick="submitForm('viewOphthalmologyFollowUp','opd?method=showOphthalmologyFollowUpJsp&visitId=<%=currentVisitId %>');">
<!--Bottom labels ends--> <%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
<!--main content placeholder ends here-->
<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>