<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasBranch"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>

<%@page import="java.math.BigDecimal"%><link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />

<%
	Map<String, Object> map = new HashMap<String, Object>();
	List<MasBranch> branchList = new ArrayList<MasBranch>();
	if (request.getAttribute("map") != null) {
		map = (Map<String, Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");
	String time = (String)utilMap.get("currentTime");
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	if(map.get("branchList") != null){
		branchList = (List<MasBranch>)map.get("branchList");
	}
BigDecimal openingBalanceId = new BigDecimal(0.00);

		%>

<form name="accountMaster" method="post" action="">
<label>GL Balance-:</label>
<label><input type="text" id="opBalanceId" name="<%=OP_BALANCE_DR %>" value="<%=openingBalanceId %>" 	 /></label>
<div class="clear"></div>
<table width="100%" border="0"  cellspacing="0" cellpadding="0" class="small" >
	<tr>
		<th scope="col">Select</th>
		<th scope="col">Branch</th>
		<th scope="col">Dr Amount</th>
		<th scope="col">Cr Amount</th>


	</tr>
	<tbody>
<%
int i = 1;

%>
		<tr>
		<%
		int branchId = 0;
		String branchdesc = "";
		if(branchList.size()>0){
			for(MasBranch masBranch :branchList){
				branchId = masBranch.getId();
				branchdesc = masBranch.getBranchDesc();

			%>
		<td><input type="checkbox" id="branchCheckBoxId<%=i%>" name="branchCheckBoxId<%=i%>" value="" 	 /></td>


		<td><%=branchdesc%><input type="hidden" id="branchId<%=i%>" name="branchId<%=i%>" value="<%=branchId %>" 	 /> </td>


		<td><input type="text" id="opBalanceDrId<%=i%>" name="opBalanceDr<%=i%>" value="" 	 /></td>
		<td><input type="text" id="opBalanceCrId<%=i%>" name="opBalanceCr<%=i %>" value="" 	 /></td>


		</tr>
<%i++;}} %>
	</tbody>
</table>
<input type="hidden" id="counterId" name="counter" value="<%=i %>" 	 />
<script>
function getParentValueInChild()
	{
	document.getElementById("opBalanceId").value=	window.opener.document.getElementById("openingBalanceId").value ;

	}

getParentValueInChild();




function setBranchDetailsInParent(){
	var tbl = window.opener.document.getElementById('branchDetails');
	var cnt = 0;
	if(document.getElementById('counterId') != null){
	for(var index = 1; index < parseInt(document.getElementById('counterId').value); index++ ){
			var branchCheckBoxId = eval(document.getElementById('branchCheckBoxId'+index));
				cnt = window.opener.document.getElementById('totalBranchId').value

			if(branchCheckBoxId.checked)
			{
				var branchId = document.getElementById('branchId'+index).value;
				var opBalanceDr = document.getElementById('opBalanceDrId'+index).value;
				var opBalanceCr = document.getElementById('opBalanceCrId'+index).value;
				var lastRow = tbl.rows.length;
				var row = tbl.insertRow(lastRow);

				var iteration = parseInt(cnt);
				var cell1 = row.insertCell(0);
				var e1 = window.opener.document.createElement('input');
				e1.type = 'text';
				e1.name = 'branchId' + (iteration+1);
				e1.id = 'branchId' + (iteration+1);
				cell1.appendChild(e1);
				e1.value = branchId;


				var cell2 = row.insertCell(1);
				var e2 = window.opener.document.createElement('input');
				e2.type = 'text';
				e2.name = 'opBalanceDr' + (iteration+1);
				e2.id = 'opBalanceDrId' + (iteration+1);
				e2.value = opBalanceDr;
				cell2.appendChild(e2);

				var cell3 = row.insertCell(2);
				var e3 = window.opener.document.createElement('input');
				e3.type = 'text';
				e3.name = 'opBalanceCr' + (iteration+1);
				e3.id = 'opBalanceCrId' + (iteration+1);
				e3.value = opBalanceCr;
				cell3.appendChild(e3);

			}

	window.opener.document.getElementById('totalBranchId').value = parseInt(cnt)+1;
		}
	}

}




function validateCheckBox(){
	for(var i = 1; i < document.getElementById('counterId').value; i++){
	  if(document.getElementById('branchCheckBoxId'+i).checked == true)
      {
		return true;
	  }
	}
	alert("Please select At least One Record")
return false;

}
</script>
<div class="clear"></div>
<input type="button" name="Submit11" id="addbutton" value="Submit" class="button" onClick="setBranchDetailsInParent()validateCheckBox();" accesskey="a" tabindex=1 />
<input type="button" name="Submit11" id="addbutton" value="Close" class="button" onClick="window.close()" accesskey="a" tabindex=1 />


<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
