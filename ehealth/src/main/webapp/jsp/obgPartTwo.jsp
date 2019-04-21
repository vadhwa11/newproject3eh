<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdObg"%>
<%@page import="jkt.hms.masters.business.MasOccupation"%>
<%@page import="jkt.hms.masters.business.MasReligion"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>


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
	List opdObgList= new ArrayList();
	if(map.get("opdObgList") != null){
		opdObgList=(List)map.get("opdObgList");
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
	 

	 String visitDOBInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());

%>


<!--main content placeholder starts here-->

<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
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


<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>Past Medical History</h5>
</a>
<div class="Block" id="title1">
<div class="clear"></div>
<label class="">&nbsp;</label><label>Personal</label> <label></label> <label>Family</label>
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
<div class="clear"></div></div>

<!--Block One Ends--> <!--Block Two Starts-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>OBSTETRIC HISTORY</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title2">
<div class="clear"></div>
<label>Normal Delivery</label> <input name="<%=NORMAL_DELIVERY %>"
	maxlength="20" type="text"><label>Ectopic</label> <input
	name="<%=ECTOPIC %>" maxlength="20" type="text"><label>Abortion</label>
<input name="<%=ABORTION%>" maxlength="9" validate="Abortion,num,no"
	type="text">
<div class="clear"></div>

<label class="auto">Premature Delivery Baby Alive/Dead Still Births Fresh/Macerated&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> 
<input	name="<%=PREMATURE_DELIVERY %>"	value="<%=opdObg.getPrematureDeliveryBabyAliveDead() %>" maxlength="5"	validate="Still Births,num,no" type="text" />
<div class="clear"></div>
</div>
<!--Block Two Ends--> 
<!--Block Three Ends-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>SEXUAL HISTORY</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">
<div class="clear"></div>
<label class="large">Dyspareunia</label> <input name="<%= DYSPAREUNIA%>"
	maxlength="20" type="text">
<div class="clear"></div>

<label class="large">Awareness of Fertile Period</label> <input
	name="<%=AWARENESS %>" maxlength="5" type="text">
<div class="clear"></div>
<label class="large">Trying to conceive for</label> <input
	name="<%=TRYING_TO_CONCERIVE_FOR %>" maxlength="5" type="text">
<div class="clear"></div>
<label class="large">Frequency of IC</label> <input
	name="<%=FREQUENCY_OF_IC %>" maxlength="10" type="text"><label
	class="smallAuto">/week for last 6 months</label>
<div class="clear"></div></div>


<!--Block Three Ends--> <!--Block Four Ends-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title4','t4')">
<h5 id='t4'>CLINICAL EXAMINATION</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title4">
<div class="clear"></div>
<h4>GENERAL EXAMINATION</h4>
<div class="clear"></div>
<label class="large">General Apperance</label> 
<label class="small">Height&nbsp;</label>
<input name="<%=GENERNAL_APPERANCE_HEIGHT %>"	validate="General Apperance Height,num,no" maxlength="9" type="text">
<label class="large"></label> 
<label class="small">Width&nbsp;</label> 
<input name="<%= GENERNAL_APPERANCE_WIDTH%>" validate="General Apperance Weight,num,no" maxlength="9" type="text">
<div class="clear"></div>
<label class="large">Secondary Sexual Characters</label> <label
	class="small"></label> <input name="<%=SECONDARY_SEXUAL_CHARACTERS %>"
	maxlength="20" type="text">
<div class="clear"></div>
<label class="large">Neck Lymph Glands</label> <label class="small"></label>
<input name="<%=NECK_LYMPH_GLANDS %>" maxlength="20" type="text">
<div class="clear"></div>
<label class="large">Thyroid</label> <label class="small"></label> <input
	name="<%=THYROID %>" maxlength="20" type="text">
<div class="clear"></div>
<label class="large">C.V.S</label> <label class="small"></label> <input
	name="<%=CVS %>" maxlength="20" type="text"><label
	class="medium">B.P</label> <input name="<%=B_P%>" maxlength="6"
	type="text" class="small"><label class="medium">Pulse</label> <input
	name="<%=PULSE %>" validate="pluse,num,no" maxlength="9" type="text"
	class="small">
<div class="clear"></div>
<label class="large">RS</label><label class="small"></label> <input
	name="<%=RS%>" maxlength="20" type="text">
<div class="clear"></div>
<label class="large">CNS</label><label class="small"></label> <input
	name="<%=CNS%>" maxlength="20" type="text">
<div class="clear"></div></div>
<input type="hidden" name="<%=OBG_ID %>" value="<%=opdObg.getId() %>">

<!--Block Five Ends--> <%}}else{ %> <!--Block One Starts-->


<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title1','t1')">
<h5 id='t1'>Past Medical History</h5>
</a>
<div class="Block" id="title1">
<div class="clear"></div>
<div class="paddLeft55"><label>Personal</label><label></label> <label>Family</label>
</div>

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
<div class="clear"></div></div>

<!--Block One Ends--> <!--Block Two Starts-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title2','t2')">
<h5 id='t2'>OBSTETRIC HISTORY</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title2">
<div class="clear"></div>
<label>Normal Delivery</label> <input name="<%=NORMAL_DELIVERY %>"
	maxlength="20" type="text"><label>Ectopic</label> <input
	name="<%=ECTOPIC %>" maxlength="20" type="text"><label>Abortion</label>
<input name="<%=ABORTION%>" maxlength="9" type="text"
	validate="Abortion,num,no">
<div class="clear"></div>
<label class="large">Premature Delivery Baby Alive/Dead Still
Births Fresh/Macerated</label> <input name="<%=PREMATURE_DELIVERY %>"
	maxlength="20" type="text" />
<div class="clear"></div></div>

<!--Block Two Ends--> <!--Block Three Ends-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title3','t3')">
<h5 id='t3'>SEXUAL HISTORY</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title3">
<div class="clear"></div>
<label class="large">Dyspareunia</label> <input name="<%= DYSPAREUNIA%>"
	maxlength="20" type="text">
<div class="clear"></div>

<label class="large">Awareness of Fertile Period</label> <input
	name="<%=AWARENESS %>" maxlength="5" type="text">
<div class="clear"></div>
<label class="large">Trying to conceive for</label> <input
	name="<%=TRYING_TO_CONCERIVE_FOR %>" maxlength="5" type="text">
<div class="clear"></div>
<label class="large">Frequency of IC</label> <input
	name="<%=FREQUENCY_OF_IC %>" maxlength="10" type="text"><label
	class="smallAuto">/week for last 6 months</label>
<div class="clear"></div></div>

<!--Block Three Ends--> <!--Block Four Ends-->
<div class="division"></div>
<div class="clear"></div>
<a href="javascript:changeClass('title4','t4')">
<h5 id='t4'>CLINICAL EXAMINATION</h5>
</a>
<div class="clear"></div>
<div class="Block" id="title4">
<div class="clear"></div>
<h4>GENERAL EXAMINATION</h4>
<div class="clear"></div>
<label class="large">General Apperance</label> <label class="small">Height</label>
<input name="<%=GENERNAL_APPERANCE_HEIGHT %>" maxlength="9" type="text"
	validate="GENERNAL_APPERANCE_HEIGHT,num,no">
<div class="clear"></div>
<label class="large"></label> <label class="small">Width</label> <input
	name="<%= GENERNAL_APPERANCE_WIDTH%>" maxlength="9" type="text"
	validate="GENERNAL_APPERANCE_WEIGTH,num,no">
<div class="clear"></div>
<label class="large">Secondary Sexual Characters</label> <label
	class="small"></label> <input name="<%=SECONDARY_SEXUAL_CHARACTERS %>"
	maxlength="20" type="text">
<div class="clear"></div>
<label class="large">Neck Lymph Glands</label> <label class="small"></label>
<input name="<%=NECK_LYMPH_GLANDS %>" maxlength="20" type="text">
<div class="clear"></div>
<label class="large">Thyroid</label> <label class="small"></label> <input
	name="<%=THYROID %>" maxlength="20" type="text">
<div class="clear"></div>
<label class="large">C.V.S</label><label class="small"></label> <input
	name="<%=CVS %>" maxlength="20" type="text"><label
	class="medium">B.P</label> <input name="<%=B_P%>" maxlength="6"
	type="text" class="small"><label class="medium">Pulse</label> <input
	name="<%=PULSE %>" maxlength="9" type="text" validate="pluse,num,no"
	class="small">
<div class="clear"></div>
<label class="large">RS</label><label class="small"></label> <input
	name="<%=RS%>" maxlength="20" type="text">
<div class="clear"></div>
<label class="large">CNS</label><label class="small"></label> <input
	name="<%=CNS%>" maxlength="20" type="text">
<div class="clear"></div></div>

<%} %> <!--Block Five Ends--> <input type="hidden" name="<%=HIN_ID %>"
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
<input name="Button" type="button" class="button" value="Page 2" /> 
<input name="Button" type="button" class="button" value="Page 3" onclick="submitForm('OBG','opd?method=showOBGTHREEJsp&visitId=<%=visit.getId() %>');" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!--Bottom labels starts--></form>
</div>

<!--main content placeholder ends here-->
<div class="paddingTop40"></div>
<script type="text/javascript">
function changeClass(title,t)
{
animatedcollapse.toggle(title,t);
}
</script>