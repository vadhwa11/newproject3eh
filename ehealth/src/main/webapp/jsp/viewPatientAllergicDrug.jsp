<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.PatientAllergicDrugsHd"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.masters.business.PatientAllergicDrugsDt"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>



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
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

</script>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<!--main content placeholder starts here-->



<%

URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

	Map<String, Object> map = new HashMap<String, Object>();
	Map<String, Object> detailsMap = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	int pageNo=1;
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	List<Visit> patientDataList = new ArrayList<Visit>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	
	if(detailsMap.get("patientDataList") != null){
		patientDataList=(List<Visit>)detailsMap.get("patientDataList");
	}	

	 List<PatientAllergicDrugsDt> searchPatientAllergicDrugsDtList = new ArrayList<PatientAllergicDrugsDt>();
		
	if(map.get("searchPatientAllergicDrugsDtList") != null){
		searchPatientAllergicDrugsDtList=(List<PatientAllergicDrugsDt>)map.get("searchPatientAllergicDrugsDtList");
	}
	
	int currentVisitId=0;
	if(map.get("currentVisitId") != null){
		currentVisitId = (Integer)map.get("currentVisitId");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	 if(map.get("pageNo") != null)
	 {
	 pageNo=(Integer)map.get("pageNo");

	 }
	List itemList = new ArrayList();
	List<PatientAllergicDrugsHd> searchPatientAllergicDrugsHdList = new ArrayList<PatientAllergicDrugsHd>();
	
	if(map.get("searchPatientAllergicDrugsHdList") != null){
		searchPatientAllergicDrugsHdList=(List<PatientAllergicDrugsHd>)map.get("searchPatientAllergicDrugsHdList");
	}	
	if(searchPatientAllergicDrugsDtList.size() > 0){
		
		PatientAllergicDrugsHd patientAllergicDrugsHd = new PatientAllergicDrugsHd();
		patientAllergicDrugsHd = searchPatientAllergicDrugsDtList.get(0).getPatientAllergicDrugsHd();
		
			
		if(detailsMap.get("itemList") != null){
			 itemList = (List)detailsMap.get("itemList");
			 }
		
		
		Visit visit = new Visit();
		
	visit=	patientAllergicDrugsHd.getVisit();
		String patientName="";
		if(patientAllergicDrugsHd.getHin().getPFirstName()!= null){
			patientName=patientAllergicDrugsHd.getHin().getPFirstName();
		}
		
		if(patientAllergicDrugsHd.getHin().getPMiddleName()!= null){
			patientName=patientName+" "+patientAllergicDrugsHd.getHin().getPMiddleName();
		}
		if(patientAllergicDrugsHd.getHin().getPLastName()!= null){
			patientName=patientName+" "+patientAllergicDrugsHd.getHin().getPLastName();
		}
		 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());

%>


<form name="ent" action="" method="post">

<div class="titleBg">
<h2>Patient Allergic Drugs</h2>
</div>
<div class="clear"></div>
<!--Block One Starts-->
<h4>Personal Details</h4>
<div class="clear"></div>

<div class="Block">
<div class="clear"></div>
<%-- <label>Service No. </label>
	<%if(visit.getHin().getServiceNo()!= null){ %>
	<label class="value"><%=visit.getHin().getServiceNo() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>
	
	<label>Service Type</label>
	<%if(visit.getHin().getServiceType()!= null){ %>
	<label class="value"><%=visit.getHin().getServiceType().getServiceTypeName() %></label>
	<%}else{ %>
	<label class="value">-</label>
	<%} %>--%> <label><%=prop.getProperty("com.jkt.hms.registration_no") %> </label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="value"><%=visit.getHin().getHinNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Patient Name. </label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label>Age</label> <%if(visit.getHin().getAge()!= null){ %>
<label class="value"><%=visit.getHin().getAge() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>
<div class="clear"></div>




<label><%=prop.getProperty("com.jkt.hms.opd_no")%></label> <%if(visit.getVisitNo()!= null){ %> <label
	class="value"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Visit Date </label> <%if(visitDateInString != null){ %>
<label class="value"><%=visitDateInString %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Visit Time</label> <%if(visit.getVisitTime() != null){ %>
<label class="value"><%=visit.getVisitTime() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>


<div class="clear"></div>

</div>
<div class="clear"></div>

<script type="text/javascript">
var amtArray = new Array();
<%
if(itemList!=null){
int counter=0;
Iterator ite = itemList.iterator();
while ( ite.hasNext() ) {
Object[] pair = (Object[]) ite.next();
MasStoreItem MasStoreItem = (MasStoreItem) pair[0];

%>
amtArray[<%=counter%>] = new Array();
amtArray[<%=counter%>][0]=<%=MasStoreItem.getId()%>;
amtArray[<%=counter%>][1] = <%=MasStoreItem.getNomenclature()%>;									

<%
counter++;
}
}
%>
</script> <input type=hidden value=0 name=pagecounter2 /> <input type="hidden"
	name="pageNo" id="pageNo" value="<%=pageNo%>" /> <input type="hidden"
	size="2" value="" name="noOfRecords" id="noOfRecords" /> <input
	type="hidden" id="patientAllergicDrugshdId"
	value="<%= patientAllergicDrugsHd.getId()%>" /> <input type="hidden"
	name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>"> <input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"> <input type="hidden"
	name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" />
<input type="hidden" name="currentVisitId" value="<%=currentVisitId %>">

<div class="paddingTop15"></div>
<div class="tableHholderCmnLarge">
<% if(searchPatientAllergicDrugsDtList.size() > 0) { 
          Iterator itr=searchPatientAllergicDrugsDtList.iterator();%>
<table width="100%" colspan="7" id="chargeDetails" cellpadding="0"
	cellspacing="0">
	<thead>
		<tr>

			<th width="7%">PVMS No</th>
			<th width="10%">Nomenclature</th>
			<th width="7%">Special Instruction</th>
		</tr>
	</thead>
	<%
          while(itr.hasNext())
          			{
          				PatientAllergicDrugsDt patientAllergicDrugsDt=(PatientAllergicDrugsDt)itr.next();
          				
          			
      %>
	<tbody>

		<tr>


			<td><input type="text" name="<%=PVMS_NO %>"
				value="<%=patientAllergicDrugsDt.getItem().getPvmsNo() %>"
				id="pvmsNo" validate="PVMS No.,string,no" readonly /></td>


			<td width="10%"><input type="text"
				value="<%=patientAllergicDrugsDt.getItem().getNomenclature() %>"
				size="30" readonly tabindex="1" id="nomenclature"
				name="<%=NOMENCLATURE_OPD %>" /></td>
			<input type="hidden" value="" name="<%=ITEM_ID%>" id="itemId" />
			<td width="7%"><input type="text" id="instructions" tabindex="1"
				name="<%=INSTRUCTIONS %>"
				value="<%=patientAllergicDrugsDt.getSpecialInstruction() %>"
				readonly /></td>
		</tr>

		<%}%>
	</tbody>
</table>


</div>
<div class="clear"></div>
<div class="division"></div>
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <input name="Back" type="button" src="images/phaseII/delete.gif"
	alt="Back" value="Back" class="button"
	onclick="history.go(-1);return false;" align="right" /> <%}%> <!--Block two Ends-->
<div class="clear"></div>
<div class="division"></div>
<!--Bottom labels starts-->
<div class="bottom"><label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label>
	</div>
<div class="clear"></div>
<input name="prev" type="hidden" class="button" value="Prev"
	onclick="submitForm('ent','opd?method=viewPatientAllergicDrug&flag=prev');">
<input name="next" type="hidden" class="button" value="Next"
	onclick="submitForm('ent','opd?method=viewPatientAllergicDrug&flag=next');">


<!--Bottom labels ends--> <%}}else{%>
 <h4><span>No Record Found!!</span></h4>
 <input	name="Back" type="button"  alt="Back"	value="Back" class="button" onclick="history.go(-1);return false;"	align="right" />
 </div>


<%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		