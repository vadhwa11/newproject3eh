<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.ExternalLabReport"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js?n=1"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<% 
Map<String, Object> map = new HashMap<String, Object>();
List <ExternalLabReport> externalLabList = new ArrayList<ExternalLabReport>();
if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		String message="";
		 if (map.get("message") != null)
	       {
	               message = (String) map.get("message");
	       }
  Boolean saved=false;
		 if (map.get("saved") != null)
	       {
	               saved = (Boolean) map.get("saved");
	       }
		 if (map.get("externalLabList") != null)
	       {
			 externalLabList = (List<ExternalLabReport>) map.get("externalLabList");
	       }
		 %>
<script>
/* jyotish */
	var count=0;
	function addRow(tableID) {
		count++;
		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.type = "checkbox";
		element1.name="chk"+count;
		cell1.appendChild(element1);
		
		var cell2 = row.insertCell(1);
		var element2 = document.createElement("input");
		element2.type = "text";
		element2.name = "testName"+count;
		cell2.appendChild(element2);

		var cell3 = row.insertCell(2);
		var element3 = document.createElement("input");
		element3.type = "text";
		element3.name = "testResult"+count;
		cell3.appendChild(element3);


	}
	
	
	function deleteRow(tableID) {
		try {
		var table = document.getElementById(tableID);
		var rowCount = table.rows.length;

		for(var i=0; i<rowCount; i++) {
			var row = table.rows[i];
			var chkbox = row.cells[0].childNodes[0];
			if(null != chkbox && true == chkbox.checked) {
				table.deleteRow(i);
				rowCount--;
				i--;
			}

			
		}
		}catch(e) {
			alert(e);
		}
	}
	
	function setCounter(tableID)
	{var table = document.getElementById(tableID);
	   var rowCount = table.rows.length;
		document.getElementById("count").value=parseInt(rowCount)-1;
	}
	
	

</script>
<%
if (map.get("message") != null){%>
<H3><%=message %></H3>
<%}%>

<form name="labTest" action="" method="post">
<div class="Block" >
<%if(externalLabList.size()>0) {%>
<table id="dataDisplayTable" width="350px" border="1">
	<tr>			
			<th width="5%">Test Name</th>
			<th width="13%">Test Result</th>						
	</tr>
	<%for(ExternalLabReport externalList:externalLabList) {%>
		<tr>
			
			<td><input type="text" name="testN" value="<%=externalList.getTestName()!=null?externalList.getTestName():"" %>"   readonly="readonly" /></td>
			<td> <input type="text" name="testR" value="<%=externalList.getTestResult()!=null?externalList.getTestResult():"" %>" readonly="readonly" /> </td>
		</tr>
		<%} %>
	</table>
<%}else{ %>
<H4>Data is Not Available</H4>
<%} %>
<div class="Block">
<div class="clear"></div>
<div class="paddingTop5"></div>

      <input type="hidden" name="<%=HIN_ID %>" value="<%=request.getParameter("hinId")%>">
		 <input type="hidden" name="<%=VISIT_ID %>" value="<%=request.getParameter("visitId") %>">
		  <input type="hidden" name="count" id="count">
	
	
    <!--  <input type="button" value="Add Row" onclick="addRow('dataTable')" />

	<input type="button" value="Delete Row" onclick="deleteRow('dataTable')" /> -->
	
	
	<div class="floatRight" style="width:130px;">
	<input type="button" class="buttonDel" value="" tabindex="1" onclick="deleteRow('dataTable')" />
	 
	<input type="button" class="buttonAdd" tabindex="1" onclick="addRow('dataTable')" value="" />
	</div>

	<table id="dataTable" width="350px" border="1">
	<tr>
			<th></th>
			<th width="5%">Test Name</th>
			<th width="13%">Test Result</th>
						
	</tr>
		<tr>
			<td><input type="checkbox" name="chk0" id="chk0"/></td>
			<td><input type="text" name="testName0" id="testName0"/></td>
			<td> <input type="text" name="testResult0" id="testResult0"/> </td>
		</tr>
	</table>

</div>		
<input name="" type="button" class="button" value="Save" onclick="setCounter('dataTable');submitForm('labTest','opd?method=saveOutSideResultEntryForAntenatal');"/>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

</div>
</form>
<script>
    if(<%=saved %>){
	       window.close();	   
	       }
</script>