<%--
 * Copyright 2016 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * printApprovedEmpDetails.jsp  
 * Purpose of the JSP -  This is for Generate Approved Transfer Details.
 * @author  Kaushal Mishra 
 * Revision Date:      
 * Revision By: 
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script language="javascript">

function getBackPages()
{
	window.location = "/hms/hrms/training?method=showTransferApplicationApprovalJsp";
}
</script>
<script language="javascript">

function generateApprovedEmpDetails()
    {
	
	window.location = "/hms/hrms/training?method=generateApprovalReport";
    }
		
</script>
</head>
<body>

<input name="button"  type="button"	value="Print Approved Transfer Details" class="button"	onclick="generateApprovedEmpDetails();"  />
<input name="button"  type="button"	value="Back" class="button"	 onclick="getBackPages();"  />

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

</body>
