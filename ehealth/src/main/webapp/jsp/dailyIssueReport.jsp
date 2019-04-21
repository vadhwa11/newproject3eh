<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@page import="jkt.hms.masters.business.StoreIssueT"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.StoreOpPatientIssueT"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<%@page import="jkt.hms.util.RequestConstants"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

<script	type="text/javascript" language="javascript">

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
<%
Map<String, Object> map = new HashMap<String, Object>();
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
date = (String) utilMap.get("currentDate");
String userName = "";
String message = "";
List<StoreOpPatientIssueT> storeOpPatientIssueTList=new ArrayList<StoreOpPatientIssueT>();
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
	}
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}
Map<String, Object> dailyIssueItem = new HashMap<String, Object>();
if (map.get("dailyIssueItem") != null) {
	
	dailyIssueItem = (Map<String, Object>)map.get("dailyIssueItem");
}
List objectList = new ArrayList();
	if (dailyIssueItem.get("objectList") != null) {
		objectList = (List)dailyIssueItem.get("objectList");

	}
	String reportType="";
	if(map.get("reportType") != null){
		reportType= (String) map.get("reportType");
	}
	List<MasDepartment> deptList = new ArrayList<MasDepartment>();
	if (map.get("deptList") != null) {
		deptList = (List<MasDepartment>)map.get("deptList");

	}
	if (dailyIssueItem.get("deptList") != null) {
		deptList = (List<MasDepartment>)dailyIssueItem.get("deptList");

	}
	 int mobileNo=0;
	 String uhid="";
	 String pname="";
	 String fromDate="";
	 String fromTime="";
	 String toTime="";
		if (dailyIssueItem.get("fromTime")!=null) {
			fromTime = (String)dailyIssueItem.get("fromTime");
		      }
		if (dailyIssueItem.get("fromDate") != null) {
		
			fromDate=(String)dailyIssueItem.get("fromDate");
				
		      }
	
		if (dailyIssueItem.get("toTime") != null) {
			toTime = (String)dailyIssueItem.get("toTime");
		      }
	
		if (dailyIssueItem.get("pname") != null) {
			pname = (String)dailyIssueItem.get("pname");
		      }
	
		if (dailyIssueItem.get("uhid") != null) {
			uhid = (String)dailyIssueItem.get("uhid");
		      }
		if (dailyIssueItem.get("mobileNo") != null) {
			mobileNo = (Integer)dailyIssueItem.get("mobileNo");
		      }
	
	if (dailyIssueItem.get("msg") != null) {
	             message = (String)dailyIssueItem.get("msg");
	      }
	
	String toDepart="";
	if(map.get("depart") != null){
		toDepart= (String) map.get("depart");
	}
	List<StoreIssueM> issueMList=new ArrayList<StoreIssueM>();
	if(dailyIssueItem.get("issueMList") != null){
		issueMList= (List<StoreIssueM>) dailyIssueItem.get("issueMList");
	}
	if(!message.equalsIgnoreCase("")){
	%>
	<h4><%=message %></h4>
	<%} %>

<!-- //Note: Revert the changes for story NO :37
<form name="dailyIssueSummery" id="dailyIssueSummery" target="_self" action="" method="post"> -->
<form name="dailyIssueSummery" id="dailyIssueSummery"  action="" method="post">
<div class="clear"></div>
<div class="titleBg">
<h2>Daily Prescription</h2>
</div>
<!--  <form name="issue" method="post">-->
<div class="clear"></div>
<div class="Block">
  
<div class="clear"></div>   
<label>Date <span>*</span>   </label> 

<%if(!fromDate.equals("")){ %>
<input type="text" class="date" name="<%=FROM_DATE%>" value="<%=fromDate %>"  MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.dailyIssueSummery.<%=FROM_DATE%>,event)" />
<%}else{ %>
<input type="text" class="date" name="<%=FROM_DATE%>" value=""  MAXLENGTH="30" validate="Pick a from date,date,yes" readonly="readonly" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender" tabindex="1" onClick="setdate('<%=currentDate%>',document.dailyIssueSummery.<%=FROM_DATE%>,event)" />

<%} %>
<label>From Time <span>*</span>   </label>
<%if(!fromTime.equals("")){ %>
<input type="text"  value="<%=fromTime %>"  id="fromTime" name="fromTime" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<%}else{ %>
<input type="text"   id="fromTime" name="fromTime" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<%} %>
<label>To Time <span>*</span>   </label>
<%if(!toTime.equals("")){ %>
<input type="text"   value="<%=toTime %>"id="toTime" name="toTime" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<%}else{ %>
<input type="text"   id="toTime" name="toTime" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);" maxlength="5"/>
<%} %>
<div class="clear"></div>

<label>UHID</label>
<%if(!uhid.equals("")){ %>
<input type="text" name="uhid"  value="<%=uhid%>"/>
<%}else{ %>
<input type="text" name="uhid"  value=""/>
<%} %>
<label>Name</label>
<%if(!pname.equals("")){ %>
<input type="text"  name="pname" value="<%=pname%>"/>
<%}else{ %>
<input type="text"  name="pname" value=""/>
<%} %>
<label>Mobile No.</label>
<%if(mobileNo!=0){ %> 
<input type="text" value="<%=mobileNo%>" name="mobileNo" validate="Mobile No.,phone,no" 	MAXLENGTH="10" tabindex="1"  />
<%}else{ %>
<input type="text" name="mobileNo" validate="Mobile No.,phone,no" 	MAXLENGTH="10" tabindex="1"  />
<%} %>
<div class="division"></div>
</div>
<div class="clear"></div>
<input type="button" class="button" value="Generate Report" onclick="methodForReport1();" />
<input type="button" class="button" value="Print" onclick="methodForReport();" />
<!-- //Note: Revert the changes for story NO :37
<input type="button" class="button" target="_self" id="atri1" value="Print HTML" onclick="methodForReportHTML();" /> -->
<input type="reset" name="Reset" id="reset" value="Cancel" class="button" onclick="resetCheck();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
 </form>

<script>

function checkPvms()
{
	var pvmsNo='';
	 pvmsNo=document.getElementById('pvmsNiv').value;

	if(pvmsNo=='')
	{
		alert("Please Enter pvmsNo ");
		return false;
	}else
	{
		return true;
	}

		 
}
function methodForReport(){
	//var pvmsNo=document.getElementById('pvmsNiv').value;

	/*if(pvmsNo !=""){
		submitForm('dailyIssueSummery','stores?method=generateDailyIssueSactionReport');
	}else{*/
		submitForm('dailyIssueSummery','stores?method=generateDailyIssueSummeryReport&flag=p');
	//}
}

/* //Note: Revert the changes for story NO :37
function methodForReportHTML(){
	
	    var x = document.getElementById('dailyIssueSummery');
	    if (x.hasAttribute("target")) {
	        x.setAttribute("target", "_blank");
	        submitForm('dailyIssueSummery','stores?method=generateDailyIssueSummeryReport&flag=2');
	    }
		} */
 
 
function methodForReport1(){
		submitForm('dailyIssueSummery','stores?method=generateDailyIssueSummeryReport&flag=j');
}

function prescriptionDetails(val){
	//alert(val);
	if(val != null)
	submitProtoAjax('dailyIssueSummery','stores?method=showPrescriptionDetailsReport&precriptionId='+val);
}

</script>

<%-- <%if(objectList.size()>0){ %>
<!-- <div class="cmntableWithHeight"> -->
<div STYLE=" height:250px; width: 1000px; font-size: 12px; overflow: auto;">
<table id="main">
	<thead>
		<tr>
	<!--	<%if(toDepart.equals("0")){ %>
		<th>Select</th>
		<%}%> -->
			 <th>Sl No.</th>
			<th>PVMS/NIV No.</th>
			<th>Nomenclature</th>
			<th>A/U </th>
			<%//if(reportType.equals("detail")){
				%>
			<th>Batch No.</th>
			<th>DOE</th>
			<th>Manufacturer</th>
			<%//} 
			%>
			<th>Qty Issued</th> 
			<%if(toDepart.equals("0")){ %>
			<th >Prescription No.</th>
			<%}%>		
				
		</tr>
	</thead>

		<%
		int count=0;
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();%>
<tr>
<!-- <%if(toDepart.equals("0")){%>
<td><input type="radio" name="precriptionId" value="<%= object[9]%>" onClick="prescriptionDetails(this.value)"/></td>
<%}%> -->
<td><%=++count%></td>
<td><div class="calcell"><%= object[2]%></div></td>
<td ><div class="calcell"><%=object[3]%></div></td>
<%if(object[4] != null) {%>
<td ><div class="calcell"><%=object[4]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<%//if(reportType.equals("detail")){ 
%>
<td><div class="calcell"><%= object[6]%></div></td>

<%if(object[7] != null){ %>
<td><div class="calcell"> <%=HMSUtil.convertDateToStringWithoutTime((Date)object[7])%></div></td>
<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<%//} 
%>
<%if(object[10] != null) {%>
	<td ><div class="calcell"><%=object[10]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<%if(object[0] != null) {%>
	<td ><div class="calcell"><%=object[0]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
<%if(toDepart.equals("0")){ %>
<%if(object[8] != null) {%>
	<td><div class="calcell"><%=object[8]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} }%>

</tr>
<%}%>

</table>
</div>
<%}%> --%>
<%if(issueMList.size()>0){ %>

<table id="main">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>UHID</th>
			<th>Name</th>
			<%-- <th>Item Code</th>
			<th>Item Name</th>
			<th>A/U </th>
			<%//if(reportType.equals("detail")){
				%>
			<th>Batch No.</th>
			<th>DOE</th>
			<th>Manufacturer</th>
			<%//} 
			%>
			<th>Qty Issued</th> --%> 
			<th>Details</th>		
			<th>Print</th>	
			<!--
			//Note: Revert the changes for story NO :37
			 <th>HTML View</th> -->	
		</tr>
	</thead>
	<%
	int i=1;
	for(StoreIssueM issueT:issueMList){
		//if(issueT.getItem()!=null){
		%>
<tr>
<td><%=i %></td>
			<td><%=issueT.getHin().getHinNo() %></td>
			<td><%=issueT.getHin().getPFirstName() %></td>
			<%-- <td><%=issueT.getItem().getPvmsNo() %></td>
			<td><%=issueT.getItem().getNomenclature() %></td>
			<%if(issueT.getItem().getItemConversion()!=null ){%>
			<td><%=issueT.getItem().getItemConversion().getPurchaseUnit().getUnitName()%> </td>
			<%}else{ %>
			<td>-</td>
			<%} %>
			
			<%if(issueT.getBatchNo()!=null){ %>
			<td><%=issueT.getBatchNo()%></td>
			<%}else{ %>
			<td>-</td>
			<%} %>
			<td><%=issueT.getStock().getExpiryDate()%></td>
			<%if(issueT.getItem().getManufacturer()!=null){ %>
			<td><%=issueT.getItem().getManufacturer().getManufacturerName()%></td>
			<%}else{ %>
			<td>-</td>
			<%} %>
			<td><%=issueT.getQtyIssued()%></td>  --%>
			<td><input type="button" value="Details" onclick="openpopup(<%=issueT.getId() %>);" /></td>
			<td><input type="button" value="Print" onclick="printReport(<%=issueT.getId() %>);" /></td>
            <%--//Note: Revert the changes for story NO :37
             <td><input type="button" value="VIEW" onclick="PrintReportHTML(<%=issueT.getId() %>);" /></td> --%>

</tr>
<%i++;} %>
</table>
<%} %>
<div class="clear"></div>
<div class="clear"></div>
<div id="testDiv">
			</div>
			
			<script>
			function openpopup(val){
				//alert("val---->>>"+val);
				var url="/hms/hms/stores?method=getDetailsForMedicineIssue&issueId="+val;
//				alert("url---->>>"+url)
				window.open(url,'name',"height=400,width=850,status=1");
			}
			function printReport(val){
				//alert("val---->>>"+val);
				submitForm('dailyIssueSummery','stores?method=printMeddicineDetails&issueId='+val);
				
			}
			
			</script>
			
			
			