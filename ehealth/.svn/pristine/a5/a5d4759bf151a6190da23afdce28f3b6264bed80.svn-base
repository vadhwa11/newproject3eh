<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="jkt.hms.masters.business.DgMasInvestigation"%>
<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="/hms/jsp/js/jquery-ui.css" />
<script type="text/javascript" src="/hms/jsp/js/jquery-1.8.2.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery-ui.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Map map = new HashMap();
List<DgMasInvestigation> testNonBloodBanklist = new ArrayList<DgMasInvestigation>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
if(map.get("testNonBloodBanklist") != null){
	testNonBloodBanklist=(List)map.get("testNonBloodBanklist");
}
String crossMatch = "";
if(request.getParameter("crossMatch") != null && !request.getParameter("crossMatch").equals("")) {
	crossMatch = request.getParameter("crossMatch").toString();
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test List</title>
</head>
<body >

<label>Test List</label>
<select name="ddlNames" id="ddlNames" >
  <c:forEach var="testlist" items="${requestScope.map.testNonBloodBanklist }">
    <option id="${testlist.id }" value="${testlist.id }">${testlist.investigationName }</option>
  </c:forEach> 
</select>

<br />
<br />
<% if(!crossMatch.equals("") && crossMatch.equals("Yes")) { %>
	<input type="button" value="Add Test"  class="button" onclick="SetTestName();" />
<% } else { %>
	<input type="button" value="Add Test"  class="button" onclick="SetName();" />
<% } %>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

<script type="text/javascript">
    function SetName() {
    	
        if (window.opener != null && !window.opener.closed) {
        	
            var txtName = window.opener.document.getElementById("txtName");
            
    		var table = window.opener.document.getElementById("testListID");
    	
        	var rowCount = table.rows.length;
        	var row = table.insertRow(rowCount);

        	var colCount = table.rows[0].cells.length;
        	
        	var invId = document.getElementById("ddlNames").value;
        	var chargeId = 0;
        	var mainChargecodeId = 0;
        	<%
        	for(DgMasInvestigation testBlood : testNonBloodBanklist) {%>
        		if(<%=testBlood.getId()%> == invId) {
        			chargeId = <%=testBlood.getChargeCode().getId() %>;
        			mainChargecodeId = <%=testBlood.getMainChargecode().getId() %>;
        		}
        	<%}
        	%>

        	for(var i=0; i<colCount; i++) {
 
            	var newcell = row.insertCell(i);

            	var es = document.getElementById("ddlNames");
            	/*var strUser = e.options[e.selectedIndex].text;
            	alert(strUser);
            	var strUserr = e.options[e.selectedIndex].value;
            	alert("hii");
            	alert(strUserr); */
            	//alert(newcell.childNodes);
            	/* switch(newcell.childNodes[0].type) {
                	case "text":
                    	newcell.childNodes[0].value = e.options[e.selectedIndex].text;
                        break;
                	case "checkbox":
                        newcell.childNodes[0].checked = true;
                        newcell.childNodes[0].checked=e.options[e.selectedIndex].value;
                        break;
               
            	} */
            	if(i == 0) {
            		newcell.innerHTML = es.options[es.selectedIndex].text;
            		var e = document.createElement("input");
            		e.class = "large";
            		e.type = "hidden";
            		e.name = document.getElementById("ddlNames").value;
            		e.value = es.options[es.selectedIndex].text;
            		newcell.appendChild(e);
	        	    
	        	    var e = document.createElement("input");
            		e.type = "hidden";
            		e.name = "chargeId";
            		e.value = chargeId;
            		newcell.appendChild(e);
            		var e = document.createElement("input");
            		e.type = "hidden";
            		e.name = "mainchargeId";
            		e.value = mainChargecodeId;
            		newcell.appendChild(e);
            	} else {
            		var e = document.createElement("input");
            		e.type = "checkbox";
            		e.name = "selectedTest";
            		e.value = document.getElementById("ddlNames").value;
            		e.checked = "checked";
            		newcell.appendChild(e);
            	} 
        	}
        }
		window.close();
    }
    
	function SetTestName() {
    	
        if (window.opener != null && !window.opener.closed) {
        	
    		var table = window.opener.document.getElementById("testListID");
    	
        	var rowCount = table.rows.length;
        	var row = table.insertRow(rowCount);

        	var colCount = table.rows[0].cells.length;
        	
        	for(var i=0; i<colCount; i++) {
 
            	var newcell = row.insertCell(i);

            	var es = document.getElementById("ddlNames");
            	if(i == 0) {
            		var e = document.createElement("input");
            		e.type = "text";
            		e.id = "investigationName";
            		e.name = "investigationName";
            		e.size = "50";
            		e.value = es.options[es.selectedIndex].text;
            		newcell.appendChild(e);
	        	    
	        	    var e = document.createElement("input");
            		e.type = "hidden";
            		e.id = "investigationName";
            		e.name = "crossInvestName";
            		e.size = "50";
            		e.value = document.getElementById("ddlNames").value;
            		newcell.appendChild(e);
            	} else {
            		var e = document.createElement("select");
            		e.name = "investigationNameResult";
            		e.options[0] = new Option("select", "");
            		e.options[1] = new Option("Reactive", "reactive");
            		e.options[2] = new Option('NonReactive', "Nonreactive");
            		newcell.appendChild(e);
            	} 
        	}
        }
		window.close();
    }
</script>

</body>
</html>