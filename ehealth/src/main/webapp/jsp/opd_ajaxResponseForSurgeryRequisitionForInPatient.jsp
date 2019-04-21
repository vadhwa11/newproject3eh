<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.*"%>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<%Map<String,Object> map = new HashMap<String,Object>();
	if (request.getAttribute("map") != null) {
		map = (Map<String,Object>) request.getAttribute("map");
	
	}
	
	 List employeeList = new ArrayList();
	 if(map.get("employeeList") != null){
			employeeList=(List)map.get("employeeList");
			}
	int departmentId=0;
	 if(map.get("departmentId") != null){
		 departmentId=(Integer)map.get("departmentId");
			}
	%>

<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<div class="titleBig">Surgical Test</div>
<div class="clear"></div>


<input type="button" class="ButtonDel" alt="Delete" value=" "
	onclick="removeRow();" align="right" />
<input type="button" class="ButtonAdd" alt="Add" value=" "
	onclick="addRowForSurgery('<%=departmentId%>');" align="right" />

<div class="clear"></div>

<div class="tableHholder">

<table border="0" align="center" cellpadding="0" cellspacing="0"
	id="investigationGrid">
	<tr>
		<th scope="col">S.No</th>
		<th scope="col">Surgery Name</th>
		<th scope="col">Surgery Code</th>

	</tr>

	<tr>
		<td><input type="text" size="2" value="1" /></td>
		<td>
		<%int inc=1; %> <input type="text" value="" tabindex="1"
			id="chargeCodeName1" size="43" name="chargeCodeName1"
			onblur="if(validateSurgeryForAutoComplete(this.value,'<%=inc %>')){submitProtoAjaxWithDivName('inpatientSurgeryRequisition','/hms/hms/opd?method=fillChargeCode&rowVal=1','chargeCodeVal');}" />
		<div id="ac2update2"
			style="display: none; font-weight: normal; border: 1px solid black; padding-right: 10px; background-color: white;"></div>
		<script type="text/javascript" language="javascript" charset="utf-8">
			
			  new Ajax.Autocompleter('chargeCodeName1','ac2update2','opd?method=getChargeCodeListForAutoComplete&deptId=<%=departmentId%>',{parameters:'requiredField=chargeCodeName1'});
			</script></td>

		<td id="chargeCodeVal"><input type="text" name="chargeCode1"
			id="chargeCode1" size="10" /></td>
		<input type="hidden" value="1" name="hiddenValue" id="hiddenValue" />
	</tr>
</table>

<div class="clear"></div>

</div>

<div class="clear"></div>
<div class="division"></div>
<input name="Submit" type="button" align="right" class="button"
	value="Submit"
	onclick="submitForm('inpatientSurgeryRequisition','opd?method=submitSurgeryRequisitionDetailsForInpatient');" />

<div class="clear"></div>
<div class="division"></div>



<%

%>