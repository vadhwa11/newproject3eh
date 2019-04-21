<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.6.pack.js"></script>

<script type="text/javascript" src="/hms/jsp/js/ddaccordion.js">

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
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [0], //index of content(s) open by default [index1, index2, etc]. [] denotes no content
	onemustopen: true, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", "openheader"], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["prefix", "", ""], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})


</script>

<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<!-- START OF CALENDER JAVASCRIPT CODE -->
<script language="javascript"><!--
var w3c=(document.getElementById)?true:false;
var ie4=(document.all && !w3c)?true:false;
var ie5=(document.all && w3c)?true:false;
var ns4=(document.layers)?true:false;
var ns6=(w3c && !document.all)?true:false;
var mi=0; var yi=0;
var calA=new Array();
var cal_m, cal_y, cal, calS, now;

function setMonth(incr){
if(!ns4){
var m = (incr)?1:-1;
mi = parseInt(mi)+parseInt(m);

if(mi>11)mi=0;
if(mi<0)mi=11;
now.setMonth(mi);
updateCalender();
}}

function setYear(incr){
if(!ns4){
yi+=(incr)?1:-1;
if(yi>50)yi=0;
if(yi<0)yi=50;
now.setFullYear(yi+1970);
updateCalender();
}}

function updateCalender(){
var dim=[31,0,31,30,31,30,31,31,30,31,30,31];
dim[1]=(((now.getFullYear()%100!=0)&&(now.getFullYear()%4==0))||(now.getFullYear()%400==0))?29:28;
cal_m.innerHTML=['January','February','March','April','May','June','July','August','September','October','November','December'][mi];
cal_y.innerHTML=yi+1970;
var offsetD=new Date();
offsetD.setFullYear(yi+1970);
offsetD.setMonth(mi);
offsetD.setDate(1);
offsetD=offsetD.getDay()+1;
for(i=1;i<=42;i++){
if((i-offsetD>=0)&&(i-offsetD<dim[mi])){
calA[i].innerHTML=i-offsetD+1;
calA[i].i=i;
calA[i].o=offsetD;


calA[i].className=((now.ref.getDate()==i-offsetD+1)&&(now.ref.getFullYear()==now.getFullYear())&&(now.ref.getMonth()==now.getMonth()))?"calToday":"calText";
}else{
calA[i].className="calText";
calA[i].innerHTML='&nbsp;';
}}}

window.onload=function(){
if(!ns4){
for(i=1;i<=42;i++)calA[i]=(ie4)?document.all['cal'+i]:document.getElementById('cal'+i);
cal_m=(ie4)?document.all["calender_m"]:document.getElementById("calender_m");
cal_y=(ie4)?document.all["calender_y"]:document.getElementById("calender_y");
cal=(ie4)?document.all["calender"]:document.getElementById("calender");
calS=(ie4)?document.all["calenderS"]:document.getElementById("calenderS");
//calS.style.height=((ie4||ie5)?cal.clientHeight:(w3c)?cal.offsetHeight:200)+'px';
//calS.style.width=((ie4||ie5)?cal.clientWidth:(w3c)?cal.offsetWidth:300)+'px';
cal.parentNode.style.width=parseInt(calS.style.width)+10+'px';
cal.parentNode.style.height=parseInt(calS.style.height)+10+'px';


<%

Calendar now = Calendar.getInstance();

int currentMonth=now.get(Calendar.MONTH);
int currentYear=now.get(Calendar.YEAR);


%>
<%-- Commented By Ritu for client side date--%>

<%--
now=new Date(); now.ref=new Date();
mi=now.getMonth(); yi=now.getFullYear()-1970;  --%>

<%-- Added By Ritu for server side date calendar --%>

var curDate = '<%=HMSUtil.convertDateToStringWithoutTime(new Date())%>';
now = new Date(curDate.substring(6),(curDate.substring(3,5) - 1) ,curDate.substring(0,2));
now.ref = new Date(curDate.substring(6),(curDate.substring(3,5) - 1) ,curDate.substring(0,2));
mi = '<%=currentMonth%>';
yi = parseInt('<%=currentYear%>')-1970;


updateCalender();
//fillDashBoard('m');
//getLeaveDetails('mrd');

}
// ADD OTHER WINDOW ONLOAD EVENTS HERE...
}

--></script>
<!-- END OF CALENDER JAVASCRIPT CODE -->


<link href="css/style.css" rel="stylesheet" type="text/css" />


<div class="dashBoardArea">
<div id="heading" class="titleBar">Message Board - <a style="cursor:pointer;" onclick="fillDashBoard('m')">Refresh</a></div>
<div class="clear"></div>
<div id="msgToDisplay"><textarea
	style="width: 700px; height: 200px" id="ts" readonly="readonly"
	name="msgToDisplay">
 
 </textarea></div>
<div class="clear"></div>


<!--tab content starts-->

<ul id="countrytabsD" class="shadetabsD">
	<label class="selected" id="r1"
		onclick="getLeaveDetails('mrd');changeState('r1');">MRD</label>
	<!--<label  id="r2"  class="tab"  onclick="getLeaveDetails('billing');changeState('r2');" >Billing</label>
<label class="tab" id="r4" onclick="getLeaveDetails('compbill');changeState('r4');" >Other Billing</label>
-->
	<label class="tab" id="r3"
		onclick="getLeaveDetails('pharmacy');changeState('r3');">Pharmacy</label>
	<label class="tab" id="r5"
		onclick="getLeaveDetails('leave');changeState('r5');">Leaves</label>
</ul>
<div class="clear"></div>
<div class="divisionD"></div>
<div class="tabcontainerD">

<script type="text/javascript">

function changeState(anchorId) 
{
	document.getElementById('r1').className='tab';
	document.getElementById('r2').className='tab';
	document.getElementById('r3').className='tab';
	document.getElementById('r4').className='tab';
	document.getElementById('r5').className='tab';
	
	if(document.getElementById(anchorId).className!='selected')
	{
		document.getElementById(anchorId).className='selected';
	}
	
}

</script> <script type="text/javascript">

function getLeaveDetails(tab)
{

document.getElementById('mrd').style.display='none';
document.getElementById('billing').style.display='none';
document.getElementById('pharmacy').style.display='none';
document.getElementById('compbill').style.display='none';
document.getElementById('leave').style.display='none';
//document.getElementById('etravel').style.display='none';
document.getElementById(tab).style.display='block';
var orGroupId ="";
  var x=document.getElementById(tab)
	
	 //----------------------AJAX PART------------Start------
  
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById(tab).innerHTML='<font id="error">Loading...</font>'
      document.getElementById(tab).innerHTML=""
    }else
      if(xmlHttp.readyState==4){
         document.getElementById(tab).innerHTML = xmlHttp.responseText;
        
      }
    }
    if(tab == 'leave')
   		 xmlHttp.open("GET","/hms/hms/noticeBoard?method=showLeaveDetailsOnDashboard&tab="+tab+'&'+csrfTokenName+'='+csrfTokenValue,true);
    else
    	xmlHttp.open("GET","/hms/hms/noticeBoard?method=showMrdBillingDetailsOnDashboard&tab="+tab+'&'+csrfTokenName+'='+csrfTokenValue,true);
  
  <%-- For Graph  --%>
  if(tab != 'pharmacy' && tab != 'leave'){
  		var so = new SWFObject("/hms/jsp/chart/amcolumn.swf", "amcolumn", "290", "230", "8", "#FFFFFF");
		so.addVariable("path", "/hms/jsp/chart/");
		so.addVariable("settings_file", encodeURIComponent("/hms/jsp/chart/amcolumn_settings.xml"));
	    if(tab == 'mrd'){
			so.addVariable("data_file",  encodeURIComponent("/hms/jsp/chart/amcolumn_data.xml"));
	    }else if(tab == 'billing'){
			so.addVariable("data_file",  encodeURIComponent("/hms/jsp/chart/amcolumn_billing_data.xml"));
	  	}else if(tab == 'compbill'){
			so.addVariable("data_file",  encodeURIComponent("/hms/jsp/chart/amcolumn_comp_billing_data.xml"));
	  	}
	  	
		so.addVariable("preloader_color", "#999999");
		so.write("flashcontent");
	}	
	<%-- End   --%>
	
    xmlHttp.send(null);
//----------------------AJAX PART------------End------
}
</script>

<div id="mrd">

<div class="clear"></div>
</div>

<div id="billing">


<div class="clear"></div>
</div>

<div id="pharmacy">

<div class="clear"></div>
</div>

<div id="compbill">

<div class="clear"></div>
</div>

<div id="leave">
<div class="clear"></div>
</div>
<%
	Map<String,Object> map = new HashMap<String,Object>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>)request.getAttribute("map");
	}
	
	String userName="";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int totalMsg=0;
	if(map.get("totalMsg")!=null){
		totalMsg=(Integer)map.get("totalMsg");
	}
	%>
<div class="clear"></div>
<div class="links"><a
	href="/hms/hrms/leave?method=showLeaveApplicationJsp">Apply Leave</a>
	<div class="clear"></div>
<!-- 
<a href="/hms/hrms/timeSheet?method=showTimeSheetJsp">Time Sheet</a>
<a href="/hms/hrms/training?method=showTrainingRequisitionJsp">Training Requisition</a>
 --></div>




</div>

 <!-- amcolumn script-->
 <script>
function openPopUp()
		{
				window.open('/hms/hms/hes?method=showCommunicationJsp','mywindow','location=1,status=1,scrollbars=1,top=210,left=30,width=960,height=300');

		}
</script>

 
  <script type="text/javascript"
	src="/hms/jsp/chart/swfobject.js"></script>
<div id="flashcontent" style="float: right;"><strong><a style="cursor:pointer;" onclick="getLeaveDetails('mrd')">Click Here to Load Graph</a></strong></div>


<!-- end of amcolumn script -->

<div class="clear"></div>

</div>

<script type="text/javascript">

var countries=new ddtabcontent("countrytabsD")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>

<div class="arrowlistmenu">

<h3 class="menuheader expandable">Our Area</h3>
<ul class="categoryitems">
	<li><a onclick="fillDashBoard('m');">Message Board </a></li>
	<li><a onclick="fillDashBoard('n');">Notice</a></li>
	<li><a onclick="fillDashBoard('p');">Policies</a></li>
	<li><a onclick="fillDashBoard('e');">Events</a></li>
	<li><a onclick="fillDashBoard('h');">Visiting</a></li>
	<li><a onclick="fillDashBoard('a');">Achievements</a></li>
	<li><a onclick="fillDashBoard('o');">On Call List</a></li>
	<% if(userName.equals("admin"))
	{
		%>
		<li><a href="/hms/hms/stores?method=showFSNAnalysisReportJsp">FSN Anlaysis</a></li>
	<li><a href="/hms/hms/purchaseOrder?method=showDrugExpiryReportJsp">Expiry Item On Date</a></li>
		
	<%} %>
	<li>
	<%
	if(totalMsg>0){
		%>
		<a href="javascript:openPopUp()" style="color: red">Communication (<%=totalMsg %>)</a>
		<%
	}else{
	%>
	<a href="javascript:openPopUp()">Communication (<%=totalMsg %>)</a>
	<%} %>
	</li>
	
</ul>
<script type="text/javascript">
function fillDashBoard(para){
  var orGroupId ="";
   var x=document.getElementById("msgToDisplay")
	
	 //----------------------AJAX PART------------Start------
  
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
    if (xmlHttp.readyState>0 && xmlHttp.readyState<4){
     document.getElementById("msgToDisplay").innerHTML='<font id="error">Loading...</font>'
      document.getElementById("msgToDisplay").innerHTML=""
    }else
      if(xmlHttp.readyState==4){
         document.getElementById("msgToDisplay").innerHTML = xmlHttp.responseText;
      }
    }
     
    xmlHttp.open("GET","/hms/hms/noticeBoard?method=showNotice&noticeType="+para+"&viewOnly=y"+"&"+csrfTokenName+"="+csrfTokenValue,true);
  
    xmlHttp.send(null);
//----------------------AJAX PART------------End------
}
</script> <!--
<h3 class="menuheader expandable">Other Links </h3>
<ul class="categoryitems">
<li><a href="/hms/Training/Omega_training.doc">Omega Training Document</a></li>
<li><a href="http://www.clinirx.com" target="blank">www.clinirx.com</a></li>
</ul>

<h3 class="menuheader expandable">Help Desk</h3>
<ul class="categoryitems">
<li><a href="mailto:hrhelpdesk@clinirx.com">hrhelpdesk@clinirx.com</a></li>
<li><a href="mailto:ithelpdesk@clinirx.com">ithelpdesk@clinirx.com</a></li>
<li><a href="mailto:omega@clinirx.com">omega@clinirx.com</a></li>
</ul>
 --></div>



<!--Calendar-->
<div class="floatLeft">
<div id="calendar">
<table border="0" cellpadding="20" cellspacing="0">
	<tbody>
		<tr>

			<td valign="top"><!-- START OF CALENDER HTML CODE --> <layer
				visibility="hide">
			<div>
			<div id="calenderS"></div>
			<div id="calender" class="calMain">
			<center>
			<table class="spanText" style="width: auto;" border="0"
				cellpadding="0" cellspacing="0">
				<tbody>
					<tr valign="bottom" align="center">
						<td class="calMonthYear"><img
							src="/hms/jsp/images/clinirx/back.jpg"
							onMouseDown="setMonth(false)" width="13" border="none"
							height="13"></td>
						<td class="calMonthYear" width="75"><span id="calender_m"
							class="calMonthYear">February</span></td>
						<td class="calMonthYear"><img
							src="/hms/jsp/images/clinirx/next.jpg"
							onMouseDown="setMonth(true)" width="13" border="none" height="13"></td>
						<td class="calMonthYear">&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td class="calMonthYear"><img
							src="/hms/jsp/images/clinirx/back.jpg"
							onMouseDown="setYear(false)" width="13" border="none" height="13"></td>
						<td class="calMonthYear" width="75"><span id="calender_y"
							class="calMonthYear">2009</span></td>
						<td class="calMonthYear"><img
							src="/hms/jsp/images/clinirx/next.jpg"
							onMouseDown="setYear(true)" width="13" border="none" height="13"></td>
					</tr>
				</tbody>
			</table>
			<hr>
			<table border="0" cellpadding="0" cellspacing="0"
				style="background: #FFF; border: 1px solid #98C050; width: 150px;">
				<tbody>
					<tr align="center">
						<td>
						<div class="calHdr">S</div>
						</td>
						<td>
						<div class="calHdr">M</div>
						</td>
						<td>
						<div class="calHdr">T</div>
						</td>
						<td>
						<div class="calHdr">W</div>
						</td>
						<td>
						<div class="calHdr">T</div>
						</td>
						<td>
						<div class="calHdr">F</div>
						</td>
						<td>
						<div class="calHdr">S</div>
						</td>
					</tr>
					<tr align="center">
						<td>
						<div id="cal1" class="calText">1</div>
						</td>
						<td>
						<div id="cal2" class="calText">2</div>
						</td>
						<td>
						<div id="cal3" class="calText">3</div>
						</td>
						<td>
						<div id="cal4" class="calText">4</div>
						</td>
						<td>
						<div id="cal5" class="calToday">5</div>
						</td>
						<td>
						<div id="cal6" class="calText">6</div>
						</td>
						<td>
						<div id="cal7" class="calText">7</div>
						</td>
					</tr>
					<tr align="center">
						<td>
						<div id="cal8" class="calText">8</div>
						</td>
						<td>
						<div id="cal9" class="calText">9</div>
						</td>
						<td>
						<div id="cal10" class="calText">10</div>
						</td>
						<td>
						<div id="cal11" class="calText">11</div>
						</td>
						<td>
						<div id="cal12" class="calText">12</div>
						</td>
						<td>
						<div id="cal13" class="calText">13</div>
						</td>
						<td>
						<div id="cal14" class="calText">14</div>
						</td>
					</tr>
					<tr align="center">
						<td>
						<div id="cal15" class="calText">15</div>
						</td>
						<td>
						<div id="cal16" class="calText">16</div>
						</td>
						<td>
						<div id="cal17" class="calText">17</div>
						</td>
						<td>
						<div id="cal18" class="calText">18</div>
						</td>
						<td>
						<div id="cal19" class="calText">19</div>
						</td>
						<td>
						<div id="cal20" class="calText">20</div>
						</td>
						<td>
						<div id="cal21" class="calText">21</div>
						</td>
					</tr>
					<tr align="center">
						<td>
						<div id="cal22" class="calText">22</div>
						</td>
						<td>
						<div id="cal23" class="calText">23</div>
						</td>
						<td>
						<div id="cal24" class="calText">24</div>
						</td>
						<td>
						<div id="cal25" class="calText">25</div>
						</td>
						<td>
						<div id="cal26" class="calText">26</div>
						</td>
						<td>
						<div id="cal27" class="calText">27</div>
						</td>
						<td>
						<div id="cal28" class="calText">28</div>
						</td>
					</tr>
					<tr align="center">
						<td>
						<div id="cal29" class="calText">&nbsp;</div>
						</td>
						<td>
						<div id="cal30" class="calText">&nbsp;</div>
						</td>
						<td>
						<div id="cal31" class="calText">&nbsp;</div>
						</td>
						<td>
						<div id="cal32" class="calText">&nbsp;</div>
						</td>
						<td>
						<div id="cal33" class="calText">&nbsp;</div>
						</td>
						<td>
						<div id="cal34" class="calText">&nbsp;</div>
						</td>
						<td>
						<div id="cal35" class="calText">&nbsp;</div>
						</td>
					</tr>
					<tr align="center">
						<td>
						<div id="cal36" class="calText">&nbsp;</div>
						</td>
						<td>
						<div id="cal37" class="calText">&nbsp;</div>
						</td>
						<td>
						<div id="cal38" class="calText">&nbsp;</div>
						</td>
						<td>
						<div id="cal39" class="calText">&nbsp;</div>
						</td>
						<td>
						<div id="cal40" class="calText">&nbsp;</div>
						</td>
						<td>
						<div id="cal41" class="calText">&nbsp;</div>
						</td>
						<td>
						<div id="cal42" class="calText">&nbsp;</div>
						</td>
					</tr>
				</tbody>
			</table>
			</center>
			</div>
			</div>
			</layer> <!--END OF CALENDER HTML CODE --></td>
			<td valign="top"></td>
		</tr>
	</tbody>
</table>
</div>
</div>
<div class="clear"></div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<!--Calendar-->