<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.PharmacyLabQueue"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>


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
      // List<Visit> visits=new ArrayList<Visit>();
       
       List<PharmacyLabQueue> pharmacyLabQueue = new ArrayList<PharmacyLabQueue>();
       List<Inpatient> inpatientList=new ArrayList<Inpatient>();
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
		/* if(map.get("visits") != null){
			visits = (List<Visit>)map.get("visits");
		} */
		
		if(map.get("pharmacyLabQueue") != null){
			pharmacyLabQueue = (List<PharmacyLabQueue>)map.get("pharmacyLabQueue");
		}
		
		// added by amit das on 11-05-2017
		String billingScreen = null;
		if (map.get("billingScreen") != null) {
			billingScreen = (String) map.get("billingScreen");
		}
		String patientType="OP";
		if(map.get("inpatientList") != null){
			inpatientList = (List<Inpatient>)map.get("inpatientList");
		}
		
		if(map.get("patientType")!=null){
			patientType=(String) map.get("patientType");
		}
		System.out.println("inpatientList jsp "+inpatientList.size()+" patientType "+patientType);
	%>
<div class="titleBg">
<h2>Order Booking</h2>
</div>
<input type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />

<form name="search" method="post" action="">
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
<%-- <div class="Block"><label><%=prop.getProperty("com.jkt.hms.registration_no")%></label> <input type="text"
	id="hinId" name="<%=HIN_NO%>" value="" MAXLENGTH="30"
	onchange="submitProtoAjaxWithDivName('search','lab?method=getVisitNo&flag=lab','testDiv')"
	validate="HIN ,String,yes" tabindex=1 /> <label>Visit No </label>
<div id="testDiv"><input type="text" id="visitId"
	name="<%=VISIT_NUMBER %>" value=""
	onchange="submitForm('search','lab?method=getPatientDetails');"
	validate="Visit No ,String,yes" class="readOnly" readonly="readonly"
	tabindex=1 /></div> --%>
	<div class="Block">
	<label>New</label> 
<input type="radio" name="reportType"	value="New" class="inputRadiobutton" maxlength="30" tabindex=1 onclick="displayLabDetails(this.value)" checked="checked"/> 
<label>Existing </label> 
<input	type="radio" name="reportType" value="Existing" class="inputRadiobutton" maxlength="30" tabindex=1 onclick="displayLabDetails(this.value)"  /> 
	</div>
<div id="newDiv" >
	<div class="Block">
<label>UHID</label>
<input type="text" name="uhid" value=""	tabindex=1   id="uhidId" validate="UHID ,alphanumeric,no"/>
<label>Patient Type</label>
<select name="labType" id="labType" tabindex=1 onchange="enableIPDiv()">
<%if(patientType.equals("OP")){ %>
<option value="OP" selected="selected">OP</option>
<option value="IP">IP</option>
<%}if(patientType.equals("IP")){ %>
<option value="IP" selected="selected">IP</option>
<option value="OP">OP</option>
<%} %>
</select>
</div>	
<div class="clear"></div>
<div style="display: none;" id="ipDiv">
<label>IP No.</label>
<input type="text" name="ipNo" id="ipNo" tabindex=1/>
</div>
<input name="button"  type="button"	value="Search" class="button"	onclick="submitForm('search','lab?method=showOpOrderBookingSearchJsp')" />
<div class="clear"></div>
</div>
<div class="clear"></div>
<div id="existingDiv" style="display: none;">
	<div class="Block">
<label>UHID</label>
<input type="text" name="hinNo" value=""   id="hinNo" validate="UHID ,alphanumeric,no" onblur="displayOrderNo(this.value)"/>
<div  id="testDiv">
<label>Order No.</label>
<select name="orderId" id="orderId" >
</select>
</div>
</div>	


<input name="button"  type="button"	value="Search" class="button"	onclick="submitForm('search','lab?method=showExistingOpOrderBookingJsp')" />
<div class="clear"></div>
</div>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<form name="itemGrid" method="post"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 </form>
 <div id="ipBlock">
   <div class="Block">
   <%if(patientType.equals("IP")){ %>
   <%if(inpatientList.size()>0){ %>
   <table>
        <tr><th>S.No</th><th>UHID</th><th>Admitted Date</th><th>IP No.</th><th>Patient Name</th><th>Department</th></tr>
        <% int sn=1;
        for(Inpatient inpatient:inpatientList){ %>
        
        <tr onclick="submitForm('pendingList<%=sn %>', 'lab?method=getPatientDetails')" style="cursor: pointer;"><td><%=sn %>
      <form name="pendingList<%=sn %>" method="post"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

 
        <input type="hidden" name="inpatientId" value="<%=inpatient.getId()%>" />
        <input type="hidden" name="billingScreen" value="y">
        <input type="hidden" name="patientType" value="<%=patientType%>" />
        </form>
        </td>
        <td><%=inpatient.getHin().getHinNo()  %></td>
        <td><%=(inpatient.getAddEditDate()!=null?HMSUtil.convertDateToStringWithoutTime(inpatient.getAddEditDate()):"")  %></td>
        <td><%=inpatient.getAdNo() %></td>
        <td><%=inpatient.getHin().getPFirstName() %></td>
        <td><%=inpatient.getDepartment().getDepartmentName()%></td></tr>
        <% sn++;} %>
         
    </table>
     <%}else{ %>
        No Record Found
        <%}} %>
  </div>
 </div>
 <div id="opBlock">
  <div class="Block">
   <%if(patientType.equals("OP")){%>
    <%if(pharmacyLabQueue.size()>0){ %>
    <table>
        <tr><th>S.No</th><th>UHID</th><th>Date</th><th>Patient Name</th><th>Department</th></tr>
        <% int sn=1;
        for(PharmacyLabQueue labQueue:pharmacyLabQueue){ %>
        
        <tr onclick="submitForm('pendingList<%=sn %>', 'lab?method=getPatientDetails')" style="cursor: pointer;"><td><%=sn %>
        <form name="pendingList<%=sn %>" method="post"><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

        <input type="hidden" name="patientType" value="<%=patientType%>" />
        <input type="hidden" name="<%=VISIT_NUMBER %>" value="<%=labQueue.getVisit().getId()%>" />
         <input type="hidden" name="pharmacyLabQueue" value="<%=labQueue.getId()%>" />
        <input type="hidden" name="visitNo" value="<%=labQueue.getVisit().getVisitNo()%>" />
        <input type="hidden" name="billingScreen" value="<%=billingScreen%>">
        </form>
        </td>
        <td><%=labQueue.getVisit().getHin().getHinNo()  %></td>
        <td><%=HMSUtil.convertDateToStringWithoutTime(labQueue.getVisit().getVisitDate())  %></td>
        <td><%=labQueue.getVisit().getHin().getPFirstName() %></td>
        <td><%= labQueue.getVisit().getDepartment().getDepartmentName()%></td></tr>
        <% sn++;} %>
         
    </table>
    <%}else{ %>
        No Record Found
        <%} %>
     <%}%>
   </div>
  </div>
  <%--  <%
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
<%} %>  --%>
<script>
<%--added by govind 26-07-2017--%>
window.onload= enableIPDiv;
function enableIPDiv(){
	var sel = document.getElementById("labType");
	var labType = sel.options[sel.selectedIndex].value;
	if(labType=="IP"){
		document.getElementById('ipDiv').style.display = 'block';
		document.getElementById('ipBlock').style.display = 'block';
		document.getElementById('opBlock').style.display = 'none';
	}else{
		document.getElementById('ipDiv').style.display = 'none';
		document.getElementById('opBlock').style.display = 'block';
		document.getElementById('ipBlock').style.display = 'none';
	}
}


function displayLabDetails(val){
	if(val=='New'){
		document.getElementById('newDiv').style.display = 'block';
		document.getElementById('existingDiv').style.display = 'none';
		document.getElementById('ipBlock').style.display = 'block';
		document.getElementById('opBlock').style.display = 'block';
		
	}else{
		document.getElementById('existingDiv').style.display = 'block';
		document.getElementById('newDiv').style.display = 'none';
		document.getElementById('ipBlock').style.display = 'none';
		document.getElementById('opBlock').style.display = 'none';
	}	
		
	}
	
	function displayOrderNo(val){
		if(val !=''){
			submitProtoAjax('search','/hms/hms/opBilling?method=displayOrderNoWithOutResultEntry&hinNo='+val)
			}
	}

	
<%--added by govind 26-07-2017 end--%>
</script>