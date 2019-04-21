<%@page import="java.util.*"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.OpdObg"%>

<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
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
<!--main content placeholder starts here-->
<form name="viewObg" method="post" action="">
<div class="titleBg">
<h2>OPD OBG</h2>
</div>
<div class="clear"></div>


<!--Block One Starts--> <%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> detailsMap = new HashMap<String, Object>();

		if (request.getAttribute("map") != null) {
			map = (Map<String, Object>) request.getAttribute("map");
		}
		
		List<Visit> patientDataList = new ArrayList<Visit>();
		List<OpdObg> obgList = new ArrayList<OpdObg>();
		
		if(map.get("detailsMap") != null){
			detailsMap=(Map<String, Object>)map.get("detailsMap");
		}		
		
		if(detailsMap.get("patientDataList") != null){
			patientDataList=(List<Visit>)detailsMap.get("patientDataList");
		}	
		if(map.get("obgList") != null){
			obgList=(List<OpdObg>)map.get("obgList");
		}	
		int currentVisitId = 0;
	
		if(map.get("currentVisitId") != null){
			currentVisitId = (Integer)map.get("currentVisitId");
		}
		
		
%> <%
if(obgList.size() > 0){
	
	OpdObg opdObg = new OpdObg();
	opdObg = obgList.get(0);
	
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
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>Endocrine Status</h5>
</a>
<div class="Block" id="title1">
<div class="clear"></div>
<label>Hair Distribution</label> <input name="<%=HAIR_DISTRIBUTION %>"
	value="<%=opdObg.getHairDistribution() %>" maxlength="20" type="text">

<label>Breast Development</label> <input
	name="<%=BREAST_DEDVELOPMENT %>"
	value="<%=opdObg.getBreastDevelopment() %>" maxlength="20" type="text">

<label>Galactorrhoea</label> <input
	name="<%=GALACTORRHOEA_ENDORICE_STATUS %>"
	value="<%=opdObg.getGalactorrhoea() %>" maxlength="20" type="text" />

<div class="clear"></div>

<label>Obesity</label> <input name="<%=OBESITY %>"
	value="<%=opdObg.getObesity() %>" maxlength="20" type="text"> <label>Pigmentation/Abdominal
Striae</label> <input name="<%=PIGMENTATION_ABODOMINAL_STRIAE %>"
	value="<%=opdObg.getPigmentationAbdominalStriae() %>" maxlength="20"
	type="text" /> <label>Acne</label> <input name="<%=ACNE %>"
	value="<%=opdObg.getAcne() %>" maxlength="20" type="text" />

<div class="clear"></div>

<label>Others</label> <input name="<%=OTHERS_ENDORICE_STATUS %>"
	value="<%=opdObg.getOthers() %>" maxlength="20" type="text" />
<div class="clear"></div></div>
<!--Block one Ends--> <!--Block Two Starts-->

<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>GYNAECOLOGICAL EXAMICATIONAL</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title2">
<div class="clear"></div>
<div class="paddLeft55"><label>Clitoris</label> <label>Majopra</label>
<label>Minora</label></div>
<div class="clear"></div>
<label>P.S </label> <label></label> <input name="<%=P_S_CLITORIS %>"
	value="<%=opdObg.getPSClitoris() %>" maxlength="20" type="text">


<input name="<%=P_S_MAJOPRA %>" value="<%=opdObg.getPSLabiaMajopra() %>"
	maxlength="20" type="text"> <input name="<%=P_S_MINORA %>"
	value="<%=opdObg.getPSLabiaMinora() %>" maxlength="20" type="text">

<div class="clear"></div>
<label>P.V </label><label></label> <input name="<%=P_V_CLITORIS %>"
	value="<%=opdObg.getPVClitoris() %>" maxlength="20" type="text">

<input name="<%=P_V_MAJOPRA %>" value="<%=opdObg.getPVLabiaMajopra() %>"
	maxlength="20" type="text"> <input name="<%=P_V_MINORA %>"
	value="<%=opdObg.getPVLabiaMinora() %>" maxlength="20" type="text">

<div class="clear"></div></div>
<!--Block Two Ends--> <!--Block Three Starts-->


<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>INVESTIAGATIONS</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">
<div class="clear"></div>
<label>Hemoglobin </label> <label></label> <input
	name="<%=HEMOGLOBIN %>" value="<%=opdObg.getHemoglobin() %>"
	maxlength="7" type="text"> <label>TLC</label> <label></label> <input
	name="<%=TLC %>" value="<%=opdObg.getTlc() %>" maxlength="20"
	type="text">

<div class="clear"></div>
<label>DLC </label> <label></label> <input name="<%=DLC %>"
	value="<%=opdObg.getDlc() %>" maxlength="20" type="text"> <label>ESR</label>
<label></label> <input name="<%=ESR %>" value="<%=opdObg.getEsr() %>"
	maxlength="20" type="text">


<div class="clear"></div>
<div class="paddLeft55"><label>Wife</label><label></label> <label>Husband</label>
</div>


<div class="clear"></div>
<label>Blood Group </label><label></label> <input
	name="<%=BLOOD_GROUP_HUSBAND %>"
	value="<%=opdObg.getBloodGroupHusband() %>" maxlength="10" type="text">
<label></label> <input name="<%=BLOOD_GROUP_WIFE %>"
	value="<%=opdObg.getBloodGroupWife() %>" maxlength="10" type="text">

<div class="clear"></div>

<label>Blood Sugar </label><label></label> <input
	name="<%=BLOOD_SUGAR_HUSBAND %>"
	value="<%=opdObg.getBloodSugarHusband() %>" maxlength="10" type="text">
<label></label> <input name="<%=BLOOD_SUGAR_WIFE %>"
	value="<%=opdObg.getBloodSugarWife() %>" maxlength="10" type="text">
<div class="clear"></div>

<label>VDRL</label><label></label> <%if(opdObg.getVdrlHusband()!= null){ %>
<label class="value"><%=opdObg.getVdrlHusband() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label></label> <%if(opdObg.getVdrlWife()!= null){ %>
<label class="value"><%=opdObg.getVdrlWife() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>
<div class="clear"></div>


<label>Urine analysis</label><label></label> <%if(opdObg.getUrineAnalysis()!= null){ %>
<label class="value"><%=opdObg.getUrineAnalysis() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Specify</label> <%if(opdObg.getSpecification()!= null){ %>
<label class="value"><%=opdObg.getSpecification() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>
<div class="clear"></div>

<label>HIV</label><label></label> <%if(opdObg.getHivHusband()!= null){ %>
<label class="value"><%=opdObg.getHivHusband() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label></label> <%if(opdObg.getHivWife()!= null){ %>
<label class="value"><%=opdObg.getHivWife() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>
<div class="clear"></div>

<label>HbsAg</label><label></label> <%if(opdObg.getHbsagHusband()!= null){ %>
<label class="value"><%=opdObg.getHbsagHusband() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label></label> <%if(opdObg.getHbsagWife()!= null){ %>
<label class="value"><%=opdObg.getHbsagWife() %></label> <%}else{ %> <label
	class="value">-</label> <%} %>
<div class="clear"></div></div>

<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">

<!--Block Three Ends-->


<div class="division"></div>
<div class="clear"></div>
<!--Bottom labels starts--> <input name="prev" type="button"
	class="button" value="Prev"
	onclick="submitForm('viewObg','opd?method=viewOBGTHREE&flag=prev');">
<input name="next" type="button" class="button" value="Next"
	onclick="submitForm('viewObg','opd?method=viewOBGTHREE&flag=next');">
<input name="button" type="button" class="imagebutton" id="btn2"
	value="Page 3" /> <input name="Button" type="button" class="button"
	value="Page 4"
	onclick="submitForm('viewObg','opd?method=viewOBGFOUR&visitId=<%=currentVisitId %>');" />
<input name="Button" type="button" class="button" value="Back"
	onclick="submitForm('viewObg','opd?method=viewOBGTWO&visitId=<%=currentVisitId %>');" />
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> <%}%> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> <input type="hidden"
	name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>"> <input
	type="hidden" name="currentVisitId" value="<%=currentVisitId %>">
<!--Bottom labels ends--> <%}else{%> <span>No Record Found</span> <!--Bottom labels starts-->
<div class="clear"></div>
<input name="back" type="button" class="button" value="Back"
	onclick="submitForm('viewObg','opd?method=showOBGTHREEJsp&visitId=<%=currentVisitId %>');">

<!--Bottom labels ends--> <%} %>

<div class="division"></div><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>

<!--main content placeholder ends here-->

<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>