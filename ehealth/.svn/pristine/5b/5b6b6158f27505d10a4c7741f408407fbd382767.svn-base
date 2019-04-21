<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.DgOrderdt"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Investigation</title>
<link href="/hms/jsp/css/--style.css?n=1" rel="stylesheet" type="text/css" />
<style>
body {font-family: arial, tahoma;}

.reportMainDiv {width: 1024px;
height: auto;
background: #fff;
margin:0 auto;

}

label.mainlbl {
	font-weight: bold;
	font-size: 18px;
	height:24px;
	line-height:25px;
	color: #010101;
	width: 170px;
	float: left;
	text-align: left;
	padding:0px 0px 0px 5px;
	margin:0px 5px 5px 5px;
	}



label.value {
	font-size: 18px;
	font-weight:normal;
	color: #010101;
	width: 190px;
	height: 23px;
	float: left;
	text-align: left;
	padding: 2px 5px 0px 3px;
	margin: 0px 0px 0px 0px;
}

label.auto {
	font-weight: bold;
	font-size: 12px;	
	width: auto;
	height:19px;
	float: left;
	text-align: left;
	padding: 5px 5px 0px 5px;
	margin: 0px 4px 0px 4px;
}
.clear, .Clear{
	clear: both;
	overflow: hidden;
	padding: 0px;
	margin: 0px;
	height: 1px;
}

.headerDiv
{
background: #aaa;
 width:100%; 
float:left;
}

table {border-collapse:collapse; width:100%;}
table th{border:solid 1px #000; text-align: left;}
table td{ border:solid 1px #000; text-align: left;}

@page {
    size: auto;   /* auto is the initial value */
    margin-top: 0;  /* this affects the margin in the printer settings */
    margin-bottom: 0;
}

</style>
<%
Map<String,Object> map = new HashMap<String,Object>();
if (request.getAttribute("map") != null) {
	map = (Map)request.getAttribute("map");

}
List<DgOrderdt> inv= new ArrayList<DgOrderdt>();
if (map.get("piList") != null) {
	inv = (List)map.get("piList");
}
String uhid =null;
String age = "";
int visitNo=0;
String department=null;
String name=null;
for(DgOrderdt dgOrderdt:inv){
	Patient p = dgOrderdt.getOrderhd().getHin();
	uhid = p.getHinNo();
	age= p.getAge();
	name=p.getFullName();

if(dgOrderdt.getOrderhd().getDepartment()!=null)
	department=dgOrderdt.getOrderhd().getDepartment().getDepartmentName();
	 visitNo = dgOrderdt.getOrderhd().getVisit().getVisitNo(); 
}
%>
</head>
<body>
<%if(inv.size()>0){%>
<h2 style="text-align:center;font-size:36px;">EHEALTH KERALA</h2>
<div class="reportMainDiv">
<div class="headerDiv">
<label class="mainlbl">UHID</label><label class="auto">:</label> <label class="value"><%=uhid%></label>
<label class="auto">&nbsp; &nbsp; &nbsp; &nbsp;</label>

<label class="mainlbl">Patient Name</label><label class="auto">:</label> <label class="value"><%=name%></label>
<div class="clear"></div> 
<label class="mainlbl">Age</label><label class="auto">:</label> <label class="value"><%=age%></label>
<label class="auto">&nbsp; &nbsp; &nbsp; &nbsp;</label>

<label class="mainlbl">Visit no</label><label class="auto">:</label> <label class="value"><%=visitNo %></label>
<div class="clear"></div> 
<label class="mainlbl">Department</label><label class="auto">:</label> <label class="value"><%=department%></label>
<label class="auto">&nbsp; &nbsp; &nbsp; &nbsp;</label>
<div class="clear"></div> 
<div class="clear"></div> 
</div>

	
	<table cellpadding="10" cellspacing="0" style="text-align: left;"  >
	<tr><th>Test Code</th>
	<th>Test Description</th>
	</tr>
	 <%for(DgOrderdt DgOrderdt:inv){
	%>
		<tr><td><%=DgOrderdt.getChargeCode().getChargeCodeCode()%></td>
		<td><%=DgOrderdt.getChargeCode().getChargeCodeName()%></td>
	
	<%}%>
	 </table>
<% } else{%>
<h2 style="text-align:center;font-size:36px;">No Data Found</h2>
<%} %>

</div>
</body>
</html>


