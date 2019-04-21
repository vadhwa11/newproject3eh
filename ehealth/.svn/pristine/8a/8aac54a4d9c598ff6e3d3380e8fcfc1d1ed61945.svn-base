<%@page import="jkt.hms.masters.business.MasPhReportsParameters"%>
<%@ page import="java.util.*"%>
<script lang="javascript" src="/hms/jsp/js/csrfToken.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/jquery1.min.js"></script>
<script src="/hms/jsp/js/jquery.ba-throttle-debounce.min.js"></script>
<script src="/hms/jsp/js/jquery.stickyheader.js"></script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasPhReportsParameters> masPhReportsParameterList = new ArrayList<MasPhReportsParameters>();
	int i = 0;

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	
	
	if(map.get("masPhReportsParameterList")!=null){
		masPhReportsParameterList =(List) map.get("masPhReportsParameterList");
		
	}
	
	
	
	
	String message="";
	if(map.get("message")!=null){
		message=(String)map.get("message");
	}
	%>


<%
if(message!=null && !message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>

<div class="titleBg"><h2>PH Reports Parameters Mappings</h2>
</div>
<div class="Block">
<div class="clear"></div>
<div class="Clear"></div>
<div class="floatRight"><input type="button" name="assignTemplate" value="Assign Mappings"	
class="buttonBig"	onClick="submitForm('showUserAssinedTemplet','pubHealth?method=updatePhReportsParametersMappingJsp&'+csrfTokenName+'='+csrfTokenValue);" /></div>
<div class="Clear"></div>
<div id="divEmployee">

<div class="Clear"></div>
<table>
<tr>
</tr>
</table>
<form name="showUserAssinedTemplet" method="post">
<div class="userRights">
<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<thead>
	<tr>
	<th>S No.</th>
	<th>HMIS Parameter Id</th>
	<th>HMIS Parameter Name</th>
	<th>Forms to be submitted by States U.T.s to Government Of India (Monthly Consolidated) Parameter Id</th>
	<th>Forms to be submitted by States U.T.s to Government Of India (Monthly Consolidated) Parameter Name</th>
	<th>Forms to be submitted by States U.T.s to Government Of India (Quarterly Consolidated) Parameter Id</th>
	<th>Forms to be submitted by States U.T.s to Government Of India (Quarterly Consolidated) Parameter Name</th>
	<th>Forms to be submitted by States U.T.s to Government Of India (Annually Consolidated) Parameter Id</th>
	<th>Forms to be submitted by States U.T.s to Government Of India (Annually Consolidated) Parameter Name</th>
	<th>Forms for use within States for internal reporting (Monthly Format for District HQ) Parameter Id</th>
	<th>Forms for use within States for internal reporting (Monthly Format for District HQ) Parameter Name</th>
	<th>Forms for use within States for internal reporting (Quarterly Format for District) Parameter Id</th>
	<th>Forms for use within States for internal reporting (Quarterly Format for District) Parameter Name</th>
	<th>Forms for use within States for internal reporting (Annually Format for District) Parameter Id</th>
	<th>Forms for use within States for internal reporting (Annually Format for District) Parameter Name</th>
	<th>Forms for use within States for internal reporting (Quarterly Format for State HQ) Parameter Id</th>
	<th>Forms for use within States for internal reporting (Quarterly Format for State HQ) Parameter Name</th>
	<th>Forms for use within States for internal reporting (Annually Format for State) Parameter Id</th>
	<th>Forms for use within States for internal reporting (Annually Format for State) Parameter Name</th>
	<th>Facility Level Forms for internal reporting (Monthly format for SC's and equivalent facilities) Parameter Id</th>
	<th>Facility Level Forms for internal reporting (Monthly format for SC's and equivalent facilities) Parameter Name</th>
	<th>Facility Level Forms for internal reporting (Monthly format for CHC's and equivalent hospitals) Parameter Id</th>
	<th>Facility Level Forms for internal reporting (Monthly format for CHC's and equivalent hospitals) Parameter Name</th>
	<th>Facility Level Forms for internal reporting (Monthly format for PHC's and equivalent facilities) Parameter Id</th>
	<th>Facility Level Forms for internal reporting (Monthly format for PHC's and equivalent facilities) Parameter Name</th>
	<th>Facility Level Forms for internal reporting (Monthly format for Sub-District Hospitals and equivalent hospitals) Parameter Id</th>
	<th>Facility Level Forms for internal reporting (Monthly format for Sub-District Hospitals and equivalent hospitals) Parameter Name</th>
	<th>Facility Level Forms for internal reporting (Monthly format for District Hospitals and equivalent hospitals) Parameter Id</th>
	<th>Facility Level Forms for internal reporting (Monthly format for District Hospitals and equivalent hospitals) Parameter Name</th>
	<th>Facility Level Forms for infrastructure reporting (Format for Sub-District Hospitals - 31 to 50 Beds) Parameter Id</th>
	<th>Facility Level Forms for infrastructure reporting (Format for Sub-District Hospitals - 31 to 50 Beds) Parameter Name</th>
	<th>Facility Level Forms for infrastructure reporting (Format for Sub-District Hospitals - 51 to 100 Beds) Parameter Id</th>
	<th>Facility Level Forms for infrastructure reporting (Format for Sub-District Hospitals - 51 to 100 Beds) Parameter Name</th>
	<th>Facility Level Forms for infrastructure reporting (Format for District Hospitals - 101 to 200 Beds) Parameter Id</th>
	<th>Facility Level Forms for infrastructure reporting (Format for District Hospitals - 101 to 200 Beds) Parameter Name</th>
	<th>Facility Level Forms for infrastructure reporting (Format for District Hospitals - 201 to 300 Beds) Parameter Id</th>
	<th>Facility Level Forms for infrastructure reporting (Format for District Hospitals - 201 to 300 Beds) Parameter Name</th>
	<th>Facility Level Forms for infrastructure reporting (Format for District Hospitals - 301 to 500 Beds) Parameter Id</th>
	<th>Facility Level Forms for infrastructure reporting (Format for District Hospitals - 301 to 500 Beds) Parameter Name</th>
	<th>NVBDCP Parameter Id</th>
	<th>NVBDCP Parameter Name</th>
	</tr>
	</thead>
	<tbody>
	<% if(masPhReportsParameterList!=null && masPhReportsParameterList.size()>0){ 
		 i=0;
		for(MasPhReportsParameters masPhReportsParameter : masPhReportsParameterList){
			
	%>
	<tr>
	<td><input type="hidden" name="paramaterId<%=++i%>" value="<%=masPhReportsParameter.getId()%>"><%=i%></td>
	<%-- <% if(i==1){ %> --%>
	<td><input type="text" name="hmisParameterId<%=i%>" value="<%=(masPhReportsParameter.getHmisId()!=null)?masPhReportsParameter.getHmisId():""%>" ></td>
	<td><input type="text" name="hmisParameterName<%=i%>" value="<%=(masPhReportsParameter.getHmisParameter()!=null)?masPhReportsParameter.getHmisParameter():""%>" ></td>
	<td><input type="text" name="goiMonthlyParameterId<%=i%>" value="<%=(masPhReportsParameter.getGoiMonthlyId()!=null)?masPhReportsParameter.getGoiMonthlyId():""%>" ></td>
	<td><input type="text" name="goiMonthlyParameterName<%=i%>" value="<%=(masPhReportsParameter.getGoiMonthlyParameter()!=null)?masPhReportsParameter.getGoiMonthlyParameter():""%>" ></td>
	<td><input type="text" name="goiQuarterlyParameterId<%=i%>" value="<%=(masPhReportsParameter.getGoiQuarterlyId()!=null)?masPhReportsParameter.getGoiQuarterlyId():""%>" ></td>
	<td><input type="text" name="goiQuarterlyParameterName<%=i%>" value="<%=(masPhReportsParameter.getGoiQuarterlyParameter()!=null)?masPhReportsParameter.getGoiQuarterlyParameter():""%>" ></td>
	<td><input type="text" name="goiAnnuallyParameterId<%=i%>" value="<%=(masPhReportsParameter.getGoiAnnuallyId()!=null)?masPhReportsParameter.getGoiAnnuallyId():""%>" ></td>
	<td><input type="text" name="goiAnnuallyParameterName<%=i%>" value="<%=(masPhReportsParameter.getGoiAnnuallyParameter()!=null)?masPhReportsParameter.getGoiAnnuallyParameter():""%>" ></td>
	<td><input type="text" name="internalReportDistrictMonthlyParameterId<%=i%>" value="<%=(masPhReportsParameter.getInternalReportMonthlyDistrictId()!=null)?masPhReportsParameter.getInternalReportMonthlyDistrictId():""%>" ></td>
	<td><input type="text" name="internalReportDistrictMonthlyParameterName<%=i%>" value="<%=(masPhReportsParameter.getInternalReportMonthlyDistrictParameter()!=null)?masPhReportsParameter.getInternalReportMonthlyDistrictParameter():""%>" ></td>
	<td><input type="text" name="internalReportDistrictQuarterlyParameterId<%=i%>" value="<%=(masPhReportsParameter.getInternalReportQuarterlyDistrictId()!=null)?masPhReportsParameter.getInternalReportQuarterlyDistrictId():""%>" ></td>
	<td><input type="text" name="internalReportDistrictQuarterlyParameterName<%=i%>" value="<%=(masPhReportsParameter.getInternalReportQuarterlyDistrictParameter()!=null)?masPhReportsParameter.getInternalReportQuarterlyDistrictParameter():""%>" ></td>
	<td><input type="text" name="internalReportDistrictAnnuallyParameterId<%=i%>" value="<%=(masPhReportsParameter.getInternalReportAnnuallyDistrictId() !=null)?masPhReportsParameter.getInternalReportAnnuallyDistrictId():""%>" ></td>
	<td><input type="text" name="internalReportDistrictAnnuallyParameterName<%=i%>" value="<%=(masPhReportsParameter.getInternalReportAnnuallyDistrictParameter()!=null)?masPhReportsParameter.getInternalReportAnnuallyDistrictParameter():""%>" ></td>
	<td><input type="text" name="internalReportStateQuarterlyParameterId<%=i%>" value="<%=(masPhReportsParameter.getInternalReportQuarterlyStateId()!=null)?masPhReportsParameter.getInternalReportQuarterlyStateId():""%>" ></td>
	<td><input type="text" name="internalReportStateQuarterlyParameterName<%=i%>" value="<%=(masPhReportsParameter.getInternalReportQuarterlyStateParameter()!=null)?masPhReportsParameter.getInternalReportQuarterlyStateParameter():""%>" ></td>
	<td><input type="text" name="internalReportStateAnnuallyParameterId<%=i%>" value="<%=(masPhReportsParameter.getInternalReportAnnuallyStateId() !=null)?masPhReportsParameter.getInternalReportAnnuallyStateId():""%>" ></td>
	<td><input type="text" name="internalReportStateAnnuallyParameterName<%=i%>" value="<%=(masPhReportsParameter.getInternalReportAnnuallyStateParameter()!=null)?masPhReportsParameter.getInternalReportAnnuallyStateParameter():""%>" ></td>
	<td><input type="text" name="internalReportMonthlyScParameterId<%=i%>" value="<%=(masPhReportsParameter.getInternalReportMonthlyScId()!=null)?masPhReportsParameter.getInternalReportMonthlyScId():""%>" ></td>
	<td><input type="text" name="internalReportMonthlyScParameterName<%=i%>" value="<%=(masPhReportsParameter.getInternalReportMonthlyScParameter()!=null)?masPhReportsParameter.getInternalReportMonthlyScParameter():""%>" ></td>
	<td><input type="text" name="internalReportMonthlyChcParameterId<%=i%>" value="<%=(masPhReportsParameter.getInternalReportMonthlyChcId()!=null)?masPhReportsParameter.getInternalReportMonthlyChcId():""%>" ></td>
	<td><input type="text" name="internalReportMonthlyChcParameterName<%=i%>" value="<%=(masPhReportsParameter.getInternalReportMonthlyChcParameter()!=null)?masPhReportsParameter.getInternalReportMonthlyChcParameter():""%>" ></td>
	<td><input type="text" name="internalReportMonthlyPhcParameterId<%=i%>" value="<%=(masPhReportsParameter.getInternalReportMonthlyPhcId() !=null)?masPhReportsParameter.getInternalReportMonthlyPhcId():""%>" ></td>
	<td><input type="text" name="internalReportMonthlyPhcParameterName<%=i%>" value="<%=(masPhReportsParameter.getInternalReportMonthlyPhcParameter()!=null)?masPhReportsParameter.getInternalReportMonthlyPhcParameter():""%>" ></td>
	<td><input type="text" name="internalReportMonthlySubDistrictParameterId<%=i%>" value="<%=(masPhReportsParameter.getInternalReportMonthlySubDistrictId()!=null)?masPhReportsParameter.getInternalReportMonthlySubDistrictId():""%>" ></td>
	<td><input type="text" name="internalReportMonthlySubDistrictParameterName<%=i%>" value="<%=(masPhReportsParameter.getInternalReportMonthlySubDistrictParameter()!=null)?masPhReportsParameter.getInternalReportMonthlySubDistrictParameter():""%>" ></td>
	<td><input type="text" name="internalReportMonthlyDistrictHospitalParameterId<%=i%>" value="<%=(masPhReportsParameter.getInternalReportMonthlyDistrictHospitalId()!=null)?masPhReportsParameter.getInternalReportMonthlyDistrictHospitalId():""%>" ></td>
	<td><input type="text" name="internalReportMonthlyDistrictHospitalParameterName<%=i%>" value="<%=(masPhReportsParameter.getInternalReportMonthlyDistrictHospitalParameter()!=null)?masPhReportsParameter.getInternalReportMonthlyDistrictHospitalParameter():""%>" ></td>
	<td><input type="text" name="infrastructurelReportMonthlySubDistrict1ParameterId<%=i%>" value="<%=(masPhReportsParameter.getInfrastructurelReportMonthlySubDistrict1Id()!=null)?masPhReportsParameter.getInfrastructurelReportMonthlySubDistrict1Id():""%>" ></td>
	<td><input type="text" name="infrastructurelReportMonthlySubDistrict1ParameterName<%=i%>" value="<%=(masPhReportsParameter.getInfrastructurelReportMonthlySubDistrict1Parameter()!=null)?masPhReportsParameter.getInfrastructurelReportMonthlySubDistrict1Parameter():""%>" ></td>
	<td><input type="text" name="infrastructurelReportMonthlySubDistrict2ParameterId<%=i%>" value="<%=(masPhReportsParameter.getInfrastructurelReportMonthlySubDistrict2Id()!=null)?masPhReportsParameter.getInfrastructurelReportMonthlySubDistrict2Id():""%>" ></td>
	<td><input type="text" name="infrastructurelReportMonthlySubDistrict2ParameterName<%=i%>" value="<%=(masPhReportsParameter.getInfrastructurelReportMonthlySubDistrict2Parameter()!=null)?masPhReportsParameter.getInfrastructurelReportMonthlySubDistrict2Parameter():""%>" ></td>
	<td><input type="text" name="infrastructurelReportMonthlyDistrict1ParameterId<%=i%>" value="<%=(masPhReportsParameter.getInfrastructurelReportMonthlyDistrict1Id()!=null)?masPhReportsParameter.getInfrastructurelReportMonthlyDistrict1Id():""%>" ></td>
	<td><input type="text" name="infrastructurelReportMonthlyDistrict1ParameterName<%=i%>" value="<%=(masPhReportsParameter.getInfrastructurelReportMonthlyDistrict1Parameter()!=null)?masPhReportsParameter.getInfrastructurelReportMonthlyDistrict1Parameter():""%>" ></td>
	<td><input type="text" name="infrastructurelReportMonthlyDistrict2ParameterId<%=i%>" value="<%=(masPhReportsParameter.getInfrastructurelReportMonthlyDistrict2Id()!=null)?masPhReportsParameter.getInfrastructurelReportMonthlyDistrict2Id():""%>" ></td>
	<td><input type="text" name="infrastructurelReportMonthlyDistrict2ParameterName<%=i%>" value="<%=(masPhReportsParameter.getInfrastructurelReportMonthlyDistrict2Parameter()!=null)?masPhReportsParameter.getInfrastructurelReportMonthlyDistrict2Parameter():""%>" ></td>
	<td><input type="text" name="infrastructurelReportMonthlyDistrict3ParameterId<%=i%>" value="<%=(masPhReportsParameter.getInfrastructurelReportMonthlyDistrict3Id()!=null)?masPhReportsParameter.getInfrastructurelReportMonthlyDistrict3Id():""%>" ></td>
	<td><input type="text" name="infrastructurelReportMonthlyDistrict3ParameterName<%=i%>" value="<%=(masPhReportsParameter.getInfrastructurelReportMonthlyDistrict3Parameter()!=null)?masPhReportsParameter.getInfrastructurelReportMonthlyDistrict3Parameter():""%>" ></td>
	<td><input type="text" name="nvbdcpParameterId<%=i%>" value="<%=(masPhReportsParameter.getNvbdcpReportId()!=null)?masPhReportsParameter.getNvbdcpReportId():""%>" ></td>
	<td><input type="text" name="nvbdcpParameterName<%=i%>" value="<%=(masPhReportsParameter.getInfrastructurelReportMonthlyDistrict3Parameter()!=null)?masPhReportsParameter.getInfrastructurelReportMonthlyDistrict3Parameter():""%>" ></td>
	</tr>
	<%   } } %>
	
	<input type="hidden" name="count" id="count" value="<%=i%>">
	</tbody>
	
</table>
</div>
</form>
</div>
<script>
function setHiddenTempId(obj,cnt,fieldName,chgCnt){
	if(obj.checked){
		
		document.getElementById(fieldName+cnt).value=obj.value;
	}else{
		document.getElementById(fieldName+cnt).value=0;
		}
	document.getElementById('changeFlag'+chgCnt+cnt).value='yes';
}
</script>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"></form>