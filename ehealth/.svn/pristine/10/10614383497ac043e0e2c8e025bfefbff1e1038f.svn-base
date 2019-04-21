
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.BlPaywardBooking"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>


<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">


<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	
	</script>
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

	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");


			
	 List<Inpatient> inpatientList=new ArrayList<Inpatient>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	if(map.get("inpatientList") != null)
	{
		inpatientList=(List<Inpatient>)map.get("inpatientList");
	}
	if(map.get("departmentList") != null)
	{
		departmentList=(List<MasDepartment>)map.get("departmentList");
	}
	int availablebed=0;
	if(map.get("availablebed")!=null)
	{
		availablebed=(Integer)map.get("availablebed");
	}
	%>

<div class="titleBg">
<h2>General Medicine</h2>
</div>
<div class="clear"></div>
<%if(map.get("message")!=null){ %>
<h4><span><%=map.get("message") %></span></h4>
<%} %>
<h4>Patient PostPaid Status</h4>
<div class="Block">
<form name="postpaidSearch" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
<div class="clear"></div>
<div class="paddingTop25"></div>
<label class="auto">Ward<span>*</span></label>
<select name="<%=RequestConstants.WARD%>" id="<%=RequestConstants.WARD%>" validate="ward,int,yes">
<option value="">Select</option>
<%for(MasDepartment department:departmentList){ %>
<option value="<%=department.getId()%>"><%=department.getDepartmentName()%></option>
<%} %>
</select>
<div class="clear"></div>	
<input type="button" class="buttonAuto"  id="search" name="search" value="Search" onClick="submitForm('postpaidSearch','/hms/hms/ipd?method=showPostPaidSearchJsp')" />

 


 </form>
</div>

<div class="floatleft">
 <!--<div style="display:none"> -->
<jsp:include page="searchResultBlockForIPD.jsp" />
<!-- </div>
 -->
<form name="inpatient_post_paid" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 



<div class="clear"></div>	
<div id="test" class="">
<div id="searchresults" tabindex=2>
<div class="cmnTable"  id="searchtable" class="small" tabindex=2>

</div>
</div>
<div id="edited"></div>
<div id="statusMessage"></div>
</div>
<div id="edited"></div>
<div id="statusMessage"></div>

<script type="text/javascript" language="javascript">

	data_header = new Array();

	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "5%";

	data_header[1] = new Array;
	data_header[1][0] = "UHID"
	data_header[1][1] = "data";
	data_header[1][2] = "8%";

	data_header[2] = new Array;
	data_header[2][0] = "Patient Name"
	data_header[2][1] = "data";
	data_header[2][2] = "10%";

	data_header[3] = new Array;
	data_header[3][0] = "IP No."
	data_header[3][1] = "data";
	data_header[3][2] = "5%";

	data_header[4] = new Array;
	data_header[4][0] = "Department"
	data_header[4][1] = "data";
	data_header[4][2] = "6%";
	
	data_header[5] = new Array;
	data_header[5][0] = "Age"
	data_header[5][1] = "data";
	data_header[5][2] = "6%";
	
	data_header[6] = new Array;
	data_header[6][0] = "Gender"
	data_header[6][1] = "data";
	data_header[6][2] = "6%";

	data_header[7] = new Array;
	data_header[7][0] = "Post Paid"
	data_header[7][1] = "data";
	data_header[7][2] = "6%";
	
	data_arr = new Array();

	<%
	int  i=0;
	String st="";

	Iterator iterator=inpatientList.iterator();

	while(iterator.hasNext())
	{
		Inpatient inpatient=(Inpatient)iterator.next();
		Patient patient=inpatient.getHin();
		String uhid=patient.getHinNo();
		String patientName="";
		patientName=patient.getPFirstName();
		
		/* if(patient.getPMiddleName()!= null){
		patientName=patientName+" "+patient.getPMiddleName();
		}
		if(patient.getPLastName()!= null)
		{
		patientName=patientName+" "+patient.getPLastName();
		} */
		/* Integer ipNo=booking.getInpatient().getAdNo(); */
		%>
		data_arr[<%= i%>] = new Array();
		data_arr[<%= i%>][0] =""
		data_arr[<%= i%>][1] =""
		data_arr[<%= i%>][2] ="<%=uhid%>"
		data_arr[<%= i%>][3] ="<%=patientName%>"
		 data_arr[<%= i%>][4] ="<%=inpatient.getAdNo()%>"
		data_arr[<%= i%>][5] = "<%=inpatient.getDepartment().getDepartmentName()%> " 
		data_arr[<%= i%>][6]="<%=patient.getAge()!=null?patient.getAge():""%>"
		data_arr[<%= i%>][7] = "<%=patient.getSex()!=null?patient.getSex().getAdministrativeSexName():""%>"
		data_arr[<%= i%>][8] ="<input type='checkbox' id='inpatientId' name='inpatientId' value='<%=inpatient.getId()%>' />"
					

	<%	
		i++;
		}
		%>

	formName = "inpatient_post_paid"

	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	
	makeGridForPatient(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
	</script>
	<%if(inpatientList.size()>0) {%>
<input type="button" class="buttonAuto"  id="search" name="search" value="submit" onClick="validate();" />
<%} %>
<div class="clear"></div>
</form>

<script type="text/javascript" >
function validate(){
submitForm('inpatient_post_paid','ipd?method=submitPostPaid');
}

function getCheckedBoxes(chkboxName) {
  var checkboxes = document.getElementsByName(chkboxName);
  var checkboxesChecked = [];
  // loop over them all
  for (var i=0; i<checkboxes.length; i++) {
     // And stick the checked ones onto an array...
     if (checkboxes[i].checked) {
        checkboxesChecked.push(checkboxes[i]);
     }
  }
  // Return the array if it is non-empty, or null
  return checkboxesChecked.length > 0 ? checkboxesChecked : null;
}


</script>