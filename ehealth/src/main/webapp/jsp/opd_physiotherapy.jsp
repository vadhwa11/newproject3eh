
<%@page import="jkt.hms.masters.business.MasModularity"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.OpdTemplate"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
	function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""
	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
	}
	</script>
<script type="text/javascript" language="javascript">
	<%

	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String getDate=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
	month="0"+month;
	}
	if(getDate.length()<2){
	getDate="0"+getDate;
	}

	%>
	serverdate = '<%=getDate+"/"+month+"/"+year%>'
	</script>

<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.6.pack.js"></script>

<!--  <script type="text/javascript" src="/hms/jsp/js/ddaccordion.js">

	/***********************************************
	* Accordion Content script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
	* Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
	* This notice must stay intact for legal use
	***********************************************/

	</script>-->
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

<%--For AutoComplete Through Ajax--%>

<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<%


URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);

		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

		}


		List patientDataList = new ArrayList();

		if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");

		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		Map<String,Object> mapForDS= new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String consultationDate = (String)utilMap.get("currentDate");
		String consultationTime = (String)utilMap.get("currentTime");

		int hospitalId=0;
		if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
		}


		List<MasDepartment> deptList= new ArrayList<MasDepartment>();
		if(map.get("deptList") != null){
		deptList=(List)map.get("deptList");
		}
		List<MasEmployee> phytherapyList=new ArrayList<MasEmployee>();
		if(map.get("phytherapyList")!=null)
		{
			phytherapyList =(List)map.get("phytherapyList");
		}

		List<MasModularity> modularityList=new ArrayList<MasModularity>();
		if(map.get("modularityList")!=null)
		{
			modularityList =(List)map.get("modularityList");
		}


		String userName = "";
		if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
		}
		String deptName="";
		if(map.get("deptName") != null){
			deptName=(String)map.get("deptName");
			}

		Visit visit=(Visit)patientDataList.get(0);
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
		int deptId=visit.getDepartment().getId();
		String departmentName=visit.getDepartment().getDepartmentName();
		int deptId1=Integer.parseInt(""+session.getAttribute("deptId"));
		Set listSet= new HashSet();
		listSet = (Set)visit.getOpdPatientDetails();
		OpdPatientDetails opdPatientDetails =null;
		for(Iterator it=listSet.iterator();it.hasNext();)
		{
				opdPatientDetails =(OpdPatientDetails)it.next();
		}

		%>


<!--main content placeholder starts here-->
<form name="opdMain" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"><input type="hidden"
	name="userName" value="<%=userName %>" />
<div class="titleBg">
<h2><%=deptName%></h2>
</div>
 <script type="text/javascript">
		   var icdArray=new Array();
	</script> <%
				if(map.get("message") != null){
				   String message = (String)map.get("message");
				   out.println(message);
				  }


		    %> <!--Block One Starts-->

<div class="clear"></div>
<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block"><label><%=prop.getProperty("com.jkt.hms.registration_no") %></label> <%if(visit.getHin().getHinNo()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getHinNo() %></label> <%}else{ %>
<label class="valueMedium">-</label> <%} %> <label>Patient Name </label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %> <label
	class="value">- </label> <%} %> <label class="medium">Age</label> <%if(visit.getHin().getAge()!= null){ %>
<label class="valueMedium"><%=visit.getHin().getAge() %></label> <%}else{ %>
<label class="valueMedium">-</label> <%} %> <label class="medium">Visit
Date </label> <%if(visitDateInString != null){ %> <label class="valueMedium"><%=visitDateInString %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>

<div class="clear"></div>

<label class=""><%=prop.getProperty("com.jkt.hms.opd_no") %></label> <%if(visit.getVisitNo()!= null){ %> <label
	class="valueMedium"><%=visit.getVisitNo() %></label> <%}else{ %> <label
	class="valueMedium">-</label> <%} %> <label>Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label> <%}else{ %> <label>-</label>
<%} %>
 <label class="medium">Phone No.</label> <% if(visit.getHin().getPhoneNumber()!= null && !visit.getHin().getPhoneNumber().equals("")){%>
<label class="valueMedium"><%=visit.getHin().getPhoneNumber() %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %> <label
	class="medium">Mobile No.</label> <% if(visit.getHin().getMobileNumber()!= null && !visit.getHin().getMobileNumber().equals("")){%>
<label class="valueMedium"><%=visit.getHin().getMobileNumber() %></label>
<%}else{ %> <label class="valueMedium">-</label> <%} %>
<div class="clear"></div>
<label>Consulting Doctor</label>
<%
String doctorName="";
 if(visit.getDoctor()!=null)
 {
	doctorName = visit.getDoctor().getFirstName();
	if(visit.getDoctor().getMiddleName()!=null)
	{

		doctorName = doctorName+" "+visit.getDoctor().getMiddleName();
	}
	if(visit.getDoctor().getLastName()!=null)
	{

		doctorName = doctorName+" "+visit.getDoctor().getLastName();
	}
 }
%>
<label class="value"><%=doctorName%></label>
<label class="medium">Prev. Diag </label> <%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %> <label class="value">-</label> <%} %>
<label>Patient for Physiotheraphy:</label>
<%--<%
if(opdPatientDetails.getPhysiotheraphy()!=null)
{
%>
<label class="valueAuto"><%=opdPatientDetails.getPhysiotheraphy()%></label>
<%}else{%>
	<label class="valueAuto">-</label>
<%} %> --%>

<input type="hidden" name="visitId" value="<%=visit.getId()%>" />
<input type="hidden" name="hinId" value="<%=visit.getHin().getId()%>" />
<input type="hidden" name="<%=HIN_NO%>" value="<%=visit.getHin().getId()%>" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="button" name="priv" id="priv" value="Patient Previous Details"	class="buttonBig3" onclick="showPreviousVisit(<%=visit.getVisitNo()%>)"/>
<div class="Block">
<div class="clear"></div>
<label>
<span>*</span> Physiotherapist Name</label> <select name="physiotherapistNameId" id="physiotherapistNameId">
	<option value="0">Select</option>
	<%
	Iterator it= phytherapyList.iterator();
	 while(it.hasNext())
	  {
		 MasEmployee emp=(MasEmployee)it.next();
		 int empId =emp.getId();
		 String empName =emp.getFirstName();
		 if(emp.getMiddleName()!=null){
			 empName=empName+" "+emp.getMiddleName();
		 }
		 if(emp.getLastName()!=null){
			 empName=empName+" "+emp.getLastName();
		 }
	 %>
	<option value="<%=empId%>"><%=empName%></option>

	 <%}%>
	</select>
<label><span>*</span> H/O & Examination</label>
<textarea id="hoExaminationId" name="hoExaminationId" rows="15" cols="15"></textarea>

<label><span>*</span> Plan of care & Goals</label>
<textarea id="plancaregoalsId" name="plancaregoalsId" rows="15" cols="15"></textarea>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input	type="button" class="buttonAdd" alt="Add" value="&nbsp;"	 align="right" onclick="addRow();"/>
<input type="button" class="buttonDel" alt="Delete" value="&nbsp;"	 align="right" onclick="removeRow();"/>
<div class="clear"></div>
<table border="0" width="50%" align="center" cellpadding="0" cellspacing="0"
	id="tblSample">
	<tr><th><span>*</span>  Modality Name</th><th> <span>*</span>  Remarks</th></tr>

<tr><td>
<%int inc=1; %>
<select name="modalityNameId" id="modalityNameId<%=inc%>">
	<option value="0">Select</option>
	<%
	Iterator itr= modularityList.iterator();
	 while(itr.hasNext())
	  {
		 MasModularity modu=(MasModularity)itr.next();
		 int md_id= modu.getId();
		 String md_name=modu.getModularityName();
	 %>
	<option value="<%=md_id%>"><%=md_name%></option>

	 <%}%>
	</select>
	<%
		MasModularity  masModularity = new MasModularity();

				         for (int i = 0; i < modularityList.size(); i++) {
				        	 masModularity = (MasModularity) modularityList.get(i);
	     			 %>
	<script>
	     		 icdArray[<%=i%>]= new Array();
		          icdArray[<%=i%>][0] = "<%=masModularity.getId()%>";
		          icdArray[<%=i%>][1] = "<%=masModularity.getModularityName()%>";
	            </script> <% }%>

	</td>
	<td><input type="text" name="remarksId" size="100" id="remarksId<%=inc%>" />
	</td>
</tr>
</table>
<div class="clear"></div>
<div class="paddingTop15"></div>
<input type="hidden" name="hidvalId" id="hidvalId"  value="<%=inc%>" />
<label>Prognosis Reports</label>
<textarea id="prognosisReportsId" name="prognosisReportsId" rows="15" class="large" cols="15"></textarea>
<div class="clear"></div>

<div class="division"></div>
<div class="clear"></div>
<input name="Submit" type="button" align="right" tabindex="1"	class="button" value="Submit"	onclick="if(validateFieldValues())submitForm('opdMain','opd?method=submitOPDPhysiotherapyJsp');" />
<input name="Reset" type="reset" align="right" class="buttonHighlight"	value="Reset" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="paddingTop40"></div>
<script type="text/javascript">

	function validateFieldValues(){
	  var physiotherapistNameId = document.getElementById("physiotherapistNameId").value;
	  if(physiotherapistNameId=='0')
	 {
     	alert("Please Select the Physiotherapist Name !");
     	document.getElementById("physiotherapistNameId").focus();
     	return false;
      }
	  var hoExaminationId = document.getElementById("hoExaminationId").value;
      if(hoExaminationId=="")
      {
			alert("Please Enter The H/O Examination Details !");
			document.getElementById("hoExaminationId").focus();
			return false;
      }
	  var plancaregoalsId = document.getElementById("plancaregoalsId").value;
	  if(plancaregoalsId=="")
      {
			alert("Please Enter The Plan of care & Goals Details !");
			document.getElementById("plancaregoalsId").focus();
			return false;
      }


	    //code for chaecking investigation requistion tblSample
	    var tbl = document.getElementById('tblSample');
		  var lastRow = tbl.rows.length;
		  for(var i=1;i<lastRow;i++){
		  var modalityNameId=document.getElementById("modalityNameId"+i).value;
		  if(modalityNameId=="0")
		  {
			alert("Please select the Modality type !");
			document.getElementById("modalityNameId"+i).focus();
			return false;
		  }
		  if(modalityNameId!=""){

		  	if(document.getElementById("remarksId"+i).value==""){
		  		alert("Please Enter the Remarks Details. "+i);
		  		document.getElementById("remarksId"+i).focus();
		  		return false;
		         }
		      }

		  }
	    return true;
	}

	function addRow(){

	  var tbl = document.getElementById('tblSample');
	  var lastRow = tbl.rows.length;
	  var hidvalId = document.getElementById('hidvalId');
	  var iteration = parseInt(hidvalId.value)+1;
	  hidvalId.value = iteration;
	  var row = tbl.insertRow(lastRow);

	  var cellRight0 = row.insertCell(0);
	  var e0 = document.createElement('Select');
	  e0.name='modalityNameId';
	  e0.id='modalityNameId'+iteration;
	  e0.classname='smalllabel'
	  e0.options[0] = new Option('Select', 'value0');
	   for(var i = 0;i<icdArray.length;i++ ){
	      e0.options[icdArray[i][0]] = new Option(icdArray[i][1],icdArray[i][0]);
	      }
	  cellRight0.appendChild(e0);
	  var cellRight1 = row.insertCell(1);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.size = '100';
	  e1.name='remarksId';
	  e1.id='remarksId'+iteration;
	  cellRight1.appendChild(e1);


	}
	function removeRow()
	{
	  var tbl = document.getElementById('tblSample');
	  var lastRow = tbl.rows.length;

	  if (lastRow > 2){
	   tbl.deleteRow(lastRow - 1);
	   }
	  var hidvalId = document.getElementById('hidvalId');

	  hidvalId.value=hidvalId.value-1

	}

	function showPreviousVisit(visitNo){
	//alert("in showPreviousVisit"+visitNo)
	if(visitNo >1){
var url="/hms/hms/opd?method=showPatientPhysiotheraypPreviousVisit1&hinId=<%=visit.getHin().getId()%>";
//alert("url--->"+url)
newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=1");
//      document.opdMain.action="/hms/hms/opd?method=showPatientPhysiotheraypPreviousVisit&hinId=<%=visit.getHin().getId()%>&deptId=<%=visit.getDepartment().getId()%>&visitNo=<%=visit.getVisitNo() %>";
     // document.opdMain.submit();
      }else{
        alert("This Is Patient's first Visit.")
      }
   }
</script>
</form>


<%
deptList.clear();
listSet.clear();
modularityList.clear();
patientDataList.clear();

%>