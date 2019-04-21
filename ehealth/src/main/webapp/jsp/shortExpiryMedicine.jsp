<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<SCRIPT language=javascript src="/hms/jsp/js/common.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/hms.js"	type=text/javascript></SCRIPT>
<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"	type=text/javascript></SCRIPT>

<SCRIPT>
		<%
	
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
		</SCRIPT>
<%
		Map<String,Object> map = new HashMap<String,Object>();
		List<Object[]> visitListJsp = new ArrayList<Object[]>();
		List<MasDepartment> departmentListJsp = new ArrayList<MasDepartment>();
		List<MasEmployee> employeeListJsp = new ArrayList<MasEmployee>();
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		if(map.get("visitList") != null){
			visitListJsp= (List<Object[]>)map.get("visitList");
		}
		if(map.get("departmentList") != null){
			departmentListJsp= (List<MasDepartment>)map.get("departmentList");
		}
		
		if(map.get("employeeList") != null){
			employeeListJsp= (List<MasEmployee>)map.get("employeeList");
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		String message = "";
		if (map.get("visitList") != null) {
			message = (String) map.get("message");
		}
	%>

<script type="text/javascript">
function check(){
var SDate = document.report.<%= FROM_DATE%>.value;
var EDate = document.report.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
}
</script>
<%
	if(!message.equals("")){
%>
<h4><span><%=message %></span></h4>
<%} %> 
<form name="replaceMedicinEquipment" method="post" action="">
<div class="titleBg">
<h2>Short Expiry Medicines</h2> 
<!-- <h2> Dispensing Pending List</h2> -->
</div>
<div class="clear"></div>
<div class="Block" >
<label >Date</label> 
<input type="text" name="<%= FROM_DATE%>" value="<%=date %>" class="date" MAXLENGTH="30" readonly="readonly" validate="fromDate,date,yes"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=FROM_DATE%>',replaceMedicinEquipment.<%=FROM_DATE%>,true);" />

<div class="clear" ></div>  
</div> 
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="search" value="Search" class="button" onClick="submitForm('replaceMedicinEquipment','stores?method=shortExpiryMedicineReport');"	accesskey="g" tabindex=1 />
<input type="hidden" size="2" value="fgfg" name="noOfRecords"
	id="noOfRecords" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form> 
        
 
