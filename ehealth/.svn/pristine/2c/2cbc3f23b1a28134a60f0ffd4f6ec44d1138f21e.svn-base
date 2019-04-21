<%@page import="jkt.hms.masters.business.ImmunizationCardDetail"%>
<%@page import="jkt.hms.masters.business.ImmunizationCardMaster"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
</script>
<script	type="text/javascript" language="javascript">
<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		String time=String.valueOf(calendar.getTime());
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}

%>
	serverdate = '<%=date+"/"+month+"/"+year%>'
</script>
<script type="text/javascript">
	ddaccordion.init({
		headerclass: "expandable", //Shared CSS class name of headers group that are expandable
		contentclass: "categoryitems", //Shared CSS class name of contents group
		revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click" or "mouseover
		collapseprev: true, //Collapse previous content (so only one open at any time)? true/false
		defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
		onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
		animatedefault: false, //Should contents open by default be animated into view?
		persiststate: true, //persist state of opened contents within browser session?
		toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
		togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
		animatespeed: "normal", //speed of animation: "fast", "normal", or "slow"
		oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
			//do nothing
		},
		onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
			//do nothing
		}
	})
</script>
<script type="text/javascript">
	function showBackJSP(formName)
	{
  		obj = eval('document.'+formName)
  		obj.action = "/hms/hms/opd?method=showWaitingPatientListJsp";
 		obj.submit();
	}

	function ismaxlength(obj){
		var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
		if (obj.getAttribute && obj.value.length>mlength)
		obj.value=obj.value.substring(0,mlength)
	}

</script>
<%
		URL myURL=application.getResource("/WEB-INF/commonFile.properties");
		InputStream in = myURL.openStream();
		Properties prop = new Properties();
		prop.load(in);

		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");

		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentdate = (String)utilMap.get("currentDate");
		String currenttime = (String)utilMap.get("currentTime");

		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
			}

		 List patientDataList = new ArrayList();

	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}


	Visit visit=(Visit)patientDataList.get(0);
	int hinId=visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();


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


	 List<ImmunizationCardMaster> immunizationCardList = new ArrayList<ImmunizationCardMaster>();
	 if(map.get("immunizationCardList") != null){
		 immunizationCardList = (List<ImmunizationCardMaster>) map.get("immunizationCardList");
		}
	 List<ImmunizationCardDetail> cardDetailsList =new ArrayList<ImmunizationCardDetail>();
	 if(map.get("cardDetailsList") != null)
	 {
		 cardDetailsList =(List<ImmunizationCardDetail>) map.get("cardDetailsList");
	 }

%>
<!--main content placeholder starts here-->


<form name="immunizationCard" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=visit.getDepartment().getId() %>" />
<%
if(visit.getDepartment()!= null){ %>
<div class="titleBg">
<h2>Immunization Card</h2>
</div>
<div class="clear"></div>
<%} %>
<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<%
if(visit.getHin().getHinNo()!= null)
{
%>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label>
<%
}
else
{
%>
<label class="valueMedium">-</label>
<%
}
%>
<label>Patient Name </label>
<%
if(patientName!= null)
{
%>
<label class="value"><%=patientName %> </label>
<%
}
else
{
%>
<label	class="value">- </label>
	<%
	}
	%>
<label class="medium">Age</label>
<%
if(visit.getHin().getAge()!= null)
{
%>
<label class="valueMedium"><%=visit.getHin().getAge() %></label>
 <%
 }
else
{
	%>
<label class="valueMedium">-</label>
<%
}
%>
<label class="medium">Visit Date </label>
<%
if(visitDateInString != null){ %>
<label class="valueMedium"><%=visitDateInString %></label>
<%
}
else
{
%>
 <label class="valueMedium">-</label>
 <%} %>
<div class="clear"></div>
<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no") %></label>
<%
if(visit.getVisitNo()!= null){
%>
<label class="valueMedium"><%=visit.getVisitNo() %>
</label>
<%
}
else
{
%>
<label	class="valueMedium">-</label>
<%
}
%>
<label>Token No. </label>
<%
if(visit.getTokenNo()!= null)
{
%>
<label class="value"><%=visit.getTokenNo() %></label>
<%}else{ %>
<label>-</label>
<%}
%>
<label class="medium">Prev. Diag </label>
<%
if(visit.getDiagnosis()!= null)
{
%>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
</div>
<b>Birth Date :<%=HMSUtil.convertDateToStringTypeDateOnly(patient.getDateOfBirth())%></b>
<input type="hidden" name="birthdate" id="birthdate" value="<%=HMSUtil.convertDateToStringTypeDateOnly(patient.getDateOfBirth())%>" />
<input type="hidden" name="listLength" id="listLength" value="<%=immunizationCardList.size()%>" />
<table>
	<tr>
		<th>Sr.No.</th>
		<th>Details</th>
		<th>Duration </th>
	 	<th>Due Date</th>
		<th>Given Date</th>

	</tr>
	<%
	int masIcmId =0;
	int detIcmId=0;

	int counter =0;
	ImmunizationCardMaster cardMaster = new ImmunizationCardMaster();
	for(int i=0;i<immunizationCardList.size();i++)
	{
		cardMaster =(ImmunizationCardMaster)immunizationCardList.get(i);

	%>
	<tr>
	<td><%=cardMaster.getIcmId()%>
	<input type="hidden" name="sno<%=cardMaster.getIcmId()%>" id="sno<%=cardMaster.getIcmId()%>" value="<%=cardMaster.getIcmId()%>" /></td>
	<td><%=cardMaster.getDetailsName()%></td>
	<td><%=cardMaster.getDuration()%></td>
	<td><%=HMSUtil.convertDateToStringTypeDateOnly(cardMaster.getDueDate())%></td>

<%
	if(cardDetailsList.size()>0)
	{
		boolean flag = false;
		String givenDate="";
	 		//for(int j=0;j<cardDetailsList.size();j++)
	 			for(ImmunizationCardDetail immunizationCardDetail:cardDetailsList)
	  		{
	 			detIcmId = immunizationCardDetail.getIcmId().getIcmId();
	 			if(detIcmId == cardMaster.getIcmId())
				   {
	 				if(immunizationCardDetail.getGivendate()!=null){
		 				givenDate=HMSUtil.convertDateToStringTypeDate(immunizationCardDetail.getGivendate());
	 				}
					   flag = true;
						break;
				   }
	  		}
	 		if(flag){
	 			%>
				<td><input type="text" name="givendate<%=cardMaster.getIcmId()%>" id="givendate<%=cardMaster.getIcmId()%>"  value="<%=givenDate%>"/><img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date"
				onclick="setdate('<%=currentdate%>',document.immunizationCard.givendate<%=cardMaster.getIcmId()%>,event);" />
				</td>
<%
		   }else{
			   %>
				<td>
				<input type="text" name="givendate<%=cardMaster.getIcmId()%>" id="givendate<%=cardMaster.getIcmId()%>"  value=""/><img
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date"
				onclick="setdate('<%=currentdate%>',document.immunizationCard.givendate<%=cardMaster.getIcmId()%>,event);" />
				</td>
			<%
	 		}
	}else{
	%>
	<td>
	<input type="text" name="givendate<%=cardMaster.getIcmId()%>" id="givendate<%=cardMaster.getIcmId()%>"  value=""/><img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onclick="setdate('<%=currentdate%>',document.immunizationCard.givendate<%=cardMaster.getIcmId()%>,event);" />
	</td>
<%
}
	}
%>
</tr>
</table>
<div class="division"></div>
<input type="button" class="button" value="Submit"	onclick="submitForm('immunizationCard','opd?method=addImmunizationCard','validateDateOnSubmit');"	align="right" />
<input	name="Back" type="button" src="images/phaseII/delete.gif" alt="Back"	value="Back" class="button" onclick="history.go(-1);return false;"	align="right" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom"><label>Changed By</label> <label class="value"><%=userName %></label>
<label>Changed Date</label> <label class="value"><%=date%></label> <label>Changed
Time</label> <label class="value"><%=time%></label></div>
<div class="division"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId()%>"> 
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input	type="hidden" name="<%=VISIT_NUMBER %>"	value="<%=visit.getVisitNo() %>">
<input type="hidden" name="currentVisitId" value="<%=visit.getId() %>">
</form>
<script type="text/javascript">
function validateDateOnSubmit()
{
	var length = document.getElementById('listLength').value;
    var birthdate = document.getElementById('birthdate').value;
    birthdate =   new Date(birthdate.substring(6),(birthdate.substring(3,5) - 1) ,birthdate.substring(0,2))

	for(var i = 1; i<=length; i++)
 	{
	 	if((document.getElementById('givendate'+i).value)!='')
	 	{
			var givendate = document.getElementById('givendate'+i).value;
			givendate = new Date(givendate.substring(6),(givendate.substring(3,5) - 1) ,givendate.substring(0,2))
			  if(givendate<birthdate)
			  {
               alert('Given date Should be greater than Birth Date !!!');
               return false;
              }
	 	}
  	 }
	return true;
}
</script>