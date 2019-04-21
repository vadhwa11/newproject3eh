<%@page import="jkt.hms.masters.business.MasDepartmentType"%>
<%@page import="jkt.hms.masters.business.MultiDepartmentMapping"%>
<%@page import="jkt.hms.masters.business.MasInstituteDepartment"%>
<%@ page import="java.util.*"%>


<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>

<%
Map<String,Object> map = new HashMap<String,Object>();
List<Object[]> multiDepartmentMappingsList = null;
List<MasInstituteDepartment> serviceCenterList = null;
List<MasInstituteDepartment> childPharmacyServiceCenterList = null;
List<MasInstituteDepartment> childLabServiceCenterList = null;
List<MasInstituteDepartment> childBillingServiceCenterList = null;
List<MasInstituteDepartment> childSampleCollectionServiceCenterList = null;
List<String> departmentTypeList = null;
String departmentTypeName = null;
String message = null;

boolean dataExist = false;

if(request.getAttribute("map") != null){
	map = (Map<String,Object>) request.getAttribute("map");

multiDepartmentMappingsList = (List<Object[]>) map.get("multiDepartmentMappingsList");
serviceCenterList = (List<MasInstituteDepartment>) map.get("serviceCenterList");
childPharmacyServiceCenterList = (List<MasInstituteDepartment>) map.get("childPharmacyServiceCenterList");
childLabServiceCenterList = (List<MasInstituteDepartment>) map.get("childLabServiceCenterList");
childBillingServiceCenterList = (List<MasInstituteDepartment>) map.get("childBillingServiceCenterList");
childSampleCollectionServiceCenterList = (List<MasInstituteDepartment>) map.get("childSampleCollectionServiceCenterList");

departmentTypeList = (List<String>) map.get("departmentTypeList");

if(map.get("result") != null){
	   boolean result = (Boolean)map.get("result");
	   if(result)
		   message = "Multi Department Mappping added successfully !";
		else
			message = "Some error occured !";
	   	
		out.println(message);
}

}

if (multiDepartmentMappingsList != null && multiDepartmentMappingsList.size() > 0)
	dataExist = true;
	
%>
<div class="titleBg">
	<h2>Multi Service Center Mapping</h2>
</div>
<div class="clear"></div>
<div class="Block">
	<div class="clear"></div>
	<div id="divVal">

		<form name="multiDepartments" method="post">
			<div id="pageNavPosition"></div>
			<div class="clear"></div>
			<div class="clear"></div>
			<div class="clear"></div>
			<label><span>*</span>Service Center</label> <select
				validate="Parent Service Center,string,no"
				name="parentServiceCenterId" id="parentServiceCenterId">
				<option value="0">Select</option>
				<% if(serviceCenterList!=null && serviceCenterList.size()>0) {
				for(MasInstituteDepartment serviceCenter : serviceCenterList) {%>
				<option value="<%=serviceCenter.getId()%>"><%=serviceCenter.getDepartment().getDepartmentName()%></option>
				<% } } %>
			</select> <label><span>*</span>Department Type</label> <select
				validate="Department Type,string,no" name="departmentTypeName"
				id="departmentTypeName"
				onchange="setServiceCenterOptions(this.options[this.options.selectedIndex].innerHTML);">
				<option value="0">Select</option>
				<% if(departmentTypeList!=null && departmentTypeList.size()>0) {
				for(String departmentType : departmentTypeList) {%>
				<option value="<%=departmentType%>"><%=departmentType%></option>
				<% } } %>
			</select> <label><span>*</span>To Be Mapped Service Center</label> <select
				style="height: 20%;" multiple
				validate="To Be Mapped Service Center,string,no"
				name="serviceCenterId" id="serviceCenterId">
			</select>

			<div>
				<input name="add" id="add" class="buttonAuto" type="button"
					align="right"
					onclick="submitForm('multiDepartments','hospital?method=addMultiDepartmentMapping');"
					value="ADD" />
			</div>

			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">
		</form>
	</div>

</div>

<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="test" class="">
	<div id="searchresults" tabindex="2">
		<div id="searchtable" tabindex="2"></div>
	</div>
</div>

<% if(dataExist) {%>
<div style="float: left;">
	<input name="delete" id="delete" class="buttonAuto" type="button"
		align="right" value="Delete" onclick="deleteMultiDepartmentMapping();" />
</div>
<% } %>

<script type="text/javascript">
	  formFields = [[0, "orderId", "id"],[1,"Service Center"],[2,"Department Type"],[2,"Mapped Service Centers"]];
	  statusTd = 15;
</script>

<script type="text/javascript">

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = ""
data_header[0][1] = "data"; 
data_header[0][2] = "0.5%";
data_header[0][3] = "id"

data_header[1] = new Array;
data_header[1][0] = "Service Center"
data_header[1][1] = "data"; 
data_header[1][2] = "7%";
data_header[1][3] = "serviceCenterId"


data_header[2] = new Array;
data_header[2][0] = "Department Type"
data_header[2][1] = "data"; 
data_header[2][2] = "7%";
data_header[2][3] = "departmentType"

data_header[3] = new Array;
data_header[3][0] = "Mapped Service Centers"
data_header[3][1] = "data"; 
data_header[3][2] = "7%";
data_header[3][3] = "mappedServiceCenters"

data_arr = new Array();
<%
    int  counter=0;
	if (dataExist){
		for(Object[] objects : multiDepartmentMappingsList){
			MasInstituteDepartment masInstituteDepartment = (MasInstituteDepartment)objects[0];
			departmentTypeName =	((MasDepartmentType)objects[1]).getDepartmentTypeName();
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][1] = '<input type="checkbox" class="multiDepartment" value="<%=masInstituteDepartment.getId()%>"  />';
data_arr[<%=counter%>][2] = '<%=masInstituteDepartment.getDepartment().getDepartmentName()%>';

<%Set<MultiDepartmentMapping> multiDepartmentMappingSet =	masInstituteDepartment.getMultiDepartmentMappings();
		StringBuilder multiDepartments = new StringBuilder();
		if(multiDepartmentMappingSet!=null && multiDepartmentMappingSet.size()>0){
			for(MultiDepartmentMapping multiDepartmentMapping : multiDepartmentMappingSet){
				if(departmentTypeName.equalsIgnoreCase(multiDepartmentMapping.getServiceCenter().getDepartment().getDepartmentType().getDepartmentTypeName()))
					multiDepartments.append(multiDepartmentMapping.getServiceCenter().getDepartment().getDepartmentName()+", ");
			}
		}
		String multiDepartmentStr = multiDepartments.toString().trim();%>
data_arr[<%=counter%>][3] = '<%=departmentTypeName%>';
data_arr[<%=counter%>][4] = '<%=multiDepartmentStr.substring(0, multiDepartmentStr.length()-1)%>';
<%counter++; 
	}
}%>
	formName = "multiDepartments"
	start = 0
	if (data_arr.length < rowsPerPage) {
		end = data_arr.length;
	} else {
		end = rowsPerPage;
	}

	makeTable(start, end);

	function deleteMultiDepartmentMapping() {
		var parentServiceCenterIdArray = document
				.getElementsByClassName('multiDepartment');
		var parentServiceCenterIds = '';
		for (var i = 0; i < parentServiceCenterIdArray.length; i++) {
			if (parentServiceCenterIdArray[i].checked)
				parentServiceCenterIds = parentServiceCenterIds
						+ parentServiceCenterIdArray[i].value + ',';

		}

		submitForm('multiDepartments',
				'hospital?method=deleteDepartmentPharmacyMapping&parentServiceCenterIds='
						+ parentServiceCenterIds);
	}
	
	var childPharmacyServiceCenters = new Array(<%=childPharmacyServiceCenterList.size()%>);
	var childLabServiceCenters = new Array(<%=childLabServiceCenterList.size()%>);
	<%-- var childBillingServiceCenters = new Array(<%=childBillingServiceCenterList.size()%>);
	var childSampleCollectionServiceCenters = new Array(<%=childSampleCollectionServiceCenterList.size()%>); 
	 --%>
	<%if(childPharmacyServiceCenterList!=null && childPharmacyServiceCenterList.size()>0) {
		for(MasInstituteDepartment instituteDepartment : childPharmacyServiceCenterList){%>
	childPharmacyServiceCenters.push({id:<%=instituteDepartment.getId()%>,value:'<%=instituteDepartment.getDepartment().getDepartmentName()%>'});
	<%} }%>
	
	<%if(childLabServiceCenterList!=null && childLabServiceCenterList.size()>0) {
		for(MasInstituteDepartment instituteDepartment : childLabServiceCenterList){%>
	childLabServiceCenters.push({id:<%=instituteDepartment.getId()%>,value:'<%=instituteDepartment.getDepartment().getDepartmentName()%>'});
	<%} }%>
	
	<%if(childBillingServiceCenterList!=null && childBillingServiceCenterList.size()>0) {
		for(MasInstituteDepartment instituteDepartment : childBillingServiceCenterList){%>
	childBillingServiceCenters.push({id:<%=instituteDepartment.getId()%>,value:'<%=instituteDepartment.getDepartment().getDepartmentName()%>'});
	<%} }%>
	
	<%if(childSampleCollectionServiceCenterList!=null && childSampleCollectionServiceCenterList.size()>0) {
		for(MasInstituteDepartment instituteDepartment : childSampleCollectionServiceCenterList){%>
	childSampleCollectionServiceCenters.push({id:<%=instituteDepartment.getId()%>,value:'<%=instituteDepartment.getDepartment().getDepartmentName()%>'});
	<%} }%>
	
	var optionsArray = new Array();
	
	function fillOptions(optionsArray){
		var serviceCenterId = document.getElementById('serviceCenterId');
		serviceCenterId.innerHTML = '';
		for(var i=0; i<optionsArray.length; i++){
			if(optionsArray[i]){
			 	var opt = document.createElement('option');
			    opt.value = optionsArray[i].id;
			    opt.innerHTML = optionsArray[i].value;
			    serviceCenterId.appendChild(opt);
			}
		}
	}
	
	function setServiceCenterOptions(departmentType){
		
		switch (departmentType) {
		 case 'Pharmacy':
			 optionsArray = childPharmacyServiceCenters;
			 break;
		 case 'Diagnostics':
			 optionsArray = childLabServiceCenters;
			 break;
		}
		fillOptions(optionsArray);
	}
	
	
</script>