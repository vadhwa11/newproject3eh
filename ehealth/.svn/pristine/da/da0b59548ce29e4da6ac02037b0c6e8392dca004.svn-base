<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.TokenDisplayIp"%>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<%@ page import="java.util.*"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/sorttableAccounts.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>


<%
Map<String,Object> map = new HashMap<String,Object>();
String message = null;
String displayName = null;
Map<String,Object> utilMap = new HashMap<String,Object>();
List<TokenDisplayIp> ipWiseDepartmentList = null;
List<MasDepartmentType> masDepartmentTypeList = null;
Set<MasInstituteDepartment> departmentList = null;
StringBuffer departmentNames = null;
String selectedDepartmentNames = "";
int departmentTypeId = 0;

if(request.getAttribute("map") != null){
	map = (Map<String,Object>)request.getAttribute("map");
}

utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime(); 

String time = (String)utilMap.get("currentTime");
utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
String currentDate = (String)utilMap.get("currentDate");


if(map.get("ipWiseDepartmentList")!=null)
{
	ipWiseDepartmentList = (List<TokenDisplayIp>)map.get("ipWiseDepartmentList");
}

if(map.get("masDepartmentTypeList")!=null)
{
	masDepartmentTypeList = (List<MasDepartmentType>)map.get("masDepartmentTypeList");
}

if(map.get("message") != null){
	   message = (String)map.get("message");
	   out.println(message);
}



%>
<script type="text/javascript">

function validateServiceCentreSize(){
	var sel =document.getElementById('departmentIds').options;
	var count = 0;
	for (var i=0; i < sel.length; i++) {
	  if (sel[i].selected) count++;
	}
	if(count >2){
		alert("Only 2 Service Centres can be configured for a display.");
		return false;
		
	}
	return true;
}

function checkForExistingDisplayName(i){
	var displayNameCookiee = i.value;
	 var result='';
		var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		    	result = this.responseText;
		    	 if(result=='true'){
					  alert('Display already exist !');
					  i.value = '';
				  }
		    }
		  };
		  xhttp.open("GET", "opd?method=checkForExistingDisplayName&displayName="+displayNameCookiee, true);
		  xhttp.send();
		  
		 
}

function getServiceCenters(){

	var e = document.getElementById("departmentTypeId");
	var departmentTypeId = e.options[e.selectedIndex].value;
	var formName = 'ipDepartmentMappings';
	var action = '/hms/hms/opd?method=getServiceCenters&departmentTypeId='+departmentTypeId;
	var divName = 'departmentIds';
	submitProtoAjaxWithDivName(formName,action,divName);
	
}

</script>

<% if(map.get("displayName") != null){
	displayName = (String)map.get("displayName");
   %>
<script type="text/javascript">
window.onload = function(){
		 var name = '<%=DISPLAY_NAME_COOKIEE%>';
		 var value = '<%=displayName%>';
		 var days = 1825;
		 var expires = '';
		    if (days) {
		        var date = new Date();
		        date.setTime(date.getTime() + (days*24*60*60*1000));
		        expires = '; expires=' + date.toUTCString();
		    }
		    document.cookie = name + "=" + value + expires + "; path=/";
	};
</script>
<% } %>
<div class="titleBg">
	<h2>Display Wise Departments Mapping</h2>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
	<div id="searchtable" tabindex=2></div>
	<script type="text/javascript"> 
 formFields = [
   [0, "display_name", "id"], [1,"departments"]];
  statusTd = 6;
 </script>

	<form name="ipDepartmentMappings" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}"> <input type="hidden"
			name="tokenDisplayIpId" id="tokenDisplayIpId" value="">
		<div class="Block">
			<label><span>*</span> Display Name </label> <input id="displayName"
				type="text" name="displayName" value="" MAXLENGTH="45"
				validate='displayName,metachar,yes'
				onblur="checkForExistingDisplayName(this);"> <label><span>*</span>
				Service Center Type</label> <select id="departmentTypeId"
				name="departmentTypeId" validate='departmentTypeId,metachar,yes'
				onchange="getServiceCenters();">
				<% if(masDepartmentTypeList!=null) {
		for(MasDepartmentType departmentType : masDepartmentTypeList) {%>
				<option value="<%=departmentType.getId()%>"><%=departmentType.getDepartmentTypeName()%></option>
				<% } } %>
			</select> <label><span>*</span> Service Center</label> <select
				id="departmentIds" name="departmentIds" class="multiple"
				multiple="multiple" validate='departmentIds,metachar,yes'>

			</select>

			<div class="clear"></div>
			<input type="button" name="add" id="addbutton" value="Add"
				class="button"
				onClick="submitForm('ipDepartmentMappings','opd?method=addIpDepartmentsMapping','validateServiceCentreSize');"
				accesskey="a" tabindex=1 /> <input type="button" name="edit"
				id="editbutton" value="Update" class="button"
				onClick="submitForm('ipDepartmentMappings','opd?method=editIpDepartmentsMapping','validateServiceCentreSize')"
				accesskey="u" tabindex=1 /> <input type="button" name="Delete"
				id="deletebutton" value="Delete" class="button"
				onClick="submitForm('ipDepartmentMappings','opd?method=deleteIpDepartmentsMapping')"
				accesskey="d" tabindex=1 />

			<div class="clear"></div>

		</div>
	</form>
</div>

<div id="responseDiv" style="display: none;"></div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;

data_header[0] = new Array;
data_header[0][0] = "Display Name"
data_header[0][1] = "data";
data_header[0][2] = "40%";
data_header[0][3] = "display_name";

data_header[1] = new Array;
data_header[1][0] = "Departments"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "departments";




data_arr = new Array();

<%
if(ipWiseDepartmentList!=null){
Iterator<TokenDisplayIp> itr    =   ipWiseDepartmentList.iterator();
int  counter=0;
	while(itr.hasNext()){
        	  TokenDisplayIp  tokenDisplayIp = (TokenDisplayIp)itr.next();
        	  departmentNames = new StringBuffer();
        	  selectedDepartmentNames = "";
        	   
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= tokenDisplayIp.getId()%>
data_arr[<%= counter%>][1] = "<%=tokenDisplayIp.getDisplayName()%>"
<% 	departmentList = tokenDisplayIp.getMasInstituteDepartments();
	if(departmentList!=null && departmentList.size()>0) {
		for(MasInstituteDepartment masInstituteDepartment : departmentList){
			departmentNames.append(masInstituteDepartment.getDepartment().getDepartmentName()).append(",");
			departmentTypeId = masInstituteDepartment.getDepartment().getDepartmentType().getId();
		}
	
	if(departmentNames!=null && !departmentNames.equals("")){
		selectedDepartmentNames =	departmentNames.substring(0, departmentNames.lastIndexOf(",")).toString();
	}
 } 
%>
data_arr[<%= counter%>][2] = "<%=selectedDepartmentNames%>";
data_arr[<%= counter%>][3] = "<%=departmentTypeId%>";
<%
       counter++;
 }
}
%>
	formName = "ipDepartmentMappings";

	start = 0
	if (data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start, end);

	intializeHover('searchresulttable', 'TR', ' tableover');
	getServiceCenters();
</script>