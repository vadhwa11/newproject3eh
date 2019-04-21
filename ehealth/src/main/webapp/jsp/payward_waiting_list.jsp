
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


			
	List<BlPaywardBooking> itemList = new ArrayList<BlPaywardBooking>();
	int totalPatient=0;
	if(map.get("itemList") != null)
	{
		itemList=(List<BlPaywardBooking>)map.get("itemList");
	}System.out.println("itemList  >>>> "+itemList.size());
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
<span><%=map.get("message") %></span>
<%} %>
<h4>Payward Waiting list</h4>
<div class="Block">
<form name="opWaitingList" action="" method="post">

 </select>
<div class="clear"></div>
<div class="paddingTop25"></div>
<label class="auto">Payward</label>
<input type="text" name="tokenNo" id="tokenNo" validate="tokenNo,num,no" />
<!-- <label class="auto">Room Category </label>
<input type="text" name="roomCat" id="patientName" validate="patientName,string,no"/> -->
<label class="auto">UHID</label>
<input type="text" name="uhid" id="uhid"/>
<!-- <label class="auto">Ward No</label>
<input type="text" name="wardNo" id="wardNoId"/> -->

<input type="hidden" name="searchFlag" id="searchFlag" value="1"/>
<input type="button" class="buttonAuto"  id="search" name="search" value="Search" onClick="submitForm('opWaitingList','ipd?method=getPaywardWaitingList');" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
	
</div>

<div class="floatleft">
 <!--<div style="display:none"> -->
<jsp:include page="searchResultBlockForIPD.jsp" />
<!-- </div>
 -->
<form name="payward_waiting_list" method="post" action="">



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
	data_header[5][0] = "Unit"
	data_header[5][1] = "data";
	data_header[5][2] = "5%";

	
	data_header[6] = new Array;
	data_header[6][0] = "Booking Date"
	data_header[6][1] = "data";
	data_header[6][2] = "1%";
	
	data_header[7] = new Array;
	data_header[7][0] = "Waiting List"
	data_header[7][1] = "data";
	data_header[7][2] = "6%";
	
	data_header[8] = new Array;
	data_header[8][0] = "Current Status"
	data_header[8][1] = "hide";
	data_header[8][2] = "6%";
	
	data_header[9] = new Array;
	data_header[9][0] = "Final Advanced Paid"
	data_header[9][1] = "data";
	data_header[9][2] = "6%";
	
	data_header[10] = new Array;
	data_header[10][0] = "Due Date"
	data_header[10][1] = "hide";
	data_header[10][2] = "6%";
	
	data_header[11] = new Array;
	data_header[11][0] = "Allotment"
	data_header[11][1] = "data";
	data_header[11][2] = "6%";
	
	data_arr = new Array();

	<%
	int  i=0;
	String st="";

	Iterator iterator=itemList.iterator();

	while(iterator.hasNext())
	{
		BlPaywardBooking booking=(BlPaywardBooking)iterator.next();
		Patient patient=booking.getHin();
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
		 data_arr[<%= i%>][4] ="<%=booking.getInpatient()!=null?booking.getInpatient().getAdNo():""%>"
		data_arr[<%= i%>][5] = "<%=booking.getPayward().getDepartmentName()%> " 
		data_arr[<%= i%>][6]=" "
		data_arr[<%= i%>][7] = "<%=HMSUtil.convertDateToStringTypeDateOnly(booking.getBookingDate())%>"
		data_arr[<%= i%>][8] = "<%=booking.getCurrentWaitingList()%>"
		data_arr[<%= i%>][9] = "Waiting"
		data_arr[<%= i%>][10] = ""
			data_arr[<%= i%>][11] =""
				data_arr[<%= i%>][12] ="<input type='checkbox' id='bookingId' name='bookingId' value='<%=booking.getId()%>' />"
					

	<%	
		i++;
		}
		%>

	formName = "payward_waiting_list"

	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	
	makeGridForPatient(start,end);

	intializeHover('searchresulttable', 'TR', ' tableover');
	</script>
	<%if(itemList.size()>0) {%>
<input type="button" class="buttonAuto"  id="search" name="search" value="submit" onClick="validate();" />
<%} %>
<div class="clear"></div>
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>

<script type="text/javascript" >
function validate(){
var check=getCheckedBoxes('bookingId');
if(check==null || check.length==0){
alert('Please select atleast one patient!');
return;
}
if('<%=availablebed%>' < check.length){
	alert('Total selected patient is greater than availabel bed!.');
	return ;
}
submitForm('payward_waiting_list','ipd?method=submitPayward');
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