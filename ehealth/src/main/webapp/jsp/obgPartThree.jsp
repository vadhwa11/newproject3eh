<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdObg"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
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

		List opdObgList= new ArrayList();
		if(map.get("opdObgList") != null){
			opdObgList=(List)map.get("opdObgList");
		}	
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
<%} %>
<div class="clear"></div>
<%
if (opdObgList.size() > 0)
	{
	Iterator itr = opdObgList.iterator();
	while (itr.hasNext()) 
	{
		OpdObg opdObg = (OpdObg) itr.next();
 %> <!--Block One Starts-->
<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>Endocrine Status</h5>
</a>
<div class="Block" id="title1">
<div class="clear"></div>
<label class="large">Hair Distribution</label> 
<input	name="<%=HAIR_DISTRIBUTION %>" maxlength="20" type="text">
<label	class="large">Breast Development</label> 
<input	name="<%=BREAST_DEDVELOPMENT %>" maxlength="20" type="text">
<div class="clear"></div>
<label class="large">Galactorrhoea</label> 
<input	name="<%=GALACTORRHOEA_ENDORICE_STATUS %>" maxlength="20" type="text" />
<label class="large">Obesity</label> 
<input name="<%=OBESITY %>"	maxlength="20" type="text">
<div class="clear"></div>
<label class="large">Pigmentation/Abdominal Striae</label> 
<input name="<%=PIGMENTATION_ABODOMINAL_STRIAE %>" maxlength="20" type="text" />
<label class="large">Acne</label> <input name="<%=ACNE %>" maxlength="20" type="text" />
<div class="clear"></div>
<label class="large">Others</label> 
<input	name="<%=OTHERS_ENDORICE_STATUS %>" maxlength="20" type="text" />
<div class="clear"></div></div>
<!--Block one Ends--> 
<!--Block Two Starts-->
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
<label>P.S </label> 
<label class="vlaue">-</label> 
<input name="<%=P_S_CLITORIS %>" maxlength="20" type="text">
<input name="<%=P_S_MAJOPRA %>"	maxlength="20" type="text">
<input name="<%=P_S_MINORA %>"	maxlength="20" type="text">
<div class="clear"></div>
<label>P.V </label>
<label class="value">-</label> 
<input name="<%=P_V_CLITORIS %>"	maxlength="20" type="text">
<input name="<%=P_V_MAJOPRA %>"	maxlength="20" type="text"><input name="<%=P_V_MINORA %>" maxlength="20" type="text">
<div class="clear"></div></div>
<!--Block Two Ends--> 
<!--Block Three Starts-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>INVESTIAGATIONS</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">
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

<div class="clear"></div></div>

<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">

<!--Block Three Ends--> <%}}else{ %> <!--Block One Starts-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>Endocrine Status</h5>
</a>
<div class="Block" id="title1">
<div class="clear"></div>
<label>Hair Distribution</label> 
<input name="<%=HAIR_DISTRIBUTION %>"	maxlength="20" type="text">
<label>Breast Development</label> 
<input	name="<%=BREAST_DEDVELOPMENT %>" maxlength="20" type="text">
<label>Galactorrhoea</label>
<input name="<%=GALACTORRHOEA_ENDORICE_STATUS %>" maxlength="20" type="text" />
<div class="clear"></div>
<label>Obesity</label> 
<input name="<%=OBESITY %>" maxlength="20"	type="text">
<label>Pigmentation/Abdominal Striae</label> 
<input	name="<%=PIGMENTATION_ABODOMINAL_STRIAE %>" maxlength="20" type="text" />
<label>Acne</label> 
<input name="<%=ACNE %>" maxlength="20" type="text" />
<div class="clear"></div>
<label>Others</label> 
<input name="<%=OTHERS_ENDORICE_STATUS %>"	maxlength="20" type="text" />
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
<div class="paddLeft55">
<label>Clitoris</label> 
<label>Majopra</label>
<label>Minora</label></div>
<div class="clear"></div>
<label>P.S </label> 
<label></label> <input name="<%=P_S_CLITORIS %>"	maxlength="20" type="text"><input name="<%=P_S_MAJOPRA %>"	maxlength="20" type="text"><input name="<%=P_S_MINORA %>"	maxlength="20" type="text">
<div class="clear"></div>
<label>P.V </label>
<label></label> 
<input name="<%=P_V_CLITORIS %>" maxlength="20" type="text">
<input name="<%=P_V_MAJOPRA %>"	maxlength="20" type="text">
<input name="<%=P_V_MINORA %>" maxlength="20" type="text">
<div class="clear">
</div>
</div>
<!--Block Two Ends--> 
<!--Block Three Starts-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>INVESTIAGATIONS</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">
<div class="clear"></div>
<label>Hemoglobin </label> 
<label></label> 
<input	name="<%=HEMOGLOBIN %>" maxlength="7" type="text">
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

<div class="clear"></div></div>
<%} %> <input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"><input type="hidden"
	name="<%=VISIT_ID %>" value="<%=visit.getId() %>"><input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"><input type="hidden"
	name="<%=HOSPITAL_ID %>"
	value="<%=visit.getHin().getHospital().getId() %>"><input
	type="hidden" name="<%=DEPARTMENT_ID %>"
	value="<%=visit.getDepartment().getId() %>">
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Button" type="button" class="button" value="Page 3" /> 
<input name="Button"	type="button" class="button" value="Page 4"	onclick="submitForm('OBG','opd?method=showOBGFOURJsp&visitId=<%=visit.getId() %>');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<!--Bottom labels starts--></form>
</div>
<!--main content placeholder ends here-->

<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>
