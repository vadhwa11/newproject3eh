<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.PatientAddress"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>


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
<%
		Map<String,Object> map = new HashMap<String,Object>();
		if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
		}
		int deptId=0;
		if(map.get("deptId") != null) {
			deptId = (Integer) map.get("deptId");
		}
		String deptName="";
		if (map.get("deptName") != null) {
			deptName = (String) map.get("deptName");
		}
		String msg = "";
		 if(map.get("msg") != null){
			  msg = (String)map.get("msg");
		  }
		 
		 //added by govind 30-9-2016
		 Map<Integer,Object> addressmap=new HashMap<Integer,Object>();
List<PatientAddress> searchAddressList = new ArrayList<PatientAddress>();
List<Patient> searchDataList = new ArrayList<Patient>();
if(null !=map.get("searchDataList")){
		searchDataList=(List<Patient>)map.get("searchDataList");
}
if(null!=map.get("addressMap")){
	addressmap=(Map<Integer,Object>)map.get("addressMap");
	System.out.println(" addressMap jsp "+addressmap.size());
	
}           String fromDate="",toDate="",name="",hNo="";
			String pname="";
            String pgender="";
            String patientage="";
            String pstatus="";
            String address="";
            String houseNo="";
            String streetName="";
            String District="";
            String taluk="";
            int currentPage=0;
            int noOfPages=0;
            if(null !=map.get("currentPage")){
            	currentPage=(Integer)map.get("currentPage");
                noOfPages=(Integer)map.get("noOfPages");
            	}
            if(null !=map.get("fromDate")){
            	fromDate=(String)map.get("fromDate");
            	}
            if(null !=map.get("toDate")){
            	toDate=(String)map.get("toDate");
            	}
            if(null !=map.get("hinNo")){
            	hNo=(String)map.get("hinNo");
            	}
            if(null !=map.get("name")){
            	name=(String)map.get("name");
            	}
            Map<String, Object> utilMap = new HashMap<String, Object>();
		 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		 	String currenDate = (String) utilMap.get("currentDate");
		//added by govind 30-9-2016 end
	%>
<div class="titleBg">
<h2>Return Drug</h2>
</div>
<input type="hidden" name="deptName" id="deptName"
	value="<%=deptName %>" />
<div class="Clear"></div>
<form name="search" method="post" action="">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<!-- Code for Load Property file and read data on the behalf of key
Code By Mukesh Narayan Singh
Date 19 July 2010
 -->	
	<%
URL myURL=application.getResource("/WEB-INF/commonFile.properties");
InputStream in = myURL.openStream();
Properties prop = new Properties();
prop.load(in);
//out.println("name-jsp-" +p.getProperty("age") );
%>
<%

if(!msg.equals(""))
	{
	%>
<h4><span><%=msg %></span></h4>
<%}%>


<div class="Block">
<%--
<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <input type="text"
	id="hinId" name="<%=HIN_NO%>" value="" MAXLENGTH="30"
	onchange="submitProtoAjaxWithDivName('search','stores?method=getIssueNo','testDiv')"
	validate="HIN ,String,no" tabindex=1 /> 
	<label>Name</label>
	<input type="text" name="patientName" id="nameId" value="" onchange="submitProtoAjaxWithDivName('search','stores?method=getIssueNo','testDiv')"  />
	<label>Mobile No.</label>
	<input type="text" name="mobileNumber" id="mobileId" value="" maxlength="10" onchange="submitProtoAjaxWithDivName('search','stores?method=getIssueNo','testDiv')" />
	 --%>
	<!-- added by govind 30-9-2016 -->
	<label><span>*</span> From Date </label> 
   <input	type="text" name="fromDate" id="fromDate" value="<%=fromDate %>"	class="date" maxlength="30" tabindex=1 readonly="readonly" onblur="checkDate();"/> 
   <img src="/hms/jsp/images/cal.gif" onClick="javascript:setdate('',document.search.fromDate,event)" width="16" height="16" border="0" validate="Pick a date" class="calender" />
   <label><span>*</span> To Date </label>  
   <input type="text"	name="toDate" id="toDate" value="<%=toDate %>" class="date"	maxlength="30" tabindex=1 readonly="readonly" onblur="checkDate();"/>
   <img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date" onClick="javascript:setdate('',document.search.toDate,true);" />
   <div class="clear"></div>
	<label>Name</label>
	<input type="text" name="patientName" id="nameId"  value="<%=name %>" />
	<label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <input type="text"
	id="hinId" name="<%=HIN_NO%>" value="<%=hNo %>" MAXLENGTH="30"
	tabindex=1 /> 
	<label>Mobile No.</label>
	<input type="text" name="mobileNumber" id="mobileId" maxlength="10" />
	<!-- added by govind 30-9-2016 end -->
	<label>Issue No</label>
<div id="testDiv"><input type="text" id="visitId"
	name="<%=ISSUE_NO %>" value="" 
	validate="Issue No ,String,no" class="readOnly" readonly="readonly"
	tabindex=1 /></div>
<div class="clear"></div>
<!-- added by govind 30-09-2016 -->
<input type="button" tabindex="1" id="btnSearchvisit" value="Search"
			class="button"
			onclick="submitForm('search','/hms/hms/stores?method=searchPatientReturnDrug');" />
<div class="clear"></div>

	<% 
	if(searchDataList.size()>0){%>

	<table class="tableTrhighlights">
		<tr>
			<th>UHID</th>
			<th>Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Address</th>
		</tr>
		<%for(Patient patient1:searchDataList){
			
			if(patient1.getPFirstName()!=null)
			pname=patient1.getPFirstName();
			if(null !=patient1.getSex()){
			pgender=patient1.getSex().getAdministrativeSexName();
			}
			if(null!=patient1.getAge())
			patientage=String.valueOf(patient1.getAge());
			pstatus=patient1.getStatus()!=null?patient1.getStatus():"N";
			
			if(null!=addressmap.get(patient1.getId())){
				//address=addressmap.get(patient1.getId()).toString();
// 				if(null != searchAddressList){
// 					searchAddressList.clear();
// 				}
			//searchAddressList=(List<PatientAddress>)addressmap.get(patient.getId());
// 			if(null!=searchAddressList && searchAddressList.size()>0){
				
// 				 houseNo="";
// 				 streetName="";
// 				 District="";
// 				 taluk="";
// 				for(PatientAddress paddress:searchAddressList){
// 					if(null!=paddress.getHouseNo())
// 					houseNo=paddress.getHouseNo();
// 					if(null!=paddress.getStreetRoad())
// 					streetName=paddress.getStreetRoad();
// 					if(paddress.getDistrict()!=null){
// 						District=paddress.getDistrict().getDistrictName();
// 					}
// 					if(paddress.getTaluk()!=null){
// 						taluk=paddress.getTaluk().getTalukName();
// 					}
// 					address=houseNo+"   "+streetName+"  "+taluk+"  "+District;
// 				}
				
// 			}
			}%>
		<tr onclick="submitProtoAjaxWithDivName('search','stores?method=getIssueNo&hinNo=<%=patient1.getHinNo()%>','testDiv')">
			<td><%=patient1.getHinNo()%></td>
			<td><%=pname%></td>
			<td><%=pgender%></td>
			<td><%=patientage%></td>
			<td><%=address %></td>
		</tr>
		<%}%>
	</table>
	<%
	if(currentPage !=1){%>

		<a href='/hms/hms/stores?method=searchPatientReturnDrug&page=<%=currentPage-1%>&hinNo=<%=hNo%>&patientName=<%=name%>&fromDate=<%=fromDate%>&toDate=<%=toDate%>'>Previous</a>


	<%}

if(noOfPages>=1){
	for(int i=1;i<=noOfPages;i++){
		if(currentPage==i){%>
	<%=i%>
	<%}else{%>

	<a
		href='/hms/hms/stores?method=searchPatientReturnDrug&page=<%=i%>&hinNo=<%=hNo%>&patientName=<%=name%>&fromDate=<%=fromDate%>&toDate=<%=toDate%>'><%=i%></a>
	<%
	}}
}
if(currentPage <noOfPages){%>

	<a
		href='/hms/hms/stores?method=searchPatientReturnDrug&page=<%=currentPage+1%>&hinNo=<%=hNo%>&patientName=<%=name%>&fromDate=<%=fromDate%>&toDate=<%=toDate%>'>Next</a>
	
	<%}}%>
<!-- added by govind 30-09-2016 end-->		
</div>
</form>
<%
			String includedJsp ="";
			if (request.getAttribute("map") != null) {
				map = (Map<String,Object>) request.getAttribute("map");
			}
			if(map.get("includedJsp") != null){
				includedJsp = (String)map.get("includedJsp");
			}
			
			if(!includedJsp.equals("")){
			%>
<jsp:include page="<%=includedJsp%>" flush="true" />
<%} %>
<script>
function submitDetails(){
	var issueId=document.getElementById("issueId").value;
	var hinId=document.getElementById("hinId").value;
	var nameId=document.getElementById("nameId").value;
	var mobileId=document.getElementById("mobileId").value;
	//alert("in method!!"+hinId);
	submitForm('search','stores?method=getPatientDrugDetail&<%=ISSUE_NO%>='+issueId+'&<%=HIN_ID%>='+hinId+'&name='+nameId+'&mobileId='+mobileId);
}

//added by govind 5-10-2016
function checkDate() {
	var vDate = new Date();
	var result = false;
	var fromDate = document.getElementById('fromDate').value;
	var toDate = document.getElementById('toDate').value;


	if (fromDate != "") {
		var d3 = new Date(fromDate.substring(6),
				(fromDate.substring(3, 5) - 1), fromDate.substring(0, 2));

		if (vDate < d3) {
			alert("Future Date not allowed");
			document.getElementById('fromDate').value = "";
			result = false;
		} else {
			result = true;
		}
	}
	if (toDate != "") {
		var d4 = new Date(toDate.substring(6),
				(toDate.substring(3, 5) - 1), toDate.substring(0, 2));
		if (vDate < d4) {
			alert("Future Date not allowed");
			document.getElementById('toDate').value = "";
			result = false;
		} else {
			result = true;
		}
	}

	return result;

}
//added by govind 5-10-2016 end
</script>