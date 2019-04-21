<%@page import="jkt.hms.masters.business.BloodStockDetail"%>
<%@page import="jkt.hms.masters.business.MasSpecialityDeptGroupValue"%>
<%@page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="jkt.hms.masters.business.OpdTemplateTreatment"%>


<script
	src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<form name="popPresentComp" method="post" action="">
	<%
	Map map = new HashMap();
	Map<String,Object> utilMap = new HashMap<String,Object>();
	List<MasSpecialityDeptGroupValue> masValue=new ArrayList<MasSpecialityDeptGroupValue>();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	if(map.get("masValue") != null){
		masValue=(List<MasSpecialityDeptGroupValue>)map.get("masValue");
	}
%>
	<h2>Values</h2>

	<%int departmentTempId = 0;
	if(masValue.size() == 0){
	%>
	<h4>
		<span>No Record Found</span>
	</h4>
	<%
		}else{

			
	%>
	<div class="smallWithHeight">
		<table colspan="7" id="componentDetails" cellpadding="0"
			cellspacing="0">

			<thead>
				<tr>
					<th scope="col"><input type="checkbox" name="checkall"
						class="radioCheck" value="Collected All" id="addbutton"
						onclick="CheckAll(this);" align="right" /></th>
					<th scope="col">Values</th>
				</tr>
			</thead>
			<tbody>
				<%
		int i=0; 
	for(MasSpecialityDeptGroupValue value :masValue){
		departmentTempId=value.getDeptGroup().getId();
 %>
				<%
		
	 String valueName="";
		if(value.getValue() !=null ){
			valueName=value.getValue();		 
 %>
				<tr>
					<td><input id="checkId<%=i %>" name="checkedTemp"
						type="checkbox" class="radioCheck" value="n" /> <input
						type="hidden" name="rowLength" id="rowLength" value="" /></td>

					<td>
					<input type="hidden" name="presentComplainId" value="<%=value.getId() %>" id="presentComplainId<%=i %>">
					<input type="text" value="<%= valueName%>"
						name="presentComplain" id="presentComplain<%=i %>" size="40" />
												
						</td>
				</tr>
				<%i++;
    %>
				<%}%>


			</tbody> 

	<% }	%>
	<input type="hidden" value="<%=i %>" name="rowVal" id="rowVal" />
	</table>
	</div>
	<%} %>
	<input name="" type="button" class="button" value="OK"
		onclick="setPresentComplaintTempalte('<%=departmentTempId%>');window.close();" /> <input
		name="" type="button" class="button" value="Close"
		onclick="cancelForm();" />
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</form>
<script>
	function cancelForm() {
		window.close();
	}

	function setPresentComplaintTempalte(value) {
		var preComp = "";
		var preCompId = "";
		var checkId;
		var rowVal = document.getElementById('rowVal').value;
		for (i = 0; i < rowVal; i++) {
			checkId = document.getElementById('checkId' + i);
			if (checkId.checked == true) {
				preComp += document.getElementById('presentComplain' + i).value+ "\n"
				preCompId += document.getElementById('presentComplainId' + i).value+ ","
			}

		}
		window.opener.document.getElementById('presentComplain' + value).value = preComp;
		window.opener.document.getElementById('presentComplainId' + value).value = preCompId;
		window.opener.document.getElementById('presentComplain' + value)
				.focus();
		window.close();
	}
	function CheckAll(chk) {
		var rowLength = document.getElementById('rowLength').value;
		for (var i = 0; i < document.popPresentComp.elements.length; i++) {
			var e = document.popPresentComp.elements[i];

			if (e.type == "checkbox") {
				e.checked = chk.checked;
				for (var j = 0; j < rowLength; j++) {
					document.getElementById('checkId' + j).value = "y";
				}
			}
		}
	}
</script>