<%@page import="jkt.hms.masters.business.MasEmpaneled"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Properties"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasApplication"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
 
 <div id="mainIn">
 <script type="text/javascript" src="/hms/jsp/js/csrfToken.js"></script>
<form name="defaultMenu" method="post">
<%
	Map mainMap=(Map)request.getAttribute("map");
Set<MasApplication> applicationSet = null;
String empaneledAccessDepartmentCode="";
if(session.getAttribute("applicationSet") != null){
applicationSet = (Set<MasApplication>)session.getAttribute("applicationSet"); 
String csrfvalue="";
if(null !=request.getParameter("csrf")){
	csrfvalue=request.getParameter("csrf");
}

} 
if(session.getAttribute("empaneledAccessDepartmentCode")!=null){
	empaneledAccessDepartmentCode=(String)session.getAttribute("empaneledAccessDepartmentCode");
}
if(session.getAttribute("selectedAppId")!=null){
	 session.removeAttribute("selectedAppId");
}
if(session.getAttribute("childAppId")!=null){
	 session.removeAttribute("childAppId");
}

URL resourcePath = Thread.currentThread().getContextClassLoader()
		.getResource("jktPacs.properties");
InputStream in = resourcePath.openStream();
Properties prop = new Properties();
prop.load(in);
MasEmpaneled masEmpaneled =(MasEmpaneled)session.getAttribute("users");
boolean flag1 =false;
boolean flag2 =false; 
boolean flag3 =false; 
if(empaneledAccessDepartmentCode!=null && !"".equalsIgnoreCase(empaneledAccessDepartmentCode)){  
		if("Lab".equalsIgnoreCase(empaneledAccessDepartmentCode)) 	//Reception			
		{
			flag1 = true;
		}
		if("Radio".equalsIgnoreCase(empaneledAccessDepartmentCode)) 	//OPD			
		{
			flag2 = true;
		}
		
		if("Phar".equalsIgnoreCase(empaneledAccessDepartmentCode)) 	//OPD			
		{
			flag3 = true;
		}  
}
%>
<script>
/* function showModuleHomePage(moduleName,appId){
	if(validateMetaCharacters(moduleName) && validateMetaCharacters(appId)){
		submitForm('defaultMenu','/hms/hms/login?method=showModuleDefaultJsp&moduleName='+moduleName+'&appId='+appId)
	}
} */
</script>
		
<div class="clear"></div>
<div class="menu-box">
<ul>
 <%
if(flag1){
%>
<li>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showLaboratoryDefaultJspForEmpaneled&'+csrfTokenName+'='+csrfTokenValue)"   
title="lab" name="lab"><img src="../jsp/images/menu-icons/lab.gif" class="fade" name="lab" />Lab</a>
</li>
<% } %> 


<%
if(flag2){
%>
<li><a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showRadiologyDefaultJspForEmpaneled&'+csrfTokenName+'='+csrfTokenValue)"  
title="radiology" name="radiology"><img src="../jsp/images/menu-icons/radiology.gif" class="fade" name="radiology" />  Radiology</a>
</li>
<%} %>  

<%
if(flag3){
%>
<li>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showPharmacyDefaultJspForEmpaneled&'+csrfTokenName+'='+csrfTokenValue)" 
title="pharmacy" name="pharmacy"><img src="../jsp/images/menu-icons/pharmacy.gif" class="fade" name="pharmacy" />Pharmacy</a>
</li>
<%}  %> 

</ul>
</div>
<input type="hidden" name="csrf" value=""/>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
 
<div class="clear"></div> 
</div>
<script type="text/javascript">
function disableBack() {window.history.forward(); } 
disableBack();
window.inhibited_load=disableBack;
window.onpageshow=function(evt){if(evt.persisted)disableBack()}
window.inhibited_unload=function(){void(0)}

</script>
<!-- <script>
document.addEventListener("contextmenu", function(e){
    e.preventDefault();
}, false);
</script> --> 




<%-- <%@page import="jkt.hms.masters.business.MasHospitalType"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
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
		List<MasHospital> hospitalListJsp = new ArrayList<MasHospital>();
		List<MasHospitalType> hospitalTypeListJsp = new ArrayList<MasHospitalType>();
		String message="";
		int empanelledId=0;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		if(map.get("visitList") != null){
			visitListJsp= (List<Object[]>)map.get("visitList");
		}
		
		if(map.get("hospitalList") != null){
			hospitalListJsp= (List<MasHospital>)map.get("hospitalList");
		}
		
		if(map.get("empanelledId") != null){
			empanelledId= (Integer)map.get("empanelledId");
		}
		
		
		if(map.get("hospitalTypeList") != null){
			hospitalTypeListJsp= (List<MasHospitalType>)map.get("hospitalTypeList");
		}
		if(map.get("message") != null&&!"".equals(map.get("message").toString())){
			message=map.get("message").toString();
		}
		Map<String, Object> utilMap = new HashMap<String, Object>();
		utilMap = (Map) HMSUtil.getCurrentDateAndTime();
		String date = (String) utilMap.get("currentDate");
		/* String message = ""; */
		/* if (map.get("visitList") != null) {
			message = (String) map.get("message");
		} */
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

function checkNameLengthOnSubmit(){
	alert("ok");
	var pPatientName="";
	var hospital="";
	var hospitalType="";
	var hinNo="";
	var mobileNo=""; 
	submitForm('empanelled','/hms/hms/stores?method=empanelled'); 
}
</script>
 
<%
	if(!"".equals(message)){
%>
<h4><span><%=message %></span></h4>
<%} %>
 
<form name="empanelled" method="post" action="">
<div class="titleBg">
<h2>Empanelled Store (Patient List)</h2> 
<!-- <h2> Dispensing Pending List</h2> -->
</div>
<div class="clear"></div>
<div class="Block" >
<label > From Date</label> 
<input type="text" name="<%= FROM_DATE%>" value="<%=date %>" class="date" MAXLENGTH="30" readonly="readonly" validate="fromDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=FROM_DATE%>',document.empanelled.<%=FROM_DATE%>,true);" />
<label > To Date</label> 
<input type="text"	name="<%= TO_DATE%>" value="<%=date %>" class="date" MAXLENGTH="30"	readonly="readonly" validate="toDate,date,no"/> 
<img src="/hms/jsp/images/cal.gif" width="16"	height="16" border="0" validate="Pick a date"	onclick="javascript:setdate('<%=TO_DATE%>',document.empanelled.<%=TO_DATE%>,true);" />

<label >Hospital Type </label> 
<select name="<%=HOSPITAL_TYPE %>" id="hospitalType" validate="HospitalType,metachar,no">

<option value="">
select
</option>
<%
for(MasHospitalType masHospitalType:hospitalTypeListJsp)
{
	%>
	<option value="<%=masHospitalType.getId()%>"><%=masHospitalType.getHospitalTypeName()%></option>
	<%
}
%>
</select>

<div class="clear" ></div>
<label>Hospital</label> 
<select name="<%=HOSPITAL%>" id="hospital" validate="Hospital,metachar,no">
<option value="">
select
</option>
<%
for(MasHospital masHospital:hospitalListJsp)
{
	%>
	<option value="<%=masHospital.getId()%>"><%=masHospital.getHospitalName()%></option>
	<%
}
%>
</select>



<input type="hidden" id="empanelledId" name="empanelledId" value="<%out.print(empanelledId); %>" 	maxlength="30" tabindex=1 />
 
<label >UHID </label> 
<input type="text"	name="<%=HIN_NO %>" id="hinNo" value="" 	validate="UHID,metachar,no" MAXLENGTH="16" tabindex=1 />

<label >Patient Name </label> 
<input type="text"	name="<%=P_FIRST_NAME %>" id="pFirstName" value="" 	validate="Name,string,no" MAXLENGTH="128" tabindex=1 />
 
<div class="clear" ></div>
<label> Mobile No. </label> 
<input type="text"	name="<%=MOBILE %>"  id="mobile" value="" 	 validate="Mobile,contact,no"   maxlength="12" tabindex=1 />
<!-- <label> Doctor </label> 
<select>
<option>Select Doctor</option>
</select> -->
 
<!-- <label class="auto">Pending</label> 
<input type="radio"	name="dispensType" value="pending" checked="checked" class="radioCheck">
<label class="auto">Issued</label> 
<input type="radio"	name="dispensType" value="issued" class="radioCheck"> 
<label	class="auto">All</label> 
<input type="radio" name="dispensType"	value="all" class="radioCheck"> 
<div class="clear"></div> -->
</div>




<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
                                                                                            <!-- onClick="submitForm('CurrentDispensing','billing?method=showPharmacySalesViewJsp');" -->
<input type="submit" name="Submit" id="addbutton"  value="Search" class="button" onClick="submitForm('empanelled','stores?method=empanelled');"
    	accesskey="g" tabindex=1 />

<!-- <input type="button" name="search" value="Search" class="button" onClick="submitForm('pharmacySalesViewSearch','billing?method=getPharmacySalesDetails');"	accesskey="g" tabindex=1 /> -->
<!-- <input type="button" class="buttonBig" value="Open Token Display"
	onclick="" align="right" /> 
<input type="button" class="buttonBig" value="Close Token Display"
	align="left" onclick="" /> -->
	<!-- <a href="/hms/hms/stores?method=showPendingDispensingJsp" >Dispensing details(Grid Onclick)</a>
	<a href="/hms/hms/stores?method=openTokenForPharmacy" >Dispensing details(Grid Onclick)</a> -->
	<!--  <a href="/hms/hms/stores?method=showDetailPendingDispensing" >Dispensing details(Grid Onclick)</a> -->
<input type="hidden" size="2" value="fgfg" name="noOfRecords"
	id="noOfRecords" validate="noOfRecords,int,no"/>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="admissionAcceptance" method="post" action="">
<script
       type="text/javascript">
       formFields = [
                       [0, "<%= HIN_ID%>", "id"],[1, "slno"], [2,"token"],[3,"hin"],[4,"uhin_id"], [5,"patName"], [6,"Department"],[7,"prescribed_by"],[8,"Date"]];
        statusTd = 7;
       </script>
</div>

<script type="text/javascript" language="javascript">
       data_header = new Array();
       
       data_header[0] = new Array;
       data_header[0][0] = "Sl No."
       data_header[0][1] = "data";
       data_header[0][2] = "15%";
       data_header[0][3] = "slno";
       
       
       
       data_header[1] = new Array;
       data_header[1][0] = "UHID_id"                
       data_header[1][1] = "hide";
       data_header[1][2] = "15%";
       data_header[1][3] = "hin";
       
      
     
       
       
       data_header[2] = new Array;
       data_header[2][0] = "UHID"
       data_header[2][1] = "data";
       data_header[2][2] = "15%";
       data_header[2][3] = "uhin_id";
       
       
       data_header[3] = new Array;
       data_header[3][0] = "Patient Name"
       data_header[3][1] = "data";
       data_header[3][2] = "20%";
       data_header[3][3] = "patName";
               
       data_header[4] = new Array;
       data_header[4][0] = "Hospital"           
       data_header[4][1] = "data";
       data_header[4][2] = "15%";
       data_header[4][3] = "token"; 
       
       data_header[5] = new Array;
       data_header[5][0] = "Hospital Type"           
       data_header[5][1] = "data";
       data_header[5][2] = "15%";
       data_header[5][3] = "H_Type";
       
       data_header[6] = new Array;
       data_header[6][0] = "Department"
       data_header[6][1] = "data";
       data_header[6][2] = "30%";
       data_header[6][3] = "Department";
       
       data_header[7] = new Array;
       data_header[7][0] = "Prescribed By"
       data_header[7][1] = "data";
       data_header[7][2] = "30%";
       data_header[7][3] = "prescribed_by";
       
       data_header[8] = new Array;
       data_header[8][0] = "Date"
       data_header[8][1] = "data";
       data_header[8][2] = "30%";
       data_header[8][3] = "Date";
       
       
       
     /*   data_header[7] = new Array;
       data_header[7][0] = "Date"
       data_header[7][1] = "data";
       data_header[7][2] = "30%";
       data_header[7][3] = "reffereddep1"; */
       data_arr = new Array();
        <%
           int  counter=0;
               if (visitListJsp != null && visitListJsp.size()> 0) {
                       int loopIndex=1;
//                        out.println(  visitListJsp.get(0) instanceof Visit);
                for(Object[] visitList : visitListJsp){
            
                	//Visit patientvisitList=(Visit)patientvisit;
                       
                      
       %>
                         data_arr[<%= counter%>] = new Array();
                         data_arr[<%= counter%>][0] = "<%= counter+1%>"
                       data_arr[<%= counter%>][1] = "<%= counter+1%>"
    				   data_arr[<%= counter%>][2] = "<%=visitList[7]%>@@@<%=empanelledId%>"
                       data_arr[<%= counter%>][3] = "<%=visitList[1]%>"
                       data_arr[<%= counter%>][4] = "<%=visitList[3]%>"
                       data_arr[<%= counter%>][5] ="<%=visitList[8]%>"
                    	   data_arr[<%= counter%>][6] ="<%=visitList[9]%>"
                    	
                    		   <%if((MasDepartment)visitList[4]!=null){%>
                           	 data_arr[<%= counter%>][7] = "<%=((MasDepartment)visitList[4]).getDepartmentName()%>"
                             <%}else{%>
                           	  data_arr[<%= counter%>][7] = "" 
                             <%}%>
                            
                            <% if((MasEmployee)visitList[5]!=null){%>
                          	  data_arr[<%= counter%>][8] = "<%=((MasEmployee)visitList[5]).getEmployeeName()%>" 
                            <%}else{%>
                          	  data_arr[<%= counter%>][8] = "" 
                            <%}%> 
                    	   data_arr[<%= counter%>][9] = "<%=visitList[6]%>"
                       <%counter++;
                       loopIndex++;
            
               
       }}
               %> 
               formName = "empanelled"
       
      
       
       start = 0;
       if(data_arr.length < rowsPerPage){
               end = data_arr.length;
               
       }
       else{
               end = rowsPerPage;
       
       }
       
       makeTable(start,end);
                
       </script>
        
<div class="clear"></div>
<div class="paddingTop15"></div>

<%
			String includedJsp ="";
			if(map.get("includedJsp") != null){
				includedJsp = (String)map.get("includedJsp");
			}
			
			if(!includedJsp.equals("")){
			%>
<jsp:include page="<%=includedJsp%>" flush="true" />
<%} %> --%>