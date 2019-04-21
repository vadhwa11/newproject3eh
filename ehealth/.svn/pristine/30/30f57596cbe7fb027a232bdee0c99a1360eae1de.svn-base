<%@page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdAntenatalCard"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%--For AutoComplete Through Ajax--%>
<script type="text/javascript" src="/hms/jsp/js/phase2/ddaccordion.js">
/***********************************************
* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
* This notice must stay intact for legal use
***********************************************/
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
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
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
<form name="antenatalCard" method="post" action="">
<div class="titleBg">
<h2>Antenatal Card</h2>
</div>
<div class="clear"></div>

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

	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	
	List<Visit> patientDataList = new ArrayList<Visit>();
	List<OpdAntenatalCard> antenatalCardList = new ArrayList<OpdAntenatalCard>();
	
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	
	if(detailsMap.get("patientDataList") != null){
		patientDataList=(List<Visit>)detailsMap.get("patientDataList");
	}	
	if(map.get("opdAntenatalCardList") != null){
		antenatalCardList=(List<OpdAntenatalCard>)map.get("opdAntenatalCardList");
	}	
	int currentVisitId=0;
	if(map.get("currentVisitId") != null){
		currentVisitId = (Integer)map.get("currentVisitId");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}

	
	
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
	%> <script type="text/javascript">
function get_valueForGravidagramHTN()
{
   var url="/hms/hms/opd?method=viewGravidagramHTN&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>";
   popwindowGravidagram(url);
  
 }
 function get_valueForGravidagramGestationalDiabitiesOne()
{
  var url="/hms/hms/opd?method=viewGravidagramGestationalDiabitiesOne&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>";
   popwindowGravidagram(url);
 }  
  function get_valueForGravidagramGestationalDiabitiesTwo()
{
  var url="/hms/hms/opd?method=viewGravidagramGestationalDiabitiesTwo&hinId=<%=visit.getHin().getId()%>&flag=current&<%=VISIT_NUMBER %>=<%=visit.getVisitNo() %>&viewScreen=yes&deptId=<%=visit.getDepartment().getId() %>";
   popwindowGravidagram(url);
 }
var newwindow;
function popwindow(url)
{

 newwindow=window.open(url,'name',"height=50,width=1000,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();
 //window.close();
}
function popwindowGravidagram(url)
{

 newwindow=window.open(url,'name',"height=1000,width=1000,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();
 //window.close();
}		

function back() {
window.close();
return;

}

</script> <!--Block One Starts-->
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="value"><%=visit.getHin().getHinNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Patient Name </label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label>Age</label> <%if(visit.getHin().getAge()!= null){ %>
<label class="value"><%=visit.getHin().getAge() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Visit Date </label> <%if(visitDateInString != null){ %>
<label class="value"><%=visitDateInString %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label><%=prop.getProperty("com.jkt.hms.opd_no") %></label> <%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>
<div class="clear"></div>
<label>Prev. Diag </label> <%if(visit.getDiagnosis()!= null){ %> <label
	class="valueNoWidth"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %> <label>ECHS No. </label> <%if(visit.getHin().getEchsNo()!= null){ %>
<label class="value"><%=visit.getHin().getEchsNo() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Phone Number</label> <% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
<label class="value"><%=visit.getHin().getPhoneNumber() %></label> <%}else{ %>
<label class="value">-</label> <%} %>

<div class="clear"></div>


<label>Mobile Number</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="value"><%=visit.getHin().getMobileNumber() %></label> <%}else{ %>
<label class="value">-</label> <%} %> <label class="noWidth">Consulting
Doctor</label> <label class="value"><%=userName %></label>

<div class="clear"></div>
</div>
<div class="clear"></div>
<!--Block one Ends--> <!--Block one Ends--> <%if(antenatalCardList.size() > 0){
	
	OpdAntenatalCard antenatalCard = new OpdAntenatalCard();
	antenatalCard = antenatalCardList.get(0); %> <!--Block two Start--> <a
	href="javascript:changeClass('title1','t1')">
<h5 id='t1'>Details I</h5>
</a>
<div class="Block" id="title1">
<div class="clear"></div>

<h4>Menstrual History</h4>
<div class="clear"></div>
<label class="medium">Menraeche </label> <%if(antenatalCard.getMenarche()==null){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=MENARCHE %>" validate="Menraeche Code,num,no" type="text"
	maxlength="3" value="<%=antenatalCard.getMenarche() %>"
	readonly="readonly" /> <%} %> <label>Cycle</label> <%if(antenatalCard.getCycle()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <label
	class="valuemedium"><%=antenatalCard.getCycle() %></label> <%} %> <%if(antenatalCard.getDays()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=DAYS %>" type="text" class="calDate" maxlength="15"
	value="<%=antenatalCard.getDays()%>" readonly="readonly" /> <%} %> <label
	class="small">Days</label>
<div class="clear"></div>
<label class="medium">LMP</label> <%if(antenatalCard.getLmp()==null){%> <label></label>
<label class="value">-</label> <%} else{%> <input type="text" id="lmpId"
	name="<%=LMP %>"
	value="<%=HMSUtil.changeDateToddMMyyyy(antenatalCard.getLmp())%>"
	class="calDate" validate="LMP,date,no" readonly="readonly" /> <%} %> <label>EDD
(LMP+9M+7D)</label> <%if(antenatalCard.getEdd()==null){%> <label></label> <label
	class="value">-</label> <%} else{%> <input type="text" id="eddId"
	name="<%=EDD %>"
	value="<%=HMSUtil.changeDateToddMMyyyy(antenatalCard.getEdd())%>"
	class="calDate" validate="EDD,date,no" readonly="readonly" /> <%} %>
<div class="clear"></div>
<h4>Obstetric History</h4>
<div class="clear"></div>
<label>Gravida </label> <label class="small"><%=antenatalCard.getGravida() %></label>
<label>Para</label> <label class="small"><%=antenatalCard.getPara() %></label>
<label>Abortion</label> <label class="small"><%=antenatalCard.getAbortions() %></label>

<label>Live</label> <label class="small"><%=antenatalCard.getLive() %></label>
<label>Ectopic</label> <label class="small"><%=antenatalCard.getEctopic() %></label>
<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Srl No.</th>
		<th scope="col">Year</th>
		<th scope="col">Pregnancy Outcome</th>
		<th scope="col">Complication ( Preg. Delivery/ Puerperium)</th>
		<th scope="col">Sex</th>
		<th scope="col">Age</th>
		<th scope="col">Birth Weight</th>
		<th scope="col">Breast Feeding</th>
		<th scope="col">General Health</th>
	</tr>
	<tr>
		<td><input name="<%=SR_NO %>" type="text" size=3
			validate="Sr No Code,num,no" /></td>
		<%if(antenatalCard.getYear()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=YEAR %>" type="text" size=3 id="yearTxt"
			onblur="yearValid();" maxlength="4"
			value="<%=antenatalCard.getYear()%>" readonly="readonly" /></td>
		<%}if(antenatalCard.getPregnancyOutcome()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=PREGNANCY_OUTCOME %>" type="text"
			maxlength="20" validate="Pregnancy Outcome,string,no"
			value="<%=antenatalCard.getPregnancyOutcome()%>" readonly="readonly" /></td>
		<%}if(antenatalCard.getComplications()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=COMPLICATIONS %>" type="text" maxlength="20"
			validate="Complication(Preg.Delivery/ Puerperium),string,no"
			value="<%=antenatalCard.getComplications()%>" readonly="readonly" /></td>
		<%}if(antenatalCard.getSex()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=SEX %>" type="text" size=3 maxlength="6"
			validate="Sex,string,no" value="<%=antenatalCard.getSex()%>"
			readonly="readonly" /></td>
		<%}if(antenatalCard.getAge()==null){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=AGE_UNIT %>" type="text" size=3 maxlength="2"
			validate="Age,num,no" value="<%=antenatalCard.getAge()%>"
			readonly="readonly" /></td>
		<%}if(antenatalCard.getBirthWeight()==null){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=BIRTH_WEIGHT %>" type="text" size=5
			maxlength="2" validate="Birth Weight,num,no"
			value="<%=antenatalCard.getBirthWeight()%>" readonly="readonly" /></td>
		<%}if(antenatalCard.getBreastFeeding()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=BREAST_FEEDING %>" type="text" size=10
			maxlength="15" validate="Breast Feeding,string,no"
			value="<%=antenatalCard.getBreastFeeding()%>" readonly="readonly" /></td>
		<%}if(antenatalCard.getGeneralHealth()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=GENERAL_HEALTH %>" type="text" size=10
			maxlength="15" validate="General Health,string,no"
			value="<%=antenatalCard.getGeneralHealth()%>" readonly="readonly" /></td>
		<%} %>
	</tr>
</table>

</div>
</div>
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>Details II</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title2">
<div class="clear"></div>
<div class="division"></div>
<h4>Past History</h4>
<div class="clear"></div>

<label>Medical </label> <%if(antenatalCard.getMedical()==""){%> <label></label>
<label class="value">-</label> <%} else{%> <input name="<%=MEDICAL %>"
	type="text" maxlength="20" validate="Medical Code,string,no"
	value="<%=antenatalCard.getMedical()%>" readonly="readonly" /> <%} %> <label>Surgical</label>
<%if(antenatalCard.getSurgical()==""){%> <label></label> <label
	class="value">-</label> <%} else{%> <input name="<%=SURGICAL %>"
	type="text" maxlength="20" validate="Surgical Code,string,no"
	value="<%=antenatalCard.getSurgical()%>" readonly="readonly" /> <%} %> <label>Gynaecological</label>
<%if(antenatalCard.getGynecological()==""){%> <label></label> <label
	class="value">-</label> <%} else{%> <input name="<%=GYNECOLOGICAL %>"
	type="text" maxlength="20" validate="Gynaecological Code,string,no"
	value="<%=antenatalCard.getGynecological()%>" readonly="readonly" /> <%} %>
<div class="clear"></div>

<h4>Family History</h4>
<div class="clear"></div>
<label>Medical History </label> <%if(antenatalCard.getMedicalHistory()==null){%>
<label></label> <label class="value">-</label> <%} else{%> <label
	class="value"><%=antenatalCard.getMedicalHistory() %></label> <%} %> <label>Multiple
Pregnancy </label> <%if(antenatalCard.getMultiplePregnancy()==""){%> <label></label>
<label class="value">-</label> <%} else{%> <input
	name="<%=MULTIPLE_PREGNANCY %>" type="text" maxlength="20"
	validate="Multiple Pregnancy,string,no"
	value="<%=antenatalCard.getMultiplePregnancy()%>" readonly="readonly" />
<%} %> <label>Foetal Abnormality</label> <%if(antenatalCard.getFoetalAbnormality()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=FOETAL_ABNORMALITY %>" type="text" maxlength="20"
	validate="Foetal Abnormality,string,no"
	value="<%=antenatalCard.getFoetalAbnormality()%>" readonly="readonly" />
<%} %>
<div class="clear"></div>
<h4>Personal History</h4>
<div class="clear"></div>
<label> Dietary Habit </label> <%if(antenatalCard.getDietaryHabit()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <label
	class="value"><%=antenatalCard.getDietaryHabit() %></label> <%} %> <label>Smoking</label>
<%if(antenatalCard.getSmoking()==""){%> <label></label> <label
	class="value">-</label> <%} else{%> <label class="value"><%=antenatalCard.getSmoking() %></label>
<%} %>
<div class="clear"></div>
<h4>Booking Examination</h4>
<div class="clear"></div>
<label class="medium">Build</label> <%if(antenatalCard.getBuild()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=BUILD %>" type="text" maxlength="20"
	validate="Build,string,no" value="<%=antenatalCard.getBuild()%>"
	readonly="readonly" /> <%} %> <label class="medium">Nutrition</label> <%if(antenatalCard.getNutrition()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=NUTRITION %>" type="text" maxlength="10"
	validate="Nutrition,string,no"
	value="<%=antenatalCard.getNutrition()%>" readonly="readonly" /> <%} %>
<label class="medium">Height</label> <%if(antenatalCard.getHeight()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=HEIGHT %>" type="text" class="calDate" maxlength="10"
	validate="Height,string,no" value="<%=antenatalCard.getHeight()%>"
	readonly="readonly" /> <%} %> <label class="medium">Weight</label> <%if(antenatalCard.getWeight()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=WEIGHT %>" type="text" class="calDate" maxlength="6"
	validate="Weight,string,no" value="<%=antenatalCard.getWeight()%>"
	readonly="readonly" /> <%} %>
<div class="clear"></div>
<label class="medium">Breast</label> <%if(antenatalCard.getBreast()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=BREAST %>" type="text" maxlength="5"
	validate="Breast,string,no" value="<%=antenatalCard.getBreast()%>"
	readonly="readonly" /> <%} %> <label class="medium">Nipple</label> <%if(antenatalCard.getNipple()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=NIPPLE %>" type="text" maxlength="5"
	validate="Nipple,string,no" value="<%=antenatalCard.getNipple()%>"
	readonly="readonly" /> <%} %> <label class="medium">Heart</label> <%if(antenatalCard.getHeart()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=HEART %>" type="text" class="calDate" maxlength="5"
	validate="Heart,string,no" value="<%=antenatalCard.getHeart()%>"
	readonly="readonly" /> <%} %> <label class="medium">Lungs</label> <%if(antenatalCard.getLungs()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=LUNGS %>" type="text" class="calDate" maxlength="5"
	validate="LUNGS,string,no" value="<%=antenatalCard.getLungs()%>"
	readonly="readonly" /> <%} %>
<div class="clear"></div>
</div>

<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>Details III</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">
<div class="clear"></div>

<h4>Blood Group</h4>
<div class="clear"></div>
<label class="medium">Wife</label> <%if(antenatalCard.getBloodGroupWife()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <label
	class="value"><%=antenatalCard.getBloodGroupWife() %></label> <%} %> <label
	class="medium">Husband</label> <%if(antenatalCard.getBloodGroupHusband()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <label
	class="value"><%=antenatalCard.getBloodGroupHusband() %></label> <%} %>
<div class="clear"></div>
<label class="medium">STS</label> <%if(antenatalCard.getSts()==""){%> <label></label>
<label class="value">-</label> <%} else{%> <input name="<%=STS %>"
	type="text" size=9 class="Auto" maxlength="10" validate="STS,string,no"
	value="<%=antenatalCard.getSts()%>" readonly="readonly" /> <%} %> <label
	class="medium">Hbsag</label> <%if(antenatalCard.getHbsag()==""){%> <label></label>
<label class="value">-</label> <%} else{%> <input name="<%=HBSAG %>"
	type="text" size=9 class="Auto" maxlength="10"
	validate="Hbsag,string,no" value="<%=antenatalCard.getHbsag()%>"
	readonly="readonly" /> <%} %> <label class="medium">HIV</label> <%if(antenatalCard.getHiv()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=HIV %>" type="text" size=9 class="Auto" maxlength="10"
	validate="HIV,string,no" value="<%=antenatalCard.getHiv()%>"
	readonly="readonly" /> <%} %> <label class="medium">GCT</label> <%if(antenatalCard.getGct()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	type="text" name="<%=GCT %>" class="small" maxlength="10"
	validate="GCT,string,no" value="<%=antenatalCard.getGct()%>"
	readonly="readonly" /> <%} %> <label class="small">mg%</label> <label
	class="noWidth">&nbsp;&nbsp;Date</label> <%if(antenatalCard.getExaminationDate()==null){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	type="text" id="depIssueDateId" name="<%=EXAMINATION_DATE %>"
	value="<%=HMSUtil.changeDateToddMMyyyy(antenatalCard.getExaminationDate())%>"
	class="calDate" validate="Date,date,no" readonly="readonly" /> <%} %>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">OGTT</th>
		<th scope="col">Fasting</th>
		<th scope="col">1 Hr</th>
		<th scope="col">2 Hr</th>
		<th scope="col">3 Hr</th>
	</tr>

	<tr>
		<%if(antenatalCard.getOgtt()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=OGTT %>" type="text" maxlength="10"
			validate="OGTT,string,no" value="<%=antenatalCard.getOgtt()%>"
			readonly="readonly" /></td>
		<%}if(antenatalCard.getFasting()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=FASTING %>" type="text" maxlength="10"
			validate="Fasting,string,no" value="<%=antenatalCard.getFasting()%>"
			readonly="readonly" /></td>
		<%}if(antenatalCard.getOneHr()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=ONE_HR %>" type="text" maxlength="10"
			validate="1 Hr,string,no" value="<%=antenatalCard.getOneHr()%>"
			readonly="readonly" /></td>
		<%}if(antenatalCard.getTwoHr()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=TWO_HR%>" type="text" maxlength="10"
			validate="2 Hr,string,no" value="<%=antenatalCard.getTwoHr()%>"
			readonly="readonly" /></td>
		<%}if(antenatalCard.getThreeHr()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=THREE_HR %>" type="text" maxlength="10"
			validate="3 Hr,string,no" value="<%=antenatalCard.getThreeHr()%>"
			readonly="readonly" /></td>
		<%} %>
	</tr>
</table>
</div>
</div>
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title4','t4')">
<h5 id='t4'>Details IV</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title4">
<div class="clear"></div>

<label>High Risk Factors</label> <%if(antenatalCard.getHighRiskFactors()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	name="<%=HIGH_RISK_FACTORS %>"
	value="<%=antenatalCard.getHighRiskFactors()%>" type="text"
	class="large" maxlength="30" validate="High Risk Factors,string,no"
	readonly="readonly" /> <%} %>
<div class="clear"></div>
<h4>Immunisation: Tetanus</h4>
<div class="clear"></div>
<label>1st Dose on</label> <%if(antenatalCard.getTetanusOnestDoseDate()==null){%>
<label></label> <label class="value">-</label> <%} else{%> <input
	type="text"
	value="<%=HMSUtil.changeDateToddMMyyyy(antenatalCard.getTetanusOnestDoseDate())%>"
	name="<%=TETANUS_ONE_DOSE_DATE %>" class="calDate"
	validate="1st Dose on,date,no" readonly="readonly" /> <%} %> <label>2nd
Dose on</label> <%if(antenatalCard.getTetanusTwondDoseDate()==null){%> <label></label>
<label class="value">-</label> <%} else{%> <input type="text"
	value="<%=HMSUtil.changeDateToddMMyyyy(antenatalCard.getTetanusTwondDoseDate())%>"
	name="<%=TETANUS_TWO_DOSE_DATE %>" class="calDate"
	validate="2st Dose on,date,no" readonly="readonly" /> <%} %>
<div class="clear"></div>
<label class="noWidth">Willing for Tubectomy</label> <%if(antenatalCard.getWillingForTubectomy()==""){%>
<label></label> <label class="value">-</label> <%} else{%> <label
	class="value"><%=antenatalCard.getWillingForTubectomy() %></label> <%} %>
<div class="clear"></div>
</div>

<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title5','t5')">
<h5 id='t5'>Periodic Antenatal Record</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title5">
<div class="clear"></div>
<h4>Present Records</h4>
<div class="clear"></div>
<div class="cmntable">
<div class="clear"></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col">&nbsp;</th>
		<th scope="col">Weight (kg)</th>
		<th scope="col">Any Complaint</th>
		<th scope="col">Pallor</th>
		<th scope="col">Oedema</th>
		<th scope="col">BP</th>
		<th scope="col">Uterine Size<br readonly="readonly" />
		Weeks/Cms</th>
		<th scope="col">Presentation &amp; Position</th>
		<th scope="col">Enagement</th>
		<th scope="col">FHS/FM</th>
		<th scope="col">Urine</th>
		<th scope="col">Hb% gms</th>
		<th scope="col">Next Visit on</th>
		<th scope="col">Advice</th>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<%if(antenatalCard.getWeightAntenatal()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=WEIGHT_ANTENATAL %>" type="text" size=5
			maxlength="5" validate="Weight(kg) Code,string,no"
			value="<%=antenatalCard.getWeightAntenatal() %>" readonly="readonly" /></td>
		<%}if(antenatalCard.getAnyCompliant()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=ANY_COMPLIANT %>" type="text" maxlength="25"
			validate="Any Complaint Code,string,no"
			value="<%=antenatalCard.getAnyCompliant() %>" readonly="readonly" /></td>
		<%}if(antenatalCard.getParllor()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=PARLLOR%>" type="text" size=10 maxlength="15"
			validate="Pallor Code,string,no"
			value="<%=antenatalCard.getParllor() %>" readonly="readonly" /></td>
		<%}if(antenatalCard.getOedema()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=OEDEMA%>" type="text" size=10 maxlength="15"
			validate="Oedema Code,string,no"
			value="<%=antenatalCard.getOedema() %>" readonly="readonly" /></td>
		<%}if(antenatalCard.getBp()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=BP %>" type="text" size=2 maxlength="6"
			validate="BP,string,no" value="<%=antenatalCard.getBp() %>"
			readonly="readonly" /></td>
		<%}if(antenatalCard.getUterineSize()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=UTERINE_SIZE %>" type="text" size=10
			maxlength="15" validate="Uterine Size,string,no"
			value="<%=antenatalCard.getUterineSize() %>" readonly="readonly" /></td>
		<%}if(antenatalCard.getPresentationPosition()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=PRESENTATION_POSITION %>" type="text" size=10
			maxlength="15" validate="Presentation & Position,string,no"
			value="<%=antenatalCard.getPresentationPosition() %>"
			readonly="readonly" /></td>
		<%}if(antenatalCard.getEngagement()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=ENGAGEMENT %>" type="text" size=10
			maxlength="15" validate="Enagement,string,no"
			value="<%=antenatalCard.getEngagement() %>" readonly="readonly" /></td>
		<%}if(antenatalCard.getFhsFm()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=FHS_FM %>" type="text" size=10 maxlength="15"
			validate="FHS/FM,string,no" value="<%=antenatalCard.getFhsFm() %>"
			readonly="readonly" /></td>
		<%}if(antenatalCard.getUrine()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=URINE %>" type="text" size=10 maxlength="15"
			validate="Urine,string,no" value="<%=antenatalCard.getUrine() %>"
			readonly="readonly" /></td>
		<%}if(antenatalCard.getHbGms()==""){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input name="<%=HB_GMS %>" type="text" size=10 maxlength="15"
			validate="Hb% gms,string,no" value="<%=antenatalCard.getHbGms() %>"
			readonly="readonly" /></td>
		<%}if(antenatalCard.getNextVisitOn()==null){%>
		<label></label>
		<label class="value">-</label>
		<%} else{%>
		<td><input type="text" name="<%=NEXT_VISIT_ON %>" size="10"
			validate="Next Visit on,date,no"
			value="<%=HMSUtil.changeDateToddMMyyyy(antenatalCard.getNextVisitOn()) %>"
			readonly="readonly" /> <%}if(antenatalCard.getAdvice()==""){%> <label></label>
		<label class="value">-</label> <%} else{%>
		<td><input name="<%=ADVICE %>" type="text" size=10 maxlength="15"
			validate="Advice,string,no" value="<%=antenatalCard.getAdvice() %>"
			readonly="readonly" /></td>
		<%} %>
		
	</tr>
</table>

</div>
<div class="clear"></div>
<input name="" type="button" class="button" value="Gravidagram HTN"	onclick="get_valueForGravidagramHTN();" />
<input name=""	type="button" class="button" value="Gravidagram GDM1"	onclick="get_valueForGravidagramGestationalDiabitiesOne();" />
<input	name="" type="button" class="button" value="Gravidagram GDM2"	onclick="get_valueForGravidagramGestationalDiabitiesTwo();" />
<div class="clear"></div>
</div>

<div class="division"></div>
<div class="clear"></div>
<input name="prev" type="button" class="button" value="Prev"	onclick="submitForm('antenatalCard','opd?method=viewAntenatalCard&flag=prev');">
<input name="next" type="button" class="button" value="Next"	onclick="submitForm('antenatalCard','opd?method=viewAntenatalCard&flag=next');">
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> 
<input name="Back" type="button"	alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" align="right" /> <%}%>

<div class="division"></div>
<div class="clear"></div>

<!--Bottom labels starts-->
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %></label>

<label>Changed Date</label>
<label class="value"><%=date%></label>
<label>Changed
Time</label> <label class="value"><%=time%></label></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> <input
	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<%}else{%><h4><span>No Record Found!!</span></h4> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" align="right" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<!--Bottom labels ends--> <%} %>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	
</form>


<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>