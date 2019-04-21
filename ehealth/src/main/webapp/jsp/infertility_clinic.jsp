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
<!-- <script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script> -->

<%--For AutoComplete Through Ajax--%>
<!-- <script type="text/javascript">
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
</script> -->

<script type="text/javascript" language="javascript" 	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/opd.js"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js"></script>

<!-- <link href="/hms/jsp/css/jquery-ui.css" rel="stylesheet" />	
<script src="/hms/jsp/js/jquery-1.10.2.js"></script>
<script src="/hms/jsp/js/jquery-ui.js"></script>
<script src="/hms/jsp/js/canvasjs.min.js"></script>
<script>jQuery.noConflict();</script> -->

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<!-- <script type="text/javascript">
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
</script> -->
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
<!-- <div class="OpdOphthamology-maindiv"> -->
<form name="OBG" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(visit.getDepartment()!= null){ %>
<div class="titleBg">
<h2>Infertility Clinic</h2>
</div>
<div class="clear"></div>
<input id="infertilityClinicFlag" name="infertilityClinicFlag"  value="InfertilityClinic" type="hidden"  />
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
<label class="value">- </label>
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
<%} %> 
<label class="medium">Prev. Diag </label> <%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>

<div class="clear"></div>
</div>

 <%
 System.out.println("opdObgList========in jsp========"+opdObgList.size());
if (opdObgList.size() > 0)
	{
	Iterator itr = opdObgList.iterator();
	while (itr.hasNext()) 
	{
		OpdObg opdObg = (OpdObg) itr.next();
 %> <!--Block Two Starts-->
<div class="clear"></div>

<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('SOCIOECONOMIC HISTORY')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">SOCIOECONOMIC HISTORY</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title1">
<div class="indArrow"></div>
<div class="Block">
<label style="margin-left:171px;background:none; box-shadow:none;">Wife</label><label style="margin-left:29px;background:none; box-shadow:none;">Husband</label>

<div class="clear"></div>
<label>Education AAA</label>
<input	name="<%=EDUCATION_WIFE%>" maxlength="20" type="text" value="<%=opdObg.getEducationWife() != null?opdObg.getEducationWife():""%>">
<input name="<%=EDUCATION_HUSBAND %>" maxlength="20" type="text" value="<%=opdObg.getEducationHusband() != null?opdObg.getEducationHusband():""%>">
<div class="clear"></div>

<label>Religion</label>
<select	name="<%=RELIGION_WIFE %>" >
	<option value="0">Select</option>
	<%
          		if(masReligionList != null){ 	
          			for (Iterator iter = masReligionList.iterator(); iter.hasNext();) {
          				MasReligion masReligion = (MasReligion) iter.next();
          				if(opdObg.getReligionWife() != null){
          				if(masReligion.getId().equals(opdObg.getReligionWife().getId())){
          %>
	<option value="<%=masReligion.getId() %>" selected="selected"><%=masReligion.getReligionName() %></option>
	<%		
         			}else{%>
         				<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>	
         			<%}
          				}else{%>
          					
          					<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>	
          					
          				<%}
         		 }
          		}
         %>
</select>
<select name="<%=RELIGION_HUSBAND%>" >
	<option value="0">Select</option>
	<%
          		if(masReligionList != null){ 	
          			for (Iterator iter = masReligionList.iterator(); iter.hasNext();) {
          				MasReligion masReligion = (MasReligion) iter.next();
          				if(opdObg.getReligionWife() != null){
          				if(masReligion.getId().equals(opdObg.getReligionHusband().getId())){
          %>
	<option value="<%=masReligion.getId() %>" selected="selected"><%=masReligion.getReligionName() %></option>
	<%		
         			}else{%>
         				<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>	
         			<%}
          				}else{%>
      					
      					<option value="<%=masReligion.getId() %>"><%=masReligion.getReligionName() %></option>	
      					
      				<%}
         		 }
          		}
         %>
</select>
<div class="clear"></div>

<label>Occupation</label>
<select	name="<%=OCCUPATION_WIFE %>" >
	<option value="0">Select</option>
	<%
          		if(masOccupationList != null){ 	
          			for (Iterator iter = masOccupationList.iterator(); iter.hasNext();) {
          				MasOccupation masOccupation = (MasOccupation) iter.next();
          				if(opdObg.getOccupationWife() != null){
              				if(masOccupation.getId().equals(opdObg.getOccupationWife().getId())){
          %>
	<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>
	<%		
         			}else{%>
         				<option value="<%=masOccupation.getId() %>" selected="selected"><%=masOccupation.getOccupationName() %></option>	
         			<%}
          				}else{%>
      					
      					<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>	
      					
      				<%}
         		 }
          		}
         %>
</select>  <select name="<%=OCCUPATION_HUSBAND %>" tabindex=1>
	<option value="0">Select</option>
	<%
          		if(masOccupationList != null){ 	
          			for (Iterator iter = masOccupationList.iterator(); iter.hasNext();) {
          				MasOccupation masOccupation = (MasOccupation) iter.next();
          				if(opdObg.getOccupationHusband() != null){
              				if(masOccupation.getId().equals(opdObg.getOccupationHusband().getId())){
          %>
	<option value="<%=masOccupation.getId() %>" selected="selected"><%=masOccupation.getOccupationName() %></option>
	<%		
         			}else{%>
         				<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>	
         			<%}
          				}else{%>
      					
      					<option value="<%=masOccupation.getId() %>"><%=masOccupation.getOccupationName() %></option>	
      					
      				<%}
         		 }
          		}
         %>
</select>
<div class="clear"></div>

<label>Accommodation Type</label>
<input	name="<%=ACCOMMODATION_TYPE %>" maxlength="15" type="text" value="<%=opdObg.getTypeOfAccommodation() != null?opdObg.getTypeOfAccommodation():""%>">
<label style="width:62px">Privacy</label>

<%if(opdObg.getPrivacy() != null && opdObg.getPrivacy().equalsIgnoreCase("y") ){ %>
<label class="auto">Yes</label>
<input name="<%=PRIVACY %>"	type="radio" class="checkboxMargin" value="y" checked="checked"/>
<label class="auto">NO</label>
<input	name="<%=PRIVACY %>" type="radio" class="checkboxMargin" value="n" />
<%}else{ %>
<label class="auto">Yes</label>
<input name="<%=PRIVACY %>"	type="radio" class="checkboxMargin" value="y" />
<label class="auto">NO</label>
<input	name="<%=PRIVACY %>" type="radio" class="checkboxMargin" value="n" />
<%} %>
<div class="clear"></div>
</div>
</div>
<!--Block Two Ends--> <!--Block Three Starts-->
<div class="division"></div>
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('COMPLAINTS')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">COMPLAINTS</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title2">
<div class="indArrow"></div>
<div class="Block">
<h4 style="float:left; width:157px;">Infertility</h4>
<div class="clear"></div>
<label>Primary: Yrs</label>
<input	name="<%=INFERTILITY_PRIMARY_YRS %>" maxlength="5" type="text" value="<%=opdObg.getInfertilityPrimaryYrs() != null?opdObg.getInfertilityPrimaryYrs():""%>">
<label>Secondary:Yrs</label>
<input name="<%=INFERTILITY_SECONDARY_YRS %>" maxlength="5"	type="text" value="<%=opdObg.getInfertilitySecondaryYrs() != null?opdObg.getInfertilitySecondaryYrs():""%>">
<label>Hypomenorrohea</label>
<input name="<%=HYPOMENRROHEA %>"	maxlength="5" type="text"  value="<%=opdObg.getHypomenorrohea() != null?opdObg.getHypomenorrohea():""%>"/>

<div class="clear"></div>
<label>Yrs</label>
<input	name="<%=HYPOMENRROHEA_YRS %>" maxlength="5" type="text" value="<%=opdObg.getHypomenorroheaYrs() != null?opdObg.getHypomenorroheaYrs():""%>">
<label>Oligomenorrhoea:Yrs</label>
<input name="<%=OLIGOMEORRHOEA_YRS %>" maxlength="5" type="text" value="<%=opdObg.getOligomenorrhoeaYrs() != null?opdObg.getOligomenorrhoeaYrs():""%>">
<label> Galactorrhoea</label>
<input name="<%=GALACTORRHOEA %>"	maxlength="15" type="text" value="<%=opdObg.getGalactorrhoea() != null?opdObg.getGalactorrhoea():""%>"/>

<div class="clear"></div>
<label>Yrs</label>
<input	name="<%=GALACTORRHOEA_YRS %>" maxlength="5" type="text" value="<%=opdObg.getGalactorrhoeaYrs() != null?opdObg.getGalactorrhoeaYrs():""%>">
<label>Hirsutism: Yrs</label>
<input name="<%=HIRSUTISM_YRS %>" maxlength="5" type="text" value="<%=opdObg.getHirsutismYrs() != null?opdObg.getHirsutismYrs():""%>">
<label>Leucorrhoea</label>
<input name="<%=LEUCORRHOEA %>"	maxlength="15" type="text" value="<%=opdObg.getLeucorrhoea() != null?opdObg.getLeucorrhoea():""%>" />

<div class="clear"></div>
<label>Pruritis Valve</label>
<input name="<%=PRURITIS_VALUE %>" maxlength="15" type="text" value="<%=opdObg.getPruritisValue() != null?opdObg.getPruritisValue():""%>">
<label>Backaches</label>
<input name="<%=BACKACHES %>" maxlength="15" type="text"  value="<%=opdObg.getBackaches() != null?opdObg.getBackaches():""%>"/>
<label>Dysmenorrhoea</label>
<input	name="<%=DYSMENORRHOEA %>" maxlength="15" type="text" value="<%=opdObg.getDysmenorrhoea() != null?opdObg.getDysmenorrhoea():""%>">
<div class="clear"></div>
</div>
</div>
<!--Block Three Ends--> <!--Block Four Ends-->

<div class="division"></div>
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('MENSTRUALl')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">MENSTRUALL</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title3">
<div class="indArrow"></div>
<div class="Block">
<label>Menarche YRS</label>
<input name="<%=MENARCHE_YRS %>" maxlength="5" type="text" value="<%=opdObg.getMenarcheYrs() != null?opdObg.getMenarcheYrs():""%>">
<label>Past MC</label>
<input	name="<%=PAST_MC %>" maxlength="15" type="text" value="<%=opdObg.getPastMc() != null?opdObg.getPastMc():""%>">
<label>Present MC</label>
<input name="<%=PRESENT_MC %>" maxlength="15" type="text" value="<%=opdObg.getPresentMc() != null?opdObg.getPresentMc():""%>">
<div class="clear"></div>

<label>LMP</label>
<input name="<%=LMP %>" maxlength="15" type="text" value="<%=opdObg.getLmp() != null?opdObg.getLmp():""%>">
<label>PMP1</label>
<input name="<%=PMP_ONE %>" maxlength="15" type="text" value="<%=opdObg.getPmpOne() != null?opdObg.getPmpOne():""%>">
<label>PMP2</label>
<input name="<%=PMP_TWO %>" maxlength="15" type="text" value="<%=opdObg.getPmpTwo() != null?opdObg.getPmpTwo():""%>">
<div class="clear"></div>
</div>
</div>
<!--Block Four Ends--> <!--Block Five Ends-->

<div class="division"></div>
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('PAST SURGICAL HISTORY')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">PAST SURGICAL HISTORY</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title4">
<div class="indArrow"></div>
<div class="Block">
<label>Diagnostic Scopy</label>
<input name="<%=DIAGNOSTIC_SCOPY %>"	maxlength="20" type="text" value="<%=opdObg.getDiagnosticScopy() != null?opdObg.getDiagnosticScopy():""%>">
<label>Tubal Surgery</label>
<input name="<%=TUBAL_SURFERY %>" maxlength="20" type="text" value="<%=opdObg.getTubalSurgery() != null?opdObg.getTubalSurgery():""%>">
<label>Exploratory Lap</label>
<input name="<%=EXPLORATORY_LAP %>"	maxlength="20" type="text" value="<%=opdObg.getExploratoryLaparotomy() != null?opdObg.getExploratoryLaparotomy():""%>">
<div class="clear"></div>
<label>Operative Scopy</label>
<input name="<%=OPERATIVE_SCOPY %>" maxlength="20" type="text" value="<%=opdObg.getOperativeScopy() != null?opdObg.getOperativeScopy():""%>">
<div class="clear"></div>
<%
%>
</div>
</div>

<div class="division"></div>
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('Past Medical History')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Past Medical History</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title5">
<div class="indArrow"></div>
<div class="Block">
<label style="margin-left:341px;background:none;box-shadow:none;">Personal</label>
<label style="margin-left:200px;background:none;box-shadow:none;">Family</label>
<div class="clear"></div>
<label>Diabetes Personal</label><label></label> 
<input name="<%=DIABETES_PERSONAL %>" maxlength="20" type="text" value="<%=opdObg.getDiabetesPersonal() != null?opdObg.getDiabetesPersonal():""%>">
	<label></label>
<input name="<%=DIABETES_FAMILY %>" maxlength="20" type="text" value="<%=opdObg.getDiabetesFamily() != null?opdObg.getDiabetesFamily():""%>">
<div class="clear"></div>

<label>Hypertension</label><label></label> <input
	name="<%=HYPERTENSION_PERSONAL %>" maxlength="20" type="text" value="<%=opdObg.getHypertensionPersonal() != null?opdObg.getHypertensionPersonal():""%>">
	<label></label>
<input name="<%=HYPERTENSION_FAMILY %>" maxlength="20" type="text" value="<%=opdObg.getHypertensionFamily() != null?opdObg.getHypertensionFamily():""%>">
<div class="clear"></div>

<label>Tuberculosis</label><label></label> <input
	name="<%=TUBERCULOSIS_PERSONAL %>" maxlength="20" type="text" value="<%=opdObg.getTuberculosisPersonal() != null?opdObg.getTuberculosisPersonal():""%>"> <label></label>
<input name="<%=TUBERCULOSIS_FAMILY %>" maxlength="20" type="text" value="<%=opdObg.getTuberculosisFamily() != null?opdObg.getTuberculosisFamily():""%>">
<div class="clear"></div>

<label> </label><label>Pulmonary</label> <input
	name="<%=PULMONARY_PERSONAL %>" maxlength="20" type="text" value="<%=opdObg.getPulmonaryPersonal() != null?opdObg.getPulmonaryPersonal():""%>"><label></label>
<input name="<%=PULMONARY_FAMILY %>" maxlength="20" type="text" value="<%=opdObg.getPulmonaryFamily() != null?opdObg.getPulmonaryFamily():""%>">
<div class="clear"></div>

<label></label><label>Abdominal</label> <input
	name="<%=ABDOMINAL_PERSONAL %>" maxlength="20" type="text" value="<%=opdObg.getAbdominalPersonal() != null?opdObg.getAbdominalPersonal():""%>"><label></label>
<input name="<%=ABDOMINAL_FAMILY%>" maxlength="20" type="text" value="<%=opdObg.getAbdominalFamily() != null?opdObg.getAbdominalFamily():""%>">
<div class="clear"></div>

<label>Thyroid <span></span></label><label></label> <input
	name="<%=THYROID_PERSONAL %>" maxlength="20" type="text" value="<%=opdObg.getThyroidPersonal() != null?opdObg.getThyroidPersonal():""%>"><label></label>
<input name="<%=THYROID_FAMILY %>" maxlength="20" type="text" value="<%=opdObg.getThyroidFamily() != null?opdObg.getThyroidFamily():""%>">
<div class="clear"></div>

<label>Others <span></span></label><label></label> <input
	name="<%=OTHERS_PERSONAL %>" maxlength="25" type="text" value="<%=opdObg.getOthersPersonal() != null?opdObg.getOthersPersonal():""%>"><label></label>
<input name="<%=OTHERS_FAMILY %>" maxlength="25" type="text" value="<%=opdObg.getOthersFamily() != null?opdObg.getOthersFamily():""%>">
<div class="clear"></div>
</div>
</div>
<!--Block One Ends--> <!--Block Two Starts-->
<div class="division"></div>
<div class="clear"></div>

<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('OBSTETRIC HISTORY')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">OBSTETRIC HISTORY</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title6">
<div class="indArrow"></div>
<div class="Block">
<label>Normal Delivery</label> 
<input name="<%=NORMAL_DELIVERY %>" maxlength="20" type="text" value="<%=opdObg.getNormalDelivery() != null?opdObg.getNormalDelivery():""%>">
	<label>Ectopic</label>
	 <input name="<%=ECTOPIC %>" maxlength="20" type="text" value="<%=opdObg.getEctopic() != null?opdObg.getEctopic():""%>">
	 <label>Abortion</label>
<input name="<%=ABORTION%>" maxlength="9" validate="Abortion,num,no" type="text" value="<%=opdObg.getAAbortion() != null?opdObg.getAAbortion():""%>">
<div class="clear"></div>
<label class="auto">Premature Delivery Baby Alive/Dead Still Births Fresh/Macerated</label> 
<input	name="<%=PREMATURE_DELIVERY %>"	value="<%=opdObg.getPrematureDeliveryBabyAliveDead() != null?opdObg.getPrematureDeliveryBabyAliveDead():"" %>" maxlength="5"	validate="Still Births,num,no" type="text" />
<div class="clear"></div>
</div>
</div>
<!--Block Two Ends--> 
<!--Block Three Ends-->
<div class="division"></div>
<div class="clear"></div>

<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('SEXUAL HISTORY')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">SEXUAL HISTORY</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title7">
<div class="indArrow"></div>
<div class="Block">
<label>Dyspareunia</label>
<input name="<%= DYSPAREUNIA%>" maxlength="20" type="text" value="<%=opdObg.getDyspareunia() != null?opdObg.getDyspareunia():""%>">
<label class="auto">Awareness of Fertile Period</label>
 <input name="<%=AWARENESS %>" maxlength="5" type="text" value="<%=opdObg.getAwarenessOfFertilePeriod() != null?opdObg.getAwarenessOfFertilePeriod():""%>">
<label>Trying to conceive for</label> 
<input name="<%=TRYING_TO_CONCERIVE_FOR %>" maxlength="5" type="text" value="<%=opdObg.getTryingToConceiveFor() != null?opdObg.getTryingToConceiveFor():""%>">
<div class="clear"></div>
<label>Frequency of IC</label>
 <input name="<%=FREQUENCY_OF_IC %>" maxlength="10" type="text" value="<%=opdObg.getFrequencyOfIc() != null?opdObg.getFrequencyOfIc():""%>"><label
	class="smallAuto">/week for last 6 months</label>
<div class="clear"></div>
</div>
</div>

<!--Block Three Ends--> <!--Block Four Ends-->
<div class="division"></div>
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('CLINICAL EXAMINATION')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">CLINICAL EXAMINATION</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title8">
<div class="indArrow"></div>
<div class="Block">
<h4 class="h4style">GENERAL EXAMINATION</h4>
<div class="clear"></div>
<h4>General Apperance</h4> 
<div class="clear"></div>
<label>Height</label>
<input name="<%=GENERNAL_APPERANCE_HEIGHT %>"	validate="General Apperance Height,num,no" maxlength="9" type="text" value="<%=opdObg.getGeneralAppearanceHeight() != null?opdObg.getGeneralAppearanceHeight():""%>" >
<label>Width</label> 
<input name="<%= GENERNAL_APPERANCE_WIDTH%>" validate="General Apperance Weight,num,no" maxlength="9" type="text" value="<%=opdObg.getGeneralAppearanceWeight() != null?opdObg.getGeneralAppearanceWeight():""%>" >
<label class="auto">Secondary Sexual Characters</label> 
<input name="<%=SECONDARY_SEXUAL_CHARACTERS %>" maxlength="20" type="text" value="<%=opdObg.getSecondarySexualCharacters() != null?opdObg.getSecondarySexualCharacters():""%>" >

<div class="clear"></div>
<label>Neck Lymph Glands</label> 
<input name="<%=NECK_LYMPH_GLANDS %>" maxlength="20" type="text" value="<%=opdObg.getNeckLymphGlands() != null?opdObg.getNeckLymphGlands():""%>" >
<label>Thyroid</label>
<input name="<%=THYROID %>" maxlength="20" type="text" value="<%=opdObg.getThyroid() != null?opdObg.getThyroid():""%>" >

<div class="clear"></div>
<label class="medium">C.V.S</label>
<input name="<%=CVS %>" maxlength="20" class="small" type="text" value="<%=opdObg.getCVS() != null?opdObg.getCVS():""%>" > 
<label class="medium">B.P</label>
 <input name="<%=B_P%>" maxlength="6" class="small" type="text"  value="<%=opdObg.getBP() != null?opdObg.getBP():""%>" >
 <label class="medium">Pulse</label>
  <input name="<%=PULSE %>" validate="pulse,num,no" class="small" maxlength="9" type="text"  value="<%=opdObg.getPulse() != null?opdObg.getPulse():""%>" >
<label class="medium">RS</label>
<input name="<%=RS%>" maxlength="20" type="text" class="small" value="<%=opdObg.getRs() != null?opdObg.getRs():""%>" >
<label class="medium">CNS</label>
<input name="<%=CNS%>" maxlength="20" type="text" class="small" value="<%=opdObg.getCns() != null?opdObg.getCns():""%>" >
<div class="clear"></div>
</div>
</div>

<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('Endocrine Status')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Endocrine Status</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title9">
<div class="indArrow"></div>
<div class="Block">
<label>Hair Distribution</label> 
<input	name="<%=HAIR_DISTRIBUTION %>" maxlength="20" type="text" value="<%=opdObg.getHairDistribution() != null?opdObg.getHairDistribution():""%>">
<label>Breast Development</label> 
<input	name="<%=BREAST_DEDVELOPMENT %>" maxlength="20" type="text" value="<%=opdObg.getBreastDevelopment() != null?opdObg.getBreastDevelopment():""%>">
<label>Galactorrhoea</label> 
<input	name="<%=GALACTORRHOEA_ENDORICE_STATUS %>" maxlength="20" type="text"  value="<%=opdObg.getEndocrineStatusGalactorrhoea() != null?opdObg.getEndocrineStatusGalactorrhoea():""%>"/>

<div class="clear"></div>
<label>Obesity</label> 
<input name="<%=OBESITY %>"	maxlength="20" type="text" value="<%=opdObg.getObesity() != null?opdObg.getObesity():""%>">
<label class="heightAuto">Pigmentation/Abdominal Striae</label> 
<input name="<%=PIGMENTATION_ABODOMINAL_STRIAE %>" maxlength="20" type="text" value="<%=opdObg.getPigmentationAbdominalStriae() != null?opdObg.getPigmentationAbdominalStriae():""%>"/>
<label>Acne</label> <input name="<%=ACNE %>" maxlength="20" type="text" value="<%=opdObg.getAcne() != null?opdObg.getAcne():""%>" />
<div class="clear"></div>
<label>Others</label> 
<input	name="<%=OTHERS_ENDORICE_STATUS %>" maxlength="20" type="text" value="<%=opdObg.getOthers() != null?opdObg.getOthers():""%>" />
<div class="clear"></div>
</div>
</div>
<!--Block one Ends--> 
<!--Block Two Starts-->
<div class="division"></div>
<div class="clear"></div>

<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('GYNAECOLOGICAL EXAMINATIONAL')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">GYNAECOLOGICAL EXAMINATIONAL</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title10">
<div class="indArrow"></div>
<div class="Block">
<label style="margin-left:172px;width:178px;background:none;box-shadow:none;">Clitoris</label> 
<label style="width:178px;background:none;box-shadow:none;">Majopra</label>
<label style="width:178px;background:none;box-shadow:none;">Minora</label>
<div class="clear"></div>
<label>P.S </label> 
<input name="<%=P_S_CLITORIS %>" maxlength="20" type="text" value="<%=opdObg.getPSClitoris() != null?opdObg.getPSClitoris():""%>">
<input name="<%=P_S_MAJOPRA %>"	maxlength="20" type="text" value="<%=opdObg.getPSLabiaMajopra() != null?opdObg.getPSLabiaMajopra():""%>">
<input name="<%=P_S_MINORA %>"	maxlength="20" type="text" value="<%=opdObg.getPSLabiaMinora() != null?opdObg.getPSLabiaMinora():""%>">
<div class="clear"></div>
<label>P.V </label>
<input name="<%=P_V_CLITORIS %>"	maxlength="20" type="text" value="<%=opdObg.getPVClitoris() != null?opdObg.getPVClitoris():""%>">
<input name="<%=P_V_MAJOPRA %>"	maxlength="20" type="text" value="<%=opdObg.getPVLabiaMajopra() != null?opdObg.getPVLabiaMajopra():""%>">
<input name="<%=P_V_MINORA %>" maxlength="20" type="text" value="<%=opdObg.getPVLabiaMinora() != null?opdObg.getPVLabiaMinora():""%>">
<div class="clear"></div>
</div>
</div>
<!--Block Two Ends--> 
<!--Block Three Starts-->
<div class="division"></div>
<div class="clear"></div>

<%-- <div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('INVESTIAGATIONS')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">INVESTIAGATIONS</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title11">
<div class="indArrow"></div>
<div class="clear"></div>
<label>Hemoglobin </label> <label></label> 
<input name="<%=HEMOGLOBIN %>" maxlength="7" type="text">
<label>TLC</label>
<label></label> 
<input name="<%=TLC %>" maxlength="20" type="text">
<div class="clear"></div>
<label>DLC </label> 
<label></label> 
<input name="<%=DLC %>"	maxlength="20" type="text">
<label>ESR</label> 
<label></label> 
<input	name="<%=ESR %>" maxlength="20" type="text">
<div class="clear"></div>
<label class="">&nbsp;</label>
<label class="medium">Wife</label> 
<label>Husband</label>

<div class="clear"></div>
<label>Blood Group </label><label></label> 
<input name="<%=BLOOD_GROUP_HUSBAND %>" maxlength="10" type="text">
<label></label>
<input name="<%=BLOOD_GROUP_WIFE %>" maxlength="10" type="text">
<div class="clear"></div>
<label>Blood Sugar </label>
<label></label> 
<input	name="<%=BLOOD_SUGAR_HUSBAND %>" maxlength="10" type="text">
<label></label>
<input name="<%=BLOOD_SUGAR_WIFE %>" maxlength="10" type="text">
<div class="clear"></div>
<label>VDRL</label><label></label> 
<select name="<%=VDRL_HUSBAND %>">
<option value="">select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select> 
<label></label> 
<select name="<%=VDRL_WIFE %>">
<option value="">select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select>
<div class="clear"></div>
<label>Urine analysis</label><label></label> 
<select	name="<%=URINE_ANALYSIS %>">
<option value="">select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select> 
<label>Specify</label> 
<input name="<%=SPECIFICATION %>" maxlength="20" type="text">
<div class="clear"></div>
<label>HIV</label>
<label></label> 
<select name="<%=HIV_HUSBAND %>">
<option value="">select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select> 
<label></label> 
<select name="<%=HIV_WIFE %>">
<option value="">select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select>
<div class="clear"></div>
<label>HbsAg</label>
<label></label> 
<select name="<%=HBSAG_HUSBAND %>">
<option value="">select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select> 
<label></label> 
<select name="<%=HBSAG_WIFE %>">
<option value="">select</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select>

<div class="clear"></div></div> --%>

<div class="division"></div>
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('HORMONAL TESTS')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">HORMONAL TESTS</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title12">
<div class="indArrow"></div>
<div class="Block">
<label style="margin-left:172px; width:178px;background:none;box-shadow:none;">Wife</label>
<label style="width:178px;background:none;box-shadow:none;">Husband</label>
<div class="clear"></div>
<label>T3 </label>
<input name="<%=T_THREE_WIFE %>"maxlength="20" type="text" value="<%=opdObg.getTThreeWife() != null?opdObg.getTThreeWife():""%>"><label></label> 
<input	name="<%=T_THREE_HUSBAND %>" maxlength="20" type="text" value="<%=opdObg.getTThreeHusband() != null?opdObg.getTThreeHusband():""%>" >
<div class="clear"></div>
<label>T4 </label>
<input name="<%=T_FOUR_WIFE %>"	maxlength="20" type="text" value="<%=opdObg.getTFourWife() != null?opdObg.getTFourWife():""%>"><label></label> 
<input	name="<%=T_FOUR_HUSBAND %>" maxlength="20" type="text" value="<%=opdObg.getTFourHusband() != null?opdObg.getTFourHusband():""%>">
<div class="clear"></div>
<label>TSH </label>
<input name="<%=TSH_WIFE %>" maxlength="20" type="text" value="<%=opdObg.getTshHusband() != null?opdObg.getTshHusband():""%>"><label></label> 
<input	name="<%=TSH_HUSBAND %>" maxlength="20" type="text" value="<%=opdObg.getTshWife() != null?opdObg.getTshWife():""%>">
<div class="clear"></div>
<label>S Prolactin </label>
<input	name="<%=S_PROLACTIN_WIFE %>" maxlength="20" type="text" value="<%=opdObg.getSProlactinWife() != null?opdObg.getSProlactinWife():""%>">
<label></label>
<input name="<%=S_PROLACTIN_HUSBAND %>" maxlength="20" type="text" value="<%=opdObg.getSProlactinHusband() != null?opdObg.getSProlactinHusband():""%>">
<div class="clear"></div>
<label>FSH </label>
<input name="<%=FSH_WIFE %>" maxlength="20" type="text" value="<%=opdObg.getFshHusband() != null?opdObg.getFshHusband():""%>"><label></label>
 <input name="<%=FSH_HUSBAND %>" maxlength="20" type="text" value="<%=opdObg.getFshWife() != null?opdObg.getFshWife():""%>">
<div class="clear"></div>

<label>LH </label>
 <input name="<%=LH_WIFE %>" maxlength="20" type="text" value="<%=opdObg.getLhHusband() != null?opdObg.getLhHusband():""%>"><label></label>
  <input name="<%=LH_HUSBAND %>" maxlength="20" type="text" value="<%=opdObg.getLhHusband() != null?opdObg.getLhHusband():""%>">
<div class="clear"></div>

<label>S Testosterone </label>
<input name="<%=S_TESTOSTERONE_WIFE %>" maxlength="20" type="text" value="<%=opdObg.getSTestosteroneWife() != null?opdObg.getSTestosteroneWife():""%>"><label></label>
<input name="<%=S_TESTOSTERONE_HUSBAND %>" maxlength="20" type="text" value="<%=opdObg.getSTestosteroneHusband() != null?opdObg.getSTestosteroneHusband():""%>">
<div class="clear"></div>

<label>DHES </label>
<input name="<%=DHES_WIFE %>" maxlength="20" type="text" value="<%=opdObg.getDhesHusband() != null?opdObg.getDhesHusband():""%>"> 
<input name="<%=DHES_HUSBAND %>" maxlength="20" type="text" value="<%=opdObg.getDhesWife() != null?opdObg.getDhesWife():""%>">
<div class="clear"></div>
</div>
</div>
<!--Block one Ends--> <!--Block Two Starts-->
<div class="division"></div>
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('ULTRASONOGRAPHY')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">ULTRASONOGRAPHY</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title13">
<div class="indArrow"></div>
<div class="Block">
<label class="auto"><U>Test of Tubal Patency</U> </label>
<div class="clear"></div>
<h4 class="h4style">Hysterosalpingography</h4>
<div class="clear"></div>
<label>Uterus </label> <label></label> 
<input name="<%=UTERUS_HYSTEROSALIAGOGRAPHY %>" maxlength="20" type="text" value="<%= opdObg.getUterusHysterosaliagography() != null? opdObg.getUterusHysterosaliagography():""%>">
<div class="clear"></div>
<label>Tubes </label><label>R</label>
 <input name="<%=TUBES_RIGHT %>" maxlength="20" type="text" value="<%= opdObg.getTubesRight() != null? opdObg.getTubesRight():""%>">
 <label>L</label>
  <input name="<%=TUBES_LEFT %>" maxlength="20" type="text" value="<%= opdObg.getTubesLeft() != null? opdObg.getTubesLeft():""%>">
<div class="clear"></div>
<h4 class="h4style">Hysteroscopy</h4>
<div class="clear"></div>
<label>Endometrical Cavity </label> <label></label> 
<input name="<%=ENDOMETRICAL %>" maxlength="20" type="text" value="<%= opdObg.getTubesLeft() != null? opdObg.getTubesLeft():""%>">
<label>Cornual Openings </label>
 <input name="<%=CORNUAL_OPENING %>" maxlength="20" type="text" value="<%= opdObg.getTubesLeft() != null? opdObg.getTubesLeft():""%>">
<div class="clear"></div>
<h4 class="h4style">Endoscopy</h4>
<div class="clear"></div>
<label>Uterus </label> <label></label> 
<input name="<%=UTERUS %>" maxlength="20" type="text" value="<%= opdObg.getUterus()!= null? opdObg.getUterus():""%>">
<label>Pelvis </label>
 <input name="<%=PELVIS_ENDOSCOPY_UTERUS %>" maxlength="20" type="text"  value="<%= opdObg.getPelvisEndosocopyUterus()!= null? opdObg.getPelvisEndosocopyUterus():""%>">
<div class="clear"></div>
<label>Tubes </label> <label>R</label>
 <input name="<%=TUBES_RIGHT_ENDOSCOPY %>" maxlength="20" type="text" value="<%= opdObg.getTubesR()!= null? opdObg.getTubesR():""%>">
 <label>L</label>
<input name="<%=TUBES_LEFT_ENDOSCOPY %>" maxlength="20" type="text" value="<%= opdObg.getTubesL()!= null? opdObg.getTubesL():""%>">
<div class="clear"></div>
<label>Ovaries </label> <label>R</label>
 <input name="<%=OVERIES_RIGHT_ENDOSCOPY %>" maxlength="20" type="text" value="<%= opdObg.getOvariesR()!= null? opdObg.getOvariesR():""%>">
 <label>L</label>
<input name="<%=OVERIES_LEFT_ENDOSCOPY %>" maxlength="20" type="text" value="<%= opdObg.getOvariesL()!= null? opdObg.getOvariesL():""%>">
<div class="clear"></div>
<label>Pelvis </label> <label></label> <input
	name="<%=PELVIS_ENDOSCOPY %>" maxlength="20" type="text" value="<%= opdObg.getPelvisEndosocopy()!= null? opdObg.getPelvisEndosocopy():""%>">
<div class="clear"></div>
<h4 class="h4style">Endometrical Biposy</h4>
<div class="clear"></div>

<label>Date</label> 
<%if(opdObg.getObgDate()==null){%>
<input type="text" onblur="checkDate();" class="date" id="startDateId" name="<%=DATE_OBG %>" value="" readonly="readonly" MAXLENGTH="30" />
	 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onClick="setdate('',document.opdMain.<%=DATE_OBG%>,event)" onblur="checkDate();" /> 
	<%}else{%> 
	<input type="text" onblur="checkDate();" value="<%=HMSUtil.changeDateToddMMyyyy(opdObg.getObgDate()) %>" class="date" id="startDateId" name="<%=DATE_OBG %>" value="" readonly="readonly" MAXLENGTH="30" />
	 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="setdate('',document.opdMain.<%=DATE_OBG%>,event)" onblur="checkDate();" />
	  <%} %>
<label>Days of Cycle</label>
<input name="<%=DAYS_OF_CYCLE %>" validate="Days of Cycle,num,no" maxlength="9" type="text" value="<%= opdObg.getDaysOfCycle()!= null? opdObg.getDaysOfCycle():""%>">
<label>Proliferative</label>
<input name="<%=PROLIFERATIVE %>" maxlength="20" type="text" value="<%= opdObg.getProliferative()!= null? opdObg.getProliferative():""%>">

<div class="clear"></div>
<label>Secretory</label>
<input name="<%=SECRETORY %>" maxlength="20" type="text"  value="<%= opdObg.getSecretory()!= null? opdObg.getSecretory():""%>"/>
<label>Dating</label> <label></label> 
<input name="<%=DATING %>" maxlength="20" type="text" value="<%= opdObg.getDating()!= null? opdObg.getDating():""%>" /> 
<div class="clear"></div>
</div>
</div>

<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">
<!--Block Five Ends--> <%}}else{ %>

<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('SOCIOECONOMIC HISTORY')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">SOCIOECONOMIC HISTORY</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title1">
<div class="indArrow"></div>
<div class="Block">
<label style="margin-left:171px;background:none; box-shadow:none;">Wife</label><label style="margin-left:29px;background:none; box-shadow:none;">Husband</label>

<div class="clear"></div>
<label>Education</label> <input
	name="<%=EDUCATION_WIFE%>" maxlength="20" type="text">
<input name="<%=EDUCATION_HUSBAND %>" maxlength="20" type="text">
<div class="clear"></div>

<label>Religion<span></span></label> <select
	name="<%=RELIGION_WIFE %>" >
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
</select>  <select name="<%=RELIGION_HUSBAND %>" >
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
	name="<%=OCCUPATION_WIFE %>" >
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
</select>  <select name="<%=OCCUPATION_HUSBAND %>" >
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
<label style="width:62px">Privacy</label>
<label class="auto">Yes</label>
<input name="<%=PRIVACY %>" type="radio" value="y"	class="checkboxMargin" />
 <label class="auto">No</label> <input name="<%=PRIVACY %>"
	type="radio" value="n" class="checkboxMargin" />
<div class="clear"></div>
</div>
</div>
<!--Block Two Ends--> <!--Block Three Starts-->

<div class="clear"></div>

<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('COMPLAINTS')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">COMPLAINTS</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title2">
<div class="indArrow"></div>
<div class="Block">
<h4 style="float:left; width:157px;">Infertility</h4>
 <input name="" type="text" style="visibility:hidden;height:17px;" />
 <div class="clear"></div>
  <label>Primary: Yrs</label>
   <input name="<%=INFERTILITY_PRIMARY_YRS %>" maxlength="5" type="text">
   <label>Secondary:Yrs</label>
    <input name="<%=INFERTILITY_SECONDARY_YRS %>" maxlength="5" type="text">
<label>Hypomenorrohea</label>
 <input name="<%=HYPOMENRROHEA %>" maxlength="5" type="text" /> 
 <div class="clear"></div>
 
 <label>Yrs</label>
  <input name="<%=HYPOMENRROHEA_YRS %>" maxlength="5" type="text">
  <label>Oligomenorrhoea:Yrs</label>
   <input name="<%=OLIGOMEORRHOEA_YRS %>" maxlength="5" type="text">
<label> Galactorrhoea</label>
<input name="<%=GALACTORRHOEA %>" maxlength="5" type="text" />
<div class="clear"></div>
	
<label>Yrs</label>
<input name="<%=GALACTORRHOEA_YRS %>" maxlength="5" type="text">
<label>Hirsutism: Yrs</label>
<input name="<%=HIRSUTISM_YRS %>" maxlength="5" type="text">
<label>Leucorrhoea</label>
<input name="<%=LEUCORRHOEA %>" maxlength="15" type="text" />
<div class="clear"></div>

<label>Pruritis Valve</label>
<input name="<%=PRURITIS_VALUE %>" maxlength="15" type="text">
<label>Backaches</label>
<input name="<%=BACKACHES %>" maxlength="15" type="text" />
<label>Dysmenorrhoea</label>
<input name="<%=DYSMENORRHOEA %>" maxlength="15" type="text">
<div class="clear"></div>
</div>
</div>

<!--Block Three Ends--> <!--Block Four Ends-->
<div class="division"></div>
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('MENSTRUALl')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">MENSTRUALL</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title3">
<div class="indArrow"></div>
<div class="Block">
<label>Menarche YRS:</label>
 <input name="<%=MENARCHE_YRS %>" maxlength="5" type="text">
 <label>Past MC</label>
  <input name="<%=PAST_MC %>" maxlength="15" type="text">
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
</div>

<!--Block Four Ends--> <!--Block Five Ends-->
<div class="division"></div>
<div class="clear"></div>

<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('PAST SURGICAL HISTORY')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">PAST SURGICAL HISTORY</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title4">
<div class="indArrow"></div>
<div class="Block">
<label>Diagnostic Scopy</label> <input name="<%=DIAGNOSTIC_SCOPY %>"
	maxlength="20" type="text"> <label>Tubal
Surgery</label> <input name="<%=TUBAL_SURFERY %>" maxlength="20" type="text">
<label>Exploratory Lap</label> <input name="<%=EXPLORATORY_LAP %>"
	maxlength="20" type="text">
<div class="clear"></div>	
	<label>Operative
Scopy</label> <input name="<%=OPERATIVE_SCOPY %>" maxlength="20" type="text">
<div class="clear"></div>
</div>
</div>

<div class="division"></div>
<div class="clear"></div>

<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('Past Medical History')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Past Medical History</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title5">
<div class="indArrow"></div>
<div class="Block">
<label style="margin-left:341px;background:none;box-shadow:none;">Personal</label>
<label style="margin-left:200px;background:none;box-shadow:none;">Family</label>
<div class="clear"></div>
<label>Diabetes Personal</label><label></label> <input
	name="<%=DIABETES_PERSONAL %>" maxlength="20" type="text"><label></label>
<input name="<%=DIABETES_FAMILY %>" maxlength="20" type="text">
<div class="clear"></div>

<label>Hypertension</label><label></label> <input
	name="<%=HYPERTENSION_PERSONAL %>" maxlength="20" type="text"><label></label>
<input name="<%=HYPERTENSION_FAMILY %>" maxlength="20" type="text">
<div class="clear"></div>

<label>Tuberculosis</label><label></label> <input
	name="<%=TUBERCULOSIS_PERSONAL %>" maxlength="20" type="text"><label></label>
<input name="<%=TUBERCULOSIS_FAMILY %>" maxlength="20" type="text">
<div class="clear"></div>

<label> </label><label>Pulmonary</label> <input
	name="<%=PULMONARY_PERSONAL %>" maxlength="20" type="text"><label></label>
<input name="<%=PULMONARY_FAMILY %>" maxlength="20" type="text">
<div class="clear"></div>

<label></label><label>Abdominal</label> <input
	name="<%=ABDOMINAL_PERSONAL %>" maxlength="20" type="text"><label></label>
<input name="<%=ABDOMINAL_FAMILY%>" maxlength="20" type="text">
<div class="clear"></div>

<label>Thyroid <span></span></label><label></label> <input
	name="<%=THYROID_PERSONAL %>" maxlength="20" type="text"><label></label>
<input name="<%=THYROID_FAMILY %>" maxlength="20" type="text">
<div class="clear"></div>

<label>Others <span></span></label><label></label> <input
	name="<%=OTHERS_PERSONAL %>" maxlength="25" type="text"><label></label>
<input name="<%=OTHERS_FAMILY %>" maxlength="25" type="text">
<div class="clear"></div>
</div>
</div>

<!--Block One Ends--> <!--Block Two Starts-->
<div class="division"></div>
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('OBSTETRIC HISTORY')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">OBSTETRIC HISTORY</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title6">
<div class="indArrow"></div>
<div class="Block">
<label>Normal Delivery</label> 
<input name="<%=NORMAL_DELIVERY %>" maxlength="20" type="text">

<label>Ectopic</label>
 <input name="<%=ECTOPIC %>" maxlength="20" type="text">
 <label>Abortion</label>
<input name="<%=ABORTION%>" maxlength="9" type="text" validate="Abortion,num,no">
<div class="clear"></div>
<label  class="auto">Premature Delivery Baby Alive/Dead Still Births Fresh/Macerated</label> <input name="<%=PREMATURE_DELIVERY %>"
	maxlength="20" type="text" />
<div class="clear"></div>
</div>
</div>

<!--Block Two Ends--> <!--Block Three Ends-->
<div class="division"></div>
<div class="clear"></div>

<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('SEXUAL HISTORY')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">SEXUAL HISTORY</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title7">
<div class="indArrow"></div>
<div class="Block">
<label>Dyspareunia</label> <input name="<%= DYSPAREUNIA%>"
	maxlength="20" type="text">
<label class="auto">Awareness of Fertile Period</label> <input
	name="<%=AWARENESS %>" maxlength="5" type="text">
<label>Trying to conceive for</label> <input
	name="<%=TRYING_TO_CONCERIVE_FOR %>" maxlength="5" type="text">
<div class="clear"></div>
<label>Frequency of IC</label> <input
	name="<%=FREQUENCY_OF_IC %>" maxlength="10" type="text"><label
	class="smallAuto">/week for last 6 months</label>
<div class="clear"></div>
</div>
</div>

<!--Block Three Ends--> <!--Block Four Ends-->
<div class="division"></div>
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('CLINICAL EXAMINATION')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">CLINICAL EXAMINATION</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title8">
<div class="indArrow"></div>
<div class="Block">
<h4 class="h4style">GENERAL EXAMINATION</h4>
<div class="clear"></div>
<h4>General Apperance</h4>
<div class="clear"></div>
<label>Height</label>
<input name="<%=GENERNAL_APPERANCE_HEIGHT %>" maxlength="9" type="text" validate="GENERNAL_APPERANCE_HEIGHT,num,no">
<label>Width</label>
<input name="<%= GENERNAL_APPERANCE_WIDTH%>" maxlength="9" type="text" validate="GENERNAL_APPERANCE_WEIGTH,num,no">
<label class="auto">Secondary Sexual Characters</label>
<input name="<%=SECONDARY_SEXUAL_CHARACTERS %>" maxlength="20" type="text">
<div class="clear"></div>

<label>Neck Lymph Glands</label> 
<input name="<%=NECK_LYMPH_GLANDS %>" maxlength="20" type="text">
<label>Thyroid</label> 
<input name="<%=THYROID %>" maxlength="20" type="text">

<div class="clear"></div>
<label class="medium">C.V.S</label>
<input name="<%=CVS %>" maxlength="20" type="text" class="small">
 <label class="medium">B.P</label>
  <input name="<%=B_P%>" maxlength="6" type="text" class="small">
  <label class="medium">Pulse</label>
   <input name="<%=PULSE %>" maxlength="9" type="text" validate="pulse,num,no" class="small" value="">
<label class="medium">RS</label>
 <input name="<%=RS%>" maxlength="20" type="text" class="small">
<label class="medium">CNS</label>
 <input name="<%=CNS%>" maxlength="20" type="text" class="small">
<div class="clear"></div>
</div>
</div>

<div class="division"></div>
<div class="clear"></div>

<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('Endocrine Status')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">Endocrine Status</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title9">
<div class="indArrow"></div>
<div class="Block">
<label>Hair Distribution</label> 
<input name="<%=HAIR_DISTRIBUTION %>"	maxlength="20" type="text">
<label>Breast Development</label> 
<input	name="<%=BREAST_DEDVELOPMENT %>" maxlength="20" type="text">
<label>Galactorrhoea</label>
<input name="<%=GALACTORRHOEA_ENDORICE_STATUS %>" maxlength="20" type="text" />
<div class="clear"></div>

<label>Obesity</label> 
<input name="<%=OBESITY %>" maxlength="20"	type="text">
<label class="heightAuto">Pigmentation/Abdominal Striae</label> 
<input	name="<%=PIGMENTATION_ABODOMINAL_STRIAE %>" maxlength="20" type="text" />
<label>Acne</label> 
<input name="<%=ACNE %>" maxlength="20" type="text" />
<div class="clear"></div>
<label>Others</label> 
<input name="<%=OTHERS_ENDORICE_STATUS %>"	maxlength="20" type="text" />
<div class="clear"></div>
</div>
</div>

<!--Block one Ends--> <!--Block Two Starts-->
<div class="division"></div>
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('GYNAECOLOGICAL EXAMINATIONAL')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">GYNAECOLOGICAL EXAMINATIONAL</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title10">
<div class="indArrow"></div>
<div class="Block">
<label style="margin-left:172px;width:178px;background:none;box-shadow:none;">Clitoris</label> 
<label style="width:178px;background:none;box-shadow:none;">Majopra</label>
<label style="width:178px;background:none;box-shadow:none;">Minora</label>
<div class="clear"></div>
<label>P.S </label>
<input name="<%=P_S_CLITORIS %>"	maxlength="20" type="text">
<input name="<%=P_S_MAJOPRA %>"	maxlength="20" type="text">
<input name="<%=P_S_MINORA %>"	maxlength="20" type="text">
<div class="clear"></div>
<label>P.V </label>
<input name="<%=P_V_CLITORIS %>" maxlength="20" type="text">
<input name="<%=P_V_MAJOPRA %>"	maxlength="20" type="text">
<input name="<%=P_V_MINORA %>" maxlength="20" type="text">
<div class="clear">
</div>
</div>
</div>
<!--Block Two Ends--> 
<!--Block Three Starts-->
<div class="division"></div>
<div class="clear"></div>

<%-- <div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('INVESTIAGATIONS')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">INVESTIAGATIONS</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title11">
<div class="indArrow"></div>
<div class="clear"></div>
<label>Hemoglobin </label> 

<input	name="<%=HEMOGLOBIN %>" maxlength="7" type="text">
<label>TLC</label>
 
<input name="<%=TLC %>" maxlength="20" type="text">
<div class="clear"></div>
<label>DLC </label> 

<input name="<%=DLC %>"	maxlength="20" type="text">
<label>ESR</label> 

<input	name="<%=ESR %>" maxlength="20" type="text">
<div class="clear"></div>
<div class="paddLeft55"><label>Wife</label> 
<label>Husband</label>
</div>
<div class="clear"></div>
<label>Blood Group </label>
<label></label> <input
	name="<%=BLOOD_GROUP_HUSBAND %>" maxlength="10" type="text"><label></label>
<input name="<%=BLOOD_GROUP_WIFE %>" maxlength="10" type="text">
<div class="clear"></div>

<label>Blood Sugar </label><label></label> <input
	name="<%=BLOOD_SUGAR_HUSBAND %>" maxlength="10" type="text"><label></label>
<input name="<%=BLOOD_SUGAR_WIFE %>" maxlength="10" type="text">
<div class="clear"></div>

<label>VDRL</label><label></label> <select name="<%=VDRL_HUSBAND %>">
	<option value="">select</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
</select> <label></label> <select name="<%=VDRL_WIFE %>">
	<option value="">select</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
</select>
<div class="clear"></div>


<label>Urine analysis</label><label></label> <select
	name="<%=URINE_ANALYSIS %>">
	<option value="">select</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
</select> <label>Specify</label> <input name="<%=SPECIFICATION %>" maxlength="20"
	type="text">
<div class="clear"></div>

<label>HIV</label><label></label> <select name="<%=HIV_HUSBAND %>">
	<option value="">select</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
</select> <label></label> <select name="<%=HIV_WIFE %>">
	<option value="">select</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
</select>
<div class="clear"></div>

<label>HbsAg</label><label></label> <select name="<%=HBSAG_HUSBAND %>">
	<option value="">select</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
</select> <label></label> <select name="<%=HBSAG_WIFE %>">
	<option value="">select</option>
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
</select>
<div class="clear"></div>
<div class="clear"></div></div> --%>

<div class="division"></div>
<div class="clear"></div>
<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('HORMONAL TESTS')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">HORMONAL TESTS</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title12">
<div class="indArrow"></div>
<div class="Block">
<label style="margin-left:172px; width:178px;background:none;box-shadow:none;">Wife</label>
<label style="width:178px;background:none;box-shadow:none;">Husband</label>
<div class="clear"></div>
<label>T3 </label>
<input name="<%=T_THREE_WIFE %>"
	maxlength="20" type="text"><input	name="<%=T_THREE_HUSBAND %>" maxlength="20" type="text">
<div class="clear"></div>

<label>T4 </label><input name="<%=T_FOUR_WIFE %>"
	maxlength="20" type="text"> <input
	name="<%=T_FOUR_HUSBAND %>" maxlength="20" type="text">
<div class="clear"></div>

<label>TSH </label><input name="<%=TSH_WIFE %>"
	maxlength="20" type="text"><input
	name="<%=TSH_HUSBAND %>" maxlength="20" type="text">
<div class="clear"></div>

<label>S Prolactin </label><input
	name="<%=S_PROLACTIN_WIFE %>" maxlength="20" type="text">
<input name="<%=S_PROLACTIN_HUSBAND %>" maxlength="20" type="text">
<div class="clear"></div>

<label>FSH </label><input name="<%=FSH_WIFE %>"
	maxlength="20" type="text"><input
	name="<%=FSH_HUSBAND %>" maxlength="20" type="text">
<div class="clear"></div>

<label>LH </label><input name="<%=LH_WIFE %>"
	maxlength="20" type="text"> <input
	name="<%=LH_HUSBAND %>" maxlength="20" type="text">
<div class="clear"></div>

<label>S Testosterone </label> <input
	name="<%=S_TESTOSTERONE_WIFE %>" maxlength="20" type="text">
<input name="<%=S_TESTOSTERONE_HUSBAND %>" maxlength="20" type="text">
<div class="clear"></div>

<label>DHES </label><input name="<%=DHES_WIFE %>"
	maxlength="20" type="text"><input
	name="<%=DHES_HUSBAND %>" maxlength="20" type="text">
<div class="clear"></div>
</div>
</div>

<!--Block one Ends--> <!--Block Two Starts-->
<div class="division"></div>
<div class="clear"></div>

<div class="plusDiv"><input class="plusMinus" tabindex="3" onclick="showInfertilityClinicTab('ULTRASONOGRAPHY')" name="" value="+" type="button"></div>
<div class="plusText"><h4 class="h4Tab">ULTRASONOGRAPHY</h4></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="collapasHide" id="title13">
<div class="indArrow"></div>
<div class="Block">
<label class="auto"><U>Test of Tubal Patency</U> </label>
<div class="clear"></div>
<h4 class="h4style">Hysterosalpingography</h4>
<div class="clear"></div>
<label>Uterus </label> <label></label> <input
	name="<%=UTERUS_HYSTEROSALIAGOGRAPHY %>" maxlength="20" type="text">
<div class="clear"></div>
<label>Tubes </label><label>R</label> <input name="<%=TUBES_RIGHT %>"
	maxlength="20" type="text"><label>L</label> <input
	name="<%=TUBES_LEFT %>" maxlength="20" type="text">
<div class="clear"></div>
<h4 class="h4style">Hysteroscopy</h4>
<div class="clear"></div>
<label>Endometrical Cavity </label>
  <input name="<%=ENDOMETRICAL %>" maxlength="20" type="text">
  <label>Cornual Openings </label>
   <input name="<%=CORNUAL_OPENING %>" maxlength="20" type="text">
<div class="clear"></div>
<h4 class="h4style">Endoscopy</h4>
<div class="clear"></div>
<label>Uterus </label> <label></label>
 <input name="<%=UTERUS %>" maxlength="20" type="text">
 <label>Pelvis </label>
  <input name="<%=PELVIS_ENDOSCOPY_UTERUS %>" maxlength="20" type="text">
<div class="clear"></div>
<label>Tubes </label> <label>R</label> 
<input name="<%=TUBES_RIGHT_ENDOSCOPY %>" maxlength="20" type="text">
<label>L</label>
<input name="<%=TUBES_LEFT_ENDOSCOPY %>" maxlength="20" type="text">
<div class="clear"></div>
<label>Ovaries </label> <label>R</label>
 <input name="<%=OVERIES_RIGHT_ENDOSCOPY %>" maxlength="20" type="text">
 <label>L</label>
<input name="<%=OVERIES_LEFT_ENDOSCOPY %>" maxlength="20" type="text">
<div class="clear"></div>
<label>Pelvis </label> 
 <input name="<%=PELVIS_ENDOSCOPY %>" maxlength="20" type="text">
<div class="clear"></div>
<h4 class="h4style">Endometrical Biposy</h4>
<div class="clear"></div>

<label>Date</label> 
<input type="text" onblur="checkDate();" class="date" id="startDateId" name="<%=DATE_OBG %>" value="" readonly="readonly" MAXLENGTH="30" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"  onClick="setdate('',document.opdMain.<%=DATE_OBG%>,event)" onblur="checkDate();" />
<label>Days of Cycle</label> 
<input name="<%=DAYS_OF_CYCLE %>" maxlength="9" type="text" validate="Days of Cycle,num,no">
<label>Proliferative</label> 
<input name="<%=PROLIFERATIVE %>" maxlength="20" type="text">
<div class="clear"></div>

<label>Secretory</label>
<input name="<%=SECRETORY %>" maxlength="20" type="text" />
<label>Dating</label> 
 <input name="<%=DATING %>" maxlength="20" type="text" />
<div class="clear"></div>
</div>
</div>

<!--Block Five Ends--> <%} %>
<%-- <input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>"> --%>
<%-- <input type="hidden"	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"> --%>
<%-- <input	type="hidden" name="<%=VISIT_NUMBER %>"	value="<%=visit.getVisitNo() %>">
<input type="hidden"	name="<%=OBG_ID %>" value="<%=visit.getVisitNo() %>"> --%>
<%-- <input	type="hidden" name="<%=HOSPITAL_ID %>"	value="<%=visit.getHin().getHospital().getId() %>"> --%>
<%-- <input	type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=visit.getDepartment().getId() %>"> --%>
<div class="clear"></div>
<div class="division"></div>
<%-- <input name="button" type="button"	class="button" id="btn2" value="Page 1" />
<input name="Button" type="button" class="button" value="Page 2"	onclick="submitForm('OBG','opd?method=showOBGTWOJsp&visitId=<%=visit.getId() %>');" />
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" align="right" /> --%>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
</form>
<!-- 
</div> -->

<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>