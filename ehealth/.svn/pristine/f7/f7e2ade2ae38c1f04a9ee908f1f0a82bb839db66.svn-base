<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
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

		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");
		String time = (String)utilMap.get("currentTime");

	 List patientDetailList = new ArrayList();
	 List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
	 List employeeList = new ArrayList();

	if(map.get("patientDetailList") != null){

		patientDetailList=(List)map.get("patientDetailList");

	}
	if(map.get("departmentList") != null){

		departmentList=(List)map.get("departmentList");

		}
	if(map.get("employeeList") != null){
		employeeList=(List)map.get("employeeList");
		}



	int hospitalId=0;
	if (session.getAttribute("hospitalId") != null) {
		hospitalId = (Integer) session.getAttribute("hospitalId");
	}
	int orderNo=0;
	if(map.get("orderNo") != null){
		orderNo=(Integer)map.get("orderNo");
		}


	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	Visit visit=(Visit)patientDetailList.get(0);

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
	int hinId=visit.getHin().getId();
	int prescribedDepartmentId=visit.getDepartment().getId();
%>
<BODY onload="doSomething();">
<form name="opdSurgery" action="doSomething();" method="post" >
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<%if(visit.getDepartment()!= null){ %>
<div class="titleBg">
<h2>Surgery Requisition For OPD-Patient</h2>
</div>
<div class="clear"></div>
<%} %> <!--Block One Starts-->


<h4>Patient Details</h4>
<div class="clear"></div>
<div class="Block">

<label><%=prop.getProperty("com.jkt.hms.registration_no") %></label>
<%if(visit.getHin().getHinNo()!= null){ %>
<label class="value"><%=visit.getHin().getHinNo() %></label>
<%}else{ %>
<label class="value">-</label>
<%} %>

<label>Patient Name </label> <%if(patientName!= null){ %>
<label class="value"><%=patientName %> </label> <%}else{ %>
<label	class="value">- </label> <%} %>

<label>Age</label> <%if(visit.getHin().getAge()!= null){ %>
<label class="value"><%=visit.getHin().getAge() %></label> <%}else{ %>
<label class="value">-</label> <%} %>

<div class="clear"></div>

<label>Visit Date </label> <%if(visitDateInString != null){ %>
<label class="value"><%=visitDateInString %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<label><%=prop.getProperty("com.jkt.hms.opd_no") %></label> <%if(visit.getVisitNo()!= null){ %>
<label class="value"><%=visit.getVisitNo() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<label>Token No. </label> <%if(visit.getTokenNo()!= null){ %>
<label class="value"><%=visit.getTokenNo() %></label> <%}else{ %>
<label>-</label>
<%} %>

<div class="clear"></div>

<label>Prev. Diag </label> <%if(visit.getDiagnosis()!= null){ %>
<label class="valueAuto"><%=visit.getDiagnosis().getDiagnosisConclusionName() %></label>
<%}else{ %>
<label class="value">-</label> <%} %>

<label>Order No.</label>
<label	class="value"><%=orderNo %></label>
<input type="hidden" name="orderNo"	value="<%=orderNo %>" />
<label>Order Date.</label>
<label	class="value"><%=date %></label>
<input type="hidden" name="orderDate"	value="<%=date %>" />
<label>Order Time.</label>
<div id="ajaxResponse1">
<label	class="value"><%=time %></label>
<input type="hidden" name="orderTime" value="<%=time %>" />
</div>

<div class="clear"></div>
</div>
<!--Block one Ends-->
<div class="clear"></div>
<div class="paddingTop15"></div>

<label class="small"><span>*</span>Surgical Department</label> <select
	name="departmentId" id="departmentid"
	onchange="submitProtoAjaxWithDivName('opdSurgery','/hms/hms/opd?method=showAjaxResponseForSurgeryRequisitionJsp','ajaxResponse');">
	<option value="0">Select</option>
	<%
	 int deptId=0;
	   for(int i=0;i<departmentList.size();i++)
	   {
		   MasDepartment masDepartment= new MasDepartment();
   		   masDepartment=(MasDepartment) departmentList.get(i);
   		  deptId =masDepartment.getId();
	%>
	<option value="<%=deptId%>"><%=masDepartment.getDepartmentName() %></option>
	<%
       }
	%>
</select> <label>Prescribed By</label> <label class="value"><%=userName %></label>
<div id="ajaxResponse"><label class="small">Referred To</label> <select
	name="empId" id="empId ">
	<option value="0">Select</option>
</select></div>
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
<input type="hidden" name="visitId" value="<%=visit.getId() %>" /> <input
	type="hidden" name="hinId" value="<%=hinId %>" /> <input type="hidden"
	name="deptId" value="<%=deptId %>" /> <input type="hidden" name="date"
	value="<%=date %>" /> <input type="hidden" name="time"
	value="<%=time %>" /> <input type="hidden"
	name="prescribedDepartmentId" value="<%=prescribedDepartmentId %>" />
<input type="hidden" name="userName" value="<%=userName %>" /></form>
</BODY>
<script type="text/javascript">

function validateSurgeryForAutoComplete1( strValue,inc ) {

		var index1 = strValue.lastIndexOf("[");
    var index2 = strValue.lastIndexOf("]");
    index1++;
    var id = strValue.substring(index1,index2);
    //alert("id----"+id)

    if(id =="")
    {
    		document.getElementById('chargeCodeName'+inc).value="";
				document.getElementById('chargeCode'+inc).value="";
				return ;
		}

    for(i=1;i<inc;i++){
			if(inc != 1){

			if(document.getElementById('chargeCodeName'+i).value==strValue)
			{
				alert("Charge Code Name already selected...!")
				document.getElementById('chargeCodeName'+inc).value=""
				var e=eval(document.getElementById('chargeCodeName'+inc));
				e.focus();
				return false;
			} }  }
		return true;
}

function doSomething ( )
{
  // (do something here)

 submitProtoAjaxWithDivName('opdSurgery','/hms/hms/opd?method=showUpdateTime','ajaxResponse1');
  setTimeout ( "doSomething()", 100000 );
}


	function removeRow()
	{
	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2) tbl.deleteRow(lastRow - 1);
	}

 	function addRowForSurgery(departmentId){

	  var tbl = document.getElementById('investigationGrid');
	  var lastRow = tbl.rows.length;

	  // if there's no header row in the table, then iteration = lastRow + 1
	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hiddenValue');
	  hdb.value=iteration
	  // alert("iteration row--"+iteration)


	  var cellRightSel = row.insertCell(0);
	  var sel = document.createElement('input');
	  sel.value=hdb.value;
	  sel.size='2'
	  cellRightSel.appendChild(sel);


	  var cellRight1 = row.insertCell(1);
	  var e0 = document.createElement('input');
	  e0.type = 'text';
	 // e0.innerHTML = iteration+':'
	  e0.onblur=function(){

	  						if(validateSurgeryForAutoComplete1(this.value,iteration)){submitProtoAjaxWithDivName('opdSurgery','/hms/hms/opd?method=fillChargeCode&rowVal='+iteration,'chargeCodeVal'+iteration);}

	  					  };
	  e0.name = 'chargeCodeName' + iteration;
	  e0.id = 'chargeCodeName' + iteration;
	  //alert("name--"+e0.name)
	  e0.size = '43'
	  cellRight1.appendChild(e0);
	new Ajax.Autocompleter('chargeCodeName'+iteration,'ac2update2','ot?method=getInvestigationListForRequestionForIP&deptId='+departmentId,{parameters:'requiredField=chargeCodeName'+iteration});




	  var cellRightSel = row.insertCell(2);
	  cellRightSel.id='chargeCodeVal'+iteration;
	  var sel = document.createElement('input');
	  sel.type = 'text';
	  sel.name='chargeCode'+iteration;
	  sel.id='chargeCode'+iteration;
	  sel.size = '10'
	  cellRightSel.appendChild(sel);

	  var cellRightSe2 = row.insertCell(3);
	  cellRightSe2.id='rateVal'+iteration;
	  var se2 = document.createElement('input');
	  se2.type = 'text';
	  se2.name='rate'+iteration;
	  se2.id='rate'+iteration;
	  se2.readOnly=true; 
	  se2.size = '8';
	  cellRightSe2.appendChild(se2);

	}

</script>

<script type="text/javascript">
function validateSurgery()
{
		  var tbl = document.getElementById('investigationGrid');
		  var lastRow = tbl.rows.length;
		  for(var i=1;i<lastRow;i++){
		  var chargeCodeName=document.getElementById("chargeCodeName"+i).value;
		  if(chargeCodeName ==""){
 	  		  alert("Please Enter the Surgery Name "+i)
 	  		  document.getElementById("chargeCodeName"+i).focus();
		  	  return false;
  		   }
		  }
	    return true;
	}
</script>


