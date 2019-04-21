<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdVaccinationPlan"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/jsjquery-1.2.2.pack.js"></script>
<script type="text/javascript" src="/hms/jsp/js/animatedcollapse.js"></script>

<%--For AutoComplete Through Ajax--%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />
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
function checkDOB(){
	var vDate = new Date() ;
	var dobDate = document.getElementById('startDateId').value ;
	var dateofBirthId = document.getElementById('dateofBirthId').value ;

	var d1 = new Date(dateofBirthId.substring(6),(dateofBirthId.substring(3,5) - 1) ,dateofBirthId.substring(0,2));
	var d = new Date(dobDate.substring(6),(dobDate.substring(3,5) - 1) ,dobDate.substring(0,2));
	var year1 = vDate.getFullYear() ;
	var year = d.getFullYear() ;
	var yearFive = year1-15;

	if(dobDate != ""){
		//if((vDate < d) || (year != yearFive) && (year != yearFour)  && (year != yearThree) && (year != yearTwo)  && (year != yearOne))
		if(vDate > d)
		{
			if(year < yearFive)
			{
				alert("Age cannot be more than 15 years");
				document.getElementById('startDateId').value = "";
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			alert("Please enter valid date of Birthday");
			document.getElementById('startDateId').value = "";
				return false;
		}
	}
	return true;
}

function checkFatherMotherChild()
{
		var b3 = document.getElementById('b3').value;
		var b4 = document.getElementById('b4').value;
		var b5 = document.getElementById('b5').value;
		if((b3=="")&& (b4=="") && (b5=="") )
		{
			alert("Please Enter Father,Mother and Child");
			return false;
		}
		else if((b3=="")&& (b4!="") && (b5!="") )
		{
			alert("Please give Father Height in CMs ");
			return false;
		}
		else if((b3!="")&& (b4=="") && (b5!="") )
		{
			alert("Please give Monther Height in CMs ");
			return false;
		}
		else if((b3!="")&& (b4!="") && (b5=="") )
		{
			alert("Please give Child Age ");
			return false;
		}
			else if((b3!="")&& (b4=="") && (b5=="") )
		{
			alert("Please give Mother Height in CMs and Child Age ");
			return false;
		}
		else if((b3=="")&& (b4!="") && (b5=="") )
		{
			alert("Please give Father Height in CMs and Child Age ");
			return false;
		}
		else if((b3=="")&& (b4=="") && (b5!="") )
		{
			alert("Please give Father and Mother Height in CMs ");
			return false;
		}
		else
		{
				alert("Then Click Calculate button.");
				return true;
		}

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
	var b22 = document.getElementById('b22').value ;
	var b23 = document.getElementById('b23').value ;
	//var b10 = document.getElementById('b10').value ;
	//var b11 = document.getElementById('b11').value ;
	//var b12 = document.getElementById('b12').value ;
	var startDateId = document.getElementById('startDateId').value ;
	if((b1=="")&&(b2==0)&&(b3=="")&&(b4=="")&&(b5=="")&&(b6=="")&&(b7=="")&&(b8=="")&&(b9=="")&&(b22=="")&&(b23=="")&&(startDateId==""))
	{
		alert("Please give some fields.");
		return false;
	}
	else
	{
		return true;
	}
}

function calculated()
{
	var b3= document.getElementById('b3').value ;
	var b4 = document.getElementById('b4').value ;
	var b5= document.getElementById('b5').value ;
	var cal;
	var cal1;
	var cal2;
	var cal3;
	var b6;
	if((b3!="")&& (b4!="") && (b5!="") )
	{

		b3 = parseFloat( b3 );
	    b4 = parseFloat( b4 );

		var cal= b3 + b4;

    	cal1=(cal + 13)/2;
		document.getElementById('b6').value=cal1;
		b6 = document.getElementById('b6').value;
		b6 = parseFloat( b6 );

		cal2=(b6)-8;
		cal3=(b6)+8;
		document.getElementById('b7').value=cal2;
		document.getElementById('b8').value=cal3;

		return true;
	}
	else if((b3=="")&& (b4!="") && (b5!="") )
	{
		alert("Please give Father Height in CMs ");
	}
	else if((b3!="")&& (b4=="") && (b5!="") )
	{
		alert("Please give Monther Height in CMs ");
	}
	else if((b3!="")&& (b4!="") && (b5=="") )
	{
		alert("Please give Child Age ");
	}
		else if((b3!="")&& (b4=="") && (b5=="") )
	{
		alert("Please give Mother Height in CMs and Child Age ");
	}
	else if((b3=="")&& (b4!="") && (b5=="") )
	{
		alert("Please give Father Height in CMs and Child Age ");
	}
	else if((b3=="")&& (b4=="") && (b5!="") )
	{
		alert("Please give Father and Mother Height in CMs ");
	}
	else
	{
			alert("Please give Both Height in CMs And Child Age ");
	}

}

</script>
<script language="javascript">

function weightValidation()
{
	var a = document.getElementById('b10').value ;
	if(a!=0)
	{
		var c = Math.round(a);
		document.getElementById('b10').value=c;
		if(c>17 && c<23)
		{
			document.getElementById('b10').value=c;
			return true;
		}
		else
		{
			alert("Please invaild Weight");
			document.getElementById('b10').value="";
			return false;
		}
	}
}

function heightValidation()
{
	var b = document.getElementById('b11').value ;
	if(b!=0)
	{
		var d = Math.round(b);
		document.getElementById('b11').value=d;
		if(d>118 && d<144)
		{
			document.getElementById('b11').value=d;
			return true;
		}
		else
		{
			alert("Please invaild Height");
			document.getElementById('b11').value="";
			return false;
		}

	}
}

function hcValidation()
{
	var c = document.getElementById('b12').value ;
	if(c!="")
	{
		var d = parseInt(c);
		document.getElementById('b12').value=d;
		if(d>118 && d<144)
		{
			document.getElementById('b12').value=d;
			return true;
		}
		else
		{
			alert("Please invaild Hc");
			document.getElementById('b12').value="";
			return false;
		}

	}
}

function weightValidation1()
{
	var a = document.getElementById('kgS').value ;
	if(a!=0)
	{
		var c = Math.round(a);
		document.getElementById('kgS').value=c;

	}
}

function heightValidation1()
{
	var b = document.getElementById('htcS').value ;
	if(b!=0)
	{
		var d = Math.round(b);
		document.getElementById('htcS').value=d;

	}
}

function hcValidation1()
{
	var c = document.getElementById('b12').value ;
	if(c!="")
	{
		var d = parseInt(c);
		document.getElementById('b12').value=d;

	}
}



function cal_bmiS(kgS, htcS){


   mS = htcS/100;
   h2S = mS * mS;

   bmiS = kgS/h2S;


   f_bmiS = Math.floor(bmiS);

   diffS  = bmiS - f_bmiS;
   diffS = diffS * 10;

   diffS = Math.round(diffS);
   if (diffS == 10){
      // Need to bump up the whole thing instead
      f_bmiS += 1;
      diffS = 0;
   }
   bmiS = f_bmiS + "." + diffS;

   return bmiS;
}
function computeS(){
   var fS = self.document.pediatricCaseSheet;

   // Set up variables for calculation
   wS = fS.kgS.value;
//   i = parseInt(f.htc.value);
   iS = fS.htcS.value;

   // Do validation checking to ensure existence of values

   if (!chkwS(i)){
     alert("Please enter a number for your height.");
     fS.htcS.focus();
     return;
   }
   if (!chkwS(wS)){
     alert("Please enter a number for your weight.");
     fS.kgS.focus();
     return;
   }

   fS.bmiS.value = cal_bmiS(wS, iS);
   fS.bmiS.focus();
}
function chkwS(wS){
  // if (isNaN(parseInt(wS))){
   if (isNaN(wS)){
	  return false;
   } else if (wS < 0){
  return false;
  }
  else{
  return true;
  }
}


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
		int height = 0;
		int weight = 0;
		String buttonFlag="";
		 List patientDataList = new ArrayList();

	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
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
	String patientDOBInString="";
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
	 if(visit.getHin().getDateOfBirth()!= null){
		 patientDOBInString =HMSUtil.changeDateToddMMyyyy(visit.getHin().getDateOfBirth());
	 }

	 if(map.get("height") != null)
	 {
		 height=(Integer)map.get("height");

	 }
	 if(map.get("weight") != null)
	 {
		 weight=(Integer)map.get("weight");

	 }
	 List opdVaccinationPlanList = new ArrayList();
		if(map.get("opdVaccinationPlanList") != null){
			opdVaccinationPlanList=(List)map.get("opdVaccinationPlanList");
		}

		List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
		 if(map.get("employeeList") != null){
				employeeList = (List<MasEmployee>) map.get("employeeList");
			}

%>
<!--main content placeholder starts here-->
<link href="css/hms_style.css" rel="stylesheet" type="text/css" />
<form name="pediatricCaseSheet" action="" method="post">
<input type="hidden" name="<%=DEPARTMENT_ID %>"	value="<%=visit.getDepartment().getId() %>" />
<input type="hidden" id="heights" value="" /> <%if(visit.getDepartment()!= null){ %>
<div class="titleBg">
<h2>Pediatric Case Sheet</h2>
</div>
<div class="clear"></div>
<%} %> <!--Block One Starts-->
<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">
<label class="medium"><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<%
if(visit.getHin().getHinNo()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label>
<%
}
else{
%>
<label class="valueMedium">-</label>
<%
}
%>
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
<%
}
else
{
%>
<label class="valueMedium">-</label>
<%
}
%>
<label class="medium">Visit Date </label>
<%
if(visitDateInString != null){ %> <label class="valueMedium"><%=visitDateInString %></label>
<%}
else{
	%>
	<label class="valueMedium">-</label> <%} %>

<div class="clear"></div>
<label class="medium"><%=prop.getProperty("com.jkt.hms.opd_no") %></label>
<%if(visit.getVisitNo()!= null)
{ %>
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
<!--Block one Ends--> <!--Block two Start-->
<div class="clear"></div>
<div class="division"></div>
<h4>Vaccine Plan</h4>
<div class="clear"></div>
<div class="clear"></div>
<div class="tableHolderAuto">
<%
if(opdVaccinationPlanList.size()!=0) {
Iterator itrObj=opdVaccinationPlanList.iterator();
%>
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">
	<tr>
		<th>Vaccine</th>
		<th>Vaccine Date</th>
		<th>Completion Date</th>
		<th>Remarks</th>
	</tr>
	<%
int i=1;
while(itrObj.hasNext())
{
	OpdVaccinationPlan opdVaccinMstObj=(OpdVaccinationPlan)itrObj.next();
%>
	<tr>
		<td width="7%">
		<input type="hidden" name="<%=VACCINATION_ID %>"value="<%=opdVaccinMstObj.getId() %>" id="vaccinationId<%=i %>" />
		<input	type="hidden" value="<%=opdVaccinMstObj.getVaccin().getId() %>"			name="<%=VACCINE_ID%>" id="vaccineId<%=i %>" validate="Vaccine Id,num,no" />
		<input type="text" size="12" tabindex="1" name="<%=VACCINE_NAME%>" value="<%=opdVaccinMstObj.getVaccin().getVaccinName() %>"		id="vaccineCode<%=i %>" validate="Vaccine,string,no" readonly /></td>
		<td width="10%">
		<%if(opdVaccinMstObj.getVaccinDate()==null)
		{
		%>
		<input type="text" value="" id="totalId<%=i %>" size="8" validate="Vaccine Date" tabindex="1" name="<%=VACCINE_DATE%>"	readonly="readonly" />
			<%
			}
		else
		{
		%>
		<input type="text"	value="<%=HMSUtil.changeDateToddMMyyyy(opdVaccinMstObj.getVaccinDate()) %>"	id="totalId<%=i %>" size="8" validate="Vaccine Date" tabindex="1"	name="<%=VACCINE_DATE %>" readonly="readonly" /> <%} %>
		</td>
		<td width="7%">
		<%if(opdVaccinMstObj.getVaccinCompleteDate()==null)
		{
		%>
		<input type="text" id="CompletionDate<%=i %>" tabindex="1"
			name="<%=COMPLETION_DATE %>" value="" readonly="readonly"
			onblur="checkDate(<%=i %>)" size="8" />
			<%
			}
		else
		{
		%>
		<input type="text" id="CompletionDate<%=i %>" tabindex="1" name="<%=COMPLETION_DATE %>"	value="<%=HMSUtil.changeDateToddMMyyyy(opdVaccinMstObj.getVaccinCompleteDate()) %>"	readonly="readonly" onblur="checkDate(<%=i %>)" size="8" /> <%} %>
		</td>
		<td width="7%">
		<%if(opdVaccinMstObj.getRemarks()==null)
		{
		%>
		<input type="text" id="remarks<%=i %>" tabindex="1"	name="<%=REMARKS %>" value="" size="10" readonly="readonly"	validate="Remarks,String,no" />
		<%
		}
		else
		{%>
		<input type="text"	id="<%=REMARKS %>" size="10" tabindex="1" name="<%=REMARKS %>2"	value="<%=opdVaccinMstObj.getRemarks() %>" readonly="readonly"	validate="Remarks,String,no" />
		<%
		}
		%>
		</td>
	</tr>
	<%
		i++;
      }
	}
	else
	{%>
</table>
<table width="100%" id="chargeDetails" cellpadding="0" cellspacing="0">
	<tr>
		<th>Vaccine</th>
		<th>Vaccine Date</th>
		<th>Completion Date</th>
		<th>Remarks</th>
	</tr>
	<tr>
		<td width="7%">
		<input type="text" tabindex="1"	name="<%=VACCINE_NAME%>2" value="" size="12" id="vaccineCode"	validate="Vaccine,string,no" readonly /></td>
		<td width="10%"><input type="text" value="" id="totalId" size="8" validate="Vaccine Date" tabindex="1" name="<%=VACCINE_DATE %>" readonly="readonly" /></td>
		<td width="7%"><input type="text" id="CompletionDate" tabindex="1" name="<%=COMPLETION_DATE %>" value="" size="8" readonly="readonly" /></td>
		<td width="7%"><input type="text" id="remarks" tabindex="1" name="<%=REMARKS %>" value="" readonly="readonly" validate="Remarks,String,no" size="10" /></td>
	</tr>
	<%}%>
</table>
</div>
<div class="clear"></div>
<div class="floatRight">
<input type="button" class="button" value="Vaccination" onclick="showVaccination('pediatricCaseSheet');" />
</div>
<div class="clear"></div>

<div class="division"></div>
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Date of Birth</label> <%if(visit.getHin().getDateOfBirth()!=null){ %>
<input type="text" class="date" id="startDateId" name="<%=DATE_OF_BIRTH %>" value="<%=patientDOBInString %>" readonly="readonly" MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" onClick="javascript:setdate('<%=patientDOBInString %>',document.pediatricCaseSheet.<%=DATE_OF_BIRTH%>,'event')" />
<%
}
else
{
%>
<label class="value">-</label>
 <%
 }
 %>
 <label>Referred By</label>
<select id="b2" name="<%=EMPLOYEE_ID %>" validate="Refered By,string,no">
<option value="0">Select</option>
<%
String empName ="";
		for (MasEmployee masEmployee : employeeList) {
			empName = masEmployee.getFirstName();
			if(masEmployee.getMiddleName()!=null)
			{
				empName = empName+" "+masEmployee.getMiddleName();
			}
			if(masEmployee.getLastName()!=null)
			{
				empName = empName+" "+masEmployee.getLastName();
			}
%>
<option value="<%=masEmployee.getId()%>"><%=empName%></option>
<%
					}
					%>
</select>
<div class="clear"></div>
<label>Wt</label>
<input type="text" id="b10" value=<%=weight%>
	class="small" validate="Wt,num,no" tabindex="1" readonly="readonly" />
<label	class="readOnlySmall">(18.5-24.9)</label>
<label>Ht</label>
<input	type="text" id="b11" value=<%=height%> class="small"
	validate="Ht,num,no" tabindex="1" readonly="readonly" />
<label class="readOnlySmall">(119-144)</label>
<label>Hc</label>
<input
	type="text" id="b12" name="<%=HIV %>" class="small"
	validate="Hc,num,no" MAXLENGTH="3" tabindex="1"
	onblur="hcValidation1();" onmousedown="hcValidation1();" />
<label	class="small">(119-144)</label>
<div class="clear"></div>
<label>OFC</label>
<input type="text" id="b22" name="<%=OFC%>"	validate="OFC,float,no" MAXLENGTH="5" tabindex="1" />
 <label	class="small">cm</label>
 <label>RR</label>
 <input type="text" id="b23" name="<%=RR%>" validate="RR,float,no" MAXLENGTH="5" tabindex="1" />
 <label class="small">min</label>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<!--tab content starts-->
<ul id="countrytabs" class="shadetabs">
	<li><a href="#" rel="country1" class="selected">Clinical Notes</a></li>
	<li><a href="#" rel="country2">Exp. HT</a></li>
	<li><a href="#" rel="country3">BMI</a></li>
</ul>
<div class="tabcontainer">
<div id="country1" class="tabcontent"><label></label>
<textarea 	maxlength="1000" onkeyup="return ismaxlength(this)" name="<%=CLINICAL_NOTE %>" class="large" id="b1"></textarea>
<div class="clear"></div>
</div>
<div id="country2" class="tabcontent">
<div class="paddLeft30">
<label class="common">Father</label>
<!-------->
<label class="common">Mother</label></div>
<div class="clear"></div>
<label>Height in CM</label>
<!--------> <input id="b3" type="text"	maxlength="3" name="<%=HEIGHT_IN_CM_FATHER %>" class="calDate"	validate="Height in CM Father,num,no" />
<div class="paddLeft55"><input id="b4" type="text"	name="<%=HEIGHT_IN_CM_MOTHER %>" maxlength="3" class="calDate"	validate="Height in CM Mother,num,no" /></div>
<div class="clear"></div>
<label>Child's Age</label> <input id="b5" type="text" maxlength="2"	name="<%=AGE %>" class="calDate" validate="Child's Age,num,no" />
<div class="paddLeft55"><input type="button" class="button"	value="Calculate" onclick="calculated();" /></div>
<input type="hidden" class="button" value="History"	onclick="submitForm('pediatricCaseSheet','opd?method=showPatientHistoryJsp&visitId=<%=visit.getId() %>');" />
<div class="clear"></div>
<div class="Height10"></div>
<div class="paddLeft30"><label class="common">Child</label></div>
<div class="clear"></div>
<div class="Height10"></div>
<label>Height in CM</label>
<input id="b6" type="text" name="<%=HEIGHT_IN_CM_CHILD %>" maxlength="3" class="readOnly" validate="Height in CM Child,num,no" readonly="readonly" onmousedown="checkFatherMotherChild();" />
<div class="clear"></div>
<label>3rd Percentile</label>
<input id="b7" type="text" name="<%=RD_PERCENDTILE %>" maxlength="20" class="readOnly" validate="3rd Percentile,num,no" readonly="readonly" onmousedown="checkFatherMotherChild();" />
<div class="clear"></div>
<label>97th Percentile</label>
<input id="b8" type="text"	name="<%=TH_PERCENDTILE %>" maxlength="20" class="readOnly" validate="97th Percentile,num,no" readonly="readonly" onmousedown="checkFatherMotherChild();" />
<div class="clear"></div>
<label>Remarks</label>
<textarea maxlength="50" onkeyup="return ismaxlength(this)" name="<%=REMARKS_TEMP %>" id="b9"></textarea>
<div class="clear"></div>
</div>
<div id="country3" class="tabcontent">
<div class="paddLeft30"><label class="auto"> <u>Body
mass index (BMI)</u> is measure of body fat based on height and weight that
applies to both adult men and women. </label>
<div class="clear"></div>
<label> <b><u>BMI Categories</u></b> </label>
<div class="clear"></div>
<li>Normal weight = 18.5-24.9</li>
<li>Overweight = 25-29.9</li>
<li>Obesity = BMI of 30 or greater</li>
</div>
<TABLE WIDTH="600" CELLPADDING="0" CELLSPACING="0" BORDER="0"
	SUMMARY="This table is used for layout purposes only.">
	<TR>
		<TD ALIGN="LEFT"></TD>
	</TR>
	<TR>
		<TD COLSPAN="2" ALIGN="LEFT"></TD>
	</TR>
</TABLE>
<div class="clear"></div>
<TABLE SUMMARY="This table is used for layout purposes only.">
	<TR>
		<TD>
		<TABLE BORDER="0" CELLSPACING="0" WIDTH="185" BGCOLOR="#FFFFFF"	CELLPADDING="2"	SUMMARY="This table is used for layout purposes only.">
			<TR>
				<TD COLSPAN="2" ALIGN="center">
				<TABLE CELLSPACING="0" CELLPADDING="0" BORDER="0" WIDTH="143" SUMMARY="This table is used for layout purposes only.">
					<TR>
						<TD ROWSPAN="3" ALIGN="right" WIDTH="50">
						<IMG SRC="/hms/jsp/images/BMI/bmi_1-4.gif" ALT=" " WIDTH="36" HEIGHT="201"></TD>
						<TD VALIGN="top" WIDTH="50">
						<img src="/hms/jsp/images/BMI/bmi_2-4.gif" alt=" " width="50" height="76" /></TD>
						<TD ROWSPAN="3" ALIGN="left" WIDTH="92">
						<IMG SRC="/hms/jsp/images/BMI/bmi_4-4.gif" ALT=" " WIDTH="57" HEIGHT="201"></TD>
					</TR>
					<TR>
						<TD ALIGN="center">
						<INPUT NAME="bmiS" TYPE="text" SIZE="4" STYLE="width: 30px; float: none;" id="yourbmi"></TD>
					</TR>
					<TR>
						<TD VALIGN="bottom">
						<img src="/hms/jsp/images/BMI/bmi_3-4.gif" alt=" " width="50" height="96" /></TD>
					</TR>
				</TABLE>
				</TD>
			</TR>
			<TR>
				<TD >
				<SPAN STYLE="font-size: 10pt;">
				<B>
				<LABEL FOR="htcS">&nbsp;Your Height:</LABEL>
				</B>
				</SPAN>
				</TD>
				<TD  ALIGN="left">
				<INPUT TYPE="text" NAME="htcS" size="3" ID="htcS" MAXLENGTH="4" value=<%=height%> validate="Height,num,no" onblur="heightValidation1();" onmousedown="heightValidation1();"></TD>
			</TR>
			<TR>
				<TD ><SPAN STYLE="font-size: 10pt;">&nbsp;</SPAN></TD>
				<TD  ALIGN="left"><B>
				<SPAN STYLE="font-size: 10pt;"> (centimeters)</SPAN>
				</B>
				</TD>
			</TR>
			<TR>
				<TD ><SPAN STYLE="font-size: 10pt;"><B><LABEL
					FOR="kgS">&nbsp;Your Weight:</LABEL></B></SPAN></TD>
				<TD  ALIGN="left">
				<P><INPUT TYPE="text" NAME="kgS" size="3" MAXLENGTH="4" ID="kgS"
					value=<%=weight%> validate="Weight,num,no"
					onblur="weightValidation1();" onmousedown="weightValidation1();"></P>
				</TD>
			</TR>
			<TR>
				<TD ><SPAN STYLE="font-size: 10pt;">&nbsp;</SPAN></TD>
				<TD  ALIGN="left"><B><SPAN
					STYLE="font-size: 10pt;"> (kilograms)</SPAN></B></TD>
			</TR>
			<TR>
				<TD COLSPAN="2" ALIGN="center"><INPUT TYPE="button"
					class="button" VALUE="Compute BMI" ONCLICK="self.computeS();"></TD>
			</TR>
		</TABLE>
		<TABLE BORDER="0" CELLSPACING="0" CELLPADDING="10" WIDTH="600">
			<TR>
				<TD VALIGN="top" COLSPAN="3"></TD>
			</TR>
			<TR>
				<TD VALIGN="top"></TD>
				<TD ALIGN="center" VALIGN="top"></TD>
				<TD VALIGN="top"></TD>
			</TR>
			<TR>
				<TD VALIGN="top">&nbsp;</TD>
				<TD ALIGN="center" VALIGN="top"></TD>
				<TD VALIGN="top">&nbsp;</TD>
			</TR>
		</TABLE>
		</TD>
	</TR>
</TABLE>

</div>
</div>
<script type="text/javascript">

var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()

</script>

<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" value="Submit"	onclick="submitForm('pediatricCaseSheet','opd?method=addPediatricCaseSheet','checkDOB','blankSpace');"	align="right" />
<input type="button" class="button" value="View"	onclick="showView('pediatricCaseSheet');" align="right" />
<input	name="Back" type="button" src="images/phaseII/delete.gif" alt="Back"	value="Back" class="button" onclick="history.go(-1);return false;"	align="right" />
<div class="clear"></div>
<div class="division"></div>
<div class="bottom">
<label>Changed By</label>
 <label class="value"><%=userName%></label>
 <label>Changed Date</label> <label class="value"><%=date%></label>
 <label>Changed Time</label>
 <label class="value"><%=time%></label>
<div class="clear"></div>
<input type="hidden" name="<%=HIN_ID %>"	value="<%=visit.getHin().getId() %>">
<input type="hidden"	name="<%=VISIT_ID %>" value="<%=visit.getId() %>">
<input	type="hidden" name="<%=VISIT_NUMBER %>"value="<%=visit.getVisitNo() %>">
<input type="hidden" name="currentVisitId" value="<%=visit.getId() %>"> <%if(visit.getHin().getDateOfBirth()!=null){ %>
<input type="hidden" name="dateofBirthId" id="dateofBirthId"	value="<%=HMSUtil.changeDateToddMMyyyy(visit.getHin().getDateOfBirth()) %>">
<%} %>
</div>
<div class="paddingTop40"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<script type="text/javascript">
function showVaccination(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/opd?method=showPediatricVaccinationPlanJsp&visitId=<%=visit.getId()%>";
  obj.submit();
}
function showView(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/opd?method=viewPediatricCaseSheet&flag=prev&viewScreen=no";
  obj.submit();
}

function showBack(formName)
{
  obj = eval('document.'+formName)
  obj.action = "/hms/hms/opd?method=showWaitingPatientListJsp";
  obj.submit();
}
</script>