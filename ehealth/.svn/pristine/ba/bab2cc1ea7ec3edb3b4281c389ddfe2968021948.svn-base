<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript" 	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<%--For AutoComplete Through Ajax--%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.2.pack.js"></script>
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
	var dobDate1 = document.getElementById('dateId').value ;
	
	var d1 = new Date(dobDate1.substring(6),(dobDate1.substring(3,5) - 1) ,dobDate1.substring(0,2));
	if(dobDate1 != ""){
		if(vDate > d1)
		{
			alert("Please enter valid date of Date?Of 1st Visit.");
			document.getElementById('dateId').value = "";
			return false;
		}
		else
		{
			return true;
		}
	}
	return true;
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
	
	
function addMonths()
{
var lmp = document.getElementById('lmpId').value ;
if(lmp!="")
{
	var v = new Date(lmp.substring(6),(lmp.substring(3,5) - 1) ,lmp.substring(0,2));

      
      v.setMonth(v.getMonth() + 9);
       v.setDate(v.getDate() + 7);
      var curr_date = v.getDate();
      
      var curr_month = v.getMonth();
      
      var curr_year = v.getFullYear();
      
      var mth;
      var dt;
      if(v.getDate() < 10){
       			
       			dt = "0"+curr_date;
       		}
       		else
       		{
       			dt = curr_date;
       		}
       		
       		if(v.getMonth()+1 < 10){
       			mth = "0"+curr_month
       		}
       		else
       		{
       			mth = curr_month
       		}
      
      var myDate = (dt + "/" + mth + "/" + curr_year);

	  document.getElementById('eddId').value=myDate;
	}
	else
	{
	  document.getElementById('eddId').value="";
	}
}
function setFocusLmp()
{
	  document.gravidagramHTN.<%=LMP%>.focus();
}
function eddF()
{	
	var edd = document.getElementById('eddId').value ;
	if(edd=="")
	{
	  alert("Please Enter LMP")
	  return false;
	}
	else
	{
	return true;
	}
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
var dobDate1 = document.getElementById('dateId').value ;

if((b1=="")&&(b2=="")&&(b3=="")&&(b4=="")&&(b5=="")&&(b6=="")&&(b7=="")&&(b8=="")&&(b9=="")&&(b10=="")&&(b11=="")&&(b12=="")&&(b13=="")&&(dobDate1==""))
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

	 
	 List opdAntenatalCardList= new ArrayList();
		if(map.get("opdAntenatalCardList") != null){
			opdAntenatalCardList=(List)map.get("opdAntenatalCardList");
		}
%>
<script type="text/javascript">
function get_valueForEdit(n)
{
 var url="/hms/hms/opd?method=showAntenatalCardEditJsp&aId="+n+"&visitId=<%=visit.getId() %>";
   popwindow(url);
  
 }  
function get_valueForGravidagramHTN(visitId)
{
 var url="/hms/hms/opd?method=showGravidagramHTNJsp&visitId=<%=visit.getId() %>";
   popwindowGravidagramHTN(url);
  
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
 window.close();
}
function popwindowGravidagramHTN(url)
{

 newwindow=window.open(url,'name',"height=200,width=1000,status=1");
 if (window.focus) 
 {
 newwindow.focus()
 }
newwindow.createPopup();
 window.close();
}		

function back() {
window.close();
return;

}


</script>
<!--main content placeholder starts here-->
<div class="OpdOphthamology-maindiv">
<form name="gravidagramHTN" action="" method="post">
<input	type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=visit.getDepartment().getId() %>" />
<%if(visit.getDepartment()!= null){ %>

<div class="titleBg">
<h2>Gravidagram HTN</h2>
</div>
<div class="clear"></div>
<%} %> <!--Block One Starts-->

<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="value"><%=visit.getHin().getHinNo() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> <label>Patient Name. </label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label>Age</label> <%if(visit.getHin().getAge()!= null){ %>
<label class="value"><%=visit.getHin().getAge() %></label> <%}else{ %> <label
	class="value">-</label> <%} %> 
	
	
<div class="clear"></div>
	
	<label>Visit Date </label> <%if(visitDateInString != null){ %>
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
<!--Block one Ends-->

<div class="clear"></div>
<div class="paddingTop15"></div>
<h4>Present Records</h4>
<div class="clear"></div>
<div class="cmntable">
<table width="100%" border="0" cellspacing="0" cellpadding="0">

	<tr>
		<th scope="col" rowspan="2" colspan="2">Date</th>
		<th colspan="2" scope="col">POG</th>
		<th colspan="2" scope="col">BP</th>
		<th colspan="2" scope="col">FETUS</th>
		<th colspan="7" scope="col">&nbsp;</th>
	</tr>
	<tr>
		<th scope="col">Weeks</th>
		<th scope="col">Days</th>
		<th scope="col">AM</th>
		<th scope="col">PM</th>
		<th scope="col">DFMC</th>
		<th scope="col">FHS</th>
		<th scope="col">FUNDAL HT</th>
		<th scope="col">ABDO GIRTH</th>
		<th scope="col">WT Kg</th>
		<th scope="col">U ALB</th>
		<th scope="col">USB?AFI<br />
		(See Reverse also)</th>
		<th scope="col">NST</th>
		<th scope="col">HAEMAT/BIOCHEM <br />
		INVES TIGATIONS <br />
		(see reverse also)</th>
	</tr>
	<tr>
		<td>
		<input type="text" class="date" id="dateId"
			name="<%=DATE %>" onblur="checkDate();" readonly="readonly"
			MAXLENGTH="30" />
			</td>
			<td>
			<img src="/hms/jsp/images/cal.gif" width="16"
			height="16" border="0" validate="Pick a date"
			onClick="setdate('',document.gravidagramHTN.<%=DATE%>,event)"
			onblur="checkDate();" />

		</td>
		<td><input id="b1" name="<%=WEEKS%>" type="text" size=10
			maxlength="10" /></td>
		<td><input id="b2" name="<%=DAYS %>" type="text" size=10
			maxlength="10" /></td>
		<td><input id="b3" name="<%=AM%>" type="text" size=3
			maxlength="6" /></td>
		<td><input id="b4" name="<%=PM%>" type="text" size=3
			maxlength="6" /></td>
		<td><input id="b5" name="<%=DFMC %>" type="text" size=10
			maxlength="20" /></td>
		<td><input id="b6" name="<%=FHS %>" type="text" size=10
			maxlength="20" /></td>
		<td><input id="b7" name="<%=FUBDAL_HT %>" type="text" size=10
			maxlength="20" /></td>
		<td><input id="b8" name="<%=ABDO_GIRTH %>" type="text" size=10
			maxlength="20" /></td>
		<td><input id="b9" name="<%=WT_KG %>" type="text" size=5
			maxlength="10" /></td>
		<td><input id="b10" name="<%=U_ALB %>" type="text" size=10
			maxlength="20" /></td>
		<td><input id="b11" name="<%=USB_AFI %>" type="text" size=10
			maxlength="20" /></td>
		<td><input id="b12" type="text" name="<%=NST %>" size="10" /></td>
		<td><input id="b13" name="<%=HAEMAT %>" type="text" size=10
			maxlength="20" /></td>
	</tr>
</table>

</div>
<input type="hidden" name="<%=HIN_ID %>"
	value="<%=visit.getHin().getId() %>"> 
<input type="hidden" name="<%=VISIT_ID %>" value="<%=visit.getId() %>"><input
	type="hidden" name="<%=VISIT_NUMBER %>"
	value="<%=visit.getVisitNo() %>"><input type="hidden"
	name="currentVisitId" value="<%=visit.getId() %>">

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"	onclick="submitForm('gravidagramHTN','opd?method=addGravidagramHTN','checkDate','blankSpace');"	/>
<input name="" type="hidden" class="button"	value="View"	onclick="submitForm('gravidagramHTN','opd?method=viewGravidagramHTN&flag=prev&viewScreen=no');" />

	<input type="button" name="Back" value="Cancel" class="button"	onclick="setVa();" />


<div class="clear"></div>
<div class="division"></div>

<div class="bottom">
<label>Changed By</label>
<label class="value"><%=userName %></label>
<label>Changed Date</label>
<label class="value"><%=dateC%></label>
<label>Changed Time</label>
<label class="value"><%=time%></label>
</div>



<!--Main Div Ends-->
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
       </form>

</div>
	<script type="text/javascript">
	function setVa(){
		//submitForm('opdOphthalmology','opd?method=submitOphthalmologyDetails');
		window.close();
	}
	</script>