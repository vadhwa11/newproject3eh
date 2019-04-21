<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdUrology"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<%--For AutoComplete Through Ajax--%>
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
<script type="text/javascript">
function patientVisitPrev()
{
	var visitNo =document.getElementById('visitNo').value;
	if(visitNo==1)
	{
		alert("Not Before Visit Number");
		return false;
	}
	return true;
	}
function patientVisitNext()
{
	var visitId =document.getElementById('visitId').value;
	var visitIdM =document.getElementById('max').value;
	if(visitId==visitIdM)
	{
		alert("Not After Visit Number");
		return false;
	}
	return true;
}
</script>
<!--main content placeholder starts here-->
<form name="oncosurgeryCaseSheet" action="" method="post">
<div class="titleBg">
<h2>Urology Case Sheet</h2>
</div>
<div class="clear"></div>
<%
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
	List<OpdUrology> oncosurgeryCaseSheetList = new ArrayList<OpdUrology>();
	if(map.get("detailsMap") != null){
		detailsMap=(Map<String, Object>)map.get("detailsMap");
	}		
	int max=0;
	if(map.get("max") != null){
		max = (Integer)map.get("max");
	}
	if(detailsMap.get("patientDataList") != null){
		patientDataList=(List<Visit>)detailsMap.get("patientDataList");
	}	
	if(map.get("oncosurgeryCaseSheetList") != null){
		oncosurgeryCaseSheetList=(List<OpdUrology>)map.get("oncosurgeryCaseSheetList");
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


%> <!--Block One Starts-->
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label> 
<%
if(visit.getHin().getHinNo()!= null){ 
%>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label> 
<%}else{ %>
<label class="valueMedium">-</label> 
<%} %> 
<label>Patient Name </label> 
<%
if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> 
<%}else{ %> 
<label	class="value">- </label> 
<%} %> 
<label class="medium">Age</label> 
<%if(visit.getHin().getAge()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getAge() %></label> 
<%}else{ %>
<label class="valueMedium">-</label> <%} %> 
<label class="medium">Visit Date </label> 
<%if(visitDateInString != null){ %> 
<label class="valueMedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>
<div class="clear"></div>
<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no") %></label> 
<%if(visit.getVisitNo()!= null){ %>
<label class="valueMedium"><%=visit.getVisitNo() %></label> 
<%}else{ %> 
<label	class="valueMedium">-</label> 
<%} %> 
<label>Token No. </label> 
<%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label> 
<%}else{ %>
 <label>-</label>
<%} %>
 <label class="medium">Prev. Diag </label>
  <%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<div class="clear"></div>
</div>
<!--Block one Ends-->
<!--Block two Start--> <!--Block one Ends--> <%
if(oncosurgeryCaseSheetList.size() > 0){
	
	OpdUrology oncosurgeryCaseSheet = new OpdUrology();
	oncosurgeryCaseSheet = oncosurgeryCaseSheetList.get(0);
%>
<div class="clear"></div>
<!--Block two Start-->
<h4>Symptomes</h4>
<div class="Block">
 <textarea class="large"	readonly="readonly"><%=oncosurgeryCaseSheet.getSymptomme()%></textarea>
 </div>
<div class="clear"></div>
<h4>Haematuria</h4>
<div class="Block">
<div class="clear"></div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getHaeTotal() != null && !oncosurgeryCaseSheet.getHaeTotal().equals("")){
%> 
<input type="checkbox" name="<%=HAE_TOTAL %>" value="y"	class="radioCheck" checked="checked" />
<label class="value">Total</label>
<%}else{ %>
 <input type="checkbox" name="<%=HAE_TOTAL %>" value="y"	class="radioCheck" />
 <label class="value">Total</label>
  <%} %>
</div>
<%
	if(oncosurgeryCaseSheet.getHaeTeriminal() != null && !oncosurgeryCaseSheet.getHaeTeriminal().equals("")){
%> 
<input type="checkbox" name="<%=HAE_TERIMINAL %>" value="y"	class="radioCheck" checked="checked" />
<label class="value">Terminal</label>
<%}else{ %> 
<input type="checkbox" name="<%=HAE_TERIMINAL %>" value="y"	class="radioCheck" />
<label class="value">Terminal</label> 
<%} %> <%
	if(oncosurgeryCaseSheet.getHaeInitial() != null && !oncosurgeryCaseSheet.getHaeInitial().equals("")){
%> 
<input type="checkbox" name="<%=HAE_INITIAL %>" value="y"	class="radioCheck" checked="checked" />
	<label class="value">Initial</label>
<%}else{ %> 
<input type="checkbox" name="<%=HAE_INITIAL %>" value="y"	class="radioCheck" />
<label class="value">Initial</label> 
<%} %> <%
	if(oncosurgeryCaseSheet.getHaeClots() != null && !oncosurgeryCaseSheet.getHaeClots().equals("")){
%> 
<input type="checkbox" name="<%=HAE_CLOTS %>" value="y"	class="radioCheck" checked="checked" />
<label class="value">Clots</label>
<%}else{ %> 
<input type="checkbox" name="<%=HAE_CLOTS %>" value="y"	class="radioCheck" />
<label class="value">Clots</label>
 <%} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<h4>Pain</h4>
<div class="Block">
<div class="clear"></div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getUretericLeft() != null && !oncosurgeryCaseSheet.getUretericLeft().equals("")){
%> 
<input type="checkbox" name="<%=URETERIC_LEFT %>" value="y"	class="radioCheck" checked="checked" />
<label class="value">Left</label>
<%}else{ %> 
<input type="checkbox" name="<%=URETERIC_LEFT %>" value="y"	class="radioCheck" />
<label class="value">Left</label> <%} %>
</div>
<%
	if(oncosurgeryCaseSheet.getUretericRight() != null && !oncosurgeryCaseSheet.getUretericRight().equals("")){
%> 
<input type="checkbox" name="<%=URETERIC_RIGHT %>" value="y"	class="radioCheck" checked="checked" />
<label class="value">Right</label>
<%}else{ %> 
<input type="checkbox" name="<%=URETERIC_RIGHT %>" value="y"	class="radioCheck" />
<label class="value">Right</label> 
<%} %> <%
	if(oncosurgeryCaseSheet.getHypogastricPain() != null && !oncosurgeryCaseSheet.getHypogastricPain().equals("")){
%> 
<input type="checkbox" name="<%=HYPOGASTRIC_PAIN %>" value="y"	class="radioCheck" checked="checked" />
<label class="value">Hypogastric pain</label> 
<%}else{ %> 
<input type="checkbox" name="<%=HYPOGASTRIC_PAIN %>" value="y" class="radioCheck" />
<label class="value">Hypogastric pain</label> 
<%} %> <%
	if(oncosurgeryCaseSheet.getBonePain() != null && !oncosurgeryCaseSheet.getBonePain().equals("")){
%> 
<input type="checkbox" name="<%=BONE_PAIN %>" value="y"	class="radioCheck" checked="checked" />
<label class="value">Bone Pain </label> 
<%}else{ %> 
<input type="checkbox" name="<%=BONE_PAIN %>" value="y"	class="radioCheck" />
<label class="value">Bone Pain </label> 
<%} %>
<div class="clear"></div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getDysuriaPain() != null && !oncosurgeryCaseSheet.getDysuriaPain().equals("")){
%> 
<input type="checkbox" name="<%=DYSURIA_PAIN %>" value="y" class="radioCheck" checked="checked" />
<label class="value">Dysuria</label>
<%}else{ %> 
<input type="checkbox" name="<%=DYSURIA_PAIN %>" value="y"	class="radioCheck" />
<label class="value">Dysuria</label> 
<%} %>
</div>
<%
	if(oncosurgeryCaseSheet.getPerinalRectal() != null && !oncosurgeryCaseSheet.getPerinalRectal().equals("")){
%> <input type="checkbox" name="<%=PERINAL_RECTAL %>" value="y"
	class="radioCheck" checked="checked" /><label class="value">Perineal
/ Rectal pain</label> <%}else{ %> <input type="checkbox"
	name="<%=PERINAL_RECTAL %>" value="y" class="radioCheck" /><label
	class="value">Perineal / Rectal pain</label> <%} %>



<div class="clear"></div>
</div>

<h4>Luts</h4>
<div class="Block">
<div class="clear"></div>
<label>Irritative</label>
<div class="paddLeft35"><label>Obstructive</label></div>
<div class="clear"></div>

<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getLFrequency() != null && !oncosurgeryCaseSheet.getLFrequency().equals("")){
%> <input type="checkbox" name="<%=L_FREQUENCY %>" value="y"
	class="radioCheck" checked="checked" /><label class="value">Frequency</label>
<%}else{ %> <input type="checkbox" name="<%=L_FREQUENCY %>" value="y"
	class="radioCheck" /><label class="value">Frequency</label> <%} %>
</div>

<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getLHesitanvy() != null && !oncosurgeryCaseSheet.getLHesitanvy().equals("")){
%> 
<input type="checkbox" name="<%=L_HESITANVY %>" value="y"	class="radioCheck" checked="checked" />
<label class="value">Hesitanvy</label>
<%}else{ %>
 <input type="checkbox" name="<%=L_HESITANVY %>" value="y"	class="radioCheck" />
 <label class="value">Hesitanvy</label> <%} %>
</div>
<div class="clear"></div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getLNocturia() != null && !oncosurgeryCaseSheet.getLNocturia().equals("")){
%> 
<input type="checkbox" name="<%=L_NOCTURIA %>" value="y"	class="radioCheck" checked="checked" /> 
<label class="value">Nocturia</label>
<%}else{ %> 
<input type="checkbox" name="<%=L_NOCTURIA %>" value="y"	class="radioCheck" /> <label class="value">Nocturia</label> <%} %>
</div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getLStraining() != null && !oncosurgeryCaseSheet.getLStraining().equals("")){
%> <input type="checkbox" name="<%=L_STRAINING %>" value="y"
	class="radioCheck" checked="checked" /> <label class="value">Straining</label>
<%}else{ %> <input type="checkbox" name="<%=L_STRAINING %>" value="y"
	class="radioCheck" /> <label class="value">Straining</label> <%} %>
</div>
<div class="clear"></div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getLUrgency() != null && !oncosurgeryCaseSheet.getLUrgency().equals("")){
%> 
<input type="checkbox" name="<%=L_URGENCY %>" value="y"	class="radioCheck" checked="checked" /> 
<label class="value">Urgency</label>
<%}else{ %> 
<input type="checkbox" name="<%=L_URGENCY %>" value="y"	class="radioCheck" /> 
<label class="value">Urgency</label> <%} %>
</div>
<div class="clear"></div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getLSenseComEva() != null && !oncosurgeryCaseSheet.getLSenseComEva().equals("")){
%> 
<input type="checkbox" name="<%=L_SENSE_COM_EVA %>" value="y"	class="radioCheck" checked="checked" />
<label class="value">Sense of incomplete evaluation</label> 
<%}else{ %> 
<input type="checkbox"	name="<%=L_SENSE_COM_EVA %>" value="y" class="radioCheck" />
<label	class="value">Sense of incomplete evaluation</label> 
<%} %>
</div>
<div class="clear"></div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getLUrgeIncon() != null && !oncosurgeryCaseSheet.getLUrgeIncon().equals("")){
%> 
<input type="checkbox" name="<%=L_URGE_INCON %>" value="y"	class="radioCheck" checked="checked" /> 
<label class="value">Urge incontinence</label> 
<%}else{ %> 
<input type="checkbox" name="<%=L_URGE_INCON %>" value="y" class="radioCheck" /> 
<label class="value">Urge incontinence</label> 
<%} %>
</div>
<div class="clear"></div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getLIntermittency() != null && !oncosurgeryCaseSheet.getLIntermittency().equals("")){
%> 
<input type="checkbox" name="<%=L_INTERMITTENCY %>" value="y" class="radioCheck" checked="checked" />
<label class="value">Intermittency</label>
<%}else{ %> 
<input type="checkbox" name="<%=L_INTERMITTENCY %>" value="y"	class="radioCheck" />
<label class="value">Intermittency</label>
<%} %></div>
<div class="clear"></div>
<div class="paddLeft30">
 <%
	if(oncosurgeryCaseSheet.getLDribbling() != null && !oncosurgeryCaseSheet.getLDribbling().equals("")){
%> 
<input type="checkbox" name="<%=L_DRIBBLING %>" value="y"	class="radioCheck" checked="checked" />
<label class="value">Dribbling</label>
<%}else{ %> 
<input type="checkbox" name="<%=L_DRIBBLING %>" value="y"	class="radioCheck" />
<label class="value">Dribbling</label> <%} %>
</div>
</div>
<div class="clear"></div>
<div class="Block">
<label>Calcularia</label>
<div class="paddLeft15">
<%
	if(oncosurgeryCaseSheet.getCalculariaCheck() != null && !oncosurgeryCaseSheet.getCalculariaCheck().equals("")){
%> 
<input type="checkbox" name="<%=CALCULARIA_CHECK %>" value="y"	class="radioCheck" checked="checked" /> 
<%}else{ %> 
<input	type="checkbox" name="<%=CALCULARIA_CHECK %>" value="y"	class="radioCheck" /> 
<%} %> 
<input type="text" name="<%=CALCULARIA %>"	value="<%=oncosurgeryCaseSheet.getCalcularia() %>" />
</div>
<label>Chyluria </label>
<div class="paddLeft15">
<%
	if(oncosurgeryCaseSheet.getChyluriaCheck() != null && !oncosurgeryCaseSheet.getChyluriaCheck().equals("")){
%> 
<input type="checkbox" name="<%=CHYLURIA_CHECK %>" value="y"	class="radioCheck" checked="checked" /> 
<%}else{ %> 
<input	type="checkbox" name="<%=CHYLURIA_CHECK %>" value="y"	class="radioCheck" /> <%} %> 
<input type="text" name="<%=CHYLURIA %>" value="<%=oncosurgeryCaseSheet.getChyluria() %>" />
</div>
<div class="clear"></div>
<label>Erectile Dysfunction </label>
<div class="paddLeft15">
<%
	if(oncosurgeryCaseSheet.getErectileDysfunctionCheck() != null && !oncosurgeryCaseSheet.getErectileDysfunctionCheck().equals("")){
%> 
<input type="checkbox" name="<%=ERECTILE_DYSFUNCTION_CHECK %>"	value="y" class="radioCheck" checked="checked" /> 
<%}else{ %> 
<input	type="checkbox" name="<%=ERECTILE_DYSFUNCTION_CHECK %>" value="y"	class="radioCheck" /> 
<%} %> 
<input type="text"	name="<%=ERECTILE_DYSFUNCTION %>"	value="<%=oncosurgeryCaseSheet.getErectileDysfunction() %>">
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="clear"></div>
<h4>Ejaculatory Dysfunction</h4>
<div class="Block">
<div class="clear"></div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getHaemospermia() != null && !oncosurgeryCaseSheet.getHaemospermia().equals("")){
%> 
<input type="checkbox" name="<%=HAEMOSPERMIA %>" value="y"	class="radioCheck" checked="checked" /><label class="value">Haemospermia</label>
<%}else{ %>
<input type="checkbox" name="<%=HAEMOSPERMIA %>" value="y"	class="radioCheck" />
<label class="value">Haemospermia</label> 
<%} %>
</div>
<div class="paddingLeft30">
<%
	if(oncosurgeryCaseSheet.getPrematureejaculation() != null && !oncosurgeryCaseSheet.getPrematureejaculation().equals("")){
%> 
<input type="checkbox" name="<%=PREMATUREEJACULATION %>" value="y"	class="radioCheck" checked="checked" />
<label class="value">Premature Ejaculation</label>
 <%}else{ %>
<input type="checkbox"	name="<%=PREMATUREEJACULATION %>" value="y" class="radioCheck" />
<label	class="value">Premature Ejaculation</label> 
  <%} %> 
  </div>
<div class="paddingLeft30">
  <%
	if(oncosurgeryCaseSheet.getRetrogradeEjaculation() != null && !oncosurgeryCaseSheet.getRetrogradeEjaculation().equals("")){
%> 
<input type="checkbox" name="<%=RETROGRADE_EJACULATION %>" value="y"	class="radioCheck" checked="checked" />
<label class="value">Retrograde Ejaculation</label> 
 <%}else{ %> 
<input type="checkbox"	name="<%=RETROGRADE_EJACULATION %>" value="y" class="radioCheck" />
<label	class="value">Retrograde Ejaculation</label> 
<%} %>
</div>
<div class="paddingLeft30">
 <%
	if(oncosurgeryCaseSheet.getAnejaculationEjaculation() != null && !oncosurgeryCaseSheet.getAnejaculationEjaculation().equals("")){
%> 
<input type="checkbox" name="<%=ANEJACULATION_EJACULATION %>" value="y" class="radioCheck" checked="checked" />
<label class="value">Anejaculation</label>
	 <%}else{ %> 
<input type="checkbox" name="<%=ANEJACULATION_EJACULATION %>"	value="y" class="radioCheck" />
<label class="value">Anejaculation </label>
<%} %>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>

<h4>Incontinence</h4>
<div class="Block">
<div class="clear"></div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getStressIncontinence() != null && !oncosurgeryCaseSheet.getStressIncontinence().equals("")){
%> 
<input type="checkbox" name="<%=STRESS_INCONTINENCE %>" value="y"	class="radioCheck" checked="checked" /> 
	<label class="value">Stress Incontinence</label>

<%}else{ %> 
<input type="checkbox" name="<%=STRESS_INCONTINENCE %>"	value="y" class="radioCheck" /> 
<label class="value">Stress Incontinence</label>
<%} %>
</div> 
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getUrgeIncontinence() != null && !oncosurgeryCaseSheet.getUrgeIncontinence().equals("")){
%> 
<input type="checkbox" name="<%=URGE_INCONTINENCE %>" value="y"	class="radioCheck" checked="checked" /> 
<label class="value">Urge incontinence</label> <%}else{ %> 
<input type="checkbox"	name="<%=URGE_INCONTINENCE %>" value="y" class="radioCheck" /> 
<label	class="value">Urge incontinence</label> 
<%} %> </div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getTotalIncontinence() != null && !oncosurgeryCaseSheet.getTotalIncontinence().equals("")){
%> 
<input type="checkbox" name="<%=TOTAL_INCONTINENCE %>" value="y"	class="radioCheck" checked="checked" /> 
<label class="value">Total incontinence</label> <%}else{ %> 
<input type="checkbox"	name="<%=TOTAL_INCONTINENCE %>" value="y" class="radioCheck" /> 
<label	class="value">Total incontinence</label> 
<%} %> </div>
<div class="paddLeft30">
<%
	if(oncosurgeryCaseSheet.getOverflowIncontinence() != null && !oncosurgeryCaseSheet.getOverflowIncontinence().equals("")){
%> 
<input type="checkbox" name="<%=OVERFLOW_INCONTINENCE %>" value="y"	class="radioCheck" checked="checked" /> 
<label class="value">Overflow incontinence</label> 
<%}else{ %> 
<input type="checkbox"	name="<%=OVERFLOW_INCONTINENCE %>" value="y" class="radioCheck" /> 
<label	class="value">Overflow incontinence</label> 
<%}%>
</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<label>Acute Urinary Retention</label>
<div class="Block">
<%
	if(oncosurgeryCaseSheet.getAcuteUrinaryCheck() != null && !oncosurgeryCaseSheet.getAcuteUrinaryCheck().equals("")){
%> 
<input type="checkbox" name="<%=ACUTE_URINARY_CHECK %>" value="y"	class="radioCheck" checked="checked"> <%}else{ %> 
<input	type="checkbox" name="<%=ACUTE_URINARY_CHECK %>" value="y"	class="radioCheck"> <%} %> 
<input type="text"	name="<%=ACUTE_URINARY %>"	value="<%=oncosurgeryCaseSheet.getAcuteUrinary() %>">
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input name="prev" type="button" class="button" value="Prev"	onclick="submitForm('oncosurgeryCaseSheet','opd?method=viewUrologyCaseSheet&flag=prev','patientVisitPrev');" />
<input name="next" type="button" class="button" value="Next"	onclick="submitForm('oncosurgeryCaseSheet','opd?method=viewUrologyCaseSheet&flag=next','patientVisitNext');"/>
<%
	String url = ""; 
	if(map.get("backButtonUrl") != null){
		url = (String)map.get("backButtonUrl");		
	
%> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('oncosurgeryCaseSheet','<%=url%>');" align="right" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<%}%> 
 <%}else{%> 
<h4>No Record Found!!</h4>
<%} %>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="Bottom">
<label>Changed By:</label> 
<label	class="value"><%=userName %></label>
 <label>Changed Date:</label> 
 <label	class="value"><%=date%></label> 
 <label>Changed Time:</label> 
 <label	class="value"><%=time%></label> 
 <input type="hidden"	name="<%=HIN_ID %>" value="<%=visit.getHin().getId() %>"> 
 <input	type="hidden" name="<%=DEPARTMENT_ID %>" value="<%=visit.getDepartment().getId() %>" /> 
 <input type="hidden" id="visitNo" name="<%=VISIT_NUMBER %>" value="<%=visit.getVisitNo() %>">
<input type="hidden" id="currentVisitId" name="currentVisitId"	value="<%=currentVisitId %>"> 
<input type="hidden" id="max" name="max" value="<%=max %>"> 
<input type="hidden" id="visitId" value="<%=visit.getId() %>">
<div class="paddingTop40"></div>
<div class="paddingTop40"></div>
<!--Bottom labels ends--> 
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>