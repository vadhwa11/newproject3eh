<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdObg"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>

<%--For AutoComplete Through Ajax--%>
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

<script type="text/javascript" language="javascript" 	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>

<link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script>jQuery.noConflict();</script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript">

function ismaxlength(obj){
var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
if (obj.getAttribute && obj.value.length>mlength)
obj.value=obj.value.substring(0,mlength)
}

</script>
<script>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
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

<%
		Map<String,Object> map = new HashMap<String,Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

		if(map.get("detailsMap") != null){
			detailsMap = (Map<String,Object>)map.get("detailsMap");
			}
		int orderhdId = 0;
		String buttonFlag="";
		 List patientDataList = new ArrayList();
			
	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}			
	List opdObgList= new ArrayList();
	if(map.get("opdObgList") != null){
		opdObgList=(List)map.get("opdObgList");
	}	
	List<MasOccupation> masOccupationList= new ArrayList<MasOccupation>();
	if(map.get("masOccupationList") != null){
		masOccupationList=(List)map.get("masOccupationList");
	}
	List<MasReligion> masReligionList= new ArrayList<MasReligion>();
	if(map.get("masReligionList") != null){
		masReligionList=(List)map.get("masReligionList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	
	if(map.get("buttonFlag") != null)
	{
	buttonFlag=(String)map.get("buttonFlag");

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
	 
	
	 if(map.get("orderhdId") != null)
	 {
	 orderhdId=(Integer)map.get("orderhdId");

	 }
	 
	 List opdVaccinationPlanList = new ArrayList();
		if(map.get("opdVaccinationPlanList") != null){
			opdVaccinationPlanList=(List)map.get("opdVaccinationPlanList");
		}
		String visitDOBInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());

%>


<!--main content placeholder starts here-->
<div class="OpdOphthamology-maindiv">
<form name="OBG" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(visit.getDepartment()!= null){ %>
<div class="titleBg">
<h2>Infertility Clinic</h2>
</div>
<div class="clear"></div>
<%} %> <!--Block One Starts-->
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<%if(visit.getHin().getHinNo()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label>
<%}else{ %>
<label class="valueMedium">-</label>
<%} %>
<label>Patient Name </label>
<%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label>
<%}else{ %>
<labelclass="value">- </label>
<%} %>
<label class="medium">Age</label>
<%if(visit.getHin().getAge()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getAge() %></label>
<%}else{ %>
<label class="valueMedium">-</label>
<%} %>
<label class="medium">Visit Date </label>
<%if(visitDateInString != null){ %>
<label class="valueMedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>

<div class="clear"></div>

<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no") %></label>
<%if(visit.getVisitNo()!= null){ %>
<label class="valueMedium"><%=visit.getVisitNo() %></label>
<%}else{ %>
<label	class="valueMedium">-</label> <%} %>
<label>Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label> <%}else{ %> <label>-</label>
<%} %> <label class="medium">Prev. Diag </label> <%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>
</div>

 <%
if (opdObgList.size() > 0)
	{
	Iterator itr = opdObgList.iterator();
	while (itr.hasNext()) 
	{
		OpdObg opdObg = (OpdObg) itr.next();
 %> <!--Block Two Starts-->
<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>SOCIOECONOMIC HISTORY</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title1">
<div class="clear"></div>
<div class="paddLeft95"><label>Wife</label> </div>
<div class="paddLeft35"><label>Husband</label></div>

<div class="clear"></div>
<label>Education</label>
<input	name="<%=EDUCATION_WIFE%>" maxlength="20" type="text">
<input name="<%=EDUCATION_HUSBAND %>" maxlength="20" type="text">
<div class="clear"></div>

<label>Religion</label>
<select	name="<%=RELIGION_WIFE %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masReligionList != null){ 	
          			for (Iterator iter = masReligionList.iterator(); iter.hasNext();) {
          				MasReligion masReligion = (MasReligion) iter.next();
          %>
	<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>
	<%		
         			}
         		 } 
         %>
</select>
<select name="<%=RELIGION_HUSBAND%>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masReligionList != null){ 	
          			for (Iterator iter = masReligionList.iterator(); iter.hasNext();) {
          				MasReligion masReligion = (MasReligion) iter.next();
          %>
	<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>
	<%		
         			}
         		 } 
         %>
</select>
<div class="clear"></div>

<label>Occupation</label>
<select	name="<%=OCCUPATION_WIFE %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masOccupationList != null){ 	
          			for (Iterator iter = masOccupationList.iterator(); iter.hasNext();) {
          				MasOccupation masOccupation = (MasOccupation) iter.next();
          %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>
	<%		
         			}
         		 }

         %>
</select>  <select name="<%=OCCUPATION_HUSBAND %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masOccupationList != null){ 	
          			for (Iterator iter = masOccupationList.iterator(); iter.hasNext();) {
          				MasOccupation masOccupation = (MasOccupation) iter.next();
          %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>
	<%		
         			}
         		 } 
         %>
</select>
<div class="clear"></div>

<label>Accommodation Type</label>
<input	name="<%=ACCOMMODATION_TYPE %>" maxlength="15" type="text">
<label>Privacy</label>

<label class="valueAuto">Yes</label>
<input name="<%=PRIVACY %>"	type="radio" class="radio" />
<label class="valueAuto">NO</label>
<input	name="<%=PRIVACY %>" type="radio" class="radio" />
<div class="clear"></div>
</div>

<!--Block Two Ends--> <!--Block Three Starts-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>COMPLAINTS</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title2">
<div class="clear"></div>
<label>Infertility</label>
<input name="" type="text"	style="visibility: hidden;" />
<label>Primary: Yrs</label>
<input	name="<%=INFERTILITY_PRIMARY_YRS %>" maxlength="5" type="text">
<label>Secondary:Yrs</label>
<input name="<%=INFERTILITY_SECONDARY_YRS %>" maxlength="5"	type="text">
<div class="clear"></div>
<label>Hypomenorrohea</label>
<input name="<%=HYPOMENRROHEA %>"	maxlength="5" type="text" />
<label>Yrs</label>
<input	name="<%=HYPOMENRROHEA_YRS %>" maxlength="5" type="text">
<label>Oligomenorrhoea:Yrs</label>
<input name="<%=OLIGOMEORRHOEA_YRS %>" maxlength="5" type="text">
<div class="clear"></div>
<label> Galactorrhoea</label>
<input name="<%=GALACTORRHOEA %>"	maxlength="15" type="text" />
<label>Yrs</label>
<input	name="<%=GALACTORRHOEA_YRS %>" maxlength="5" type="text">
<label>Hirsutism: Yrs</label>
<input name="<%=HIRSUTISM_YRS %>" maxlength="5" type="text">
<div class="clear"></div>
<label>Leucorrhoea</label>
<input name="<%=LEUCORRHOEA %>"	maxlength="15" type="text" />
<input name=""	type="text" style="visibility: hidden;" />
<label>Pruritis Valve</label>
<input name="<%=PRURITIS_VALUE %>" maxlength="15" type="text">
<div class="clear"></div>

<label>Backaches</label>
<input name="<%=BACKACHES %>" maxlength="15" type="text" />
<input name="Input" type="text"	style="visibility: hidden;" />
<label>Dysmenorrhoea</label>
<input	name="<%=DYSMENORRHOEA %>" maxlength="15" type="text">
<div class="clear"></div>
</div>


<!--Block Three Ends--> <!--Block Four Ends-->

<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>MENSTRUALl</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">
<div class="clear"></div>
<label>Menarche YRS</label>
<input name="<%=MENARCHE_YRS %>" maxlength="5" type="text">
<label>Past MC</label>
<input	name="<%=PAST_MC %>" maxlength="15" type="text">
<label>Present MC</label>
<input name="<%=PRESENT_MC %>" maxlength="15" type="text">
<div class="clear"></div>

<label>LMP</label>
<input name="<%=LMP %>" maxlength="15" type="text">
<label>PMP1</label>
<input name="<%=PMP_ONE %>" maxlength="15" type="text">
<label>PMP2</label>
<input name="<%=PMP_TWO %>" maxlength="15" type="text">
<div class="clear"></div>
</div>

<!--Block Four Ends--> <!--Block Five Ends-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title4','t4')">
<h5 id='t4'>PAST SURGICAL HISTORY</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title4">
<div class="clear"></div>
<label>Diagnostic Scopy</label>
<input name="<%=DIAGNOSTIC_SCOPY %>"	maxlength="20" type="text">
<label>Tubal Surgery</label>
<input name="<%=TUBAL_SURFERY %>" maxlength="20" type="text">
<div class="clear"></div>
<label>Exploratory Lap</label>
<input name="<%=EXPLORATORY_LAP %>"	maxlength="20" type="text">
<label>Operative Scopy</label>
<input name="<%=OPERATIVE_SCOPY %>" maxlength="20" type="text">
<div class="clear"></div>
<%
%>
</div>
<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">
<!--Block Five Ends--> <%}}else{ %>

<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>SOCIOECONOMIC HISTORY</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title1">
<div class="clear"></div>
<div class="paddLeft95"><label>Wife</label></div><div class="paddLeft35"><label>Husband</label></div>

<div class="clear"></div>
<label>Education</label> <input
	name="<%=EDUCATION_WIFE%>" maxlength="20" type="text">
<input name="<%=EDUCATION_HUSBAND %>" maxlength="20" type="text">
<div class="clear"></div>

<label>Religion<span></span></label> <select
	name="<%=RELIGION_WIFE %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masReligionList != null){ 	
          			for (Iterator iter = masReligionList.iterator(); iter.hasNext();) {
          				MasReligion masReligion = (MasReligion) iter.next();
          %>
	<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>
	<%		
         			}
         		 } 
         %>
</select>  <select name="<%=RELIGION_HUSBAND %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masReligionList != null){ 	
          			for (Iterator iter = masReligionList.iterator(); iter.hasNext();) {
          				MasReligion masReligion = (MasReligion) iter.next();
          %>
	<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>
	<%		
         			}
         		 } 
         %>
</select>
<div class="clear"></div>

<label>Occupation</label> <select
	name="<%=OCCUPATION_WIFE %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masOccupationList != null){ 	
          			for (Iterator iter = masOccupationList.iterator(); iter.hasNext();) {
          				MasOccupation masOccupation = (MasOccupation) iter.next();
          %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>
	<%		
         			}
         		 } 
         %>
</select>  <select name="<%=OCCUPATION_HUSBAND %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masOccupationList != null){ 	
          			for (Iterator iter = masOccupationList.iterator(); iter.hasNext();) {
          				MasOccupation masOccupation = (MasOccupation) iter.next();
          %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>
	<%		
         			}
         		 } 
         %>
</select>
<div class="clear"></div>


<label>Accommodation Type</label>
<input	<%=ACCOMMODATION_TYPE %> maxlength="15" type="text">
<label>Privacy</label>
<label>Yes</label>
<input name="<%=PRIVACY %>" type="radio" value="y"	class="radioCheck" /> <label>No</label> <input name="<%=PRIVACY %>"
	type="radio" value="n" class="radioCheck" />
<div class="clear"></div>
</div>

<!--Block Two Ends--> <!--Block Three Starts-->

<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>COMPLAINTS</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title2">
<div class="clear"></div>
<label>Infertility</label> <input name="" type="text"
	style="visibility: hidden;" /> <label>Primary: Yrs</label> <input
	name="<%=INFERTILITY_PRIMARY_YRS %>" maxlength="5" type="text"><label>Secondary:
Yrs</label> <input name="<%=INFERTILITY_SECONDARY_YRS %>" maxlength="5"
	type="text">
<div class="clear"></div>
<label>Hypomenorrohea</label> <input name="<%=HYPOMENRROHEA %>"
	maxlength="5" type="text" /> <label>Yrs</label> <input
	name="<%=HYPOMENRROHEA_YRS %>" maxlength="5" type="text"><label>Oligomenorrhoea:
Yrs</label> <input name="<%=OLIGOMEORRHOEA_YRS %>" maxlength="5" type="text">
<div class="clear"></div>
<label> Galactorrhoea</label> <input name="<%=GALACTORRHOEA %>"
	maxlength="5" type="text" /> <label>Yrs</label> <input
	name="<%=GALACTORRHOEA_YRS %>" maxlength="5" type="text"><label>Hirsutism
: Yrs</label> <input name="<%=HIRSUTISM_YRS %>" maxlength="5" type="text">
<div class="clear"></div>
<label>Leucorrhoea</label> <input name="<%=LEUCORRHOEA %>"
	maxlength="15" type="text" />  <input name=""
	type="text" style="visibility: hidden;" /> <label>Pruritis
Valve</label> <input name="<%=PRURITIS_VALUE %>" maxlength="15" type="text">
<div class="clear"></div>

<label>Backaches</label> <input name="<%=BACKACHES %>" maxlength="15"
	type="text" />  <input name="" type="text"
	style="visibility: hidden;" /> <label>Dysmenorrhoea</label> <input
	name="<%=DYSMENORRHOEA %>" maxlength="15" type="text">
<div class="clear"></div></div>

<!--Block Three Ends--> <!--Block Four Ends-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>MENSTRUALl</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">
<div class="clear"></div>
<label>Menarche YRS:</label> <input name="<%=MENARCHE_YRS %>"
	maxlength="5" type="text"><label>Past MC</label> <input
	name="<%=PAST_MC %>" maxlength="15" type="text"><label>Present
MC</label> <input name="<%=PRESENT_MC %>" maxlength="15" type="text">
<div class="clear"></div>

<label>LMP</label> <input name="<%=LMP %>" maxlength="15" type="text"><label>PMP1</label>
<input name="<%=PMP_ONE %>" maxlength="15" type="text"><label>PMP2</label>
<input name="<%=PMP_TWO %>" maxlength="15" type="text">
<div class="clear"></div></div>

<!--Block Four Ends--> <!--Block Five Ends-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title4','t4')">
<h5 id='t4'>PAST SURGICAL HISTORY</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title4">
<div class="clear"></div>
<label>Diagnostic Scopy</label> <input name="<%=DIAGNOSTIC_SCOPY %>"
	maxlength="20" type="text"> <label>Tubal
Surgery</label> <input name="<%=TUBAL_SURFERY %>" maxlength="20" type="text">
<div class="clear"></div>
<label>Exploratory Lap</label> <input name="<%=EXPLORATORY_LAP %>"
	maxlength="20" type="text"> <label>Operative
Scopy</label> <input name="<%=OPERATIVE_SCOPY %>" maxlength="20" type="text">
<div class="clear"></div></div>

<!--Block Five Ends--> <%} %>
<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>">
<input type="hidden"	name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input	type="hidden" name="<%=VISIT_NUMBER %>"	value="<%=visit.getVisitNo() %>">
<input type="hidden"	name="<%=OBG_ID %>" value="<%=visit.getVisitNo() %>">
<input	type="hidden" name="<%=HOSPITAL_ID %>"	value="<%=visit.getHin().getHospital().getId() %>">
<input	type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=visit.getDepartment().getId() %>">
<div class="clear"></div>
<div class="division"></div>
<input name="button" type="button"	class="button" id="btn2" value="Page 1" />
<input name="Button" type="button" class="button" value="Page 2"	onclick="submitForm('OBG','opd?method=showOBGTWOJsp&visitId=<%=visit.getId() %>');" />
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" align="right" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
</form>

</div>

<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>