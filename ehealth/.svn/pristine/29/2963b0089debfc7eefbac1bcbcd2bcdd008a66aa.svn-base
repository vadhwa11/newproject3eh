<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.BldCrossmatchDetail"%>
<%@page import="jkt.hms.masters.business.BldCrossmatchingHeader"%>
<%@page import="jkt.hms.masters.business.BloodRequestEntryDetail"%>
<%@page import="jkt.hms.masters.business.BldCrossmatchBagDetail"%>


<%@page import="jkt.hms.util.Box"%>

<%@page import="java.util.Calendar"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>



<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
	 <script type="text/javascript" src="/hms/jsp/js/jquery-1.4.2.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Issue Blood</title>
<div class="titleBg">
<h2>Issue Blood</h2>
</div>

<script type="text/javascript">


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




</head>
<%
Map<String,Object> map = new HashMap<String,Object>();

List<BldCrossmatchDetail> bldCrossMatchDetalList=new ArrayList<BldCrossmatchDetail>();

List<BloodRequestEntryDetail> bldRequstEnrtyDetailList=new ArrayList<BloodRequestEntryDetail>();


BldCrossmatchingHeader bldCrossHeader=new BldCrossmatchingHeader();

if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
if(map.get("bldCrossMatchDetalList") != null){
	bldCrossMatchDetalList = (List<BldCrossmatchDetail>) map.get("bldCrossMatchDetalList");
}
if(map.get("bldCrossHeader") != null){
	bldCrossHeader = (BldCrossmatchingHeader) map.get("bldCrossHeader");
}

if(map.get("bldRequstEnrtyDetailList") != null){
	bldRequstEnrtyDetailList = (List<BloodRequestEntryDetail>) map.get("bldRequstEnrtyDetailList");
}

List<BldCrossmatchBagDetail> bldcossBagDetailList=new ArrayList<BldCrossmatchBagDetail>();

if(map.get("bldcossBagDetailList") != null){
	bldcossBagDetailList = (List<BldCrossmatchBagDetail>) map.get("bldcossBagDetailList");
}
int crossMatchHeaderId=0;
int bldrequestheaderId=0;

if(map.get("bldrequestheaderId") != null){
	bldrequestheaderId = (Integer) map.get("bldrequestheaderId");
}
if(map.get("crossMatchHeaderId") != null){
	crossMatchHeaderId = (Integer) map.get("crossMatchHeaderId");
}
String ProvisDiagnosis="";
if(map.get("ProvisDiagnosis")!=null){
	ProvisDiagnosis=(String)map.get("ProvisDiagnosis");
}

//String ProvisDiagnosis1="";
Date croosMatchdate=null;
String crossMatchTime="";
String UHID="";
String PatientName="";
String gender="";
String IpNum="";

String mobileNum="";

String BloodGroup="";
String Unit="";
String ward="";
String bedNum="";
String Doctorname="";
String crossMatchDate="";
String crossMatchBy="";
String no_of_bottel="";
//System.out.print("componentName  ");
if(null !=bldCrossHeader){
	
	croosMatchdate=bldCrossHeader.getCrossMatchDate();
	crossMatchBy=bldCrossHeader.getCrossMatchBy().getEmployee().getEmployeeName();
	crossMatchTime=bldCrossHeader.getCrossMatchTime();
	UHID=bldCrossHeader.getBldRequest().getHin().getHinNo();
	PatientName=bldCrossHeader.getBldRequest().getHin().getPFirstName();
	gender=bldCrossHeader.getBldRequest().getHin().getSex().getAdministrativeSexName();
	BloodGroup=bldCrossHeader.getBldRequest().getBloodGroup().getBloodGroupName();
	mobileNum=bldCrossHeader.getBldRequest().getHin().getMobileNumber();
	
	if(null !=bldCrossHeader.getBldRequest().getInpatient()){
	IpNum=bldCrossHeader.getBldRequest().getInpatient().getAdNo();
	Doctorname=bldCrossHeader.getBldRequest().getInpatient().getDoctor().getEmployeeName();
	ward=bldCrossHeader.getBldRequest().getInpatient().getAdWard().getDepartmentName();
	if(null != bldCrossHeader.getBldRequest().getInpatient().getBed()) 
		bedNum=bldCrossHeader.getBldRequest().getInpatient().getBed().getBedNo();
	no_of_bottel=bldCrossHeader.getBldRequest().getNoBottles();
	crossMatchDate=HMSUtil.convertDateTypeToStringWithoutTime(bldCrossHeader.getCrossMatchDate()) ;
	}
}


%>
<body>
<form method="post" name="IssueBlood">
<div class="Block">
<h4>Patient Details</h4>

<input type="hidden"  name="crossMatchHeaderName" value="<%=crossMatchHeaderId %>" validate="BP,string,no" maxlength="3"
	tabindex="1" /> 
	<input type="hidden"  name="bldrequestHeaderName" value="<%=bldrequestheaderId %>" validate="BP,string,no" maxlength="3"
	tabindex="1" /> 

<label>UHID</label> 
	<input type="text"  name="" value="<%=UHID %>" validate="BP,string,no" maxlength="3" readonly="readonly"
	tabindex="1" /> 
		
<label>Patient Name</label> 
	<input type="text"  name="" value="<%=PatientName %>" validate="BP,string,no" maxlength="3" readonly="readonly"
	tabindex="1" /> 
	
	<label>Gender</label> 
	<input type="text"  name="" value="<%=gender %>" validate="BP,string,no" maxlength="3" readonly="readonly"
	tabindex="1" /> 
	
	<div class="clear"></div>
	
	<label>IP Number</label> 
	<input type="text"  name="" value="<%=IpNum %>" validate="BP,string,no" maxlength="3" readonly="readonly"
	tabindex="1" /> 
		
<label>Blood group</label> 
	<input type="text"  name="" value="<%=BloodGroup %>" validate="BP,string,no" maxlength="3"readonly="readonly"
	tabindex="1" /> 
	
	<label>Mobile Number</label> 
	<input type="text"  name="" value="<%=mobileNum!=null?mobileNum:"" %>" validate="BP,string,no" maxlength="3" readonly="readonly"
	tabindex="1" /> 
	
<div class="clear"></div>

<label>Unit</label> 
	<input type="text"  name="" value="<%=no_of_bottel %>" readonly="readonly" validate="BP,string,no" maxlength="3"
	tabindex="1" /> 
		
<label>Ward</label> 
	<input type="text"  name="" value="<%=ward %>" validate="BP,string,no" maxlength="3" readonly="readonly"
	tabindex="1" /> 
	
	<label>Bed Number</label> 
	<input type="text"  name="" value="<%=bedNum %>" validate="BP,string,no" maxlength="3" readonly="readonly"
	tabindex="1" /> 
	
	<div class="clear"></div>

<label>Doctor Name</label> 
	<input type="text"  name="" value="<%=Doctorname %>" validate="BP,string,no" maxlength="3" readonly="readonly"
	tabindex="1" />
	<label>Provisional Diagnosis</label>
	<%if(ProvisDiagnosis!=null && !ProvisDiagnosis.equals("")){ %>
	<textarea rows="" cols="" readonly="readonly">
	<%= ProvisDiagnosis%>
	</textarea>
	<%}else{ %>
	<textarea rows="" cols="" readonly="readonly">
	-
	</textarea>
	<%} %>
<div class="clear"></div>
<div class="clear"></div>
<h4>Cross Match Details</h4>
<div class="clear"></div>
<div class="clear"></div>

<label>Cross Match Date</label> 
	<input type="text"  name="" value="<%=crossMatchDate %>" readonly="readonly" validate="BP,string,no" maxlength="3"
	tabindex="1" />
	
	<label>Cross Match Time</label> 
	<input type="text"  name="" value="<%=crossMatchTime %>" readonly="readonly" validate="BP,string,no" maxlength="3"
	tabindex="1" />
	
	<label>Cross Match By </label> 
	<input type="text"  name="" value="<%=crossMatchBy %>" readonly="readonly" maxlength="3" tabindex="1" />

<div class="clear"></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="clear"></div>
<%
Date reqDate=null;
String Qunatity="";
String componentName="";
String sdate="";

for(BloodRequestEntryDetail bch:bldRequstEnrtyDetailList){
	reqDate=bch.getRequest().getOrderDate();
	Qunatity=String.valueOf(bch.getQty());
	componentName=bch.getComponent().getComponentName();
}
if(null !=bldcossBagDetailList && bldcossBagDetailList.size()>0){
%>
	
	<table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			
			<th>Required Date</th>
			<th>Required Quantity(ml)</th>
			<th>Component Name</th>
			<th>Blood Bag Number</th>
			<th>Issued Quantity(ml)</th>
			<th></th>
			<th></th>
		</tr>
		<%
		for(BldCrossmatchBagDetail bch:bldcossBagDetailList){
			if(null !=bch.getBldCrossmatchingHeader().getBldRequest().getOrderDate()){
				sdate=HMSUtil.convertDateToStringTypeDateOnly(bch.getBldCrossmatchingHeader().getBldRequest().getOrderDate());
			}
		
		%>
		
		<tr>
		<td><%=sdate %> </td>
		<td><%=bch.getQuantity() %> </td>
		<td><%=componentName %> </td>
		<td><%=bch.getBagNo() %> </td>
		<td><%=bch.getQuantity() %> </td>
		
	</tr>
	<%}} %>
	</thead>
	</table>
<script type="text/javascript">
function showIssueDiv(){
	document.getElementById("issueId").style.display = "block";
	document.getElementById("unreserve").style.display = "none";
	
}
function showUnreserveDiv(){
	document.getElementById("issueId").style.display = "none";
	document.getElementById("unreserve").style.display = "block";
	
}
</script>

<div class="clear"></div>

<!-- <input type="button" class="button" value="Submit"
	onclick="addRow('dataTable')"
	align="right" /> 
	
	<input type="button" class="buttonHighlight"
	name="Reset" id="reset" value="Reset"
	onclick="deleteRow('dataTable')" accesskey="r" /> -->
	<td><input type="button" class="button" value="Issue"
		onclick="showIssueDiv()"
	align="right"/>  </td>
		<td> <input type="button" class="button" value="Unreserve"
		onclick="showUnreserveDiv()"
	align="right"/> </tr>
<div class="clear"></div>
<div class="clear"></div>

<div class="Block">


<div class="clear"></div>



	<div id="issueId" class="Block" style="display: none; ">
	
	<label>Issue Date </label> 

<input type="text" class="date"
	id="lastDateId" name="issueDate" value="" validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" />
	 <img
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.IssueBlood.issueDate,event)" />
	
     <div class="clear"></div>
     
     <table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			
			<th>Blood Bag Number</th>
			<th>Quantity(ml)</th>
			<th>Select</th>
		</tr>
		<%
		for(BldCrossmatchBagDetail bch:bldcossBagDetailList){

		
		%>
		<tr>
		<td><input type="text" name="reserBag" value="<%=bch.getBagNo() %>"/></td>
		<td><input type="text" name="reserBagQuantity" value="<%=bch.getQuantity() %>"/></td>
		<td><input type="checkbox" name="reservedCheck" value="Bike"> </td>
		</tr>
		<%} %>
	</thead>
	</table>
	
	
    
     
    <%--  <label>Quantity</label>
     <input id="" type="text"
				name="<%=BLOOD_BAG_NO%>" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" />
				
	<label>Quantity Issued</label>
     <input id="" type="text"
				name="<%=BLOOD_BAG_NO%>" value="" size="20" MAXLENGTH="45"
				tabindex=1 readonly="readonly" />
			 --%>
		<div class="clear"></div>
				
	<input type="button" class="button"
	name="save"  value="Save" onclick="submitForm('IssueBlood','/hms/hms/bloodBank?method=submitBloodIssue')" accesskey="r" />
							
    </div>
    
    
    <div class="clear"></div>

 <div id="unreserve" class="Block" style="display: none;">
	
	
	<label>Unreserve Date </label>
<input type="text" class="date"
	id="unreserve" name="unreserveDate" value=""
	validate="Date of Collection,date,no" MAXLENGTH="10" tabindex="1" />
	 <img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date"
	onClick="setdate('',document.IssueBlood.unreserveDate,event)" />
	
     <div class="clear"></div>
    
     <table id=" " width="100%" border="0" cellspacing="0" cellpadding="0">
 <thead>
		<tr>
			
			<th>Blood Bag Number</th>
			<th>Quantity(ml)</th>
			<th>Select</th>
		</tr>
		<tr>
		<%
		for(BldCrossmatchBagDetail bch:bldcossBagDetailList){

		
		%>
		<tr>
		<td><input type="text" name="unreserBag" value="<%=bch.getBagNo() %>"/></td>
		<td><input type="text" name="unreserBagQuantity" value="<%=bch.getQuantity() %>"/></td>
		<td><input type="checkbox" name="unreservedCheck" value="Bike"> </td>
		</tr>
		<%} %>
		
		
		
	</thead>
	</table>
	
	
     <div class="clear"></div>	
	<input type="button" class="button"
	name="Reset" id="reset" value="Submit"
	onclick="" accesskey="r" />
							
    </div>

</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		
</form>
<div class="clear"></div>
<div class="paddingTop40"></div>
</body>
</html>