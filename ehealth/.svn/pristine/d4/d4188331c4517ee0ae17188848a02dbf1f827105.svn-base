
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.BlDispensingDetails"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>

<script type="text/javascript" language="javascript">
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
<script type="text/javascript" language="javascript">
function openPopupWindow()
{
 var url="/hms/hms/discharge?method=showPatientSearchJsp";
 newwindow=window.open(url,'name',"height=600,width=800,status=1,scrollbars=1,resizable=1");
}

function jsSetPatientData(hinNo)
{
document.clinicalSheetReportForm.<%=HIN_NO%>.value=hinNo;
document.clinicalSheetReportForm.<%=HIN_NO%>.focus();
}
</script>

<%
Map map = new  HashMap();
Map<String, Object> utilMap = new HashMap<String, Object>();
Set patientSet = null;
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
String status = "";
String admissionNumber = "";
String serviceNo = "";
String hinNoForPrint ="";
String adNoForprint ="" ;
List<BlDispensingDetails>blDispensingDetailsList=new ArrayList<BlDispensingDetails>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}

if(map.get("itemList")!=null){
blDispensingDetailsList = (List<BlDispensingDetails>)map.get("itemList");

}
%>

<div class="clear"></div>
<h2>IP Patient Issue Search</h2>
<div class="clear"></div>
<form name="clinicalSheetReportForm" action="" method="post">
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
</div>
<div class="cmntableWithHeight">
<table  border="0" align="center" cellpadding="0" cellspacing="0" class="small"	>
		<tr>
			<th scope="col">Issue Date</th>
			<th scope="col">Reg. No.</th>
			<th scope="col">Patient Name</th>
				<!--<th scope="col">Brand Name</th>
			<th scope="col">Manufacturer</th>-->
			<th scope="col" >Item Name</th>
			<th scope="col" style="width: 100px;">Issue Quantity</th>
		</tr>
		<%for(BlDispensingDetails bdd : blDispensingDetailsList){ %>
		<tr>
		<td><%=bdd.getDispensingHeader().getBillDate() %></td>
		<td><%=bdd.getDispensingHeader().getHinNo() %></td>
		<td><%=bdd.getDispensingHeader().getPatientName() %></td>
		<td><%=bdd.getItem().getNomenclature() %></td>
		<td><%=bdd.getQty() %></td>

		<%} %>
		</tr>
		</table>
</div> 
<div class="clear paddingTop40"></div>
<div class="clear"></div>
<div class="division"></div>
<input	type="button" name="back" class="button" id="back" value="back" onClick="submitForm('clinicalSheetReportForm','ipd?method=showClinicalSheetReportScreen')"; />
<div class="clear"></div>
<div class="division"></div>
<div class="clear paddingTop40"></div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

