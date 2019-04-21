
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="java.net.URL"%>
<%@page import="jkt.hrms.masters.business.HrMasShift"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css"/>

<%
System.out.println("jsp");
Map<String,Object> map = new HashMap<String,Object>();
List<HrMasShift> hrMasShift = new ArrayList<HrMasShift>();
List<MasDepartment> masDepart = new ArrayList<MasDepartment>();
String row="";
if (request.getAttribute("map") != null) {
	map = (Map<String,Object>) request.getAttribute("map");

}

if (map.get("masDepart") != null) {
	masDepart = (List<MasDepartment>) map.get("masDepart");

}

if (map.get("hrMasShift") != null) {
	hrMasShift = (List<HrMasShift> ) map.get("hrMasShift");

}
if (map.get("row") != null) {
	row = (String ) map.get("row");

}
/* System.out.println("jhkjgjk>>>"+hrMasShift.size()); */
%>
<div id="testDiv<%=row%>">

<%
if(hrMasShift.size()>0){
	
for(HrMasShift hrms : hrMasShift){ %>

<lavel>
<%=hrms.getSession() %></lavel>




<select name="scheduleDept" id="scheduleDept" class="small" validate="Employee Category1,string,yes" >	
<option value="">Select</option>
	<%for(MasDepartment md : masDepart){ %>

	<option value="<%=md.getId() %>"><%=md.getDepartmentName()%>
	</option>
	<%}%>
</select>


<%}}else{ %>
<label>No Session </label>

<%} %>	
	
</div>