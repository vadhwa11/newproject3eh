<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<%@page import="jkt.hms.masters.business.MasDietType"%>
<%@page import="jkt.hms.masters.business.MasDietCombination"%>


<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>

<div id="contentHolder">
<form name="dietChange" method="post" action="">
<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<Inpatient> patientList = new ArrayList<Inpatient>();
	List<MasDiet> dietList = new ArrayList<MasDiet>();
	List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
	List<MasDietCombination> dietCombinationList = new ArrayList<MasDietCombination>();
	
	if(request.getAttribute("map") != null){
		map = (Map<String, Object>)request.getAttribute("map");
	}
	if(map.get("patientList") != null){
		patientList = (List<Inpatient>)map.get("patientList");
	}
	if(map.get("dietList") != null){
		dietList = (List<MasDiet>)map.get("dietList");
	}
	if(map.get("dietTypeList") != null){
		dietTypeList = (List<MasDietType>)map.get("dietTypeList");
	}
	if(map.get("dietCombinationList") != null){
		dietCombinationList = (List<MasDietCombination>)map.get("dietCombinationList");
	}
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}


%> <!--Block One Starts-->
<div class="Clear"></div>

<h6>Patient Diet Change</h6>
<h4><%=deptName %></h4>

<div class="blockFrame">
<div class="Clear"></div>
<label>Service No.</label> <input type="text" id="serviceNo"
	name="<%=SERVICE_NO%>" value="" size="10" MAXLENGTH="30" /> <label>
HIN:</label> <input type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30"
	size="10" /> <label> IP No.:</label> <input type="text"
	name="<%=AD_NO%>" value="" MAXLENGTH="30" size="10" /> <input
	name="search" type="button" value="Search" class="cmnButton"></div>
<div class="Clear"></div>
<div class="tableHholderCmnLarge">

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	id="chargeDetails" colspan="7">
	<tr>
		<th>S.No.</th>
		<th width="18%">Service No</th>
		<th width="22%">Patient Name</th>
		<th width="18%">Admission No</th>
		<th width="18%">Diet Name</th>
		<th width="18%">Diet Category</th>
		<th width="18%">Diet Type</th>
		<th width="18%">Walking/Bed Patient</th>
	</tr>

	<%
     		if(patientList.size() > 0 ){
     			int count = 1;
     			String patientName = "";
     			for(Inpatient inpatient : patientList){
     				Patient patient = inpatient.getHin();
   				  	if(patient.getPFirstName()+patient.getPLastName()!= null || patient.getPFirstName()+patient.getPLastName()!="")
   				  	 {
   				  		patientName = patient.getPFirstName()+patient.getPLastName();
   				  	 }
     	%>

	<tr>

		<td><input type="text" size="2" value="<%=count %>"
			name="<%=SR_NO%>" readonly="readonly" /></td>
		<td><input type="text" align="right" name="<%=SERVICE_NO %>"
			value="<%=patient.getServiceNo() %>" tabindex="1" /></td>
		<td><input type="text" name="<%=PATIENT_NAME %>"
			value="<%=patientName %>" maxlength="4" tabindex="1" /></td>
		<td><input type="text" value="<%=inpatient.getAdNo() %>"
			name="<%=AD_NO %>" maxlength="12" /></td>
		<td><select name="<%=DIET_ID %>" id="dietId<%=count %>">
			<option value="0">Select</option>
			<%
		   		for(MasDiet diet : dietList){
		   			if(inpatient.getDiet().getId() == diet.getId()){
		   	%>
			<option value="<%=diet.getId() %>" selected="selected"><%=diet.getDietName() %></option>
			<%		}else{ %>
			<option value="<%=diet.getId() %>"><%=diet.getDietName() %></option>
			<%} 
		   	}%>
		</select></td>
		<td><select name="<%=DIET_CATEGORY_NAME %>"
			id="dietCategoryId<%=count %>">
			<option value="">Select</option>
			<%
		   			if(inpatient.getDiet().getDietCategory().equals("T")){
		   		%>
			<option value="T" selected="selected">Therapeutic</option>
			<option value="G">General</option>
			<%  }
		   			if(inpatient.getDiet().getDietCategory().equals("G")){
		   		%>
			<option value="G" selected="selected">General</option>
			<option value="T">Therapeutic</option>
			<%} %>
		</select></td>
		<td><select name="<%=DIET_TYPE_ID %>" id="dietTypeId<%=count %>">
			<option value="0">Select</option>
			<%
		   		for(MasDietType dietType : dietTypeList){
		   			if(dietType.getDietTypeName().equalsIgnoreCase(inpatient.getDietType())){
		   				
		   		%>
			<option value="<%=dietType.getId() %>" selected="selected"><%=dietType.getDietTypeName() %></option>
			<%		}
		   				if(!inpatient.getDietType().equalsIgnoreCase(dietType.getDietTypeName())){
		  	%>
			<option value="<%=dietType.getId() %>"><%=dietType.getDietTypeName() %></option>
			<%
		   				
		   			}
		  				}%>

		</select></td>
		<td><select name="<%=CONDITION %>">
			<option value="">Select</option>
			<option value="W">Walking</option>
			<option value="B">Bed Patient</option>

		</select> <input type="hidden" name="<%=DIET_COMBINATION_ID %>"
			id="dietCombinationId<%=count %>" value="" /></td>

	</tr>
	<script type="text/javascript">
		var dietId = document.getElementById('dietId<%=count %>').value;
		var dietTypeId = document.getElementById('dietTypeId<%=count %>').value;
		var dietCat = document.getElementById('dietCategoryId<%=count %>').value;
		
		<%
			for(MasDietCombination dietCombination : dietCombinationList){
		%>
				var dId = '<%=dietCombination.getDiet().getId()%>'
				var dtId = '<%=dietCombination.getDietType().getId()%>'
				var dCat = '<%=dietCombination.getDiet().getDietCategory()%>'
				if(dietId == dId && dietTypeId == dtId && dietCat == dCat){
					document.getElementById('dietCombinationId<%=count %>').value = '<%=dietCombination.getId()%>'
				}
		<%}%>
		</script>

	<input type="hidden" name="<%=HIN_ID %>" value="<%=patient.getId() %>" />
	<input type="hidden" name="<%=INPATIENT_ID %>"
		value="<%=inpatient.getId() %>" />
	<%  count++;
} 
}%>

</table>
</div>
<div class="Clear"></div>

<input type="hidden" name="counter" id="counter" value="" />
<div class="division"></div>

<div class="bottom"><input type="button" class="button"
	value="Submit" align="right"
	onclick="submitForm('dietChange','diet?method=addPatientDietDetails');" />
<input type="reset" class="buttonHighlight" value="Reset" /> <input
	type="hidden" name="rows" id="rr" value="1" /></div>

<div class="division"></div>



<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</div>
