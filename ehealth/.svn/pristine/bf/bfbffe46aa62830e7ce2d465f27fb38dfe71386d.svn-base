<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.Calendar"%>


<script type="text/javascript" language="javascript"	src="/hms/jsp/js/hms.js"></script>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<SCRIPT SRC="/hms/jsp/js/ssm.js" language="JavaScript1.2"></SCRIPT>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script>
<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String curDate=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(curDate.length()<2){
			curDate="0"+curDate;
		}

	%>
		serverdate = '<%=curDate+"/"+month+"/"+year%>'
</script>
<%
	Map<String, Object> map = new HashMap<String, Object>();

	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	
	List<Visit> VisitList = new ArrayList<Visit>();
		
	if(map.get("VisitList")!=null){
		
		VisitList = (List<Visit>)map.get("VisitList");
		
	}
	
	
	List<MasHospital> hospitalNameList = new ArrayList<MasHospital>();
	
	
	
	
	String message = "";
	if (map.get("message") != null) {
		message = (String) map.get("message");
	}
	
	
	if(map.get("hospitalNameList")!=null){
		 hospitalNameList=(List<MasHospital>)map.get("hospitalNameList");
		}
%>

<!--Block One Starts-->
<form name="billDispensingSearch" action="" method="post">
<%
	if(!message.equals("")){
		%>

<h4><span><%=message %></span></h4>
<div class="clear"></div>

<%	}
%>
<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
%>
<%
	if(map.get("inpatientList") != null){
%> <script type="text/javascript">
	alert("Patient is admitted.");
</script> <%		
	}
%>
<div class="clear"></div>
<div class="titleBg">
<h2>Bill Dispensing</h2>
</div>
<div class="clear"></div>

<div class="Block">

<label>UHID</label>
<input type="text" name="uhid" value=""  class="small" maxlength="50" id="hinNo"/>
<label>Patient Name</label>
<input type="text" name="patientName" value="" class="small" maxlength="50" />
<label>Mobile</label>
<input type="text" name="mobile" value="" class="small" maxlength="50" id="mobile"/>
<div class="clear"></div>


<input type="button" name="search" value="Search" class="button" onclick="submitForm('billDispensingSearch','/hms/hms/opBilling?method=showBillDispensingJsp')"/>


<%
	if(VisitList.size() > 0){
%>
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	id="paymentDetails">

	<tr >
		<th scope="col">UHID</th>
		<th scope="col">Patient Name</th>
		<th scope="col">Referred By</th>
		<th scope="col">Hospital Name</th>
	</tr>
	<%
	
		for(Visit obj : VisitList){
	%><%-- &visitId=<%=obj.getId() %>&phinNumer=<%=obj.getHin().getPatientInvestigationHeaders()%> --%>
	<tr style="cursor: pointer;"  onclick="submitForm('billDispensingSearch','/hms/hms/opBilling?method=getPatientDetailsForBillDispensing&uhid=<%=obj.getHin().getHinNo()%>')">
	<td><%=obj.getHin().getHinNo()%></td>
	<td><%=obj.getHin().getPFirstName() %></td>
	<td><%=obj.getDoctor().getEmployeeName() %></td>
	<td><%=obj.getHin().getHospital().getHospitalName() %></td>
	</tr>
	
	<%} %>

</table>
<%}else{ %>
<h4>No Record Found</h4>
<%} %>


<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="paddingTop15"></div>

<div class="clear"></div>
<div id="error"></div>
<script type="text/javascript">
document.getElementById('hinNo').focus();
function chkDate(){
	var err = "";
	var currentDate=new Date(serverdate.substring(6),(serverdate.substring(3,5) - 1) ,serverdate.substring(0,2));
	obj1 = document.discountMaster.effectiveDateFrom.value;
	obj2 = document.discountMaster.effectiveDateTo.value;
	fromDate=new Date(obj1.substring(6),(obj1.substring(3,5) - 1) ,obj1.substring(0,2));
	toDate=new Date(obj2.substring(6),(obj2.substring(3,5) - 1) ,obj2.substring(0,2));
/*	if(obj1 != ""){
		if(fromDate>currentDate)
			err += "From Date should be less than or equal to current date.\n"
	}*/
	if(obj2 != ""){
		if(toDate<currentDate)
			err += "To Date should be greater than or equal to current date.\n"

	}
	if(obj1!="" && obj2 !=""){

		if(fromDate>toDate)
			err += "From date should be less than or equal to To Date.\n"
	}
	if(err!="")
		alert(err)
	else
		return true;
}
</script>

 

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>

