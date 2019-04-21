<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * messageForADT.jsp
 * Purpose of the JSP -  This is for ADT Message.
 * @author  Ramdular
 * Create Date: 07th Sep,2010
 * Revision Date:
 * Revision By:
 * @version 1.4
--%>

<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="java.util.Iterator"%>
<%@page import="jkt.hms.masters.business.Department"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>


<%
Map<String, Object> map = new HashMap<String, Object>();
List<MasDepartment> deptList = new ArrayList<MasDepartment>();

if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("deptList") != null){
	deptList = (List<MasDepartment>)map.get("deptList");
}
int deptId=0;

if (map.get("deptId") != null) {
deptId = (Integer) map.get("deptId");
}

String departmentName="";
if (map.get("deptName") != null) {
departmentName = (String) map.get("deptName");
}
%>

<div class="titleBg">
<h2><%=departmentName%></h2>
</div>
<form name="tokenForm" action="" method="post">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<div class="clear"></div>
<div class="Block">
<label>Department Name</label>
<select name="<%=DEPARTMENT_ID%>"  id="<%=DEPARTMENT_ID%>">
	<option value="0">Select</option>
	<%
						  Iterator iterator= deptList.iterator();
						  while(iterator.hasNext())
						  {
							MasDepartment masDepartment=(MasDepartment)iterator.next();
							int departmentId=masDepartment.getId();
							String deptName=masDepartment.getDepartmentName();
		 				%>
	<option value="<%=departmentId %>"><%=deptName %></option>
	<%
		 			 }
					%>
</select>
<div class="clear"></div>
<label>Start Number </label>
<input type="text" name="num1" id="num1" value="" maxlength="4"/>
<label>End Number </label>
<input type="text" name="num2" id="num2" value="" maxlength="4"/>
<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<input name="Submit" type="button" align="right" tabindex="1"
	class="button" value="OK"
	onclick="if(validateFieldValues()){submitForm('tokenForm','opd?method=getTokenNumber');}" />
<input name="Reset" type="reset" align="right" class="buttonHighlight"
	value="Reset" />
<div class="clear"></div>
<div class="division"></div>
<script type="text/javascript" language="javascript">
function validateFieldValues()
{
		var departmentId=document.getElementById("departmentId").value
		var num1=document.getElementById("num1").value
		var num2=document.getElementById("num2").value

		if(departmentId=='0')
		{
			alert("Please Select a Department Name !!!");
			document.getElementById("departmentId").focus();
			return false;
	     }
	     if(num1=='')
	     {
	    	 alert("Please Enter The Start Number !!!");
	    	 document.getElementById("num1").focus();
			 return false;
	    }
		 if(isNaN(parseInt(document.getElementById("num1").value)))
		 {
			 alert("Please Enter The Start Number only Numeric  !!!");
	    	 document.getElementById("num1").focus();
			 return false;
	     }
	     if(num2=='')
	     {
	    	 alert("Please Enter The End Number !!!");
	    	 document.getElementById("num2").focus();
			 return false;
	    }
		if(isNaN(parseInt(document.getElementById("num2").value)))
		 {
			 alert("Please Enter The End Number only Numeric  !!!");
	    	 document.getElementById("num2").focus();
			 return false;
	     }
	     if(parseInt(document.getElementById("num1").value)>parseInt(document.getElementById("num2").value))
	     {
           alert('End Number Should be Greater than Start Number !!!');
           return false;
		 }
	   else
	    {
	 		 return true;
	    }
}
	</script>
</form>