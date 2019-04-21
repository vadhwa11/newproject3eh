<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" 	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
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
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript"	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
<script type="text/javascript"	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript">
animatedcollapse.addDiv('slide1', 'fade=0,speed=400,group=pets')
animatedcollapse.addDiv('slide2', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide3', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide4', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.addDiv('slide5', 'fade=0,speed=400,group=pets,persist=1,hide=1')
animatedcollapse.init()

</script>
<script type="text/javascript">

function checkDate(){

	var vDate = new Date() ;
	
		var vDate =  new Date();
	var mth;
	var dt;
	var da = vDate.getDate();
	var m = vDate.getMonth()+1;
	if(vDate.getDate() < 10)
	{
		dt = "0"+da;
	}
	else
	{
		dt = da;
	}
	if(vDate.getMonth()+1 < 10)
	{
		mth = "0"+m
	}
	else
	{
		mth = m
	}
	var finalToday=dt+"/"+mth+"/"+vDate.getFullYear();
	
	
	
	var dobDate1 = document.getElementById('datePog').value ;
	if(dobDate1 != ""){
		if(dobDate1<finalToday)
		{
			alert("Please ensure Date Of 1st Visit that the Today Date is greater than or equal to the Start Date.");
			document.getElementById('startDateId').value = "";
			return false;
		}
			return false;
	}

}



<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
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
		String dateC = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");

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

	 
%>
<script type="text/javascript">

function back() {
window.close();
return;

}

</script>
<script type="text/javascript">
function blankSpace()
{
var b1 = document.getElementById('b1').value ;
var b2 = document.getElementById('b2').value ;
var b3= document.getElementById('b3').value ;
var b4 = document.getElementById('b4').value ;
var b5= document.getElementById('b5').value ;
var b6 = document.getElementById('b6').value ;
var b7 = document.getElementById('b7').value ;
var b8 = document.getElementById('b8').value ;
var b9 = document.getElementById('b9').value ;
var b10 = document.getElementById('b10').value ;
var b11 = document.getElementById('b11').value ;
var b12 = document.getElementById('b12').value ;
var b13 = document.getElementById('b13').value ;
var b14 = document.getElementById('b14').value ;
var b15 = document.getElementById('b15').value ;
var b16 = document.getElementById('b16').value ;
var b17 = document.getElementById('b16').value ;
var dobDate1 = document.getElementById('datePog').value ;

if((b1=="")&&(b2=="")&&(b3=="")&&(b4=="")&&(b5=="")&&(b6=="")&&(b7=="")&&(b8=="")&&(b9=="")&&(b10=="")&&(b11=="")&&(b12=="")&&(b13=="")&&(b14=="")&&(b15=="")&&(b16=="")&&(b17=="")&&(dobDate1==""))
{
alert("Please give some fields.");
	return false;
}
else
{
	return true;
}
}
</script>
<div class="OpdOphthamology-maindiv">
<form name="gravidagramGestationalDiabitiesTwo" action="" method="post">
<input type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=visit.getDepartment().getId() %>" /> <%if(visit.getDepartment()!= null){ %>
<div class="titleBg"><h2>Gravidagram Gestational Diabities Two</h2></div>
<div class="clear"></div>
<%} %> <!--Block One Starts-->

<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<%if(visit.getHin().getHinNo()!= null){ %>
<label class="value"><%=visit.getHin().getHinNo() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<label>Patient Name </label>
<%if(patientName!= null){ %>
<label class="value"><%=patientName %></label> <%}else{ %>
<label class="value">-</label> <%} %>
<label>Age</label> <%if(visit.getHin().getAge()!= null){ %>
<label	class="value"><%=visit.getHin().getAge() %></label> <%}else{ %>
<label class="value">-</label> <%} %>

<div class="clear"></div>

<label>Visit Date </label> <%if(visitDateInString != null){ %>
<label class="value"><%=visitDateInString %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<label><%=prop.getProperty("com.jkt.hms.opd_no") %></label> <%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label> <%}else{ %>
<label	class="value">-</label> <%} %>
<label>Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<div class="clear"></div>
<label>ECHS No. </label> <%if(visit.getHin().getEchsNo()!= null){ %>
<label class="value"><%=visit.getHin().getEchsNo() %></label> <%}else{ %>
<label class="value">-</label> <%} %>
<label>Phone Number</label> <% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
<label class="value"><%=visit.getHin().getPhoneNumber() %></label>
<%}else{ %>
<label class="value">-</label>
 <%} %>
<label>Mobile Number</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="value"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>
<div class="clear"></div>
<label>Prev. Diag </label>
<%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<!--Block two Starts-->
<div class="Block">
<label>Nuchal Traslucency </label>
<input id="b1"	name="<%=NUCHAL_TRASLUCENCY %>" type="text" maxlength="30"	validate="Nuchal Traslucency ,string,no" />
<label>Msarp </label>
<input	id="b2" name="<%=MSARP %>" type="text" maxlength="30"	validate="Msarp,string,no" />
<label>Anomaly Scan </label>
<input	id="b3" name="<%=ANOMALY_SCAN %>" type="text" maxlength="30"	validate="Anomaly Scan,string,no" size="20" />
<div class="clear"></div>
<label>Retal Echo </label>
<input id="b4" name="<%=RETAL_ECHO %>"	type="text" maxlength="30" validate="Retal Echo,string,no" size="20" />
<div class="clear"></div>
</div>

<div class="clear"></div>
<h4>HOMETRY</h4>
<div class="clear"></div>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Date/POG</th>
		<th scope="col">Met Age</th>
		<th scope="col">CEN</th>
		<th scope="col">AC</th>
		<th scope="col">EFW</th>
		<th scope="col">AEL</th>
		<th scope="col">NST</th>
		<th scope="col">EL/AC</th>
		<th scope="col">PONDREL INDEX</th>
		<th scope="col">REMARKS</th>
	</tr>

	<tr>
		<td>
		<div><input type="text" class="calDate" id="datePog"
			name="<%=POG %>" onblur="checkDate();" readonly="readonly"
			MAXLENGTH="30" /> <img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onClick="setdate('',document.gravidagramGestationalDiabitiesTwo.<%=POG%>,event)"
			onblur="checkDate();" /></div>
		</td>
		<td><input id="b5" name="<%=MET_AGE%>" type="text" maxlength="15"
			validate="Met Age,string,no" /></td>
		<td><input id="b6" name="<%=CEN%>" type="text" maxlength="15"
			validate="Cen,string,no" /></td>
		<td><input id="b7" name="<%=AC%>" type="text" maxlength="15"
			validate="Ac,string,no" /></td>
		<td><input id="b8" name="<%=EFW%>" type="text" maxlength="15"
			validate="Efw,string,no" /></td>
		<td><input id="b9" name="<%=AEL%>" type="text" maxlength="15"
			validate="Ael,string,no" /></td>
		<td><input id="b10" name="<%=NST%>" type="text" maxlength="15"
			validate="Nst,string,no" /></td>
		<td><input id="b11" name="<%=EL_ACAC %>" type="text"
			maxlength="15" validate="EL/AC,string,no" /></td>
		<td><input id="b12" name="<%=PONDREL_INDEX %>" type="text"
			maxlength="15" validate="PONDREL INDEX,string,no" /></td>
		<td><input id="b13" name="<%=REMARKS%>" type="text"
			maxlength="15" validate="REMARKS,string,no" /></td>
	</tr>
</table>

</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="Block"><div class="clear"></div>
<label>Doppler </label>
<input id="b14" name="<%=DOPPLER %>" type="text"	maxlength="15" validate="DOPPLER ,string,no" />
<label>DelieverNote </label>
<input id="b15" name="<%=DELIVER_NOTE %>" type="text"	maxlength="15" validate="DELIVER NOTE,string,no" />

<label>Birth Weight </label>
<input id="b16" name="<%=BIRTH_WEIGHT %>" type="text"	maxlength="15" validate="BIRTH WEIGHT,string,no" size="20" />
<div class="clear"></div>
<label>MN/NeonatlEcome</label>
<input id="b17" name="<%=MN_NEONATL_ECOME %>" type="text"	maxlength="15" validate="MN/NEONATL ECOME,string,no" size="20" />
<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"	onclick="submitForm('gravidagramGestationalDiabitiesTwo','opd?method=addGravidagramGestationalDiabitiesTwo','checkDate()','blankSpace');" />
<input name="" type="hidden" class="button"	value="View"	onclick="submitForm('gravidagramGestationalDiabitiesTwo','opd?method=viewGravidagramGestationalDiabitiesTwo&flag=prev&viewScreen=no');" />

	<input type="button" name="Back" value="Cancel" class="button"	onclick="setVaa();" />
<div class="clear"></div>
<div class="division"></div>
<!--Block two Ends-->
<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>">
<input type="hidden"	name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input	type="hidden" name="<%=VISIT_NUMBER %>"	value="<%=visit.getVisitNo() %>">
<input type="hidden"	name="currentVisitId" value="<%=visit.getId() %>">
<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %></label>
<label>Changed Date</label>
<label class="value"><%=dateC%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
</div>




<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

</div>

	<script type="text/javascript">
	function setVaa(){
		//submitForm('opdOphthalmology','opd?method=submitOphthalmologyDetails');
		window.close();
	}
	</script>