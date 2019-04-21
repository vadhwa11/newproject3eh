<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.*"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascrip"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>



 <script>
	<%

	URL myURL=application.getResource("/WEB-INF/commonFile.properties");
	InputStream in = myURL.openStream();
	Properties prop = new Properties();
	prop.load(in);

		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date1=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
	%>
	serverdate = '<%=date1+"/"+month+"/"+year%>'
</script>

<script language="javascript">

function jsImport()
{
	
	  var tbl = document.getElementById('documentTable');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('uploadCount');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("upload"+i)!=null && (typeof  document.getElementById("upload"+i).checked)!='undefined' && document.getElementById("<%=UPLOAD_FILENAME%>"+i).value!="" )
			  {
			  totalSelected=totalSelected+1;
			  }
		  }
	      if(totalSelected==0)
		  {
	    	  alert('Pl. Select a file to Import!.....');
	    	  return;
		  }
	
	
	<%-- var fname1 = document.appointmentUpload.upload_filename1.value;
	var fname2 = document.appointmentUpload.upload_filename2.value;
	var fname3 = document.appointmentUpload.upload_filename3.value;
	var fname4 = document.appointmentUpload.upload_filename4.value;
	var fname5 = document.appointmentUpload.upload_filename5.value;
	//var st = fname.length;
	//st = st-3;
	//if (fname.substring(st)!="zip")
	//{
	//alert('Only zip files are Allowed. Please Zip all the Excel Files and Give the file as input !....For further Help, Refer User Manual.');
	//return;
	//}
	var ind1 = fname1.lastIndexOf("\\");
	var ind2 = fname2.lastIndexOf("\\");
	var ind3 = fname3.lastIndexOf("\\");
	var ind4 = fname4.lastIndexOf("\\");
	var ind5 = fname5.lastIndexOf("\\");
	var filename1 = fname1.substring(ind1+1);
	var filename2 = fname2.substring(ind2+1);
	var filename3 = fname3.substring(ind3+1);
	var filename4 = fname4.substring(ind4+1);
	var filename5 = fname5.substring(ind5+1);

	var changed_by = document.getElementById("<%=CHANGED_BY%>").value;
	var changed_date = document.getElementById("<%=CHANGED_DATE%>").value;
	var changed_time = document.getElementById("<%=CHANGED_TIME%>").value;
	var hospitalId =  document.getElementById("hospitalId").value;
	var deptId = document.getElementById("deptId").value; --%>

	document.appointmentUpload.method="post";
	submitForm('appointmentUpload','opd?method=submitUploadDocuments&'+csrfTokenName+'='+csrfTokenValue);


<%-- 	submitForm('appointmentUpload','opd?method=submitUploadDocuments&filename1='+filename1+'&filename2='+filename2+'&filename3='+filename3+'&filename4='+filename4+'&filename5='+filename5 + '&<%=CHANGED_BY%>=' + changed_by + '&<%=CHANGED_DATE%>=' + changed_date + '&<%=CHANGED_TIME%>=' + changed_time + '&hospitalId=' + hospitalId + '&deptId=' + deptId);
 --%>
 
 }

	/* function createSoftCopy()
	{

		document.appointmentUpload.method="post";
		submitForm('appointmentUpload','opd?method=viewUploadDocuments');
	}*/

	function viewPatientDocuments()
	{
		var num;
		//document.getElementById('flag1').value="viewDocuments";
		
		/* if(document.getElementById("hinNo")!=null)
			num=document.getElementById("hinNo").value;
		else */
			
			if(document.getElementById("adNo")!=null)
			num=document.getElementById("adNo").value;

				submitForm('appointmentUpload','opd?method=viewPatientDetails&flag1=viewDocuments&fieldValue='+num+'&'+csrfTokenName+'='+csrfTokenValue);


	}
	/*function clearValue()
	{
		if(document.getElementById('flag1')!=null)
			document.getElementById('flag1').value="";
		return true;
	} */

</script>
<%
	String date = "";
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String, Object> map = new HashMap<String, Object>();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<Patient>patientList=new ArrayList<Patient>();
	List<Inpatient>inpatientList=new ArrayList<Inpatient>();
	List<Visit>visitList=new ArrayList<Visit>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
 	date = (String)utilMap.get("currentDate");
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}

  	//Map map = new HashMap();
  	HashMap[] gridData =null;
	PagedArray pagedArray = null;
	Vector supplier_ids = null;
	String message = null;
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");
    }


	if(map.get("message") != null){
		 message = (String)map.get("message");
		%>

<h4><span><%=message %></span></h4>

<%

	}

	if(map.get("patientList")!=null)
	{
		patientList=(List<Patient>)map.get("patientList");
	}
	Inpatient inpatient=null;
	if(map.get("inpatientList")!=null)
	{
		inpatientList=(List<Inpatient>)map.get("inpatientList");
		
	}
	if(inpatientList.size()>0)
	{
		inpatient=inpatientList.get(0);
		session.setAttribute("inpatient",inpatient);
	}
	if(map.get("visitList")!=null)
	{
		visitList=(List<Visit>)map.get("visitList");
	}


	Visit visit=null;
	int hinId=0;
	String hinNo=null;
	if(inpatient!=null)
	{
		hinId=inpatient.getHin().getId();
		hinNo=inpatient.getHin().getHinNo();
	}
	/* List patientDataList = new ArrayList();

	if(map.get("patientDataList") != null){
		patientDataList=(List)map.get("patientDataList");
	}
	 visit=(Visit)patientDataList.get(0);
	 hinId=visit.getHin().getId();
	Patient patient = null;
	patient = (Patient) visit.getHin();


	Map<String,Object> mapForDS= new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String consultationDate = (String)utilMap.get("currentDate");
	String consultationTime = (String)utilMap.get("currentTime");


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
	String departmentName=visit.getDepartment().getDepartmentName(); */
	%>
	


<!--main content placeholder starts here-->


<form name="appointmentUpload" method="post"
	enctype="multipart/form-data">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="titleBg">
<h2> Upload Documents</h2>
</div>

<h4>Patient Details </h4>
<div class="clear"></div>
<div class="paddingTop40"></div>
<div class="clear"></div>
<%

if(inpatient!=null)
{
%>

<%@include file="PatientDetails.jsp" %>

<%} %>


<div class="clear"></div>

<!--Main div starts-->
<input	id="visitId" name="visitId" type="hidden" value="<%=visit!=null?visit.getId():""%>"	readonly="readonly" />
<input type="hidden" name="deptId" id="deptId"	size="5" value="<%=deptId%>" />
<input type="hidden" name="date"	size="5" id="<%=date %>" value="<%=date%>" />
<input type="hidden"	name="<%=CHANGED_BY%>" id="<%=CHANGED_BY %>" value="<%=userName%>" readonly="readonly" MAXLENGTH="8" tabindex=3 />
<input type="hidden" name="<%=CHANGED_DATE %>" id="<%=CHANGED_DATE %>"	value="<%=date%>" readonly="readonly" tabindex=3 />
<input type="hidden" name="<%=CHANGED_TIME %>" id="<%=CHANGED_TIME %>"	value="<%=time%>" readonly="readonly" tabindex=3 />
<input type="hidden" name="<%=INPATIENT_ID %>" id="<%=INPATIENT_ID %>"	value="<%=inpatient!=null?inpatient.getId():""%>" readonly="readonly" tabindex=3 /> 
<input type="hidden" name="<%=AD_NO %>" id="<%=AD_NO %>"	value="<%=inpatient!=null?inpatient.getAdNo():""%>" readonly="readonly" tabindex=3 /> 
<input type="hidden" name="<%=HIN_NO %>" id="<%=HIN_NO %>"	value="<%=hinNo%>" readonly="readonly" tabindex=3 /> 
<input type="hidden" name="<%=HIN_ID %>" id="<%=HIN_ID %>"	value="<%=hinId%>" readonly="readonly" tabindex=3 /> 
<input type="hidden" name="hin_no" id="hin_no"	value="<%=hinNo%>" readonly="readonly" tabindex=3 /> 
<%
if(inpatient!=null)
{
%>
<input type="hidden" name="inputField" id="inputField"	value="<%=inpatient!=null?inpatient.getAdNo():""%>" readonly="readonly" tabindex=3 /> 
<input type="hidden" name="flag1" id="flag1"	value="viewDocuments" readonly="readonly" tabindex=3 /> 
<input type="hidden" name="flag" id="flag"	value="view" readonly="readonly" tabindex=3 /> 

<%} 
else
{%>
<input type="hidden" name="flag" value="upload" id="flag">
<%
}
 %>

<div class="clear"></div>

<div class="clear"></div>
<%int inc=1; %>

<div class="tableHolderAuto">
<div class="clear"></div>
<div style="float: right;">
	<input type="button" class="buttonAdd" value="" align="right" onclick="javascript:addMoreDocument();">
	<input type="button" name="Reset" value="" class="buttonDel" align="right" onclick="javascript:removeDocument();">
		</div>
		<div class="clear"></div>
<div class="paddingTop25"></div>
<div class="clear"></div>
<table border="0" cellspacing="0" cellpadding="0" id="documentTable">
	<tr>
		<th></th>
		<th scope="col">Files:</th>
		<th scope="col">Description:</th>
	</tr>
	<tr>
		<td><input type="checkbox" name="upload<%=inc %>" id="upload<%=inc %>" /></td>
		<td><input type="file" name="<%=UPLOAD_FILENAME + inc%>"
			id="<%=UPLOAD_FILENAME + inc%>" class="Browse" onkeypress="javascript:return false;"
			onkeydown="javascript:return false;" onchange="checkFileName(this);" /></td>
		<td><input type="text" name="<%=DESCRIPTION + inc%>"
			id="<%=DESCRIPTION + inc%>" maxlength="40" /></td>
	</tr>

</table>

<input type="hidden" id="uploadCount" name="uploadCount" value="<%=inc %>" />
</div>


<div class="clear"></div>
<div class="division"></div>
<input type="button" class="button" name="impbutton" value="Attach" onClick="jsImport()" />
<input type="button" class="button" name="impbutton" value="View Documents" onClick="viewPatientDocuments()" />
<%-- <input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('appointmentUpload','opd?method=showOPDMainJsp&visitId=<%=visit.getId()%>&deptId=<%=visit.getDepartment().getId()%>');"	align="right" /> --%>
<div class="clear"></div>
<div class="division"></div>
<script type="text/javascript">
function checkFileName(obj){
	var hdb = document.getElementById('uploadCount');
	for(var i=1;i<=hdb.value;i++){
		if(document.getElementById('<%=UPLOAD_FILENAME%>'+i)!=null && 
				obj.id != document.getElementById('<%=UPLOAD_FILENAME%>'+i).id){
			if(obj.value == document.getElementById('<%=UPLOAD_FILENAME%>'+i).value){
				alert("File Already selected for upload.");
				obj.value = "";
				return false;
			}
		}
	}

}
</script> <!--
<input type="file" name="" id="attachment" class="Browse" onkeypress="javascript:return false;" onkeydown="javascript:return false;"
onchange="document.getElementById('moreUploadsLink').style.display = 'block';"/>
<div id="moreUploads"><br/></div>
<div id="moreUploadsLink" style="display:none;"><a href="javascript:addFileInput();">Attach another File</a></div>
<br/>
<input type="button" class="cmnButton" name="impbutton" value="Attach" onClick="jsImport()"/>
-->
<div class="paddingTop25"></div>
<div class="clear"></div>
<!--Main div starts-->
<script type="text/javascript">
/* var upload_number = 2;
function addFileInput() {
 	var d = document.createElement("div");
 	var file = document.createElement("input");
 	file.setAttribute("type", "file");
 	file.setAttribute("id", "attachment"+upload_number);
 	file.setAttribute("name", "upload_filename");
 	d.appendChild(file);
 	document.getElementById("moreUploads").appendChild(d);
 	upload_number++;
} */

function addMoreDocument()
{

	var tbl = document.getElementById('documentTable');
	var lastRow = tbl.rows.length;
	// if there's no header row in the table, then iteration = lastRow + 1
	var iteration = lastRow;
	var row = tbl.insertRow(lastRow);
	var hdb = document.getElementById('uploadCount');
	iteration = parseInt(hdb.value)+1;
	hdb.value=iteration;

	var cellRight1 = row.insertCell(0);
	var e1 = document.createElement('input');
	e1.type = 'checkbox';
	e1.name='upload'+iteration;
	e1.id='upload'+iteration;
	e1.className='radioCheck';
	cellRight1.appendChild(e1);
	
	var cellRight1 = row.insertCell(1);
	var file = document.createElement("input");
 	file.setAttribute("type", "file");
 	file.setAttribute("id", "<%=UPLOAD_FILENAME%>"+iteration);
 	file.setAttribute("name", "<%=UPLOAD_FILENAME%>"+iteration);
 	file.onchange=function(){checkFileName(this);};
  	cellRight1.appendChild(file);

	var cellRight1 = row.insertCell(2);
	var e1 = document.createElement('input');
	e1.type = 'text';
	e1.name='<%=DESCRIPTION%>'+iteration;
	e1.id='<%=DESCRIPTION%>'+iteration;
	e1.maxLength='40';
	e1.size='20';
	cellRight1.appendChild(e1);	
}

function removeDocument()
{

	  var tbl = document.getElementById('documentTable');
	  var lastRow = tbl.rows.length;
	  var hdb = document.getElementById('uploadCount');
	  var iteration = parseInt(hdb.value);
	  var totalSelected=0;
	  for(var i=1;i<=iteration;i++)
		  {
		  if(document.getElementById("upload"+i)!=null && (typeof  document.getElementById("upload"+i).checked)!='undefined' && document.getElementById("upload"+i).checked )
			  {
			  totalSelected=totalSelected+1;
			  }
		  }
	      if(totalSelected==0)
		  {
		  alert('Please select atleast 1 row to delete');
		  }
	      else  if(lastRow==2 || lastRow==(totalSelected+1))
		  {
	    	  alert('You can not delete all Row.');
	      }
	      else if (lastRow > 2){
	    	  for(var i=1;i<=iteration;i++)
	    	  {
	    		  if(document.getElementById("upload"+i)!=null && (typeof  document.getElementById("upload"+i).checked)!='undefined' && document.getElementById("upload"+i).checked )
	    		  {
	    		  var deleteRow= document.getElementById("upload"+i).parentNode.parentNode;
	    		  document.getElementById("upload"+i).parentNode.parentNode.parentNode.removeChild(deleteRow);
	    		  }
	    	  }
	  }
	      }

</script>
</form>

 