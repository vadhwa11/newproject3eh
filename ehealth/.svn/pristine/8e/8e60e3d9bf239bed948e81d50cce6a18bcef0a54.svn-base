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
if(session.getAttribute("applicationSet") != null){
applicationSet = (Set<MasApplication>)session.getAttribute("applicationSet");
String csrfvalue="";
if(null !=request.getParameter("csrf")){
	csrfvalue=request.getParameter("csrf");
}

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
Users users =(Users)session.getAttribute("users");
boolean flag1 =false;
boolean flag2 =false;
boolean flag3 =false;
boolean flag4 =false;
boolean flag5 =false;
boolean flag6 =false;
boolean flag7 =false;
boolean flag8 =false;
boolean flag9 =false;
boolean flag10 =false;
boolean flag11 =false;
boolean flag12 =false;
boolean flag13 =true;
boolean flag14 =true;
boolean flag15 =false;
boolean flag16 =false;
boolean flag17 =false;
boolean flag18 =false;
boolean flag19 =false;
boolean flagForSMS=false;
boolean flagForPACS=true;
boolean flagForTokenDisplay = true;
for(MasApplication appMaster : applicationSet){
	if(appMaster.getParentId().equals("0")){
		if( appMaster.getId().equals("A3")) 	//Reception			
		{
			flag1 = true;
		}
		if(appMaster.getId().equals("A332")) 	//OPD			
		{
			flag2 = true;
		}
		if (appMaster.getId().equals("A328")) //Lab		
		{
			flag3 = true;
		}
		if (appMaster.getId().equals("A504")) //Radiology			
		{
			flag4 = true;
		} 
	 	if (appMaster.getId().equals("A1017")) //Dispensary		
		{
			flag5 = true;
		} 
	 	if(appMaster.getId().equals("A105")) 	//Ward			
		{
			flag6 = true;
		}
		if (appMaster.getId().equals("A89")) //Stores			
		{
			flag7 = true;
		} 
		if (appMaster.getId().equals("A2")) //Masters		
		{
			flag8 = true;
		} 
		if (appMaster.getId().equals("A1")) //Billing		
		{
			flag9 = true;
		} 
		if (appMaster.getId().equals("A1174")) //Blood Bank		
		{
			flag10 = true;
		} 
		if (appMaster.getId().equals("A1576")) //Procurement	
		{
			flag11 = true;
		} 
		if (appMaster.getId().equals("A1548")) //Maintenance	
		{
			flag12 = true;
		} 
		if (appMaster.getId().equals("A402")) //HRMS	
		{
			flag13 = true;
		} 
		if (appMaster.getId().equals("A2")) //Accounts	
		{
			flag14 = true;
		} 
		if (appMaster.getId().equals("A324")) //Security	
		{
			flag15 = true;
		} 
		if (appMaster.getId().equals("A376")) //OT
		{
			flag16 = true;
		} 
		if (appMaster.getId().equals("A1667")) //Public Health	
		{
			flag17 = true;
		} 
		
		if(appMaster.getId().equals("A1793"))
		{
			flagForSMS=true;
		} 
		
		if (appMaster.getId().equals("A112")) //MIS
		{
			flag18 = true;
		} 
		/* if(appMaster.getId().equals("A1793"))
		{
			flagForPACS=true;
		} */
		if (appMaster.getId().equals("A2048")) //MIS
		{
			flagForTokenDisplay = true;
		} 
		
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

 <a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showReceptionDefaultJsp')" title="reception" name="reception">  <img src="../jsp/images/menu-icons/reception.gif" class="fade" border="0" name="reception" /> Reception</a> 
<!-- <a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showReceptionDefaultJsp ')"  title="reception" name="reception"><img src="../jsp/images/menu-icons/reception.gif" class="fade" name="reception" /> Reception</a>
 -->
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/reception.gif" class="fade" border="0" name="reception" />
Reception
</li>
<%} %>

<%
if(flag2){
%>
<li>
<a href="#"  onclick="submitForm('defaultMenu','/hms/hms/login?method=showOPClinicDefaultJsp')" title="opd" name="opd"><img src="../jsp/images/menu-icons/opd.gif" class="fade" border="0" name="opd" />OP Clinic</a>

</li>
<%}else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/opd.gif" class="fade" border="0" name="opd" />
OP Clinic
</li>
<%} %>

<%
if(flag3){
%>
<li>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showLaboratoryDefaultJsp')" title="lab" name="lab"><img src="../jsp/images/menu-icons/lab.gif" class="fade" border="0" name="lab" />Lab</a>
</li>
<%}else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/lab.gif" class="fade" border="0" name="lab" />
Lab
</li>
<%} %>

<%
if(flag4){
%>
<li><a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showRadiologyDefaultJsp')" title="radiology" name="radiology"><img src="../jsp/images/menu-icons/radiology.gif" class="fade" border="0" name="radiology" />  Radiology</a>
</li>
<%}else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/radiology.gif" class="fade" border="0" name="radiology" />
Radiology
</li>
<%} %>

<%
if(flag5){
%>
<li>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showPharmacyDefaultJsp')" title="pharmacy" name="pharmacy"><img src="../jsp/images/menu-icons/pharmacy.gif" class="fade" border="0" name="pharmacy" />Pharmacy</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/pharmacy.gif" class="fade" border="0" name="pharmacy" />
Pharmacy
</li>
<%} %>

<%
if(flag6){
%>
<li>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showWardDefaultJsp')" title="ward" name=" In-Patient"><img src="../jsp/images/menu-icons/ward.gif" class="fade" border="0" name="ward" />
 In-Patient</a>

</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/ward.gif" class="fade" border="0" name=" In-Patient" />
 In-Patient
</li>
<%} %>

<%
if(flag7){
%>
<li>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showStoresDefaultJsp')" title="stores" name="stores"><img src="../jsp/images/menu-icons/stores.gif" class="fade" border="0" name="stores" />
 Stores</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/stores.gif" class="fade" border="0" name="stores" />
Stores
</li>
<%} %>
<%
if(flag9){
%>
<li>
<a href="#"  onclick="submitForm('defaultMenu','/hms/hms/login?method=showBillingDefaultJsp')" title="billing" name="billing"><img src="../jsp/images/menu-icons/billing.gif" class="fade" border="0" name="billing" />
Billing</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/billing.gif" class="fade" border="0" name="billing" />
Billing
</li>
<%} %>
<%
if(flag16){
%>

<li>
<a href="#"  onclick="submitForm('defaultMenu','/hms/hms/login?method=showOTDefaultJsp')" title="OT" name="OT"><img src="../jsp/images/menu-icons/ot.gif" class="fade" border="0" name="ot" />
 OT</a>

</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/ot.gif" class="fade" border="0" name="ot" />
OT
</li>
<%} %>
<%
if(flag10){
%>
<li>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showBloodBankDefaultJsp')" title="bloodBank" name="bloodBank"><img src="../jsp/images/menu-icons/blood-bank.gif" class="fade" border="0" name="bloodBank" />
Blood Bank</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/blood-bank.gif" class="fade" border="0" name="bloodBank" />
Blood Bank
</li>
<%} %>
<%
if(flag11){
%>
<li>
<a href="#"  onclick="submitForm('defaultMenu','/hms/hms/login?method=showProcurementDefaultJsp')" title="Procurement" name="Procurement"><img src="../jsp/images/menu-icons/procurement.gif" class="fade" border="0" name="Procurement" />
 Procurement</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/procurement.gif" class="fade" border="0" name="Procurement" />
Procurement
</li>
<%} %>
<%
if(flag12){
%>
<li>
<a href="#"  onclick="submitForm('defaultMenu','/hms/hms/login?method=showMaintenanceDefaultJsp')" title="Maintenance" name="Maintenance"><img src="../jsp/images/menu-icons/maintenance.gif" class="fade" border="0" name=Maintenance />
 Maintenance</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/maintenance.gif" class="fade" border="0" name="Maintenance" />
Maintenance
</li>
<%} %>

<%
if(flag13){
%>
<li>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showHRMSDefaultJsp')" title="hr" name="hr"><img src="../jsp/images/menu-icons/hrms.gif" class="fade" border="0" name=hr />
 HRMS</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/hrms.gif" class="fade" border="0" name="hr" />
HRMS
</li>
<%} %>

<%
if(flag14){
%>
<li>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showAccountsDefaultJsp')" title="Accounts" name="Accounts"><img src="../jsp/images/menu-icons/accounts.gif" class="fade" border="0" name=Accounts />
 Accounts</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/accounts.gif" class="fade" border="0" name="accounts" />
Accounts
</li>
<%} %>

<%
if(flag17){
%>
<li>
<a href="#"    onclick="submitForm('defaultMenu','/hms/hms/login?method=showPublicHealthDefaultJsp')" title="PH" name="PH"><img src="../jsp/images/menu-icons/ph.gif" class="fade" border="0" name="ph" />
 Public Health</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/ph.gif" class="fade" border="0" name="PH" />
Public Health
</li>
<%} %>

<%--Added By Ujjwal For SMS --%>
<%
if(flagForSMS){
%>
<li>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showSMSDefaultJsp')" title="SMS" name="SMS"><img src="../jsp/images/menu-icons/sms-logo_Ehealth.gif" class="fade" border="0" name="sms" />
 SMS</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/sms-logo_Ehealth.gif" class="fade" border="0" name="SMS" />
SMS
</li>
<%} %>

<%
if(flag8){
%>
<li>
<a href="#"  onclick="submitForm('defaultMenu','/hms/hms/login?method=showMastersDefaultJsp')" title="masters" name="masters"><img src="../jsp/images/menu-icons/masters.gif" class="fade" border="0" name="masters" />
 Masters</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/masters.gif" class="fade" border="0" name="masters" />
Masters
</li>
<%} %>

<%
if(flag15){
%>
<li>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showAdminDefaultJsp')" title="Admin" name="Admin"><img src="../jsp/images/menu-icons/admin.gif" class="fade" border="0" name="Admin" />
 Admin</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/admin.gif" class="fade" border="0" name="admin" />
Admin
</li>
<%} %>

<%
if(flag18){
%>
<li>
<a href="#" onclick="submitForm('defaultMenu','/hms/hms/login?method=showMISDefaultJsp')" title="MIS" name="MIS"><img src="../jsp/images/menu-icons/mis.gif" class="fade" border="0" name="MIS" />
 MIS</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/mis.gif" class="fade" border="0" name="MIS" />
MIS
</li>
<%} %>
<%--Added By Rajat For PACS --%>
<%
if(users!=null){
if(flagForPACS && users.getPacsUsername()!=null && users.getPacsPassword()!=null){
	//http://104.211.226.154/login
	String url=prop.getProperty("PACS_URL_FOR_LOGIN");
	String pacsUser =  users.getPacsUsername();
	String pacsPwd =  users.getPacsPassword();
	url = url+"?user="+pacsUser+"&password="+pacsPwd;
%>
<li>
<a href="<%=url%>"  target="_blank" title="PACS" name="PACS"><img src="../jsp/images/menu-icons/radiology.gif" class="fade" border="0" name="sms" />
 PACS</a>
</li>
<% }
else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/radiology.gif" class="fade" border="0" name="SMS" />
PACS</a>
</li>
<%}
}else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/radiology.gif" class="fade" border="0" name="SMS" />
PACS
</li>
<%}%>

<%
if(flagForTokenDisplay){
%>
<li>
<a href="#" onclick="openTokenDisplay();" title="Token Display" name="Token Display"><img src="../jsp/images/menu-icons/queue.gif" class="fade" border="0" name="Token Display" />
Token Display</a>
</li>
<% }else{ %>
<li class="no-access-menu-box">
<img src="../jsp/images/menu-icons/queue.gif" class="fade" border="0" name="Token Display" />
Token Display
</li>
<%} %>

</ul>
</div>
<input type="hidden" name="csrf" value=""/>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</form>
<%if(users!=null){ %>
<form method="post" name="formForPACS">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
<input type="hidden" value="<%=users.getPacsUsername() %>" name="user">
<input type="hidden" value="<%=users.getPacsPassword() %>" name="password"> 
</form>
<%} %>
<div class="clear"></div>
<%@ include file="footer.jsp"%>
</div>
<script type="text/javascript">
function disableBack() {window.history.forward(); } 
disableBack();
window.inhibited_load=disableBack;
window.onpageshow=function(evt){if(evt.persisted)disableBack()}
window.inhibited_unload=function(){void(0)}
function openTokenDisplay()
{
 var url="/hms/hms/opd?method=showWaitingQueueTokenJsp&"+csrfTokenName+"="+csrfTokenValue;
 newwindow=window.open(url,"","status=no,scrollbars=no,resizable=yes,height = 900, width = 1200,fullscreen=yes");
 newwindow.moveTo(1024,0);
}

</script>
<!-- <script>
document.addEventListener("contextmenu", function(e){
    e.preventDefault();
}, false);
</script> --> 