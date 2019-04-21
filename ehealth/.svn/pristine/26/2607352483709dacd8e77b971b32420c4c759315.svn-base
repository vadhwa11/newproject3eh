<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");

	}
	List treatmentTemplateList= new ArrayList();
	 List<MasEmployee> employeeList = new ArrayList<MasEmployee>();
	 if(map.get("employeeList") != null){
			employeeList=(List<MasEmployee>)map.get("employeeList");
			}
	int departmentId=0;
	 if(map.get("departmentId") != null){
		 departmentId=(Integer)map.get("departmentId");
			}
	%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>
<%@page import="jkt.hms.masters.business.MasFrequency"%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<label class="small">Referred To</label>
<select name="empId" id="empId ">
	<option value="0">Select</option>
	<%
		   Iterator itr1= employeeList.iterator();
	       while(itr1.hasNext())
	       {   MasEmployee masEmployee= new MasEmployee();
	        masEmployee=(MasEmployee) itr1.next();
	    	   int empId=masEmployee.getId();
	    	   String empName="";
	    		if(masEmployee.getFirstName()!= null){
	    			empName=masEmployee.getFirstName();
	    		}
	    		if(masEmployee.getMiddleName()!= null){
	    			empName=empName+" "+masEmployee.getMiddleName();
	    		}
	    		if(masEmployee.getLastName()!= null){
	    			empName=empName+" "+masEmployee.getLastName();
	    		}

		%>
	<option value="<%=empId %>"><%=empName %></option>
	<%
	       }
		%>
</select>
<!-- <div class="titleBg">Surgical Test</div> -->
<div class="clear"></div>

<input type="button" class="buttonDel" value="" onclick="removeRow();"
	align="right" /> <input type="button" class="buttonAdd" value=""
	onclick="addRowForSurgery('<%=departmentId%>');" align="right" />

<div class="clear"></div>

<div class="tableHholder">

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">S.No</th>
		<th scope="col"><span>*</span>Surgery Name</th>
		<th scope="col">Surgery Code</th>
		<th scope="col">Rate</th>
	</tr>
	<tr>
		<td><input type="text" size="2" value="1" /></td>
		<td>
		<%int inc=1; %> <input type="text" value="" tabindex="1"
			id="chargeCodeName<%=inc%>" size="43" name="chargeCodeName1"
			onblur="if(validateSurgeryForAutoComplete1(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('opdSurgery','/hms/hms/opd?method=fillChargeCode&rowVal=1','chargeCodeVal');}" />
		<div id="ac2update2" style="display: none;" class="autocomplete"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">

			  new Ajax.Autocompleter('chargeCodeName1','ac2update2','ot?method=getInvestigationListForRequestionForIP&deptId=<%=departmentId%>',{parameters:'requiredField=chargeCodeName1'});
			</script></td>

		<td id="chargeCodeVal"><input type="text" name="chargeCode1"
			id="chargeCode1" size="10" /></td>
		<td id="rateVal"><input type="text" name="rate1"  id="rate1"
			size="8" readonly="readonly" tabindex="1"/></td>	
		<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	</tr>
</table>

<div class="clear"></div>

</div>

<div class="clear"></div>
<div class="division"></div>
<input name="Submit" type="button" align="right" class="button"
	value="Submit" onclick="if(validateSurgery()){submitForm('opdSurgery','opd?method=submitSurgeryRequisitionDetails');}" />
<input name="Back" type="button" src="images/phaseII/delete.gif"
				alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" align="right" />
<div class="clear"></div>
<div class="division"></div>

<%
treatmentTemplateList.clear();

%>